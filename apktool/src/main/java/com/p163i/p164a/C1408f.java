package com.p163i.p164a;

import java.util.HashMap;
import java.util.Map;

/* compiled from: FastClonerHashMap.java */
/* renamed from: com.i.a.f */
/* loaded from: classes.dex */
public class C1408f implements InterfaceC1414l {
    @Override // com.p163i.p164a.InterfaceC1414l
    /* renamed from: a */
    public Object mo11217a(Object obj, InterfaceC1412j interfaceC1412j, Map<Object, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : ((HashMap) obj).entrySet()) {
            hashMap.put(interfaceC1412j.mo11216a(entry.getKey(), map), interfaceC1412j.mo11216a(entry.getValue(), map));
        }
        return hashMap;
    }
}
