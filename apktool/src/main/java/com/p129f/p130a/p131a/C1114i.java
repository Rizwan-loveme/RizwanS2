package com.p129f.p130a.p131a;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.p209io.IOException;
import java.util.Iterator;

/* compiled from: Joiner.java */
/* renamed from: com.f.a.a.i */
/* loaded from: classes.dex */
public class C1114i {

    /* renamed from: a */
    private final String f7528a;

    /* renamed from: a */
    public static C1114i m9521a(String str) {
        return new C1114i(str);
    }

    /* renamed from: a */
    public static C1114i m9520a(char c2) {
        return new C1114i(String.valueOf(c2));
    }

    private C1114i(String str) {
        this.f7528a = (String) C1120o.m9547a(str);
    }

    @CanIgnoreReturnValue
    /* renamed from: a */
    public <A extends Appendable> A m9522a(A a2, Iterator<?> it) {
        C1120o.m9547a(a2);
        if (it.hasNext()) {
            a2.append(m9523a(it.next()));
            while (it.hasNext()) {
                a2.append(this.f7528a);
                a2.append(m9523a(it.next()));
            }
        }
        return a2;
    }

    @CanIgnoreReturnValue
    /* renamed from: a */
    public final StringBuilder m9526a(StringBuilder sb, Iterable<?> iterable) {
        return m9527a(sb, iterable.iterator());
    }

    @CanIgnoreReturnValue
    /* renamed from: a */
    public final StringBuilder m9527a(StringBuilder sb, Iterator<?> it) {
        try {
            m9522a((C1114i) sb, it);
            return sb;
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    /* renamed from: a */
    public final String m9524a(Iterable<?> iterable) {
        return m9525a(iterable.iterator());
    }

    /* renamed from: a */
    public final String m9525a(Iterator<?> it) {
        return m9527a(new StringBuilder(), it).toString();
    }

    /* renamed from: a */
    CharSequence m9523a(Object obj) {
        C1120o.m9547a(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}
