package p046b.p058c;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* compiled from: FileDirectory.java */
/* renamed from: b.c.f */
/* loaded from: classes.dex */
public class C0531f extends AbstractC0526a {

    /* renamed from: d */
    private File f3627d;

    public C0531f(File file) {
        if (!file.isDirectory()) {
            throw new C0529d(new StringBuffer().append("file must be a directory: ").append(file).toString());
        }
        this.f3627d = file;
    }

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: p */
    public long mo3951p(String str) {
        File file = new File(m3957r(str));
        if (!file.isFile()) {
            throw new C0529d(new StringBuffer().append("file must be a file: ").append(file).toString());
        }
        return file.length();
    }

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: q */
    public long mo3952q(String str) {
        File file = new File(m3957r(str));
        if (!file.exists()) {
            throw new C0529d(new StringBuffer().append("file not found: ").append(file).toString());
        }
        return file.lastModified();
    }

    @Override // p046b.p058c.AbstractC0526a
    /* renamed from: k */
    protected AbstractC0526a mo3933k(String str) {
        File file = new File(m3957r(str));
        file.mkdir();
        return new C0531f(file);
    }

    @Override // p046b.p058c.AbstractC0526a
    /* renamed from: i */
    protected InputStream mo3931i(String str) {
        try {
            return new FileInputStream(m3957r(str));
        } catch (FileNotFoundException e2) {
            throw new C0529d(e2);
        }
    }

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: o */
    public InputStream mo3950o(String str) {
        return mo3931i(str);
    }

    @Override // p046b.p058c.AbstractC0526a
    /* renamed from: j */
    protected OutputStream mo3932j(String str) {
        try {
            return new FileOutputStream(m3957r(str));
        } catch (FileNotFoundException e2) {
            throw new C0529d(e2);
        }
    }

    @Override // p046b.p058c.AbstractC0526a
    /* renamed from: f */
    protected void mo3928f() {
        m3955h();
    }

    @Override // p046b.p058c.AbstractC0526a
    /* renamed from: e */
    protected void mo3926e() {
        m3955h();
    }

    @Override // p046b.p058c.AbstractC0526a
    /* renamed from: l */
    protected void mo3934l(String str) {
        new File(m3957r(str)).delete();
    }

    /* renamed from: r */
    private String m3957r(String str) {
        return new StringBuffer().append(new StringBuffer().append(m3956i().getPath()).append('/').toString()).append(str).toString();
    }

    @Override // p046b.p058c.AbstractC0526a
    /* renamed from: m */
    protected File mo3935m(String str) {
        return new File(m3957r(str));
    }

    /* renamed from: h */
    private void m3955h() {
        this.f3617a = new LinkedHashSet();
        this.f3619c = new LinkedHashMap();
        for (File file : m3956i().listFiles()) {
            if (file.isFile()) {
                this.f3617a.add(file.getName());
            } else {
                try {
                    this.f3619c.put(file.getName(), new C0531f(file));
                } catch (C0529d e2) {
                }
            }
        }
    }

    /* renamed from: i */
    private File m3956i() {
        return this.f3627d;
    }

    @Override // p046b.p058c.InterfaceC0528c
    /* renamed from: g */
    public String mo3949g() {
        return this.f3627d.getAbsolutePath();
    }
}
