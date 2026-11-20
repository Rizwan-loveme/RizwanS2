package org.p210a.p211a.p212a.p215c;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: DoubleKeyMap.java */
/* renamed from: org.a.a.a.c.c */
/* loaded from: classes.dex */
public class C1833c<Key1, Key2, Value> {

    /* renamed from: a */
    Map<Key1, Map<Key2, Value>> f10887a = new LinkedHashMap();

    /* renamed from: a */
    public Value m13729a(Key1 key1, Key2 key2, Value value) {
        Map<Key2, Value> map = this.f10887a.get(key1);
        Value value2 = null;
        if (map == null) {
            map = new LinkedHashMap<>();
            this.f10887a.put(key1, map);
        } else {
            value2 = map.get(key2);
        }
        map.put(key2, value);
        return value2;
    }

    /* renamed from: a */
    public Value m13728a(Key1 key1, Key2 key2) {
        Map<Key2, Value> map = this.f10887a.get(key1);
        if (map == null) {
            return null;
        }
        return map.get(key2);
    }
}
