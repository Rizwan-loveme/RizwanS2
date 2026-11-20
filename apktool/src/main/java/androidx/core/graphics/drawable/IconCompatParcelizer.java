package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import androidx.versionedparcelable.AbstractC0452a;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(AbstractC0452a abstractC0452a) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f2248a = abstractC0452a.m3446b(iconCompat.f2248a, 1);
        iconCompat.f2250c = abstractC0452a.m3454b(iconCompat.f2250c, 2);
        iconCompat.f2251d = abstractC0452a.m3447b((AbstractC0452a) iconCompat.f2251d, 3);
        iconCompat.f2252e = abstractC0452a.m3446b(iconCompat.f2252e, 4);
        iconCompat.f2253f = abstractC0452a.m3446b(iconCompat.f2253f, 5);
        iconCompat.f2254g = (ColorStateList) abstractC0452a.m3447b((AbstractC0452a) iconCompat.f2254g, 6);
        iconCompat.f2256j = abstractC0452a.m3450b(iconCompat.f2256j, 7);
        iconCompat.f2257k = abstractC0452a.m3450b(iconCompat.f2257k, 8);
        iconCompat.mo2354f();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, AbstractC0452a abstractC0452a) {
        abstractC0452a.m3442a(true, true);
        iconCompat.mo2348a(abstractC0452a.m3445a());
        if (-1 != iconCompat.f2248a) {
            abstractC0452a.m3430a(iconCompat.f2248a, 1);
        }
        if (iconCompat.f2250c != null) {
            abstractC0452a.m3444a(iconCompat.f2250c, 2);
        }
        if (iconCompat.f2251d != null) {
            abstractC0452a.m3432a(iconCompat.f2251d, 3);
        }
        if (iconCompat.f2252e != 0) {
            abstractC0452a.m3430a(iconCompat.f2252e, 4);
        }
        if (iconCompat.f2253f != 0) {
            abstractC0452a.m3430a(iconCompat.f2253f, 5);
        }
        if (iconCompat.f2254g != null) {
            abstractC0452a.m3432a(iconCompat.f2254g, 6);
        }
        if (iconCompat.f2256j != null) {
            abstractC0452a.m3439a(iconCompat.f2256j, 7);
        }
        if (iconCompat.f2257k != null) {
            abstractC0452a.m3439a(iconCompat.f2257k, 8);
        }
    }
}
