package p046b.p047a.p056d;

import com.srizwan.apktool.R;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import org.p226d.p233b.C2359g;
import org.p226d.p233b.p250e.InterfaceC2244d;
import org.p226d.p233b.p264i.p265a.C2398d;
import org.p226d.p233b.p264i.p266b.C2409i;
import p046b.p047a.C0461b;
import p046b.p058c.C0529d;
import p046b.p058c.C0530e;
import p046b.p059d.InterfaceC0541f;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.p295a.C2608a;

/* compiled from: SmaliBuilder.java */
/* renamed from: b.a.d.a */
/* loaded from: classes.dex */
public class C0519a {

    /* renamed from: a */
    private final C0530e f3602a;

    /* renamed from: b */
    private final File f3603b;

    /* renamed from: c */
    private final int f3604c;

    /* renamed from: d */
    private final InterfaceC0541f f3605d;

    /* renamed from: e */
    private final ExecutorService f3606e = Executors.newFixedThreadPool(C3102bd.f18298af);

    /* renamed from: a */
    public static void m3893a(C0530e c0530e, File file, int i, InterfaceC0541f interfaceC0541f) {
        new C0519a(c0530e, file, i, interfaceC0541f).m3892a();
    }

    C0519a(C0530e c0530e, File file, int i, InterfaceC0541f interfaceC0541f) {
        this.f3605d = interfaceC0541f;
        this.f3602a = c0530e;
        this.f3603b = file;
        this.f3604c = i;
    }

    /* renamed from: a */
    private void m3892a() {
        C2359g m15022a;
        try {
            if (!this.f3605d.mo3981a()) {
                if (this.f3604c > 0) {
                    m15022a = C2359g.m15023a(this.f3604c);
                } else {
                    m15022a = C2359g.m15022a();
                }
                C2409i c2409i = new C2409i(m15022a);
                LinkedList<Future<InterfaceC2244d>> linkedList = new LinkedList();
                Iterator<String> it = this.f3602a.m3953a().mo3908a(true).iterator();
                while (it.hasNext()) {
                    linkedList.add(this.f3606e.submit(new Callable<InterfaceC2244d>(this, it.next(), m15022a) { // from class: b.a.d.a.1

                        /* renamed from: a */
                        private final C0519a f3607a;

                        /* renamed from: b */
                        private final String f3608b;

                        /* renamed from: c */
                        private final C2359g f3609c;

                        {
                            this.f3607a = this;
                            this.f3608b = r2;
                            this.f3609c = m15022a;
                        }

                        @Override // java.util.concurrent.Callable
                        public InterfaceC2244d call() {
                            return m3896a();
                        }

                        /* renamed from: a */
                        public InterfaceC2244d m3896a() {
                            try {
                                return this.f3607a.m3891a(this.f3608b, this.f3609c);
                            } catch (Error e2) {
                                this.f3607a.f3605d.mo3979a(R.string.errorf, new StringBuffer().append(new StringBuffer().append(this.f3607a.f3602a.getName()).append("/").toString()).append(this.f3608b).toString());
                                throw e2;
                            } catch (Exception e3) {
                                this.f3607a.f3605d.mo3983c(R.string.errorf, new StringBuffer().append(new StringBuffer().append(this.f3607a.f3602a.getName()).append("/").toString()).append(this.f3608b).toString());
                                throw e3;
                            }
                        }
                    }));
                }
                boolean z = false;
                for (Future<InterfaceC2244d> future : linkedList) {
                    if (z) {
                        future.cancel(false);
                    } else if (!m3894a(future, c2409i)) {
                        z = true;
                    }
                }
                if (z) {
                    throw new C0461b("Build smali failed!");
                }
                c2409i.m15405a(new C2398d(new File(this.f3603b.getAbsolutePath())));
            }
        } catch (C0529d e2) {
            e = e2;
            throw new C0461b(e);
        } catch (IOException e3) {
            e = e3;
            throw new C0461b(e);
        }
    }

    /* renamed from: a */
    private boolean m3894a(Future<InterfaceC2244d> future, C2409i c2409i) {
        while (true) {
            try {
                InterfaceC2244d interfaceC2244d = future.get();
                if (interfaceC2244d == null) {
                    break;
                }
                c2409i.m15249a(interfaceC2244d);
                break;
            } catch (Error e2) {
                this.f3605d.mo3979a(R.string.errorf, e2.getMessage());
                return false;
            } catch (InterruptedException e3) {
            } catch (Exception e4) {
                this.f3605d.mo3980a(Level.WARNING, "Build smali failed!", e4.getCause());
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public InterfaceC2244d m3891a(String str, C2359g c2359g) {
        File file = new File(this.f3602a, str);
        if (str.endsWith(".smali")) {
            InterfaceC2244d m16251a = C2608a.m16251a(file, c2359g);
            if (m16251a == null) {
                throw new C0461b(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("Failed to compile the \"").append(this.f3602a.getName()).toString()).append("/").toString()).append(str).toString()).append("\" file!").toString());
            }
            return m16251a;
        }
        if (!str.matches("^\\.dex03(7|8|9)$")) {
            this.f3605d.mo3983c(R.string.text, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("Unknown file type, ignoring: \"").append(this.f3602a.getName()).toString()).append("/").toString()).append(str).toString()).append("\"").toString());
        }
        return (InterfaceC2244d) null;
    }
}
