package ru.maximoff.apktool.service;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.p006pm.ActivityInfo;
import android.content.p006pm.PackageManager;
import android.graphics.BitmapFactory;
import android.media.AudioAttributes;
import android.net.Uri;
import android.p008os.Build;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.app.C0237h;
import com.srizwan.apktool.R;
import java.util.ArrayList;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;

/* loaded from: classes.dex */
public class ActivityDetectingService extends AccessibilityService {

    /* renamed from: c */
    private C3050a f17102c;

    /* renamed from: a */
    private final int f17100a = 777;

    /* renamed from: b */
    private final int f17101b = 100;

    /* renamed from: d */
    private boolean f17103d = true;

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f17102c = new C3050a(this, this);
        this.f17102c.m18151a((CharSequence) getString(R.string.accessibility_service_name), (CharSequence) getString(R.string.accessibility_service_description));
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f17103d = true;
        if (this.f17102c != null) {
            this.f17102c.m18154b();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            this.f17103d = true;
            if (this.f17102c != null) {
                this.f17102c.m18154b();
            }
            stopSelf();
            return super.onStartCommand(intent, i, i2);
        }
        String action = intent.getAction();
        if (action == null || action.equals("ru.maximoff.apktool.AccessibilityService.STOP")) {
            this.f17103d = true;
            if (this.f17102c != null) {
                this.f17102c.m18154b();
            }
            stopSelf();
            return super.onStartCommand(intent, i, i2);
        }
        this.f17103d = false;
        if (action.equals("ru.maximoff.apktool.AccessibilityService.START")) {
            if (this.f17102c != null) {
                return 1;
            }
            this.f17102c = new C3050a(this, this);
            this.f17102c.m18151a((CharSequence) getString(R.string.accessibility_service_name), (CharSequence) getString(R.string.accessibility_service_description));
            return 1;
        }
        if (action.equals("ru.maximoff.apktool.AccessibilityService.COPY")) {
            sendBroadcast(new Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS));
            if (this.f17102c == null || this.f17102c.m18155c() == null || this.f17102c.m18155c().equals("...")) {
                return 1;
            }
            C3112bn.m19002a(this, this.f17102c.m18155c());
            return 1;
        }
        if (!action.equals("ru.maximoff.apktool.AccessibilityService.RESET") || this.f17102c == null) {
            return 1;
        }
        this.f17102c.m18150a();
        return 1;
    }

    @Override // android.accessibilityservice.AccessibilityService
    protected void onServiceConnected() {
        super.onServiceConnected();
        AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
        accessibilityServiceInfo.eventTypes = 32;
        accessibilityServiceInfo.feedbackType = 16;
        if (Build.VERSION.SDK_INT >= 16) {
            accessibilityServiceInfo.flags = 2;
        }
        setServiceInfo(accessibilityServiceInfo);
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (this.f17103d) {
            if (this.f17102c != null) {
                this.f17102c.m18154b();
            }
            stopSelf();
        } else if (accessibilityEvent.getEventType() == 32 && accessibilityEvent.getPackageName() != null && accessibilityEvent.getClassName() != null) {
            ComponentName componentName = new ComponentName(accessibilityEvent.getPackageName().toString(), accessibilityEvent.getClassName().toString());
            if (this.f17102c == null) {
                this.f17102c = new C3050a(this, this);
                this.f17102c.m18151a((CharSequence) getString(R.string.accessibility_service_name), (CharSequence) getString(R.string.accessibility_service_description));
            }
            this.f17102c.m18152a(componentName.flattenToString());
            if (m18148a(componentName) != null) {
                this.f17102c.m18153b(getString(R.string.accessibility_service_name), componentName.flattenToShortString());
            } else {
                this.f17102c.m18153b(getString(R.string.accessibility_service_name), this.f17102c.m18155c());
            }
        }
    }

    /* renamed from: a */
    private ActivityInfo m18148a(ComponentName componentName) {
        try {
            return getPackageManager().getActivityInfo(componentName, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            return (ActivityInfo) null;
        }
    }

    /* renamed from: ru.maximoff.apktool.service.ActivityDetectingService$a */
    private class C3050a {

        /* renamed from: b */
        private NotificationManager f17105b;

        /* renamed from: c */
        private C0237h.c f17106c;

        /* renamed from: d */
        private final Context f17107d;

        /* renamed from: f */
        private String f17109f;

        /* renamed from: g */
        private final ActivityDetectingService f17110g;

        /* renamed from: e */
        private String f17108e = "current_activity";

        /* renamed from: a */
        private ArrayList<String> f17104a = new ArrayList<>();

        public C3050a(ActivityDetectingService activityDetectingService, Context context) {
            this.f17110g = activityDetectingService;
            this.f17107d = context;
            this.f17105b = (NotificationManager) this.f17107d.getSystemService("notification");
        }

        /* renamed from: a */
        public void m18152a(String str) {
            if (this.f17104a.isEmpty() || !this.f17104a.get(this.f17104a.size() - 1).equals(str)) {
                if (this.f17104a.size() < 100) {
                    this.f17104a.add(str);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                int i = 1;
                while (true) {
                    int i2 = i;
                    if (i2 < this.f17104a.size()) {
                        arrayList.add(this.f17104a.get(i2));
                        i = i2 + 1;
                    } else {
                        arrayList.add(str);
                        this.f17104a.clear();
                        this.f17104a.addAll(arrayList);
                        return;
                    }
                }
            }
        }

        /* renamed from: a */
        public void m18150a() {
            this.f17104a.clear();
        }

        /* renamed from: a */
        public void m18151a(CharSequence charSequence, CharSequence charSequence2) {
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel(this.f17108e, charSequence, 4);
                notificationChannel.setDescription(charSequence2.toString());
                notificationChannel.enableLights(false);
                notificationChannel.enableVibration(false);
                notificationChannel.setSound((Uri) null, (AudioAttributes) null);
                this.f17105b.createNotificationChannel(notificationChannel);
            }
        }

        /* renamed from: a */
        public Notification m18149a(String str, String str2) {
            int i;
            int i2;
            int i3;
            this.f17109f = str2;
            this.f17106c = new C0237h.c(this.f17107d, this.f17108e);
            this.f17106c.m1736a((CharSequence) str);
            this.f17106c.m1738a(true);
            this.f17106c.m1733a(System.currentTimeMillis());
            this.f17106c.m1741b(str2);
            this.f17106c.m1744d(true);
            this.f17106c.m1731a(R.drawable.ic_notification);
            this.f17106c.m1740b(1);
            if (C3102bd.m18925a(this.f17107d, "use_dark_icon", false)) {
                i = R.mipmap.ic_launcher_dark;
            } else {
                i = R.mipmap.ic_launcher;
            }
            if (C3080al.m18615q(this.f17107d)) {
                i2 = R.drawable.ic_close_dark;
                i3 = R.drawable.ic_copy_dark;
            } else {
                i2 = R.drawable.ic_close;
                i3 = R.drawable.ic_copy;
            }
            this.f17106c.m1735a(BitmapFactory.decodeResource(this.f17107d.getResources(), i));
            try {
                Intent intent = new Intent(this.f17107d, Class.forName("ru.maximoff.apktool.ActivityList"));
                intent.putStringArrayListExtra("activity_list", this.f17104a);
                this.f17106c.m1734a(PendingIntent.getActivity(this.f17107d, 777, intent, 134217728));
                try {
                    Intent intent2 = new Intent(this.f17107d, Class.forName("ru.maximoff.apktool.service.ActivityDetectingService"));
                    intent2.setAction("ru.maximoff.apktool.AccessibilityService.STOP");
                    this.f17106c.m1732a(i2, this.f17110g.getString(R.string.close_cur), PendingIntent.getService(this.f17107d, 778, intent2, 134217728));
                    try {
                        Intent intent3 = new Intent(this.f17107d, Class.forName("ru.maximoff.apktool.service.ActivityDetectingService"));
                        intent3.setAction("ru.maximoff.apktool.AccessibilityService.COPY");
                        this.f17106c.m1732a(i3, this.f17110g.getString(R.string.copy), PendingIntent.getService(this.f17107d, 779, intent3, 134217728));
                        Notification m1739b = this.f17106c.m1739b();
                        this.f17105b.notify(777, m1739b);
                        return m1739b;
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

        /* renamed from: b */
        public void m18154b() {
            this.f17105b.cancel(777);
        }

        /* renamed from: c */
        public String m18155c() {
            return this.f17109f;
        }

        /* renamed from: b */
        public Notification m18153b(String str, String str2) {
            if (this.f17106c != null) {
                this.f17109f = str2;
                this.f17106c.m1736a((CharSequence) str);
                this.f17106c.m1741b(str2);
                try {
                    Intent intent = new Intent(this.f17107d, Class.forName("ru.maximoff.apktool.ActivityList"));
                    intent.putStringArrayListExtra("activity_list", this.f17104a);
                    this.f17106c.m1734a(PendingIntent.getActivity(this.f17107d, 777, intent, 134217728));
                    Notification m1739b = this.f17106c.m1739b();
                    this.f17105b.notify(777, m1739b);
                    return m1739b;
                } catch (ClassNotFoundException e2) {
                    throw new NoClassDefFoundError(e2.getMessage());
                }
            }
            return m18149a(str, str2);
        }
    }
}
