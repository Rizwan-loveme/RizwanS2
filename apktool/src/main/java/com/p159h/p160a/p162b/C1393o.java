package com.p159h.p160a.p162b;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: LinearSearchStrategy.java */
/* renamed from: com.h.a.b.o */
/* loaded from: classes.dex */
public class C1393o {

    /* renamed from: a */
    private int f9046a = 0;

    /* renamed from: b */
    private final AbstractC1389k f9047b;

    public C1393o(AbstractC1389k abstractC1389k) {
        this.f9047b = abstractC1389k;
    }

    /* renamed from: a */
    public int[] m11105a(C1386h c1386h, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        int[] m11104a = m11104a(c1386h, str, i, c1386h.m11055h(), z, z2, z3);
        if (m11104a[0] < 0 && z4) {
            return m11104a(c1386h, str, 0, i, z, z2, z3);
        }
        return m11104a;
    }

    /* renamed from: a */
    public int m11101a(C1386h c1386h, String str, boolean z, boolean z2) {
        int i = 0;
        if (z2) {
            str = new StringBuffer().append(new StringBuffer().append("\\b").append(str).toString()).append("\\b").toString();
        }
        int i2 = 8;
        if (!z) {
            i2 = 10;
        }
        try {
            while (Pattern.compile(str, i2).matcher(c1386h.toString()).find()) {
                i++;
            }
        } catch (Exception e2) {
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x009e, code lost:
    
        r1[0] = r7;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int[] m11104a(C1386h c1386h, String str, int i, int i2, boolean z, boolean z2, boolean z3) {
        int[] iArr = {-1, str.length()};
        if (str.length() == 0) {
            return iArr;
        }
        if (i < 0) {
            C1401w.m11173a("TextBuffer.find: Invalid start position");
            i = 0;
        }
        if (i2 > c1386h.m11055h()) {
            C1401w.m11173a("TextBuffer.find: Invalid end position");
            i2 = c1386h.m11055h();
        }
        if (z3) {
            if (z2) {
                str = new StringBuffer().append(new StringBuffer().append("\\b").append(str).toString()).append("\\b").toString();
            }
            int i3 = 8;
            if (!z) {
                i3 = 10;
            }
            try {
                Matcher matcher = Pattern.compile(str, i3).matcher(c1386h.toString());
                if (matcher.find(i)) {
                    this.f9046a = matcher.start();
                    iArr[0] = matcher.start();
                    iArr[1] = matcher.end() - matcher.start();
                }
            } catch (Exception e2) {
            }
            return iArr;
        }
        int min = Math.min(i2, (c1386h.m11055h() - str.length()) + 1);
        while (i < min && (!m11103a(c1386h, str, i, z) || (z2 && !m11102a(c1386h, i, str.length())))) {
            i++;
            this.f9046a++;
        }
        return iArr;
    }

    /* renamed from: b */
    public int[] m11108b(C1386h c1386h, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        int[] m11107b = m11107b(c1386h, str, i, -1, z, z2, z3);
        if (m11107b[0] < 0 && z4) {
            return m11107b(c1386h, str, c1386h.m11055h() - 1, i, z, z2, z3);
        }
        return m11107b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x009d, code lost:
    
        r0[0] = r1;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int[] m11107b(C1386h c1386h, String str, int i, int i2, boolean z, boolean z2, boolean z3) {
        int[] iArr = {-1, str.length()};
        if (str.length() != 0) {
            if (i >= c1386h.m11055h()) {
                C1401w.m11173a("Invalid start position given to TextBuffer.find");
                i = c1386h.m11055h() - 1;
            }
            if (i2 < -1) {
                C1401w.m11173a("Invalid end position given to TextBuffer.find");
                i2 = -1;
            }
            if (z3) {
                if (z2) {
                    str = new StringBuffer().append(new StringBuffer().append("\\b").append(str).toString()).append("\\b").toString();
                }
                int i3 = 8;
                if (!z) {
                    i3 = 10;
                }
                try {
                    Matcher matcher = Pattern.compile(str, i3).matcher(c1386h.toString());
                    while (matcher.find() && matcher.start() <= i) {
                        iArr[0] = matcher.start();
                        iArr[1] = matcher.end() - matcher.start();
                    }
                } catch (Exception e2) {
                }
            } else {
                int min = Math.min(i, c1386h.m11055h() - str.length());
                while (min > i2 && (!m11103a(c1386h, str, min, z) || (z2 && !m11102a(c1386h, min, str.length())))) {
                    min--;
                }
            }
        }
        return iArr;
    }

    /* renamed from: a */
    public int m11100a(C1386h c1386h, String str, String str2, int i, boolean z, boolean z2, boolean z3) {
        if (z3) {
            if (z2) {
                str = new StringBuffer().append(new StringBuffer().append("\\b").append(str).toString()).append("\\b").toString();
            }
            int i2 = 8;
            if (!z) {
                i2 = 10;
            }
            try {
                Pattern compile = Pattern.compile(str, i2);
                Matcher matcher = compile.matcher(c1386h.toString());
                if (!matcher.find(i)) {
                    return -1;
                }
                try {
                    str2 = compile.matcher(matcher.group()).replaceFirst(str2);
                } catch (Exception e2) {
                }
                long nanoTime = System.nanoTime();
                c1386h.m11048d();
                c1386h.m11035a(matcher.start(), matcher.end() - matcher.start(), nanoTime);
                c1386h.m11041a(str2.toCharArray(), matcher.start(), nanoTime);
                c1386h.m11050e();
                return matcher.start();
            } catch (Exception e3) {
                return -1;
            }
        }
        int[] m11104a = m11104a(c1386h, str, i, c1386h.m11055h(), z, z2, z3);
        if (m11104a[0] == -1) {
            return m11104a[0];
        }
        char[] charArray = str2.toCharArray();
        long nanoTime2 = System.nanoTime();
        c1386h.m11048d();
        c1386h.m11035a(m11104a[0], m11104a[1], nanoTime2);
        c1386h.m11041a(charArray, m11104a[0], nanoTime2);
        c1386h.m11050e();
        return m11104a[0];
    }

    /* renamed from: b */
    public C1397s m11106b(C1386h c1386h, String str, String str2, int i, boolean z, boolean z2, boolean z3) {
        int i2;
        int i3;
        int i4 = 0;
        this.f9046a = 0;
        if (z3) {
            if (z2) {
                str = new StringBuffer().append(new StringBuffer().append("\\b").append(str).toString()).append("\\b").toString();
            }
            int i5 = 8;
            if (!z) {
                i5 = 10;
            }
            long nanoTime = System.nanoTime();
            c1386h.m11048d();
            try {
                StringBuffer stringBuffer = new StringBuffer();
                Matcher matcher = Pattern.compile(str, i5).matcher(c1386h.toString());
                int i6 = 0;
                i3 = 0;
                while (matcher.find()) {
                    try {
                        i6 = matcher.end();
                        matcher.appendReplacement(stringBuffer, str2);
                        i3++;
                    } catch (Exception e2) {
                        i2 = i;
                    }
                }
                StringBuffer appendTail = matcher.appendTail(stringBuffer);
                i2 = (i6 - (c1386h.length() - appendTail.length())) + 1;
                try {
                    c1386h.m11035a(0, c1386h.length() - 1, nanoTime);
                    c1386h.m11041a(appendTail.toString().toCharArray(), 0, nanoTime);
                } catch (Exception e3) {
                }
            } catch (Exception e4) {
                i2 = i;
                i3 = 0;
            }
            c1386h.m11050e();
            return new C1397s(i3, new Integer(Math.max(i2, 0)));
        }
        char[] charArray = str2.toCharArray();
        int[] m11104a = m11104a(c1386h, str, 0, c1386h.m11055h(), z, z2, z3);
        long nanoTime2 = System.nanoTime();
        c1386h.m11048d();
        while (true) {
            int i7 = i4;
            if (m11104a[0] != -1) {
                c1386h.m11035a(m11104a[0], m11104a[1], nanoTime2);
                c1386h.m11041a(charArray, m11104a[0], nanoTime2);
                if (m11104a[0] < i) {
                    i += str2.length() - str.length();
                }
                i4 = i7 + 1;
                this.f9046a += str.length();
                m11104a = m11104a(c1386h, str, m11104a[0] + str2.length(), c1386h.m11055h(), z, z2, z3);
            } else {
                c1386h.m11050e();
                return new C1397s(i7, new Integer(Math.max(i, 0)));
            }
        }
    }

    /* renamed from: a */
    protected boolean m11103a(C1386h c1386h, String str, int i, boolean z) {
        if (c1386h.m11055h() - i < str.length()) {
            return false;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (z && str.charAt(i2) != c1386h.charAt(i2 + i)) {
                return false;
            }
            if (!z && Character.toLowerCase(str.charAt(i2)) != Character.toLowerCase(c1386h.charAt(i2 + i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    protected boolean m11102a(C1386h c1386h, int i, int i2) {
        AbstractC1389k abstractC1389k = this.f9047b;
        int i3 = i + i2;
        return (i == 0 ? true : abstractC1389k.m11081a(c1386h.charAt(i + (-1)))) && (i3 == c1386h.m11055h() ? true : abstractC1389k.m11081a(c1386h.charAt(i3)));
    }
}
