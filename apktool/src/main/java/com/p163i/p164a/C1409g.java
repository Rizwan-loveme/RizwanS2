package com.p163i.p164a;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: FastClonerHashSet.java */
/* renamed from: com.i.a.g */
/* loaded from: classes.dex */
public class C1409g implements InterfaceC1414l {
    @Override // com.p163i.p164a.InterfaceC1414l
    /* renamed from: a */
    public Object mo11217a(Object obj, InterfaceC1412j interfaceC1412j, Map<Object, Object> map) {
        HashSet hashSet = new HashSet();
        Iterator it = ((HashSet) obj).iterator();
        while (it.hasNext()) {
            hashSet.add(interfaceC1412j.mo11216a(it.next(), map));
        }
        return hashSet;
    }
}
