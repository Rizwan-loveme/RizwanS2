package ru.maximoff.apktool.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.srizwan.apktool.R;

/* compiled from: IconFactory.java */
/* renamed from: ru.maximoff.apktool.util.aa */
/* loaded from: classes.dex */
public class C3066aa {

    /* renamed from: a */
    private int f17231a;

    /* renamed from: b */
    private int f17232b;

    /* renamed from: c */
    private float f17233c;

    /* renamed from: d */
    private Context f17234d;

    /* renamed from: g */
    private int f17237g;

    /* renamed from: h */
    private int f17238h;

    /* renamed from: i */
    private final Paint f17239i = new Paint(1);

    /* renamed from: j */
    private final Paint f17240j = new Paint(1);

    /* renamed from: k */
    private final RectF f17241k = new RectF();

    /* renamed from: e */
    private int f17235e = 0;

    /* renamed from: f */
    private int f17236f = Color.DKGRAY;

    public C3066aa(Context context) {
        this.f17231a = 48;
        this.f17232b = 24;
        this.f17231a = C3080al.m18574b(context, 36);
        this.f17232b = this.f17231a / 2;
        this.f17234d = context;
        this.f17233c = context.getResources().getDisplayMetrics().density;
        this.f17239i.setStyle(Paint.Style.FILL);
        this.f17240j.setStyle(Paint.Style.FILL);
        switch (C3102bd.f18319b) {
            case 1:
                this.f17238h = C3246h.m19470a(context, R.color.drawerScrim);
                this.f17237g = 200;
                break;
            case 2:
                this.f17238h = C3246h.m19470a(context, R.color.ic_outline_color_dark);
                this.f17237g = 255;
                break;
            default:
                this.f17237g = 255;
                this.f17238h = C3246h.m19470a(context, R.color.drawerScrim);
                break;
        }
    }

    /* renamed from: a */
    public Bitmap m18363a(int i, int i2) {
        this.f17236f = i;
        return m18364a(C3067ab.m18379a(this.f17234d, i2, this.f17235e), this.f17231a, this.f17232b, 0);
    }

    /* renamed from: a */
    public Bitmap m18364a(Drawable drawable, int i, int i2, int i3) {
        float f2 = (i / 7.0f) * this.f17233c;
        int i4 = (int) (i * this.f17233c);
        int i5 = (int) (i2 * this.f17233c);
        int i6 = (int) ((i3 * this.f17233c) + (f2 / 2.0f));
        int i7 = (i6 * 2) + i4;
        Bitmap createBitmap = Bitmap.createBitmap(i7, i7, Bitmap.Config.ARGB_8888);
        createBitmap.setHasAlpha(true);
        createBitmap.eraseColor(0);
        Canvas canvas = new Canvas(createBitmap);
        int i8 = (i7 - i5) / 2;
        drawable.setAlpha(this.f17237g);
        drawable.setBounds(i8, i8, i8 + i5, i5 + i8);
        if (this.f17236f != 0) {
            this.f17240j.setColor(m18361b(this.f17238h, 100));
            this.f17240j.setMaskFilter(new BlurMaskFilter(f2 / 2.0f, BlurMaskFilter.Blur.NORMAL));
            m18360a(canvas, i7, i4, i6);
        }
        this.f17239i.setColor(this.f17236f);
        m18362b(canvas, i7, i4, i6);
        drawable.draw(canvas);
        return createBitmap;
    }

    /* renamed from: a */
    private void m18360a(Canvas canvas, int i, int i2, int i3) {
        if (C3102bd.f18270F) {
            int i4 = i / 2;
            canvas.drawCircle(i4, i4, i4 - i3, this.f17240j);
        } else {
            float f2 = i2 / 5.0f;
            this.f17241k.set(i3, i3, i - i3, i - i3);
            canvas.drawRoundRect(this.f17241k, f2, f2, this.f17240j);
        }
    }

    /* renamed from: b */
    private void m18362b(Canvas canvas, int i, int i2, int i3) {
        if (C3102bd.f18270F) {
            int i4 = i / 2;
            canvas.drawCircle(i4, i4, i4 - i3, this.f17239i);
        } else {
            float f2 = i2 / 5.0f;
            this.f17241k.set(i3, i3, i - i3, i - i3);
            canvas.drawRoundRect(this.f17241k, f2, f2, this.f17239i);
        }
    }

    /* renamed from: b */
    private int m18361b(int i, int i2) {
        return Color.argb(i2, Color.red(i), Color.green(i), Color.blue(i));
    }
}
