package ru.maximoff.apktool.fragment.p301a;

import android.content.ContentResolver;
import android.net.Uri;
import android.p008os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.p209io.FileFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.fragment.C2981b;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.p306d.C3215e;
import ru.maximoff.apktool.view.EditorPager;

/* compiled from: EditorGoToSmali.java */
/* renamed from: ru.maximoff.apktool.fragment.a.a */
/* loaded from: classes.dex */
public class AsyncTaskC2977a extends AsyncTask<CharSequence, Void, File> {

    /* renamed from: a */
    private MainActivity f16117a;

    /* renamed from: b */
    private DialogInterfaceC0070b f16118b;

    /* renamed from: c */
    private EditorPager f16119c;

    /* renamed from: d */
    private C2981b f16120d;

    /* renamed from: h */
    private boolean f16124h;

    /* renamed from: e */
    private int f16121e = 0;

    /* renamed from: f */
    private int f16122f = 0;

    /* renamed from: g */
    private int f16123g = 0;

    /* renamed from: i */
    private String f16125i = (String) null;

    @Override // android.p008os.AsyncTask
    protected File doInBackground(CharSequence[] charSequenceArr) {
        return m17671a(charSequenceArr);
    }

    @Override // android.p008os.AsyncTask
    protected void onPostExecute(File file) {
        m17672a(file);
    }

    public AsyncTaskC2977a(MainActivity mainActivity, EditorPager editorPager, boolean z) {
        this.f16124h = false;
        this.f16117a = mainActivity;
        this.f16119c = editorPager;
        this.f16120d = mainActivity.m16616A();
        this.f16124h = z;
    }

    @Override // android.p008os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f16117a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f16118b = new DialogInterfaceC0070b.a(this.f16117a).m435b(inflate).m429a(false).m438b();
        this.f16118b.show();
    }

    /* renamed from: a */
    protected File m17671a(CharSequence[] charSequenceArr) {
        String m16618C;
        boolean z;
        String stringBuffer;
        Uri m17731q = C2978b.f16135a.m17731q(this.f16119c.getCurrentItem());
        if (m17731q == null) {
            m16618C = this.f16117a.m16618C();
        } else if (m17731q.getScheme().equals(ContentResolver.SCHEME_FILE)) {
            m16618C = this.f16117a.m16620a(new File(m17731q.getPath()).getParent());
        } else {
            m16618C = this.f16117a.m16618C();
        }
        if (this.f16120d == null || m16618C == null) {
            this.f16121e = R.string.error;
            return (File) null;
        }
        String str = (String) null;
        Matcher matcher = Pattern.compile("L([^;\\s]+);", 8).matcher(charSequenceArr[0]);
        String group = matcher.find() ? matcher.group(1) : str;
        if (group == null) {
            if (!this.f16124h) {
                this.f16125i = C2978b.f16135a.m17727n(this.f16119c.getCurrentItem()).getLineText();
            } else {
                this.f16121e = R.string.error;
            }
            return (File) null;
        }
        File[] listFiles = new File(m16618C).listFiles(new FileFilter(this) { // from class: ru.maximoff.apktool.fragment.a.a.1

            /* renamed from: a */
            private final AsyncTaskC2977a f16134a;

            {
                this.f16134a = this;
            }

            @Override // java.p209io.FileFilter
            public boolean accept(File file) {
                return file.isDirectory() && file.getName().startsWith("smali");
            }
        });
        if (listFiles == null || listFiles.length == 0) {
            this.f16121e = R.string.not_found;
            return (File) null;
        }
        File file = (File) null;
        int i = 0;
        while (true) {
            if (i >= listFiles.length) {
                break;
            }
            File m19251a = C3215e.m19251a(listFiles[i], group, group);
            if (m19251a != null && m19251a.isFile()) {
                file = m19251a;
                break;
            }
            i++;
        }
        if (file == null) {
            this.f16121e = R.string.not_found;
            return (File) null;
        }
        String str2 = (String) null;
        Matcher matcher2 = Pattern.compile(new StringBuffer().append(new StringBuffer().append("L").append(C3112bn.m19024c((CharSequence) group)).toString()).append(";->([^\\:\\(]+\\([^\\)]*\\)[^\\n]+)").toString(), 8).matcher(charSequenceArr[0]);
        if (matcher2.find()) {
            str2 = matcher2.group(1);
            z = false;
        } else {
            Matcher matcher3 = Pattern.compile(new StringBuffer().append(new StringBuffer().append("L").append(C3112bn.m19024c((CharSequence) group)).toString()).append(";->([^\\:\\(]+\\:[^\\n]+)").toString(), 8).matcher(charSequenceArr[0]);
            if (matcher3.find()) {
                str2 = matcher3.group(1);
                z = true;
            } else {
                z = false;
            }
        }
        if (str2 != null) {
            if (z) {
                stringBuffer = new StringBuffer().append("\\.field([^\\n]+?)").append(C3112bn.m19024c((CharSequence) str2)).toString();
            } else {
                stringBuffer = new StringBuffer().append("\\.method([^\\n]+?)").append(C3112bn.m19024c((CharSequence) str2)).toString();
            }
            C3215e.a m19254a = C3215e.m19254a(file, stringBuffer, false, "UTF-8", 0);
            if (m19254a.f19216a > 0) {
                this.f16122f = m19254a.f19216a;
                this.f16123g = m19254a.f19217b - 1;
            }
        }
        return file;
    }

    /* renamed from: a */
    protected void m17672a(File file) {
        if (this.f16118b != null && this.f16118b.isShowing()) {
            try {
                this.f16118b.cancel();
            } catch (Exception e2) {
            }
        }
        if (this.f16125i != null) {
            new AsyncTaskC2977a(this.f16117a, this.f16119c, true).execute(this.f16125i);
            return;
        }
        if (file != null) {
            if (this.f16122f > 0) {
                this.f16120d.m17822a(file, this.f16122f, this.f16123g);
                return;
            } else {
                this.f16120d.m17821a(file);
                return;
            }
        }
        if (this.f16121e == 0) {
            C3112bn.m18999a(this.f16117a, R.string.error);
        } else {
            C3112bn.m18999a(this.f16117a, this.f16121e);
        }
    }
}
