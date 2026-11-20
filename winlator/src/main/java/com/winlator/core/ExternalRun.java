package com.winlator.core;

import android.content.Context;
import android.content.Intent;

import com.winlator.XServerDisplayActivity;
import com.winlator.container.Container;
import com.winlator.container.Drive;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Win11 File Manager -> Winlator: run a Windows file that lives anywhere on the phone.
 *
 * XServerDisplayActivity turns "exec_path" into a DOS path with WineUtils.unixToDOSPath(), which
 * only works for files below one of the container's drives (D: = Download, E: = app storage by
 * default) or below drive C:. A file in another folder would start with an empty path. So before
 * the activity is started, the storage the file lives on is added to the container as a new
 * drive letter (F:, G:, ... the first free one): /storage/emulated/N or /storage/XXXX-XXXX (SD
 * card), otherwise the folder of the file. The drive is kept in the container (it shows up in the
 * container's Drives list and can be removed there). dosdevices symlinks are rebuilt at every
 * launch (XServerDisplayActivity.setupWineSystemFiles), so the new drive is used at once.
 */
public abstract class ExternalRun {
    /** Extra of XServerDisplayActivity: started from Win11, so leaving Winlator must not restart Winlator's own home screen. */
    public static final String EXTRA_FROM_WIN11 = "from_win11";

    private static final Pattern STORAGE_ROOT = Pattern.compile("^(/storage/emulated/\\d+|/storage/(?!self|emulated)[^/]+)(/.*)?$");

    /** Same file, one spelling: /sdcard/x and /storage/self/primary/x become /storage/emulated/0/x. */
    public static String normalize(String path) {
        if (path == null) return "";
        String p = path;
        if (p.equals("/sdcard") || p.startsWith("/sdcard/")) p = "/storage/emulated/0"+p.substring(7);
        else if (p.equals("/storage/self/primary") || p.startsWith("/storage/self/primary/")) p = "/storage/emulated/0"+p.substring(21);
        return p;
    }

    private static boolean isUnder(String path, String dir) {
        if (dir == null || dir.isEmpty()) return false;
        dir = StringUtils.removeEndSlash(dir);
        return path.equals(dir) || path.startsWith(dir+"/");
    }

    /** The folder that becomes the drive: the storage volume if the file is on one, else its own folder. */
    static String mountFor(String path) {
        Matcher matcher = STORAGE_ROOT.matcher(path);
        if (matcher.matches()) return matcher.group(1);
        String parent = new File(path).getParent();
        return parent != null ? parent : "/";
    }

    /**
     * Makes sure the container can reach the file. Returns the (normalized) path to give to
     * XServerDisplayActivity as "exec_path", or null when no drive letter is free.
     */
    public static String ensureDrive(Container container, String path) {
        String p = normalize(path);
        if (p.contains("/.wine/drive_c")) return p;

        StringBuilder used = new StringBuilder();
        int count = 0;
        for (Drive drive : container.drivesIterator()) {
            if (isUnder(p, drive.path)) return p;
            used.append(drive.letter.toUpperCase());
            count++;
        }
        if (count >= Container.MAX_DRIVE_LETTERS) return null;

        return addDrive(container, used.toString(), mountFor(p)) ? p : null;
    }

    /** Adds [mountPath] as the first free drive letter from F: to W:. False when no letter is free. */
    private static boolean addDrive(Container container, String usedLetters, String mountPath) {
        for (char letter = 'F'; letter <= 'W'; letter++) {
            if (usedLetters.indexOf(String.valueOf(letter)) == -1) {
                container.setDrives(container.getDrives()+letter+":"+mountPath);
                container.saveData();
                return true;
            }
        }
        return false;
    }

    /**
     * Part 7: makes sure the whole phone storage (the folders the Win11 File Manager shows: Documents,
     * Pictures, Music, Download, ...) is a drive of the container, so Windows programs can open and save
     * there with their normal Open / Save dialogs. New containers already have it as F:
     * (Container.DEFAULT_DRIVES); containers made before part 7 get the first free letter from F:.
     * Does nothing when it is there already or all 8 drive letters are used. Returns true if it was added.
     */
    public static boolean ensureSharedDrive(Container container) {
        String root = StringUtils.removeEndSlash(normalize(AppUtils.PHONE_STORAGE));
        StringBuilder used = new StringBuilder();
        int count = 0;
        for (Drive drive : container.drivesIterator()) {
            if (StringUtils.removeEndSlash(normalize(drive.path)).equals(root)) return false;
            used.append(drive.letter.toUpperCase());
            count++;
        }
        if (count >= Container.MAX_DRIVE_LETTERS) return false;
        return addDrive(container, used.toString(), root);
    }

    public static Intent buildRunIntent(Context context, int containerId, String execPath) {
        Intent intent = new Intent(context, XServerDisplayActivity.class);
        intent.putExtra("container_id", containerId);
        intent.putExtra("exec_path", execPath);
        intent.putExtra(EXTRA_FROM_WIN11, true);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }
}
