package ru.maximoff.apktool.util;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Camera;
import android.p008os.Build;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Colors.java */
/* renamed from: ru.maximoff.apktool.util.h */
/* loaded from: classes.dex */
public class C3246h {

    /* renamed from: a */
    private static final Map<String, String> f19518a;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("aliceblue", "#FFF0F8FF");
        hashMap.put("antiquewhite", "#FFFAEBD7");
        hashMap.put(Camera.Parameters.EFFECT_AQUA, "#FF00FFFF");
        hashMap.put("aquamarine", "#FF7FFFD4");
        hashMap.put("azure", "#FFF0FFFF");
        hashMap.put("beige", "#FFF5F5DC");
        hashMap.put("bisque", "#FFFFE4C4");
        hashMap.put("black", "#FF000000");
        hashMap.put("blanchedalmond", "#FFFFEBCD");
        hashMap.put("blue", "#FF0000FF");
        hashMap.put("blueviolet", "#FF8A2BE2");
        hashMap.put("brown", "#FFA52A2A");
        hashMap.put("burlywood", "#FFDEB887");
        hashMap.put("cadetblue", "#FF5F9EA0");
        hashMap.put("chartreuse", "#FF7FFF00");
        hashMap.put("chocolate", "#FFD2691E");
        hashMap.put("coral", "#FFFF7F50");
        hashMap.put("cornflowerblue", "#FF6495ED");
        hashMap.put("cornsilk", "#FFFFF8DC");
        hashMap.put("crimson", "#FFDC143C");
        hashMap.put("cyan", "#FF00FFFF");
        hashMap.put("darkblue", "#FF00008B");
        hashMap.put("darkcyan", "#FF008B8B");
        hashMap.put("darkgoldenrod", "#FFB8860B");
        hashMap.put("darkgray", "#FFA9A9A9");
        hashMap.put("darkgreen", "#FF006400");
        hashMap.put("darkgrey", "#FFA9A9A9");
        hashMap.put("darkkhaki", "#FFBDB76B");
        hashMap.put("darkmagenta", "#FF8B008B");
        hashMap.put("darkolivegreen", "#FF556B2F");
        hashMap.put("darkorange", "#FFFF8C00");
        hashMap.put("darkorchid", "#FF9932CC");
        hashMap.put("darkred", "#FF8B0000");
        hashMap.put("darksalmon", "#FFE9967A");
        hashMap.put("darkseagreen", "#FF8FBC8F");
        hashMap.put("darkslateblue", "#FF483D8B");
        hashMap.put("darkslategray", "#FF2F4F4F");
        hashMap.put("darkslategrey", "#FF2F4F4F");
        hashMap.put("darkturquoise", "#FF00CED1");
        hashMap.put("darkviolet", "#FF9400D3");
        hashMap.put("deeppink", "#FFFF1493");
        hashMap.put("deepskyblue", "#FF00BFFF");
        hashMap.put("dimgray", "#FF696969");
        hashMap.put("dimgrey", "#FF696969");
        hashMap.put("dodgerblue", "#FF1E90FF");
        hashMap.put("firebrick", "#FFB22222");
        hashMap.put("floralwhite", "#FFFFFAF0");
        hashMap.put("forestgreen", "#FF228B22");
        hashMap.put("fuchsia", "#FFFF00FF");
        hashMap.put("gainsboro", "#FFDCDCDC");
        hashMap.put("ghostwhite", "#FFF8F8FF");
        hashMap.put("gold", "#FFFFD700");
        hashMap.put("goldenrod", "#FFDAA520");
        hashMap.put("gray", "#FF808080");
        hashMap.put("green", "#FF008000");
        hashMap.put("greenyellow", "#FFADFF2F");
        hashMap.put("grey", "#FF808080");
        hashMap.put("honeydew", "#FFF0FFF0");
        hashMap.put("hotpink", "#FFFF69B4");
        hashMap.put("indianred", "#FFCD5C5C");
        hashMap.put("indigo", "#FF4B0082");
        hashMap.put("ivory", "#FFFFFFF0");
        hashMap.put("khaki", "#FFF0E68C");
        hashMap.put("lavender", "#FFE6E6FA");
        hashMap.put("lavenderblush", "#FFFFF0F5");
        hashMap.put("lawngreen", "#FF7CFC00");
        hashMap.put("lemonchiffon", "#FFFFFACD");
        hashMap.put("lightblue", "#FFADD8E6");
        hashMap.put("lightcoral", "#FFF08080");
        hashMap.put("lightcyan", "#FFE0FFFF");
        hashMap.put("lightgoldenrodyellow", "#FFFAFAD2");
        hashMap.put("lightgray", "#FFD3D3D3");
        hashMap.put("lightgreen", "#FF90EE90");
        hashMap.put("lightgrey", "#FFD3D3D3");
        hashMap.put("lightpink", "#FFFFB6C1");
        hashMap.put("lightsalmon", "#FFFFA07A");
        hashMap.put("lightseagreen", "#FF20B2AA");
        hashMap.put("lightskyblue", "#FF87CEFA");
        hashMap.put("lightslategray", "#FF778899");
        hashMap.put("lightslategrey", "#FF778899");
        hashMap.put("lightsteelblue", "#FFB0C4DE");
        hashMap.put("lightyellow", "#FFFFFFE0");
        hashMap.put("lime", "#FF00FF00");
        hashMap.put("limegreen", "#FF32CD32");
        hashMap.put("linen", "#FFFAF0E6");
        hashMap.put("magenta", "#FFFF00FF");
        hashMap.put("maroon", "#FF800000");
        hashMap.put("mediumaquamarine", "#FF66CDAA");
        hashMap.put("mediumblue", "#FF0000CD");
        hashMap.put("mediumorchid", "#FFBA55D3");
        hashMap.put("mediumpurple", "#FF9370DB");
        hashMap.put("mediumseagreen", "#FF3CB371");
        hashMap.put("mediumslateblue", "#FF7B68EE");
        hashMap.put("mediumspringgreen", "#FF00FA9A");
        hashMap.put("mediumturquoise", "#FF48D1CC");
        hashMap.put("mediumvioletred", "#FFC71585");
        hashMap.put("midnightblue", "#FF191970");
        hashMap.put("mintcream", "#FFF5FFFA");
        hashMap.put("mistyrose", "#FFFFE4E1");
        hashMap.put("moccasin", "#FFFFE4B5");
        hashMap.put("navajowhite", "#FFFFDEAD");
        hashMap.put("navy", "#FF000080");
        hashMap.put("oldlace", "#FFFDF5E6");
        hashMap.put("olive", "#FF808000");
        hashMap.put("olivedrab", "#FF6B8E23");
        hashMap.put("orange", "#FFFFA500");
        hashMap.put("orangered", "#FFFF4500");
        hashMap.put("orchid", "#FFDA70D6");
        hashMap.put("palegoldenrod", "#FFEEE8AA");
        hashMap.put("palegreen", "#FF98FB98");
        hashMap.put("paleturquoise", "#FFAFEEEE");
        hashMap.put("palevioletred", "#FFDB7093");
        hashMap.put("papayawhip", "#FFFFEFD5");
        hashMap.put("peachpuff", "#FFFFDAB9");
        hashMap.put("peru", "#FFCD853F");
        hashMap.put("pink", "#FFFFC0CB");
        hashMap.put("plum", "#FFDDA0DD");
        hashMap.put("powderblue", "#FFB0E0E6");
        hashMap.put("purple", "#FF800080");
        hashMap.put("rebeccapurple", "#FF663399");
        hashMap.put("red", "#FFFF0000");
        hashMap.put("rosybrown", "#FFBC8F8F");
        hashMap.put("royalblue", "#FF4169E1");
        hashMap.put("saddlebrown", "#FF8B4513");
        hashMap.put("salmon", "#FFFA8072");
        hashMap.put("sandybrown", "#FFF4A460");
        hashMap.put("seagreen", "#FF2E8B57");
        hashMap.put("seashell", "#FFFFF5EE");
        hashMap.put("sienna", "#FFA0522D");
        hashMap.put("silver", "#FFC0C0C0");
        hashMap.put("skyblue", "#FF87CEEB");
        hashMap.put("slateblue", "#FF6A5ACD");
        hashMap.put("slategray", "#FF708090");
        hashMap.put("slategrey", "#FF708090");
        hashMap.put(Camera.Parameters.SCENE_MODE_SNOW, "#FFFFFAFA");
        hashMap.put("springgreen", "#FF00FF7F");
        hashMap.put("steelblue", "#FF4682B4");
        hashMap.put("tan", "#FFD2B48C");
        hashMap.put("teal", "#FF008080");
        hashMap.put("thistle", "#FFD8BFD8");
        hashMap.put("tomato", "#FFFF6347");
        hashMap.put("turquoise", "#FF40E0D0");
        hashMap.put("violet", "#FFEE82EE");
        hashMap.put("wheat", "#FFF5DEB3");
        hashMap.put("white", "#FFFFFFFF");
        hashMap.put("whitesmoke", "#FFF5F5F5");
        hashMap.put("yellow", "#FFFFFF00");
        hashMap.put("yellowgreen", "#FF9ACD32");
        f19518a = hashMap;
    }

    /* renamed from: a */
    public static String m19471a(String str) {
        return f19518a.get(str);
    }

    /* renamed from: a */
    public static int m19470a(Context context, int i) {
        return Build.VERSION.SDK_INT >= 23 ? context.getColor(i) : context.getResources().getColor(i);
    }

    /* renamed from: a */
    public static int m19469a(int i, int i2) {
        return Color.argb(Math.max(0, Math.min(255, i2)), Color.red(i), Color.green(i), Color.blue(i));
    }
}
