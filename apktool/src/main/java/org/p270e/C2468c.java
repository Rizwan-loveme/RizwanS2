package org.p270e;

import android.app.slice.SliceItem;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.p209io.Closeable;
import java.p209io.IOException;
import java.p209io.StringWriter;
import java.p209io.Writer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* compiled from: JSONObject.java */
/* renamed from: org.e.c */
/* loaded from: classes.dex */
public class C2468c {

    /* renamed from: a */
    static final Pattern f12953a = Pattern.compile("-?(?:0|[1-9]\\d*)(?:\\.\\d+)?(?:[eE][+-]?\\d+)?");

    /* renamed from: b */
    public static final Object f12954b = new a();

    /* renamed from: c */
    private final Map<String, Object> f12955c;

    /* compiled from: JSONObject.java */
    /* renamed from: org.e.c$a */
    private static final class a {
        private a() {
        }

        protected final Object clone() {
            return this;
        }

        public boolean equals(Object obj) {
            return obj == null || obj == this;
        }

        public int hashCode() {
            return 0;
        }

        public String toString() {
            return "null";
        }
    }

    public C2468c() {
        this.f12955c = new HashMap();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:202)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:61)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:281)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:100)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public C2468c(org.p270e.C2472g r4) {
        /*
            r3 = this;
            r3.<init>()
            char r0 = r4.m15633d()
            r1 = 123(0x7b, float:1.72E-43)
            if (r0 == r1) goto L15
            java.lang.String r0 = "A JSONObject text must begin with '{'"
            org.e.b r0 = r4.m15628a(r0)
            throw r0
        L12:
            r4.m15630a()
        L15:
            char r0 = r4.m15633d()
            switch(r0) {
                case 0: goto L36;
                case 125: goto L82;
                default: goto L1c;
            }
        L1c:
            r4.m15630a()
            java.lang.Object r0 = r4.m15634e()
            java.lang.String r0 = r0.toString()
            char r1 = r4.m15633d()
            r2 = 58
            if (r1 == r2) goto L3d
            java.lang.String r0 = "Expected a ':' after a key"
            org.e.b r0 = r4.m15628a(r0)
            throw r0
        L36:
            java.lang.String r0 = "A JSONObject text must end with '}'"
            org.e.b r0 = r4.m15628a(r0)
            throw r0
        L3d:
            if (r0 == 0) goto L6c
            java.lang.Object r1 = r3.m15620i(r0)
            if (r1 == 0) goto L63
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Duplicate key \""
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r1 = "\""
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            org.e.b r0 = r4.m15628a(r0)
            throw r0
        L63:
            java.lang.Object r1 = r4.m15634e()
            if (r1 == 0) goto L6c
            r3.m15608a(r0, r1)
        L6c:
            char r0 = r4.m15633d()
            switch(r0) {
                case 44: goto L7a;
                case 59: goto L7a;
                case 125: goto L82;
                default: goto L73;
            }
        L73:
            java.lang.String r0 = "Expected a ',' or '}'"
            org.e.b r0 = r4.m15628a(r0)
            throw r0
        L7a:
            char r0 = r4.m15633d()
            r1 = 125(0x7d, float:1.75E-43)
            if (r0 != r1) goto L12
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.p270e.C2468c.<init>(org.e.g):void");
    }

    public C2468c(Map<?, ?> map) {
        if (map == null) {
            this.f12955c = new HashMap();
            return;
        }
        this.f12955c = new HashMap(map.size());
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (entry.getKey() == null) {
                throw new NullPointerException("Null key.");
            }
            Object value = entry.getValue();
            if (value != null) {
                this.f12955c.put(String.valueOf(entry.getKey()), m15593b(value));
            }
        }
    }

    public C2468c(Object obj) {
        this();
        m15595c(obj);
    }

    public C2468c(String str) {
        this(new C2472g(str));
    }

    /* renamed from: a */
    public Object m15602a(String str) {
        if (str == null) {
            throw new C2467b("Null key.");
        }
        Object m15620i = m15620i(str);
        if (m15620i == null) {
            throw new C2467b("JSONObject[" + m15596j(str) + "] not found.");
        }
        return m15620i;
    }

    /* renamed from: b */
    public boolean m15611b(String str) {
        Object m15602a = m15602a(str);
        if (m15602a.equals(Boolean.FALSE) || ((m15602a instanceof String) && ((String) m15602a).equalsIgnoreCase("false"))) {
            return false;
        }
        if (m15602a.equals(Boolean.TRUE) || ((m15602a instanceof String) && ((String) m15602a).equalsIgnoreCase("true"))) {
            return true;
        }
        throw m15589a(str, "Boolean", (Throwable) null);
    }

    /* renamed from: c */
    public int m15612c(String str) {
        Object m15602a = m15602a(str);
        if (m15602a instanceof Number) {
            return ((Number) m15602a).intValue();
        }
        try {
            return Integer.parseInt(m15602a.toString());
        } catch (Exception e2) {
            throw m15589a(str, SliceItem.FORMAT_INT, e2);
        }
    }

    /* renamed from: d */
    public C2466a m15615d(String str) {
        Object m15602a = m15602a(str);
        if (m15602a instanceof C2466a) {
            return (C2466a) m15602a;
        }
        throw m15589a(str, "JSONArray", (Throwable) null);
    }

    /* renamed from: e */
    public C2468c m15616e(String str) {
        Object m15602a = m15602a(str);
        if (m15602a instanceof C2468c) {
            return (C2468c) m15602a;
        }
        throw m15589a(str, "JSONObject", (Throwable) null);
    }

    /* renamed from: f */
    public String m15617f(String str) {
        Object m15602a = m15602a(str);
        if (m15602a instanceof String) {
            return (String) m15602a;
        }
        throw m15589a(str, "string", (Throwable) null);
    }

    /* renamed from: g */
    public boolean m15618g(String str) {
        return this.f12955c.containsKey(str);
    }

    /* renamed from: h */
    public boolean m15619h(String str) {
        return f12954b.equals(m15620i(str));
    }

    /* renamed from: a */
    public Iterator<String> m15605a() {
        return m15610b().iterator();
    }

    /* renamed from: b */
    public Set<String> m15610b() {
        return this.f12955c.keySet();
    }

    /* renamed from: c */
    protected Set<Map.Entry<String, Object>> m15613c() {
        return this.f12955c.entrySet();
    }

    /* renamed from: d */
    public int m15614d() {
        return this.f12955c.size();
    }

    /* renamed from: a */
    public static String m15586a(Number number) {
        if (number == null) {
            throw new C2467b("Null pointer");
        }
        m15591a((Object) number);
        String obj = number.toString();
        if (obj.indexOf(46) > 0 && obj.indexOf(101) < 0 && obj.indexOf(69) < 0) {
            while (obj.endsWith("0")) {
                obj = obj.substring(0, obj.length() - 1);
            }
            if (obj.endsWith(".")) {
                return obj.substring(0, obj.length() - 1);
            }
            return obj;
        }
        return obj;
    }

    /* renamed from: i */
    public Object m15620i(String str) {
        if (str == null) {
            return null;
        }
        return this.f12955c.get(str);
    }

    /* renamed from: a */
    public String m15604a(String str, String str2) {
        Object m15620i = m15620i(str);
        return f12954b.equals(m15620i) ? str2 : m15620i.toString();
    }

    /* renamed from: c */
    private void m15595c(Object obj) {
        String m15587a;
        Class<?> cls = obj.getClass();
        for (Method method : cls.getClassLoader() != null ? cls.getMethods() : cls.getDeclaredMethods()) {
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers) && !Modifier.isStatic(modifiers) && method.getParameterTypes().length == 0 && !method.isBridge() && method.getReturnType() != Void.TYPE && m15600o(method.getName()) && (m15587a = m15587a(method)) != null && !m15587a.isEmpty()) {
                try {
                    Object invoke = method.invoke(obj, new Object[0]);
                    if (invoke != null) {
                        this.f12955c.put(m15587a, m15593b(invoke));
                        if (invoke instanceof Closeable) {
                            try {
                                ((Closeable) invoke).close();
                            } catch (IOException e2) {
                            }
                        }
                    }
                } catch (IllegalAccessException e3) {
                } catch (IllegalArgumentException e4) {
                } catch (InvocationTargetException e5) {
                }
            }
        }
    }

    /* renamed from: o */
    private static boolean m15600o(String str) {
        return ("getClass".equals(str) || "getDeclaringClass".equals(str)) ? false : true;
    }

    /* renamed from: a */
    private static String m15587a(Method method) {
        String substring;
        int m15592b;
        int m15592b2 = m15592b(method, InterfaceC2469d.class);
        if (m15592b2 > 0 && ((m15592b = m15592b(method, InterfaceC2470e.class)) < 0 || m15592b2 <= m15592b)) {
            return null;
        }
        InterfaceC2470e interfaceC2470e = (InterfaceC2470e) m15588a(method, InterfaceC2470e.class);
        if (interfaceC2470e != null && interfaceC2470e.m15622a() != null && !interfaceC2470e.m15622a().isEmpty()) {
            return interfaceC2470e.m15622a();
        }
        String name = method.getName();
        if (name.startsWith("get") && name.length() > 3) {
            substring = name.substring(3);
        } else {
            if (!name.startsWith("is") || name.length() <= 2) {
                return null;
            }
            substring = name.substring(2);
        }
        if (substring.length() == 0 || Character.isLowerCase(substring.charAt(0))) {
            return null;
        }
        if (substring.length() == 1) {
            return substring.toLowerCase(Locale.ROOT);
        }
        if (!Character.isUpperCase(substring.charAt(1))) {
            return substring.substring(0, 1).toLowerCase(Locale.ROOT) + substring.substring(1);
        }
        return substring;
    }

    /* renamed from: a */
    private static <A extends Annotation> A m15588a(Method method, Class<A> cls) {
        A a2 = null;
        if (method == null || cls == null) {
            return null;
        }
        if (method.isAnnotationPresent(cls)) {
            return (A) method.getAnnotation(cls);
        }
        Class<?> declaringClass = method.getDeclaringClass();
        if (declaringClass.getSuperclass() == null) {
            return null;
        }
        for (Class<?> cls2 : declaringClass.getInterfaces()) {
            try {
                return (A) m15588a(cls2.getMethod(method.getName(), method.getParameterTypes()), cls);
            } catch (NoSuchMethodException | SecurityException e2) {
            }
        }
        try {
            return (A) m15588a(declaringClass.getSuperclass().getMethod(method.getName(), method.getParameterTypes()), cls);
        } catch (NoSuchMethodException e3) {
            return a2;
        } catch (SecurityException e4) {
            return a2;
        }
    }

    /* renamed from: b */
    private static int m15592b(Method method, Class<? extends Annotation> cls) {
        int m15592b;
        if (method == null || cls == null) {
            return -1;
        }
        if (method.isAnnotationPresent(cls)) {
            return 1;
        }
        Class<?> declaringClass = method.getDeclaringClass();
        if (declaringClass.getSuperclass() == null) {
            return -1;
        }
        for (Class<?> cls2 : declaringClass.getInterfaces()) {
            try {
                m15592b = m15592b(cls2.getMethod(method.getName(), method.getParameterTypes()), cls);
            } catch (NoSuchMethodException e2) {
            } catch (SecurityException e3) {
            }
            if (m15592b > 0) {
                return m15592b + 1;
            }
        }
        try {
            int m15592b2 = m15592b(declaringClass.getSuperclass().getMethod(method.getName(), method.getParameterTypes()), cls);
            if (m15592b2 > 0) {
                return m15592b2 + 1;
            }
            return -1;
        } catch (NoSuchMethodException e4) {
            return -1;
        } catch (SecurityException e5) {
            return -1;
        }
    }

    /* renamed from: a */
    public C2468c m15609a(String str, boolean z) {
        return m15608a(str, z ? Boolean.TRUE : Boolean.FALSE);
    }

    /* renamed from: a */
    public C2468c m15606a(String str, int i) {
        return m15608a(str, Integer.valueOf(i));
    }

    /* renamed from: a */
    public C2468c m15607a(String str, long j) {
        return m15608a(str, Long.valueOf(j));
    }

    /* renamed from: a */
    public C2468c m15608a(String str, Object obj) {
        if (str == null) {
            throw new NullPointerException("Null key.");
        }
        if (obj != null) {
            m15591a(obj);
            this.f12955c.put(str, obj);
        } else {
            m15621k(str);
        }
        return this;
    }

    /* renamed from: j */
    public static String m15596j(String str) {
        String str2;
        StringWriter stringWriter = new StringWriter();
        synchronized (stringWriter.getBuffer()) {
            try {
                str2 = m15585a(str, (Writer) stringWriter).toString();
            } catch (IOException e2) {
                str2 = "";
            }
        }
        return str2;
    }

    /* renamed from: a */
    public static Writer m15585a(String str, Writer writer) {
        if (str == null || str.isEmpty()) {
            writer.write("\"\"");
        } else {
            int length = str.length();
            writer.write(34);
            int i = 0;
            char c2 = 0;
            while (i < length) {
                char charAt = str.charAt(i);
                switch (charAt) {
                    case '\b':
                        writer.write("\\b");
                        break;
                    case '\t':
                        writer.write("\\t");
                        break;
                    case '\n':
                        writer.write("\\n");
                        break;
                    case '\f':
                        writer.write("\\f");
                        break;
                    case '\r':
                        writer.write("\\r");
                        break;
                    case '\"':
                    case '\\':
                        writer.write(92);
                        writer.write(charAt);
                        break;
                    case '/':
                        if (c2 == '<') {
                            writer.write(92);
                        }
                        writer.write(charAt);
                        break;
                    default:
                        if (charAt < ' ' || ((charAt >= 128 && charAt < 160) || (charAt >= 8192 && charAt < 8448))) {
                            writer.write("\\u");
                            String hexString = Integer.toHexString(charAt);
                            writer.write("0000", 0, 4 - hexString.length());
                            writer.write(hexString);
                            break;
                        } else {
                            writer.write(charAt);
                            break;
                        }
                }
                i++;
                c2 = charAt;
            }
            writer.write(34);
        }
        return writer;
    }

    /* renamed from: k */
    public Object m15621k(String str) {
        return this.f12955c.remove(str);
    }

    /* renamed from: b */
    private static boolean m15594b(Number number) {
        if ((number instanceof Double) && (((Double) number).isInfinite() || ((Double) number).isNaN())) {
            return false;
        }
        return ((number instanceof Float) && (((Float) number).isInfinite() || ((Float) number).isNaN())) ? false : true;
    }

    /* renamed from: l */
    protected static boolean m15597l(String str) {
        return str.indexOf(46) > -1 || str.indexOf(101) > -1 || str.indexOf(69) > -1 || "-0".equals(str);
    }

    /* renamed from: m */
    protected static Number m15598m(String str) {
        char charAt = str.charAt(0);
        if ((charAt >= '0' && charAt <= '9') || charAt == '-') {
            if (m15597l(str)) {
                try {
                    BigDecimal bigDecimal = new BigDecimal(str);
                    if (charAt == '-' && BigDecimal.ZERO.compareTo(bigDecimal) == 0) {
                        return Double.valueOf(-0.0d);
                    }
                    return bigDecimal;
                } catch (NumberFormatException e2) {
                    try {
                        Double valueOf = Double.valueOf(str);
                        if (valueOf.isNaN() || valueOf.isInfinite()) {
                            throw new NumberFormatException("val [" + str + "] is not a valid number.");
                        }
                        return valueOf;
                    } catch (NumberFormatException e3) {
                        throw new NumberFormatException("val [" + str + "] is not a valid number.");
                    }
                }
            }
            if (charAt == '0' && str.length() > 1) {
                char charAt2 = str.charAt(1);
                if (charAt2 >= '0' && charAt2 <= '9') {
                    throw new NumberFormatException("val [" + str + "] is not a valid number.");
                }
            } else if (charAt == '-' && str.length() > 2) {
                char charAt3 = str.charAt(1);
                char charAt4 = str.charAt(2);
                if (charAt3 == '0' && charAt4 >= '0' && charAt4 <= '9') {
                    throw new NumberFormatException("val [" + str + "] is not a valid number.");
                }
            }
            BigInteger bigInteger = new BigInteger(str);
            if (bigInteger.bitLength() <= 31) {
                return Integer.valueOf(bigInteger.intValue());
            }
            if (bigInteger.bitLength() <= 63) {
                return Long.valueOf(bigInteger.longValue());
            }
            return bigInteger;
        }
        throw new NumberFormatException("val [" + str + "] is not a valid number.");
    }

    /* renamed from: n */
    public static Object m15599n(String str) {
        if (!"".equals(str)) {
            if ("true".equalsIgnoreCase(str)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(str)) {
                return Boolean.FALSE;
            }
            if ("null".equalsIgnoreCase(str)) {
                return f12954b;
            }
            char charAt = str.charAt(0);
            if ((charAt >= '0' && charAt <= '9') || charAt == '-') {
                try {
                    return m15598m(str);
                } catch (Exception e2) {
                    return str;
                }
            }
            return str;
        }
        return str;
    }

    /* renamed from: a */
    public static void m15591a(Object obj) {
        if ((obj instanceof Number) && !m15594b((Number) obj)) {
            throw new C2467b("JSON does not allow non-finite numbers.");
        }
    }

    public String toString() {
        try {
            return m15603a(0);
        } catch (Exception e2) {
            return null;
        }
    }

    /* renamed from: a */
    public String m15603a(int i) {
        String obj;
        StringWriter stringWriter = new StringWriter();
        synchronized (stringWriter.getBuffer()) {
            obj = m15601a(stringWriter, i, 0).toString();
        }
        return obj;
    }

    /* renamed from: b */
    public static Object m15593b(Object obj) {
        try {
            if (f12954b.equals(obj)) {
                return f12954b;
            }
            if (!(obj instanceof C2468c) && !(obj instanceof C2466a) && !f12954b.equals(obj) && !(obj instanceof InterfaceC2471f) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Short) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Boolean) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof String) && !(obj instanceof BigInteger) && !(obj instanceof BigDecimal) && !(obj instanceof Enum)) {
                if (obj instanceof Collection) {
                    return new C2466a((Collection<?>) obj);
                }
                if (obj.getClass().isArray()) {
                    return new C2466a(obj);
                }
                if (obj instanceof Map) {
                    return new C2468c((Map<?, ?>) obj);
                }
                Package r0 = obj.getClass().getPackage();
                String name = r0 != null ? r0.getName() : "";
                if (name.startsWith("java.") || name.startsWith("javax.") || obj.getClass().getClassLoader() == null) {
                    return obj.toString();
                }
                return new C2468c(obj);
            }
            return obj;
        } catch (Exception e2) {
            return null;
        }
    }

    /* renamed from: a */
    static final Writer m15584a(Writer writer, Object obj, int i, int i2) {
        if (obj == null || obj.equals(null)) {
            writer.write("null");
        } else if (obj instanceof InterfaceC2471f) {
            try {
                String m15623a = ((InterfaceC2471f) obj).m15623a();
                writer.write(m15623a != null ? m15623a.toString() : m15596j(obj.toString()));
            } catch (Exception e2) {
                throw new C2467b(e2);
            }
        } else if (obj instanceof Number) {
            String m15586a = m15586a((Number) obj);
            if (f12953a.matcher(m15586a).matches()) {
                writer.write(m15586a);
            } else {
                m15585a(m15586a, writer);
            }
        } else if (obj instanceof Boolean) {
            writer.write(obj.toString());
        } else if (obj instanceof Enum) {
            writer.write(m15596j(((Enum) obj).name()));
        } else if (obj instanceof C2468c) {
            ((C2468c) obj).m15601a(writer, i, i2);
        } else if (obj instanceof C2466a) {
            ((C2466a) obj).m15570a(writer, i, i2);
        } else if (obj instanceof Map) {
            new C2468c((Map<?, ?>) obj).m15601a(writer, i, i2);
        } else if (obj instanceof Collection) {
            new C2466a((Collection<?>) obj).m15570a(writer, i, i2);
        } else if (obj.getClass().isArray()) {
            new C2466a(obj).m15570a(writer, i, i2);
        } else {
            m15585a(obj.toString(), writer);
        }
        return writer;
    }

    /* renamed from: a */
    static final void m15590a(Writer writer, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            writer.write(32);
        }
    }

    /* renamed from: a */
    public Writer m15601a(Writer writer, int i, int i2) {
        try {
            int m15614d = m15614d();
            writer.write(123);
            if (m15614d == 1) {
                Map.Entry<String, Object> next = m15613c().iterator().next();
                String key = next.getKey();
                writer.write(m15596j(key));
                writer.write(58);
                if (i > 0) {
                    writer.write(32);
                }
                try {
                    m15584a(writer, next.getValue(), i, i2);
                    writer.write(125);
                    return writer;
                } catch (Exception e2) {
                    throw new C2467b("Unable to write JSONObject value for key: " + key, e2);
                }
            }
            if (m15614d != 0) {
                int i3 = i2 + i;
                boolean z = false;
                for (Map.Entry<String, Object> entry : m15613c()) {
                    if (z) {
                        writer.write(44);
                    }
                    if (i > 0) {
                        writer.write(10);
                    }
                    m15590a(writer, i3);
                    String key2 = entry.getKey();
                    writer.write(m15596j(key2));
                    writer.write(58);
                    if (i > 0) {
                        writer.write(32);
                    }
                    try {
                        m15584a(writer, entry.getValue(), i, i3);
                        z = true;
                    } catch (Exception e3) {
                        throw new C2467b("Unable to write JSONObject value for key: " + key2, e3);
                    }
                }
                if (i > 0) {
                    writer.write(10);
                }
                m15590a(writer, i2);
            }
            writer.write(125);
            return writer;
        } catch (IOException e4) {
            throw new C2467b(e4);
        }
    }

    /* renamed from: a */
    private static C2467b m15589a(String str, String str2, Throwable th) {
        return new C2467b("JSONObject[" + m15596j(str) + "] is not a " + str2 + ".", th);
    }
}
