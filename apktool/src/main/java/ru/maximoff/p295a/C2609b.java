package ru.maximoff.p295a;

import com.p129f.p130a.p133c.AbstractC1148aa;
import java.util.Set;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p233b.p250e.InterfaceC2269j;

/* compiled from: SmaliMethodParamter.java */
/* renamed from: ru.maximoff.a.b */
/* loaded from: classes.dex */
public class C2609b implements InterfaceC2269j {

    /* renamed from: a */
    private final String f13577a;

    /* renamed from: b */
    private String f13578b;

    /* renamed from: c */
    private final AbstractC1148aa.a<InterfaceC2165a> f13579c = new AbstractC1148aa.a<>();

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2243h, java.lang.Comparable
    public int compareTo(Object obj) {
        return compareTo((CharSequence) obj);
    }

    public C2609b(String str) {
        this.f13577a = str;
    }

    /* renamed from: a */
    public void m16362a(String str) {
        this.f13578b = str;
    }

    /* renamed from: a */
    public void m16363a(InterfaceC2165a interfaceC2165a) {
        this.f13579c.mo9812b(interfaceC2165a);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f13577a.length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.f13577a.charAt(i);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f13577a;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.f13577a.subSequence(i, i2);
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2269j, org.p226d.p233b.p250e.p251a.InterfaceC2170e
    /* renamed from: l */
    public String mo14465l() {
        return this.f13577a;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2269j
    /* renamed from: a */
    public Set<? extends InterfaceC2165a> mo14219a() {
        return this.f13579c.mo9808a();
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2269j, org.p226d.p233b.p250e.p251a.InterfaceC2170e
    /* renamed from: b */
    public String mo14220b() {
        return this.f13578b;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2269j, org.p226d.p233b.p250e.p251a.InterfaceC2170e
    /* renamed from: c */
    public String mo14452c() {
        return (String) null;
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2243h
    /* renamed from: a */
    public int compareTo(CharSequence charSequence) {
        return this.f13577a.compareTo(charSequence.toString());
    }

    public int hashCode() {
        return this.f13577a.hashCode();
    }
}
