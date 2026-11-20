package ru.maximoff.apktool.view;

import android.content.Context;
import android.webkit.WebView;

/* compiled from: ObservableWebView.java */
/* renamed from: ru.maximoff.apktool.view.j */
/* loaded from: classes.dex */
public class C3308j extends WebView {

    /* renamed from: a */
    private a f21124a;

    /* compiled from: ObservableWebView.java */
    /* renamed from: ru.maximoff.apktool.view.j$a */
    public interface a {
        /* renamed from: a */
        void mo17610a(int i, int i2, int i3, int i4);
    }

    public C3308j(Context context) {
        super(context);
    }

    public void setOnScrollChangedListener(a aVar) {
        this.f21124a = aVar;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f21124a != null) {
            this.f21124a.mo17610a(i, i2, i3, i4);
        }
    }
}
