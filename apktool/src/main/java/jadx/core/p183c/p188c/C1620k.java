package jadx.core.p183c.p188c;

import jadx.core.p183c.p187b.C1592d;
import jadx.core.p183c.p187b.C1594f;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p188c.p189a.EnumC1603h;
import jadx.core.p183c.p191d.C1637c;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p203d.C1739h;
import jadx.core.p203d.p205b.C1725b;
import java.util.LinkedList;
import java.util.List;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.InterfaceC2218f;
import org.p226d.p233b.p250e.p252b.InterfaceC2222j;
import org.p226d.p233b.p250e.p252b.InterfaceC2223k;
import org.p226d.p233b.p250e.p252b.InterfaceC2225m;
import org.p226d.p233b.p250e.p252b.InterfaceC2227o;
import org.p226d.p233b.p250e.p252b.InterfaceC2228p;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2177a;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2213z;
import org.p226d.p233b.p250e.p254c.InterfaceC2237b;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;
import org.p226d.p233b.p250e.p254c.InterfaceC2242g;
import org.p226d.p233b.p250e.p254c.InterfaceC2243h;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: InsnDecoder.java */
/* renamed from: jadx.core.c.c.k */
/* loaded from: classes.dex */
public class C1620k {

    /* renamed from: a */
    private static final InterfaceC2558b f10236a = C2568c.m15995a((Class<?>) C1620k.class);

    /* renamed from: e */
    private static /* synthetic */ int[] f10237e;

    /* renamed from: b */
    private final C1648n f10238b;

    /* renamed from: c */
    private final C1637c f10239c;

    /* renamed from: d */
    private InterfaceC2218f[] f10240d;

