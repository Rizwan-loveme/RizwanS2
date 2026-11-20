package org.p271f.p272a.p275c;

import java.util.Arrays;
import java.util.List;
import org.p271f.p272a.AbstractC2526r;

/* compiled from: FrameNode.java */
/* renamed from: org.f.a.c.d */
/* loaded from: classes.dex */
public class C2489d extends AbstractC2486a {

    /* renamed from: g */
    public int f13005g;

    /* renamed from: h */
    public List<Object> f13006h;

    /* renamed from: i */
    public List<Object> f13007i;

    private C2489d() {
        super(-1);
    }

    public C2489d(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        super(-1);
        this.f13005g = i;
        switch (i) {
            case -1:
            case 0:
                this.f13006h = m15724a(i2, objArr);
                this.f13007i = m15724a(i3, objArr2);
                break;
            case 1:
                this.f13006h = m15724a(i2, objArr);
                break;
            case 2:
                this.f13006h = Arrays.asList(new Object[i2]);
                break;
            case 4:
                this.f13007i = m15724a(1, objArr2);
                break;
        }
    }

    @Override // org.p271f.p272a.p275c.AbstractC2486a
    /* renamed from: a */
    public void mo15719a(AbstractC2526r abstractC2526r) {
        switch (this.f13005g) {
            case -1:
            case 0:
                abstractC2526r.mo15644a(this.f13005g, this.f13006h.size(), m15725a(this.f13006h), this.f13007i.size(), m15725a(this.f13007i));
                break;
            case 1:
                abstractC2526r.mo15644a(this.f13005g, this.f13006h.size(), m15725a(this.f13006h), 0, (Object[]) null);
                break;
            case 2:
                abstractC2526r.mo15644a(this.f13005g, this.f13006h.size(), (Object[]) null, 0, (Object[]) null);
                break;
            case 3:
                abstractC2526r.mo15644a(this.f13005g, 0, (Object[]) null, 0, (Object[]) null);
                break;
            case 4:
                abstractC2526r.mo15644a(this.f13005g, 0, (Object[]) null, 1, m15725a(this.f13007i));
                break;
        }
    }

    /* renamed from: a */
    private static List<Object> m15724a(int i, Object[] objArr) {
        return Arrays.asList(objArr).subList(0, i);
    }

    /* renamed from: a */
    private static Object[] m15725a(List<Object> list) {
        Object[] objArr = new Object[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < objArr.length) {
                Object obj = list.get(i2);
                if (obj instanceof C2497l) {
                    obj = ((C2497l) obj).m15734c();
                }
                objArr[i2] = obj;
                i = i2 + 1;
            } else {
                return objArr;
            }
        }
    }
}
