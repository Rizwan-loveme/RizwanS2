package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.AbstractC0452a;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(AbstractC0452a abstractC0452a) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f1828a = (IconCompat) abstractC0452a.m3448b((AbstractC0452a) remoteActionCompat.f1828a, 1);
        remoteActionCompat.f1829b = abstractC0452a.m3449b(remoteActionCompat.f1829b, 2);
        remoteActionCompat.f1830c = abstractC0452a.m3449b(remoteActionCompat.f1830c, 3);
        remoteActionCompat.f1831d = (PendingIntent) abstractC0452a.m3447b((AbstractC0452a) remoteActionCompat.f1831d, 4);
        remoteActionCompat.f1832e = abstractC0452a.m3453b(remoteActionCompat.f1832e, 5);
        remoteActionCompat.f1833f = abstractC0452a.m3453b(remoteActionCompat.f1833f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, AbstractC0452a abstractC0452a) {
        abstractC0452a.m3442a(false, false);
        abstractC0452a.m3434a(remoteActionCompat.f1828a, 1);
        abstractC0452a.m3437a(remoteActionCompat.f1829b, 2);
        abstractC0452a.m3437a(remoteActionCompat.f1830c, 3);
        abstractC0452a.m3432a(remoteActionCompat.f1831d, 4);
        abstractC0452a.m3441a(remoteActionCompat.f1832e, 5);
        abstractC0452a.m3441a(remoteActionCompat.f1833f, 6);
    }
}
