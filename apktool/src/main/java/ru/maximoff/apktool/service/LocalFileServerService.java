package ru.maximoff.apktool.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.textclassifier.TextClassifier;
import androidx.core.app.C0237h;
import com.srizwan.apktool.R;
import java.io.File;
import ru.maximoff.apktool.p298c.C2896a;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;

/* loaded from: classes.dex */
public class LocalFileServerService extends Service {

    /* renamed from: a */
    public static final String f17111a = "ru.maximoff.apktool.action.START_WEBDAV";

    /* renamed from: b */
    public static final String f17112b = "ru.maximoff.apktool.action.STOP_WEBDAV";

    /* renamed from: c */
    public static final String f17113c = "ru.maximoff.apktool.action.COPY_URL";

    /* renamed from: e */
    private C2896a f17115e;

    /* renamed from: d */
    private final Handler f17114d = new Handler(Looper.getMainLooper());

    /* renamed from: f */
    private String f17116f = (String) null;

    /* renamed from: g */
    private String f17117g = (String) null;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        m18166b();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return 2;
        }
        String action = intent.getAction();
        if (f17113c.equals(action)) {
            C3112bn.m19002a(this, intent.getStringExtra(TextClassifier.TYPE_URL));
            return 2;
        }
        if (f17112b.equals(action)) {
            m18159a();
            return 2;
        }
        if (f17111a.equals(action)) {
            String stringExtra = intent.getStringExtra("ru.maximoff.apktool.extra.PATH");
            if (stringExtra == null || stringExtra.length() == 0) {
                stopSelf();
                return 2;
            }
            m18160a(stringExtra);
        }
        return 1;
    }

    /* renamed from: a */
    private void m18160a(String str) {
        if (this.f17115e != null && this.f17115e.m17003c()) {
            this.f17114d.post(new Runnable(this) { // from class: ru.maximoff.apktool.service.LocalFileServerService.1

                /* renamed from: a */
                private final LocalFileServerService f17118a;

                {
                    this.f17118a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C3112bn.m18999a(this.f17118a, R.string.server_already_running);
                    if (this.f17118a.f17116f == null || this.f17118a.f17117g == null) {
                        return;
                    }
                    this.f17118a.m18161a(this.f17118a.f17116f, this.f17118a.f17117g);
                }
            });
            return;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            stopSelf();
            return;
        }
        this.f17117g = str;
        startForeground(4217, m18164b(getString(R.string.server_starting), (String) null));
        this.f17115e = new C2896a(file, 8080);
        this.f17115e.m17000a(new StringBuffer().append(new StringBuffer().append(Build.MANUFACTURER).append(" ").toString()).append(Build.MODEL).toString());
        this.f17115e.m17001a(new C30522(this));
        this.f17115e.m16999a();
    }

    /* renamed from: ru.maximoff.apktool.service.LocalFileServerService$2 */
    class C30522 implements C2896a.c {

        /* renamed from: a */
        private final LocalFileServerService f17119a;

        C30522(LocalFileServerService localFileServerService) {
            this.f17119a = localFileServerService;
        }

        /* renamed from: a */
        static LocalFileServerService m18172a(C30522 c30522) {
            return c30522.f17119a;
        }

        @Override // ru.maximoff.apktool.p298c.C2896a.c
        /* renamed from: a */
        public void mo17008a(String str, int i) {
            this.f17119a.f17116f = str;
            this.f17119a.m18171c(this.f17119a.getString(R.string.server_running), str);
            this.f17119a.f17114d.post(new Runnable(this, str) { // from class: ru.maximoff.apktool.service.LocalFileServerService.2.1

                /* renamed from: a */
                private final C30522 f17120a;

                /* renamed from: b */
                private final String f17121b;

                {
                    this.f17120a = this;
                    this.f17121b = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C30522.m18172a(this.f17120a).m18161a(this.f17121b, C30522.m18172a(this.f17120a).f17117g);
                    C3112bn.m18999a(C30522.m18172a(this.f17120a), R.string.server_running);
                }
            });
        }

        @Override // ru.maximoff.apktool.p298c.C2896a.c
        /* renamed from: a */
        public void mo17006a() {
            this.f17119a.f17116f = (String) null;
            this.f17119a.f17117g = (String) null;
            this.f17119a.f17114d.post(new Runnable(this) { // from class: ru.maximoff.apktool.service.LocalFileServerService.2.2

                /* renamed from: a */
                private final C30522 f17122a;

                {
                    this.f17122a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C3112bn.m18999a(C30522.m18172a(this.f17122a), R.string.server_stopped);
                }
            });
        }

        @Override // ru.maximoff.apktool.p298c.C2896a.c
        /* renamed from: a */
        public void mo17007a(Exception exc) {
            this.f17119a.f17116f = (String) null;
            this.f17119a.f17117g = (String) null;
            this.f17119a.m18171c(this.f17119a.getString(R.string.error), exc.getMessage());
            this.f17119a.stopSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m18161a(String str, String str2) {
        Intent intent = new Intent("ru.maximoff.apktool.WEBDAV_STARTED");
        intent.setPackage(getPackageName());
        intent.putExtra(TextClassifier.TYPE_URL, str);
        intent.putExtra("path", str2);
        sendBroadcast(intent);
    }

    /* renamed from: a */
    private void m18159a() {
        if (this.f17115e != null) {
            this.f17115e.m17002b();
            this.f17115e = (C2896a) null;
        }
        this.f17116f = (String) null;
        this.f17117g = (String) null;
        stopForeground(true);
        stopSelf();
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.f17115e != null) {
            this.f17115e.m17002b();
            this.f17115e = (C2896a) null;
        }
        this.f17116f = (String) null;
        this.f17117g = (String) null;
        stopForeground(true);
        super.onDestroy();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return (IBinder) null;
    }

    /* renamed from: b */
    private Notification m18164b(String str, String str2) {
        C0237h.c cVar;
        int i;
        int i2;
        int i3;
        try {
            PendingIntent activity = PendingIntent.getActivity(this, 1, new Intent(this, Class.forName("ru.maximoff.apktool.MainActivity")), m18169c());
            try {
                Intent intent = new Intent(this, Class.forName("ru.maximoff.apktool.service.LocalFileServerService"));
                intent.setAction(f17112b);
                PendingIntent service = PendingIntent.getService(this, 2, intent, m18169c());
                try {
                    Intent intent2 = new Intent(this, Class.forName("ru.maximoff.apktool.service.LocalFileServerService"));
                    intent2.setAction(f17113c);
                    intent2.putExtra(TextClassifier.TYPE_URL, this.f17116f);
                    PendingIntent service2 = PendingIntent.getService(this, 3, intent2, m18169c());
                    if (Build.VERSION.SDK_INT >= 26) {
                        cVar = new C0237h.c(this, "local_file_server");
                    } else {
                        cVar = new C0237h.c(this);
                    }
                    if (C3102bd.m18925a((Context) this, "use_dark_icon", false)) {
                        i = R.mipmap.ic_launcher_dark;
                    } else {
                        i = R.mipmap.ic_launcher;
                    }
                    if (C3080al.m18615q(this)) {
                        i2 = R.drawable.ic_close_dark;
                        i3 = R.drawable.ic_copy_dark;
                    } else {
                        i2 = R.drawable.ic_close;
                        i3 = R.drawable.ic_copy;
                    }
                    cVar.m1731a(R.drawable.ic_notification).m1735a(BitmapFactory.decodeResource(getResources(), i)).m1736a((CharSequence) str).m1741b(str2).m1734a(activity).m1742b(true).m1744d(false).m1743c(true).m1733a(System.currentTimeMillis()).m1732a(i2, getString(R.string.stop), service).m1732a(i3, getString(R.string.copy), service2);
                    return cVar.m1739b();
                } catch (ClassNotFoundException e2) {
                    throw new NoClassDefFoundError(e2.getMessage());
                }
            } catch (ClassNotFoundException e3) {
                throw new NoClassDefFoundError(e3.getMessage());
            }
        } catch (ClassNotFoundException e4) {
            throw new NoClassDefFoundError(e4.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m18171c(String str, String str2) {
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.notify(4217, m18164b(str, str2));
        }
    }

    /* renamed from: b */
    private void m18166b() {
        NotificationManager notificationManager;
        if (Build.VERSION.SDK_INT >= 26 && (notificationManager = (NotificationManager) getSystemService("notification")) != null) {
            NotificationChannel notificationChannel = new NotificationChannel("local_file_server", getString(R.string.local_server), 2);
            notificationChannel.setDescription(getString(R.string.server_label));
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    /* renamed from: c */
    private int m18169c() {
        return Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728;
    }
}
