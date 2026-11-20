package ru.maximoff.apktool;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.p008os.Build;
import android.p008os.Bundle;
import android.p008os.Handler;
import android.p008os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.p044h.p045a.AbstractC0405a;
import androidx.p044h.p045a.C0406b;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.p209io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ru.maximoff.apktool.util.C3067ab;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3106bh;
import ru.maximoff.apktool.util.C3108bj;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.view.C3300b;

/* loaded from: classes.dex */
public class PreviewActivity extends AbstractActivityC2894b {

    /* renamed from: h */
    private final String[] f14185h = {"gif", "png", "jpg", "jpeg", "bmp", "webp"};

    /* renamed from: i */
    private List<File> f14186i;

    /* renamed from: j */
    private File f14187j;

    /* renamed from: k */
    private File f14188k;

    /* renamed from: l */
    private File[] f14189l;

    /* renamed from: m */
    private String[] f14190m;

    /* renamed from: n */
    private C0406b f14191n;

    /* renamed from: o */
    private TextView f14192o;

    /* renamed from: p */
    private TextView f14193p;

    /* renamed from: q */
    private Button f14194q;

    /* renamed from: r */
    private ImageView f14195r;

    /* renamed from: s */
    private Button f14196s;

    /* renamed from: t */
    private CheckBox f14197t;

    /* renamed from: u */
    private LinearLayout f14198u;

    /* renamed from: v */
    private LinearLayout f14199v;

    /* renamed from: w */
    private LinearLayout f14200w;

    /* renamed from: x */
    private ProgressBar f14201x;

    /* renamed from: y */
    private boolean f14202y;

    @Override // ru.maximoff.apktool.AbstractActivityC2894b
    /* renamed from: a */
    protected void mo16413a(Bundle bundle) {
    }

