package com.p065b.p086b.p100d.p101a;

import com.p065b.p086b.p100d.C0905m;
import com.p065b.p086b.p100d.EnumC0903k;
import com.p065b.p086b.p110h.C1018i;
import com.p065b.p086b.p110h.C1022m;

/* compiled from: InstructionCodec.java */
/* renamed from: com.b.b.d.a.j */
/* loaded from: classes.dex */
public enum EnumC0884j {
    FORMAT_00X { // from class: com.b.b.d.a.j.1
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return new C0893s(this, i, 0, null, 0, 0L);
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            interfaceC0879e.mo7456a(abstractC0880f.m7474c());
        }
    },
    FORMAT_10X { // from class: com.b.b.d.a.j.12
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return new C0893s(this, EnumC0884j.m7529k(i), 0, null, 0, EnumC0884j.m7530l(i));
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            interfaceC0879e.mo7456a(abstractC0880f.m7474c());
        }
    },
    FORMAT_12X { // from class: com.b.b.d.a.j.23
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return new C0892r(this, EnumC0884j.m7529k(i), 0, null, 0, 0L, EnumC0884j.m7533o(i), EnumC0884j.m7534p(i));
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            interfaceC0879e.mo7456a(EnumC0884j.m7510c(abstractC0880f.m7474c(), EnumC0884j.m7514d(abstractC0880f.mo7486n(), abstractC0880f.mo7487o())));
        }
    },
    FORMAT_11N { // from class: com.b.b.d.a.j.34
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return new C0885k(this, EnumC0884j.m7529k(i), 0, null, 0, (EnumC0884j.m7534p(i) << 28) >> 28, EnumC0884j.m7533o(i));
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            interfaceC0879e.mo7456a(EnumC0884j.m7510c(abstractC0880f.m7474c(), EnumC0884j.m7514d(abstractC0880f.mo7486n(), abstractC0880f.m7484l())));
        }
    },
    FORMAT_11X { // from class: com.b.b.d.a.j.36
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return new C0885k(this, EnumC0884j.m7529k(i), 0, null, 0, 0L, EnumC0884j.m7530l(i));
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            interfaceC0879e.mo7456a(EnumC0884j.m7510c(abstractC0880f.m7471b(), abstractC0880f.mo7486n()));
        }
    },
    FORMAT_10T { // from class: com.b.b.d.a.j.37
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return new C0893s(this, EnumC0884j.m7529k(i), 0, null, ((byte) EnumC0884j.m7530l(i)) + (interfaceC0878d.mo7449a() - 1), 0L);
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            interfaceC0879e.mo7456a(EnumC0884j.m7510c(abstractC0880f.m7471b(), abstractC0880f.m7473c(interfaceC0879e.mo7449a())));
        }
    },
    FORMAT_20T { // from class: com.b.b.d.a.j.38
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return new C0893s(this, EnumC0884j.m7529k(i), 0, null, ((short) interfaceC0878d.mo7453c()) + (interfaceC0878d.mo7449a() - 1), EnumC0884j.m7530l(i));
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            interfaceC0879e.mo7457a(abstractC0880f.m7474c(), abstractC0880f.m7472b(interfaceC0879e.mo7449a()));
        }
    },
    FORMAT_20BC { // from class: com.b.b.d.a.j.39
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return new C0893s(this, EnumC0884j.m7529k(i), interfaceC0878d.mo7453c(), EnumC0903k.VARIES, 0, EnumC0884j.m7530l(i));
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            interfaceC0879e.mo7457a(EnumC0884j.m7510c(abstractC0880f.m7471b(), abstractC0880f.m7483k()), abstractC0880f.m7477e());
        }
    },
    FORMAT_22X { // from class: com.b.b.d.a.j.40
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return new C0892r(this, EnumC0884j.m7529k(i), 0, null, 0, 0L, EnumC0884j.m7530l(i), interfaceC0878d.mo7453c());
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            interfaceC0879e.mo7457a(EnumC0884j.m7510c(abstractC0880f.m7471b(), abstractC0880f.mo7486n()), abstractC0880f.m7493u());
        }
    },
    FORMAT_21T { // from class: com.b.b.d.a.j.2
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return new C0885k(this, EnumC0884j.m7529k(i), 0, null, ((short) interfaceC0878d.mo7453c()) + (interfaceC0878d.mo7449a() - 1), 0L, EnumC0884j.m7530l(i));
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            interfaceC0879e.mo7457a(EnumC0884j.m7510c(abstractC0880f.m7471b(), abstractC0880f.mo7486n()), abstractC0880f.m7472b(interfaceC0879e.mo7449a()));
        }
    },
    FORMAT_21S { // from class: com.b.b.d.a.j.3
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return new C0885k(this, EnumC0884j.m7529k(i), 0, null, 0, (short) interfaceC0878d.mo7453c(), EnumC0884j.m7530l(i));
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            interfaceC0879e.mo7457a(EnumC0884j.m7510c(abstractC0880f.m7471b(), abstractC0880f.mo7486n()), abstractC0880f.m7482j());
        }
    },
    FORMAT_21H { // from class: com.b.b.d.a.j.4
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            int m7529k = EnumC0884j.m7529k(i);
            return new C0885k(this, m7529k, 0, null, 0, ((short) interfaceC0878d.mo7453c()) << (m7529k == 21 ? (char) 16 : '0'), EnumC0884j.m7530l(i));
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            int m7471b = abstractC0880f.m7471b();
            interfaceC0879e.mo7457a(EnumC0884j.m7510c(m7471b, abstractC0880f.mo7486n()), (short) (abstractC0880f.m7480h() >> (m7471b == 21 ? (char) 16 : '0')));
        }
    },
    FORMAT_21C { // from class: com.b.b.d.a.j.5
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            int m7529k = EnumC0884j.m7529k(i);
            return new C0885k(this, m7529k, interfaceC0878d.mo7453c(), C0905m.m7688d(m7529k), 0, 0L, EnumC0884j.m7530l(i));
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            interfaceC0879e.mo7457a(EnumC0884j.m7510c(abstractC0880f.m7471b(), abstractC0880f.mo7486n()), abstractC0880f.m7477e());
        }
    },
    FORMAT_23X { // from class: com.b.b.d.a.j.6
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            int m7529k = EnumC0884j.m7529k(i);
            int m7530l = EnumC0884j.m7530l(i);
            int mo7453c = interfaceC0878d.mo7453c();
            return new C0891q(this, m7529k, 0, null, 0, 0L, m7530l, EnumC0884j.m7529k(mo7453c), EnumC0884j.m7530l(mo7453c));
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            interfaceC0879e.mo7457a(EnumC0884j.m7510c(abstractC0880f.m7471b(), abstractC0880f.mo7486n()), EnumC0884j.m7510c(abstractC0880f.mo7487o(), abstractC0880f.mo7488p()));
        }
    },
    FORMAT_22B { // from class: com.b.b.d.a.j.7
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return new C0892r(this, EnumC0884j.m7529k(i), 0, null, 0, (byte) EnumC0884j.m7530l(r0), EnumC0884j.m7530l(i), EnumC0884j.m7529k(interfaceC0878d.mo7453c()));
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            interfaceC0879e.mo7457a(EnumC0884j.m7510c(abstractC0880f.m7471b(), abstractC0880f.mo7486n()), EnumC0884j.m7510c(abstractC0880f.mo7487o(), abstractC0880f.m7483k()));
        }
    },
    FORMAT_22T { // from class: com.b.b.d.a.j.8
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return new C0892r(this, EnumC0884j.m7529k(i), 0, null, ((short) interfaceC0878d.mo7453c()) + (interfaceC0878d.mo7449a() - 1), 0L, EnumC0884j.m7533o(i), EnumC0884j.m7534p(i));
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            interfaceC0879e.mo7457a(EnumC0884j.m7510c(abstractC0880f.m7471b(), EnumC0884j.m7514d(abstractC0880f.mo7486n(), abstractC0880f.mo7487o())), abstractC0880f.m7472b(interfaceC0879e.mo7449a()));
        }
    },
    FORMAT_22S { // from class: com.b.b.d.a.j.9
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return new C0892r(this, EnumC0884j.m7529k(i), 0, null, 0, (short) interfaceC0878d.mo7453c(), EnumC0884j.m7533o(i), EnumC0884j.m7534p(i));
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            interfaceC0879e.mo7457a(EnumC0884j.m7510c(abstractC0880f.m7471b(), EnumC0884j.m7514d(abstractC0880f.mo7486n(), abstractC0880f.mo7487o())), abstractC0880f.m7482j());
        }
    },
    FORMAT_22C { // from class: com.b.b.d.a.j.10
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            int m7529k = EnumC0884j.m7529k(i);
            return new C0892r(this, m7529k, interfaceC0878d.mo7453c(), C0905m.m7688d(m7529k), 0, 0L, EnumC0884j.m7533o(i), EnumC0884j.m7534p(i));
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            interfaceC0879e.mo7457a(EnumC0884j.m7510c(abstractC0880f.m7471b(), EnumC0884j.m7514d(abstractC0880f.mo7486n(), abstractC0880f.mo7487o())), abstractC0880f.m7477e());
        }
    },
    FORMAT_22CS { // from class: com.b.b.d.a.j.11
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return new C0892r(this, EnumC0884j.m7529k(i), interfaceC0878d.mo7453c(), EnumC0903k.FIELD_OFFSET, 0, 0L, EnumC0884j.m7533o(i), EnumC0884j.m7534p(i));
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            interfaceC0879e.mo7457a(EnumC0884j.m7510c(abstractC0880f.m7471b(), EnumC0884j.m7514d(abstractC0880f.mo7486n(), abstractC0880f.mo7487o())), abstractC0880f.m7477e());
        }
    },
    FORMAT_30T { // from class: com.b.b.d.a.j.13
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return new C0893s(this, EnumC0884j.m7529k(i), 0, null, interfaceC0878d.mo7454d() + (interfaceC0878d.mo7449a() - 1), EnumC0884j.m7530l(i));
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            int m7468a = abstractC0880f.m7468a(interfaceC0879e.mo7449a());
            interfaceC0879e.mo7458a(abstractC0880f.m7474c(), EnumC0884j.m7527i(m7468a), EnumC0884j.m7528j(m7468a));
        }
    },
    FORMAT_32X { // from class: com.b.b.d.a.j.14
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return new C0892r(this, EnumC0884j.m7529k(i), 0, null, 0, EnumC0884j.m7530l(i), interfaceC0878d.mo7453c(), interfaceC0878d.mo7453c());
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            interfaceC0879e.mo7458a(abstractC0880f.m7474c(), abstractC0880f.m7492t(), abstractC0880f.m7493u());
        }
    },
    FORMAT_31I { // from class: com.b.b.d.a.j.15
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return new C0885k(this, EnumC0884j.m7529k(i), 0, null, 0, interfaceC0878d.mo7454d(), EnumC0884j.m7530l(i));
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            int m7481i = abstractC0880f.m7481i();
            interfaceC0879e.mo7458a(EnumC0884j.m7510c(abstractC0880f.m7471b(), abstractC0880f.mo7486n()), EnumC0884j.m7527i(m7481i), EnumC0884j.m7528j(m7481i));
        }
    },
    FORMAT_31T { // from class: com.b.b.d.a.j.16
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            int a2 = interfaceC0878d.mo7449a() - 1;
            int m7529k = EnumC0884j.m7529k(i);
            int m7530l = EnumC0884j.m7530l(i);
            int mo7454d = a2 + interfaceC0878d.mo7454d();
            switch (m7529k) {
                case 43:
                case 44:
                    interfaceC0878d.mo7451a(mo7454d, a2);
                    break;
            }
            return new C0885k(this, m7529k, 0, null, mo7454d, 0L, m7530l);
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            int m7468a = abstractC0880f.m7468a(interfaceC0879e.mo7449a());
            interfaceC0879e.mo7458a(EnumC0884j.m7510c(abstractC0880f.m7471b(), abstractC0880f.mo7486n()), EnumC0884j.m7527i(m7468a), EnumC0884j.m7528j(m7468a));
        }
    },
    FORMAT_31C { // from class: com.b.b.d.a.j.17
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            int m7529k = EnumC0884j.m7529k(i);
            return new C0885k(this, m7529k, interfaceC0878d.mo7454d(), C0905m.m7688d(m7529k), 0, 0L, EnumC0884j.m7530l(i));
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            int m7475d = abstractC0880f.m7475d();
            interfaceC0879e.mo7458a(EnumC0884j.m7510c(abstractC0880f.m7471b(), abstractC0880f.mo7486n()), EnumC0884j.m7527i(m7475d), EnumC0884j.m7528j(m7475d));
        }
    },
    FORMAT_35C { // from class: com.b.b.d.a.j.18
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return EnumC0884j.m7509c(this, i, interfaceC0878d);
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            EnumC0884j.m7517d(abstractC0880f, interfaceC0879e);
        }
    },
    FORMAT_35MS { // from class: com.b.b.d.a.j.19
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return EnumC0884j.m7509c(this, i, interfaceC0878d);
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            EnumC0884j.m7517d(abstractC0880f, interfaceC0879e);
        }
    },
    FORMAT_35MI { // from class: com.b.b.d.a.j.20
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return EnumC0884j.m7509c(this, i, interfaceC0878d);
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            EnumC0884j.m7517d(abstractC0880f, interfaceC0879e);
        }
    },
    FORMAT_3RC { // from class: com.b.b.d.a.j.21
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return EnumC0884j.m7515d(this, i, interfaceC0878d);
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            EnumC0884j.m7520e(abstractC0880f, interfaceC0879e);
        }
    },
    FORMAT_3RMS { // from class: com.b.b.d.a.j.22
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return EnumC0884j.m7515d(this, i, interfaceC0878d);
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            EnumC0884j.m7520e(abstractC0880f, interfaceC0879e);
        }
    },
    FORMAT_3RMI { // from class: com.b.b.d.a.j.24
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return EnumC0884j.m7515d(this, i, interfaceC0878d);
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            EnumC0884j.m7520e(abstractC0880f, interfaceC0879e);
        }
    },
    FORMAT_51L { // from class: com.b.b.d.a.j.25
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return new C0885k(this, EnumC0884j.m7529k(i), 0, null, 0, interfaceC0878d.mo7455e(), EnumC0884j.m7530l(i));
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            long m7480h = abstractC0880f.m7480h();
            interfaceC0879e.mo7460a(EnumC0884j.m7510c(abstractC0880f.m7471b(), abstractC0880f.mo7486n()), EnumC0884j.m7519e(m7480h), EnumC0884j.m7522f(m7480h), EnumC0884j.m7524g(m7480h), EnumC0884j.m7526h(m7480h));
        }
    },
    FORMAT_33X { // from class: com.b.b.d.a.j.26
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            int mo7453c = interfaceC0878d.mo7453c();
            return new C0891q(this, i, 0, null, 0, 0L, EnumC0884j.m7529k(mo7453c), EnumC0884j.m7530l(mo7453c), interfaceC0878d.mo7453c());
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            interfaceC0879e.mo7458a(abstractC0880f.m7474c(), EnumC0884j.m7510c(abstractC0880f.mo7486n(), abstractC0880f.mo7487o()), abstractC0880f.m7494v());
        }
    },
    FORMAT_32S { // from class: com.b.b.d.a.j.27
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            int mo7453c = interfaceC0878d.mo7453c();
            return new C0892r(this, i, 0, null, 0, (short) interfaceC0878d.mo7453c(), EnumC0884j.m7529k(mo7453c), EnumC0884j.m7530l(mo7453c));
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            interfaceC0879e.mo7458a(abstractC0880f.m7474c(), EnumC0884j.m7510c(abstractC0880f.mo7486n(), abstractC0880f.mo7487o()), abstractC0880f.m7482j());
        }
    },
    FORMAT_40SC { // from class: com.b.b.d.a.j.28
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return new C0893s(this, i, interfaceC0878d.mo7454d(), EnumC0903k.VARIES, 0, interfaceC0878d.mo7453c());
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            int m7475d = abstractC0880f.m7475d();
            interfaceC0879e.mo7459a(abstractC0880f.m7474c(), EnumC0884j.m7527i(m7475d), EnumC0884j.m7528j(m7475d), abstractC0880f.m7482j());
        }
    },
    FORMAT_41C { // from class: com.b.b.d.a.j.29
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return new C0885k(this, i, interfaceC0878d.mo7454d(), C0905m.m7688d(i), 0, 0L, interfaceC0878d.mo7453c());
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            int m7475d = abstractC0880f.m7475d();
            interfaceC0879e.mo7459a(abstractC0880f.m7474c(), EnumC0884j.m7527i(m7475d), EnumC0884j.m7528j(m7475d), abstractC0880f.m7492t());
        }
    },
    FORMAT_52C { // from class: com.b.b.d.a.j.30
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            return new C0892r(this, i, interfaceC0878d.mo7454d(), C0905m.m7688d(i), 0, 0L, interfaceC0878d.mo7453c(), interfaceC0878d.mo7453c());
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            int m7475d = abstractC0880f.m7475d();
            interfaceC0879e.mo7460a(abstractC0880f.m7474c(), EnumC0884j.m7527i(m7475d), EnumC0884j.m7528j(m7475d), abstractC0880f.m7492t(), abstractC0880f.m7493u());
        }
    },
    FORMAT_5RC { // from class: com.b.b.d.a.j.31
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            int mo7454d = interfaceC0878d.mo7454d();
            int mo7453c = interfaceC0878d.mo7453c();
            return new C0887m(this, i, mo7454d, C0905m.m7688d(i), 0, 0L, interfaceC0878d.mo7453c(), mo7453c);
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            int m7475d = abstractC0880f.m7475d();
            interfaceC0879e.mo7460a(abstractC0880f.m7474c(), EnumC0884j.m7527i(m7475d), EnumC0884j.m7528j(m7475d), abstractC0880f.m7491s(), abstractC0880f.m7492t());
        }
    },
    FORMAT_PACKED_SWITCH_PAYLOAD { // from class: com.b.b.d.a.j.32
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            int b2 = interfaceC0878d.mo7452b() - 1;
            int mo7453c = interfaceC0878d.mo7453c();
            int mo7454d = interfaceC0878d.mo7454d();
            int[] iArr = new int[mo7453c];
            for (int i2 = 0; i2 < mo7453c; i2++) {
                iArr[i2] = interfaceC0878d.mo7454d() + b2;
            }
            return new C0886l(this, i, mo7454d, iArr);
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            C0886l c0886l = (C0886l) abstractC0880f;
            int[] m7538x = c0886l.m7538x();
            int b2 = interfaceC0879e.mo7452b();
            interfaceC0879e.mo7456a(c0886l.m7474c());
            interfaceC0879e.mo7456a(EnumC0884j.m7525h(m7538x.length));
            interfaceC0879e.mo7465a_(c0886l.m7537w());
            for (int i : m7538x) {
                interfaceC0879e.mo7465a_(i - b2);
            }
        }
    },
    FORMAT_SPARSE_SWITCH_PAYLOAD { // from class: com.b.b.d.a.j.33
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            int b2 = interfaceC0878d.mo7452b() - 1;
            int mo7453c = interfaceC0878d.mo7453c();
            int[] iArr = new int[mo7453c];
            int[] iArr2 = new int[mo7453c];
            for (int i2 = 0; i2 < mo7453c; i2++) {
                iArr[i2] = interfaceC0878d.mo7454d();
            }
            for (int i3 = 0; i3 < mo7453c; i3++) {
                iArr2[i3] = interfaceC0878d.mo7454d() + b2;
            }
            return new C0890p(this, i, iArr, iArr2);
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            C0890p c0890p = (C0890p) abstractC0880f;
            int[] m7542w = c0890p.m7542w();
            int[] m7543x = c0890p.m7543x();
            int b2 = interfaceC0879e.mo7452b();
            interfaceC0879e.mo7456a(c0890p.m7474c());
            interfaceC0879e.mo7456a(EnumC0884j.m7525h(m7543x.length));
            for (int i : m7542w) {
                interfaceC0879e.mo7465a_(i);
            }
            for (int i2 : m7543x) {
                interfaceC0879e.mo7465a_(i2 - b2);
            }
        }
    },
    FORMAT_FILL_ARRAY_DATA_PAYLOAD { // from class: com.b.b.d.a.j.35
        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d) {
            int i2 = 0;
            int mo7453c = interfaceC0878d.mo7453c();
            int mo7454d = interfaceC0878d.mo7454d();
            switch (mo7453c) {
                case 1:
                    byte[] bArr = new byte[mo7454d];
                    int i3 = 0;
                    int i4 = 0;
                    boolean z = true;
                    while (i4 < mo7454d) {
                        if (z) {
                            i3 = interfaceC0878d.mo7453c();
                        }
                        bArr[i4] = (byte) (i3 & 255);
                        i3 >>= 8;
                        i4++;
                        z = !z;
                    }
                    return new C0881g((EnumC0884j) this, i, bArr);
                case 2:
                    short[] sArr = new short[mo7454d];
                    while (i2 < mo7454d) {
                        sArr[i2] = (short) interfaceC0878d.mo7453c();
                        i2++;
                    }
                    return new C0881g((EnumC0884j) this, i, sArr);
                case 3:
                case 5:
                case 6:
                case 7:
                default:
                    throw new C1018i("bogus element_width: " + C1022m.m8557c(mo7453c));
                case 4:
                    int[] iArr = new int[mo7454d];
                    while (i2 < mo7454d) {
                        iArr[i2] = interfaceC0878d.mo7454d();
                        i2++;
                    }
                    return new C0881g((EnumC0884j) this, i, iArr);
                case 8:
                    long[] jArr = new long[mo7454d];
                    while (i2 < mo7454d) {
                        jArr[i2] = interfaceC0878d.mo7455e();
                        i2++;
                    }
                    return new C0881g(this, i, jArr);
            }
        }

        @Override // com.p065b.p086b.p100d.p101a.EnumC0884j
        /* renamed from: a */
        public void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
            C0881g c0881g = (C0881g) abstractC0880f;
            short m7495w = c0881g.m7495w();
            Object m7497y = c0881g.m7497y();
            interfaceC0879e.mo7456a(c0881g.m7474c());
            interfaceC0879e.mo7456a(m7495w);
            interfaceC0879e.mo7465a_(c0881g.m7496x());
            switch (m7495w) {
                case 1:
                    interfaceC0879e.mo7461a((byte[]) m7497y);
                    return;
                case 2:
                    interfaceC0879e.mo7464a((short[]) m7497y);
                    return;
                case 3:
                case 5:
                case 6:
                case 7:
                default:
                    throw new C1018i("bogus element_width: " + C1022m.m8557c(m7495w));
                case 4:
                    interfaceC0879e.mo7462a((int[]) m7497y);
                    return;
                case 8:
                    interfaceC0879e.mo7463a((long[]) m7497y);
                    return;
            }
        }
    };

    /* renamed from: a */
    public abstract AbstractC0880f mo7535a(int i, InterfaceC0878d interfaceC0878d);

    /* renamed from: a */
    public abstract void mo7536a(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static AbstractC0880f m7509c(EnumC0884j enumC0884j, int i, InterfaceC0878d interfaceC0878d) {
        int m7529k = m7529k(i);
        int m7533o = m7533o(i);
        int m7534p = m7534p(i);
        int mo7453c = interfaceC0878d.mo7453c();
        int mo7453c2 = interfaceC0878d.mo7453c();
        int m7531m = m7531m(mo7453c2);
        int m7532n = m7532n(mo7453c2);
        int m7533o2 = m7533o(mo7453c2);
        int m7534p2 = m7534p(mo7453c2);
        EnumC0903k m7688d = C0905m.m7688d(m7529k);
        switch (m7534p) {
            case 0:
                return new C0893s(enumC0884j, m7529k, mo7453c, m7688d, 0, 0L);
            case 1:
                return new C0885k(enumC0884j, m7529k, mo7453c, m7688d, 0, 0L, m7531m);
            case 2:
                return new C0892r(enumC0884j, m7529k, mo7453c, m7688d, 0, 0L, m7531m, m7532n);
            case 3:
                return new C0891q(enumC0884j, m7529k, mo7453c, m7688d, 0, 0L, m7531m, m7532n, m7533o2);
            case 4:
                return new C0883i(enumC0884j, m7529k, mo7453c, m7688d, 0, 0L, m7531m, m7532n, m7533o2, m7534p2);
            case 5:
                return new C0882h(enumC0884j, m7529k, mo7453c, m7688d, 0, 0L, m7531m, m7532n, m7533o2, m7534p2, m7533o);
            default:
                throw new C1018i("bogus registerCount: " + C1022m.m8560f(m7534p));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m7517d(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
        interfaceC0879e.mo7458a(m7510c(abstractC0880f.m7471b(), m7514d(abstractC0880f.mo7490r(), abstractC0880f.mo7485m())), abstractC0880f.m7477e(), m7501a(abstractC0880f.mo7486n(), abstractC0880f.mo7487o(), abstractC0880f.mo7488p(), abstractC0880f.mo7489q()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static AbstractC0880f m7515d(EnumC0884j enumC0884j, int i, InterfaceC0878d interfaceC0878d) {
        int m7529k = m7529k(i);
        int m7530l = m7530l(i);
        return new C0887m(enumC0884j, m7529k, interfaceC0878d.mo7453c(), C0905m.m7688d(m7529k), 0, 0L, interfaceC0878d.mo7453c(), m7530l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static void m7520e(AbstractC0880f abstractC0880f, InterfaceC0879e interfaceC0879e) {
        interfaceC0879e.mo7458a(m7510c(abstractC0880f.m7471b(), abstractC0880f.mo7485m()), abstractC0880f.m7477e(), abstractC0880f.m7492t());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static short m7510c(int i, int i2) {
        if ((i & (-256)) != 0) {
            throw new IllegalArgumentException("bogus lowByte");
        }
        if ((i2 & (-256)) != 0) {
            throw new IllegalArgumentException("bogus highByte");
        }
        return (short) ((i2 << 8) | i);
    }

    /* renamed from: a */
    private static short m7501a(int i, int i2, int i3, int i4) {
        if ((i & (-16)) != 0) {
            throw new IllegalArgumentException("bogus nibble0");
        }
        if ((i2 & (-16)) != 0) {
            throw new IllegalArgumentException("bogus nibble1");
        }
        if ((i3 & (-16)) != 0) {
            throw new IllegalArgumentException("bogus nibble2");
        }
        if ((i4 & (-16)) != 0) {
            throw new IllegalArgumentException("bogus nibble3");
        }
        return (short) ((i2 << 4) | i | (i3 << 8) | (i4 << 12));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static int m7514d(int i, int i2) {
        if ((i & (-16)) != 0) {
            throw new IllegalArgumentException("bogus lowNibble");
        }
        if ((i2 & (-16)) != 0) {
            throw new IllegalArgumentException("bogus highNibble");
        }
        return (i2 << 4) | i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static short m7525h(int i) {
        if (((-65536) & i) != 0) {
            throw new IllegalArgumentException("bogus unsigned code unit");
        }
        return (short) i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public static short m7527i(int i) {
        return (short) i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static short m7528j(int i) {
        return (short) (i >> 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static short m7519e(long j) {
        return (short) j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static short m7522f(long j) {
        return (short) (j >> 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static short m7524g(long j) {
        return (short) (j >> 32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static short m7526h(long j) {
        return (short) (j >> 48);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public static int m7529k(int i) {
        return i & 255;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static int m7530l(int i) {
        return (i >> 8) & 255;
    }

    /* renamed from: m */
    private static int m7531m(int i) {
        return i & 15;
    }

    /* renamed from: n */
    private static int m7532n(int i) {
        return (i >> 4) & 15;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public static int m7533o(int i) {
        return (i >> 8) & 15;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public static int m7534p(int i) {
        return (i >> 12) & 15;
    }
}
