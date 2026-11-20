package ru.maximoff.apktool.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.provider.Contacts;
import android.provider.Telephony;
import android.security.KeyChain;
import android.security.keystore.KeyProperties;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.p209io.FileOutputStream;
import java.p209io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Random;
import p165d.p167b.p173f.C1456aa;
import p165d.p167b.p173f.C1474as;
import p165d.p167b.p173f.C1486bd;
import p165d.p167b.p173f.C1492bj;
import p165d.p167b.p173f.C1496bn;
import p165d.p167b.p173f.C1500br;
import p165d.p167b.p173f.C1501bs;
import p165d.p167b.p173f.C1505e;
import p165d.p167b.p173f.C1514n;
import p165d.p167b.p173f.C1515o;
import p165d.p167b.p173f.C1517q;
import p165d.p167b.p173f.C1522v;
import p165d.p167b.p173f.C1523w;
import p165d.p167b.p173f.C1525y;
import p165d.p167b.p173f.C1526z;
import ru.maximoff.apktool.util.C3066aa;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3261t;

/* loaded from: classes.dex */
public class GenKeystorePreference extends CustomPreference implements TextWatcher, AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    private EditText f16920a;

    /* renamed from: b */
    private TextView f16921b;

    /* renamed from: c */
    private EditText f16922c;

    /* renamed from: d */
    private EditText f16923d;

    /* renamed from: e */
    private Button f16924e;

    /* renamed from: f */
    private Button f16925f;

    /* renamed from: g */
    private EditText f16926g;

    /* renamed from: h */
    private Spinner f16927h;

    /* renamed from: i */
    private boolean f16928i;

    /* renamed from: j */
    private EditText f16929j;

    /* renamed from: k */
    private EditText f16930k;

    /* renamed from: l */
    private EditText f16931l;

    /* renamed from: m */
    private EditText f16932m;

    /* renamed from: n */
    private EditText f16933n;

    /* renamed from: o */
    private View f16934o;

    /* renamed from: p */
    private EditText f16935p;

    /* renamed from: q */
    private EditText f16936q;

    /* renamed from: r */
    private EditText f16937r;

    /* renamed from: s */
    private TextView f16938s;

    /* renamed from: t */
    private Spinner f16939t;

    /* renamed from: u */
    private Spinner f16940u;

    /* renamed from: v */
    private ImageButton f16941v;

    /* renamed from: w */
    private String[] f16942w;

    /* renamed from: x */
    private boolean f16943x;

    /* renamed from: y */
    private DialogInterface.OnClickListener f16944y;

    /* renamed from: ru.maximoff.apktool.preference.GenKeystorePreference$a */
    public static class C3028a {

        /* renamed from: a */
        public String f16958a;

        /* renamed from: b */
        public String f16959b;

        /* renamed from: c */
        public String f16960c;

        /* renamed from: d */
        public long f16961d;

        /* renamed from: e */
        public String f16962e;

        /* renamed from: f */
        public String f16963f;

        /* renamed from: g */
        public int f16964g;

        /* renamed from: h */
        public String f16965h;

        /* renamed from: i */
        public String f16966i;

        /* renamed from: j */
        public String f16967j;

        /* renamed from: k */
        public String f16968k;

        /* renamed from: l */
        public String f16969l;

        /* renamed from: m */
        public int f16970m;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public GenKeystorePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16928i = false;
        this.f16944y = new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.preference.GenKeystorePreference.3

            /* renamed from: a */
            private final GenKeystorePreference f16957a;

            {
                this.f16957a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == -1) {
                    this.f16957a.m18111c();
                }
                dialogInterface.cancel();
            }
        };
    }

    @Override // android.preference.Preference
    protected void onClick() {
        this.f16943x = false;
        Context context = getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.genkey, (ViewGroup) null);
        this.f16942w = context.getResources().getStringArray(R.array.algorithmsArray);
        this.f16938s = (TextView) inflate.findViewById(R.id.algorithm_title);
        this.f16938s.setText(context.getString(R.string.sign_algorithm, ""));
        this.f16939t = (Spinner) inflate.findViewById(R.id.algorithm);
        int length = this.f16942w.length - 1;
        int i = 0;
        while (true) {
            if (i < this.f16942w.length) {
                if (this.f16942w[i].equals("SHA256withRSA")) {
                    break;
                } else {
                    i++;
                }
            } else {
                i = length;
                break;
            }
        }
        this.f16939t.setSelection(i);
        this.f16927h = (Spinner) inflate.findViewById(R.id.format);
        this.f16935p = (EditText) inflate.findViewById(R.id.path);
        this.f16920a = (EditText) inflate.findViewById(R.id.alias);
        this.f16937r = (EditText) inflate.findViewById(R.id.storePass);
        this.f16929j = (EditText) inflate.findViewById(R.id.keyPass);
        this.f16922c = (EditText) inflate.findViewById(R.id.name);
        this.f16933n = (EditText) inflate.findViewById(R.id.organizationUnit);
        this.f16932m = (EditText) inflate.findViewById(R.id.organizationName);
        this.f16931l = (EditText) inflate.findViewById(R.id.localityName);
        this.f16936q = (EditText) inflate.findViewById(R.id.stateName);
        this.f16923d = (EditText) inflate.findViewById(R.id.country);
        this.f16926g = (EditText) inflate.findViewById(R.id.date);
        this.f16940u = (Spinner) inflate.findViewById(R.id.date_format);
        this.f16940u.setSelection(0);
        this.f16921b = (TextView) inflate.findViewById(R.id.cert);
        this.f16930k = (EditText) inflate.findViewById(R.id.keySize);
        this.f16934o = inflate.findViewById(R.id.password);
        this.f16927h.setOnItemSelectedListener(this);
        this.f16935p.addTextChangedListener(this);
        this.f16920a.addTextChangedListener(this);
        this.f16937r.addTextChangedListener(this);
        this.f16926g.addTextChangedListener(this);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.genkeyImageView1);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.genkeyImageView2);
        C3080al.m18559a(imageView, this.f16937r);
        C3080al.m18559a(imageView2, this.f16929j);
        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(context);
        aVar.m435b(inflate);
        aVar.m418a(R.string.gen_key_title);
        aVar.m434b(R.string.cancel, this.f16944y);
        aVar.m420a(R.string.save, this.f16944y);
        DialogInterfaceC0070b m438b = aVar.m438b();
        m438b.show();
        m438b.getWindow().setSoftInputMode(16);
        this.f16924e = m438b.m414a(-1);
        this.f16925f = (Button) inflate.findViewById(R.id.create_and_use);
        this.f16925f.setOnClickListener(new View.OnClickListener(this, m438b) { // from class: ru.maximoff.apktool.preference.GenKeystorePreference.1

            /* renamed from: a */
            private final GenKeystorePreference f16945a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f16946b;

            {
                this.f16945a = this;
                this.f16946b = m438b;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C3028a m18111c = this.f16945a.m18111c();
                if (m18111c != null) {
                    SharedPreferences.Editor edit = this.f16945a.getSharedPreferences().edit();
                    edit.putInt("key_type", m18111c.f16970m);
                    edit.putString("key_path", m18111c.f16963f);
                    edit.putString("cert_or_alias", m18111c.f16958a);
                    edit.putString("store_pass", m18111c.f16969l);
                    edit.putString("key_pass", m18111c.f16962e);
                    edit.commit();
                }
                this.f16946b.cancel();
            }
        });
        Bitmap m18363a = new C3066aa(context).m18363a(!C3102bd.f18291a ? -16777216 : Color.DKGRAY, R.drawable.ic_folder);
        this.f16941v = (ImageButton) inflate.findViewById(R.id.genkeyImageButton1);
        this.f16941v.setImageBitmap(m18363a);
        this.f16941v.setOnClickListener(new ViewOnClickListenerC30262(this, context));
        m18104a();
    }

    /* renamed from: ru.maximoff.apktool.preference.GenKeystorePreference$2 */
    class ViewOnClickListenerC30262 implements View.OnClickListener {

        /* renamed from: a */
        private final GenKeystorePreference f16947a;

        /* renamed from: b */
        private final Context f16948b;

        ViewOnClickListenerC30262(GenKeystorePreference genKeystorePreference, Context context) {
            this.f16947a = genKeystorePreference;
            this.f16948b = context;
        }

        /* renamed from: a */
        static GenKeystorePreference m18114a(ViewOnClickListenerC30262 viewOnClickListenerC30262) {
            return viewOnClickListenerC30262.f16947a;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String[] strArr = {""};
            String[] strArr2 = {""};
            switch (this.f16947a.f16927h.getSelectedItemPosition()) {
                case 0:
                    strArr[0] = "jks";
                    break;
                case 1:
                    strArr[0] = "p12";
                    break;
                case 2:
                    strArr[0] = "bks";
                    break;
                case 3:
                    strArr[0] = "pk8";
                    strArr2[0] = "x509.pem";
                    break;
            }
            C3261t c3261t = new C3261t(this.f16948b);
            Runnable runnable = new Runnable(this, c3261t, strArr2, strArr) { // from class: ru.maximoff.apktool.preference.GenKeystorePreference.2.1

                /* renamed from: a */
                private final ViewOnClickListenerC30262 f16949a;

                /* renamed from: b */
                private final C3261t f16950b;

                /* renamed from: c */
                private final String[] f16951c;

                /* renamed from: d */
                private final String[] f16952d;

                {
                    this.f16949a = this;
                    this.f16950b = c3261t;
                    this.f16951c = strArr2;
                    this.f16952d = strArr;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String stringBuffer = new StringBuffer().append(new StringBuffer().append("/Key_").append(C3112bn.m19032g("yyyyMMdd_HHmmss")).toString()).append(".").toString();
                    if (ViewOnClickListenerC30262.m18114a(this.f16949a).f16927h.getSelectedItemPosition() == 3) {
                        ViewOnClickListenerC30262.m18114a(this.f16949a).f16920a.setText(new StringBuffer().append(new StringBuffer().append(this.f16950b.getPath()).append(stringBuffer).toString()).append(this.f16951c[0]).toString());
                    }
                    String stringBuffer2 = new StringBuffer().append(new StringBuffer().append(this.f16950b.getPath()).append(stringBuffer).toString()).append(this.f16952d[0]).toString();
                    ViewOnClickListenerC30262.m18114a(this.f16949a).f16935p.requestFocus();
                    ViewOnClickListenerC30262.m18114a(this.f16949a).f16935p.setText(stringBuffer2);
                    ViewOnClickListenerC30262.m18114a(this.f16949a).f16935p.setSelection(stringBuffer2.length());
                }
            };
            c3261t.m19545a("_ks");
            c3261t.setCallback(runnable);
            c3261t.m19550e();
            DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(this.f16948b);
            aVar.m427a(c3261t.m19548c());
            aVar.m435b(c3261t);
            aVar.m420a(R.string.mselect, new DialogInterface.OnClickListener(this, runnable) { // from class: ru.maximoff.apktool.preference.GenKeystorePreference.2.2

                /* renamed from: a */
                private final ViewOnClickListenerC30262 f16953a;

                /* renamed from: b */
                private final Runnable f16954b;

                {
                    this.f16953a = this;
                    this.f16954b = runnable;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f16954b.run();
                    dialogInterface.dismiss();
                }
            });
            aVar.m434b(R.string.cancel, (DialogInterface.OnClickListener) null);
            aVar.m429a(false);
            aVar.m422a(new DialogInterface.OnKeyListener(this, c3261t) { // from class: ru.maximoff.apktool.preference.GenKeystorePreference.2.3

                /* renamed from: a */
                private final ViewOnClickListenerC30262 f16955a;

                /* renamed from: b */
                private final C3261t f16956b;

                {
                    this.f16955a = this;
                    this.f16956b = c3261t;
                }

                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                        return false;
                    }
                    boolean m19551f = this.f16956b.m19551f();
                    if (!m19551f) {
                        dialogInterface.dismiss();
                        return m19551f;
                    }
                    return m19551f;
                }
            });
            DialogInterfaceC0070b m438b = aVar.m438b();
            c3261t.setDialog(m438b);
            m438b.show();
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        String stringBuffer;
        String editable = this.f16935p.getText().toString();
        if (!editable.isEmpty()) {
            this.f16928i = true;
            String replaceAll = editable.replaceAll("\\.(jks|p12|bks|pk8)$", "");
            switch (i) {
                case 0:
                    stringBuffer = new StringBuffer().append(replaceAll).append(".jks").toString();
                    break;
                case 1:
                    stringBuffer = new StringBuffer().append(replaceAll).append(".p12").toString();
                    break;
                case 2:
                    stringBuffer = new StringBuffer().append(replaceAll).append(".bks").toString();
                    break;
                case 3:
                    stringBuffer = new StringBuffer().append(replaceAll).append(".pk8").toString();
                    break;
                default:
                    stringBuffer = "";
                    break;
            }
            this.f16935p.setText(stringBuffer);
            this.f16935p.setSelection(stringBuffer.length());
            this.f16928i = false;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
                this.f16921b.setText(R.string.key_alias);
                this.f16934o.setVisibility(0);
                if (this.f16920a.getText().toString().startsWith("/")) {
                    this.f16920a.setText("");
                    break;
                }
                break;
            case 3:
                m18109b();
                this.f16921b.setText(R.string.cert_path);
                this.f16934o.setVisibility(8);
                this.f16929j.setText("");
                this.f16937r.setText("");
                break;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        m18104a();
        if (this.f16927h.getSelectedItemPosition() == 3) {
            m18109b();
        }
    }

    /* renamed from: a */
    private void m18104a() {
        boolean z = true;
        if (m18107a(this.f16935p) || m18107a(this.f16920a) || m18107a(this.f16926g) || (this.f16927h.getSelectedItemPosition() != 3 && m18107a(this.f16937r))) {
            z = false;
        }
        this.f16924e.setEnabled(z);
        this.f16925f.setEnabled(z);
    }

    /* renamed from: a */
    private boolean m18107a(EditText editText) {
        return editText.getText().toString().trim().length() == 0;
    }

    /* renamed from: b */
    private void m18109b() {
        String stringBuffer;
        if (this.f16928i) {
            return;
        }
        this.f16928i = true;
        String editable = this.f16935p.getText().toString();
        if (editable.isEmpty()) {
            stringBuffer = "";
        } else if (editable.endsWith(".pk8")) {
            stringBuffer = new StringBuffer().append(editable.substring(0, editable.length() - 3)).append("x509.pem").toString();
        } else {
            stringBuffer = new StringBuffer().append(editable).append(".x509.pem").toString();
        }
        this.f16920a.setText(stringBuffer);
        this.f16928i = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public C3028a m18111c() {
        Context context = getContext();
        C3028a c3028a = new C3028a();
        int selectedItemPosition = this.f16927h.getSelectedItemPosition();
        String trim = this.f16930k.getText().toString().trim();
        try {
            if (trim.equals("")) {
                c3028a.f16964g = 2048;
            } else {
                c3028a.f16964g = Integer.parseInt(trim);
            }
            c3028a.f16970m = selectedItemPosition;
            c3028a.f16963f = this.f16935p.getText().toString();
            c3028a.f16958a = this.f16920a.getText().toString();
            c3028a.f16969l = this.f16937r.getText().toString();
            c3028a.f16962e = this.f16929j.getText().toString();
            c3028a.f16959b = this.f16922c.getText().toString();
            c3028a.f16967j = this.f16933n.getText().toString();
            c3028a.f16966i = this.f16932m.getText().toString();
            c3028a.f16965h = this.f16931l.getText().toString();
            c3028a.f16968k = this.f16936q.getText().toString();
            c3028a.f16960c = this.f16923d.getText().toString();
            if (this.f16940u.getSelectedItemPosition() == 0) {
                c3028a.f16961d = Long.parseLong(this.f16926g.getText().toString()) * 365;
            } else {
                c3028a.f16961d = Long.parseLong(this.f16926g.getText().toString());
            }
            m18106a(c3028a);
            C3112bn.m19023b(context, context.getString(R.string.complete));
            return c3028a;
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder(e2.getMessage());
            StackTraceElement[] stackTrace = e2.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb.append('\n').append(stackTraceElement);
            }
            m18113a(sb);
            return (C3028a) null;
        }
    }

    /* renamed from: a */
    private X509Certificate m18103a(PrivateKey privateKey, PublicKey publicKey, C1496bn c1496bn, Date date, Date date2, C1515o c1515o) {
        String str = this.f16942w[this.f16939t.getSelectedItemPosition()];
        try {
            C1525y c1525y = new C1525y(date, date2);
            C1501bs c1501bs = new C1501bs();
            c1501bs.m11610a("version", new C1526z(2));
            c1501bs.m11610a("serialNumber", new C1522v(new Random().nextInt() & Integer.MAX_VALUE));
            c1501bs.m11610a("algorithmID", new C1514n(C1505e.m11631a(str)));
            c1501bs.m11610a(Telephony.TextBasedSmsColumns.SUBJECT, new C1523w(c1496bn));
            c1501bs.m11610a("key", new C1456aa(publicKey));
            c1501bs.m11610a("validity", c1525y);
            c1501bs.m11610a("issuer", new C1517q(c1496bn));
            if (c1515o != null) {
                c1501bs.m11610a(Contacts.People.Extensions.CONTENT_DIRECTORY, c1515o);
            }
            C1500br c1500br = new C1500br(c1501bs);
            c1500br.m11588a(privateKey, str);
            return c1500br;
        } catch (IOException e2) {
            throw new CertificateEncodingException(new StringBuffer().append("getSelfCert: ").append(e2.getMessage()).toString());
        }
    }

    /* renamed from: a */
    private void m18105a(PrivateKey privateKey, X509Certificate x509Certificate, C3028a c3028a) {
        KeyStore keyStore;
        File file = new File(c3028a.f16963f);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        int i = c3028a.f16970m;
        if (i < 3) {
            if (i == 0) {
                keyStore = KeyStore.getInstance("JKS");
            } else {
                keyStore = i == 1 ? KeyStore.getInstance(KeyChain.EXTRA_PKCS12) : KeyStore.getInstance("BKS");
            }
            if (file.exists()) {
                keyStore.load(new FileInputStream(file), c3028a.f16969l.toCharArray());
            } else {
                keyStore.load((KeyStore.LoadStoreParameter) null);
            }
            keyStore.setKeyEntry(c3028a.f16958a, privateKey, c3028a.f16962e.toCharArray(), new X509Certificate[]{x509Certificate});
            keyStore.store(new FileOutputStream(file), c3028a.f16969l.toCharArray());
            return;
        }
        if (i == 3) {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(privateKey.getEncoded());
            fileOutputStream.close();
            FileOutputStream fileOutputStream2 = new FileOutputStream(c3028a.f16958a);
            fileOutputStream2.write("-----BEGIN CERTIFICATE-----\n".getBytes());
            fileOutputStream2.write(Base64.encode(x509Certificate.getEncoded(), 0));
            fileOutputStream2.write("\n-----END CERTIFICATE-----\n".getBytes());
            fileOutputStream2.flush();
        }
    }

    /* renamed from: a */
    private void m18106a(C3028a c3028a) {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KeyProperties.KEY_ALGORITHM_RSA);
        keyPairGenerator.initialize(c3028a.f16964g, SecureRandom.getInstance("SHA1PRNG"));
        KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = generateKeyPair.getPublic();
        PrivateKey privateKey = generateKeyPair.getPrivate();
        C1515o c1515o = new C1515o();
        c1515o.m11668a("SubjectKeyIdentifier", new C1492bj(new C1474as(publicKey).m11512a()));
        C1496bn c1496bn = new C1496bn(c3028a.f16959b, c3028a.f16967j, c3028a.f16966i, c3028a.f16965h, c3028a.f16968k, c3028a.f16960c);
        Date date = new Date();
        long j = c3028a.f16961d * 24 * 3600000;
        Date date2 = new Date();
        date2.setTime(j + date.getTime());
        c1515o.m11668a("PrivateKeyUsage", new C1486bd(date, date2));
        m18105a(privateKey, m18103a(privateKey, publicKey, c1496bn, date, date2, c1515o), c3028a);
    }

    /* renamed from: a */
    protected final void m18113a(CharSequence charSequence) {
        new DialogInterfaceC0070b.a(getContext()).m418a(R.string.error).m436b(charSequence).m420a(R.string.f21470ok, (DialogInterface.OnClickListener) null).m429a(false).m441c();
    }
}
