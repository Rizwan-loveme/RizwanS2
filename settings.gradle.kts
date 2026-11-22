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
// Glass Gallery (photos + albums + full-screen viewer), package com.srizwan.gallery.
// Used by the File Manager (image files), the Start menu and the Home screen.
include(":gallery")
// Own "Open with" / Share sheets and file picker (replaces the system chooser for this app's own calls), package com.srizwan.chooser.
// Own module, resources prefixed "ch_", glass UI, no text of its own. Used by :app, :gallery and :video. Built step by step, see README.md.
include(":chooser")
// J2ME Loader (Java ME games / apps, .jar + .jad) as the built-in "J2ME" app, package ru.playsoftware.j2meloader (upstream package kept).
// Upstream: https://github.com/nikita36078/J2ME-Loader (Apache-2.0), see NOTICE-J2ME-Loader.md. :j2me-dexlib is upstream's ":dexlib".
// Used by the Start menu, the Home screen, the rizwans2://j2me deep link and the File Manager (.jar / .jad files).
include(":j2me")
include(":j2me-dexlib")
// Built-in Camera app (CameraX: photo, video, front / back, flash, zoom, focus), package com.srizwan.camera, resources prefixed "cm_".
// Used by the Start menu, the Home screen, the rizwans2://camera deep link and the built-in Browser (page camera / file upload with capture).
include(":camera")
