package top.niunaijun.blackbox.app.configuration;

import java.io.File;


public abstract class ClientConfiguration {

    public boolean isHideRoot() {
        return false;
    }



    public abstract String getHostPackageName();

    public boolean isEnableDaemonService() {
        return true;
    }

    public boolean isEnableLauncherActivity() {
        return true;
    }

    
    public boolean isUseVpnNetwork() {
        return false;
    }

    public boolean isDisableFlagSecure() {
        return false;
    }

    
    public boolean requestInstallPackage(File file, int userId) {
        return false;
    }

    /**
     * Part 31: when true (default), an app inside the box that asks to install an APK gets the box's own
     * install dialog and the app is installed into the same space. When false the system installer runs
     * (the app lands on the phone).
     */
    public boolean isInstallInsideBox() {
        return true;
    }

    
    public String getLogSenderChatId() {
        return ""; // log upload disabled in Parallel
    }
}
