package com.p065b.p086b.p103f.p105b;

import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.C0967u;
import com.p065b.p086b.p103f.p107d.C0973a;
import com.p065b.p086b.p103f.p107d.C0974b;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0976d;
import com.p065b.p086b.p103f.p107d.InterfaceC0977e;

/* compiled from: Rops.java */
/* renamed from: com.b.b.f.b.u */
/* loaded from: classes.dex */
public final class C0939u {

    /* renamed from: a */
    public static final C0937s f5947a = new C0937s(1, C0975c.f6254i, C0974b.f6209a, "nop");

    /* renamed from: b */
    public static final C0937s f6000b = new C0937s(2, C0975c.f6251f, C0974b.f6210b, "move-int");

    /* renamed from: c */
    public static final C0937s f6053c = new C0937s(2, C0975c.f6252g, C0974b.f6211c, "move-long");

    /* renamed from: d */
    public static final C0937s f6105d = new C0937s(2, C0975c.f6250e, C0974b.f6212d, "move-float");

    /* renamed from: e */
    public static final C0937s f6106e = new C0937s(2, C0975c.f6249d, C0974b.f6213e, "move-double");

    /* renamed from: f */
    public static final C0937s f6107f = new C0937s(2, C0975c.f6260o, C0974b.f6214f, "move-object");

    /* renamed from: g */
    public static final C0937s f6108g = new C0937s(2, C0975c.f6256k, C0974b.f6215g, "move-return-address");

    /* renamed from: h */
    public static final C0937s f6109h = new C0937s(3, C0975c.f6251f, C0974b.f6209a, "move-param-int");

    /* renamed from: i */
    public static final C0937s f6110i = new C0937s(3, C0975c.f6252g, C0974b.f6209a, "move-param-long");

    /* renamed from: j */
    public static final C0937s f6111j = new C0937s(3, C0975c.f6250e, C0974b.f6209a, "move-param-float");

    /* renamed from: k */
    public static final C0937s f6112k = new C0937s(3, C0975c.f6249d, C0974b.f6209a, "move-param-double");

    /* renamed from: l */
    public static final C0937s f6113l = new C0937s(3, C0975c.f6260o, C0974b.f6209a, "move-param-object");

    /* renamed from: m */
    public static final C0937s f6114m = new C0937s(5, C0975c.f6251f, C0974b.f6209a, "const-int");

    /* renamed from: n */
    public static final C0937s f6115n = new C0937s(5, C0975c.f6252g, C0974b.f6209a, "const-long");

    /* renamed from: o */
    public static final C0937s f6116o = new C0937s(5, C0975c.f6250e, C0974b.f6209a, "const-float");

    /* renamed from: p */
    public static final C0937s f6117p = new C0937s(5, C0975c.f6249d, C0974b.f6209a, "const-double");

    /* renamed from: q */
    public static final C0937s f6118q = new C0937s(5, C0975c.f6260o, C0974b.f6209a, C0924f.f5874i, "const-object");

    /* renamed from: r */
    public static final C0937s f6119r = new C0937s(5, C0975c.f6260o, C0974b.f6209a, "const-object-nothrow");

    /* renamed from: s */
    public static final C0937s f6120s = new C0937s(6, C0975c.f6254i, C0974b.f6209a, 3, "goto");

    /* renamed from: t */
    public static final C0937s f6121t = new C0937s(7, C0975c.f6254i, C0974b.f6210b, 4, "if-eqz-int");

    /* renamed from: u */
    public static final C0937s f6122u = new C0937s(8, C0975c.f6254i, C0974b.f6210b, 4, "if-nez-int");

    /* renamed from: v */
    public static final C0937s f6123v = new C0937s(9, C0975c.f6254i, C0974b.f6210b, 4, "if-ltz-int");

    /* renamed from: w */
    public static final C0937s f6124w = new C0937s(10, C0975c.f6254i, C0974b.f6210b, 4, "if-gez-int");

    /* renamed from: x */
    public static final C0937s f6125x = new C0937s(11, C0975c.f6254i, C0974b.f6210b, 4, "if-lez-int");

    /* renamed from: y */
    public static final C0937s f6126y = new C0937s(12, C0975c.f6254i, C0974b.f6210b, 4, "if-gtz-int");

    /* renamed from: z */
    public static final C0937s f6127z = new C0937s(7, C0975c.f6254i, C0974b.f6214f, 4, "if-eqz-object");

    /* renamed from: A */
    public static final C0937s f5921A = new C0937s(8, C0975c.f6254i, C0974b.f6214f, 4, "if-nez-object");

    /* renamed from: B */
    public static final C0937s f5922B = new C0937s(7, C0975c.f6254i, C0974b.f6217i, 4, "if-eq-int");

    /* renamed from: C */
    public static final C0937s f5923C = new C0937s(8, C0975c.f6254i, C0974b.f6217i, 4, "if-ne-int");

    /* renamed from: D */
    public static final C0937s f5924D = new C0937s(9, C0975c.f6254i, C0974b.f6217i, 4, "if-lt-int");

    /* renamed from: E */
    public static final C0937s f5925E = new C0937s(10, C0975c.f6254i, C0974b.f6217i, 4, "if-ge-int");

    /* renamed from: F */
    public static final C0937s f5926F = new C0937s(11, C0975c.f6254i, C0974b.f6217i, 4, "if-le-int");

    /* renamed from: G */
    public static final C0937s f5927G = new C0937s(12, C0975c.f6254i, C0974b.f6217i, 4, "if-gt-int");

    /* renamed from: H */
    public static final C0937s f5928H = new C0937s(7, C0975c.f6254i, C0974b.f6221m, 4, "if-eq-object");

    /* renamed from: I */
    public static final C0937s f5929I = new C0937s(8, C0975c.f6254i, C0974b.f6221m, 4, "if-ne-object");

    /* renamed from: J */
    public static final C0937s f5930J = new C0937s(13, C0975c.f6254i, C0974b.f6210b, 5, "switch");

    /* renamed from: K */
    public static final C0937s f5931K = new C0937s(14, C0975c.f6251f, C0974b.f6217i, "add-int");

    /* renamed from: L */
    public static final C0937s f5932L = new C0937s(14, C0975c.f6252g, C0974b.f6218j, "add-long");

    /* renamed from: M */
    public static final C0937s f5933M = new C0937s(14, C0975c.f6250e, C0974b.f6219k, "add-float");

    /* renamed from: N */
    public static final C0937s f5934N = new C0937s(14, C0975c.f6249d, C0974b.f6220l, 1, "add-double");

    /* renamed from: O */
    public static final C0937s f5935O = new C0937s(15, C0975c.f6251f, C0974b.f6217i, "sub-int");

    /* renamed from: P */
    public static final C0937s f5936P = new C0937s(15, C0975c.f6252g, C0974b.f6218j, "sub-long");

    /* renamed from: Q */
    public static final C0937s f5937Q = new C0937s(15, C0975c.f6250e, C0974b.f6219k, "sub-float");

    /* renamed from: R */
    public static final C0937s f5938R = new C0937s(15, C0975c.f6249d, C0974b.f6220l, 1, "sub-double");

    /* renamed from: S */
    public static final C0937s f5939S = new C0937s(16, C0975c.f6251f, C0974b.f6217i, "mul-int");

