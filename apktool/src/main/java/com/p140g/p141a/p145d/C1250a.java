package com.p140g.p141a.p145d;

import com.p140g.p141a.C1249d;
import com.p140g.p141a.EnumC1301h;
import com.p140g.p141a.p151g.C1294b;
import com.p140g.p141a.p151g.InterfaceC1293a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DexAnnotationNode.java */
/* renamed from: com.g.a.d.a */
/* loaded from: classes.dex */
public class C1250a extends C1294b {

    /* renamed from: a */
    public List<b> f8089a = new ArrayList(5);

    /* renamed from: b */
    public String f8090b;

    /* renamed from: c */
    public EnumC1301h f8091c;

    /* compiled from: DexAnnotationNode.java */
    /* renamed from: com.g.a.d.a$a */
    private static abstract class a extends C1294b {

        /* renamed from: a */
        List<Object> f8096a = new ArrayList();

        @Override // com.p140g.p141a.p151g.C1294b
        /* renamed from: a */
        public void mo10343a(String str, Object obj) {
            this.f8096a.add(obj);
        }

        @Override // com.p140g.p141a.p151g.C1294b
        /* renamed from: a */
        public C1294b mo10341a(String str, String str2) {
            C1250a c1250a = new C1250a(str2, EnumC1301h.RUNTIME);
            this.f8096a.add(c1250a);
            return c1250a;
        }

        @Override // com.p140g.p141a.p151g.C1294b
        /* renamed from: a */
        public C1294b mo10340a(String str) {
            return new a(this) { // from class: com.g.a.d.a.a.1

                /* renamed from: b */
                private final a f8097b;

                {
                    this.f8097b = this;
                }

                @Override // com.p140g.p141a.p145d.C1250a.a, com.p140g.p141a.p151g.C1294b
                /* renamed from: a */
                public void mo10345a() {
                    this.f8097b.f8096a.add(this.f8096a.toArray());
                    super.mo10345a();
                }
            };
        }

        @Override // com.p140g.p141a.p151g.C1294b
        /* renamed from: a */
        public void mo10345a() {
            this.f8096a = (List) null;
            super.mo10345a();
        }

        @Override // com.p140g.p141a.p151g.C1294b
        /* renamed from: a */
        public void mo10344a(String str, String str2, String str3) {
            this.f8096a.add(new C1249d((String) null, str3, str2));
        }
    }

    /* compiled from: DexAnnotationNode.java */
    /* renamed from: com.g.a.d.a$b */
    public static class b {

        /* renamed from: a */
        public String f8098a;

        /* renamed from: b */
        public Object f8099b;

        public b(String str, Object obj) {
            this.f8098a = str;
            this.f8099b = obj;
        }
    }

    /* renamed from: a */
    public static void m10339a(C1294b c1294b, String str, Object obj) {
        if (obj instanceof Object[]) {
            C1294b mo10340a = c1294b.mo10340a(str);
            if (mo10340a != null) {
                Object[] objArr = (Object[]) obj;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < objArr.length) {
                        m10339a(mo10340a, (String) null, objArr[i2]);
                        i = i2 + 1;
                    } else {
                        mo10340a.mo10345a();
                        return;
                    }
                }
            }
        } else {
            if (obj instanceof C1250a) {
                C1250a c1250a = (C1250a) obj;
                C1294b mo10341a = c1294b.mo10341a(str, c1250a.f8090b);
                if (mo10341a != null) {
                    for (b bVar : c1250a.f8089a) {
                        m10339a(mo10341a, bVar.f8098a, bVar.f8099b);
                    }
                    mo10341a.mo10345a();
                    return;
                }
                return;
            }
            if (obj instanceof C1249d) {
                C1249d c1249d = (C1249d) obj;
                c1294b.mo10344a(str, c1249d.m10338c(), c1249d.m10336a());
            } else {
                c1294b.mo10343a(str, obj);
            }
        }
    }

    public C1250a(String str, EnumC1301h enumC1301h) {
        this.f8090b = str;
        this.f8091c = enumC1301h;
    }

    /* renamed from: a */
    public void m10342a(InterfaceC1293a interfaceC1293a) {
        C1294b mo10353a = interfaceC1293a.mo10353a(this.f8090b, this.f8091c);
        if (mo10353a != null) {
            for (b bVar : this.f8089a) {
                m10339a(mo10353a, bVar.f8098a, bVar.f8099b);
            }
            mo10353a.mo10345a();
        }
    }

    @Override // com.p140g.p141a.p151g.C1294b
    /* renamed from: a */
    public void mo10343a(String str, Object obj) {
        this.f8089a.add(new b(str, obj));
    }

    @Override // com.p140g.p141a.p151g.C1294b
    /* renamed from: a */
    public C1294b mo10341a(String str, String str2) {
        C1250a c1250a = new C1250a(str2, EnumC1301h.RUNTIME);
        this.f8089a.add(new b(str, c1250a));
        return c1250a;
    }

    @Override // com.p140g.p141a.p151g.C1294b
    /* renamed from: a */
    public C1294b mo10340a(String str) {
        return new a(this, str) { // from class: com.g.a.d.a.1

            /* renamed from: b */
            private final C1250a f8092b;

            /* renamed from: c */
            private final String f8093c;

            {
                this.f8092b = this;
                this.f8093c = str;
            }

            @Override // com.p140g.p141a.p145d.C1250a.a, com.p140g.p141a.p151g.C1294b
            /* renamed from: a */
            public void mo10345a() {
                this.f8092b.f8089a.add(new b(this.f8093c, this.f8096a.toArray()));
                super.mo10345a();
            }
        };
    }

    @Override // com.p140g.p141a.p151g.C1294b
    /* renamed from: a */
    public void mo10344a(String str, String str2, String str3) {
        this.f8089a.add(new b(str, new C1249d(str2, str3, str2)));
    }
}
