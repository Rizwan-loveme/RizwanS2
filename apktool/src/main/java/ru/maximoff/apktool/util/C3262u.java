package ru.maximoff.apktool.util;

import android.C0012R;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.p006pm.PackageInfo;
import android.content.p006pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaCodec;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.storage.StorageManager;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.security.keystore.KeyProperties;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.widget.C0173ao;
import androidx.core.content.FileProvider;
import com.p065b.p066a.p067a.AbstractC0581c;
import com.srizwan.apktool.R;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
import javax.xml.XMLConstants;
import org.p217b.p218a.p219a.C1887e;
import org.p270e.C2466a;
import org.p270e.C2467b;
import p046b.p047a.C0518d;
import p046b.p057b.C0522a;
import p046b.p059d.C0542g;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.fragment.p301a.C2978b;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a;
import ru.maximoff.apktool.p300e.AsyncTaskC2899aa;
import ru.maximoff.apktool.p300e.AsyncTaskC2900ab;
import ru.maximoff.apktool.p300e.AsyncTaskC2901ac;
import ru.maximoff.apktool.p300e.AsyncTaskC2902ad;
import ru.maximoff.apktool.p300e.AsyncTaskC2903ae;
import ru.maximoff.apktool.p300e.AsyncTaskC2904af;
import ru.maximoff.apktool.p300e.AsyncTaskC2905ag;
import ru.maximoff.apktool.p300e.AsyncTaskC2906ah;
import ru.maximoff.apktool.p300e.AsyncTaskC2907ai;
import ru.maximoff.apktool.p300e.AsyncTaskC2908aj;
import ru.maximoff.apktool.p300e.AsyncTaskC2911am;
import ru.maximoff.apktool.p300e.AsyncTaskC2913ao;
import ru.maximoff.apktool.p300e.AsyncTaskC2914ap;
import ru.maximoff.apktool.p300e.AsyncTaskC2916ar;
import ru.maximoff.apktool.p300e.AsyncTaskC2920av;
import ru.maximoff.apktool.p300e.AsyncTaskC2921aw;
import ru.maximoff.apktool.p300e.AsyncTaskC2922ax;
import ru.maximoff.apktool.p300e.AsyncTaskC2923ay;
import ru.maximoff.apktool.p300e.AsyncTaskC2924az;
import ru.maximoff.apktool.p300e.AsyncTaskC2926ba;
import ru.maximoff.apktool.p300e.AsyncTaskC2927bb;
import ru.maximoff.apktool.p300e.AsyncTaskC2928bc;
import ru.maximoff.apktool.p300e.AsyncTaskC2929bd;
import ru.maximoff.apktool.p300e.AsyncTaskC2930be;
import ru.maximoff.apktool.p300e.AsyncTaskC2931bf;
import ru.maximoff.apktool.p300e.AsyncTaskC2932c;
import ru.maximoff.apktool.p300e.AsyncTaskC2936g;
import ru.maximoff.apktool.p300e.AsyncTaskC2937h;
import ru.maximoff.apktool.p300e.AsyncTaskC2938i;
import ru.maximoff.apktool.p300e.AsyncTaskC2940k;
import ru.maximoff.apktool.p300e.AsyncTaskC2941l;
import ru.maximoff.apktool.p300e.AsyncTaskC2942m;
import ru.maximoff.apktool.p300e.AsyncTaskC2943n;
import ru.maximoff.apktool.p300e.AsyncTaskC2944o;
import ru.maximoff.apktool.p300e.AsyncTaskC2945p;
import ru.maximoff.apktool.p300e.AsyncTaskC2947r;
import ru.maximoff.apktool.p300e.AsyncTaskC2948s;
import ru.maximoff.apktool.p300e.AsyncTaskC2951v;
import ru.maximoff.apktool.p300e.AsyncTaskC2955z;
import ru.maximoff.apktool.p300e.C2917as;
import ru.maximoff.apktool.p300e.C2919au;
import ru.maximoff.apktool.util.C3060a;
import ru.maximoff.apktool.util.C3089au;
import ru.maximoff.apktool.util.p303a.C3061a;
import ru.maximoff.apktool.util.p306d.C3212b;
import ru.maximoff.apktool.util.p308f.AsyncTaskC3229i;
import ru.maximoff.apktool.util.p310h.C3247a;
import ru.maximoff.apktool.view.C3309k;
import ru.maximoff.apktool.view.CustomListView;
import ru.maximoff.apktool.view.ZipViewer;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: FileUtils.java */
/* renamed from: ru.maximoff.apktool.util.u */
/* loaded from: classes.dex */
public class C3262u {

    /* renamed from: a */
    private static final String[] f19730a = {"gif", "png", "jpg", "jpeg", "bmp", "webp"};

    /* renamed from: a */
    public static void m19608a(File file, View view, InterfaceC2995n interfaceC2995n) {
        Context context = view.getContext();
        MainActivity m16615o = MainActivity.m16615o();
        String lowerCase = file.getName().toLowerCase();
        if (lowerCase.equalsIgnoreCase("Apktool_M.backup") || lowerCase.matches("^apktool_m\\.\\d+\\.backup$")) {
            try {
                Intent intent = new Intent(m16615o, Class.forName("ru.maximoff.apktool.SettingActivity"));
                intent.putExtra("backup_file", file.getAbsolutePath());
                m16615o.startActivityForResult(intent, 0);
                return;
            } catch (ClassNotFoundException e2) {
                throw new NoClassDefFoundError(e2.getMessage());
            }
        }
        if (lowerCase.endsWith(".mp3") || lowerCase.endsWith(".wav") || lowerCase.endsWith(".ogg") || lowerCase.endsWith(".oga") || lowerCase.endsWith(".amr") || lowerCase.endsWith(".awb")) {
            try {
                new C3088at(context, file).m18706a();
                return;
            } catch (Exception e3) {
                C3112bn.m19023b(context, context.getString(R.string.failed_open, file.getAbsolutePath()));
                return;
            }
        }
        if (lowerCase.endsWith(".apks") || lowerCase.endsWith(".zip") || lowerCase.endsWith(".jar") || lowerCase.endsWith(".hwt") || lowerCase.endsWith(".xapk") || lowerCase.endsWith(".aab") || lowerCase.endsWith(".xpi")) {
            m19579a(context, file, view, interfaceC2995n);
            return;
        }
        if (lowerCase.endsWith(".apk")) {
            try {
                new AsyncTaskC2903ae(context, view, interfaceC2995n).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, file);
                return;
            } catch (Exception e4) {
                C3112bn.m18999a(context, R.string.error_try_again);
                return;
            }
        }
        if (lowerCase.endsWith(".xml") && m19671j(file)) {
            m19627b(context, file, view, interfaceC2995n);
            return;
        }
        if (lowerCase.endsWith(".dex")) {
            m19653d(file, view, interfaceC2995n);
            return;
        }
        if (lowerCase.endsWith(".apkm")) {
            m19646c(file, view, interfaceC2995n);
            return;
        }
        if (lowerCase.endsWith(".bak")) {
            m19631b(context, interfaceC2995n, file);
            return;
        }
        if (lowerCase.endsWith(".mtd") || lowerCase.endsWith(".amd")) {
            m19659e(file, view, interfaceC2995n);
            return;
        }
        if (lowerCase.endsWith(".sh")) {
            m19661f(file, view, interfaceC2995n);
            return;
        }
        if (lowerCase.endsWith(".ttf") || lowerCase.endsWith(".otf")) {
            m19577a(context, file);
            return;
        }
        if (lowerCase.endsWith(".jks") || lowerCase.endsWith(".bks") || lowerCase.endsWith(".keystore") || lowerCase.endsWith(".key") || lowerCase.endsWith(".pk8")) {
            if (lowerCase.endsWith(".pk8") && !new File(new StringBuffer().append(file.getAbsolutePath().substring(0, file.getAbsolutePath().length() - 3)).append("x509.pem").toString()).isFile()) {
                m19650d(context, file);
                return;
            } else {
                m19606a(view, file, interfaceC2995n);
                return;
            }
        }
        if (lowerCase.endsWith(".so")) {
            try {
                Intent intent2 = new Intent(m16615o, Class.forName("ru.maximoff.apktool.SoEditor"));
                intent2.putExtra("data", file.getAbsolutePath());
                m16615o.startActivityForResult(intent2, 0);
                return;
            } catch (ClassNotFoundException e5) {
                throw new NoClassDefFoundError(e5.getMessage());
            }
        }
        for (String str : f19730a) {
            if (lowerCase.endsWith(new StringBuffer().append(".").append(str).toString())) {
                try {
                    Intent intent3 = new Intent(m16615o, Class.forName("ru.maximoff.apktool.PreviewActivity"));
                    intent3.putExtra("data", file.getAbsolutePath());
                    m16615o.startActivityForResult(intent3, PointerIcon.TYPE_ALL_SCROLL);
                    return;
                } catch (ClassNotFoundException e6) {
                    throw new NoClassDefFoundError(e6.getMessage());
                }
            }
        }
        m19650d(context, file);
    }

    /* renamed from: b */
    public static void m19635b(File file, View view, InterfaceC2995n interfaceC2995n) {
        C3099ba c3099ba;
        Drawable drawable;
        boolean z;
        Context context = view.getContext();
        MainActivity m16615o = MainActivity.m16615o();
        File m16639u = m16615o.m16639u();
        boolean m19664g = m19664g(context, m16639u);
        String[] m19641b = m19641b(file.getName());
        boolean m19664g2 = m19664g(context, file);
        int[] iArr = {1, 2, 0};
        if (file.isFile() && (m19641b[1].equalsIgnoreCase(XMLConstants.XML_NS_PREFIX) || m19641b[1].equalsIgnoreCase("svg"))) {
            c3099ba = new C3099ba(context, file);
        } else {
            c3099ba = (C3099ba) null;
        }
        if (!interfaceC2995n.mo17970v() && ((c3099ba == null || !c3099ba.m18881j()) && file.isFile() && m19641b[1].equalsIgnoreCase(XMLConstants.XML_NS_PREFIX))) {
            drawable = C3067ab.m18380a(context, file);
        } else {
            drawable = (Drawable) null;
        }
        C3220f c3220f = new C3220f(context, interfaceC2995n);
        Menu m18715a = C3089au.m18715a(view, R.menu.file, new C3089au.a(file, interfaceC2995n, m16639u, m19641b, iArr, context, m19664g2, c3099ba, drawable, c3220f, m16615o) { // from class: ru.maximoff.apktool.util.u.1

            /* renamed from: a */
            private final File f19731a;

            /* renamed from: b */
            private final InterfaceC2995n f19732b;

            /* renamed from: c */
            private final File f19733c;

            /* renamed from: d */
            private final String[] f19734d;

            /* renamed from: e */
            private final int[] f19735e;

            /* renamed from: f */
            private final Context f19736f;

            /* renamed from: g */
            private final boolean f19737g;

            /* renamed from: h */
            private final C3099ba f19738h;

            /* renamed from: i */
            private final Drawable f19739i;

            /* renamed from: j */
            private final C3220f f19740j;

            /* renamed from: k */
            private final MainActivity f19741k;

            {
                this.f19731a = file;
                this.f19732b = interfaceC2995n;
                this.f19733c = m16639u;
                this.f19734d = m19641b;
                this.f19735e = iArr;
                this.f19736f = context;
                this.f19737g = m19664g2;
                this.f19738h = c3099ba;
                this.f19739i = drawable;
                this.f19740j = c3220f;
                this.f19741k = m16615o;
            }

            @Override // ru.maximoff.apktool.util.C3089au.a
            /* renamed from: a */
            public void mo17670a(Context context2, int i) {
                File[] fileArr;
                File[] fileArr2;
                File file2;
                int i2;
                int m19672k;
                String[] strArr;
                int i3;
                String[] strArr2;
                File[] fileArr3;
                File[] fileArr4;
                File[] fileArr5;
                int i4;
                File[] fileArr6;
                LayoutInflater from = LayoutInflater.from(context2);
                View inflate = from.inflate(R.layout.search_progress, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
                switch (i) {
                    case R.id.decompile /* 2131690155 */:
                        C3080al.m18556a(context2, this.f19732b, this.f19732b.mo17960l(), context2.getString(R.string.decompile), (String) null);
                        return;
                    case R.id.sign /* 2131690156 */:
                        this.f19735e[1] = 2;
                        Runnable runnable = new Runnable(this, context2, this.f19735e, this.f19732b, this.f19736f) { // from class: ru.maximoff.apktool.util.u.1.4

                            /* renamed from: a */
                            private final AnonymousClass1 f19840a;

                            /* renamed from: b */
                            private final Context f19841b;

                            /* renamed from: c */
                            private final int[] f19842c;

                            /* renamed from: d */
                            private final InterfaceC2995n f19843d;

                            /* renamed from: e */
                            private final Context f19844e;

                            {
                                this.f19840a = this;
                                this.f19841b = context2;
                                this.f19842c = r3;
                                this.f19843d = r4;
                                this.f19844e = r5;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                C2917as.m17314a(this.f19841b, this.f19842c[0], new C2917as.a(this, this.f19841b, this.f19843d, this.f19844e) { // from class: ru.maximoff.apktool.util.u.1.4.1

                                    /* renamed from: a */
                                    private final AnonymousClass4 f19845a;

                                    /* renamed from: b */
                                    private final Context f19846b;

                                    /* renamed from: c */
                                    private final InterfaceC2995n f19847c;

                                    /* renamed from: d */
                                    private final Context f19848d;

                                    {
                                        this.f19845a = this;
                                        this.f19846b = r2;
                                        this.f19847c = r3;
                                        this.f19848d = r4;
                                    }

                                    @Override // ru.maximoff.apktool.p300e.C2917as.a
                                    /* renamed from: a */
                                    public void mo16440a(C2917as c2917as, boolean z2) {
                                        try {
                                            new AsyncTaskC2916ar(this.f19846b, this.f19847c, c2917as).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f19847c.mo17960l());
                                        } catch (Exception e2) {
                                            C3112bn.m18999a(this.f19848d, R.string.error_try_again);
                                        }
                                    }
                                });
                            }
                        };
                        if (C3102bd.m18925a(context2, "custom_signature_file", false)) {
                            C3262u.m19599a(context2, this.f19735e, runnable, (Runnable) null);
                            return;
                        } else {
                            new Handler(Looper.getMainLooper()).postDelayed(runnable, 100L);
                            return;
                        }
                    case R.id.verify /* 2131690157 */:
                    case R.id.sign_kill /* 2131690158 */:
                    case R.id.embed_dp /* 2131690159 */:
                    case R.id.edit_axml /* 2131690161 */:
                    case R.id.redistribute /* 2131690164 */:
                    case R.id.split_arch /* 2131690166 */:
                    case R.id.soeditor /* 2131690167 */:
                    case R.id.import_framework /* 2131690169 */:
                    case R.id.to_apks /* 2131690172 */:
                    case R.id.launchApp /* 2131690183 */:
                    case R.id.deleteApp /* 2131690184 */:
                    case R.id.open_settings /* 2131690185 */:
                    case R.id.open_market /* 2131690186 */:
                    case R.id.extract_app /* 2131690187 */:
                    case R.id.save /* 2131690189 */:
                    case R.id.reset /* 2131690190 */:
                    case R.id.search /* 2131690191 */:
                    case R.id.replace /* 2131690192 */:
                    case R.id.line_num /* 2131690193 */:
                    case R.id.backup /* 2131690194 */:
                    case R.id.prop /* 2131690195 */:
                    case R.id.dump /* 2131690196 */:
                    case R.id.exit /* 2131690197 */:
                    case R.id.close_cur /* 2131690198 */:
                    case R.id.close_others /* 2131690199 */:
                    case R.id.close_all /* 2131690200 */:
                    case R.id.color_picker /* 2131690201 */:
                    case R.id.hex /* 2131690202 */:
                    case R.id.smali /* 2131690203 */:
                    case R.id.date_fmt /* 2131690204 */:
                    case R.id.cur_date /* 2131690205 */:
                    case R.id.split_dex /* 2131690207 */:
                    case R.id.add_dict /* 2131690209 */:
                    case R.id.previous /* 2131690211 */:
                    case R.id.next /* 2131690212 */:
                    case R.id.wordwrap /* 2131690213 */:
                    case R.id.monospace /* 2131690214 */:
                    case R.id.line_nums /* 2131690215 */:
                    case R.id.ignore_indent /* 2131690216 */:
                    case R.id.only_diff /* 2131690217 */:
                    case R.id.select_mode /* 2131690218 */:
                    case R.id.sort /* 2131690219 */:
                    case R.id.filter /* 2131690220 */:
                    case R.id.translate /* 2131690221 */:
                    case R.id.translate_smali /* 2131690222 */:
                    case R.id.translate_xml /* 2131690223 */:
                    case R.id.colors /* 2131690224 */:
                    case R.id.refresh_res /* 2131690225 */:
                    case R.id.cloning /* 2131690226 */:
                    case R.id.patcher /* 2131690227 */:
                    case R.id.recent_files /* 2131690229 */:
                    case R.id.search_res /* 2131690230 */:
                    case R.id.make_home /* 2131690231 */:
                    case R.id.main_project /* 2131690232 */:
                    case R.id.color_pipette /* 2131690236 */:
                    case R.id.act_list /* 2131690237 */:
                    case R.id.methods /* 2131690238 */:
                    case R.id.undo /* 2131690239 */:
                    case R.id.redo /* 2131690240 */:
                    case R.id.find /* 2131690241 */:
                    case R.id.go_to_line /* 2131690242 */:
                    case R.id.edit_mode /* 2131690243 */:
                    case R.id.save_as /* 2131690244 */:
                    case R.id.save_all /* 2131690245 */:
                    case R.id.reload /* 2131690246 */:
                    case R.id.encoding /* 2131690247 */:
                    case R.id.syntax /* 2131690248 */:
                    case R.id.select_rows /* 2131690249 */:
                    case R.id.smali_help /* 2131690250 */:
                    case R.id.color /* 2131690251 */:
                    case R.id.properties /* 2131690252 */:
                    default:
                        return;
                    case R.id.encrypt /* 2131690160 */:
                        this.f19735e[1] = 3;
                        C3262u.m19602a(this.f19736f, this.f19735e, new Runnable(this, this.f19732b, this.f19731a, this.f19736f, this.f19735e) { // from class: ru.maximoff.apktool.util.u.1.16

                            /* renamed from: a */
                            private final AnonymousClass1 f19785a;

                            /* renamed from: b */
                            private final InterfaceC2995n f19786b;

                            /* renamed from: c */
                            private final File f19787c;

                            /* renamed from: d */
                            private final Context f19788d;

                            /* renamed from: e */
                            private final int[] f19789e;

                            {
                                this.f19785a = this;
                                this.f19786b = r2;
                                this.f19787c = r3;
                                this.f19788d = r4;
                                this.f19789e = r5;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                File[] fileArr7;
                                if (this.f19786b.mo17970v()) {
                                    fileArr7 = this.f19786b.mo17960l();
                                } else {
                                    fileArr7 = new File[]{this.f19787c};
                                }
                                try {
                                    new AsyncTaskC2948s(this.f19788d, false, this.f19789e[0]).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, fileArr7);
                                } catch (Exception e2) {
                                    C3112bn.m18999a(this.f19788d, R.string.error_try_again);
                                }
                            }
                        }, (Runnable) null, false, 3, false, R.string.enc_res);
                        return;
                    case R.id.optimize /* 2131690162 */:
                        this.f19735e[1] = 3;
                        C3262u.m19602a(context2, this.f19735e, new Runnable(this, context2, this.f19732b, this.f19735e, this.f19736f) { // from class: ru.maximoff.apktool.util.u.1.5

                            /* renamed from: a */
                            private final AnonymousClass1 f19849a;

                            /* renamed from: b */
                            private final Context f19850b;

                            /* renamed from: c */
                            private final InterfaceC2995n f19851c;

                            /* renamed from: d */
                            private final int[] f19852d;

                            /* renamed from: e */
                            private final Context f19853e;

                            {
                                this.f19849a = this;
                                this.f19850b = context2;
                                this.f19851c = r3;
                                this.f19852d = r4;
                                this.f19853e = r5;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    new AsyncTaskC2902ad(this.f19850b, this.f19851c, this.f19852d[0]).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f19851c.mo17960l());
                                } catch (Exception e2) {
                                    C3112bn.m18999a(this.f19853e, R.string.error_try_again);
                                }
                            }
                        }, (Runnable) null, false, 1, false, R.string.moptimize);
                        return;
                    case R.id.optimize2 /* 2131690163 */:
                        this.f19735e[1] = 3;
                        C3262u.m19602a(this.f19736f, this.f19735e, new Runnable(this, this.f19732b, this.f19731a, this.f19736f, this.f19735e) { // from class: ru.maximoff.apktool.util.u.1.17

                            /* renamed from: a */
                            private final AnonymousClass1 f19790a;

                            /* renamed from: b */
                            private final InterfaceC2995n f19791b;

                            /* renamed from: c */
                            private final File f19792c;

                            /* renamed from: d */
                            private final Context f19793d;

                            /* renamed from: e */
                            private final int[] f19794e;

                            {
                                this.f19790a = this;
                                this.f19791b = r2;
                                this.f19792c = r3;
                                this.f19793d = r4;
                                this.f19794e = r5;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                File[] fileArr7;
                                if (this.f19791b.mo17970v()) {
                                    fileArr7 = this.f19791b.mo17960l();
                                } else {
                                    fileArr7 = new File[]{this.f19792c};
                                }
                                try {
                                    new AsyncTaskC2948s(this.f19793d, true, this.f19794e[0]).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, fileArr7);
                                } catch (Exception e2) {
                                    C3112bn.m18999a(this.f19793d, R.string.error_try_again);
                                }
                            }
                        }, (Runnable) null, false, 2, false, R.string.moptimize2);
                        return;
                    case R.id.zipalign /* 2131690165 */:
                        this.f19735e[1] = 3;
                        C3262u.m19601a(context2, this.f19735e, new Runnable(this, context2, this.f19732b, this.f19735e, this.f19736f) { // from class: ru.maximoff.apktool.util.u.1.6

                            /* renamed from: a */
                            private final AnonymousClass1 f19854a;

                            /* renamed from: b */
                            private final Context f19855b;

                            /* renamed from: c */
                            private final InterfaceC2995n f19856c;

                            /* renamed from: d */
                            private final int[] f19857d;

                            /* renamed from: e */
                            private final Context f19858e;

                            {
                                this.f19854a = this;
                                this.f19855b = context2;
                                this.f19856c = r3;
                                this.f19857d = r4;
                                this.f19858e = r5;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    new AsyncTaskC2929bd(this.f19855b, this.f19856c, this.f19857d[0]).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f19856c.mo17960l());
                                } catch (Exception e2) {
                                    C3112bn.m18999a(this.f19858e, R.string.error_try_again);
                                }
                            }
                        }, (Runnable) null, false, R.string.mzipalign);
                        return;
                    case R.id.ultrazip /* 2131690168 */:
                        this.f19735e[1] = 3;
                        this.f19735e[2] = C3102bd.m18925a(context2, "change_api_ultra", true) ? 0 : 1;
                        C3262u.m19602a(context2, this.f19735e, new Runnable(this, this.f19732b, this.f19731a, this.f19735e, context2, this.f19736f) { // from class: ru.maximoff.apktool.util.u.1.15

                            /* renamed from: a */
                            private final AnonymousClass1 f19779a;

                            /* renamed from: b */
                            private final InterfaceC2995n f19780b;

                            /* renamed from: c */
                            private final File f19781c;

                            /* renamed from: d */
                            private final int[] f19782d;

                            /* renamed from: e */
                            private final Context f19783e;

                            /* renamed from: f */
                            private final Context f19784f;

                            {
                                this.f19779a = this;
                                this.f19780b = r2;
                                this.f19781c = r3;
                                this.f19782d = r4;
                                this.f19783e = context2;
                                this.f19784f = r6;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                File[] fileArr7;
                                if (this.f19780b.mo17970v()) {
                                    fileArr7 = this.f19780b.mo17960l();
                                } else {
                                    fileArr7 = new File[]{this.f19781c};
                                }
                                boolean z2 = this.f19782d[2] == 0;
                                C3102bd.m18938b(this.f19783e, "change_api_ultra", z2);
                                try {
                                    new AsyncTaskC2922ax(this.f19783e, this.f19780b, this.f19782d[0], z2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, fileArr7);
                                } catch (Exception e2) {
                                    C3112bn.m18999a(this.f19784f, R.string.error_try_again);
                                }
                            }
                        }, (Runnable) null, false, 0, true, R.string.ultra_zip);
                        return;
                    case R.id.open_in /* 2131690170 */:
                        C3262u.m19650d(context2, this.f19731a);
                        return;
                    case R.id.sharing_file /* 2131690171 */:
                        if (this.f19732b.mo17970v()) {
                            C3262u.m19604a(context2, this.f19732b.mo17960l());
                            return;
                        } else {
                            C3262u.m19604a(context2, new File[]{this.f19731a});
                            return;
                        }
                    case R.id.installSplit /* 2131690173 */:
                    case R.id.installnsignSplit /* 2131690174 */:
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.f19735e[1] = 2;
                            DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(context2).m435b(inflate).m429a(false).m438b();
                            m438b.show();
                            File[] fileArr7 = new File[1];
                            Runnable runnable2 = new Runnable(this, this.f19737g, context2, m438b, fileArr7, this.f19731a, this.f19732b, this.f19735e, i) { // from class: ru.maximoff.apktool.util.u.1.9

                                /* renamed from: a */
                                private final AnonymousClass1 f19867a;

                                /* renamed from: b */
                                private final boolean f19868b;

                                /* renamed from: c */
                                private final Context f19869c;

                                /* renamed from: d */
                                private final DialogInterfaceC0070b f19870d;

                                /* renamed from: e */
                                private final File[] f19871e;

                                /* renamed from: f */
                                private final File f19872f;

                                /* renamed from: g */
                                private final InterfaceC2995n f19873g;

                                /* renamed from: h */
                                private final int[] f19874h;

                                /* renamed from: i */
                                private final int f19875i;

                                {
                                    this.f19867a = this;
                                    this.f19868b = r2;
                                    this.f19869c = context2;
                                    this.f19870d = m438b;
                                    this.f19871e = fileArr7;
                                    this.f19872f = r6;
                                    this.f19873g = r7;
                                    this.f19874h = r8;
                                    this.f19875i = i;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    if (!this.f19868b) {
                                        String str = C3102bd.f18339v;
                                        if (str == null) {
                                            C3112bn.m19023b(this.f19869c, this.f19869c.getString(R.string.output_directory_not_set));
                                            this.f19870d.cancel();
                                            return;
                                        }
                                        this.f19871e[0] = new File(new StringBuffer().append(new StringBuffer().append(str).append("/.AM_TempSplit_").toString()).append(System.currentTimeMillis()).toString());
                                    } else {
                                        this.f19871e[0] = new File(new StringBuffer().append(new StringBuffer().append(this.f19872f.getParent()).append("/.AM_TempSplit_").toString()).append(System.currentTimeMillis()).toString());
                                    }
                                    this.f19871e[0].mkdir();
                                    for (File file3 : this.f19873g.mo17960l()) {
                                        C3262u.m19612a(file3, new File(this.f19871e[0], file3.getName()));
                                    }
                                    File[] listFiles = this.f19871e[0].listFiles(new FilenameFilter(this) { // from class: ru.maximoff.apktool.util.u.1.9.1

                                        /* renamed from: a */
                                        private final AnonymousClass9 f19876a;

                                        {
                                            this.f19876a = this;
                                        }

                                        @Override // java.io.FilenameFilter
                                        public boolean accept(File file4, String str2) {
                                            return str2.endsWith(".apk");
                                        }
                                    });
                                    if (listFiles == null || listFiles.length == 0) {
                                        this.f19870d.cancel();
                                        C3112bn.m19023b(this.f19869c, this.f19869c.getString(R.string.error));
                                        C0542g.m3987a(this.f19871e[0]);
                                        this.f19873g.mo17929a();
                                        return;
                                    }
                                    C2917as.m17314a(this.f19869c, this.f19874h[0], new C2917as.a(this, this.f19869c, this.f19873g, this.f19875i, listFiles) { // from class: ru.maximoff.apktool.util.u.1.9.2

                                        /* renamed from: a */
                                        private final AnonymousClass9 f19877a;

                                        /* renamed from: b */
                                        private final Context f19878b;

                                        /* renamed from: c */
                                        private final InterfaceC2995n f19879c;

                                        /* renamed from: d */
                                        private final int f19880d;

                                        /* renamed from: e */
                                        private final File[] f19881e;

                                        {
                                            this.f19877a = this;
                                            this.f19878b = r2;
                                            this.f19879c = r3;
                                            this.f19880d = r4;
                                            this.f19881e = listFiles;
                                        }

                                        @Override // ru.maximoff.apktool.p300e.C2917as.a
                                        /* renamed from: a */
                                        public void mo16440a(C2917as c2917as, boolean z2) {
                                            C3262u.m19595a(this.f19878b, this.f19879c, c2917as, this.f19880d == R.id.installnsignSplit, this.f19881e);
                                        }
                                    });
                                    this.f19870d.cancel();
                                }
                            };
                            if (C3102bd.m18925a(context2, "custom_signature_file", false) && i == R.id.installnsignSplit) {
                                C3262u.m19600a(context2, this.f19735e, runnable2, new Runnable(this, fileArr7, this.f19732b) { // from class: ru.maximoff.apktool.util.u.1.10

                                    /* renamed from: a */
                                    private final AnonymousClass1 f19745a;

                                    /* renamed from: b */
                                    private final File[] f19746b;

                                    /* renamed from: c */
                                    private final InterfaceC2995n f19747c;

                                    {
                                        this.f19745a = this;
                                        this.f19746b = fileArr7;
                                        this.f19747c = r3;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (this.f19746b[0] != null && this.f19746b[0].exists()) {
                                            C0542g.m3987a(this.f19746b[0]);
                                        }
                                        if (this.f19747c != null) {
                                            this.f19747c.mo17929a();
                                        }
                                    }
                                }, R.string.install_sign);
                                m438b.cancel();
                                return;
                            } else {
                                new Handler(Looper.getMainLooper()).postDelayed(runnable2, 100L);
                                return;
                            }
                        }
                        return;
                    case R.id.antisplit /* 2131690175 */:
                    case R.id.decompile_full /* 2131690176 */:
                    case R.id.decompile_res /* 2131690182 */:
                        this.f19735e[1] = 3;
                        File[] mo17960l = this.f19732b.mo17960l();
                        File[] fileArr8 = new File[mo17960l.length];
                        File[] fileArr9 = new File[1];
                        Runnable runnable3 = new Runnable(this, fileArr9, this.f19732b) { // from class: ru.maximoff.apktool.util.u.1.1

                            /* renamed from: a */
                            private final AnonymousClass1 f19742a;

                            /* renamed from: b */
                            private final File[] f19743b;

                            /* renamed from: c */
                            private final InterfaceC2995n f19744c;

                            {
                                this.f19742a = this;
                                this.f19743b = fileArr9;
                                this.f19744c = r3;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                if (this.f19743b[0] != null && this.f19743b[0].exists()) {
                                    C0542g.m3987a(this.f19743b[0]);
                                }
                                if (this.f19744c != null) {
                                    this.f19744c.mo17929a();
                                }
                            }
                        };
                        Runnable runnable4 = new Runnable(this, i, context2, this.f19732b, this.f19735e, fileArr8, this.f19736f) { // from class: ru.maximoff.apktool.util.u.1.2

                            /* renamed from: a */
                            private final AnonymousClass1 f19803a;

                            /* renamed from: b */
                            private final int f19804b;

                            /* renamed from: c */
                            private final Context f19805c;

                            /* renamed from: d */
                            private final InterfaceC2995n f19806d;

                            /* renamed from: e */
                            private final int[] f19807e;

                            /* renamed from: f */
                            private final File[] f19808f;

                            /* renamed from: g */
                            private final Context f19809g;

                            {
                                this.f19803a = this;
                                this.f19804b = i;
                                this.f19805c = context2;
                                this.f19806d = r4;
                                this.f19807e = r5;
                                this.f19808f = fileArr8;
                                this.f19809g = r7;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                boolean z2 = true;
                                boolean z3 = this.f19804b == R.id.decompile_full;
                                AsyncTaskC2940k asyncTaskC2940k = new AsyncTaskC2940k(this.f19805c, this.f19806d, (String) null);
                                AbstractAsyncTaskC2898a.m17030c(true);
                                if (!z3 && this.f19804b != R.id.decompile_res) {
                                    z2 = false;
                                }
                                asyncTaskC2940k.m17512k(z2);
                                asyncTaskC2940k.m17513l(z3);
                                asyncTaskC2940k.m17507b(this.f19807e[0]);
                                try {
                                    asyncTaskC2940k.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f19808f);
                                } catch (Exception e2) {
                                    C3112bn.m18999a(this.f19809g, R.string.error_try_again);
                                }
                            }
                        };
                        DialogInterfaceC0070b m438b2 = new DialogInterfaceC0070b.a(context2).m435b(inflate).m429a(false).m438b();
                        m438b2.show();
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this, context2, this.f19737g, m438b2, fileArr9, this.f19731a, mo17960l, fileArr8, i, runnable4, runnable3, this.f19735e) { // from class: ru.maximoff.apktool.util.u.1.3

                            /* renamed from: a */
                            private final AnonymousClass1 f19820a;

                            /* renamed from: b */
                            private final Context f19821b;

                            /* renamed from: c */
                            private final boolean f19822c;

                            /* renamed from: d */
                            private final DialogInterfaceC0070b f19823d;

                            /* renamed from: e */
                            private final File[] f19824e;

                            /* renamed from: f */
                            private final File f19825f;

                            /* renamed from: g */
                            private final File[] f19826g;

                            /* renamed from: h */
                            private final File[] f19827h;

                            /* renamed from: i */
                            private final int f19828i;

                            /* renamed from: j */
                            private final Runnable f19829j;

                            /* renamed from: k */
                            private final Runnable f19830k;

                            /* renamed from: l */
                            private final int[] f19831l;

                            {
                                this.f19820a = this;
                                this.f19821b = context2;
                                this.f19822c = r3;
                                this.f19823d = m438b2;
                                this.f19824e = fileArr9;
                                this.f19825f = r6;
                                this.f19826g = mo17960l;
                                this.f19827h = fileArr8;
                                this.f19828i = i;
                                this.f19829j = runnable4;
                                this.f19830k = runnable3;
                                this.f19831l = r12;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                boolean m18925a = C3102bd.m18925a(this.f19821b, "all_to_out_dir", false);
                                if (!this.f19822c || m18925a) {
                                    String str = C3102bd.f18339v;
                                    if (str == null) {
                                        C3112bn.m19023b(this.f19821b, this.f19821b.getString(R.string.output_directory_not_set));
                                        this.f19823d.cancel();
                                        return;
                                    }
                                    this.f19824e[0] = new File(new StringBuffer().append(new StringBuffer().append(str).append("/AM_AntiSplit_").toString()).append(System.currentTimeMillis()).toString());
                                } else {
                                    this.f19824e[0] = new File(new StringBuffer().append(new StringBuffer().append(this.f19825f.getParent()).append("/AM_AntiSplit_").toString()).append(System.currentTimeMillis()).toString());
                                }
                                if (!this.f19824e[0].exists()) {
                                    this.f19824e[0].mkdirs();
                                }
                                for (int i5 = 0; i5 < this.f19826g.length; i5++) {
                                    File file3 = new File(this.f19824e[0], this.f19826g[i5].getName());
                                    C3262u.m19612a(this.f19826g[i5], file3);
                                    this.f19827h[i5] = file3;
                                }
                                this.f19823d.cancel();
                                if (this.f19828i == R.id.decompile_full || this.f19828i == R.id.decompile_res) {
                                    boolean[] zArr = {true};
                                    DialogInterfaceC0070b m438b3 = new DialogInterfaceC0070b.a(this.f19821b).m427a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f19828i == R.id.decompile_full ? this.f19821b.getString(R.string.decompile) : this.f19821b.getString(R.string.decompile_res)).append(" (").toString()).append(this.f19821b.getString(R.string.split).toLowerCase()).toString()).append(")").toString()).m433b(R.string.mtr_sure).m420a(R.string.yes, new DialogInterface.OnClickListener(this, zArr, this.f19829j) { // from class: ru.maximoff.apktool.util.u.1.3.1

                                        /* renamed from: a */
                                        private final AnonymousClass3 f19832a;

                                        /* renamed from: b */
                                        private final boolean[] f19833b;

                                        /* renamed from: c */
                                        private final Runnable f19834c;

                                        {
                                            this.f19832a = this;
                                            this.f19833b = zArr;
                                            this.f19834c = r3;
                                        }

                                        @Override // android.content.DialogInterface.OnClickListener
                                        public void onClick(DialogInterface dialogInterface, int i6) {
                                            this.f19833b[0] = false;
                                            this.f19834c.run();
                                            dialogInterface.cancel();
                                        }
                                    }).m434b(R.string.cancel, new DialogInterface.OnClickListener(this, zArr) { // from class: ru.maximoff.apktool.util.u.1.3.2

                                        /* renamed from: a */
                                        private final AnonymousClass3 f19835a;

                                        /* renamed from: b */
                                        private final boolean[] f19836b;

                                        {
                                            this.f19835a = this;
                                            this.f19836b = zArr;
                                        }

                                        @Override // android.content.DialogInterface.OnClickListener
                                        public void onClick(DialogInterface dialogInterface, int i6) {
                                            this.f19836b[0] = true;
                                            dialogInterface.cancel();
                                        }
                                    }).m438b();
                                    m438b3.setOnCancelListener(new DialogInterface.OnCancelListener(this, zArr, this.f19830k) { // from class: ru.maximoff.apktool.util.u.1.3.3

                                        /* renamed from: a */
                                        private final AnonymousClass3 f19837a;

                                        /* renamed from: b */
                                        private final boolean[] f19838b;

                                        /* renamed from: c */
                                        private final Runnable f19839c;

                                        {
                                            this.f19837a = this;
                                            this.f19838b = zArr;
                                            this.f19839c = r3;
                                        }

                                        @Override // android.content.DialogInterface.OnCancelListener
                                        public void onCancel(DialogInterface dialogInterface) {
                                            if (this.f19838b[0]) {
                                                this.f19839c.run();
                                            }
                                        }
                                    });
                                    m438b3.show();
                                    return;
                                }
                                C3262u.m19601a(this.f19821b, this.f19831l, this.f19829j, this.f19830k, true, R.string.mantisplit);
                            }
                        }, 100L);
                        return;
                    case R.id.exhere /* 2131690177 */:
                        C3262u.m19582a(context2, this.f19731a, this.f19731a.getParentFile(), false, R.string.mextract_zip);
                        return;
                    case R.id.extoname /* 2131690178 */:
                        C3262u.m19583a(context2, this.f19731a, new File(new StringBuffer().append(new StringBuffer().append(this.f19731a.getParent()).append("/").toString()).append(this.f19734d[0]).toString()), true, context2.getString(R.string.mextract_zip_to, this.f19734d[0]));
                        return;
                    case R.id.extotab /* 2131690179 */:
                        C3262u.m19582a(context2, this.f19731a, this.f19733c, false, R.string.mextract_zip_to2);
                        return;
                    case R.id.open_zip /* 2131690180 */:
                        try {
                            new AsyncTaskC2901ac(context2, this.f19731a, this.f19732b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        } catch (Exception e2) {
                            C3112bn.m18999a(context2, R.string.error_try_again);
                            return;
                        }
                    case R.id.jar2dex /* 2131690181 */:
                        try {
                            new AsyncTaskC2942m(context2, this.f19732b, true).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f19732b.mo17960l());
                            return;
                        } catch (Exception e3) {
                            C3112bn.m18999a(this.f19736f, R.string.error_try_again);
                            return;
                        }
                    case R.id.prev_vector /* 2131690188 */:
                        C3262u.m19596a(context2, this.f19732b, this.f19738h, this.f19739i, this.f19731a);
                        return;
                    case R.id.decompile_dex /* 2131690206 */:
                        if (this.f19732b.mo17970v()) {
                            m19672k = 0;
                            strArr = C3080al.m18573a(new String[]{context2.getString(R.string.mauto)}, C3080al.f17664a);
                        } else {
                            String[] strArr3 = C3080al.f17664a;
                            m19672k = C3262u.m19672k(this.f19731a);
                            strArr = strArr3;
                        }
                        int i5 = m19672k < 0 ? 0 : m19672k;
                        View inflate2 = LayoutInflater.from(context2).inflate(R.layout.spinner_layout2, (ViewGroup) null);
                        CheckBox checkBox = (CheckBox) inflate2.findViewById(R.id.spinnerlayout2CheckBox1);
                        if (this.f19737g) {
                            checkBox.setVisibility(0);
                        } else {
                            checkBox.setVisibility(8);
                        }
                        Spinner spinner = (Spinner) inflate2.findViewById(R.id.spinnerlayout2Spinner1);
                        spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(context2, C0012R.layout.simple_spinner_dropdown_item, strArr));
                        spinner.setSelection(i5);
                        new DialogInterfaceC0070b.a(context2).m418a(R.string.dex_version).m435b(inflate2).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, spinner, this.f19732b, context2, checkBox, this.f19737g, this.f19736f) { // from class: ru.maximoff.apktool.util.u.1.12

                            /* renamed from: a */
                            private final AnonymousClass1 f19756a;

                            /* renamed from: b */
                            private final Spinner f19757b;

                            /* renamed from: c */
                            private final InterfaceC2995n f19758c;

                            /* renamed from: d */
                            private final Context f19759d;

                            /* renamed from: e */
                            private final CheckBox f19760e;

                            /* renamed from: f */
                            private final boolean f19761f;

                            /* renamed from: g */
                            private final Context f19762g;

                            {
                                this.f19756a = this;
                                this.f19757b = spinner;
                                this.f19758c = r3;
                                this.f19759d = context2;
                                this.f19760e = checkBox;
                                this.f19761f = r6;
                                this.f19762g = r7;
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i6) {
                                int i7;
                                try {
                                    int selectedItemPosition = this.f19757b.getSelectedItemPosition();
                                    if (this.f19758c.mo17970v()) {
                                        if (selectedItemPosition == 0) {
                                            i7 = -1;
                                        } else {
                                            i7 = C3080al.f17665b[selectedItemPosition - 1];
                                        }
                                    } else {
                                        i7 = C3080al.f17665b[selectedItemPosition];
                                    }
                                    AsyncTaskC2943n asyncTaskC2943n = new AsyncTaskC2943n(this.f19759d, i7, this.f19758c);
                                    asyncTaskC2943n.m17518h(this.f19760e.isChecked() && this.f19761f);
                                    asyncTaskC2943n.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f19758c.mo17960l());
                                } catch (Exception e4) {
                                    C3112bn.m18999a(this.f19762g, R.string.error_try_again);
                                }
                                dialogInterface.dismiss();
                            }
                        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
                        return;
                    case R.id.dex2jar /* 2131690208 */:
                        try {
                            new AsyncTaskC2942m(context2, this.f19732b, false).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f19732b.mo17960l());
                            return;
                        } catch (Exception e4) {
                            C3112bn.m18999a(this.f19736f, R.string.error_try_again);
                            return;
                        }
                    case R.id.open_in_editor /* 2131690210 */:
                        this.f19732b.mo17940b().m17821a(this.f19731a);
                        this.f19732b.mo17929a();
                        return;
                    case R.id.mpatcher /* 2131690228 */:
                        try {
                            Uri m19657e = C3262u.m19657e(context2, this.f19731a);
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.addCategory(Intent.CATEGORY_DEFAULT);
                            intent.setPackage("ru.maximoff.sheller");
                            intent.setDataAndType(m19657e, "application/ru.maximoff.sheller-patch");
                            intent.putExtra("realPath", this.f19731a.getAbsolutePath());
                            intent.addFlags(268435459);
                            context2.startActivity(intent);
                            return;
                        } catch (Exception e5) {
                            C3112bn.m18999a(context2, R.string.error);
                            return;
                        }
                    case R.id.set_as_output_directory /* 2131690233 */:
                        C3102bd.m18933b(context2, this.f19731a.getAbsolutePath());
                        return;
                    case R.id.bookmark_add /* 2131690234 */:
                        if (this.f19740j.m19293b(this.f19731a)) {
                            C3112bn.m18999a(this.f19736f, R.string.success);
                        } else {
                            C3112bn.m18999a(this.f19736f, R.string.error);
                        }
                        this.f19732b.mo17929a();
                        this.f19740j.m19295c();
                        return;
                    case R.id.bookmark_remove /* 2131690235 */:
                        if (this.f19740j.m19296c(this.f19731a)) {
                            C3112bn.m18999a(this.f19736f, R.string.success);
                        } else {
                            C3112bn.m18999a(this.f19736f, R.string.error);
                        }
                        this.f19732b.mo17929a();
                        this.f19740j.m19295c();
                        return;
                    case R.id.build_dex /* 2131690253 */:
                        if (this.f19732b.mo17970v()) {
                            i3 = 0;
                        } else {
                            i3 = C3262u.m19563a(this.f19731a);
                        }
                        View inflate3 = LayoutInflater.from(context2).inflate(R.layout.spinner_layout2, (ViewGroup) null);
                        Spinner spinner2 = (Spinner) inflate3.findViewById(R.id.spinnerlayout2Spinner1);
                        CheckBox checkBox2 = (CheckBox) inflate3.findViewById(R.id.spinnerlayout2CheckBox1);
                        if (this.f19737g) {
                            checkBox2.setVisibility(0);
                        } else {
                            checkBox2.setVisibility(8);
                        }
                        if (this.f19732b.mo17970v() && !this.f19732b.mo17967s()) {
                            strArr2 = C3080al.m18573a(new String[]{context2.getString(R.string.mauto)}, C3080al.f17664a);
                        } else {
                            strArr2 = C3080al.f17664a;
                        }
                        spinner2.setAdapter((SpinnerAdapter) new ArrayAdapter(context2, C0012R.layout.simple_spinner_dropdown_item, strArr2));
                        spinner2.setSelection(i3);
                        new DialogInterfaceC0070b.a(context2).m418a(R.string.dex_version).m435b(inflate3).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, spinner2, this.f19732b, context2, checkBox2, this.f19737g, this.f19731a, this.f19736f) { // from class: ru.maximoff.apktool.util.u.1.11

                            /* renamed from: a */
                            private final AnonymousClass1 f19748a;

                            /* renamed from: b */
                            private final Spinner f19749b;

                            /* renamed from: c */
                            private final InterfaceC2995n f19750c;

                            /* renamed from: d */
                            private final Context f19751d;

                            /* renamed from: e */
                            private final CheckBox f19752e;

                            /* renamed from: f */
                            private final boolean f19753f;

                            /* renamed from: g */
                            private final File f19754g;

                            /* renamed from: h */
                            private final Context f19755h;

                            {
                                this.f19748a = this;
                                this.f19749b = spinner2;
                                this.f19750c = r3;
                                this.f19751d = context2;
                                this.f19752e = checkBox2;
                                this.f19753f = r6;
                                this.f19754g = r7;
                                this.f19755h = r8;
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i6) {
                                int i7;
                                int selectedItemPosition = this.f19749b.getSelectedItemPosition();
                                if (this.f19750c.mo17970v() && !this.f19750c.mo17967s()) {
                                    if (selectedItemPosition == 0) {
                                        i7 = -1;
                                    } else {
                                        i7 = C3080al.f17665b[selectedItemPosition - 1];
                                    }
                                } else {
                                    i7 = C3080al.f17665b[selectedItemPosition];
                                }
                                AsyncTaskC2943n asyncTaskC2943n = new AsyncTaskC2943n(this.f19751d, i7, this.f19750c);
                                asyncTaskC2943n.m17518h(this.f19752e.isChecked() && this.f19753f);
                                try {
                                    if (this.f19750c.mo17970v()) {
                                        asyncTaskC2943n.m17517g(this.f19750c.mo17967s());
                                        asyncTaskC2943n.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f19750c.mo17960l());
                                    } else {
                                        asyncTaskC2943n.m17517g(this.f19754g.isFile() && this.f19754g.getName().endsWith(".smali"));
                                        asyncTaskC2943n.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f19754g);
                                    }
                                } catch (Exception e6) {
                                    C3112bn.m18999a(this.f19755h, R.string.error_try_again);
                                }
                                dialogInterface.dismiss();
                            }
                        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
                        return;
                    case R.id.merge_dex /* 2131690254 */:
                        View inflate4 = from.inflate(R.layout.zip, (ViewGroup) null);
                        ((Spinner) inflate4.findViewById(R.id.zipSpinner1)).setVisibility(8);
                        EditText editText = (EditText) inflate4.findViewById(R.id.zipEditText1);
                        editText.setText(new StringBuffer().append(C3249i.f19547g).append(".dex").toString());
                        CheckBox checkBox3 = (CheckBox) inflate4.findViewById(R.id.zipCheckBox1);
                        checkBox3.setText(R.string.delete_orig);
                        ImageView imageView = (ImageView) inflate4.findViewById(R.id.zipImageView1);
                        imageView.setVisibility(0);
                        if (C3102bd.f18291a) {
                            imageView.setImageResource(R.drawable.ic_paste_light);
                        } else {
                            imageView.setImageResource(R.drawable.ic_paste_dark);
                        }
                        imageView.setOnClickListener(new View.OnClickListener(this, this.f19736f, editText) { // from class: ru.maximoff.apktool.util.u.1.18

                            /* renamed from: a */
                            private final AnonymousClass1 f19795a;

                            /* renamed from: b */
                            private final Context f19796b;

                            /* renamed from: c */
                            private final EditText f19797c;

                            {
                                this.f19795a = this;
                                this.f19796b = r2;
                                this.f19797c = editText;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                String m18991a = C3112bn.m18991a(this.f19796b);
                                if (m18991a != null) {
                                    C3112bn.m19007a(this.f19797c, (CharSequence) m18991a);
                                } else {
                                    C3112bn.m18999a(this.f19796b, R.string.empty);
                                }
                            }
                        });
                        DialogInterfaceC0070b m438b3 = new DialogInterfaceC0070b.a(this.f19736f).m418a(R.string.merge_dex).m435b(inflate4).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, this.f19736f, this.f19732b, checkBox3, editText) { // from class: ru.maximoff.apktool.util.u.1.19

                            /* renamed from: a */
                            private final AnonymousClass1 f19798a;

                            /* renamed from: b */
                            private final Context f19799b;

                            /* renamed from: c */
                            private final InterfaceC2995n f19800c;

                            /* renamed from: d */
                            private final CheckBox f19801d;

                            /* renamed from: e */
                            private final EditText f19802e;

                            {
                                this.f19798a = this;
                                this.f19799b = r2;
                                this.f19800c = r3;
                                this.f19801d = checkBox3;
                                this.f19802e = editText;
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i6) {
                                AsyncTaskC2945p asyncTaskC2945p = new AsyncTaskC2945p(this.f19799b, this.f19800c, true);
                                try {
                                    asyncTaskC2945p.m17537g(this.f19801d.isChecked());
                                    asyncTaskC2945p.m17534a(this.f19802e.getText().toString());
                                    asyncTaskC2945p.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f19800c.mo17960l());
                                } catch (Exception e6) {
                                    C3112bn.m18999a(this.f19799b, R.string.error_try_again);
                                }
                            }
                        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
                        m438b3.getWindow().setSoftInputMode(4);
                        m438b3.setOnShowListener(new DialogInterface.OnShowListener(this, editText) { // from class: ru.maximoff.apktool.util.u.1.20

                            /* renamed from: a */
                            private final AnonymousClass1 f19810a;

                            /* renamed from: b */
                            private final EditText f19811b;

                            {
                                this.f19810a = this;
                                this.f19811b = editText;
                            }

                            @Override // android.content.DialogInterface.OnShowListener
                            public void onShow(DialogInterface dialogInterface) {
                                this.f19811b.setSelection(C3249i.f19547g.length());
                                this.f19811b.requestFocus();
                            }
                        });
                        m438b3.show();
                        return;
                    case R.id.delete /* 2131690255 */:
                        C3262u.m19645c(context2, new File[]{this.f19731a}, this.f19732b);
                        return;
                    case R.id.rename /* 2131690256 */:
                        if (this.f19732b.mo17970v()) {
                            File[] mo17960l2 = this.f19732b.mo17960l();
                            if (mo17960l2.length == 1) {
                                C3262u.m19631b(context2, this.f19732b, mo17960l2[0]);
                                return;
                            } else {
                                C3262u.m19632b(context2, this.f19732b, mo17960l2);
                                return;
                            }
                        }
                        C3262u.m19631b(context2, this.f19732b, this.f19731a);
                        return;
                    case R.id.to_vector /* 2131690257 */:
                        int[] iArr2 = {C3102bd.m18905a(context2, "to_vector_mode", 0)};
                        if (iArr2[0] < 0 || iArr2[0] > 2) {
                            iArr2[0] = 0;
                        }
                        String string = this.f19736f.getString(R.string.to_vector);
                        if (this.f19732b.mo17970v()) {
                            string = new StringBuffer().append(string).append(new StringBuffer().append(new StringBuffer().append(" (").append(this.f19732b.mo17959k().size()).toString()).append(")").toString()).toString();
                        }
                        new DialogInterfaceC0070b.a(context2).m427a(string).m419a(R.array.to_vector_values, iArr2[0], new DialogInterface.OnClickListener(this, iArr2) { // from class: ru.maximoff.apktool.util.u.1.7

                            /* renamed from: a */
                            private final AnonymousClass1 f19859a;

                            /* renamed from: b */
                            private final int[] f19860b;

                            {
                                this.f19859a = this;
                                this.f19860b = iArr2;
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i6) {
                                this.f19860b[0] = i6;
                            }
                        }).m420a(R.string.mselect, new DialogInterface.OnClickListener(this, context2, iArr2, this.f19732b, this.f19731a, this.f19736f) { // from class: ru.maximoff.apktool.util.u.1.8

                            /* renamed from: a */
                            private final AnonymousClass1 f19861a;

                            /* renamed from: b */
                            private final Context f19862b;

                            /* renamed from: c */
                            private final int[] f19863c;

                            /* renamed from: d */
                            private final InterfaceC2995n f19864d;

                            /* renamed from: e */
                            private final File f19865e;

                            /* renamed from: f */
                            private final Context f19866f;

                            {
                                this.f19861a = this;
                                this.f19862b = context2;
                                this.f19863c = iArr2;
                                this.f19864d = r4;
                                this.f19865e = r5;
                                this.f19866f = r6;
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i6) {
                                C3102bd.m18935b(this.f19862b, "to_vector_mode", this.f19863c[0]);
                                AsyncTaskC2921aw asyncTaskC2921aw = new AsyncTaskC2921aw(this.f19862b, this.f19864d);
                                asyncTaskC2921aw.m17361b(this.f19863c[0] > 0);
                                asyncTaskC2921aw.m17359a(this.f19863c[0] == 2);
                                try {
                                    if (this.f19864d.mo17970v()) {
                                        asyncTaskC2921aw.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f19864d.mo17960l());
                                    } else {
                                        asyncTaskC2921aw.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f19865e);
                                    }
                                } catch (Exception e6) {
                                    C3112bn.m18999a(this.f19866f, R.string.error_try_again);
                                }
                            }
                        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
                        return;
                    case R.id.to_svg /* 2131690258 */:
                    case R.id.to_xml /* 2131690259 */:
                    case R.id.to_png /* 2131690260 */:
                        if (this.f19732b.mo17970v()) {
                            fileArr5 = this.f19732b.mo17960l();
                        } else {
                            fileArr5 = new File[]{this.f19731a};
                        }
                        switch (i) {
                            case R.id.to_xml /* 2131690259 */:
                                i4 = 2;
                                break;
                            case R.id.to_png /* 2131690260 */:
                                i4 = 3;
                                break;
                            default:
                                i4 = 1;
                                break;
                        }
                        AsyncTaskC2926ba asyncTaskC2926ba = new AsyncTaskC2926ba(context2, this.f19732b);
                        asyncTaskC2926ba.m17412a(i4);
                        if (i4 == 3) {
                            C3262u.m19630b(context2, asyncTaskC2926ba, fileArr5);
                            return;
                        }
                        try {
                            asyncTaskC2926ba.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, fileArr5);
                            return;
                        } catch (Exception e6) {
                            C3112bn.m18999a(this.f19736f, R.string.error_try_again);
                            return;
                        }
                    case R.id.invert_color /* 2131690261 */:
                        if (this.f19732b.mo17970v()) {
                            fileArr2 = this.f19732b.mo17960l();
                        } else {
                            fileArr2 = new File[]{this.f19731a};
                        }
                        try {
                            new AsyncTaskC2899aa(context2, this.f19732b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, fileArr2);
                            return;
                        } catch (Exception e7) {
                            C3112bn.m18999a(this.f19736f, R.string.error_try_again);
                            return;
                        }
                    case R.id.monochrome /* 2131690262 */:
                        if (this.f19732b.mo17970v()) {
                            fileArr = this.f19732b.mo17960l();
                        } else {
                            fileArr = new File[]{this.f19731a};
                        }
                        try {
                            new AsyncTaskC2900ab(context2, this.f19732b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, fileArr);
                            return;
                        } catch (Exception e8) {
                            C3112bn.m18999a(this.f19736f, R.string.error_try_again);
                            return;
                        }
                    case R.id.pngquant /* 2131690263 */:
                        if (this.f19732b.mo17970v()) {
                            fileArr4 = this.f19732b.mo17960l();
                        } else {
                            fileArr4 = new File[]{this.f19731a};
                        }
                        try {
                            new AsyncTaskC2904af(context2, this.f19732b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, fileArr4);
                            return;
                        } catch (Exception e9) {
                            C3112bn.m18999a(this.f19736f, R.string.error_try_again);
                            return;
                        }
                    case R.id.dummy /* 2131690264 */:
                        if (this.f19732b.mo17970v()) {
                            fileArr3 = this.f19732b.mo17960l();
                        } else {
                            fileArr3 = new File[]{this.f19731a};
                        }
                        try {
                            new AsyncTaskC2951v(context2, this.f19732b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, fileArr3);
                            return;
                        } catch (Exception e10) {
                            C3112bn.m18999a(this.f19736f, R.string.error_try_again);
                            return;
                        }
                    case R.id.create_icon /* 2131690265 */:
                        C3250j.m19503a(this.f19736f, this.f19732b, this.f19731a, this.f19738h, this.f19739i);
                        return;
                    case R.id.compress /* 2131690266 */:
                        if (this.f19732b.mo17970v()) {
                            File[] mo17960l3 = this.f19732b.mo17960l();
                            C3262u.m19633b(context2, this.f19732b, mo17960l3, (!this.f19732b.mo17961m() || mo17960l3.length <= 1) ? ".zip" : ".apks");
                            return;
                        } else {
                            C3262u.m19633b(context2, this.f19732b, new File[]{this.f19731a}, ".zip");
                            return;
                        }
                    case R.id.file_details /* 2131690267 */:
                        if (this.f19732b.mo17970v() && this.f19732b.mo17959k().size() > 1) {
                            try {
                                new AsyncTaskC2907ai(context2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f19732b.mo17960l());
                                return;
                            } catch (Exception e11) {
                                C3112bn.m18999a(this.f19736f, R.string.error_try_again);
                                return;
                            }
                        }
                        C3080al.m18553a(context2, this.f19731a, this.f19732b);
                        return;
                    case R.id.mark_file /* 2131690268 */:
                        C3082an.f18011a.m18648a(this.f19731a.getAbsolutePath());
                        this.f19732b.mo17929a();
                        return;
                    case R.id.copy_file /* 2131690269 */:
                    case R.id.cut_file /* 2131690270 */:
                        C2466a c2466a = new C2466a();
                        try {
                            c2466a.m15572a(0, this.f19731a.getParent());
                            c2466a.m15572a(1, this.f19731a.getName());
                            C3102bd.m18937b(context2, "copy_file_path", c2466a.toString());
                            C3102bd.m18938b(context2, "cut_file_mode", i == R.id.cut_file);
                            this.f19732b.mo17929a();
                            return;
                        } catch (C2467b e12) {
                            C3112bn.m19023b(context2, context2.getString(R.string.error));
                            return;
                        }
                    case R.id.copy_tt /* 2131690271 */:
                    case R.id.move_tt /* 2131690272 */:
                        if (this.f19732b.mo17970v()) {
                            fileArr6 = this.f19732b.mo17960l();
                        } else {
                            fileArr6 = new File[]{this.f19731a};
                        }
                        StringBuilder sb = new StringBuilder();
                        for (int i6 = 0; i6 < fileArr6.length; i6++) {
                            if (i6 > 0) {
                                sb.append(", ");
                            }
                            sb.append(fileArr6[i6].getName());
                            if (fileArr6[i6].isDirectory()) {
                                sb.append("/");
                            }
                        }
                        MainActivity.m16615o().m16627a(sb.toString(), fileArr6, this.f19733c.getAbsolutePath(), i == R.id.move_tt, true, this.f19731a.getParent().length(), true);
                        return;
                    case R.id.select_file /* 2131690273 */:
                        this.f19732b.mo17949e(this.f19731a.getAbsolutePath());
                        return;
                    case R.id.select_to /* 2131690274 */:
                        this.f19732b.mo17953g(this.f19731a.getAbsolutePath());
                        return;
                    case R.id.select_all /* 2131690275 */:
                        this.f19732b.mo17936a(false);
                        return;
                    case R.id.compare_text /* 2131690276 */:
                        try {
                            File[] mo17960l4 = this.f19732b.mo17960l();
                            if (mo17960l4.length != 2) {
                                mo17960l4 = MainActivity.m16615o().m16638t();
                            }
                            try {
                                Intent intent2 = new Intent(context2, Class.forName("ru.maximoff.apktool.DiffText"));
                                intent2.putExtra("first", mo17960l4[0].getAbsolutePath());
                                intent2.putExtra("second", mo17960l4[1].getAbsolutePath());
                                context2.startActivity(intent2);
                                return;
                            } catch (ClassNotFoundException e13) {
                                throw new NoClassDefFoundError(e13.getMessage());
                            }
                        } catch (Exception e14) {
                            C3112bn.m18999a(this.f19736f, R.string.error);
                            return;
                        }
                    case R.id.compare_sign /* 2131690277 */:
                        try {
                            File[] mo17960l5 = this.f19732b.mo17960l();
                            if (mo17960l5.length != 2) {
                                mo17960l5 = MainActivity.m16615o().m16638t();
                            }
                            new AsyncTaskC2937h(context2, this.f19732b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, mo17960l5);
                            return;
                        } catch (Exception e15) {
                            C3112bn.m18999a(this.f19736f, R.string.error_try_again);
                            return;
                        }
                    case R.id.compare_apk /* 2131690278 */:
                        File[] mo17960l6 = this.f19732b.mo17960l();
                        if (mo17960l6.length != 2) {
                            mo17960l6 = MainActivity.m16615o().m16638t();
                        }
                        C3262u.m19658e(this.f19736f, mo17960l6, this.f19732b);
                        return;
                    case R.id.dump_resources /* 2131690279 */:
                        C3262u.m19644c(this.f19736f, this.f19731a, this.f19732b);
                        return;
                    case R.id.diff_resources /* 2131690280 */:
                        File[] mo17960l7 = this.f19732b.mo17960l();
                        if (mo17960l7.length != 2) {
                            mo17960l7 = MainActivity.m16615o().m16638t();
                        }
                        C3262u.m19652d(this.f19736f, mo17960l7, this.f19732b);
                        return;
                    case R.id.copy_sign /* 2131690281 */:
                        C3262u.m19651d(context2, this.f19731a, this.f19732b);
                        return;
                    case R.id.cp_name /* 2131690282 */:
                        if (C3102bd.m18925a(context2, "copy_with_ext", false)) {
                            if (this.f19731a.getName().toLowerCase().endsWith(".9.png")) {
                                C3112bn.m19002a(context2, this.f19734d[0].substring(0, this.f19734d[0].length() - 2));
                                return;
                            } else {
                                C3112bn.m19002a(context2, this.f19734d[0]);
                                return;
                            }
                        }
                        C3112bn.m19002a(context2, this.f19731a.getName());
                        return;
                    case R.id.copy_path /* 2131690283 */:
                        C3112bn.m19002a(context2, this.f19731a.getAbsolutePath());
                        return;
                    case R.id.create_list /* 2131690284 */:
                        if (this.f19732b.mo17970v()) {
                            String stringBuffer = new StringBuffer().append(new StringBuffer().append("LIST_").append(C3112bn.m19032g("yyyyMMddHHmmss")).toString()).append(".txt").toString();
                            if (!this.f19737g) {
                                String str = C3102bd.f18339v;
                                if (str == null) {
                                    C3112bn.m19023b(context2, context2.getString(R.string.output_directory_not_set));
                                    return;
                                }
                                file2 = new File(str);
                            } else {
                                file2 = new File(this.f19731a.getParent());
                            }
                            C3212b c3212b = new C3212b(this.f19736f, "list_names");
                            View inflate5 = from.inflate(R.layout.create_list, (ViewGroup) null);
                            EditText editText2 = (EditText) inflate5.findViewById(R.id.createlistEditText1);
                            CheckBox checkBox4 = (CheckBox) inflate5.findViewById(R.id.createlistCheckBox1);
                            CheckBox checkBox5 = (CheckBox) inflate5.findViewById(R.id.createlistCheckBox2);
                            CheckBox checkBox6 = (CheckBox) inflate5.findViewById(R.id.createlistCheckBox3);
                            checkBox4.setChecked(C3102bd.m18925a(context2, "clist_rec", false));
                            checkBox5.setChecked(C3102bd.m18925a(context2, "clist_rel", false));
                            checkBox6.setChecked(C3102bd.m18925a(context2, "clist_suff", true));
                            ImageView imageView2 = (ImageView) inflate5.findViewById(R.id.createlistImageView1);
                            if (C3102bd.f18291a) {
                                i2 = R.drawable.ic_collapse;
                            } else {
                                i2 = R.drawable.ic_collapse_dark;
                            }
                            imageView2.setImageResource(i2);
                            imageView2.setClickable(true);
                            if (c3212b.m19205b().isEmpty()) {
                                imageView2.setVisibility(8);
                            } else {
                                imageView2.setVisibility(0);
                            }
                            editText2.setText(stringBuffer);
                            editText2.setHint(R.string.name);
                            imageView2.setOnClickListener(new View.OnClickListener(this, c3212b, imageView2, editText2) { // from class: ru.maximoff.apktool.util.u.1.13

                                /* renamed from: a */
                                private final AnonymousClass1 f19763a;

                                /* renamed from: b */
                                private final C3212b f19764b;

                                /* renamed from: c */
                                private final ImageView f19765c;

                                /* renamed from: d */
                                private final EditText f19766d;

                                {
                                    this.f19763a = this;
                                    this.f19764b = c3212b;
                                    this.f19765c = imageView2;
                                    this.f19766d = editText2;
                                }

                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    this.f19764b.m19201a(this.f19765c, this.f19766d);
                                }
                            });
                            new DialogInterfaceC0070b.a(context2).m418a(R.string.create_list).m435b(inflate5).m420a(R.string.mtr_create, new DialogInterface.OnClickListener(this, context2, checkBox4, checkBox5, checkBox6, editText2, stringBuffer, c3212b, this.f19731a, this.f19732b, file2, this.f19741k) { // from class: ru.maximoff.apktool.util.u.1.14

                                /* renamed from: a */
                                private final AnonymousClass1 f19767a;

                                /* renamed from: b */
                                private final Context f19768b;

                                /* renamed from: c */
                                private final CheckBox f19769c;

                                /* renamed from: d */
                                private final CheckBox f19770d;

                                /* renamed from: e */
                                private final CheckBox f19771e;

                                /* renamed from: f */
                                private final EditText f19772f;

                                /* renamed from: g */
                                private final String f19773g;

                                /* renamed from: h */
                                private final C3212b f19774h;

                                /* renamed from: i */
                                private final File f19775i;

                                /* renamed from: j */
                                private final InterfaceC2995n f19776j;

                                /* renamed from: k */
                                private final File f19777k;

                                /* renamed from: l */
                                private final MainActivity f19778l;

                                {
                                    this.f19767a = this;
                                    this.f19768b = context2;
                                    this.f19769c = checkBox4;
                                    this.f19770d = checkBox5;
                                    this.f19771e = checkBox6;
                                    this.f19772f = editText2;
                                    this.f19773g = stringBuffer;
                                    this.f19774h = c3212b;
                                    this.f19775i = r9;
                                    this.f19776j = r10;
                                    this.f19777k = file2;
                                    this.f19778l = r12;
                                }

                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i7) {
                                    C3102bd.m18938b(this.f19768b, "clist_rec", this.f19769c.isChecked());
                                    C3102bd.m18938b(this.f19768b, "clist_rel", this.f19770d.isChecked());
                                    C3102bd.m18938b(this.f19768b, "clist_suff", this.f19771e.isChecked());
                                    String m19033h = C3112bn.m19033h(this.f19772f.getText().toString());
                                    String str2 = m19033h.trim().isEmpty() ? this.f19773g : m19033h;
                                    this.f19774h.m19204a(str2);
                                    String m19570a = C3262u.m19570a(this.f19768b, this.f19776j.mo17960l(), C3262u.m19640b(this.f19768b), this.f19770d.isChecked() ? this.f19775i.getParent().length() + 1 : 0, this.f19769c.isChecked(), this.f19771e.isChecked());
                                    if (m19570a == null) {
                                        C3112bn.m18999a(this.f19768b, R.string.error);
                                    } else {
                                        C3061a.m18319b(new File(this.f19777k, str2), m19570a);
                                        C3112bn.m19023b(this.f19768b, this.f19768b.getString(R.string.successf, new StringBuffer().append(new StringBuffer().append(this.f19777k.getAbsolutePath()).append(File.separator).toString()).append(str2).toString()));
                                    }
                                    this.f19778l.m16637s();
                                    dialogInterface.dismiss();
                                }
                            }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
                            return;
                        }
                        return;
                    case R.id.merge_dict /* 2131690285 */:
                        String string2 = context2.getString(R.string.new_dict);
                        String[] strArr4 = {".amd", ".mtd"};
                        View inflate6 = from.inflate(R.layout.dictionary, (ViewGroup) null);
                        ArrayAdapter arrayAdapter = new ArrayAdapter(this.f19736f, C0012R.layout.simple_spinner_dropdown_item, strArr4);
                        Spinner spinner3 = (Spinner) inflate6.findViewById(R.id.dictionarySpinner1);
                        spinner3.setAdapter((SpinnerAdapter) arrayAdapter);
                        spinner3.setSelection(0);
                        EditText editText3 = (EditText) inflate6.findViewById(R.id.dictionaryEditText1);
                        editText3.setHint(string2);
                        editText3.setText(string2);
                        DialogInterfaceC0070b m438b4 = new DialogInterfaceC0070b.a(context2).m418a(R.string.mtr_create_dict).m435b(inflate6).m420a(R.string.save, new DialogInterface.OnClickListener(this, this.f19736f, this.f19732b, editText3, strArr4, spinner3) { // from class: ru.maximoff.apktool.util.u.1.21

                            /* renamed from: a */
                            private final AnonymousClass1 f19812a;

                            /* renamed from: b */
                            private final Context f19813b;

                            /* renamed from: c */
                            private final InterfaceC2995n f19814c;

                            /* renamed from: d */
                            private final EditText f19815d;

                            /* renamed from: e */
                            private final String[] f19816e;

                            /* renamed from: f */
                            private final Spinner f19817f;

                            {
                                this.f19812a = this;
                                this.f19813b = r2;
                                this.f19814c = r3;
                                this.f19815d = editText3;
                                this.f19816e = strArr4;
                                this.f19817f = spinner3;
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i7) {
                                try {
                                    new AsyncTaskC3229i(this.f19813b, this.f19814c, new StringBuffer().append(this.f19815d.getText().toString()).append(this.f19816e[this.f19817f.getSelectedItemPosition()]).toString()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, MainActivity.m16615o().m16638t());
                                } catch (Exception e16) {
                                    C3112bn.m18999a(this.f19813b, R.string.error_try_again);
                                }
                            }
                        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
                        m438b4.getWindow().setSoftInputMode(4);
                        m438b4.setOnShowListener(new DialogInterface.OnShowListener(this, editText3) { // from class: ru.maximoff.apktool.util.u.1.22

                            /* renamed from: a */
                            private final AnonymousClass1 f19818a;

                            /* renamed from: b */
                            private final EditText f19819b;

                            {
                                this.f19818a = this;
                                this.f19819b = editText3;
                            }

                            @Override // android.content.DialogInterface.OnShowListener
                            public void onShow(DialogInterface dialogInterface) {
                                this.f19819b.requestFocus();
                                this.f19819b.selectAll();
                            }
                        });
                        m438b4.show();
                        return;
                    case R.id.add_media /* 2131690286 */:
                        if (this.f19732b.mo17970v()) {
                            int i7 = 0;
                            for (File file3 : this.f19732b.mo17960l()) {
                                if (C3080al.m18562a(context2, file3)) {
                                    i7++;
                                }
                            }
                            C3112bn.m19000a(this.f19736f, R.string.success_of, new Integer(i7), new Integer(this.f19732b.mo17960l().length));
                            return;
                        }
                        if (C3080al.m18562a(context2, this.f19731a)) {
                            C3112bn.m18999a(this.f19736f, R.string.success);
                            return;
                        } else {
                            C3112bn.m18999a(this.f19736f, R.string.error);
                            return;
                        }
                }
            }
        });
        m18715a.findItem(R.id.copy_tt).setVisible(m19664g);
        m18715a.findItem(R.id.move_tt).setVisible(m19664g && m19664g2);
        if (interfaceC2995n.mo17970v()) {
            m18715a.findItem(R.id.select_all).setVisible(false);
            m18715a.findItem(R.id.copy_file).setVisible(false);
            m18715a.findItem(R.id.cut_file).setVisible(false);
            m18715a.findItem(R.id.delete).setVisible(false);
            m18715a.findItem(R.id.cp_name).setVisible(false);
            m18715a.findItem(R.id.copy_path).setVisible(false);
            m18715a.findItem(R.id.set_as_output_directory).setVisible(false);
            m18715a.findItem(R.id.open_in).setVisible(false);
            m18715a.findItem(R.id.open_in_editor).setVisible(false);
            m18715a.findItem(R.id.exhere).setVisible(false);
            m18715a.findItem(R.id.extoname).setVisible(false);
            m18715a.findItem(R.id.extotab).setVisible(false);
            m18715a.findItem(R.id.open_zip).setVisible(false);
            m18715a.findItem(R.id.mpatcher).setVisible(false);
            m18715a.findItem(R.id.bookmark_add).setVisible(false);
            m18715a.findItem(R.id.bookmark_remove).setVisible(false);
            if (!interfaceC2995n.mo17957i(file.getAbsolutePath())) {
                m18715a.findItem(R.id.rename).setVisible(false);
                m18715a.findItem(R.id.compress).setVisible(false);
                m18715a.findItem(R.id.sharing_file).setVisible(false);
                m18715a.findItem(R.id.select_to).setVisible(true);
                m18715a.findItem(R.id.build_dex).setVisible(false);
                m18715a.findItem(R.id.file_details).setVisible(false);
            } else {
                m18715a.findItem(R.id.invert_color).setVisible(interfaceC2995n.mo17968t());
                m18715a.findItem(R.id.monochrome).setVisible(interfaceC2995n.mo17968t());
                m18715a.findItem(R.id.to_vector).setVisible(interfaceC2995n.mo17968t());
                m18715a.findItem(R.id.to_svg).setVisible(interfaceC2995n.mo17964p());
                m18715a.findItem(R.id.to_xml).setVisible(interfaceC2995n.mo17965q());
                m18715a.findItem(R.id.to_png).setVisible(interfaceC2995n.mo17965q() || interfaceC2995n.mo17964p());
                m18715a.findItem(R.id.dummy).setVisible(m19664g2 && (interfaceC2995n.mo17965q() || interfaceC2995n.mo17964p() || interfaceC2995n.mo17968t()));
                m18715a.findItem(R.id.pngquant).setVisible(interfaceC2995n.mo17966r());
                m18715a.findItem(R.id.compress).setVisible(m19664g2);
                m18715a.findItem(R.id.rename).setVisible(m19664g2);
                m18715a.findItem(R.id.select_file).setVisible(false);
                m18715a.findItem(R.id.create_list).setVisible(true);
                m18715a.findItem(R.id.build_dex).setVisible(m19656d(interfaceC2995n.mo17960l()) || interfaceC2995n.mo17967s());
                m18715a.findItem(R.id.file_details).setVisible(true);
                File[] m16638t = MainActivity.m16615o().m16638t();
                if (m16638t != null && m16638t.length > 1) {
                    m18715a.findItem(R.id.merge_dict).setVisible(m19639b(m16638t));
                }
            }
            if (interfaceC2995n.mo17961m() && interfaceC2995n.mo17957i(file.getAbsolutePath())) {
                int length = interfaceC2995n.mo17960l().length;
                m18715a.findItem(R.id.decompile).setVisible(true);
                m18715a.findItem(R.id.decompile_full).setVisible(length > 1);
                m18715a.findItem(R.id.decompile_res).setVisible(length > 1);
                m18715a.findItem(R.id.antisplit).setVisible(length > 1);
                m18715a.findItem(R.id.zipalign).setVisible(true);
                m18715a.findItem(R.id.ultrazip).setVisible(true);
                m18715a.findItem(R.id.optimize).setVisible(true);
                m18715a.findItem(R.id.optimize2).setVisible(true);
                m18715a.findItem(R.id.encrypt).setVisible(true);
                m18715a.findItem(R.id.sign).setVisible(true);
                String lowerCase = context.getString(R.string.split).toLowerCase();
                m18715a.findItem(R.id.decompile_full).setTitle(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(context.getString(R.string.decompile)).append(" (").toString()).append(lowerCase).toString()).append(")").toString());
                m18715a.findItem(R.id.decompile_res).setTitle(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(context.getString(R.string.decompile_res)).append(" (").toString()).append(lowerCase).toString()).append(")").toString());
                if (Build.VERSION.SDK_INT >= 21 && length > 1) {
                    m18715a.findItem(R.id.installSplit).setTitle(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(context.getString(R.string.install)).append(" (").toString()).append(lowerCase).toString()).append(")").toString());
                    m18715a.findItem(R.id.installnsignSplit).setTitle(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(context.getString(R.string.install_sign)).append(" (").toString()).append(lowerCase).toString()).append(")").toString());
                    m18715a.findItem(R.id.installSplit).setVisible(true);
                    m18715a.findItem(R.id.installnsignSplit).setVisible(true);
                }
                if (length == 2) {
                    m18715a.findItem(R.id.compare_sign).setVisible(true);
                    m18715a.findItem(R.id.compare_apk).setVisible(true);
                    m18715a.findItem(R.id.diff_resources).setVisible(true);
                } else {
                    File[] m16638t2 = MainActivity.m16615o().m16638t();
                    if (m16638t2 != null && m16638t2.length == 2) {
                        boolean m19617a = m19617a(m16638t2);
                        m18715a.findItem(R.id.compare_sign).setVisible(m19617a);
                        m18715a.findItem(R.id.compare_apk).setVisible(m19617a);
                        m18715a.findItem(R.id.diff_resources).setVisible(m19617a);
                    }
                }
            } else if (interfaceC2995n.mo17962n() && interfaceC2995n.mo17957i(file.getAbsolutePath())) {
                m18715a.findItem(R.id.decompile_dex).setVisible(true);
                m18715a.findItem(R.id.dex2jar).setVisible(true);
                m18715a.findItem(R.id.merge_dex).setVisible(interfaceC2995n.mo17960l().length > 1);
            } else if (interfaceC2995n.mo17963o() && interfaceC2995n.mo17957i(file.getAbsolutePath())) {
                m18715a.findItem(R.id.jar2dex).setVisible(true);
            } else if (interfaceC2995n.mo17957i(file.getAbsolutePath())) {
                boolean z2 = true;
                if (interfaceC2995n.mo17960l().length == 2) {
                    File[] mo17960l = interfaceC2995n.mo17960l();
                    int i = 0;
                    while (true) {
                        if (i >= mo17960l.length) {
                            z = true;
                            break;
                        } else {
                            if (!m19673k(context, mo17960l[i])) {
                                z = false;
                                break;
                            }
                            i++;
                        }
                    }
                } else {
                    File[] m16638t3 = MainActivity.m16615o().m16638t();
                    if (m16638t3 != null && m16638t3.length == 2) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= m16638t3.length) {
                                break;
                            }
                            if (!m19673k(context, m16638t3[i2])) {
                                z2 = false;
                                break;
                            }
                            i2++;
                        }
                        z = z2;
                    } else {
                        z = false;
                    }
                }
                m18715a.findItem(R.id.compare_text).setVisible(z);
            }
            m18715a.findItem(R.id.add_media).setVisible(C3102bd.m18925a(context, "amdm", false));
            return;
        }
        String[] strArr = f19730a;
        int i3 = 0;
        while (true) {
            if (i3 >= strArr.length) {
                break;
            }
            if (m19641b[1].equalsIgnoreCase(strArr[i3])) {
                m18715a.findItem(R.id.to_vector).setVisible(true);
                m18715a.findItem(R.id.invert_color).setVisible(true);
                m18715a.findItem(R.id.monochrome).setVisible(true);
                m18715a.findItem(R.id.dummy).setVisible(m19664g2);
                m18715a.findItem(R.id.create_icon).setVisible(true);
                break;
            }
            i3++;
        }
        boolean z3 = file.isFile() && (m19641b[1].equalsIgnoreCase("apk") || m19641b[1].equalsIgnoreCase("xapk") || m19641b[1].equalsIgnoreCase("apks") || m19641b[1].equalsIgnoreCase("zip") || m19641b[1].equalsIgnoreCase("jar") || m19641b[1].equalsIgnoreCase("hwt") || m19641b[1].equalsIgnoreCase("aab") || m19641b[1].equalsIgnoreCase("xpi"));
        boolean z4 = file.isFile() && m19641b[1].equalsIgnoreCase("apkm") && m19654d(file);
        boolean z5 = file.getName().equalsIgnoreCase("Apktool_M.backup") || file.getName().toLowerCase().matches("^apktool_m\\.\\d+\\.backup$");
        if (file.isFile() && m19641b[1].equalsIgnoreCase("jar")) {
            m18715a.add(0, 1000, 0, context.getString(R.string.import_framework)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(context, interfaceC2995n, file) { // from class: ru.maximoff.apktool.util.u.2

                /* renamed from: a */
                private final Context f20107a;

                /* renamed from: b */
                private final InterfaceC2995n f20108b;

                /* renamed from: c */
                private final File f20109c;

                {
                    this.f20107a = context;
                    this.f20108b = interfaceC2995n;
                    this.f20109c = file;
                }

                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    try {
                        new AsyncTaskC2955z(this.f20107a, this.f20108b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20109c);
                    } catch (Exception e2) {
                        C3112bn.m18999a(this.f20107a, R.string.error_try_again);
                    }
                    return true;
                }
            });
        }
        if (file.isFile() && m19641b[1].equalsIgnoreCase("json")) {
            m18715a.add(0, 1001, 0, context.getString(R.string.import_scheme)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(context, file) { // from class: ru.maximoff.apktool.util.u.3

                /* renamed from: a */
                private final Context f20183a;

                /* renamed from: b */
                private final File f20184b;

                {
                    this.f20183a = context;
                    this.f20184b = file;
                }

                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    new C3078aj(this.f20183a).m18496a(this.f20183a.getString(R.string.import_scheme_confirm, this.f20184b.getAbsolutePath())).m18495a(R.string.yes, new Runnable(this, this.f20183a, this.f20184b) { // from class: ru.maximoff.apktool.util.u.3.1

                        /* renamed from: a */
                        private final AnonymousClass3 f20185a;

                        /* renamed from: b */
                        private final Context f20186b;

                        /* renamed from: c */
                        private final File f20187c;

                        {
                            this.f20185a = this;
                            this.f20186b = r2;
                            this.f20187c = r3;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            new C3255o().m19515a(this.f20186b, this.f20187c);
                        }
                    }).m18508e(R.string.cancel).m18507d();
                    return true;
                }
            });
        }
        if (file.isFile() && m19641b[1].equalsIgnoreCase("apk")) {
            m18715a.findItem(R.id.create_icon).setVisible(true);
        }
        m18715a.findItem(R.id.build_dex).setVisible((file.isDirectory() && file.getName().startsWith("smali")) || (file.isFile() && m19641b[1].equalsIgnoreCase("smali")));
        m18715a.findItem(R.id.open_in).setVisible(!file.isDirectory());
        m18715a.findItem(R.id.open_in_editor).setVisible(!file.isDirectory());
        m18715a.findItem(R.id.mark_file).setVisible(true);
        m18715a.findItem(R.id.sharing_file).setVisible(!file.isDirectory());
        m18715a.findItem(R.id.extoname).setTitle(context.getString(R.string.mextract_zip_to, m19641b[0]));
        m18715a.findItem(R.id.pngquant).setVisible(file.isFile() && m19641b[1].equalsIgnoreCase("png"));
        m18715a.findItem(R.id.dump_resources).setVisible(file.isFile() && m19641b[1].equalsIgnoreCase("apk"));
        m18715a.findItem(R.id.copy_sign).setVisible(file.isFile() && m19641b[1].equalsIgnoreCase("apk"));
        m18715a.findItem(R.id.delete).setVisible(m19664g2);
        m18715a.findItem(R.id.compress).setVisible(m19664g2);
        m18715a.findItem(R.id.rename).setVisible(m19664g2);
        m18715a.findItem(R.id.cut_file).setVisible(m19664g2);
        m18715a.findItem(R.id.set_as_output_directory).setVisible(m19664g2 && file.isDirectory());
        m18715a.findItem(R.id.exhere).setVisible(m19664g2 && (z3 || z4));
        m18715a.findItem(R.id.extoname).setVisible(m19664g2 && (z3 || z4));
        m18715a.findItem(R.id.extotab).setVisible(m19664g && (z3 || z4));
        m18715a.findItem(R.id.open_zip).setVisible(z3 || z4 || z5);
        m18715a.findItem(R.id.mpatcher).setVisible(m19616a("ru.maximoff.sheller", context.getPackageManager()));
        if (c3099ba != null) {
            m18715a.findItem(R.id.prev_vector).setVisible(c3099ba.m18881j());
            if (m19641b[1].equalsIgnoreCase(XMLConstants.XML_NS_PREFIX)) {
                m18715a.findItem(R.id.to_svg).setVisible(c3099ba.m18881j() || drawable != null);
            } else if (m19641b[1].equalsIgnoreCase("svg")) {
                m18715a.findItem(R.id.to_xml).setVisible(c3099ba.m18881j());
            }
            m18715a.findItem(R.id.to_png).setVisible(c3099ba.m18881j() || drawable != null);
            m18715a.findItem(R.id.dummy).setVisible(m19664g2 && c3099ba.m18881j());
            m18715a.findItem(R.id.create_icon).setVisible(c3099ba.m18881j());
        }
        if (drawable != null) {
            m18715a.findItem(R.id.prev_vector).setVisible(true);
            m18715a.findItem(R.id.create_icon).setVisible(true);
        }
        if (c3220f.m19290a(file)) {
            m18715a.findItem(R.id.bookmark_add).setVisible(false);
            m18715a.findItem(R.id.bookmark_remove).setVisible(true);
        } else {
            m18715a.findItem(R.id.bookmark_add).setVisible(true);
            m18715a.findItem(R.id.bookmark_remove).setVisible(false);
        }
        m18715a.findItem(R.id.add_media).setVisible(C3102bd.m18925a(context, "amdm", false));
    }

    /* renamed from: a */
    public static boolean m19617a(File[] fileArr) {
        if (fileArr == null || fileArr.length == 0) {
            return false;
        }
        for (File file : fileArr) {
            if (!file.getName().toLowerCase().endsWith(".apk")) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m19639b(File[] fileArr) {
        if (fileArr == null || fileArr.length == 0) {
            return false;
        }
        for (int i = 0; i < fileArr.length; i++) {
            if (!fileArr[i].getName().toLowerCase().endsWith(".amd") && !fileArr[i].getName().toLowerCase().endsWith(".mtd")) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m19644c(Context context, File file, InterfaceC2995n interfaceC2995n) {
        String[] stringArray = context.getResources().getStringArray(R.array.aapt2_dump);
        String[] stringArray2 = context.getResources().getStringArray(R.array.aapt2_dump_descr);
        View inflate = LayoutInflater.from(context).inflate(R.layout.spinner_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.spinnerlayoutTextView1);
        textView.setVisibility(0);
        C3112bn.m19001a(context, textView, C0012R.style.TextAppearance_Medium);
        Spinner spinner = (Spinner) inflate.findViewById(R.id.spinnerlayoutSpinner1);
        spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(context, C0012R.layout.simple_spinner_dropdown_item, stringArray));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(textView, stringArray2) { // from class: ru.maximoff.apktool.util.u.4

            /* renamed from: a */
            private final TextView f20333a;

            /* renamed from: b */
            private final String[] f20334b;

            {
                this.f20333a = textView;
                this.f20334b = stringArray2;
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                this.f20333a.setText(this.f20334b[i]);
            }
        });
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(context).m418a(R.string.dump_resources).m435b(inflate).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(spinner, context, interfaceC2995n, stringArray, file) { // from class: ru.maximoff.apktool.util.u.5

            /* renamed from: a */
            private final Spinner f20399a;

            /* renamed from: b */
            private final Context f20400b;

            /* renamed from: c */
            private final InterfaceC2995n f20401c;

            /* renamed from: d */
            private final String[] f20402d;

            /* renamed from: e */
            private final File f20403e;

            {
                this.f20399a = spinner;
                this.f20400b = context;
                this.f20401c = interfaceC2995n;
                this.f20402d = stringArray;
                this.f20403e = file;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                int selectedItemPosition = this.f20399a.getSelectedItemPosition();
                C3102bd.m18935b(this.f20400b, "aapt2_dump_mode", selectedItemPosition);
                AsyncTaskC2931bf asyncTaskC2931bf = new AsyncTaskC2931bf(this.f20400b, this.f20401c, this.f20402d[selectedItemPosition]);
                asyncTaskC2931bf.m17464a(false);
                asyncTaskC2931bf.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20403e);
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
        m438b.setOnShowListener(new DialogInterface.OnShowListener(context, stringArray, spinner) { // from class: ru.maximoff.apktool.util.u.6

            /* renamed from: a */
            private final Context f20441a;

            /* renamed from: b */
            private final String[] f20442b;

            /* renamed from: c */
            private final Spinner f20443c;

            {
                this.f20441a = context;
                this.f20442b = stringArray;
                this.f20443c = spinner;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                int m18905a = C3102bd.m18905a(this.f20441a, "aapt2_dump_mode", 4);
                if (m18905a >= this.f20442b.length) {
                    m18905a = 0;
                }
                this.f20443c.setSelection(m18905a);
            }
        });
        m438b.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m19652d(Context context, File[] fileArr, InterfaceC2995n interfaceC2995n) {
        int m19470a = C3246h.m19470a(context, R.color.dark_red);
        int m19470a2 = C3246h.m19470a(context, R.color.dark_green);
        String absolutePath = fileArr[0].getAbsolutePath();
        String absolutePath2 = fileArr[1].getAbsolutePath();
        SpannableString spannableString = new SpannableString(absolutePath);
        spannableString.setSpan(new ForegroundColorSpan(m19470a), absolutePath.lastIndexOf(47) + 1, absolutePath.length(), 33);
        SpannableString spannableString2 = new SpannableString(absolutePath2);
        spannableString2.setSpan(new ForegroundColorSpan(m19470a2), absolutePath2.lastIndexOf(47) + 1, absolutePath2.length(), 33);
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(context).m418a(R.string.diff_resources).m436b(C3109bk.m18982a(context.getText(R.string.diff_resources2), spannableString, spannableString2)).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(context, interfaceC2995n, fileArr) { // from class: ru.maximoff.apktool.util.u.7

            /* renamed from: a */
            private final Context f20495a;

            /* renamed from: b */
            private final InterfaceC2995n f20496b;

            /* renamed from: c */
            private final File[] f20497c;

            {
                this.f20495a = context;
                this.f20496b = interfaceC2995n;
                this.f20497c = fileArr;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                try {
                    AsyncTaskC2931bf asyncTaskC2931bf = new AsyncTaskC2931bf(this.f20495a, this.f20496b, (String) null);
                    asyncTaskC2931bf.m17464a(true);
                    asyncTaskC2931bf.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20497c);
                } catch (Exception e2) {
                    C3112bn.m18999a(this.f20495a, R.string.error);
                }
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.swap, (DialogInterface.OnClickListener) null).m438b();
        m438b.setOnShowListener(new DialogInterface.OnShowListener(m438b, fileArr, m19470a, m19470a2, context) { // from class: ru.maximoff.apktool.util.u.8

            /* renamed from: a */
            private final DialogInterfaceC0070b f20531a;

            /* renamed from: b */
            private final File[] f20532b;

            /* renamed from: c */
            private final int f20533c;

            /* renamed from: d */
            private final int f20534d;

            /* renamed from: e */
            private final Context f20535e;

            {
                this.f20531a = m438b;
                this.f20532b = fileArr;
                this.f20533c = m19470a;
                this.f20534d = m19470a2;
                this.f20535e = context;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f20531a.m414a(-3).setOnClickListener(new View.OnClickListener(this, this.f20532b, this.f20533c, this.f20534d, (TextView) this.f20531a.findViewById(C0012R.id.message), this.f20535e) { // from class: ru.maximoff.apktool.util.u.8.1

                    /* renamed from: a */
                    private final AnonymousClass8 f20536a;

                    /* renamed from: b */
                    private final File[] f20537b;

                    /* renamed from: c */
                    private final int f20538c;

                    /* renamed from: d */
                    private final int f20539d;

                    /* renamed from: e */
                    private final TextView f20540e;

                    /* renamed from: f */
                    private final Context f20541f;

                    {
                        this.f20536a = this;
                        this.f20537b = r2;
                        this.f20538c = r3;
                        this.f20539d = r4;
                        this.f20540e = r5;
                        this.f20541f = r6;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        File file = this.f20537b[0];
                        this.f20537b[0] = this.f20537b[1];
                        this.f20537b[1] = file;
                        String absolutePath3 = this.f20537b[0].getAbsolutePath();
                        String absolutePath4 = this.f20537b[1].getAbsolutePath();
                        SpannableString spannableString3 = new SpannableString(absolutePath3);
                        spannableString3.setSpan(new ForegroundColorSpan(this.f20538c), absolutePath3.lastIndexOf(47) + 1, absolutePath3.length(), 33);
                        SpannableString spannableString4 = new SpannableString(absolutePath4);
                        spannableString4.setSpan(new ForegroundColorSpan(this.f20539d), absolutePath4.lastIndexOf(47) + 1, absolutePath4.length(), 33);
                        this.f20540e.setText(C3109bk.m18982a(this.f20541f.getText(R.string.diff_resources2), spannableString3, spannableString4));
                    }
                });
            }
        });
        m438b.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static void m19658e(Context context, File[] fileArr, InterfaceC2995n interfaceC2995n) {
        int m19470a = C3246h.m19470a(context, R.color.dark_green);
        int m19470a2 = C3246h.m19470a(context, R.color.dark_red);
        String absolutePath = fileArr[0].getAbsolutePath();
        String absolutePath2 = fileArr[1].getAbsolutePath();
        SpannableString spannableString = new SpannableString(absolutePath);
        spannableString.setSpan(new ForegroundColorSpan(m19470a), absolutePath.lastIndexOf(47) + 1, absolutePath.length(), 33);
        SpannableString spannableString2 = new SpannableString(absolutePath2);
        spannableString2.setSpan(new ForegroundColorSpan(m19470a2), absolutePath2.lastIndexOf(47) + 1, absolutePath2.length(), 33);
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(context).m418a(R.string.compare_apk).m436b(C3109bk.m18982a(context.getText(R.string.compare_apk_mess), spannableString, spannableString2)).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(context, interfaceC2995n, fileArr) { // from class: ru.maximoff.apktool.util.u.9

            /* renamed from: a */
            private final Context f20593a;

            /* renamed from: b */
            private final InterfaceC2995n f20594b;

            /* renamed from: c */
            private final File[] f20595c;

            {
                this.f20593a = context;
                this.f20594b = interfaceC2995n;
                this.f20595c = fileArr;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                try {
                    new AsyncTaskC2936g(this.f20593a, this.f20594b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20595c);
                } catch (Exception e2) {
                    C3112bn.m18999a(this.f20593a, R.string.error);
                }
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.swap, (DialogInterface.OnClickListener) null).m438b();
        m438b.setOnShowListener(new DialogInterface.OnShowListener(m438b, fileArr, m19470a, m19470a2, context) { // from class: ru.maximoff.apktool.util.u.10

            /* renamed from: a */
            private final DialogInterfaceC0070b f19882a;

            /* renamed from: b */
            private final File[] f19883b;

            /* renamed from: c */
            private final int f19884c;

            /* renamed from: d */
            private final int f19885d;

            /* renamed from: e */
            private final Context f19886e;

            {
                this.f19882a = m438b;
                this.f19883b = fileArr;
                this.f19884c = m19470a;
                this.f19885d = m19470a2;
                this.f19886e = context;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f19882a.m414a(-3).setOnClickListener(new View.OnClickListener(this, this.f19883b, this.f19884c, this.f19885d, (TextView) this.f19882a.findViewById(C0012R.id.message), this.f19886e) { // from class: ru.maximoff.apktool.util.u.10.1

                    /* renamed from: a */
                    private final AnonymousClass10 f19887a;

                    /* renamed from: b */
                    private final File[] f19888b;

                    /* renamed from: c */
                    private final int f19889c;

                    /* renamed from: d */
                    private final int f19890d;

                    /* renamed from: e */
                    private final TextView f19891e;

                    /* renamed from: f */
                    private final Context f19892f;

                    {
                        this.f19887a = this;
                        this.f19888b = r2;
                        this.f19889c = r3;
                        this.f19890d = r4;
                        this.f19891e = r5;
                        this.f19892f = r6;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        File file = this.f19888b[0];
                        this.f19888b[0] = this.f19888b[1];
                        this.f19888b[1] = file;
                        String absolutePath3 = this.f19888b[0].getAbsolutePath();
                        String absolutePath4 = this.f19888b[1].getAbsolutePath();
                        SpannableString spannableString3 = new SpannableString(absolutePath3);
                        spannableString3.setSpan(new ForegroundColorSpan(this.f19889c), absolutePath3.lastIndexOf(47) + 1, absolutePath3.length(), 33);
                        SpannableString spannableString4 = new SpannableString(absolutePath4);
                        spannableString4.setSpan(new ForegroundColorSpan(this.f19890d), absolutePath4.lastIndexOf(47) + 1, absolutePath4.length(), 33);
                        this.f19891e.setText(C3109bk.m18982a(this.f19892f.getText(R.string.compare_apk_mess), spannableString3, spannableString4));
                    }
                });
            }
        });
        m438b.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m19630b(Context context, AsyncTaskC2926ba asyncTaskC2926ba, File[] fileArr) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.mdialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.mdialogTextView1)).setText(R.string.custom_size_info_vc);
        EditText editText = (EditText) inflate.findViewById(R.id.mdialogEditText1);
        editText.setInputType(8194);
        editText.setText(String.valueOf(C3102bd.m18905a(context, "vcto_png_size", 0)));
        editText.setHint(R.string.custom_size);
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(context).m418a(R.string.to_png).m435b(inflate).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(editText, context, asyncTaskC2926ba, fileArr) { // from class: ru.maximoff.apktool.util.u.11

            /* renamed from: a */
            private final EditText f19931a;

            /* renamed from: b */
            private final Context f19932b;

            /* renamed from: c */
            private final AsyncTaskC2926ba f19933c;

            /* renamed from: d */
            private final File[] f19934d;

            {
                this.f19931a = editText;
                this.f19932b = context;
                this.f19933c = asyncTaskC2926ba;
                this.f19934d = fileArr;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    int abs = Math.abs(Integer.parseInt(this.f19931a.getText().toString()));
                    C3102bd.m18935b(this.f19932b, "vcto_png_size", abs);
                    this.f19933c.m17414b(abs);
                    this.f19933c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f19934d);
                } catch (Exception e2) {
                    C3112bn.m18999a(this.f19932b, R.string.error);
                }
                dialogInterface.cancel();
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(editText) { // from class: ru.maximoff.apktool.util.u.12

            /* renamed from: a */
            private final EditText f20026a;

            {
                this.f20026a = editText;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f20026a.requestFocus();
                this.f20026a.selectAll();
            }
        });
        m438b.show();
    }

    /* renamed from: d */
    private static boolean m19656d(File[] fileArr) {
        if (fileArr == null) {
            return false;
        }
        for (File file : fileArr) {
            if (!file.isDirectory() || !file.getName().startsWith("smali")) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m19631b(Context context, InterfaceC2995n interfaceC2995n, File file) {
        C3060a c3060a;
        View inflate = LayoutInflater.from(context).inflate(R.layout.rename_one, (ViewGroup) null);
        EditText editText = (EditText) inflate.findViewById(R.id.renameoneEditText1);
        editText.setSingleLine(true);
        editText.setText(file.getName());
        String string = file.isDirectory() ? context.getString(R.string.dirf, file.getName()) : context.getString(R.string.filef, file.getName());
        TextView textView = (TextView) inflate.findViewById(R.id.renameoneTextView1);
        C3112bn.m19009a(textView, string);
        textView.setOnClickListener(new View.OnClickListener(editText, file) { // from class: ru.maximoff.apktool.util.u.13

            /* renamed from: a */
            private final EditText f20073a;

            /* renamed from: b */
            private final File f20074b;

            {
                this.f20073a = editText;
                this.f20074b = file;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C3112bn.m19007a(this.f20073a, (CharSequence) this.f20074b.getName());
            }
        });
        textView.setOnLongClickListener(new View.OnLongClickListener(context, file) { // from class: ru.maximoff.apktool.util.u.14

            /* renamed from: a */
            private final Context f20075a;

            /* renamed from: b */
            private final File f20076b;

            {
                this.f20075a = context;
                this.f20076b = file;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                C3112bn.m19002a(this.f20075a, this.f20076b.getName());
                return true;
            }
        });
        ImageView imageView = (ImageView) inflate.findViewById(R.id.renameoneImageView1);
        imageView.setVisibility(0);
        if (C3102bd.f18291a) {
            imageView.setImageResource(R.drawable.ic_paste_light);
        } else {
            imageView.setImageResource(R.drawable.ic_paste_dark);
        }
        imageView.setOnClickListener(new View.OnClickListener(context, editText) { // from class: ru.maximoff.apktool.util.u.15

            /* renamed from: a */
            private final Context f20077a;

            /* renamed from: b */
            private final EditText f20078b;

            {
                this.f20077a = context;
                this.f20078b = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String m18991a = C3112bn.m18991a(this.f20077a);
                if (m18991a != null) {
                    C3112bn.m19007a(this.f20078b, (CharSequence) m18991a);
                } else {
                    C3112bn.m18999a(this.f20077a, R.string.empty);
                }
            }
        });
        DialogInterfaceC0070b.a m434b = new DialogInterfaceC0070b.a(context).m418a(R.string.rename).m435b(inflate).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(file, editText, context, interfaceC2995n) { // from class: ru.maximoff.apktool.util.u.16

            /* renamed from: a */
            private final File f20079a;

            /* renamed from: b */
            private final EditText f20080b;

            /* renamed from: c */
            private final Context f20081c;

            /* renamed from: d */
            private final InterfaceC2995n f20082d;

            {
                this.f20079a = file;
                this.f20080b = editText;
                this.f20081c = context;
                this.f20082d = interfaceC2995n;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                boolean renameTo;
                File file2 = new File(this.f20079a.getParentFile(), this.f20080b.getText().toString());
                if (file2.exists()) {
                    File file3 = new File(this.f20079a.getParentFile(), new StringBuffer().append(".").append(C3112bn.m18988a(7)).toString());
                    while (file3.exists()) {
                        file3 = new File(this.f20079a.getParentFile(), new StringBuffer().append(".").append(C3112bn.m18988a(7)).toString());
                    }
                    if (this.f20079a.renameTo(file3)) {
                        renameTo = file3.renameTo(file2);
                    } else {
                        renameTo = false;
                    }
                } else {
                    renameTo = this.f20079a.renameTo(file2);
                }
                if (!renameTo) {
                    C3112bn.m18999a(this.f20081c, R.string.error);
                }
                this.f20082d.mo17929a();
                C2978b.f16135a.m17711f();
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null);
        if (file.getName().endsWith(".apk")) {
            c3060a = new C3060a(context, file);
        } else {
            c3060a = (C3060a) null;
        }
        if (c3060a != null && c3060a.m18255D()) {
            m434b.m440c(R.string.mauto, (DialogInterface.OnClickListener) null);
        } else {
            m434b.m437b("{}", (DialogInterface.OnClickListener) null);
        }
        DialogInterfaceC0070b m438b = m434b.m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(m438b, c3060a, context, file, editText) { // from class: ru.maximoff.apktool.util.u.17

            /* renamed from: a */
            private final DialogInterfaceC0070b f20083a;

            /* renamed from: b */
            private final C3060a f20084b;

            /* renamed from: c */
            private final Context f20085c;

            /* renamed from: d */
            private final File f20086d;

            /* renamed from: e */
            private final EditText f20087e;

            {
                this.f20083a = m438b;
                this.f20084b = c3060a;
                this.f20085c = context;
                this.f20086d = file;
                this.f20087e = editText;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                Button m414a = this.f20083a.m414a(-3);
                if (this.f20084b != null && this.f20084b.m18255D()) {
                    m414a.setOnClickListener(new View.OnClickListener(this, this.f20085c, this.f20084b, this.f20086d, this.f20087e) { // from class: ru.maximoff.apktool.util.u.17.1

                        /* renamed from: a */
                        private final AnonymousClass17 f20088a;

                        /* renamed from: b */
                        private final Context f20089b;

                        /* renamed from: c */
                        private final C3060a f20090c;

                        /* renamed from: d */
                        private final File f20091d;

                        /* renamed from: e */
                        private final EditText f20092e;

                        {
                            this.f20088a = this;
                            this.f20089b = r2;
                            this.f20090c = r3;
                            this.f20091d = r4;
                            this.f20092e = r5;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            String str;
                            try {
                                str = C3112bn.m19033h(C3112bn.m18992a(this.f20089b, this.f20090c, C3102bd.m18910a(this.f20089b, "apk_name_tpl", "{LABEL}_v{VERSION}({CODE})")));
                            } catch (Exception e2) {
                                C3112bn.m18999a(this.f20089b, R.string.error);
                                str = C3262u.m19641b(this.f20091d.getName())[0];
                            }
                            this.f20092e.setText(new StringBuffer().append(str).append(".apk").toString());
                            this.f20092e.requestFocus();
                            this.f20092e.setSelection(0, str.length());
                        }
                    });
                    m414a.setOnLongClickListener(new View.OnLongClickListener(this, this.f20085c) { // from class: ru.maximoff.apktool.util.u.17.2

                        /* renamed from: a */
                        private final AnonymousClass17 f20093a;

                        /* renamed from: b */
                        private final Context f20094b;

                        {
                            this.f20093a = this;
                            this.f20094b = r2;
                        }

                        @Override // android.view.View.OnLongClickListener
                        public boolean onLongClick(View view) {
                            C3262u.m19575a(this.f20094b);
                            return true;
                        }
                    });
                    m414a.setText("...");
                    m414a.setEnabled(false);
                    this.f20084b.m18263a(new C3060a.a(this, m414a) { // from class: ru.maximoff.apktool.util.u.17.3

                        /* renamed from: a */
                        private final AnonymousClass17 f20095a;

                        /* renamed from: b */
                        private final Button f20096b;

                        {
                            this.f20095a = this;
                            this.f20096b = m414a;
                        }

                        @Override // ru.maximoff.apktool.util.C3060a.a
                        /* renamed from: a */
                        public void mo17840a() {
                            this.f20096b.setEnabled(true);
                            this.f20096b.setText(R.string.mauto);
                        }
                    });
                } else {
                    m414a.setOnClickListener(new View.OnClickListener(this, this.f20085c, this.f20087e) { // from class: ru.maximoff.apktool.util.u.17.4

                        /* renamed from: a */
                        private final AnonymousClass17 f20097a;

                        /* renamed from: b */
                        private final Context f20098b;

                        /* renamed from: c */
                        private final EditText f20099c;

                        {
                            this.f20097a = this;
                            this.f20098b = r2;
                            this.f20099c = r3;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            String[] split = C3102bd.f18266B.split(" ", 2);
                            String[] strArr = {C3112bn.m19032g(split[0]), C3112bn.m19032g(split[1]), C3112bn.m19032g(C3102bd.f18266B)};
                            C0173ao c0173ao = new C0173ao(this.f20098b, view);
                            for (int i = 0; i < strArr.length; i++) {
                                c0173ao.m1339a().add(0, i + MediaCodec.CodecException.ERROR_INSUFFICIENT_RESOURCE, 0, strArr[i]).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f20099c) { // from class: ru.maximoff.apktool.util.u.17.4.1

                                    /* renamed from: a */
                                    private final AnonymousClass4 f20100a;

                                    /* renamed from: b */
                                    private final EditText f20101b;

                                    {
                                        this.f20100a = this;
                                        this.f20101b = r2;
                                    }

                                    @Override // android.view.MenuItem.OnMenuItemClickListener
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        C3112bn.m19007a(this.f20101b, (CharSequence) menuItem.getTitle().toString());
                                        return true;
                                    }
                                });
                            }
                            c0173ao.m1344c();
                        }
                    });
                }
                this.f20087e.requestFocus();
                String name = this.f20086d.getName();
                int lastIndexOf = name.lastIndexOf(46);
                if (name.endsWith(".bak")) {
                    this.f20087e.setSelection(lastIndexOf, name.length());
                    return;
                }
                if (lastIndexOf <= 0 || this.f20086d.isDirectory()) {
                    lastIndexOf = name.length();
                }
                this.f20087e.setSelection(0, lastIndexOf);
            }
        });
        m438b.show();
        Button m414a = m438b.m414a(-1);
        editText.addTextChangedListener(new TextWatcher(m414a, file) { // from class: ru.maximoff.apktool.util.u.18

            /* renamed from: a */
            private final Button f20102a;

            /* renamed from: b */
            private final File f20103b;

            {
                this.f20102a = m414a;
                this.f20103b = file;
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
                    this.f20102a.setEnabled(false);
                    return;
                }
                String editable2 = editable.toString();
                if (C3112bn.m19034i(editable2)) {
                    this.f20102a.setEnabled(false);
                    return;
                }
                File file2 = new File(this.f20103b.getParentFile(), editable2);
                if (C3262u.m19615a(file2, editable2)) {
                    this.f20102a.setEnabled(false);
                } else if (file2.exists() && !editable2.equalsIgnoreCase(this.f20103b.getName())) {
                    this.f20102a.setEnabled(false);
                } else {
                    this.f20102a.setEnabled(true);
                }
            }
        });
        m414a.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m19632b(Context context, InterfaceC2995n interfaceC2995n, File[] fileArr) {
        int i;
        if (fileArr == null || fileArr.length == 0) {
            C3112bn.m19023b(context, context.getString(R.string.error));
            return;
        }
        boolean m19617a = m19617a(fileArr);
        C3212b c3212b = new C3212b(context, "rename_template");
        C3212b c3212b2 = new C3212b(context, "rename_search");
        C3212b c3212b3 = new C3212b(context, "rename_replace");
        View inflate = LayoutInflater.from(context).inflate(R.layout.rename, (ViewGroup) null);
        EditText editText = (EditText) inflate.findViewById(R.id.renameEditText1);
        EditText editText2 = (EditText) inflate.findViewById(R.id.renameEditText2);
        EditText editText3 = (EditText) inflate.findViewById(R.id.renameEditText3);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.renameImageView1);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.renameImageView2);
        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.renameImageView3);
        ((TextView) inflate.findViewById(R.id.renameTextView1)).setText(context.getString(R.string.rename_help, C3112bn.m19032g("yyyyMMdd"), C3112bn.m19032g("HHmmss")));
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.renameCheckBox1);
        checkBox.setText(context.getString(R.string.search_regexp).toLowerCase());
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.renameCheckBox2);
        checkBox2.setText(context.getString(R.string.mauto).toLowerCase());
        if (m19617a) {
            checkBox2.setVisibility(0);
        } else {
            checkBox2.setVisibility(8);
        }
        if (C3102bd.f18291a) {
            i = R.drawable.ic_collapse;
        } else {
            i = R.drawable.ic_collapse_dark;
        }
        imageView.setImageResource(i);
        imageView2.setImageResource(i);
        imageView3.setImageResource(i);
        imageView.setClickable(true);
        imageView2.setClickable(true);
        imageView3.setClickable(true);
        List<String> m19205b = c3212b.m19205b();
        if (m19205b.isEmpty()) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            editText.setText(m19205b.get(m19205b.size() - 1));
        }
        if (c3212b2.m19205b().isEmpty()) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setVisibility(0);
        }
        if (c3212b3.m19205b().isEmpty()) {
            imageView3.setVisibility(8);
        } else {
            imageView3.setVisibility(0);
        }
        imageView.setOnClickListener(new View.OnClickListener(c3212b, imageView, editText) { // from class: ru.maximoff.apktool.util.u.19

            /* renamed from: a */
            private final C3212b f20104a;

            /* renamed from: b */
            private final ImageView f20105b;

            /* renamed from: c */
            private final EditText f20106c;

            {
                this.f20104a = c3212b;
                this.f20105b = imageView;
                this.f20106c = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f20104a.m19201a(this.f20105b, this.f20106c);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener(c3212b2, imageView2, editText2) { // from class: ru.maximoff.apktool.util.u.20

            /* renamed from: a */
            private final C3212b f20110a;

            /* renamed from: b */
            private final ImageView f20111b;

            /* renamed from: c */
            private final EditText f20112c;

            {
                this.f20110a = c3212b2;
                this.f20111b = imageView2;
                this.f20112c = editText2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f20110a.m19201a(this.f20111b, this.f20112c);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener(c3212b3, imageView3, editText3) { // from class: ru.maximoff.apktool.util.u.21

            /* renamed from: a */
            private final C3212b f20113a;

            /* renamed from: b */
            private final ImageView f20114b;

            /* renamed from: c */
            private final EditText f20115c;

            {
                this.f20113a = c3212b3;
                this.f20114b = imageView3;
                this.f20115c = editText3;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f20113a.m19201a(this.f20114b, this.f20115c);
            }
        });
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(context).m427a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(context.getString(R.string.rename)).append(" (").toString()).append(fileArr.length).toString()).append(")").toString()).m435b(inflate).m420a(R.string.preview, (DialogInterface.OnClickListener) null).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m437b("{}", (DialogInterface.OnClickListener) null).m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(m438b, editText, editText2, editText3, c3212b, imageView, c3212b2, imageView2, c3212b3, imageView3, context, interfaceC2995n, checkBox, m19617a, checkBox2, fileArr) { // from class: ru.maximoff.apktool.util.u.22

            /* renamed from: a */
            private final DialogInterfaceC0070b f20116a;

            /* renamed from: b */
            private final EditText f20117b;

            /* renamed from: c */
            private final EditText f20118c;

            /* renamed from: d */
            private final EditText f20119d;

            /* renamed from: e */
            private final C3212b f20120e;

            /* renamed from: f */
            private final ImageView f20121f;

            /* renamed from: g */
            private final C3212b f20122g;

            /* renamed from: h */
            private final ImageView f20123h;

            /* renamed from: i */
            private final C3212b f20124i;

            /* renamed from: j */
            private final ImageView f20125j;

            /* renamed from: k */
            private final Context f20126k;

            /* renamed from: l */
            private final InterfaceC2995n f20127l;

            /* renamed from: m */
            private final CheckBox f20128m;

            /* renamed from: n */
            private final boolean f20129n;

            /* renamed from: o */
            private final CheckBox f20130o;

            /* renamed from: p */
            private final File[] f20131p;

            {
                this.f20116a = m438b;
                this.f20117b = editText;
                this.f20118c = editText2;
                this.f20119d = editText3;
                this.f20120e = c3212b;
                this.f20121f = imageView;
                this.f20122g = c3212b2;
                this.f20123h = imageView2;
                this.f20124i = c3212b3;
                this.f20125j = imageView3;
                this.f20126k = context;
                this.f20127l = interfaceC2995n;
                this.f20128m = checkBox;
                this.f20129n = m19617a;
                this.f20130o = checkBox2;
                this.f20131p = fileArr;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                Button m414a = this.f20116a.m414a(-1);
                Button m414a2 = this.f20116a.m414a(-3);
                m414a.setOnClickListener(new View.OnClickListener(this, this.f20117b, this.f20118c, this.f20119d, this.f20120e, this.f20121f, this.f20122g, this.f20123h, this.f20124i, this.f20125j, this.f20126k, this.f20127l, this.f20128m, this.f20129n, this.f20130o, this.f20116a, this.f20131p) { // from class: ru.maximoff.apktool.util.u.22.1

                    /* renamed from: a */
                    private final AnonymousClass22 f20132a;

                    /* renamed from: b */
                    private final EditText f20133b;

                    /* renamed from: c */
                    private final EditText f20134c;

                    /* renamed from: d */
                    private final EditText f20135d;

                    /* renamed from: e */
                    private final C3212b f20136e;

                    /* renamed from: f */
                    private final ImageView f20137f;

                    /* renamed from: g */
                    private final C3212b f20138g;

                    /* renamed from: h */
                    private final ImageView f20139h;

                    /* renamed from: i */
                    private final C3212b f20140i;

                    /* renamed from: j */
                    private final ImageView f20141j;

                    /* renamed from: k */
                    private final Context f20142k;

                    /* renamed from: l */
                    private final InterfaceC2995n f20143l;

                    /* renamed from: m */
                    private final CheckBox f20144m;

                    /* renamed from: n */
                    private final boolean f20145n;

                    /* renamed from: o */
                    private final CheckBox f20146o;

                    /* renamed from: p */
                    private final DialogInterfaceC0070b f20147p;

                    /* renamed from: q */
                    private final File[] f20148q;

                    {
                        this.f20132a = this;
                        this.f20133b = r3;
                        this.f20134c = r4;
                        this.f20135d = r5;
                        this.f20136e = r6;
                        this.f20137f = r7;
                        this.f20138g = r8;
                        this.f20139h = r9;
                        this.f20140i = r10;
                        this.f20141j = r11;
                        this.f20142k = r12;
                        this.f20143l = r13;
                        this.f20144m = r14;
                        this.f20145n = r15;
                        this.f20146o = r16;
                        this.f20147p = r17;
                        this.f20148q = r18;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        boolean z = false;
                        String editable = this.f20133b.getText().toString();
                        if (editable.isEmpty()) {
                            editable = (String) null;
                        }
                        String editable2 = this.f20134c.getText().toString();
                        if (editable2.isEmpty()) {
                            editable2 = (String) null;
                        }
                        String editable3 = this.f20135d.getText().toString();
                        if (this.f20136e.m19204a(editable)) {
                            this.f20137f.setVisibility(0);
                        }
                        if (this.f20138g.m19204a(editable2)) {
                            this.f20139h.setVisibility(0);
                        }
                        if (this.f20140i.m19204a(editable3)) {
                            this.f20141j.setVisibility(0);
                        }
                        try {
                            Context context2 = this.f20142k;
                            InterfaceC2995n interfaceC2995n2 = this.f20143l;
                            boolean isChecked = this.f20144m.isChecked();
                            if (this.f20145n && this.f20146o.isChecked()) {
                                z = true;
                            }
                            new AsyncTaskC2906ah(context2, interfaceC2995n2, editable, editable2, editable3, isChecked, z, this.f20147p).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20148q);
                        } catch (Exception e2) {
                            C3112bn.m18999a(this.f20142k, R.string.error_try_again);
                        }
                    }
                });
                m414a2.setOnClickListener(new View.OnClickListener(this, this.f20126k, this.f20118c, this.f20119d, this.f20117b, this.f20129n) { // from class: ru.maximoff.apktool.util.u.22.2

                    /* renamed from: a */
                    private final AnonymousClass22 f20149a;

                    /* renamed from: b */
                    private final Context f20150b;

                    /* renamed from: c */
                    private final EditText f20151c;

                    /* renamed from: d */
                    private final EditText f20152d;

                    /* renamed from: e */
                    private final EditText f20153e;

                    /* renamed from: f */
                    private final boolean f20154f;

                    {
                        this.f20149a = this;
                        this.f20150b = r2;
                        this.f20151c = r3;
                        this.f20152d = r4;
                        this.f20153e = r5;
                        this.f20154f = r6;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String[] split = C3102bd.f18266B.split(" ", 2);
                        String[] strArr = {"{NAME}", "{EXT}", "{DATE}", "{TIME}", "{0}", C3112bn.m19032g(split[0]), C3112bn.m19032g(split[1]), C3112bn.m19032g(C3102bd.f18266B)};
                        C0173ao c0173ao = new C0173ao(this.f20150b, view);
                        c0173ao.m1340a(C3102bd.m18910a(this.f20150b, "menu_position", "1").equals("0") ? 3 : 5);
                        for (int i2 = 0; i2 < strArr.length; i2++) {
                            c0173ao.m1339a().add(0, i2 + MediaCodec.CodecException.ERROR_INSUFFICIENT_RESOURCE, 0, strArr[i2]).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f20151c, this.f20152d, this.f20153e) { // from class: ru.maximoff.apktool.util.u.22.2.1

                                /* renamed from: a */
                                private final AnonymousClass2 f20155a;

                                /* renamed from: b */
                                private final EditText f20156b;

                                /* renamed from: c */
                                private final EditText f20157c;

                                /* renamed from: d */
                                private final EditText f20158d;

                                {
                                    this.f20155a = this;
                                    this.f20156b = r2;
                                    this.f20157c = r3;
                                    this.f20158d = r4;
                                }

                                @Override // android.view.MenuItem.OnMenuItemClickListener
                                public boolean onMenuItemClick(MenuItem menuItem) {
                                    String charSequence = menuItem.getTitle().toString();
                                    if (this.f20156b.isFocused()) {
                                        C3112bn.m19007a(this.f20156b, (CharSequence) charSequence);
                                        return true;
                                    }
                                    if (this.f20157c.isFocused()) {
                                        C3112bn.m19007a(this.f20157c, (CharSequence) charSequence);
                                        return true;
                                    }
                                    C3112bn.m19007a(this.f20158d, (CharSequence) charSequence);
                                    return true;
                                }
                            });
                        }
                        if (this.f20154f) {
                            c0173ao.m1339a().add(0, strArr.length + MediaCodec.CodecException.ERROR_INSUFFICIENT_RESOURCE, 0, R.string.apk_template).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f20150b) { // from class: ru.maximoff.apktool.util.u.22.2.2

                                /* renamed from: a */
                                private final AnonymousClass2 f20159a;

                                /* renamed from: b */
                                private final Context f20160b;

                                {
                                    this.f20159a = this;
                                    this.f20160b = r2;
                                }

                                @Override // android.view.MenuItem.OnMenuItemClickListener
                                public boolean onMenuItemClick(MenuItem menuItem) {
                                    C3262u.m19575a(this.f20160b);
                                    return true;
                                }
                            });
                        }
                        c0173ao.m1344c();
                    }
                });
                this.f20117b.requestFocus();
                this.f20117b.setSelection(this.f20117b.getText().toString().length());
            }
        });
        m438b.show();
    }

    /* renamed from: a */
    public static void m19575a(Context context) {
        LayoutInflater from = LayoutInflater.from(context);
        String m18910a = C3102bd.m18910a(context, "apk_name_tpl", "{LABEL}_v{VERSION}({CODE})");
        String m18910a2 = C3102bd.m18910a(context, "apk_name_chars_remove", "");
        View inflate = from.inflate(R.layout.aname_tpl, (ViewGroup) null);
        EditText editText = (EditText) inflate.findViewById(R.id.anametplEditText1);
        editText.setText(m18910a);
        editText.setHint("{LABEL}_v{VERSION}({CODE})");
        EditText editText2 = (EditText) inflate.findViewById(R.id.anametplEditText2);
        editText2.setText(m18910a2);
        C3212b c3212b = new C3212b(context, "apk_name");
        ImageView imageView = (ImageView) inflate.findViewById(R.id.anametplImageView1);
        imageView.setClickable(true);
        if (C3102bd.f18291a) {
            imageView.setImageResource(R.drawable.ic_collapse);
        } else {
            imageView.setImageResource(R.drawable.ic_collapse_dark);
        }
        if (c3212b.m19205b().isEmpty()) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
        }
        imageView.setOnClickListener(new View.OnClickListener(c3212b, imageView, editText) { // from class: ru.maximoff.apktool.util.u.23

            /* renamed from: a */
            private final C3212b f20161a;

            /* renamed from: b */
            private final ImageView f20162b;

            /* renamed from: c */
            private final EditText f20163c;

            {
                this.f20161a = c3212b;
                this.f20162b = imageView;
                this.f20163c = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f20161a.m19201a(this.f20162b, this.f20163c);
            }
        });
        imageView.setOnLongClickListener(new View.OnLongClickListener(c3212b, imageView, context) { // from class: ru.maximoff.apktool.util.u.24

            /* renamed from: a */
            private final C3212b f20164a;

            /* renamed from: b */
            private final ImageView f20165b;

            /* renamed from: c */
            private final Context f20166c;

            {
                this.f20164a = c3212b;
                this.f20165b = imageView;
                this.f20166c = context;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                new C3078aj(this.f20166c).m18500b(R.string.clear_history).m18495a(R.string.yes, new Runnable(this, this.f20164a, this.f20165b) { // from class: ru.maximoff.apktool.util.u.24.1

                    /* renamed from: a */
                    private final AnonymousClass24 f20167a;

                    /* renamed from: b */
                    private final C3212b f20168b;

                    /* renamed from: c */
                    private final ImageView f20169c;

                    {
                        this.f20167a = this;
                        this.f20168b = r2;
                        this.f20169c = r3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f20168b.m19208d();
                        this.f20169c.setVisibility(8);
                    }
                }).m18508e(R.string.cancel).m18507d();
                return true;
            }
        });
        ((Button) inflate.findViewById(R.id.anametplButton1)).setOnClickListener(new View.OnClickListener(context, editText) { // from class: ru.maximoff.apktool.util.u.25

            /* renamed from: a */
            private final Context f20170a;

            /* renamed from: b */
            private final EditText f20171b;

            {
                this.f20170a = context;
                this.f20171b = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                C0173ao c0173ao = new C0173ao(this.f20170a, view);
                if (C3102bd.m18910a(this.f20170a, "menu_position", "1").equals("0")) {
                    i = 3;
                } else {
                    i = 5;
                }
                c0173ao.m1340a(i);
                for (int i2 = 0; i2 < C3112bn.f18385c.length; i2++) {
                    c0173ao.m1339a().add(0, i2 + MediaCodec.CodecException.ERROR_INSUFFICIENT_RESOURCE, 0, C3112bn.f18385c[i2]).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f20171b) { // from class: ru.maximoff.apktool.util.u.25.1

                        /* renamed from: a */
                        private final AnonymousClass25 f20172a;

                        /* renamed from: b */
                        private final EditText f20173b;

                        {
                            this.f20172a = this;
                            this.f20173b = r2;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            C3112bn.m19007a(this.f20173b, (CharSequence) menuItem.getTitle().toString());
                            return true;
                        }
                    });
                }
                c0173ao.m1344c();
            }
        });
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(context).m435b(inflate).m418a(R.string.apk_template).m420a(R.string.save, new DialogInterface.OnClickListener(editText, editText2, context, c3212b) { // from class: ru.maximoff.apktool.util.u.26

            /* renamed from: a */
            private final EditText f20174a;

            /* renamed from: b */
            private final EditText f20175b;

            /* renamed from: c */
            private final Context f20176c;

            /* renamed from: d */
            private final C3212b f20177d;

            {
                this.f20174a = editText;
                this.f20175b = editText2;
                this.f20176c = context;
                this.f20177d = c3212b;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                String editable = this.f20174a.getText().toString();
                String editable2 = this.f20175b.getText().toString();
                C3102bd.m18937b(this.f20176c, "apk_name_tpl", editable);
                C3102bd.m18937b(this.f20176c, "apk_name_chars_remove", editable2);
                this.f20177d.m19204a(editable);
                dialogInterface.dismiss();
            }
        }).m440c(R.string.search_reset, new DialogInterface.OnClickListener(context) { // from class: ru.maximoff.apktool.util.u.27

            /* renamed from: a */
            private final Context f20178a;

            {
                this.f20178a = context;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                C3102bd.m18937b(this.f20178a, "apk_name_tpl", "{LABEL}_v{VERSION}({CODE})");
                C3102bd.m18924a(this.f20178a, "apk_name_chars_remove");
                dialogInterface.dismiss();
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(editText) { // from class: ru.maximoff.apktool.util.u.28

            /* renamed from: a */
            private final EditText f20179a;

            {
                this.f20179a = editText;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f20179a.requestFocus();
                this.f20179a.selectAll();
            }
        });
        m438b.show();
    }

    /* renamed from: c */
    public static void m19645c(Context context, File[] fileArr, InterfaceC2995n interfaceC2995n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fileArr.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append('\"').append(fileArr[i].getName());
            if (fileArr[i].isDirectory()) {
                sb.append('/');
            }
            sb.append('\"');
        }
        String string = context.getString(R.string.delete);
        if (fileArr.length > 1) {
            string = new StringBuffer().append(string).append(new StringBuffer().append(new StringBuffer().append(" (").append(fileArr.length).toString()).append(")").toString()).toString();
        }
        new DialogInterfaceC0070b.a(context).m427a(string).m436b(sb.toString()).m420a(R.string.delete, new DialogInterface.OnClickListener(context, interfaceC2995n, fileArr) { // from class: ru.maximoff.apktool.util.u.29

            /* renamed from: a */
            private final Context f20180a;

            /* renamed from: b */
            private final InterfaceC2995n f20181b;

            /* renamed from: c */
            private final File[] f20182c;

            {
                this.f20180a = context;
                this.f20181b = interfaceC2995n;
                this.f20182c = fileArr;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                try {
                    new AsyncTaskC2941l(this.f20180a, this.f20181b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20182c);
                } catch (Exception e2) {
                    C3112bn.m18999a(this.f20180a, R.string.error_try_again);
                }
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m441c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m19633b(Context context, InterfaceC2995n interfaceC2995n, File[] fileArr, String str) {
        if (fileArr == null || fileArr.length == 0) {
            C3112bn.m19023b(context, context.getString(R.string.error));
            return;
        }
        String parent = fileArr[0].getParent();
        String[] strArr = {"Created by Apktool M – https://github.com/Maximoff/Apktool-M-updates"};
        String name = fileArr.length > 1 ? fileArr[0].getParentFile().getName() : m19641b(fileArr[0].getName())[0];
        LayoutInflater from = LayoutInflater.from(context);
        View inflate = from.inflate(R.layout.zip, (ViewGroup) null);
        EditText editText = (EditText) inflate.findViewById(R.id.zipEditText1);
        TextView textView = (TextView) inflate.findViewById(R.id.zipTextView1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.zipTextView3);
        Button button = (Button) inflate.findViewById(R.id.zipButton1);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.zipCheckBox1);
        Spinner spinner = (Spinner) inflate.findViewById(R.id.zipSpinner2);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.zipLinearLayout1);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.zipImageView1);
        imageView.setVisibility(0);
        if (C3102bd.f18291a) {
            imageView.setImageResource(R.drawable.ic_paste_light);
        } else {
            imageView.setImageResource(R.drawable.ic_paste_dark);
        }
        imageView.setOnClickListener(new View.OnClickListener(context, editText) { // from class: ru.maximoff.apktool.util.u.30

            /* renamed from: a */
            private final Context f20188a;

            /* renamed from: b */
            private final EditText f20189b;

            {
                this.f20188a = context;
                this.f20189b = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String m18991a = C3112bn.m18991a(this.f20188a);
                if (m18991a != null) {
                    C3112bn.m19007a(this.f20189b, (CharSequence) m18991a);
                } else {
                    C3112bn.m18999a(this.f20188a, R.string.empty);
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener(from, strArr, context) { // from class: ru.maximoff.apktool.util.u.31

            /* renamed from: a */
            private final LayoutInflater f20190a;

            /* renamed from: b */
            private final String[] f20191b;

            /* renamed from: c */
            private final Context f20192c;

            {
                this.f20190a = from;
                this.f20191b = strArr;
                this.f20192c = context;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View inflate2 = this.f20190a.inflate(R.layout.mdialog, (ViewGroup) null);
                EditText editText2 = (EditText) inflate2.findViewById(R.id.mdialogEditText1);
                ((TextView) inflate2.findViewById(R.id.mdialogTextView1)).setVisibility(8);
                editText2.setSingleLine(false);
                editText2.setHorizontallyScrolling(false);
                editText2.setInputType(131073);
                editText2.setHint(R.string.comment);
                if (this.f20191b[0] != null) {
                    editText2.setText(this.f20191b[0]);
                }
                DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f20192c).m418a(R.string.comment).m435b(inflate2).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, this.f20191b, editText2) { // from class: ru.maximoff.apktool.util.u.31.1

                    /* renamed from: a */
                    private final AnonymousClass31 f20193a;

                    /* renamed from: b */
                    private final String[] f20194b;

                    /* renamed from: c */
                    private final EditText f20195c;

                    {
                        this.f20193a = this;
                        this.f20194b = r2;
                        this.f20195c = editText2;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        this.f20194b[0] = this.f20195c.getText().toString();
                    }
                }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.paste, (DialogInterface.OnClickListener) null).m438b();
                m438b.getWindow().setSoftInputMode(4);
                m438b.setOnShowListener(new DialogInterface.OnShowListener(this, editText2, m438b, this.f20192c, this.f20191b) { // from class: ru.maximoff.apktool.util.u.31.2

                    /* renamed from: a */
                    private final AnonymousClass31 f20196a;

                    /* renamed from: b */
                    private final EditText f20197b;

                    /* renamed from: c */
                    private final DialogInterfaceC0070b f20198c;

                    /* renamed from: d */
                    private final Context f20199d;

                    /* renamed from: e */
                    private final String[] f20200e;

                    {
                        this.f20196a = this;
                        this.f20197b = editText2;
                        this.f20198c = m438b;
                        this.f20199d = r4;
                        this.f20200e = r5;
                    }

                    @Override // android.content.DialogInterface.OnShowListener
                    public void onShow(DialogInterface dialogInterface) {
                        this.f20197b.requestFocus();
                        this.f20197b.selectAll();
                        Button m414a = this.f20198c.m414a(-3);
                        m414a.setOnClickListener(new View.OnClickListener(this, this.f20199d, this.f20197b) { // from class: ru.maximoff.apktool.util.u.31.2.1

                            /* renamed from: a */
                            private final AnonymousClass2 f20201a;

                            /* renamed from: b */
                            private final Context f20202b;

                            /* renamed from: c */
                            private final EditText f20203c;

                            {
                                this.f20201a = this;
                                this.f20202b = r2;
                                this.f20203c = r3;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                String m18991a = C3112bn.m18991a(this.f20202b);
                                if (m18991a != null) {
                                    C3112bn.m19007a(this.f20203c, (CharSequence) m18991a);
                                } else {
                                    C3112bn.m18999a(this.f20202b, R.string.empty);
                                }
                            }
                        });
                        m414a.setOnLongClickListener(new View.OnLongClickListener(this, this.f20198c, this.f20200e) { // from class: ru.maximoff.apktool.util.u.31.2.2

                            /* renamed from: a */
                            private final AnonymousClass2 f20204a;

                            /* renamed from: b */
                            private final DialogInterfaceC0070b f20205b;

                            /* renamed from: c */
                            private final String[] f20206c;

                            {
                                this.f20204a = this;
                                this.f20205b = r2;
                                this.f20206c = r3;
                            }

                            @Override // android.view.View.OnLongClickListener
                            public boolean onLongClick(View view2) {
                                this.f20205b.cancel();
                                this.f20206c[0] = "Created by Apktool M – https://github.com/Maximoff/Apktool-M-updates";
                                return true;
                            }
                        });
                    }
                });
                m438b.show();
            }
        });
        spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(context, C0012R.layout.simple_spinner_dropdown_item, new String[]{context.getString(R.string.add_to_archive), context.getString(R.string.replace_to_archive), context.getString(R.string.skip_to_archive)}));
        Spinner spinner2 = (Spinner) inflate.findViewById(R.id.zipSpinner1);
        String string = context.getString(R.string.compress_level);
        String[] strArr2 = new String[10];
        for (int i = 0; i < 10; i++) {
            strArr2[i] = new StringBuffer().append(new StringBuffer().append(string).append(" - ").toString()).append(String.valueOf(i)).toString();
        }
        boolean[] zArr = {false};
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, C0012R.layout.simple_spinner_dropdown_item, strArr2);
        int m18905a = C3102bd.m18905a(context, "compression_level", 5);
        if (m18905a < 0 || m18905a > 9) {
            m18905a = 5;
        }
        spinner2.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner2.setSelection(m18905a);
        editText.setText(m19566a(context, parent, name, str, 0));
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(context).m418a(R.string.mcompress).m435b(inflate).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(spinner2, zArr, spinner, editText, context, textView, parent, interfaceC2995n, strArr, checkBox, fileArr) { // from class: ru.maximoff.apktool.util.u.32

            /* renamed from: a */
            private final Spinner f20207a;

            /* renamed from: b */
            private final boolean[] f20208b;

            /* renamed from: c */
            private final Spinner f20209c;

            /* renamed from: d */
            private final EditText f20210d;

            /* renamed from: e */
            private final Context f20211e;

            /* renamed from: f */
            private final TextView f20212f;

            /* renamed from: g */
            private final String f20213g;

            /* renamed from: h */
            private final InterfaceC2995n f20214h;

            /* renamed from: i */
            private final String[] f20215i;

            /* renamed from: j */
            private final CheckBox f20216j;

            /* renamed from: k */
            private final File[] f20217k;

            {
                this.f20207a = spinner2;
                this.f20208b = zArr;
                this.f20209c = spinner;
                this.f20210d = editText;
                this.f20211e = context;
                this.f20212f = textView;
                this.f20213g = parent;
                this.f20214h = interfaceC2995n;
                this.f20215i = strArr;
                this.f20216j = checkBox;
                this.f20217k = fileArr;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                int selectedItemPosition = this.f20207a.getSelectedItemPosition();
                if (this.f20208b[0]) {
                    selectedItemPosition--;
                }
                int selectedItemPosition2 = this.f20209c.getSelectedItemPosition();
                String[] m19641b = C3262u.m19641b(C3112bn.m19033h(this.f20210d.getText().toString()));
                if (selectedItemPosition >= 0) {
                    C3102bd.m18935b(this.f20211e, "compression_level", selectedItemPosition);
                }
                AsyncTaskC2930be asyncTaskC2930be = new AsyncTaskC2930be(this.f20211e, this.f20208b[0] ? this.f20212f.getText().toString() : new StringBuffer().append(new StringBuffer().append(this.f20213g).append("/").toString()).append(C3262u.m19566a(this.f20211e, this.f20213g, m19641b[0], new StringBuffer().append(".").append(m19641b[1]).toString(), 0)).toString(), selectedItemPosition, this.f20214h);
                asyncTaskC2930be.m17457g(this.f20208b[0]);
                asyncTaskC2930be.m17455a(selectedItemPosition2);
                asyncTaskC2930be.m17456a(this.f20215i[0]);
                asyncTaskC2930be.m17458h(this.f20216j.isChecked());
                try {
                    asyncTaskC2930be.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20217k);
                } catch (Exception e2) {
                    C3112bn.m18999a(this.f20211e, R.string.error_try_again);
                }
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.to_archive, (DialogInterface.OnClickListener) null).m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(editText, m438b, context, linearLayout, textView2, spinner, textView, zArr, spinner2) { // from class: ru.maximoff.apktool.util.u.33

            /* renamed from: a */
            private final EditText f20218a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f20219b;

            /* renamed from: c */
            private final Context f20220c;

            /* renamed from: d */
            private final LinearLayout f20221d;

            /* renamed from: e */
            private final TextView f20222e;

            /* renamed from: f */
            private final Spinner f20223f;

            /* renamed from: g */
            private final TextView f20224g;

            /* renamed from: h */
            private final boolean[] f20225h;

            /* renamed from: i */
            private final Spinner f20226i;

            {
                this.f20218a = editText;
                this.f20219b = m438b;
                this.f20220c = context;
                this.f20221d = linearLayout;
                this.f20222e = textView2;
                this.f20223f = spinner;
                this.f20224g = textView;
                this.f20225h = zArr;
                this.f20226i = spinner2;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f20218a.requestFocus();
                int lastIndexOf = this.f20218a.getText().toString().lastIndexOf(46);
                if (lastIndexOf <= 0) {
                    this.f20218a.selectAll();
                } else {
                    this.f20218a.setSelection(0, lastIndexOf);
                }
                Button m414a = this.f20219b.m414a(-3);
                m414a.setOnClickListener(new View.OnClickListener(this, this.f20220c, this.f20221d, this.f20222e, this.f20223f, this.f20224g, this.f20225h, this.f20226i) { // from class: ru.maximoff.apktool.util.u.33.1

                    /* renamed from: a */
                    private final AnonymousClass33 f20227a;

                    /* renamed from: b */
                    private final Context f20228b;

                    /* renamed from: c */
                    private final LinearLayout f20229c;

                    /* renamed from: d */
                    private final TextView f20230d;

                    /* renamed from: e */
                    private final Spinner f20231e;

                    /* renamed from: f */
                    private final TextView f20232f;

                    /* renamed from: g */
                    private final boolean[] f20233g;

                    /* renamed from: h */
                    private final Spinner f20234h;

                    {
                        this.f20227a = this;
                        this.f20228b = r2;
                        this.f20229c = r3;
                        this.f20230d = r4;
                        this.f20231e = r5;
                        this.f20232f = r6;
                        this.f20233g = r7;
                        this.f20234h = r8;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C3261t c3261t = new C3261t(this.f20228b);
                        Runnable runnable = new Runnable(this, this.f20229c, this.f20230d, this.f20231e, this.f20232f, c3261t, this.f20233g, this.f20228b, this.f20234h) { // from class: ru.maximoff.apktool.util.u.33.1.1

                            /* renamed from: a */
                            private final AnonymousClass1 f20235a;

                            /* renamed from: b */
                            private final LinearLayout f20236b;

                            /* renamed from: c */
                            private final TextView f20237c;

                            /* renamed from: d */
                            private final Spinner f20238d;

                            /* renamed from: e */
                            private final TextView f20239e;

                            /* renamed from: f */
                            private final C3261t f20240f;

                            /* renamed from: g */
                            private final boolean[] f20241g;

                            /* renamed from: h */
                            private final Context f20242h;

                            /* renamed from: i */
                            private final Spinner f20243i;

                            {
                                this.f20235a = this;
                                this.f20236b = r2;
                                this.f20237c = r3;
                                this.f20238d = r4;
                                this.f20239e = r5;
                                this.f20240f = c3261t;
                                this.f20241g = r7;
                                this.f20242h = r8;
                                this.f20243i = r9;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                this.f20236b.setVisibility(8);
                                this.f20237c.setVisibility(0);
                                this.f20238d.setVisibility(0);
                                this.f20239e.setVisibility(0);
                                this.f20239e.setText(this.f20240f.getPath());
                                this.f20241g[0] = true;
                                String string2 = this.f20242h.getString(R.string.compress_level);
                                String[] strArr3 = new String[11];
                                strArr3[0] = this.f20242h.getString(R.string.archive_mode);
                                for (int i2 = 0; i2 < 10; i2++) {
                                    strArr3[i2 + 1] = new StringBuffer().append(new StringBuffer().append(string2).append(" - ").toString()).append(String.valueOf(i2)).toString();
                                }
                                this.f20243i.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f20242h, C0012R.layout.simple_spinner_dropdown_item, strArr3));
                                this.f20243i.setSelection(0);
                            }
                        };
                        c3261t.m19545a("_tz");
                        c3261t.setCallback(runnable);
                        c3261t.setFilter(new String[]{"zip", "apk", "xapk", "apks", "jar", "aab"});
                        c3261t.m19543a();
                        c3261t.m19550e();
                        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(this.f20228b);
                        aVar.m427a(c3261t.m19548c());
                        aVar.m435b(c3261t);
                        aVar.m420a(R.string.cancel, (DialogInterface.OnClickListener) null);
                        aVar.m429a(false);
                        aVar.m422a(new DialogInterface.OnKeyListener(this, c3261t) { // from class: ru.maximoff.apktool.util.u.33.1.2

                            /* renamed from: a */
                            private final AnonymousClass1 f20244a;

                            /* renamed from: b */
                            private final C3261t f20245b;

                            {
                                this.f20244a = this;
                                this.f20245b = c3261t;
                            }

                            @Override // android.content.DialogInterface.OnKeyListener
                            public boolean onKey(DialogInterface dialogInterface2, int i2, KeyEvent keyEvent) {
                                if (i2 != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                                    return false;
                                }
                                boolean m19551f = this.f20245b.m19551f();
                                if (!m19551f) {
                                    dialogInterface2.dismiss();
                                    return m19551f;
                                }
                                return m19551f;
                            }
                        });
                        DialogInterfaceC0070b m438b2 = aVar.m438b();
                        c3261t.setDialog(m438b2);
                        m438b2.show();
                    }
                });
                m414a.setOnLongClickListener(new View.OnLongClickListener(this, this.f20225h, this.f20221d, this.f20222e, this.f20223f, this.f20224g, this.f20220c, this.f20226i) { // from class: ru.maximoff.apktool.util.u.33.2

                    /* renamed from: a */
                    private final AnonymousClass33 f20246a;

                    /* renamed from: b */
                    private final boolean[] f20247b;

                    /* renamed from: c */
                    private final LinearLayout f20248c;

                    /* renamed from: d */
                    private final TextView f20249d;

                    /* renamed from: e */
                    private final Spinner f20250e;

                    /* renamed from: f */
                    private final TextView f20251f;

                    /* renamed from: g */
                    private final Context f20252g;

                    /* renamed from: h */
                    private final Spinner f20253h;

                    {
                        this.f20246a = this;
                        this.f20247b = r2;
                        this.f20248c = r3;
                        this.f20249d = r4;
                        this.f20250e = r5;
                        this.f20251f = r6;
                        this.f20252g = r7;
                        this.f20253h = r8;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        if (!this.f20247b[0]) {
                            return false;
                        }
                        this.f20248c.setVisibility(0);
                        this.f20249d.setVisibility(8);
                        this.f20250e.setVisibility(8);
                        this.f20251f.setVisibility(8);
                        this.f20247b[0] = false;
                        String string2 = this.f20252g.getString(R.string.compress_level);
                        String[] strArr3 = new String[10];
                        for (int i2 = 0; i2 < 10; i2++) {
                            strArr3[i2] = new StringBuffer().append(new StringBuffer().append(string2).append(" - ").toString()).append(String.valueOf(i2)).toString();
                        }
                        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this.f20252g, C0012R.layout.simple_spinner_dropdown_item, strArr3);
                        int m18905a2 = C3102bd.m18905a(this.f20252g, "compression_level", 5);
                        if (m18905a2 < 0 || m18905a2 > 9) {
                            m18905a2 = 5;
                        }
                        this.f20253h.setAdapter((SpinnerAdapter) arrayAdapter2);
                        this.f20253h.setSelection(m18905a2);
                        return true;
                    }
                });
            }
        });
        m438b.show();
    }

    /* renamed from: a */
    public static void m19588a(Context context, File file, InterfaceC2995n interfaceC2995n, List<C3247a> list, String str, String str2) {
        int i;
        try {
            boolean m19664g = m19664g(context, file);
            String str3 = m19641b(file.getName())[0];
            View inflate = LayoutInflater.from(context).inflate(R.layout.zip_viewer, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.zipviewerLinearLayout1);
            Spinner spinner = (Spinner) inflate.findViewById(R.id.zipviewerSpinner1);
            boolean z = file.getName().toLowerCase().endsWith(".apk") && m19664g;
            if (z) {
                linearLayout.setVisibility(0);
                boolean m18925a = C3102bd.m18925a(context, "custom_signature_file", false);
                int m18905a = C3102bd.m18905a(context, "selected_signature", 1);
                String[] strArr = new String[m18925a ? 3 : 2];
                strArr[0] = context.getString(R.string.not_sign);
                strArr[1] = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(context.getString(R.string.default_signature_file)).append(" (").toString()).append(C3102bd.f18324g).toString()).append(")").toString();
                if (m18925a) {
                    strArr[2] = context.getString(R.string.custom_signature_file);
                    i = m18905a;
                } else {
                    i = m18905a > 2 ? 1 : m18905a;
                }
                C3102bd.f18317ay = (boolean[]) null;
                String[] stringArray = context.getResources().getStringArray(R.array.keys);
                spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(context, C0012R.layout.simple_spinner_dropdown_item, strArr));
                spinner.setSelection(i);
                spinner.setOnLongClickListener(new View.OnLongClickListener(stringArray, context, spinner, strArr) { // from class: ru.maximoff.apktool.util.u.34

                    /* renamed from: a */
                    private final String[] f20254a;

                    /* renamed from: b */
                    private final Context f20255b;

                    /* renamed from: c */
                    private final Spinner f20256c;

                    /* renamed from: d */
                    private final String[] f20257d;

                    {
                        this.f20254a = stringArray;
                        this.f20255b = context;
                        this.f20256c = spinner;
                        this.f20257d = strArr;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        int i2;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= this.f20254a.length) {
                                i2 = -1;
                                break;
                            }
                            if (this.f20254a[i3].equals(C3102bd.f18324g)) {
                                i2 = i3;
                                break;
                            }
                            i3++;
                        }
                        new DialogInterfaceC0070b.a(this.f20255b).m418a(R.string.default_key).m430a(this.f20254a, i2, new DialogInterface.OnClickListener(this, this.f20255b, this.f20254a, this.f20256c, this.f20257d) { // from class: ru.maximoff.apktool.util.u.34.1

                            /* renamed from: a */
                            private final AnonymousClass34 f20258a;

                            /* renamed from: b */
                            private final Context f20259b;

                            /* renamed from: c */
                            private final String[] f20260c;

                            /* renamed from: d */
                            private final Spinner f20261d;

                            /* renamed from: e */
                            private final String[] f20262e;

                            {
                                this.f20258a = this;
                                this.f20259b = r2;
                                this.f20260c = r3;
                                this.f20261d = r4;
                                this.f20262e = r5;
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i4) {
                                C3102bd.m18937b(this.f20259b, "default_key", this.f20260c[i4]);
                                C3102bd.f18324g = this.f20260c[i4];
                                try {
                                    C3102bd.m18919a(this.f20259b.getAssets(), this.f20259b.getFilesDir());
                                    String string = this.f20259b.getString(R.string.default_signature_file);
                                    int selectedItemPosition = this.f20261d.getSelectedItemPosition();
                                    int i5 = 0;
                                    while (true) {
                                        if (i5 >= this.f20262e.length) {
                                            i5 = selectedItemPosition;
                                            break;
                                        } else if (!this.f20262e[i5].startsWith(string)) {
                                            i5++;
                                        } else {
                                            this.f20262e[i5] = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(string).append(" (").toString()).append(C3102bd.f18324g).toString()).append(")").toString();
                                            break;
                                        }
                                    }
                                    this.f20261d.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f20259b, C0012R.layout.simple_spinner_dropdown_item, this.f20262e));
                                    this.f20261d.setSelection(i5);
                                } catch (Exception e2) {
                                    C3112bn.m18999a(this.f20259b, R.string.error);
                                }
                                dialogInterface.dismiss();
                            }
                        }).m420a(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
                        return true;
                    }
                });
                ImageView imageView = (ImageView) inflate.findViewById(R.id.zipviewerImageView1);
                if (C3102bd.f18291a) {
                    imageView.setImageResource(R.drawable.ic_settings_light);
                } else {
                    imageView.setImageResource(R.drawable.ic_settings_dark);
                }
                imageView.setOnClickListener(new View.OnClickListener(context) { // from class: ru.maximoff.apktool.util.u.35

                    /* renamed from: a */
                    private final Context f20263a;

                    {
                        this.f20263a = context;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C3080al.m18598f(this.f20263a);
                    }
                });
            } else {
                linearLayout.setVisibility(8);
            }
            ZipViewer zipViewer = (ZipViewer) inflate.findViewById(R.id.zipviewerZipViewer1);
            zipViewer.m19796a(file, list, str, str2);
            zipViewer.setRefreshable(interfaceC2995n);
            DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(context);
            aVar.m427a("...");
            aVar.m435b(inflate);
            aVar.m429a(false);
            aVar.m434b(R.string.close_cur, (DialogInterface.OnClickListener) null);
            aVar.m420a(R.string.extract, (DialogInterface.OnClickListener) null);
            aVar.m440c(R.string.delete, (DialogInterface.OnClickListener) null);
            aVar.m422a(new DialogInterface.OnKeyListener(zipViewer) { // from class: ru.maximoff.apktool.util.u.36

                /* renamed from: a */
                private final ZipViewer f20264a;

                {
                    this.f20264a = zipViewer;
                }

                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                    if (i2 != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                        return false;
                    }
                    boolean m19801d = this.f20264a.m19801d();
                    if (!m19801d) {
                        dialogInterface.cancel();
                        return m19801d;
                    }
                    return m19801d;
                }
            });
            DialogInterfaceC0070b m438b = aVar.m438b();
            m438b.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ru.maximoff.apktool.util.u.37
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    C2919au.m17346e();
                }
            });
            m438b.setOnShowListener(new DialogInterface.OnShowListener(m438b, zipViewer, z, spinner, context, interfaceC2995n, file, str3) { // from class: ru.maximoff.apktool.util.u.38

                /* renamed from: a */
                private final DialogInterfaceC0070b f20265a;

                /* renamed from: b */
                private final ZipViewer f20266b;

                /* renamed from: c */
                private final boolean f20267c;

                /* renamed from: d */
                private final Spinner f20268d;

                /* renamed from: e */
                private final Context f20269e;

                /* renamed from: f */
                private final InterfaceC2995n f20270f;

                /* renamed from: g */
                private final File f20271g;

                /* renamed from: h */
                private final String f20272h;

                {
                    this.f20265a = m438b;
                    this.f20266b = zipViewer;
                    this.f20267c = z;
                    this.f20268d = spinner;
                    this.f20269e = context;
                    this.f20270f = interfaceC2995n;
                    this.f20271g = file;
                    this.f20272h = str3;
                }

                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    Button m414a = this.f20265a.m414a(-1);
                    m414a.setEnabled(false);
                    m414a.setOnClickListener(new View.OnClickListener(this, this.f20266b, this.f20267c, this.f20268d, this.f20269e, this.f20270f, this.f20271g, this.f20265a, this.f20272h) { // from class: ru.maximoff.apktool.util.u.38.1

                        /* renamed from: a */
                        private final AnonymousClass38 f20273a;

                        /* renamed from: b */
                        private final ZipViewer f20274b;

                        /* renamed from: c */
                        private final boolean f20275c;

                        /* renamed from: d */
                        private final Spinner f20276d;

                        /* renamed from: e */
                        private final Context f20277e;

                        /* renamed from: f */
                        private final InterfaceC2995n f20278f;

                        /* renamed from: g */
                        private final File f20279g;

                        /* renamed from: h */
                        private final DialogInterfaceC0070b f20280h;

                        /* renamed from: i */
                        private final String f20281i;

                        {
                            this.f20273a = this;
                            this.f20274b = r2;
                            this.f20275c = r3;
                            this.f20276d = r4;
                            this.f20277e = r5;
                            this.f20278f = r6;
                            this.f20279g = r7;
                            this.f20280h = r8;
                            this.f20281i = r9;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            int i2;
                            if (!this.f20274b.m19799b().isEmpty()) {
                                if (this.f20275c) {
                                    i2 = this.f20276d.getSelectedItemPosition();
                                    C3102bd.m18935b(this.f20277e, "selected_signature", i2);
                                } else {
                                    i2 = 0;
                                }
                                AsyncTaskC2911am asyncTaskC2911am = new AsyncTaskC2911am(this.f20277e, i2, this.f20278f);
                                asyncTaskC2911am.m17240a(this.f20274b.getFakeCrc());
                                asyncTaskC2911am.m17241b(this.f20274b.m19799b());
                                try {
                                    asyncTaskC2911am.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20279g);
                                } catch (Exception e2) {
                                    C3112bn.m18999a(this.f20277e, R.string.error_try_again);
                                }
                                this.f20280h.cancel();
                                return;
                            }
                            File m16639u = MainActivity.m16615o().m16639u();
                            boolean m19664g2 = C3262u.m19664g(this.f20277e, m16639u);
                            List<String> selection = this.f20274b.getSelection();
                            int length = this.f20274b.getPath().length();
                            C0173ao c0173ao = new C0173ao(this.f20277e, view);
                            c0173ao.m1339a().add(0, MediaCodec.CodecException.ERROR_INSUFFICIENT_RESOURCE, 0, this.f20277e.getString(R.string.mextract_zip)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f20277e, this.f20279g, selection, length, this.f20274b) { // from class: ru.maximoff.apktool.util.u.38.1.1

                                /* renamed from: a */
                                private final AnonymousClass1 f20282a;

                                /* renamed from: b */
                                private final Context f20283b;

                                /* renamed from: c */
                                private final File f20284c;

                                /* renamed from: d */
                                private final List f20285d;

                                /* renamed from: e */
                                private final int f20286e;

                                /* renamed from: f */
                                private final ZipViewer f20287f;

                                {
                                    this.f20282a = this;
                                    this.f20283b = r2;
                                    this.f20284c = r3;
                                    this.f20285d = selection;
                                    this.f20286e = length;
                                    this.f20287f = r6;
                                }

                                @Override // android.view.MenuItem.OnMenuItemClickListener
                                public boolean onMenuItemClick(MenuItem menuItem) {
                                    AsyncTaskC2924az asyncTaskC2924az = new AsyncTaskC2924az(this.f20283b, this.f20284c.getParentFile(), this.f20285d, (Runnable) null);
                                    asyncTaskC2924az.m17380g(true);
                                    asyncTaskC2924az.m17379a(this.f20286e);
                                    asyncTaskC2924az.m17382i(true);
                                    try {
                                        asyncTaskC2924az.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20284c);
                                        this.f20287f.m19802e();
                                    } catch (Exception e3) {
                                        C3112bn.m18999a(this.f20283b, R.string.error_try_again);
                                    }
                                    return true;
                                }
                            });
                            c0173ao.m1339a().add(0, MediaCodec.CodecException.ERROR_RECLAIMED, 0, this.f20277e.getString(R.string.mextract_zip_to, this.f20281i)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f20279g, this.f20281i, this.f20277e, selection, length, this.f20274b) { // from class: ru.maximoff.apktool.util.u.38.1.2

                                /* renamed from: a */
                                private final AnonymousClass1 f20288a;

                                /* renamed from: b */
                                private final File f20289b;

                                /* renamed from: c */
                                private final String f20290c;

                                /* renamed from: d */
                                private final Context f20291d;

                                /* renamed from: e */
                                private final List f20292e;

                                /* renamed from: f */
                                private final int f20293f;

                                /* renamed from: g */
                                private final ZipViewer f20294g;

                                {
                                    this.f20288a = this;
                                    this.f20289b = r2;
                                    this.f20290c = r3;
                                    this.f20291d = r4;
                                    this.f20292e = selection;
                                    this.f20293f = length;
                                    this.f20294g = r7;
                                }

                                @Override // android.view.MenuItem.OnMenuItemClickListener
                                public boolean onMenuItemClick(MenuItem menuItem) {
                                    AsyncTaskC2924az asyncTaskC2924az = new AsyncTaskC2924az(this.f20291d, new File(new StringBuffer().append(new StringBuffer().append(this.f20289b.getParent()).append("/").toString()).append(this.f20290c).toString()), this.f20292e, (Runnable) null);
                                    asyncTaskC2924az.m17380g(true);
                                    asyncTaskC2924az.m17381h(true);
                                    asyncTaskC2924az.m17379a(this.f20293f);
                                    asyncTaskC2924az.m17382i(true);
                                    try {
                                        asyncTaskC2924az.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20289b);
                                        this.f20294g.m19802e();
                                    } catch (Exception e3) {
                                        C3112bn.m18999a(this.f20291d, R.string.error_try_again);
                                    }
                                    return true;
                                }
                            });
                            if (m19664g2) {
                                c0173ao.m1339a().add(0, 1102, 0, this.f20277e.getString(R.string.mextract_zip_to2)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f20277e, m16639u, selection, length, this.f20279g, this.f20274b) { // from class: ru.maximoff.apktool.util.u.38.1.3

                                    /* renamed from: a */
                                    private final AnonymousClass1 f20295a;

                                    /* renamed from: b */
                                    private final Context f20296b;

                                    /* renamed from: c */
                                    private final File f20297c;

                                    /* renamed from: d */
                                    private final List f20298d;

                                    /* renamed from: e */
                                    private final int f20299e;

                                    /* renamed from: f */
                                    private final File f20300f;

                                    /* renamed from: g */
                                    private final ZipViewer f20301g;

                                    {
                                        this.f20295a = this;
                                        this.f20296b = r2;
                                        this.f20297c = m16639u;
                                        this.f20298d = selection;
                                        this.f20299e = length;
                                        this.f20300f = r6;
                                        this.f20301g = r7;
                                    }

                                    @Override // android.view.MenuItem.OnMenuItemClickListener
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        AsyncTaskC2924az asyncTaskC2924az = new AsyncTaskC2924az(this.f20296b, this.f20297c, this.f20298d, (Runnable) null);
                                        asyncTaskC2924az.m17380g(true);
                                        asyncTaskC2924az.m17379a(this.f20299e);
                                        asyncTaskC2924az.m17382i(true);
                                        try {
                                            asyncTaskC2924az.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20300f);
                                            this.f20301g.m19802e();
                                        } catch (Exception e3) {
                                            C3112bn.m18999a(this.f20296b, R.string.error_try_again);
                                        }
                                        return true;
                                    }
                                });
                            }
                            c0173ao.m1344c();
                        }
                    });
                    Button m414a2 = this.f20265a.m414a(-3);
                    m414a2.setEnabled(false);
                    m414a2.setOnClickListener(new View.OnClickListener(this, this.f20266b, this.f20267c, this.f20268d, this.f20269e, this.f20270f, this.f20271g) { // from class: ru.maximoff.apktool.util.u.38.2

                        /* renamed from: a */
                        private final AnonymousClass38 f20302a;

                        /* renamed from: b */
                        private final ZipViewer f20303b;

                        /* renamed from: c */
                        private final boolean f20304c;

                        /* renamed from: d */
                        private final Spinner f20305d;

                        /* renamed from: e */
                        private final Context f20306e;

                        /* renamed from: f */
                        private final InterfaceC2995n f20307f;

                        /* renamed from: g */
                        private final File f20308g;

                        {
                            this.f20302a = this;
                            this.f20303b = r2;
                            this.f20304c = r3;
                            this.f20305d = r4;
                            this.f20306e = r5;
                            this.f20307f = r6;
                            this.f20308g = r7;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            int i2 = 0;
                            List<String> selection = this.f20303b.getSelection();
                            if (this.f20304c) {
                                i2 = this.f20305d.getSelectedItemPosition();
                                C3102bd.m18935b(this.f20306e, "selected_signature", i2);
                            }
                            AsyncTaskC2911am asyncTaskC2911am = new AsyncTaskC2911am(this.f20306e, i2, this.f20307f);
                            asyncTaskC2911am.m17239a(this.f20303b);
                            asyncTaskC2911am.m17238a(selection);
                            try {
                                asyncTaskC2911am.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20308g);
                            } catch (Exception e2) {
                                C3112bn.m18999a(this.f20306e, R.string.error_try_again);
                            }
                        }
                    });
                    try {
                        TextView textView = (TextView) this.f20265a.findViewById(R.id.alertTitle);
                        if (textView != null) {
                            textView.setEllipsize(TextUtils.TruncateAt.START);
                            textView.setHorizontallyScrolling(true);
                            textView.setSingleLine(true);
                            textView.setMaxLines(1);
                            this.f20266b.setDialogTitle(textView);
                        }
                    } catch (Exception e2) {
                    }
                    this.f20266b.m19800c();
                }
            });
            zipViewer.setDialog(m438b);
            zipViewer.setAccess(m19664g);
            m438b.show();
        } catch (Exception e2) {
            C3112bn.m19023b(context, context.getString(R.string.failed_open, file.getAbsolutePath()));
        }
    }

    /* renamed from: a */
    public static void m19606a(View view, File file, InterfaceC2995n interfaceC2995n) {
        String lowerCase = file.getName().toLowerCase();
        boolean z = lowerCase.endsWith(".key") && C3079ak.m18515b(file.getAbsolutePath());
        Menu m18715a = C3089au.m18715a(view, R.menu.keystore, new C3089au.a(lowerCase, file, z, interfaceC2995n) { // from class: ru.maximoff.apktool.util.u.39

            /* renamed from: a */
            private final String f20309a;

            /* renamed from: b */
            private final File f20310b;

            /* renamed from: c */
            private final boolean f20311c;

            /* renamed from: d */
            private final InterfaceC2995n f20312d;

            {
                this.f20309a = lowerCase;
                this.f20310b = file;
                this.f20311c = z;
                this.f20312d = interfaceC2995n;
            }

            @Override // ru.maximoff.apktool.util.C3089au.a
            /* renamed from: a */
            public void mo17670a(Context context, int i) {
                int i2;
                switch (i) {
                    case R.id.open_in /* 2131690170 */:
                        C3262u.m19650d(context, this.f20310b);
                        break;
                    case R.id.import_jks /* 2131690288 */:
                    case R.id.convert_jks /* 2131690289 */:
                        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
                        boolean z2 = i == R.id.import_jks;
                        if (z2 && this.f20309a.endsWith(".pk8")) {
                            edit.putBoolean("custom_signature_file", true);
                            edit.putInt("key_type", 3);
                            edit.putString("key_path", this.f20310b.getAbsolutePath());
                            edit.putString("cert_or_alias", new StringBuffer().append(this.f20310b.getAbsolutePath().substring(0, this.f20310b.getAbsolutePath().length() - 3)).append("x509.pem").toString());
                            edit.commit();
                            C3112bn.m18999a(context, R.string.success);
                            break;
                        } else if (this.f20311c) {
                            try {
                                if (C3079ak.m18519d(this.f20310b.getAbsolutePath())) {
                                    C3112bn.m19000a(context, R.string.load_signature_file_fail, this.f20310b.getAbsolutePath());
                                    break;
                                } else {
                                    try {
                                        C3112bn.m19023b(context, context.getString(R.string.successf, C3079ak.m18509a(context, this.f20310b, this.f20310b.getName().substring(0, this.f20310b.getName().length() - 4), (String) null).getAbsolutePath()));
                                    } catch (Exception e2) {
                                        C3112bn.m19023b(context, context.getString(R.string.errorf, e2.getMessage()));
                                    }
                                    this.f20312d.mo17929a();
                                    break;
                                }
                            } catch (Exception e3) {
                                C3112bn.m18999a(context, R.string.error);
                                return;
                            }
                        } else {
                            View inflate = LayoutInflater.from(context).inflate(R.layout.convert_jks, (ViewGroup) null);
                            EditText editText = (EditText) inflate.findViewById(R.id.convertjksEditText1);
                            EditText editText2 = (EditText) inflate.findViewById(R.id.convertjksEditText2);
                            EditText editText3 = (EditText) inflate.findViewById(R.id.convertjksEditText3);
                            ImageView imageView = (ImageView) inflate.findViewById(R.id.convertjksImageView1);
                            ImageView imageView2 = (ImageView) inflate.findViewById(R.id.convertjksImageView2);
                            C3080al.m18559a(imageView, editText);
                            C3080al.m18559a(imageView2, editText3);
                            if (this.f20309a.endsWith(".keystore")) {
                                i2 = 1;
                            } else if (this.f20309a.endsWith(".bks")) {
                                i2 = 2;
                            } else {
                                i2 = 0;
                            }
                            Spinner spinner = (Spinner) inflate.findViewById(R.id.convertjksSpinner1);
                            spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(context, C0012R.layout.simple_spinner_dropdown_item, (String[]) Arrays.copyOf(context.getResources().getStringArray(R.array.format), 3)));
                            spinner.setSelection(i2);
                            DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(context).m418a(z2 ? R.string.import_jks : R.string.convert_jks).m435b(inflate).m420a(R.string.save, new DialogInterface.OnClickListener(this, z2, edit, spinner, this.f20310b, editText2, editText, editText3, context, this.f20312d) { // from class: ru.maximoff.apktool.util.u.39.1

                                /* renamed from: a */
                                private final AnonymousClass39 f20313a;

                                /* renamed from: b */
                                private final boolean f20314b;

                                /* renamed from: c */
                                private final SharedPreferences.Editor f20315c;

                                /* renamed from: d */
                                private final Spinner f20316d;

                                /* renamed from: e */
                                private final File f20317e;

                                /* renamed from: f */
                                private final EditText f20318f;

                                /* renamed from: g */
                                private final EditText f20319g;

                                /* renamed from: h */
                                private final EditText f20320h;

                                /* renamed from: i */
                                private final Context f20321i;

                                /* renamed from: j */
                                private final InterfaceC2995n f20322j;

                                {
                                    this.f20313a = this;
                                    this.f20314b = z2;
                                    this.f20315c = edit;
                                    this.f20316d = spinner;
                                    this.f20317e = r5;
                                    this.f20318f = editText2;
                                    this.f20319g = editText;
                                    this.f20320h = editText3;
                                    this.f20321i = context;
                                    this.f20322j = r10;
                                }

                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i3) {
                                    if (this.f20314b) {
                                        this.f20315c.putBoolean("custom_signature_file", true);
                                        this.f20315c.putInt("key_type", this.f20316d.getSelectedItemPosition());
                                        this.f20315c.putString("key_path", this.f20317e.getAbsolutePath());
                                        this.f20315c.putString("cert_or_alias", this.f20318f.getText().toString());
                                        this.f20315c.putString("store_pass", this.f20319g.getText().toString());
                                        this.f20315c.putString("key_pass", this.f20320h.getText().toString());
                                        this.f20315c.commit();
                                        C3112bn.m18999a(this.f20321i, R.string.success);
                                    } else {
                                        try {
                                            C3112bn.m19023b(this.f20321i, this.f20321i.getString(R.string.successf, C2917as.m17310a(this.f20321i, this.f20317e, this.f20318f.getText().toString(), this.f20319g.getText().toString(), this.f20320h.getText().toString(), this.f20316d.getSelectedItemPosition()).getAbsolutePath()));
                                        } catch (Exception e4) {
                                            C3112bn.m19023b(this.f20321i, this.f20321i.getString(R.string.errorf, e4.getMessage()));
                                        }
                                    }
                                    this.f20322j.mo17929a();
                                }
                            }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
                            m438b.getWindow().setSoftInputMode(4);
                            m438b.setOnShowListener(new DialogInterface.OnShowListener(this, editText, m438b, editText2, editText3) { // from class: ru.maximoff.apktool.util.u.39.2

                                /* renamed from: a */
                                private final AnonymousClass39 f20323a;

                                /* renamed from: b */
                                private final EditText f20324b;

                                /* renamed from: c */
                                private final DialogInterfaceC0070b f20325c;

                                /* renamed from: d */
                                private final EditText f20326d;

                                /* renamed from: e */
                                private final EditText f20327e;

                                {
                                    this.f20323a = this;
                                    this.f20324b = editText;
                                    this.f20325c = m438b;
                                    this.f20326d = editText2;
                                    this.f20327e = editText3;
                                }

                                @Override // android.content.DialogInterface.OnShowListener
                                public void onShow(DialogInterface dialogInterface) {
                                    this.f20324b.requestFocus();
                                    Button m414a = this.f20325c.m414a(-1);
                                    m414a.setEnabled(false);
                                    TextWatcher textWatcher = new TextWatcher(this, m414a, this.f20324b, this.f20326d, this.f20327e) { // from class: ru.maximoff.apktool.util.u.39.2.1

                                        /* renamed from: a */
                                        private final AnonymousClass2 f20328a;

                                        /* renamed from: b */
                                        private final Button f20329b;

                                        /* renamed from: c */
                                        private final EditText f20330c;

                                        /* renamed from: d */
                                        private final EditText f20331d;

                                        /* renamed from: e */
                                        private final EditText f20332e;

                                        {
                                            this.f20328a = this;
                                            this.f20329b = m414a;
                                            this.f20330c = r3;
                                            this.f20331d = r4;
                                            this.f20332e = r5;
                                        }

                                        @Override // android.text.TextWatcher
                                        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                                        }

                                        @Override // android.text.TextWatcher
                                        public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                                        }

                                        @Override // android.text.TextWatcher
                                        public void afterTextChanged(Editable editable) {
                                            this.f20329b.setEnabled(this.f20330c.getText().length() > 0 && this.f20331d.getText().length() > 0 && this.f20332e.getText().length() > 0);
                                        }
                                    };
                                    this.f20324b.addTextChangedListener(textWatcher);
                                    this.f20326d.addTextChangedListener(textWatcher);
                                    this.f20327e.addTextChangedListener(textWatcher);
                                }
                            });
                            m438b.show();
                            break;
                        }
                        break;
                }
            }
        });
        m18715a.findItem(R.id.convert_jks).setVisible(!file.getName().toLowerCase().endsWith(".pk8"));
        m18715a.findItem(R.id.import_jks).setVisible(z ? false : true);
    }

    /* renamed from: a */
    public static void m19609a(File file, View view, InterfaceC2995n interfaceC2995n, List<String> list, List<String> list2, int i) {
        Context context = view.getContext();
        String m18910a = C3102bd.m18910a(context, "install_opt", "0");
        Menu m18715a = C3089au.m18715a(view, R.menu.apk, new C3089au.a(file, interfaceC2995n, list, list2, i, m18910a) { // from class: ru.maximoff.apktool.util.u.40

            /* renamed from: a */
            private final File f20335a;

            /* renamed from: b */
            private final InterfaceC2995n f20336b;

            /* renamed from: c */
            private final List f20337c;

            /* renamed from: d */
            private final List f20338d;

            /* renamed from: e */
            private final int f20339e;

            /* renamed from: f */
            private final String f20340f;

            {
                this.f20335a = file;
                this.f20336b = interfaceC2995n;
                this.f20337c = list;
                this.f20338d = list2;
                this.f20339e = i;
                this.f20340f = m18910a;
            }

            @Override // ru.maximoff.apktool.util.C3089au.a
            /* renamed from: a */
            public void mo17670a(Context context2, int i2) {
                int i3;
                int i4 = 1;
                switch (i2) {
                    case R.id.install /* 2131690150 */:
                        if (Build.VERSION.SDK_INT >= 21 && !this.f20340f.equals("0")) {
                            try {
                                i4 = Integer.parseInt(this.f20340f);
                            } catch (Exception e2) {
                            }
                            switch (i4) {
                                case 1:
                                    i3 = 3;
                                    break;
                                case 2:
                                    i3 = 4;
                                    break;
                            }
                            C3262u.m19578a(context2, this.f20335a, i3, this.f20336b, (List<String>) this.f20337c, (List<String>) this.f20338d, this.f20339e);
                            break;
                        }
                        i3 = 3;
                        C3262u.m19578a(context2, this.f20335a, i3, this.f20336b, (List<String>) this.f20337c, (List<String>) this.f20338d, this.f20339e);
                        break;
                    case R.id.install_session /* 2131690151 */:
                        C3262u.m19578a(context2, this.f20335a, 4, this.f20336b, (List<String>) this.f20337c, (List<String>) this.f20338d, this.f20339e);
                        break;
                    case R.id.app_details /* 2131690153 */:
                        C3262u.m19578a(context2, this.f20335a, 5, this.f20336b, (List<String>) this.f20337c, (List<String>) this.f20338d, this.f20339e);
                        break;
                    case R.id.quick_edit /* 2131690154 */:
                        C3262u.m19578a(context2, this.f20335a, 7, this.f20336b, (List<String>) this.f20337c, (List<String>) this.f20338d, this.f20339e);
                        break;
                    case R.id.decompile /* 2131690155 */:
                        C3262u.m19578a(context2, this.f20335a, 0, this.f20336b, (List<String>) this.f20337c, (List<String>) this.f20338d, this.f20339e);
                        break;
                    case R.id.sign /* 2131690156 */:
                        C3262u.m19578a(context2, this.f20335a, 1, this.f20336b, (List<String>) this.f20337c, (List<String>) this.f20338d, this.f20339e);
                        break;
                    case R.id.verify /* 2131690157 */:
                        C3262u.m19578a(context2, this.f20335a, 2, this.f20336b, (List<String>) this.f20337c, (List<String>) this.f20338d, this.f20339e);
                        break;
                    case R.id.sign_kill /* 2131690158 */:
                        C3262u.m19578a(context2, this.f20335a, 14, this.f20336b, (List<String>) this.f20337c, (List<String>) this.f20338d, this.f20339e);
                        break;
                    case R.id.embed_dp /* 2131690159 */:
                        C3262u.m19578a(context2, this.f20335a, 18, this.f20336b, (List<String>) this.f20337c, (List<String>) this.f20338d, this.f20339e);
                        break;
                    case R.id.encrypt /* 2131690160 */:
                        C3262u.m19578a(context2, this.f20335a, 12, this.f20336b, (List<String>) this.f20337c, (List<String>) this.f20338d, this.f20339e);
                        break;
                    case R.id.edit_axml /* 2131690161 */:
                        C3262u.m19578a(context2, this.f20335a, 15, this.f20336b, (List<String>) this.f20337c, (List<String>) this.f20338d, this.f20339e);
                        break;
                    case R.id.optimize /* 2131690162 */:
                        C3262u.m19578a(context2, this.f20335a, 8, this.f20336b, (List<String>) this.f20337c, (List<String>) this.f20338d, this.f20339e);
                        break;
                    case R.id.optimize2 /* 2131690163 */:
                        C3262u.m19578a(context2, this.f20335a, 13, this.f20336b, (List<String>) this.f20337c, (List<String>) this.f20338d, this.f20339e);
                        break;
                    case R.id.redistribute /* 2131690164 */:
                        C3262u.m19578a(context2, this.f20335a, 17, this.f20336b, (List<String>) this.f20337c, (List<String>) this.f20338d, this.f20339e);
                        break;
                    case R.id.zipalign /* 2131690165 */:
                        C3262u.m19578a(context2, this.f20335a, 9, this.f20336b, (List<String>) this.f20337c, (List<String>) this.f20338d, this.f20339e);
                        break;
                    case R.id.split_arch /* 2131690166 */:
                        C3262u.m19578a(context2, this.f20335a, 11, this.f20336b, (List<String>) this.f20337c, (List<String>) this.f20338d, this.f20339e);
                        break;
                    case R.id.soeditor /* 2131690167 */:
                        C3262u.m19578a(context2, this.f20335a, 16, this.f20336b, (List<String>) this.f20337c, (List<String>) this.f20338d, this.f20339e);
                        break;
                    case R.id.ultrazip /* 2131690168 */:
                        C3262u.m19578a(context2, this.f20335a, 10, this.f20336b, (List<String>) this.f20337c, (List<String>) this.f20338d, this.f20339e);
                        break;
                    case R.id.import_framework /* 2131690169 */:
                        C3262u.m19578a(context2, this.f20335a, 6, this.f20336b, (List<String>) this.f20337c, (List<String>) this.f20338d, this.f20339e);
                        break;
                }
            }
        });
        m18715a.findItem(R.id.install_session).setVisible(Build.VERSION.SDK_INT >= 21 && m18910a.equals("0"));
        m18715a.findItem(R.id.split_arch).setVisible(list != null && list.size() > 1);
        m18715a.findItem(R.id.soeditor).setVisible(list != null && list.size() > 0);
        if (m19664g(context, file)) {
            m18715a.findItem(R.id.edit_axml).setVisible(true);
            m18715a.findItem(R.id.edit_axml).setTitle(new StringBuffer().append(context.getString(R.string.strings_edit)).append(" (AndroidManifest.xml)").toString());
        } else {
            m18715a.findItem(R.id.edit_axml).setVisible(false);
        }
    }

    /* renamed from: a */
    public static void m19578a(Context context, File file, int i, InterfaceC2995n interfaceC2995n, List<String> list, List<String> list2, int i2) {
        int[] iArr = {1, 2, 0};
        MainActivity m16615o = MainActivity.m16615o();
        switch (i) {
            case 0:
                C3080al.m18556a(context, interfaceC2995n, new File[]{file}, file.getName(), (String) null);
                return;
            case 1:
                iArr[1] = 2;
                Runnable runnable = new Runnable(context, iArr, interfaceC2995n, file) { // from class: ru.maximoff.apktool.util.u.41

                    /* renamed from: a */
                    private final Context f20341a;

                    /* renamed from: b */
                    private final int[] f20342b;

                    /* renamed from: c */
                    private final InterfaceC2995n f20343c;

                    /* renamed from: d */
                    private final File f20344d;

                    {
                        this.f20341a = context;
                        this.f20342b = iArr;
                        this.f20343c = interfaceC2995n;
                        this.f20344d = file;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        C2917as.m17314a(this.f20341a, this.f20342b[0], new C2917as.a(this, this.f20341a, this.f20343c, this.f20344d) { // from class: ru.maximoff.apktool.util.u.41.1

                            /* renamed from: a */
                            private final AnonymousClass41 f20345a;

                            /* renamed from: b */
                            private final Context f20346b;

                            /* renamed from: c */
                            private final InterfaceC2995n f20347c;

                            /* renamed from: d */
                            private final File f20348d;

                            {
                                this.f20345a = this;
                                this.f20346b = r2;
                                this.f20347c = r3;
                                this.f20348d = r4;
                            }

                            @Override // ru.maximoff.apktool.p300e.C2917as.a
                            /* renamed from: a */
                            public void mo16440a(C2917as c2917as, boolean z) {
                                try {
                                    new AsyncTaskC2916ar(this.f20346b, this.f20347c, c2917as).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20348d);
                                } catch (Exception e2) {
                                    C3112bn.m18999a(this.f20346b, R.string.error_try_again);
                                }
                            }
                        });
                    }
                };
                if (C3102bd.m18925a(context, "custom_signature_file", false)) {
                    m19599a(context, iArr, runnable, (Runnable) null);
                    return;
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(runnable, 100L);
                    return;
                }
            case 2:
                AsyncTaskC2928bc asyncTaskC2928bc = new AsyncTaskC2928bc(context);
                asyncTaskC2928bc.m17060b(file);
                try {
                    asyncTaskC2928bc.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, file);
                    return;
                } catch (Exception e2) {
                    C3112bn.m18999a(context, R.string.error_try_again);
                    return;
                }
            case 3:
                m19590a(context, file, false);
                return;
            case 4:
                m19590a(context, file, true);
                return;
            case 5:
                C3080al.m18551a(context, file, (PackageInfo) null, (PackageManager) null);
                return;
            case 6:
                try {
                    new AsyncTaskC2955z(context, interfaceC2995n).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, file);
                    return;
                } catch (Exception e3) {
                    C3112bn.m18999a(context, R.string.error_try_again);
                    return;
                }
            case 7:
                m19589a(context, file, interfaceC2995n, false);
                return;
            case 8:
                iArr[1] = 3;
                m19602a(context, iArr, new Runnable(context, interfaceC2995n, iArr, file) { // from class: ru.maximoff.apktool.util.u.42

                    /* renamed from: a */
                    private final Context f20349a;

                    /* renamed from: b */
                    private final InterfaceC2995n f20350b;

                    /* renamed from: c */
                    private final int[] f20351c;

                    /* renamed from: d */
                    private final File f20352d;

                    {
                        this.f20349a = context;
                        this.f20350b = interfaceC2995n;
                        this.f20351c = iArr;
                        this.f20352d = file;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            new AsyncTaskC2902ad(this.f20349a, this.f20350b, this.f20351c[0]).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20352d);
                        } catch (Exception e4) {
                            C3112bn.m18999a(this.f20349a, R.string.error_try_again);
                        }
                    }
                }, (Runnable) null, false, 1, false, R.string.moptimize);
                return;
            case 9:
                iArr[1] = 3;
                m19601a(context, iArr, new Runnable(context, interfaceC2995n, iArr, file) { // from class: ru.maximoff.apktool.util.u.43

                    /* renamed from: a */
                    private final Context f20353a;

                    /* renamed from: b */
                    private final InterfaceC2995n f20354b;

                    /* renamed from: c */
                    private final int[] f20355c;

                    /* renamed from: d */
                    private final File f20356d;

                    {
                        this.f20353a = context;
                        this.f20354b = interfaceC2995n;
                        this.f20355c = iArr;
                        this.f20356d = file;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            new AsyncTaskC2929bd(this.f20353a, this.f20354b, this.f20355c[0]).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20356d);
                        } catch (Exception e4) {
                            C3112bn.m18999a(this.f20353a, R.string.error_try_again);
                        }
                    }
                }, (Runnable) null, false, R.string.mzipalign);
                return;
            case 10:
                iArr[1] = 3;
                iArr[2] = C3102bd.m18925a(context, "change_api_ultra", true) ? 0 : 1;
                m19602a(context, iArr, new Runnable(iArr, context, interfaceC2995n, file) { // from class: ru.maximoff.apktool.util.u.44

                    /* renamed from: a */
                    private final int[] f20357a;

                    /* renamed from: b */
                    private final Context f20358b;

                    /* renamed from: c */
                    private final InterfaceC2995n f20359c;

                    /* renamed from: d */
                    private final File f20360d;

                    {
                        this.f20357a = iArr;
                        this.f20358b = context;
                        this.f20359c = interfaceC2995n;
                        this.f20360d = file;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z = this.f20357a[2] == 0;
                        C3102bd.m18938b(this.f20358b, "change_api_ultra", z);
                        try {
                            new AsyncTaskC2922ax(this.f20358b, this.f20359c, this.f20357a[0], z).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20360d);
                        } catch (Exception e4) {
                            C3112bn.m18999a(this.f20358b, R.string.error_try_again);
                        }
                    }
                }, (Runnable) null, false, 0, true, R.string.ultra_zip);
                return;
            case 11:
                if (list == null || list.isEmpty()) {
                    C3112bn.m18999a(context, R.string.sets_nf);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                try {
                    C2466a c2466a = new C2466a(C3102bd.m18910a(context, "exclude_arch", "[]"));
                    for (int i3 = 0; i3 < c2466a.m15569a(); i3++) {
                        arrayList.add(c2466a.m15579f(i3));
                    }
                } catch (Exception e4) {
                    arrayList.clear();
                }
                String[] strArr = new String[list.size() + 1];
                strArr[0] = context.getString(R.string.libs_one_apk);
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 < list.size()) {
                        strArr[i5 + 1] = list.get(i5);
                        i4 = i5 + 1;
                    } else {
                        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(context);
                        aVar.m432a(strArr, (boolean[]) null, (DialogInterface.OnMultiChoiceClickListener) null);
                        aVar.m418a(R.string.split_arch);
                        aVar.m434b(R.string.cancel, (DialogInterface.OnClickListener) null);
                        aVar.m420a(R.string.f21470ok, new DialogInterface.OnClickListener(iArr, context, interfaceC2995n, file) { // from class: ru.maximoff.apktool.util.u.45

                            /* renamed from: a */
                            private final int[] f20361a;

                            /* renamed from: b */
                            private final Context f20362b;

                            /* renamed from: c */
                            private final InterfaceC2995n f20363c;

                            /* renamed from: d */
                            private final File f20364d;

                            {
                                this.f20361a = iArr;
                                this.f20362b = context;
                                this.f20363c = interfaceC2995n;
                                this.f20364d = file;
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i6) {
                                ArrayList arrayList2 = new ArrayList();
                                ListView m415a = ((DialogInterfaceC0070b) dialogInterface).m415a();
                                for (int i7 = 1; i7 < m415a.getCount(); i7++) {
                                    if (m415a.isItemChecked(i7)) {
                                        arrayList2.add((String) m415a.getItemAtPosition(i7));
                                    }
                                }
                                if (arrayList2.isEmpty()) {
                                    dialogInterface.dismiss();
                                    return;
                                }
                                boolean isItemChecked = m415a.isItemChecked(0);
                                this.f20361a[1] = 3;
                                C3262u.m19600a(this.f20362b, this.f20361a, new Runnable(this, this.f20362b, this.f20363c, arrayList2, this.f20361a, isItemChecked, this.f20364d) { // from class: ru.maximoff.apktool.util.u.45.1

                                    /* renamed from: a */
                                    private final AnonymousClass45 f20365a;

                                    /* renamed from: b */
                                    private final Context f20366b;

                                    /* renamed from: c */
                                    private final InterfaceC2995n f20367c;

                                    /* renamed from: d */
                                    private final List f20368d;

                                    /* renamed from: e */
                                    private final int[] f20369e;

                                    /* renamed from: f */
                                    private final boolean f20370f;

                                    /* renamed from: g */
                                    private final File f20371g;

                                    {
                                        this.f20365a = this;
                                        this.f20366b = r2;
                                        this.f20367c = r3;
                                        this.f20368d = arrayList2;
                                        this.f20369e = r5;
                                        this.f20370f = isItemChecked;
                                        this.f20371g = r7;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            AsyncTaskC2920av asyncTaskC2920av = new AsyncTaskC2920av(this.f20366b, this.f20367c, this.f20368d, this.f20369e[0]);
                                            asyncTaskC2920av.m17353g(this.f20370f);
                                            asyncTaskC2920av.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20371g);
                                        } catch (Exception e5) {
                                            C3112bn.m18999a(this.f20366b, R.string.error_try_again);
                                        }
                                    }
                                }, (Runnable) null, R.string.split_arch);
                                dialogInterface.dismiss();
                            }
                        });
                        aVar.m440c(R.string.mselect_inv, (DialogInterface.OnClickListener) null);
                        DialogInterfaceC0070b m438b = aVar.m438b();
                        m438b.setOnShowListener(new DialogInterface.OnShowListener(m438b, context, arrayList) { // from class: ru.maximoff.apktool.util.u.46

                            /* renamed from: a */
                            private final DialogInterfaceC0070b f20372a;

                            /* renamed from: b */
                            private final Context f20373b;

                            /* renamed from: c */
                            private final List f20374c;

                            {
                                this.f20372a = m438b;
                                this.f20373b = context;
                                this.f20374c = arrayList;
                            }

                            @Override // android.content.DialogInterface.OnShowListener
                            public void onShow(DialogInterface dialogInterface) {
                                Button m414a = this.f20372a.m414a(-1);
                                ListView m415a = this.f20372a.m415a();
                                m415a.setItemChecked(0, C3102bd.m18925a(this.f20373b, "libs_in_one", false));
                                boolean z = false;
                                for (int i6 = 1; i6 < m415a.getCount(); i6++) {
                                    boolean z2 = !this.f20374c.contains((String) m415a.getItemAtPosition(i6));
                                    m415a.setItemChecked(i6, z2);
                                    if (z2) {
                                        z = true;
                                    }
                                }
                                m414a.setEnabled(z);
                                m415a.setOnItemClickListener(new AdapterView.OnItemClickListener(this, this.f20373b, m415a, this.f20374c, m414a) { // from class: ru.maximoff.apktool.util.u.46.1

                                    /* renamed from: a */
                                    private final AnonymousClass46 f20375a;

                                    /* renamed from: b */
                                    private final Context f20376b;

                                    /* renamed from: c */
                                    private final ListView f20377c;

                                    /* renamed from: d */
                                    private final List f20378d;

                                    /* renamed from: e */
                                    private final Button f20379e;

                                    {
                                        this.f20375a = this;
                                        this.f20376b = r2;
                                        this.f20377c = m415a;
                                        this.f20378d = r4;
                                        this.f20379e = m414a;
                                    }

                                    @Override // android.widget.AdapterView.OnItemClickListener
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i7, long j) {
                                        C3102bd.m18938b(this.f20376b, "libs_in_one", this.f20377c.isItemChecked(0));
                                        boolean z3 = false;
                                        for (int i8 = 1; i8 < this.f20377c.getCount(); i8++) {
                                            String str = (String) this.f20377c.getItemAtPosition(i8);
                                            if (this.f20377c.isItemChecked(i8)) {
                                                this.f20378d.remove(str);
                                                z3 = true;
                                            } else if (!this.f20378d.contains(str)) {
                                                this.f20378d.add(str);
                                            }
                                        }
                                        this.f20379e.setEnabled(z3);
                                        C3102bd.m18937b(this.f20376b, "exclude_arch", new C2466a((Collection<?>) this.f20378d).toString());
                                    }
                                });
                                Button m414a2 = this.f20372a.m414a(-3);
                                m414a2.setOnClickListener(new View.OnClickListener(this, m415a, this.f20374c, m414a, this.f20373b) { // from class: ru.maximoff.apktool.util.u.46.2

                                    /* renamed from: a */
                                    private final AnonymousClass46 f20380a;

                                    /* renamed from: b */
                                    private final ListView f20381b;

                                    /* renamed from: c */
                                    private final List f20382c;

                                    /* renamed from: d */
                                    private final Button f20383d;

                                    /* renamed from: e */
                                    private final Context f20384e;

                                    {
                                        this.f20380a = this;
                                        this.f20381b = m415a;
                                        this.f20382c = r3;
                                        this.f20383d = m414a;
                                        this.f20384e = r5;
                                    }

                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        boolean z3 = false;
                                        for (int i7 = 1; i7 < this.f20381b.getCount(); i7++) {
                                            String str = (String) this.f20381b.getItemAtPosition(i7);
                                            boolean isItemChecked = this.f20381b.isItemChecked(i7);
                                            this.f20381b.setItemChecked(i7, !isItemChecked);
                                            if (!isItemChecked) {
                                                this.f20382c.remove(str);
                                                z3 = true;
                                            } else if (!this.f20382c.contains(str)) {
                                                this.f20382c.add(str);
                                            }
                                        }
                                        this.f20383d.setEnabled(z3);
                                        C3102bd.m18937b(this.f20384e, "exclude_arch", new C2466a((Collection<?>) this.f20382c).toString());
                                    }
                                });
                                m414a2.setOnLongClickListener(new View.OnLongClickListener(this, m415a, this.f20374c, this.f20373b, m414a) { // from class: ru.maximoff.apktool.util.u.46.3

                                    /* renamed from: a */
                                    private final AnonymousClass46 f20385a;

                                    /* renamed from: b */
                                    private final ListView f20386b;

                                    /* renamed from: c */
                                    private final List f20387c;

                                    /* renamed from: d */
                                    private final Context f20388d;

                                    /* renamed from: e */
                                    private final Button f20389e;

                                    {
                                        this.f20385a = this;
                                        this.f20386b = m415a;
                                        this.f20387c = r3;
                                        this.f20388d = r4;
                                        this.f20389e = m414a;
                                    }

                                    @Override // android.view.View.OnLongClickListener
                                    public boolean onLongClick(View view) {
                                        for (int i7 = 1; i7 < this.f20386b.getCount(); i7++) {
                                            this.f20387c.remove((String) this.f20386b.getItemAtPosition(i7));
                                            this.f20386b.setItemChecked(i7, true);
                                        }
                                        C3102bd.m18937b(this.f20388d, "exclude_arch", new C2466a((Collection<?>) this.f20387c).toString());
                                        this.f20389e.setEnabled(true);
                                        return true;
                                    }
                                });
                            }
                        });
                        m438b.show();
                        return;
                    }
                }
                break;
            case 12:
                iArr[1] = 3;
                m19602a(context, iArr, new Runnable(context, iArr, file) { // from class: ru.maximoff.apktool.util.u.47

                    /* renamed from: a */
                    private final Context f20390a;

                    /* renamed from: b */
                    private final int[] f20391b;

                    /* renamed from: c */
                    private final File f20392c;

                    {
                        this.f20390a = context;
                        this.f20391b = iArr;
                        this.f20392c = file;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            new AsyncTaskC2948s(this.f20390a, false, this.f20391b[0]).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20392c);
                        } catch (Exception e5) {
                            C3112bn.m18999a(this.f20390a, R.string.error_try_again);
                        }
                    }
                }, (Runnable) null, false, 3, false, R.string.enc_res);
                return;
            case 13:
                iArr[1] = 3;
                m19602a(context, iArr, new Runnable(context, iArr, file) { // from class: ru.maximoff.apktool.util.u.48

                    /* renamed from: a */
                    private final Context f20393a;

                    /* renamed from: b */
                    private final int[] f20394b;

                    /* renamed from: c */
                    private final File f20395c;

                    {
                        this.f20393a = context;
                        this.f20394b = iArr;
                        this.f20395c = file;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            new AsyncTaskC2948s(this.f20393a, true, this.f20394b[0]).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20395c);
                        } catch (Exception e5) {
                            C3112bn.m18999a(this.f20393a, R.string.error_try_again);
                        }
                    }
                }, (Runnable) null, false, 2, false, R.string.moptimize2);
                return;
            case 14:
                C3074af.m18463a(context, interfaceC2995n, file);
                return;
            case 15:
                try {
                    Intent intent = new Intent(m16615o, Class.forName("ru.maximoff.apktool.AxmlEdit"));
                    intent.putExtra("apk_path", file.getAbsolutePath());
                    intent.putExtra("data", AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME);
                    m16615o.startActivityForResult(intent, 0);
                    return;
                } catch (ClassNotFoundException e5) {
                    throw new NoClassDefFoundError(e5.getMessage());
                }
            case 16:
                if (list == null || list.isEmpty()) {
                    C3112bn.m18999a(context, R.string.sets_nf);
                    return;
                }
                String[] strArr2 = new String[list2.size()];
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    if (i7 < list2.size()) {
                        String[] split = list2.get(i7).split(";", 2);
                        strArr2[i7] = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(split[1]).append(" (").toString()).append(C3106bh.m18975a(Long.parseLong(split[0]), C3102bd.f18305am)).toString()).append(")").toString();
                        i6 = i7 + 1;
                    } else {
                        new DialogInterfaceC0070b.a(context).m418a(R.string.soeditor).m431a(strArr2, new DialogInterface.OnClickListener(list2, m16615o, file) { // from class: ru.maximoff.apktool.util.u.49

                            /* renamed from: a */
                            private final List f20396a;

                            /* renamed from: b */
                            private final MainActivity f20397b;

                            /* renamed from: c */
                            private final File f20398c;

                            {
                                this.f20396a = list2;
                                this.f20397b = m16615o;
                                this.f20398c = file;
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i8) {
                                dialogInterface.cancel();
                                String[] split2 = ((String) this.f20396a.get(i8)).split(";", 2);
                                try {
                                    Intent intent2 = new Intent(this.f20397b, Class.forName("ru.maximoff.apktool.SoEditor"));
                                    intent2.putExtra("data", new StringBuffer().append("lib/").append(split2[1]).toString());
                                    intent2.putExtra("apk_path", this.f20398c.getAbsolutePath());
                                    this.f20397b.startActivityForResult(intent2, 0);
                                } catch (ClassNotFoundException e6) {
                                    throw new NoClassDefFoundError(e6.getMessage());
                                }
                            }
                        }).m420a(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
                        return;
                    }
                }
                break;
            case 17:
                if (i2 == 0) {
                    C3112bn.m19000a(context, R.string.errorf, "no dex files found in apk");
                    return;
                }
                String[] strArr3 = {C3102bd.m18910a(context, "dex_split_mc2", "64000"), String.valueOf(Math.max(i2, 2))};
                View inflate = LayoutInflater.from(context).inflate(R.layout.split_dex, (ViewGroup) null);
                ((LinearLayout) inflate.findViewById(R.id.splitdexLinearLayout1)).setVisibility(0);
                String[] stringArray = context.getResources().getStringArray(R.array.keys);
                Spinner spinner = (Spinner) inflate.findViewById(R.id.splitdexSpinner2);
                int m18905a = C3102bd.m18905a(context, "selected_signature", 1);
                boolean m18925a = C3102bd.m18925a(context, "custom_signature_file", false);
                String[] strArr4 = new String[m18925a ? 3 : 2];
                strArr4[0] = context.getString(R.string.not_sign);
                strArr4[1] = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(context.getString(R.string.default_signature_file)).append(" (").toString()).append(C3102bd.f18324g).toString()).append(")").toString();
                if (m18925a) {
                    strArr4[2] = context.getString(R.string.custom_signature_file);
                } else if (m18905a > 1) {
                    m18905a = 1;
                }
                C3102bd.f18317ay = (boolean[]) null;
                spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(context, C0012R.layout.simple_spinner_dropdown_item, strArr4));
                spinner.setSelection(m18905a);
                spinner.setOnLongClickListener(new View.OnLongClickListener(stringArray, context, spinner, strArr4) { // from class: ru.maximoff.apktool.util.u.50

                    /* renamed from: a */
                    private final String[] f20404a;

                    /* renamed from: b */
                    private final Context f20405b;

                    /* renamed from: c */
                    private final Spinner f20406c;

                    /* renamed from: d */
                    private final String[] f20407d;

                    {
                        this.f20404a = stringArray;
                        this.f20405b = context;
                        this.f20406c = spinner;
                        this.f20407d = strArr4;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        int i8;
                        int i9 = 0;
                        while (true) {
                            if (i9 >= this.f20404a.length) {
                                i8 = -1;
                                break;
                            }
                            if (this.f20404a[i9].equals(C3102bd.f18324g)) {
                                i8 = i9;
                                break;
                            }
                            i9++;
                        }
                        new DialogInterfaceC0070b.a(this.f20405b).m418a(R.string.default_key).m430a(this.f20404a, i8, new DialogInterface.OnClickListener(this, this.f20405b, this.f20404a, this.f20406c, this.f20407d) { // from class: ru.maximoff.apktool.util.u.50.1

                            /* renamed from: a */
                            private final AnonymousClass50 f20408a;

                            /* renamed from: b */
                            private final Context f20409b;

                            /* renamed from: c */
                            private final String[] f20410c;

                            /* renamed from: d */
                            private final Spinner f20411d;

                            /* renamed from: e */
                            private final String[] f20412e;

                            {
                                this.f20408a = this;
                                this.f20409b = r2;
                                this.f20410c = r3;
                                this.f20411d = r4;
                                this.f20412e = r5;
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i10) {
                                C3102bd.m18937b(this.f20409b, "default_key", this.f20410c[i10]);
                                C3102bd.f18324g = this.f20410c[i10];
                                try {
                                    C3102bd.m18919a(this.f20409b.getAssets(), this.f20409b.getFilesDir());
                                    String string = this.f20409b.getString(R.string.default_signature_file);
                                    int selectedItemPosition = this.f20411d.getSelectedItemPosition();
                                    int i11 = 0;
                                    while (true) {
                                        if (i11 >= this.f20412e.length) {
                                            i11 = selectedItemPosition;
                                            break;
                                        } else if (!this.f20412e[i11].startsWith(string)) {
                                            i11++;
                                        } else {
                                            this.f20412e[i11] = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(string).append(" (").toString()).append(C3102bd.f18324g).toString()).append(")").toString();
                                            break;
                                        }
                                    }
                                    this.f20411d.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f20409b, C0012R.layout.simple_spinner_dropdown_item, this.f20412e));
                                    this.f20411d.setSelection(i11);
                                } catch (Exception e6) {
                                    C3112bn.m18999a(this.f20409b, R.string.error);
                                }
                                dialogInterface.dismiss();
                            }
                        }).m420a(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
                        return true;
                    }
                });
                Button[] buttonArr = new Button[1];
                EditText editText = (EditText) inflate.findViewById(R.id.splitdexEditText1);
                editText.setText(strArr3[0]);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.splitdexImageView1);
                ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.splitdexImageButton1);
                if (C3102bd.f18291a) {
                    imageView.setImageResource(R.drawable.ic_settings_light);
                    imageButton.setImageResource(R.drawable.ic_top);
                } else {
                    imageView.setImageResource(R.drawable.ic_settings_dark);
                    imageButton.setImageResource(R.drawable.ic_top_dark);
                }
                imageButton.setOnClickListener(new View.OnClickListener(editText) { // from class: ru.maximoff.apktool.util.u.51

                    /* renamed from: a */
                    private final EditText f20413a;

                    {
                        this.f20413a = editText;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        this.f20413a.setText(String.valueOf(65536));
                        this.f20413a.setSelection(this.f20413a.getText().length());
                        this.f20413a.requestFocus();
                    }
                });
                imageButton.setOnLongClickListener(new View.OnLongClickListener(editText, strArr3) { // from class: ru.maximoff.apktool.util.u.52

                    /* renamed from: a */
                    private final EditText f20414a;

                    /* renamed from: b */
                    private final String[] f20415b;

                    {
                        this.f20414a = editText;
                        this.f20415b = strArr3;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        this.f20414a.setText(this.f20415b[0]);
                        this.f20414a.setSelection(this.f20414a.getText().length());
                        this.f20414a.requestFocus();
                        return true;
                    }
                });
                imageView.setOnClickListener(new View.OnClickListener(context) { // from class: ru.maximoff.apktool.util.u.53

                    /* renamed from: a */
                    private final Context f20416a;

                    {
                        this.f20416a = context;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C3080al.m18598f(this.f20416a);
                    }
                });
                TextView textView = (TextView) inflate.findViewById(R.id.splitdexTextView1);
                textView.setText(R.string.split_dex_cnm);
                Spinner spinner2 = (Spinner) inflate.findViewById(R.id.splitdexSpinner1);
                spinner2.setAdapter((SpinnerAdapter) new ArrayAdapter(context, C0012R.layout.simple_spinner_dropdown_item, context.getResources().getStringArray(R.array.split_dex_items)));
                spinner2.setSelection(0);
                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(buttonArr, editText, strArr3, imageButton, textView) { // from class: ru.maximoff.apktool.util.u.54

                    /* renamed from: a */
                    private final Button[] f20417a;

                    /* renamed from: b */
                    private final EditText f20418b;

                    /* renamed from: c */
                    private final String[] f20419c;

                    /* renamed from: d */
                    private final ImageButton f20420d;

                    /* renamed from: e */
                    private final TextView f20421e;

                    {
                        this.f20417a = buttonArr;
                        this.f20418b = editText;
                        this.f20419c = strArr3;
                        this.f20420d = imageButton;
                        this.f20421e = textView;
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i8, long j) {
                        if (this.f20417a[0] != null) {
                            this.f20417a[0].setEnabled(true);
                        }
                        this.f20418b.setText(this.f20419c[i8]);
                        if (i8 == 0) {
                            this.f20420d.setVisibility(0);
                            this.f20421e.setText(R.string.split_dex_cnm);
                        } else {
                            this.f20420d.setVisibility(8);
                            this.f20421e.setText(R.string.split_dex_cnd);
                        }
                        this.f20418b.setSelection(this.f20418b.getText().length());
                        this.f20418b.requestFocus();
                    }
                });
                editText.addTextChangedListener(new TextWatcher(buttonArr, spinner2) { // from class: ru.maximoff.apktool.util.u.55

                    /* renamed from: a */
                    private final Button[] f20422a;

                    /* renamed from: b */
                    private final Spinner f20423b;

                    {
                        this.f20422a = buttonArr;
                        this.f20423b = spinner2;
                    }

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        if (this.f20422a[0] != null && this.f20423b.getSelectedItemPosition() == 0) {
                            try {
                                this.f20422a[0].setEnabled(Integer.parseInt(editable.toString()) <= 65536);
                            } catch (Exception e6) {
                                this.f20422a[0].setEnabled(false);
                            }
                        }
                    }
                });
                ((CheckBox) inflate.findViewById(R.id.splitdexCheckBox1)).setVisibility(8);
                ((TextView) inflate.findViewById(R.id.splitdexTextView2)).setText(context.getString(R.string.dex_limit_info, new Integer(65536)));
                DialogInterfaceC0070b m438b2 = new DialogInterfaceC0070b.a(context).m418a(R.string.redistribute_dex).m435b(inflate).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(context, interfaceC2995n, editText, spinner2, spinner, file) { // from class: ru.maximoff.apktool.util.u.56

                    /* renamed from: a */
                    private final Context f20424a;

                    /* renamed from: b */
                    private final InterfaceC2995n f20425b;

                    /* renamed from: c */
                    private final EditText f20426c;

                    /* renamed from: d */
                    private final Spinner f20427d;

                    /* renamed from: e */
                    private final Spinner f20428e;

                    /* renamed from: f */
                    private final File f20429f;

                    {
                        this.f20424a = context;
                        this.f20425b = interfaceC2995n;
                        this.f20426c = editText;
                        this.f20427d = spinner2;
                        this.f20428e = spinner;
                        this.f20429f = file;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i8) {
                        AsyncTaskC2945p asyncTaskC2945p = new AsyncTaskC2945p(this.f20424a, this.f20425b, false);
                        try {
                            int parseInt = Integer.parseInt(this.f20426c.getText().toString());
                            if (this.f20427d.getSelectedItemPosition() == 0) {
                                asyncTaskC2945p.m17536c(parseInt);
                                C3102bd.m18937b(this.f20424a, "dex_split_mc2", String.valueOf(parseInt));
                            } else {
                                asyncTaskC2945p.m17535b(parseInt);
                            }
                            int selectedItemPosition = this.f20428e.getSelectedItemPosition();
                            C3102bd.m18935b(this.f20424a, "selected_signature", selectedItemPosition);
                            asyncTaskC2945p.m17533a(selectedItemPosition);
                            asyncTaskC2945p.m17537g(false);
                            asyncTaskC2945p.m17538h(true);
                            asyncTaskC2945p.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20429f);
                        } catch (Exception e6) {
                            C3112bn.m18999a(this.f20424a, R.string.error_try_again);
                        }
                    }
                }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
                m438b2.getWindow().setSoftInputMode(4);
                m438b2.setOnShowListener(new DialogInterface.OnShowListener(buttonArr, m438b2, editText) { // from class: ru.maximoff.apktool.util.u.57

                    /* renamed from: a */
                    private final Button[] f20430a;

                    /* renamed from: b */
                    private final DialogInterfaceC0070b f20431b;

                    /* renamed from: c */
                    private final EditText f20432c;

                    {
                        this.f20430a = buttonArr;
                        this.f20431b = m438b2;
                        this.f20432c = editText;
                    }

                    @Override // android.content.DialogInterface.OnShowListener
                    public void onShow(DialogInterface dialogInterface) {
                        this.f20430a[0] = this.f20431b.m414a(-1);
                        this.f20432c.setSelection(this.f20432c.getText().length());
                        this.f20432c.requestFocus();
                    }
                });
                m438b2.show();
                return;
            case 18:
                iArr[1] = 3;
                m19603a(context, iArr, new Runnable(context, interfaceC2995n, file, iArr) { // from class: ru.maximoff.apktool.util.u.58

                    /* renamed from: a */
                    private final Context f20433a;

                    /* renamed from: b */
                    private final InterfaceC2995n f20434b;

                    /* renamed from: c */
                    private final File f20435c;

                    /* renamed from: d */
                    private final int[] f20436d;

                    {
                        this.f20433a = context;
                        this.f20434b = interfaceC2995n;
                        this.f20435c = file;
                        this.f20436d = iArr;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AsyncTaskC2947r asyncTaskC2947r = new AsyncTaskC2947r(this.f20433a, this.f20434b, new C3081am(this.f20435c));
                            asyncTaskC2947r.m17566g(this.f20436d[2] == 1);
                            asyncTaskC2947r.m17565a(this.f20436d[0]);
                            asyncTaskC2947r.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20435c);
                        } catch (Exception e6) {
                            C3112bn.m18999a(this.f20433a, R.string.error_try_again);
                        }
                    }
                }, (Runnable) null, false, 0, false, true, R.string.embed_dp);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m19651d(Context context, File file, InterfaceC2995n interfaceC2995n) {
        C3261t c3261t = new C3261t(context);
        Runnable runnable = new Runnable(c3261t, context, interfaceC2995n, file) { // from class: ru.maximoff.apktool.util.u.59

            /* renamed from: a */
            private final C3261t f20437a;

            /* renamed from: b */
            private final Context f20438b;

            /* renamed from: c */
            private final InterfaceC2995n f20439c;

            /* renamed from: d */
            private final File f20440d;

            {
                this.f20437a = c3261t;
                this.f20438b = context;
                this.f20439c = interfaceC2995n;
                this.f20440d = file;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    new AsyncTaskC2938i(this.f20438b, new File(this.f20437a.getPath()), this.f20439c).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20440d);
                } catch (Exception e2) {
                    C3112bn.m18999a(this.f20438b, R.string.error_try_again);
                }
            }
        };
        c3261t.m19545a("_fsign");
        c3261t.setCallback(runnable);
        c3261t.setFilter(new String[]{"apk", "apks", "apkm", "xapk", "zip"});
        c3261t.m19546a(true);
        c3261t.m19550e();
        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(context);
        aVar.m427a(c3261t.m19548c());
        aVar.m435b(c3261t);
        aVar.m420a(R.string.cancel, (DialogInterface.OnClickListener) null);
        aVar.m437b("/...", (DialogInterface.OnClickListener) null);
        aVar.m429a(false);
        aVar.m422a(new DialogInterface.OnKeyListener(c3261t) { // from class: ru.maximoff.apktool.util.u.60

            /* renamed from: a */
            private final C3261t f20444a;

            {
                this.f20444a = c3261t;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                    return false;
                }
                boolean m19551f = this.f20444a.m19551f();
                if (!m19551f) {
                    dialogInterface.dismiss();
                    return m19551f;
                }
                return m19551f;
            }
        });
        DialogInterfaceC0070b m438b = aVar.m438b();
        m438b.setOnShowListener(new DialogInterface.OnShowListener(m438b, context, c3261t) { // from class: ru.maximoff.apktool.util.u.61

            /* renamed from: a */
            private final DialogInterfaceC0070b f20445a;

            /* renamed from: b */
            private final Context f20446b;

            /* renamed from: c */
            private final C3261t f20447c;

            {
                this.f20445a = m438b;
                this.f20446b = context;
                this.f20447c = c3261t;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                Button m414a = this.f20445a.m414a(-3);
                m414a.setOnClickListener(new View.OnClickListener(this, this.f20446b, this.f20447c) { // from class: ru.maximoff.apktool.util.u.61.1

                    /* renamed from: a */
                    private final AnonymousClass61 f20448a;

                    /* renamed from: b */
                    private final Context f20449b;

                    /* renamed from: c */
                    private final C3261t f20450c;

                    {
                        this.f20448a = this;
                        this.f20449b = r2;
                        this.f20450c = r3;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        int i;
                        String[] m19640b = C3262u.m19640b(this.f20449b);
                        if (m19640b != null) {
                            C0173ao c0173ao = new C0173ao(this.f20449b, view);
                            if (C3102bd.m18910a(this.f20449b, "menu_position", "1").equals("0")) {
                                i = 3;
                            } else {
                                i = 5;
                            }
                            c0173ao.m1340a(i);
                            for (int i2 = 0; i2 < m19640b.length; i2++) {
                                c0173ao.m1339a().add(0, i2 + MediaCodec.CodecException.ERROR_INSUFFICIENT_RESOURCE, 0, m19640b[i2]).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f20450c) { // from class: ru.maximoff.apktool.util.u.61.1.1

                                    /* renamed from: a */
                                    private final AnonymousClass1 f20451a;

                                    /* renamed from: b */
                                    private final C3261t f20452b;

                                    {
                                        this.f20451a = this;
                                        this.f20452b = r2;
                                    }

                                    @Override // android.view.MenuItem.OnMenuItemClickListener
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        this.f20452b.m19544a(new File(menuItem.getTitle().toString()));
                                        return true;
                                    }
                                });
                            }
                            c0173ao.m1344c();
                        }
                    }
                });
                m414a.setOnLongClickListener(new View.OnLongClickListener(this, this.f20447c, this.f20446b) { // from class: ru.maximoff.apktool.util.u.61.2

                    /* renamed from: a */
                    private final AnonymousClass61 f20453a;

                    /* renamed from: b */
                    private final C3261t f20454b;

                    /* renamed from: c */
                    private final Context f20455c;

                    {
                        this.f20453a = this;
                        this.f20454b = r2;
                        this.f20455c = r3;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        int i;
                        List<String> m19205b = this.f20454b.m19549d().m19205b();
                        if (m19205b.isEmpty()) {
                            return false;
                        }
                        C0173ao c0173ao = new C0173ao(this.f20455c, view);
                        if (C3102bd.m18910a(this.f20455c, "menu_position", "1").equals("0")) {
                            i = 3;
                        } else {
                            i = 5;
                        }
                        c0173ao.m1340a(i);
                        Iterator<String> it = m19205b.iterator();
                        while (it.hasNext()) {
                            c0173ao.m1339a().add(0, 1300, 0, it.next()).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f20454b) { // from class: ru.maximoff.apktool.util.u.61.2.1

                                /* renamed from: a */
                                private final AnonymousClass2 f20456a;

                                /* renamed from: b */
                                private final C3261t f20457b;

                                {
                                    this.f20456a = this;
                                    this.f20457b = r2;
                                }

                                @Override // android.view.MenuItem.OnMenuItemClickListener
                                public boolean onMenuItemClick(MenuItem menuItem) {
                                    this.f20457b.m19544a(new File(menuItem.getTitle().toString()));
                                    return true;
                                }
                            });
                        }
                        c0173ao.m1344c();
                        return true;
                    }
                });
            }
        });
        c3261t.setDialog(m438b);
        m438b.show();
    }

    /* renamed from: a */
    public static void m19599a(Context context, int[] iArr, Runnable runnable, Runnable runnable2) {
        m19602a(context, iArr, runnable, runnable2, false, 0, false, R.string.signature_file);
    }

    /* renamed from: a */
    public static void m19600a(Context context, int[] iArr, Runnable runnable, Runnable runnable2, int i) {
        m19602a(context, iArr, runnable, runnable2, false, 0, false, i);
    }

    /* renamed from: a */
    public static void m19601a(Context context, int[] iArr, Runnable runnable, Runnable runnable2, boolean z, int i) {
        m19602a(context, iArr, runnable, runnable2, z, 0, false, i);
    }

    /* renamed from: a */
    public static void m19602a(Context context, int[] iArr, Runnable runnable, Runnable runnable2, boolean z, int i, boolean z2, int i2) {
        m19603a(context, iArr, runnable, runnable2, z, i, z2, false, i2);
    }

    /* renamed from: a */
    public static void m19603a(Context context, int[] iArr, Runnable runnable, Runnable runnable2, boolean z, int i, boolean z2, boolean z3, int i2) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.sign, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.signLinearLayout1);
        String string = context.getString(R.string.use_aapt2);
        RadioButton radioButton = (RadioButton) inflate.findViewById(R.id.signRadioButton1);
        RadioButton radioButton2 = (RadioButton) inflate.findViewById(R.id.signRadioButton2);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.signCheckBox1);
        radioButton.setText(string.replace("aapt2", "aapt"));
        radioButton2.setText(string);
        radioButton2.setChecked(C3102bd.f18279O);
        if (z) {
            linearLayout.setVisibility(0);
        } else {
            linearLayout.setVisibility(8);
        }
        if (z2 && iArr.length == 3) {
            checkBox.setVisibility(0);
            checkBox.setChecked(iArr[2] == 1);
            checkBox.setOnClickListener(new View.OnClickListener(checkBox, iArr) { // from class: ru.maximoff.apktool.util.u.62

                /* renamed from: a */
                private final CheckBox f20458a;

                /* renamed from: b */
                private final int[] f20459b;

                {
                    this.f20458a = checkBox;
                    this.f20459b = iArr;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (this.f20458a.isChecked()) {
                        this.f20459b[2] = 1;
                    } else {
                        this.f20459b[2] = 0;
                    }
                }
            });
        } else if (z3) {
            checkBox.setVisibility(0);
            checkBox.setText(R.string.kill_sign_rand);
            checkBox.setOnClickListener(new View.OnClickListener(checkBox, iArr) { // from class: ru.maximoff.apktool.util.u.63

                /* renamed from: a */
                private final CheckBox f20460a;

                /* renamed from: b */
                private final int[] f20461b;

                {
                    this.f20460a = checkBox;
                    this.f20461b = iArr;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (this.f20460a.isChecked()) {
                        this.f20461b[2] = 1;
                    } else {
                        this.f20461b[2] = 0;
                    }
                }
            });
        } else {
            checkBox.setVisibility(8);
        }
        boolean m18946d = C3102bd.m18946d();
        Spinner spinner = (Spinner) inflate.findViewById(R.id.signSpinner0);
        spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(context, C0012R.layout.simple_spinner_dropdown_item, context.getResources().getStringArray(R.array.store_type)));
        spinner.setSelection((C3102bd.f18316ax && m18946d) ? 1 : 0);
        spinner.setEnabled(m18946d);
        spinner.setOnLongClickListener(new View.OnLongClickListener(context, spinner) { // from class: ru.maximoff.apktool.util.u.64

            /* renamed from: a */
            private final Context f20462a;

            /* renamed from: b */
            private final Spinner f20463b;

            {
                this.f20462a = context;
                this.f20463b = spinner;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                C3080al.m18550a(this.f20462a, this.f20463b, 0);
                return true;
            }
        });
        C3102bd.f18317ay = (boolean[]) null;
        String[] stringArray = context.getResources().getStringArray(R.array.keys);
        Spinner spinner2 = (Spinner) inflate.findViewById(R.id.signSpinner1);
        boolean m18925a = C3102bd.m18925a(context, "custom_signature_file", false);
        int i3 = z ? 1 : 0;
        int m18905a = C3102bd.m18905a(context, "selected_signature", 1);
        String[] strArr = new String[((iArr[1] == 3 && m18925a) ? 3 : 2) + i3];
        if (z) {
            strArr[0] = context.getString(R.string.copyOriginalFiles);
        }
        if (iArr[1] == 2) {
            int i4 = m18905a > 0 ? m18905a - 1 : m18905a;
            strArr[i3 + 0] = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(context.getString(R.string.default_signature_file)).append(" (").toString()).append(C3102bd.f18324g).toString()).append(")").toString();
            strArr[i3 + 1] = context.getString(R.string.custom_signature_file);
            m18905a = i4;
        } else {
            strArr[i3 + 0] = context.getString(R.string.not_sign);
            strArr[i3 + 1] = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(context.getString(R.string.default_signature_file)).append(" (").toString()).append(C3102bd.f18324g).toString()).append(")").toString();
            if (m18925a) {
                strArr[i3 + 2] = context.getString(R.string.custom_signature_file);
            } else if (m18905a > 1) {
                m18905a = 1;
            }
        }
        spinner2.setAdapter((SpinnerAdapter) new ArrayAdapter(context, C0012R.layout.simple_spinner_dropdown_item, strArr));
        if (z && C3102bd.m18925a(context, "copyOriginalFiles", false)) {
            spinner2.setSelection(0);
        } else {
            spinner2.setSelection(i3 + m18905a);
        }
        spinner2.setOnLongClickListener(new View.OnLongClickListener(stringArray, context, spinner2, strArr) { // from class: ru.maximoff.apktool.util.u.65

            /* renamed from: a */
            private final String[] f20464a;

            /* renamed from: b */
            private final Context f20465b;

            /* renamed from: c */
            private final Spinner f20466c;

            /* renamed from: d */
            private final String[] f20467d;

            {
                this.f20464a = stringArray;
                this.f20465b = context;
                this.f20466c = spinner2;
                this.f20467d = strArr;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                int i5;
                int i6 = 0;
                while (true) {
                    if (i6 >= this.f20464a.length) {
                        i5 = -1;
                        break;
                    }
                    if (this.f20464a[i6].equals(C3102bd.f18324g)) {
                        i5 = i6;
                        break;
                    }
                    i6++;
                }
                new DialogInterfaceC0070b.a(this.f20465b).m418a(R.string.default_key).m430a(this.f20464a, i5, new DialogInterface.OnClickListener(this, this.f20465b, this.f20464a, this.f20466c, this.f20467d) { // from class: ru.maximoff.apktool.util.u.65.1

                    /* renamed from: a */
                    private final AnonymousClass65 f20468a;

                    /* renamed from: b */
                    private final Context f20469b;

                    /* renamed from: c */
                    private final String[] f20470c;

                    /* renamed from: d */
                    private final Spinner f20471d;

                    /* renamed from: e */
                    private final String[] f20472e;

                    {
                        this.f20468a = this;
                        this.f20469b = r2;
                        this.f20470c = r3;
                        this.f20471d = r4;
                        this.f20472e = r5;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i7) {
                        C3102bd.m18937b(this.f20469b, "default_key", this.f20470c[i7]);
                        C3102bd.f18324g = this.f20470c[i7];
                        try {
                            C3102bd.m18919a(this.f20469b.getAssets(), this.f20469b.getFilesDir());
                            String string2 = this.f20469b.getString(R.string.default_signature_file);
                            int selectedItemPosition = this.f20471d.getSelectedItemPosition();
                            int i8 = 0;
                            while (true) {
                                if (i8 >= this.f20472e.length) {
                                    i8 = selectedItemPosition;
                                    break;
                                } else if (!this.f20472e[i8].startsWith(string2)) {
                                    i8++;
                                } else {
                                    this.f20472e[i8] = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(string2).append(" (").toString()).append(C3102bd.f18324g).toString()).append(")").toString();
                                    break;
                                }
                            }
                            this.f20471d.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f20469b, C0012R.layout.simple_spinner_dropdown_item, this.f20472e));
                            this.f20471d.setSelection(i8);
                        } catch (Exception e2) {
                            C3112bn.m18999a(this.f20469b, R.string.error);
                        }
                        dialogInterface.dismiss();
                    }
                }).m420a(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
                return true;
            }
        });
        ImageView imageView = (ImageView) inflate.findViewById(R.id.signImageView1);
        if (C3102bd.f18291a) {
            imageView.setImageResource(R.drawable.ic_settings_light);
        } else {
            imageView.setImageResource(R.drawable.ic_settings_dark);
        }
        imageView.setOnClickListener(new View.OnClickListener(context) { // from class: ru.maximoff.apktool.util.u.66

            /* renamed from: a */
            private final Context f20473a;

            {
                this.f20473a = context;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C3080al.m18598f(this.f20473a);
            }
        });
        DialogInterfaceC0070b.a m420a = new DialogInterfaceC0070b.a(context).m435b(inflate).m418a(i2).m429a(true).m434b(R.string.cancel, new DialogInterface.OnClickListener(runnable2) { // from class: ru.maximoff.apktool.util.u.67

            /* renamed from: a */
            private final Runnable f20474a;

            {
                this.f20474a = runnable2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i5) {
                if (this.f20474a != null) {
                    new Handler(Looper.getMainLooper()).postDelayed(this.f20474a, 100L);
                }
            }
        }).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(iArr, spinner2, z, context, radioButton2, spinner, m18946d, runnable) { // from class: ru.maximoff.apktool.util.u.68

            /* renamed from: a */
            private final int[] f20475a;

            /* renamed from: b */
            private final Spinner f20476b;

            /* renamed from: c */
            private final boolean f20477c;

            /* renamed from: d */
            private final Context f20478d;

            /* renamed from: e */
            private final RadioButton f20479e;

            /* renamed from: f */
            private final Spinner f20480f;

            /* renamed from: g */
            private final boolean f20481g;

            /* renamed from: h */
            private final Runnable f20482h;

            {
                this.f20475a = iArr;
                this.f20476b = spinner2;
                this.f20477c = z;
                this.f20478d = context;
                this.f20479e = radioButton2;
                this.f20480f = spinner;
                this.f20481g = m18946d;
                this.f20482h = runnable;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i5) {
                boolean z4;
                this.f20475a[0] = (this.f20476b.getSelectedItemPosition() + 3) - this.f20475a[1];
                if (this.f20477c) {
                    if (this.f20475a[0] > 0) {
                        this.f20475a[0] = r0[0] - 1;
                        C3102bd.m18935b(this.f20478d, "selected_signature", this.f20475a[0]);
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    boolean isChecked = this.f20479e.isChecked();
                    C0518d c0518d = C0518d.f3579w;
                    c0518d.f3585f = z4;
                    if (isChecked) {
                        c0518d.f3600u = C3102bd.f18278N;
                        c0518d.f3601v = 2;
                    } else {
                        c0518d.f3600u = C3102bd.f18321d;
                        c0518d.f3601v = 1;
                    }
                    if (this.f20480f.getSelectedItemPosition() == 0 || !this.f20481g) {
                        C3102bd.m18938b(this.f20478d, "user_frameworks", false);
                        C3102bd.f18316ax = false;
                        c0518d.f3598s = C3102bd.f18322e;
                    } else {
                        C3102bd.m18938b(this.f20478d, "user_frameworks", true);
                        C3102bd.f18316ax = true;
                        c0518d.f3598s = C3102bd.f18323f;
                    }
                    C3102bd.m18938b(this.f20478d, "use_aapt2", isChecked);
                    C3102bd.m18938b(this.f20478d, "copyOriginalFiles", z4);
                    C3102bd.f18279O = isChecked;
                } else {
                    C3102bd.m18935b(this.f20478d, "selected_signature", this.f20475a[0]);
                }
                if (this.f20482h != null) {
                    new Handler(Looper.getMainLooper()).postDelayed(this.f20482h, 100L);
                }
            }
        });
        if (i > 0 || z) {
            m420a.m440c(R.string.settings, (DialogInterface.OnClickListener) null);
        } else if (z3) {
            m420a.m440c(R.string.minfo, (DialogInterface.OnClickListener) null);
        }
        DialogInterfaceC0070b m438b = m420a.m438b();
        m438b.setOnShowListener(new DialogInterface.OnShowListener(i, z, z3, m438b, context, i2) { // from class: ru.maximoff.apktool.util.u.69

            /* renamed from: a */
            private final int f20483a;

            /* renamed from: b */
            private final boolean f20484b;

            /* renamed from: c */
            private final boolean f20485c;

            /* renamed from: d */
            private final DialogInterfaceC0070b f20486d;

            /* renamed from: e */
            private final Context f20487e;

            /* renamed from: f */
            private final int f20488f;

            {
                this.f20483a = i;
                this.f20484b = z;
                this.f20485c = z3;
                this.f20486d = m438b;
                this.f20487e = context;
                this.f20488f = i2;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (this.f20483a != 0 || this.f20484b || this.f20485c) {
                    this.f20486d.m414a(-3).setOnClickListener(new View.OnClickListener(this, this.f20484b, this.f20487e, this.f20485c, this.f20483a, this.f20488f) { // from class: ru.maximoff.apktool.util.u.69.1

                        /* renamed from: a */
                        private final AnonymousClass69 f20489a;

                        /* renamed from: b */
                        private final boolean f20490b;

                        /* renamed from: c */
                        private final Context f20491c;

                        /* renamed from: d */
                        private final boolean f20492d;

                        /* renamed from: e */
                        private final int f20493e;

                        /* renamed from: f */
                        private final int f20494f;

                        {
                            this.f20489a = this;
                            this.f20490b = r2;
                            this.f20491c = r3;
                            this.f20492d = r4;
                            this.f20493e = r5;
                            this.f20494f = r6;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (this.f20490b) {
                                C3080al.m18587c(this.f20491c, 2);
                            }
                            if (this.f20492d) {
                                new C3078aj(this.f20491c).m18494a(R.string.embed_dp).m18500b(R.string.embed_dp_info).m18506d(R.string.f21470ok).m18507d();
                                return;
                            }
                            switch (this.f20493e) {
                                case 1:
                                    C3262u.m19625b(this.f20491c, this.f20494f);
                                    break;
                                case 2:
                                    C3262u.m19629b(this.f20491c, "", this.f20494f);
                                    break;
                                case 3:
                                    C3262u.m19629b(this.f20491c, "enc_", this.f20494f);
                                    break;
                            }
                        }
                    });
                }
            }
        });
        m438b.setOnCancelListener(new DialogInterface.OnCancelListener(runnable2) { // from class: ru.maximoff.apktool.util.u.70

            /* renamed from: a */
            private final Runnable f20498a;

            {
                this.f20498a = runnable2;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (this.f20498a != null) {
                    new Handler(Looper.getMainLooper()).postDelayed(this.f20498a, 100L);
                }
            }
        });
        m438b.show();
        if (i == 3 && C3102bd.m18925a(context, "encript_notice_dialog", true)) {
            new DialogInterfaceC0070b.a(context).m418a(R.string.attention).m433b(R.string.encript_notice).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m440c(R.string.not_remind, new DialogInterface.OnClickListener(context) { // from class: ru.maximoff.apktool.util.u.71

                /* renamed from: a */
                private final Context f20499a;

                {
                    this.f20499a = context;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i5) {
                    C3102bd.m18938b(this.f20499a, "encript_notice_dialog", false);
                    dialogInterface.dismiss();
                }
            }).m438b().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m19625b(Context context, int i) {
        C2466a c2466a;
        String[] strArr = {context.getString(R.string.dont_change), "true", "false"};
        View inflate = LayoutInflater.from(context).inflate(R.layout.optimization, (ViewGroup) null);
        EditText editText = (EditText) inflate.findViewById(R.id.optimizationEditText1);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.optimizationCheckBox1);
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.optimizationCheckBox2);
        Spinner spinner = (Spinner) inflate.findViewById(R.id.optimizationSpinner1);
        spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(context, C0012R.layout.simple_spinner_dropdown_item, strArr));
        checkBox.setChecked(C3102bd.m18925a(context, "optimization_over", false));
        checkBox2.setChecked(C3102bd.m18925a(context, "optimization_za", true));
        spinner.setSelection(C3102bd.m18905a(context, "optimization_senl", 0));
        String m18910a = C3102bd.m18910a(context, "optimization_rules", (String) null);
        try {
            if (m18910a == null) {
                c2466a = new C2466a(C3249i.f19548h);
            } else {
                c2466a = new C2466a(m18910a);
            }
            String str = "";
            int i2 = 0;
            while (i2 < c2466a.m15569a()) {
                if (i2 > 0) {
                    str = new StringBuffer().append(str).append("\n").toString();
                }
                String stringBuffer = new StringBuffer().append(str).append(c2466a.m15571a(i2)).toString();
                i2++;
                str = stringBuffer;
            }
            editText.setText(str);
        } catch (Exception e2) {
            editText.setText("");
        }
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(context).m418a(i).m435b(inflate).m420a(R.string.save, new DialogInterface.OnClickListener(editText, context, checkBox, checkBox2, spinner) { // from class: ru.maximoff.apktool.util.u.72

            /* renamed from: a */
            private final EditText f20500a;

            /* renamed from: b */
            private final Context f20501b;

            /* renamed from: c */
            private final CheckBox f20502c;

            /* renamed from: d */
            private final CheckBox f20503d;

            /* renamed from: e */
            private final Spinner f20504e;

            {
                this.f20500a = editText;
                this.f20501b = context;
                this.f20502c = checkBox;
                this.f20503d = checkBox2;
                this.f20504e = spinner;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                try {
                    String editable = this.f20500a.getText().toString();
                    C2466a c2466a2 = new C2466a();
                    String[] split = editable.split("\n");
                    for (String str2 : split) {
                        c2466a2.m15574a(str2);
                    }
                    C3102bd.m18937b(this.f20501b, "optimization_rules", c2466a2.toString());
                    C3102bd.m18938b(this.f20501b, "optimization_over", this.f20502c.isChecked());
                    C3102bd.m18938b(this.f20501b, "optimization_za", this.f20503d.isChecked());
                    C3102bd.m18935b(this.f20501b, "optimization_senl", this.f20504e.getSelectedItemPosition());
                    C3112bn.m18999a(this.f20501b, R.string.success);
                } catch (Exception e3) {
                    C3112bn.m18999a(this.f20501b, R.string.error);
                }
                dialogInterface.cancel();
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.search_reset, new DialogInterface.OnClickListener(context) { // from class: ru.maximoff.apktool.util.u.73

            /* renamed from: a */
            private final Context f20505a;

            {
                this.f20505a = context;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                C3102bd.m18924a(this.f20505a, "optimization_rules");
                C3102bd.m18924a(this.f20505a, "optimization_over");
                C3102bd.m18924a(this.f20505a, "optimization_za");
                C3102bd.m18924a(this.f20505a, "optimization_senl");
                dialogInterface.cancel();
            }
        }).m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(editText) { // from class: ru.maximoff.apktool.util.u.74

            /* renamed from: a */
            private final EditText f20506a;

            {
                this.f20506a = editText;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f20506a.requestFocus();
                this.f20506a.setSelection(this.f20506a.getText().length());
            }
        });
        m438b.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m19629b(Context context, String str, int i) {
        int i2;
        View inflate = LayoutInflater.from(context).inflate(R.layout.aapt2_options, (ViewGroup) null);
        String[] strArr = new String[38];
        strArr[0] = context.getString(R.string.dont_change);
        for (int i3 = 1; i3 <= 37; i3++) {
            strArr[i3] = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(i3).append(" (").toString()).append(C3080al.m18532a(i3, true)).toString()).append(")").toString();
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, C0012R.layout.simple_spinner_dropdown_item, strArr);
        Spinner spinner = (Spinner) inflate.findViewById(R.id.aapt2optionsSpinner1);
        Spinner spinner2 = (Spinner) inflate.findViewById(R.id.aapt2optionsSpinner2);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner2.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner.setSelection(C3102bd.m18905a(context, new StringBuffer().append(str).append("aapt2_minSdk").toString(), 0));
        spinner2.setSelection(C3102bd.m18905a(context, new StringBuffer().append(str).append("aapt2_targetSdk").toString(), 0));
        EditText editText = (EditText) inflate.findViewById(R.id.aapt2optionsEditText1);
        EditText editText2 = (EditText) inflate.findViewById(R.id.aapt2optionsEditText2);
        EditText editText3 = (EditText) inflate.findViewById(R.id.aapt2optionsEditText3);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.aapt2optionsCheckBox1);
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.aapt2optionsCheckBox2);
        CheckBox checkBox3 = (CheckBox) inflate.findViewById(R.id.aapt2optionsCheckBox3);
        TextView textView = (TextView) inflate.findViewById(R.id.aapt2optionsTextView1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.aapt2optionsTextView2);
        TextView textView3 = (TextView) inflate.findViewById(R.id.aapt2optionsTextView3);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.aapt2optionsImageView1);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.aapt2optionsImageView2);
        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.aapt2optionsImageView3);
        C3212b c3212b = new C3212b(context, "aapt2_densities");
        C3212b c3212b2 = new C3212b(context, "aapt2_configurations");
        C3212b c3212b3 = new C3212b(context, "aapt2_libs");
        String m18600g = C3080al.m18600g(context);
        String lowerCase = C3080al.m18602h(context).toLowerCase();
        if (C3102bd.f18291a) {
            i2 = R.drawable.ic_collapse;
        } else {
            i2 = R.drawable.ic_collapse_dark;
        }
        imageView.setImageResource(i2);
        imageView2.setImageResource(i2);
        imageView3.setImageResource(i2);
        editText.setText(C3102bd.m18910a(context, new StringBuffer().append(str).append("aapt2_target_densities").toString(), lowerCase));
        editText.setHint(lowerCase);
        editText2.setText(C3102bd.m18910a(context, new StringBuffer().append(str).append("aapt2_configurations_include").toString(), m18600g));
        editText2.setHint(m18600g);
        editText3.setText(C3102bd.m18910a(context, new StringBuffer().append(str).append("aapt2_libs_include").toString(), C3102bd.f18268D));
        editText3.setHint(C3102bd.f18268D);
        C3112bn.m19008a(textView);
        C3112bn.m19008a(textView2);
        C3112bn.m19008a(textView3);
        boolean m18925a = C3102bd.m18925a(context, new StringBuffer().append(str).append("aapt2_densities_enable").toString(), false);
        boolean m18925a2 = C3102bd.m18925a(context, new StringBuffer().append(str).append("aapt2_configurations_enable").toString(), false);
        boolean m18925a3 = C3102bd.m18925a(context, new StringBuffer().append(str).append("aapt2_libs_enable").toString(), false);
        checkBox.setChecked(m18925a);
        editText.setEnabled(m18925a);
        textView.setEnabled(m18925a);
        imageView.setEnabled(m18925a);
        checkBox2.setChecked(m18925a2);
        editText2.setEnabled(m18925a2);
        textView2.setEnabled(m18925a2);
        imageView2.setEnabled(m18925a2);
        checkBox3.setChecked(m18925a3);
        editText3.setEnabled(m18925a3);
        textView3.setEnabled(m18925a3);
        imageView3.setEnabled(m18925a3);
        View.OnClickListener onClickListener = new View.OnClickListener(editText, textView, imageView, editText2, textView2, imageView2, editText3, textView3, imageView3) { // from class: ru.maximoff.apktool.util.u.75

            /* renamed from: a */
            private final EditText f20507a;

            /* renamed from: b */
            private final TextView f20508b;

            /* renamed from: c */
            private final ImageView f20509c;

            /* renamed from: d */
            private final EditText f20510d;

            /* renamed from: e */
            private final TextView f20511e;

            /* renamed from: f */
            private final ImageView f20512f;

            /* renamed from: g */
            private final EditText f20513g;

            /* renamed from: h */
            private final TextView f20514h;

            /* renamed from: i */
            private final ImageView f20515i;

            {
                this.f20507a = editText;
                this.f20508b = textView;
                this.f20509c = imageView;
                this.f20510d = editText2;
                this.f20511e = textView2;
                this.f20512f = imageView2;
                this.f20513g = editText3;
                this.f20514h = textView3;
                this.f20515i = imageView3;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean isChecked = ((CheckBox) view).isChecked();
                switch (view.getId()) {
                    case R.id.aapt2optionsCheckBox1 /* 2131689581 */:
                        this.f20507a.setEnabled(isChecked);
                        this.f20508b.setEnabled(isChecked);
                        this.f20509c.setEnabled(isChecked);
                        break;
                    case R.id.aapt2optionsCheckBox2 /* 2131689585 */:
                        this.f20510d.setEnabled(isChecked);
                        this.f20511e.setEnabled(isChecked);
                        this.f20512f.setEnabled(isChecked);
                        break;
                    case R.id.aapt2optionsCheckBox3 /* 2131689589 */:
                        this.f20513g.setEnabled(isChecked);
                        this.f20514h.setEnabled(isChecked);
                        this.f20515i.setEnabled(isChecked);
                        break;
                }
            }
        };
        checkBox.setOnClickListener(onClickListener);
        checkBox2.setOnClickListener(onClickListener);
        checkBox3.setOnClickListener(onClickListener);
        if (c3212b.m19202a()) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
        }
        if (c3212b2.m19202a()) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setVisibility(0);
        }
        if (c3212b3.m19202a()) {
            imageView3.setVisibility(8);
        } else {
            imageView3.setVisibility(0);
        }
        imageView.setOnClickListener(new View.OnClickListener(c3212b, imageView, editText) { // from class: ru.maximoff.apktool.util.u.76

            /* renamed from: a */
            private final C3212b f20516a;

            /* renamed from: b */
            private final ImageView f20517b;

            /* renamed from: c */
            private final EditText f20518c;

            {
                this.f20516a = c3212b;
                this.f20517b = imageView;
                this.f20518c = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f20516a.m19201a(this.f20517b, this.f20518c);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener(c3212b2, imageView2, editText2) { // from class: ru.maximoff.apktool.util.u.77

            /* renamed from: a */
            private final C3212b f20519a;

            /* renamed from: b */
            private final ImageView f20520b;

            /* renamed from: c */
            private final EditText f20521c;

            {
                this.f20519a = c3212b2;
                this.f20520b = imageView2;
                this.f20521c = editText2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f20519a.m19201a(this.f20520b, this.f20521c);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener(c3212b3, imageView3, editText3) { // from class: ru.maximoff.apktool.util.u.78

            /* renamed from: a */
            private final C3212b f20522a;

            /* renamed from: b */
            private final ImageView f20523b;

            /* renamed from: c */
            private final EditText f20524c;

            {
                this.f20522a = c3212b3;
                this.f20523b = imageView3;
                this.f20524c = editText3;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f20522a.m19201a(this.f20523b, this.f20524c);
            }
        });
        imageView.setOnLongClickListener(new View.OnLongClickListener(c3212b, imageView, context) { // from class: ru.maximoff.apktool.util.u.79

            /* renamed from: a */
            private final C3212b f20525a;

            /* renamed from: b */
            private final ImageView f20526b;

            /* renamed from: c */
            private final Context f20527c;

            {
                this.f20525a = c3212b;
                this.f20526b = imageView;
                this.f20527c = context;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                new C3078aj(this.f20527c).m18500b(R.string.clear_history).m18495a(R.string.yes, new Runnable(this, this.f20525a, this.f20526b) { // from class: ru.maximoff.apktool.util.u.79.1

                    /* renamed from: a */
                    private final AnonymousClass79 f20528a;

                    /* renamed from: b */
                    private final C3212b f20529b;

                    /* renamed from: c */
                    private final ImageView f20530c;

                    {
                        this.f20528a = this;
                        this.f20529b = r2;
                        this.f20530c = r3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f20529b.m19208d();
                        this.f20530c.setVisibility(8);
                    }
                }).m18508e(R.string.cancel).m18507d();
                return true;
            }
        });
        imageView2.setOnLongClickListener(new View.OnLongClickListener(c3212b2, imageView2, context) { // from class: ru.maximoff.apktool.util.u.80

            /* renamed from: a */
            private final C3212b f20542a;

            /* renamed from: b */
            private final ImageView f20543b;

            /* renamed from: c */
            private final Context f20544c;

            {
                this.f20542a = c3212b2;
                this.f20543b = imageView2;
                this.f20544c = context;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                new C3078aj(this.f20544c).m18500b(R.string.clear_history).m18495a(R.string.yes, new Runnable(this, this.f20542a, this.f20543b) { // from class: ru.maximoff.apktool.util.u.80.1

                    /* renamed from: a */
                    private final AnonymousClass80 f20545a;

                    /* renamed from: b */
                    private final C3212b f20546b;

                    /* renamed from: c */
                    private final ImageView f20547c;

                    {
                        this.f20545a = this;
                        this.f20546b = r2;
                        this.f20547c = r3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f20546b.m19208d();
                        this.f20547c.setVisibility(8);
                    }
                }).m18508e(R.string.cancel).m18507d();
                return true;
            }
        });
        imageView3.setOnLongClickListener(new View.OnLongClickListener(c3212b3, imageView3, context) { // from class: ru.maximoff.apktool.util.u.81

            /* renamed from: a */
            private final C3212b f20548a;

            /* renamed from: b */
            private final ImageView f20549b;

            /* renamed from: c */
            private final Context f20550c;

            {
                this.f20548a = c3212b3;
                this.f20549b = imageView3;
                this.f20550c = context;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                new C3078aj(this.f20550c).m18500b(R.string.clear_history).m18495a(R.string.yes, new Runnable(this, this.f20548a, this.f20549b) { // from class: ru.maximoff.apktool.util.u.81.1

                    /* renamed from: a */
                    private final AnonymousClass81 f20551a;

                    /* renamed from: b */
                    private final C3212b f20552b;

                    /* renamed from: c */
                    private final ImageView f20553c;

                    {
                        this.f20551a = this;
                        this.f20552b = r2;
                        this.f20553c = r3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f20552b.m19208d();
                        this.f20553c.setVisibility(8);
                    }
                }).m18508e(R.string.cancel).m18507d();
                return true;
            }
        });
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(context).m418a(i).m435b(inflate).m420a(R.string.save, new DialogInterface.OnClickListener(context, str, checkBox, editText, c3212b, checkBox2, editText2, c3212b2, checkBox3, editText3, c3212b3, spinner, spinner2) { // from class: ru.maximoff.apktool.util.u.82

            /* renamed from: a */
            private final Context f20554a;

            /* renamed from: b */
            private final String f20555b;

            /* renamed from: c */
            private final CheckBox f20556c;

            /* renamed from: d */
            private final EditText f20557d;

            /* renamed from: e */
            private final C3212b f20558e;

            /* renamed from: f */
            private final CheckBox f20559f;

            /* renamed from: g */
            private final EditText f20560g;

            /* renamed from: h */
            private final C3212b f20561h;

            /* renamed from: i */
            private final CheckBox f20562i;

            /* renamed from: j */
            private final EditText f20563j;

            /* renamed from: k */
            private final C3212b f20564k;

            /* renamed from: l */
            private final Spinner f20565l;

            /* renamed from: m */
            private final Spinner f20566m;

            {
                this.f20554a = context;
                this.f20555b = str;
                this.f20556c = checkBox;
                this.f20557d = editText;
                this.f20558e = c3212b;
                this.f20559f = checkBox2;
                this.f20560g = editText2;
                this.f20561h = c3212b2;
                this.f20562i = checkBox3;
                this.f20563j = editText3;
                this.f20564k = c3212b3;
                this.f20565l = spinner;
                this.f20566m = spinner2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                C3102bd.m18938b(this.f20554a, new StringBuffer().append(this.f20555b).append("aapt2_densities_enable").toString(), this.f20556c.isChecked());
                if (this.f20556c.isChecked()) {
                    String replaceAll = this.f20557d.getText().toString().replaceAll("\\s", "");
                    C3102bd.m18937b(this.f20554a, new StringBuffer().append(this.f20555b).append("aapt2_target_densities").toString(), replaceAll);
                    this.f20558e.m19204a(replaceAll);
                }
                C3102bd.m18938b(this.f20554a, new StringBuffer().append(this.f20555b).append("aapt2_configurations_enable").toString(), this.f20559f.isChecked());
                if (this.f20559f.isChecked()) {
                    String replaceAll2 = this.f20560g.getText().toString().replaceAll("\\s", "");
                    C3102bd.m18937b(this.f20554a, new StringBuffer().append(this.f20555b).append("aapt2_configurations_include").toString(), replaceAll2);
                    this.f20561h.m19204a(replaceAll2);
                }
                C3102bd.m18938b(this.f20554a, new StringBuffer().append(this.f20555b).append("aapt2_libs_enable").toString(), this.f20562i.isChecked());
                if (this.f20562i.isChecked()) {
                    String replaceAll3 = this.f20563j.getText().toString().replaceAll("\\s", "");
                    C3102bd.m18937b(this.f20554a, new StringBuffer().append(this.f20555b).append("aapt2_libs_include").toString(), replaceAll3);
                    this.f20564k.m19204a(replaceAll3);
                }
                C3102bd.m18935b(this.f20554a, new StringBuffer().append(this.f20555b).append("aapt2_minSdk").toString(), this.f20565l.getSelectedItemPosition());
                C3102bd.m18935b(this.f20554a, new StringBuffer().append(this.f20555b).append("aapt2_targetSdk").toString(), this.f20566m.getSelectedItemPosition());
                C3112bn.m18999a(this.f20554a, R.string.success);
                dialogInterface.cancel();
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.search_reset, new DialogInterface.OnClickListener(context, str) { // from class: ru.maximoff.apktool.util.u.83

            /* renamed from: a */
            private final Context f20567a;

            /* renamed from: b */
            private final String f20568b;

            {
                this.f20567a = context;
                this.f20568b = str;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                C3102bd.m18924a(this.f20567a, new StringBuffer().append(this.f20568b).append("aapt2_densities_enable").toString());
                C3102bd.m18924a(this.f20567a, new StringBuffer().append(this.f20568b).append("aapt2_target_densities").toString());
                C3102bd.m18924a(this.f20567a, new StringBuffer().append(this.f20568b).append("aapt2_configurations_enable").toString());
                C3102bd.m18924a(this.f20567a, new StringBuffer().append(this.f20568b).append("aapt2_configurations_include").toString());
                C3102bd.m18924a(this.f20567a, new StringBuffer().append(this.f20568b).append("aapt2_libs_enable").toString());
                C3102bd.m18924a(this.f20567a, new StringBuffer().append(this.f20568b).append("aapt2_libs_include").toString());
                C3102bd.m18924a(this.f20567a, new StringBuffer().append(this.f20568b).append("aapt2_minSdk").toString());
                C3102bd.m18924a(this.f20567a, new StringBuffer().append(this.f20568b).append("aapt2_targetSdk").toString());
                dialogInterface.cancel();
            }
        }).m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(m18925a, editText, m18925a2, editText2, m18925a3, editText3) { // from class: ru.maximoff.apktool.util.u.84

            /* renamed from: a */
            private final boolean f20569a;

            /* renamed from: b */
            private final EditText f20570b;

            /* renamed from: c */
            private final boolean f20571c;

            /* renamed from: d */
            private final EditText f20572d;

            /* renamed from: e */
            private final boolean f20573e;

            /* renamed from: f */
            private final EditText f20574f;

            {
                this.f20569a = m18925a;
                this.f20570b = editText;
                this.f20571c = m18925a2;
                this.f20572d = editText2;
                this.f20573e = m18925a3;
                this.f20574f = editText3;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (this.f20569a) {
                    this.f20570b.requestFocus();
                    this.f20570b.setSelection(this.f20570b.getText().length());
                } else if (this.f20571c) {
                    this.f20572d.requestFocus();
                    this.f20572d.setSelection(this.f20572d.getText().length());
                } else if (this.f20573e) {
                    this.f20574f.requestFocus();
                    this.f20574f.setSelection(this.f20574f.getText().length());
                }
            }
        });
        m438b.show();
    }

    /* renamed from: a */
    private static void m19579a(Context context, File file, View view, InterfaceC2995n interfaceC2995n) {
        File m16639u = MainActivity.m16615o().m16639u();
        boolean m19664g = m19664g(context, m16639u);
        boolean m19664g2 = m19664g(context, file.getParentFile());
        boolean z = Build.VERSION.SDK_INT >= 21;
        String str = m19641b(file.getName())[0];
        Menu m18715a = C3089au.m18715a(view, R.menu.apks, new C3089au.a(file, z, interfaceC2995n, str, m16639u, new int[]{1, 2}) { // from class: ru.maximoff.apktool.util.u.85

            /* renamed from: a */
            private final File f20575a;

            /* renamed from: b */
            private final boolean f20576b;

            /* renamed from: c */
            private final InterfaceC2995n f20577c;

            /* renamed from: d */
            private final String f20578d;

            /* renamed from: e */
            private final File f20579e;

            /* renamed from: f */
            private final int[] f20580f;

            {
                this.f20575a = file;
                this.f20576b = z;
                this.f20577c = interfaceC2995n;
                this.f20578d = str;
                this.f20579e = m16639u;
                this.f20580f = r6;
            }

            @Override // ru.maximoff.apktool.util.C3089au.a
            /* renamed from: a */
            public void mo17670a(Context context2, int i) {
                switch (i) {
                    case R.id.app_details /* 2131690153 */:
                        C3080al.m18551a(context2, this.f20575a, (PackageInfo) null, (PackageManager) null);
                        break;
                    case R.id.decompile /* 2131690155 */:
                    case R.id.antisplit /* 2131690175 */:
                    case R.id.decompile_full /* 2131690176 */:
                        boolean z2 = i == R.id.decompile_full;
                        C3262u.m19587a(context2, this.f20575a, this.f20577c, 0, z2 || i == R.id.decompile, z2);
                        break;
                    case R.id.sign /* 2131690156 */:
                        this.f20580f[1] = 2;
                        Runnable runnable = new Runnable(this, context2, this.f20580f, this.f20577c, this.f20575a) { // from class: ru.maximoff.apktool.util.u.85.1

                            /* renamed from: a */
                            private final AnonymousClass85 f20581a;

                            /* renamed from: b */
                            private final Context f20582b;

                            /* renamed from: c */
                            private final int[] f20583c;

                            /* renamed from: d */
                            private final InterfaceC2995n f20584d;

                            /* renamed from: e */
                            private final File f20585e;

                            {
                                this.f20581a = this;
                                this.f20582b = context2;
                                this.f20583c = r3;
                                this.f20584d = r4;
                                this.f20585e = r5;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                C2917as.m17314a(this.f20582b, this.f20583c[0], new C2917as.a(this, this.f20582b, this.f20584d, this.f20585e) { // from class: ru.maximoff.apktool.util.u.85.1.1

                                    /* renamed from: a */
                                    private final AnonymousClass1 f20586a;

                                    /* renamed from: b */
                                    private final Context f20587b;

                                    /* renamed from: c */
                                    private final InterfaceC2995n f20588c;

                                    /* renamed from: d */
                                    private final File f20589d;

                                    {
                                        this.f20586a = this;
                                        this.f20587b = r2;
                                        this.f20588c = r3;
                                        this.f20589d = r4;
                                    }

                                    @Override // ru.maximoff.apktool.p300e.C2917as.a
                                    /* renamed from: a */
                                    public void mo16440a(C2917as c2917as, boolean z3) {
                                        try {
                                            new AsyncTaskC2916ar(this.f20587b, this.f20588c, c2917as).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20589d);
                                        } catch (Exception e2) {
                                            C3112bn.m18999a(this.f20587b, R.string.error_try_again);
                                        }
                                    }
                                });
                            }
                        };
                        if (C3102bd.m18925a(context2, "custom_signature_file", false)) {
                            C3262u.m19599a(context2, this.f20580f, runnable, (Runnable) null);
                            break;
                        } else {
                            new Handler(Looper.getMainLooper()).postDelayed(runnable, 100L);
                            break;
                        }
                    case R.id.verify /* 2131690157 */:
                        AsyncTaskC2928bc asyncTaskC2928bc = new AsyncTaskC2928bc(context2);
                        asyncTaskC2928bc.m17060b(this.f20575a);
                        asyncTaskC2928bc.m17445g(true);
                        try {
                            asyncTaskC2928bc.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20575a);
                            break;
                        } catch (Exception e2) {
                            C3112bn.m18999a(context2, R.string.error_try_again);
                            return;
                        }
                    case R.id.zipalign /* 2131690165 */:
                        AsyncTaskC2929bd asyncTaskC2929bd = new AsyncTaskC2929bd(context2, this.f20577c, 0);
                        asyncTaskC2929bd.m17453a();
                        try {
                            asyncTaskC2929bd.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20575a);
                            break;
                        } catch (Exception e3) {
                            C3112bn.m18999a(context2, R.string.error_try_again);
                            return;
                        }
                    case R.id.installSplit /* 2131690173 */:
                    case R.id.installnsignSplit /* 2131690174 */:
                        if (this.f20576b) {
                            C3262u.m19586a(context2, this.f20575a, this.f20577c, i != R.id.installSplit ? 2 : 1, false);
                            break;
                        }
                        break;
                    case R.id.exhere /* 2131690177 */:
                        C3262u.m19582a(context2, this.f20575a, this.f20575a.getParentFile(), false, R.string.mextract_zip);
                        break;
                    case R.id.extoname /* 2131690178 */:
                        C3262u.m19583a(context2, this.f20575a, new File(new StringBuffer().append(new StringBuffer().append(this.f20575a.getParent()).append("/").toString()).append(this.f20578d).toString()), true, context2.getString(R.string.mextract_zip_to, this.f20578d));
                        break;
                    case R.id.extotab /* 2131690179 */:
                        C3262u.m19582a(context2, this.f20575a, this.f20579e, false, R.string.mextract_zip_to2);
                        break;
                    case R.id.open_zip /* 2131690180 */:
                        try {
                            new AsyncTaskC2901ac(context2, this.f20575a, this.f20577c).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            break;
                        } catch (Exception e4) {
                            C3112bn.m18999a(context2, R.string.error_try_again);
                            return;
                        }
                    case R.id.jar2dex /* 2131690181 */:
                        try {
                            new AsyncTaskC2942m(context2, this.f20577c, true).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20575a);
                            break;
                        } catch (Exception e5) {
                            C3112bn.m18999a(context2, R.string.error_try_again);
                            return;
                        }
                }
            }
        });
        boolean z2 = file.getName().endsWith(".apks") || file.getName().endsWith(".xapk") || file.getName().endsWith(".apkm");
        m18715a.findItem(R.id.app_details).setVisible(z2);
        m18715a.findItem(R.id.installSplit).setVisible(z && z2);
        m18715a.findItem(R.id.installnsignSplit).setVisible(z && z2);
        m18715a.findItem(R.id.antisplit).setVisible(z2);
        m18715a.findItem(R.id.decompile).setVisible(z2);
        m18715a.findItem(R.id.decompile_full).setVisible(z2);
        m18715a.findItem(R.id.verify).setVisible(z2);
        m18715a.findItem(R.id.exhere).setVisible(m19664g2);
        m18715a.findItem(R.id.extoname).setVisible(m19664g2);
        m18715a.findItem(R.id.extoname).setTitle(view.getContext().getString(R.string.mextract_zip_to, str));
        m18715a.findItem(R.id.extotab).setVisible(m19664g);
        m18715a.findItem(R.id.sign).setVisible(!z2);
        m18715a.findItem(R.id.jar2dex).setVisible(file.getName().endsWith(".jar"));
    }

    /* renamed from: a */
    public static int m19563a(File file) {
        if (!file.isDirectory()) {
            return 0;
        }
        try {
            if (new File(file, ".dex037").isFile()) {
                return 1;
            }
            if (new File(file, ".dex038").isFile()) {
                return 2;
            }
            if (!new File(file, ".dex039").isFile()) {
                return 0;
            }
            return 3;
        } catch (Exception e2) {
            return 0;
        }
    }

    /* renamed from: a */
    public static File m19564a() {
        File createTempFile = File.createTempFile("temp", Long.toString(System.nanoTime()), C3102bd.m18908a());
        if (!createTempFile.delete()) {
            throw new IOException(new StringBuffer().append("Could not delete temp file: ").append(createTempFile.getAbsolutePath()).toString());
        }
        if (!createTempFile.mkdirs()) {
            throw new IOException(new StringBuffer().append("Could not create temp directory: ").append(createTempFile.getAbsolutePath()).toString());
        }
        return createTempFile;
    }

    /* renamed from: a */
    public static void m19607a(File file, long j, boolean z, boolean z2, boolean z3) {
        File[] listFiles;
        if ((z || z2) && (listFiles = file.listFiles(new FilenameFilter() { // from class: ru.maximoff.apktool.util.u.86
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                return C3102bd.f18269E || str.charAt(0) != '.';
            }
        })) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    if (z && !m19611a(file2, j, z3)) {
                        throw new Exception("file modification time change error");
                    }
                    m19607a(file2, j, z, z2, z3);
                } else if (file2.isFile() && z2 && !m19611a(file2, j, z3)) {
                    throw new Exception("file modification time change error");
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m19610a(File file, long j) {
        return m19611a(file, j, false);
    }

    /* renamed from: a */
    public static boolean m19611a(File file, long j, boolean z) {
        if (!C3102bd.f18312at && !z) {
            return true;
        }
        if (!file.exists() || j < 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                Files.setLastModifiedTime(file.toPath(), FileTime.fromMillis(j));
                return true;
            } catch (Exception e2) {
            }
        }
        if (file.setLastModified(j)) {
            return true;
        }
        return C3080al.m18569a(file, j);
    }

    /* renamed from: b */
    public static C3253m m19624b(File file) {
        if (file == null) {
            return (C3253m) null;
        }
        try {
            return m19574a(new FileInputStream(file));
        } catch (Exception e2) {
            return (C3253m) null;
        }
    }

    /* renamed from: a */
    public static C3253m m19574a(InputStream inputStream) {
        if (inputStream == null) {
            return (C3253m) null;
        }
        try {
            byte[] bArr = new byte[100];
            if (inputStream.read(bArr) != bArr.length) {
                C3253m c3253m = (C3253m) null;
                try {
                    inputStream.close();
                } catch (IOException e2) {
                }
                return c3253m;
            }
            if (Arrays.equals(Arrays.copyOf(bArr, 4), C3249i.f19536B)) {
                C3253m c3253m2 = new C3253m(bArr);
                try {
                    inputStream.close();
                } catch (IOException e3) {
                }
                return c3253m2;
            }
            C3253m c3253m3 = (C3253m) null;
            try {
                inputStream.close();
            } catch (IOException e4) {
            }
            return c3253m3;
        } catch (Exception e5) {
            try {
                inputStream.close();
            } catch (IOException e6) {
            }
            return (C3253m) null;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e7) {
            }
            throw th;
        }
    }

    /* renamed from: c */
    public static boolean m19647c(File file) {
        if (file == null) {
            return false;
        }
        try {
            return m19638b(new FileInputStream(file));
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m19638b(InputStream inputStream) {
        if (inputStream == null) {
            return false;
        }
        byte[] bArr = new byte[4];
        try {
            if (inputStream.read(bArr) == bArr.length) {
                boolean equals = Arrays.equals(bArr, C3249i.f19566z);
                try {
                    inputStream.close();
                } catch (IOException e2) {
                }
                return equals;
            }
            try {
                inputStream.close();
                return false;
            } catch (IOException e3) {
                return false;
            }
        } catch (Exception e4) {
            try {
                inputStream.close();
                return false;
            } catch (IOException e5) {
                return false;
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e6) {
            }
            throw th;
        }
    }

    /* renamed from: d */
    public static boolean m19654d(File file) {
        if (file == null) {
            return false;
        }
        try {
            return m19648c(new FileInputStream(file));
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m19648c(InputStream inputStream) {
        if (inputStream == null) {
            return false;
        }
        byte[] bArr = new byte[4];
        try {
            if (inputStream.read(bArr) == bArr.length) {
                boolean z = Arrays.equals(bArr, C3249i.f19563w) || Arrays.equals(bArr, C3249i.f19564x) || Arrays.equals(bArr, C3249i.f19565y);
                try {
                    inputStream.close();
                } catch (IOException e2) {
                }
                return z;
            }
            try {
                inputStream.close();
                return false;
            } catch (IOException e3) {
                return false;
            }
        } catch (Exception e4) {
            try {
                inputStream.close();
                return false;
            } catch (IOException e5) {
                return false;
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e6) {
            }
            throw th;
        }
    }

    /* renamed from: e */
    public static boolean m19660e(File file) {
        return m19663f(file) || m19665g(file) || m19667h(file) || m19669i(file);
    }

    /* renamed from: f */
    public static boolean m19663f(File file) {
        InputStream inputStream;
        if (file == null) {
            return false;
        }
        byte[] bArr = new byte[4];
        InputStream inputStream2 = (InputStream) null;
        try {
            inputStream = new FileInputStream(file);
            try {
                if (inputStream.read(bArr) != bArr.length) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    return false;
                }
                boolean equals = Arrays.equals(bArr, C3249i.f19557q);
                if (inputStream == null) {
                    return equals;
                }
                try {
                    inputStream.close();
                    return equals;
                } catch (IOException e3) {
                    return equals;
                }
            } catch (Exception e4) {
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e5) {
                    }
                }
                return false;
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                    }
                }
                throw th;
            }
        } catch (Exception e7) {
        } catch (Throwable th2) {
            th = th2;
            inputStream = inputStream2;
        }
    }

    /* renamed from: g */
    public static boolean m19665g(File file) {
        InputStream inputStream;
        if (file == null) {
            return false;
        }
        byte[] bArr = new byte[4];
        InputStream inputStream2 = (InputStream) null;
        try {
            inputStream = new FileInputStream(file);
            try {
                if (inputStream.read(bArr) != bArr.length) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    return false;
                }
                boolean equals = Arrays.equals(bArr, C3249i.f19558r);
                if (inputStream == null) {
                    return equals;
                }
                try {
                    inputStream.close();
                    return equals;
                } catch (IOException e3) {
                    return equals;
                }
            } catch (Exception e4) {
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e5) {
                    }
                }
                return false;
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                    }
                }
                throw th;
            }
        } catch (Exception e7) {
        } catch (Throwable th2) {
            th = th2;
            inputStream = inputStream2;
        }
    }

    /* renamed from: h */
    public static boolean m19667h(File file) {
        InputStream inputStream;
        if (file == null) {
            return false;
        }
        byte[] bArr = new byte[4];
        InputStream inputStream2 = (InputStream) null;
        try {
            inputStream = new FileInputStream(file);
        } catch (Exception e2) {
        } catch (Throwable th) {
            th = th;
            inputStream = inputStream2;
        }
        try {
            if (inputStream.read(bArr) == bArr.length) {
                boolean z = Arrays.equals(bArr, C3249i.f19559s) || Arrays.equals(bArr, C3249i.f19560t) || Arrays.equals(bArr, C3249i.f19561u);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                    }
                }
                return z;
            }
            if (inputStream == null) {
                return false;
            }
            try {
                inputStream.close();
                return false;
            } catch (IOException e4) {
                return false;
            }
        } catch (Exception e5) {
            inputStream2 = inputStream;
            if (inputStream2 == null) {
                return false;
            }
            try {
                inputStream2.close();
                return false;
            } catch (IOException e6) {
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e7) {
                }
            }
            throw th;
        }
    }

    /* renamed from: i */
    public static boolean m19669i(File file) {
        InputStream inputStream;
        if (file == null) {
            return false;
        }
        byte[] bArr = new byte[4];
        InputStream inputStream2 = (InputStream) null;
        try {
            inputStream = new FileInputStream(file);
            try {
                if (inputStream.read(bArr) != bArr.length) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    return false;
                }
                boolean equals = Arrays.equals(bArr, C3249i.f19562v);
                if (inputStream == null) {
                    return equals;
                }
                try {
                    inputStream.close();
                    return equals;
                } catch (IOException e3) {
                    return equals;
                }
            } catch (Exception e4) {
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e5) {
                    }
                }
                return false;
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                    }
                }
                throw th;
            }
        } catch (Exception e7) {
        } catch (Throwable th2) {
            th = th2;
            inputStream = inputStream2;
        }
    }

    /* renamed from: j */
    public static boolean m19671j(File file) {
        if (file == null) {
            return false;
        }
        try {
            return m19655d(new FileInputStream(file));
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m19655d(InputStream inputStream) {
        if (inputStream == null) {
            return false;
        }
        byte[] bArr = new byte[4];
        try {
            if (inputStream.read(bArr) == bArr.length) {
                boolean equals = Arrays.equals(bArr, C3249i.f19535A);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                    }
                }
                return equals;
            }
            if (inputStream == null) {
                return false;
            }
            try {
                inputStream.close();
                return false;
            } catch (IOException e3) {
                return false;
            }
        } catch (Exception e4) {
            if (inputStream == null) {
                return false;
            }
            try {
                inputStream.close();
                return false;
            } catch (IOException e5) {
                return false;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                }
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static byte[] m19619a(InputStream inputStream, int i) {
        if (inputStream == null || i <= 0) {
            return (byte[]) null;
        }
        byte[] bArr = new byte[i];
        try {
            if (inputStream.read(bArr) == bArr.length) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                    }
                }
                return bArr;
            }
            byte[] bArr2 = (byte[]) null;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                }
            }
            return bArr2;
        } catch (Exception e4) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
            return (byte[]) null;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m19672k(File file) {
        InputStream inputStream;
        if (file == null) {
            return -1;
        }
        byte[] bArr = new byte[8];
        InputStream inputStream2 = (InputStream) null;
        try {
            inputStream = new FileInputStream(file);
            try {
            } catch (Exception e2) {
                inputStream2 = inputStream;
                inputStream = inputStream2;
                if (inputStream != null) {
                }
                return -1;
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
        } catch (Throwable th2) {
            th = th2;
            inputStream = inputStream2;
        }
        if (inputStream.read(bArr) != bArr.length) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
            return -1;
        }
        if (Arrays.equals(bArr, C3249i.f19537C)) {
            if (inputStream == null) {
                return 0;
            }
            try {
                inputStream.close();
                return 0;
            } catch (IOException e6) {
                return 0;
            }
        }
        if (Arrays.equals(bArr, C3249i.f19538D)) {
            if (inputStream == null) {
                return 1;
            }
            try {
                inputStream.close();
                return 1;
            } catch (IOException e7) {
                return 1;
            }
        }
        if (Arrays.equals(bArr, C3249i.f19539E)) {
            if (inputStream == null) {
                return 2;
            }
            try {
                inputStream.close();
                return 2;
            } catch (IOException e8) {
                return 2;
            }
        }
        if (Arrays.equals(bArr, C3249i.f19540F)) {
            if (inputStream == null) {
                return 3;
            }
            try {
                inputStream.close();
                return 3;
            } catch (IOException e9) {
                return 3;
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static String m19570a(Context context, File[] fileArr, String[] strArr, int i, boolean z, boolean z2) {
        if (m19649c(fileArr)) {
            return (String) null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < fileArr.length; i2++) {
            File file = fileArr[i2];
            if (i2 > 0) {
                sb.append("\n");
            }
            sb.append(file.getAbsolutePath().substring(i));
            if (file.isDirectory() && z2) {
                sb.append("/");
            }
            if (z && !file.isFile()) {
                File[] listFiles = file.listFiles(new FilenameFilter() { // from class: ru.maximoff.apktool.util.u.87
                    @Override // java.io.FilenameFilter
                    public boolean accept(File file2, String str) {
                        return !str.startsWith(".") || C3102bd.f18269E;
                    }
                });
                if (m19649c(listFiles) && !m19618a(strArr, file)) {
                    listFiles = C3086ar.m18671a(context, file.getAbsolutePath(), C3102bd.f18269E);
                }
                if (m19649c(listFiles)) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= strArr.length) {
                            break;
                        }
                        if (!file.getAbsolutePath().equalsIgnoreCase(new StringBuffer().append(strArr[i3]).append(C3249i.f19551k).toString())) {
                            i3++;
                        } else {
                            listFiles = new File[]{new File(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(strArr[i3]).append(C3249i.f19551k).toString()).append("/").toString()).append(context.getPackageName()).toString())};
                            break;
                        }
                    }
                }
                String m19570a = m19570a(context, (m19649c(listFiles) && file.getAbsolutePath().equalsIgnoreCase(C3249i.f19550j)) ? new File[]{new File(new StringBuffer().append(new StringBuffer().append(C3249i.f19550j).append("/").toString()).append(context.getPackageName()).toString())} : listFiles, strArr, i, z, z2);
                if (m19570a != null) {
                    sb.append("\n").append(m19570a);
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: c */
    public static boolean m19649c(File[] fileArr) {
        return fileArr == null || fileArr.length == 0;
    }

    /* renamed from: c */
    private static void m19646c(File file, View view, InterfaceC2995n interfaceC2995n) {
        Context context = view.getContext();
        if (m19654d(file)) {
            m19579a(context, file, view, interfaceC2995n);
            return;
        }
        if (!m19616a(new StringBuffer().append(context.getPackageName()).append(".unapkm").toString(), context.getPackageManager())) {
            if (Build.VERSION.SDK_INT >= 19) {
                DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(context);
                aVar.m433b(R.string.mapp_down_plugin);
                aVar.m434b(R.string.cancel, (DialogInterface.OnClickListener) null);
                aVar.m420a(R.string.mplugin_down, new DialogInterface.OnClickListener(context) { // from class: ru.maximoff.apktool.util.u.88

                    /* renamed from: a */
                    private final Context f20590a;

                    {
                        this.f20590a = context;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C3080al.m18595e(this.f20590a, new StringBuffer().append(new StringBuffer().append("https://raw.githubusercontent.com/Maximoff/Apktool-M-updates/main/").append("files/UnApkm.apk?t=").toString()).append(System.currentTimeMillis()).toString());
                    }
                });
                aVar.m440c(R.string.open_in, new DialogInterface.OnClickListener(context, file) { // from class: ru.maximoff.apktool.util.u.89

                    /* renamed from: a */
                    private final Context f20591a;

                    /* renamed from: b */
                    private final File f20592b;

                    {
                        this.f20591a = context;
                        this.f20592b = file;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C3262u.m19650d(this.f20591a, this.f20592b);
                    }
                });
                aVar.m438b().show();
                return;
            }
            m19650d(context, file);
            return;
        }
        C3089au.m18715a(view, R.menu.apkm, new C3089au.a(context, interfaceC2995n, file) { // from class: ru.maximoff.apktool.util.u.90

            /* renamed from: a */
            private final Context f20596a;

            /* renamed from: b */
            private final InterfaceC2995n f20597b;

            /* renamed from: c */
            private final File f20598c;

            {
                this.f20596a = context;
                this.f20597b = interfaceC2995n;
                this.f20598c = file;
            }

            @Override // ru.maximoff.apktool.util.C3089au.a
            /* renamed from: a */
            public void mo17670a(Context context2, int i) {
                switch (i) {
                    case R.id.open_in /* 2131690170 */:
                        C3262u.m19650d(context2, this.f20598c);
                        break;
                    case R.id.sharing_file /* 2131690171 */:
                        C3262u.m19604a(context2, new File[]{this.f20598c});
                        break;
                    case R.id.to_apks /* 2131690172 */:
                        if (!C3102bd.m18925a(context2, "plugin_mod_nrm", false) && !C3080al.m18590c(this.f20596a, true)) {
                            DialogInterfaceC0070b.a aVar2 = new DialogInterfaceC0070b.a(context2);
                            aVar2.m418a(R.string.attention);
                            aVar2.m433b(R.string.plugin_modif);
                            aVar2.m434b(R.string.cancel, (DialogInterface.OnClickListener) null);
                            aVar2.m420a(R.string.delete, new DialogInterface.OnClickListener(this, context2) { // from class: ru.maximoff.apktool.util.u.90.1

                                /* renamed from: a */
                                private final AnonymousClass90 f20599a;

                                /* renamed from: b */
                                private final Context f20600b;

                                {
                                    this.f20599a = this;
                                    this.f20600b = context2;
                                }

                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                    C3080al.m18601g(this.f20600b, new StringBuffer().append(this.f20600b.getPackageName()).append(".unapkm").toString());
                                }
                            });
                            aVar2.m440c(R.string.not_remind, new DialogInterface.OnClickListener(this, context2, this.f20597b, this.f20598c, this.f20596a) { // from class: ru.maximoff.apktool.util.u.90.2

                                /* renamed from: a */
                                private final AnonymousClass90 f20601a;

                                /* renamed from: b */
                                private final Context f20602b;

                                /* renamed from: c */
                                private final InterfaceC2995n f20603c;

                                /* renamed from: d */
                                private final File f20604d;

                                /* renamed from: e */
                                private final Context f20605e;

                                {
                                    this.f20601a = this;
                                    this.f20602b = context2;
                                    this.f20603c = r3;
                                    this.f20604d = r4;
                                    this.f20605e = r5;
                                }

                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                    C3102bd.m18938b(this.f20602b, "plugin_mod_nrm", true);
                                    try {
                                        new AsyncTaskC2923ay(this.f20602b, this.f20603c).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20604d);
                                    } catch (Exception e2) {
                                        C3112bn.m18999a(this.f20605e, R.string.error_try_again);
                                    }
                                }
                            });
                            aVar2.m438b().show();
                            break;
                        } else {
                            try {
                                new AsyncTaskC2923ay(context2, this.f20597b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20598c);
                                break;
                            } catch (Exception e2) {
                                C3112bn.m18999a(this.f20596a, R.string.error_try_again);
                                return;
                            }
                        }
                }
            }
        });
    }

    /* renamed from: b */
    private static void m19627b(Context context, File file, View view, InterfaceC2995n interfaceC2995n) {
        Drawable m18380a = C3067ab.m18380a(context, file);
        boolean m19664g = m19664g(context, file);
        if (m18380a == null && !m19664g) {
            m19650d(context, file);
            return;
        }
        Menu m18715a = C3089au.m18715a(view, R.menu.axml, new C3089au.a(MainActivity.m16615o(), file, interfaceC2995n, m18380a) { // from class: ru.maximoff.apktool.util.u.91

            /* renamed from: a */
            private final MainActivity f20606a;

            /* renamed from: b */
            private final File f20607b;

            /* renamed from: c */
            private final InterfaceC2995n f20608c;

            /* renamed from: d */
            private final Drawable f20609d;

            {
                this.f20606a = r1;
                this.f20607b = file;
                this.f20608c = interfaceC2995n;
                this.f20609d = m18380a;
            }

            @Override // ru.maximoff.apktool.util.C3089au.a
            /* renamed from: a */
            public void mo17670a(Context context2, int i) {
                switch (i) {
                    case R.id.edit_axml /* 2131690161 */:
                        try {
                            Intent intent = new Intent(this.f20606a, Class.forName("ru.maximoff.apktool.AxmlEdit"));
                            intent.putExtra("data", this.f20607b.getAbsolutePath());
                            this.f20606a.startActivityForResult(intent, 0);
                            return;
                        } catch (ClassNotFoundException e2) {
                            throw new NoClassDefFoundError(e2.getMessage());
                        }
                    case R.id.open_in /* 2131690170 */:
                        C3262u.m19650d(context2, this.f20607b);
                        return;
                    case R.id.prev_vector /* 2131690188 */:
                        C3262u.m19596a(context2, this.f20608c, (C3099ba) null, this.f20609d, this.f20607b);
                        return;
                    default:
                        return;
                }
            }
        });
        m18715a.findItem(R.id.edit_axml).setVisible(m19664g);
        m18715a.findItem(R.id.prev_vector).setVisible(m18380a != null);
    }

    /* renamed from: d */
    private static void m19653d(File file, View view, InterfaceC2995n interfaceC2995n) {
        C3089au.m18715a(view, R.menu.dex, new C3089au.a(file, interfaceC2995n) { // from class: ru.maximoff.apktool.util.u.92

            /* renamed from: a */
            private final File f20610a;

            /* renamed from: b */
            private final InterfaceC2995n f20611b;

            {
                this.f20610a = file;
                this.f20611b = interfaceC2995n;
            }

            @Override // ru.maximoff.apktool.util.C3089au.a
            /* renamed from: a */
            public void mo17670a(Context context, int i) {
                switch (i) {
                    case R.id.info /* 2131689924 */:
                        try {
                            C3253m m19624b = C3262u.m19624b(this.f20610a);
                            if (m19624b != null) {
                                m19624b.f19662h = this.f20610a.length();
                                AsyncTaskC2944o asyncTaskC2944o = new AsyncTaskC2944o(context, (C3060a) null);
                                asyncTaskC2944o.m17521a(this.f20610a.getName(), m19624b);
                                asyncTaskC2944o.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (File) null);
                            } else {
                                C3112bn.m18999a(context, R.string.error);
                            }
                            break;
                        } catch (Exception e2) {
                            C3112bn.m18999a(context, R.string.error);
                            return;
                        }
                    case R.id.open_in /* 2131690170 */:
                        C3262u.m19650d(context, this.f20610a);
                        break;
                    case R.id.sharing_file /* 2131690171 */:
                        C3262u.m19604a(context, new File[]{this.f20610a});
                        break;
                    case R.id.decompile_dex /* 2131690206 */:
                        int m19672k = C3262u.m19672k(this.f20610a);
                        int i2 = m19672k < 0 ? 0 : m19672k;
                        boolean m19664g = C3262u.m19664g(context, this.f20610a);
                        View inflate = LayoutInflater.from(context).inflate(R.layout.spinner_layout2, (ViewGroup) null);
                        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.spinnerlayout2CheckBox1);
                        if (m19664g) {
                            checkBox.setVisibility(0);
                        } else {
                            checkBox.setVisibility(8);
                        }
                        Spinner spinner = (Spinner) inflate.findViewById(R.id.spinnerlayout2Spinner1);
                        spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(context, C0012R.layout.simple_spinner_dropdown_item, C3080al.f17664a));
                        spinner.setSelection(i2);
                        new DialogInterfaceC0070b.a(context).m418a(R.string.dex_version).m435b(inflate).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, context, spinner, this.f20611b, checkBox, m19664g, this.f20610a) { // from class: ru.maximoff.apktool.util.u.92.1

                            /* renamed from: a */
                            private final AnonymousClass92 f20612a;

                            /* renamed from: b */
                            private final Context f20613b;

                            /* renamed from: c */
                            private final Spinner f20614c;

                            /* renamed from: d */
                            private final InterfaceC2995n f20615d;

                            /* renamed from: e */
                            private final CheckBox f20616e;

                            /* renamed from: f */
                            private final boolean f20617f;

                            /* renamed from: g */
                            private final File f20618g;

                            {
                                this.f20612a = this;
                                this.f20613b = context;
                                this.f20614c = spinner;
                                this.f20615d = r4;
                                this.f20616e = checkBox;
                                this.f20617f = m19664g;
                                this.f20618g = r7;
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                try {
                                    AsyncTaskC2943n asyncTaskC2943n = new AsyncTaskC2943n(this.f20613b, C3080al.f17665b[this.f20614c.getSelectedItemPosition()], this.f20615d);
                                    asyncTaskC2943n.m17518h(this.f20616e.isChecked() && this.f20617f);
                                    asyncTaskC2943n.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20618g);
                                } catch (Exception e3) {
                                    C3112bn.m18999a(this.f20613b, R.string.error_try_again);
                                }
                                dialogInterface.dismiss();
                            }
                        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
                        break;
                    case R.id.split_dex /* 2131690207 */:
                        String[] strArr = {C3102bd.m18910a(context, "dex_split_mc", String.valueOf(32768)), C3102bd.m18910a(context, "dex_split_dc", "2")};
                        Button[] buttonArr = new Button[1];
                        View inflate2 = LayoutInflater.from(context).inflate(R.layout.split_dex, (ViewGroup) null);
                        EditText editText = (EditText) inflate2.findViewById(R.id.splitdexEditText1);
                        editText.setText(strArr[0]);
                        ImageButton imageButton = (ImageButton) inflate2.findViewById(R.id.splitdexImageButton1);
                        if (C3102bd.f18291a) {
                            imageButton.setImageResource(R.drawable.ic_top);
                        } else {
                            imageButton.setImageResource(R.drawable.ic_top_dark);
                        }
                        imageButton.setOnClickListener(new View.OnClickListener(this, editText) { // from class: ru.maximoff.apktool.util.u.92.2

                            /* renamed from: a */
                            private final AnonymousClass92 f20619a;

                            /* renamed from: b */
                            private final EditText f20620b;

                            {
                                this.f20619a = this;
                                this.f20620b = editText;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                this.f20620b.setText(String.valueOf(65536));
                                this.f20620b.setSelection(this.f20620b.getText().length());
                                this.f20620b.requestFocus();
                            }
                        });
                        imageButton.setOnLongClickListener(new View.OnLongClickListener(this, editText, strArr) { // from class: ru.maximoff.apktool.util.u.92.3

                            /* renamed from: a */
                            private final AnonymousClass92 f20621a;

                            /* renamed from: b */
                            private final EditText f20622b;

                            /* renamed from: c */
                            private final String[] f20623c;

                            {
                                this.f20621a = this;
                                this.f20622b = editText;
                                this.f20623c = strArr;
                            }

                            @Override // android.view.View.OnLongClickListener
                            public boolean onLongClick(View view2) {
                                this.f20622b.setText(this.f20623c[0]);
                                this.f20622b.setSelection(this.f20622b.getText().length());
                                this.f20622b.requestFocus();
                                return true;
                            }
                        });
                        TextView textView = (TextView) inflate2.findViewById(R.id.splitdexTextView1);
                        textView.setText(R.string.split_dex_cnm);
                        Spinner spinner2 = (Spinner) inflate2.findViewById(R.id.splitdexSpinner1);
                        spinner2.setAdapter((SpinnerAdapter) new ArrayAdapter(context, C0012R.layout.simple_spinner_dropdown_item, context.getResources().getStringArray(R.array.split_dex_items)));
                        spinner2.setSelection(0);
                        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(this, buttonArr, editText, strArr, imageButton, textView) { // from class: ru.maximoff.apktool.util.u.92.4

                            /* renamed from: a */
                            private final AnonymousClass92 f20624a;

                            /* renamed from: b */
                            private final Button[] f20625b;

                            /* renamed from: c */
                            private final EditText f20626c;

                            /* renamed from: d */
                            private final String[] f20627d;

                            /* renamed from: e */
                            private final ImageButton f20628e;

                            /* renamed from: f */
                            private final TextView f20629f;

                            {
                                this.f20624a = this;
                                this.f20625b = buttonArr;
                                this.f20626c = editText;
                                this.f20627d = strArr;
                                this.f20628e = imageButton;
                                this.f20629f = textView;
                            }

                            @Override // android.widget.AdapterView.OnItemSelectedListener
                            public void onNothingSelected(AdapterView<?> adapterView) {
                            }

                            @Override // android.widget.AdapterView.OnItemSelectedListener
                            public void onItemSelected(AdapterView<?> adapterView, View view2, int i3, long j) {
                                if (this.f20625b[0] != null) {
                                    this.f20625b[0].setEnabled(true);
                                }
                                this.f20626c.setText(this.f20627d[i3]);
                                if (i3 == 0) {
                                    this.f20628e.setVisibility(0);
                                    this.f20629f.setText(R.string.split_dex_cnm);
                                } else {
                                    this.f20628e.setVisibility(8);
                                    this.f20629f.setText(R.string.split_dex_cnd);
                                }
                                this.f20626c.setSelection(this.f20626c.getText().length());
                                this.f20626c.requestFocus();
                            }
                        });
                        editText.addTextChangedListener(new TextWatcher(this, buttonArr, spinner2) { // from class: ru.maximoff.apktool.util.u.92.5

                            /* renamed from: a */
                            private final AnonymousClass92 f20630a;

                            /* renamed from: b */
                            private final Button[] f20631b;

                            /* renamed from: c */
                            private final Spinner f20632c;

                            {
                                this.f20630a = this;
                                this.f20631b = buttonArr;
                                this.f20632c = spinner2;
                            }

                            @Override // android.text.TextWatcher
                            public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                            }

                            @Override // android.text.TextWatcher
                            public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                            }

                            @Override // android.text.TextWatcher
                            public void afterTextChanged(Editable editable) {
                                if (this.f20631b[0] != null && this.f20632c.getSelectedItemPosition() == 0) {
                                    try {
                                        this.f20631b[0].setEnabled(Integer.parseInt(editable.toString()) <= 65536);
                                    } catch (Exception e3) {
                                        this.f20631b[0].setEnabled(false);
                                    }
                                }
                            }
                        });
                        CheckBox checkBox2 = (CheckBox) inflate2.findViewById(R.id.splitdexCheckBox1);
                        ((TextView) inflate2.findViewById(R.id.splitdexTextView2)).setText(context.getString(R.string.dex_limit_info, new Integer(65536)));
                        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(context).m418a(R.string.split_dex).m435b(inflate2).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, context, this.f20611b, editText, spinner2, checkBox2, this.f20610a) { // from class: ru.maximoff.apktool.util.u.92.6

                            /* renamed from: a */
                            private final AnonymousClass92 f20633a;

                            /* renamed from: b */
                            private final Context f20634b;

                            /* renamed from: c */
                            private final InterfaceC2995n f20635c;

                            /* renamed from: d */
                            private final EditText f20636d;

                            /* renamed from: e */
                            private final Spinner f20637e;

                            /* renamed from: f */
                            private final CheckBox f20638f;

                            /* renamed from: g */
                            private final File f20639g;

                            {
                                this.f20633a = this;
                                this.f20634b = context;
                                this.f20635c = r3;
                                this.f20636d = editText;
                                this.f20637e = spinner2;
                                this.f20638f = checkBox2;
                                this.f20639g = r7;
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                AsyncTaskC2945p asyncTaskC2945p = new AsyncTaskC2945p(this.f20634b, this.f20635c, false);
                                try {
                                    int parseInt = Integer.parseInt(this.f20636d.getText().toString());
                                    if (this.f20637e.getSelectedItemPosition() == 0) {
                                        asyncTaskC2945p.m17536c(parseInt);
                                        C3102bd.m18937b(this.f20634b, "dex_split_mc", String.valueOf(parseInt));
                                    } else {
                                        asyncTaskC2945p.m17535b(parseInt);
                                        C3102bd.m18937b(this.f20634b, "dex_split_dc", String.valueOf(parseInt));
                                    }
                                    asyncTaskC2945p.m17537g(this.f20638f.isChecked());
                                    asyncTaskC2945p.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20639g);
                                } catch (Exception e3) {
                                    C3112bn.m18999a(this.f20634b, R.string.error_try_again);
                                }
                            }
                        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
                        m438b.getWindow().setSoftInputMode(4);
                        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, buttonArr, m438b, editText) { // from class: ru.maximoff.apktool.util.u.92.7

                            /* renamed from: a */
                            private final AnonymousClass92 f20640a;

                            /* renamed from: b */
                            private final Button[] f20641b;

                            /* renamed from: c */
                            private final DialogInterfaceC0070b f20642c;

                            /* renamed from: d */
                            private final EditText f20643d;

                            {
                                this.f20640a = this;
                                this.f20641b = buttonArr;
                                this.f20642c = m438b;
                                this.f20643d = editText;
                            }

                            @Override // android.content.DialogInterface.OnShowListener
                            public void onShow(DialogInterface dialogInterface) {
                                this.f20641b[0] = this.f20642c.m414a(-1);
                                this.f20643d.setSelection(this.f20643d.getText().length());
                                this.f20643d.requestFocus();
                            }
                        });
                        m438b.show();
                        break;
                    case R.id.dex2jar /* 2131690208 */:
                        try {
                            new AsyncTaskC2942m(context, this.f20611b, false).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20610a);
                            break;
                        } catch (Exception e3) {
                            C3112bn.m18999a(context, R.string.error_try_again);
                            return;
                        }
                }
            }
        });
    }

    /* renamed from: a */
    public static void m19577a(Context context, File file) {
        try {
            Intent intent = new Intent(context, Class.forName("ru.maximoff.apktool.FontViewer"));
            intent.putExtra("data", file.getAbsolutePath());
            context.startActivity(intent);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    /* renamed from: e */
    private static void m19659e(File file, View view, InterfaceC2995n interfaceC2995n) {
        File file2;
        if (C3102bd.f18339v != null) {
            file2 = new File(C3102bd.f18339v, "dictionary");
            if (file.getParent().equals(file2.getAbsolutePath())) {
                interfaceC2995n.mo17940b().m17821a(file);
                interfaceC2995n.mo17929a();
                return;
            }
        } else {
            file2 = (File) null;
        }
        C3089au.m18715a(view, R.menu.dict, new C3089au.a(file2, file, interfaceC2995n) { // from class: ru.maximoff.apktool.util.u.93

            /* renamed from: a */
            private final File f20644a;

            /* renamed from: b */
            private final File f20645b;

            /* renamed from: c */
            private final InterfaceC2995n f20646c;

            {
                this.f20644a = file2;
                this.f20645b = file;
                this.f20646c = interfaceC2995n;
            }

            @Override // ru.maximoff.apktool.util.C3089au.a
            /* renamed from: a */
            public void mo17670a(Context context, int i) {
                switch (i) {
                    case R.id.add_dict /* 2131690209 */:
                        if (C3102bd.f18339v == null || this.f20644a == null) {
                            C3112bn.m19023b(context, context.getString(R.string.output_directory_not_set));
                            break;
                        } else {
                            if (!this.f20644a.exists() || !this.f20644a.isDirectory()) {
                                this.f20644a.mkdir();
                            }
                            C3262u.m19612a(this.f20645b, new File(this.f20644a, C3262u.m19568a(context, this.f20644a.getAbsolutePath(), this.f20645b.getName().substring(0, this.f20645b.getName().lastIndexOf(46)), ".amd", 0, true)));
                            this.f20646c.mo17929a();
                            C3112bn.m19023b(context, context.getString(R.string.success));
                            break;
                        }
                        break;
                    case R.id.open_in_editor /* 2131690210 */:
                        this.f20646c.mo17940b().m17821a(this.f20645b);
                        this.f20646c.mo17929a();
                        break;
                }
            }
        });
    }

    /* renamed from: f */
    private static void m19661f(File file, View view, InterfaceC2995n interfaceC2995n) {
        C3089au.m18715a(view, R.menu.shell, new C3089au.a(interfaceC2995n, file) { // from class: ru.maximoff.apktool.util.u.94

            /* renamed from: a */
            private final InterfaceC2995n f20647a;

            /* renamed from: b */
            private final File f20648b;

            {
                this.f20647a = interfaceC2995n;
                this.f20648b = file;
            }

            @Override // ru.maximoff.apktool.util.C3089au.a
            /* renamed from: a */
            public void mo17670a(Context context, int i) {
                switch (i) {
                    case R.id.open_in_editor /* 2131690210 */:
                        this.f20647a.mo17940b().m17821a(this.f20648b);
                        this.f20647a.mo17929a();
                        break;
                    case R.id.shell_run /* 2131690308 */:
                    case R.id.shell_run_root /* 2131690309 */:
                        try {
                            new AsyncTaskC2914ap(context, this.f20647a, i == R.id.shell_run_root).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20648b);
                            break;
                        } catch (Exception e2) {
                            C3112bn.m18999a(context, R.string.error_try_again);
                            return;
                        }
                }
            }
        });
    }

    /* renamed from: a */
    public static void m19586a(Context context, File file, InterfaceC2995n interfaceC2995n, int i, boolean z) {
        m19584a(context, file, file.getName(), interfaceC2995n, i, z, false, false);
    }

    /* renamed from: a */
    public static void m19587a(Context context, File file, InterfaceC2995n interfaceC2995n, int i, boolean z, boolean z2) {
        m19584a(context, file, file.getName(), interfaceC2995n, i, z, z2, false);
    }

    /* renamed from: a */
    public static void m19584a(Context context, File file, String str, InterfaceC2995n interfaceC2995n, int i, boolean z, boolean z2, boolean z3) {
        File file2;
        File file3;
        boolean m19664g = m19664g(context, file);
        int[] iArr = {1, 3};
        switch (i) {
            case 0:
                boolean m18925a = C3102bd.m18925a(context, "all_to_out_dir", false);
                if (!m19664g || m18925a || z3) {
                    String str2 = C3102bd.f18339v;
                    if (str2 == null) {
                        C3112bn.m19023b(context, context.getString(R.string.output_directory_not_set));
                        break;
                    } else {
                        file2 = new File(new StringBuffer().append(new StringBuffer().append(str2).append("/AM_AntiSplit_").toString()).append(System.currentTimeMillis()).toString());
                    }
                } else {
                    file2 = new File(new StringBuffer().append(new StringBuffer().append(file.getParent()).append("/AM_AntiSplit_").toString()).append(System.currentTimeMillis()).toString());
                }
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                try {
                    m19580a(context, file, file2, str, (z || z2) ? R.string.decompile : R.string.mantisplit, new Runnable(z3, file, file2, context, interfaceC2995n, z, z2, iArr) { // from class: ru.maximoff.apktool.util.u.96

                        /* renamed from: a */
                        private final boolean f20669a;

                        /* renamed from: b */
                        private final File f20670b;

                        /* renamed from: c */
                        private final File f20671c;

                        /* renamed from: d */
                        private final Context f20672d;

                        /* renamed from: e */
                        private final InterfaceC2995n f20673e;

                        /* renamed from: f */
                        private final boolean f20674f;

                        /* renamed from: g */
                        private final boolean f20675g;

                        /* renamed from: h */
                        private final int[] f20676h;

                        {
                            this.f20669a = z3;
                            this.f20670b = file;
                            this.f20671c = file2;
                            this.f20672d = context;
                            this.f20673e = interfaceC2995n;
                            this.f20674f = z;
                            this.f20675g = z2;
                            this.f20676h = iArr;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (this.f20669a) {
                                this.f20670b.delete();
                            }
                            File[] listFiles = this.f20671c.listFiles(new FilenameFilter(this) { // from class: ru.maximoff.apktool.util.u.96.1

                                /* renamed from: a */
                                private final AnonymousClass96 f20677a;

                                {
                                    this.f20677a = this;
                                }

                                @Override // java.io.FilenameFilter
                                public boolean accept(File file4, String str3) {
                                    return str3.endsWith(".apk");
                                }
                            });
                            if (listFiles == null || listFiles.length == 0) {
                                C3112bn.m19023b(this.f20672d, this.f20672d.getString(R.string.error));
                                C0542g.m3987a(this.f20671c);
                                this.f20673e.mo17929a();
                                return;
                            }
                            Runnable runnable = new Runnable(this, this.f20672d, this.f20673e, this.f20674f, this.f20675g, this.f20676h, listFiles) { // from class: ru.maximoff.apktool.util.u.96.2

                                /* renamed from: a */
                                private final AnonymousClass96 f20678a;

                                /* renamed from: b */
                                private final Context f20679b;

                                /* renamed from: c */
                                private final InterfaceC2995n f20680c;

                                /* renamed from: d */
                                private final boolean f20681d;

                                /* renamed from: e */
                                private final boolean f20682e;

                                /* renamed from: f */
                                private final int[] f20683f;

                                /* renamed from: g */
                                private final File[] f20684g;

                                {
                                    this.f20678a = this;
                                    this.f20679b = r2;
                                    this.f20680c = r3;
                                    this.f20681d = r4;
                                    this.f20682e = r5;
                                    this.f20683f = r6;
                                    this.f20684g = listFiles;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    AsyncTaskC2940k asyncTaskC2940k = new AsyncTaskC2940k(this.f20679b, this.f20680c, (String) null);
                                    AbstractAsyncTaskC2898a.m17030c(true);
                                    asyncTaskC2940k.m17512k(this.f20681d || this.f20682e);
                                    asyncTaskC2940k.m17513l(this.f20682e);
                                    asyncTaskC2940k.m17507b(this.f20683f[0]);
                                    try {
                                        asyncTaskC2940k.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20684g);
                                    } catch (Exception e2) {
                                        C3112bn.m18999a(this.f20679b, R.string.error_try_again);
                                    }
                                }
                            };
                            if (this.f20674f || this.f20675g) {
                                runnable.run();
                            } else {
                                C3262u.m19601a(this.f20672d, this.f20676h, runnable, new Runnable(this, this.f20671c, this.f20673e) { // from class: ru.maximoff.apktool.util.u.96.3

                                    /* renamed from: a */
                                    private final AnonymousClass96 f20685a;

                                    /* renamed from: b */
                                    private final File f20686b;

                                    /* renamed from: c */
                                    private final InterfaceC2995n f20687c;

                                    {
                                        this.f20685a = this;
                                        this.f20686b = r2;
                                        this.f20687c = r3;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (this.f20686b != null && this.f20686b.exists()) {
                                            C0542g.m3987a(this.f20686b);
                                        }
                                        if (this.f20687c != null) {
                                            this.f20687c.mo17929a();
                                        }
                                    }
                                }, true, R.string.mantisplit);
                            }
                        }
                    });
                    break;
                } catch (Exception e2) {
                    C3112bn.m19023b(context, context.getString(R.string.failed_open, file.getName()));
                    return;
                }
            case 1:
            case 2:
                if (Build.VERSION.SDK_INT >= 26 && !context.getPackageManager().canRequestPackageInstalls()) {
                    try {
                        Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES);
                        intent.setData(Uri.parse(String.format("package:%s", context.getPackageName())));
                        intent.addFlags(268435456);
                        context.startActivity(intent);
                        break;
                    } catch (Exception e3) {
                    }
                }
                if (!m19664g) {
                    String str3 = C3102bd.f18339v;
                    if (str3 == null) {
                        C3112bn.m19023b(context, context.getString(R.string.output_directory_not_set));
                        break;
                    } else {
                        file3 = new File(new StringBuffer().append(new StringBuffer().append(str3).append("/.AM_TempSplit_").toString()).append(System.currentTimeMillis()).toString());
                    }
                } else {
                    file3 = new File(new StringBuffer().append(new StringBuffer().append(file.getParent()).append("/.AM_TempSplit_").toString()).append(System.currentTimeMillis()).toString());
                }
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                try {
                    m19580a(context, file, file3, str, i == 1 ? R.string.install : R.string.install_sign, new Runnable(file3, context, interfaceC2995n, iArr, i) { // from class: ru.maximoff.apktool.util.u.95

                        /* renamed from: a */
                        private final File f20649a;

                        /* renamed from: b */
                        private final Context f20650b;

                        /* renamed from: c */
                        private final InterfaceC2995n f20651c;

                        /* renamed from: d */
                        private final int[] f20652d;

                        /* renamed from: e */
                        private final int f20653e;

                        {
                            this.f20649a = file3;
                            this.f20650b = context;
                            this.f20651c = interfaceC2995n;
                            this.f20652d = iArr;
                            this.f20653e = i;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            File[] listFiles = this.f20649a.listFiles(new FilenameFilter(this) { // from class: ru.maximoff.apktool.util.u.95.1

                                /* renamed from: a */
                                private final AnonymousClass95 f20654a;

                                {
                                    this.f20654a = this;
                                }

                                @Override // java.io.FilenameFilter
                                public boolean accept(File file4, String str4) {
                                    return str4.endsWith(".apk");
                                }
                            });
                            if (listFiles == null || listFiles.length == 0) {
                                C3112bn.m19023b(this.f20650b, this.f20650b.getString(R.string.error));
                                C0542g.m3987a(this.f20649a);
                                this.f20651c.mo17929a();
                                return;
                            }
                            File file4 = new File(this.f20649a, "/Android");
                            if (file4.exists() && file4.isDirectory()) {
                                try {
                                    C0542g.m3991a(file4, new File(Environment.getExternalStorageDirectory(), "/Android"));
                                } catch (C0522a e4) {
                                }
                            }
                            Runnable runnable = new Runnable(this, this.f20650b, this.f20652d, this.f20651c, this.f20653e, listFiles) { // from class: ru.maximoff.apktool.util.u.95.2

                                /* renamed from: a */
                                private final AnonymousClass95 f20655a;

                                /* renamed from: b */
                                private final Context f20656b;

                                /* renamed from: c */
                                private final int[] f20657c;

                                /* renamed from: d */
                                private final InterfaceC2995n f20658d;

                                /* renamed from: e */
                                private final int f20659e;

                                /* renamed from: f */
                                private final File[] f20660f;

                                {
                                    this.f20655a = this;
                                    this.f20656b = r2;
                                    this.f20657c = r3;
                                    this.f20658d = r4;
                                    this.f20659e = r5;
                                    this.f20660f = listFiles;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    C2917as.m17314a(this.f20656b, this.f20657c[0], new C2917as.a(this, this.f20656b, this.f20658d, this.f20659e, this.f20660f) { // from class: ru.maximoff.apktool.util.u.95.2.1

                                        /* renamed from: a */
                                        private final AnonymousClass2 f20661a;

                                        /* renamed from: b */
                                        private final Context f20662b;

                                        /* renamed from: c */
                                        private final InterfaceC2995n f20663c;

                                        /* renamed from: d */
                                        private final int f20664d;

                                        /* renamed from: e */
                                        private final File[] f20665e;

                                        {
                                            this.f20661a = this;
                                            this.f20662b = r2;
                                            this.f20663c = r3;
                                            this.f20664d = r4;
                                            this.f20665e = r5;
                                        }

                                        @Override // ru.maximoff.apktool.p300e.C2917as.a
                                        /* renamed from: a */
                                        public void mo16440a(C2917as c2917as, boolean z4) {
                                            C3262u.m19595a(this.f20662b, this.f20663c, c2917as, this.f20664d == 2, this.f20665e);
                                        }
                                    });
                                }
                            };
                            if (C3102bd.m18925a(this.f20650b, "custom_signature_file", false) && this.f20653e == 2) {
                                C3262u.m19600a(this.f20650b, this.f20652d, runnable, new Runnable(this, this.f20649a, this.f20651c) { // from class: ru.maximoff.apktool.util.u.95.3

                                    /* renamed from: a */
                                    private final AnonymousClass95 f20666a;

                                    /* renamed from: b */
                                    private final File f20667b;

                                    /* renamed from: c */
                                    private final InterfaceC2995n f20668c;

                                    {
                                        this.f20666a = this;
                                        this.f20667b = r2;
                                        this.f20668c = r3;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (this.f20667b != null && this.f20667b.exists()) {
                                            C0542g.m3987a(this.f20667b);
                                        }
                                        if (this.f20668c != null) {
                                            this.f20668c.mo17929a();
                                        }
                                    }
                                }, R.string.install_sign);
                            } else {
                                new Handler(Looper.getMainLooper()).postDelayed(runnable, 100L);
                            }
                        }
                    });
                    break;
                } catch (Exception e4) {
                    C3112bn.m19023b(context, context.getString(R.string.failed_open, file.getName()));
                    return;
                }
                break;
        }
    }

    /* renamed from: a */
    private static void m19580a(Context context, File file, File file2, String str, int i, Runnable runnable) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Enumeration<C2602u> m16163b = new C2604w(file).m16163b();
        while (m16163b.hasMoreElements()) {
            C2602u nextElement = m16163b.nextElement();
            if (nextElement.getName().toLowerCase().endsWith(".apk") && nextElement.getName().indexOf(47) == -1) {
                arrayList.add(nextElement.getName());
            } else if (file.getName().toLowerCase().endsWith(".xapk") && nextElement.getName().startsWith("Android/obb/")) {
                arrayList2.add(nextElement.getName());
            }
        }
        if (arrayList.isEmpty()) {
            C3112bn.m19023b(context, context.getString(R.string.errorf, new StringBuffer().append("apk files not found in ").append(file.getAbsolutePath()).toString()));
            if (file2.exists()) {
                file2.delete();
                return;
            }
            return;
        }
        Collections.sort(arrayList);
        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(context);
        aVar.m432a((String[]) arrayList.toArray(new String[arrayList.size()]), (boolean[]) null, (DialogInterface.OnMultiChoiceClickListener) null);
        aVar.m427a(str);
        aVar.m434b(R.string.cancel, new DialogInterface.OnClickListener(file2) { // from class: ru.maximoff.apktool.util.u.97

            /* renamed from: a */
            private final File f20688a;

            {
                this.f20688a = file2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (this.f20688a.exists()) {
                    this.f20688a.delete();
                }
            }
        });
        aVar.m421a(new DialogInterface.OnCancelListener(file2) { // from class: ru.maximoff.apktool.util.u.98

            /* renamed from: a */
            private final File f20689a;

            {
                this.f20689a = file2;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (this.f20689a.exists()) {
                    this.f20689a.delete();
                }
            }
        });
        aVar.m420a(i, new DialogInterface.OnClickListener(file2, arrayList2, context, runnable, file) { // from class: ru.maximoff.apktool.util.u.99

            /* renamed from: a */
            private final File f20690a;

            /* renamed from: b */
            private final List f20691b;

            /* renamed from: c */
            private final Context f20692c;

            /* renamed from: d */
            private final Runnable f20693d;

            /* renamed from: e */
            private final File f20694e;

            {
                this.f20690a = file2;
                this.f20691b = arrayList2;
                this.f20692c = context;
                this.f20693d = runnable;
                this.f20694e = file;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                int i3 = 0;
                ArrayList arrayList3 = new ArrayList();
                ListView m415a = ((DialogInterfaceC0070b) dialogInterface).m415a();
                while (true) {
                    int i4 = i3;
                    if (i4 >= m415a.getCount()) {
                        break;
                    }
                    if (m415a.isItemChecked(i4)) {
                        arrayList3.add((String) m415a.getItemAtPosition(i4));
                    }
                    i3 = i4 + 1;
                }
                if (!arrayList3.isEmpty()) {
                    if (!this.f20690a.exists()) {
                        this.f20690a.mkdirs();
                    }
                    if (!this.f20691b.isEmpty()) {
                        arrayList3.addAll(this.f20691b);
                    }
                    try {
                        AsyncTaskC2924az asyncTaskC2924az = new AsyncTaskC2924az(this.f20692c, this.f20690a, arrayList3, this.f20693d);
                        asyncTaskC2924az.m17380g(true);
                        asyncTaskC2924az.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20694e);
                    } catch (Exception e2) {
                        C3112bn.m18999a(this.f20692c, R.string.error_try_again);
                    }
                }
            }
        });
        aVar.m440c(R.string.mselect_inv, (DialogInterface.OnClickListener) null);
        DialogInterfaceC0070b m438b = aVar.m438b();
        m438b.setOnShowListener(new DialogInterface.OnShowListener(m438b, context) { // from class: ru.maximoff.apktool.util.u.100

            /* renamed from: a */
            private final DialogInterfaceC0070b f19893a;

            /* renamed from: b */
            private final Context f19894b;

            {
                this.f19893a = m438b;
                this.f19894b = context;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                boolean z;
                Button m414a = this.f19893a.m414a(-1);
                ListView m415a = this.f19893a.m415a();
                String upperCase = C3080al.m18600g(this.f19894b).toUpperCase();
                String upperCase2 = C3102bd.f18268D.replace("-", "_").toUpperCase();
                String upperCase3 = C3080al.m18602h(this.f19894b).toUpperCase();
                int i2 = 0;
                boolean z2 = false;
                boolean z3 = false;
                while (i2 < m415a.getCount()) {
                    String upperCase4 = m415a.getItemAtPosition(i2).toString().toUpperCase();
                    if (upperCase4.equals("BASE.APK")) {
                        m415a.setItemChecked(i2, true);
                        z = true;
                        z3 = true;
                    } else if (upperCase4.endsWith(new StringBuffer().append(new StringBuffer().append(".").append(upperCase).toString()).append(".APK").toString()) || upperCase4.endsWith(new StringBuffer().append(new StringBuffer().append(".").append(upperCase2).toString()).append(".APK").toString()) || upperCase4.endsWith(new StringBuffer().append(new StringBuffer().append(".").append(upperCase3).toString()).append(".APK").toString())) {
                        m415a.setItemChecked(i2, true);
                        z = z2;
                        z3 = true;
                    } else {
                        z = z2;
                    }
                    i2++;
                    z2 = z;
                }
                m414a.setEnabled(z3);
                m415a.setOnItemClickListener(new AdapterView.OnItemClickListener(this, m415a, m414a) { // from class: ru.maximoff.apktool.util.u.100.1

                    /* renamed from: a */
                    private final AnonymousClass100 f19895a;

                    /* renamed from: b */
                    private final ListView f19896b;

                    /* renamed from: c */
                    private final Button f19897c;

                    {
                        this.f19895a = this;
                        this.f19896b = m415a;
                        this.f19897c = m414a;
                    }

                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                        for (int i4 = 0; i4 < this.f19896b.getCount(); i4++) {
                            if (this.f19896b.isItemChecked(i4)) {
                                this.f19897c.setEnabled(true);
                                return;
                            }
                        }
                        this.f19897c.setEnabled(false);
                    }
                });
                Button m414a2 = this.f19893a.m414a(-3);
                m414a2.setOnClickListener(new View.OnClickListener(this, m415a, m414a) { // from class: ru.maximoff.apktool.util.u.100.2

                    /* renamed from: a */
                    private final AnonymousClass100 f19898a;

                    /* renamed from: b */
                    private final ListView f19899b;

                    /* renamed from: c */
                    private final Button f19900c;

                    {
                        this.f19898a = this;
                        this.f19899b = m415a;
                        this.f19900c = m414a;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        boolean z4 = false;
                        for (int i3 = 0; i3 < this.f19899b.getCount(); i3++) {
                            boolean isItemChecked = this.f19899b.isItemChecked(i3);
                            this.f19899b.setItemChecked(i3, !isItemChecked);
                            if (!isItemChecked) {
                                z4 = true;
                            }
                        }
                        this.f19900c.setEnabled(z4);
                    }
                });
                m414a2.setOnLongClickListener(new View.OnLongClickListener(this, m415a, m414a) { // from class: ru.maximoff.apktool.util.u.100.3

                    /* renamed from: a */
                    private final AnonymousClass100 f19901a;

                    /* renamed from: b */
                    private final ListView f19902b;

                    /* renamed from: c */
                    private final Button f19903c;

                    {
                        this.f19901a = this;
                        this.f19902b = m415a;
                        this.f19903c = m414a;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        for (int i3 = 0; i3 < this.f19902b.getCount(); i3++) {
                            this.f19902b.setItemChecked(i3, true);
                        }
                        this.f19903c.setEnabled(true);
                        return true;
                    }
                });
                if (z2) {
                    return;
                }
                C3112bn.m19022b(this.f19894b, R.string.base_not_def);
            }
        });
        m438b.show();
    }

    /* renamed from: a */
    public static void m19590a(Context context, File file, boolean z) {
        m19591a(context, file, false, z);
    }

    /* renamed from: a */
    public static void m19591a(Context context, File file, boolean z, boolean z2) {
        if (Build.VERSION.SDK_INT >= 26 && !context.getPackageManager().canRequestPackageInstalls()) {
            try {
                Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES);
                intent.setData(Uri.parse(String.format("package:%s", context.getPackageName())));
                intent.addFlags(268435456);
                context.startActivity(intent);
                return;
            } catch (Exception e2) {
            }
        }
        if (C3102bd.m18925a(context, "check_install", true)) {
            try {
                new AsyncTaskC2905ag(context, z, z2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, file);
                return;
            } catch (Exception e3) {
                C3112bn.m18999a(context, R.string.error_try_again);
                return;
            }
        }
        m19626b(context, file);
    }

    /* renamed from: b */
    public static void m19626b(Context context, File file) {
        Uri fromFile;
        if (Build.VERSION.SDK_INT >= 24) {
            Uri.Builder builder = new Uri.Builder();
            builder.authority(new StringBuffer().append(context.getPackageName()).append(".fileprovider").toString());
            builder.scheme(ContentResolver.SCHEME_CONTENT);
            builder.path(Base64.encodeToString(file.getAbsolutePath().getBytes(), 2));
            fromFile = builder.build();
        } else {
            fromFile = Uri.fromFile(file);
        }
        Intent intent = new Intent(Intent.ACTION_INSTALL_PACKAGE);
        intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
        intent.addFlags(268435456);
        intent.addFlags(1);
        context.startActivity(intent);
    }

    /* renamed from: c */
    public static void m19643c(Context context, File file) {
        AsyncTaskC2932c asyncTaskC2932c = new AsyncTaskC2932c(context);
        if (!C3102bd.m18925a(context, "installLocation", false)) {
            try {
                asyncTaskC2932c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, file);
            } catch (Exception e2) {
                C3112bn.m18999a(context, R.string.error_try_again);
            }
        } else {
            String[] stringArray = context.getResources().getStringArray(R.array.installLocation);
            String[] strArr = (String[]) Arrays.copyOfRange(stringArray, 1, stringArray.length);
            int[] iArr = {C3102bd.m18905a(context, "inlocation_idx", 1)};
            new DialogInterfaceC0070b.a(context).m418a(R.string.mapp_inLocation).m430a(strArr, iArr[0], new DialogInterface.OnClickListener(iArr, context) { // from class: ru.maximoff.apktool.util.u.101

                /* renamed from: a */
                private final int[] f19904a;

                /* renamed from: b */
                private final Context f19905b;

                {
                    this.f19904a = iArr;
                    this.f19905b = context;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f19904a[0] = i;
                    if (i == 2) {
                        C3080al.m18614p(this.f19905b);
                    }
                }
            }).m420a(R.string.install, new DialogInterface.OnClickListener(context, iArr, asyncTaskC2932c, file) { // from class: ru.maximoff.apktool.util.u.102

                /* renamed from: a */
                private final Context f19906a;

                /* renamed from: b */
                private final int[] f19907b;

                /* renamed from: c */
                private final AsyncTaskC2932c f19908c;

                /* renamed from: d */
                private final File f19909d;

                {
                    this.f19906a = context;
                    this.f19907b = iArr;
                    this.f19908c = asyncTaskC2932c;
                    this.f19909d = file;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    C3102bd.m18935b(this.f19906a, "inlocation_idx", this.f19907b[0]);
                    try {
                        this.f19908c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f19909d);
                    } catch (Exception e3) {
                        C3112bn.m18999a(this.f19906a, R.string.error_try_again);
                    }
                    dialogInterface.cancel();
                }
            }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
        }
    }

    /* renamed from: a */
    public static void m19595a(Context context, InterfaceC2995n interfaceC2995n, C2917as c2917as, boolean z, File[] fileArr) {
        AsyncTaskC2913ao asyncTaskC2913ao = new AsyncTaskC2913ao(context, interfaceC2995n, c2917as, z, false, false, false);
        if (!C3102bd.m18925a(context, "installLocation", false)) {
            try {
                asyncTaskC2913ao.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, fileArr);
            } catch (Exception e2) {
                C3112bn.m18999a(context, R.string.error_try_again);
            }
        } else {
            String[] stringArray = context.getResources().getStringArray(R.array.installLocation);
            String[] strArr = (String[]) Arrays.copyOfRange(stringArray, 1, stringArray.length);
            int[] iArr = {C3102bd.m18905a(context, "inlocation_idx", 1)};
            new DialogInterfaceC0070b.a(context).m418a(R.string.mapp_inLocation).m430a(strArr, iArr[0], new DialogInterface.OnClickListener(iArr, context) { // from class: ru.maximoff.apktool.util.u.103

                /* renamed from: a */
                private final int[] f19910a;

                /* renamed from: b */
                private final Context f19911b;

                {
                    this.f19910a = iArr;
                    this.f19911b = context;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f19910a[0] = i;
                    if (i == 2) {
                        C3080al.m18614p(this.f19911b);
                    }
                }
            }).m420a(R.string.install, new DialogInterface.OnClickListener(context, iArr, asyncTaskC2913ao, fileArr) { // from class: ru.maximoff.apktool.util.u.104

                /* renamed from: a */
                private final Context f19912a;

                /* renamed from: b */
                private final int[] f19913b;

                /* renamed from: c */
                private final AsyncTaskC2913ao f19914c;

                /* renamed from: d */
                private final File[] f19915d;

                {
                    this.f19912a = context;
                    this.f19913b = iArr;
                    this.f19914c = asyncTaskC2913ao;
                    this.f19915d = fileArr;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    C3102bd.m18935b(this.f19912a, "inlocation_idx", this.f19913b[0]);
                    try {
                        this.f19914c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f19915d);
                    } catch (Exception e3) {
                        C3112bn.m18999a(this.f19912a, R.string.error_try_again);
                    }
                    dialogInterface.cancel();
                }
            }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
        }
    }

    /* renamed from: d */
    public static void m19650d(Context context, File file) {
        try {
            Uri m19657e = m19657e(context, file);
            String m19571a = m19571a(m19657e.toString());
            Intent intent = new Intent("android.intent.action.VIEW");
            if (C3112bn.m19040o(m19571a) || m19571a.equals("application/octet-stream")) {
                m19571a = "*/*";
            }
            intent.setDataAndType(m19657e, m19571a);
            intent.addFlags(268435456);
            intent.addFlags(3);
            context.startActivity(intent);
        } catch (Exception e2) {
            C3112bn.m19023b(context, context.getString(R.string.errorf, e2.getMessage()));
        }
    }

    /* renamed from: a */
    public static void m19604a(Context context, File[] fileArr) {
        try {
            Intent intent = new Intent();
            if (fileArr.length > 1) {
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                for (File file : fileArr) {
                    if (!file.isDirectory()) {
                        arrayList.add(m19657e(context, file));
                    }
                }
                if (arrayList.isEmpty()) {
                    C3112bn.m19023b(context, context.getString(R.string.errorf, "files list is empty"));
                    return;
                } else {
                    intent.setType("*/*");
                    intent.setAction(Intent.ACTION_SEND_MULTIPLE);
                    intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, arrayList);
                }
            } else {
                Uri m19657e = m19657e(context, fileArr[0]);
                String m19571a = m19571a(m19657e.toString());
                if (C3112bn.m19040o(m19571a) || m19571a.equals("application/octet-stream") || !C3102bd.m18925a(context, "share_type", true)) {
                    m19571a = "*/*";
                }
                intent.setType(m19571a);
                intent.putExtra(Intent.EXTRA_STREAM, m19657e);
                intent.setAction(Intent.ACTION_SEND);
            }
            intent.addFlags(268435456);
            intent.addFlags(3);
            context.startActivity(Intent.createChooser(intent, context.getString(R.string.sharing_file)));
        } catch (Exception e2) {
            C3112bn.m19023b(context, context.getString(R.string.errorf, e2.getMessage()));
        }
    }

    /* renamed from: a */
    public static String m19572a(String str, String str2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[C3249i.m19500a()];
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return C3112bn.m18997a(messageDigest.digest()).toLowerCase();
                }
            }
        } catch (Exception e2) {
            return (String) null;
        }
    }

    /* renamed from: a */
    public static Map<String, String> m19573a(Context context, String str) {
        String lowerCase;
        String lowerCase2;
        boolean m18925a = C3102bd.m18925a(context, "checksum_upper", false);
        boolean m18925a2 = C3102bd.m18925a(context, "checksum_separate", false);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String[] strArr = {KeyProperties.DIGEST_MD5, KeyProperties.DIGEST_SHA1, KeyProperties.DIGEST_SHA224, KeyProperties.DIGEST_SHA256, KeyProperties.DIGEST_SHA384, KeyProperties.DIGEST_SHA512};
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[C3249i.m19500a()];
            CRC32 crc32 = new CRC32();
            MessageDigest[] messageDigestArr = new MessageDigest[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                try {
                    messageDigestArr[i] = MessageDigest.getInstance(strArr[i]);
                } catch (NoSuchAlgorithmException e2) {
                    messageDigestArr[i] = (MessageDigest) null;
                }
            }
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                crc32.update(bArr, 0, read);
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    if (messageDigestArr[i2] != null) {
                        messageDigestArr[i2].update(bArr, 0, read);
                    }
                }
            }
            linkedHashMap.put(new StringBuffer().append("Long_").append("CRC32").toString(), String.valueOf(crc32.getValue()));
            String hexString = Long.toHexString(crc32.getValue());
            if (m18925a) {
                lowerCase = hexString.toUpperCase();
            } else {
                lowerCase = hexString.toLowerCase();
            }
            linkedHashMap.put("CRC32", lowerCase);
            for (int i3 = 0; i3 < strArr.length; i3++) {
                if (messageDigestArr[i3] != null) {
                    String m18997a = C3112bn.m18997a(messageDigestArr[i3].digest());
                    if (m18925a2) {
                        m18997a = m18997a.replaceAll("..(?!$)", "$0:");
                    }
                    if (m18925a) {
                        lowerCase2 = m18997a.toUpperCase();
                    } else {
                        lowerCase2 = m18997a.toLowerCase();
                    }
                    linkedHashMap.put(strArr[i3], lowerCase2);
                }
            }
            fileInputStream.close();
        } catch (Exception e3) {
        }
        return linkedHashMap;
    }

    /* renamed from: e */
    public static Uri m19657e(Context context, File file) {
        if (Build.VERSION.SDK_INT >= 24) {
            return FileProvider.m1838a(context, new StringBuffer().append(context.getPackageName()).append(".outprovider").toString(), file);
        }
        return Uri.fromFile(file);
    }

    /* renamed from: a */
    public static String m19565a(Context context, Uri uri) {
        String str;
        String str2 = (String) null;
        if (uri.getScheme().equals(ContentResolver.SCHEME_CONTENT)) {
            Cursor cursor = (Cursor) null;
            try {
                cursor = context.getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
                if (cursor != null && cursor.moveToFirst()) {
                    str2 = cursor.getString(cursor.getColumnIndex("_display_name"));
                }
                str = str2;
            } catch (Exception e2) {
                str = str2;
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
            if (cursor != null) {
                cursor.close();
            }
        } else {
            str = str2;
        }
        if (str == null) {
            String path = uri.getPath();
            int lastIndexOf = path.lastIndexOf(47);
            if (lastIndexOf != -1 && lastIndexOf < path.length() - 1) {
                return path.substring(lastIndexOf + 1);
            }
            return path;
        }
        return str;
    }

    /* renamed from: a */
    public static String m19571a(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        String str2 = (String) null;
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return str2;
    }

    /* renamed from: f */
    public static boolean m19662f(Context context, File file) {
        try {
            String absolutePath = context.getFilesDir().getAbsolutePath();
            String absolutePath2 = context.getExternalFilesDir((String) null).getAbsolutePath();
            String absolutePath3 = file.getAbsolutePath();
            if (!absolutePath3.startsWith(absolutePath)) {
                if (!absolutePath3.startsWith(absolutePath2)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: l */
    public static boolean m19674l(File file) {
        String parent = file.getParent();
        return file.isDirectory() && (file.getAbsolutePath().toLowerCase().startsWith(C3249i.f19549i.toLowerCase()) || (parent != null && (parent.toLowerCase().endsWith(C3249i.f19551k.toLowerCase()) || parent.toLowerCase().endsWith(C3249i.f19552l.toLowerCase()) || parent.toLowerCase().endsWith(C3249i.f19553m.toLowerCase()) || parent.toLowerCase().endsWith(C3249i.f19554n.toLowerCase()))));
    }

    /* renamed from: g */
    public static boolean m19664g(Context context, File file) {
        boolean canWrite;
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            canWrite = file.canWrite();
        } else {
            canWrite = file.getParentFile().canWrite();
        }
        return (m19662f(context, file) || m19666h(context, file)) && canWrite;
    }

    /* renamed from: h */
    public static boolean m19666h(Context context, File file) {
        if (file == null) {
            return false;
        }
        return m19618a(m19640b(context), file);
    }

    /* renamed from: a */
    public static boolean m19618a(String[] strArr, File file) {
        if (file == null) {
            return false;
        }
        if (strArr == null) {
            strArr = new String[]{Environment.getExternalStorageDirectory().getAbsolutePath()};
        }
        for (String str : strArr) {
            if (file.getAbsolutePath().startsWith(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static String[] m19640b(Context context) {
        StorageManager storageManager = (StorageManager) context.getSystemService(Context.STORAGE_SERVICE);
        try {
            Class<?> cls = Class.forName("android.os.storage.StorageVolume");
            Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Method method2 = cls.getMethod("getPath", new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            String[] strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = (String) method2.invoke(Array.get(invoke, i), new Object[0]);
            }
            return strArr;
        } catch (Exception e2) {
            return (String[]) null;
        }
    }

    /* renamed from: i */
    public static long m19668i(Context context, File file) {
        long j = 0;
        if (file == null) {
            return 0L;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            File[] m18671a = (listFiles != null || m19666h(context, file)) ? listFiles : C3086ar.m18671a(context, file.getAbsolutePath(), true);
            if (m18671a == null) {
                return 0L;
            }
            for (File file2 : m18671a) {
                j += m19668i(context, file2);
            }
            return j;
        }
        return file.length();
    }

    /* renamed from: b */
    public static int m19621b(Context context, File file, boolean z) {
        return m19622b(context, file, z, false);
    }

    /* renamed from: b */
    public static int m19622b(Context context, File file, boolean z, boolean z2) {
        if (file == null || !file.exists() || !file.isDirectory()) {
            throw new Exception("error of counting, break");
        }
        File[] listFiles = file.listFiles(new FilenameFilter() { // from class: ru.maximoff.apktool.util.u.105
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                return C3102bd.f18269E || str.charAt(0) != '.';
            }
        });
        File[] m18671a = (listFiles != null || m19666h(context, file)) ? listFiles : C3086ar.m18671a(context, file.getAbsolutePath(), C3102bd.f18269E);
        if (m18671a == null || m18671a.length == 0) {
            String[] m19640b = m19640b(context);
            if (m19640b != null) {
                for (String str : m19640b) {
                    if (z && file.getAbsolutePath().equalsIgnoreCase(new StringBuffer().append(str).append(C3249i.f19551k).toString())) {
                        return 1;
                    }
                }
            }
            if (z && file.getAbsolutePath().equalsIgnoreCase(new StringBuffer().append(Environment.getExternalStorageDirectory().getAbsolutePath()).append(C3249i.f19551k).toString())) {
                return 1;
            }
            return (z && file.getAbsolutePath().equalsIgnoreCase(C3249i.f19550j)) ? 1 : 0;
        }
        int i = 0;
        for (File file2 : m18671a) {
            if (file2.isDirectory() ? z : !z) {
                i++;
            }
            if (file2.isDirectory() && z2) {
                i += m19622b(context, file2, z, z2);
            }
        }
        return i;
    }

    /* renamed from: a */
    public static boolean m19612a(File file, File file2) {
        return m19613a(file, file2, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m19613a(File file, File file2, boolean z) {
        Throwable th;
        OutputStream outputStream;
        InputStream inputStream;
        InputStream inputStream2;
        FileOutputStream fileOutputStream;
        if (z && m19637b(file, file2)) {
            return true;
        }
        InputStream inputStream3 = (InputStream) null;
        OutputStream outputStream2 = (OutputStream) null;
        try {
            inputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (FileNotFoundException e2) {
                inputStream2 = inputStream;
            } catch (Exception e3) {
            } catch (Throwable th2) {
                th = th2;
                outputStream = outputStream2;
            }
        } catch (FileNotFoundException e4) {
            inputStream2 = inputStream3;
        } catch (Exception e5) {
            inputStream = inputStream3;
        } catch (Throwable th3) {
            th = th3;
            outputStream = outputStream2;
            inputStream = inputStream3;
        }
        try {
            byte[] bArr = new byte[C3249i.m19500a()];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            m19610a(file2, file.lastModified());
            if (z) {
                file.delete();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e7) {
                }
            }
            return true;
        } catch (FileNotFoundException e8) {
            outputStream2 = fileOutputStream;
            inputStream2 = inputStream;
            if (inputStream2 != null) {
                try {
                    try {
                        inputStream2.close();
                    } catch (IOException e9) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    outputStream = outputStream2;
                    inputStream = inputStream2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e10) {
                        }
                    }
                    if (outputStream == null) {
                        throw th;
                    }
                    try {
                        outputStream.close();
                        throw th;
                    } catch (IOException e11) {
                        throw th;
                    }
                }
            }
            if (outputStream2 != null) {
                try {
                    outputStream2.close();
                } catch (IOException e12) {
                }
            }
            return false;
        } catch (Exception e13) {
            outputStream2 = fileOutputStream;
            if (inputStream != null) {
                try {
                    try {
                        inputStream.close();
                    } catch (IOException e14) {
                    }
                } catch (Throwable th5) {
                    th = th5;
                    outputStream = outputStream2;
                    if (inputStream != null) {
                    }
                    if (outputStream == null) {
                    }
                }
            }
            if (outputStream2 != null) {
                try {
                    outputStream2.close();
                } catch (IOException e15) {
                }
            }
            return false;
        } catch (Throwable th6) {
            th = th6;
            outputStream = fileOutputStream;
            if (inputStream != null) {
            }
            if (outputStream == null) {
            }
        }
    }

    /* renamed from: b */
    public static boolean m19637b(File file, File file2) {
        return file.renameTo(file2);
    }

    /* renamed from: a */
    public static boolean m19615a(File file, String str) {
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf >= 0) {
            str = str.substring(lastIndexOf + 1);
        }
        File[] listFiles = file.getParentFile().listFiles(new FilenameFilter(str) { // from class: ru.maximoff.apktool.util.u.106

            /* renamed from: a */
            private final String f19916a;

            {
                this.f19916a = str;
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                return str2.equals(this.f19916a);
            }
        });
        return listFiles != null && listFiles.length > 0;
    }

    /* renamed from: j */
    public static boolean m19670j(Context context, File file) {
        if (file == null) {
            return false;
        }
        return m19636b(context, file.getAbsolutePath());
    }

    /* renamed from: b */
    public static boolean m19636b(Context context, String str) {
        String[] m19640b = m19640b(context.getApplicationContext());
        if (m19640b == null) {
            return false;
        }
        for (String str2 : m19640b) {
            if (str.startsWith(str2)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m19616a(String str, PackageManager packageManager) {
        try {
            packageManager.getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            return false;
        }
    }

    /* renamed from: a */
    public static String[] m19620a(Context context, PackageInfo packageInfo, PackageManager packageManager) {
        try {
            HashSet<Long> m18972b = C3105bg.m18972b(context, packageInfo.packageName);
            HashSet<Long> m18973c = C3105bg.m18973c(context, packageInfo.applicationInfo.sourceDir);
            PackageInfo packageInfo2 = packageManager.getPackageInfo(packageInfo.packageName, 0);
            return new String[]{new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(C3112bn.m19017b((CharSequence) packageInfo2.versionName)).append(" (").toString()).append(packageInfo2.versionCode).toString()).append(")").toString(), (m18972b.isEmpty() || m18973c.isEmpty() || !C3105bg.m18968a(m18972b, m18973c)) ? context.getString(R.string.not_match) : context.getString(R.string.matches)};
        } catch (PackageManager.NameNotFoundException | Exception e2) {
            return (String[]) null;
        }
    }

    /* renamed from: a */
    public static String m19566a(Context context, String str, String str2, String str3, int i) {
        return m19569a(context, str, str2, str3, i, false, (HashMap<String, String>) null);
    }

    /* renamed from: a */
    public static String m19568a(Context context, String str, String str2, String str3, int i, boolean z) {
        return m19569a(context, str, str2, str3, i, z, (HashMap<String, String>) null);
    }

    /* renamed from: a */
    public static String m19567a(Context context, String str, String str2, String str3, int i, HashMap<String, String> hashMap) {
        return m19569a(context, str, str2, str3, i, false, hashMap);
    }

    /* renamed from: a */
    public static String m19569a(Context context, String str, String str2, String str3, int i, boolean z, HashMap<String, String> hashMap) {
        String stringBuffer;
        if (C3102bd.m18925a(context, "overwrite_apk", false) && !z) {
            return new StringBuffer().append(str2).append(str3).toString();
        }
        if (i > 0) {
            try {
                stringBuffer = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(str2).append(" (").toString()).append(i).toString()).append(")").toString();
            } catch (Exception e2) {
                return new StringBuffer().append(str2).append(str3).toString();
            }
        } else {
            stringBuffer = str2;
        }
        File file = new File(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(str).append(File.separator).toString()).append(stringBuffer).toString()).append(str3).toString());
        if (file.exists()) {
            return m19569a(context, str, str2, str3, i + 1, z, hashMap);
        }
        if (hashMap != null && (hashMap.containsKey(file.getAbsolutePath()) || hashMap.containsValue(file.getAbsolutePath()))) {
            return m19569a(context, str, str2, str3, i + 1, z, hashMap);
        }
        return new StringBuffer().append(stringBuffer).append(str3).toString();
    }

    /* renamed from: b */
    public static String m19623b(Context context, String str, String str2, String str3, int i) {
        String[] m19642b = m19642b(str2, str3);
        if (C3102bd.m18925a(context, "overwrite_apk", false)) {
            return new StringBuffer().append(new StringBuffer().append(m19642b[0]).append(".").toString()).append(m19642b[1]).toString();
        }
        try {
            String str4 = m19642b[0];
            if (i > 0) {
                str4 = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m19642b[0]).append(" (").toString()).append(i).toString()).append(")").toString();
            }
            if (new File(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(str).append(File.separator).toString()).append(str4).toString()).append(".").toString()).append(m19642b[1]).toString()).exists()) {
                return m19623b(context, str, str2, str3, i + 1);
            }
            return new StringBuffer().append(new StringBuffer().append(str4).append(".").toString()).append(m19642b[1]).toString();
        } catch (Exception e2) {
            return new StringBuffer().append(new StringBuffer().append(m19642b[0]).append(".").toString()).append(m19642b[1]).toString();
        }
    }

    /* renamed from: k */
    public static boolean m19673k(Context context, File file) {
        String m19571a;
        for (String str : C3249i.m19501b()) {
            if (file.getName().toLowerCase().endsWith(new StringBuffer().append(".").append(str).toString())) {
                return (str.equals(XMLConstants.XML_NS_PREFIX) && m19671j(file)) ? false : true;
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            m19571a = context.getContentResolver().getType(FileProvider.m1838a(context, new StringBuffer().append(context.getPackageName()).append(".outprovider").toString(), file));
        } else {
            m19571a = m19571a(Uri.fromFile(file).toString());
        }
        return m19571a != null && m19571a.startsWith("text/");
    }

    /* renamed from: b */
    public static String[] m19641b(String str) {
        if (str == null) {
            return new String[]{"", ""};
        }
        String str2 = "";
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf > 0) {
            String substring = str.substring(0, lastIndexOf);
            str2 = str.substring(lastIndexOf + 1);
            if (str2.indexOf(File.separator) >= 0) {
                str2 = "";
            } else {
                str = substring;
            }
        }
        return new String[]{str, str2};
    }

    /* renamed from: b */
    public static String[] m19642b(String str, String str2) {
        int lastIndexOf;
        String stringBuffer = new StringBuffer().append("out").append(str2).toString();
        String str3 = "apk";
        if (!C3112bn.m19040o(str) && (lastIndexOf = str.lastIndexOf(46)) > 0) {
            stringBuffer = new StringBuffer().append(str.substring(0, lastIndexOf)).append(str2).toString();
            str3 = str.substring(lastIndexOf + 1);
            if (!str3.equalsIgnoreCase("apk")) {
                stringBuffer = new StringBuffer().append(str).append(str2).toString();
                str3 = "apk";
            }
        }
        return new String[]{stringBuffer, str3};
    }

    /* renamed from: a */
    public static void m19582a(Context context, File file, File file2, boolean z, int i) {
        m19583a(context, file, file2, z, context.getString(i));
    }

    /* renamed from: a */
    public static void m19583a(Context context, File file, File file2, boolean z, String str) {
        new DialogInterfaceC0070b.a(context).m427a(str).m433b(R.string.mtr_sure).m420a(R.string.yes, new DialogInterface.OnClickListener(context, file, file2, z) { // from class: ru.maximoff.apktool.util.u.107

            /* renamed from: a */
            private final Context f19917a;

            /* renamed from: b */
            private final File f19918b;

            /* renamed from: c */
            private final File f19919c;

            /* renamed from: d */
            private final boolean f19920d;

            {
                this.f19917a = context;
                this.f19918b = file;
                this.f19919c = file2;
                this.f19920d = z;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                C3262u.m19581a(this.f19917a, this.f19918b, this.f19919c, this.f19920d);
            }
        }).m434b(R.string.f21469no, (DialogInterface.OnClickListener) null).m438b().show();
    }

    /* renamed from: a */
    public static void m19581a(Context context, File file, File file2, boolean z) {
        try {
            AsyncTaskC2924az asyncTaskC2924az = new AsyncTaskC2924az(context, file2);
            asyncTaskC2924az.m17381h(z);
            asyncTaskC2924az.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, file);
        } catch (Exception e2) {
            C3112bn.m18999a(context, R.string.error_try_again);
        }
    }

    /* renamed from: a */
    public static boolean m19614a(File file, File file2, boolean z, boolean z2) {
        file2.mkdirs();
        for (File file3 : file.listFiles()) {
            if (!file3.equals(file2)) {
                File file4 = new File(new StringBuffer().append(new StringBuffer().append(file2.getPath()).append(File.separatorChar).toString()).append(file3.getName()).toString());
                if (file3.isDirectory()) {
                    m19614a(file3, file4, z, z2);
                } else {
                    if (file4.exists()) {
                        if (z2) {
                            if (!m19572a(file3.getAbsolutePath(), KeyProperties.DIGEST_MD5).equals(m19572a(file4.getAbsolutePath(), KeyProperties.DIGEST_MD5))) {
                                C3061a.m18308a(file4, file3, false);
                            }
                        } else if (!z) {
                            continue;
                        }
                    }
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file3);
                        FileOutputStream fileOutputStream = new FileOutputStream(file4);
                        C1887e.m13962a(fileInputStream, fileOutputStream);
                        fileInputStream.close();
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        throw new Exception(new StringBuffer().append("Could not copy file: ").append(file3).toString(), e2);
                    }
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public static void m19596a(Context context, InterfaceC2995n interfaceC2995n, C3099ba c3099ba, Drawable drawable, File file) {
        if (c3099ba == null && drawable == null) {
            C3112bn.m19023b(context, context.getString(R.string.error));
            return;
        }
        AsyncTaskC2927bb asyncTaskC2927bb = new AsyncTaskC2927bb(context, interfaceC2995n);
        asyncTaskC2927bb.m17433a(drawable, file);
        try {
            asyncTaskC2927bb.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, c3099ba);
        } catch (Exception e2) {
            C3112bn.m18999a(context, R.string.error_try_again);
        }
    }

    /* renamed from: a */
    public static void m19589a(Context context, File file, InterfaceC2995n interfaceC2995n, boolean z) {
        String str;
        int i;
        if (!m19664g(context, file) || C3102bd.m18925a(context, "all_to_out_dir", false)) {
            str = C3102bd.f18339v;
            if (str == null) {
                C3112bn.m18999a(context, R.string.output_directory_not_set);
                return;
            }
            File file2 = new File(str);
            if (!file2.exists() && !file2.mkdirs()) {
                C3112bn.m19023b(context, context.getString(R.string.output_directory_not_extsts, str));
                return;
            } else if (!file2.isDirectory()) {
                C3112bn.m19023b(context, context.getString(R.string.not_directory, str));
                return;
            }
        } else {
            str = file.getParent();
        }
        C3060a c3060a = new C3060a(context, file);
        C3102bd.f18317ay = (boolean[]) null;
        Button[] buttonArr = new Button[3];
        List<String> m18265c = c3060a.m18265c();
        String str2 = c3060a.m18267e() == null ? "" : c3060a.m18267e().split(":")[1];
        String str3 = c3060a.m18268f() == null ? "" : c3060a.m18268f().split(":")[1];
        Bitmap[] bitmapArr = {(Bitmap) null};
        int max = Math.max(37, c3060a.m18283u());
        View inflate = LayoutInflater.from(context).inflate(R.layout.edit_dialog, (ViewGroup) null);
        ((LinearLayout) inflate.findViewById(R.id.editdialogLinearLayout2)).setVisibility(0);
        int m18905a = C3102bd.m18905a(context, "selected_signature", 1);
        boolean m18925a = C3102bd.m18925a(context, "custom_signature_file", false);
        String[] strArr = new String[m18925a ? 3 : 2];
        strArr[0] = context.getString(R.string.not_sign);
        strArr[1] = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(context.getString(R.string.default_signature_file)).append(" (").toString()).append(C3102bd.f18324g).toString()).append(")").toString();
        if (m18925a) {
            strArr[2] = context.getString(R.string.custom_signature_file);
            i = m18905a;
        } else {
            i = m18905a > 1 ? 1 : m18905a;
        }
        String[] stringArray = context.getResources().getStringArray(R.array.keys);
        Spinner spinner = (Spinner) inflate.findViewById(R.id.editdialogSpinner3);
        spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(context, C0012R.layout.simple_spinner_dropdown_item, strArr));
        spinner.setSelection(i);
        spinner.setOnLongClickListener(new View.OnLongClickListener(stringArray, context, spinner, strArr) { // from class: ru.maximoff.apktool.util.u.108

            /* renamed from: a */
            private final String[] f19921a;

            /* renamed from: b */
            private final Context f19922b;

            /* renamed from: c */
            private final Spinner f19923c;

            /* renamed from: d */
            private final String[] f19924d;

            {
                this.f19921a = stringArray;
                this.f19922b = context;
                this.f19923c = spinner;
                this.f19924d = strArr;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                int i2;
                int i3 = 0;
                while (true) {
                    if (i3 >= this.f19921a.length) {
                        i2 = -1;
                        break;
                    }
                    if (this.f19921a[i3].equals(C3102bd.f18324g)) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                new DialogInterfaceC0070b.a(this.f19922b).m418a(R.string.default_key).m430a(this.f19921a, i2, new DialogInterface.OnClickListener(this, this.f19922b, this.f19921a, this.f19923c, this.f19924d) { // from class: ru.maximoff.apktool.util.u.108.1

                    /* renamed from: a */
                    private final AnonymousClass108 f19925a;

                    /* renamed from: b */
                    private final Context f19926b;

                    /* renamed from: c */
                    private final String[] f19927c;

                    /* renamed from: d */
                    private final Spinner f19928d;

                    /* renamed from: e */
                    private final String[] f19929e;

                    {
                        this.f19925a = this;
                        this.f19926b = r2;
                        this.f19927c = r3;
                        this.f19928d = r4;
                        this.f19929e = r5;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i4) {
                        C3102bd.m18937b(this.f19926b, "default_key", this.f19927c[i4]);
                        C3102bd.f18324g = this.f19927c[i4];
                        try {
                            C3102bd.m18919a(this.f19926b.getAssets(), this.f19926b.getFilesDir());
                            String string = this.f19926b.getString(R.string.default_signature_file);
                            int selectedItemPosition = this.f19928d.getSelectedItemPosition();
                            int i5 = 0;
                            while (true) {
                                if (i5 >= this.f19929e.length) {
                                    i5 = selectedItemPosition;
                                    break;
                                } else if (!this.f19929e[i5].startsWith(string)) {
                                    i5++;
                                } else {
                                    this.f19929e[i5] = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(string).append(" (").toString()).append(C3102bd.f18324g).toString()).append(")").toString();
                                    break;
                                }
                            }
                            this.f19928d.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f19926b, C0012R.layout.simple_spinner_dropdown_item, this.f19929e));
                            this.f19928d.setSelection(i5);
                        } catch (Exception e2) {
                            C3112bn.m18999a(this.f19926b, R.string.error);
                        }
                        dialogInterface.dismiss();
                    }
                }).m420a(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
                return true;
            }
        });
        ImageView imageView = (ImageView) inflate.findViewById(R.id.editdialogImageView2);
        if (C3102bd.f18291a) {
            imageView.setImageResource(R.drawable.ic_settings_light);
        } else {
            imageView.setImageResource(R.drawable.ic_settings_dark);
        }
        imageView.setOnClickListener(new View.OnClickListener(context) { // from class: ru.maximoff.apktool.util.u.109

            /* renamed from: a */
            private final Context f19930a;

            {
                this.f19930a = context;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C3080al.m18598f(this.f19930a);
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.editdialogTextView2);
        C3112bn.m19009a(textView, context.getString(R.string.aicon_size));
        textView.setOnClickListener(new View.OnClickListener(context) { // from class: ru.maximoff.apktool.util.u.110

            /* renamed from: a */
            private final Context f19935a;

            {
                this.f19935a = context;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C3080al.m18546a(this.f19935a, 50, 250, 108, "aicon_size", R.string.aicon_size);
            }
        });
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.editdialogCheckBox2);
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.editdialogCheckBox5);
        checkBox.setOnClickListener(new View.OnClickListener(checkBox, checkBox2, textView, context) { // from class: ru.maximoff.apktool.util.u.111

            /* renamed from: a */
            private final CheckBox f19936a;

            /* renamed from: b */
            private final CheckBox f19937b;

            /* renamed from: c */
            private final TextView f19938c;

            /* renamed from: d */
            private final Context f19939d;

            {
                this.f19936a = checkBox;
                this.f19937b = checkBox2;
                this.f19938c = textView;
                this.f19939d = context;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean isChecked = this.f19936a.isChecked();
                this.f19937b.setEnabled(isChecked);
                this.f19938c.setEnabled(isChecked);
                if (isChecked) {
                    C3112bn.m19009a(this.f19938c, this.f19939d.getString(R.string.aicon_size));
                } else {
                    this.f19938c.setText(R.string.aicon_size);
                }
            }
        });
        checkBox2.setChecked(C3102bd.m18925a(context, "qe_qicon", true));
        checkBox2.setOnClickListener(new View.OnClickListener(context, checkBox2) { // from class: ru.maximoff.apktool.util.u.112

            /* renamed from: a */
            private final Context f19940a;

            /* renamed from: b */
            private final CheckBox f19941b;

            {
                this.f19940a = context;
                this.f19941b = checkBox2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C3102bd.m18938b(this.f19940a, "qe_qicon", this.f19941b.isChecked());
            }
        });
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.editdialogLinearLayout1);
        if (c3060a.m18266d() == null || c3060a.m18267e() == null) {
            linearLayout.setVisibility(8);
        } else {
            TextView textView2 = (TextView) inflate.findViewById(R.id.editdialogTextView1);
            textView2.setText(new StringBuffer().append("@").append(str2).toString());
            textView2.setOnLongClickListener(new View.OnLongClickListener(context, textView2) { // from class: ru.maximoff.apktool.util.u.113

                /* renamed from: a */
                private final Context f19942a;

                /* renamed from: b */
                private final TextView f19943b;

                {
                    this.f19942a = context;
                    this.f19943b = textView2;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    C3112bn.m19002a(this.f19942a, this.f19943b.getText().toString());
                    return true;
                }
            });
            ImageView imageView2 = (ImageView) inflate.findViewById(R.id.editdialogImageView1);
            View.OnClickListener onClickListener = new View.OnClickListener(context, bitmapArr, imageView2, textView2, checkBox, checkBox2, textView) { // from class: ru.maximoff.apktool.util.u.114

                /* renamed from: a */
                private final Context f19944a;

                /* renamed from: b */
                private final Bitmap[] f19945b;

                /* renamed from: c */
                private final ImageView f19946c;

                /* renamed from: d */
                private final TextView f19947d;

                /* renamed from: e */
                private final CheckBox f19948e;

                /* renamed from: f */
                private final CheckBox f19949f;

                /* renamed from: g */
                private final TextView f19950g;

                {
                    this.f19944a = context;
                    this.f19945b = bitmapArr;
                    this.f19946c = imageView2;
                    this.f19947d = textView2;
                    this.f19948e = checkBox;
                    this.f19949f = checkBox2;
                    this.f19950g = textView;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C3261t c3261t = new C3261t(this.f19944a);
                    Runnable runnable = new Runnable(this, this.f19945b, c3261t, this.f19944a, this.f19946c, this.f19947d, this.f19948e, this.f19949f, this.f19950g) { // from class: ru.maximoff.apktool.util.u.114.1

                        /* renamed from: a */
                        private final AnonymousClass114 f19951a;

                        /* renamed from: b */
                        private final Bitmap[] f19952b;

                        /* renamed from: c */
                        private final C3261t f19953c;

                        /* renamed from: d */
                        private final Context f19954d;

                        /* renamed from: e */
                        private final ImageView f19955e;

                        /* renamed from: f */
                        private final TextView f19956f;

                        /* renamed from: g */
                        private final CheckBox f19957g;

                        /* renamed from: h */
                        private final CheckBox f19958h;

                        /* renamed from: i */
                        private final TextView f19959i;

                        {
                            this.f19951a = this;
                            this.f19952b = r2;
                            this.f19953c = c3261t;
                            this.f19954d = r4;
                            this.f19955e = r5;
                            this.f19956f = r6;
                            this.f19957g = r7;
                            this.f19958h = r8;
                            this.f19959i = r9;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                                this.f19952b[0] = BitmapFactory.decodeFile(this.f19953c.getPath(), options);
                                this.f19955e.setImageDrawable(new BitmapDrawable(this.f19954d.getResources(), C3067ab.m18368a(this.f19952b[0], 192)));
                                this.f19956f.setText(this.f19953c.getPath());
                                this.f19957g.setVisibility(0);
                                this.f19958h.setVisibility(0);
                                this.f19959i.setVisibility(0);
                            } catch (Exception e2) {
                                C3112bn.m18999a(this.f19954d, R.string.error);
                            }
                        }
                    };
                    c3261t.m19545a("_qe");
                    c3261t.setCallback(runnable);
                    c3261t.setFilter(new String[]{"gif", "png", "jpg", "jpeg", "bmp", "webp"});
                    c3261t.m19550e();
                    DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(this.f19944a);
                    aVar.m427a(c3261t.m19548c());
                    aVar.m435b(c3261t);
                    aVar.m420a(R.string.cancel, (DialogInterface.OnClickListener) null);
                    aVar.m437b("/...", (DialogInterface.OnClickListener) null);
                    aVar.m429a(false);
                    aVar.m422a(new DialogInterface.OnKeyListener(this, c3261t) { // from class: ru.maximoff.apktool.util.u.114.2

                        /* renamed from: a */
                        private final AnonymousClass114 f19960a;

                        /* renamed from: b */
                        private final C3261t f19961b;

                        {
                            this.f19960a = this;
                            this.f19961b = c3261t;
                        }

                        @Override // android.content.DialogInterface.OnKeyListener
                        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                            if (i2 != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                                return false;
                            }
                            boolean m19551f = this.f19961b.m19551f();
                            if (!m19551f) {
                                dialogInterface.dismiss();
                                return m19551f;
                            }
                            return m19551f;
                        }
                    });
                    DialogInterfaceC0070b m438b = aVar.m438b();
                    m438b.setOnShowListener(new DialogInterface.OnShowListener(this, m438b, this.f19944a, c3261t) { // from class: ru.maximoff.apktool.util.u.114.3

                        /* renamed from: a */
                        private final AnonymousClass114 f19962a;

                        /* renamed from: b */
                        private final DialogInterfaceC0070b f19963b;

                        /* renamed from: c */
                        private final Context f19964c;

                        /* renamed from: d */
                        private final C3261t f19965d;

                        {
                            this.f19962a = this;
                            this.f19963b = m438b;
                            this.f19964c = r3;
                            this.f19965d = c3261t;
                        }

                        @Override // android.content.DialogInterface.OnShowListener
                        public void onShow(DialogInterface dialogInterface) {
                            Button m414a = this.f19963b.m414a(-3);
                            m414a.setOnClickListener(new View.OnClickListener(this, this.f19964c, this.f19965d) { // from class: ru.maximoff.apktool.util.u.114.3.1

                                /* renamed from: a */
                                private final AnonymousClass3 f19966a;

                                /* renamed from: b */
                                private final Context f19967b;

                                /* renamed from: c */
                                private final C3261t f19968c;

                                {
                                    this.f19966a = this;
                                    this.f19967b = r2;
                                    this.f19968c = r3;
                                }

                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    int i2;
                                    String[] m19640b = C3262u.m19640b(this.f19967b);
                                    if (m19640b != null) {
                                        C0173ao c0173ao = new C0173ao(this.f19967b, view2);
                                        if (C3102bd.m18910a(this.f19967b, "menu_position", "1").equals("0")) {
                                            i2 = 3;
                                        } else {
                                            i2 = 5;
                                        }
                                        c0173ao.m1340a(i2);
                                        for (int i3 = 0; i3 < m19640b.length; i3++) {
                                            c0173ao.m1339a().add(0, i3 + MediaCodec.CodecException.ERROR_INSUFFICIENT_RESOURCE, 0, m19640b[i3]).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f19968c) { // from class: ru.maximoff.apktool.util.u.114.3.1.1

                                                /* renamed from: a */
                                                private final AnonymousClass1 f19969a;

                                                /* renamed from: b */
                                                private final C3261t f19970b;

                                                {
                                                    this.f19969a = this;
                                                    this.f19970b = r2;
                                                }

                                                @Override // android.view.MenuItem.OnMenuItemClickListener
                                                public boolean onMenuItemClick(MenuItem menuItem) {
                                                    this.f19970b.m19544a(new File(menuItem.getTitle().toString()));
                                                    return true;
                                                }
                                            });
                                        }
                                        c0173ao.m1344c();
                                    }
                                }
                            });
                            m414a.setOnLongClickListener(new View.OnLongClickListener(this, this.f19965d, this.f19964c) { // from class: ru.maximoff.apktool.util.u.114.3.2

                                /* renamed from: a */
                                private final AnonymousClass3 f19971a;

                                /* renamed from: b */
                                private final C3261t f19972b;

                                /* renamed from: c */
                                private final Context f19973c;

                                {
                                    this.f19971a = this;
                                    this.f19972b = r2;
                                    this.f19973c = r3;
                                }

                                @Override // android.view.View.OnLongClickListener
                                public boolean onLongClick(View view2) {
                                    int i2;
                                    List<String> m19205b = this.f19972b.m19549d().m19205b();
                                    if (m19205b.isEmpty()) {
                                        return false;
                                    }
                                    C0173ao c0173ao = new C0173ao(this.f19973c, view2);
                                    if (C3102bd.m18910a(this.f19973c, "menu_position", "1").equals("0")) {
                                        i2 = 3;
                                    } else {
                                        i2 = 5;
                                    }
                                    c0173ao.m1340a(i2);
                                    Iterator<String> it = m19205b.iterator();
                                    while (it.hasNext()) {
                                        c0173ao.m1339a().add(0, 1300, 0, it.next()).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f19972b) { // from class: ru.maximoff.apktool.util.u.114.3.2.1

                                            /* renamed from: a */
                                            private final AnonymousClass2 f19974a;

                                            /* renamed from: b */
                                            private final C3261t f19975b;

                                            {
                                                this.f19974a = this;
                                                this.f19975b = r2;
                                            }

                                            @Override // android.view.MenuItem.OnMenuItemClickListener
                                            public boolean onMenuItemClick(MenuItem menuItem) {
                                                this.f19975b.m19544a(new File(menuItem.getTitle().toString()));
                                                return true;
                                            }
                                        });
                                    }
                                    c0173ao.m1344c();
                                    return true;
                                }
                            });
                        }
                    });
                    c3261t.setDialog(m438b);
                    m438b.show();
                }
            };
            imageView2.setOnLongClickListener(new View.OnLongClickListener(bitmapArr, c3060a, context, imageView2, textView2, checkBox, checkBox2, textView, str2, str, interfaceC2995n) { // from class: ru.maximoff.apktool.util.u.115

                /* renamed from: a */
                private final Bitmap[] f19976a;

                /* renamed from: b */
                private final C3060a f19977b;

                /* renamed from: c */
                private final Context f19978c;

                /* renamed from: d */
                private final ImageView f19979d;

                /* renamed from: e */
                private final TextView f19980e;

                /* renamed from: f */
                private final CheckBox f19981f;

                /* renamed from: g */
                private final CheckBox f19982g;

                /* renamed from: h */
                private final TextView f19983h;

                /* renamed from: i */
                private final String f19984i;

                /* renamed from: j */
                private final String f19985j;

                /* renamed from: k */
                private final InterfaceC2995n f19986k;

                {
                    this.f19976a = bitmapArr;
                    this.f19977b = c3060a;
                    this.f19978c = context;
                    this.f19979d = imageView2;
                    this.f19980e = textView2;
                    this.f19981f = checkBox;
                    this.f19982g = checkBox2;
                    this.f19983h = textView;
                    this.f19984i = str2;
                    this.f19985j = str;
                    this.f19986k = interfaceC2995n;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    int i2;
                    Bitmap m18266d = this.f19976a[0] == null ? this.f19977b.m18266d() : this.f19976a[0];
                    C0173ao c0173ao = new C0173ao(this.f19978c, view);
                    if (C3102bd.m18910a(this.f19978c, "menu_position", "1").equals("0")) {
                        i2 = 3;
                    } else {
                        i2 = 5;
                    }
                    c0173ao.m1340a(i2);
                    c0173ao.m1339a().add(0, 1500, 0, this.f19978c.getString(R.string.invert_color)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, m18266d, this.f19976a, this.f19978c, this.f19979d, this.f19980e, this.f19981f, this.f19982g, this.f19983h) { // from class: ru.maximoff.apktool.util.u.115.1

                        /* renamed from: a */
                        private final AnonymousClass115 f19987a;

                        /* renamed from: b */
                        private final Bitmap f19988b;

                        /* renamed from: c */
                        private final Bitmap[] f19989c;

                        /* renamed from: d */
                        private final Context f19990d;

                        /* renamed from: e */
                        private final ImageView f19991e;

                        /* renamed from: f */
                        private final TextView f19992f;

                        /* renamed from: g */
                        private final CheckBox f19993g;

                        /* renamed from: h */
                        private final CheckBox f19994h;

                        /* renamed from: i */
                        private final TextView f19995i;

                        {
                            this.f19987a = this;
                            this.f19988b = m18266d;
                            this.f19989c = r3;
                            this.f19990d = r4;
                            this.f19991e = r5;
                            this.f19992f = r6;
                            this.f19993g = r7;
                            this.f19994h = r8;
                            this.f19995i = r9;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            try {
                                File createTempFile = File.createTempFile("AM_QuickInv_", ".png", C3102bd.m18908a());
                                Bitmap m18395c = C3067ab.m18395c(this.f19988b);
                                C3067ab.m18383a(m18395c, createTempFile);
                                this.f19989c[0] = m18395c;
                                this.f19991e.setImageDrawable(new BitmapDrawable(this.f19990d.getResources(), m18395c));
                                this.f19992f.setText(createTempFile.getAbsolutePath());
                                this.f19993g.setVisibility(0);
                                this.f19994h.setVisibility(0);
                                this.f19995i.setVisibility(0);
                                return true;
                            } catch (Exception e2) {
                                C3112bn.m18999a(this.f19990d, R.string.error);
                                return true;
                            }
                        }
                    });
                    c0173ao.m1339a().add(0, 1501, 0, this.f19978c.getString(R.string.monochrome)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, m18266d, this.f19976a, this.f19978c, this.f19979d, this.f19980e, this.f19981f, this.f19982g, this.f19983h) { // from class: ru.maximoff.apktool.util.u.115.2

                        /* renamed from: a */
                        private final AnonymousClass115 f19996a;

                        /* renamed from: b */
                        private final Bitmap f19997b;

                        /* renamed from: c */
                        private final Bitmap[] f19998c;

                        /* renamed from: d */
                        private final Context f19999d;

                        /* renamed from: e */
                        private final ImageView f20000e;

                        /* renamed from: f */
                        private final TextView f20001f;

                        /* renamed from: g */
                        private final CheckBox f20002g;

                        /* renamed from: h */
                        private final CheckBox f20003h;

                        /* renamed from: i */
                        private final TextView f20004i;

                        {
                            this.f19996a = this;
                            this.f19997b = m18266d;
                            this.f19998c = r3;
                            this.f19999d = r4;
                            this.f20000e = r5;
                            this.f20001f = r6;
                            this.f20002g = r7;
                            this.f20003h = r8;
                            this.f20004i = r9;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            try {
                                File createTempFile = File.createTempFile("AM_QuickMono_", ".png", C3102bd.m18908a());
                                Bitmap m18397d = C3067ab.m18397d(this.f19997b);
                                C3067ab.m18383a(m18397d, createTempFile);
                                this.f19998c[0] = m18397d;
                                this.f20000e.setImageDrawable(new BitmapDrawable(this.f19999d.getResources(), m18397d));
                                this.f20001f.setText(createTempFile.getAbsolutePath());
                                this.f20002g.setVisibility(0);
                                this.f20003h.setVisibility(0);
                                this.f20004i.setVisibility(0);
                                return true;
                            } catch (Exception e2) {
                                C3112bn.m18999a(this.f19999d, R.string.error);
                                return true;
                            }
                        }
                    });
                    c0173ao.m1339a().add(0, 1502, 0, this.f19978c.getString(R.string.search_reset)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f19976a, this.f19979d, this.f19977b, this.f19980e, this.f19984i, this.f19981f, this.f19982g, this.f19983h) { // from class: ru.maximoff.apktool.util.u.115.3

                        /* renamed from: a */
                        private final AnonymousClass115 f20005a;

                        /* renamed from: b */
                        private final Bitmap[] f20006b;

                        /* renamed from: c */
                        private final ImageView f20007c;

                        /* renamed from: d */
                        private final C3060a f20008d;

                        /* renamed from: e */
                        private final TextView f20009e;

                        /* renamed from: f */
                        private final String f20010f;

                        /* renamed from: g */
                        private final CheckBox f20011g;

                        /* renamed from: h */
                        private final CheckBox f20012h;

                        /* renamed from: i */
                        private final TextView f20013i;

                        {
                            this.f20005a = this;
                            this.f20006b = r2;
                            this.f20007c = r3;
                            this.f20008d = r4;
                            this.f20009e = r5;
                            this.f20010f = r6;
                            this.f20011g = r7;
                            this.f20012h = r8;
                            this.f20013i = r9;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            this.f20006b[0] = (Bitmap) null;
                            this.f20007c.setImageBitmap(this.f20008d.m18266d());
                            this.f20009e.setText(new StringBuffer().append("@").append(this.f20010f).toString());
                            this.f20011g.setVisibility(8);
                            this.f20012h.setVisibility(8);
                            this.f20013i.setVisibility(8);
                            return true;
                        }
                    });
                    c0173ao.m1339a().add(0, 1503, 0, this.f19978c.getString(R.string.save)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f19978c, this.f19985j, this.f19977b, this.f19984i, this.f19986k) { // from class: ru.maximoff.apktool.util.u.115.4

                        /* renamed from: a */
                        private final AnonymousClass115 f20014a;

                        /* renamed from: b */
                        private final Context f20015b;

                        /* renamed from: c */
                        private final String f20016c;

                        /* renamed from: d */
                        private final C3060a f20017d;

                        /* renamed from: e */
                        private final String f20018e;

                        /* renamed from: f */
                        private final InterfaceC2995n f20019f;

                        {
                            this.f20014a = this;
                            this.f20015b = r2;
                            this.f20016c = r3;
                            this.f20017d = r4;
                            this.f20018e = r5;
                            this.f20019f = r6;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            try {
                                C3112bn.m19023b(this.f20015b, this.f20015b.getString(R.string.extraction, C3067ab.m18383a(this.f20017d.m18266d(), new File(this.f20016c, C3262u.m19566a(this.f20015b, this.f20016c, C3112bn.m19033h(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f20017d.m18271i()).append("_v").toString()).append(this.f20017d.m18277o()).toString()).append("_").toString()).append(this.f20018e.split("/")[1]).toString()).replaceAll("\\s", "_"), ".png", 0))).getAbsolutePath()));
                                if (this.f20019f != null) {
                                    this.f20019f.mo17929a();
                                } else {
                                    MainActivity.m16615o().m16644z();
                                }
                            } catch (Exception e2) {
                                C3112bn.m18999a(this.f20015b, R.string.error);
                            }
                            return true;
                        }
                    });
                    c0173ao.m1344c();
                    return true;
                }
            });
            imageView2.setOnClickListener(onClickListener);
            textView2.setOnClickListener(onClickListener);
            imageView2.setImageBitmap(c3060a.m18266d());
        }
        EditText editText = (EditText) inflate.findViewById(R.id.editdialogEditText1);
        editText.setHint(c3060a.m18271i());
        editText.setText(c3060a.m18271i());
        editText.setEnabled(c3060a.m18281s() <= Build.VERSION.SDK_INT);
        EditText editText2 = (EditText) inflate.findViewById(R.id.editdialogEditText2);
        editText2.addTextChangedListener(new TextWatcher(buttonArr) { // from class: ru.maximoff.apktool.util.u.116

            /* renamed from: a */
            private final Button[] f20020a;

            {
                this.f20020a = buttonArr;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                try {
                    C3112bn.m19004a(editable, (Class<? extends CharacterStyle>) Class.forName("android.text.style.ForegroundColorSpan"));
                    if (this.f20020a[0] != null) {
                        this.f20020a[0].setEnabled(true);
                    }
                    if (editable.length() != 0) {
                        if (editable.length() > 127 || !editable.toString().matches("^[a-zA-Z0-9\\._]+$")) {
                            editable.setSpan(new ForegroundColorSpan(Color.RED), 0, editable.length(), 33);
                            if (this.f20020a[0] != null) {
                                this.f20020a[0].setEnabled(false);
                            }
                        }
                    }
                } catch (ClassNotFoundException e2) {
                    throw new NoClassDefFoundError(e2.getMessage());
                }
            }
        });
        editText2.setHint(c3060a.m18276n());
        editText2.setText(c3060a.m18276n());
        EditText editText3 = (EditText) inflate.findViewById(R.id.editdialogEditText3);
        editText3.setHint(c3060a.m18277o());
        editText3.setText(c3060a.m18277o());
        EditText editText4 = (EditText) inflate.findViewById(R.id.editdialogEditText4);
        editText4.addTextChangedListener(new TextWatcher(buttonArr) { // from class: ru.maximoff.apktool.util.u.117

            /* renamed from: a */
            private final Button[] f20021a;

            {
                this.f20021a = buttonArr;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                try {
                    C3112bn.m19004a(editable, (Class<? extends CharacterStyle>) Class.forName("android.text.style.ForegroundColorSpan"));
                    if (this.f20021a[0] != null) {
                        this.f20021a[0].setEnabled(true);
                    }
                    if (editable.length() != 0) {
                        try {
                            Integer.parseInt(editable.toString());
                        } catch (Exception e2) {
                            editable.setSpan(new ForegroundColorSpan(Color.RED), 0, editable.length(), 33);
                            if (this.f20021a[0] != null) {
                                this.f20021a[0].setEnabled(false);
                            }
                        }
                    }
                } catch (ClassNotFoundException e3) {
                    throw new NoClassDefFoundError(e3.getMessage());
                }
            }
        });
        editText4.setHint(String.valueOf(c3060a.m18278p()));
        editText4.setText(String.valueOf(c3060a.m18278p()));
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.editdialogImageButton1);
        ImageButton imageButton2 = (ImageButton) inflate.findViewById(R.id.editdialogImageButton2);
        if (C3102bd.f18291a) {
            imageButton.setImageResource(R.drawable.ic_reload);
            imageButton2.setImageResource(R.drawable.ic_top);
        } else {
            imageButton.setImageResource(R.drawable.ic_reload_dark);
            imageButton2.setImageResource(R.drawable.ic_top_dark);
        }
        imageButton.setOnClickListener(new View.OnClickListener(c3060a, editText2) { // from class: ru.maximoff.apktool.util.u.118

            /* renamed from: a */
            private final C3060a f20022a;

            /* renamed from: b */
            private final EditText f20023b;

            {
                this.f20022a = c3060a;
                this.f20023b = editText2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String m19042q = C3112bn.m19042q(this.f20022a.m18276n());
                this.f20023b.setText(m19042q);
                this.f20023b.setSelection(m19042q.length());
            }
        });
        imageButton.setOnLongClickListener(new View.OnLongClickListener(editText2, c3060a) { // from class: ru.maximoff.apktool.util.u.119

            /* renamed from: a */
            private final EditText f20024a;

            /* renamed from: b */
            private final C3060a f20025b;

            {
                this.f20024a = editText2;
                this.f20025b = c3060a;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                this.f20024a.setText(this.f20025b.m18276n());
                this.f20024a.setSelection(this.f20025b.m18276n().length());
                return true;
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener(editText4) { // from class: ru.maximoff.apktool.util.u.120

            /* renamed from: a */
            private final EditText f20027a;

            {
                this.f20027a = editText4;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String valueOf = String.valueOf(Integer.MAX_VALUE);
                this.f20027a.setText(valueOf);
                this.f20027a.setSelection(valueOf.length());
            }
        });
        imageButton2.setOnLongClickListener(new View.OnLongClickListener(c3060a, editText4) { // from class: ru.maximoff.apktool.util.u.121

            /* renamed from: a */
            private final C3060a f20028a;

            /* renamed from: b */
            private final EditText f20029b;

            {
                this.f20028a = c3060a;
                this.f20029b = editText4;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                String valueOf = String.valueOf(this.f20028a.m18278p());
                this.f20029b.setText(valueOf);
                this.f20029b.setSelection(valueOf.length());
                return true;
            }
        });
        String[] strArr2 = new String[max + 1];
        strArr2[0] = context.getString(R.string.dont_change);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= max) {
                break;
            }
            strArr2[i3 + 1] = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(max - i3).append(" (").toString()).append(C3080al.m18532a(max - i3, true)).toString()).append(")").toString()).append(c3060a.m18281s() == max - i3 ? " √" : "").toString();
            i2 = i3 + 1;
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, C0012R.layout.simple_spinner_dropdown_item, strArr2);
        String[] strArr3 = new String[max + 1];
        strArr3[0] = context.getString(R.string.dont_change);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= max) {
                break;
            }
            strArr3[i5 + 1] = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(max - i5).append(" (").toString()).append(C3080al.m18532a(max - i5, true)).toString()).append(")").toString()).append(c3060a.m18283u() == max - i5 ? " √" : "").toString();
            i4 = i5 + 1;
        }
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(context, C0012R.layout.simple_spinner_dropdown_item, strArr3);
        Spinner spinner2 = (Spinner) inflate.findViewById(R.id.editdialogSpinner1);
        spinner2.setAdapter((SpinnerAdapter) arrayAdapter);
        if (c3060a.m18281s() > 0) {
            spinner2.setSelection((max - c3060a.m18281s()) + 1);
        } else {
            spinner2.setSelection(0);
        }
        Spinner spinner3 = (Spinner) inflate.findViewById(R.id.editdialogSpinner2);
        spinner3.setAdapter((SpinnerAdapter) arrayAdapter2);
        if (c3060a.m18283u() > 0) {
            spinner3.setSelection((max - c3060a.m18283u()) + 1);
        } else {
            spinner3.setSelection(0);
        }
        ArrayAdapter arrayAdapter3 = new ArrayAdapter(context, C0012R.layout.simple_spinner_dropdown_item, context.getResources().getStringArray(R.array.installLocation));
        Spinner spinner4 = (Spinner) inflate.findViewById(R.id.editdialogSpinner4);
        spinner4.setAdapter((SpinnerAdapter) arrayAdapter3);
        spinner4.setSelection(c3060a.m18280r() + 1);
        CheckBox checkBox3 = (CheckBox) inflate.findViewById(R.id.editdialogCheckBox1);
        if (!c3060a.m18252A()) {
            checkBox3.setVisibility(8);
        }
        CheckBox checkBox4 = (CheckBox) inflate.findViewById(R.id.editdialogCheckBox3);
        checkBox4.setText(context.getString(R.string.debug_mode).toLowerCase());
        checkBox4.setChecked(c3060a.m18253B());
        CheckBox checkBox5 = (CheckBox) inflate.findViewById(R.id.editdialogCheckBox4);
        if (!c3060a.m18254C()) {
            checkBox5.setVisibility(8);
        }
        CheckBox checkBox6 = (CheckBox) inflate.findViewById(R.id.editdialogCheckBox7);
        if (c3060a.m18274l() == null) {
            checkBox6.setVisibility(8);
        }
        CheckBox checkBox7 = (CheckBox) inflate.findViewById(R.id.editdialogCheckBox6);
        if (c3060a.m18266d() == null || c3060a.m18267e() == null) {
            checkBox7.setVisibility(8);
        }
        Button button = (Button) inflate.findViewById(R.id.editdialogButton1);
        button.setEnabled(!m18265c.isEmpty());
        button.setOnClickListener(new View.OnClickListener(context, m18265c) { // from class: ru.maximoff.apktool.util.u.122

            /* renamed from: a */
            private final Context f20030a;

            /* renamed from: b */
            private final List f20031b;

            {
                this.f20030a = context;
                this.f20031b = m18265c;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View inflate2 = LayoutInflater.from(this.f20030a).inflate(R.layout.smali_help, (ViewGroup) null);
                C3309k c3309k = new C3309k(this.f20030a, this.f20031b, true);
                CustomListView customListView = (CustomListView) inflate2.findViewById(R.id.smalihelpListView1);
                customListView.setDivider((Drawable) null);
                customListView.setDividerHeight(0);
                customListView.setFastScrollEnabled(C3102bd.f18314av);
                customListView.setAdapter((ListAdapter) c3309k);
                EditText editText5 = (EditText) inflate2.findViewById(R.id.smalihelpEditText1);
                ImageView imageView3 = (ImageView) inflate2.findViewById(R.id.clearText1);
                if (C3102bd.f18291a) {
                    imageView3.setImageResource(R.drawable.ic_close);
                } else {
                    imageView3.setImageResource(R.drawable.ic_close_dark);
                }
                imageView3.setOnClickListener(new View.OnClickListener(this, editText5) { // from class: ru.maximoff.apktool.util.u.122.1

                    /* renamed from: a */
                    private final AnonymousClass122 f20032a;

                    /* renamed from: b */
                    private final EditText f20033b;

                    {
                        this.f20032a = this;
                        this.f20033b = editText5;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        this.f20033b.requestFocus();
                        this.f20033b.setText("");
                    }
                });
                if (editText5.getText().length() == 0) {
                    imageView3.setVisibility(8);
                }
                editText5.addTextChangedListener(new TextWatcher(this, imageView3, c3309k) { // from class: ru.maximoff.apktool.util.u.122.2

                    /* renamed from: a */
                    private final AnonymousClass122 f20034a;

                    /* renamed from: b */
                    private final ImageView f20035b;

                    /* renamed from: c */
                    private final C3309k f20036c;

                    {
                        this.f20034a = this;
                        this.f20035b = imageView3;
                        this.f20036c = c3309k;
                    }

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        if (editable.length() == 0) {
                            this.f20035b.setVisibility(8);
                        } else {
                            this.f20035b.setVisibility(0);
                        }
                        this.f20036c.m19937a(editable.toString());
                    }
                });
                DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f20030a).m427a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f20030a.getString(R.string.permissions)).append(" (").toString()).append(this.f20031b.size()).toString()).append(")").toString()).m435b(inflate2).m420a(R.string.f21470ok, (DialogInterface.OnClickListener) null).m440c(R.string.mselect_inv, (DialogInterface.OnClickListener) null).m438b();
                m438b.setOnShowListener(new DialogInterface.OnShowListener(this, m438b, c3309k) { // from class: ru.maximoff.apktool.util.u.122.3

                    /* renamed from: a */
                    private final AnonymousClass122 f20037a;

                    /* renamed from: b */
                    private final DialogInterfaceC0070b f20038b;

                    /* renamed from: c */
                    private final C3309k f20039c;

                    {
                        this.f20037a = this;
                        this.f20038b = m438b;
                        this.f20039c = c3309k;
                    }

                    @Override // android.content.DialogInterface.OnShowListener
                    public void onShow(DialogInterface dialogInterface) {
                        Button m414a = this.f20038b.m414a(-3);
                        m414a.setOnClickListener(new View.OnClickListener(this, this.f20039c) { // from class: ru.maximoff.apktool.util.u.122.3.1

                            /* renamed from: a */
                            private final AnonymousClass3 f20040a;

                            /* renamed from: b */
                            private final C3309k f20041b;

                            {
                                this.f20040a = this;
                                this.f20041b = r2;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                this.f20041b.m19938b();
                            }
                        });
                        m414a.setOnLongClickListener(new View.OnLongClickListener(this, this.f20039c) { // from class: ru.maximoff.apktool.util.u.122.3.2

                            /* renamed from: a */
                            private final AnonymousClass3 f20042a;

                            /* renamed from: b */
                            private final C3309k f20043b;

                            {
                                this.f20042a = this;
                                this.f20043b = r2;
                            }

                            @Override // android.view.View.OnLongClickListener
                            public boolean onLongClick(View view2) {
                                this.f20043b.m19936a();
                                return true;
                            }
                        });
                    }
                });
                m438b.show();
            }
        });
        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(context);
        aVar.m418a(R.string.mapp_quickedit);
        aVar.m435b(inflate);
        aVar.m420a(R.string.save, new DialogInterface.OnClickListener(str, context, editText, c3060a, editText2, editText3, editText4, max, spinner2, spinner3, spinner, interfaceC2995n, spinner4, checkBox3, checkBox4, checkBox5, checkBox6, bitmapArr, checkBox, checkBox2, str2, m18265c, z, str3, checkBox7, file) { // from class: ru.maximoff.apktool.util.u.123

            /* renamed from: a */
            private final String f20044a;

            /* renamed from: b */
            private final Context f20045b;

            /* renamed from: c */
            private final EditText f20046c;

            /* renamed from: d */
            private final C3060a f20047d;

            /* renamed from: e */
            private final EditText f20048e;

            /* renamed from: f */
            private final EditText f20049f;

            /* renamed from: g */
            private final EditText f20050g;

            /* renamed from: h */
            private final int f20051h;

            /* renamed from: i */
            private final Spinner f20052i;

            /* renamed from: j */
            private final Spinner f20053j;

            /* renamed from: k */
            private final Spinner f20054k;

            /* renamed from: l */
            private final InterfaceC2995n f20055l;

            /* renamed from: m */
            private final Spinner f20056m;

            /* renamed from: n */
            private final CheckBox f20057n;

            /* renamed from: o */
            private final CheckBox f20058o;

            /* renamed from: p */
            private final CheckBox f20059p;

            /* renamed from: q */
            private final CheckBox f20060q;

            /* renamed from: r */
            private final Bitmap[] f20061r;

            /* renamed from: s */
            private final CheckBox f20062s;

            /* renamed from: t */
            private final CheckBox f20063t;

            /* renamed from: u */
            private final String f20064u;

            /* renamed from: v */
            private final List f20065v;

            /* renamed from: w */
            private final boolean f20066w;

            /* renamed from: x */
            private final String f20067x;

            /* renamed from: y */
            private final CheckBox f20068y;

            /* renamed from: z */
            private final File f20069z;

            {
                this.f20044a = str;
                this.f20045b = context;
                this.f20046c = editText;
                this.f20047d = c3060a;
                this.f20048e = editText2;
                this.f20049f = editText3;
                this.f20050g = editText4;
                this.f20051h = max;
                this.f20052i = spinner2;
                this.f20053j = spinner3;
                this.f20054k = spinner;
                this.f20055l = interfaceC2995n;
                this.f20056m = spinner4;
                this.f20057n = checkBox3;
                this.f20058o = checkBox4;
                this.f20059p = checkBox5;
                this.f20060q = checkBox6;
                this.f20061r = bitmapArr;
                this.f20062s = checkBox;
                this.f20063t = checkBox2;
                this.f20064u = str2;
                this.f20065v = m18265c;
                this.f20066w = z;
                this.f20067x = str3;
                this.f20068y = checkBox7;
                this.f20069z = file;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i6) {
                File file3 = new File(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f20044a).append(File.separator).toString()).append(".AM_TempQE_").toString()).append(System.currentTimeMillis()).toString());
                if (!file3.mkdir()) {
                    C3112bn.m19023b(this.f20045b, this.f20045b.getString(R.string.error));
                    return;
                }
                String editable = this.f20046c.getText().toString();
                String str4 = (C3112bn.m19040o(editable) || editable.equals(this.f20047d.m18271i())) ? (String) null : editable;
                String editable2 = this.f20048e.getText().toString();
                String str5 = (C3112bn.m19040o(editable2) || editable2.length() > 127 || !editable2.matches("[a-zA-Z0-9\\._]+") || editable2.equals(this.f20047d.m18276n())) ? (String) null : editable2;
                String editable3 = this.f20049f.getText().toString();
                String str6 = (C3112bn.m19040o(editable3) || editable3.equals(this.f20047d.m18277o())) ? (String) null : editable3;
                int i7 = 0;
                if (!C3112bn.m19013a(this.f20050g.getText())) {
                    try {
                        i7 = Math.abs(Integer.parseInt(this.f20050g.getText().toString()));
                    } catch (Exception e2) {
                        i7 = 0;
                    }
                }
                int i8 = i7 == this.f20047d.m18278p() ? 0 : i7;
                int selectedItemPosition = (this.f20051h - this.f20052i.getSelectedItemPosition()) + 1;
                int i9 = (selectedItemPosition > this.f20051h || selectedItemPosition == this.f20047d.m18281s()) ? 0 : selectedItemPosition;
                int selectedItemPosition2 = (this.f20051h - this.f20053j.getSelectedItemPosition()) + 1;
                int i10 = (selectedItemPosition2 > this.f20051h || selectedItemPosition2 == this.f20047d.m18283u()) ? 0 : selectedItemPosition2;
                int selectedItemPosition3 = this.f20054k.getSelectedItemPosition();
                C3102bd.m18935b(this.f20045b, "selected_signature", selectedItemPosition3);
                AsyncTaskC2908aj asyncTaskC2908aj = new AsyncTaskC2908aj(this.f20045b, this.f20055l);
                asyncTaskC2908aj.m17196c(str4);
                asyncTaskC2908aj.m17199d(C3112bn.m19040o(this.f20047d.m18272j()) ? (String) null : this.f20047d.m18272j());
                asyncTaskC2908aj.m17202e(C3112bn.m19040o(this.f20047d.m18273k()) ? (String) null : this.f20047d.m18273k());
                asyncTaskC2908aj.m17205f(str5);
                asyncTaskC2908aj.m17208g(this.f20047d.m18276n());
                asyncTaskC2908aj.m17211h(str6);
                asyncTaskC2908aj.m17195c(i8);
                asyncTaskC2908aj.m17198d(i9);
                asyncTaskC2908aj.m17201e(i10);
                asyncTaskC2908aj.m17204f(this.f20047d.m18281s());
                asyncTaskC2908aj.m17207g(this.f20047d.m18283u());
                asyncTaskC2908aj.m17213i(this.f20056m.getSelectedItemPosition());
                asyncTaskC2908aj.m17191a(this.f20057n.isChecked());
                asyncTaskC2908aj.m17194b(this.f20058o.isChecked());
                asyncTaskC2908aj.m17197c(this.f20059p.isChecked());
                asyncTaskC2908aj.m17200d(this.f20060q.isChecked());
                asyncTaskC2908aj.m17187a(this.f20061r[0]);
                asyncTaskC2908aj.m17186a(this.f20047d.m18258G());
                asyncTaskC2908aj.m17203e(this.f20062s.isChecked());
                asyncTaskC2908aj.m17206f(this.f20063t.isChecked() && this.f20062s.isChecked());
                asyncTaskC2908aj.m17189a(this.f20064u);
                asyncTaskC2908aj.m17185a(this.f20047d.m18269g());
                asyncTaskC2908aj.m17210h(selectedItemPosition3);
                asyncTaskC2908aj.m17190a(this.f20065v);
                asyncTaskC2908aj.m17212h(this.f20066w);
                asyncTaskC2908aj.m17193b(this.f20067x);
                asyncTaskC2908aj.m17192b(this.f20047d.m18270h());
                asyncTaskC2908aj.m17209g(this.f20068y.isChecked());
                try {
                    asyncTaskC2908aj.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f20069z.getAbsolutePath(), new StringBuffer().append(new StringBuffer().append(file3.getAbsolutePath()).append(File.separator).toString()).append(this.f20069z.getName()).toString());
                } catch (Exception e3) {
                    C3112bn.m18999a(this.f20045b, R.string.error_try_again);
                }
                dialogInterface.dismiss();
            }
        });
        aVar.m434b(R.string.cancel, (DialogInterface.OnClickListener) null);
        DialogInterfaceC0070b m438b = aVar.m438b();
        m438b.getWindow().setSoftInputMode(16);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(editText, buttonArr, m438b) { // from class: ru.maximoff.apktool.util.u.124

            /* renamed from: a */
            private final EditText f20070a;

            /* renamed from: b */
            private final Button[] f20071b;

            /* renamed from: c */
            private final DialogInterfaceC0070b f20072c;

            {
                this.f20070a = editText;
                this.f20071b = buttonArr;
                this.f20072c = m438b;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f20070a.requestFocus();
                this.f20070a.selectAll();
                this.f20071b[0] = this.f20072c.m414a(-1);
                this.f20071b[1] = this.f20072c.m414a(-2);
            }
        });
        m438b.show();
    }
}
