package ru.maximoff.apktool.fragment.p302b;

import android.C0012R;
import android.app.Notification;
import android.content.Context;
import android.content.p006pm.ApplicationInfo;
import android.content.p006pm.PackageInfo;
import android.content.p006pm.PackageManager;
import android.p008os.Build;
import android.p008os.Bundle;
import android.p008os.Handler;
import android.p008os.Looper;
import android.p008os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import ru.maximoff.apktool.fragment.C2981b;
import ru.maximoff.apktool.util.C3078aj;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3246h;
import ru.maximoff.apktool.util.C3252l;
import ru.maximoff.apktool.util.p306d.C3212b;
import ru.maximoff.apktool.view.TreeView;

/* compiled from: ApplicationsPage.java */
/* renamed from: ru.maximoff.apktool.fragment.b.b */
/* loaded from: classes.dex */
public class RunnableC2983b implements Runnable {

    /* renamed from: a */
    private View f16344a;

    /* renamed from: b */
    private PackageManager f16345b;

    /* renamed from: c */
    private CharSequence f16346c;

    /* renamed from: d */
    private TreeView<C2986e> f16347d;

    /* renamed from: e */
    private RunnableC2987f f16348e;

    /* renamed from: f */
    private C2982a f16349f;

    /* renamed from: g */
    private C2982a f16350g;

    /* renamed from: h */
    private SwipeRefreshLayout f16351h;

    /* renamed from: i */
    private EditText f16352i;

    /* renamed from: j */
    private String f16353j;

    /* renamed from: k */
    private Handler f16354k;

    /* renamed from: l */
    private boolean f16355l = false;

    /* renamed from: m */
    private Context f16356m;

    /* renamed from: n */
    private boolean f16357n;

    /* renamed from: o */
    private C3252l f16358o;

