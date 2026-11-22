// J2ME Loader (https://github.com/nikita36078/J2ME-Loader, Apache-2.0) as an Android library (built-in "J2ME" app).
//
// Upstream is an application module (applicationId ru.playsoftware.j2meloader); here it is a library whose Java
// package and R class stay ru.playsoftware.j2meloader, so the upstream sources are used unchanged where possible.
// What changed compared to upstream (details in README.md, section "J2ME Loader"):
//   * no Application class: com.srizwan.win11.App calls EmulatorApplication.attach / attachMidletProcess,
//   * no MAIN / LAUNCHER filter (the Win11 Start menu, Home icon and rizwans2://j2me open it),
//   * no product flavors (the "midlet" port flavor is dropped, FULL_EMULATOR is always true),
//   * the resources that clashed with :app / :winlator got a "jl_" prefix (about, add, ic_launcher, ...).
// The native libraries (MascotCapsule micro3d, M3G, MMAPI / sonivox / TinySoundFont) are built with ndk-build.
plugins {
    id("com.android.library")
}

android {
    namespace = "ru.playsoftware.j2meloader"
    compileSdk = 37
    // Same NDK as :Bcore (one NDK for the whole project, see ext.ndkVer in the root build.gradle.kts)
    ndkVersion = rootProject.extra["ndkVer"] as String

    defaultConfig {
        // Same as :app (26); upstream supports 21
        minSdk = 26

        // Replaces the flavor fields / BuildConfig.VERSION_NAME of upstream (a library has no VERSION_NAME)
        buildConfigField("boolean", "FULL_EMULATOR", "true")
        buildConfigField("String", "J2ME_VERSION_NAME", "\"1.8.2\"")

        // The rest of the app (BlackBox, Winlator) is ARM only; no need to build x86 copies of the J2ME libraries
        ndk {
            abiFilters += listOf("arm64-v8a", "armeabi-v7a")
        }

        // Rules for a minified host build (upstream "play" flavor rules)
        consumerProguardFiles("proguard-rules.pro", "proguard-common.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    externalNativeBuild {
        ndkBuild {
            path = file("src/main/cpp/Android.mk")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    buildFeatures {
        viewBinding = true
        // Oboe (audio) is a Prefab package used by the native MMAPI code
        prefab = true
        buildConfig = true
    }

    lint {
        abortOnError = false
        disable += listOf("MissingTranslation", "ExtraTranslation")
    }
}

dependencies {
    val roomVersion = "2.8.5"
    val cameraxVersion = "1.6.2"
    val autoServiceVersion = "1.1.1"

    implementation(project(":j2me-dexlib"))

    // Android Jetpack
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-rxjava2:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")
    implementation("androidx.constraintlayout:constraintlayout:2.2.2")
    implementation("androidx.activity:activity:1.13.0")
    implementation("androidx.appcompat:appcompat:1.8.0")
    implementation("androidx.recyclerview:recyclerview:1.4.0")
    implementation("com.google.android.material:material:1.13.0")
    implementation("androidx.preference:preference:1.2.1")

    // Networking && APIs
    implementation("com.android.volley:volley:1.2.1")
    implementation("com.google.code.gson:gson:2.14.0")
    implementation("com.google.guava:guava:33.7.2-android")

    // Threads, Streams and Archives
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("net.lingala.zip4j:zip4j:2.11.6")

    // Audio / Video / Graphics
    implementation("com.github.nikita36078:pngj:2.2.3")
    implementation("io.github.nikita36078:ffmpeg-kit:6.0.LTS")
    implementation("com.google.oboe:oboe:1.11.0")

    implementation("androidx.camera:camera-core:$cameraxVersion")
    implementation("androidx.camera:camera-camera2:$cameraxVersion")
    implementation("androidx.camera:camera-lifecycle:$cameraxVersion")
    implementation("androidx.camera:camera-view:$cameraxVersion")

    // Android UI
    implementation("com.github.nikita36078:filepicker:4.3.0")
    implementation("com.github.yukuku:ambilwarna:2.0.1")

    // Crash dialog (shown in the :midlet process)
    implementation("ch.acra:acra-dialog:5.14.2")

    val kotlinMetadataVersion = "2.4.21"
    annotationProcessor("org.jetbrains.kotlin:kotlin-metadata-jvm:$kotlinMetadataVersion")
    compileOnly("com.google.auto.service:auto-service-annotations:$autoServiceVersion")
    annotationProcessor("com.google.auto.service:auto-service:$autoServiceVersion")
}
