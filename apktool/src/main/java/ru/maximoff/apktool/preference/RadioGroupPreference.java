package ru.maximoff.apktool.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.provider.Settings;
import android.util.AttributeSet;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3252l;
import ru.maximoff.apktool.util.C3262u;

/* loaded from: classes.dex */
public class RadioGroupPreference extends CustomPreference {

    /* renamed from: a */
    private int f17020a;

    /* renamed from: b */
    private String f17021b;

    /* renamed from: c */
    private String[] f17022c;

    /* renamed from: d */
    private String[] f17023d;

    public RadioGroupPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    private boolean m18126a() {
        Context context = getContext();
        String key = getKey();
        if (key.equals(Settings.System.DATE_FORMAT)) {
            this.f17020a = R.string.date_format;
            this.f17021b = "yyyy/MM/dd HH:mm";
            this.f17023d = context.getResources().getStringArray(R.array.date_variants);
            this.f17022c = new String[this.f17023d.length];
            for (int i = 0; i < this.f17023d.length; i++) {
                this.f17022c[i] = C3112bn.m19032g(this.f17023d[i]);
            }
            return this.f17022c.length == this.f17023d.length;
        }
        if (key.equals("lang")) {
            this.f17020a = R.string.LangDialogTitle;
            this.f17021b = "en";
            this.f17022c = context.getResources().getStringArray(R.array.entries_lang);
            this.f17023d = context.getResources().getStringArray(R.array.values_lang);
            return this.f17022c.length == this.f17023d.length;
        }
        if (key.equals("auto_save")) {
            this.f17020a = R.string.auto_save_title;
            this.f17021b = "15";
            this.f17022c = context.getResources().getStringArray(R.array.auto_save_variants);
            this.f17023d = context.getResources().getStringArray(R.array.auto_save_values);
            return this.f17022c.length == this.f17023d.length;
        }
        if (key.equals("editor_theme")) {
            this.f17020a = R.string.editor_cs;
            this.f17021b = "new";
            String[] stringArray = context.getResources().getStringArray(R.array.editor_themes);
            String[] stringArray2 = context.getResources().getStringArray(R.array.editor_themes_values);
            String[] m18127a = m18127a(stringArray2);
            this.f17022c = m18128a(stringArray, m18127a);
            this.f17023d = m18128a(stringArray2, m18127a);
            return this.f17022c.length == this.f17023d.length;
        }
        if (key.equals("default_key")) {
            this.f17020a = R.string.default_key;
            this.f17021b = "testkey";
            this.f17022c = context.getResources().getStringArray(R.array.keys);
            this.f17023d = context.getResources().getStringArray(R.array.keys);
            return this.f17022c.length == this.f17023d.length;
        }
        if (key.equals("menu_position")) {
            this.f17020a = R.string.menu_position;
            this.f17021b = "1";
            this.f17022c = context.getResources().getStringArray(R.array.menu_pos);
            this.f17023d = context.getResources().getStringArray(R.array.menu_pos_values);
            return this.f17022c.length == this.f17023d.length;
        }
        if (key.equals("screen_orientation")) {
            this.f17020a = R.string.screen_orientation;
            this.f17021b = "0";
            this.f17022c = context.getResources().getStringArray(R.array.orientation_variants);
            this.f17023d = context.getResources().getStringArray(R.array.orientation_values);
            return this.f17022c.length == this.f17023d.length;
        }
        if (key.equals("file_size")) {
            this.f17020a = R.string.file_size;
            this.f17021b = "0";
            this.f17022c = context.getResources().getStringArray(R.array.file_size);
            this.f17023d = context.getResources().getStringArray(R.array.file_size_values);
            return this.f17022c.length == this.f17023d.length;
        }
        if (key.equals("xml_format_type")) {
            this.f17020a = R.string.editor_xml_format;
            this.f17021b = "0";
            this.f17022c = context.getResources().getStringArray(R.array.xml_format_variants);
            this.f17023d = context.getResources().getStringArray(R.array.xml_format_values);
            return this.f17022c.length == this.f17023d.length;
        }
        if (key.equals("app_theme")) {
            this.f17020a = R.string.app_theme;
            this.f17021b = "0";
            this.f17022c = context.getResources().getStringArray(R.array.app_theme);
            this.f17023d = context.getResources().getStringArray(R.array.app_theme_values);
            return this.f17022c.length == this.f17023d.length;
        }
        if (key.equals("ds_display")) {
            this.f17020a = R.string.ds_display;
            this.f17021b = "0";
            this.f17022c = context.getResources().getStringArray(R.array.ds_display_items);
            this.f17023d = context.getResources().getStringArray(R.array.ds_display_values);
            return this.f17022c.length == this.f17023d.length;
        }
        if (key.equals("user_cache")) {
            this.f17020a = R.string.user_cache;
            String[] m18597e = C3080al.m18597e(context);
            this.f17023d = m18597e;
            this.f17022c = m18597e;
            this.f17021b = this.f17022c[0];
            return true;
        }
        if (!key.equals("install_opt")) {
            return false;
        }
        this.f17020a = R.string.install_options;
        this.f17021b = "0";
        this.f17022c = new String[]{context.getString(R.string.both_options), context.getString(R.string.install), context.getString(R.string.install_session)};
        this.f17023d = new String[]{"0", "1", "2"};
        return true;
    }

