package org.p210a.p211a.p212a.p214b;

import java.util.Arrays;
import org.p210a.p211a.p212a.p213a.AbstractC1783ax;
import org.p210a.p211a.p212a.p213a.C1793c;
import org.p210a.p211a.p212a.p213a.C1814x;
import org.p210a.p211a.p212a.p215c.C1841k;

/* compiled from: DFAState.java */
/* renamed from: org.a.a.a.b.c */
/* loaded from: classes.dex */
public class C1829c {

    /* renamed from: a */
    public int f10862a;

    /* renamed from: b */
    public C1793c f10863b;

    /* renamed from: c */
    public C1829c[] f10864c;

    /* renamed from: d */
    public boolean f10865d;

    /* renamed from: e */
    public int f10866e;

    /* renamed from: f */
    public C1814x f10867f;

    /* renamed from: g */
    public boolean f10868g;

    /* renamed from: h */
    public a[] f10869h;

    /* compiled from: DFAState.java */
    /* renamed from: org.a.a.a.b.c$a */
    public static class a {

        /* renamed from: a */
        public AbstractC1783ax f10870a;

        /* renamed from: b */
        public int f10871b;

        public a(AbstractC1783ax abstractC1783ax, int i) {
            this.f10871b = i;
            this.f10870a = abstractC1783ax;
        }

        public String toString() {
            return "(" + this.f10870a + ", " + this.f10871b + ")";
        }
    }

    public C1829c() {
        this.f10862a = -1;
        this.f10863b = new C1793c();
        this.f10865d = false;
    }

    public C1829c(C1793c c1793c) {
        this.f10862a = -1;
        this.f10863b = new C1793c();
        this.f10865d = false;
        this.f10863b = c1793c;
    }

    public int hashCode() {
        return C1841k.m13775b(C1841k.m13772a(C1841k.m13771a(7), this.f10863b.hashCode()), 1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1829c)) {
            return false;
        }
        return this.f10863b.equals(((C1829c) obj).f10863b);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f10862a).append(":").append(this.f10863b);
        if (this.f10865d) {
            sb.append("=>");
            if (this.f10869h != null) {
                sb.append(Arrays.toString(this.f10869h));
            } else {
                sb.append(this.f10866e);
            }
        }
        return sb.toString();
    }
}
