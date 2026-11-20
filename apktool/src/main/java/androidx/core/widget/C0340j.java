package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.core.p031f.C0287c;
import androidx.core.p031f.InterfaceC0303s;

/* compiled from: TextViewOnReceiveContentListener.java */
/* renamed from: androidx.core.widget.j */
/* loaded from: classes.dex */
public final class C0340j implements InterfaceC0303s {
    @Override // androidx.core.p031f.InterfaceC0303s
    /* renamed from: a */
    public C0287c mo2208a(View view, C0287c c0287c) {
        boolean z = false;
        if (Log.isLoggable("ReceiveContent", 3)) {
            Log.m182d("ReceiveContent", "onReceive: " + c0287c);
        }
        if (c0287c.m2156b() != 2) {
            ClipData m2155a = c0287c.m2155a();
            int m2157c = c0287c.m2157c();
            TextView textView = (TextView) view;
            Editable editable = (Editable) textView.getText();
            Context context = textView.getContext();
            int i = 0;
            while (true) {
                boolean z2 = z;
                if (i < m2155a.getItemCount()) {
                    CharSequence m2532a = m2532a(context, m2155a.getItemAt(i), m2157c);
                    if (m2532a != null) {
                        if (!z2) {
                            m2533a(editable, m2532a);
                            z2 = true;
                        } else {
                            editable.insert(Selection.getSelectionEnd(editable), "\n");
                            editable.insert(Selection.getSelectionEnd(editable), m2532a);
                        }
                    }
                    z = z2;
                    i++;
                } else {
                    return null;
                }
            }
        } else {
            return c0287c;
        }
    }

    /* renamed from: a */
    private static CharSequence m2532a(Context context, ClipData.Item item, int i) {
        return Build.VERSION.SDK_INT >= 16 ? a.m2534a(context, item, i) : b.m2535a(context, item, i);
    }

    /* renamed from: a */
    private static void m2533a(Editable editable, CharSequence charSequence) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int max = Math.max(0, Math.min(selectionStart, selectionEnd));
        int max2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, max2);
        editable.replace(max, max2, charSequence);
    }

    /* compiled from: TextViewOnReceiveContentListener.java */
    /* renamed from: androidx.core.widget.j$a */
    private static final class a {
        /* renamed from: a */
        static CharSequence m2534a(Context context, ClipData.Item item, int i) {
            if ((i & 1) == 0) {
                return item.coerceToStyledText(context);
            }
            CharSequence coerceToText = item.coerceToText(context);
            return coerceToText instanceof Spanned ? coerceToText.toString() : coerceToText;
        }
    }

    /* compiled from: TextViewOnReceiveContentListener.java */
    /* renamed from: androidx.core.widget.j$b */
    private static final class b {
        /* renamed from: a */
        static CharSequence m2535a(Context context, ClipData.Item item, int i) {
            CharSequence coerceToText = item.coerceToText(context);
            if ((i & 1) != 0 && (coerceToText instanceof Spanned)) {
                return coerceToText.toString();
            }
            return coerceToText;
        }
    }
}
