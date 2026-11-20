package org.p226d.p233b.p263h;

import java.p209io.IOException;
import java.p209io.StringWriter;
import java.p209io.Writer;
import java.util.Iterator;
import org.p226d.p233b.C2164e;
import org.p226d.p233b.p250e.p254c.InterfaceC2236a;
import org.p226d.p233b.p250e.p254c.InterfaceC2237b;
import org.p226d.p233b.p250e.p254c.InterfaceC2238c;
import org.p226d.p233b.p250e.p254c.InterfaceC2239d;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;
import org.p226d.p233b.p250e.p254c.InterfaceC2242g;
import org.p226d.p233b.p250e.p254c.InterfaceC2243h;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p269d.C2464r;

/* compiled from: ReferenceUtil.java */
/* renamed from: org.d.b.h.i */
/* loaded from: classes.dex */
public final class C2389i {
    /* renamed from: a */
    public static String m15120a(InterfaceC2240e interfaceC2240e) {
        return m15121a(interfaceC2240e, false);
    }

    /* renamed from: a */
    public static String m15121a(InterfaceC2240e interfaceC2240e, boolean z) {
        StringBuilder sb = new StringBuilder();
        if (!z) {
            sb.append(interfaceC2240e.mo14209a());
            sb.append("->");
        }
        sb.append(interfaceC2240e.mo14210b());
        sb.append('(');
        Iterator<? extends CharSequence> it = interfaceC2240e.mo14211c().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        sb.append(')');
        sb.append(interfaceC2240e.mo14212d());
        return sb.toString();
    }

    /* renamed from: a */
    public static String m15119a(InterfaceC2239d interfaceC2239d) {
        StringWriter stringWriter = new StringWriter();
        try {
            m15128a(stringWriter, interfaceC2239d);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* renamed from: a */
    public static void m15128a(Writer writer, InterfaceC2239d interfaceC2239d) {
        writer.write(40);
        Iterator<? extends CharSequence> it = interfaceC2239d.mo14685a().iterator();
        while (it.hasNext()) {
            writer.write(it.next().toString());
        }
        writer.write(41);
        writer.write(interfaceC2239d.mo14686b());
    }

    /* renamed from: a */
    public static void m15129a(Writer writer, InterfaceC2240e interfaceC2240e) {
        m15130a(writer, interfaceC2240e, false);
    }

    /* renamed from: a */
    public static void m15130a(Writer writer, InterfaceC2240e interfaceC2240e, boolean z) {
        if (!z) {
            writer.write(interfaceC2240e.mo14209a());
            writer.write("->");
        }
        writer.write(interfaceC2240e.mo14210b());
        writer.write(40);
        Iterator<? extends CharSequence> it = interfaceC2240e.mo14211c().iterator();
        while (it.hasNext()) {
            writer.write(it.next().toString());
        }
        writer.write(41);
        writer.write(interfaceC2240e.mo14212d());
    }

    /* renamed from: a */
    public static String m15116a(InterfaceC2237b interfaceC2237b) {
        return m15117a(interfaceC2237b, false);
    }

    /* renamed from: a */
    public static String m15117a(InterfaceC2237b interfaceC2237b, boolean z) {
        StringBuilder sb = new StringBuilder();
        if (!z) {
            sb.append(interfaceC2237b.mo14225d());
            sb.append("->");
        }
        sb.append(interfaceC2237b.mo14226e());
        sb.append(':');
        sb.append(interfaceC2237b.mo14227f());
        return sb.toString();
    }

    /* renamed from: b */
    public static String m15131b(InterfaceC2237b interfaceC2237b) {
        return interfaceC2237b.mo14226e() + ':' + interfaceC2237b.mo14227f();
    }

    /* renamed from: a */
    public static void m15125a(Writer writer, InterfaceC2237b interfaceC2237b) {
        m15126a(writer, interfaceC2237b, false);
    }

    /* renamed from: a */
    public static void m15126a(Writer writer, InterfaceC2237b interfaceC2237b, boolean z) {
        if (!z) {
            writer.write(interfaceC2237b.mo14225d());
            writer.write("->");
        }
        writer.write(interfaceC2237b.mo14226e());
        writer.write(58);
        writer.write(interfaceC2237b.mo14227f());
    }

    /* renamed from: a */
    public static String m15118a(InterfaceC2238c interfaceC2238c) {
        StringWriter stringWriter = new StringWriter();
        try {
            m15127a(stringWriter, interfaceC2238c);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* renamed from: a */
    public static void m15127a(Writer writer, InterfaceC2238c interfaceC2238c) {
        writer.write(C2164e.m14859a(interfaceC2238c.mo14683a()));
        writer.write(64);
        InterfaceC2241f mo14684b = interfaceC2238c.mo14684b();
        if (mo14684b instanceof InterfaceC2240e) {
            m15129a(writer, (InterfaceC2240e) mo14684b);
        } else {
            m15125a(writer, (InterfaceC2237b) mo14684b);
        }
    }

    /* renamed from: a */
    public static String m15115a(InterfaceC2236a interfaceC2236a) {
        StringWriter stringWriter = new StringWriter();
        try {
            m15124a(stringWriter, interfaceC2236a);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* renamed from: a */
    public static void m15124a(Writer writer, InterfaceC2236a interfaceC2236a) {
        writer.write(interfaceC2236a.mo14678a());
        writer.write(40);
        writer.write(34);
        C2464r.m15561a(writer, interfaceC2236a.mo14680c());
        writer.write(34);
        writer.write(", ");
        m15128a(writer, interfaceC2236a.mo14681d());
        for (InterfaceC2251g interfaceC2251g : interfaceC2236a.mo14682e()) {
            writer.write(", ");
            C2383c.m15079a(writer, interfaceC2251g);
        }
        writer.write(")@");
        if (interfaceC2236a.mo14679b().mo14683a() != 4) {
            throw new IllegalArgumentException("The linker method handle for a call site must be of type invoke-static");
        }
        m15129a(writer, (InterfaceC2240e) interfaceC2236a.mo14679b().mo14684b());
    }

    /* renamed from: a */
    public static String m15122a(InterfaceC2241f interfaceC2241f) {
        return m15123a(interfaceC2241f, (String) null);
    }

    /* renamed from: a */
    public static String m15123a(InterfaceC2241f interfaceC2241f, String str) {
        if (interfaceC2241f instanceof InterfaceC2242g) {
            return String.format("\"%s\"", C2464r.m15559a(((InterfaceC2242g) interfaceC2241f).mo14691a()));
        }
        if (interfaceC2241f instanceof InterfaceC2243h) {
            return ((InterfaceC2243h) interfaceC2241f).mo14205l();
        }
        if (interfaceC2241f instanceof InterfaceC2237b) {
            InterfaceC2237b interfaceC2237b = (InterfaceC2237b) interfaceC2241f;
            return m15117a(interfaceC2237b, interfaceC2237b.mo14225d().equals(str));
        }
        if (interfaceC2241f instanceof InterfaceC2240e) {
            InterfaceC2240e interfaceC2240e = (InterfaceC2240e) interfaceC2241f;
            return m15121a(interfaceC2240e, interfaceC2240e.mo14209a().equals(str));
        }
        if (interfaceC2241f instanceof InterfaceC2239d) {
            return m15119a((InterfaceC2239d) interfaceC2241f);
        }
        if (interfaceC2241f instanceof InterfaceC2238c) {
            return m15118a((InterfaceC2238c) interfaceC2241f);
        }
        if (interfaceC2241f instanceof InterfaceC2236a) {
            return m15115a((InterfaceC2236a) interfaceC2241f);
        }
        return null;
    }
}
