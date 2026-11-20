package com.p065b.p066a;

import android.media.session.PlaybackState;
import com.p065b.p066a.C0678e;
import com.p065b.p066a.C0679f;
import com.p065b.p066a.InterfaceC0585b;
import com.p065b.p066a.p067a.AbstractC0581c;
import com.p065b.p066a.p067a.C0579a;
import com.p065b.p066a.p067a.C0580b;
import com.p065b.p066a.p067a.C0584f;
import com.p065b.p066a.p068b.p081g.C0642a;
import com.p065b.p066a.p068b.p083i.AbstractC0667d;
import com.p065b.p066a.p068b.p083i.C0664a;
import com.p065b.p066a.p068b.p083i.C0665b;
import com.p065b.p066a.p068b.p083i.C0666c;
import com.p065b.p066a.p084c.AbstractC0670b;
import com.p065b.p066a.p084c.AbstractC0672d;
import com.p065b.p066a.p084c.InterfaceC0669a;
import com.p065b.p066a.p084c.InterfaceC0671c;
import com.p065b.p066a.p085d.C0676a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.p209io.File;
import java.p209io.IOException;
import java.p209io.RandomAccessFile;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: ApkSigner.java */
/* renamed from: com.b.a.a */
/* loaded from: classes.dex */
public class C0578a {
    private static final short ALIGNMENT_ZIP_EXTRA_DATA_FIELD_HEADER_ID = -9931;
    private static final short ALIGNMENT_ZIP_EXTRA_DATA_FIELD_MIN_SIZE_BYTES = 6;
    private static final short ANDROID_COMMON_PAGE_ALIGNMENT_BYTES = 4096;
    private static final short ANDROID_FILE_ALIGNMENT_BYTES = 4096;
    private static final String ANDROID_MANIFEST_ZIP_ENTRY_NAME = "AndroidManifest.xml";

    /* renamed from: a */
    private final boolean f3908a;

    /* renamed from: b */
    private final String f3909b;

    /* renamed from: c */
    private final boolean f3910c;

    /* renamed from: d */
    private final boolean f3911d;

    /* renamed from: e */
    private final InterfaceC0671c f3912e;

    /* renamed from: f */
    private final File f3913f;

    /* renamed from: g */
    private final Integer f3914g;

    /* renamed from: h */
    private final boolean f3915h;

    /* renamed from: i */
    private final InterfaceC0669a f3916i;

    /* renamed from: j */
    private final InterfaceC0671c f3917j;

    /* renamed from: k */
    private final File f3918k;

    /* renamed from: l */
    private final File f3919l;

    /* renamed from: m */
    private final int f3920m;

    /* renamed from: n */
    private final boolean f3921n;

    /* renamed from: o */
    private final List<c> f3922o;

    /* renamed from: p */
    private final InterfaceC0585b f3923p;

    /* renamed from: q */
    private final C0680g f3924q;

    /* renamed from: r */
    private final c f3925r;

    /* renamed from: s */
    private final C0680g f3926s;

    /* renamed from: t */
    private final boolean f3927t;

    /* renamed from: u */
    private final boolean f3928u;

    /* renamed from: v */
    private final boolean f3929v;

    /* renamed from: w */
    private final boolean f3930w;

    /* renamed from: x */
    private final boolean f3931x;

    /* renamed from: y */
    private final boolean f3932y;

