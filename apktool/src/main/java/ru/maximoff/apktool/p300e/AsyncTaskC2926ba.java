package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.p217b.p218a.p219a.C1887e;
import p060c.p061a.p062a.C0546b;
import p060c.p061a.p062a.C0547c;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3067ab;
import ru.maximoff.apktool.util.C3078aj;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3099ba;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3254n;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p303a.C3061a;

/* compiled from: VectorConvert.java */
/* renamed from: ru.maximoff.apktool.e.ba */
/* loaded from: classes.dex */
public class AsyncTaskC2926ba extends AsyncTask<File, String, Boolean> {

    /* renamed from: a */
    private Context f15505a;

    /* renamed from: b */
    private InterfaceC2995n f15506b;

    /* renamed from: c */
    private DialogInterfaceC0070b f15507c;

    /* renamed from: d */
    private List<String> f15508d = new ArrayList();

    /* renamed from: e */
    private boolean f15509e = false;

    /* renamed from: f */
    private int f15510f = 1;

    /* renamed from: g */
    private int f15511g = 0;

    /* renamed from: h */
    private int f15512h = 0;

    /* renamed from: i */
    private int f15513i = 0;

    /* renamed from: j */
    private List<String> f15514j = new ArrayList();

    @Override // android.os.AsyncTask
    protected Boolean doInBackground(File[] fileArr) {
        return m17411a(fileArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m17413a(bool);
    }

    public AsyncTaskC2926ba(Context context, InterfaceC2995n interfaceC2995n) {
        this.f15505a = context;
        this.f15506b = interfaceC2995n;
    }

    /* renamed from: a */
    public void m17412a(int i) {
        this.f15510f = i;
    }

    /* renamed from: b */
    public void m17414b(int i) {
        this.f15511g = i;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f15505a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f15507c = new DialogInterfaceC0070b.a(this.f15505a).m435b(inflate).m429a(false).m438b();
        this.f15507c.show();
    }

    /* renamed from: a */
    protected Boolean m17411a(File[] fileArr) {
        int i;
        File file;
        Drawable drawable;
        C3099ba c3099ba;
        Drawable drawable2;
        File file2;
        int i2;
        int i3;
        Bitmap m18373a;
        int i4;
        int i5;
        this.f15512h = fileArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < fileArr.length) {
            File file3 = fileArr[i6];
            try {
                try {
                    file = (File) null;
                    drawable = (Drawable) null;
                    c3099ba = new C3099ba(this.f15505a, file3);
                } catch (Exception e2) {
                    e = e2;
                    this.f15508d.add(e.getMessage());
                    i = i7 + 1;
                    i6++;
                    i7 = i;
                }
            } catch (Error e3) {
                e = e3;
                this.f15508d.add(e.getMessage());
                i = i7 + 1;
                i6++;
                i7 = i;
            }
            if (c3099ba.m18881j()) {
                drawable2 = drawable;
                file2 = file;
            } else {
                Drawable m18380a = C3067ab.m18380a(this.f15505a, file3);
                if (m18380a != null) {
                    try {
                        file = File.createTempFile("APKTOOL_M", (String) null, C3102bd.m18908a());
                        C3061a.m18319b(file, m17409a(file3));
                        c3099ba = new C3099ba(this.f15505a, file);
                        drawable2 = m18380a;
                        file2 = file;
                    } catch (Exception e4) {
                        drawable2 = m18380a;
                        file2 = file;
                    }
                } else {
                    i = i7;
                    i6++;
                    i7 = i;
                }
            }
            if (c3099ba.m18881j() && this.f15506b != null && this.f15506b.mo17952g() != null && (c3099ba.m18879h() || c3099ba.m18880i())) {
                c3099ba.m18871a(this.f15506b.mo17952g());
            }
            File m17408a = m17408a(file3, C3262u.m19641b(file3.getName())[0]);
            StringBuilder sb = new StringBuilder();
            switch (this.f15510f) {
                case 1:
                    sb.append(new StringBuffer().append(new StringBuffer().append("<!-- ").append("Created by Apktool M – https://github.com/Maximoff/Apktool-M-updates").toString()).append(" -->\n").toString());
                    sb.append(c3099ba.m18882k());
                    C3061a.m18319b(m17408a, sb.toString());
                    break;
                case 2:
                    sb.append(c3099ba.m18883l());
                    C3061a.m18319b(m17408a, sb.toString());
                    break;
                case 3:
                    if (drawable2 == null) {
                        String m18882k = c3099ba.m18882k();
                        int m18875d = c3099ba.m18875d();
                        int m18876e = c3099ba.m18876e();
                        if (this.f15511g <= 0) {
                            i4 = m18876e;
                            i5 = m18875d;
                        } else if (m18875d > m18876e) {
                            i5 = this.f15511g;
                            i4 = (this.f15511g * m18876e) / m18875d;
                        } else {
                            i4 = this.f15511g;
                            i5 = (this.f15511g * m18875d) / m18876e;
                        }
                        m18373a = C3067ab.m18378a(m18882k, Math.max(1, i5), Math.max(1, i4));
                    } else {
                        int intrinsicWidth = drawable2.getIntrinsicWidth();
                        int intrinsicHeight = drawable2.getIntrinsicHeight();
                        if (this.f15511g <= 0) {
                            i2 = intrinsicHeight;
                            i3 = intrinsicWidth;
                        } else if (intrinsicWidth > intrinsicHeight) {
                            i3 = this.f15511g;
                            i2 = (this.f15511g * intrinsicHeight) / intrinsicWidth;
                        } else {
                            i2 = this.f15511g;
                            i3 = (this.f15511g * intrinsicWidth) / intrinsicHeight;
                        }
                        m18373a = C3067ab.m18373a(drawable2, Math.max(1, i3), Math.max(1, i2));
                    }
                    C3067ab.m18383a(m18373a, m17408a);
                    break;
            }
            this.f15514j.add(m17408a.getAbsolutePath());
            this.f15513i++;
            if (file2 != null) {
                file2.delete();
            }
            i = i7;
            i6++;
            i7 = i;
        }
        return new Boolean(i7 == 0);
    }

