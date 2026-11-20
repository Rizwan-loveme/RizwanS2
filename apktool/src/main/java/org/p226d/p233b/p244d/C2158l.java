package org.p226d.p233b.p244d;

import com.p129f.p130a.p135e.C1213a;
import java.p209io.InputStream;
import java.p209io.UnsupportedEncodingException;
import java.util.List;
import org.p226d.p233b.C2359g;
import org.p226d.p233b.p244d.p246b.C2119c;
import org.p226d.p233b.p244d.p248d.AbstractC2137h;
import org.p226d.p233b.p263h.C2382b;

/* compiled from: DexBackedOdexFile.java */
/* renamed from: org.d.b.d.l */
/* loaded from: classes.dex */
public class C2158l extends C2153g {

    /* renamed from: c */
    private final byte[] f12056c;

    public C2158l(C2359g c2359g, byte[] bArr, byte[] bArr2) {
        super(c2359g, bArr2);
        this.f12056c = bArr;
    }

    @Override // org.p226d.p233b.p244d.C2153g
    /* renamed from: b */
    public boolean mo14768b() {
        return true;
    }

    /* renamed from: e */
    public List<String> m14803e() {
        int m14668b = C2119c.m14668b(this.f12056c) - C2119c.m14665a(this.f12056c);
        return new AbstractC2137h<String>(this, m14668b + 16, new C2077a(this.f11801a).m14621g(m14668b + 12)) { // from class: org.d.b.d.l.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.p226d.p233b.p244d.p248d.AbstractC2137h
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String mo14725b(C2161o c2161o, int i) {
                int j = c2161o.m14652j();
                int a2 = c2161o.m14635a();
                c2161o.m14638b(j + 20);
                try {
                    return new String(C2158l.this.f11801a, a2, j - 1, "US-ASCII");
                } catch (UnsupportedEncodingException e2) {
                    throw new RuntimeException(e2);
                }
            }
        };
    }

    /* renamed from: b */
    public static C2158l m14802b(C2359g c2359g, InputStream inputStream) {
        C2382b.m15075b(inputStream);
        inputStream.reset();
        byte[] bArr = new byte[40];
        C1213a.m10158a(inputStream, bArr);
        if (C2119c.m14665a(bArr) > 40) {
            C1213a.m10157a(inputStream, r1 - 40);
        }
        return new C2158l(c2359g, bArr, C1213a.m10161a(inputStream));
    }

    /* renamed from: f */
    public int m14804f() {
        return C2119c.m14669b(this.f12056c, 0);
    }

    /* compiled from: DexBackedOdexFile.java */
    /* renamed from: org.d.b.d.l$a */
    public static class a extends RuntimeException {
        public a() {
        }

        public a(String str) {
            super(str);
        }
    }
}