    /* renamed from: T */
    public static final C0937s f5940T = new C0937s(16, C0975c.f6252g, C0974b.f6218j, "mul-long");

    /* renamed from: U */
    public static final C0937s f5941U = new C0937s(16, C0975c.f6250e, C0974b.f6219k, "mul-float");

    /* renamed from: V */
    public static final C0937s f5942V = new C0937s(16, C0975c.f6249d, C0974b.f6220l, 1, "mul-double");

    /* renamed from: W */
    public static final C0937s f5943W = new C0937s(17, C0975c.f6251f, C0974b.f6217i, C0924f.f5875j, "div-int");

    /* renamed from: X */
    public static final C0937s f5944X = new C0937s(17, C0975c.f6252g, C0974b.f6218j, C0924f.f5875j, "div-long");

    /* renamed from: Y */
    public static final C0937s f5945Y = new C0937s(17, C0975c.f6250e, C0974b.f6219k, "div-float");

    /* renamed from: Z */
    public static final C0937s f5946Z = new C0937s(17, C0975c.f6249d, C0974b.f6220l, "div-double");

    /* renamed from: aa */
    public static final C0937s f5974aa = new C0937s(18, C0975c.f6251f, C0974b.f6217i, C0924f.f5875j, "rem-int");

    /* renamed from: ab */
    public static final C0937s f5975ab = new C0937s(18, C0975c.f6252g, C0974b.f6218j, C0924f.f5875j, "rem-long");

    /* renamed from: ac */
    public static final C0937s f5976ac = new C0937s(18, C0975c.f6250e, C0974b.f6219k, "rem-float");

    /* renamed from: ad */
    public static final C0937s f5977ad = new C0937s(18, C0975c.f6249d, C0974b.f6220l, "rem-double");

    /* renamed from: ae */
    public static final C0937s f5978ae = new C0937s(19, C0975c.f6251f, C0974b.f6210b, "neg-int");

    /* renamed from: af */
    public static final C0937s f5979af = new C0937s(19, C0975c.f6252g, C0974b.f6211c, "neg-long");

    /* renamed from: ag */
    public static final C0937s f5980ag = new C0937s(19, C0975c.f6250e, C0974b.f6212d, "neg-float");

    /* renamed from: ah */
    public static final C0937s f5981ah = new C0937s(19, C0975c.f6249d, C0974b.f6213e, "neg-double");

    /* renamed from: ai */
    public static final C0937s f5982ai = new C0937s(20, C0975c.f6251f, C0974b.f6217i, "and-int");

    /* renamed from: aj */
    public static final C0937s f5983aj = new C0937s(20, C0975c.f6252g, C0974b.f6218j, "and-long");

    /* renamed from: ak */
    public static final C0937s f5984ak = new C0937s(21, C0975c.f6251f, C0974b.f6217i, "or-int");

    /* renamed from: al */
    public static final C0937s f5985al = new C0937s(21, C0975c.f6252g, C0974b.f6218j, "or-long");

    /* renamed from: am */
    public static final C0937s f5986am = new C0937s(22, C0975c.f6251f, C0974b.f6217i, "xor-int");

    /* renamed from: an */
    public static final C0937s f5987an = new C0937s(22, C0975c.f6252g, C0974b.f6218j, "xor-long");

    /* renamed from: ao */
    public static final C0937s f5988ao = new C0937s(23, C0975c.f6251f, C0974b.f6217i, "shl-int");

    /* renamed from: ap */
    public static final C0937s f5989ap = new C0937s(23, C0975c.f6252g, C0974b.f6226r, "shl-long");

    /* renamed from: aq */
    public static final C0937s f5990aq = new C0937s(24, C0975c.f6251f, C0974b.f6217i, "shr-int");

    /* renamed from: ar */
    public static final C0937s f5991ar = new C0937s(24, C0975c.f6252g, C0974b.f6226r, "shr-long");

    /* renamed from: as */
    public static final C0937s f5992as = new C0937s(25, C0975c.f6251f, C0974b.f6217i, "ushr-int");

    /* renamed from: at */
    public static final C0937s f5993at = new C0937s(25, C0975c.f6252g, C0974b.f6226r, "ushr-long");

    /* renamed from: au */
    public static final C0937s f5994au = new C0937s(26, C0975c.f6251f, C0974b.f6210b, "not-int");

    /* renamed from: av */
    public static final C0937s f5995av = new C0937s(26, C0975c.f6252g, C0974b.f6211c, "not-long");

    /* renamed from: aw */
    public static final C0937s f5996aw = new C0937s(14, C0975c.f6251f, C0974b.f6210b, "add-const-int");

    /* renamed from: ax */
    public static final C0937s f5997ax = new C0937s(14, C0975c.f6252g, C0974b.f6211c, "add-const-long");

    /* renamed from: ay */
    public static final C0937s f5998ay = new C0937s(14, C0975c.f6250e, C0974b.f6212d, "add-const-float");

    /* renamed from: az */
    public static final C0937s f5999az = new C0937s(14, C0975c.f6249d, C0974b.f6213e, "add-const-double");

    /* renamed from: aA */
    public static final C0937s f5948aA = new C0937s(15, C0975c.f6251f, C0974b.f6210b, "sub-const-int");

    /* renamed from: aB */
    public static final C0937s f5949aB = new C0937s(15, C0975c.f6252g, C0974b.f6211c, "sub-const-long");

    /* renamed from: aC */
    public static final C0937s f5950aC = new C0937s(15, C0975c.f6250e, C0974b.f6212d, "sub-const-float");

    /* renamed from: aD */
    public static final C0937s f5951aD = new C0937s(15, C0975c.f6249d, C0974b.f6213e, "sub-const-double");

    /* renamed from: aE */
    public static final C0937s f5952aE = new C0937s(16, C0975c.f6251f, C0974b.f6210b, "mul-const-int");

    /* renamed from: aF */
    public static final C0937s f5953aF = new C0937s(16, C0975c.f6252g, C0974b.f6211c, "mul-const-long");

    /* renamed from: aG */
    public static final C0937s f5954aG = new C0937s(16, C0975c.f6250e, C0974b.f6212d, "mul-const-float");

    /* renamed from: aH */
    public static final C0937s f5955aH = new C0937s(16, C0975c.f6249d, C0974b.f6213e, "mul-const-double");

    /* renamed from: aI */
    public static final C0937s f5956aI = new C0937s(17, C0975c.f6251f, C0974b.f6210b, C0924f.f5875j, "div-const-int");

    /* renamed from: aJ */
    public static final C0937s f5957aJ = new C0937s(17, C0975c.f6252g, C0974b.f6211c, C0924f.f5875j, "div-const-long");

    /* renamed from: aK */
    public static final C0937s f5958aK = new C0937s(17, C0975c.f6250e, C0974b.f6212d, "div-const-float");

    /* renamed from: aL */
    public static final C0937s f5959aL = new C0937s(17, C0975c.f6249d, C0974b.f6213e, "div-const-double");

    /* renamed from: aM */
    public static final C0937s f5960aM = new C0937s(18, C0975c.f6251f, C0974b.f6210b, C0924f.f5875j, "rem-const-int");

    /* renamed from: aN */
    public static final C0937s f5961aN = new C0937s(18, C0975c.f6252g, C0974b.f6211c, C0924f.f5875j, "rem-const-long");

