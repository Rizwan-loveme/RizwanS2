package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.core.content.p028a.C0258c;
import androidx.core.p027c.C0251f;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: TypefaceCompatApi29Impl.java */
/* renamed from: androidx.core.graphics.i */
/* loaded from: classes.dex */
public class C0325i extends C0326j {
    @Override // androidx.core.graphics.C0326j
    /* renamed from: a */
    protected C0251f.b mo2406a(C0251f.b[] bVarArr, int i) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // androidx.core.graphics.C0326j
    /* renamed from: a */
    protected Typeface mo2405a(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // androidx.core.graphics.C0326j
    /* renamed from: a */
    public Typeface mo2384a(Context context, CancellationSignal cancellationSignal, C0251f.b[] bVarArr, int i) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily.Builder builder = null;
            for (C0251f.b bVar : bVarArr) {
                try {
                    ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(bVar.m1827a(), "r", cancellationSignal);
                    if (openFileDescriptor != null) {
                        try {
                            Font build = new Font.Builder(openFileDescriptor).setWeight(bVar.m1829c()).setSlant(bVar.m1830d() ? 1 : 0).setTtcIndex(bVar.m1828b()).build();
                            if (builder == null) {
                                builder = new FontFamily.Builder(build);
                            } else {
                                builder.addFont(build);
                            }
                            if (openFileDescriptor != null) {
                                openFileDescriptor.close();
                            }
                        } catch (Throwable th) {
                            if (openFileDescriptor != null) {
                                try {
                                    openFileDescriptor.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    } else if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                } catch (IOException e2) {
                }
            }
            if (builder == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0)).build();
        } catch (Exception e3) {
            return null;
        }
    }

    @Override // androidx.core.graphics.C0326j
    /* renamed from: a */
    public Typeface mo2385a(Context context, C0258c.b bVar, Resources resources, int i) {
        FontFamily.Builder builder;
        try {
            C0258c.c[] m1889a = bVar.m1889a();
            int length = m1889a.length;
            int i2 = 0;
            FontFamily.Builder builder2 = null;
            while (i2 < length) {
                C0258c.c cVar = m1889a[i2];
                try {
                    Font build = new Font.Builder(resources, cVar.m1895f()).setWeight(cVar.m1891b()).setSlant(cVar.m1892c() ? 1 : 0).setTtcIndex(cVar.m1894e()).setFontVariationSettings(cVar.m1893d()).build();
                    if (builder2 == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder2.addFont(build);
                        builder = builder2;
                    }
                } catch (IOException e2) {
                    builder = builder2;
                }
                i2++;
                builder2 = builder;
            }
            if (builder2 == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(builder2.build()).setStyle(new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0)).build();
        } catch (Exception e3) {
            return null;
        }
    }

    @Override // androidx.core.graphics.C0326j
    /* renamed from: a */
    public Typeface mo2396a(Context context, Resources resources, int i, String str, int i2) {
        try {
            Font build = new Font.Builder(resources, i).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception e2) {
            return null;
        }
    }
}
