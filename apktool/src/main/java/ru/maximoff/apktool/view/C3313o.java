package ru.maximoff.apktool.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;

/* compiled from: TextDrawable.java */
/* renamed from: ru.maximoff.apktool.view.o */
/* loaded from: classes.dex */
public class C3313o extends ShapeDrawable {

    /* renamed from: a */
    private final Paint f21246a;

    /* renamed from: b */
    private final Paint f21247b;

    /* renamed from: c */
    private final String f21248c;

    /* renamed from: d */
    private final int f21249d;

    /* renamed from: e */
    private final RectShape f21250e;

    /* renamed from: f */
    private final int f21251f;

    /* renamed from: g */
    private final int f21252g;

    /* renamed from: h */
    private final int f21253h;

    /* renamed from: i */
    private final float f21254i;

    /* renamed from: j */
    private final int f21255j;

    /* compiled from: TextDrawable.java */
    /* renamed from: ru.maximoff.apktool.view.o$b */
    public interface b {
    }

    /* compiled from: TextDrawable.java */
    /* renamed from: ru.maximoff.apktool.view.o$c */
    public interface c {
        /* renamed from: a */
        c mo20030a(int i);

        /* renamed from: a */
        c mo20031a(Typeface typeface);

        /* renamed from: b */
        c mo20033b(int i);

        /* renamed from: b */
        d mo20034b();

        /* renamed from: c */
        c mo20037c(int i);

        /* renamed from: d */
        c mo20040d(int i);

        /* renamed from: e */
        c mo20041e(int i);
    }

    /* compiled from: TextDrawable.java */
    /* renamed from: ru.maximoff.apktool.view.o$d */
    public interface d {
        /* renamed from: a */
        c mo20029a();

        /* renamed from: a */
        C3313o mo20032a(String str, int i);

        /* renamed from: b */
        C3313o mo20035b(String str, int i);
    }

    C3313o(a aVar) {
        super(aVar.f21264i);
        this.f21250e = aVar.f21264i;
        this.f21251f = aVar.f21262g;
        this.f21252g = aVar.f21261f;
        this.f21254i = aVar.f21257b;
        this.f21248c = aVar.f21267l ? aVar.f21258c.toUpperCase() : aVar.f21258c;
        this.f21249d = aVar.f21259d;
        this.f21253h = aVar.f21265j;
        this.f21246a = new Paint();
        this.f21246a.setColor(aVar.f21256a);
        this.f21246a.setAntiAlias(true);
        this.f21246a.setFakeBoldText(aVar.f21266k);
        this.f21246a.setStyle(Paint.Style.FILL);
        this.f21246a.setTypeface(aVar.f21263h);
        this.f21246a.setTextAlign(Paint.Align.CENTER);
        this.f21246a.setStrokeWidth(aVar.f21260e);
        this.f21255j = aVar.f21260e;
        this.f21247b = new Paint();
        this.f21247b.setColor(m20016a(this.f21249d));
        this.f21247b.setStyle(Paint.Style.STROKE);
        this.f21247b.setStrokeWidth(this.f21255j);
        getPaint().setColor(this.f21249d);
    }

    /* renamed from: a */
    private int m20016a(int i) {
        return Color.rgb((int) (Color.red(i) * 0.9f), (int) (Color.green(i) * 0.9f), (int) (Color.blue(i) * 0.9f));
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Rect bounds = getBounds();
        if (this.f21255j > 0) {
            m20018a(canvas);
        }
        int save = canvas.save();
        canvas.translate(bounds.left, bounds.top);
        int width = this.f21252g < 0 ? bounds.width() : this.f21252g;
        int height = this.f21251f < 0 ? bounds.height() : this.f21251f;
        this.f21246a.setTextSize(this.f21253h < 0 ? Math.min(width, height) / 2 : this.f21253h);
        canvas.drawText(this.f21248c, width / 2, (height / 2) - ((this.f21246a.descent() + this.f21246a.ascent()) / 2), this.f21246a);
        canvas.restoreToCount(save);
    }

