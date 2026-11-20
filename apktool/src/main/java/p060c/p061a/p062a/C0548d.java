package p060c.p061a.p062a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import p060c.p061a.C0544a;
import p060c.p061a.C0551b;

/* compiled from: AxmlWriter.java */
/* renamed from: c.a.a.d */
/* loaded from: classes.dex */
public class C0548d extends C0547c {

    /* renamed from: a */
    static final Comparator<a> f3664a = new Comparator<a>() { // from class: c.a.a.d.1
        @Override // java.util.Comparator
        public int compare(a aVar, a aVar2) {
            return m4027a(aVar, aVar2);
        }

        /* renamed from: a */
        public int m4027a(a aVar, a aVar2) {
            int i = aVar.f3675d - aVar2.f3675d;
            if (i != 0 || (i = aVar.f3673b.f3643a.compareTo(aVar2.f3673b.f3643a)) != 0) {
                return i;
            }
            boolean z = aVar.f3674c == null;
            boolean z2 = aVar2.f3674c == null;
            if (z) {
                return z2 ? 0 : -1;
            }
            if (z2) {
                return 1;
            }
            return aVar.f3674c.f3643a.compareTo(aVar2.f3674c.f3643a);
        }
    };

    /* renamed from: b */
    private List<b> f3665b = new ArrayList(3);

    /* renamed from: c */
    private Map<String, c> f3666c = new HashMap();

    /* renamed from: e */
    private List<C0544a> f3667e = new ArrayList();

    /* renamed from: f */
    private Map<String, C0544a> f3668f = new HashMap();

    /* renamed from: g */
    private List<Integer> f3669g = new ArrayList();

    /* renamed from: h */
    private List<C0544a> f3670h = new ArrayList();

    /* renamed from: i */
    private C0551b f3671i = new C0551b();

    @Override // p060c.p061a.p062a.AbstractC0549e
    /* renamed from: a */
    public void mo4024a() {
    }

    /* compiled from: AxmlWriter.java */
    /* renamed from: c.a.a.d$a */
    static class a {

        /* renamed from: a */
        public int f3672a;

        /* renamed from: b */
        public C0544a f3673b;

        /* renamed from: c */
        public C0544a f3674c;

        /* renamed from: d */
        public int f3675d;

        /* renamed from: e */
        public int f3676e;

        /* renamed from: f */
        public Object f3677f;

        /* renamed from: g */
        public C0544a f3678g;

        public a(C0544a c0544a, C0544a c0544a2, int i) {
            this.f3674c = c0544a;
            this.f3673b = c0544a2;
            this.f3675d = i;
        }

        /* renamed from: a */
        public void m4028a(C0548d c0548d) {
            this.f3674c = c0548d.m4025b(this.f3674c);
            if (this.f3673b != null) {
                if (this.f3675d != -1) {
                    this.f3673b = c0548d.m4023a(this.f3673b, this.f3675d);
                } else {
                    this.f3673b = c0548d.m4022a(this.f3673b);
                }
            }
            if (this.f3677f instanceof C0544a) {
                this.f3677f = c0548d.m4022a((C0544a) this.f3677f);
            }
            if (this.f3678g != null) {
                this.f3678g = c0548d.m4022a(this.f3678g);
            }
        }
    }

    /* compiled from: AxmlWriter.java */
    /* renamed from: c.a.a.d$b */
    static class b extends AbstractC0549e {

        /* renamed from: a */
        a f3679a;

        /* renamed from: b */
        a f3680b;

        /* renamed from: c */
        a f3681c;

        /* renamed from: e */
        private Set<a> f3682e;

        /* renamed from: f */
        private List<b> f3683f;

        /* renamed from: g */
        private int f3684g;

        /* renamed from: h */
        private C0544a f3685h;

        /* renamed from: i */
        private C0544a f3686i;

        /* renamed from: j */
        private C0544a f3687j;

        /* renamed from: k */
        private int f3688k;

        @Override // p060c.p061a.p062a.AbstractC0549e
        /* renamed from: a */
        public void mo4024a() {
        }

        public b(String str, String str2) {
            super((AbstractC0549e) null);
            this.f3682e = new TreeSet(C0548d.f3664a);
            this.f3683f = new ArrayList();
            this.f3686i = str == null ? (C0544a) null : new C0544a(str);
            this.f3685h = str2 == null ? (C0544a) null : new C0544a(str2);
        }

        @Override // p060c.p061a.p062a.AbstractC0549e
        /* renamed from: a */
        public void mo4032a(String str, String str2, int i, int i2, Object obj) {
            if (str2 == null) {
                throw new RuntimeException("name can't be null");
            }
            a aVar = new a(str == null ? (C0544a) null : new C0544a(str), new C0544a(str2), i);
            aVar.f3676e = i2;
            if (obj instanceof C0550f) {
                C0550f c0550f = (C0550f) obj;
                if (c0550f.f3694b != null) {
                    aVar.f3678g = new C0544a(c0550f.f3694b);
                }
                aVar.f3677f = new Integer(c0550f.f3695c);
                switch (c0550f.f3693a) {
                    case 1:
                        this.f3679a = aVar;
                        break;
                    case 2:
                        this.f3680b = aVar;
                        break;
                    case 3:
                        this.f3681c = aVar;
                        break;
                }
            } else if (i2 == 3) {
                C0544a c0544a = new C0544a((String) obj);
                aVar.f3678g = c0544a;
                aVar.f3677f = c0544a;
            } else {
                aVar.f3678g = (C0544a) null;
                aVar.f3677f = obj;
            }
            this.f3682e.add(aVar);
        }

