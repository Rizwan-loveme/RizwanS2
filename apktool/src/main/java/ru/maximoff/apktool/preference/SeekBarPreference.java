package ru.maximoff.apktool.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.icu.text.DateFormat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;

/* loaded from: classes.dex */
public class SeekBarPreference extends CustomPreference {

    /* renamed from: a */
    private int f17034a;

    /* renamed from: b */
    private int f17035b;

    /* renamed from: c */
    private int f17036c;

    /* renamed from: d */
    private int f17037d;

    /* renamed from: e */
    private int f17038e;

    /* renamed from: f */
    private String f17039f;

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17034a = 0;
        this.f17035b = 0;
        this.f17036c = 0;
        this.f17037d = 1;
        this.f17038e = 0;
        this.f17039f = "";
    }

    /* renamed from: a */
    private boolean m18131a() {
        String key = getKey();
        if (key.equals("drawer_width")) {
            this.f17038e = R.string.drawer_width;
            this.f17034a = 80;
            this.f17035b = 50;
            this.f17036c = 100;
            this.f17037d = 1;
            this.f17039f = "%";
            return true;
        }
        if (!key.equals("hl_time")) {
            return false;
        }
        this.f17038e = R.string.hl_time;
        this.f17034a = 7;
        this.f17035b = 0;
        this.f17036c = 35;
        this.f17037d = 100;
        this.f17039f = DateFormat.MINUTE_SECOND;
        return true;
    }

    @Override // android.preference.Preference
    protected void onClick() {
        if (m18131a()) {
            Context context = getContext();
            String key = getKey();
            int i = getSharedPreferences().getInt(key, this.f17034a * this.f17037d);
            int i2 = (i < this.f17035b * this.f17037d || i > this.f17036c * this.f17037d) ? this.f17034a * this.f17037d : i;
            View inflate = LayoutInflater.from(context).inflate(R.layout.seekbar, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.seekbarTextView1);
            textView.setText(new StringBuffer().append(i2).append(this.f17039f).toString());
            SeekBar seekBar = (SeekBar) inflate.findViewById(R.id.seekbarSeekBar1);
            seekBar.setMax(this.f17036c - this.f17035b);
            seekBar.setProgress((i2 / this.f17037d) - this.f17035b);
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(this, textView) { // from class: ru.maximoff.apktool.preference.SeekBarPreference.1

                /* renamed from: a */
                private final SeekBarPreference f17040a;

                /* renamed from: b */
                private final TextView f17041b;

                {
                    this.f17040a = this;
                    this.f17041b = textView;
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStartTrackingTouch(SeekBar seekBar2) {
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStopTrackingTouch(SeekBar seekBar2) {
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onProgressChanged(SeekBar seekBar2, int i3, boolean z) {
                    this.f17041b.setText(new StringBuffer().append((this.f17040a.f17035b + i3) * this.f17040a.f17037d).append(this.f17040a.f17039f).toString());
                }
            });
            textView.setOnLongClickListener(new ViewOnLongClickListenerC30382(this, context, seekBar));
            DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(context);
            aVar.m435b(inflate);
            aVar.m418a(this.f17038e);
            aVar.m434b(R.string.cancel, (DialogInterface.OnClickListener) null);
            aVar.m420a(R.string.save, new DialogInterface.OnClickListener(this, seekBar, key) { // from class: ru.maximoff.apktool.preference.SeekBarPreference.3

                /* renamed from: a */
                private final SeekBarPreference f17052a;

                /* renamed from: b */
                private final SeekBar f17053b;

                /* renamed from: c */
                private final String f17054c;

                {
                    this.f17052a = this;
                    this.f17053b = seekBar;
                    this.f17054c = key;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    int progress = this.f17053b.getProgress();
                    SharedPreferences.Editor edit = this.f17052a.getSharedPreferences().edit();
                    edit.putInt(this.f17054c, (progress + this.f17052a.f17035b) * this.f17052a.f17037d);
                    edit.commit();
                }
            });
            aVar.m440c(R.string.search_reset, new DialogInterface.OnClickListener(this, key) { // from class: ru.maximoff.apktool.preference.SeekBarPreference.4

                /* renamed from: a */
                private final SeekBarPreference f17055a;

                /* renamed from: b */
                private final String f17056b;

                {
                    this.f17055a = this;
                    this.f17056b = key;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    SharedPreferences.Editor edit = this.f17055a.getSharedPreferences().edit();
                    edit.remove(this.f17056b);
                    edit.commit();
                }
            });
            aVar.m438b().show();
        }
    }

    /* renamed from: ru.maximoff.apktool.preference.SeekBarPreference$2 */
    class ViewOnLongClickListenerC30382 implements View.OnLongClickListener {

        /* renamed from: a */
        private final SeekBarPreference f17042a;

        /* renamed from: b */
        private final Context f17043b;

        /* renamed from: c */
        private final SeekBar f17044c;

        ViewOnLongClickListenerC30382(SeekBarPreference seekBarPreference, Context context, SeekBar seekBar) {
            this.f17042a = seekBarPreference;
            this.f17043b = context;
            this.f17044c = seekBar;
        }

        /* renamed from: a */
        static SeekBarPreference m18135a(ViewOnLongClickListenerC30382 viewOnLongClickListenerC30382) {
            return viewOnLongClickListenerC30382.f17042a;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            View inflate = LayoutInflater.from(this.f17043b).inflate(R.layout.rename_one, (ViewGroup) null);
            ((LinearLayout) inflate.findViewById(R.id.renameoneLinearLayout1)).setVisibility(8);
            EditText editText = (EditText) inflate.findViewById(R.id.renameoneEditText1);
            int progress = this.f17044c.getProgress();
            editText.setSingleLine(true);
            editText.setInputType(8194);
            editText.setText(String.valueOf((this.f17042a.f17035b + progress) * this.f17042a.f17037d));
            editText.setHint(String.valueOf((this.f17042a.f17035b + progress) * this.f17042a.f17037d));
            DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f17043b).m435b(inflate).m427a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f17042a.f17035b * this.f17042a.f17037d).append(" - ").toString()).append(this.f17042a.f17036c * this.f17042a.f17037d).toString()).append(" (").toString()).append(this.f17042a.f17039f).toString()).append(")").toString()).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, editText, progress, this.f17044c) { // from class: ru.maximoff.apktool.preference.SeekBarPreference.2.1

                /* renamed from: a */
                private final ViewOnLongClickListenerC30382 f17045a;

                /* renamed from: b */
                private final EditText f17046b;

                /* renamed from: c */
                private final int f17047c;

                /* renamed from: d */
                private final SeekBar f17048d;

                {
                    this.f17045a = this;
                    this.f17046b = editText;
                    this.f17047c = progress;
                    this.f17048d = r4;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    try {
                        int abs = Math.abs(Integer.parseInt(this.f17046b.getText().toString())) / ViewOnLongClickListenerC30382.m18135a(this.f17045a).f17037d;
                        if (abs > ViewOnLongClickListenerC30382.m18135a(this.f17045a).f17036c || abs < ViewOnLongClickListenerC30382.m18135a(this.f17045a).f17035b) {
                            abs = this.f17047c + ViewOnLongClickListenerC30382.m18135a(this.f17045a).f17035b;
                        }
                        this.f17048d.setProgress(abs - ViewOnLongClickListenerC30382.m18135a(this.f17045a).f17035b);
                    } catch (Exception e2) {
                    }
                    dialogInterface.dismiss();
                }
            }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
            m438b.getWindow().setSoftInputMode(4);
            m438b.setOnShowListener(new DialogInterface.OnShowListener(this, editText, progress) { // from class: ru.maximoff.apktool.preference.SeekBarPreference.2.2

                /* renamed from: a */
                private final ViewOnLongClickListenerC30382 f17049a;

                /* renamed from: b */
                private final EditText f17050b;

                /* renamed from: c */
                private final int f17051c;

                {
                    this.f17049a = this;
                    this.f17050b = editText;
                    this.f17051c = progress;
                }

                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    this.f17050b.requestFocus();
                    this.f17050b.setSelection(String.valueOf((this.f17051c + ViewOnLongClickListenerC30382.m18135a(this.f17049a).f17035b) * ViewOnLongClickListenerC30382.m18135a(this.f17049a).f17037d).length());
                }
            });
            m438b.show();
            return true;
        }
    }
}
