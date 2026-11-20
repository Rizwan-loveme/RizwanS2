package ru.maximoff.apktool.p296a;

import com.p063a.p064a.C0571t;
import com.p063a.p064a.C0572u;
import com.p063a.p064a.C0573v;
import com.p065b.p066a.p067a.AbstractC0581c;
import com.p159h.p160a.p162b.AbstractC1381c;
import com.p159h.p160a.p162b.AbstractC1389k;
import com.p159h.p160a.p162b.C1388j;
import com.p159h.p160a.p162b.C1397s;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.p209io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.p210a.p211a.p212a.C1830c;
import org.p210a.p211a.p212a.C1864l;
import org.p210a.p211a.p212a.InterfaceC1819ac;
import org.p210a.p211a.p212a.InterfaceC1822af;
import org.p210a.p211a.p212a.InterfaceC1858f;
import org.p210a.p211a.p212a.p216d.InterfaceC1849d;
import org.p210a.p211a.p212a.p216d.InterfaceC1854i;
import ru.maximoff.apktool.service.C3055a;
import ru.maximoff.apktool.util.C3090av;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.p303a.C3061a;

/* compiled from: XmlLexTask.java */
/* renamed from: ru.maximoff.apktool.a.m */
/* loaded from: classes.dex */
public class C2893m extends AbstractC2881a<C0571t> {

    /* renamed from: c */
    protected final C0572u f14859c;

    /* renamed from: d */
    protected C0572u.d f14860d;

    /* renamed from: e */
    private final C0571t f14861e;

