package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.security.keystore.KeyProperties;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.io.File;
import java.util.HashSet;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3105bg;
import ru.maximoff.apktool.util.C3246h;
import ru.maximoff.apktool.util.C3262u;

/* compiled from: CompareSign.java */
/* renamed from: ru.maximoff.apktool.e.h */
/* loaded from: classes.dex */
public class AsyncTaskC2937h extends AsyncTask<File, String, Boolean> {

    /* renamed from: a */
    private Context f15647a;

    /* renamed from: b */
    private InterfaceC2995n f15648b;

    /* renamed from: c */
    private DialogInterfaceC0070b f15649c;

    /* renamed from: d */
    private String f15650d = "";

    /* renamed from: e */
    private boolean f15651e = false;

    @Override // android.os.AsyncTask
    protected Boolean doInBackground(File[] fileArr) {
        return m17490a(fileArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m17491a(bool);
    }

    public AsyncTaskC2937h(Context context, InterfaceC2995n interfaceC2995n) {
        this.f15647a = context;
        this.f15648b = interfaceC2995n;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f15647a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f15649c = new DialogInterfaceC0070b.a(this.f15647a).m435b(inflate).m429a(false).m438b();
        this.f15649c.show();
    }

    /* renamed from: a */
    protected Boolean m17490a(File[] fileArr) {
        try {
            HashSet<Long> m18965a = C3105bg.m18965a(this.f15647a, fileArr[0]);
            HashSet<Long> m18965a2 = C3105bg.m18965a(this.f15647a, fileArr[1]);
            boolean z = m18965a.size() == m18965a2.size();
            this.f15650d = new StringBuffer().append(this.f15650d).append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("1) ").append(fileArr[0].getAbsolutePath()).toString()).append(z ? "" : new StringBuffer().append(new StringBuffer().append(" (").append(m18965a.size()).toString()).append(" cert.)").toString()).toString()).append("\n").toString()).toString();
            this.f15650d = new StringBuffer().append(this.f15650d).append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("2) ").append(fileArr[1].getAbsolutePath()).toString()).append(z ? "" : new StringBuffer().append(new StringBuffer().append(" (").append(m18965a2.size()).toString()).append(" cert.)").toString()).toString()).append("\n\n").toString()).toString();
            String m19572a = C3262u.m19572a(fileArr[0].getAbsolutePath(), KeyProperties.DIGEST_MD5);
            String m19572a2 = C3262u.m19572a(fileArr[1].getAbsolutePath(), KeyProperties.DIGEST_MD5);
            if (m19572a == null || m19572a2 == null) {
                this.f15651e = false;
            } else {
                this.f15651e = m19572a.equals(m19572a2);
            }
            return new Boolean((m18965a.isEmpty() || m18965a2.isEmpty() || !C3105bg.m18968a(m18965a, m18965a2)) ? false : true);
        } catch (Error | Exception e2) {
            return new Boolean(false);
        }
    }

    /* renamed from: a */
    protected void m17491a(Boolean bool) {
        int m19470a;
        int i;
        if (this.f15649c != null && this.f15649c.isShowing()) {
            try {
                this.f15649c.cancel();
            } catch (Exception e2) {
            }
        }
        if (bool.booleanValue()) {
            m19470a = C3246h.m19470a(this.f15647a, R.color.dark_green);
            i = R.string.matches;
        } else {
            m19470a = C3246h.m19470a(this.f15647a, R.color.dark_red);
            i = R.string.not_match;
        }
        this.f15650d = new StringBuffer().append(this.f15650d).append(new StringBuffer().append(new StringBuffer().append(this.f15647a.getString(R.string.sign_match)).append(": ").toString()).append(this.f15647a.getString(i)).toString()).toString();
        if (this.f15651e) {
            this.f15650d = new StringBuffer().append(this.f15650d).append(new StringBuffer().append("\n\n").append(this.f15647a.getString(R.string.files_identical)).toString()).toString();
        }
        SpannableString spannableString = new SpannableString(this.f15650d);
        spannableString.setSpan(new ForegroundColorSpan(m19470a), this.f15650d.lastIndexOf(58) + 2, this.f15650d.length(), 33);
        new DialogInterfaceC0070b.a(this.f15647a).m436b(spannableString).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m438b().show();
    }
}