    @Override // android.preference.Preference
    protected void onClick() {
        int i;
        File file;
        if (m18126a()) {
            Context context = getContext();
            String key = getKey();
            String string = getSharedPreferences().getString(key, this.f17021b);
            int i2 = 0;
            while (true) {
                if (i2 >= this.f17023d.length) {
                    i = -1;
                    break;
                } else {
                    if (this.f17023d[i2].equals(string)) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
            }
            if (key.equals("user_cache")) {
                file = new C3252l(context).m19508b();
            } else {
                file = (File) null;
            }
            DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(context);
            aVar.m418a(this.f17020a);
            aVar.m420a(R.string.close_cur, (DialogInterface.OnClickListener) null);
            if (!key.equals("lang") && !key.equals("app_theme")) {
                aVar.m440c(R.string.search_reset, new DialogInterface.OnClickListener(this, key, context, string, file) { // from class: ru.maximoff.apktool.preference.RadioGroupPreference.1

                    /* renamed from: a */
                    private final RadioGroupPreference f17024a;

                    /* renamed from: b */
                    private final String f17025b;

                    /* renamed from: c */
                    private final Context f17026c;

                    /* renamed from: d */
                    private final String f17027d;

                    /* renamed from: e */
                    private final File f17028e;

                    {
                        this.f17024a = this;
                        this.f17025b = key;
                        this.f17026c = context;
                        this.f17027d = string;
                        this.f17028e = file;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        if (this.f17025b.equals("editor_theme")) {
                            try {
                                for (File file2 : new File(this.f17026c.getFilesDir(), "theme").listFiles()) {
                                    file2.delete();
                                }
                            } catch (Exception e2) {
                            }
                            C3102bd.f18320c = true;
                        }
                        this.f17024a.getSharedPreferences().edit().putString(this.f17025b, this.f17024a.f17021b).commit();
                        if (!this.f17024a.f17021b.equals(this.f17027d) && this.f17028e != null && this.f17028e.isFile()) {
                            C3262u.m19613a(this.f17028e, new File(new StringBuffer().append(new StringBuffer().append(this.f17024a.f17021b).append(File.separator).toString()).append(this.f17028e.getName()).toString()), true);
                        }
                        dialogInterface.dismiss();
                    }
                });
            }
            aVar.m430a(this.f17022c, i, new DialogInterface.OnClickListener(this, key, string, file) { // from class: ru.maximoff.apktool.preference.RadioGroupPreference.2

                /* renamed from: a */
                private final RadioGroupPreference f17029a;

                /* renamed from: b */
                private final String f17030b;

                /* renamed from: c */
                private final String f17031c;

                /* renamed from: d */
                private final File f17032d;

                {
                    this.f17029a = this;
                    this.f17030b = key;
                    this.f17031c = string;
                    this.f17032d = file;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    String str = this.f17029a.f17023d[i3];
                    this.f17029a.getSharedPreferences().edit().putString(this.f17030b, str).commit();
                    if (!str.equals(this.f17031c) && this.f17032d != null && this.f17032d.isFile()) {
                        C3262u.m19613a(this.f17032d, new File(new StringBuffer().append(new StringBuffer().append(str).append(File.separator).toString()).append(this.f17032d.getName()).toString()), true);
                    }
                    dialogInterface.dismiss();
                }
            });
            aVar.m438b().show();
        }
    }

    /* renamed from: a */
    private String[] m18127a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = new File(getContext().getFilesDir(), "theme").listFiles(new FilenameFilter(this) { // from class: ru.maximoff.apktool.preference.RadioGroupPreference.3

            /* renamed from: a */
            private final RadioGroupPreference f17033a;

            {
                this.f17033a = this;
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.endsWith(".json");
            }
        });
        if (listFiles != null) {
            for (File file : listFiles) {
                String substring = file.getName().substring(0, r4.getName().length() - 5);
                if (!C3080al.m18585b(strArr, substring)) {
                    arrayList.add(substring);
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: a */
    private String[] m18128a(String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(str);
        }
        for (String str2 : strArr2) {
            arrayList.add(str2);
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
