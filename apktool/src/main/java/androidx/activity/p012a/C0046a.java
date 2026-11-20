package androidx.activity.p012a;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: ContextAwareHelper.java */
/* renamed from: androidx.activity.a.a */
/* loaded from: classes.dex */
public final class C0046a {

    /* renamed from: a */
    private final Set<InterfaceC0047b> f362a = new CopyOnWriteArraySet();

    /* renamed from: b */
    private volatile Context f363b;

    /* renamed from: a */
    public void m291a(InterfaceC0047b interfaceC0047b) {
        if (this.f363b != null) {
            interfaceC0047b.mo292a(this.f363b);
        }
        this.f362a.add(interfaceC0047b);
    }

    /* renamed from: a */
    public void m290a(Context context) {
        this.f363b = context;
        Iterator<InterfaceC0047b> it = this.f362a.iterator();
        while (it.hasNext()) {
            it.next().mo292a(context);
        }
    }

    /* renamed from: a */
    public void m289a() {
        this.f363b = null;
    }
}
