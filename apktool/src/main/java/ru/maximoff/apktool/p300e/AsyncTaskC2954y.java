package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.content.p006pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.srizwan.apktool.R;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import org.p217b.p218a.p219a.C1887e;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3060a;
import ru.maximoff.apktool.util.C3066aa;
import ru.maximoff.apktool.util.C3067ab;
import ru.maximoff.apktool.util.C3068ac;
import ru.maximoff.apktool.util.C3072ad;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3099ba;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3246h;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.C3252l;
import ru.maximoff.apktool.util.C3262u;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: IconTask.java */
/* renamed from: ru.maximoff.apktool.e.y */
/* loaded from: classes.dex */
public class AsyncTaskC2954y extends AsyncTask<File, Integer, Bitmap> {

    /* renamed from: a */
    private int f15819a;

    /* renamed from: b */
    private int f15820b;

    /* renamed from: c */
    private ImageView f15821c;

    /* renamed from: d */
    private Context f15822d;

    /* renamed from: e */
    private C3066aa f15823e;

    /* renamed from: f */
    private String f15824f;

    /* renamed from: g */
    private Drawable f15825g;

    /* renamed from: h */
    private int f15826h;

    /* renamed from: i */
    private boolean f15827i;

    /* renamed from: j */
    private boolean f15828j;

    /* renamed from: k */
    private C2604w f15829k;

    /* renamed from: l */
    private InterfaceC2995n f15830l;

    /* renamed from: m */
    private Object f15831m;

    /* renamed from: n */
    private Resources f15832n = (Resources) null;

    /* renamed from: o */
    private int f15833o;

