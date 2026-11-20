package ru.maximoff.apktool.util;

import android.content.Context;
import java.io.File;
import java.util.Comparator;
import org.p270e.C2468c;
import ru.maximoff.apktool.fragment.p302b.EnumC2989h;

/* compiled from: SortFiles.java */
/* renamed from: ru.maximoff.apktool.util.bj */
/* loaded from: classes.dex */
public class C3108bj implements Comparator<File> {

    /* renamed from: a */
    private Context f18378a;

    @Override // java.util.Comparator
    public int compare(File file, File file2) {
        return m18981a(file, file2);
    }

    public C3108bj(Context context, File file) {
        this.f18378a = context;
        try {
            EnumC2989h.m17910a(m18980a(file.getAbsolutePath()));
        } catch (Exception e2) {
        }
    }

    /* renamed from: a */
    public int m18981a(File file, File file2) {
        return EnumC2989h.m17909a().mo17914a(file, file2);
    }

    /* renamed from: a */
    private int m18980a(String str) {
        C2468c c2468c = new C2468c(C3102bd.m18910a(this.f18378a, "customCompator", "{}"));
        return c2468c.m15618g(str) ? c2468c.m15612c(str) : C3102bd.m18905a(this.f18378a, "defaultCompator", 0);
    }
}
