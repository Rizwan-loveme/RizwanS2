package ru.maximoff.apktool.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;

/* loaded from: classes.dex */
public class MultiPreference extends CustomPreference {

    /* renamed from: a */
    private int f17004a;

    /* renamed from: b */
    private boolean f17005b;

    /* renamed from: c */
    private String[] f17006c;

    /* renamed from: d */
    private String[] f17007d;

    public MultiPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17004a = 0;
        this.f17005b = false;
    }

    /* renamed from: a */
    private boolean m18121a(Context context) {
        String key = getKey();
        if (key.equals("checksum_format")) {
            this.f17005b = false;
            this.f17004a = R.string.checksum_format;
            this.f17006c = context.getResources().getStringArray(R.array.checksum_names);
            this.f17007d = context.getResources().getStringArray(R.array.checksum_keys);
            return this.f17006c.length == this.f17007d.length;
        }
        if (key.equals("tooltips")) {
            this.f17005b = true;
            this.f17004a = R.string.tooltips;
            this.f17006c = context.getResources().getStringArray(R.array.tooltips_names);
            this.f17007d = context.getResources().getStringArray(R.array.tooltips_keys);
            return this.f17006c.length == this.f17007d.length;
        }
        if (!key.equals("jadx_settings")) {
            return false;
        }
        this.f17005b = false;
        this.f17004a = R.string.jadx_settings;
        this.f17006c = context.getResources().getStringArray(R.array.jadx_sets);
        this.f17007d = context.getResources().getStringArray(R.array.jadx_sets_keys);
        return this.f17006c.length == this.f17007d.length;
    }

    @Override // android.preference.Preference
    protected void onClick() {
        Context context = getContext();
        if (m18121a(context)) {
            String key = getKey();
            SharedPreferences sharedPreferences = getSharedPreferences();
            boolean[] zArr = new boolean[this.f17007d.length];
            int i = 0;
            while (i < this.f17007d.length) {
                if (key.equals("jadx_settings")) {
                    zArr[i] = sharedPreferences.getBoolean(this.f17007d[i], i == this.f17007d.length + (-1));
                } else {
                    zArr[i] = sharedPreferences.getBoolean(this.f17007d[i], this.f17005b);
                }
                i++;
            }
            new DialogInterfaceC0070b.a(context).m418a(this.f17004a).m432a(this.f17006c, zArr, new DialogInterface.OnMultiChoiceClickListener(this, zArr) { // from class: ru.maximoff.apktool.preference.MultiPreference.1

                /* renamed from: a */
                private final MultiPreference f17008a;

                /* renamed from: b */
                private final boolean[] f17009b;

                {
                    this.f17008a = this;
                    this.f17009b = zArr;
                }

                @Override // android.content.DialogInterface.OnMultiChoiceClickListener
                public void onClick(DialogInterface dialogInterface, int i2, boolean z) {
                    this.f17009b[i2] = z;
                }
            }).m420a(R.string.save, new DialogInterface.OnClickListener(this, sharedPreferences, zArr) { // from class: ru.maximoff.apktool.preference.MultiPreference.2

                /* renamed from: a */
                private final MultiPreference f17010a;

                /* renamed from: b */
                private final SharedPreferences f17011b;

                /* renamed from: c */
                private final boolean[] f17012c;

                {
                    this.f17010a = this;
                    this.f17011b = sharedPreferences;
                    this.f17012c = zArr;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    SharedPreferences.Editor edit = this.f17011b.edit();
                    for (int i3 = 0; i3 < this.f17010a.f17007d.length; i3++) {
                        edit.putBoolean(this.f17010a.f17007d[i3], this.f17012c[i3]);
                    }
                    edit.commit();
                }
            }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.search_reset, new DialogInterface.OnClickListener(this, sharedPreferences, key) { // from class: ru.maximoff.apktool.preference.MultiPreference.3

                /* renamed from: a */
                private final MultiPreference f17013a;

                /* renamed from: b */
                private final SharedPreferences f17014b;

                /* renamed from: c */
                private final String f17015c;

                {
                    this.f17013a = this;
                    this.f17014b = sharedPreferences;
                    this.f17015c = key;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    SharedPreferences.Editor edit = this.f17014b.edit();
                    int i3 = 0;
                    while (i3 < this.f17013a.f17007d.length) {
                        if (this.f17015c.equals("jadx_settings")) {
                            edit.putBoolean(this.f17013a.f17007d[i3], i3 == this.f17013a.f17007d.length + (-1));
                        } else {
                            edit.putBoolean(this.f17013a.f17007d[i3], this.f17013a.f17005b);
                        }
                        i3++;
                    }
                    edit.commit();
                }
            }).m438b().show();
        }
    }
}
