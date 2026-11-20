package p165d.p167b.p173f;

import p165d.p167b.p172e.C1440c;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: ReasonFlags.java */
/* renamed from: d.b.f.bg */
/* loaded from: classes.dex */
public class C1489bg {

    /* renamed from: a */
    private static final String[] f9519a = {"unused", "key_compromise", "ca_compromise", "affiliation_changed", "superseded", "cessation_of_operation", "certificate_hold", "privilege_withdrawn", "aa_compromise"};

    /* renamed from: b */
    private boolean[] f9520b;

    /* renamed from: a */
    private boolean m11540a(int i) {
        return i < this.f9520b.length && this.f9520b[i];
    }

    public C1489bg(C1450m c1450m) {
        this.f9520b = c1450m.m11414a(true).m11322b();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Reason Flags [\n");
        if (m11540a(0)) {
            sb.append("  Unused\n");
        }
        if (m11540a(1)) {
            sb.append("  Key Compromise\n");
        }
        if (m11540a(2)) {
            sb.append("  CA Compromise\n");
        }
        if (m11540a(3)) {
            sb.append("  Affiliation_Changed\n");
        }
        if (m11540a(4)) {
            sb.append("  Superseded\n");
        }
        if (m11540a(5)) {
            sb.append("  Cessation Of Operation\n");
        }
        if (m11540a(6)) {
            sb.append("  Certificate Hold\n");
        }
        if (m11540a(7)) {
            sb.append("  Privilege Withdrawn\n");
        }
        if (m11540a(8)) {
            sb.append("  AA Compromise\n");
        }
        sb.append("]\n");
        return sb.toString();
    }

    /* renamed from: a */
    public void m11541a(C1449l c1449l) {
        c1449l.m11392a(new C1440c(this.f9520b));
    }
}
