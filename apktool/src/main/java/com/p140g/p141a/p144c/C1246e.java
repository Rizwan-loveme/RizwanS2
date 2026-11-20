package com.p140g.p141a.p144c;

import com.p140g.p141a.C1249d;
import com.p140g.p141a.p145d.C1253b;
import com.p140g.p141a.p145d.C1276e;
import com.p140g.p141a.p145d.C1278g;
import com.p140g.p141a.p148e.EnumC1286f;
import com.p140g.p141a.p151g.C1296d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: DexFix.java */
/* renamed from: com.g.a.c.e */
/* loaded from: classes.dex */
public class C1246e {
    /* renamed from: a */
    public static void m10331a(C1253b c1253b) {
        if (c1253b.f8103d != null) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            for (C1276e c1276e : c1253b.f8103d) {
                if ((c1276e.f8162a & 24) == 24) {
                    if (c1276e.f8164c == null) {
                        char charAt = c1276e.f8165d.m10338c().charAt(0);
                        if (charAt != 'L' && charAt != '[') {
                            hashMap.put(new StringBuffer().append(new StringBuffer().append(c1276e.f8165d.m10336a()).append(":").toString()).append(c1276e.f8165d.m10338c()).toString(), c1276e);
                        }
                    } else if (m10332a(c1276e.f8165d.m10338c(), c1276e.f8164c)) {
                        hashMap2.put(new StringBuffer().append(new StringBuffer().append(c1276e.f8165d.m10336a()).append(":").toString()).append(c1276e.f8165d.m10338c()).toString(), c1276e);
                    }
                }
            }
            if (!hashMap.isEmpty() || !hashMap2.isEmpty()) {
                C1278g c1278g = (C1278g) null;
                if (c1253b.f8105f != null) {
                    Iterator<C1278g> it = c1253b.f8105f.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        C1278g next = it.next();
                        if (next.f8171d.m10398c().equals("<clinit>")) {
                            c1278g = next;
                            break;
                        }
                    }
                }
                if (c1278g != null) {
                    if (c1278g.f8170c != null) {
                        c1278g.f8170c.m10377a(new C1296d(c1253b, hashMap, hashMap2) { // from class: com.g.a.c.e.1

                            /* renamed from: a */
                            private final C1253b f8082a;

                            /* renamed from: b */
                            private final Map f8083b;

                            /* renamed from: c */
                            private final Map f8084c;

                            {
                                this.f8082a = c1253b;
                                this.f8083b = hashMap;
                                this.f8084c = hashMap2;
                            }

                            @Override // com.p140g.p141a.p151g.C1296d
                            /* renamed from: a */
                            public void mo10333a(EnumC1286f enumC1286f, int i, int i2, C1249d c1249d) {
                                if ((enumC1286f == EnumC1286f.f8304aT || enumC1286f == EnumC1286f.f8307aW || enumC1286f == EnumC1286f.f8308aX || enumC1286f == EnumC1286f.f8309aY || enumC1286f == EnumC1286f.f8306aV || enumC1286f == EnumC1286f.f8310aZ || enumC1286f == EnumC1286f.f8305aU) && c1249d.m10337b().equals(this.f8082a.f8102c)) {
                                    String stringBuffer = new StringBuffer().append(new StringBuffer().append(c1249d.m10336a()).append(":").toString()).append(c1249d.m10338c()).toString();
                                    this.f8083b.remove(stringBuffer);
                                    C1276e c1276e2 = (C1276e) this.f8084c.get(stringBuffer);
                                    if (c1276e2 != null) {
                                        c1276e2.f8164c = (Object) null;
                                    }
                                }
                            }
                        });
                    } else {
                        return;
                    }
                }
                for (C1276e c1276e2 : hashMap.values()) {
                    c1276e2.f8164c = m10330a(c1276e2.f8165d.m10338c().charAt(0));
                }
            }
        }
    }

    /* renamed from: a */
    private static Object m10330a(char c2) {
        switch (c2) {
            case 'B':
                return (byte) 0;
            case 'C':
                return (char) 0;
            case 'D':
                return Double.valueOf(0.0d);
            case 'F':
                return Float.valueOf(0.0f);
            case 'I':
                return new Integer(0);
            case 'J':
                return 0L;
            case 'S':
                return (short) 0;
            case 'Z':
                return Boolean.FALSE;
            default:
                return (Object) null;
        }
    }

    /* renamed from: a */
    static boolean m10332a(String str, Object obj) {
        if (obj == null || str == null || str.length() <= 0) {
            return false;
        }
        switch (str.charAt(0)) {
            case 'B':
                if (((Byte) obj).byteValue() == 0) {
                    break;
                }
                break;
            case 'C':
                if (((Character) obj).charValue() == 0) {
                    break;
                }
                break;
            case 'D':
                if (((Double) obj).doubleValue() == 0.0d) {
                    break;
                }
                break;
            case 'F':
                if (((Float) obj).floatValue() == 0.0f) {
                    break;
                }
                break;
            case 'I':
                if (((Integer) obj).intValue() == 0) {
                    break;
                }
                break;
            case 'J':
                if (((Long) obj).longValue() == 0) {
                    break;
                }
                break;
            case 'S':
                if (((Short) obj).shortValue() == 0) {
                    break;
                }
                break;
            case 'Z':
                break;
        }
        return false;
    }
}
