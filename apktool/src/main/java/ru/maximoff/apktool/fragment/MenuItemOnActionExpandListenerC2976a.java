package ru.maximoff.apktool.fragment;

import android.C0012R;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.p008os.AsyncTask;
import android.p008os.Bundle;
import android.p008os.Handler;
import android.p008os.Looper;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.ActivityC0071c;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.widget.C0173ao;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.ComponentCallbacksC0374e;
import androidx.p044h.p045a.C0406b;
import com.p159h.p160a.p162b.C1397s;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.p209io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.fragment.p301a.AsyncTaskC2977a;
import ru.maximoff.apktool.fragment.p301a.C2978b;
import ru.maximoff.apktool.fragment.p301a.C2980d;
import ru.maximoff.apktool.fragment.p302b.C2986e;
import ru.maximoff.apktool.p297b.C2895a;
import ru.maximoff.apktool.util.C3078aj;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3089au;
import ru.maximoff.apktool.util.C3093ay;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3106bh;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.ViewOnLongClickListenerC3083ao;
import ru.maximoff.apktool.util.p306d.C3212b;
import ru.maximoff.apktool.util.p308f.AsyncTaskC3238r;
import ru.maximoff.apktool.util.p308f.C3237q;
import ru.maximoff.apktool.util.p308f.C3239s;
import ru.maximoff.apktool.view.Editor;
import ru.maximoff.apktool.view.EditorPager;
import ru.maximoff.color.C3321c;

/* compiled from: EditorFragment.java */
/* renamed from: ru.maximoff.apktool.fragment.a */
/* loaded from: classes.dex */
public class MenuItemOnActionExpandListenerC2976a extends ComponentCallbacksC0374e implements MenuItem.OnActionExpandListener, View.OnClickListener, C0406b.f, Editor.InterfaceC3272a {

    /* renamed from: W */
    public C2980d f15895W;

    /* renamed from: X */
    private EditorPager f15896X;

    /* renamed from: Y */
    private TextView f15897Y;

    /* renamed from: Z */
    private TextView f15898Z;

    /* renamed from: aa */
    private ImageView f15899aa;

    /* renamed from: ab */
    private LinearLayout f15900ab;

    /* renamed from: ac */
    private LinearLayout f15901ac;

    /* renamed from: ae */
    private View f15903ae;

    /* renamed from: af */
    private ImageView f15904af;

    /* renamed from: ag */
    private View f15905ag;

    /* renamed from: ah */
    private MenuItem f15906ah;

    /* renamed from: ak */
    private EditText f15909ak;

    /* renamed from: al */
    private EditText f15910al;

    /* renamed from: ad */
    private MenuItem f15902ad = (MenuItem) null;

    /* renamed from: ai */
    private String f15907ai = "#";

    /* renamed from: aj */
    private int f15908aj = 4;

    @Override // androidx.p044h.p045a.C0406b.f
    /* renamed from: a */
    public void mo130a(int i) {
    }

    @Override // androidx.p044h.p045a.C0406b.f
    /* renamed from: a */
    public void mo131a(int i, float f2, int i2) {
    }

    /* renamed from: a */
    public void m17642a(C2986e c2986e) {
        C2978b.f16135a.m17695a(c2986e);
        c2986e.m17882a(this);
    }

