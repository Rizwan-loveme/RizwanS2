package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.p008os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.C0059a;
import androidx.appcompat.app.AlertController;

/* compiled from: AlertDialog.java */
/* renamed from: androidx.appcompat.app.b */
/* loaded from: classes.dex */
public class DialogInterfaceC0070b extends DialogC0075g implements DialogInterface {

    /* renamed from: a */
    final AlertController f545a;

    protected DialogInterfaceC0070b(Context context, int i) {
        super(context, m413a(context, i));
        this.f545a = new AlertController(getContext(), this, getWindow());
    }

    /* renamed from: a */
    static int m413a(Context context, int i) {
        if (((i >>> 24) & 255) < 1) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(C0059a.a.alertDialogTheme, typedValue, true);
            return typedValue.resourceId;
        }
        return i;
    }

    /* renamed from: a */
    public Button m414a(int i) {
        return this.f545a.m378d(i);
    }

    /* renamed from: a */
    public ListView m415a() {
        return this.f545a.m371b();
    }

    @Override // androidx.appcompat.app.DialogC0075g, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f545a.m369a(charSequence);
    }

    /* renamed from: a */
    public void m416a(CharSequence charSequence) {
        this.f545a.m374b(charSequence);
    }

    @Override // androidx.appcompat.app.DialogC0075g, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f545a.m364a();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f545a.m370a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f545a.m375b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* compiled from: AlertDialog.java */
    /* renamed from: androidx.appcompat.app.b$a */
    public static class a {

        /* renamed from: a */
        private final AlertController.C0066a f546a;

        /* renamed from: b */
        private final int f547b;

        public a(Context context) {
            this(context, DialogInterfaceC0070b.m413a(context, 0));
        }

        public a(Context context, int i) {
            this.f546a = new AlertController.C0066a(new ContextThemeWrapper(context, DialogInterfaceC0070b.m413a(context, i)));
            this.f547b = i;
        }

        /* renamed from: a */
        public Context m417a() {
            return this.f546a.f505a;
        }

        /* renamed from: a */
        public a m418a(int i) {
            this.f546a.f510f = this.f546a.f505a.getText(i);
            return this;
        }

        /* renamed from: a */
        public a m427a(CharSequence charSequence) {
            this.f546a.f510f = charSequence;
            return this;
        }

        /* renamed from: a */
        public a m424a(View view) {
            this.f546a.f511g = view;
            return this;
        }

        /* renamed from: b */
        public a m433b(int i) {
            this.f546a.f512h = this.f546a.f505a.getText(i);
            return this;
        }

        /* renamed from: b */
        public a m436b(CharSequence charSequence) {
            this.f546a.f512h = charSequence;
            return this;
        }

        /* renamed from: c */
        public a m439c(int i) {
            this.f546a.f507c = i;
            return this;
        }

        /* renamed from: a */
        public a m423a(Drawable drawable) {
            this.f546a.f508d = drawable;
            return this;
        }

        /* renamed from: a */
        public a m420a(int i, DialogInterface.OnClickListener onClickListener) {
            this.f546a.f513i = this.f546a.f505a.getText(i);
            this.f546a.f515k = onClickListener;
            return this;
        }

        /* renamed from: b */
        public a m434b(int i, DialogInterface.OnClickListener onClickListener) {
            this.f546a.f516l = this.f546a.f505a.getText(i);
            this.f546a.f518n = onClickListener;
            return this;
        }

        /* renamed from: a */
        public a m428a(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f546a.f516l = charSequence;
            this.f546a.f518n = onClickListener;
            return this;
        }

        /* renamed from: c */
        public a m440c(int i, DialogInterface.OnClickListener onClickListener) {
            this.f546a.f519o = this.f546a.f505a.getText(i);
            this.f546a.f521q = onClickListener;
            return this;
        }

        /* renamed from: b */
        public a m437b(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f546a.f519o = charSequence;
            this.f546a.f521q = onClickListener;
            return this;
        }

        /* renamed from: a */
        public a m429a(boolean z) {
            this.f546a.f522r = z;
            return this;
        }

        /* renamed from: a */
        public a m421a(DialogInterface.OnCancelListener onCancelListener) {
            this.f546a.f523s = onCancelListener;
            return this;
        }

        /* renamed from: a */
        public a m422a(DialogInterface.OnKeyListener onKeyListener) {
            this.f546a.f525u = onKeyListener;
            return this;
        }

        /* renamed from: a */
        public a m431a(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            this.f546a.f526v = charSequenceArr;
            this.f546a.f528x = onClickListener;
            return this;
        }

        /* renamed from: a */
        public a m426a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            this.f546a.f527w = listAdapter;
            this.f546a.f528x = onClickListener;
            return this;
        }

        /* renamed from: a */
        public a m432a(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f546a.f526v = charSequenceArr;
            this.f546a.f498J = onMultiChoiceClickListener;
            this.f546a.f494F = zArr;
            this.f546a.f495G = true;
            return this;
        }

        /* renamed from: a */
        public a m419a(int i, int i2, DialogInterface.OnClickListener onClickListener) {
            this.f546a.f526v = this.f546a.f505a.getResources().getTextArray(i);
            this.f546a.f528x = onClickListener;
            this.f546a.f497I = i2;
            this.f546a.f496H = true;
            return this;
        }

        /* renamed from: a */
        public a m430a(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            this.f546a.f526v = charSequenceArr;
            this.f546a.f528x = onClickListener;
            this.f546a.f497I = i;
            this.f546a.f496H = true;
            return this;
        }

        /* renamed from: a */
        public a m425a(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            this.f546a.f527w = listAdapter;
            this.f546a.f528x = onClickListener;
            this.f546a.f497I = i;
            this.f546a.f496H = true;
            return this;
        }

        /* renamed from: b */
        public a m435b(View view) {
            this.f546a.f530z = view;
            this.f546a.f529y = 0;
            this.f546a.f493E = false;
            return this;
        }

        /* renamed from: b */
        public DialogInterfaceC0070b m438b() {
            DialogInterfaceC0070b dialogInterfaceC0070b = new DialogInterfaceC0070b(this.f546a.f505a, this.f547b);
            this.f546a.m382a(dialogInterfaceC0070b.f545a);
            dialogInterfaceC0070b.setCancelable(this.f546a.f522r);
            if (this.f546a.f522r) {
                dialogInterfaceC0070b.setCanceledOnTouchOutside(true);
            }
            dialogInterfaceC0070b.setOnCancelListener(this.f546a.f523s);
            dialogInterfaceC0070b.setOnDismissListener(this.f546a.f524t);
            if (this.f546a.f525u != null) {
                dialogInterfaceC0070b.setOnKeyListener(this.f546a.f525u);
            }
            return dialogInterfaceC0070b;
        }

        /* renamed from: c */
        public DialogInterfaceC0070b m441c() {
            DialogInterfaceC0070b m438b = m438b();
            m438b.show();
            return m438b;
        }
    }
}
