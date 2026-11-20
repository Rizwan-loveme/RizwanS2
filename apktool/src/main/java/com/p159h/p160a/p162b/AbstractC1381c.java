package com.p159h.p160a.p162b;

import ru.maximoff.apktool.util.C3255o;

/* compiled from: ColorScheme.java */
/* renamed from: com.h.a.b.c */
/* loaded from: classes.dex */
public abstract class AbstractC1381c {
    /* renamed from: a */
    public abstract int mo11008a();

    /* compiled from: ColorScheme.java */
    /* renamed from: com.h.a.b.c$a */
    public static class a {

        /* renamed from: a */
        public static a f8995a = new a("FOREGROUND");

        /* renamed from: b */
        public static a f8996b = new a("BACKGROUND");

        /* renamed from: c */
        public static a f8997c = new a("SELECTION_FOREGROUND");

        /* renamed from: d */
        public static a f8998d = new a("SELECTION_BACKGROUND");

        /* renamed from: e */
        public static a f8999e = new a("CARET_BACKGROUND");

        /* renamed from: f */
        public static a f9000f = new a("CARET_DISABLED");

        /* renamed from: g */
        public static a f9001g = new a("LINE_HIGHLIGHT");

        /* renamed from: h */
        public static a f9002h = new a("NON_PRINTING_GLYPH");

        /* renamed from: i */
        public static a f9003i = new a("COMMENT");

        /* renamed from: j */
        public static a f9004j = new a("KEYWORD");

        /* renamed from: k */
        public static a f9005k = new a("NAME");

        /* renamed from: l */
        public static a f9006l = new a("LITERAL");

        /* renamed from: m */
        public static a f9007m = new a("OPERATOR");

        /* renamed from: n */
        public static a f9008n = new a("SEPARATOR");

        /* renamed from: o */
        public static a f9009o = new a("PACKAGE");

        /* renamed from: p */
        public static a f9010p = new a("TYPE");

        /* renamed from: q */
        public static a f9011q = new a("LINENUMBER_BG");

        /* renamed from: r */
        public static a f9012r = new a("LINENUMBER_FG");

        /* renamed from: s */
        public static a f9013s = new a("ERROR");

        /* renamed from: t */
        public static a f9014t = new a("HEXHL");

        /* renamed from: u */
        final int f9015u;

        /* renamed from: v */
        final int f9016v;

        /* renamed from: w */
        final int f9017w;

        a(String str) {
            new C3255o();
            this.f9015u = C3255o.m19514a(str, 0);
            this.f9016v = C3255o.m19514a(str, 1);
            this.f9017w = C3255o.m19514a(str, 2);
        }

        /* renamed from: a */
        public static void m11011a() {
            f8995a = new a("FOREGROUND");
            f8996b = new a("BACKGROUND");
            f8997c = new a("SELECTION_FOREGROUND");
            f8998d = new a("SELECTION_BACKGROUND");
            f8999e = new a("CARET_BACKGROUND");
            f9000f = new a("CARET_DISABLED");
            f9001g = new a("LINE_HIGHLIGHT");
            f9002h = new a("NON_PRINTING_GLYPH");
            f9003i = new a("COMMENT");
            f9004j = new a("KEYWORD");
            f9005k = new a("NAME");
            f9006l = new a("LITERAL");
            f9007m = new a("OPERATOR");
            f9008n = new a("SEPARATOR");
            f9009o = new a("PACKAGE");
            f9010p = new a("TYPE");
            f9011q = new a("LINENUMBER_BG");
            f9012r = new a("LINENUMBER_FG");
            f9013s = new a("ERROR");
            f9014t = new a("HEXHL");
        }
    }

    /* renamed from: a */
    public int m11009a(a aVar) {
        switch (mo11008a()) {
            case 1:
                return aVar.f9016v;
            case 2:
                return aVar.f9017w;
            default:
                return aVar.f9015u;
        }
    }

    /* renamed from: a */
    public int m11010a(a aVar, int i) {
        switch (i) {
            case 1:
                return aVar.f9016v;
            case 2:
                return aVar.f9017w;
            default:
                return aVar.f9015u;
        }
    }
}
