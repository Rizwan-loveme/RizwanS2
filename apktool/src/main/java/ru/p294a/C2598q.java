package ru.p294a;

import java.util.zip.ZipException;

/* compiled from: Zip64RequiredException.java */
/* renamed from: ru.a.q */
/* loaded from: classes.dex */
public class C2598q extends ZipException {
    /* renamed from: a */
    static String m16104a(C2602u c2602u) {
        return new StringBuffer().append(c2602u.getName()).append("'s size exceeds the limit of 4GByte.").toString();
    }

    public C2598q(String str) {
        super(str);
    }
}
