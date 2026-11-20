package ru.maximoff.apktool.util.p303a;

import java.io.File;
import java.util.Iterator;
import org.p270e.C2466a;
import org.p270e.C2467b;
import org.p270e.C2468c;

/* compiled from: JsonMerger.java */
/* renamed from: ru.maximoff.apktool.util.a.d */
/* loaded from: classes.dex */
public class C3064d {
    /* renamed from: a */
    public static C2468c m18352a(C2468c c2468c, C2468c c2468c2, String[] strArr) {
        if (c2468c == null) {
            return c2468c2;
        }
        if (c2468c2 != null) {
            Iterator<String> m15605a = c2468c2.m15605a();
            while (m15605a.hasNext()) {
                String next = m15605a.next();
                if (!m18354a(next, strArr)) {
                    if (c2468c.m15618g(next)) {
                        if (!c2468c2.m15619h(next)) {
                            Object m15602a = c2468c.m15602a(next);
                            Object m15602a2 = c2468c2.m15602a(next);
                            if (!m15602a.equals(m15602a2)) {
                                if (m15602a2 instanceof C2468c) {
                                    if (m15602a instanceof C2468c) {
                                        if (((C2468c) m15602a2).m15614d() != 0) {
                                            c2468c.m15608a(next, m18352a((C2468c) m15602a, (C2468c) m15602a2, strArr));
                                        }
                                    } else {
                                        c2468c.m15608a(next, c2468c2.m15602a(next));
                                    }
                                } else if (m15602a2 instanceof C2466a) {
                                    if (m15602a instanceof C2466a) {
                                        if (((C2466a) m15602a2).m15569a() != 0) {
                                            c2468c.m15608a(next, m18350a((C2466a) m15602a, (C2466a) m15602a2));
                                        }
                                    } else {
                                        c2468c.m15608a(next, c2468c2.m15602a(next));
                                    }
                                } else {
                                    c2468c.m15608a(next, c2468c2.m15602a(next));
                                }
                            }
                        }
                    } else {
                        c2468c.m15608a(next, c2468c2.m15602a(next));
                    }
                }
            }
            return c2468c;
        }
        return c2468c;
    }

    /* renamed from: a */
    public static C2466a m18350a(C2466a c2466a, C2466a c2466a2) {
        if (c2466a == null) {
            return c2466a2;
        }
        if (c2466a2 != null) {
            for (int i = 0; i < c2466a2.m15569a(); i++) {
                try {
                    if (!m18355a(c2466a, c2466a2.m15571a(i))) {
                        c2466a.m15574a(c2466a2.m15571a(i));
                    }
                } catch (C2467b e2) {
                }
            }
            return c2466a;
        }
        return c2466a;
    }

    /* renamed from: a */
    public static boolean m18355a(C2466a c2466a, Object obj) {
        for (int i = 0; i < c2466a.m15569a(); i++) {
            if (c2466a.m15571a(i).equals(obj)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static C2468c m18351a(File file) {
        String m18332i = C3061a.m18332i(file);
        if (m18332i.equals("")) {
            return (C2468c) null;
        }
        try {
            return new C2468c(m18332i);
        } catch (C2467b e2) {
            return (C2468c) null;
        }
    }

    /* renamed from: a */
    public static void m18353a(File file, C2468c c2468c, int i) {
        C3061a.m18319b(file, c2468c.m15603a(i));
    }

    /* renamed from: a */
    private static boolean m18354a(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }
}
