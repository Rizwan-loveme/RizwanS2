package androidx.appcompat.app;

import android.C0012R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.p008os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.C0092d;
import androidx.appcompat.widget.C0160ab;
import androidx.appcompat.widget.C0162ad;
import androidx.appcompat.widget.C0181aw;
import androidx.appcompat.widget.C0195e;
import androidx.appcompat.widget.C0197g;
import androidx.appcompat.widget.C0198h;
import androidx.appcompat.widget.C0199i;
import androidx.appcompat.widget.C0202l;
import androidx.appcompat.widget.C0204n;
import androidx.appcompat.widget.C0206p;
import androidx.appcompat.widget.C0207q;
import androidx.appcompat.widget.C0210t;
import androidx.appcompat.widget.C0211u;
import androidx.appcompat.widget.C0213w;
import androidx.appcompat.widget.C0215y;
import androidx.core.p031f.C0308x;
import androidx.p011a.C0042g;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: AppCompatViewInflater.java */
/* renamed from: androidx.appcompat.app.i */
/* loaded from: classes.dex */
public class C0077i {

    /* renamed from: a */
    private static final Class<?>[] f655a = {Context.class, AttributeSet.class};

    /* renamed from: b */
    private static final int[] f656b = {C0012R.attr.onClick};

    /* renamed from: c */
    private static final String[] f657c = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: d */
    private static final C0042g<String, Constructor<? extends View>> f658d = new C0042g<>();

    /* renamed from: e */
    private final Object[] f659e = new Object[2];

    /* renamed from: a */
    final View m594a(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        Context context2;
        View m608n;
        context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = m588a(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = C0181aw.m1427a(context2);
        }
        switch (str) {
            case "TextView":
                m608n = m595a(context2, attributeSet);
                m591a(m608n, str);
                break;
            case "ImageView":
                m608n = m596b(context2, attributeSet);
                m591a(m608n, str);
                break;
            case "Button":
                m608n = m597c(context2, attributeSet);
                m591a(m608n, str);
                break;
            case "EditText":
                m608n = m598d(context2, attributeSet);
                m591a(m608n, str);
                break;
            case "Spinner":
                m608n = m599e(context2, attributeSet);
                m591a(m608n, str);
                break;
            case "ImageButton":
                m608n = m600f(context2, attributeSet);
                m591a(m608n, str);
                break;
            case "CheckBox":
                m608n = m601g(context2, attributeSet);
                m591a(m608n, str);
                break;
            case "RadioButton":
                m608n = m602h(context2, attributeSet);
                m591a(m608n, str);
                break;
            case "CheckedTextView":
                m608n = m603i(context2, attributeSet);
                m591a(m608n, str);
                break;
            case "AutoCompleteTextView":
                m608n = m604j(context2, attributeSet);
                m591a(m608n, str);
                break;
            case "MultiAutoCompleteTextView":
                m608n = m605k(context2, attributeSet);
                m591a(m608n, str);
                break;
            case "RatingBar":
                m608n = m606l(context2, attributeSet);
                m591a(m608n, str);
                break;
            case "SeekBar":
                m608n = m607m(context2, attributeSet);
                m591a(m608n, str);
                break;
            case "ToggleButton":
                m608n = m608n(context2, attributeSet);
                m591a(m608n, str);
                break;
            default:
                m608n = m593a(context2, str, attributeSet);
                break;
        }
        View m592b = (m608n != null || context == context2) ? m608n : m592b(context2, str, attributeSet);
        if (m592b != null) {
            m590a(m592b, attributeSet);
        }
        return m592b;
    }

    /* renamed from: a */
    protected C0160ab m595a(Context context, AttributeSet attributeSet) {
        return new C0160ab(context, attributeSet);
    }

    /* renamed from: b */
    protected C0206p m596b(Context context, AttributeSet attributeSet) {
        return new C0206p(context, attributeSet);
    }

    /* renamed from: c */
    protected C0197g m597c(Context context, AttributeSet attributeSet) {
        return new C0197g(context, attributeSet);
    }

    /* renamed from: d */
    protected C0202l m598d(Context context, AttributeSet attributeSet) {
        return new C0202l(context, attributeSet);
    }

    /* renamed from: e */
    protected C0215y m599e(Context context, AttributeSet attributeSet) {
        return new C0215y(context, attributeSet);
    }

    /* renamed from: f */
    protected C0204n m600f(Context context, AttributeSet attributeSet) {
        return new C0204n(context, attributeSet);
    }

