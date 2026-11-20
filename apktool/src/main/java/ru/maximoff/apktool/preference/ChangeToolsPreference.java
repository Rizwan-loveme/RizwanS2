package ru.maximoff.apktool.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaCodec;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.widget.C0173ao;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.p209io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import org.p217b.p218a.p219a.C1887e;
import ru.maximoff.apktool.SettingActivity;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3261t;
import ru.maximoff.apktool.util.C3262u;

/* loaded from: classes.dex */
public class ChangeToolsPreference extends CustomPreference {

    /* renamed from: a */
    private SettingActivity f16831a;

    public ChangeToolsPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.preference.Preference
    protected void onClick() {
        String str;
        String[] strArr;
        this.f16831a = (SettingActivity) getContext();
        if (C3102bd.f18268D.startsWith("x86")) {
            str = "x86";
        } else {
            str = "armeabi-v7a";
        }
        if (C3102bd.f18268D.equals("arm64-v8a") || C3102bd.f18268D.equals("x86-64")) {
            strArr = new String[]{"aapt", "aapt2", this.f16831a.getString(R.string.down_for, str), this.f16831a.getString(R.string.down_for, C3102bd.f18268D)};
        } else {
            strArr = new String[]{"aapt", "aapt2", this.f16831a.getString(R.string.down_for, str)};
        }
        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(this.f16831a);
        aVar.m418a(R.string.mtool_repl);
        aVar.m420a(R.string.cancel, (DialogInterface.OnClickListener) null);
        aVar.m434b(R.string.server, (DialogInterface.OnClickListener) null);
        aVar.m440c(R.string.search_reset, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.preference.ChangeToolsPreference.1

            /* renamed from: a */
            private final ChangeToolsPreference f16832a;

            {
                this.f16832a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (C3102bd.m18951f()) {
                    if (C3102bd.f18268D.equals("arm64-v8a") || C3102bd.f18268D.equals("x86-64")) {
                        C3102bd.m18938b((Context) this.f16832a.f16831a, "load_aapts_dialog", true);
                        C3102bd.m18918a(this.f16832a.f16831a, true, C3102bd.f18268D, R.string.load_binaries, new boolean[]{true, true});
                    }
                    C3112bn.m18999a(this.f16832a.f16831a, R.string.success);
                } else {
                    C3112bn.m18999a(this.f16832a.f16831a, R.string.error);
                }
                dialogInterface.dismiss();
            }
        });
        aVar.m431a(strArr, new DialogInterfaceOnClickListenerC29982(this, str, strArr));
        DialogInterfaceC0070b m438b = aVar.m438b();
        m438b.setOnShowListener(new DialogInterfaceOnShowListenerC29993(this, m438b));
        m438b.show();
    }

    /* renamed from: ru.maximoff.apktool.preference.ChangeToolsPreference$2 */
    class DialogInterfaceOnClickListenerC29982 implements DialogInterface.OnClickListener {

        /* renamed from: a */
        private final ChangeToolsPreference f16833a;

        /* renamed from: b */
        private final String f16834b;

        /* renamed from: c */
        private final String[] f16835c;

        DialogInterfaceOnClickListenerC29982(ChangeToolsPreference changeToolsPreference, String str, String[] strArr) {
            this.f16833a = changeToolsPreference;
            this.f16834b = str;
            this.f16835c = strArr;
        }

        /* renamed from: a */
        static ChangeToolsPreference m18078a(DialogInterfaceOnClickListenerC29982 dialogInterfaceOnClickListenerC29982) {
            return dialogInterfaceOnClickListenerC29982.f16833a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
            if (i > 1) {
                this.f16833a.m18075a(i == 2 ? this.f16834b : C3102bd.f18268D);
                return;
            }
            C3261t c3261t = new C3261t(this.f16833a.f16831a);
            Runnable runnable = new Runnable(this, c3261t, this.f16835c, i) { // from class: ru.maximoff.apktool.preference.ChangeToolsPreference.2.1

                /* renamed from: a */
                private final DialogInterfaceOnClickListenerC29982 f16836a;

                /* renamed from: b */
                private final C3261t f16837b;

                /* renamed from: c */
                private final String[] f16838c;

                /* renamed from: d */
                private final int f16839d;

                {
                    this.f16836a = this;
                    this.f16837b = c3261t;
                    this.f16838c = r3;
                    this.f16839d = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        DialogInterfaceOnClickListenerC29982.m18078a(this.f16836a).m18074a(new File(this.f16837b.getPath()), this.f16838c[this.f16839d]);
                        C3112bn.m19023b(DialogInterfaceOnClickListenerC29982.m18078a(this.f16836a).f16831a, DialogInterfaceOnClickListenerC29982.m18078a(this.f16836a).f16831a.getString(R.string.complete));
                    } catch (Exception e2) {
                        C3112bn.m19023b(DialogInterfaceOnClickListenerC29982.m18078a(this.f16836a).f16831a, DialogInterfaceOnClickListenerC29982.m18078a(this.f16836a).f16831a.getString(R.string.error));
                    }
                }
            };
            c3261t.m19545a("_tools");
            c3261t.m19547b();
            c3261t.setCallback(runnable);
            c3261t.setTitlePattern(new StringBuffer().append(new StringBuffer().append("%s (").append(this.f16835c[i]).toString()).append(")").toString());
            c3261t.m19550e();
            DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(this.f16833a.f16831a);
            aVar.m427a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(c3261t.m19548c()).append(" (").toString()).append(this.f16835c[i]).toString()).append(")").toString());
            aVar.m435b(c3261t);
            aVar.m420a(R.string.cancel, (DialogInterface.OnClickListener) null);
            aVar.m437b("/...", (DialogInterface.OnClickListener) null);
            aVar.m429a(false);
            aVar.m422a(new DialogInterface.OnKeyListener(this, c3261t) { // from class: ru.maximoff.apktool.preference.ChangeToolsPreference.2.2

                /* renamed from: a */
                private final DialogInterfaceOnClickListenerC29982 f16840a;

                /* renamed from: b */
                private final C3261t f16841b;

                {
                    this.f16840a = this;
                    this.f16841b = c3261t;
                }

                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface2, int i2, KeyEvent keyEvent) {
                    if (i2 != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                        return false;
                    }
                    boolean m19551f = this.f16841b.m19551f();
                    if (!m19551f) {
                        dialogInterface2.dismiss();
                        return m19551f;
                    }
                    return m19551f;
                }
            });
            DialogInterfaceC0070b m438b = aVar.m438b();
            m438b.setOnShowListener(new AnonymousClass3(this, m438b, c3261t));
            c3261t.setDialog(m438b);
            m438b.show();
        }

        /* renamed from: ru.maximoff.apktool.preference.ChangeToolsPreference$2$3, reason: invalid class name */
        class AnonymousClass3 implements DialogInterface.OnShowListener {

            /* renamed from: a */
            private final DialogInterfaceOnClickListenerC29982 f16842a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f16843b;

            /* renamed from: c */
            private final C3261t f16844c;

            AnonymousClass3(DialogInterfaceOnClickListenerC29982 dialogInterfaceOnClickListenerC29982, DialogInterfaceC0070b dialogInterfaceC0070b, C3261t c3261t) {
                this.f16842a = dialogInterfaceOnClickListenerC29982;
                this.f16843b = dialogInterfaceC0070b;
                this.f16844c = c3261t;
            }

            /* renamed from: a */
            static DialogInterfaceOnClickListenerC29982 m18079a(AnonymousClass3 anonymousClass3) {
                return anonymousClass3.f16842a;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                Button m414a = this.f16843b.m414a(-3);
                m414a.setOnClickListener(new View.OnClickListener(this, this.f16844c) { // from class: ru.maximoff.apktool.preference.ChangeToolsPreference.2.3.1

                    /* renamed from: a */
                    private final AnonymousClass3 f16845a;

                    /* renamed from: b */
                    private final C3261t f16846b;

                    {
                        this.f16845a = this;
                        this.f16846b = r2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        int i;
                        String[] m19640b = C3262u.m19640b(DialogInterfaceOnClickListenerC29982.m18078a(AnonymousClass3.m18079a(this.f16845a)).f16831a);
                        if (m19640b != null) {
                            C0173ao c0173ao = new C0173ao(DialogInterfaceOnClickListenerC29982.m18078a(AnonymousClass3.m18079a(this.f16845a)).f16831a, view);
                            if (C3102bd.m18910a(DialogInterfaceOnClickListenerC29982.m18078a(AnonymousClass3.m18079a(this.f16845a)).f16831a, "menu_position", "1").equals("0")) {
                                i = 3;
                            } else {
                                i = 5;
                            }
                            c0173ao.m1340a(i);
                            for (int i2 = 0; i2 < m19640b.length; i2++) {
                                c0173ao.m1339a().add(0, i2 + MediaCodec.CodecException.ERROR_INSUFFICIENT_RESOURCE, 0, m19640b[i2]).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f16846b) { // from class: ru.maximoff.apktool.preference.ChangeToolsPreference.2.3.1.1

                                    /* renamed from: a */
                                    private final AnonymousClass1 f16847a;

                                    /* renamed from: b */
                                    private final C3261t f16848b;

                                    {
                                        this.f16847a = this;
                                        this.f16848b = r2;
                                    }

                                    @Override // android.view.MenuItem.OnMenuItemClickListener
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        this.f16848b.m19544a(new File(menuItem.getTitle().toString()));
                                        return true;
                                    }
                                });
                            }
                            c0173ao.m1344c();
                        }
                    }
                });
                m414a.setOnLongClickListener(new View.OnLongClickListener(this, this.f16844c) { // from class: ru.maximoff.apktool.preference.ChangeToolsPreference.2.3.2

                    /* renamed from: a */
                    private final AnonymousClass3 f16849a;

                    /* renamed from: b */
                    private final C3261t f16850b;

                    {
                        this.f16849a = this;
                        this.f16850b = r2;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        int i;
                        List<String> m19205b = this.f16850b.m19549d().m19205b();
                        if (m19205b.isEmpty()) {
                            return false;
                        }
                        C0173ao c0173ao = new C0173ao(DialogInterfaceOnClickListenerC29982.m18078a(AnonymousClass3.m18079a(this.f16849a)).f16831a, view);
                        if (C3102bd.m18910a(DialogInterfaceOnClickListenerC29982.m18078a(AnonymousClass3.m18079a(this.f16849a)).f16831a, "menu_position", "1").equals("0")) {
                            i = 3;
                        } else {
                            i = 5;
                        }
                        c0173ao.m1340a(i);
                        Iterator<String> it = m19205b.iterator();
                        while (it.hasNext()) {
                            c0173ao.m1339a().add(0, 1300, 0, it.next()).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f16850b) { // from class: ru.maximoff.apktool.preference.ChangeToolsPreference.2.3.2.1

                                /* renamed from: a */
                                private final AnonymousClass2 f16851a;

                                /* renamed from: b */
                                private final C3261t f16852b;

                                {
                                    this.f16851a = this;
                                    this.f16852b = r2;
                                }

                                @Override // android.view.MenuItem.OnMenuItemClickListener
                                public boolean onMenuItemClick(MenuItem menuItem) {
                                    this.f16852b.m19544a(new File(menuItem.getTitle().toString()));
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

    /* renamed from: ru.maximoff.apktool.preference.ChangeToolsPreference$3 */
    class DialogInterfaceOnShowListenerC29993 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final ChangeToolsPreference f16853a;

        /* renamed from: b */
        private final DialogInterfaceC0070b f16854b;

        DialogInterfaceOnShowListenerC29993(ChangeToolsPreference changeToolsPreference, DialogInterfaceC0070b dialogInterfaceC0070b) {
            this.f16853a = changeToolsPreference;
            this.f16854b = dialogInterfaceC0070b;
        }

        /* renamed from: a */
        static ChangeToolsPreference m18080a(DialogInterfaceOnShowListenerC29993 dialogInterfaceOnShowListenerC29993) {
            return dialogInterfaceOnShowListenerC29993.f16853a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            this.f16854b.m414a(-2).setOnClickListener(new AnonymousClass1(this));
        }

        /* renamed from: ru.maximoff.apktool.preference.ChangeToolsPreference$3$1, reason: invalid class name */
        class AnonymousClass1 implements View.OnClickListener {

            /* renamed from: a */
            private final DialogInterfaceOnShowListenerC29993 f16855a;

            AnonymousClass1(DialogInterfaceOnShowListenerC29993 dialogInterfaceOnShowListenerC29993) {
                this.f16855a = dialogInterfaceOnShowListenerC29993;
            }

            /* renamed from: a */
            static DialogInterfaceOnShowListenerC29993 m18081a(AnonymousClass1 anonymousClass1) {
                return anonymousClass1.f16855a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i = 0;
                String[] strArr = {"githubusercontent.com", "maximoff.su", "beget.tech"};
                int m18905a = C3102bd.m18905a((Context) DialogInterfaceOnShowListenerC29993.m18080a(this.f16855a).f16831a, "aapts_server", 0);
                if (m18905a > strArr.length - 1) {
                    C3102bd.m18935b((Context) DialogInterfaceOnShowListenerC29993.m18080a(this.f16855a).f16831a, "aapts_server", 0);
                } else {
                    i = m18905a;
                }
                new DialogInterfaceC0070b.a(DialogInterfaceOnShowListenerC29993.m18080a(this.f16855a).f16831a).m418a(R.string.server).m430a(strArr, i, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.preference.ChangeToolsPreference.3.1.1

                    /* renamed from: a */
                    private final AnonymousClass1 f16856a;

                    {
                        this.f16856a = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        C3102bd.m18935b((Context) DialogInterfaceOnShowListenerC29993.m18080a(AnonymousClass1.m18081a(this.f16856a)).f16831a, "aapts_server", i2);
                        dialogInterface.cancel();
                    }
                }).m420a(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m18074a(File file, String str) {
        File file2 = new File(this.f16831a.getFilesDir(), new StringBuffer().append("bin/").append(str).toString());
        File file3 = new File(this.f16831a.getFilesDir(), new StringBuffer().append(new StringBuffer().append("bin/").append(str).toString()).append("_64").toString());
        File file4 = new File(this.f16831a.getFilesDir(), new StringBuffer().append(new StringBuffer().append("bin/").append(str).toString()).append("_usr").toString());
        if (file3.exists()) {
            file3.delete();
        }
        if (file4.exists()) {
            file4.delete();
        }
        if (file2.exists()) {
            file2.delete();
        }
        file2.getParentFile().mkdirs();
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file4);
        C1887e.m13962a(fileInputStream, fileOutputStream);
        fileInputStream.close();
        fileOutputStream.close();
        file4.setExecutable(true);
        if (str.equals("aapt")) {
            C3102bd.f18321d = file4.getAbsolutePath();
        } else if (str.equals("aapt2")) {
            C3102bd.f18278N = file4.getAbsolutePath();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m18075a(String str) {
        Button[] buttonArr = new Button[1];
        boolean[] zArr = {true, true};
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f16831a).m427a(this.f16831a.getString(R.string.down_for, str)).m432a(new String[]{"aapt", "aapt2"}, zArr, new DialogInterface.OnMultiChoiceClickListener(this, zArr, buttonArr) { // from class: ru.maximoff.apktool.preference.ChangeToolsPreference.4

            /* renamed from: a */
            private final ChangeToolsPreference f16857a;

            /* renamed from: b */
            private final boolean[] f16858b;

            /* renamed from: c */
            private final Button[] f16859c;

            {
                this.f16857a = this;
                this.f16858b = zArr;
                this.f16859c = buttonArr;
            }

            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public void onClick(DialogInterface dialogInterface, int i, boolean z) {
                this.f16858b[i] = z;
                this.f16859c[0].setEnabled(this.f16858b[0] || this.f16858b[1]);
            }
        }).m420a(R.string.mselect, new DialogInterface.OnClickListener(this, str, zArr) { // from class: ru.maximoff.apktool.preference.ChangeToolsPreference.5

            /* renamed from: a */
            private final ChangeToolsPreference f16860a;

            /* renamed from: b */
            private final String f16861b;

            /* renamed from: c */
            private final boolean[] f16862c;

            {
                this.f16860a = this;
                this.f16861b = str;
                this.f16862c = zArr;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                C3102bd.m18918a(this.f16860a.f16831a, false, this.f16861b, R.string.load_binaries, this.f16862c);
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, buttonArr, m438b) { // from class: ru.maximoff.apktool.preference.ChangeToolsPreference.6

            /* renamed from: a */
            private final ChangeToolsPreference f16863a;

            /* renamed from: b */
            private final Button[] f16864b;

            /* renamed from: c */
            private final DialogInterfaceC0070b f16865c;

            {
                this.f16863a = this;
                this.f16864b = buttonArr;
                this.f16865c = m438b;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f16864b[0] = this.f16865c.m414a(-1);
            }
        });
        m438b.show();
    }
}
