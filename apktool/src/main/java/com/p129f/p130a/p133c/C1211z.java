package com.p129f.p130a.p133c;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.p129f.p130a.p131a.C1120o;
import com.p129f.p130a.p131a.InterfaceC1112g;
import com.p129f.p130a.p133c.AbstractC1208w;
import com.p129f.p130a.p133c.C1181bg;
import java.lang.Comparable;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: ImmutableRangeMap.java */
/* renamed from: com.f.a.c.z */
/* loaded from: classes.dex */
public class C1211z<K extends Comparable<?>, V> implements InterfaceC1168au<K, V>, Serializable {

    /* renamed from: a */
    private static final C1211z<Comparable<?>, Object> f7973a = new C1211z<>(AbstractC1208w.m10138g(), AbstractC1208w.m10138g());

    /* renamed from: b */
    private final transient AbstractC1208w<C1166as<K>> f7974b;

    /* renamed from: c */
    private final transient AbstractC1208w<V> f7975c;

    /* renamed from: a */
    public static <K extends Comparable<?>, V> a<K, V> m10153a() {
        return new a<>();
    }

    /* compiled from: ImmutableRangeMap.java */
    /* renamed from: com.f.a.c.z$a */
    public static final class a<K extends Comparable<?>, V> {

        /* renamed from: a */
        private final List<Map.Entry<C1166as<K>, V>> f7976a = C1156ai.m9909a();

        @CanIgnoreReturnValue
        /* renamed from: a */
        public a<K, V> m10155a(C1166as<K> c1166as, V v) {
            C1120o.m9547a(c1166as);
            C1120o.m9547a(v);
            C1120o.m9553a(!c1166as.m9979d(), "Range must not be empty, but was %s", c1166as);
            this.f7976a.add(C1157aj.m9930a(c1166as, v));
            return this;
        }

        /* renamed from: a */
        public C1211z<K, V> m10156a() {
            Collections.sort(this.f7976a, C1166as.m9970b().m9962d());
            AbstractC1208w.a aVar = new AbstractC1208w.a(this.f7976a.size());
            AbstractC1208w.a aVar2 = new AbstractC1208w.a(this.f7976a.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f7976a.size()) {
                    C1166as<K> key = this.f7976a.get(i2).getKey();
                    if (i2 > 0) {
                        C1166as<K> key2 = this.f7976a.get(i2 - 1).getKey();
                        if (key.m9976a(key2) && !key.m9977b(key2).m9979d()) {
                            throw new IllegalArgumentException("Overlapping ranges: range " + key2 + " overlaps with entry " + key);
                        }
                    }
                    aVar.mo9809a(key);
                    aVar2.mo9809a(this.f7976a.get(i2).getValue());
                    i = i2 + 1;
                } else {
                    return new C1211z<>(aVar.m10144a(), aVar2.m10144a());
                }
            }
        }
    }

    C1211z(AbstractC1208w<C1166as<K>> abstractC1208w, AbstractC1208w<V> abstractC1208w2) {
        this.f7974b = abstractC1208w;
        this.f7975c = abstractC1208w2;
    }

    @Override // com.p129f.p130a.p133c.InterfaceC1168au
    @NullableDecl
    /* renamed from: a */
    public V mo9982a(K k) {
        int m10012a = C1181bg.m10012a(this.f7974b, (InterfaceC1112g<? super E, AbstractC1202q>) C1166as.m9966a(), AbstractC1202q.m10100b(k), C1181bg.b.ANY_PRESENT, C1181bg.a.NEXT_LOWER);
        if (m10012a == -1) {
            return null;
        }
        return this.f7974b.get(m10012a).m9978c(k) ? this.f7975c.get(m10012a) : null;
    }

    @Override // com.p129f.p130a.p133c.InterfaceC1168au
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractC1209x<C1166as<K>, V> mo9983c() {
        if (this.f7974b.isEmpty()) {
            return AbstractC1209x.m10149i();
        }
        return new C1149ab(new C1173az(this.f7974b, C1166as.m9970b()), this.f7975c);
    }

    public int hashCode() {
        return mo9983c().hashCode();
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof InterfaceC1168au) {
            return mo9983c().equals(((InterfaceC1168au) obj).mo9983c());
        }
        return false;
    }

    public String toString() {
        return mo9983c().toString();
    }
}