    /* renamed from: g */
    protected C0198h m601g(Context context, AttributeSet attributeSet) {
        return new C0198h(context, attributeSet);
    }

    /* renamed from: h */
    protected C0210t m602h(Context context, AttributeSet attributeSet) {
        return new C0210t(context, attributeSet);
    }

    /* renamed from: i */
    protected C0199i m603i(Context context, AttributeSet attributeSet) {
        return new C0199i(context, attributeSet);
    }

    /* renamed from: j */
    protected C0195e m604j(Context context, AttributeSet attributeSet) {
        return new C0195e(context, attributeSet);
    }

    /* renamed from: k */
    protected C0207q m605k(Context context, AttributeSet attributeSet) {
        return new C0207q(context, attributeSet);
    }

    /* renamed from: l */
    protected C0211u m606l(Context context, AttributeSet attributeSet) {
        return new C0211u(context, attributeSet);
    }

    /* renamed from: m */
    protected C0213w m607m(Context context, AttributeSet attributeSet) {
        return new C0213w(context, attributeSet);
    }

    /* renamed from: n */
    protected C0162ad m608n(Context context, AttributeSet attributeSet) {
        return new C0162ad(context, attributeSet);
    }

    /* renamed from: a */
    private void m591a(View view, String str) {
        if (view == null) {
            throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
        }
    }

    /* renamed from: a */
    protected View m593a(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    /* renamed from: b */
    private View m592b(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.f659e[0] = context;
            this.f659e[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return m589a(context, str, (String) null);
            }
            for (int i = 0; i < f657c.length; i++) {
                View m589a = m589a(context, str, f657c[i]);
                if (m589a != null) {
                    return m589a;
                }
            }
            return null;
        } catch (Exception e2) {
            return null;
        } finally {
            this.f659e[0] = null;
            this.f659e[1] = null;
        }
    }

    /* renamed from: a */
    private void m590a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (context instanceof ContextWrapper) {
            if (Build.VERSION.SDK_INT < 15 || C0308x.m2277x(view)) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f656b);
                String string = obtainStyledAttributes.getString(0);
                if (string != null) {
                    view.setOnClickListener(new a(view, string));
                }
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* renamed from: a */
    private View m589a(Context context, String str, String str2) {
        String str3;
        Constructor<? extends View> constructor = f658d.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception e2) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f655a);
            f658d.put(str, constructor);
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.f659e);
    }

    /* renamed from: a */
    private static Context m588a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0059a.j.View, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(C0059a.j.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = obtainStyledAttributes.getResourceId(C0059a.j.View_theme, 0)) != 0) {
            Log.m186i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        int i = resourceId;
        obtainStyledAttributes.recycle();
        if (i != 0) {
            if (!(context instanceof C0092d) || ((C0092d) context).m753a() != i) {
                return new C0092d(context, i);
            }
            return context;
        }
        return context;
    }

    /* compiled from: AppCompatViewInflater.java */
    /* renamed from: androidx.appcompat.app.i$a */
    private static class a implements View.OnClickListener {

        /* renamed from: a */
        private final View f660a;

        /* renamed from: b */
        private final String f661b;

        /* renamed from: c */
        private Method f662c;

        /* renamed from: d */
        private Context f663d;

        public a(View view, String str) {
            this.f660a = view;
            this.f661b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f662c == null) {
                m609a(this.f660a.getContext());
            }
            try {
                this.f662c.invoke(this.f663d, view);
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
            } catch (InvocationTargetException e3) {
                throw new IllegalStateException("Could not execute method for android:onClick", e3);
            }
        }

        /* renamed from: a */
        private void m609a(Context context) {
            Method method;
            Context context2 = context;
            while (context2 != null) {
                try {
                    if (!context2.isRestricted() && (method = context2.getClass().getMethod(this.f661b, View.class)) != null) {
                        this.f662c = method;
                        this.f663d = context2;
                        return;
                    }
                } catch (NoSuchMethodException e2) {
                }
                if (context2 instanceof ContextWrapper) {
                    context2 = ((ContextWrapper) context2).getBaseContext();
                } else {
                    context2 = null;
                }
            }
            int id = this.f660a.getId();
            throw new IllegalStateException("Could not find method " + this.f661b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f660a.getClass() + (id == -1 ? "" : " with id '" + this.f660a.getContext().getResources().getResourceEntryName(id) + "'"));
        }
    }
}
