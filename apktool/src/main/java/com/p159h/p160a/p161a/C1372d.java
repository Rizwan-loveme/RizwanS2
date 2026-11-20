package com.p159h.p160a.p161a;

import android.view.KeyEvent;

/* compiled from: KeysInterpreter.java */
/* renamed from: com.h.a.a.d */
/* loaded from: classes.dex */
public class C1372d {
    /* renamed from: a */
    public static char m10965a(KeyEvent keyEvent) {
        if (m10969e(keyEvent)) {
            return '\n';
        }
        if (m10968d(keyEvent)) {
            return '\b';
        }
        if (m10967c(keyEvent)) {
            return '\t';
        }
        if (m10970f(keyEvent)) {
            return ' ';
        }
        if (!keyEvent.isPrintingKey()) {
            return (char) 0;
        }
        return (char) keyEvent.getUnicodeChar(keyEvent.getMetaState());
    }

    /* renamed from: c */
    private static boolean m10967c(KeyEvent keyEvent) {
        return (keyEvent.isShiftPressed() && keyEvent.getKeyCode() == 62) || (keyEvent.getKeyCode() == 61 && keyEvent.getAction() == 0);
    }

    /* renamed from: d */
    private static boolean m10968d(KeyEvent keyEvent) {
        return keyEvent.getKeyCode() == 67 && keyEvent.getAction() == 0;
    }

    /* renamed from: e */
    private static boolean m10969e(KeyEvent keyEvent) {
        return keyEvent.getKeyCode() == 66 && keyEvent.getAction() == 0;
    }

    /* renamed from: f */
    private static boolean m10970f(KeyEvent keyEvent) {
        return keyEvent.getKeyCode() == 62 && keyEvent.getAction() == 0;
    }

    /* renamed from: b */
    public static boolean m10966b(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        return (keyCode == 20 || keyCode == 19 || keyCode == 22 || keyCode == 21 || keyCode == 123 || keyCode == 122) && keyEvent.getAction() == 0;
    }
}
