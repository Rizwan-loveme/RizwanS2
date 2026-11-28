# :shizuku-shell (Shizuku step 3C, rules replaced by upstream's own in 3E: shell/proguard-rules.pro of v13.6.0 + the dontwarn lines below).
# R8 shrinks the shell loader into one small classes.dex (rish_shizuku.dex). app_process looks the entry point up by name.

-keep class rikka.shizuku.shell.ShizukuShellLoader {
    public static void main(java.lang.String[]);
}

-allowaccessmodification
-repackageclasses

# hidden-API stubs are compile-only; their real classes are the system's (not in upstream's file: it builds with the stub project's own consumer rules)
-dontwarn android.**
-dontwarn com.android.**
-dontwarn stub.**
-dontwarn dev.rikka.hidden.**
-dontwarn dev.rikka.tools.refine.**
