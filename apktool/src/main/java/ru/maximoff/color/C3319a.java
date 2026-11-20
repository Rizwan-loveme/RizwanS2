package ru.maximoff.color;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: AlphaPatternDrawable.java */
/* renamed from: ru.maximoff.color.a */
/* loaded from: classes.dex */
public class C3319a extends Drawable {

    /* renamed from: a */
    private int f21331a;

    /* renamed from: b */
    private Paint f21332b = new Paint();

    /* renamed from: c */
    private Paint f21333c = new Paint();

    /* renamed from: d */
    private Paint f21334d = new Paint();

    /* renamed from: e */
    private int f21335e;

    /* renamed from: f */
    private int f21336f;

    /* renamed from: g */
    private Bitmap f21337g;

    public C3319a(int i) {
        this.f21331a = 10;
        this.f21331a = i;
        this.f21333c.setColor(-1);
        this.f21334d.setColor(-3421237);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.f21337g, (Rect) null, getBounds(), this.f21332b);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        throw new UnsupportedOperationException("Alpha is not supported by this drawwable.");
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        throw new UnsupportedOperationException("ColorFilter is not supported by this drawwable.");
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int height = rect.height();
        this.f21335e = (int) Math.ceil(rect.width() / this.f21331a);
        this.f21336f = (int) Math.ceil(height / this.f21331a);
        m20081a();
    }

    /* renamed from: a */
    private void m20081a() {
        if (getBounds().width() > 0 && getBounds().height() > 0) {
            this.f21337g = Bitmap.createBitmap(getBounds().width(), getBounds().height(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.f21337g);
            Rect rect = new Rect();
            boolean z = true;
            for (int i = 0; i <= this.f21336f; i++) {
                boolean z2 = z;
                for (int i2 = 0; i2 <= this.f21335e; i2++) {
                    rect.top = this.f21331a * i;
                    rect.left = this.f21331a * i2;
                    rect.bottom = rect.top + this.f21331a;
                    rect.right = rect.left + this.f21331a;
                    canvas.drawRect(rect, z2 ? this.f21333c : this.f21334d);
                    z2 = !z2;
                }
                z = !z;
            }
        }
    }
}
