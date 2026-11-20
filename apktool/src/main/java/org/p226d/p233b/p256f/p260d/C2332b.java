package org.p226d.p233b.p256f.p260d;

import com.p129f.p130a.p133c.AbstractC1148aa;
import java.util.Iterator;
import org.p226d.p233b.p256f.C2273a;
import org.p226d.p233b.p256f.C2357i;

/* compiled from: ParamUtil.java */
/* renamed from: org.d.b.f.d.b */
/* loaded from: classes.dex */
public class C2332b {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: b */
    public static int m14971b(String str, int i) {
        char charAt = str.charAt(i);
        switch (charAt) {
            case 'B':
            case 'C':
            case 'D':
            case 'F':
            case 'I':
            case 'J':
            case 'S':
            case 'Z':
                return i + 1;
            case 'L':
                while (true) {
                    int i2 = i + 1;
                    if (str.charAt(i) == ';') {
                        return i2;
                    }
                    i = i2;
                }
            case '[':
                while (true) {
                    int i3 = i + 1;
                    if (str.charAt(i) == '[') {
                        return m14971b(str, i3);
                    }
                    i = i3;
                }
            default:
                throw new IllegalArgumentException(String.format("Param string \"%s\" contains invalid type prefix: %s", str, Character.toString(charAt)));
        }
    }

    /* renamed from: a */
    public static Iterable<C2357i> m14970a(final String str) {
        return new Iterable<C2357i>() { // from class: org.d.b.f.d.b.1
            @Override // java.lang.Iterable
            public Iterator<C2357i> iterator() {
                return new Iterator<C2357i>() { // from class: org.d.b.f.d.b.1.1

                    /* renamed from: b */
                    private int f12582b = 0;

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f12582b < String.this.length();
                    }

                    @Override // java.util.Iterator
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public C2357i next() {
                        int m14971b = C2332b.m14971b(String.this, this.f12582b);
                        String substring = String.this.substring(this.f12582b, m14971b);
                        this.f12582b = m14971b;
                        return new C2357i(substring, (AbstractC1148aa<? extends C2273a>) null, (String) null);
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}
