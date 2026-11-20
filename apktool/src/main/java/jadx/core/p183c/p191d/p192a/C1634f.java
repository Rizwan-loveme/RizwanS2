package jadx.core.p183c.p191d.p192a;

import jadx.core.p183c.p184a.InterfaceC1588h;
import jadx.core.p183c.p184a.p185a.C1563a;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p203d.p205b.C1729f;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: SignatureParser.java */
/* renamed from: jadx.core.c.d.a.f */
/* loaded from: classes.dex */
public class C1634f {

    /* renamed from: a */
    private static final InterfaceC2558b f10333a = C2568c.m15995a((Class<?>) C1634f.class);

    /* renamed from: b */
    private final String f10334b;

    /* renamed from: c */
    private final int f10335c;

    /* renamed from: d */
    private int f10336d = -1;

    /* renamed from: e */
    private int f10337e = 0;

    public C1634f(String str) {
        this.f10334b = str;
        this.f10335c = this.f10334b.length();
    }

    /* renamed from: a */
    public static C1634f m12485a(InterfaceC1588h interfaceC1588h) {
        C1563a mo12139a = interfaceC1588h.mo12139a("dalvik.annotation.Signature");
        if (mo12139a == null) {
            return null;
        }
        return new C1634f(m12486a((List<String>) mo12139a.m12082d()));
    }

    /* renamed from: d */
    private char m12490d() {
        this.f10336d++;
        if (this.f10336d >= this.f10335c) {
            return (char) 0;
        }
        return this.f10334b.charAt(this.f10336d);
    }

    /* renamed from: a */
    private boolean m12487a(char c2) {
        int i = this.f10336d + 1;
        return i < this.f10335c && this.f10334b.charAt(i) == c2;
    }

    /* renamed from: e */
    private void m12493e() {
        this.f10337e = this.f10336d;
    }

    /* renamed from: f */
    private String m12494f() {
        return this.f10337e >= this.f10336d ? "" : this.f10334b.substring(this.f10337e, this.f10336d);
    }

    /* renamed from: g */
    private String m12495g() {
        return this.f10337e >= this.f10336d ? "" : this.f10334b.substring(this.f10337e, this.f10336d + 1);
    }

    /* renamed from: b */
    private boolean m12488b(char c2) {
        char m12490d;
        int i = this.f10336d;
        do {
            m12490d = m12490d();
            if (m12490d == 0) {
                this.f10336d = i;
                return false;
            }
        } while (m12490d != c2);
        return true;
    }

    /* renamed from: c */
    private void m12489c(char c2) {
        char m12490d = m12490d();
        if (c2 != m12490d) {
            throw new C1729f("Consume wrong char: '" + m12490d + "' != '" + c2 + "', sign: " + m12498j());
        }
    }

    /* renamed from: d */
    private boolean m12491d(char c2) {
        if (!m12487a(c2)) {
            return false;
        }
        m12490d();
        return true;
    }

    /* renamed from: e */
    private String m12492e(char c2) {
        m12493e();
        if (m12488b(c2)) {
            return m12494f();
        }
        return null;
    }

    /* renamed from: a */
    public AbstractC1596a m12499a() {
        char m12490d = m12490d();
        m12493e();
        switch (m12490d) {
            case 0:
                return null;
            case 'L':
                AbstractC1596a m12484a = m12484a(false);
                if (m12484a != null) {
                    return m12484a;
                }
                break;
            case 'T':
                m12490d();
                m12493e();
                if (m12488b(';')) {
                    return AbstractC1596a.m12267b(m12494f());
                }
                break;
            case '[':
                return AbstractC1596a.m12258a(m12499a());
            default:
                AbstractC1596a m12257a = AbstractC1596a.m12257a(m12490d);
                if (m12257a != null) {
                    return m12257a;
                }
                break;
        }
        throw new C1729f("Can't parse type: " + m12498j());
    }

