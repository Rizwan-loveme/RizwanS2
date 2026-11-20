package org.p226d.p233b.p234a;

import android.app.slice.Slice;
import com.p129f.p130a.p133c.AbstractC1148aa;
import com.p129f.p130a.p133c.AbstractC1208w;
import org.p226d.p233b.p250e.InterfaceC2267h;
import org.p226d.p233b.p250e.p252b.InterfaceC2217e;
import org.p226d.p233b.p250e.p252b.InterfaceC2231s;
import org.p226d.p233b.p256f.C2273a;
import org.p226d.p233b.p256f.C2355g;
import org.p226d.p233b.p256f.C2356h;
import org.p226d.p233b.p256f.C2357i;
import org.p226d.p233b.p256f.p260d.C2332b;

/* compiled from: InlineMethodResolver.java */
/* renamed from: org.d.b.a.j */
/* loaded from: classes.dex */
public abstract class AbstractC1975j {
    /* renamed from: a */
    public abstract InterfaceC2267h mo14335a(C1966b c1966b);

    /* renamed from: a */
    public static AbstractC1975j m14332a(int i) {
        if (i == 35) {
            return new a();
        }
        if (i == 36) {
            return new b();
        }
        throw new RuntimeException(String.format("odex version %d is not supported yet", Integer.valueOf(i)));
    }

    protected AbstractC1975j() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static InterfaceC2267h m14334b(int i, String str, String str2, String str3, String str4) {
        return new C2355g(str, str2, (AbstractC1208w<? extends C2357i>) AbstractC1208w.m10129a((Iterable) C2332b.m14970a(str3)), str4, i, (AbstractC1148aa<? extends C2273a>) null, (C2356h) null);
    }

    /* compiled from: InlineMethodResolver.java */
    /* renamed from: org.d.b.a.j$a */
    private static class a extends AbstractC1975j {

        /* renamed from: a */
        private final InterfaceC2267h[] f11500a = {AbstractC1975j.m14334b(8, "Lorg/apache/harmony/dalvik/NativeTestTarget;", "emptyInlineMethod", "", "V"), AbstractC1975j.m14334b(1, "Ljava/lang/String;", "charAt", "I", "C"), AbstractC1975j.m14334b(1, "Ljava/lang/String;", "compareTo", "Ljava/lang/String;", "I"), AbstractC1975j.m14334b(1, "Ljava/lang/String;", "equals", "Ljava/lang/Object;", "Z"), AbstractC1975j.m14334b(1, "Ljava/lang/String;", "length", "", "I"), AbstractC1975j.m14334b(8, "Ljava/lang/Math;", "abs", "I", "I"), AbstractC1975j.m14334b(8, "Ljava/lang/Math;", "abs", "J", "J"), AbstractC1975j.m14334b(8, "Ljava/lang/Math;", "abs", "F", "F"), AbstractC1975j.m14334b(8, "Ljava/lang/Math;", "abs", "D", "D"), AbstractC1975j.m14334b(8, "Ljava/lang/Math;", "min", "II", "I"), AbstractC1975j.m14334b(8, "Ljava/lang/Math;", Slice.SUBTYPE_MAX, "II", "I"), AbstractC1975j.m14334b(8, "Ljava/lang/Math;", "sqrt", "D", "D"), AbstractC1975j.m14334b(8, "Ljava/lang/Math;", "cos", "D", "D"), AbstractC1975j.m14334b(8, "Ljava/lang/Math;", "sin", "D", "D")};

        @Override // org.p226d.p233b.p234a.AbstractC1975j
        /* renamed from: a */
        public InterfaceC2267h mo14335a(C1966b c1966b) {
            int mo14482f = ((InterfaceC2217e) c1966b.f11439b).mo14482f();
            if (mo14482f < 0 || mo14482f >= this.f11500a.length) {
                throw new RuntimeException("Invalid inline index: " + mo14482f);
            }
            return this.f11500a[mo14482f];
        }
    }

    /* compiled from: InlineMethodResolver.java */
    /* renamed from: org.d.b.a.j$b */
    private static class b extends AbstractC1975j {

        /* renamed from: b */
        private final InterfaceC2267h f11502b = AbstractC1975j.m14334b(1, "Ljava/lang/String;", "indexOf", "I", "I");

        /* renamed from: c */
        private final InterfaceC2267h f11503c = AbstractC1975j.m14334b(1, "Ljava/lang/String;", "indexOf", "II", "I");

        /* renamed from: d */
        private final InterfaceC2267h f11504d = AbstractC1975j.m14334b(2, "Ljava/lang/String;", "fastIndexOf", "II", "I");

