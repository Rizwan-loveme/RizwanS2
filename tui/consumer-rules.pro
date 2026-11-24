# Consumer ProGuard / R8 rules of :tui (applied to :app when it shrinks; :app has isMinifyEnabled = false today).
# Step 7: upstream's app/proguard-rules.pro (TUI-ConsoleLauncher), unchanged in meaning. TUI loads its commands by class name
# (reflection: one class per command in commands.main.raw / commands.main.specific / commands.tuixt.raw) and its managers are looked up and
# read through reflection and XML names, so renaming or removing them would break the terminal. Checked against a real shrunk build in step 13.

-keep public class ohi.andre.consolelauncher.commands.main.raw.** { *; }
-keep public class ohi.andre.consolelauncher.commands.main.specific.** { *; }
-keep public class ohi.andre.consolelauncher.commands.tuixt.raw.** { *; }
-keep public class ohi.andre.consolelauncher.tuils.GenericFileProvider { *; }
-keep public class ohi.andre.consolelauncher.tuils.PrivateIOReceiver { *; }
-keep public class ohi.andre.consolelauncher.tuils.PublicIOReceiver { *; }
-keep class ohi.andre.consolelauncher.managers.** { *; }
-keep class ohi.andre.consolelauncher.tuils.libsuperuser.**
-keep class ohi.andre.consolelauncher.managers.suggestions.HideSuggestionViewValues
-keep public class it.andreuzzi.comparestring2.**

-dontwarn ohi.andre.consolelauncher.commands.main.raw.**

-dontwarn javax.annotation.**
-dontwarn javax.inject.**
-dontwarn sun.misc.Unsafe

-dontwarn okhttp3.**
-dontwarn okio.**
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase

-dontwarn org.htmlcleaner.**
-dontwarn com.jayway.jsonpath.**
-dontwarn org.slf4j.**

-dontwarn org.jdom2.**
