package ru.maximoff.apktool.util;

import android.C0012R;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;

/* compiled from: MDialog.java */
/* renamed from: ru.maximoff.apktool.util.aj */
/* loaded from: classes.dex */
public class C3078aj {

    /* renamed from: a */
    private Context f17653a;

    /* renamed from: b */
    private DialogInterfaceC0070b.a f17654b;

    /* renamed from: c */
    private DialogInterfaceC0070b f17655c = (DialogInterfaceC0070b) null;

    /* renamed from: d */
    private boolean f17656d = true;

    /* renamed from: e */
    private boolean f17657e = false;

    /* renamed from: f */
    private boolean f17658f = false;

    public C3078aj(Context context) {
        this.f17653a = context;
        this.f17654b = new DialogInterfaceC0070b.a(context);
    }

    /* renamed from: a */
    public C3078aj m18497a(boolean z) {
        this.f17658f = z;
        return this;
    }

    /* renamed from: a */
    public C3078aj m18494a(int i) {
        this.f17654b.m418a(i);
        return this;
    }

    /* renamed from: a */
    public C3078aj m18496a(String str) {
        this.f17654b.m436b(str);
        return this;
    }

    /* renamed from: b */
    public C3078aj m18500b(int i) {
        this.f17654b.m433b(i);
        return this;
    }

    /* renamed from: b */
    public C3078aj m18502b(String str) {
        this.f17657e = true;
        this.f17654b.m436b(C3112bn.m19041p(str));
        return this;
    }

    /* renamed from: c */
    public C3078aj m18504c(int i) {
        return m18502b(this.f17653a.getText(i).toString());
    }

    /* renamed from: d */
    public C3078aj m18506d(int i) {
        return m18495a(i, (Runnable) null);
    }

    /* renamed from: a */
    public C3078aj m18495a(int i, Runnable runnable) {
        this.f17654b.m420a(i, m18492a(runnable));
        return this;
    }

    /* renamed from: e */
    public C3078aj m18508e(int i) {
        return m18501b(i, (Runnable) null);
    }

    /* renamed from: b */
    public C3078aj m18501b(int i, Runnable runnable) {
        this.f17654b.m434b(i, m18492a(runnable));
        return this;
    }

    /* renamed from: c */
    public C3078aj m18505c(int i, Runnable runnable) {
        this.f17654b.m440c(i, m18492a(runnable));
        return this;
    }

    /* renamed from: a */
    private DialogInterface.OnClickListener m18492a(Runnable runnable) {
        return runnable == null ? (DialogInterface.OnClickListener) null : new DialogInterface.OnClickListener(this, runnable) { // from class: ru.maximoff.apktool.util.aj.1

            /* renamed from: a */
            private final C3078aj f17659a;

            /* renamed from: b */
            private final Runnable f17660b;

            {
                this.f17659a = this;
                this.f17660b = runnable;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f17660b instanceof Runnable) {
                    this.f17660b.run();
                }
                dialogInterface.dismiss();
            }
        };
    }

    /* renamed from: a */
    public void m18498a() {
        if (this.f17655c != null) {
            this.f17655c.cancel();
        }
    }

    /* renamed from: b */
    public DialogInterfaceC0070b m18499b() {
        if (this.f17655c == null) {
            this.f17655c = this.f17654b.m438b();
        }
        this.f17655c.setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: ru.maximoff.apktool.util.aj.2

            /* renamed from: a */
            private final C3078aj f17661a;

            {
                this.f17661a = this;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!this.f17661a.f17656d || i != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                    return false;
                }
                dialogInterface.cancel();
                return true;
            }
        });
        return this.f17655c;
    }

    /* renamed from: c */
    public Button m18503c() {
        if (this.f17655c == null) {
            this.f17655c = m18499b();
        }
        return this.f17655c.m414a(-1);
    }

    /* renamed from: d */
    public void m18507d() {
        if (this.f17655c == null) {
            this.f17655c = m18499b();
        }
        this.f17655c.show();
        TextView textView = (TextView) this.f17655c.findViewById(C0012R.id.message);
        if (this.f17658f) {
            textView.setTextIsSelectable(true);
        }
        if (this.f17657e) {
            textView.setMovementMethod(new C3251k());
        }
    }
}
