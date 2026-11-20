package androidx.core.app;

import android.app.RemoteInput;
import android.p008os.Build;
import android.p008os.Bundle;
import java.util.Iterator;
import java.util.Set;

/* compiled from: RemoteInput.java */
/* renamed from: androidx.core.app.l */
/* loaded from: classes.dex */
public final class C0241l {

    /* renamed from: a */
    private final String f1948a;

    /* renamed from: b */
    private final CharSequence f1949b;

    /* renamed from: c */
    private final CharSequence[] f1950c;

    /* renamed from: d */
    private final boolean f1951d;

    /* renamed from: e */
    private final int f1952e;

    /* renamed from: f */
    private final Bundle f1953f;

    /* renamed from: g */
    private final Set<String> f1954g;

    /* renamed from: a */
    public String m1773a() {
        return this.f1948a;
    }

    /* renamed from: b */
    public CharSequence m1774b() {
        return this.f1949b;
    }

    /* renamed from: c */
    public CharSequence[] m1775c() {
        return this.f1950c;
    }

    /* renamed from: d */
    public Set<String> m1776d() {
        return this.f1954g;
    }

    /* renamed from: e */
    public boolean m1777e() {
        return this.f1951d;
    }

    /* renamed from: f */
    public int m1778f() {
        return this.f1952e;
    }

    /* renamed from: g */
    public Bundle m1779g() {
        return this.f1953f;
    }

    /* renamed from: a */
    static RemoteInput[] m1772a(C0241l[] c0241lArr) {
        if (c0241lArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[c0241lArr.length];
        for (int i = 0; i < c0241lArr.length; i++) {
            remoteInputArr[i] = m1771a(c0241lArr[i]);
        }
        return remoteInputArr;
    }

    /* renamed from: a */
    static RemoteInput m1771a(C0241l c0241l) {
        Set<String> m1776d;
        RemoteInput.Builder addExtras = new RemoteInput.Builder(c0241l.m1773a()).setLabel(c0241l.m1774b()).setChoices(c0241l.m1775c()).setAllowFreeFormInput(c0241l.m1777e()).addExtras(c0241l.m1779g());
        if (Build.VERSION.SDK_INT >= 26 && (m1776d = c0241l.m1776d()) != null) {
            Iterator<String> it = m1776d.iterator();
            while (it.hasNext()) {
                addExtras.setAllowDataType(it.next(), true);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            addExtras.setEditChoicesBeforeSending(c0241l.m1778f());
        }
        return addExtras.build();
    }
}
