package com.p063a.p064a;

import org.p210a.p211a.p212a.AbstractC1870r;
import org.p210a.p211a.p212a.C1817aa;
import org.p210a.p211a.p212a.C1824ah;
import org.p210a.p211a.p212a.InterfaceC1823ag;
import org.p210a.p211a.p212a.InterfaceC1858f;
import org.p210a.p211a.p212a.p213a.C1759a;
import org.p210a.p211a.p212a.p213a.C1777ar;
import org.p210a.p211a.p212a.p213a.C1795e;
import org.p210a.p211a.p212a.p213a.C1812v;
import org.p210a.p211a.p212a.p214b.C1827a;

/* compiled from: JSONLexer.java */
/* renamed from: com.a.a.d */
/* loaded from: classes.dex */
public class C0555d extends AbstractC1870r {

    /* renamed from: a */
    protected static final C1827a[] f3718a;

    /* renamed from: b */
    protected static final C1777ar f3719b;

    /* renamed from: c */
    public static String[] f3720c;

    /* renamed from: d */
    public static String[] f3721d;

    /* renamed from: e */
    public static final String[] f3722e;

    /* renamed from: f */
    public static final InterfaceC1823ag f3723f;

    /* renamed from: g */
    @Deprecated
    public static final String[] f3724g;

    /* renamed from: h */
    public static final C1759a f3725h;

    /* renamed from: i */
    private static final String[] f3726i;

    /* renamed from: x */
    private static final String[] f3727x;