    /* renamed from: a */
    private AbstractC1596a m12484a(boolean z) {
        char m12490d;
        String m12495g;
        m12493e();
        do {
            m12490d = m12490d();
            if (m12490d == 0) {
                return null;
            }
            if (m12490d == '<') {
                break;
            }
        } while (m12490d != ';');
        if (m12490d == ';') {
            if (z) {
                m12495g = m12494f().replace('/', '.');
            } else {
                m12495g = m12495g();
            }
            return AbstractC1596a.m12263a(m12495g);
        }
        String m12494f = m12494f();
        if (!z) {
            m12494f = String.valueOf(m12494f) + ";";
        }
        AbstractC1596a[] m12496h = m12496h();
        m12489c('>');
        AbstractC1596a m12264a = AbstractC1596a.m12264a(m12494f, m12496h);
        if (m12487a('.')) {
            m12489c('.');
            m12490d();
            AbstractC1596a m12484a = m12484a(true);
            if (m12484a == null) {
                throw new C1729f("No inner type found: " + m12498j());
            }
            return AbstractC1596a.m12260a(m12264a, m12484a.mo12279e(), m12484a.mo12283i());
        }
        m12489c(';');
        return m12264a;
    }

    /* renamed from: h */
    private AbstractC1596a[] m12496h() {
        AbstractC1596a m12499a;
        LinkedList linkedList = new LinkedList();
        do {
            if (m12487a('*')) {
                m12490d();
                m12499a = AbstractC1596a.m12256a();
            } else if (m12487a('+')) {
                m12490d();
                m12499a = AbstractC1596a.m12259a(m12499a(), 1);
            } else if (m12487a('-')) {
                m12490d();
                m12499a = AbstractC1596a.m12259a(m12499a(), -1);
            } else {
                m12499a = m12499a();
            }
            if (m12499a != null) {
                linkedList.add(m12499a);
            }
            if (m12499a == null) {
                break;
            }
        } while (!m12487a('>'));
        return (AbstractC1596a[]) linkedList.toArray(new AbstractC1596a[linkedList.size()]);
    }

    /* renamed from: b */
    public Map<AbstractC1596a, List<AbstractC1596a>> m12500b() {
        if (!m12487a('<')) {
            return Collections.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(2);
        m12489c('<');
        while (!m12487a('>') && m12490d() != 0) {
            String m12492e = m12492e(':');
            if (m12492e == null) {
                f10333a.mo15946d("Can't parse generic map: {}", this.f10334b);
                return Collections.emptyMap();
            }
            m12491d(':');
            linkedHashMap.put(AbstractC1596a.m12267b(m12492e), m12497i());
        }
        m12489c('>');
        return linkedHashMap;
    }

    /* renamed from: i */
    private List<AbstractC1596a> m12497i() {
        boolean m12487a;
        List<AbstractC1596a> emptyList = Collections.emptyList();
        do {
            AbstractC1596a m12499a = m12499a();
            if (!m12499a.equals(AbstractC1596a.f10134j)) {
                if (emptyList.isEmpty()) {
                    emptyList = new LinkedList<>();
                }
                emptyList.add(m12499a);
            }
            m12487a = m12487a(':');
            if (m12487a) {
                m12489c(':');
            }
        } while (m12487a);
        return emptyList;
    }

    /* renamed from: c */
    public List<AbstractC1596a> m12501c() {
        m12489c('(');
        if (m12487a(')')) {
            m12489c(')');
            return Collections.emptyList();
        }
        LinkedList linkedList = new LinkedList();
        do {
            linkedList.add(m12499a());
        } while (!m12487a(')'));
        m12489c(')');
        return linkedList;
    }

    /* renamed from: a */
    private static String m12486a(List<String> list) {
        if (list.size() == 1) {
            return list.get(0);
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    /* renamed from: j */
    private String m12498j() {
        return this.f10336d >= this.f10334b.length() ? this.f10334b : String.valueOf(this.f10334b) + " at position " + this.f10336d + " ('" + this.f10334b.charAt(this.f10336d) + "')";
    }

    public String toString() {
        return this.f10336d == -1 ? this.f10334b : String.valueOf(this.f10334b.substring(0, this.f10337e)) + '{' + this.f10334b.substring(this.f10337e, this.f10336d) + '}' + this.f10334b.substring(this.f10336d);
    }
}
