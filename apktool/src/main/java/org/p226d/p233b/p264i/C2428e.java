package org.p226d.p233b.p264i;

import java.lang.CharSequence;
import org.p226d.p269d.C2453g;

/* compiled from: DebugWriter.java */
/* renamed from: org.d.b.i.e */
/* loaded from: classes.dex */
public class C2428e<StringKey extends CharSequence, TypeKey extends CharSequence> {

    /* renamed from: a */
    private final InterfaceC2442s<StringKey, ?> f12818a;

    /* renamed from: b */
    private final InterfaceC2444u<StringKey, TypeKey, ?> f12819b;

    /* renamed from: c */
    private final C2429f f12820c;

    /* renamed from: d */
    private int f12821d;

    /* renamed from: e */
    private int f12822e;

    C2428e(InterfaceC2442s<StringKey, ?> interfaceC2442s, InterfaceC2444u<StringKey, TypeKey, ?> interfaceC2444u, C2429f c2429f) {
        this.f12818a = interfaceC2442s;
        this.f12819b = interfaceC2444u;
        this.f12820c = c2429f;
    }

    /* renamed from: a */
    void m15344a(int i) {
        this.f12821d = 0;
        this.f12822e = i;
    }

    /* renamed from: a */
    public void m15346a(int i, int i2, StringKey stringkey, TypeKey typekey, StringKey stringkey2) {
        int a2 = this.f12818a.mo15313a((InterfaceC2442s<StringKey, ?>) stringkey);
        int a3 = this.f12819b.mo15313a((InterfaceC2444u<StringKey, TypeKey, ?>) typekey);
        int a4 = this.f12818a.mo15313a((InterfaceC2442s<StringKey, ?>) stringkey2);
        m15341d(i);
        if (a4 == -1) {
            this.f12820c.write(3);
            this.f12820c.m15371e(i2);
            this.f12820c.m15371e(a2 + 1);
            this.f12820c.m15371e(a3 + 1);
            return;
        }
        this.f12820c.write(4);
        this.f12820c.m15371e(i2);
        this.f12820c.m15371e(a2 + 1);
        this.f12820c.m15371e(a3 + 1);
        this.f12820c.m15371e(a4 + 1);
    }

    /* renamed from: a */
    public void m15345a(int i, int i2) {
        m15341d(i);
        this.f12820c.write(5);
        this.f12820c.m15371e(i2);
    }

    /* renamed from: b */
    public void m15349b(int i, int i2) {
        m15341d(i);
        this.f12820c.write(6);
        this.f12820c.m15371e(i2);
    }

    /* renamed from: b */
    public void m15348b(int i) {
        m15341d(i);
        this.f12820c.write(7);
    }

    /* renamed from: c */
    public void m15350c(int i) {
        m15341d(i);
        this.f12820c.write(8);
    }

    /* renamed from: c */
    public void m15351c(int i, int i2) {
        int i3 = 0;
        int i4 = i2 - this.f12822e;
        int i5 = i - this.f12821d;
        if (i5 < 0) {
            throw new C2453g("debug info items must have non-decreasing code addresses", new Object[0]);
        }
        if (i4 < -4 || i4 > 10) {
            m15343e(i2);
            i4 = 0;
        }
        if ((i4 >= 2 || i5 <= 16) && (i4 <= 1 || i5 <= 15)) {
            i3 = i5;
        } else {
            m15341d(i);
        }
        m15342d(i4, i3);
    }

    /* renamed from: a */
    public void m15347a(int i, StringKey stringkey) {
        m15341d(i);
        this.f12820c.write(9);
        this.f12820c.m15371e(this.f12818a.mo15313a((InterfaceC2442s<StringKey, ?>) stringkey) + 1);
    }

    /* renamed from: d */
    private void m15341d(int i) {
        int i2 = i - this.f12821d;
        if (i2 > 0) {
            this.f12820c.write(1);
            this.f12820c.m15371e(i2);
            this.f12821d = i;
        }
    }

    /* renamed from: e */
    private void m15343e(int i) {
        int i2 = i - this.f12822e;
        if (i2 != 0) {
            this.f12820c.write(2);
            this.f12820c.m15372f(i2);
            this.f12822e = i;
        }
    }

    /* renamed from: d */
    private void m15342d(int i, int i2) {
        this.f12820c.write((byte) ((i2 * 15) + 10 + i + 4));
        this.f12822e += i;
        this.f12821d += i2;
    }
}
