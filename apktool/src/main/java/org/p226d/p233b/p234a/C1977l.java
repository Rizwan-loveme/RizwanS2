package org.p226d.p233b.p234a;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import org.p226d.p233b.EnumC2272f;

/* compiled from: OdexedFieldInstructionMapper.java */
/* renamed from: org.d.b.a.l */
/* loaded from: classes.dex */
public class C1977l {

    /* renamed from: a */
    private static final a[] f11527a = {new a('Z', EnumC2272f.IGET_BOOLEAN, EnumC2272f.IGET_QUICK, EnumC2272f.IGET_VOLATILE), new a('B', EnumC2272f.IGET_BYTE, EnumC2272f.IGET_QUICK, EnumC2272f.IGET_VOLATILE), new a('S', EnumC2272f.IGET_SHORT, EnumC2272f.IGET_QUICK, EnumC2272f.IGET_VOLATILE), new a('C', EnumC2272f.IGET_CHAR, EnumC2272f.IGET_QUICK, EnumC2272f.IGET_VOLATILE), new a('I', EnumC2272f.IGET, EnumC2272f.IGET_QUICK, EnumC2272f.IGET_VOLATILE), new a('F', EnumC2272f.IGET, EnumC2272f.IGET_QUICK, EnumC2272f.IGET_VOLATILE), new a('J', EnumC2272f.IGET_WIDE, EnumC2272f.IGET_WIDE_QUICK, EnumC2272f.IGET_WIDE_VOLATILE), new a('D', EnumC2272f.IGET_WIDE, EnumC2272f.IGET_WIDE_QUICK, EnumC2272f.IGET_WIDE_VOLATILE), new a('L', EnumC2272f.IGET_OBJECT, EnumC2272f.IGET_OBJECT_QUICK, EnumC2272f.IGET_OBJECT_VOLATILE), new a('[', EnumC2272f.IGET_OBJECT, EnumC2272f.IGET_OBJECT_QUICK, EnumC2272f.IGET_OBJECT_VOLATILE), new a('Z', EnumC2272f.IPUT_BOOLEAN, EnumC2272f.IPUT_QUICK, EnumC2272f.IPUT_VOLATILE), new a('B', EnumC2272f.IPUT_BYTE, EnumC2272f.IPUT_QUICK, EnumC2272f.IPUT_VOLATILE), new a('S', EnumC2272f.IPUT_SHORT, EnumC2272f.IPUT_QUICK, EnumC2272f.IPUT_VOLATILE), new a('C', EnumC2272f.IPUT_CHAR, EnumC2272f.IPUT_QUICK, EnumC2272f.IPUT_VOLATILE), new a('I', EnumC2272f.IPUT, EnumC2272f.IPUT_QUICK, EnumC2272f.IPUT_VOLATILE), new a('F', EnumC2272f.IPUT, EnumC2272f.IPUT_QUICK, EnumC2272f.IPUT_VOLATILE), new a('J', EnumC2272f.IPUT_WIDE, EnumC2272f.IPUT_WIDE_QUICK, EnumC2272f.IPUT_WIDE_VOLATILE), new a('D', EnumC2272f.IPUT_WIDE, EnumC2272f.IPUT_WIDE_QUICK, EnumC2272f.IPUT_WIDE_VOLATILE), new a('L', EnumC2272f.IPUT_OBJECT, EnumC2272f.IPUT_OBJECT_QUICK, EnumC2272f.IPUT_OBJECT_VOLATILE), new a('[', EnumC2272f.IPUT_OBJECT, EnumC2272f.IPUT_OBJECT_QUICK, EnumC2272f.IPUT_OBJECT_VOLATILE), new a('Z', true, EnumC2272f.SPUT_BOOLEAN, EnumC2272f.SPUT_VOLATILE), new a('B', true, EnumC2272f.SPUT_BYTE, EnumC2272f.SPUT_VOLATILE), new a('S', true, EnumC2272f.SPUT_SHORT, EnumC2272f.SPUT_VOLATILE), new a('C', true, EnumC2272f.SPUT_CHAR, EnumC2272f.SPUT_VOLATILE), new a('I', true, EnumC2272f.SPUT, EnumC2272f.SPUT_VOLATILE), new a('F', true, EnumC2272f.SPUT, EnumC2272f.SPUT_VOLATILE), new a('J', true, EnumC2272f.SPUT_WIDE, EnumC2272f.SPUT_WIDE_VOLATILE), new a('D', true, EnumC2272f.SPUT_WIDE, EnumC2272f.SPUT_WIDE_VOLATILE), new a('L', true, EnumC2272f.SPUT_OBJECT, EnumC2272f.SPUT_OBJECT_VOLATILE), new a('[', true, EnumC2272f.SPUT_OBJECT, EnumC2272f.SPUT_OBJECT_VOLATILE), new a('Z', true, EnumC2272f.SGET_BOOLEAN, EnumC2272f.SGET_VOLATILE), new a('B', true, EnumC2272f.SGET_BYTE, EnumC2272f.SGET_VOLATILE), new a('S', true, EnumC2272f.SGET_SHORT, EnumC2272f.SGET_VOLATILE), new a('C', true, EnumC2272f.SGET_CHAR, EnumC2272f.SGET_VOLATILE), new a('I', true, EnumC2272f.SGET, EnumC2272f.SGET_VOLATILE), new a('F', true, EnumC2272f.SGET, EnumC2272f.SGET_VOLATILE), new a('J', true, EnumC2272f.SGET_WIDE, EnumC2272f.SGET_WIDE_VOLATILE), new a('D', true, EnumC2272f.SGET_WIDE, EnumC2272f.SGET_WIDE_VOLATILE), new a('L', true, EnumC2272f.SGET_OBJECT, EnumC2272f.SGET_OBJECT_VOLATILE), new a('[', true, EnumC2272f.SGET_OBJECT, EnumC2272f.SGET_OBJECT_VOLATILE)};

