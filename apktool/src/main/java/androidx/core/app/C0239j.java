package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.C0237h;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: NotificationCompatJellybean.java */
/* renamed from: androidx.core.app.j */
/* loaded from: classes.dex */
class C0239j {

    /* renamed from: b */
    private static Field f1939b;

    /* renamed from: c */
    private static boolean f1940c;

    /* renamed from: a */
    private static final Object f1938a = new Object();

    /* renamed from: d */
    private static final Object f1941d = new Object();

    /* renamed from: a */
    public static SparseArray<Bundle> m1761a(List<Bundle> list) {
        SparseArray<Bundle> sparseArray = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    /* renamed from: a */
    public static Bundle m1758a(Notification notification) {
        synchronized (f1938a) {
            if (f1940c) {
                return null;
            }
            try {
                if (f1939b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.m184e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f1940c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f1939b = declaredField;
                }
                Bundle bundle = (Bundle) f1939b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f1939b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e2) {
                Log.m185e("NotificationCompat", "Unable to access notification extras", e2);
                f1940c = true;
                return null;
            } catch (NoSuchFieldException e3) {
                Log.m185e("NotificationCompat", "Unable to access notification extras", e3);
                f1940c = true;
                return null;
            }
        }
    }

    /* renamed from: a */
    public static Bundle m1757a(Notification.Builder builder, C0237h.a aVar) {
        IconCompat m1706a = aVar.m1706a();
        builder.addAction(m1706a != null ? m1706a.m2351c() : 0, aVar.m1707b(), aVar.m1708c());
        Bundle bundle = new Bundle(aVar.m1709d());
        if (aVar.m1711f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", m1762a(aVar.m1711f()));
        }
        if (aVar.m1714i() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", m1762a(aVar.m1714i()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.m1710e());
        return bundle;
    }

    /* renamed from: a */
    static Bundle m1759a(C0237h.a aVar) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat m1706a = aVar.m1706a();
        bundle2.putInt("icon", m1706a != null ? m1706a.m2351c() : 0);
        bundle2.putCharSequence("title", aVar.m1707b());
        bundle2.putParcelable("actionIntent", aVar.m1708c());
        if (aVar.m1709d() != null) {
            bundle = new Bundle(aVar.m1709d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.m1710e());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", m1762a(aVar.m1711f()));
        bundle2.putBoolean("showsUserInterface", aVar.m1715j());
        bundle2.putInt("semanticAction", aVar.m1712g());
        return bundle2;
    }

    /* renamed from: a */
    private static Bundle m1760a(C0241l c0241l) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", c0241l.m1773a());
        bundle.putCharSequence("label", c0241l.m1774b());
        bundle.putCharSequenceArray("choices", c0241l.m1775c());
        bundle.putBoolean("allowFreeFormInput", c0241l.m1777e());
        bundle.putBundle("extras", c0241l.m1779g());
        Set<String> m1776d = c0241l.m1776d();
        if (m1776d != null && !m1776d.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(m1776d.size());
            Iterator<String> it = m1776d.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    /* renamed from: a */
    private static Bundle[] m1762a(C0241l[] c0241lArr) {
        if (c0241lArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[c0241lArr.length];
        for (int i = 0; i < c0241lArr.length; i++) {
            bundleArr[i] = m1760a(c0241lArr[i]);
        }
        return bundleArr;
    }
}
