package androidx.appcompat.app;

import android.C0012R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.appcompat.widget.C0169ak;
import androidx.core.p031f.C0308x;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class AlertController {

    /* renamed from: A */
    private int f429A;

    /* renamed from: C */
    private CharSequence f431C;

    /* renamed from: D */
    private Drawable f432D;

    /* renamed from: E */
    private CharSequence f433E;

    /* renamed from: F */
    private Drawable f434F;

    /* renamed from: G */
    private CharSequence f435G;

    /* renamed from: H */
    private Drawable f436H;

    /* renamed from: J */
    private Drawable f438J;

    /* renamed from: K */
    private ImageView f439K;

    /* renamed from: L */
    private TextView f440L;

    /* renamed from: M */
    private TextView f441M;

    /* renamed from: N */
    private View f442N;

    /* renamed from: O */
    private int f443O;

    /* renamed from: P */
    private int f444P;

    /* renamed from: Q */
    private boolean f445Q;

    /* renamed from: a */
    final DialogC0075g f448a;

    /* renamed from: b */
    ListView f449b;

    /* renamed from: c */
    Button f450c;

    /* renamed from: d */
    Message f451d;

    /* renamed from: e */
    Button f452e;

    /* renamed from: f */
    Message f453f;

    /* renamed from: g */
    Button f454g;

    /* renamed from: h */
    Message f455h;

    /* renamed from: i */
    NestedScrollView f456i;

    /* renamed from: j */
    ListAdapter f457j;

    /* renamed from: l */
    int f459l;

    /* renamed from: m */
    int f460m;

    /* renamed from: n */
    int f461n;

    /* renamed from: o */
    int f462o;

    /* renamed from: p */
    Handler f463p;

    /* renamed from: q */
    private final Context f464q;

    /* renamed from: r */
    private final Window f465r;

    /* renamed from: s */
    private final int f466s;

    /* renamed from: t */
    private CharSequence f467t;

    /* renamed from: u */
    private CharSequence f468u;

    /* renamed from: v */
    private View f469v;

    /* renamed from: w */
    private int f470w;

    /* renamed from: x */
    private int f471x;

    /* renamed from: y */
    private int f472y;

    /* renamed from: z */
    private int f473z;

    /* renamed from: B */
    private boolean f430B = false;

    /* renamed from: I */
    private int f437I = 0;

    /* renamed from: k */
    int f458k = -1;

    /* renamed from: R */
    private int f446R = 0;

    /* renamed from: S */
    private final View.OnClickListener f447S = new View.OnClickListener() { // from class: androidx.appcompat.app.AlertController.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            if (view == AlertController.this.f450c && AlertController.this.f451d != null) {
                message = Message.obtain(AlertController.this.f451d);
            } else if (view == AlertController.this.f452e && AlertController.this.f453f != null) {
                message = Message.obtain(AlertController.this.f453f);
            } else if (view == AlertController.this.f454g && AlertController.this.f455h != null) {
                message = Message.obtain(AlertController.this.f455h);
            } else {
                message = null;
            }
            if (message != null) {
                message.sendToTarget();
            }
            AlertController.this.f463p.obtainMessage(1, AlertController.this.f448a).sendToTarget();
        }
    };

    /* renamed from: androidx.appcompat.app.AlertController$b */
    private static final class HandlerC0067b extends Handler {

        /* renamed from: a */
        private WeakReference<DialogInterface> f543a;

        public HandlerC0067b(DialogInterface dialogInterface) {
            this.f543a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case -3:
                case -2:
                case -1:
                    ((DialogInterface.OnClickListener) message.obj).onClick(this.f543a.get(), message.what);
                    break;
                case 1:
                    ((DialogInterface) message.obj).dismiss();
                    break;
            }
        }
    }

    /* renamed from: a */
    private static boolean m357a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0059a.a.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    public AlertController(Context context, DialogC0075g dialogC0075g, Window window) {
        this.f464q = context;
        this.f448a = dialogC0075g;
        this.f465r = window;
        this.f463p = new HandlerC0067b(dialogC0075g);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, C0059a.j.AlertDialog, C0059a.a.alertDialogStyle, 0);
        this.f443O = obtainStyledAttributes.getResourceId(C0059a.j.AlertDialog_android_layout, 0);
        this.f444P = obtainStyledAttributes.getResourceId(C0059a.j.AlertDialog_buttonPanelSideLayout, 0);
        this.f459l = obtainStyledAttributes.getResourceId(C0059a.j.AlertDialog_listLayout, 0);
        this.f460m = obtainStyledAttributes.getResourceId(C0059a.j.AlertDialog_multiChoiceItemLayout, 0);
        this.f461n = obtainStyledAttributes.getResourceId(C0059a.j.AlertDialog_singleChoiceItemLayout, 0);
        this.f462o = obtainStyledAttributes.getResourceId(C0059a.j.AlertDialog_listItemLayout, 0);
        this.f445Q = obtainStyledAttributes.getBoolean(C0059a.j.AlertDialog_showTitle, true);
        this.f466s = obtainStyledAttributes.getDimensionPixelSize(C0059a.j.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        dialogC0075g.m584b(1);
    }

    /* renamed from: a */
    static boolean m358a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (m358a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void m364a() {
        this.f448a.setContentView(m360c());
        m362d();
    }

    /* renamed from: c */
    private int m360c() {
        if (this.f444P == 0) {
            return this.f443O;
        }
        if (this.f446R == 1) {
            return this.f444P;
        }
        return this.f443O;
    }

    /* renamed from: a */
    public void m369a(CharSequence charSequence) {
        this.f467t = charSequence;
        if (this.f440L != null) {
            this.f440L.setText(charSequence);
        }
    }

    /* renamed from: b */
    public void m373b(View view) {
        this.f442N = view;
    }

    /* renamed from: b */
    public void m374b(CharSequence charSequence) {
        this.f468u = charSequence;
        if (this.f441M != null) {
            this.f441M.setText(charSequence);
        }
    }

    /* renamed from: a */
    public void m365a(int i) {
        this.f469v = null;
        this.f470w = i;
        this.f430B = false;
    }

    /* renamed from: c */
    public void m377c(View view) {
        this.f469v = view;
        this.f470w = 0;
        this.f430B = false;
    }

    /* renamed from: a */
    public void m368a(View view, int i, int i2, int i3, int i4) {
        this.f469v = view;
        this.f470w = 0;
        this.f430B = true;
        this.f471x = i;
        this.f472y = i2;
        this.f473z = i3;
        this.f429A = i4;
    }

    /* renamed from: a */
    public void m366a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f463p.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.f435G = charSequence;
                this.f455h = message;
                this.f436H = drawable;
                return;
            case -2:
                this.f433E = charSequence;
                this.f453f = message;
                this.f434F = drawable;
                return;
            case -1:
                this.f431C = charSequence;
                this.f451d = message;
                this.f432D = drawable;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    /* renamed from: b */
    public void m372b(int i) {
        this.f438J = null;
        this.f437I = i;
        if (this.f439K != null) {
            if (i != 0) {
                this.f439K.setVisibility(0);
                this.f439K.setImageResource(this.f437I);
            } else {
                this.f439K.setVisibility(8);
            }
        }
    }

    /* renamed from: a */
    public void m367a(Drawable drawable) {
        this.f438J = drawable;
        this.f437I = 0;
        if (this.f439K != null) {
            if (drawable != null) {
                this.f439K.setVisibility(0);
                this.f439K.setImageDrawable(drawable);
            } else {
                this.f439K.setVisibility(8);
            }
        }
    }

    /* renamed from: c */
    public int m376c(int i) {
        TypedValue typedValue = new TypedValue();
        this.f464q.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    /* renamed from: b */
    public ListView m371b() {
        return this.f449b;
    }

    /* renamed from: d */
    public Button m378d(int i) {
        switch (i) {
            case -3:
                return this.f454g;
            case -2:
                return this.f452e;
            case -1:
                return this.f450c;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public boolean m370a(int i, KeyEvent keyEvent) {
        return this.f456i != null && this.f456i.m2452a(keyEvent);
    }

    /* renamed from: b */
    public boolean m375b(int i, KeyEvent keyEvent) {
        return this.f456i != null && this.f456i.m2452a(keyEvent);
    }

    /* renamed from: a */
    private ViewGroup m352a(View view, View view2) {
        if (view == null) {
            return (ViewGroup) (view2 instanceof ViewStub ? ((ViewStub) view2).inflate() : view2);
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        return (ViewGroup) (view instanceof ViewStub ? ((ViewStub) view).inflate() : view);
    }

    /* renamed from: d */
    private void m362d() {
        View findViewById;
        View findViewById2;
        View findViewById3 = this.f465r.findViewById(C0059a.f.parentPanel);
        View findViewById4 = findViewById3.findViewById(C0059a.f.topPanel);
        View findViewById5 = findViewById3.findViewById(C0059a.f.contentPanel);
        View findViewById6 = findViewById3.findViewById(C0059a.f.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(C0059a.f.customPanel);
        m354a(viewGroup);
        View findViewById7 = viewGroup.findViewById(C0059a.f.topPanel);
        View findViewById8 = viewGroup.findViewById(C0059a.f.contentPanel);
        View findViewById9 = viewGroup.findViewById(C0059a.f.buttonPanel);
        ViewGroup m352a = m352a(findViewById7, findViewById4);
        ViewGroup m352a2 = m352a(findViewById8, findViewById5);
        ViewGroup m352a3 = m352a(findViewById9, findViewById6);
        m361c(m352a2);
        m363d(m352a3);
        m359b(m352a);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (m352a == null || m352a.getVisibility() == 8) ? false : true;
        boolean z3 = (m352a3 == null || m352a3.getVisibility() == 8) ? false : true;
        if (!z3 && m352a2 != null && (findViewById2 = m352a2.findViewById(C0059a.f.textSpacerNoButtons)) != null) {
            findViewById2.setVisibility(0);
        }
        if (z2) {
            if (this.f456i != null) {
                this.f456i.setClipToPadding(true);
            }
            View view = null;
            if (this.f468u != null || this.f449b != null) {
                view = m352a.findViewById(C0059a.f.titleDividerNoCustom);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (m352a2 != null && (findViewById = m352a2.findViewById(C0059a.f.textSpacerNoTitle)) != null) {
            findViewById.setVisibility(0);
        }
        if (this.f449b instanceof RecycleListView) {
            ((RecycleListView) this.f449b).m380a(z2, z3);
        }
        if (!z) {
            View view2 = this.f449b != null ? this.f449b : this.f456i;
            if (view2 != null) {
                m355a(m352a2, view2, (z3 ? 2 : 0) | (z2 ? 1 : 0), 3);
            }
        }
        ListView listView = this.f449b;
        if (listView != null && this.f457j != null) {
            listView.setAdapter(this.f457j);
            int i = this.f458k;
            if (i > -1) {
                listView.setItemChecked(i, true);
                listView.setSelection(i);
            }
        }
    }

    /* renamed from: a */
    private void m355a(ViewGroup viewGroup, View view, int i, int i2) {
        final View view2 = null;
        final View findViewById = this.f465r.findViewById(C0059a.f.scrollIndicatorUp);
        View findViewById2 = this.f465r.findViewById(C0059a.f.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            C0308x.m2228a(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById != null || view2 != null) {
            if (this.f468u != null) {
                this.f456i.setOnScrollChangeListener(new NestedScrollView.InterfaceC0329b() { // from class: androidx.appcompat.app.AlertController.2
                    @Override // androidx.core.widget.NestedScrollView.InterfaceC0329b
                    /* renamed from: a */
                    public void mo379a(NestedScrollView nestedScrollView, int i3, int i4, int i5, int i6) {
                        AlertController.m353a(nestedScrollView, findViewById, view2);
                    }
                });
                this.f456i.post(new Runnable() { // from class: androidx.appcompat.app.AlertController.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlertController.m353a(AlertController.this.f456i, findViewById, view2);
                    }
                });
            } else {
                if (this.f449b != null) {
                    this.f449b.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: androidx.appcompat.app.AlertController.4
                        @Override // android.widget.AbsListView.OnScrollListener
                        public void onScrollStateChanged(AbsListView absListView, int i3) {
                        }

                        @Override // android.widget.AbsListView.OnScrollListener
                        public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
                            AlertController.m353a(absListView, findViewById, view2);
                        }
                    });
                    this.f449b.post(new Runnable() { // from class: androidx.appcompat.app.AlertController.5
                        @Override // java.lang.Runnable
                        public void run() {
                            AlertController.m353a(AlertController.this.f449b, findViewById, view2);
                        }
                    });
                    return;
                }
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (view2 != null) {
                    viewGroup.removeView(view2);
                }
            }
        }
    }

    /* renamed from: a */
    private void m354a(ViewGroup viewGroup) {
        View view;
        if (this.f469v != null) {
            view = this.f469v;
        } else if (this.f470w != 0) {
            view = LayoutInflater.from(this.f464q).inflate(this.f470w, viewGroup, false);
        } else {
            view = null;
        }
        boolean z = view != null;
        if (!z || !m358a(view)) {
            this.f465r.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f465r.findViewById(C0059a.f.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.f430B) {
                frameLayout.setPadding(this.f471x, this.f472y, this.f473z, this.f429A);
            }
            if (this.f449b != null) {
                ((C0169ak.a) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* renamed from: b */
    private void m359b(ViewGroup viewGroup) {
        if (this.f442N != null) {
            viewGroup.addView(this.f442N, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f465r.findViewById(C0059a.f.title_template).setVisibility(8);
            return;
        }
        this.f439K = (ImageView) this.f465r.findViewById(C0012R.id.icon);
        if ((!TextUtils.isEmpty(this.f467t)) && this.f445Q) {
            this.f440L = (TextView) this.f465r.findViewById(C0059a.f.alertTitle);
            this.f440L.setText(this.f467t);
            if (this.f437I != 0) {
                this.f439K.setImageResource(this.f437I);
                return;
            } else if (this.f438J != null) {
                this.f439K.setImageDrawable(this.f438J);
                return;
            } else {
                this.f440L.setPadding(this.f439K.getPaddingLeft(), this.f439K.getPaddingTop(), this.f439K.getPaddingRight(), this.f439K.getPaddingBottom());
                this.f439K.setVisibility(8);
                return;
            }
        }
        this.f465r.findViewById(C0059a.f.title_template).setVisibility(8);
        this.f439K.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    /* renamed from: c */
    private void m361c(ViewGroup viewGroup) {
        this.f456i = (NestedScrollView) this.f465r.findViewById(C0059a.f.scrollView);
        this.f456i.setFocusable(false);
        this.f456i.setNestedScrollingEnabled(false);
        this.f441M = (TextView) viewGroup.findViewById(C0012R.id.message);
        if (this.f441M != null) {
            if (this.f468u != null) {
                this.f441M.setText(this.f468u);
                return;
            }
            this.f441M.setVisibility(8);
            this.f456i.removeView(this.f441M);
            if (this.f449b != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.f456i.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.f456i);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f449b, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    /* renamed from: a */
    static void m353a(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    /* renamed from: d */
    private void m363d(ViewGroup viewGroup) {
        int i;
        this.f450c = (Button) viewGroup.findViewById(C0012R.id.button1);
        this.f450c.setOnClickListener(this.f447S);
        if (TextUtils.isEmpty(this.f431C) && this.f432D == null) {
            this.f450c.setVisibility(8);
            i = 0;
        } else {
            this.f450c.setText(this.f431C);
            if (this.f432D != null) {
                this.f432D.setBounds(0, 0, this.f466s, this.f466s);
                this.f450c.setCompoundDrawables(this.f432D, null, null, null);
            }
            this.f450c.setVisibility(0);
            i = 1;
        }
        this.f452e = (Button) viewGroup.findViewById(C0012R.id.button2);
        this.f452e.setOnClickListener(this.f447S);
        if (TextUtils.isEmpty(this.f433E) && this.f434F == null) {
            this.f452e.setVisibility(8);
        } else {
            this.f452e.setText(this.f433E);
            if (this.f434F != null) {
                this.f434F.setBounds(0, 0, this.f466s, this.f466s);
                this.f452e.setCompoundDrawables(this.f434F, null, null, null);
            }
            this.f452e.setVisibility(0);
            i |= 2;
        }
        this.f454g = (Button) viewGroup.findViewById(C0012R.id.button3);
        this.f454g.setOnClickListener(this.f447S);
        if (TextUtils.isEmpty(this.f435G) && this.f436H == null) {
            this.f454g.setVisibility(8);
        } else {
            this.f454g.setText(this.f435G);
            if (this.f436H != null) {
                this.f436H.setBounds(0, 0, this.f466s, this.f466s);
                this.f454g.setCompoundDrawables(this.f436H, null, null, null);
            }
            this.f454g.setVisibility(0);
            i |= 4;
        }
        if (m357a(this.f464q)) {
            if (i == 1) {
                m356a(this.f450c);
            } else if (i == 2) {
                m356a(this.f452e);
            } else if (i == 4) {
                m356a(this.f454g);
            }
        }
        if (!(i != 0)) {
            viewGroup.setVisibility(8);
        }
    }

    /* renamed from: a */
    private void m356a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public static class RecycleListView extends ListView {

        /* renamed from: a */
        private final int f487a;

        /* renamed from: b */
        private final int f488b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0059a.j.RecycleListView);
            this.f488b = obtainStyledAttributes.getDimensionPixelOffset(C0059a.j.RecycleListView_paddingBottomNoButtons, -1);
            this.f487a = obtainStyledAttributes.getDimensionPixelOffset(C0059a.j.RecycleListView_paddingTopNoTitle, -1);
        }

        /* renamed from: a */
        public void m380a(boolean z, boolean z2) {
            if (!z2 || !z) {
                setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f487a, getPaddingRight(), z2 ? getPaddingBottom() : this.f488b);
            }
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$a */
    public static class C0066a {

        /* renamed from: A */
        public int f489A;

        /* renamed from: B */
        public int f490B;

        /* renamed from: C */
        public int f491C;

        /* renamed from: D */
        public int f492D;

        /* renamed from: F */
        public boolean[] f494F;

        /* renamed from: G */
        public boolean f495G;

        /* renamed from: H */
        public boolean f496H;

        /* renamed from: J */
        public DialogInterface.OnMultiChoiceClickListener f498J;

        /* renamed from: K */
        public Cursor f499K;

        /* renamed from: L */
        public String f500L;

        /* renamed from: M */
        public String f501M;

        /* renamed from: N */
        public AdapterView.OnItemSelectedListener f502N;

        /* renamed from: O */
        public a f503O;

        /* renamed from: a */
        public final Context f505a;

        /* renamed from: b */
        public final LayoutInflater f506b;

        /* renamed from: d */
        public Drawable f508d;

        /* renamed from: f */
        public CharSequence f510f;

        /* renamed from: g */
        public View f511g;

        /* renamed from: h */
        public CharSequence f512h;

        /* renamed from: i */
        public CharSequence f513i;

        /* renamed from: j */
        public Drawable f514j;

        /* renamed from: k */
        public DialogInterface.OnClickListener f515k;

        /* renamed from: l */
        public CharSequence f516l;

        /* renamed from: m */
        public Drawable f517m;

        /* renamed from: n */
        public DialogInterface.OnClickListener f518n;

        /* renamed from: o */
        public CharSequence f519o;

        /* renamed from: p */
        public Drawable f520p;

        /* renamed from: q */
        public DialogInterface.OnClickListener f521q;

        /* renamed from: s */
        public DialogInterface.OnCancelListener f523s;

        /* renamed from: t */
        public DialogInterface.OnDismissListener f524t;

        /* renamed from: u */
        public DialogInterface.OnKeyListener f525u;

        /* renamed from: v */
        public CharSequence[] f526v;

        /* renamed from: w */
        public ListAdapter f527w;

        /* renamed from: x */
        public DialogInterface.OnClickListener f528x;

        /* renamed from: y */
        public int f529y;

        /* renamed from: z */
        public View f530z;

        /* renamed from: c */
        public int f507c = 0;

        /* renamed from: e */
        public int f509e = 0;

        /* renamed from: E */
        public boolean f493E = false;

        /* renamed from: I */
        public int f497I = -1;

        /* renamed from: P */
        public boolean f504P = true;

        /* renamed from: r */
        public boolean f522r = true;

        /* renamed from: androidx.appcompat.app.AlertController$a$a */
        public interface a {
            /* renamed from: a */
            void m383a(ListView listView);
        }

        public C0066a(Context context) {
            this.f505a = context;
            this.f506b = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        /* renamed from: a */
        public void m382a(AlertController alertController) {
            if (this.f511g != null) {
                alertController.m373b(this.f511g);
            } else {
                if (this.f510f != null) {
                    alertController.m369a(this.f510f);
                }
                if (this.f508d != null) {
                    alertController.m367a(this.f508d);
                }
                if (this.f507c != 0) {
                    alertController.m372b(this.f507c);
                }
                if (this.f509e != 0) {
                    alertController.m372b(alertController.m376c(this.f509e));
                }
            }
            if (this.f512h != null) {
                alertController.m374b(this.f512h);
            }
            if (this.f513i != null || this.f514j != null) {
                alertController.m366a(-1, this.f513i, this.f515k, (Message) null, this.f514j);
            }
            if (this.f516l != null || this.f517m != null) {
                alertController.m366a(-2, this.f516l, this.f518n, (Message) null, this.f517m);
            }
            if (this.f519o != null || this.f520p != null) {
                alertController.m366a(-3, this.f519o, this.f521q, (Message) null, this.f520p);
            }
            if (this.f526v != null || this.f499K != null || this.f527w != null) {
                m381b(alertController);
            }
            if (this.f530z != null) {
                if (this.f493E) {
                    alertController.m368a(this.f530z, this.f489A, this.f490B, this.f491C, this.f492D);
                    return;
                } else {
                    alertController.m377c(this.f530z);
                    return;
                }
            }
            if (this.f529y != 0) {
                alertController.m365a(this.f529y);
            }
        }

        /* renamed from: b */
        private void m381b(final AlertController alertController) {
            int i;
            ListAdapter c0068c;
            int i2 = C0012R.id.text1;
            boolean z = false;
            final RecycleListView recycleListView = (RecycleListView) this.f506b.inflate(alertController.f459l, (ViewGroup) null);
            if (this.f495G) {
                if (this.f499K == null) {
                    c0068c = new ArrayAdapter<CharSequence>(this.f505a, alertController.f460m, i2, this.f526v) { // from class: androidx.appcompat.app.AlertController.a.1
                        @Override // android.widget.ArrayAdapter, android.widget.Adapter
                        public View getView(int i3, View view, ViewGroup viewGroup) {
                            View view2 = super.getView(i3, view, viewGroup);
                            if (C0066a.this.f494F != null && C0066a.this.f494F[i3]) {
                                recycleListView.setItemChecked(i3, true);
                            }
                            return view2;
                        }
                    };
                } else {
                    c0068c = new CursorAdapter(this.f505a, this.f499K, z) { // from class: androidx.appcompat.app.AlertController.a.2

                        /* renamed from: d */
                        private final int f536d;

                        /* renamed from: e */
                        private final int f537e;

                        {
                            Cursor cursor = getCursor();
                            this.f536d = cursor.getColumnIndexOrThrow(C0066a.this.f500L);
                            this.f537e = cursor.getColumnIndexOrThrow(C0066a.this.f501M);
                        }

                        @Override // android.widget.CursorAdapter
                        public void bindView(View view, Context context, Cursor cursor) {
                            ((CheckedTextView) view.findViewById(C0012R.id.text1)).setText(cursor.getString(this.f536d));
                            recycleListView.setItemChecked(cursor.getPosition(), cursor.getInt(this.f537e) == 1);
                        }

                        @Override // android.widget.CursorAdapter
                        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                            return C0066a.this.f506b.inflate(alertController.f460m, viewGroup, false);
                        }
                    };
                }
            } else {
                if (this.f496H) {
                    i = alertController.f461n;
                } else {
                    i = alertController.f462o;
                }
                if (this.f499K != null) {
                    c0068c = new SimpleCursorAdapter(this.f505a, i, this.f499K, new String[]{this.f500L}, new int[]{C0012R.id.text1});
                } else if (this.f527w != null) {
                    c0068c = this.f527w;
                } else {
                    c0068c = new C0068c(this.f505a, i, C0012R.id.text1, this.f526v);
                }
            }
            if (this.f503O != null) {
                this.f503O.m383a(recycleListView);
            }
            alertController.f457j = c0068c;
            alertController.f458k = this.f497I;
            if (this.f528x != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.a.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                        C0066a.this.f528x.onClick(alertController.f448a, i3);
                        if (!C0066a.this.f496H) {
                            alertController.f448a.dismiss();
                        }
                    }
                });
            } else if (this.f498J != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.a.4
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                        if (C0066a.this.f494F != null) {
                            C0066a.this.f494F[i3] = recycleListView.isItemChecked(i3);
                        }
                        C0066a.this.f498J.onClick(alertController.f448a, i3, recycleListView.isItemChecked(i3));
                    }
                });
            }
            if (this.f502N != null) {
                recycleListView.setOnItemSelectedListener(this.f502N);
            }
            if (this.f496H) {
                recycleListView.setChoiceMode(1);
            } else if (this.f495G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f449b = recycleListView;
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$c */
    private static class C0068c extends ArrayAdapter<CharSequence> {
        public C0068c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }
    }
}
