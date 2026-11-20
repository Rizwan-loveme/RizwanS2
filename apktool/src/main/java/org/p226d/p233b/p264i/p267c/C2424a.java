package org.p226d.p233b.p264i.p267c;

import com.p129f.p130a.p133c.C1156ai;
import java.util.ArrayList;
import java.util.List;
import org.p226d.p233b.p238b.p240b.AbstractC1996b;
import org.p226d.p233b.p238b.p240b.AbstractC2007m;
import org.p226d.p233b.p238b.p240b.AbstractC2008n;
import org.p226d.p233b.p250e.p254c.InterfaceC2236a;
import org.p226d.p233b.p250e.p254c.InterfaceC2238c;
import org.p226d.p233b.p250e.p254c.InterfaceC2239d;
import org.p226d.p233b.p250e.p255d.InterfaceC2246b;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p256f.p261e.C2352s;

/* compiled from: CallSiteUtil.java */
/* renamed from: org.d.b.i.c.a */
/* loaded from: classes.dex */
public class C2424a {
    /* renamed from: a */
    public static InterfaceC2246b m15324a(final InterfaceC2236a interfaceC2236a) {
        return new AbstractC1996b() { // from class: org.d.b.i.c.a.1
            @Override // org.p226d.p233b.p250e.p255d.InterfaceC2246b
            /* renamed from: b */
            public List<? extends InterfaceC2251g> mo14733b() {
                ArrayList m9909a = C1156ai.m9909a();
                m9909a.add(new AbstractC2007m() { // from class: org.d.b.i.c.a.1.1
                    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2258n
                    /* renamed from: b */
                    public InterfaceC2238c mo14740b() {
                        return InterfaceC2236a.this.mo14679b();
                    }
                });
                m9909a.add(new C2352s(InterfaceC2236a.this.mo14680c()));
                m9909a.add(new AbstractC2008n() { // from class: org.d.b.i.c.a.1.2
                    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2259o
                    /* renamed from: b */
                    public InterfaceC2239d mo14741b() {
                        return InterfaceC2236a.this.mo14681d();
                    }
                });
                m9909a.addAll(InterfaceC2236a.this.mo14682e());
                return m9909a;
            }
        };
    }
}
