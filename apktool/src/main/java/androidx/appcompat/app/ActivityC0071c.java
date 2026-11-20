package androidx.appcompat.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.p008os.Build;
import android.p008os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.p012a.InterfaceC0047b;
import androidx.appcompat.view.AbstractC0090b;
import androidx.appcompat.widget.C0190be;
import androidx.core.app.C0230a;
import androidx.core.app.C0235f;
import androidx.core.app.C0243n;
import androidx.fragment.app.ActivityC0375f;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.C0433b;
import androidx.savedstate.C0436e;

/* compiled from: AppCompatActivity.java */
/* renamed from: androidx.appcompat.app.c */
/* loaded from: classes.dex */
public class ActivityC0071c extends ActivityC0375f implements InterfaceC0072d, C0243n.a {

    /* renamed from: h */
    private AbstractC0073e f548h;

    /* renamed from: i */
    private Resources f549i;

    public ActivityC0071c() {
        m443o();
    }

    public ActivityC0071c(int i) {
        super(i);
        m443o();
    }

    /* renamed from: o */
    private void m443o() {
        mo300d().m3348a("androidx:appcompat", new C0433b.b() { // from class: androidx.appcompat.app.c.1
            @Override // androidx.savedstate.C0433b.b
            public Bundle saveState() {
                Bundle bundle = new Bundle();
                ActivityC0071c.this.m459k().mo482c(bundle);
                return bundle;
            }
        });
        m297a(new InterfaceC0047b() { // from class: androidx.appcompat.app.c.2
            @Override // androidx.activity.p012a.InterfaceC0047b
            /* renamed from: a */
            public void mo292a(Context context) {
                AbstractC0073e m459k = ActivityC0071c.this.m459k();
                m459k.mo488h();
                m459k.mo471a(ActivityC0071c.this.mo300d().m3344a("androidx:appcompat"));
            }
        });
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(m459k().mo475b(context));
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        m459k().mo468a(i);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        m459k().mo478b(bundle);
    }

    /* renamed from: f */
    public AbstractC0069a m454f() {
        return m459k().mo466a();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return m459k().mo476b();
    }

    @Override // androidx.activity.ActivityC0048b, android.app.Activity
    public void setContentView(int i) {
        m444p();
        m459k().mo481c(i);
    }

    @Override // androidx.activity.ActivityC0048b, android.app.Activity
    public void setContentView(View view) {
        m444p();
        m459k().mo472a(view);
    }

    @Override // androidx.activity.ActivityC0048b, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m444p();
        m459k().mo473a(view, layoutParams);
    }

    @Override // androidx.activity.ActivityC0048b, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m444p();
        m459k().mo479b(view, layoutParams);
    }

    /* renamed from: p */
    private void m444p() {
        ViewTreeLifecycleOwner.set(getWindow().getDecorView(), this);
        ViewTreeViewModelStoreOwner.set(getWindow().getDecorView(), this);
        C0436e.m3353a(getWindow().getDecorView(), this);
    }

    @Override // androidx.fragment.app.ActivityC0375f, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f549i != null) {
            this.f549i.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        m459k().mo470a(configuration);
    }

    @Override // androidx.fragment.app.ActivityC0375f, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        m459k().mo485e();
    }

    @Override // androidx.fragment.app.ActivityC0375f, android.app.Activity
    protected void onStart() {
        super.onStart();
        m459k().mo480c();
    }

    @Override // androidx.fragment.app.ActivityC0375f, android.app.Activity
    protected void onStop() {
        super.onStop();
        m459k().mo483d();
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        return (T) m459k().mo477b(i);
    }

    @Override // androidx.fragment.app.ActivityC0375f, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        AbstractC0069a m454f = m454f();
        if (menuItem.getItemId() == 16908332 && m454f != null && (m454f.mo394b() & 4) != 0) {
            return m456h();
        }
        return false;
    }

    @Override // androidx.fragment.app.ActivityC0375f, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        m459k().mo487g();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        m459k().mo474a(charSequence);
    }

    @Override // androidx.fragment.app.ActivityC0375f
    /* renamed from: g */
    public void mo455g() {
        m459k().mo486f();
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        m459k().mo486f();
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

    /* renamed from: b */
    public AbstractC0090b m449b(AbstractC0090b.a aVar) {
        return m459k().mo467a(aVar);
    }

    /* renamed from: a */
    public void m447a(C0243n c0243n) {
        c0243n.m1784a((Activity) this);
    }

    /* renamed from: b */
    public void m452b(C0243n c0243n) {
    }

    /* renamed from: h */
    public boolean m456h() {
        Intent mo457i = mo457i();
        if (mo457i != null) {
            if (m448a(mo457i)) {
                C0243n m1783a = C0243n.m1783a((Context) this);
                m447a(m1783a);
                m452b(m1783a);
                m1783a.m1787a();
                try {
                    C0230a.m1679a((Activity) this);
                } catch (IllegalStateException e2) {
                    finish();
                }
            } else {
                m450b(mo457i);
            }
            return true;
        }
        return false;
    }

    @Override // androidx.core.app.C0243n.a
    /* renamed from: i */
    public Intent mo457i() {
        return C0235f.m1699a(this);
    }

    /* renamed from: a */
    public boolean m448a(Intent intent) {
        return C0235f.m1701a(this, intent);
    }

    /* renamed from: b */
    public void m450b(Intent intent) {
        C0235f.m1704b(this, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        m458j();
    }

    @Deprecated
    /* renamed from: j */
    public void m458j() {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // androidx.fragment.app.ActivityC0375f, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    /* renamed from: k */
    public AbstractC0073e m459k() {
        if (this.f548h == null) {
            this.f548h = AbstractC0073e.m460a(this, this);
        }
        return this.f548h;
    }

    @Override // androidx.core.app.ActivityC0234e, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        AbstractC0069a m454f = m454f();
        if (keyCode == 82 && m454f != null && m454f.mo393a(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f549i == null && C0190be.m1477a()) {
            this.f549i = new C0190be(this, super.getResources());
        }
        return this.f549i == null ? super.getResources() : this.f549i;
    }

    /* renamed from: b */
    private boolean m442b(KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (m442b(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        AbstractC0069a m454f = m454f();
        if (getWindow().hasFeature(0)) {
            if (m454f == null || !m454f.mo402e()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        AbstractC0069a m454f = m454f();
        if (getWindow().hasFeature(0)) {
            if (m454f == null || !m454f.mo403f()) {
                super.closeOptionsMenu();
            }
        }
    }

    /* renamed from: b_ */
    protected void m453b_(int i) {
    }
}