    /* renamed from: aO */
    public static final C0937s f5962aO = new C0937s(18, C0975c.f6250e, C0974b.f6212d, "rem-const-float");

    /* renamed from: aP */
    public static final C0937s f5963aP = new C0937s(18, C0975c.f6249d, C0974b.f6213e, "rem-const-double");

    /* renamed from: aQ */
    public static final C0937s f5964aQ = new C0937s(20, C0975c.f6251f, C0974b.f6210b, "and-const-int");

    /* renamed from: aR */
    public static final C0937s f5965aR = new C0937s(20, C0975c.f6252g, C0974b.f6211c, "and-const-long");

    /* renamed from: aS */
    public static final C0937s f5966aS = new C0937s(21, C0975c.f6251f, C0974b.f6210b, "or-const-int");

    /* renamed from: aT */
    public static final C0937s f5967aT = new C0937s(21, C0975c.f6252g, C0974b.f6211c, "or-const-long");

    /* renamed from: aU */
    public static final C0937s f5968aU = new C0937s(22, C0975c.f6251f, C0974b.f6210b, "xor-const-int");

    /* renamed from: aV */
    public static final C0937s f5969aV = new C0937s(22, C0975c.f6252g, C0974b.f6211c, "xor-const-long");

    /* renamed from: aW */
    public static final C0937s f5970aW = new C0937s(23, C0975c.f6251f, C0974b.f6210b, "shl-const-int");

    /* renamed from: aX */
    public static final C0937s f5971aX = new C0937s(23, C0975c.f6252g, C0974b.f6210b, "shl-const-long");

    /* renamed from: aY */
    public static final C0937s f5972aY = new C0937s(24, C0975c.f6251f, C0974b.f6210b, "shr-const-int");

    /* renamed from: aZ */
    public static final C0937s f5973aZ = new C0937s(24, C0975c.f6252g, C0974b.f6210b, "shr-const-long");

    /* renamed from: ba */
    public static final C0937s f6027ba = new C0937s(25, C0975c.f6251f, C0974b.f6210b, "ushr-const-int");

    /* renamed from: bb */
    public static final C0937s f6028bb = new C0937s(25, C0975c.f6252g, C0974b.f6210b, "ushr-const-long");

    /* renamed from: bc */
    public static final C0937s f6029bc = new C0937s(27, C0975c.f6251f, C0974b.f6218j, "cmpl-long");

    /* renamed from: bd */
    public static final C0937s f6030bd = new C0937s(27, C0975c.f6251f, C0974b.f6219k, "cmpl-float");

    /* renamed from: be */
    public static final C0937s f6031be = new C0937s(27, C0975c.f6251f, C0974b.f6220l, "cmpl-double");

    /* renamed from: bf */
    public static final C0937s f6032bf = new C0937s(28, C0975c.f6251f, C0974b.f6219k, "cmpg-float");

    /* renamed from: bg */
    public static final C0937s f6033bg = new C0937s(28, C0975c.f6251f, C0974b.f6220l, "cmpg-double");

    /* renamed from: bh */
    public static final C0937s f6034bh = new C0937s(29, C0975c.f6251f, C0974b.f6211c, "conv-l2i");

    /* renamed from: bi */
    public static final C0937s f6035bi = new C0937s(29, C0975c.f6251f, C0974b.f6212d, "conv-f2i");

    /* renamed from: bj */
    public static final C0937s f6036bj = new C0937s(29, C0975c.f6251f, C0974b.f6213e, "conv-d2i");

    /* renamed from: bk */
    public static final C0937s f6037bk = new C0937s(29, C0975c.f6252g, C0974b.f6210b, "conv-i2l");

    /* renamed from: bl */
    public static final C0937s f6038bl = new C0937s(29, C0975c.f6252g, C0974b.f6212d, "conv-f2l");

    /* renamed from: bm */
    public static final C0937s f6039bm = new C0937s(29, C0975c.f6252g, C0974b.f6213e, "conv-d2l");

    /* renamed from: bn */
    public static final C0937s f6040bn = new C0937s(29, C0975c.f6250e, C0974b.f6210b, "conv-i2f");

    /* renamed from: bo */
    public static final C0937s f6041bo = new C0937s(29, C0975c.f6250e, C0974b.f6211c, "conv-l2f");

    /* renamed from: bp */
    public static final C0937s f6042bp = new C0937s(29, C0975c.f6250e, C0974b.f6213e, "conv-d2f");

    /* renamed from: bq */
    public static final C0937s f6043bq = new C0937s(29, C0975c.f6249d, C0974b.f6210b, "conv-i2d");

    /* renamed from: br */
    public static final C0937s f6044br = new C0937s(29, C0975c.f6249d, C0974b.f6211c, "conv-l2d");

    /* renamed from: bs */
    public static final C0937s f6045bs = new C0937s(29, C0975c.f6249d, C0974b.f6212d, "conv-f2d");

    /* renamed from: bt */
    public static final C0937s f6046bt = new C0937s(30, C0975c.f6251f, C0974b.f6210b, "to-byte");

    /* renamed from: bu */
    public static final C0937s f6047bu = new C0937s(31, C0975c.f6251f, C0974b.f6210b, "to-char");

    /* renamed from: bv */
    public static final C0937s f6048bv = new C0937s(32, C0975c.f6251f, C0974b.f6210b, "to-short");

    /* renamed from: bw */
    public static final C0937s f6049bw = new C0937s(33, C0975c.f6254i, C0974b.f6209a, 2, "return-void");

    /* renamed from: bx */
    public static final C0937s f6050bx = new C0937s(33, C0975c.f6254i, C0974b.f6210b, 2, "return-int");

    /* renamed from: by */
    public static final C0937s f6051by = new C0937s(33, C0975c.f6254i, C0974b.f6211c, 2, "return-long");

    /* renamed from: bz */
    public static final C0937s f6052bz = new C0937s(33, C0975c.f6254i, C0974b.f6212d, 2, "return-float");

    /* renamed from: bA */
    public static final C0937s f6001bA = new C0937s(33, C0975c.f6254i, C0974b.f6213e, 2, "return-double");

    /* renamed from: bB */
    public static final C0937s f6002bB = new C0937s(33, C0975c.f6254i, C0974b.f6214f, 2, "return-object");

    /* renamed from: bC */
    public static final C0937s f6003bC = new C0937s(34, C0975c.f6251f, C0974b.f6214f, C0924f.f5878m, "array-length");

    /* renamed from: bD */
    public static final C0937s f6004bD = new C0937s(35, C0975c.f6254i, C0974b.f6216h, C0974b.f6216h, "throw");

    /* renamed from: bE */
    public static final C0937s f6005bE = new C0937s(36, C0975c.f6254i, C0974b.f6214f, C0924f.f5878m, "monitor-enter");

    /* renamed from: bF */
    public static final C0937s f6006bF = new C0937s(37, C0975c.f6254i, C0974b.f6214f, C0924f.f5881p, "monitor-exit");

    /* renamed from: bG */
    public static final C0937s f6007bG = new C0937s(38, C0975c.f6251f, C0974b.f6227s, C0924f.f5879n, "aget-int");

    /* renamed from: bH */
    public static final C0937s f6008bH = new C0937s(38, C0975c.f6252g, C0974b.f6228t, C0924f.f5879n, "aget-long");

