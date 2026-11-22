// Dex / ASM helpers of J2ME Loader (upstream module ":dexlib", package ru.playsoftware.j2meloader.dexlib).
// Used by :j2me to convert a MIDlet .jar into a .dex file when a game is installed.
// Kept as its own module (like upstream) so it can be updated from upstream without touching :j2me.
plugins {
    id("com.android.library")
}

android {
    namespace = "ru.playsoftware.j2meloader.dexlib"
    compileSdk = 37

    defaultConfig {
        // Same as :app and the other built-in app modules
        minSdk = 26
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    lint {
        abortOnError = false
    }
}

dependencies {
    implementation("net.lingala.zip4j:zip4j:2.11.6")
    implementation("org.ow2.asm:asm:9.11")

    testImplementation("junit:junit:4.13.2")
}
