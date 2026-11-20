package ru.maximoff.apktool;

import android.C0012R;
import android.app.Activity;
import android.app.UiModeManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.p006pm.PackageInfo;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.p008os.Build;
import android.p008os.Bundle;
import android.p008os.Environment;
import android.p008os.Handler;
import android.p008os.Looper;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.widget.Toolbar;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.p209io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.p270e.C2466a;
import org.p270e.C2467b;
import org.p270e.C2468c;
import p046b.p059d.C0542g;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.preference.C3049a;
import ru.maximoff.apktool.util.C3077ai;
import ru.maximoff.apktool.util.C3078aj;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3093ay;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3106bh;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3117bs;
import ru.maximoff.apktool.util.C3220f;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.C3266y;
import ru.maximoff.apktool.util.p303a.C3061a;
import ru.maximoff.apktool.util.p306d.C3212b;
import ru.maximoff.apktool.util.p307e.C3217a;
import ru.maximoff.apktool.util.p307e.C3218b;
import ru.maximoff.apktool.util.p307e.C3219c;
import ru.maximoff.apktool.view.CustomListView;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* loaded from: classes.dex */
public class SettingActivity extends PreferenceActivity {

    /* renamed from: a */
    public static boolean f14219a = false;

    /* renamed from: b */
    public static boolean f14220b = false;

    /* renamed from: c */
    private List<PreferenceActivity.Header> f14221c;

    /* renamed from: d */
    private Toolbar f14222d;

    /* renamed from: e */
    private File f14223e;

    /* renamed from: f */
    private File[] f14224f;

    /* renamed from: h */
    private C3220f f14226h;

    /* renamed from: i */
    private C3093ay f14227i;

    /* renamed from: g */
    private boolean f14225g = false;

    /* renamed from: j */
    private final String f14228j = "history";

    /* renamed from: k */
    private final String[] f14229k = {"translate", "translate_repl", "colors", "colors_repl", "editor_search", "editor_replace", "apps", Logger.GLOBAL_LOGGER_NAME, "global_replace", "rename_template", "rename_search", "rename_replace", "favorites_colors", "aapt2_densities", "aapt2_configurations", "apk_name", "soeditor", "soeditor_repl", "diff_text", "search_filter_files", "axml_editor", "axml_editor_repl", "ic_name", "ric_name"};

    /* renamed from: l */
    private final String[] f14230l = {"plugin_mod_nrm", "scoped_storage_dialog", "optimization_dialog", "new_optimization_dialog", "load_aapts_dialog", "update_skip", "app_killed_dialog", "encript_notice_dialog", "show_miui_dialog", "accessibility_info", "kill_sign_notice", "kill_sign_notice_ex", "installLocation_notice", "show_pipette_info"};

    /* renamed from: m */
    private final String[] f14231m = {"nyholidays", "use_dark_icon"};

    /* renamed from: n */
    private final String[] f14232n = {"pipette_zoom"};

    /* renamed from: o */
    private final String[] f14233o = {"update_last_time", "system_ua_time"};

    @Override // android.app.Activity
    public boolean isDestroyed() {
        if (Build.VERSION.SDK_INT < 17) {
            return !f14219a;
        }
        return super.isDestroyed();
    }

    /* renamed from: a */
    public boolean m16699a() {
        return !f14220b;
    }

