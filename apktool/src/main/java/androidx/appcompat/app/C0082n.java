package androidx.appcompat.app;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.text.format.DateUtils;
import android.util.Log;
import androidx.core.content.C0264c;
import java.util.Calendar;

/* compiled from: TwilightManager.java */
/* renamed from: androidx.appcompat.app.n */
/* loaded from: classes.dex */
class C0082n {

    /* renamed from: a */
    private static C0082n f686a;

    /* renamed from: b */
    private final Context f687b;

    /* renamed from: c */
    private final LocationManager f688c;

    /* renamed from: d */
    private final a f689d = new a();

    /* renamed from: a */
    static C0082n m625a(Context context) {
        if (f686a == null) {
            Context applicationContext = context.getApplicationContext();
            f686a = new C0082n(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f686a;
    }

    C0082n(Context context, LocationManager locationManager) {
        this.f687b = context;
        this.f688c = locationManager;
    }

    /* renamed from: a */
    boolean m629a() {
        a aVar = this.f689d;
        if (m628c()) {
            return aVar.f690a;
        }
        Location m627b = m627b();
        if (m627b != null) {
            m626a(m627b);
            return aVar.f690a;
        }
        Log.m186i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: b */
    private Location m627b() {
        Location m624a = C0264c.m1938a(this.f687b, Manifest.permission.ACCESS_COARSE_LOCATION) == 0 ? m624a(LocationManager.NETWORK_PROVIDER) : null;
        Location m624a2 = C0264c.m1938a(this.f687b, Manifest.permission.ACCESS_FINE_LOCATION) == 0 ? m624a(LocationManager.GPS_PROVIDER) : null;
        if (m624a2 != null && m624a != null) {
            return m624a2.getTime() > m624a.getTime() ? m624a2 : m624a;
        }
        if (m624a2 == null) {
            m624a2 = m624a;
        }
        return m624a2;
    }

    /* renamed from: a */
    private Location m624a(String str) {
        try {
            if (this.f688c.isProviderEnabled(str)) {
                return this.f688c.getLastKnownLocation(str);
            }
        } catch (Exception e2) {
            Log.m183d("TwilightManager", "Failed to get last known location", e2);
        }
        return null;
    }

    /* renamed from: c */
    private boolean m628c() {
        return this.f689d.f695f > System.currentTimeMillis();
    }

    /* renamed from: a */
    private void m626a(Location location) {
        long j;
        long j2;
        a aVar = this.f689d;
        long currentTimeMillis = System.currentTimeMillis();
        C0081m m622a = C0081m.m622a();
        m622a.m623a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j3 = m622a.f683a;
        m622a.m623a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = m622a.f685c == 1;
        long j4 = m622a.f684b;
        long j5 = m622a.f683a;
        m622a.m623a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j6 = m622a.f684b;
        if (j4 == -1 || j5 == -1) {
            j = AlarmManager.INTERVAL_HALF_DAY + currentTimeMillis;
        } else {
            if (currentTimeMillis > j5) {
                j2 = 0 + j6;
            } else if (currentTimeMillis > j4) {
                j2 = 0 + j5;
            } else {
                j2 = 0 + j4;
            }
            j = j2 + DateUtils.MINUTE_IN_MILLIS;
        }
        aVar.f690a = z;
        aVar.f691b = j3;
        aVar.f692c = j4;
        aVar.f693d = j5;
        aVar.f694e = j6;
        aVar.f695f = j;
    }

    /* compiled from: TwilightManager.java */
    /* renamed from: androidx.appcompat.app.n$a */
    private static class a {

        /* renamed from: a */
        boolean f690a;

        /* renamed from: b */
        long f691b;

        /* renamed from: c */
        long f692c;

        /* renamed from: d */
        long f693d;

        /* renamed from: e */
        long f694e;

        /* renamed from: f */
        long f695f;

        a() {
        }
    }
}
