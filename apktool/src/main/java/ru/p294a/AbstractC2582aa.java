package ru.p294a;

import java.io.IOException;
import java.util.Calendar;
import java.util.zip.CRC32;
import ru.p294a.C2595n;

/* compiled from: ZipUtil.java */
/* renamed from: ru.a.aa */
/* loaded from: classes.dex */
public abstract class AbstractC2582aa {

    /* renamed from: a */
    private static final byte[] f13416a = C2605x.m16176a(8448);

    /* renamed from: a */
    static void m16054a(Calendar calendar, long j, byte[] bArr, int i) {
        calendar.setTimeInMillis(j);
        if (calendar.get(1) < 1980) {
            System.arraycopy(f13416a, 0, bArr, i, f13416a.length);
        } else {
            C2605x.m16175a(((r0 - 1980) << 25) | ((calendar.get(2) + 1) << 21) | (calendar.get(5) << 16) | (calendar.get(11) << 11) | (calendar.get(12) << 5) | (calendar.get(13) >> 1), bArr, i);
        }
    }

    /* renamed from: a */
    public static long m16052a(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, ((int) ((j >> 25) & 127)) + 1980);
        calendar.set(2, ((int) ((j >> 21) & 15)) - 1);
        calendar.set(5, ((int) (j >> 16)) & 31);
        calendar.set(11, ((int) (j >> 11)) & 31);
        calendar.set(12, ((int) (j >> 5)) & 63);
        calendar.set(13, ((int) (j << 1)) & 62);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    /* renamed from: a */
    static void m16056a(C2602u c2602u, byte[] bArr, byte[] bArr2) {
        String m16053a;
        C2592k c2592k = (C2592k) c2602u.m16140b(C2592k.f13444a);
        String name = c2602u.getName();
        String m16053a2 = m16053a(c2592k, bArr);
        if (m16053a2 != null && !name.equals(m16053a2)) {
            c2602u.m16131a(m16053a2);
        }
        if (bArr2 == null || bArr2.length <= 0 || (m16053a = m16053a((C2591j) c2602u.m16140b(C2591j.f13443a), bArr2)) == null) {
            return;
        }
        c2602u.setComment(m16053a);
    }

    /* renamed from: a */
    private static String m16053a(AbstractC2581a abstractC2581a, byte[] bArr) {
        if (abstractC2581a != null) {
            CRC32 crc32 = new CRC32();
            crc32.update(bArr);
            if (crc32.getValue() == abstractC2581a.m16051t_()) {
                try {
                    return AbstractC2601t.f13471b.mo16077a(abstractC2581a.m16046b());
                } catch (IOException e2) {
                    return (String) null;
                }
            }
        }
        return (String) null;
    }

    /* renamed from: a */
    static byte[] m16057a(byte[] bArr) {
        if (bArr == null) {
            return (byte[]) null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        return bArr2;
    }

    /* renamed from: b */
    private static boolean m16058b(C2602u c2602u) {
        return !c2602u.m16147g().m16085b();
    }

    /* renamed from: c */
    private static boolean m16059c(C2602u c2602u) {
        return c2602u.getMethod() == 0 || c2602u.getMethod() == 8;
    }

    /* renamed from: a */
    static void m16055a(C2602u c2602u) {
        if (!m16058b(c2602u)) {
            throw new C2595n(C2595n.a.f13453a, c2602u);
        }
        if (!m16059c(c2602u)) {
            throw new C2595n(C2595n.a.f13454b, c2602u);
        }
    }
}
