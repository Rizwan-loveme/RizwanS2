package com.p129f.p130a.p131a;

import java.p209io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Suppliers.java */
/* renamed from: com.f.a.a.w */
/* loaded from: classes.dex */
public final class C1128w {
    /* renamed from: a */
    public static <T> InterfaceC1127v<T> m9593a(InterfaceC1127v<T> interfaceC1127v) {
        return ((interfaceC1127v instanceof b) || (interfaceC1127v instanceof a)) ? interfaceC1127v : interfaceC1127v instanceof Serializable ? new a(interfaceC1127v) : new b(interfaceC1127v);
    }

    /* compiled from: Suppliers.java */
    /* renamed from: com.f.a.a.w$a */
    static class a<T> implements InterfaceC1127v<T>, Serializable {

        /* renamed from: a */
        final InterfaceC1127v<T> f7564a;

        /* renamed from: b */
        volatile transient boolean f7565b;

        /* renamed from: c */
        @NullableDecl
        transient T f7566c;

        a(InterfaceC1127v<T> interfaceC1127v) {
            this.f7564a = (InterfaceC1127v) C1120o.m9547a(interfaceC1127v);
        }

        @Override // com.p129f.p130a.p131a.InterfaceC1127v
        /* renamed from: a */
        public T mo9592a() {
            if (!this.f7565b) {
                synchronized (this) {
                    if (!this.f7565b) {
                        T mo9592a = this.f7564a.mo9592a();
                        this.f7566c = mo9592a;
                        this.f7565b = true;
                        return mo9592a;
                    }
                }
            }
            return this.f7566c;
        }

        public String toString() {
            return "Suppliers.memoize(" + (this.f7565b ? "<supplier that returned " + this.f7566c + ">" : this.f7564a) + ")";
        }
    }

    /* compiled from: Suppliers.java */
    /* renamed from: com.f.a.a.w$b */
    static class b<T> implements InterfaceC1127v<T> {

        /* renamed from: a */
        volatile InterfaceC1127v<T> f7567a;

        /* renamed from: b */
        volatile boolean f7568b;

        /* renamed from: c */
        @NullableDecl
        T f7569c;

        b(InterfaceC1127v<T> interfaceC1127v) {
            this.f7567a = (InterfaceC1127v) C1120o.m9547a(interfaceC1127v);
        }

        @Override // com.p129f.p130a.p131a.InterfaceC1127v
        /* renamed from: a */
        public T mo9592a() {
            if (!this.f7568b) {
                synchronized (this) {
                    if (!this.f7568b) {
                        T mo9592a = this.f7567a.mo9592a();
                        this.f7569c = mo9592a;
                        this.f7568b = true;
                        this.f7567a = null;
                        return mo9592a;
                    }
                }
            }
            return this.f7569c;
        }

        public String toString() {
            Object obj = this.f7567a;
            StringBuilder append = new StringBuilder().append("Suppliers.memoize(");
            if (obj == null) {
                obj = "<supplier that returned " + this.f7569c + ">";
            }
            return append.append(obj).append(")").toString();
        }
    }

    /* renamed from: a */
    public static <T> InterfaceC1127v<T> m9594a(@NullableDecl T t) {
        return new c(t);
    }

    /* compiled from: Suppliers.java */
    /* renamed from: com.f.a.a.w$c */
    private static class c<T> implements InterfaceC1127v<T>, Serializable {

        /* renamed from: a */
        @NullableDecl
        final T f7570a;

        c(@NullableDecl T t) {
            this.f7570a = t;
        }

        @Override // com.p129f.p130a.p131a.InterfaceC1127v
        /* renamed from: a */
        public T mo9592a() {
            return this.f7570a;
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof c) {
                return C1116k.m9538a(this.f7570a, ((c) obj).f7570a);
            }
            return false;
        }

        public int hashCode() {
            return C1116k.m9537a(this.f7570a);
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.f7570a + ")";
        }
    }
}
