# Rizwan: licence and source notice (part of the Win11 app)

This file is shipped inside the app (`assets/licenses/RIZWAN-NOTICE.md`) next to the licence texts of the **Rizwan** assistant.

## What Rizwan is
Rizwan is based on **Mika** (https://github.com/wangzan101/Mika), version 0.1.52, commit `7ff1703f63b7cbf5741a29345c1b4507802c6b06`.
Mika is licensed under the **Apache License 2.0** (`Apache-2.0.txt`), Copyright 2026 wangzan101. Mika's own NOTICE file is `MIKA-NOTICE.txt`.
Mika's name and logo are not used as the brand of this app; the assistant is shown as "Rizwan" with its own icon. This is not an official Mika release and is not endorsed by its authors.

## Changes made to Mika (Apache-2.0 section 4(b))
The changes are applied to Mika's source when this app is built (the patch script `mika/tools/patch-upstream.py` of the Win11 project). In short:
- Mika's Android application is built as a library inside Win11 (application attributes and launcher entry removed from its manifest, `MikaApp` made extendable);
- 13 clashing resource names are renamed with the prefix `mk_`;
- the product name "Mika" becomes "Rizwan" in all texts, the chat greeting becomes "Hey Rizwan", the icon art is replaced;
- Mika's own update check is switched off (it would install Mika's own APK over Win11); its language switch no longer changes the language of the whole app;
  the text after a backup import is reworded; Mika's screens get the label "Rizwan", its icon and their own task; Mika is started by Win11, and "Quit" no longer ends the host process;
- the licence texts and notices listed below are added to the app's assets.
No permission of Mika is removed.

## Third-party components that come with Mika (full list: `THIRD_PARTY_NOTICES.md`)
| Component | Licence | Where it is in the app |
|---|---|---|
| **PRoot 5.4.0** (modified by Mika with 4 patches) | GPL-2.0-or-later (`GPL-2.0.txt`) | `lib/arm64-v8a/libproot.so` and `libproot_loader.so`, started only as a separate process |
| **talloc 2.4.3** (unmodified) | LGPL-3.0-or-later (`LGPL-3.0.txt`, `GPL-3.0.txt`) | linked into `libproot.so` |
| **Alpine Linux 3.22.7 root file system** with Python, Node, Pillow, pypdf and their dependencies | the licence of each package (GPL, LGPL, MIT, BSD, MPL ...), listed in `assets/runtime/packages.json` | `assets/runtime/rootfs.tar.xz`, programs run only as separate processes |
| scrcpy (technique), FlashPhone (calls feature), commons-compress, xterm.js, Shizuku, ML Kit, ZXing and others | Apache-2.0, MIT, BSD, 0BSD, CC0 ... | see `THIRD_PARTY_NOTICES.md` |

## Source code of the GPL / LGPL parts
- The four patches Mika applies to PRoot, the pinned source archives with their SHA-256 values and Mika's build notes are in this app: `gpl-source/patches/*.patch`, `gpl-source/sources.lock`, `gpl-source/runtime-sources.lock`, `gpl-source/README.md`.
- PRoot 5.4.0: https://github.com/proot-me/proot/archive/refs/tags/v5.4.0.tar.gz  talloc 2.4.3: https://www.samba.org/ftp/talloc/talloc-2.4.3.tar.gz (checksums in `gpl-source/sources.lock`).
- Build scripts and the rest of Mika's source at the pinned commit: https://github.com/wangzan101/Mika/tree/7ff1703f63b7cbf5741a29345c1b4507802c6b06 (`tools/sandbox/`).
- Source of the GPL / LGPL / MPL packages of the Alpine root file system: Alpine's package sources (https://alpinelinux.org/), exact package versions in `assets/runtime/packages.json`;
  Mika's own release page also names a `mika-<version>-gpl-sources.tar.gz` for them (see `gpl-source/README.md`).
