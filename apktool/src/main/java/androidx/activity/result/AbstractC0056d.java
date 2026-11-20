package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.p013a.AbstractC0052a;
import androidx.core.app.C0231b;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* compiled from: ActivityResultRegistry.java */
/* renamed from: androidx.activity.result.d */
/* loaded from: classes.dex */
public abstract class AbstractC0056d {

    /* renamed from: a */
    private Random f394a = new Random();

    /* renamed from: g */
    private final Map<Integer, String> f400g = new HashMap();

    /* renamed from: b */
    final Map<String, Integer> f395b = new HashMap();

    /* renamed from: h */
    private final Map<String, b> f401h = new HashMap();

    /* renamed from: c */
    ArrayList<String> f396c = new ArrayList<>();

    /* renamed from: d */
    final transient Map<String, a<?>> f397d = new HashMap();

    /* renamed from: e */
    final Map<String, Object> f398e = new HashMap();

    /* renamed from: f */
    final Bundle f399f = new Bundle();

    /* renamed from: a */
    public abstract <I, O> void mo302a(int i, AbstractC0052a<I, O> abstractC0052a, @SuppressLint({"UnknownNullness"}) I i2, C0231b c0231b);

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final <I, O> AbstractC0055c<I> m329a(final String str, final AbstractC0052a<I, O> abstractC0052a, InterfaceC0054b<O> interfaceC0054b) {
        final int m328b = m328b(str);
        this.f397d.put(str, new a<>(interfaceC0054b, abstractC0052a));
        if (this.f398e.containsKey(str)) {
            Object obj = this.f398e.get(str);
            this.f398e.remove(str);
            interfaceC0054b.mo321a(obj);
        }
        C0051a c0051a = (C0051a) this.f399f.getParcelable(str);
        if (c0051a != null) {
            this.f399f.remove(str);
            interfaceC0054b.mo321a(abstractC0052a.mo315a(c0051a.m310a(), c0051a.m311b()));
        }
        return new AbstractC0055c<I>() { // from class: androidx.activity.result.d.1
            @Override // androidx.activity.result.AbstractC0055c
            /* renamed from: a */
            public void mo324a(I i, C0231b c0231b) {
                AbstractC0056d.this.f396c.add(str);
                Integer num = AbstractC0056d.this.f395b.get(str);
                AbstractC0056d.this.mo302a(num != null ? num.intValue() : m328b, (AbstractC0052a<AbstractC0052a, O>) abstractC0052a, (AbstractC0052a) i, c0231b);
            }

            @Override // androidx.activity.result.AbstractC0055c
            /* renamed from: a */
            public void mo322a() {
                AbstractC0056d.this.m331a(str);
            }
        };
    }

    /* renamed from: a */
    final void m331a(String str) {
        Integer remove;
        if (!this.f396c.contains(str) && (remove = this.f395b.remove(str)) != null) {
            this.f400g.remove(remove);
        }
        this.f397d.remove(str);
        if (this.f398e.containsKey(str)) {
            Log.m190w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f398e.get(str));
            this.f398e.remove(str);
        }
        if (this.f399f.containsKey(str)) {
            Log.m190w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f399f.getParcelable(str));
            this.f399f.remove(str);
        }
        b bVar = this.f401h.get(str);
        if (bVar != null) {
            bVar.m335a();
            this.f401h.remove(str);
        }
    }

    /* renamed from: a */
    public final void m330a(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f395b.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f395b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f396c));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f399f.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.f394a);
    }

    /* renamed from: b */
    public final void m334b(Bundle bundle) {
        if (bundle != null) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList != null && integerArrayList != null) {
                this.f396c = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                this.f394a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
                this.f399f.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < stringArrayList.size()) {
                        String str = stringArrayList.get(i2);
                        if (this.f395b.containsKey(str)) {
                            Integer remove = this.f395b.remove(str);
                            if (!this.f399f.containsKey(str)) {
                                this.f400g.remove(remove);
                            }
                        }
                        m326a(integerArrayList.get(i2).intValue(), stringArrayList.get(i2));
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final boolean m332a(int i, int i2, Intent intent) {
        String str = this.f400g.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        this.f396c.remove(str);
        m327a(str, i2, intent, this.f397d.get(str));
        return true;
    }

    /* renamed from: a */
    public final <O> boolean m333a(int i, @SuppressLint({"UnknownNullness"}) O o) {
        String str = this.f400g.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        this.f396c.remove(str);
        a<?> aVar = this.f397d.get(str);
        if (aVar == null || aVar.f406a == null) {
            this.f399f.remove(str);
            this.f398e.put(str, o);
        } else {
            aVar.f406a.mo321a(o);
        }
        return true;
    }

    /* renamed from: a */
    private <O> void m327a(String str, int i, Intent intent, a<O> aVar) {
        if (aVar != null && aVar.f406a != null) {
            aVar.f406a.mo321a(aVar.f407b.mo315a(i, intent));
        } else {
            this.f398e.remove(str);
            this.f399f.putParcelable(str, new C0051a(i, intent));
        }
    }

    /* renamed from: b */
    private int m328b(String str) {
        Integer num = this.f395b.get(str);
        if (num != null) {
            return num.intValue();
        }
        int m325a = m325a();
        m326a(m325a, str);
        return m325a;
    }

    /* renamed from: a */
    private int m325a() {
        int nextInt = this.f394a.nextInt(2147418112);
        while (true) {
            int i = nextInt + 65536;
            if (this.f400g.containsKey(Integer.valueOf(i))) {
                nextInt = this.f394a.nextInt(2147418112);
            } else {
                return i;
            }
        }
    }

    /* renamed from: a */
    private void m326a(int i, String str) {
        this.f400g.put(Integer.valueOf(i), str);
        this.f395b.put(str, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ActivityResultRegistry.java */
    /* renamed from: androidx.activity.result.d$a */
    static class a<O> {

        /* renamed from: a */
        final InterfaceC0054b<O> f406a;

        /* renamed from: b */
        final AbstractC0052a<?, O> f407b;

        a(InterfaceC0054b<O> interfaceC0054b, AbstractC0052a<?, O> abstractC0052a) {
            this.f406a = interfaceC0054b;
            this.f407b = abstractC0052a;
        }
    }

    /* compiled from: ActivityResultRegistry.java */
    /* renamed from: androidx.activity.result.d$b */
    private static class b {

        /* renamed from: a */
        final Lifecycle f408a;

        /* renamed from: b */
        private final ArrayList<LifecycleEventObserver> f409b;

        /* renamed from: a */
        void m335a() {
            Iterator<LifecycleEventObserver> it = this.f409b.iterator();
            while (it.hasNext()) {
                this.f408a.removeObserver(it.next());
            }
            this.f409b.clear();
        }
    }
}