    /* renamed from: b */
    static /* synthetic */ int[] m12411b() {
        int[] iArr = f10237e;
        if (iArr == null) {
            iArr = new int[EnumC2272f.values().length];
            try {
                iArr[EnumC2272f.ADD_DOUBLE.ordinal()] = 163;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[EnumC2272f.ADD_DOUBLE_2ADDR.ordinal()] = 195;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[EnumC2272f.ADD_FLOAT.ordinal()] = 158;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[EnumC2272f.ADD_FLOAT_2ADDR.ordinal()] = 190;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[EnumC2272f.ADD_INT.ordinal()] = 136;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[EnumC2272f.ADD_INT_2ADDR.ordinal()] = 168;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[EnumC2272f.ADD_INT_LIT16.ordinal()] = 200;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[EnumC2272f.ADD_INT_LIT8.ordinal()] = 208;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[EnumC2272f.ADD_LONG.ordinal()] = 147;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[EnumC2272f.ADD_LONG_2ADDR.ordinal()] = 179;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[EnumC2272f.AGET.ordinal()] = 63;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[EnumC2272f.AGET_BOOLEAN.ordinal()] = 66;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr[EnumC2272f.AGET_BYTE.ordinal()] = 67;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr[EnumC2272f.AGET_CHAR.ordinal()] = 68;
            } catch (NoSuchFieldError e15) {
            }
            try {
                iArr[EnumC2272f.AGET_OBJECT.ordinal()] = 65;
            } catch (NoSuchFieldError e16) {
            }
            try {
                iArr[EnumC2272f.AGET_SHORT.ordinal()] = 69;
            } catch (NoSuchFieldError e17) {
            }
            try {
                iArr[EnumC2272f.AGET_WIDE.ordinal()] = 64;
            } catch (NoSuchFieldError e18) {
            }
            try {
                iArr[EnumC2272f.AND_INT.ordinal()] = 141;
            } catch (NoSuchFieldError e19) {
            }
            try {
                iArr[EnumC2272f.AND_INT_2ADDR.ordinal()] = 173;
            } catch (NoSuchFieldError e20) {
            }
            try {
                iArr[EnumC2272f.AND_INT_LIT16.ordinal()] = 205;
            } catch (NoSuchFieldError e21) {
            }
            try {
                iArr[EnumC2272f.AND_INT_LIT8.ordinal()] = 213;
            } catch (NoSuchFieldError e22) {
            }
            try {
                iArr[EnumC2272f.AND_LONG.ordinal()] = 152;
            } catch (NoSuchFieldError e23) {
            }
            try {
                iArr[EnumC2272f.AND_LONG_2ADDR.ordinal()] = 184;
            } catch (NoSuchFieldError e24) {
            }
            try {
                iArr[EnumC2272f.APUT.ordinal()] = 70;
            } catch (NoSuchFieldError e25) {
            }
            try {
                iArr[EnumC2272f.APUT_BOOLEAN.ordinal()] = 73;
            } catch (NoSuchFieldError e26) {
            }
            try {
                iArr[EnumC2272f.APUT_BYTE.ordinal()] = 74;
            } catch (NoSuchFieldError e27) {
            }
            try {
                iArr[EnumC2272f.APUT_CHAR.ordinal()] = 75;
            } catch (NoSuchFieldError e28) {
            }
            try {
                iArr[EnumC2272f.APUT_OBJECT.ordinal()] = 72;
            } catch (NoSuchFieldError e29) {
            }
            try {
                iArr[EnumC2272f.APUT_SHORT.ordinal()] = 76;
            } catch (NoSuchFieldError e30) {
            }
            try {
                iArr[EnumC2272f.APUT_WIDE.ordinal()] = 71;
            } catch (NoSuchFieldError e31) {
            }
            try {
                iArr[EnumC2272f.ARRAY_LENGTH.ordinal()] = 34;
            } catch (NoSuchFieldError e32) {
            }
            try {
                iArr[EnumC2272f.ARRAY_PAYLOAD.ordinal()] = 258;
            } catch (NoSuchFieldError e33) {
            }
            try {
                iArr[EnumC2272f.CHECK_CAST.ordinal()] = 32;
            } catch (NoSuchFieldError e34) {
            }
            try {
                iArr[EnumC2272f.CMPG_DOUBLE.ordinal()] = 49;
            } catch (NoSuchFieldError e35) {
            }
            try {
                iArr[EnumC2272f.CMPG_FLOAT.ordinal()] = 47;
            } catch (NoSuchFieldError e36) {
            }
            try {
                iArr[EnumC2272f.CMPL_DOUBLE.ordinal()] = 48;
            } catch (NoSuchFieldError e37) {
            }
            try {
                iArr[EnumC2272f.CMPL_FLOAT.ordinal()] = 46;
            } catch (NoSuchFieldError e38) {
            }
            try {
                iArr[EnumC2272f.CMP_LONG.ordinal()] = 50;
            } catch (NoSuchFieldError e39) {
            }
            try {
                iArr[EnumC2272f.CONST.ordinal()] = 21;
            } catch (NoSuchFieldError e40) {
            }
            try {
                iArr[EnumC2272f.CONST_16.ordinal()] = 20;
            } catch (NoSuchFieldError e41) {
            }
            try {
                iArr[EnumC2272f.CONST_4.ordinal()] = 19;
            } catch (NoSuchFieldError e42) {
            }
            try {
                iArr[EnumC2272f.CONST_CLASS.ordinal()] = 29;
            } catch (NoSuchFieldError e43) {
            }
            try {
                iArr[EnumC2272f.CONST_HIGH16.ordinal()] = 22;
            } catch (NoSuchFieldError e44) {
            }
            try {
                iArr[EnumC2272f.CONST_METHOD_HANDLE.ordinal()] = 263;
            } catch (NoSuchFieldError e45) {
            }
            try {
                iArr[EnumC2272f.CONST_METHOD_TYPE.ordinal()] = 264;
            } catch (NoSuchFieldError e46) {
            }
            try {
                iArr[EnumC2272f.CONST_STRING.ordinal()] = 27;
            } catch (NoSuchFieldError e47) {
            }
            try {
                iArr[EnumC2272f.CONST_STRING_JUMBO.ordinal()] = 28;
            } catch (NoSuchFieldError e48) {
            }
            try {
                iArr[EnumC2272f.CONST_WIDE.ordinal()] = 25;
            } catch (NoSuchFieldError e49) {
            }
            try {
                iArr[EnumC2272f.CONST_WIDE_16.ordinal()] = 23;
            } catch (NoSuchFieldError e50) {
            }
            try {
                iArr[EnumC2272f.CONST_WIDE_32.ordinal()] = 24;
            } catch (NoSuchFieldError e51) {
            }
            try {
                iArr[EnumC2272f.CONST_WIDE_HIGH16.ordinal()] = 26;
            } catch (NoSuchFieldError e52) {
            }
            try {
                iArr[EnumC2272f.DIV_DOUBLE.ordinal()] = 166;
            } catch (NoSuchFieldError e53) {
            }
            try {
                iArr[EnumC2272f.DIV_DOUBLE_2ADDR.ordinal()] = 198;
            } catch (NoSuchFieldError e54) {
            }
            try {
                iArr[EnumC2272f.DIV_FLOAT.ordinal()] = 161;
            } catch (NoSuchFieldError e55) {
            }
            try {
                iArr[EnumC2272f.DIV_FLOAT_2ADDR.ordinal()] = 193;
            } catch (NoSuchFieldError e56) {
            }
            try {
                iArr[EnumC2272f.DIV_INT.ordinal()] = 139;
            } catch (NoSuchFieldError e57) {
            }
            try {
                iArr[EnumC2272f.DIV_INT_2ADDR.ordinal()] = 171;
            } catch (NoSuchFieldError e58) {
            }
            try {
                iArr[EnumC2272f.DIV_INT_LIT16.ordinal()] = 203;
            } catch (NoSuchFieldError e59) {
            }
            try {
                iArr[EnumC2272f.DIV_INT_LIT8.ordinal()] = 211;
            } catch (NoSuchFieldError e60) {
            }
            try {
                iArr[EnumC2272f.DIV_LONG.ordinal()] = 150;
            } catch (NoSuchFieldError e61) {
            }
            try {
                iArr[EnumC2272f.DIV_LONG_2ADDR.ordinal()] = 182;
            } catch (NoSuchFieldError e62) {
            }
            try {
                iArr[EnumC2272f.DOUBLE_TO_FLOAT.ordinal()] = 132;
            } catch (NoSuchFieldError e63) {
            }
            try {
                iArr[EnumC2272f.DOUBLE_TO_INT.ordinal()] = 130;
            } catch (NoSuchFieldError e64) {
            }
            try {
                iArr[EnumC2272f.DOUBLE_TO_LONG.ordinal()] = 131;
            } catch (NoSuchFieldError e65) {
            }
            try {
                iArr[EnumC2272f.EXECUTE_INLINE.ordinal()] = 229;
            } catch (NoSuchFieldError e66) {
            }
            try {
                iArr[EnumC2272f.EXECUTE_INLINE_RANGE.ordinal()] = 230;
            } catch (NoSuchFieldError e67) {
            }
            try {
                iArr[EnumC2272f.FILLED_NEW_ARRAY.ordinal()] = 37;
            } catch (NoSuchFieldError e68) {
            }
            try {
                iArr[EnumC2272f.FILLED_NEW_ARRAY_RANGE.ordinal()] = 38;
            } catch (NoSuchFieldError e69) {
            }
            try {
                iArr[EnumC2272f.FILL_ARRAY_DATA.ordinal()] = 39;
            } catch (NoSuchFieldError e70) {
            }
            try {
                iArr[EnumC2272f.FLOAT_TO_DOUBLE.ordinal()] = 129;
            } catch (NoSuchFieldError e71) {
            }
            try {
                iArr[EnumC2272f.FLOAT_TO_INT.ordinal()] = 127;
            } catch (NoSuchFieldError e72) {
            }
            try {
                iArr[EnumC2272f.FLOAT_TO_LONG.ordinal()] = 128;
            } catch (NoSuchFieldError e73) {
            }
            try {
                iArr[EnumC2272f.GOTO.ordinal()] = 41;
            } catch (NoSuchFieldError e74) {
            }
            try {
                iArr[EnumC2272f.GOTO_16.ordinal()] = 42;
            } catch (NoSuchFieldError e75) {
            }
            try {
                iArr[EnumC2272f.GOTO_32.ordinal()] = 43;
            } catch (NoSuchFieldError e76) {
            }
            try {
                iArr[EnumC2272f.IF_EQ.ordinal()] = 51;
            } catch (NoSuchFieldError e77) {
            }
            try {
                iArr[EnumC2272f.IF_EQZ.ordinal()] = 57;
            } catch (NoSuchFieldError e78) {
            }
            try {
                iArr[EnumC2272f.IF_GE.ordinal()] = 54;
            } catch (NoSuchFieldError e79) {
            }
            try {
                iArr[EnumC2272f.IF_GEZ.ordinal()] = 60;
            } catch (NoSuchFieldError e80) {
            }
            try {
                iArr[EnumC2272f.IF_GT.ordinal()] = 55;
            } catch (NoSuchFieldError e81) {
            }
            try {
                iArr[EnumC2272f.IF_GTZ.ordinal()] = 61;
            } catch (NoSuchFieldError e82) {
            }
            try {
                iArr[EnumC2272f.IF_LE.ordinal()] = 56;
            } catch (NoSuchFieldError e83) {
            }
            try {
                iArr[EnumC2272f.IF_LEZ.ordinal()] = 62;
            } catch (NoSuchFieldError e84) {
            }
            try {
                iArr[EnumC2272f.IF_LT.ordinal()] = 53;
            } catch (NoSuchFieldError e85) {
            }
            try {
                iArr[EnumC2272f.IF_LTZ.ordinal()] = 59;
            } catch (NoSuchFieldError e86) {
            }
            try {
                iArr[EnumC2272f.IF_NE.ordinal()] = 52;
            } catch (NoSuchFieldError e87) {
            }
            try {
                iArr[EnumC2272f.IF_NEZ.ordinal()] = 58;
            } catch (NoSuchFieldError e88) {
            }
            try {
                iArr[EnumC2272f.IGET.ordinal()] = 77;
            } catch (NoSuchFieldError e89) {
            }
            try {
                iArr[EnumC2272f.IGET_BOOLEAN.ordinal()] = 80;
            } catch (NoSuchFieldError e90) {
            }
            try {
                iArr[EnumC2272f.IGET_BOOLEAN_QUICK.ordinal()] = 245;
            } catch (NoSuchFieldError e91) {
            }
            try {
                iArr[EnumC2272f.IGET_BYTE.ordinal()] = 81;
            } catch (NoSuchFieldError e92) {
            }
            try {
                iArr[EnumC2272f.IGET_BYTE_QUICK.ordinal()] = 246;
            } catch (NoSuchFieldError e93) {
            }
            try {
                iArr[EnumC2272f.IGET_CHAR.ordinal()] = 82;
            } catch (NoSuchFieldError e94) {
            }
            try {
                iArr[EnumC2272f.IGET_CHAR_QUICK.ordinal()] = 247;
            } catch (NoSuchFieldError e95) {
            }
            try {
                iArr[EnumC2272f.IGET_OBJECT.ordinal()] = 79;
            } catch (NoSuchFieldError e96) {
            }
            try {
                iArr[EnumC2272f.IGET_OBJECT_QUICK.ordinal()] = 237;
            } catch (NoSuchFieldError e97) {
            }
            try {
                iArr[EnumC2272f.IGET_OBJECT_VOLATILE.ordinal()] = 223;
            } catch (NoSuchFieldError e98) {
            }
            try {
                iArr[EnumC2272f.IGET_QUICK.ordinal()] = 235;
            } catch (NoSuchFieldError e99) {
            }
            try {
                iArr[EnumC2272f.IGET_SHORT.ordinal()] = 83;
            } catch (NoSuchFieldError e100) {
            }
            try {
                iArr[EnumC2272f.IGET_SHORT_QUICK.ordinal()] = 248;
            } catch (NoSuchFieldError e101) {
            }
            try {
                iArr[EnumC2272f.IGET_VOLATILE.ordinal()] = 219;
            } catch (NoSuchFieldError e102) {
            }
            try {
                iArr[EnumC2272f.IGET_WIDE.ordinal()] = 78;
            } catch (NoSuchFieldError e103) {
            }
            try {
                iArr[EnumC2272f.IGET_WIDE_QUICK.ordinal()] = 236;
            } catch (NoSuchFieldError e104) {
            }
            try {
                iArr[EnumC2272f.IGET_WIDE_VOLATILE.ordinal()] = 224;
            } catch (NoSuchFieldError e105) {
            }
            try {
                iArr[EnumC2272f.INSTANCE_OF.ordinal()] = 33;
            } catch (NoSuchFieldError e106) {
            }
            try {
                iArr[EnumC2272f.INT_TO_BYTE.ordinal()] = 133;
            } catch (NoSuchFieldError e107) {
            }
            try {
                iArr[EnumC2272f.INT_TO_CHAR.ordinal()] = 134;
            } catch (NoSuchFieldError e108) {
            }
            try {
                iArr[EnumC2272f.INT_TO_DOUBLE.ordinal()] = 123;
            } catch (NoSuchFieldError e109) {
            }
            try {
                iArr[EnumC2272f.INT_TO_FLOAT.ordinal()] = 122;
            } catch (NoSuchFieldError e110) {
            }
            try {
                iArr[EnumC2272f.INT_TO_LONG.ordinal()] = 121;
            } catch (NoSuchFieldError e111) {
            }
            try {
                iArr[EnumC2272f.INT_TO_SHORT.ordinal()] = 135;
            } catch (NoSuchFieldError e112) {
            }
            try {
                iArr[EnumC2272f.INVOKE_CUSTOM.ordinal()] = 261;
            } catch (NoSuchFieldError e113) {
            }
            try {
                iArr[EnumC2272f.INVOKE_CUSTOM_RANGE.ordinal()] = 262;
            } catch (NoSuchFieldError e114) {
            }
            try {
                iArr[EnumC2272f.INVOKE_DIRECT.ordinal()] = 107;
            } catch (NoSuchFieldError e115) {
            }
            try {
                iArr[EnumC2272f.INVOKE_DIRECT_EMPTY.ordinal()] = 231;
            } catch (NoSuchFieldError e116) {
            }
            try {
                iArr[EnumC2272f.INVOKE_DIRECT_RANGE.ordinal()] = 112;
            } catch (NoSuchFieldError e117) {
            }
            try {
                iArr[EnumC2272f.INVOKE_INTERFACE.ordinal()] = 109;
            } catch (NoSuchFieldError e118) {
            }
            try {
                iArr[EnumC2272f.INVOKE_INTERFACE_RANGE.ordinal()] = 114;
            } catch (NoSuchFieldError e119) {
            }
            try {
                iArr[EnumC2272f.INVOKE_OBJECT_INIT_RANGE.ordinal()] = 232;
            } catch (NoSuchFieldError e120) {
            }
            try {
                iArr[EnumC2272f.INVOKE_POLYMORPHIC.ordinal()] = 259;
            } catch (NoSuchFieldError e121) {
            }
            try {
                iArr[EnumC2272f.INVOKE_POLYMORPHIC_RANGE.ordinal()] = 260;
            } catch (NoSuchFieldError e122) {
            }
            try {
                iArr[EnumC2272f.INVOKE_STATIC.ordinal()] = 108;
            } catch (NoSuchFieldError e123) {
            }
            try {
                iArr[EnumC2272f.INVOKE_STATIC_RANGE.ordinal()] = 113;
            } catch (NoSuchFieldError e124) {
            }
            try {
                iArr[EnumC2272f.INVOKE_SUPER.ordinal()] = 106;
            } catch (NoSuchFieldError e125) {
            }
            try {
                iArr[EnumC2272f.INVOKE_SUPER_QUICK.ordinal()] = 251;
            } catch (NoSuchFieldError e126) {
            }
            try {
                iArr[EnumC2272f.INVOKE_SUPER_QUICK_RANGE.ordinal()] = 252;
            } catch (NoSuchFieldError e127) {
            }
            try {
                iArr[EnumC2272f.INVOKE_SUPER_RANGE.ordinal()] = 111;
            } catch (NoSuchFieldError e128) {
            }
            try {
                iArr[EnumC2272f.INVOKE_VIRTUAL.ordinal()] = 105;
            } catch (NoSuchFieldError e129) {
            }
            try {
                iArr[EnumC2272f.INVOKE_VIRTUAL_QUICK.ordinal()] = 249;
            } catch (NoSuchFieldError e130) {
            }
            try {
                iArr[EnumC2272f.INVOKE_VIRTUAL_QUICK_RANGE.ordinal()] = 250;
            } catch (NoSuchFieldError e131) {
            }
            try {
                iArr[EnumC2272f.INVOKE_VIRTUAL_RANGE.ordinal()] = 110;
            } catch (NoSuchFieldError e132) {
            }
            try {
                iArr[EnumC2272f.IPUT.ordinal()] = 84;
            } catch (NoSuchFieldError e133) {
            }
            try {
                iArr[EnumC2272f.IPUT_BOOLEAN.ordinal()] = 87;
            } catch (NoSuchFieldError e134) {
            }
            try {
                iArr[EnumC2272f.IPUT_BOOLEAN_QUICK.ordinal()] = 241;
            } catch (NoSuchFieldError e135) {
            }
            try {
                iArr[EnumC2272f.IPUT_BYTE.ordinal()] = 88;
            } catch (NoSuchFieldError e136) {
            }
            try {
                iArr[EnumC2272f.IPUT_BYTE_QUICK.ordinal()] = 242;
            } catch (NoSuchFieldError e137) {
            }
            try {
                iArr[EnumC2272f.IPUT_CHAR.ordinal()] = 89;
            } catch (NoSuchFieldError e138) {
            }
            try {
                iArr[EnumC2272f.IPUT_CHAR_QUICK.ordinal()] = 243;
            } catch (NoSuchFieldError e139) {
            }
            try {
                iArr[EnumC2272f.IPUT_OBJECT.ordinal()] = 86;
            } catch (NoSuchFieldError e140) {
            }
            try {
                iArr[EnumC2272f.IPUT_OBJECT_QUICK.ordinal()] = 240;
            } catch (NoSuchFieldError e141) {
            }
            try {
                iArr[EnumC2272f.IPUT_OBJECT_VOLATILE.ordinal()] = 253;
            } catch (NoSuchFieldError e142) {
            }
            try {
                iArr[EnumC2272f.IPUT_QUICK.ordinal()] = 238;
            } catch (NoSuchFieldError e143) {
            }
            try {
                iArr[EnumC2272f.IPUT_SHORT.ordinal()] = 90;
            } catch (NoSuchFieldError e144) {
            }
            try {
                iArr[EnumC2272f.IPUT_SHORT_QUICK.ordinal()] = 244;
            } catch (NoSuchFieldError e145) {
            }
            try {
                iArr[EnumC2272f.IPUT_VOLATILE.ordinal()] = 220;
            } catch (NoSuchFieldError e146) {
            }
            try {
                iArr[EnumC2272f.IPUT_WIDE.ordinal()] = 85;
            } catch (NoSuchFieldError e147) {
            }
            try {
                iArr[EnumC2272f.IPUT_WIDE_QUICK.ordinal()] = 239;
            } catch (NoSuchFieldError e148) {
            }
            try {
                iArr[EnumC2272f.IPUT_WIDE_VOLATILE.ordinal()] = 225;
            } catch (NoSuchFieldError e149) {
            }
            try {
                iArr[EnumC2272f.LONG_TO_DOUBLE.ordinal()] = 126;
            } catch (NoSuchFieldError e150) {
            }
            try {
                iArr[EnumC2272f.LONG_TO_FLOAT.ordinal()] = 125;
            } catch (NoSuchFieldError e151) {
            }
            try {
                iArr[EnumC2272f.LONG_TO_INT.ordinal()] = 124;
            } catch (NoSuchFieldError e152) {
            }
            try {
                iArr[EnumC2272f.MONITOR_ENTER.ordinal()] = 30;
            } catch (NoSuchFieldError e153) {
            }
            try {
                iArr[EnumC2272f.MONITOR_EXIT.ordinal()] = 31;
            } catch (NoSuchFieldError e154) {
            }
            try {
                iArr[EnumC2272f.MOVE.ordinal()] = 2;
            } catch (NoSuchFieldError e155) {
            }
            try {
                iArr[EnumC2272f.MOVE_16.ordinal()] = 4;
            } catch (NoSuchFieldError e156) {
            }
            try {
                iArr[EnumC2272f.MOVE_EXCEPTION.ordinal()] = 14;
            } catch (NoSuchFieldError e157) {
            }
            try {
                iArr[EnumC2272f.MOVE_FROM16.ordinal()] = 3;
            } catch (NoSuchFieldError e158) {
            }
            try {
                iArr[EnumC2272f.MOVE_OBJECT.ordinal()] = 8;
            } catch (NoSuchFieldError e159) {
            }
            try {
                iArr[EnumC2272f.MOVE_OBJECT_16.ordinal()] = 10;
            } catch (NoSuchFieldError e160) {
            }
            try {
                iArr[EnumC2272f.MOVE_OBJECT_FROM16.ordinal()] = 9;
            } catch (NoSuchFieldError e161) {
            }
            try {
                iArr[EnumC2272f.MOVE_RESULT.ordinal()] = 11;
            } catch (NoSuchFieldError e162) {
            }
            try {
                iArr[EnumC2272f.MOVE_RESULT_OBJECT.ordinal()] = 13;
            } catch (NoSuchFieldError e163) {
            }
            try {
                iArr[EnumC2272f.MOVE_RESULT_WIDE.ordinal()] = 12;
            } catch (NoSuchFieldError e164) {
            }
            try {
                iArr[EnumC2272f.MOVE_WIDE.ordinal()] = 5;
            } catch (NoSuchFieldError e165) {
            }
            try {
                iArr[EnumC2272f.MOVE_WIDE_16.ordinal()] = 7;
            } catch (NoSuchFieldError e166) {
            }
            try {
                iArr[EnumC2272f.MOVE_WIDE_FROM16.ordinal()] = 6;
            } catch (NoSuchFieldError e167) {
            }
            try {
                iArr[EnumC2272f.MUL_DOUBLE.ordinal()] = 165;
            } catch (NoSuchFieldError e168) {
            }
            try {
                iArr[EnumC2272f.MUL_DOUBLE_2ADDR.ordinal()] = 197;
            } catch (NoSuchFieldError e169) {
            }
            try {
                iArr[EnumC2272f.MUL_FLOAT.ordinal()] = 160;
            } catch (NoSuchFieldError e170) {
            }
            try {
                iArr[EnumC2272f.MUL_FLOAT_2ADDR.ordinal()] = 192;
            } catch (NoSuchFieldError e171) {
            }
            try {
                iArr[EnumC2272f.MUL_INT.ordinal()] = 138;
            } catch (NoSuchFieldError e172) {
            }
            try {
                iArr[EnumC2272f.MUL_INT_2ADDR.ordinal()] = 170;
            } catch (NoSuchFieldError e173) {
            }
            try {
                iArr[EnumC2272f.MUL_INT_LIT16.ordinal()] = 202;
            } catch (NoSuchFieldError e174) {
            }
            try {
                iArr[EnumC2272f.MUL_INT_LIT8.ordinal()] = 210;
            } catch (NoSuchFieldError e175) {
            }
            try {
                iArr[EnumC2272f.MUL_LONG.ordinal()] = 149;
            } catch (NoSuchFieldError e176) {
            }
            try {
                iArr[EnumC2272f.MUL_LONG_2ADDR.ordinal()] = 181;
            } catch (NoSuchFieldError e177) {
            }
            try {
                iArr[EnumC2272f.NEG_DOUBLE.ordinal()] = 120;
            } catch (NoSuchFieldError e178) {
            }
            try {
                iArr[EnumC2272f.NEG_FLOAT.ordinal()] = 119;
            } catch (NoSuchFieldError e179) {
            }
            try {
                iArr[EnumC2272f.NEG_INT.ordinal()] = 115;
            } catch (NoSuchFieldError e180) {
            }
            try {
                iArr[EnumC2272f.NEG_LONG.ordinal()] = 117;
            } catch (NoSuchFieldError e181) {
            }
            try {
                iArr[EnumC2272f.NEW_ARRAY.ordinal()] = 36;
            } catch (NoSuchFieldError e182) {
            }
            try {
                iArr[EnumC2272f.NEW_INSTANCE.ordinal()] = 35;
            } catch (NoSuchFieldError e183) {
            }
            try {
                iArr[EnumC2272f.NOP.ordinal()] = 1;
            } catch (NoSuchFieldError e184) {
            }
            try {
                iArr[EnumC2272f.NOT_INT.ordinal()] = 116;
            } catch (NoSuchFieldError e185) {
            }
            try {
                iArr[EnumC2272f.NOT_LONG.ordinal()] = 118;
            } catch (NoSuchFieldError e186) {
            }
            try {
                iArr[EnumC2272f.OR_INT.ordinal()] = 142;
            } catch (NoSuchFieldError e187) {
            }
            try {
                iArr[EnumC2272f.OR_INT_2ADDR.ordinal()] = 174;
            } catch (NoSuchFieldError e188) {
            }
            try {
                iArr[EnumC2272f.OR_INT_LIT16.ordinal()] = 206;
            } catch (NoSuchFieldError e189) {
            }
            try {
                iArr[EnumC2272f.OR_INT_LIT8.ordinal()] = 214;
            } catch (NoSuchFieldError e190) {
            }
            try {
                iArr[EnumC2272f.OR_LONG.ordinal()] = 153;
            } catch (NoSuchFieldError e191) {
            }
            try {
                iArr[EnumC2272f.OR_LONG_2ADDR.ordinal()] = 185;
            } catch (NoSuchFieldError e192) {
            }
            try {
                iArr[EnumC2272f.PACKED_SWITCH.ordinal()] = 44;
            } catch (NoSuchFieldError e193) {
            }
            try {
                iArr[EnumC2272f.PACKED_SWITCH_PAYLOAD.ordinal()] = 256;
            } catch (NoSuchFieldError e194) {
            }
            try {
                iArr[EnumC2272f.REM_DOUBLE.ordinal()] = 167;
            } catch (NoSuchFieldError e195) {
            }
            try {
                iArr[EnumC2272f.REM_DOUBLE_2ADDR.ordinal()] = 199;
            } catch (NoSuchFieldError e196) {
            }
            try {
                iArr[EnumC2272f.REM_FLOAT.ordinal()] = 162;
            } catch (NoSuchFieldError e197) {
            }
            try {
                iArr[EnumC2272f.REM_FLOAT_2ADDR.ordinal()] = 194;
            } catch (NoSuchFieldError e198) {
            }
            try {
                iArr[EnumC2272f.REM_INT.ordinal()] = 140;
            } catch (NoSuchFieldError e199) {
            }
            try {
                iArr[EnumC2272f.REM_INT_2ADDR.ordinal()] = 172;
            } catch (NoSuchFieldError e200) {
            }
            try {
                iArr[EnumC2272f.REM_INT_LIT16.ordinal()] = 204;
            } catch (NoSuchFieldError e201) {
            }
            try {
                iArr[EnumC2272f.REM_INT_LIT8.ordinal()] = 212;
            } catch (NoSuchFieldError e202) {
            }
            try {
                iArr[EnumC2272f.REM_LONG.ordinal()] = 151;
            } catch (NoSuchFieldError e203) {
            }
            try {
                iArr[EnumC2272f.REM_LONG_2ADDR.ordinal()] = 183;
            } catch (NoSuchFieldError e204) {
            }
            try {
                iArr[EnumC2272f.RETURN.ordinal()] = 16;
            } catch (NoSuchFieldError e205) {
            }
            try {
                iArr[EnumC2272f.RETURN_OBJECT.ordinal()] = 18;
            } catch (NoSuchFieldError e206) {
            }
            try {
                iArr[EnumC2272f.RETURN_VOID.ordinal()] = 15;
            } catch (NoSuchFieldError e207) {
            }
            try {
                iArr[EnumC2272f.RETURN_VOID_BARRIER.ordinal()] = 233;
            } catch (NoSuchFieldError e208) {
            }
            try {
                iArr[EnumC2272f.RETURN_VOID_NO_BARRIER.ordinal()] = 234;
            } catch (NoSuchFieldError e209) {
            }
            try {
                iArr[EnumC2272f.RETURN_WIDE.ordinal()] = 17;
            } catch (NoSuchFieldError e210) {
            }
            try {
                iArr[EnumC2272f.RSUB_INT.ordinal()] = 201;
            } catch (NoSuchFieldError e211) {
            }
            try {
                iArr[EnumC2272f.RSUB_INT_LIT8.ordinal()] = 209;
            } catch (NoSuchFieldError e212) {
            }
            try {
                iArr[EnumC2272f.SGET.ordinal()] = 91;
            } catch (NoSuchFieldError e213) {
            }
            try {
                iArr[EnumC2272f.SGET_BOOLEAN.ordinal()] = 94;
            } catch (NoSuchFieldError e214) {
            }
            try {
                iArr[EnumC2272f.SGET_BYTE.ordinal()] = 95;
            } catch (NoSuchFieldError e215) {
            }
            try {
                iArr[EnumC2272f.SGET_CHAR.ordinal()] = 96;
            } catch (NoSuchFieldError e216) {
            }
            try {
                iArr[EnumC2272f.SGET_OBJECT.ordinal()] = 93;
            } catch (NoSuchFieldError e217) {
            }
            try {
                iArr[EnumC2272f.SGET_OBJECT_VOLATILE.ordinal()] = 254;
            } catch (NoSuchFieldError e218) {
            }
            try {
                iArr[EnumC2272f.SGET_SHORT.ordinal()] = 97;
            } catch (NoSuchFieldError e219) {
            }
            try {
                iArr[EnumC2272f.SGET_VOLATILE.ordinal()] = 221;
            } catch (NoSuchFieldError e220) {
            }
            try {
                iArr[EnumC2272f.SGET_WIDE.ordinal()] = 92;
            } catch (NoSuchFieldError e221) {
            }
            try {
                iArr[EnumC2272f.SGET_WIDE_VOLATILE.ordinal()] = 226;
            } catch (NoSuchFieldError e222) {
            }
            try {
                iArr[EnumC2272f.SHL_INT.ordinal()] = 144;
            } catch (NoSuchFieldError e223) {
            }
            try {
                iArr[EnumC2272f.SHL_INT_2ADDR.ordinal()] = 176;
            } catch (NoSuchFieldError e224) {
            }
            try {
                iArr[EnumC2272f.SHL_INT_LIT8.ordinal()] = 216;
            } catch (NoSuchFieldError e225) {
            }
            try {
                iArr[EnumC2272f.SHL_LONG.ordinal()] = 155;
            } catch (NoSuchFieldError e226) {
            }
            try {
                iArr[EnumC2272f.SHL_LONG_2ADDR.ordinal()] = 187;
            } catch (NoSuchFieldError e227) {
            }
            try {
                iArr[EnumC2272f.SHR_INT.ordinal()] = 145;
            } catch (NoSuchFieldError e228) {
            }
            try {
                iArr[EnumC2272f.SHR_INT_2ADDR.ordinal()] = 177;
            } catch (NoSuchFieldError e229) {
            }
            try {
                iArr[EnumC2272f.SHR_INT_LIT8.ordinal()] = 217;
            } catch (NoSuchFieldError e230) {
            }
            try {
                iArr[EnumC2272f.SHR_LONG.ordinal()] = 156;
            } catch (NoSuchFieldError e231) {
            }
            try {
                iArr[EnumC2272f.SHR_LONG_2ADDR.ordinal()] = 188;
            } catch (NoSuchFieldError e232) {
            }
            try {
                iArr[EnumC2272f.SPARSE_SWITCH.ordinal()] = 45;
            } catch (NoSuchFieldError e233) {
            }
            try {
                iArr[EnumC2272f.SPARSE_SWITCH_PAYLOAD.ordinal()] = 257;
            } catch (NoSuchFieldError e234) {
            }
            try {
                iArr[EnumC2272f.SPUT.ordinal()] = 98;
            } catch (NoSuchFieldError e235) {
            }
            try {
                iArr[EnumC2272f.SPUT_BOOLEAN.ordinal()] = 101;
            } catch (NoSuchFieldError e236) {
            }
            try {
                iArr[EnumC2272f.SPUT_BYTE.ordinal()] = 102;
            } catch (NoSuchFieldError e237) {
            }
            try {
                iArr[EnumC2272f.SPUT_CHAR.ordinal()] = 103;
            } catch (NoSuchFieldError e238) {
            }
            try {
                iArr[EnumC2272f.SPUT_OBJECT.ordinal()] = 100;
            } catch (NoSuchFieldError e239) {
            }
            try {
                iArr[EnumC2272f.SPUT_OBJECT_VOLATILE.ordinal()] = 255;
            } catch (NoSuchFieldError e240) {
            }
            try {
                iArr[EnumC2272f.SPUT_SHORT.ordinal()] = 104;
            } catch (NoSuchFieldError e241) {
            }
            try {
                iArr[EnumC2272f.SPUT_VOLATILE.ordinal()] = 222;
            } catch (NoSuchFieldError e242) {
            }
            try {
                iArr[EnumC2272f.SPUT_WIDE.ordinal()] = 99;
            } catch (NoSuchFieldError e243) {
            }
            try {
                iArr[EnumC2272f.SPUT_WIDE_VOLATILE.ordinal()] = 227;
            } catch (NoSuchFieldError e244) {
            }
            try {
                iArr[EnumC2272f.SUB_DOUBLE.ordinal()] = 164;
            } catch (NoSuchFieldError e245) {
            }
            try {
                iArr[EnumC2272f.SUB_DOUBLE_2ADDR.ordinal()] = 196;
            } catch (NoSuchFieldError e246) {
            }
            try {
                iArr[EnumC2272f.SUB_FLOAT.ordinal()] = 159;
            } catch (NoSuchFieldError e247) {
            }
            try {
                iArr[EnumC2272f.SUB_FLOAT_2ADDR.ordinal()] = 191;
            } catch (NoSuchFieldError e248) {
            }
            try {
                iArr[EnumC2272f.SUB_INT.ordinal()] = 137;
            } catch (NoSuchFieldError e249) {
            }
            try {
                iArr[EnumC2272f.SUB_INT_2ADDR.ordinal()] = 169;
            } catch (NoSuchFieldError e250) {
            }
            try {
                iArr[EnumC2272f.SUB_LONG.ordinal()] = 148;
            } catch (NoSuchFieldError e251) {
            }
            try {
                iArr[EnumC2272f.SUB_LONG_2ADDR.ordinal()] = 180;
            } catch (NoSuchFieldError e252) {
            }
            try {
                iArr[EnumC2272f.THROW.ordinal()] = 40;
            } catch (NoSuchFieldError e253) {
            }
            try {
                iArr[EnumC2272f.THROW_VERIFICATION_ERROR.ordinal()] = 228;
            } catch (NoSuchFieldError e254) {
            }
            try {
                iArr[EnumC2272f.USHR_INT.ordinal()] = 146;
            } catch (NoSuchFieldError e255) {
            }
            try {
                iArr[EnumC2272f.USHR_INT_2ADDR.ordinal()] = 178;
            } catch (NoSuchFieldError e256) {
            }
            try {
                iArr[EnumC2272f.USHR_INT_LIT8.ordinal()] = 218;
            } catch (NoSuchFieldError e257) {
            }
            try {
                iArr[EnumC2272f.USHR_LONG.ordinal()] = 157;
            } catch (NoSuchFieldError e258) {
            }
            try {
                iArr[EnumC2272f.USHR_LONG_2ADDR.ordinal()] = 189;
            } catch (NoSuchFieldError e259) {
            }
            try {
                iArr[EnumC2272f.XOR_INT.ordinal()] = 143;
            } catch (NoSuchFieldError e260) {
            }
            try {
                iArr[EnumC2272f.XOR_INT_2ADDR.ordinal()] = 175;
            } catch (NoSuchFieldError e261) {
            }
            try {
                iArr[EnumC2272f.XOR_INT_LIT16.ordinal()] = 207;
            } catch (NoSuchFieldError e262) {
            }
            try {
                iArr[EnumC2272f.XOR_INT_LIT8.ordinal()] = 215;
            } catch (NoSuchFieldError e263) {
            }
            try {
                iArr[EnumC2272f.XOR_LONG.ordinal()] = 154;
            } catch (NoSuchFieldError e264) {
            }
            try {
                iArr[EnumC2272f.XOR_LONG_2ADDR.ordinal()] = 186;
            } catch (NoSuchFieldError e265) {
            }
            f10237e = iArr;
        }
        return iArr;
    }

