package ru.maximoff.apktool.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaCodec;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.widget.C0173ao;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.util.Iterator;
import java.util.List;
import ru.maximoff.apktool.util.C3066aa;
import ru.maximoff.apktool.util.C3079ak;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3261t;
import ru.maximoff.apktool.util.C3262u;

/* loaded from: classes.dex */
public class KeystorePreference extends CustomPreference implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    public DialogInterface.OnClickListener f16971a;

    /* renamed from: b */
    private Spinner f16972b;

    /* renamed from: c */
    private EditText f16973c;

    /* renamed from: d */
    private TextView f16974d;

    /* renamed from: e */
    private EditText f16975e;

    /* renamed from: f */
    private LinearLayout f16976f;

    /* renamed from: g */
    private EditText f16977g;

    /* renamed from: h */
    private EditText f16978h;

    /* renamed from: i */
    private ImageButton f16979i;

    /* renamed from: j */
    private ImageButton f16980j;

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public KeystorePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16971a = new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.preference.KeystorePreference.2

            /* renamed from: a */
            private final KeystorePreference f17003a;

            {
                this.f17003a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == -1) {
                    SharedPreferences.Editor edit = this.f17003a.getSharedPreferences().edit();
                    edit.putInt("key_type", this.f17003a.f16972b.getSelectedItemPosition());
                    edit.putString("key_path", this.f17003a.f16973c.getText().toString());
                    edit.putString("cert_or_alias", this.f17003a.f16975e.getText().toString());
                    edit.putString("store_pass", this.f17003a.f16977g.getText().toString());
                    edit.putString("key_pass", this.f17003a.f16978h.getText().toString());
                    edit.commit();
                    return;
                }
                if (i == -3) {
                    SharedPreferences.Editor edit2 = this.f17003a.getSharedPreferences().edit();
                    edit2.putString("store_pass", "");
                    edit2.putString("key_pass", "");
                    edit2.commit();
                }
            }
        };
    }

    @Override // android.preference.Preference
    protected void onClick() {
        Context context = getContext();
        C3066aa c3066aa = new C3066aa(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.keystore, (ViewGroup) null);
        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(context);
        aVar.m435b(inflate);
        aVar.m418a(R.string.signature_file);
        aVar.m434b(R.string.cancel, this.f16971a);
        aVar.m420a(R.string.save, this.f16971a);
        Bitmap m18363a = c3066aa.m18363a(!C3102bd.f18291a ? -16777216 : Color.DKGRAY, R.drawable.ic_folder);
        this.f16972b = (Spinner) inflate.findViewById(R.id.format);
        this.f16973c = (EditText) inflate.findViewById(R.id.key_path);
        this.f16974d = (TextView) inflate.findViewById(R.id.cert);
        this.f16975e = (EditText) inflate.findViewById(R.id.alias);
        this.f16976f = (LinearLayout) inflate.findViewById(R.id.password);
        this.f16977g = (EditText) inflate.findViewById(R.id.storePass);
        this.f16978h = (EditText) inflate.findViewById(R.id.keyPass);
        this.f16979i = (ImageButton) inflate.findViewById(R.id.keystoreImageButton1);
        this.f16980j = (ImageButton) inflate.findViewById(R.id.keystoreImageButton2);
        this.f16979i.setImageBitmap(m18363a);
        this.f16980j.setImageBitmap(m18363a);
        this.f16972b.setOnItemSelectedListener(this);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.passwordImageView1);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.passwordImageView2);
        C3080al.m18559a(imageView, this.f16977g);
        C3080al.m18559a(imageView2, this.f16978h);
        SharedPreferences sharedPreferences = getSharedPreferences();
        this.f16972b.setSelection(sharedPreferences.getInt("key_type", 0));
        this.f16973c.setText(sharedPreferences.getString("key_path", ""));
        this.f16975e.setText(sharedPreferences.getString("cert_or_alias", ""));
        this.f16977g.setText(sharedPreferences.getString("store_pass", ""));
        this.f16978h.setText(sharedPreferences.getString("key_pass", ""));
        ViewOnClickListenerC30291 viewOnClickListenerC30291 = new ViewOnClickListenerC30291(this, context);
        this.f16979i.setOnClickListener(viewOnClickListenerC30291);
        this.f16980j.setOnClickListener(viewOnClickListenerC30291);
        aVar.m438b().show();
    }

    /* renamed from: ru.maximoff.apktool.preference.KeystorePreference$1 */
    class ViewOnClickListenerC30291 implements View.OnClickListener {

        /* renamed from: a */
        private final KeystorePreference f16981a;

        /* renamed from: b */
        private final Context f16982b;

        ViewOnClickListenerC30291(KeystorePreference keystorePreference, Context context) {
            this.f16981a = keystorePreference;
            this.f16982b = context;
        }

        /* renamed from: a */
        static KeystorePreference m18120a(ViewOnClickListenerC30291 viewOnClickListenerC30291) {
            return viewOnClickListenerC30291.f16981a;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C3261t c3261t = new C3261t(this.f16982b);
            Runnable runnable = new Runnable(this, c3261t, this.f16982b, view) { // from class: ru.maximoff.apktool.preference.KeystorePreference.1.1

                /* renamed from: a */
                private final ViewOnClickListenerC30291 f16983a;

                /* renamed from: b */
                private final C3261t f16984b;

                /* renamed from: c */
                private final Context f16985c;

                /* renamed from: d */
                private final View f16986d;

                {
                    this.f16983a = this;
                    this.f16984b = c3261t;
                    this.f16985c = r3;
                    this.f16986d = view;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String path = this.f16984b.getPath();
                    if (path.toLowerCase().endsWith(".key") && C3079ak.m18515b(path)) {
                        C3112bn.m19000a(this.f16985c, R.string.load_signature_file_fail, path);
                        return;
                    }
                    if (this.f16986d.getId() == R.id.keystoreImageButton1) {
                        ViewOnClickListenerC30291.m18120a(this.f16983a).f16973c.requestFocus();
                        ViewOnClickListenerC30291.m18120a(this.f16983a).f16973c.setText(path);
                        ViewOnClickListenerC30291.m18120a(this.f16983a).f16973c.setSelection(path.length());
                    } else {
                        ViewOnClickListenerC30291.m18120a(this.f16983a).f16975e.requestFocus();
                        ViewOnClickListenerC30291.m18120a(this.f16983a).f16975e.setText(path);
                        ViewOnClickListenerC30291.m18120a(this.f16983a).f16975e.setSelection(path.length());
                    }
                }
            };
            String[] strArr = (String[]) null;
            String[] strArr2 = (String[]) null;
            switch (this.f16981a.f16972b.getSelectedItemPosition()) {
                case 0:
                    strArr = new String[]{"jks", "keystore", "key"};
                    break;
                case 1:
                    strArr = new String[]{"p12", "pfx", "jks"};
                    break;
                case 2:
                    strArr = new String[]{"bks", "jks"};
                    break;
                case 3:
                    strArr = new String[]{"pk8"};
                    strArr2 = new String[]{"x509.pem"};
                    break;
            }
            c3261t.m19545a("_ks");
            c3261t.setCallback(runnable);
            if (view.getId() != R.id.keystoreImageButton1) {
                strArr = strArr2;
            }
            c3261t.setFilter(strArr);
            c3261t.m19550e();
            DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(this.f16982b);
            aVar.m427a(c3261t.m19548c());
            aVar.m435b(c3261t);
            aVar.m420a(R.string.cancel, (DialogInterface.OnClickListener) null);
            aVar.m437b("/...", (DialogInterface.OnClickListener) null);
            aVar.m429a(false);
            aVar.m422a(new DialogInterface.OnKeyListener(this, c3261t) { // from class: ru.maximoff.apktool.preference.KeystorePreference.1.2

                /* renamed from: a */
                private final ViewOnClickListenerC30291 f16987a;

                /* renamed from: b */
                private final C3261t f16988b;

                {
                    this.f16987a = this;
                    this.f16988b = c3261t;
                }

                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                        return false;
                    }
                    boolean m19551f = this.f16988b.m19551f();
                    if (!m19551f) {
                        dialogInterface.dismiss();
                        return m19551f;
                    }
                    return m19551f;
                }
            });
            DialogInterfaceC0070b m438b = aVar.m438b();
            m438b.setOnShowListener(new DialogInterface.OnShowListener(this, m438b, this.f16982b, c3261t) { // from class: ru.maximoff.apktool.preference.KeystorePreference.1.3

                /* renamed from: a */
                private final ViewOnClickListenerC30291 f16989a;

                /* renamed from: b */
                private final DialogInterfaceC0070b f16990b;

                /* renamed from: c */
                private final Context f16991c;

                /* renamed from: d */
                private final C3261t f16992d;

                {
                    this.f16989a = this;
                    this.f16990b = m438b;
                    this.f16991c = r3;
                    this.f16992d = c3261t;
                }

                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    Button m414a = this.f16990b.m414a(-3);
                    m414a.setOnClickListener(new View.OnClickListener(this, this.f16991c, this.f16992d) { // from class: ru.maximoff.apktool.preference.KeystorePreference.1.3.1

                        /* renamed from: a */
                        private final AnonymousClass3 f16993a;

                        /* renamed from: b */
                        private final Context f16994b;

                        /* renamed from: c */
                        private final C3261t f16995c;

                        {
                            this.f16993a = this;
                            this.f16994b = r2;
                            this.f16995c = r3;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            int i;
                            String[] m19640b = C3262u.m19640b(this.f16994b);
                            if (m19640b != null) {
                                C0173ao c0173ao = new C0173ao(this.f16994b, view2);
                                if (C3102bd.m18910a(this.f16994b, "menu_position", "1").equals("0")) {
                                    i = 3;
                                } else {
                                    i = 5;
                                }
                                c0173ao.m1340a(i);
                                for (int i2 = 0; i2 < m19640b.length; i2++) {
                                    c0173ao.m1339a().add(0, i2 + MediaCodec.CodecException.ERROR_INSUFFICIENT_RESOURCE, 0, m19640b[i2]).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f16995c) { // from class: ru.maximoff.apktool.preference.KeystorePreference.1.3.1.1

                                        /* renamed from: a */
                                        private final AnonymousClass1 f16996a;

                                        /* renamed from: b */
                                        private final C3261t f16997b;

                                        {
                                            this.f16996a = this;
                                            this.f16997b = r2;
                                        }

                                        @Override // android.view.MenuItem.OnMenuItemClickListener
                                        public boolean onMenuItemClick(MenuItem menuItem) {
                                            this.f16997b.m19544a(new File(menuItem.getTitle().toString()));
                                            return true;
                                        }
                                    });
                                }
                                c0173ao.m1344c();
                            }
                        }
                    });
                    m414a.setOnLongClickListener(new View.OnLongClickListener(this, this.f16992d, this.f16991c) { // from class: ru.maximoff.apktool.preference.KeystorePreference.1.3.2

                        /* renamed from: a */
                        private final AnonymousClass3 f16998a;

                        /* renamed from: b */
                        private final C3261t f16999b;

                        /* renamed from: c */
                        private final Context f17000c;

                        {
                            this.f16998a = this;
                            this.f16999b = r2;
                            this.f17000c = r3;
                        }

                        @Override // android.view.View.OnLongClickListener
                        public boolean onLongClick(View view2) {
                            int i;
                            List<String> m19205b = this.f16999b.m19549d().m19205b();
                            if (m19205b.isEmpty()) {
                                return false;
                            }
                            C0173ao c0173ao = new C0173ao(this.f17000c, view2);
                            if (C3102bd.m18910a(this.f17000c, "menu_position", "1").equals("0")) {
                                i = 3;
                            } else {
                                i = 5;
                            }
                            c0173ao.m1340a(i);
                            Iterator<String> it = m19205b.iterator();
                            while (it.hasNext()) {
                                c0173ao.m1339a().add(0, 1300, 0, it.next()).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f16999b) { // from class: ru.maximoff.apktool.preference.KeystorePreference.1.3.2.1

                                    /* renamed from: a */
                                    private final AnonymousClass2 f17001a;

                                    /* renamed from: b */
                                    private final C3261t f17002b;

                                    {
                                        this.f17001a = this;
                                        this.f17002b = r2;
                                    }

                                    @Override // android.view.MenuItem.OnMenuItemClickListener
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        this.f17002b.m19544a(new File(menuItem.getTitle().toString()));
                                        return true;
                                    }
                                });
                            }
                            c0173ao.m1344c();
                            return true;
                        }
                    });
                }
            });
            c3261t.setDialog(m438b);
            m438b.show();
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == 3) {
            this.f16976f.setVisibility(8);
            this.f16980j.setVisibility(0);
            this.f16974d.setText(R.string.cert_path);
        } else {
            this.f16976f.setVisibility(0);
            this.f16980j.setVisibility(8);
            this.f16974d.setText(R.string.key_alias);
        }
    }
}
