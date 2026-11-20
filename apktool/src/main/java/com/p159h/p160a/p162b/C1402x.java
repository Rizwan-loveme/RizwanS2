package com.p159h.p160a.p162b;

import android.provider.ContactsContract;
import java.util.LinkedList;

/* compiled from: UndoStack.java */
/* renamed from: com.h.a.b.x */
/* loaded from: classes.dex */
public class C1402x {

    /* renamed from: b */
    private C1399u f9153b;

    /* renamed from: c */
    private LinkedList<a> f9154c = new LinkedList<>();

    /* renamed from: d */
    private boolean f9155d = false;

    /* renamed from: e */
    private int f9156e = 0;

    /* renamed from: f */
    private int f9157f = 0;

    /* renamed from: a */
    long f9152a = -1;

    public C1402x(C1399u c1399u) {
        this.f9153b = c1399u;
    }

    /* renamed from: a */
    public int m11179a() {
        a aVar;
        if (m11184d()) {
            a aVar2 = this.f9154c.get(this.f9157f - 1);
            int i = aVar2.f9161d;
            while (true) {
                aVar = aVar2;
                aVar2 = this.f9154c.get(this.f9157f - 1);
                if (aVar2.f9161d != i) {
                    break;
                }
                aVar2.mo11189a();
                this.f9157f--;
                if (!m11184d()) {
                    aVar = aVar2;
                    break;
                }
            }
            return aVar.mo11193d();
        }
        return -1;
    }

    /* renamed from: b */
    public int m11181b() {
        a aVar;
        if (m11185e()) {
            a aVar2 = this.f9154c.get(this.f9157f);
            int i = aVar2.f9161d;
            while (true) {
                aVar = aVar2;
                aVar2 = this.f9154c.get(this.f9157f);
                if (aVar2.f9161d != i) {
                    break;
                }
                aVar2.mo11191b();
                this.f9157f++;
                if (!m11185e()) {
                    aVar = aVar2;
                    break;
                }
            }
            return aVar.mo11194e();
        }
        return -1;
    }

