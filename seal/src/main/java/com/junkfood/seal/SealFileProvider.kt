package com.junkfood.seal

import androidx.core.content.FileProvider

/**
 * Win11: own subclass of the AndroidX FileProvider (same reason as `ChooserFileProvider` / `GalleryFileProvider` / `WinlatorFileProvider`:
 * two `<provider>` entries with the class `androidx.core.content.FileProvider` clash in the manifest merge, the authorities differ).
 * Authority `${applicationId}.provider` and paths `res/xml/sl_provider_paths.xml` are upstream's; `FileUtil.getFileProvider()` (= "$packageName.provider") is unchanged.
 */
class SealFileProvider : FileProvider()
