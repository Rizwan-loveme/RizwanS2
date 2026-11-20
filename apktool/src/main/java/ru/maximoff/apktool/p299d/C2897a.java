package ru.maximoff.apktool.p299d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaCodec;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.widget.C0173ao;
import com.srizwan.apktool.R;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3261t;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p303a.C3061a;
import ru.maximoff.apktool.view.C3306h;
import ru.p294a.C2604w;

/* compiled from: Patcher.java */
/* renamed from: ru.maximoff.apktool.d.a */
/* loaded from: classes.dex */
public class C2897a {

    /* renamed from: a */
    private Context f14914a;

    /* renamed from: b */
    private String f14915b;

    /* renamed from: c */
    private String f14916c;

    /* renamed from: d */
    private String f14917d;

    /* renamed from: e */
    private long f14918e = 0;

    public C2897a(Context context, String str, String str2) {
        this.f14914a = context;
        this.f14915b = str;
        this.f14917d = str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0029 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0047 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m17015a() {
        InputStream inputStream;
        List<String> list;
        File file = new File(this.f14916c);
        InputStream inputStream2 = (InputStream) null;
        try {
            try {
                C2604w c2604w = new C2604w(this.f14916c);
                inputStream = new BufferedInputStream(c2604w.m16160a(c2604w.m16162a("patch.txt")));
                try {
                    list = C3061a.m18305a(inputStream);
                } catch (Exception e2) {
                    list = (List) null;
                    if (inputStream != null) {
                    }
                    if (list != null) {
                    }
                    C3112bn.m18999a(this.f14914a, R.string.patcher_select_error);
                    return;
                }
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            inputStream = inputStream2;
        } catch (Throwable th2) {
            th = th2;
            inputStream = inputStream2;
            if (inputStream != null) {
            }
            throw th;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e5) {
            }
        }
        if (list != null || list.isEmpty()) {
            C3112bn.m18999a(this.f14914a, R.string.patcher_select_error);
            return;
        }
        C3306h c3306h = new C3306h(this.f14914a);
        c3306h.m19905c(true);
        c3306h.m19901a((CharSequence) this.f14914a.getString(R.string.patcher_project, this.f14915b));
        c3306h.m19901a((CharSequence) this.f14914a.getString(R.string.patcher_patchf, this.f14916c));
        if (this.f14917d != null) {
            c3306h.m19901a((CharSequence) this.f14914a.getString(R.string.patcher_apk, this.f14917d));
        }
        c3306h.m19901a((CharSequence) "");
        c3306h.m19902a(list);
        c3306h.m19904b(false);
        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(this.f14914a);
        aVar.m435b(c3306h).m427a(file.getName()).m420a(R.string.patcher_patch, (DialogInterface.OnClickListener) null).m429a(false).m440c(R.string.mselect, (DialogInterface.OnClickListener) null).m434b(R.string.cancel, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.d.a.1

            /* renamed from: a */
            private final C2897a f14919a;

            {
                this.f14919a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        DialogInterfaceC0070b m438b = aVar.m438b();
        c3306h.setDialog(m438b);
        m438b.setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: ru.maximoff.apktool.d.a.2

            /* renamed from: a */
            private final C2897a f14920a;

            {
                this.f14920a = this;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                    return false;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f14920a.f14918e > 2000) {
                    C3112bn.m18999a(this.f14920a.f14914a, R.string.click_once_more2);
                    this.f14920a.f14918e = currentTimeMillis;
                    return false;
                }
                dialogInterface.cancel();
                return true;
            }
        });
        m438b.setOnShowListener(new AnonymousClass3(this, m438b));
        m438b.show();
    }

    /* compiled from: Patcher.java */
    /* renamed from: ru.maximoff.apktool.d.a$3, reason: invalid class name */
    class AnonymousClass3 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final C2897a f14921a;

        /* renamed from: b */
        private final DialogInterfaceC0070b f14922b;

        AnonymousClass3(C2897a c2897a, DialogInterfaceC0070b dialogInterfaceC0070b) {
            this.f14921a = c2897a;
            this.f14922b = dialogInterfaceC0070b;
        }

