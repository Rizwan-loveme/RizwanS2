package com.p122c.p123a;

import java.p209io.FileNotFoundException;
import java.p209io.IOException;
import java.p209io.RandomAccessFile;
import java.util.Arrays;

/* compiled from: ELFFileParser.java */
/* renamed from: com.c.a.d */
/* loaded from: classes.dex */
public class C1076d {

    /* renamed from: a */
    private static C1076d f6874a;

    /* renamed from: a */
    public static C1076d m8992a() {
        if (f6874a == null) {
            f6874a = new C1076d();
        }
        return f6874a;
    }

    /* renamed from: a */
    public InterfaceC1075c m8994a(String str) {
        try {
            return m8993a(new C1080h(new RandomAccessFile(str, "r")));
        } catch (FileNotFoundException e2) {
            throw new C1074b(e2);
        }
    }

    /* renamed from: a */
    public InterfaceC1075c m8993a(InterfaceC1073a interfaceC1073a) {
        return new a(this, interfaceC1073a);
    }

    /* compiled from: ELFFileParser.java */
    /* renamed from: com.c.a.d$a */
    class a implements InterfaceC1075c {

        /* renamed from: b */
        private InterfaceC1073a f6875b;

        /* renamed from: c */
        private InterfaceC1077e f6876c;

        /* renamed from: d */
        private byte[] f6877d = new byte[16];

        /* renamed from: e */
        private final C1076d f6878e;

        a(C1076d c1076d, InterfaceC1073a interfaceC1073a) {
            this.f6878e = c1076d;
            this.f6875b = interfaceC1073a;
            int m8996a = m8996a(this.f6877d);
            if (m8996a != this.f6877d.length) {
                throw new C1074b(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("Error reading elf header (read ").append(m8996a).toString()).append("bytes, expected to ").toString()).append("read ").toString()).append(this.f6877d.length).toString()).append("bytes).").toString());
            }
            if (!Arrays.equals(m8998d(), InterfaceC1075c.f6873a)) {
                throw new C1074b("Bad magic number for file.");
            }
            this.f6876c = new C3336a(this);
        }

        @Override // com.p122c.p123a.InterfaceC1075c
        /* renamed from: a */
        public InterfaceC1077e mo8989a() {
            return this.f6876c;
        }

        /* renamed from: d */
        public byte[] m8998d() {
            return new byte[]{this.f6877d[0], this.f6877d[1], this.f6877d[2], this.f6877d[3]};
        }

        @Override // com.p122c.p123a.InterfaceC1075c
        /* renamed from: b */
        public byte mo8990b() {
            return this.f6877d[4];
        }

        @Override // com.p122c.p123a.InterfaceC1075c
        /* renamed from: c */
        public byte mo8991c() {
            return this.f6877d[5];
        }

        /* compiled from: ELFFileParser.java */
        /* renamed from: com.c.a.d$a$a, reason: collision with other inner class name */
        class C3336a implements InterfaceC1077e {

            /* renamed from: a */
            private byte[] f6879a = new byte[16];

            /* renamed from: b */
            private short f6880b;

            /* renamed from: c */
            private short f6881c;

            /* renamed from: d */
            private int f6882d;

            /* renamed from: e */
            private int f6883e;

            /* renamed from: f */
            private int f6884f;

            /* renamed from: g */
            private int f6885g;

            /* renamed from: h */
            private int f6886h;

            /* renamed from: i */
            private short f6887i;

            /* renamed from: j */
            private short f6888j;

            /* renamed from: k */
            private short f6889k;

            /* renamed from: l */
            private short f6890l;

            /* renamed from: m */
            private short f6891m;

            /* renamed from: n */
            private short f6892n;

            /* renamed from: o */
            private AbstractC1079g[] f6893o;

            /* renamed from: p */
            private final a f6894p;

            C3336a(a aVar) {
                this.f6894p = aVar;
                this.f6880b = this.f6894p.m8999e();
                this.f6881c = this.f6894p.m8999e();
                this.f6882d = this.f6894p.m9000f();
                this.f6883e = this.f6894p.m9000f();
                this.f6884f = this.f6894p.m9000f();
                this.f6885g = this.f6894p.m9000f();
                this.f6886h = this.f6894p.m9000f();
                this.f6887i = this.f6894p.m8999e();
                this.f6888j = this.f6894p.m8999e();
                this.f6889k = this.f6894p.m8999e();
                this.f6890l = this.f6894p.m8999e();
                this.f6891m = this.f6894p.m8999e();
                this.f6892n = this.f6894p.m8999e();
                this.f6893o = new AbstractC1079g[this.f6891m];
                for (int i = 0; i < this.f6891m; i++) {
                    this.f6893o[i] = new AbstractC1079g(this, this.f6885g + (this.f6890l * i)) { // from class: com.c.a.d.a.a.1

                        /* renamed from: a */
                        private final C3336a f6895a;

                        /* renamed from: b */
                        private final long f6896b;

                        {
                            this.f6895a = this;
                            this.f6896b = r2;
                        }
                    };
                }
            }

            @Override // com.p122c.p123a.InterfaceC1077e
            /* renamed from: a */
            public short mo9001a() {
                return this.f6880b;
            }

            @Override // com.p122c.p123a.InterfaceC1077e
            /* renamed from: b */
            public short mo9002b() {
                return this.f6881c;
            }
        }

        /* renamed from: a */
        int m8996a(byte[] bArr) {
            try {
                return this.f6875b.mo8986a(bArr);
            } catch (IOException e2) {
                throw new C1074b(e2);
            }
        }

        /* renamed from: e */
        short m8999e() {
            try {
                switch (this.f6877d[5]) {
                    case 1:
                        return m8997a(this.f6875b.mo8987a());
                    case 2:
                        return this.f6875b.mo8987a();
                    default:
                        throw new C1074b("Invalid encoding.");
                }
            } catch (IOException e2) {
                throw new C1074b(e2);
            }
        }

        /* renamed from: f */
        int m9000f() {
            try {
                switch (this.f6877d[5]) {
                    case 1:
                        return m8995a(this.f6875b.mo8988b());
                    case 2:
                        return this.f6875b.mo8988b();
                    default:
                        throw new C1074b("Invalid encoding.");
                }
            } catch (IOException e2) {
                throw new C1074b(e2);
            }
        }

        /* renamed from: a */
        short m8997a(short s) {
            return (short) ((s << 8) | ((s >>> 8) & 255));
        }

        /* renamed from: a */
        int m8995a(int i) {
            return (m8997a((short) i) << 16) | (m8997a((short) (i >>> 16)) & 65535);
        }
    }
}
