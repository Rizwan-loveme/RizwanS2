package com.p065b.p111c;

import com.p065b.p111c.p120c.InterfaceC1067a;
import com.p065b.p111c.p120c.InterfaceC1069c;
import java.p209io.Closeable;
import java.util.List;

/* compiled from: ApkSignerEngine.java */
/* renamed from: com.b.c.b */
/* loaded from: classes.dex */
public interface InterfaceC1041b extends Closeable {

    /* compiled from: ApkSignerEngine.java */
    /* renamed from: com.b.c.b$b */
    public enum b {
        SKIP,
        OUTPUT,
        OUTPUT_BY_ENGINE;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static b[] valuesCustom() {
            b[] valuesCustom = values();
            int length = valuesCustom.length;
            b[] bVarArr = new b[length];
            System.arraycopy(valuesCustom, 0, bVarArr, 0, length);
            return bVarArr;
        }
    }

    /* compiled from: ApkSignerEngine.java */
    /* renamed from: com.b.c.b$c */
    public interface c {
        /* renamed from: a */
        void mo8837a();

        /* renamed from: b */
        InterfaceC1067a mo8838b();
    }

    /* compiled from: ApkSignerEngine.java */
    /* renamed from: com.b.c.b$d */
    public interface d {
        /* renamed from: a */
        void mo8856a();

        /* renamed from: b */
        byte[] mo8857b();
    }

    /* compiled from: ApkSignerEngine.java */
    /* renamed from: com.b.c.b$e */
    public interface e {
        /* renamed from: a */
        void mo8910a();

        /* renamed from: b */
        List<f> mo8911b();
    }

    /* renamed from: a */
    a mo8635a(String str);

    /* renamed from: a */
    d mo8636a(InterfaceC1069c interfaceC1069c, InterfaceC1069c interfaceC1069c2, InterfaceC1069c interfaceC1069c3);

    /* renamed from: a */
    void mo8637a();

    /* renamed from: a */
    void mo8638a(InterfaceC1069c interfaceC1069c);

    /* renamed from: b */
    c mo8639b(String str);

    /* renamed from: b */
    e mo8640b();

    /* compiled from: ApkSignerEngine.java */
    /* renamed from: com.b.c.b$a */
    public static class a {

        /* renamed from: a */
        private final c f6550a;

        /* renamed from: b */
        private final b f6551b;

        public a(b bVar) {
            this(bVar, null);
        }

        public a(b bVar, c cVar) {
            this.f6551b = bVar;
            this.f6550a = cVar;
        }

        /* renamed from: b */
        public b m8642b() {
            return this.f6551b;
        }

        /* renamed from: a */
        public c m8641a() {
            return this.f6550a;
        }
    }

    /* compiled from: ApkSignerEngine.java */
    /* renamed from: com.b.c.b$f */
    public static class f {

        /* renamed from: a */
        private final byte[] f6739a;

        /* renamed from: b */
        private final String f6740b;

        public f(String str, byte[] bArr) {
            this.f6740b = str;
            this.f6739a = (byte[]) bArr.clone();
        }

        /* renamed from: b */
        public String m8913b() {
            return this.f6740b;
        }

        /* renamed from: a */
        public byte[] m8912a() {
            return (byte[]) this.f6739a.clone();
        }
    }
}
