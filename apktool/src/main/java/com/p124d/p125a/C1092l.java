package com.p124d.p125a;

import android.app.slice.Slice;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.fonts.FontStyle;
import android.hardware.Camera;
import android.hardware.HardwareBuffer;
import android.media.session.PlaybackState;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.util.Log;
import android.util.Xml;
import com.p124d.p125a.C1082b;
import com.p124d.p125a.C1086f;
import com.p124d.p125a.C1088h;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;
import org.xmlpull.p291v1.XmlPullParser;
import org.xmlpull.p291v1.XmlPullParserException;

/* compiled from: SVGParser.java */
/* renamed from: com.d.a.l */
/* loaded from: classes.dex */
class C1092l {

    /* renamed from: d */
    private int f7301d;

    /* renamed from: a */
    private C1088h f7298a = null;

    /* renamed from: b */
    private C1088h.ai f7299b = null;

    /* renamed from: c */
    private boolean f7300c = false;

    /* renamed from: e */
    private boolean f7302e = false;

    /* renamed from: f */
    private g f7303f = null;

    /* renamed from: g */
    private StringBuilder f7304g = null;

    /* renamed from: h */
    private boolean f7305h = false;

    /* renamed from: i */
    private StringBuilder f7306i = null;

    C1092l() {
    }

    /* compiled from: SVGParser.java */
    /* renamed from: com.d.a.l$g */
    private enum g {
        svg,
        a,
        circle,
        clipPath,
        defs,
        desc,
        ellipse,
        g,
        image,
        line,
        linearGradient,
        marker,
        mask,
        path,
        pattern,
        polygon,
        polyline,
        radialGradient,
        rect,
        solidColor,
        stop,
        style,
        SWITCH,
        symbol,
        text,
        textPath,
        title,
        tref,
        tspan,
        use,
        view,
        UNSUPPORTED;


        /* renamed from: G */
        private static final Map<String, g> f7414G = new HashMap();

        static {
            for (g gVar : values()) {
                if (gVar == SWITCH) {
                    f7414G.put("switch", gVar);
                } else if (gVar != UNSUPPORTED) {
                    f7414G.put(gVar.name(), gVar);
                }
            }
        }

        /* renamed from: a */
        public static g m9375a(String str) {
            g gVar = f7414G.get(str);
            return gVar != null ? gVar : UNSUPPORTED;
        }
    }

    /* compiled from: SVGParser.java */
    /* renamed from: com.d.a.l$f */
    private enum f {
        CLASS,
        clip,
        clip_path,
        clipPathUnits,
        clip_rule,
        color,
        cx,
        cy,
        direction,
        dx,
        dy,
        fx,
        fy,
        d,
        display,
        fill,
        fill_rule,
        fill_opacity,
        font,
        font_family,
        font_size,
        font_weight,
        font_style,
        gradientTransform,
        gradientUnits,
        height,
        href,
        image_rendering,
        marker,
        marker_start,
        marker_mid,
        marker_end,
        markerHeight,
        markerUnits,
        markerWidth,
        mask,
        maskContentUnits,
        maskUnits,
        media,
        offset,
        opacity,
        orient,
        overflow,
        pathLength,
        patternContentUnits,
        patternTransform,
        patternUnits,
        points,
        preserveAspectRatio,
        r,
        refX,
        refY,
        requiredFeatures,
        requiredExtensions,
        requiredFormats,
        requiredFonts,
        rx,
        ry,
        solid_color,
        solid_opacity,
        spreadMethod,
        startOffset,
        stop_color,
        stop_opacity,
        stroke,
        stroke_dasharray,
        stroke_dashoffset,
        stroke_linecap,
        stroke_linejoin,
        stroke_miterlimit,
        stroke_opacity,
        stroke_width,
        style,
        systemLanguage,
        text_anchor,
        text_decoration,
        transform,
        type,
        vector_effect,
        version,
        viewBox,
        width,
        x,
        y,
        x1,
        y1,
        x2,
        y2,
        viewport_fill,
        viewport_fill_opacity,
        visibility,
        UNSUPPORTED;


        /* renamed from: aO */
        private static final Map<String, f> f7355aO = new HashMap();

        static {
            for (f fVar : values()) {
                if (fVar == CLASS) {
                    f7355aO.put("class", fVar);
                } else if (fVar != UNSUPPORTED) {
                    f7355aO.put(fVar.name().replace('_', '-'), fVar);
                }
            }
        }

        /* renamed from: a */
        public static f m9374a(String str) {
            f fVar = f7355aO.get(str);
            return fVar != null ? fVar : UNSUPPORTED;
        }
    }

    /* compiled from: SVGParser.java */
    /* renamed from: com.d.a.l$b */
    private static class b {

        /* renamed from: a */
        private static final Map<String, Integer> f7310a = new HashMap(47);

        static {
            f7310a.put("aliceblue", -984833);
            f7310a.put("antiquewhite", -332841);
            f7310a.put(Camera.Parameters.EFFECT_AQUA, Integer.valueOf(Color.CYAN));
            f7310a.put("aquamarine", -8388652);
            f7310a.put("azure", -983041);
            f7310a.put("beige", -657956);
            f7310a.put("bisque", -6972);
            f7310a.put("black", -16777216);
            f7310a.put("blanchedalmond", -5171);
            f7310a.put("blue", -16776961);
            f7310a.put("blueviolet", -7722014);
            f7310a.put("brown", -5952982);
            f7310a.put("burlywood", -2180985);
            f7310a.put("cadetblue", -10510688);
            f7310a.put("chartreuse", -8388864);
            f7310a.put("chocolate", -2987746);
            f7310a.put("coral", -32944);
            f7310a.put("cornflowerblue", -10185235);
            f7310a.put("cornsilk", -1828);
            f7310a.put("crimson", -2354116);
            f7310a.put("cyan", Integer.valueOf(Color.CYAN));
            f7310a.put("darkblue", -16777077);
            f7310a.put("darkcyan", -16741493);
            f7310a.put("darkgoldenrod", -4684277);
            f7310a.put("darkgray", -5658199);
            f7310a.put("darkgreen", -16751616);
            f7310a.put("darkgrey", -5658199);
            f7310a.put("darkkhaki", -4343957);
            f7310a.put("darkmagenta", -7667573);
            f7310a.put("darkolivegreen", -11179217);
            f7310a.put("darkorange", -29696);
            f7310a.put("darkorchid", -6737204);
            f7310a.put("darkred", -7667712);
            f7310a.put("darksalmon", -1468806);
            f7310a.put("darkseagreen", -7357297);
            f7310a.put("darkslateblue", -12042869);
            f7310a.put("darkslategray", -13676721);
            f7310a.put("darkslategrey", -13676721);
            f7310a.put("darkturquoise", -16724271);
            f7310a.put("darkviolet", -7077677);
            f7310a.put("deeppink", -60269);
            f7310a.put("deepskyblue", -16728065);
            f7310a.put("dimgray", -9868951);
            f7310a.put("dimgrey", -9868951);
            f7310a.put("dodgerblue", -14774017);
            f7310a.put("firebrick", -5103070);
            f7310a.put("floralwhite", -1296);
            f7310a.put("forestgreen", -14513374);
            f7310a.put("fuchsia", Integer.valueOf(Color.MAGENTA));
            f7310a.put("gainsboro", -2302756);
            f7310a.put("ghostwhite", -460545);
            f7310a.put("gold", -10496);
            f7310a.put("goldenrod", -2448096);
            f7310a.put("gray", -8355712);
            f7310a.put("green", -16744448);
            f7310a.put("greenyellow", -5374161);
            f7310a.put("grey", -8355712);
            f7310a.put("honeydew", -983056);
            f7310a.put("hotpink", -38476);
            f7310a.put("indianred", -3318692);
            f7310a.put("indigo", -11861886);
            f7310a.put("ivory", -16);
            f7310a.put("khaki", -989556);
            f7310a.put("lavender", -1644806);
            f7310a.put("lavenderblush", -3851);
            f7310a.put("lawngreen", -8586240);
            f7310a.put("lemonchiffon", -1331);
            f7310a.put("lightblue", -5383962);
            f7310a.put("lightcoral", -1015680);
            f7310a.put("lightcyan", -2031617);
            f7310a.put("lightgoldenrodyellow", -329006);
            f7310a.put("lightgray", -2894893);
            f7310a.put("lightgreen", -7278960);
            f7310a.put("lightgrey", -2894893);
            f7310a.put("lightpink", -18751);
            f7310a.put("lightsalmon", -24454);
            f7310a.put("lightseagreen", -14634326);
            f7310a.put("lightskyblue", -7876870);
            f7310a.put("lightslategray", -8943463);
            f7310a.put("lightslategrey", -8943463);
            f7310a.put("lightsteelblue", -5192482);
            f7310a.put("lightyellow", -32);
            f7310a.put("lime", Integer.valueOf(Color.GREEN));
            f7310a.put("limegreen", -13447886);
            f7310a.put("linen", -331546);
            f7310a.put("magenta", Integer.valueOf(Color.MAGENTA));
            f7310a.put("maroon", -8388608);
            f7310a.put("mediumaquamarine", -10039894);
            f7310a.put("mediumblue", -16777011);
            f7310a.put("mediumorchid", -4565549);
            f7310a.put("mediumpurple", -7114533);
            f7310a.put("mediumseagreen", -12799119);
            f7310a.put("mediumslateblue", -8689426);
            f7310a.put("mediumspringgreen", -16713062);
            f7310a.put("mediumturquoise", -12004916);
            f7310a.put("mediumvioletred", -3730043);
            f7310a.put("midnightblue", -15132304);
            f7310a.put("mintcream", -655366);
            f7310a.put("mistyrose", -6943);
            f7310a.put("moccasin", -6987);
            f7310a.put("navajowhite", -8531);
            f7310a.put("navy", -16777088);
            f7310a.put("oldlace", -133658);
            f7310a.put("olive", -8355840);
            f7310a.put("olivedrab", -9728477);
            f7310a.put("orange", -23296);
            f7310a.put("orangered", -47872);
            f7310a.put("orchid", -2461482);
            f7310a.put("palegoldenrod", -1120086);
            f7310a.put("palegreen", -6751336);
            f7310a.put("paleturquoise", -5247250);
            f7310a.put("palevioletred", -2396013);
            f7310a.put("papayawhip", -4139);
            f7310a.put("peachpuff", -9543);
            f7310a.put("peru", -3308225);
            f7310a.put("pink", -16181);
            f7310a.put("plum", -2252579);
            f7310a.put("powderblue", -5185306);
            f7310a.put("purple", -8388480);
            f7310a.put("rebeccapurple", -10079335);
            f7310a.put("red", Integer.valueOf(Color.RED));
            f7310a.put("rosybrown", -4419697);
            f7310a.put("royalblue", -12490271);
            f7310a.put("saddlebrown", -7650029);
            f7310a.put("salmon", -360334);
            f7310a.put("sandybrown", -744352);
            f7310a.put("seagreen", -13726889);
            f7310a.put("seashell", -2578);
            f7310a.put("sienna", -6270419);
            f7310a.put("silver", -4144960);
            f7310a.put("skyblue", -7876885);
            f7310a.put("slateblue", -9807155);
            f7310a.put("slategray", -9404272);
            f7310a.put("slategrey", -9404272);
            f7310a.put(Camera.Parameters.SCENE_MODE_SNOW, -1286);
            f7310a.put("springgreen", -16711809);
            f7310a.put("steelblue", -12156236);
            f7310a.put("tan", -2968436);
            f7310a.put("teal", -16744320);
            f7310a.put("thistle", -2572328);
            f7310a.put("tomato", -40121);
            f7310a.put("turquoise", -12525360);
            f7310a.put("violet", -1146130);
            f7310a.put("wheat", -663885);
            f7310a.put("white", -1);
            f7310a.put("whitesmoke", -657931);
            f7310a.put("yellow", -256);
            f7310a.put("yellowgreen", -6632142);
            f7310a.put("transparent", 0);
        }

        /* renamed from: a */
        static Integer m9371a(String str) {
            return f7310a.get(str);
        }
    }

    /* compiled from: SVGParser.java */
    /* renamed from: com.d.a.l$c */
    private static class c {

        /* renamed from: a */
        private static final Map<String, C1088h.o> f7311a = new HashMap(9);

        static {
            f7311a.put("xx-small", new C1088h.o(0.694f, C1088h.bc.pt));
            f7311a.put("x-small", new C1088h.o(0.833f, C1088h.bc.pt));
            f7311a.put("small", new C1088h.o(10.0f, C1088h.bc.pt));
            f7311a.put("medium", new C1088h.o(12.0f, C1088h.bc.pt));
            f7311a.put(Slice.HINT_LARGE, new C1088h.o(14.4f, C1088h.bc.pt));
            f7311a.put("x-large", new C1088h.o(17.3f, C1088h.bc.pt));
            f7311a.put("xx-large", new C1088h.o(20.7f, C1088h.bc.pt));
            f7311a.put("smaller", new C1088h.o(83.33f, C1088h.bc.percent));
            f7311a.put("larger", new C1088h.o(120.0f, C1088h.bc.percent));
        }

        /* renamed from: a */
        static C1088h.o m9372a(String str) {
            return f7311a.get(str);
        }
    }

    /* compiled from: SVGParser.java */
    /* renamed from: com.d.a.l$d */
    private static class d {

        /* renamed from: a */
        private static final Map<String, Integer> f7312a = new HashMap(13);

        static {
            f7312a.put("normal", 400);
            f7312a.put("bold", 700);
            f7312a.put("bolder", 1);
            f7312a.put("lighter", -1);
            f7312a.put("100", 100);
            f7312a.put("200", 200);
            f7312a.put("300", 300);
            f7312a.put("400", 400);
            f7312a.put("500", 500);
            f7312a.put("600", 600);
            f7312a.put("700", 700);
            f7312a.put("800", 800);
            f7312a.put("900", Integer.valueOf(FontStyle.FONT_WEIGHT_BLACK));
        }

        /* renamed from: a */
        static Integer m9373a(String str) {
            return f7312a.get(str);
        }
    }

    /* compiled from: SVGParser.java */
    /* renamed from: com.d.a.l$a */
    private static class a {

