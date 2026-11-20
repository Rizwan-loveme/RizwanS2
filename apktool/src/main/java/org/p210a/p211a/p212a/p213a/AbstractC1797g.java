package org.p210a.p211a.p212a.p213a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.p210a.p211a.p212a.p215c.C1840j;

/* compiled from: ATNState.java */
/* renamed from: org.a.a.a.a.g */
/* loaded from: classes.dex */
public abstract class AbstractC1797g {

    /* renamed from: a */
    public static final List<String> f10796a = Collections.unmodifiableList(Arrays.asList("INVALID", "BASIC", "RULE_START", "BLOCK_START", "PLUS_BLOCK_START", "STAR_BLOCK_START", "TOKEN_START", "RULE_STOP", "BLOCK_END", "STAR_LOOP_BACK", "STAR_LOOP_ENTRY", "PLUS_LOOP_BACK", "LOOP_END"));

    /* renamed from: d */
    public int f10799d;

    /* renamed from: g */
    public C1840j f10802g;

    /* renamed from: b */
    public C1759a f10797b = null;

    /* renamed from: c */
    public int f10798c = -1;

    /* renamed from: e */
    public boolean f10800e = false;

    /* renamed from: f */
    protected final List<AbstractC1791be> f10801f = new ArrayList(4);

    /* renamed from: b */
    public abstract int mo13499b();

    public int hashCode() {
        return this.f10798c;
    }

    public boolean equals(Object obj) {
        return (obj instanceof AbstractC1797g) && this.f10798c == ((AbstractC1797g) obj).f10798c;
    }

    public String toString() {
        return String.valueOf(this.f10798c);
    }

    /* renamed from: a */
    public int m13630a() {
        return this.f10801f.size();
    }

    /* renamed from: a */
    public void m13633a(AbstractC1791be abstractC1791be) {
        m13632a(this.f10801f.size(), abstractC1791be);
    }

    /* renamed from: a */
    public void m13632a(int i, AbstractC1791be abstractC1791be) {
        boolean z;
        if (this.f10801f.isEmpty()) {
            this.f10800e = abstractC1791be.mo13540b();
        } else if (this.f10800e != abstractC1791be.mo13540b()) {
            System.err.format(Locale.getDefault(), "ATN state %d has both epsilon and non-epsilon transitions.\n", Integer.valueOf(this.f10798c));
            this.f10800e = false;
        }
        Iterator<AbstractC1791be> it = this.f10801f.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            AbstractC1791be next = it.next();
            if (next.f10764f.f10798c == abstractC1791be.f10764f.f10798c) {
                if (next.mo13577c() != null && abstractC1791be.mo13577c() != null && next.mo13577c().equals(abstractC1791be.mo13577c())) {
                    z = true;
                    break;
                } else if (next.mo13540b() && abstractC1791be.mo13540b()) {
                    z = true;
                    break;
                }
            }
        }
        if (!z) {
            this.f10801f.add(i, abstractC1791be);
        }
    }

    /* renamed from: a */
    public AbstractC1791be m13631a(int i) {
        return this.f10801f.get(i);
    }

    /* renamed from: b */
    public void m13635b(int i, AbstractC1791be abstractC1791be) {
        this.f10801f.set(i, abstractC1791be);
    }

    /* renamed from: b */
    public AbstractC1791be m13634b(int i) {
        return this.f10801f.remove(i);
    }

    /* renamed from: c */
    public final boolean m13636c() {
        return this.f10800e;
    }
}
