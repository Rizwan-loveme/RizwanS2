package org.p210a.p211a.p212a.p213a;

/* compiled from: SingletonPredictionContext.java */
/* renamed from: org.a.a.a.a.az */
/* loaded from: classes.dex */
public class C1785az extends AbstractC1776aq {

    /* renamed from: c */
    static final /* synthetic */ boolean f10752c;

    /* renamed from: a */
    public final AbstractC1776aq f10753a;

    /* renamed from: b */
    public final int f10754b;

    static {
        f10752c = !C1785az.class.desiredAssertionStatus();
    }

    C1785az(AbstractC1776aq abstractC1776aq, int i) {
        super(abstractC1776aq != null ? m13543a(abstractC1776aq, i) : m13552d());
        if (!f10752c && i == -1) {
            throw new AssertionError();
        }
        this.f10753a = abstractC1776aq;
        this.f10754b = i;
    }

    /* renamed from: b */
    public static C1785az m13585b(AbstractC1776aq abstractC1776aq, int i) {
        return (i == Integer.MAX_VALUE && abstractC1776aq == null) ? f10726d : new C1785az(abstractC1776aq, i);
    }

    @Override // org.p210a.p211a.p212a.p213a.AbstractC1776aq
    /* renamed from: b */
    public int mo13555b() {
        return 1;
    }

    @Override // org.p210a.p211a.p212a.p213a.AbstractC1776aq
    /* renamed from: a */
    public AbstractC1776aq mo13553a(int i) {
        if (f10752c || i == 0) {
            return this.f10753a;
        }
        throw new AssertionError();
    }

    @Override // org.p210a.p211a.p212a.p213a.AbstractC1776aq
    /* renamed from: b */
    public int mo13556b(int i) {
        if (f10752c || i == 0) {
            return this.f10754b;
        }
        throw new AssertionError();
    }

    @Override // org.p210a.p211a.p212a.p213a.AbstractC1776aq
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof C1785az) && hashCode() == obj.hashCode()) {
            C1785az c1785az = (C1785az) obj;
            return this.f10754b == c1785az.f10754b && this.f10753a != null && this.f10753a.equals(c1785az.f10753a);
        }
        return false;
    }

    public String toString() {
        String obj = this.f10753a != null ? this.f10753a.toString() : "";
        if (obj.length() == 0) {
            if (this.f10754b == Integer.MAX_VALUE) {
                return "$";
            }
            return String.valueOf(this.f10754b);
        }
        return String.valueOf(String.valueOf(this.f10754b)) + " " + obj;
    }
}
