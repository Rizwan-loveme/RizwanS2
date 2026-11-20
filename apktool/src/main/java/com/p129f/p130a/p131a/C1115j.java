package com.p129f.p130a.p131a;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: MoreObjects.java */
/* renamed from: com.f.a.a.j */
/* loaded from: classes.dex */
public final class C1115j {
    /* renamed from: a */
    public static <T> T m9529a(@NullableDecl T t, @NullableDecl T t2) {
        if (t == null) {
            if (t2 != null) {
                return t2;
            }
            throw new NullPointerException("Both parameters are null");
        }
        return t;
    }

    /* renamed from: a */
    public static a m9528a(Object obj) {
        return new a(obj.getClass().getSimpleName());
    }

    /* compiled from: MoreObjects.java */
    /* renamed from: com.f.a.a.j$a */
    public static final class a {

        /* renamed from: a */
        private final String f7529a;

        /* renamed from: b */
        private final C3337a f7530b;

        /* renamed from: c */
        private C3337a f7531c;

        /* renamed from: d */
        private boolean f7532d;

        private a(String str) {
            this.f7530b = new C3337a();
            this.f7531c = this.f7530b;
            this.f7532d = false;
            this.f7529a = (String) C1120o.m9547a(str);
        }

        @CanIgnoreReturnValue
        /* renamed from: a */
        public a m9536a(String str, @NullableDecl Object obj) {
            return m9532b(str, obj);
        }

        @CanIgnoreReturnValue
        /* renamed from: a */
        public a m9534a(String str, int i) {
            return m9532b(str, String.valueOf(i));
        }

        @CanIgnoreReturnValue
        /* renamed from: a */
        public a m9535a(String str, long j) {
            return m9532b(str, String.valueOf(j));
        }

        @CanIgnoreReturnValue
        /* renamed from: a */
        public a m9533a(@NullableDecl Object obj) {
            return m9531b(obj);
        }

        public String toString() {
            boolean z = this.f7532d;
            String str = "";
            StringBuilder append = new StringBuilder(32).append(this.f7529a).append('{');
            for (C3337a c3337a = this.f7530b.f7535c; c3337a != null; c3337a = c3337a.f7535c) {
                Object obj = c3337a.f7534b;
                if (!z || obj != null) {
                    append.append(str);
                    str = ", ";
                    if (c3337a.f7533a != null) {
                        append.append(c3337a.f7533a).append('=');
                    }
                    if (obj != null && obj.getClass().isArray()) {
                        append.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r4.length() - 1);
                    } else {
                        append.append(obj);
                    }
                }
            }
            return append.append('}').toString();
        }

        /* renamed from: a */
        private C3337a m9530a() {
            C3337a c3337a = new C3337a();
            this.f7531c.f7535c = c3337a;
            this.f7531c = c3337a;
            return c3337a;
        }

        /* renamed from: b */
        private a m9531b(@NullableDecl Object obj) {
            m9530a().f7534b = obj;
            return this;
        }

        /* renamed from: b */
        private a m9532b(String str, @NullableDecl Object obj) {
            C3337a m9530a = m9530a();
            m9530a.f7534b = obj;
            m9530a.f7533a = (String) C1120o.m9547a(str);
            return this;
        }

        /* compiled from: MoreObjects.java */
        /* renamed from: com.f.a.a.j$a$a, reason: collision with other inner class name */
        private static final class C3337a {

            /* renamed from: a */
            @NullableDecl
            String f7533a;

            /* renamed from: b */
            @NullableDecl
            Object f7534b;

            /* renamed from: c */
            @NullableDecl
            C3337a f7535c;

            private C3337a() {
            }
        }
    }
}
