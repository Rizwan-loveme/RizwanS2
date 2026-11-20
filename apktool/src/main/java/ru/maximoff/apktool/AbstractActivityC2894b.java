package ru.maximoff.apktool;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.app.ActivityC0071c;
import com.p159h.p160a.p162b.AbstractC1381c;
import com.srizwan.apktool.R;
import java.io.IOException;
import ru.maximoff.apktool.fragment.p301a.C2978b;
import ru.maximoff.apktool.util.C3077ai;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3113bo;

/* compiled from: ThemedActivity.java */
/* renamed from: ru.maximoff.apktool.b */
/* loaded from: classes.dex */
public abstract class AbstractActivityC2894b extends ActivityC0071c {
    /* renamed from: a */
    protected abstract void mo16413a(Bundle bundle);

    @Override // androidx.fragment.app.ActivityC0375f, androidx.activity.ActivityC0048b, androidx.core.app.ActivityC0234e, android.app.Activity
    public void onCreate(Bundle bundle) {
        m16937o();
        super.onCreate(bundle);
        if (C3102bd.f18301ai.equals("1")) {
            setRequestedOrientation(6);
        } else if (C3102bd.f18301ai.equals("2")) {
            setRequestedOrientation(7);
        } else {
            setRequestedOrientation(-1);
        }
        C3077ai.m18488a(this);
        if (!C3102bd.m18925a((Context) this, "disable_crashes", false)) {
            Thread.setDefaultUncaughtExceptionHandler(new C3113bo(this, C3080al.m18589c(this)));
        }
        mo16413a(bundle);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    protected void onApplyThemeResource(Resources.Theme theme, int i, boolean z) {
        super.onApplyThemeResource(theme, i, z);
    }

    /* renamed from: o */
    private void m16937o() {
        int i;
        int m18608k = C3080al.m18608k(this);
        switch (m18608k) {
            case 1:
                setTheme(R.style.AppTheme);
                break;
            case 2:
                setTheme(R.style.AppThemeBlack);
                break;
            default:
                setTheme(R.style.AppThemeLight);
                break;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            View decorView = getWindow().getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (m18608k == 0) {
                i = systemUiVisibility | 16;
            } else {
                i = systemUiVisibility & (-17);
            }
            decorView.setSystemUiVisibility(i);
        }
    }

    @Override // androidx.appcompat.app.ActivityC0071c, androidx.fragment.app.ActivityC0375f, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m16938a(configuration);
    }

    /* renamed from: a */
    protected boolean m16938a(Configuration configuration) {
        if (!C3102bd.m18925a((Context) this, "system_theme", true) || configuration == null) {
            C3077ai.m18488a(this);
            return false;
        }
        boolean m18567a = C3080al.m18567a(configuration);
        if (C3102bd.f18291a ? m18567a : !m18567a) {
            C3102bd.m18937b(this, "app_theme", String.valueOf(C3080al.m18591d(this, m18567a ? false : true)));
            C3102bd.f18320c = true;
            onResume();
            return true;
        }
        C3077ai.m18488a(this);
        return false;
    }

    @Override // android.app.Activity
    public void recreate() {
        C3102bd.m18914a((Context) this);
        C3077ai.m18488a(this);
        super.recreate();
    }

    @Override // androidx.fragment.app.ActivityC0375f, android.app.Activity
    protected void onResume() {
        super.onResume();
        C3102bd.m18914a((Context) this);
        C3080al.m18545a((Activity) this, C3102bd.f18275K);
        if (C3102bd.f18320c) {
            C3102bd.f18320c = false;
            try {
                C3102bd.m18929b(this, getAssets(), getFilesDir());
            } catch (IOException e2) {
            }
            AbstractC1381c.a.m11011a();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.b.1

                /* renamed from: a */
                private final AbstractActivityC2894b f14870a;

                {
                    this.f14870a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f14870a.recreate();
                }
            }, 100L);
            return;
        }
        if (C3102bd.f18336s) {
            C3102bd.f18336s = false;
            C2978b.f16135a.m17715h();
        }
    }
}
