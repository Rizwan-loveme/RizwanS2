package ru.maximoff.apktool.fragment;

import android.C0012R;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.view.View;
import android.widget.ListView;
import com.srizwan.apktool.R;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3246h;

/* compiled from: SettingsFragment.java */
/* renamed from: ru.maximoff.apktool.fragment.c */
/* loaded from: classes.dex */
public abstract class AbstractFragmentC2996c extends PreferenceFragment {
    /* renamed from: a */
    protected abstract int mo17609a();

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        Activity activity = getActivity();
        if (activity != null) {
            activity.setTitle(mo17609a());
        }
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Preference findPreference;
        super.onActivityCreated(bundle);
        ListView listView = (ListView) getView().findViewById(C0012R.id.list);
        if (listView != null) {
            listView.setDivider((Drawable) null);
            String stringExtra = getActivity().getIntent().getStringExtra("target_key");
            if (stringExtra != null && (findPreference = findPreference(stringExtra)) != null) {
                listView.post(new Runnable(this, findPreference, listView) { // from class: ru.maximoff.apktool.fragment.c.1

                    /* renamed from: a */
                    private final AbstractFragmentC2996c f16821a;

                    /* renamed from: b */
                    private final Preference f16822b;

                    /* renamed from: c */
                    private final ListView f16823c;

                    {
                        this.f16821a = this;
                        this.f16822b = findPreference;
                        this.f16823c = listView;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        int m18069a = this.f16821a.m18069a(this.f16822b);
                        if (m18069a >= 0) {
                            this.f16823c.setSelection(m18069a);
                            this.f16821a.m18071a(this.f16823c, m18069a);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m18069a(Preference preference) {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        for (int i = 0; i < preferenceScreen.getPreferenceCount(); i++) {
            if (preferenceScreen.getPreference(i) == preference) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m18071a(ListView listView, int i) {
        listView.postDelayed(new Runnable(this, listView, i) { // from class: ru.maximoff.apktool.fragment.c.2

            /* renamed from: a */
            private final AbstractFragmentC2996c f16824a;

            /* renamed from: b */
            private final ListView f16825b;

            /* renamed from: c */
            private final int f16826c;

            {
                this.f16824a = this;
                this.f16825b = listView;
                this.f16826c = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                int firstVisiblePosition = this.f16826c - this.f16825b.getFirstVisiblePosition();
                if (firstVisiblePosition >= 0 && firstVisiblePosition < this.f16825b.getChildCount()) {
                    View childAt = this.f16825b.getChildAt(firstVisiblePosition);
                    childAt.setBackgroundColor(C3246h.m19470a(this.f16824a.getActivity(), C3102bd.f18291a ? R.color.tvery_light_grey2 : R.color.tvery_light_grey));
                    childAt.animate().alpha(1.0f).setDuration(300).withEndAction(new Runnable(this, childAt) { // from class: ru.maximoff.apktool.fragment.c.2.1

                        /* renamed from: a */
                        private final AnonymousClass2 f16827a;

                        /* renamed from: b */
                        private final View f16828b;

                        {
                            this.f16827a = this;
                            this.f16828b = childAt;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            this.f16828b.postDelayed(new Runnable(this, this.f16828b) { // from class: ru.maximoff.apktool.fragment.c.2.1.1

                                /* renamed from: a */
                                private final AnonymousClass1 f16829a;

                                /* renamed from: b */
                                private final View f16830b;

                                {
                                    this.f16829a = this;
                                    this.f16830b = r2;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    this.f16830b.setBackgroundColor(0);
                                }
                            }, 1200L);
                        }
                    });
                }
            }
        }, 200L);
    }
}
