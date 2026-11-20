package org.p226d.p233b.p234a.p235a;

import com.p129f.p130a.p133c.AbstractC1148aa;
import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.List;
import java.util.Set;
import org.p226d.p233b.p234a.p235a.p236a.C1962a;
import org.p226d.p233b.p238b.AbstractC2014d;
import org.p226d.p233b.p238b.p239a.AbstractC1991e;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p233b.p250e.InterfaceC2267h;
import org.p226d.p233b.p250e.InterfaceC2268i;
import org.p226d.p233b.p250e.InterfaceC2269j;

/* compiled from: ReflectionMethod.java */
/* renamed from: org.d.b.a.a.d */
/* loaded from: classes.dex */
public class C1965d extends AbstractC1991e implements InterfaceC2267h {

    /* renamed from: a */
    private final Method f11429a;

    public C1965d(Method method) {
        this.f11429a = method;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: e */
    public List<? extends InterfaceC2269j> mo14213e() {
        final Method method = this.f11429a;
        return new AbstractList<InterfaceC2269j>() { // from class: org.d.b.a.a.d.1

            /* renamed from: c */
            private final Class[] f11432c;

            {
                this.f11432c = method.getParameterTypes();
            }

            @Override // java.util.AbstractList, java.util.List
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public InterfaceC2269j get(final int i) {
                return new AbstractC2014d() { // from class: org.d.b.a.a.d.1.1
                    @Override // org.p226d.p233b.p250e.InterfaceC2269j
                    /* renamed from: a */
                    public Set<? extends InterfaceC2165a> mo14219a() {
                        return AbstractC1148aa.m9802i();
                    }

                    @Override // org.p226d.p233b.p250e.InterfaceC2269j, org.p226d.p233b.p250e.p251a.InterfaceC2170e
                    /* renamed from: b */
                    public String mo14220b() {
                        return null;
                    }

                    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2243h, org.p226d.p233b.p250e.InterfaceC2244d
                    /* renamed from: l */
                    public String mo14205l() {
                        return C1962a.m14208a(AnonymousClass1.this.f11432c[i].getName());
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.f11432c.length;
            }
        };
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: f */
    public int mo14214f() {
        return this.f11429a.getModifiers();
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: g */
    public Set<? extends InterfaceC2165a> mo14215g() {
        return AbstractC1148aa.m9802i();
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: h */
    public InterfaceC2268i mo14216h() {
        return null;
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: a */
    public String mo14209a() {
        return C1962a.m14208a(this.f11429a.getDeclaringClass().getName());
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: b */
    public String mo14210b() {
        return this.f11429a.getName();
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e
    /* renamed from: c */
    public List<String> mo14211c() {
        return new AbstractList<String>() { // from class: org.d.b.a.a.d.2

            /* renamed from: b */
            private final List<? extends InterfaceC2269j> f11436b;

            {
                this.f11436b = C1965d.this.mo14213e();
            }

            @Override // java.util.AbstractList, java.util.List
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String get(int i) {
                return this.f11436b.get(i).mo14465l();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.f11436b.size();
            }
        };
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: d */
    public String mo14212d() {
        return C1962a.m14208a(this.f11429a.getReturnType().getName());
    }
}
