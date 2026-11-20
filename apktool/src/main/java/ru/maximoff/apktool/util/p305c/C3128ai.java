package ru.maximoff.apktool.util.p305c;

/* compiled from: DexProtectX.java */
/* renamed from: ru.maximoff.apktool.util.c.ai */
/* loaded from: classes.dex */
public class C3128ai extends AbstractC3187d {

    /* renamed from: a */
    private final String f18473a = "^assets/dexshell/(arm.*|x86.*)/libdexshell\\.so$";

    /* renamed from: b */
    private final String f18474b = "assets/libVMDexShellx.so";

    /* renamed from: c */
    private final String f18475c = "assets/DexShell.mp3";

    /* renamed from: d */
    private boolean f18476d = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18476d) {
            return;
        }
        if (str.matches("^assets/dexshell/(arm.*|x86.*)/libdexshell\\.so$") || str.equals("assets/libVMDexShellx.so") || str.equals("assets/DexShell.mp3")) {
            this.f18476d = true;
        }
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "DexProtect X (DexShellx)";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18476d;
    }
}
