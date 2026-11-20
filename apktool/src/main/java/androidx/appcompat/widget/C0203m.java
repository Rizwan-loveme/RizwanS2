package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* compiled from: AppCompatHintHelper.java */
/* renamed from: androidx.appcompat.widget.m */
/* loaded from: classes.dex */
class C0203m {
    /* renamed from: a */
    static InputConnection m1560a(InputConnection inputConnection, EditorInfo editorInfo, View view) {
        if (inputConnection != null && editorInfo.hintText == null) {
            ViewParent parent = view.getParent();
            while (true) {
                if (!(parent instanceof View)) {
                    break;
                }
                if (parent instanceof InterfaceC0192bg) {
                    editorInfo.hintText = ((InterfaceC0192bg) parent).m1483a();
                    break;
                }
                parent = parent.getParent();
            }
        }
        return inputConnection;
    }
}
