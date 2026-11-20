package org.p210a.p211a.p212a.p214b;

import android.icu.text.DateFormat;
import java.util.Arrays;
import org.p210a.p211a.p212a.InterfaceC1823ag;

/* compiled from: DFASerializer.java */
/* renamed from: org.a.a.a.b.b */
/* loaded from: classes.dex */
public class C1828b {

    /* renamed from: a */
    private final C1827a f10860a;

    /* renamed from: b */
    private final InterfaceC1823ag f10861b;

    public C1828b(C1827a c1827a, InterfaceC1823ag interfaceC1823ag) {
        this.f10860a = c1827a;
        this.f10861b = interfaceC1823ag;
    }

    public String toString() {
        if (this.f10860a.f10855b == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (C1829c c1829c : this.f10860a.m13707b()) {
            int length = c1829c.f10864c != null ? c1829c.f10864c.length : 0;
            for (int i = 0; i < length; i++) {
                C1829c c1829c2 = c1829c.f10864c[i];
                if (c1829c2 != null && c1829c2.f10862a != Integer.MAX_VALUE) {
                    sb.append(m13710a(c1829c));
                    sb.append("-").append(m13709a(i)).append("->").append(m13710a(c1829c2)).append('\n');
                }
            }
        }
        String sb2 = sb.toString();
        if (sb2.length() == 0) {
            return null;
        }
        return sb2;
    }

    /* renamed from: a */
    protected String m13709a(int i) {
        return this.f10861b.mo13693c(i - 1);
    }

    /* renamed from: a */
    protected String m13710a(C1829c c1829c) {
        String str = String.valueOf(c1829c.f10865d ? ":" : "") + DateFormat.SECOND + c1829c.f10862a + (c1829c.f10868g ? "^" : "");
        if (c1829c.f10865d) {
            if (c1829c.f10869h != null) {
                return String.valueOf(str) + "=>" + Arrays.toString(c1829c.f10869h);
            }
            return String.valueOf(str) + "=>" + c1829c.f10866e;
        }
        return str;
    }
}
