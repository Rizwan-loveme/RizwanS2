package top.niunaijun.blackbox.entity.pm;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;


public class InstallOption implements Parcelable {
    public static final int FLAG_SYSTEM = 1;
    public static final int FLAG_STORAGE = 1 << 1;

    public static final int FLAG_URI_FILE = 1 << 3;

    /**
     * The app comes as a bundle (base APK + split APKs). The split file paths are in
     * {@link #splitPaths}. The base APK path is still passed as the normal "file" argument.
     */
    public static final int FLAG_SPLIT = 1 << 4;

    public int flags = 0;

    /**
     * Absolute paths of the split APKs that belong to the base APK.
     * Only used (and only sent through Parcel) when {@link #FLAG_SPLIT} is set.
     */
    public List<String> splitPaths = new ArrayList<>();

    public static InstallOption installBySystem() {
        InstallOption installOption = new InstallOption();
        installOption.flags = installOption.flags | FLAG_SYSTEM;
        return installOption;
    }

    public static InstallOption installByStorage() {
        InstallOption installOption = new InstallOption();
        installOption.flags = installOption.flags | FLAG_STORAGE;
        return installOption;
    }

    /**
     * Install option for a bundle that was already unpacked to storage.
     */
    public static InstallOption installByStorageWithSplits(List<String> splitPaths) {
        return installByStorage().withSplits(splitPaths);
    }


    public InstallOption makeUriFile() {
        this.flags |= FLAG_URI_FILE;
        return this;
    }

    /**
     * Sets {@link #FLAG_SPLIT} and stores the split paths. An empty or null list clears the flag.
     */
    public InstallOption withSplits(List<String> paths) {
        this.splitPaths = new ArrayList<>();
        if (paths != null) {
            for (String path : paths) {
                if (path != null && !path.isEmpty()) {
                    this.splitPaths.add(path);
                }
            }
        }
        if (this.splitPaths.isEmpty()) {
            this.flags &= ~FLAG_SPLIT;
        } else {
            this.flags |= FLAG_SPLIT;
        }
        return this;
    }

    public boolean isFlag(int flag) {
        return (flags & flag) != 0;
    }

    /**
     * @return true when this install has split APKs to handle.
     */
    public boolean hasSplits() {
        return isFlag(FLAG_SPLIT) && splitPaths != null && !splitPaths.isEmpty();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // Keep the old layout for non-split installs. InstallOption is nested inside
        // BPackageSettings, which is saved to package.conf, so apps that were installed
        // before FLAG_SPLIT existed must still be readable.
        boolean writeSplits = hasSplits();
        int writtenFlags = writeSplits ? this.flags : (this.flags & ~FLAG_SPLIT);
        dest.writeInt(writtenFlags);
        if (writeSplits) {
            dest.writeStringList(this.splitPaths);
        }
    }

    public InstallOption() {
    }

    protected InstallOption(Parcel in) {
        this.flags = in.readInt();
        this.splitPaths = new ArrayList<>();
        if ((this.flags & FLAG_SPLIT) != 0) {
            in.readStringList(this.splitPaths);
        }
    }

    public static final Parcelable.Creator<InstallOption> CREATOR = new Parcelable.Creator<InstallOption>() {
        @Override
        public InstallOption createFromParcel(Parcel source) {
            return new InstallOption(source);
        }

        @Override
        public InstallOption[] newArray(int size) {
            return new InstallOption[size];
        }
    };
}