    /* renamed from: a */
    public void m17630a() {
        CharSequence spannableString;
        C2978b.f16135a.m17694a(this);
        MainActivity mainActivity = (MainActivity) m2879p();
        if (mainActivity != null && !mainActivity.isFinishing() && !mainActivity.isDestroyed() && !mainActivity.m16634p()) {
            if (C2978b.f16135a.mo3270a() == 0) {
                this.f15897Y.setVisibility(0);
                this.f15900ab.setVisibility(8);
                this.f15904af.setVisibility(8);
                m17645aB();
                if (this.f15898Z != null) {
                    if (C3102bd.f18294ab.endsWith("-beta")) {
                        spannableString = C3112bn.m19041p(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m2849c(R.string.app_name)).append(" <sup><small>").toString()).append(m2849c(R.string.beta)).toString()).append("</small></sup>").toString());
                    } else {
                        spannableString = new SpannableString(m2849c(R.string.app_name));
                    }
                    this.f15898Z.setText(spannableString);
                }
            } else {
                mo132b(this.f15896X.getCurrentItem());
                this.f15897Y.setVisibility(8);
                this.f15904af.setVisibility(0);
                if (C3102bd.f18284T) {
                    this.f15900ab.setVisibility(0);
                }
            }
            mainActivity.invalidateOptionsMenu();
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: b */
    public View mo2691b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.editor_pager, viewGroup, false);
        this.f15896X = (EditorPager) inflate.findViewById(R.id.editorPager);
        this.f15897Y = (TextView) inflate.findViewById(R.id.empty);
        this.f15900ab = (LinearLayout) inflate.findViewById(R.id.quickPanelWrapper);
        this.f15901ac = (LinearLayout) this.f15900ab.findViewById(R.id.quickPanel);
        this.f15905ag = m17629a((ActivityC0071c) m2879p(), inflate);
        return inflate;
    }

    /* renamed from: e */
    public EditorPager m17656e() {
        return this.f15896X;
    }

    /* renamed from: k */
    public void m17662k(boolean z) {
        C2978b.f16135a.m17696a(z);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: b */
    public void mo2758b(Bundle bundle) {
        super.mo2758b(bundle);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: a */
    public void mo2688a(View view, Bundle bundle) {
        super.mo2688a(view, bundle);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: k */
    public void mo2871k(Bundle bundle) {
        CharSequence spannableString;
        super.mo2871k(bundle);
        this.f15895W = new C2980d(this, this.f15896X);
        m2846b(true);
        ActivityC0071c activityC0071c = (ActivityC0071c) m2879p();
        View mo384a = activityC0071c.m454f().mo384a();
        this.f15898Z = (TextView) mo384a.findViewById(R.id.name);
        this.f15899aa = (ImageView) mo384a.findViewById(R.id.titleOpenDrawer);
        C2978b.f16135a.m17692a(activityC0071c, this);
        this.f15903ae = mo384a.findViewById(R.id.errors);
        this.f15904af = (ImageView) mo384a.findViewById(R.id.menu_expand);
        if (C3102bd.f18291a) {
            this.f15904af.setImageResource(R.drawable.ic_collapse);
        } else {
            this.f15904af.setImageResource(R.drawable.ic_collapse_dark);
        }
        this.f15904af.setOnClickListener(this);
        this.f15904af.setOnLongClickListener(new View.OnLongClickListener(this) { // from class: ru.maximoff.apktool.fragment.a.1

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f15911a;

            {
                this.f15911a = this;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                C2978b.f16135a.m17684a(this.f15911a.f15896X.getCurrentItem(), 2);
                return true;
            }
        });
        if (C3102bd.f18294ab.endsWith("-beta")) {
            spannableString = C3112bn.m19041p(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m2849c(R.string.app_name)).append(" <sup><small>").toString()).append(m2849c(R.string.beta)).toString()).append("</small></sup>").toString());
        } else {
            spannableString = new SpannableString(m2849c(R.string.app_name));
        }
        this.f15898Z.setText(spannableString);
        this.f15898Z.setOnClickListener(this);
        this.f15898Z.setOnLongClickListener(new View.OnLongClickListener(this) { // from class: ru.maximoff.apktool.fragment.a.2

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f15964a;

            {
                this.f15964a = this;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (C2978b.f16135a.mo3270a() == 0) {
                    return false;
                }
                if (!this.f15964a.m17644aA()) {
                    this.f15964a.m17641a((CharSequence) "", true, false);
                } else {
                    this.f15964a.m17645aB();
                }
                return true;
            }
        });
        this.f15896X.m3323a(this);
        this.f15896X.setAdapter(C2978b.f16135a);
        this.f15903ae.setOnClickListener(this);
        m17619a(bundle);
    }

    /* renamed from: l */
    public void m17663l(boolean z) {
        this.f15903ae.setVisibility(z ? 0 : 8);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: a */
    public void mo2812a(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.editor, menu);
        super.mo2812a(menu, menuInflater);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.fragment.a.3

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f16059a;

            {
                this.f16059a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                ActivityC0071c activityC0071c = (ActivityC0071c) this.f16059a.m2879p();
                if (activityC0071c == null || this.f16059a.f15896X == null) {
                    return;
                }
                View findViewById = activityC0071c.findViewById(R.id.undo);
                if (findViewById != null) {
                    findViewById.setOnLongClickListener(new ViewOnLongClickListenerC3083ao(this.f16059a.f15896X));
                }
                View findViewById2 = activityC0071c.findViewById(R.id.redo);
                if (findViewById2 != null) {
                    findViewById2.setOnLongClickListener(new ViewOnLongClickListenerC3083ao(this.f16059a.f15896X));
                }
                View findViewById3 = activityC0071c.findViewById(R.id.save);
                if (findViewById3 != null) {
                    findViewById3.setOnLongClickListener(new ViewOnLongClickListenerC3083ao(this.f16059a.f15896X));
                }
            }
        }, 100L);
    }

    /* renamed from: au */
    public void m17647au() {
        m17657e(this.f15896X.getCurrentItem());
    }

    /* renamed from: e */
    public void m17657e(int i) {
        if (m17644aA()) {
            if (this.f15909ak != null && this.f15909ak.isFocused()) {
                this.f15909ak.requestFocus();
                return;
            } else if (this.f15910al != null && this.f15910al.isFocused()) {
                this.f15910al.requestFocus();
                return;
            }
        }
        C2978b.f16135a.m17708d(i);
    }

    @Override // androidx.p044h.p045a.C0406b.f
    /* renamed from: b */
    public void mo132b(int i) {
        m17657e(i);
        this.f15898Z.setText(C2978b.f16135a.mo3272a(i));
        this.f15904af.setVisibility(0);
        ((MainActivity) m2879p()).invalidateOptionsMenu();
    }

    /* renamed from: a */
    private void m17619a(Bundle bundle) {
        int i = bundle != null ? bundle.getInt("CURRENT_ITEM", 0) : 0;
        if (C2978b.f16135a.mo3270a() == 0) {
            this.f15897Y.setVisibility(0);
            this.f15900ab.setVisibility(8);
        } else {
            this.f15897Y.setVisibility(8);
            if (C3102bd.f18284T) {
                this.f15900ab.setVisibility(0);
            }
            this.f15896X.setCurrentItem(i);
            mo132b(i);
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.fragment.a.4

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f16097a;

            {
                this.f16097a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                ActivityC0071c activityC0071c = (ActivityC0071c) this.f16097a.m2879p();
                if (activityC0071c != null) {
                    this.f16097a.m17653b(activityC0071c);
                }
            }
        }, 100L);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: e */
    public void mo2762e(Bundle bundle) {
        super.mo2762e(bundle);
        bundle.putInt("CURRENT_ITEM", this.f15896X.getCurrentItem());
    }

    /* renamed from: a */
    public void m17637a(File file, int i, int i2) {
        if (file.isFile()) {
            m17633a(Uri.fromFile(file), file);
            this.f15896X.postDelayed(new Runnable(this, i, i2) { // from class: ru.maximoff.apktool.fragment.a.5

                /* renamed from: a */
                private final MenuItemOnActionExpandListenerC2976a f16109a;

                /* renamed from: b */
                private final int f16110b;

                /* renamed from: c */
                private final int f16111c;

                {
                    this.f16109a = this;
                    this.f16110b = i;
                    this.f16111c = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C2978b.f16135a.m17685a(this.f16109a.f15896X.getCurrentItem(), this.f16110b, this.f16111c);
                }
            }, 400L);
        }
    }

    /* renamed from: a */
    public void m17633a(Uri uri, File file) {
        m17634a(uri, file, false);
    }

    /* renamed from: a */
    public void m17634a(Uri uri, File file, boolean z) {
        m17635a(uri, file, z, 0);
    }

    /* renamed from: a */
    public void m17635a(Uri uri, File file, boolean z, int i) {
        if (file == null || file.isFile()) {
            m17632a(C2978b.f16135a.m17683a(((ActivityC0071c) m2879p()).getContentResolver(), uri, z, i), false);
            this.f15897Y.setVisibility(8);
            if (C3102bd.f18284T) {
                this.f15900ab.setVisibility(0);
            }
            ((MainActivity) m2879p()).m16636r();
        }
    }

    /* renamed from: a */
    public void m17636a(File file) {
        m17638a(file, false);
    }

    /* renamed from: a */
    public void m17638a(File file, boolean z) {
        if (file == null || file.isFile()) {
            m17634a(Uri.fromFile(file), file, z);
        }
    }

    /* renamed from: a */
    public void m17639a(File file, boolean z, int i) {
        if (file == null || file.isFile()) {
            m17635a(Uri.fromFile(file), file, z, i);
        }
    }

    /* renamed from: a */
    public void m17632a(int i, boolean z) {
        if (z && i == this.f15896X.getCurrentItem()) {
            m17627g(i);
        } else {
            this.f15896X.setCurrentItem(i);
            mo132b(i);
        }
    }

    /* renamed from: g */
    private void m17627g(int i) {
        C3089au.m18715a(this.f15898Z, R.menu.close_file, new C3089au.a(this, i) { // from class: ru.maximoff.apktool.fragment.a.6

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f16112a;

            /* renamed from: b */
            private final int f16113b;

            {
                this.f16112a = this;
                this.f16113b = i;
            }

            @Override // ru.maximoff.apktool.util.C3089au.a
            /* renamed from: a */
            public void mo17670a(Context context, int i2) {
                int i3;
                switch (i2) {
                    case R.id.close_cur /* 2131690198 */:
                        i3 = 0;
                        break;
                    case R.id.close_others /* 2131690199 */:
                        i3 = 1;
                        break;
                    case R.id.close_all /* 2131690200 */:
                        i3 = 2;
                        break;
                    default:
                        return;
                }
                this.f16112a.m17631a(this.f16113b, i3);
            }
        });
    }

    /* renamed from: a */
    protected void m17631a(int i, int i2) {
        C2978b.f16135a.m17684a(i, i2);
    }

    /* renamed from: f */
    public void m17659f(int i) {
        CharSequence spannableString;
        if (i == 0) {
            if (C3102bd.f18294ab.endsWith("-beta")) {
                spannableString = C3112bn.m19041p(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m2849c(R.string.app_name)).append(" <sup><small>").toString()).append(m2849c(R.string.beta)).toString()).append("</small></sup>").toString());
            } else {
                spannableString = new SpannableString(m2849c(R.string.app_name));
            }
            this.f15898Z.setText(spannableString);
            this.f15897Y.setVisibility(0);
            this.f15900ab.setVisibility(8);
            this.f15904af.setVisibility(8);
            ((MainActivity) m2879p()).invalidateOptionsMenu();
            return;
        }
        mo132b(this.f15896X.getCurrentItem());
    }

    /* renamed from: av */
    public void m17648av() {
        if (this.f15898Z != null) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.fragment.a.7

                /* renamed from: a */
                private final MenuItemOnActionExpandListenerC2976a f16114a;

                {
                    this.f16114a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f16114a.f15898Z.performClick();
                }
            }, 100L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.errors /* 2131689802 */:
                ((MainActivity) m2879p()).m16631c(3);
                break;
            case R.id.name /* 2131689816 */:
            case R.id.menu_expand /* 2131690050 */:
                if (C2978b.f16135a.mo3270a() != 0) {
                    C3089au.m18717a(this.f15899aa, C2978b.f16135a, new C3089au.a(this) { // from class: ru.maximoff.apktool.fragment.a.8

                        /* renamed from: a */
                        private final MenuItemOnActionExpandListenerC2976a f16115a;

                        {
                            this.f16115a = this;
                        }

                        @Override // ru.maximoff.apktool.util.C3089au.a
                        /* renamed from: a */
                        public void mo17670a(Context context, int i) {
                            this.f16115a.m17632a(i, true);
                            ((MainActivity) this.f16115a.m2879p()).m16636r();
                        }
                    }, new C3089au.a(this) { // from class: ru.maximoff.apktool.fragment.a.9

                        /* renamed from: a */
                        private final MenuItemOnActionExpandListenerC2976a f16116a;

                        {
                            this.f16116a = this;
                        }

                        @Override // ru.maximoff.apktool.util.C3089au.a
                        /* renamed from: a */
                        public void mo17670a(Context context, int i) {
                            this.f16116a.m17631a(i, 0);
                        }
                    });
                    break;
                }
                break;
        }
    }

    /* renamed from: a */
    public void m17643a(boolean z, boolean z2) {
        if (z) {
            C2978b.f16135a.m17719j();
            return;
        }
        C2978b.f16135a.m17735u(this.f15896X.getCurrentItem());
        if (z2) {
            C3112bn.m18999a((ActivityC0071c) m2879p(), R.string.success);
        }
    }

    @Override // ru.maximoff.apktool.view.Editor.InterfaceC3272a
    /* renamed from: aw */
    public void mo17649aw() {
        mo132b(this.f15896X.getCurrentItem());
    }

    /* renamed from: ax */
    public boolean m17650ax() {
        return C2978b.f16135a.m17728n();
    }

    /* renamed from: m */
    public void m17664m(boolean z) {
        C2978b.f16135a.m17704b(z);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: a */
    public void mo2811a(Menu menu) {
        int currentItem;
        if (C2978b.f16135a.mo3270a() == 0) {
            currentItem = -1;
        } else {
            currentItem = this.f15896X.getCurrentItem();
        }
        C2895a.m16939a(menu, currentItem);
        this.f15906ah = menu.findItem(R.id.translate);
        menu.findItem(R.id.go_to_line).setOnActionExpandListener(this);
        menu.findItem(R.id.wordwrap).setChecked(C3102bd.f18341x);
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public boolean onMenuItemActionExpand(MenuItem menuItem) {
        this.f15902ad = menuItem;
        int currentItem = this.f15896X.getCurrentItem();
        if (menuItem.getItemId() == R.id.go_to_line) {
            C2978b.f16135a.m17687a(currentItem, (SearchView) menuItem.getActionView());
            return true;
        }
        return true;
    }

    /* renamed from: ay */
    public boolean m17651ay() {
        if (this.f15902ad == null) {
            return false;
        }
        this.f15902ad.collapseActionView();
        return true;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public boolean onMenuItemActionCollapse(MenuItem menuItem) {
        this.f15902ad = (MenuItem) null;
        return true;
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: a */
    public boolean mo2820a(MenuItem menuItem) {
        String uri;
        EditText editText = (EditText) this.f15905ag.findViewById(R.id.editorpagerEditText1);
        int currentItem = this.f15896X.getCurrentItem();
        ActivityC0071c activityC0071c = (ActivityC0071c) m2879p();
        switch (menuItem.getItemId()) {
            case R.id.save /* 2131690189 */:
                m17643a(false, true);
                return true;
            case R.id.wordwrap /* 2131690213 */:
                C3102bd.f18341x = !menuItem.isChecked();
                C3102bd.m18938b(activityC0071c, "is_wordwrap", menuItem.isChecked() ? false : true);
                C2978b.f16135a.m17715h();
                return true;
            case R.id.translate /* 2131690221 */:
                C2978b.f16135a.m17686a(currentItem, menuItem);
                ((MainActivity) activityC0071c).invalidateOptionsMenu();
                return true;
            case R.id.methods /* 2131690238 */:
                C2978b.f16135a.m17700b(currentItem, menuItem);
                return true;
            case R.id.find /* 2131690241 */:
                if (!m17644aA()) {
                    m17641a("", true, false);
                } else {
                    m17645aB();
                }
                return true;
            case R.id.edit_mode /* 2131690243 */:
                if (C2978b.f16135a.m17712f(currentItem)) {
                    menuItem.setTitle(R.string.edit_mode);
                    m17662k(false);
                    this.f15900ab.setVisibility(8);
                } else {
                    menuItem.setTitle(R.string.scan_mode);
                    m17662k(true);
                    if (C3102bd.f18284T) {
                        this.f15900ab.setVisibility(0);
                    }
                }
                return true;
            case R.id.reload /* 2131690246 */:
                C2978b.f16135a.m17736v(currentItem);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this, currentItem) { // from class: ru.maximoff.apktool.fragment.a.12

                    /* renamed from: a */
                    private final MenuItemOnActionExpandListenerC2976a f15917a;

                    /* renamed from: b */
                    private final int f15918b;

                    {
                        this.f15917a = this;
                        this.f15918b = currentItem;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f15917a.mo132b(this.f15918b);
                    }
                }, 100L);
                return true;
            case R.id.encoding /* 2131690247 */:
                String m17732r = C2978b.f16135a.m17732r(currentItem);
                if (m17732r == null) {
                    C3112bn.m18999a(activityC0071c, R.string.error);
                } else {
                    String[] stringArray = m2882s().getStringArray(R.array.charsets);
                    int i = 0;
                    while (true) {
                        if (i >= stringArray.length) {
                            i = 0;
                        } else if (!m17732r.equals(stringArray[i])) {
                            i++;
                        }
                    }
                    new DialogInterfaceC0070b.a(activityC0071c).m418a(R.string.encoding).m430a(stringArray, i, new DialogInterface.OnClickListener(this, currentItem, stringArray) { // from class: ru.maximoff.apktool.fragment.a.13

                        /* renamed from: a */
                        private final MenuItemOnActionExpandListenerC2976a f15919a;

                        /* renamed from: b */
                        private final int f15920b;

                        /* renamed from: c */
                        private final String[] f15921c;

                        {
                            this.f15919a = this;
                            this.f15920b = currentItem;
                            this.f15921c = stringArray;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            C2978b.f16135a.m17688a(this.f15920b, this.f15921c[i2]);
                            C2978b.f16135a.m17703b(this.f15920b, true);
                        }
                    }).m420a(R.string.f21470ok, (DialogInterface.OnClickListener) null).m440c(R.string.reload, new DialogInterface.OnClickListener(this, currentItem) { // from class: ru.maximoff.apktool.fragment.a.14

                        /* renamed from: a */
                        private final MenuItemOnActionExpandListenerC2976a f15922a;

                        /* renamed from: b */
                        private final int f15923b;

                        {
                            this.f15922a = this;
                            this.f15923b = currentItem;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            C2978b.f16135a.m17736v(this.f15923b);
                        }
                    }).m438b().show();
                }
                return true;
            case R.id.syntax /* 2131690248 */:
                C2978b.f16135a.m17705c(currentItem);
                return true;
            case R.id.select_rows /* 2131690249 */:
                m17652az();
                return true;
            case R.id.smali_help /* 2131690250 */:
                m17658e((String) null);
                return true;
            case R.id.color /* 2131690251 */:
                m17661g((String) null);
                return true;
            case R.id.properties /* 2131690252 */:
                Uri m17731q = C2978b.f16135a.m17731q(currentItem);
                if (m17731q == null) {
                    C3112bn.m18999a(activityC0071c, R.string.error);
                } else {
                    try {
                        if (m17731q.getScheme().equals(ContentResolver.SCHEME_FILE)) {
                            uri = C3112bn.m19018b(m17731q.getPath());
                        } else {
                            uri = m17731q.toString();
                        }
                        InputStream openInputStream = activityC0071c.getContentResolver().openInputStream(m17731q);
                        String m18975a = C3106bh.m18975a(openInputStream.available(), C3102bd.f18305am);
                        openInputStream.close();
                        DialogInterfaceC0070b.a m420a = new DialogInterfaceC0070b.a(activityC0071c).m418a(R.string.properties).m436b(m2801a(R.string.editor_prop_dialog, C3262u.m19565a(activityC0071c, m17731q), uri, m18975a)).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null);
                        if (m17731q.getScheme().equals(ContentResolver.SCHEME_FILE)) {
                            m420a.m440c(R.string.show, new DialogInterface.OnClickListener(this, activityC0071c, m17731q) { // from class: ru.maximoff.apktool.fragment.a.10

                                /* renamed from: a */
                                private final MenuItemOnActionExpandListenerC2976a f15912a;

                                /* renamed from: b */
                                private final ActivityC0071c f15913b;

                                /* renamed from: c */
                                private final Uri f15914c;

                                {
                                    this.f15912a = this;
                                    this.f15913b = activityC0071c;
                                    this.f15914c = m17731q;
                                }

                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                    ((MainActivity) this.f15913b).m16622a(new File(this.f15914c.getPath()));
                                    dialogInterface.dismiss();
                                }
                            });
                        }
                        DialogInterfaceC0070b m438b = m420a.m438b();
                        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, m438b) { // from class: ru.maximoff.apktool.fragment.a.11

                            /* renamed from: a */
                            private final MenuItemOnActionExpandListenerC2976a f15915a;

                            /* renamed from: b */
                            private final DialogInterfaceC0070b f15916b;

                            {
                                this.f15915a = this;
                                this.f15916b = m438b;
                            }

                            @Override // android.content.DialogInterface.OnShowListener
                            public void onShow(DialogInterface dialogInterface) {
                                TextView textView = (TextView) this.f15916b.findViewById(C0012R.id.message);
                                if (textView != null) {
                                    textView.setTextIsSelectable(true);
                                }
                            }
                        });
                        m438b.show();
                    } catch (Exception e2) {
                        C3112bn.m18999a(activityC0071c, R.string.error);
                    }
                }
                return true;
            case R.id.search_regexp /* 2131690293 */:
                C3102bd.m18938b(activityC0071c, "search_editor_regexp", menuItem.isChecked() ? false : true);
                editText.requestFocus();
                editText.selectAll();
                return true;
            case R.id.whole_words /* 2131690294 */:
                C3102bd.m18938b(activityC0071c, "search_editor_whole", menuItem.isChecked() ? false : true);
                editText.requestFocus();
                editText.selectAll();
                return true;
            case R.id.search_case_sens /* 2131690295 */:
                C3102bd.m18938b(activityC0071c, "search_editor_csens", menuItem.isChecked() ? false : true);
                editText.requestFocus();
                editText.selectAll();
                return true;
            case R.id.search_loop /* 2131690296 */:
                C3102bd.m18938b(activityC0071c, "search_editor_loop", menuItem.isChecked() ? false : true);
                return true;
            case R.id.search_close /* 2131690297 */:
                m17645aB();
                return true;
            default:
                C2895a.m16940a(menuItem, currentItem);
                return true;
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.fragment.a.15

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f15924a;

            {
                this.f15924a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                ActivityC0071c activityC0071c = (ActivityC0071c) this.f15924a.m2879p();
                if (activityC0071c != null) {
                    this.f15924a.m17653b(activityC0071c);
                }
            }
        }, 100L);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: E */
    public void mo2778E() {
        super.mo2778E();
        if (C2978b.f16135a.mo3270a() == 0 || !C3102bd.f18284T) {
            this.f15900ab.setVisibility(8);
        } else {
            this.f15900ab.setVisibility(0);
        }
    }

    /* renamed from: az */
    public void m17652az() {
        ActivityC0071c activityC0071c = (ActivityC0071c) m2879p();
        Editor m17727n = C2978b.f16135a.m17727n(this.f15896X.getCurrentItem());
        View inflate = LayoutInflater.from(activityC0071c).inflate(R.layout.select_rows, (ViewGroup) null);
        EditText editText = (EditText) inflate.findViewById(R.id.selectrowsEditText1);
        EditText editText2 = (EditText) inflate.findViewById(R.id.selectrowsEditText2);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.selectrowsCheckBox1);
        checkBox.setChecked(C3102bd.m18925a((Context) activityC0071c, "editor_del_rows", false));
        String format = String.format("%d - %d", new Integer(1), new Integer(m17727n.getLineCount()));
        String valueOf = String.valueOf(m17727n.getLineNumber() + 1);
        editText.setHint(format);
        editText2.setHint(format);
        editText.setText(valueOf);
        editText2.setText(valueOf);
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(activityC0071c).m418a(R.string.select_rows).m435b(inflate).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, checkBox, activityC0071c, editText, editText2, m17727n) { // from class: ru.maximoff.apktool.fragment.a.16

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f15925a;

            /* renamed from: b */
            private final CheckBox f15926b;

            /* renamed from: c */
            private final Context f15927c;

            /* renamed from: d */
            private final EditText f15928d;

            /* renamed from: e */
            private final EditText f15929e;

            /* renamed from: f */
            private final Editor f15930f;

            {
                this.f15925a = this;
                this.f15926b = checkBox;
                this.f15927c = activityC0071c;
                this.f15928d = editText;
                this.f15929e = editText2;
                this.f15930f = m17727n;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                boolean isChecked = this.f15926b.isChecked();
                C3102bd.m18938b(this.f15927c, "editor_del_rows", isChecked);
                String editable = this.f15928d.getText().toString();
                String editable2 = this.f15929e.getText().toString();
                if (!editable.isEmpty() && !editable2.isEmpty()) {
                    try {
                        this.f15930f.m10870a(Integer.parseInt(editable), Integer.parseInt(editable2), isChecked);
                    } catch (Exception e2) {
                        C3112bn.m18999a(this.f15927c, R.string.error);
                    }
                }
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, editText2) { // from class: ru.maximoff.apktool.fragment.a.17

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f15931a;

            /* renamed from: b */
            private final EditText f15932b;

            {
                this.f15931a = this;
                this.f15932b = editText2;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f15932b.requestFocus();
                this.f15932b.selectAll();
            }
        });
        m438b.show();
    }

    /* renamed from: c */
    public void m17654c(String str) {
        C2978b.f16135a.m17701b(this.f15896X.getCurrentItem(), str);
    }

    /* renamed from: d */
    public void m17655d(String str) {
        C2978b.f16135a.m17706c(this.f15896X.getCurrentItem(), str);
    }

    /* renamed from: a */
    public int m17628a(String str, boolean z) {
        return C2978b.f16135a.m17681a(this.f15896X.getCurrentItem(), str, z, C3102bd.f18335r);
    }

    /* renamed from: n */
    public void m17665n(boolean z) {
        C2978b.f16135a.m17691a(this.f15896X.getCurrentItem(), z);
    }

    /* renamed from: e */
    public void m17658e(String str) {
        int indexOf;
        if (!C3112bn.m19040o(str) && (indexOf = (str = str.trim()).indexOf(32)) > 0) {
            str = str.substring(0, indexOf);
        }
        ActivityC0071c activityC0071c = (ActivityC0071c) m2879p();
        try {
            C3080al.m18609k(activityC0071c, str);
        } catch (Exception e2) {
            C3112bn.m18999a(activityC0071c, R.string.error);
        }
    }

    /* renamed from: f */
    public void m17660f(String str) {
        String str2;
        String str3;
        ActivityC0071c activityC0071c = (ActivityC0071c) m2879p();
        String[] strArr = {m2849c(R.string.mtr_yandex), m2849c(R.string.mtr_bing), m2849c(R.string.mtr_google), m2849c(R.string.mtr_google_web), m2849c(R.string.mtr_deepl)};
        int m18905a = C3102bd.m18905a((Context) activityC0071c, "editor_translate_service", 0);
        String m18600g = C3080al.m18600g(activityC0071c);
        String[] m19423a = C3239s.m19423a((Context) activityC0071c, 0, false);
        String[] m19423a2 = C3239s.m19423a((Context) activityC0071c, 0, true);
        String[] m19423a3 = C3239s.m19423a((Context) activityC0071c, 1, false);
        String[] m19423a4 = C3239s.m19423a((Context) activityC0071c, 1, true);
        String[] m19423a5 = C3239s.m19423a((Context) activityC0071c, 2, false);
        String[] m19423a6 = C3239s.m19423a((Context) activityC0071c, 2, true);
        String[] m19423a7 = C3239s.m19423a((Context) activityC0071c, 3, false);
        String[] m19423a8 = C3239s.m19423a((Context) activityC0071c, 3, true);
        String[] m19423a9 = C3239s.m19423a((Context) activityC0071c, 4, false);
        String[] m19423a10 = C3239s.m19423a((Context) activityC0071c, 4, true);
        String m18910a = C3102bd.m18910a(activityC0071c, "editor_translate_ysource_code", "auto");
        String m18910a2 = C3102bd.m18910a(activityC0071c, "editor_translate_ytarget_code", m18600g);
        String m18910a3 = C3102bd.m18910a(activityC0071c, "editor_translate_bsource_code", "auto");
        String m18910a4 = C3102bd.m18910a(activityC0071c, "editor_translate_btarget_code", m18600g);
        String m18910a5 = C3102bd.m18910a(activityC0071c, "editor_translate_gsource_code", "auto");
        String m18910a6 = C3102bd.m18910a(activityC0071c, "editor_translate_gtarget_code", m18600g);
        String m18910a7 = C3102bd.m18910a(activityC0071c, "editor_translate_gwsource_code", "auto");
        String m18910a8 = C3102bd.m18910a(activityC0071c, "editor_translate_gwtarget_code", m18600g);
        String m18910a9 = C3102bd.m18910a(activityC0071c, "editor_translate_dsource_code", "auto");
        String m18910a10 = C3102bd.m18910a(activityC0071c, "editor_translate_dtarget_code", m18600g);
        int[] iArr = {0, 0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0, 0};
        for (int i = 1; i < m19423a.length; i++) {
            if (m19423a[i].equals(m18910a2)) {
                iArr2[0] = i - 1;
            } else if (m19423a[i].equals(m18910a)) {
                iArr[0] = i;
            }
        }
        for (int i2 = 1; i2 < m19423a3.length; i2++) {
            if (m19423a3[i2].equals(m18910a4)) {
                iArr2[1] = i2 - 1;
            } else if (m19423a3[i2].equals(m18910a3)) {
                iArr[1] = i2;
            }
        }
        for (int i3 = 1; i3 < m19423a5.length; i3++) {
            if (m19423a5[i3].equals(m18910a6)) {
                iArr2[2] = i3 - 1;
            } else if (m19423a5[i3].equals(m18910a5)) {
                iArr[2] = i3;
            }
        }
        for (int i4 = 1; i4 < m19423a7.length; i4++) {
            if (m19423a7[i4].equals(m18910a8)) {
                iArr2[3] = i4 - 1;
            } else if (m19423a7[i4].equals(m18910a7)) {
                iArr[3] = i4;
            }
        }
        for (int i5 = 1; i5 < m19423a9.length; i5++) {
            if (m19423a9[i5].equals(m18910a10)) {
                iArr2[4] = i5 - 1;
            } else if (m19423a9[i5].equals(m18910a9)) {
                iArr[4] = i5;
            }
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(activityC0071c, C0012R.layout.simple_spinner_dropdown_item, m19423a2);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(activityC0071c, C0012R.layout.simple_spinner_dropdown_item, (String[]) Arrays.copyOfRange(m19423a2, 1, m19423a2.length));
        ArrayAdapter arrayAdapter3 = new ArrayAdapter(activityC0071c, C0012R.layout.simple_spinner_dropdown_item, m19423a4);
        ArrayAdapter arrayAdapter4 = new ArrayAdapter(activityC0071c, C0012R.layout.simple_spinner_dropdown_item, (String[]) Arrays.copyOfRange(m19423a4, 1, m19423a4.length));
        ArrayAdapter arrayAdapter5 = new ArrayAdapter(activityC0071c, C0012R.layout.simple_spinner_dropdown_item, m19423a6);
        ArrayAdapter arrayAdapter6 = new ArrayAdapter(activityC0071c, C0012R.layout.simple_spinner_dropdown_item, (String[]) Arrays.copyOfRange(m19423a6, 1, m19423a6.length));
        ArrayAdapter arrayAdapter7 = new ArrayAdapter(activityC0071c, C0012R.layout.simple_spinner_dropdown_item, m19423a8);
        ArrayAdapter arrayAdapter8 = new ArrayAdapter(activityC0071c, C0012R.layout.simple_spinner_dropdown_item, (String[]) Arrays.copyOfRange(m19423a8, 1, m19423a8.length));
        ArrayAdapter arrayAdapter9 = new ArrayAdapter(activityC0071c, C0012R.layout.simple_spinner_dropdown_item, m19423a10);
        ArrayAdapter arrayAdapter10 = new ArrayAdapter(activityC0071c, C0012R.layout.simple_spinner_dropdown_item, (String[]) Arrays.copyOfRange(m19423a10, 1, m19423a10.length));
        View inflate = LayoutInflater.from(activityC0071c).inflate(R.layout.editor_translate, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.editortranslateTextView2)).setText(str);
        TextView textView = (TextView) inflate.findViewById(R.id.editortranslateTextView1);
        String c2 = m2849c(R.string.dot);
        textView.setText(c2);
        textView.setTag(c2);
        Handler handler = new Handler(Looper.getMainLooper());
        Runnable runnable = new Runnable(this, textView, c2, handler) { // from class: ru.maximoff.apktool.fragment.a.18

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f15933a;

            /* renamed from: b */
            private final TextView f15934b;

            /* renamed from: c */
            private final String f15935c;

            /* renamed from: d */
            private final Handler f15936d;

            {
                this.f15933a = this;
                this.f15934b = textView;
                this.f15935c = c2;
                this.f15936d = handler;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f15934b.getText().length() >= 5) {
                    this.f15934b.setText(this.f15935c);
                } else {
                    this.f15934b.setText(new StringBuffer().append((Object) this.f15934b.getText()).append(this.f15935c).toString());
                }
                this.f15936d.postDelayed(this, 1000L);
            }
        };
        Spinner spinner = (Spinner) inflate.findViewById(R.id.editortranslateSpinner1);
        Spinner spinner2 = (Spinner) inflate.findViewById(R.id.editortranslateSpinner2);
        Spinner spinner3 = (Spinner) inflate.findViewById(R.id.editortranslateSpinner3);
        spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(activityC0071c, C0012R.layout.simple_spinner_dropdown_item, strArr));
        spinner.setSelection((m18905a > 4 || m18905a < 0) ? 0 : m18905a);
        switch (m18905a) {
            case 0:
                spinner2.setAdapter((SpinnerAdapter) arrayAdapter);
                spinner3.setAdapter((SpinnerAdapter) arrayAdapter2);
                break;
            case 1:
                spinner2.setAdapter((SpinnerAdapter) arrayAdapter3);
                spinner3.setAdapter((SpinnerAdapter) arrayAdapter4);
                break;
            case 2:
                spinner2.setAdapter((SpinnerAdapter) arrayAdapter5);
                spinner3.setAdapter((SpinnerAdapter) arrayAdapter6);
                break;
            case 3:
                spinner2.setAdapter((SpinnerAdapter) arrayAdapter7);
                spinner3.setAdapter((SpinnerAdapter) arrayAdapter8);
                break;
            case 4:
                spinner2.setAdapter((SpinnerAdapter) arrayAdapter9);
                spinner3.setAdapter((SpinnerAdapter) arrayAdapter10);
                break;
        }
        spinner2.setSelection(iArr[m18905a]);
        spinner3.setSelection(iArr2[m18905a]);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(this, activityC0071c, spinner2, arrayAdapter, spinner3, arrayAdapter2, arrayAdapter3, arrayAdapter4, arrayAdapter5, arrayAdapter6, arrayAdapter7, arrayAdapter8, arrayAdapter9, arrayAdapter10, iArr, iArr2, spinner, m19423a, m19423a3, m19423a5, m19423a7, m19423a9, handler, textView, c2, runnable, str) { // from class: ru.maximoff.apktool.fragment.a.19

            /* renamed from: A */
            private final String f15937A;

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f15938a;

            /* renamed from: b */
            private final Context f15939b;

            /* renamed from: c */
            private final Spinner f15940c;

            /* renamed from: d */
            private final ArrayAdapter f15941d;

            /* renamed from: e */
            private final Spinner f15942e;

            /* renamed from: f */
            private final ArrayAdapter f15943f;

            /* renamed from: g */
            private final ArrayAdapter f15944g;

            /* renamed from: h */
            private final ArrayAdapter f15945h;

            /* renamed from: i */
            private final ArrayAdapter f15946i;

            /* renamed from: j */
            private final ArrayAdapter f15947j;

            /* renamed from: k */
            private final ArrayAdapter f15948k;

            /* renamed from: l */
            private final ArrayAdapter f15949l;

            /* renamed from: m */
            private final ArrayAdapter f15950m;

            /* renamed from: n */
            private final ArrayAdapter f15951n;

            /* renamed from: o */
            private final int[] f15952o;

            /* renamed from: p */
            private final int[] f15953p;

            /* renamed from: q */
            private final Spinner f15954q;

            /* renamed from: r */
            private final String[] f15955r;

            /* renamed from: s */
            private final String[] f15956s;

            /* renamed from: t */
            private final String[] f15957t;

            /* renamed from: u */
            private final String[] f15958u;

            /* renamed from: v */
            private final String[] f15959v;

            /* renamed from: w */
            private final Handler f15960w;

            /* renamed from: x */
            private final TextView f15961x;

            /* renamed from: y */
            private final String f15962y;

            /* renamed from: z */
            private final Runnable f15963z;

            {
                this.f15938a = this;
                this.f15939b = activityC0071c;
                this.f15940c = spinner2;
                this.f15941d = arrayAdapter;
                this.f15942e = spinner3;
                this.f15943f = arrayAdapter2;
                this.f15944g = arrayAdapter3;
                this.f15945h = arrayAdapter4;
                this.f15946i = arrayAdapter5;
                this.f15947j = arrayAdapter6;
                this.f15948k = arrayAdapter7;
                this.f15949l = arrayAdapter8;
                this.f15950m = arrayAdapter9;
                this.f15951n = arrayAdapter10;
                this.f15952o = iArr;
                this.f15953p = iArr2;
                this.f15954q = spinner;
                this.f15955r = m19423a;
                this.f15956s = m19423a3;
                this.f15957t = m19423a5;
                this.f15958u = m19423a7;
                this.f15959v = m19423a9;
                this.f15960w = handler;
                this.f15961x = textView;
                this.f15962y = c2;
                this.f15963z = runnable;
                this.f15937A = str;
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i6, long j) {
                String str4;
                String str5;
                C3102bd.m18935b(this.f15939b, "editor_translate_service", i6);
                switch (i6) {
                    case 0:
                        this.f15940c.setAdapter((SpinnerAdapter) this.f15941d);
                        this.f15942e.setAdapter((SpinnerAdapter) this.f15943f);
                        break;
                    case 1:
                        this.f15940c.setAdapter((SpinnerAdapter) this.f15944g);
                        this.f15942e.setAdapter((SpinnerAdapter) this.f15945h);
                        break;
                    case 2:
                        this.f15940c.setAdapter((SpinnerAdapter) this.f15946i);
                        this.f15942e.setAdapter((SpinnerAdapter) this.f15947j);
                        break;
                    case 3:
                        this.f15940c.setAdapter((SpinnerAdapter) this.f15948k);
                        this.f15942e.setAdapter((SpinnerAdapter) this.f15949l);
                        break;
                    case 4:
                        this.f15940c.setAdapter((SpinnerAdapter) this.f15950m);
                        this.f15942e.setAdapter((SpinnerAdapter) this.f15951n);
                        break;
                }
                this.f15940c.setSelection(this.f15952o[i6]);
                this.f15942e.setSelection(this.f15953p[i6]);
                switch (this.f15954q.getSelectedItemPosition()) {
                    case 1:
                        str4 = this.f15956s[this.f15940c.getSelectedItemPosition()];
                        str5 = this.f15956s[this.f15942e.getSelectedItemPosition() + 1];
                        break;
                    case 2:
                        str4 = this.f15957t[this.f15940c.getSelectedItemPosition()];
                        str5 = this.f15957t[this.f15942e.getSelectedItemPosition() + 1];
                        break;
                    case 3:
                        str4 = this.f15958u[this.f15940c.getSelectedItemPosition()];
                        str5 = this.f15958u[this.f15942e.getSelectedItemPosition() + 1];
                        break;
                    case 4:
                        str4 = this.f15959v[this.f15940c.getSelectedItemPosition()];
                        str5 = this.f15959v[this.f15942e.getSelectedItemPosition() + 1];
                        break;
                    default:
                        str4 = this.f15955r[this.f15940c.getSelectedItemPosition()];
                        str5 = this.f15955r[this.f15942e.getSelectedItemPosition() + 1];
                        break;
                }
                this.f15960w.removeCallbacksAndMessages((Object) null);
                this.f15961x.setText(this.f15962y);
                this.f15961x.setTag(this.f15962y);
                this.f15960w.postDelayed(this.f15963z, 1000L);
                this.f15938a.m17618a(this.f15939b, i6, this.f15937A, str4, str5, this.f15961x, this.f15960w);
            }
        });
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener(this, spinner, m19423a, spinner2, spinner3, activityC0071c, m19423a3, m19423a5, m19423a7, m19423a9, handler, textView, c2, runnable, str) { // from class: ru.maximoff.apktool.fragment.a.20

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f15965a;

            /* renamed from: b */
            private final Spinner f15966b;

            /* renamed from: c */
            private final String[] f15967c;

            /* renamed from: d */
            private final Spinner f15968d;

            /* renamed from: e */
            private final Spinner f15969e;

            /* renamed from: f */
            private final Context f15970f;

            /* renamed from: g */
            private final String[] f15971g;

            /* renamed from: h */
            private final String[] f15972h;

            /* renamed from: i */
            private final String[] f15973i;

            /* renamed from: j */
            private final String[] f15974j;

            /* renamed from: k */
            private final Handler f15975k;

            /* renamed from: l */
            private final TextView f15976l;

            /* renamed from: m */
            private final String f15977m;

            /* renamed from: n */
            private final Runnable f15978n;

            /* renamed from: o */
            private final String f15979o;

            {
                this.f15965a = this;
                this.f15966b = spinner;
                this.f15967c = m19423a;
                this.f15968d = spinner2;
                this.f15969e = spinner3;
                this.f15970f = activityC0071c;
                this.f15971g = m19423a3;
                this.f15972h = m19423a5;
                this.f15973i = m19423a7;
                this.f15974j = m19423a9;
                this.f15975k = handler;
                this.f15976l = textView;
                this.f15977m = c2;
                this.f15978n = runnable;
                this.f15979o = str;
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i6, long j) {
                String str4;
                String str5;
                switch (this.f15966b.getSelectedItemPosition()) {
                    case 1:
                        str4 = this.f15971g[this.f15968d.getSelectedItemPosition()];
                        str5 = this.f15971g[this.f15969e.getSelectedItemPosition() + 1];
                        C3102bd.m18937b(this.f15970f, "editor_translate_bsource_code", str4);
                        C3102bd.m18937b(this.f15970f, "editor_translate_btarget_code", str5);
                        break;
                    case 2:
                        str4 = this.f15972h[this.f15968d.getSelectedItemPosition()];
                        str5 = this.f15972h[this.f15969e.getSelectedItemPosition() + 1];
                        C3102bd.m18937b(this.f15970f, "editor_translate_gsource_code", str4);
                        C3102bd.m18937b(this.f15970f, "editor_translate_gtarget_code", str5);
                        break;
                    case 3:
                        str4 = this.f15973i[this.f15968d.getSelectedItemPosition()];
                        str5 = this.f15973i[this.f15969e.getSelectedItemPosition() + 1];
                        C3102bd.m18937b(this.f15970f, "editor_translate_gwsource_code", str4);
                        C3102bd.m18937b(this.f15970f, "editor_translate_gwtarget_code", str5);
                        break;
                    case 4:
                        str4 = this.f15974j[this.f15968d.getSelectedItemPosition()];
                        str5 = this.f15974j[this.f15969e.getSelectedItemPosition() + 1];
                        C3102bd.m18937b(this.f15970f, "editor_translate_dsource_code", str4);
                        C3102bd.m18937b(this.f15970f, "editor_translate_dtarget_code", str5);
                        break;
                    default:
                        str4 = this.f15967c[this.f15968d.getSelectedItemPosition()];
                        str5 = this.f15967c[this.f15969e.getSelectedItemPosition() + 1];
                        C3102bd.m18937b(this.f15970f, "editor_translate_ysource_code", str4);
                        C3102bd.m18937b(this.f15970f, "editor_translate_ytarget_code", str5);
                        break;
                }
                this.f15975k.removeCallbacksAndMessages((Object) null);
                this.f15976l.setText(this.f15977m);
                this.f15976l.setTag(this.f15977m);
                this.f15975k.postDelayed(this.f15978n, 1000L);
                this.f15965a.m17618a(this.f15970f, this.f15966b.getSelectedItemPosition(), this.f15979o, str4, str5, this.f15976l, this.f15975k);
            }
        };
        spinner2.setOnItemSelectedListener(onItemSelectedListener);
        spinner3.setOnItemSelectedListener(onItemSelectedListener);
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(activityC0071c).m418a(R.string.mtranslator).m435b(inflate).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.fragment.a.21

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f15980a;

            {
                this.f15980a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i6) {
                dialogInterface.cancel();
            }
        }).m434b(R.string.mupdate_get, (DialogInterface.OnClickListener) null).m440c(R.string.mshow_more_options, (DialogInterface.OnClickListener) null).m429a(false).m438b();
        m438b.setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: ru.maximoff.apktool.fragment.a.22

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f15981a;

            {
                this.f15981a = this;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i6, KeyEvent keyEvent) {
                if (i6 != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                    return false;
                }
                dialogInterface.cancel();
                return true;
            }
        });
        m438b.setOnCancelListener(new DialogInterface.OnCancelListener(this, handler) { // from class: ru.maximoff.apktool.fragment.a.23

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f15982a;

            /* renamed from: b */
            private final Handler f15983b;

            {
                this.f15982a = this;
                this.f15983b = handler;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                this.f15983b.removeCallbacksAndMessages((Object) null);
            }
        });
        m438b.setOnShowListener(new AnonymousClass24(this, m438b, spinner, m19423a, spinner2, spinner3, m19423a3, m19423a5, m19423a7, m19423a9, handler, textView, c2, runnable, activityC0071c, str));
        m438b.show();
        switch (spinner.getSelectedItemPosition()) {
            case 1:
                String str4 = m19423a3[spinner2.getSelectedItemPosition()];
                str2 = m19423a3[spinner3.getSelectedItemPosition() + 1];
                str3 = str4;
                break;
            case 2:
                String str5 = m19423a5[spinner2.getSelectedItemPosition()];
                str2 = m19423a5[spinner3.getSelectedItemPosition() + 1];
                str3 = str5;
                break;
            case 3:
                String str6 = m19423a7[spinner2.getSelectedItemPosition()];
                str2 = m19423a7[spinner3.getSelectedItemPosition() + 1];
                str3 = str6;
                break;
            case 4:
                String str7 = m19423a9[spinner2.getSelectedItemPosition()];
                str2 = m19423a9[spinner3.getSelectedItemPosition() + 1];
                str3 = str7;
                break;
            default:
                String str8 = m19423a[spinner2.getSelectedItemPosition()];
                str2 = m19423a[spinner3.getSelectedItemPosition() + 1];
                str3 = str8;
                break;
        }
        handler.postDelayed(runnable, 1000L);
        m17618a(activityC0071c, m18905a, str, str3, str2, textView, handler);
    }

    /* compiled from: EditorFragment.java */
    /* renamed from: ru.maximoff.apktool.fragment.a$24, reason: invalid class name */
    class AnonymousClass24 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final MenuItemOnActionExpandListenerC2976a f15984a;

        /* renamed from: b */
        private final DialogInterfaceC0070b f15985b;

        /* renamed from: c */
        private final Spinner f15986c;

        /* renamed from: d */
        private final String[] f15987d;

        /* renamed from: e */
        private final Spinner f15988e;

        /* renamed from: f */
        private final Spinner f15989f;

        /* renamed from: g */
        private final String[] f15990g;

        /* renamed from: h */
        private final String[] f15991h;

        /* renamed from: i */
        private final String[] f15992i;

        /* renamed from: j */
        private final String[] f15993j;

        /* renamed from: k */
        private final Handler f15994k;

        /* renamed from: l */
        private final TextView f15995l;

        /* renamed from: m */
        private final String f15996m;

        /* renamed from: n */
        private final Runnable f15997n;

        /* renamed from: o */
        private final Context f15998o;

        /* renamed from: p */
        private final String f15999p;

        AnonymousClass24(MenuItemOnActionExpandListenerC2976a menuItemOnActionExpandListenerC2976a, DialogInterfaceC0070b dialogInterfaceC0070b, Spinner spinner, String[] strArr, Spinner spinner2, Spinner spinner3, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5, Handler handler, TextView textView, String str, Runnable runnable, Context context, String str2) {
            this.f15984a = menuItemOnActionExpandListenerC2976a;
            this.f15985b = dialogInterfaceC0070b;
            this.f15986c = spinner;
            this.f15987d = strArr;
            this.f15988e = spinner2;
            this.f15989f = spinner3;
            this.f15990g = strArr2;
            this.f15991h = strArr3;
            this.f15992i = strArr4;
            this.f15993j = strArr5;
            this.f15994k = handler;
            this.f15995l = textView;
            this.f15996m = str;
            this.f15997n = runnable;
            this.f15998o = context;
            this.f15999p = str2;
        }

        /* renamed from: a */
        static MenuItemOnActionExpandListenerC2976a m17666a(AnonymousClass24 anonymousClass24) {
            return anonymousClass24.f15984a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            Button m414a = this.f15985b.m414a(-2);
            Button m414a2 = this.f15985b.m414a(-3);
            m414a.setOnClickListener(new View.OnClickListener(this, this.f15986c, this.f15987d, this.f15988e, this.f15989f, this.f15990g, this.f15991h, this.f15992i, this.f15993j, this.f15994k, this.f15995l, this.f15996m, this.f15997n, this.f15998o, this.f15999p) { // from class: ru.maximoff.apktool.fragment.a.24.1

                /* renamed from: a */
                private final AnonymousClass24 f16000a;

                /* renamed from: b */
                private final Spinner f16001b;

                /* renamed from: c */
                private final String[] f16002c;

                /* renamed from: d */
                private final Spinner f16003d;

                /* renamed from: e */
                private final Spinner f16004e;

                /* renamed from: f */
                private final String[] f16005f;

                /* renamed from: g */
                private final String[] f16006g;

                /* renamed from: h */
                private final String[] f16007h;

                /* renamed from: i */
                private final String[] f16008i;

                /* renamed from: j */
                private final Handler f16009j;

                /* renamed from: k */
                private final TextView f16010k;

                /* renamed from: l */
                private final String f16011l;

                /* renamed from: m */
                private final Runnable f16012m;

                /* renamed from: n */
                private final Context f16013n;

                /* renamed from: o */
                private final String f16014o;

                {
                    this.f16000a = this;
                    this.f16001b = r2;
                    this.f16002c = r3;
                    this.f16003d = r4;
                    this.f16004e = r5;
                    this.f16005f = r6;
                    this.f16006g = r7;
                    this.f16007h = r8;
                    this.f16008i = r9;
                    this.f16009j = r10;
                    this.f16010k = r11;
                    this.f16011l = r12;
                    this.f16012m = r13;
                    this.f16013n = r14;
                    this.f16014o = r15;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    String str2;
                    switch (this.f16001b.getSelectedItemPosition()) {
                        case 1:
                            str = this.f16005f[this.f16003d.getSelectedItemPosition()];
                            str2 = this.f16005f[this.f16004e.getSelectedItemPosition() + 1];
                            break;
                        case 2:
                            str = this.f16006g[this.f16003d.getSelectedItemPosition()];
                            str2 = this.f16006g[this.f16004e.getSelectedItemPosition() + 1];
                            break;
                        case 3:
                            str = this.f16007h[this.f16003d.getSelectedItemPosition()];
                            str2 = this.f16007h[this.f16004e.getSelectedItemPosition() + 1];
                            break;
                        case 4:
                            str = this.f16008i[this.f16003d.getSelectedItemPosition()];
                            str2 = this.f16008i[this.f16004e.getSelectedItemPosition() + 1];
                            break;
                        default:
                            str = this.f16002c[this.f16003d.getSelectedItemPosition()];
                            str2 = this.f16002c[this.f16004e.getSelectedItemPosition() + 1];
                            break;
                    }
                    this.f16009j.removeCallbacksAndMessages((Object) null);
                    this.f16010k.setText(this.f16011l);
                    this.f16010k.setTag(this.f16011l);
                    this.f16009j.postDelayed(this.f16012m, 1000L);
                    AnonymousClass24.m17666a(this.f16000a).m17618a(this.f16013n, this.f16001b.getSelectedItemPosition(), this.f16014o, str, str2, this.f16010k, this.f16009j);
                }
            });
            m414a2.setOnClickListener(new AnonymousClass2(this, this.f15995l, this.f15998o, this.f15985b));
        }

        /* compiled from: EditorFragment.java */
        /* renamed from: ru.maximoff.apktool.fragment.a$24$2, reason: invalid class name */
        class AnonymousClass2 implements View.OnClickListener {

            /* renamed from: a */
            private final AnonymousClass24 f16015a;

            /* renamed from: b */
            private final TextView f16016b;

            /* renamed from: c */
            private final Context f16017c;

            /* renamed from: d */
            private final DialogInterfaceC0070b f16018d;

            AnonymousClass2(AnonymousClass24 anonymousClass24, TextView textView, Context context, DialogInterfaceC0070b dialogInterfaceC0070b) {
                this.f16015a = anonymousClass24;
                this.f16016b = textView;
                this.f16017c = context;
                this.f16018d = dialogInterfaceC0070b;
            }

            /* renamed from: a */
            static AnonymousClass24 m17667a(AnonymousClass2 anonymousClass2) {
                return anonymousClass2.f16015a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (this.f16016b.getTag() != null) {
                    C3112bn.m18999a(this.f16017c, R.string.mplease_wait);
                    return;
                }
                C0173ao c0173ao = new C0173ao(this.f16017c, view);
                if (C3102bd.m18910a(this.f16017c, "menu_position", "1").equals("0")) {
                    i = 3;
                } else {
                    i = 5;
                }
                c0173ao.m1340a(i);
                c0173ao.m1339a().add(0, 1700, 0, this.f16017c.getString(R.string.settings)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f16017c, this.f16018d) { // from class: ru.maximoff.apktool.fragment.a.24.2.1

                    /* renamed from: a */
                    private final AnonymousClass2 f16019a;

                    /* renamed from: b */
                    private final Context f16020b;

                    /* renamed from: c */
                    private final DialogInterfaceC0070b f16021c;

                    {
                        this.f16019a = this;
                        this.f16020b = r2;
                        this.f16021c = r3;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        C3239s.m19428b(this.f16020b);
                        this.f16021c.cancel();
                        return true;
                    }
                });
                c0173ao.m1339a().add(0, 1701, 0, this.f16017c.getString(R.string.copy)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f16017c, this.f16016b) { // from class: ru.maximoff.apktool.fragment.a.24.2.2

                    /* renamed from: a */
                    private final AnonymousClass2 f16022a;

                    /* renamed from: b */
                    private final Context f16023b;

                    /* renamed from: c */
                    private final TextView f16024c;

                    {
                        this.f16022a = this;
                        this.f16023b = r2;
                        this.f16024c = r3;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        C3112bn.m19002a(this.f16023b, this.f16024c.getText().toString());
                        return true;
                    }
                });
                c0173ao.m1339a().add(0, 1702, 0, this.f16017c.getString(R.string.paste)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f16016b, this.f16018d) { // from class: ru.maximoff.apktool.fragment.a.24.2.3

                    /* renamed from: a */
                    private final AnonymousClass2 f16025a;

                    /* renamed from: b */
                    private final TextView f16026b;

                    /* renamed from: c */
                    private final DialogInterfaceC0070b f16027c;

                    {
                        this.f16025a = this;
                        this.f16026b = r2;
                        this.f16027c = r3;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        AnonymousClass24.m17666a(AnonymousClass2.m17667a(this.f16025a)).m17654c(this.f16026b.getText().toString());
                        this.f16027c.cancel();
                        return true;
                    }
                });
                c0173ao.m1344c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17618a(Context context, int i, String str, String str2, String str3, TextView textView, Handler handler) {
        String m18910a = C3102bd.m18910a(context, "deepl_api_key", "");
        AsyncTaskC3238r asyncTaskC3238r = new AsyncTaskC3238r(context, C3102bd.f18289Y);
        asyncTaskC3238r.m19407a(i);
        asyncTaskC3238r.m19410a(true);
        asyncTaskC3238r.m19409a(new AsyncTaskC3238r.a(this, handler, textView, context, str2, str3, str, i, m18910a) { // from class: ru.maximoff.apktool.fragment.a.25

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f16028a;

            /* renamed from: b */
            private final Handler f16029b;

            /* renamed from: c */
            private final TextView f16030c;

            /* renamed from: d */
            private final Context f16031d;

            /* renamed from: e */
            private final String f16032e;

            /* renamed from: f */
            private final String f16033f;

            /* renamed from: g */
            private final String f16034g;

            /* renamed from: h */
            private final int f16035h;

            /* renamed from: i */
            private final String f16036i;

            {
                this.f16028a = this;
                this.f16029b = handler;
                this.f16030c = textView;
                this.f16031d = context;
                this.f16032e = str2;
                this.f16033f = str3;
                this.f16034g = str;
                this.f16035h = i;
                this.f16036i = m18910a;
            }

            @Override // ru.maximoff.apktool.util.p308f.AsyncTaskC3238r.a
            /* renamed from: a */
            public void mo16855a() {
                this.f16029b.removeCallbacksAndMessages((Object) null);
                this.f16030c.setText("Error: translator stopped!");
            }

            @Override // ru.maximoff.apktool.util.p308f.AsyncTaskC3238r.a
            /* renamed from: a */
            public void mo16857a(Map<String, String> map) {
                C3237q c3237q = new C3237q(this.f16031d, this.f16032e, this.f16033f, this.f16034g);
                c3237q.m19398a(C3102bd.f18289Y);
                c3237q.m19402b(1);
                c3237q.m19399a(map);
                c3237q.m19397a(this.f16035h);
                c3237q.m19403b(this.f16036i);
                c3237q.m19400a(new C3237q.a(this, this.f16029b, this.f16035h, this.f16030c, this.f16031d) { // from class: ru.maximoff.apktool.fragment.a.25.1

                    /* renamed from: a */
                    private final AnonymousClass25 f16037a;

                    /* renamed from: b */
                    private final Handler f16038b;

                    /* renamed from: c */
                    private final int f16039c;

                    /* renamed from: d */
                    private final TextView f16040d;

                    /* renamed from: e */
                    private final Context f16041e;

                    {
                        this.f16037a = this;
                        this.f16038b = r2;
                        this.f16039c = r3;
                        this.f16040d = r4;
                        this.f16041e = r5;
                    }

                    @Override // ru.maximoff.apktool.util.p308f.C3237q.a
                    /* renamed from: b */
                    public void mo16860b() {
                    }

                    @Override // ru.maximoff.apktool.util.p308f.C3237q.a
                    /* renamed from: a */
                    public void mo16858a() {
                        this.f16038b.removeCallbacksAndMessages((Object) null);
                        if (this.f16039c == 4) {
                            this.f16040d.setText(R.string.mtr_deepl_warn);
                        } else {
                            this.f16040d.setText("Error: translator stopped!");
                        }
                    }

                    @Override // ru.maximoff.apktool.util.p308f.C3237q.a
                    /* renamed from: a */
                    public void mo16859a(String str4) {
                        this.f16038b.removeCallbacksAndMessages((Object) null);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this, this.f16040d, str4) { // from class: ru.maximoff.apktool.fragment.a.25.1.1

                            /* renamed from: a */
                            private final AnonymousClass1 f16042a;

                            /* renamed from: b */
                            private final TextView f16043b;

                            /* renamed from: c */
                            private final String f16044c;

                            {
                                this.f16042a = this;
                                this.f16043b = r2;
                                this.f16044c = str4;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                this.f16043b.setText(this.f16044c);
                                this.f16043b.setTag((Object) null);
                            }
                        }, 100L);
                    }

                    @Override // ru.maximoff.apktool.util.p308f.C3237q.a
                    /* renamed from: b */
                    public void mo16861b(String str4) {
                        C3112bn.m19023b(this.f16041e, this.f16041e.getString(R.string.errorf, str4));
                    }
                });
                c3237q.m19396a();
            }

            @Override // ru.maximoff.apktool.util.p308f.AsyncTaskC3238r.a
            /* renamed from: a */
            public void mo16856a(String str4) {
                C3112bn.m19023b(this.f16031d, this.f16031d.getString(R.string.errorf, str4));
            }
        });
        try {
            asyncTaskC3238r.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        } catch (Exception e2) {
            C3112bn.m18999a(context, R.string.error_try_again);
        }
    }

    /* renamed from: g */
    public void m17661g(String str) {
        String m18537a;
        int i = -16777216;
        int i2 = 1;
        this.f15908aj = 4;
        if (str == null || str.isEmpty()) {
            this.f15907ai = "#";
        } else {
            try {
                if (C3112bn.m19035j(str)) {
                    this.f15908aj = str.split(",").length;
                    m18537a = String.format("#%08x", new Integer(C3112bn.m19036k(str) & (-1)));
                } else {
                    m18537a = (str.startsWith("-0x") || str.startsWith("0x")) ? C3080al.m18537a(str) : str;
                }
                if (!m18537a.startsWith("#")) {
                    m18537a = new StringBuffer().append("#").append(m18537a).toString();
                    this.f15907ai = "";
                } else {
                    this.f15907ai = "#";
                }
                StringBuilder sb = new StringBuilder();
                if (m18537a.length() == 5) {
                    sb.append("#");
                    while (i2 < 5) {
                        sb.append(m18537a.charAt(i2)).append(m18537a.charAt(i2));
                        i2++;
                    }
                } else if (m18537a.length() == 4) {
                    sb.append("#");
                    while (i2 < 4) {
                        sb.append(m18537a.charAt(i2)).append(m18537a.charAt(i2));
                        i2++;
                    }
                } else {
                    sb.append(m18537a);
                }
                i = Color.parseColor(sb.toString());
            } catch (Exception e2) {
                this.f15907ai = "#";
            }
        }
        new C3321c(m2879p()).m20105a(i).m20108b(m2849c(R.string.select_color)).m20107a(new AnonymousClass26(this)).m20104a().m20109b();
    }

    /* compiled from: EditorFragment.java */
    /* renamed from: ru.maximoff.apktool.fragment.a$26, reason: invalid class name */
    class AnonymousClass26 implements C3321c.a {

        /* renamed from: a */
        private final MenuItemOnActionExpandListenerC2976a f16045a;

        AnonymousClass26(MenuItemOnActionExpandListenerC2976a menuItemOnActionExpandListenerC2976a) {
            this.f16045a = menuItemOnActionExpandListenerC2976a;
        }

        /* renamed from: a */
        static MenuItemOnActionExpandListenerC2976a m17668a(AnonymousClass26 anonymousClass26) {
            return anonymousClass26.f16045a;
        }

        @Override // ru.maximoff.color.C3321c.a
        /* renamed from: a */
        public void mo16419a() {
        }

        @Override // ru.maximoff.color.C3321c.a
        /* renamed from: a */
        public void mo16421a(String str) {
        }

        @Override // ru.maximoff.color.C3321c.a
        /* renamed from: b */
        public void mo16422b(String str) {
        }

        @Override // ru.maximoff.color.C3321c.a
        /* renamed from: a */
        public void mo16420a(int i) {
            new DialogInterfaceC0070b.a(this.f16045a.m2879p()).m418a(R.string.mselect).m431a(this.f16045a.m2879p().getResources().getStringArray(R.array.color_var), new DialogInterface.OnClickListener(this, i) { // from class: ru.maximoff.apktool.fragment.a.26.1

                /* renamed from: a */
                private final AnonymousClass26 f16046a;

                /* renamed from: b */
                private final int f16047b;

                {
                    this.f16046a = this;
                    this.f16047b = i;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    String format = String.format(new StringBuffer().append(AnonymousClass26.m17668a(this.f16046a).f15907ai).append("%08x").toString(), new Integer(this.f16047b & (-1)));
                    if (i2 == 1) {
                        format = C3080al.m18581b(format);
                    } else if (i2 == 2) {
                        if (AnonymousClass26.m17668a(this.f16046a).f15908aj == 3) {
                            format = String.format("%d,%d,%d", new Integer(Color.red(this.f16047b)), new Integer(Color.green(this.f16047b)), new Integer(Color.blue(this.f16047b)));
                        } else {
                            format = String.format("%d,%d,%d,%d", new Integer(Color.alpha(this.f16047b)), new Integer(Color.red(this.f16047b)), new Integer(Color.green(this.f16047b)), new Integer(Color.blue(this.f16047b)));
                        }
                    }
                    C2978b.f16135a.m17701b(AnonymousClass26.m17668a(this.f16046a).f15896X.getCurrentItem(), format);
                    dialogInterface.dismiss();
                }
            }).m438b().show();
        }
    }

    /* renamed from: a */
    public void m17640a(CharSequence charSequence, boolean z) {
        new AsyncTaskC2977a((MainActivity) m2879p(), this.f15896X, z).execute(charSequence);
    }

    /* renamed from: aA */
    public boolean m17644aA() {
        return this.f15905ag.getVisibility() == 0;
    }

    /* renamed from: a */
    public void m17641a(CharSequence charSequence, boolean z, boolean z2) {
        boolean m18925a = C3102bd.m18925a(m2879p(), "search_editor_regexp", false);
        EditText editText = (EditText) this.f15905ag.findViewById(R.id.editorpagerEditText1);
        this.f15905ag.setVisibility(0);
        editText.setImeOptions(3);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this, charSequence, m18925a, z2, editText, z) { // from class: ru.maximoff.apktool.fragment.a.27

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f16048a;

            /* renamed from: b */
            private final CharSequence f16049b;

            /* renamed from: c */
            private final boolean f16050c;

            /* renamed from: d */
            private final boolean f16051d;

            /* renamed from: e */
            private final EditText f16052e;

            /* renamed from: f */
            private final boolean f16053f;

            {
                this.f16048a = this;
                this.f16049b = charSequence;
                this.f16050c = m18925a;
                this.f16051d = z2;
                this.f16052e = editText;
                this.f16053f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f16049b != null && !this.f16049b.equals("")) {
                    if (this.f16050c && !this.f16051d) {
                        this.f16052e.setText(C3112bn.m19024c(this.f16049b));
                    } else {
                        this.f16052e.setText(this.f16049b);
                    }
                }
                if (this.f16053f) {
                    this.f16052e.requestFocus();
                    this.f16052e.selectAll();
                    ((InputMethodManager) this.f16048a.m2879p().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(this.f16052e, 1);
                }
            }
        }, 100L);
    }

    /* renamed from: aB */
    public boolean m17645aB() {
        if (!m17644aA()) {
            return false;
        }
        this.f15905ag.findViewById(R.id.editorpagerLinearLayout2).setVisibility(8);
        this.f15905ag.findViewById(R.id.editorpagerButton4).setEnabled(false);
        this.f15905ag.setVisibility(8);
        m17647au();
        return true;
    }

    /* renamed from: aC */
    public boolean m17646aC() {
        if (!C2978b.f16135a.m17734t(this.f15896X.getCurrentItem()) || this.f15906ah == null) {
            return false;
        }
        mo2820a(this.f15906ah);
        return true;
    }

    /* renamed from: b */
    public void m17653b(Context context) {
        this.f15901ac.removeAllViews();
        if (!C3102bd.f18284T) {
            this.f15900ab.setVisibility(8);
            return;
        }
        C3093ay c3093ay = new C3093ay(context);
        if (c3093ay.m18784c()) {
            this.f15900ab.setVisibility(8);
            return;
        }
        List<C3093ay.a> m18786e = c3093ay.m18786e();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int m18522a = C3080al.m18522a(context, C3102bd.f18332o + 4);
        int m18521a = C3080al.m18521a(context, 7.0f);
        int resourceId = m2879p().obtainStyledAttributes(new int[]{C0012R.attr.selectableItemBackground}).getResourceId(0, 0);
        for (C3093ay.a aVar : m18786e) {
            String m18790a = aVar.m18790a();
            if (m18790a.equals("\t") || m18790a.equals("    ")) {
                m18790a = "⇥";
            }
            SpannableString spannableString = new SpannableString(m18790a);
            spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 0);
            TextView textView = new TextView(context);
            textView.setClickable(true);
            textView.setFocusable(true);
            textView.setBackgroundResource(resourceId);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setGravity(17);
            textView.setMinimumHeight((m18521a * 2) + m18522a);
            textView.setMinimumWidth((m18521a * 2) + m18522a);
            textView.setText(spannableString);
            textView.setTypeface(C3102bd.f18327j);
            textView.setTextSize(2, C3102bd.f18329l + 4);
            textView.setPadding(m18521a, m18521a, m18521a, m18521a);
            textView.setOnClickListener(new View.OnClickListener(this, aVar) { // from class: ru.maximoff.apktool.fragment.a.28

                /* renamed from: a */
                private final MenuItemOnActionExpandListenerC2976a f16054a;

                /* renamed from: b */
                private final C3093ay.a f16055b;

                {
                    this.f16054a = this;
                    this.f16055b = aVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String m18791b = this.f16055b.m18791b();
                    if (this.f16054a.m17644aA()) {
                        EditText editText = (EditText) this.f16054a.f15905ag.findViewById(R.id.editorpagerEditText1);
                        EditText editText2 = (EditText) this.f16054a.f15905ag.findViewById(R.id.editorpagerEditText2);
                        if (editText.isFocused()) {
                            C3112bn.m19007a(editText, (CharSequence) m18791b);
                            return;
                        } else if (editText2.isFocused()) {
                            C3112bn.m19007a(editText2, (CharSequence) m18791b);
                            return;
                        }
                    }
                    C2978b.f16135a.m17701b(this.f16054a.f15896X.getCurrentItem(), m18791b);
                }
            });
            this.f15901ac.addView(textView, layoutParams);
        }
    }

    /* renamed from: a */
    public View m17629a(Context context, View view) {
        int i = C3102bd.f18291a ? -1 : -12303292;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.editorpagerLinearLayout1);
        linearLayout.setBackgroundColor(i);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.editorpagerImageView1);
        if (C3102bd.f18291a) {
            imageView.setImageResource(R.drawable.ic_collapse);
        } else {
            imageView.setImageResource(R.drawable.ic_collapse_dark);
        }
        ImageView imageView2 = (ImageView) linearLayout.findViewById(R.id.editorpagerImageView2);
        if (C3102bd.f18291a) {
            imageView2.setImageResource(R.drawable.ic_collapse);
        } else {
            imageView2.setImageResource(R.drawable.ic_collapse_dark);
        }
        ImageView imageView3 = (ImageView) linearLayout.findViewById(R.id.editorpagerImageView3);
        if (C3102bd.f18291a) {
            imageView3.setImageResource(R.drawable.ic_dotsmenu);
        } else {
            imageView3.setImageResource(R.drawable.ic_dotsmenu_dark);
        }
        imageView3.setOnClickListener(new AnonymousClass29(this, context));
        this.f15909ak = (EditText) linearLayout.findViewById(R.id.editorpagerEditText1);
        this.f15910al = (EditText) linearLayout.findViewById(R.id.editorpagerEditText2);
        C3112bn.m19006a(this.f15909ak, 10000);
        C3112bn.m19006a(this.f15910al, 10000);
        ImageView imageView4 = (ImageView) linearLayout.findViewById(R.id.editorpagerTextSwap);
        imageView4.setImageResource(R.drawable.ic_tswap_disable);
        imageView4.setEnabled(false);
        this.f15909ak.setImeOptions(3);
        this.f15910al.setImeOptions(3);
        C3212b c3212b = new C3212b(context, "editor_search");
        C3212b c3212b2 = new C3212b(context, "editor_replace");
        List<String> m19205b = c3212b.m19205b();
        List<String> m19205b2 = c3212b2.m19205b();
        if (m19205b.isEmpty()) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            this.f15909ak.setText(m19205b.get(m19205b.size() - 1));
        }
        if (m19205b2.isEmpty()) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setVisibility(0);
            this.f15910al.setText(m19205b2.get(m19205b2.size() - 1));
        }
        imageView.setOnClickListener(new View.OnClickListener(this, c3212b, imageView) { // from class: ru.maximoff.apktool.fragment.a.30

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f16060a;

            /* renamed from: b */
            private final C3212b f16061b;

            /* renamed from: c */
            private final ImageView f16062c;

            {
                this.f16060a = this;
                this.f16061b = c3212b;
                this.f16062c = imageView;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                this.f16061b.m19201a(this.f16062c, this.f16060a.f15909ak);
            }
        });
        imageView.setOnLongClickListener(new View.OnLongClickListener(this, c3212b, imageView, context) { // from class: ru.maximoff.apktool.fragment.a.31

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f16063a;

            /* renamed from: b */
            private final C3212b f16064b;

            /* renamed from: c */
            private final ImageView f16065c;

            /* renamed from: d */
            private final Context f16066d;

            {
                this.f16063a = this;
                this.f16064b = c3212b;
                this.f16065c = imageView;
                this.f16066d = context;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                new C3078aj(this.f16066d).m18500b(R.string.clear_history).m18495a(R.string.yes, new Runnable(this, this.f16064b, this.f16065c) { // from class: ru.maximoff.apktool.fragment.a.31.1

                    /* renamed from: a */
                    private final AnonymousClass31 f16067a;

                    /* renamed from: b */
                    private final C3212b f16068b;

                    /* renamed from: c */
                    private final ImageView f16069c;

                    {
                        this.f16067a = this;
                        this.f16068b = r2;
                        this.f16069c = r3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f16068b.m19208d();
                        this.f16069c.setVisibility(8);
                    }
                }).m18507d();
                return true;
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener(this, c3212b2, imageView2) { // from class: ru.maximoff.apktool.fragment.a.32

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f16070a;

            /* renamed from: b */
            private final C3212b f16071b;

            /* renamed from: c */
            private final ImageView f16072c;

            {
                this.f16070a = this;
                this.f16071b = c3212b2;
                this.f16072c = imageView2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                this.f16071b.m19201a(this.f16072c, this.f16070a.f15910al);
            }
        });
        imageView2.setOnLongClickListener(new View.OnLongClickListener(this, c3212b2, imageView2, context) { // from class: ru.maximoff.apktool.fragment.a.33

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f16073a;

            /* renamed from: b */
            private final C3212b f16074b;

            /* renamed from: c */
            private final ImageView f16075c;

            /* renamed from: d */
            private final Context f16076d;

            {
                this.f16073a = this;
                this.f16074b = c3212b2;
                this.f16075c = imageView2;
                this.f16076d = context;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                new C3078aj(this.f16076d).m18500b(R.string.clear_history).m18495a(R.string.yes, new Runnable(this, this.f16074b, this.f16075c) { // from class: ru.maximoff.apktool.fragment.a.33.1

                    /* renamed from: a */
                    private final AnonymousClass33 f16077a;

                    /* renamed from: b */
                    private final C3212b f16078b;

                    /* renamed from: c */
                    private final ImageView f16079c;

                    {
                        this.f16077a = this;
                        this.f16078b = r2;
                        this.f16079c = r3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f16078b.m19208d();
                        this.f16079c.setVisibility(8);
                    }
                }).m18508e(R.string.cancel).m18507d();
                return true;
            }
        });
        ImageView imageView5 = (ImageView) linearLayout.findViewById(R.id.clearText1);
        ImageView imageView6 = (ImageView) linearLayout.findViewById(R.id.clearText2);
        if (C3102bd.f18291a) {
            imageView5.setImageResource(R.drawable.ic_close);
            imageView6.setImageResource(R.drawable.ic_close);
        } else {
            imageView5.setImageResource(R.drawable.ic_close_dark);
            imageView6.setImageResource(R.drawable.ic_close_dark);
        }
        if (this.f15909ak.getText().length() == 0) {
            imageView5.setVisibility(8);
        }
        if (this.f15910al.getText().length() == 0) {
            imageView6.setVisibility(8);
        }
        imageView5.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.fragment.a.34

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f16080a;

            {
                this.f16080a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                this.f16080a.f15909ak.requestFocus();
                this.f16080a.f15909ak.setText("");
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.fragment.a.35

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f16081a;

            {
                this.f16081a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                this.f16081a.f15910al.requestFocus();
                this.f16081a.f15910al.setText("");
            }
        });
        this.f15909ak.addTextChangedListener(new TextWatcher(this, imageView5) { // from class: ru.maximoff.apktool.fragment.a.36

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f16082a;

            /* renamed from: b */
            private final ImageView f16083b;

            {
                this.f16082a = this;
                this.f16083b = imageView5;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0) {
                    this.f16083b.setVisibility(8);
                } else {
                    this.f16083b.setVisibility(0);
                }
            }
        });
        this.f15910al.addTextChangedListener(new TextWatcher(this, imageView6) { // from class: ru.maximoff.apktool.fragment.a.37

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f16084a;

            /* renamed from: b */
            private final ImageView f16085b;

            {
                this.f16084a = this;
                this.f16085b = imageView6;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0) {
                    this.f16085b.setVisibility(8);
                } else {
                    this.f16085b.setVisibility(0);
                }
            }
        });
        Button button = (Button) linearLayout.findViewById(R.id.editorpagerButton1);
        Button button2 = (Button) linearLayout.findViewById(R.id.editorpagerButton2);
        Button button3 = (Button) linearLayout.findViewById(R.id.editorpagerButton3);
        Button button4 = (Button) linearLayout.findViewById(R.id.editorpagerButton4);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.editorpagerLinearLayout2);
        button4.setEnabled(false);
        View.OnClickListener onClickListener = new View.OnClickListener(this, c3212b, imageView, context, linearLayout2, button4, imageView4, c3212b2, imageView2) { // from class: ru.maximoff.apktool.fragment.a.38

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f16086a;

            /* renamed from: b */
            private final C3212b f16087b;

            /* renamed from: c */
            private final ImageView f16088c;

            /* renamed from: d */
            private final Context f16089d;

            /* renamed from: e */
            private final LinearLayout f16090e;

            /* renamed from: f */
            private final Button f16091f;

            /* renamed from: g */
            private final ImageView f16092g;

            /* renamed from: h */
            private final C3212b f16093h;

            /* renamed from: i */
            private final ImageView f16094i;

            {
                this.f16086a = this;
                this.f16087b = c3212b;
                this.f16088c = imageView;
                this.f16089d = context;
                this.f16090e = linearLayout2;
                this.f16091f = button4;
                this.f16092g = imageView4;
                this.f16093h = c3212b2;
                this.f16094i = imageView2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String editable = this.f16086a.f15909ak.getText().toString();
                String editable2 = this.f16086a.f15910al.getText().toString();
                if (!C3112bn.m19040o(editable) || view2.getId() == R.id.editorpagerButton3) {
                    if (!C3112bn.m19040o(editable)) {
                        this.f16087b.m19204a(editable);
                        this.f16088c.setVisibility(0);
                    }
                    boolean m18925a = C3102bd.m18925a(this.f16089d, "search_editor_regexp", false);
                    boolean m18925a2 = C3102bd.m18925a(this.f16089d, "search_editor_csens", false);
                    boolean m18925a3 = C3102bd.m18925a(this.f16089d, "search_editor_whole", false);
                    boolean m18925a4 = C3102bd.m18925a(this.f16089d, "search_editor_loop", true);
                    switch (view2.getId()) {
                        case R.id.editorpagerButton1 /* 2131689785 */:
                            C2978b.f16135a.m17702b(this.f16086a.f15896X.getCurrentItem(), editable, m18925a2, m18925a3, m18925a, m18925a4);
                            break;
                        case R.id.editorpagerButton2 /* 2131689786 */:
                            C2978b.f16135a.m17690a(this.f16086a.f15896X.getCurrentItem(), editable, m18925a2, m18925a3, m18925a, m18925a4);
                            break;
                        case R.id.editorpagerButton3 /* 2131689787 */:
                            if (this.f16090e.getVisibility() == 8) {
                                this.f16090e.setVisibility(0);
                                this.f16091f.setEnabled(true);
                                this.f16086a.f15910al.requestFocus();
                                this.f16086a.f15910al.selectAll();
                                this.f16092g.setEnabled(true);
                                if (C3102bd.f18291a) {
                                    this.f16092g.setImageResource(R.drawable.ic_tswap);
                                    break;
                                } else {
                                    this.f16092g.setImageResource(R.drawable.ic_tswap_dark);
                                    break;
                                }
                            } else if (!C3112bn.m19040o(editable)) {
                                this.f16093h.m19204a(editable2);
                                this.f16094i.setVisibility(0);
                                C2978b.f16135a.m17689a(this.f16086a.f15896X.getCurrentItem(), editable, C3112bn.m19029d(editable2), m18925a2, m18925a3, m18925a);
                                break;
                            }
                            break;
                        case R.id.editorpagerButton4 /* 2131689788 */:
                            this.f16093h.m19204a(editable2);
                            this.f16094i.setVisibility(0);
                            new b(this.f16086a, this.f16089d, this.f16086a.f15896X.getCurrentItem(), editable, C3112bn.m19029d(editable2), m18925a2, m18925a3, m18925a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            break;
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener(this, context) { // from class: ru.maximoff.apktool.fragment.a.39

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f16095a;

            /* renamed from: b */
            private final Context f16096b;

            {
                this.f16095a = this;
                this.f16096b = context;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                String editable = this.f16095a.f15909ak.getText().toString();
                if (C3112bn.m19040o(editable)) {
                    return false;
                }
                boolean m18925a = C3102bd.m18925a(this.f16096b, "search_editor_regexp", false);
                new a(this.f16095a, this.f16096b, this.f16095a.f15896X.getCurrentItem(), editable, C3102bd.m18925a(this.f16096b, "search_editor_csens", false), C3102bd.m18925a(this.f16096b, "search_editor_whole", false), m18925a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return true;
            }
        };
        button2.setOnLongClickListener(onLongClickListener);
        button.setOnLongClickListener(onLongClickListener);
        button3.setOnLongClickListener(new View.OnLongClickListener(this, linearLayout2, button4, imageView4) { // from class: ru.maximoff.apktool.fragment.a.40

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f16098a;

            /* renamed from: b */
            private final LinearLayout f16099b;

            /* renamed from: c */
            private final Button f16100c;

            /* renamed from: d */
            private final ImageView f16101d;

            {
                this.f16098a = this;
                this.f16099b = linearLayout2;
                this.f16100c = button4;
                this.f16101d = imageView4;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                if (this.f16099b.getVisibility() != 0) {
                    return false;
                }
                this.f16100c.setEnabled(false);
                this.f16101d.setEnabled(false);
                this.f16101d.setImageResource(R.drawable.ic_tswap_disable);
                this.f16099b.setVisibility(8);
                this.f16098a.f15909ak.requestFocus();
                return true;
            }
        });
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener(this, button2, button3) { // from class: ru.maximoff.apktool.fragment.a.41

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f16102a;

            /* renamed from: b */
            private final Button f16103b;

            /* renamed from: c */
            private final Button f16104c;

            {
                this.f16102a = this;
                this.f16103b = button2;
                this.f16104c = button3;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
            
                return true;
             */
            @Override // android.widget.TextView.OnEditorActionListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if (i2 != 3) {
                    return false;
                }
                switch (textView.getId()) {
                    case R.id.editorpagerEditText1 /* 2131689777 */:
                        this.f16103b.performClick();
                        this.f16102a.f15909ak.requestFocus();
                        break;
                    case R.id.editorpagerEditText2 /* 2131689781 */:
                        this.f16104c.performClick();
                        this.f16102a.f15910al.requestFocus();
                        break;
                }
            }
        };
        this.f15909ak.setOnEditorActionListener(onEditorActionListener);
        this.f15910al.setOnEditorActionListener(onEditorActionListener);
        imageView4.setOnClickListener(new View.OnClickListener(this, linearLayout2) { // from class: ru.maximoff.apktool.fragment.a.42

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f16105a;

            /* renamed from: b */
            private final LinearLayout f16106b;

            {
                this.f16105a = this;
                this.f16106b = linearLayout2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (this.f16106b.getVisibility() != 8) {
                    String editable = this.f16105a.f15909ak.getText().toString();
                    String editable2 = this.f16105a.f15910al.getText().toString();
                    this.f16105a.f15909ak.setText(editable2);
                    this.f16105a.f15910al.setText(editable);
                    if (this.f16105a.f15909ak.isFocused()) {
                        this.f16105a.f15909ak.requestFocus();
                        this.f16105a.f15909ak.setSelection(editable2.length());
                    } else if (this.f16105a.f15910al.isFocused()) {
                        this.f16105a.f15910al.requestFocus();
                        this.f16105a.f15910al.setSelection(editable.length());
                    }
                }
            }
        });
        TextView textView = (TextView) linearLayout.findViewById(R.id.editorpagerFinlabel);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.editorpagerReplabel);
        View.OnLongClickListener onLongClickListener2 = new View.OnLongClickListener(this, linearLayout2) { // from class: ru.maximoff.apktool.fragment.a.43

            /* renamed from: a */
            private final MenuItemOnActionExpandListenerC2976a f16107a;

            /* renamed from: b */
            private final LinearLayout f16108b;

            {
                this.f16107a = this;
                this.f16108b = linearLayout2;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                if (this.f16108b.getVisibility() == 8) {
                    return false;
                }
                String editable = this.f16107a.f15909ak.getText().toString();
                String editable2 = this.f16107a.f15910al.getText().toString();
                this.f16107a.f15909ak.setText(editable2);
                this.f16107a.f15910al.setText(editable);
                if (this.f16107a.f15909ak.isFocused()) {
                    this.f16107a.f15909ak.requestFocus();
                    this.f16107a.f15909ak.setSelection(editable2.length());
                } else if (this.f16107a.f15910al.isFocused()) {
                    this.f16107a.f15910al.requestFocus();
                    this.f16107a.f15910al.setSelection(editable.length());
                }
                return true;
            }
        };
        textView.setOnLongClickListener(onLongClickListener2);
        textView2.setOnLongClickListener(onLongClickListener2);
        return linearLayout;
    }

    /* compiled from: EditorFragment.java */
    /* renamed from: ru.maximoff.apktool.fragment.a$29, reason: invalid class name */
    class AnonymousClass29 implements View.OnClickListener {

        /* renamed from: a */
        private final MenuItemOnActionExpandListenerC2976a f16056a;

        /* renamed from: b */
        private final Context f16057b;

        AnonymousClass29(MenuItemOnActionExpandListenerC2976a menuItemOnActionExpandListenerC2976a, Context context) {
            this.f16056a = menuItemOnActionExpandListenerC2976a;
            this.f16057b = context;
        }

        /* renamed from: a */
        static MenuItemOnActionExpandListenerC2976a m17669a(AnonymousClass29 anonymousClass29) {
            return anonymousClass29.f16056a;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            C0173ao c0173ao = new C0173ao(this.f16057b, view);
            c0173ao.m1343b(R.menu.search);
            if (C3102bd.m18910a(this.f16057b, "menu_position", "1").equals("0")) {
                i = 3;
            } else {
                i = 5;
            }
            c0173ao.m1340a(i);
            c0173ao.m1341a(new C0173ao.b(this) { // from class: ru.maximoff.apktool.fragment.a.29.1

                /* renamed from: a */
                private final AnonymousClass29 f16058a;

                {
                    this.f16058a = this;
                }

                @Override // androidx.appcompat.widget.C0173ao.b
                /* renamed from: a */
                public boolean mo1346a(MenuItem menuItem) {
                    return AnonymousClass29.m17669a(this.f16058a).mo2820a(menuItem);
                }
            });
            c0173ao.m1339a().findItem(R.id.whole_words).setChecked(C3102bd.m18925a(this.f16057b, "search_editor_whole", false));
            c0173ao.m1339a().findItem(R.id.search_regexp).setChecked(C3102bd.m18925a(this.f16057b, "search_editor_regexp", false));
            c0173ao.m1339a().findItem(R.id.search_case_sens).setChecked(C3102bd.m18925a(this.f16057b, "search_editor_csens", false));
            c0173ao.m1339a().findItem(R.id.search_loop).setChecked(C3102bd.m18925a(this.f16057b, "search_editor_loop", true));
            c0173ao.m1344c();
        }
    }

    /* compiled from: EditorFragment.java */
    /* renamed from: ru.maximoff.apktool.fragment.a$b */
    private class b extends AsyncTask<Void, Void, C1397s> {

        /* renamed from: a */
        private Context f16142a;

        /* renamed from: b */
        private DialogInterfaceC0070b f16143b;

        /* renamed from: c */
        private int f16144c;

        /* renamed from: d */
        private String f16145d;

        /* renamed from: e */
        private String f16146e;

        /* renamed from: f */
        private boolean f16147f;

        /* renamed from: g */
        private boolean f16148g;

        /* renamed from: h */
        private boolean f16149h;

        /* renamed from: i */
        private final MenuItemOnActionExpandListenerC2976a f16150i;

        @Override // android.p008os.AsyncTask
        protected C1397s doInBackground(Void[] voidArr) {
            return m17737a(voidArr);
        }

        @Override // android.p008os.AsyncTask
        protected void onPostExecute(C1397s c1397s) {
            m17738a(c1397s);
        }

        public b(MenuItemOnActionExpandListenerC2976a menuItemOnActionExpandListenerC2976a, Context context, int i, String str, String str2, boolean z, boolean z2, boolean z3) {
            this.f16150i = menuItemOnActionExpandListenerC2976a;
            this.f16142a = context;
            this.f16144c = i;
            this.f16145d = str;
            this.f16146e = str2;
            this.f16147f = z;
            this.f16148g = z2;
            this.f16149h = z3;
        }

        @Override // android.p008os.AsyncTask
        protected void onPreExecute() {
            View inflate = LayoutInflater.from(this.f16142a).inflate(R.layout.search_progress, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
            this.f16143b = new DialogInterfaceC0070b.a(this.f16142a).m435b(inflate).m429a(false).m438b();
            this.f16143b.show();
        }

        /* renamed from: a */
        protected C1397s m17737a(Void[] voidArr) {
            return C2978b.f16135a.m17698b(this.f16150i.f15896X.getCurrentItem(), this.f16145d, this.f16146e, this.f16147f, this.f16148g, this.f16149h);
        }

        /* renamed from: a */
        protected void m17738a(C1397s c1397s) {
            if (this.f16143b != null && this.f16143b.isShowing()) {
                try {
                    this.f16143b.cancel();
                } catch (Exception e2) {
                }
            }
            Editor m17727n = C2978b.f16135a.m17727n(this.f16150i.f15896X.getCurrentItem());
            if (m17727n != null) {
                m17727n.m10895f(false);
                m17727n.m10860G();
                if (c1397s.m11130a() == 0) {
                    C3112bn.m18999a(this.f16142a, R.string.not_found);
                    return;
                }
                m17727n.m10901h(((Integer) c1397s.m11134b()).intValue());
                m17727n.setEdited(true);
                C3112bn.m19023b(this.f16142a, this.f16142a.getString(R.string.total_repl, new Integer(c1397s.m11130a())));
            }
        }
    }

    /* compiled from: EditorFragment.java */
    /* renamed from: ru.maximoff.apktool.fragment.a$a */
    private class a extends AsyncTask<Void, Void, Integer> {

        /* renamed from: a */
        private Context f16126a;

        /* renamed from: b */
        private DialogInterfaceC0070b f16127b;

        /* renamed from: c */
        private int f16128c;

        /* renamed from: d */
        private String f16129d;

        /* renamed from: e */
        private boolean f16130e;

        /* renamed from: f */
        private boolean f16131f;

        /* renamed from: g */
        private boolean f16132g;

        /* renamed from: h */
        private final MenuItemOnActionExpandListenerC2976a f16133h;

        @Override // android.p008os.AsyncTask
        protected Integer doInBackground(Void[] voidArr) {
            return m17673a(voidArr);
        }

        @Override // android.p008os.AsyncTask
        protected void onPostExecute(Integer num) {
            m17674a(num);
        }

        public a(MenuItemOnActionExpandListenerC2976a menuItemOnActionExpandListenerC2976a, Context context, int i, String str, boolean z, boolean z2, boolean z3) {
            this.f16133h = menuItemOnActionExpandListenerC2976a;
            this.f16126a = context;
            this.f16128c = i;
            this.f16129d = str;
            this.f16130e = z;
            this.f16131f = z2;
            this.f16132g = z3;
        }

        @Override // android.p008os.AsyncTask
        protected void onPreExecute() {
            View inflate = LayoutInflater.from(this.f16126a).inflate(R.layout.search_progress, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
            this.f16127b = new DialogInterfaceC0070b.a(this.f16126a).m435b(inflate).m429a(false).m438b();
            this.f16127b.show();
        }

        /* renamed from: a */
        protected Integer m17673a(Void[] voidArr) {
            return new Integer(C2978b.f16135a.m17682a(this.f16128c, this.f16129d, this.f16130e, this.f16131f, this.f16132g));
        }

        /* renamed from: a */
        protected void m17674a(Integer num) {
            if (this.f16127b != null && this.f16127b.isShowing()) {
                try {
                    this.f16127b.cancel();
                } catch (Exception e2) {
                }
            }
            if (num.intValue() > 0) {
                C3112bn.m19023b(this.f16126a, String.format("%s: %d", this.f16126a.getString(R.string.total), num));
            } else {
                C3112bn.m18999a(this.f16126a, R.string.not_found);
            }
        }
    }
}
