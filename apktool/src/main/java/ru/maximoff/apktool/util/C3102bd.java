package ru.maximoff.apktool.util;

import android.C0012R;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.p006pm.PackageInfo;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.p008os.AsyncTask;
import android.p008os.Build;
import android.p008os.Environment;
import android.p008os.Handler;
import android.p008os.Looper;
import android.p008os.PowerManager;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.security.keystore.KeyProperties;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.widget.C0173ao;
import androidx.core.content.C0255a;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.p209io.FileFilter;
import java.p209io.FileOutputStream;
import java.p209io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.p217b.p218a.p219a.C1887e;
import org.p270e.C2466a;
import org.p270e.C2467b;
import p046b.p047a.C0518d;
import p046b.p059d.C0542g;
import ru.maximoff.apktool.ApktoolApplication;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.fragment.p302b.EnumC2989h;
import ru.maximoff.apktool.p296a.C2890j;
import ru.maximoff.apktool.p300e.AsyncTaskC2946q;
import ru.maximoff.apktool.service.C3056b;
import ru.maximoff.apktool.service.C3058d;
import ru.maximoff.apktool.util.p303a.C3061a;

/* compiled from: Settings.java */
/* renamed from: ru.maximoff.apktool.util.bd */
/* loaded from: classes.dex */
public class C3102bd {

    /* renamed from: A */
    public static boolean f18265A;

    /* renamed from: B */
    public static String f18266B;

    /* renamed from: C */
    public static String f18267C;

    /* renamed from: D */
    public static String f18268D;

    /* renamed from: E */
    public static boolean f18269E;

    /* renamed from: F */
    public static boolean f18270F;

    /* renamed from: G */
    public static boolean f18271G;

    /* renamed from: H */
    public static boolean f18272H;

    /* renamed from: I */
    public static boolean f18273I;

    /* renamed from: J */
    public static int f18274J;

    /* renamed from: K */
    public static boolean f18275K;

    /* renamed from: L */
    public static String f18276L;

    /* renamed from: M */
    public static String f18277M;

    /* renamed from: N */
    public static String f18278N;

    /* renamed from: O */
    public static boolean f18279O;

    /* renamed from: P */
    public static String f18280P;

    /* renamed from: Q */
    public static File f18281Q;

    /* renamed from: R */
    public static boolean f18282R;

    /* renamed from: S */
    public static boolean f18283S;

    /* renamed from: T */
    public static boolean f18284T;

    /* renamed from: U */
    public static boolean f18285U;

    /* renamed from: V */
    public static boolean f18286V;

    /* renamed from: W */
    public static boolean f18287W;

    /* renamed from: X */
    public static boolean f18288X;

    /* renamed from: Y */
    public static String f18289Y;

    /* renamed from: Z */
    public static String[] f18290Z;

    /* renamed from: a */
    public static boolean f18291a;

    /* renamed from: aA */
    private static SharedPreferences f18292aA;

    /* renamed from: aa */
    public static String f18293aa;

    /* renamed from: ab */
    public static String f18294ab;

    /* renamed from: ac */
    public static int f18295ac;

    /* renamed from: ad */
    public static int f18296ad;

    /* renamed from: ae */
    public static int f18297ae;

    /* renamed from: af */
    public static int f18298af;

    /* renamed from: ag */
    public static int f18299ag;

    /* renamed from: ah */
    public static int f18300ah;

    /* renamed from: ai */
    public static String f18301ai;

    /* renamed from: aj */
    public static String f18302aj;

    /* renamed from: ak */
    public static boolean f18303ak;

    /* renamed from: al */
    public static boolean f18304al;

    /* renamed from: am */
    public static boolean f18305am;

    /* renamed from: an */
    public static boolean f18306an;

    /* renamed from: ao */
    public static boolean f18307ao;

    /* renamed from: ap */
    public static boolean f18308ap;

    /* renamed from: aq */
    public static boolean f18309aq;

    /* renamed from: ar */
    public static boolean f18310ar;

    /* renamed from: as */
    public static boolean f18311as;

    /* renamed from: at */
    public static boolean f18312at;

    /* renamed from: au */
    public static boolean f18313au;

    /* renamed from: av */
    public static boolean f18314av;

    /* renamed from: aw */
    public static boolean f18315aw;

    /* renamed from: ax */
    public static boolean f18316ax;

    /* renamed from: ay */
    public static boolean[] f18317ay = (boolean[]) null;

    /* renamed from: az */
    private static long f18318az;

    /* renamed from: b */
    public static int f18319b;

    /* renamed from: c */
    public static boolean f18320c;

    /* renamed from: d */
    public static String f18321d;

    /* renamed from: e */
    public static String f18322e;

    /* renamed from: f */
    public static String f18323f;

    /* renamed from: g */
    public static String f18324g;

    /* renamed from: h */
    public static String f18325h;

    /* renamed from: i */
    public static String f18326i;

    /* renamed from: j */
    public static Typeface f18327j;

    /* renamed from: k */
    public static Typeface f18328k;

    /* renamed from: l */
    public static int f18329l;

    /* renamed from: m */
    public static int f18330m;

    /* renamed from: n */
    public static int f18331n;

    /* renamed from: o */
    public static int f18332o;

    /* renamed from: p */
    public static int f18333p;

    /* renamed from: q */
    public static int f18334q;

    /* renamed from: r */
    public static int f18335r;

    /* renamed from: s */
    public static boolean f18336s;

    /* renamed from: t */
    public static String f18337t;

    /* renamed from: u */
    public static C3058d f18338u;

    /* renamed from: v */
    public static String f18339v;

    /* renamed from: w */
    public static boolean f18340w;

    /* renamed from: x */
    public static boolean f18341x;

    /* renamed from: y */
    public static boolean f18342y;

    /* renamed from: z */
    public static boolean f18343z;

