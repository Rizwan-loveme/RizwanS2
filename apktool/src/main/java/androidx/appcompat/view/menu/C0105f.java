package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.InterfaceC0113n;
import java.util.ArrayList;

/* compiled from: MenuAdapter.java */
/* renamed from: androidx.appcompat.view.menu.f */
/* loaded from: classes.dex */
public class C0105f extends BaseAdapter {

    /* renamed from: a */
    C0106g f990a;

    /* renamed from: b */
    private int f991b = -1;

    /* renamed from: c */
    private boolean f992c;

    /* renamed from: d */
    private final boolean f993d;

    /* renamed from: e */
    private final LayoutInflater f994e;

    /* renamed from: f */
    private final int f995f;

    public C0105f(C0106g c0106g, LayoutInflater layoutInflater, boolean z, int i) {
        this.f993d = z;
        this.f994e = layoutInflater;
        this.f990a = c0106g;
        this.f995f = i;
        m858b();
    }

    /* renamed from: a */
    public void m857a(boolean z) {
        this.f992c = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<C0108i> m909m = this.f993d ? this.f990a.m909m() : this.f990a.m906j();
        if (this.f991b < 0) {
            return m909m.size();
        }
        return m909m.size() - 1;
    }

    /* renamed from: a */
    public C0106g m855a() {
        return this.f990a;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0108i getItem(int i) {
        ArrayList<C0108i> m909m = this.f993d ? this.f990a.m909m() : this.f990a.m906j();
        if (this.f991b >= 0 && i >= this.f991b) {
            i++;
        }
        return m909m.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = view == null ? this.f994e.inflate(this.f995f, viewGroup, false) : view;
        int groupId = getItem(i).getGroupId();
        ((ListMenuItemView) inflate).setGroupDividerEnabled(this.f990a.mo891b() && groupId != (i + (-1) >= 0 ? getItem(i + (-1)).getGroupId() : groupId));
        InterfaceC0113n.a aVar = (InterfaceC0113n.a) inflate;
        if (this.f992c) {
            ((ListMenuItemView) inflate).setForceShowIcon(true);
        }
        aVar.mo782a(getItem(i), 0);
        return inflate;
    }

    /* renamed from: b */
    void m858b() {
        C0108i m915s = this.f990a.m915s();
        if (m915s != null) {
            ArrayList<C0108i> m909m = this.f990a.m909m();
            int size = m909m.size();
            for (int i = 0; i < size; i++) {
                if (m909m.get(i) == m915s) {
                    this.f991b = i;
                    return;
                }
            }
        }
        this.f991b = -1;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        m858b();
        super.notifyDataSetChanged();
    }
}
