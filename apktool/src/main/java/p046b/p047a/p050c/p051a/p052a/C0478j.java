package p046b.p047a.p050c.p051a.p052a;

import java.util.Arrays;
import java.util.Comparator;
import org.xmlpull.p291v1.XmlSerializer;
import p046b.p047a.p050c.p051a.C0494e;
import p046b.p059d.C0538c;
import p046b.p059d.InterfaceC0541f;

/* compiled from: ResFlagsAttr.java */
/* renamed from: b.a.c.a.a.j */
/* loaded from: classes.dex */
public class C0478j extends C0470b {

    /* renamed from: b */
    private final a[] f3389b;

    /* renamed from: c */
    private a[] f3390c;

    /* renamed from: d */
    private a[] f3391d;

    C0478j(C0485q c0485q, int i, Integer num, Integer num2, Boolean bool, C0538c<C0485q, C0483o>[] c0538cArr, boolean z, InterfaceC0541f interfaceC0541f) {
        super(c0485q, i, num, num2, bool, z, interfaceC0541f);
        this.f3389b = new a[c0538cArr.length];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= c0538cArr.length) {
                return;
            }
            this.f3389b[i3] = new a(c0538cArr[i3].f3632a, c0538cArr[i3].f3633b.m3643b());
            i2 = i3 + 1;
        }
    }

    @Override // p046b.p047a.p050c.p051a.p052a.C0470b
    /* renamed from: a */
    public String mo3629a(AbstractC0486r abstractC0486r) {
        int i = 0;
        if (abstractC0486r instanceof C0485q) {
            return abstractC0486r.mo3632a();
        }
        if (!(abstractC0486r instanceof C0483o)) {
            return super.mo3629a(abstractC0486r);
        }
        m3639c();
        int m3643b = ((C0483o) abstractC0486r).m3643b();
        if (m3643b == 0) {
            return m3637a(this.f3390c);
        }
        a[] aVarArr = new a[this.f3391d.length];
        int[] iArr = new int[this.f3391d.length];
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < this.f3391d.length) {
                a aVar = this.f3391d[i2];
                int i4 = aVar.f3394b;
                if ((m3643b & i4) != i4) {
                    i = i3;
                } else if (m3638a(i4, iArr)) {
                    i = i3;
                } else {
                    iArr[i3] = i4;
                    i = i3 + 1;
                    aVarArr[i3] = aVar;
                }
                i2++;
            } else {
                return m3637a((a[]) Arrays.copyOf(aVarArr, i3));
            }
        }
    }

    @Override // p046b.p047a.p050c.p051a.p052a.C0470b
    /* renamed from: b */
    protected void mo3631b(XmlSerializer xmlSerializer, C0494e c0494e) {
        for (int i = 0; i < this.f3389b.length; i++) {
            a aVar = this.f3389b[i];
            xmlSerializer.startTag((String) null, "flag");
            xmlSerializer.attribute((String) null, "name", aVar.m3641a());
            xmlSerializer.attribute((String) null, "value", String.format("0x%08x", new Integer(aVar.f3394b)));
            xmlSerializer.endTag((String) null, "flag");
        }
    }

    /* renamed from: a */
    private boolean m3638a(int i, int[] iArr) {
        for (int i2 : iArr) {
            if ((i2 & i) == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private String m3637a(a[] aVarArr) {
        String str = "";
        for (a aVar : aVarArr) {
            str = new StringBuffer().append(str).append(new StringBuffer().append("|").append(aVar.m3641a()).toString()).toString();
        }
        return str.isEmpty() ? str : str.substring(1);
    }

    /* renamed from: c */
    private void m3639c() {
        int i;
        if (this.f3391d == null) {
            a[] aVarArr = new a[this.f3389b.length];
            a[] aVarArr2 = new a[this.f3389b.length];
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i2 < this.f3389b.length) {
                a aVar = this.f3389b[i2];
                if (aVar.f3394b == 0) {
                    aVarArr[i4] = aVar;
                    i = i3;
                    i4++;
                } else {
                    i = i3 + 1;
                    aVarArr2[i3] = aVar;
                }
                i2++;
                i3 = i;
            }
            this.f3390c = (a[]) Arrays.copyOf(aVarArr, i4);
            this.f3391d = (a[]) Arrays.copyOf(aVarArr2, i3);
            Arrays.sort(this.f3391d, new Comparator<a>(this) { // from class: b.a.c.a.a.j.1

                /* renamed from: a */
                private final C0478j f3392a;

                {
                    this.f3392a = this;
                }

                @Override // java.util.Comparator
                public int compare(a aVar2, a aVar3) {
                    return m3640a(aVar2, aVar3);
                }

                /* renamed from: a */
                public int m3640a(a aVar2, a aVar3) {
                    return Integer.valueOf(Integer.bitCount(aVar3.f3394b)).compareTo(new Integer(Integer.bitCount(aVar2.f3394b)));
                }
            });
        }
    }

    /* compiled from: ResFlagsAttr.java */
    /* renamed from: b.a.c.a.a.j$a */
    private static class a {

        /* renamed from: a */
        public final C0485q f3393a;

        /* renamed from: b */
        public final int f3394b;

        /* renamed from: c */
        public String f3395c;

        public a(C0485q c0485q, int i) {
            this.f3393a = c0485q;
            this.f3394b = i;
        }

        /* renamed from: a */
        public String m3641a() {
            if (this.f3395c == null) {
                if (this.f3393a.m3647f()) {
                    this.f3395c = new StringBuffer().append("flag_").append(String.format("%08x", new Integer(this.f3393a.m3642d()))).toString();
                } else {
                    this.f3395c = this.f3393a.m3645c().m3693e();
                }
            }
            return this.f3395c;
        }
    }
}
