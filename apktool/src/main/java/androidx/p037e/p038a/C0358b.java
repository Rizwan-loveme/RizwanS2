package androidx.p037e.p038a;

import android.os.Bundle;
import android.util.Log;
import androidx.core.p030e.C0267b;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.p011a.C0043h;
import androidx.p037e.p038a.AbstractC0357a;
import androidx.p037e.p039b.C0359a;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: LoaderManagerImpl.java */
/* renamed from: androidx.e.a.b */
/* loaded from: classes.dex */
class C0358b extends AbstractC0357a {

    /* renamed from: a */
    static boolean f2436a = false;

    /* renamed from: b */
    private final LifecycleOwner f2437b;

    /* renamed from: c */
    private final c f2438c;

    /* compiled from: LoaderManagerImpl.java */
    /* renamed from: androidx.e.a.b$a */
    public static class a<D> extends MutableLiveData<D> implements C0359a.a<D> {

        /* renamed from: a */
        private final int f2439a;

        /* renamed from: b */
        private final Bundle f2440b;

        /* renamed from: c */
        private final C0359a<D> f2441c;

        /* renamed from: d */
        private LifecycleOwner f2442d;

        /* renamed from: e */
        private b<D> f2443e;

        /* renamed from: f */
        private C0359a<D> f2444f;

        /* renamed from: a */
        C0359a<D> m2601a() {
            return this.f2441c;
        }

        @Override // androidx.lifecycle.LiveData
        protected void onActive() {
            if (C0358b.f2436a) {
                Log.m188v("LoaderManager", "  Starting: " + this);
            }
            this.f2441c.m2612a();
        }

        @Override // androidx.lifecycle.LiveData
        protected void onInactive() {
            if (C0358b.f2436a) {
                Log.m188v("LoaderManager", "  Stopping: " + this);
            }
            this.f2441c.m2618e();
        }

        /* renamed from: b */
        void m2604b() {
            LifecycleOwner lifecycleOwner = this.f2442d;
            b<D> bVar = this.f2443e;
            if (lifecycleOwner != null && bVar != null) {
                super.removeObserver(bVar);
                observe(lifecycleOwner, bVar);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void removeObserver(Observer<? super D> observer) {
            super.removeObserver(observer);
            this.f2442d = null;
            this.f2443e = null;
        }

        /* renamed from: a */
        C0359a<D> m2602a(boolean z) {
            if (C0358b.f2436a) {
                Log.m188v("LoaderManager", "  Destroying: " + this);
            }
            this.f2441c.m2616c();
            this.f2441c.m2620g();
            b<D> bVar = this.f2443e;
            if (bVar != null) {
                removeObserver(bVar);
                if (z) {
                    bVar.m2607b();
                }
            }
            this.f2441c.m2613a((C0359a.a) this);
            if ((bVar == null || bVar.m2606a()) && !z) {
                return this.f2441c;
            }
            this.f2441c.m2622i();
            return this.f2444f;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(D d2) {
            super.setValue(d2);
            if (this.f2444f != null) {
                this.f2444f.m2622i();
                this.f2444f = null;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f2439a);
            sb.append(" : ");
            C0267b.m1951a(this.f2441c, sb);
            sb.append("}}");
            return sb.toString();
        }

        /* renamed from: a */
        public void m2603a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f2439a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f2440b);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f2441c);
            this.f2441c.m2614a(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f2443e != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f2443e);
                this.f2443e.m2605a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(m2601a().m2611a((C0359a<D>) getValue()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(hasActiveObservers());
        }
    }

    /* compiled from: LoaderManagerImpl.java */
    /* renamed from: androidx.e.a.b$b */
    static class b<D> implements Observer<D> {

        /* renamed from: a */
        private final C0359a<D> f2445a;

        /* renamed from: b */
        private final AbstractC0357a.a<D> f2446b;

        /* renamed from: c */
        private boolean f2447c;

        @Override // androidx.lifecycle.Observer
        public void onChanged(D d2) {
            if (C0358b.f2436a) {
                Log.m188v("LoaderManager", "  onLoadFinished in " + this.f2445a + ": " + this.f2445a.m2611a((C0359a<D>) d2));
            }
            this.f2446b.m2600a(this.f2445a, d2);
            this.f2447c = true;
        }

        /* renamed from: a */
        boolean m2606a() {
            return this.f2447c;
        }

        /* renamed from: b */
        void m2607b() {
            if (this.f2447c) {
                if (C0358b.f2436a) {
                    Log.m188v("LoaderManager", "  Resetting: " + this.f2445a);
                }
                this.f2446b.m2599a(this.f2445a);
            }
        }

        public String toString() {
            return this.f2446b.toString();
        }

        /* renamed from: a */
        public void m2605a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f2447c);
        }
    }

    /* compiled from: LoaderManagerImpl.java */
    /* renamed from: androidx.e.a.b$c */
    static class c extends ViewModel {

        /* renamed from: a */
        private static final ViewModelProvider.Factory f2448a = new ViewModelProvider.Factory() { // from class: androidx.e.a.b.c.1
            @Override // androidx.lifecycle.ViewModelProvider.Factory
            public <T extends ViewModel> T create(Class<T> cls) {
                return new c();
            }
        };

        /* renamed from: b */
        private C0043h<a> f2449b = new C0043h<>();

        /* renamed from: c */
        private boolean f2450c = false;

        c() {
        }

        /* renamed from: a */
        static c m2608a(ViewModelStore viewModelStore) {
            return (c) new ViewModelProvider(viewModelStore, f2448a).get(c.class);
        }

        /* renamed from: a */
        void m2609a() {
            int m278b = this.f2449b.m278b();
            for (int i = 0; i < m278b; i++) {
                this.f2449b.m281c(i).m2604b();
            }
        }

        @Override // androidx.lifecycle.ViewModel
        protected void onCleared() {
            super.onCleared();
            int m278b = this.f2449b.m278b();
            for (int i = 0; i < m278b; i++) {
                this.f2449b.m281c(i).m2602a(true);
            }
            this.f2449b.m282c();
        }

        /* renamed from: a */
        public void m2610a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f2449b.m278b() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.f2449b.m278b()) {
                        a m281c = this.f2449b.m281c(i2);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(this.f2449b.m279b(i2));
                        printWriter.print(": ");
                        printWriter.println(m281c.toString());
                        m281c.m2603a(str2, fileDescriptor, printWriter, strArr);
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    C0358b(LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        this.f2437b = lifecycleOwner;
        this.f2438c = c.m2608a(viewModelStore);
    }

    @Override // androidx.p037e.p038a.AbstractC0357a
    /* renamed from: a */
    public void mo2597a() {
        this.f2438c.m2609a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        C0267b.m1951a(this.f2437b, sb);
        sb.append("}}");
        return sb.toString();
    }

    @Override // androidx.p037e.p038a.AbstractC0357a
    @Deprecated
    /* renamed from: a */
    public void mo2598a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f2438c.m2610a(str, fileDescriptor, printWriter, strArr);
    }
}
