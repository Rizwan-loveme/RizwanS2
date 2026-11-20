package ru.maximoff.color;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.p306d.C3212b;
import ru.maximoff.apktool.view.CustomListView;
import ru.maximoff.color.ColorPickerView;

/* compiled from: Picker.java */
/* renamed from: ru.maximoff.color.c */
/* loaded from: classes.dex */
public class C3321c {

    /* renamed from: a */
    private a f21362a;

    /* renamed from: b */
    private String f21363b = (String) null;

    /* renamed from: c */
    private int f21364c = -16777216;

    /* renamed from: d */
    private String f21365d = m20112d(String.format("#%08x", new Integer(this.f21364c & (-1))));

    /* renamed from: e */
    private boolean f21366e = false;

    /* renamed from: f */
    private Context f21367f;

    /* compiled from: Picker.java */
    /* renamed from: ru.maximoff.color.c$a */
    public interface a {
        /* renamed from: a */
        void mo16419a();

        /* renamed from: a */
        void mo16420a(int i);

        /* renamed from: a */
        void mo16421a(String str);

        /* renamed from: b */
        void mo16422b(String str);
    }

    public C3321c(Context context) {
        this.f21367f = context;
    }

    /* renamed from: a */
    public C3321c m20106a(String str) {
        try {
            this.f21364c = Color.parseColor(str);
        } catch (Exception e2) {
        }
        return this;
    }

    /* renamed from: a */
    public C3321c m20105a(int i) {
        this.f21364c = i;
        return this;
    }

    /* renamed from: a */
    public C3321c m20107a(a aVar) {
        this.f21362a = aVar;
        return this;
    }

    /* renamed from: b */
    public C3321c m20108b(String str) {
        this.f21363b = str;
        return this;
    }

    /* renamed from: a */
    public C3321c m20104a() {
        this.f21366e = true;
        return this;
    }

    /* renamed from: c */
    public String m20110c(String str) {
        String str2 = "";
        if (str.startsWith("-")) {
            str = str.substring(1);
            str2 = "-";
        }
        if (str.startsWith("0x")) {
            str = str.substring(2);
        }
        return String.format("#%08x", new Integer(Integer.parseInt(new StringBuffer().append(str2).append(str).toString(), 16) & (-1)));
    }

