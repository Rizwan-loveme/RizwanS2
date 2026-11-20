package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.p008os.AsyncTask;
import android.p008os.Build;
import android.p008os.Handler;
import android.p008os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.widget.C0173ao;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.p217b.p218a.p219a.C1887e;
import p060c.p061a.p062a.C0546b;
import p060c.p061a.p062a.C0547c;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3067ab;
import ru.maximoff.apktool.util.C3099ba;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3254n;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p303a.C3061a;
import ru.maximoff.apktool.view.C3300b;

/* compiled from: VectorPreview.java */
/* renamed from: ru.maximoff.apktool.e.bb */
/* loaded from: classes.dex */
public class AsyncTaskC2927bb extends AsyncTask<C3099ba, String, Boolean> {

    /* renamed from: a */
    private Context f15518a;

    /* renamed from: b */
    private File f15519b;

    /* renamed from: c */
    private File f15520c;

    /* renamed from: e */
    private InterfaceC2995n f15522e;

    /* renamed from: f */
    private DialogInterfaceC0070b f15523f;

    /* renamed from: g */
    private C3099ba f15524g;

    /* renamed from: h */
    private String f15525h;

    /* renamed from: i */
    private String f15526i;

    /* renamed from: j */
    private Bitmap f15527j;

    /* renamed from: k */
    private Drawable f15528k;

    /* renamed from: l */
    private int f15529l;

    /* renamed from: m */
    private int f15530m;

    /* renamed from: n */
    private final int f15531n = 2000;

    /* renamed from: d */
    private String f15521d = "unknown";

    @Override // android.p008os.AsyncTask
    protected Boolean doInBackground(C3099ba[] c3099baArr) {
        return m17432a(c3099baArr);
    }

