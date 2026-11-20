package ru.maximoff.apktool.fragment.p301a;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.p044h.p045a.AbstractC0405a;
import androidx.p044h.p045a.C0406b;
import com.srizwan.apktool.R;
import ru.maximoff.apktool.fragment.MenuItemOnActionExpandListenerC2976a;

/* compiled from: EditorTitleAdapter.java */
/* renamed from: ru.maximoff.apktool.fragment.a.d */
/* loaded from: classes.dex */
public class C2980d extends BaseAdapter implements C0406b.e {

    /* renamed from: b */
    private final MenuItemOnActionExpandListenerC2976a f16266b;

    /* renamed from: a */
    private final DataSetObserver f16265a = new DataSetObserver(this) { // from class: ru.maximoff.apktool.fragment.a.d.1

        /* renamed from: a */
        private final C2980d f16268a;

        {
            this.f16268a = this;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            this.f16268a.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.f16268a.notifyDataSetInvalidated();
        }
    };

    /* renamed from: c */
    private AbstractC0405a f16267c = (AbstractC0405a) null;

    @Override // androidx.p044h.p045a.C0406b.e
    /* renamed from: a */
    public void mo100a(C0406b c0406b, AbstractC0405a abstractC0405a, AbstractC0405a abstractC0405a2) {
        this.f16267c = abstractC0405a2;
        if (abstractC0405a != null) {
            abstractC0405a.m3284b(this.f16265a);
        }
        if (abstractC0405a2 != null) {
            abstractC0405a2.m3275a(this.f16265a);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f16267c == null) {
            return 0;
        }
        return this.f16267c.mo3270a();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f16267c.mo3272a(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f16266b.m2775B().inflate(R.layout.title, viewGroup, false);
        }
        ((TextView) view.findViewById(R.id.name)).setText(this.f16267c.mo3272a(i));
        return view;
    }

    public C2980d(MenuItemOnActionExpandListenerC2976a menuItemOnActionExpandListenerC2976a, C0406b c0406b) {
        this.f16266b = menuItemOnActionExpandListenerC2976a;
        c0406b.m3322a(this);
    }
}
