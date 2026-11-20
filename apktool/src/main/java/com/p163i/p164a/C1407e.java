package com.p163i.p164a;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: FastClonerConcurrentHashMap.java */
/* renamed from: com.i.a.e */
/* loaded from: classes.dex */
public class C1407e implements InterfaceC1414l {
    @Override // com.p163i.p164a.InterfaceC1414l
    /* renamed from: a */
    public Object mo11217a(Object obj, InterfaceC1412j interfaceC1412j, Map<Object, Object> map) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry entry : ((ConcurrentHashMap) obj).entrySet()) {
            concurrentHashMap.put(interfaceC1412j.mo11216a(entry.getKey(), map), interfaceC1412j.mo11216a(entry.getValue(), map));
        }
        return concurrentHashMap;
    }
}
