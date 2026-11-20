package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.C0225a;
import androidx.core.content.C0263b;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* compiled from: NotificationCompat.java */
/* renamed from: androidx.core.app.h */
/* loaded from: classes.dex */
public class C0237h {

    /* compiled from: NotificationCompat.java */
    /* renamed from: androidx.core.app.h$c */
    public static class c {

        /* renamed from: A */
        boolean f1878A;

        /* renamed from: B */
        boolean f1879B;

        /* renamed from: C */
        String f1880C;

        /* renamed from: D */
        Bundle f1881D;

        /* renamed from: E */
        int f1882E;

        /* renamed from: F */
        int f1883F;

        /* renamed from: G */
        Notification f1884G;

        /* renamed from: H */
        RemoteViews f1885H;

        /* renamed from: I */
        RemoteViews f1886I;

        /* renamed from: J */
        RemoteViews f1887J;

        /* renamed from: K */
        String f1888K;

        /* renamed from: L */
        int f1889L;

        /* renamed from: M */
        String f1890M;

        /* renamed from: N */
        C0263b f1891N;

        /* renamed from: O */
        long f1892O;

        /* renamed from: P */
        int f1893P;

        /* renamed from: Q */
        boolean f1894Q;

        /* renamed from: R */
        b f1895R;

        /* renamed from: S */
        Notification f1896S;

        /* renamed from: T */
        boolean f1897T;

        /* renamed from: U */
        Icon f1898U;

        /* renamed from: V */
        @Deprecated
        public ArrayList<String> f1899V;

        /* renamed from: a */
        public Context f1900a;

        /* renamed from: b */
        public ArrayList<a> f1901b;

        /* renamed from: c */
        public ArrayList<C0240k> f1902c;

        /* renamed from: d */
        ArrayList<a> f1903d;

        /* renamed from: e */
        CharSequence f1904e;

        /* renamed from: f */
        CharSequence f1905f;

        /* renamed from: g */
        PendingIntent f1906g;

        /* renamed from: h */
        PendingIntent f1907h;

        /* renamed from: i */
        RemoteViews f1908i;

        /* renamed from: j */
        Bitmap f1909j;

        /* renamed from: k */
        CharSequence f1910k;

        /* renamed from: l */
        int f1911l;

        /* renamed from: m */
        int f1912m;

        /* renamed from: n */
        boolean f1913n;

        /* renamed from: o */
        boolean f1914o;

        /* renamed from: p */
        d f1915p;

        /* renamed from: q */
        CharSequence f1916q;

        /* renamed from: r */
        CharSequence f1917r;

        /* renamed from: s */
        CharSequence[] f1918s;

        /* renamed from: t */
        int f1919t;

        /* renamed from: u */
        int f1920u;

        /* renamed from: v */
        boolean f1921v;

        /* renamed from: w */
        String f1922w;

        /* renamed from: x */
        boolean f1923x;

        /* renamed from: y */
        String f1924y;

        /* renamed from: z */
        boolean f1925z;

        public c(Context context, String str) {
            this.f1901b = new ArrayList<>();
            this.f1902c = new ArrayList<>();
            this.f1903d = new ArrayList<>();
            this.f1913n = true;
            this.f1925z = false;
            this.f1882E = 0;
            this.f1883F = 0;
            this.f1889L = 0;
            this.f1893P = 0;
            this.f1896S = new Notification();
            this.f1900a = context;
            this.f1888K = str;
            this.f1896S.when = System.currentTimeMillis();
            this.f1896S.audioStreamType = -1;
            this.f1912m = 0;
            this.f1899V = new ArrayList<>();
            this.f1894Q = true;
        }

        @Deprecated
        public c(Context context) {
            this(context, (String) null);
        }

        /* renamed from: a */
        public c m1733a(long j) {
            this.f1896S.when = j;
            return this;
        }

        /* renamed from: a */
        public c m1731a(int i) {
            this.f1896S.icon = i;
            return this;
        }

        /* renamed from: a */
        public c m1738a(boolean z) {
            this.f1897T = z;
            return this;
        }

        /* renamed from: a */
        public c m1736a(CharSequence charSequence) {
            this.f1904e = m1729c(charSequence);
            return this;
        }

        /* renamed from: b */
        public c m1741b(CharSequence charSequence) {
            this.f1905f = m1729c(charSequence);
            return this;
        }

        /* renamed from: a */
        public c m1734a(PendingIntent pendingIntent) {
            this.f1906g = pendingIntent;
            return this;
        }

        /* renamed from: a */
        public c m1735a(Bitmap bitmap) {
            this.f1909j = m1728b(bitmap);
            return this;
        }

