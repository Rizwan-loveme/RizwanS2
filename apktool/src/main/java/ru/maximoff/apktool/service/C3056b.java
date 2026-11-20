package ru.maximoff.apktool.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import androidx.core.app.C0237h;
import com.srizwan.apktool.R;
import ru.maximoff.apktool.util.C3102bd;

/* compiled from: NotificationManager.java */
/* renamed from: ru.maximoff.apktool.service.b */
/* loaded from: classes.dex */
public class C3056b {

    /* renamed from: a */
    private NotificationManager f17136a;

    /* renamed from: b */
    private C0237h.c f17137b;

    /* renamed from: c */
    private Context f17138c;

    /* renamed from: g */
    private Uri f17142g;

    /* renamed from: h */
    private Class<?> f17143h;

    /* renamed from: i */
    private boolean f17144i;

    /* renamed from: j */
    private boolean f17145j;

    /* renamed from: l */
    private Runnable f17147l;

    /* renamed from: m */
    private String f17148m;

    /* renamed from: n */
    private String f17149n;

    /* renamed from: k */
    private Handler f17146k = new Handler();

    /* renamed from: o */
    private long f17150o = 0;

    /* renamed from: d */
    private boolean f17139d = true;

    /* renamed from: e */
    private String f17140e = "Z";

    /* renamed from: f */
    private int f17141f = 111;

    public C3056b(Context context) {
        this.f17138c = context;
        this.f17136a = (NotificationManager) this.f17138c.getSystemService("notification");
        try {
            this.f17143h = Class.forName("ru.maximoff.apktool.MainActivity");
            this.f17144i = false;
            this.f17145j = false;
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    /* renamed from: a */
    public void m18196a(Class<?> cls) {
        this.f17143h = cls;
    }

    /* renamed from: a */
    public void m18194a(int i) {
        this.f17141f = i;
    }

    /* renamed from: a */
    public void m18197a(String str) {
        this.f17140e = str;
    }

    /* renamed from: a */
    public void m18198a(boolean z) {
        this.f17144i = z;
    }

    /* renamed from: b */
    public void m18201b(boolean z) {
        this.f17139d = z;
    }

    /* renamed from: c */
    public void m18202c(boolean z) {
        this.f17145j = z;
    }

    /* renamed from: a */
    public void m18195a(CharSequence charSequence, CharSequence charSequence2) {
        try {
            this.f17142g = Uri.parse(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("android.resource://").append(this.f17138c.getPackageName()).toString()).append("/").toString()).append(this.f17144i ? R.raw.error : R.raw.done).toString());
        } catch (Exception e2) {
            this.f17142g = RingtoneManager.getDefaultUri(2);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(this.f17140e, charSequence, 3);
            notificationChannel.setDescription(charSequence2.toString());
            if (!this.f17139d) {
                notificationChannel.enableLights(true);
                notificationChannel.enableVibration(true);
                notificationChannel.setLightColor(this.f17144i ? Color.RED : -16776961);
                if (this.f17142g != null) {
                    notificationChannel.setSound(this.f17142g, new AudioAttributes.Builder().setUsage(5).build());
                }
            } else {
                notificationChannel.enableLights(false);
                notificationChannel.enableVibration(false);
                notificationChannel.setSound((Uri) null, (AudioAttributes) null);
            }
            this.f17136a.createNotificationChannel(notificationChannel);
        }
    }

    /* renamed from: a */
    public Notification m18192a(String str, String str2) {
        int i;
        this.f17137b = new C0237h.c(this.f17138c, this.f17140e);
        this.f17137b.m1736a((CharSequence) str);
        this.f17137b.m1738a(this.f17139d);
        this.f17137b.m1733a(System.currentTimeMillis());
        this.f17137b.m1741b(str2);
        this.f17137b.m1744d(!this.f17145j);
        this.f17137b.m1742b(this.f17145j);
        if (this.f17145j) {
            this.f17137b.m1737a(Notification.CATEGORY_SERVICE);
        } else {
            this.f17137b.m1737a(Notification.CATEGORY_EVENT);
        }
        this.f17137b.m1731a(R.drawable.ic_notification);
        this.f17137b.m1740b(0);
        if (C3102bd.m18925a(this.f17138c, "use_dark_icon", false)) {
            i = R.mipmap.ic_launcher_dark;
        } else {
            i = R.mipmap.ic_launcher;
        }
        this.f17137b.m1735a(BitmapFactory.decodeResource(this.f17138c.getResources(), i));
        Intent intent = new Intent(this.f17138c, this.f17143h);
        intent.putExtra("from_ongoing", this.f17141f);
        this.f17137b.m1734a(PendingIntent.getActivity(this.f17138c, this.f17141f, intent, 134217728));
        Notification m1739b = this.f17137b.m1739b();
        if (!this.f17139d) {
            m1739b.ledARGB = this.f17144i ? Color.RED : -16776961;
            m1739b.ledOffMS = 0;
            m1739b.ledOnMS = 1;
            if (this.f17142g != null) {
                m1739b.sound = this.f17142g;
                m1739b.defaults = 2;
            } else {
                m1739b.defaults = 3;
            }
        }
        m1739b.flags |= 1;
        if (this.f17145j) {
            m1739b.flags &= -17;
        } else {
            m1739b.flags |= 16;
        }
        this.f17136a.notify(this.f17141f, m1739b);
        return m1739b;
    }

    /* renamed from: a */
    public void m18193a() {
        this.f17146k.removeCallbacksAndMessages((Object) null);
        this.f17136a.cancel(this.f17141f);
    }

    /* renamed from: b */
    public void m18200b(int i) {
        this.f17146k.removeCallbacksAndMessages((Object) null);
        this.f17136a.cancel(i);
    }

    /* renamed from: b */
    public Notification m18199b(String str, String str2) {
        this.f17148m = str;
        this.f17149n = str2;
        long max = Math.max(0, 500 - (System.currentTimeMillis() - this.f17150o));
        this.f17146k.removeCallbacksAndMessages((Object) null);
        this.f17147l = new Runnable(this) { // from class: ru.maximoff.apktool.service.b.1

            /* renamed from: a */
            private final C3056b f17151a;

            {
                this.f17151a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f17151a.f17137b != null) {
                    this.f17151a.f17137b.m1736a((CharSequence) this.f17151a.f17148m);
                    this.f17151a.f17137b.m1741b(this.f17151a.f17149n);
                    this.f17151a.f17136a.notify(this.f17151a.f17141f, this.f17151a.f17137b.m1739b());
                } else {
                    this.f17151a.m18192a(this.f17151a.f17148m, this.f17151a.f17149n);
                }
                this.f17151a.f17150o = System.currentTimeMillis();
            }
        };
        this.f17146k.postDelayed(this.f17147l, max);
        return (Notification) null;
    }
}