    /* renamed from: bI */
    public static final C0937s f6009bI = new C0937s(38, C0975c.f6250e, C0974b.f6229u, C0924f.f5879n, "aget-float");

    /* renamed from: bJ */
    public static final C0937s f6010bJ = new C0937s(38, C0975c.f6249d, C0974b.f6230v, C0924f.f5879n, "aget-double");

    /* renamed from: bK */
    public static final C0937s f6011bK = new C0937s(38, C0975c.f6260o, C0974b.f6231w, C0924f.f5879n, "aget-object");

    /* renamed from: bL */
    public static final C0937s f6012bL = new C0937s(38, C0975c.f6251f, C0974b.f6232x, C0924f.f5879n, "aget-boolean");

    /* renamed from: bM */
    public static final C0937s f6013bM = new C0937s(38, C0975c.f6251f, C0974b.f6233y, C0924f.f5879n, "aget-byte");

    /* renamed from: bN */
    public static final C0937s f6014bN = new C0937s(38, C0975c.f6251f, C0974b.f6234z, C0924f.f5879n, "aget-char");

    /* renamed from: bO */
    public static final C0937s f6015bO = new C0937s(38, C0975c.f6251f, C0974b.f6199A, C0924f.f5879n, "aget-short");

    /* renamed from: bP */
    public static final C0937s f6016bP = new C0937s(39, C0975c.f6254i, C0974b.f6200B, C0924f.f5879n, "aput-int");

    /* renamed from: bQ */
    public static final C0937s f6017bQ = new C0937s(39, C0975c.f6254i, C0974b.f6201C, C0924f.f5879n, "aput-long");

    /* renamed from: bR */
    public static final C0937s f6018bR = new C0937s(39, C0975c.f6254i, C0974b.f6202D, C0924f.f5879n, "aput-float");

    /* renamed from: bS */
    public static final C0937s f6019bS = new C0937s(39, C0975c.f6254i, C0974b.f6203E, C0924f.f5879n, "aput-double");

    /* renamed from: bT */
    public static final C0937s f6020bT = new C0937s(39, C0975c.f6254i, C0974b.f6204F, C0924f.f5880o, "aput-object");

    /* renamed from: bU */
    public static final C0937s f6021bU = new C0937s(39, C0975c.f6254i, C0974b.f6205G, C0924f.f5880o, "aput-boolean");

    /* renamed from: bV */
    public static final C0937s f6022bV = new C0937s(39, C0975c.f6254i, C0974b.f6206H, C0924f.f5880o, "aput-byte");

    /* renamed from: bW */
    public static final C0937s f6023bW = new C0937s(39, C0975c.f6254i, C0974b.f6207I, C0924f.f5880o, "aput-char");

    /* renamed from: bX */
    public static final C0937s f6024bX = new C0937s(39, C0975c.f6254i, C0974b.f6208J, C0924f.f5880o, "aput-short");

    /* renamed from: bY */
    public static final C0937s f6025bY = new C0937s(40, C0975c.f6260o, C0974b.f6209a, C0924f.f5874i, "new-instance");

    /* renamed from: bZ */
    public static final C0937s f6026bZ = new C0937s(41, C0975c.f6241G, C0974b.f6210b, C0924f.f5877l, "new-array-int");

    /* renamed from: ca */
    public static final C0937s f6079ca = new C0937s(41, C0975c.f6242H, C0974b.f6210b, C0924f.f5877l, "new-array-long");

    /* renamed from: cb */
    public static final C0937s f6080cb = new C0937s(41, C0975c.f6240F, C0974b.f6210b, C0924f.f5877l, "new-array-float");

    /* renamed from: cc */
    public static final C0937s f6081cc = new C0937s(41, C0975c.f6239E, C0974b.f6210b, C0924f.f5877l, "new-array-double");

    /* renamed from: cd */
    public static final C0937s f6082cd = new C0937s(41, C0975c.f6236B, C0974b.f6210b, C0924f.f5877l, "new-array-boolean");

    /* renamed from: ce */
    public static final C0937s f6083ce = new C0937s(41, C0975c.f6237C, C0974b.f6210b, C0924f.f5877l, "new-array-byte");

    /* renamed from: cf */
    public static final C0937s f6084cf = new C0937s(41, C0975c.f6238D, C0974b.f6210b, C0924f.f5877l, "new-array-char");

    /* renamed from: cg */
    public static final C0937s f6085cg = new C0937s(41, C0975c.f6244J, C0974b.f6210b, C0924f.f5877l, "new-array-short");

    /* renamed from: ch */
    public static final C0937s f6086ch = new C0937s(43, C0975c.f6254i, C0974b.f6214f, C0924f.f5876k, "check-cast");

    /* renamed from: ci */
    public static final C0937s f6087ci = new C0937s(44, C0975c.f6251f, C0974b.f6214f, C0924f.f5874i, "instance-of");

    /* renamed from: cj */
    public static final C0937s f6088cj = new C0937s(45, C0975c.f6251f, C0974b.f6214f, C0924f.f5878m, "get-field-int");

    /* renamed from: ck */
    public static final C0937s f6089ck = new C0937s(45, C0975c.f6252g, C0974b.f6214f, C0924f.f5878m, "get-field-long");

    /* renamed from: cl */
    public static final C0937s f6090cl = new C0937s(45, C0975c.f6250e, C0974b.f6214f, C0924f.f5878m, "get-field-float");

    /* renamed from: cm */
    public static final C0937s f6091cm = new C0937s(45, C0975c.f6249d, C0974b.f6214f, C0924f.f5878m, "get-field-double");

    /* renamed from: cn */
    public static final C0937s f6092cn = new C0937s(45, C0975c.f6260o, C0974b.f6214f, C0924f.f5878m, "get-field-object");

    /* renamed from: co */
    public static final C0937s f6093co = new C0937s(45, C0975c.f6251f, C0974b.f6214f, C0924f.f5878m, "get-field-boolean");

    /* renamed from: cp */
    public static final C0937s f6094cp = new C0937s(45, C0975c.f6251f, C0974b.f6214f, C0924f.f5878m, "get-field-byte");

    /* renamed from: cq */
    public static final C0937s f6095cq = new C0937s(45, C0975c.f6251f, C0974b.f6214f, C0924f.f5878m, "get-field-char");

    /* renamed from: cr */
    public static final C0937s f6096cr = new C0937s(45, C0975c.f6251f, C0974b.f6214f, C0924f.f5878m, "get-field-short");

    /* renamed from: cs */
    public static final C0937s f6097cs = new C0937s(46, C0975c.f6251f, C0974b.f6209a, C0924f.f5874i, "get-static-int");

    /* renamed from: ct */
    public static final C0937s f6098ct = new C0937s(46, C0975c.f6252g, C0974b.f6209a, C0924f.f5874i, "get-static-long");

    /* renamed from: cu */
    public static final C0937s f6099cu = new C0937s(46, C0975c.f6250e, C0974b.f6209a, C0924f.f5874i, "get-static-float");

    /* renamed from: cv */
    public static final C0937s f6100cv = new C0937s(46, C0975c.f6249d, C0974b.f6209a, C0924f.f5874i, "get-static-double");

    /* renamed from: cw */
    public static final C0937s f6101cw = new C0937s(46, C0975c.f6260o, C0974b.f6209a, C0924f.f5874i, "get-static-object");