    @Override // android.p008os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m17434a(bool);
    }

    public AsyncTaskC2927bb(Context context, InterfaceC2995n interfaceC2995n) {
        this.f15518a = context;
        this.f15522e = interfaceC2995n;
    }

    @Override // android.p008os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f15518a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f15523f = new DialogInterfaceC0070b.a(this.f15518a).m435b(inflate).m429a(false).m438b();
        this.f15523f.show();
    }

    /* renamed from: a */
    public void m17433a(Drawable drawable, File file) {
        this.f15528k = drawable;
        this.f15519b = file;
    }

    /* renamed from: a */
    protected Boolean m17432a(C3099ba[] c3099baArr) {
        int i;
        int i2;
        int i3;
        int i4;
        try {
            try {
                this.f15524g = c3099baArr[0];
                if ((this.f15524g == null || !this.f15524g.m18881j()) && this.f15528k != null) {
                    this.f15529l = this.f15528k.getIntrinsicWidth();
                    this.f15530m = this.f15528k.getIntrinsicHeight();
                    if (this.f15529l > this.f15530m) {
                        i2 = (this.f15530m * 2000) / this.f15529l;
                        i = 2000;
                    } else {
                        i = (this.f15529l * 2000) / this.f15530m;
                        i2 = 2000;
                    }
                    this.f15527j = C3067ab.m18373a(this.f15528k, i, i2);
                    try {
                        this.f15520c = File.createTempFile("APKTOOL_M", (String) null, C3102bd.m18908a());
                        C3061a.m18319b(this.f15520c, m17416a(this.f15519b));
                        this.f15524g = new C3099ba(this.f15518a, this.f15520c);
                        this.f15525h = this.f15524g.m18882k();
                    } catch (Exception e2) {
                    }
                    return new Boolean(true);
                }
                if (this.f15522e != null && this.f15522e.mo17952g() != null && (this.f15524g.m18879h() || this.f15524g.m18880i())) {
                    this.f15524g.m18871a(this.f15522e.mo17952g());
                }
                this.f15519b = this.f15524g.m18874c();
                this.f15525h = this.f15524g.m18882k();
                this.f15526i = this.f15524g.m18883l();
                this.f15529l = this.f15524g.m18875d();
                this.f15530m = this.f15524g.m18876e();
                if (this.f15529l > this.f15530m) {
                    i4 = (this.f15530m * 2000) / this.f15529l;
                    i3 = 2000;
                } else {
                    i3 = (this.f15529l * 2000) / this.f15530m;
                    i4 = 2000;
                }
                this.f15527j = C3067ab.m18378a(this.f15525h, i3, i4);
                return new Boolean(true);
            } catch (Exception e3) {
                e = e3;
                this.f15521d = e.getMessage();
                return new Boolean(false);
            }
        } catch (Error e4) {
            e = e4;
            this.f15521d = e.getMessage();
            return new Boolean(false);
        }
    }

    /* renamed from: a */
    protected void m17434a(Boolean bool) {
        if (this.f15523f != null && this.f15523f.isShowing()) {
            try {
                this.f15523f.cancel();
            } catch (Exception e2) {
            }
        }
        if (!bool.booleanValue()) {
            C3112bn.m19023b(this.f15518a, this.f15518a.getString(R.string.errorf, this.f15521d));
            return;
        }
        try {
            int[] iArr = {Math.min(7, C3102bd.m18905a(this.f15518a, "vector_preview_background", 0))};
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0f);
            C3300b c3300b = new C3300b(this.f15518a);
            c3300b.setZoomable(true);
            c3300b.setMaximumScale(10.0f);
            c3300b.setBackgroundColor(0);
            c3300b.setScaleType(ImageView.ScaleType.FIT_CENTER);
            c3300b.setImageBitmap(this.f15527j);
            c3300b.setLayoutParams(layoutParams);
            DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f15518a).m427a(this.f15518a.getString(R.string.previewf, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f15519b.getName()).append(" (").toString()).append(this.f15529l).toString()).append("×").toString()).append(this.f15530m).toString()).append(")").toString())).m435b(c3300b).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m434b(R.string.save, (DialogInterface.OnClickListener) null).m440c(R.string.background_preview, (DialogInterface.OnClickListener) null).m438b();
            m438b.setOnShowListener(new AnonymousClass1(this, m438b, iArr, c3300b));
            m438b.setOnCancelListener(new DialogInterface.OnCancelListener(this) { // from class: ru.maximoff.apktool.e.bb.2

                /* renamed from: a */
                private final AsyncTaskC2927bb f15549a;

                {
                    this.f15549a = this;
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (this.f15549a.f15520c != null) {
                        this.f15549a.f15520c.delete();
                    }
                }
            });
            m438b.show();
            WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
            layoutParams2.copyFrom(m438b.getWindow().getAttributes());
            layoutParams2.width = -1;
            layoutParams2.height = -2;
            m438b.getWindow().setAttributes(layoutParams2);
        } catch (Exception e3) {
            C3112bn.m19023b(this.f15518a, this.f15518a.getString(R.string.errorf, e3.getMessage()));
        }
    }

    /* compiled from: VectorPreview.java */
    /* renamed from: ru.maximoff.apktool.e.bb$1, reason: invalid class name */
    class AnonymousClass1 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final AsyncTaskC2927bb f15532a;

        /* renamed from: b */
        private final DialogInterfaceC0070b f15533b;

        /* renamed from: c */
        private final int[] f15534c;

        /* renamed from: d */
        private final C3300b f15535d;

        AnonymousClass1(AsyncTaskC2927bb asyncTaskC2927bb, DialogInterfaceC0070b dialogInterfaceC0070b, int[] iArr, C3300b c3300b) {
            this.f15532a = asyncTaskC2927bb;
            this.f15533b = dialogInterfaceC0070b;
            this.f15534c = iArr;
            this.f15535d = c3300b;
        }

        /* renamed from: a */
        static AsyncTaskC2927bb m17435a(AnonymousClass1 anonymousClass1) {
            return anonymousClass1.f15532a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            Button m414a = this.f15533b.m414a(-3);
            this.f15533b.m414a(-2).setOnClickListener(new ViewOnClickListenerC33871(this));
            m414a.setOnClickListener(new AnonymousClass2(this, this.f15534c, this.f15535d));
            new Handler(Looper.getMainLooper()).post(new Runnable(this, this.f15535d, this.f15534c) { // from class: ru.maximoff.apktool.e.bb.1.3

                /* renamed from: a */
                private final AnonymousClass1 f15546a;

                /* renamed from: b */
                private final C3300b f15547b;

                /* renamed from: c */
                private final int[] f15548c;

                {
                    this.f15546a = this;
                    this.f15547b = r2;
                    this.f15548c = r3;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass1.m17435a(this.f15546a).m17419a(this.f15547b, this.f15548c[0]);
                }
            });
        }

        /* compiled from: VectorPreview.java */
        /* renamed from: ru.maximoff.apktool.e.bb$1$1, reason: invalid class name and collision with other inner class name */
        class ViewOnClickListenerC33871 implements View.OnClickListener {

            /* renamed from: a */
            private final AnonymousClass1 f15536a;

            ViewOnClickListenerC33871(AnonymousClass1 anonymousClass1) {
                this.f15536a = anonymousClass1;
            }

            /* renamed from: a */
            static AnonymousClass1 m17436a(ViewOnClickListenerC33871 viewOnClickListenerC33871) {
                return viewOnClickListenerC33871.f15536a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                C0173ao c0173ao = new C0173ao(AnonymousClass1.m17435a(this.f15536a).f15518a, view);
                if (C3102bd.m18910a(AnonymousClass1.m17435a(this.f15536a).f15518a, "menu_position", "1").equals("0")) {
                    i = 3;
                } else {
                    i = 5;
                }
                c0173ao.m1340a(i);
                c0173ao.m1339a().add(0, PointerIcon.TYPE_ALIAS, 0, "PNG").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: ru.maximoff.apktool.e.bb.1.1.1

                    /* renamed from: a */
                    private final ViewOnClickListenerC33871 f15537a;

                    {
                        this.f15537a = this;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        AnonymousClass1.m17435a(ViewOnClickListenerC33871.m17436a(this.f15537a)).m17417a();
                        return true;
                    }
                });
                if (AnonymousClass1.m17435a(this.f15536a).f15524g != null && AnonymousClass1.m17435a(this.f15536a).f15524g.m18881j()) {
                    if (AnonymousClass1.m17435a(this.f15536a).f15524g.m18879h() || AnonymousClass1.m17435a(this.f15536a).f15524g.m18880i()) {
                        c0173ao.m1339a().add(0, PointerIcon.TYPE_COPY, 0, "SVG").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: ru.maximoff.apktool.e.bb.1.1.2

                            /* renamed from: a */
                            private final ViewOnClickListenerC33871 f15538a;

                            {
                                this.f15538a = this;
                            }

                            @Override // android.view.MenuItem.OnMenuItemClickListener
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                return AnonymousClass1.m17435a(ViewOnClickListenerC33871.m17436a(this.f15538a)).m17421b();
                            }
                        });
                    } else if (AnonymousClass1.m17435a(this.f15536a).f15524g.m18878g()) {
                        c0173ao.m1339a().add(0, PointerIcon.TYPE_COPY, 0, "XML").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: ru.maximoff.apktool.e.bb.1.1.3

                            /* renamed from: a */
                            private final ViewOnClickListenerC33871 f15539a;

                            {
                                this.f15539a = this;
                            }

                            @Override // android.view.MenuItem.OnMenuItemClickListener
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                return AnonymousClass1.m17435a(ViewOnClickListenerC33871.m17436a(this.f15539a)).m17423c();
                            }
                        });
                    }
                }
                c0173ao.m1344c();
            }
        }

        /* compiled from: VectorPreview.java */
        /* renamed from: ru.maximoff.apktool.e.bb$1$2, reason: invalid class name */
        class AnonymousClass2 implements View.OnClickListener {

            /* renamed from: a */
            private final AnonymousClass1 f15540a;

            /* renamed from: b */
            private final int[] f15541b;

            /* renamed from: c */
            private final C3300b f15542c;

            AnonymousClass2(AnonymousClass1 anonymousClass1, int[] iArr, C3300b c3300b) {
                this.f15540a = anonymousClass1;
                this.f15541b = iArr;
                this.f15542c = c3300b;
            }

            /* renamed from: a */
            static AnonymousClass1 m17437a(AnonymousClass2 anonymousClass2) {
                return anonymousClass2.f15540a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.f15541b[0] >= 7) {
                    this.f15541b[0] = 0;
                } else {
                    int[] iArr = this.f15541b;
                    iArr[0] = iArr[0] + 1;
                }
                new Handler(Looper.getMainLooper()).post(new Runnable(this, this.f15542c, this.f15541b) { // from class: ru.maximoff.apktool.e.bb.1.2.1

                    /* renamed from: a */
                    private final AnonymousClass2 f15543a;

                    /* renamed from: b */
                    private final C3300b f15544b;

                    /* renamed from: c */
                    private final int[] f15545c;

                    {
                        this.f15543a = this;
                        this.f15544b = r2;
                        this.f15545c = r3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1.m17435a(AnonymousClass2.m17437a(this.f15543a)).m17419a(this.f15544b, this.f15545c[0]);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17417a() {
        View inflate = LayoutInflater.from(this.f15518a).inflate(R.layout.mdialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.mdialogTextView1);
        textView.setText(this.f15518a.getString(R.string.custom_size_info, new StringBuffer().append(new StringBuffer().append(this.f15529l).append("×").toString()).append(this.f15530m).toString()));
        EditText editText = (EditText) inflate.findViewById(R.id.mdialogEditText1);
        editText.setInputType(8194);
        editText.setText(String.valueOf(Math.max(this.f15529l, this.f15530m)));
        editText.setHint(R.string.custom_size);
        editText.addTextChangedListener(new TextWatcher(this, textView) { // from class: ru.maximoff.apktool.e.bb.3

            /* renamed from: a */
            private final AsyncTaskC2927bb f15550a;

            /* renamed from: b */
            private final TextView f15551b;

            {
                this.f15550a = this;
                this.f15551b = textView;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int i;
                int i2;
                if (editable.length() == 0) {
                    this.f15551b.setText(this.f15550a.f15518a.getString(R.string.custom_size_info, "..."));
                    return;
                }
                try {
                    int abs = Math.abs(Integer.parseInt(editable.toString()));
                    if (this.f15550a.f15529l > this.f15550a.f15530m) {
                        i2 = (this.f15550a.f15530m * abs) / this.f15550a.f15529l;
                        i = abs;
                    } else {
                        i = (this.f15550a.f15529l * abs) / this.f15550a.f15530m;
                        i2 = abs;
                    }
                    this.f15551b.setText(this.f15550a.f15518a.getString(R.string.custom_size_info, new StringBuffer().append(new StringBuffer().append(i).append("×").toString()).append(i2).toString()));
                } catch (Exception e2) {
                    this.f15551b.setText(this.f15550a.f15518a.getString(R.string.custom_size_info, "..."));
                }
            }
        });
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f15518a).m427a(new StringBuffer().append("PNG - ").append(this.f15518a.getString(R.string.custom_size)).toString()).m435b(inflate).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, editText) { // from class: ru.maximoff.apktool.e.bb.4

            /* renamed from: a */
            private final AsyncTaskC2927bb f15552a;

            /* renamed from: b */
            private final EditText f15553b;

            {
                this.f15552a = this;
                this.f15553b = editText;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                int i2;
                int i3;
                try {
                    int abs = Math.abs(Integer.parseInt(this.f15553b.getText().toString()));
                    if (this.f15552a.f15529l > this.f15552a.f15530m) {
                        i3 = (this.f15552a.f15530m * abs) / this.f15552a.f15529l;
                        i2 = abs;
                    } else {
                        i2 = (this.f15552a.f15529l * abs) / this.f15552a.f15530m;
                        i3 = abs;
                    }
                    AsyncTaskC2912an asyncTaskC2912an = new AsyncTaskC2912an(this.f15552a.f15518a, this.f15552a.f15519b, i2, i3);
                    asyncTaskC2912an.m17244a(this.f15552a.f15528k);
                    asyncTaskC2912an.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f15552a.f15525h);
                } catch (Exception e2) {
                    C3112bn.m18999a(this.f15552a.f15518a, R.string.error);
                }
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, editText) { // from class: ru.maximoff.apktool.e.bb.5

            /* renamed from: a */
            private final AsyncTaskC2927bb f15554a;

            /* renamed from: b */
            private final EditText f15555b;

            {
                this.f15554a = this;
                this.f15555b = editText;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f15555b.requestFocus();
                this.f15555b.selectAll();
            }
        });
        m438b.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m17421b() {
        String str;
        int lastIndexOf = this.f15519b.getName().lastIndexOf(46);
        String name = this.f15519b.getName();
        if (lastIndexOf > 0) {
            name = name.substring(0, lastIndexOf);
        }
        if (!C3262u.m19664g(this.f15518a, this.f15519b.getParentFile()) || C3102bd.m18925a(this.f15518a, "all_to_out_dir", false)) {
            str = C3102bd.f18339v;
            if (str == null) {
                C3112bn.m19023b(this.f15518a, this.f15518a.getString(R.string.output_directory_not_set));
                return false;
            }
            File file = new File(str);
            if (!file.exists() && !file.mkdirs()) {
                C3112bn.m19023b(this.f15518a, this.f15518a.getString(R.string.output_directory_not_extsts, str));
                return false;
            }
            if (!file.isDirectory()) {
                C3112bn.m19023b(this.f15518a, this.f15518a.getString(R.string.not_directory, str));
                return false;
            }
        } else {
            str = this.f15519b.getParent();
        }
        File file2 = new File(str, C3262u.m19566a(this.f15518a, str, name, ".svg", 0));
        C3061a.m18319b(file2, new StringBuffer().append(new StringBuffer().append("<!-- ").append("Created by Apktool M – https://github.com/Maximoff/Apktool-M-updates").toString()).append(" -->\n").toString() + this.f15525h);
        MainActivity.m16615o().m16644z();
        C3112bn.m19023b(this.f15518a, this.f15518a.getString(R.string.extraction, file2.getAbsolutePath()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public boolean m17423c() {
        String str;
        int lastIndexOf = this.f15519b.getName().lastIndexOf(46);
        String name = this.f15519b.getName();
        if (lastIndexOf > 0) {
            name = name.substring(0, lastIndexOf);
        }
        if (!C3262u.m19664g(this.f15518a, this.f15519b.getParentFile()) || C3102bd.m18925a(this.f15518a, "all_to_out_dir", false)) {
            str = C3102bd.f18339v;
            if (str == null) {
                C3112bn.m19023b(this.f15518a, this.f15518a.getString(R.string.output_directory_not_set));
                return false;
            }
            File file = new File(str);
            if (!file.exists() && !file.mkdirs()) {
                C3112bn.m19023b(this.f15518a, this.f15518a.getString(R.string.output_directory_not_extsts, str));
                return false;
            }
            if (!file.isDirectory()) {
                C3112bn.m19023b(this.f15518a, this.f15518a.getString(R.string.not_directory, str));
                return false;
            }
        } else {
            str = this.f15519b.getParent();
        }
        File file2 = new File(str, C3262u.m19566a(this.f15518a, str, name, ".xml", 0));
        C3061a.m18319b(file2, this.f15526i);
        MainActivity.m16615o().m16644z();
        C3112bn.m19023b(this.f15518a, this.f15518a.getString(R.string.extraction, file2.getAbsolutePath()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17419a(C3300b c3300b, int i) {
        switch (i) {
            case 1:
                c3300b.setBackgroundResource(R.drawable.maximoff_picker_alpha_repeat);
                break;
            case 2:
                c3300b.setBackgroundColor(-1);
                break;
            case 3:
                c3300b.setBackgroundColor(Color.GRAY);
                break;
            case 4:
                c3300b.setBackgroundColor(-16777216);
                break;
            case 5:
                c3300b.setBackgroundColor(Color.RED);
                break;
            case 6:
                c3300b.setBackgroundColor(Color.GREEN);
                break;
            case 7:
                c3300b.setBackgroundColor(-16776961);
                break;
            default:
                c3300b.setBackgroundColor(0);
                break;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            c3300b.postInvalidateOnAnimation();
        } else {
            c3300b.postInvalidateDelayed(16L);
        }
        C3102bd.m18935b(this.f15518a, "vector_preview_background", i);
    }

    /* renamed from: a */
    private String m17416a(File file) {
        C0546b c0546b = new C0546b(C1887e.m13984b(new FileInputStream(file)));
        StringBuilder sb = new StringBuilder();
        c0546b.m4018a(new C3254n(new C0547c(), this.f15518a.getResources(), 0, new HashMap(), new ArrayList(), sb, (String) null));
        return sb.toString();
    }
}
