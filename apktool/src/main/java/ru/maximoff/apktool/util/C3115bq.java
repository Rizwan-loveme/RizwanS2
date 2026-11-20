package ru.maximoff.apktool.util;

import java.util.Arrays;

/* compiled from: VectorPath.java */
/* renamed from: ru.maximoff.apktool.util.bq */
/* loaded from: classes.dex */
public class C3115bq {

    /* renamed from: a */
    private String f18392a;

    /* renamed from: b */
    private String f18393b;

    public C3115bq(String str, String str2) {
        this.f18392a = str;
        this.f18393b = str2;
    }

    /* renamed from: a */
    public String m19046a() {
        return this.f18392a;
    }

    /* renamed from: b */
    public String m19047b() {
        return this.f18393b;
    }

    public String toString() {
        return new StringBuffer().append(new StringBuffer().append(this.f18392a).append(";").toString()).append(this.f18393b).toString();
    }

    public int hashCode() {
        return Arrays.hashCode(new String[]{this.f18392a, this.f18393b});
    }
}
