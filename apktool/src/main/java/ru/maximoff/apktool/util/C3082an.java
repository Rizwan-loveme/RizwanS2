package ru.maximoff.apktool.util;

import java.util.ArrayList;
import java.util.List;

/* compiled from: MarkedFiles.java */
/* renamed from: ru.maximoff.apktool.util.an */
/* loaded from: classes.dex */
public class C3082an {

    /* renamed from: a */
    public static final C3082an f18011a = new C3082an();

    /* renamed from: b */
    private List<String> f18012b = new ArrayList();

    /* renamed from: a */
    public void m18648a(String str) {
        if (this.f18012b.contains(str)) {
            this.f18012b.remove(str);
        } else {
            this.f18012b.add(str);
        }
    }

    /* renamed from: b */
    public boolean m18649b(String str) {
        return this.f18012b.contains(str);
    }

    /* renamed from: a */
    public void m18647a() {
        this.f18012b.clear();
    }

    C3082an() {
    }
}