    public C1620k(C1648n c1648n) {
        this.f10238b = c1648n;
        this.f10239c = this.f10238b.mo12540t();
    }

    /* renamed from: a */
    public void m12414a(Iterable<? extends InterfaceC2218f> iterable) {
        LinkedList linkedList = new LinkedList();
        for (InterfaceC2218f interfaceC2218f : iterable) {
            linkedList.add(interfaceC2218f);
            for (int i = 1; i < interfaceC2218f.mo14417b(); i++) {
                linkedList.add(null);
            }
        }
        this.f10240d = new InterfaceC2218f[linkedList.size()];
        linkedList.toArray(this.f10240d);
    }

    /* renamed from: a */
    public C1646l[] m12415a() {
        C1646l[] c1646lArr = new C1646l[this.f10240d.length];
        for (int i = 0; i < this.f10240d.length; i++) {
            InterfaceC2218f interfaceC2218f = this.f10240d[i];
            if (interfaceC2218f != null) {
                C1646l m12400a = m12400a(interfaceC2218f, i);
                m12400a.m12586e(i);
                c1646lArr[i] = m12400a;
            } else {
                c1646lArr[i] = null;
            }
        }
        this.f10240d = null;
        return c1646lArr;
    }

    /* renamed from: a */
    private C1646l m12400a(InterfaceC2218f interfaceC2218f, int i) {
        switch (m12411b()[interfaceC2218f.mo14416a().ordinal()]) {
            case 1:
            case 256:
            case 257:
            case 258:
                return new C1646l(EnumC1621l.NOP, 0);
            case 2:
            case 3:
            case 4:
                return m12399a(EnumC1621l.MOVE, AbstractC1598c.m12304a(interfaceC2218f, 0, AbstractC1596a.f10141q), AbstractC1598c.m12304a(interfaceC2218f, 1, AbstractC1596a.f10141q));
            case 5:
            case 6:
            case 7:
                return m12399a(EnumC1621l.MOVE, AbstractC1598c.m12304a(interfaceC2218f, 0, AbstractC1596a.f10143s), AbstractC1598c.m12304a(interfaceC2218f, 1, AbstractC1596a.f10143s));
            case 8:
            case 9:
            case 10:
                return m12399a(EnumC1621l.MOVE, AbstractC1598c.m12304a(interfaceC2218f, 0, AbstractC1596a.f10140p), AbstractC1598c.m12304a(interfaceC2218f, 1, AbstractC1596a.f10140p));
            case 11:
            case 12:
            case 13:
                return new C1646l(EnumC1621l.NOP, 0);
            case 14:
                return m12398a(EnumC1621l.MOVE_EXCEPTION, AbstractC1598c.m12304a(interfaceC2218f, 0, AbstractC1596a.m12265a(EnumC1603h.OBJECT)));
            case 15:
                return new C1646l(EnumC1621l.RETURN, 0);
            case 16:
            case 17:
            case 18:
                return m12399a(EnumC1621l.RETURN, (C1604i) null, AbstractC1598c.m12304a(interfaceC2218f, 0, this.f10238b.m12636k()));
            case 19:
            case 20:
            case 21:
            case 22:
                return m12399a(EnumC1621l.CONST, AbstractC1598c.m12304a(interfaceC2218f, 0, AbstractC1596a.f10141q), AbstractC1598c.m12301a(interfaceC2218f, AbstractC1596a.f10141q));
            case 23:
            case 24:
            case 25:
            case 26:
                return m12399a(EnumC1621l.CONST, AbstractC1598c.m12304a(interfaceC2218f, 0, AbstractC1596a.f10143s), AbstractC1598c.m12301a(interfaceC2218f, AbstractC1596a.f10143s));
            case 27:
            case 28:
                C1613d c1613d = new C1613d(((InterfaceC2242g) ((InterfaceC2225m) interfaceC2218f).mo14489f()).mo14691a());
                c1613d.m12581b(AbstractC1598c.m12304a(interfaceC2218f, 0, AbstractC1596a.f10136l));
                return c1613d;
            case 29:
                C1612c c1612c = new C1612c(this.f10239c.m12548a((InterfaceC2243h) ((InterfaceC2225m) interfaceC2218f).mo14489f()));
                c1612c.m12581b(AbstractC1598c.m12304a(interfaceC2218f, 0, AbstractC1596a.f10135k));
                return c1612c;
            case 30:
                return m12399a(EnumC1621l.MONITOR_ENTER, (C1604i) null, AbstractC1598c.m12304a(interfaceC2218f, 0, AbstractC1596a.f10140p));
            case 31:
                return m12399a(EnumC1621l.MONITOR_EXIT, (C1604i) null, AbstractC1598c.m12304a(interfaceC2218f, 0, AbstractC1596a.f10140p));
            case 32:
                AbstractC1596a m12548a = this.f10239c.m12548a((InterfaceC2243h) ((InterfaceC2225m) interfaceC2218f).mo14489f());
                C1619j c1619j = new C1619j(EnumC1621l.CHECK_CAST, m12548a, 1);
                c1619j.m12581b(AbstractC1598c.m12304a(interfaceC2218f, 0, m12548a));
                c1619j.m12584c((AbstractC1598c) AbstractC1598c.m12304a(interfaceC2218f, 0, AbstractC1596a.f10140p));
                return c1619j;
            case 33:
                C1619j c1619j2 = new C1619j(EnumC1621l.INSTANCE_OF, this.f10239c.m12548a((InterfaceC2243h) ((InterfaceC2225m) interfaceC2218f).mo14489f()), 1);
                c1619j2.m12581b(AbstractC1598c.m12304a(interfaceC2218f, 0, AbstractC1596a.f10126b));
                c1619j2.m12584c((AbstractC1598c) AbstractC1598c.m12304a(interfaceC2218f, 1, AbstractC1596a.f10140p));
                return c1619j2;
            case 34:
                C1646l c1646l = new C1646l(EnumC1621l.ARRAY_LENGTH, 1);
                c1646l.m12581b(AbstractC1598c.m12304a(interfaceC2218f, 0, AbstractC1596a.f10125a));
                c1646l.m12584c((AbstractC1598c) AbstractC1598c.m12304a(interfaceC2218f, 1, AbstractC1596a.m12258a(AbstractC1596a.f10139o)));
                return c1646l;
            case 35:
                return m12398a(EnumC1621l.NEW_INSTANCE, AbstractC1598c.m12304a(interfaceC2218f, 0, this.f10239c.m12548a((InterfaceC2243h) ((InterfaceC2225m) interfaceC2218f).mo14489f())));
            case 36:
                AbstractC1596a m12548a2 = this.f10239c.m12548a((InterfaceC2243h) ((InterfaceC2225m) interfaceC2218f).mo14489f());
                return new C1624o(m12548a2, AbstractC1598c.m12304a(interfaceC2218f, 0, m12548a2), AbstractC1598c.m12304a(interfaceC2218f, 1, AbstractC1596a.f10125a));
            case 37:
                return m12408b(interfaceC2218f, i, false);
            case 38:
                return m12408b(interfaceC2218f, i, true);
            case 39:
                return m12407b(interfaceC2218f, i);
            case 40:
                return m12399a(EnumC1621l.THROW, (C1604i) null, AbstractC1598c.m12304a(interfaceC2218f, 0, AbstractC1596a.m12265a(EnumC1603h.OBJECT)));
            case 41:
            case 42:
            case 43:
                return new C1616g(((InterfaceC2222j) interfaceC2218f).mo14507e() + i);
            case 44:
                return m12402a(interfaceC2218f, i, true);
            case 45:
                return m12402a(interfaceC2218f, i, false);
            case 46:
                return m12406a(interfaceC2218f, EnumC1621l.CMP_L, AbstractC1596a.f10130f);
            case 47:
                return m12406a(interfaceC2218f, EnumC1621l.CMP_G, AbstractC1596a.f10130f);
            case 48:
                return m12406a(interfaceC2218f, EnumC1621l.CMP_L, AbstractC1596a.f10131g);
            case 49:
                return m12406a(interfaceC2218f, EnumC1621l.CMP_G, AbstractC1596a.f10131g);
            case 50:
                return m12406a(interfaceC2218f, EnumC1621l.CMP_L, AbstractC1596a.f10132h);
            case 51:
            case 57:
                return new C1617h(interfaceC2218f, EnumC1618i.EQ, i);
            case 52:
            case 58:
                return new C1617h(interfaceC2218f, EnumC1618i.NE, i);
            case 53:
            case 59:
                return new C1617h(interfaceC2218f, EnumC1618i.LT, i);
            case 54:
            case 60:
                return new C1617h(interfaceC2218f, EnumC1618i.GE, i);
            case 55:
            case 61:
                return new C1617h(interfaceC2218f, EnumC1618i.GT, i);
            case 56:
            case 62:
                return new C1617h(interfaceC2218f, EnumC1618i.LE, i);
            case 63:
                return m12403a(interfaceC2218f, AbstractC1596a.f10141q);
            case 64:
                return m12403a(interfaceC2218f, AbstractC1596a.f10143s);
            case 65:
                return m12403a(interfaceC2218f, AbstractC1596a.f10140p);
            case 66:
                return m12403a(interfaceC2218f, AbstractC1596a.f10126b);
            case 67:
                return m12403a(interfaceC2218f, AbstractC1596a.f10127c);
            case 68:
                return m12403a(interfaceC2218f, AbstractC1596a.f10129e);
            case 69:
                return m12403a(interfaceC2218f, AbstractC1596a.f10128d);
            case 70:
                return m12409b(interfaceC2218f, AbstractC1596a.f10141q);
            case 71:
                return m12409b(interfaceC2218f, AbstractC1596a.f10143s);
            case 72:
                return m12409b(interfaceC2218f, AbstractC1596a.f10140p);
            case 73:
                return m12409b(interfaceC2218f, AbstractC1596a.f10126b);
            case 74:
                return m12409b(interfaceC2218f, AbstractC1596a.f10127c);
            case 75:
                return m12409b(interfaceC2218f, AbstractC1596a.f10129e);
            case 76:
                return m12409b(interfaceC2218f, AbstractC1596a.f10128d);
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
                C1592d m12224a = C1592d.m12224a(this.f10239c, (InterfaceC2237b) ((InterfaceC2225m) interfaceC2218f).mo14489f());
                C1619j c1619j3 = new C1619j(EnumC1621l.IGET, m12224a, 1);
                c1619j3.m12581b(AbstractC1598c.m12304a(interfaceC2218f, 0, m12224a.m12227b()));
                c1619j3.m12584c((AbstractC1598c) AbstractC1598c.m12304a(interfaceC2218f, 1, m12224a.m12228c().m12211m()));
                return c1619j3;
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
                C1592d m12224a2 = C1592d.m12224a(this.f10239c, (InterfaceC2237b) ((InterfaceC2225m) interfaceC2218f).mo14489f());
                C1619j c1619j4 = new C1619j(EnumC1621l.IPUT, m12224a2, 2);
                c1619j4.m12584c((AbstractC1598c) AbstractC1598c.m12304a(interfaceC2218f, 0, m12224a2.m12227b()));
                c1619j4.m12584c((AbstractC1598c) AbstractC1598c.m12304a(interfaceC2218f, 1, m12224a2.m12228c().m12211m()));
                return c1619j4;
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
                C1592d m12224a3 = C1592d.m12224a(this.f10239c, (InterfaceC2237b) ((InterfaceC2225m) interfaceC2218f).mo14489f());
                C1619j c1619j5 = new C1619j(EnumC1621l.SGET, m12224a3, 0);
                c1619j5.m12581b(AbstractC1598c.m12304a(interfaceC2218f, 0, m12224a3.m12227b()));
                return c1619j5;
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
                C1592d m12224a4 = C1592d.m12224a(this.f10239c, (InterfaceC2237b) ((InterfaceC2225m) interfaceC2218f).mo14489f());
                C1619j c1619j6 = new C1619j(EnumC1621l.SPUT, m12224a4, 1);
                c1619j6.m12584c((AbstractC1598c) AbstractC1598c.m12304a(interfaceC2218f, 0, m12224a4.m12227b()));
                return c1619j6;
            case 105:
                return m12401a(interfaceC2218f, i, EnumC1623n.VIRTUAL, false);
            case 106:
                return m12401a(interfaceC2218f, i, EnumC1623n.SUPER, false);
            case 107:
                return m12401a(interfaceC2218f, i, EnumC1623n.DIRECT, false);
            case 108:
                return m12401a(interfaceC2218f, i, EnumC1623n.STATIC, false);
            case 109:
                return m12401a(interfaceC2218f, i, EnumC1623n.INTERFACE, false);
            case 110:
                return m12401a(interfaceC2218f, i, EnumC1623n.VIRTUAL, true);
            case 111:
                return m12401a(interfaceC2218f, i, EnumC1623n.SUPER, true);
            case 112:
                return m12401a(interfaceC2218f, i, EnumC1623n.DIRECT, true);
            case 113:
                return m12401a(interfaceC2218f, i, EnumC1623n.STATIC, true);
            case 114:
                return m12401a(interfaceC2218f, i, EnumC1623n.INTERFACE, true);
            case 115:
                return m12412c(interfaceC2218f, AbstractC1596a.f10125a);
            case 116:
                return m12413d(interfaceC2218f, AbstractC1596a.f10125a);
            case 117:
                return m12412c(interfaceC2218f, AbstractC1596a.f10132h);
            case 118:
                return m12413d(interfaceC2218f, AbstractC1596a.f10132h);
            case 119:
                return m12412c(interfaceC2218f, AbstractC1596a.f10130f);
            case 120:
                return m12412c(interfaceC2218f, AbstractC1596a.f10131g);
            case 121:
                return m12404a(interfaceC2218f, AbstractC1596a.f10125a, AbstractC1596a.f10132h);
            case 122:
                return m12404a(interfaceC2218f, AbstractC1596a.f10125a, AbstractC1596a.f10130f);
            case 123:
                return m12404a(interfaceC2218f, AbstractC1596a.f10125a, AbstractC1596a.f10131g);
            case 124:
                return m12404a(interfaceC2218f, AbstractC1596a.f10132h, AbstractC1596a.f10125a);
            case 125:
                return m12404a(interfaceC2218f, AbstractC1596a.f10132h, AbstractC1596a.f10130f);
            case 126:
                return m12404a(interfaceC2218f, AbstractC1596a.f10132h, AbstractC1596a.f10131g);
            case 127:
                return m12404a(interfaceC2218f, AbstractC1596a.f10130f, AbstractC1596a.f10125a);
            case 128:
                return m12404a(interfaceC2218f, AbstractC1596a.f10130f, AbstractC1596a.f10132h);
            case 129:
                return m12404a(interfaceC2218f, AbstractC1596a.f10130f, AbstractC1596a.f10131g);
            case 130:
                return m12404a(interfaceC2218f, AbstractC1596a.f10131g, AbstractC1596a.f10125a);
            case 131:
                return m12404a(interfaceC2218f, AbstractC1596a.f10131g, AbstractC1596a.f10132h);
            case 132:
                return m12404a(interfaceC2218f, AbstractC1596a.f10131g, AbstractC1596a.f10130f);
            case 133:
                return m12404a(interfaceC2218f, AbstractC1596a.f10125a, AbstractC1596a.f10127c);
            case 134:
                return m12404a(interfaceC2218f, AbstractC1596a.f10125a, AbstractC1596a.f10129e);
            case 135:
                return m12404a(interfaceC2218f, AbstractC1596a.f10125a, AbstractC1596a.f10128d);
            case 136:
            case 168:
                return m12405a(interfaceC2218f, EnumC1609b.ADD, AbstractC1596a.f10125a);
            case 137:
            case 169:
                return m12405a(interfaceC2218f, EnumC1609b.SUB, AbstractC1596a.f10125a);
            case 138:
            case 170:
                return m12405a(interfaceC2218f, EnumC1609b.MUL, AbstractC1596a.f10125a);
            case 139:
            case 171:
                return m12405a(interfaceC2218f, EnumC1609b.DIV, AbstractC1596a.f10125a);
            case 140:
            case 172:
                return m12405a(interfaceC2218f, EnumC1609b.REM, AbstractC1596a.f10125a);
            case 141:
            case 173:
                return m12405a(interfaceC2218f, EnumC1609b.AND, AbstractC1596a.f10125a);
            case 142:
            case 174:
                return m12405a(interfaceC2218f, EnumC1609b.OR, AbstractC1596a.f10125a);
            case 143:
            case 175:
                return m12405a(interfaceC2218f, EnumC1609b.XOR, AbstractC1596a.f10125a);
            case 144:
            case 176:
                return m12405a(interfaceC2218f, EnumC1609b.SHL, AbstractC1596a.f10125a);
            case 145:
            case 177:
                return m12405a(interfaceC2218f, EnumC1609b.SHR, AbstractC1596a.f10125a);
            case 146:
            case 178:
                return m12405a(interfaceC2218f, EnumC1609b.USHR, AbstractC1596a.f10125a);
            case 147:
            case 179:
                return m12405a(interfaceC2218f, EnumC1609b.ADD, AbstractC1596a.f10132h);
            case 148:
            case 180:
                return m12405a(interfaceC2218f, EnumC1609b.SUB, AbstractC1596a.f10132h);
            case 149:
            case 181:
                return m12405a(interfaceC2218f, EnumC1609b.MUL, AbstractC1596a.f10132h);
            case 150:
            case 182:
                return m12405a(interfaceC2218f, EnumC1609b.DIV, AbstractC1596a.f10132h);
            case 151:
            case 183:
                return m12405a(interfaceC2218f, EnumC1609b.REM, AbstractC1596a.f10132h);
            case 152:
            case 184:
                return m12405a(interfaceC2218f, EnumC1609b.AND, AbstractC1596a.f10132h);
            case 153:
            case 185:
                return m12405a(interfaceC2218f, EnumC1609b.OR, AbstractC1596a.f10132h);
            case 154:
            case 186:
                return m12405a(interfaceC2218f, EnumC1609b.XOR, AbstractC1596a.f10132h);
            case 155:
            case 187:
                return m12405a(interfaceC2218f, EnumC1609b.SHL, AbstractC1596a.f10132h);
            case 156:
            case 188:
                return m12405a(interfaceC2218f, EnumC1609b.SHR, AbstractC1596a.f10132h);
            case 157:
            case 189:
                return m12405a(interfaceC2218f, EnumC1609b.USHR, AbstractC1596a.f10132h);
            case 158:
            case 190:
                return m12405a(interfaceC2218f, EnumC1609b.ADD, AbstractC1596a.f10130f);
            case 159:
            case 191:
                return m12405a(interfaceC2218f, EnumC1609b.SUB, AbstractC1596a.f10130f);
            case 160:
            case 192:
                return m12405a(interfaceC2218f, EnumC1609b.MUL, AbstractC1596a.f10130f);
            case 161:
            case 193:
                return m12405a(interfaceC2218f, EnumC1609b.DIV, AbstractC1596a.f10130f);
            case 162:
            case 194:
                return m12405a(interfaceC2218f, EnumC1609b.REM, AbstractC1596a.f10130f);
            case 163:
            case 195:
                return m12405a(interfaceC2218f, EnumC1609b.ADD, AbstractC1596a.f10131g);
            case 164:
            case 196:
                return m12405a(interfaceC2218f, EnumC1609b.SUB, AbstractC1596a.f10131g);
            case 165:
            case 197:
                return m12405a(interfaceC2218f, EnumC1609b.MUL, AbstractC1596a.f10131g);
            case 166:
            case 198:
                return m12405a(interfaceC2218f, EnumC1609b.DIV, AbstractC1596a.f10131g);
            case 167:
            case 199:
                return m12405a(interfaceC2218f, EnumC1609b.REM, AbstractC1596a.f10131g);
            case 200:
            case 208:
                return m12410b(interfaceC2218f, EnumC1609b.ADD, AbstractC1596a.f10125a);
            case 201:
            case 209:
                return new C1595a(EnumC1609b.SUB, AbstractC1598c.m12304a(interfaceC2218f, 0, AbstractC1596a.f10125a), AbstractC1598c.m12301a(interfaceC2218f, AbstractC1596a.f10125a), AbstractC1598c.m12304a(interfaceC2218f, 1, AbstractC1596a.f10125a));
            case 202:
            case 210:
                return m12410b(interfaceC2218f, EnumC1609b.MUL, AbstractC1596a.f10125a);
            case 203:
            case 211:
                return m12410b(interfaceC2218f, EnumC1609b.DIV, AbstractC1596a.f10125a);
            case 204:
            case 212:
                return m12410b(interfaceC2218f, EnumC1609b.REM, AbstractC1596a.f10125a);
            case 205:
            case 213:
                return m12410b(interfaceC2218f, EnumC1609b.AND, AbstractC1596a.f10125a);
            case 206:
            case 214:
                return m12410b(interfaceC2218f, EnumC1609b.OR, AbstractC1596a.f10125a);
            case 207:
            case 215:
                return m12410b(interfaceC2218f, EnumC1609b.XOR, AbstractC1596a.f10125a);
            case 216:
                return m12410b(interfaceC2218f, EnumC1609b.SHL, AbstractC1596a.f10125a);
            case 217:
                return m12410b(interfaceC2218f, EnumC1609b.SHR, AbstractC1596a.f10125a);
            case 218:
                return m12410b(interfaceC2218f, EnumC1609b.USHR, AbstractC1596a.f10125a);
            case 219:
            case 220:
            case 221:
            case 222:
            case 223:
            case 224:
            case 225:
            case 226:
            case 227:
            case 228:
            case 229:
            case 230:
            case 231:
            case 232:
            case 233:
            case 234:
            case 235:
            case 236:
            case 237:
            case 238:
            case 239:
            case 240:
            case 241:
            case 242:
            case 243:
            case 244:
            case 245:
            case 246:
            case 247:
            case 248:
            case 249:
            case 250:
            case 251:
            case 252:
            case 253:
            case 254:
            case 255:
            default:
                throw new C1725b("Unknown instruction: '" + interfaceC2218f.mo14416a().f12384eg + "'");
        }
    }

