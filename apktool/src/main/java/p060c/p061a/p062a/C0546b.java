package p060c.p061a.p062a;

import java.util.Stack;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: AxmlReader.java */
/* renamed from: c.a.a.b */
/* loaded from: classes.dex */
public class C0546b {

    /* renamed from: a */
    public static final AbstractC0549e f3661a;

    /* renamed from: c */
    private static final InterfaceC2558b f3662c;

    /* renamed from: b */
    final C0545a f3663b;

    static {
        try {
            f3662c = C2568c.m15995a(Class.forName("c.a.a.b"));
            f3661a = new AbstractC0549e() { // from class: c.a.a.b.1
                @Override // p060c.p061a.p062a.AbstractC0549e
                /* renamed from: a */
                public AbstractC0549e mo4019a(String str, String str2) {
                    return this;
                }
            };
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public C0546b(byte[] bArr) {
        this.f3663b = new C0545a(bArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a2, code lost:
    
        return;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m4018a(C0547c c0547c) {
        Stack stack = new Stack();
        AbstractC0549e abstractC0549e = c0547c;
        while (true) {
            int m4017g = this.f3663b.m4017g();
            switch (m4017g) {
                case 1:
                case 5:
                    break;
                case 2:
                    stack.push(abstractC0549e);
                    abstractC0549e = abstractC0549e.mo4019a(this.f3663b.m4014e(), this.f3663b.m4009c());
                    if (abstractC0549e != null) {
                        if (abstractC0549e == f3661a) {
                            break;
                        } else {
                            abstractC0549e.mo4030a(this.f3663b.m4007b());
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 < this.f3663b.m4005a()) {
                                    abstractC0549e.mo4032a(this.f3663b.m4008b(i2), this.f3663b.m4006a(i2), this.f3663b.m4011d(i2), this.f3663b.m4013e(i2), this.f3663b.m4015f(i2));
                                    i = i2 + 1;
                                }
                            }
                        }
                    } else {
                        abstractC0549e = f3661a;
                        break;
                    }
                    break;
                case 3:
                    abstractC0549e.mo4024a();
                    abstractC0549e = (AbstractC0549e) stack.pop();
                    break;
                case 4:
                    c0547c.mo4020a(this.f3663b.m4012d(), this.f3663b.m4014e(), this.f3663b.m4007b());
                    break;
                case 6:
                    abstractC0549e.mo4031a(this.f3663b.m4007b(), this.f3663b.m4016f());
                    break;
                case 7:
                    break;
                default:
                    f3662c.mo15942c("Unsupported tag: {}", new Integer(m4017g));
                    break;
            }
        }
    }
}
