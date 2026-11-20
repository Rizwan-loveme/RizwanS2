package org.p226d.p233b.p238b.p239a;

import org.p226d.p233b.p250e.p254c.InterfaceC2243h;

/* compiled from: BaseTypeReference.java */
/* renamed from: org.d.b.b.a.g */
/* loaded from: classes.dex */
public abstract class AbstractC1993g implements InterfaceC2243h {
    public int hashCode() {
        return mo14205l().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof InterfaceC2243h) {
                return mo14205l().equals(((InterfaceC2243h) obj).mo14205l());
            }
            if (obj instanceof CharSequence) {
                return mo14205l().equals(obj.toString());
            }
        }
        return false;
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2243h, java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(CharSequence charSequence) {
        return mo14205l().compareTo(charSequence.toString());
    }

    @Override // java.lang.CharSequence
    public int length() {
        return mo14205l().length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return mo14205l().charAt(i);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return mo14205l().subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return mo14205l();
    }
}
