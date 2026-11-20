package jadx.core.clsp;

import jadx.core.p183c.p191d.C1636b;
import jadx.core.p203d.p205b.C1729f;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: ClspGraph.java */
/* renamed from: jadx.core.clsp.a */
/* loaded from: classes.dex */
public class C1719a {

    /* renamed from: a */
    private static final InterfaceC2558b f10570a = C2568c.m15995a((Class<?>) C1719a.class);

    /* renamed from: c */
    private Map<String, C1720b> f10572c;

    /* renamed from: b */
    private final Map<String, Set<String>> f10571b = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: d */
    private final Set<String> f10573d = new HashSet();

    /* renamed from: a */
    public void m13178a() {
        ClsSet clsSet = new ClsSet();
        clsSet.m13170a();
        m13179a(clsSet);
    }

    /* renamed from: a */
    public void m13179a(ClsSet clsSet) {
        if (this.f10572c == null) {
            this.f10572c = new HashMap(clsSet.m13173b());
            clsSet.m13172a(this.f10572c);
            return;
        }
        throw new C1729f("Classpath already loaded");
    }

    /* renamed from: a */
    public void m13180a(List<C1636b> list) {
        if (this.f10572c == null) {
            throw new C1729f("Classpath must be loaded first");
        }
        int size = list.size();
        C1720b[] c1720bArr = new C1720b[size];
        Iterator<C1636b> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            c1720bArr[i] = m13174a(it.next());
            i++;
        }
        for (int i2 = 0; i2 < size; i2++) {
            c1720bArr[i2].m13184a(ClsSet.m13169a(list.get(i2), this.f10572c));
        }
    }

    /* renamed from: a */
    private C1720b m13174a(C1636b c1636b) {
        String m12543w = c1636b.m12543w();
        C1720b c1720b = new C1720b(m12543w, -1);
        this.f10572c.put(m12543w, c1720b);
        return c1720b;
    }

    /* renamed from: a */
    public boolean m13181a(String str, String str2) {
        return m13176a(str).contains(str2);
    }

    /* renamed from: b */
    public String m13182b(String str, String str2) {
        if (!str.equals(str2)) {
            C1720b c1720b = this.f10572c.get(str2);
            if (c1720b != null) {
                return m13181a(str, str2) ? str2 : m13175a(m13176a(str), c1720b);
            }
            this.f10573d.add(str);
            return null;
        }
        return str;
    }

    /* renamed from: a */
    private String m13175a(Set<String> set, C1720b c1720b) {
        for (C1720b c1720b2 : c1720b.m13185b()) {
            String m13183a = c1720b2.m13183a();
            if (set.contains(m13183a)) {
                return m13183a;
            }
            String m13175a = m13175a(set, c1720b2);
            if (m13175a != null) {
                return m13175a;
            }
        }
        return null;
    }

    /* renamed from: a */
    private Set<String> m13176a(String str) {
        Set<String> set = this.f10571b.get(str);
        if (set == null) {
            C1720b c1720b = this.f10572c.get(str);
            if (c1720b == null) {
                this.f10573d.add(str);
                return Collections.emptySet();
            }
            HashSet hashSet = new HashSet();
            m13177a(c1720b, hashSet);
            Set<String> emptySet = hashSet.isEmpty() ? Collections.emptySet() : hashSet;
            this.f10571b.put(str, emptySet);
            return emptySet;
        }
        return set;
    }

    /* renamed from: a */
    private void m13177a(C1720b c1720b, Set<String> set) {
        if (set.add(c1720b.m13183a())) {
            for (C1720b c1720b2 : c1720b.m13185b()) {
                m13177a(c1720b2, set);
            }
        }
    }
}
