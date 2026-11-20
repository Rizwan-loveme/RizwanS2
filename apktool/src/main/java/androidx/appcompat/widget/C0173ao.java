package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.C0095g;
import androidx.appcompat.view.menu.C0106g;
import androidx.appcompat.view.menu.C0111l;

/* compiled from: PopupMenu.java */
/* renamed from: androidx.appcompat.widget.ao */
/* loaded from: classes.dex */
public class C0173ao {

    /* renamed from: a */
    final C0111l f1504a;

    /* renamed from: b */
    b f1505b;

    /* renamed from: c */
    a f1506c;

    /* renamed from: d */
    private final Context f1507d;

    /* renamed from: e */
    private final C0106g f1508e;

    /* renamed from: f */
    private final View f1509f;

    /* compiled from: PopupMenu.java */
    /* renamed from: androidx.appcompat.widget.ao$a */
    public interface a {
        /* renamed from: a */
        void m1345a(C0173ao c0173ao);
    }

    /* compiled from: PopupMenu.java */
    /* renamed from: androidx.appcompat.widget.ao$b */
    public interface b {
        /* renamed from: a */
        boolean mo1346a(MenuItem menuItem);
    }

    public C0173ao(Context context, View view) {
        this(context, view, 0);
    }

    public C0173ao(Context context, View view, int i) {
        this(context, view, i, C0059a.a.popupMenuStyle, 0);
    }

    public C0173ao(Context context, View view, int i, int i2, int i3) {
        this.f1507d = context;
        this.f1509f = view;
        this.f1508e = new C0106g(context);
        this.f1508e.mo877a(new C0106g.a() { // from class: androidx.appcompat.widget.ao.1
            @Override // androidx.appcompat.view.menu.C0106g.a
            /* renamed from: a */
            public boolean mo532a(C0106g c0106g, MenuItem menuItem) {
                if (C0173ao.this.f1505b != null) {
                    return C0173ao.this.f1505b.mo1346a(menuItem);
                }
                return false;
            }

            @Override // androidx.appcompat.view.menu.C0106g.a
            /* renamed from: a */
            public void mo529a(C0106g c0106g) {
            }
        });
        this.f1504a = new C0111l(context, this.f1508e, view, false, i2, i3);
        this.f1504a.m963a(i);
        this.f1504a.m965a(new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.widget.ao.2
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (C0173ao.this.f1506c != null) {
                    C0173ao.this.f1506c.m1345a(C0173ao.this);
                }
            }
        });
    }

    /* renamed from: a */
    public void m1340a(int i) {
        this.f1504a.m963a(i);
    }

    /* renamed from: a */
    public Menu m1339a() {
        return this.f1508e;
    }

    /* renamed from: b */
    public MenuInflater m1342b() {
        return new C0095g(this.f1507d);
    }

    /* renamed from: b */
    public void m1343b(int i) {
        m1342b().inflate(i, this.f1508e);
    }

    /* renamed from: c */
    public void m1344c() {
        this.f1504a.m962a();
    }

    /* renamed from: a */
    public void m1341a(b bVar) {
        this.f1505b = bVar;
    }
}
