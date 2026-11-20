package p165d.p167b.p172e;

import java.security.AlgorithmParameters;
import java.security.Key;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: DisabledAlgorithmConstraints.java */
/* renamed from: d.b.e.n */
/* loaded from: classes.dex */
public class C1451n extends AbstractC1438a {

    /* renamed from: b */
    private static final C1444g f9359b = C1444g.m11327a("certpath");

    /* renamed from: c */
    private final b f9360c;

    /* renamed from: d */
    private final String[] f9361d;

    public C1451n(String str) {
        this(str, new C1439b());
    }

    public C1451n(String str, C1439b c1439b) {
        super(c1439b);
        this.f9361d = m11312a(str);
        this.f9360c = new b(this.f9361d);
    }

    /* renamed from: a */
    public final boolean m11444a(Set<EnumC1443f> set, String str, AlgorithmParameters algorithmParameters) {
        if (set == null || set.isEmpty()) {
            throw new IllegalArgumentException("No cryptographic primitive specified");
        }
        return m11311a(this.f9361d, str, this.f9320a);
    }

    /* renamed from: a */
    public final boolean m11445a(Set<EnumC1443f> set, Key key) {
        return m11443a(set, "", key, null);
    }

    /* renamed from: a */
    private boolean m11443a(Set<EnumC1443f> set, String str, Key key, AlgorithmParameters algorithmParameters) {
        if (key == null) {
            throw new IllegalArgumentException("The key cannot be null");
        }
        if ((str == null || str.length() == 0 || m11444a(set, str, algorithmParameters)) && m11444a(set, key.getAlgorithm(), (AlgorithmParameters) null)) {
            return this.f9360c.m11448a(key);
        }
        return false;
    }

    /* compiled from: DisabledAlgorithmConstraints.java */
    /* renamed from: d.b.e.n$b */
    private static class b {

        /* renamed from: a */
        private static final Pattern f9364a = Pattern.compile("keySize\\s*(<=|<|==|!=|>|>=)\\s*(\\d+)");

        /* renamed from: b */
        private Map<String, Set<a>> f9365b = new HashMap();

        public b(String[] strArr) {
            boolean z;
            a aVar;
            for (String str : strArr) {
                if (str != null && !str.isEmpty()) {
                    String trim = str.trim();
                    if (C1451n.f9359b != null) {
                        C1451n.f9359b.m11333c("Constraints: " + trim);
                    }
                    int indexOf = trim.indexOf(32);
                    if (indexOf > 0) {
                        String m11314a = C1439b.m11314a(trim.substring(0, indexOf).toUpperCase(Locale.ENGLISH));
                        String substring = trim.substring(indexOf + 1);
                        a aVar2 = null;
                        boolean z2 = false;
                        String[] split = substring.split("&");
                        int length = split.length;
                        a aVar3 = null;
                        int i = 0;
                        while (i < length) {
                            String trim2 = split[i].trim();
                            Matcher matcher = f9364a.matcher(trim2);
                            if (matcher.matches()) {
                                if (C1451n.f9359b != null) {
                                    C1451n.f9359b.m11333c("Constraints set to keySize: " + trim2);
                                }
                                aVar = new c(m11314a, c.a.valueOf(matcher.group(1)), Integer.parseInt(matcher.group(2)));
                                z = z2;
                            } else if (trim2.equalsIgnoreCase("jdkCA")) {
                                if (C1451n.f9359b != null) {
                                    C1451n.f9359b.m11333c("Constraints set to jdkCA.");
                                }
                                if (z2) {
                                    throw new IllegalArgumentException("Only one jdkCA entry allowed in property. Constraint: " + trim);
                                }
                                aVar = new d(m11314a);
                                z = true;
                            } else {
                                z = z2;
                                aVar = aVar2;
                            }
                            if (aVar3 == null) {
                                if (!this.f9365b.containsKey(m11314a)) {
                                    this.f9365b.put(m11314a, new HashSet());
                                }
                                if (aVar != null) {
                                    this.f9365b.get(m11314a).add(aVar);
                                }
                            } else {
                                aVar3.f9363b = aVar;
                            }
                            i++;
                            z2 = z;
                            aVar3 = aVar;
                            aVar2 = aVar;
                        }
                    } else {
                        String upperCase = trim.toUpperCase(Locale.ENGLISH);
                        if (this.f9365b.get(upperCase) == null) {
                            this.f9365b.put(upperCase, new HashSet());
                        }
                    }
                }
            }
        }

        /* renamed from: a */
        private Set<a> m11447a(String str) {
            return this.f9365b.get(str);
        }

