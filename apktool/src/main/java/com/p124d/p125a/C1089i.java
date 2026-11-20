package com.p124d.p125a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.hardware.HardwareBuffer;
import android.media.session.PlaybackState;
import android.os.Build;
import android.util.Base64;
import android.util.Log;
import com.p124d.p125a.C1082b;
import com.p124d.p125a.C1086f;
import com.p124d.p125a.C1088h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;

/* compiled from: SVGAndroidRenderer.java */
/* renamed from: com.d.a.i */
/* loaded from: classes.dex */
class C1089i {

    /* renamed from: h */
    private static HashSet<String> f7242h = null;

    /* renamed from: a */
    private Canvas f7243a;

    /* renamed from: b */
    private float f7244b;

    /* renamed from: c */
    private C1088h f7245c;

    /* renamed from: d */
    private g f7246d;

    /* renamed from: e */
    private Stack<g> f7247e;

    /* renamed from: f */
    private Stack<C1088h.ai> f7248f;

    /* renamed from: g */
    private Stack<Matrix> f7249g;

    /* renamed from: i */
    private C1082b.p f7250i = null;

    /* compiled from: SVGAndroidRenderer.java */
    /* renamed from: com.d.a.i$g */
    private class g {

        /* renamed from: a */
        C1088h.ad f7282a;

        /* renamed from: b */
        boolean f7283b;

        /* renamed from: c */
        boolean f7284c;

        /* renamed from: d */
        Paint f7285d;

        /* renamed from: e */
        Paint f7286e;

        /* renamed from: f */
        C1088h.a f7287f;

        /* renamed from: g */
        C1088h.a f7288g;

        /* renamed from: h */
        boolean f7289h;

        g() {
            this.f7285d = new Paint();
            this.f7285d.setFlags(193);
            if (Build.VERSION.SDK_INT >= 14) {
                this.f7285d.setHinting(0);
            }
            this.f7285d.setStyle(Paint.Style.FILL);
            this.f7285d.setTypeface(Typeface.DEFAULT);
            this.f7286e = new Paint();
            this.f7286e.setFlags(193);
            if (Build.VERSION.SDK_INT >= 14) {
                this.f7286e.setHinting(0);
            }
            this.f7286e.setStyle(Paint.Style.STROKE);
            this.f7286e.setTypeface(Typeface.DEFAULT);
            this.f7282a = C1088h.ad.m9097a();
        }

        g(g gVar) {
            this.f7283b = gVar.f7283b;
            this.f7284c = gVar.f7284c;
            this.f7285d = new Paint(gVar.f7285d);
            this.f7286e = new Paint(gVar.f7286e);
            if (gVar.f7287f != null) {
                this.f7287f = new C1088h.a(gVar.f7287f);
            }
            if (gVar.f7288g != null) {
                this.f7288g = new C1088h.a(gVar.f7288g);
            }
            this.f7289h = gVar.f7289h;
            try {
                this.f7282a = (C1088h.ad) gVar.f7282a.clone();
            } catch (CloneNotSupportedException e2) {
                Log.m185e("SVGAndroidRenderer", "Unexpected clone error", e2);
                this.f7282a = C1088h.ad.m9097a();
            }
        }
    }

    /* renamed from: e */
    private void m9223e() {
        this.f7246d = new g();
        this.f7247e = new Stack<>();
        m9187a(this.f7246d, C1088h.ad.m9097a());
        this.f7246d.f7287f = null;
        this.f7246d.f7289h = false;
        this.f7247e.push(new g(this.f7246d));
        this.f7249g = new Stack<>();
        this.f7248f = new Stack<>();
    }

    C1089i(Canvas canvas, float f2) {
        this.f7243a = canvas;
        this.f7244b = f2;
    }

    /* renamed from: a */
    float m9240a() {
        return this.f7244b;
    }

    /* renamed from: b */
    float m9242b() {
        return this.f7246d.f7285d.getTextSize();
    }

    /* renamed from: c */
    float m9243c() {
        return this.f7246d.f7285d.getTextSize() / 2.0f;
    }

    /* renamed from: d */
    C1088h.a m9244d() {
        return this.f7246d.f7288g != null ? this.f7246d.f7288g : this.f7246d.f7287f;
    }

    /* renamed from: a */
    void m9241a(C1088h c1088h, C1087g c1087g) {
        C1088h.a aVar;
        C1086f c1086f;
        if (c1087g == null) {
            throw new NullPointerException("renderOptions shouldn't be null");
        }
        this.f7245c = c1088h;
        C1088h.ae m9076a = c1088h.m9076a();
        if (m9076a == null) {
            m9222d("Nothing to render. Document is empty.", new Object[0]);
            return;
        }
        if (c1087g.m9068c()) {
            C1088h.ak m9089e = this.f7245c.m9089e(c1087g.f7015e);
            if (m9089e == null || !(m9089e instanceof C1088h.be)) {
                Log.m190w("SVGAndroidRenderer", String.format("View element with id \"%s\" not found.", c1087g.f7015e));
                return;
            }
            C1088h.be beVar = (C1088h.be) m9089e;
            if (beVar.f7145x == null) {
                Log.m190w("SVGAndroidRenderer", String.format("View element with id \"%s\" is missing a viewBox attribute.", c1087g.f7015e));
                return;
            } else {
                C1088h.a aVar2 = beVar.f7145x;
                c1086f = beVar.f7139w;
                aVar = aVar2;
            }
        } else {
            aVar = c1087g.m9069d() ? c1087g.f7014d : m9076a.f7145x;
            c1086f = c1087g.m9067b() ? c1087g.f7012b : m9076a.f7139w;
        }
        if (c1087g.m9066a()) {
            c1088h.m9080a(c1087g.f7011a);
        }
        if (c1087g.m9071f()) {
            this.f7250i = new C1082b.p();
            this.f7250i.f6968a = c1088h.m9089e(c1087g.f7013c);
        }
        m9223e();
        m9210b((C1088h.am) m9076a);
        m9225f();
        C1088h.a aVar3 = new C1088h.a(c1087g.f7016f);
        if (m9076a.f7113c != null) {
            aVar3.f7028c = m9076a.f7113c.m9118a(this, aVar3.f7028c);
        }
        if (m9076a.f7114d != null) {
            aVar3.f7029d = m9076a.f7114d.m9118a(this, aVar3.f7029d);
        }
        m9151a(m9076a, aVar3, aVar, c1086f);
        m9227g();
        if (c1087g.m9066a()) {
            c1088h.m9087d();
        }
    }

    /* renamed from: a */
    private void m9159a(C1088h.am amVar) {
        if (!(amVar instanceof C1088h.s)) {
            m9225f();
            m9210b(amVar);
            if (amVar instanceof C1088h.ae) {
                m9149a((C1088h.ae) amVar);
            } else if (amVar instanceof C1088h.bd) {
                m9170a((C1088h.bd) amVar);
            } else if (amVar instanceof C1088h.ar) {
                m9163a((C1088h.ar) amVar);
            } else if (amVar instanceof C1088h.l) {
                m9177a((C1088h.l) amVar);
            } else if (amVar instanceof C1088h.n) {
                m9178a((C1088h.n) amVar);
            } else if (amVar instanceof C1088h.u) {
                m9182a((C1088h.u) amVar);
            } else if (amVar instanceof C1088h.aa) {
                m9148a((C1088h.aa) amVar);
            } else if (amVar instanceof C1088h.c) {
                m9172a((C1088h.c) amVar);
            } else if (amVar instanceof C1088h.h) {
                m9173a((C1088h.h) amVar);
            } else if (amVar instanceof C1088h.p) {
                m9179a((C1088h.p) amVar);
            } else if (amVar instanceof C1088h.z) {
                m9186a((C1088h.z) amVar);
            } else if (amVar instanceof C1088h.y) {
                m9185a((C1088h.y) amVar);
            } else if (amVar instanceof C1088h.av) {
                m9165a((C1088h.av) amVar);
            }
            m9227g();
        }
    }

    /* renamed from: a */
    private void m9153a(C1088h.ai aiVar, boolean z) {
        if (z) {
            m9152a(aiVar);
        }
        Iterator<C1088h.am> it = aiVar.mo9096b().iterator();
        while (it.hasNext()) {
            m9159a(it.next());
        }
        if (z) {
            m9228h();
        }
    }

    /* renamed from: f */
    private void m9225f() {
        this.f7243a.save();
        this.f7247e.push(this.f7246d);
        this.f7246d = new g(this.f7246d);
    }

    /* renamed from: g */
    private void m9227g() {
        this.f7243a.restore();
        this.f7246d = this.f7247e.pop();
    }

    /* renamed from: a */
    private void m9152a(C1088h.ai aiVar) {
        this.f7248f.push(aiVar);
        this.f7249g.push(this.f7243a.getMatrix());
    }

    /* renamed from: h */
    private void m9228h() {
        this.f7248f.pop();
        this.f7249g.pop();
    }

    /* renamed from: a */
    private void m9188a(g gVar, C1088h.ak akVar) {
        gVar.f7282a.m9098a(akVar.f7138v == null);
        if (akVar.f7130r != null) {
            m9187a(gVar, akVar.f7130r);
        }
        if (this.f7245c.m9086c()) {
            for (C1082b.o oVar : this.f7245c.m9083b()) {
                if (C1082b.m9011a(this.f7250i, oVar.f6965a, akVar)) {
                    m9187a(gVar, oVar.f6966b);
                }
            }
        }
        if (akVar.f7131s != null) {
            m9187a(gVar, akVar.f7131s);
        }
    }

    /* renamed from: b */
    private void m9210b(C1088h.am amVar) {
        if (amVar instanceof C1088h.ak) {
            C1088h.ak akVar = (C1088h.ak) amVar;
            if (akVar.f7129q != null) {
                this.f7246d.f7289h = akVar.f7129q.booleanValue();
            }
        }
    }

    /* renamed from: a */
    private void m9155a(C1088h.aj ajVar, Path path) {
        if (this.f7246d.f7282a.f7051b instanceof C1088h.t) {
            C1088h.am m9082b = this.f7245c.m9082b(((C1088h.t) this.f7246d.f7282a.f7051b).f7225a);
            if (m9082b instanceof C1088h.x) {
                m9156a(ajVar, path, (C1088h.x) m9082b);
                return;
            }
        }
        this.f7243a.drawPath(path, this.f7246d.f7285d);
    }

