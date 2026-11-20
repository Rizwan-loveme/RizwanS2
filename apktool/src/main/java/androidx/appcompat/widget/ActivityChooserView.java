package androidx.appcompat.widget;

import android.C0012R;
import android.content.Context;
import android.content.Intent;
import android.content.p006pm.PackageManager;
import android.content.p006pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.core.p031f.AbstractC0283b;

/* loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup {

    /* renamed from: a */
    final C0130a f1189a;

    /* renamed from: b */
    final FrameLayout f1190b;

    /* renamed from: c */
    final FrameLayout f1191c;

    /* renamed from: d */
    AbstractC0283b f1192d;

    /* renamed from: e */
    final DataSetObserver f1193e;

    /* renamed from: f */
    PopupWindow.OnDismissListener f1194f;

    /* renamed from: g */
    boolean f1195g;

    /* renamed from: h */
    int f1196h;

    /* renamed from: i */
    private final ViewOnClickListenerC0131b f1197i;

    /* renamed from: j */
    private final View f1198j;

    /* renamed from: k */
    private final ImageView f1199k;

    /* renamed from: l */
    private final int f1200l;

    /* renamed from: m */
    private final ViewTreeObserver.OnGlobalLayoutListener f1201m;

    /* renamed from: n */
    private C0170al f1202n;

    /* renamed from: o */
    private boolean f1203o;

    /* renamed from: p */
    private int f1204p;

    public void setActivityChooserModel(C0194d c0194d) {
        this.f1189a.m1038a(c0194d);
        if (m1035c()) {
            m1034b();
            m1033a();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1199k.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f1199k.setContentDescription(getContext().getString(i));
    }

    public void setProvider(AbstractC0283b abstractC0283b) {
        this.f1192d = abstractC0283b;
    }

    /* renamed from: a */
    public boolean m1033a() {
        if (m1035c() || !this.f1203o) {
            return false;
        }
        this.f1195g = false;
        m1032a(this.f1196h);
        return true;
    }

    /* renamed from: a */
    void m1032a(int i) {
        if (this.f1189a.m1043d() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f1201m);
        boolean z = this.f1191c.getVisibility() == 0;
        int m1042c = this.f1189a.m1042c();
        int i2 = z ? 1 : 0;
        if (i != Integer.MAX_VALUE && m1042c > i2 + i) {
            this.f1189a.m1039a(true);
            this.f1189a.m1037a(i - 1);
        } else {
            this.f1189a.m1039a(false);
            this.f1189a.m1037a(i);
        }
        C0170al listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.mo845d()) {
            if (this.f1195g || !z) {
                this.f1189a.m1040a(true, z);
            } else {
                this.f1189a.m1040a(false, false);
            }
            listPopupWindow.m1327h(Math.min(this.f1189a.m1036a(), this.f1200l));
            listPopupWindow.mo841b_();
            if (this.f1192d != null) {
                this.f1192d.m2129a(true);
            }
            listPopupWindow.mo846e().setContentDescription(getContext().getString(C0059a.h.abc_activitychooserview_choose_application));
            listPopupWindow.mo846e().setSelector(new ColorDrawable(0));
        }
    }

    /* renamed from: b */
    public boolean m1034b() {
        if (m1035c()) {
            getListPopupWindow().mo842c();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f1201m);
                return true;
            }
            return true;
        }
        return true;
    }

    /* renamed from: c */
    public boolean m1035c() {
        return getListPopupWindow().mo845d();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0194d m1043d = this.f1189a.m1043d();
        if (m1043d != null) {
            m1043d.registerObserver(this.f1193e);
        }
        this.f1203o = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0194d m1043d = this.f1189a.m1043d();
        if (m1043d != null) {
            m1043d.unregisterObserver(this.f1193e);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1201m);
        }
        if (m1035c()) {
            m1034b();
        }
        this.f1203o = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        View view = this.f1198j;
        if (this.f1191c.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1198j.layout(0, 0, i3 - i, i4 - i2);
        if (!m1035c()) {
            m1034b();
        }
    }

    public C0194d getDataModel() {
        return this.f1189a.m1043d();
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f1194f = onDismissListener;
    }

    public void setInitialActivityCount(int i) {
        this.f1196h = i;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.f1204p = i;
    }

    C0170al getListPopupWindow() {
        if (this.f1202n == null) {
            this.f1202n = new C0170al(getContext());
            this.f1202n.mo1314a(this.f1189a);
            this.f1202n.m1320b(this);
            this.f1202n.m1316a(true);
            this.f1202n.m1313a((AdapterView.OnItemClickListener) this.f1197i);
            this.f1202n.m1315a((PopupWindow.OnDismissListener) this.f1197i);
        }
        return this.f1202n;
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$b */
    private class ViewOnClickListenerC0131b implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {

        /* renamed from: a */
        final /* synthetic */ ActivityChooserView f1212a;

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((C0130a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    this.f1212a.m1034b();
                    if (this.f1212a.f1195g) {
                        if (i > 0) {
                            this.f1212a.f1189a.m1043d().m1518c(i);
                            return;
                        }
                        return;
                    }
                    if (!this.f1212a.f1189a.m1044e()) {
                        i++;
                    }
                    Intent m1516b = this.f1212a.f1189a.m1043d().m1516b(i);
                    if (m1516b != null) {
                        m1516b.addFlags(524288);
                        this.f1212a.getContext().startActivity(m1516b);
                        return;
                    }
                    return;
                case 1:
                    this.f1212a.m1032a(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.f1212a.f1191c) {
                this.f1212a.m1034b();
                Intent m1516b = this.f1212a.f1189a.m1043d().m1516b(this.f1212a.f1189a.m1043d().m1514a(this.f1212a.f1189a.m1041b()));
                if (m1516b != null) {
                    m1516b.addFlags(524288);
                    this.f1212a.getContext().startActivity(m1516b);
                    return;
                }
                return;
            }
            if (view == this.f1212a.f1190b) {
                this.f1212a.f1195g = false;
                this.f1212a.m1032a(this.f1212a.f1196h);
                return;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view == this.f1212a.f1191c) {
                if (this.f1212a.f1189a.getCount() > 0) {
                    this.f1212a.f1195g = true;
                    this.f1212a.m1032a(this.f1212a.f1196h);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            m1045a();
            if (this.f1212a.f1192d != null) {
                this.f1212a.f1192d.m2129a(false);
            }
        }

        /* renamed from: a */
        private void m1045a() {
            if (this.f1212a.f1194f != null) {
                this.f1212a.f1194f.onDismiss();
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$a */
    private class C0130a extends BaseAdapter {

        /* renamed from: a */
        final /* synthetic */ ActivityChooserView f1206a;

        /* renamed from: b */
        private C0194d f1207b;

        /* renamed from: c */
        private int f1208c;

        /* renamed from: d */
        private boolean f1209d;

        /* renamed from: e */
        private boolean f1210e;

        /* renamed from: f */
        private boolean f1211f;

        /* renamed from: a */
        public void m1038a(C0194d c0194d) {
            C0194d m1043d = this.f1206a.f1189a.m1043d();
            if (m1043d != null && this.f1206a.isShown()) {
                m1043d.unregisterObserver(this.f1206a.f1193e);
            }
            this.f1207b = c0194d;
            if (c0194d != null && this.f1206a.isShown()) {
                c0194d.registerObserver(this.f1206a.f1193e);
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return (this.f1211f && i == getCount() + (-1)) ? 1 : 0;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int m1513a = this.f1207b.m1513a();
            if (!this.f1209d && this.f1207b.m1517b() != null) {
                m1513a--;
            }
            int min = Math.min(m1513a, this.f1208c);
            if (this.f1211f) {
                return min + 1;
            }
            return min;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!this.f1209d && this.f1207b.m1517b() != null) {
                        i++;
                    }
                    return this.f1207b.m1515a(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != C0059a.f.list_item) {
                        view = LayoutInflater.from(this.f1206a.getContext()).inflate(C0059a.g.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = this.f1206a.getContext().getPackageManager();
                    ImageView imageView = (ImageView) view.findViewById(C0059a.f.icon);
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(C0059a.f.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (this.f1209d && i == 0 && this.f1210e) {
                        view.setActivated(true);
                        return view;
                    }
                    view.setActivated(false);
                    return view;
                case 1:
                    if (view == null || view.getId() != 1) {
                        View inflate = LayoutInflater.from(this.f1206a.getContext()).inflate(C0059a.g.abc_activity_chooser_view_list_item, viewGroup, false);
                        inflate.setId(1);
                        ((TextView) inflate.findViewById(C0059a.f.title)).setText(this.f1206a.getContext().getString(C0059a.h.abc_activity_chooser_view_see_all));
                        return inflate;
                    }
                    return view;
                default:
                    throw new IllegalArgumentException();
            }
        }

        /* renamed from: a */
        public int m1036a() {
            int i = this.f1208c;
            this.f1208c = Integer.MAX_VALUE;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            int i2 = 0;
            View view = null;
            int i3 = 0;
            while (i2 < count) {
                View view2 = getView(i2, view, null);
                view2.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view2.getMeasuredWidth());
                i2++;
                view = view2;
            }
            this.f1208c = i;
            return i3;
        }

        /* renamed from: a */
        public void m1037a(int i) {
            if (this.f1208c != i) {
                this.f1208c = i;
                notifyDataSetChanged();
            }
        }

        /* renamed from: b */
        public ResolveInfo m1041b() {
            return this.f1207b.m1517b();
        }

        /* renamed from: a */
        public void m1039a(boolean z) {
            if (this.f1211f != z) {
                this.f1211f = z;
                notifyDataSetChanged();
            }
        }

        /* renamed from: c */
        public int m1042c() {
            return this.f1207b.m1513a();
        }

        /* renamed from: d */
        public C0194d m1043d() {
            return this.f1207b;
        }

        /* renamed from: a */
        public void m1040a(boolean z, boolean z2) {
            if (this.f1209d != z || this.f1210e != z2) {
                this.f1209d = z;
                this.f1210e = z2;
                notifyDataSetChanged();
            }
        }

        /* renamed from: e */
        public boolean m1044e() {
            return this.f1209d;
        }
    }

    public static class InnerLayout extends LinearLayout {

        /* renamed from: a */
        private static final int[] f1205a = {C0012R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            C0184az m1431a = C0184az.m1431a(context, attributeSet, f1205a);
            setBackgroundDrawable(m1431a.m1437a(0));
            m1431a.m1441b();
        }
    }
}