    /* renamed from: a */
    private C1646l m12402a(InterfaceC2218f interfaceC2218f, int i, boolean z) {
        List<? extends InterfaceC2227o> mo14496f = ((InterfaceC2228p) this.f10240d[((InterfaceC2222j) interfaceC2218f).mo14507e() + i]).mo14496f();
        int size = mo14496f.size();
        Object[] objArr = new Object[size];
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            InterfaceC2227o interfaceC2227o = mo14496f.get(i2);
            iArr[i2] = interfaceC2227o.mo14498b() + i;
            objArr[i2] = Integer.valueOf(interfaceC2227o.mo14497a());
        }
        return new C1626q(AbstractC1598c.m12304a(interfaceC2218f, 0, AbstractC1596a.f10141q), objArr, iArr, m12396a((Object[]) this.f10240d, i));
    }

    /* renamed from: b */
    private C1646l m12407b(InterfaceC2218f interfaceC2218f, int i) {
        return new C1614e(((InterfaceC2223k) interfaceC2218f).mo14495q_(), (InterfaceC2177a) this.f10240d[((InterfaceC2222j) interfaceC2218f).mo14507e() + i]);
    }

    /* renamed from: b */
    private C1646l m12408b(InterfaceC2218f interfaceC2218f, int i, boolean z) {
        InterfaceC2213z interfaceC2213z = (InterfaceC2213z) interfaceC2218f;
        int m12397a = m12397a(this.f10240d, i);
        AbstractC1596a m12548a = this.f10239c.m12548a((InterfaceC2243h) interfaceC2213z.mo14489f());
        AbstractC1596a mo12288n = m12548a.mo12288n();
        boolean mo12278d = mo12288n.mo12278d();
        int e2 = interfaceC2213z.mo14481e();
        AbstractC1598c[] abstractC1598cArr = new AbstractC1598c[e2];
        if (z) {
            int h = interfaceC2213z.mo14483h();
            for (int i2 = 0; i2 < e2; i2++) {
                abstractC1598cArr[i2] = AbstractC1598c.m12303a(h, mo12288n, mo12278d);
                h++;
            }
        } else {
            for (int i3 = 0; i3 < e2; i3++) {
                abstractC1598cArr[i3] = AbstractC1598c.m12303a(C1739h.m13268a(interfaceC2218f, i3), mo12288n, mo12278d);
            }
        }
        C1615f c1615f = new C1615f(mo12288n, abstractC1598cArr.length);
        c1615f.m12581b(m12397a == -1 ? null : AbstractC1598c.m12302a(m12397a, m12548a));
        for (AbstractC1598c abstractC1598c : abstractC1598cArr) {
            c1615f.m12584c(abstractC1598c);
        }
        return c1615f;
    }

    /* renamed from: a */
    private C1646l m12406a(InterfaceC2218f interfaceC2218f, EnumC1621l enumC1621l, AbstractC1596a abstractC1596a) {
        C1646l c1646l = new C1646l(enumC1621l, 2);
        c1646l.m12581b(AbstractC1598c.m12304a(interfaceC2218f, 0, AbstractC1596a.f10125a));
        c1646l.m12584c((AbstractC1598c) AbstractC1598c.m12304a(interfaceC2218f, 1, abstractC1596a));
        c1646l.m12584c((AbstractC1598c) AbstractC1598c.m12304a(interfaceC2218f, 2, abstractC1596a));
        return c1646l;
    }

    /* renamed from: a */
    private C1646l m12404a(InterfaceC2218f interfaceC2218f, AbstractC1596a abstractC1596a, AbstractC1596a abstractC1596a2) {
        C1619j c1619j = new C1619j(EnumC1621l.CAST, abstractC1596a2, 1);
        c1619j.m12581b(AbstractC1598c.m12304a(interfaceC2218f, 0, abstractC1596a2));
        c1619j.m12584c((AbstractC1598c) AbstractC1598c.m12304a(interfaceC2218f, 1, abstractC1596a));
        return c1619j;
    }

    /* renamed from: a */
    private C1646l m12401a(InterfaceC2218f interfaceC2218f, int i, EnumC1623n enumC1623n, boolean z) {
        return new C1622m(C1594f.m12238a(this.f10239c, (InterfaceC2240e) ((InterfaceC2225m) interfaceC2218f).mo14489f()), interfaceC2218f, enumC1623n, z, m12397a(this.f10240d, i));
    }

    /* renamed from: a */
    private C1646l m12403a(InterfaceC2218f interfaceC2218f, AbstractC1596a abstractC1596a) {
        C1646l c1646l = new C1646l(EnumC1621l.AGET, 2);
        c1646l.m12581b(AbstractC1598c.m12304a(interfaceC2218f, 0, abstractC1596a));
        c1646l.m12584c((AbstractC1598c) AbstractC1598c.m12304a(interfaceC2218f, 1, AbstractC1596a.m12265a(EnumC1603h.ARRAY)));
        c1646l.m12584c((AbstractC1598c) AbstractC1598c.m12304a(interfaceC2218f, 2, AbstractC1596a.f10125a));
        return c1646l;
    }

    /* renamed from: b */
    private C1646l m12409b(InterfaceC2218f interfaceC2218f, AbstractC1596a abstractC1596a) {
        C1646l c1646l = new C1646l(EnumC1621l.APUT, 3);
        c1646l.m12584c((AbstractC1598c) AbstractC1598c.m12304a(interfaceC2218f, 1, AbstractC1596a.m12265a(EnumC1603h.ARRAY)));
        c1646l.m12584c((AbstractC1598c) AbstractC1598c.m12304a(interfaceC2218f, 2, AbstractC1596a.f10125a));
        c1646l.m12584c((AbstractC1598c) AbstractC1598c.m12304a(interfaceC2218f, 0, abstractC1596a));
        return c1646l;
    }

    /* renamed from: a */
    private C1646l m12405a(InterfaceC2218f interfaceC2218f, EnumC1609b enumC1609b, AbstractC1596a abstractC1596a) {
        return new C1595a(interfaceC2218f, enumC1609b, abstractC1596a, false);
    }

    /* renamed from: b */
    private C1646l m12410b(InterfaceC2218f interfaceC2218f, EnumC1609b enumC1609b, AbstractC1596a abstractC1596a) {
        return new C1595a(interfaceC2218f, enumC1609b, abstractC1596a, true);
    }

    /* renamed from: c */
    private C1646l m12412c(InterfaceC2218f interfaceC2218f, AbstractC1596a abstractC1596a) {
        C1646l c1646l = new C1646l(EnumC1621l.NEG, 1);
        c1646l.m12581b(AbstractC1598c.m12304a(interfaceC2218f, 0, abstractC1596a));
        c1646l.m12584c((AbstractC1598c) AbstractC1598c.m12304a(interfaceC2218f, 1, abstractC1596a));
        return c1646l;
    }

    /* renamed from: d */
    private C1646l m12413d(InterfaceC2218f interfaceC2218f, AbstractC1596a abstractC1596a) {
        C1646l c1646l = new C1646l(EnumC1621l.NOT, 1);
        c1646l.m12581b(AbstractC1598c.m12304a(interfaceC2218f, 0, abstractC1596a));
        c1646l.m12584c((AbstractC1598c) AbstractC1598c.m12304a(interfaceC2218f, 1, abstractC1596a));
        return c1646l;
    }

    /* renamed from: a */
    private C1646l m12398a(EnumC1621l enumC1621l, C1604i c1604i) {
        C1646l c1646l = new C1646l(enumC1621l, 0);
        c1646l.m12581b(c1604i);
        return c1646l;
    }

    /* renamed from: a */
    private C1646l m12399a(EnumC1621l enumC1621l, C1604i c1604i, AbstractC1598c abstractC1598c) {
        C1646l c1646l = new C1646l(enumC1621l, 1);
        c1646l.m12581b(c1604i);
        c1646l.m12584c(abstractC1598c);
        return c1646l;
    }

    /* renamed from: a */
    private int m12397a(InterfaceC2218f[] interfaceC2218fArr, int i) {
        InterfaceC2218f interfaceC2218f;
        EnumC2272f mo14416a;
        int m12396a = m12396a((Object[]) interfaceC2218fArr, i);
        if (m12396a < 0 || !((mo14416a = (interfaceC2218f = interfaceC2218fArr[m12396a]).mo14416a()) == EnumC2272f.MOVE_RESULT || mo14416a == EnumC2272f.MOVE_RESULT_WIDE || mo14416a == EnumC2272f.MOVE_RESULT_OBJECT)) {
            return -1;
        }
        return ((InterfaceC2223k) interfaceC2218f).mo14495q_();
    }

    /* renamed from: a */
    public static int m12396a(Object[] objArr, int i) {
        int i2 = i + 1;
        while (i2 < objArr.length && objArr[i2] == null) {
            i2++;
        }
        if (i2 >= objArr.length) {
            return -1;
        }
        return i2;
    }
}