    @Override // android.app.Activity
    protected void onStart() {
        f14219a = true;
        super.onStart();
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onStop() {
        f14219a = false;
        super.onStop();
    }

    @Override // android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        f14220b = false;
        super.onDestroy();
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m16676a(intent);
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        m16696f();
        super.onCreate(bundle);
        f14220b = true;
        if (C3102bd.f18301ai.equals("1")) {
            setRequestedOrientation(6);
        } else if (C3102bd.f18301ai.equals("2")) {
            setRequestedOrientation(7);
        } else {
            setRequestedOrientation(-1);
        }
        C3077ai.m18488a(this);
        this.f14224f = m16686b();
        if (getIntent() != null && getIntent().hasExtra("backup_file")) {
            this.f14223e = new File(getIntent().getStringExtra("backup_file"));
            getIntent().removeExtra("backup_file");
            this.f14225g = true;
        } else {
            this.f14223e = this.f14224f[0];
        }
        this.f14226h = new C3220f(this, (InterfaceC2995n) null);
        this.f14227i = new C3093ay(this);
        m16676a(getIntent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public File[] m16686b() {
        File externalStorageDirectory;
        if (C3102bd.f18339v != null) {
            externalStorageDirectory = new File(C3102bd.f18339v);
        } else {
            externalStorageDirectory = Environment.getExternalStorageDirectory();
        }
        File[] listFiles = externalStorageDirectory.listFiles(new FilenameFilter(this) { // from class: ru.maximoff.apktool.SettingActivity.1

            /* renamed from: a */
            private final SettingActivity f14234a;

            {
                this.f14234a = this;
            }

            @Override // java.p209io.FilenameFilter
            public boolean accept(File file, String str) {
                if (str.equalsIgnoreCase("Apktool_M.backup") || str.toLowerCase().matches("^apktool_m\\.\\d+\\.backup$")) {
                    return new File(file, str).isFile();
                }
                return false;
            }
        });
        return (listFiles == null || listFiles.length == 0) ? new File[]{new File(externalStorageDirectory, "Apktool_M.backup")} : listFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean[] m16684a(File file) {
        boolean[] zArr = {false, false, false, false, false};
        try {
            C2604w c2604w = new C2604w(file);
            Enumeration<C2602u> m16163b = c2604w.m16163b();
            while (m16163b.hasMoreElements()) {
                String lowerCase = m16163b.nextElement().getName().toLowerCase();
                if (lowerCase.endsWith(".json")) {
                    zArr[0] = true;
                } else if (lowerCase.endsWith(".amd") || lowerCase.endsWith(".mtd")) {
                    zArr[1] = true;
                } else if (lowerCase.matches("^aapt(_.+)?$")) {
                    zArr[2] = true;
                } else if (lowerCase.matches("^aapt2(_.+)?$")) {
                    zArr[3] = true;
                } else if (lowerCase.endsWith(".apk")) {
                    zArr[4] = true;
                }
            }
            c2604w.close();
            return zArr;
        } catch (Error e2) {
            return new boolean[]{true, true, true, true, true};
        } catch (Exception e3) {
            return new boolean[]{true, true, true, true, true};
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m16700a(configuration);
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        if (this.f14222d != null) {
            this.f14222d.setTitle(charSequence);
        }
    }

    @Override // android.app.Activity
    public void setTitle(int i) {
        if (i != 0) {
            super.setTitle(i);
            if (this.f14222d != null) {
                this.f14222d.setTitle(i);
            }
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        LinearLayout linearLayout = (LinearLayout) findViewById(C0012R.id.list).getParent().getParent().getParent();
        this.f14222d = (Toolbar) LayoutInflater.from(this).inflate(R.layout.settings_toolbar, (ViewGroup) linearLayout, false);
        this.f14222d.m1130a(R.menu.settings);
        this.f14222d.getMenu().getItem(0).setIcon(C3102bd.f18291a ? R.drawable.ic_search : R.drawable.ic_search_dark);
        MenuItem item = this.f14222d.getMenu().getItem(2);
        item.setEnabled(this.f14223e.exists());
        this.f14222d.getMenu().getItem(4).setVisible(Build.VERSION.SDK_INT > 29);
        this.f14222d.getMenu().getItem(5).setVisible(Build.VERSION.SDK_INT >= 23);
        File file = new File(C3102bd.f18280P);
        MenuItem item2 = this.f14222d.getMenu().getItem(9);
        item2.setTitle(String.format("%s (%s)", getString(R.string.clear_preview), C3106bh.m18975a(C3262u.m19668i(this, file), C3102bd.f18305am)));
        ArrayList arrayList = new ArrayList(Arrays.asList(getResources().getStringArray(R.array.backup_values)));
        arrayList.add("aapt");
        arrayList.add("aapt2");
        arrayList.add(getString(R.string.custom_frame));
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        this.f14222d.setOnMenuItemClickListener(new C27742(this, new boolean[strArr.length], 3, strArr, 4, 5, 6, item, file, item2));
        linearLayout.addView(this.f14222d, 0);
        this.f14222d.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.SettingActivity.3

            /* renamed from: a */
            private final SettingActivity f14304a;

            {
                this.f14304a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f14304a.onBackPressed();
            }
        });
        if (this.f14225g) {
            this.f14222d.getMenu().performIdentifierAction(R.id.restore, 0);
        }
    }

    /* renamed from: ru.maximoff.apktool.SettingActivity$2 */
    class C27742 implements Toolbar.InterfaceC0155c {

        /* renamed from: a */
        private final SettingActivity f14235a;

        /* renamed from: b */
        private final boolean[] f14236b;

        /* renamed from: c */
        private final int f14237c;

        /* renamed from: d */
        private final String[] f14238d;

        /* renamed from: e */
        private final int f14239e;

        /* renamed from: f */
        private final int f14240f;

        /* renamed from: g */
        private final int f14241g;

        /* renamed from: h */
        private final MenuItem f14242h;

        /* renamed from: i */
        private final File f14243i;

        /* renamed from: j */
        private final MenuItem f14244j;

        C27742(SettingActivity settingActivity, boolean[] zArr, int i, String[] strArr, int i2, int i3, int i4, MenuItem menuItem, File file, MenuItem menuItem2) {
            this.f14235a = settingActivity;
            this.f14236b = zArr;
            this.f14237c = i;
            this.f14238d = strArr;
            this.f14239e = i2;
            this.f14240f = i3;
            this.f14241g = i4;
            this.f14242h = menuItem;
            this.f14243i = file;
            this.f14244j = menuItem2;
        }

        /* renamed from: a */
        static SettingActivity m16701a(C27742 c27742) {
            return c27742.f14235a;
        }

        @Override // androidx.appcompat.widget.Toolbar.InterfaceC0155c
        /* renamed from: a */
        public boolean mo1150a(MenuItem menuItem) {
            String str;
            int i = 0;
            switch (menuItem.getItemId()) {
                case R.id.optimize /* 2131690162 */:
                    try {
                        C3102bd.m18917a((Context) this.f14235a, true);
                        break;
                    } catch (Exception e2) {
                        C3112bn.m18999a(this.f14235a, R.string.error);
                        return true;
                    }
                case R.id.search /* 2131690191 */:
                    this.f14235a.m16678a("");
                    break;
                case R.id.backup /* 2131690194 */:
                    if (C3102bd.f18339v == null) {
                        C3112bn.m18999a(this.f14235a, R.string.output_directory_not_set);
                        break;
                    } else {
                        File file = new File(C3102bd.f18339v);
                        if (!file.isDirectory() && !file.mkdirs()) {
                            C3112bn.m18999a(this.f14235a, R.string.output_directory_not_extsts);
                            break;
                        } else {
                            int i2 = 0;
                            while (i2 < this.f14236b.length) {
                                this.f14236b[i2] = i2 < 3;
                                i2++;
                            }
                            DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f14235a).m418a(R.string.backup).m432a(this.f14238d, this.f14236b, new DialogInterface.OnMultiChoiceClickListener(this, this.f14236b) { // from class: ru.maximoff.apktool.SettingActivity.2.1

                                /* renamed from: a */
                                private final C27742 f14245a;

                                /* renamed from: b */
                                private final boolean[] f14246b;

                                {
                                    this.f14245a = this;
                                    this.f14246b = r2;
                                }

                                @Override // android.content.DialogInterface.OnMultiChoiceClickListener
                                public void onClick(DialogInterface dialogInterface, int i3, boolean z) {
                                    this.f14246b[i3] = z;
                                }
                            }).m420a(R.string.backup, new DialogInterface.OnClickListener(this, this.f14236b, this.f14237c, this.f14239e, this.f14240f, this.f14241g, file, this.f14242h) { // from class: ru.maximoff.apktool.SettingActivity.2.2

                                /* renamed from: a */
                                private final C27742 f14253a;

                                /* renamed from: b */
                                private final boolean[] f14254b;

                                /* renamed from: c */
                                private final int f14255c;

                                /* renamed from: d */
                                private final int f14256d;

                                /* renamed from: e */
                                private final int f14257e;

                                /* renamed from: f */
                                private final int f14258f;

                                /* renamed from: g */
                                private final File f14259g;

                                /* renamed from: h */
                                private final MenuItem f14260h;

                                {
                                    this.f14253a = this;
                                    this.f14254b = r2;
                                    this.f14255c = r3;
                                    this.f14256d = r4;
                                    this.f14257e = r5;
                                    this.f14258f = r6;
                                    this.f14259g = file;
                                    this.f14260h = r8;
                                }

                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i3) {
                                    File[] listFiles;
                                    File[] listFiles2;
                                    dialogInterface.dismiss();
                                    try {
                                        PackageInfo packageInfo = C27742.m16701a(this.f14253a).getPackageManager().getPackageInfo(C27742.m16701a(this.f14253a).getPackageName(), 0);
                                        C2468c m16675a = C27742.m16701a(this.f14253a).m16675a(this.f14254b[1], this.f14254b[2]);
                                        File file2 = new File(C3102bd.m18908a(), new StringBuffer().append(new StringBuffer().append("backup_").append(packageInfo.versionCode).toString()).append(".json").toString());
                                        C3061a.m18319b(file2, m16675a.m15603a(2));
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.add(file2);
                                        if (this.f14254b[3] && C3102bd.f18339v != null) {
                                            File file3 = new File(C3102bd.f18339v, "dictionary");
                                            if ((file3.exists() || file3.isDirectory()) && (listFiles2 = file3.listFiles(new FilenameFilter(this) { // from class: ru.maximoff.apktool.SettingActivity.2.2.1

                                                /* renamed from: a */
                                                private final AnonymousClass2 f14261a;

                                                {
                                                    this.f14261a = this;
                                                }

                                                @Override // java.p209io.FilenameFilter
                                                public boolean accept(File file4, String str2) {
                                                    return str2.toLowerCase().endsWith(".amd") || str2.toLowerCase().endsWith(".mtd");
                                                }
                                            })) != null) {
                                                for (File file4 : listFiles2) {
                                                    File file5 = new File(C3102bd.m18908a(), file4.getName());
                                                    C3262u.m19612a(file4, file5);
                                                    arrayList.add(file5);
                                                }
                                            }
                                        }
                                        if (this.f14254b[4]) {
                                            File file6 = new File(C3102bd.f18321d);
                                            File file7 = new File(C3102bd.m18908a(), file6.getName());
                                            C3262u.m19612a(file6, file7);
                                            arrayList.add(file7);
                                        }
                                        if (this.f14254b[5]) {
                                            File file8 = new File(C3102bd.f18278N);
                                            File file9 = new File(C3102bd.m18908a(), file8.getName());
                                            C3262u.m19612a(file8, file9);
                                            arrayList.add(file9);
                                        }
                                        if (this.f14254b[6]) {
                                            File file10 = new File(C3102bd.f18323f);
                                            if ((file10.exists() || file10.isDirectory()) && (listFiles = file10.listFiles(new FilenameFilter(this) { // from class: ru.maximoff.apktool.SettingActivity.2.2.2

                                                /* renamed from: a */
                                                private final AnonymousClass2 f14262a;

                                                {
                                                    this.f14262a = this;
                                                }

                                                @Override // java.p209io.FilenameFilter
                                                public boolean accept(File file11, String str2) {
                                                    return str2.toLowerCase().endsWith(".apk");
                                                }
                                            })) != null) {
                                                for (File file11 : listFiles) {
                                                    File file12 = new File(C3102bd.m18908a(), file11.getName());
                                                    C3262u.m19612a(file11, file12);
                                                    arrayList.add(file12);
                                                }
                                            }
                                        }
                                        C27742.m16701a(this.f14253a).f14223e = new File(this.f14259g, String.format("Apktool_M.%s.backup", C3112bn.m19032g("yyyyMMddHHmmss")));
                                        C3117bs.m19067a((File[]) arrayList.toArray(new File[arrayList.size()]), C27742.m16701a(this.f14253a).f14223e.getAbsolutePath(), 5);
                                        Iterator<E> it = arrayList.iterator();
                                        while (it.hasNext()) {
                                            ((File) it.next()).delete();
                                        }
                                        C3112bn.m19023b(C27742.m16701a(this.f14253a), C27742.m16701a(this.f14253a).getString(R.string.extraction, C27742.m16701a(this.f14253a).f14223e.getAbsolutePath()));
                                    } catch (Exception e3) {
                                        C3112bn.m19023b(C27742.m16701a(this.f14253a), C27742.m16701a(this.f14253a).getString(R.string.err_save, e3.getMessage()));
                                    }
                                    C27742.m16701a(this.f14253a).f14224f = C27742.m16701a(this.f14253a).m16686b();
                                    this.f14260h.setEnabled(C27742.m16701a(this.f14253a).f14223e.exists());
                                }
                            }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
                            m438b.setOnShowListener(new DialogInterface.OnShowListener(this, m438b) { // from class: ru.maximoff.apktool.SettingActivity.2.3

                                /* renamed from: a */
                                private final C27742 f14263a;

                                /* renamed from: b */
                                private final DialogInterfaceC0070b f14264b;

                                {
                                    this.f14263a = this;
                                    this.f14264b = m438b;
                                }

                                @Override // android.content.DialogInterface.OnShowListener
                                public void onShow(DialogInterface dialogInterface) {
                                    CheckedTextView checkedTextView = (CheckedTextView) this.f14264b.m415a().getChildAt(0);
                                    checkedTextView.setEnabled(false);
                                    checkedTextView.setOnClickListener((View.OnClickListener) null);
                                }
                            });
                            m438b.show();
                            break;
                        }
                    }
                    break;
                case R.id.exit /* 2131690197 */:
                    this.f14235a.finish();
                    break;
                case R.id.smali_help /* 2131690250 */:
                    try {
                        C3080al.m18609k(this.f14235a, (String) null);
                        break;
                    } catch (Exception e3) {
                        C3112bn.m18999a(this.f14235a, R.string.error);
                        return true;
                    }
                case R.id.restore /* 2131690298 */:
                    AnonymousClass4 anonymousClass4 = new AnonymousClass4(this, this.f14236b, this.f14237c, this.f14239e, this.f14240f, this.f14241g, this.f14238d);
                    if (this.f14235a.f14224f.length > 1 && !this.f14235a.f14225g) {
                        String[] strArr = new String[this.f14235a.f14224f.length];
                        while (i < this.f14235a.f14224f.length) {
                            strArr[i] = this.f14235a.f14224f[i].getName();
                            i++;
                        }
                        new DialogInterfaceC0070b.a(this.f14235a).m418a(R.string.restore).m431a(strArr, new DialogInterface.OnClickListener(this, anonymousClass4) { // from class: ru.maximoff.apktool.SettingActivity.2.5

                            /* renamed from: a */
                            private final C27742 f14288a;

                            /* renamed from: b */
                            private final Runnable f14289b;

                            {
                                this.f14288a = this;
                                this.f14289b = anonymousClass4;
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                dialogInterface.cancel();
                                C27742.m16701a(this.f14288a).f14223e = C27742.m16701a(this.f14288a).f14224f[i3];
                                this.f14289b.run();
                            }
                        }).m420a(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
                        break;
                    } else {
                        anonymousClass4.run();
                        break;
                    }
                    break;
                case R.id.heap /* 2131690299 */:
                    Handler handler = new Handler(Looper.getMainLooper());
                    C3266y c3266y = new C3266y();
                    DialogInterfaceC0070b m438b2 = new DialogInterfaceC0070b.a(this.f14235a).m418a(R.string.heap_memory).m436b(this.f14235a.getString(R.string.heap_info, new Long(c3266y.m19709a()), new Long(c3266y.m19711c()), new Long(c3266y.m19710b()))).m420a(R.string.f21470ok, (DialogInterface.OnClickListener) null).m434b(R.string.copy, (DialogInterface.OnClickListener) null).m440c(R.string.minfo, (DialogInterface.OnClickListener) null).m438b();
                    m438b2.setOnShowListener(new AnonymousClass6(this, m438b2, handler));
                    m438b2.setOnCancelListener(new DialogInterface.OnCancelListener(this, handler) { // from class: ru.maximoff.apktool.SettingActivity.2.7

                        /* renamed from: a */
                        private final C27742 f14300a;

                        /* renamed from: b */
                        private final Handler f14301b;

                        {
                            this.f14300a = this;
                            this.f14301b = handler;
                        }

                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            this.f14301b.removeCallbacksAndMessages((Object) null);
                        }
                    });
                    m438b2.show();
                    break;
                case R.id.scoped /* 2131690300 */:
                    String[] m18596e = C3080al.m18596e();
                    try {
                        Intent intent = new Intent(m18596e[0]);
                        intent.addCategory(Intent.CATEGORY_DEFAULT);
                        intent.setData(Uri.parse(String.format("package:%s", this.f14235a.getPackageName())));
                        this.f14235a.startActivity(intent);
                        break;
                    } catch (Exception e4) {
                        try {
                            Intent intent2 = new Intent();
                            intent2.setAction(m18596e[1]);
                            this.f14235a.startActivity(intent2);
                            return true;
                        } catch (Exception e5) {
                            C3112bn.m18999a(this.f14235a, R.string.error);
                            return true;
                        }
                    }
                case R.id.reset_files /* 2131690301 */:
                    new C3078aj(this.f14235a).m18494a(R.string.reset_files).m18500b(R.string.mreset_app_files).m18495a(R.string.search_reset, new Runnable(this) { // from class: ru.maximoff.apktool.SettingActivity.2.8

                        /* renamed from: a */
                        private final C27742 f14302a;

                        {
                            this.f14302a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            C3102bd.m18913a((Activity) C27742.m16701a(this.f14302a));
                        }
                    }).m18508e(R.string.cancel).m18507d();
                    break;
                case R.id.reset_settings /* 2131690302 */:
                    new C3078aj(this.f14235a).m18494a(R.string.reset_settings).m18500b(R.string.mreset_app_settings).m18495a(R.string.search_reset, new Runnable(this) { // from class: ru.maximoff.apktool.SettingActivity.2.9

                        /* renamed from: a */
                        private final C27742 f14303a;

                        {
                            this.f14303a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            C27742.m16701a(this.f14303a).m16698g();
                        }
                    }).m18508e(R.string.cancel).m18507d();
                    break;
                case R.id.reset_remind /* 2131690303 */:
                    String[] strArr2 = this.f14235a.f14230l;
                    while (i < strArr2.length) {
                        C3102bd.m18924a(this.f14235a, strArr2[i]);
                        i++;
                    }
                    C3112bn.m18999a(this.f14235a, R.string.success);
                    break;
                case R.id.clear_preview /* 2131690304 */:
                    C0542g.m3987a(this.f14243i);
                    this.f14243i.mkdir();
                    this.f14244j.setTitle(String.format("%s (%s)", this.f14235a.getString(R.string.clear_preview), C3106bh.m18975a(C3262u.m19668i(this.f14235a, this.f14243i), C3102bd.f18305am)));
                    C3112bn.m18999a(this.f14235a, R.string.success);
                    break;
                case R.id.create_logcat /* 2131690305 */:
                    try {
                        if (C3102bd.f18339v == null) {
                            str = Environment.getExternalStorageDirectory().getAbsolutePath();
                        } else {
                            str = C3102bd.f18339v;
                        }
                        String format = String.format("%s/Apktool_M_LogCat_%d_%s.txt", str, new Integer(this.f14235a.getPackageManager().getPackageInfo(this.f14235a.getPackageName(), 0).versionCode), C3112bn.m19032g("yyyyMMdd_HHmmss"));
                        if (C3080al.m18568a(new File(format))) {
                            C3112bn.m19023b(this.f14235a, this.f14235a.getString(R.string.extraction, format));
                            break;
                        } else {
                            C3112bn.m18999a(this.f14235a, R.string.error);
                            break;
                        }
                    } catch (Exception e6) {
                        C3112bn.m18999a(this.f14235a, R.string.error);
                        return true;
                    }
                case R.id.license_agreement /* 2131690306 */:
                    C3102bd.m18916a(this.f14235a, (Runnable) null, (Runnable) null, true);
                    break;
                case R.id.comp_stats /* 2131690307 */:
                    String string = this.f14235a.getString(R.string.comp_stats_info, C3080al.m18572a((Context) this.f14235a));
                    DialogInterfaceC0070b m438b3 = new DialogInterfaceC0070b.a(this.f14235a).m418a(R.string.comp_stats).m436b(string).m420a(R.string.f21470ok, (DialogInterface.OnClickListener) null).m434b(R.string.copy, (DialogInterface.OnClickListener) null).m440c(R.string.search_reset, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.SettingActivity.2.10

                        /* renamed from: a */
                        private final C27742 f14247a;

                        {
                            this.f14247a = this;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            new File(C27742.m16701a(this.f14247a).getFilesDir(), ".stats").delete();
                            dialogInterface.cancel();
                        }
                    }).m438b();
                    m438b3.setOnShowListener(new AnonymousClass11(this, m438b3, string));
                    m438b3.show();
                    break;
            }
            return false;
        }

        /* renamed from: ru.maximoff.apktool.SettingActivity$2$4, reason: invalid class name */
        class AnonymousClass4 implements Runnable {

            /* renamed from: a */
            private final C27742 f14265a;

            /* renamed from: b */
            private final boolean[] f14266b;

            /* renamed from: c */
            private final int f14267c;

            /* renamed from: d */
            private final int f14268d;

            /* renamed from: e */
            private final int f14269e;

            /* renamed from: f */
            private final int f14270f;

            /* renamed from: g */
            private final String[] f14271g;

            AnonymousClass4(C27742 c27742, boolean[] zArr, int i, int i2, int i3, int i4, String[] strArr) {
                this.f14265a = c27742;
                this.f14266b = zArr;
                this.f14267c = i;
                this.f14268d = i2;
                this.f14269e = i3;
                this.f14270f = i4;
                this.f14271g = strArr;
            }

            /* renamed from: a */
            static C27742 m16703a(AnonymousClass4 anonymousClass4) {
                return anonymousClass4.f14265a;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!C27742.m16701a(this.f14265a).f14223e.exists()) {
                    C3112bn.m19023b(C27742.m16701a(this.f14265a), C27742.m16701a(this.f14265a).getString(R.string.file_not_found, C27742.m16701a(this.f14265a).f14223e.getAbsolutePath()));
                    return;
                }
                boolean[] m16684a = C27742.m16701a(this.f14265a).m16684a(C27742.m16701a(this.f14265a).f14223e);
                for (int i = 0; i < this.f14266b.length; i++) {
                    this.f14266b[i] = true;
                    if (i < 3 && !m16684a[0]) {
                        this.f14266b[i] = false;
                    }
                    if (i == 3 && !m16684a[1]) {
                        this.f14266b[i] = false;
                    }
                    if (i == 4 && !m16684a[2]) {
                        this.f14266b[i] = false;
                    }
                    if (i == 5 && !m16684a[3]) {
                        this.f14266b[i] = false;
                    }
                    if (i == 6 && !m16684a[4]) {
                        this.f14266b[i] = false;
                    }
                }
                Button[] buttonArr = new Button[1];
                DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(C27742.m16701a(this.f14265a)).m427a(C27742.m16701a(this.f14265a).f14223e.getName()).m432a(this.f14271g, this.f14266b, new DialogInterface.OnMultiChoiceClickListener(this, this.f14266b, buttonArr) { // from class: ru.maximoff.apktool.SettingActivity.2.4.1

                    /* renamed from: a */
                    private final AnonymousClass4 f14272a;

                    /* renamed from: b */
                    private final boolean[] f14273b;

                    /* renamed from: c */
                    private final Button[] f14274c;

                    {
                        this.f14272a = this;
                        this.f14273b = r2;
                        this.f14274c = buttonArr;
                    }

                    @Override // android.content.DialogInterface.OnMultiChoiceClickListener
                    public void onClick(DialogInterface dialogInterface, int i2, boolean z) {
                        boolean z2;
                        this.f14273b[i2] = z;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= this.f14273b.length) {
                                z2 = false;
                                break;
                            } else if (!this.f14273b[i3]) {
                                i3++;
                            } else {
                                z2 = true;
                                break;
                            }
                        }
                        if (this.f14274c[0] != null) {
                            this.f14274c[0].setEnabled(z2);
                        }
                    }
                }).m420a(R.string.restore, new DialogInterface.OnClickListener(this, this.f14266b, this.f14267c, this.f14268d, this.f14269e, this.f14270f) { // from class: ru.maximoff.apktool.SettingActivity.2.4.2

                    /* renamed from: a */
                    private final AnonymousClass4 f14275a;

                    /* renamed from: b */
                    private final boolean[] f14276b;

                    /* renamed from: c */
                    private final int f14277c;

                    /* renamed from: d */
                    private final int f14278d;

                    /* renamed from: e */
                    private final int f14279e;

                    /* renamed from: f */
                    private final int f14280f;

                    {
                        this.f14275a = this;
                        this.f14276b = r2;
                        this.f14277c = r3;
                        this.f14278d = r4;
                        this.f14279e = r5;
                        this.f14280f = r6;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:54:0x0053  */
                    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:66:0x0100  */
                    /* JADX WARN: Removed duplicated region for block: B:68:? A[SYNTHETIC] */
                    @Override // android.content.DialogInterface.OnClickListener
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        File file;
                        dialogInterface.cancel();
                        File file2 = (File) null;
                        try {
                            file = C3262u.m19564a();
                            try {
                                try {
                                    C3117bs.m19062a((Context) C27742.m16701a(AnonymousClass4.m16703a(this.f14275a)), C27742.m16701a(AnonymousClass4.m16703a(this.f14275a)).f14223e, file, (List<String>) null, false);
                                    File[] listFiles = file.listFiles();
                                    if (listFiles != null) {
                                        for (File file3 : listFiles) {
                                            if ((this.f14276b[3] && file3.getName().toLowerCase().endsWith(".amd")) || file3.getName().toLowerCase().endsWith(".mtd")) {
                                                if (C3102bd.f18339v != null) {
                                                    File file4 = new File(C3102bd.f18339v, "dictionary");
                                                    if (!file4.exists() || !file4.isDirectory()) {
                                                        file4.mkdir();
                                                    }
                                                    C3262u.m19612a(file3, new File(file4, C3262u.m19566a(C27742.m16701a(AnonymousClass4.m16703a(this.f14275a)), file4.getAbsolutePath(), file3.getName().substring(0, file3.getName().length() - 4), ".amd", 0)));
                                                }
                                            } else if (file3.getName().endsWith(".json")) {
                                                C27742.m16701a(AnonymousClass4.m16703a(this.f14275a)).m16677a(file3, this.f14276b);
                                            } else if (file3.getName().matches("^aapt(_.+)?$") && this.f14276b[4]) {
                                                File file5 = new File(C3102bd.f18321d);
                                                File file6 = new File(file5.getParentFile(), file3.getName());
                                                file5.delete();
                                                C3262u.m19612a(file3, file6);
                                                file6.setExecutable(true);
                                                C3102bd.f18321d = file6.getAbsolutePath();
                                            } else if (file3.getName().matches("^aapt2(_.+)?$") && this.f14276b[5]) {
                                                File file7 = new File(C3102bd.f18278N);
                                                File file8 = new File(file7.getParentFile(), file3.getName());
                                                file7.delete();
                                                C3262u.m19612a(file3, file8);
                                                file8.setExecutable(true);
                                                C3102bd.f18278N = file8.getAbsolutePath();
                                            } else if (file3.getName().toLowerCase().endsWith(".apk") && this.f14276b[6]) {
                                                C3262u.m19612a(file3, new File(C3102bd.f18323f, file3.getName()));
                                            }
                                        }
                                    }
                                    C3112bn.m18999a(C27742.m16701a(AnonymousClass4.m16703a(this.f14275a)), R.string.completed_success);
                                    C27742.m16701a(AnonymousClass4.m16703a(this.f14275a)).recreate();
                                } catch (Exception e2) {
                                    e = e2;
                                    C3112bn.m19023b(C27742.m16701a(AnonymousClass4.m16703a(this.f14275a)), C27742.m16701a(AnonymousClass4.m16703a(this.f14275a)).getString(R.string.errorf, e.getMessage()));
                                    if (file == null) {
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (file != null) {
                                    throw th;
                                }
                                C0542g.m3987a(file);
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            file = file2;
                        } catch (Throwable th2) {
                            th = th2;
                            file = file2;
                            if (file != null) {
                            }
                        }
                        if (file == null) {
                            C0542g.m3987a(file);
                        }
                    }
                }).m434b(R.string.cancel, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.SettingActivity.2.4.3

                    /* renamed from: a */
                    private final AnonymousClass4 f14281a;

                    {
                        this.f14281a = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.cancel();
                    }
                }).m438b();
                m438b.setOnShowListener(new DialogInterface.OnShowListener(this, buttonArr, m438b, m16684a, this.f14266b) { // from class: ru.maximoff.apktool.SettingActivity.2.4.4

                    /* renamed from: a */
                    private final AnonymousClass4 f14282a;

                    /* renamed from: b */
                    private final Button[] f14283b;

                    /* renamed from: c */
                    private final DialogInterfaceC0070b f14284c;

                    /* renamed from: d */
                    private final boolean[] f14285d;

                    /* renamed from: e */
                    private final boolean[] f14286e;

                    {
                        this.f14282a = this;
                        this.f14283b = buttonArr;
                        this.f14284c = m438b;
                        this.f14285d = m16684a;
                        this.f14286e = r5;
                    }

                    @Override // android.content.DialogInterface.OnShowListener
                    public void onShow(DialogInterface dialogInterface) {
                        boolean z;
                        this.f14283b[0] = this.f14284c.m414a(-1);
                        int i2 = 0;
                        while (true) {
                            if (i2 < this.f14285d.length) {
                                if (!this.f14285d[i2]) {
                                    i2++;
                                } else {
                                    z = true;
                                    break;
                                }
                            } else {
                                z = false;
                                break;
                            }
                        }
                        if (!z) {
                            this.f14283b[0].setEnabled(z);
                            C3112bn.m18999a(C27742.m16701a(AnonymousClass4.m16703a(this.f14282a)), R.string.not_found);
                        }
                        ListView m415a = this.f14284c.m415a();
                        for (int i3 = 0; i3 < m415a.getChildCount(); i3++) {
                            CheckedTextView checkedTextView = (CheckedTextView) m415a.getChildAt(i3);
                            if (!this.f14286e[i3]) {
                                checkedTextView.setEnabled(false);
                                checkedTextView.setOnClickListener((View.OnClickListener) null);
                            }
                        }
                    }
                });
                m438b.setOnCancelListener(new DialogInterface.OnCancelListener(this) { // from class: ru.maximoff.apktool.SettingActivity.2.4.5

                    /* renamed from: a */
                    private final AnonymousClass4 f14287a;

                    {
                        this.f14287a = this;
                    }

                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        C27742.m16701a(AnonymousClass4.m16703a(this.f14287a)).f14225g = false;
                    }
                });
                m438b.show();
            }
        }

