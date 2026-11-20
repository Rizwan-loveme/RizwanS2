package jadx.core.p207e;

import android.icu.text.PluralRules;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ParserConstants.java */
/* renamed from: jadx.core.e.c */
/* loaded from: classes.dex */
public class C1752c {

    /* renamed from: b */
    protected static final double[] f10632b = {0.00390625d, 3.0517578125E-5d, 1.1920928955078125E-7d, 4.656612873077393E-10d};

    /* renamed from: c */
    protected static final int f10633c = m13346a(0);

    /* renamed from: d */
    protected static final int f10634d = m13346a(1);

    /* renamed from: e */
    protected static final int f10635e = m13346a(2);

    /* renamed from: f */
    protected static final int f10636f = m13346a(3);

    /* renamed from: g */
    protected static final int f10637g = m13346a(4);

    /* renamed from: h */
    protected static final int f10638h = m13346a(5);

    /* renamed from: i */
    protected static final int f10639i = m13346a(6);

    /* renamed from: j */
    protected static final int f10640j = m13346a(7);

    /* renamed from: k */
    protected static final int f10641k = m13346a(8);

    /* renamed from: l */
    protected static final int f10642l = m13346a(9);

    /* renamed from: m */
    protected static final Map<Integer, String> f10643m = new HashMap();

    protected C1752c() {
    }

    static {
        f10643m.put(Integer.valueOf(f10637g), "other");
        f10643m.put(Integer.valueOf(f10638h), PluralRules.KEYWORD_ZERO);
        f10643m.put(Integer.valueOf(f10639i), PluralRules.KEYWORD_ONE);
        f10643m.put(Integer.valueOf(f10640j), PluralRules.KEYWORD_TWO);
        f10643m.put(Integer.valueOf(f10641k), PluralRules.KEYWORD_FEW);
        f10643m.put(Integer.valueOf(f10642l), PluralRules.KEYWORD_MANY);
    }

    /* renamed from: a */
    private static int m13346a(int i) {
        return 16777216 | (65535 & i);
    }
}