    /* renamed from: cx */
    public static final C0937s f6102cx = new C0937s(46, C0975c.f6251f, C0974b.f6209a, C0924f.f5874i, "get-field-boolean");

    /* renamed from: cy */
    public static final C0937s f6103cy = new C0937s(46, C0975c.f6251f, C0974b.f6209a, C0924f.f5874i, "get-field-byte");

    /* renamed from: cz */
    public static final C0937s f6104cz = new C0937s(46, C0975c.f6251f, C0974b.f6209a, C0924f.f5874i, "get-field-char");

    /* renamed from: cA */
    public static final C0937s f6054cA = new C0937s(46, C0975c.f6251f, C0974b.f6209a, C0924f.f5874i, "get-field-short");

    /* renamed from: cB */
    public static final C0937s f6055cB = new C0937s(47, C0975c.f6254i, C0974b.f6222n, C0924f.f5878m, "put-field-int");

    /* renamed from: cC */
    public static final C0937s f6056cC = new C0937s(47, C0975c.f6254i, C0974b.f6223o, C0924f.f5878m, "put-field-long");

    /* renamed from: cD */
    public static final C0937s f6057cD = new C0937s(47, C0975c.f6254i, C0974b.f6224p, C0924f.f5878m, "put-field-float");

    /* renamed from: cE */
    public static final C0937s f6058cE = new C0937s(47, C0975c.f6254i, C0974b.f6225q, C0924f.f5878m, "put-field-double");

    /* renamed from: cF */
    public static final C0937s f6059cF = new C0937s(47, C0975c.f6254i, C0974b.f6221m, C0924f.f5878m, "put-field-object");

    /* renamed from: cG */
    public static final C0937s f6060cG = new C0937s(47, C0975c.f6254i, C0974b.f6222n, C0924f.f5878m, "put-field-boolean");

    /* renamed from: cH */
    public static final C0937s f6061cH = new C0937s(47, C0975c.f6254i, C0974b.f6222n, C0924f.f5878m, "put-field-byte");

    /* renamed from: cI */
    public static final C0937s f6062cI = new C0937s(47, C0975c.f6254i, C0974b.f6222n, C0924f.f5878m, "put-field-char");

    /* renamed from: cJ */
    public static final C0937s f6063cJ = new C0937s(47, C0975c.f6254i, C0974b.f6222n, C0924f.f5878m, "put-field-short");

    /* renamed from: cK */
    public static final C0937s f6064cK = new C0937s(48, C0975c.f6254i, C0974b.f6210b, C0924f.f5874i, "put-static-int");

    /* renamed from: cL */
    public static final C0937s f6065cL = new C0937s(48, C0975c.f6254i, C0974b.f6211c, C0924f.f5874i, "put-static-long");

    /* renamed from: cM */
    public static final C0937s f6066cM = new C0937s(48, C0975c.f6254i, C0974b.f6212d, C0924f.f5874i, "put-static-float");

    /* renamed from: cN */
    public static final C0937s f6067cN = new C0937s(48, C0975c.f6254i, C0974b.f6213e, C0924f.f5874i, "put-static-double");

    /* renamed from: cO */
    public static final C0937s f6068cO = new C0937s(48, C0975c.f6254i, C0974b.f6214f, C0924f.f5874i, "put-static-object");

    /* renamed from: cP */
    public static final C0937s f6069cP = new C0937s(48, C0975c.f6254i, C0974b.f6210b, C0924f.f5874i, "put-static-boolean");

    /* renamed from: cQ */
    public static final C0937s f6070cQ = new C0937s(48, C0975c.f6254i, C0974b.f6210b, C0924f.f5874i, "put-static-byte");

    /* renamed from: cR */
    public static final C0937s f6071cR = new C0937s(48, C0975c.f6254i, C0974b.f6210b, C0924f.f5874i, "put-static-char");

    /* renamed from: cS */
    public static final C0937s f6072cS = new C0937s(48, C0975c.f6254i, C0974b.f6210b, C0924f.f5874i, "put-static-short");

    /* renamed from: cT */
    public static final C0937s f6073cT = new C0937s(54, C0975c.f6254i, C0974b.f6210b, "mark-local-int");

    /* renamed from: cU */
    public static final C0937s f6074cU = new C0937s(54, C0975c.f6254i, C0974b.f6211c, "mark-local-long");

    /* renamed from: cV */
    public static final C0937s f6075cV = new C0937s(54, C0975c.f6254i, C0974b.f6212d, "mark-local-float");

    /* renamed from: cW */
    public static final C0937s f6076cW = new C0937s(54, C0975c.f6254i, C0974b.f6213e, "mark-local-double");

    /* renamed from: cX */
    public static final C0937s f6077cX = new C0937s(54, C0975c.f6254i, C0974b.f6214f, "mark-local-object");

    /* renamed from: cY */
    public static final C0937s f6078cY = new C0937s(57, C0975c.f6254i, C0974b.f6209a, "fill-array-data");

    /* renamed from: a */
    public static C0937s m7980a(int i, InterfaceC0976d interfaceC0976d, InterfaceC0977e interfaceC0977e, AbstractC0945a abstractC0945a) {
        C0975c m8138u;
        C0975c m8138u2;
        switch (i) {
            case 1:
                return f5947a;
            case 2:
                return m7982a(interfaceC0976d);
            case 3:
                return m7989b(interfaceC0976d);
            case 4:
                return m7992c(interfaceC0976d);
            case 5:
                return m8000f(interfaceC0976d);
            case 6:
                return f6120s;
            case 7:
                return m7985a(interfaceC0977e);
            case 8:
                return m7990b(interfaceC0977e);
            case 9:
                return m7993c(interfaceC0977e);
            case 10:
                return m7996d(interfaceC0977e);
            case 11:
                return m8001f(interfaceC0977e);
            case 12:
                return m7999e(interfaceC0977e);
            case 13:
                return f5930J;
            case 14:
                return m8003g(interfaceC0977e);
            case 15:
                return m8005h(interfaceC0977e);
            case 16:
                return m8007i(interfaceC0977e);
            case 17:
                return m8009j(interfaceC0977e);
            case 18:
                return m8011k(interfaceC0977e);
            case 19:
                return m8002g(interfaceC0976d);
            case 20:
                return m8013l(interfaceC0977e);
            case 21:
                return m8015m(interfaceC0977e);
            case 22:
                return m8017n(interfaceC0977e);
            case 23:
                return m8019o(interfaceC0977e);
            case 24:
                return m8021p(interfaceC0977e);
            case 25:
                return m8023q(interfaceC0977e);
            case 26:
                return m8004h(interfaceC0976d);
            case 27:
                return m8006i(interfaceC0977e.mo6853a(0));
            case 28:
                return m8008j(interfaceC0977e.mo6853a(0));
            case 29:
                return m7984a(interfaceC0976d, interfaceC0977e.mo6853a(0));
            case 30:
                return f6046bt;
            case 31:
                return f6047bu;
            case 32:
                return f6048bv;
            case 33:
                if (interfaceC0977e.mo6856f_() == 0) {
                    return f6049bw;
                }
                return m8010k(interfaceC0977e.mo6853a(0));
            case 34:
                return f6003bC;
            case 35:
                return f6004bD;
            case 36:
                return f6005bE;
            case 37:
                return f6006bF;
            case 38:
                C0975c mo6853a = interfaceC0977e.mo6853a(0);
                if (mo6853a == C0975c.f6255j) {
                    m8138u2 = interfaceC0976d.mo6695a();
                } else {
                    m8138u2 = mo6853a.m8138u();
                }
                return m8012l(m8138u2);
            case 39:
                C0975c mo6853a2 = interfaceC0977e.mo6853a(1);
                if (mo6853a2 == C0975c.f6255j) {
                    m8138u = interfaceC0977e.mo6853a(0);
                } else {
                    m8138u = mo6853a2.m8138u();
                }
                return m8014m(m8138u);
            case 40:
                return f6025bY;
            case 41:
                return m8016n(interfaceC0976d.mo6695a());
            case 42:
            default:
                throw new RuntimeException("unknown opcode " + C0933o.m7911a(i));
            case 43:
                return f6086ch;
            case 44:
                return f6087ci;
            case 45:
                return m8018o(interfaceC0976d);
            case 46:
                return m8022q(interfaceC0976d);
            case 47:
                return m8020p(interfaceC0977e.mo6853a(0));
            case 48:
                return m8024r(interfaceC0977e.mo6853a(0));
            case 49:
                return m7981a(((C0967u) abstractC0945a).m8047i());
            case 50:
                C0967u c0967u = (C0967u) abstractC0945a;
                return m7988b(c0967u.m8047i().m8101a(c0967u.m8070m().m8090i()));
            case 51:
                C0967u c0967u2 = (C0967u) abstractC0945a;
                return m7991c(c0967u2.m8047i().m8101a(c0967u2.m8070m().m8090i()));
            case 52:
                C0967u c0967u3 = (C0967u) abstractC0945a;
                return m7994d(c0967u3.m8047i().m8101a(c0967u3.m8070m().m8090i()));
            case 53:
                C0967u c0967u4 = (C0967u) abstractC0945a;
                return m7997e(c0967u4.m8047i().m8101a(c0967u4.m8070m().m8090i()));
        }
    }

