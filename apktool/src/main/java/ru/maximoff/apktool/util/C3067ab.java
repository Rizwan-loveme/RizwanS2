package ru.maximoff.apktool.util;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.p008os.Build;
import android.security.keystore.KeyProperties;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.content.C0255a;
import androidx.core.graphics.drawable.C0315a;
import androidx.p041g.p042a.p043a.C0404i;
import com.nicdahlquist.pngquant.LibPngQuant;
import com.p124d.p125a.C1088h;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.p209io.ByteArrayOutputStream;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.p209io.FileOutputStream;
import java.p209io.IOException;
import java.p209io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.p217b.p218a.p219a.C1887e;
import org.xmlpull.p291v1.XmlPullParser;
import p060c.p061a.p062a.AbstractC0549e;
import p060c.p061a.p062a.C0546b;
import p060c.p061a.p062a.C0547c;
import p060c.p061a.p062a.C0548d;

/* compiled from: IconGenerate.java */
/* renamed from: ru.maximoff.apktool.util.ab */
/* loaded from: classes.dex */
public class C3067ab {

    /* renamed from: a */
    public static final int[] f17242a = {36, 48, 72, 96, 144, 192};

    /* renamed from: b */
    public static final String[] f17243b = {"ldpi", "mdpi", "hdpi", "xhdpi", "xxhdpi", "xxxhdpi"};

    /* renamed from: a */
    public static String m18385a(int i) {
        char c2;
        if (i < 42) {
            c2 = 0;
        } else if (i < 60) {
            c2 = 1;
        } else if (i < 84) {
            c2 = 2;
        } else if (i < 120) {
            c2 = 3;
        } else if (i < 168) {
            c2 = 4;
        } else {
            c2 = 5;
        }
        return f17243b[c2];
    }

    /* renamed from: a */
    public static void m18386a(String str, Bitmap bitmap, String str2, String str3, String str4) {
        if (str2 != null || str3 != null) {
            Bitmap m18367a = m18367a(m18368a(bitmap, 192));
            for (int i = 0; i < f17242a.length; i++) {
                File file = new File(str, f17243b[i]);
                if (!file.exists()) {
                    file.mkdir();
                }
                if (str2 != null) {
                    m18384a(m18369a(m18367a, f17242a[i], f17242a[i]), new File(file, new StringBuffer().append(new StringBuffer().append(str2).append(".").toString()).append(str4).toString()), str4);
                }
                if (str3 != null) {
                    m18384a(m18399f(m18369a(m18367a, f17242a[i], f17242a[i])), new File(file, new StringBuffer().append(new StringBuffer().append(str3).append(".").toString()).append(str4).toString()), str4);
                }
            }
        }
    }