        /* renamed from: a */
        static C2897a m17017a(AnonymousClass3 anonymousClass3) {
            return anonymousClass3.f14921a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            this.f14922b.m414a(-3).setOnClickListener(new View.OnClickListener(this, this.f14922b) { // from class: ru.maximoff.apktool.d.a.3.1

                /* renamed from: a */
                private final AnonymousClass3 f14923a;

                /* renamed from: b */
                private final DialogInterfaceC0070b f14924b;

                {
                    this.f14923a = this;
                    this.f14924b = r2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f14924b.cancel();
                    AnonymousClass3.m17017a(this.f14923a).m17016b();
                }
            });
            this.f14922b.m414a(-1).setOnClickListener(new View.OnClickListener(this, this.f14922b) { // from class: ru.maximoff.apktool.d.a.3.2

                /* renamed from: a */
                private final AnonymousClass3 f14925a;

                /* renamed from: b */
                private final DialogInterfaceC0070b f14926b;

                {
                    this.f14925a = this;
                    this.f14926b = r2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f14926b.cancel();
                    AnonymousClass3.m17017a(this.f14925a).m17013c();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m17013c() {
        try {
            Uri m19657e = C3262u.m19657e(this.f14914a, new File(this.f14915b));
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            intent.setPackage("ru.maximoff.aepatcher");
            intent.setDataAndType(m19657e, "application/ru.maximoff.aepatcher-patch");
            intent.putExtra("appTheme", C3102bd.f18319b);
            intent.putExtra("appLanguage", C3102bd.f18267C);
            intent.putExtra("keepScreenOn", C3102bd.f18275K);
            intent.putExtra("projectPath", this.f14915b);
            intent.putExtra("patchPath", this.f14916c);
            if (this.f14917d != null) {
                intent.putExtra("apkPath", this.f14917d);
            }
            intent.addFlags(268435459);
            this.f14914a.startActivity(intent);
        } catch (Exception e2) {
            C3112bn.m18999a(this.f14914a, R.string.error);
        }
    }

    /* renamed from: b */
    public void m17016b() {
        C3261t c3261t = new C3261t(this.f14914a);
        Runnable runnable = new Runnable(this, c3261t) { // from class: ru.maximoff.apktool.d.a.4

            /* renamed from: a */
            private final C2897a f14927a;

            /* renamed from: b */
            private final C3261t f14928b;

            {
                this.f14927a = this;
                this.f14928b = c3261t;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f14927a.f14916c = this.f14928b.getPath();
                this.f14927a.m17015a();
            }
        };
        c3261t.m19545a("_patcher");
        c3261t.setCallback(runnable);
        c3261t.setFilter(new String[]{"zip"});
        c3261t.m19550e();
        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(this.f14914a);
        aVar.m427a(c3261t.m19548c());
        aVar.m435b(c3261t);
        aVar.m420a(R.string.cancel, (DialogInterface.OnClickListener) null);
        aVar.m437b("/...", (DialogInterface.OnClickListener) null);
        aVar.m429a(false);
        aVar.m422a(new DialogInterface.OnKeyListener(this, c3261t) { // from class: ru.maximoff.apktool.d.a.5

            /* renamed from: a */
            private final C2897a f14929a;

            /* renamed from: b */
            private final C3261t f14930b;

            {
                this.f14929a = this;
                this.f14930b = c3261t;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                    return false;
                }
                boolean m19551f = this.f14930b.m19551f();
                if (!m19551f) {
                    dialogInterface.dismiss();
                    return m19551f;
                }
                return m19551f;
            }
        });
        DialogInterfaceC0070b m438b = aVar.m438b();
        m438b.setOnShowListener(new AnonymousClass6(this, m438b, c3261t));
        c3261t.setDialog(m438b);
        m438b.show();
    }

    /* compiled from: Patcher.java */
    /* renamed from: ru.maximoff.apktool.d.a$6, reason: invalid class name */
    class AnonymousClass6 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final C2897a f14931a;

        /* renamed from: b */
        private final DialogInterfaceC0070b f14932b;

        /* renamed from: c */
        private final C3261t f14933c;

        AnonymousClass6(C2897a c2897a, DialogInterfaceC0070b dialogInterfaceC0070b, C3261t c3261t) {
            this.f14931a = c2897a;
            this.f14932b = dialogInterfaceC0070b;
            this.f14933c = c3261t;
        }

        /* renamed from: a */
        static C2897a m17018a(AnonymousClass6 anonymousClass6) {
            return anonymousClass6.f14931a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            Button m414a = this.f14932b.m414a(-3);
            m414a.setOnClickListener(new View.OnClickListener(this, this.f14933c) { // from class: ru.maximoff.apktool.d.a.6.1

                /* renamed from: a */
                private final AnonymousClass6 f14934a;

                /* renamed from: b */
                private final C3261t f14935b;

                {
                    this.f14934a = this;
                    this.f14935b = r2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String[] m19640b = C3262u.m19640b(AnonymousClass6.m17018a(this.f14934a).f14914a);
                    if (m19640b != null) {
                        C0173ao c0173ao = new C0173ao(AnonymousClass6.m17018a(this.f14934a).f14914a, view);
                        for (int i = 0; i < m19640b.length; i++) {
                            c0173ao.m1339a().add(0, i + MediaCodec.CodecException.ERROR_INSUFFICIENT_RESOURCE, 0, m19640b[i]).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f14935b) { // from class: ru.maximoff.apktool.d.a.6.1.1

                                /* renamed from: a */
                                private final AnonymousClass1 f14936a;

                                /* renamed from: b */
                                private final C3261t f14937b;

                                {
                                    this.f14936a = this;
                                    this.f14937b = r2;
                                }

                                @Override // android.view.MenuItem.OnMenuItemClickListener
                                public boolean onMenuItemClick(MenuItem menuItem) {
                                    this.f14937b.m19544a(new File(menuItem.getTitle().toString()));
                                    return true;
                                }
                            });
                        }
                        c0173ao.m1344c();
                    }
                }
            });
            m414a.setOnLongClickListener(new View.OnLongClickListener(this, this.f14933c) { // from class: ru.maximoff.apktool.d.a.6.2

                /* renamed from: a */
                private final AnonymousClass6 f14938a;

                /* renamed from: b */
                private final C3261t f14939b;

                {
                    this.f14938a = this;
                    this.f14939b = r2;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    List<String> m19205b = this.f14939b.m19549d().m19205b();
                    if (m19205b.isEmpty()) {
                        return false;
                    }
                    C0173ao c0173ao = new C0173ao(AnonymousClass6.m17018a(this.f14938a).f14914a, view);
                    Iterator<String> it = m19205b.iterator();
                    while (it.hasNext()) {
                        c0173ao.m1339a().add(0, 1300, 0, it.next()).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f14939b) { // from class: ru.maximoff.apktool.d.a.6.2.1

                            /* renamed from: a */
                            private final AnonymousClass2 f14940a;

                            /* renamed from: b */
                            private final C3261t f14941b;

                            {
                                this.f14940a = this;
                                this.f14941b = r2;
                            }

                            @Override // android.view.MenuItem.OnMenuItemClickListener
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                this.f14941b.m19544a(new File(menuItem.getTitle().toString()));
                                return true;
                            }
                        });
                    }
                    c0173ao.m1344c();
                    return true;
                }
            });
        }
    }
}