        @Override // p060c.p061a.p062a.AbstractC0549e
        /* renamed from: a */
        public AbstractC0549e mo4019a(String str, String str2) {
            b bVar = new b(str, str2);
            this.f3683f.add(bVar);
            return bVar;
        }

        @Override // p060c.p061a.p062a.AbstractC0549e
        /* renamed from: a */
        public void mo4030a(int i) {
            this.f3684g = i;
        }

        /* renamed from: a */
        public int m4029a(C0548d c0548d) {
            this.f3686i = c0548d.m4025b(this.f3686i);
            this.f3685h = c0548d.m4022a(this.f3685h);
            int i = 0;
            for (a aVar : this.f3682e) {
                aVar.f3672a = i;
                aVar.m4028a(c0548d);
                i++;
            }
            this.f3687j = c0548d.m4022a(this.f3687j);
            int size = (this.f3682e.size() * 20) + 60;
            Iterator<b> it = this.f3683f.iterator();
            while (it.hasNext()) {
                size = it.next().m4029a(c0548d) + size;
            }
            if (this.f3687j != null) {
                return size + 28;
            }
            return size;
        }

        @Override // p060c.p061a.p062a.AbstractC0549e
        /* renamed from: a */
        public void mo4031a(int i, String str) {
            this.f3687j = new C0544a(str);
            this.f3688k = i;
        }

        /* renamed from: a */
        void m4033a(ByteBuffer byteBuffer) {
            byteBuffer.putInt(1048834);
            byteBuffer.putInt((this.f3682e.size() * 20) + 36);
            byteBuffer.putInt(this.f3684g);
            byteBuffer.putInt(-1);
            byteBuffer.putInt(this.f3686i != null ? this.f3686i.f3645c : -1);
            byteBuffer.putInt(this.f3685h.f3645c);
            byteBuffer.putInt(1310740);
            byteBuffer.putShort((short) this.f3682e.size());
            byteBuffer.putShort((short) (this.f3679a == null ? 0 : this.f3679a.f3672a + 1));
            byteBuffer.putShort((short) (this.f3681c == null ? 0 : this.f3681c.f3672a + 1));
            byteBuffer.putShort((short) (this.f3680b == null ? 0 : this.f3680b.f3672a + 1));
            for (a aVar : this.f3682e) {
                byteBuffer.putInt(aVar.f3674c == null ? -1 : aVar.f3674c.f3645c);
                byteBuffer.putInt(aVar.f3673b.f3645c);
                byteBuffer.putInt(aVar.f3678g != null ? aVar.f3678g.f3645c : -1);
                byteBuffer.putInt((aVar.f3676e << 24) | 8);
                Object obj = aVar.f3677f;
                if (obj instanceof C0544a) {
                    byteBuffer.putInt(((C0544a) aVar.f3677f).f3645c);
                } else if (obj instanceof Boolean) {
                    byteBuffer.putInt(Boolean.TRUE.equals(obj) ? -1 : 0);
                } else if (obj instanceof Float) {
                    byteBuffer.putInt(Float.floatToIntBits(((Float) obj).floatValue()));
                } else {
                    byteBuffer.putInt(((Integer) aVar.f3677f).intValue());
                }
            }
            if (this.f3687j != null) {
                byteBuffer.putInt(1048836);
                byteBuffer.putInt(28);
                byteBuffer.putInt(this.f3688k);
                byteBuffer.putInt(-1);
                byteBuffer.putInt(this.f3687j.f3645c);
                byteBuffer.putInt(8);
                byteBuffer.putInt(0);
            }
            Iterator<b> it = this.f3683f.iterator();
            while (it.hasNext()) {
                it.next().m4033a(byteBuffer);
            }
            byteBuffer.putInt(1048835);
            byteBuffer.putInt(24);
            byteBuffer.putInt(-1);
            byteBuffer.putInt(-1);
            byteBuffer.putInt(this.f3686i != null ? this.f3686i.f3645c : -1);
            byteBuffer.putInt(this.f3685h.f3645c);
        }
    }

    /* compiled from: AxmlWriter.java */
    /* renamed from: c.a.a.d$c */
    static class c {

        /* renamed from: a */
        int f3689a;

        /* renamed from: b */
        C0544a f3690b;

        /* renamed from: c */
        C0544a f3691c;

        public c(C0544a c0544a, C0544a c0544a2, int i) {
            this.f3690b = c0544a;
            this.f3691c = c0544a2;
            this.f3689a = i;
        }
    }

