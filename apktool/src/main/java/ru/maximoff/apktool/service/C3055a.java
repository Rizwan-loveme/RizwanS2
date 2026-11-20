package ru.maximoff.apktool.service;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.srizwan.apktool.R;
import java.io.File;
import java.util.BitSet;
import java.util.Iterator;
import org.p210a.p211a.p212a.AbstractC1873u;
import org.p210a.p211a.p212a.AbstractC1877y;
import org.p210a.p211a.p212a.C1874v;
import org.p210a.p211a.p212a.C1876x;
import org.p210a.p211a.p212a.InterfaceC1758a;
import org.p210a.p211a.p212a.InterfaceC1819ac;
import org.p210a.p211a.p212a.p213a.C1793c;
import org.p210a.p211a.p212a.p214b.C1827a;
import org.p210a.p211a.p212a.p215c.C1843m;
import ru.maximoff.apktool.fragment.p302b.C2986e;
import ru.maximoff.apktool.util.C3066aa;
import ru.maximoff.apktool.util.C3246h;

/* compiled from: FileItem.java */
/* renamed from: ru.maximoff.apktool.service.a */
/* loaded from: classes.dex */
public class C3055a extends C2986e implements InterfaceC1758a {

    /* renamed from: c */
    private final File f17131c;

    @Override // org.p210a.p211a.p212a.InterfaceC1758a
    /* renamed from: a */
    public void mo13477a(AbstractC1873u abstractC1873u, C1827a c1827a, int i, int i2, int i3, C1793c c1793c) {
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1758a
    /* renamed from: a */
    public void mo13478a(AbstractC1873u abstractC1873u, C1827a c1827a, int i, int i2, BitSet bitSet, C1793c c1793c) {
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1758a
    /* renamed from: a */
    public void mo13479a(AbstractC1873u abstractC1873u, C1827a c1827a, int i, int i2, boolean z, BitSet bitSet, C1793c c1793c) {
    }

    @Override // ru.maximoff.apktool.fragment.p302b.C2986e
    /* renamed from: d */
    public CharSequence mo17886d() {
        return m18180a();
    }

    @Override // ru.maximoff.apktool.fragment.p302b.C2986e
    /* renamed from: e */
    public CharSequence mo17887e() {
        return m18182i();
    }

    public C3055a(String str) {
        this(new File(str));
    }

    public C3055a(File file) {
        super("", "");
        this.f17131c = file;
    }

    /* renamed from: a */
    public String m18180a() {
        return this.f17131c.getName();
    }

    /* renamed from: i */
    public String m18182i() {
        return this.f17131c.getAbsolutePath();
    }

    @Override // ru.maximoff.apktool.fragment.p302b.C2986e
    /* renamed from: a */
    public void mo17836a(ImageView imageView) {
        Context c2 = m17885c();
        imageView.setImageBitmap(new C3066aa(c2).m18363a(C3246h.m19470a(c2, R.color.colorText), R.drawable.ic_text));
    }

    /* renamed from: b */
    public boolean m18181b(int i) {
        synchronized (this.f16433b) {
            try {
                Iterator<C2986e> it = this.f16433b.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (i >= aVar.f17132c && i <= aVar.f17133d) {
                        return true;
                    }
                }
            } catch (Exception e2) {
            }
            return false;
        }
    }

    /* renamed from: j */
    public File m18183j() {
        return this.f17131c;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.C2986e
    /* renamed from: a */
    public void mo17838a(View view) {
        this.f16432a.m17636a(this.f17131c);
    }

    @Override // ru.maximoff.apktool.fragment.p302b.C2986e
    /* renamed from: a */
    public void mo17883a(C2986e c2986e) {
        if (!(c2986e instanceof a)) {
            throw new RuntimeException("FileItem only can add FileItem.child!");
        }
        super.mo17883a(c2986e);
    }

    @Override // ru.maximoff.apktool.fragment.p302b.C2986e
    /* renamed from: b */
    public void mo17859b() {
        super.mo17859b();
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1758a
    /* renamed from: a */
    public void mo13480a(AbstractC1877y<?, ?> abstractC1877y, Object obj, int i, int i2, String str, C1876x c1876x) {
        String string;
        Context c2 = m17885c();
        if (c2 == null) {
            string = String.format("line %d", new Integer(i));
        } else {
            string = c2.getString(R.string.linef, new Integer(i));
        }
        mo17883a(new a(this, str, string, obj));
    }

    /* compiled from: FileItem.java */
    /* renamed from: ru.maximoff.apktool.service.a$a */
    private class a extends C2986e {

        /* renamed from: c */
        private final int f17132c;

        /* renamed from: d */
        private final int f17133d;

        /* renamed from: e */
        private C3066aa f17134e;

        /* renamed from: f */
        private final C3055a f17135f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(C3055a c3055a, CharSequence charSequence, CharSequence charSequence2, Object obj) {
            super(charSequence, charSequence2);
            this.f17135f = c3055a;
            this.f17134e = new C3066aa(m17885c());
            if (obj instanceof InterfaceC1819ac) {
                InterfaceC1819ac interfaceC1819ac = (InterfaceC1819ac) obj;
                this.f17132c = interfaceC1819ac.mo13677f();
                this.f17133d = interfaceC1819ac.mo13678g();
            } else if (obj instanceof C1843m) {
                C1843m c1843m = (C1843m) obj;
                this.f17132c = ((Integer) c1843m.f10912a).intValue();
                this.f17133d = ((Integer) c1843m.f10913b).intValue();
            } else if (obj instanceof C1874v) {
                C1874v c1874v = (C1874v) obj;
                this.f17132c = c1874v.f11000f.mo13677f();
                this.f17133d = c1874v.f11001g.mo13678g();
            } else {
                this.f17132c = 0;
                this.f17133d = 0;
            }
        }

        @Override // ru.maximoff.apktool.fragment.p302b.C2986e
        /* renamed from: a */
        public void mo17836a(ImageView imageView) {
            imageView.setImageBitmap(this.f17134e.m18363a(0, R.drawable.ic_error));
        }

        @Override // ru.maximoff.apktool.fragment.p302b.C2986e
        /* renamed from: a */
        public void mo17838a(View view) {
            this.f16432a.m17637a(this.f17135f.f17131c, this.f17132c, this.f17133d);
        }
    }
}
