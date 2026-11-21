package top.niunaijun.blackbox.core.system.permission;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Pure-Java storage for per-user / per-package / per-permission modes.
 * No Android dependencies, so it can be unit-tested on the JVM.
 *
 * File format (UTF-8, one record per line, safe to edit by hand):
 *   # comment
 *   global|<mode>
 *   rule|<userId>|<package>|<permission>|<mode>
 * Writes go to "<file>.tmp" first and are then renamed, so a crash never leaves a half file.
 */
public class PermissionStore {
    public static final int MODE_DEFAULT = 0;
    public static final int MODE_ALLOW = 1;
    public static final int MODE_ASK = 2;
    public static final int MODE_DENY = 3;

    /** Permission name that means "default for the whole package". */
    public static final String PACKAGE_DEFAULT = "*";

    private final File mFile;
    // key = userId + "|" + package  ->  (permission -> mode)
    private final Map<String, Map<String, Integer>> mRules = new HashMap<>();
    private int mGlobalDefault = MODE_ALLOW; // old behaviour: everything granted
    private int mVersion = 0;

    public PermissionStore(File file) {
        mFile = file;
    }

    public static boolean isValidMode(int mode) {
        return mode >= MODE_DEFAULT && mode <= MODE_DENY;
    }

    private static String key(int userId, String pkg) {
        return userId + "|" + pkg;
    }

    public synchronized int getVersion() {
        return mVersion;
    }

    public synchronized int getGlobalDefault() {
        return mGlobalDefault;
    }

    /** Only ALLOW / ASK / DENY make sense as a global default. Returns false if rejected. */
    public synchronized boolean setGlobalDefault(int mode) {
        if (mode < MODE_ALLOW || mode > MODE_DENY) return false;
        if (mGlobalDefault == mode) return true;
        mGlobalDefault = mode;
        mVersion++;
        save();
        return true;
    }

    public synchronized int getRawMode(int userId, String pkg, String permission) {
        Map<String, Integer> m = mRules.get(key(userId, pkg));
        if (m == null) return MODE_DEFAULT;
        Integer v = m.get(permission);
        return v == null ? MODE_DEFAULT : v;
    }

    public synchronized int getMode(int userId, String pkg, String permission) {
        Map<String, Integer> m = mRules.get(key(userId, pkg));
        if (m != null) {
            Integer v = m.get(permission);
            if (v != null && v != MODE_DEFAULT) return v;
            v = m.get(PACKAGE_DEFAULT);
            if (v != null && v != MODE_DEFAULT) return v;
        }
        return mGlobalDefault;
    }

    public synchronized boolean setMode(int userId, String pkg, String permission, int mode) {
        if (pkg == null || permission == null || pkg.isEmpty() || permission.isEmpty()) return false;
        if (!isValidMode(mode)) return false;
        if (hasBadChar(pkg) || hasBadChar(permission)) return false;
        String k = key(userId, pkg);
        Map<String, Integer> m = mRules.get(k);
        boolean changed;
        if (mode == MODE_DEFAULT) {
            if (m == null) return true;
            changed = m.remove(permission) != null;
            if (m.isEmpty()) mRules.remove(k);
        } else {
            if (m == null) {
                m = new HashMap<>();
                mRules.put(k, m);
            }
            Integer old = m.put(permission, mode);
            changed = old == null || old != mode;
        }
        if (changed) {
            mVersion++;
            save();
        }
        return true;
    }

    public synchronized Map<String, Integer> getModes(int userId, String pkg) {
        Map<String, Integer> m = mRules.get(key(userId, pkg));
        return m == null ? new HashMap<String, Integer>() : new HashMap<>(m);
    }

    public synchronized void clearPackage(int userId, String pkg) {
        if (mRules.remove(key(userId, pkg)) != null) {
            mVersion++;
            save();
        }
    }

    public synchronized void clearUser(int userId) {
        String prefix = userId + "|";
        boolean changed = mRules.keySet().removeIf(k -> k.startsWith(prefix));
        if (changed) {
            mVersion++;
            save();
        }
    }

    /** User ids that have stored rules for this package. */
    public synchronized java.util.List<Integer> getUserIds(String pkg) {
        java.util.List<Integer> ids = new java.util.ArrayList<>();
        String suffix = "|" + pkg;
        for (String k : mRules.keySet()) {
            if (k.endsWith(suffix)) {
                try {
                    ids.add(Integer.parseInt(k.substring(0, k.length() - suffix.length())));
                } catch (NumberFormatException ignored) {
                }
            }
        }
        return ids;
    }

    /** Removes every rule and puts the global default back to ALLOW. */
    public synchronized void clearAll() {
        mRules.clear();
        mGlobalDefault = MODE_ALLOW;
        mVersion++;
        save();
    }

    private static boolean hasBadChar(String s) {
        return s.indexOf('|') >= 0 || s.indexOf('\n') >= 0 || s.indexOf('\r') >= 0;
    }

    public synchronized void load() {
        mRules.clear();
        mGlobalDefault = MODE_ALLOW;
        if (!mFile.exists()) return;
        try (BufferedReader r = new BufferedReader(
                new InputStreamReader(new FileInputStream(mFile), StandardCharsets.UTF_8))) {
            String line;
            while ((line = r.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                String[] p = line.split("\\|", -1);
                try {
                    if (p[0].equals("global") && p.length == 2) {
                        int m = Integer.parseInt(p[1]);
                        if (m >= MODE_ALLOW && m <= MODE_DENY) mGlobalDefault = m;
                    } else if (p[0].equals("rule") && p.length == 5) {
                        int uid = Integer.parseInt(p[1]);
                        int m = Integer.parseInt(p[4]);
                        if (m > MODE_DEFAULT && m <= MODE_DENY && !p[2].isEmpty() && !p[3].isEmpty()) {
                            String k = key(uid, p[2]);
                            Map<String, Integer> map = mRules.get(k);
                            if (map == null) {
                                map = new HashMap<>();
                                mRules.put(k, map);
                            }
                            map.put(p[3], m);
                        }
                    }
                } catch (NumberFormatException ignored) {
                    // skip a bad line, keep the rest
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void save() {
        File parent = mFile.getParentFile();
        if (parent != null && !parent.exists()) parent.mkdirs();
        File tmp = new File(mFile.getPath() + ".tmp");
        try {
            FileOutputStream fos = new FileOutputStream(tmp);
            try (Writer w = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {
                w.write("# BlackBox per-app permission modes: 1=allow 2=ask 3=deny\n");
                w.write("global|" + mGlobalDefault + "\n");
                // sorted so the file is stable and easy to diff
                for (Map.Entry<String, Map<String, Integer>> e : new TreeMap<>(mRules).entrySet()) {
                    int bar = e.getKey().indexOf('|');
                    String uid = e.getKey().substring(0, bar);
                    String pkg = e.getKey().substring(bar + 1);
                    for (Map.Entry<String, Integer> pe : new TreeMap<>(e.getValue()).entrySet()) {
                        w.write("rule|" + uid + "|" + pkg + "|" + pe.getKey() + "|" + pe.getValue() + "\n");
                    }
                }
                w.flush();
                fos.getFD().sync();
            }
            if (!tmp.renameTo(mFile)) {
                // some filesystems refuse to rename over an existing file
                mFile.delete();
                if (!tmp.renameTo(mFile)) {
                    throw new IOException("rename failed: " + tmp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            tmp.delete();
        }
    }
}
