package androidx.p037e.p038a;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.p037e.p039b.C0359a;
import java.p209io.FileDescriptor;
import java.p209io.PrintWriter;

/* compiled from: LoaderManager.java */
/* renamed from: androidx.e.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC0357a {

    /* compiled from: LoaderManager.java */
    /* renamed from: androidx.e.a.a$a */
    public interface a<D> {
        /* renamed from: a */
        void m2599a(C0359a<D> c0359a);

        /* renamed from: a */
        void m2600a(C0359a<D> c0359a, D d2);
    }

    /* renamed from: a */
    public abstract void mo2597a();

    @Deprecated
    /* renamed from: a */
    public abstract void mo2598a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    /* renamed from: a */
    public static <T extends LifecycleOwner & ViewModelStoreOwner> AbstractC0357a m2596a(T t) {
        return new C0358b(t, t.getViewModelStore());
    }
}