        /* renamed from: b */
        private Bitmap m1728b(Bitmap bitmap) {
            if (bitmap != null && Build.VERSION.SDK_INT < 27) {
                Resources resources = this.f1900a.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(C0225a.b.compat_notification_large_icon_max_width);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(C0225a.b.compat_notification_large_icon_max_height);
                if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                    double min = Math.min(dimensionPixelSize / Math.max(1, bitmap.getWidth()), dimensionPixelSize2 / Math.max(1, bitmap.getHeight()));
                    return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * min), (int) Math.ceil(min * bitmap.getHeight()), true);
                }
                return bitmap;
            }
            return bitmap;
        }

        /* renamed from: b */
        public c m1742b(boolean z) {
            m1727a(2, z);
            return this;
        }

        /* renamed from: c */
        public c m1743c(boolean z) {
            m1727a(8, z);
            return this;
        }

        /* renamed from: d */
        public c m1744d(boolean z) {
            m1727a(16, z);
            return this;
        }

        /* renamed from: a */
        public c m1737a(String str) {
            this.f1880C = str;
            return this;
        }

        /* renamed from: a */
        private void m1727a(int i, boolean z) {
            if (z) {
                this.f1896S.flags |= i;
            } else {
                this.f1896S.flags &= i ^ (-1);
            }
        }

        /* renamed from: b */
        public c m1740b(int i) {
            this.f1912m = i;
            return this;
        }

        /* renamed from: a */
        public Bundle m1730a() {
            if (this.f1881D == null) {
                this.f1881D = new Bundle();
            }
            return this.f1881D;
        }

        /* renamed from: a */
        public c m1732a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f1901b.add(new a(i, charSequence, pendingIntent));
            return this;
        }

        /* renamed from: b */
        public Notification m1739b() {
            return new C0238i(this).m1755a();
        }

        /* renamed from: c */
        protected static CharSequence m1729c(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > 5120) {
                return charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* renamed from: androidx.core.app.h$d */
    public static abstract class d {

        /* renamed from: a */
        CharSequence f1926a;

        /* renamed from: b */
        CharSequence f1927b;

        /* renamed from: c */
        boolean f1928c;

        /* renamed from: a */
        protected String m1745a() {
            return null;
        }

        /* renamed from: a */
        public void m1747a(InterfaceC0236g interfaceC0236g) {
        }

        /* renamed from: b */
        public RemoteViews m1748b(InterfaceC0236g interfaceC0236g) {
            return null;
        }

        /* renamed from: c */
        public RemoteViews m1749c(InterfaceC0236g interfaceC0236g) {
            return null;
        }

        /* renamed from: d */
        public RemoteViews m1750d(InterfaceC0236g interfaceC0236g) {
            return null;
        }

        /* renamed from: a */
        public void m1746a(Bundle bundle) {
            if (this.f1928c) {
                bundle.putCharSequence(Notification.EXTRA_SUMMARY_TEXT, this.f1927b);
            }
            if (this.f1926a != null) {
                bundle.putCharSequence(Notification.EXTRA_TITLE_BIG, this.f1926a);
            }
            String m1745a = m1745a();
            if (m1745a != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", m1745a);
            }
        }
    }

    /* compiled from: NotificationCompat.java */
    /* renamed from: androidx.core.app.h$a */
    public static class a {

        /* renamed from: a */
        final Bundle f1860a;

        /* renamed from: b */
        boolean f1861b;

        /* renamed from: c */
        @Deprecated
        public int f1862c;

        /* renamed from: d */
        public CharSequence f1863d;

        /* renamed from: e */
        public PendingIntent f1864e;

        /* renamed from: f */
        private IconCompat f1865f;

        /* renamed from: g */
        private final C0241l[] f1866g;

        /* renamed from: h */
        private final C0241l[] f1867h;

        /* renamed from: i */
        private boolean f1868i;

        /* renamed from: j */
        private final int f1869j;

        /* renamed from: k */
        private final boolean f1870k;

        public a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i != 0 ? IconCompat.m2341a(null, "", i) : null, charSequence, pendingIntent);
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false);
        }

        a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, C0241l[] c0241lArr, C0241l[] c0241lArr2, boolean z, int i, boolean z2, boolean z3) {
            this.f1861b = true;
            this.f1865f = iconCompat;
            if (iconCompat != null && iconCompat.m2346a() == 2) {
                this.f1862c = iconCompat.m2351c();
            }
            this.f1863d = c.m1729c(charSequence);
            this.f1864e = pendingIntent;
            this.f1860a = bundle == null ? new Bundle() : bundle;
            this.f1866g = c0241lArr;
            this.f1867h = c0241lArr2;
            this.f1868i = z;
            this.f1869j = i;
            this.f1861b = z2;
            this.f1870k = z3;
        }

        /* renamed from: a */
        public IconCompat m1706a() {
            if (this.f1865f == null && this.f1862c != 0) {
                this.f1865f = IconCompat.m2341a(null, "", this.f1862c);
            }
            return this.f1865f;
        }

        /* renamed from: b */
        public CharSequence m1707b() {
            return this.f1863d;
        }

        /* renamed from: c */
        public PendingIntent m1708c() {
            return this.f1864e;
        }

        /* renamed from: d */
        public Bundle m1709d() {
            return this.f1860a;
        }

        /* renamed from: e */
        public boolean m1710e() {
            return this.f1868i;
        }

        /* renamed from: f */
        public C0241l[] m1711f() {
            return this.f1866g;
        }

        /* renamed from: g */
        public int m1712g() {
            return this.f1869j;
        }

        /* renamed from: h */
        public boolean m1713h() {
            return this.f1870k;
        }

        /* renamed from: i */
        public C0241l[] m1714i() {
            return this.f1867h;
        }

        /* renamed from: j */
        public boolean m1715j() {
            return this.f1861b;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* renamed from: androidx.core.app.h$b */
    public static final class b {

        /* renamed from: a */
        private PendingIntent f1871a;

        /* renamed from: b */
        private PendingIntent f1872b;

        /* renamed from: c */
        private IconCompat f1873c;

        /* renamed from: d */
        private int f1874d;

        /* renamed from: e */
        private int f1875e;

        /* renamed from: f */
        private int f1876f;

        /* renamed from: g */
        private String f1877g;

        @SuppressLint({"InvalidNullConversion"})
        /* renamed from: a */
        public PendingIntent m1717a() {
            return this.f1871a;
        }

        /* renamed from: b */
        public String m1718b() {
            return this.f1877g;
        }

        /* renamed from: c */
        public PendingIntent m1719c() {
            return this.f1872b;
        }

        @SuppressLint({"InvalidNullConversion"})
        /* renamed from: d */
        public IconCompat m1720d() {
            return this.f1873c;
        }

        /* renamed from: e */
        public int m1721e() {
            return this.f1874d;
        }

        /* renamed from: f */
        public int m1722f() {
            return this.f1875e;
        }

        /* renamed from: g */
        public boolean m1723g() {
            return (this.f1876f & 1) != 0;
        }

        /* renamed from: h */
        public boolean m1724h() {
            return (this.f1876f & 2) != 0;
        }

        /* renamed from: a */
        public static Notification.BubbleMetadata m1716a(b bVar) {
            if (bVar == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                return C3323b.m1726a(bVar);
            }
            if (Build.VERSION.SDK_INT == 29) {
                return a.m1725a(bVar);
            }
            return null;
        }

        /* compiled from: NotificationCompat.java */
        /* renamed from: androidx.core.app.h$b$a */
        private static class a {
            /* renamed from: a */
            static Notification.BubbleMetadata m1725a(b bVar) {
                if (bVar == null || bVar.m1717a() == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setIcon(bVar.m1720d().m2353e()).setIntent(bVar.m1717a()).setDeleteIntent(bVar.m1719c()).setAutoExpandBubble(bVar.m1723g()).setSuppressNotification(bVar.m1724h());
                if (bVar.m1721e() != 0) {
                    suppressNotification.setDesiredHeight(bVar.m1721e());
                }
                if (bVar.m1722f() != 0) {
                    suppressNotification.setDesiredHeightResId(bVar.m1722f());
                }
                return suppressNotification.build();
            }
        }

        /* compiled from: NotificationCompat.java */
        /* renamed from: androidx.core.app.h$b$b, reason: collision with other inner class name */
        private static class C3323b {
            /* renamed from: a */
            static Notification.BubbleMetadata m1726a(b bVar) {
                Notification.BubbleMetadata.Builder builder;
                if (bVar == null) {
                    return null;
                }
                if (bVar.m1718b() != null) {
                    builder = new Notification.BubbleMetadata.Builder(bVar.m1718b());
                } else {
                    builder = new Notification.BubbleMetadata.Builder(bVar.m1717a(), bVar.m1720d().m2353e());
                }
                builder.setDeleteIntent(bVar.m1719c()).setAutoExpandBubble(bVar.m1723g()).setSuppressNotification(bVar.m1724h());
                if (bVar.m1721e() != 0) {
                    builder.setDesiredHeight(bVar.m1721e());
                }
                if (bVar.m1722f() != 0) {
                    builder.setDesiredHeightResId(bVar.m1722f());
                }
                return builder.build();
            }
        }
    }

    /* renamed from: a */
    public static Bundle m1705a(Notification notification) {
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return C0239j.m1758a(notification);
        }
        return null;
    }
}
