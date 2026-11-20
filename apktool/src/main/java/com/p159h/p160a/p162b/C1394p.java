package com.p159h.p160a.p162b;

import java.p209io.IOException;
import java.p209io.Reader;
import ru.maximoff.apktool.util.C3249i;

/* compiled from: LuaLexer.java */
/* renamed from: com.h.a.b.p */
/* loaded from: classes.dex */
public class C1394p {

    /* renamed from: b */
    private static final int f9048b = C3249i.m19500a();

    /* renamed from: c */
    private static final int[] f9049c = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};

    /* renamed from: d */
    private static final char[] f9050d = m11110a("\t\u0000\u0001\u0001\u0001\u0002\u00016\u00016\u0001\u0003\u0012\u0000\u0001\u0001\u0001$\u0001!\u0001#\u0001\u0000\u0001)\u0001\u0000\u0001\"\u0001+\u0001,\u0001(\u0001\b\u00010\u0001\u000e\u0001\f\u0001*\u0001\t\t\u0006\u00012\u00011\u0001&\u0001\r\u0001%\u0002\u0000\u0004\u000b\u0001\u0007\u0001\u000b\u0011\u0005\u0001\n\u0002\u0005\u0001\u0004\u00014\u0001-\u00013\u0001\u0005\u0001\u0000\u0001\u000f\u0001\u0012\u0001\u001c\u0001\u0011\u0001\u0014\u0001\u001a\u0001\u0005\u0001\u001f\u0001\u0019\u0001\u0005\u0001\u0015\u0001\u0017\u0001\u0005\u0001\u0010\u0001\u0016\u0001\u001e\u0001\u0005\u0001\u0013\u0001\u0018\u0001\u001d\u0001\u001b\u00015\u0001 \u0001\n\u0002\u0005\u0001.\u0001\u0000\u0001/\u0001'\u0006\u0000\u00016ᾢ\u0000\u00016\u00016\uffff\u0000\uffff\u0000\uffff\u0000\uffff\u0000\uffff\u0000\uffff\u0000\uffff\u0000\uffff\u0000\uffff\u0000\uffff\u0000\uffff\u0000\uffff\u0000\uffff\u0000\uffff\u0000\uffff\u0000\uffff\u0000\udfe6\u0000");

    /* renamed from: e */
    private static final int[] f9051e = m11115d();

    /* renamed from: f */
    private static final int[] f9052f = m11116e();

    /* renamed from: g */
    private static final int[] f9053g = m11117f();

    /* renamed from: h */
    private static final String[] f9054h = {"Unknown internal scanner error", "Error: could not match input", "Error: pushback value was too large"};

    /* renamed from: i */
    private static final int[] f9055i = m11118g();

    /* renamed from: j */
    private Reader f9057j;

    /* renamed from: k */
    private int f9058k;

    /* renamed from: n */
    private int f9061n;

    /* renamed from: o */
    private int f9062o;

    /* renamed from: p */
    private int f9063p;

    /* renamed from: q */
    private int f9064q;

    /* renamed from: s */
    private boolean f9066s;

    /* renamed from: t */
    private boolean f9067t;

    /* renamed from: l */
    private int f9059l = 0;

    /* renamed from: m */
    private char[] f9060m = new char[f9048b];

    /* renamed from: r */
    private boolean f9065r = true;

    /* renamed from: u */
    private int f9068u = 0;

    /* renamed from: a */
    b f9056a = new b();

    /* renamed from: d */
    private static int[] m11115d() {
        int[] iArr = new int[163];
        m11109a("\u0007\u0000\u0001\u0001\u0001\u0002\u0002\u0003\u0001\u0004\u0001\u0005\u0001\u0006\u0001\u0007\u0001\u0006\u0001\b\u0001\t\u0001\n\r\u0005\u0001\u000b\u0001\f\u0001\r\u0001\u000e\u0001\u000f\u0001\u0001\u0001\u0010\u0001\u0011\u0001\u0012\u0001\u0013\u0001\u0014\u0001\u0015\u0001\u0016\u0001\u0017\u0001\u0018\u0001\u0019\u0001\u001a\u0001\u001b\u0003\u001c\u0001\u001d\u0002\u001e\u0001\u001f\u0002 \u0003!\u0001\"\u0002#\u0001$\u0001\"\u0002%\u0001$\u0001\"\u0001&\u0002\u0000\u0001\u0006\u0001\u0000\u0001\u0006\u0001'\u0001(\u0001)\u0003\u0005\u0001*\u0004\u0005\u0001+\u0001\u0005\u0001,\u0001-\u0007\u0005\u0001.\u0001/\u00010\u00011\u0001\u0000\u00012\u0001\u0000\u00013\u0001\u0000\u0002\u0006\u00014\u0001\u0000\u0001)\u00015\u00016\u00017\u0003\u0005\u00018\u0003\u0005\u00019\u0005\u0005\u0001:\u0001\u0000\u0002;\u0003\u0005\u0001<\u0004\u0005\u0001=\u0001>\u0001\u0005\u0002\u0000\u0001?\u0003\u0005\u0001@\u0001A\u0001\u0005\u0001B\u0001C\u0001\u0000\u0001D\u0001E\u0001F\u0001\u0005\u0001\u0000\u0001\u0005\u0001G", 0, iArr);
        return iArr;
    }

    /* renamed from: a */
    private static int m11109a(String str, int i, int[] iArr) {
        int i2;
        int i3 = 0;
        int length = str.length();
        int i4 = i;
        while (i3 < length) {
            int i5 = i3 + 1;
            int charAt = str.charAt(i3);
            int i6 = i5 + 1;
            char charAt2 = str.charAt(i5);
            while (true) {
                i2 = i4 + 1;
                iArr[i4] = charAt2;
                charAt--;
                if (charAt <= 0) {
                    break;
                }
                i4 = i2;
            }
            i4 = i2;
            i3 = i6;
        }
        return i4;
    }

    /* renamed from: e */
    private static int[] m11116e() {
        int[] iArr = new int[163];
        m11111b("\u0000\u0000\u00007\u0000n\u0000¥\u0000Ü\u0000ē\u0000Ŋ\u0000Ɓ\u0000Ƹ\u0000Ɓ\u0000ǯ\u0000Ȧ\u0000ɝ\u0000ʔ\u0000Ɓ\u0000ˋ\u0000̂\u0000̹\u0000Ͱ\u0000Χ\u0000Ϟ\u0000Е\u0000ь\u0000҃\u0000Һ\u0000ӱ\u0000Ԩ\u0000՟\u0000֖\u0000\u05cd\u0000\u0604\u0000ػ\u0000Ɓ\u0000Ɓ\u0000ٲ\u0000ک\u0000۠\u0000ܗ\u0000Ɓ\u0000Ɓ\u0000Ɓ\u0000Ɓ\u0000Ɓ\u0000Ɓ\u0000Ɓ\u0000Ɓ\u0000Ɓ\u0000Ɓ\u0000Ɓ\u0000Ɓ\u0000Ɓ\u0000ݎ\u0000ޅ\u0000Ɓ\u0000Ɓ\u0000\u07bc\u0000Ɓ\u0000Ɓ\u0000߳\u0000Ɓ\u0000ࠪ\u0000ࡡ\u0000Ɓ\u0000Ɓ\u0000࢘\u0000࣏\u0000आ\u0000Ɓ\u0000ऽ\u0000ॴ\u0000ফ\u0000Ɓ\u0000Ȧ\u0000ৢ\u0000ਙ\u0000\u0a50\u0000ઇ\u0000ા\u0000Ɓ\u0000\u0af5\u0000ବ\u0000ୣ\u0000ச\u0000ɝ\u0000\u0bd1\u0000ఈ\u0000ి\u0000\u0c76\u0000ɝ\u0000ಭ\u0000ɝ\u0000ɝ\u0000\u0ce4\u0000ഛ\u0000\u0d52\u0000ඉ\u0000ව\u0000\u0df7\u0000ฮ\u0000Ɓ\u0000Ɓ\u0000Ɓ\u0000Ɓ\u0000ޅ\u0000Ɓ\u0000ࡡ\u0000Ɓ\u0000ઇ\u0000\u0e65\u0000\u0a50\u0000Ɓ\u0000ຜ\u0000໓\u0000ɝ\u0000ɝ\u0000ɝ\u0000༊\u0000ཁ\u0000ླྀ\u0000ɝ\u0000ྯ\u0000\u0fe6\u0000ဝ\u0000ɝ\u0000ၔ\u0000ႋ\u0000Ⴢ\u0000ჹ\u0000ᄰ\u0000Ɓ\u0000ᅧ\u0000ᆞ\u0000ᇕ\u0000ሌ\u0000ቃ\u0000ቺ\u0000\u12b1\u0000የ\u0000ጟ\u0000ፖ\u0000ᎍ\u0000ɝ\u0000ɝ\u0000Ꮔ\u0000ᆞ\u0000ᏻ\u0000ɝ\u0000ᐲ\u0000ᑩ\u0000ᒠ\u0000ɝ\u0000ɝ\u0000ᓗ\u0000ɝ\u0000ɝ\u0000ᔎ\u0000ɝ\u0000ɝ\u0000ɝ\u0000ᕅ\u0000ᕼ\u0000ᖳ\u0000ɝ", 0, iArr);
        return iArr;
    }

    /* renamed from: b */
    private static int m11111b(String str, int i, int[] iArr) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            int charAt = str.charAt(i2) << 16;
            i2 = i3 + 1;
            iArr[i] = str.charAt(i3) | charAt;
            i++;
        }
        return i;
    }

    /* renamed from: f */
    private static int[] m11117f() {
        int[] iArr = new int[5610];
        m11112c("\u0001\b\u0001\t\u0001\n\u0001\u000b\u0001\f\u0001\r\u0001\u000e\u0001\r\u0001\u000f\u0001\u0010\u0002\r\u0001\u0011\u0001\u0012\u0001\u0013\u0001\u0014\u0001\u0015\u0001\u0016\u0001\u0017\u0001\u0018\u0001\u0019\u0001\r\u0001\u001a\u0001\u001b\u0001\r\u0001\u001c\u0001\u001d\u0001\u001e\u0001\r\u0001\u001f\u0002\r\u0001 \u0001!\u0001\"\u0001#\u0001\b\u0001$\u0001%\u0001&\u0001'\u0001(\u0001)\u0001*\u0001+\u0001,\u0001-\u0001.\u0001/\u00010\u00011\u00012\u0001\b\u0001\r\u0001\u0000\u00033\u00014)3\u00015\b3\u0001\u0000\u00026\u00017\u0001826\u0001\u0000\u00029\u0001:\u0001;29\u0001\u0000\u0003<\u0001=)<\u0001>\b<\u0001\u0000\u0002?\u0001@\u0001A\u001d?\u0001B\u0012?\u0001C\u0001?\u0001\u0000\u0002?\u0001D\u0001E\u001e?\u0001F\u0011?\u0001G\u0001?9\u0000\u0001\t7\u0000\u0001\n8\u0000\u0001H\b\u0000\u0001I.\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0012\r\u0014\u0000\u0001\r\u0007\u0000\u0001\u000e\u0001J\u0001\u0000\u0001\u000e\u0002\u0000\u0001K\u0007\u0000\u0001J(\u0000\u0001\u000e\u0001J\u0001\u0000\u0001\u000e\u0001L\u0001\u0000\u0001K\u0007\u0000\u0001J(\u0000\u0001M\u0002\u0000\u0001M\u0002\u0000\u0001N7\u0000\u0001O7\u0000\u0001P-\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0001\r\u0001Q\u0010\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0007\r\u0001R\u0002\r\u0001S\u0007\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0007\r\u0001T\n\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0004\r\u0001U\r\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0005\r\u0001V\f\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0001\r\u0001W\u0006\r\u0001X\t\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0004\r\u0001Y\r\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0007\r\u0001Z\n\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0001\r\u0001[\t\r\u0001\\\u0006\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0001]\u0006\r\u0001^\u0004\r\u0001_\u0005\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0001\r\u0001`\u0010\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0004\r\u0001a\u000b\r\u0001b\u0001\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0010\r\u0001c\u0001\r\u0014\u0000\u0001\r%\u0000\u0001d\u001f\u0000\u0001e6\u0000\u0001f6\u0000\u0001g+\u0000\u00013A\u0000\u0001h\u001f\u0000\u0001i\u000b\u0000\u000176\u0000\u0001:6\u0000\u0001<A\u0000\u0001j\u001f\u0000\u0001k\u000b\u0000\u0001@U\u0000\u0001?\u0017\u0000\u0001?\u0001\u0000\u0001?\n\u0000\u0002?\u0001\u0000\u0002?\u0006\u0000\u0001?\u0002\u0000\u0001?\u0003\u0000\u0002?\n\u0000\u0001?\u0006\u0000\u0002?\u0003\u0000\u0001DV\u0000\u0001?\u0016\u0000\u0001?\u0001\u0000\u0001?\n\u0000\u0002?\u0001\u0000\u0002?\u0006\u0000\u0001?\u0002\u0000\u0001?\u0004\u0000\u0001?\n\u0000\u0001?\u0006\u0000\u0002?\u0007\u0000\u0001M\u0001\u0000\u0001l\u0001M\u0004\u0000\u0001l.\u0000\u0001m\u0002\u0000\u0001m3\u0000\u0002n\u0001\u0000\u0001n\u0001\u0000\u0001n\u0003\u0000\u0001n\u0001\u0000\u0002n\u0001\u0000\u0001n\u0005\u0000\u0001n\u0001\u0000\u0001n \u0000\u0001M\u0002\u0000\u0001M9\u0000\u0001o.\u0000\u0001p\t\u0000\u0001q-\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0002\r\u0001r\u000f\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u000e\r\u0001s\u0003\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\b\r\u0001t\t\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0005\r\u0001u\f\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u000e\r\u0001v\u0001w\u0002\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0002\r\u0001x\u000f\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\t\r\u0001y\b\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\r\r\u0001z\u0004\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\b\r\u0001{\t\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0004\r\u0001|\r\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0001\r\u0001}\u0010\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u000e\r\u0001~\u0003\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\f\r\u0001\u007f\u0005\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0005\r\u0001\u0080\f\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\n\r\u0001\u0081\u0007\r\u0014\u0000\u0001\r\u0007\u0000\u0001m\u0001J\u0001\u0000\u0001m\n\u0000\u0001J&\u0000\u0001\u0082\b\u0000\u0001p)\u0000\u0002\u0083\u0001\u0084\u0001\u0085\n\u0083\u0001q(\u0083\u0005\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0001\u0086\u0011\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\f\r\u0001\u0087\u0005\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0005\r\u0001\u0088\f\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0005\r\u0001\u0089\f\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0001\u008a\u0011\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\t\r\u0001\u008b\b\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\r\r\u0001\u008c\u0004\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\n\r\u0001\u008d\u0007\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0005\r\u0001\u008e\f\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0001\r\u0001\u008f\u0010\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\b\r\u0001\u0090\t\r\u0014\u0000\u0001\r\u0001\u0000\u0002\u0083\u0001\u0084\u0001\u00853\u0083\u0001\u0000\u0001\u0091\f\u0000\u0001\u0092)\u0000\u0001\u0091\u0001\u0084\u000b\u0000\u0001\u0092-\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0006\r\u0001\u0093\u000b\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0004\r\u0001\u0094\r\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0001\u0095\u0011\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\n\r\u0001\u0096\u0007\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\b\r\u0001\u0097\t\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0005\r\u0001\u0098\f\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u000e\r\u0001\u0099\u0003\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\b\r\u0001\u009a\t\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0005\r\u0001\u009b\f\r\u0014\u0000\u0001\r\u000f\u0000\u0001\u009c-\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0001\r\u0001\u009d\u0010\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u000e\r\u0001\u009e\u0003\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u000b\r\u0001\u009f\u0006\r\u0014\u0000\u0001\r\u0006\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\n\r\u0001 \u0007\r\u0014\u0000\u0001\r\u0001\u0000\u0002\u0083\u0001\u0084\u0001\u0085\u0001¡2\u0083\u0005\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0007\r\u0001¢\n\r\u0014\u0000\u0001\r\u0003\u0000\u0001\u0084\u0001\u00858\u0000\u0003\r\u0001\u0000\u0003\r\u0003\u0000\u0001\r\u0001£\u0010\r\u0014\u0000\u0001\r\u0001\u0000", 0, iArr);
        return iArr;
    }

    /* renamed from: c */
    private static int m11112c(String str, int i, int[] iArr) {
        int i2;
        int i3 = 0;
        int length = str.length();
        int i4 = i;
        while (i3 < length) {
            int i5 = i3 + 1;
            int charAt = str.charAt(i3);
            int i6 = i5 + 1;
            int charAt2 = str.charAt(i5) - 1;
            while (true) {
                i2 = i4 + 1;
                iArr[i4] = charAt2;
                charAt--;
                if (charAt <= 0) {
                    break;
                }
                i4 = i2;
            }
            i4 = i2;
            i3 = i6;
        }
        return i4;
    }

    /* renamed from: g */
    private static int[] m11118g() {
        int[] iArr = new int[163];
        m11114d("\u0007\u0000\u0001\t\u0001\u0001\u0001\t\u0004\u0001\u0001\t\u0011\u0001\u0002\t\u0004\u0001\r\t\u0002\u0001\u0002\t\u0001\u0001\u0002\t\u0001\u0001\u0001\t\u0002\u0001\u0002\t\u0003\u0001\u0001\t\u0003\u0001\u0001\t\u0002\u0000\u0001\u0001\u0001\u0000\u0002\u0001\u0001\t\u0014\u0001\u0004\t\u0001\u0000\u0001\t\u0001\u0000\u0001\t\u0001\u0000\u0002\u0001\u0001\t\u0001\u0000\u0011\u0001\u0001\t\u0001\u0000\r\u0001\u0002\u0000\t\u0001\u0001\u0000\u0004\u0001\u0001\u0000\u0002\u0001", 0, iArr);
        return iArr;
    }

    /* renamed from: d */
    private static int m11114d(String str, int i, int[] iArr) {
        int i2;
        int i3 = 0;
        int length = str.length();
        int i4 = i;
        while (i3 < length) {
            int i5 = i3 + 1;
            int charAt = str.charAt(i3);
            int i6 = i5 + 1;
            char charAt2 = str.charAt(i5);
            while (true) {
                i2 = i4 + 1;
                iArr[i4] = charAt2;
                charAt--;
                if (charAt <= 0) {
                    break;
                }
                i4 = i2;
            }
            i4 = i2;
            i3 = i6;
        }
        return i4;
    }

    /* compiled from: LuaLexer.java */
    /* renamed from: com.h.a.b.p$b */
    static class b {

        /* renamed from: a */
        int f9071a = 0;

        /* renamed from: a */
        boolean m11128a(CharSequence charSequence) {
            return this.f9071a == m11126c(charSequence);
        }

        /* renamed from: a */
        void m11127a() {
            this.f9071a = 0;
        }

        /* renamed from: b */
        void m11129b(CharSequence charSequence) {
            this.f9071a = m11126c(charSequence);
        }

        /* renamed from: c */
        private static int m11126c(CharSequence charSequence) {
            int i = 0;
            int i2 = 0;
            while (charSequence.charAt(i2) == '-') {
                i2++;
            }
            while (charSequence.length() > i2 + i && charSequence.charAt(i2 + 1 + i) == '=') {
                i++;
            }
            return i;
        }
    }

    public C1394p(CharSequence charSequence) {
        this.f9057j = new a(charSequence);
    }

    /* renamed from: a */
    private static char[] m11110a(String str) {
        int i;
        char[] cArr = new char[1114112];
        int i2 = 0;
        int i3 = 0;
        while (i3 < 188) {
            int i4 = i3 + 1;
            int charAt = str.charAt(i3);
            int i5 = i4 + 1;
            char charAt2 = str.charAt(i4);
            while (true) {
                i = i2 + 1;
                cArr[i2] = charAt2;
                charAt--;
                if (charAt <= 0) {
                    break;
                }
                i2 = i;
            }
            i2 = i;
            i3 = i5;
        }
        return cArr;
    }

    /* renamed from: h */
    private boolean m11119h() {
        if (this.f9063p > 0) {
            this.f9064q += this.f9068u;
            this.f9068u = 0;
            System.arraycopy(this.f9060m, this.f9063p, this.f9060m, 0, this.f9064q - this.f9063p);
            this.f9064q -= this.f9063p;
            this.f9062o -= this.f9063p;
            this.f9061n -= this.f9063p;
            this.f9063p = 0;
        }
        if (this.f9062o >= this.f9060m.length - this.f9068u) {
            char[] cArr = new char[this.f9060m.length * 2];
            System.arraycopy(this.f9060m, 0, cArr, 0, this.f9060m.length);
            this.f9060m = cArr;
            this.f9064q += this.f9068u;
            this.f9068u = 0;
        }
        int length = this.f9060m.length - this.f9064q;
        int read = this.f9057j.read(this.f9060m, this.f9064q, length);
        if (read == 0) {
            throw new IOException("Reader returned 0 characters. See JFlex examples for workaround.");
        }
        if (read <= 0) {
            return true;
        }
        this.f9064q += read;
        if (read != length || !Character.isHighSurrogate(this.f9060m[this.f9064q - 1])) {
            return false;
        }
        this.f9064q--;
        this.f9068u = 1;
        return false;
    }

    /* renamed from: a */
    public final void m11122a(int i) {
        this.f9059l = i;
    }

    /* renamed from: a */
    public final String m11121a() {
        return new String(this.f9060m, this.f9063p, this.f9061n - this.f9063p);
    }

    /* renamed from: b */
    public final int m11123b() {
        return this.f9061n - this.f9063p;
    }

    /* renamed from: c */
    private void m11113c(int i) {
        String str;
        try {
            str = f9054h[i];
        } catch (ArrayIndexOutOfBoundsException e2) {
            str = f9054h[0];
        }
        throw new Error(str);
    }

    /* renamed from: b */
    public void m11124b(int i) {
        if (i > m11123b()) {
            m11113c(2);
        }
        this.f9061n -= i;
    }

    /* renamed from: i */
    private void m11120i() {
        if (this.f9067t) {
            return;
        }
        this.f9067t = true;
    }

    /* renamed from: c */
    public EnumC1395q m11125c() {
        int i;
        int charCount;
        int i2 = this.f9064q;
        char[] cArr = this.f9060m;
        char[] cArr2 = f9050d;
        int[] iArr = f9053g;
        int[] iArr2 = f9052f;
        int[] iArr3 = f9055i;
        while (true) {
            int i3 = this.f9061n;
            int i4 = -1;
            this.f9063p = i3;
            this.f9062o = i3;
            this.f9058k = f9049c[this.f9059l];
            if ((iArr3[this.f9058k] & 1) == 1) {
                i4 = this.f9058k;
            }
            int i5 = i3;
            int i6 = i3;
            int i7 = i4;
            while (true) {
                if (i6 < i2) {
                    int codePointAt = Character.codePointAt(cArr, i6, i2);
                    charCount = Character.charCount(codePointAt) + i6;
                    i = codePointAt;
                } else if (this.f9066s) {
                    i = -1;
                } else {
                    this.f9062o = i6;
                    this.f9061n = i5;
                    boolean m11119h = m11119h();
                    int i8 = this.f9062o;
                    i5 = this.f9061n;
                    cArr = this.f9060m;
                    i2 = this.f9064q;
                    if (m11119h) {
                        i = -1;
                    } else {
                        int codePointAt2 = Character.codePointAt(cArr, i8, i2);
                        charCount = Character.charCount(codePointAt2) + i8;
                        i = codePointAt2;
                    }
                }
                int i9 = iArr[iArr2[this.f9058k] + cArr2[i]];
                if (i9 != -1) {
                    this.f9058k = i9;
                    int i10 = iArr3[this.f9058k];
                    if ((i10 & 1) == 1) {
                        int i11 = this.f9058k;
                        if ((i10 & 8) == 8) {
                            i5 = charCount;
                            i7 = i11;
                        } else {
                            i5 = charCount;
                            i6 = charCount;
                            i7 = i11;
                        }
                    } else {
                        i6 = charCount;
                    }
                }
            }
            this.f9061n = i5;
            if (i == -1 && this.f9063p == this.f9062o) {
                this.f9066s = true;
                m11120i();
                return (EnumC1395q) null;
            }
            if (i7 >= 0) {
                i7 = f9051e[i7];
            }
            switch (i7) {
                case 1:
                    return EnumC1395q.WRONG;
                case 2:
                    return EnumC1395q.WS;
                case 3:
                    return EnumC1395q.NEWLINE;
                case 4:
                    return EnumC1395q.LBRACK;
                case 5:
                    return EnumC1395q.NAME;
                case 6:
                    return EnumC1395q.NUMBER;
                case 7:
                    return EnumC1395q.PLUS;
                case 8:
                    return EnumC1395q.DOT;
                case 9:
                    return EnumC1395q.ASSIGN;
                case 10:
                    return EnumC1395q.MINUS;
                case 11:
                    m11122a(10);
                    return EnumC1395q.STRING;
                case 12:
                    m11122a(12);
                    return EnumC1395q.STRING;
                case 13:
                    return EnumC1395q.GETN;
                case 14:
                    return EnumC1395q.GT;
                case 15:
                    return EnumC1395q.LT;
                case 16:
                    return EnumC1395q.MULT;
                case 17:
                    return EnumC1395q.MOD;
                case 18:
                    return EnumC1395q.DIV;
                case 19:
                    return EnumC1395q.LPAREN;
                case 20:
                    return EnumC1395q.RPAREN;
                case 21:
                    return EnumC1395q.RBRACK;
                case 22:
                    return EnumC1395q.LCURLY;
                case 23:
                    return EnumC1395q.RCURLY;
                case 24:
                    return EnumC1395q.COMMA;
                case 25:
                    return EnumC1395q.SEMI;
                case 26:
                    return EnumC1395q.COLON;
                case 27:
                    return EnumC1395q.EXP;
                case 28:
                    return EnumC1395q.LONGSTRING;
                case 29:
                    m11124b(m11121a().length());
                    m11122a(2);
                    return m11125c();
                case 30:
                    return EnumC1395q.NL_BEFORE_LONGSTRING;
                case 31:
                    return EnumC1395q.SHORTCOMMENT;
                case 32:
                    m11122a(0);
                    m11124b(m11121a().length());
                    return m11125c();
                case 33:
                    return EnumC1395q.LONGCOMMENT;
                case 34:
                    return EnumC1395q.STRING;
                case 35:
                    m11122a(0);
                    return EnumC1395q.WRONG;
                case 36:
                    m11122a(0);
                    return EnumC1395q.STRING;
                case 37:
                    m11122a(0);
                    return EnumC1395q.WRONG;
                case 38:
                    this.f9056a.m11129b(m11121a().toString());
                    m11122a(4);
                    return EnumC1395q.LONGSTRING_BEGIN;
                case 39:
                    return EnumC1395q.CONCAT;
                case 40:
                    return EnumC1395q.EQ;
                case 41:
                    m11124b(m11121a().length());
                    m11122a(6);
                    return m11125c();
                case 42:
                    return EnumC1395q.DO;
                case 43:
                    return EnumC1395q.OR;
                case 44:
                    return EnumC1395q.IN;
                case 45:
                    return EnumC1395q.IF;
                case 46:
                    m11122a(6);
                    return EnumC1395q.SHEBANG;
                case 47:
                    return EnumC1395q.GE;
                case 48:
                    return EnumC1395q.LE;
                case 49:
                    return EnumC1395q.NE;
                case 50:
                    if (this.f9056a.m11128a(m11121a())) {
                        m11122a(0);
                        this.f9056a.m11127a();
                        return EnumC1395q.LONGSTRING_END;
                    }
                    m11124b(m11121a().length() - 1);
                    return EnumC1395q.LONGSTRING;
                case 51:
                    if (this.f9056a.m11128a(m11121a())) {
                        m11122a(0);
                        this.f9056a.m11127a();
                        return EnumC1395q.LONGCOMMENT_END;
                    }
                    m11124b(m11121a().length() - 1);
                    return EnumC1395q.LONGCOMMENT;
                case 52:
                    return EnumC1395q.ELLIPSIS;
                case 53:
                    return EnumC1395q.AND;
                case 54:
                    return EnumC1395q.NOT;
                case 55:
                    return EnumC1395q.NIL;
                case 56:
                    return EnumC1395q.END;
                case 57:
                    return EnumC1395q.FOR;
                case 58:
                    this.f9056a.m11129b(m11121a().toString());
                    m11122a(8);
                    return EnumC1395q.LONGCOMMENT_BEGIN;
                case 59:
                    m11124b(1);
                    return EnumC1395q.LUADOC_COMMENT;
                case 60:
                    return EnumC1395q.ELSE;
                case 61:
                    return EnumC1395q.TRUE;
                case 62:
                    return EnumC1395q.THEN;
                case 63:
                    return EnumC1395q.BREAK;
                case 64:
                    return EnumC1395q.LOCAL;
                case 65:
                    return EnumC1395q.FALSE;
                case 66:
                    return EnumC1395q.UNTIL;
                case 67:
                    return EnumC1395q.WHILE;
                case 68:
                    return EnumC1395q.RETURN;
                case 69:
                    return EnumC1395q.REPEAT;
                case 70:
                    return EnumC1395q.ELSEIF;
                case 71:
                    return EnumC1395q.FUNCTION;
                case 72:
                case 73:
                case 74:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
                case 81:
                case 82:
                case 83:
                case 84:
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                case 109:
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                case 115:
                case 116:
                case 117:
                case 118:
                case 119:
                case 120:
                case 121:
                case 122:
                case 123:
                case 124:
                case 125:
                case 126:
                case 127:
                case 128:
                case 129:
                case 130:
                case 131:
                case 132:
                case 133:
                case 134:
                case 135:
                case 136:
                case 137:
                case 138:
                case 139:
                case 140:
                case 141:
                case 142:
                    break;
                default:
                    m11113c(1);
                    break;
            }
        }
    }

    /* compiled from: LuaLexer.java */
    /* renamed from: com.h.a.b.p$a */
    static class a extends Reader {

        /* renamed from: a */
        int f9069a = 0;

        /* renamed from: b */
        CharSequence f9070b;

        a(CharSequence charSequence) {
            this.f9070b = charSequence;
        }

        @Override // java.p209io.Reader, java.p209io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f9070b = (CharSequence) null;
            this.f9069a = 0;
        }

        @Override // java.p209io.Reader
        public int read(char[] cArr, int i, int i2) {
            int min = Math.min(this.f9070b.length() - this.f9069a, i2);
            int i3 = 0;
            while (i3 < min) {
                CharSequence charSequence = this.f9070b;
                int i4 = this.f9069a;
                this.f9069a = i4 + 1;
                cArr[i] = charSequence.charAt(i4);
                i3++;
                i++;
            }
            if (min <= 0) {
                return -1;
            }
            return min;
        }
    }
}
