package org.p226d.p233b.p256f.p260d;

import com.p129f.p130a.p133c.AbstractC1208w;
import org.p226d.p269d.AbstractC2455i;

/* compiled from: CharSequenceConverter.java */
/* renamed from: org.d.b.f.d.a */
/* loaded from: classes.dex */
public final class C2331a {

    /* renamed from: a */
    private static final AbstractC2455i<String, CharSequence> f12579a = new AbstractC2455i<String, CharSequence>() { // from class: org.d.b.f.d.a.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public boolean mo14890b(CharSequence charSequence) {
            return charSequence instanceof String;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public String mo14889a(CharSequence charSequence) {
            return charSequence.toString();
        }
    };

    /* renamed from: a */
    public static AbstractC1208w<String> m14968a(Iterable<? extends CharSequence> iterable) {
        return f12579a.m15525a(iterable);
    }
}
