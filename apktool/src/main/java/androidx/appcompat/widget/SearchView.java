package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.speech.RecognizerIntent;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.InterfaceC0091c;
import androidx.core.p031f.C0308x;
import androidx.p019b.p020a.AbstractC0220a;
import androidx.p021c.p022a.AbstractC0223a;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SearchView extends C0169ak implements InterfaceC0091c {

    /* renamed from: i */
    static final C0147d f1226i;

    /* renamed from: A */
    private InterfaceC0145b f1227A;

    /* renamed from: B */
    private InterfaceC0144a f1228B;

    /* renamed from: C */
    private InterfaceC0146c f1229C;

    /* renamed from: D */
    private View.OnClickListener f1230D;

    /* renamed from: E */
    private boolean f1231E;

    /* renamed from: F */
    private boolean f1232F;

    /* renamed from: G */
    private boolean f1233G;

    /* renamed from: H */
    private CharSequence f1234H;

    /* renamed from: I */
    private boolean f1235I;

    /* renamed from: J */
    private boolean f1236J;

    /* renamed from: K */
    private int f1237K;

    /* renamed from: L */
    private boolean f1238L;

    /* renamed from: M */
    private CharSequence f1239M;

    /* renamed from: N */
    private CharSequence f1240N;

    /* renamed from: O */
    private boolean f1241O;

    /* renamed from: P */
    private int f1242P;

    /* renamed from: Q */
    private Bundle f1243Q;

    /* renamed from: R */
    private final Runnable f1244R;

    /* renamed from: S */
    private Runnable f1245S;

    /* renamed from: T */
    private final WeakHashMap<String, Drawable.ConstantState> f1246T;

    /* renamed from: U */
    private final View.OnClickListener f1247U;

    /* renamed from: V */
    private final TextView.OnEditorActionListener f1248V;

    /* renamed from: W */
    private final AdapterView.OnItemClickListener f1249W;

    /* renamed from: a */
    final SearchAutoComplete f1250a;

    /* renamed from: aa */
    private final AdapterView.OnItemSelectedListener f1251aa;

    /* renamed from: ab */
    private TextWatcher f1252ab;

    /* renamed from: b */
    final ImageView f1253b;

    /* renamed from: c */
    final ImageView f1254c;

    /* renamed from: d */
    final ImageView f1255d;

    /* renamed from: e */
    final ImageView f1256e;

    /* renamed from: f */
    View.OnFocusChangeListener f1257f;

    /* renamed from: g */
    AbstractC0220a f1258g;

    /* renamed from: h */
    SearchableInfo f1259h;

    /* renamed from: j */
    View.OnKeyListener f1260j;

    /* renamed from: k */
    private final View f1261k;

    /* renamed from: l */
    private final View f1262l;

    /* renamed from: m */
    private final View f1263m;

    /* renamed from: n */
    private final View f1264n;

    /* renamed from: o */
    private C0149f f1265o;

    /* renamed from: p */
    private Rect f1266p;

    /* renamed from: q */
    private Rect f1267q;

    /* renamed from: r */
    private int[] f1268r;

    /* renamed from: s */
    private int[] f1269s;

    /* renamed from: t */
    private final ImageView f1270t;

    /* renamed from: u */
    private final Drawable f1271u;

    /* renamed from: v */
    private final int f1272v;

    /* renamed from: w */
    private final int f1273w;

    /* renamed from: x */
    private final Intent f1274x;

    /* renamed from: y */
    private final Intent f1275y;

    /* renamed from: z */
    private final CharSequence f1276z;

    /* renamed from: androidx.appcompat.widget.SearchView$a */
    public interface InterfaceC0144a {
        /* renamed from: a */
        boolean m1094a();
    }

    /* renamed from: androidx.appcompat.widget.SearchView$b */
    public interface InterfaceC0145b {
        /* renamed from: a */
        boolean mo1095a(String str);

        /* renamed from: b */
        boolean mo1096b(String str);
    }

    /* renamed from: androidx.appcompat.widget.SearchView$c */
    public interface InterfaceC0146c {
        /* renamed from: a */
        boolean m1097a(int i);

        /* renamed from: b */
        boolean m1098b(int i);
    }

    static {
        f1226i = Build.VERSION.SDK_INT < 29 ? new C0147d() : null;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0059a.a.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1266p = new Rect();
        this.f1267q = new Rect();
        this.f1268r = new int[2];
        this.f1269s = new int[2];
        this.f1244R = new Runnable() { // from class: androidx.appcompat.widget.SearchView.1
            @Override // java.lang.Runnable
            public void run() {
                SearchView.this.m1083d();
            }
        };
        this.f1245S = new Runnable() { // from class: androidx.appcompat.widget.SearchView.3
            @Override // java.lang.Runnable
            public void run() {
                if (SearchView.this.f1258g instanceof ViewOnClickListenerC0178at) {
                    SearchView.this.f1258g.mo1416a((Cursor) null);
                }
            }
        };
        this.f1246T = new WeakHashMap<>();
        this.f1247U = new View.OnClickListener() { // from class: androidx.appcompat.widget.SearchView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == SearchView.this.f1253b) {
                    SearchView.this.m1086g();
                    return;
                }
                if (view == SearchView.this.f1255d) {
                    SearchView.this.m1085f();
                    return;
                }
                if (view == SearchView.this.f1254c) {
                    SearchView.this.m1084e();
                } else if (view == SearchView.this.f1256e) {
                    SearchView.this.m1087h();
                } else if (view == SearchView.this.f1250a) {
                    SearchView.this.m1090l();
                }
            }
        };
        this.f1260j = new View.OnKeyListener() { // from class: androidx.appcompat.widget.SearchView.7
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (SearchView.this.f1259h == null) {
                    return false;
                }
                if (SearchView.this.f1250a.isPopupShowing() && SearchView.this.f1250a.getListSelection() != -1) {
                    return SearchView.this.m1080a(view, i2, keyEvent);
                }
                if (SearchView.this.f1250a.m1091a() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i2 != 66) {
                    return false;
                }
                view.cancelLongPress();
                SearchView.this.m1075a(0, (String) null, SearchView.this.f1250a.getText().toString());
                return true;
            }
        };
        this.f1248V = new TextView.OnEditorActionListener() { // from class: androidx.appcompat.widget.SearchView.8
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                SearchView.this.m1084e();
                return true;
            }
        };
        this.f1249W = new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.widget.SearchView.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                SearchView.this.m1079a(i2, 0, (String) null);
            }
        };
        this.f1251aa = new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.SearchView.10
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
                SearchView.this.m1078a(i2);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.f1252ab = new TextWatcher() { // from class: androidx.appcompat.widget.SearchView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                SearchView.this.m1081b(charSequence);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        C0184az m1432a = C0184az.m1432a(context, attributeSet, C0059a.j.SearchView, i, 0);
        LayoutInflater.from(context).inflate(m1432a.m1450g(C0059a.j.SearchView_layout, C0059a.g.abc_search_view), (ViewGroup) this, true);
        this.f1250a = (SearchAutoComplete) findViewById(C0059a.f.search_src_text);
        this.f1250a.setSearchView(this);
        this.f1261k = findViewById(C0059a.f.search_edit_frame);
        this.f1262l = findViewById(C0059a.f.search_plate);
        this.f1263m = findViewById(C0059a.f.submit_area);
        this.f1253b = (ImageView) findViewById(C0059a.f.search_button);
        this.f1254c = (ImageView) findViewById(C0059a.f.search_go_btn);
        this.f1255d = (ImageView) findViewById(C0059a.f.search_close_btn);
        this.f1256e = (ImageView) findViewById(C0059a.f.search_voice_btn);
        this.f1270t = (ImageView) findViewById(C0059a.f.search_mag_icon);
        C0308x.m2233a(this.f1262l, m1432a.m1437a(C0059a.j.SearchView_queryBackground));
        C0308x.m2233a(this.f1263m, m1432a.m1437a(C0059a.j.SearchView_submitBackground));
        this.f1253b.setImageDrawable(m1432a.m1437a(C0059a.j.SearchView_searchIcon));
        this.f1254c.setImageDrawable(m1432a.m1437a(C0059a.j.SearchView_goIcon));
        this.f1255d.setImageDrawable(m1432a.m1437a(C0059a.j.SearchView_closeIcon));
        this.f1256e.setImageDrawable(m1432a.m1437a(C0059a.j.SearchView_voiceIcon));
        this.f1270t.setImageDrawable(m1432a.m1437a(C0059a.j.SearchView_searchIcon));
        this.f1271u = m1432a.m1437a(C0059a.j.SearchView_searchHintIcon);
        C0187bb.m1463a(this.f1253b, getResources().getString(C0059a.h.abc_searchview_description_search));
        this.f1272v = m1432a.m1450g(C0059a.j.SearchView_suggestionRowLayout, C0059a.g.abc_search_dropdown_item_icons_2line);
        this.f1273w = m1432a.m1450g(C0059a.j.SearchView_commitIcon, 0);
        this.f1253b.setOnClickListener(this.f1247U);
        this.f1255d.setOnClickListener(this.f1247U);
        this.f1254c.setOnClickListener(this.f1247U);
        this.f1256e.setOnClickListener(this.f1247U);
        this.f1250a.setOnClickListener(this.f1247U);
        this.f1250a.addTextChangedListener(this.f1252ab);
        this.f1250a.setOnEditorActionListener(this.f1248V);
        this.f1250a.setOnItemClickListener(this.f1249W);
        this.f1250a.setOnItemSelectedListener(this.f1251aa);
        this.f1250a.setOnKeyListener(this.f1260j);
        this.f1250a.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: androidx.appcompat.widget.SearchView.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (SearchView.this.f1257f != null) {
                    SearchView.this.f1257f.onFocusChange(SearchView.this, z);
                }
            }
        });
        setIconifiedByDefault(m1432a.m1438a(C0059a.j.SearchView_iconifiedByDefault, true));
        int m1446e = m1432a.m1446e(C0059a.j.SearchView_android_maxWidth, -1);
        if (m1446e != -1) {
            setMaxWidth(m1446e);
        }
        this.f1276z = m1432a.m1443c(C0059a.j.SearchView_defaultQueryHint);
        this.f1234H = m1432a.m1443c(C0059a.j.SearchView_queryHint);
        int m1434a = m1432a.m1434a(C0059a.j.SearchView_android_imeOptions, -1);
        if (m1434a != -1) {
            setImeOptions(m1434a);
        }
        int m1434a2 = m1432a.m1434a(C0059a.j.SearchView_android_inputType, -1);
        if (m1434a2 != -1) {
            setInputType(m1434a2);
        }
        setFocusable(m1432a.m1438a(C0059a.j.SearchView_android_focusable, true));
        m1432a.m1441b();
        this.f1274x = new Intent(RecognizerIntent.ACTION_WEB_SEARCH);
        this.f1274x.addFlags(268435456);
        this.f1274x.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
        this.f1275y = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        this.f1275y.addFlags(268435456);
        this.f1264n = findViewById(this.f1250a.getDropDownAnchor());
        if (this.f1264n != null) {
            this.f1264n.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.appcompat.widget.SearchView.5
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    SearchView.this.m1089k();
                }
            });
        }
        m1059a(this.f1231E);
        m1072r();
    }

    int getSuggestionRowLayout() {
        return this.f1272v;
    }

    int getSuggestionCommitIconResId() {
        return this.f1273w;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f1259h = searchableInfo;
        if (this.f1259h != null) {
            m1073s();
            m1072r();
        }
        this.f1238L = m1067m();
        if (this.f1238L) {
            this.f1250a.setPrivateImeOptions("nm");
        }
        m1059a(m1082c());
    }

    public void setAppSearchData(Bundle bundle) {
        this.f1243Q = bundle;
    }

    public void setImeOptions(int i) {
        this.f1250a.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.f1250a.getImeOptions();
    }

    public void setInputType(int i) {
        this.f1250a.setInputType(i);
    }

    public int getInputType() {
        return this.f1250a.getInputType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i, Rect rect) {
        if (this.f1236J || !isFocusable()) {
            return false;
        }
        if (!m1082c()) {
            boolean requestFocus = this.f1250a.requestFocus(i, rect);
            if (requestFocus) {
                m1059a(false);
            }
            return requestFocus;
        }
        return super.requestFocus(i, rect);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.f1236J = true;
        super.clearFocus();
        this.f1250a.clearFocus();
        this.f1250a.setImeVisibility(false);
        this.f1236J = false;
    }

    public void setOnQueryTextListener(InterfaceC0145b interfaceC0145b) {
        this.f1227A = interfaceC0145b;
    }

    public void setOnCloseListener(InterfaceC0144a interfaceC0144a) {
        this.f1228B = interfaceC0144a;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f1257f = onFocusChangeListener;
    }

    public void setOnSuggestionListener(InterfaceC0146c interfaceC0146c) {
        this.f1229C = interfaceC0146c;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f1230D = onClickListener;
    }

    public CharSequence getQuery() {
        return this.f1250a.getText();
    }

    /* renamed from: a */
    public void m1077a(CharSequence charSequence, boolean z) {
        this.f1250a.setText(charSequence);
        if (charSequence != null) {
            this.f1250a.setSelection(this.f1250a.length());
            this.f1240N = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            m1084e();
        }
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f1234H = charSequence;
        m1072r();
    }

    public CharSequence getQueryHint() {
        if (this.f1234H != null) {
            return this.f1234H;
        }
        if (this.f1259h != null && this.f1259h.getHintId() != 0) {
            return getContext().getText(this.f1259h.getHintId());
        }
        return this.f1276z;
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f1231E != z) {
            this.f1231E = z;
            m1059a(z);
            m1072r();
        }
    }

    public void setIconified(boolean z) {
        if (z) {
            m1085f();
        } else {
            m1086g();
        }
    }

    /* renamed from: c */
    public boolean m1082c() {
        return this.f1232F;
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f1233G = z;
        m1059a(m1082c());
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.f1235I = z;
        if (this.f1258g instanceof ViewOnClickListenerC0178at) {
            ((ViewOnClickListenerC0178at) this.f1258g).m1415a(z ? 2 : 1);
        }
    }

    public void setSuggestionsAdapter(AbstractC0220a abstractC0220a) {
        this.f1258g = abstractC0220a;
        this.f1250a.setAdapter(this.f1258g);
    }

    public AbstractC0220a getSuggestionsAdapter() {
        return this.f1258g;
    }

    public void setMaxWidth(int i) {
        this.f1237K = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.f1237K;
    }

    @Override // androidx.appcompat.widget.C0169ak, android.view.View
    protected void onMeasure(int i, int i2) {
        if (m1082c()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (this.f1237K > 0) {
                    size = Math.min(this.f1237K, size);
                    break;
                } else {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                }
            case 0:
                if (this.f1237K <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.f1237K;
                    break;
                }
            case 1073741824:
                if (this.f1237K > 0) {
                    size = Math.min(this.f1237K, size);
                    break;
                }
                break;
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        switch (mode2) {
            case Integer.MIN_VALUE:
                size2 = Math.min(getPreferredHeight(), size2);
                break;
            case 0:
                size2 = getPreferredHeight();
                break;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // androidx.appcompat.widget.C0169ak, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            m1058a(this.f1250a, this.f1266p);
            this.f1267q.set(this.f1266p.left, 0, this.f1266p.right, i4 - i2);
            if (this.f1265o == null) {
                this.f1265o = new C0149f(this.f1267q, this.f1266p, this.f1250a);
                setTouchDelegate(this.f1265o);
            } else {
                this.f1265o.m1106a(this.f1267q, this.f1266p);
            }
        }
    }

    /* renamed from: a */
    private void m1058a(View view, Rect rect) {
        view.getLocationInWindow(this.f1268r);
        getLocationInWindow(this.f1269s);
        int i = this.f1268r[1] - this.f1269s[1];
        int i2 = this.f1268r[0] - this.f1269s[0];
        rect.set(i2, i, view.getWidth() + i2, view.getHeight() + i);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(C0059a.d.abc_search_view_preferred_width);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(C0059a.d.abc_search_view_preferred_height);
    }

    /* renamed from: a */
    private void m1059a(boolean z) {
        int i = 8;
        this.f1232F = z;
        int i2 = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.f1250a.getText());
        this.f1253b.setVisibility(i2);
        m1062b(z2);
        this.f1261k.setVisibility(z ? 8 : 0);
        if (this.f1270t.getDrawable() != null && !this.f1231E) {
            i = 0;
        }
        this.f1270t.setVisibility(i);
        m1070p();
        m1065c(z2 ? false : true);
        m1069o();
    }

    /* renamed from: m */
    private boolean m1067m() {
        if (this.f1259h == null || !this.f1259h.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f1259h.getVoiceSearchLaunchWebSearch()) {
            intent = this.f1274x;
        } else if (this.f1259h.getVoiceSearchLaunchRecognizer()) {
            intent = this.f1275y;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    /* renamed from: n */
    private boolean m1068n() {
        return (this.f1233G || this.f1238L) && !m1082c();
    }

    /* renamed from: b */
    private void m1062b(boolean z) {
        int i = 8;
        if (this.f1233G && m1068n() && hasFocus() && (z || !this.f1238L)) {
            i = 0;
        }
        this.f1254c.setVisibility(i);
    }

    /* renamed from: o */
    private void m1069o() {
        int i = 8;
        if (m1068n() && (this.f1254c.getVisibility() == 0 || this.f1256e.getVisibility() == 0)) {
            i = 0;
        }
        this.f1263m.setVisibility(i);
    }

    /* renamed from: p */
    private void m1070p() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f1250a.getText());
        if (!z2 && (!this.f1231E || this.f1241O)) {
            z = false;
        }
        this.f1255d.setVisibility(z ? 0 : 8);
        Drawable drawable = this.f1255d.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    /* renamed from: q */
    private void m1071q() {
        post(this.f1244R);
    }

    /* renamed from: d */
    void m1083d() {
        int[] iArr = this.f1250a.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.f1262l.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f1263m.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f1244R);
        post(this.f1245S);
        super.onDetachedFromWindow();
    }

    /* renamed from: a */
    void m1076a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    /* renamed from: a */
    boolean m1080a(View view, int i, KeyEvent keyEvent) {
        if (this.f1259h == null || this.f1258g == null || keyEvent.getAction() != 0 || !keyEvent.hasNoModifiers()) {
            return false;
        }
        if (i == 66 || i == 84 || i == 61) {
            return m1079a(this.f1250a.getListSelection(), 0, (String) null);
        }
        if (i == 21 || i == 22) {
            this.f1250a.setSelection(i == 21 ? 0 : this.f1250a.length());
            this.f1250a.setListSelection(0);
            this.f1250a.clearListSelection();
            this.f1250a.m1093c();
            return true;
        }
        if (i != 19 || this.f1250a.getListSelection() != 0) {
        }
        return false;
    }

    /* renamed from: c */
    private CharSequence m1064c(CharSequence charSequence) {
        if (this.f1231E && this.f1271u != null) {
            int textSize = (int) (this.f1250a.getTextSize() * 1.25d);
            this.f1271u.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(this.f1271u), 1, 2, 33);
            spannableStringBuilder.append(charSequence);
            return spannableStringBuilder;
        }
        return charSequence;
    }

    /* renamed from: r */
    private void m1072r() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f1250a;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(m1064c(queryHint));
    }

    /* renamed from: s */
    private void m1073s() {
        this.f1250a.setThreshold(this.f1259h.getSuggestThreshold());
        this.f1250a.setImeOptions(this.f1259h.getImeOptions());
        int inputType = this.f1259h.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f1259h.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.f1250a.setInputType(inputType);
        if (this.f1258g != null) {
            this.f1258g.mo1416a((Cursor) null);
        }
        if (this.f1259h.getSuggestAuthority() != null) {
            this.f1258g = new ViewOnClickListenerC0178at(getContext(), this, this.f1259h, this.f1246T);
            this.f1250a.setAdapter(this.f1258g);
            ((ViewOnClickListenerC0178at) this.f1258g).m1415a(this.f1235I ? 2 : 1);
        }
    }

    /* renamed from: c */
    private void m1065c(boolean z) {
        int i;
        if (this.f1238L && !m1082c() && z) {
            i = 0;
            this.f1254c.setVisibility(8);
        } else {
            i = 8;
        }
        this.f1256e.setVisibility(i);
    }

    /* renamed from: b */
    void m1081b(CharSequence charSequence) {
        Editable text = this.f1250a.getText();
        this.f1240N = text;
        boolean z = !TextUtils.isEmpty(text);
        m1062b(z);
        m1065c(z ? false : true);
        m1070p();
        m1069o();
        if (this.f1227A != null && !TextUtils.equals(charSequence, this.f1239M)) {
            this.f1227A.mo1096b(charSequence.toString());
        }
        this.f1239M = charSequence.toString();
    }

    /* renamed from: e */
    void m1084e() {
        Editable text = this.f1250a.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.f1227A == null || !this.f1227A.mo1095a(text.toString())) {
                if (this.f1259h != null) {
                    m1075a(0, (String) null, text.toString());
                }
                this.f1250a.setImeVisibility(false);
                m1074t();
            }
        }
    }

    /* renamed from: t */
    private void m1074t() {
        this.f1250a.dismissDropDown();
    }

    /* renamed from: f */
    void m1085f() {
        if (TextUtils.isEmpty(this.f1250a.getText())) {
            if (this.f1231E) {
                if (this.f1228B == null || !this.f1228B.m1094a()) {
                    clearFocus();
                    m1059a(true);
                    return;
                }
                return;
            }
            return;
        }
        this.f1250a.setText("");
        this.f1250a.requestFocus();
        this.f1250a.setImeVisibility(true);
    }

    /* renamed from: g */
    void m1086g() {
        m1059a(false);
        this.f1250a.requestFocus();
        this.f1250a.setImeVisibility(true);
        if (this.f1230D != null) {
            this.f1230D.onClick(this);
        }
    }

    /* renamed from: h */
    void m1087h() {
        if (this.f1259h != null) {
            SearchableInfo searchableInfo = this.f1259h;
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    getContext().startActivity(m1054a(this.f1274x, searchableInfo));
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    getContext().startActivity(m1061b(this.f1275y, searchableInfo));
                }
            } catch (ActivityNotFoundException e2) {
                Log.m190w("SearchView", "Could not find voice search activity");
            }
        }
    }

    /* renamed from: i */
    void m1088i() {
        m1059a(m1082c());
        m1071q();
        if (this.f1250a.hasFocus()) {
            m1090l();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m1071q();
    }

    @Override // androidx.appcompat.view.InterfaceC0091c
    /* renamed from: b */
    public void mo750b() {
        m1077a("", false);
        clearFocus();
        m1059a(true);
        this.f1250a.setImeOptions(this.f1242P);
        this.f1241O = false;
    }

    @Override // androidx.appcompat.view.InterfaceC0091c
    /* renamed from: a */
    public void mo749a() {
        if (!this.f1241O) {
            this.f1241O = true;
            this.f1242P = this.f1250a.getImeOptions();
            this.f1250a.setImeOptions(this.f1242P | 33554432);
            this.f1250a.setText("");
            setIconified(false);
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$e */
    static class C0148e extends AbstractC0223a {
        public static final Parcelable.Creator<C0148e> CREATOR = new Parcelable.ClassLoaderCreator<C0148e>() { // from class: androidx.appcompat.widget.SearchView.e.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0148e createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0148e(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0148e createFromParcel(Parcel parcel) {
                return new C0148e(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0148e[] newArray(int i) {
                return new C0148e[i];
            }
        };

        /* renamed from: a */
        boolean f1295a;

        C0148e(Parcelable parcelable) {
            super(parcelable);
        }

        public C0148e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1295a = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        @Override // androidx.p021c.p022a.AbstractC0223a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f1295a));
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1295a + "}";
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        C0148e c0148e = new C0148e(super.onSaveInstanceState());
        c0148e.f1295a = m1082c();
        return c0148e;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0148e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0148e c0148e = (C0148e) parcelable;
        super.onRestoreInstanceState(c0148e.m1617a());
        m1059a(c0148e.f1295a);
        requestLayout();
    }

    /* renamed from: k */
    void m1089k() {
        int i;
        int i2;
        if (this.f1264n.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f1262l.getPaddingLeft();
            Rect rect = new Rect();
            boolean m1481a = C0191bf.m1481a(this);
            if (this.f1231E) {
                i = resources.getDimensionPixelSize(C0059a.d.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(C0059a.d.abc_dropdownitem_icon_width);
            } else {
                i = 0;
            }
            this.f1250a.getDropDownBackground().getPadding(rect);
            if (m1481a) {
                i2 = -rect.left;
            } else {
                i2 = paddingLeft - (rect.left + i);
            }
            this.f1250a.setDropDownHorizontalOffset(i2);
            this.f1250a.setDropDownWidth((i + ((this.f1264n.getWidth() + rect.left) + rect.right)) - paddingLeft);
        }
    }

    /* renamed from: a */
    boolean m1079a(int i, int i2, String str) {
        if (this.f1229C != null && this.f1229C.m1098b(i)) {
            return false;
        }
        m1063b(i, 0, null);
        this.f1250a.setImeVisibility(false);
        m1074t();
        return true;
    }

    /* renamed from: a */
    boolean m1078a(int i) {
        if (this.f1229C != null && this.f1229C.m1097a(i)) {
            return false;
        }
        m1066e(i);
        return true;
    }

    /* renamed from: e */
    private void m1066e(int i) {
        Editable text = this.f1250a.getText();
        Cursor mo1612a = this.f1258g.mo1612a();
        if (mo1612a != null) {
            if (mo1612a.moveToPosition(i)) {
                CharSequence mo1418b = this.f1258g.mo1418b(mo1612a);
                if (mo1418b != null) {
                    setQuery(mo1418b);
                    return;
                } else {
                    setQuery(text);
                    return;
                }
            }
            setQuery(text);
        }
    }

    /* renamed from: b */
    private boolean m1063b(int i, int i2, String str) {
        Cursor mo1612a = this.f1258g.mo1612a();
        if (mo1612a == null || !mo1612a.moveToPosition(i)) {
            return false;
        }
        m1057a(m1055a(mo1612a, i2, str));
        return true;
    }

    /* renamed from: a */
    private void m1057a(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException e2) {
                Log.m185e("SearchView", "Failed launch activity: " + intent, e2);
            }
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.f1250a.setText(charSequence);
        this.f1250a.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    /* renamed from: a */
    void m1075a(int i, String str, String str2) {
        getContext().startActivity(m1056a(Intent.ACTION_SEARCH, (Uri) null, (String) null, str2, i, str));
    }

    /* renamed from: a */
    private Intent m1056a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra(SearchManager.USER_QUERY, this.f1240N);
        if (str3 != null) {
            intent.putExtra(SearchManager.QUERY, str3);
        }
        if (str2 != null) {
            intent.putExtra(SearchManager.EXTRA_DATA_KEY, str2);
        }
        if (this.f1243Q != null) {
            intent.putExtra(SearchManager.APP_DATA, this.f1243Q);
        }
        if (i != 0) {
            intent.putExtra(SearchManager.ACTION_KEY, i);
            intent.putExtra(SearchManager.ACTION_MSG, str4);
        }
        intent.setComponent(this.f1259h.getSearchActivity());
        return intent;
    }

    /* renamed from: a */
    private Intent m1054a(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    /* renamed from: b */
    private Intent m1061b(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent(Intent.ACTION_SEARCH);
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        if (this.f1243Q != null) {
            bundle.putParcelable(SearchManager.APP_DATA, this.f1243Q);
        }
        Intent intent3 = new Intent(intent);
        String str = RecognizerIntent.LANGUAGE_MODEL_FREE_FORM;
        int i = 1;
        Resources resources = getResources();
        if (searchableInfo.getVoiceLanguageModeId() != 0) {
            str = resources.getString(searchableInfo.getVoiceLanguageModeId());
        }
        String string = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string2 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i = searchableInfo.getVoiceMaxResults();
        }
        intent3.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, str);
        intent3.putExtra(RecognizerIntent.EXTRA_PROMPT, string);
        intent3.putExtra(RecognizerIntent.EXTRA_LANGUAGE, string2);
        intent3.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, i);
        intent3.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra(RecognizerIntent.EXTRA_RESULTS_PENDINGINTENT, activity);
        intent3.putExtra(RecognizerIntent.EXTRA_RESULTS_PENDINGINTENT_BUNDLE, bundle);
        return intent3;
    }

    /* renamed from: a */
    private Intent m1055a(Cursor cursor, int i, String str) {
        int i2;
        String m1399a;
        try {
            String m1399a2 = ViewOnClickListenerC0178at.m1399a(cursor, SearchManager.SUGGEST_COLUMN_INTENT_ACTION);
            if (m1399a2 == null) {
                m1399a2 = this.f1259h.getSuggestIntentAction();
            }
            if (m1399a2 == null) {
                m1399a2 = Intent.ACTION_SEARCH;
            }
            String m1399a3 = ViewOnClickListenerC0178at.m1399a(cursor, SearchManager.SUGGEST_COLUMN_INTENT_DATA);
            if (m1399a3 == null) {
                m1399a3 = this.f1259h.getSuggestIntentData();
            }
            if (m1399a3 != null && (m1399a = ViewOnClickListenerC0178at.m1399a(cursor, SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID)) != null) {
                m1399a3 = m1399a3 + "/" + Uri.encode(m1399a);
            }
            return m1056a(m1399a2, m1399a3 == null ? null : Uri.parse(m1399a3), ViewOnClickListenerC0178at.m1399a(cursor, SearchManager.SUGGEST_COLUMN_INTENT_EXTRA_DATA), ViewOnClickListenerC0178at.m1399a(cursor, SearchManager.SUGGEST_COLUMN_QUERY), i, str);
        } catch (RuntimeException e2) {
            try {
                i2 = cursor.getPosition();
            } catch (RuntimeException e3) {
                i2 = -1;
            }
            Log.m191w("SearchView", "Search suggestions cursor at row " + i2 + " returned exception.", e2);
            return null;
        }
    }

    /* renamed from: l */
    void m1090l() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1250a.refreshAutoCompleteResults();
        } else {
            f1226i.m1100a(this.f1250a);
            f1226i.m1101b(this.f1250a);
        }
    }

    /* renamed from: a */
    static boolean m1060a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    /* renamed from: androidx.appcompat.widget.SearchView$f */
    private static class C0149f extends TouchDelegate {

        /* renamed from: a */
        private final View f1296a;

        /* renamed from: b */
        private final Rect f1297b;

        /* renamed from: c */
        private final Rect f1298c;

        /* renamed from: d */
        private final Rect f1299d;

        /* renamed from: e */
        private final int f1300e;

        /* renamed from: f */
        private boolean f1301f;

        public C0149f(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f1300e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f1297b = new Rect();
            this.f1299d = new Rect();
            this.f1298c = new Rect();
            m1106a(rect, rect2);
            this.f1296a = view;
        }

        /* renamed from: a */
        public void m1106a(Rect rect, Rect rect2) {
            this.f1297b.set(rect);
            this.f1299d.set(rect);
            this.f1299d.inset(-this.f1300e, -this.f1300e);
            this.f1298c.set(rect2);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            boolean z2;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.f1297b.contains(x, y)) {
                        this.f1301f = true;
                        z2 = true;
                        z = true;
                        break;
                    }
                    z2 = true;
                    z = false;
                    break;
                case 1:
                case 2:
                    z = this.f1301f;
                    if (z && !this.f1299d.contains(x, y)) {
                        z2 = false;
                        break;
                    }
                    z2 = true;
                    break;
                case 3:
                    z = this.f1301f;
                    this.f1301f = false;
                    z2 = true;
                    break;
                default:
                    z2 = true;
                    z = false;
                    break;
            }
            if (!z) {
                return false;
            }
            if (z2 && !this.f1298c.contains(x, y)) {
                motionEvent.setLocation(this.f1296a.getWidth() / 2, this.f1296a.getHeight() / 2);
            } else {
                motionEvent.setLocation(x - this.f1298c.left, y - this.f1298c.top);
            }
            return this.f1296a.dispatchTouchEvent(motionEvent);
        }
    }

    public static class SearchAutoComplete extends C0195e {

        /* renamed from: a */
        final Runnable f1287a;

        /* renamed from: b */
        private int f1288b;

        /* renamed from: c */
        private SearchView f1289c;

        /* renamed from: d */
        private boolean f1290d;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, C0059a.a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f1287a = new Runnable() { // from class: androidx.appcompat.widget.SearchView.SearchAutoComplete.1
                @Override // java.lang.Runnable
                public void run() {
                    SearchAutoComplete.this.m1092b();
                }
            };
            this.f1288b = getThreshold();
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        void setSearchView(SearchView searchView) {
            this.f1289c = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f1288b = i;
        }

        /* renamed from: a */
        boolean m1091a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f1289c.hasFocus() && getVisibility() == 0) {
                this.f1290d = true;
                if (SearchView.m1060a(getContext())) {
                    m1093c();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f1289c.m1088i();
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f1288b <= 0 || super.enoughToFilter();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1289c.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i >= 600 || (i >= 640 && i2 >= 480)) {
                return 192;
            }
            return 160;
        }

        @Override // androidx.appcompat.widget.C0195e, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f1290d) {
                removeCallbacks(this.f1287a);
                post(this.f1287a);
            }
            return onCreateInputConnection;
        }

        /* renamed from: b */
        void m1092b() {
            if (this.f1290d) {
                ((InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(this, 0);
                this.f1290d = false;
            }
        }

        void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (!z) {
                this.f1290d = false;
                removeCallbacks(this.f1287a);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (inputMethodManager.isActive(this)) {
                    this.f1290d = false;
                    removeCallbacks(this.f1287a);
                    inputMethodManager.showSoftInput(this, 0);
                    return;
                }
                this.f1290d = true;
            }
        }

        /* renamed from: c */
        void m1093c() {
            if (Build.VERSION.SDK_INT >= 29) {
                setInputMethodMode(1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            SearchView.f1226i.m1102c(this);
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$d */
    private static class C0147d {

        /* renamed from: a */
        private Method f1292a;

        /* renamed from: b */
        private Method f1293b;

        /* renamed from: c */
        private Method f1294c;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        C0147d() {
            this.f1292a = null;
            this.f1293b = null;
            this.f1294c = null;
            m1099a();
            try {
                this.f1292a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f1292a.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            try {
                this.f1293b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f1293b.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
            try {
                this.f1294c = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f1294c.setAccessible(true);
            } catch (NoSuchMethodException e4) {
            }
        }

        /* renamed from: a */
        void m1100a(AutoCompleteTextView autoCompleteTextView) {
            m1099a();
            if (this.f1292a != null) {
                try {
                    this.f1292a.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e2) {
                }
            }
        }

        /* renamed from: b */
        void m1101b(AutoCompleteTextView autoCompleteTextView) {
            m1099a();
            if (this.f1293b != null) {
                try {
                    this.f1293b.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e2) {
                }
            }
        }

        /* renamed from: c */
        void m1102c(AutoCompleteTextView autoCompleteTextView) {
            m1099a();
            if (this.f1294c != null) {
                try {
                    this.f1294c.invoke(autoCompleteTextView, true);
                } catch (Exception e2) {
                }
            }
        }

        /* renamed from: a */
        private static void m1099a() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }
    }
}
