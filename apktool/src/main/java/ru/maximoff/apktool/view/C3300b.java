package ru.maximoff.apktool.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.p126e.p127a.p128a.C1103k;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: CustomImageView.java */
/* renamed from: ru.maximoff.apktool.view.b */
/* loaded from: classes.dex */
public class C3300b extends C1103k {

    /* renamed from: a */
    private Context f20934a;

    /* renamed from: b */
    private boolean f20935b;

    /* renamed from: c */
    private C3304f f20936c;

    /* renamed from: d */
    private Bitmap f20937d;

    /* renamed from: e */
    private ProgressBar f20938e;

    /* renamed from: f */
    private float f20939f;

    /* renamed from: g */
    private final Handler f20940g;

    /* renamed from: h */
    private final Runnable f20941h;

    public C3300b(Context context) {
        this(context, (AttributeSet) null, 0);
        this.f20934a = context;
        this.f20935b = false;
    }

    public C3300b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20939f = 1.0f;
        this.f20940g = new Handler(Looper.getMainLooper());
        this.f20941h = new Runnable(this) { // from class: ru.maximoff.apktool.view.b.1

            /* renamed from: a */
            private final C3300b f20942a;

            {
                this.f20942a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f20942a.f20938e.getVisibility() == 0) {
                    this.f20942a.f20938e.setVisibility(8);
                }
                if (this.f20942a.f20937d == null || this.f20942a.f20937d.isRecycled()) {
                    return;
                }
                this.f20942a.setImageBitmap(this.f20942a.f20937d);
                this.f20942a.setScale(this.f20942a.f20939f);
            }
        };
        this.f20934a = context;
        this.f20935b = false;
    }

    /* renamed from: a */
    public boolean m19831a() {
        return this.f20935b;
    }

    /* renamed from: a */
    public void m19830a(File file, ProgressBar progressBar) {
        this.f20938e = progressBar;
        this.f20935b = true;
        try {
            new a(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, file);
        } catch (Exception e2) {
        }
    }

    /* compiled from: CustomImageView.java */
    /* renamed from: ru.maximoff.apktool.view.b$a */
    public class a extends AsyncTask<File, Void, Void> {

        /* renamed from: a */
        private final C3300b f20943a;

        @Override // android.os.AsyncTask
        protected Void doInBackground(File[] fileArr) {
            return m19832a(fileArr);
        }

        @Override // android.os.AsyncTask
        protected void onProgressUpdate(Void[] voidArr) {
            m19833a(voidArr);
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected Void m19832a(File... fileArr) {
            InputStream inputStream;
            if (!this.f20943a.f20935b) {
                return (Void) null;
            }
            InputStream inputStream2 = (InputStream) null;
            try {
                try {
                    inputStream = new BufferedInputStream(new FileInputStream(fileArr[0]));
                    try {
                        this.f20943a.f20936c = new C3304f();
                    } catch (Error e2) {
                        publishProgress((Void) null);
                        this.f20943a.f20935b = false;
                        if (inputStream != null) {
                        }
                        return (Void) null;
                    } catch (Exception e3) {
                        publishProgress((Void) null);
                        this.f20943a.f20935b = false;
                        if (inputStream != null) {
                        }
                        return (Void) null;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Error e5) {
                inputStream = inputStream2;
            } catch (Exception e6) {
                inputStream = inputStream2;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream2 != null) {
                }
                throw th;
            }
            if (this.f20943a.f20936c.m19866a(inputStream) != 0) {
                throw new Exception("Bad gif, break task...");
            }
            int m19864a = this.f20943a.f20936c.m19864a();
            int m19867b = this.f20943a.f20936c.m19867b();
            int i = 0;
            while (this.f20943a.f20935b && i <= m19867b) {
                for (int i2 = 0; i2 < m19864a; i2++) {
                    this.f20943a.f20939f = Math.max(1.0f, Math.min(this.f20943a.getScale(), 10.0f));
                    this.f20943a.f20937d = this.f20943a.f20936c.m19868b(i2);
                    int m19865a = this.f20943a.f20936c.m19865a(i2);
                    int i3 = m19865a <= 0 ? 100 : m19865a;
                    publishProgress((Void) null);
                    Thread.sleep(i3);
                }
                if (m19867b != 0) {
                    i++;
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e7) {
                }
            }
            return (Void) null;
        }

        /* renamed from: a */
        protected void m19833a(Void[] voidArr) {
            this.f20943a.f20940g.post(this.f20943a.f20941h);
        }

        public a(C3300b c3300b) {
            this.f20943a = c3300b;
        }
    }
}
