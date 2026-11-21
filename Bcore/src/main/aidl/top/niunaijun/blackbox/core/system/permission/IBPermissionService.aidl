// IBPermissionService.aidl
package top.niunaijun.blackbox.core.system.permission;

import android.os.Bundle;

// Per-clone permission decisions (Allow / Ask / Deny).
// Mode values: 0 = DEFAULT (inherit), 1 = ALLOW, 2 = ASK, 3 = DENY.
interface IBPermissionService {
    // Effective mode (never 0): exact permission -> package default ("*") -> global default.
    int getMode(int userId, String packageName, String permission);
    // Stored mode only; 0 when nothing stored for this exact permission.
    int getRawMode(int userId, String packageName, String permission);
    // mode 0 removes the stored value. permission "*" = default for the whole package.
    void setMode(int userId, String packageName, String permission, int mode);
    // Bundle of permission -> int (stored values only, may include "*").
    Bundle getModes(int userId, String packageName);
    void resetPackage(int userId, String packageName);
    void resetAll();
    int getGlobalDefault();
    void setGlobalDefault(int mode);
    // Bumped on every change, lets clients invalidate caches cheaply.
    int getVersion();
    // "Allow this time" from the Ask dialog (part 17): in memory only, ends after a while,
    // and is dropped when the rules of that clone change. Counts only while the mode is Ask.
    void grantTemporary(int userId, String packageName, String permission);
}
