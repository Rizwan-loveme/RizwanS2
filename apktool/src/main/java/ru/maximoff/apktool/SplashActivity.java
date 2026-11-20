package ru.maximoff.apktool;

import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import androidx.appcompat.app.ActivityC0071c;
import com.srizwan.apktool.R;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;

/* loaded from: classes.dex */
public class SplashActivity extends ActivityC0071c implements Runnable {

    /* renamed from: h */
    private static boolean f14476h = false;

    /* renamed from: i */
    private int f14477i = 0;

    /* renamed from: j */
    private Intent f14478j;

    @Override // androidx.fragment.app.ActivityC0375f, androidx.activity.ActivityC0048b, androidx.core.app.ActivityC0234e, android.app.Activity
    public void onCreate(Bundle bundle) {
        m16771p();
        super.onCreate(bundle);
        setContentView(R.layout.splash);
        this.f14478j = getIntent();
        if (m16770o()) {
            run();
            return;
        }
        if (this.f14477i != 0) {
            ((ImageView) findViewById(R.id.splashImageView1)).setImageResource(this.f14477i);
        }
        new Handler(Looper.getMainLooper()).postDelayed(this, 500L);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    protected void onApplyThemeResource(Resources.Theme theme, int i, boolean z) {
        super.onApplyThemeResource(theme, i, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0095  */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m16771p() {
        int i;
        int i2;
        int i3;
        int m18608k = C3080al.m18608k(this);
        if (C3102bd.m18925a((Context) this, "system_theme", true) && Build.VERSION.SDK_INT >= 23) {
            boolean z = ((UiModeManager) getSystemService(Context.UI_MODE_SERVICE)).getNightMode() == 2;
            if ((m18608k == 0) ? z : !z) {
                i = C3080al.m18591d(this, !z);
                C3102bd.m18937b(this, "app_theme", String.valueOf(i));
                Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
                calendar.setTime(new Date());
                i2 = calendar.get(5);
                int i4 = calendar.get(2);
                if (i2 != 9 && i4 == 4) {
                    this.f14477i = R.drawable.splash_logo_9may;
                } else if ((i2 <= 24 && i4 == 11) || (i2 < 11 && i4 == 0)) {
                    this.f14477i = R.drawable.splash_logo_ng;
                } else {
                    this.f14477i = R.drawable.splash_logo;
                }
                C3102bd.m18938b(this, "nyholidays", this.f14477i == R.drawable.splash_logo_ng);
                switch (i) {
                    case 1:
                        i3 = 2131493237;
                        break;
                    case 2:
                        i3 = 2131493239;
                        break;
                    default:
                        i3 = 2131493238;
                        break;
                }
                setTheme(i3);
            }
        }
        i = m18608k;
        Calendar calendar2 = Calendar.getInstance(TimeZone.getDefault());
        calendar2.setTime(new Date());
        i2 = calendar2.get(5);
        int i42 = calendar2.get(2);
        if (i2 != 9) {
        }
        if (i2 <= 24) {
        }
        this.f14477i = R.drawable.splash_logo;
        C3102bd.m18938b(this, "nyholidays", this.f14477i == R.drawable.splash_logo_ng);
        switch (i) {
        }
        setTheme(i3);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Intent intent = new Intent(this, Class.forName("ru.maximoff.apktool.MainActivity"));
            if (this.f14478j != null) {
                if (this.f14478j.getAction() != null) {
                    intent.setAction(this.f14478j.getAction());
                }
                if (this.f14478j.getData() != null) {
                    intent.setData(this.f14478j.getData());
                }
                intent.addFlags(this.f14478j.getFlags());
                intent.putExtras(this.f14478j);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
            }
            startActivity(intent);
            if (m16770o()) {
                overridePendingTransition(R.anim.fast_fade_in, R.anim.fast_fade_out);
            } else {
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
            f14476h = true;
            finish();
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    /* renamed from: o */
    public static boolean m16770o() {
        return f14476h;
    }
}