    /* renamed from: f */
    private C3055a f14862f;

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: a */
    protected /* bridge */ int mo16887a(C1388j c1388j, C0571t c0571t, int i, int i2) {
        return a2(c1388j, c0571t, i, i2);
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: a */
    protected /* bridge */ void mo16888a(List list, C0571t c0571t) {
        a2((List<C1397s<AbstractC1381c.a>>) list, c0571t);
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: a */
    protected /* bridge */ void mo16890a(C0571t c0571t) {
        a2(c0571t);
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: g */
    protected C0571t mo16892g() {
        return m16932j();
    }

    public C2893m(C3055a c3055a) {
        super(new a(c3055a), c3055a);
        this.f14862f = c3055a;
        this.f14859c = new C0572u((InterfaceC1822af) null);
        if (c3055a != null) {
            this.f14859c.m13927cD();
            this.f14859c.m13925a(c3055a);
        }
        this.f14861e = m16932j();
        this.f14860d = (C0572u.d) null;
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: i */
    protected InterfaceC1849d mo16894i() {
        return this.f14860d;
    }

    /* renamed from: j */
    protected C0571t m16932j() {
        C0571t c0571t = new C0571t((InterfaceC1858f) null);
        if (this.f14862f != null) {
            c0571t.m13927cD();
            c0571t.m13925a(this.f14862f);
        }
        return c0571t;
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    protected void a2(List<C1397s<AbstractC1381c.a>> list, C0571t c0571t) {
        InterfaceC1819ac f2;
        AbstractC1381c.a aVar;
        int i = 0;
        this.f14860d = (C0572u.d) null;
        while (true) {
            int i2 = i;
            if (this.f9035a || (i = (f2 = c0571t.mo4722f()).mo13672a()) == -1) {
                return;
            }
            switch (i) {
                case 1:
                    aVar = AbstractC1381c.a.f9003i;
                    break;
                case 2:
                case 4:
                case 5:
                case 6:
                case 9:
                case 11:
                default:
                    aVar = AbstractC1381c.a.f9005k;
                    break;
                case 3:
                    aVar = AbstractC1381c.a.f9009o;
                    break;
                case 7:
                case 10:
                case 12:
                case 13:
                    aVar = AbstractC1381c.a.f9008n;
                    break;
                case 8:
                    m16931a(c0571t, 11);
                    aVar = AbstractC1381c.a.f9009o;
                    break;
                case 14:
                    aVar = AbstractC1381c.a.f9007m;
                    break;
                case 15:
                    aVar = AbstractC1381c.a.f9006l;
                    break;
                case 16:
                    if (i2 == 7 || i2 == 13) {
                        aVar = AbstractC1381c.a.f9004j;
                        break;
                    } else {
                        aVar = AbstractC1381c.a.f9010p;
                        break;
                    }
                    break;
            }
            list.add(new C1397s<>(f2.mo13678g(), aVar));
        }
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    protected void a2(C0571t c0571t) {
        if (this.f14862f != null) {
            this.f14862f.mo17859b();
        }
        this.f14859c.m13881a((InterfaceC1822af) new C1864l(c0571t));
        try {
            this.f14860d = this.f14859c.m5538e();
        } catch (Exception | StackOverflowError e2) {
            this.f14860d = (C0572u.d) null;
        }
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: f */
    protected boolean mo16891f() {
        return this.f14862f != null;
    }

    @Override // com.p159h.p160a.p162b.AbstractRunnableC1391m
    /* renamed from: d */
    public boolean mo11092d() {
        return true;
    }

    @Override // ru.maximoff.apktool.p296a.AbstractC2881a
    /* renamed from: a */
    protected void mo16889a(C1830c c1830c) {
        this.f14861e.m13860a(c1830c);
        a2(this.f14861e);
    }

    @Override // com.p159h.p160a.p162b.AbstractRunnableC1391m
    /* renamed from: a */
    public boolean mo11089a(int i) {
        C3055a c3055a = this.f14862f;
        if (c3055a == null) {
            return false;
        }
        return c3055a.m18181b(i);
    }

    /* renamed from: a */
    protected void m16931a(C0571t c0571t, int i) {
        while (c0571t.mo4722f().mo13672a() != i) {
        }
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    protected int a2(C1388j c1388j, C0571t c0571t, int i, int i2) {
        this.f14859c.m13881a((InterfaceC1822af) new C1864l(c0571t));
        b bVar = new b(this, c1388j, i, i2);
        try {
            this.f14859c.m5538e().mo4289a(bVar);
            return bVar.f14868e;
        } catch (Exception | StackOverflowError e2) {
            return 0;
        }
    }

    /* compiled from: XmlLexTask.java */
    /* renamed from: ru.maximoff.apktool.a.m$a */
    private static class a extends AbstractC1389k {

        /* renamed from: c */
        private List<C3090av> f14863c = new ArrayList();

        public a(C3055a c3055a) {
            String[] strArr;
            File parentFile;
            if (!C3102bd.f18309aq) {
                m11079a(new String[0]);
                return;
            }
            if (c3055a != null) {
                try {
                    File m18183j = c3055a.m18183j();
                    if (m18183j.getName().equals(AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME)) {
                        parentFile = new File(m18183j.getParentFile(), "res");
                    } else {
                        parentFile = m18183j.getParentFile().getParentFile();
                    }
                    if (parentFile != null && parentFile.isDirectory() && parentFile.getName().equals("res")) {
                        File file = new File(parentFile.getParentFile(), "apktool.json");
                        File file2 = new File(parentFile.getParentFile(), "apktool.yml");
                        File file3 = new File(parentFile, "/values/public.xml");
                        if ((file.isFile() || file2.isFile()) && file3.isFile()) {
                            this.f14863c.addAll(C3061a.m18326d(file3));
                            strArr = new String[]{"android:"};
                        } else {
                            strArr = new String[0];
                        }
                    } else {
                        strArr = new String[0];
                    }
                } catch (Exception e2) {
                    strArr = new String[0];
                }
            } else {
                strArr = new String[0];
            }
            m11079a(strArr);
        }

        @Override // com.p159h.p160a.p162b.AbstractC1389k
        /* renamed from: a */
        public CharSequence mo11078a(ArrayList<String> arrayList, CharSequence charSequence) {
            if (!C3102bd.f18309aq) {
                return super.mo11078a(arrayList, charSequence);
            }
            String charSequence2 = charSequence.toString();
            if (charSequence2.startsWith("android:")) {
                String substring = charSequence2.substring(8);
                try {
                    for (Field field : Class.forName("android.R$attr").getDeclaredFields()) {
                        if (Modifier.isStatic(field.getModifiers()) && !Modifier.isPrivate(field.getModifiers()) && field.getType().equals(Integer.TYPE)) {
                            String name = field.getName();
                            if (name.startsWith(substring)) {
                                arrayList.add(name);
                            }
                        }
                    }
                    return substring;
                } catch (ClassNotFoundException e2) {
                    throw new NoClassDefFoundError(e2.getMessage());
                }
            }
            if (charSequence.charAt(0) != '@' || this.f14863c == null || this.f14863c.isEmpty()) {
                return super.mo11078a(arrayList, charSequence);
            }
            for (C3090av c3090av : this.f14863c) {
                String stringBuffer = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("@").append(c3090av.m18724a()).toString()).append("/").toString()).append(c3090av.m18727b()).toString();
                if (stringBuffer.startsWith(charSequence2)) {
                    arrayList.add(stringBuffer);
                }
            }
            return charSequence2;
        }
    }

    /* compiled from: XmlLexTask.java */
    /* renamed from: ru.maximoff.apktool.a.m$b */
    private class b extends C0573v<Void> {

        /* renamed from: a */
        private C1388j f14864a;

        /* renamed from: b */
        private int f14865b;

        /* renamed from: c */
        private int f14866c;

        /* renamed from: d */
        private boolean f14867d = false;

        /* renamed from: e */
        private int f14868e;

        /* renamed from: f */
        private final C2893m f14869f;

        @Override // com.p063a.p064a.C0573v, com.p063a.p064a.InterfaceC0574w
        /* renamed from: a */
        public Object mo5551a(C0572u.a aVar) {
            return m16934b(aVar);
        }

        @Override // com.p063a.p064a.C0573v, com.p063a.p064a.InterfaceC0574w
        /* renamed from: a */
        public Object mo5555a(C0572u.e eVar) {
            return m16935b(eVar);
        }

        @Override // org.p210a.p211a.p212a.p216d.AbstractC1846a, org.p210a.p211a.p212a.p216d.InterfaceC1851f
        /* renamed from: a */
        public Object mo13783a(InterfaceC1854i interfaceC1854i) {
            return m16936b(interfaceC1854i);
        }

        public b(C2893m c2893m, C1388j c1388j, int i, int i2) {
            this.f14869f = c2893m;
            this.f14864a = c1388j;
            this.f14865b = i;
            this.f14866c = i2;
            this.f14868e = i2;
        }

        /* renamed from: b */
        public Void m16935b(C0572u.e eVar) {
            this.f14864a.m11076b('<');
            this.f14864a.m11073a(this.f14865b);
            eVar.m5548a(0).mo4289a(this);
            List<C0572u.a> m5550c = eVar.m5550c();
            this.f14867d = m5550c.size() > 1;
            Iterator<C0572u.a> it = m5550c.iterator();
            while (it.hasNext()) {
                it.next().mo4289a(this);
            }
            C0572u.c m5549b = eVar.m5549b();
            if (m5549b == null) {
                this.f14864a.m11070a((CharSequence) "/>");
                this.f14864a.m11077b(this.f14865b);
            } else {
                this.f14864a.m11076b('>');
                m5549b.mo4289a(this);
                this.f14864a.m11077b(this.f14865b);
                this.f14864a.m11070a((CharSequence) "</");
                m16936b(eVar.m5548a(1));
                this.f14864a.m11076b('>');
            }
            return (Void) null;
        }

        /* renamed from: b */
        public Void m16934b(C0572u.a aVar) {
            this.f14864a.m11076b(this.f14867d ? '\n' : ' ');
            aVar.m5546b().mo4289a(this);
            this.f14864a.m11076b('=');
            aVar.m5547c().mo4289a(this);
            return (Void) null;
        }

        /* renamed from: b */
        public Void m16936b(InterfaceC1854i interfaceC1854i) {
            if (interfaceC1854i == null) {
                return (Void) null;
            }
            InterfaceC1819ac mo13792a = interfaceC1854i.mo13792a();
            String mo13673b = mo13792a.mo13673b();
            switch (mo13792a.mo13672a()) {
                case 6:
                    C2891k.m16926a(this.f14864a, mo13673b);
                    break;
                case 11:
                    this.f14864a.m11076b(' ');
                    this.f14864a.m11070a((CharSequence) mo13673b);
                    break;
                default:
                    this.f14864a.m11070a((CharSequence) mo13673b);
                    break;
            }
            this.f14868e = AbstractC2881a.m16884a(this.f14864a.length(), mo13792a.mo13677f(), mo13792a.mo13678g(), this.f14866c, this.f14868e);
            return (Void) null;
        }
    }
}
