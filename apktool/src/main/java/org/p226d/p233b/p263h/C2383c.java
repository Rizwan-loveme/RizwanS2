package org.p226d.p233b.p263h;

import java.p209io.Writer;
import org.p226d.p233b.p250e.InterfaceC2175b;
import org.p226d.p233b.p250e.p255d.InterfaceC2245a;
import org.p226d.p233b.p250e.p255d.InterfaceC2246b;
import org.p226d.p233b.p250e.p255d.InterfaceC2247c;
import org.p226d.p233b.p250e.p255d.InterfaceC2248d;
import org.p226d.p233b.p250e.p255d.InterfaceC2249e;
import org.p226d.p233b.p250e.p255d.InterfaceC2250f;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p250e.p255d.InterfaceC2252h;
import org.p226d.p233b.p250e.p255d.InterfaceC2253i;
import org.p226d.p233b.p250e.p255d.InterfaceC2254j;
import org.p226d.p233b.p250e.p255d.InterfaceC2255k;
import org.p226d.p233b.p250e.p255d.InterfaceC2256l;
import org.p226d.p233b.p250e.p255d.InterfaceC2257m;
import org.p226d.p233b.p250e.p255d.InterfaceC2258n;
import org.p226d.p233b.p250e.p255d.InterfaceC2259o;
import org.p226d.p233b.p250e.p255d.InterfaceC2261q;
import org.p226d.p233b.p250e.p255d.InterfaceC2262r;
import org.p226d.p233b.p250e.p255d.InterfaceC2263s;
import org.p226d.p269d.C2464r;

/* compiled from: EncodedValueUtils.java */
/* renamed from: org.d.b.h.c */
/* loaded from: classes.dex */
public final class C2383c {
    /* renamed from: a */
    public static boolean m15080a(InterfaceC2251g interfaceC2251g) {
        switch (interfaceC2251g.mo14430a()) {
            case 0:
                return ((InterfaceC2248d) interfaceC2251g).mo14861b() == 0;
            case 2:
                return ((InterfaceC2261q) interfaceC2251g).mo14867b() == 0;
            case 3:
                return ((InterfaceC2249e) interfaceC2251g).mo14862b() == 0;
            case 4:
                return ((InterfaceC2255k) interfaceC2251g).mo14865b() == 0;
            case 6:
                return ((InterfaceC2256l) interfaceC2251g).mo14866b() == 0;
            case 16:
                return ((InterfaceC2254j) interfaceC2251g).mo14864b() == 0.0f;
            case 17:
                return ((InterfaceC2250f) interfaceC2251g).mo14863b() == 0.0d;
            case 30:
                return true;
            case 31:
                return !((InterfaceC2247c) interfaceC2251g).mo14860b();
            default:
                return false;
        }
    }

    /* renamed from: a */
    public static void m15079a(Writer writer, InterfaceC2251g interfaceC2251g) {
        switch (interfaceC2251g.mo14430a()) {
            case 0:
                writer.write(Byte.toString(((InterfaceC2248d) interfaceC2251g).mo14861b()));
                return;
            case 1:
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 18:
            case 19:
            case 20:
            default:
                throw new IllegalArgumentException("Unknown encoded value type");
            case 2:
                writer.write(Short.toString(((InterfaceC2261q) interfaceC2251g).mo14867b()));
                return;
            case 3:
                writer.write(Integer.toString(((InterfaceC2249e) interfaceC2251g).mo14862b()));
                return;
            case 4:
                writer.write(Integer.toString(((InterfaceC2255k) interfaceC2251g).mo14865b()));
                return;
            case 6:
                writer.write(Long.toString(((InterfaceC2256l) interfaceC2251g).mo14866b()));
                return;
            case 16:
                writer.write(Float.toString(((InterfaceC2254j) interfaceC2251g).mo14864b()));
                return;
            case 17:
                writer.write(Double.toString(((InterfaceC2250f) interfaceC2251g).mo14863b()));
                return;
            case 21:
                C2389i.m15128a(writer, ((InterfaceC2259o) interfaceC2251g).mo14741b());
                return;
            case 22:
                C2389i.m15127a(writer, ((InterfaceC2258n) interfaceC2251g).mo14740b());
                return;
            case 23:
                writer.write(34);
                C2464r.m15561a(writer, ((InterfaceC2262r) interfaceC2251g).mo14742b());
                writer.write(34);
                return;
            case 24:
                writer.write(((InterfaceC2263s) interfaceC2251g).mo14743b());
                return;
            case 25:
                C2389i.m15125a(writer, ((InterfaceC2253i) interfaceC2251g).mo14738b());
                return;
            case 26:
                C2389i.m15129a(writer, ((InterfaceC2257m) interfaceC2251g).mo14739b());
                return;
            case 27:
                C2389i.m15125a(writer, ((InterfaceC2252h) interfaceC2251g).mo14737b());
                return;
            case 28:
                m15078a(writer, (InterfaceC2246b) interfaceC2251g);
                return;
            case 29:
                m15077a(writer, (InterfaceC2245a) interfaceC2251g);
                return;
            case 30:
                writer.write("null");
                return;
            case 31:
                writer.write(Boolean.toString(((InterfaceC2247c) interfaceC2251g).mo14860b()));
                return;
        }
    }

    /* renamed from: a */
    private static void m15077a(Writer writer, InterfaceC2245a interfaceC2245a) {
        writer.write("Annotation[");
        writer.write(interfaceC2245a.mo14672b());
        for (InterfaceC2175b interfaceC2175b : interfaceC2245a.mo14673c()) {
            writer.write(", ");
            writer.write(interfaceC2175b.mo14692a());
            writer.write(61);
            m15079a(writer, interfaceC2175b.mo14693b());
        }
        writer.write(93);
    }

    /* renamed from: a */
    private static void m15078a(Writer writer, InterfaceC2246b interfaceC2246b) {
        writer.write("Array[");
        boolean z = true;
        for (InterfaceC2251g interfaceC2251g : interfaceC2246b.mo14733b()) {
            if (z) {
                z = false;
            } else {
                writer.write(", ");
            }
            m15079a(writer, interfaceC2251g);
        }
        writer.write(93);
    }
}
