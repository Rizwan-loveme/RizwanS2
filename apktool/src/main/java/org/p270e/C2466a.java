package org.p270e;

import android.app.slice.SliceItem;
import java.lang.reflect.Array;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: JSONArray.java */
/* renamed from: org.e.a */
/* loaded from: classes.dex */
public class C2466a implements Iterable<Object> {

    /* renamed from: a */
    private final ArrayList<Object> f12952a;

    public C2466a() {
        this.f12952a = new ArrayList<>();
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
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:100)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:100)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public C2466a(org.p270e.C2472g r4) {
        /*
            r3 = this;
            r2 = 93
            r3.<init>()
            char r0 = r4.m15633d()
            r1 = 91
            if (r0 == r1) goto L14
            java.lang.String r0 = "A JSONArray text must start with '['"
            org.e.b r0 = r4.m15628a(r0)
            throw r0
        L14:
            char r0 = r4.m15633d()
            if (r0 != 0) goto L21
            java.lang.String r0 = "Expected a ',' or ']'"
            org.e.b r0 = r4.m15628a(r0)
            throw r0
        L21:
            if (r0 == r2) goto L69
            r4.m15630a()
        L26:
            char r0 = r4.m15633d()
            r1 = 44
            if (r0 != r1) goto L46
            r4.m15630a()
            java.util.ArrayList<java.lang.Object> r0 = r3.f12952a
            java.lang.Object r1 = org.p270e.C2468c.f12954b
            r0.add(r1)
        L38:
            char r0 = r4.m15633d()
            switch(r0) {
                case 0: goto L53;
                case 44: goto L5a;
                case 93: goto L69;
                default: goto L3f;
            }
        L3f:
            java.lang.String r0 = "Expected a ',' or ']'"
            org.e.b r0 = r4.m15628a(r0)
            throw r0
        L46:
            r4.m15630a()
            java.util.ArrayList<java.lang.Object> r0 = r3.f12952a
            java.lang.Object r1 = r4.m15634e()
            r0.add(r1)
            goto L38
        L53:
            java.lang.String r0 = "Expected a ',' or ']'"
            org.e.b r0 = r4.m15628a(r0)
            throw r0
        L5a:
            char r0 = r4.m15633d()
            if (r0 != 0) goto L67
            java.lang.String r0 = "Expected a ',' or ']'"
            org.e.b r0 = r4.m15628a(r0)
            throw r0
        L67:
            if (r0 != r2) goto L6a
        L69:
            return
        L6a:
            r4.m15630a()
            goto L26
        */
        throw new UnsupportedOperationException("Method not decompiled: org.p270e.C2466a.<init>(org.e.g):void");
    }

    public C2466a(String str) {
        this(new C2472g(str));
    }

    public C2466a(Collection<?> collection) {
        if (collection == null) {
            this.f12952a = new ArrayList<>();
        } else {
            this.f12952a = new ArrayList<>(collection.size());
            m15568a(collection, true);
        }
    }

    public C2466a(Object obj) {
        this();
        if (!obj.getClass().isArray()) {
            throw new C2467b("JSONArray initial value should be a string or collection or array.");
        }
        m15567a(obj, true);
    }

    @Override // java.lang.Iterable
    public Iterator<Object> iterator() {
        return this.f12952a.iterator();
    }

    /* renamed from: a */
    public Object m15571a(int i) {
        Object m15581h = m15581h(i);
        if (m15581h == null) {
            throw new C2467b("JSONArray[" + i + "] not found.");
        }
        return m15581h;
    }

    /* renamed from: b */
    public int m15575b(int i) {
        Object m15571a = m15571a(i);
        if (m15571a instanceof Number) {
            return ((Number) m15571a).intValue();
        }
        try {
            return Integer.parseInt(m15571a.toString());
        } catch (Exception e2) {
            throw m15565a(i, SliceItem.FORMAT_INT, e2);
        }
    }

    /* renamed from: c */
    public C2466a m15576c(int i) {
        Object m15571a = m15571a(i);
        if (m15571a instanceof C2466a) {
            return (C2466a) m15571a;
        }
        throw m15565a(i, "JSONArray", (Throwable) null);
    }

    /* renamed from: d */
    public C2468c m15577d(int i) {
        Object m15571a = m15571a(i);
        if (m15571a instanceof C2468c) {
            return (C2468c) m15571a;
        }
        throw m15565a(i, "JSONObject", (Throwable) null);
    }

    /* renamed from: e */
    public long m15578e(int i) {
        Object m15571a = m15571a(i);
        if (m15571a instanceof Number) {
            return ((Number) m15571a).longValue();
        }
        try {
            return Long.parseLong(m15571a.toString());
        } catch (Exception e2) {
            throw m15565a(i, SliceItem.FORMAT_LONG, e2);
        }
    }

    /* renamed from: f */
    public String m15579f(int i) {
        Object m15571a = m15571a(i);
        if (m15571a instanceof String) {
            return (String) m15571a;
        }
        throw m15565a(i, "String", (Throwable) null);
    }

    /* renamed from: g */
    public boolean m15580g(int i) {
        return C2468c.f12954b.equals(m15581h(i));
    }

    /* renamed from: a */
    public int m15569a() {
        return this.f12952a.size();
    }

    /* renamed from: h */
    public Object m15581h(int i) {
        if (i < 0 || i >= m15569a()) {
            return null;
        }
        return this.f12952a.get(i);
    }

    /* renamed from: i */
    public C2466a m15582i(int i) {
        return m15574a(Integer.valueOf(i));
    }

    /* renamed from: a */
    public C2466a m15574a(Object obj) {
        C2468c.m15591a(obj);
        this.f12952a.add(obj);
        return this;
    }

    /* renamed from: a */
    public C2466a m15573a(int i, boolean z) {
        return m15572a(i, z ? Boolean.TRUE : Boolean.FALSE);
    }

    /* renamed from: a */
    public C2466a m15572a(int i, Object obj) {
        if (i < 0) {
            throw new C2467b("JSONArray[" + i + "] not found.");
        }
        if (i < m15569a()) {
            C2468c.m15591a(obj);
            this.f12952a.set(i, obj);
            return this;
        }
        if (i == m15569a()) {
            return m15574a(obj);
        }
        this.f12952a.ensureCapacity(i + 1);
        while (i != m15569a()) {
            this.f12952a.add(C2468c.f12954b);
        }
        return m15574a(obj);
    }

    public String toString() {
        try {
            return m15583j(0);
        } catch (Exception e2) {
            return null;
        }
    }

    /* renamed from: j */
    public String m15583j(int i) {
        String obj;
        StringWriter stringWriter = new StringWriter();
        synchronized (stringWriter.getBuffer()) {
            obj = m15570a(stringWriter, i, 0).toString();
        }
        return obj;
    }

    /* renamed from: a */
    public Writer m15570a(Writer writer, int i, int i2) {
        try {
            int m15569a = m15569a();
            writer.write(91);
            if (m15569a == 1) {
                try {
                    C2468c.m15584a(writer, this.f12952a.get(0), i, i2);
                    writer.write(93);
                    return writer;
                } catch (Exception e2) {
                    throw new C2467b("Unable to write JSONArray value at index: 0", e2);
                }
            }
            if (m15569a != 0) {
                int i3 = i2 + i;
                int i4 = 0;
                boolean z = false;
                while (i4 < m15569a) {
                    if (z) {
                        writer.write(44);
                    }
                    if (i > 0) {
                        writer.write(10);
                    }
                    C2468c.m15590a(writer, i3);
                    try {
                        C2468c.m15584a(writer, this.f12952a.get(i4), i, i3);
                        i4++;
                        z = true;
                    } catch (Exception e3) {
                        throw new C2467b("Unable to write JSONArray value at index: " + i4, e3);
                    }
                }
                if (i > 0) {
                    writer.write(10);
                }
                C2468c.m15590a(writer, i2);
            }
            writer.write(93);
            return writer;
        } catch (IOException e4) {
            throw new C2467b(e4);
        }
    }

    /* renamed from: a */
    private void m15568a(Collection<?> collection, boolean z) {
        this.f12952a.ensureCapacity(this.f12952a.size() + collection.size());
        if (z) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                m15574a(C2468c.m15593b(it.next()));
            }
        } else {
            Iterator<?> it2 = collection.iterator();
            while (it2.hasNext()) {
                m15574a(it2.next());
            }
        }
    }

    /* renamed from: a */
    private void m15566a(Iterable<?> iterable, boolean z) {
        if (z) {
            Iterator<?> it = iterable.iterator();
            while (it.hasNext()) {
                m15574a(C2468c.m15593b(it.next()));
            }
        } else {
            Iterator<?> it2 = iterable.iterator();
            while (it2.hasNext()) {
                m15574a(it2.next());
            }
        }
    }

    /* renamed from: a */
    private void m15567a(Object obj, boolean z) {
        int i = 0;
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            this.f12952a.ensureCapacity(this.f12952a.size() + length);
            if (z) {
                while (i < length) {
                    m15574a(C2468c.m15593b(Array.get(obj, i)));
                    i++;
                }
                return;
            } else {
                while (i < length) {
                    m15574a(Array.get(obj, i));
                    i++;
                }
                return;
            }
        }
        if (obj instanceof C2466a) {
            this.f12952a.addAll(((C2466a) obj).f12952a);
        } else if (obj instanceof Collection) {
            m15568a((Collection<?>) obj, z);
        } else {
            if (obj instanceof Iterable) {
                m15566a((Iterable<?>) obj, z);
                return;
            }
            throw new C2467b("JSONArray initial value should be a string or collection or array.");
        }
    }

    /* renamed from: a */
    private static C2467b m15565a(int i, String str, Throwable th) {
        return new C2467b("JSONArray[" + i + "] is not a " + str + ".", th);
    }
}
