package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.InterfaceC0112m;
import androidx.appcompat.view.menu.InterfaceC0113n;
import java.util.ArrayList;

/* compiled from: BaseMenuPresenter.java */
/* renamed from: androidx.appcompat.view.menu.b */
/* loaded from: classes.dex */
public abstract class AbstractC0101b implements InterfaceC0112m {

    /* renamed from: a */
    protected Context f929a;

    /* renamed from: b */
    protected Context f930b;

    /* renamed from: c */
    protected C0106g f931c;

    /* renamed from: d */
    protected LayoutInflater f932d;

    /* renamed from: e */
    protected LayoutInflater f933e;

    /* renamed from: f */
    protected InterfaceC0113n f934f;

    /* renamed from: g */
    private InterfaceC0112m.a f935g;

    /* renamed from: h */
    private int f936h;

    /* renamed from: i */
    private int f937i;

    /* renamed from: j */
    private int f938j;

    /* renamed from: a */
    public abstract void mo813a(C0108i c0108i, InterfaceC0113n.a aVar);

    public AbstractC0101b(Context context, int i, int i2) {
        this.f929a = context;
        this.f932d = LayoutInflater.from(context);
        this.f936h = i;
        this.f937i = i2;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: a */
    public void mo810a(Context context, C0106g c0106g) {
        this.f930b = context;
        this.f933e = LayoutInflater.from(this.f930b);
        this.f931c = c0106g;
    }

    /* renamed from: a */
    public InterfaceC0113n mo808a(ViewGroup viewGroup) {
        if (this.f934f == null) {
            this.f934f = (InterfaceC0113n) this.f932d.inflate(this.f936h, viewGroup, false);
            this.f934f.mo790a(this.f931c);
            mo815a(true);
        }
        return this.f934f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: a */
    public void mo815a(boolean z) {
        int i;
        int i2;
        ViewGroup viewGroup = (ViewGroup) this.f934f;
        if (viewGroup != null) {
            if (this.f931c != null) {
                this.f931c.m907k();
                ArrayList<C0108i> m906j = this.f931c.m906j();
                int size = m906j.size();
                int i3 = 0;
                i = 0;
                while (i3 < size) {
                    C0108i c0108i = m906j.get(i3);
                    if (mo816a(i, c0108i)) {
                        View childAt = viewGroup.getChildAt(i);
                        C0108i itemData = childAt instanceof InterfaceC0113n.a ? ((InterfaceC0113n.a) childAt).getItemData() : null;
                        View mo806a = mo806a(c0108i, childAt, viewGroup);
                        if (c0108i != itemData) {
                            mo806a.setPressed(false);
                            mo806a.jumpDrawablesToCurrentState();
                        }
                        if (mo806a != childAt) {
                            m811a(mo806a, i);
                        }
                        i2 = i + 1;
                    } else {
                        i2 = i;
                    }
                    i3++;
                    i = i2;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!mo817a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    /* renamed from: a */
    protected void m811a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f934f).addView(view, i);
    }

    /* renamed from: a */
    protected boolean mo817a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: a */
    public void mo814a(InterfaceC0112m.a aVar) {
        this.f935g = aVar;
    }

    /* renamed from: a */
    public InterfaceC0112m.a m807a() {
        return this.f935g;
    }

    /* renamed from: b */
    public InterfaceC0113n.a m820b(ViewGroup viewGroup) {
        return (InterfaceC0113n.a) this.f932d.inflate(this.f937i, viewGroup, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public View mo806a(C0108i c0108i, View view, ViewGroup viewGroup) {
        InterfaceC0113n.a aVar;
        if (view instanceof InterfaceC0113n.a) {
            aVar = (InterfaceC0113n.a) view;
        } else {
            aVar = m820b(viewGroup);
        }
        mo813a(c0108i, aVar);
        return (View) aVar;
    }

    /* renamed from: a */
    public boolean mo816a(int i, C0108i c0108i) {
        return true;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: a */
    public void mo812a(C0106g c0106g, boolean z) {
        if (this.f935g != null) {
            this.f935g.mo558a(c0106g, z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.appcompat.view.menu.g] */
    @Override // androidx.appcompat.view.menu.InterfaceC0112m
    /* renamed from: a */
    public boolean mo819a(SubMenuC0117r subMenuC0117r) {
        if (this.f935g != null) {
            InterfaceC0112m.a aVar = this.f935g;
            SubMenuC0117r subMenuC0117r2 = subMenuC0117r;
            if (subMenuC0117r == null) {
                subMenuC0117r2 = this.f931c;
            }
            return aVar.mo559a(subMenuC0117r2);
        }
        return false;
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

    /* renamed from: a */
    public void m809a(int i) {
        this.f938j = i;
    }
}
