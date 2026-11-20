package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* compiled from: TintResources.java */
/* renamed from: androidx.appcompat.widget.ay */
/* loaded from: classes.dex */
class C0183ay extends C0175aq {

    /* renamed from: a */
    private final WeakReference<Context> f1588a;

    public C0183ay(Context context, Resources resources) {
        super(resources);
        this.f1588a = new WeakReference<>(context);
    }

    @Override // androidx.appcompat.widget.C0175aq, android.content.res.Resources
    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = this.f1588a.get();
        if (drawable != null && context != null) {
            C0174ap.m1352a().m1369a(context, i, drawable);
        }
        return drawable;
    }
}