    /* renamed from: b */
    private static final a[] f11528b = {new a('Z', EnumC2272f.IGET_BOOLEAN, EnumC2272f.IGET_BOOLEAN_QUICK), new a('B', EnumC2272f.IGET_BYTE, EnumC2272f.IGET_BYTE_QUICK), new a('S', EnumC2272f.IGET_SHORT, EnumC2272f.IGET_SHORT_QUICK), new a('C', EnumC2272f.IGET_CHAR, EnumC2272f.IGET_CHAR_QUICK), new a('I', EnumC2272f.IGET, EnumC2272f.IGET_QUICK), new a('F', EnumC2272f.IGET, EnumC2272f.IGET_QUICK), new a('J', EnumC2272f.IGET_WIDE, EnumC2272f.IGET_WIDE_QUICK), new a('D', EnumC2272f.IGET_WIDE, EnumC2272f.IGET_WIDE_QUICK), new a('L', EnumC2272f.IGET_OBJECT, EnumC2272f.IGET_OBJECT_QUICK), new a('[', EnumC2272f.IGET_OBJECT, EnumC2272f.IGET_OBJECT_QUICK), new a('Z', EnumC2272f.IPUT_BOOLEAN, EnumC2272f.IPUT_BOOLEAN_QUICK), new a('B', EnumC2272f.IPUT_BYTE, EnumC2272f.IPUT_BYTE_QUICK), new a('S', EnumC2272f.IPUT_SHORT, EnumC2272f.IPUT_SHORT_QUICK), new a('C', EnumC2272f.IPUT_CHAR, EnumC2272f.IPUT_CHAR_QUICK), new a('I', EnumC2272f.IPUT, EnumC2272f.IPUT_QUICK), new a('F', EnumC2272f.IPUT, EnumC2272f.IPUT_QUICK), new a('J', EnumC2272f.IPUT_WIDE, EnumC2272f.IPUT_WIDE_QUICK), new a('D', EnumC2272f.IPUT_WIDE, EnumC2272f.IPUT_WIDE_QUICK), new a('L', EnumC2272f.IPUT_OBJECT, EnumC2272f.IPUT_OBJECT_QUICK), new a('[', EnumC2272f.IPUT_OBJECT, EnumC2272f.IPUT_OBJECT_QUICK)};

    /* renamed from: c */
    private final a[][][] f11529c = (a[][][]) Array.newInstance((Class<?>) a.class, 2, 2, 10);

    /* renamed from: d */
    private final Map<EnumC2272f, Integer> f11530d = new HashMap(30);

