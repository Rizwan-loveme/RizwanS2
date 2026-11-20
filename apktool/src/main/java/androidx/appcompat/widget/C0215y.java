package androidx.appcompat.widget;

import android.C0012R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.C0059a;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.p014a.p015a.C0060a;
import androidx.appcompat.view.C0092d;
import androidx.appcompat.view.menu.InterfaceC0115p;
import androidx.core.p031f.C0308x;
import androidx.core.p031f.InterfaceC0307w;

/* compiled from: AppCompatSpinner.java */
/* renamed from: androidx.appcompat.widget.y */
/* loaded from: classes.dex */
public class C0215y extends Spinner implements InterfaceC0307w {

    /* renamed from: c */
    private static final int[] f1752c = {C0012R.attr.spinnerMode};

    /* renamed from: a */
    int f1753a;

    /* renamed from: b */
    final Rect f1754b;

    /* renamed from: d */
    private final C0196f f1755d;

    /* renamed from: e */
    private final Context f1756e;

    /* renamed from: f */
    private AbstractViewOnAttachStateChangeListenerC0168aj f1757f;

    /* renamed from: g */
    private SpinnerAdapter f1758g;

    /* renamed from: h */
    private final boolean f1759h;

    /* renamed from: i */
    private e f1760i;

    /* compiled from: AppCompatSpinner.java */
    /* renamed from: androidx.appcompat.widget.y$e */
    interface e {
        /* renamed from: a */
        CharSequence mo1592a();

        /* renamed from: a */
        void mo1593a(int i);

        /* renamed from: a */
        void mo1594a(int i, int i2);

        /* renamed from: a */
        void mo1595a(Drawable drawable);

        /* renamed from: a */
        void mo1314a(ListAdapter listAdapter);

        /* renamed from: a */
        void mo1596a(CharSequence charSequence);

        /* renamed from: a_ */
        int mo1597a_();

        /* renamed from: b */
        Drawable mo1598b();

        /* renamed from: b */
        void mo1599b(int i);

        /* renamed from: c */
        void mo1600c();

        /* renamed from: c */
        void mo1601c(int i);

        /* renamed from: d */
        boolean mo1602d();

        /* renamed from: f */
        int mo1603f();
    }