        /* renamed from: a */
        private static final Map<String, C1086f.a> f7309a = new HashMap(10);

        static {
            f7309a.put(Camera.Parameters.EFFECT_NONE, C1086f.a.none);
            f7309a.put("xMinYMin", C1086f.a.xMinYMin);
            f7309a.put("xMidYMin", C1086f.a.xMidYMin);
            f7309a.put("xMaxYMin", C1086f.a.xMaxYMin);
            f7309a.put("xMinYMid", C1086f.a.xMinYMid);
            f7309a.put("xMidYMid", C1086f.a.xMidYMid);
            f7309a.put("xMaxYMid", C1086f.a.xMaxYMid);
            f7309a.put("xMinYMax", C1086f.a.xMinYMax);
            f7309a.put("xMidYMax", C1086f.a.xMidYMax);
            f7309a.put("xMaxYMax", C1086f.a.xMaxYMax);
        }

        /* renamed from: a */
        static C1086f.a m9370a(String str) {
            return f7309a.get(str);
        }
    }

    /* renamed from: a */
    C1088h m9369a(InputStream inputStream, boolean z) {
        InputStream bufferedInputStream = !inputStream.markSupported() ? new BufferedInputStream(inputStream) : inputStream;
        try {
            bufferedInputStream.mark(3);
            int read = bufferedInputStream.read() + (bufferedInputStream.read() << 8);
            bufferedInputStream.reset();
            bufferedInputStream = read == 35615 ? new BufferedInputStream(new GZIPInputStream(bufferedInputStream)) : bufferedInputStream;
        } catch (IOException e2) {
        }
        try {
            bufferedInputStream.mark(4096);
            m9319b(bufferedInputStream, z);
            return this.f7298a;
        } finally {
            try {
                bufferedInputStream.close();
            } catch (IOException e3) {
                Log.m184e("SVGParser", "Exception thrown closing input stream");
            }
        }
    }

    /* compiled from: SVGParser.java */
    /* renamed from: com.d.a.l$i */
    private class i implements Attributes {

        /* renamed from: b */
        private XmlPullParser f7447b;

        public i(XmlPullParser xmlPullParser) {
            this.f7447b = xmlPullParser;
        }

        @Override // org.xml.sax.Attributes
        public int getLength() {
            return this.f7447b.getAttributeCount();
        }

        @Override // org.xml.sax.Attributes
        public String getURI(int i) {
            return this.f7447b.getAttributeNamespace(i);
        }

        @Override // org.xml.sax.Attributes
        public String getLocalName(int i) {
            return this.f7447b.getAttributeName(i);
        }

        @Override // org.xml.sax.Attributes
        public String getQName(int i) {
            String attributeName = this.f7447b.getAttributeName(i);
            if (this.f7447b.getAttributePrefix(i) != null) {
                return this.f7447b.getAttributePrefix(i) + ':' + attributeName;
            }
            return attributeName;
        }

        @Override // org.xml.sax.Attributes
        public String getValue(int i) {
            return this.f7447b.getAttributeValue(i);
        }

