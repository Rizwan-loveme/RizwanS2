// Shared by :shizuku and the ten :shizuku-* modules (Shizuku step 3C, see shizuku/README.md).
// Every module build file applies it with  apply(from = "../after-fetch.gradle.kts")  (:shizuku itself: "modules/after-fetch.gradle.kts").
//
// What it does (same pattern as :mika and :ppsspp):
//   1. Everything that reads the upstream checkout waits for :shizuku:patchShizukuUpstream (which itself depends on :shizuku:fetchShizukuUpstream; both tasks are
//      registered in shizuku/build.gradle.kts, step 3E). The tasks are named by PATH, so they are resolved when the task graph is built and the order in which the
//      projects are configured does not matter. Hooked: preBuild (the umbrella of every variant task) and, to be explicit, the task families that read the source
//      sets directly: resources, assets, JNI libs, manifest, AIDL, BuildConfig, the Java / Kotlin compile, native (CMake) and lint.
//   2. Registers  checkShizukuLayout  in every module: a plain file check that runs after the patch and before the compile. The module build files point their
//      source sets at folders of shizuku/upstream/ that cannot be looked at from here (no network), so if upstream moved a folder or added a kind of source the
//      build file does not wire (Kotlin, AIDL, resources, a manifest, native code ...), the build stops with the module name and the folder instead of
//      with a "cannot find symbol" 3000 lines later. A missing src/main folder is an error; an unwired kind of file is only a warning (printed once per module).
//
// Not done here, on purpose: no source set, no dependency and no plugin is configured in this file (a script plugin has no typed accessors, and the build files
// show everything they read in one place). Nothing happens unless a module applies the script, i.e. only with -PincludeShizuku=true (settings.gradle.kts, step 3B).
//
// A module sets two extra properties BEFORE applying the script:
//   extra["shizukuUpstreamPath"] = "api/aidl"                      folder of the upstream Gradle project inside shizuku/upstream/
//   extra["shizukuWired"]        = listOf("java", "aidl")          kinds of source the build file wires: java, kotlin, aidl, res, assets, jniLibs, native, manifest
//   extra["shizukuIgnored"]      = listOf("manifest")              (optional) kinds that exist upstream and are deliberately NOT wired: no warning for them
//   extra["shizukuRequired"]     = listOf("api/rish/src/main/cpp/CMakeLists.txt")   (optional, step 3D) single files the build file points at directly (a CMake file ...), relative to
//                                                                  shizuku/upstream/: the check fails with the file name if one is missing
// Without shizukuUpstreamPath (the :shizuku-shell module has its own manifest, for example) the check is skipped; the task hooks are always set.

val shizukuFetchAndPatch = ":shizuku:patchShizukuUpstream"
val shizukuUpstreamRoot: File = rootProject.file("shizuku/upstream")
val shizukuModuleName: String = project.path

// 1. wait for fetch + patch
val shizukuHookPrefixes = listOf(
    "preBuild",
    "merge", "package", "process", "parse", "extract", "generate", "map", "copy",
    "javaPreCompile", "compile", "kapt", "ksp",
    "configureCMake", "buildCMake", "externalNativeBuild", "configureNdkBuild", "buildNdkBuild",
    "lint"
)
val shizukuCheckTaskName = "checkShizukuLayout"

val shizukuUpstreamPath: String? = if (extra.has("shizukuUpstreamPath")) extra["shizukuUpstreamPath"] as String else null
val shizukuWired: Set<String> =
    if (extra.has("shizukuWired")) (extra["shizukuWired"] as List<*>).map { it.toString() }.toSet() else emptySet()
val shizukuRequired: List<String> =
    if (extra.has("shizukuRequired")) (extra["shizukuRequired"] as List<*>).map { it.toString() } else emptyList()
val shizukuIgnored: Set<String> =
    if (extra.has("shizukuIgnored")) (extra["shizukuIgnored"] as List<*>).map { it.toString() }.toSet() else emptySet()

// 2. layout check (plain file walk; needs nothing but the checkout)
val shizukuCheck = tasks.register(shizukuCheckTaskName) {
    group = "shizuku"
    description = "Checks that the folder of this module in shizuku/upstream/ exists and holds only kinds of source that the build file wires"
    dependsOn(shizukuFetchAndPatch)
    val projectDirInUpstream: File? = shizukuUpstreamPath?.let { File(shizukuUpstreamRoot, it) }
    val wired = shizukuWired
    val ignored = shizukuIgnored
    val upstreamRoot = shizukuUpstreamRoot
    val required = shizukuRequired
    val moduleName = shizukuModuleName
    val relPath = shizukuUpstreamPath
    doLast {
        for (rel in required) {
            if (!File(upstreamRoot, rel).isFile) {
                throw GradleException(
                    "Shizuku: $moduleName points the build at shizuku/upstream/$rel, but that file does not exist. " +
                        "Upstream was probably reorganised: look at shizuku/upstream/ and fix the path in the module build file."
                )
            }
        }
        val dir = projectDirInUpstream ?: return@doLast
        val main = File(dir, "src/main")
        if (!main.isDirectory) {
            throw GradleException(
                "Shizuku: $moduleName expects the upstream project in shizuku/upstream/$relPath/src/main, but that folder does not exist. " +
                    "Upstream was probably reorganised: look at shizuku/upstream/ and fix extra[\"shizukuUpstreamPath\"] / the source sets in the module build file."
            )
        }
        val files = main.walkTopDown().filter { it.isFile }.toList()
        fun has(ext: String) = files.any { it.extension == ext }
        val found = linkedSetOf<String>()
        if (has("java")) found += "java"
        if (has("kt")) found += "kotlin"
        if (has("aidl")) found += "aidl"
        if (File(main, "res").isDirectory && files.any { it.path.contains("/res/") }) found += "res"
        if (File(main, "assets").isDirectory && files.any { it.path.contains("/assets/") }) found += "assets"
        if (File(main, "jniLibs").isDirectory) found += "jniLibs"
        if (File(main, "cpp").isDirectory || File(main, "jni").isDirectory) found += "native"
        if (File(main, "AndroidManifest.xml").isFile) found += "manifest"
        val unwired = found - wired - ignored
        if (unwired.isNotEmpty()) {
            logger.warn(
                "Shizuku: $moduleName: shizuku/upstream/$relPath/src/main holds $unwired that the build file does not wire (wired: $wired). " +
                    "Fine if the module does not need them (native code and the manifest of a library are often wired in a later step); " +
                    "otherwise add them to the source sets of the module build file."
            )
        }
        val missing = wired - found
        if (missing.isNotEmpty() && "java" in missing) {
            throw GradleException("Shizuku: $moduleName: no .java file under shizuku/upstream/$relPath/src/main although the build file wires java sources.")
        }
    }
}

tasks.configureEach {
    if (name == shizukuCheckTaskName) return@configureEach
    if (shizukuHookPrefixes.any { name.startsWith(it) }) {
        dependsOn(shizukuFetchAndPatch)
        // the layout check runs before the compile (it only looks at files, so it is cheap)
        if (name.startsWith("compile") || name == "preBuild") dependsOn(shizukuCheck)
    }
}
