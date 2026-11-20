package ru.maximoff.apktool.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.p006pm.PackageInfo;
import android.content.p006pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaCodec;
import android.p008os.AsyncTask;
import android.p008os.Build;
import android.p008os.Handler;
import android.p008os.Looper;
import android.security.keystore.KeyProperties;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.widget.C0173ao;
import com.srizwan.apktool.R;
import java.p209io.BufferedInputStream;
import java.p209io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.fragment.p302b.EnumC2989h;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.p300e.AsyncTaskC2901ac;
import ru.maximoff.apktool.p300e.AsyncTaskC2944o;
import ru.maximoff.apktool.p300e.AsyncTaskC2954y;
import ru.maximoff.apktool.p300e.C2919au;
import ru.maximoff.apktool.util.C3060a;
import ru.maximoff.apktool.util.C3066aa;
import ru.maximoff.apktool.util.C3068ac;
import ru.maximoff.apktool.util.C3078aj;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3106bh;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3246h;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.C3253m;
import ru.maximoff.apktool.util.C3261t;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.C3267z;
import ru.maximoff.apktool.util.p310h.C3247a;
import ru.maximoff.apktool.view.CustomListView;
import ru.p294a.C2604w;

/* loaded from: classes.dex */
public class ZipViewer extends CustomListView {

    /* renamed from: a */
    private String f20818a;

    /* renamed from: b */
    private C3297a f20819b;

    /* renamed from: c */
    private List<C3247a> f20820c;

    /* renamed from: d */
    private Context f20821d;

    /* renamed from: e */
    private DialogInterfaceC0070b f20822e;

    /* renamed from: f */
    private Runnable f20823f;

    /* renamed from: g */
    private C3066aa f20824g;

    /* renamed from: h */
    private C2604w f20825h;

    /* renamed from: i */
    private File f20826i;

    /* renamed from: j */
    private Map<String, Integer> f20827j;

    /* renamed from: k */
    private List<C3247a> f20828k;

    /* renamed from: l */
    private TextView f20829l;

    /* renamed from: m */
    private boolean f20830m;

    /* renamed from: n */
    private boolean f20831n;

    /* renamed from: o */
    private String f20832o;

    /* renamed from: p */
    private String f20833p;

    /* renamed from: q */
    private InterfaceC2995n f20834q;

    /* renamed from: r */
    private boolean f20835r;

    /* renamed from: s */
    private Resources f20836s;

    /* renamed from: t */
    private long f20837t;

    public ZipViewer(Context context) {
        super(context);
        this.f20835r = false;
        this.f20836s = (Resources) null;
        this.f20837t = 0L;
        this.f20821d = context;
    }