        @Override // org.xml.sax.Attributes
        public String getType(int i) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public int getIndex(String str, String str2) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public int getIndex(String str) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String str, String str2) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String str) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getValue(String str, String str2) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getValue(String str) {
            return null;
        }
    }

    /* renamed from: b */
    private void m9319b(InputStream inputStream, boolean z) {
        try {
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                i iVar = new i(newPullParser);
                newPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_DOCDECL, false);
                newPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);
                newPullParser.setInput(inputStream, null);
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.nextToken()) {
                    switch (eventType) {
                        case 0:
                            m9272a();
                            break;
                        case 2:
                            String name = newPullParser.getName();
                            if (newPullParser.getPrefix() != null) {
                                name = newPullParser.getPrefix() + ':' + name;
                            }
                            m9308a(newPullParser.getNamespace(), newPullParser.getName(), name, iVar);
                            break;
                        case 3:
                            String name2 = newPullParser.getName();
                            if (newPullParser.getPrefix() != null) {
                                name2 = newPullParser.getPrefix() + ':' + name2;
                            }
                            m9307a(newPullParser.getNamespace(), newPullParser.getName(), name2);
                            break;
                        case 4:
                            int[] iArr = new int[2];
                            m9312a(newPullParser.getTextCharacters(iArr), iArr[0], iArr[1]);
                            break;
                        case 5:
                            m9321c(newPullParser.getText());
                            break;
                        case 8:
                            Log.m182d("SVGParser", "PROC INSTR: " + newPullParser.getText());
                            h hVar = new h(newPullParser.getText());
                            m9309a(hVar.m9395o(), m9270a(hVar));
                            break;
                        case 10:
                            if (z && this.f7298a.m9076a() == null && newPullParser.getText().contains("<!ENTITY ")) {
                                try {
                                    Log.m182d("SVGParser", "Switching to SAX parser to process entities");
                                    inputStream.reset();
                                    m9306a(inputStream);
                                    return;
                                } catch (IOException e2) {
                                    Log.m190w("SVGParser", "Detected internal entity definitions, but could not parse them.");
                                    return;
                                }
                            }
                            break;
                    }
                }
                m9316b();
            } catch (XmlPullParserException e3) {
                throw new C1091k("XML parser problem", e3);
            }
        } catch (IOException e4) {
            throw new C1091k("Stream error", e4);
        }
    }

    /* renamed from: a */
    private void m9306a(InputStream inputStream) {
        Log.m182d("SVGParser", "Falling back to SAX parser");
        try {
            SAXParserFactory newInstance = SAXParserFactory.newInstance();
            newInstance.setFeature("http://xml.org/sax/features/external-general-entities", false);
            newInstance.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            XMLReader xMLReader = newInstance.newSAXParser().getXMLReader();
            e eVar = new e();
            xMLReader.setContentHandler(eVar);
            xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", eVar);
            xMLReader.parse(new InputSource(inputStream));
        } catch (IOException e2) {
            throw new C1091k("Stream error", e2);
        } catch (ParserConfigurationException e3) {
            throw new C1091k("XML parser problem", e3);
        } catch (SAXException e4) {
            throw new C1091k("SVG parse error", e4);
        }
    }

    /* compiled from: SVGParser.java */
    /* renamed from: com.d.a.l$e */
    private class e extends DefaultHandler2 {
        private e() {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() {
            C1092l.this.m9272a();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) {
            C1092l.this.m9308a(str, str2, str3, attributes);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) {
            C1092l.this.m9321c(new String(cArr, i, i2));
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            C1092l.this.m9307a(str, str2, str3);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endDocument() {
            C1092l.this.m9316b();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) {
            C1092l.this.m9309a(str, (Map<String, String>) C1092l.this.m9270a(new h(str2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9272a() {
        this.f7298a = new C1088h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9308a(String str, String str2, String str3, Attributes attributes) {
        if (this.f7300c) {
            this.f7301d++;
        }
        if ("http://www.w3.org/2000/svg".equals(str) || "".equals(str)) {
            if (str2.length() <= 0) {
                str2 = str3;
            }
            g m9375a = g.m9375a(str2);
            switch (m9375a) {
                case svg:
                    m9311a(attributes);
                    break;
                case g:
                case a:
                    m9320b(attributes);
                    break;
                case defs:
                    m9322c(attributes);
                    break;
                case use:
                    m9324d(attributes);
                    break;
                case path:
                    m9328f(attributes);
                    break;
                case rect:
                    m9330g(attributes);
                    break;
                case circle:
                    m9332h(attributes);
                    break;
                case ellipse:
                    m9334i(attributes);
                    break;
                case line:
                    m9336j(attributes);
                    break;
                case polyline:
                    m9338k(attributes);
                    break;
                case polygon:
                    m9340l(attributes);
                    break;
                case text:
                    m9342m(attributes);
                    break;
                case tspan:
                    m9344n(attributes);
                    break;
                case tref:
                    m9346o(attributes);
                    break;
                case SWITCH:
                    m9348p(attributes);
                    break;
                case symbol:
                    m9350q(attributes);
                    break;
                case marker:
                    m9352r(attributes);
                    break;
                case linearGradient:
                    m9354s(attributes);
                    break;
                case radialGradient:
                    m9356t(attributes);
                    break;
                case stop:
                    m9358u(attributes);
                    break;
                case title:
                case desc:
                    this.f7302e = true;
                    this.f7303f = m9375a;
                    break;
                case clipPath:
                    m9362w(attributes);
                    break;
                case textPath:
                    m9363x(attributes);
                    break;
                case pattern:
                    m9366y(attributes);
                    break;
                case image:
                    m9326e(attributes);
                    break;
                case view:
                    m9368z(attributes);
                    break;
                case mask:
                    m9256A(attributes);
                    break;
                case style:
                    m9258B(attributes);
                    break;
                case solidColor:
                    m9360v(attributes);
                    break;
                default:
                    this.f7300c = true;
                    this.f7301d = 1;
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m9321c(String str) {
        if (!this.f7300c) {
            if (this.f7302e) {
                if (this.f7304g == null) {
                    this.f7304g = new StringBuilder(str.length());
                }
                this.f7304g.append(str);
            } else if (this.f7305h) {
                if (this.f7306i == null) {
                    this.f7306i = new StringBuilder(str.length());
                }
                this.f7306i.append(str);
            } else if (this.f7299b instanceof C1088h.ax) {
                m9323d(str);
            }
        }
    }

    /* renamed from: a */
    private void m9312a(char[] cArr, int i2, int i3) {
        if (!this.f7300c) {
            if (this.f7302e) {
                if (this.f7304g == null) {
                    this.f7304g = new StringBuilder(i3);
                }
                this.f7304g.append(cArr, i2, i3);
            } else if (this.f7305h) {
                if (this.f7306i == null) {
                    this.f7306i = new StringBuilder(i3);
                }
                this.f7306i.append(cArr, i2, i3);
            } else if (this.f7299b instanceof C1088h.ax) {
                m9323d(new String(cArr, i2, i3));
            }
        }
    }

    /* renamed from: d */
    private void m9323d(String str) {
        C1088h.ag agVar = (C1088h.ag) this.f7299b;
        int size = agVar.f7116i.size();
        C1088h.am amVar = size == 0 ? null : agVar.f7116i.get(size - 1);
        if (amVar instanceof C1088h.bb) {
            ((C1088h.bb) amVar).f7161a += str;
        } else {
            this.f7299b.mo9095a(new C1088h.bb(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9307a(String str, String str2, String str3) {
        if (this.f7300c) {
            int i2 = this.f7301d - 1;
            this.f7301d = i2;
            if (i2 == 0) {
                this.f7300c = false;
            }
        }
        if ("http://www.w3.org/2000/svg".equals(str) || "".equals(str)) {
            if (str2.length() <= 0) {
                str2 = str3;
            }
            switch (g.m9375a(str2)) {
                case svg:
                case g:
                case defs:
                case use:
                case text:
                case tspan:
                case SWITCH:
                case symbol:
                case marker:
                case linearGradient:
                case radialGradient:
                case stop:
                case clipPath:
                case textPath:
                case pattern:
                case image:
                case view:
                case mask:
                case solidColor:
                    this.f7299b = ((C1088h.am) this.f7299b).f7138v;
                    break;
                case title:
                case desc:
                    this.f7302e = false;
                    if (this.f7304g != null) {
                        if (this.f7303f == g.title) {
                            this.f7298a.m9085c(this.f7304g.toString());
                        } else if (this.f7303f == g.desc) {
                            this.f7298a.m9088d(this.f7304g.toString());
                        }
                        this.f7304g.setLength(0);
                        break;
                    }
                    break;
                case style:
                    if (this.f7306i != null) {
                        this.f7305h = false;
                        m9264H(this.f7306i.toString());
                        this.f7306i.setLength(0);
                        break;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m9316b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9309a(String str, Map<String, String> map) {
        String str2;
        String m9253b;
        if (str.equals("xml-stylesheet") && C1088h.m9074e() != null) {
            if (map.get("type") == null || "text/css".equals(map.get("type"))) {
                if ((map.get("alternate") == null || "no".equals(map.get("alternate"))) && (str2 = map.get("href")) != null && (m9253b = C1088h.m9074e().m9253b(str2)) != null) {
                    String str3 = map.get(MediaStore.AUTHORITY);
                    m9264H((str3 == null || "all".equals(str3.trim())) ? m9253b : "@media " + str3 + " { " + m9253b + "}");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Map<String, String> m9270a(h hVar) {
        HashMap hashMap = new HashMap();
        hVar.m9387g();
        String m9383b = hVar.m9383b('=');
        while (m9383b != null) {
            hVar.m9380a('=');
            hashMap.put(m9383b, hVar.m9401u());
            hVar.m9387g();
            m9383b = hVar.m9383b('=');
        }
        return hashMap;
    }

    /* renamed from: a */
    private void m9310a(String str, Object... objArr) {
    }

    /* renamed from: a */
    private void m9311a(Attributes attributes) {
        m9310a("<svg>", new Object[0]);
        C1088h.ae aeVar = new C1088h.ae();
        aeVar.f7137u = this.f7298a;
        aeVar.f7138v = this.f7299b;
        m9280a((C1088h.ak) aeVar, attributes);
        m9317b(aeVar, attributes);
        m9278a((C1088h.af) aeVar, attributes);
        m9284a((C1088h.aq) aeVar, attributes);
        m9277a(aeVar, attributes);
        if (this.f7299b == null) {
            this.f7298a.m9081a(aeVar);
        } else {
            this.f7299b.mo9095a(aeVar);
        }
        this.f7299b = aeVar;
    }

    /* renamed from: a */
    private void m9277a(C1088h.ae aeVar, Attributes attributes) {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.m9374a(attributes.getLocalName(i2))) {
                case x:
                    aeVar.f7111a = m9268a(trim);
                    break;
                case y:
                    aeVar.f7112b = m9268a(trim);
                    break;
                case width:
                    aeVar.f7113c = m9268a(trim);
                    if (aeVar.f7113c.m9122c()) {
                        throw new C1091k("Invalid <svg> element. width cannot be negative");
                    }
                    break;
                case height:
                    aeVar.f7114d = m9268a(trim);
                    if (aeVar.f7114d.m9122c()) {
                        throw new C1091k("Invalid <svg> element. height cannot be negative");
                    }
                    break;
                case version:
                    aeVar.f7115e = trim;
                    break;
            }
        }
    }

    /* renamed from: b */
    private void m9320b(Attributes attributes) {
        m9310a("<g>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        C1088h.l lVar = new C1088h.l();
        lVar.f7137u = this.f7298a;
        lVar.f7138v = this.f7299b;
        m9280a((C1088h.ak) lVar, attributes);
        m9317b(lVar, attributes);
        m9293a((C1088h.m) lVar, attributes);
        m9278a((C1088h.af) lVar, attributes);
        this.f7299b.mo9095a(lVar);
        this.f7299b = lVar;
    }

    /* renamed from: c */
    private void m9322c(Attributes attributes) {
        m9310a("<defs>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        C1088h.g gVar = new C1088h.g();
        gVar.f7137u = this.f7298a;
        gVar.f7138v = this.f7299b;
        m9280a((C1088h.ak) gVar, attributes);
        m9317b(gVar, attributes);
        m9293a((C1088h.m) gVar, attributes);
        this.f7299b.mo9095a(gVar);
        this.f7299b = gVar;
    }

    /* renamed from: d */
    private void m9324d(Attributes attributes) {
        m9310a("<use>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        C1088h.bd bdVar = new C1088h.bd();
        bdVar.f7137u = this.f7298a;
        bdVar.f7138v = this.f7299b;
        m9280a((C1088h.ak) bdVar, attributes);
        m9317b(bdVar, attributes);
        m9293a((C1088h.m) bdVar, attributes);
        m9278a((C1088h.af) bdVar, attributes);
        m9288a(bdVar, attributes);
        this.f7299b.mo9095a(bdVar);
        this.f7299b = bdVar;
    }

    /* renamed from: a */
    private void m9288a(C1088h.bd bdVar, Attributes attributes) {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.m9374a(attributes.getLocalName(i2))) {
                case x:
                    bdVar.f7174c = m9268a(trim);
                    break;
                case y:
                    bdVar.f7175d = m9268a(trim);
                    break;
                case width:
                    bdVar.f7176e = m9268a(trim);
                    if (bdVar.f7176e.m9122c()) {
                        throw new C1091k("Invalid <use> element. width cannot be negative");
                    }
                    break;
                case height:
                    bdVar.f7177f = m9268a(trim);
                    if (bdVar.f7177f.m9122c()) {
                        throw new C1091k("Invalid <use> element. height cannot be negative");
                    }
                    break;
                case href:
                    if (!"".equals(attributes.getURI(i2)) && !"http://www.w3.org/1999/xlink".equals(attributes.getURI(i2))) {
                        break;
                    } else {
                        bdVar.f7173a = trim;
                        break;
                    }
            }
        }
    }

    /* renamed from: e */
    private void m9326e(Attributes attributes) {
        m9310a("<image>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        C1088h.n nVar = new C1088h.n();
        nVar.f7137u = this.f7298a;
        nVar.f7138v = this.f7299b;
        m9280a((C1088h.ak) nVar, attributes);
        m9317b(nVar, attributes);
        m9293a((C1088h.m) nVar, attributes);
        m9278a((C1088h.af) nVar, attributes);
        m9294a(nVar, attributes);
        this.f7299b.mo9095a(nVar);
        this.f7299b = nVar;
    }

    /* renamed from: a */
    private void m9294a(C1088h.n nVar, Attributes attributes) {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.m9374a(attributes.getLocalName(i2))) {
                case x:
                    nVar.f7202b = m9268a(trim);
                    break;
                case y:
                    nVar.f7203c = m9268a(trim);
                    break;
                case width:
                    nVar.f7204d = m9268a(trim);
                    if (nVar.f7204d.m9122c()) {
                        throw new C1091k("Invalid <use> element. width cannot be negative");
                    }
                    break;
                case height:
                    nVar.f7205e = m9268a(trim);
                    if (nVar.f7205e.m9122c()) {
                        throw new C1091k("Invalid <use> element. height cannot be negative");
                    }
                    break;
                case href:
                    if (!"".equals(attributes.getURI(i2)) && !"http://www.w3.org/1999/xlink".equals(attributes.getURI(i2))) {
                        break;
                    } else {
                        nVar.f7201a = trim;
                        break;
                    }
                case preserveAspectRatio:
                    m9282a((C1088h.ao) nVar, trim);
                    break;
            }
        }
    }

    /* renamed from: f */
    private void m9328f(Attributes attributes) {
        m9310a("<path>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        C1088h.u uVar = new C1088h.u();
        uVar.f7137u = this.f7298a;
        uVar.f7138v = this.f7299b;
        m9280a((C1088h.ak) uVar, attributes);
        m9317b(uVar, attributes);
        m9293a((C1088h.m) uVar, attributes);
        m9278a((C1088h.af) uVar, attributes);
        m9298a(uVar, attributes);
        this.f7299b.mo9095a(uVar);
    }

    /* renamed from: a */
    private void m9298a(C1088h.u uVar, Attributes attributes) {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.m9374a(attributes.getLocalName(i2))) {
                case d:
                    uVar.f7227a = m9260D(trim);
                    break;
                case pathLength:
                    uVar.f7228b = Float.valueOf(m9331h(trim));
                    if (uVar.f7228b.floatValue() < 0.0f) {
                        throw new C1091k("Invalid <path> element. pathLength cannot be negative");
                    }
                    break;
            }
        }
    }

    /* renamed from: g */
    private void m9330g(Attributes attributes) {
        m9310a("<rect>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        C1088h.aa aaVar = new C1088h.aa();
        aaVar.f7137u = this.f7298a;
        aaVar.f7138v = this.f7299b;
        m9280a((C1088h.ak) aaVar, attributes);
        m9317b(aaVar, attributes);
        m9293a((C1088h.m) aaVar, attributes);
        m9278a((C1088h.af) aaVar, attributes);
        m9273a(aaVar, attributes);
        this.f7299b.mo9095a(aaVar);
    }

    /* renamed from: a */
    private void m9273a(C1088h.aa aaVar, Attributes attributes) {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.m9374a(attributes.getLocalName(i2))) {
                case x:
                    aaVar.f7030a = m9268a(trim);
                    break;
                case y:
                    aaVar.f7031b = m9268a(trim);
                    break;
                case width:
                    aaVar.f7032c = m9268a(trim);
                    if (aaVar.f7032c.m9122c()) {
                        throw new C1091k("Invalid <rect> element. width cannot be negative");
                    }
                    break;
                case height:
                    aaVar.f7033d = m9268a(trim);
                    if (aaVar.f7033d.m9122c()) {
                        throw new C1091k("Invalid <rect> element. height cannot be negative");
                    }
                    break;
                case rx:
                    aaVar.f7034f = m9268a(trim);
                    if (aaVar.f7034f.m9122c()) {
                        throw new C1091k("Invalid <rect> element. rx cannot be negative");
                    }
                    break;
                case ry:
                    aaVar.f7035g = m9268a(trim);
                    if (aaVar.f7035g.m9122c()) {
                        throw new C1091k("Invalid <rect> element. ry cannot be negative");
                    }
                    break;
            }
        }
    }

    /* renamed from: h */
    private void m9332h(Attributes attributes) {
        m9310a("<circle>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        C1088h.c cVar = new C1088h.c();
        cVar.f7137u = this.f7298a;
        cVar.f7138v = this.f7299b;
        m9280a((C1088h.ak) cVar, attributes);
        m9317b(cVar, attributes);
        m9293a((C1088h.m) cVar, attributes);
        m9278a((C1088h.af) cVar, attributes);
        m9289a(cVar, attributes);
        this.f7299b.mo9095a(cVar);
    }

    /* renamed from: a */
    private void m9289a(C1088h.c cVar, Attributes attributes) {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.m9374a(attributes.getLocalName(i2))) {
                case cx:
                    cVar.f7178a = m9268a(trim);
                    break;
                case cy:
                    cVar.f7179b = m9268a(trim);
                    break;
                case r:
                    cVar.f7180c = m9268a(trim);
                    if (cVar.f7180c.m9122c()) {
                        throw new C1091k("Invalid <circle> element. r cannot be negative");
                    }
                    break;
            }
        }
    }

    /* renamed from: i */
    private void m9334i(Attributes attributes) {
        m9310a("<ellipse>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        C1088h.h hVar = new C1088h.h();
        hVar.f7137u = this.f7298a;
        hVar.f7138v = this.f7299b;
        m9280a((C1088h.ak) hVar, attributes);
        m9317b(hVar, attributes);
        m9293a((C1088h.m) hVar, attributes);
        m9278a((C1088h.af) hVar, attributes);
        m9291a(hVar, attributes);
        this.f7299b.mo9095a(hVar);
    }

    /* renamed from: a */
    private void m9291a(C1088h.h hVar, Attributes attributes) {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.m9374a(attributes.getLocalName(i2))) {
                case rx:
                    hVar.f7188c = m9268a(trim);
                    if (hVar.f7188c.m9122c()) {
                        throw new C1091k("Invalid <ellipse> element. rx cannot be negative");
                    }
                    break;
                case ry:
                    hVar.f7189d = m9268a(trim);
                    if (hVar.f7189d.m9122c()) {
                        throw new C1091k("Invalid <ellipse> element. ry cannot be negative");
                    }
                    break;
                case cx:
                    hVar.f7186a = m9268a(trim);
                    break;
                case cy:
                    hVar.f7187b = m9268a(trim);
                    break;
            }
        }
    }

    /* renamed from: j */
    private void m9336j(Attributes attributes) {
        m9310a("<line>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        C1088h.p pVar = new C1088h.p();
        pVar.f7137u = this.f7298a;
        pVar.f7138v = this.f7299b;
        m9280a((C1088h.ak) pVar, attributes);
        m9317b(pVar, attributes);
        m9293a((C1088h.m) pVar, attributes);
        m9278a((C1088h.af) pVar, attributes);
        m9295a(pVar, attributes);
        this.f7299b.mo9095a(pVar);
    }

    /* renamed from: a */
    private void m9295a(C1088h.p pVar, Attributes attributes) {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.m9374a(attributes.getLocalName(i2))) {
                case x1:
                    pVar.f7209a = m9268a(trim);
                    break;
                case y1:
                    pVar.f7210b = m9268a(trim);
                    break;
                case x2:
                    pVar.f7211c = m9268a(trim);
                    break;
                case y2:
                    pVar.f7212d = m9268a(trim);
                    break;
            }
        }
    }

    /* renamed from: k */
    private void m9338k(Attributes attributes) {
        m9310a("<polyline>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        C1088h.y yVar = new C1088h.y();
        yVar.f7137u = this.f7298a;
        yVar.f7138v = this.f7299b;
        m9280a((C1088h.ak) yVar, attributes);
        m9317b(yVar, attributes);
        m9293a((C1088h.m) yVar, attributes);
        m9278a((C1088h.af) yVar, attributes);
        m9300a(yVar, attributes, "polyline");
        this.f7299b.mo9095a(yVar);
    }

    /* renamed from: a */
    private void m9300a(C1088h.y yVar, Attributes attributes, String str) {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            if (f.m9374a(attributes.getLocalName(i2)) == f.points) {
                h hVar = new h(attributes.getValue(i2));
                ArrayList arrayList = new ArrayList();
                hVar.m9387g();
                while (!hVar.m9386f()) {
                    float m9389i = hVar.m9389i();
                    if (Float.isNaN(m9389i)) {
                        throw new C1091k("Invalid <" + str + "> points attribute. Non-coordinate content found in list.");
                    }
                    hVar.m9388h();
                    float m9389i2 = hVar.m9389i();
                    if (Float.isNaN(m9389i2)) {
                        throw new C1091k("Invalid <" + str + "> points attribute. There should be an even number of coordinates.");
                    }
                    hVar.m9388h();
                    arrayList.add(Float.valueOf(m9389i));
                    arrayList.add(Float.valueOf(m9389i2));
                }
                yVar.f7241a = new float[arrayList.size()];
                Iterator<E> it = arrayList.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    yVar.f7241a[i3] = ((Float) it.next()).floatValue();
                    i3++;
                }
            }
        }
    }

    /* renamed from: l */
    private void m9340l(Attributes attributes) {
        m9310a("<polygon>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        C1088h.z zVar = new C1088h.z();
        zVar.f7137u = this.f7298a;
        zVar.f7138v = this.f7299b;
        m9280a((C1088h.ak) zVar, attributes);
        m9317b(zVar, attributes);
        m9293a((C1088h.m) zVar, attributes);
        m9278a((C1088h.af) zVar, attributes);
        m9300a(zVar, attributes, "polygon");
        this.f7299b.mo9095a(zVar);
    }

    /* renamed from: m */
    private void m9342m(Attributes attributes) {
        m9310a("<text>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        C1088h.av avVar = new C1088h.av();
        avVar.f7137u = this.f7298a;
        avVar.f7138v = this.f7299b;
        m9280a((C1088h.ak) avVar, attributes);
        m9317b(avVar, attributes);
        m9293a((C1088h.m) avVar, attributes);
        m9278a((C1088h.af) avVar, attributes);
        m9287a((C1088h.az) avVar, attributes);
        this.f7299b.mo9095a(avVar);
        this.f7299b = avVar;
    }

    /* renamed from: a */
    private void m9287a(C1088h.az azVar, Attributes attributes) {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.m9374a(attributes.getLocalName(i2))) {
                case x:
                    azVar.f7153b = m9329g(trim);
                    break;
                case y:
                    azVar.f7154c = m9329g(trim);
                    break;
                case dx:
                    azVar.f7155d = m9329g(trim);
                    break;
                case dy:
                    azVar.f7156e = m9329g(trim);
                    break;
            }
        }
    }

    /* renamed from: n */
    private void m9344n(Attributes attributes) {
        m9310a("<tspan>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        if (!(this.f7299b instanceof C1088h.ax)) {
            throw new C1091k("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
        }
        C1088h.au auVar = new C1088h.au();
        auVar.f7137u = this.f7298a;
        auVar.f7138v = this.f7299b;
        m9280a((C1088h.ak) auVar, attributes);
        m9317b(auVar, attributes);
        m9278a((C1088h.af) auVar, attributes);
        m9287a((C1088h.az) auVar, attributes);
        this.f7299b.mo9095a(auVar);
        this.f7299b = auVar;
        if (auVar.f7138v instanceof C1088h.ba) {
            auVar.m9111a((C1088h.ba) auVar.f7138v);
        } else {
            auVar.m9111a(((C1088h.aw) auVar.f7138v).mo9110h());
        }
    }

    /* renamed from: o */
    private void m9346o(Attributes attributes) {
        m9310a("<tref>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        if (!(this.f7299b instanceof C1088h.ax)) {
            throw new C1091k("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
        }
        C1088h.at atVar = new C1088h.at();
        atVar.f7137u = this.f7298a;
        atVar.f7138v = this.f7299b;
        m9280a((C1088h.ak) atVar, attributes);
        m9317b(atVar, attributes);
        m9278a((C1088h.af) atVar, attributes);
        m9285a(atVar, attributes);
        this.f7299b.mo9095a(atVar);
        if (atVar.f7138v instanceof C1088h.ba) {
            atVar.m9109a((C1088h.ba) atVar.f7138v);
        } else {
            atVar.m9109a(((C1088h.aw) atVar.f7138v).mo9110h());
        }
    }

    /* renamed from: a */
    private void m9285a(C1088h.at atVar, Attributes attributes) {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.m9374a(attributes.getLocalName(i2))) {
                case href:
                    if (!"".equals(attributes.getURI(i2)) && !"http://www.w3.org/1999/xlink".equals(attributes.getURI(i2))) {
                        break;
                    } else {
                        atVar.f7146a = trim;
                        break;
                    }
            }
        }
    }

    /* renamed from: p */
    private void m9348p(Attributes attributes) {
        m9310a("<switch>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        C1088h.ar arVar = new C1088h.ar();
        arVar.f7137u = this.f7298a;
        arVar.f7138v = this.f7299b;
        m9280a((C1088h.ak) arVar, attributes);
        m9317b(arVar, attributes);
        m9293a((C1088h.m) arVar, attributes);
        m9278a((C1088h.af) arVar, attributes);
        this.f7299b.mo9095a(arVar);
        this.f7299b = arVar;
    }

    /* renamed from: a */
    private void m9278a(C1088h.af afVar, Attributes attributes) {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.m9374a(attributes.getLocalName(i2))) {
                case requiredFeatures:
                    afVar.mo9100a(m9261E(trim));
                    break;
                case requiredExtensions:
                    afVar.mo9099a(trim);
                    break;
                case systemLanguage:
                    afVar.mo9101b(m9262F(trim));
                    break;
                case requiredFormats:
                    afVar.mo9103c(m9263G(trim));
                    break;
                case requiredFonts:
                    List<String> m9345o = m9345o(trim);
                    afVar.mo9105d(m9345o != null ? new HashSet(m9345o) : new HashSet(0));
                    break;
            }
        }
    }

    /* renamed from: q */
    private void m9350q(Attributes attributes) {
        m9310a("<symbol>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        C1088h.as asVar = new C1088h.as();
        asVar.f7137u = this.f7298a;
        asVar.f7138v = this.f7299b;
        m9280a((C1088h.ak) asVar, attributes);
        m9317b(asVar, attributes);
        m9278a((C1088h.af) asVar, attributes);
        m9284a((C1088h.aq) asVar, attributes);
        this.f7299b.mo9095a(asVar);
        this.f7299b = asVar;
    }

    /* renamed from: r */
    private void m9352r(Attributes attributes) {
        m9310a("<marker>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        C1088h.q qVar = new C1088h.q();
        qVar.f7137u = this.f7298a;
        qVar.f7138v = this.f7299b;
        m9280a((C1088h.ak) qVar, attributes);
        m9317b(qVar, attributes);
        m9278a((C1088h.af) qVar, attributes);
        m9284a((C1088h.aq) qVar, attributes);
        m9296a(qVar, attributes);
        this.f7299b.mo9095a(qVar);
        this.f7299b = qVar;
    }

    /* renamed from: a */
    private void m9296a(C1088h.q qVar, Attributes attributes) {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.m9374a(attributes.getLocalName(i2))) {
                case refX:
                    qVar.f7214b = m9268a(trim);
                    break;
                case refY:
                    qVar.f7215c = m9268a(trim);
                    break;
                case markerWidth:
                    qVar.f7216d = m9268a(trim);
                    if (qVar.f7216d.m9122c()) {
                        throw new C1091k("Invalid <marker> element. markerWidth cannot be negative");
                    }
                    break;
                case markerHeight:
                    qVar.f7217e = m9268a(trim);
                    if (qVar.f7217e.m9122c()) {
                        throw new C1091k("Invalid <marker> element. markerHeight cannot be negative");
                    }
                    break;
                case markerUnits:
                    if ("strokeWidth".equals(trim)) {
                        qVar.f7213a = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        qVar.f7213a = true;
                        break;
                    } else {
                        throw new C1091k("Invalid value for attribute markerUnits");
                    }
                case orient:
                    if ("auto".equals(trim)) {
                        qVar.f7218f = Float.valueOf(Float.NaN);
                        break;
                    } else {
                        qVar.f7218f = Float.valueOf(m9331h(trim));
                        break;
                    }
            }
        }
    }

    /* renamed from: s */
    private void m9354s(Attributes attributes) {
        m9310a("<linearGradient>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        C1088h.al alVar = new C1088h.al();
        alVar.f7137u = this.f7298a;
        alVar.f7138v = this.f7299b;
        m9280a((C1088h.ak) alVar, attributes);
        m9317b(alVar, attributes);
        m9292a((C1088h.i) alVar, attributes);
        m9281a(alVar, attributes);
        this.f7299b.mo9095a(alVar);
        this.f7299b = alVar;
    }

    /* renamed from: a */
    private void m9292a(C1088h.i iVar, Attributes attributes) {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.m9374a(attributes.getLocalName(i2))) {
                case href:
                    if (!"".equals(attributes.getURI(i2)) && !"http://www.w3.org/1999/xlink".equals(attributes.getURI(i2))) {
                        break;
                    } else {
                        iVar.f7194e = trim;
                        break;
                    }
                case gradientUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        iVar.f7191b = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        iVar.f7191b = true;
                        break;
                    } else {
                        throw new C1091k("Invalid value for attribute gradientUnits");
                    }
                case gradientTransform:
                    iVar.f7192c = m9327f(trim);
                    break;
                case spreadMethod:
                    try {
                        iVar.f7193d = C1088h.j.valueOf(trim);
                        break;
                    } catch (IllegalArgumentException e2) {
                        throw new C1091k("Invalid spreadMethod attribute. \"" + trim + "\" is not a valid value.");
                    }
            }
        }
    }

    /* renamed from: a */
    private void m9281a(C1088h.al alVar, Attributes attributes) {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.m9374a(attributes.getLocalName(i2))) {
                case x1:
                    alVar.f7133f = m9268a(trim);
                    break;
                case y1:
                    alVar.f7134g = m9268a(trim);
                    break;
                case x2:
                    alVar.f7135h = m9268a(trim);
                    break;
                case y2:
                    alVar.f7136i = m9268a(trim);
                    break;
            }
        }
    }

    /* renamed from: t */
    private void m9356t(Attributes attributes) {
        m9310a("<radialGradient>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        C1088h.ap apVar = new C1088h.ap();
        apVar.f7137u = this.f7298a;
        apVar.f7138v = this.f7299b;
        m9280a((C1088h.ak) apVar, attributes);
        m9317b(apVar, attributes);
        m9292a((C1088h.i) apVar, attributes);
        m9283a(apVar, attributes);
        this.f7299b.mo9095a(apVar);
        this.f7299b = apVar;
    }

    /* renamed from: a */
    private void m9283a(C1088h.ap apVar, Attributes attributes) {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.m9374a(attributes.getLocalName(i2))) {
                case cx:
                    apVar.f7140f = m9268a(trim);
                    break;
                case cy:
                    apVar.f7141g = m9268a(trim);
                    break;
                case r:
                    apVar.f7142h = m9268a(trim);
                    if (apVar.f7142h.m9122c()) {
                        throw new C1091k("Invalid <radialGradient> element. r cannot be negative");
                    }
                    break;
                case fx:
                    apVar.f7143i = m9268a(trim);
                    break;
                case fy:
                    apVar.f7144j = m9268a(trim);
                    break;
            }
        }
    }

    /* renamed from: u */
    private void m9358u(Attributes attributes) {
        m9310a("<stop>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        if (!(this.f7299b instanceof C1088h.i)) {
            throw new C1091k("Invalid document. <stop> elements are only valid inside <linearGradient> or <radialGradient> elements.");
        }
        C1088h.ac acVar = new C1088h.ac();
        acVar.f7137u = this.f7298a;
        acVar.f7138v = this.f7299b;
        m9280a((C1088h.ak) acVar, attributes);
        m9317b(acVar, attributes);
        m9274a(acVar, attributes);
        this.f7299b.mo9095a(acVar);
        this.f7299b = acVar;
    }

    /* renamed from: a */
    private void m9274a(C1088h.ac acVar, Attributes attributes) {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.m9374a(attributes.getLocalName(i2))) {
                case offset:
                    acVar.f7036a = m9325e(trim);
                    break;
            }
        }
    }

    /* renamed from: e */
    private Float m9325e(String str) {
        boolean z;
        if (str.length() == 0) {
            throw new C1091k("Invalid offset value in <stop> (empty string)");
        }
        int length = str.length();
        if (str.charAt(str.length() - 1) == '%') {
            length--;
            z = true;
        } else {
            z = false;
        }
        try {
            float m9265a = m9265a(str, 0, length);
            if (z) {
                m9265a /= 100.0f;
            }
            return Float.valueOf(m9265a >= 0.0f ? m9265a > 100.0f ? 100.0f : m9265a : 0.0f);
        } catch (NumberFormatException e2) {
            throw new C1091k("Invalid offset value in <stop>: " + str, e2);
        }
    }

    /* renamed from: v */
    private void m9360v(Attributes attributes) {
        m9310a("<solidColor>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        C1088h.ab abVar = new C1088h.ab();
        abVar.f7137u = this.f7298a;
        abVar.f7138v = this.f7299b;
        m9280a(abVar, attributes);
        m9317b(abVar, attributes);
        this.f7299b.mo9095a(abVar);
        this.f7299b = abVar;
    }

    /* renamed from: w */
    private void m9362w(Attributes attributes) {
        m9310a("<clipPath>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        C1088h.d dVar = new C1088h.d();
        dVar.f7137u = this.f7298a;
        dVar.f7138v = this.f7299b;
        m9280a((C1088h.ak) dVar, attributes);
        m9317b(dVar, attributes);
        m9293a((C1088h.m) dVar, attributes);
        m9278a((C1088h.af) dVar, attributes);
        m9290a(dVar, attributes);
        this.f7299b.mo9095a(dVar);
        this.f7299b = dVar;
    }

    /* renamed from: a */
    private void m9290a(C1088h.d dVar, Attributes attributes) {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.m9374a(attributes.getLocalName(i2))) {
                case clipPathUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        dVar.f7181a = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        dVar.f7181a = true;
                        break;
                    } else {
                        throw new C1091k("Invalid value for attribute clipPathUnits");
                    }
            }
        }
    }

    /* renamed from: x */
    private void m9363x(Attributes attributes) {
        m9310a("<textPath>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        C1088h.ay ayVar = new C1088h.ay();
        ayVar.f7137u = this.f7298a;
        ayVar.f7138v = this.f7299b;
        m9280a((C1088h.ak) ayVar, attributes);
        m9317b(ayVar, attributes);
        m9278a((C1088h.af) ayVar, attributes);
        m9286a(ayVar, attributes);
        this.f7299b.mo9095a(ayVar);
        this.f7299b = ayVar;
        if (ayVar.f7138v instanceof C1088h.ba) {
            ayVar.m9113a((C1088h.ba) ayVar.f7138v);
        } else {
            ayVar.m9113a(((C1088h.aw) ayVar.f7138v).mo9110h());
        }
    }

    /* renamed from: a */
    private void m9286a(C1088h.ay ayVar, Attributes attributes) {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.m9374a(attributes.getLocalName(i2))) {
                case href:
                    if (!"".equals(attributes.getURI(i2)) && !"http://www.w3.org/1999/xlink".equals(attributes.getURI(i2))) {
                        break;
                    } else {
                        ayVar.f7150a = trim;
                        break;
                    }
                case startOffset:
                    ayVar.f7151b = m9268a(trim);
                    break;
            }
        }
    }

    /* renamed from: y */
    private void m9366y(Attributes attributes) {
        m9310a("<pattern>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        C1088h.x xVar = new C1088h.x();
        xVar.f7137u = this.f7298a;
        xVar.f7138v = this.f7299b;
        m9280a((C1088h.ak) xVar, attributes);
        m9317b(xVar, attributes);
        m9278a((C1088h.af) xVar, attributes);
        m9284a((C1088h.aq) xVar, attributes);
        m9299a(xVar, attributes);
        this.f7299b.mo9095a(xVar);
        this.f7299b = xVar;
    }

    /* renamed from: a */
    private void m9299a(C1088h.x xVar, Attributes attributes) {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.m9374a(attributes.getLocalName(i2))) {
                case x:
                    xVar.f7236d = m9268a(trim);
                    break;
                case y:
                    xVar.f7237e = m9268a(trim);
                    break;
                case width:
                    xVar.f7238f = m9268a(trim);
                    if (xVar.f7238f.m9122c()) {
                        throw new C1091k("Invalid <pattern> element. width cannot be negative");
                    }
                    break;
                case height:
                    xVar.f7239g = m9268a(trim);
                    if (xVar.f7239g.m9122c()) {
                        throw new C1091k("Invalid <pattern> element. height cannot be negative");
                    }
                    break;
                case href:
                    if (!"".equals(attributes.getURI(i2)) && !"http://www.w3.org/1999/xlink".equals(attributes.getURI(i2))) {
                        break;
                    } else {
                        xVar.f7240h = trim;
                        break;
                    }
                case patternUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        xVar.f7233a = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        xVar.f7233a = true;
                        break;
                    } else {
                        throw new C1091k("Invalid value for attribute patternUnits");
                    }
                case patternContentUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        xVar.f7234b = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        xVar.f7234b = true;
                        break;
                    } else {
                        throw new C1091k("Invalid value for attribute patternContentUnits");
                    }
                case patternTransform:
                    xVar.f7235c = m9327f(trim);
                    break;
            }
        }
    }

    /* renamed from: z */
    private void m9368z(Attributes attributes) {
        m9310a("<view>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        C1088h.be beVar = new C1088h.be();
        beVar.f7137u = this.f7298a;
        beVar.f7138v = this.f7299b;
        m9280a((C1088h.ak) beVar, attributes);
        m9278a((C1088h.af) beVar, attributes);
        m9284a((C1088h.aq) beVar, attributes);
        this.f7299b.mo9095a(beVar);
        this.f7299b = beVar;
    }

    /* renamed from: A */
    private void m9256A(Attributes attributes) {
        m9310a("<mask>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        C1088h.r rVar = new C1088h.r();
        rVar.f7137u = this.f7298a;
        rVar.f7138v = this.f7299b;
        m9280a((C1088h.ak) rVar, attributes);
        m9317b(rVar, attributes);
        m9278a((C1088h.af) rVar, attributes);
        m9297a(rVar, attributes);
        this.f7299b.mo9095a(rVar);
        this.f7299b = rVar;
    }

    /* renamed from: a */
    private void m9297a(C1088h.r rVar, Attributes attributes) {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.m9374a(attributes.getLocalName(i2))) {
                case x:
                    rVar.f7221c = m9268a(trim);
                    break;
                case y:
                    rVar.f7222d = m9268a(trim);
                    break;
                case width:
                    rVar.f7223e = m9268a(trim);
                    if (rVar.f7223e.m9122c()) {
                        throw new C1091k("Invalid <mask> element. width cannot be negative");
                    }
                    break;
                case height:
                    rVar.f7224f = m9268a(trim);
                    if (rVar.f7224f.m9122c()) {
                        throw new C1091k("Invalid <mask> element. height cannot be negative");
                    }
                    break;
                case maskUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        rVar.f7219a = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        rVar.f7219a = true;
                        break;
                    } else {
                        throw new C1091k("Invalid value for attribute maskUnits");
                    }
                case maskContentUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        rVar.f7220b = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        rVar.f7220b = true;
                        break;
                    } else {
                        throw new C1091k("Invalid value for attribute maskContentUnits");
                    }
            }
        }
    }

    /* compiled from: SVGParser.java */
    /* renamed from: com.d.a.l$h */
    static class h {

        /* renamed from: a */
        String f7442a;

        /* renamed from: c */
        int f7444c;

        /* renamed from: b */
        int f7443b = 0;

        /* renamed from: d */
        private C1085e f7445d = new C1085e();

        h(String str) {
            this.f7444c = 0;
            this.f7442a = str.trim();
            this.f7444c = this.f7442a.length();
        }

        /* renamed from: f */
        boolean m9386f() {
            return this.f7443b == this.f7444c;
        }

        /* renamed from: a */
        boolean m9381a(int i) {
            return i == 32 || i == 10 || i == 13 || i == 9;
        }

        /* renamed from: g */
        void m9387g() {
            while (this.f7443b < this.f7444c && m9381a((int) this.f7442a.charAt(this.f7443b))) {
                this.f7443b++;
            }
        }

        /* renamed from: b */
        boolean m9384b(int i) {
            return i == 10 || i == 13;
        }

        /* renamed from: h */
        boolean m9388h() {
            m9387g();
            if (this.f7443b == this.f7444c || this.f7442a.charAt(this.f7443b) != ',') {
                return false;
            }
            this.f7443b++;
            m9387g();
            return true;
        }

        /* renamed from: i */
        float m9389i() {
            float m9061a = this.f7445d.m9061a(this.f7442a, this.f7443b, this.f7444c);
            if (!Float.isNaN(m9061a)) {
                this.f7443b = this.f7445d.m9062a();
            }
            return m9061a;
        }

        /* renamed from: j */
        float m9390j() {
            m9388h();
            float m9061a = this.f7445d.m9061a(this.f7442a, this.f7443b, this.f7444c);
            if (!Float.isNaN(m9061a)) {
                this.f7443b = this.f7445d.m9062a();
            }
            return m9061a;
        }

        /* renamed from: a */
        float m9376a(float f2) {
            if (Float.isNaN(f2)) {
                return Float.NaN;
            }
            m9388h();
            return m9389i();
        }

        /* renamed from: a */
        float m9377a(Boolean bool) {
            if (bool == null) {
                return Float.NaN;
            }
            m9388h();
            return m9389i();
        }

        /* renamed from: k */
        Integer m9391k() {
            if (this.f7443b == this.f7444c) {
                return null;
            }
            String str = this.f7442a;
            int i = this.f7443b;
            this.f7443b = i + 1;
            return Integer.valueOf(str.charAt(i));
        }

        /* renamed from: l */
        C1088h.o m9392l() {
            float m9389i = m9389i();
            if (Float.isNaN(m9389i)) {
                return null;
            }
            C1088h.bc m9399s = m9399s();
            if (m9399s == null) {
                return new C1088h.o(m9389i, C1088h.bc.px);
            }
            return new C1088h.o(m9389i, m9399s);
        }

        /* renamed from: m */
        Boolean m9393m() {
            if (this.f7443b == this.f7444c) {
                return null;
            }
            char charAt = this.f7442a.charAt(this.f7443b);
            if (charAt != '0' && charAt != '1') {
                return null;
            }
            this.f7443b++;
            return Boolean.valueOf(charAt == '1');
        }

        /* renamed from: a */
        Boolean m9378a(Object obj) {
            if (obj == null) {
                return null;
            }
            m9388h();
            return m9393m();
        }

        /* renamed from: a */
        boolean m9380a(char c2) {
            boolean z = this.f7443b < this.f7444c && this.f7442a.charAt(this.f7443b) == c2;
            if (z) {
                this.f7443b++;
            }
            return z;
        }

        /* renamed from: a */
        boolean m9382a(String str) {
            int length = str.length();
            boolean z = this.f7443b <= this.f7444c - length && this.f7442a.substring(this.f7443b, this.f7443b + length).equals(str);
            if (z) {
                this.f7443b = length + this.f7443b;
            }
            return z;
        }

        /* renamed from: n */
        int m9394n() {
            if (this.f7443b == this.f7444c) {
                return -1;
            }
            this.f7443b++;
            if (this.f7443b < this.f7444c) {
                return this.f7442a.charAt(this.f7443b);
            }
            return -1;
        }

        /* renamed from: o */
        String m9395o() {
            return m9379a(' ', false);
        }

        /* renamed from: b */
        String m9383b(char c2) {
            return m9379a(c2, false);
        }

        /* renamed from: c */
        String m9385c(char c2) {
            return m9379a(c2, true);
        }

        /* renamed from: a */
        String m9379a(char c2, boolean z) {
            if (m9386f()) {
                return null;
            }
            char charAt = this.f7442a.charAt(this.f7443b);
            if ((!z && m9381a((int) charAt)) || charAt == c2) {
                return null;
            }
            int i = this.f7443b;
            int m9394n = m9394n();
            while (m9394n != -1 && m9394n != c2 && (z || !m9381a(m9394n))) {
                m9394n = m9394n();
            }
            return this.f7442a.substring(i, this.f7443b);
        }

        /* renamed from: p */
        String m9396p() {
            if (m9386f()) {
                return null;
            }
            int i = this.f7443b;
            char charAt = this.f7442a.charAt(this.f7443b);
            if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
                int m9394n = m9394n();
                while (true) {
                    if ((m9394n < 65 || m9394n > 90) && (m9394n < 97 || m9394n > 122)) {
                        break;
                    }
                    m9394n = m9394n();
                }
                return this.f7442a.substring(i, this.f7443b);
            }
            this.f7443b = i;
            return null;
        }

        /* renamed from: q */
        String m9397q() {
            if (m9386f()) {
                return null;
            }
            int i = this.f7443b;
            int charAt = this.f7442a.charAt(this.f7443b);
            while (true) {
                if ((charAt < 97 || charAt > 122) && (charAt < 65 || charAt > 90)) {
                    break;
                }
                charAt = m9394n();
            }
            int i2 = this.f7443b;
            while (m9381a(charAt)) {
                charAt = m9394n();
            }
            if (charAt == 40) {
                this.f7443b++;
                return this.f7442a.substring(i, i2);
            }
            this.f7443b = i;
            return null;
        }

        /* renamed from: r */
        String m9398r() {
            int i = this.f7443b;
            while (!m9386f() && !m9381a((int) this.f7442a.charAt(this.f7443b))) {
                this.f7443b++;
            }
            String substring = this.f7442a.substring(i, this.f7443b);
            this.f7443b = i;
            return substring;
        }

        /* renamed from: s */
        C1088h.bc m9399s() {
            if (m9386f()) {
                return null;
            }
            if (this.f7442a.charAt(this.f7443b) == '%') {
                this.f7443b++;
                return C1088h.bc.percent;
            }
            if (this.f7443b > this.f7444c - 2) {
                return null;
            }
            try {
                C1088h.bc valueOf = C1088h.bc.valueOf(this.f7442a.substring(this.f7443b, this.f7443b + 2).toLowerCase(Locale.f10688US));
                this.f7443b += 2;
                return valueOf;
            } catch (IllegalArgumentException e2) {
                return null;
            }
        }

        /* renamed from: t */
        boolean m9400t() {
            if (this.f7443b == this.f7444c) {
                return false;
            }
            char charAt = this.f7442a.charAt(this.f7443b);
            return (charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z');
        }

        /* renamed from: u */
        String m9401u() {
            if (m9386f()) {
                return null;
            }
            int i = this.f7443b;
            char charAt = this.f7442a.charAt(this.f7443b);
            if (charAt != '\'' && charAt != '\"') {
                return null;
            }
            int m9394n = m9394n();
            while (m9394n != -1 && m9394n != charAt) {
                m9394n = m9394n();
            }
            if (m9394n == -1) {
                this.f7443b = i;
                return null;
            }
            this.f7443b++;
            return this.f7442a.substring(i + 1, this.f7443b - 1);
        }

        /* renamed from: v */
        String m9402v() {
            if (m9386f()) {
                return null;
            }
            int i = this.f7443b;
            this.f7443b = this.f7444c;
            return this.f7442a.substring(i);
        }
    }

    /* renamed from: a */
    private void m9280a(C1088h.ak akVar, Attributes attributes) {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String qName = attributes.getQName(i2);
            if (qName.equals("id") || qName.equals("xml:id")) {
                akVar.f7128p = attributes.getValue(i2).trim();
                return;
            }
            if (qName.equals("xml:space")) {
                String trim = attributes.getValue(i2).trim();
                if ("default".equals(trim)) {
                    akVar.f7129q = Boolean.FALSE;
                    return;
                } else {
                    if ("preserve".equals(trim)) {
                        akVar.f7129q = Boolean.TRUE;
                        return;
                    }
                    throw new C1091k("Invalid value for \"xml:space\" attribute: " + trim);
                }
            }
        }
    }

    /* renamed from: b */
    private void m9317b(C1088h.ak akVar, Attributes attributes) {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            if (trim.length() != 0) {
                switch (f.m9374a(attributes.getLocalName(i2))) {
                    case style:
                        m9279a(akVar, trim);
                        break;
                    case CLASS:
                        akVar.f7132t = C1082b.m9015b(trim);
                        break;
                    default:
                        if (akVar.f7130r == null) {
                            akVar.f7130r = new C1088h.ad();
                        }
                        m9276a(akVar.f7130r, attributes.getLocalName(i2), attributes.getValue(i2).trim());
                        break;
                }
            }
        }
    }

    /* renamed from: a */
    private static void m9279a(C1088h.ak akVar, String str) {
        h hVar = new h(str.replaceAll("/\\*.*?\\*/", ""));
        while (true) {
            String m9383b = hVar.m9383b(':');
            hVar.m9387g();
            if (hVar.m9380a(':')) {
                hVar.m9387g();
                String m9385c = hVar.m9385c(';');
                if (m9385c != null) {
                    hVar.m9387g();
                    if (hVar.m9386f() || hVar.m9380a(';')) {
                        if (akVar.f7131s == null) {
                            akVar.f7131s = new C1088h.ad();
                        }
                        m9276a(akVar.f7131s, m9383b, m9385c);
                        hVar.m9387g();
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    static void m9276a(C1088h.ad adVar, String str, String str2) {
        if (str2.length() != 0 && !str2.equals("inherit")) {
            switch (f.m9374a(str)) {
                case fill:
                    adVar.f7051b = m9337k(str2);
                    if (adVar.f7051b != null) {
                        adVar.f7050a |= 1;
                        break;
                    }
                    break;
                case fill_rule:
                    adVar.f7052c = m9357u(str2);
                    if (adVar.f7052c != null) {
                        adVar.f7050a |= 2;
                        break;
                    }
                    break;
                case fill_opacity:
                    adVar.f7053d = m9333i(str2);
                    if (adVar.f7053d != null) {
                        adVar.f7050a |= 4;
                        break;
                    }
                    break;
                case stroke:
                    adVar.f7054e = m9337k(str2);
                    if (adVar.f7054e != null) {
                        adVar.f7050a |= 8;
                        break;
                    }
                    break;
                case stroke_opacity:
                    adVar.f7055f = m9333i(str2);
                    if (adVar.f7055f != null) {
                        adVar.f7050a |= 16;
                        break;
                    }
                    break;
                case stroke_width:
                    try {
                        adVar.f7056g = m9268a(str2);
                        adVar.f7050a |= 32;
                        break;
                    } catch (C1091k e2) {
                        return;
                    }
                case stroke_linecap:
                    adVar.f7057h = m9359v(str2);
                    if (adVar.f7057h != null) {
                        adVar.f7050a |= 64;
                        break;
                    }
                    break;
                case stroke_linejoin:
                    adVar.f7058i = m9361w(str2);
                    if (adVar.f7058i != null) {
                        adVar.f7050a |= 128;
                        break;
                    }
                    break;
                case stroke_miterlimit:
                    try {
                        adVar.f7059j = Float.valueOf(m9331h(str2));
                        adVar.f7050a |= 256;
                        break;
                    } catch (C1091k e3) {
                        return;
                    }
                case stroke_dasharray:
                    if (Camera.Parameters.EFFECT_NONE.equals(str2)) {
                        adVar.f7060k = null;
                        adVar.f7050a |= 512;
                        break;
                    } else {
                        adVar.f7060k = m9364x(str2);
                        if (adVar.f7060k != null) {
                            adVar.f7050a |= 512;
                            break;
                        }
                    }
                    break;
                case stroke_dashoffset:
                    try {
                        adVar.f7061l = m9268a(str2);
                        adVar.f7050a |= PlaybackState.ACTION_PLAY_FROM_MEDIA_ID;
                        break;
                    } catch (C1091k e4) {
                        return;
                    }
                case opacity:
                    adVar.f7062m = m9333i(str2);
                    adVar.f7050a |= PlaybackState.ACTION_PLAY_FROM_SEARCH;
                    break;
                case color:
                    try {
                        adVar.f7063n = m9341m(str2);
                        adVar.f7050a |= PlaybackState.ACTION_SKIP_TO_QUEUE_ITEM;
                        break;
                    } catch (C1091k e5) {
                        return;
                    }
                case font:
                    m9275a(adVar, str2);
                    break;
                case font_family:
                    adVar.f7064o = m9345o(str2);
                    if (adVar.f7064o != null) {
                        adVar.f7050a |= PlaybackState.ACTION_PLAY_FROM_URI;
                        break;
                    }
                    break;
                case font_size:
                    adVar.f7065p = m9347p(str2);
                    if (adVar.f7065p != null) {
                        adVar.f7050a |= 16384;
                        break;
                    }
                    break;
                case font_weight:
                    adVar.f7066q = m9349q(str2);
                    if (adVar.f7066q != null) {
                        adVar.f7050a |= PlaybackState.ACTION_PREPARE_FROM_MEDIA_ID;
                        break;
                    }
                    break;
                case font_style:
                    adVar.f7067r = m9351r(str2);
                    if (adVar.f7067r != null) {
                        adVar.f7050a |= 65536;
                        break;
                    }
                    break;
                case text_decoration:
                    adVar.f7068s = m9353s(str2);
                    if (adVar.f7068s != null) {
                        adVar.f7050a |= PlaybackState.ACTION_PREPARE_FROM_URI;
                        break;
                    }
                    break;
                case direction:
                    adVar.f7069t = m9355t(str2);
                    if (adVar.f7069t != null) {
                        adVar.f7050a |= 68719476736L;
                        break;
                    }
                    break;
                case text_anchor:
                    adVar.f7070u = m9365y(str2);
                    if (adVar.f7070u != null) {
                        adVar.f7050a |= 262144;
                        break;
                    }
                    break;
                case overflow:
                    adVar.f7071v = m9367z(str2);
                    if (adVar.f7071v != null) {
                        adVar.f7050a |= 524288;
                        break;
                    }
                    break;
                case marker:
                    adVar.f7073x = m9269a(str2, str);
                    adVar.f7074y = adVar.f7073x;
                    adVar.f7075z = adVar.f7073x;
                    adVar.f7050a |= 14680064;
                    break;
                case marker_start:
                    adVar.f7073x = m9269a(str2, str);
                    adVar.f7050a |= 2097152;
                    break;
                case marker_mid:
                    adVar.f7074y = m9269a(str2, str);
                    adVar.f7050a |= 4194304;
                    break;
                case marker_end:
                    adVar.f7075z = m9269a(str2, str);
                    adVar.f7050a |= HardwareBuffer.USAGE_SENSOR_DIRECT_DATA;
                    break;
                case display:
                    if (str2.indexOf(124) < 0 && "|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".contains('|' + str2 + '|')) {
                        adVar.f7037A = Boolean.valueOf(!str2.equals(Camera.Parameters.EFFECT_NONE));
                        adVar.f7050a |= HardwareBuffer.USAGE_GPU_DATA_BUFFER;
                        break;
                    }
                    break;
                case visibility:
                    if (str2.indexOf(124) < 0 && "|visible|hidden|collapse|".contains('|' + str2 + '|')) {
                        adVar.f7038B = Boolean.valueOf(str2.equals(CalendarContract.CalendarColumns.VISIBLE));
                        adVar.f7050a |= HardwareBuffer.USAGE_GPU_CUBE_MAP;
                        break;
                    }
                    break;
                case stop_color:
                    if (str2.equals("currentColor")) {
                        adVar.f7039C = C1088h.f.m9114a();
                    } else {
                        try {
                            adVar.f7039C = m9341m(str2);
                        } catch (C1091k e6) {
                            Log.m190w("SVGParser", e6.getMessage());
                            return;
                        }
                    }
                    adVar.f7050a |= HardwareBuffer.USAGE_GPU_MIPMAP_COMPLETE;
                    break;
                case stop_opacity:
                    adVar.f7040D = m9333i(str2);
                    adVar.f7050a |= 134217728;
                    break;
                case clip:
                    adVar.f7072w = m9255A(str2);
                    if (adVar.f7072w != null) {
                        adVar.f7050a |= 1048576;
                        break;
                    }
                    break;
                case clip_path:
                    adVar.f7041E = m9269a(str2, str);
                    adVar.f7050a |= 268435456;
                    break;
                case clip_rule:
                    adVar.f7042F = m9357u(str2);
                    adVar.f7050a |= 536870912;
                    break;
                case mask:
                    adVar.f7043G = m9269a(str2, str);
                    adVar.f7050a |= 1073741824;
                    break;
                case solid_color:
                    if (str2.equals("currentColor")) {
                        adVar.f7044H = C1088h.f.m9114a();
                    } else {
                        try {
                            adVar.f7044H = m9341m(str2);
                        } catch (C1091k e7) {
                            Log.m190w("SVGParser", e7.getMessage());
                            return;
                        }
                    }
                    adVar.f7050a |= 2147483648L;
                    break;
                case solid_opacity:
                    adVar.f7045I = m9333i(str2);
                    adVar.f7050a |= 4294967296L;
                    break;
                case viewport_fill:
                    if (str2.equals("currentColor")) {
                        adVar.f7046J = C1088h.f.m9114a();
                    } else {
                        try {
                            adVar.f7046J = m9341m(str2);
                        } catch (C1091k e8) {
                            Log.m190w("SVGParser", e8.getMessage());
                            return;
                        }
                    }
                    adVar.f7050a |= 8589934592L;
                    break;
                case viewport_fill_opacity:
                    adVar.f7047K = m9333i(str2);
                    adVar.f7050a |= 17179869184L;
                    break;
                case vector_effect:
                    adVar.f7048L = m9257B(str2);
                    if (adVar.f7048L != null) {
                        adVar.f7050a |= 34359738368L;
                        break;
                    }
                    break;
                case image_rendering:
                    adVar.f7049M = m9259C(str2);
                    if (adVar.f7049M != null) {
                        adVar.f7050a |= 137438953472L;
                        break;
                    }
                    break;
            }
        }
    }

    /* renamed from: a */
    private void m9284a(C1088h.aq aqVar, Attributes attributes) {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.m9374a(attributes.getLocalName(i2))) {
                case preserveAspectRatio:
                    m9282a((C1088h.ao) aqVar, trim);
                    break;
                case viewBox:
                    aqVar.f7145x = m9335j(trim);
                    break;
            }
        }
    }

    /* renamed from: a */
    private void m9293a(C1088h.m mVar, Attributes attributes) {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            if (f.m9374a(attributes.getLocalName(i2)) == f.transform) {
                mVar.mo9112a(m9327f(attributes.getValue(i2)));
            }
        }
    }

    /* renamed from: f */
    private Matrix m9327f(String str) {
        Matrix matrix = new Matrix();
        h hVar = new h(str);
        hVar.m9387g();
        while (!hVar.m9386f()) {
            String m9397q = hVar.m9397q();
            if (m9397q == null) {
                throw new C1091k("Bad transform function encountered in transform list: " + str);
            }
            switch (m9397q) {
                case "matrix":
                    hVar.m9387g();
                    float m9389i = hVar.m9389i();
                    hVar.m9388h();
                    float m9389i2 = hVar.m9389i();
                    hVar.m9388h();
                    float m9389i3 = hVar.m9389i();
                    hVar.m9388h();
                    float m9389i4 = hVar.m9389i();
                    hVar.m9388h();
                    float m9389i5 = hVar.m9389i();
                    hVar.m9388h();
                    float m9389i6 = hVar.m9389i();
                    hVar.m9387g();
                    if (Float.isNaN(m9389i6) || !hVar.m9380a(')')) {
                        throw new C1091k("Invalid transform list: " + str);
                    }
                    Matrix matrix2 = new Matrix();
                    matrix2.setValues(new float[]{m9389i, m9389i3, m9389i5, m9389i2, m9389i4, m9389i6, 0.0f, 0.0f, 1.0f});
                    matrix.preConcat(matrix2);
                    break;
                    break;
                case "translate":
                    hVar.m9387g();
                    float m9389i7 = hVar.m9389i();
                    float m9390j = hVar.m9390j();
                    hVar.m9387g();
                    if (Float.isNaN(m9389i7) || !hVar.m9380a(')')) {
                        throw new C1091k("Invalid transform list: " + str);
                    }
                    if (Float.isNaN(m9390j)) {
                        matrix.preTranslate(m9389i7, 0.0f);
                        break;
                    } else {
                        matrix.preTranslate(m9389i7, m9390j);
                        break;
                    }
                    break;
                case "scale":
                    hVar.m9387g();
                    float m9389i8 = hVar.m9389i();
                    float m9390j2 = hVar.m9390j();
                    hVar.m9387g();
                    if (Float.isNaN(m9389i8) || !hVar.m9380a(')')) {
                        throw new C1091k("Invalid transform list: " + str);
                    }
                    if (Float.isNaN(m9390j2)) {
                        matrix.preScale(m9389i8, m9389i8);
                        break;
                    } else {
                        matrix.preScale(m9389i8, m9390j2);
                        break;
                    }
                case "rotate":
                    hVar.m9387g();
                    float m9389i9 = hVar.m9389i();
                    float m9390j3 = hVar.m9390j();
                    float m9390j4 = hVar.m9390j();
                    hVar.m9387g();
                    if (Float.isNaN(m9389i9) || !hVar.m9380a(')')) {
                        throw new C1091k("Invalid transform list: " + str);
                    }
                    if (Float.isNaN(m9390j3)) {
                        matrix.preRotate(m9389i9);
                        break;
                    } else if (!Float.isNaN(m9390j4)) {
                        matrix.preRotate(m9389i9, m9390j3, m9390j4);
                        break;
                    } else {
                        throw new C1091k("Invalid transform list: " + str);
                    }
                    break;
                case "skewX":
                    hVar.m9387g();
                    float m9389i10 = hVar.m9389i();
                    hVar.m9387g();
                    if (Float.isNaN(m9389i10) || !hVar.m9380a(')')) {
                        throw new C1091k("Invalid transform list: " + str);
                    }
                    matrix.preSkew((float) Math.tan(Math.toRadians(m9389i10)), 0.0f);
                    break;
                    break;
                case "skewY":
                    hVar.m9387g();
                    float m9389i11 = hVar.m9389i();
                    hVar.m9387g();
                    if (Float.isNaN(m9389i11) || !hVar.m9380a(')')) {
                        throw new C1091k("Invalid transform list: " + str);
                    }
                    matrix.preSkew(0.0f, (float) Math.tan(Math.toRadians(m9389i11)));
                    break;
                    break;
                default:
                    throw new C1091k("Invalid transform list fn: " + m9397q + ")");
            }
            if (!hVar.m9386f()) {
                hVar.m9388h();
            } else {
                return matrix;
            }
        }
        return matrix;
    }

    /* renamed from: a */
    static C1088h.o m9268a(String str) {
        if (str.length() == 0) {
            throw new C1091k("Invalid length value (empty string)");
        }
        int length = str.length();
        C1088h.bc bcVar = C1088h.bc.px;
        char charAt = str.charAt(length - 1);
        if (charAt == '%') {
            length--;
            bcVar = C1088h.bc.percent;
        } else if (length > 2 && Character.isLetter(charAt) && Character.isLetter(str.charAt(length - 2))) {
            length -= 2;
            try {
                bcVar = C1088h.bc.valueOf(str.substring(length).toLowerCase(Locale.f10688US));
            } catch (IllegalArgumentException e2) {
                throw new C1091k("Invalid length unit specifier: " + str);
            }
        }
        try {
            return new C1088h.o(m9265a(str, 0, length), bcVar);
        } catch (NumberFormatException e3) {
            throw new C1091k("Invalid length value: " + str, e3);
        }
    }

    /* renamed from: g */
    private static List<C1088h.o> m9329g(String str) {
        if (str.length() == 0) {
            throw new C1091k("Invalid length list (empty string)");
        }
        ArrayList arrayList = new ArrayList(1);
        h hVar = new h(str);
        hVar.m9387g();
        while (!hVar.m9386f()) {
            float m9389i = hVar.m9389i();
            if (Float.isNaN(m9389i)) {
                throw new C1091k("Invalid length list value: " + hVar.m9398r());
            }
            C1088h.bc m9399s = hVar.m9399s();
            if (m9399s == null) {
                m9399s = C1088h.bc.px;
            }
            arrayList.add(new C1088h.o(m9389i, m9399s));
            hVar.m9388h();
        }
        return arrayList;
    }

    /* renamed from: h */
    private static float m9331h(String str) {
        int length = str.length();
        if (length == 0) {
            throw new C1091k("Invalid float value (empty string)");
        }
        return m9265a(str, 0, length);
    }

    /* renamed from: a */
    private static float m9265a(String str, int i2, int i3) {
        float m9061a = new C1085e().m9061a(str, i2, i3);
        if (!Float.isNaN(m9061a)) {
            return m9061a;
        }
        throw new C1091k("Invalid float value: " + str);
    }

    /* renamed from: i */
    private static Float m9333i(String str) {
        try {
            float m9331h = m9331h(str);
            return Float.valueOf(m9331h >= 0.0f ? m9331h > 1.0f ? 1.0f : m9331h : 0.0f);
        } catch (C1091k e2) {
            return null;
        }
    }

    /* renamed from: j */
    private static C1088h.a m9335j(String str) {
        h hVar = new h(str);
        hVar.m9387g();
        float m9389i = hVar.m9389i();
        hVar.m9388h();
        float m9389i2 = hVar.m9389i();
        hVar.m9388h();
        float m9389i3 = hVar.m9389i();
        hVar.m9388h();
        float m9389i4 = hVar.m9389i();
        if (Float.isNaN(m9389i) || Float.isNaN(m9389i2) || Float.isNaN(m9389i3) || Float.isNaN(m9389i4)) {
            throw new C1091k("Invalid viewBox definition - should have four numbers");
        }
        if (m9389i3 < 0.0f) {
            throw new C1091k("Invalid viewBox. width cannot be negative");
        }
        if (m9389i4 < 0.0f) {
            throw new C1091k("Invalid viewBox. height cannot be negative");
        }
        return new C1088h.a(m9389i, m9389i2, m9389i3, m9389i4);
    }

    /* renamed from: a */
    private static void m9282a(C1088h.ao aoVar, String str) {
        aoVar.f7139w = m9314b(str);
    }

    /* renamed from: b */
    static C1086f m9314b(String str) {
        h hVar = new h(str);
        hVar.m9387g();
        String m9395o = hVar.m9395o();
        if ("defer".equals(m9395o)) {
            hVar.m9387g();
            m9395o = hVar.m9395o();
        }
        C1086f.a m9370a = a.m9370a(m9395o);
        C1086f.b bVar = null;
        hVar.m9387g();
        if (!hVar.m9386f()) {
            switch (hVar.m9395o()) {
                case "meet":
                    bVar = C1086f.b.meet;
                    break;
                case "slice":
                    bVar = C1086f.b.slice;
                    break;
                default:
                    throw new C1091k("Invalid preserveAspectRatio definition: " + str);
            }
        }
        return new C1086f(m9370a, bVar);
    }

    /* renamed from: k */
    private static C1088h.an m9337k(String str) {
        if (str.startsWith("url(")) {
            int indexOf = str.indexOf(")");
            if (indexOf != -1) {
                String trim = str.substring(4, indexOf).trim();
                String trim2 = str.substring(indexOf + 1).trim();
                return new C1088h.t(trim, trim2.length() > 0 ? m9339l(trim2) : null);
            }
            return new C1088h.t(str.substring(4).trim(), null);
        }
        return m9339l(str);
    }

    /* renamed from: l */
    private static C1088h.an m9339l(String str) {
        switch (str) {
            case "none":
                return C1088h.e.f7183c;
            case "currentColor":
                return C1088h.f.m9114a();
            default:
                try {
                    return m9341m(str);
                } catch (C1091k e2) {
                    return null;
                }
        }
    }

    /* renamed from: m */
    private static C1088h.e m9341m(String str) {
        if (str.charAt(0) == '#') {
            C1084d m9057a = C1084d.m9057a(str, 1, str.length());
            if (m9057a == null) {
                throw new C1091k("Bad hex colour value: " + str);
            }
            switch (m9057a.m9059a()) {
                case 4:
                    int m9060b = m9057a.m9060b();
                    int i2 = m9060b & 3840;
                    int i3 = m9060b & 240;
                    int i4 = m9060b & 15;
                    return new C1088h.e((i2 << 8) | (i2 << 12) | (-16777216) | (i3 << 8) | (i3 << 4) | (i4 << 4) | i4);
                case 5:
                    int m9060b2 = m9057a.m9060b();
                    int i5 = 61440 & m9060b2;
                    int i6 = m9060b2 & 3840;
                    int i7 = m9060b2 & 240;
                    int i8 = m9060b2 & 15;
                    return new C1088h.e((i5 << 4) | (i8 << 24) | (i8 << 28) | (i5 << 8) | (i6 << 4) | i6 | i7 | (i7 >> 4));
                case 6:
                case 8:
                default:
                    throw new C1091k("Bad hex colour value: " + str);
                case 7:
                    return new C1088h.e(m9057a.m9060b() | (-16777216));
                case 9:
                    return new C1088h.e((m9057a.m9060b() >>> 8) | (m9057a.m9060b() << 24));
            }
        }
        String lowerCase = str.toLowerCase(Locale.f10688US);
        boolean startsWith = lowerCase.startsWith("rgba(");
        if (startsWith || lowerCase.startsWith("rgb(")) {
            h hVar = new h(str.substring(startsWith ? 5 : 4));
            hVar.m9387g();
            float m9389i = hVar.m9389i();
            if (!Float.isNaN(m9389i) && hVar.m9380a('%')) {
                m9389i = (m9389i * 256.0f) / 100.0f;
            }
            float m9376a = hVar.m9376a(m9389i);
            if (!Float.isNaN(m9376a) && hVar.m9380a('%')) {
                m9376a = (m9376a * 256.0f) / 100.0f;
            }
            float m9376a2 = hVar.m9376a(m9376a);
            float f2 = (Float.isNaN(m9376a2) || !hVar.m9380a('%')) ? m9376a2 : (m9376a2 * 256.0f) / 100.0f;
            if (startsWith) {
                float m9376a3 = hVar.m9376a(f2);
                hVar.m9387g();
                if (Float.isNaN(m9376a3) || !hVar.m9380a(')')) {
                    throw new C1091k("Bad rgba() colour value: " + str);
                }
                return new C1088h.e((m9266a(m9389i) << 16) | (m9266a(m9376a3 * 256.0f) << 24) | (m9266a(m9376a) << 8) | m9266a(f2));
            }
            hVar.m9387g();
            if (Float.isNaN(f2) || !hVar.m9380a(')')) {
                throw new C1091k("Bad rgb() colour value: " + str);
            }
            return new C1088h.e((m9266a(m9389i) << 16) | (-16777216) | (m9266a(m9376a) << 8) | m9266a(f2));
        }
        boolean startsWith2 = lowerCase.startsWith("hsla(");
        if (startsWith2 || lowerCase.startsWith("hsl(")) {
            h hVar2 = new h(str.substring(startsWith2 ? 5 : 4));
            hVar2.m9387g();
            float m9389i2 = hVar2.m9389i();
            float m9376a4 = hVar2.m9376a(m9389i2);
            if (!Float.isNaN(m9376a4)) {
                hVar2.m9380a('%');
            }
            float m9376a5 = hVar2.m9376a(m9376a4);
            if (!Float.isNaN(m9376a5)) {
                hVar2.m9380a('%');
            }
            if (startsWith2) {
                float m9376a6 = hVar2.m9376a(m9376a5);
                hVar2.m9387g();
                if (Float.isNaN(m9376a6) || !hVar2.m9380a(')')) {
                    throw new C1091k("Bad hsla() colour value: " + str);
                }
                return new C1088h.e((m9266a(m9376a6 * 256.0f) << 24) | m9267a(m9389i2, m9376a4, m9376a5));
            }
            hVar2.m9387g();
            if (Float.isNaN(m9376a5) || !hVar2.m9380a(')')) {
                throw new C1091k("Bad hsl() colour value: " + str);
            }
            return new C1088h.e(m9267a(m9389i2, m9376a4, m9376a5) | (-16777216));
        }
        return m9343n(lowerCase);
    }

    /* renamed from: a */
    private static int m9266a(float f2) {
        if (f2 < 0.0f) {
            return 0;
        }
        if (f2 > 255.0f) {
            return 255;
        }
        return Math.round(f2);
    }

    /* renamed from: a */
    private static int m9267a(float f2, float f3, float f4) {
        float f5;
        float f6 = (f2 >= 0.0f ? f2 % 360.0f : (f2 % 360.0f) + 360.0f) / 60.0f;
        float f7 = f3 / 100.0f;
        float f8 = f4 / 100.0f;
        if (f7 < 0.0f) {
            f7 = 0.0f;
        } else if (f7 > 1.0f) {
            f7 = 1.0f;
        }
        if (f8 < 0.0f) {
            f8 = 0.0f;
        } else if (f8 > 1.0f) {
            f8 = 1.0f;
        }
        if (f8 <= 0.5f) {
            f5 = (f7 + 1.0f) * f8;
        } else {
            f5 = (f8 + f7) - (f8 * f7);
        }
        float f9 = (f8 * 2.0f) - f5;
        return m9266a(m9313b(f9, f5, f6 - 2.0f) * 256.0f) | (m9266a(m9313b(f9, f5, f6 + 2.0f) * 256.0f) << 16) | (m9266a(m9313b(f9, f5, f6) * 256.0f) << 8);
    }

    /* renamed from: b */
    private static float m9313b(float f2, float f3, float f4) {
        float f5 = f4 < 0.0f ? f4 + 6.0f : f4;
        if (f5 >= 6.0f) {
            f5 -= 6.0f;
        }
        if (f5 < 1.0f) {
            return (f5 * (f3 - f2)) + f2;
        }
        if (f5 < 3.0f) {
            return f3;
        }
        if (f5 < 4.0f) {
            return ((4.0f - f5) * (f3 - f2)) + f2;
        }
        return f2;
    }

    /* renamed from: n */
    private static C1088h.e m9343n(String str) {
        Integer m9371a = b.m9371a(str);
        if (m9371a == null) {
            throw new C1091k("Invalid colour keyword: " + str);
        }
        return new C1088h.e(m9371a.intValue());
    }

    /* renamed from: a */
    private static void m9275a(C1088h.ad adVar, String str) {
        String m9383b;
        if ("|caption|icon|menu|message-box|small-caption|status-bar|".contains('|' + str + '|')) {
            h hVar = new h(str);
            String str2 = null;
            C1088h.ad.b bVar = null;
            Integer num = null;
            while (true) {
                m9383b = hVar.m9383b('/');
                hVar.m9387g();
                if (m9383b != null) {
                    if (num != null && bVar != null) {
                        break;
                    }
                    if (!m9383b.equals("normal") && (num != null || (num = d.m9373a(m9383b)) == null)) {
                        if (bVar != null || (bVar = m9351r(m9383b)) == null) {
                            if (str2 != null || !m9383b.equals("small-caps")) {
                                break;
                            } else {
                                str2 = m9383b;
                            }
                        }
                    }
                } else {
                    return;
                }
            }
            C1088h.o m9347p = m9347p(m9383b);
            if (hVar.m9380a('/')) {
                hVar.m9387g();
                String m9395o = hVar.m9395o();
                if (m9395o != null) {
                    try {
                        m9268a(m9395o);
                    } catch (C1091k e2) {
                        return;
                    }
                }
                hVar.m9387g();
            }
            adVar.f7064o = m9345o(hVar.m9402v());
            adVar.f7065p = m9347p;
            adVar.f7066q = Integer.valueOf(num == null ? 400 : num.intValue());
            if (bVar == null) {
                bVar = C1088h.ad.b.Normal;
            }
            adVar.f7067r = bVar;
            adVar.f7050a |= 122880;
        }
    }

    /* renamed from: o */
    private static List<String> m9345o(String str) {
        ArrayList arrayList = null;
        h hVar = new h(str);
        do {
            String m9401u = hVar.m9401u();
            if (m9401u == null) {
                m9401u = hVar.m9385c(',');
            }
            if (m9401u == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(m9401u);
            hVar.m9388h();
        } while (!hVar.m9386f());
        return arrayList;
    }

    /* renamed from: p */
    private static C1088h.o m9347p(String str) {
        try {
            C1088h.o m9372a = c.m9372a(str);
            if (m9372a == null) {
                return m9268a(str);
            }
            return m9372a;
        } catch (C1091k e2) {
            return null;
        }
    }

    /* renamed from: q */
    private static Integer m9349q(String str) {
        return d.m9373a(str);
    }

    /* renamed from: r */
    private static C1088h.ad.b m9351r(String str) {
        switch (str) {
            case "italic":
                return C1088h.ad.b.Italic;
            case "normal":
                return C1088h.ad.b.Normal;
            case "oblique":
                return C1088h.ad.b.Oblique;
            default:
                return null;
        }
    }

    /* renamed from: s */
    private static C1088h.ad.g m9353s(String str) {
        switch (str) {
            case "none":
                return C1088h.ad.g.None;
            case "underline":
                return C1088h.ad.g.Underline;
            case "overline":
                return C1088h.ad.g.Overline;
            case "line-through":
                return C1088h.ad.g.LineThrough;
            case "blink":
                return C1088h.ad.g.Blink;
            default:
                return null;
        }
    }

    /* renamed from: t */
    private static C1088h.ad.h m9355t(String str) {
        switch (str) {
            case "ltr":
                return C1088h.ad.h.LTR;
            case "rtl":
                return C1088h.ad.h.RTL;
            default:
                return null;
        }
    }

    /* renamed from: u */
    private static C1088h.ad.a m9357u(String str) {
        if ("nonzero".equals(str)) {
            return C1088h.ad.a.NonZero;
        }
        if ("evenodd".equals(str)) {
            return C1088h.ad.a.EvenOdd;
        }
        return null;
    }

    /* renamed from: v */
    private static C1088h.ad.c m9359v(String str) {
        if ("butt".equals(str)) {
            return C1088h.ad.c.Butt;
        }
        if ("round".equals(str)) {
            return C1088h.ad.c.Round;
        }
        if ("square".equals(str)) {
            return C1088h.ad.c.Square;
        }
        return null;
    }

    /* renamed from: w */
    private static C1088h.ad.d m9361w(String str) {
        if ("miter".equals(str)) {
            return C1088h.ad.d.Miter;
        }
        if ("round".equals(str)) {
            return C1088h.ad.d.Round;
        }
        if ("bevel".equals(str)) {
            return C1088h.ad.d.Bevel;
        }
        return null;
    }

    /* renamed from: x */
    private static C1088h.o[] m9364x(String str) {
        C1088h.o m9392l;
        h hVar = new h(str);
        hVar.m9387g();
        if (!hVar.m9386f() && (m9392l = hVar.m9392l()) != null && !m9392l.m9122c()) {
            float m9115a = m9392l.m9115a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(m9392l);
            while (!hVar.m9386f()) {
                hVar.m9388h();
                C1088h.o m9392l2 = hVar.m9392l();
                if (m9392l2 != null && !m9392l2.m9122c()) {
                    arrayList.add(m9392l2);
                    m9115a += m9392l2.m9115a();
                }
                return null;
            }
            if (m9115a == 0.0f) {
                return null;
            }
            return (C1088h.o[]) arrayList.toArray(new C1088h.o[arrayList.size()]);
        }
        return null;
    }

    /* renamed from: y */
    private static C1088h.ad.f m9365y(String str) {
        switch (str) {
            case "start":
                return C1088h.ad.f.Start;
            case "middle":
                return C1088h.ad.f.Middle;
            case "end":
                return C1088h.ad.f.End;
            default:
                return null;
        }
    }

    /* renamed from: z */
    private static Boolean m9367z(String str) {
        switch (str) {
            case "visible":
            case "auto":
                return Boolean.TRUE;
            case "hidden":
            case "scroll":
                return Boolean.FALSE;
            default:
                return null;
        }
    }

    /* renamed from: A */
    private static C1088h.b m9255A(String str) {
        if ("auto".equals(str) || !str.startsWith("rect(")) {
            return null;
        }
        h hVar = new h(str.substring(5));
        hVar.m9387g();
        C1088h.o m9315b = m9315b(hVar);
        hVar.m9388h();
        C1088h.o m9315b2 = m9315b(hVar);
        hVar.m9388h();
        C1088h.o m9315b3 = m9315b(hVar);
        hVar.m9388h();
        C1088h.o m9315b4 = m9315b(hVar);
        hVar.m9387g();
        if (hVar.m9380a(')') || hVar.m9386f()) {
            return new C1088h.b(m9315b, m9315b2, m9315b3, m9315b4);
        }
        return null;
    }

    /* renamed from: b */
    private static C1088h.o m9315b(h hVar) {
        return hVar.m9382a("auto") ? new C1088h.o(0.0f) : hVar.m9392l();
    }

    /* renamed from: B */
    private static C1088h.ad.i m9257B(String str) {
        switch (str) {
            case "none":
                return C1088h.ad.i.None;
            case "non-scaling-stroke":
                return C1088h.ad.i.NonScalingStroke;
            default:
                return null;
        }
    }

    /* renamed from: C */
    private static C1088h.ad.e m9259C(String str) {
        switch (str) {
            case "auto":
                return C1088h.ad.e.auto;
            case "optimizeQuality":
                return C1088h.ad.e.optimizeQuality;
            case "optimizeSpeed":
                return C1088h.ad.e.optimizeSpeed;
            default:
                return null;
        }
    }

    /* renamed from: D */
    private static C1088h.v m9260D(String str) {
        int intValue;
        float f2;
        float f3;
        int i2;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        h hVar = new h(str);
        float f15 = 0.0f;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        C1088h.v vVar = new C1088h.v();
        if (!hVar.m9386f() && ((intValue = hVar.m9391k().intValue()) == 77 || intValue == 109)) {
            int i3 = intValue;
            float f19 = 0.0f;
            float f20 = 0.0f;
            while (true) {
                hVar.m9387g();
                switch (i3) {
                    case 65:
                    case 97:
                        float m9389i = hVar.m9389i();
                        float m9376a = hVar.m9376a(m9389i);
                        float m9376a2 = hVar.m9376a(m9376a);
                        Boolean m9378a = hVar.m9378a(Float.valueOf(m9376a2));
                        Boolean m9378a2 = hVar.m9378a((Object) m9378a);
                        float m9377a = hVar.m9377a(m9378a2);
                        float m9376a3 = hVar.m9376a(m9377a);
                        if (!Float.isNaN(m9376a3) && m9389i >= 0.0f && m9376a >= 0.0f) {
                            if (i3 == 97) {
                                float f21 = m9377a + f15;
                                f13 = m9376a3 + f16;
                                f14 = f21;
                            } else {
                                f13 = m9376a3;
                                f14 = m9377a;
                            }
                            vVar.mo9128a(m9389i, m9376a, m9376a2, m9378a.booleanValue(), m9378a2.booleanValue(), f14, f13);
                            i2 = i3;
                            f18 = f13;
                            f17 = f14;
                            f4 = f19;
                            f5 = f20;
                            f6 = f13;
                            f3 = f14;
                            break;
                        }
                        break;
                    case 67:
                    case 99:
                        float m9389i2 = hVar.m9389i();
                        float m9376a4 = hVar.m9376a(m9389i2);
                        f17 = hVar.m9376a(m9376a4);
                        float m9376a5 = hVar.m9376a(f17);
                        f3 = hVar.m9376a(m9376a5);
                        float m9376a6 = hVar.m9376a(f3);
                        if (Float.isNaN(m9376a6)) {
                            Log.m184e("SVGParser", "Bad path coords for " + ((char) i3) + " path segment");
                            break;
                        } else {
                            if (i3 == 99) {
                                f3 += f15;
                                m9389i2 += f15;
                                m9376a4 += f16;
                                f17 += f15;
                                m9376a5 += f16;
                                f8 = m9376a6 + f16;
                            } else {
                                f8 = m9376a6;
                            }
                            vVar.mo9127a(m9389i2, m9376a4, f17, m9376a5, f3, f8);
                            i2 = i3;
                            f18 = m9376a5;
                            f4 = f19;
                            f5 = f20;
                            f6 = f8;
                            break;
                        }
                    case 72:
                    case 104:
                        float m9389i3 = hVar.m9389i();
                        if (Float.isNaN(m9389i3)) {
                            Log.m184e("SVGParser", "Bad path coords for " + ((char) i3) + " path segment");
                            break;
                        } else {
                            float f22 = i3 == 104 ? m9389i3 + f15 : m9389i3;
                            vVar.mo9132b(f22, f16);
                            i2 = i3;
                            f17 = f22;
                            f4 = f19;
                            f5 = f20;
                            f6 = f16;
                            f3 = f22;
                            break;
                        }
                    case 76:
                    case 108:
                        float m9389i4 = hVar.m9389i();
                        float m9376a7 = hVar.m9376a(m9389i4);
                        if (Float.isNaN(m9376a7)) {
                            Log.m184e("SVGParser", "Bad path coords for " + ((char) i3) + " path segment");
                            break;
                        } else {
                            if (i3 == 108) {
                                f9 = m9376a7 + f16;
                                f10 = m9389i4 + f15;
                            } else {
                                f9 = m9376a7;
                                f10 = m9389i4;
                            }
                            vVar.mo9132b(f10, f9);
                            i2 = i3;
                            f18 = f9;
                            f17 = f10;
                            f4 = f19;
                            f5 = f20;
                            f6 = f9;
                            f3 = f10;
                            break;
                        }
                    case 77:
                    case 109:
                        float m9389i5 = hVar.m9389i();
                        float m9376a8 = hVar.m9376a(m9389i5);
                        if (Float.isNaN(m9376a8)) {
                            Log.m184e("SVGParser", "Bad path coords for " + ((char) i3) + " path segment");
                            break;
                        } else {
                            if (i3 != 109 || vVar.m9130a()) {
                                f11 = m9376a8;
                                f12 = m9389i5;
                            } else {
                                f11 = m9376a8 + f16;
                                f12 = m9389i5 + f15;
                            }
                            vVar.mo9125a(f12, f11);
                            i2 = i3 == 109 ? 108 : 76;
                            f18 = f11;
                            f17 = f12;
                            f4 = f11;
                            f5 = f12;
                            f6 = f11;
                            f3 = f12;
                            break;
                        }
                    case 81:
                    case 113:
                        f17 = hVar.m9389i();
                        float m9376a9 = hVar.m9376a(f17);
                        f3 = hVar.m9376a(m9376a9);
                        float m9376a10 = hVar.m9376a(f3);
                        if (Float.isNaN(m9376a10)) {
                            Log.m184e("SVGParser", "Bad path coords for " + ((char) i3) + " path segment");
                            break;
                        } else {
                            if (i3 == 113) {
                                f3 += f15;
                                m9376a10 += f16;
                                f17 += f15;
                                f18 = m9376a9 + f16;
                            } else {
                                f18 = m9376a9;
                            }
                            vVar.mo9126a(f17, f18, f3, m9376a10);
                            i2 = i3;
                            f4 = f19;
                            f5 = f20;
                            f6 = m9376a10;
                            break;
                        }
                    case 83:
                    case 115:
                        float f23 = (2.0f * f15) - f17;
                        float f24 = (2.0f * f16) - f18;
                        f17 = hVar.m9389i();
                        float m9376a11 = hVar.m9376a(f17);
                        f3 = hVar.m9376a(m9376a11);
                        float m9376a12 = hVar.m9376a(f3);
                        if (Float.isNaN(m9376a12)) {
                            Log.m184e("SVGParser", "Bad path coords for " + ((char) i3) + " path segment");
                            break;
                        } else {
                            if (i3 == 115) {
                                f3 += f15;
                                f17 += f15;
                                m9376a11 += f16;
                                f7 = m9376a12 + f16;
                            } else {
                                f7 = m9376a12;
                            }
                            vVar.mo9127a(f23, f24, f17, m9376a11, f3, f7);
                            i2 = i3;
                            f18 = m9376a11;
                            f4 = f19;
                            f5 = f20;
                            f6 = f7;
                            break;
                        }
                    case 84:
                    case 116:
                        f17 = (2.0f * f15) - f17;
                        float f25 = (2.0f * f16) - f18;
                        float m9389i6 = hVar.m9389i();
                        float m9376a13 = hVar.m9376a(m9389i6);
                        if (Float.isNaN(m9376a13)) {
                            Log.m184e("SVGParser", "Bad path coords for " + ((char) i3) + " path segment");
                            break;
                        } else {
                            if (i3 == 116) {
                                f2 = m9376a13 + f16;
                                f3 = m9389i6 + f15;
                            } else {
                                f2 = m9376a13;
                                f3 = m9389i6;
                            }
                            vVar.mo9126a(f17, f25, f3, f2);
                            i2 = i3;
                            f18 = f25;
                            f4 = f19;
                            f5 = f20;
                            f6 = f2;
                            break;
                        }
                    case 86:
                    case 118:
                        float m9389i7 = hVar.m9389i();
                        if (Float.isNaN(m9389i7)) {
                            Log.m184e("SVGParser", "Bad path coords for " + ((char) i3) + " path segment");
                            break;
                        } else {
                            float f26 = i3 == 118 ? m9389i7 + f16 : m9389i7;
                            vVar.mo9132b(f15, f26);
                            i2 = i3;
                            f18 = f26;
                            f4 = f19;
                            f5 = f20;
                            f6 = f26;
                            f3 = f15;
                            break;
                        }
                    case 90:
                    case 122:
                        vVar.mo9131b();
                        i2 = i3;
                        f18 = f19;
                        f17 = f20;
                        f4 = f19;
                        f5 = f20;
                        f6 = f19;
                        f3 = f20;
                        break;
                }
                hVar.m9388h();
                if (!hVar.m9386f()) {
                    if (hVar.m9400t()) {
                        i3 = hVar.m9391k().intValue();
                        f19 = f4;
                        f20 = f5;
                        f16 = f6;
                        f15 = f3;
                    } else {
                        i3 = i2;
                        f19 = f4;
                        f20 = f5;
                        f16 = f6;
                        f15 = f3;
                    }
                }
            }
        }
        return vVar;
    }

    /* renamed from: E */
    private static Set<String> m9261E(String str) {
        h hVar = new h(str);
        HashSet hashSet = new HashSet();
        while (!hVar.m9386f()) {
            String m9395o = hVar.m9395o();
            if (m9395o.startsWith("http://www.w3.org/TR/SVG11/feature#")) {
                hashSet.add(m9395o.substring("http://www.w3.org/TR/SVG11/feature#".length()));
            } else {
                hashSet.add("UNSUPPORTED");
            }
            hVar.m9387g();
        }
        return hashSet;
    }

    /* renamed from: F */
    private static Set<String> m9262F(String str) {
        h hVar = new h(str);
        HashSet hashSet = new HashSet();
        while (!hVar.m9386f()) {
            String m9395o = hVar.m9395o();
            int indexOf = m9395o.indexOf(45);
            if (indexOf != -1) {
                m9395o = m9395o.substring(0, indexOf);
            }
            hashSet.add(new Locale(m9395o, "", "").getLanguage());
            hVar.m9387g();
        }
        return hashSet;
    }

    /* renamed from: G */
    private static Set<String> m9263G(String str) {
        h hVar = new h(str);
        HashSet hashSet = new HashSet();
        while (!hVar.m9386f()) {
            hashSet.add(hVar.m9395o());
            hVar.m9387g();
        }
        return hashSet;
    }

    /* renamed from: a */
    private static String m9269a(String str, String str2) {
        if (str.equals(Camera.Parameters.EFFECT_NONE) || !str.startsWith("url(")) {
            return null;
        }
        if (str.endsWith(")")) {
            return str.substring(4, str.length() - 1).trim();
        }
        return str.substring(4).trim();
    }

    /* renamed from: B */
    private void m9258B(Attributes attributes) {
        m9310a("<style>", new Object[0]);
        if (this.f7299b == null) {
            throw new C1091k("Invalid document. Root element must be <svg>");
        }
        String str = "all";
        boolean z = true;
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (f.m9374a(attributes.getLocalName(i2))) {
                case type:
                    z = trim.equals("text/css");
                    break;
                case media:
                    str = trim;
                    break;
            }
        }
        if (z && C1082b.m9013a(str, C1082b.e.screen)) {
            this.f7305h = true;
        } else {
            this.f7300c = true;
            this.f7301d = 1;
        }
    }

    /* renamed from: H */
    private void m9264H(String str) {
        this.f7298a.m9080a(new C1082b(C1082b.e.screen, C1082b.t.Document).m9020a(str));
    }
}
