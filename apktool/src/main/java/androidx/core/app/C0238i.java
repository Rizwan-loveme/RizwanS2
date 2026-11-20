package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.p008os.Build;
import android.p008os.Bundle;
import android.provider.AlarmClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.C0237h;
import androidx.core.graphics.drawable.IconCompat;
import androidx.p011a.C0037b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: NotificationCompatBuilder.java */
/* renamed from: androidx.core.app.i */
/* loaded from: classes.dex */
class C0238i implements InterfaceC0236g {

    /* renamed from: a */
    private final Context f1929a;

    /* renamed from: b */
    private final Notification.Builder f1930b;

    /* renamed from: c */
    private final C0237h.c f1931c;

    /* renamed from: d */
    private RemoteViews f1932d;

    /* renamed from: e */
    private RemoteViews f1933e;

    /* renamed from: f */
    private final List<Bundle> f1934f = new ArrayList();

    /* renamed from: g */
    private final Bundle f1935g = new Bundle();

    /* renamed from: h */
    private int f1936h;

    /* renamed from: i */
    private RemoteViews f1937i;

    C0238i(C0237h.c cVar) {
        List list;
        List<String> m1752a;
        this.f1931c = cVar;
        this.f1929a = cVar.f1900a;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1930b = new Notification.Builder(cVar.f1900a, cVar.f1888K);
        } else {
            this.f1930b = new Notification.Builder(cVar.f1900a);
        }
        Notification notification = cVar.f1896S;
        this.f1930b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, cVar.f1908i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(cVar.f1904e).setContentText(cVar.f1905f).setContentInfo(cVar.f1910k).setContentIntent(cVar.f1906g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(cVar.f1907h, (notification.flags & 128) != 0).setLargeIcon(cVar.f1909j).setNumber(cVar.f1911l).setProgress(cVar.f1919t, cVar.f1920u, cVar.f1921v);
        if (Build.VERSION.SDK_INT < 21) {
            this.f1930b.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1930b.setSubText(cVar.f1916q).setUsesChronometer(cVar.f1914o).setPriority(cVar.f1912m);
            Iterator<C0237h.a> it = cVar.f1901b.iterator();
            while (it.hasNext()) {
                m1754a(it.next());
            }
            if (cVar.f1881D != null) {
                this.f1935g.putAll(cVar.f1881D);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (cVar.f1925z) {
                    this.f1935g.putBoolean("android.support.localOnly", true);
                }
                if (cVar.f1922w != null) {
                    this.f1935g.putString("android.support.groupKey", cVar.f1922w);
                    if (cVar.f1923x) {
                        this.f1935g.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f1935g.putBoolean("android.support.useSideChannel", true);
                    }
                }
                if (cVar.f1924y != null) {
                    this.f1935g.putString("android.support.sortKey", cVar.f1924y);
                }
            }
            this.f1932d = cVar.f1885H;
            this.f1933e = cVar.f1886I;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.f1930b.setShowWhen(cVar.f1913n);
        }
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21 && (m1752a = m1752a(m1751a(cVar.f1902c), cVar.f1899V)) != null && !m1752a.isEmpty()) {
            this.f1935g.putStringArray(Notification.EXTRA_PEOPLE, (String[]) m1752a.toArray(new String[m1752a.size()]));
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f1930b.setLocalOnly(cVar.f1925z).setGroup(cVar.f1922w).setGroupSummary(cVar.f1923x).setSortKey(cVar.f1924y);
            this.f1936h = cVar.f1893P;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1930b.setCategory(cVar.f1880C).setColor(cVar.f1882E).setVisibility(cVar.f1883F).setPublicVersion(cVar.f1884G).setSound(notification.sound, notification.audioAttributes);
            if (Build.VERSION.SDK_INT < 28) {
                list = m1752a(m1751a(cVar.f1902c), cVar.f1899V);
            } else {
                list = cVar.f1899V;
            }
            if (list != null && !list.isEmpty()) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    this.f1930b.addPerson((String) it2.next());
                }
            }
            this.f1937i = cVar.f1887J;
            if (cVar.f1903d.size() > 0) {
                Bundle bundle = cVar.m1730a().getBundle("android.car.EXTENSIONS");
                Bundle bundle2 = bundle == null ? new Bundle() : bundle;
                Bundle bundle3 = new Bundle(bundle2);
                Bundle bundle4 = new Bundle();
                for (int i = 0; i < cVar.f1903d.size(); i++) {
                    bundle4.putBundle(Integer.toString(i), C0239j.m1759a(cVar.f1903d.get(i)));
                }
                bundle2.putBundle("invisible_actions", bundle4);
                bundle3.putBundle("invisible_actions", bundle4);
                cVar.m1730a().putBundle("android.car.EXTENSIONS", bundle2);
                this.f1935g.putBundle("android.car.EXTENSIONS", bundle3);
            }
        }
        if (Build.VERSION.SDK_INT >= 23 && cVar.f1898U != null) {
            this.f1930b.setSmallIcon(cVar.f1898U);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f1930b.setExtras(cVar.f1881D).setRemoteInputHistory(cVar.f1918s);
            if (cVar.f1885H != null) {
                this.f1930b.setCustomContentView(cVar.f1885H);
            }
            if (cVar.f1886I != null) {
                this.f1930b.setCustomBigContentView(cVar.f1886I);
            }
            if (cVar.f1887J != null) {
                this.f1930b.setCustomHeadsUpContentView(cVar.f1887J);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1930b.setBadgeIconType(cVar.f1889L).setSettingsText(cVar.f1917r).setShortcutId(cVar.f1890M).setTimeoutAfter(cVar.f1892O).setGroupAlertBehavior(cVar.f1893P);
            if (cVar.f1879B) {
                this.f1930b.setColorized(cVar.f1878A);
            }
            if (!TextUtils.isEmpty(cVar.f1888K)) {
                this.f1930b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Iterator<C0240k> it3 = cVar.f1902c.iterator();
            while (it3.hasNext()) {
                this.f1930b.addPerson(it3.next().m1763a());
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1930b.setAllowSystemGeneratedContextualActions(cVar.f1894Q);
            this.f1930b.setBubbleMetadata(C0237h.b.m1716a(cVar.f1895R));
            if (cVar.f1891N != null) {
                this.f1930b.setLocusId(cVar.f1891N.m1937a());
            }
        }
        if (cVar.f1897T) {
            if (this.f1931c.f1923x) {
                this.f1936h = 2;
            } else {
                this.f1936h = 1;
            }
            this.f1930b.setVibrate(null);
            this.f1930b.setSound(null);
            notification.defaults &= -2;
            notification.defaults &= -3;
            this.f1930b.setDefaults(notification.defaults);
            if (Build.VERSION.SDK_INT >= 26) {
                if (TextUtils.isEmpty(this.f1931c.f1922w)) {
                    this.f1930b.setGroup(AlarmClock.VALUE_RINGTONE_SILENT);
                }
                this.f1930b.setGroupAlertBehavior(this.f1936h);
            }
        }
    }

    /* renamed from: a */
    private static List<String> m1752a(List<String> list, List<String> list2) {
        if (list != null) {
            if (list2 == null) {
                return list;
            }
            C0037b c0037b = new C0037b(list.size() + list2.size());
            c0037b.addAll(list);
            c0037b.addAll(list2);
            return new ArrayList(c0037b);
        }
        return list2;
    }

    /* renamed from: a */
    private static List<String> m1751a(List<C0240k> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<C0240k> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m1770h());
        }
        return arrayList;
    }

    /* renamed from: a */
    public Notification m1755a() {
        RemoteViews remoteViews;
        Bundle m1705a;
        RemoteViews m1750d;
        RemoteViews m1749c;
        C0237h.d dVar = this.f1931c.f1915p;
        if (dVar != null) {
            dVar.m1747a(this);
        }
        if (dVar != null) {
            remoteViews = dVar.m1748b(this);
        } else {
            remoteViews = null;
        }
        Notification m1756b = m1756b();
        if (remoteViews != null) {
            m1756b.contentView = remoteViews;
        } else if (this.f1931c.f1885H != null) {
            m1756b.contentView = this.f1931c.f1885H;
        }
        if (Build.VERSION.SDK_INT >= 16 && dVar != null && (m1749c = dVar.m1749c(this)) != null) {
            m1756b.bigContentView = m1749c;
        }
        if (Build.VERSION.SDK_INT >= 21 && dVar != null && (m1750d = this.f1931c.f1915p.m1750d(this)) != null) {
            m1756b.headsUpContentView = m1750d;
        }
        if (Build.VERSION.SDK_INT >= 16 && dVar != null && (m1705a = C0237h.m1705a(m1756b)) != null) {
            dVar.m1746a(m1705a);
        }
        return m1756b;
    }

    /* renamed from: a */
    private void m1754a(C0237h.a aVar) {
        Notification.Action.Builder builder;
        Bundle bundle;
        if (Build.VERSION.SDK_INT >= 20) {
            IconCompat m1706a = aVar.m1706a();
            if (Build.VERSION.SDK_INT >= 23) {
                builder = new Notification.Action.Builder(m1706a != null ? m1706a.m2353e() : null, aVar.m1707b(), aVar.m1708c());
            } else {
                builder = new Notification.Action.Builder(m1706a != null ? m1706a.m2351c() : 0, aVar.m1707b(), aVar.m1708c());
            }
            if (aVar.m1711f() != null) {
                for (RemoteInput remoteInput : C0241l.m1772a(aVar.m1711f())) {
                    builder.addRemoteInput(remoteInput);
                }
            }
            if (aVar.m1709d() != null) {
                bundle = new Bundle(aVar.m1709d());
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.m1710e());
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(aVar.m1710e());
            }
            bundle.putInt("android.support.action.semanticAction", aVar.m1712g());
            if (Build.VERSION.SDK_INT >= 28) {
                builder.setSemanticAction(aVar.m1712g());
            }
            if (Build.VERSION.SDK_INT >= 29) {
                builder.setContextual(aVar.m1713h());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", aVar.m1715j());
            builder.addExtras(bundle);
            this.f1930b.addAction(builder.build());
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1934f.add(C0239j.m1757a(this.f1930b, aVar));
        }
    }

    /* renamed from: b */
    protected Notification m1756b() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f1930b.build();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Notification build = this.f1930b.build();
            if (this.f1936h != 0) {
                if (build.getGroup() != null && (build.flags & 512) != 0 && this.f1936h == 2) {
                    m1753a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f1936h == 1) {
                    m1753a(build);
                    return build;
                }
                return build;
            }
            return build;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1930b.setExtras(this.f1935g);
            Notification build2 = this.f1930b.build();
            if (this.f1932d != null) {
                build2.contentView = this.f1932d;
            }
            if (this.f1933e != null) {
                build2.bigContentView = this.f1933e;
            }
            if (this.f1937i != null) {
                build2.headsUpContentView = this.f1937i;
            }
            if (this.f1936h != 0) {
                if (build2.getGroup() != null && (build2.flags & 512) != 0 && this.f1936h == 2) {
                    m1753a(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.f1936h == 1) {
                    m1753a(build2);
                    return build2;
                }
                return build2;
            }
            return build2;
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f1930b.setExtras(this.f1935g);
            Notification build3 = this.f1930b.build();
            if (this.f1932d != null) {
                build3.contentView = this.f1932d;
            }
            if (this.f1933e != null) {
                build3.bigContentView = this.f1933e;
            }
            if (this.f1936h != 0) {
                if (build3.getGroup() != null && (build3.flags & 512) != 0 && this.f1936h == 2) {
                    m1753a(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.f1936h == 1) {
                    m1753a(build3);
                    return build3;
                }
                return build3;
            }
            return build3;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            SparseArray<Bundle> m1761a = C0239j.m1761a(this.f1934f);
            if (m1761a != null) {
                this.f1935g.putSparseParcelableArray("android.support.actionExtras", m1761a);
            }
            this.f1930b.setExtras(this.f1935g);
            Notification build4 = this.f1930b.build();
            if (this.f1932d != null) {
                build4.contentView = this.f1932d;
            }
            if (this.f1933e != null) {
                build4.bigContentView = this.f1933e;
                return build4;
            }
            return build4;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            Notification build5 = this.f1930b.build();
            Bundle m1705a = C0237h.m1705a(build5);
            Bundle bundle = new Bundle(this.f1935g);
            for (String str : this.f1935g.keySet()) {
                if (m1705a.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            m1705a.putAll(bundle);
            SparseArray<Bundle> m1761a2 = C0239j.m1761a(this.f1934f);
            if (m1761a2 != null) {
                C0237h.m1705a(build5).putSparseParcelableArray("android.support.actionExtras", m1761a2);
            }
            if (this.f1932d != null) {
                build5.contentView = this.f1932d;
            }
            if (this.f1933e != null) {
                build5.bigContentView = this.f1933e;
            }
            return build5;
        }
        return this.f1930b.getNotification();
    }

    /* renamed from: a */
    private void m1753a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
