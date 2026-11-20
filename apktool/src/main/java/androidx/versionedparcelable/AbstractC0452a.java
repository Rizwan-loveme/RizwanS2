package androidx.versionedparcelable;

import android.os.Parcelable;
import androidx.p011a.C0036a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: VersionedParcel.java */
/* renamed from: androidx.versionedparcelable.a */
/* loaded from: classes.dex */
public abstract class AbstractC0452a {

    /* renamed from: a */
    protected final C0036a<String, Method> f3253a;

    /* renamed from: b */
    protected final C0036a<String, Method> f3254b;

    /* renamed from: c */
    protected final C0036a<String, Class> f3255c;

    /* renamed from: a */
    protected abstract void mo3429a(int i);

    /* renamed from: a */
    protected abstract void mo3431a(Parcelable parcelable);

    /* renamed from: a */
    protected abstract void mo3436a(CharSequence charSequence);

    /* renamed from: a */
    protected abstract void mo3438a(String str);

    /* renamed from: a */
    protected abstract void mo3440a(boolean z);

    /* renamed from: a */
    protected abstract void mo3443a(byte[] bArr);

    /* renamed from: b */
    protected abstract void mo3451b();

    /* renamed from: b */
    protected abstract boolean mo3452b(int i);

    /* renamed from: c */
    protected abstract AbstractC0452a mo3455c();

    /* renamed from: c */
    protected abstract void mo3456c(int i);

    /* renamed from: d */
    protected abstract int mo3457d();

    /* renamed from: e */
    protected abstract String mo3458e();

    /* renamed from: f */
    protected abstract byte[] mo3459f();

    /* renamed from: g */
    protected abstract CharSequence mo3460g();

    /* renamed from: h */
    protected abstract <T extends Parcelable> T mo3461h();

    /* renamed from: i */
    protected abstract boolean mo3462i();

    public AbstractC0452a(C0036a<String, Method> c0036a, C0036a<String, Method> c0036a2, C0036a<String, Class> c0036a3) {
        this.f3253a = c0036a;
        this.f3254b = c0036a2;
        this.f3255c = c0036a3;
    }

    /* renamed from: a */
    public boolean m3445a() {
        return false;
    }

    /* renamed from: a */
    public void m3442a(boolean z, boolean z2) {
    }

    /* renamed from: a */
    public void m3441a(boolean z, int i) {
        mo3456c(i);
        mo3440a(z);
    }

    /* renamed from: a */
    public void m3444a(byte[] bArr, int i) {
        mo3456c(i);
        mo3443a(bArr);
    }

    /* renamed from: a */
    public void m3437a(CharSequence charSequence, int i) {
        mo3456c(i);
        mo3436a(charSequence);
    }

    /* renamed from: a */
    public void m3430a(int i, int i2) {
        mo3456c(i2);
        mo3429a(i);
    }

    /* renamed from: a */
    public void m3439a(String str, int i) {
        mo3456c(i);
        mo3438a(str);
    }

    /* renamed from: a */
    public void m3432a(Parcelable parcelable, int i) {
        mo3456c(i);
        mo3431a(parcelable);
    }

    /* renamed from: b */
    public boolean m3453b(boolean z, int i) {
        return !mo3452b(i) ? z : mo3462i();
    }

    /* renamed from: b */
    public int m3446b(int i, int i2) {
        return !mo3452b(i2) ? i : mo3457d();
    }

    /* renamed from: b */
    public String m3450b(String str, int i) {
        return !mo3452b(i) ? str : mo3458e();
    }

    /* renamed from: b */
    public byte[] m3454b(byte[] bArr, int i) {
        return !mo3452b(i) ? bArr : mo3459f();
    }

    /* renamed from: b */
    public <T extends Parcelable> T m3447b(T t, int i) {
        return !mo3452b(i) ? t : (T) mo3461h();
    }

    /* renamed from: b */
    public CharSequence m3449b(CharSequence charSequence, int i) {
        return !mo3452b(i) ? charSequence : mo3460g();
    }

    /* renamed from: a */
    public void m3434a(InterfaceC0454c interfaceC0454c, int i) {
        mo3456c(i);
        m3433a(interfaceC0454c);
    }

    /* renamed from: a */
    protected void m3433a(InterfaceC0454c interfaceC0454c) {
        if (interfaceC0454c == null) {
            mo3438a((String) null);
            return;
        }
        m3427b(interfaceC0454c);
        AbstractC0452a mo3455c = mo3455c();
        m3435a((AbstractC0452a) interfaceC0454c, mo3455c);
        mo3455c.mo3451b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    private void m3427b(InterfaceC0454c interfaceC0454c) {
        try {
            mo3438a(m3425b((Class<? extends InterfaceC0454c>) interfaceC0454c.getClass()).getName());
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(interfaceC0454c.getClass().getSimpleName() + " does not have a Parcelizer", e2);
        }
    }

    /* renamed from: b */
    public <T extends InterfaceC0454c> T m3448b(T t, int i) {
        return !mo3452b(i) ? t : (T) m3463j();
    }

    /* renamed from: j */
    protected <T extends InterfaceC0454c> T m3463j() {
        String mo3458e = mo3458e();
        if (mo3458e == null) {
            return null;
        }
        return (T) m3428a(mo3458e, mo3455c());
    }

    /* renamed from: a */
    protected <T extends InterfaceC0454c> T m3428a(String str, AbstractC0452a abstractC0452a) {
        try {
            return (T) m3426b(str).invoke(null, abstractC0452a);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (InvocationTargetException e5) {
            if (e5.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e5.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e5);
        }
    }

    /* renamed from: a */
    protected <T extends InterfaceC0454c> void m3435a(T t, AbstractC0452a abstractC0452a) {
        try {
            m3424a(t.getClass()).invoke(null, t, abstractC0452a);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (InvocationTargetException e5) {
            if (e5.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e5.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e5);
        }
    }

    /* renamed from: b */
    private Method m3426b(String str) {
        Method method = this.f3253a.get(str);
        if (method == null) {
            System.currentTimeMillis();
            Method declaredMethod = Class.forName(str, true, AbstractC0452a.class.getClassLoader()).getDeclaredMethod("read", AbstractC0452a.class);
            this.f3253a.put(str, declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private Method m3424a(Class cls) {
        Method method = this.f3254b.get(cls.getName());
        if (method == null) {
            Class m3425b = m3425b((Class<? extends InterfaceC0454c>) cls);
            System.currentTimeMillis();
            Method declaredMethod = m3425b.getDeclaredMethod("write", cls, AbstractC0452a.class);
            this.f3254b.put(cls.getName(), declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    /* renamed from: b */
    private Class m3425b(Class<? extends InterfaceC0454c> cls) {
        Class cls2 = this.f3255c.get(cls.getName());
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
            this.f3255c.put(cls.getName(), cls3);
            return cls3;
        }
        return cls2;
    }
}
