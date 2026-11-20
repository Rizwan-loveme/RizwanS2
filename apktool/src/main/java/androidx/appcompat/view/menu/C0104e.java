package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.IBinder;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.menu.InterfaceC0112m;
import androidx.appcompat.view.menu.InterfaceC0113n;
import java.util.ArrayList;

/* compiled from: ListMenuPresenter.java */
/* renamed from: androidx.appcompat.view.menu.e */
/* loaded from: classes.dex */
public class C0104e implements AdapterView.OnItemClickListener, InterfaceC0112m {

    /* renamed from: a */
    Context f979a;

    /* renamed from: b */
    LayoutInflater f980b;

    /* renamed from: c */
    C0106g f981c;

    /* renamed from: d */
    ExpandedMenuView f982d;

    /* renamed from: e */
    int f983e;

    /* renamed from: f */
    int f984f;

    /* renamed from: g */
    int f985g;

    /* renamed from: h */
    a f986h;

    /* renamed from: i */
    private InterfaceC0112m.a f987i;

    public C0104e(Context context, int i) {
        this(i, 0);
        this.f979a = context;
        this.f980b = LayoutInflater.from(this.f979a);
    }

    public C0104e(int i, int i2) {
        this.f985g = i;
        this.f984f = i2;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: a */
    public void mo810a(Context context, C0106g c0106g) {
        if (this.f984f != 0) {
            this.f979a = new ContextThemeWrapper(context, this.f984f);
            this.f980b = LayoutInflater.from(this.f979a);
        } else if (this.f979a != null) {
            this.f979a = context;
            if (this.f980b == null) {
                this.f980b = LayoutInflater.from(this.f979a);
            }
        }
        this.f981c = c0106g;
        if (this.f986h != null) {
            this.f986h.notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public InterfaceC0113n m852a(ViewGroup viewGroup) {
        if (this.f982d == null) {
            this.f982d = (ExpandedMenuView) this.f980b.inflate(C0059a.g.abc_expanded_menu_layout, viewGroup, false);
            if (this.f986h == null) {
                this.f986h = new a();
            }
            this.f982d.setAdapter((ListAdapter) this.f986h);
            this.f982d.setOnItemClickListener(this);
        }
        return this.f982d;
    }

    /* renamed from: a */
    public ListAdapter m851a() {
        if (this.f986h == null) {
            this.f986h = new a();
        }
        return this.f986h;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: a */
    public void mo815a(boolean z) {
        if (this.f986h != null) {
            this.f986h.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: a */
    public void mo814a(InterfaceC0112m.a aVar) {
        this.f987i = aVar;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: a */
    public boolean mo819a(SubMenuC0117r subMenuC0117r) {
        if (!subMenuC0117r.hasVisibleItems()) {
            return false;
        }
        new DialogInterfaceOnClickListenerC0107h(subMenuC0117r).m917a((IBinder) null);
        if (this.f987i != null) {
            this.f987i.mo559a(subMenuC0117r);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: a */
    public void mo812a(C0106g c0106g, boolean z) {
        if (this.f987i != null) {
            this.f987i.mo558a(c0106g, z);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f981c.m884a(this.f986h.getItem(i), this, 0);
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: b */
    public boolean mo821b() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: a */
    public boolean mo818a(C0106g c0106g, C0108i c0108i) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: b */
    public boolean mo822b(C0106g c0106g, C0108i c0108i) {
        return false;
    }

    /* compiled from: ListMenuPresenter.java */
    /* renamed from: androidx.appcompat.view.menu.e$a */
    private class a extends BaseAdapter {

        /* renamed from: b */
        private int f989b = -1;

        public a() {
            m854a();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = C0104e.this.f981c.m909m().size() - C0104e.this.f983e;
            return this.f989b < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0108i getItem(int i) {
            ArrayList<C0108i> m909m = C0104e.this.f981c.m909m();
            int i2 = C0104e.this.f983e + i;
            if (this.f989b >= 0 && i2 >= this.f989b) {
                i2++;
            }
            return m909m.get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = view == null ? C0104e.this.f980b.inflate(C0104e.this.f985g, viewGroup, false) : view;
            ((InterfaceC0113n.a) inflate).mo782a(getItem(i), 0);
            return inflate;
        }

        /* renamed from: a */
        void m854a() {
            C0108i m915s = C0104e.this.f981c.m915s();
            if (m915s != null) {
                ArrayList<C0108i> m909m = C0104e.this.f981c.m909m();
                int size = m909m.size();
                for (int i = 0; i < size; i++) {
                    if (m909m.get(i) == m915s) {
                        this.f989b = i;
                        return;
                    }
                }
            }
            this.f989b = -1;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            m854a();
            super.notifyDataSetChanged();
        }
    }
}
