package ru.maximoff.apktool.fragment.p302b;

import android.C0012R;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.io.File;
import java.util.Arrays;
import p046b.p047a.C0518d;
import ru.maximoff.apktool.fragment.C2981b;
import ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a;
import ru.maximoff.apktool.p300e.AsyncTaskC2934e;
import ru.maximoff.apktool.p300e.C2917as;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3116br;

/* compiled from: BuildItem.java */
/* renamed from: ru.maximoff.apktool.fragment.b.d */
/* loaded from: classes.dex */
public class C2985d implements InterfaceC2994m {

    /* renamed from: a */
    private final File f16391a;

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: a */
    public void mo17863a() {
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: a */
    public void mo17865a(C2991j c2991j) {
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: b */
    public void mo17868b() {
    }

    @Override // java.lang.Comparable
    public int compareTo(InterfaceC2994m interfaceC2994m) {
        return m17877a(interfaceC2994m);
    }

    public C2985d(File file) {
        this.f16391a = file;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: c */
    public boolean mo17870c() {
        return false;
    }

    /* renamed from: f */
    public File m17879f() {
        return this.f16391a;
    }

    /* renamed from: a */
    public boolean m17878a(File file) {
        return file.getAbsolutePath().startsWith(this.f16391a.getAbsolutePath());
    }

    /* renamed from: g */
    private boolean m17876g() {
        File file = new File(this.f16391a, "apktool.json");
        if (file.isFile() && file.length() > 0) {
            return true;
        }
        File file2 = new File(this.f16391a, "apktool.yml");
        if (file2.isFile() && file2.length() > 0) {
            try {
                new C3116br(file2).m19052a(file);
                return true;
            } catch (Exception e2) {
            }
        }
        return false;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: a */
    public void mo17864a(View view, ImageView imageView, TextView textView, TextView textView2, InterfaceC2995n interfaceC2995n) {
        view.setBackgroundColor(0);
        if (C3102bd.f18291a) {
            imageView.setImageResource(R.drawable.ic_play_light);
        } else {
            imageView.setImageResource(R.drawable.ic_play_dark);
        }
        String string = view.getContext().getString(R.string.compile_project);
        textView.setText(string);
        textView.setContentDescription(string);
        textView2.setVisibility(8);
        imageView.setContentDescription(string);
        imageView.setOnClickListener(new View.OnClickListener(this, view, interfaceC2995n) { // from class: ru.maximoff.apktool.fragment.b.d.1

            /* renamed from: a */
            private final C2985d f16392a;

            /* renamed from: b */
            private final View f16393b;

            /* renamed from: c */
            private final InterfaceC2995n f16394c;

            {
                this.f16392a = this;
                this.f16393b = view;
                this.f16394c = interfaceC2995n;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                this.f16392a.mo17866a(this.f16393b, this.f16394c);
            }
        });
        imageView.setOnLongClickListener(new View.OnLongClickListener(this) { // from class: ru.maximoff.apktool.fragment.b.d.2

            /* renamed from: a */
            private final C2985d f16395a;

            {
                this.f16395a = this;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return false;
            }
        });
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: a */
    public boolean mo17866a(View view, InterfaceC2995n interfaceC2995n) {
        Context context = view.getContext();
        if (!m17876g()) {
            C3112bn.m19023b(context, context.getString(R.string.error));
            return false;
        }
        C3102bd.f18317ay = (boolean[]) null;
        boolean[] zArr = {false};
        View inflate = LayoutInflater.from(context).inflate(R.layout.compile, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.compileTextView1);
        ((LinearLayout) inflate.findViewById(R.id.compileLinearLayout1)).setVisibility(0);
        boolean m18925a = C3102bd.m18925a(context, "custom_signature_file", false);
        int m18905a = C3102bd.m18905a(context, "selected_signature", 1);
        String[] strArr = new String[m18925a ? 4 : 3];
        strArr[0] = context.getString(R.string.copyOriginalFiles);
        strArr[1] = context.getString(R.string.not_sign);
        strArr[2] = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(context.getString(R.string.default_signature_file)).append(" (").toString()).append(C3102bd.f18324g).toString()).append(")").toString();
        if (m18925a) {
            strArr[3] = context.getString(R.string.custom_signature_file);
        } else if (m18905a > 1) {
            m18905a = 1;
        }
        String[] stringArray = context.getResources().getStringArray(R.array.keys);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.compileImageView1);
        if (C3102bd.f18291a) {
            imageView.setImageResource(R.drawable.ic_settings_light);
        } else {
            imageView.setImageResource(R.drawable.ic_settings_dark);
        }
        imageView.setOnClickListener(new View.OnClickListener(this, context) { // from class: ru.maximoff.apktool.fragment.b.d.3

            /* renamed from: a */
            private final C2985d f16396a;

            /* renamed from: b */
            private final Context f16397b;

            {
                this.f16396a = this;
                this.f16397b = context;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                C3080al.m18598f(this.f16397b);
            }
        });
        boolean m18946d = C3102bd.m18946d();
        Spinner spinner = (Spinner) inflate.findViewById(R.id.compileSpinner0);
        spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(context, C0012R.layout.simple_spinner_dropdown_item, context.getResources().getStringArray(R.array.store_type)));
        spinner.setSelection((C3102bd.f18316ax && m18946d) ? 1 : 0);
        spinner.setEnabled(m18946d);
        spinner.setOnLongClickListener(new View.OnLongClickListener(this, context, spinner) { // from class: ru.maximoff.apktool.fragment.b.d.4

            /* renamed from: a */
            private final C2985d f16398a;

            /* renamed from: b */
            private final Context f16399b;

            /* renamed from: c */
            private final Spinner f16400c;

            {
                this.f16398a = this;
                this.f16399b = context;
                this.f16400c = spinner;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                C3080al.m18550a(this.f16399b, this.f16400c, 0);
                return true;
            }
        });
        Spinner spinner2 = (Spinner) inflate.findViewById(R.id.compileSpinner1);
        spinner2.setAdapter((SpinnerAdapter) new ArrayAdapter(context, C0012R.layout.simple_spinner_dropdown_item, strArr));
        if (C3102bd.m18925a(context, "copyOriginalFiles", false)) {
            spinner2.setSelection(0);
        } else {
            spinner2.setSelection(m18905a + 1);
        }
        spinner2.setOnLongClickListener(new View.OnLongClickListener(this, stringArray, context, spinner2, strArr) { // from class: ru.maximoff.apktool.fragment.b.d.5

            /* renamed from: a */
            private final C2985d f16401a;

            /* renamed from: b */
            private final String[] f16402b;

            /* renamed from: c */
            private final Context f16403c;

            /* renamed from: d */
            private final Spinner f16404d;

            /* renamed from: e */
            private final String[] f16405e;

            {
                this.f16401a = this;
                this.f16402b = stringArray;
                this.f16403c = context;
                this.f16404d = spinner2;
                this.f16405e = strArr;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                int i;
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f16402b.length) {
                        i = -1;
                        break;
                    }
                    if (this.f16402b[i2].equals(C3102bd.f18324g)) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                new DialogInterfaceC0070b.a(this.f16403c).m418a(R.string.default_key).m430a(this.f16402b, i, new DialogInterface.OnClickListener(this, this.f16403c, this.f16402b, this.f16404d, this.f16405e) { // from class: ru.maximoff.apktool.fragment.b.d.5.1

                    /* renamed from: a */
                    private final AnonymousClass5 f16406a;

                    /* renamed from: b */
                    private final Context f16407b;

                    /* renamed from: c */
                    private final String[] f16408c;

                    /* renamed from: d */
                    private final Spinner f16409d;

                    /* renamed from: e */
                    private final String[] f16410e;

                    {
                        this.f16406a = this;
                        this.f16407b = r2;
                        this.f16408c = r3;
                        this.f16409d = r4;
                        this.f16410e = r5;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        C3102bd.m18937b(this.f16407b, "default_key", this.f16408c[i3]);
                        C3102bd.f18324g = this.f16408c[i3];
                        try {
                            C3102bd.m18919a(this.f16407b.getAssets(), this.f16407b.getFilesDir());
                            String string = this.f16407b.getString(R.string.default_signature_file);
                            int selectedItemPosition = this.f16409d.getSelectedItemPosition();
                            int i4 = 0;
                            while (true) {
                                if (i4 >= this.f16410e.length) {
                                    i4 = selectedItemPosition;
                                    break;
                                } else if (!this.f16410e[i4].startsWith(string)) {
                                    i4++;
                                } else {
                                    this.f16410e[i4] = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(string).append(" (").toString()).append(C3102bd.f18324g).toString()).append(")").toString();
                                    break;
                                }
                            }
                            this.f16409d.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f16407b, C0012R.layout.simple_spinner_dropdown_item, this.f16410e));
                            this.f16409d.setSelection(i4);
                        } catch (Exception e2) {
                            C3112bn.m18999a(this.f16407b, R.string.error);
                        }
                        dialogInterface.dismiss();
                    }
                }).m420a(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
                return true;
            }
        });
        String string = context.getString(R.string.use_aapt2);
        textView.setText(context.getString(R.string.confirmb, this.f16391a.getName()));
        RadioButton radioButton = (RadioButton) inflate.findViewById(R.id.compileRadioButton1);
        RadioButton radioButton2 = (RadioButton) inflate.findViewById(R.id.compileRadioButton2);
        radioButton.setText(string.replace("aapt2", "aapt"));
        radioButton2.setText(string);
        radioButton2.setChecked(C3102bd.f18279O);
        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(context);
        aVar.m435b(inflate);
        aVar.m434b(R.string.cancel, (DialogInterface.OnClickListener) null);
        aVar.m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, spinner2, context, radioButton2, spinner, m18946d, interfaceC2995n, zArr) { // from class: ru.maximoff.apktool.fragment.b.d.6

            /* renamed from: a */
            private final C2985d f16411a;

            /* renamed from: b */
            private final Spinner f16412b;

            /* renamed from: c */
            private final Context f16413c;

            /* renamed from: d */
            private final RadioButton f16414d;

            /* renamed from: e */
            private final Spinner f16415e;

            /* renamed from: f */
            private final boolean f16416f;

            /* renamed from: g */
            private final InterfaceC2995n f16417g;

            /* renamed from: h */
            private final boolean[] f16418h;

            {
                this.f16411a = this;
                this.f16412b = spinner2;
                this.f16413c = context;
                this.f16414d = radioButton2;
                this.f16415e = spinner;
                this.f16416f = m18946d;
                this.f16417g = interfaceC2995n;
                this.f16418h = zArr;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                boolean z;
                int selectedItemPosition = this.f16412b.getSelectedItemPosition();
                if (selectedItemPosition > 0) {
                    selectedItemPosition--;
                    C3102bd.m18935b(this.f16413c, "selected_signature", selectedItemPosition);
                    z = false;
                } else {
                    z = true;
                }
                boolean isChecked = this.f16414d.isChecked();
                C0518d c0518d = C0518d.f3579w;
                c0518d.f3585f = z;
                if (isChecked) {
                    c0518d.f3600u = C3102bd.f18278N;
                    c0518d.f3601v = 2;
                } else {
                    c0518d.f3600u = C3102bd.f18321d;
                    c0518d.f3601v = 1;
                }
                if (this.f16415e.getSelectedItemPosition() == 0 || !this.f16416f) {
                    C3102bd.m18938b(this.f16413c, "user_frameworks", false);
                    C3102bd.f18316ax = false;
                    c0518d.f3598s = C3102bd.f18322e;
                } else {
                    C3102bd.m18938b(this.f16413c, "user_frameworks", true);
                    C3102bd.f18316ax = true;
                    c0518d.f3598s = C3102bd.f18323f;
                }
                C3102bd.m18938b(this.f16413c, "use_aapt2", isChecked);
                C3102bd.m18938b(this.f16413c, "copyOriginalFiles", z);
                C3102bd.f18279O = isChecked;
                this.f16411a.m17874a(this.f16413c, this.f16417g, selectedItemPosition, this.f16418h[0]);
            }
        });
        aVar.m440c(R.string.settings, (DialogInterface.OnClickListener) null);
        DialogInterfaceC0070b m438b = aVar.m438b();
        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, m438b, zArr, context) { // from class: ru.maximoff.apktool.fragment.b.d.7

            /* renamed from: a */
            private final C2985d f16419a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f16420b;

            /* renamed from: c */
            private final boolean[] f16421c;

            /* renamed from: d */
            private final Context f16422d;

            {
                this.f16419a = this;
                this.f16420b = m438b;
                this.f16421c = zArr;
                this.f16422d = context;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                Button m414a = this.f16420b.m414a(-1);
                m414a.setOnLongClickListener(new View.OnLongClickListener(this, this.f16421c, m414a) { // from class: ru.maximoff.apktool.fragment.b.d.7.1

                    /* renamed from: a */
                    private final AnonymousClass7 f16423a;

                    /* renamed from: b */
                    private final boolean[] f16424b;

                    /* renamed from: c */
                    private final Button f16425c;

                    {
                        this.f16423a = this;
                        this.f16424b = r2;
                        this.f16425c = m414a;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view2) {
                        this.f16424b[0] = true;
                        this.f16425c.performClick();
                        return true;
                    }
                });
                this.f16420b.m414a(-3).setOnClickListener(new View.OnClickListener(this, this.f16422d) { // from class: ru.maximoff.apktool.fragment.b.d.7.2

                    /* renamed from: a */
                    private final AnonymousClass7 f16426a;

                    /* renamed from: b */
                    private final Context f16427b;

                    {
                        this.f16426a = this;
                        this.f16427b = r2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        C3080al.m18587c(this.f16427b, 1);
                    }
                });
            }
        });
        m438b.show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17874a(Context context, InterfaceC2995n interfaceC2995n, int i, boolean z) {
        C2917as.m17314a(context, i, new C2917as.a(this, context, interfaceC2995n, z) { // from class: ru.maximoff.apktool.fragment.b.d.8

            /* renamed from: a */
            private final C2985d f16428a;

            /* renamed from: b */
            private final Context f16429b;

            /* renamed from: c */
            private final InterfaceC2995n f16430c;

            /* renamed from: d */
            private final boolean f16431d;

            {
                this.f16428a = this;
                this.f16429b = context;
                this.f16430c = interfaceC2995n;
                this.f16431d = z;
            }

            @Override // ru.maximoff.apktool.p300e.C2917as.a
            /* renamed from: a */
            public void mo16440a(C2917as c2917as, boolean z2) {
                try {
                    AsyncTaskC2934e asyncTaskC2934e = new AsyncTaskC2934e(this.f16429b, this.f16430c, c2917as, z2);
                    AbstractAsyncTaskC2898a.m17032d(this.f16431d);
                    asyncTaskC2934e.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f16428a.f16391a);
                } catch (Exception e2) {
                    C3112bn.m18999a(this.f16429b, R.string.error_try_again);
                }
            }
        });
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: a */
    public boolean mo17867a(C2981b c2981b) {
        return false;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: b */
    public boolean mo17869b(View view, InterfaceC2995n interfaceC2995n) {
        return false;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: d */
    public String mo17871d() {
        return (String) null;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: e */
    public int mo17872e() {
        return -2;
    }

    /* renamed from: a */
    public int m17877a(InterfaceC2994m interfaceC2994m) {
        return (-2) - interfaceC2994m.mo17872e();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f16391a, new Integer(mo17872e())});
    }
}
