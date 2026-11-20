package com.p159h.p160a.p161a;

import android.C0012R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListPopupWindow;
import android.widget.TextView;
import com.p159h.p160a.p162b.AbstractC1389k;
import com.p159h.p160a.p162b.C1387i;
import com.p159h.p160a.p162b.C1390l;
import java.util.ArrayList;

/* compiled from: AutoCompletePanel.java */
/* renamed from: com.h.a.a.a */
/* loaded from: classes.dex */
public class C1369a {

    /* renamed from: a */
    private C1371c f8823a;

    /* renamed from: b */
    private Context f8824b;

    /* renamed from: c */
    private AbstractC1389k f8825c = C1390l.m11083b();

    /* renamed from: d */
    private ListPopupWindow f8826d;

    /* renamed from: e */
    private a f8827e;

    /* renamed from: f */
    private Filter f8828f;

    /* renamed from: g */
    private int f8829g;

    /* renamed from: h */
    private int f8830h;

    /* renamed from: i */
    private int f8831i;

    /* renamed from: j */
    private CharSequence f8832j;

    /* renamed from: k */
    private GradientDrawable f8833k;

    /* renamed from: l */
    private int f8834l;

    public C1369a(C1371c c1371c) {
        this.f8823a = c1371c;
        this.f8824b = c1371c.getContext();
        m10778c();
    }

    /* renamed from: a */
    public void m10786a(int i) {
        this.f8834l = i;
        this.f8833k.setStroke(1, i);
        this.f8826d.setBackgroundDrawable(this.f8833k);
    }

    /* renamed from: c */
    private void m10778c() {
        this.f8826d = new ListPopupWindow(this.f8824b);
        this.f8826d.setAnchorView(this.f8823a);
        this.f8827e = new a(this, this.f8824b, C0012R.layout.simple_list_item_1);
        this.f8826d.setAdapter(this.f8827e);
        this.f8828f = this.f8827e.getFilter();
        m10779c(300);
        TypedArray obtainStyledAttributes = this.f8824b.getTheme().obtainStyledAttributes(new int[]{C0012R.attr.colorBackground, C0012R.attr.textColorPrimary});
        int color = obtainStyledAttributes.getColor(0, 16711935);
        int color2 = obtainStyledAttributes.getColor(1, 16777215);
        obtainStyledAttributes.recycle();
        this.f8833k = new GradientDrawable();
        this.f8833k.setColor(color);
        this.f8833k.setCornerRadius(4);
        this.f8833k.setStroke(1, color2);
        m10786a(color2);
        this.f8826d.setBackgroundDrawable(this.f8833k);
        this.f8826d.setOnItemClickListener(new AdapterView.OnItemClickListener(this) { // from class: com.h.a.a.a.1

            /* renamed from: a */
            private final C1369a f8835a;

            {
                this.f8835a = this;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.f8835a.f8823a.m10869a(this.f8835a.f8823a.getCaretPosition() - this.f8835a.f8832j.length(), this.f8835a.f8832j.length(), ((TextView) view).getText().toString());
                this.f8835a.f8827e.m10793a();
                this.f8835a.m10789b();
            }
        });
    }

