package com.p129f.p130a.p133c;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Multimaps.java */
/* renamed from: com.f.a.c.al */
/* loaded from: classes.dex */
public final class C1159al {
    /* renamed from: a */
    static boolean m9948a(InterfaceC1158ak<?, ?> interfaceC1158ak, @NullableDecl Object obj) {
        if (obj == interfaceC1158ak) {
            return true;
        }
        if (obj instanceof InterfaceC1158ak) {
            return interfaceC1158ak.mo9947b().equals(((InterfaceC1158ak) obj).mo9947b());
        }
        return false;
    }
}
