package com.p065b.p086b.p103f.p106c;

import android.app.slice.SliceItem;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p110h.C1022m;

/* compiled from: CstLong.java */
/* renamed from: com.b.b.f.c.s */
/* loaded from: classes.dex */
public final class C0965s extends AbstractC0963q {

    /* renamed from: a */
    public static final C0965s f6161a = m8068a(0);

    /* renamed from: b */
    public static final C0965s f6162b = m8068a(1);

    /* renamed from: a */
    public static C0965s m8068a(long j) {
        return new C0965s(j);
    }

    private C0965s(long j) {
        super(j);
    }

    public String toString() {
        long k = mo8065k();
        return "long{0x" + C1022m.m8553a(k) + " / " + k + '}';
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: a */
    public C0975c mo6695a() {
        return C0975c.f6252g;
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: h */
    public String mo8036h() {
        return SliceItem.FORMAT_LONG;
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        return Long.toString(mo8065k());
    }

    /* renamed from: n */
    public long m8069n() {
        return mo8065k();
    }
}