    /* renamed from: b */
    public void m10790b(int i) {
        this.f8826d.setWidth(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m10779c(int i) {
        if (this.f8830h != i) {
            this.f8830h = i;
            this.f8826d.setHeight(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m10782d(int i) {
        int min = Math.min(i, this.f8823a.getWidth() / 2);
        if (this.f8831i != min) {
            this.f8831i = min;
            this.f8826d.setHorizontalOffset(min);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m10784e(int i) {
        int height = 0 - this.f8826d.getHeight();
        if (i > height) {
            this.f8823a.scrollBy(0, i - height);
            i = height;
        }
        if (this.f8829g != i) {
            this.f8829g = i;
            this.f8826d.setVerticalOffset(i);
        }
    }

    /* renamed from: a */
    public void m10788a(CharSequence charSequence) {
        this.f8827e.m10794b();
        this.f8828f.filter(charSequence);
    }

    /* renamed from: a */
    public void m10785a() {
        if (!this.f8826d.isShowing()) {
            this.f8826d.show();
        }
        this.f8826d.getListView().setFadingEdgeLength(0);
    }

    /* renamed from: b */
    public void m10789b() {
        if (this.f8826d.isShowing()) {
            this.f8826d.dismiss();
        }
    }

    /* renamed from: a */
    public synchronized void m10787a(AbstractC1389k abstractC1389k) {
        this.f8825c = abstractC1389k;
    }

    /* compiled from: AutoCompletePanel.java */
    /* renamed from: com.h.a.a.a$a */
    class a extends ArrayAdapter<String> implements Filterable {

        /* renamed from: a */
        private int f8836a;

        /* renamed from: b */
        private C1387i f8837b;

        /* renamed from: c */
        private DisplayMetrics f8838c;

        /* renamed from: d */
        private final C1369a f8839d;

        /* renamed from: b */
        static C1369a m10792b(a aVar) {
            return aVar.f8839d;
        }

        public a(C1369a c1369a, Context context, int i) {
            super(context, i);
            this.f8839d = c1369a;
            this.f8837b = new C1387i();
            setNotifyOnChange(false);
            this.f8838c = context.getResources().getDisplayMetrics();
        }

        /* renamed from: a */
        public void m10793a() {
            this.f8837b.m11065a();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView = (TextView) super.getView(i, view, viewGroup);
            textView.setTextColor(this.f8839d.f8834l);
            return textView;
        }

        /* renamed from: b */
        public void m10794b() {
            this.f8837b.m11066b();
        }

        /* renamed from: c */
        public int m10795c() {
            if (this.f8836a != 0) {
                return this.f8836a;
            }
            TextView textView = (TextView) ((LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(C0012R.layout.simple_list_item_1, (ViewGroup) null);
            textView.measure(0, 0);
            this.f8836a = textView.getMeasuredHeight();
            return this.f8836a;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Filterable
        public Filter getFilter() {
            return new Filter(this) { // from class: com.h.a.a.a.a.1

                /* renamed from: a */
                private final a f8840a;

                {
                    this.f8840a = this;
                }

                @Override // android.widget.Filter
                protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    a.m10792b(this.f8840a).f8832j = a.m10792b(this.f8840a).f8825c.mo11078a(arrayList, charSequence);
                    Filter.FilterResults filterResults = new Filter.FilterResults();
                    filterResults.values = arrayList;
                    filterResults.count = arrayList.size();
                    return filterResults;
                }

                @Override // android.widget.Filter
                protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                    if (filterResults != null && filterResults.count > 0 && !this.f8840a.f8837b.m11067c()) {
                        this.f8840a.clear();
                        this.f8840a.addAll((ArrayList) filterResults.values);
                        int caretY = (a.m10792b(this.f8840a).f8823a.getCaretY() + (a.m10792b(this.f8840a).f8823a.m10900h() / 2)) - a.m10792b(this.f8840a).f8823a.getScrollY();
                        a.m10792b(this.f8840a).m10779c((int) Math.min(a.m10792b(this.f8840a).f8823a.getContentHeight() * 0.9f, this.f8840a.m10795c() * filterResults.count));
                        a.m10792b(this.f8840a).m10790b((int) (a.m10792b(this.f8840a).f8823a.getContentWidth() * 0.9f));
                        a.m10792b(this.f8840a).m10782d(((int) (a.m10792b(this.f8840a).f8823a.getContentWidth() * 0.05f)) + a.m10792b(this.f8840a).f8823a.getScrollX());
                        a.m10792b(this.f8840a).m10784e(caretY - a.m10792b(this.f8840a).f8823a.getHeight());
                        this.f8840a.notifyDataSetChanged();
                        a.m10792b(this.f8840a).m10785a();
                        return;
                    }
                    this.f8840a.notifyDataSetInvalidated();
                }
            };
        }
    }
}