        /* renamed from: a */
        public boolean m11448a(Key key) {
            Set<a> m11447a = m11447a(key.getAlgorithm());
            if (m11447a == null) {
                return true;
            }
            Iterator<a> it = m11447a.iterator();
            while (it.hasNext()) {
                if (!it.next().mo11446a(key)) {
                    if (C1451n.f9359b != null) {
                        C1451n.f9359b.m11333c("keySizeConstraint: failed key constraint check " + C1452o.m11451a(key));
                    }
                    return false;
                }
            }
            return true;
        }
    }

    /* compiled from: DisabledAlgorithmConstraints.java */
    /* renamed from: d.b.e.n$a */
    private static abstract class a {

        /* renamed from: a */
        String f9362a;

        /* renamed from: b */
        a f9363b;

        private a() {
            this.f9363b = null;
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* renamed from: a */
        public boolean mo11446a(Key key) {
            return true;
        }
    }

    /* compiled from: DisabledAlgorithmConstraints.java */
    /* renamed from: d.b.e.n$d */
    private static class d extends a {
        d(String str) {
            super(null);
            this.f9362a = str;
        }
    }

    /* compiled from: DisabledAlgorithmConstraints.java */
    /* renamed from: d.b.e.n$c */
    private static class c extends a {

        /* renamed from: c */
        private static int[] f9366c;

        /* renamed from: d */
        private int f9367d;

        /* renamed from: e */
        private int f9368e;

        /* renamed from: f */
        private int f9369f;

        /* compiled from: DisabledAlgorithmConstraints.java */
        /* renamed from: d.b.e.n$c$a */
        public enum a {
            EQ,
            NE,
            LT,
            LE,
            GT,
            GE;

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static a[] valuesCustom() {
                a[] valuesCustom = values();
                int length = valuesCustom.length;
                a[] aVarArr = new a[length];
                System.arraycopy(valuesCustom, 0, aVarArr, 0, length);
                return aVarArr;
            }
        }

        /* renamed from: a */
        static /* synthetic */ int[] m11449a() {
            int[] iArr = f9366c;
            if (iArr == null) {
                iArr = new int[a.valuesCustom().length];
                try {
                    iArr[a.EQ.ordinal()] = 1;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[a.GE.ordinal()] = 6;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[a.GT.ordinal()] = 5;
                } catch (NoSuchFieldError e4) {
                }
                try {
                    iArr[a.LE.ordinal()] = 4;
                } catch (NoSuchFieldError e5) {
                }
                try {
                    iArr[a.LT.ordinal()] = 3;
                } catch (NoSuchFieldError e6) {
                }
                try {
                    iArr[a.NE.ordinal()] = 2;
                } catch (NoSuchFieldError e7) {
                }
                f9366c = iArr;
            }
            return iArr;
        }

        public c(String str, a aVar, int i) {
            super(null);
            this.f9369f = -1;
            this.f9362a = str;
            switch (m11449a()[aVar.ordinal()]) {
                case 1:
                    this.f9368e = 0;
                    this.f9367d = Integer.MAX_VALUE;
                    this.f9369f = i;
                    break;
                case 2:
                    this.f9368e = i;
                    this.f9367d = i;
                    break;
                case 3:
                    this.f9368e = i;
                    this.f9367d = Integer.MAX_VALUE;
                    break;
                case 4:
                    this.f9368e = i + 1;
                    this.f9367d = Integer.MAX_VALUE;
                    break;
                case 5:
                    this.f9368e = 0;
                    this.f9367d = i;
                    break;
                case 6:
                    this.f9368e = 0;
                    this.f9367d = i > 1 ? i - 1 : 0;
                    break;
                default:
                    this.f9368e = Integer.MAX_VALUE;
                    this.f9367d = -1;
                    break;
            }
        }

        @Override // p165d.p167b.p172e.C1451n.a
        /* renamed from: a */
        public boolean mo11446a(Key key) {
            if (this.f9363b == null || !this.f9363b.mo11446a(key)) {
                if (C1451n.f9359b != null) {
                    C1451n.f9359b.m11333c("KeySizeConstraints.permits(): " + this.f9362a);
                }
                return m11450b(key);
            }
            return true;
        }

        /* renamed from: b */
        private boolean m11450b(Key key) {
            if (this.f9362a.compareToIgnoreCase(key.getAlgorithm()) != 0) {
                return true;
            }
            int m11451a = C1452o.m11451a(key);
            if (m11451a == 0) {
                return false;
            }
            if (m11451a > 0) {
                return m11451a >= this.f9368e && m11451a <= this.f9367d && this.f9369f != m11451a;
            }
            return true;
        }
    }
}