    /* renamed from: a */
    private void m9147a(Path path) {
        if (this.f7246d.f7282a.f7048L == C1088h.ad.i.NonScalingStroke) {
            Matrix matrix = this.f7243a.getMatrix();
            Path path2 = new Path();
            path.transform(matrix, path2);
            this.f7243a.setMatrix(new Matrix());
            Shader shader = this.f7246d.f7286e.getShader();
            Matrix matrix2 = new Matrix();
            if (shader != null) {
                shader.getLocalMatrix(matrix2);
                Matrix matrix3 = new Matrix(matrix2);
                matrix3.postConcat(matrix);
                shader.setLocalMatrix(matrix3);
            }
            this.f7243a.drawPath(path2, this.f7246d.f7286e);
            this.f7243a.setMatrix(matrix);
            if (shader != null) {
                shader.setLocalMatrix(matrix2);
                return;
            }
            return;
        }
        this.f7243a.drawPath(path, this.f7246d.f7286e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m9222d(String str, Object... objArr) {
        Log.m190w("SVGAndroidRenderer", String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static void m9224e(String str, Object... objArr) {
        Log.m184e("SVGAndroidRenderer", String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static void m9226f(String str, Object... objArr) {
    }

    /* renamed from: a */
    private void m9149a(C1088h.ae aeVar) {
        m9151a(aeVar, m9141a(aeVar.f7111a, aeVar.f7112b, aeVar.f7113c, aeVar.f7114d), aeVar.f7145x, aeVar.f7139w);
    }

    /* renamed from: a */
    private void m9150a(C1088h.ae aeVar, C1088h.a aVar) {
        m9151a(aeVar, aVar, aeVar.f7145x, aeVar.f7139w);
    }

    /* renamed from: a */
    private void m9151a(C1088h.ae aeVar, C1088h.a aVar, C1088h.a aVar2, C1086f c1086f) {
        C1086f c1086f2;
        m9226f("Svg render", new Object[0]);
        if (aVar.f7028c != 0.0f && aVar.f7029d != 0.0f) {
            if (c1086f == null) {
                c1086f2 = aeVar.f7139w != null ? aeVar.f7139w : C1086f.f6988c;
            } else {
                c1086f2 = c1086f;
            }
            m9188a(this.f7246d, aeVar);
            if (m9233m()) {
                this.f7246d.f7287f = aVar;
                if (!this.f7246d.f7282a.f7071v.booleanValue()) {
                    m9145a(this.f7246d.f7287f.f7026a, this.f7246d.f7287f.f7027b, this.f7246d.f7287f.f7028c, this.f7246d.f7287f.f7029d);
                }
                m9209b(aeVar, this.f7246d.f7287f);
                if (aVar2 != null) {
                    this.f7243a.concat(m9138a(this.f7246d.f7287f, aVar2, c1086f2));
                    this.f7246d.f7288g = aeVar.f7145x;
                } else {
                    this.f7243a.translate(this.f7246d.f7287f.f7026a, this.f7246d.f7287f.f7027b);
                }
                boolean m9229i = m9229i();
                m9236p();
                m9153a((C1088h.ai) aeVar, true);
                if (m9229i) {
                    m9208b((C1088h.aj) aeVar);
                }
                m9154a((C1088h.aj) aeVar);
            }
        }
    }

    /* renamed from: a */
    private C1088h.a m9141a(C1088h.o oVar, C1088h.o oVar2, C1088h.o oVar3, C1088h.o oVar4) {
        float m9117a = oVar != null ? oVar.m9117a(this) : 0.0f;
        float m9119b = oVar2 != null ? oVar2.m9119b(this) : 0.0f;
        C1088h.a m9244d = m9244d();
        return new C1088h.a(m9117a, m9119b, oVar3 != null ? oVar3.m9117a(this) : m9244d.f7028c, oVar4 != null ? oVar4.m9119b(this) : m9244d.f7029d);
    }

    /* renamed from: a */
    private void m9177a(C1088h.l lVar) {
        m9226f("Group render", new Object[0]);
        m9188a(this.f7246d, lVar);
        if (m9233m()) {
            if (lVar.f7200b != null) {
                this.f7243a.concat(lVar.f7200b);
            }
            m9220d(lVar);
            boolean m9229i = m9229i();
            m9153a((C1088h.ai) lVar, true);
            if (m9229i) {
                m9208b((C1088h.aj) lVar);
            }
            m9154a((C1088h.aj) lVar);
        }
    }

    /* renamed from: a */
    private void m9154a(C1088h.aj ajVar) {
        if (ajVar.f7138v != null && ajVar.f7127o != null) {
            Matrix matrix = new Matrix();
            if (this.f7249g.peek().invert(matrix)) {
                float[] fArr = {ajVar.f7127o.f7026a, ajVar.f7127o.f7027b, ajVar.f7127o.m9091a(), ajVar.f7127o.f7027b, ajVar.f7127o.m9091a(), ajVar.f7127o.m9093b(), ajVar.f7127o.f7026a, ajVar.f7127o.m9093b()};
                matrix.preConcat(this.f7243a.getMatrix());
                matrix.mapPoints(fArr);
                RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
                for (int i2 = 2; i2 <= 6; i2 += 2) {
                    if (fArr[i2] < rectF.left) {
                        rectF.left = fArr[i2];
                    }
                    if (fArr[i2] > rectF.right) {
                        rectF.right = fArr[i2];
                    }
                    if (fArr[i2 + 1] < rectF.top) {
                        rectF.top = fArr[i2 + 1];
                    }
                    if (fArr[i2 + 1] > rectF.bottom) {
                        rectF.bottom = fArr[i2 + 1];
                    }
                }
                C1088h.aj ajVar2 = (C1088h.aj) this.f7248f.peek();
                if (ajVar2.f7127o == null) {
                    ajVar2.f7127o = C1088h.a.m9090a(rectF.left, rectF.top, rectF.right, rectF.bottom);
                } else {
                    ajVar2.f7127o.m9092a(C1088h.a.m9090a(rectF.left, rectF.top, rectF.right, rectF.bottom));
                }
            }
        }
    }

    /* renamed from: i */
    private boolean m9229i() {
        C1088h.am m9082b;
        if (!m9230j()) {
            return false;
        }
        this.f7243a.saveLayerAlpha(null, m9135a(this.f7246d.f7282a.f7062m.floatValue()), 31);
        this.f7247e.push(this.f7246d);
        this.f7246d = new g(this.f7246d);
        if (this.f7246d.f7282a.f7043G == null || ((m9082b = this.f7245c.m9082b(this.f7246d.f7282a.f7043G)) != null && (m9082b instanceof C1088h.r))) {
            return true;
        }
        m9224e("Mask reference '%s' not found", this.f7246d.f7282a.f7043G);
        this.f7246d.f7282a.f7043G = null;
        return true;
    }

    /* renamed from: b */
    private void m9208b(C1088h.aj ajVar) {
        m9157a(ajVar, ajVar.f7127o);
    }

    /* renamed from: a */
    private void m9157a(C1088h.aj ajVar, C1088h.a aVar) {
        if (this.f7246d.f7282a.f7043G != null) {
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.f7243a.saveLayer(null, paint, 31);
            Paint paint2 = new Paint();
            paint2.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2127f, 0.7151f, 0.0722f, 0.0f, 0.0f})));
            this.f7243a.saveLayer(null, paint2, 31);
            C1088h.am m9082b = this.f7245c.m9082b(this.f7246d.f7282a.f7043G);
            m9181a((C1088h.r) m9082b, ajVar, aVar);
            this.f7243a.restore();
            Paint paint3 = new Paint();
            paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.f7243a.saveLayer(null, paint3, 31);
            m9181a((C1088h.r) m9082b, ajVar, aVar);
            this.f7243a.restore();
            this.f7243a.restore();
        }
        m9227g();
    }

    /* renamed from: j */
    private boolean m9230j() {
        return this.f7246d.f7282a.f7062m.floatValue() < 1.0f || this.f7246d.f7282a.f7043G != null;
    }

    /* renamed from: a */
    private void m9163a(C1088h.ar arVar) {
        m9226f("Switch render", new Object[0]);
        m9188a(this.f7246d, arVar);
        if (m9233m()) {
            if (arVar.f7200b != null) {
                this.f7243a.concat(arVar.f7200b);
            }
            m9220d(arVar);
            boolean m9229i = m9229i();
            m9211b(arVar);
            if (m9229i) {
                m9208b((C1088h.aj) arVar);
            }
            m9154a((C1088h.aj) arVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    private void m9211b(C1088h.ar arVar) {
        Set<String> mo9106e;
        String language = Locale.getDefault().getLanguage();
        C1090j m9074e = C1088h.m9074e();
        for (C1088h.am amVar : arVar.mo9096b()) {
            if (amVar instanceof C1088h.af) {
                C1088h.af afVar = (C1088h.af) amVar;
                if (afVar.mo9104d() == null && ((mo9106e = afVar.mo9106e()) == null || (!mo9106e.isEmpty() && mo9106e.contains(language)))) {
                    Set<String> mo9102c = afVar.mo9102c();
                    if (mo9102c != null) {
                        if (f7242h == null) {
                            m9231k();
                        }
                        if (!mo9102c.isEmpty() && f7242h.containsAll(mo9102c)) {
                        }
                    }
                    Set<String> mo9107f = afVar.mo9107f();
                    if (mo9107f != null) {
                        if (!mo9107f.isEmpty() && m9074e != null) {
                            Iterator<String> it = mo9107f.iterator();
                            while (it.hasNext()) {
                                if (!m9074e.m9254c(it.next())) {
                                    break;
                                }
                            }
                        }
                    }
                    Set<String> mo9108g = afVar.mo9108g();
                    if (mo9108g != null) {
                        if (!mo9108g.isEmpty() && m9074e != null) {
                            Iterator<String> it2 = mo9108g.iterator();
                            while (it2.hasNext()) {
                                if (m9074e.m9252a(it2.next(), this.f7246d.f7282a.f7066q.intValue(), String.valueOf(this.f7246d.f7282a.f7067r)) == null) {
                                    break;
                                }
                            }
                        }
                    }
                    m9159a(amVar);
                    return;
                }
            }
        }
    }

    /* renamed from: k */
    private static synchronized void m9231k() {
        synchronized (C1089i.class) {
            f7242h = new HashSet<>();
            f7242h.add("Structure");
            f7242h.add("BasicStructure");
            f7242h.add("ConditionalProcessing");
            f7242h.add("Image");
            f7242h.add("Style");
            f7242h.add("ViewportAttribute");
            f7242h.add("Shape");
            f7242h.add("BasicText");
            f7242h.add("PaintAttribute");
            f7242h.add("BasicPaintAttribute");
            f7242h.add("OpacityAttribute");
            f7242h.add("BasicGraphicsAttribute");
            f7242h.add("Marker");
            f7242h.add("Gradient");
            f7242h.add("Pattern");
            f7242h.add("Clip");
            f7242h.add("BasicClip");
            f7242h.add("Mask");
            f7242h.add("View");
        }
    }

    /* renamed from: a */
    private void m9170a(C1088h.bd bdVar) {
        m9226f("Use render", new Object[0]);
        if (bdVar.f7176e == null || !bdVar.f7176e.m9120b()) {
            if (bdVar.f7177f == null || !bdVar.f7177f.m9120b()) {
                m9188a(this.f7246d, bdVar);
                if (m9233m()) {
                    C1088h.am m9082b = bdVar.f7137u.m9082b(bdVar.f7173a);
                    if (m9082b == null) {
                        m9224e("Use reference '%s' not found", bdVar.f7173a);
                        return;
                    }
                    if (bdVar.f7200b != null) {
                        this.f7243a.concat(bdVar.f7200b);
                    }
                    this.f7243a.translate(bdVar.f7174c != null ? bdVar.f7174c.m9117a(this) : 0.0f, bdVar.f7175d != null ? bdVar.f7175d.m9119b(this) : 0.0f);
                    m9220d(bdVar);
                    boolean m9229i = m9229i();
                    m9152a((C1088h.ai) bdVar);
                    if (m9082b instanceof C1088h.ae) {
                        C1088h.a m9141a = m9141a((C1088h.o) null, (C1088h.o) null, bdVar.f7176e, bdVar.f7177f);
                        m9225f();
                        m9150a((C1088h.ae) m9082b, m9141a);
                        m9227g();
                    } else if (m9082b instanceof C1088h.as) {
                        C1088h.a m9141a2 = m9141a((C1088h.o) null, (C1088h.o) null, bdVar.f7176e != null ? bdVar.f7176e : new C1088h.o(100.0f, C1088h.bc.percent), bdVar.f7177f != null ? bdVar.f7177f : new C1088h.o(100.0f, C1088h.bc.percent));
                        m9225f();
                        m9164a((C1088h.as) m9082b, m9141a2);
                        m9227g();
                    } else {
                        m9159a(m9082b);
                    }
                    m9228h();
                    if (m9229i) {
                        m9208b((C1088h.aj) bdVar);
                    }
                    m9154a((C1088h.aj) bdVar);
                }
            }
        }
    }

    /* renamed from: a */
    private void m9182a(C1088h.u uVar) {
        m9226f("Path render", new Object[0]);
        if (uVar.f7227a != null) {
            m9188a(this.f7246d, uVar);
            if (m9233m() && m9234n()) {
                if (this.f7246d.f7284c || this.f7246d.f7283b) {
                    if (uVar.f7199e != null) {
                        this.f7243a.concat(uVar.f7199e);
                    }
                    Path m9248a = new c(uVar.f7227a).m9248a();
                    if (uVar.f7127o == null) {
                        uVar.f7127o = m9203b(m9248a);
                    }
                    m9154a((C1088h.aj) uVar);
                    m9218c((C1088h.aj) uVar);
                    m9220d(uVar);
                    boolean m9229i = m9229i();
                    if (this.f7246d.f7283b) {
                        m9248a.setFillType(m9235o());
                        m9155a(uVar, m9248a);
                    }
                    if (this.f7246d.f7284c) {
                        m9147a(m9248a);
                    }
                    m9175a((C1088h.k) uVar);
                    if (m9229i) {
                        m9208b((C1088h.aj) uVar);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private C1088h.a m9203b(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return new C1088h.a(rectF.left, rectF.top, rectF.width(), rectF.height());
    }

    /* renamed from: a */
    private void m9148a(C1088h.aa aaVar) {
        m9226f("Rect render", new Object[0]);
        if (aaVar.f7032c != null && aaVar.f7033d != null && !aaVar.f7032c.m9120b() && !aaVar.f7033d.m9120b()) {
            m9188a(this.f7246d, aaVar);
            if (m9233m() && m9234n()) {
                if (aaVar.f7199e != null) {
                    this.f7243a.concat(aaVar.f7199e);
                }
                Path m9199b = m9199b(aaVar);
                m9154a((C1088h.aj) aaVar);
                m9218c((C1088h.aj) aaVar);
                m9220d(aaVar);
                boolean m9229i = m9229i();
                if (this.f7246d.f7283b) {
                    m9155a(aaVar, m9199b);
                }
                if (this.f7246d.f7284c) {
                    m9147a(m9199b);
                }
                if (m9229i) {
                    m9208b((C1088h.aj) aaVar);
                }
            }
        }
    }

    /* renamed from: a */
    private void m9172a(C1088h.c cVar) {
        m9226f("Circle render", new Object[0]);
        if (cVar.f7180c != null && !cVar.f7180c.m9120b()) {
            m9188a(this.f7246d, cVar);
            if (m9233m() && m9234n()) {
                if (cVar.f7199e != null) {
                    this.f7243a.concat(cVar.f7199e);
                }
                Path m9201b = m9201b(cVar);
                m9154a((C1088h.aj) cVar);
                m9218c((C1088h.aj) cVar);
                m9220d(cVar);
                boolean m9229i = m9229i();
                if (this.f7246d.f7283b) {
                    m9155a(cVar, m9201b);
                }
                if (this.f7246d.f7284c) {
                    m9147a(m9201b);
                }
                if (m9229i) {
                    m9208b((C1088h.aj) cVar);
                }
            }
        }
    }

    /* renamed from: a */
    private void m9173a(C1088h.h hVar) {
        m9226f("Ellipse render", new Object[0]);
        if (hVar.f7188c != null && hVar.f7189d != null && !hVar.f7188c.m9120b() && !hVar.f7189d.m9120b()) {
            m9188a(this.f7246d, hVar);
            if (m9233m() && m9234n()) {
                if (hVar.f7199e != null) {
                    this.f7243a.concat(hVar.f7199e);
                }
                Path m9202b = m9202b(hVar);
                m9154a((C1088h.aj) hVar);
                m9218c((C1088h.aj) hVar);
                m9220d(hVar);
                boolean m9229i = m9229i();
                if (this.f7246d.f7283b) {
                    m9155a(hVar, m9202b);
                }
                if (this.f7246d.f7284c) {
                    m9147a(m9202b);
                }
                if (m9229i) {
                    m9208b((C1088h.aj) hVar);
                }
            }
        }
    }

    /* renamed from: a */
    private void m9179a(C1088h.p pVar) {
        m9226f("Line render", new Object[0]);
        m9188a(this.f7246d, pVar);
        if (m9233m() && m9234n() && this.f7246d.f7284c) {
            if (pVar.f7199e != null) {
                this.f7243a.concat(pVar.f7199e);
            }
            Path m9215c = m9215c(pVar);
            m9154a((C1088h.aj) pVar);
            m9218c((C1088h.aj) pVar);
            m9220d(pVar);
            boolean m9229i = m9229i();
            m9147a(m9215c);
            m9175a((C1088h.k) pVar);
            if (m9229i) {
                m9208b((C1088h.aj) pVar);
            }
        }
    }

    /* renamed from: b */
    private List<b> m9205b(C1088h.p pVar) {
        float m9117a = pVar.f7209a != null ? pVar.f7209a.m9117a(this) : 0.0f;
        float m9119b = pVar.f7210b != null ? pVar.f7210b.m9119b(this) : 0.0f;
        float m9117a2 = pVar.f7211c != null ? pVar.f7211c.m9117a(this) : 0.0f;
        float m9119b2 = pVar.f7212d != null ? pVar.f7212d.m9119b(this) : 0.0f;
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new b(m9117a, m9119b, m9117a2 - m9117a, m9119b2 - m9119b));
        arrayList.add(new b(m9117a2, m9119b2, m9117a2 - m9117a, m9119b2 - m9119b));
        return arrayList;
    }

    /* renamed from: a */
    private void m9185a(C1088h.y yVar) {
        m9226f("PolyLine render", new Object[0]);
        m9188a(this.f7246d, yVar);
        if (m9233m() && m9234n()) {
            if (this.f7246d.f7284c || this.f7246d.f7283b) {
                if (yVar.f7199e != null) {
                    this.f7243a.concat(yVar.f7199e);
                }
                if (yVar.f7241a.length >= 2) {
                    Path m9216c = m9216c(yVar);
                    m9154a((C1088h.aj) yVar);
                    m9216c.setFillType(m9235o());
                    m9218c((C1088h.aj) yVar);
                    m9220d(yVar);
                    boolean m9229i = m9229i();
                    if (this.f7246d.f7283b) {
                        m9155a(yVar, m9216c);
                    }
                    if (this.f7246d.f7284c) {
                        m9147a(m9216c);
                    }
                    m9175a((C1088h.k) yVar);
                    if (m9229i) {
                        m9208b((C1088h.aj) yVar);
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    private List<b> m9206b(C1088h.y yVar) {
        int i2 = 2;
        int length = yVar.f7241a.length;
        if (length < 2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        float f2 = 0.0f;
        float f3 = 0.0f;
        b bVar = new b(yVar.f7241a[0], yVar.f7241a[1], 0.0f, 0.0f);
        while (i2 < length) {
            f3 = yVar.f7241a[i2];
            f2 = yVar.f7241a[i2 + 1];
            bVar.m9246a(f3, f2);
            arrayList.add(bVar);
            i2 += 2;
            bVar = new b(f3, f2, f3 - bVar.f7263a, f2 - bVar.f7264b);
        }
        if (!(yVar instanceof C1088h.z)) {
            arrayList.add(bVar);
        } else if (f3 != yVar.f7241a[0] && f2 != yVar.f7241a[1]) {
            float f4 = yVar.f7241a[0];
            float f5 = yVar.f7241a[1];
            bVar.m9246a(f4, f5);
            arrayList.add(bVar);
            b bVar2 = new b(f4, f5, f4 - bVar.f7263a, f5 - bVar.f7264b);
            bVar2.m9247a((b) arrayList.get(0));
            arrayList.add(bVar2);
            arrayList.set(0, bVar2);
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m9186a(C1088h.z zVar) {
        m9226f("Polygon render", new Object[0]);
        m9188a(this.f7246d, zVar);
        if (m9233m() && m9234n()) {
            if (this.f7246d.f7284c || this.f7246d.f7283b) {
                if (zVar.f7199e != null) {
                    this.f7243a.concat(zVar.f7199e);
                }
                if (zVar.f7241a.length >= 2) {
                    Path m9216c = m9216c((C1088h.y) zVar);
                    m9154a((C1088h.aj) zVar);
                    m9218c((C1088h.aj) zVar);
                    m9220d(zVar);
                    boolean m9229i = m9229i();
                    if (this.f7246d.f7283b) {
                        m9155a(zVar, m9216c);
                    }
                    if (this.f7246d.f7284c) {
                        m9147a(m9216c);
                    }
                    m9175a((C1088h.k) zVar);
                    if (m9229i) {
                        m9208b((C1088h.aj) zVar);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m9165a(C1088h.av avVar) {
        float f2 = 0.0f;
        m9226f("Text render", new Object[0]);
        m9188a(this.f7246d, avVar);
        if (m9233m()) {
            if (avVar.f7149a != null) {
                this.f7243a.concat(avVar.f7149a);
            }
            float m9117a = (avVar.f7153b == null || avVar.f7153b.size() == 0) ? 0.0f : avVar.f7153b.get(0).m9117a(this);
            float m9119b = (avVar.f7154c == null || avVar.f7154c.size() == 0) ? 0.0f : avVar.f7154c.get(0).m9119b(this);
            float m9117a2 = (avVar.f7155d == null || avVar.f7155d.size() == 0) ? 0.0f : avVar.f7155d.get(0).m9117a(this);
            if (avVar.f7156e != null && avVar.f7156e.size() != 0) {
                f2 = avVar.f7156e.get(0).m9119b(this);
            }
            C1088h.ad.f m9232l = m9232l();
            if (m9232l != C1088h.ad.f.Start) {
                float m9134a = m9134a((C1088h.ax) avVar);
                if (m9232l == C1088h.ad.f.Middle) {
                    m9117a -= m9134a / 2.0f;
                } else {
                    m9117a -= m9134a;
                }
            }
            if (avVar.f7127o == null) {
                h hVar = new h(m9117a, m9119b);
                m9167a((C1088h.ax) avVar, (i) hVar);
                avVar.f7127o = new C1088h.a(hVar.f7293c.left, hVar.f7293c.top, hVar.f7293c.width(), hVar.f7293c.height());
            }
            m9154a((C1088h.aj) avVar);
            m9218c((C1088h.aj) avVar);
            m9220d(avVar);
            boolean m9229i = m9229i();
            m9167a((C1088h.ax) avVar, new e(m9117a + m9117a2, f2 + m9119b));
            if (m9229i) {
                m9208b((C1088h.aj) avVar);
            }
        }
    }

    /* renamed from: l */
    private C1088h.ad.f m9232l() {
        if (this.f7246d.f7282a.f7069t == C1088h.ad.h.LTR || this.f7246d.f7282a.f7070u == C1088h.ad.f.Middle) {
            return this.f7246d.f7282a.f7070u;
        }
        return this.f7246d.f7282a.f7070u == C1088h.ad.f.Start ? C1088h.ad.f.End : C1088h.ad.f.Start;
    }

    /* compiled from: SVGAndroidRenderer.java */
    /* renamed from: com.d.a.i$e */
    private class e extends i {

        /* renamed from: b */
        float f7275b;

        /* renamed from: c */
        float f7276c;

        e(float f2, float f3) {
            super();
            this.f7275b = f2;
            this.f7276c = f3;
        }

        @Override // com.p124d.p125a.C1089i.i
        /* renamed from: a */
        public void mo9249a(String str) {
            C1089i.m9226f("TextSequence render", new Object[0]);
            if (C1089i.this.m9234n()) {
                if (C1089i.this.f7246d.f7283b) {
                    C1089i.this.f7243a.drawText(str, this.f7275b, this.f7276c, C1089i.this.f7246d.f7285d);
                }
                if (C1089i.this.f7246d.f7284c) {
                    C1089i.this.f7243a.drawText(str, this.f7275b, this.f7276c, C1089i.this.f7246d.f7286e);
                }
            }
            this.f7275b += C1089i.this.f7246d.f7285d.measureText(str);
        }
    }

    /* compiled from: SVGAndroidRenderer.java */
    /* renamed from: com.d.a.i$i */
    private abstract class i {
        /* renamed from: a */
        public abstract void mo9249a(String str);

        private i() {
        }

        /* renamed from: a */
        public boolean mo9250a(C1088h.ax axVar) {
            return true;
        }
    }

    /* renamed from: a */
    private void m9167a(C1088h.ax axVar, i iVar) {
        if (m9233m()) {
            Iterator<C1088h.am> it = axVar.f7116i.iterator();
            boolean z = true;
            while (it.hasNext()) {
                C1088h.am next = it.next();
                if (next instanceof C1088h.bb) {
                    iVar.mo9249a(m9144a(((C1088h.bb) next).f7161a, z, !it.hasNext()));
                } else {
                    m9160a(next, iVar);
                }
                z = false;
            }
        }
    }

    /* renamed from: a */
    private void m9160a(C1088h.am amVar, i iVar) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        C1088h.ad.f m9232l;
        float f7 = 0.0f;
        if (iVar.mo9250a((C1088h.ax) amVar)) {
            if (amVar instanceof C1088h.ay) {
                m9225f();
                m9169a((C1088h.ay) amVar);
                m9227g();
                return;
            }
            if (amVar instanceof C1088h.au) {
                m9226f("TSpan render", new Object[0]);
                m9225f();
                C1088h.au auVar = (C1088h.au) amVar;
                m9188a(this.f7246d, auVar);
                if (m9233m()) {
                    boolean z = auVar.f7153b != null && auVar.f7153b.size() > 0;
                    if (iVar instanceof e) {
                        float m9117a = !z ? ((e) iVar).f7275b : auVar.f7153b.get(0).m9117a(this);
                        f4 = (auVar.f7154c == null || auVar.f7154c.size() == 0) ? ((e) iVar).f7276c : auVar.f7154c.get(0).m9119b(this);
                        f3 = (auVar.f7155d == null || auVar.f7155d.size() == 0) ? 0.0f : auVar.f7155d.get(0).m9117a(this);
                        if (auVar.f7156e != null && auVar.f7156e.size() != 0) {
                            f7 = auVar.f7156e.get(0).m9119b(this);
                        }
                        f2 = f7;
                        f5 = m9117a;
                    } else {
                        f2 = 0.0f;
                        f3 = 0.0f;
                        f4 = 0.0f;
                        f5 = 0.0f;
                    }
                    if (!z || (m9232l = m9232l()) == C1088h.ad.f.Start) {
                        f6 = f5;
                    } else {
                        float m9134a = m9134a((C1088h.ax) auVar);
                        if (m9232l == C1088h.ad.f.Middle) {
                            f6 = f5 - (m9134a / 2.0f);
                        } else {
                            f6 = f5 - m9134a;
                        }
                    }
                    m9218c((C1088h.aj) auVar.mo9110h());
                    if (iVar instanceof e) {
                        ((e) iVar).f7275b = f6 + f3;
                        ((e) iVar).f7276c = f4 + f2;
                    }
                    boolean m9229i = m9229i();
                    m9167a((C1088h.ax) auVar, iVar);
                    if (m9229i) {
                        m9208b((C1088h.aj) auVar);
                    }
                }
                m9227g();
                return;
            }
            if (amVar instanceof C1088h.at) {
                m9225f();
                C1088h.at atVar = (C1088h.at) amVar;
                m9188a(this.f7246d, atVar);
                if (m9233m()) {
                    m9218c((C1088h.aj) atVar.mo9110h());
                    C1088h.am m9082b = amVar.f7137u.m9082b(atVar.f7146a);
                    if (m9082b != null && (m9082b instanceof C1088h.ax)) {
                        StringBuilder sb = new StringBuilder();
                        m9168a((C1088h.ax) m9082b, sb);
                        if (sb.length() > 0) {
                            iVar.mo9249a(sb.toString());
                        }
                    } else {
                        m9224e("Tref reference '%s' not found", atVar.f7146a);
                    }
                }
                m9227g();
            }
        }
    }

    /* renamed from: a */
    private void m9169a(C1088h.ay ayVar) {
        float f2;
        m9226f("TextPath render", new Object[0]);
        m9188a(this.f7246d, ayVar);
        if (m9233m() && m9234n()) {
            C1088h.am m9082b = ayVar.f7137u.m9082b(ayVar.f7150a);
            if (m9082b == null) {
                m9224e("TextPath reference '%s' not found", ayVar.f7150a);
                return;
            }
            C1088h.u uVar = (C1088h.u) m9082b;
            Path m9248a = new c(uVar.f7227a).m9248a();
            if (uVar.f7199e != null) {
                m9248a.transform(uVar.f7199e);
            }
            float m9118a = ayVar.f7151b != null ? ayVar.f7151b.m9118a(this, new PathMeasure(m9248a, false).getLength()) : 0.0f;
            C1088h.ad.f m9232l = m9232l();
            if (m9232l != C1088h.ad.f.Start) {
                float m9134a = m9134a((C1088h.ax) ayVar);
                if (m9232l == C1088h.ad.f.Middle) {
                    f2 = m9118a - (m9134a / 2.0f);
                } else {
                    f2 = m9118a - m9134a;
                }
            } else {
                f2 = m9118a;
            }
            m9218c((C1088h.aj) ayVar.mo9110h());
            boolean m9229i = m9229i();
            m9167a((C1088h.ax) ayVar, (i) new d(m9248a, f2, 0.0f));
            if (m9229i) {
                m9208b((C1088h.aj) ayVar);
            }
        }
    }

    /* compiled from: SVGAndroidRenderer.java */
    /* renamed from: com.d.a.i$d */
    private class d extends e {

        /* renamed from: f */
        private Path f7274f;

        d(Path path, float f2, float f3) {
            super(f2, f3);
            this.f7274f = path;
        }

        @Override // com.p124d.p125a.C1089i.e, com.p124d.p125a.C1089i.i
        /* renamed from: a */
        public void mo9249a(String str) {
            if (C1089i.this.m9234n()) {
                if (C1089i.this.f7246d.f7283b) {
                    C1089i.this.f7243a.drawTextOnPath(str, this.f7274f, this.f7275b, this.f7276c, C1089i.this.f7246d.f7285d);
                }
                if (C1089i.this.f7246d.f7284c) {
                    C1089i.this.f7243a.drawTextOnPath(str, this.f7274f, this.f7275b, this.f7276c, C1089i.this.f7246d.f7286e);
                }
            }
            this.f7275b += C1089i.this.f7246d.f7285d.measureText(str);
        }
    }

    /* renamed from: a */
    private float m9134a(C1088h.ax axVar) {
        j jVar = new j();
        m9167a(axVar, (i) jVar);
        return jVar.f7296a;
    }

    /* compiled from: SVGAndroidRenderer.java */
    /* renamed from: com.d.a.i$j */
    private class j extends i {

        /* renamed from: a */
        float f7296a;

        private j() {
            super();
            this.f7296a = 0.0f;
        }

        @Override // com.p124d.p125a.C1089i.i
        /* renamed from: a */
        public void mo9249a(String str) {
            this.f7296a += C1089i.this.f7246d.f7285d.measureText(str);
        }
    }

    /* compiled from: SVGAndroidRenderer.java */
    /* renamed from: com.d.a.i$h */
    private class h extends i {

        /* renamed from: a */
        float f7291a;

        /* renamed from: b */
        float f7292b;

        /* renamed from: c */
        RectF f7293c;

        h(float f2, float f3) {
            super();
            this.f7293c = new RectF();
            this.f7291a = f2;
            this.f7292b = f3;
        }

        @Override // com.p124d.p125a.C1089i.i
        /* renamed from: a */
        public boolean mo9250a(C1088h.ax axVar) {
            if (!(axVar instanceof C1088h.ay)) {
                return true;
            }
            C1088h.ay ayVar = (C1088h.ay) axVar;
            C1088h.am m9082b = axVar.f7137u.m9082b(ayVar.f7150a);
            if (m9082b == null) {
                C1089i.m9224e("TextPath path reference '%s' not found", ayVar.f7150a);
                return false;
            }
            C1088h.u uVar = (C1088h.u) m9082b;
            Path m9248a = C1089i.this.new c(uVar.f7227a).m9248a();
            if (uVar.f7199e != null) {
                m9248a.transform(uVar.f7199e);
            }
            RectF rectF = new RectF();
            m9248a.computeBounds(rectF, true);
            this.f7293c.union(rectF);
            return false;
        }

        @Override // com.p124d.p125a.C1089i.i
        /* renamed from: a */
        public void mo9249a(String str) {
            if (C1089i.this.m9234n()) {
                Rect rect = new Rect();
                C1089i.this.f7246d.f7285d.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.f7291a, this.f7292b);
                this.f7293c.union(rectF);
            }
            this.f7291a += C1089i.this.f7246d.f7285d.measureText(str);
        }
    }

    /* renamed from: a */
    private void m9168a(C1088h.ax axVar, StringBuilder sb) {
        Iterator<C1088h.am> it = axVar.f7116i.iterator();
        boolean z = true;
        while (it.hasNext()) {
            C1088h.am next = it.next();
            if (next instanceof C1088h.ax) {
                m9168a((C1088h.ax) next, sb);
            } else if (next instanceof C1088h.bb) {
                sb.append(m9144a(((C1088h.bb) next).f7161a, z, !it.hasNext()));
            }
            z = false;
        }
    }

    /* renamed from: a */
    private String m9144a(String str, boolean z, boolean z2) {
        if (this.f7246d.f7289h) {
            return str.replaceAll("[\\n\\t]", " ");
        }
        String replaceAll = str.replaceAll("\\n", "").replaceAll("\\t", " ");
        if (z) {
            replaceAll = replaceAll.replaceAll("^\\s+", "");
        }
        if (z2) {
            replaceAll = replaceAll.replaceAll("\\s+$", "");
        }
        return replaceAll.replaceAll("\\s{2,}", " ");
    }

    /* renamed from: a */
    private void m9164a(C1088h.as asVar, C1088h.a aVar) {
        m9226f("Symbol render", new Object[0]);
        if (aVar.f7028c != 0.0f && aVar.f7029d != 0.0f) {
            C1086f c1086f = asVar.f7139w != null ? asVar.f7139w : C1086f.f6988c;
            m9188a(this.f7246d, asVar);
            this.f7246d.f7287f = aVar;
            if (!this.f7246d.f7282a.f7071v.booleanValue()) {
                m9145a(this.f7246d.f7287f.f7026a, this.f7246d.f7287f.f7027b, this.f7246d.f7287f.f7028c, this.f7246d.f7287f.f7029d);
            }
            if (asVar.f7145x != null) {
                this.f7243a.concat(m9138a(this.f7246d.f7287f, asVar.f7145x, c1086f));
                this.f7246d.f7288g = asVar.f7145x;
            } else {
                this.f7243a.translate(this.f7246d.f7287f.f7026a, this.f7246d.f7287f.f7027b);
            }
            boolean m9229i = m9229i();
            m9153a((C1088h.ai) asVar, true);
            if (m9229i) {
                m9208b((C1088h.aj) asVar);
            }
            m9154a((C1088h.aj) asVar);
        }
    }

    /* renamed from: a */
    private void m9178a(C1088h.n nVar) {
        Bitmap bitmap;
        m9226f("Image render", new Object[0]);
        if (nVar.f7204d != null && !nVar.f7204d.m9120b() && nVar.f7205e != null && !nVar.f7205e.m9120b() && nVar.f7201a != null) {
            C1086f c1086f = nVar.f7139w != null ? nVar.f7139w : C1086f.f6988c;
            Bitmap m9137a = m9137a(nVar.f7201a);
            if (m9137a == null) {
                C1090j m9074e = C1088h.m9074e();
                if (m9074e != null) {
                    bitmap = m9074e.m9251a(nVar.f7201a);
                } else {
                    return;
                }
            } else {
                bitmap = m9137a;
            }
            if (bitmap == null) {
                m9224e("Could not locate image '%s'", nVar.f7201a);
                return;
            }
            C1088h.a aVar = new C1088h.a(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
            m9188a(this.f7246d, nVar);
            if (m9233m() && m9234n()) {
                if (nVar.f7206f != null) {
                    this.f7243a.concat(nVar.f7206f);
                }
                this.f7246d.f7287f = new C1088h.a(nVar.f7202b != null ? nVar.f7202b.m9117a(this) : 0.0f, nVar.f7203c != null ? nVar.f7203c.m9119b(this) : 0.0f, nVar.f7204d.m9117a(this), nVar.f7205e.m9117a(this));
                if (!this.f7246d.f7282a.f7071v.booleanValue()) {
                    m9145a(this.f7246d.f7287f.f7026a, this.f7246d.f7287f.f7027b, this.f7246d.f7287f.f7028c, this.f7246d.f7287f.f7029d);
                }
                nVar.f7127o = this.f7246d.f7287f;
                m9154a((C1088h.aj) nVar);
                m9220d(nVar);
                boolean m9229i = m9229i();
                m9236p();
                this.f7243a.save();
                this.f7243a.concat(m9138a(this.f7246d.f7287f, aVar, c1086f));
                this.f7243a.drawBitmap(bitmap, 0.0f, 0.0f, new Paint(this.f7246d.f7282a.f7049M == C1088h.ad.e.optimizeSpeed ? 0 : 2));
                this.f7243a.restore();
                if (m9229i) {
                    m9208b((C1088h.aj) nVar);
                }
            }
        }
    }

    /* renamed from: a */
    private Bitmap m9137a(String str) {
        int indexOf;
        if (!str.startsWith("data:") || str.length() < 14 || (indexOf = str.indexOf(44)) < 12 || !";base64".equals(str.substring(indexOf - 7, indexOf))) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str.substring(indexOf + 1), 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e2) {
            Log.m185e("SVGAndroidRenderer", "Could not decode bad Data URL", e2);
            return null;
        }
    }

    /* renamed from: m */
    private boolean m9233m() {
        if (this.f7246d.f7282a.f7037A != null) {
            return this.f7246d.f7282a.f7037A.booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public boolean m9234n() {
        if (this.f7246d.f7282a.f7038B != null) {
            return this.f7246d.f7282a.f7038B.booleanValue();
        }
        return true;
    }

    /* renamed from: a */
    private Matrix m9138a(C1088h.a aVar, C1088h.a aVar2, C1086f c1086f) {
        Matrix matrix = new Matrix();
        if (c1086f == null || c1086f.m9063a() == null) {
            return matrix;
        }
        float f2 = aVar.f7028c / aVar2.f7028c;
        float f3 = aVar.f7029d / aVar2.f7029d;
        float f4 = -aVar2.f7026a;
        float f5 = -aVar2.f7027b;
        if (c1086f.equals(C1086f.f6987b)) {
            matrix.preTranslate(aVar.f7026a, aVar.f7027b);
            matrix.preScale(f2, f3);
            matrix.preTranslate(f4, f5);
            return matrix;
        }
        float max = c1086f.m9064b() == C1086f.b.slice ? Math.max(f2, f3) : Math.min(f2, f3);
        float f6 = aVar.f7028c / max;
        float f7 = aVar.f7029d / max;
        switch (c1086f.m9063a()) {
            case xMidYMin:
            case xMidYMid:
            case xMidYMax:
                f4 -= (aVar2.f7028c - f6) / 2.0f;
                break;
            case xMaxYMin:
            case xMaxYMid:
            case xMaxYMax:
                f4 -= aVar2.f7028c - f6;
                break;
        }
        switch (c1086f.m9063a()) {
            case xMidYMid:
            case xMaxYMid:
            case xMinYMid:
                f5 -= (aVar2.f7029d - f7) / 2.0f;
                break;
            case xMidYMax:
            case xMaxYMax:
            case xMinYMax:
                f5 -= aVar2.f7029d - f7;
                break;
        }
        matrix.preTranslate(aVar.f7026a, aVar.f7027b);
        matrix.preScale(max, max);
        matrix.preTranslate(f4, f5);
        return matrix;
    }

    /* renamed from: a */
    private boolean m9195a(C1088h.ad adVar, long j2) {
        return (adVar.f7050a & j2) != 0;
    }

    /* renamed from: a */
    private void m9187a(g gVar, C1088h.ad adVar) {
        Typeface typeface;
        if (m9195a(adVar, PlaybackState.ACTION_SKIP_TO_QUEUE_ITEM)) {
            gVar.f7282a.f7063n = adVar.f7063n;
        }
        if (m9195a(adVar, PlaybackState.ACTION_PLAY_FROM_SEARCH)) {
            gVar.f7282a.f7062m = adVar.f7062m;
        }
        if (m9195a(adVar, 1L)) {
            gVar.f7282a.f7051b = adVar.f7051b;
            gVar.f7283b = (adVar.f7051b == null || adVar.f7051b == C1088h.e.f7183c) ? false : true;
        }
        if (m9195a(adVar, 4L)) {
            gVar.f7282a.f7053d = adVar.f7053d;
        }
        if (m9195a(adVar, 6149L)) {
            m9189a(gVar, true, gVar.f7282a.f7051b);
        }
        if (m9195a(adVar, 2L)) {
            gVar.f7282a.f7052c = adVar.f7052c;
        }
        if (m9195a(adVar, 8L)) {
            gVar.f7282a.f7054e = adVar.f7054e;
            gVar.f7284c = (adVar.f7054e == null || adVar.f7054e == C1088h.e.f7183c) ? false : true;
        }
        if (m9195a(adVar, 16L)) {
            gVar.f7282a.f7055f = adVar.f7055f;
        }
        if (m9195a(adVar, 6168L)) {
            m9189a(gVar, false, gVar.f7282a.f7054e);
        }
        if (m9195a(adVar, 34359738368L)) {
            gVar.f7282a.f7048L = adVar.f7048L;
        }
        if (m9195a(adVar, 32L)) {
            gVar.f7282a.f7056g = adVar.f7056g;
            gVar.f7286e.setStrokeWidth(gVar.f7282a.f7056g.m9121c(this));
        }
        if (m9195a(adVar, 64L)) {
            gVar.f7282a.f7057h = adVar.f7057h;
            switch (adVar.f7057h) {
                case Butt:
                    gVar.f7286e.setStrokeCap(Paint.Cap.BUTT);
                    break;
                case Round:
                    gVar.f7286e.setStrokeCap(Paint.Cap.ROUND);
                    break;
                case Square:
                    gVar.f7286e.setStrokeCap(Paint.Cap.SQUARE);
                    break;
            }
        }
        if (m9195a(adVar, 128L)) {
            gVar.f7282a.f7058i = adVar.f7058i;
            switch (adVar.f7058i) {
                case Miter:
                    gVar.f7286e.setStrokeJoin(Paint.Join.MITER);
                    break;
                case Round:
                    gVar.f7286e.setStrokeJoin(Paint.Join.ROUND);
                    break;
                case Bevel:
                    gVar.f7286e.setStrokeJoin(Paint.Join.BEVEL);
                    break;
            }
        }
        if (m9195a(adVar, 256L)) {
            gVar.f7282a.f7059j = adVar.f7059j;
            gVar.f7286e.setStrokeMiter(adVar.f7059j.floatValue());
        }
        if (m9195a(adVar, 512L)) {
            gVar.f7282a.f7060k = adVar.f7060k;
        }
        if (m9195a(adVar, PlaybackState.ACTION_PLAY_FROM_MEDIA_ID)) {
            gVar.f7282a.f7061l = adVar.f7061l;
        }
        if (m9195a(adVar, 1536L)) {
            if (gVar.f7282a.f7060k == null) {
                gVar.f7286e.setPathEffect(null);
            } else {
                int length = gVar.f7282a.f7060k.length;
                int i2 = length % 2 == 0 ? length : length * 2;
                float[] fArr = new float[i2];
                float f2 = 0.0f;
                for (int i3 = 0; i3 < i2; i3++) {
                    fArr[i3] = gVar.f7282a.f7060k[i3 % length].m9121c(this);
                    f2 += fArr[i3];
                }
                if (f2 == 0.0f) {
                    gVar.f7286e.setPathEffect(null);
                } else {
                    float m9121c = gVar.f7282a.f7061l.m9121c(this);
                    if (m9121c < 0.0f) {
                        m9121c = (m9121c % f2) + f2;
                    }
                    gVar.f7286e.setPathEffect(new DashPathEffect(fArr, m9121c));
                }
            }
        }
        if (m9195a(adVar, 16384L)) {
            float m9242b = m9242b();
            gVar.f7282a.f7065p = adVar.f7065p;
            gVar.f7285d.setTextSize(adVar.f7065p.m9118a(this, m9242b));
            gVar.f7286e.setTextSize(adVar.f7065p.m9118a(this, m9242b));
        }
        if (m9195a(adVar, PlaybackState.ACTION_PLAY_FROM_URI)) {
            gVar.f7282a.f7064o = adVar.f7064o;
        }
        if (m9195a(adVar, PlaybackState.ACTION_PREPARE_FROM_MEDIA_ID)) {
            if (adVar.f7066q.intValue() == -1 && gVar.f7282a.f7066q.intValue() > 100) {
                gVar.f7282a.f7066q = Integer.valueOf(r0.f7066q.intValue() - 100);
            } else if (adVar.f7066q.intValue() == 1 && gVar.f7282a.f7066q.intValue() < 900) {
                C1088h.ad adVar2 = gVar.f7282a;
                adVar2.f7066q = Integer.valueOf(adVar2.f7066q.intValue() + 100);
            } else {
                gVar.f7282a.f7066q = adVar.f7066q;
            }
        }
        if (m9195a(adVar, 65536L)) {
            gVar.f7282a.f7067r = adVar.f7067r;
        }
        if (m9195a(adVar, 106496L)) {
            if (gVar.f7282a.f7064o == null || this.f7245c == null) {
                typeface = null;
            } else {
                C1090j m9074e = C1088h.m9074e();
                typeface = null;
                for (String str : gVar.f7282a.f7064o) {
                    Typeface m9140a = m9140a(str, gVar.f7282a.f7066q, gVar.f7282a.f7067r);
                    typeface = (m9140a != null || m9074e == null) ? m9140a : m9074e.m9252a(str, gVar.f7282a.f7066q.intValue(), String.valueOf(gVar.f7282a.f7067r));
                    if (typeface != null) {
                    }
                }
            }
            if (typeface == null) {
                typeface = m9140a("serif", gVar.f7282a.f7066q, gVar.f7282a.f7067r);
            }
            gVar.f7285d.setTypeface(typeface);
            gVar.f7286e.setTypeface(typeface);
        }
        if (m9195a(adVar, PlaybackState.ACTION_PREPARE_FROM_URI)) {
            gVar.f7282a.f7068s = adVar.f7068s;
            gVar.f7285d.setStrikeThruText(adVar.f7068s == C1088h.ad.g.LineThrough);
            gVar.f7285d.setUnderlineText(adVar.f7068s == C1088h.ad.g.Underline);
            if (Build.VERSION.SDK_INT >= 17) {
                gVar.f7286e.setStrikeThruText(adVar.f7068s == C1088h.ad.g.LineThrough);
                gVar.f7286e.setUnderlineText(adVar.f7068s == C1088h.ad.g.Underline);
            }
        }
        if (m9195a(adVar, 68719476736L)) {
            gVar.f7282a.f7069t = adVar.f7069t;
        }
        if (m9195a(adVar, 262144L)) {
            gVar.f7282a.f7070u = adVar.f7070u;
        }
        if (m9195a(adVar, 524288L)) {
            gVar.f7282a.f7071v = adVar.f7071v;
        }
        if (m9195a(adVar, 2097152L)) {
            gVar.f7282a.f7073x = adVar.f7073x;
        }
        if (m9195a(adVar, 4194304L)) {
            gVar.f7282a.f7074y = adVar.f7074y;
        }
        if (m9195a(adVar, HardwareBuffer.USAGE_SENSOR_DIRECT_DATA)) {
            gVar.f7282a.f7075z = adVar.f7075z;
        }
        if (m9195a(adVar, HardwareBuffer.USAGE_GPU_DATA_BUFFER)) {
            gVar.f7282a.f7037A = adVar.f7037A;
        }
        if (m9195a(adVar, HardwareBuffer.USAGE_GPU_CUBE_MAP)) {
            gVar.f7282a.f7038B = adVar.f7038B;
        }
        if (m9195a(adVar, 1048576L)) {
            gVar.f7282a.f7072w = adVar.f7072w;
        }
        if (m9195a(adVar, 268435456L)) {
            gVar.f7282a.f7041E = adVar.f7041E;
        }
        if (m9195a(adVar, 536870912L)) {
            gVar.f7282a.f7042F = adVar.f7042F;
        }
        if (m9195a(adVar, 1073741824L)) {
            gVar.f7282a.f7043G = adVar.f7043G;
        }
        if (m9195a(adVar, HardwareBuffer.USAGE_GPU_MIPMAP_COMPLETE)) {
            gVar.f7282a.f7039C = adVar.f7039C;
        }
        if (m9195a(adVar, 134217728L)) {
            gVar.f7282a.f7040D = adVar.f7040D;
        }
        if (m9195a(adVar, 8589934592L)) {
            gVar.f7282a.f7046J = adVar.f7046J;
        }
        if (m9195a(adVar, 17179869184L)) {
            gVar.f7282a.f7047K = adVar.f7047K;
        }
        if (m9195a(adVar, 137438953472L)) {
            gVar.f7282a.f7049M = adVar.f7049M;
        }
    }

    /* renamed from: a */
    private void m9189a(g gVar, boolean z, C1088h.an anVar) {
        int i2;
        float floatValue = (z ? gVar.f7282a.f7053d : gVar.f7282a.f7055f).floatValue();
        if (anVar instanceof C1088h.e) {
            i2 = ((C1088h.e) anVar).f7184a;
        } else if (anVar instanceof C1088h.f) {
            i2 = gVar.f7282a.f7063n.f7184a;
        } else {
            return;
        }
        int m9136a = m9136a(i2, floatValue);
        if (z) {
            gVar.f7285d.setColor(m9136a);
        } else {
            gVar.f7286e.setColor(m9136a);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0033, code lost:
    
        if (r9.equals("serif") != false) goto L12;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Typeface m9140a(String str, Integer num, C1088h.ad.b bVar) {
        char c2 = 0;
        boolean z = bVar == C1088h.ad.b.Italic;
        int i2 = num.intValue() > 500 ? z ? 3 : 1 : z ? 2 : 0;
        switch (str.hashCode()) {
            case -1536685117:
                if (str.equals("sans-serif")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -1431958525:
                if (str.equals("monospace")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -1081737434:
                if (str.equals("fantasy")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 109326717:
                break;
            case 1126973893:
                if (str.equals("cursive")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                return Typeface.create(Typeface.SERIF, i2);
            case 1:
                return Typeface.create(Typeface.SANS_SERIF, i2);
            case 2:
                return Typeface.create(Typeface.MONOSPACE, i2);
            case 3:
                return Typeface.create(Typeface.SANS_SERIF, i2);
            case 4:
                return Typeface.create(Typeface.SANS_SERIF, i2);
            default:
                return null;
        }
    }

    /* renamed from: a */
    private static int m9135a(float f2) {
        int i2 = (int) (256.0f * f2);
        if (i2 < 0) {
            return 0;
        }
        if (i2 <= 255) {
            return i2;
        }
        return 255;
    }

    /* renamed from: a */
    private static int m9136a(int i2, float f2) {
        int i3 = 255;
        int round = Math.round(((i2 >> 24) & 255) * f2);
        if (round < 0) {
            i3 = 0;
        } else if (round <= 255) {
            i3 = round;
        }
        return (i3 << 24) | (16777215 & i2);
    }

    /* renamed from: o */
    private Path.FillType m9235o() {
        return (this.f7246d.f7282a.f7052c == null || this.f7246d.f7282a.f7052c != C1088h.ad.a.EvenOdd) ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
    }

    /* renamed from: a */
    private void m9145a(float f2, float f3, float f4, float f5) {
        float f6 = f2 + f4;
        float f7 = f3 + f5;
        if (this.f7246d.f7282a.f7072w != null) {
            f2 += this.f7246d.f7282a.f7072w.f7160d.m9117a(this);
            f3 += this.f7246d.f7282a.f7072w.f7157a.m9119b(this);
            f6 -= this.f7246d.f7282a.f7072w.f7158b.m9117a(this);
            f7 -= this.f7246d.f7282a.f7072w.f7159c.m9119b(this);
        }
        this.f7243a.clipRect(f2, f3, f6, f7);
    }

    /* renamed from: p */
    private void m9236p() {
        int i2;
        if (this.f7246d.f7282a.f7046J instanceof C1088h.e) {
            i2 = ((C1088h.e) this.f7246d.f7282a.f7046J).f7184a;
        } else if (this.f7246d.f7282a.f7046J instanceof C1088h.f) {
            i2 = this.f7246d.f7282a.f7063n.f7184a;
        } else {
            return;
        }
        if (this.f7246d.f7282a.f7047K != null) {
            i2 = m9136a(i2, this.f7246d.f7282a.f7047K.floatValue());
        }
        this.f7243a.drawColor(i2);
    }

    /* compiled from: SVGAndroidRenderer.java */
    /* renamed from: com.d.a.i$c */
    private class c implements C1088h.w {

        /* renamed from: a */
        Path f7269a = new Path();

        /* renamed from: b */
        float f7270b;

        /* renamed from: c */
        float f7271c;

        c(C1088h.v vVar) {
            if (vVar != null) {
                vVar.m9129a(this);
            }
        }

        /* renamed from: a */
        Path m9248a() {
            return this.f7269a;
        }

        @Override // com.p124d.p125a.C1088h.w
        /* renamed from: a */
        public void mo9125a(float f2, float f3) {
            this.f7269a.moveTo(f2, f3);
            this.f7270b = f2;
            this.f7271c = f3;
        }

        @Override // com.p124d.p125a.C1088h.w
        /* renamed from: b */
        public void mo9132b(float f2, float f3) {
            this.f7269a.lineTo(f2, f3);
            this.f7270b = f2;
            this.f7271c = f3;
        }

        @Override // com.p124d.p125a.C1088h.w
        /* renamed from: a */
        public void mo9127a(float f2, float f3, float f4, float f5, float f6, float f7) {
            this.f7269a.cubicTo(f2, f3, f4, f5, f6, f7);
            this.f7270b = f6;
            this.f7271c = f7;
        }

        @Override // com.p124d.p125a.C1088h.w
        /* renamed from: a */
        public void mo9126a(float f2, float f3, float f4, float f5) {
            this.f7269a.quadTo(f2, f3, f4, f5);
            this.f7270b = f4;
            this.f7271c = f5;
        }

        @Override // com.p124d.p125a.C1088h.w
        /* renamed from: a */
        public void mo9128a(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6) {
            C1089i.m9207b(this.f7270b, this.f7271c, f2, f3, f4, z, z2, f5, f6, this);
            this.f7270b = f5;
            this.f7271c = f6;
        }

        @Override // com.p124d.p125a.C1088h.w
        /* renamed from: b */
        public void mo9131b() {
            this.f7269a.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m9207b(float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, float f7, float f8, C1088h.w wVar) {
        double d2;
        double d3;
        if (f2 == f7 && f3 == f8) {
            return;
        }
        if (f4 == 0.0f || f5 == 0.0f) {
            wVar.mo9132b(f7, f8);
            return;
        }
        float abs = Math.abs(f4);
        float abs2 = Math.abs(f5);
        double radians = Math.toRadians(f6 % 360.0d);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double d4 = (f2 - f7) / 2.0d;
        double d5 = (f3 - f8) / 2.0d;
        double d6 = (cos * d4) + (sin * d5);
        double d7 = (d4 * (-sin)) + (d5 * cos);
        double d8 = abs * abs;
        double d9 = abs2 * abs2;
        double d10 = d6 * d6;
        double d11 = d7 * d7;
        double d12 = (d10 / d8) + (d11 / d9);
        if (d12 > 0.99999d) {
            double sqrt = Math.sqrt(d12) * 1.00001d;
            abs = (float) (abs * sqrt);
            abs2 = (float) (sqrt * abs2);
            d2 = abs2 * abs2;
            d3 = abs * abs;
        } else {
            d2 = d9;
            d3 = d8;
        }
        double d13 = z == z2 ? -1.0d : 1.0d;
        double d14 = (((d3 * d2) - (d3 * d11)) - (d2 * d10)) / ((d2 * d10) + (d3 * d11));
        if (d14 < 0.0d) {
            d14 = 0.0d;
        }
        double sqrt2 = Math.sqrt(d14) * d13;
        double d15 = ((abs * d7) / abs2) * sqrt2;
        double d16 = sqrt2 * (-((abs2 * d6) / abs));
        double d17 = ((f2 + f7) / 2.0d) + ((cos * d15) - (sin * d16));
        double d18 = ((f3 + f8) / 2.0d) + (cos * d16) + (sin * d15);
        double d19 = (d6 - d15) / abs;
        double d20 = (d7 - d16) / abs2;
        double d21 = ((-d6) - d15) / abs;
        double d22 = ((-d7) - d16) / abs2;
        double acos = Math.acos(d19 / Math.sqrt((d19 * d19) + (d20 * d20))) * (d20 < 0.0d ? -1.0d : 1.0d);
        double m9133a = ((d19 * d22) - (d21 * d20) < 0.0d ? -1.0d : 1.0d) * m9133a(((d20 * d22) + (d19 * d21)) / Math.sqrt(((d19 * d19) + (d20 * d20)) * ((d21 * d21) + (d22 * d22))));
        if (!z2 && m9133a > 0.0d) {
            m9133a -= 6.283185307179586d;
        } else if (z2 && m9133a < 0.0d) {
            m9133a += 6.283185307179586d;
        }
        float[] m9197a = m9197a(acos % 6.283185307179586d, m9133a % 6.283185307179586d);
        Matrix matrix = new Matrix();
        matrix.postScale(abs, abs2);
        matrix.postRotate(f6);
        matrix.postTranslate((float) d17, (float) d18);
        matrix.mapPoints(m9197a);
        m9197a[m9197a.length - 2] = f7;
        m9197a[m9197a.length - 1] = f8;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < m9197a.length) {
                wVar.mo9127a(m9197a[i3], m9197a[i3 + 1], m9197a[i3 + 2], m9197a[i3 + 3], m9197a[i3 + 4], m9197a[i3 + 5]);
                i2 = i3 + 6;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private static double m9133a(double d2) {
        if (d2 < -1.0d) {
            return 3.141592653589793d;
        }
        if (d2 > 1.0d) {
            return 0.0d;
        }
        return Math.acos(d2);
    }

    /* renamed from: a */
    private static float[] m9197a(double d2, double d3) {
        int ceil = (int) Math.ceil((Math.abs(d3) * 2.0d) / 3.141592653589793d);
        double d4 = d3 / ceil;
        double sin = (1.3333333333333333d * Math.sin(d4 / 2.0d)) / (1.0d + Math.cos(d4 / 2.0d));
        float[] fArr = new float[ceil * 6];
        int i2 = 0;
        for (int i3 = 0; i3 < ceil; i3++) {
            double d5 = (i3 * d4) + d2;
            double cos = Math.cos(d5);
            double sin2 = Math.sin(d5);
            int i4 = i2 + 1;
            fArr[i2] = (float) (cos - (sin * sin2));
            int i5 = i4 + 1;
            fArr[i4] = (float) ((cos * sin) + sin2);
            double d6 = d5 + d4;
            double cos2 = Math.cos(d6);
            double sin3 = Math.sin(d6);
            int i6 = i5 + 1;
            fArr[i5] = (float) ((sin * sin3) + cos2);
            int i7 = i6 + 1;
            fArr[i6] = (float) (sin3 - (sin * cos2));
            int i8 = i7 + 1;
            fArr[i7] = (float) cos2;
            i2 = i8 + 1;
            fArr[i8] = (float) sin3;
        }
        return fArr;
    }

    /* compiled from: SVGAndroidRenderer.java */
    /* renamed from: com.d.a.i$b */
    private class b {

        /* renamed from: a */
        float f7263a;

        /* renamed from: b */
        float f7264b;

        /* renamed from: c */
        float f7265c;

        /* renamed from: d */
        float f7266d;

        /* renamed from: e */
        boolean f7267e = false;

        b(float f2, float f3, float f4, float f5) {
            this.f7265c = 0.0f;
            this.f7266d = 0.0f;
            this.f7263a = f2;
            this.f7264b = f3;
            double sqrt = Math.sqrt((f4 * f4) + (f5 * f5));
            if (sqrt != 0.0d) {
                this.f7265c = (float) (f4 / sqrt);
                this.f7266d = (float) (f5 / sqrt);
            }
        }

        /* renamed from: a */
        void m9246a(float f2, float f3) {
            float f4 = f2 - this.f7263a;
            float f5 = f3 - this.f7264b;
            double sqrt = Math.sqrt((f4 * f4) + (f5 * f5));
            if (sqrt != 0.0d) {
                f4 = (float) (f4 / sqrt);
                f5 = (float) (f5 / sqrt);
            }
            if (f4 == (-this.f7265c) && f5 == (-this.f7266d)) {
                this.f7267e = true;
                this.f7265c = -f5;
                this.f7266d = f4;
            } else {
                this.f7265c = f4 + this.f7265c;
                this.f7266d = f5 + this.f7266d;
            }
        }

        /* renamed from: a */
        void m9247a(b bVar) {
            if (bVar.f7265c == (-this.f7265c) && bVar.f7266d == (-this.f7266d)) {
                this.f7267e = true;
                this.f7265c = -bVar.f7266d;
                this.f7266d = bVar.f7265c;
            } else {
                this.f7265c += bVar.f7265c;
                this.f7266d += bVar.f7266d;
            }
        }

        public String toString() {
            return "(" + this.f7263a + "," + this.f7264b + " " + this.f7265c + "," + this.f7266d + ")";
        }
    }

    /* compiled from: SVGAndroidRenderer.java */
    /* renamed from: com.d.a.i$a */
    private class a implements C1088h.w {

        /* renamed from: c */
        private float f7256c;

        /* renamed from: d */
        private float f7257d;

        /* renamed from: i */
        private boolean f7262i;

        /* renamed from: b */
        private List<b> f7255b = new ArrayList();

        /* renamed from: e */
        private b f7258e = null;

        /* renamed from: f */
        private boolean f7259f = false;

        /* renamed from: g */
        private boolean f7260g = true;

        /* renamed from: h */
        private int f7261h = -1;

        a(C1088h.v vVar) {
            if (vVar != null) {
                vVar.m9129a(this);
                if (this.f7262i) {
                    this.f7258e.m9247a(this.f7255b.get(this.f7261h));
                    this.f7255b.set(this.f7261h, this.f7258e);
                    this.f7262i = false;
                }
                if (this.f7258e != null) {
                    this.f7255b.add(this.f7258e);
                }
            }
        }

        /* renamed from: a */
        List<b> m9245a() {
            return this.f7255b;
        }

        @Override // com.p124d.p125a.C1088h.w
        /* renamed from: a */
        public void mo9125a(float f2, float f3) {
            if (this.f7262i) {
                this.f7258e.m9247a(this.f7255b.get(this.f7261h));
                this.f7255b.set(this.f7261h, this.f7258e);
                this.f7262i = false;
            }
            if (this.f7258e != null) {
                this.f7255b.add(this.f7258e);
            }
            this.f7256c = f2;
            this.f7257d = f3;
            this.f7258e = C1089i.this.new b(f2, f3, 0.0f, 0.0f);
            this.f7261h = this.f7255b.size();
        }

        @Override // com.p124d.p125a.C1088h.w
        /* renamed from: b */
        public void mo9132b(float f2, float f3) {
            this.f7258e.m9246a(f2, f3);
            this.f7255b.add(this.f7258e);
            this.f7258e = C1089i.this.new b(f2, f3, f2 - this.f7258e.f7263a, f3 - this.f7258e.f7264b);
            this.f7262i = false;
        }

        @Override // com.p124d.p125a.C1088h.w
        /* renamed from: a */
        public void mo9127a(float f2, float f3, float f4, float f5, float f6, float f7) {
            if (this.f7260g || this.f7259f) {
                this.f7258e.m9246a(f2, f3);
                this.f7255b.add(this.f7258e);
                this.f7259f = false;
            }
            this.f7258e = C1089i.this.new b(f6, f7, f6 - f4, f7 - f5);
            this.f7262i = false;
        }

        @Override // com.p124d.p125a.C1088h.w
        /* renamed from: a */
        public void mo9126a(float f2, float f3, float f4, float f5) {
            this.f7258e.m9246a(f2, f3);
            this.f7255b.add(this.f7258e);
            this.f7258e = C1089i.this.new b(f4, f5, f4 - f2, f5 - f3);
            this.f7262i = false;
        }

        @Override // com.p124d.p125a.C1088h.w
        /* renamed from: a */
        public void mo9128a(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6) {
            this.f7259f = true;
            this.f7260g = false;
            C1089i.m9207b(this.f7258e.f7263a, this.f7258e.f7264b, f2, f3, f4, z, z2, f5, f6, this);
            this.f7260g = true;
            this.f7262i = false;
        }

        @Override // com.p124d.p125a.C1088h.w
        /* renamed from: b */
        public void mo9131b() {
            this.f7255b.add(this.f7258e);
            mo9132b(this.f7256c, this.f7257d);
            this.f7262i = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0107  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m9175a(C1088h.k kVar) {
        C1088h.q qVar;
        C1088h.q qVar2;
        C1088h.q qVar3;
        List<b> m9206b;
        int size;
        int i2 = 1;
        if (this.f7246d.f7282a.f7073x != null || this.f7246d.f7282a.f7074y != null || this.f7246d.f7282a.f7075z != null) {
            if (this.f7246d.f7282a.f7073x != null) {
                C1088h.am m9082b = kVar.f7137u.m9082b(this.f7246d.f7282a.f7073x);
                if (m9082b != null) {
                    qVar = (C1088h.q) m9082b;
                    if (this.f7246d.f7282a.f7074y != null) {
                        C1088h.am m9082b2 = kVar.f7137u.m9082b(this.f7246d.f7282a.f7074y);
                        if (m9082b2 != null) {
                            qVar2 = (C1088h.q) m9082b2;
                            if (this.f7246d.f7282a.f7075z != null) {
                                C1088h.am m9082b3 = kVar.f7137u.m9082b(this.f7246d.f7282a.f7075z);
                                if (m9082b3 != null) {
                                    qVar3 = (C1088h.q) m9082b3;
                                    if (!(kVar instanceof C1088h.u)) {
                                        m9206b = new a(((C1088h.u) kVar).f7227a).m9245a();
                                    } else if (kVar instanceof C1088h.p) {
                                        m9206b = m9205b((C1088h.p) kVar);
                                    } else {
                                        m9206b = m9206b((C1088h.y) kVar);
                                    }
                                    if (m9206b == null && (size = m9206b.size()) != 0) {
                                        C1088h.ad adVar = this.f7246d.f7282a;
                                        C1088h.ad adVar2 = this.f7246d.f7282a;
                                        this.f7246d.f7282a.f7075z = null;
                                        adVar2.f7074y = null;
                                        adVar.f7073x = null;
                                        if (qVar != null) {
                                            m9180a(qVar, m9206b.get(0));
                                        }
                                        if (qVar2 != null && m9206b.size() > 2) {
                                            b bVar = m9206b.get(0);
                                            b bVar2 = m9206b.get(1);
                                            b bVar3 = bVar;
                                            while (i2 < size - 1) {
                                                b bVar4 = m9206b.get(i2 + 1);
                                                b m9142a = bVar2.f7267e ? m9142a(bVar3, bVar2, bVar4) : bVar2;
                                                m9180a(qVar2, m9142a);
                                                i2++;
                                                bVar2 = bVar4;
                                                bVar3 = m9142a;
                                            }
                                        }
                                        if (qVar3 != null) {
                                            m9180a(qVar3, m9206b.get(size - 1));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                m9224e("Marker reference '%s' not found", this.f7246d.f7282a.f7075z);
                            }
                            qVar3 = null;
                            if (!(kVar instanceof C1088h.u)) {
                            }
                            if (m9206b == null) {
                                return;
                            } else {
                                return;
                            }
                        }
                        m9224e("Marker reference '%s' not found", this.f7246d.f7282a.f7074y);
                    }
                    qVar2 = null;
                    if (this.f7246d.f7282a.f7075z != null) {
                    }
                    qVar3 = null;
                    if (!(kVar instanceof C1088h.u)) {
                    }
                    if (m9206b == null) {
                    }
                } else {
                    m9224e("Marker reference '%s' not found", this.f7246d.f7282a.f7073x);
                }
            }
            qVar = null;
            if (this.f7246d.f7282a.f7074y != null) {
            }
            qVar2 = null;
            if (this.f7246d.f7282a.f7075z != null) {
            }
            qVar3 = null;
            if (!(kVar instanceof C1088h.u)) {
            }
            if (m9206b == null) {
            }
        }
    }

    /* renamed from: a */
    private b m9142a(b bVar, b bVar2, b bVar3) {
        float m9198b = m9198b(bVar2.f7265c, bVar2.f7266d, bVar2.f7263a - bVar.f7263a, bVar2.f7264b - bVar.f7264b);
        if (m9198b == 0.0f) {
            m9198b = m9198b(bVar2.f7265c, bVar2.f7266d, bVar3.f7263a - bVar2.f7263a, bVar3.f7264b - bVar2.f7264b);
        }
        if (m9198b <= 0.0f && (m9198b != 0.0f || (bVar2.f7265c <= 0.0f && bVar2.f7266d < 0.0f))) {
            bVar2.f7265c = -bVar2.f7265c;
            bVar2.f7266d = -bVar2.f7266d;
        }
        return bVar2;
    }

    /* renamed from: b */
    private float m9198b(float f2, float f3, float f4, float f5) {
        return (f2 * f4) + (f3 * f5);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010d  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m9180a(C1088h.q qVar, b bVar) {
        float f2;
        boolean m9229i;
        float f3;
        float f4;
        float f5 = 0.0f;
        m9225f();
        if (qVar.f7218f != null) {
            if (!Float.isNaN(qVar.f7218f.floatValue())) {
                f2 = qVar.f7218f.floatValue();
            } else if (bVar.f7265c != 0.0f || bVar.f7266d != 0.0f) {
                f2 = (float) Math.toDegrees(Math.atan2(bVar.f7266d, bVar.f7265c));
            }
            float m9116a = !qVar.f7213a ? 1.0f : this.f7246d.f7282a.f7056g.m9116a(this.f7244b);
            this.f7246d = m9217c((C1088h.am) qVar);
            Matrix matrix = new Matrix();
            matrix.preTranslate(bVar.f7263a, bVar.f7264b);
            matrix.preRotate(f2);
            matrix.preScale(m9116a, m9116a);
            float m9117a = qVar.f7214b == null ? qVar.f7214b.m9117a(this) : 0.0f;
            float m9119b = qVar.f7215c == null ? qVar.f7215c.m9119b(this) : 0.0f;
            float m9117a2 = qVar.f7216d == null ? qVar.f7216d.m9117a(this) : 3.0f;
            float m9119b2 = qVar.f7217e != null ? qVar.f7217e.m9119b(this) : 3.0f;
            if (qVar.f7145x == null) {
                float f6 = m9117a2 / qVar.f7145x.f7028c;
                float f7 = m9119b2 / qVar.f7145x.f7029d;
                C1086f c1086f = qVar.f7139w != null ? qVar.f7139w : C1086f.f6988c;
                if (c1086f.equals(C1086f.f6987b)) {
                    f3 = f7;
                } else {
                    float max = c1086f.m9064b() == C1086f.b.slice ? Math.max(f6, f7) : Math.min(f6, f7);
                    f3 = max;
                    f6 = max;
                }
                matrix.preTranslate((-m9117a) * f6, (-m9119b) * f3);
                this.f7243a.concat(matrix);
                float f8 = qVar.f7145x.f7028c * f6;
                float f9 = qVar.f7145x.f7029d * f3;
                switch (c1086f.m9063a()) {
                    case xMidYMin:
                    case xMidYMid:
                    case xMidYMax:
                        f4 = 0.0f - ((m9117a2 - f8) / 2.0f);
                        break;
                    case xMaxYMin:
                    case xMaxYMid:
                    case xMaxYMax:
                        f4 = 0.0f - (m9117a2 - f8);
                        break;
                    default:
                        f4 = 0.0f;
                        break;
                }
                switch (c1086f.m9063a()) {
                    case xMidYMid:
                    case xMaxYMid:
                    case xMinYMid:
                        f5 = 0.0f - ((m9119b2 - f9) / 2.0f);
                        break;
                    case xMidYMax:
                    case xMaxYMax:
                    case xMinYMax:
                        f5 = 0.0f - (m9119b2 - f9);
                        break;
                }
                if (!this.f7246d.f7282a.f7071v.booleanValue()) {
                    m9145a(f4, f5, m9117a2, m9119b2);
                }
                matrix.reset();
                matrix.preScale(f6, f3);
                this.f7243a.concat(matrix);
            } else {
                matrix.preTranslate(-m9117a, -m9119b);
                this.f7243a.concat(matrix);
                if (!this.f7246d.f7282a.f7071v.booleanValue()) {
                    m9145a(0.0f, 0.0f, m9117a2, m9119b2);
                }
            }
            m9229i = m9229i();
            m9153a((C1088h.ai) qVar, false);
            if (m9229i) {
                m9208b((C1088h.aj) qVar);
            }
            m9227g();
        }
        f2 = 0.0f;
        if (!qVar.f7213a) {
        }
        this.f7246d = m9217c((C1088h.am) qVar);
        Matrix matrix2 = new Matrix();
        matrix2.preTranslate(bVar.f7263a, bVar.f7264b);
        matrix2.preRotate(f2);
        matrix2.preScale(m9116a, m9116a);
        if (qVar.f7214b == null) {
        }
        if (qVar.f7215c == null) {
        }
        if (qVar.f7216d == null) {
        }
        if (qVar.f7217e != null) {
        }
        if (qVar.f7145x == null) {
        }
        m9229i = m9229i();
        m9153a((C1088h.ai) qVar, false);
        if (m9229i) {
        }
        m9227g();
    }

    /* renamed from: c */
    private g m9217c(C1088h.am amVar) {
        g gVar = new g();
        m9187a(gVar, C1088h.ad.m9097a());
        return m9143a(amVar, gVar);
    }

    /* renamed from: a */
    private g m9143a(C1088h.am amVar, g gVar) {
        ArrayList arrayList = new ArrayList();
        C1088h.am amVar2 = amVar;
        while (true) {
            if (amVar2 instanceof C1088h.ak) {
                arrayList.add(0, (C1088h.ak) amVar2);
            }
            if (amVar2.f7138v == null) {
                break;
            }
            amVar2 = (C1088h.am) amVar2.f7138v;
        }
        Iterator<E> it = arrayList.iterator();
        while (it.hasNext()) {
            m9188a(gVar, (C1088h.ak) it.next());
        }
        gVar.f7288g = this.f7246d.f7288g;
        gVar.f7287f = this.f7246d.f7287f;
        return gVar;
    }

    /* renamed from: c */
    private void m9218c(C1088h.aj ajVar) {
        if (this.f7246d.f7282a.f7051b instanceof C1088h.t) {
            m9193a(true, ajVar.f7127o, (C1088h.t) this.f7246d.f7282a.f7051b);
        }
        if (this.f7246d.f7282a.f7054e instanceof C1088h.t) {
            m9193a(false, ajVar.f7127o, (C1088h.t) this.f7246d.f7282a.f7054e);
        }
    }

    /* renamed from: a */
    private void m9193a(boolean z, C1088h.a aVar, C1088h.t tVar) {
        C1088h.am m9082b = this.f7245c.m9082b(tVar.f7225a);
        if (m9082b == null) {
            Object[] objArr = new Object[2];
            objArr[0] = z ? "Fill" : "Stroke";
            objArr[1] = tVar.f7225a;
            m9224e("%s reference '%s' not found", objArr);
            if (tVar.f7226b != null) {
                m9189a(this.f7246d, z, tVar.f7226b);
                return;
            } else if (z) {
                this.f7246d.f7283b = false;
                return;
            } else {
                this.f7246d.f7284c = false;
                return;
            }
        }
        if (m9082b instanceof C1088h.al) {
            m9191a(z, aVar, (C1088h.al) m9082b);
        } else if (m9082b instanceof C1088h.ap) {
            m9192a(z, aVar, (C1088h.ap) m9082b);
        } else if (m9082b instanceof C1088h.ab) {
            m9194a(z, (C1088h.ab) m9082b);
        }
    }

    /* renamed from: a */
    private void m9191a(boolean z, C1088h.a aVar, C1088h.al alVar) {
        float m9118a;
        float m9118a2;
        float m9118a3;
        float f2;
        if (alVar.f7194e != null) {
            m9174a(alVar, alVar.f7194e);
        }
        boolean z2 = alVar.f7191b != null && alVar.f7191b.booleanValue();
        Paint paint = z ? this.f7246d.f7285d : this.f7246d.f7286e;
        if (z2) {
            C1088h.a m9244d = m9244d();
            float m9117a = alVar.f7133f != null ? alVar.f7133f.m9117a(this) : 0.0f;
            m9118a = alVar.f7134g != null ? alVar.f7134g.m9119b(this) : 0.0f;
            m9118a2 = alVar.f7135h != null ? alVar.f7135h.m9117a(this) : m9244d.f7028c;
            m9118a3 = alVar.f7136i != null ? alVar.f7136i.m9119b(this) : 0.0f;
            f2 = m9117a;
        } else {
            float m9118a4 = alVar.f7133f != null ? alVar.f7133f.m9118a(this, 1.0f) : 0.0f;
            m9118a = alVar.f7134g != null ? alVar.f7134g.m9118a(this, 1.0f) : 0.0f;
            m9118a2 = alVar.f7135h != null ? alVar.f7135h.m9118a(this, 1.0f) : 1.0f;
            m9118a3 = alVar.f7136i != null ? alVar.f7136i.m9118a(this, 1.0f) : 0.0f;
            f2 = m9118a4;
        }
        m9225f();
        this.f7246d = m9217c(alVar);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(aVar.f7026a, aVar.f7027b);
            matrix.preScale(aVar.f7028c, aVar.f7029d);
        }
        if (alVar.f7192c != null) {
            matrix.preConcat(alVar.f7192c);
        }
        int size = alVar.f7190a.size();
        if (size == 0) {
            m9227g();
            if (z) {
                this.f7246d.f7283b = false;
                return;
            } else {
                this.f7246d.f7284c = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        int i2 = 0;
        Iterator<C1088h.am> it = alVar.f7190a.iterator();
        float f3 = -1.0f;
        while (it.hasNext()) {
            C1088h.ac acVar = (C1088h.ac) it.next();
            float floatValue = acVar.f7036a != null ? acVar.f7036a.floatValue() : 0.0f;
            if (i2 == 0 || floatValue >= f3) {
                fArr[i2] = floatValue;
                f3 = floatValue;
            } else {
                fArr[i2] = f3;
            }
            m9225f();
            m9188a(this.f7246d, acVar);
            C1088h.e eVar = (C1088h.e) this.f7246d.f7282a.f7039C;
            if (eVar == null) {
                eVar = C1088h.e.f7182b;
            }
            iArr[i2] = m9136a(eVar.f7184a, this.f7246d.f7282a.f7040D.floatValue());
            m9227g();
            i2++;
        }
        if ((f2 == m9118a2 && m9118a == m9118a3) || size == 1) {
            m9227g();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (alVar.f7193d != null) {
            if (alVar.f7193d == C1088h.j.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (alVar.f7193d == C1088h.j.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        m9227g();
        LinearGradient linearGradient = new LinearGradient(f2, m9118a, m9118a2, m9118a3, iArr, fArr, tileMode);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);
        paint.setAlpha(m9135a(this.f7246d.f7282a.f7053d.floatValue()));
    }

    /* renamed from: a */
    private void m9192a(boolean z, C1088h.a aVar, C1088h.ap apVar) {
        float m9118a;
        float m9118a2;
        float f2;
        if (apVar.f7194e != null) {
            m9174a(apVar, apVar.f7194e);
        }
        boolean z2 = apVar.f7191b != null && apVar.f7191b.booleanValue();
        Paint paint = z ? this.f7246d.f7285d : this.f7246d.f7286e;
        if (z2) {
            C1088h.o oVar = new C1088h.o(50.0f, C1088h.bc.percent);
            float m9117a = apVar.f7140f != null ? apVar.f7140f.m9117a(this) : oVar.m9117a(this);
            m9118a = apVar.f7141g != null ? apVar.f7141g.m9119b(this) : oVar.m9119b(this);
            m9118a2 = apVar.f7142h != null ? apVar.f7142h.m9121c(this) : oVar.m9121c(this);
            f2 = m9117a;
        } else {
            float m9118a3 = apVar.f7140f != null ? apVar.f7140f.m9118a(this, 1.0f) : 0.5f;
            m9118a = apVar.f7141g != null ? apVar.f7141g.m9118a(this, 1.0f) : 0.5f;
            m9118a2 = apVar.f7142h != null ? apVar.f7142h.m9118a(this, 1.0f) : 0.5f;
            f2 = m9118a3;
        }
        m9225f();
        this.f7246d = m9217c(apVar);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(aVar.f7026a, aVar.f7027b);
            matrix.preScale(aVar.f7028c, aVar.f7029d);
        }
        if (apVar.f7192c != null) {
            matrix.preConcat(apVar.f7192c);
        }
        int size = apVar.f7190a.size();
        if (size == 0) {
            m9227g();
            if (z) {
                this.f7246d.f7283b = false;
                return;
            } else {
                this.f7246d.f7284c = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        int i2 = 0;
        Iterator<C1088h.am> it = apVar.f7190a.iterator();
        float f3 = -1.0f;
        while (it.hasNext()) {
            C1088h.ac acVar = (C1088h.ac) it.next();
            float floatValue = acVar.f7036a != null ? acVar.f7036a.floatValue() : 0.0f;
            if (i2 == 0 || floatValue >= f3) {
                fArr[i2] = floatValue;
                f3 = floatValue;
            } else {
                fArr[i2] = f3;
            }
            m9225f();
            m9188a(this.f7246d, acVar);
            C1088h.e eVar = (C1088h.e) this.f7246d.f7282a.f7039C;
            if (eVar == null) {
                eVar = C1088h.e.f7182b;
            }
            iArr[i2] = m9136a(eVar.f7184a, this.f7246d.f7282a.f7040D.floatValue());
            m9227g();
            i2++;
        }
        if (m9118a2 == 0.0f || size == 1) {
            m9227g();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (apVar.f7193d != null) {
            if (apVar.f7193d == C1088h.j.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (apVar.f7193d == C1088h.j.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        m9227g();
        RadialGradient radialGradient = new RadialGradient(f2, m9118a, m9118a2, iArr, fArr, tileMode);
        radialGradient.setLocalMatrix(matrix);
        paint.setShader(radialGradient);
        paint.setAlpha(m9135a(this.f7246d.f7282a.f7053d.floatValue()));
    }

    /* renamed from: a */
    private void m9174a(C1088h.i iVar, String str) {
        C1088h.am m9082b = iVar.f7137u.m9082b(str);
        if (m9082b == null) {
            m9222d("Gradient reference '%s' not found", str);
            return;
        }
        if (!(m9082b instanceof C1088h.i)) {
            m9224e("Gradient href attributes must point to other gradient elements", new Object[0]);
            return;
        }
        if (m9082b == iVar) {
            m9224e("Circular reference in gradient href attribute '%s'", str);
            return;
        }
        C1088h.i iVar2 = (C1088h.i) m9082b;
        if (iVar.f7191b == null) {
            iVar.f7191b = iVar2.f7191b;
        }
        if (iVar.f7192c == null) {
            iVar.f7192c = iVar2.f7192c;
        }
        if (iVar.f7193d == null) {
            iVar.f7193d = iVar2.f7193d;
        }
        if (iVar.f7190a.isEmpty()) {
            iVar.f7190a = iVar2.f7190a;
        }
        try {
            if (iVar instanceof C1088h.al) {
                m9158a((C1088h.al) iVar, (C1088h.al) m9082b);
            } else {
                m9162a((C1088h.ap) iVar, (C1088h.ap) m9082b);
            }
        } catch (ClassCastException e2) {
        }
        if (iVar2.f7194e != null) {
            m9174a(iVar, iVar2.f7194e);
        }
    }

    /* renamed from: a */
    private void m9158a(C1088h.al alVar, C1088h.al alVar2) {
        if (alVar.f7133f == null) {
            alVar.f7133f = alVar2.f7133f;
        }
        if (alVar.f7134g == null) {
            alVar.f7134g = alVar2.f7134g;
        }
        if (alVar.f7135h == null) {
            alVar.f7135h = alVar2.f7135h;
        }
        if (alVar.f7136i == null) {
            alVar.f7136i = alVar2.f7136i;
        }
    }

    /* renamed from: a */
    private void m9162a(C1088h.ap apVar, C1088h.ap apVar2) {
        if (apVar.f7140f == null) {
            apVar.f7140f = apVar2.f7140f;
        }
        if (apVar.f7141g == null) {
            apVar.f7141g = apVar2.f7141g;
        }
        if (apVar.f7142h == null) {
            apVar.f7142h = apVar2.f7142h;
        }
        if (apVar.f7143i == null) {
            apVar.f7143i = apVar2.f7143i;
        }
        if (apVar.f7144j == null) {
            apVar.f7144j = apVar2.f7144j;
        }
    }

    /* renamed from: a */
    private void m9194a(boolean z, C1088h.ab abVar) {
        if (z) {
            if (m9195a(abVar.f7130r, 2147483648L)) {
                this.f7246d.f7282a.f7051b = abVar.f7130r.f7044H;
                this.f7246d.f7283b = abVar.f7130r.f7044H != null;
            }
            if (m9195a(abVar.f7130r, 4294967296L)) {
                this.f7246d.f7282a.f7053d = abVar.f7130r.f7045I;
            }
            if (m9195a(abVar.f7130r, 6442450944L)) {
                m9189a(this.f7246d, z, this.f7246d.f7282a.f7051b);
                return;
            }
            return;
        }
        if (m9195a(abVar.f7130r, 2147483648L)) {
            this.f7246d.f7282a.f7054e = abVar.f7130r.f7044H;
            this.f7246d.f7284c = abVar.f7130r.f7044H != null;
        }
        if (m9195a(abVar.f7130r, 4294967296L)) {
            this.f7246d.f7282a.f7055f = abVar.f7130r.f7045I;
        }
        if (m9195a(abVar.f7130r, 6442450944L)) {
            m9189a(this.f7246d, z, this.f7246d.f7282a.f7054e);
        }
    }

    /* renamed from: d */
    private void m9220d(C1088h.aj ajVar) {
        m9209b(ajVar, ajVar.f7127o);
    }

    /* renamed from: b */
    private void m9209b(C1088h.aj ajVar, C1088h.a aVar) {
        if (this.f7246d.f7282a.f7041E != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                Path m9214c = m9214c(ajVar, aVar);
                if (m9214c != null) {
                    this.f7243a.clipPath(m9214c);
                    return;
                }
                return;
            }
            m9221d(ajVar, aVar);
        }
    }

    @TargetApi(19)
    /* renamed from: c */
    private Path m9214c(C1088h.aj ajVar, C1088h.a aVar) {
        Path m9139a;
        C1088h.am m9082b = ajVar.f7137u.m9082b(this.f7246d.f7282a.f7041E);
        if (m9082b == null) {
            m9224e("ClipPath reference '%s' not found", this.f7246d.f7282a.f7041E);
            return null;
        }
        C1088h.d dVar = (C1088h.d) m9082b;
        this.f7247e.push(this.f7246d);
        this.f7246d = m9217c((C1088h.am) dVar);
        boolean z = dVar.f7181a == null || dVar.f7181a.booleanValue();
        Matrix matrix = new Matrix();
        if (!z) {
            matrix.preTranslate(aVar.f7026a, aVar.f7027b);
            matrix.preScale(aVar.f7028c, aVar.f7029d);
        }
        if (dVar.f7200b != null) {
            matrix.preConcat(dVar.f7200b);
        }
        Path path = new Path();
        for (C1088h.am amVar : dVar.f7116i) {
            if ((amVar instanceof C1088h.aj) && (m9139a = m9139a((C1088h.aj) amVar, true)) != null) {
                path.m53op(m9139a, Path.EnumC0013Op.UNION);
            }
        }
        if (this.f7246d.f7282a.f7041E != null) {
            if (dVar.f7127o == null) {
                dVar.f7127o = m9203b(path);
            }
            Path m9214c = m9214c(dVar, dVar.f7127o);
            if (m9214c != null) {
                path.m53op(m9214c, Path.EnumC0013Op.INTERSECT);
            }
        }
        path.transform(matrix);
        this.f7246d = this.f7247e.pop();
        return path;
    }

    @TargetApi(19)
    /* renamed from: a */
    private Path m9139a(C1088h.aj ajVar, boolean z) {
        Path m9200b;
        Path m9214c;
        this.f7247e.push(this.f7246d);
        this.f7246d = new g(this.f7246d);
        m9188a(this.f7246d, ajVar);
        if (!m9233m() || !m9234n()) {
            this.f7246d = this.f7247e.pop();
            return null;
        }
        if (ajVar instanceof C1088h.bd) {
            if (!z) {
                m9224e("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
            }
            C1088h.bd bdVar = (C1088h.bd) ajVar;
            C1088h.am m9082b = ajVar.f7137u.m9082b(bdVar.f7173a);
            if (m9082b == null) {
                m9224e("Use reference '%s' not found", bdVar.f7173a);
                this.f7246d = this.f7247e.pop();
                return null;
            }
            if (!(m9082b instanceof C1088h.aj)) {
                this.f7246d = this.f7247e.pop();
                return null;
            }
            m9200b = m9139a((C1088h.aj) m9082b, false);
            if (m9200b == null) {
                return null;
            }
            if (bdVar.f7127o == null) {
                bdVar.f7127o = m9203b(m9200b);
            }
            if (bdVar.f7200b != null) {
                m9200b.transform(bdVar.f7200b);
            }
        } else if (ajVar instanceof C1088h.k) {
            C1088h.k kVar = (C1088h.k) ajVar;
            if (ajVar instanceof C1088h.u) {
                m9200b = new c(((C1088h.u) ajVar).f7227a).m9248a();
                if (ajVar.f7127o == null) {
                    ajVar.f7127o = m9203b(m9200b);
                }
            } else {
                m9200b = ajVar instanceof C1088h.aa ? m9199b((C1088h.aa) ajVar) : ajVar instanceof C1088h.c ? m9201b((C1088h.c) ajVar) : ajVar instanceof C1088h.h ? m9202b((C1088h.h) ajVar) : ajVar instanceof C1088h.y ? m9216c((C1088h.y) ajVar) : null;
            }
            if (m9200b == null) {
                return null;
            }
            if (kVar.f7127o == null) {
                kVar.f7127o = m9203b(m9200b);
            }
            if (kVar.f7199e != null) {
                m9200b.transform(kVar.f7199e);
            }
            m9200b.setFillType(m9239s());
        } else if (ajVar instanceof C1088h.av) {
            C1088h.av avVar = (C1088h.av) ajVar;
            m9200b = m9200b(avVar);
            if (m9200b == null) {
                return null;
            }
            if (avVar.f7149a != null) {
                m9200b.transform(avVar.f7149a);
            }
            m9200b.setFillType(m9239s());
        } else {
            m9224e("Invalid %s element found in clipPath definition", ajVar.mo9094a());
            return null;
        }
        if (this.f7246d.f7282a.f7041E != null && (m9214c = m9214c(ajVar, ajVar.f7127o)) != null) {
            m9200b.m53op(m9214c, Path.EnumC0013Op.INTERSECT);
        }
        this.f7246d = this.f7247e.pop();
        return m9200b;
    }

    /* renamed from: d */
    private void m9221d(C1088h.aj ajVar, C1088h.a aVar) {
        C1088h.am m9082b = ajVar.f7137u.m9082b(this.f7246d.f7282a.f7041E);
        if (m9082b == null) {
            m9224e("ClipPath reference '%s' not found", this.f7246d.f7282a.f7041E);
            return;
        }
        C1088h.d dVar = (C1088h.d) m9082b;
        if (dVar.f7116i.isEmpty()) {
            this.f7243a.clipRect(0, 0, 0, 0);
            return;
        }
        boolean z = dVar.f7181a == null || dVar.f7181a.booleanValue();
        if ((ajVar instanceof C1088h.l) && !z) {
            m9222d("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", ajVar.mo9094a());
            return;
        }
        m9237q();
        if (!z) {
            Matrix matrix = new Matrix();
            matrix.preTranslate(aVar.f7026a, aVar.f7027b);
            matrix.preScale(aVar.f7028c, aVar.f7029d);
            this.f7243a.concat(matrix);
        }
        if (dVar.f7200b != null) {
            this.f7243a.concat(dVar.f7200b);
        }
        this.f7246d = m9217c((C1088h.am) dVar);
        m9220d(dVar);
        Path path = new Path();
        Iterator<C1088h.am> it = dVar.f7116i.iterator();
        while (it.hasNext()) {
            m9161a(it.next(), true, path, new Matrix());
        }
        this.f7243a.clipPath(path);
        m9238r();
    }

    /* renamed from: a */
    private void m9161a(C1088h.am amVar, boolean z, Path path, Matrix matrix) {
        if (m9233m()) {
            m9237q();
            if (amVar instanceof C1088h.bd) {
                if (z) {
                    m9171a((C1088h.bd) amVar, path, matrix);
                } else {
                    m9224e("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
                }
            } else if (amVar instanceof C1088h.u) {
                m9183a((C1088h.u) amVar, path, matrix);
            } else if (amVar instanceof C1088h.av) {
                m9166a((C1088h.av) amVar, path, matrix);
            } else if (amVar instanceof C1088h.k) {
                m9176a((C1088h.k) amVar, path, matrix);
            } else {
                m9224e("Invalid %s element found in clipPath definition", amVar.toString());
            }
            m9238r();
        }
    }

    /* renamed from: q */
    private void m9237q() {
        C1083c.m9055a(this.f7243a, C1083c.f6979a);
        this.f7247e.push(this.f7246d);
        this.f7246d = new g(this.f7246d);
    }

    /* renamed from: r */
    private void m9238r() {
        this.f7243a.restore();
        this.f7246d = this.f7247e.pop();
    }

    /* renamed from: s */
    private Path.FillType m9239s() {
        return (this.f7246d.f7282a.f7042F == null || this.f7246d.f7282a.f7042F != C1088h.ad.a.EvenOdd) ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
    }

    /* renamed from: a */
    private void m9183a(C1088h.u uVar, Path path, Matrix matrix) {
        m9188a(this.f7246d, uVar);
        if (m9233m() && m9234n()) {
            if (uVar.f7199e != null) {
                matrix.preConcat(uVar.f7199e);
            }
            Path m9248a = new c(uVar.f7227a).m9248a();
            if (uVar.f7127o == null) {
                uVar.f7127o = m9203b(m9248a);
            }
            m9220d(uVar);
            path.setFillType(m9239s());
            path.addPath(m9248a, matrix);
        }
    }

    /* renamed from: a */
    private void m9176a(C1088h.k kVar, Path path, Matrix matrix) {
        Path m9216c;
        m9188a(this.f7246d, kVar);
        if (m9233m() && m9234n()) {
            if (kVar.f7199e != null) {
                matrix.preConcat(kVar.f7199e);
            }
            if (kVar instanceof C1088h.aa) {
                m9216c = m9199b((C1088h.aa) kVar);
            } else if (kVar instanceof C1088h.c) {
                m9216c = m9201b((C1088h.c) kVar);
            } else if (kVar instanceof C1088h.h) {
                m9216c = m9202b((C1088h.h) kVar);
            } else if (kVar instanceof C1088h.y) {
                m9216c = m9216c((C1088h.y) kVar);
            } else {
                return;
            }
            m9220d(kVar);
            path.setFillType(m9239s());
            path.addPath(m9216c, matrix);
        }
    }

    /* renamed from: a */
    private void m9171a(C1088h.bd bdVar, Path path, Matrix matrix) {
        m9188a(this.f7246d, bdVar);
        if (m9233m() && m9234n()) {
            if (bdVar.f7200b != null) {
                matrix.preConcat(bdVar.f7200b);
            }
            C1088h.am m9082b = bdVar.f7137u.m9082b(bdVar.f7173a);
            if (m9082b == null) {
                m9224e("Use reference '%s' not found", bdVar.f7173a);
            } else {
                m9220d(bdVar);
                m9161a(m9082b, false, path, matrix);
            }
        }
    }

    /* renamed from: a */
    private void m9166a(C1088h.av avVar, Path path, Matrix matrix) {
        float f2 = 0.0f;
        m9188a(this.f7246d, avVar);
        if (m9233m()) {
            if (avVar.f7149a != null) {
                matrix.preConcat(avVar.f7149a);
            }
            float m9117a = (avVar.f7153b == null || avVar.f7153b.size() == 0) ? 0.0f : avVar.f7153b.get(0).m9117a(this);
            float m9119b = (avVar.f7154c == null || avVar.f7154c.size() == 0) ? 0.0f : avVar.f7154c.get(0).m9119b(this);
            float m9117a2 = (avVar.f7155d == null || avVar.f7155d.size() == 0) ? 0.0f : avVar.f7155d.get(0).m9117a(this);
            if (avVar.f7156e != null && avVar.f7156e.size() != 0) {
                f2 = avVar.f7156e.get(0).m9119b(this);
            }
            if (this.f7246d.f7282a.f7070u != C1088h.ad.f.Start) {
                float m9134a = m9134a((C1088h.ax) avVar);
                if (this.f7246d.f7282a.f7070u == C1088h.ad.f.Middle) {
                    m9117a -= m9134a / 2.0f;
                } else {
                    m9117a -= m9134a;
                }
            }
            if (avVar.f7127o == null) {
                h hVar = new h(m9117a, m9119b);
                m9167a((C1088h.ax) avVar, (i) hVar);
                avVar.f7127o = new C1088h.a(hVar.f7293c.left, hVar.f7293c.top, hVar.f7293c.width(), hVar.f7293c.height());
            }
            m9220d(avVar);
            Path path2 = new Path();
            m9167a((C1088h.ax) avVar, new f(m9117a + m9117a2, f2 + m9119b, path2));
            path.setFillType(m9239s());
            path.addPath(path2, matrix);
        }
    }

    /* compiled from: SVGAndroidRenderer.java */
    /* renamed from: com.d.a.i$f */
    private class f extends i {

        /* renamed from: a */
        float f7278a;

        /* renamed from: b */
        float f7279b;

        /* renamed from: c */
        Path f7280c;

        f(float f2, float f3, Path path) {
            super();
            this.f7278a = f2;
            this.f7279b = f3;
            this.f7280c = path;
        }

        @Override // com.p124d.p125a.C1089i.i
        /* renamed from: a */
        public boolean mo9250a(C1088h.ax axVar) {
            if (!(axVar instanceof C1088h.ay)) {
                return true;
            }
            C1089i.m9222d("Using <textPath> elements in a clip path is not supported.", new Object[0]);
            return false;
        }

        @Override // com.p124d.p125a.C1089i.i
        /* renamed from: a */
        public void mo9249a(String str) {
            if (C1089i.this.m9234n()) {
                Path path = new Path();
                C1089i.this.f7246d.f7285d.getTextPath(str, 0, str.length(), this.f7278a, this.f7279b, path);
                this.f7280c.addPath(path);
            }
            this.f7278a += C1089i.this.f7246d.f7285d.measureText(str);
        }
    }

    /* renamed from: c */
    private Path m9215c(C1088h.p pVar) {
        float m9117a = pVar.f7209a == null ? 0.0f : pVar.f7209a.m9117a(this);
        float m9119b = pVar.f7210b == null ? 0.0f : pVar.f7210b.m9119b(this);
        float m9117a2 = pVar.f7211c == null ? 0.0f : pVar.f7211c.m9117a(this);
        float m9119b2 = pVar.f7212d != null ? pVar.f7212d.m9119b(this) : 0.0f;
        if (pVar.f7127o == null) {
            pVar.f7127o = new C1088h.a(Math.min(m9117a, m9117a2), Math.min(m9119b, m9119b2), Math.abs(m9117a2 - m9117a), Math.abs(m9119b2 - m9119b));
        }
        Path path = new Path();
        path.moveTo(m9117a, m9119b);
        path.lineTo(m9117a2, m9119b2);
        return path;
    }

    /* renamed from: b */
    private Path m9199b(C1088h.aa aaVar) {
        float m9119b;
        float f2;
        if (aaVar.f7034f == null && aaVar.f7035g == null) {
            m9119b = 0.0f;
            f2 = 0.0f;
        } else if (aaVar.f7034f == null) {
            float m9119b2 = aaVar.f7035g.m9119b(this);
            m9119b = m9119b2;
            f2 = m9119b2;
        } else if (aaVar.f7035g == null) {
            float m9117a = aaVar.f7034f.m9117a(this);
            m9119b = m9117a;
            f2 = m9117a;
        } else {
            float m9117a2 = aaVar.f7034f.m9117a(this);
            m9119b = aaVar.f7035g.m9119b(this);
            f2 = m9117a2;
        }
        float min = Math.min(f2, aaVar.f7032c.m9117a(this) / 2.0f);
        float min2 = Math.min(m9119b, aaVar.f7033d.m9119b(this) / 2.0f);
        float m9117a3 = aaVar.f7030a != null ? aaVar.f7030a.m9117a(this) : 0.0f;
        float m9119b3 = aaVar.f7031b != null ? aaVar.f7031b.m9119b(this) : 0.0f;
        float m9117a4 = aaVar.f7032c.m9117a(this);
        float m9119b4 = aaVar.f7033d.m9119b(this);
        if (aaVar.f7127o == null) {
            aaVar.f7127o = new C1088h.a(m9117a3, m9119b3, m9117a4, m9119b4);
        }
        float f3 = m9117a3 + m9117a4;
        float f4 = m9119b3 + m9119b4;
        Path path = new Path();
        if (min == 0.0f || min2 == 0.0f) {
            path.moveTo(m9117a3, m9119b3);
            path.lineTo(f3, m9119b3);
            path.lineTo(f3, f4);
            path.lineTo(m9117a3, f4);
            path.lineTo(m9117a3, m9119b3);
        } else {
            float f5 = min * 0.5522848f;
            float f6 = min2 * 0.5522848f;
            path.moveTo(m9117a3, m9119b3 + min2);
            path.cubicTo(m9117a3, (m9119b3 + min2) - f6, (m9117a3 + min) - f5, m9119b3, m9117a3 + min, m9119b3);
            path.lineTo(f3 - min, m9119b3);
            path.cubicTo((f3 - min) + f5, m9119b3, f3, (m9119b3 + min2) - f6, f3, m9119b3 + min2);
            path.lineTo(f3, f4 - min2);
            path.cubicTo(f3, (f4 - min2) + f6, (f3 - min) + f5, f4, f3 - min, f4);
            path.lineTo(m9117a3 + min, f4);
            path.cubicTo((m9117a3 + min) - f5, f4, m9117a3, (f4 - min2) + f6, m9117a3, f4 - min2);
            path.lineTo(m9117a3, m9119b3 + min2);
        }
        path.close();
        return path;
    }

    /* renamed from: b */
    private Path m9201b(C1088h.c cVar) {
        float m9117a = cVar.f7178a != null ? cVar.f7178a.m9117a(this) : 0.0f;
        float m9119b = cVar.f7179b != null ? cVar.f7179b.m9119b(this) : 0.0f;
        float m9121c = cVar.f7180c.m9121c(this);
        float f2 = m9117a - m9121c;
        float f3 = m9119b - m9121c;
        float f4 = m9117a + m9121c;
        float f5 = m9119b + m9121c;
        if (cVar.f7127o == null) {
            cVar.f7127o = new C1088h.a(f2, f3, 2.0f * m9121c, 2.0f * m9121c);
        }
        float f6 = m9121c * 0.5522848f;
        Path path = new Path();
        path.moveTo(m9117a, f3);
        path.cubicTo(m9117a + f6, f3, f4, m9119b - f6, f4, m9119b);
        path.cubicTo(f4, m9119b + f6, m9117a + f6, f5, m9117a, f5);
        path.cubicTo(m9117a - f6, f5, f2, m9119b + f6, f2, m9119b);
        path.cubicTo(f2, m9119b - f6, m9117a - f6, f3, m9117a, f3);
        path.close();
        return path;
    }

    /* renamed from: b */
    private Path m9202b(C1088h.h hVar) {
        float m9117a = hVar.f7186a != null ? hVar.f7186a.m9117a(this) : 0.0f;
        float m9119b = hVar.f7187b != null ? hVar.f7187b.m9119b(this) : 0.0f;
        float m9117a2 = hVar.f7188c.m9117a(this);
        float m9119b2 = hVar.f7189d.m9119b(this);
        float f2 = m9117a - m9117a2;
        float f3 = m9119b - m9119b2;
        float f4 = m9117a + m9117a2;
        float f5 = m9119b + m9119b2;
        if (hVar.f7127o == null) {
            hVar.f7127o = new C1088h.a(f2, f3, 2.0f * m9117a2, 2.0f * m9119b2);
        }
        float f6 = m9117a2 * 0.5522848f;
        float f7 = m9119b2 * 0.5522848f;
        Path path = new Path();
        path.moveTo(m9117a, f3);
        path.cubicTo(m9117a + f6, f3, f4, m9119b - f7, f4, m9119b);
        path.cubicTo(f4, m9119b + f7, m9117a + f6, f5, m9117a, f5);
        path.cubicTo(m9117a - f6, f5, f2, m9119b + f7, f2, m9119b);
        path.cubicTo(f2, m9119b - f7, m9117a - f6, f3, m9117a, f3);
        path.close();
        return path;
    }

    /* renamed from: c */
    private Path m9216c(C1088h.y yVar) {
        Path path = new Path();
        path.moveTo(yVar.f7241a[0], yVar.f7241a[1]);
        for (int i2 = 2; i2 < yVar.f7241a.length; i2 += 2) {
            path.lineTo(yVar.f7241a[i2], yVar.f7241a[i2 + 1]);
        }
        if (yVar instanceof C1088h.z) {
            path.close();
        }
        if (yVar.f7127o == null) {
            yVar.f7127o = m9203b(path);
        }
        return path;
    }

    /* renamed from: b */
    private Path m9200b(C1088h.av avVar) {
        float f2 = 0.0f;
        float m9117a = (avVar.f7153b == null || avVar.f7153b.size() == 0) ? 0.0f : avVar.f7153b.get(0).m9117a(this);
        float m9119b = (avVar.f7154c == null || avVar.f7154c.size() == 0) ? 0.0f : avVar.f7154c.get(0).m9119b(this);
        float m9117a2 = (avVar.f7155d == null || avVar.f7155d.size() == 0) ? 0.0f : avVar.f7155d.get(0).m9117a(this);
        if (avVar.f7156e != null && avVar.f7156e.size() != 0) {
            f2 = avVar.f7156e.get(0).m9119b(this);
        }
        if (this.f7246d.f7282a.f7070u != C1088h.ad.f.Start) {
            float m9134a = m9134a((C1088h.ax) avVar);
            if (this.f7246d.f7282a.f7070u == C1088h.ad.f.Middle) {
                m9117a -= m9134a / 2.0f;
            } else {
                m9117a -= m9134a;
            }
        }
        if (avVar.f7127o == null) {
            h hVar = new h(m9117a, m9119b);
            m9167a((C1088h.ax) avVar, (i) hVar);
            avVar.f7127o = new C1088h.a(hVar.f7293c.left, hVar.f7293c.top, hVar.f7293c.width(), hVar.f7293c.height());
        }
        Path path = new Path();
        m9167a((C1088h.ax) avVar, new f(m9117a + m9117a2, f2 + m9119b, path));
        return path;
    }

    /* renamed from: a */
    private void m9156a(C1088h.aj ajVar, Path path, C1088h.x xVar) {
        float f2;
        float f3;
        float f4;
        float f5;
        boolean z = xVar.f7233a != null && xVar.f7233a.booleanValue();
        if (xVar.f7240h != null) {
            m9184a(xVar, xVar.f7240h);
        }
        if (z) {
            float m9117a = xVar.f7236d != null ? xVar.f7236d.m9117a(this) : 0.0f;
            float m9119b = xVar.f7237e != null ? xVar.f7237e.m9119b(this) : 0.0f;
            float m9117a2 = xVar.f7238f != null ? xVar.f7238f.m9117a(this) : 0.0f;
            f2 = xVar.f7239g != null ? xVar.f7239g.m9119b(this) : 0.0f;
            f3 = m9117a2;
            f4 = m9119b;
            f5 = m9117a;
        } else {
            float m9118a = xVar.f7236d != null ? xVar.f7236d.m9118a(this, 1.0f) : 0.0f;
            float m9118a2 = xVar.f7237e != null ? xVar.f7237e.m9118a(this, 1.0f) : 0.0f;
            float m9118a3 = xVar.f7238f != null ? xVar.f7238f.m9118a(this, 1.0f) : 0.0f;
            float m9118a4 = xVar.f7239g != null ? xVar.f7239g.m9118a(this, 1.0f) : 0.0f;
            float f6 = (m9118a * ajVar.f7127o.f7028c) + ajVar.f7127o.f7026a;
            float f7 = (m9118a2 * ajVar.f7127o.f7029d) + ajVar.f7127o.f7027b;
            float f8 = m9118a3 * ajVar.f7127o.f7028c;
            f2 = m9118a4 * ajVar.f7127o.f7029d;
            f3 = f8;
            f4 = f7;
            f5 = f6;
        }
        if (f3 != 0.0f && f2 != 0.0f) {
            C1086f c1086f = xVar.f7139w != null ? xVar.f7139w : C1086f.f6988c;
            m9225f();
            this.f7243a.clipPath(path);
            g gVar = new g();
            m9187a(gVar, C1088h.ad.m9097a());
            gVar.f7282a.f7071v = false;
            this.f7246d = m9143a(xVar, gVar);
            C1088h.a aVar = ajVar.f7127o;
            if (xVar.f7235c != null) {
                this.f7243a.concat(xVar.f7235c);
                Matrix matrix = new Matrix();
                if (xVar.f7235c.invert(matrix)) {
                    float[] fArr = {ajVar.f7127o.f7026a, ajVar.f7127o.f7027b, ajVar.f7127o.m9091a(), ajVar.f7127o.f7027b, ajVar.f7127o.m9091a(), ajVar.f7127o.m9093b(), ajVar.f7127o.f7026a, ajVar.f7127o.m9093b()};
                    matrix.mapPoints(fArr);
                    RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
                    for (int i2 = 2; i2 <= 6; i2 += 2) {
                        if (fArr[i2] < rectF.left) {
                            rectF.left = fArr[i2];
                        }
                        if (fArr[i2] > rectF.right) {
                            rectF.right = fArr[i2];
                        }
                        if (fArr[i2 + 1] < rectF.top) {
                            rectF.top = fArr[i2 + 1];
                        }
                        if (fArr[i2 + 1] > rectF.bottom) {
                            rectF.bottom = fArr[i2 + 1];
                        }
                    }
                    aVar = new C1088h.a(rectF.left, rectF.top, rectF.right - rectF.left, rectF.bottom - rectF.top);
                }
            }
            float floor = f5 + (((float) Math.floor((aVar.f7026a - f5) / f3)) * f3);
            float floor2 = (((float) Math.floor((aVar.f7027b - f4) / f2)) * f2) + f4;
            float m9091a = aVar.m9091a();
            float m9093b = aVar.m9093b();
            C1088h.a aVar2 = new C1088h.a(0.0f, 0.0f, f3, f2);
            boolean m9229i = m9229i();
            for (float f9 = floor2; f9 < m9093b; f9 += f2) {
                for (float f10 = floor; f10 < m9091a; f10 += f3) {
                    aVar2.f7026a = f10;
                    aVar2.f7027b = f9;
                    m9225f();
                    if (!this.f7246d.f7282a.f7071v.booleanValue()) {
                        m9145a(aVar2.f7026a, aVar2.f7027b, aVar2.f7028c, aVar2.f7029d);
                    }
                    if (xVar.f7145x != null) {
                        this.f7243a.concat(m9138a(aVar2, xVar.f7145x, c1086f));
                    } else {
                        boolean z2 = xVar.f7234b == null || xVar.f7234b.booleanValue();
                        this.f7243a.translate(f10, f9);
                        if (!z2) {
                            this.f7243a.scale(ajVar.f7127o.f7028c, ajVar.f7127o.f7029d);
                        }
                    }
                    Iterator<C1088h.am> it = xVar.f7116i.iterator();
                    while (it.hasNext()) {
                        m9159a(it.next());
                    }
                    m9227g();
                }
            }
            if (m9229i) {
                m9208b((C1088h.aj) xVar);
            }
            m9227g();
        }
    }

    /* renamed from: a */
    private void m9184a(C1088h.x xVar, String str) {
        C1088h.am m9082b = xVar.f7137u.m9082b(str);
        if (m9082b == null) {
            m9222d("Pattern reference '%s' not found", str);
            return;
        }
        if (!(m9082b instanceof C1088h.x)) {
            m9224e("Pattern href attributes must point to other pattern elements", new Object[0]);
            return;
        }
        if (m9082b == xVar) {
            m9224e("Circular reference in pattern href attribute '%s'", str);
            return;
        }
        C1088h.x xVar2 = (C1088h.x) m9082b;
        if (xVar.f7233a == null) {
            xVar.f7233a = xVar2.f7233a;
        }
        if (xVar.f7234b == null) {
            xVar.f7234b = xVar2.f7234b;
        }
        if (xVar.f7235c == null) {
            xVar.f7235c = xVar2.f7235c;
        }
        if (xVar.f7236d == null) {
            xVar.f7236d = xVar2.f7236d;
        }
        if (xVar.f7237e == null) {
            xVar.f7237e = xVar2.f7237e;
        }
        if (xVar.f7238f == null) {
            xVar.f7238f = xVar2.f7238f;
        }
        if (xVar.f7239g == null) {
            xVar.f7239g = xVar2.f7239g;
        }
        if (xVar.f7116i.isEmpty()) {
            xVar.f7116i = xVar2.f7116i;
        }
        if (xVar.f7145x == null) {
            xVar.f7145x = xVar2.f7145x;
        }
        if (xVar.f7139w == null) {
            xVar.f7139w = xVar2.f7139w;
        }
        if (xVar2.f7240h != null) {
            m9184a(xVar, xVar2.f7240h);
        }
    }

    /* renamed from: a */
    private void m9181a(C1088h.r rVar, C1088h.aj ajVar, C1088h.a aVar) {
        float f2;
        float f3;
        m9226f("Mask render", new Object[0]);
        if (rVar.f7219a != null && rVar.f7219a.booleanValue()) {
            f2 = rVar.f7223e != null ? rVar.f7223e.m9117a(this) : aVar.f7028c;
            f3 = rVar.f7224f != null ? rVar.f7224f.m9119b(this) : aVar.f7029d;
        } else {
            float m9118a = rVar.f7223e != null ? rVar.f7223e.m9118a(this, 1.0f) : 1.2f;
            float m9118a2 = rVar.f7224f != null ? rVar.f7224f.m9118a(this, 1.0f) : 1.2f;
            f2 = m9118a * aVar.f7028c;
            f3 = m9118a2 * aVar.f7029d;
        }
        if (f2 != 0.0f && f3 != 0.0f) {
            m9225f();
            this.f7246d = m9217c((C1088h.am) rVar);
            this.f7246d.f7282a.f7062m = Float.valueOf(1.0f);
            boolean m9229i = m9229i();
            this.f7243a.save();
            if (!(rVar.f7220b == null || rVar.f7220b.booleanValue())) {
                this.f7243a.translate(aVar.f7026a, aVar.f7027b);
                this.f7243a.scale(aVar.f7028c, aVar.f7029d);
            }
            m9153a((C1088h.ai) rVar, false);
            this.f7243a.restore();
            if (m9229i) {
                m9157a(ajVar, aVar);
            }
            m9227g();
        }
    }
}
