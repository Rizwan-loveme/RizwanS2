package ru.maximoff.apktool.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.srizwan.apktool.R;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

/* compiled from: ScreenCapture.java */
/* renamed from: ru.maximoff.apktool.util.bb */
/* loaded from: classes.dex */
public class C3100bb {

    /* renamed from: a */
    private final Context f18239a;

    /* renamed from: b */
    private final MediaProjection f18240b;

    /* renamed from: d */
    private ImageReader f18242d;

    /* renamed from: e */
    private VirtualDisplay f18243e;

    /* renamed from: f */
    private Bitmap f18244f;

    /* renamed from: g */
    private int[] f18245g;

    /* renamed from: h */
    private boolean f18246h;

    /* renamed from: i */
    private HandlerThread f18247i;

    /* renamed from: j */
    private Handler f18248j;

    /* renamed from: k */
    private a f18249k;

    /* renamed from: l */
    private int f18250l;

    /* renamed from: m */
    private int f18251m;

    /* renamed from: n */
    private int f18252n;

    /* renamed from: o */
    private final ImageReader.OnImageAvailableListener f18253o = new ImageReader.OnImageAvailableListener(this) { // from class: ru.maximoff.apktool.util.bb.1

        /* renamed from: a */
        private final C3100bb f18254a;

        {
            this.f18254a = this;
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader imageReader) {
            Image acquireLatestImage;
            if (!this.f18254a.f18246h && (acquireLatestImage = imageReader.acquireLatestImage()) != null) {
                try {
                    this.f18254a.m18887a(acquireLatestImage);
                } catch (Exception e2) {
                } catch (Throwable th) {
                    acquireLatestImage.close();
                    throw th;
                }
                acquireLatestImage.close();
            }
        }
    };

    /* renamed from: c */
    private final Handler f18241c = new Handler(Looper.getMainLooper());

    /* compiled from: ScreenCapture.java */
    /* renamed from: ru.maximoff.apktool.util.bb$a */
    public interface a {
        /* renamed from: a */
        void mo16449a(Bitmap bitmap, int[] iArr);
    }

    public C3100bb(Context context, MediaProjection mediaProjection) {
        this.f18239a = context.getApplicationContext();
        this.f18240b = mediaProjection;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRealMetrics(displayMetrics);
        this.f18250l = displayMetrics.widthPixels;
        this.f18251m = displayMetrics.heightPixels;
        this.f18252n = displayMetrics.densityDpi;
        this.f18245g = new int[this.f18250l * this.f18251m];
    }

    /* renamed from: a */
    public void m18893a(a aVar) {
        this.f18249k = aVar;
    }

    /* renamed from: a */
    public void m18892a() {
        String string = this.f18239a.getString(R.string.color_pipette);
        this.f18246h = false;
        this.f18247i = new HandlerThread(string);
        this.f18247i.start();
        this.f18248j = new Handler(this.f18247i.getLooper());
        this.f18242d = ImageReader.newInstance(this.f18250l, this.f18251m, 1, 2);
        this.f18243e = this.f18240b.createVirtualDisplay(string, this.f18250l, this.f18251m, this.f18252n, 16, this.f18242d.getSurface(), (VirtualDisplay.Callback) null, this.f18248j);
        this.f18242d.setOnImageAvailableListener(this.f18253o, this.f18248j);
    }

    /* renamed from: b */
    public void m18894b() {
        this.f18246h = true;
        if (this.f18242d != null) {
            this.f18242d.setOnImageAvailableListener((ImageReader.OnImageAvailableListener) null, (Handler) null);
        }
        if (this.f18243e != null) {
            this.f18243e.release();
            this.f18243e = (VirtualDisplay) null;
        }
        if (this.f18240b != null) {
            this.f18240b.stop();
        }
        if (this.f18247i != null) {
            this.f18247i.quitSafely();
            this.f18247i = (HandlerThread) null;
        }
        if (this.f18248j != null) {
            this.f18248j.removeCallbacksAndMessages((Object) null);
            this.f18248j = (Handler) null;
        }
        if (this.f18244f != null) {
            this.f18244f.recycle();
            this.f18244f = (Bitmap) null;
        }
        this.f18245g = (int[]) null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m18887a(Image image) {
        if (!this.f18246h && this.f18245g != null) {
            Image.Plane plane = image.getPlanes()[0];
            ByteBuffer buffer = plane.getBuffer();
            int pixelStride = plane.getPixelStride();
            int rowStride = plane.getRowStride();
            if (pixelStride == 4) {
                if (this.f18244f == null || this.f18244f.isRecycled()) {
                    this.f18244f = Bitmap.createBitmap(this.f18250l, this.f18251m, Bitmap.Config.ARGB_8888);
                }
                IntBuffer asIntBuffer = buffer.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
                int i = rowStride / 4;
                for (int i2 = 0; i2 < this.f18251m; i2++) {
                    asIntBuffer.position(i2 * i);
                    int i3 = i2 * this.f18250l;
                    asIntBuffer.get(this.f18245g, i3, this.f18250l);
                    for (int i4 = 0; i4 < this.f18250l; i4++) {
                        int i5 = this.f18245g[i3 + i4];
                        this.f18245g[i3 + i4] = ((i5 & 255) << 16) | ((-16711936) & i5) | ((16711680 & i5) >> 16);
                    }
                }
                if (!this.f18246h && this.f18244f != null && !this.f18244f.isRecycled()) {
                    this.f18244f.setPixels(this.f18245g, 0, this.f18250l, 0, 0, this.f18250l, this.f18251m);
                    if (this.f18249k != null) {
                        this.f18241c.post(new Runnable(this) { // from class: ru.maximoff.apktool.util.bb.2

                            /* renamed from: a */
                            private final C3100bb f18255a;

                            {
                                this.f18255a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                this.f18255a.f18249k.mo16449a(this.f18255a.f18244f, this.f18255a.f18245g);
                            }
                        });
                    }
                }
            }
        }
    }
}