    /* renamed from: a */
    public static void m18923a(ApktoolApplication apktoolApplication) {
        long currentTimeMillis = System.currentTimeMillis();
        f18320c = false;
        f18311as = true;
        f18292aA = PreferenceManager.getDefaultSharedPreferences(apktoolApplication);
        f18341x = f18292aA.getBoolean("is_wordwrap", false);
        f18342y = f18292aA.getBoolean("editor_line_num", true);
        f18343z = f18292aA.getBoolean("editor_fix_line_num", false);
        f18265A = f18292aA.getBoolean("keyboard_suggestions", false);
        f18336s = false;
        f18268D = m18952g();
        f18319b = C3080al.m18608k(apktoolApplication);
        f18291a = f18319b == 0;
        int i = f18292aA.getInt("dark_theme", 1);
        switch (f18319b) {
            case 1:
                f18331n = R.style.AppTheme;
                i = 1;
                break;
            case 2:
                i = 2;
                f18331n = R.style.AppThemeBlack;
                break;
            default:
                f18331n = R.style.AppThemeLight;
                break;
        }
        f18292aA.edit().putInt("dark_theme", i).commit();
        f18279O = f18292aA.getBoolean("use_aapt2", true);
        f18332o = f18292aA.getInt("napp_fontsz", 16);
        f18333p = C3080al.m18522a((Context) apktoolApplication, f18332o);
        f18329l = f18292aA.getInt("nfont_size", 14);
        f18296ad = f18292aA.getInt("clear_preview", 7);
        f18330m = C3080al.m18522a((Context) apktoolApplication, f18329l);
        f18274J = Integer.parseInt(f18292aA.getString("auto_save", "15"));
        f18334q = f18292aA.getInt("hl_time", 700);
        f18335r = f18292aA.getInt("editor_indent", 4);
        f18295ac = f18292aA.getInt("buffer_size", 10);
        f18290Z = m18926a(f18292aA);
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (availableProcessors <= 0) {
            availableProcessors = 4;
        }
        f18297ae = f18292aA.getInt("threads_others", availableProcessors);
        f18300ah = f18292aA.getInt("threads_antisplit", availableProcessors);
        f18298af = f18292aA.getInt("threads_smali", Math.min(4, availableProcessors));
        f18299ag = f18292aA.getInt("threads_baksmali", Math.min(6, availableProcessors));
        f18313au = f18292aA.getBoolean("baksmali_registers", false);
        f18272H = f18292aA.getBoolean("show_errors", false);
        f18273I = f18292aA.getBoolean("scrollbar_left", false);
        f18267C = f18292aA.getString("lang", "en");
        f18324g = f18292aA.getString("default_key", "testkey");
        f18276L = f18292aA.getString("editor_theme", "new");
        f18277M = new File(apktoolApplication.getFilesDir(), new StringBuffer().append(new StringBuffer().append("theme/").append(f18276L).toString()).append(".json").toString()).getAbsolutePath();
        f18269E = f18292aA.getBoolean("hide_files", true);
        f18270F = f18292aA.getBoolean("round_icons", false);
        f18271G = f18292aA.getBoolean("dirs_size", false);
        f18275K = f18292aA.getBoolean("screen_on", false);
        f18288X = f18292aA.getBoolean("icons_outline", true);
        f18303ak = f18292aA.getBoolean("refreshing", true);
        f18282R = f18292aA.getBoolean("non_printing_chars", false);
        f18283S = f18292aA.getBoolean("fast_scroll", true);
        f18286V = f18292aA.getBoolean("scaling", true);
        f18304al = f18292aA.getBoolean("editor_hlcolors", true);
        f18287W = f18292aA.getBoolean("disable_syntax", false);
        f18312at = f18292aA.getBoolean("keep_modified_time", true);
        f18314av = f18292aA.getBoolean("scrollbar_files", true);
        f18315aw = f18292aA.getBoolean("ignore_crc", true);
        f18316ax = f18292aA.getBoolean("user_frameworks", false);
        f18327j = Typeface.DEFAULT;
        try {
            f18328k = Typeface.createFromAsset(apktoolApplication.getAssets(), "monospace.ttf");
        } catch (Exception e2) {
            f18328k = Typeface.MONOSPACE;
        }
        f18284T = f18292aA.getBoolean("quick_panel", true);
        f18285U = f18292aA.getBoolean("editor_state", true);
        f18306an = f18292aA.getBoolean("editor_caps", false);
        f18307ao = f18292aA.getBoolean("editor_magnifier", false);
        f18308ap = f18292aA.getBoolean("tooltips_smali", true);
        f18309aq = f18292aA.getBoolean("tooltips_xml", true);
        f18310ar = f18292aA.getBoolean("drawer_fixed", false) && f18292aA.getBoolean("floating_button", true);
        f18266B = f18292aA.getString(Settings.System.DATE_FORMAT, "yyyy/MM/dd HH:mm");
        f18301ai = f18292aA.getString("screen_orientation", "0");
        f18302aj = f18292aA.getString("ds_display", "0");
        f18305am = f18292aA.getString("file_size", "0").equals("1");
        f18281Q = apktoolApplication.getCacheDir();
        m18950f(apktoolApplication);
        f18289Y = f18292aA.getString("system_ua", (String) null);
        f18318az = f18292aA.getLong("system_ua_time", 0L);
        if (currentTimeMillis - f18318az > DateUtils.WEEK_IN_MILLIS) {
            f18289Y = (String) null;
        }
        if (f18289Y == null) {
            try {
                f18289Y = new WebView(apktoolApplication).getSettings().getUserAgentString();
            } catch (Exception e3) {
                f18289Y = "Mozilla/5.0 (Linux; Android 10; Apktool M) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Mobile Safari/537.36";
            }
            m18937b(apktoolApplication, "system_ua", f18289Y);
            m18936b((Context) apktoolApplication, "system_ua_time", currentTimeMillis);
        }
        if (f18324g.equals("releasekey")) {
            m18937b(apktoolApplication, "default_key", "editorkey");
            f18324g = "editorkey";
        }
        C3056b c3056b = new C3056b(apktoolApplication);
        c3056b.m18197a("analysis");
        c3056b.m18194a(321);
        c3056b.m18195a(apktoolApplication.getText(R.string.smali_snalysis), apktoolApplication.getText(R.string.smali_snalysis_desc));
        m18915a(apktoolApplication, apktoolApplication.getAssets(), apktoolApplication.getFilesDir());
        m18932b(apktoolApplication.getFilesDir());
        f18338u = new C3058d(c3056b, C0255a.m1854b(apktoolApplication));
        m18914a((Context) apktoolApplication);
    }

