package androidx.core.p031f.p032a;

import android.p008os.Build;
import android.p008os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompat.java */
/* renamed from: androidx.core.f.a.c */
/* loaded from: classes.dex */
public class C0274c {

    /* renamed from: a */
    private final Object f2121a;

    /* compiled from: AccessibilityNodeProviderCompat.java */
    /* renamed from: androidx.core.f.a.c$a */
    static class a extends AccessibilityNodeProvider {

        /* renamed from: a */
        final C0274c f2122a;

        a(C0274c c0274c) {
            this.f2122a = c0274c;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            C0273b m2039a = this.f2122a.m2039a(i);
            if (m2039a == null) {
                return null;
            }
            return m2039a.m1988a();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            List<C0273b> m2041a = this.f2122a.m2041a(str, i);
            if (m2041a == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = m2041a.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(m2041a.get(i2).m1988a());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f2122a.m2043a(i, i2, bundle);
        }
    }

    /* compiled from: AccessibilityNodeProviderCompat.java */
    /* renamed from: androidx.core.f.a.c$b */
    static class b extends a {
        b(C0274c c0274c) {
            super(c0274c);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i) {
            C0273b m2044b = this.f2122a.m2044b(i);
            if (m2044b == null) {
                return null;
            }
            return m2044b.m1988a();
        }
    }

    /* compiled from: AccessibilityNodeProviderCompat.java */
    /* renamed from: androidx.core.f.a.c$c */
    static class c extends b {
        c(C0274c c0274c) {
            super(c0274c);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f2122a.m2042a(i, C0273b.m1976a(accessibilityNodeInfo), str, bundle);
        }
    }

    public C0274c() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2121a = new c(this);
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2121a = new b(this);
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.f2121a = new a(this);
        } else {
            this.f2121a = null;
        }
    }

    public C0274c(Object obj) {
        this.f2121a = obj;
    }

    /* renamed from: a */
    public Object m2040a() {
        return this.f2121a;
    }

    /* renamed from: a */
    public C0273b m2039a(int i) {
        return null;
    }

    /* renamed from: a */
    public boolean m2043a(int i, int i2, Bundle bundle) {
        return false;
    }

    /* renamed from: a */
    public List<C0273b> m2041a(String str, int i) {
        return null;
    }

    /* renamed from: b */
    public C0273b m2044b(int i) {
        return null;
    }

    /* renamed from: a */
    public void m2042a(int i, C0273b c0273b, String str, Bundle bundle) {
    }
}
