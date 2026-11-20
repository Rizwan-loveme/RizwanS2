package com.p140g.p141a.p145d;

import com.p140g.p141a.C1238b;
import com.p140g.p141a.p151g.C1297e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: DexDebugNode.java */
/* renamed from: com.g.a.d.d */
/* loaded from: classes.dex */
public class C1275d extends C1297e {

    /* renamed from: a */
    public List<a> f8151a = new ArrayList();

    /* renamed from: b */
    public List<String> f8152b;

    /* renamed from: c */
    public String f8153c;

    /* renamed from: a */
    protected void m10384a(a aVar) {
        this.f8151a.add(aVar);
    }

    @Override // com.p140g.p141a.p151g.C1297e
    /* renamed from: a */
    public void mo10386a(String str) {
        this.f8153c = str;
    }

    @Override // com.p140g.p141a.p151g.C1297e
    /* renamed from: a */
    public void mo10380a(int i, C1238b c1238b) {
        m10384a(new a.e(c1238b, i));
    }

    @Override // com.p140g.p141a.p151g.C1297e
    /* renamed from: a */
    public void mo10382a(int i, String str) {
        if (this.f8152b == null) {
            this.f8152b = new ArrayList();
        }
        while (this.f8152b.size() <= i) {
            this.f8152b.add((String) null);
        }
        this.f8152b.set(i, str);
    }

    @Override // com.p140g.p141a.p151g.C1297e
    /* renamed from: b */
    public void mo10387b(int i, C1238b c1238b) {
        m10384a(new a.c(c1238b, i));
    }

    @Override // com.p140g.p141a.p151g.C1297e
    /* renamed from: a */
    public void mo10381a(int i, C1238b c1238b, String str, String str2, String str3) {
        m10384a(new a.f(c1238b, i, str, str2, str3));
    }

    @Override // com.p140g.p141a.p151g.C1297e
    /* renamed from: c */
    public void mo10389c(int i, C1238b c1238b) {
        m10384a(new a.C3342a(c1238b, i));
    }

    /* renamed from: a */
    public void m10385a(C1297e c1297e) {
        if (this.f8152b != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f8152b.size()) {
                    break;
                }
                String str = this.f8152b.get(i2);
                if (str != null) {
                    c1297e.mo10382a(i2, str);
                }
                i = i2 + 1;
            }
        }
        if (this.f8151a != null) {
            Iterator<a> it = this.f8151a.iterator();
            while (it.hasNext()) {
                it.next().mo10390a(c1297e);
            }
        }
        if (this.f8153c != null) {
            c1297e.mo10386a(this.f8153c);
        }
    }

    @Override // com.p140g.p141a.p151g.C1297e
    /* renamed from: a */
    public void mo10383a(C1238b c1238b) {
        m10384a(new a.d(c1238b));
    }

    @Override // com.p140g.p141a.p151g.C1297e
    /* renamed from: b */
    public void mo10388b(C1238b c1238b) {
        m10384a(new a.b(c1238b));
    }

    /* compiled from: DexDebugNode.java */
    /* renamed from: com.g.a.d.d$a */
    public static abstract class a {

        /* renamed from: a */
        public C1238b f8154a;

        /* renamed from: a */
        public abstract void mo10390a(C1297e c1297e);

        protected a(C1238b c1238b) {
            this.f8154a = c1238b;
        }

        /* compiled from: DexDebugNode.java */
        /* renamed from: com.g.a.d.d$a$f */
        public static class f extends a {

            /* renamed from: b */
            public int f8158b;

            /* renamed from: c */
            public String f8159c;

            /* renamed from: d */
            public String f8160d;

            /* renamed from: e */
            public String f8161e;

            public f(C1238b c1238b, int i, String str, String str2, String str3) {
                super(c1238b);
                this.f8158b = i;
                this.f8159c = str;
                this.f8160d = str2;
                this.f8161e = str3;
            }

            @Override // com.p140g.p141a.p145d.C1275d.a
            /* renamed from: a */
            public void mo10390a(C1297e c1297e) {
                c1297e.mo10381a(this.f8158b, this.f8154a, this.f8159c, this.f8160d, this.f8161e);
            }
        }

        /* compiled from: DexDebugNode.java */
        /* renamed from: com.g.a.d.d$a$a, reason: collision with other inner class name */
        public static class C3342a extends a {

            /* renamed from: b */
            public int f8155b;

            public C3342a(C1238b c1238b, int i) {
                super(c1238b);
                this.f8155b = i;
            }

            @Override // com.p140g.p141a.p145d.C1275d.a
            /* renamed from: a */
            public void mo10390a(C1297e c1297e) {
                c1297e.mo10389c(this.f8155b, this.f8154a);
            }
        }

        /* compiled from: DexDebugNode.java */
        /* renamed from: com.g.a.d.d$a$b */
        public static class b extends a {
            public b(C1238b c1238b) {
                super(c1238b);
            }

            @Override // com.p140g.p141a.p145d.C1275d.a
            /* renamed from: a */
            public void mo10390a(C1297e c1297e) {
                c1297e.mo10388b(this.f8154a);
            }
        }

        /* compiled from: DexDebugNode.java */
        /* renamed from: com.g.a.d.d$a$d */
        public static class d extends a {
            public d(C1238b c1238b) {
                super(c1238b);
            }

            @Override // com.p140g.p141a.p145d.C1275d.a
            /* renamed from: a */
            public void mo10390a(C1297e c1297e) {
                c1297e.mo10383a(this.f8154a);
            }
        }

        /* compiled from: DexDebugNode.java */
        /* renamed from: com.g.a.d.d$a$e */
        public static class e extends a {

            /* renamed from: b */
            public int f8157b;

            public e(C1238b c1238b, int i) {
                super(c1238b);
                this.f8157b = i;
            }

            @Override // com.p140g.p141a.p145d.C1275d.a
            /* renamed from: a */
            public void mo10390a(C1297e c1297e) {
                c1297e.mo10380a(this.f8157b, this.f8154a);
            }
        }

        /* compiled from: DexDebugNode.java */
        /* renamed from: com.g.a.d.d$a$c */
        public static class c extends a {

            /* renamed from: b */
            public int f8156b;

            public c(C1238b c1238b, int i) {
                super(c1238b);
                this.f8156b = i;
            }

            @Override // com.p140g.p141a.p145d.C1275d.a
            /* renamed from: a */
            public void mo10390a(C1297e c1297e) {
                c1297e.mo10387b(this.f8156b, this.f8154a);
            }
        }
    }
}
