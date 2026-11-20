package ru.maximoff.apktool.p300e;

import android.content.Context;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p046b.p059d.C0542g;
import ru.maximoff.apktool.fragment.p301a.C2978b;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3262u;

/* compiled from: CopyTask.java */
/* renamed from: ru.maximoff.apktool.e.j */
/* loaded from: classes.dex */
public class AsyncTaskC2939j extends AbstractAsyncTaskC2898a {

    /* renamed from: a */
    private Context f15657a;

    /* renamed from: b */
    private String f15658b;

    /* renamed from: c */
    private boolean f15659c;

    /* renamed from: d */
    private boolean f15660d;

    /* renamed from: e */
    private Map<String, String> f15661e;

    /* renamed from: f */
    private Map<String, Long> f15662f;

    /* renamed from: g */
    private List<File> f15663g;

    /* renamed from: h */
    private int f15664h;

    /* renamed from: i */
    private int f15665i;

    /* renamed from: j */
    private int f15666j;

    public AsyncTaskC2939j(Context context, String str, boolean z, int i) {
        super(context, (InterfaceC2995n) null);
        this.f15657a = context;
        this.f15658b = str;
        this.f15659c = z;
        this.f15660d = false;
        this.f15661e = new HashMap();
        this.f15662f = new HashMap();
        this.f15663g = new ArrayList();
        this.f15664h = z ? R.string.moving : R.string.copying;
        this.f15665i = 0;
        this.f15666j = i;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: c */
    protected int mo17065c() {
        return this.f15664h;
    }

    /* renamed from: a */
    public void m17496a(int i) {
        this.f15665i = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x01b7 A[Catch: Error -> 0x0211, Exception -> 0x0222, TryCatch #2 {Error -> 0x0211, Exception -> 0x0222, blocks: (B:11:0x0026, B:13:0x0033, B:15:0x0039, B:17:0x004c, B:19:0x0052, B:21:0x0065, B:23:0x0071, B:24:0x0074, B:26:0x0086, B:28:0x008c, B:30:0x008f, B:32:0x00c0, B:34:0x00c4, B:37:0x00cc, B:39:0x00d0, B:41:0x00d8, B:43:0x00e7, B:44:0x00f8, B:45:0x010d, B:47:0x013e, B:49:0x0142, B:51:0x014a, B:53:0x014e, B:55:0x0152, B:57:0x0158, B:60:0x0168, B:61:0x017b, B:63:0x018d, B:65:0x019b, B:66:0x01b1, B:68:0x01b7, B:70:0x01bd, B:72:0x01cb, B:73:0x01dd, B:75:0x01e3, B:79:0x01fa, B:81:0x0200, B:83:0x0208, B:89:0x01e9), top: B:10:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01fa A[Catch: Error -> 0x0211, Exception -> 0x0222, TryCatch #2 {Error -> 0x0211, Exception -> 0x0222, blocks: (B:11:0x0026, B:13:0x0033, B:15:0x0039, B:17:0x004c, B:19:0x0052, B:21:0x0065, B:23:0x0071, B:24:0x0074, B:26:0x0086, B:28:0x008c, B:30:0x008f, B:32:0x00c0, B:34:0x00c4, B:37:0x00cc, B:39:0x00d0, B:41:0x00d8, B:43:0x00e7, B:44:0x00f8, B:45:0x010d, B:47:0x013e, B:49:0x0142, B:51:0x014a, B:53:0x014e, B:55:0x0152, B:57:0x0158, B:60:0x0168, B:61:0x017b, B:63:0x018d, B:65:0x019b, B:66:0x01b1, B:68:0x01b7, B:70:0x01bd, B:72:0x01cb, B:73:0x01dd, B:75:0x01e3, B:79:0x01fa, B:81:0x0200, B:83:0x0208, B:89:0x01e9), top: B:10:0x0026 }] */
    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean mo17058a(File file) {
        File file2;
        String str;
        File parentFile;
        int indexOf;
        File[] listFiles;
        if (mo3981a()) {
            return false;
        }
        if (!file.exists()) {
            mo3983c(R.string.file_not_found, file.getAbsolutePath());
            this.f15660d = true;
            return false;
        }
        try {
            file2 = new File(this.f15658b);
        } catch (Error e2) {
            mo3983c(R.string.errorf, e2.getMessage());
            this.f15660d = true;
        } catch (Exception e3) {
            mo3983c(R.string.errorf, e3.getMessage());
            this.f15660d = true;
        }
        if (!file2.exists() && !file2.mkdirs()) {
            mo3983c(R.string.output_directory_not_extsts, this.f15658b);
            this.f15660d = true;
            return false;
        }
        if (!file2.isDirectory()) {
            mo3983c(R.string.not_directory, this.f15658b);
            this.f15660d = true;
            return false;
        }
        if (this.f15658b.startsWith(file.getAbsolutePath())) {
            this.f15659c = false;
        }
        String substring = file.getAbsolutePath().substring(this.f15666j + 1);
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            if (new File(new StringBuffer().append(new StringBuffer().append(this.f15658b).append(File.separator).toString()).append(substring).toString()).exists() && this.f15665i == 3) {
                this.f15663g.add(file);
            }
            return true;
        }
        if (this.f15665i == 0 && (indexOf = substring.indexOf(File.separatorChar)) > 0) {
            String substring2 = substring.substring(0, indexOf);
            String str2 = this.f15661e.get(substring2);
            if (str2 == null) {
                str2 = C3262u.m19568a(this.f15657a, this.f15658b, substring2, "", 0, true);
                this.f15661e.put(substring2, str2);
            }
            substring = new StringBuffer().append(str2).append(substring.substring(indexOf)).toString();
        }
        if (new File(new StringBuffer().append(new StringBuffer().append(this.f15658b).append(File.separator).toString()).append(substring).toString()).exists()) {
            if (this.f15665i == 3) {
                this.f15663g.add(file);
                return true;
            }
            if (this.f15665i == 0 || (this.f15665i == 1 && !file.isDirectory())) {
                int lastIndexOf = substring.lastIndexOf(46);
                int lastIndexOf2 = substring.lastIndexOf(File.separatorChar);
                if (lastIndexOf >= 0 && lastIndexOf > lastIndexOf2) {
                    str = C3262u.m19568a(this.f15657a, this.f15658b, substring.substring(0, lastIndexOf), substring.substring(lastIndexOf), 0, true);
                } else {
                    str = C3262u.m19568a(this.f15657a, this.f15658b, substring, "", 0, true);
                }
                File file3 = new File(file2, str);
                parentFile = file3.getParentFile();
                parentFile.mkdirs();
                if (!parentFile.equals(file2) && this.f15662f.get(parentFile.getAbsolutePath()) == null) {
                    this.f15662f.put(parentFile.getAbsolutePath(), new Long(file.getParentFile().lastModified()));
                }
                if (!file.isDirectory()) {
                    if (!file3.isDirectory() && this.f15662f.get(file3.getAbsolutePath()) == null) {
                        this.f15662f.put(file3.getAbsolutePath(), new Long(file.lastModified()));
                    }
                    if (file3.isDirectory()) {
                        return true;
                    }
                    return file3.mkdirs();
                }
                if (file3.equals(file) || C3262u.m19613a(file, file3, this.f15659c) || C3262u.m19612a(file, file3)) {
                    return true;
                }
                return false;
            }
        }
        str = substring;
        File file32 = new File(file2, str);
        parentFile = file32.getParentFile();
        parentFile.mkdirs();
        if (!parentFile.equals(file2)) {
            this.f15662f.put(parentFile.getAbsolutePath(), new Long(file.getParentFile().lastModified()));
        }
        if (!file.isDirectory()) {
        }
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected Boolean mo17049a(File[] fileArr) {
        mo3984d(R.string.mplease_wait, new Object[0]);
        boolean booleanValue = super.mo17049a(fileArr).booleanValue();
        for (Map.Entry<String, Long> entry : this.f15662f.entrySet()) {
            C3262u.m19610a(new File(entry.getKey()), entry.getValue().longValue());
        }
        if (this.f15659c && fileArr != null && booleanValue) {
            for (File file : fileArr) {
                if (!m17497d(file)) {
                    if (file.isDirectory()) {
                        C0542g.m3987a(file);
                    } else {
                        file.delete();
                    }
                }
            }
        }
        return new Boolean(booleanValue);
    }

    /* renamed from: d */
    public boolean m17497d(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        if (this.f15663g == null || this.f15663g.isEmpty()) {
            return false;
        }
        return this.f15663g.contains(file);
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: e */
    protected boolean mo17071e() {
        return this.f15660d;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: b */
    protected void mo17061b(Boolean bool) {
        C2978b.f16135a.m17721k();
        super.mo17061b(bool);
    }
}
