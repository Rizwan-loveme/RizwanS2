package com.srizwan.win11.parallel

import top.niunaijun.blackbox.utils.bundle.BundleInstaller
import top.niunaijun.blackbox.utils.bundle.InstallErrors

/** Texts of the "install from file" flow (Bengali, like the rest of the Parallel screen). */
object InstallText {

    /** File types the picker shows. The installer looks inside the file, so a wrong extension still works. */
    val PICKER_TYPES = listOf(".apk", ".xapk", ".apks", ".apkm")

    fun stage(stage: BundleInstaller.Stage): String = when (stage) {
        BundleInstaller.Stage.COPYING -> "📥 ফাইল কপি হচ্ছে…"
        BundleInstaller.Stage.UNPACKING -> "📦 ফাইল খোলা হচ্ছে…"
        BundleInstaller.Stage.CHECKING -> "🔍 পরীক্ষা করা হচ্ছে…"
        BundleInstaller.Stage.COPYING_OBB -> "🎮 গেমের OBB ফাইল কপি হচ্ছে…"
        BundleInstaller.Stage.INSTALLING -> "⚙️ ইনস্টল হচ্ছে…"
    }

    /** "12.3 / 80.0 MB" for the copy, unpack and OBB steps, empty when the size is not known. */
    fun amount(done: Long, total: Long): String {
        if (total <= 0L) return ""
        fun mb(v: Long) = String.format(java.util.Locale.US, "%.1f", v / 1048576.0)
        return " ${mb(done)} / ${mb(total)} MB"
    }

    /** A short title and a one or two line explanation for a failed install. */
    fun error(kind: InstallErrors.Kind): Pair<String, String> = when (kind) {
        InstallErrors.Kind.WRONG_ABI -> "এই ফোনে অ্যাপটি চলবে না" to
            "অ্যাপটির নেটিভ কোড এই ফোনের প্রসেসরের (arm / arm64) সাথে মেলে না। আপনার ফোনের জন্য সঠিক ফাইলটি নিন।"
        InstallErrors.Kind.BAD_FILE -> "ফাইলটি পড়া যাচ্ছে না" to
            "ফাইলটি নষ্ট বা অসম্পূর্ণ, অথবা এটি .apks / .xapk / .apkm নয়। আবার ডাউনলোড করে চেষ্টা করুন।"
        InstallErrors.Kind.NO_APK -> "ফাইলের ভেতরে কোনো APK নেই" to
            "এই জিপ ফাইলে ইনস্টল করার মতো কোনো APK পাওয়া যায়নি।"
        InstallErrors.Kind.NOT_ENOUGH_SPACE -> "ফোনে জায়গা কম" to
            "বান্ডেল খুলতে ফাইলের সমান ফাঁকা জায়গা লাগে। কিছু ফাইল মুছে আবার চেষ্টা করুন।"
        InstallErrors.Kind.SELF -> "এই অ্যাপ নিজের ভেতরে ক্লোন করা যায় না" to
            "এটি এই অ্যাপেরই APK।"
        InstallErrors.Kind.SPLIT_UNREADABLE -> "অ্যাপের একটি অংশ পড়া যায়নি" to
            "মূল অ্যাপটি আপডেট করে আবার চেষ্টা করুন।"
        InstallErrors.Kind.NO_FREE_SPACE_SLOT -> "আর কপি করা যাবে না" to
            "সব স্পেসে অ্যাপটি আগে থেকেই আছে (সর্বোচ্চ ${Engine.maxSpaces} টি)। একটি কপি মুছে আবার চেষ্টা করুন।"
        InstallErrors.Kind.BROKEN_APK -> "APK ফাইলটি নষ্ট" to
            "অ্যাপটি পড়া যায়নি। ফাইলটি ঠিকমতো ডাউনলোড হয়েছে কি না দেখুন।"
        InstallErrors.Kind.CANNOT_READ -> "ফাইলটি খোলা যায়নি" to
            "ফাইলটি সরানো হয়েছে বা পড়ার অনুমতি নেই।"
        InstallErrors.Kind.OBB_COPY -> "OBB ফাইল কপি করা যায়নি" to
            "গেমের ডেটা (OBB) কপি হয়নি, তাই অ্যাপটি ইনস্টল করা হয়নি। ফোনে ফাঁকা জায়গা আছে কি না দেখে আবার চেষ্টা করুন।"
        InstallErrors.Kind.UNKNOWN -> "ইনস্টল ব্যর্থ হয়েছে" to
            "নিচের বিস্তারিত দেখুন।"
    }
}
