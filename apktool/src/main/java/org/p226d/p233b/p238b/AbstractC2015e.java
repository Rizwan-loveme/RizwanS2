package org.p226d.p233b.p238b;

import org.p226d.p233b.p250e.InterfaceC2265f;
import org.p226d.p233b.p250e.InterfaceC2271l;

/* compiled from: BaseTryBlock.java */
/* renamed from: org.d.b.b.e */
/* loaded from: classes.dex */
public abstract class AbstractC2015e<EH extends InterfaceC2265f> implements InterfaceC2271l<EH> {
    public boolean equals(Object obj) {
        if (!(obj instanceof InterfaceC2271l)) {
            return false;
        }
        InterfaceC2271l interfaceC2271l = (InterfaceC2271l) obj;
        return mo14514a() == interfaceC2271l.mo14514a() && mo14515b() == interfaceC2271l.mo14515b() && mo14516c().equals(interfaceC2271l.mo14516c());
    }
}
