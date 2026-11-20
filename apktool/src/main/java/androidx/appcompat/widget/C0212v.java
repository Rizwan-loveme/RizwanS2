package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.p008os.Build;
import android.p008os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import android.widget.TextView;
import androidx.core.p031f.C0287c;
import androidx.core.p031f.C0308x;
import androidx.core.p031f.p033b.C0285b;
import androidx.core.p031f.p033b.C0286c;

/* compiled from: AppCompatReceiveContentHelper.java */
/* renamed from: androidx.appcompat.widget.v */
/* loaded from: classes.dex */
final class C0212v {
    /* renamed from: a */
    static boolean m1580a(TextView textView, int i) {
        if ((i != 16908322 && i != 16908337) || C0308x.m2270q(textView) == null) {
            return false;
        }
        ClipboardManager clipboardManager = (ClipboardManager) textView.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip == null || primaryClip.getItemCount() <= 0) {
            return true;
        }
        C0308x.m2224a(textView, new C0287c.a(primaryClip, 1).m2158a(i == 16908322 ? 0 : 1).m2161a());
        return true;
    }

    /* renamed from: a */
    static boolean m1579a(View view, DragEvent dragEvent) {
        boolean m1583a;
        if (Build.VERSION.SDK_INT < 24 || dragEvent.getLocalState() != null || C0308x.m2270q(view) == null) {
            return false;
        }
        Activity m1578a = m1578a(view);
        if (m1578a == null) {
            Log.m186i("ReceiveContent", "Can't handle drop: no activity: view=" + view);
            return false;
        }
        if (dragEvent.getAction() == 1) {
            return view instanceof TextView ? false : true;
        }
        if (dragEvent.getAction() != 3) {
            return false;
        }
        if (view instanceof TextView) {
            m1583a = a.m1584a(dragEvent, (TextView) view, m1578a);
        } else {
            m1583a = a.m1583a(dragEvent, view, m1578a);
        }
        return m1583a;
    }

    /* compiled from: AppCompatReceiveContentHelper.java */
    /* renamed from: androidx.appcompat.widget.v$a */
    private static final class a {
        /* renamed from: a */
        static boolean m1584a(DragEvent dragEvent, TextView textView, Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
            textView.beginBatchEdit();
            try {
                Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
                C0308x.m2224a(textView, new C0287c.a(dragEvent.getClipData(), 3).m2161a());
                textView.endBatchEdit();
                return true;
            } catch (Throwable th) {
                textView.endBatchEdit();
                throw th;
            }
        }

        /* renamed from: a */
        static boolean m1583a(DragEvent dragEvent, View view, Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            C0308x.m2224a(view, new C0287c.a(dragEvent.getClipData(), 3).m2161a());
            return true;
        }
    }

    /* renamed from: a */
    static Activity m1578a(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    /* renamed from: b */
    static C0285b.a m1581b(final View view) {
        return new C0285b.a() { // from class: androidx.appcompat.widget.v.1
            @Override // androidx.core.p031f.p033b.C0285b.a
            /* renamed from: a */
            public boolean mo1582a(C0286c c0286c, int i, Bundle bundle) {
                if (Build.VERSION.SDK_INT >= 25 && (i & 1) != 0) {
                    try {
                        c0286c.m2147e();
                        InputContentInfo inputContentInfo = (InputContentInfo) c0286c.m2146d();
                        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
                        bundle2.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo);
                        bundle = bundle2;
                    } catch (Exception e2) {
                        Log.m191w("ReceiveContent", "Can't insert content from IME; requestPermission() failed", e2);
                        return false;
                    }
                }
                return C0308x.m2224a(View.this, new C0287c.a(new ClipData(c0286c.m2144b(), new ClipData.Item(c0286c.m2143a())), 2).m2159a(c0286c.m2145c()).m2160a(bundle).m2161a()) == null;
            }
        };
    }
}