    public RunnableC2983b(Context context) {
        this.f16357n = false;
        LayoutInflater from = LayoutInflater.from(context);
        this.f16356m = context;
        this.f16358o = new C3252l(context);
        this.f16353j = (String) null;
        this.f16354k = new Handler(this, Looper.getMainLooper(), context) { // from class: ru.maximoff.apktool.fragment.b.b.1

            /* renamed from: a */
            private final RunnableC2983b f16359a;

            /* renamed from: b */
            private final Context f16360b;

            {
                this.f16359a = this;
                this.f16360b = context;
            }

            @Override // android.p008os.Handler
            public void handleMessage(Message message) {
                Bundle data = message.getData();
                switch (message.what) {
                    case 0:
                        C3112bn.m19023b(this.f16360b, this.f16360b.getString(R.string.errorf, data.getString(Notification.CATEGORY_ERROR)));
                        break;
                    case 1:
                        this.f16359a.m17856e();
                        break;
                }
                this.f16359a.f16355l = false;
                if (this.f16359a.f16351h != null) {
                    this.f16359a.f16351h.setRefreshing(false);
                }
                this.f16359a.m17854c();
            }
        };
        this.f16345b = context.getPackageManager();
        this.f16344a = from.inflate(R.layout.errors, (ViewGroup) null);
        this.f16346c = context.getText(R.string.apps);
        this.f16347d = (TreeView) this.f16344a.findViewById(R.id.errors);
        this.f16351h = (SwipeRefreshLayout) this.f16344a.findViewById(R.id.swipe_container);
        LinearLayout linearLayout = (LinearLayout) this.f16344a.findViewById(R.id.errorsLinearLayout1);
        this.f16352i = (EditText) this.f16344a.findViewById(R.id.errorsEditText1);
        ImageView imageView = (ImageView) this.f16344a.findViewById(R.id.clearText1);
        if (C3102bd.f18291a) {
            imageView.setImageResource(R.drawable.ic_close);
        } else {
            imageView.setImageResource(R.drawable.ic_close_dark);
        }
        if (this.f16352i.getText().length() == 0) {
            imageView.setVisibility(8);
        }
        imageView.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.fragment.b.b.2

            /* renamed from: a */
            private final RunnableC2983b f16362a;

            {
                this.f16362a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f16362a.f16352i.requestFocus();
                this.f16362a.f16352i.setText("");
            }
        });
        linearLayout.setVisibility(0);
        this.f16349f = new C2982a(context, context.getText(R.string.apps_installed), context.getText(R.string.apps_installed_sum), false);
        this.f16350g = new C2982a(context, context.getText(R.string.apps_system), context.getText(R.string.apps_system_sum), true);
        this.f16352i.addTextChangedListener(new TextWatcher(this, imageView) { // from class: ru.maximoff.apktool.fragment.b.b.3

            /* renamed from: a */
            private final RunnableC2983b f16363a;

            /* renamed from: b */
            private final ImageView f16364b;

            {
                this.f16363a = this;
                this.f16364b = imageView;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0) {
                    this.f16364b.setVisibility(8);
                } else {
                    this.f16364b.setVisibility(0);
                }
                this.f16363a.f16353j = editable.toString();
                this.f16363a.m17855d();
                this.f16363a.f16352i.requestFocus();
            }
        });
        this.f16352i.setImeOptions(3);
        C3112bn.m19006a(this.f16352i, 10000);
        C3212b c3212b = new C3212b(context, "apps");
        ImageView imageView2 = (ImageView) this.f16344a.findViewById(R.id.errorsImageView1);
        imageView2.setClickable(true);
        if (C3102bd.f18291a) {
            imageView2.setImageResource(R.drawable.ic_collapse);
        } else {
            imageView2.setImageResource(R.drawable.ic_collapse_dark);
        }
        if (c3212b.m19205b().isEmpty()) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setVisibility(0);
        }
        imageView2.setOnClickListener(new View.OnClickListener(this, c3212b, imageView2) { // from class: ru.maximoff.apktool.fragment.b.b.4

            /* renamed from: a */
            private final RunnableC2983b f16365a;

            /* renamed from: b */
            private final C3212b f16366b;

            /* renamed from: c */
            private final ImageView f16367c;

            {
                this.f16365a = this;
                this.f16366b = c3212b;
                this.f16367c = imageView2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f16366b.m19201a(this.f16367c, this.f16365a.f16352i);
            }
        });
        imageView2.setOnLongClickListener(new View.OnLongClickListener(this, c3212b, imageView2, context) { // from class: ru.maximoff.apktool.fragment.b.b.5

            /* renamed from: a */
            private final RunnableC2983b f16368a;

            /* renamed from: b */
            private final C3212b f16369b;

            /* renamed from: c */
            private final ImageView f16370c;

            /* renamed from: d */
            private final Context f16371d;

            {
                this.f16368a = this;
                this.f16369b = c3212b;
                this.f16370c = imageView2;
                this.f16371d = context;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                new C3078aj(this.f16371d).m18500b(R.string.clear_history).m18495a(R.string.yes, new Runnable(this, this.f16369b, this.f16370c) { // from class: ru.maximoff.apktool.fragment.b.b.5.1

                    /* renamed from: a */
                    private final AnonymousClass5 f16372a;

                    /* renamed from: b */
                    private final C3212b f16373b;

                    /* renamed from: c */
                    private final ImageView f16374c;

                    {
                        this.f16372a = this;
                        this.f16373b = r2;
                        this.f16374c = r3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f16373b.m19208d();
                        this.f16374c.setVisibility(8);
                    }
                }).m18508e(R.string.cancel).m18507d();
                return true;
            }
        });
        this.f16352i.setOnEditorActionListener(new TextView.OnEditorActionListener(this, c3212b, imageView2) { // from class: ru.maximoff.apktool.fragment.b.b.6

            /* renamed from: a */
            private final RunnableC2983b f16375a;

            /* renamed from: b */
            private final C3212b f16376b;

            /* renamed from: c */
            private final ImageView f16377c;

            {
                this.f16375a = this;
                this.f16376b = c3212b;
                this.f16377c = imageView2;
            }

            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 3) {
                    return false;
                }
                this.f16375a.f16353j = this.f16375a.f16352i.getText().toString();
                if (this.f16376b.m19204a(this.f16375a.f16353j)) {
                    this.f16377c.setVisibility(0);
                }
                this.f16375a.m17855d();
                return true;
            }
        });
        String[] strArr = {this.f16356m.getString(R.string.name), this.f16356m.getString(R.string.pname_app), this.f16356m.getString(R.string.inst_date), this.f16356m.getString(R.string.inst_update), this.f16356m.getString(R.string.apk_size_label)};
        Spinner spinner = (Spinner) this.f16344a.findViewById(R.id.errorsSpinner1);
        spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f16356m, C0012R.layout.simple_spinner_dropdown_item, strArr));
        spinner.setSelection(C3102bd.m18905a(this.f16356m, "apps_sort", 0));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(this) { // from class: ru.maximoff.apktool.fragment.b.b.7

            /* renamed from: a */
            private final RunnableC2983b f16378a;

            {
                this.f16378a = this;
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                C3102bd.m18935b(this.f16378a.f16356m, "apps_sort", i);
                this.f16378a.m17855d();
            }
        });
        this.f16357n = C3102bd.m18925a(this.f16356m, "apps_sort_asc", false);
        ImageView imageView3 = (ImageView) this.f16344a.findViewById(R.id.errorsImageButton1);
        imageView3.setClickable(true);
        if (C3102bd.f18291a) {
            if (this.f16357n) {
                imageView3.setImageResource(R.drawable.ic_sort_asc);
            } else {
                imageView3.setImageResource(R.drawable.ic_sort_desc);
            }
        } else if (this.f16357n) {
            imageView3.setImageResource(R.drawable.ic_sort_asc_dark);
        } else {
            imageView3.setImageResource(R.drawable.ic_sort_desc_dark);
        }
        imageView3.setOnClickListener(new View.OnClickListener(this, imageView3) { // from class: ru.maximoff.apktool.fragment.b.b.8

            /* renamed from: a */
            private final RunnableC2983b f16379a;

            /* renamed from: b */
            private final ImageView f16380b;

            {
                this.f16379a = this;
                this.f16380b = imageView3;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f16379a.f16357n = !this.f16379a.f16357n;
                C3102bd.m18938b(this.f16379a.f16356m, "apps_sort_asc", this.f16379a.f16357n);
                if (C3102bd.f18291a) {
                    if (this.f16379a.f16357n) {
                        this.f16380b.setImageResource(R.drawable.ic_sort_asc);
                    } else {
                        this.f16380b.setImageResource(R.drawable.ic_sort_desc);
                    }
                } else if (this.f16379a.f16357n) {
                    this.f16380b.setImageResource(R.drawable.ic_sort_asc_dark);
                } else {
                    this.f16380b.setImageResource(R.drawable.ic_sort_desc_dark);
                }
                this.f16379a.m17855d();
            }
        });
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            m17850g();
            this.f16354k.sendEmptyMessage(1);
        } catch (Exception e2) {
            Bundle bundle = new Bundle();
            Message obtain = Message.obtain();
            obtain.what = 0;
            bundle.putString(Notification.CATEGORY_ERROR, e2.getMessage());
            obtain.setData(bundle);
            this.f16354k.sendMessage(obtain);
        }
    }

    /* renamed from: a */
    public void m17852a(C2981b c2981b) {
        int m19470a;
        int i;
        this.f16348e = new RunnableC2987f(this) { // from class: ru.maximoff.apktool.fragment.b.b.9

            /* renamed from: c */
            private final RunnableC2983b f16381c;

            {
                this.f16381c = this;
            }

            @Override // ru.maximoff.apktool.fragment.p302b.RunnableC2987f, ru.maximoff.apktool.view.InterfaceC3314p
            /* renamed from: a */
            public boolean mo17858a() {
                return true;
            }

            @Override // ru.maximoff.apktool.fragment.p302b.RunnableC2987f, ru.maximoff.apktool.fragment.p302b.C2986e
            /* renamed from: b */
            public void mo17859b() {
                this.f16433b.clear();
            }
        };
        switch (C3102bd.f18319b) {
            case 1:
                m19470a = -12303292;
                i = -1;
                break;
            case 2:
                m19470a = C3246h.m19470a(this.f16356m, R.color.primary_material);
                i = -1;
                break;
            default:
                m19470a = -1;
                i = -12303292;
                break;
        }
        this.f16351h.setColorSchemeColors(i);
        this.f16351h.setProgressBackgroundColorSchemeColor(m19470a);
        this.f16351h.setOnRefreshListener(new SwipeRefreshLayout.InterfaceC0447b(this) { // from class: ru.maximoff.apktool.fragment.b.b.10

            /* renamed from: a */
            private final RunnableC2983b f16361a;

            {
                this.f16361a = this;
            }

            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.InterfaceC0447b
            /* renamed from: a */
            public void mo3375a() {
                this.f16361a.m17855d();
            }
        });
        m17854c();
        this.f16347d.setAdapter(this.f16348e);
        m17855d();
    }

    /* renamed from: a */
    public View m17851a() {
        return this.f16344a;
    }

    /* renamed from: b */
    public CharSequence m17853b() {
        return this.f16346c;
    }

    /* renamed from: c */
    public void m17854c() {
        if (this.f16351h == null) {
            return;
        }
        this.f16351h.setEnabled(C3102bd.f18303ak);
    }

    /* renamed from: d */
    public void m17855d() {
        if (!this.f16355l) {
            this.f16355l = true;
            if (this.f16351h != null) {
                this.f16351h.setRefreshing(true);
            }
            new Thread(this).start();
        }
    }

    /* renamed from: e */
    public void m17856e() {
        if (this.f16348e != null) {
            try {
                this.f16348e.mo17859b();
                this.f16349f.m17881a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append((Object) this.f16356m.getText(R.string.apps_installed)).append(" (").toString()).append(this.f16349f.m17889g()).toString()).append(")").toString());
                this.f16348e.mo17883a((C2986e) this.f16349f);
                this.f16350g.m17881a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append((Object) this.f16356m.getText(R.string.apps_system)).append(" (").toString()).append(this.f16350g.m17889g()).toString()).append(")").toString());
                this.f16348e.mo17883a((C2986e) this.f16350g);
                m17857f();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: f */
    public void m17857f() {
        m17854c();
        if (this.f16348e == null) {
            return;
        }
        this.f16348e.m17898j();
    }

    /* renamed from: g */
    private void m17850g() {
        this.f16349f.mo17859b();
        this.f16350g.mo17859b();
        this.f16358o.m19506a();
        for (PackageInfo packageInfo : this.f16345b.getInstalledPackages(0)) {
            if (!C3112bn.m19040o(this.f16353j)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(packageInfo.packageName.toLowerCase());
                arrayList.add(packageInfo.applicationInfo.loadLabel(this.f16345b).toString().toLowerCase());
                arrayList.add(packageInfo.versionName);
                arrayList.add(String.valueOf(packageInfo.versionCode));
                if (Build.VERSION.SDK_INT >= 21) {
                    ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                    if (applicationInfo.splitSourceDirs != null && applicationInfo.splitSourceDirs.length > 0) {
                        arrayList.add(this.f16356m.getString(R.string.split));
                    }
                }
                if (m17844a(arrayList)) {
                }
            } else {
                this.f16358o.m19507a(packageInfo.applicationInfo.sourceDir, packageInfo.packageName);
            }
            if (packageInfo.applicationInfo.sourceDir.startsWith("/data/") || packageInfo.applicationInfo.sourceDir.startsWith("/mnt/")) {
                this.f16349f.m17835a(packageInfo, this.f16345b);
            } else {
                this.f16350g.m17835a(packageInfo, this.f16345b);
            }
        }
        if (C3112bn.m19040o(this.f16353j)) {
            this.f16358o.m19510d();
        }
        a aVar = new a(this);
        Collections.sort(this.f16349f.m17888f(), aVar);
        Collections.sort(this.f16350g.m17888f(), aVar);
        if (this.f16357n) {
            Collections.reverse(this.f16349f.m17888f());
            Collections.reverse(this.f16350g.m17888f());
        }
    }

    /* renamed from: a */
    private boolean m17844a(List<String> list) {
        for (String str : list) {
            if (str != null && str.toLowerCase().contains(this.f16353j.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /* compiled from: ApplicationsPage.java */
    /* renamed from: ru.maximoff.apktool.fragment.b.b$a */
    private class a implements Comparator<C2986e> {

        /* renamed from: a */
        private final RunnableC2983b f16382a;

        @Override // java.util.Comparator
        public int compare(C2986e c2986e, C2986e c2986e2) {
            return m17860a(c2986e, c2986e2);
        }

        /* renamed from: a */
        public int m17860a(C2986e c2986e, C2986e c2986e2) {
            PackageInfo m17890h = c2986e.m17890h();
            PackageInfo m17890h2 = c2986e2.m17890h();
            if (m17890h == null || m17890h2 == null) {
                return 0;
            }
            switch (C3102bd.m18905a(this.f16382a.f16356m, "apps_sort", 0)) {
                case 1:
                    return m17890h.packageName.toLowerCase().compareTo(m17890h2.packageName.toLowerCase());
                case 2:
                    if (m17890h.firstInstallTime <= m17890h2.firstInstallTime) {
                        return m17890h.firstInstallTime < m17890h2.firstInstallTime ? 1 : 0;
                    }
                    return -1;
                case 3:
                    if (m17890h.lastUpdateTime <= m17890h2.lastUpdateTime) {
                        return m17890h.lastUpdateTime < m17890h2.lastUpdateTime ? 1 : 0;
                    }
                    return -1;
                case 4:
                    File[] m18570a = C3080al.m18570a(m17890h);
                    File[] m18570a2 = C3080al.m18570a(m17890h2);
                    long m18525a = C3080al.m18525a(this.f16382a.f16356m, m18570a);
                    long m18525a2 = C3080al.m18525a(this.f16382a.f16356m, m18570a2);
                    if (m18525a <= m18525a2) {
                        return m18525a < m18525a2 ? 1 : 0;
                    }
                    return -1;
                default:
                    return c2986e.mo17886d().toString().toLowerCase().compareTo(c2986e2.mo17886d().toString().toLowerCase());
            }
        }

        public a(RunnableC2983b runnableC2983b) {
            this.f16382a = runnableC2983b;
        }
    }
}
