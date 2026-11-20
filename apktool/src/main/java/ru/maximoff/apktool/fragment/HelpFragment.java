package ru.maximoff.apktool.fragment;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.srizwan.apktool.R;
import java.io.InputStream;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.view.C3305g;

/* loaded from: classes.dex */
public class HelpFragment extends AbstractFragmentC2996c {
    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return new WebView(layoutInflater.getContext());
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        String str;
        super.onViewCreated(view, bundle);
        Activity activity = getActivity();
        int m18608k = C3080al.m18608k(activity);
        String m18600g = C3080al.m18600g(activity);
        String str2 = m18600g.equalsIgnoreCase("iw") ? "he" : m18600g;
        InputStream inputStream = (InputStream) null;
        try {
            inputStream = getResources().getAssets().open(new StringBuffer().append(new StringBuffer().append("about_").append(str2).toString()).append(".html").toString());
            str = new StringBuffer().append("_").append(str2).toString();
        } catch (Exception e2) {
            str = "_en";
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e3) {
                }
            }
            throw th;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e4) {
            }
        }
        WebView webView = (WebView) view;
        String str3 = "";
        switch (m18608k) {
            case 0:
                webView.setBackgroundColor(-1);
                str3 = "light";
                break;
            case 1:
                webView.setBackgroundColor(Color.parseColor("#303030"));
                str3 = "dark";
                break;
            case 2:
                webView.setBackgroundColor(-16777216);
                str3 = "black";
                break;
        }
        webView.addJavascriptInterface(new C3305g(activity), "apktool");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.loadUrl(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("file:///android_asset/about").append(str).toString()).append(".html?theme=").toString()).append(str3).toString()).append("&version=").toString()).append(C3102bd.f18293aa).toString()).append("-").toString()).append(str2).toString()).append("&arch=").toString()).append(C3102bd.f18268D).toString()).append("&lang=").toString()).append(str2).toString()).append("&fs=").toString()).append(C3102bd.f18333p).toString());
    }

    @Override // ru.maximoff.apktool.fragment.AbstractFragmentC2996c
    /* renamed from: a */
    protected int mo17609a() {
        return R.string.about;
    }
}
