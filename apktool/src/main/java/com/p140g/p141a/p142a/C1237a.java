package com.p140g.p141a.p142a;

import org.p271f.p272a.AbstractC2526r;
import org.p271f.p272a.C2529u;
import org.p271f.p272a.InterfaceC2528t;

/* compiled from: LdcOptimizeAdapter.java */
/* renamed from: com.g.a.a.a */
/* loaded from: classes.dex */
public class C1237a extends AbstractC2526r implements InterfaceC2528t {
    public C1237a(AbstractC2526r abstractC2526r) {
        super(262144, abstractC2526r);
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo10229a(Object obj) {
        if (obj == null) {
            mo15740a(1);
            return;
        }
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            if (intValue >= -1 && intValue <= 5) {
                super.mo15740a(intValue + 3);
                return;
            }
            if (intValue <= 127 && intValue >= -128) {
                super.mo15741a(16, intValue);
                return;
            } else if (intValue <= 32767 && intValue >= -32768) {
                super.mo15741a(17, intValue);
                return;
            } else {
                super.mo10229a(obj);
                return;
            }
        }
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            if (longValue == 0 || longValue == 1) {
                super.mo15740a(((int) longValue) + 9);
                return;
            } else {
                super.mo10229a(obj);
                return;
            }
        }
        if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            if (floatValue == 0.0f) {
                super.mo15740a(11);
                return;
            }
            if (floatValue == 1.0f) {
                super.mo15740a(12);
                return;
            } else if (floatValue == 2.0f) {
                super.mo15740a(13);
                return;
            } else {
                super.mo10229a(obj);
                return;
            }
        }
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            if (doubleValue == 0.0d) {
                super.mo15740a(14);
                return;
            } else if (doubleValue == 1.0d) {
                super.mo15740a(15);
                return;
            } else {
                super.mo10229a(obj);
                return;
            }
        }
        if (obj instanceof C2529u) {
            switch (((C2529u) obj).m15896a()) {
                case 1:
                    super.mo15681a(178, "java/lang/Boolean", "TYPE", "Ljava/lang/Class;");
                    break;
                case 2:
                    super.mo15681a(178, "java/lang/Character", "TYPE", "Ljava/lang/Class;");
                    break;
                case 3:
                    super.mo15681a(178, "java/lang/Byte", "TYPE", "Ljava/lang/Class;");
                    break;
                case 4:
                    super.mo15681a(178, "java/lang/Short", "TYPE", "Ljava/lang/Class;");
                    break;
                case 5:
                    super.mo15681a(178, "java/lang/Integer", "TYPE", "Ljava/lang/Class;");
                    break;
                case 6:
                    super.mo15681a(178, "java/lang/Float", "TYPE", "Ljava/lang/Class;");
                    break;
                case 7:
                    super.mo15681a(178, "java/lang/Long", "TYPE", "Ljava/lang/Class;");
                    break;
                case 8:
                    super.mo15681a(178, "java/lang/Double", "TYPE", "Ljava/lang/Class;");
                    break;
                default:
                    super.mo10229a(obj);
                    break;
            }
            return;
        }
        super.mo10229a(obj);
    }
}