    /* compiled from: OdexedFieldInstructionMapper.java */
    /* renamed from: org.d.b.a.l$a */
    private static class a {

        /* renamed from: a */
        public final char f11531a;

        /* renamed from: b */
        public final boolean f11532b;

        /* renamed from: c */
        public final EnumC2272f f11533c;

        /* renamed from: d */
        public final EnumC2272f f11534d;

        /* renamed from: e */
        public final EnumC2272f f11535e;

        public a(char c2, EnumC2272f enumC2272f, EnumC2272f enumC2272f2, EnumC2272f enumC2272f3) {
            this.f11531a = c2;
            this.f11532b = false;
            this.f11533c = enumC2272f;
            this.f11534d = enumC2272f2;
            this.f11535e = enumC2272f3;
        }

        public a(char c2, boolean z, EnumC2272f enumC2272f, EnumC2272f enumC2272f2) {
            this.f11531a = c2;
            this.f11532b = z;
            this.f11533c = enumC2272f;
            this.f11534d = null;
            this.f11535e = enumC2272f2;
        }

        public a(char c2, EnumC2272f enumC2272f, EnumC2272f enumC2272f2) {
            this.f11531a = c2;
            this.f11532b = false;
            this.f11533c = enumC2272f;
            this.f11534d = enumC2272f2;
            this.f11535e = null;
        }
    }

    /* renamed from: a */
    private static int m14399a(char c2) {
        switch (c2) {
            case 'B':
            case 'C':
            case 'F':
            case 'I':
            case 'S':
            case 'Z':
                return 0;
            case 'D':
            case 'J':
                return 1;
            case 'L':
            case '[':
                return 2;
            default:
                throw new RuntimeException(String.format("Unknown type %s: ", Character.valueOf(c2)));
        }
    }

    /* renamed from: b */
    private static int m14402b(char c2) {
        switch (c2) {
            case 'B':
                return 1;
            case 'C':
                return 3;
            case 'D':
                return 7;
            case 'F':
                return 5;
            case 'I':
                return 4;
            case 'J':
                return 6;
            case 'L':
                return 8;
            case 'S':
                return 2;
            case 'Z':
                return 0;
            case '[':
                return 9;
            default:
                throw new RuntimeException(String.format("Unknown type %s: ", Character.valueOf(c2)));
        }
    }

    /* renamed from: a */
    private static boolean m14400a(EnumC2272f enumC2272f) {
        return (enumC2272f.f12387ej & 16) != 0;
    }

    /* renamed from: b */
    private static boolean m14403b(EnumC2272f enumC2272f) {
        return (enumC2272f.f12387ej & 256) != 0;
    }

    public C1977l(boolean z) {
        a[] aVarArr;
        if (z) {
            aVarArr = f11528b;
        } else {
            aVarArr = f11527a;
        }
        for (a aVar : aVarArr) {
            this.f11529c[m14400a(aVar.f11533c) ? (char) 0 : (char) 1][m14403b(aVar.f11533c) ? (char) 1 : (char) 0][m14402b(aVar.f11531a)] = aVar;
            if (aVar.f11534d != null) {
                this.f11530d.put(aVar.f11534d, Integer.valueOf(m14399a(aVar.f11531a)));
            }
            if (aVar.f11535e != null) {
                this.f11530d.put(aVar.f11535e, Integer.valueOf(m14399a(aVar.f11531a)));
            }
        }
    }

    /* renamed from: a */
    public EnumC2272f m14404a(String str, EnumC2272f enumC2272f) {
        a aVar = this.f11529c[m14400a(enumC2272f) ? (char) 0 : (char) 1][m14403b(enumC2272f) ? (char) 1 : (char) 0][m14402b(str.charAt(0))];
        if (!m14401a(enumC2272f, aVar.f11531a)) {
            throw new C1960a(String.format("Incorrect field type \"%s\" for %s", str, enumC2272f.f12384eg), new Object[0]);
        }
        return aVar.f11533c;
    }

    /* renamed from: a */
    private boolean m14401a(EnumC2272f enumC2272f, char c2) {
        Integer num = this.f11530d.get(enumC2272f);
        if (num == null) {
            throw new RuntimeException("Unexpected opcode: " + enumC2272f.f12384eg);
        }
        return num.intValue() == m14399a(c2);
    }
}
