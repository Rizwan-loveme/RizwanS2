package ru.maximoff.apktool.fragment;

import android.C0012R;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.srizwan.apktool.R;
import java.io.InputStream;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.view.C3305g;
import ru.maximoff.apktool.view.C3308j;

/* loaded from: classes.dex */
public class FaqFragment extends AbstractFragmentC2996c {

    /* renamed from: a */
    private C3308j f15838a;

    /* renamed from: b */
    private ImageButton f15839b;

    /* renamed from: c */
    private boolean f15840c = false;

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(getActivity());
        this.f15838a = new C3308j(getActivity());
        frameLayout.addView(this.f15838a, new FrameLayout.LayoutParams(-1, -1));
        this.f15839b = new ImageButton(getActivity());
        this.f15839b.setImageResource(C0012R.drawable.arrow_up_float);
        this.f15839b.setBackgroundColor(1426063360);
        int i = (int) (48 * getResources().getDisplayMetrics().density);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
        layoutParams.gravity = 8388693;
        layoutParams.setMargins(16, 16, 16, 16);
        this.f15839b.setLayoutParams(layoutParams);
        this.f15839b.setVisibility(8);
        frameLayout.addView(this.f15839b);
        return frameLayout;
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
            inputStream = getResources().getAssets().open(new StringBuffer().append(new StringBuffer().append("faq/faq_").append(str2).toString()).append(".html").toString());
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
        String str3 = "";
        switch (m18608k) {
            case 0:
                this.f15838a.setBackgroundColor(-1);
                str3 = "light";
                break;
            case 1:
                this.f15838a.setBackgroundColor(Color.parseColor("#303030"));
                str3 = "dark";
                break;
            case 2:
                this.f15838a.setBackgroundColor(-16777216);
                str3 = "black";
                break;
        }
        this.f15838a.addJavascriptInterface(new C3305g(activity), "apktool");
        this.f15838a.getSettings().setJavaScriptEnabled(true);
        this.f15838a.getSettings().setAllowFileAccess(true);
        this.f15838a.loadUrl(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("file:///android_asset/faq/faq").append(str).toString()).append(".html?theme=").toString()).append(str3).toString()).append("&version=").toString()).append(C3102bd.f18293aa).toString()).append("-").toString()).append(str2).toString()).append("&arch=").toString()).append(C3102bd.f18268D).toString()).append("&lang=").toString()).append(str2).toString()).append("&fs=").toString()).append(C3102bd.f18333p).toString());
        this.f15838a.setOnScrollChangedListener(new C3308j.a(this) { // from class: ru.maximoff.apktool.fragment.FaqFragment.1

            /* renamed from: a */
            private final FaqFragment f15841a;

            {
                this.f15841a = this;
            }

            @Override // ru.maximoff.apktool.view.C3308j.a
            /* renamed from: a */
            public void mo17610a(int i, int i2, int i3, int i4) {
                if (i2 > 200 && !this.f15841a.f15840c) {
                    this.f15841a.m17604b();
                } else {
                    if (i2 > 200 || !this.f15841a.f15840c) {
                        return;
                    }
                    this.f15841a.m17605c();
                }
            }
        });
        this.f15839b.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.fragment.FaqFragment.2

            /* renamed from: a */
            private final FaqFragment f15842a;

            {
                this.f15842a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                this.f15842a.f15838a.scrollTo(0, 0);
            }
        });
    }

    @Override // ru.maximoff.apktool.fragment.AbstractFragmentC2996c
    /* renamed from: a */
    protected int mo17609a() {
        return R.string.faq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m17604b() {
        this.f15840c = true;
        this.f15839b.setVisibility(0);
        this.f15839b.animate().alpha(1.0f).setDuration(300).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m17605c() {
        this.f15840c = false;
        this.f15839b.animate().alpha(0.0f).setDuration(300).withEndAction(new Runnable(this) { // from class: ru.maximoff.apktool.fragment.FaqFragment.3

            /* renamed from: a */
            private final FaqFragment f15843a;

            {
                this.f15843a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f15843a.f15840c) {
                    return;
                }
                this.f15843a.f15839b.setVisibility(8);
            }
        }).start();
    }
}