    @Override // ru.maximoff.apktool.AbstractActivityC2894b, androidx.fragment.app.ActivityC0375f, androidx.activity.ActivityC0048b, androidx.core.app.ActivityC0234e, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        String str;
        super.onCreate(bundle);
        setContentView(R.layout.viewer);
        m454f().mo397c();
        getWindow().addFlags(1024);
        getWindow().clearFlags(2048);
        Intent intent = getIntent();
        if (intent == null || !intent.hasExtra("data")) {
            C3112bn.m19023b(this, getString(R.string.errorf, getString(R.string.no_data)));
            finish();
            return;
        }
        this.f14186i = new ArrayList();
        this.f14187j = new File(intent.getStringExtra("data"));
        this.f14188k = this.f14187j.getParentFile();
        this.f14189l = m16656c(this.f14188k);
        if (this.f14189l == null || this.f14189l.length == 0) {
            finish();
        }
        Arrays.sort(this.f14189l, new C3108bj(this, this.f14188k));
        this.f14190m = new String[this.f14189l.length];
        int i2 = 0;
        while (true) {
            if (i2 >= this.f14189l.length) {
                i = 0;
                break;
            } else {
                if (this.f14189l[i2].equals(this.f14187j)) {
                    i = i2;
                    break;
                }
                i2++;
            }
        }
        this.f14202y = false;
        String stringBuffer = new StringBuffer().append(C3112bn.m18989a(this.f14187j.lastModified())).append(new StringBuffer().append(", ").append(C3106bh.m18975a(this.f14187j.length(), C3102bd.f18305am)).toString()).toString();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.f14187j.getAbsolutePath(), options);
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (i3 < 0 || i4 < 0) {
            C3112bn.m18999a(this, R.string.image_damage);
            str = stringBuffer;
        } else {
            str = new StringBuffer().append(stringBuffer).append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(" (").append(i3).toString()).append("x").toString()).append(i4).toString()).append(")").toString()).toString();
        }
        this.f14200w = (LinearLayout) findViewById(R.id.viewerLinearLayout1);
        this.f14199v = (LinearLayout) findViewById(R.id.viewerLinearLayout2);
        this.f14197t = (CheckBox) findViewById(R.id.viewerCheckBox1);
        this.f14192o = (TextView) findViewById(R.id.viewerTextView1);
        this.f14192o.setTextSize(2, C3102bd.f18332o);
        this.f14192o.setText(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f14187j.getName()).append(" (").toString()).append(i + 1).toString()).append("/").toString()).append(this.f14189l.length).toString()).append(")").toString());
        this.f14193p = (TextView) findViewById(R.id.viewerTextView2);
        this.f14193p.setTextSize(2, C3102bd.m18927b());
        this.f14193p.setText(str);
        this.f14191n = (C0406b) findViewById(R.id.view_pager);
        this.f14201x = (ProgressBar) findViewById(R.id.viewerProgressBar1);
        this.f14191n.setAdapter(new C2772a(this, this, this.f14189l));
        this.f14191n.setCurrentItem(i);
        this.f14191n.m3323a(new C0406b.f(this) { // from class: ru.maximoff.apktool.PreviewActivity.1

            /* renamed from: a */
            private final PreviewActivity f14203a;

            {
                this.f14203a = this;
            }

            @Override // androidx.p044h.p045a.C0406b.f
            /* renamed from: a */
            public void mo130a(int i5) {
            }

            @Override // androidx.p044h.p045a.C0406b.f
            /* renamed from: a */
            public void mo131a(int i5, float f2, int i6) {
            }

            @Override // androidx.p044h.p045a.C0406b.f
            /* renamed from: b */
            public void mo132b(int i5) {
                File file = this.f14203a.f14189l[i5];
                String str2 = this.f14203a.f14190m[i5];
                String stringBuffer2 = new StringBuffer().append(C3112bn.m18989a(file.lastModified())).append(new StringBuffer().append(", ").append(C3106bh.m18975a(file.length(), C3102bd.f18305am)).toString()).toString();
                if (str2 == null) {
                    C3112bn.m18999a(this.f14203a, R.string.image_damage);
                } else {
                    stringBuffer2 = new StringBuffer().append(stringBuffer2).append(new StringBuffer().append(new StringBuffer().append(" (").append(str2).toString()).append(")").toString()).toString();
                }
                this.f14203a.f14192o.setText(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(file.getName()).append(" (").toString()).append(i5 + 1).toString()).append("/").toString()).append(this.f14203a.f14189l.length).toString()).append(")").toString());
                this.f14203a.f14193p.setText(stringBuffer2);
                this.f14203a.f14197t.setChecked(this.f14203a.m16670b(file));
            }
        });
        this.f14194q = (Button) findViewById(R.id.viewerButton1);
        this.f14194q.setTextSize(2, C3102bd.f18332o);
        this.f14194q.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.PreviewActivity.2

            /* renamed from: a */
            private final PreviewActivity f14204a;

            {
                this.f14204a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C3262u.m19650d(this.f14204a, this.f14204a.f14189l[this.f14204a.f14191n.getCurrentItem()]);
            }
        });
        this.f14196s = (Button) findViewById(R.id.viewerButton3);
        this.f14196s.setTextSize(2, C3102bd.f18332o);
        this.f14196s.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.PreviewActivity.3

            /* renamed from: a */
            private final PreviewActivity f14205a;

            {
                this.f14205a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!this.f14205a.f14186i.isEmpty()) {
                    C3262u.m19604a(this.f14205a, (File[]) this.f14205a.f14186i.toArray(new File[this.f14205a.f14186i.size()]));
                } else {
                    C3262u.m19604a(this.f14205a, new File[]{this.f14205a.f14189l[this.f14205a.f14191n.getCurrentItem()]});
                }
            }
        });
        this.f14197t.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.PreviewActivity.4

            /* renamed from: a */
            private final PreviewActivity f14206a;

            {
                this.f14206a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f14206a.m16669a(this.f14206a.f14189l[this.f14206a.f14191n.getCurrentItem()]);
                if (this.f14206a.f14186i.isEmpty()) {
                    this.f14206a.f14196s.setText(R.string.sharing_file);
                } else {
                    this.f14206a.f14196s.setText(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f14206a.getString(R.string.sharing_file)).append(" (").toString()).append(this.f14206a.f14186i.size()).toString()).append(")").toString());
                }
            }
        });
        int[] iArr = {Math.min(7, C3102bd.m18905a((Context) this, "preview_background", 0))};
        this.f14198u = (LinearLayout) findViewById(R.id.viewerRelativeLayout1);
        new Handler(Looper.getMainLooper()).post(new Runnable(this, iArr) { // from class: ru.maximoff.apktool.PreviewActivity.5

            /* renamed from: a */
            private final PreviewActivity f14207a;

            /* renamed from: b */
            private final int[] f14208b;

            {
                this.f14207a = this;
                this.f14208b = iArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f14207a.m16651a(this.f14207a.f14198u, this.f14208b[0]);
            }
        });
        this.f14195r = (ImageView) findViewById(R.id.viewerButton2);
        this.f14195r.setClickable(true);
        if (C3102bd.f18291a) {
            this.f14195r.setImageResource(R.drawable.ic_sync);
        } else {
            this.f14195r.setImageResource(R.drawable.ic_sync_dark);
        }
        this.f14195r.setOnClickListener(new ViewOnClickListenerC27706(this, iArr));
    }

    /* renamed from: ru.maximoff.apktool.PreviewActivity$6 */
    class ViewOnClickListenerC27706 implements View.OnClickListener {

        /* renamed from: a */
        private final PreviewActivity f14209a;

        /* renamed from: b */
        private final int[] f14210b;

        ViewOnClickListenerC27706(PreviewActivity previewActivity, int[] iArr) {
            this.f14209a = previewActivity;
            this.f14210b = iArr;
        }

        /* renamed from: a */
        static PreviewActivity m16671a(ViewOnClickListenerC27706 viewOnClickListenerC27706) {
            return viewOnClickListenerC27706.f14209a;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f14210b[0] >= 7) {
                this.f14210b[0] = 0;
            } else {
                int[] iArr = this.f14210b;
                iArr[0] = iArr[0] + 1;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable(this, this.f14210b) { // from class: ru.maximoff.apktool.PreviewActivity.6.1

                /* renamed from: a */
                private final ViewOnClickListenerC27706 f14211a;

                /* renamed from: b */
                private final int[] f14212b;

                {
                    this.f14211a = this;
                    this.f14212b = r2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ViewOnClickListenerC27706.m16671a(this.f14211a).m16651a(ViewOnClickListenerC27706.m16671a(this.f14211a).f14198u, this.f14212b[0]);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16651a(LinearLayout linearLayout, int i) {
        switch (i) {
            case 1:
                linearLayout.setBackgroundResource(R.drawable.maximoff_picker_alpha_repeat);
                break;
            case 2:
                linearLayout.setBackgroundColor(-1);
                break;
            case 3:
                linearLayout.setBackgroundColor(Color.GRAY);
                break;
            case 4:
                linearLayout.setBackgroundColor(-16777216);
                break;
            case 5:
                linearLayout.setBackgroundColor(Color.RED);
                break;
            case 6:
                linearLayout.setBackgroundColor(Color.GREEN);
                break;
            case 7:
                linearLayout.setBackgroundColor(-16776961);
                break;
            default:
                linearLayout.setBackgroundColor(0);
                break;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            linearLayout.postInvalidateOnAnimation();
        } else {
            linearLayout.postInvalidateDelayed(16L);
        }
        C3102bd.m18935b((Context) this, "preview_background", i);
    }

    /* renamed from: c */
    private File[] m16656c(File file) {
        return file.listFiles(new FilenameFilter(this) { // from class: ru.maximoff.apktool.PreviewActivity.7

            /* renamed from: a */
            private final PreviewActivity f14213a;

            {
                this.f14213a = this;
            }

            @Override // java.p209io.FilenameFilter
            public boolean accept(File file2, String str) {
                for (String str2 : this.f14213a.f14185h) {
                    if (str.toLowerCase().endsWith(new StringBuffer().append(".").append(str2).toString())) {
                        return true;
                    }
                }
                return false;
            }
        });
    }

    /* renamed from: a */
    public void m16669a(File file) {
        if (m16670b(file)) {
            this.f14186i.remove(file);
        } else {
            this.f14186i.add(file);
        }
    }

    /* renamed from: b */
    public boolean m16670b(File file) {
        return this.f14186i.contains(file);
    }

    /* renamed from: ru.maximoff.apktool.PreviewActivity$a */
    private class C2772a extends AbstractC0405a {

        /* renamed from: a */
        private Context f14214a;

        /* renamed from: b */
        private File[] f14215b;

        /* renamed from: c */
        private Bitmap f14216c;

        /* renamed from: d */
        private final PreviewActivity f14217d;

        /* renamed from: a */
        static PreviewActivity m16672a(C2772a c2772a) {
            return c2772a.f14217d;
        }

        public C2772a(PreviewActivity previewActivity, Context context, File[] fileArr) {
            this.f14217d = previewActivity;
            this.f14214a = context;
            this.f14215b = fileArr;
            this.f14216c = C3067ab.m18388b(context, R.drawable.ic_damage, 0);
        }

        @Override // androidx.p044h.p045a.AbstractC0405a
        /* renamed from: a */
        public int mo3270a() {
            return this.f14215b.length;
        }

        @Override // androidx.p044h.p045a.AbstractC0405a
        /* renamed from: a */
        public boolean mo3281a(View view, Object obj) {
            return view == ((C3300b) obj);
        }

        @Override // androidx.p044h.p045a.AbstractC0405a
        /* renamed from: a */
        public Object mo3274a(ViewGroup viewGroup, int i) {
            File file = this.f14217d.f14189l[i];
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            options.inSampleSize = C3067ab.m18365a(options, 2000);
            options.inJustDecodeBounds = false;
            Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            C3300b c3300b = new C3300b(this.f14214a);
            if (decodeFile == null) {
                c3300b.setZoomable(false);
                Bitmap bitmap = this.f14216c;
                this.f14217d.f14190m[i] = (String) null;
                decodeFile = bitmap;
            } else {
                c3300b.setZoomable(true);
                c3300b.setMaximumScale(10.0f);
                this.f14217d.f14190m[i] = new StringBuffer().append(new StringBuffer().append(i2).append("x").toString()).append(i3).toString();
            }
            c3300b.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            c3300b.setImageBitmap(decodeFile);
            c3300b.setTag(new StringBuffer().append("CustomView-").append(i).toString());
            c3300b.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.PreviewActivity.a.1

                /* renamed from: a */
                private final C2772a f14218a;

                {
                    this.f14218a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C2772a.m16672a(this.f14218a).f14202y) {
                        C2772a.m16672a(this.f14218a).f14200w.setVisibility(0);
                        C2772a.m16672a(this.f14218a).f14199v.setVisibility(0);
                        C2772a.m16672a(this.f14218a).f14202y = false;
                    } else {
                        C2772a.m16672a(this.f14218a).f14200w.setVisibility(8);
                        C2772a.m16672a(this.f14218a).f14199v.setVisibility(8);
                        C2772a.m16672a(this.f14218a).f14202y = true;
                    }
                }
            });
            viewGroup.addView(c3300b, -1, -1);
            if (file.getName().toLowerCase().endsWith(".gif")) {
                try {
                    if (!c3300b.m19831a()) {
                        this.f14217d.f14201x.setVisibility(0);
                        c3300b.m19830a(file, this.f14217d.f14201x);
                    }
                } catch (Exception e2) {
                    this.f14217d.f14201x.setVisibility(8);
                }
            }
            return c3300b;
        }

        @Override // androidx.p044h.p045a.AbstractC0405a
        /* renamed from: a */
        public void mo3280a(ViewGroup viewGroup, int i, Object obj) {
            ((C0406b) viewGroup).removeView((C3300b) obj);
        }
    }

    @Override // androidx.activity.ActivityC0048b, androidx.core.app.ActivityC0234e, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("OPENED_DIRECTORY", this.f14188k.getAbsolutePath());
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String string = bundle.getString("OPENED_DIRECTORY", (String) null);
        if (string != null) {
            this.f14188k = new File(string);
        }
    }

    @Override // androidx.activity.ActivityC0048b, android.app.Activity
    public void onBackPressed() {
        if (!this.f14186i.isEmpty()) {
            String[] strArr = new String[this.f14186i.size()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f14186i.size()) {
                    break;
                }
                strArr[i2] = this.f14186i.get(i2).getAbsolutePath();
                i = i2 + 1;
            }
            setResult(-1, new Intent().putExtra("preview_selection", strArr));
        }
        finish();
    }
}
