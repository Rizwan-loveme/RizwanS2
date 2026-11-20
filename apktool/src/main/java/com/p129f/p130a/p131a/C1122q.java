package com.p129f.p130a.p131a;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Predicates.java */
/* renamed from: com.f.a.a.q */
/* loaded from: classes.dex */
public final class C1122q {
    /* renamed from: a */
    public static <T> InterfaceC1121p<T> m9563a() {
        return a.NOT_NULL.m9564a();
    }

    /* compiled from: Predicates.java */
    /* renamed from: com.f.a.a.q$a */
    enum a implements InterfaceC1121p<Object> {
        ALWAYS_TRUE { // from class: com.f.a.a.q.a.1
            @Override // com.p129f.p130a.p131a.InterfaceC1121p
            /* renamed from: a */
            public boolean mo9509a(@NullableDecl Object obj) {
                return true;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        },
        ALWAYS_FALSE { // from class: com.f.a.a.q.a.2
            @Override // com.p129f.p130a.p131a.InterfaceC1121p
            /* renamed from: a */
            public boolean mo9509a(@NullableDecl Object obj) {
                return false;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        },
        IS_NULL { // from class: com.f.a.a.q.a.3
            @Override // com.p129f.p130a.p131a.InterfaceC1121p
            /* renamed from: a */
            public boolean mo9509a(@NullableDecl Object obj) {
                return obj == null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.isNull()";
            }
        },
        NOT_NULL { // from class: com.f.a.a.q.a.4
            @Override // com.p129f.p130a.p131a.InterfaceC1121p
            /* renamed from: a */
            public boolean mo9509a(@NullableDecl Object obj) {
                return obj != null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.notNull()";
            }
        };

        /* renamed from: a */
        <T> InterfaceC1121p<T> m9564a() {
            return this;
        }
    }
}
