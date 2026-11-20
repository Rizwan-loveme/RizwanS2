package androidx.core.p031f.p032a;

import android.p008os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: AccessibilityClickableSpanCompat.java */
/* renamed from: androidx.core.f.a.a */
/* loaded from: classes.dex */
public final class C0272a extends ClickableSpan {

    /* renamed from: a */
    private final int f2071a;

    /* renamed from: b */
    private final C0273b f2072b;

    /* renamed from: c */
    private final int f2073c;

    public C0272a(int i, C0273b c0273b, int i2) {
        this.f2071a = i;
        this.f2072b = c0273b;
        this.f2073c = i2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f2071a);
        this.f2072b.m1996a(this.f2073c, bundle);
    }
}