    static {
        C1817aa.m13671a("4.7.2", "4.7.2");
        f3719b = new C1777ar();
        f3720c = new String[]{"DEFAULT_TOKEN_CHANNEL", "HIDDEN"};
        f3721d = new String[]{"DEFAULT_MODE"};
        f3722e = m4490e();
        f3726i = m4491g();
        f3727x = m4492h();
        f3723f = new C1824ah(f3726i, f3727x);
        f3724g = new String[f3727x.length];
        for (int i = 0; i < f3724g.length; i++) {
            f3724g[i] = f3723f.mo13691a(i);
            if (f3724g[i] == null) {
                f3724g[i] = f3723f.mo13692b(i);
            }
            if (f3724g[i] == null) {
                f3724g[i] = "<INVALID>";
            }
        }
        f3725h = new C1795e().m13619a("\u0003悋Ꜫ脳맭䅼㯧瞆奤\u0002\u000e\u0082\b\u0001\u0004\u0002\t\u0002\u0004\u0003\t\u0003\u0004\u0004\t\u0004\u0004\u0005\t\u0005\u0004\u0006\t\u0006\u0004\u0007\t\u0007\u0004\b\t\b\u0004\t\t\t\u0004\n\t\n\u0004\u000b\t\u000b\u0004\f\t\f\u0004\r\t\r\u0004\u000e\t\u000e\u0004\u000f\t\u000f\u0004\u0010\t\u0010\u0004\u0011\t\u0011\u0004\u0012\t\u0012\u0004\u0013\t\u0013\u0003\u0002\u0003\u0002\u0003\u0002\u0003\u0002\u0003\u0002\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0004\u0003\u0004\u0003\u0004\u0003\u0004\u0003\u0004\u0003\u0005\u0003\u0005\u0003\u0005\u0007\u0005;\n\u0005\f\u0005\u000e\u0005>\u000b\u0005\u0003\u0005\u0003\u0005\u0003\u0006\u0003\u0006\u0003\u0007\u0003\u0007\u0003\b\u0003\b\u0003\t\u0003\t\u0003\n\u0003\n\u0003\u000b\u0003\u000b\u0003\f\u0003\f\u0003\f\u0005\fQ\n\f\u0003\r\u0003\r\u0003\r\u0003\r\u0003\r\u0003\r\u0003\u000e\u0003\u000e\u0003\u000f\u0003\u000f\u0003\u0010\u0005\u0010^\n\u0010\u0003\u0010\u0003\u0010\u0003\u0010\u0006\u0010c\n\u0010\r\u0010\u000e\u0010d\u0005\u0010g\n\u0010\u0003\u0010\u0005\u0010j\n\u0010\u0003\u0011\u0003\u0011\u0003\u0011\u0007\u0011o\n\u0011\f\u0011\u000e\u0011r\u000b\u0011\u0005\u0011t\n\u0011\u0003\u0012\u0003\u0012\u0005\u0012x\n\u0012\u0003\u0012\u0003\u0012\u0003\u0013\u0006\u0013}\n\u0013\r\u0013\u000e\u0013~\u0003\u0013\u0003\u0013\u0002\u0002\u0014\u0003\u0003\u0005\u0004\u0007\u0005\t\u0006\u000b\u0007\r\b\u000f\t\u0011\n\u0013\u000b\u0015\f\u0017\u0002\u0019\u0002\u001b\u0002\u001d\u0002\u001f\r!\u0002#\u0002%\u000e\u0003\u0002\n\n\u0002$$11^^ddhhppttvv\u0005\u00022;CHch\u0005\u0002\u0002!$$^^\u0003\u00022;\u0003\u00023;\u0004\u0002GGgg\u0004\u0002--//\u0005\u0002\u000b\f\u000f\u000f\"\"\u0002\u0086\u0002\u0003\u0003\u0002\u0002\u0002\u0002\u0005\u0003\u0002\u0002\u0002\u0002\u0007\u0003\u0002\u0002\u0002\u0002\t\u0003\u0002\u0002\u0002\u0002\u000b\u0003\u0002\u0002\u0002\u0002\r\u0003\u0002\u0002\u0002\u0002\u000f\u0003\u0002\u0002\u0002\u0002\u0011\u0003\u0002\u0002\u0002\u0002\u0013\u0003\u0002\u0002\u0002\u0002\u0015\u0003\u0002\u0002\u0002\u0002\u001f\u0003\u0002\u0002\u0002\u0002%\u0003\u0002\u0002\u0002\u0003'\u0003\u0002\u0002\u0002\u0005,\u0003\u0002\u0002\u0002\u00072\u0003\u0002\u0002\u0002\t7\u0003\u0002\u0002\u0002\u000bA\u0003\u0002\u0002\u0002\rC\u0003\u0002\u0002\u0002\u000fE\u0003\u0002\u0002\u0002\u0011G\u0003\u0002\u0002\u0002\u0013I\u0003\u0002\u0002\u0002\u0015K\u0003\u0002\u0002\u0002\u0017M\u0003\u0002\u0002\u0002\u0019R\u0003\u0002\u0002\u0002\u001bX\u0003\u0002\u0002\u0002\u001dZ\u0003\u0002\u0002\u0002\u001f]\u0003\u0002\u0002\u0002!s\u0003\u0002\u0002\u0002#u\u0003\u0002\u0002\u0002%|\u0003\u0002\u0002\u0002'(\u0007v\u0002\u0002()\u0007t\u0002\u0002)*\u0007w\u0002\u0002*+\u0007g\u0002\u0002+\u0004\u0003\u0002\u0002\u0002,-\u0007h\u0002\u0002-.\u0007c\u0002\u0002./\u0007n\u0002\u0002/0\u0007u\u0002\u000201\u0007g\u0002\u00021\u0006\u0003\u0002\u0002\u000223\u0007p\u0002\u000234\u0007w\u0002\u000245\u0007n\u0002\u000256\u0007n\u0002\u00026\b\u0003\u0002\u0002\u00027<\u0007$\u0002\u00028;\u0005\u0017\f\u00029;\u0005\u001d\u000f\u0002:8\u0003\u0002\u0002\u0002:9\u0003\u0002\u0002\u0002;>\u0003\u0002\u0002\u0002<:\u0003\u0002\u0002\u0002<=\u0003\u0002\u0002\u0002=?\u0003\u0002\u0002\u0002><\u0003\u0002\u0002\u0002?@\u0007$\u0002\u0002@\n\u0003\u0002\u0002\u0002AB\u0007}\u0002\u0002B\f\u0003\u0002\u0002\u0002CD\u0007\u007f\u0002\u0002D\u000e\u0003\u0002\u0002\u0002EF\u0007]\u0002\u0002F\u0010\u0003\u0002\u0002\u0002GH\u0007_\u0002\u0002H\u0012\u0003\u0002\u0002\u0002IJ\u0007.\u0002\u0002J\u0014\u0003\u0002\u0002\u0002KL\u0007<\u0002\u0002L\u0016\u0003\u0002\u0002\u0002MP\u0007^\u0002\u0002NQ\t\u0002\u0002\u0002OQ\u0005\u0019\r\u0002PN\u0003\u0002\u0002\u0002PO\u0003\u0002\u0002\u0002Q\u0018\u0003\u0002\u0002\u0002RS\u0007w\u0002\u0002ST\u0005\u001b\u000e\u0002TU\u0005\u001b\u000e\u0002UV\u0005\u001b\u000e\u0002VW\u0005\u001b\u000e\u0002W\u001a\u0003\u0002\u0002\u0002XY\t\u0003\u0002\u0002Y\u001c\u0003\u0002\u0002\u0002Z[\n\u0004\u0002\u0002[\u001e\u0003\u0002\u0002\u0002\\^\u0007/\u0002\u0002]\\\u0003\u0002\u0002\u0002]^\u0003\u0002\u0002\u0002^_\u0003\u0002\u0002\u0002_f\u0005!\u0011\u0002`b\u00070\u0002\u0002ac\t\u0005\u0002\u0002ba\u0003\u0002\u0002\u0002cd\u0003\u0002\u0002\u0002db\u0003\u0002\u0002\u0002de\u0003\u0002\u0002\u0002eg\u0003\u0002\u0002\u0002f`\u0003\u0002\u0002\u0002fg\u0003\u0002\u0002\u0002gi\u0003\u0002\u0002\u0002hj\u0005#\u0012\u0002ih\u0003\u0002\u0002\u0002ij\u0003\u0002\u0002\u0002j \u0003\u0002\u0002\u0002kt\u00072\u0002\u0002lp\t\u0006\u0002\u0002mo\t\u0005\u0002\u0002nm\u0003\u0002\u0002\u0002or\u0003\u0002\u0002\u0002pn\u0003\u0002\u0002\u0002pq\u0003\u0002\u0002\u0002qt\u0003\u0002\u0002\u0002rp\u0003\u0002\u0002\u0002sk\u0003\u0002\u0002\u0002sl\u0003\u0002\u0002\u0002t\"\u0003\u0002\u0002\u0002uw\t\u0007\u0002\u0002vx\t\b\u0002\u0002wv\u0003\u0002\u0002\u0002wx\u0003\u0002\u0002\u0002xy\u0003\u0002\u0002\u0002yz\u0005!\u0011\u0002z$\u0003\u0002\u0002\u0002{}\t\t\u0002\u0002|{\u0003\u0002\u0002\u0002}~\u0003\u0002\u0002\u0002~|\u0003\u0002\u0002\u0002~\u007f\u0003\u0002\u0002\u0002\u007f\u0080\u0003\u0002\u0002\u0002\u0080\u0081\b\u0013\u0002\u0002\u0081&\u0003\u0002\u0002\u0002\u000e\u0002:<P]dfipsw~\u0003\b\u0002\u0002".toCharArray());
        f3718a = new C1827a[f3725h.m13481a()];
        for (int i2 = 0; i2 < f3725h.m13481a(); i2++) {
            f3718a[i2] = new C1827a(f3725h.m13483a(i2), i2);
        }
    }

