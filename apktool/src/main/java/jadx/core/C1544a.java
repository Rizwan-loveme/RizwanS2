package jadx.core;

import jadx.core.p183c.p197g.C1677b;
import jadx.core.p183c.p197g.C1695c;
import jadx.core.p183c.p197g.C1699d;
import jadx.core.p183c.p197g.C1705e;
import jadx.core.p183c.p197g.C1706f;
import jadx.core.p183c.p197g.C1708h;
import jadx.core.p183c.p197g.C1709i;
import jadx.core.p183c.p197g.C1710j;
import jadx.core.p183c.p197g.C1711k;
import jadx.core.p183c.p197g.C1713m;
import jadx.core.p183c.p197g.C1714n;
import jadx.core.p183c.p197g.C1715o;
import jadx.core.p183c.p197g.C1716p;
import jadx.core.p183c.p197g.C1717q;
import jadx.core.p183c.p197g.C1718r;
import jadx.core.p183c.p197g.InterfaceC1712l;
import jadx.core.p183c.p197g.p198a.C1670a;
import jadx.core.p183c.p197g.p198a.C1673b;
import jadx.core.p183c.p197g.p198a.C1674c;
import jadx.core.p183c.p197g.p198a.C1675d;
import jadx.core.p183c.p197g.p198a.C1676e;
import jadx.core.p183c.p197g.p200b.C1679b;
import jadx.core.p183c.p197g.p200b.C1685h;
import jadx.core.p183c.p197g.p200b.C1686i;
import jadx.core.p183c.p197g.p200b.C1688k;
import jadx.core.p183c.p197g.p200b.C1690m;
import jadx.core.p183c.p197g.p200b.C1692o;
import jadx.core.p183c.p197g.p201c.C1696a;
import jadx.core.p183c.p197g.p201c.C1698c;
import jadx.core.p183c.p197g.p202d.C1701b;
import jadx.core.p183c.p197g.p202d.C1704e;
import jadx.p180a.C1534b;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.Manifest;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: Jadx.java */
/* renamed from: jadx.core.a */
/* loaded from: classes.dex */
public class C1544a {

    /* renamed from: a */
    private static final InterfaceC2558b f9899a = C2568c.m15995a((Class<?>) C1544a.class);

    private C1544a() {
    }

    /* renamed from: a */
    public static List<InterfaceC1712l> m11831a(C1534b c1534b) {
        ArrayList arrayList = new ArrayList();
        if (c1534b.m11772g()) {
            arrayList.add(new C1711k());
        } else {
            arrayList.add(new C1676e());
            arrayList.add(new C1675d());
            arrayList.add(new C1670a());
            arrayList.add(new C1673b());
            arrayList.add(new C1674c());
            arrayList.add(new C1698c());
            arrayList.add(new C1705e());
            arrayList.add(new C1704e());
            if (c1534b.m11771f()) {
                arrayList.add(C1708h.m13093b());
            }
            arrayList.add(new C1699d());
            arrayList.add(new C1701b());
            arrayList.add(new C1696a());
            arrayList.add(new C1714n());
            arrayList.add(new C1695c());
            arrayList.add(new C1716p());
            if (c1534b.m11770e()) {
                arrayList.add(C1708h.m13091a());
            }
            arrayList.add(new C1690m());
            arrayList.add(new C1685h());
            arrayList.add(new C1692o());
            arrayList.add(new C1695c());
            arrayList.add(new C1718r());
            arrayList.add(new C1679b());
            arrayList.add(new C1713m());
            arrayList.add(new C1710j());
            arrayList.add(new C1677b());
            arrayList.add(new C1709i());
            arrayList.add(new C1715o());
            arrayList.add(new C1686i());
            arrayList.add(new C1688k());
            if (c1534b.m11770e()) {
                arrayList.add(C1708h.m13095c());
            }
            arrayList.add(new C1706f());
            arrayList.add(new C1717q());
        }
        return arrayList;
    }

    /* renamed from: a */
    public static String m11830a() {
        try {
            ClassLoader classLoader = C1544a.class.getClassLoader();
            if (classLoader != null) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/MANIFEST.MF");
                while (resources.hasMoreElements()) {
                    String value = new Manifest(resources.nextElement().openStream()).getMainAttributes().getValue("jadx-version");
                    if (value != null) {
                        return value;
                    }
                }
            }
        } catch (Exception e2) {
            f9899a.mo15938b("Can't get manifest file", (Throwable) e2);
        }
        return "dev";
    }
}
