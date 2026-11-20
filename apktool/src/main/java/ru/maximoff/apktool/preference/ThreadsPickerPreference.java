package ru.maximoff.apktool.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import ru.maximoff.apktool.util.C3080al;

/* loaded from: classes.dex */
public class ThreadsPickerPreference extends CustomPreference {

    /* renamed from: a */
    private int f17083a;

    /* renamed from: b */
    private int f17084b;

    /* renamed from: c */
    private int f17085c;

    public ThreadsPickerPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17083a = 1;
        this.f17084b = 8;
    }

    /* renamed from: a */
    private boolean m18143a() {
        if (!getKey().equals("threads_count")) {
            return false;
        }
        this.f17085c = R.string.threads_count;
        this.f17083a = 1;
        this.f17084b = Runtime.getRuntime().availableProcessors();
        if (this.f17084b > 0) {
            return true;
        }
        this.f17084b = 4;
        return true;
    }

    @Override // android.preference.Preference
    protected void onClick() {
        if (m18143a()) {
            Context context = getContext();
            String[] strArr = {context.getString(R.string.build_smali), context.getString(R.string.decode_smali), context.getString(R.string.mantisplit), context.getString(R.string.others)};
            new DialogInterfaceC0070b.a(context).m418a(R.string.threads_count).m431a(strArr, new DialogInterface.OnClickListener(this, context, strArr) { // from class: ru.maximoff.apktool.preference.ThreadsPickerPreference.1

                /* renamed from: a */
                private final ThreadsPickerPreference f17086a;

                /* renamed from: b */
                private final Context f17087b;

                /* renamed from: c */
                private final String[] f17088c;

                {
                    this.f17086a = this;
                    this.f17087b = context;
                    this.f17088c = strArr;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    String str;
                    int i2;
                    dialogInterface.cancel();
                    switch (i) {
                        case 1:
                            str = "threads_baksmali";
                            i2 = Math.min(6, this.f17086a.f17084b);
                            break;
                        case 2:
                            str = "threads_antisplit";
                            i2 = this.f17086a.f17084b;
                            break;
                        case 3:
                            str = "threads_others";
                            i2 = this.f17086a.f17084b;
                            break;
                        default:
                            str = "threads_smali";
                            i2 = Math.min(4, this.f17086a.f17084b);
                            break;
                    }
                    C3080al.m18548a(this.f17087b, this.f17086a.f17083a, this.f17086a.f17084b, i2, str, this.f17088c[i], (Runnable) null);
                }
            }).m420a(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
        }
    }
}
