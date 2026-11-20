package com.p065b.p066a.p068b.p081g;

import android.media.session.PlaybackState;
import com.p065b.p066a.C0681h;
import com.p065b.p066a.p068b.p083i.AbstractC0667d;
import com.p065b.p066a.p084c.AbstractC0672d;
import com.p065b.p066a.p084c.InterfaceC0669a;
import com.p065b.p066a.p084c.InterfaceC0671c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Phaser;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: VerityTreeBuilder.java */
/* renamed from: com.b.a.b.g.n */
/* loaded from: classes.dex */
public class C0655n implements AutoCloseable {
    private static final int CHUNK_SIZE = 4096;
    private static final int DIGEST_PARALLELISM = Math.min(32, Runtime.getRuntime().availableProcessors());
    private static final String JCA_ALGORITHM = "SHA-256";
    private static final int MAX_OUTSTANDING_CHUNKS = 4;
    private static final int MAX_PREFETCH_CHUNKS = 1024;
    private static final int MIN_CHUNKS_PER_WORKER = 8;

    /* renamed from: a */
    private final ExecutorService f4257a;

    /* renamed from: b */
    private final MessageDigest f4258b;

    /* renamed from: c */
    private final byte[] f4259c;

    public C0655n(byte[] bArr) {
        int i = DIGEST_PARALLELISM;
        this.f4257a = new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(4), new ThreadPoolExecutor.CallerRunsPolicy());
        this.f4259c = bArr;
        this.f4258b = m6262b();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.f4257a.shutdownNow();
    }

    /* renamed from: a */
    public byte[] m6265a(InterfaceC0671c interfaceC0671c, InterfaceC0671c interfaceC0671c2, InterfaceC0671c interfaceC0671c3) {
        if (interfaceC0671c.mo6233a() % PlaybackState.ACTION_SKIP_TO_QUEUE_ITEM != 0) {
            throw new IllegalStateException("APK Signing Block size not a multiple of 4096: " + interfaceC0671c.mo6233a());
        }
        long mo6233a = interfaceC0671c.mo6233a();
        ByteBuffer allocate = ByteBuffer.allocate((int) interfaceC0671c3.mo6233a());
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        interfaceC0671c3.mo6236a(0L, (int) interfaceC0671c3.mo6233a(), allocate);
        allocate.flip();
        AbstractC0667d.m6321b(allocate, mo6233a);
        return m6267b(new C0645d(interfaceC0671c, interfaceC0671c2, AbstractC0672d.m6337a(allocate)));
    }

    /* renamed from: b */
    public byte[] m6267b(InterfaceC0671c interfaceC0671c) {
        return m6266a(m6264a(interfaceC0671c));
    }

    /* renamed from: a */
    public ByteBuffer m6264a(InterfaceC0671c interfaceC0671c) {
        InterfaceC0671c m6337a;
        int digestLength = this.f4258b.getDigestLength();
        int[] m6260a = m6260a(interfaceC0671c.mo6233a(), digestLength);
        ByteBuffer allocate = ByteBuffer.allocate(m6260a[m6260a.length - 1]);
        for (int length = m6260a.length - 2; length >= 0; length--) {
            int i = length + 1;
            C0643b c0643b = new C0643b(m6261b(allocate, m6260a[length], m6260a[i]));
            if (length == m6260a.length - 2) {
                m6257a(interfaceC0671c, c0643b);
                m6337a = interfaceC0671c;
            } else {
                m6337a = AbstractC0672d.m6337a(m6261b(allocate.asReadOnlyBuffer(), m6260a[i], m6260a[length + 2]));
                m6257a(m6337a, c0643b);
            }
            int m6253a = (int) ((m6253a(m6337a.mo6233a(), PlaybackState.ACTION_SKIP_TO_QUEUE_ITEM) * digestLength) % PlaybackState.ACTION_SKIP_TO_QUEUE_ITEM);
            if (m6253a > 0) {
                int i2 = 4096 - m6253a;
                c0643b.mo6240a(new byte[i2], 0, i2);
            }
        }
        return allocate;
    }

    /* renamed from: a */
    public byte[] m6266a(ByteBuffer byteBuffer) {
        return m6263b(m6261b(byteBuffer.asReadOnlyBuffer(), 0, 4096));
    }

    /* renamed from: a */
    private static int[] m6260a(long j, int i) {
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        do {
            j = m6253a(j, PlaybackState.ACTION_SKIP_TO_QUEUE_ITEM) * i;
            arrayList.add(Long.valueOf(m6253a(j, PlaybackState.ACTION_SKIP_TO_QUEUE_ITEM) * PlaybackState.ACTION_SKIP_TO_QUEUE_ITEM));
        } while (j > PlaybackState.ACTION_SKIP_TO_QUEUE_ITEM);
        int[] iArr = new int[arrayList.size() + 1];
        iArr[0] = 0;
        while (i2 < arrayList.size()) {
            int i3 = i2 + 1;
            iArr[i3] = C0681h.m6494a(((Long) arrayList.get((arrayList.size() - i2) - 1)).longValue()) + iArr[i2];
            i2 = i3;
        }
        return iArr;
    }

    /* renamed from: a */
    private void m6257a(InterfaceC0671c interfaceC0671c, InterfaceC0669a interfaceC0669a) {
        long mo6233a = interfaceC0671c.mo6233a();
        int m6253a = (int) m6253a(mo6233a, PlaybackState.ACTION_SKIP_TO_QUEUE_ITEM);
        byte[][] bArr = new byte[m6253a][];
        Phaser phaser = new Phaser(1);
        long j = 0;
        int i = 0;
        while (true) {
            long j2 = j;
            if (j2 >= mo6233a) {
                break;
            }
            int min = (int) (Math.min(4194304 + j2, mo6233a) - j2);
            long j3 = min;
            int m6253a2 = (int) m6253a(j3, PlaybackState.ACTION_SKIP_TO_QUEUE_ITEM);
            ByteBuffer allocate = ByteBuffer.allocate(m6253a2 * 4096);
            interfaceC0671c.mo6236a(j2, min, allocate);
            allocate.rewind();
            Runnable runnable = new Runnable(this, allocate, i, bArr, phaser) { // from class: com.b.a.b.g.n.1

                /* renamed from: a */
                final C0655n f4260a;

                /* renamed from: b */
                final ByteBuffer f4261b;

                /* renamed from: c */
                final byte[][] f4262c;

                /* renamed from: d */
                final int f4263d;

                /* renamed from: e */
                final Phaser f4264e;

                {
                    this.f4260a = this;
                    this.f4261b = allocate;
                    this.f4263d = i;
                    this.f4262c = bArr;
                    this.f4264e = phaser;
                }

                @Override // java.lang.Runnable
                public void run() {
                    MessageDigest m6255a = this.f4260a.m6255a();
                    int capacity = this.f4261b.capacity();
                    int i2 = 0;
                    int i3 = this.f4263d;
                    while (i2 < capacity) {
                        int i4 = i2 + 4096;
                        this.f4262c[i3] = this.f4260a.m6259a(m6255a, C0655n.m6261b(this.f4261b, i2, i4));
                        i3++;
                        i2 = i4;
                    }
                    this.f4264e.arriveAndDeregister();
                }
            };
            phaser.register();
            this.f4257a.execute(runnable);
            i += m6253a2;
            j = j2 + j3;
        }
        phaser.arriveAndAwaitAdvance();
        for (int i2 = 0; i2 < m6253a; i2++) {
            byte[] bArr2 = bArr[i2];
            interfaceC0669a.mo6240a(bArr2, 0, bArr2.length);
        }
    }

    /* renamed from: b */
    private byte[] m6263b(ByteBuffer byteBuffer) {
        return m6259a(this.f4258b, byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public byte[] m6259a(MessageDigest messageDigest, ByteBuffer byteBuffer) {
        messageDigest.reset();
        byte[] bArr = this.f4259c;
        if (bArr != null) {
            messageDigest.update(bArr);
        }
        messageDigest.update(byteBuffer);
        return messageDigest.digest();
    }

    /* renamed from: a */
    private static long m6253a(long j, long j2) {
        return ((j + j2) - 1) / j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static ByteBuffer m6261b(ByteBuffer byteBuffer, int i, int i2) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position(0);
        duplicate.limit(i2);
        duplicate.position(i);
        return duplicate.slice();
    }

    /* renamed from: b */
    private static MessageDigest m6262b() {
        return MessageDigest.getInstance("SHA-256");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public MessageDigest m6255a() {
        try {
            return (MessageDigest) this.f4258b.clone();
        } catch (CloneNotSupportedException e2) {
            try {
                return m6262b();
            } catch (NoSuchAlgorithmException e3) {
                throw new IllegalStateException("Failed to obtain an instance of a previously available message digest", e3);
            }
        }
    }
}