    public C0215y(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0059a.a.spinnerStyle);
    }

    public C0215y(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public C0215y(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0215y(Context context, AttributeSet attributeSet, int i, int i2, Resources.Theme theme) {
        super(context, attributeSet, i);
        TypedArray typedArray;
        CharSequence[] m1449f;
        this.f1754b = new Rect();
        C0179au.m1422a(this, getContext());
        C0184az m1432a = C0184az.m1432a(context, attributeSet, C0059a.j.Spinner, i, 0);
        this.f1755d = new C0196f(this);
        if (theme != null) {
            this.f1756e = new C0092d(context, theme);
        } else {
            int m1450g = m1432a.m1450g(C0059a.j.Spinner_popupTheme, 0);
            if (m1450g != 0) {
                this.f1756e = new C0092d(context, m1450g);
            } else {
                this.f1756e = context;
            }
        }
        if (i2 == -1) {
            try {
                typedArray = context.obtainStyledAttributes(attributeSet, f1752c, i, 0);
                try {
                    try {
                        i2 = typedArray.hasValue(0) ? typedArray.getInt(0, 0) : i2;
                        if (typedArray != null) {
                            typedArray.recycle();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        Log.m187i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                        if (typedArray != null) {
                            typedArray.recycle();
                        }
                        switch (i2) {
                        }
                        m1449f = m1432a.m1449f(C0059a.j.Spinner_android_entries);
                        if (m1449f != null) {
                        }
                        m1432a.m1441b();
                        this.f1759h = true;
                        if (this.f1758g != null) {
                        }
                        this.f1755d.m1530a(attributeSet, i);
                    }
                } catch (Throwable th) {
                    th = th;
                    if (typedArray != null) {
                        typedArray.recycle();
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                typedArray = null;
            } catch (Throwable th2) {
                th = th2;
                typedArray = null;
                if (typedArray != null) {
                }
                throw th;
            }
        }
        switch (i2) {
            case 0:
                this.f1760i = new a();
                this.f1760i.mo1596a(m1432a.m1445d(C0059a.j.Spinner_android_prompt));
                break;
            case 1:
                final c cVar = new c(this.f1756e, attributeSet, i);
                C0184az m1432a2 = C0184az.m1432a(this.f1756e, attributeSet, C0059a.j.Spinner, i, 0);
                this.f1753a = m1432a2.m1448f(C0059a.j.Spinner_android_dropDownWidth, -2);
                cVar.m1312a(m1432a2.m1437a(C0059a.j.Spinner_android_popupBackground));
                cVar.mo1596a(m1432a.m1445d(C0059a.j.Spinner_android_prompt));
                m1432a2.m1441b();
                this.f1760i = cVar;
                this.f1757f = new AbstractViewOnAttachStateChangeListenerC0168aj(this) { // from class: androidx.appcompat.widget.y.1
                    @Override // androidx.appcompat.widget.AbstractViewOnAttachStateChangeListenerC0168aj
                    /* renamed from: a */
                    public InterfaceC0115p mo787a() {
                        return cVar;
                    }

                    @Override // androidx.appcompat.widget.AbstractViewOnAttachStateChangeListenerC0168aj
                    @SuppressLint({"SyntheticAccessor"})
                    /* renamed from: b */
                    public boolean mo788b() {
                        if (!C0215y.this.getInternalPopup().mo1602d()) {
                            C0215y.this.m1591a();
                            return true;
                        }
                        return true;
                    }
                };
                break;
        }
        m1449f = m1432a.m1449f(C0059a.j.Spinner_android_entries);
        if (m1449f != null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(context, C0012R.layout.simple_spinner_item, m1449f);
            arrayAdapter.setDropDownViewResource(C0059a.g.support_simple_spinner_dropdown_item);
            setAdapter((SpinnerAdapter) arrayAdapter);
        }
        m1432a.m1441b();
        this.f1759h = true;
        if (this.f1758g != null) {
            setAdapter(this.f1758g);
            this.f1758g = null;
        }
        this.f1755d.m1530a(attributeSet, i);
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f1756e;
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.f1760i != null) {
            this.f1760i.mo1595a(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(C0060a.m348b(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        if (this.f1760i != null) {
            return this.f1760i.mo1598b();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        if (this.f1760i != null) {
            this.f1760i.mo1593a(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        if (this.f1760i != null) {
            return this.f1760i.mo1597a_();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        if (this.f1760i != null) {
            this.f1760i.mo1601c(i);
            this.f1760i.mo1599b(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        if (this.f1760i != null) {
            return this.f1760i.mo1603f();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.f1760i != null) {
            this.f1753a = i;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.f1760i != null) {
            return this.f1753a;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1759h) {
            this.f1758g = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f1760i != null) {
            this.f1760i.mo1314a(new b(spinnerAdapter, (this.f1756e == null ? getContext() : this.f1756e).getTheme()));
        }
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1760i != null && this.f1760i.mo1602d()) {
            this.f1760i.mo1600c();
        }
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f1757f == null || !this.f1757f.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1760i != null && View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m1590a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        if (this.f1760i == null) {
            return super.performClick();
        }
        if (!this.f1760i.mo1602d()) {
            m1591a();
        }
        return true;
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        if (this.f1760i != null) {
            this.f1760i.mo1596a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        return this.f1760i != null ? this.f1760i.mo1592a() : super.getPrompt();
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1755d != null) {
            this.f1755d.m1526a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1755d != null) {
            this.f1755d.m1529a(drawable);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1755d != null) {
            this.f1755d.m1527a(colorStateList);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1755d != null) {
            return this.f1755d.m1525a();
        }
        return null;
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1755d != null) {
            this.f1755d.m1528a(mode);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0307w
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1755d != null) {
            return this.f1755d.m1531b();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1755d != null) {
            this.f1755d.m1533c();
        }
    }

    /* renamed from: a */
    int m1590a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        int i = 0;
        View view = null;
        int i2 = 0;
        while (max2 < min) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i) {
                view = null;
            } else {
                itemViewType = i;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
            max2++;
            i = itemViewType;
        }
        if (drawable == null) {
            return i2;
        }
        drawable.getPadding(this.f1754b);
        return this.f1754b.left + this.f1754b.right + i2;
    }

    final e getInternalPopup() {
        return this.f1760i;
    }

    /* renamed from: a */
    void m1591a() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.f1760i.mo1594a(getTextDirection(), getTextAlignment());
        } else {
            this.f1760i.mo1594a(-1, -1);
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f1780a = this.f1760i != null && this.f1760i.mo1602d();
        return dVar;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        if (dVar.f1780a && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.widget.y.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (!C0215y.this.getInternalPopup().mo1602d()) {
                        C0215y.this.m1591a();
                    }
                    ViewTreeObserver viewTreeObserver2 = C0215y.this.getViewTreeObserver();
                    if (viewTreeObserver2 != null) {
                        if (Build.VERSION.SDK_INT >= 16) {
                            viewTreeObserver2.removeOnGlobalLayoutListener(this);
                        } else {
                            viewTreeObserver2.removeGlobalOnLayoutListener(this);
                        }
                    }
                }
            });
        }
    }

    /* compiled from: AppCompatSpinner.java */
    /* renamed from: androidx.appcompat.widget.y$d */
    static class d extends View.BaseSavedState {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: androidx.appcompat.widget.y.d.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i) {
                return new d[i];
            }
        };

        /* renamed from: a */
        boolean f1780a;

        d(Parcelable parcelable) {
            super(parcelable);
        }

        d(Parcel parcel) {
            super(parcel);
            this.f1780a = parcel.readByte() != 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte((byte) (this.f1780a ? 1 : 0));
        }
    }

    /* compiled from: AppCompatSpinner.java */
    /* renamed from: androidx.appcompat.widget.y$b */
    private static class b implements ListAdapter, SpinnerAdapter {

        /* renamed from: a */
        private SpinnerAdapter f1768a;

        /* renamed from: b */
        private ListAdapter f1769b;

        public b(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f1768a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1769b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                        return;
                    }
                    return;
                }
                if (spinnerAdapter instanceof InterfaceC0180av) {
                    InterfaceC0180av interfaceC0180av = (InterfaceC0180av) spinnerAdapter;
                    if (interfaceC0180av.m1425a() == null) {
                        interfaceC0180av.m1426a(theme);
                    }
                }
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f1768a == null) {
                return 0;
            }
            return this.f1768a.getCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.f1768a == null) {
                return null;
            }
            return this.f1768a.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            if (this.f1768a == null) {
                return -1L;
            }
            return this.f1768a.getItemId(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            if (this.f1768a == null) {
                return null;
            }
            return this.f1768a.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            return this.f1768a != null && this.f1768a.hasStableIds();
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f1768a != null) {
                this.f1768a.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f1768a != null) {
                this.f1768a.unregisterDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1769b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f1769b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    /* compiled from: AppCompatSpinner.java */
    /* renamed from: androidx.appcompat.widget.y$a */
    class a implements DialogInterface.OnClickListener, e {

        /* renamed from: a */
        DialogInterfaceC0070b f1764a;

        /* renamed from: c */
        private ListAdapter f1766c;

        /* renamed from: d */
        private CharSequence f1767d;

        a() {
        }

        @Override // androidx.appcompat.widget.C0215y.e
        /* renamed from: c */
        public void mo1600c() {
            if (this.f1764a != null) {
                this.f1764a.dismiss();
                this.f1764a = null;
            }
        }

        @Override // androidx.appcompat.widget.C0215y.e
        /* renamed from: d */
        public boolean mo1602d() {
            if (this.f1764a != null) {
                return this.f1764a.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.C0215y.e
        /* renamed from: a */
        public void mo1314a(ListAdapter listAdapter) {
            this.f1766c = listAdapter;
        }

        @Override // androidx.appcompat.widget.C0215y.e
        /* renamed from: a */
        public void mo1596a(CharSequence charSequence) {
            this.f1767d = charSequence;
        }

        @Override // androidx.appcompat.widget.C0215y.e
        /* renamed from: a */
        public CharSequence mo1592a() {
            return this.f1767d;
        }

        @Override // androidx.appcompat.widget.C0215y.e
        /* renamed from: a */
        public void mo1594a(int i, int i2) {
            if (this.f1766c != null) {
                DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(C0215y.this.getPopupContext());
                if (this.f1767d != null) {
                    aVar.m427a(this.f1767d);
                }
                this.f1764a = aVar.m425a(this.f1766c, C0215y.this.getSelectedItemPosition(), this).m438b();
                ListView m415a = this.f1764a.m415a();
                if (Build.VERSION.SDK_INT >= 17) {
                    m415a.setTextDirection(i);
                    m415a.setTextAlignment(i2);
                }
                this.f1764a.show();
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            C0215y.this.setSelection(i);
            if (C0215y.this.getOnItemClickListener() != null) {
                C0215y.this.performItemClick(null, i, this.f1766c.getItemId(i));
            }
            mo1600c();
        }

        @Override // androidx.appcompat.widget.C0215y.e
        /* renamed from: a */
        public void mo1595a(Drawable drawable) {
            Log.m184e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.C0215y.e
        /* renamed from: a */
        public void mo1593a(int i) {
            Log.m184e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.C0215y.e
        /* renamed from: b */
        public void mo1599b(int i) {
            Log.m184e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.C0215y.e
        /* renamed from: b */
        public Drawable mo1598b() {
            return null;
        }

        @Override // androidx.appcompat.widget.C0215y.e
        /* renamed from: a_ */
        public int mo1597a_() {
            return 0;
        }

        @Override // androidx.appcompat.widget.C0215y.e
        /* renamed from: f */
        public int mo1603f() {
            return 0;
        }

        @Override // androidx.appcompat.widget.C0215y.e
        /* renamed from: c */
        public void mo1601c(int i) {
            Log.m184e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }
    }

    /* compiled from: AppCompatSpinner.java */
    /* renamed from: androidx.appcompat.widget.y$c */
    class c extends C0170al implements e {

        /* renamed from: a */
        ListAdapter f1770a;

        /* renamed from: h */
        private CharSequence f1772h;

        /* renamed from: i */
        private final Rect f1773i;

        /* renamed from: j */
        private int f1774j;

        public c(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f1773i = new Rect();
            m1320b(C0215y.this);
            m1316a(true);
            m1322d(0);
            m1313a(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.widget.y.c.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    C0215y.this.setSelection(i2);
                    if (C0215y.this.getOnItemClickListener() != null) {
                        C0215y.this.performItemClick(view, i2, c.this.f1770a.getItemId(i2));
                    }
                    c.this.mo842c();
                }
            });
        }

        @Override // androidx.appcompat.widget.C0170al, androidx.appcompat.widget.C0215y.e
        /* renamed from: a */
        public void mo1314a(ListAdapter listAdapter) {
            super.mo1314a(listAdapter);
            this.f1770a = listAdapter;
        }

        @Override // androidx.appcompat.widget.C0215y.e
        /* renamed from: a */
        public CharSequence mo1592a() {
            return this.f1772h;
        }

        @Override // androidx.appcompat.widget.C0215y.e
        /* renamed from: a */
        public void mo1596a(CharSequence charSequence) {
            this.f1772h = charSequence;
        }

        /* renamed from: g */
        void m1606g() {
            int i;
            int m1607h;
            Drawable b2 = m1318b();
            if (b2 != null) {
                b2.getPadding(C0215y.this.f1754b);
                i = C0191bf.m1481a(C0215y.this) ? C0215y.this.f1754b.right : -C0215y.this.f1754b.left;
            } else {
                Rect rect = C0215y.this.f1754b;
                C0215y.this.f1754b.right = 0;
                rect.left = 0;
                i = 0;
            }
            int paddingLeft = C0215y.this.getPaddingLeft();
            int paddingRight = C0215y.this.getPaddingRight();
            int width = C0215y.this.getWidth();
            if (C0215y.this.f1753a == -2) {
                int m1590a = C0215y.this.m1590a((SpinnerAdapter) this.f1770a, m1318b());
                int i2 = (C0215y.this.getContext().getResources().getDisplayMetrics().widthPixels - C0215y.this.f1754b.left) - C0215y.this.f1754b.right;
                if (m1590a <= i2) {
                    i2 = m1590a;
                }
                m1327h(Math.max(i2, (width - paddingLeft) - paddingRight));
            } else if (C0215y.this.f1753a == -1) {
                m1327h((width - paddingLeft) - paddingRight);
            } else {
                m1327h(C0215y.this.f1753a);
            }
            if (C0191bf.m1481a(C0215y.this)) {
                m1607h = (((width - paddingRight) - m1332k()) - m1607h()) + i;
            } else {
                m1607h = m1607h() + paddingLeft + i;
            }
            m1319b(m1607h);
        }

        @Override // androidx.appcompat.widget.C0215y.e
        /* renamed from: a */
        public void mo1594a(int i, int i2) {
            ViewTreeObserver viewTreeObserver;
            boolean d2 = mo845d();
            m1606g();
            m1328i(2);
            super.mo841b_();
            ListView e2 = mo846e();
            e2.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                e2.setTextDirection(i);
                e2.setTextAlignment(i2);
            }
            m1331j(C0215y.this.getSelectedItemPosition());
            if (!d2 && (viewTreeObserver = C0215y.this.getViewTreeObserver()) != null) {
                final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.widget.y.c.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        if (!c.this.m1605a(C0215y.this)) {
                            c.this.mo842c();
                        } else {
                            c.this.m1606g();
                            c.super.mo841b_();
                        }
                    }
                };
                viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
                m1315a(new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.widget.y.c.3
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        ViewTreeObserver viewTreeObserver2 = C0215y.this.getViewTreeObserver();
                        if (viewTreeObserver2 != null) {
                            viewTreeObserver2.removeGlobalOnLayoutListener(onGlobalLayoutListener);
                        }
                    }
                });
            }
        }

        /* renamed from: a */
        boolean m1605a(View view) {
            return C0308x.m2276w(view) && view.getGlobalVisibleRect(this.f1773i);
        }

        @Override // androidx.appcompat.widget.C0215y.e
        /* renamed from: c */
        public void mo1601c(int i) {
            this.f1774j = i;
        }

        /* renamed from: h */
        public int m1607h() {
            return this.f1774j;
        }
    }
}
