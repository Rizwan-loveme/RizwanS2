package ru.maximoff.apktool.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.p006pm.PackageManager;
import android.p008os.AsyncTask;
import android.p008os.Build;
import android.p008os.Bundle;
import android.preference.Preference;
import com.srizwan.apktool.R;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p309g.AsyncTaskC3243a;
import ru.maximoff.apktool.util.p309g.AsyncTaskC3245c;

/* loaded from: classes.dex */
public class UpdaterFragment extends AbstractFragmentC2996c {

    /* renamed from: a */
    private int f15872a;

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.preference_updater);
        Activity activity = getActivity();
        this.f15872a = 1;
        try {
            this.f15872a = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
        }
        findPreference("check_update").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this, activity) { // from class: ru.maximoff.apktool.fragment.UpdaterFragment.1

            /* renamed from: a */
            private final UpdaterFragment f15873a;

            /* renamed from: b */
            private final Context f15874b;

            {
                this.f15873a = this;
                this.f15874b = activity;
            }

            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                C3112bn.m18999a(this.f15874b, R.string.mplease_wait);
                try {
                    new AsyncTaskC3245c(this.f15873a.getActivity(), this.f15873a.f15872a, false).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                } catch (Exception e3) {
                    C3112bn.m18999a(this.f15874b, R.string.error_try_again);
                }
                return false;
            }
        });
        findPreference("get_changelog").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this, activity) { // from class: ru.maximoff.apktool.fragment.UpdaterFragment.2

            /* renamed from: a */
            private final UpdaterFragment f15875a;

            /* renamed from: b */
            private final Context f15876b;

            {
                this.f15875a = this;
                this.f15876b = activity;
            }

            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                C3112bn.m18999a(this.f15876b, R.string.mplease_wait);
                try {
                    new AsyncTaskC3243a(this.f15875a.getActivity(), this.f15875a.f15872a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                } catch (Exception e3) {
                    C3112bn.m18999a(this.f15876b, R.string.error_try_again);
                }
                return false;
            }
        });
        findPreference("open_site").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this, activity) { // from class: ru.maximoff.apktool.fragment.UpdaterFragment.3

            /* renamed from: a */
            private final UpdaterFragment f15877a;

            /* renamed from: b */
            private final Context f15878b;

            {
                this.f15877a = this;
                this.f15878b = activity;
            }

            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                C3080al.m18595e(this.f15878b, "https://github.com/Maximoff/Apktool-M-updates");
                return false;
            }
        });
        findPreference("topic_4pda").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this, activity) { // from class: ru.maximoff.apktool.fragment.UpdaterFragment.4

            /* renamed from: a */
            private final UpdaterFragment f15879a;

            /* renamed from: b */
            private final Context f15880b;

            {
                this.f15879a = this;
                this.f15880b = activity;
            }

            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                C3080al.m18595e(this.f15880b, "https://4pda.to/forum/index.php?showtopic=1002506");
                return false;
            }
        });
        findPreference("telegram").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this, activity) { // from class: ru.maximoff.apktool.fragment.UpdaterFragment.5

            /* renamed from: a */
            private final UpdaterFragment f15881a;

            /* renamed from: b */
            private final Context f15882b;

            {
                this.f15881a = this;
                this.f15882b = activity;
            }

            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                C3080al.m18595e(this.f15882b, "https://t.me/s/apktool_m");
                return false;
            }
        });
        findPreference("github").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this, activity) { // from class: ru.maximoff.apktool.fragment.UpdaterFragment.6

            /* renamed from: a */
            private final UpdaterFragment f15883a;

            /* renamed from: b */
            private final Context f15884b;

            {
                this.f15883a = this;
                this.f15884b = activity;
            }

            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                C3080al.m18595e(this.f15884b, "https://github.com/Maximoff/Apktool-M-translations");
                return false;
            }
        });
        Preference findPreference = findPreference("plugin_key");
        if (Build.VERSION.SDK_INT >= 19) {
            boolean m19616a = C3262u.m19616a(new StringBuffer().append(activity.getPackageName()).append(".unapkm").toString(), activity.getPackageManager());
            if (m19616a) {
                findPreference.setTitle(R.string.mplugin_installed);
                findPreference.setSummary(R.string.mplugin_installed_summary);
            }
            findPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this, m19616a, activity) { // from class: ru.maximoff.apktool.fragment.UpdaterFragment.7

                /* renamed from: a */
                private final UpdaterFragment f15885a;

                /* renamed from: b */
                private final boolean f15886b;

                /* renamed from: c */
                private final Context f15887c;

                {
                    this.f15885a = this;
                    this.f15886b = m19616a;
                    this.f15887c = activity;
                }

                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    if (this.f15886b) {
                        C3080al.m18601g(this.f15887c, new StringBuffer().append(this.f15887c.getPackageName()).append(".unapkm").toString());
                        return false;
                    }
                    C3080al.m18595e(this.f15887c, new StringBuffer().append(new StringBuffer().append("https://raw.githubusercontent.com/Maximoff/Apktool-M-updates/main/").append("files/UnApkm.apk?t=").toString()).append(System.currentTimeMillis()).toString());
                    return false;
                }
            });
        } else {
            getPreferenceScreen().removePreference(findPreference);
        }
        Preference findPreference2 = findPreference("aeplugin_key");
        boolean m19616a2 = C3262u.m19616a("ru.maximoff.aepatcher", activity.getPackageManager());
        if (m19616a2) {
            findPreference2.setTitle(R.string.aeplugin_installed);
            findPreference2.setSummary(R.string.mplugin_installed_summary);
        }
        findPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this, m19616a2, activity) { // from class: ru.maximoff.apktool.fragment.UpdaterFragment.8

            /* renamed from: a */
            private final UpdaterFragment f15888a;

            /* renamed from: b */
            private final boolean f15889b;

            /* renamed from: c */
            private final Context f15890c;

            {
                this.f15888a = this;
                this.f15889b = m19616a2;
                this.f15890c = activity;
            }

            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                if (this.f15889b) {
                    C3080al.m18601g(this.f15890c, "ru.maximoff.aepatcher");
                    return false;
                }
                C3080al.m18595e(this.f15890c, new StringBuffer().append(new StringBuffer().append("https://raw.githubusercontent.com/Maximoff/Apktool-M-updates/main/").append("files/AEPatcher.apk?t=").toString()).append(System.currentTimeMillis()).toString());
                return false;
            }
        });
        Preference findPreference3 = findPreference("mpatcher_down");
        String str = "ru.maximoff.sheller";
        boolean m19616a3 = C3262u.m19616a("ru.maximoff.sheller", activity.getPackageManager());
        if (m19616a3) {
            findPreference3.setTitle(R.string.mpatcher_run);
            findPreference3.setSummary(R.string.mpatcher_down_summary);
        }
        findPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this, m19616a3, activity, str) { // from class: ru.maximoff.apktool.fragment.UpdaterFragment.9

            /* renamed from: a */
            private final UpdaterFragment f15891a;

            /* renamed from: b */
            private final boolean f15892b;

            /* renamed from: c */
            private final Context f15893c;

            /* renamed from: d */
            private final String f15894d;

            {
                this.f15891a = this;
                this.f15892b = m19616a3;
                this.f15893c = activity;
                this.f15894d = str;
            }

            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                if (this.f15892b) {
                    C3080al.m18599f(this.f15893c, this.f15894d);
                    return false;
                }
                C3080al.m18595e(this.f15893c, new StringBuffer().append(new StringBuffer().append("https://raw.githubusercontent.com/Maximoff/Apktool-M-updates/main/").append("files/MPatcher.apk?t=").toString()).append(System.currentTimeMillis()).toString());
                return false;
            }
        });
    }

    @Override // ru.maximoff.apktool.fragment.AbstractFragmentC2996c
    /* renamed from: a */
    protected int mo17609a() {
        return R.string.mupdate_pref;
    }
}
