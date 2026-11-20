package com.p163i.p164a;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* compiled from: FastClonerLinkedList.java */
/* renamed from: com.i.a.h */
/* loaded from: classes.dex */
public class C1410h implements InterfaceC1414l {
    @Override // com.p163i.p164a.InterfaceC1414l
    /* renamed from: a */
    public Object mo11217a(Object obj, InterfaceC1412j interfaceC1412j, Map<Object, Object> map) {
        LinkedList linkedList = new LinkedList();
        Iterator<E> it = ((LinkedList) obj).iterator();
        while (it.hasNext()) {
            linkedList.add(interfaceC1412j.mo11216a(it.next(), map));
        }
        return linkedList;
    }
}
