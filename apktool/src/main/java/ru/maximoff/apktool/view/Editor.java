package ru.maximoff.apktool.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import androidx.appcompat.widget.SearchView;
import com.p159h.p160a.p161a.C1371c;
import com.p159h.p160a.p161a.C1378j;
import com.p159h.p160a.p162b.AbstractRunnableC1391m;
import com.p159h.p160a.p162b.C1382d;
import com.p159h.p160a.p162b.C1383e;
import com.p159h.p160a.p162b.C1384f;
import com.p159h.p160a.p162b.C1385g;
import com.p159h.p160a.p162b.C1386h;
import com.p159h.p160a.p162b.C1393o;
import com.p159h.p160a.p162b.C1396r;
import com.p159h.p160a.p162b.C1397s;
import com.srizwan.apktool.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ru.maximoff.apktool.p296a.C2883c;
import ru.maximoff.apktool.p296a.C2892l;
import ru.maximoff.apktool.p296a.C2893m;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;

/* loaded from: classes.dex */
public class Editor extends C1371c {

    /* renamed from: t */
    private boolean f20787t;

    /* renamed from: u */
    private InterfaceC3272a f20788u;

    /* renamed from: v */
    private ScaleGestureDetector f20789v;

    /* renamed from: w */
    private float f20790w;

    /* renamed from: x */
    private boolean f20791x;

    /* renamed from: y */
    private C3301c f20792y;

    /* renamed from: z */
    private boolean f20793z;

    /* renamed from: ru.maximoff.apktool.view.Editor$a */
    public interface InterfaceC3272a {
        /* renamed from: aw */
        void mo17649aw();
    }

    public Editor(Context context) {
        this(context, (AttributeSet) null);
    }

