# :shizuku-provider: same two rules as api/provider/consumer-rules.pro of Shizuku-API (MIT), copied here so the path exists without the checkout.
-keepnames class moe.shizuku.api.BinderContainer
-keepclassmembers class moe.shizuku.api.BinderContainer {
   public static final android.os.Parcelable$Creator CREATOR;
}
