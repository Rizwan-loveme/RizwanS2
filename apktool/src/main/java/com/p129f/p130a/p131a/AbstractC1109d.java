package com.p129f.p130a.p131a;

import ru.maximoff.apktool.util.C3112bn;

/* compiled from: CharMatcher.java */
/* renamed from: com.f.a.a.d */
/* loaded from: classes.dex */
public abstract class AbstractC1109d implements InterfaceC1121p<Character> {
    /* renamed from: b */
    public abstract boolean mo9510b(char c2);

    /* renamed from: a */
    public static AbstractC1109d m9504a() {
        return d.f7523a;
    }

    /* renamed from: a */
    public static AbstractC1109d m9505a(char c2) {
        return new b(c2);
    }

    protected AbstractC1109d() {
    }

    /* renamed from: a */
    public int mo9508a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        C1120o.m9555b(i, length);
        for (int i2 = i; i2 < length; i2++) {
            if (mo9510b(charSequence.charAt(i2))) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.p129f.p130a.p131a.InterfaceC1121p
    @Deprecated
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo9509a(Character ch) {
        return mo9510b(ch.charValue());
    }

    public String toString() {
        return super.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static String m9507d(char c2) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = C3112bn.f18384b.charAt(c2 & 15);
            c2 = (char) (c2 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    /* compiled from: CharMatcher.java */
    /* renamed from: com.f.a.a.d$a */
    static abstract class a extends AbstractC1109d {
        a() {
        }

        @Override // com.p129f.p130a.p131a.AbstractC1109d, com.p129f.p130a.p131a.InterfaceC1121p
        @Deprecated
        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo9509a(Character ch) {
            return super.mo9509a(ch);
        }
    }

    /* compiled from: CharMatcher.java */
    /* renamed from: com.f.a.a.d$c */
    static abstract class c extends a {

        /* renamed from: a */
        private final String f7522a;

        c(String str) {
            this.f7522a = (String) C1120o.m9547a(str);
        }

        @Override // com.p129f.p130a.p131a.AbstractC1109d
        public final String toString() {
            return this.f7522a;
        }
    }

    /* compiled from: CharMatcher.java */
    /* renamed from: com.f.a.a.d$d */
    private static final class d extends c {

        /* renamed from: a */
        static final d f7523a = new d();

        private d() {
            super("CharMatcher.none()");
        }

        @Override // com.p129f.p130a.p131a.AbstractC1109d
        /* renamed from: b */
        public boolean mo9510b(char c2) {
            return false;
        }

        @Override // com.p129f.p130a.p131a.AbstractC1109d
        /* renamed from: a */
        public int mo9508a(CharSequence charSequence, int i) {
            C1120o.m9555b(i, charSequence.length());
            return -1;
        }
    }

    /* compiled from: CharMatcher.java */
    /* renamed from: com.f.a.a.d$b */
    private static final class b extends a {

        /* renamed from: a */
        private final char f7521a;

        b(char c2) {
            this.f7521a = c2;
        }

        @Override // com.p129f.p130a.p131a.AbstractC1109d
        /* renamed from: b */
        public boolean mo9510b(char c2) {
            return c2 == this.f7521a;
        }

        @Override // com.p129f.p130a.p131a.AbstractC1109d
        public String toString() {
            return "CharMatcher.is('" + AbstractC1109d.m9507d(this.f7521a) + "')";
        }
    }
}
