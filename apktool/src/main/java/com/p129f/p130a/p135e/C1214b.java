package com.p129f.p130a.p135e;

import com.p129f.p130a.p131a.C1120o;
import com.p129f.p130a.p133c.AbstractC1184bj;
import com.p129f.p130a.p134d.InterfaceC1212a;
import java.p209io.File;

/* compiled from: Files.java */
/* renamed from: com.f.a.e.b */
/* loaded from: classes.dex */
public final class C1214b {

    /* renamed from: a */
    private static final AbstractC1184bj<File> f7978a = new AbstractC1184bj<File>() { // from class: com.f.a.e.b.1
        public String toString() {
            return "Files.fileTreeTraverser()";
        }
    };

    /* renamed from: b */
    private static final InterfaceC1212a<File> f7979b = new InterfaceC1212a<File>() { // from class: com.f.a.e.b.2
    };

    /* renamed from: a */
    public static String m10167a(String str) {
        C1120o.m9547a(str);
        String name = new File(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf == -1 ? name : name.substring(0, lastIndexOf);
    }
}
