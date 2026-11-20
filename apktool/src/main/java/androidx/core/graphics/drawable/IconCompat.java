package androidx.core.graphics.drawable;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.p008os.Build;
import android.p008os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.p209io.ByteArrayOutputStream;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.p209io.FileNotFoundException;
import java.p209io.InputStream;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: h */
    static final PorterDuff.Mode f2247h = PorterDuff.Mode.SRC_IN;

    /* renamed from: a */
    public int f2248a;

    /* renamed from: b */
    Object f2249b;

    /* renamed from: c */
    public byte[] f2250c;

    /* renamed from: d */
    public Parcelable f2251d;

    /* renamed from: e */
    public int f2252e;

    /* renamed from: f */
    public int f2253f;

    /* renamed from: g */
    public ColorStateList f2254g;

    /* renamed from: i */
    PorterDuff.Mode f2255i;

    /* renamed from: j */
    public String f2256j;

    /* renamed from: k */
    public String f2257k;

    /* renamed from: a */
    public static IconCompat m2341a(Resources resources, String str, int i) {
        if (str == null) {
            throw new IllegalArgumentException("Package must not be null.");
        }
        if (i == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f2252e = i;
        if (resources != null) {
            try {
                iconCompat.f2249b = resources.getResourceName(i);
            } catch (Resources.NotFoundException e2) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f2249b = str;
        }
        iconCompat.f2257k = str;
        return iconCompat;
    }

    public IconCompat() {
        this.f2248a = -1;
        this.f2250c = null;
        this.f2251d = null;
        this.f2252e = 0;
        this.f2253f = 0;
        this.f2254g = null;
        this.f2255i = f2247h;
        this.f2256j = null;
    }

    private IconCompat(int i) {
        this.f2248a = -1;
        this.f2250c = null;
        this.f2251d = null;
        this.f2252e = 0;
        this.f2253f = 0;
        this.f2254g = null;
        this.f2255i = f2247h;
        this.f2256j = null;
        this.f2248a = i;
    }

    /* renamed from: a */
    public int m2346a() {
        return (this.f2248a != -1 || Build.VERSION.SDK_INT < 23) ? this.f2248a : m2339a((Icon) this.f2249b);
    }

    /* renamed from: b */
    public String m2350b() {
        if (this.f2248a == -1 && Build.VERSION.SDK_INT >= 23) {
            return m2343b((Icon) this.f2249b);
        }
        if (this.f2248a != 2) {
            throw new IllegalStateException("called getResPackage() on " + this);
        }
        if (TextUtils.isEmpty(this.f2257k)) {
            return ((String) this.f2249b).split(":", -1)[0];
        }
        return this.f2257k;
    }

    /* renamed from: c */
    public int m2351c() {
        if (this.f2248a == -1 && Build.VERSION.SDK_INT >= 23) {
            return m2344c((Icon) this.f2249b);
        }
        if (this.f2248a != 2) {
            throw new IllegalStateException("called getResId() on " + this);
        }
        return this.f2252e;
    }

    /* renamed from: d */
    public Uri m2352d() {
        if (this.f2248a == -1 && Build.VERSION.SDK_INT >= 23) {
            return m2345d((Icon) this.f2249b);
        }
        if (this.f2248a != 4 && this.f2248a != 6) {
            throw new IllegalStateException("called getUri() on " + this);
        }
        return Uri.parse((String) this.f2249b);
    }

    @Deprecated
    /* renamed from: e */
    public Icon m2353e() {
        return m2347a((Context) null);
    }

    /* renamed from: a */
    public Icon m2347a(Context context) {
        Icon createWithBitmap;
        switch (this.f2248a) {
            case -1:
                return (Icon) this.f2249b;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                createWithBitmap = Icon.createWithBitmap((Bitmap) this.f2249b);
                break;
            case 2:
                createWithBitmap = Icon.createWithResource(m2350b(), this.f2252e);
                break;
            case 3:
                createWithBitmap = Icon.createWithData((byte[]) this.f2249b, this.f2252e, this.f2253f);
                break;
            case 4:
                createWithBitmap = Icon.createWithContentUri((String) this.f2249b);
                break;
            case 5:
                if (Build.VERSION.SDK_INT >= 26) {
                    createWithBitmap = Icon.createWithAdaptiveBitmap((Bitmap) this.f2249b);
                    break;
                } else {
                    createWithBitmap = Icon.createWithBitmap(m2340a((Bitmap) this.f2249b, false));
                    break;
                }
            case 6:
                if (Build.VERSION.SDK_INT >= 30) {
                    createWithBitmap = Icon.createWithAdaptiveBitmapContentUri(m2352d());
                    break;
                } else {
                    if (context == null) {
                        throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + m2352d());
                    }
                    InputStream m2349b = m2349b(context);
                    if (m2349b == null) {
                        throw new IllegalStateException("Cannot load adaptive icon from uri: " + m2352d());
                    }
                    if (Build.VERSION.SDK_INT >= 26) {
                        createWithBitmap = Icon.createWithAdaptiveBitmap(BitmapFactory.decodeStream(m2349b));
                        break;
                    } else {
                        createWithBitmap = Icon.createWithBitmap(m2340a(BitmapFactory.decodeStream(m2349b), false));
                        break;
                    }
                }
        }
        if (this.f2254g != null) {
            createWithBitmap.setTintList(this.f2254g);
        }
        if (this.f2255i != f2247h) {
            createWithBitmap.setTintMode(this.f2255i);
            return createWithBitmap;
        }
        return createWithBitmap;
    }

    /* renamed from: b */
    public InputStream m2349b(Context context) {
        Uri m2352d = m2352d();
        String scheme = m2352d.getScheme();
        if (ContentResolver.SCHEME_CONTENT.equals(scheme) || ContentResolver.SCHEME_FILE.equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(m2352d);
            } catch (Exception e2) {
                Log.m191w("IconCompat", "Unable to load image from URI: " + m2352d, e2);
            }
        } else {
            try {
                return new FileInputStream(new File((String) this.f2249b));
            } catch (FileNotFoundException e3) {
                Log.m191w("IconCompat", "Unable to load image from path: " + m2352d, e3);
            }
        }
        return null;
    }

    public String toString() {
        if (this.f2248a == -1) {
            return String.valueOf(this.f2249b);
        }
        StringBuilder append = new StringBuilder("Icon(typ=").append(m2342a(this.f2248a));
        switch (this.f2248a) {
            case 1:
            case 5:
                append.append(" size=").append(((Bitmap) this.f2249b).getWidth()).append("x").append(((Bitmap) this.f2249b).getHeight());
                break;
            case 2:
                append.append(" pkg=").append(this.f2257k).append(" id=").append(String.format("0x%08x", Integer.valueOf(m2351c())));
                break;
            case 3:
                append.append(" len=").append(this.f2252e);
                if (this.f2253f != 0) {
                    append.append(" off=").append(this.f2253f);
                    break;
                }
                break;
            case 4:
            case 6:
                append.append(" uri=").append(this.f2249b);
                break;
        }
        if (this.f2254g != null) {
            append.append(" tint=");
            append.append(this.f2254g);
        }
        if (this.f2255i != f2247h) {
            append.append(" mode=").append(this.f2255i);
        }
        append.append(")");
        return append.toString();
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    /* renamed from: a */
    public void mo2348a(boolean z) {
        this.f2256j = this.f2255i.name();
        switch (this.f2248a) {
            case -1:
                if (z) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.f2251d = (Parcelable) this.f2249b;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (z) {
                    Bitmap bitmap = (Bitmap) this.f2249b;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f2250c = byteArrayOutputStream.toByteArray();
                    return;
                }
                this.f2251d = (Parcelable) this.f2249b;
                return;
            case 2:
                this.f2250c = ((String) this.f2249b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f2250c = (byte[]) this.f2249b;
                return;
            case 4:
            case 6:
                this.f2250c = this.f2249b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    /* renamed from: f */
    public void mo2354f() {
        this.f2255i = PorterDuff.Mode.valueOf(this.f2256j);
        switch (this.f2248a) {
            case -1:
                if (this.f2251d != null) {
                    this.f2249b = this.f2251d;
                    return;
                }
                throw new IllegalArgumentException("Invalid icon");
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (this.f2251d != null) {
                    this.f2249b = this.f2251d;
                    return;
                }
                this.f2249b = this.f2250c;
                this.f2248a = 3;
                this.f2252e = 0;
                this.f2253f = this.f2250c.length;
                return;
            case 2:
            case 4:
            case 6:
                this.f2249b = new String(this.f2250c, Charset.forName("UTF-16"));
                if (this.f2248a == 2 && this.f2257k == null) {
                    this.f2257k = ((String) this.f2249b).split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f2249b = this.f2250c;
                return;
        }
    }

    /* renamed from: a */
    private static String m2342a(int i) {
        switch (i) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    /* renamed from: a */
    private static int m2339a(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getType();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getType", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e2) {
            Log.m185e("IconCompat", "Unable to get icon type " + icon, e2);
            return -1;
        } catch (NoSuchMethodException e3) {
            Log.m185e("IconCompat", "Unable to get icon type " + icon, e3);
            return -1;
        } catch (InvocationTargetException e4) {
            Log.m185e("IconCompat", "Unable to get icon type " + icon, e4);
            return -1;
        }
    }

    /* renamed from: b */
    private static String m2343b(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e2) {
            Log.m185e("IconCompat", "Unable to get icon package", e2);
            return null;
        } catch (NoSuchMethodException e3) {
            Log.m185e("IconCompat", "Unable to get icon package", e3);
            return null;
        } catch (InvocationTargetException e4) {
            Log.m185e("IconCompat", "Unable to get icon package", e4);
            return null;
        }
    }

    /* renamed from: c */
    private static int m2344c(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e2) {
            Log.m185e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (NoSuchMethodException e3) {
            Log.m185e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        } catch (InvocationTargetException e4) {
            Log.m185e("IconCompat", "Unable to get icon resource", e4);
            return 0;
        }
    }

    /* renamed from: d */
    private static Uri m2345d(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getUri();
        }
        try {
            return (Uri) icon.getClass().getMethod("getUri", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e2) {
            Log.m185e("IconCompat", "Unable to get icon uri", e2);
            return null;
        } catch (NoSuchMethodException e3) {
            Log.m185e("IconCompat", "Unable to get icon uri", e3);
            return null;
        } catch (InvocationTargetException e4) {
            Log.m185e("IconCompat", "Unable to get icon uri", e4);
            return null;
        }
    }

    /* renamed from: a */
    static Bitmap m2340a(Bitmap bitmap, boolean z) {
        int min = (int) (0.6666667f * Math.min(bitmap.getWidth(), bitmap.getHeight()));
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f2 = min * 0.5f;
        float f3 = 0.9166667f * f2;
        if (z) {
            float f4 = 0.010416667f * min;
            paint.setColor(0);
            paint.setShadowLayer(f4, 0.0f, 0.020833334f * min, 1023410176);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.setShadowLayer(f4, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2, (-(bitmap.getHeight() - min)) / 2);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f2, f2, f3, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }
}