    /* renamed from: a */
    public static String[] m18926a(SharedPreferences sharedPreferences) {
        ArrayList arrayList = new ArrayList();
        try {
            String trim = sharedPreferences.getString("custom_exts", "").trim();
            if (!trim.isEmpty()) {
                String[] split = trim.split(",");
                for (String str : split) {
                    String trim2 = str.trim();
                    if (!trim2.isEmpty()) {
                        arrayList.add(trim2);
                    }
                }
            }
        } catch (Error e2) {
        } catch (Exception e3) {
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: e */
    private static void m18947e(Context context) {
        String string = f18292aA.getString("quick_panel_symbols", (String) null);
        if (string != null) {
            try {
                new C3093ay(context).m18778a(new C2466a(string));
            } catch (C2467b e2) {
            }
            f18292aA.edit().remove("quick_panel_symbols").commit();
        }
    }

    /* renamed from: a */
    public static File m18908a() {
        if (f18292aA == null || f18281Q == null) {
            return (File) null;
        }
        File file = new File(f18292aA.getString("user_cache", f18281Q.getAbsolutePath()));
        if ((!file.isDirectory() || !file.canWrite()) && !file.mkdirs()) {
            f18292aA.edit().remove("user_cache").commit();
            return f18281Q;
        }
        return file;
    }

    /* renamed from: b */
    public static int m18927b() {
        if (f18332o < 10) {
            return f18332o - 3;
        }
        if (f18332o < 15) {
            return f18332o - 4;
        }
        if (f18332o < 20) {
            return f18332o - 5;
        }
        if (f18332o < 30) {
            return f18332o - 6;
        }
        return f18332o - 7;
    }

    /* renamed from: f */
    private static void m18950f(Context context) {
        String str;
        int i;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            i = packageInfo.versionCode;
            str = C3112bn.m19017b((CharSequence) packageInfo.versionName);
        } catch (Exception e2) {
            str = "2.4.0";
            i = Integer.MAX_VALUE;
        }
        f18293aa = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(str).append("(").toString()).append(i).toString()).append(")").toString();
        f18294ab = str;
    }

    /* renamed from: a */
    public static String m18909a(Context context, int i, String[] strArr) {
        String absolutePath;
        if (strArr != null && strArr.length > i) {
            absolutePath = strArr[i];
        } else {
            absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        return m18910a(context, new StringBuffer().append("home_dir").append(i > 0 ? new StringBuffer().append("_").append(i).toString() : "").toString(), absolutePath);
    }

    /* renamed from: a */
    public static void m18914a(Context context) {
        if (f18292aA == null) {
            f18292aA = PreferenceManager.getDefaultSharedPreferences(context);
        }
        m18947e(context);
        m18941c(f18292aA, context);
        m18931b(f18292aA, context);
        m18930b(f18292aA);
        EnumC2989h.m17910a(f18292aA.getInt("defaultCompator", 0));
        C0518d c0518d = C0518d.f3579w;
        if (f18279O) {
            c0518d.f3600u = f18278N;
            c0518d.f3601v = 2;
        } else {
            c0518d.f3600u = f18321d;
            c0518d.f3601v = 1;
        }
        if (f18316ax) {
            c0518d.f3598s = f18323f;
        } else {
            c0518d.f3598s = f18322e;
        }
        c0518d.f3580a = m18943c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m18932b(File file) {
        File file2 = new File(file, "thumbnails");
        if (file2.exists() && !file2.isDirectory()) {
            file2.delete();
            file2.mkdir();
        }
        if (!file2.exists()) {
            file2.mkdir();
        }
        f18280P = file2.getAbsolutePath();
        m18912a(f18296ad);
    }

    /* renamed from: a */
    public static void m18912a(int i) {
        File[] listFiles;
        File file = new File(f18280P);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            long currentTimeMillis = System.currentTimeMillis();
            for (File file2 : listFiles) {
                if (TimeUnit.MILLISECONDS.toDays(currentTimeMillis - file2.lastModified()) >= i) {
                    file2.delete();
                }
            }
        }
    }

    /* renamed from: c */
    public static boolean m18943c() {
        String m19572a = C3262u.m19572a(f18278N, KeyProperties.DIGEST_SHA1);
        if (m19572a != null) {
            return C3080al.m18585b(new String[]{"71c0e1907d5dbd2416ef810dbf1fdeb241ae98ab", "8505b44fe50c1987995a34ff93bc6f4defbeb48e", "382e3f3e997e06f9ffa49e8326eb779757027a32", "9ed5c07cbfa6de069d6221b2acbae7451eb310e7", "baddfd89740c4b0d9c77e2b9a9f3866325e6504f"}, m19572a);
        }
        return false;
    }

    /* renamed from: d */
    public static boolean m18946d() {
        File[] listFiles;
        File file = new File(f18323f);
        return file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0;
    }

    /* renamed from: a */
    public static boolean m18924a(Context context, String str) {
        if (f18292aA == null) {
            f18292aA = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return f18292aA.edit().remove(str).commit();
    }

    /* renamed from: a */
    public static boolean m18925a(Context context, String str, boolean z) {
        if (f18292aA == null) {
            f18292aA = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return f18292aA.getBoolean(str, z);
    }

    /* renamed from: b */
    public static boolean m18938b(Context context, String str, boolean z) {
        if (f18292aA == null) {
            f18292aA = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return f18292aA.edit().putBoolean(str, z).commit();
    }

    /* renamed from: a */
    public static String m18910a(Context context, String str, String str2) {
        if (f18292aA == null) {
            f18292aA = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return f18292aA.getString(str, str2);
    }

    /* renamed from: b */
    public static boolean m18937b(Context context, String str, String str2) {
        if (f18292aA == null) {
            f18292aA = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return f18292aA.edit().putString(str, str2).commit();
    }

    /* renamed from: a */
    public static int m18905a(Context context, String str, int i) {
        if (f18292aA == null) {
            f18292aA = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return f18292aA.getInt(str, i);
    }

    /* renamed from: b */
    public static boolean m18935b(Context context, String str, int i) {
        if (f18292aA == null) {
            f18292aA = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return f18292aA.edit().putInt(str, i).commit();
    }

    /* renamed from: a */
    public static long m18906a(Context context, String str, long j) {
        if (f18292aA == null) {
            f18292aA = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return f18292aA.getLong(str, j);
    }

    /* renamed from: b */
    public static boolean m18936b(Context context, String str, long j) {
        if (f18292aA == null) {
            f18292aA = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return f18292aA.edit().putLong(str, j).commit();
    }

    /* renamed from: a */
    public static float m18904a(Context context, String str, float f2) {
        if (f18292aA == null) {
            f18292aA = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return f18292aA.getFloat(str, f2);
    }

    /* renamed from: b */
    public static boolean m18934b(Context context, String str, float f2) {
        if (f18292aA == null) {
            f18292aA = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return f18292aA.edit().putFloat(str, f2).commit();
    }

    /* renamed from: a */
    public static Typeface m18907a(SharedPreferences sharedPreferences, Context context) {
        return sharedPreferences.getBoolean("use_monospace", true) ? f18328k : Typeface.DEFAULT;
    }

    /* renamed from: b */
    private static void m18931b(SharedPreferences sharedPreferences, Context context) {
        int i = sharedPreferences.getInt("nfont_size", 14);
        if (f18329l != i) {
            f18336s = true;
        }
        f18329l = i;
        f18330m = C3080al.m18522a(context, i);
        int parseInt = Integer.parseInt(sharedPreferences.getString("auto_save", "15"));
        if (f18274J != parseInt) {
            f18336s = true;
        }
        f18274J = parseInt;
        boolean z = sharedPreferences.getBoolean("is_wordwrap", false);
        if (f18341x ? !z : z) {
            f18336s = true;
        }
        f18341x = z;
        boolean z2 = sharedPreferences.getBoolean("editor_line_num", true);
        if (f18342y ? !z2 : z2) {
            f18336s = true;
        }
        f18342y = z2;
        boolean z3 = sharedPreferences.getBoolean("editor_fix_line_num", false);
        if (f18343z ? !z3 : z3) {
            f18336s = true;
        }
        f18343z = z3;
        boolean z4 = sharedPreferences.getBoolean("disable_syntax", false);
        if (f18287W ? !z4 : z4) {
            f18336s = true;
        }
        f18287W = z4;
        boolean z5 = sharedPreferences.getBoolean("keyboard_suggestions", false);
        if (f18265A ? !z5 : z5) {
            f18336s = true;
        }
        f18265A = z5;
        boolean z6 = sharedPreferences.getBoolean("non_printing_chars", false);
        if (f18282R ? !z6 : z6) {
            f18336s = true;
        }
        f18282R = z6;
        boolean z7 = sharedPreferences.getBoolean("fast_scroll", true);
        if (f18283S ? !z7 : z7) {
            f18336s = true;
        }
        f18283S = z7;
        boolean z8 = sharedPreferences.getBoolean("scaling", true);
        if (f18286V ? !z8 : z8) {
            f18336s = true;
        }
        f18286V = z8;
        boolean z9 = sharedPreferences.getBoolean("editor_hlcolors", true);
        if (f18304al ? !z9 : z9) {
            f18336s = true;
        }
        f18304al = z9;
        boolean z10 = sharedPreferences.getBoolean("quick_panel", true);
        if (f18284T ? !z10 : z10) {
            f18336s = true;
        }
        f18284T = z10;
        boolean z11 = sharedPreferences.getBoolean("editor_state", true);
        if (f18285U ? !z11 : z11) {
            f18336s = true;
        }
        f18285U = z11;
        boolean z12 = sharedPreferences.getBoolean("editor_caps", false);
        if (f18306an ? !z12 : z12) {
            f18336s = true;
        }
        f18306an = z12;
        boolean z13 = sharedPreferences.getBoolean("editor_magnifier", false);
        if (f18307ao ? !z13 : z13) {
            f18336s = true;
        }
        f18307ao = z13;
        Typeface m18907a = m18907a(sharedPreferences, context);
        if (!f18327j.equals(m18907a)) {
            f18336s = true;
        }
        f18327j = m18907a;
        boolean z14 = sharedPreferences.getBoolean("tooltips_smali", true);
        if (f18308ap ? !z14 : z14) {
            f18336s = true;
        }
        f18308ap = z14;
        boolean z15 = sharedPreferences.getBoolean("tooltips_xml", true);
        if (f18309aq ? !z15 : z15) {
            f18336s = true;
        }
        f18309aq = z15;
        int i2 = sharedPreferences.getInt("editor_indent", 4);
        if (f18335r != i2) {
            f18336s = true;
        }
        f18335r = i2;
    }

    /* renamed from: c */
    private static void m18941c(SharedPreferences sharedPreferences, Context context) {
        boolean z = false;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (availableProcessors <= 0) {
            availableProcessors = 4;
        }
        f18295ac = sharedPreferences.getInt("buffer_size", 10);
        f18297ae = sharedPreferences.getInt("threads_others", availableProcessors);
        f18300ah = sharedPreferences.getInt("threads_antisplit", availableProcessors);
        f18298af = sharedPreferences.getInt("threads_smali", Math.min(4, availableProcessors));
        f18299ag = sharedPreferences.getInt("threads_baksmali", Math.min(6, availableProcessors));
        f18275K = sharedPreferences.getBoolean("screen_on", false);
        f18296ad = sharedPreferences.getInt("clear_preview", 7);
        f18313au = sharedPreferences.getBoolean("baksmali_registers", false);
        m18912a(f18296ad);
        String[] m18926a = m18926a(sharedPreferences);
        if (!Arrays.equals(f18290Z, m18926a)) {
            f18320c = true;
        }
        f18290Z = m18926a;
        String string = sharedPreferences.getString("lang", "en");
        if (!string.equals(f18267C)) {
            f18320c = true;
        }
        f18267C = string;
        int i = sharedPreferences.getInt("napp_fontsz", 16);
        if (f18332o != i) {
            f18320c = true;
        }
        f18332o = i;
        f18333p = C3080al.m18522a(context, i);
        int i2 = sharedPreferences.getInt("hl_time", 700);
        if (f18334q != i2) {
            f18320c = true;
        }
        f18334q = i2;
        int m18608k = C3080al.m18608k(context);
        int i3 = sharedPreferences.getInt("dark_theme", 1);
        switch (m18608k) {
            case 1:
                f18331n = R.style.AppTheme;
                i3 = 1;
                break;
            case 2:
                i3 = 2;
                f18331n = R.style.AppThemeBlack;
                break;
            default:
                f18331n = R.style.AppThemeLight;
                break;
        }
        if (m18608k != f18319b) {
            f18320c = true;
            m18935b(context, "dark_theme", i3);
        }
        f18319b = m18608k;
        f18291a = m18608k == 0;
        boolean z2 = sharedPreferences.getBoolean("hide_files", true);
        if (z2 ? !f18269E : f18269E) {
            f18320c = true;
        }
        f18269E = z2;
        boolean z3 = sharedPreferences.getBoolean("round_icons", false);
        if (z3 ? !f18270F : f18270F) {
            f18320c = true;
        }
        f18270F = z3;
        boolean z4 = sharedPreferences.getBoolean("dirs_size", false);
        if (z4 ? !f18271G : f18271G) {
            f18320c = true;
        }
        f18271G = z4;
        boolean z5 = sharedPreferences.getBoolean("icons_outline", true);
        if (z5 ? !f18288X : f18288X) {
            f18320c = true;
        }
        f18288X = z5;
        boolean z6 = sharedPreferences.getBoolean("refreshing", true);
        if (z6 ? !f18303ak : f18303ak) {
            f18320c = true;
        }
        f18303ak = z6;
        boolean z7 = sharedPreferences.getBoolean("show_errors", false);
        if (z7 ? !f18272H : f18272H) {
            f18320c = true;
            f18336s = true;
        }
        f18272H = z7;
        String string2 = sharedPreferences.getString(Settings.System.DATE_FORMAT, "yyyy/MM/dd HH:mm");
        if (!string2.equals(f18266B)) {
            f18320c = true;
        }
        f18266B = string2;
        String string3 = sharedPreferences.getString("editor_theme", "new");
        if (!f18276L.equals(string3)) {
            f18320c = true;
        }
        f18276L = string3;
        f18277M = new File(context.getFilesDir(), new StringBuffer().append(new StringBuffer().append("theme/").append(f18276L).toString()).append(".json").toString()).getAbsolutePath();
        boolean z8 = sharedPreferences.getBoolean("use_aapt2", true);
        if (z8 ? !f18279O : f18279O) {
            f18320c = true;
        }
        f18279O = z8;
        boolean z9 = sharedPreferences.getBoolean("scrollbar_left", false);
        if (z9 ? !f18273I : f18273I) {
            f18320c = true;
        }
        f18273I = z9;
        boolean z10 = sharedPreferences.getBoolean("scrollbar_files", true);
        if (z10 ? !f18314av : f18314av) {
            f18320c = true;
        }
        f18314av = z10;
        String string4 = sharedPreferences.getString("default_key", "testkey");
        if (!f18324g.equals(string4)) {
            f18324g = string4;
            try {
                m18919a(context.getAssets(), context.getFilesDir());
            } catch (Exception e2) {
            }
        }
        String string5 = sharedPreferences.getString("screen_orientation", "0");
        if (!f18301ai.equals(string5)) {
            f18320c = true;
        }
        f18301ai = string5;
        String string6 = sharedPreferences.getString("ds_display", "0");
        if (!f18302aj.equals(string6)) {
            f18320c = true;
        }
        f18302aj = string6;
        boolean equals = sharedPreferences.getString("file_size", "0").equals("1");
        if (equals ? !f18305am : f18305am) {
            f18320c = true;
        }
        f18305am = equals;
        boolean z11 = sharedPreferences.getBoolean("drawer_fixed", false) && sharedPreferences.getBoolean("floating_button", true);
        if (z11 ? !f18310ar : f18310ar) {
            f18320c = true;
        }
        f18310ar = z11;
        boolean z12 = sharedPreferences.getBoolean("ignore_crc", true);
        if (z12 ? !f18315aw : f18315aw) {
            f18320c = true;
        }
        f18315aw = z12;
        boolean z13 = sharedPreferences.getBoolean("user_frameworks", false);
        if (!z13 || m18946d()) {
            z = z13;
        } else {
            sharedPreferences.edit().putBoolean("user_frameworks", false).commit();
        }
        if (z ? !f18316ax : f18316ax) {
            f18320c = true;
        }
        f18316ax = z;
        boolean z14 = sharedPreferences.getBoolean("keep_modified_time", true);
        if (z14 ? !f18312at : f18312at) {
            f18320c = true;
        }
        f18312at = z14;
        f18337t = sharedPreferences.getString("projectPath", (String) null);
        if (f18337t == null) {
            m18922a("", context);
            return;
        }
        try {
            if (!new File(f18337t).exists()) {
                m18922a("", context);
            } else {
                f18338u.m18215a(f18337t);
            }
        } catch (Exception e3) {
            m18922a("", context);
        }
    }

    /* renamed from: a */
    public static void m18922a(String str, Context context) {
        f18337t = str;
        f18338u.m18215a(str);
        m18937b(context, "projectPath", str);
    }

    /* renamed from: b */
    public static String m18928b(Context context) {
        File file = new File(context.getFilesDir(), ".checkpoint_2");
        if (!file.exists() || file.isDirectory()) {
            return (String) null;
        }
        return C3257q.m19520b(C3061a.m18332i(file), file.getName());
    }

    /* renamed from: c */
    public static void m18939c(Context context) {
        File file = new File(context.getFilesDir(), ".checkpoint_2");
        C3061a.m18319b(file, C3257q.m19518a(f18293aa, file.getName()));
    }

    /* renamed from: a */
    public static void m18915a(Context context, AssetManager assetManager, File file) {
        try {
            File file2 = new File(file, ".checkpoint_2");
            if (!file2.exists() || file2.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (int i = 0; i < listFiles.length; i++) {
                        if (listFiles[i].isDirectory()) {
                            C0542g.m3987a(listFiles[i]);
                        } else {
                            listFiles[i].delete();
                        }
                    }
                }
                file2.createNewFile();
                C3061a.m18319b(file2, C3257q.m19518a(f18293aa, file2.getName()));
                m18924a(context, "load_aapts_dialog");
                m18937b(context, "editor_theme", "new");
                f18276L = "new";
                f18277M = new File(file, new StringBuffer().append(new StringBuffer().append("theme/").append(f18276L).toString()).append(".json").toString()).getAbsolutePath();
            }
            m18919a(assetManager, file);
            m18945d(context, assetManager, file);
            m18948e(context, assetManager, file);
            m18940c(context, assetManager, file);
            m18929b(context, assetManager, file);
            C2890j.m16910a(assetManager);
            C2890j.m16909a();
        } catch (Exception e2) {
        }
    }

    /* renamed from: a */
    public static List<String> m18911a(AssetManager assetManager, String str) {
        try {
            ArrayList arrayList = new ArrayList();
            String[] list = assetManager.list(str);
            if (list != null) {
                for (int i = 0; i < list.length; i++) {
                    List<String> m18911a = m18911a(assetManager, new StringBuffer().append(new StringBuffer().append(str).append("/").toString()).append(list[i]).toString());
                    if (m18911a == null || m18911a.isEmpty()) {
                        arrayList.add(new StringBuffer().append(new StringBuffer().append(str).append("/").toString()).append(list[i]).toString());
                    } else {
                        arrayList.addAll(m18911a);
                    }
                }
                return arrayList;
            }
            return arrayList;
        } catch (Exception e2) {
            return (List) null;
        }
    }

    /* renamed from: a */
    public static void m18919a(AssetManager assetManager, File file) {
        Iterator<String> it = m18911a(assetManager, "key").iterator();
        while (it.hasNext()) {
            m18920a(assetManager, file, it.next());
        }
    }

    /* renamed from: a */
    private static void m18920a(AssetManager assetManager, File file, String str) {
        boolean startsWith = str.startsWith(new StringBuffer().append("key/").append(f18324g).toString());
        File file2 = new File(file, str);
        if (file2.exists() && file2.isFile()) {
            if (startsWith) {
                if (str.endsWith(".pk8")) {
                    f18325h = file2.getAbsolutePath();
                    return;
                } else {
                    f18326i = file2.getAbsolutePath();
                    return;
                }
            }
            return;
        }
        InputStream open = assetManager.open(str);
        file2.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        C1887e.m13962a(open, fileOutputStream);
        open.close();
        fileOutputStream.close();
        if (startsWith) {
            if (str.endsWith(".pk8")) {
                f18325h = file2.getAbsolutePath();
            } else {
                f18326i = file2.getAbsolutePath();
            }
        }
    }

    /* renamed from: e */
    public static boolean m18949e() {
        try {
            MainActivity m16615o = MainActivity.m16615o();
            m18940c(m16615o, m16615o.getAssets(), m16615o.getFilesDir());
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: f */
    public static boolean m18951f() {
        try {
            MainActivity m16615o = MainActivity.m16615o();
            File file = new File(m16615o.getFilesDir(), "bin");
            if (file.isDirectory()) {
                C0542g.m3987a(file);
            } else {
                file.delete();
            }
            m18945d(m16615o, m16615o.getAssets(), m16615o.getFilesDir());
            m18948e(m16615o, m16615o.getAssets(), m16615o.getFilesDir());
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: c */
    private static void m18942c(File file) {
        File[] listFiles = file.getParentFile().listFiles(new FileFilter() { // from class: ru.maximoff.apktool.util.bd.1
            @Override // java.p209io.FileFilter
            public boolean accept(File file2) {
                return file2.isFile() && file2.getName().endsWith(".apk");
            }
        });
        if (listFiles != null) {
            for (File file2 : listFiles) {
                C3262u.m19637b(file2, new File(file, file2.getName()));
            }
        }
    }

    /* renamed from: c */
    private static void m18940c(Context context, AssetManager assetManager, File file) {
        File file2 = new File(file, "framework/main");
        File file3 = new File(file, "framework/user");
        if (!file2.isDirectory() || !file3.isDirectory()) {
            file2.mkdirs();
            file3.mkdirs();
            m18942c(file3);
        }
        File file4 = new File(file2, "1.apk");
        if (file4.exists() && file4.isFile()) {
            String m18928b = m18928b(context);
            if (m18928b != null && m18928b.equals(f18293aa)) {
                f18322e = file2.getAbsolutePath();
                f18323f = file3.getAbsolutePath();
                return;
            }
            m18939c(context);
        }
        InputStream open = assetManager.open("resources.amres");
        file4.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = new FileOutputStream(file4);
        C1887e.m13962a(open, fileOutputStream);
        open.close();
        fileOutputStream.close();
        f18322e = file2.getAbsolutePath();
        f18323f = file3.getAbsolutePath();
        if (!m18946d()) {
            f18316ax = false;
            m18938b(context, "user_frameworks", false);
        }
    }

    /* renamed from: d */
    private static void m18945d(Context context, AssetManager assetManager, File file) {
        String str;
        InputStream open;
        File file2 = new File(file, "bin/aapt");
        File file3 = new File(new StringBuffer().append(file2.getAbsolutePath()).append("_64").toString());
        File file4 = new File(new StringBuffer().append(file2.getAbsolutePath()).append("_usr").toString());
        if (file4.exists() && file4.isFile()) {
            if (file2.exists()) {
                file2.delete();
            }
            if (file3.exists()) {
                file3.delete();
            }
            f18321d = file4.getAbsolutePath();
            file4.setExecutable(true);
            return;
        }
        if (file3.exists() && file3.isFile()) {
            if (file2.exists()) {
                file2.delete();
            }
            f18321d = file3.getAbsolutePath();
            file3.setExecutable(true);
            return;
        }
        if (file2.exists() && file2.isFile()) {
            f18321d = file2.getAbsolutePath();
            file2.setExecutable(true);
            return;
        }
        file2.getParentFile().mkdirs();
        if (f18268D.startsWith("x86")) {
            str = "x86";
        } else {
            str = "arm";
        }
        String stringBuffer = new StringBuffer().append(new StringBuffer().append("bin/").append(str).toString()).append("_aapt").toString();
        if ((f18268D.equals("arm64-v8a") || f18268D.equals("x86-64")) && C3080al.m18564a(context, new StringBuffer().append(stringBuffer).append("_64").toString())) {
            open = assetManager.open(new StringBuffer().append(stringBuffer).append("_64").toString());
        } else {
            open = assetManager.open(stringBuffer);
            file3 = file2;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file3);
        C1887e.m13962a(open, fileOutputStream);
        open.close();
        fileOutputStream.close();
        file3.setExecutable(true);
        f18321d = file3.getAbsolutePath();
    }

    /* renamed from: e */
    private static void m18948e(Context context, AssetManager assetManager, File file) {
        String str;
        InputStream open;
        File file2 = new File(file, "bin/aapt2");
        File file3 = new File(new StringBuffer().append(file2.getAbsolutePath()).append("_64").toString());
        File file4 = new File(new StringBuffer().append(file2.getAbsolutePath()).append("_usr").toString());
        if (file4.exists() && file4.isFile()) {
            if (file2.exists()) {
                file2.delete();
            }
            if (file3.exists()) {
                file3.delete();
            }
            f18278N = file4.getAbsolutePath();
            file4.setExecutable(true);
            return;
        }
        if (file3.exists() && file3.isFile()) {
            if (file2.exists()) {
                file2.delete();
            }
            f18278N = file3.getAbsolutePath();
            file3.setExecutable(true);
            return;
        }
        if (file2.exists() && file2.isFile()) {
            f18278N = file2.getAbsolutePath();
            file2.setExecutable(true);
            return;
        }
        file2.getParentFile().mkdirs();
        if (f18268D.startsWith("x86")) {
            str = "x86";
        } else {
            str = "arm";
        }
        String stringBuffer = new StringBuffer().append(new StringBuffer().append("bin/").append(str).toString()).append("_aapt2").toString();
        if ((f18268D.equals("arm64-v8a") || f18268D.equals("x86-64")) && C3080al.m18564a(context, new StringBuffer().append(stringBuffer).append("_64").toString())) {
            open = assetManager.open(new StringBuffer().append(stringBuffer).append("_64").toString());
        } else {
            open = assetManager.open(stringBuffer);
            file3 = file2;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file3);
        C1887e.m13962a(open, fileOutputStream);
        open.close();
        fileOutputStream.close();
        file3.setExecutable(true);
        f18278N = file3.getAbsolutePath();
    }

    /* renamed from: b */
    public static void m18929b(Context context, AssetManager assetManager, File file) {
        File file2;
        boolean z = false;
        File file3 = new File(file, new StringBuffer().append(new StringBuffer().append("theme/").append(f18276L).toString()).append(".json").toString());
        if (file3.isFile()) {
            f18277M = file3.getAbsolutePath();
            return;
        }
        String[] stringArray = context.getResources().getStringArray(R.array.editor_themes_values);
        int i = 0;
        while (true) {
            if (i >= stringArray.length) {
                break;
            }
            if (f18276L.equals(stringArray[i])) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            file2 = file3;
        } else {
            m18937b(context, "editor_theme", "new");
            f18276L = "new";
            file2 = new File(file, new StringBuffer().append(new StringBuffer().append("theme/").append(f18276L).toString()).append(".json").toString());
        }
        file2.getParentFile().mkdirs();
        InputStream open = assetManager.open(new StringBuffer().append(new StringBuffer().append("themes/").append(f18276L).toString()).append(".json").toString());
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        C1887e.m13962a(open, fileOutputStream);
        open.close();
        fileOutputStream.close();
        f18277M = file2.getAbsolutePath();
    }

    /* renamed from: b */
    private static void m18930b(SharedPreferences sharedPreferences) {
        C0518d c0518d = C0518d.f3579w;
        c0518d.f3585f = sharedPreferences.getBoolean("copyOriginalFiles", false);
        c0518d.f3586g = sharedPreferences.getBoolean("copy_original_sign", true);
        c0518d.f3587h = sharedPreferences.getBoolean("copy_original_mf", false);
        c0518d.f3583d = sharedPreferences.getBoolean("debug_mode", false);
        c0518d.f3584e = sharedPreferences.getBoolean("verbose_mode", false);
        c0518d.f3594o = sharedPreferences.getBoolean("add_nsc", false);
        c0518d.f3595p = sharedPreferences.getBoolean("add_nsc_ex", true);
        f18340w = sharedPreferences.getBoolean("analysis_all_smali", false);
        String string = sharedPreferences.getString("output_directory", (String) null);
        f18339v = (string == null || !string.equals("")) ? string : (String) null;
    }

    /* renamed from: b */
    public static boolean m18933b(Context context, String str) {
        f18339v = str;
        return m18937b(context, "output_directory", str);
    }

    /* renamed from: d */
    public static void m18944d(Context context) {
        if (f18339v == null) {
            try {
                File file = new File(Environment.getExternalStorageDirectory(), "Apktool_M");
                if (file.exists()) {
                    if (file.isDirectory()) {
                        m18933b(context, file.getAbsolutePath());
                    }
                } else if (file.mkdirs()) {
                    m18933b(context, file.getAbsolutePath());
                }
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: g */
    private static String m18952g() {
        String str;
        try {
            if (Build.VERSION.SDK_INT < 21) {
                str = Build.CPU_ABI;
            } else {
                str = Build.SUPPORTED_ABIS[0];
            }
            return str;
        } catch (Exception e2) {
            return m18953h();
        }
    }

    /* renamed from: h */
    private static String m18953h() {
        String str;
        try {
            String lowerCase = System.getProperty("os.arch").toLowerCase();
            if (lowerCase.contains("64")) {
                if (lowerCase.startsWith("x86")) {
                    str = "x86-64";
                } else if (lowerCase.startsWith("mips")) {
                    str = "mips64";
                } else {
                    str = "arm64-v8a";
                }
            } else if (lowerCase.contains("v8")) {
                str = "arm64-v8a";
            } else if (lowerCase.startsWith("x86")) {
                str = "x86";
            } else if (lowerCase.startsWith("mips")) {
                str = "mips";
            } else {
                str = "armeabi-v7a";
            }
            return str;
        } catch (Exception e2) {
            return "armeabi";
        }
    }

    /* renamed from: a */
    public static void m18913a(Activity activity) {
        View inflate = activity.getLayoutInflater().inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(activity).m435b(inflate).m429a(false).m438b();
        m438b.show();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(activity, m438b) { // from class: ru.maximoff.apktool.util.bd.2

            /* renamed from: a */
            private final Activity f18352a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f18353b;

            {
                this.f18352a = activity;
                this.f18353b = m438b;
            }

            @Override // java.lang.Runnable
            public void run() {
                File filesDir = this.f18352a.getFilesDir();
                if (filesDir.isDirectory()) {
                    File[] listFiles = filesDir.listFiles();
                    if (listFiles != null) {
                        for (int i = 0; i < listFiles.length; i++) {
                            if (listFiles[i].isDirectory()) {
                                C0542g.m3987a(listFiles[i]);
                            } else if (listFiles[i].isFile() && !listFiles[i].getName().equals(".stats")) {
                                listFiles[i].delete();
                            }
                        }
                    }
                } else {
                    filesDir.delete();
                    filesDir.mkdirs();
                }
                File file = new File(filesDir, ".checkpoint_2");
                try {
                    file.createNewFile();
                } catch (Exception e2) {
                }
                C3061a.m18319b(file, C3257q.m19518a(C3102bd.f18293aa, file.getName()));
                C3102bd.m18938b((Context) this.f18352a, "user_frameworks", false);
                C3102bd.m18924a(this.f18352a, "load_aapts_dialog");
                C3102bd.m18937b(this.f18352a, "editor_theme", "new");
                C3102bd.f18276L = "new";
                C3102bd.f18277M = new File(filesDir, new StringBuffer().append(new StringBuffer().append("theme/").append(C3102bd.f18276L).toString()).append(".json").toString()).getAbsolutePath();
                C3102bd.m18915a(this.f18352a, this.f18352a.getAssets(), filesDir);
                C0518d c0518d = C0518d.f3579w;
                c0518d.f3598s = C3102bd.f18322e;
                c0518d.f3580a = C3102bd.m18943c();
                C3102bd.m18932b(filesDir);
                this.f18353b.cancel();
                C3112bn.m19023b(this.f18352a, this.f18352a.getString(R.string.complete));
                if (C3102bd.f18268D.equals("arm64-v8a") || C3102bd.f18268D.equals("x86-64")) {
                    C3102bd.m18918a(this.f18352a, true, C3102bd.f18268D, R.string.load_binaries, new boolean[]{true, true});
                }
            }
        }, 100L);
    }

    /* renamed from: a */
    public static void m18917a(Context context, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (m18925a(context, "new_optimization_dialog", true) || z) {
                String packageName = context.getPackageName();
                PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
                if (z) {
                    try {
                        if (powerManager.isIgnoringBatteryOptimizations(packageName)) {
                            Intent intent = new Intent();
                            intent.setAction(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS);
                            intent.addFlags(268435456);
                            context.startActivity(intent);
                        } else {
                            Intent intent2 = new Intent();
                            intent2.setAction(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                            intent2.setData(Uri.parse(new StringBuffer().append("package:").append(packageName).toString()));
                            intent2.addFlags(268435456);
                            context.startActivity(intent2);
                        }
                        return;
                    } catch (Exception e2) {
                        C3112bn.m18999a(context, R.string.error);
                        return;
                    }
                }
                if (!powerManager.isIgnoringBatteryOptimizations(packageName)) {
                    new DialogInterfaceC0070b.a(context).m418a(R.string.attention).m433b(R.string.optimization_notice).m420a(R.string.yes, new DialogInterface.OnClickListener(powerManager, packageName, context) { // from class: ru.maximoff.apktool.util.bd.3

                        /* renamed from: a */
                        private final PowerManager f18354a;

                        /* renamed from: b */
                        private final String f18355b;

                        /* renamed from: c */
                        private final Context f18356c;

                        {
                            this.f18354a = powerManager;
                            this.f18355b = packageName;
                            this.f18356c = context;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            try {
                                if (this.f18354a.isIgnoringBatteryOptimizations(this.f18355b)) {
                                    Intent intent3 = new Intent();
                                    intent3.setAction(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS);
                                    intent3.addFlags(268435456);
                                    this.f18356c.startActivity(intent3);
                                } else {
                                    Intent intent4 = new Intent();
                                    intent4.setAction(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                                    intent4.setData(Uri.parse(new StringBuffer().append("package:").append(this.f18355b).toString()));
                                    intent4.addFlags(268435456);
                                    this.f18356c.startActivity(intent4);
                                }
                            } catch (Exception e3) {
                                C3112bn.m18999a(this.f18356c, R.string.error);
                            }
                            dialogInterface.dismiss();
                        }
                    }).m434b(R.string.f21469no, (DialogInterface.OnClickListener) null).m440c(R.string.not_remind, new DialogInterface.OnClickListener(context) { // from class: ru.maximoff.apktool.util.bd.4

                        /* renamed from: a */
                        private final Context f18357a;

                        {
                            this.f18357a = context;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            C3102bd.m18938b(this.f18357a, "new_optimization_dialog", false);
                            dialogInterface.dismiss();
                        }
                    }).m429a(false).m438b().show();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m18918a(Context context, boolean z, String str, int i, boolean[] zArr) {
        ArrayList arrayList = new ArrayList();
        if (z) {
            if (!f18321d.endsWith("_64") && !f18321d.endsWith("_usr")) {
                arrayList.add("aapt");
            }
            if (!f18278N.endsWith("_64") && !f18278N.endsWith("_usr")) {
                arrayList.add("aapt2");
            }
        } else {
            if (zArr[0]) {
                arrayList.add("aapt");
            }
            if (zArr[1]) {
                arrayList.add("aapt2");
            }
        }
        if (!arrayList.isEmpty()) {
            String[] stringArray = context.getResources().getStringArray(R.array.aapts_version);
            String[] strArr = new String[stringArray.length];
            for (int i2 = 0; i2 < stringArray.length; i2++) {
                strArr[i2] = context.getString(R.string.down_for, stringArray[i2]);
            }
            View inflate = LayoutInflater.from(context).inflate(R.layout.alert, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.alertTextView1)).setText(i);
            Spinner spinner = (Spinner) inflate.findViewById(R.id.alertSpinner1);
            spinner.setVisibility(0);
            spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(context, C0012R.layout.simple_spinner_dropdown_item, strArr));
            spinner.setSelection(strArr.length - 1);
            TextView textView = (TextView) inflate.findViewById(R.id.alertTextView2);
            textView.setText(R.string.aapts33_warn);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(textView) { // from class: ru.maximoff.apktool.util.bd.5

                /* renamed from: a */
                private final TextView f18358a;

                {
                    this.f18358a = textView;
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j) {
                    if (i3 == 1) {
                        this.f18358a.setVisibility(0);
                    } else {
                        this.f18358a.setVisibility(8);
                    }
                }
            });
            DialogInterfaceC0070b.a m429a = new DialogInterfaceC0070b.a(context).m418a(R.string.attention).m435b(inflate).m420a(R.string.mupdate_down, new DialogInterface.OnClickListener(str, spinner, stringArray, context, z, arrayList) { // from class: ru.maximoff.apktool.util.bd.6

                /* renamed from: a */
                private final String f18359a;

                /* renamed from: b */
                private final Spinner f18360b;

                /* renamed from: c */
                private final String[] f18361c;

                /* renamed from: d */
                private final Context f18362d;

                /* renamed from: e */
                private final boolean f18363e;

                /* renamed from: f */
                private final List f18364f;

                {
                    this.f18359a = str;
                    this.f18360b = spinner;
                    this.f18361c = stringArray;
                    this.f18362d = context;
                    this.f18363e = z;
                    this.f18364f = arrayList;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                    String stringBuffer = new StringBuffer().append(new StringBuffer().append("/bin/").append(this.f18359a).toString()).append("/").toString();
                    int selectedItemPosition = this.f18360b.getSelectedItemPosition();
                    if (selectedItemPosition > 0) {
                        stringBuffer = new StringBuffer().append(stringBuffer).append(new StringBuffer().append(this.f18361c[selectedItemPosition].toLowerCase()).append("/").toString()).toString();
                    }
                    AsyncTaskC2946q asyncTaskC2946q = new AsyncTaskC2946q(this.f18362d, new File(this.f18362d.getFilesDir(), "bin"), stringBuffer);
                    asyncTaskC2946q.m17548a(this.f18363e);
                    asyncTaskC2946q.m17550b(this.f18359a.indexOf("64") > 0);
                    try {
                        asyncTaskC2946q.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (String[]) this.f18364f.toArray(new String[this.f18364f.size()]));
                    } catch (Exception e2) {
                        C3112bn.m18999a(this.f18362d, R.string.error_try_again);
                    }
                }
            }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m429a(true);
            if (z) {
                m429a.m440c(R.string.not_remind, new DialogInterface.OnClickListener(context) { // from class: ru.maximoff.apktool.util.bd.7

                    /* renamed from: a */
                    private final Context f18365a;

                    {
                        this.f18365a = context;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        C3102bd.m18938b(this.f18365a, "load_aapts_dialog", false);
                        dialogInterface.dismiss();
                    }
                });
            }
            m429a.m438b().show();
        }
    }

    /* renamed from: a */
    public static void m18916a(Context context, Runnable runnable, Runnable runnable2, boolean z) {
        String m18578b = C3080al.m18578b(context, "agreement.txt");
        if (m18578b == null || (m18905a(context, "license_version", 0) >= 1 && !z)) {
            if (runnable != null && (runnable instanceof Runnable)) {
                runnable.run();
                return;
            }
            return;
        }
        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(context);
        aVar.m418a(R.string.license_agreement);
        aVar.m436b(C3112bn.m19041p(m18578b));
        if (runnable != null) {
            aVar.m420a(R.string.license_accept, new DialogInterface.OnClickListener(runnable) { // from class: ru.maximoff.apktool.util.bd.8

                /* renamed from: a */
                private final Runnable f18366a;

                {
                    this.f18366a = runnable;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f18366a.run();
                    dialogInterface.dismiss();
                }
            });
        } else {
            aVar.m420a(R.string.f21470ok, (DialogInterface.OnClickListener) null);
        }
        if (runnable2 != null) {
            aVar.m434b(R.string.license_refuse, new DialogInterface.OnClickListener(runnable2) { // from class: ru.maximoff.apktool.util.bd.9

                /* renamed from: a */
                private final Runnable f18367a;

                {
                    this.f18367a = runnable2;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f18367a.run();
                    dialogInterface.dismiss();
                }
            });
        }
        aVar.m440c(R.string.mtranslation, (DialogInterface.OnClickListener) null);
        aVar.m429a(z);
        DialogInterfaceC0070b m438b = aVar.m438b();
        m438b.setOnShowListener(new DialogInterface.OnShowListener(m438b, context) { // from class: ru.maximoff.apktool.util.bd.10

            /* renamed from: a */
            private final DialogInterfaceC0070b f18344a;

            /* renamed from: b */
            private final Context f18345b;

            {
                this.f18344a = m438b;
                this.f18345b = context;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                TextView textView = (TextView) this.f18344a.findViewById(C0012R.id.message);
                textView.setTextIsSelectable(true);
                textView.setMovementMethod(new C3251k());
                this.f18344a.m414a(-3).setOnClickListener(new View.OnClickListener(this, this.f18345b) { // from class: ru.maximoff.apktool.util.bd.10.1

                    /* renamed from: a */
                    private final AnonymousClass10 f18346a;

                    /* renamed from: b */
                    private final Context f18347b;

                    {
                        this.f18346a = this;
                        this.f18347b = r2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        int i;
                        C0173ao c0173ao = new C0173ao(this.f18347b, view);
                        if (C3102bd.m18910a(this.f18347b, "menu_position", "1").equals("0")) {
                            i = 3;
                        } else {
                            i = 5;
                        }
                        c0173ao.m1340a(i);
                        c0173ao.m1339a().add(0, PointerIcon.TYPE_ALIAS, 0, R.string.mtr_google).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f18347b) { // from class: ru.maximoff.apktool.util.bd.10.1.1

                            /* renamed from: a */
                            private final AnonymousClass1 f18348a;

                            /* renamed from: b */
                            private final Context f18349b;

                            {
                                this.f18348a = this;
                                this.f18349b = r2;
                            }

                            @Override // android.view.MenuItem.OnMenuItemClickListener
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                C3080al.m18595e(this.f18349b, new StringBuffer().append("https://translate.google.com/translate?u=https%3A%2F%2Fgithub.com%2FMaximoff%2FApktool-M-updates%2Fblob%2Fmain%2FAGREEMENT.MD&hl=").append(C3080al.m18600g(this.f18349b)).toString());
                                return true;
                            }
                        });
                        c0173ao.m1339a().add(0, PointerIcon.TYPE_COPY, 0, R.string.mtr_yandex).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f18347b) { // from class: ru.maximoff.apktool.util.bd.10.1.2

                            /* renamed from: a */
                            private final AnonymousClass1 f18350a;

                            /* renamed from: b */
                            private final Context f18351b;

                            {
                                this.f18350a = this;
                                this.f18351b = r2;
                            }

                            @Override // android.view.MenuItem.OnMenuItemClickListener
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                C3080al.m18595e(this.f18351b, new StringBuffer().append("https://translate.yandex.com/translate?url=https%3A%2F%2Fgithub.com%2FMaximoff%2FApktool-M-updates%2Fblob%2Fmain%2FAGREEMENT.MD&lang=ru-").append(C3080al.m18600g(this.f18351b)).toString());
                                return true;
                            }
                        });
                        c0173ao.m1344c();
                    }
                });
            }
        });
        m438b.show();
    }
}
