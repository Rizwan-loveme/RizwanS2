package ru.maximoff.apktool.util;

import android.content.Context;
import android.content.Intent;
import android.content.p006pm.ShortcutInfo;
import android.content.p006pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import com.srizwan.apktool.R;
import java.io.File;
import java.util.ArrayList;

/* compiled from: Shortcuts.java */
/* renamed from: ru.maximoff.apktool.util.be */
/* loaded from: classes.dex */
public class C3103be {

    /* renamed from: a */
    private final Context f18368a;

    /* renamed from: b */
    private final int[] f18369b;

    /* renamed from: c */
    private final ShortcutManager f18370c;

    public C3103be(Context context) {
        this.f18368a = context;
        this.f18370c = (ShortcutManager) this.f18368a.getSystemService("shortcut");
        if (C3102bd.m18925a(this.f18368a, "use_dark_icon", false)) {
            this.f18369b = new int[]{R.mipmap.ic_shortcut_converter_dark, R.mipmap.ic_shortcut_apps_dark, R.mipmap.ic_shortcut_storage_dark};
        } else {
            this.f18369b = new int[]{R.mipmap.ic_shortcut_converter, R.mipmap.ic_shortcut_apps, R.mipmap.ic_shortcut_storage};
        }
    }

    /* renamed from: a */
    public void m18955a() {
        this.f18370c.removeAllDynamicShortcuts();
        ArrayList arrayList = new ArrayList();
        String[] m19640b = C3262u.m19640b(this.f18368a);
        File file = new File(C3102bd.m18909a(this.f18368a, 0, m19640b));
        File file2 = new File(C3102bd.m18909a(this.f18368a, 1, m19640b));
        arrayList.add(m18954a(file.getName().isEmpty() ? file.getAbsolutePath() : file.getName(), file.getAbsolutePath(), 0, this.f18369b[2]));
        if (!file.equals(file2)) {
            arrayList.add(m18954a(file2.getName().isEmpty() ? file2.getAbsolutePath() : file2.getName(), file2.getAbsolutePath(), 1, this.f18369b[2]));
        }
        String string = this.f18368a.getString(R.string.apps);
        arrayList.add(m18954a(string, string, 2, this.f18369b[1]));
        this.f18370c.setDynamicShortcuts(arrayList);
    }

    /* renamed from: a */
    public ShortcutInfo m18954a(String str, String str2, int i, int i2) {
        if (str.isEmpty()) {
            str = this.f18368a.getString(R.string.files);
        }
        if (str2.isEmpty()) {
            str2 = this.f18368a.getString(R.string.files);
        }
        try {
            return new ShortcutInfo.Builder(this.f18368a, String.valueOf(i + 2)).setIntent(new Intent(Intent.ACTION_MAIN, (Uri) null, this.f18368a, Class.forName("ru.maximoff.apktool.SplashActivity")).addFlags(268435456).putExtra("start_tab", i)).setShortLabel(str).setLongLabel(str2).setIcon(Icon.createWithResource(this.f18368a, i2)).build();
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }
}
