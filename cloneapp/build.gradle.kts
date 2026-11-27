// Clone App as a prebuilt AAR module (package com.pengyou.cloneapp).
// This module has no sources: it only hands the ready-made cloneapp/cloneapp.aar (classes, res, assets, merged manifest) to :app.
// The AAR is made by cloneapp/tools/build-aar.py from the decoded Clone App + its dex2jar jars, see cloneapp/README.md ("What was changed").
//
// An AAR has no dependency list, so what the original APK carried inside its dex files and what was taken OUT of the AAR again
// (androidx, Material, protobuf, gson, ffmpeg-kit, WebView support: see cloneapp/STRIPPED-CLASSES.txt) is declared here as normal Gradle dependencies.
// Versions are the ones the other modules use, so Gradle still resolves ONE version of each library for the whole app.
configurations.maybeCreate("default")
artifacts.add("default", file("cloneapp.aar"))

dependencies {
    add("default", "androidx.core:core-ktx:1.12.0")
    add("default", "androidx.appcompat:appcompat:1.6.1")
    add("default", "androidx.recyclerview:recyclerview:1.3.2")
    add("default", "androidx.constraintlayout:constraintlayout:2.1.4")
    add("default", "com.google.android.material:material:1.11.0")
    add("default", "androidx.fragment:fragment:1.6.2")
    add("default", "androidx.activity:activity:1.8.2")
    add("default", "androidx.viewpager2:viewpager2:1.0.0")
    add("default", "androidx.cardview:cardview:1.0.0")
    add("default", "androidx.drawerlayout:drawerlayout:1.2.0")
    add("default", "androidx.coordinatorlayout:coordinatorlayout:1.2.0")
    add("default", "androidx.localbroadcastmanager:localbroadcastmanager:1.1.0")
    add("default", "androidx.browser:browser:1.8.0")
    add("default", "androidx.webkit:webkit:1.12.1")
    add("default", "androidx.emoji2:emoji2:1.4.0")
    add("default", "androidx.startup:startup-runtime:1.1.1")
    add("default", "androidx.profileinstaller:profileinstaller:1.3.1")
    add("default", "androidx.lifecycle:lifecycle-process:2.8.7")
    add("default", "androidx.work:work-runtime:2.9.1")
    // Same Media3 as :video / :youtube
    add("default", "androidx.media3:media3-exoplayer:1.8.0")
    add("default", "androidx.media3:media3-ui:1.8.0")
    // CameraX: same version as :camera / :j2me (the Clone App scans QR codes with it)
    add("default", "androidx.camera:camera-core:1.6.2")
    add("default", "androidx.camera:camera-camera2:1.6.2")
    add("default", "androidx.camera:camera-lifecycle:1.6.2")
    add("default", "androidx.camera:camera-view:1.6.2")
    add("default", "com.google.code.gson:gson:2.14.0")
    // Same protobuf-lite as :mika (the pin there lifts :ppsspp's 4.33.5 to it)
    add("default", "com.google.protobuf:protobuf-javalite:4.36.2")
    // The ffmpeg-kit classes (com.arthenica) of the Clone App's video tools: the same artifact :j2me uses
    add("default", "io.github.nikita36078:ffmpeg-kit:6.0.LTS")
}
