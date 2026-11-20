package com.p140g.p152b.p153a.p156c;

import com.p140g.p141a.C1241c;
import com.p140g.p152b.p153a.C1323b;
import com.p140g.p152b.p153a.C1365f;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import com.p140g.p152b.p153a.p154a.C1307e;
import com.p140g.p152b.p153a.p154a.C1308f;
import com.p140g.p152b.p153a.p154a.C1310h;
import com.p140g.p152b.p153a.p154a.C1312j;
import com.p140g.p152b.p153a.p154a.C1319q;
import com.p140g.p152b.p153a.p154a.C1320r;

/* compiled from: MultiArrayTransformer.java */
/* renamed from: com.g.b.a.c.h */
/* loaded from: classes.dex */
public class C1352h extends AbstractC1357m {
    @Override // com.p140g.p152b.p153a.p156c.AbstractC1357m
    /* renamed from: a */
    public boolean mo10610a(C1323b c1323b) {
        boolean[] zArr = {false};
        new C1365f(this, zArr) { // from class: com.g.b.a.c.h.1

            /* renamed from: a */
            private final C1352h f8730a;

            /* renamed from: b */
            private final boolean[] f8731b;

            {
                this.f8730a = this;
                this.f8731b = zArr;
            }

            @Override // com.p140g.p152b.p153a.C1365f
            /* renamed from: a */
            public AbstractC1322t mo10678a(AbstractC1322t abstractC1322t) {
                String str;
                if (abstractC1322t.f8563h == AbstractC1322t.e.CHECK_CAST) {
                    C1320r c1320r = (C1320r) abstractC1322t;
                    if (c1320r.f8564d.f8563h == AbstractC1322t.e.CHECK_CAST) {
                        C1320r c1320r2 = (C1320r) c1320r.f8564d;
                        if (c1320r.f8557a.equals(c1320r2.f8557a)) {
                            abstractC1322t = c1320r2;
                        }
                    }
                }
                AbstractC1322t mo10678a = super.mo10678a(abstractC1322t);
                if (mo10678a.f8563h == AbstractC1322t.e.CHECK_CAST) {
                    C1320r c1320r3 = (C1320r) mo10678a;
                    if (c1320r3.f8557a.charAt(0) == '[') {
                        AbstractC1322t g = c1320r3.mo10544g();
                        if (g.f8563h == AbstractC1322t.e.INVOKE_STATIC) {
                            C1312j c1312j = (C1312j) g;
                            if (c1312j.m10538e().equals("newInstance") && c1312j.m10536c().equals("Ljava/lang/reflect/Array;") && c1312j.m10539f().length == 2 && c1312j.m10539f()[0].equals("Ljava/lang/Class;")) {
                                AbstractC1322t abstractC1322t2 = c1312j.mo10547j()[0];
                                String str2 = (String) null;
                                if (abstractC1322t2.f8563h == AbstractC1322t.e.CONSTANT) {
                                    str = ((C1241c) ((C1307e) c1312j.mo10547j()[0]).f8534b).f8048a;
                                } else {
                                    if (abstractC1322t2.f8563h == AbstractC1322t.e.STATIC_FIELD) {
                                        C1319q c1319q = (C1319q) abstractC1322t2;
                                        if (c1319q.f8555b.startsWith("Ljava/lang/") && c1319q.f8554a.equals("TYPE")) {
                                            String str3 = c1319q.f8555b;
                                            if (str3.equals("Ljava/lang/Boolean;")) {
                                                str = "Z";
                                            } else if (str3.equals("Ljava/lang/Byte;")) {
                                                str = "B";
                                            } else if (str3.equals("Ljava/lang/Short;")) {
                                                str = "S";
                                            } else if (str3.equals("Ljava/lang/Character;")) {
                                                str = "C";
                                            } else if (str3.equals("Ljava/lang/Integer;")) {
                                                str = "I";
                                            } else if (str3.equals("Ljava/lang/Long;")) {
                                                str = "J";
                                            } else if (str3.equals("Ljava/lang/Float;")) {
                                                str = "F";
                                            } else if (str3.equals("Ljava/lang/Double;")) {
                                                str = "D";
                                            } else {
                                                str = str3.equals("Ljava/lang/Void;") ? "V" : str2;
                                            }
                                        }
                                    }
                                    str = str2;
                                }
                                if (str != null) {
                                    AbstractC1322t abstractC1322t3 = c1312j.mo10547j()[1];
                                    if (c1312j.m10539f()[1].equals("I")) {
                                        if (c1320r3.f8557a.equals(new StringBuffer().append("[").append(str).toString())) {
                                            int i = 0;
                                            while (str.charAt(i) == '[') {
                                                i++;
                                            }
                                            this.f8731b[0] = true;
                                            if (i > 0) {
                                                return C1308f.m10497a(str.substring(i), i + 1, new AbstractC1322t[]{abstractC1322t3});
                                            }
                                            return C1308f.m10502a(str, abstractC1322t3);
                                        }
                                        return mo10678a;
                                    }
                                    if (abstractC1322t3.f8563h == AbstractC1322t.e.FILLED_ARRAY) {
                                        C1310h c1310h = (C1310h) abstractC1322t3;
                                        int length = c1310h.mo10547j().length;
                                        if (c1320r3.f8557a.length() > length && c1320r3.f8557a.substring(length).equals(str)) {
                                            int i2 = 0;
                                            while (str.charAt(i2) == '[') {
                                                i2++;
                                            }
                                            this.f8731b[0] = true;
                                            return C1308f.m10497a(str.substring(i2), i2 + length, c1310h.mo10547j());
                                        }
                                        return mo10678a;
                                    }
                                    return mo10678a;
                                }
                                return mo10678a;
                            }
                            return mo10678a;
                        }
                        return mo10678a;
                    }
                    return mo10678a;
                }
                return mo10678a;
            }
        }.m10765a(c1323b);
        return zArr[0];
    }
}
