package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.p030e.C0270e;

/* compiled from: AppCompatTextClassifierHelper.java */
/* renamed from: androidx.appcompat.widget.z */
/* loaded from: classes.dex */
final class C0216z {

    /* renamed from: a */
    private TextView f1781a;

    /* renamed from: b */
    private TextClassifier f1782b;

    C0216z(TextView textView) {
        this.f1781a = (TextView) C0270e.m1960a(textView);
    }

    /* renamed from: a */
    public void m1611a(TextClassifier textClassifier) {
        this.f1782b = textClassifier;
    }

    /* renamed from: a */
    public TextClassifier m1610a() {
        if (this.f1782b == null) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) this.f1781a.getContext().getSystemService(TextClassificationManager.class);
            if (textClassificationManager != null) {
                return textClassificationManager.getTextClassifier();
            }
            return TextClassifier.NO_OP;
        }
        return this.f1782b;
    }
}
