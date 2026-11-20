package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.AbstractC0090b;
import androidx.core.p031f.C0290f;

/* compiled from: AppCompatDialog.java */
/* renamed from: androidx.appcompat.app.g */
/* loaded from: classes.dex */
public class DialogC0075g extends Dialog implements InterfaceC0072d {

    /* renamed from: a */
    private AbstractC0073e f652a;

    /* renamed from: b */
    private final C0290f.a f653b;

    public DialogC0075g(Context context, int i) {
        super(context, m581a(context, i));
        this.f653b = new C0290f.a() { // from class: androidx.appcompat.app.g.1
            @Override // androidx.core.p031f.C0290f.a
            /* renamed from: a */
            public boolean mo585a(KeyEvent keyEvent) {
                return DialogC0075g.this.m582a(keyEvent);
            }
        };
        AbstractC0073e m583b = m583b();
        m583b.mo468a(m581a(context, i));
        m583b.mo471a((Bundle) null);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        m583b().mo488h();
        super.onCreate(bundle);
        m583b().mo471a(bundle);
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        m583b().mo481c(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        m583b().mo472a(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m583b().mo473a(view, layoutParams);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        return (T) m583b().mo477b(i);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        m583b().mo474a(charSequence);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        m583b().mo474a(getContext().getString(i));
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m583b().mo479b(view, layoutParams);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        m583b().mo483d();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        m583b().mo487g();
    }

    /* renamed from: b */
    public boolean m584b(int i) {
        return m583b().mo484d(i);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        m583b().mo486f();
    }

    /* renamed from: b */
    public AbstractC0073e m583b() {
        if (this.f652a == null) {
            this.f652a = AbstractC0073e.m461a(this, this);
        }
        return this.f652a;
    }

    /* renamed from: a */
    private static int m581a(Context context, int i) {
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(C0059a.a.dialogTheme, typedValue, true);
            return typedValue.resourceId;
        }
        return i;
    }

    @Override // androidx.appcompat.app.InterfaceC0072d
    /* renamed from: a */
    public void mo446a(AbstractC0090b abstractC0090b) {
    }

    @Override // androidx.appcompat.app.InterfaceC0072d
    /* renamed from: b */
    public void mo451b(AbstractC0090b abstractC0090b) {
    }

    @Override // androidx.appcompat.app.InterfaceC0072d
    /* renamed from: a */
    public AbstractC0090b mo445a(AbstractC0090b.a aVar) {
        return null;
    }

    /* renamed from: a */
    boolean m582a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return C0290f.m2173a(this.f653b, getWindow().getDecorView(), this, keyEvent);
    }
}
