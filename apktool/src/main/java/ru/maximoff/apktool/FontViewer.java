package ru.maximoff.apktool;

import android.C0012R;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.p008os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.p209io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3106bh;
import ru.maximoff.apktool.util.C3108bj;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3246h;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.C3262u;

/* loaded from: classes.dex */
public class FontViewer extends AbstractActivityC2894b {

    /* renamed from: h */
    private String f14078h;

    /* renamed from: i */
    private File f14079i;

    /* renamed from: j */
    private List<File> f14080j;

    /* renamed from: k */
    private int f14081k;

    /* renamed from: l */
    private TextView f14082l;

    /* renamed from: m */
    private TextView f14083m;

    /* renamed from: n */
    private TextView f14084n;

    /* renamed from: o */
    private TextView f14085o;

    /* renamed from: p */
    private TextView f14086p;

    /* renamed from: q */
    private TextView f14087q;

    /* renamed from: r */
    private TextView f14088r;

    @Override // ru.maximoff.apktool.AbstractActivityC2894b
    /* renamed from: a */
    protected void mo16413a(Bundle bundle) {
    }

    @Override // ru.maximoff.apktool.AbstractActivityC2894b, androidx.fragment.app.ActivityC0375f, androidx.activity.ActivityC0048b, androidx.core.app.ActivityC0234e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.font_view);
        Intent intent = getIntent();
        if (intent == null || !intent.hasExtra("data")) {
            C3112bn.m19023b(this, getString(R.string.errorf, getString(R.string.no_data)));
            finish();
            return;
        }
        this.f14079i = new File(intent.getStringExtra("data"));
        this.f14080j = new ArrayList();
        this.f14081k = 0;
        this.f14078h = C3102bd.m18910a(this, "font_viewer_text", getString(R.string.app_name));
        this.f14082l = (TextView) findViewById(R.id.fontviewTextView1);
        this.f14083m = (TextView) findViewById(R.id.fontviewTextView2);
        this.f14084n = (TextView) findViewById(R.id.fontviewTextView3);
        this.f14085o = (TextView) findViewById(R.id.fontviewTextView4);
        this.f14086p = (TextView) findViewById(R.id.fontviewTextView5);
        this.f14087q = (TextView) findViewById(R.id.fontviewTextView6);
        this.f14088r = (TextView) findViewById(R.id.fontviewTextView7);
        this.f14082l.setTextSize(2, C3102bd.f18332o);
        m16592a(this.f14079i.getParentFile());
        m16601o();
    }

    /* renamed from: a */
    private void m16592a(File file) {
        File[] listFiles = file.listFiles(new FileFilter(this) { // from class: ru.maximoff.apktool.FontViewer.1

            /* renamed from: a */
            private final FontViewer f14089a;

            {
                this.f14089a = this;
            }

            @Override // java.p209io.FileFilter
            public boolean accept(File file2) {
                String lowerCase = file2.getName().toLowerCase();
                return file2.isFile() && (lowerCase.endsWith(".ttf") || lowerCase.endsWith(".otf"));
            }
        });
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        Arrays.sort(listFiles, new C3108bj(this, file));
        for (int i = 0; i < listFiles.length; i++) {
            if (this.f14079i.equals(listFiles[i])) {
                this.f14081k = i;
            }
            this.f14080j.add(i, listFiles[i]);
        }
        invalidateOptionsMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m16601o() {
        String format;
        try {
            if (this.f14080j.size() < 2) {
                format = this.f14079i.getName();
            } else {
                format = String.format("[%d/%d] %s", new Integer(this.f14081k + 1), new Integer(this.f14080j.size()), this.f14079i.getName());
            }
            setTitle(format);
            Typeface createFromFile = Typeface.createFromFile(this.f14079i);
            if (createFromFile == null || createFromFile.equals(Typeface.DEFAULT)) {
                throw new Exception("invalid font file");
            }
            this.f14082l.setTypeface(createFromFile);
            this.f14083m.setTypeface(createFromFile);
            this.f14084n.setTypeface(createFromFile);
            this.f14085o.setTypeface(createFromFile);
            this.f14086p.setTypeface(createFromFile);
            this.f14087q.setTypeface(createFromFile);
            this.f14088r.setTypeface(createFromFile);
            m16602p();
        } catch (Exception e2) {
            String string = getString(R.string.failed_open, this.f14079i.getAbsolutePath());
            SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(new ForegroundColorSpan(C3246h.m19470a(this, R.color.dark_red)), 0, string.length(), 33);
            m16591a(spannableString);
            C3112bn.m19023b(this, spannableString.toString());
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.font_view, menu);
        if (C3102bd.f18291a) {
            menu.findItem(R.id.previous).setIcon(R.drawable.ic_left);
            menu.findItem(R.id.next).setIcon(R.drawable.ic_right);
        } else {
            menu.findItem(R.id.previous).setIcon(R.drawable.ic_left_dark);
            menu.findItem(R.id.next).setIcon(R.drawable.ic_right_dark);
        }
        menu.findItem(R.id.previous).setVisible(this.f14080j.size() > 1);
        menu.findItem(R.id.next).setVisible(this.f14080j.size() > 1);
        menu.findItem(R.id.delete).setEnabled(C3262u.m19664g(this, this.f14079i));
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.exit /* 2131690197 */:
                finish();
                break;
            case R.id.previous /* 2131690211 */:
                this.f14081k--;
                if (this.f14081k < 0) {
                    this.f14081k = this.f14080j.size() - 1;
                }
                this.f14079i = this.f14080j.get(this.f14081k);
                m16601o();
                break;
            case R.id.next /* 2131690212 */:
                this.f14081k++;
                if (this.f14081k >= this.f14080j.size()) {
                    this.f14081k = 0;
                }
                this.f14079i = this.f14080j.get(this.f14081k);
                m16601o();
                break;
            case R.id.properties /* 2131690252 */:
                DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this).m418a(R.string.properties).m436b(getString(R.string.editor_prop_dialog, this.f14079i.getName(), this.f14079i.getAbsolutePath(), C3106bh.m18975a(this.f14079i.length(), C3102bd.f18305am))).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m438b();
                m438b.setOnShowListener(new DialogInterface.OnShowListener(this, m438b) { // from class: ru.maximoff.apktool.FontViewer.2

                    /* renamed from: a */
                    private final FontViewer f14090a;

                    /* renamed from: b */
                    private final DialogInterfaceC0070b f14091b;

                    {
                        this.f14090a = this;
                        this.f14091b = m438b;
                    }

                    @Override // android.content.DialogInterface.OnShowListener
                    public void onShow(DialogInterface dialogInterface) {
                        TextView textView = (TextView) this.f14091b.findViewById(C0012R.id.message);
                        if (textView != null) {
                            textView.setTextIsSelectable(true);
                        }
                    }
                });
                m438b.show();
                break;
            case R.id.delete /* 2131690255 */:
                new DialogInterfaceC0070b.a(this).m418a(R.string.delete).m436b(this.f14079i.getName()).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.FontViewer.6

                    /* renamed from: a */
                    private final FontViewer f14100a;

                    {
                        this.f14100a = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        this.f14100a.f14079i.delete();
                        this.f14100a.f14080j.remove(this.f14100a.f14081k);
                        if (this.f14100a.f14080j.isEmpty()) {
                            this.f14100a.finish();
                            return;
                        }
                        if (this.f14100a.f14081k >= this.f14100a.f14080j.size()) {
                            this.f14100a.f14081k = 0;
                        }
                        this.f14100a.f14079i = (File) this.f14100a.f14080j.get(this.f14100a.f14081k);
                        this.f14100a.m16601o();
                        this.f14100a.invalidateOptionsMenu();
                    }
                }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
                break;
            case R.id.edit_text /* 2131690287 */:
                View inflate = getLayoutInflater().inflate(R.layout.rename_one, (ViewGroup) null);
                ((LinearLayout) inflate.findViewById(R.id.renameoneLinearLayout1)).setVisibility(8);
                EditText editText = (EditText) inflate.findViewById(R.id.renameoneEditText1);
                editText.setText(C3102bd.m18910a(this, "font_viewer_text", getString(R.string.app_name)));
                editText.setHint(R.string.search_hint);
                DialogInterfaceC0070b m438b2 = new DialogInterfaceC0070b.a(this).m418a(R.string.search_hint).m435b(inflate).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, editText) { // from class: ru.maximoff.apktool.FontViewer.3

                    /* renamed from: a */
                    private final FontViewer f14092a;

                    /* renamed from: b */
                    private final EditText f14093b;

                    {
                        this.f14092a = this;
                        this.f14093b = editText;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        this.f14092a.f14078h = this.f14093b.getText().toString();
                        C3102bd.m18937b(this.f14092a, "font_viewer_text", this.f14092a.f14078h);
                        this.f14092a.m16602p();
                        dialogInterface.dismiss();
                    }
                }).m440c(R.string.search_reset, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.FontViewer.4

                    /* renamed from: a */
                    private final FontViewer f14094a;

                    {
                        this.f14094a = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        this.f14094a.f14078h = this.f14094a.getString(R.string.app_name);
                        C3102bd.m18924a(this.f14094a, "font_viewer_text");
                        this.f14094a.m16602p();
                        dialogInterface.dismiss();
                    }
                }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
                m438b2.getWindow().setSoftInputMode(4);
                m438b2.setOnShowListener(new DialogInterface.OnShowListener(this, m438b2, editText) { // from class: ru.maximoff.apktool.FontViewer.5

                    /* renamed from: a */
                    private final FontViewer f14095a;

                    /* renamed from: b */
                    private final DialogInterfaceC0070b f14096b;

                    /* renamed from: c */
                    private final EditText f14097c;

                    {
                        this.f14095a = this;
                        this.f14096b = m438b2;
                        this.f14097c = editText;
                    }

                    @Override // android.content.DialogInterface.OnShowListener
                    public void onShow(DialogInterface dialogInterface) {
                        Button m414a = this.f14096b.m414a(-1);
                        m414a.setEnabled(this.f14097c.getText().length() > 0);
                        this.f14097c.addTextChangedListener(new TextWatcher(this, m414a) { // from class: ru.maximoff.apktool.FontViewer.5.1

                            /* renamed from: a */
                            private final DialogInterfaceOnShowListenerC27315 f14098a;

                            /* renamed from: b */
                            private final Button f14099b;

                            {
                                this.f14098a = this;
                                this.f14099b = m414a;
                            }

                            @Override // android.text.TextWatcher
                            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                            }

                            @Override // android.text.TextWatcher
                            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                            }

                            @Override // android.text.TextWatcher
                            public void afterTextChanged(Editable editable) {
                                this.f14099b.setEnabled(editable.length() > 0);
                            }
                        });
                        this.f14097c.requestFocus();
                        this.f14097c.selectAll();
                    }
                });
                m438b2.show();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.activity.ActivityC0048b, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m16602p() {
        StringBuilder sb = new StringBuilder();
        sb.append(C3249i.f19555o);
        sb.append('\n');
        sb.append(C3249i.f19555o.toUpperCase());
        sb.append('\n');
        sb.append(C3249i.f19556p);
        sb.append('\n');
        sb.append(C3249i.f19556p.toUpperCase());
        sb.append('\n');
        for (int i = 0; i < 10; i++) {
            sb.append(String.valueOf(i));
        }
        for (int i2 = 0; i2 < 10; i2++) {
            sb.append(String.valueOf(i2));
        }
        sb.append('\n');
        sb.append(". : , ; ' \" ! ? + - * / % = ~ |");
        sb.append('\n');
        sb.append("@ # $ _ ^ \\ & < > ( ) [ ] { }");
        this.f14082l.setText(sb);
        this.f14083m.setText(this.f14078h);
        this.f14084n.setText(this.f14078h);
        this.f14085o.setText(this.f14078h);
        this.f14086p.setText(this.f14078h);
        this.f14087q.setText(this.f14078h);
        this.f14088r.setText(this.f14078h);
    }

    /* renamed from: a */
    private void m16591a(SpannableString spannableString) {
        this.f14082l.setTypeface(Typeface.DEFAULT);
        this.f14082l.setText(spannableString);
        this.f14083m.setText("");
        this.f14084n.setText("");
        this.f14085o.setText("");
        this.f14086p.setText("");
        this.f14087q.setText("");
        this.f14088r.setText("");
    }
}
