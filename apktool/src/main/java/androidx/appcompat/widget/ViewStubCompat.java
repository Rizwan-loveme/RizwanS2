package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.C0059a;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* renamed from: a */
    private int f1352a;

    /* renamed from: b */
    private int f1353b;

    /* renamed from: c */
    private WeakReference<View> f1354c;

    /* renamed from: d */
    private LayoutInflater f1355d;

    /* renamed from: e */
    private InterfaceC0157a f1356e;

    /* renamed from: androidx.appcompat.widget.ViewStubCompat$a */
    public interface InterfaceC0157a {
        /* renamed from: a */
        void m1155a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1352a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0059a.j.ViewStubCompat, i, 0);
        this.f1353b = obtainStyledAttributes.getResourceId(C0059a.j.ViewStubCompat_android_inflatedId, -1);
        this.f1352a = obtainStyledAttributes.getResourceId(C0059a.j.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(C0059a.j.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public int getInflatedId() {
        return this.f1353b;
    }

    public void setInflatedId(int i) {
        this.f1353b = i;
    }

    public int getLayoutResource() {
        return this.f1352a;
    }

    public void setLayoutResource(int i) {
        this.f1352a = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f1355d = layoutInflater;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f1355d;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (this.f1354c != null) {
            View view = this.f1354c.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            m1154a();
        }
    }

    /* renamed from: a */
    public View m1154a() {
        LayoutInflater from;
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            if (this.f1352a != 0) {
                ViewGroup viewGroup = (ViewGroup) parent;
                if (this.f1355d != null) {
                    from = this.f1355d;
                } else {
                    from = LayoutInflater.from(getContext());
                }
                View inflate = from.inflate(this.f1352a, viewGroup, false);
                if (this.f1353b != -1) {
                    inflate.setId(this.f1353b);
                }
                int indexOfChild = viewGroup.indexOfChild(this);
                viewGroup.removeViewInLayout(this);
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    viewGroup.addView(inflate, indexOfChild, layoutParams);
                } else {
                    viewGroup.addView(inflate, indexOfChild);
                }
                this.f1354c = new WeakReference<>(inflate);
                if (this.f1356e != null) {
                    this.f1356e.m1155a(this, inflate);
                }
                return inflate;
            }
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    public void setOnInflateListener(InterfaceC0157a interfaceC0157a) {
        this.f1356e = interfaceC0157a;
    }
}