    public ZipViewer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20835r = false;
        this.f20836s = (Resources) null;
        this.f20837t = 0L;
        this.f20821d = context;
    }

    public ZipViewer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20835r = false;
        this.f20836s = (Resources) null;
        this.f20837t = 0L;
        this.f20821d = context;
    }

    /* renamed from: a */
    public void m19796a(File file, List<C3247a> list, String str, String str2) {
        setDivider((Drawable) null);
        setDividerHeight(0);
        setFastScrollEnabled(C3102bd.f18314av);
        if (file.getName().toLowerCase().endsWith(".apk")) {
            m19771a(this.f20821d, file);
        }
        this.f20827j = new HashMap();
        this.f20820c = new ArrayList();
        this.f20825h = new C2604w(file);
        this.f20826i = file;
        this.f20828k = list;
        this.f20818a = str;
        this.f20832o = str2;
        this.f20830m = true;
        this.f20831n = false;
        this.f20824g = new C3066aa(this.f20821d);
        this.f20819b = new C3297a(this, new ArrayList());
        setAdapter((ListAdapter) this.f20819b);
    }

    /* renamed from: a */
    private void m19771a(Context context, File file) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(file.getAbsolutePath(), 0);
            packageArchiveInfo.applicationInfo.sourceDir = file.getAbsolutePath();
            packageArchiveInfo.applicationInfo.publicSourceDir = file.getAbsolutePath();
            this.f20836s = packageManager.getResourcesForApplication(packageArchiveInfo.applicationInfo);
        } catch (Error | Exception e2) {
            this.f20836s = (Resources) null;
        }
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (this.f20835r) {
            this.f20835r = false;
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.view.ZipViewer.1

                /* renamed from: a */
                private final ZipViewer f20838a;

                {
                    this.f20838a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.f20838a.f20832o.equals(C3262u.m19572a(this.f20838a.f20826i.getAbsolutePath(), KeyProperties.DIGEST_SHA1))) {
                        return;
                    }
                    this.f20838a.m19795a();
                }
            }, 100L);
        }
    }

    /* renamed from: a */
    public void m19795a() {
        if (this.f20822e != null && this.f20822e.isShowing()) {
            try {
                this.f20822e.cancel();
            } catch (Exception e2) {
            }
        }
        try {
            AsyncTaskC2901ac asyncTaskC2901ac = new AsyncTaskC2901ac(this.f20821d, this.f20826i, this.f20834q);
            asyncTaskC2901ac.m17102a(this.f20818a);
            asyncTaskC2901ac.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        } catch (Exception e3) {
            C3112bn.m18999a(this.f20821d, R.string.error_try_again);
        }
    }

    public void setRefreshable(InterfaceC2995n interfaceC2995n) {
        this.f20834q = interfaceC2995n;
    }

    public void setAccess(boolean z) {
        this.f20830m = z;
    }

    /* renamed from: a */
    public void m19798a(boolean z) {
        this.f20831n = z;
    }

    public boolean getFakeCrc() {
        return this.f20831n;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
    }

    public void setDialog(DialogInterfaceC0070b dialogInterfaceC0070b) {
        this.f20822e = dialogInterfaceC0070b;
    }

    public void setDialogTitle(TextView textView) {
        this.f20829l = textView;
        if (this.f20829l != null) {
            this.f20829l.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.view.ZipViewer.2

                /* renamed from: a */
                private final ZipViewer f20863a;

                {
                    this.f20863a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C3112bn.m19002a(this.f20863a.f20821d, this.f20863a.f20833p);
                }
            });
            String m16164c = this.f20825h.m16164c();
            if (m16164c != null) {
                try {
                    m19780b(m16164c);
                } catch (Exception e2) {
                }
            }
        }
    }

    /* renamed from: b */
    private void m19780b(String str) {
        int m18521a = C3080al.m18521a(this.f20821d, 24.0f);
        int m18521a2 = C3080al.m18521a(this.f20821d, 5.0f);
        LinearLayout linearLayout = (LinearLayout) this.f20829l.getParent();
        ImageView imageView = new ImageView(this.f20821d);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setImageResource(C3102bd.f18291a ? R.drawable.ic_help_light : R.drawable.ic_help_dark);
        imageView.setClickable(true);
        imageView.setFocusable(true);
        imageView.setContentDescription(this.f20821d.getText(R.string.comment));
        imageView.setOnClickListener(new ViewOnClickListenerC32903(this, str));
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.width = m18521a;
        marginLayoutParams.height = m18521a;
        marginLayoutParams.setMargins(m18521a2, 0, 0, 0);
        linearLayout.addView(imageView, marginLayoutParams);
        imageView.requestLayout();
        this.f20829l.setLayoutParams(new LinearLayout.LayoutParams((((linearLayout.getWidth() - linearLayout.getPaddingLeft()) - linearLayout.getPaddingRight()) - m18521a) - m18521a2, -2));
        this.f20829l.requestLayout();
    }

    /* renamed from: ru.maximoff.apktool.view.ZipViewer$3 */
    class ViewOnClickListenerC32903 implements View.OnClickListener {

        /* renamed from: a */
        private final ZipViewer f20877a;

        /* renamed from: b */
        private final String f20878b;

        ViewOnClickListenerC32903(ZipViewer zipViewer, String str) {
            this.f20877a = zipViewer;
            this.f20878b = str;
        }

        /* renamed from: a */
        static ZipViewer m19804a(ViewOnClickListenerC32903 viewOnClickListenerC32903) {
            return viewOnClickListenerC32903.f20877a;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new C3078aj(this.f20877a.f20821d).m18494a(R.string.comment).m18496a(this.f20878b).m18497a(true).m18506d(R.string.close_cur).m18505c(R.string.copy, new Runnable(this, this.f20878b) { // from class: ru.maximoff.apktool.view.ZipViewer.3.1

                /* renamed from: a */
                private final ViewOnClickListenerC32903 f20879a;

                /* renamed from: b */
                private final String f20880b;

                {
                    this.f20879a = this;
                    this.f20880b = r2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C3112bn.m19002a(ViewOnClickListenerC32903.m19804a(this.f20879a).f20821d, this.f20880b);
                }
            }).m18507d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDialogTitle(String str) {
        this.f20833p = str;
        this.f20829l.post(new Runnable(this, str) { // from class: ru.maximoff.apktool.view.ZipViewer.4

            /* renamed from: a */
            private final ZipViewer f20881a;

            /* renamed from: b */
            private final String f20882b;

            {
                this.f20881a = this;
                this.f20882b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f20881a.f20829l.setText(TextUtils.ellipsize(this.f20882b, this.f20881a.f20829l.getPaint(), this.f20881a.f20829l.getWidth(), TextUtils.TruncateAt.START));
            }
        });
    }

    public void setCallback(Runnable runnable) {
        this.f20823f = runnable;
    }

    /* renamed from: b */
    public List<C3247a> m19799b() {
        return this.f20820c;
    }

    public void setPath(String str) {
        this.f20818a = str;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this, str) { // from class: ru.maximoff.apktool.view.ZipViewer.5

            /* renamed from: a */
            private final ZipViewer f20883a;

            /* renamed from: b */
            private final String f20884b;

            {
                this.f20883a = this;
                this.f20884b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f20883a.f20822e != null && this.f20883a.f20822e.isShowing()) {
                    try {
                        if (this.f20883a.f20829l == null) {
                            this.f20883a.f20829l = (TextView) this.f20883a.f20822e.findViewById(R.id.alertTitle);
                        }
                        if (this.f20883a.f20829l == null) {
                            this.f20883a.f20822e.setTitle(new StringBuffer().append(new StringBuffer().append(this.f20883a.f20826i.getName()).append("/").toString()).append(this.f20884b).toString());
                        } else {
                            this.f20883a.setDialogTitle(new StringBuffer().append(new StringBuffer().append(this.f20883a.f20826i.getName()).append("/").toString()).append(this.f20884b).toString());
                        }
                    } catch (Exception e2) {
                    }
                }
            }
        }, 100L);
    }

    public String getPath() {
        return this.f20818a;
    }

    /* renamed from: c */
    public void m19800c() {
        m19797a(this.f20818a);
    }

    /* renamed from: a */
    public void m19797a(String str) {
        int i;
        setScrollPosition(this.f20818a);
        setPath(str);
        this.f20819b.m19811a(m19784c(str));
        if (this.f20827j.isEmpty() || !this.f20827j.containsKey(this.f20818a)) {
            i = 0;
        } else {
            i = this.f20827j.get(this.f20818a).intValue();
            if (i >= this.f20819b.getCount()) {
                i = 0;
            }
        }
        setHandleDataChangedListener(new CustomListView.InterfaceC3268a(this, i) { // from class: ru.maximoff.apktool.view.ZipViewer.6

            /* renamed from: a */
            private final ZipViewer f20885a;

            /* renamed from: b */
            private final int f20886b;

            {
                this.f20885a = this;
                this.f20886b = i;
            }

            @Override // ru.maximoff.apktool.view.CustomListView.InterfaceC3268a
            /* renamed from: a */
            public void mo16527a() {
                this.f20885a.setHandleDataChangedListener((CustomListView.InterfaceC3268a) null);
                if (Build.VERSION.SDK_INT >= 21) {
                    View childAt = this.f20885a.getChildAt(0);
                    this.f20885a.setSelectionFromTop(this.f20886b, childAt == null ? 0 : childAt.getTop() - this.f20885a.getPaddingTop());
                } else {
                    this.f20885a.setSelection(this.f20886b);
                }
            }
        });
        this.f20819b.notifyDataSetChanged();
    }

    private void setScrollPosition(String str) {
        Iterator<Map.Entry<String, Integer>> it = this.f20827j.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (key.length() > str.length() && key.startsWith(str)) {
                it.remove();
            }
        }
        this.f20827j.put(str, new Integer(getFirstVisiblePosition()));
    }

    /* renamed from: d */
    public boolean m19801d() {
        if (this.f20819b.m19817e()) {
            this.f20819b.m19815c();
            this.f20819b.notifyDataSetChanged();
            return true;
        }
        for (C3247a c3247a : this.f20819b.m19813b()) {
            if (c3247a.m19493k()) {
                m19797a(c3247a.m19495m());
                return true;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f20837t > 2000) {
            C3112bn.m18999a(this.f20821d, R.string.click_once_more2);
            this.f20837t = currentTimeMillis;
            return true;
        }
        return false;
    }

    /* renamed from: c */
    private List<C3247a> m19784c(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!str.equals("")) {
            C3247a c3247a = new C3247a("..");
            c3247a.m19477a(str);
            c3247a.m19478a(true);
            c3247a.m19483b(true);
            arrayList.add(0, c3247a);
        }
        for (C3247a c3247a2 : this.f20828k) {
            if (c3247a2.m19495m().equals(str)) {
                if (c3247a2.m19489g()) {
                    arrayList2.add(c3247a2);
                } else {
                    arrayList3.add(c3247a2);
                }
            }
        }
        Comparator<C3247a> comparator = new Comparator<C3247a>(this) { // from class: ru.maximoff.apktool.view.ZipViewer.7

            /* renamed from: a */
            private final ZipViewer f20887a;

            {
                this.f20887a = this;
            }

            @Override // java.util.Comparator
            public int compare(C3247a c3247a3, C3247a c3247a4) {
                return m19805a(c3247a3, c3247a4);
            }

            /* renamed from: a */
            public int m19805a(C3247a c3247a3, C3247a c3247a4) {
                return EnumC2989h.m17906a(c3247a3.m19494l().toLowerCase(), c3247a4.m19494l().toLowerCase());
            }
        };
        Collections.sort(arrayList2, comparator);
        Collections.sort(arrayList3, comparator);
        arrayList.addAll(arrayList2);
        arrayList.addAll(arrayList3);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m19772a(List<C3247a> list, String str) {
        for (C3247a c3247a : this.f20828k) {
            if (c3247a.m19491i().equals(str)) {
                if (list.contains(c3247a)) {
                    list.remove(c3247a);
                } else {
                    list.add(c3247a);
                }
            } else if (c3247a.m19495m().equals(str)) {
                if (c3247a.m19489g()) {
                    m19772a(list, c3247a.m19491i());
                } else if (list.contains(c3247a)) {
                    list.remove(c3247a);
                } else {
                    list.add(c3247a);
                }
            }
        }
    }

    public List<String> getSelection() {
        ArrayList arrayList = new ArrayList();
        Iterator<C3247a> it = this.f20819b.m19809a().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m19492j());
        }
        return arrayList;
    }

    /* renamed from: e */
    public void m19802e() {
        this.f20819b.m19815c();
        this.f20819b.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m19773a(C3247a c3247a) {
        int i;
        View inflate = LayoutInflater.from(this.f20821d).inflate(R.layout.zip_prop, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.zippropLinearLayout1);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.zippropLinearLayout2);
        LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.zippropLinearLayout3);
        LinearLayout linearLayout4 = (LinearLayout) inflate.findViewById(R.id.zippropLinearLayout4);
        LinearLayout linearLayout5 = (LinearLayout) inflate.findViewById(R.id.zippropLinearLayout5);
        TextView textView = (TextView) inflate.findViewById(R.id.zippropTextView1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.zippropTextView2);
        TextView textView3 = (TextView) inflate.findViewById(R.id.zippropTextView3);
        TextView textView4 = (TextView) inflate.findViewById(R.id.zippropTextView4);
        EditText editText = (EditText) inflate.findViewById(R.id.zippropEditText0);
        TextView textView5 = (TextView) inflate.findViewById(R.id.zippropTextView6);
        EditText editText2 = (EditText) inflate.findViewById(R.id.zippropEditText1);
        EditText editText3 = (EditText) inflate.findViewById(R.id.zippropEditText2);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.copyText0);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.copyText1);
        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.copyText2);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.zippropCheckBox1);
        C3112bn.m19005a((ViewGroup) inflate, C3102bd.f18332o);
        String m18989a = C3112bn.m18989a(c3247a.m19484c());
        if (C3102bd.f18291a) {
            i = R.drawable.ic_copy;
        } else {
            i = R.drawable.ic_copy_dark;
        }
        imageView.setImageResource(i);
        imageView2.setImageResource(i);
        imageView3.setImageResource(i);
        View.OnClickListener onClickListener = new View.OnClickListener(this, c3247a, m18989a) { // from class: ru.maximoff.apktool.view.ZipViewer.8

            /* renamed from: a */
            private final ZipViewer f20888a;

            /* renamed from: b */
            private final C3247a f20889b;

            /* renamed from: c */
            private final String f20890c;

            {
                this.f20888a = this;
                this.f20889b = c3247a;
                this.f20890c = m18989a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                switch (view.getId()) {
                    case R.id.copyText0 /* 2131690133 */:
                        str = Long.toHexString(this.f20889b.m19486d());
                        break;
                    case R.id.copyText1 /* 2131690136 */:
                        str = this.f20889b.m19491i();
                        break;
                    case R.id.copyText2 /* 2131690140 */:
                        str = this.f20890c;
                        break;
                    default:
                        return;
                }
                C3112bn.m19002a(this.f20888a.f20821d, str);
            }
        };
        imageView.setOnLongClickListener(new View.OnLongClickListener(this, c3247a) { // from class: ru.maximoff.apktool.view.ZipViewer.9

            /* renamed from: a */
            private final ZipViewer f20891a;

            /* renamed from: b */
            private final C3247a f20892b;

            {
                this.f20891a = this;
                this.f20892b = c3247a;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                C3112bn.m19002a(this.f20891a.f20821d, String.valueOf(this.f20892b.m19486d()));
                return true;
            }
        });
        imageView.setOnClickListener(onClickListener);
        imageView2.setOnClickListener(onClickListener);
        imageView3.setOnClickListener(onClickListener);
        String stringBuffer = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f20821d.getString(R.string.modified)).append(" (").toString()).append(C3102bd.f18266B).toString()).append(")").toString();
        textView5.setText(stringBuffer);
        if (this.f20830m) {
            C3112bn.m19009a(textView5, stringBuffer);
            textView5.setOnClickListener(new View.OnClickListener(this, editText3, m18989a) { // from class: ru.maximoff.apktool.view.ZipViewer.10

                /* renamed from: a */
                private final ZipViewer f20839a;

                /* renamed from: b */
                private final EditText f20840b;

                /* renamed from: c */
                private final String f20841c;

                {
                    this.f20839a = this;
                    this.f20840b = editText3;
                    this.f20841c = m18989a;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f20840b.setText(this.f20841c);
                }
            });
            textView5.setOnLongClickListener(new View.OnLongClickListener(this, editText3) { // from class: ru.maximoff.apktool.view.ZipViewer.11

                /* renamed from: a */
                private final ZipViewer f20842a;

                /* renamed from: b */
                private final EditText f20843b;

                {
                    this.f20842a = this;
                    this.f20843b = editText3;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    this.f20843b.setText(C3112bn.m19032g(C3102bd.f18266B));
                    return true;
                }
            });
        }
        textView.setText(c3247a.m19494l());
        textView2.setText(new StringBuffer().append("/").append(c3247a.m19495m()).toString());
        textView.setTextSize(2, C3102bd.f18332o - 2);
        textView2.setTextSize(2, C3102bd.f18332o - 2);
        textView3.setTextSize(2, C3102bd.f18332o - 2);
        textView4.setTextSize(2, C3102bd.f18332o - 2);
        if (c3247a.m19489g()) {
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(8);
            linearLayout3.setVisibility(8);
            linearLayout4.setVisibility(8);
            linearLayout5.setVisibility(8);
            checkBox.setVisibility(8);
        } else {
            editText2.setText(c3247a.m19491i());
            editText2.setHint(c3247a.m19491i());
            textView4.setText(String.valueOf(c3247a.m19472a()));
            textView3.setText(String.valueOf(c3247a.m19479b()));
            editText.setText(Long.toHexString(c3247a.m19486d()));
            editText.setHint(Long.toHexString(c3247a.m19486d()));
            checkBox.setChecked(c3247a.m19487e() == 8);
            checkBox.setEnabled(this.f20830m);
            editText3.setText(m18989a);
            editText3.setHint(m18989a);
            if (!this.f20830m) {
                InputFilter[] inputFilterArr = {new InputFilter(this) { // from class: ru.maximoff.apktool.view.ZipViewer.12

                    /* renamed from: a */
                    private final ZipViewer f20844a;

                    {
                        this.f20844a = this;
                    }

                    @Override // android.text.InputFilter
                    public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
                        return spanned.subSequence(i4, i5);
                    }
                }};
                editText.setFilters(inputFilterArr);
                editText2.setFilters(inputFilterArr);
                editText3.setFilters(inputFilterArr);
            }
        }
        View.OnClickListener onClickListener2 = new View.OnClickListener(this) { // from class: ru.maximoff.apktool.view.ZipViewer.13

            /* renamed from: a */
            private final ZipViewer f20845a;

            {
                this.f20845a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C3112bn.m19002a(this.f20845a.f20821d, ((TextView) view).getText().toString());
            }
        };
        textView.setOnClickListener(onClickListener2);
        textView2.setOnClickListener(onClickListener2);
        textView3.setOnClickListener(onClickListener2);
        textView4.setOnClickListener(onClickListener2);
        textView.setOnLongClickListener(new View.OnLongClickListener(this, c3247a) { // from class: ru.maximoff.apktool.view.ZipViewer.14

            /* renamed from: a */
            private final ZipViewer f20846a;

            /* renamed from: b */
            private final C3247a f20847b;

            {
                this.f20846a = this;
                this.f20847b = c3247a;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                C3112bn.m19002a(this.f20846a.f20821d, this.f20847b.m19491i());
                return true;
            }
        });
        textView3.setOnLongClickListener(new View.OnLongClickListener(this, c3247a) { // from class: ru.maximoff.apktool.view.ZipViewer.15

            /* renamed from: a */
            private final ZipViewer f20848a;

            /* renamed from: b */
            private final C3247a f20849b;

            {
                this.f20848a = this;
                this.f20849b = c3247a;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                C3112bn.m19002a(this.f20848a.f20821d, C3106bh.m18975a(this.f20849b.m19479b(), C3102bd.f18305am));
                return true;
            }
        });
        textView4.setOnLongClickListener(new View.OnLongClickListener(this, c3247a) { // from class: ru.maximoff.apktool.view.ZipViewer.16

            /* renamed from: a */
            private final ZipViewer f20850a;

            /* renamed from: b */
            private final C3247a f20851b;

            {
                this.f20850a = this;
                this.f20851b = c3247a;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                C3112bn.m19002a(this.f20850a.f20821d, C3106bh.m18975a(this.f20851b.m19472a(), C3102bd.f18305am));
                return true;
            }
        });
        DialogInterfaceC0070b.a m420a = new DialogInterfaceC0070b.a(this.f20821d).m418a(R.string.properties).m435b(inflate).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null);
        if (!c3247a.m19489g() && this.f20830m) {
            m420a.m440c(R.string.save, new DialogInterface.OnClickListener(this, editText2, c3247a, editText3, editText, checkBox) { // from class: ru.maximoff.apktool.view.ZipViewer.17

                /* renamed from: a */
                private final ZipViewer f20852a;

                /* renamed from: b */
                private final EditText f20853b;

                /* renamed from: c */
                private final C3247a f20854c;

                /* renamed from: d */
                private final EditText f20855d;

                /* renamed from: e */
                private final EditText f20856e;

                /* renamed from: f */
                private final CheckBox f20857f;

                {
                    this.f20852a = this;
                    this.f20853b = editText2;
                    this.f20854c = c3247a;
                    this.f20855d = editText3;
                    this.f20856e = editText;
                    this.f20857f = checkBox;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    long j;
                    long parseLong;
                    try {
                        String editable = this.f20853b.getText().toString();
                        if (!editable.equals(this.f20854c.m19491i())) {
                            for (int i3 = 0; i3 < this.f20852a.f20828k.size(); i3++) {
                                if (editable.equals(((C3247a) this.f20852a.f20828k.get(i3)).m19492j())) {
                                    C3112bn.m18999a(this.f20852a.f20821d, R.string.string_exists);
                                    return;
                                }
                            }
                        }
                        String trim = this.f20855d.getText().toString().trim();
                        String trim2 = this.f20856e.getText().toString().trim();
                        try {
                            if (trim2.matches("^[-0-9]+$")) {
                                parseLong = Long.parseLong(trim2, 10);
                            } else {
                                parseLong = trim2.matches("^[0-9a-fA-F]+$") ? Long.parseLong(trim2, 16) : 0L;
                            }
                            j = parseLong;
                        } catch (Exception e2) {
                            j = 0;
                        }
                        int i4 = this.f20857f.isChecked() ? 8 : 0;
                        if (!this.f20854c.m19491i().equals(editable) || !C3112bn.m18989a(this.f20854c.m19484c()).equalsIgnoreCase(trim) || ((j > 0 && j != this.f20854c.m19486d()) || i4 != this.f20854c.m19487e())) {
                            Date parse = new SimpleDateFormat(C3102bd.f18266B).parse(trim);
                            C3247a c3247a2 = new C3247a(this.f20854c.m19492j());
                            c3247a2.m19482b(editable);
                            c3247a2.m19478a(false);
                            c3247a2.m19485c(this.f20854c.m19490h());
                            c3247a2.m19473a(i4);
                            c3247a2.m19475a(this.f20854c.m19472a(), this.f20854c.m19479b());
                            if (j > 0 && j != this.f20854c.m19486d()) {
                                c3247a2.m19480b(j);
                                this.f20852a.m19798a(true);
                            } else {
                                c3247a2.m19480b(this.f20854c.m19486d());
                            }
                            c3247a2.m19474a(parse.getTime());
                            int m19768a = this.f20852a.m19768a((List<C3247a>) this.f20852a.f20820c, c3247a2);
                            if (m19768a >= 0) {
                                this.f20852a.f20820c.set(m19768a, c3247a2);
                            } else {
                                this.f20852a.f20820c.add(c3247a2);
                            }
                            C3112bn.m18999a(this.f20852a.f20821d, R.string.success);
                        }
                    } catch (Exception e3) {
                        C3112bn.m18999a(this.f20852a.f20821d, R.string.error);
                    }
                    this.f20852a.m19800c();
                    dialogInterface.cancel();
                }
            });
            if (this.f20820c.contains(c3247a)) {
                m420a.m434b(R.string.search_reset, new DialogInterface.OnClickListener(this, c3247a) { // from class: ru.maximoff.apktool.view.ZipViewer.18

                    /* renamed from: a */
                    private final ZipViewer f20858a;

                    /* renamed from: b */
                    private final C3247a f20859b;

                    {
                        this.f20858a = this;
                        this.f20859b = c3247a;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        int m19768a = this.f20858a.m19768a((List<C3247a>) this.f20858a.f20820c, this.f20859b);
                        if (m19768a >= 0) {
                            this.f20858a.f20820c.remove(m19768a);
                            C3112bn.m18999a(this.f20858a.f20821d, R.string.success);
                        } else {
                            C3112bn.m18999a(this.f20858a.f20821d, R.string.error);
                        }
                        this.f20858a.m19800c();
                        dialogInterface.cancel();
                    }
                });
            }
        }
        m420a.m438b().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m19781b(C3247a c3247a) {
        C3261t c3261t = new C3261t(this.f20821d);
        Runnable runnable = new Runnable(this, c3261t, c3247a) { // from class: ru.maximoff.apktool.view.ZipViewer.19

            /* renamed from: a */
            private final ZipViewer f20860a;

            /* renamed from: b */
            private final C3261t f20861b;

            /* renamed from: c */
            private final C3247a f20862c;

            {
                this.f20860a = this;
                this.f20861b = c3261t;
                this.f20862c = c3247a;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    File file = new File(this.f20861b.getPath());
                    C3247a c3247a2 = new C3247a(this.f20862c.m19492j());
                    c3247a2.m19478a(false);
                    c3247a2.m19485c(this.f20862c.m19490h());
                    c3247a2.m19473a(this.f20862c.m19487e());
                    c3247a2.m19475a(file.length(), file.length());
                    c3247a2.m19480b(this.f20862c.m19486d());
                    c3247a2.m19474a(this.f20862c.m19484c());
                    c3247a2.m19476a(file);
                    int m19768a = this.f20860a.m19768a((List<C3247a>) this.f20860a.f20820c, c3247a2);
                    if (m19768a >= 0) {
                        this.f20860a.f20820c.set(m19768a, c3247a2);
                    } else {
                        this.f20860a.f20820c.add(c3247a2);
                    }
                } catch (Exception e2) {
                    C3112bn.m18999a(this.f20860a.f20821d, R.string.error);
                }
                this.f20860a.m19800c();
            }
        };
        c3261t.m19545a("_zv");
        c3261t.setCallback(runnable);
        c3261t.m19547b();
        c3261t.m19550e();
        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(this.f20821d);
        aVar.m427a(c3261t.m19548c());
        aVar.m435b(c3261t);
        aVar.m420a(R.string.cancel, (DialogInterface.OnClickListener) null);
        aVar.m437b("/...", (DialogInterface.OnClickListener) null);
        aVar.m429a(false);
        aVar.m422a(new DialogInterface.OnKeyListener(this, c3261t) { // from class: ru.maximoff.apktool.view.ZipViewer.20

            /* renamed from: a */
            private final ZipViewer f20864a;

            /* renamed from: b */
            private final C3261t f20865b;

            {
                this.f20864a = this;
                this.f20865b = c3261t;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                    return false;
                }
                boolean m19551f = this.f20865b.m19551f();
                if (!m19551f) {
                    dialogInterface.dismiss();
                    return m19551f;
                }
                return m19551f;
            }
        });
        DialogInterfaceC0070b m438b = aVar.m438b();
        m438b.setOnShowListener(new DialogInterfaceOnShowListenerC328921(this, m438b, c3261t));
        c3261t.setDialog(m438b);
        m438b.show();
    }

    /* renamed from: ru.maximoff.apktool.view.ZipViewer$21 */
    class DialogInterfaceOnShowListenerC328921 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final ZipViewer f20866a;

        /* renamed from: b */
        private final DialogInterfaceC0070b f20867b;

        /* renamed from: c */
        private final C3261t f20868c;

        DialogInterfaceOnShowListenerC328921(ZipViewer zipViewer, DialogInterfaceC0070b dialogInterfaceC0070b, C3261t c3261t) {
            this.f20866a = zipViewer;
            this.f20867b = dialogInterfaceC0070b;
            this.f20868c = c3261t;
        }

        /* renamed from: a */
        static ZipViewer m19803a(DialogInterfaceOnShowListenerC328921 dialogInterfaceOnShowListenerC328921) {
            return dialogInterfaceOnShowListenerC328921.f20866a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            Button m414a = this.f20867b.m414a(-3);
            m414a.setOnClickListener(new View.OnClickListener(this, this.f20868c) { // from class: ru.maximoff.apktool.view.ZipViewer.21.1

                /* renamed from: a */
                private final DialogInterfaceOnShowListenerC328921 f20869a;

                /* renamed from: b */
                private final C3261t f20870b;

                {
                    this.f20869a = this;
                    this.f20870b = r2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i;
                    String[] m19640b = C3262u.m19640b(DialogInterfaceOnShowListenerC328921.m19803a(this.f20869a).f20821d);
                    if (m19640b != null) {
                        C0173ao c0173ao = new C0173ao(DialogInterfaceOnShowListenerC328921.m19803a(this.f20869a).f20821d, view);
                        if (C3102bd.m18910a(DialogInterfaceOnShowListenerC328921.m19803a(this.f20869a).f20821d, "menu_position", "1").equals("0")) {
                            i = 3;
                        } else {
                            i = 5;
                        }
                        c0173ao.m1340a(i);
                        for (int i2 = 0; i2 < m19640b.length; i2++) {
                            c0173ao.m1339a().add(0, i2 + MediaCodec.CodecException.ERROR_INSUFFICIENT_RESOURCE, 0, m19640b[i2]).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f20870b) { // from class: ru.maximoff.apktool.view.ZipViewer.21.1.1

                                /* renamed from: a */
                                private final AnonymousClass1 f20871a;

                                /* renamed from: b */
                                private final C3261t f20872b;

                                {
                                    this.f20871a = this;
                                    this.f20872b = r2;
                                }

                                @Override // android.view.MenuItem.OnMenuItemClickListener
                                public boolean onMenuItemClick(MenuItem menuItem) {
                                    this.f20872b.m19544a(new File(menuItem.getTitle().toString()));
                                    return true;
                                }
                            });
                        }
                        c0173ao.m1344c();
                    }
                }
            });
            m414a.setOnLongClickListener(new View.OnLongClickListener(this, this.f20868c) { // from class: ru.maximoff.apktool.view.ZipViewer.21.2

                /* renamed from: a */
                private final DialogInterfaceOnShowListenerC328921 f20873a;

                /* renamed from: b */
                private final C3261t f20874b;

                {
                    this.f20873a = this;
                    this.f20874b = r2;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    int i;
                    List<String> m19205b = this.f20874b.m19549d().m19205b();
                    if (m19205b.isEmpty()) {
                        return false;
                    }
                    C0173ao c0173ao = new C0173ao(DialogInterfaceOnShowListenerC328921.m19803a(this.f20873a).f20821d, view);
                    if (C3102bd.m18910a(DialogInterfaceOnShowListenerC328921.m19803a(this.f20873a).f20821d, "menu_position", "1").equals("0")) {
                        i = 3;
                    } else {
                        i = 5;
                    }
                    c0173ao.m1340a(i);
                    Iterator<String> it = m19205b.iterator();
                    while (it.hasNext()) {
                        c0173ao.m1339a().add(0, 1300, 0, it.next()).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f20874b) { // from class: ru.maximoff.apktool.view.ZipViewer.21.2.1

                            /* renamed from: a */
                            private final AnonymousClass2 f20875a;

                            /* renamed from: b */
                            private final C3261t f20876b;

                            {
                                this.f20875a = this;
                                this.f20876b = r2;
                            }

                            @Override // android.view.MenuItem.OnMenuItemClickListener
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                this.f20876b.m19544a(new File(menuItem.getTitle().toString()));
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m19768a(List<C3247a> list, C3247a c3247a) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if (c3247a.m19492j().equals(list.get(i2).m19492j())) {
                    return i2;
                }
                i = i2 + 1;
            } else {
                return -1;
            }
        }
    }

    /* renamed from: ru.maximoff.apktool.view.ZipViewer$a */
    private class C3297a extends BaseAdapter {

        /* renamed from: a */
        private List<C3247a> f20893a;

        /* renamed from: b */
        private List<C3247a> f20894b;

        /* renamed from: c */
        private int f20895c;

        /* renamed from: d */
        private final ZipViewer f20896d;

        /* renamed from: a */
        static ZipViewer m19806a(C3297a c3297a) {
            return c3297a.f20896d;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return m19810a(i);
        }

        public C3297a(ZipViewer zipViewer, List<C3247a> list) {
            this.f20896d = zipViewer;
            this.f20895c = C3246h.m19470a(this.f20896d.f20821d, C3102bd.f18291a ? R.color.colorFolderLight : R.color.colorFolderDark);
            this.f20893a = new ArrayList();
            this.f20893a.clear();
            this.f20893a.addAll(list);
            this.f20894b = new ArrayList();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f20893a != null) {
                return this.f20893a.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        /* renamed from: a */
        public C3247a m19810a(int i) {
            return this.f20893a != null ? this.f20893a.get(i) : (C3247a) null;
        }

        /* renamed from: a */
        public void m19812a(C3247a c3247a) {
            if (c3247a.m19489g()) {
                this.f20896d.m19772a(this.f20894b, c3247a.m19491i());
            } else if (this.f20894b.contains(c3247a)) {
                this.f20894b.remove(c3247a);
            } else {
                this.f20894b.add(c3247a);
            }
            m19816d();
            notifyDataSetChanged();
        }

        /* renamed from: b */
        public void m19814b(C3247a c3247a) {
            this.f20896d.m19772a(this.f20894b, c3247a.m19495m());
            m19816d();
            notifyDataSetChanged();
        }

        /* renamed from: a */
        public List<C3247a> m19809a() {
            return this.f20894b;
        }

        /* renamed from: b */
        public List<C3247a> m19813b() {
            return this.f20893a;
        }

        /* renamed from: c */
        public void m19815c() {
            this.f20894b.clear();
            m19816d();
        }

        /* renamed from: a */
        public void m19811a(List<C3247a> list) {
            this.f20893a.clear();
            this.f20893a.addAll(list);
            m19815c();
        }

        /* renamed from: d */
        public void m19816d() {
            Button m414a = this.f20896d.f20822e.m414a(-1);
            Button m414a2 = this.f20896d.f20822e.m414a(-3);
            boolean z = !this.f20894b.isEmpty() && this.f20896d.f20830m;
            m414a2.setEnabled(z);
            if (!this.f20896d.f20820c.isEmpty() && this.f20896d.f20830m) {
                m414a.setEnabled(true);
                m414a.setText(R.string.save);
            } else {
                m414a.setEnabled(z);
                m414a.setText(R.string.extract);
            }
        }

        /* renamed from: e */
        public boolean m19817e() {
            return !this.f20894b.isEmpty();
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            C2919au.m17346e();
            super.notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C3298b c3298b;
            C3247a c3247a;
            if (view == null) {
                view = ((LayoutInflater) this.f20896d.f20821d.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.files_entry, (ViewGroup) null);
                c3298b = new C3298b(this.f20896d);
                c3298b.f20930b = (ImageView) view.findViewById(R.id.icon);
                c3298b.f20931c = (TextView) view.findViewById(R.id.name);
                c3298b.f20932d = (TextView) view.findViewById(R.id.details);
                view.setTag(c3298b);
            } else {
                c3298b = (C3298b) view.getTag();
            }
            c3298b.f20929a = i;
            int m19768a = this.f20896d.m19768a((List<C3247a>) this.f20896d.f20820c, this.f20893a.get(i));
            if (m19768a >= 0) {
                c3247a = (C3247a) this.f20896d.f20820c.get(m19768a);
            } else {
                c3247a = this.f20893a.get(i);
            }
            if (c3247a != null) {
                if (this.f20894b.contains(c3247a)) {
                    view.setBackgroundColor(C3246h.m19470a(this.f20896d.f20821d, R.color.tvery_light_blue));
                } else if (this.f20896d.f20820c.contains(c3247a)) {
                    view.setBackgroundColor(C3246h.m19470a(this.f20896d.f20821d, C3102bd.f18291a ? R.color.tvery_light_grey2 : R.color.tvery_light_grey));
                } else {
                    view.setBackgroundColor(0);
                }
                if (c3247a.m19493k()) {
                    c3298b.f20932d.setVisibility(8);
                } else {
                    String stringBuffer = new StringBuffer().append(new StringBuffer().append(C3112bn.m18989a(c3247a.m19484c())).append(new StringBuffer().append(", ").append(C3106bh.m18975a(c3247a.m19472a(), C3102bd.f18305am)).toString()).toString()).append(new StringBuffer().append(new StringBuffer().append(" (").append(C3106bh.m18975a(c3247a.m19479b(), C3102bd.f18305am)).toString()).append(")").toString()).toString();
                    c3298b.f20932d.setVisibility(0);
                    c3298b.f20932d.setTextSize(2, C3102bd.m18927b());
                    c3298b.f20932d.setText(stringBuffer);
                }
                c3298b.f20931c.setText(c3247a.m19494l());
                c3298b.f20931c.setTextSize(2, C3102bd.f18332o);
                c3298b.f20930b.setTag(new StringBuffer().append(new StringBuffer().append(this.f20896d.f20826i.getAbsolutePath()).append("|").toString()).append(c3247a.m19491i()).toString());
                if (c3247a.m19489g()) {
                    c3298b.f20930b.setImageBitmap(C3267z.m19713a().m19714a(this.f20896d.f20824g, this.f20895c, R.drawable.ic_folder));
                } else {
                    String lowerCase = c3247a.m19494l().toLowerCase();
                    int[] m18400a = C3068ac.m18400a(this.f20896d.f20821d, lowerCase);
                    c3298b.f20930b.setImageBitmap(C3267z.m19713a().m19714a(this.f20896d.f20824g, m18400a[1], m18400a[0]));
                    if (c3247a.m19488f() != null || m18400a[0] == R.drawable.ic_image || lowerCase.endsWith(".xml") || lowerCase.endsWith(".svg")) {
                        AsyncTaskC2954y asyncTaskC2954y = new AsyncTaskC2954y(this.f20896d.f20821d, c3298b.f20930b, this.f20896d.f20834q);
                        if (c3247a.m19488f() != null) {
                            asyncTaskC2954y.m17595a("");
                            asyncTaskC2954y.m17596a((C2604w) null, false, false, (Resources) null);
                            C2919au.m17340a(c3247a.m19488f(), new C2919au.a(this, asyncTaskC2954y) { // from class: ru.maximoff.apktool.view.ZipViewer.a.1

                                /* renamed from: a */
                                private final C3297a f20897a;

                                /* renamed from: b */
                                private final AsyncTaskC2954y f20898b;

                                {
                                    this.f20897a = this;
                                    this.f20898b = asyncTaskC2954y;
                                }

                                @Override // ru.maximoff.apktool.p300e.C2919au.a
                                /* renamed from: a */
                                public AsyncTaskC2954y mo17349a() {
                                    return this.f20898b;
                                }
                            });
                        } else {
                            asyncTaskC2954y.m17595a(c3247a.m19491i());
                            asyncTaskC2954y.m17596a(this.f20896d.f20825h, lowerCase.endsWith(".xml"), lowerCase.endsWith(".svg"), this.f20896d.f20836s);
                            C2919au.m17340a(this.f20896d.f20826i, new C2919au.a(this, asyncTaskC2954y) { // from class: ru.maximoff.apktool.view.ZipViewer.a.2

                                /* renamed from: a */
                                private final C3297a f20912a;

                                /* renamed from: b */
                                private final AsyncTaskC2954y f20913b;

                                {
                                    this.f20912a = this;
                                    this.f20913b = asyncTaskC2954y;
                                }

                                @Override // ru.maximoff.apktool.p300e.C2919au.a
                                /* renamed from: a */
                                public AsyncTaskC2954y mo17349a() {
                                    return this.f20913b;
                                }
                            });
                        }
                    }
                }
                view.setOnClickListener(new View.OnClickListener(this, c3247a) { // from class: ru.maximoff.apktool.view.ZipViewer.a.3

                    /* renamed from: a */
                    private final C3297a f20914a;

                    /* renamed from: b */
                    private final C3247a f20915b;

                    {
                        this.f20914a = this;
                        this.f20915b = c3247a;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (this.f20915b.m19493k()) {
                            C3297a.m19806a(this.f20914a).m19797a(this.f20915b.m19495m());
                            return;
                        }
                        if (this.f20914a.m19817e() && C3297a.m19806a(this.f20914a).f20830m) {
                            this.f20914a.m19812a(this.f20915b);
                        } else if (this.f20915b.m19489g()) {
                            C3297a.m19806a(this.f20914a).m19797a(this.f20915b.m19491i());
                        } else {
                            this.f20914a.m19807a(view2, this.f20915b);
                        }
                    }
                });
                view.setOnLongClickListener(new View.OnLongClickListener(this, c3247a) { // from class: ru.maximoff.apktool.view.ZipViewer.a.4

                    /* renamed from: a */
                    private final C3297a f20916a;

                    /* renamed from: b */
                    private final C3247a f20917b;

                    {
                        this.f20916a = this;
                        this.f20917b = c3247a;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view2) {
                        if (this.f20917b.m19493k()) {
                            return false;
                        }
                        this.f20916a.m19807a(view2, this.f20917b);
                        return true;
                    }
                });
                c3298b.f20930b.setOnClickListener(new View.OnClickListener(this, c3247a) { // from class: ru.maximoff.apktool.view.ZipViewer.a.5

                    /* renamed from: a */
                    private final C3297a f20918a;

                    /* renamed from: b */
                    private final C3247a f20919b;

                    {
                        this.f20918a = this;
                        this.f20919b = c3247a;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!C3297a.m19806a(this.f20918a).f20830m || this.f20919b.m19493k()) {
                            return;
                        }
                        this.f20918a.m19812a(this.f20919b);
                    }
                });
            }
            return view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m19807a(View view, C3247a c3247a) {
            int i;
            MainActivity m16615o = MainActivity.m16615o();
            C0173ao c0173ao = new C0173ao(this.f20896d.f20821d, view);
            if (C3102bd.m18910a(this.f20896d.f20821d, "menu_position", "1").equals("0")) {
                i = 3;
            } else {
                i = 5;
            }
            c0173ao.m1340a(i);
            int i2 = 1009;
            if (m19817e()) {
                c0173ao.m1339a().add(0, 1009, 0, R.string.mselect).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, c3247a) { // from class: ru.maximoff.apktool.view.ZipViewer.a.6

                    /* renamed from: a */
                    private final C3297a f20920a;

                    /* renamed from: b */
                    private final C3247a f20921b;

                    {
                        this.f20920a = this;
                        this.f20921b = c3247a;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f20920a.m19812a(this.f20921b);
                        return true;
                    }
                });
                c0173ao.m1339a().add(0, PointerIcon.TYPE_ALIAS, 0, R.string.mselect_inv).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, c3247a) { // from class: ru.maximoff.apktool.view.ZipViewer.a.7

                    /* renamed from: a */
                    private final C3297a f20922a;

                    /* renamed from: b */
                    private final C3247a f20923b;

                    {
                        this.f20922a = this;
                        this.f20923b = c3247a;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f20922a.m19814b(this.f20923b);
                        return true;
                    }
                });
                c0173ao.m1344c();
                return;
            }
            if (!c3247a.m19489g() && c3247a.m19494l().toLowerCase().endsWith(".dex")) {
                c0173ao.m1339a().add(0, 1009, 0, R.string.minfo).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, c3247a) { // from class: ru.maximoff.apktool.view.ZipViewer.a.8

                    /* renamed from: a */
                    private final C3297a f20924a;

                    /* renamed from: b */
                    private final C3247a f20925b;

                    {
                        this.f20924a = this;
                        this.f20925b = c3247a;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        try {
                            C3253m m19574a = C3262u.m19574a(new BufferedInputStream(C3297a.m19806a(this.f20924a).f20825h.m16160a(C3297a.m19806a(this.f20924a).f20825h.m16162a(this.f20925b.m19491i())), C3249i.m19500a()));
                            if (m19574a != null) {
                                m19574a.f19662h = this.f20925b.m19479b();
                                AsyncTaskC2944o asyncTaskC2944o = new AsyncTaskC2944o(C3297a.m19806a(this.f20924a).f20821d, (C3060a) null);
                                asyncTaskC2944o.m17521a(this.f20925b.m19494l(), m19574a);
                                asyncTaskC2944o.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (File) null);
                            } else {
                                C3112bn.m18999a(C3297a.m19806a(this.f20924a).f20821d, R.string.error);
                            }
                        } catch (Exception e2) {
                            C3112bn.m18999a(C3297a.m19806a(this.f20924a).f20821d, R.string.error);
                        }
                        return true;
                    }
                });
                i2 = 1010;
            } else if (!c3247a.m19489g() && c3247a.m19494l().toLowerCase().endsWith(".so")) {
                c0173ao.m1339a().add(0, 1009, 0, R.string.soeditor).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, m16615o, c3247a) { // from class: ru.maximoff.apktool.view.ZipViewer.a.9

                    /* renamed from: a */
                    private final C3297a f20926a;

                    /* renamed from: b */
                    private final MainActivity f20927b;

                    /* renamed from: c */
                    private final C3247a f20928c;

                    {
                        this.f20926a = this;
                        this.f20927b = m16615o;
                        this.f20928c = c3247a;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        try {
                            Intent intent = new Intent(this.f20927b, Class.forName("ru.maximoff.apktool.SoEditor"));
                            intent.putExtra("data", this.f20928c.m19491i());
                            intent.putExtra("apk_path", C3297a.m19806a(this.f20926a).f20826i.getAbsolutePath());
                            this.f20927b.startActivityForResult(intent, 0);
                            C3297a.m19806a(this.f20926a).f20835r = true;
                            return true;
                        } catch (ClassNotFoundException e2) {
                            throw new NoClassDefFoundError(e2.getMessage());
                        }
                    }
                });
                i2 = 1010;
            }
            if (this.f20896d.f20830m) {
                int i3 = i2 + 1;
                c0173ao.m1339a().add(0, i2, 0, R.string.mselect).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, c3247a) { // from class: ru.maximoff.apktool.view.ZipViewer.a.10

                    /* renamed from: a */
                    private final C3297a f20899a;

                    /* renamed from: b */
                    private final C3247a f20900b;

                    {
                        this.f20899a = this;
                        this.f20900b = c3247a;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f20899a.m19812a(this.f20900b);
                        return true;
                    }
                });
                int i4 = i3 + 1;
                c0173ao.m1339a().add(0, i3, 0, R.string.mselect_inv).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, c3247a) { // from class: ru.maximoff.apktool.view.ZipViewer.a.11

                    /* renamed from: a */
                    private final C3297a f20901a;

                    /* renamed from: b */
                    private final C3247a f20902b;

                    {
                        this.f20901a = this;
                        this.f20902b = c3247a;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f20901a.m19814b(this.f20902b);
                        return true;
                    }
                });
                if (this.f20896d.f20826i.getName().toLowerCase().endsWith(".apk") && c3247a.m19490h()) {
                    i2 = i4 + 1;
                    c0173ao.m1339a().add(0, i4, 0, R.string.strings_edit).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, m16615o, c3247a) { // from class: ru.maximoff.apktool.view.ZipViewer.a.12

                        /* renamed from: a */
                        private final C3297a f20903a;

                        /* renamed from: b */
                        private final MainActivity f20904b;

                        /* renamed from: c */
                        private final C3247a f20905c;

                        {
                            this.f20903a = this;
                            this.f20904b = m16615o;
                            this.f20905c = c3247a;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            try {
                                Intent intent = new Intent(this.f20904b, Class.forName("ru.maximoff.apktool.AxmlEdit"));
                                intent.putExtra("apk_path", C3297a.m19806a(this.f20903a).f20826i.getAbsolutePath());
                                intent.putExtra("data", this.f20905c.m19491i());
                                this.f20904b.startActivityForResult(intent, 0);
                                C3297a.m19806a(this.f20903a).f20835r = true;
                                return true;
                            } catch (ClassNotFoundException e2) {
                                throw new NoClassDefFoundError(e2.getMessage());
                            }
                        }
                    });
                } else {
                    i2 = i4;
                }
                if (!c3247a.m19489g()) {
                    c0173ao.m1339a().add(0, i2, 0, R.string.replace_to_archive).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, c3247a) { // from class: ru.maximoff.apktool.view.ZipViewer.a.13

                        /* renamed from: a */
                        private final C3297a f20906a;

                        /* renamed from: b */
                        private final C3247a f20907b;

                        {
                            this.f20906a = this;
                            this.f20907b = c3247a;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            C3297a.m19806a(this.f20906a).m19781b(this.f20907b);
                            return true;
                        }
                    });
                    i2++;
                }
            }
            int i5 = i2 + 1;
            c0173ao.m1339a().add(0, i2, 0, R.string.properties).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, c3247a) { // from class: ru.maximoff.apktool.view.ZipViewer.a.14

                /* renamed from: a */
                private final C3297a f20908a;

                /* renamed from: b */
                private final C3247a f20909b;

                {
                    this.f20908a = this;
                    this.f20909b = c3247a;
                }

                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    C3297a.m19806a(this.f20908a).m19773a(this.f20909b);
                    return true;
                }
            });
            if (this.f20896d.f20820c.contains(c3247a)) {
                int i6 = i5 + 1;
                c0173ao.m1339a().add(0, i5, 0, R.string.search_reset).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, c3247a) { // from class: ru.maximoff.apktool.view.ZipViewer.a.15

                    /* renamed from: a */
                    private final C3297a f20910a;

                    /* renamed from: b */
                    private final C3247a f20911b;

                    {
                        this.f20910a = this;
                        this.f20911b = c3247a;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int m19768a = C3297a.m19806a(this.f20910a).m19768a((List<C3247a>) C3297a.m19806a(this.f20910a).f20820c, this.f20911b);
                        if (m19768a >= 0) {
                            C3297a.m19806a(this.f20910a).f20820c.remove(m19768a);
                        } else {
                            C3112bn.m18999a(C3297a.m19806a(this.f20910a).f20821d, R.string.error);
                        }
                        C3297a.m19806a(this.f20910a).m19800c();
                        return true;
                    }
                });
            }
            c0173ao.m1344c();
        }
    }

    /* renamed from: ru.maximoff.apktool.view.ZipViewer$b */
    private class C3298b {

        /* renamed from: a */
        public int f20929a;

        /* renamed from: b */
        public ImageView f20930b;

        /* renamed from: c */
        public TextView f20931c;

        /* renamed from: d */
        public TextView f20932d;

        /* renamed from: e */
        private final ZipViewer f20933e;

        public C3298b(ZipViewer zipViewer) {
            this.f20933e = zipViewer;
        }
    }
}
