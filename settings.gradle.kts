pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    // এই লাইনটি রিপোজিটরি কনফ্লিক্ট দূর করবে
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        // FreeReflection (used by the BlackBox engine in :Bcore)
        maven { url = uri("https://www.jitpack.io") }
    }
}

rootProject.name = "Win11"
include(":app")
// BlackBox engine (parallel apps / "Open in black box"): see NOTICE-BlackBox.md
include(":Bcore")
include(":black-reflection")
include(":compiler")
// Winlator engine (run PC .exe from the File Manager / Start menu): see NOTICE-Winlator.md
include(":winlator")
// Built-in YouTube app (native client: NewPipeExtractor + Media3), package com.srizwan.YouTube
include(":youtube")
// Glass video player (Media3 ExoPlayer, 4K ready) + the built-in Video app, package com.srizwan.video.
// Used by the File Manager (video files), the Start menu and the Home screen.
include(":video")
