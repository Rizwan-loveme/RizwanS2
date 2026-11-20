package ru.p294a;

import java.p209io.Serializable;
import java.util.zip.ZipException;

/* compiled from: UnsupportedZipFeatureException.java */
/* renamed from: ru.a.n */
/* loaded from: classes.dex */
public class C2595n extends ZipException {

    /* renamed from: a */
    private final a f13451a;

    /* renamed from: b */
    private final transient C2602u f13452b;

    public C2595n(a aVar, C2602u c2602u) {
        super(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("unsupported feature ").append(aVar).toString()).append(" used in entry ").toString()).append(c2602u.getName()).toString());
        this.f13451a = aVar;
        this.f13452b = c2602u;
    }

    /* compiled from: UnsupportedZipFeatureException.java */
    @SuppressWarnings("serial")
    /* renamed from: ru.a.n$a */
    public static class a implements Serializable {

        /* renamed from: a */
        public static final a f13453a = new a("encryption");

        /* renamed from: b */
        public static final a f13454b = new a("compression method");

        /* renamed from: c */
        public static final a f13455c = new a("data descriptor");

        /* renamed from: d */
        private final String f13456d;

        a(String str) {
            this.f13456d = str;
        }

        public String toString() {
            return this.f13456d;
        }
    }
}
