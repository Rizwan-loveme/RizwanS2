package ru.maximoff.apktool.fragment.p302b;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaCodec;
import android.net.Uri;
import android.p008os.AsyncTask;
import android.p008os.Build;
import android.p008os.Bundle;
import android.p008os.Environment;
import android.p008os.Handler;
import android.p008os.Looper;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.widget.C0173ao;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.p209io.FileFilter;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.XMLConstants;
import org.p270e.C2466a;
import org.p270e.C2467b;
import org.p270e.C2468c;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.fragment.C2981b;
import ru.maximoff.apktool.p299d.C2897a;
import ru.maximoff.apktool.p300e.AsyncTaskC2909ak;
import ru.maximoff.apktool.p300e.AsyncTaskC2935f;
import ru.maximoff.apktool.p300e.AsyncTaskC2939j;
import ru.maximoff.apktool.service.LocalFileServerService;
import ru.maximoff.apktool.util.C3066aa;
import ru.maximoff.apktool.util.C3067ab;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3089au;
import ru.maximoff.apktool.util.C3099ba;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3103be;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3220f;
import ru.maximoff.apktool.util.C3246h;
import ru.maximoff.apktool.util.C3258r;
import ru.maximoff.apktool.util.C3259s;
import ru.maximoff.apktool.util.C3261t;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.C3264w;
import ru.maximoff.apktool.util.p303a.C3061a;
import ru.maximoff.apktool.util.p306d.C3211a;
import ru.maximoff.apktool.view.C3312n;
import ru.maximoff.apktool.view.CustomListView;

