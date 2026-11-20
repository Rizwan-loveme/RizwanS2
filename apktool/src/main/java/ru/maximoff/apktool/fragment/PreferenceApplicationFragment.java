package ru.maximoff.apktool.fragment;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.p006pm.PackageManager;
import android.p008os.Build;
import android.p008os.Bundle;
import android.p008os.Process;
import android.preference.Preference;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import p046b.p059d.C0542g;
import ru.maximoff.apktool.SettingActivity;
import ru.maximoff.apktool.preference.CheckBoxPreference;
import ru.maximoff.apktool.preference.DualPreference;
import ru.maximoff.apktool.preference.RadioGroupPreference;
import ru.maximoff.apktool.preference.SeekBarPreference;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3257q;

/* loaded from: classes.dex */
public class PreferenceApplicationFragment extends AbstractFragmentC2996c implements SharedPreferences.OnSharedPreferenceChangeListener {
    @Override // ru.maximoff.apktool.fragment.AbstractFragmentC2996c, android.app.Fragment
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str.equals("app_theme") || str.equals("lang") || str.equals("napp_fontsz") || str.equals("screen_orientation")) {
            m17614b();
        }
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.preference_application);
        Activity activity = getActivity();
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTime(new Date());
        int i = calendar.get(5);
        int i2 = calendar.get(2);
        int i3 = calendar.get(1);
        RadioGroupPreference radioGroupPreference = (RadioGroupPreference) findPreference("app_theme");
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("system_theme");
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) findPreference("icons_outline");
        CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) findPreference("open_apk");
        radioGroupPreference.setEnabled(!checkBoxPreference.isChecked());
        checkBoxPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this, radioGroupPreference, checkBoxPreference, activity) { // from class: ru.maximoff.apktool.fragment.PreferenceApplicationFragment.1

            /* renamed from: a */
            private final PreferenceApplicationFragment f15844a;

            /* renamed from: b */
            private final RadioGroupPreference f15845b;

            /* renamed from: c */
            private final CheckBoxPreference f15846c;

            /* renamed from: d */
            private final Context f15847d;

            {
                this.f15844a = this;
                this.f15845b = radioGroupPreference;
                this.f15846c = checkBoxPreference;
                this.f15847d = activity;
            }

            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                this.f15845b.setEnabled(!this.f15846c.isChecked());
                if (!((SettingActivity) this.f15844a.getActivity()).m16700a(this.f15847d.getResources().getConfiguration())) {
                    this.f15844a.m17614b();
                }
                return false;
            }
        });
        checkBoxPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: ru.maximoff.apktool.fragment.PreferenceApplicationFragment.2

            /* renamed from: a */
            private final PreferenceApplicationFragment f15848a;

            {
                this.f15848a = this;
            }

            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                C0542g.m3989a(C3102bd.f18280P);
                new File(C3102bd.f18280P).mkdir();
                return true;
            }
        });
        PackageManager packageManager = activity.getPackageManager();
        String packageName = activity.getPackageName();
        ComponentName componentName = new ComponentName(packageName, new StringBuffer().append(packageName).append(".OpenApk").toString());
        checkBoxPreference3.setChecked(C3080al.m18566a(packageManager, componentName));
        checkBoxPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this, checkBoxPreference3, activity, packageManager, componentName) { // from class: ru.maximoff.apktool.fragment.PreferenceApplicationFragment.3

            /* renamed from: a */
            private final PreferenceApplicationFragment f15849a;

            /* renamed from: b */
            private final CheckBoxPreference f15850b;

            /* renamed from: c */
            private final Context f15851c;

            /* renamed from: d */
            private final PackageManager f15852d;

            /* renamed from: e */
            private final ComponentName f15853e;

            {
                this.f15849a = this;
                this.f15850b = checkBoxPreference3;
                this.f15851c = activity;
                this.f15852d = packageManager;
                this.f15853e = componentName;
            }

            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                boolean isChecked = this.f15850b.isChecked();
                if (Build.VERSION.SDK_INT < 21) {
                    this.f15849a.m17611a(this.f15851c, this.f15852d, this.f15853e, isChecked);
                } else {
                    this.f15852d.setComponentEnabledSetting(this.f15853e, isChecked ? 1 : 2, 1);
                }
                return true;
            }
        });
        ((CheckBoxPreference) findPreference("imgs_backup")).setSummary(activity.getString(R.string.imgs_backup_summary, activity.getString(R.string.invert_color), activity.getString(R.string.monochrome), activity.getString(R.string.pngquant), activity.getString(R.string.dummy_file)));
        CheckBoxPreference checkBoxPreference4 = (CheckBoxPreference) findPreference("drawer_full");
        SeekBarPreference seekBarPreference = (SeekBarPreference) findPreference("drawer_width");
        seekBarPreference.setEnabled(checkBoxPreference4.isChecked() ? false : true);
        checkBoxPreference4.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this, seekBarPreference, checkBoxPreference4) { // from class: ru.maximoff.apktool.fragment.PreferenceApplicationFragment.4

            /* renamed from: a */
            private final PreferenceApplicationFragment f15854a;

            /* renamed from: b */
            private final SeekBarPreference f15855b;

            /* renamed from: c */
            private final CheckBoxPreference f15856c;

            {
                this.f15854a = this;
                this.f15855b = seekBarPreference;
                this.f15856c = checkBoxPreference4;
            }

            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                this.f15855b.setEnabled(!this.f15856c.isChecked());
                return true;
            }
        });
        DualPreference dualPreference = (DualPreference) findPreference("installLocation");
        RadioGroupPreference radioGroupPreference2 = (RadioGroupPreference) findPreference("install_opt");
        if (Build.VERSION.SDK_INT < 21) {
            getPreferenceScreen().removePreference(dualPreference);
            getPreferenceScreen().removePreference(radioGroupPreference2);
        }
        CheckBoxPreference checkBoxPreference5 = (CheckBoxPreference) findPreference("disable_crashes");
        if (!C3080al.m18589c(activity)) {
            getPreferenceScreen().removePreference(checkBoxPreference5);
        }
        ((CheckBoxPreference) findPreference("snowfall")).setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this, i, i2, i3, activity) { // from class: ru.maximoff.apktool.fragment.PreferenceApplicationFragment.5

            /* renamed from: a */
            private final PreferenceApplicationFragment f15857a;

            /* renamed from: b */
            private final int f15858b;

            /* renamed from: c */
            private final int f15859c;

            /* renamed from: d */
            private final int f15860d;

            /* renamed from: e */
            private final Context f15861e;

            {
                this.f15857a = this;
                this.f15858b = i;
                this.f15859c = i2;
                this.f15860d = i3;
                this.f15861e = activity;
            }

            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                if ((this.f15858b > 24 && this.f15859c == 11) || (this.f15858b < 11 && this.f15859c == 0)) {
                    C3102bd.f18320c = true;
                } else {
                    C3112bn.m19023b(this.f15861e, String.format(C3257q.m19519b("MjUvMTIvJWQg8J+OhA=="), new Integer(this.f15860d)));
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17611a(Context context, PackageManager packageManager, ComponentName componentName, boolean z) {
        new DialogInterfaceC0070b.a(context).m418a(R.string.attention).m433b(R.string.program_closed).m420a(R.string.yes, new DialogInterface.OnClickListener(this, packageManager, componentName, z) { // from class: ru.maximoff.apktool.fragment.PreferenceApplicationFragment.6

            /* renamed from: a */
            private final PreferenceApplicationFragment f15862a;

            /* renamed from: b */
            private final PackageManager f15863b;

            /* renamed from: c */
            private final ComponentName f15864c;

            /* renamed from: d */
            private final boolean f15865d;

            {
                this.f15862a = this;
                this.f15863b = packageManager;
                this.f15864c = componentName;
                this.f15865d = z;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                this.f15863b.setComponentEnabledSetting(this.f15864c, this.f15865d ? 1 : 2, 0);
                Process.killProcess(Process.myPid());
                System.exit(0);
            }
        }).m434b(R.string.f21469no, (DialogInterface.OnClickListener) null).m438b().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m17614b() {
        ((SettingActivity) getActivity()).recreate();
    }

    @Override // ru.maximoff.apktool.fragment.AbstractFragmentC2996c
    /* renamed from: a */
    protected int mo17609a() {
        return R.string.application;
    }
}
