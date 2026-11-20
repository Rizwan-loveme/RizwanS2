package org.p226d.p233b.p238b;

import java.util.Iterator;
import org.p226d.p233b.p238b.p239a.AbstractC1993g;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p233b.p250e.InterfaceC2175b;
import org.p226d.p233b.p250e.InterfaceC2269j;
import org.p226d.p233b.p250e.p255d.InterfaceC2246b;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p250e.p255d.InterfaceC2262r;

/* compiled from: BaseMethodParameter.java */
/* renamed from: org.d.b.b.d */
/* loaded from: classes.dex */
public abstract class AbstractC2014d extends AbstractC1993g implements InterfaceC2269j {
    @Override // org.p226d.p233b.p250e.InterfaceC2269j, org.p226d.p233b.p250e.p251a.InterfaceC2170e
    /* renamed from: c */
    public String mo14452c() {
        InterfaceC2165a interfaceC2165a;
        InterfaceC2246b interfaceC2246b;
        Iterator<? extends InterfaceC2165a> it = mo14219a().iterator();
        while (true) {
            if (!it.hasNext()) {
                interfaceC2165a = null;
                break;
            }
            interfaceC2165a = it.next();
            if (interfaceC2165a.mo14672b().equals("Ldalvik/annotation/Signature;")) {
                break;
            }
        }
        if (interfaceC2165a == null) {
            return null;
        }
        Iterator<? extends InterfaceC2175b> it2 = interfaceC2165a.mo14673c().iterator();
        while (true) {
            if (!it2.hasNext()) {
                interfaceC2246b = null;
                break;
            }
            InterfaceC2175b next = it2.next();
            if (next.mo14692a().equals("value")) {
                InterfaceC2251g mo14693b = next.mo14693b();
                if (mo14693b.mo14430a() != 28) {
                    return null;
                }
                interfaceC2246b = (InterfaceC2246b) mo14693b;
            }
        }
        if (interfaceC2246b == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (InterfaceC2251g interfaceC2251g : interfaceC2246b.mo14733b()) {
            if (interfaceC2251g.mo14430a() != 23) {
                return null;
            }
            sb.append(((InterfaceC2262r) interfaceC2251g).mo14742b());
        }
        return sb.toString();
    }
}
