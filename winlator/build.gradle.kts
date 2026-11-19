// Winlator engine as an Android library (part 1 of 10 of "Winlator inside Win11").
// Source: https://github.com/brunodev85/winlator-app (v11.2). See NOTICE-Winlator.md.
//
// Differences from the original application module:
//   * com.android.application -> com.android.library (the Win11 :app is the only application)
//   * no minifyEnabled
//   * native build (cmake 3.22.1, NDK from ext.ndkVer, arm64-v8a only) is wired in part 2
plugins {
    id("com.android.library")
}

android {
    namespace = "com.winlator"
    compileSdk = 37

    defaultConfig {
        // Winlator needs 26. :app was raised from 24 to 26 for this (Tecno Spark Go 3 runs Android 15).
        minSdk = 26
        consumerProguardFiles("consumer-rules.pro")

        // Winlator (Wine + Box64) is arm64 only; libadrenotools even stops the build for other ABIs.
        ndk {
            abiFilters += "arm64-v8a"
        }
        externalNativeBuild {
            cmake {
                abiFilters += "arm64-v8a"
            }
        }
    }

    // Native part (part 2): libwinlator, libvortekrenderer, libvirglrenderer, libgladiorenderer,
    // libmidihandler, libadrenotools. Same NDK as the BlackBox engine (ext.ndkVer in build.gradle.kts).
    ndkVersion = rootProject.extra["ndkVer"] as String
    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    // Winlator unpacks its own rootfs and runs native tools, libs must be extracted to disk.
    packaging {
        jniLibs {
            useLegacyPackaging = true
        }
    }

    lint {
        checkReleaseBuilds = false
        abortOnError = false
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.preference:preference:1.2.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("com.github.luben:zstd-jni:1.5.2-3@aar")
    implementation("org.tukaani:xz:1.12")
    implementation("org.apache.commons:commons-compress:1.28.0")
    implementation("androidx.lifecycle:lifecycle-process:2.5.1")
}

// ---------------------------------------------------------------------------------------------
// Big binary assets (*.tzst, *.sf2 = about 140 MB: rootfs, box64, dxvk, vkd3d, wincomponents, ...)
// are NOT kept in the project zip (upload limit). They are downloaded once, at build time, from the
// pinned commit of brunodev85/winlator-app (the same commit the module code was copied from) and
// unpacked into src/main/assets. Offline: copy them there by hand and the task is skipped.
// ---------------------------------------------------------------------------------------------
val winlatorCommit = "ecd5ab2980de79eb955621cef26a3b4672013875"

val fetchWinlatorAssets by tasks.registering {
    val assetsDir = layout.projectDirectory.dir("src/main/assets").asFile
    val tmpZip = layout.buildDirectory.file("winlator-app-$winlatorCommit.zip").get().asFile
    onlyIf { !File(assetsDir, "rootfs.tzst").exists() }
    doLast {
        tmpZip.parentFile.mkdirs()
        val url = "https://github.com/brunodev85/winlator-app/archive/$winlatorCommit.zip"
        logger.lifecycle("Downloading Winlator assets from $url")
        java.net.URL(url).openStream().use { input -> tmpZip.outputStream().use { input.copyTo(it) } }
        val prefix = "winlator-app-$winlatorCommit/app/src/main/assets/"
        var count = 0
        java.util.zip.ZipInputStream(tmpZip.inputStream().buffered()).use { zip ->
            var e = zip.nextEntry
            while (e != null) {
                if (!e.isDirectory && e.name.startsWith(prefix)) {
                    val out = File(assetsDir, e.name.removePrefix(prefix))
                    if (!out.canonicalPath.startsWith(assetsDir.canonicalPath)) throw GradleException("bad entry " + e.name)
                    out.parentFile.mkdirs()
                    out.outputStream().use { zip.copyTo(it) }
                    count++
                }
                e = zip.nextEntry
            }
        }
        check(File(assetsDir, "rootfs.tzst").exists()) { "rootfs.tzst missing after download ($count files)" }
        logger.lifecycle("Winlator assets ready: $count files")
    }
}
tasks.matching { it.name == "preBuild" }.configureEach { dependsOn(fetchWinlatorAssets) }
