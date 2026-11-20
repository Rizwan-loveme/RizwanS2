package com.p129f.p130a.p132b;

import com.p129f.p130a.p131a.InterfaceC1127v;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: LongAddables.java */
/* renamed from: com.f.a.b.i */
/* loaded from: classes.dex */
final class C1139i {

    /* renamed from: a */
    private static final InterfaceC1127v<InterfaceC1138h> f7744a;

    static {
        InterfaceC1127v<InterfaceC1138h> interfaceC1127v;
        try {
            new C1140j();
            interfaceC1127v = new InterfaceC1127v<InterfaceC1138h>() { // from class: com.f.a.b.i.1
                @Override // com.p129f.p130a.p131a.InterfaceC1127v
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public InterfaceC1138h mo9592a() {
                    return new C1140j();
                }
            };
        } catch (Throwable th) {
            interfaceC1127v = new InterfaceC1127v<InterfaceC1138h>() { // from class: com.f.a.b.i.2
                @Override // com.p129f.p130a.p131a.InterfaceC1127v
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public InterfaceC1138h mo9592a() {
                    return new a();
                }
            };
        }
        f7744a = interfaceC1127v;
    }

    /* renamed from: a */
    public static InterfaceC1138h m9779a() {
        return f7744a.mo9592a();
    }

    /* compiled from: LongAddables.java */
    /* renamed from: com.f.a.b.i$a */
    private static final class a extends AtomicLong implements InterfaceC1138h {
        private a() {
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1138h
        /* renamed from: a */
        public void mo9777a() {
            getAndIncrement();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1138h
        /* renamed from: a */
        public void mo9778a(long j) {
            getAndAdd(j);
        }
    }
}
