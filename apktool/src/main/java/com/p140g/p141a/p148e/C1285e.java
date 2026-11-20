package com.p140g.p141a.p148e;

import com.p140g.p141a.p149f.p150a.C1289a;
import com.p140g.p141a.p149f.p150a.C1290b;
import com.p140g.p141a.p149f.p150a.C1291c;
import com.p140g.p141a.p151g.C1299g;
import java.nio.charset.StandardCharsets;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/* compiled from: MultiDexFileReader.java */
/* renamed from: com.g.a.e.e */
/* loaded from: classes.dex */
public class C1285e implements InterfaceC1281a {

    /* renamed from: a */
    private final List<C1282b> f8253a = new ArrayList();

    /* renamed from: b */
    private final List<a> f8254b = new ArrayList();

    /* renamed from: b */
    private static byte[] m10450b(String str) {
        byte[] bArr = (byte[]) null;
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1000);
            byte[] bArr2 = new byte[1000];
            while (true) {
                int read = fileInputStream.read(bArr2);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                    bArr = byteArrayOutputStream.toByteArray();
                    return bArr;
                }
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return bArr;
        } catch (IOException e3) {
            e3.printStackTrace();
            return bArr;
        }
    }

    public C1285e(Collection<C1282b> collection) {
        this.f8253a.addAll(collection);
        m10451a();
    }

    /* renamed from: a */
    private static byte[] m10449a(InputStream inputStream) {
        C1289a c1289a = new C1289a();
        byte[] bArr = new byte[1024];
        int read = inputStream.read(bArr);
        while (read > 0) {
            c1289a.write(bArr, 0, read);
            read = inputStream.read(bArr);
        }
        return c1289a.m10461a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.TreeMap] */
    /* renamed from: a */
    public static InterfaceC1281a m10448a(String str) {
        byte[] m10450b = m10450b(str);
        if (m10450b.length < 3) {
            throw new IOException("File too small to be a dex/zip");
        }
        if ("dex".equals(new String(m10450b, 0, 3, StandardCharsets.ISO_8859_1))) {
            return new C1282b(m10450b);
        }
        if ("PK".equals(new String(m10450b, 0, 2, StandardCharsets.ISO_8859_1))) {
            TreeMap treeMap = new TreeMap();
            C1291c c1291c = new C1291c(m10450b);
            try {
                Iterator it = c1291c.m10468a().iterator();
                while (it.hasNext()) {
                    C1290b c1290b = (C1290b) it.next();
                    String m10462a = c1290b.m10462a();
                    if (m10462a.startsWith("classes") && m10462a.endsWith(".dex") && !treeMap.containsKey(m10462a)) {
                        treeMap.put(m10462a, new C1282b(m10449a(c1291c.m10469b(c1290b))));
                    }
                }
            } finally {
                c1291c.close();
            }
            if (treeMap.size() == 0) {
                throw new IOException("Can not find classes.dex in zip file");
            }
            if (treeMap.size() == 1) {
                return (C1282b) treeMap.firstEntry().getValue();
            }
            return new C1285e(treeMap.values());
        }
        throw new IOException("the src file not a .dex or zip file");
    }

    /* renamed from: a */
    void m10451a() {
        HashSet hashSet = new HashSet();
        for (C1282b c1282b : this.f8253a) {
            List<String> m10445a = c1282b.m10445a();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < m10445a.size()) {
                    String str = m10445a.get(i2);
                    if (hashSet.add(str)) {
                        this.f8254b.add(new a(i2, c1282b, str));
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    @Override // com.p140g.p141a.p148e.InterfaceC1281a
    /* renamed from: a */
    public void mo10402a(C1299g c1299g, int i) {
        int size = this.f8254b.size();
        for (int i2 = 0; i2 < size; i2++) {
            m10452a(c1299g, i2, i);
        }
    }

    /* renamed from: a */
    public void m10452a(C1299g c1299g, int i, int i2) {
        a aVar = this.f8254b.get(i);
        aVar.f8256b.m10447a(c1299g, aVar.f8255a, i2);
    }

    /* compiled from: MultiDexFileReader.java */
    /* renamed from: com.g.a.e.e$a */
    static class a {

        /* renamed from: a */
        int f8255a;

        /* renamed from: b */
        C1282b f8256b;

        /* renamed from: c */
        String f8257c;

        public a(int i, C1282b c1282b, String str) {
            this.f8255a = i;
            this.f8256b = c1282b;
            this.f8257c = str;
        }
    }
}