    /* renamed from: e */
    private static String[] m4490e() {
        return new String[]{"TRUE", "FALSE", "NULL", "STRING", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "COMMA", "COLON", "ESC", "UNICODE", "HEX", "SAFECODEPOINT", "NUMBER", "INT", "EXP", "WS"};
    }

    /* renamed from: g */
    private static String[] m4491g() {
        String[] strArr = new String[11];
        strArr[1] = "'true'";
        strArr[2] = "'false'";
        strArr[3] = "'null'";
        strArr[5] = "'{'";
        strArr[6] = "'}'";
        strArr[7] = "'['";
        strArr[8] = "']'";
        strArr[9] = "','";
        strArr[10] = "':'";
        return strArr;
    }

    /* renamed from: h */
    private static String[] m4492h() {
        String[] strArr = new String[13];
        strArr[1] = "TRUE";
        strArr[2] = "FALSE";
        strArr[3] = "NULL";
        strArr[4] = "STRING";
        strArr[5] = "LBRACE";
        strArr[6] = "RBRACE";
        strArr[7] = "LBRACK";
        strArr[8] = "RBRACK";
        strArr[9] = "COMMA";
        strArr[10] = "COLON";
        strArr[11] = "NUMBER";
        strArr[12] = "WS";
        return strArr;
    }

    @Override // org.p210a.p211a.p212a.AbstractC1870r, org.p210a.p211a.p212a.AbstractC1877y
    @Deprecated
    /* renamed from: a */
    public String[] mo4046a() {
        return f3724g;
    }

    @Override // org.p210a.p211a.p212a.AbstractC1877y
    /* renamed from: b */
    public InterfaceC1823ag mo4047b() {
        return f3723f;
    }

    public C0555d(InterfaceC1858f interfaceC1858f) {
        super(interfaceC1858f);
        this.f11013w = new C1812v(this, f3725h, f3718a, f3719b);
    }

    @Override // org.p210a.p211a.p212a.AbstractC1877y
    /* renamed from: c */
    public String[] mo4048c() {
        return f3722e;
    }

    @Override // org.p210a.p211a.p212a.AbstractC1877y
    /* renamed from: d */
    public C1759a mo4049d() {
        return f3725h;
    }
}