    /* renamed from: a */
    protected void m17413a(Boolean bool) {
        if (this.f15507c != null && this.f15507c.isShowing()) {
            try {
                this.f15507c.cancel();
            } catch (Exception e2) {
            }
        }
        if (this.f15506b != null) {
            this.f15506b.mo17929a();
            this.f15506b.mo17935a(this.f15514j);
        }
        C3112bn.m19023b(this.f15505a, this.f15505a.getString(R.string.success_of, new Integer(this.f15513i), new Integer(this.f15512h)));
        if (!this.f15508d.isEmpty()) {
            String m18538a = C3080al.m18538a(this.f15508d, "\n\n");
            new C3078aj(this.f15505a).m18494a(R.string.error).m18496a(this.f15505a.getString(R.string.errorf, m18538a)).m18495a(R.string.copy, new Runnable(this, m18538a) { // from class: ru.maximoff.apktool.e.ba.1

                /* renamed from: a */
                private final AsyncTaskC2926ba f15515a;

                /* renamed from: b */
                private final String f15516b;

                {
                    this.f15515a = this;
                    this.f15516b = m18538a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C3112bn.m19002a(this.f15515a.f15505a, this.f15516b);
                }
            }).m18508e(R.string.close_cur).m18507d();
        } else if (this.f15509e) {
            new C3078aj(this.f15505a).m18494a(R.string.complete).m18496a(this.f15505a.getString(R.string.complete_msg2, C3102bd.f18339v)).m18495a(R.string.go_to, new Runnable(this) { // from class: ru.maximoff.apktool.e.ba.2

                /* renamed from: a */
                private final AsyncTaskC2926ba f15517a;

                {
                    this.f15517a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.f15517a.f15506b == null) {
                        return;
                    }
                    this.f15517a.f15506b.mo17934a(new File(C3102bd.f18339v));
                }
            }).m18508e(R.string.close_cur).m18507d();
        }
    }

    /* renamed from: a */
    private File m17408a(File file, String str) {
        String str2;
        String parent = file.getParent();
        if ((!C3262u.m19664g(this.f15505a, file)) || C3102bd.m18925a(this.f15505a, "all_to_out_dir", false)) {
            parent = C3102bd.f18339v;
            if (parent == null) {
                this.f15508d.add(this.f15505a.getString(R.string.output_directory_not_set));
                return (File) null;
            }
            File file2 = new File(parent);
            if (!file2.exists() && !file2.mkdirs()) {
                this.f15508d.add(this.f15505a.getString(R.string.output_directory_not_extsts, parent));
                return (File) null;
            }
            if (!file2.isDirectory()) {
                this.f15508d.add(this.f15505a.getString(R.string.not_directory, parent));
                return (File) null;
            }
            this.f15509e = !parent.equals(file.getParent());
        }
        String str3 = parent;
        if (str == null) {
            str = file.getName();
        }
        switch (this.f15510f) {
            case 2:
                str2 = ".xml";
                break;
            case 3:
                str2 = ".png";
                break;
            default:
                str2 = ".svg";
                break;
        }
        return new File(str3, C3262u.m19566a(this.f15505a, str3, str, str2, 0));
    }

    /* renamed from: a */
    private String m17409a(File file) {
        C0546b c0546b = new C0546b(C1887e.m13984b(new FileInputStream(file)));
        StringBuilder sb = new StringBuilder();
        c0546b.m4018a(new C3254n(new C0547c(), this.f15505a.getResources(), 0, new HashMap(), new ArrayList(), sb, (String) null));
        return sb.toString();
    }
}
