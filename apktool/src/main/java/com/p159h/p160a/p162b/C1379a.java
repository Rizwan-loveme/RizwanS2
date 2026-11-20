package com.p159h.p160a.p162b;

/* compiled from: AutoIndent.java */
/* renamed from: com.h.a.b.a */
/* loaded from: classes.dex */
public class C1379a {
    /* renamed from: a */
    public static int m11005a(CharSequence charSequence) {
        C1394p c1394p = new C1394p(charSequence);
        int i = 0;
        while (true) {
            try {
                EnumC1395q m11125c = c1394p.m11125c();
                if (m11125c == null) {
                    break;
                }
                i += m11004a(m11125c);
            } catch (Error e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return i;
    }

    /* renamed from: a */
    private static int m11004a(EnumC1395q enumC1395q) {
        if (enumC1395q != EnumC1395q.DO && enumC1395q != EnumC1395q.FUNCTION && enumC1395q != EnumC1395q.THEN && enumC1395q != EnumC1395q.REPEAT && enumC1395q != EnumC1395q.LCURLY) {
            if (enumC1395q == EnumC1395q.UNTIL || enumC1395q == EnumC1395q.ELSEIF || enumC1395q == EnumC1395q.END || enumC1395q == EnumC1395q.RCURLY) {
                return -1;
            }
            return 0;
        }
        return 1;
    }
}
