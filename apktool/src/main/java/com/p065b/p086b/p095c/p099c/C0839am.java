package com.p065b.p086b.p095c.p099c;

import android.icu.text.DateFormat;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

/* compiled from: Statistics.java */
/* renamed from: com.b.b.c.c.am */
/* loaded from: classes.dex */
public final class C0839am {

    /* renamed from: a */
    private final HashMap<String, a> f5186a = new HashMap<>(50);

    /* renamed from: a */
    public void m7263a(AbstractC0872y abstractC0872y) {
        String m7438k = abstractC0872y.m7438k();
        a aVar = this.f5186a.get(m7438k);
        if (aVar == null) {
            this.f5186a.put(m7438k, new a(abstractC0872y, m7438k));
        } else {
            aVar.m7267a(abstractC0872y);
        }
    }

    /* renamed from: a */
    public void m7262a(AbstractC0838al abstractC0838al) {
        Iterator<? extends AbstractC0872y> it = abstractC0838al.mo7221a().iterator();
        while (it.hasNext()) {
            m7263a(it.next());
        }
    }

    /* renamed from: a */
    public final void m7264a(InterfaceC1007a interfaceC1007a) {
        if (this.f5186a.size() != 0) {
            interfaceC1007a.mo8458a(0, "\nstatistics:\n");
            TreeMap treeMap = new TreeMap();
            for (a aVar : this.f5186a.values()) {
                treeMap.put(aVar.f5187a, aVar);
            }
            Iterator it = treeMap.values().iterator();
            while (it.hasNext()) {
                ((a) it.next()).m7268a(interfaceC1007a);
            }
        }
    }

    /* renamed from: a */
    public String m7261a() {
        StringBuilder sb = new StringBuilder();
        sb.append("Statistics:\n");
        TreeMap treeMap = new TreeMap();
        for (a aVar : this.f5186a.values()) {
            treeMap.put(aVar.f5187a, aVar);
        }
        Iterator it = treeMap.values().iterator();
        while (it.hasNext()) {
            sb.append(((a) it.next()).m7266a());
        }
        return sb.toString();
    }

    /* compiled from: Statistics.java */
    /* renamed from: com.b.b.c.c.am$a */
    private static class a {

        /* renamed from: a */
        private final String f5187a;

        /* renamed from: b */
        private int f5188b;

        /* renamed from: c */
        private int f5189c;

        /* renamed from: d */
        private int f5190d;

        /* renamed from: e */
        private int f5191e;

        public a(AbstractC0872y abstractC0872y, String str) {
            int mo7211g_ = abstractC0872y.mo7211g_();
            this.f5187a = str;
            this.f5188b = 1;
            this.f5189c = mo7211g_;
            this.f5190d = mo7211g_;
            this.f5191e = mo7211g_;
        }

        /* renamed from: a */
        public void m7267a(AbstractC0872y abstractC0872y) {
            int mo7211g_ = abstractC0872y.mo7211g_();
            this.f5188b++;
            this.f5189c += mo7211g_;
            if (mo7211g_ > this.f5190d) {
                this.f5190d = mo7211g_;
            }
            if (mo7211g_ < this.f5191e) {
                this.f5191e = mo7211g_;
            }
        }

        /* renamed from: a */
        public void m7268a(InterfaceC1007a interfaceC1007a) {
            interfaceC1007a.mo8459a(m7266a());
        }

        /* renamed from: a */
        public String m7266a() {
            StringBuilder sb = new StringBuilder();
            sb.append("  " + this.f5187a + ": " + this.f5188b + " item" + (this.f5188b == 1 ? "" : DateFormat.SECOND) + "; " + this.f5189c + " bytes total\n");
            if (this.f5191e == this.f5190d) {
                sb.append("    " + this.f5191e + " bytes/item\n");
            } else {
                sb.append("    " + this.f5191e + ".." + this.f5190d + " bytes/item; average " + (this.f5189c / this.f5188b) + "\n");
            }
            return sb.toString();
        }
    }
}
