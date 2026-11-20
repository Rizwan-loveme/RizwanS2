package ru.maximoff.apktool;

import android.app.Application;
import android.content.Context;
import android.view.ContextThemeWrapper;
import com.srizwan.apktool.R;
import java.security.Security;
import p165d.p167b.p171d.C1436b;
import ru.maximoff.apktool.util.C3077ai;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;

/* loaded from: classes.dex */
public class ApktoolApplication extends Application {

    /* renamed from: a */
    private static Application f13587a;

    /* renamed from: a */
    public static Application m16370a() {
        return f13587a;
    }

    /* renamed from: b */
    public static Context m16371b() {
        return m16370a().getApplicationContext();
    }

    @Override // android.app.Application
    public void onCreate() {
        Security.addProvider(new C1436b());
        C3102bd.m18923a(this);
        super.onCreate();
        f13587a = this;
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        ContextThemeWrapper contextThemeWrapper;
        int m18608k = C3080al.m18608k(context);
        Context m18488a = C3077ai.m18488a(context);
        switch (m18608k) {
            case 1:
                contextThemeWrapper = new ContextThemeWrapper(m18488a, R.style.AppTheme);
                break;
            case 2:
                contextThemeWrapper = new ContextThemeWrapper(m18488a, R.style.AppThemeBlack);
                break;
            default:
                contextThemeWrapper = new ContextThemeWrapper(m18488a, R.style.AppThemeLight);
                break;
        }
        super.attachBaseContext(contextThemeWrapper);
    }
}
