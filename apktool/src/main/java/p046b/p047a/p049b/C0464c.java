package p046b.p047a.p049b;

import android.os.DropBoxManager;
import java.util.LinkedList;
import java.util.List;
import org.p270e.C2466a;
import org.p270e.C2468c;

/* compiled from: UsesFramework.java */
/* renamed from: b.a.b.c */
/* loaded from: classes.dex */
public class C0464c {

    /* renamed from: a */
    public List<Integer> f3297a;

    /* renamed from: b */
    public String f3298b;

    /* renamed from: a */
    public static void m3538a(C2468c c2468c, C0464c c0464c) {
        if (c0464c == null) {
            c2468c.m15608a("UsesFramework", C2468c.f12954b);
        } else {
            c0464c.m3539b(c2468c);
        }
    }

    /* renamed from: a */
    public static C0464c m3537a(C2468c c2468c) {
        C0464c c0464c = new C0464c();
        if (!c2468c.m15619h("UsesFramework")) {
            C2468c m15616e = c2468c.m15616e("UsesFramework");
            if (m15616e.m15619h(DropBoxManager.EXTRA_TAG)) {
                c0464c.f3298b = (String) null;
            } else {
                c0464c.f3298b = m15616e.m15617f(DropBoxManager.EXTRA_TAG);
            }
            C2466a m15615d = m15616e.m15615d("ids");
            LinkedList linkedList = new LinkedList();
            int m15569a = m15615d.m15569a();
            for (int i = 0; i < m15569a; i++) {
                linkedList.add(new Integer(m15615d.m15575b(i)));
            }
            c0464c.f3297a = linkedList;
        }
        return c0464c;
    }

    /* renamed from: b */
    public void m3539b(C2468c c2468c) {
        C2468c c2468c2 = new C2468c();
        C0462a.m3525a(c2468c2, this.f3297a, "ids");
        C0462a.m3524a(c2468c2, DropBoxManager.EXTRA_TAG, this.f3298b);
        c2468c.m15608a("UsesFramework", c2468c2);
    }
}
