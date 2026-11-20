package org.p210a.p211a.p212a.p213a;

import java.util.Arrays;

/* compiled from: ArrayPredictionContext.java */
/* renamed from: org.a.a.a.a.k */
/* loaded from: classes.dex */
public class C1801k extends AbstractC1776aq {

    /* renamed from: c */
    static final /* synthetic */ boolean f10809c;

    /* renamed from: a */
    public final AbstractC1776aq[] f10810a;

    /* renamed from: b */
    public final int[] f10811b;

    static {
        f10809c = !C1801k.class.desiredAssertionStatus();
    }

    public C1801k(C1785az c1785az) {
        this(new AbstractC1776aq[]{c1785az.f10753a}, new int[]{c1785az.f10754b});
    }

    public C1801k(AbstractC1776aq[] abstractC1776aqArr, int[] iArr) {
        super(m13544a(abstractC1776aqArr, iArr));
        if (!f10809c && (abstractC1776aqArr == null || abstractC1776aqArr.length <= 0)) {
            throw new AssertionError();
        }
        if (!f10809c && (iArr == null || iArr.length <= 0)) {
            throw new AssertionError();
        }
        this.f10810a = abstractC1776aqArr;
        this.f10811b = iArr;
    }

    @Override // org.p210a.p211a.p212a.p213a.AbstractC1776aq
    /* renamed from: a */
    public boolean mo13554a() {
        return this.f10811b[0] == Integer.MAX_VALUE;
    }

    @Override // org.p210a.p211a.p212a.p213a.AbstractC1776aq
    /* renamed from: b */
    public int mo13555b() {
        return this.f10811b.length;
    }

    @Override // org.p210a.p211a.p212a.p213a.AbstractC1776aq
    /* renamed from: a */
    public AbstractC1776aq mo13553a(int i) {
        return this.f10810a[i];
    }

    @Override // org.p210a.p211a.p212a.p213a.AbstractC1776aq
    /* renamed from: b */
    public int mo13556b(int i) {
        return this.f10811b[i];
    }

    @Override // org.p210a.p211a.p212a.p213a.AbstractC1776aq
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof C1801k) && hashCode() == obj.hashCode()) {
            C1801k c1801k = (C1801k) obj;
            return Arrays.equals(this.f10811b, c1801k.f10811b) && Arrays.equals(this.f10810a, c1801k.f10810a);
        }
        return false;
    }

    public String toString() {
        if (mo13554a()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.f10811b.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            if (this.f10811b[i] == Integer.MAX_VALUE) {
                sb.append("$");
            } else {
                sb.append(this.f10811b[i]);
                if (this.f10810a[i] != null) {
                    sb.append(' ');
                    sb.append(this.f10810a[i].toString());
                } else {
                    sb.append("null");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
