package ru.maximoff.apktool.util;

import android.content.Context;
import android.graphics.Color;
import com.p159h.p160a.p162b.AbstractC1381c;
import com.srizwan.apktool.R;
import java.p209io.File;
import org.p270e.C2468c;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.util.p303a.C3061a;

/* compiled from: EditorTheme.java */
/* renamed from: ru.maximoff.apktool.util.o */
/* loaded from: classes.dex */
public class C3255o {

    /* renamed from: b */
    public static File f19671b;

    /* renamed from: a */
    public final String[] f19672a = {"FOREGROUND", "BACKGROUND", "SELECTION_FOREGROUND", "SELECTION_BACKGROUND", "CARET_BACKGROUND", "CARET_DISABLED", "LINE_HIGHLIGHT", "NON_PRINTING_GLYPH", "COMMENT", "KEYWORD", "NAME", "LITERAL", "OPERATOR", "SEPARATOR", "PACKAGE", "TYPE", "LINENUMBER_BG", "LINENUMBER_FG", "ERROR", "HEXHL"};

    public C3255o() {
        if (C3102bd.f18277M == null) {
            try {
                MainActivity m16615o = MainActivity.m16615o();
                C3102bd.m18929b(m16615o, m16615o.getAssets(), m16615o.getFilesDir());
                f19671b = new File(C3102bd.f18277M);
                return;
            } catch (Exception e2) {
                f19671b = (File) null;
                return;
            }
        }
        f19671b = new File(C3102bd.f18277M);
    }

    /* renamed from: a */
    public static int m19514a(String str, int i) {
        String str2;
        try {
            String m18332i = C3061a.m18332i(f19671b);
            switch (i) {
                case 1:
                    str2 = "DARK";
                    break;
                case 2:
                    str2 = "BLACK";
                    break;
                default:
                    str2 = "LIGHT";
                    break;
            }
            C2468c m15616e = new C2468c(m18332i).m15616e(str);
            if (i == 2 && !m15616e.m15618g(str2)) {
                str2 = "DARK";
            }
            return Color.parseColor(m15616e.m15617f(str2));
        } catch (Exception e2) {
            if (i == 0) {
                return -16777216;
            }
            return -1;
        }
    }

    /* renamed from: a */
    public boolean m19516a(File file) {
        try {
            C2468c c2468c = new C2468c(C3061a.m18332i(file));
            for (int i = 0; i < this.f19672a.length; i++) {
                if (!c2468c.m15618g(this.f19672a[i])) {
                    return false;
                }
                C2468c m15616e = c2468c.m15616e(this.f19672a[i]);
                if (!m15616e.m15618g("LIGHT") || !m15616e.m15618g("DARK")) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: a */
    public void m19515a(Context context, File file) {
        boolean z = false;
        try {
            if (m19516a(file)) {
                String name = file.getName();
                String m19033h = C3112bn.m19033h(C3262u.m19566a(context, f19671b.getParent(), name.substring(0, name.lastIndexOf(46)), ".json", 0));
                File file2 = new File(new StringBuffer().append(new StringBuffer().append(f19671b.getParent()).append("/").toString()).append(m19033h).toString());
                if (C3262u.m19612a(file, file2)) {
                    C3102bd.f18276L = m19033h.substring(0, m19033h.length() - 5);
                    C3102bd.f18277M = file2.getAbsolutePath();
                    C3102bd.m18937b(context, "editor_theme", C3102bd.f18276L);
                    z = true;
                }
            }
        } catch (Exception e2) {
        }
        if (z) {
            C3112bn.m19023b(context, context.getString(R.string.complete));
            AbstractC1381c.a.m11011a();
            MainActivity.m16615o().recreate();
            return;
        }
        C3112bn.m19023b(context, context.getString(R.string.error));
    }
}
