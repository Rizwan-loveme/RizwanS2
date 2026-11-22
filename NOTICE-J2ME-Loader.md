# J2ME Loader notice

The `:j2me` and `:j2me-dexlib` modules are a copy of https://github.com/nikita36078/J2ME-Loader (v1.8.2, versionCode 101,
commit 360681d) by Nikita Shakarun and contributors (a fork of J2meLoader by Nickolay Savchenko; Mascot Capsule 3D,
soundbank support and more by woesss, JL-Mod). `:j2me-dexlib` is upstream's `:dexlib`.

License: Apache License 2.0 (see `LICENSE-J2ME-Loader`). Third-party parts: MicroEmulator (`org.microemu`), Sonivox EAS,
TinySoundFont (`j2me/src/main/cpp/mmapi_tsf/TinySoundFont`, MIT, its own LICENSE file is kept), ffmpeg-kit,
Oboe, ACRA and the AndroidX / Material libraries listed in `j2me/build.gradle.kts`. The upstream `assets/licenses.html`
(the in-app license list) is kept. If you distribute the APK you must keep this notice and the Apache-2.0 license text.

Changes made for Win11 (the Apache-2.0 "state changes" rule) are listed in `README.md`, section "J2ME Loader".
