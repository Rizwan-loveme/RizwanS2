package com.p065b.p086b.p103f.p104a;

import android.os.Build;
import com.p065b.p086b.p110h.InterfaceC1035z;

/* compiled from: AnnotationVisibility.java */
/* renamed from: com.b.b.f.a.b */
/* loaded from: classes.dex */
public enum EnumC0915b implements InterfaceC1035z {
    RUNTIME("runtime"),
    BUILD("build"),
    SYSTEM(Build.Partition.PARTITION_NAME_SYSTEM),
    EMBEDDED("embedded");


    /* renamed from: e */
    private final String f5850e;

    EnumC0915b(String str) {
        this.f5850e = str;
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        return this.f5850e;
    }
}
