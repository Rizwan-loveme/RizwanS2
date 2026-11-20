package com.p159h.p160a.p162b;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.srizwan.apktool.R;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.util.C3112bn;

/* compiled from: Clipboard.java */
/* renamed from: com.h.a.b.b */
/* loaded from: classes.dex */
public class C1380b {
    /* renamed from: a */
    public static void m11007a(ClipboardManager clipboardManager, CharSequence charSequence) {
        try {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("Apktool_M", charSequence));
        } catch (Exception e2) {
            C3112bn.m18999a(MainActivity.m16615o(), R.string.error);
        }
    }

    /* renamed from: a */
    public static CharSequence m11006a(ClipboardManager clipboardManager, Context context) {
        try {
            ClipData primaryClip = clipboardManager.getPrimaryClip();
            if (primaryClip != null) {
                return primaryClip.getItemAt(0).coerceToText(context);
            }
        } catch (Exception e2) {
            C3112bn.m18999a(MainActivity.m16615o(), R.string.error);
        }
        return (CharSequence) null;
    }
}