    /* renamed from: a */
    private void m20018a(Canvas canvas) {
        RectF rectF = new RectF(getBounds());
        rectF.inset(this.f21255j / 2, this.f21255j / 2);
        if (this.f21250e instanceof OvalShape) {
            canvas.drawOval(rectF, this.f21247b);
        } else if (this.f21250e instanceof RoundRectShape) {
            canvas.drawRoundRect(rectF, this.f21254i, this.f21254i, this.f21247b);
        } else {
            canvas.drawRect(rectF, this.f21247b);
        }
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f21246a.setAlpha(i);
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f21246a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f21252g;
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f21251f;
    }

    /* renamed from: a */
    public static d m20017a() {
        return new a();
    }

    /* compiled from: TextDrawable.java */
    /* renamed from: ru.maximoff.apktool.view.o$a */
    public static class a implements b, c, d {

        /* renamed from: b */
        public float f21257b;

        /* renamed from: c */
        private String f21258c = "";

        /* renamed from: d */
        private int f21259d = Color.GRAY;

        /* renamed from: a */
        public int f21256a = -1;

        /* renamed from: e */
        private int f21260e = 0;

        /* renamed from: f */
        private int f21261f = -1;

        /* renamed from: g */
        private int f21262g = -1;

        /* renamed from: i */
        private RectShape f21264i = new RectShape();

        /* renamed from: h */
        private Typeface f21263h = Typeface.create("sans-serif-light", 0);

        /* renamed from: j */
        private int f21265j = -1;

        /* renamed from: k */
        private boolean f21266k = false;

        /* renamed from: l */
        private boolean f21267l = false;

        a() {
        }

        @Override // ru.maximoff.apktool.view.C3313o.c
        /* renamed from: a */
        public c mo20030a(int i) {
            this.f21261f = i;
            return this;
        }

        @Override // ru.maximoff.apktool.view.C3313o.c
        /* renamed from: b */
        public c mo20033b(int i) {
            this.f21262g = i;
            return this;
        }

        @Override // ru.maximoff.apktool.view.C3313o.c
        /* renamed from: c */
        public c mo20037c(int i) {
            this.f21256a = i;
            return this;
        }

        @Override // ru.maximoff.apktool.view.C3313o.c
        /* renamed from: d */
        public c mo20040d(int i) {
            this.f21260e = i;
            return this;
        }

        @Override // ru.maximoff.apktool.view.C3313o.c
        /* renamed from: a */
        public c mo20031a(Typeface typeface) {
            this.f21263h = typeface;
            return this;
        }

        @Override // ru.maximoff.apktool.view.C3313o.c
        /* renamed from: e */
        public c mo20041e(int i) {
            this.f21265j = i;
            return this;
        }

        @Override // ru.maximoff.apktool.view.C3313o.d
        /* renamed from: a */
        public c mo20029a() {
            return this;
        }

        @Override // ru.maximoff.apktool.view.C3313o.c
        /* renamed from: b */
        public d mo20034b() {
            return this;
        }

        /* renamed from: c */
        public b m20036c() {
            this.f21264i = new RectShape();
            return this;
        }

        /* renamed from: d */
        public b m20039d() {
            this.f21264i = new OvalShape();
            return this;
        }

        @Override // ru.maximoff.apktool.view.C3313o.d
        /* renamed from: a */
        public C3313o mo20032a(String str, int i) {
            m20036c();
            return m20038c(str, i);
        }

        @Override // ru.maximoff.apktool.view.C3313o.d
        /* renamed from: b */
        public C3313o mo20035b(String str, int i) {
            m20039d();
            return m20038c(str, i);
        }

        /* renamed from: c */
        public C3313o m20038c(String str, int i) {
            this.f21259d = i;
            this.f21258c = str;
            return new C3313o(this);
        }
    }
}
