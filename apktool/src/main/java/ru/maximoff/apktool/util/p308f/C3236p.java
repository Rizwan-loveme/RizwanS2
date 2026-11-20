package ru.maximoff.apktool.util.p308f;

import java.io.File;
import ru.maximoff.apktool.util.C3112bn;

/* compiled from: StringItem.java */
/* renamed from: ru.maximoff.apktool.util.f.p */
/* loaded from: classes.dex */
public class C3236p {

    /* renamed from: a */
    private boolean f19405a;

    /* renamed from: b */
    private boolean f19406b;

    /* renamed from: c */
    private boolean f19407c;

    /* renamed from: d */
    private boolean f19408d;

    /* renamed from: e */
    private boolean f19409e;

    /* renamed from: f */
    private boolean f19410f;

    /* renamed from: g */
    private boolean f19411g;

    /* renamed from: h */
    private boolean f19412h;

    /* renamed from: i */
    private boolean f19413i;

    /* renamed from: j */
    private File f19414j;

    /* renamed from: k */
    private int f19415k;

    /* renamed from: l */
    private String f19416l;

    /* renamed from: m */
    private String f19417m;

    /* renamed from: n */
    private String f19418n;

    /* renamed from: o */
    private String f19419o;

    /* renamed from: p */
    private String f19420p;

    /* renamed from: q */
    private String f19421q;

    public C3236p(String str, String str2) {
        this.f19408d = false;
        this.f19409e = false;
        this.f19410f = false;
        this.f19411g = false;
        this.f19412h = false;
        this.f19413i = false;
        this.f19416l = str;
        this.f19417m = m19365f(str2);
        this.f19418n = (String) null;
        this.f19419o = (String) null;
        this.f19420p = (String) null;
        this.f19405a = true;
        this.f19406b = true;
        this.f19407c = true;
    }

    public C3236p(String str, String str2, boolean z) {
        this.f19408d = false;
        this.f19409e = false;
        this.f19410f = false;
        this.f19411g = false;
        this.f19412h = false;
        this.f19413i = false;
        this.f19409e = z;
        this.f19416l = str;
        this.f19417m = m19365f(str2);
        this.f19418n = (String) null;
        this.f19419o = (String) null;
        this.f19420p = (String) null;
        this.f19405a = true;
        this.f19406b = true;
        this.f19407c = true;
    }

    public C3236p(String str, String str2, String str3) {
        this.f19408d = false;
        this.f19409e = false;
        this.f19410f = false;
        this.f19411g = false;
        this.f19412h = false;
        this.f19413i = false;
        this.f19416l = str;
        this.f19417m = m19365f(str2);
        this.f19418n = str3;
        this.f19419o = (String) null;
        this.f19420p = (String) null;
        this.f19405a = true;
        this.f19406b = true;
        this.f19407c = true;
    }

    public C3236p(String str, String str2, String str3, boolean z) {
        this.f19408d = false;
        this.f19409e = false;
        this.f19410f = false;
        this.f19411g = false;
        this.f19412h = false;
        this.f19413i = false;
        this.f19416l = str;
        this.f19417m = m19365f(str2);
        this.f19418n = str3;
        this.f19419o = (String) null;
        this.f19420p = (String) null;
        this.f19405a = z;
        this.f19406b = z;
        this.f19407c = true;
    }

    public C3236p(String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        this.f19408d = false;
        this.f19409e = false;
        this.f19410f = false;
        this.f19411g = false;
        this.f19412h = false;
        this.f19413i = false;
        this.f19416l = str;
        this.f19417m = m19365f(str2);
        this.f19418n = str3;
        this.f19419o = (String) null;
        this.f19420p = (String) null;
        this.f19405a = z;
        this.f19406b = z;
        this.f19407c = z2;
        this.f19410f = z3;
        this.f19411g = z3;
    }

    public C3236p(String str, String str2, String str3, String str4, boolean z) {
        this.f19408d = false;
        this.f19409e = false;
        this.f19410f = false;
        this.f19411g = false;
        this.f19412h = false;
        this.f19413i = false;
        this.f19416l = str;
        this.f19417m = m19365f(str2);
        this.f19418n = str3;
        this.f19419o = str4;
        this.f19420p = str4;
        this.f19405a = z;
        this.f19406b = z;
        this.f19407c = true;
    }

    /* renamed from: a */
    public void m19371a(boolean z) {
        this.f19405a = z;
    }

    /* renamed from: b */
    public void m19373b(boolean z) {
        this.f19407c = z;
    }

    /* renamed from: c */
    public void m19376c(boolean z) {
        this.f19405a = z;
        this.f19406b = z;
    }

    /* renamed from: a */
    public void m19369a(String str) {
        this.f19416l = str;
    }

    /* renamed from: b */
    public void m19372b(String str) {
        this.f19417m = m19365f(str);
    }

    /* renamed from: c */
    public void m19375c(String str) {
        this.f19418n = str;
        this.f19412h = false;
    }

    /* renamed from: a */
    public void m19370a(String str, boolean z) {
        this.f19418n = str;
        this.f19412h = z;
    }

    /* renamed from: d */
    public void m19378d(String str) {
        this.f19419o = str;
    }

    /* renamed from: e */
    public void m19382e(String str) {
        this.f19421q = str;
    }

    /* renamed from: d */
    public void m19379d(boolean z) {
        this.f19408d = z;
    }

    /* renamed from: e */
    public void m19383e(boolean z) {
        this.f19410f = z;
    }

    /* renamed from: f */
    public void m19385f(boolean z) {
        this.f19413i = z;
    }

    /* renamed from: a */
    public void m19368a(File file) {
        this.f19414j = file;
    }

    /* renamed from: a */
    public void m19367a(int i) {
        this.f19415k = i;
    }

    /* renamed from: a */
    public void m19366a() {
        this.f19418n = this.f19417m;
        this.f19412h = false;
    }

    /* renamed from: b */
    public boolean m19374b() {
        return this.f19405a;
    }

    /* renamed from: c */
    public boolean m19377c() {
        return this.f19407c;
    }

    /* renamed from: d */
    public boolean m19380d() {
        return this.f19406b;
    }

    /* renamed from: e */
    public String m19381e() {
        return this.f19416l;
    }

    /* renamed from: f */
    public String m19384f() {
        return this.f19421q;
    }

    /* renamed from: g */
    public String m19386g() {
        return this.f19417m;
    }

    /* renamed from: h */
    public String m19387h() {
        return this.f19418n;
    }

    /* renamed from: i */
    public String m19388i() {
        return this.f19419o;
    }

    /* renamed from: j */
    public String m19389j() {
        return this.f19420p;
    }

    /* renamed from: k */
    public boolean m19390k() {
        return (this.f19418n == null && (this.f19405a ? this.f19406b : !this.f19406b) && this.f19419o == this.f19420p) ? false : true;
    }

    /* renamed from: l */
    public boolean m19391l() {
        return this.f19410f;
    }

    /* renamed from: m */
    public boolean m19392m() {
        return this.f19413i;
    }

    /* renamed from: n */
    public File m19393n() {
        return this.f19414j;
    }

    /* renamed from: o */
    public int m19394o() {
        return this.f19415k;
    }

    /* renamed from: p */
    public void m19395p() {
        this.f19410f = this.f19411g;
    }

    public String toString() {
        return this.f19417m;
    }

    /* renamed from: f */
    private String m19365f(String str) {
        String m19031f = C3112bn.m19031f(str);
        if (this.f19409e) {
            return m19031f.replace("&quot;", "\"");
        }
        return m19031f;
    }
}