        /* renamed from: e */
        private final InterfaceC2267h f11505e = AbstractC1975j.m14334b(1, "Ljava/lang/String;", "isEmpty", "", "Z");

        /* renamed from: a */
        private final InterfaceC2267h[] f11501a = {AbstractC1975j.m14334b(8, "Lorg/apache/harmony/dalvik/NativeTestTarget;", "emptyInlineMethod", "", "V"), AbstractC1975j.m14334b(1, "Ljava/lang/String;", "charAt", "I", "C"), AbstractC1975j.m14334b(1, "Ljava/lang/String;", "compareTo", "Ljava/lang/String;", "I"), AbstractC1975j.m14334b(1, "Ljava/lang/String;", "equals", "Ljava/lang/Object;", "Z"), null, null, AbstractC1975j.m14334b(1, "Ljava/lang/String;", "length", "", "I"), AbstractC1975j.m14334b(8, "Ljava/lang/Math;", "abs", "I", "I"), AbstractC1975j.m14334b(8, "Ljava/lang/Math;", "abs", "J", "J"), AbstractC1975j.m14334b(8, "Ljava/lang/Math;", "abs", "F", "F"), AbstractC1975j.m14334b(8, "Ljava/lang/Math;", "abs", "D", "D"), AbstractC1975j.m14334b(8, "Ljava/lang/Math;", "min", "II", "I"), AbstractC1975j.m14334b(8, "Ljava/lang/Math;", Slice.SUBTYPE_MAX, "II", "I"), AbstractC1975j.m14334b(8, "Ljava/lang/Math;", "sqrt", "D", "D"), AbstractC1975j.m14334b(8, "Ljava/lang/Math;", "cos", "D", "D"), AbstractC1975j.m14334b(8, "Ljava/lang/Math;", "sin", "D", "D"), AbstractC1975j.m14334b(8, "Ljava/lang/Float;", "floatToIntBits", "F", "I"), AbstractC1975j.m14334b(8, "Ljava/lang/Float;", "floatToRawIntBits", "F", "I"), AbstractC1975j.m14334b(8, "Ljava/lang/Float;", "intBitsToFloat", "I", "F"), AbstractC1975j.m14334b(8, "Ljava/lang/Double;", "doubleToLongBits", "D", "J"), AbstractC1975j.m14334b(8, "Ljava/lang/Double;", "doubleToRawLongBits", "D", "J"), AbstractC1975j.m14334b(8, "Ljava/lang/Double;", "longBitsToDouble", "J", "D"), AbstractC1975j.m14334b(8, "Ljava/lang/StrictMath;", "abs", "I", "I"), AbstractC1975j.m14334b(8, "Ljava/lang/StrictMath;", "abs", "J", "J"), AbstractC1975j.m14334b(8, "Ljava/lang/StrictMath;", "abs", "F", "F"), AbstractC1975j.m14334b(8, "Ljava/lang/StrictMath;", "abs", "D", "D"), AbstractC1975j.m14334b(8, "Ljava/lang/StrictMath;", "min", "II", "I"), AbstractC1975j.m14334b(8, "Ljava/lang/StrictMath;", Slice.SUBTYPE_MAX, "II", "I"), AbstractC1975j.m14334b(8, "Ljava/lang/StrictMath;", "sqrt", "D", "D")};

        @Override // org.p226d.p233b.p234a.AbstractC1975j
        /* renamed from: a */
        public InterfaceC2267h mo14335a(C1966b c1966b) {
            InterfaceC2217e interfaceC2217e = (InterfaceC2217e) c1966b.f11439b;
            int mo14482f = interfaceC2217e.mo14482f();
            if (mo14482f < 0 || mo14482f >= this.f11501a.length) {
                throw new RuntimeException("Invalid method index: " + mo14482f);
            }
            if (mo14482f == 4) {
                int mo14481e = ((InterfaceC2231s) interfaceC2217e).mo14481e();
                if (mo14481e == 2) {
                    return this.f11502b;
                }
                if (mo14481e == 3) {
                    return this.f11504d;
                }
                throw new RuntimeException("Could not determine the correct inline method to use");
            }
            if (mo14482f == 5) {
                int mo14481e2 = ((InterfaceC2231s) interfaceC2217e).mo14481e();
                if (mo14481e2 == 3) {
                    return this.f11503c;
                }
                if (mo14481e2 == 1) {
                    return this.f11505e;
                }
                throw new RuntimeException("Could not determine the correct inline method to use");
            }
            return this.f11501a[mo14482f];
        }
    }
}