    @Override // p060c.p061a.p062a.AbstractC0549e
    /* renamed from: a */
    public AbstractC0549e mo4019a(String str, String str2) {
        b bVar = new b(str, str2);
        this.f3665b.add(bVar);
        return bVar;
    }

    @Override // p060c.p061a.p062a.C0547c
    /* renamed from: a */
    public void mo4020a(String str, String str2, int i) {
        this.f3666c.put(str2, new c(str == null ? (C0544a) null : new C0544a(str), new C0544a(str2), i));
    }

    /* renamed from: c */
    private int m4021c() {
        int i;
        Iterator<b> it = this.f3665b.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 = it.next().m4029a(this) + i2;
        }
        int i3 = 0;
        for (Map.Entry<String, c> entry : this.f3666c.entrySet()) {
            c value = entry.getValue();
            if (value == null) {
                c cVar = new c((C0544a) null, new C0544a(entry.getKey()), 0);
                entry.setValue(cVar);
                value = cVar;
            }
            if (value.f3690b == null) {
                i = i3 + 1;
                value.f3690b = new C0544a(String.format("axml_auto_%02d", new Integer(i3)));
            } else {
                i = i3;
            }
            value.f3690b = m4022a(value.f3690b);
            value.f3691c = m4022a(value.f3691c);
            i3 = i;
        }
        int size = i2 + (this.f3666c.size() * 24 * 2);
        this.f3671i.addAll(this.f3670h);
        this.f3670h = (List) null;
        this.f3671i.addAll(this.f3667e);
        this.f3667e = (List) null;
        this.f3671i.m4041b();
        int m4040a = this.f3671i.m4040a();
        if (m4040a % 4 != 0) {
            m4040a += 4 - (m4040a % 4);
        }
        return m4040a + 8 + size + (this.f3669g.size() * 4) + 8;
    }

    /* renamed from: b */
    public byte[] m4026b() {
        int m4021c = m4021c() + 8;
        ByteBuffer order = ByteBuffer.allocate(m4021c).order(ByteOrder.LITTLE_ENDIAN);
        order.putInt(524291);
        order.putInt(m4021c);
        int m4040a = this.f3671i.m4040a();
        int i = 0;
        if (m4040a % 4 != 0) {
            i = 4 - (m4040a % 4);
        }
        order.putInt(1835009);
        order.putInt(m4040a + i + 8);
        this.f3671i.m4042d(order);
        order.put(new byte[i]);
        order.putInt(524672);
        order.putInt((this.f3669g.size() * 4) + 8);
        Iterator<Integer> it = this.f3669g.iterator();
        while (it.hasNext()) {
            order.putInt(it.next().intValue());
        }
        Stack stack = new Stack();
        Iterator<Map.Entry<String, c>> it2 = this.f3666c.entrySet().iterator();
        while (it2.hasNext()) {
            c value = it2.next().getValue();
            stack.push(value);
            order.putInt(1048832);
            order.putInt(24);
            order.putInt(-1);
            order.putInt(-1);
            order.putInt(value.f3690b.f3645c);
            order.putInt(value.f3691c.f3645c);
        }
        Iterator<b> it3 = this.f3665b.iterator();
        while (it3.hasNext()) {
            it3.next().m4033a(order);
        }
        while (stack.size() > 0) {
            c cVar = (c) stack.pop();
            order.putInt(1048833);
            order.putInt(24);
            order.putInt(cVar.f3689a);
            order.putInt(-1);
            order.putInt(cVar.f3690b.f3645c);
            order.putInt(cVar.f3691c.f3645c);
        }
        return order.array();
    }

    /* renamed from: a */
    C0544a m4022a(C0544a c0544a) {
        if (c0544a == null) {
            return (C0544a) null;
        }
        int indexOf = this.f3667e.indexOf(c0544a);
        if (indexOf < 0) {
            C0544a c0544a2 = new C0544a(c0544a.f3643a);
            this.f3667e.add(c0544a2);
            return c0544a2;
        }
        return this.f3667e.get(indexOf);
    }

    /* renamed from: b */
    C0544a m4025b(C0544a c0544a) {
        if (c0544a == null) {
            return (C0544a) null;
        }
        String str = c0544a.f3643a;
        if (!this.f3666c.containsKey(str)) {
            this.f3666c.put(str, (c) null);
        }
        return m4022a(c0544a);
    }

    /* renamed from: a */
    C0544a m4023a(C0544a c0544a, int i) {
        String stringBuffer = new StringBuffer().append(c0544a.f3643a).append(i).toString();
        C0544a c0544a2 = this.f3668f.get(stringBuffer);
        if (c0544a2 == null) {
            C0544a c0544a3 = new C0544a(c0544a.f3643a);
            this.f3669g.add(new Integer(i));
            this.f3670h.add(c0544a3);
            this.f3668f.put(stringBuffer, c0544a3);
            return c0544a3;
        }
        return c0544a2;
    }
}
