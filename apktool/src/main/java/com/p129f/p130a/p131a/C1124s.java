package com.p129f.p130a.p131a;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Splitter.java */
/* renamed from: com.f.a.a.s */
/* loaded from: classes.dex */
public final class C1124s {

    /* renamed from: a */
    private final AbstractC1109d f7544a;

    /* renamed from: b */
    private final boolean f7545b;

    /* renamed from: c */
    private final c f7546c;

    /* renamed from: d */
    private final int f7547d;

    /* compiled from: Splitter.java */
    /* renamed from: com.f.a.a.s$c */
    private interface c {
        /* renamed from: b */
        Iterator<String> mo9577b(C1124s c1124s, CharSequence charSequence);
    }

    private C1124s(c cVar) {
        this(cVar, false, AbstractC1109d.m9504a(), Integer.MAX_VALUE);
    }

    private C1124s(c cVar, boolean z, AbstractC1109d abstractC1109d, int i) {
        this.f7546c = cVar;
        this.f7545b = z;
        this.f7544a = abstractC1109d;
        this.f7547d = i;
    }

    /* renamed from: a */
    public static C1124s m9565a(char c2) {
        return m9566a(AbstractC1109d.m9505a(c2));
    }

    /* renamed from: a */
    public static C1124s m9566a(final AbstractC1109d abstractC1109d) {
        C1120o.m9547a(abstractC1109d);
        return new C1124s(new c() { // from class: com.f.a.a.s.1
            @Override // com.p129f.p130a.p131a.C1124s.c
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b mo9577b(C1124s c1124s, CharSequence charSequence) {
                return new b(c1124s, charSequence) { // from class: com.f.a.a.s.1.1
                    @Override // com.p129f.p130a.p131a.C1124s.b
                    /* renamed from: a */
                    int mo9578a(int i) {
                        return AbstractC1109d.this.mo9508a(this.f7554b, i);
                    }

                    @Override // com.p129f.p130a.p131a.C1124s.b
                    /* renamed from: b */
                    int mo9579b(int i) {
                        return i + 1;
                    }
                };
            }
        });
    }

    /* renamed from: a */
    public C1124s m9573a() {
        return new C1124s(this.f7546c, true, this.f7544a, this.f7547d);
    }

    /* renamed from: a */
    public C1124s m9574a(int i) {
        C1120o.m9552a(i > 0, "must be greater than zero: %s", i);
        return new C1124s(this.f7546c, this.f7545b, this.f7544a, i);
    }

    /* renamed from: a */
    public Iterable<String> m9575a(final CharSequence charSequence) {
        C1120o.m9547a(charSequence);
        return new Iterable<String>() { // from class: com.f.a.a.s.2
            @Override // java.lang.Iterable
            public Iterator<String> iterator() {
                return C1124s.this.m9569b(charSequence);
            }

            public String toString() {
                return C1114i.m9521a(", ").m9526a(new StringBuilder().append('['), this).append(']').toString();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public Iterator<String> m9569b(CharSequence charSequence) {
        return this.f7546c.mo9577b(this, charSequence);
    }

    /* renamed from: a */
    public a m9572a(C1124s c1124s) {
        return new a(c1124s);
    }

    /* compiled from: Splitter.java */
    /* renamed from: com.f.a.a.s$a */
    public static final class a {

        /* renamed from: a */
        private final C1124s f7552a;

        /* renamed from: b */
        private final C1124s f7553b;

        private a(C1124s c1124s, C1124s c1124s2) {
            this.f7552a = c1124s;
            this.f7553b = (C1124s) C1120o.m9547a(c1124s2);
        }

        /* renamed from: a */
        public Map<String, String> m9580a(CharSequence charSequence) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : this.f7552a.m9575a(charSequence)) {
                Iterator m9569b = this.f7553b.m9569b(str);
                C1120o.m9553a(m9569b.hasNext(), "Chunk [%s] is not a valid entry", str);
                String str2 = (String) m9569b.next();
                C1120o.m9553a(!linkedHashMap.containsKey(str2), "Duplicate key [%s] found.", str2);
                C1120o.m9553a(m9569b.hasNext(), "Chunk [%s] is not a valid entry", str);
                linkedHashMap.put(str2, (String) m9569b.next());
                C1120o.m9553a(!m9569b.hasNext(), "Chunk [%s] is not a valid entry", str);
            }
            return Collections.unmodifiableMap(linkedHashMap);
        }
    }

    /* compiled from: Splitter.java */
    /* renamed from: com.f.a.a.s$b */
    private static abstract class b extends AbstractC1107b<String> {

        /* renamed from: b */
        final CharSequence f7554b;

        /* renamed from: c */
        final AbstractC1109d f7555c;

        /* renamed from: d */
        final boolean f7556d;

        /* renamed from: e */
        int f7557e = 0;

        /* renamed from: f */
        int f7558f;

        /* renamed from: a */
        abstract int mo9578a(int i);

        /* renamed from: b */
        abstract int mo9579b(int i);

        protected b(C1124s c1124s, CharSequence charSequence) {
            this.f7555c = c1124s.f7544a;
            this.f7556d = c1124s.f7545b;
            this.f7558f = c1124s.f7547d;
            this.f7554b = charSequence;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.p129f.p130a.p131a.AbstractC1107b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public String mo9500a() {
            int i = this.f7557e;
            while (this.f7557e != -1) {
                int mo9578a = mo9578a(this.f7557e);
                if (mo9578a == -1) {
                    mo9578a = this.f7554b.length();
                    this.f7557e = -1;
                } else {
                    this.f7557e = mo9579b(mo9578a);
                }
                if (this.f7557e == i) {
                    this.f7557e++;
                    if (this.f7557e > this.f7554b.length()) {
                        this.f7557e = -1;
                    }
                } else {
                    int i2 = i;
                    while (i2 < mo9578a && this.f7555c.mo9510b(this.f7554b.charAt(i2))) {
                        i2++;
                    }
                    int i3 = mo9578a;
                    while (i3 > i2 && this.f7555c.mo9510b(this.f7554b.charAt(i3 - 1))) {
                        i3--;
                    }
                    if (this.f7556d && i2 == i3) {
                        i = this.f7557e;
                    } else {
                        if (this.f7558f == 1) {
                            i3 = this.f7554b.length();
                            this.f7557e = -1;
                            while (i3 > i2 && this.f7555c.mo9510b(this.f7554b.charAt(i3 - 1))) {
                                i3--;
                            }
                        } else {
                            this.f7558f--;
                        }
                        return this.f7554b.subSequence(i2, i3).toString();
                    }
                }
            }
            return m9501b();
        }
    }
}
