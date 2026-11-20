package ru.maximoff.apktool.util;

import android.C0012R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.widget.C0173ao;
import com.srizwan.apktool.R;
import java.io.File;
import java.util.List;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a;
import ru.maximoff.apktool.util.p306d.C3212b;

/* compiled from: CreateIcon.java */
/* renamed from: ru.maximoff.apktool.util.j */
/* loaded from: classes.dex */
public class C3250j {
    /* renamed from: a */
    public static void m19503a(Context context, InterfaceC2995n interfaceC2995n, File file, C3099ba c3099ba, Drawable drawable) {
        Bitmap[] bitmapArr = {(Bitmap) null, (Bitmap) null};
        try {
            bitmapArr[0] = m19502a(context, file, c3099ba, drawable);
            if (bitmapArr[0] == null) {
                C3112bn.m19000a(context, R.string.errorf, "image is damaged");
                return;
            }
            View inflate = LayoutInflater.from(context).inflate(R.layout.create_icon, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.createiconTextView1);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.createiconImageView0);
            EditText editText = (EditText) inflate.findViewById(R.id.createiconEditText1);
            EditText editText2 = (EditText) inflate.findViewById(R.id.createiconEditText2);
            ImageView imageView2 = (ImageView) inflate.findViewById(R.id.createiconImageView1);
            ImageView imageView3 = (ImageView) inflate.findViewById(R.id.createiconImageView2);
            Spinner spinner = (Spinner) inflate.findViewById(R.id.createiconSpinner1);
            Spinner spinner2 = (Spinner) inflate.findViewById(R.id.createiconSpinner2);
            CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.createiconCheckBox1);
            CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.createiconCheckBox2);
            CheckBox checkBox3 = (CheckBox) inflate.findViewById(R.id.createiconCheckBox3);
            CheckBox checkBox4 = (CheckBox) inflate.findViewById(R.id.createiconCheckBox4);
            CheckBox checkBox5 = (CheckBox) inflate.findViewById(R.id.createiconCheckBox5);
            CheckBox checkBox6 = (CheckBox) inflate.findViewById(R.id.createiconCheckBox6);
            CheckBox checkBox7 = (CheckBox) inflate.findViewById(R.id.createiconCheckBox7);
            CheckBox checkBox8 = (CheckBox) inflate.findViewById(R.id.createiconCheckBox8);
            CheckBox checkBox9 = (CheckBox) inflate.findViewById(R.id.createiconCheckBox9);
            CheckBox checkBox10 = (CheckBox) inflate.findViewById(R.id.createiconCheckBox10);
            String[] strArr = {"drawable", "mipmap"};
            String[] strArr2 = {"png", "webp"};
            String str = "%s (%dx%d)";
            Button[] buttonArr = new Button[1];
            imageView.setImageBitmap(bitmapArr[0]);
            textView.setText(file.getName());
            C3212b c3212b = new C3212b(context, "ic_name");
            C3212b c3212b2 = new C3212b(context, "ric_name");
            if (C3102bd.f18291a) {
                imageView2.setImageResource(R.drawable.ic_collapse);
                imageView3.setImageResource(R.drawable.ic_collapse);
            } else {
                imageView2.setImageResource(R.drawable.ic_collapse_dark);
                imageView3.setImageResource(R.drawable.ic_collapse_dark);
            }
            TextView textView2 = (TextView) inflate.findViewById(R.id.createiconTextView2);
            Runnable runnable = new Runnable(context, checkBox9, str, checkBox10) { // from class: ru.maximoff.apktool.util.j.1

                /* renamed from: a */
                private final Context f19567a;

                /* renamed from: b */
                private final CheckBox f19568b;

                /* renamed from: c */
                private final String f19569c;

                /* renamed from: d */
                private final CheckBox f19570d;

                {
                    this.f19567a = context;
                    this.f19568b = checkBox9;
                    this.f19569c = str;
                    this.f19570d = checkBox10;
                }

                @Override // java.lang.Runnable
                public void run() {
                    int m18905a = C3102bd.m18905a(this.f19567a, "aicon_size", 108);
                    this.f19568b.setText(String.format(this.f19569c, this.f19567a.getString(R.string.vector_icon).toLowerCase(), new Integer(m18905a), new Integer(m18905a)));
                    this.f19570d.setText(String.format(this.f19569c, this.f19567a.getString(R.string.adaptive_icon).toLowerCase(), new Integer(m18905a), new Integer(m18905a)));
                }
            };
            C3112bn.m19009a(textView2, context.getString(R.string.aicon_size));
            textView2.setOnClickListener(new View.OnClickListener(context, runnable) { // from class: ru.maximoff.apktool.util.j.2

                /* renamed from: a */
                private final Context f19597a;

                /* renamed from: b */
                private final Runnable f19598b;

                {
                    this.f19597a = context;
                    this.f19598b = runnable;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C3080al.m18547a(this.f19597a, 50, 250, 108, "aicon_size", R.string.aicon_size, this.f19598b);
                }
            });
            List<String> m19205b = c3212b.m19205b();
            List<String> m19205b2 = c3212b2.m19205b();
            editText.setHint("ic_launcher");
            editText2.setHint("ic_launcher_round");
            if (m19205b.isEmpty()) {
                imageView2.setVisibility(8);
                editText.setText("ic_launcher");
            } else {
                imageView2.setVisibility(0);
                editText.setText(m19205b.get(m19205b.size() - 1));
            }
            imageView2.setOnClickListener(new View.OnClickListener(c3212b, imageView2, editText) { // from class: ru.maximoff.apktool.util.j.3

                /* renamed from: a */
                private final C3212b f19599a;

                /* renamed from: b */
                private final ImageView f19600b;

                /* renamed from: c */
                private final EditText f19601c;

                {
                    this.f19599a = c3212b;
                    this.f19600b = imageView2;
                    this.f19601c = editText;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f19599a.m19201a(this.f19600b, this.f19601c);
                }
            });
            imageView2.setOnLongClickListener(new View.OnLongClickListener(c3212b, imageView2, context) { // from class: ru.maximoff.apktool.util.j.4

                /* renamed from: a */
                private final C3212b f19602a;

                /* renamed from: b */
                private final ImageView f19603b;

                /* renamed from: c */
                private final Context f19604c;

                {
                    this.f19602a = c3212b;
                    this.f19603b = imageView2;
                    this.f19604c = context;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    new C3078aj(this.f19604c).m18500b(R.string.clear_history).m18495a(R.string.yes, new Runnable(this, this.f19602a, this.f19603b) { // from class: ru.maximoff.apktool.util.j.4.1

                        /* renamed from: a */
                        private final AnonymousClass4 f19605a;

                        /* renamed from: b */
                        private final C3212b f19606b;

                        /* renamed from: c */
                        private final ImageView f19607c;

                        {
                            this.f19605a = this;
                            this.f19606b = r2;
                            this.f19607c = r3;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            this.f19606b.m19208d();
                            this.f19607c.setVisibility(8);
                        }
                    }).m18508e(R.string.cancel).m18507d();
                    return true;
                }
            });
            if (m19205b2.isEmpty()) {
                imageView3.setVisibility(8);
                editText2.setText("ic_launcher_round");
            } else {
                imageView3.setVisibility(0);
                editText2.setText(m19205b2.get(m19205b2.size() - 1));
            }
            imageView3.setOnClickListener(new View.OnClickListener(c3212b2, imageView3, editText2) { // from class: ru.maximoff.apktool.util.j.5

                /* renamed from: a */
                private final C3212b f19608a;

                /* renamed from: b */
                private final ImageView f19609b;

                /* renamed from: c */
                private final EditText f19610c;

                {
                    this.f19608a = c3212b2;
                    this.f19609b = imageView3;
                    this.f19610c = editText2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f19608a.m19201a(this.f19609b, this.f19610c);
                }
            });
            imageView3.setOnLongClickListener(new View.OnLongClickListener(c3212b2, imageView3, context) { // from class: ru.maximoff.apktool.util.j.6

                /* renamed from: a */
                private final C3212b f19611a;

                /* renamed from: b */
                private final ImageView f19612b;

                /* renamed from: c */
                private final Context f19613c;

                {
                    this.f19611a = c3212b2;
                    this.f19612b = imageView3;
                    this.f19613c = context;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    new C3078aj(this.f19613c).m18500b(R.string.clear_history).m18495a(R.string.yes, new Runnable(this, this.f19611a, this.f19612b) { // from class: ru.maximoff.apktool.util.j.6.1

                        /* renamed from: a */
                        private final AnonymousClass6 f19614a;

                        /* renamed from: b */
                        private final C3212b f19615b;

                        /* renamed from: c */
                        private final ImageView f19616c;

                        {
                            this.f19614a = this;
                            this.f19615b = r2;
                            this.f19616c = r3;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            this.f19615b.m19208d();
                            this.f19616c.setVisibility(8);
                        }
                    }).m18508e(R.string.cancel).m18507d();
                    return true;
                }
            });
            CheckBox[] checkBoxArr = {checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8};
            spinner2.setAdapter((SpinnerAdapter) new ArrayAdapter(context, C0012R.layout.simple_spinner_dropdown_item, strArr2));
            spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(context, C0012R.layout.simple_spinner_dropdown_item, strArr));
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(strArr, context, checkBoxArr) { // from class: ru.maximoff.apktool.util.j.7

                /* renamed from: a */
                private final String[] f19617a;

                /* renamed from: b */
                private final Context f19618b;

                /* renamed from: c */
                private final CheckBox[] f19619c;

                {
                    this.f19617a = strArr;
                    this.f19618b = context;
                    this.f19619c = checkBoxArr;
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    String stringBuffer = new StringBuffer().append(this.f19617a[i]).append("-%s (%dx%d)").toString();
                    String m18602h = C3080al.m18602h(this.f19618b);
                    for (int i2 = 0; i2 < this.f19619c.length; i2++) {
                        String str2 = C3067ab.f17243b[i2];
                        this.f19619c[i2].setText(new StringBuffer().append(String.format(stringBuffer, str2, new Integer(C3067ab.f17242a[i2]), new Integer(C3067ab.f17242a[i2]))).append(m18602h.equalsIgnoreCase(str2) ? " √" : "").toString());
                    }
                }
            });
            checkBox.setChecked(C3102bd.m18925a(context, "ic_create_icn", true));
            checkBox2.setChecked(C3102bd.m18925a(context, "ic_create_ricn", false));
            String[] strArr3 = {"ic_create_vector", "ic_create_adapt", "ic_create_ldpi", "ic_create_mdpi", "ic_create_hdpi", "ic_create_xhdpi", "ic_create_xxhdpi", "ic_create_xxxhdpi"};
            checkBox9.setChecked(C3102bd.m18925a(context, strArr3[0], false));
            checkBox10.setChecked(C3102bd.m18925a(context, strArr3[1], false));
            int m18905a = C3102bd.m18905a(context, "aicon_size", 108);
            checkBox9.setText(String.format("%s (%dx%d)", context.getString(R.string.vector_icon).toLowerCase(), new Integer(m18905a), new Integer(m18905a)));
            checkBox10.setText(String.format("%s (%dx%d)", context.getString(R.string.adaptive_icon).toLowerCase(), new Integer(m18905a), new Integer(m18905a)));
            editText.setEnabled(checkBox.isChecked());
            imageView2.setEnabled(checkBox.isChecked());
            editText2.setEnabled(checkBox2.isChecked());
            imageView3.setEnabled(checkBox2.isChecked());
            View.OnClickListener onClickListener = new View.OnClickListener(checkBoxArr, editText, checkBox, imageView2, editText2, checkBox2, imageView3, buttonArr, checkBox9, checkBox10) { // from class: ru.maximoff.apktool.util.j.8

                /* renamed from: a */
                private final CheckBox[] f19620a;

                /* renamed from: b */
                private final EditText f19621b;

                /* renamed from: c */
                private final CheckBox f19622c;

                /* renamed from: d */
                private final ImageView f19623d;

                /* renamed from: e */
                private final EditText f19624e;

                /* renamed from: f */
                private final CheckBox f19625f;

                /* renamed from: g */
                private final ImageView f19626g;

                /* renamed from: h */
                private final Button[] f19627h;

                /* renamed from: i */
                private final CheckBox f19628i;

                /* renamed from: j */
                private final CheckBox f19629j;

                {
                    this.f19620a = checkBoxArr;
                    this.f19621b = editText;
                    this.f19622c = checkBox;
                    this.f19623d = imageView2;
                    this.f19624e = editText2;
                    this.f19625f = checkBox2;
                    this.f19626g = imageView3;
                    this.f19627h = buttonArr;
                    this.f19628i = checkBox9;
                    this.f19629j = checkBox10;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z;
                    boolean z2 = false;
                    int i = 0;
                    while (true) {
                        if (i >= this.f19620a.length) {
                            z = false;
                            break;
                        } else {
                            if (this.f19620a[i].isChecked()) {
                                z = true;
                                break;
                            }
                            i++;
                        }
                    }
                    this.f19621b.setEnabled(this.f19622c.isChecked());
                    this.f19623d.setEnabled(this.f19622c.isChecked());
                    this.f19624e.setEnabled(this.f19625f.isChecked());
                    this.f19626g.setEnabled(this.f19625f.isChecked());
                    Button button = this.f19627h[0];
                    if ((this.f19622c.isChecked() || this.f19625f.isChecked()) && (z || this.f19628i.isChecked() || this.f19629j.isChecked())) {
                        z2 = true;
                    }
                    button.setEnabled(z2);
                }
            };
            checkBox.setOnClickListener(onClickListener);
            checkBox2.setOnClickListener(onClickListener);
            checkBox9.setOnClickListener(onClickListener);
            checkBox10.setOnClickListener(onClickListener);
            for (int i = 0; i < checkBoxArr.length; i++) {
                checkBoxArr[i].setChecked(C3102bd.m18925a(context, strArr3[i + 2], true));
                checkBoxArr[i].setOnClickListener(onClickListener);
            }
            imageView.setOnLongClickListener(new View.OnLongClickListener(bitmapArr, context, imageView) { // from class: ru.maximoff.apktool.util.j.9

                /* renamed from: a */
                private final Bitmap[] f19630a;

                /* renamed from: b */
                private final Context f19631b;

                /* renamed from: c */
                private final ImageView f19632c;

                {
                    this.f19630a = bitmapArr;
                    this.f19631b = context;
                    this.f19632c = imageView;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    int i2;
                    if (this.f19630a[0] != null) {
                        C0173ao c0173ao = new C0173ao(this.f19631b, view);
                        if (C3102bd.m18910a(this.f19631b, "menu_position", "1").equals("0")) {
                            i2 = 3;
                        } else {
                            i2 = 5;
                        }
                        c0173ao.m1340a(i2);
                        c0173ao.m1339a().add(0, 1400, 0, this.f19631b.getString(R.string.invert_color)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f19630a, this.f19632c, this.f19631b) { // from class: ru.maximoff.apktool.util.j.9.1

                            /* renamed from: a */
                            private final AnonymousClass9 f19633a;

                            /* renamed from: b */
                            private final Bitmap[] f19634b;

                            /* renamed from: c */
                            private final ImageView f19635c;

                            /* renamed from: d */
                            private final Context f19636d;

                            {
                                this.f19633a = this;
                                this.f19634b = r2;
                                this.f19635c = r3;
                                this.f19636d = r4;
                            }

                            @Override // android.view.MenuItem.OnMenuItemClickListener
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                try {
                                    if (this.f19634b[1] != null) {
                                        this.f19634b[1] = C3067ab.m18395c(this.f19634b[1]);
                                    } else {
                                        this.f19634b[1] = C3067ab.m18395c(this.f19634b[0]);
                                    }
                                    this.f19635c.setImageBitmap(this.f19634b[1]);
                                } catch (Exception e2) {
                                    C3112bn.m18999a(this.f19636d, R.string.error);
                                }
                                return true;
                            }
                        });
                        c0173ao.m1339a().add(0, 1401, 0, this.f19631b.getString(R.string.monochrome)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f19630a, this.f19632c, this.f19631b) { // from class: ru.maximoff.apktool.util.j.9.2

                            /* renamed from: a */
                            private final AnonymousClass9 f19637a;

                            /* renamed from: b */
                            private final Bitmap[] f19638b;

                            /* renamed from: c */
                            private final ImageView f19639c;

                            /* renamed from: d */
                            private final Context f19640d;

                            {
                                this.f19637a = this;
                                this.f19638b = r2;
                                this.f19639c = r3;
                                this.f19640d = r4;
                            }

                            @Override // android.view.MenuItem.OnMenuItemClickListener
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                try {
                                    if (this.f19638b[1] != null) {
                                        this.f19638b[1] = C3067ab.m18397d(this.f19638b[1]);
                                    } else {
                                        this.f19638b[1] = C3067ab.m18397d(this.f19638b[0]);
                                    }
                                    this.f19639c.setImageBitmap(this.f19638b[1]);
                                } catch (Exception e2) {
                                    C3112bn.m18999a(this.f19640d, R.string.error);
                                }
                                return true;
                            }
                        });
                        c0173ao.m1339a().add(0, 1402, 0, this.f19631b.getString(R.string.search_reset)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f19630a, this.f19632c) { // from class: ru.maximoff.apktool.util.j.9.3

                            /* renamed from: a */
                            private final AnonymousClass9 f19641a;

                            /* renamed from: b */
                            private final Bitmap[] f19642b;

                            /* renamed from: c */
                            private final ImageView f19643c;

                            {
                                this.f19641a = this;
                                this.f19642b = r2;
                                this.f19643c = r3;
                            }

                            @Override // android.view.MenuItem.OnMenuItemClickListener
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                if (this.f19642b[1] != null) {
                                    this.f19642b[1].recycle();
                                }
                                this.f19642b[1] = (Bitmap) null;
                                this.f19643c.setImageBitmap(this.f19642b[0]);
                                return true;
                            }
                        });
                        c0173ao.m1344c();
                        return true;
                    }
                    C3112bn.m18999a(this.f19631b, R.string.error);
                    return true;
                }
            });
            DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(context).m418a(R.string.create_icon).m435b(inflate).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(checkBoxArr, checkBox9, checkBox10, context, strArr3, spinner, spinner2, checkBox, checkBox2, editText, c3212b, editText2, c3212b2, bitmapArr, interfaceC2995n, strArr, strArr2, file) { // from class: ru.maximoff.apktool.util.j.10

                /* renamed from: a */
                private final CheckBox[] f19571a;

                /* renamed from: b */
                private final CheckBox f19572b;

                /* renamed from: c */
                private final CheckBox f19573c;

                /* renamed from: d */
                private final Context f19574d;

                /* renamed from: e */
                private final String[] f19575e;

                /* renamed from: f */
                private final Spinner f19576f;

                /* renamed from: g */
                private final Spinner f19577g;

                /* renamed from: h */
                private final CheckBox f19578h;

                /* renamed from: i */
                private final CheckBox f19579i;

                /* renamed from: j */
                private final EditText f19580j;

                /* renamed from: k */
                private final C3212b f19581k;

                /* renamed from: l */
                private final EditText f19582l;

                /* renamed from: m */
                private final C3212b f19583m;

                /* renamed from: n */
                private final Bitmap[] f19584n;

                /* renamed from: o */
                private final InterfaceC2995n f19585o;

                /* renamed from: p */
                private final String[] f19586p;

                /* renamed from: q */
                private final String[] f19587q;

                /* renamed from: r */
                private final File f19588r;

                {
                    this.f19571a = checkBoxArr;
                    this.f19572b = checkBox9;
                    this.f19573c = checkBox10;
                    this.f19574d = context;
                    this.f19575e = strArr3;
                    this.f19576f = spinner;
                    this.f19577g = spinner2;
                    this.f19578h = checkBox;
                    this.f19579i = checkBox2;
                    this.f19580j = editText;
                    this.f19581k = c3212b;
                    this.f19582l = editText2;
                    this.f19583m = c3212b2;
                    this.f19584n = bitmapArr;
                    this.f19585o = interfaceC2995n;
                    this.f19586p = strArr;
                    this.f19587q = strArr2;
                    this.f19588r = file;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    String str2;
                    String str3;
                    Bitmap bitmap;
                    boolean[] zArr = new boolean[this.f19571a.length + 2];
                    zArr[0] = this.f19572b.isChecked();
                    zArr[1] = this.f19573c.isChecked();
                    for (int i3 = 0; i3 < this.f19571a.length; i3++) {
                        zArr[i3 + 2] = this.f19571a[i3].isChecked();
                    }
                    for (int i4 = 0; i4 < zArr.length; i4++) {
                        C3102bd.m18938b(this.f19574d, this.f19575e[i4], zArr[i4]);
                    }
                    int selectedItemPosition = this.f19576f.getSelectedItemPosition();
                    int selectedItemPosition2 = this.f19577g.getSelectedItemPosition();
                    C3102bd.m18938b(this.f19574d, "ic_create_icn", this.f19578h.isChecked());
                    C3102bd.m18938b(this.f19574d, "ic_create_ricn", this.f19579i.isChecked());
                    C3102bd.m18935b(this.f19574d, "ic_create_type", selectedItemPosition);
                    C3102bd.m18935b(this.f19574d, "ic_create_format", selectedItemPosition2);
                    if (this.f19578h.isChecked()) {
                        str2 = this.f19580j.getText().toString();
                        this.f19581k.m19204a(str2);
                    } else {
                        str2 = (String) null;
                    }
                    if (this.f19579i.isChecked()) {
                        str3 = this.f19582l.getText().toString();
                        this.f19583m.m19204a(str3);
                    } else {
                        str3 = (String) null;
                    }
                    dialogInterface.cancel();
                    try {
                        if (this.f19584n[1] != null) {
                            bitmap = this.f19584n[1];
                        } else {
                            bitmap = this.f19584n[0];
                        }
                        new a(this.f19574d, this.f19585o, bitmap, str2, str3, this.f19586p[selectedItemPosition], this.f19587q[selectedItemPosition2], zArr).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f19588r);
                    } catch (Exception e2) {
                        C3112bn.m18999a(this.f19574d, R.string.error_try_again);
                    }
                }
            }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
            m438b.getWindow().setSoftInputMode(4);
            m438b.setOnShowListener(new DialogInterface.OnShowListener(buttonArr, m438b, spinner, context, spinner2, checkBox, editText, editText2) { // from class: ru.maximoff.apktool.util.j.11

                /* renamed from: a */
                private final Button[] f19589a;

                /* renamed from: b */
                private final DialogInterfaceC0070b f19590b;

                /* renamed from: c */
                private final Spinner f19591c;

                /* renamed from: d */
                private final Context f19592d;

                /* renamed from: e */
                private final Spinner f19593e;

                /* renamed from: f */
                private final CheckBox f19594f;

                /* renamed from: g */
                private final EditText f19595g;

                /* renamed from: h */
                private final EditText f19596h;

                {
                    this.f19589a = buttonArr;
                    this.f19590b = m438b;
                    this.f19591c = spinner;
                    this.f19592d = context;
                    this.f19593e = spinner2;
                    this.f19594f = checkBox;
                    this.f19595g = editText;
                    this.f19596h = editText2;
                }

                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    this.f19589a[0] = this.f19590b.m414a(-1);
                    this.f19591c.setSelection(C3102bd.m18905a(this.f19592d, "ic_create_type", 0));
                    this.f19593e.setSelection(C3102bd.m18905a(this.f19592d, "ic_create_format", 0));
                    if (this.f19594f.isChecked()) {
                        this.f19595g.requestFocus();
                        this.f19595g.selectAll();
                    } else {
                        this.f19596h.requestFocus();
                        this.f19596h.selectAll();
                    }
                }
            });
            m438b.show();
        } catch (Error e2) {
            C3112bn.m19000a(context, R.string.errorf, e2.getMessage());
        } catch (Exception e3) {
            C3112bn.m19000a(context, R.string.errorf, e3.getMessage());
        }
    }

    /* renamed from: a */
    public static Bitmap m19502a(Context context, File file, C3099ba c3099ba, Drawable drawable) {
        int max;
        int i;
        int max2;
        int i2;
        if (file.getName().toLowerCase().endsWith(".apk")) {
            return new C3060a(context, file).m18266d();
        }
        if (c3099ba != null && c3099ba.m18881j()) {
            String m18882k = c3099ba.m18882k();
            int m18875d = c3099ba.m18875d();
            int m18876e = c3099ba.m18876e();
            if (m18875d > m18876e) {
                i2 = Math.max(1, Math.abs((m18876e * 512) / m18875d));
                max2 = 512;
            } else {
                max2 = Math.max(1, Math.abs((m18875d * 512) / m18876e));
                i2 = 512;
            }
            return C3067ab.m18378a(m18882k, max2, i2);
        }
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > intrinsicHeight) {
                i = Math.max(1, Math.abs((intrinsicHeight * 512) / intrinsicWidth));
                max = 512;
            } else {
                max = Math.max(1, Math.abs((intrinsicWidth * 512) / intrinsicHeight));
                i = 512;
            }
            return C3067ab.m18373a(drawable, max, i);
        }
        return C3067ab.m18391b(file, 512);
    }

    /* compiled from: CreateIcon.java */
    /* renamed from: ru.maximoff.apktool.util.j$a */
    private static class a extends AbstractAsyncTaskC2898a {

        /* renamed from: a */
        private Context f19644a;

        /* renamed from: b */
        private Bitmap f19645b;

        /* renamed from: c */
        private String f19646c;

        /* renamed from: d */
        private String f19647d;

        /* renamed from: e */
        private String f19648e;

        /* renamed from: f */
        private String f19649f;

        /* renamed from: g */
        private boolean[] f19650g;

        public a(Context context, InterfaceC2995n interfaceC2995n, Bitmap bitmap, String str, String str2, String str3, String str4, boolean[] zArr) {
            super(context, interfaceC2995n);
            this.f19644a = context;
            this.f19645b = bitmap;
            this.f19646c = str;
            this.f19647d = str2;
            this.f19648e = str3;
            this.f19649f = str4;
            this.f19650g = zArr;
        }

        @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
        /* renamed from: c */
        protected int mo17065c() {
            return R.string.create_icon;
        }

        @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
        /* renamed from: a */
        protected boolean mo17058a(File file) {
            return false;
        }

        @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
        /* renamed from: a */
        protected Boolean mo17049a(File[] fileArr) {
            File m19504a = m19504a(fileArr[0], "res", this);
            if (m19504a != null) {
                m19504a.mkdirs();
                try {
                    Bitmap m18367a = C3067ab.m18367a(C3067ab.m18368a(this.f19645b, 192));
                    for (int i = 0; i < C3067ab.f17243b.length; i++) {
                        if (this.f19650g[i + 2]) {
                            File file = new File(m19504a, new StringBuffer().append(new StringBuffer().append(this.f19648e).append("-").toString()).append(C3067ab.f17243b[i]).toString());
                            file.mkdirs();
                            if (this.f19646c != null) {
                                File file2 = new File(file, new StringBuffer().append(new StringBuffer().append(C3112bn.m19033h(this.f19646c)).append(".").toString()).append(this.f19649f).toString());
                                if (C3067ab.m18384a(C3067ab.m18369a(m18367a, C3067ab.f17242a[i], C3067ab.f17242a[i]), file2, this.f19649f) != null) {
                                    mo3984d(R.string.successf, file2.getAbsolutePath());
                                }
                            }
                            if (this.f19647d != null) {
                                File file3 = new File(file, new StringBuffer().append(new StringBuffer().append(C3112bn.m19033h(this.f19647d)).append(".").toString()).append(this.f19649f).toString());
                                if (C3067ab.m18384a(C3067ab.m18399f(C3067ab.m18369a(m18367a, C3067ab.f17242a[i], C3067ab.f17242a[i])), file3, this.f19649f) != null) {
                                    mo3984d(R.string.successf, file3.getAbsolutePath());
                                }
                            }
                        }
                    }
                    if (this.f19650g[0] || this.f19650g[1]) {
                        Bitmap m18368a = C3067ab.m18368a(this.f19645b, C3102bd.m18905a(this.f19644a, "aicon_size", 108));
                        if (this.f19650g[0]) {
                            File file4 = new File(m19504a, new StringBuffer().append(this.f19648e).append("-v24").toString());
                            file4.mkdirs();
                            Bitmap m18367a2 = C3067ab.m18367a(m18368a);
                            if (this.f19646c != null) {
                                File file5 = new File(file4, new StringBuffer().append(C3112bn.m19033h(this.f19646c)).append(".xml").toString());
                                new C3118c(m18367a2).m19079a(file5);
                                mo3984d(R.string.successf, file5.getAbsolutePath());
                            }
                            if (this.f19647d != null) {
                                File file6 = new File(file4, new StringBuffer().append(C3112bn.m19033h(this.f19647d)).append(".xml").toString());
                                new C3118c(C3067ab.m18399f(m18367a2)).m19079a(file6);
                                mo3984d(R.string.successf, file6.getAbsolutePath());
                            }
                        }
                        if (this.f19650g[1]) {
                            int m18398e = C3067ab.m18398e(m18368a);
                            File file7 = new File(m19504a, new StringBuffer().append(this.f19648e).append("-anydpi-v26").toString());
                            file7.mkdirs();
                            if (this.f19646c != null) {
                                File file8 = new File(file7, new StringBuffer().append(C3112bn.m19033h(this.f19646c)).append(".xml").toString());
                                C3118c c3118c = new C3118c(C3067ab.m18371a(m18368a, false));
                                c3118c.m19078a(m18398e);
                                c3118c.m19083c(file8);
                                mo3984d(R.string.successf, file8.getAbsolutePath());
                            }
                            if (this.f19647d != null) {
                                File file9 = new File(file7, new StringBuffer().append(C3112bn.m19033h(this.f19647d)).append(".xml").toString());
                                C3118c c3118c2 = new C3118c(C3067ab.m18371a(m18368a, true));
                                c3118c2.m19078a(m18398e);
                                c3118c2.m19083c(file9);
                                mo3984d(R.string.successf, file9.getAbsolutePath());
                            }
                        }
                    }
                    m17060b(m19504a);
                    return new Boolean(true);
                } catch (Error e2) {
                    mo3979a(R.string.errorf, e2.getMessage());
                } catch (Exception e3) {
                    mo3979a(R.string.errorf, e3.getMessage());
                }
            } else {
                mo3979a(R.string.errorf, "failed to create a folder");
            }
            return new Boolean(false);
        }

        @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
        /* renamed from: e */
        protected boolean mo17071e() {
            return true;
        }

        /* renamed from: a */
        public File m19504a(File file, String str, AbstractAsyncTaskC2898a abstractAsyncTaskC2898a) {
            String stringBuffer;
            String parent = file.getParent();
            if (str == null) {
                stringBuffer = file.getName();
            } else {
                stringBuffer = new StringBuffer().append(str).append(new StringBuffer().append("_").append(file.getName()).toString()).toString();
            }
            int lastIndexOf = stringBuffer.lastIndexOf(46);
            if (lastIndexOf >= 0) {
                stringBuffer = stringBuffer.substring(0, lastIndexOf);
            }
            boolean m18925a = C3102bd.m18925a(this.f19644a, "overwrite_apk", false);
            boolean m18925a2 = C3102bd.m18925a(this.f19644a, "all_to_out_dir", false);
            boolean z = !C3262u.m19664g(this.f19644a, file);
            if (m18925a2 || z) {
                parent = C3102bd.f18339v;
                if (parent == null) {
                    abstractAsyncTaskC2898a.mo3983c(R.string.output_directory_not_set, new Object[0]);
                    return (File) null;
                }
                File file2 = new File(parent);
                if (!file2.exists() && !file2.mkdirs()) {
                    abstractAsyncTaskC2898a.mo3983c(R.string.output_directory_not_extsts, parent);
                    return (File) null;
                }
                if (!file2.isDirectory()) {
                    abstractAsyncTaskC2898a.mo3983c(R.string.not_directory, parent);
                    return (File) null;
                }
            }
            if (!m18925a) {
                stringBuffer = C3262u.m19566a(this.f19644a, parent, stringBuffer, "", 0);
            }
            return new File(parent, stringBuffer);
        }
    }
}