    /* renamed from: a */
    public static C0937s m7982a(InterfaceC0976d interfaceC0976d) {
        switch (interfaceC0976d.mo6698e()) {
            case 4:
                return f6106e;
            case 5:
                return f6105d;
            case 6:
                return f6000b;
            case 7:
                return f6053c;
            case 8:
            default:
                return m8027t(interfaceC0976d);
            case 9:
                return f6107f;
            case 10:
                return f6108g;
        }
    }

    /* renamed from: b */
    public static C0937s m7989b(InterfaceC0976d interfaceC0976d) {
        switch (interfaceC0976d.mo6698e()) {
            case 4:
                return f6112k;
            case 5:
                return f6111j;
            case 6:
                return f6109h;
            case 7:
                return f6110i;
            case 8:
            default:
                return m8027t(interfaceC0976d);
            case 9:
                return f6113l;
        }
    }

    /* renamed from: c */
    public static C0937s m7992c(InterfaceC0976d interfaceC0976d) {
        return new C0937s(4, interfaceC0976d.mo6695a(), C0974b.f6209a, (String) null);
    }

    /* renamed from: d */
    public static C0937s m7995d(InterfaceC0976d interfaceC0976d) {
        return new C0937s(55, interfaceC0976d.mo6695a(), C0974b.f6209a, (String) null);
    }

    /* renamed from: e */
    public static C0937s m7998e(InterfaceC0976d interfaceC0976d) {
        return new C0937s(56, interfaceC0976d.mo6695a(), C0974b.f6209a, (String) null);
    }

    /* renamed from: f */
    public static C0937s m8000f(InterfaceC0976d interfaceC0976d) {
        if (interfaceC0976d.mo6695a() == C0975c.f6255j) {
            return f6119r;
        }
        switch (interfaceC0976d.mo6698e()) {
            case 4:
                return f6117p;
            case 5:
                return f6116o;
            case 6:
                return f6114m;
            case 7:
                return f6115n;
            case 8:
            default:
                return m8027t(interfaceC0976d);
            case 9:
                return f6118q;
        }
    }

    /* renamed from: a */
    public static C0937s m7985a(InterfaceC0977e interfaceC0977e) {
        return m7986a(interfaceC0977e, f6121t, f6127z, f5922B, f5928H);
    }

    /* renamed from: b */
    public static C0937s m7990b(InterfaceC0977e interfaceC0977e) {
        return m7986a(interfaceC0977e, f6122u, f5921A, f5923C, f5929I);
    }

    /* renamed from: c */
    public static C0937s m7993c(InterfaceC0977e interfaceC0977e) {
        return m7986a(interfaceC0977e, f6123v, null, f5924D, null);
    }

    /* renamed from: d */
    public static C0937s m7996d(InterfaceC0977e interfaceC0977e) {
        return m7986a(interfaceC0977e, f6124w, null, f5925E, null);
    }

    /* renamed from: e */
    public static C0937s m7999e(InterfaceC0977e interfaceC0977e) {
        return m7986a(interfaceC0977e, f6126y, null, f5927G, null);
    }

    /* renamed from: f */
    public static C0937s m8001f(InterfaceC0977e interfaceC0977e) {
        return m7986a(interfaceC0977e, f6125x, null, f5926F, null);
    }

    /* renamed from: a */
    private static C0937s m7986a(InterfaceC0977e interfaceC0977e, C0937s c0937s, C0937s c0937s2, C0937s c0937s3, C0937s c0937s4) {
        switch (interfaceC0977e.mo6856f_()) {
            case 1:
                switch (interfaceC0977e.mo6853a(0).mo6698e()) {
                    case 6:
                        return c0937s;
                    case 9:
                        if (c0937s2 != null) {
                            return c0937s2;
                        }
                        break;
                }
            case 2:
                int mo6698e = interfaceC0977e.mo6853a(0).mo6698e();
                if (mo6698e == interfaceC0977e.mo6853a(1).mo6698e()) {
                    switch (mo6698e) {
                        case 6:
                            return c0937s3;
                        case 9:
                            if (c0937s4 != null) {
                                return c0937s4;
                            }
                            break;
                    }
                }
                break;
        }
        return m8025r(interfaceC0977e);
    }

    /* renamed from: g */
    public static C0937s m8003g(InterfaceC0977e interfaceC0977e) {
        return m7987a(interfaceC0977e, f5996aw, f5997ax, f5998ay, f5999az, f5931K, f5932L, f5933M, f5934N);
    }

    /* renamed from: h */
    public static C0937s m8005h(InterfaceC0977e interfaceC0977e) {
        return m7987a(interfaceC0977e, f5948aA, f5949aB, f5950aC, f5951aD, f5935O, f5936P, f5937Q, f5938R);
    }

    /* renamed from: i */
    public static C0937s m8007i(InterfaceC0977e interfaceC0977e) {
        return m7987a(interfaceC0977e, f5952aE, f5953aF, f5954aG, f5955aH, f5939S, f5940T, f5941U, f5942V);
    }

    /* renamed from: j */
    public static C0937s m8009j(InterfaceC0977e interfaceC0977e) {
        return m7987a(interfaceC0977e, f5956aI, f5957aJ, f5958aK, f5959aL, f5943W, f5944X, f5945Y, f5946Z);
    }

    /* renamed from: k */
    public static C0937s m8011k(InterfaceC0977e interfaceC0977e) {
        return m7987a(interfaceC0977e, f5960aM, f5961aN, f5962aO, f5963aP, f5974aa, f5975ab, f5976ac, f5977ad);
    }

