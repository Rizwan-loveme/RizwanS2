package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.C0362a;

/* compiled from: FragmentLayoutInflaterFactory.java */
/* renamed from: androidx.fragment.app.m */
/* loaded from: classes.dex */
class LayoutInflaterFactory2C0382m implements LayoutInflater.Factory2 {

    /* renamed from: a */
    final AbstractC0384o f2730a;

    LayoutInflaterFactory2C0382m(AbstractC0384o abstractC0384o) {
        this.f2730a = abstractC0384o;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01d9  */
    @Override // android.view.LayoutInflater.Factory2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        final C0391v m3046f;
        ComponentCallbacksC0374e componentCallbacksC0374e;
        if (C0378i.class.getName().equals(str)) {
            return new C0378i(context, attributeSet, this.f2730a);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0362a.c.Fragment);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(C0362a.c.Fragment_android_name);
        }
        int resourceId = obtainStyledAttributes.getResourceId(C0362a.c.Fragment_android_id, -1);
        String string = obtainStyledAttributes.getString(C0362a.c.Fragment_android_tag);
        obtainStyledAttributes.recycle();
        if (attributeValue == null || !C0380k.m2938a(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        ComponentCallbacksC0374e m3036c = resourceId != -1 ? this.f2730a.m3036c(resourceId) : null;
        if (m3036c == null && string != null) {
            m3036c = this.f2730a.m3027b(string);
        }
        if (m3036c == null && id != -1) {
            m3036c = this.f2730a.m3036c(id);
        }
        if (m3036c == null) {
            m3036c = this.f2730a.m2997C().mo2941c(context.getClassLoader(), attributeValue);
            m3036c.f2650n = true;
            m3036c.f2659w = resourceId != 0 ? resourceId : id;
            m3036c.f2660x = id;
            m3036c.f2661y = string;
            m3036c.f2651o = true;
            m3036c.f2655s = this.f2730a;
            m3036c.f2656t = this.f2730a.m3056k();
            m3036c.m2809a(this.f2730a.m3056k().m2944i(), attributeSet, m3036c.f2639c);
            m3046f = this.f2730a.m3048g(m3036c);
            if (AbstractC0384o.m2976a(2)) {
                Log.m188v("FragmentManager", "Fragment " + m3036c + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                componentCallbacksC0374e = m3036c;
                componentCallbacksC0374e.f2616F = (ViewGroup) view;
                m3046f.m3122c();
                m3046f.m3123d();
                if (componentCallbacksC0374e.f2617G != null) {
                    throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
                }
                if (resourceId != 0) {
                    componentCallbacksC0374e.f2617G.setId(resourceId);
                }
                if (componentCallbacksC0374e.f2617G.getTag() == null) {
                    componentCallbacksC0374e.f2617G.setTag(string);
                }
                componentCallbacksC0374e.f2617G.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.fragment.app.m.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view2) {
                        ComponentCallbacksC0374e m3118a = m3046f.m3118a();
                        m3046f.m3122c();
                        AbstractC0368ae.m2696a((ViewGroup) m3118a.f2617G.getParent(), LayoutInflaterFactory2C0382m.this.f2730a).m2711e();
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view2) {
                    }
                });
                return componentCallbacksC0374e.f2617G;
            }
        } else {
            if (m3036c.f2651o) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            m3036c.f2651o = true;
            m3036c.f2655s = this.f2730a;
            m3036c.f2656t = this.f2730a.m3056k();
            m3036c.m2809a(this.f2730a.m3056k().m2944i(), attributeSet, m3036c.f2639c);
            m3046f = this.f2730a.m3046f(m3036c);
            if (AbstractC0384o.m2976a(2)) {
                Log.m188v("FragmentManager", "Retained Fragment " + m3036c + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        }
        componentCallbacksC0374e = m3036c;
        componentCallbacksC0374e.f2616F = (ViewGroup) view;
        m3046f.m3122c();
        m3046f.m3123d();
        if (componentCallbacksC0374e.f2617G != null) {
        }
    }
}
