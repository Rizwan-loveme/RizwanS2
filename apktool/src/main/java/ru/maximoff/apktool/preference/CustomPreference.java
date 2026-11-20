package ru.maximoff.apktool.preference;

import android.C0012R;
import android.content.Context;
import android.content.Intent;
import android.content.p006pm.PackageManager;
import android.net.Uri;
import android.preference.Preference;
import android.security.keystore.KeyProperties;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.p065b.p066a.p067a.AbstractC0581c;
import com.p122c.p123a.C1076d;
import com.p122c.p123a.C1078f;
import com.p122c.p123a.InterfaceC1075c;
import com.srizwan.apktool.R;
import java.io.File;
import java.util.Enumeration;
import ru.maximoff.apktool.util.C3078aj;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3106bh;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3262u;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* loaded from: classes.dex */
public class CustomPreference extends Preference implements View.OnLongClickListener {

    /* renamed from: a */
    private final String[] f16869a;

    /* renamed from: b */
    private Context f16870b;

    public CustomPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16869a = new String[]{"aeplugin_key", "tools_replace", "man_frame", "check_update", "get_changelog"};
        this.f16870b = context;
    }

    public CustomPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16869a = new String[]{"aeplugin_key", "tools_replace", "man_frame", "check_update", "get_changelog"};
        this.f16870b = context;
    }

    public CustomPreference(Context context) {
        this(context, (AttributeSet) null, 0);
        this.f16870b = context;
    }

    @Override // android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(C0012R.id.title);
        if (textView != null) {
            C3112bn.m19001a(view.getContext(), textView, C0012R.style.TextAppearance_Medium);
            textView.setSingleLine(false);
            textView.setTextSize(2, C3102bd.f18332o);
        }
        TextView textView2 = (TextView) view.findViewById(C0012R.id.summary);
        if (textView2 != null) {
            C3112bn.m19001a(view.getContext(), textView2, C0012R.style.TextAppearance_Small);
            textView2.setSingleLine(false);
            textView2.setTextSize(2, C3102bd.m18927b());
        }
    }

    @Override // android.preference.Preference
    protected View onCreateView(ViewGroup viewGroup) {
        ((ListView) viewGroup).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(this) { // from class: ru.maximoff.apktool.preference.CustomPreference.1

            /* renamed from: a */
            private final CustomPreference f16871a;

            {
                this.f16871a = this;
            }

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                Object item = ((ListView) adapterView).getAdapter().getItem(i);
                if (item == null || !(item instanceof View.OnLongClickListener)) {
                    return false;
                }
                return ((View.OnLongClickListener) item).onLongClick(view);
            }
        });
        return super.onCreateView(viewGroup);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        for (String str : this.f16869a) {
            if (str.equals(getKey())) {
                return m18084a(str);
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m18084a(String str) {
        int i;
        try {
            int i2 = this.f16870b.getPackageManager().getPackageInfo(this.f16870b.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
        }
        if (str.equals("aeplugin_key")) {
            if (!C3262u.m19616a("ru.maximoff.aepatcher", this.f16870b.getPackageManager())) {
                return false;
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.setPackage("ru.maximoff.aepatcher");
                intent.setDataAndType(Uri.parse(""), "application/ru.maximoff.aepatcher-patch");
                intent.putExtra("appTheme", C3102bd.f18319b);
                intent.putExtra("appLanguage", C3102bd.f18267C);
                intent.putExtra("keepScreenOn", C3102bd.f18275K);
                intent.putExtra("showHelp", true);
                intent.addFlags(268435456);
                this.f16870b.startActivity(intent);
            } catch (Exception e3) {
                C3112bn.m18999a(this.f16870b, R.string.error);
            }
            return true;
        }
        if (str.equals("tools_replace")) {
            File file = new File(C3102bd.f18321d);
            File file2 = new File(C3102bd.f18278N);
            StringBuilder sb = new StringBuilder();
            sb.append(new StringBuffer().append("System: ").append(C3102bd.f18268D).toString()).append("\n");
            C1076d m8992a = C1076d.m8992a();
            if (file.isFile()) {
                try {
                    InterfaceC1075c m8994a = m8992a.m8994a(C3102bd.f18321d);
                    sb.append(new StringBuffer().append(new StringBuffer().append("aapt: \"").append(C3102bd.f18321d).toString()).append("\"").toString());
                    byte mo8990b = m8994a.mo8990b();
                    if (mo8990b != 0) {
                        sb.append(", ").append(mo8990b == 1 ? "32-bit" : "64-bit");
                    }
                    byte mo8991c = m8994a.mo8991c();
                    if (mo8991c != 0) {
                        sb.append(", ").append(mo8991c == 1 ? "LSB" : "MSB");
                    }
                    short mo9001a = m8994a.mo8989a().mo9001a();
                    if (mo9001a != 0) {
                        sb.append(", ").append(C1078f.m9003a(mo9001a));
                    }
                    short mo9002b = m8994a.mo8989a().mo9002b();
                    if (mo9002b != 0) {
                        sb.append(", ").append(C1078f.m9004b(mo9002b));
                    }
                    sb.append(", ").append(C3106bh.m18975a(file.length(), C3102bd.f18305am));
                    sb.append(", ").append(new StringBuffer().append("MD5: ").append(C3262u.m19572a(C3102bd.f18321d, KeyProperties.DIGEST_MD5)).toString());
                } catch (Error | Exception e4) {
                    C3112bn.m18999a(this.f16870b, R.string.error);
                    return true;
                }
            }
            if (file2.isFile()) {
                try {
                    InterfaceC1075c m8994a2 = m8992a.m8994a(C3102bd.f18278N);
                    sb.append("\n").append(new StringBuffer().append(new StringBuffer().append("aapt2: \"").append(C3102bd.f18278N).toString()).append("\"").toString());
                    byte mo8990b2 = m8994a2.mo8990b();
                    if (mo8990b2 != 0) {
                        sb.append(", ").append(mo8990b2 == 1 ? "32-bit" : "64-bit");
                    }
                    byte mo8991c2 = m8994a2.mo8991c();
                    if (mo8991c2 != 0) {
                        sb.append(", ").append(mo8991c2 == 1 ? "LSB" : "MSB");
                    }
                    short mo9001a2 = m8994a2.mo8989a().mo9001a();
                    if (mo9001a2 != 0) {
                        sb.append(", ").append(C1078f.m9003a(mo9001a2));
                    }
                    short mo9002b2 = m8994a2.mo8989a().mo9002b();
                    if (mo9002b2 != 0) {
                        sb.append(", ").append(C1078f.m9004b(mo9002b2));
                    }
                    sb.append(", ").append(C3106bh.m18975a(file2.length(), C3102bd.f18305am));
                    sb.append(", ").append(new StringBuffer().append("MD5: ").append(C3262u.m19572a(C3102bd.f18278N, KeyProperties.DIGEST_MD5)).toString());
                } catch (Error | Exception e5) {
                    C3112bn.m18999a(this.f16870b, R.string.error);
                    return true;
                }
            }
            String sb2 = sb.toString();
            new C3078aj(this.f16870b).m18494a(R.string.minfo).m18506d(R.string.f21470ok).m18505c(R.string.copy, new Runnable(this, sb2) { // from class: ru.maximoff.apktool.preference.CustomPreference.2

                /* renamed from: a */
                private final CustomPreference f16872a;

                /* renamed from: b */
                private final String f16873b;

                {
                    this.f16872a = this;
                    this.f16873b = sb2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C3112bn.m19002a(this.f16872a.f16870b, this.f16873b);
                }
            }).m18497a(true).m18496a(sb2).m18507d();
            return true;
        }
        if (!str.equals("man_frame")) {
            return false;
        }
        File file3 = new File(this.f16870b.getFilesDir(), "framework/main/1.apk");
        if (!file3.isFile()) {
            C3102bd.m18949e();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(new StringBuffer().append(new StringBuffer().append("Built-in framework: \"").append(file3.getAbsolutePath()).toString()).append("\", ").toString());
        try {
            C2604w c2604w = new C2604w(file3);
            Enumeration<C2602u> m16163b = c2604w.m16163b();
            while (true) {
                if (!m16163b.hasMoreElements()) {
                    i = 0;
                    break;
                }
                C2602u nextElement = m16163b.nextElement();
                if (AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME.equals(nextElement.getName())) {
                    i = C3080al.m18523a(c2604w.m16160a(nextElement));
                    break;
                }
            }
            c2604w.close();
        } catch (Error | Exception e6) {
            i = 0;
        }
        if (i > 0 && i <= 36) {
            sb3.append(String.format("SDK %d, %s", new Integer(i), C3106bh.m18975a(file3.length(), C3102bd.f18305am)));
        } else {
            sb3.append(String.format("Unknow SDK (%d), %s", new Integer(i), C3106bh.m18975a(file3.length(), C3102bd.f18305am)));
        }
        sb3.append(", ").append(new StringBuffer().append("MD5: ").append(C3262u.m19572a(file3.getAbsolutePath(), KeyProperties.DIGEST_MD5)).toString());
        String sb4 = sb3.toString();
        new C3078aj(this.f16870b).m18494a(R.string.minfo).m18506d(R.string.f21470ok).m18505c(R.string.copy, new Runnable(this, sb4) { // from class: ru.maximoff.apktool.preference.CustomPreference.3

            /* renamed from: a */
            private final CustomPreference f16874a;

            /* renamed from: b */
            private final String f16875b;

            {
                this.f16874a = this;
                this.f16875b = sb4;
            }

            @Override // java.lang.Runnable
            public void run() {
                C3112bn.m19002a(this.f16874a.f16870b, this.f16875b);
            }
        }).m18497a(true).m18496a(sb4).m18507d();
        return true;
    }
}
