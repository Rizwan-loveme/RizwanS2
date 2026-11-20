package ru.maximoff.apktool;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.slice.Slice;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.p006pm.ShortcutInfo;
import android.content.p006pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.security.keystore.KeyProperties;
import android.view.PointerIcon;
import android.view.View;
import com.srizwan.apktool.R;
import java.util.List;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;

/* loaded from: classes.dex */
public class CreateShortcut extends Activity {

    /* renamed from: a */
    private final int f13989a = PointerIcon.TYPE_ALIAS;

    /* renamed from: b */
    private Bitmap f13990b;

    /* renamed from: c */
    private String f13991c;

    /* renamed from: d */
    private String f13992d;

    /* renamed from: e */
    private String f13993e;

    /* renamed from: f */
    private String f13994f;

    /* renamed from: g */
    private String f13995g;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16544a(String str) {
        C3112bn.m19023b(this, str);
        if (Build.VERSION.SDK_INT >= 21) {
            finishAndRemoveTask();
        } else {
            finish();
        }
    }

    /* renamed from: ru.maximoff.apktool.CreateShortcut$a */
    private class AsyncTaskC2709a extends AsyncTask<Void, Void, Void> {

        /* renamed from: a */
        final int f13998a;

        /* renamed from: b */
        private final CreateShortcut f13999b;

        @Override // android.os.AsyncTask
        protected Void doInBackground(Void[] voidArr) {
            return m16548a(voidArr);
        }

        AsyncTaskC2709a(CreateShortcut createShortcut, int i) {
            this.f13999b = createShortcut;
            this.f13998a = i;
        }

        /* renamed from: a */
        protected Void m16548a(Void... voidArr) {
            try {
                Thread.sleep(this.f13998a);
                this.f13999b.sendBroadcast(new Intent(this.f13999b.f13995g));
            } catch (Exception e2) {
            }
            return (Void) null;
        }
    }

    /* renamed from: a */
    private void m16543a() {
        try {
            ShortcutManager shortcutManager = (ShortcutManager) getSystemService(Class.forName("android.content.pm.ShortcutManager"));
            if (shortcutManager != null && shortcutManager.isRequestPinShortcutSupported()) {
                List<ShortcutInfo> pinnedShortcuts = shortcutManager.getPinnedShortcuts();
                boolean z = false;
                for (int i = 0; i < pinnedShortcuts.size() && !z; i++) {
                    z = pinnedShortcuts.get(i).getId().equals(this.f13995g);
                }
                if (z) {
                    m16544a(getString(R.string.shortcut_exists));
                    return;
                }
                Intent intent = new Intent(this.f13995g);
                intent.putExtra(Slice.SUBTYPE_MESSAGE, getString(R.string.success));
                AsyncTaskC2709a asyncTaskC2709a = new AsyncTaskC2709a(this, 1000);
                asyncTaskC2709a.execute(new Void[0]);
                registerReceiver(new BroadcastReceiver(this, asyncTaskC2709a) { // from class: ru.maximoff.apktool.CreateShortcut.1

                    /* renamed from: a */
                    private final CreateShortcut f13996a;

                    /* renamed from: b */
                    private final AsyncTaskC2709a f13997b;

                    {
                        this.f13996a = this;
                        this.f13997b = asyncTaskC2709a;
                    }

                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent2) {
                        if (intent2.hasExtra(Slice.SUBTYPE_MESSAGE)) {
                            String stringExtra = intent2.getStringExtra(Slice.SUBTYPE_MESSAGE);
                            this.f13996a.unregisterReceiver(this);
                            this.f13997b.cancel(true);
                            this.f13996a.m16544a(stringExtra);
                        }
                    }
                }, new IntentFilter(this.f13995g));
                Intent intent2 = new Intent(Intent.ACTION_MAIN);
                intent2.setComponent(new ComponentName(this.f13991c, this.f13992d));
                shortcutManager.requestPinShortcut(new ShortcutInfo.Builder(this, this.f13995g).setShortLabel(this.f13993e).setIcon(Icon.createWithBitmap(this.f13990b)).setIntent(intent2).build(), PendingIntent.getBroadcast(this, PointerIcon.TYPE_ALIAS, intent, 0).getIntentSender());
            }
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    /* renamed from: b */
    private void m16546b() {
        try {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addFlags(268435456);
            intent.addFlags(67108864);
            intent.setComponent(new ComponentName(this.f13991c, this.f13992d));
            Intent intent2 = new Intent();
            intent2.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intent);
            intent2.putExtra(Intent.EXTRA_SHORTCUT_NAME, this.f13993e);
            intent2.putExtra(Intent.EXTRA_SHORTCUT_ICON, this.f13990b);
            intent2.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
            intent2.putExtra("duplicate", false);
            sendBroadcast(intent2);
            m16544a(getString(R.string.success));
        } catch (Exception e2) {
            m16544a(getString(R.string.error));
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        m16547c();
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!intent.hasExtra("shortcutIcon") || !intent.hasExtra("shortcutPackage") || !intent.hasExtra("shortcutClass") || !intent.hasExtra("shortcutName")) {
            m16544a(getString(R.string.errorf, getString(R.string.no_data)));
            return;
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra("shortcutIcon");
        this.f13990b = BitmapFactory.decodeByteArray(byteArrayExtra, 0, byteArrayExtra.length);
        this.f13991c = intent.getStringExtra("shortcutPackage");
        this.f13992d = intent.getStringExtra("shortcutClass");
        this.f13993e = intent.getStringExtra("shortcutName");
        this.f13994f = C3112bn.m19020b(new StringBuffer().append(new StringBuffer().append(this.f13991c).append("_").toString()).append(this.f13992d).toString(), KeyProperties.DIGEST_MD5);
        this.f13995g = new StringBuffer().append(new StringBuffer().append(getPackageName()).append(".SHORTCUT.").toString()).append(this.f13994f).toString();
        if (Build.VERSION.SDK_INT >= 26) {
            m16543a();
        } else {
            m16546b();
        }
    }

    /* renamed from: c */
    private void m16547c() {
        int i;
        switch (C3102bd.f18319b) {
            case 1:
                setTheme(R.style.TransparentTheme);
                break;
            case 2:
                setTheme(R.style.TransparentThemeBlack);
                break;
            default:
                setTheme(R.style.TransparentThemeLight);
                break;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            View decorView = getWindow().getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (C3102bd.f18291a) {
                i = systemUiVisibility | 16;
            } else {
                i = systemUiVisibility & (-17);
            }
            decorView.setSystemUiVisibility(i);
        }
    }
}
