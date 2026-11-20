package org.p226d.p233b.p238b.p239a;

import org.p226d.p233b.p250e.p254c.InterfaceC2242g;

/* compiled from: BaseStringReference.java */
/* renamed from: org.d.b.b.a.f */
/* loaded from: classes.dex */
public abstract class AbstractC1992f implements InterfaceC2242g {
    public int hashCode() {
        return mo14691a().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof InterfaceC2242g)) {
            return false;
        }
        return mo14691a().equals(((InterfaceC2242g) obj).mo14691a());
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2242g, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(CharSequence charSequence) {
        return mo14691a().compareTo(charSequence.toString());
    }

    @Override // java.lang.CharSequence
    public int length() {
        return mo14691a().length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return mo14691a().charAt(i);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return mo14691a().subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return mo14691a();
    }
}
