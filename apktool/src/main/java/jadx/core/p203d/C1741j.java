package jadx.core.p203d;

import java.util.Map;

/* compiled from: MapUtils.java */
/* renamed from: jadx.core.d.j */
/* loaded from: classes.dex */
public class C1741j {
    /* renamed from: a */
    public static <K, V> V m13285a(Map<K, V> map, K k, InterfaceC1736e<K, V> interfaceC1736e) {
        V v = map.get(k);
        if (v == null) {
            V mo12561a = interfaceC1736e.mo12561a(k);
            map.put(k, mo12561a);
            return mo12561a;
        }
        return v;
    }
}
