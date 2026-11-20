package androidx.appcompat.widget;

import android.C0012R;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.graphics.drawable.InterfaceC0317c;

/* compiled from: AppCompatProgressBarHelper.java */
/* renamed from: androidx.appcompat.widget.s */
/* loaded from: classes.dex */
class C0209s {

    /* renamed from: a */
    private static final int[] f1737a = {C0012R.attr.indeterminateDrawable, C0012R.attr.progressDrawable};

    /* renamed from: b */
    private final ProgressBar f1738b;

    /* renamed from: c */
    private Bitmap f1739c;

    C0209s(ProgressBar progressBar) {
        this.f1738b = progressBar;
    }

    /* renamed from: a */
    void mo1577a(AttributeSet attributeSet, int i) {
        C0184az m1432a = C0184az.m1432a(this.f1738b.getContext(), attributeSet, f1737a, i, 0);
        Drawable m1440b = m1432a.m1440b(0);
        if (m1440b != null) {
            this.f1738b.setIndeterminateDrawable(m1573a(m1440b));
        }
        Drawable m1440b2 = m1432a.m1440b(1);
        if (m1440b2 != null) {
            this.f1738b.setProgressDrawable(m1574a(m1440b2, false));
        }
        m1432a.m1441b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private Drawable m1574a(Drawable drawable, boolean z) {
        if (drawable instanceof InterfaceC0317c) {
            Drawable mo2371a = ((InterfaceC0317c) drawable).mo2371a();
            if (mo2371a != null) {
                ((InterfaceC0317c) drawable).mo2372a(m1574a(mo2371a, z));
            }
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i = 0; i < numberOfLayers; i++) {
                    int id = layerDrawable.getId(i);
                    drawableArr[i] = m1574a(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    layerDrawable2.setId(i2, layerDrawable.getId(i2));
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (this.f1739c == null) {
                    this.f1739c = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(m1575b());
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }

    /* renamed from: a */
    private Drawable m1573a(Drawable drawable) {
        if (drawable instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            AnimationDrawable animationDrawable2 = new AnimationDrawable();
            animationDrawable2.setOneShot(animationDrawable.isOneShot());
            for (int i = 0; i < numberOfFrames; i++) {
                Drawable m1574a = m1574a(animationDrawable.getFrame(i), true);
                m1574a.setLevel(10000);
                animationDrawable2.addFrame(m1574a, animationDrawable.getDuration(i));
            }
            animationDrawable2.setLevel(10000);
            return animationDrawable2;
        }
        return drawable;
    }

    /* renamed from: b */
    private Shape m1575b() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    /* renamed from: a */
    Bitmap m1576a() {
        return this.f1739c;
    }
}
