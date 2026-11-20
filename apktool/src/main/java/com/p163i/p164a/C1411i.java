package com.p163i.p164a;

import java.util.Map;
import java.util.TreeMap;

/* compiled from: FastClonerTreeMap.java */
/* renamed from: com.i.a.i */
/* loaded from: classes.dex */
public class C1411i implements InterfaceC1414l {
    @Override // com.p163i.p164a.InterfaceC1414l
    /* renamed from: a */
    public Object mo11217a(Object obj, InterfaceC1412j interfaceC1412j, Map<Object, Object> map) {
        TreeMap treeMap = (TreeMap) obj;
        TreeMap treeMap2 = new TreeMap(treeMap.comparator());
        for (Map.Entry entry : treeMap.entrySet()) {
            treeMap2.put(interfaceC1412j.mo11216a(entry.getKey(), map), interfaceC1412j.mo11216a(entry.getValue(), map));
        }
        return treeMap2;
    }
}
