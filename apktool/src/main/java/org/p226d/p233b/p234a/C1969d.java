package org.p226d.p233b.p234a;

import android.app.slice.SliceItem;
import com.p129f.p130a.p131a.C1126u;
import org.p226d.p233b.p250e.InterfaceC2267h;
import org.p226d.p233b.p250e.p254c.InterfaceC2237b;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;
import org.p226d.p233b.p256f.p259c.C2322b;
import org.p226d.p233b.p263h.C2392l;
import org.p226d.p269d.C2453g;

/* compiled from: ArrayProto.java */
/* renamed from: org.d.b.a.d */
/* loaded from: classes.dex */
public class C1969d implements InterfaceC1981p {

    /* renamed from: d */
    private static final String f11452d = C1126u.m9589a("[", 256);

    /* renamed from: a */
    protected final C1970e f11453a;

    /* renamed from: b */
    protected final int f11454b;

    /* renamed from: c */
    protected final String f11455c;

    public C1969d(C1970e c1970e, String str) {
        this.f11453a = c1970e;
        int i = 0;
        while (str.charAt(i) == '[') {
            i++;
            if (i == str.length()) {
                throw new C2453g("Invalid array type: %s", str);
            }
        }
        if (i == 0) {
            throw new C2453g("Invalid array type: %s", str);
        }
        this.f11454b = i;
        this.f11455c = str.substring(i);
    }

    public String toString() {
        return mo14265b();
    }

    @Override // org.p226d.p233b.p234a.InterfaceC1981p
    /* renamed from: a */
    public C1970e mo14261a() {
        return this.f11453a;
    }

    @Override // org.p226d.p233b.p234a.InterfaceC1981p
    /* renamed from: b */
    public String mo14265b() {
        return m14259a(this.f11455c, this.f11454b);
    }

    @Override // org.p226d.p233b.p234a.InterfaceC1981p
    /* renamed from: c */
    public boolean mo14267c() {
        return false;
    }

    /* renamed from: d */
    public String m14268d() {
        return this.f11455c;
    }

    /* renamed from: e */
    public String m14269e() {
        return this.f11454b > 1 ? m14259a(this.f11455c, this.f11454b - 1) : this.f11455c;
    }

    @Override // org.p226d.p233b.p234a.InterfaceC1981p
    /* renamed from: a */
    public boolean mo14264a(String str) {
        return str.equals("Ljava/lang/Cloneable;") || str.equals("Ljava/io/Serializable;");
    }

    @Override // org.p226d.p233b.p234a.InterfaceC1981p
    /* renamed from: f */
    public String mo14270f() {
        return "Ljava/lang/Object;";
    }

    @Override // org.p226d.p233b.p234a.InterfaceC1981p
    /* renamed from: a */
    public InterfaceC1981p mo14262a(InterfaceC1981p interfaceC1981p) {
        if (interfaceC1981p instanceof C1969d) {
            if (C2392l.m15149b(m14268d()) || C2392l.m15149b(((C1969d) interfaceC1981p).m14268d())) {
                if (this.f11454b != ((C1969d) interfaceC1981p).f11454b || !m14268d().equals(((C1969d) interfaceC1981p).m14268d())) {
                    return this.f11453a.m14273a((CharSequence) "Ljava/lang/Object;");
                }
                return this;
            }
            if (this.f11454b == ((C1969d) interfaceC1981p).f11454b) {
                InterfaceC1981p m14273a = this.f11453a.m14273a((CharSequence) this.f11455c);
                InterfaceC1981p m14273a2 = this.f11453a.m14273a((CharSequence) ((C1969d) interfaceC1981p).f11455c);
                InterfaceC1981p mo14262a = m14273a.mo14262a(m14273a2);
                if (m14273a != mo14262a) {
                    return m14273a2 == mo14262a ? interfaceC1981p : this.f11453a.m14273a((CharSequence) m14259a(mo14262a.mo14265b(), this.f11454b));
                }
                return this;
            }
            return this.f11453a.m14273a((CharSequence) m14259a("Ljava/lang/Object;", Math.min(this.f11454b, ((C1969d) interfaceC1981p).f11454b)));
        }
        if (interfaceC1981p instanceof C1972g) {
            try {
                if (interfaceC1981p.mo14267c()) {
                    if (mo14264a(interfaceC1981p.mo14265b())) {
                        return interfaceC1981p;
                    }
                }
            } catch (C1983r e2) {
            }
            return this.f11453a.m14273a((CharSequence) "Ljava/lang/Object;");
        }
        return interfaceC1981p.mo14262a(this);
    }

    /* renamed from: a */
    private static String m14259a(String str, int i) {
        return f11452d.substring(0, i) + str;
    }

    @Override // org.p226d.p233b.p234a.InterfaceC1981p
    /* renamed from: a */
    public InterfaceC2237b mo14263a(int i) {
        if (i == 8) {
            return new C2322b(mo14265b(), "length", SliceItem.FORMAT_INT);
        }
        return null;
    }

    @Override // org.p226d.p233b.p234a.InterfaceC1981p
    /* renamed from: b */
    public InterfaceC2267h mo14266b(int i) {
        return this.f11453a.m14273a((CharSequence) "Ljava/lang/Object;").mo14266b(i);
    }

    @Override // org.p226d.p233b.p234a.InterfaceC1981p
    /* renamed from: a */
    public int mo14260a(InterfaceC2240e interfaceC2240e) {
        return this.f11453a.m14273a((CharSequence) "Ljava/lang/Object;").mo14260a(interfaceC2240e);
    }
}