    /* renamed from: d */
    public String m20112d(String str) {
        if (!str.startsWith("#")) {
            str = new StringBuffer().append("#").append(str).toString();
        }
        int parseColor = Color.parseColor(str);
        if (Color.alpha(parseColor) >= 128) {
            return new StringBuffer().append("-0x").append(Integer.toHexString(parseColor * (-1))).toString();
        }
        return new StringBuffer().append("0x").append(Integer.toHexString(parseColor)).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public int m20097b(int i) {
        return Color.argb(Color.alpha(i), 255 - Color.red(i), 255 - Color.green(i), 255 - Color.blue(i));
    }

    /* renamed from: b */
    public void m20109b() {
        if (C3102bd.m18925a(this.f21367f, "old_picker", false)) {
            m20113d();
        } else {
            m20111c();
        }
    }

    /* renamed from: c */
    public void m20111c() {
        int i;
        int i2;
        int i3;
        String format = String.format("#%08x", new Integer(this.f21364c & (-1)));
        String m20112d = m20112d(format);
        if (C3102bd.f18291a) {
            i = R.drawable.ic_invert;
            i2 = -12303292;
            i3 = R.drawable.ic_preset;
        } else {
            i = R.drawable.ic_invert_dark;
            i2 = -3355444;
            i3 = R.drawable.ic_preset_dark;
        }
        C3212b c3212b = new C3212b(this.f21367f, "favorites_colors");
        View inflate = LayoutInflater.from(this.f21367f).inflate(R.layout.maximoff_picker, (ViewGroup) null);
        EditText editText = (EditText) inflate.findViewById(R.id.pickerEditText1);
        EditText editText2 = (EditText) inflate.findViewById(R.id.pickerEditText2);
        editText2.setVisibility(this.f21366e ? 0 : 8);
        editText2.setEnabled(this.f21366e);
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.pickerButton1);
        ImageButton imageButton2 = (ImageButton) inflate.findViewById(R.id.pickerButton2);
        ColorPickerView colorPickerView = (ColorPickerView) inflate.findViewById(R.id.pickerView);
        ColorPickerPanelView colorPickerPanelView = (ColorPickerPanelView) inflate.findViewById(R.id.pickerOldColor);
        ColorPickerPanelView colorPickerPanelView2 = (ColorPickerPanelView) inflate.findViewById(R.id.pickerNewColor);
        imageButton.setImageResource(i3);
        imageButton2.setImageResource(i);
        editText.setText(format);
        editText.setHint(format);
        editText.addTextChangedListener(new TextWatcher(this, editText, editText2, colorPickerView, colorPickerPanelView2, imageButton, imageButton2) { // from class: ru.maximoff.color.c.1

            /* renamed from: a */
            private final C3321c f21368a;

            /* renamed from: b */
            private final EditText f21369b;

            /* renamed from: c */
            private final EditText f21370c;

            /* renamed from: d */
            private final ColorPickerView f21371d;

            /* renamed from: e */
            private final ColorPickerPanelView f21372e;

            /* renamed from: f */
            private final ImageButton f21373f;

            /* renamed from: g */
            private final ImageButton f21374g;

            {
                this.f21368a = this;
                this.f21369b = editText;
                this.f21370c = editText2;
                this.f21371d = colorPickerView;
                this.f21372e = colorPickerPanelView2;
                this.f21373f = imageButton;
                this.f21374g = imageButton2;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int i4 = 1;
                if (this.f21369b.isFocused() && editable.length() != 0) {
                    try {
                        String editable2 = editable.toString();
                        if (!editable2.startsWith("#")) {
                            editable2 = new StringBuffer().append("#").append(editable2).toString();
                        }
                        StringBuilder sb = new StringBuilder();
                        if (editable2.length() == 5) {
                            sb.append("#");
                            while (i4 < 5) {
                                sb.append(editable2.charAt(i4)).append(editable2.charAt(i4));
                                i4++;
                            }
                        } else if (editable2.length() == 4) {
                            sb.append("#");
                            while (i4 < 4) {
                                sb.append(editable2.charAt(i4)).append(editable2.charAt(i4));
                                i4++;
                            }
                        } else {
                            sb.append(editable2);
                        }
                        this.f21368a.f21364c = Color.parseColor(sb.toString());
                        this.f21368a.f21365d = this.f21368a.m20112d(String.format("#%08x", new Integer(this.f21368a.f21364c & (-1))));
                        if (this.f21368a.f21366e) {
                            this.f21370c.setText(this.f21368a.f21365d);
                        }
                        this.f21371d.setColor(this.f21368a.f21364c);
                        this.f21372e.setColor(this.f21368a.f21364c);
                        this.f21373f.setEnabled(true);
                        this.f21374g.setEnabled(true);
                    } catch (Exception e2) {
                        this.f21373f.setEnabled(false);
                        this.f21374g.setEnabled(false);
                    }
                }
            }
        });
        if (this.f21366e) {
            editText2.setText(m20112d);
            editText2.setHint(m20112d);
            editText2.addTextChangedListener(new TextWatcher(this, editText2, editText, colorPickerView, colorPickerPanelView2, imageButton, imageButton2) { // from class: ru.maximoff.color.c.2

                /* renamed from: a */
                private final C3321c f21424a;

                /* renamed from: b */
                private final EditText f21425b;

                /* renamed from: c */
                private final EditText f21426c;

                /* renamed from: d */
                private final ColorPickerView f21427d;

                /* renamed from: e */
                private final ColorPickerPanelView f21428e;

                /* renamed from: f */
                private final ImageButton f21429f;

                /* renamed from: g */
                private final ImageButton f21430g;

                {
                    this.f21424a = this;
                    this.f21425b = editText2;
                    this.f21426c = editText;
                    this.f21427d = colorPickerView;
                    this.f21428e = colorPickerPanelView2;
                    this.f21429f = imageButton;
                    this.f21430g = imageButton2;
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (this.f21425b.isFocused() && editable.length() != 0) {
                        try {
                            this.f21424a.f21365d = editable.toString();
                            String m20110c = this.f21424a.m20110c(this.f21424a.f21365d);
                            this.f21424a.f21364c = Color.parseColor(m20110c);
                            this.f21426c.setText(m20110c);
                            this.f21427d.setColor(this.f21424a.f21364c);
                            this.f21428e.setColor(this.f21424a.f21364c);
                            this.f21429f.setEnabled(true);
                            this.f21430g.setEnabled(true);
                        } catch (Exception e2) {
                            this.f21429f.setEnabled(false);
                            this.f21430g.setEnabled(false);
                        }
                    }
                }
            });
        }
        imageButton.setOnClickListener(new View.OnClickListener(this, c3212b) { // from class: ru.maximoff.color.c.3

            /* renamed from: a */
            private final C3321c f21443a;

            /* renamed from: b */
            private final C3212b f21444b;

            {
                this.f21443a = this;
                this.f21444b = c3212b;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f21444b.m19204a(String.format("#%08x", new Integer(this.f21443a.f21364c & (-1))));
                C3112bn.m18999a(this.f21443a.f21367f, R.string.success);
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener(this, colorPickerView) { // from class: ru.maximoff.color.c.4

            /* renamed from: a */
            private final C3321c f21445a;

            /* renamed from: b */
            private final ColorPickerView f21446b;

            {
                this.f21445a = this;
                this.f21446b = colorPickerView;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    this.f21446b.m20079a(this.f21445a.m20097b(this.f21445a.f21364c), true);
                } catch (Exception e2) {
                    C3112bn.m18999a(this.f21445a.f21367f, R.string.error);
                }
            }
        });
        colorPickerView.setOnColorChangedListener(new ColorPickerView.InterfaceC3318a(this, colorPickerPanelView2, editText, editText2, colorPickerView) { // from class: ru.maximoff.color.c.5

            /* renamed from: a */
            private final C3321c f21447a;

            /* renamed from: b */
            private final ColorPickerPanelView f21448b;

            /* renamed from: c */
            private final EditText f21449c;

            /* renamed from: d */
            private final EditText f21450d;

            /* renamed from: e */
            private final ColorPickerView f21451e;

            {
                this.f21447a = this;
                this.f21448b = colorPickerPanelView2;
                this.f21449c = editText;
                this.f21450d = editText2;
                this.f21451e = colorPickerView;
            }

            @Override // ru.maximoff.color.ColorPickerView.InterfaceC3318a
            /* renamed from: a */
            public void mo20080a(int i4) {
                this.f21447a.f21364c = i4;
                this.f21448b.setColor(this.f21447a.f21364c);
                String format2 = String.format("#%08x", new Integer(this.f21447a.f21364c & (-1)));
                this.f21447a.f21365d = this.f21447a.m20112d(format2);
                String m20112d2 = this.f21447a.m20112d(format2);
                this.f21449c.setText(format2);
                this.f21449c.clearFocus();
                this.f21449c.setHint(format2);
                if (this.f21447a.f21366e) {
                    this.f21450d.setText(m20112d2);
                    this.f21450d.clearFocus();
                    this.f21450d.setHint(m20112d2);
                }
                this.f21451e.requestFocus();
            }
        });
        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(this.f21367f);
        aVar.m435b(inflate);
        if (this.f21363b != null) {
            aVar.m427a(this.f21363b);
        }
        aVar.m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.color.c.6

            /* renamed from: a */
            private final C3321c f21452a;

            {
                this.f21452a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                if (this.f21452a.f21362a != null) {
                    this.f21452a.f21362a.mo16421a(String.format("#%08x", new Integer(this.f21452a.f21364c & (-1))));
                    this.f21452a.f21362a.mo16420a(this.f21452a.f21364c);
                    this.f21452a.f21362a.mo16422b(this.f21452a.f21365d);
                }
                dialogInterface.dismiss();
            }
        });
        aVar.m434b(R.string.cancel, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.color.c.7

            /* renamed from: a */
            private final C3321c f21453a;

            {
                this.f21453a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                dialogInterface.cancel();
            }
        });
        aVar.m422a(new DialogInterface.OnKeyListener(this) { // from class: ru.maximoff.color.c.8

            /* renamed from: a */
            private final C3321c f21454a;

            {
                this.f21454a = this;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
                if (i4 != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                    return false;
                }
                dialogInterface.dismiss();
                return true;
            }
        });
        aVar.m429a(false);
        aVar.m440c(R.string.fav_short, (DialogInterface.OnClickListener) null);
        DialogInterfaceC0070b m438b = aVar.m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new AnonymousClass9(this, colorPickerView, colorPickerPanelView, colorPickerPanelView2, i2, m438b, c3212b, editText));
        m438b.setOnCancelListener(new DialogInterface.OnCancelListener(this) { // from class: ru.maximoff.color.c.10

            /* renamed from: a */
            private final C3321c f21375a;

            {
                this.f21375a = this;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (this.f21375a.f21362a != null) {
                    this.f21375a.f21362a.mo16419a();
                }
                dialogInterface.dismiss();
            }
        });
        m438b.show();
    }

    /* compiled from: Picker.java */
    /* renamed from: ru.maximoff.color.c$9, reason: invalid class name */
    class AnonymousClass9 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final C3321c f21455a;

        /* renamed from: b */
        private final ColorPickerView f21456b;

        /* renamed from: c */
        private final ColorPickerPanelView f21457c;

        /* renamed from: d */
        private final ColorPickerPanelView f21458d;

        /* renamed from: e */
        private final int f21459e;

        /* renamed from: f */
        private final DialogInterfaceC0070b f21460f;

        /* renamed from: g */
        private final C3212b f21461g;

        /* renamed from: h */
        private final EditText f21462h;

        AnonymousClass9(C3321c c3321c, ColorPickerView colorPickerView, ColorPickerPanelView colorPickerPanelView, ColorPickerPanelView colorPickerPanelView2, int i, DialogInterfaceC0070b dialogInterfaceC0070b, C3212b c3212b, EditText editText) {
            this.f21455a = c3321c;
            this.f21456b = colorPickerView;
            this.f21457c = colorPickerPanelView;
            this.f21458d = colorPickerPanelView2;
            this.f21459e = i;
            this.f21460f = dialogInterfaceC0070b;
            this.f21461g = c3212b;
            this.f21462h = editText;
        }

        /* renamed from: a */
        static C3321c m20116a(AnonymousClass9 anonymousClass9) {
            return anonymousClass9.f21455a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            this.f21456b.setAlphaSliderVisible(true);
            this.f21456b.setColor(this.f21455a.f21364c);
            this.f21457c.setColor(this.f21455a.f21364c);
            this.f21458d.setColor(this.f21455a.f21364c);
            this.f21456b.setBorderColor(this.f21459e);
            this.f21457c.setBorderColor(this.f21459e);
            this.f21458d.setBorderColor(this.f21459e);
            this.f21456b.setSliderTrackerColor(this.f21459e);
            this.f21460f.m414a(-3).setOnClickListener(new View.OnClickListener(this, this.f21461g, this.f21462h) { // from class: ru.maximoff.color.c.9.1

                /* renamed from: a */
                private final AnonymousClass9 f21463a;

                /* renamed from: b */
                private final C3212b f21464b;

                /* renamed from: c */
                private final EditText f21465c;

                {
                    this.f21463a = this;
                    this.f21464b = r2;
                    this.f21465c = r3;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (this.f21464b.m19202a()) {
                        C3112bn.m18999a(AnonymousClass9.m20116a(this.f21463a).f21367f, R.string.empty);
                        return;
                    }
                    CustomListView customListView = new CustomListView(AnonymousClass9.m20116a(this.f21463a).f21367f);
                    customListView.setFastScrollEnabled(C3102bd.f18314av);
                    C3320b c3320b = new C3320b(AnonymousClass9.m20116a(this.f21463a).f21367f, this.f21465c, this.f21464b);
                    customListView.setAdapter((ListAdapter) c3320b);
                    DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(AnonymousClass9.m20116a(this.f21463a).f21367f).m418a(R.string.fav_full).m435b(customListView).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m438b();
                    m438b.show();
                    c3320b.m20091a(m438b);
                }
            });
            this.f21456b.requestFocus();
            if (this.f21455a.f21363b != null) {
                try {
                    TextView textView = (TextView) this.f21460f.findViewById(R.id.alertTitle);
                    if (textView != null) {
                        textView.setOnLongClickListener(new AnonymousClass2(this, this.f21460f));
                    }
                } catch (Exception e2) {
                }
            }
        }

        /* compiled from: Picker.java */
        /* renamed from: ru.maximoff.color.c$9$2, reason: invalid class name */
        class AnonymousClass2 implements View.OnLongClickListener {

            /* renamed from: a */
            private final AnonymousClass9 f21466a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f21467b;

            AnonymousClass2(AnonymousClass9 anonymousClass9, DialogInterfaceC0070b dialogInterfaceC0070b) {
                this.f21466a = anonymousClass9;
                this.f21467b = dialogInterfaceC0070b;
            }

            /* renamed from: a */
            static AnonymousClass9 m20117a(AnonymousClass2 anonymousClass2) {
                return anonymousClass2.f21466a;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                this.f21467b.dismiss();
                C3102bd.m18938b(AnonymousClass9.m20116a(this.f21466a).f21367f, "old_picker", true);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: ru.maximoff.color.c.9.2.1

                    /* renamed from: a */
                    private final AnonymousClass2 f21468a;

                    {
                        this.f21468a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass9.m20116a(AnonymousClass2.m20117a(this.f21468a)).m20109b();
                    }
                }, 100L);
                return true;
            }
        }
    }

    /* renamed from: d */
    public void m20113d() {
        int i;
        int i2;
        String format = String.format("#%08x", new Integer(this.f21364c & (-1)));
        String m20112d = m20112d(format);
        if (C3102bd.f18291a) {
            i = R.drawable.ic_invert;
            i2 = R.drawable.ic_preset;
        } else {
            i = R.drawable.ic_invert_dark;
            i2 = R.drawable.ic_preset_dark;
        }
        C3212b c3212b = new C3212b(this.f21367f, "favorites_colors");
        View inflate = LayoutInflater.from(this.f21367f).inflate(R.layout.maximoff_picker_old, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.pickerImageView1);
        imageView.setImageDrawable(new ColorDrawable(this.f21364c));
        SeekBar seekBar = (SeekBar) inflate.findViewById(R.id.pickerSeekBar1);
        SeekBar seekBar2 = (SeekBar) inflate.findViewById(R.id.pickerSeekBar2);
        SeekBar seekBar3 = (SeekBar) inflate.findViewById(R.id.pickerSeekBar3);
        SeekBar seekBar4 = (SeekBar) inflate.findViewById(R.id.pickerSeekBar4);
        TextView textView = (TextView) inflate.findViewById(R.id.pickerTextView1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.pickerTextView2);
        TextView textView3 = (TextView) inflate.findViewById(R.id.pickerTextView3);
        TextView textView4 = (TextView) inflate.findViewById(R.id.pickerTextView4);
        EditText editText = (EditText) inflate.findViewById(R.id.pickerEditText1);
        EditText editText2 = (EditText) inflate.findViewById(R.id.pickerEditText2);
        editText2.setVisibility(this.f21366e ? 0 : 8);
        editText2.setEnabled(this.f21366e);
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.pickerButton1);
        ImageButton imageButton2 = (ImageButton) inflate.findViewById(R.id.pickerButton2);
        seekBar.setFocusable(true);
        seekBar.setFocusableInTouchMode(true);
        seekBar2.setFocusable(true);
        seekBar2.setFocusableInTouchMode(true);
        seekBar3.setFocusable(true);
        seekBar3.setFocusableInTouchMode(true);
        seekBar4.setFocusable(true);
        seekBar4.setFocusableInTouchMode(true);
        imageButton.setImageResource(i2);
        imageButton2.setImageResource(i);
        editText.setText(format);
        editText.setHint(format);
        editText.addTextChangedListener(new TextWatcher(this, editText, editText2, seekBar, seekBar2, seekBar3, seekBar4, imageButton, imageButton2) { // from class: ru.maximoff.color.c.11

            /* renamed from: a */
            private final C3321c f21376a;

            /* renamed from: b */
            private final EditText f21377b;

            /* renamed from: c */
            private final EditText f21378c;

            /* renamed from: d */
            private final SeekBar f21379d;

            /* renamed from: e */
            private final SeekBar f21380e;

            /* renamed from: f */
            private final SeekBar f21381f;

            /* renamed from: g */
            private final SeekBar f21382g;

            /* renamed from: h */
            private final ImageButton f21383h;

            /* renamed from: i */
            private final ImageButton f21384i;

            {
                this.f21376a = this;
                this.f21377b = editText;
                this.f21378c = editText2;
                this.f21379d = seekBar;
                this.f21380e = seekBar2;
                this.f21381f = seekBar3;
                this.f21382g = seekBar4;
                this.f21383h = imageButton;
                this.f21384i = imageButton2;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int i3 = 1;
                if (this.f21377b.isFocused() && editable.length() != 0) {
                    try {
                        String editable2 = editable.toString();
                        if (!editable2.startsWith("#")) {
                            editable2 = new StringBuffer().append("#").append(editable2).toString();
                        }
                        StringBuilder sb = new StringBuilder();
                        if (editable2.length() == 5) {
                            sb.append("#");
                            while (i3 < 5) {
                                sb.append(editable2.charAt(i3)).append(editable2.charAt(i3));
                                i3++;
                            }
                        } else if (editable2.length() == 4) {
                            sb.append("#");
                            while (i3 < 4) {
                                sb.append(editable2.charAt(i3)).append(editable2.charAt(i3));
                                i3++;
                            }
                        } else {
                            sb.append(editable2);
                        }
                        this.f21376a.f21364c = Color.parseColor(sb.toString());
                        this.f21376a.f21365d = this.f21376a.m20112d(String.format("#%08x", new Integer(this.f21376a.f21364c & (-1))));
                        if (this.f21376a.f21366e) {
                            this.f21378c.setText(this.f21376a.f21365d);
                        }
                        this.f21379d.setProgress(Color.alpha(this.f21376a.f21364c));
                        this.f21380e.setProgress(Color.red(this.f21376a.f21364c));
                        this.f21381f.setProgress(Color.green(this.f21376a.f21364c));
                        this.f21382g.setProgress(Color.blue(this.f21376a.f21364c));
                        this.f21383h.setEnabled(true);
                        this.f21384i.setEnabled(true);
                    } catch (Exception e2) {
                        this.f21383h.setEnabled(false);
                        this.f21384i.setEnabled(false);
                    }
                }
            }
        });
        if (this.f21366e) {
            editText2.setText(m20112d);
            editText2.setHint(m20112d);
            editText2.addTextChangedListener(new TextWatcher(this, editText2, editText, seekBar, seekBar2, seekBar3, seekBar4, imageButton, imageButton2) { // from class: ru.maximoff.color.c.12

                /* renamed from: a */
                private final C3321c f21385a;

                /* renamed from: b */
                private final EditText f21386b;

                /* renamed from: c */
                private final EditText f21387c;

                /* renamed from: d */
                private final SeekBar f21388d;

                /* renamed from: e */
                private final SeekBar f21389e;

                /* renamed from: f */
                private final SeekBar f21390f;

                /* renamed from: g */
                private final SeekBar f21391g;

                /* renamed from: h */
                private final ImageButton f21392h;

                /* renamed from: i */
                private final ImageButton f21393i;

                {
                    this.f21385a = this;
                    this.f21386b = editText2;
                    this.f21387c = editText;
                    this.f21388d = seekBar;
                    this.f21389e = seekBar2;
                    this.f21390f = seekBar3;
                    this.f21391g = seekBar4;
                    this.f21392h = imageButton;
                    this.f21393i = imageButton2;
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (this.f21386b.isFocused() && editable.length() != 0) {
                        try {
                            this.f21385a.f21365d = editable.toString();
                            String m20110c = this.f21385a.m20110c(this.f21385a.f21365d);
                            this.f21385a.f21364c = Color.parseColor(m20110c);
                            this.f21387c.setText(m20110c);
                            this.f21388d.setProgress(Color.alpha(this.f21385a.f21364c));
                            this.f21389e.setProgress(Color.red(this.f21385a.f21364c));
                            this.f21390f.setProgress(Color.green(this.f21385a.f21364c));
                            this.f21391g.setProgress(Color.blue(this.f21385a.f21364c));
                            this.f21392h.setEnabled(true);
                            this.f21393i.setEnabled(true);
                        } catch (Exception e2) {
                            this.f21392h.setEnabled(false);
                            this.f21393i.setEnabled(false);
                        }
                    }
                }
            });
        }
        imageButton.setOnClickListener(new View.OnClickListener(this, c3212b) { // from class: ru.maximoff.color.c.13

            /* renamed from: a */
            private final C3321c f21394a;

            /* renamed from: b */
            private final C3212b f21395b;

            {
                this.f21394a = this;
                this.f21395b = c3212b;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f21395b.m19204a(String.format("#%08x", new Integer(this.f21394a.f21364c & (-1))));
                C3112bn.m18999a(this.f21394a.f21367f, R.string.success);
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener(this, editText) { // from class: ru.maximoff.color.c.14

            /* renamed from: a */
            private final C3321c f21396a;

            /* renamed from: b */
            private final EditText f21397b;

            {
                this.f21396a = this;
                this.f21397b = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    String format2 = String.format("#%08x", new Integer(this.f21396a.m20097b(this.f21396a.f21364c) & (-1)));
                    this.f21397b.requestFocus();
                    this.f21397b.setText(format2);
                    this.f21397b.setSelection(format2.length());
                } catch (Exception e2) {
                    C3112bn.m18999a(this.f21396a.f21367f, R.string.error);
                }
            }
        });
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener(this, textView, textView2, textView3, textView4, imageView, editText, editText2) { // from class: ru.maximoff.color.c.15

            /* renamed from: a */
            private boolean f21398a = false;

            /* renamed from: b */
            private final C3321c f21399b;

            /* renamed from: c */
            private final TextView f21400c;

            /* renamed from: d */
            private final TextView f21401d;

            /* renamed from: e */
            private final TextView f21402e;

            /* renamed from: f */
            private final TextView f21403f;

            /* renamed from: g */
            private final ImageView f21404g;

            /* renamed from: h */
            private final EditText f21405h;

            /* renamed from: i */
            private final EditText f21406i;

            {
                this.f21399b = this;
                this.f21400c = textView;
                this.f21401d = textView2;
                this.f21402e = textView3;
                this.f21403f = textView4;
                this.f21404g = imageView;
                this.f21405h = editText;
                this.f21406i = editText2;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar5, int i3, boolean z) {
                switch (seekBar5.getTag().toString().toUpperCase().charAt(0)) {
                    case 'A':
                        this.f21399b.f21364c = Color.argb(i3, Color.red(this.f21399b.f21364c), Color.green(this.f21399b.f21364c), Color.blue(this.f21399b.f21364c));
                        this.f21400c.setText(String.valueOf(i3));
                        break;
                    case 'B':
                        this.f21399b.f21364c = Color.argb(Color.alpha(this.f21399b.f21364c), Color.red(this.f21399b.f21364c), Color.green(this.f21399b.f21364c), i3);
                        this.f21403f.setText(String.valueOf(i3));
                        break;
                    case 'G':
                        this.f21399b.f21364c = Color.argb(Color.alpha(this.f21399b.f21364c), Color.red(this.f21399b.f21364c), i3, Color.blue(this.f21399b.f21364c));
                        this.f21402e.setText(String.valueOf(i3));
                        break;
                    case 'R':
                        this.f21399b.f21364c = Color.argb(Color.alpha(this.f21399b.f21364c), i3, Color.green(this.f21399b.f21364c), Color.blue(this.f21399b.f21364c));
                        this.f21401d.setText(String.valueOf(i3));
                        break;
                }
                this.f21399b.f21365d = this.f21399b.m20112d(String.format("#%08x", new Integer(this.f21399b.f21364c & (-1))));
                this.f21404g.setImageDrawable(new ColorDrawable(this.f21399b.f21364c));
                if (this.f21398a) {
                    String format2 = String.format("#%08x", new Integer(this.f21399b.f21364c & (-1)));
                    String m20112d2 = this.f21399b.m20112d(format2);
                    this.f21405h.setText(format2);
                    this.f21405h.clearFocus();
                    this.f21405h.setHint(format2);
                    if (this.f21399b.f21366e) {
                        this.f21406i.setText(m20112d2);
                        this.f21406i.clearFocus();
                        this.f21406i.setHint(m20112d2);
                    }
                    seekBar5.requestFocus();
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar5) {
                this.f21398a = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar5) {
                this.f21398a = false;
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener(this, seekBar, seekBar2, seekBar3, seekBar4, onSeekBarChangeListener) { // from class: ru.maximoff.color.c.16

            /* renamed from: a */
            private final C3321c f21407a;

            /* renamed from: b */
            private final SeekBar f21408b;

            /* renamed from: c */
            private final SeekBar f21409c;

            /* renamed from: d */
            private final SeekBar f21410d;

            /* renamed from: e */
            private final SeekBar f21411e;

            /* renamed from: f */
            private final SeekBar.OnSeekBarChangeListener f21412f;

            {
                this.f21407a = this;
                this.f21408b = seekBar;
                this.f21409c = seekBar2;
                this.f21410d = seekBar3;
                this.f21411e = seekBar4;
                this.f21412f = onSeekBarChangeListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SeekBar seekBar5;
                String upperCase = view.getTag().toString().toUpperCase();
                switch (upperCase.charAt(0)) {
                    case 'A':
                        seekBar5 = this.f21408b;
                        break;
                    case 'B':
                        seekBar5 = this.f21411e;
                        break;
                    case 'G':
                        seekBar5 = this.f21410d;
                        break;
                    case 'R':
                        seekBar5 = this.f21409c;
                        break;
                    default:
                        return;
                }
                View inflate2 = LayoutInflater.from(this.f21407a.f21367f).inflate(R.layout.rename_one, (ViewGroup) null);
                ((LinearLayout) inflate2.findViewById(R.id.renameoneLinearLayout1)).setVisibility(8);
                EditText editText3 = (EditText) inflate2.findViewById(R.id.renameoneEditText1);
                int progress = seekBar5.getProgress();
                editText3.setSingleLine(true);
                editText3.setInputType(8194);
                editText3.setText(String.valueOf(progress));
                editText3.setHint(String.valueOf(progress));
                DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f21407a.f21367f).m435b(inflate2).m427a(new StringBuffer().append(new StringBuffer().append("[").append(upperCase.charAt(0)).toString()).append("] 0 - 255").toString()).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, editText3, progress, this.f21412f, seekBar5) { // from class: ru.maximoff.color.c.16.1

                    /* renamed from: a */
                    private final AnonymousClass16 f21413a;

                    /* renamed from: b */
                    private final EditText f21414b;

                    /* renamed from: c */
                    private final int f21415c;

                    /* renamed from: d */
                    private final SeekBar.OnSeekBarChangeListener f21416d;

                    /* renamed from: e */
                    private final SeekBar f21417e;

                    {
                        this.f21413a = this;
                        this.f21414b = editText3;
                        this.f21415c = progress;
                        this.f21416d = r4;
                        this.f21417e = seekBar5;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        try {
                            int abs = Math.abs(Integer.parseInt(this.f21414b.getText().toString()));
                            if (abs > 255) {
                                abs = this.f21415c;
                            }
                            this.f21416d.onStartTrackingTouch(this.f21417e);
                            this.f21417e.setProgress(abs);
                            this.f21416d.onStopTrackingTouch(this.f21417e);
                        } catch (Exception e2) {
                        }
                        dialogInterface.dismiss();
                    }
                }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
                m438b.getWindow().setSoftInputMode(4);
                m438b.setOnShowListener(new DialogInterface.OnShowListener(this, editText3, progress) { // from class: ru.maximoff.color.c.16.2

                    /* renamed from: a */
                    private final AnonymousClass16 f21418a;

                    /* renamed from: b */
                    private final EditText f21419b;

                    /* renamed from: c */
                    private final int f21420c;

                    {
                        this.f21418a = this;
                        this.f21419b = editText3;
                        this.f21420c = progress;
                    }

                    @Override // android.content.DialogInterface.OnShowListener
                    public void onShow(DialogInterface dialogInterface) {
                        this.f21419b.requestFocus();
                        this.f21419b.setSelection(String.valueOf(this.f21420c).length());
                    }
                });
                m438b.show();
            }
        };
        seekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);
        seekBar2.setOnSeekBarChangeListener(onSeekBarChangeListener);
        seekBar3.setOnSeekBarChangeListener(onSeekBarChangeListener);
        seekBar4.setOnSeekBarChangeListener(onSeekBarChangeListener);
        textView.setOnClickListener(onClickListener);
        textView2.setOnClickListener(onClickListener);
        textView3.setOnClickListener(onClickListener);
        textView4.setOnClickListener(onClickListener);
        seekBar.setProgress(Color.alpha(this.f21364c));
        seekBar2.setProgress(Color.red(this.f21364c));
        seekBar3.setProgress(Color.green(this.f21364c));
        seekBar4.setProgress(Color.blue(this.f21364c));
        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(this.f21367f);
        aVar.m435b(inflate);
        if (this.f21363b != null) {
            aVar.m427a(this.f21363b);
        }
        aVar.m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.color.c.17

            /* renamed from: a */
            private final C3321c f21421a;

            {
                this.f21421a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                if (this.f21421a.f21362a != null) {
                    this.f21421a.f21362a.mo16421a(String.format("#%08x", new Integer(this.f21421a.f21364c & (-1))));
                    this.f21421a.f21362a.mo16420a(this.f21421a.f21364c);
                    this.f21421a.f21362a.mo16422b(this.f21421a.f21365d);
                }
                dialogInterface.dismiss();
            }
        });
        aVar.m434b(R.string.cancel, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.color.c.18

            /* renamed from: a */
            private final C3321c f21422a;

            {
                this.f21422a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.cancel();
            }
        });
        aVar.m422a(new DialogInterface.OnKeyListener(this) { // from class: ru.maximoff.color.c.19

            /* renamed from: a */
            private final C3321c f21423a;

            {
                this.f21423a = this;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
                if (i3 != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                    return false;
                }
                dialogInterface.dismiss();
                return true;
            }
        });
        aVar.m429a(false);
        aVar.m440c(R.string.fav_short, (DialogInterface.OnClickListener) null);
        DialogInterfaceC0070b m438b = aVar.m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new AnonymousClass20(this, m438b, c3212b, editText, imageView));
        m438b.setOnCancelListener(new DialogInterface.OnCancelListener(this) { // from class: ru.maximoff.color.c.21

            /* renamed from: a */
            private final C3321c f21442a;

            {
                this.f21442a = this;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (this.f21442a.f21362a != null) {
                    this.f21442a.f21362a.mo16419a();
                }
                dialogInterface.dismiss();
            }
        });
        m438b.show();
    }

    /* compiled from: Picker.java */
    /* renamed from: ru.maximoff.color.c$20, reason: invalid class name */
    class AnonymousClass20 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final C3321c f21431a;

        /* renamed from: b */
        private final DialogInterfaceC0070b f21432b;

        /* renamed from: c */
        private final C3212b f21433c;

        /* renamed from: d */
        private final EditText f21434d;

        /* renamed from: e */
        private final ImageView f21435e;

        AnonymousClass20(C3321c c3321c, DialogInterfaceC0070b dialogInterfaceC0070b, C3212b c3212b, EditText editText, ImageView imageView) {
            this.f21431a = c3321c;
            this.f21432b = dialogInterfaceC0070b;
            this.f21433c = c3212b;
            this.f21434d = editText;
            this.f21435e = imageView;
        }

        /* renamed from: a */
        static C3321c m20114a(AnonymousClass20 anonymousClass20) {
            return anonymousClass20.f21431a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            this.f21432b.m414a(-3).setOnClickListener(new View.OnClickListener(this, this.f21433c, this.f21434d) { // from class: ru.maximoff.color.c.20.1

                /* renamed from: a */
                private final AnonymousClass20 f21436a;

                /* renamed from: b */
                private final C3212b f21437b;

                /* renamed from: c */
                private final EditText f21438c;

                {
                    this.f21436a = this;
                    this.f21437b = r2;
                    this.f21438c = r3;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (this.f21437b.m19202a()) {
                        C3112bn.m18999a(AnonymousClass20.m20114a(this.f21436a).f21367f, R.string.empty);
                        return;
                    }
                    CustomListView customListView = new CustomListView(AnonymousClass20.m20114a(this.f21436a).f21367f);
                    customListView.setFastScrollEnabled(C3102bd.f18314av);
                    C3320b c3320b = new C3320b(AnonymousClass20.m20114a(this.f21436a).f21367f, this.f21438c, this.f21437b);
                    customListView.setAdapter((ListAdapter) c3320b);
                    DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(AnonymousClass20.m20114a(this.f21436a).f21367f).m418a(R.string.fav_full).m435b(customListView).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m438b();
                    m438b.show();
                    c3320b.m20091a(m438b);
                }
            });
            this.f21435e.requestFocus();
            if (this.f21431a.f21363b != null) {
                try {
                    TextView textView = (TextView) this.f21432b.findViewById(R.id.alertTitle);
                    if (textView != null) {
                        textView.setOnLongClickListener(new AnonymousClass2(this, this.f21432b));
                    }
                } catch (Exception e2) {
                }
            }
        }

        /* compiled from: Picker.java */
        /* renamed from: ru.maximoff.color.c$20$2, reason: invalid class name */
        class AnonymousClass2 implements View.OnLongClickListener {

            /* renamed from: a */
            private final AnonymousClass20 f21439a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f21440b;

            AnonymousClass2(AnonymousClass20 anonymousClass20, DialogInterfaceC0070b dialogInterfaceC0070b) {
                this.f21439a = anonymousClass20;
                this.f21440b = dialogInterfaceC0070b;
            }

            /* renamed from: a */
            static AnonymousClass20 m20115a(AnonymousClass2 anonymousClass2) {
                return anonymousClass2.f21439a;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                this.f21440b.dismiss();
                C3102bd.m18938b(AnonymousClass20.m20114a(this.f21439a).f21367f, "old_picker", false);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: ru.maximoff.color.c.20.2.1

                    /* renamed from: a */
                    private final AnonymousClass2 f21441a;

                    {
                        this.f21441a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass20.m20114a(AnonymousClass2.m20115a(this.f21441a)).m20109b();
                    }
                }, 100L);
                return true;
            }
        }
    }
}
