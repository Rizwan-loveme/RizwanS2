package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.p026b.C0245b;
import androidx.core.p031f.C0308x;
import androidx.core.p031f.C0310z;
import androidx.core.p031f.ViewOnAttachStateChangeListenerC0305u;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: FragmentTransitionImpl.java */
@SuppressLint({"UnknownNullness"})
/* renamed from: androidx.fragment.app.aa */
/* loaded from: classes.dex */
public abstract class AbstractC0364aa {
    /* renamed from: a */
    public abstract Object mo2656a(Object obj, Object obj2, Object obj3);

    /* renamed from: a */
    public abstract void mo2661a(ViewGroup viewGroup, Object obj);

    /* renamed from: a */
    public abstract void mo2664a(Object obj, Rect rect);

    /* renamed from: a */
    public abstract void mo2665a(Object obj, View view);

    /* renamed from: a */
    public abstract void mo2666a(Object obj, View view, ArrayList<View> arrayList);

    /* renamed from: a */
    public abstract void mo2667a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    /* renamed from: a */
    public abstract void mo2668a(Object obj, ArrayList<View> arrayList);

    /* renamed from: a */
    public abstract void mo2669a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    /* renamed from: a */
    public abstract boolean mo2672a(Object obj);

    /* renamed from: b */
    public abstract Object mo2673b(Object obj);

    /* renamed from: b */
    public abstract Object mo2674b(Object obj, Object obj2, Object obj3);

    /* renamed from: b */
    public abstract void mo2675b(Object obj, View view);

    /* renamed from: b */
    public abstract void mo2676b(Object obj, View view, ArrayList<View> arrayList);

    /* renamed from: b */
    public abstract void mo2677b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    /* renamed from: c */
    public abstract Object mo2678c(Object obj);

    /* renamed from: c */
    public abstract void mo2679c(Object obj, View view);

    /* renamed from: a */
    protected void m2658a(View view, Rect rect) {
        if (C0308x.m2276w(view)) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            Object parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            view.getRootView().getLocationOnScreen(new int[2]);
            rectF.offset(r0[0], r0[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    /* renamed from: a */
    ArrayList<String> m2657a(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = arrayList.get(i);
            arrayList2.add(C0308x.m2265l(view));
            C0308x.m2241a(view, (String) null);
        }
        return arrayList2;
    }

    /* renamed from: a */
    void m2659a(View view, final ArrayList<View> arrayList, final ArrayList<View> arrayList2, final ArrayList<String> arrayList3, Map<String, String> map) {
        final int size = arrayList2.size();
        final ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = arrayList.get(i);
            String m2265l = C0308x.m2265l(view2);
            arrayList4.add(m2265l);
            if (m2265l != null) {
                C0308x.m2241a(view2, (String) null);
                String str = map.get(m2265l);
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    if (!str.equals(arrayList3.get(i2))) {
                        i2++;
                    } else {
                        C0308x.m2241a(arrayList2.get(i2), m2265l);
                        break;
                    }
                }
            }
        }
        ViewOnAttachStateChangeListenerC0305u.m2209a(view, new Runnable() { // from class: androidx.fragment.app.aa.1
            @Override // java.lang.Runnable
            public void run() {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < size) {
                        C0308x.m2241a((View) arrayList2.get(i4), (String) arrayList3.get(i4));
                        C0308x.m2241a((View) arrayList.get(i4), (String) arrayList4.get(i4));
                        i3 = i4 + 1;
                    } else {
                        return;
                    }
                }
            }
        });
    }

    /* renamed from: a */
    void m2670a(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (C0310z.m2306a(viewGroup)) {
                    arrayList.add(viewGroup);
                    return;
                }
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    m2670a(arrayList, viewGroup.getChildAt(i));
                }
                return;
            }
            arrayList.add(view);
        }
    }

    /* renamed from: a */
    void m2671a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String m2265l = C0308x.m2265l(view);
            if (m2265l != null) {
                map.put(m2265l, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    m2671a(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    /* renamed from: a */
    void m2660a(View view, final ArrayList<View> arrayList, final Map<String, String> map) {
        ViewOnAttachStateChangeListenerC0305u.m2209a(view, new Runnable() { // from class: androidx.fragment.app.aa.2
            @Override // java.lang.Runnable
            public void run() {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    View view2 = (View) arrayList.get(i);
                    String m2265l = C0308x.m2265l(view2);
                    if (m2265l != null) {
                        C0308x.m2241a(view2, AbstractC0364aa.m2652a((Map<String, String>) map, m2265l));
                    }
                }
            }
        });
    }

    /* renamed from: a */
    public void mo2663a(ComponentCallbacksC0374e componentCallbacksC0374e, Object obj, C0245b c0245b, Runnable runnable) {
        runnable.run();
    }

    /* renamed from: a */
    void m2662a(ViewGroup viewGroup, final ArrayList<View> arrayList, final Map<String, String> map) {
        ViewOnAttachStateChangeListenerC0305u.m2209a(viewGroup, new Runnable() { // from class: androidx.fragment.app.aa.3
            @Override // java.lang.Runnable
            public void run() {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    View view = (View) arrayList.get(i);
                    C0308x.m2241a(view, (String) map.get(C0308x.m2265l(view)));
                }
            }
        });
    }

    /* renamed from: a */
    protected static void m2653a(List<View> list, View view) {
        int size = list.size();
        if (!m2655a(list, view, size)) {
            if (C0308x.m2265l(view) != null) {
                list.add(view);
            }
            for (int i = size; i < list.size(); i++) {
                View view2 = list.get(i);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (!m2655a(list, childAt, size) && C0308x.m2265l(childAt) != null) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m2655a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    protected static boolean m2654a(List list) {
        return list == null || list.isEmpty();
    }

    /* renamed from: a */
    static String m2652a(Map<String, String> map, String str) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
