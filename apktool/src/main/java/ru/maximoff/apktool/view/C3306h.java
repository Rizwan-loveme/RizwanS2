package ru.maximoff.apktool.view;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.fragment.p301a.C2978b;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3246h;
import ru.maximoff.apktool.util.C3251k;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.view.CustomListView;

/* compiled from: MessageView.java */
/* renamed from: ru.maximoff.apktool.view.h */
/* loaded from: classes.dex */
public class C3306h extends CustomListView {

    /* renamed from: a */
    private int f21035a;

    /* renamed from: b */
    private int f21036b;

    /* renamed from: c */
    private int f21037c;

    /* renamed from: d */
    private int f21038d;

    /* renamed from: e */
    private int f21039e;

    /* renamed from: f */
    private int f21040f;

    /* renamed from: g */
    private int f21041g;

    /* renamed from: h */
    private int f21042h;

    /* renamed from: i */
    private a f21043i;

    /* renamed from: j */
    private DialogInterfaceC0070b f21044j;

    /* renamed from: k */
    private Context f21045k;

    /* renamed from: l */
    private Typeface f21046l;

    /* renamed from: m */
    private boolean f21047m;

    /* renamed from: n */
    private boolean f21048n;

    /* renamed from: o */
    private boolean f21049o;

    /* renamed from: p */
    private String[] f21050p;

    /* renamed from: q */
    private long f21051q;

    public C3306h(Context context) {
        super(context);
        this.f21051q = 0L;
        setColors(context);
        int m18574b = C3080al.m18574b(context, 10);
        this.f21045k = context;
        try {
            this.f21046l = Typeface.createFromAsset(context.getAssets(), "monospace.ttf");
        } catch (Exception e2) {
            this.f21046l = Typeface.MONOSPACE;
        }
        this.f21047m = false;
        this.f21048n = false;
        this.f21049o = false;
        this.f21050p = C3262u.m19640b(context);
        this.f21043i = new a(this, context);
        this.f21043i.m19908a();
        setAdapter((ListAdapter) this.f21043i);
        setDivider((Drawable) null);
        setDividerHeight(0);
        setFastScrollEnabled(C3102bd.f18314av);
        setPadding(m18574b, m18574b, m18574b, m18574b);
    }

    public void setDialog(DialogInterfaceC0070b dialogInterfaceC0070b) {
        this.f21044j = dialogInterfaceC0070b;
    }

    private void setColors(Context context) {
        if (C3102bd.f18291a) {
            this.f21035a = C3246h.m19470a(context, R.color.very_dark_green);
            this.f21036b = -16777216;
            this.f21037c = C3246h.m19470a(context, R.color.dark_red);
            this.f21038d = C3246h.m19470a(context, R.color.very_dark_red);
            this.f21039e = C3246h.m19470a(context, R.color.dark_brown);
            this.f21040f = C3246h.m19470a(context, R.color.very_dark_blue);
            this.f21041g = C3246h.m19470a(context, R.color.purple);
            this.f21042h = C3246h.m19470a(context, R.color.accent_material_light);
            return;
        }
        this.f21035a = C3246h.m19470a(context, R.color.very_light_green);
        this.f21036b = -1;
        this.f21037c = C3246h.m19470a(context, R.color.light_red);
        this.f21038d = C3246h.m19470a(context, R.color.very_light_red);
        this.f21039e = C3246h.m19470a(context, R.color.very_light_yellow);
        this.f21040f = C3246h.m19470a(context, R.color.very_light_blue);
        this.f21041g = C3246h.m19470a(context, R.color.purple);
        this.f21042h = C3246h.m19470a(context, R.color.accent_material);
    }

    /* renamed from: a */
    public void m19903a(boolean z) {
        this.f21047m = z;
    }

    /* renamed from: b */
    public void m19904b(boolean z) {
        this.f21048n = z;
    }

