package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

/* compiled from: VectorEnabledTintResources.java */
/* renamed from: androidx.appcompat.widget.be */
/* loaded from: classes.dex */
public class C0190be extends Resources {

    /* renamed from: a */
    private static boolean f1635a = false;

    /* renamed from: b */
    private final WeakReference<Context> f1636b;

    /* renamed from: a */
    public static boolean m1477a() {
        return m1478b() && Build.VERSION.SDK_INT <= 20;
    }

    public C0190be(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f1636b = new WeakReference<>(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) {
        Context context = this.f1636b.get();
        return context != null ? C0174ap.m1352a().m1366a(context, this, i) : super.getDrawable(i);
    }

    /* renamed from: a */
    final Drawable m1479a(int i) {
        return super.getDrawable(i);
    }

    /* renamed from: b */
    public static boolean m1478b() {
        return f1635a;
    }
}
