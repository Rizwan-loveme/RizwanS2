package ohi.andre.consolelauncher.commands.main.raw;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

import ohi.andre.consolelauncher.R;
import ohi.andre.consolelauncher.TuiHost;
import ohi.andre.consolelauncher.commands.CommandAbstraction;
import ohi.andre.consolelauncher.commands.ExecutePack;
import ohi.andre.consolelauncher.commands.main.MainPack;
import ohi.andre.consolelauncher.commands.main.specific.ParamCommand;
import ohi.andre.consolelauncher.managers.AppsManager;
import ohi.andre.consolelauncher.tuils.Tuils;

/**
 * Win11 addition (step 11), not part of upstream T-UI: the pinned apps of the Win11 launcher (Start menu > Pinned) seen from the terminal. Same list, same order:
 * `pinned -ls` shows it, `pinned -open [n]` opens the n-th one, `pinned -add [appName]` / `pinned -rm [appName]` change it (the Start menu shows the change the next time it
 * reloads its apps). Pinned built-in apps (Files, Gallery, ...) are in the list too; hidden apps are not (like in the Start menu). Written like upstream's `apps`
 * (ParamCommand with an enum of params). Everything goes through TuiHost.Share; without a host the list is empty.
 */
public class pinned extends ParamCommand {

    private static class Entry {
        final String key;
        final String label;
        final AppsManager.LaunchInfo app;     // null for a built-in app
        final String builtInName;             // null for a normal app

        Entry(String key, String label, AppsManager.LaunchInfo app, String builtInName) {
            this.key = key;
            this.label = label;
            this.app = app;
            this.builtInName = builtInName;
        }
    }

    /** The pinned list of the launcher, resolved: normal apps through AppsManager (an app that is not installed any more is skipped), built-in apps through the host. */
    private static List<Entry> entries(MainPack pack) {
        List<Entry> out = new ArrayList<>();
        TuiHost.Share share = TuiHost.getShare();
        if (share == null) return out;
        List<String[]> builtIns = share.builtIns();
        for (String key : share.pinnedKeys()) {
            String[] b = null;
            for (String[] x : builtIns) {
                if (x[2].equals(key)) { b = x; break; }
            }
            if (b != null) {
                out.add(new Entry(key, b[1], null, b[0]));
                continue;
            }
            AppsManager.LaunchInfo info = pack.appsManager.findLaunchInfoWithKey(key);
            if (info != null) out.add(new Entry(key, info.publicLabel, info, null));
        }
        return out;
    }

    private static String list(MainPack pack) {
        if (TuiHost.getShare() == null) return pack.context.getString(R.string.tui_builtin_unavailable);
        List<Entry> es = entries(pack);
        if (es.isEmpty()) return pack.context.getString(R.string.tui_pinned_empty);
        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < es.size(); c++) {
            if (c > 0) sb.append(Tuils.NEWLINE);
            sb.append(c + 1).append(Tuils.SPACE).append(es.get(c).label);
        }
        return sb.toString();
    }

    private enum Param implements ohi.andre.consolelauncher.commands.main.Param {

        ls {
            @Override
            public int[] args() {
                return new int[0];
            }

            @Override
            public String exec(ExecutePack pack) {
                return list((MainPack) pack);
            }
        },
        open {
            @Override
            public int[] args() {
                return new int[] {CommandAbstraction.INT};
            }

            @Override
            public String exec(ExecutePack pack) {
                int n = pack.getInt();
                MainPack mp = (MainPack) pack;
                List<Entry> es = entries(mp);
                if (n < 1 || n > es.size()) return pack.context.getString(R.string.tui_pinned_nonumber) + Tuils.SPACE + n;
                Entry e = es.get(n - 1);
                if (e.app != null) {
                    pack.context.startActivity(mp.appsManager.getIntent(e.app));
                    return null;
                }
                if (pack.context instanceof Activity && TuiHost.openBuiltIn((Activity) pack.context, e.builtInName)) return null;
                return pack.context.getString(R.string.tui_builtin_unavailable);
            }

            @Override
            public String onNotArgEnough(ExecutePack pack, int n) {
                return pack.context.getString(R.string.tui_pinned_nonumber);
            }

            @Override
            public String onArgNotFound(ExecutePack pack, int index) {
                return pack.context.getString(R.string.tui_invalid_integer);
            }
        },
        add {
            @Override
            public int[] args() {
                return new int[] {CommandAbstraction.VISIBLE_PACKAGE};
            }

            @Override
            public String exec(ExecutePack pack) {
                TuiHost.Share share = TuiHost.getShare();
                if (share == null) return pack.context.getString(R.string.tui_builtin_unavailable);
                AppsManager.LaunchInfo i = pack.getLaunchInfo();
                share.setPinned(AppsManager.keyOf(i), true);
                return i.publicLabel;
            }
        },
        rm {
            @Override
            public int[] args() {
                return new int[] {CommandAbstraction.PLAIN_TEXT};
            }

            @Override
            public String exec(ExecutePack pack) {
                TuiHost.Share share = TuiHost.getShare();
                if (share == null) return pack.context.getString(R.string.tui_builtin_unavailable);
                String name = Tuils.removeSpaces(pack.getString()).toLowerCase();
                for (Entry e : entries((MainPack) pack)) {
                    if (Tuils.removeSpaces(e.label).toLowerCase().equals(name)) {
                        share.setPinned(e.key, false);
                        return e.label;
                    }
                }
                return pack.context.getString(R.string.tui_output_appnotfound);
            }
        };

        static Param get(String p) {
            p = p.toLowerCase();
            Param[] ps = values();
            for (Param p1 : ps)
                if (p.endsWith(p1.label()))
                    return p1;
            return null;
        }

        static String[] labels() {
            Param[] ps = values();
            String[] ss = new String[ps.length];

            for (int count = 0; count < ps.length; count++) {
                ss[count] = ps[count].label();
            }

            return ss;
        }

        @Override
        public String label() {
            return Tuils.MINUS + name();
        }

        @Override
        public String onNotArgEnough(ExecutePack pack, int n) {
            return pack.context.getString(R.string.tui_help_pinned);
        }

        @Override
        public String onArgNotFound(ExecutePack pack, int index) {
            return pack.context.getString(R.string.tui_output_appnotfound);
        }
    }

    @Override
    protected ohi.andre.consolelauncher.commands.main.Param paramForString(MainPack pack, String param) {
        return Param.get(param);
    }

    @Override
    protected String doThings(ExecutePack pack) {
        return null;
    }

    @Override
    public int helpRes() {
        return R.string.tui_help_pinned;
    }

    @Override
    public int priority() {
        return 4;
    }

    @Override
    public String[] params() {
        return Param.labels();
    }
}
