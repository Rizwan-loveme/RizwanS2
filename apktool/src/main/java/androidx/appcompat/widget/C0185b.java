package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* compiled from: ActionBarBackgroundDrawable.java */
/* renamed from: androidx.appcompat.widget.b */
/* loaded from: classes.dex */
class C0185b extends Drawable {

    /* renamed from: a */
    final ActionBarContainer f1592a;

    public C0185b(ActionBarContainer actionBarContainer) {
        this.f1592a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f1592a.f1114d) {
            if (this.f1592a.f1113c != null) {
                this.f1592a.f1113c.draw(canvas);
            }
        } else {
            if (this.f1592a.f1111a != null) {
                this.f1592a.f1111a.draw(canvas);
            }
            if (this.f1592a.f1112b != null && this.f1592a.f1115e) {
                this.f1592a.f1112b.draw(canvas);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f1592a.f1114d) {
            if (this.f1592a.f1113c != null) {
                this.f1592a.f1113c.getOutline(outline);
            }
        } else if (this.f1592a.f1111a != null) {
            this.f1592a.f1111a.getOutline(outline);
        }
    }
}
