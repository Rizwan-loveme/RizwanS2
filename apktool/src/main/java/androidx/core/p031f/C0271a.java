package androidx.core.p031f;

import android.p008os.Build;
import android.p008os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.C0225a;
import androidx.core.p031f.p032a.C0273b;
import androidx.core.p031f.p032a.C0274c;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* compiled from: AccessibilityDelegateCompat.java */
/* renamed from: androidx.core.f.a */
/* loaded from: classes.dex */
public class C0271a {

    /* renamed from: a */
    private static final View.AccessibilityDelegate f2067a = new View.AccessibilityDelegate();

    /* renamed from: b */
    private final View.AccessibilityDelegate f2068b;

    /* renamed from: c */
    private final View.AccessibilityDelegate f2069c;

    /* compiled from: AccessibilityDelegateCompat.java */
    /* renamed from: androidx.core.f.a$a */
    static final class a extends View.AccessibilityDelegate {

        /* renamed from: a */
        final C0271a f2070a;

        a(C0271a c0271a) {
            this.f2070a = c0271a;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f2070a.mo1972b(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f2070a.mo1974d(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            C0273b m1976a = C0273b.m1976a(accessibilityNodeInfo);
            m1976a.m2018h(C0308x.m2278y(view));
            m1976a.m2020i(C0308x.m2213A(view));
            m1976a.m2013f(C0308x.m2279z(view));
            m1976a.m2010e(C0308x.m2255e(view));
            this.f2070a.mo1969a(view, m1976a);
            m1976a.m1994a(accessibilityNodeInfo.getText(), view);
            List<C0273b.a> m1964b = C0271a.m1964b(view);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < m1964b.size()) {
                    m1976a.m1992a(m1964b.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f2070a.m1973c(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f2070a.mo1971a(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i) {
            this.f2070a.m1967a(view, i);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f2070a.m1968a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            C0274c m1966a = this.f2070a.m1966a(view);
            if (m1966a != null) {
                return (AccessibilityNodeProvider) m1966a.m2040a();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.f2070a.mo1970a(view, i, bundle);
        }
    }

    public C0271a() {
        this(f2067a);
    }

    public C0271a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f2068b = accessibilityDelegate;
        this.f2069c = new a(this);
    }

    /* renamed from: a */
    View.AccessibilityDelegate m1965a() {
        return this.f2069c;
    }

    /* renamed from: a */
    public void m1967a(View view, int i) {
        this.f2068b.sendAccessibilityEvent(view, i);
    }

    /* renamed from: a */
    public void m1968a(View view, AccessibilityEvent accessibilityEvent) {
        this.f2068b.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    /* renamed from: b */
    public boolean mo1972b(View view, AccessibilityEvent accessibilityEvent) {
        return this.f2068b.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    /* renamed from: c */
    public void m1973c(View view, AccessibilityEvent accessibilityEvent) {
        this.f2068b.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    /* renamed from: d */
    public void mo1974d(View view, AccessibilityEvent accessibilityEvent) {
        this.f2068b.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    /* renamed from: a */
    public void mo1969a(View view, C0273b c0273b) {
        this.f2068b.onInitializeAccessibilityNodeInfo(view, c0273b.m1988a());
    }

    /* renamed from: a */
    public boolean mo1971a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f2068b.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    /* renamed from: a */
    public C0274c m1966a(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = this.f2068b.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new C0274c(accessibilityNodeProvider);
    }

    /* renamed from: a */
    public boolean mo1970a(View view, int i, Bundle bundle) {
        boolean z;
        List<C0273b.a> m1964b = m1964b(view);
        int i2 = 0;
        while (true) {
            if (i2 >= m1964b.size()) {
                z = false;
                break;
            }
            C0273b.a aVar = m1964b.get(i2);
            if (aVar.m2035a() != i) {
                i2++;
            } else {
                z = aVar.m2037a(view, bundle);
                break;
            }
        }
        if (!z && Build.VERSION.SDK_INT >= 16) {
            z = this.f2068b.performAccessibilityAction(view, i, bundle);
        }
        if (!z && i == C0225a.c.accessibility_action_clickable_span) {
            return m1962a(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private boolean m1962a(int i, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(C0225a.c.tag_accessibility_clickable_spans);
        if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(i)) != null) {
            ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
            if (m1963a(clickableSpan, view)) {
                clickableSpan.onClick(view);
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m1963a(ClickableSpan clickableSpan, View view) {
        if (clickableSpan == null) {
            return false;
        }
        ClickableSpan[] m1982c = C0273b.m1982c(view.createAccessibilityNodeInfo().getText());
        for (int i = 0; m1982c != null && i < m1982c.length; i++) {
            if (clickableSpan.equals(m1982c[i])) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    static List<C0273b.a> m1964b(View view) {
        List<C0273b.a> list = (List) view.getTag(C0225a.c.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }
}
