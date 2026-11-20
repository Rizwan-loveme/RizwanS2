package ru.maximoff.apktool.fragment;

import android.content.res.Configuration;
import android.p008os.Build;
import android.p008os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActivityC0071c;
import androidx.core.content.C0255a;
import androidx.fragment.app.ComponentCallbacksC0374e;
import androidx.p044h.p045a.C0406b;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.util.ArrayList;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.fragment.p302b.C2986e;
import ru.maximoff.apktool.fragment.p302b.C2993l;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;

/* compiled from: FilesFragment.java */
/* renamed from: ru.maximoff.apktool.fragment.b */
/* loaded from: classes.dex */
public class C2981b extends ComponentCallbacksC0374e {

    /* renamed from: X */
    private MenuItemOnActionExpandListenerC2976a f16270X;

    /* renamed from: Y */
    private C0406b f16271Y;

    /* renamed from: aa */
    private C2993l f16273aa;

    /* renamed from: ab */
    private Bundle f16274ab;

    /* renamed from: W */
    private final int f16269W = PointerIcon.TYPE_ALIAS;

    /* renamed from: Z */
    private int f16272Z = 0;

    /* renamed from: a */
    public void m17820a(int i) {
        this.f16271Y.setCurrentItem(i);
    }

    /* renamed from: a */
    public void m17825a(C2986e c2986e) {
        this.f16270X.m17642a(c2986e);
    }

    /* renamed from: a */
    public void m17824a(MenuItemOnActionExpandListenerC2976a menuItemOnActionExpandListenerC2976a) {
        this.f16270X = menuItemOnActionExpandListenerC2976a;
    }

    /* renamed from: a */
    public void m17819a() {
        this.f16271Y.requestFocus();
    }

    /* renamed from: e */
    public int m17828e() {
        return this.f16272Z;
    }

    /* renamed from: au */
    public int m17826au() {
        return this.f16271Y.getCurrentItem();
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: b */
    public void mo2758b(Bundle bundle) {
        super.mo2758b(bundle);
        this.f16273aa = new C2993l((ActivityC0071c) m2879p());
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: b */
    public View mo2691b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.files_pager, viewGroup, false);
        this.f16271Y = (C0406b) inflate.findViewById(R.id.files_pager);
        ((TabLayout) inflate.findViewById(R.id.tab)).m91a(this.f16271Y, true);
        return inflate;
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: a */
    public void mo2688a(View view, Bundle bundle) {
        super.mo2688a(view, bundle);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: k */
    public void mo2871k(Bundle bundle) {
        super.mo2871k(bundle);
        this.f16274ab = bundle;
        C3102bd.m18916a((ActivityC0071c) m2879p(), new Runnable(this) { // from class: ru.maximoff.apktool.fragment.b.1

            /* renamed from: a */
            private final C2981b f16275a;

            {
                this.f16275a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                C3102bd.m18935b(this.f16275a.m2879p(), "license_version", 1);
                this.f16275a.m17818a(new String[]{"READ_EXTERNAL_STORAGE", "WRITE_EXTERNAL_STORAGE"});
            }
        }, new Runnable(this) { // from class: ru.maximoff.apktool.fragment.b.2

            /* renamed from: a */
            private final C2981b f16276a;

            {
                this.f16276a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                ((MainActivity) this.f16276a.m2879p()).finish();
            }
        }, false);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* renamed from: a */
    private void m17815a(Bundle bundle) {
        this.f16273aa.m18060a(bundle, this);
        this.f16271Y.setAdapter(this.f16273aa);
        this.f16271Y.m3323a(new C0406b.f(this) { // from class: ru.maximoff.apktool.fragment.b.3

            /* renamed from: a */
            private final C2981b f16277a;

            {
                this.f16277a = this;
            }

            @Override // androidx.p044h.p045a.C0406b.f
            /* renamed from: a */
            public void mo130a(int i) {
            }

            @Override // androidx.p044h.p045a.C0406b.f
            /* renamed from: a */
            public void mo131a(int i, float f2, int i2) {
            }

            @Override // androidx.p044h.p045a.C0406b.f
            /* renamed from: b */
            public void mo132b(int i) {
                this.f16277a.f16273aa.m18067e(i);
                if (i < 2) {
                    this.f16277a.f16272Z = i;
                }
            }
        });
        this.f16270X.m17630a();
        C3102bd.m18944d((ActivityC0071c) m2879p());
        ((MainActivity) m2879p()).m16640v();
    }

    /* renamed from: a */
    public void m17821a(File file) {
        this.f16270X.m17636a(file);
    }

    /* renamed from: a */
    public void m17823a(File file, boolean z, int i) {
        this.f16270X.m17639a(file, z, i);
    }

    /* renamed from: a */
    public void m17822a(File file, int i, int i2) {
        this.f16270X.m17637a(file, i, i2);
    }

    /* renamed from: av */
    public C2993l m17827av() {
        return this.f16273aa;
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: e */
    public void mo2762e(Bundle bundle) {
        this.f16273aa.m18059a(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17818a(String[] strArr) {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= strArr.length) {
                    break;
                }
                String stringBuffer = new StringBuffer().append("android.permission.").append(strArr[i2]).toString();
                if (C0255a.m1852b((ActivityC0071c) m2879p(), stringBuffer) != 0) {
                    arrayList.add(stringBuffer);
                }
                i = i2 + 1;
            }
            if (arrayList.size() == 0) {
                m17815a(this.f16274ab);
                return;
            } else {
                m2819a((String[]) arrayList.toArray(new String[arrayList.size()]), PointerIcon.TYPE_ALIAS);
                return;
            }
        }
        m17815a(this.f16274ab);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0374e
    /* renamed from: a */
    public void mo2805a(int i, String[] strArr, int[] iArr) {
        ActivityC0071c activityC0071c = (ActivityC0071c) m2879p();
        switch (i) {
            case PointerIcon.TYPE_ALIAS /* 1010 */:
                if (strArr == null || strArr.length == 0) {
                    m17815a(this.f16274ab);
                    break;
                } else if (iArr.length > 0 && iArr[0] == 0) {
                    m17815a(this.f16274ab);
                    break;
                } else if (!m2821a(strArr[0])) {
                    C3112bn.m19023b(activityC0071c, activityC0071c.getString(R.string.storage_error));
                    C3080al.m18588c(activityC0071c, activityC0071c.getPackageName());
                    ((MainActivity) m2879p()).finish();
                    break;
                } else {
                    C3112bn.m19023b(activityC0071c, activityC0071c.getString(R.string.storage_error));
                    m17818a(new String[]{"READ_EXTERNAL_STORAGE", "WRITE_EXTERNAL_STORAGE"});
                    break;
                }
                break;
            default:
                super.mo2805a(i, strArr, iArr);
                break;
        }
    }
}
