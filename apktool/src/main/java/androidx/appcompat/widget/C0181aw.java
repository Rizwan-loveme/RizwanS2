package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.p008os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: TintContextWrapper.java */
/* renamed from: androidx.appcompat.widget.aw */
/* loaded from: classes.dex */
public class C0181aw extends ContextWrapper {

    /* renamed from: a */
    private static final Object f1580a = new Object();

    /* renamed from: b */
    private static ArrayList<WeakReference<C0181aw>> f1581b;

    /* renamed from: c */
    private final Resources f1582c;

    /* renamed from: d */
    private final Resources.Theme f1583d;

    /* renamed from: a */
    public static Context m1427a(Context context) {
        if (m1428b(context)) {
            synchronized (f1580a) {
                if (f1581b == null) {
                    f1581b = new ArrayList<>();
                } else {
                    for (int size = f1581b.size() - 1; size >= 0; size--) {
                        WeakReference<C0181aw> weakReference = f1581b.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f1581b.remove(size);
                        }
                    }
                    for (int size2 = f1581b.size() - 1; size2 >= 0; size2--) {
                        WeakReference<C0181aw> weakReference2 = f1581b.get(size2);
                        C0181aw c0181aw = weakReference2 != null ? weakReference2.get() : null;
                        if (c0181aw != null && c0181aw.getBaseContext() == context) {
                            return c0181aw;
                        }
                    }
                }
                C0181aw c0181aw2 = new C0181aw(context);
                f1581b.add(new WeakReference<>(c0181aw2));
                return c0181aw2;
            }
        }
        return context;
    }

    /* renamed from: b */
    private static boolean m1428b(Context context) {
        if ((context instanceof C0181aw) || (context.getResources() instanceof C0183ay) || (context.getResources() instanceof C0190be)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || C0190be.m1477a();
    }

    private C0181aw(Context context) {
        super(context);
        if (C0190be.m1477a()) {
            this.f1582c = new C0190be(this, context.getResources());
            this.f1583d = this.f1582c.newTheme();
            this.f1583d.setTo(context.getTheme());
        } else {
            this.f1582c = new C0183ay(this, context.getResources());
            this.f1583d = null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        return this.f1583d == null ? super.getTheme() : this.f1583d;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.f1583d == null) {
            super.setTheme(i);
        } else {
            this.f1583d.applyStyle(i, true);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f1582c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f1582c.getAssets();
    }
}
