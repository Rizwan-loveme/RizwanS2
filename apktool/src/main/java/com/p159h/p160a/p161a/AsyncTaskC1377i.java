package com.p159h.p160a.p161a;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.p159h.p160a.p162b.C1386h;
import com.srizwan.apktool.R;
import p174e.p175a.C1527a;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;

/* compiled from: XmlFormat.java */
/* renamed from: com.h.a.a.i */
/* loaded from: classes.dex */
public class AsyncTaskC1377i extends AsyncTask<String, String, Boolean> {

    /* renamed from: a */
    private C1371c f8970a;

    /* renamed from: b */
    private DialogInterfaceC0070b f8971b;

    /* renamed from: c */
    private Context f8972c;

    /* renamed from: d */
    private C1386h f8973d;

    /* renamed from: e */
    private int f8974e;

    @Override // android.os.AsyncTask
    protected Boolean doInBackground(String[] strArr) {
        return m10987a(strArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m10988a(bool);
    }

    public AsyncTaskC1377i(C1371c c1371c) {
        this.f8970a = c1371c;
        this.f8972c = c1371c.getContext();
        this.f8973d = c1371c.getDocumentProvider();
        try {
            this.f8974e = Integer.parseInt(C3102bd.m18910a(this.f8972c, "xml_format_type", "0"));
        } catch (Exception e2) {
            this.f8974e = 0;
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f8972c).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f8971b = new DialogInterfaceC0070b.a(this.f8972c).m435b(inflate).m429a(false).m438b();
        this.f8971b.show();
    }

    /* renamed from: a */
    protected Boolean m10987a(String[] strArr) {
        try {
            int caretPosition = this.f8970a.getCaretPosition();
            C1527a c1527a = new C1527a();
            c1527a.m11709a(this.f8974e);
            c1527a.m11710b(this.f8970a.getAutoIndentWidth());
            String m11708a = c1527a.m11708a(this.f8973d.toString().toString());
            if (m11708a != null) {
                this.f8973d.m11048d();
                this.f8973d.m11035a(0, this.f8973d.m11055h() - 1, System.nanoTime());
                this.f8973d.m11041a(m11708a.toCharArray(), 0, System.nanoTime());
                this.f8973d.m11050e();
                this.f8970a.setCaretPosition(Math.min(caretPosition, m11708a.length()));
                return new Boolean(true);
            }
        } catch (Error e2) {
        } catch (Exception e3) {
        }
        return new Boolean(false);
    }

    /* renamed from: a */
    protected void m10988a(Boolean bool) {
        if (this.f8971b != null && this.f8971b.isShowing()) {
            try {
                this.f8971b.cancel();
            } catch (Exception e2) {
            }
        }
        if (!bool.booleanValue()) {
            C3112bn.m18999a(this.f8972c, R.string.error);
        } else {
            this.f8970a.setEdited(true);
        }
        this.f8970a.m10860G();
        this.f8970a.m10897g();
        this.f8970a.m10907l();
    }
}
