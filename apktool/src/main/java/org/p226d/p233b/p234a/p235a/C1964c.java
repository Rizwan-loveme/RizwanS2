package org.p226d.p233b.p234a.p235a;

import com.p129f.p130a.p133c.AbstractC1148aa;
import java.lang.reflect.Field;
import java.util.Set;
import org.p226d.p233b.p234a.p235a.p236a.C1962a;
import org.p226d.p233b.p238b.p239a.AbstractC1988b;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p233b.p250e.InterfaceC2266g;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;

/* compiled from: ReflectionField.java */
/* renamed from: org.d.b.a.a.c */
/* loaded from: classes.dex */
public class C1964c extends AbstractC1988b implements InterfaceC2266g {

    /* renamed from: a */
    private final Field f11428a;

    public C1964c(Field field) {
        this.f11428a = field;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2266g
    /* renamed from: a */
    public int mo14222a() {
        return this.f11428a.getModifiers();
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2266g
    /* renamed from: b */
    public InterfaceC2251g mo14223b() {
        return null;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2266g
    /* renamed from: c */
    public Set<? extends InterfaceC2165a> mo14224c() {
        return AbstractC1148aa.m9802i();
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2237b, org.p226d.p233b.p250e.InterfaceC2266g
    /* renamed from: d */
    public String mo14225d() {
        return C1962a.m14208a(this.f11428a.getDeclaringClass().getName());
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2237b, org.p226d.p233b.p250e.InterfaceC2266g
    /* renamed from: e */
    public String mo14226e() {
        return this.f11428a.getName();
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2237b, org.p226d.p233b.p250e.InterfaceC2266g
    /* renamed from: f */
    public String mo14227f() {
        return C1962a.m14208a(this.f11428a.getType().getName());
    }
}
