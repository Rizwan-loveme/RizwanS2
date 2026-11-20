package ru.maximoff.apktool.util.activities;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import java.util.Arrays;

/* compiled from: MActivity.java */
/* renamed from: ru.maximoff.apktool.util.activities.a */
/* loaded from: classes.dex */
public class C3071a {

    /* renamed from: a */
    private String f17327a;

    /* renamed from: b */
    private String f17328b;

    /* renamed from: c */
    private String f17329c;

    /* renamed from: d */
    private Drawable f17330d;

    /* renamed from: e */
    private boolean f17331e;

    /* renamed from: f */
    private boolean f17332f;

    public C3071a(String str, String str2, CharSequence charSequence, Drawable drawable, boolean z) {
        this(str, str2, charSequence, drawable, z, false);
    }

    public C3071a(String str, String str2, CharSequence charSequence, Drawable drawable, boolean z, boolean z2) {
        this.f17327a = str;
        this.f17328b = str2;
        this.f17329c = charSequence.toString();
        this.f17330d = drawable;
        this.f17331e = z;
        this.f17332f = z2;
    }

    /* renamed from: a */
    public boolean m18422a() {
        return this.f17332f;
    }

    /* renamed from: b */
    public String m18423b() {
        return this.f17327a;
    }

    /* renamed from: c */
    public String m18424c() {
        return this.f17328b;
    }

    /* renamed from: d */
    public String m18425d() {
        return new ComponentName(this.f17327a, this.f17328b).flattenToShortString();
    }

    /* renamed from: e */
    public String m18426e() {
        return new ComponentName(this.f17327a, this.f17328b).flattenToString();
    }

    /* renamed from: f */
    public String m18427f() {
        return this.f17329c;
    }

    /* renamed from: g */
    public Drawable m18428g() {
        return this.f17330d;
    }

    /* renamed from: h */
    public boolean m18429h() {
        return this.f17331e;
    }

    /* renamed from: a */
    public void m18421a(Context context) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addFlags(268435456);
        intent.setComponent(new ComponentName(this.f17327a, this.f17328b));
        context.startActivity(intent);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f17327a, this.f17328b, this.f17329c, this.f17330d, new Boolean(this.f17331e), new Boolean(this.f17332f)});
    }
}
