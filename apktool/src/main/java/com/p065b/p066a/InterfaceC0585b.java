package com.p065b.p066a;

import com.p065b.p066a.p084c.InterfaceC0669a;
import com.p065b.p066a.p084c.InterfaceC0671c;
import java.p209io.Closeable;
import java.p209io.File;
import java.util.List;

/* compiled from: ApkSignerEngine.java */
/* renamed from: com.b.a.b */
/* loaded from: classes.dex */
public interface InterfaceC0585b extends Closeable {

    /* compiled from: ApkSignerEngine.java */
    /* renamed from: com.b.a.b$b */
    public interface b {
        /* renamed from: a */
        void mo6086a();

        /* renamed from: b */
        InterfaceC0669a mo6087b();
    }

    /* compiled from: ApkSignerEngine.java */
    /* renamed from: com.b.a.b$c */
    public interface c {
        /* renamed from: a */
        void mo6188a();

        /* renamed from: b */
        byte[] mo6189b();

        /* renamed from: c */
        int mo6190c();
    }

    /* renamed from: a */
    a mo5790a(String str);

    /* renamed from: a */
    c mo5791a(InterfaceC0671c interfaceC0671c, InterfaceC0671c interfaceC0671c2, InterfaceC0671c interfaceC0671c3);

    /* renamed from: a */
    void mo5792a(InterfaceC0671c interfaceC0671c);

    /* renamed from: a */
    void mo5793a(InterfaceC0671c interfaceC0671c, File file, boolean z);

    /* renamed from: a */
    byte[] mo5794a();

    /* renamed from: b */
    b mo5795b(String str);

    /* renamed from: b */
    boolean mo5796b();

    /* renamed from: c */
    void mo5797c();

    /* renamed from: d */
    d mo5798d();

    /* compiled from: ApkSignerEngine.java */
    /* renamed from: com.b.a.b$a */
    public static class a {

        /* renamed from: a */
        private final b f3974a;

        /* renamed from: b */
        private final EnumC3327a f3975b;

        /* compiled from: ApkSignerEngine.java */
        /* renamed from: com.b.a.b$a$a, reason: collision with other inner class name */
        public enum EnumC3327a {
            SKIP,
            OUTPUT,
            OUTPUT_BY_ENGINE
        }

        public a(EnumC3327a enumC3327a) {
            this(enumC3327a, null);
        }

        public a(EnumC3327a enumC3327a, b bVar) {
            this.f3975b = enumC3327a;
            this.f3974a = bVar;
        }

        /* renamed from: b */
        public EnumC3327a m5800b() {
            return this.f3975b;
        }

        /* renamed from: a */
        public b m5799a() {
            return this.f3974a;
        }
    }

    /* compiled from: ApkSignerEngine.java */
    /* renamed from: com.b.a.b$d */
    public interface d {
        /* renamed from: a */
        void mo6196a();

        /* renamed from: b */
        List<a> mo6197b();

        /* compiled from: ApkSignerEngine.java */
        /* renamed from: com.b.a.b$d$a */
        public static class a {

            /* renamed from: a */
            private final byte[] f4224a;

            /* renamed from: b */
            private final String f4225b;

            public a(String str, byte[] bArr) {
                this.f4225b = str;
                this.f4224a = (byte[]) bArr.clone();
            }

            /* renamed from: b */
            public String m6199b() {
                return this.f4225b;
            }

            /* renamed from: a */
            public byte[] m6198a() {
                return (byte[]) this.f4224a.clone();
            }
        }
    }
}
