package org.p226d.p233b.p234a.p235a;

import com.p129f.p130a.p131a.InterfaceC1112g;
import com.p129f.p130a.p131a.InterfaceC1121p;
import com.p129f.p130a.p133c.AbstractC1148aa;
import com.p129f.p130a.p133c.AbstractC1208w;
import com.p129f.p130a.p133c.C1154ag;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.p226d.p233b.p234a.p235a.p236a.C1962a;
import org.p226d.p233b.p238b.p239a.AbstractC1993g;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p233b.p250e.InterfaceC2244d;
import org.p226d.p233b.p250e.InterfaceC2266g;
import org.p226d.p233b.p250e.InterfaceC2267h;

/* compiled from: ReflectionClassDef.java */
/* renamed from: org.d.b.a.a.a */
/* loaded from: classes.dex */
public class C1961a extends AbstractC1993g implements InterfaceC2244d {

    /* renamed from: a */
    private final Class f11399a;

    public C1961a(Class cls) {
        this.f11399a = cls;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: a */
    public int mo14194a() {
        return this.f11399a.getModifiers();
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: b */
    public String mo14195b() {
        if (Modifier.isInterface(this.f11399a.getModifiers())) {
            return "Ljava/lang/Object;";
        }
        Class superclass = this.f11399a.getSuperclass();
        if (superclass == null) {
            return null;
        }
        return C1962a.m14208a(superclass.getName());
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: c */
    public List<String> mo14196c() {
        return AbstractC1208w.m10134a(C1154ag.m9889a((Iterator) C1154ag.m9885a((Object[]) this.f11399a.getInterfaces()), (InterfaceC1112g) new InterfaceC1112g<Class, String>() { // from class: org.d.b.a.a.a.1
            @Override // com.p129f.p130a.p131a.InterfaceC1112g
            /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public String mo9517a(Class cls) {
                if (cls == null) {
                    return null;
                }
                return C1962a.m14208a(cls.getName());
            }
        }));
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: d */
    public String mo14197d() {
        return null;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: e */
    public Set<? extends InterfaceC2165a> mo14198e() {
        return AbstractC1148aa.m9802i();
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: f */
    public Iterable<? extends InterfaceC2266g> mo14199f() {
        return new Iterable<InterfaceC2266g>() { // from class: org.d.b.a.a.a.2
            @Override // java.lang.Iterable
            public Iterator<InterfaceC2266g> iterator() {
                return C1154ag.m9889a((Iterator) C1154ag.m9884a((Iterator) C1154ag.m9885a((Object[]) C1961a.this.f11399a.getDeclaredFields()), (InterfaceC1121p) new InterfaceC1121p<Field>() { // from class: org.d.b.a.a.a.2.1
                    @Override // com.p129f.p130a.p131a.InterfaceC1121p
                    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                    public boolean mo9509a(Field field) {
                        return field != null && Modifier.isStatic(field.getModifiers());
                    }
                }), (InterfaceC1112g) new InterfaceC1112g<Field, InterfaceC2266g>() { // from class: org.d.b.a.a.a.2.2
                    @Override // com.p129f.p130a.p131a.InterfaceC1112g
                    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                    public InterfaceC2266g mo9517a(Field field) {
                        return new C1964c(field);
                    }
                });
            }
        };
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: g */
    public Iterable<? extends InterfaceC2266g> mo14200g() {
        return new Iterable<InterfaceC2266g>() { // from class: org.d.b.a.a.a.3
            @Override // java.lang.Iterable
            public Iterator<InterfaceC2266g> iterator() {
                return C1154ag.m9889a((Iterator) C1154ag.m9884a((Iterator) C1154ag.m9885a((Object[]) C1961a.this.f11399a.getDeclaredFields()), (InterfaceC1121p) new InterfaceC1121p<Field>() { // from class: org.d.b.a.a.a.3.1
                    @Override // com.p129f.p130a.p131a.InterfaceC1121p
                    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                    public boolean mo9509a(Field field) {
                        return (field == null || Modifier.isStatic(field.getModifiers())) ? false : true;
                    }
                }), (InterfaceC1112g) new InterfaceC1112g<Field, InterfaceC2266g>() { // from class: org.d.b.a.a.a.3.2
                    @Override // com.p129f.p130a.p131a.InterfaceC1112g
                    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                    public InterfaceC2266g mo9517a(Field field) {
                        return new C1964c(field);
                    }
                });
            }
        };
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public Set<? extends InterfaceC2266g> mo14207n() {
        return new AbstractSet<InterfaceC2266g>() { // from class: org.d.b.a.a.a.4
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<InterfaceC2266g> iterator() {
                return C1154ag.m9889a((Iterator) C1154ag.m9885a((Object[]) C1961a.this.f11399a.getDeclaredFields()), (InterfaceC1112g) new InterfaceC1112g<Field, InterfaceC2266g>() { // from class: org.d.b.a.a.a.4.1
                    @Override // com.p129f.p130a.p131a.InterfaceC1112g
                    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                    public InterfaceC2266g mo9517a(Field field) {
                        return new C1964c(field);
                    }
                });
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C1961a.this.f11399a.getDeclaredFields().length;
            }
        };
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: i */
    public Iterable<? extends InterfaceC2267h> mo14202i() {
        return new Iterable<InterfaceC2267h>() { // from class: org.d.b.a.a.a.5
            @Override // java.lang.Iterable
            public Iterator<InterfaceC2267h> iterator() {
                return C1154ag.m9895b(C1154ag.m9889a((Iterator) C1154ag.m9885a((Object[]) C1961a.this.f11399a.getDeclaredConstructors()), (InterfaceC1112g) new InterfaceC1112g<Constructor, InterfaceC2267h>() { // from class: org.d.b.a.a.a.5.1
                    @Override // com.p129f.p130a.p131a.InterfaceC1112g
                    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                    public InterfaceC2267h mo9517a(Constructor constructor) {
                        return new C1963b(constructor);
                    }
                }), C1154ag.m9889a((Iterator) C1154ag.m9884a((Iterator) C1154ag.m9885a((Object[]) C1961a.this.f11399a.getDeclaredMethods()), (InterfaceC1121p) new InterfaceC1121p<Method>() { // from class: org.d.b.a.a.a.5.2
                    @Override // com.p129f.p130a.p131a.InterfaceC1121p
                    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                    public boolean mo9509a(Method method) {
                        return (method == null || (method.getModifiers() & 10) == 0) ? false : true;
                    }
                }), (InterfaceC1112g) new InterfaceC1112g<Method, InterfaceC2267h>() { // from class: org.d.b.a.a.a.5.3
                    @Override // com.p129f.p130a.p131a.InterfaceC1112g
                    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                    public InterfaceC2267h mo9517a(Method method) {
                        return new C1965d(method);
                    }
                }));
            }
        };
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: j */
    public Iterable<? extends InterfaceC2267h> mo14203j() {
        return new Iterable<InterfaceC2267h>() { // from class: org.d.b.a.a.a.6
            @Override // java.lang.Iterable
            public Iterator<InterfaceC2267h> iterator() {
                return C1154ag.m9889a((Iterator) C1154ag.m9884a((Iterator) C1154ag.m9885a((Object[]) C1961a.this.f11399a.getDeclaredMethods()), (InterfaceC1121p) new InterfaceC1121p<Method>() { // from class: org.d.b.a.a.a.6.1
                    @Override // com.p129f.p130a.p131a.InterfaceC1121p
                    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                    public boolean mo9509a(Method method) {
                        return method != null && (method.getModifiers() & 10) == 0;
                    }
                }), (InterfaceC1112g) new InterfaceC1112g<Method, InterfaceC2267h>() { // from class: org.d.b.a.a.a.6.2
                    @Override // com.p129f.p130a.p131a.InterfaceC1112g
                    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                    public InterfaceC2267h mo9517a(Method method) {
                        return new C1965d(method);
                    }
                });
            }
        };
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public Set<? extends InterfaceC2267h> mo14206m() {
        return new AbstractSet<InterfaceC2267h>() { // from class: org.d.b.a.a.a.7
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<InterfaceC2267h> iterator() {
                return C1154ag.m9895b(C1154ag.m9889a((Iterator) C1154ag.m9885a((Object[]) C1961a.this.f11399a.getDeclaredConstructors()), (InterfaceC1112g) new InterfaceC1112g<Constructor, InterfaceC2267h>() { // from class: org.d.b.a.a.a.7.1
                    @Override // com.p129f.p130a.p131a.InterfaceC1112g
                    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                    public InterfaceC2267h mo9517a(Constructor constructor) {
                        return new C1963b(constructor);
                    }
                }), C1154ag.m9889a((Iterator) C1154ag.m9885a((Object[]) C1961a.this.f11399a.getDeclaredMethods()), (InterfaceC1112g) new InterfaceC1112g<Method, InterfaceC2267h>() { // from class: org.d.b.a.a.a.7.2
                    @Override // com.p129f.p130a.p131a.InterfaceC1112g
                    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                    public InterfaceC2267h mo9517a(Method method) {
                        return new C1965d(method);
                    }
                }));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C1961a.this.f11399a.getDeclaredMethods().length + C1961a.this.f11399a.getDeclaredConstructors().length;
            }
        };
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2243h, org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: l */
    public String mo14205l() {
        return C1962a.m14208a(this.f11399a.getName());
    }
}