    private C0578a(List<c> list, c cVar, C0680g c0680g, boolean z, Integer num, int i, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, String str, InterfaceC0585b interfaceC0585b, File file, InterfaceC0671c interfaceC0671c, File file2, InterfaceC0669a interfaceC0669a, InterfaceC0671c interfaceC0671c2, File file3, C0680g c0680g2) {
        this.f3922o = list;
        this.f3925r = cVar;
        this.f3926s = c0680g;
        this.f3911d = z;
        this.f3914g = num;
        this.f3920m = i;
        this.f3921n = z2;
        this.f3927t = z3;
        this.f3928u = z4;
        this.f3929v = z5;
        this.f3931x = z6;
        this.f3908a = z7;
        this.f3932y = z8;
        this.f3930w = z9;
        this.f3910c = z10;
        this.f3915h = z11;
        this.f3909b = str;
        this.f3923p = interfaceC0585b;
        this.f3913f = file;
        this.f3912e = interfaceC0671c;
        this.f3918k = file2;
        this.f3916i = interfaceC0669a;
        this.f3917j = interfaceC0671c2;
        this.f3919l = file3;
        this.f3924q = c0680g2;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0056 A[Catch: all -> 0x005a, TRY_ENTER, TryCatch #2 {all -> 0x005a, blocks: (B:14:0x0012, B:25:0x0056, B:26:0x0059, B:44:0x0028), top: B:43:0x0028 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m5756a() {
        RandomAccessFile randomAccessFile;
        Throwable th;
        RandomAccessFile randomAccessFile2;
        RandomAccessFile randomAccessFile3;
        Throwable th2;
        InterfaceC0669a interfaceC0669a;
        InterfaceC0671c m6335a;
        try {
            InterfaceC0671c interfaceC0671c = this.f3912e;
            if (interfaceC0671c != null) {
                randomAccessFile2 = null;
            } else if (this.f3913f != null) {
                randomAccessFile2 = new RandomAccessFile(this.f3913f, "r");
                try {
                    interfaceC0671c = AbstractC0672d.m6335a(randomAccessFile2);
                } catch (Throwable th3) {
                    randomAccessFile = randomAccessFile2;
                    th = th3;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                        throw th;
                    }
                    throw th;
                }
            } else {
                throw new IllegalStateException("Input APK not specified");
            }
            try {
                interfaceC0669a = this.f3916i;
                if (interfaceC0669a != null) {
                    m6335a = this.f3917j;
                    randomAccessFile3 = null;
                } else if (this.f3918k != null) {
                    randomAccessFile3 = new RandomAccessFile(this.f3918k, "rw");
                    try {
                        randomAccessFile3.setLength(0L);
                        InterfaceC0669a m6333a = AbstractC0670b.m6333a(randomAccessFile3);
                        m6335a = AbstractC0672d.m6335a(randomAccessFile3);
                        interfaceC0669a = m6333a;
                    } catch (Throwable th4) {
                        th2 = th4;
                        if (randomAccessFile3 != null) {
                            randomAccessFile3.close();
                        }
                        throw th2;
                    }
                } else {
                    throw new IllegalStateException("Output APK not specified");
                }
            } catch (Throwable th5) {
                th = th5;
                randomAccessFile3 = null;
            }
            try {
                m5753a(interfaceC0671c, interfaceC0669a, m6335a);
                if (randomAccessFile3 != null) {
                    randomAccessFile3.close();
                }
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
            } catch (Throwable th6) {
                th = th6;
                th2 = th;
                if (randomAccessFile3 != null) {
                }
                throw th2;
            }
        } catch (Throwable th7) {
            randomAccessFile = null;
            th = th7;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x039c A[LOOP:4: B:137:0x0396->B:139:0x039c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03aa A[EDGE_INSN: B:140:0x03aa->B:141:0x03aa BREAK  A[LOOP:4: B:137:0x0396->B:139:0x039c], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x029d  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m5753a(InterfaceC0671c interfaceC0671c, InterfaceC0669a interfaceC0669a, InterfaceC0671c interfaceC0671c2) {
        long j;
        InterfaceC0671c interfaceC0671c3;
        InterfaceC0585b interfaceC0585b;
        int m5755c;
        InterfaceC0585b m6451a;
        long j2;
        int i;
        ArrayList arrayList;
        long mo6233a;
        long j3;
        ArrayList arrayList2;
        Iterator<C0664a> it;
        int i2;
        int i3;
        InterfaceC0585b.d mo5798d;
        long j4;
        long j5;
        long j6;
        ByteBuffer byteBuffer;
        byte[] bArr;
        boolean z;
        long j7;
        long j8;
        ArrayList arrayList3;
        int i4;
        boolean z2;
        C0679f.a m6485a;
        try {
            AbstractC0581c.c m5771a = AbstractC0581c.m5771a(interfaceC0671c);
            try {
                AbstractC0581c.a m5770a = AbstractC0581c.m5770a(interfaceC0671c, m5771a);
                j = m5770a.m5789b();
                try {
                    interfaceC0671c3 = m5770a.m5788a();
                } catch (C0580b e2) {
                    interfaceC0671c3 = null;
                    if (j == -1) {
                    }
                    InterfaceC0671c mo6238b = interfaceC0671c.mo6238b(0L, j);
                    List<C0664a> m5750a = m5750a(m5747a(interfaceC0671c, m5771a), m5771a);
                    List<C0679f.b> m5754b = m5754b(m5750a, mo6238b);
                    if (m5754b != null) {
                    }
                    interfaceC0585b = this.f3923p;
                    if (interfaceC0585b == null) {
                    }
                    if (interfaceC0671c3 != null) {
                    }
                    ArrayList<C0664a> arrayList4 = new ArrayList(m5750a);
                    Collections.sort(arrayList4, C0664a.BY_LOCAL_FILE_HEADER_OFFSET_COMPARATOR);
                    HashMap hashMap = new HashMap(m5750a.size());
                    int i5 = -1;
                    j2 = 0;
                    i = -1;
                    byte[] bArr2 = null;
                    long j9 = 0;
                    arrayList = r8;
                    while (r27.hasNext()) {
                    }
                    mo6233a = mo6238b.mo6233a();
                    if (j2 >= mo6233a) {
                    }
                    arrayList2 = new ArrayList(m5750a.size() + 10);
                    it = m5750a.iterator();
                    while (it.hasNext()) {
                    }
                    if (i != -1) {
                    }
                    if (m6451a.mo5796b()) {
                    }
                    if (arrayList != null) {
                    }
                    mo5798d = m6451a.mo5798d();
                    if (mo5798d == null) {
                    }
                    j5 = 0;
                    while (true) {
                        j6 = j5;
                        if (arrayList2.iterator().hasNext()) {
                        }
                        j5 = ((C0664a) r9.next()).m6289j() + j6;
                    }
                    if (j6 <= 2147483647L) {
                    }
                }
            } catch (C0580b e3) {
                j = -1;
            }
            if (j == -1) {
                j = m5771a.m6355a();
            }
            InterfaceC0671c mo6238b2 = interfaceC0671c.mo6238b(0L, j);
            List<C0664a> m5750a2 = m5750a(m5747a(interfaceC0671c, m5771a), m5771a);
            List<C0679f.b> m5754b2 = m5754b(m5750a2, mo6238b2);
            ArrayList arrayList5 = m5754b2 != null ? null : new ArrayList();
            interfaceC0585b = this.f3923p;
            if (interfaceC0585b == null) {
                m6451a = interfaceC0585b;
            } else {
                Integer num = this.f3914g;
                if (num != null) {
                    m5755c = num.intValue();
                } else {
                    m5755c = m5755c(m5750a2, mo6238b2);
                }
                ArrayList arrayList6 = new ArrayList(this.f3922o.size());
                for (c cVar : this.f3922o) {
                    arrayList6.add(new C0678e.g.a(cVar.m5779c(), cVar.m5780d(), cVar.m5777a(), cVar.m5778b()).m6481a());
                }
                C0678e.a m6454c = new C0678e.a(arrayList6, m5755c).m6455d(this.f3927t).m6456e(this.f3928u).m6457f(this.f3929v).m6458g(this.f3932y).m6450a(this.f3910c).m6453b(this.f3915h).m6448a(this.f3924q).m6446a(this.f3920m).m6454c(this.f3921n);
                String str = this.f3909b;
                if (str != null) {
                    m6454c.m6449a(str);
                }
                c cVar2 = this.f3925r;
                if (cVar2 != null) {
                    m6454c.m6447a(new C0678e.g.a(cVar2.m5779c(), this.f3925r.m5780d(), this.f3925r.m5777a(), this.f3925r.m5778b()).m6481a());
                }
                C0680g c0680g = this.f3926s;
                if (c0680g != null) {
                    m6454c.m6452b(c0680g);
                }
                m6451a = m6454c.m6451a();
            }
            if (interfaceC0671c3 != null) {
                m6451a.mo5792a(interfaceC0671c3);
            }
            ArrayList<C0664a> arrayList42 = new ArrayList(m5750a2);
            Collections.sort(arrayList42, C0664a.BY_LOCAL_FILE_HEADER_OFFSET_COMPARATOR);
            HashMap hashMap2 = new HashMap(m5750a2.size());
            int i52 = -1;
            j2 = 0;
            i = -1;
            byte[] bArr22 = null;
            long j92 = 0;
            arrayList = arrayList5;
            for (C0664a c0664a : arrayList42) {
                String m6287h = c0664a.m6287h();
                if (C0679f.PIN_BYTE_RANGE_ZIP_ENTRY_NAME.equals(m6287h)) {
                    bArr = bArr22;
                } else if (AbstractC0581c.SOURCE_STAMP_CERTIFICATE_HASH_ZIP_ENTRY_NAME.equals(m6287h)) {
                    try {
                        bArr = C0666c.m6298b(mo6238b2, c0664a, mo6238b2.mo6233a());
                    } catch (C0676a e4) {
                        throw new C0579a("Bad source stamp entry");
                    }
                } else {
                    InterfaceC0585b.a mo5790a = m6451a.mo5790a(m6287h);
                    int i6 = AnonymousClass1.f3933x62cebf84[mo5790a.m5800b().ordinal()];
                    if (i6 == 1) {
                        z = true;
                    } else {
                        if (i6 != 2 && i6 != 3) {
                            throw new RuntimeException("Unknown output policy: " + mo5790a.m5800b());
                        }
                        z = false;
                    }
                    long m6286g = c0664a.m6286g();
                    if (m6286g > j2) {
                        long j10 = m6286g - j2;
                        mo6238b2.mo6237a(j2, j10, interfaceC0669a);
                        j7 = j92 + j10;
                        j2 = m6286g;
                    } else {
                        j7 = j92;
                    }
                    try {
                        C0666c m6295a = C0666c.m6295a(mo6238b2, c0664a, mo6238b2.mo6233a());
                        long m6306e = j2 + m6295a.m6306e();
                        InterfaceC0585b.b m5799a = mo5790a.m5799a();
                        if (m5799a != null) {
                            m5752a(mo6238b2, m6295a, m5799a);
                        }
                        if (z) {
                            int m6284e = c0664a.m6284e();
                            int m6285f = c0664a.m6285f();
                            if (i == -1 || m6284e > i || (m6284e == i && m6285f > i52)) {
                                i4 = m6284e;
                            } else {
                                i4 = i;
                                m6285f = i52;
                            }
                            InterfaceC0585b.b mo5795b = m6451a.mo5795b(m6287h);
                            if (mo5795b != null) {
                                m5752a(mo6238b2, m6295a, mo5795b);
                            }
                            b m5745a = m5745a(mo6238b2, m6295a, interfaceC0669a, j7);
                            long j11 = m5745a.f3962b + j7;
                            long j12 = m5745a.f3961a + j7;
                            if (m5754b2 != null) {
                                Iterator<C0679f.b> it2 = m5754b2.iterator();
                                boolean z3 = false;
                                while (true) {
                                    z2 = z3;
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    C0679f.b next = it2.next();
                                    if (next.m6486a(c0664a.m6287h()).matches() && (m6485a = next.m6485a(new C0679f.a(j12, j11))) != null) {
                                        arrayList.add(m6485a);
                                        z2 = true;
                                    }
                                    z3 = z2;
                                }
                                if (z2) {
                                    arrayList.add(new C0679f.a(j7, j12));
                                    arrayList3 = arrayList;
                                    if (j7 != m6295a.m6307f()) {
                                        c0664a = c0664a.m6279a(j7);
                                    }
                                    hashMap2.put(m6287h, c0664a);
                                    i = i4;
                                    i52 = m6285f;
                                    j8 = j11;
                                }
                            }
                            arrayList3 = arrayList;
                            if (j7 != m6295a.m6307f()) {
                            }
                            hashMap2.put(m6287h, c0664a);
                            i = i4;
                            i52 = m6285f;
                            j8 = j11;
                        } else {
                            j8 = j7;
                            arrayList3 = arrayList;
                        }
                        j2 = m6306e;
                        j92 = j8;
                        arrayList = arrayList3;
                    } catch (C0676a e5) {
                        throw new C0579a("Malformed ZIP entry: " + c0664a.m6287h(), e5);
                    }
                }
                bArr22 = bArr;
            }
            mo6233a = mo6238b2.mo6233a();
            if (j2 >= mo6233a) {
                long j13 = mo6233a - j2;
                mo6238b2.mo6237a(j2, j13, interfaceC0669a);
                j3 = j92 + j13;
            } else {
                j3 = j92;
            }
            arrayList2 = new ArrayList(m5750a2.size() + 10);
            it = m5750a2.iterator();
            while (it.hasNext()) {
                C0664a c0664a2 = (C0664a) hashMap2.get(it.next().m6287h());
                if (c0664a2 != null) {
                    arrayList2.add(c0664a2);
                }
            }
            if (i != -1) {
                i2 = 14881;
                i3 = 0;
            } else {
                i2 = i;
                i3 = i52;
            }
            if (m6451a.mo5796b()) {
                byte[] mo5794a = m6451a.mo5794a();
                if (this.f3911d || bArr22 == null || Arrays.equals(mo5794a, bArr22)) {
                    j3 += m5744a(AbstractC0581c.SOURCE_STAMP_CERTIFICATE_HASH_ZIP_ENTRY_NAME, mo5794a, j3, arrayList2, i3, i2, interfaceC0669a);
                } else {
                    throw new C0579a(String.format("Cannot generate SourceStamp. APK contains an existing entry with the name: %s, and it is different than the provided source stamp certificate", AbstractC0581c.SOURCE_STAMP_CERTIFICATE_HASH_ZIP_ENTRY_NAME));
                }
            }
            if (arrayList != null) {
                arrayList.add(new C0679f.a(j3, Long.MAX_VALUE));
                byte[] m6484a = C0679f.m6484a(arrayList);
                m5751a(m6451a, C0679f.PIN_BYTE_RANGE_ZIP_ENTRY_NAME, m6484a);
                j3 += m5744a(C0679f.PIN_BYTE_RANGE_ZIP_ENTRY_NAME, m6484a, j3, arrayList2, i3, i2, interfaceC0669a);
            }
            mo5798d = m6451a.mo5798d();
            if (mo5798d == null) {
                for (InterfaceC0585b.d.a aVar : mo5798d.mo6197b()) {
                    String m6199b = aVar.m6199b();
                    byte[] m6198a = aVar.m6198a();
                    m5751a(m6451a, m6199b, m6198a);
                    j3 += m5744a(m6199b, m6198a, j3, arrayList2, i3, i2, interfaceC0669a);
                }
                mo5798d.mo6196a();
                j4 = j3;
            } else {
                j4 = j3;
            }
            j5 = 0;
            while (true) {
                j6 = j5;
                if (arrayList2.iterator().hasNext()) {
                    break;
                } else {
                    j5 = ((C0664a) r9.next()).m6289j() + j6;
                }
            }
            if (j6 <= 2147483647L) {
                throw new IOException("Output ZIP Central Directory too large: " + j6 + " bytes");
            }
            ByteBuffer allocate = ByteBuffer.allocate((int) j6);
            Iterator<E> it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                ((C0664a) it3.next()).m6281b(allocate);
            }
            allocate.flip();
            C0642a c0642a = new C0642a(allocate);
            ByteBuffer m6293a = C0665b.m6293a(m5771a.m6358d(), arrayList2.size(), c0642a.mo6233a(), j4);
            InterfaceC0585b.c mo5791a = m6451a.mo5791a(interfaceC0671c2, c0642a, AbstractC0672d.m6337a(m6293a));
            if (mo5791a != null) {
                int mo6190c = mo5791a.mo6190c();
                byte[] mo6189b = mo5791a.mo6189b();
                mo5791a.mo6188a();
                long mo6233a2 = c0642a.mo6233a();
                long j14 = mo6190c;
                long length = mo6189b.length;
                long remaining = m6293a.remaining();
                if (this.f3908a) {
                    long j15 = ((((mo6233a2 + j4) + j14) + length) + remaining) % PlaybackState.ACTION_SKIP_TO_QUEUE_ITEM;
                    if (j15 != 0) {
                        m6293a = C0665b.m6292a(m6293a, (int) (PlaybackState.ACTION_SKIP_TO_QUEUE_ITEM - j15));
                        InterfaceC0585b.c mo5791a2 = m6451a.mo5791a(interfaceC0671c2, new C0642a(allocate), AbstractC0672d.m6337a(m6293a));
                        mo6189b = mo5791a2.mo6189b();
                        mo5791a2.mo6188a();
                    }
                }
                interfaceC0669a.mo6239a(ByteBuffer.allocate(mo6190c));
                interfaceC0669a.mo6240a(mo6189b, 0, mo6189b.length);
                AbstractC0667d.m6321b(m6293a, j4 + j14 + mo6189b.length);
                byteBuffer = m6293a;
            } else {
                byteBuffer = m6293a;
            }
            c0642a.mo6237a(0L, c0642a.mo6233a(), interfaceC0669a);
            interfaceC0669a.mo6239a(byteBuffer);
            m6451a.mo5797c();
            if (this.f3931x) {
                m6451a.mo5793a(interfaceC0671c2, this.f3919l, !this.f3930w);
            }
        } catch (C0676a e6) {
            throw new C0579a("Malformed APK: not a ZIP archive", e6);
        }
    }

    /* compiled from: ApkSigner.java */
    /* renamed from: com.b.a.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: $SwitchMap$com$android$apksig$ApkSignerEngine$InputJarEntryInstructions$OutputPolicy */
        static final int[] f3933x62cebf84;

        static {
            int[] iArr = new int[InterfaceC0585b.a.EnumC3327a.values().length];
            f3933x62cebf84 = iArr;
            try {
                iArr[InterfaceC0585b.a.EnumC3327a.OUTPUT.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3933x62cebf84[InterfaceC0585b.a.EnumC3327a.OUTPUT_BY_ENGINE.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f3933x62cebf84[InterfaceC0585b.a.EnumC3327a.SKIP.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* renamed from: a */
    private static void m5751a(InterfaceC0585b interfaceC0585b, String str, byte[] bArr) {
        InterfaceC0585b.b mo5795b = interfaceC0585b.mo5795b(str);
        if (mo5795b != null) {
            mo5795b.mo6087b().mo6240a(bArr, 0, bArr.length);
            mo5795b.mo6086a();
        }
    }

    /* renamed from: a */
    private static long m5744a(String str, byte[] bArr, long j, List<C0664a> list, int i, int i2, InterfaceC0669a interfaceC0669a) {
        AbstractC0667d.a m6320b = AbstractC0667d.m6320b(ByteBuffer.wrap(bArr));
        byte[] bArr2 = m6320b.f4293c;
        long j2 = m6320b.f4291a;
        long m6294a = C0666c.m6294a(str, i, i2, bArr2, j2, bArr.length, interfaceC0669a);
        list.add(C0664a.m6275a(str, i, i2, j2, bArr2.length, bArr.length, j));
        return m6294a;
    }

    /* renamed from: a */
    private static void m5752a(InterfaceC0671c interfaceC0671c, C0666c c0666c, InterfaceC0585b.b bVar) {
        try {
            c0666c.m6303b(interfaceC0671c, bVar.mo6087b());
            bVar.mo6086a();
        } catch (C0676a e2) {
            throw new C0579a("Malformed ZIP entry: " + c0666c.m6305d(), e2);
        }
    }

    /* compiled from: ApkSigner.java */
    /* renamed from: com.b.a.a$b */
    private static class b {

        /* renamed from: a */
        public long f3961a;

        /* renamed from: b */
        public long f3962b;

        public b(long j, long j2) {
            this.f3962b = j;
            this.f3961a = j2;
        }
    }

    /* renamed from: a */
    private static b m5745a(InterfaceC0671c interfaceC0671c, C0666c c0666c, InterfaceC0669a interfaceC0669a, long j) {
        long m6307f = c0666c.m6307f();
        if (m6307f == j) {
            return new b(c0666c.m6300a(interfaceC0671c, interfaceC0669a), c0666c.m6299a());
        }
        int m5743a = m5743a(c0666c);
        if (m5743a > 1) {
            long j2 = m5743a;
            if (m6307f % j2 != j % j2) {
                if ((m6307f + c0666c.m6299a()) % j2 != 0) {
                    return new b(c0666c.m6300a(interfaceC0671c, interfaceC0669a), c0666c.m6299a());
                }
                ByteBuffer m5748a = m5748a(c0666c.m6302b(), c0666c.m6304c() + j, m5743a);
                return new b(c0666c.m6301a(interfaceC0671c, m5748a, interfaceC0669a), (c0666c.m6299a() + m5748a.remaining()) - c0666c.m6302b().remaining());
            }
        }
        return new b(c0666c.m6300a(interfaceC0671c, interfaceC0669a), c0666c.m6299a());
    }

    /* renamed from: a */
    private static int m5743a(C0666c c0666c) {
        if (c0666c.m6308g()) {
            return 1;
        }
        ByteBuffer m6302b = c0666c.m6302b();
        if (m6302b.hasRemaining()) {
            m6302b.order(ByteOrder.LITTLE_ENDIAN);
            while (true) {
                if (m6302b.remaining() < 4) {
                    break;
                }
                short s = m6302b.getShort();
                int m6322c = AbstractC0667d.m6322c(m6302b);
                if (m6322c > m6302b.remaining()) {
                    break;
                }
                if (s != -9931) {
                    m6302b.position(m6302b.position() + m6322c);
                } else if (m6322c >= 2) {
                    return AbstractC0667d.m6322c(m6302b);
                }
            }
        }
        return c0666c.m6305d().endsWith(".so") ? 4096 : 4;
    }

    /* renamed from: a */
    private static ByteBuffer m5748a(ByteBuffer byteBuffer, long j, int i) {
        if (i > 1) {
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining() + 5 + i);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            while (byteBuffer.remaining() >= 4) {
                short s = byteBuffer.getShort();
                int m6322c = AbstractC0667d.m6322c(byteBuffer);
                if (m6322c > byteBuffer.remaining()) {
                    break;
                }
                if ((s == 0 && m6322c == 0) || s == -9931) {
                    byteBuffer.position(byteBuffer.position() + m6322c);
                } else {
                    byteBuffer.position(byteBuffer.position() - 4);
                    int limit = byteBuffer.limit();
                    byteBuffer.limit(m6322c + byteBuffer.position() + 4);
                    allocate.put(byteBuffer);
                    byteBuffer.limit(limit);
                }
            }
            int position = (i - ((int) (((allocate.position() + j) + 6) % i))) % i;
            allocate.putShort(ALIGNMENT_ZIP_EXTRA_DATA_FIELD_HEADER_ID);
            AbstractC0667d.m6323c(allocate, position + 2);
            AbstractC0667d.m6323c(allocate, i);
            allocate.position(position + allocate.position());
            allocate.flip();
            return allocate;
        }
        return byteBuffer;
    }

    /* renamed from: a */
    private static ByteBuffer m5747a(InterfaceC0671c interfaceC0671c, AbstractC0581c.c cVar) {
        long c2 = cVar.m6357c();
        if (c2 > 2147483647L) {
            throw new C0579a("ZIP Central Directory too large: " + c2);
        }
        ByteBuffer mo6235a = interfaceC0671c.mo6235a(cVar.m6355a(), (int) c2);
        mo6235a.order(ByteOrder.LITTLE_ENDIAN);
        return mo6235a;
    }

    /* renamed from: a */
    private static List<C0664a> m5750a(ByteBuffer byteBuffer, AbstractC0581c.c cVar) {
        long a2 = cVar.m6355a();
        int b2 = cVar.m6356b();
        ArrayList arrayList = new ArrayList(b2);
        HashSet hashSet = new HashSet(b2);
        for (int i = 0; i < b2; i++) {
            int position = byteBuffer.position();
            try {
                C0664a m6276a = C0664a.m6276a(byteBuffer);
                String m6287h = m6276a.m6287h();
                if (!hashSet.add(m6287h)) {
                    throw new C0579a("Multiple ZIP entries with the same name: " + m6287h);
                }
                arrayList.add(m6276a);
            } catch (C0676a e2) {
                throw new C0579a("Malformed ZIP Central Directory record #" + (i + 1) + " at file offset " + (a2 + position), e2);
            }
        }
        if (!byteBuffer.hasRemaining()) {
            return arrayList;
        }
        throw new C0579a("Unused space at the end of ZIP Central Directory: " + byteBuffer.remaining() + " bytes starting at file offset " + (a2 + byteBuffer.position()));
    }

    /* renamed from: a */
    private static C0664a m5746a(List<C0664a> list, String str) {
        for (C0664a c0664a : list) {
            if (str.equals(c0664a.m6287h())) {
                return c0664a;
            }
        }
        return null;
    }

    /* renamed from: a */
    static ByteBuffer m5749a(List<C0664a> list, InterfaceC0671c interfaceC0671c) {
        C0664a m5746a = m5746a(list, "AndroidManifest.xml");
        if (m5746a == null) {
            throw new C0579a("Missing AndroidManifest.xml");
        }
        return ByteBuffer.wrap(C0666c.m6298b(interfaceC0671c, m5746a, interfaceC0671c.mo6233a()));
    }

    /* renamed from: b */
    private static List<C0679f.b> m5754b(List<C0664a> list, InterfaceC0671c interfaceC0671c) {
        C0664a m5746a = m5746a(list, C0679f.PIN_HINT_ASSET_ZIP_ENTRY_NAME);
        if (m5746a == null) {
            return null;
        }
        new ArrayList();
        try {
            return C0679f.m6483a(C0666c.m6298b(interfaceC0671c, m5746a, interfaceC0671c.mo6233a()));
        } catch (C0676a e2) {
            throw new C0579a("Bad " + m5746a);
        }
    }

    /* renamed from: c */
    private static int m5755c(List<C0664a> list, InterfaceC0671c interfaceC0671c) {
        try {
            return AbstractC0581c.m5774b(m5749a(list, interfaceC0671c));
        } catch (C0579a | C0676a e2) {
            throw new C0584f("Failed to determine APK's minimum supported Android platform version", e2);
        }
    }

    /* compiled from: ApkSigner.java */
    /* renamed from: com.b.a.a$c */
    public static class c {

        /* renamed from: a */
        private final List<X509Certificate> f3963a;

        /* renamed from: b */
        private boolean f3964b;

        /* renamed from: c */
        private final String f3965c;

        /* renamed from: d */
        private final PrivateKey f3966d;

        private c(String str, PrivateKey privateKey, List<X509Certificate> list, boolean z) {
            this.f3965c = str;
            this.f3966d = privateKey;
            this.f3963a = Collections.unmodifiableList(new ArrayList(list));
            this.f3964b = z;
        }

        /* renamed from: c */
        public String m5779c() {
            return this.f3965c;
        }

        /* renamed from: d */
        public PrivateKey m5780d() {
            return this.f3966d;
        }

        /* renamed from: a */
        public List<X509Certificate> m5777a() {
            return this.f3963a;
        }

        /* renamed from: b */
        public boolean m5778b() {
            return this.f3964b;
        }

        /* compiled from: ApkSigner.java */
        /* renamed from: com.b.a.a$c$a */
        public static class a {

            /* renamed from: a */
            private final List<X509Certificate> f3967a;

            /* renamed from: b */
            private final boolean f3968b;

            /* renamed from: c */
            private final String f3969c;

            /* renamed from: d */
            private final PrivateKey f3970d;

            public a(String str, PrivateKey privateKey, List<X509Certificate> list) {
                this(str, privateKey, list, false);
            }

            public a(String str, PrivateKey privateKey, List<X509Certificate> list, boolean z) {
                if (str.isEmpty()) {
                    throw new IllegalArgumentException("Empty name");
                }
                this.f3969c = str;
                this.f3970d = privateKey;
                this.f3967a = new ArrayList(list);
                this.f3968b = z;
            }

            /* renamed from: a */
            public c m5781a() {
                return new c(this.f3969c, this.f3970d, this.f3967a, this.f3968b);
            }
        }
    }

    /* compiled from: ApkSigner.java */
    /* renamed from: com.b.a.a$a */
    public static class a {

        /* renamed from: A */
        private boolean f3934A;

        /* renamed from: a */
        private boolean f3935a;

        /* renamed from: b */
        private String f3936b;

        /* renamed from: c */
        private boolean f3937c;

        /* renamed from: d */
        private boolean f3938d;

        /* renamed from: e */
        private InterfaceC0671c f3939e;

        /* renamed from: f */
        private File f3940f;

        /* renamed from: g */
        private Integer f3941g;

        /* renamed from: h */
        private boolean f3942h;

        /* renamed from: i */
        private InterfaceC0669a f3943i;

        /* renamed from: j */
        private InterfaceC0671c f3944j;

        /* renamed from: k */
        private File f3945k;

        /* renamed from: l */
        private File f3946l;

        /* renamed from: m */
        private int f3947m;

        /* renamed from: n */
        private boolean f3948n;

        /* renamed from: o */
        private final List<c> f3949o;

        /* renamed from: p */
        private final InterfaceC0585b f3950p;

        /* renamed from: q */
        private C0680g f3951q;

        /* renamed from: r */
        private c f3952r;

        /* renamed from: s */
        private C0680g f3953s;

        /* renamed from: t */
        private boolean f3954t;

        /* renamed from: u */
        private boolean f3955u;

        /* renamed from: v */
        private boolean f3956v;

        /* renamed from: w */
        private boolean f3957w;

        /* renamed from: x */
        private boolean f3958x;

        /* renamed from: y */
        private boolean f3959y;

        /* renamed from: z */
        private boolean f3960z;

        public a(List<c> list) {
            this.f3938d = false;
            this.f3954t = true;
            this.f3955u = true;
            this.f3956v = true;
            this.f3960z = true;
            this.f3935a = false;
            this.f3934A = false;
            this.f3959y = false;
            this.f3937c = true;
            this.f3947m = 33;
            this.f3948n = false;
            this.f3957w = false;
            this.f3958x = false;
            if (list.isEmpty()) {
                throw new IllegalArgumentException("At least one signer config must be provided");
            }
            if (list.size() > 1) {
                this.f3956v = false;
            }
            this.f3949o = new ArrayList(list);
            this.f3950p = null;
        }

        public a(InterfaceC0585b interfaceC0585b) {
            this.f3938d = false;
            this.f3954t = true;
            this.f3955u = true;
            this.f3956v = true;
            this.f3960z = true;
            this.f3935a = false;
            this.f3934A = false;
            this.f3959y = false;
            this.f3937c = true;
            this.f3947m = 33;
            this.f3948n = false;
            this.f3957w = false;
            this.f3958x = false;
            if (interfaceC0585b == null) {
                throw new NullPointerException("signerEngine == null");
            }
            this.f3950p = interfaceC0585b;
            this.f3949o = null;
        }

        /* renamed from: a */
        public a m5759a(File file) {
            if (file == null) {
                throw new NullPointerException("inputApk == null");
            }
            this.f3940f = file;
            this.f3939e = null;
            return this;
        }

        /* renamed from: b */
        public a m5763b(File file) {
            if (file == null) {
                throw new NullPointerException("outputApk == null");
            }
            this.f3945k = file;
            this.f3943i = null;
            this.f3944j = null;
            return this;
        }

        /* renamed from: c */
        public a m5765c(File file) {
            if (file == null) {
                throw new NullPointerException("v4HashRootOutputFile == null");
            }
            this.f3946l = file;
            return this;
        }

        /* renamed from: a */
        public a m5758a(int i) {
            m5757b();
            this.f3941g = Integer.valueOf(i);
            return this;
        }

        /* renamed from: a */
        public a m5761a(boolean z) {
            m5757b();
            this.f3954t = z;
            return this;
        }

        /* renamed from: b */
        public a m5764b(boolean z) {
            m5757b();
            this.f3955u = z;
            return this;
        }

        /* renamed from: c */
        public a m5766c(boolean z) {
            m5757b();
            this.f3956v = z;
            if (z) {
                this.f3958x = true;
            } else {
                this.f3957w = true;
            }
            return this;
        }

        /* renamed from: d */
        public a m5767d(boolean z) {
            m5757b();
            this.f3960z = z;
            this.f3959y = z;
            return this;
        }

        /* renamed from: a */
        public a m5760a(String str) {
            m5757b();
            str.getClass();
            this.f3936b = str;
            return this;
        }

        /* renamed from: b */
        private void m5757b() {
            if (this.f3950p != null) {
                throw new IllegalStateException("Operation is not available when builder initialized with an engine");
            }
        }

        /* renamed from: a */
        public C0578a m5762a() {
            boolean z = this.f3957w;
            if (!z || !this.f3958x) {
                if (z) {
                    this.f3956v = false;
                }
                if (this.f3958x) {
                    this.f3956v = true;
                }
                if (this.f3960z && !this.f3955u && !this.f3956v) {
                    if (!this.f3959y) {
                        this.f3960z = false;
                    } else {
                        throw new IllegalStateException("APK Signature Scheme v4 signing requires at least v2 or v3 signing to be enabled");
                    }
                }
                return new C0578a(this.f3949o, this.f3952r, this.f3953s, this.f3938d, this.f3941g, this.f3947m, this.f3948n, this.f3954t, this.f3955u, this.f3956v, this.f3960z, this.f3935a, this.f3934A, this.f3959y, this.f3937c, this.f3942h, this.f3936b, this.f3950p, this.f3940f, this.f3939e, this.f3945k, this.f3943i, this.f3944j, this.f3946l, this.f3951q);
            }
            throw new IllegalStateException("Builder configured to both enable and disable APK Signature Scheme v3 signing");
        }
    }
}
