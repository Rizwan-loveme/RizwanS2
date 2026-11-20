package androidx.appcompat.app;

import android.app.Dialog;
import android.p008os.Bundle;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0373d;

/* compiled from: AppCompatDialogFragment.java */
/* renamed from: androidx.appcompat.app.h */
/* loaded from: classes.dex */
public class C0076h extends DialogInterfaceOnCancelListenerC0373d {
    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0373d
    /* renamed from: a */
    public Dialog mo586a(Bundle bundle) {
        return new DialogC0075g(m2876n(), m2753a());
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0373d
    /* renamed from: a */
    public void mo587a(Dialog dialog, int i) {
        if (dialog instanceof DialogC0075g) {
            DialogC0075g dialogC0075g = (DialogC0075g) dialog;
            switch (i) {
                case 1:
                case 2:
                    break;
                case 3:
                    dialog.getWindow().addFlags(24);
                    break;
                default:
                    return;
            }
            dialogC0075g.m584b(1);
            return;
        }
        super.mo587a(dialog, i);
    }
}
