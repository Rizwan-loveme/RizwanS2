package ru.maximoff.apktool;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import androidx.appcompat.app.ActivityC0071c;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3100bb;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.view.C3310l;

/* loaded from: classes.dex */
public class ColorPipette extends ActivityC0071c {

    /* renamed from: h */
    private C3310l f13769h;

    /* renamed from: i */
    private C3100bb f13770i;

    /* renamed from: j */
    private boolean f13771j;

    @Override // androidx.fragment.app.ActivityC0375f, androidx.activity.ActivityC0048b, androidx.core.app.ActivityC0234e, android.app.Activity
    protected void onCreate(Bundle bundle) {
        m16447q();
        super.onCreate(bundle);
        getWindow().setDimAmount(0.0f);
        getWindow().getDecorView().setAlpha(0.0f);
        if (Build.VERSION.SDK_INT < 21) {
            C3112bn.m18999a(this, R.string.error);
            finish();
            return;
        }
        if (!C3080al.m18607j(this)) {
            m16446p();
            return;
        }
        if (C3310l.m19944a()) {
            finish();
        } else {
            if (C3102bd.m18925a((Context) this, "show_pipette_info", true)) {
                DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this).m418a(R.string.minfo).m433b(R.string.pipette_info).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.ColorPipette.1

                    /* renamed from: a */
                    private final ColorPipette f13772a;

                    {
                        this.f13772a = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).m440c(R.string.not_remind, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.ColorPipette.2

                    /* renamed from: a */
                    private final ColorPipette f13773a;

                    {
                        this.f13773a = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C3102bd.m18938b((Context) this.f13773a, "show_pipette_info", false);
                        dialogInterface.cancel();
                    }
                }).m438b();
                m438b.setOnCancelListener(new DialogInterface.OnCancelListener(this) { // from class: ru.maximoff.apktool.ColorPipette.3

                    /* renamed from: a */
                    private final ColorPipette f13774a;

                    {
                        this.f13774a = this;
                    }

                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        this.f13774a.m16445o();
                    }
                });
                m438b.show();
                return;
            }
            m16445o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m16445o() {
        Intent createScreenCaptureIntent;
        MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) getSystemService(Context.MEDIA_PROJECTION_SERVICE);
        this.f13771j = true;
        if (Build.VERSION.SDK_INT >= 34) {
            try {
                Class<?> cls = Class.forName("android.media.projection.MediaProjectionConfig");
                try {
                    createScreenCaptureIntent = (Intent) Class.forName("android.media.projection.MediaProjectionManager").getMethod("createScreenCaptureIntent", cls).invoke(mediaProjectionManager, cls.getMethod("createConfigForDefaultDisplay", new Class[0]).invoke((Object) null, new Object[0]));
                } catch (ClassNotFoundException e2) {
                    throw new NoClassDefFoundError(e2.getMessage());
                }
            } catch (Throwable th) {
                createScreenCaptureIntent = mediaProjectionManager.createScreenCaptureIntent();
            }
        } else {
            createScreenCaptureIntent = mediaProjectionManager.createScreenCaptureIntent();
        }
        startActivityForResult(createScreenCaptureIntent, 1001);
    }

    /* renamed from: p */
    private void m16446p() {
        new DialogInterfaceC0070b.a(this).m418a(R.string.attention).m433b(R.string.permission_needle).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.ColorPipette.4

            /* renamed from: a */
            private final ColorPipette f13775a;

            {
                this.f13775a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                this.f13775a.startActivity(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse(new StringBuffer().append("package:").append(this.f13775a.getPackageName()).toString())));
                this.f13775a.finish();
            }
        }).m434b(R.string.cancel, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.ColorPipette.5

            /* renamed from: a */
            private final ColorPipette f13776a;

            {
                this.f13776a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                this.f13776a.finish();
            }
        }).m429a(false).m438b().show();
    }

    /* renamed from: a */
    private void m16443a(MediaProjection mediaProjection) {
        this.f13770i = new C3100bb(this, mediaProjection);
        this.f13769h = C3310l.m19941a(this);
        this.f13769h.m19981a(new C3310l.c(this) { // from class: ru.maximoff.apktool.ColorPipette.6

            /* renamed from: a */
            private final ColorPipette f13777a;

            {
                this.f13777a = this;
            }

            @Override // ru.maximoff.apktool.view.C3310l.c
            /* renamed from: a */
            public void mo16448a() {
                this.f13777a.finish();
            }
        });
        this.f13769h.m19980a(this.f13770i);
        this.f13769h.m19982b();
        this.f13770i.m18893a(new C3100bb.a(this) { // from class: ru.maximoff.apktool.ColorPipette.7

            /* renamed from: a */
            private final ColorPipette f13778a;

            {
                this.f13778a = this;
            }

            @Override // ru.maximoff.apktool.util.C3100bb.a
            /* renamed from: a */
            public void mo16449a(Bitmap bitmap, int[] iArr) {
                this.f13778a.f13769h.m19979a(bitmap, iArr);
            }
        });
        this.f13770i.m18892a();
    }

    @Override // androidx.fragment.app.ActivityC0375f, androidx.activity.ActivityC0048b, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1001 || i2 != -1) {
            C3112bn.m18999a(this, R.string.error_try_again);
            finish();
        } else {
            m16443a(((MediaProjectionManager) getSystemService(Context.MEDIA_PROJECTION_SERVICE)).getMediaProjection(i2, intent));
        }
    }

    @Override // androidx.fragment.app.ActivityC0375f, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // androidx.activity.ActivityC0048b, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    /* renamed from: q */
    private void m16447q() {
        int i;
        switch (C3102bd.f18319b) {
            case 0:
                setTheme(R.style.TransparentThemeLight);
                break;
            case 1:
                setTheme(R.style.TransparentTheme);
                break;
            case 2:
                setTheme(R.style.TransparentThemeBlack);
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
