package androidx.core.p027c;

import android.util.Base64;
import androidx.core.p030e.C0270e;
import java.util.List;

/* compiled from: FontRequest.java */
/* renamed from: androidx.core.c.d */
/* loaded from: classes.dex */
public final class C0249d {

    /* renamed from: a */
    private final String f1970a;

    /* renamed from: b */
    private final String f1971b;

    /* renamed from: c */
    private final String f1972c;

    /* renamed from: d */
    private final List<List<byte[]>> f1973d;

    /* renamed from: e */
    private final int f1974e = 0;

    /* renamed from: f */
    private final String f1975f;

    public C0249d(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f1970a = (String) C0270e.m1960a(str);
        this.f1971b = (String) C0270e.m1960a(str2);
        this.f1972c = (String) C0270e.m1960a(str3);
        this.f1973d = (List) C0270e.m1960a(list);
        this.f1975f = m1806a(str, str2, str3);
    }

    /* renamed from: a */
    private String m1806a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    /* renamed from: a */
    public String m1807a() {
        return this.f1970a;
    }

    /* renamed from: b */
    public String m1808b() {
        return this.f1971b;
    }

    /* renamed from: c */
    public String m1809c() {
        return this.f1972c;
    }

    /* renamed from: d */
    public List<List<byte[]>> m1810d() {
        return this.f1973d;
    }

    /* renamed from: e */
    public int m1811e() {
        return this.f1974e;
    }

    /* renamed from: f */
    String m1812f() {
        return this.f1975f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f1970a + ", mProviderPackage: " + this.f1971b + ", mQuery: " + this.f1972c + ", mCertificates:");
        for (int i = 0; i < this.f1973d.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.f1973d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f1974e);
        return sb.toString();
    }
}
