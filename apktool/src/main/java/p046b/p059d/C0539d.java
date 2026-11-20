package p046b.p059d;

import com.p129f.p130a.p135e.C1215c;
import java.p209io.DataInput;
import java.util.logging.Logger;
import org.p217b.p218a.p219a.p220a.C1880a;

/* compiled from: ExtCountingDataInput.java */
/* renamed from: b.d.d */
/* loaded from: classes.dex */
public class C0539d extends C0540e {

    /* renamed from: c */
    private static final Logger f3634c;

    /* renamed from: b */
    private final C1880a f3635b;

    static {
        try {
            f3634c = Logger.getLogger(Class.forName("b.d.d").getName());
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public C0539d(C1215c c1215c) {
        this(new C1880a(c1215c));
    }

    public C0539d(C1880a c1880a) {
        super((DataInput) new C1215c(c1880a));
        this.f3635b = c1880a;
    }

    /* renamed from: a */
    public int m3969a() {
        return this.f3635b.m13937a();
    }

    /* renamed from: a */
    public long m3970a(int i) {
        return this.f3635b.skip(i);
    }

    /* renamed from: a */
    public int[] m3971a(int i, long j) {
        int[] iArr = new int[i];
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            if (m3969a() >= j) {
                f3634c.warning(String.format("Bad string block: string entry is at %d, past end at %d", new Integer(m3969a()), new Long(j)));
                break;
            }
            iArr[i2] = readInt();
            i2++;
        }
        return iArr;
    }
}
