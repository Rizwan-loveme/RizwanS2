package androidx.p044h.p045a;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.p008os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: PagerAdapter.java */
/* renamed from: androidx.h.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC0405a {

    /* renamed from: a */
    private final DataSetObservable f3027a = new DataSetObservable();

    /* renamed from: b */
    private DataSetObserver f3028b;

    /* renamed from: a */
    public abstract int mo3270a();

    /* renamed from: a */
    public abstract boolean mo3281a(View view, Object obj);

    /* renamed from: a */
    public void m3279a(ViewGroup viewGroup) {
        m3277a((View) viewGroup);
    }

    /* renamed from: a */
    public Object mo3274a(ViewGroup viewGroup, int i) {
        return m3273a((View) viewGroup, i);
    }

    /* renamed from: a */
    public void mo3280a(ViewGroup viewGroup, int i, Object obj) {
        m3278a((View) viewGroup, i, obj);
    }

    /* renamed from: b */
    public void m3288b(ViewGroup viewGroup, int i, Object obj) {
        m3286b((View) viewGroup, i, obj);
    }

    /* renamed from: b */
    public void m3287b(ViewGroup viewGroup) {
        m3285b((View) viewGroup);
    }

    @Deprecated
    /* renamed from: a */
    public void m3277a(View view) {
    }

    @Deprecated
    /* renamed from: a */
    public Object m3273a(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    /* renamed from: a */
    public void m3278a(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    @Deprecated
    /* renamed from: b */
    public void m3286b(View view, int i, Object obj) {
    }

    @Deprecated
    /* renamed from: b */
    public void m3285b(View view) {
    }

    /* renamed from: b */
    public Parcelable m3283b() {
        return null;
    }

    /* renamed from: a */
    public void m3276a(Parcelable parcelable, ClassLoader classLoader) {
    }

    /* renamed from: a */
    public int mo3271a(Object obj) {
        return -1;
    }

    /* renamed from: c */
    public void mo3289c() {
        synchronized (this) {
            if (this.f3028b != null) {
                this.f3028b.onChanged();
            }
        }
        this.f3027a.notifyChanged();
    }

    /* renamed from: a */
    public void m3275a(DataSetObserver dataSetObserver) {
        this.f3027a.registerObserver(dataSetObserver);
    }

    /* renamed from: b */
    public void m3284b(DataSetObserver dataSetObserver) {
        this.f3027a.unregisterObserver(dataSetObserver);
    }

    /* renamed from: c */
    void m3290c(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f3028b = dataSetObserver;
        }
    }

    /* renamed from: a */
    public CharSequence mo3272a(int i) {
        return null;
    }

    /* renamed from: b */
    public float m3282b(int i) {
        return 1.0f;
    }
}
