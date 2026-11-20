package ru.maximoff.apktool.util.p305c;

/* compiled from: AbstractRule.java */
/* renamed from: ru.maximoff.apktool.util.c.d */
/* loaded from: classes.dex */
public abstract class AbstractC3187d {
    /* renamed from: a */
    protected abstract String mo19085a();

    /* renamed from: a */
    protected abstract void mo19086a(String str);

    /* renamed from: b */
    protected abstract boolean mo19087b();

    /* renamed from: a */
    protected final boolean m19107a(String str, String str2) {
        int lastIndexOf = str.lastIndexOf("/");
        return lastIndexOf >= 0 ? str2.equals(str.substring(lastIndexOf + 1)) : str2.equals(str);
    }
}