        /* renamed from: ru.maximoff.apktool.SettingActivity$2$6, reason: invalid class name */
        class AnonymousClass6 implements DialogInterface.OnShowListener {

            /* renamed from: a */
            private final C27742 f14290a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f14291b;

            /* renamed from: c */
            private final Handler f14292c;

            AnonymousClass6(C27742 c27742, DialogInterfaceC0070b dialogInterfaceC0070b, Handler handler) {
                this.f14290a = c27742;
                this.f14291b = dialogInterfaceC0070b;
                this.f14292c = handler;
            }

            /* renamed from: a */
            static C27742 m16704a(AnonymousClass6 anonymousClass6) {
                return anonymousClass6.f14290a;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f14291b.m414a(-1).setOnClickListener(new View.OnClickListener(this, this.f14291b) { // from class: ru.maximoff.apktool.SettingActivity.2.6.1

                    /* renamed from: a */
                    private final AnonymousClass6 f14293a;

                    /* renamed from: b */
                    private final DialogInterfaceC0070b f14294b;

                    {
                        this.f14293a = this;
                        this.f14294b = r2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        this.f14294b.cancel();
                    }
                });
                this.f14291b.m414a(-2).setOnClickListener(new View.OnClickListener(this, this.f14291b) { // from class: ru.maximoff.apktool.SettingActivity.2.6.2

                    /* renamed from: a */
                    private final AnonymousClass6 f14295a;

                    /* renamed from: b */
                    private final DialogInterfaceC0070b f14296b;

                    {
                        this.f14295a = this;
                        this.f14296b = r2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TextView textView = (TextView) this.f14296b.findViewById(C0012R.id.message);
                        if (textView != null) {
                            C3112bn.m19002a(C27742.m16701a(AnonymousClass6.m16704a(this.f14295a)), textView.getText().toString());
                        }
                    }
                });
                this.f14291b.m414a(-3).setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.SettingActivity.2.6.3

                    /* renamed from: a */
                    private final AnonymousClass6 f14297a;

                    {
                        this.f14297a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new C3078aj(C27742.m16701a(AnonymousClass6.m16704a(this.f14297a))).m18494a(R.string.minfo).m18504c(R.string.heap_help).m18506d(R.string.f21470ok).m18497a(true).m18507d();
                    }
                });
                TextView textView = (TextView) this.f14291b.findViewById(C0012R.id.message);
                if (textView != null) {
                    this.f14292c.postDelayed(new Runnable(this, textView) { // from class: ru.maximoff.apktool.SettingActivity.2.6.4

                        /* renamed from: a */
                        private final AnonymousClass6 f14298a;

                        /* renamed from: b */
                        private final TextView f14299b;

                        {
                            this.f14298a = this;
                            this.f14299b = textView;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            C3266y c3266y = new C3266y();
                            this.f14299b.setText(C27742.m16701a(AnonymousClass6.m16704a(this.f14298a)).getString(R.string.heap_info, new Long(c3266y.m19709a()), new Long(c3266y.m19711c()), new Long(c3266y.m19710b())));
                        }
                    }, 1000L);
                }
            }
        }

        /* renamed from: ru.maximoff.apktool.SettingActivity$2$11, reason: invalid class name */
        class AnonymousClass11 implements DialogInterface.OnShowListener {

            /* renamed from: a */
            private final C27742 f14248a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f14249b;

            /* renamed from: c */
            private final String f14250c;

            AnonymousClass11(C27742 c27742, DialogInterfaceC0070b dialogInterfaceC0070b, String str) {
                this.f14248a = c27742;
                this.f14249b = dialogInterfaceC0070b;
                this.f14250c = str;
            }

            /* renamed from: a */
            static C27742 m16702a(AnonymousClass11 anonymousClass11) {
                return anonymousClass11.f14248a;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f14249b.m414a(-2).setOnClickListener(new View.OnClickListener(this, this.f14250c) { // from class: ru.maximoff.apktool.SettingActivity.2.11.1

                    /* renamed from: a */
                    private final AnonymousClass11 f14251a;

                    /* renamed from: b */
                    private final String f14252b;

                    {
                        this.f14251a = this;
                        this.f14252b = r2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C3112bn.m19002a(C27742.m16701a(AnonymousClass11.m16702a(this.f14251a)), this.f14252b);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16678a(String str) {
        View inflate = getLayoutInflater().inflate(R.layout.smali_help, (ViewGroup) null);
        CustomListView customListView = (CustomListView) inflate.findViewById(R.id.smalihelpListView1);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.clearText1);
        customListView.setDivider((Drawable) null);
        customListView.setDividerHeight(0);
        customListView.setFastScrollEnabled(C3102bd.f18314av);
        C3219c c3219c = new C3219c(this);
        customListView.setAdapter((ListAdapter) c3219c);
        EditText editText = (EditText) inflate.findViewById(R.id.smalihelpEditText1);
        if (!C3112bn.m19040o(str)) {
            editText.setText(str);
        }
        if (C3102bd.f18291a) {
            imageView.setImageResource(R.drawable.ic_close);
        } else {
            imageView.setImageResource(R.drawable.ic_close_dark);
        }
        imageView.setOnClickListener(new View.OnClickListener(this, editText) { // from class: ru.maximoff.apktool.SettingActivity.4

            /* renamed from: a */
            private final SettingActivity f14305a;

            /* renamed from: b */
            private final EditText f14306b;

            {
                this.f14305a = this;
                this.f14306b = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f14306b.requestFocus();
                this.f14306b.setText("");
            }
        });
        if (editText.getText().length() == 0) {
            imageView.setVisibility(8);
        }
        editText.addTextChangedListener(new TextWatcher(this, imageView, c3219c) { // from class: ru.maximoff.apktool.SettingActivity.5

            /* renamed from: a */
            private final SettingActivity f14307a;

            /* renamed from: b */
            private final ImageView f14308b;

            /* renamed from: c */
            private final C3219c f14309c;

            {
                this.f14307a = this;
                this.f14308b = imageView;
                this.f14309c = c3219c;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0) {
                    this.f14308b.setVisibility(8);
                } else {
                    this.f14308b.setVisibility(0);
                }
                this.f14309c.m19283a(editable.toString());
            }
        });
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this).m418a(R.string.find).m435b(inflate).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, c3219c, m438b, str, editText) { // from class: ru.maximoff.apktool.SettingActivity.6

            /* renamed from: a */
            private final SettingActivity f14310a;

            /* renamed from: b */
            private final C3219c f14311b;

            /* renamed from: c */
            private final DialogInterfaceC0070b f14312c;

            /* renamed from: d */
            private final String f14313d;

            /* renamed from: e */
            private final EditText f14314e;

            {
                this.f14310a = this;
                this.f14311b = c3219c;
                this.f14312c = m438b;
                this.f14313d = str;
                this.f14314e = editText;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f14311b.m19282a(this.f14312c);
                this.f14311b.m19283a(this.f14313d);
                this.f14314e.requestFocus();
                if (C3112bn.m19040o(this.f14313d)) {
                    return;
                }
                this.f14314e.setSelection(this.f14313d.length());
            }
        });
        m438b.show();
    }

    /* renamed from: a */
    private void m16676a(Intent intent) {
        Uri data;
        if (intent != null && Intent.ACTION_VIEW.equals(intent.getAction()) && (data = intent.getData()) != null && "apktool".equals(data.getScheme()) && "settings".equals(data.getHost())) {
            String queryParameter = data.getQueryParameter("key");
            if (queryParameter != null && queryParameter.length() > 0) {
                m16685b(queryParameter);
                return;
            }
            String queryParameter2 = data.getQueryParameter("q");
            if (queryParameter2 == null || queryParameter2.length() == 0) {
                return;
            }
            m16678a(queryParameter2);
        }
    }

    /* renamed from: b */
    private void m16685b(String str) {
        C3217a m19277a = C3218b.m19277a(str, C3080al.m18589c(this));
        if (m19277a != null) {
            try {
                Intent intent = new Intent(this, Class.forName("ru.maximoff.apktool.SettingActivity"));
                intent.putExtra(PreferenceActivity.EXTRA_SHOW_FRAGMENT, m19277a.f19237d.getName());
                intent.putExtra(PreferenceActivity.EXTRA_NO_HEADERS, true);
                intent.putExtra("target_key", m19277a.f19234a);
                startActivity(intent);
                finish();
            } catch (ClassNotFoundException e2) {
                throw new NoClassDefFoundError(e2.getMessage());
            }
        }
    }

    @Override // android.preference.PreferenceActivity
    public void onBuildHeaders(List<PreferenceActivity.Header> list) {
        this.f14221c = list;
        loadHeadersFromResource(R.xml.preference, list);
    }

    @Override // android.preference.PreferenceActivity
    protected boolean isValidFragment(String str) {
        return true;
    }

    @Override // android.preference.PreferenceActivity
    public void onHeaderClick(PreferenceActivity.Header header, int i) {
        super.onHeaderClick(header, i);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        C3080al.m18545a((Activity) this, C3102bd.f18275K);
        if (m16694e()) {
            setTitle(R.string.settings);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.app.ListActivity
    public void setListAdapter(ListAdapter listAdapter) {
        if (this.f14221c == null) {
            this.f14221c = new ArrayList();
            int count = listAdapter.getCount();
            for (int i = 0; i < count; i++) {
                this.f14221c.add((PreferenceActivity.Header) listAdapter.getItem(i));
            }
        }
        super.setListAdapter(new C3049a(this, this.f14221c, R.layout.preference_header_item, true));
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void recreate() {
        C3102bd.m18914a((Context) this);
        C3077ai.m18488a(this);
        super.recreate();
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onBackPressed() {
        if (m16689c()) {
            m16692d();
        } else {
            super.onBackPressed();
        }
    }

    /* renamed from: c */
    private boolean m16689c() {
        Intent intent = getIntent();
        return intent != null && intent.getBooleanExtra(PreferenceActivity.EXTRA_NO_HEADERS, false);
    }

    /* renamed from: d */
    private void m16692d() {
        try {
            Intent intent = new Intent(this, Class.forName("ru.maximoff.apktool.SettingActivity"));
            intent.addFlags(67108864);
            startActivity(intent);
            finish();
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    /* renamed from: e */
    private boolean m16694e() {
        return getFragmentManager().findFragmentById(16908290) == null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m16696f() {
        int i;
        int i2;
        int m18608k = C3080al.m18608k(this);
        if (C3102bd.m18925a((Context) this, "system_theme", true) && Build.VERSION.SDK_INT >= 23) {
            boolean z = ((UiModeManager) getSystemService(Context.UI_MODE_SERVICE)).getNightMode() == 2;
            if ((m18608k == 0) ? z : !z) {
                i = C3080al.m18591d(this, !z);
                C3102bd.m18937b(this, "app_theme", String.valueOf(i));
                switch (i) {
                    case 1:
                        setTheme(R.style.AppTheme);
                        break;
                    case 2:
                        setTheme(R.style.AppThemeBlack);
                        break;
                    default:
                        setTheme(R.style.AppThemeLight);
                        break;
                }
                if (Build.VERSION.SDK_INT < 26) {
                    View decorView = getWindow().getDecorView();
                    int systemUiVisibility = decorView.getSystemUiVisibility();
                    if (i == 0) {
                        i2 = systemUiVisibility | 16;
                    } else {
                        i2 = systemUiVisibility & (-17);
                    }
                    decorView.setSystemUiVisibility(i2);
                    return;
                }
                return;
            }
        }
        i = m18608k;
        switch (i) {
        }
        if (Build.VERSION.SDK_INT < 26) {
        }
    }

    /* renamed from: a */
    public boolean m16700a(Configuration configuration) {
        if (!C3102bd.m18925a((Context) this, "system_theme", true) || configuration == null) {
            C3077ai.m18488a(this);
            return false;
        }
        boolean m18567a = C3080al.m18567a(configuration);
        if (C3102bd.f18291a ? m18567a : !m18567a) {
            C3102bd.m18937b(this, "app_theme", String.valueOf(C3080al.m18591d(this, m18567a ? false : true)));
            C3102bd.f18320c = true;
            recreate();
            return true;
        }
        C3077ai.m18488a(this);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m16698g() {
        PreferenceManager.getDefaultSharedPreferences(this).edit().clear().commit();
        C3112bn.m18999a(this, R.string.completed_success);
        recreate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public C2468c m16675a(boolean z, boolean z2) {
        C2468c c2468c = new C2468c();
        Map<String, ?> all = PreferenceManager.getDefaultSharedPreferences(this).getAll();
        ArrayList<String> arrayList = new ArrayList(all.keySet());
        arrayList.add(this.f14226h.m19287a());
        arrayList.add(this.f14227i.m18776a());
        arrayList.add("history");
        Collections.sort(arrayList);
        for (String str : arrayList) {
            if (!C3080al.m18585b(this.f14231m, str)) {
                if (str.equals(this.f14226h.m19287a()) || str.equals(this.f14227i.m18776a()) || str.equals("history")) {
                    c2468c.m15608a(str, C2468c.f12954b);
                } else {
                    c2468c.m15608a(str, all.get(str));
                }
            }
        }
        if (!this.f14227i.m18784c()) {
            C2466a c2466a = new C2466a();
            Iterator<String> it = this.f14227i.m18785d().iterator();
            while (it.hasNext()) {
                c2466a.m15574a(it.next());
            }
            c2468c.m15608a(this.f14227i.m18776a(), c2466a);
        } else {
            c2468c.m15621k(this.f14227i.m18776a());
        }
        if (z && !this.f14226h.m19298d()) {
            C2466a c2466a2 = new C2466a();
            Iterator<String> it2 = this.f14226h.m19299e().iterator();
            while (it2.hasNext()) {
                c2466a2.m15574a(it2.next());
            }
            c2468c.m15608a(this.f14226h.m19287a(), c2466a2);
        } else {
            c2468c.m15621k(this.f14226h.m19287a());
        }
        if (z2) {
            C2468c c2468c2 = new C2468c();
            String[] strArr = this.f14229k;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= strArr.length) {
                    break;
                }
                String str2 = strArr[i2];
                List<String> m19205b = new C3212b(this, str2).m19205b();
                if (!m19205b.isEmpty()) {
                    C2466a c2466a3 = new C2466a();
                    Iterator<String> it3 = m19205b.iterator();
                    while (it3.hasNext()) {
                        c2466a3.m15574a(it3.next());
                    }
                    c2468c2.m15608a(str2, c2466a3);
                }
                i = i2 + 1;
            }
            if (c2468c2.m15614d() > 0) {
                c2468c.m15608a("history", c2468c2);
            } else {
                c2468c.m15621k("history");
            }
        } else {
            c2468c.m15621k("history");
        }
        return c2468c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16677a(File file, boolean[] zArr) {
        C2466a c2466a;
        C2468c c2468c = new C2468c(C3061a.m18332i(file));
        Iterator<String> m15605a = c2468c.m15605a();
        while (m15605a.hasNext()) {
            String next = m15605a.next();
            if (!C3080al.m18585b(this.f14231m, next)) {
                if (next.equals(this.f14227i.m18776a())) {
                    if (!c2468c.m15619h(next)) {
                        try {
                            c2466a = c2468c.m15615d(next);
                        } catch (C2467b e2) {
                            c2466a = new C2466a(c2468c.m15617f(next));
                        }
                        for (int i = 0; i < c2466a.m15569a(); i++) {
                            this.f14227i.m18781a(c2466a.m15579f(i));
                        }
                    }
                } else if (zArr[1] && next.equals(this.f14226h.m19287a())) {
                    if (!c2468c.m15619h(next)) {
                        C2466a m15615d = c2468c.m15615d(next);
                        for (int i2 = 0; i2 < m15615d.m15569a(); i2++) {
                            this.f14226h.m19294b(m15615d.m15579f(i2));
                        }
                    }
                } else if (zArr[2] && next.equals("history")) {
                    if (!c2468c.m15619h(next)) {
                        C2468c m15616e = c2468c.m15616e(next);
                        Iterator<String> m15605a2 = m15616e.m15605a();
                        while (m15605a2.hasNext()) {
                            String next2 = m15605a2.next();
                            if (m16690c(next2)) {
                                C3212b c3212b = new C3212b(this, next2);
                                C2466a m15615d2 = m15616e.m15615d(next2);
                                for (int i3 = 0; i3 < m15615d2.m15569a(); i3++) {
                                    c3212b.m19204a(m15615d2.m15579f(i3));
                                }
                            }
                        }
                    }
                } else if (zArr[0]) {
                    Object m15602a = c2468c.m15602a(next);
                    if (C3080al.m18585b(this.f14232n, next)) {
                        C3102bd.m18934b(this, next, ((Number) m15602a).floatValue());
                    } else if (C3080al.m18585b(this.f14233o, next)) {
                        C3102bd.m18936b((Context) this, next, ((Number) m15602a).longValue());
                    } else if (m15602a instanceof String) {
                        C3102bd.m18937b(this, next, (String) m15602a);
                    } else if (m15602a instanceof Boolean) {
                        C3102bd.m18938b(this, next, ((Boolean) m15602a).booleanValue());
                    } else if (m15602a instanceof Integer) {
                        C3102bd.m18935b((Context) this, next, ((Integer) m15602a).intValue());
                    }
                }
            }
        }
    }

    /* renamed from: c */
    private boolean m16690c(String str) {
        for (String str2 : this.f14229k) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