/* compiled from: FilesPager.java */
/* renamed from: ru.maximoff.apktool.fragment.b.k */
/* loaded from: classes.dex */
public class ViewOnClickListenerC2992k implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: a */
    private View f16555a;

    /* renamed from: b */
    private Context f16556b;

    /* renamed from: c */
    private int f16557c;

    /* renamed from: d */
    private C2993l f16558d;

    /* renamed from: e */
    private CharSequence f16559e;

    /* renamed from: f */
    private CustomListView f16560f;

    /* renamed from: g */
    private TextView f16561g;

    /* renamed from: h */
    private TextView f16562h;

    /* renamed from: i */
    private LinearLayout f16563i;

    /* renamed from: j */
    private C2991j f16564j;

    /* renamed from: k */
    private String[] f16565k;

    /* renamed from: l */
    private ImageView f16566l;

    /* renamed from: m */
    private C3211a f16567m;

    /* renamed from: n */
    private C3220f f16568n;

    /* renamed from: o */
    private C3264w f16569o;

    /* renamed from: p */
    private SwipeRefreshLayout f16570p;

    /* renamed from: q */
    private ImageButton f16571q;

    /* renamed from: r */
    private ImageButton f16572r;

    /* renamed from: s */
    private ImageButton f16573s;

    /* renamed from: t */
    private ImageButton f16574t;

    /* renamed from: u */
    private ImageButton f16575u;

    /* renamed from: v */
    private boolean f16576v = false;

    /* renamed from: w */
    private boolean f16577w;

    /* renamed from: x */
    private AnimationDrawable f16578x;

    public ViewOnClickListenerC2992k(Context context, C2993l c2993l, int i) {
        this.f16556b = context;
        this.f16557c = i;
        this.f16558d = c2993l;
        this.f16555a = LayoutInflater.from(context).inflate(R.layout.files, (ViewGroup) null);
        this.f16559e = context.getText(R.string.files);
        this.f16577w = C3102bd.m18925a(this.f16556b, "show_exit", false);
        this.f16560f = (CustomListView) this.f16555a.findViewById(R.id.files);
        this.f16560f.setFastScrollEnabled(C3102bd.f18314av);
        this.f16570p = (SwipeRefreshLayout) this.f16555a.findViewById(R.id.swipe_container);
        this.f16561g = (TextView) this.f16555a.findViewById(R.id.path);
        this.f16561g.setTextSize(2, C3102bd.f18332o);
        this.f16562h = (TextView) this.f16555a.findViewById(R.id.filesTextView1);
        this.f16562h.setTextSize(2, C3102bd.m18927b());
        this.f16563i = (LinearLayout) this.f16555a.findViewById(R.id.filesLinearLayout1);
        ImageView imageView = (ImageView) this.f16555a.findViewById(R.id.expand);
        if (C3102bd.f18291a) {
            imageView.setImageResource(R.drawable.ic_collapse);
        } else {
            imageView.setImageResource(R.drawable.ic_collapse_dark);
        }
        imageView.setOnClickListener(this);
        this.f16566l = (ImageView) this.f16555a.findViewById(R.id.filePaste);
        if (C3102bd.f18291a) {
            this.f16566l.setImageResource(R.drawable.ic_paste_light);
        } else {
            this.f16566l.setImageResource(R.drawable.ic_paste_dark);
        }
        this.f16566l.setClickable(true);
        this.f16566l.setOnClickListener(this);
        this.f16566l.setOnLongClickListener(new View.OnLongClickListener(this) { // from class: ru.maximoff.apktool.fragment.b.k.1

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16579a;

            {
                this.f16579a = this;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                this.f16579a.m18018a((DialogInterfaceC0070b) null);
                return true;
            }
        });
        this.f16571q = (ImageButton) this.f16555a.findViewById(R.id.filesImageButton1);
        this.f16572r = (ImageButton) this.f16555a.findViewById(R.id.filesImageButton2);
        this.f16573s = (ImageButton) this.f16555a.findViewById(R.id.filesImageButton3);
        this.f16574t = (ImageButton) this.f16555a.findViewById(R.id.filesImageButton4);
        this.f16575u = (ImageButton) this.f16555a.findViewById(R.id.filesImageButton5);
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener(this) { // from class: ru.maximoff.apktool.fragment.b.k.2

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16650a;

            {
                this.f16650a = this;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (view.getId() == R.id.filesImageButton5 && !this.f16650a.f16576v) {
                    this.f16650a.f16564j.mo17929a();
                } else if (view.getId() == R.id.filesImageButton2 && !this.f16650a.f16567m.m19178b() && !this.f16650a.f16576v) {
                    this.f16650a.f16567m.m19172a();
                } else if (view.getId() == R.id.filesImageButton4) {
                    if (this.f16650a.f16576v) {
                        File[] mo17960l = this.f16650a.f16564j.mo17960l();
                        if (mo17960l.length == 1) {
                            this.f16650a.f16564j.m17955h(C3262u.m19641b(mo17960l[0].getName())[1]);
                        }
                        C3112bn.m19023b(this.f16650a.f16556b, view.getContentDescription().toString());
                    } else {
                        this.f16650a.f16564j.m17950f();
                    }
                } else {
                    if (view.getId() == R.id.filesImageButton1 && !this.f16650a.f16576v && !this.f16650a.f16569o.m19689c()) {
                        this.f16650a.f16569o.m19684a();
                    }
                    C3112bn.m19023b(this.f16650a.f16556b, view.getContentDescription().toString());
                }
                return true;
            }
        };
        this.f16571q.setOnLongClickListener(onLongClickListener);
        this.f16572r.setOnLongClickListener(onLongClickListener);
        this.f16573s.setOnLongClickListener(onLongClickListener);
        this.f16574t.setOnLongClickListener(onLongClickListener);
        this.f16575u.setOnLongClickListener(onLongClickListener);
        if (this.f16577w) {
            if (C3102bd.f18291a) {
                this.f16575u.setImageResource(R.drawable.ic_exit);
            } else {
                this.f16575u.setImageResource(R.drawable.ic_exit_dark);
            }
            this.f16575u.setContentDescription(this.f16556b.getString(R.string.exit));
        }
        this.f16563i.setClickable(true);
        this.f16563i.setOnClickListener(this);
        this.f16563i.setOnLongClickListener(this);
        m18006l();
    }

    /* renamed from: a */
    public void m18023a(boolean z) {
        boolean z2 = false;
        this.f16576v = z;
        this.f16568n.m19295c();
        this.f16577w = C3102bd.m18925a(this.f16556b, "show_exit", false);
        String charSequence = this.f16561g.getText().toString();
        boolean m19664g = C3262u.m19664g(this.f16556b, new File(charSequence));
        if (C3102bd.f18291a) {
            if (z) {
                if (m19664g) {
                    this.f16571q.setImageResource(R.drawable.ic_cut);
                } else {
                    this.f16571q.setImageResource(R.drawable.ic_cut_disable);
                }
                this.f16572r.setImageResource(R.drawable.ic_copy);
                if (m19664g) {
                    this.f16573s.setImageResource(R.drawable.ic_delete);
                } else {
                    this.f16573s.setImageResource(R.drawable.ic_delete_disable);
                }
                this.f16574t.setImageResource(R.drawable.ic_inverse);
                this.f16575u.setImageResource(R.drawable.ic_select_all);
            } else {
                if (this.f16568n.m19298d()) {
                    this.f16571q.setImageResource(R.drawable.ic_bookmark_disable);
                } else {
                    this.f16571q.setImageResource(R.drawable.ic_bookmark);
                }
                this.f16572r.setImageResource(R.drawable.ic_search);
                if (m19664g) {
                    this.f16573s.setImageResource(R.drawable.ic_add);
                } else {
                    this.f16573s.setImageResource(R.drawable.ic_add_disable);
                }
                this.f16574t.setImageResource(R.drawable.ic_sync);
                if (this.f16577w) {
                    this.f16575u.setImageResource(R.drawable.ic_exit);
                } else {
                    this.f16575u.setImageResource(R.drawable.ic_up);
                }
            }
        } else if (z) {
            if (m19664g) {
                this.f16571q.setImageResource(R.drawable.ic_cut_dark);
            } else {
                this.f16571q.setImageResource(R.drawable.ic_cut_disable);
            }
            this.f16572r.setImageResource(R.drawable.ic_copy_dark);
            if (m19664g) {
                this.f16573s.setImageResource(R.drawable.ic_delete_dark);
            } else {
                this.f16573s.setImageResource(R.drawable.ic_delete_disable);
            }
            this.f16574t.setImageResource(R.drawable.ic_inverse_dark);
            this.f16575u.setImageResource(R.drawable.ic_select_all_dark);
        } else {
            if (this.f16568n.m19298d()) {
                this.f16571q.setImageResource(R.drawable.ic_bookmark_disable);
            } else {
                this.f16571q.setImageResource(R.drawable.ic_bookmark_dark);
            }
            this.f16572r.setImageResource(R.drawable.ic_search_dark);
            if (m19664g) {
                this.f16573s.setImageResource(R.drawable.ic_add_dark);
            } else {
                this.f16573s.setImageResource(R.drawable.ic_add_disable);
            }
            this.f16574t.setImageResource(R.drawable.ic_sync_dark);
            if (this.f16577w) {
                this.f16575u.setImageResource(R.drawable.ic_exit_dark);
            } else {
                this.f16575u.setImageResource(R.drawable.ic_up_dark);
            }
        }
        if (z) {
            this.f16571q.setContentDescription(this.f16556b.getString(R.string.cut));
            this.f16572r.setContentDescription(this.f16556b.getString(R.string.copy));
            this.f16573s.setContentDescription(this.f16556b.getString(R.string.delete));
            this.f16574t.setContentDescription(this.f16556b.getString(R.string.mselect_inv));
            this.f16575u.setContentDescription(this.f16556b.getString(R.string.mselect_all));
        } else {
            this.f16571q.setContentDescription(this.f16556b.getString(R.string.bookmarks));
            this.f16572r.setContentDescription(this.f16556b.getString(R.string.search_files));
            this.f16573s.setContentDescription(this.f16556b.getString(R.string.madd));
            this.f16574t.setContentDescription(this.f16556b.getString(R.string.sync_tabs));
            if (this.f16577w) {
                this.f16575u.setContentDescription(this.f16556b.getString(R.string.exit));
            } else {
                this.f16575u.setContentDescription(this.f16556b.getString(R.string.go_back));
            }
        }
        this.f16571q.setOnClickListener(new View.OnClickListener(this, z) { // from class: ru.maximoff.apktool.fragment.b.k.3

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16726a;

            /* renamed from: b */
            private final boolean f16727b;

            {
                this.f16726a = this;
                this.f16727b = z;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.f16727b) {
                    this.f16726a.m17991b(true);
                } else {
                    this.f16726a.f16568n.m19292b();
                }
            }
        });
        this.f16572r.setOnClickListener(new View.OnClickListener(this, z, charSequence) { // from class: ru.maximoff.apktool.fragment.b.k.4

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16766a;

            /* renamed from: b */
            private final boolean f16767b;

            /* renamed from: c */
            private final String f16768c;

            {
                this.f16766a = this;
                this.f16767b = z;
                this.f16768c = charSequence;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.f16767b) {
                    this.f16766a.m17991b(false);
                } else {
                    this.f16766a.f16567m.m19173a(this.f16768c);
                }
            }
        });
        this.f16573s.setOnClickListener(new View.OnClickListener(this, z) { // from class: ru.maximoff.apktool.fragment.b.k.5

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16783a;

            /* renamed from: b */
            private final boolean f16784b;

            {
                this.f16783a = this;
                this.f16784b = z;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.f16784b) {
                    C3262u.m19645c(this.f16783a.f16556b, this.f16783a.f16564j.mo17960l(), this.f16783a.f16564j);
                } else {
                    this.f16783a.f16564j.m17948e();
                }
            }
        });
        this.f16574t.setOnClickListener(new View.OnClickListener(this, z, charSequence) { // from class: ru.maximoff.apktool.fragment.b.k.6

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16785a;

            /* renamed from: b */
            private final boolean f16786b;

            /* renamed from: c */
            private final String f16787c;

            {
                this.f16785a = this;
                this.f16786b = z;
                this.f16787c = charSequence;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.f16786b) {
                    this.f16785a.f16564j.mo17936a(true);
                } else {
                    this.f16785a.f16558d.m18061a(this.f16787c, this.f16785a.f16557c);
                    C3112bn.m19023b(this.f16785a.f16556b, this.f16785a.f16556b.getString(R.string.success));
                }
            }
        });
        this.f16575u.setOnClickListener(new View.OnClickListener(this, z) { // from class: ru.maximoff.apktool.fragment.b.k.7

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16788a;

            /* renamed from: b */
            private final boolean f16789b;

            {
                this.f16788a = this;
                this.f16789b = z;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.f16789b) {
                    this.f16788a.f16564j.mo17936a(false);
                } else if (this.f16788a.f16577w) {
                    ((MainActivity) this.f16788a.f16556b).m16643y();
                } else if (!this.f16788a.f16564j.m17958j()) {
                    ((MainActivity) this.f16788a.f16556b).m16636r();
                }
            }
        });
        this.f16573s.setEnabled(m19664g);
        ImageButton imageButton = this.f16571q;
        if ((m19664g && z) || (!this.f16568n.m19298d() && !z)) {
            z2 = true;
        }
        imageButton.setEnabled(z2);
        this.f16562h.setText(this.f16564j.m17928a(this.f16556b));
    }

    /* renamed from: l */
    private void m18006l() {
        if (!C3102bd.m18925a(this.f16556b, "topmenu_highlight_skip", false)) {
            LinearLayout linearLayout = (LinearLayout) this.f16555a.findViewById(R.id.filesLinearLayout2);
            this.f16578x = new AnimationDrawable();
            this.f16578x.addFrame(new ColorDrawable(0), 700);
            this.f16578x.addFrame(new ColorDrawable(Color.GRAY), 700);
            this.f16578x.setOneShot(false);
            linearLayout.setBackgroundDrawable(this.f16578x);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.fragment.b.k.8

                /* renamed from: a */
                private final ViewOnClickListenerC2992k f16790a;

                {
                    this.f16790a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f16790a.f16578x.start();
                }
            }, 100L);
        }
    }

    /* renamed from: a */
    public void m18013a() {
        if (!C3102bd.m18925a(this.f16556b, "topmenu_highlight_skip", false)) {
            C3112bn.m19022b(this.f16556b, R.string.topmenu_toast);
            C3102bd.m18938b(this.f16556b, "topmenu_highlight_skip", true);
        }
        LinearLayout linearLayout = (LinearLayout) this.f16555a.findViewById(R.id.filesLinearLayout2);
        if (this.f16578x != null && this.f16578x.isRunning()) {
            this.f16578x.stop();
        }
        linearLayout.setBackgroundDrawable((Drawable) null);
        linearLayout.setBackgroundColor(0);
    }

    /* renamed from: b */
    public int m18025b() {
        return this.f16560f.getFirstVisiblePosition();
    }

    /* renamed from: a */
    public void m18014a(int i) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this, i) { // from class: ru.maximoff.apktool.fragment.b.k.9

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16791a;

            /* renamed from: b */
            private final int f16792b;

            {
                this.f16791a = this;
                this.f16792b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (Build.VERSION.SDK_INT >= 21) {
                    View childAt = this.f16791a.f16560f.getChildAt(0);
                    this.f16791a.f16560f.setSelectionFromTop(this.f16792b, childAt != null ? childAt.getTop() - this.f16791a.f16560f.getPaddingTop() : 0);
                } else {
                    this.f16791a.f16560f.setSelection(this.f16792b);
                }
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m17991b(boolean z) {
        C2466a c2466a = new C2466a();
        try {
            File[] mo17960l = this.f16564j.mo17960l();
            c2466a.m15572a(0, mo17960l[0].getParent());
            for (int i = 0; i < mo17960l.length; i++) {
                c2466a.m15572a(i + 1, mo17960l[i].getName());
            }
            C3102bd.m18937b(this.f16556b, "copy_file_path", c2466a.toString());
            C3102bd.m18938b(this.f16556b, "cut_file_mode", z);
            this.f16564j.mo17929a();
        } catch (C2467b e2) {
            C3112bn.m18999a(this.f16556b, R.string.error);
        }
    }

    /* renamed from: a */
    public void m18017a(Bundle bundle, C2981b c2981b) {
        int m19470a;
        int i;
        this.f16564j = new C2991j(c2981b, this.f16561g, this);
        this.f16567m = new C3211a(this.f16556b, this.f16564j);
        this.f16569o = new C3264w(this.f16556b, this.f16564j);
        this.f16568n = new C3220f(this.f16556b, this.f16564j);
        this.f16565k = m18032d();
        this.f16564j.m17933a(this.f16560f);
        this.f16564j.m17930a(this.f16557c);
        this.f16564j.m17941b(bundle);
        this.f16564j.m17932a(this.f16566l);
        this.f16564j.m17956i();
        switch (C3102bd.f18319b) {
            case 1:
                m19470a = -12303292;
                i = -1;
                break;
            case 2:
                m19470a = C3246h.m19470a(this.f16556b, R.color.primary_material);
                i = -1;
                break;
            default:
                m19470a = -1;
                i = -12303292;
                break;
        }
        this.f16570p.setColorSchemeColors(i);
        this.f16570p.setProgressBackgroundColorSchemeColor(m19470a);
        this.f16570p.setOnRefreshListener(new SwipeRefreshLayout.InterfaceC0447b(this) { // from class: ru.maximoff.apktool.fragment.b.k.10

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16580a;

            {
                this.f16580a = this;
            }

            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.InterfaceC0447b
            /* renamed from: a */
            public void mo3375a() {
                this.f16580a.f16564j.mo17929a();
                this.f16580a.f16564j.mo17947d(this.f16580a.f16561g.getText().toString());
                this.f16580a.f16570p.setRefreshing(false);
            }
        });
        m18035f();
    }

    /* renamed from: a */
    public void m18020a(String str, String str2) {
        String charSequence = this.f16561g.getText().toString();
        String m18031d = m18031d(charSequence);
        C3211a c3211a = this.f16567m;
        if (m18031d != null) {
            charSequence = m18031d;
        }
        c3211a.m19174a(str, charSequence, str2);
    }

    /* renamed from: c */
    public void m18030c() {
        C3102bd.m18924a(this.f16556b, "copy_file_path");
        C3102bd.m18924a(this.f16556b, "cut_file_mode");
        this.f16564j.mo17929a();
    }

    /* renamed from: a */
    public void m18018a(DialogInterfaceC0070b dialogInterfaceC0070b) {
        int i;
        String m18910a = C3102bd.m18910a(this.f16556b, "copy_file_path", (String) null);
        if (m18910a == null) {
            C3112bn.m19023b(this.f16556b, this.f16556b.getString(R.string.error));
            m18030c();
            if (dialogInterfaceC0070b != null) {
                dialogInterfaceC0070b.cancel();
                return;
            }
            return;
        }
        try {
            C2466a c2466a = new C2466a(m18910a);
            String m15579f = c2466a.m15579f(0);
            String[] strArr = new String[c2466a.m15569a() - 1];
            for (int i2 = 1; i2 < c2466a.m15569a(); i2++) {
                strArr[i2 - 1] = new StringBuffer().append(new StringBuffer().append(m15579f).append(File.separator).toString()).append(c2466a.m15579f(i2)).toString();
            }
            if (C3102bd.m18925a(this.f16556b, "cut_file_mode", false)) {
                i = R.string.cut;
            } else {
                i = R.string.copy;
            }
            new DialogInterfaceC0070b.a(this.f16556b).m418a(i).m431a(strArr, new DialogInterface.OnClickListener(this, strArr, dialogInterfaceC0070b) { // from class: ru.maximoff.apktool.fragment.b.k.11

                /* renamed from: a */
                private final ViewOnClickListenerC2992k f16581a;

                /* renamed from: b */
                private final String[] f16582b;

                /* renamed from: c */
                private final DialogInterfaceC0070b f16583c;

                {
                    this.f16581a = this;
                    this.f16582b = strArr;
                    this.f16583c = dialogInterfaceC0070b;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    this.f16581a.f16564j.mo17934a(new File(this.f16582b[i3]));
                    if (this.f16583c != null) {
                        this.f16583c.cancel();
                    }
                    dialogInterface.cancel();
                }
            }).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m440c(R.string.search_reset, new DialogInterface.OnClickListener(this, dialogInterfaceC0070b) { // from class: ru.maximoff.apktool.fragment.b.k.12

                /* renamed from: a */
                private final ViewOnClickListenerC2992k f16584a;

                /* renamed from: b */
                private final DialogInterfaceC0070b f16585b;

                {
                    this.f16584a = this;
                    this.f16585b = dialogInterfaceC0070b;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    this.f16584a.m18030c();
                    if (this.f16585b != null) {
                        this.f16585b.cancel();
                    }
                    dialogInterface.cancel();
                }
            }).m438b().show();
        } catch (Exception e2) {
            C3112bn.m19023b(this.f16556b, this.f16556b.getString(R.string.error));
            m18030c();
            if (dialogInterfaceC0070b != null) {
                dialogInterfaceC0070b.cancel();
            }
        }
    }

    /* renamed from: d */
    public String[] m18032d() {
        String[] m19640b = C3262u.m19640b(this.f16556b);
        this.f16564j.m17942b(m19640b);
        return m19640b;
    }

    /* renamed from: a */
    public void m18016a(Bundle bundle) {
        if (this.f16564j != null) {
            this.f16564j.m17931a(bundle);
        }
    }

    /* renamed from: e */
    public CharSequence m18033e() {
        return this.f16559e;
    }

    /* renamed from: f */
    public void m18035f() {
        if (this.f16570p == null) {
            return;
        }
        this.f16570p.setEnabled(C3102bd.f18303ak);
    }

    /* renamed from: a */
    public void m18019a(CharSequence charSequence) {
        this.f16559e = charSequence;
        this.f16558d.mo3289c();
    }

    /* renamed from: g */
    public View m18036g() {
        return this.f16555a;
    }

    /* renamed from: h */
    public C2991j m18037h() {
        return this.f16564j;
    }

    /* renamed from: i */
    public void m18038i() {
        m18035f();
        if (this.f16564j == null) {
            return;
        }
        this.f16564j.m17971w();
    }

    /* renamed from: a */
    public void m18024a(String[] strArr) {
        if (strArr == null || this.f16564j == null) {
            return;
        }
        for (String str : strArr) {
            this.f16564j.m17951f(str);
        }
        this.f16564j.m17954h();
        this.f16564j.notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.expand /* 2131689804 */:
                this.f16558d.m18065d();
                m17981a(this.f16563i);
                break;
            case R.id.filesLinearLayout1 /* 2131689805 */:
                this.f16558d.m18065d();
                m17981a(view);
                break;
            case R.id.filePaste /* 2131689808 */:
                String charSequence = this.f16561g.getText().toString();
                if (new File(charSequence).canWrite()) {
                    String m18910a = C3102bd.m18910a(this.f16556b, "copy_file_path", (String) null);
                    if (m18910a == null) {
                        C3112bn.m19023b(this.f16556b, this.f16556b.getString(R.string.error));
                        m18030c();
                        break;
                    } else {
                        try {
                            C2466a c2466a = new C2466a(m18910a);
                            String m15579f = c2466a.m15579f(0);
                            StringBuilder sb = new StringBuilder();
                            File[] fileArr = new File[c2466a.m15569a() - 1];
                            for (int i = 1; i < c2466a.m15569a(); i++) {
                                File file = new File(new StringBuffer().append(new StringBuffer().append(m15579f).append(File.separator).toString()).append(c2466a.m15579f(i)).toString());
                                if (i > 1) {
                                    sb.append(", ");
                                }
                                sb.append(file.getName());
                                fileArr[i - 1] = file;
                            }
                            boolean m18925a = C3102bd.m18925a(this.f16556b, "cut_file_mode", false);
                            m18022a(sb.toString(), fileArr, charSequence, m18925a, C3102bd.m18925a(this.f16556b, "dont_reset_cpb", false) && !m18925a, m15579f.length(), false);
                            break;
                        } catch (Exception e2) {
                            C3112bn.m19023b(this.f16556b, this.f16556b.getString(R.string.errorf, e2.getMessage()));
                            m18030c();
                            return;
                        }
                    }
                }
                break;
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        switch (view.getId()) {
            case R.id.filesLinearLayout1 /* 2131689805 */:
                this.f16564j.m17946d();
                return true;
            default:
                return false;
        }
    }

    /* renamed from: a */
    public void m18022a(String str, File[] fileArr, String str2, boolean z, boolean z2, int i, boolean z3) {
        try {
            new a(this, this.f16556b, str, str2, z, z2, i, z3).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, fileArr);
        } catch (Exception e2) {
            C3112bn.m18999a(this.f16556b, R.string.error_try_again);
        }
    }

    /* renamed from: a */
    public void m18021a(String str, List<File> list, String str2, boolean z, boolean z2, int i, boolean z3) {
        int i2;
        if (list == null || list.isEmpty()) {
            C3112bn.m18999a(this.f16556b, R.string.error);
            return;
        }
        if (z3) {
            i2 = z ? R.string.move_tt_conf : R.string.copy_tt_conf;
        } else {
            i2 = z ? R.string.move_here : R.string.copy_here;
        }
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f16556b).m418a(z ? R.string.moving : R.string.copying).m436b(this.f16556b.getString(i2, str)).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, str2, z, z2, i, list) { // from class: ru.maximoff.apktool.fragment.b.k.13

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16586a;

            /* renamed from: b */
            private final String f16587b;

            /* renamed from: c */
            private final boolean f16588c;

            /* renamed from: d */
            private final boolean f16589d;

            /* renamed from: e */
            private final int f16590e;

            /* renamed from: f */
            private final List f16591f;

            {
                this.f16586a = this;
                this.f16587b = str2;
                this.f16588c = z;
                this.f16589d = z2;
                this.f16590e = i;
                this.f16591f = list;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.cancel();
                try {
                    new b(this.f16586a, this.f16586a.f16556b, this.f16587b, this.f16588c, this.f16589d, this.f16590e).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (File[]) this.f16591f.toArray(new File[this.f16591f.size()]));
                } catch (Exception e2) {
                    C3112bn.m18999a(this.f16586a.f16556b, R.string.error_try_again);
                }
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.details, (DialogInterface.OnClickListener) null).m438b();
        m438b.setOnShowListener(new AnonymousClass14(this, m438b, z3));
        m438b.show();
    }

    /* compiled from: FilesPager.java */
    /* renamed from: ru.maximoff.apktool.fragment.b.k$14, reason: invalid class name */
    class AnonymousClass14 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final ViewOnClickListenerC2992k f16592a;

        /* renamed from: b */
        private final DialogInterfaceC0070b f16593b;

        /* renamed from: c */
        private final boolean f16594c;

        AnonymousClass14(ViewOnClickListenerC2992k viewOnClickListenerC2992k, DialogInterfaceC0070b dialogInterfaceC0070b, boolean z) {
            this.f16592a = viewOnClickListenerC2992k;
            this.f16593b = dialogInterfaceC0070b;
            this.f16594c = z;
        }

        /* renamed from: a */
        static ViewOnClickListenerC2992k m18041a(AnonymousClass14 anonymousClass14) {
            return anonymousClass14.f16592a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            Button m414a = this.f16593b.m414a(-3);
            m414a.setEnabled(!this.f16594c);
            m414a.setOnClickListener(new View.OnClickListener(this, this.f16593b) { // from class: ru.maximoff.apktool.fragment.b.k.14.1

                /* renamed from: a */
                private final AnonymousClass14 f16595a;

                /* renamed from: b */
                private final DialogInterfaceC0070b f16596b;

                {
                    this.f16595a = this;
                    this.f16596b = r2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AnonymousClass14.m18041a(this.f16595a).m18018a(this.f16596b);
                }
            });
        }
    }

    /* renamed from: a */
    private void m17981a(View view) {
        String str;
        this.f16565k = m18032d();
        this.f16569o.m19687b();
        String charSequence = this.f16561g.getText().toString();
        String m18031d = m18031d(charSequence);
        String m18012a = m18012a(m18031d);
        String m18026b = m18026b(m18031d);
        String m18028c = m18028c(m18031d);
        boolean z = m18031d != null && m18031d.equals(C3102bd.f18337t);
        try {
            str = m17997g(m18031d);
        } catch (Exception e2) {
            str = (String) null;
        }
        Menu m18715a = C3089au.m18715a(view, R.menu.dir, new AnonymousClass15(this, charSequence, z, MainActivity.m16615o(), m18031d, str, m18012a, m18026b, m18028c));
        if (z) {
            m18715a.findItem(R.id.main_project).setTitle(this.f16556b.getString(R.string.close_project));
        }
        int i = 1001;
        m18715a.add(0, 1001, 0, this.f16556b.getString(R.string.enter_path)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: ru.maximoff.apktool.fragment.b.k.16

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16645a;

            {
                this.f16645a = this;
            }

            @Override // android.view.MenuItem.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f16645a.f16564j.m17946d();
                return true;
            }
        });
        String str2 = C3102bd.f18339v;
        if (str2 != null) {
            i = 1002;
            m18715a.add(0, 1002, 0, this.f16556b.getString(R.string.output_directory)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, str2) { // from class: ru.maximoff.apktool.fragment.b.k.17

                /* renamed from: a */
                private final ViewOnClickListenerC2992k f16646a;

                /* renamed from: b */
                private final String f16647b;

                {
                    this.f16646a = this;
                    this.f16647b = str2;
                }

                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    this.f16646a.f16564j.mo17934a(new File(this.f16647b));
                    return true;
                }
            });
        }
        if (this.f16565k != null) {
            for (int i2 = 0; i2 < this.f16565k.length; i2++) {
                m18715a.add(0, i2 + Types.OTHER, 0, this.f16565k[i2].equals(Environment.getExternalStorageDirectory().getAbsolutePath()) ? this.f16556b.getString(R.string.internal) : this.f16565k[i2]).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: ru.maximoff.apktool.fragment.b.k.18

                    /* renamed from: a */
                    private final ViewOnClickListenerC2992k f16648a;

                    {
                        this.f16648a = this;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        this.f16648a.f16564j.mo17934a(new File(this.f16648a.f16565k[menuItem.getItemId() - 1111]));
                        return true;
                    }
                });
            }
        }
        int i3 = i + 1;
        m18715a.add(0, i3, 0, this.f16556b.getString(R.string.root_dir)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: ru.maximoff.apktool.fragment.b.k.19

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16649a;

            {
                this.f16649a = this;
            }

            @Override // android.view.MenuItem.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f16649a.f16564j.mo17934a(new File("/"));
                return true;
            }
        });
        int i4 = i3 + 1;
        m18715a.add(0, i4, 0, this.f16556b.getString(R.string.storages_info)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, charSequence) { // from class: ru.maximoff.apktool.fragment.b.k.20

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16651a;

            /* renamed from: b */
            private final String f16652b;

            {
                this.f16651a = this;
                this.f16652b = charSequence;
            }

            @Override // android.view.MenuItem.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f16651a.m17996f(this.f16652b);
                return true;
            }
        });
        m18715a.add(0, i4 + 1, 0, this.f16556b.getString(R.string.server_start)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, charSequence) { // from class: ru.maximoff.apktool.fragment.b.k.21

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16653a;

            /* renamed from: b */
            private final String f16654b;

            {
                this.f16653a = this;
                this.f16654b = charSequence;
            }

            @Override // android.view.MenuItem.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                try {
                    Intent intent = new Intent(this.f16653a.f16556b, Class.forName("ru.maximoff.apktool.service.LocalFileServerService"));
                    intent.setAction(LocalFileServerService.f17111a);
                    intent.putExtra("ru.maximoff.apktool.extra.PATH", this.f16654b);
                    if (Build.VERSION.SDK_INT >= 26) {
                        this.f16653a.f16556b.startForegroundService(intent);
                        return true;
                    }
                    this.f16653a.f16556b.startService(intent);
                    return true;
                } catch (ClassNotFoundException e3) {
                    throw new NoClassDefFoundError(e3.getMessage());
                }
            }
        });
        boolean m18925a = C3102bd.m18925a(this.f16556b, "remember_path", false);
        boolean m19664g = C3262u.m19664g(this.f16556b, new File(charSequence));
        m18715a.findItem(R.id.patcher).setVisible(m18031d != null);
        m18715a.findItem(R.id.main_project).setVisible(m18031d != null);
        m18715a.findItem(R.id.translate).setVisible(m18031d != null);
        m18715a.findItem(R.id.translate_smali).setVisible(m18031d != null);
        m18715a.findItem(R.id.translate_xml).setVisible(m18031d != null);
        m18715a.findItem(R.id.colors).setVisible(m18031d != null);
        m18715a.findItem(R.id.refresh_res).setVisible(m18031d != null);
        m18715a.findItem(R.id.mpatcher).setVisible(m18031d != null && C3262u.m19616a("ru.maximoff.sheller", this.f16556b.getPackageManager()));
        m18715a.findItem(R.id.set_as_output_directory).setVisible(m19664g);
        m18715a.findItem(R.id.search_res).setVisible(!this.f16567m.m19178b());
        m18715a.findItem(R.id.recent_files).setVisible(!this.f16569o.m19689c());
        m18715a.findItem(R.id.make_home).setVisible(!m18925a);
        if (this.f16568n.m19291a(charSequence)) {
            m18715a.findItem(R.id.bookmark_add).setVisible(false);
            m18715a.findItem(R.id.bookmark_remove).setVisible(true);
        } else {
            m18715a.findItem(R.id.bookmark_add).setVisible(true);
            m18715a.findItem(R.id.bookmark_remove).setVisible(false);
        }
        m18715a.findItem(R.id.cloning).setVisible(m18012a != null);
        m18715a.findItem(R.id.color_pipette).setVisible(Build.VERSION.SDK_INT >= 21);
    }

    /* compiled from: FilesPager.java */
    /* renamed from: ru.maximoff.apktool.fragment.b.k$15, reason: invalid class name */
    class AnonymousClass15 implements C3089au.a {

        /* renamed from: a */
        private final ViewOnClickListenerC2992k f16597a;

        /* renamed from: b */
        private final String f16598b;

        /* renamed from: c */
        private final boolean f16599c;

        /* renamed from: d */
        private final MainActivity f16600d;

        /* renamed from: e */
        private final String f16601e;

        /* renamed from: f */
        private final String f16602f;

        /* renamed from: g */
        private final String f16603g;

        /* renamed from: h */
        private final String f16604h;

        /* renamed from: i */
        private final String f16605i;

        AnonymousClass15(ViewOnClickListenerC2992k viewOnClickListenerC2992k, String str, boolean z, MainActivity mainActivity, String str2, String str3, String str4, String str5, String str6) {
            this.f16597a = viewOnClickListenerC2992k;
            this.f16598b = str;
            this.f16599c = z;
            this.f16600d = mainActivity;
            this.f16601e = str2;
            this.f16602f = str3;
            this.f16603g = str4;
            this.f16604h = str5;
            this.f16605i = str6;
        }

        /* renamed from: a */
        static ViewOnClickListenerC2992k m18042a(AnonymousClass15 anonymousClass15) {
            return anonymousClass15.f16597a;
        }

        @Override // ru.maximoff.apktool.util.C3089au.a
        /* renamed from: a */
        public void mo17670a(Context context, int i) {
            switch (i) {
                case R.id.sort /* 2131690219 */:
                    this.f16597a.m18034e(this.f16598b);
                    return;
                case R.id.filter /* 2131690220 */:
                    this.f16597a.f16564j.m17950f();
                    return;
                case R.id.translate /* 2131690221 */:
                    try {
                        Intent intent = new Intent(this.f16600d, Class.forName("ru.maximoff.apktool.TranslateActivity"));
                        intent.putExtra("data", this.f16601e);
                        intent.putExtra("smali", false);
                        this.f16600d.startActivityForResult(intent, 0);
                        return;
                    } catch (ClassNotFoundException e2) {
                        throw new NoClassDefFoundError(e2.getMessage());
                    }
                case R.id.translate_smali /* 2131690222 */:
                    this.f16597a.m17983a(this.f16600d, this.f16601e);
                    return;
                case R.id.translate_xml /* 2131690223 */:
                    try {
                        Intent intent2 = new Intent(this.f16600d, Class.forName("ru.maximoff.apktool.TranslateActivity"));
                        intent2.putExtra("data", this.f16601e);
                        intent2.putExtra(XMLConstants.XML_NS_PREFIX, true);
                        this.f16600d.startActivityForResult(intent2, 0);
                        return;
                    } catch (ClassNotFoundException e3) {
                        throw new NoClassDefFoundError(e3.getMessage());
                    }
                case R.id.colors /* 2131690224 */:
                    try {
                        Intent intent3 = new Intent(this.f16600d, Class.forName("ru.maximoff.apktool.ColorsEditor"));
                        intent3.putExtra("data", this.f16601e);
                        this.f16600d.startActivityForResult(intent3, 0);
                        return;
                    } catch (ClassNotFoundException e4) {
                        throw new NoClassDefFoundError(e4.getMessage());
                    }
                case R.id.refresh_res /* 2131690225 */:
                    List<String> m18324c = C3061a.m18324c(new File(new StringBuffer().append(this.f16601e).append("/res/values/public.xml").toString()));
                    if (m18324c.contains("id")) {
                        m18324c.remove("id");
                    }
                    ArrayList arrayList = new ArrayList();
                    boolean[] zArr = {false, false};
                    Button[] buttonArr = new Button[2];
                    DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(context).m418a(R.string.refresh_res).m432a(context.getResources().getStringArray(R.array.refresh_res), (boolean[]) null, new DialogInterface.OnMultiChoiceClickListener(this, zArr, buttonArr, m18324c) { // from class: ru.maximoff.apktool.fragment.b.k.15.3

                        /* renamed from: a */
                        private final AnonymousClass15 f16610a;

                        /* renamed from: b */
                        private final boolean[] f16611b;

                        /* renamed from: c */
                        private final Button[] f16612c;

                        /* renamed from: d */
                        private final List f16613d;

                        {
                            this.f16610a = this;
                            this.f16611b = zArr;
                            this.f16612c = buttonArr;
                            this.f16613d = m18324c;
                        }

                        @Override // android.content.DialogInterface.OnMultiChoiceClickListener
                        public void onClick(DialogInterface dialogInterface, int i2, boolean z) {
                            this.f16611b[i2] = z;
                            if (!this.f16611b[0] && !this.f16611b[1]) {
                                this.f16612c[0].setEnabled(false);
                            } else {
                                this.f16612c[0].setEnabled(true);
                            }
                            this.f16612c[1].setEnabled(this.f16611b[1] && !this.f16613d.isEmpty());
                        }
                    }).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, zArr, m18324c, arrayList, this.f16601e) { // from class: ru.maximoff.apktool.fragment.b.k.15.4

                        /* renamed from: a */
                        private final AnonymousClass15 f16614a;

                        /* renamed from: b */
                        private final boolean[] f16615b;

                        /* renamed from: c */
                        private final List f16616c;

                        /* renamed from: d */
                        private final List f16617d;

                        /* renamed from: e */
                        private final String f16618e;

                        {
                            this.f16614a = this;
                            this.f16615b = zArr;
                            this.f16616c = m18324c;
                            this.f16617d = arrayList;
                            this.f16618e = r5;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            dialogInterface.cancel();
                            if (this.f16615b[0] || this.f16615b[1]) {
                                AsyncTaskC2909ak asyncTaskC2909ak = new AsyncTaskC2909ak(AnonymousClass15.m18042a(this.f16614a).f16556b, AnonymousClass15.m18042a(this.f16614a).f16564j);
                                asyncTaskC2909ak.m17232g(this.f16615b[0]);
                                asyncTaskC2909ak.m17233h(this.f16615b[1]);
                                if (this.f16616c.size() != this.f16617d.size()) {
                                    asyncTaskC2909ak.m17229a(this.f16617d);
                                }
                                try {
                                    asyncTaskC2909ak.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new File(this.f16618e));
                                } catch (Exception e5) {
                                    C3112bn.m18999a(AnonymousClass15.m18042a(this.f16614a).f16556b, R.string.error_try_again);
                                }
                            }
                        }
                    }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.types, (DialogInterface.OnClickListener) null).m438b();
                    m438b.setOnShowListener(new AnonymousClass5(this, buttonArr, m438b, m18324c, arrayList));
                    m438b.show();
                    return;
                case R.id.cloning /* 2131690226 */:
                    this.f16597a.m18015a(context, this.f16603g, this.f16604h, this.f16605i, this.f16601e);
                    return;
                case R.id.patcher /* 2131690227 */:
                    if (!C3262u.m19616a("ru.maximoff.aepatcher", context.getPackageManager())) {
                        new DialogInterfaceC0070b.a(context).m418a(R.string.error).m433b(R.string.aeplugin_not_installed).m420a(R.string.mupdate_down, new DialogInterface.OnClickListener(this, context) { // from class: ru.maximoff.apktool.fragment.b.k.15.6

                            /* renamed from: a */
                            private final AnonymousClass15 f16643a;

                            /* renamed from: b */
                            private final Context f16644b;

                            {
                                this.f16643a = this;
                                this.f16644b = context;
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                dialogInterface.cancel();
                                C3080al.m18595e(this.f16644b, new StringBuffer().append(new StringBuffer().append("https://raw.githubusercontent.com/Maximoff/Apktool-M-updates/main/").append("files/AEPatcher.apk?t=").toString()).append(System.currentTimeMillis()).toString());
                            }
                        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
                        return;
                    } else {
                        new C2897a(context, this.f16601e, this.f16602f).m17016b();
                        return;
                    }
                case R.id.mpatcher /* 2131690228 */:
                    try {
                        Uri m19657e = C3262u.m19657e(context, new File(this.f16601e));
                        Intent intent4 = new Intent("android.intent.action.VIEW");
                        intent4.addCategory(Intent.CATEGORY_DEFAULT);
                        intent4.setPackage("ru.maximoff.sheller");
                        intent4.setDataAndType(m19657e, "application/ru.maximoff.sheller-patch");
                        intent4.putExtra("realPath", this.f16601e);
                        if (this.f16602f != null) {
                            intent4.putExtra("realApkPath", this.f16602f);
                        }
                        intent4.addFlags(268435459);
                        context.startActivity(intent4);
                        return;
                    } catch (Exception e5) {
                        C3112bn.m18999a(context, R.string.error);
                        return;
                    }
                case R.id.recent_files /* 2131690229 */:
                    this.f16597a.f16569o.m19684a();
                    return;
                case R.id.search_res /* 2131690230 */:
                    this.f16597a.f16567m.m19172a();
                    return;
                case R.id.make_home /* 2131690231 */:
                    C3102bd.m18937b(context, new StringBuffer().append("home_dir").append(this.f16597a.f16557c > 0 ? new StringBuffer().append("_").append(this.f16597a.f16557c).toString() : "").toString(), this.f16598b);
                    C3112bn.m19023b(context, context.getString(R.string.success));
                    if (Build.VERSION.SDK_INT >= 25) {
                        try {
                            new C3103be(context).m18955a();
                            return;
                        } catch (Exception e6) {
                            return;
                        }
                    }
                    return;
                case R.id.main_project /* 2131690232 */:
                    C3102bd.m18922a(this.f16599c ? "" : this.f16598b, context);
                    return;
                case R.id.set_as_output_directory /* 2131690233 */:
                    C3102bd.m18933b(context, this.f16598b);
                    C3112bn.m19023b(context, context.getString(R.string.success));
                    return;
                case R.id.bookmark_add /* 2131690234 */:
                    if (this.f16597a.f16568n.m19294b(this.f16598b)) {
                        C3112bn.m18999a(context, R.string.success);
                    } else {
                        C3112bn.m18999a(context, R.string.error);
                    }
                    this.f16597a.m18023a(this.f16597a.f16576v);
                    return;
                case R.id.bookmark_remove /* 2131690235 */:
                    if (this.f16597a.f16568n.m19297c(this.f16598b)) {
                        C3112bn.m18999a(context, R.string.success);
                    } else {
                        C3112bn.m18999a(context, R.string.error);
                    }
                    this.f16597a.m18023a(this.f16597a.f16576v);
                    return;
                case R.id.color_pipette /* 2131690236 */:
                    try {
                        Intent intent5 = new Intent(this.f16600d, Class.forName("ru.maximoff.apktool.ColorPipette"));
                        intent5.putExtra("data", this.f16598b);
                        this.f16600d.startActivityForResult(intent5, 0);
                        return;
                    } catch (ClassNotFoundException e7) {
                        throw new NoClassDefFoundError(e7.getMessage());
                    }
                case R.id.act_list /* 2131690237 */:
                    if (Build.VERSION.SDK_INT >= 33 && !C3102bd.m18925a(context, "accessibility_info", false)) {
                        new DialogInterfaceC0070b.a(context).m418a(R.string.attention).m433b(R.string.accessibility_info).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, context) { // from class: ru.maximoff.apktool.fragment.b.k.15.1

                            /* renamed from: a */
                            private final AnonymousClass15 f16606a;

                            /* renamed from: b */
                            private final Context f16607b;

                            {
                                this.f16606a = this;
                                this.f16607b = context;
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                C3102bd.m18938b(this.f16607b, "accessibility_info", true);
                                AnonymousClass15.m18042a(this.f16606a).m17980a(this.f16607b);
                                dialogInterface.cancel();
                            }
                        }).m440c(R.string.settings, new DialogInterface.OnClickListener(this, context) { // from class: ru.maximoff.apktool.fragment.b.k.15.2

                            /* renamed from: a */
                            private final AnonymousClass15 f16608a;

                            /* renamed from: b */
                            private final Context f16609b;

                            {
                                this.f16608a = this;
                                this.f16609b = context;
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                C3102bd.m18938b(this.f16609b, "accessibility_info", true);
                                C3080al.m18588c(this.f16609b, this.f16609b.getPackageName());
                                dialogInterface.cancel();
                            }
                        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
                        return;
                    } else {
                        this.f16597a.m17980a(context);
                        return;
                    }
                default:
                    return;
            }
        }

        /* compiled from: FilesPager.java */
        /* renamed from: ru.maximoff.apktool.fragment.b.k$15$5, reason: invalid class name */
        class AnonymousClass5 implements DialogInterface.OnShowListener {

            /* renamed from: a */
            private final AnonymousClass15 f16619a;

            /* renamed from: b */
            private final Button[] f16620b;

            /* renamed from: c */
            private final DialogInterfaceC0070b f16621c;

            /* renamed from: d */
            private final List f16622d;

            /* renamed from: e */
            private final List f16623e;

            AnonymousClass5(AnonymousClass15 anonymousClass15, Button[] buttonArr, DialogInterfaceC0070b dialogInterfaceC0070b, List list, List list2) {
                this.f16619a = anonymousClass15;
                this.f16620b = buttonArr;
                this.f16621c = dialogInterfaceC0070b;
                this.f16622d = list;
                this.f16623e = list2;
            }

            /* renamed from: a */
            static AnonymousClass15 m18043a(AnonymousClass5 anonymousClass5) {
                return anonymousClass5.f16619a;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f16620b[0] = this.f16621c.m414a(-1);
                this.f16620b[0].setEnabled(false);
                this.f16620b[1] = this.f16621c.m414a(-3);
                this.f16620b[1].setEnabled(false);
                this.f16620b[1].setOnClickListener(new View.OnClickListener(this, this.f16622d, this.f16623e) { // from class: ru.maximoff.apktool.fragment.b.k.15.5.1

                    /* renamed from: a */
                    private final AnonymousClass5 f16624a;

                    /* renamed from: b */
                    private final List f16625b;

                    /* renamed from: c */
                    private final List f16626c;

                    {
                        this.f16624a = this;
                        this.f16625b = r2;
                        this.f16626c = r3;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(AnonymousClass15.m18042a(AnonymousClass5.m18043a(this.f16624a)).f16556b).m418a(R.string.types).m432a((String[]) this.f16625b.toArray(new String[this.f16625b.size()]), (boolean[]) null, (DialogInterface.OnMultiChoiceClickListener) null).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, this.f16626c, this.f16625b) { // from class: ru.maximoff.apktool.fragment.b.k.15.5.1.1

                            /* renamed from: a */
                            private final AnonymousClass1 f16627a;

                            /* renamed from: b */
                            private final List f16628b;

                            /* renamed from: c */
                            private final List f16629c;

                            {
                                this.f16627a = this;
                                this.f16628b = r2;
                                this.f16629c = r3;
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface2, int i) {
                                this.f16628b.clear();
                                ListView m415a = ((DialogInterfaceC0070b) dialogInterface2).m415a();
                                int i2 = 0;
                                while (true) {
                                    int i3 = i2;
                                    if (i3 < m415a.getCount()) {
                                        if (m415a.isItemChecked(i3)) {
                                            this.f16628b.add((String) this.f16629c.get(i3));
                                        }
                                        i2 = i3 + 1;
                                    } else {
                                        dialogInterface2.cancel();
                                        return;
                                    }
                                }
                            }
                        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.mselect_inv, (DialogInterface.OnClickListener) null).m438b();
                        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, m438b, this.f16626c, this.f16625b) { // from class: ru.maximoff.apktool.fragment.b.k.15.5.1.2

                            /* renamed from: a */
                            private final AnonymousClass1 f16630a;

                            /* renamed from: b */
                            private final DialogInterfaceC0070b f16631b;

                            /* renamed from: c */
                            private final List f16632c;

                            /* renamed from: d */
                            private final List f16633d;

                            {
                                this.f16630a = this;
                                this.f16631b = m438b;
                                this.f16632c = r3;
                                this.f16633d = r4;
                            }

                            @Override // android.content.DialogInterface.OnShowListener
                            public void onShow(DialogInterface dialogInterface2) {
                                Button m414a = this.f16631b.m414a(-1);
                                m414a.setEnabled(true);
                                ListView m415a = this.f16631b.m415a();
                                for (int i = 0; i < m415a.getCount(); i++) {
                                    m415a.setItemChecked(i, this.f16632c.isEmpty() || this.f16632c.contains((String) this.f16633d.get(i)));
                                }
                                m415a.setOnItemClickListener(new AdapterView.OnItemClickListener(this, m415a, m414a) { // from class: ru.maximoff.apktool.fragment.b.k.15.5.1.2.1

                                    /* renamed from: a */
                                    private final AnonymousClass2 f16634a;

                                    /* renamed from: b */
                                    private final ListView f16635b;

                                    /* renamed from: c */
                                    private final Button f16636c;

                                    {
                                        this.f16634a = this;
                                        this.f16635b = m415a;
                                        this.f16636c = m414a;
                                    }

                                    @Override // android.widget.AdapterView.OnItemClickListener
                                    public void onItemClick(AdapterView<?> adapterView, View view2, int i2, long j) {
                                        for (int i3 = 0; i3 < this.f16635b.getCount(); i3++) {
                                            if (this.f16635b.isItemChecked(i3)) {
                                                this.f16636c.setEnabled(true);
                                                return;
                                            }
                                        }
                                        this.f16636c.setEnabled(false);
                                    }
                                });
                                Button m414a2 = this.f16631b.m414a(-3);
                                m414a2.setOnClickListener(new View.OnClickListener(this, m415a, m414a) { // from class: ru.maximoff.apktool.fragment.b.k.15.5.1.2.2

                                    /* renamed from: a */
                                    private final AnonymousClass2 f16637a;

                                    /* renamed from: b */
                                    private final ListView f16638b;

                                    /* renamed from: c */
                                    private final Button f16639c;

                                    {
                                        this.f16637a = this;
                                        this.f16638b = m415a;
                                        this.f16639c = m414a;
                                    }

                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        boolean z = false;
                                        for (int i2 = 0; i2 < this.f16638b.getCount(); i2++) {
                                            boolean isItemChecked = this.f16638b.isItemChecked(i2);
                                            this.f16638b.setItemChecked(i2, !isItemChecked);
                                            if (!isItemChecked) {
                                                z = true;
                                            }
                                        }
                                        this.f16639c.setEnabled(z);
                                    }
                                });
                                m414a2.setOnLongClickListener(new View.OnLongClickListener(this, m415a, m414a) { // from class: ru.maximoff.apktool.fragment.b.k.15.5.1.2.3

                                    /* renamed from: a */
                                    private final AnonymousClass2 f16640a;

                                    /* renamed from: b */
                                    private final ListView f16641b;

                                    /* renamed from: c */
                                    private final Button f16642c;

                                    {
                                        this.f16640a = this;
                                        this.f16641b = m415a;
                                        this.f16642c = m414a;
                                    }

                                    @Override // android.view.View.OnLongClickListener
                                    public boolean onLongClick(View view2) {
                                        for (int i2 = 0; i2 < this.f16641b.getCount(); i2++) {
                                            this.f16641b.setItemChecked(i2, true);
                                        }
                                        this.f16642c.setEnabled(true);
                                        return true;
                                    }
                                });
                            }
                        });
                        m438b.show();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m17996f(String str) {
        C3312n c3312n = new C3312n(this.f16556b, this.f16564j, this.f16565k, str);
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f16556b).m418a(R.string.storages_info).m435b(c3312n).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m438b();
        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, c3312n, m438b) { // from class: ru.maximoff.apktool.fragment.b.k.22

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16655a;

            /* renamed from: b */
            private final C3312n f16656b;

            /* renamed from: c */
            private final DialogInterfaceC0070b f16657c;

            {
                this.f16655a = this;
                this.f16656b = c3312n;
                this.f16657c = m438b;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f16656b.setDialog(this.f16657c);
                this.f16656b.m20014a();
            }
        });
        m438b.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17983a(MainActivity mainActivity, String str) {
        if (str == null) {
            C3112bn.m18999a(this.f16556b, R.string.error);
            return;
        }
        File[] listFiles = new File(str).listFiles(new FileFilter(this) { // from class: ru.maximoff.apktool.fragment.b.k.23

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16658a;

            {
                this.f16658a = this;
            }

            @Override // java.p209io.FileFilter
            public boolean accept(File file) {
                return file.isDirectory() && file.getName().startsWith("smali");
            }
        });
        if (listFiles == null || listFiles.length == 0) {
            C3112bn.m18999a(this.f16556b, R.string.not_found);
            return;
        }
        if (listFiles.length == 1) {
            try {
                Intent intent = new Intent(mainActivity, Class.forName("ru.maximoff.apktool.TranslateActivity"));
                intent.putExtra("data", str);
                intent.putExtra("smali", true);
                mainActivity.startActivityForResult(intent, 0);
                return;
            } catch (ClassNotFoundException e2) {
                throw new NoClassDefFoundError(e2.getMessage());
            }
        }
        Arrays.sort(listFiles);
        Button[] buttonArr = new Button[1];
        String[] strArr = new String[listFiles.length];
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].getName().equals("smali")) {
                strArr[i] = "classes.dex";
            } else {
                strArr[i] = new StringBuffer().append(listFiles[i].getName().substring(6)).append(".dex").toString();
            }
        }
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f16556b).m418a(R.string.mtr_trans_smali).m432a(strArr, (boolean[]) null, (DialogInterface.OnMultiChoiceClickListener) null).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, strArr, mainActivity, str) { // from class: ru.maximoff.apktool.fragment.b.k.24

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16659a;

            /* renamed from: b */
            private final String[] f16660b;

            /* renamed from: c */
            private final MainActivity f16661c;

            /* renamed from: d */
            private final String f16662d;

            {
                this.f16659a = this;
                this.f16660b = strArr;
                this.f16661c = mainActivity;
                this.f16662d = str;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                ArrayList arrayList = new ArrayList();
                ListView m415a = ((DialogInterfaceC0070b) dialogInterface).m415a();
                for (int i3 = 0; i3 < m415a.getCount(); i3++) {
                    if (m415a.isItemChecked(i3)) {
                        if (this.f16660b[i3].equals("classes.dex")) {
                            arrayList.add("smali");
                        } else {
                            arrayList.add(new StringBuffer().append("smali_").append(this.f16660b[i3].substring(0, this.f16660b[i3].length() - 4)).toString());
                        }
                    }
                }
                try {
                    Intent intent2 = new Intent(this.f16661c, Class.forName("ru.maximoff.apktool.TranslateActivity"));
                    intent2.putExtra("data", this.f16662d);
                    intent2.putExtra("smali", true);
                    intent2.putExtra("smali_dirs", (String[]) arrayList.toArray(new String[arrayList.size()]));
                    this.f16661c.startActivityForResult(intent2, 0);
                    dialogInterface.cancel();
                } catch (ClassNotFoundException e3) {
                    throw new NoClassDefFoundError(e3.getMessage());
                }
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.mselect_inv, (DialogInterface.OnClickListener) null).m438b();
        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, buttonArr, m438b) { // from class: ru.maximoff.apktool.fragment.b.k.25

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16663a;

            /* renamed from: b */
            private final Button[] f16664b;

            /* renamed from: c */
            private final DialogInterfaceC0070b f16665c;

            {
                this.f16663a = this;
                this.f16664b = buttonArr;
                this.f16665c = m438b;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f16664b[0] = this.f16665c.m414a(-1);
                this.f16664b[0].setEnabled(true);
                ListView m415a = this.f16665c.m415a();
                for (int i2 = 0; i2 < m415a.getCount(); i2++) {
                    m415a.setItemChecked(i2, true);
                }
                m415a.setOnItemClickListener(new AdapterView.OnItemClickListener(this, m415a, this.f16664b) { // from class: ru.maximoff.apktool.fragment.b.k.25.1

                    /* renamed from: a */
                    private final AnonymousClass25 f16666a;

                    /* renamed from: b */
                    private final ListView f16667b;

                    /* renamed from: c */
                    private final Button[] f16668c;

                    {
                        this.f16666a = this;
                        this.f16667b = m415a;
                        this.f16668c = r3;
                    }

                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                        for (int i4 = 0; i4 < this.f16667b.getCount(); i4++) {
                            if (this.f16667b.isItemChecked(i4)) {
                                this.f16668c[0].setEnabled(true);
                                return;
                            }
                        }
                        this.f16668c[0].setEnabled(false);
                    }
                });
                Button m414a = this.f16665c.m414a(-3);
                m414a.setOnClickListener(new View.OnClickListener(this, m415a, this.f16664b) { // from class: ru.maximoff.apktool.fragment.b.k.25.2

                    /* renamed from: a */
                    private final AnonymousClass25 f16669a;

                    /* renamed from: b */
                    private final ListView f16670b;

                    /* renamed from: c */
                    private final Button[] f16671c;

                    {
                        this.f16669a = this;
                        this.f16670b = m415a;
                        this.f16671c = r3;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        boolean z = false;
                        for (int i3 = 0; i3 < this.f16670b.getCount(); i3++) {
                            boolean isItemChecked = this.f16670b.isItemChecked(i3);
                            this.f16670b.setItemChecked(i3, !isItemChecked);
                            if (!isItemChecked) {
                                z = true;
                            }
                        }
                        this.f16671c[0].setEnabled(z);
                    }
                });
                m414a.setOnLongClickListener(new View.OnLongClickListener(this, m415a, this.f16664b) { // from class: ru.maximoff.apktool.fragment.b.k.25.3

                    /* renamed from: a */
                    private final AnonymousClass25 f16672a;

                    /* renamed from: b */
                    private final ListView f16673b;

                    /* renamed from: c */
                    private final Button[] f16674c;

                    {
                        this.f16672a = this;
                        this.f16673b = m415a;
                        this.f16674c = r3;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        for (int i3 = 0; i3 < this.f16673b.getCount(); i3++) {
                            this.f16673b.setItemChecked(i3, true);
                        }
                        this.f16674c[0].setEnabled(true);
                        return true;
                    }
                });
            }
        });
        m438b.show();
    }

    /* renamed from: g */
    private String m17997g(String str) {
        if (str == null) {
            return (String) null;
        }
        File file = new File(new StringBuffer().append(str).append("/apktool.json").toString());
        if (file.isFile()) {
            C2468c c2468c = new C2468c(C3061a.m18332i(file));
            if (c2468c.m15618g("apkFilePath")) {
                return c2468c.m15617f("apkFilePath");
            }
        }
        return (String) null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17980a(Context context) {
        try {
            Intent intent = new Intent(context, Class.forName("ru.maximoff.apktool.service.ActivityDetectingService"));
            intent.setAction("ru.maximoff.apktool.AccessibilityService.START");
            context.startService(intent);
            try {
                try {
                    if (!C3080al.m18563a(context, (Class<? extends AccessibilityService>) Class.forName("ru.maximoff.apktool.service.ActivityDetectingService"))) {
                        C3112bn.m18999a(context, R.string.accessibility_service_toast);
                        Intent intent2 = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                        intent2.addFlags(268435456);
                        context.startActivity(intent2);
                    }
                } catch (Exception e2) {
                    C3112bn.m18999a(context, R.string.error);
                    try {
                        Intent intent3 = new Intent(context, Class.forName("ru.maximoff.apktool.service.ActivityDetectingService"));
                        intent3.setAction("ru.maximoff.apktool.AccessibilityService.STOP");
                        context.startService(intent3);
                    } catch (ClassNotFoundException e3) {
                        throw new NoClassDefFoundError(e3.getMessage());
                    }
                }
            } catch (ClassNotFoundException e4) {
                throw new NoClassDefFoundError(e4.getMessage());
            }
        } catch (ClassNotFoundException e5) {
            throw new NoClassDefFoundError(e5.getMessage());
        }
    }

    /* renamed from: a */
    public void m18015a(Context context, String str, String str2, String str3, String str4) {
        ImageView imageView;
        EditText editText;
        View view;
        Bitmap m18377a;
        LayoutInflater from = LayoutInflater.from(this.f16556b);
        String[] strArr = {(String) null};
        if (str3 != null) {
            int m18574b = C3080al.m18574b(this.f16556b, 64);
            Bitmap[] bitmapArr = {(Bitmap) null, (Bitmap) null};
            if (str3.endsWith(".xml")) {
                C3066aa c3066aa = new C3066aa(this.f16556b);
                C3099ba c3099ba = new C3099ba(this.f16556b, str3);
                if (c3099ba != null && c3099ba.m18881j()) {
                    try {
                        m18377a = C3067ab.m18378a(c3099ba.m18882k(), 192, 192);
                        bitmapArr[0] = m18377a;
                        bitmapArr[1] = m18377a;
                    } catch (Exception e2) {
                        Bitmap m18363a = c3066aa.m18363a(Color.GRAY, R.drawable.ic_damage_dark);
                        bitmapArr[0] = (Bitmap) null;
                        bitmapArr[1] = (Bitmap) null;
                        m18377a = m18363a;
                    }
                } else {
                    Bitmap m18363a2 = c3066aa.m18363a(Color.GRAY, R.drawable.ic_damage_dark);
                    bitmapArr[0] = (Bitmap) null;
                    bitmapArr[1] = (Bitmap) null;
                    m18377a = m18363a2;
                }
            } else {
                try {
                    m18377a = C3067ab.m18377a(str3, 192);
                    bitmapArr[0] = m18377a;
                    bitmapArr[1] = m18377a;
                } catch (Exception e3) {
                    C3112bn.m18999a(this.f16556b, R.string.error);
                    return;
                }
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f16556b.getResources(), m18377a);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(m18574b, m18574b);
            imageView = new ImageView(this.f16556b);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setAdjustViewBounds(true);
            imageView.setImageDrawable(bitmapDrawable);
            imageView.setClickable(true);
            imageView.setFocusable(true);
            imageView.setContentDescription(this.f16556b.getString(R.string.mapp_icon));
            imageView.setOnClickListener(new AnonymousClass26(this, 192, bitmapArr, imageView, strArr));
            imageView.setOnLongClickListener(new AnonymousClass27(this, bitmapArr, imageView, strArr, str3, 192, bitmapDrawable));
        } else {
            imageView = (ImageView) null;
        }
        if (str2 != null) {
            view = from.inflate(R.layout.rename_one, (ViewGroup) null);
            EditText editText2 = (EditText) view.findViewById(R.id.renameoneEditText1);
            editText2.setSingleLine(true);
            editText2.setText(str2);
            editText2.setHint(str2);
            TextView textView = (TextView) view.findViewById(R.id.renameoneTextView1);
            C3112bn.m19009a(textView, context.getString(R.string.originalf, str2));
            textView.setOnClickListener(new View.OnClickListener(this, editText2, str2) { // from class: ru.maximoff.apktool.fragment.b.k.28

                /* renamed from: a */
                private final ViewOnClickListenerC2992k f16720a;

                /* renamed from: b */
                private final EditText f16721b;

                /* renamed from: c */
                private final String f16722c;

                {
                    this.f16720a = this;
                    this.f16721b = editText2;
                    this.f16722c = str2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    this.f16721b.setText(this.f16722c);
                    this.f16721b.setSelection(this.f16722c.length());
                    this.f16721b.requestFocus();
                }
            });
            textView.setOnLongClickListener(new View.OnLongClickListener(this, context, str2) { // from class: ru.maximoff.apktool.fragment.b.k.29

                /* renamed from: a */
                private final ViewOnClickListenerC2992k f16723a;

                /* renamed from: b */
                private final Context f16724b;

                /* renamed from: c */
                private final String f16725c;

                {
                    this.f16723a = this;
                    this.f16724b = context;
                    this.f16725c = str2;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    C3112bn.m19002a(this.f16724b, this.f16725c);
                    return true;
                }
            });
            editText = editText2;
        } else {
            editText = (EditText) null;
            view = (View) null;
        }
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -2);
        ScrollView scrollView = new ScrollView(this.f16556b);
        scrollView.setLayoutParams(layoutParams2);
        LinearLayout linearLayout = new LinearLayout(this.f16556b);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        linearLayout.setLayoutParams(layoutParams2);
        scrollView.addView(linearLayout, layoutParams2);
        if (imageView != null) {
            linearLayout.addView(imageView);
        }
        if (view != null) {
            linearLayout.addView(view, layoutParams2);
        }
        View inflate = from.inflate(R.layout.rename_one, (ViewGroup) null);
        EditText editText3 = (EditText) inflate.findViewById(R.id.renameoneEditText1);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.renameoneImageView1);
        if (C3102bd.f18291a) {
            imageView2.setImageResource(R.drawable.ic_reload);
        } else {
            imageView2.setImageResource(R.drawable.ic_reload_dark);
        }
        imageView2.setVisibility(0);
        imageView2.setContentDescription(this.f16556b.getString(R.string.kill_sign_rand));
        String m19043r = C3112bn.m19043r(str);
        imageView2.setOnClickListener(new View.OnClickListener(this, str, editText3) { // from class: ru.maximoff.apktool.fragment.b.k.30

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16728a;

            /* renamed from: b */
            private final String f16729b;

            /* renamed from: c */
            private final EditText f16730c;

            {
                this.f16728a = this;
                this.f16729b = str;
                this.f16730c = editText3;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String m19042q = C3112bn.m19042q(this.f16729b);
                this.f16730c.setText(m19042q);
                this.f16730c.setSelection(m19042q.length());
            }
        });
        imageView2.setOnLongClickListener(new View.OnLongClickListener(this, editText3, m19043r) { // from class: ru.maximoff.apktool.fragment.b.k.31

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16731a;

            /* renamed from: b */
            private final EditText f16732b;

            /* renamed from: c */
            private final String f16733c;

            {
                this.f16731a = this;
                this.f16732b = editText3;
                this.f16733c = m19043r;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                this.f16732b.setText(this.f16733c);
                this.f16732b.setSelection(this.f16733c.length());
                return true;
            }
        });
        editText3.setSingleLine(true);
        editText3.setText(m19043r);
        editText3.setHint(str);
        TextView textView2 = (TextView) inflate.findViewById(R.id.renameoneTextView1);
        C3112bn.m19009a(textView2, context.getString(R.string.originalf, str));
        textView2.setOnClickListener(new View.OnClickListener(this, editText3, str) { // from class: ru.maximoff.apktool.fragment.b.k.32

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16734a;

            /* renamed from: b */
            private final EditText f16735b;

            /* renamed from: c */
            private final String f16736c;

            {
                this.f16734a = this;
                this.f16735b = editText3;
                this.f16736c = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                this.f16735b.setText(this.f16736c);
                this.f16735b.setSelection(this.f16736c.length());
                this.f16735b.requestFocus();
            }
        });
        textView2.setOnLongClickListener(new View.OnLongClickListener(this, context, str) { // from class: ru.maximoff.apktool.fragment.b.k.33

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16737a;

            /* renamed from: b */
            private final Context f16738b;

            /* renamed from: c */
            private final String f16739c;

            {
                this.f16737a = this;
                this.f16738b = context;
                this.f16739c = str;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                C3112bn.m19002a(this.f16738b, this.f16739c);
                return true;
            }
        });
        linearLayout.addView(inflate, layoutParams2);
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(context).m435b(scrollView).m418a(R.string.cloning).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, str2, editText, editText3, str, strArr, context, str4) { // from class: ru.maximoff.apktool.fragment.b.k.34

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16740a;

            /* renamed from: b */
            private final String f16741b;

            /* renamed from: c */
            private final EditText f16742c;

            /* renamed from: d */
            private final EditText f16743d;

            /* renamed from: e */
            private final String f16744e;

            /* renamed from: f */
            private final String[] f16745f;

            /* renamed from: g */
            private final Context f16746g;

            /* renamed from: h */
            private final String f16747h;

            {
                this.f16740a = this;
                this.f16741b = str2;
                this.f16742c = editText;
                this.f16743d = editText3;
                this.f16744e = str;
                this.f16745f = strArr;
                this.f16746g = context;
                this.f16747h = str4;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                String str5;
                dialogInterface.cancel();
                if (this.f16741b != null && this.f16742c != null) {
                    String editable = this.f16742c.getText().toString();
                    if (this.f16741b.equals(editable)) {
                        editable = (String) null;
                    }
                    str5 = editable;
                } else {
                    str5 = (String) null;
                }
                String trim = this.f16743d.getText().toString().trim();
                if (trim.equals(this.f16744e)) {
                    trim = (String) null;
                }
                if (str5 == null && trim == null && this.f16745f[0] == null) {
                    C3112bn.m19023b(this.f16746g, this.f16746g.getString(R.string.errorf, this.f16740a.f16556b.getString(R.string.data_unchanged)));
                } else {
                    new AsyncTaskC2935f(this.f16746g, this.f16740a.f16564j, this.f16744e, trim, this.f16741b, str5, this.f16745f[0]).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new File(this.f16747h));
                }
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.paste, (DialogInterface.OnClickListener) null).m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, m438b, context, editText, editText3) { // from class: ru.maximoff.apktool.fragment.b.k.35

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16748a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f16749b;

            /* renamed from: c */
            private final Context f16750c;

            /* renamed from: d */
            private final EditText f16751d;

            /* renamed from: e */
            private final EditText f16752e;

            {
                this.f16748a = this;
                this.f16749b = m438b;
                this.f16750c = context;
                this.f16751d = editText;
                this.f16752e = editText3;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f16749b.m414a(-3).setOnClickListener(new View.OnClickListener(this, this.f16750c, this.f16751d, this.f16752e) { // from class: ru.maximoff.apktool.fragment.b.k.35.1

                    /* renamed from: a */
                    private final AnonymousClass35 f16753a;

                    /* renamed from: b */
                    private final Context f16754b;

                    /* renamed from: c */
                    private final EditText f16755c;

                    /* renamed from: d */
                    private final EditText f16756d;

                    {
                        this.f16753a = this;
                        this.f16754b = r2;
                        this.f16755c = r3;
                        this.f16756d = r4;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        String m18991a = C3112bn.m18991a(this.f16754b);
                        if (m18991a != null) {
                            if (this.f16755c != null && this.f16755c.isFocused()) {
                                C3112bn.m19007a(this.f16755c, (CharSequence) m18991a);
                                return;
                            } else {
                                C3112bn.m19007a(this.f16756d, (CharSequence) m18991a);
                                return;
                            }
                        }
                        C3112bn.m18999a(this.f16754b, R.string.empty);
                    }
                });
                this.f16752e.requestFocus();
                this.f16752e.setSelection(this.f16752e.getText().length());
            }
        });
        m438b.show();
        editText3.addTextChangedListener(new TextWatcher(this, m438b.m414a(-1)) { // from class: ru.maximoff.apktool.fragment.b.k.36

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16757a;

            /* renamed from: b */
            private final Button f16758b;

            {
                this.f16757a = this;
                this.f16758b = r2;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                try {
                    C3112bn.m19004a(editable, (Class<? extends CharacterStyle>) Class.forName("android.text.style.ForegroundColorSpan"));
                    if (editable.length() == 0) {
                        this.f16758b.setEnabled(false);
                        return;
                    }
                    String trim = editable.toString().trim();
                    if (trim.startsWith(".") || trim.endsWith(".") || trim.indexOf(".") == -1) {
                        this.f16758b.setEnabled(false);
                    } else if (trim.length() > 127 || !trim.matches("^[a-zA-Z0-9\\._]+$")) {
                        editable.setSpan(new ForegroundColorSpan(Color.RED), 0, editable.length(), 33);
                        this.f16758b.setEnabled(false);
                    } else {
                        this.f16758b.setEnabled(true);
                    }
                } catch (ClassNotFoundException e4) {
                    throw new NoClassDefFoundError(e4.getMessage());
                }
            }
        });
    }

    /* compiled from: FilesPager.java */
    /* renamed from: ru.maximoff.apktool.fragment.b.k$26, reason: invalid class name */
    class AnonymousClass26 implements View.OnClickListener {

        /* renamed from: a */
        private final ViewOnClickListenerC2992k f16675a;

        /* renamed from: b */
        private final int f16676b;

        /* renamed from: c */
        private final Bitmap[] f16677c;

        /* renamed from: d */
        private final ImageView f16678d;

        /* renamed from: e */
        private final String[] f16679e;

        AnonymousClass26(ViewOnClickListenerC2992k viewOnClickListenerC2992k, int i, Bitmap[] bitmapArr, ImageView imageView, String[] strArr) {
            this.f16675a = viewOnClickListenerC2992k;
            this.f16676b = i;
            this.f16677c = bitmapArr;
            this.f16678d = imageView;
            this.f16679e = strArr;
        }

        /* renamed from: a */
        static ViewOnClickListenerC2992k m18044a(AnonymousClass26 anonymousClass26) {
            return anonymousClass26.f16675a;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C3261t c3261t = new C3261t(this.f16675a.f16556b);
            Runnable runnable = new Runnable(this, c3261t, this.f16676b, this.f16677c, this.f16678d, this.f16679e) { // from class: ru.maximoff.apktool.fragment.b.k.26.1

                /* renamed from: a */
                private final AnonymousClass26 f16680a;

                /* renamed from: b */
                private final C3261t f16681b;

                /* renamed from: c */
                private final int f16682c;

                /* renamed from: d */
                private final Bitmap[] f16683d;

                /* renamed from: e */
                private final ImageView f16684e;

                /* renamed from: f */
                private final String[] f16685f;

                {
                    this.f16680a = this;
                    this.f16681b = c3261t;
                    this.f16682c = r3;
                    this.f16683d = r4;
                    this.f16684e = r5;
                    this.f16685f = r6;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Bitmap m18377a = C3067ab.m18377a(this.f16681b.getPath(), 192);
                        if (this.f16683d[0] == null) {
                            this.f16683d[0] = m18377a;
                        }
                        this.f16683d[1] = m18377a;
                        this.f16684e.setImageDrawable(new BitmapDrawable(AnonymousClass26.m18044a(this.f16680a).f16556b.getResources(), m18377a));
                        this.f16685f[0] = this.f16681b.getPath();
                    } catch (Exception e2) {
                        C3112bn.m18999a(AnonymousClass26.m18044a(this.f16680a).f16556b, R.string.error);
                    }
                }
            };
            c3261t.m19545a("_cloner");
            c3261t.setCallback(runnable);
            c3261t.setFilter(new String[]{"gif", "png", "jpg", "jpeg", "bmp", "webp"});
            c3261t.m19550e();
            DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(this.f16675a.f16556b);
            aVar.m427a(c3261t.m19548c());
            aVar.m435b(c3261t);
            aVar.m420a(R.string.cancel, (DialogInterface.OnClickListener) null);
            aVar.m437b("/...", (DialogInterface.OnClickListener) null);
            aVar.m429a(false);
            aVar.m422a(new DialogInterface.OnKeyListener(this, c3261t) { // from class: ru.maximoff.apktool.fragment.b.k.26.2

                /* renamed from: a */
                private final AnonymousClass26 f16686a;

                /* renamed from: b */
                private final C3261t f16687b;

                {
                    this.f16686a = this;
                    this.f16687b = c3261t;
                }

                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                        return false;
                    }
                    boolean m19551f = this.f16687b.m19551f();
                    if (!m19551f) {
                        dialogInterface.dismiss();
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

        /* compiled from: FilesPager.java */
        /* renamed from: ru.maximoff.apktool.fragment.b.k$26$3, reason: invalid class name */
        class AnonymousClass3 implements DialogInterface.OnShowListener {

            /* renamed from: a */
            private final AnonymousClass26 f16688a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f16689b;

            /* renamed from: c */
            private final C3261t f16690c;

            AnonymousClass3(AnonymousClass26 anonymousClass26, DialogInterfaceC0070b dialogInterfaceC0070b, C3261t c3261t) {
                this.f16688a = anonymousClass26;
                this.f16689b = dialogInterfaceC0070b;
                this.f16690c = c3261t;
            }

            /* renamed from: a */
            static AnonymousClass26 m18045a(AnonymousClass3 anonymousClass3) {
                return anonymousClass3.f16688a;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                Button m414a = this.f16689b.m414a(-3);
                m414a.setOnClickListener(new View.OnClickListener(this, this.f16690c) { // from class: ru.maximoff.apktool.fragment.b.k.26.3.1

                    /* renamed from: a */
                    private final AnonymousClass3 f16691a;

                    /* renamed from: b */
                    private final C3261t f16692b;

                    {
                        this.f16691a = this;
                        this.f16692b = r2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        int i;
                        String[] m19640b = C3262u.m19640b(AnonymousClass26.m18044a(AnonymousClass3.m18045a(this.f16691a)).f16556b);
                        if (m19640b != null) {
                            C0173ao c0173ao = new C0173ao(AnonymousClass26.m18044a(AnonymousClass3.m18045a(this.f16691a)).f16556b, view);
                            if (C3102bd.m18910a(AnonymousClass26.m18044a(AnonymousClass3.m18045a(this.f16691a)).f16556b, "menu_position", "1").equals("0")) {
                                i = 3;
                            } else {
                                i = 5;
                            }
                            c0173ao.m1340a(i);
                            for (int i2 = 0; i2 < m19640b.length; i2++) {
                                c0173ao.m1339a().add(0, i2 + MediaCodec.CodecException.ERROR_INSUFFICIENT_RESOURCE, 0, m19640b[i2]).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f16692b) { // from class: ru.maximoff.apktool.fragment.b.k.26.3.1.1

                                    /* renamed from: a */
                                    private final AnonymousClass1 f16693a;

                                    /* renamed from: b */
                                    private final C3261t f16694b;

                                    {
                                        this.f16693a = this;
                                        this.f16694b = r2;
                                    }

                                    @Override // android.view.MenuItem.OnMenuItemClickListener
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        this.f16694b.m19544a(new File(menuItem.getTitle().toString()));
                                        return true;
                                    }
                                });
                            }
                            c0173ao.m1344c();
                        }
                    }
                });
                m414a.setOnLongClickListener(new View.OnLongClickListener(this, this.f16690c) { // from class: ru.maximoff.apktool.fragment.b.k.26.3.2

                    /* renamed from: a */
                    private final AnonymousClass3 f16695a;

                    /* renamed from: b */
                    private final C3261t f16696b;

                    {
                        this.f16695a = this;
                        this.f16696b = r2;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        int i;
                        List<String> m19205b = this.f16696b.m19549d().m19205b();
                        if (m19205b.isEmpty()) {
                            return false;
                        }
                        C0173ao c0173ao = new C0173ao(AnonymousClass26.m18044a(AnonymousClass3.m18045a(this.f16695a)).f16556b, view);
                        if (C3102bd.m18910a(AnonymousClass26.m18044a(AnonymousClass3.m18045a(this.f16695a)).f16556b, "menu_position", "1").equals("0")) {
                            i = 3;
                        } else {
                            i = 5;
                        }
                        c0173ao.m1340a(i);
                        Iterator<String> it = m19205b.iterator();
                        while (it.hasNext()) {
                            c0173ao.m1339a().add(0, 1300, 0, it.next()).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f16696b) { // from class: ru.maximoff.apktool.fragment.b.k.26.3.2.1

                                /* renamed from: a */
                                private final AnonymousClass2 f16697a;

                                /* renamed from: b */
                                private final C3261t f16698b;

                                {
                                    this.f16697a = this;
                                    this.f16698b = r2;
                                }

                                @Override // android.view.MenuItem.OnMenuItemClickListener
                                public boolean onMenuItemClick(MenuItem menuItem) {
                                    this.f16698b.m19544a(new File(menuItem.getTitle().toString()));
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

    /* compiled from: FilesPager.java */
    /* renamed from: ru.maximoff.apktool.fragment.b.k$27, reason: invalid class name */
    class AnonymousClass27 implements View.OnLongClickListener {

        /* renamed from: a */
        private final ViewOnClickListenerC2992k f16699a;

        /* renamed from: b */
        private final Bitmap[] f16700b;

        /* renamed from: c */
        private final ImageView f16701c;

        /* renamed from: d */
        private final String[] f16702d;

        /* renamed from: e */
        private final String f16703e;

        /* renamed from: f */
        private final int f16704f;

        /* renamed from: g */
        private final BitmapDrawable f16705g;

        AnonymousClass27(ViewOnClickListenerC2992k viewOnClickListenerC2992k, Bitmap[] bitmapArr, ImageView imageView, String[] strArr, String str, int i, BitmapDrawable bitmapDrawable) {
            this.f16699a = viewOnClickListenerC2992k;
            this.f16700b = bitmapArr;
            this.f16701c = imageView;
            this.f16702d = strArr;
            this.f16703e = str;
            this.f16704f = i;
            this.f16705g = bitmapDrawable;
        }

        /* renamed from: a */
        static ViewOnClickListenerC2992k m18046a(AnonymousClass27 anonymousClass27) {
            return anonymousClass27.f16699a;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            int i;
            if (this.f16700b[0] != null) {
                C0173ao c0173ao = new C0173ao(this.f16699a.f16556b, view);
                if (C3102bd.m18910a(this.f16699a.f16556b, "menu_position", "1").equals("0")) {
                    i = 3;
                } else {
                    i = 5;
                }
                c0173ao.m1340a(i);
                c0173ao.m1339a().add(0, 1400, 0, this.f16699a.f16556b.getString(R.string.invert_color)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f16700b, this.f16701c, this.f16702d) { // from class: ru.maximoff.apktool.fragment.b.k.27.1

                    /* renamed from: a */
                    private final AnonymousClass27 f16706a;

                    /* renamed from: b */
                    private final Bitmap[] f16707b;

                    /* renamed from: c */
                    private final ImageView f16708c;

                    /* renamed from: d */
                    private final String[] f16709d;

                    {
                        this.f16706a = this;
                        this.f16707b = r2;
                        this.f16708c = r3;
                        this.f16709d = r4;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        try {
                            File createTempFile = File.createTempFile("AM_ClonerInv_", ".png", C3102bd.m18908a());
                            Bitmap m18395c = C3067ab.m18395c(this.f16707b[1]);
                            C3067ab.m18383a(m18395c, createTempFile);
                            this.f16707b[1] = m18395c;
                            this.f16708c.setImageDrawable(new BitmapDrawable(AnonymousClass27.m18046a(this.f16706a).f16556b.getResources(), m18395c));
                            this.f16709d[0] = createTempFile.getAbsolutePath();
                        } catch (Exception e2) {
                            C3112bn.m18999a(AnonymousClass27.m18046a(this.f16706a).f16556b, R.string.error);
                        }
                        return true;
                    }
                });
                c0173ao.m1339a().add(0, 1401, 0, this.f16699a.f16556b.getString(R.string.monochrome)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f16700b, this.f16701c, this.f16702d) { // from class: ru.maximoff.apktool.fragment.b.k.27.2

                    /* renamed from: a */
                    private final AnonymousClass27 f16710a;

                    /* renamed from: b */
                    private final Bitmap[] f16711b;

                    /* renamed from: c */
                    private final ImageView f16712c;

                    /* renamed from: d */
                    private final String[] f16713d;

                    {
                        this.f16710a = this;
                        this.f16711b = r2;
                        this.f16712c = r3;
                        this.f16713d = r4;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        try {
                            File createTempFile = File.createTempFile("AM_ClonerMono_", ".png", C3102bd.m18908a());
                            Bitmap m18397d = C3067ab.m18397d(this.f16711b[1]);
                            C3067ab.m18383a(m18397d, createTempFile);
                            this.f16711b[1] = m18397d;
                            this.f16712c.setImageDrawable(new BitmapDrawable(AnonymousClass27.m18046a(this.f16710a).f16556b.getResources(), m18397d));
                            this.f16713d[0] = createTempFile.getAbsolutePath();
                        } catch (Exception e2) {
                            C3112bn.m18999a(AnonymousClass27.m18046a(this.f16710a).f16556b, R.string.error);
                        }
                        return true;
                    }
                });
                c0173ao.m1339a().add(0, 1402, 0, this.f16699a.f16556b.getString(R.string.search_reset)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f16703e, this.f16704f, this.f16700b, this.f16701c, this.f16702d) { // from class: ru.maximoff.apktool.fragment.b.k.27.3

                    /* renamed from: a */
                    private final AnonymousClass27 f16714a;

                    /* renamed from: b */
                    private final String f16715b;

                    /* renamed from: c */
                    private final int f16716c;

                    /* renamed from: d */
                    private final Bitmap[] f16717d;

                    /* renamed from: e */
                    private final ImageView f16718e;

                    /* renamed from: f */
                    private final String[] f16719f;

                    {
                        this.f16714a = this;
                        this.f16715b = r2;
                        this.f16716c = r3;
                        this.f16717d = r4;
                        this.f16718e = r5;
                        this.f16719f = r6;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Bitmap m18377a;
                        if (this.f16715b.endsWith(".xml")) {
                            C3066aa c3066aa = new C3066aa(AnonymousClass27.m18046a(this.f16714a).f16556b);
                            C3099ba c3099ba = new C3099ba(AnonymousClass27.m18046a(this.f16714a).f16556b, this.f16715b);
                            if (c3099ba != null && c3099ba.m18881j()) {
                                try {
                                    m18377a = C3067ab.m18378a(c3099ba.m18882k(), 192, 192);
                                    this.f16717d[0] = m18377a;
                                    this.f16717d[1] = m18377a;
                                } catch (Exception e2) {
                                    Bitmap m18363a = c3066aa.m18363a(Color.GRAY, R.drawable.ic_damage_dark);
                                    this.f16717d[0] = (Bitmap) null;
                                    this.f16717d[1] = (Bitmap) null;
                                    m18377a = m18363a;
                                }
                            } else {
                                Bitmap m18363a2 = c3066aa.m18363a(Color.GRAY, R.drawable.ic_damage_dark);
                                this.f16717d[0] = (Bitmap) null;
                                this.f16717d[1] = (Bitmap) null;
                                m18377a = m18363a2;
                            }
                        } else {
                            try {
                                m18377a = C3067ab.m18377a(this.f16715b, 192);
                                this.f16717d[0] = m18377a;
                                this.f16717d[1] = m18377a;
                            } catch (Exception e3) {
                                C3112bn.m18999a(AnonymousClass27.m18046a(this.f16714a).f16556b, R.string.error);
                            }
                        }
                        this.f16718e.setImageDrawable(new BitmapDrawable(AnonymousClass27.m18046a(this.f16714a).f16556b.getResources(), m18377a));
                        this.f16719f[0] = (String) null;
                        return true;
                    }
                });
                c0173ao.m1344c();
                return true;
            }
            this.f16701c.setImageDrawable(this.f16705g);
            this.f16702d[0] = (String) null;
            return true;
        }
    }

    /* renamed from: a */
    public String m18012a(String str) {
        if (str == null) {
            return (String) null;
        }
        File file = new File(new StringBuffer().append(str).append("/AndroidManifest.xml").toString());
        if (!file.exists() || !file.isFile() || !file.getParentFile().canWrite()) {
            return (String) null;
        }
        Matcher matcher = Pattern.compile("<manifest[^>]+\\spackage=\"([^\"]+)\"").matcher(C3061a.m18332i(file));
        if (matcher.find()) {
            return matcher.group(1);
        }
        return (String) null;
    }

    /* renamed from: b */
    public String m18026b(String str) {
        if (str == null) {
            return (String) null;
        }
        File file = new File(new StringBuffer().append(str).append("/AndroidManifest.xml").toString());
        if (!file.exists() || !file.isFile() || !file.getParentFile().canWrite()) {
            return (String) null;
        }
        Matcher matcher = Pattern.compile("<application[^>]+\\sandroid:label=\"([^\"]+)\"").matcher(C3061a.m18332i(file));
        if (matcher.find()) {
            String group = matcher.group(1);
            if (group.matches("^@string/.+$")) {
                return m18027b(str, group);
            }
            return C3112bn.m19031f(group);
        }
        return (String) null;
    }

    /* renamed from: b */
    public String m18027b(String str, String str2) {
        if (str == null || str2 == null) {
            return (String) null;
        }
        String[] split = str2.substring(1).split("/");
        File file = new File(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(str).append("/res/values/").toString()).append(split[0]).toString()).append("s.xml").toString());
        if (!file.exists() || !file.isFile() || !file.getParentFile().canWrite() || split.length != 2) {
            return (String) null;
        }
        Matcher matcher = Pattern.compile(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("<").append(split[0]).toString()).append(" name=\"").toString()).append(split[1]).toString()).append("\">([^<]+)</").toString()).append(split[0]).toString()).append(">").toString()).matcher(C3061a.m18332i(file));
        if (matcher.find()) {
            return C3112bn.m19031f(matcher.group(1));
        }
        return (String) null;
    }

    /* renamed from: c */
    public String m18028c(String str) {
        if (str == null) {
            return (String) null;
        }
        File file = new File(new StringBuffer().append(str).append("/AndroidManifest.xml").toString());
        if (!file.exists() || !file.isFile() || !file.getParentFile().canWrite()) {
            return (String) null;
        }
        Matcher matcher = Pattern.compile("<application[^>]+\\sandroid:icon=\"@((drawable|mipmap)/[^\"]+)\"").matcher(C3061a.m18332i(file));
        if (matcher.find()) {
            return m18029c(str, matcher.group(1));
        }
        return (String) null;
    }

    /* renamed from: c */
    public String m18029c(String str, String str2) {
        if (str == null || str2 == null) {
            return (String) null;
        }
        File file = new File(new StringBuffer().append(str).append("/res").toString());
        if (!file.isDirectory()) {
            return (String) null;
        }
        String[] split = str2.split("/");
        File[] listFiles = file.listFiles(new FileFilter(this, split) { // from class: ru.maximoff.apktool.fragment.b.k.37

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16759a;

            /* renamed from: b */
            private final String[] f16760b;

            {
                this.f16759a = this;
                this.f16760b = split;
            }

            @Override // java.p209io.FileFilter
            public boolean accept(File file2) {
                return file2.isDirectory() && file2.getName().startsWith(this.f16760b[0]);
            }
        });
        if (listFiles != null && listFiles.length > 0) {
            long j = 0;
            File file2 = (File) null;
            File file3 = (File) null;
            for (File file4 : listFiles) {
                File[] listFiles2 = file4.listFiles(new FileFilter(this, split) { // from class: ru.maximoff.apktool.fragment.b.k.38

                    /* renamed from: a */
                    private final ViewOnClickListenerC2992k f16761a;

                    /* renamed from: b */
                    private final String[] f16762b;

                    {
                        this.f16761a = this;
                        this.f16762b = split;
                    }

                    @Override // java.p209io.FileFilter
                    public boolean accept(File file5) {
                        return file5.isFile() && (file5.getName().equals(new StringBuffer().append(this.f16762b[1]).append(".png").toString()) || file5.getName().equals(new StringBuffer().append(this.f16762b[1]).append(".webp").toString()) || file5.getName().equals(new StringBuffer().append(this.f16762b[1]).append(".xml").toString()));
                    }
                });
                if (listFiles2 != null) {
                    for (File file5 : listFiles2) {
                        if (file5.getName().endsWith(".xml")) {
                            file2 = file5;
                        } else if (file5.length() > j) {
                            j = file5.length();
                            file3 = file5;
                        }
                    }
                }
            }
            if (file3 != null) {
                return file3.getAbsolutePath();
            }
            if (file2 != null) {
                return file2.getAbsolutePath();
            }
        }
        return (String) null;
    }

    /* renamed from: j */
    public String m18039j() {
        try {
            return m18031d(this.f16561g.getText().toString());
        } catch (Exception e2) {
            return (String) null;
        }
    }

    /* renamed from: d */
    public String m18031d(String str) {
        File file = new File(new StringBuffer().append(str).append("/apktool.json").toString());
        if (!file.getParentFile().canWrite()) {
            return m17999h(str);
        }
        if (!file.exists() || !file.isFile()) {
            String parent = file.getParentFile().getParent();
            int i = 0;
            while (true) {
                if (i >= this.f16565k.length) {
                    break;
                }
                if (!parent.startsWith(this.f16565k[i])) {
                    i++;
                } else {
                    while (!parent.equals(this.f16565k[i]) && parent.length() > this.f16565k[i].length()) {
                        File file2 = new File(new StringBuffer().append(parent).append("/apktool.json").toString());
                        if (file2.exists() && file2.isFile()) {
                            return parent;
                        }
                        parent = file2.getParentFile().getParent();
                    }
                }
            }
            return m17999h(str);
        }
        return str;
    }

    /* renamed from: h */
    private String m17999h(String str) {
        File file = new File(new StringBuffer().append(str).append("/apktool.yml").toString());
        if (!file.getParentFile().canWrite()) {
            return (String) null;
        }
        if (file.exists() && file.isFile()) {
            return str;
        }
        String parent = file.getParentFile().getParent();
        int i = 0;
        while (true) {
            if (i >= this.f16565k.length) {
                break;
            }
            if (!parent.startsWith(this.f16565k[i])) {
                i++;
            } else {
                while (!parent.equals(this.f16565k[i]) && parent.length() > this.f16565k[i].length()) {
                    File file2 = new File(new StringBuffer().append(parent).append("/apktool.yml").toString());
                    if (file2.exists() && file2.isFile()) {
                        return parent;
                    }
                    parent = file2.getParentFile().getParent();
                }
            }
        }
        return (String) null;
    }

    /* renamed from: e */
    protected void m18034e(String str) {
        int i;
        int m18905a = C3102bd.m18905a(this.f16556b, "defaultCompator", 0);
        try {
            i = m18001i(str);
        } catch (Exception e2) {
            i = -1;
        }
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f16556b).m418a(R.string.sort).m419a(R.array.sort, i == -1 ? m18905a : i, new DialogInterface.OnClickListener(this, i, str) { // from class: ru.maximoff.apktool.fragment.b.k.39

            /* renamed from: a */
            private final ViewOnClickListenerC2992k f16763a;

            /* renamed from: b */
            private final int f16764b;

            /* renamed from: c */
            private final String f16765c;

            {
                this.f16763a = this;
                this.f16764b = i;
                this.f16765c = str;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (this.f16764b >= 0) {
                    try {
                        this.f16763a.m17982a(this.f16765c, i2);
                    } catch (Exception e3) {
                    }
                } else {
                    C3102bd.m18935b(this.f16763a.f16556b, "defaultCompator", i2);
                }
                this.f16763a.f16564j.mo17929a();
            }
        }).m420a(R.string.f21470ok, (DialogInterface.OnClickListener) null).m440c(R.string.only_here, (DialogInterface.OnClickListener) null).m429a(true).m438b();
        m438b.setOnShowListener(new AnonymousClass40(this, m438b, i, str, m18905a));
        m438b.show();
    }

    /* compiled from: FilesPager.java */
    /* renamed from: ru.maximoff.apktool.fragment.b.k$40, reason: invalid class name */
    class AnonymousClass40 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final ViewOnClickListenerC2992k f16769a;

        /* renamed from: b */
        private final DialogInterfaceC0070b f16770b;

        /* renamed from: c */
        private final int f16771c;

        /* renamed from: d */
        private final String f16772d;

        /* renamed from: e */
        private final int f16773e;

        AnonymousClass40(ViewOnClickListenerC2992k viewOnClickListenerC2992k, DialogInterfaceC0070b dialogInterfaceC0070b, int i, String str, int i2) {
            this.f16769a = viewOnClickListenerC2992k;
            this.f16770b = dialogInterfaceC0070b;
            this.f16771c = i;
            this.f16772d = str;
            this.f16773e = i2;
        }

        /* renamed from: a */
        static ViewOnClickListenerC2992k m18047a(AnonymousClass40 anonymousClass40) {
            return anonymousClass40.f16769a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            Button m414a = this.f16770b.m414a(-3);
            if (this.f16771c >= 0) {
                m414a.setText(R.string.search_reset);
            }
            m414a.setOnClickListener(new View.OnClickListener(this, this.f16771c, this.f16772d, this.f16773e, this.f16770b) { // from class: ru.maximoff.apktool.fragment.b.k.40.1

                /* renamed from: a */
                private final AnonymousClass40 f16774a;

                /* renamed from: b */
                private final int f16775b;

                /* renamed from: c */
                private final String f16776c;

                /* renamed from: d */
                private final int f16777d;

                /* renamed from: e */
                private final DialogInterfaceC0070b f16778e;

                {
                    this.f16774a = this;
                    this.f16775b = r2;
                    this.f16776c = r3;
                    this.f16777d = r4;
                    this.f16778e = r5;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (this.f16775b >= 0) {
                        try {
                            AnonymousClass40.m18047a(this.f16774a).m18004j(this.f16776c);
                            AnonymousClass40.m18047a(this.f16774a).f16564j.mo17929a();
                        } catch (Exception e2) {
                        }
                    } else {
                        try {
                            AnonymousClass40.m18047a(this.f16774a).m17982a(this.f16776c, C3102bd.m18905a(AnonymousClass40.m18047a(this.f16774a).f16556b, "defaultCompator", 0));
                            C3102bd.m18935b(AnonymousClass40.m18047a(this.f16774a).f16556b, "defaultCompator", this.f16777d);
                        } catch (Exception e3) {
                        }
                    }
                    this.f16778e.cancel();
                }
            });
            m414a.setOnLongClickListener(new View.OnLongClickListener(this, this.f16770b) { // from class: ru.maximoff.apktool.fragment.b.k.40.2

                /* renamed from: a */
                private final AnonymousClass40 f16779a;

                /* renamed from: b */
                private final DialogInterfaceC0070b f16780b;

                {
                    this.f16779a = this;
                    this.f16780b = r2;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    try {
                        AnonymousClass40.m18047a(this.f16779a).m18008m();
                        this.f16780b.cancel();
                        return true;
                    } catch (Exception e2) {
                        return false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m18008m() {
        C2468c c2468c = new C2468c(C3102bd.m18910a(this.f16556b, "customCompator", "{}"));
        if (c2468c.m15614d() == 0) {
            C3112bn.m18999a(this.f16556b, R.string.not_found);
            return;
        }
        String[] strArr = new String[c2468c.m15614d()];
        Iterator<String> m15605a = c2468c.m15605a();
        int i = 0;
        while (true) {
            int i2 = i;
            if (m15605a.hasNext()) {
                strArr[i2] = m15605a.next();
                i = i2 + 1;
            } else {
                new DialogInterfaceC0070b.a(this.f16556b).m431a(strArr, new DialogInterface.OnClickListener(this, strArr) { // from class: ru.maximoff.apktool.fragment.b.k.41

                    /* renamed from: a */
                    private final ViewOnClickListenerC2992k f16781a;

                    /* renamed from: b */
                    private final String[] f16782b;

                    {
                        this.f16781a = this;
                        this.f16782b = strArr;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        this.f16781a.f16564j.mo17934a(new File(this.f16782b[i3]));
                        dialogInterface.dismiss();
                    }
                }).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m438b().show();
                return;
            }
        }
    }

    /* renamed from: i */
    private int m18001i(String str) {
        C2468c c2468c = new C2468c(C3102bd.m18910a(this.f16556b, "customCompator", "{}"));
        if (c2468c.m15618g(str)) {
            return c2468c.m15612c(str);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m18004j(String str) {
        C2468c c2468c = new C2468c(C3102bd.m18910a(this.f16556b, "customCompator", "{}"));
        if (c2468c.m15618g(str)) {
            c2468c.m15621k(str);
            C3102bd.m18937b(this.f16556b, "customCompator", c2468c.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17982a(String str, int i) {
        C2468c c2468c = new C2468c(C3102bd.m18910a(this.f16556b, "customCompator", "{}"));
        c2468c.m15606a(str, i);
        C3102bd.m18937b(this.f16556b, "customCompator", c2468c.toString());
    }

    /* renamed from: k */
    public String m18040k() {
        return this.f16561g.getText().toString();
    }

    /* compiled from: FilesPager.java */
    /* renamed from: ru.maximoff.apktool.fragment.b.k$a */
    private class a extends AsyncTask<File, Void, Void> {

        /* renamed from: a */
        private Context f16793a;

        /* renamed from: b */
        private DialogInterfaceC0070b f16794b;

        /* renamed from: c */
        private List<File> f16795c;

        /* renamed from: d */
        private String f16796d;

        /* renamed from: e */
        private String f16797e;

        /* renamed from: f */
        private boolean f16798f;

        /* renamed from: g */
        private boolean f16799g;

        /* renamed from: h */
        private boolean f16800h;

        /* renamed from: i */
        private int f16801i;

        /* renamed from: j */
        private final ViewOnClickListenerC2992k f16802j;

        @Override // android.p008os.AsyncTask
        protected Void doInBackground(File[] fileArr) {
            return m18048a(fileArr);
        }

        @Override // android.p008os.AsyncTask
        protected void onPostExecute(Void r1) {
            m18049a(r1);
        }

        public a(ViewOnClickListenerC2992k viewOnClickListenerC2992k, Context context, String str, String str2, boolean z, boolean z2, int i, boolean z3) {
            this.f16802j = viewOnClickListenerC2992k;
            this.f16793a = context;
            this.f16796d = str;
            this.f16797e = str2;
            this.f16798f = z;
            this.f16799g = z2;
            this.f16800h = z3;
            this.f16801i = i;
        }

        @Override // android.p008os.AsyncTask
        protected void onPreExecute() {
            View inflate = LayoutInflater.from(this.f16793a).inflate(R.layout.search_progress, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
            this.f16794b = new DialogInterfaceC0070b.a(this.f16793a).m435b(inflate).m429a(false).m438b();
            this.f16794b.show();
        }

        /* renamed from: a */
        protected Void m18048a(File[] fileArr) {
            this.f16795c = C3259s.m19523a(fileArr);
            return (Void) null;
        }

        /* renamed from: a */
        protected void m18049a(Void r9) {
            if (this.f16794b != null && this.f16794b.isShowing()) {
                try {
                    this.f16794b.cancel();
                } catch (Exception e2) {
                }
            }
            this.f16802j.m18021a(this.f16796d, this.f16795c, this.f16797e, this.f16798f, this.f16799g, this.f16801i, this.f16800h);
        }
    }

    /* compiled from: FilesPager.java */
    /* renamed from: ru.maximoff.apktool.fragment.b.k$b */
    private class b extends AsyncTask<File, Void, Boolean> {

        /* renamed from: a */
        private Context f16803a;

        /* renamed from: b */
        private DialogInterfaceC0070b f16804b;

        /* renamed from: c */
        private String f16805c;

        /* renamed from: d */
        private boolean f16806d;

        /* renamed from: e */
        private boolean f16807e;

        /* renamed from: f */
        private File[] f16808f;

        /* renamed from: g */
        private int f16809g;

        /* renamed from: h */
        private int[] f16810h;

        /* renamed from: i */
        private final ViewOnClickListenerC2992k f16811i;

        /* renamed from: e */
        static ViewOnClickListenerC2992k m18054e(b bVar) {
            return bVar.f16811i;
        }

        @Override // android.p008os.AsyncTask
        protected Boolean doInBackground(File[] fileArr) {
            return m18055a(fileArr);
        }

        @Override // android.p008os.AsyncTask
        protected void onPostExecute(Boolean bool) {
            m18056a(bool);
        }

        public b(ViewOnClickListenerC2992k viewOnClickListenerC2992k, Context context, String str, boolean z, boolean z2, int i) {
            this.f16811i = viewOnClickListenerC2992k;
            this.f16803a = context;
            this.f16805c = str;
            this.f16806d = z;
            this.f16807e = z2;
            this.f16809g = i;
            int[] iArr = new int[1];
            iArr[0] = C3102bd.m18925a(this.f16803a, "overwrite_apk", false) ? 2 : 0;
            this.f16810h = iArr;
        }

        @Override // android.p008os.AsyncTask
        protected void onPreExecute() {
            View inflate = LayoutInflater.from(this.f16803a).inflate(R.layout.search_progress, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
            this.f16804b = new DialogInterfaceC0070b.a(this.f16803a).m435b(inflate).m429a(false).m438b();
            this.f16804b.show();
        }

        /* renamed from: a */
        protected Boolean m18055a(File[] fileArr) {
            this.f16808f = fileArr;
            return new Boolean(C3258r.m19522a(this.f16805c, this.f16808f, this.f16809g));
        }

        /* renamed from: a */
        protected void m18056a(Boolean bool) {
            if (this.f16804b != null && this.f16804b.isShowing()) {
                try {
                    this.f16804b.cancel();
                } catch (Exception e2) {
                }
            }
            AsyncTaskC2939j asyncTaskC2939j = new AsyncTaskC2939j(this.f16803a, this.f16805c, this.f16806d, this.f16809g);
            if (bool.booleanValue()) {
                new DialogInterfaceC0070b.a(this.f16803a).m419a(R.array.copy_variants, this.f16810h[0], new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.fragment.b.k.b.1

                    /* renamed from: a */
                    private final b f16812a;

                    {
                        this.f16812a = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        this.f16812a.f16810h[0] = i;
                    }
                }).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, asyncTaskC2939j) { // from class: ru.maximoff.apktool.fragment.b.k.b.2

                    /* renamed from: a */
                    private final b f16813a;

                    /* renamed from: b */
                    private final AsyncTaskC2939j f16814b;

                    {
                        this.f16813a = this;
                        this.f16814b = asyncTaskC2939j;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        this.f16814b.m17496a(this.f16813a.f16810h[0]);
                        try {
                            this.f16814b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f16813a.f16808f);
                            if (!this.f16813a.f16807e) {
                                b.m18054e(this.f16813a).m18030c();
                            }
                        } catch (Exception e3) {
                            C3112bn.m18999a(this.f16813a.f16803a, R.string.error_try_again);
                        }
                    }
                }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m418a(R.string.if_exists).m438b().show();
                return;
            }
            asyncTaskC2939j.m17496a(this.f16810h[0]);
            try {
                asyncTaskC2939j.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f16808f);
                if (!this.f16807e) {
                    this.f16811i.m18030c();
                }
            } catch (Exception e3) {
                C3112bn.m18999a(this.f16803a, R.string.error_try_again);
            }
        }
    }
}