    /* renamed from: b */
    public static Bitmap m18387b(int i) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawColor(0);
        return createBitmap;
    }

    /* renamed from: a */
    public static Bitmap m18371a(Bitmap bitmap, boolean z) {
        Bitmap m18367a = m18367a(bitmap);
        if (z) {
            m18367a = m18399f(m18367a);
        }
        Bitmap m18387b = m18387b(Math.round(m18367a.getWidth() / 2) * 3);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Canvas canvas = new Canvas(m18387b);
        canvas.drawColor(0);
        canvas.drawBitmap(m18367a, r1 / 2, r1 / 2, paint);
        return m18387b;
    }

    /* renamed from: a */
    public static Bitmap m18367a(Bitmap bitmap) {
        int max = Math.max(bitmap.getWidth(), bitmap.getHeight());
        Bitmap createBitmap = Bitmap.createBitmap(max, max, Bitmap.Config.ARGB_8888);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(0);
        canvas.drawBitmap(bitmap, (max - bitmap.getWidth()) / 2, (max - bitmap.getHeight()) / 2, paint);
        return createBitmap;
    }

    /* renamed from: a */
    public static File m18383a(Bitmap bitmap, File file) {
        try {
            File createTempFile = File.createTempFile("APKTOOL_M", ".tmpquant", C3102bd.m18908a());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.close();
            if (new LibPngQuant().m11224a(createTempFile, file)) {
                createTempFile.delete();
            } else {
                C3262u.m19612a(createTempFile, file);
                createTempFile.delete();
            }
            return file;
        } catch (Exception e2) {
            return (File) null;
        }
    }

    /* renamed from: a */
    public static File m18384a(Bitmap bitmap, File file, String str) {
        Bitmap.CompressFormat compressFormat;
        boolean z = false;
        try {
            String lowerCase = str.toLowerCase();
            if (lowerCase.equals("jpg") || lowerCase.equals("jpeg")) {
                compressFormat = Bitmap.CompressFormat.JPEG;
            } else if (lowerCase.equals("webp")) {
                compressFormat = Bitmap.CompressFormat.WEBP;
            } else {
                if (lowerCase.equals("bmp")) {
                    if (!new C3210d().m19113a(bitmap, file.getAbsolutePath())) {
                        return (File) null;
                    }
                    return file;
                }
                if (lowerCase.equals("gif")) {
                    compressFormat = Bitmap.CompressFormat.PNG;
                    z = true;
                } else {
                    if (lowerCase.equals("png")) {
                    }
                    return m18383a(bitmap, file);
                }
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (z) {
                C3265x c3265x = new C3265x();
                if (m18393b(bitmap)) {
                    c3265x.m19692a(0);
                }
                c3265x.m19697a(byteArrayOutputStream);
                c3265x.m19696a(bitmap);
                c3265x.m19695a();
            } else {
                bitmap.compress(compressFormat, 100, byteArrayOutputStream);
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.close();
            return file;
        } catch (Exception e2) {
            return (File) null;
        }
    }

    /* renamed from: b */
    public static boolean m18393b(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        for (int i = 0; i < width; i++) {
            for (int i2 = 0; i2 < height; i2++) {
                if (bitmap.getPixel(i, i2) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    public static Bitmap m18395c(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                iArr[(i * width) + i2] = iArr[(i * width) + i2] ^ 16777215;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return createBitmap;
    }

    /* renamed from: d */
    public static Bitmap m18397d(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return createBitmap;
    }

    /* renamed from: a */
    public static Bitmap m18374a(File file, int i) {
        return m18368a(m18391b(file, i), i);
    }

    /* renamed from: a */
    public static Bitmap m18368a(Bitmap bitmap, int i) {
        int max;
        int i2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > height) {
            i2 = Math.max(1, Math.abs((height * i) / width));
            max = i;
        } else {
            max = Math.max(1, Math.abs((width * i) / height));
            i2 = i;
        }
        return m18369a(bitmap, max, i2);
    }

    /* renamed from: a */
    public static Bitmap m18369a(Bitmap bitmap, int i, int i2) {
        return Bitmap.createScaledBitmap(bitmap, i, i2, true);
    }

    /* renamed from: a */
    public static Bitmap m18366a(Resources resources, int i, int i2) {
        try {
            TypedValue typedValue = new TypedValue();
            resources.getValueForDensity(i2, i, typedValue, true);
            AssetFileDescriptor openNonAssetFd = resources.getAssets().openNonAssetFd(typedValue.assetCookie, typedValue.string.toString());
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            Bitmap decodeResourceStream = BitmapFactory.decodeResourceStream(resources, typedValue, openNonAssetFd.createInputStream(), (Rect) null, options);
            openNonAssetFd.close();
            if (decodeResourceStream.getWidth() > 512 || decodeResourceStream.getHeight() > 512) {
                return m18368a(decodeResourceStream, 512);
            }
            return decodeResourceStream;
        } catch (Exception e2) {
            return BitmapFactory.decodeResource(resources, i2);
        }
    }

    /* renamed from: a */
    public static Bitmap m18378a(String str, int i, int i2) {
        C1088h m9073a = C1088h.m9073a(str);
        m9073a.m9077a(i);
        m9073a.m9084b(i2);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawARGB(0, 0, 0, 0);
        m9073a.m9078a(canvas);
        return createBitmap;
    }

    /* renamed from: a */
    public static Bitmap m18372a(Drawable drawable) {
        Bitmap createBitmap;
        if (drawable == null) {
            return (Bitmap) null;
        }
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        } else {
            createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    /* renamed from: a */
    public static Bitmap m18373a(Drawable drawable, int i, int i2) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return m18369a(bitmapDrawable.getBitmap(), i, i2);
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, i, i2);
        drawable.draw(canvas);
        return createBitmap;
    }

    /* renamed from: a */
    public static Drawable m18379a(Context context, int i, int i2) {
        Drawable m1847a = C0255a.m1847a(context, i);
        if (Build.VERSION.SDK_INT < 21) {
            m1847a = C0315a.m2369f(m1847a).mutate();
        }
        if (i2 > 0) {
            C0315a.m2357a(m1847a, i2);
        }
        return m1847a;
    }

    /* renamed from: b */
    public static Bitmap m18388b(Context context, int i, int i2) {
        return m18372a(m18379a(context, i, i2));
    }

    /* renamed from: e */
    public static int m18398e(Bitmap bitmap) {
        if (bitmap == null) {
            return Color.DKGRAY;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.copy(Bitmap.Config.ARGB_4444, false).getPixels(iArr, 0, width, 0, 0, width, height);
        HashMap hashMap = new HashMap();
        new Integer(0);
        for (int i : iArr) {
            Integer num = (Integer) hashMap.get(new Integer(i));
            if (num == null) {
                num = new Integer(0);
            }
            hashMap.put(new Integer(i), new Integer(new Integer(num.intValue() + 1).intValue()));
        }
        int i2 = 0;
        int i3 = 0;
        for (Map.Entry entry : hashMap.entrySet()) {
            if (((Integer) entry.getValue()).intValue() > i2) {
                i2 = ((Integer) entry.getValue()).intValue();
                i3 = ((Integer) entry.getKey()).intValue();
            }
        }
        if (i3 == 0) {
            return -1;
        }
        return i3;
    }

    /* renamed from: f */
    public static Bitmap m18399f(Bitmap bitmap) {
        return m18390b(bitmap, false);
    }

    /* renamed from: b */
    public static Bitmap m18390b(Bitmap bitmap, boolean z) {
        int width;
        if (z) {
            width = Math.min(bitmap.getWidth(), bitmap.getHeight());
        } else {
            width = bitmap.getWidth();
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, width, width);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawCircle(width / 2, width / 2, width / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    /* renamed from: b */
    public static Bitmap m18389b(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= i || height <= i2) {
            return m18369a(bitmap, i, i2);
        }
        return Bitmap.createBitmap(bitmap, (width - i) / 2, (height - i2) / 2, i, i2);
    }

    /* renamed from: a */
    public static Bitmap m18377a(String str, int i) {
        return m18391b(new File(str), i);
    }

    /* renamed from: b */
    public static Bitmap m18391b(File file, int i) {
        String absolutePath;
        if (file.getName().toLowerCase().endsWith(".png") && C3262u.m19663f(file)) {
            try {
                File createTempFile = File.createTempFile("APKTOOL_M", ".tmpquant", C3102bd.m18908a());
                if (new LibPngQuant().m11224a(file, createTempFile)) {
                    absolutePath = createTempFile.getAbsolutePath();
                } else {
                    absolutePath = file.getAbsolutePath();
                }
            } catch (IOException e2) {
                absolutePath = file.getAbsolutePath();
            }
        } else {
            absolutePath = file.getAbsolutePath();
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(absolutePath, options);
        options.inSampleSize = m18365a(options, i);
        options.inJustDecodeBounds = false;
        return m18368a(BitmapFactory.decodeFile(absolutePath, options), i);
    }

    /* renamed from: a */
    public static Bitmap m18376a(InputStream inputStream, int i) {
        byte[] m13984b = C1887e.m13984b(inputStream);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(m13984b, 0, m13984b.length, options);
        options.inSampleSize = m18365a(options, i);
        options.inJustDecodeBounds = false;
        return m18368a(BitmapFactory.decodeByteArray(m13984b, 0, m13984b.length, options), i);
    }

    /* renamed from: a */
    public static int m18365a(BitmapFactory.Options options, int i) {
        int i2 = options.outHeight;
        int i3 = options.outWidth;
        int i4 = 1;
        if (i2 > i || i3 > i) {
            int i5 = i2 / 2;
            int i6 = i3 / 2;
            while (i5 / i4 >= i && i6 / i4 >= i) {
                i4 *= 2;
            }
        }
        return i4;
    }

    /* renamed from: c */
    public static Bitmap m18396c(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, width, height);
        Rect rect2 = new Rect(i, i, width + i, height + i);
        Bitmap createBitmap = Bitmap.createBitmap((i * 2) + width, (i * 2) + height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        for (int i3 = 0; i3 <= i * 2; i3++) {
            canvas.drawBitmap(bitmap, rect, new Rect(i3, 0, width + i3, height), paint);
            canvas.drawBitmap(bitmap, rect, new Rect(0, i3, width, height + i3), paint);
            canvas.drawBitmap(bitmap, rect, new Rect(i3, i3, width + i3, height + i3), paint);
        }
        canvas.drawColor(i2, PorterDuff.Mode.SRC_IN);
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        return createBitmap;
    }

    /* renamed from: a */
    public static Bitmap m18370a(Bitmap bitmap, Drawable drawable) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        drawable.setBounds(width / 2, height / 2, width, height);
        drawable.draw(canvas);
        return createBitmap;
    }

    /* renamed from: a */
    public static Bitmap m18375a(File file, String str) {
        try {
            File file2 = new File(new StringBuffer().append(new StringBuffer().append(C3102bd.f18280P).append(File.separator).toString()).append(C3112bn.m19020b(String.format(Locale.f10688US, "%d-%d-%s-%s", new Long(file.length()), new Long(file.lastModified()), file.getAbsolutePath(), str), KeyProperties.DIGEST_SHA1)).toString());
            if (file2.exists()) {
                if (file2.isFile()) {
                    return BitmapFactory.decodeFile(file2.getAbsolutePath());
                }
                file2.delete();
            }
        } catch (Exception e2) {
        }
        return (Bitmap) null;
    }

    /* renamed from: b */
    public static void m18392b(Bitmap bitmap, File file, String str) {
        if (!file.getAbsolutePath().startsWith(C3102bd.f18280P)) {
            String m19020b = C3112bn.m19020b(String.format(Locale.f10688US, "%d-%d-%s-%s", new Long(file.length()), new Long(file.lastModified()), file.getAbsolutePath(), str), KeyProperties.DIGEST_SHA1);
            File file2 = new File(C3102bd.f18280P);
            if (!file2.isDirectory()) {
                file2.mkdirs();
            }
            File file3 = new File(file2, m19020b);
            if (file3.exists()) {
                file3.delete();
            }
            m18383a(bitmap, file3);
        }
    }

    /* renamed from: a */
    public static Drawable m18380a(Context context, File file) {
        try {
            return m18381a(context, new FileInputStream(file));
        } catch (Exception e2) {
            return (Drawable) null;
        }
    }

    /* renamed from: a */
    public static Drawable m18381a(Context context, InputStream inputStream) {
        try {
            return m18382a(context, C1887e.m13984b(inputStream), (Resources) null);
        } catch (Exception e2) {
            return (Drawable) null;
        }
    }

    /* renamed from: a */
    public static Drawable m18382a(Context context, byte[] bArr, Resources resources) {
        if (bArr == null) {
            return (Drawable) null;
        }
        if (!Arrays.equals(Arrays.copyOfRange(bArr, 0, 4), C3249i.f19535A)) {
            return (Drawable) null;
        }
        try {
            byte[] m18394b = m18394b(context, bArr, resources);
            if (m18394b != null) {
                Class<?> cls = Class.forName("android.content.res.XmlBlock");
                Class<?>[] clsArr = new Class[1];
                try {
                    clsArr[0] = Class.forName("[B");
                    Constructor<?> constructor = cls.getConstructor(clsArr);
                    Method declaredMethod = cls.getDeclaredMethod("newParser", new Class[0]);
                    constructor.setAccessible(true);
                    declaredMethod.setAccessible(true);
                    XmlPullParser xmlPullParser = (XmlPullParser) declaredMethod.invoke(constructor.newInstance(m18394b), new Object[0]);
                    if (Build.VERSION.SDK_INT >= 24) {
                        return Drawable.createFromXml(context.getResources(), xmlPullParser);
                    }
                    AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
                    for (int next = xmlPullParser.next(); next != 2; next = xmlPullParser.next()) {
                    }
                    return C0404i.m3233a(context.getResources(), xmlPullParser, asAttributeSet, (Resources.Theme) null);
                } catch (ClassNotFoundException e2) {
                    throw new NoClassDefFoundError(e2.getMessage());
                }
            }
        } catch (Exception e3) {
        }
        return (Drawable) null;
    }

    /* renamed from: b */
    public static byte[] m18394b(Context context, byte[] bArr, Resources resources) {
        boolean[] zArr = {false};
        C0546b c0546b = new C0546b(bArr);
        C0548d c0548d = new C0548d();
        c0546b.m4018a(new C0547c(c0548d, zArr, context, resources) { // from class: ru.maximoff.apktool.util.ab.1

            /* renamed from: a */
            private final boolean[] f17244a;

            /* renamed from: b */
            private final Context f17245b;

            /* renamed from: c */
            private final Resources f17246c;

            {
                this.f17244a = zArr;
                this.f17245b = context;
                this.f17246c = resources;
            }

            @Override // p060c.p061a.p062a.AbstractC0549e
            /* renamed from: a */
            public AbstractC0549e mo4019a(String str, String str2) {
                if (str2.equals("vector")) {
                    this.f17244a[0] = true;
                }
                return new a(this.f17245b, this.f17246c, super.mo4019a(str, str2));
            }
        });
        return zArr[0] ? c0548d.m4026b() : (byte[]) null;
    }

    /* compiled from: IconGenerate.java */
    /* renamed from: ru.maximoff.apktool.util.ab$a */
    private static class a extends C0547c {

        /* renamed from: a */
        private Context f17247a;

        /* renamed from: b */
        private Resources f17248b;

        public a(Context context, Resources resources, AbstractC0549e abstractC0549e) {
            super(abstractC0549e);
            this.f17247a = context;
            this.f17248b = resources;
        }

        @Override // p060c.p061a.p062a.AbstractC0549e
        /* renamed from: a */
        public AbstractC0549e mo4019a(String str, String str2) {
            return new a(this.f17247a, this.f17248b, super.mo4019a(str, str2));
        }

        @Override // p060c.p061a.p062a.AbstractC0549e
        /* renamed from: a */
        public void mo4032a(String str, String str2, int i, int i2, Object obj) {
            Integer num;
            Object obj2;
            int i3;
            Integer num2;
            if (str2.equals("fillColor") || str2.equals("strokeColor")) {
                if (i2 < 28 || i2 > 31) {
                    if (i2 == 1) {
                        try {
                            if (((((Integer) obj).intValue() >> 24) & 255) == 1) {
                                num = new Integer(this.f17247a.getResources().getColor(((Integer) obj).intValue()));
                            } else if (this.f17248b != null) {
                                num = new Integer(this.f17248b.getColor(((Integer) obj).intValue()));
                            } else {
                                num = new Integer(-16777216);
                            }
                        } catch (Exception e2) {
                            num = new Integer(-16777216);
                        }
                    } else {
                        num = new Integer(-16777216);
                    }
                    obj = num;
                    i2 = 28;
                }
                obj2 = obj;
                i3 = i2;
            } else if (str2.equals("tint")) {
                if (i2 < 28 || i2 > 31) {
                    if (i2 != 1) {
                        return;
                    }
                    try {
                        if (((((Integer) obj).intValue() >> 24) & 255) == 1) {
                            num2 = new Integer(this.f17247a.getResources().getColor(((Integer) obj).intValue()));
                        } else if (this.f17248b == null) {
                            return;
                        } else {
                            num2 = new Integer(this.f17248b.getColor(((Integer) obj).intValue()));
                        }
                        obj = num2;
                        i2 = 28;
                    } catch (Exception e3) {
                        return;
                    }
                }
                obj2 = obj;
                i3 = i2;
            } else if (str2.equals("pathData") && i2 == 1 && this.f17248b != null) {
                try {
                    obj2 = this.f17248b.getString(((Integer) obj).intValue());
                    i3 = 3;
                } catch (Exception e4) {
                    return;
                }
            } else {
                obj2 = obj;
                i3 = i2;
            }
            super.mo4032a(str, str2, i, i3, obj2);
        }
    }
}
