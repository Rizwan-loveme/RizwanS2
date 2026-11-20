package org.p226d.p227a.p228a;

import org.p226d.p233b.p263h.C2391k;
import org.p226d.p269d.C2453g;
import org.p226d.p269d.C2457k;

/* compiled from: SyntheticAccessCommentMethodItem.java */
/* renamed from: org.d.a.a.q */
/* loaded from: classes.dex */
public class C1949q extends AbstractC1944l {

    /* renamed from: a */
    private final C2391k.a f11354a;

    public C1949q(C2391k.a aVar, int i) {
        super(i);
        this.f11354a = aVar;
    }

    @Override // org.p226d.p227a.p228a.AbstractC1944l
    /* renamed from: a */
    public double mo14091a() {
        return 99.8d;
    }

    @Override // org.p226d.p227a.p228a.AbstractC1944l
    /* renamed from: a */
    public boolean mo14089a(C2457k c2457k) {
        int i;
        c2457k.write("# ");
        switch (this.f11354a.f12757a) {
            case 0:
                c2457k.write("invokes: ");
                break;
            case 1:
                c2457k.write("getter for: ");
                break;
            case 2:
                c2457k.write("setter for: ");
                break;
            case 3:
                c2457k.write("operator++ for: ");
                break;
            case 4:
                c2457k.write("++operator for: ");
                break;
            case 5:
                c2457k.write("operator-- for: ");
                break;
            case 6:
                c2457k.write("--operator for: ");
                break;
            case 7:
                c2457k.write("+= operator for: ");
                break;
            case 8:
                c2457k.write("-= operator for: ");
                break;
            case 9:
                c2457k.write("*= operator for: ");
                break;
            case 10:
                c2457k.write("/= operator for: ");
                break;
            case 11:
                c2457k.write("%= operator for: ");
                break;
            case 12:
                c2457k.write("&= operator for: ");
                break;
            case 13:
                c2457k.write("|= operator for: ");
                break;
            case 14:
                c2457k.write("^= operator for: ");
                break;
            case 15:
                c2457k.write("<<= operator for: ");
                break;
            case 16:
                c2457k.write(">>= operator for: ");
                break;
            case 17:
                c2457k.write(">>>= operator for: ");
                break;
            default:
                throw new C2453g("Unknown access type: %d", Integer.valueOf(this.f11354a.f12757a));
        }
        if (this.f11354a.f12757a == 0) {
            i = 3;
        } else {
            i = 2;
        }
        C1947o.m14169a(c2457k, i, this.f11354a.f12758b);
        return true;
    }
}
