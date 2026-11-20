package ru.maximoff.apktool.p300e;

import android.content.Context;
import com.srizwan.apktool.R;
import java.p209io.File;
import org.p226d.p233b.C2359g;
import org.p226d.p233b.p264i.p265a.C2398d;
import org.p226d.p233b.p264i.p266b.C2409i;
import p046b.p047a.C0455a;
import p046b.p047a.C0461b;
import p046b.p047a.C0518d;
import p046b.p059d.C0542g;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.p295a.C2608a;

/* compiled from: DexBuilder.java */
/* renamed from: ru.maximoff.apktool.e.n */
/* loaded from: classes.dex */
public class AsyncTaskC2943n extends AbstractAsyncTaskC2898a {

    /* renamed from: a */
    private Context f15687a;

    /* renamed from: b */
    private InterfaceC2995n f15688b;

    /* renamed from: c */
    private int f15689c;

    /* renamed from: d */
    private boolean f15690d;

    /* renamed from: e */
    private boolean f15691e;

    public AsyncTaskC2943n(Context context, int i, InterfaceC2995n interfaceC2995n) {
        super(context, interfaceC2995n);
        this.f15690d = false;
        this.f15691e = false;
        this.f15687a = context;
        this.f15689c = i;
        this.f15688b = interfaceC2995n;
    }

    /* renamed from: g */
    public void m17517g(boolean z) {
        this.f15690d = z;
    }

    /* renamed from: h */
    public void m17518h(boolean z) {
        this.f15691e = z;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a, android.p008os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        if (C3102bd.m18925a(this.f15687a, "ongoing_notification", true)) {
            m17054a(this.f15687a.getString(mo17065c()), "decompile_task");
        }
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: c */
    protected int mo17065c() {
        return R.string.mplease_wait;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected Boolean mo17049a(File[] fileArr) {
        if (this.f15690d) {
            try {
                int i = this.f15689c < 0 ? C3080al.f17665b[0] : this.f15689c;
                File m17515a = m17515a(fileArr[0], "classes", ".dex", this);
                mo3984d(R.string.text, new StringBuffer().append(new StringBuffer().append("Smaling smali files into ").append(m17515a.getAbsolutePath()).toString()).append("...").toString());
                C2359g m15023a = C2359g.m15023a(i);
                C2409i c2409i = new C2409i(m15023a);
                for (File file : fileArr) {
                    if (file.isFile()) {
                        c2409i.m15249a(C2608a.m16251a(file, m15023a));
                        if (c2409i.m15408b()) {
                            throw new Exception(this.f15687a.getString(R.string.merge_dex_error));
                        }
                    }
                }
                c2409i.m15405a(new C2398d(m17515a));
                m17060b(m17515a.getParentFile());
                if (this.f15691e) {
                    for (File file2 : fileArr) {
                        if (file2.isFile()) {
                            file2.delete();
                        }
                    }
                }
                return new Boolean(true);
            } catch (Error e2) {
                mo3979a(R.string.errorf, e2.toString());
                return new Boolean(false);
            } catch (Exception e3) {
                mo3979a(R.string.errorf, e3.toString());
                return new Boolean(false);
            }
        }
        return super.mo17049a(fileArr);
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected boolean mo17058a(File file) {
        int i;
        String stringBuffer;
        try {
            try {
                C0455a c0455a = new C0455a(C0518d.f3579w, this);
                if (file.isDirectory()) {
                    int i2 = this.f15689c < 0 ? C3080al.f17665b[C3262u.m19563a(file)] : this.f15689c;
                    int indexOf = file.getName().indexOf("_");
                    String str = "classes";
                    if (indexOf >= 0) {
                        str = file.getName().substring(indexOf + 1);
                        if (str.equals("")) {
                            str = "classes";
                        }
                    }
                    File m17515a = m17515a(file, str, ".dex", this);
                    m17060b(m17515a.getParentFile());
                    boolean m3501a = c0455a.m3501a(file.getParentFile(), file.getName(), m17515a, i2);
                    if (m3501a && this.f15691e) {
                        C0542g.m3987a(file);
                        return m3501a;
                    }
                    return m3501a;
                }
                if (file.isFile()) {
                    if (this.f15689c < 0) {
                        int m19672k = C3262u.m19672k(file);
                        if (m19672k < 0) {
                            m19672k = 0;
                        }
                        i = C3080al.f17665b[m19672k];
                    } else {
                        i = this.f15689c;
                    }
                    if (file.getName().equals("classes.dex")) {
                        stringBuffer = "smali";
                    } else {
                        stringBuffer = new StringBuffer().append("smali_").append(file.getName().substring(0, file.getName().lastIndexOf("."))).toString();
                    }
                    File m17515a2 = m17515a(file, stringBuffer, "", this);
                    m17060b(m17515a2);
                    c0455a.m3495a(file, m17515a2, C3102bd.m18925a(this.f15687a, "mBakdeb", true), i);
                    if (i > 14) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= C3080al.f17665b.length) {
                                break;
                            }
                            if (C3080al.f17665b[i3] != i) {
                                i3++;
                            } else {
                                try {
                                    new File(m17515a2, new StringBuffer().append(".").append(C3080al.f17664a[i3].replaceAll("\\s", "")).toString()).createNewFile();
                                    break;
                                } catch (Exception e2) {
                                }
                            }
                        }
                    }
                    if (this.f15691e) {
                        file.delete();
                    }
                    return true;
                }
                mo3979a(R.string.errorf, new StringBuffer().append(file.getAbsolutePath()).append(" is bad file").toString());
                return false;
            } catch (Exception e3) {
                mo3979a(R.string.errorf, e3.toString());
                return false;
            }
        } catch (C0461b e4) {
            mo3979a(R.string.errorf, e4.toString());
            return false;
        } catch (Error e5) {
            mo3979a(R.string.errorf, e5.toString());
            return false;
        }
    }

    /* renamed from: a */
    private File m17515a(File file, String str, String str2, AbstractAsyncTaskC2898a abstractAsyncTaskC2898a) {
        String parent = file.getParent();
        if (str == null) {
            str = file.getName();
        }
        boolean m17516a = m17516a(parent);
        boolean m18925a = C3102bd.m18925a(this.f15687a, "all_to_out_dir", false);
        boolean z = !C3262u.m19664g(this.f15687a, file);
        if ((m18925a && !m17516a) || z) {
            parent = C3102bd.f18339v;
            if (parent == null) {
                abstractAsyncTaskC2898a.mo3983c(R.string.output_directory_not_set, new Object[0]);
                return (File) null;
            }
            File file2 = new File(parent);
            if (!file2.exists() && !file2.mkdirs()) {
                abstractAsyncTaskC2898a.mo3983c(R.string.output_directory_not_extsts, parent);
                return (File) null;
            }
            if (!file2.isDirectory()) {
                abstractAsyncTaskC2898a.mo3983c(R.string.not_directory, parent);
                return (File) null;
            }
        }
        String str3 = parent;
        return new File(str3, C3262u.m19566a(this.f15687a, str3, str, str2, 0));
    }

    /* renamed from: a */
    private boolean m17516a(String str) {
        return new File(new StringBuffer().append(str).append("/apktool.json").toString()).isFile() || new File(new StringBuffer().append(str).append("/apktool.yml").toString()).isFile();
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: b */
    protected void mo17061b(Boolean bool) {
        super.mo17061b(bool);
        if (C3102bd.m18925a(this.f15687a, "build_notification", true)) {
            m17072f(bool.booleanValue());
        }
    }
}