    /* renamed from: l */
    public static C0937s m8013l(InterfaceC0977e interfaceC0977e) {
        return m7987a(interfaceC0977e, f5964aQ, f5965aR, null, null, f5982ai, f5983aj, null, null);
    }

    /* renamed from: m */
    public static C0937s m8015m(InterfaceC0977e interfaceC0977e) {
        return m7987a(interfaceC0977e, f5966aS, f5967aT, null, null, f5984ak, f5985al, null, null);
    }

    /* renamed from: n */
    public static C0937s m8017n(InterfaceC0977e interfaceC0977e) {
        return m7987a(interfaceC0977e, f5968aU, f5969aV, null, null, f5986am, f5987an, null, null);
    }

    /* renamed from: o */
    public static C0937s m8019o(InterfaceC0977e interfaceC0977e) {
        return m7987a(interfaceC0977e, f5970aW, f5971aX, null, null, f5988ao, f5989ap, null, null);
    }

    /* renamed from: p */
    public static C0937s m8021p(InterfaceC0977e interfaceC0977e) {
        return m7987a(interfaceC0977e, f5972aY, f5973aZ, null, null, f5990aq, f5991ar, null, null);
    }

    /* renamed from: q */
    public static C0937s m8023q(InterfaceC0977e interfaceC0977e) {
        return m7987a(interfaceC0977e, f6027ba, f6028bb, null, null, f5992as, f5993at, null, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static C0937s m7987a(InterfaceC0977e interfaceC0977e, C0937s c0937s, C0937s c0937s2, C0937s c0937s3, C0937s c0937s4, C0937s c0937s5, C0937s c0937s6, C0937s c0937s7, C0937s c0937s8) {
        C0937s c0937s9;
        int mo6698e = interfaceC0977e.mo6853a(0).mo6698e();
        switch (interfaceC0977e.mo6856f_()) {
            case 1:
                switch (mo6698e) {
                    case 4:
                        c0937s3 = c0937s4;
                        c0937s9 = c0937s3;
                        if (c0937s9 == null) {
                            return m8025r(interfaceC0977e);
                        }
                        return c0937s9;
                    case 5:
                        c0937s9 = c0937s3;
                        if (c0937s9 == null) {
                        }
                        break;
                    case 6:
                        return c0937s;
                    case 7:
                        return c0937s2;
                    default:
                        c0937s3 = null;
                        c0937s9 = c0937s3;
                        if (c0937s9 == null) {
                        }
                        break;
                }
            case 2:
                switch (mo6698e) {
                    case 4:
                        c0937s9 = c0937s8;
                        break;
                    case 5:
                        c0937s9 = c0937s7;
                        break;
                    case 6:
                        return c0937s5;
                    case 7:
                        return c0937s6;
                }
                if (c0937s9 == null) {
                }
                break;
            default:
                c0937s9 = null;
                if (c0937s9 == null) {
                }
                break;
        }
    }

    /* renamed from: g */
    public static C0937s m8002g(InterfaceC0976d interfaceC0976d) {
        switch (interfaceC0976d.mo6698e()) {
            case 4:
                return f5981ah;
            case 5:
                return f5980ag;
            case 6:
                return f5978ae;
            case 7:
                return f5979af;
            default:
                return m8027t(interfaceC0976d);
        }
    }

    /* renamed from: h */
    public static C0937s m8004h(InterfaceC0976d interfaceC0976d) {
        switch (interfaceC0976d.mo6698e()) {
            case 6:
                return f5994au;
            case 7:
                return f5995av;
            default:
                return m8027t(interfaceC0976d);
        }
    }

    /* renamed from: i */
    public static C0937s m8006i(InterfaceC0976d interfaceC0976d) {
        switch (interfaceC0976d.mo6697c()) {
            case 4:
                return f6031be;
            case 5:
                return f6030bd;
            case 6:
            default:
                return m8027t(interfaceC0976d);
            case 7:
                return f6029bc;
        }
    }

    /* renamed from: j */
    public static C0937s m8008j(InterfaceC0976d interfaceC0976d) {
        switch (interfaceC0976d.mo6697c()) {
            case 4:
                return f6033bg;
            case 5:
                return f6032bf;
            default:
                return m8027t(interfaceC0976d);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:202)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:61)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.processFallThroughCases(SwitchRegionMaker.java:105)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    public static com.p065b.p086b.p103f.p105b.C0937s m7984a(com.p065b.p086b.p103f.p107d.InterfaceC0976d r2, com.p065b.p086b.p103f.p107d.InterfaceC0976d r3) {
        /*
            int r0 = r2.mo6698e()
            int r1 = r3.mo6698e()
            switch(r1) {
                case 4: goto L25;
                case 5: goto L22;
                case 6: goto L1c;
                case 7: goto L1f;
                default: goto Lb;
            }
        Lb:
            com.b.b.f.d.c r0 = r2.mo6695a()
            com.b.b.f.d.c r1 = r3.mo6695a()
            com.b.b.f.d.b r0 = com.p065b.p086b.p103f.p107d.C0974b.m8106a(r0, r1)
            com.b.b.f.b.s r0 = m8025r(r0)
        L1b:
            return r0
        L1c:
            switch(r0) {
                case 4: goto L32;
                case 5: goto L2f;
                case 6: goto L1f;
                case 7: goto L2c;
                default: goto L1f;
            }
        L1f:
            switch(r0) {
                case 4: goto L3b;
                case 5: goto L38;
                case 6: goto L35;
                default: goto L22;
            }
        L22:
            switch(r0) {
                case 4: goto L44;
                case 5: goto L25;
                case 6: goto L3e;
                case 7: goto L41;
                default: goto L25;
            }
        L25:
            switch(r0) {
                case 5: goto L29;
                case 6: goto L47;
                case 7: goto L4a;
                default: goto L28;
            }
        L28:
            goto Lb
        L29:
            com.b.b.f.b.s r0 = com.p065b.p086b.p103f.p105b.C0939u.f6042bp
            goto L1b
        L2c:
            com.b.b.f.b.s r0 = com.p065b.p086b.p103f.p105b.C0939u.f6037bk
            goto L1b
        L2f:
            com.b.b.f.b.s r0 = com.p065b.p086b.p103f.p105b.C0939u.f6040bn
            goto L1b
        L32:
            com.b.b.f.b.s r0 = com.p065b.p086b.p103f.p105b.C0939u.f6043bq
            goto L1b
        L35:
            com.b.b.f.b.s r0 = com.p065b.p086b.p103f.p105b.C0939u.f6034bh
            goto L1b
        L38:
            com.b.b.f.b.s r0 = com.p065b.p086b.p103f.p105b.C0939u.f6041bo
            goto L1b
        L3b:
            com.b.b.f.b.s r0 = com.p065b.p086b.p103f.p105b.C0939u.f6044br
            goto L1b
        L3e:
            com.b.b.f.b.s r0 = com.p065b.p086b.p103f.p105b.C0939u.f6035bi
            goto L1b
        L41:
            com.b.b.f.b.s r0 = com.p065b.p086b.p103f.p105b.C0939u.f6038bl
            goto L1b
        L44:
            com.b.b.f.b.s r0 = com.p065b.p086b.p103f.p105b.C0939u.f6045bs
            goto L1b
        L47:
            com.b.b.f.b.s r0 = com.p065b.p086b.p103f.p105b.C0939u.f6036bj
            goto L1b
        L4a:
            com.b.b.f.b.s r0 = com.p065b.p086b.p103f.p105b.C0939u.f6039bm
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p065b.p086b.p103f.p105b.C0939u.m7984a(com.b.b.f.d.d, com.b.b.f.d.d):com.b.b.f.b.s");
    }

    /* renamed from: k */
    public static C0937s m8010k(InterfaceC0976d interfaceC0976d) {
        switch (interfaceC0976d.mo6698e()) {
            case 0:
                return f6049bw;
            case 1:
            case 2:
            case 3:
            case 8:
            default:
                return m8027t(interfaceC0976d);
            case 4:
                return f6001bA;
            case 5:
                return f6052bz;
            case 6:
                return f6050bx;
            case 7:
                return f6051by;
            case 9:
                return f6002bB;
        }
    }

    /* renamed from: l */
    public static C0937s m8012l(InterfaceC0976d interfaceC0976d) {
        switch (interfaceC0976d.mo6697c()) {
            case 1:
                return f6012bL;
            case 2:
                return f6013bM;
            case 3:
                return f6014bN;
            case 4:
                return f6010bJ;
            case 5:
                return f6009bI;
            case 6:
                return f6007bG;
            case 7:
                return f6008bH;
            case 8:
                return f6015bO;
            case 9:
                return f6011bK;
            default:
                return m8027t(interfaceC0976d);
        }
    }

    /* renamed from: m */
    public static C0937s m8014m(InterfaceC0976d interfaceC0976d) {
        switch (interfaceC0976d.mo6697c()) {
            case 1:
                return f6021bU;
            case 2:
                return f6022bV;
            case 3:
                return f6023bW;
            case 4:
                return f6019bS;
            case 5:
                return f6018bR;
            case 6:
                return f6016bP;
            case 7:
                return f6017bQ;
            case 8:
                return f6024bX;
            case 9:
                return f6020bT;
            default:
                return m8027t(interfaceC0976d);
        }
    }

    /* renamed from: n */
    public static C0937s m8016n(InterfaceC0976d interfaceC0976d) {
        C0975c mo6695a = interfaceC0976d.mo6695a();
        switch (mo6695a.m8138u().mo6697c()) {
            case 1:
                return f6082cd;
            case 2:
                return f6083ce;
            case 3:
                return f6084cf;
            case 4:
                return f6081cc;
            case 5:
                return f6080cb;
            case 6:
                return f6026bZ;
            case 7:
                return f6079ca;
            case 8:
                return f6085cg;
            case 9:
                return new C0937s(41, mo6695a, C0974b.f6210b, C0924f.f5877l, "new-array-object");
            default:
                return m8027t(mo6695a);
        }
    }

    /* renamed from: a */
    public static C0937s m7983a(InterfaceC0976d interfaceC0976d, int i) {
        C0975c m8138u = interfaceC0976d.mo6695a().m8138u();
        if (m8138u.m8129l()) {
            return m8027t(interfaceC0976d);
        }
        if (i < 0) {
            throw new IllegalArgumentException("count < 0");
        }
        C0974b c0974b = new C0974b(i);
        for (int i2 = 0; i2 < i; i2++) {
            c0974b.m8114a(i2, m8138u);
        }
        return new C0937s(42, c0974b, C0924f.f5874i);
    }

    /* renamed from: o */
    public static C0937s m8018o(InterfaceC0976d interfaceC0976d) {
        switch (interfaceC0976d.mo6697c()) {
            case 1:
                return f6093co;
            case 2:
                return f6094cp;
            case 3:
                return f6095cq;
            case 4:
                return f6091cm;
            case 5:
                return f6090cl;
            case 6:
                return f6088cj;
            case 7:
                return f6089ck;
            case 8:
                return f6096cr;
            case 9:
                return f6092cn;
            default:
                return m8027t(interfaceC0976d);
        }
    }

    /* renamed from: p */
    public static C0937s m8020p(InterfaceC0976d interfaceC0976d) {
        switch (interfaceC0976d.mo6697c()) {
            case 1:
                return f6060cG;
            case 2:
                return f6061cH;
            case 3:
                return f6062cI;
            case 4:
                return f6058cE;
            case 5:
                return f6057cD;
            case 6:
                return f6055cB;
            case 7:
                return f6056cC;
            case 8:
                return f6063cJ;
            case 9:
                return f6059cF;
            default:
                return m8027t(interfaceC0976d);
        }
    }

    /* renamed from: q */
    public static C0937s m8022q(InterfaceC0976d interfaceC0976d) {
        switch (interfaceC0976d.mo6697c()) {
            case 1:
                return f6102cx;
            case 2:
                return f6103cy;
            case 3:
                return f6104cz;
            case 4:
                return f6100cv;
            case 5:
                return f6099cu;
            case 6:
                return f6097cs;
            case 7:
                return f6098ct;
            case 8:
                return f6054cA;
            case 9:
                return f6101cw;
            default:
                return m8027t(interfaceC0976d);
        }
    }

    /* renamed from: r */
    public static C0937s m8024r(InterfaceC0976d interfaceC0976d) {
        switch (interfaceC0976d.mo6697c()) {
            case 1:
                return f6069cP;
            case 2:
                return f6070cQ;
            case 3:
                return f6071cR;
            case 4:
                return f6067cN;
            case 5:
                return f6066cM;
            case 6:
                return f6064cK;
            case 7:
                return f6065cL;
            case 8:
                return f6072cS;
            case 9:
                return f6068cO;
            default:
                return m8027t(interfaceC0976d);
        }
    }

    /* renamed from: a */
    public static C0937s m7981a(C0973a c0973a) {
        return new C0937s(49, c0973a.m8105d(), C0974b.f6216h);
    }

    /* renamed from: b */
    public static C0937s m7988b(C0973a c0973a) {
        return new C0937s(50, c0973a.m8105d(), C0974b.f6216h);
    }

    /* renamed from: c */
    public static C0937s m7991c(C0973a c0973a) {
        return new C0937s(51, c0973a.m8105d(), C0974b.f6216h);
    }

    /* renamed from: d */
    public static C0937s m7994d(C0973a c0973a) {
        return new C0937s(52, c0973a.m8105d(), C0974b.f6216h);
    }

    /* renamed from: e */
    public static C0937s m7997e(C0973a c0973a) {
        return new C0937s(53, c0973a.m8105d(), C0974b.f6216h);
    }

    /* renamed from: s */
    public static C0937s m8026s(InterfaceC0976d interfaceC0976d) {
        switch (interfaceC0976d.mo6698e()) {
            case 4:
                return f6076cW;
            case 5:
                return f6075cV;
            case 6:
                return f6073cT;
            case 7:
                return f6074cU;
            case 8:
            default:
                return m8027t(interfaceC0976d);
            case 9:
                return f6077cX;
        }
    }

    /* renamed from: t */
    private static C0937s m8027t(InterfaceC0976d interfaceC0976d) {
        throw new IllegalArgumentException("bad type: " + interfaceC0976d);
    }

    /* renamed from: r */
    private static C0937s m8025r(InterfaceC0977e interfaceC0977e) {
        throw new IllegalArgumentException("bad types: " + interfaceC0977e);
    }
}