    @Override // android.os.AsyncTask
    protected Bitmap doInBackground(File[] fileArr) {
        return m17592a(fileArr);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled(Bitmap bitmap) {
        m17597b(bitmap);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Bitmap bitmap) {
        m17593a(bitmap);
    }

    public AsyncTaskC2954y(Context context, ImageView imageView, InterfaceC2995n interfaceC2995n) {
        this.f15819a = 48;
        this.f15820b = 1;
        this.f15819a = C3080al.m18574b(context, 36);
        this.f15820b = Math.max(1, this.f15819a / 48);
        this.f15833o = C3246h.m19470a(context, C3102bd.f18291a ? R.color.colorFolderLight : R.color.colorFolderDark);
        this.f15822d = context;
        this.f15821c = imageView;
        this.f15831m = imageView.getTag();
        if (this.f15831m == null) {
            this.f15831m = new Object();
        }
        this.f15830l = interfaceC2995n;
        this.f15824f = String.valueOf(C3102bd.f18319b);
        this.f15829k = (C2604w) null;
        this.f15827i = false;
        this.f15828j = false;
        this.f15823e = new C3066aa(context);
        this.f15826h = C3246h.m19470a(context, R.color.ic_outline_color);
        switch (C3102bd.f18319b) {
            case 1:
                this.f15826h = C3246h.m19470a(context, R.color.ic_outline_color);
                break;
            case 2:
                this.f15826h = C3246h.m19470a(context, R.color.ic_outline_color_dark);
                break;
            default:
                this.f15826h = C3246h.m19470a(context, R.color.ic_outline_color);
                break;
        }
    }

    /* renamed from: a */
    public void m17596a(C2604w c2604w, boolean z, boolean z2, Resources resources) {
        this.f15829k = c2604w;
        this.f15827i = z;
        this.f15828j = z2;
        this.f15832n = resources;
    }

    /* renamed from: a */
    public void m17595a(String str) {
        this.f15824f = new StringBuffer().append(String.valueOf(C3102bd.f18319b)).append(str).toString();
    }

    /* renamed from: a */
    public void m17594a(Drawable drawable) {
        this.f15825g = drawable;
    }

    /* JADX WARN: Removed duplicated region for block: B:172:0x0689  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0436 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0591 A[Catch: Exception -> 0x058e, all -> 0x059f, TryCatch #24 {Exception -> 0x058e, all -> 0x059f, blocks: (B:252:0x0535, B:254:0x053d, B:267:0x056e, B:270:0x058a, B:271:0x058d, B:275:0x0571, B:276:0x057b, B:278:0x0591, B:331:0x0597, B:280:0x05a5, B:283:0x05bb, B:286:0x05c7, B:298:0x05f2, B:300:0x0609, B:303:0x0629, B:305:0x0637, B:306:0x063f, B:308:0x060f, B:317:0x0622, B:318:0x0628), top: B:251:0x0535 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected Bitmap m17592a(File[] fileArr) {
        C2604w c2604w;
        Enumeration<C2602u> m16163b;
        Throwable th;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        C3060a c3060a;
        Throwable th2;
        InputStream inputStream2;
        BufferedInputStream bufferedInputStream;
        int[] m18400a;
        String parent;
        Throwable th3;
        InputStream inputStream3;
        Throwable th4;
        InputStream inputStream4;
        BufferedInputStream bufferedInputStream2;
        C3099ba c3099ba;
        Throwable th5;
        InputStream inputStream5;
        BufferedInputStream bufferedInputStream3;
        byte[] m13984b;
        Drawable m18382a;
        File file = fileArr[0];
        Bitmap m18375a = file.isDirectory() ? C3067ab.m18375a(file, new StringBuffer().append(new StringBuffer().append(this.f15824f).append(String.valueOf(C3102bd.f18270F)).toString()).append(String.valueOf(this.f15833o)).toString()) : C3067ab.m18375a(file, this.f15824f);
        if (m18375a != null) {
            return m18375a;
        }
        if (isCancelled()) {
            return (Bitmap) null;
        }
        if (this.f15829k == null) {
            if (file.isDirectory()) {
                if (file.getAbsolutePath().startsWith(C3249i.f19549i)) {
                    try {
                        C3252l c3252l = new C3252l(this.f15822d);
                        c3252l.m19511e();
                        String m19505a = c3252l.m19505a(file.getAbsolutePath().substring(C3249i.f19549i.length()));
                        if (m19505a != null) {
                            this.f15824f = new StringBuffer().append(this.f15824f).append(new StringBuffer().append(String.valueOf(C3102bd.f18270F)).append(String.valueOf(this.f15833o)).toString()).toString();
                            PackageManager packageManager = this.f15822d.getPackageManager();
                            Bitmap m18370a = C3067ab.m18370a(this.f15823e.m18363a(this.f15833o, R.drawable.ic_folder), packageManager.getPackageInfo(m19505a, 128).applicationInfo.loadIcon(packageManager));
                            C3067ab.m18392b(m18370a, file, this.f15824f);
                            return m18370a;
                        }
                    } catch (Exception e2) {
                    }
                } else if (C3262u.m19674l(file)) {
                    String parent2 = file.getParent();
                    String[] m19640b = C3262u.m19640b(this.f15822d);
                    if (m19640b != null && parent2 != null) {
                        String lowerCase = parent2.toLowerCase();
                        int i = 0;
                        while (true) {
                            if (i >= m19640b.length) {
                                break;
                            }
                            String str = m19640b[i];
                            if (lowerCase.equals(new StringBuffer().append(str).append(C3249i.f19551k).toString().toLowerCase()) || lowerCase.equals(new StringBuffer().append(str).append(C3249i.f19552l).toString().toLowerCase()) || lowerCase.equals(new StringBuffer().append(str).append(C3249i.f19553m).toString().toLowerCase()) || lowerCase.equals(new StringBuffer().append(str).append(C3249i.f19554n).toString().toLowerCase())) {
                                try {
                                    this.f15824f = new StringBuffer().append(this.f15824f).append(new StringBuffer().append(String.valueOf(C3102bd.f18270F)).append(String.valueOf(this.f15833o)).toString()).toString();
                                    PackageManager packageManager2 = this.f15822d.getPackageManager();
                                    Bitmap m18370a2 = C3067ab.m18370a(this.f15823e.m18363a(this.f15833o, R.drawable.ic_folder), packageManager2.getPackageInfo(file.getName(), 128).applicationInfo.loadIcon(packageManager2));
                                    C3067ab.m18392b(m18370a2, file, this.f15824f);
                                    return m18370a2;
                                } catch (Exception e3) {
                                }
                            } else {
                                i++;
                            }
                        }
                    }
                } else if (file.getAbsolutePath().startsWith(C3249i.f19550j) && (parent = file.getParent()) != null && parent.equals(C3249i.f19550j)) {
                    try {
                        this.f15824f = new StringBuffer().append(this.f15824f).append(new StringBuffer().append(String.valueOf(C3102bd.f18270F)).append(String.valueOf(this.f15833o)).toString()).toString();
                        PackageManager packageManager3 = this.f15822d.getPackageManager();
                        Bitmap m18370a3 = C3067ab.m18370a(this.f15823e.m18363a(this.f15833o, R.drawable.ic_folder), packageManager3.getPackageInfo(file.getName(), 128).applicationInfo.loadIcon(packageManager3));
                        C3067ab.m18392b(m18370a3, file, this.f15824f);
                        return m18370a3;
                    } catch (Exception e4) {
                    }
                }
                return this.f15823e.m18363a(this.f15833o, R.drawable.ic_folder);
            }
            String lowerCase2 = file.getName().toLowerCase();
            if (C3072ad.m18431b(lowerCase2)) {
                C3099ba c3099ba2 = new C3099ba(this.f15822d, file);
                if (c3099ba2 != null && c3099ba2.m18881j()) {
                    if (this.f15830l != null && this.f15830l.mo17952g() != null && (c3099ba2.m18879h() || c3099ba2.m18880i())) {
                        c3099ba2.m18871a(this.f15830l.mo17952g());
                    }
                    try {
                        Bitmap m18378a = C3067ab.m18378a(c3099ba2.m18882k(), this.f15819a, this.f15819a);
                        if (C3102bd.f18288X) {
                            m18378a = C3067ab.m18396c(m18378a, this.f15820b, this.f15826h);
                        }
                        C3067ab.m18392b(m18378a, file, this.f15824f);
                        return m18378a;
                    } catch (Exception e5) {
                    }
                } else if (lowerCase2.endsWith(".xml")) {
                    try {
                        Drawable m18380a = C3067ab.m18380a(this.f15822d, file);
                        if (m18380a != null) {
                            Bitmap m18368a = C3067ab.m18368a(C3067ab.m18372a(m18380a), this.f15819a);
                            if (C3102bd.f18288X) {
                                m18368a = C3067ab.m18396c(m18368a, this.f15820b, this.f15826h);
                            }
                            C3067ab.m18392b(m18368a, file, this.f15824f);
                            return m18368a;
                        }
                    } catch (Exception e6) {
                    }
                }
            } else {
                if (lowerCase2.endsWith(".apk")) {
                    if (this.f15825g != null) {
                        try {
                            Bitmap m18368a2 = C3067ab.m18368a(C3067ab.m18372a(this.f15825g), this.f15819a);
                            if (C3102bd.f18288X) {
                                m18368a2 = C3067ab.m18396c(m18368a2, this.f15820b, this.f15826h);
                            }
                            C3067ab.m18392b(m18368a2, file, this.f15824f);
                            return m18368a2;
                        } catch (Exception e7) {
                        }
                    }
                    C3060a c3060a2 = new C3060a(this.f15822d, file.getAbsolutePath());
                    if (c3060a2.m18255D() && c3060a2.m18266d() != null) {
                        try {
                            Bitmap m18368a3 = C3067ab.m18368a(c3060a2.m18266d(), this.f15819a);
                            if (C3102bd.f18288X) {
                                m18368a3 = C3067ab.m18396c(m18368a3, this.f15820b, this.f15826h);
                            }
                            C3067ab.m18392b(m18368a3, file, this.f15824f);
                            return m18368a3;
                        } catch (Exception e8) {
                        }
                    }
                    return this.f15823e.m18363a(Color.GRAY, R.drawable.ic_apk);
                }
                if (lowerCase2.endsWith(".apks") || lowerCase2.endsWith(".xapk") || lowerCase2.endsWith(".apkm")) {
                    if (lowerCase2.endsWith(".apkm") && !C3262u.m19654d(file)) {
                        int[] m18400a2 = C3068ac.m18400a(this.f15822d, lowerCase2);
                        return this.f15823e.m18363a(m18400a2[1], m18400a2[0]);
                    }
                    C2604w c2604w2 = (C2604w) null;
                    try {
                        c2604w = new C2604w(file);
                    } catch (Exception e9) {
                    } catch (Throwable th6) {
                        th = th6;
                        c2604w = c2604w2;
                    }
                    try {
                        C2602u m16162a = c2604w.m16162a("icon.png");
                        if (m16162a != null) {
                            InputStream inputStream6 = (InputStream) null;
                            try {
                                bufferedInputStream = new BufferedInputStream(c2604w.m16160a(m16162a), C3249i.m19500a());
                            } catch (Exception e10) {
                            } catch (Throwable th7) {
                                th2 = th7;
                                inputStream2 = inputStream6;
                            }
                            try {
                                Bitmap m18376a = C3067ab.m18376a(bufferedInputStream, this.f15819a);
                                if (C3102bd.f18288X) {
                                    m18376a = C3067ab.m18396c(m18376a, this.f15820b, this.f15826h);
                                }
                                C3067ab.m18392b(m18376a, file, this.f15824f);
                                C1887e.m13970a((InputStream) bufferedInputStream);
                                C1887e.m13969a(c2604w);
                                return m18376a;
                            } catch (Exception e11) {
                                inputStream6 = bufferedInputStream;
                                C1887e.m13970a(inputStream6);
                                m16163b = c2604w.m16163b();
                                byte[] bArr = new byte[C3249i.m19500a()];
                                while (m16163b.hasMoreElements()) {
                                }
                                c2604w2 = c2604w;
                                C1887e.m13969a(c2604w2);
                                m18400a = C3068ac.m18400a(this.f15822d, lowerCase2);
                                if (m18400a[0] == R.drawable.ic_image) {
                                }
                            } catch (Throwable th8) {
                                th2 = th8;
                                inputStream2 = bufferedInputStream;
                                C1887e.m13970a(inputStream2);
                                throw th2;
                            }
                        }
                        m16163b = c2604w.m16163b();
                        byte[] bArr2 = new byte[C3249i.m19500a()];
                        while (m16163b.hasMoreElements()) {
                            if (isCancelled()) {
                                Bitmap bitmap = (Bitmap) null;
                                C1887e.m13969a(c2604w);
                                return bitmap;
                            }
                            C2602u nextElement = m16163b.nextElement();
                            if (nextElement.getName().toLowerCase().endsWith(".apk") && !nextElement.getName().contains(File.separator)) {
                                File createTempFile = File.createTempFile("AM_TempApkITs_", ".tmp", C3102bd.m18908a());
                                InputStream inputStream7 = (InputStream) null;
                                FileOutputStream fileOutputStream2 = (FileOutputStream) null;
                                try {
                                    inputStream = new BufferedInputStream(c2604w.m16160a(nextElement), C3249i.m19500a());
                                    try {
                                        fileOutputStream = new FileOutputStream(createTempFile);
                                        while (true) {
                                            try {
                                                int read = inputStream.read(bArr2);
                                                if (read == -1) {
                                                    break;
                                                }
                                                fileOutputStream.write(bArr2, 0, read);
                                            } catch (Exception e12) {
                                                fileOutputStream2 = fileOutputStream;
                                                inputStream7 = inputStream;
                                                fileOutputStream = fileOutputStream2;
                                                inputStream = inputStream7;
                                                C1887e.m13970a(inputStream);
                                                C1887e.m13972a((OutputStream) fileOutputStream);
                                                c3060a = new C3060a(this.f15822d, createTempFile.getAbsolutePath());
                                                if (!c3060a.m18255D()) {
                                                }
                                                createTempFile.delete();
                                            } catch (Throwable th9) {
                                                th = th9;
                                                fileOutputStream2 = fileOutputStream;
                                                C1887e.m13970a(inputStream);
                                                C1887e.m13972a((OutputStream) fileOutputStream2);
                                                throw th;
                                            }
                                        }
                                    } catch (Exception e13) {
                                        inputStream7 = inputStream;
                                    } catch (Throwable th10) {
                                        th = th10;
                                    }
                                } catch (Exception e14) {
                                } catch (Throwable th11) {
                                    th = th11;
                                    inputStream = inputStream7;
                                }
                                C1887e.m13970a(inputStream);
                                C1887e.m13972a((OutputStream) fileOutputStream);
                                c3060a = new C3060a(this.f15822d, createTempFile.getAbsolutePath());
                                if (!c3060a.m18255D() && c3060a.m18266d() != null) {
                                    Bitmap m18368a4 = C3067ab.m18368a(c3060a.m18266d(), this.f15819a);
                                    if (C3102bd.f18288X) {
                                        m18368a4 = C3067ab.m18396c(m18368a4, this.f15820b, this.f15826h);
                                    }
                                    C3067ab.m18392b(m18368a4, file, this.f15824f);
                                    createTempFile.delete();
                                    C1887e.m13969a(c2604w);
                                    return m18368a4;
                                }
                                createTempFile.delete();
                            }
                        }
                        c2604w2 = c2604w;
                    } catch (Exception e15) {
                        c2604w2 = c2604w;
                    } catch (Throwable th12) {
                        th = th12;
                        C1887e.m13969a(c2604w);
                        throw th;
                    }
                    C1887e.m13969a(c2604w2);
                } else if (C3072ad.m18432c(lowerCase2)) {
                    try {
                        Bitmap m18368a5 = C3067ab.m18368a(ThumbnailUtils.createVideoThumbnail(file.getAbsolutePath(), 3), this.f15819a);
                        if (C3102bd.f18288X) {
                            m18368a5 = C3067ab.m18396c(m18368a5, this.f15820b, this.f15826h);
                        }
                        C3067ab.m18392b(m18368a5, file, this.f15824f);
                        return m18368a5;
                    } catch (Exception e16) {
                        return this.f15823e.m18363a(C3246h.m19470a(this.f15822d, R.color.colorVideo), R.drawable.ic_video);
                    }
                }
            }
            m18400a = C3068ac.m18400a(this.f15822d, lowerCase2);
            if (m18400a[0] == R.drawable.ic_image) {
                return this.f15823e.m18363a(m18400a[1], m18400a[0]);
            }
            try {
                Bitmap m18374a = C3067ab.m18374a(file, this.f15819a);
                if (C3102bd.f18288X) {
                    m18374a = C3067ab.m18396c(m18374a, this.f15820b, this.f15826h);
                }
                C3067ab.m18392b(m18374a, file, this.f15824f);
                return m18374a;
            } catch (Exception e17) {
                return this.f15823e.m18363a(Color.GRAY, R.drawable.ic_damage_dark);
            }
        }
        if (this.f15827i) {
            InputStream inputStream8 = (InputStream) null;
            try {
                bufferedInputStream3 = new BufferedInputStream(this.f15829k.m16160a(this.f15829k.m16162a(this.f15824f.substring(1))), C3249i.m19500a());
                try {
                    m13984b = C1887e.m13984b(bufferedInputStream3);
                    m18382a = C3067ab.m18382a(this.f15822d, m13984b, this.f15832n);
                } catch (Exception e18) {
                    inputStream8 = bufferedInputStream3;
                } catch (Throwable th13) {
                    th5 = th13;
                    inputStream5 = bufferedInputStream3;
                    C1887e.m13970a(inputStream5);
                    throw th5;
                }
            } catch (Exception e19) {
            } catch (Throwable th14) {
                th5 = th14;
                inputStream5 = inputStream8;
            }
            if (m18382a != null) {
                Bitmap m18368a6 = C3067ab.m18368a(C3067ab.m18372a(m18382a), this.f15819a);
                if (C3102bd.f18288X) {
                    m18368a6 = C3067ab.m18396c(m18368a6, this.f15820b, this.f15826h);
                }
                C3067ab.m18392b(m18368a6, file, this.f15824f);
                C1887e.m13970a((InputStream) bufferedInputStream3);
                return m18368a6;
            }
            C3099ba c3099ba3 = new C3099ba(this.f15822d, m13984b);
            if (c3099ba3 == null || !c3099ba3.m18881j()) {
                inputStream8 = bufferedInputStream3;
                C1887e.m13970a(inputStream8);
                return this.f15823e.m18363a(C3246h.m19470a(this.f15822d, R.color.colorText), R.drawable.ic_text);
            }
            Bitmap m18378a2 = C3067ab.m18378a(c3099ba3.m18882k(), this.f15819a, this.f15819a);
            if (C3102bd.f18288X) {
                m18378a2 = C3067ab.m18396c(m18378a2, this.f15820b, this.f15826h);
            }
            C3067ab.m18392b(m18378a2, file, this.f15824f);
            C1887e.m13970a((InputStream) bufferedInputStream3);
            return m18378a2;
        }
        if (this.f15828j) {
            InputStream inputStream9 = (InputStream) null;
            try {
                bufferedInputStream2 = new BufferedInputStream(this.f15829k.m16160a(this.f15829k.m16162a(this.f15824f.substring(1))), C3249i.m19500a());
            } catch (Exception e20) {
            } catch (Throwable th15) {
                th4 = th15;
                inputStream4 = inputStream9;
            }
            try {
                c3099ba = new C3099ba(this.f15822d, bufferedInputStream2);
            } catch (Exception e21) {
                inputStream9 = bufferedInputStream2;
            } catch (Throwable th16) {
                th4 = th16;
                inputStream4 = bufferedInputStream2;
                C1887e.m13970a(inputStream4);
                throw th4;
            }
            if (c3099ba == null || !c3099ba.m18881j()) {
                inputStream9 = bufferedInputStream2;
                C1887e.m13970a(inputStream9);
                return this.f15823e.m18363a(C3246h.m19470a(this.f15822d, R.color.colorText), R.drawable.ic_text);
            }
            Bitmap m18378a3 = C3067ab.m18378a(c3099ba.m18882k(), this.f15819a, this.f15819a);
            if (C3102bd.f18288X) {
                m18378a3 = C3067ab.m18396c(m18378a3, this.f15820b, this.f15826h);
            }
            C3067ab.m18392b(m18378a3, file, this.f15824f);
            C1887e.m13970a((InputStream) bufferedInputStream2);
            return m18378a3;
        }
        InputStream inputStream10 = (InputStream) null;
        try {
            BufferedInputStream bufferedInputStream4 = new BufferedInputStream(this.f15829k.m16160a(this.f15829k.m16162a(this.f15824f.substring(1))), C3249i.m19500a());
            try {
                Bitmap m18376a2 = C3067ab.m18376a(bufferedInputStream4, this.f15819a);
                if (C3102bd.f18288X) {
                    m18376a2 = C3067ab.m18396c(m18376a2, this.f15820b, this.f15826h);
                }
                C3067ab.m18392b(m18376a2, file, this.f15824f);
                C1887e.m13970a((InputStream) bufferedInputStream4);
                return m18376a2;
            } catch (Exception e22) {
                inputStream10 = bufferedInputStream4;
                C1887e.m13970a(inputStream10);
                return this.f15823e.m18363a(Color.GRAY, R.drawable.ic_damage_dark);
            } catch (Throwable th17) {
                th3 = th17;
                inputStream3 = bufferedInputStream4;
                C1887e.m13970a(inputStream3);
                throw th3;
            }
        } catch (Exception e23) {
        } catch (Throwable th18) {
            th3 = th18;
            inputStream3 = inputStream10;
        }
    }

    /* renamed from: a */
    protected void m17593a(Bitmap bitmap) {
        C2919au.m17345d();
        if (!this.f15831m.equals(this.f15821c.getTag())) {
            if (bitmap != null) {
                bitmap.recycle();
            }
        } else if (bitmap != null) {
            this.f15821c.setImageBitmap(bitmap);
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        C2919au.m17345d();
    }

    /* renamed from: b */
    protected void m17597b(Bitmap bitmap) {
        C2919au.m17345d();
    }
}