    /* renamed from: c */
    public void m11183c() {
        this.f9157f = 0;
        this.f9154c.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m11180a(int i, int i2, long j) {
        boolean z;
        if (m11184d()) {
            a aVar = this.f9154c.get(this.f9157f - 1);
            if ((aVar instanceof c) && aVar.mo11190a(i, i2, j)) {
                z = true;
                if (!z) {
                    m11176a(new c(this, i, i2, this.f9156e));
                    if (!this.f9155d) {
                        this.f9156e++;
                    }
                }
                this.f9152a = j;
            }
            aVar.mo11192c();
        }
        z = false;
        if (!z) {
        }
        this.f9152a = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m11182b(int i, int i2, long j) {
        boolean z;
        if (m11184d()) {
            a aVar = this.f9154c.get(this.f9157f - 1);
            if ((aVar instanceof b) && aVar.mo11190a(i, i2, j)) {
                z = true;
                if (!z) {
                    m11176a(new b(this, i, i2, this.f9156e));
                    if (!this.f9155d) {
                        this.f9156e++;
                    }
                }
                this.f9152a = j;
            }
            aVar.mo11192c();
        }
        z = false;
        if (!z) {
        }
        this.f9152a = j;
    }

    /* renamed from: a */
    private void m11176a(a aVar) {
        m11178i();
        this.f9157f++;
        this.f9154c.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m11178i() {
        while (this.f9154c.size() > this.f9157f) {
            this.f9154c.removeLast();
        }
    }

    /* renamed from: d */
    public final boolean m11184d() {
        return this.f9157f > 0;
    }

    /* renamed from: e */
    public final boolean m11185e() {
        return this.f9157f < this.f9154c.size();
    }

    /* renamed from: f */
    public boolean m11186f() {
        return this.f9155d;
    }

    /* renamed from: g */
    public void m11187g() {
        this.f9155d = true;
    }

    /* renamed from: h */
    public void m11188h() {
        this.f9155d = false;
        this.f9156e++;
    }

    /* compiled from: UndoStack.java */
    /* renamed from: com.h.a.b.x$a */
    private abstract class a {

        /* renamed from: a */
        public int f9158a;

        /* renamed from: b */
        public int f9159b;

        /* renamed from: c */
        public String f9160c;

        /* renamed from: d */
        public int f9161d;

        /* renamed from: e */
        private final C1402x f9162e;

        /* renamed from: a */
        public abstract void mo11189a();

        /* renamed from: a */
        public abstract boolean mo11190a(int i, int i2, long j);

        /* renamed from: b */
        public abstract void mo11191b();

        /* renamed from: c */
        public abstract void mo11192c();

        /* renamed from: d */
        public abstract int mo11193d();

        /* renamed from: e */
        public abstract int mo11194e();

        public a(C1402x c1402x) {
            this.f9162e = c1402x;
        }
    }

    /* compiled from: UndoStack.java */
    /* renamed from: com.h.a.b.x$c */
    private class c extends a {

        /* renamed from: e */
        private final C1402x f9164e;

        public c(C1402x c1402x, int i, int i2, int i3) {
            super(c1402x);
            this.f9164e = c1402x;
            this.f9158a = i;
            this.f9159b = i2;
            this.f9161d = i3;
        }

        @Override // com.p159h.p160a.p162b.C1402x.a
        /* renamed from: a */
        public boolean mo11190a(int i, int i2, long j) {
            if (this.f9164e.f9152a < 0 || j - this.f9164e.f9152a >= ContactsContract.Directory.ENTERPRISE_DEFAULT || i != this.f9158a + this.f9159b) {
                return false;
            }
            this.f9159b += i2;
            this.f9164e.m11178i();
            return true;
        }

        @Override // com.p159h.p160a.p162b.C1402x.a
        /* renamed from: c */
        public void mo11192c() {
            this.f9160c = this.f9164e.f9153b.subSequence(this.f9158a, this.f9159b).toString();
        }

        @Override // com.p159h.p160a.p162b.C1402x.a
        /* renamed from: a */
        public void mo11189a() {
            if (this.f9160c == null) {
                mo11192c();
                this.f9164e.f9153b.mo11019a(-this.f9159b);
            } else {
                this.f9164e.f9153b.mo11020a(this.f9158a, this.f9159b, 0, false);
            }
        }

        @Override // com.p159h.p160a.p162b.C1402x.a
        /* renamed from: b */
        public void mo11191b() {
            this.f9164e.f9153b.mo11024a(this.f9160c.toCharArray(), this.f9158a, 0, false);
        }

        @Override // com.p159h.p160a.p162b.C1402x.a
        /* renamed from: e */
        public int mo11194e() {
            return this.f9158a + this.f9159b;
        }

        @Override // com.p159h.p160a.p162b.C1402x.a
        /* renamed from: d */
        public int mo11193d() {
            return this.f9158a;
        }
    }

    /* compiled from: UndoStack.java */
    /* renamed from: com.h.a.b.x$b */
    private class b extends a {

        /* renamed from: e */
        private final C1402x f9163e;

        public b(C1402x c1402x, int i, int i2, int i3) {
            super(c1402x);
            this.f9163e = c1402x;
            this.f9158a = i;
            this.f9159b = i2;
            this.f9161d = i3;
        }

        @Override // com.p159h.p160a.p162b.C1402x.a
        /* renamed from: a */
        public boolean mo11190a(int i, int i2, long j) {
            if (this.f9163e.f9152a < 0 || j - this.f9163e.f9152a >= ContactsContract.Directory.ENTERPRISE_DEFAULT || i != ((this.f9158a - this.f9159b) - i2) + 1) {
                return false;
            }
            this.f9158a = i;
            this.f9159b += i2;
            this.f9163e.m11178i();
            return true;
        }

        @Override // com.p159h.p160a.p162b.C1402x.a
        /* renamed from: c */
        public void mo11192c() {
            this.f9160c = new String(this.f9163e.f9153b.m11151j(this.f9159b));
        }

        @Override // com.p159h.p160a.p162b.C1402x.a
        /* renamed from: a */
        public void mo11189a() {
            if (this.f9160c == null) {
                mo11192c();
                this.f9163e.f9153b.mo11019a(this.f9159b);
            } else {
                this.f9163e.f9153b.mo11024a(this.f9160c.toCharArray(), this.f9158a, 0, false);
            }
        }

        @Override // com.p159h.p160a.p162b.C1402x.a
        /* renamed from: b */
        public void mo11191b() {
            this.f9163e.f9153b.mo11020a(this.f9158a, this.f9159b, 0, false);
        }

        @Override // com.p159h.p160a.p162b.C1402x.a
        /* renamed from: e */
        public int mo11194e() {
            return this.f9158a;
        }

        @Override // com.p159h.p160a.p162b.C1402x.a
        /* renamed from: d */
        public int mo11193d() {
            return this.f9158a + this.f9159b;
        }
    }
}
