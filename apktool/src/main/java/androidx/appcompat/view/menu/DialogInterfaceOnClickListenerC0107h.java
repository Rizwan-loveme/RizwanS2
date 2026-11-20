package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.p008os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.C0059a;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.view.menu.InterfaceC0112m;

/* compiled from: MenuDialogHelper.java */
/* renamed from: androidx.appcompat.view.menu.h */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0107h implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, InterfaceC0112m.a {

    /* renamed from: a */
    C0104e f1023a;

    /* renamed from: b */
    private C0106g f1024b;

    /* renamed from: c */
    private DialogInterfaceC0070b f1025c;

    /* renamed from: d */
    private InterfaceC0112m.a f1026d;

    public DialogInterfaceOnClickListenerC0107h(C0106g c0106g) {
        this.f1024b = c0106g;
    }

    /* renamed from: a */
    public void m917a(IBinder iBinder) {
        C0106g c0106g = this.f1024b;
        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(c0106g.m902f());
        this.f1023a = new C0104e(aVar.m417a(), C0059a.g.abc_list_menu_item_layout);
        this.f1023a.mo814a(this);
        this.f1024b.m879a(this.f1023a);
        aVar.m426a(this.f1023a.m851a(), this);
        View m912p = c0106g.m912p();
        if (m912p != null) {
            aVar.m424a(m912p);
        } else {
            aVar.m423a(c0106g.m911o()).m427a(c0106g.m910n());
        }
        aVar.m422a(this);
        this.f1025c = aVar.m438b();
        this.f1025c.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f1025c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f1025c.show();
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f1025c.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f1025c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f1024b.m882a(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f1024b.performShortcut(i, keyEvent, 0);
    }

    /* renamed from: a */
    public void m916a() {
        if (this.f1025c != null) {
            this.f1025c.dismiss();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f1023a.mo812a(this.f1024b, true);
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0112m.a
    /* renamed from: a */
    public void mo558a(C0106g c0106g, boolean z) {
        if (z || c0106g == this.f1024b) {
            m916a();
        }
        if (this.f1026d != null) {
            this.f1026d.mo558a(c0106g, z);
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0112m.a
    /* renamed from: a */
    public boolean mo559a(C0106g c0106g) {
        if (this.f1026d != null) {
            return this.f1026d.mo559a(c0106g);
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1024b.m883a((C0108i) this.f1023a.m851a().getItem(i), 0);
    }
}
