package com.p163i.p164a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: FastClonerArrayList.java */
/* renamed from: com.i.a.c */
/* loaded from: classes.dex */
public class C1405c implements InterfaceC1414l {
    @Override // com.p163i.p164a.InterfaceC1414l
    /* renamed from: a */
    public Object mo11217a(Object obj, InterfaceC1412j interfaceC1412j, Map<Object, Object> map) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((ArrayList) obj).iterator();
        while (it.hasNext()) {
            arrayList.add(interfaceC1412j.mo11216a(it.next(), map));
        }
        return arrayList;
    }
}