    public Editor(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Editor(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20787t = true;
        this.f20793z = false;
        m19740b(context);
    }

    /* renamed from: h */
    public void m19756h(boolean z) {
        if (z) {
            if (C3102bd.f18287W) {
                setLexTask(C1396r.f9139c);
            } else {
                AbstractRunnableC1391m lexTask = getLexTask();
                if (lexTask instanceof C2892l) {
                    setLexTask(new C2892l(lexTask.m11086a()));
                } else if (lexTask instanceof C2893m) {
                    setLexTask(new C2893m(lexTask.m11086a()));
                }
            }
        }
        setTypeface(C3102bd.f18327j);
        setTextSize(C3102bd.f18329l);
        setAutoIndentWidth(C3102bd.f18335r);
        setShowLineNumbers(C3102bd.f18342y);
        setFixLineNumbers(C3102bd.f18343z && C3102bd.f18342y);
        setNonPrintingCharVisibility(C3102bd.f18282R);
        setWordWrap(C3102bd.f18341x);
        m10893e(C3102bd.f18265A);
        setFastScrollEnabled(C3102bd.f18283S);
        m10881b(C3102bd.f18304al);
        m10885c(C3102bd.f18285U);
        setHighlightCurrentRow(true);
        m10889d(C3102bd.f18307ao);
        m10897g();
    }

    /* renamed from: k */
    public void m19757k(int i) {
        int m11053g = this.f8908c.m11053g();
        if (i <= m11053g) {
            m11053g = i;
        }
        if (m11053g <= 0) {
            m11053g = 1;
        }
        setSelection(this.f8908c.m11049e(m11053g - 1));
    }

    public void setSelection(int i) {
        m10895f(false);
        m10874a(true);
        m10901h(i);
    }

    public void setEditable(boolean z) {
        this.f20787t = z;
        super.mo10898g(z);
    }

    /* renamed from: b */
    private void m19740b(Context context) {
        this.f20789v = new ScaleGestureDetector(context, new C3273b(this));
        setFastScrollEnabled(C3102bd.f18283S);
        setFocusable(true);
        setClickable(true);
        setFocusableInTouchMode(true);
        setAutoIndentWidth(C3102bd.f18335r);
        setShowLineNumbers(C3102bd.f18342y);
        setFixLineNumbers(C3102bd.f18343z && C3102bd.f18342y);
        setTypeface(C3102bd.f18327j);
        setTextSize(C3102bd.f18329l);
        setNonPrintingCharVisibility(C3102bd.f18282R);
        setWordWrap(C3102bd.f18341x);
        m10893e(C3102bd.f18265A);
        m10881b(C3102bd.f18304al);
        m10885c(C3102bd.f18285U);
        setNavigationMethod(new C1378j(this));
        setHighlightCurrentRow(true);
        setContentDescription(context.getString(R.string.editor));
        m10889d(C3102bd.f18307ao);
        this.f20790w = getZoom();
        m19741K();
    }

    @Override // com.p159h.p160a.p161a.C1371c, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f20792y != null) {
            this.f20792y.m19844a(canvas);
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f20792y != null) {
            this.f20792y.m19843a(getScrollY(), getHeight(), getMaxScrollY());
        }
        this.f20793z = true;
    }

    @Override // com.p159h.p160a.p161a.C1371c
    public void setFastScrollEnabled(boolean z) {
        super.setFastScrollEnabled(z);
        this.f20791x = z;
        if (z) {
            if (this.f20792y == null) {
                this.f20792y = new C3301c(getContext(), this);
            }
        } else if (this.f20792y != null) {
            this.f20792y.m19847b();
            this.f20792y = (C3301c) null;
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0) {
            switch (motionEvent.getAction()) {
                case 8:
                    scrollTo(Math.min(getScrollX(), getMaxScrollX()), ((int) motionEvent.getAxisValue(9)) * 100);
                    return true;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    /* renamed from: K */
    public void m19741K() {
        switch (C3102bd.f18319b) {
            case 1:
                setColorScheme(new C1383e());
                break;
            case 2:
                setColorScheme(new C1382d());
                break;
            default:
                setColorScheme(new C1384f());
                break;
        }
        m10897g();
    }

    @Override // com.p159h.p160a.p161a.C1371c
    public void setTextSize(int i) {
        super.setTextSize(C3080al.m18522a(getContext(), i));
    }

    public void setText(CharSequence charSequence) {
        C1385g c1385g = new C1385g(this);
        c1385g.m11022a(charSequence);
        setDocumentProvider(new C1386h(c1385g));
        m10883c();
    }

    public CharSequence getText() {
        return m10890e();
    }

    @Override // com.p159h.p160a.p161a.C1371c
    /* renamed from: g */
    protected void mo10898g(boolean z) {
        if (!this.f20787t) {
            z = false;
        }
        super.mo10898g(z);
        getParent().requestLayout();
    }

    /* renamed from: L */
    public boolean m19742L() {
        return this.f8908c.m11061n();
    }

    /* renamed from: M */
    public boolean m19743M() {
        return this.f8908c.m11060m();
    }

    /* renamed from: N */
    public void m19744N() {
        this.f8908c.m11064q();
    }

    /* renamed from: a */
    public void m19752a(SearchView searchView) {
        int m11053g = this.f8908c.m11053g();
        searchView.setInputType(2);
        searchView.setQueryHint(new StringBuffer().append("1 - ").append(m11053g).toString());
        searchView.setOnQueryTextListener(new SearchView.InterfaceC0145b(this, m11053g) { // from class: ru.maximoff.apktool.view.Editor.1

            /* renamed from: a */
            private final Editor f20794a;

            /* renamed from: b */
            private final int f20795b;

            {
                this.f20794a = this;
                this.f20795b = m11053g;
            }

            @Override // androidx.appcompat.widget.SearchView.InterfaceC0145b
            /* renamed from: a */
            public boolean mo1095a(String str) {
                return false;
            }

            @Override // androidx.appcompat.widget.SearchView.InterfaceC0145b
            /* renamed from: b */
            public boolean mo1096b(String str) {
                int i;
                if (str.length() > 0) {
                    try {
                        i = Integer.parseInt(str);
                    } catch (Exception e2) {
                        i = this.f20795b;
                    }
                    this.f20794a.m19757k(i);
                    return true;
                }
                return true;
            }
        });
    }

    /* renamed from: a */
    public int m19747a(String str, int i, boolean z, boolean z2) {
        if (str.isEmpty()) {
            return 0;
        }
        int[] m11105a = new C1393o(getLexTask().m11093e()).m11105a(m10890e(), str, i, z, z2, false, false);
        int i2 = m11105a[0];
        int i3 = m11105a[1];
        if (i2 != -1) {
            return i2 + i3;
        }
        return 0;
    }

    /* renamed from: a */
    public int m19751a(String str, boolean z, boolean z2) {
        return new C1393o(getLexTask().m11093e()).m11101a(m10890e(), str, z, z2);
    }

    /* renamed from: a */
    public int m19748a(String str, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        if (str.isEmpty()) {
            m10895f(false);
            return 0;
        }
        int[] m11105a = new C1393o(getLexTask().m11093e()).m11105a(m10890e(), str, i, z, z2, z3, z4);
        int i2 = m11105a[0];
        int i3 = m11105a[1];
        if (i2 == -1) {
            C3112bn.m19023b(getContext(), getContext().getString(R.string.not_found));
            m10895f(false);
            return 0;
        }
        m10888d(i2, i3);
        int i4 = i3 + i2;
        m10874a(true);
        m10901h(i4);
        return i4;
    }

    /* renamed from: b */
    public int m19753b(String str, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        if (str.isEmpty()) {
            m10895f(false);
            return 0;
        }
        int[] m11108b = new C1393o(getLexTask().m11093e()).m11108b(m10890e(), str, i, z, z2, z3, z4);
        int i2 = m11108b[0];
        int i3 = m11108b[1];
        if (i2 == -1) {
            C3112bn.m19023b(getContext(), getContext().getString(R.string.not_found));
            m10895f(false);
            return 0;
        }
        m10888d(i2, i3);
        m10874a(true);
        m10901h(i3 + i2);
        return i2 - 1;
    }

    /* renamed from: a */
    public int m19749a(String str, String str2, int i, boolean z, boolean z2, boolean z3) {
        if (str.isEmpty()) {
            m10895f(false);
            return 0;
        }
        C1393o c1393o = new C1393o(getLexTask().m11093e());
        int length = str2.length();
        int m11100a = c1393o.m11100a(m10890e(), str, str2, i, z, z2, z3);
        if (m11100a == -1) {
            C3112bn.m19023b(getContext(), getContext().getString(R.string.not_found));
            m10895f(false);
            return 0;
        }
        m10888d(m11100a, length);
        int i2 = m11100a + length;
        m10860G();
        m10874a(true);
        m10901h(i2);
        setEdited(true);
        return i2;
    }

    /* renamed from: b */
    public C1397s m19754b(String str, String str2, int i, boolean z, boolean z2, boolean z3) {
        if (str.isEmpty()) {
            return new C1397s(0, new Integer(0));
        }
        return new C1393o(getLexTask().m11093e()).m11106b(m10890e(), str, str2, i, z, z2, z3);
    }

    /* renamed from: O */
    public void m19745O() {
        int m11062o = m10890e().m11062o();
        if (m11062o >= 0) {
            setEdited(true);
            m10860G();
            m10895f(false);
            m10901h(m11062o);
        }
    }

    /* renamed from: P */
    public void m19746P() {
        int m11063p = m10890e().m11063p();
        if (m11063p >= 0) {
            setEdited(true);
            m10860G();
            m10895f(false);
            m10901h(m11063p);
        }
    }

    /* renamed from: b */
    public void m19755b(String str) {
        AbstractRunnableC1391m lexTask = getLexTask();
        if (lexTask instanceof C2893m) {
            Matcher matcher = Pattern.compile("^<!--\\s?([\\s\\S]+)\\s?-->$").matcher(str);
            if (matcher.find()) {
                m10873a(matcher.group(1));
                return;
            } else {
                m10873a(new StringBuffer().append(new StringBuffer().append("<!-- ").append(str).toString()).append(" -->").toString());
                return;
            }
        }
        if (lexTask instanceof C2883c) {
            Matcher matcher2 = Pattern.compile("^/\\*\\s?([\\s\\S]+)\\s?\\*/$").matcher(str);
            if (matcher2.find()) {
                m10873a(matcher2.group(1));
                return;
            } else {
                m10873a(new StringBuffer().append(new StringBuffer().append("/* ").append(str).toString()).append(" */").toString());
                return;
            }
        }
        if (lexTask instanceof C2892l) {
            Matcher matcher3 = Pattern.compile("^(\\s+)#\\s?([\\s\\S]+)$").matcher(str);
            if (matcher3.find()) {
                m10873a(new StringBuffer().append(matcher3.group(1)).append(matcher3.group(2).replaceAll("\n#\\s?", "\n")).toString());
                return;
            }
            if (str.startsWith("# ")) {
                m10873a(str.substring(2).replaceAll("\n#\\s?", "\n"));
                return;
            } else if (str.startsWith("#")) {
                m10873a(str.substring(1).replaceAll("\n#\\s?", "\n"));
                return;
            } else {
                m10873a(new StringBuffer().append("# ").append(str.replaceAll("\n", "\n# ")).toString());
                return;
            }
        }
        Matcher matcher4 = Pattern.compile("^(\\s+)//\\s?([\\s\\S]+)$").matcher(str);
        if (matcher4.find()) {
            m10873a(new StringBuffer().append(matcher4.group(1)).append(matcher4.group(2).replaceAll("\n//\\s?", "\n")).toString());
            return;
        }
        if (str.startsWith("// ")) {
            m10873a(str.substring(3).replaceAll("\n//\\s?", "\n"));
        } else if (str.startsWith("//")) {
            m10873a(str.substring(2).replaceAll("\n//\\s?", "\n"));
        } else {
            m10873a(new StringBuffer().append("// ").append(str.replaceAll("\n", "\n// ")).toString());
        }
    }

    /* renamed from: a */
    public int m19750a(String str, boolean z, int i) {
        String str2;
        String[] split = str.split("\n");
        String[] strArr = new String[split.length];
        for (int i2 = 0; i2 < split.length; i2++) {
            String str3 = split[i2];
            if (z) {
                str2 = new StringBuffer().append(C3112bn.m19016b(i)).append(str3).toString();
            } else {
                if (str3.length() > 0) {
                    char charAt = str3.charAt(0);
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        if (charAt != ' ' && charAt != '\t') {
                            break;
                        }
                        if (charAt == '\t') {
                            i4 += 4;
                        } else {
                            i4++;
                        }
                        i3++;
                        if (i3 >= str3.length()) {
                            break;
                        }
                        charAt = str3.charAt(i3);
                    }
                    str3 = str3.replaceFirst("^\\s*", "");
                    for (int i5 = i4 >= i ? i4 - i : 0; i5 > 0; i5--) {
                        str3 = new StringBuffer().append(" ").append(str3).toString();
                    }
                }
                str2 = str3;
            }
            strArr[i2] = str2;
        }
        String m18540a = C3080al.m18540a(strArr, "\n");
        m10873a(m18540a);
        return m18540a.length();
    }

    @Override // com.p159h.p160a.p161a.C1371c
    public void setEdited(boolean z) {
        super.setEdited(z);
        if (this.f20788u != null) {
            this.f20788u.mo17649aw();
        }
    }

    public void setOnEditStateChangedListener(InterfaceC3272a interfaceC3272a) {
        this.f20788u = interfaceC3272a;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x003a -> B:8:0x0018). Please report as a decompilation issue!!! */
    @Override // com.p159h.p160a.p161a.C1371c, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent;
        requestFocus();
        try {
            this.f20789v.onTouchEvent(motionEvent);
        } catch (Exception e2) {
        }
        if (this.f20792y != null) {
            if (this.f20792y.m19846a(motionEvent)) {
                onTouchEvent = super.onTouchEvent(motionEvent);
            } else if (this.f20792y.m19848b(motionEvent)) {
                onTouchEvent = super.onTouchEvent(motionEvent);
            }
            return onTouchEvent;
        }
        if (this.f20793z && motionEvent.getAction() == 1) {
            this.f20793z = false;
            onTouchEvent = super.onTouchEvent(motionEvent);
            return onTouchEvent;
        }
        onTouchEvent = super.onTouchEvent(motionEvent);
        return onTouchEvent;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e2) {
            return false;
        }
    }

    @Override // com.p159h.p160a.p161a.C1371c
    public void setZoom(float f2) {
        super.setZoom(f2);
    }

    /* renamed from: ru.maximoff.apktool.view.Editor$b */
    private class C3273b extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        /* renamed from: a */
        private final Editor f20796a;

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (!C3102bd.f18286V) {
                return false;
            }
            this.f20796a.f20790w *= scaleGestureDetector.getScaleFactor();
            this.f20796a.f20790w = Math.max(0.5f, Math.min(this.f20796a.f20790w, 5.0f));
            this.f20796a.setZoom(this.f20796a.f20790w);
            return true;
        }

        public C3273b(Editor editor) {
            this.f20796a = editor;
        }
    }
}