    /* renamed from: c */
    public void m19905c(boolean z) {
        this.f21049o = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m19886a(String str) {
        if (this.f21049o || str.length() <= 1 || str.charAt(1) != ':') {
            return this.f21036b;
        }
        switch (str.charAt(0)) {
            case 'A':
                break;
            case 'D':
                break;
            case 'E':
                break;
            case 'F':
            case 'I':
                break;
            case 'S':
                break;
            case 'W':
                break;
        }
        return this.f21036b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public SpannableStringBuilder m19892b(String str) {
        int i;
        StringBuilder sb = new StringBuilder();
        sb.append("((");
        if (this.f21050p != null && this.f21050p.length > 0) {
            sb.append(C3080al.m18540a(this.f21050p, "|"));
        } else {
            sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        }
        sb.append(")");
        sb.append(".+\\.(xml|smali))\\:(\\d+)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        Matcher matcher = Pattern.compile(sb.toString(), 2).matcher(str);
        boolean z = false;
        boolean z2 = false;
        while (matcher.find()) {
            File file = new File(matcher.group(1));
            if (file.isFile()) {
                try {
                    i = Integer.parseInt(matcher.group(4));
                } catch (Exception e2) {
                    i = 0;
                }
                spannableStringBuilder.setSpan(new ClickableSpan(this, file, i) { // from class: ru.maximoff.apktool.view.h.1

                    /* renamed from: a */
                    private final C3306h f21052a;

                    /* renamed from: b */
                    private final File f21053b;

                    /* renamed from: c */
                    private final int f21054c;

                    {
                        this.f21052a = this;
                        this.f21053b = file;
                        this.f21054c = i;
                    }

                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view) {
                        MainActivity m16615o = MainActivity.m16615o();
                        if (m16615o == null || m16615o.m16617B() == null) {
                            return;
                        }
                        if (this.f21052a.f21044j != null) {
                            this.f21052a.f21044j.hide();
                            m16615o.m16621a(this.f21052a.f21044j);
                        }
                        m16615o.m16617B().m17636a(this.f21053b);
                        if (this.f21054c > 0) {
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this, this.f21054c) { // from class: ru.maximoff.apktool.view.h.1.1

                                /* renamed from: a */
                                private final AnonymousClass1 f21055a;

                                /* renamed from: b */
                                private final int f21056b;

                                {
                                    this.f21055a = this;
                                    this.f21056b = r2;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    C2978b.f16135a.m17726m(this.f21056b);
                                }
                            }, 300L);
                        }
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(this.f21052a.f21042h);
                        textPaint.setTypeface(this.f21052a.f21046l);
                        textPaint.setUnderlineText(true);
                    }
                }, matcher.start(), matcher.end(), 33);
                if (z2 || this.f21044j == null) {
                    z = true;
                } else {
                    this.f21044j.setCancelable(false);
                    this.f21044j.setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: ru.maximoff.apktool.view.h.2

                        /* renamed from: a */
                        private final C3306h f21057a;

                        {
                            this.f21057a = this;
                        }

                        @Override // android.content.DialogInterface.OnKeyListener
                        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                            if (i2 != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                                return false;
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - this.f21057a.f21051q > 2000) {
                                C3112bn.m18999a(this.f21057a.f21045k, R.string.click_once_more2);
                                this.f21057a.f21051q = currentTimeMillis;
                                return false;
                            }
                            dialogInterface.cancel();
                            return true;
                        }
                    });
                    z = true;
                    z2 = true;
                }
            } else {
                z = true;
            }
        }
        return !z ? m19889a(spannableStringBuilder) : spannableStringBuilder;
    }

    /* renamed from: a */
    private SpannableStringBuilder m19889a(SpannableStringBuilder spannableStringBuilder) {
        Matcher matcher = Pattern.compile("Exception occurred while writing code_item").matcher(spannableStringBuilder.toString());
        if (matcher.find()) {
            spannableStringBuilder.setSpan(new ClickableSpan(this) { // from class: ru.maximoff.apktool.view.h.3

                /* renamed from: a */
                private final C3306h f21058a;

                {
                    this.f21058a = this;
                }

                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    new DialogInterfaceC0070b.a(this.f21058a.f21045k).m433b(R.string.dex_is_full).m420a(R.string.f21470ok, (DialogInterface.OnClickListener) null).m438b().show();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(this.f21058a.f21042h);
                    textPaint.setTypeface(this.f21058a.f21046l);
                    textPaint.setUnderlineText(true);
                }
            }, matcher.start(), matcher.end(), 33);
        }
        return spannableStringBuilder;
    }

    /* renamed from: a */
    public void m19901a(CharSequence charSequence) {
        this.f21043i.m19909a(charSequence.toString());
        setHandleDataChangedListener(new CustomListView.InterfaceC3268a(this, Math.max(this.f21043i.getCount() - 1, 0)) { // from class: ru.maximoff.apktool.view.h.4

            /* renamed from: a */
            private final C3306h f21059a;

            /* renamed from: b */
            private final int f21060b;

            {
                this.f21059a = this;
                this.f21060b = r2;
            }

            @Override // ru.maximoff.apktool.view.CustomListView.InterfaceC3268a
            /* renamed from: a */
            public void mo16527a() {
                this.f21059a.setHandleDataChangedListener((CustomListView.InterfaceC3268a) null);
                if (Build.VERSION.SDK_INT >= 21) {
                    View childAt = this.f21059a.getChildAt(0);
                    this.f21059a.setSelectionFromTop(this.f21060b, childAt == null ? 0 : childAt.getTop() - this.f21059a.getPaddingTop());
                } else {
                    this.f21059a.setSelection(this.f21060b);
                }
            }
        });
        this.f21043i.notifyDataSetChanged();
    }

    /* renamed from: a */
    public void m19902a(List<String> list) {
        setHandleDataChangedListener((CustomListView.InterfaceC3268a) null);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.f21043i.m19909a(it.next());
        }
        this.f21043i.notifyDataSetChanged();
    }

    public List<String> getTextList() {
        return this.f21043i.m19910b();
    }

    public String getLastString() {
        List<String> m19910b = this.f21043i.m19910b();
        return m19910b.isEmpty() ? (String) null : m19910b.get(m19910b.size() - 1);
    }

    @Override // android.view.View
    public String toString() {
        return C3080al.m18538a(this.f21043i.m19910b(), "\n");
    }

    /* compiled from: MessageView.java */
    /* renamed from: ru.maximoff.apktool.view.h$a */
    private class a extends ArrayAdapter<String> {

        /* renamed from: a */
        private List<String> f21061a;

        /* renamed from: b */
        private final C3306h f21062b;

        /* renamed from: a */
        static C3306h m19906a(a aVar) {
            return aVar.f21062b;
        }

        @Override // android.widget.ArrayAdapter
        public void add(String str) {
            m19909a(str);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public Object getItem(int i) {
            return m19907a(i);
        }

        public a(C3306h c3306h, Context context) {
            super(context, R.layout.logview_item);
            this.f21062b = c3306h;
        }

        /* renamed from: a */
        public void m19908a() {
            this.f21061a = new ArrayList();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            if (this.f21061a != null) {
                return this.f21061a.size();
            }
            return 0;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        /* renamed from: a */
        public String m19907a(int i) {
            return this.f21061a != null ? this.f21061a.get(i) : (String) null;
        }

        /* renamed from: a */
        public void m19909a(String str) {
            this.f21061a.add(str);
        }

        /* renamed from: b */
        public List<String> m19910b() {
            return this.f21061a;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i) {
            return this.f21062b.f21048n;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = ((LayoutInflater) this.f21062b.f21045k.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.logview_item, (ViewGroup) null);
                bVar = new b(this.f21062b);
                bVar.f21065a = (TextView) view.findViewById(R.id.logitemText);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            view.setMinimumHeight(0);
            String str = this.f21061a.get(i);
            if (str != null) {
                int m19886a = this.f21062b.m19886a(str);
                bVar.f21065a.setTypeface(this.f21062b.f21046l);
                bVar.f21065a.setTextSize(2, C3102bd.f18332o - 2);
                bVar.f21065a.setTextColor(m19886a);
                bVar.f21065a.setTextIsSelectable(this.f21062b.f21048n);
                if (this.f21062b.f21048n && (m19886a == this.f21062b.f21039e || m19886a == this.f21062b.f21037c)) {
                    bVar.f21065a.setMovementMethod(new C3251k());
                    bVar.f21065a.setText(this.f21062b.m19892b(str));
                } else {
                    bVar.f21065a.setText(str);
                }
                bVar.f21065a.setOnClickListener(new View.OnClickListener(this, str) { // from class: ru.maximoff.apktool.view.h.a.1

                    /* renamed from: a */
                    private final a f21063a;

                    /* renamed from: b */
                    private final String f21064b;

                    {
                        this.f21063a = this;
                        this.f21064b = str;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.m19906a(this.f21063a).f21048n) {
                            if (a.m19906a(this.f21063a).f21047m && this.f21064b.indexOf(58) > 0) {
                                C3112bn.m19002a(a.m19906a(this.f21063a).f21045k, this.f21064b.split(":", 2)[1].trim());
                            } else {
                                C3112bn.m19002a(a.m19906a(this.f21063a).f21045k, this.f21064b);
                            }
                        }
                    }
                });
            }
            return view;
        }
    }

    /* compiled from: MessageView.java */
    /* renamed from: ru.maximoff.apktool.view.h$b */
    private class b {

        /* renamed from: a */
        public TextView f21065a;

        /* renamed from: b */
        private final C3306h f21066b;

        public b(C3306h c3306h) {
            this.f21066b = c3306h;
        }
    }
}
