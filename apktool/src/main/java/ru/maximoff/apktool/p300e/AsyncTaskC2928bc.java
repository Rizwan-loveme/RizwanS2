package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.security.keystore.KeyProperties;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import org.p217b.p218a.p219a.C1887e;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3060a;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3104bf;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3246h;
import ru.maximoff.apktool.util.C3249i;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: VerifyTask.java */
/* renamed from: ru.maximoff.apktool.e.bc */
/* loaded from: classes.dex */
public class AsyncTaskC2928bc extends AbstractAsyncTaskC2898a {

    /* renamed from: a */
    private Context f15556a;

    /* renamed from: b */
    private File f15557b;

    /* renamed from: c */
    private Runnable f15558c;

    /* renamed from: d */
    private Runnable f15559d;

    /* renamed from: e */
    private List<String> f15560e;

    /* renamed from: f */
    private boolean f15561f;

    public AsyncTaskC2928bc(Context context) {
        super(context, (InterfaceC2995n) null);
        this.f15556a = context;
        this.f15561f = false;
        this.f15558c = new AnonymousClass1(this);
        this.f15559d = new AnonymousClass2(this);
        m17053a(this.f15556a.getString(R.string.check_hash), this.f15558c, this.f15559d);
        m17070e(false);
        m17064b(true);
    }

    /* compiled from: VerifyTask.java */
    /* renamed from: ru.maximoff.apktool.e.bc$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        private final AsyncTaskC2928bc f15562a;

        AnonymousClass1(AsyncTaskC2928bc asyncTaskC2928bc) {
            this.f15562a = asyncTaskC2928bc;
        }

        /* renamed from: a */
        static AsyncTaskC2928bc m17446a(AnonymousClass1 anonymousClass1) {
            return anonymousClass1.f15562a;
        }

        @Override // java.lang.Runnable
        public void run() {
            int m18574b = C3080al.m18574b(this.f15562a.f15556a, 10);
            View inflate = LayoutInflater.from(this.f15562a.f15556a).inflate(R.layout.checksum, (ViewGroup) null);
            ((LinearLayout) inflate.findViewById(R.id.checksumLinearLayout1)).setPadding(m18574b, m18574b, m18574b, m18574b);
            TextView textView = (TextView) inflate.findViewById(R.id.checksumTextView1);
            textView.setTextSize(2, C3102bd.f18332o);
            EditText editText = (EditText) inflate.findViewById(R.id.checksumEditText1);
            ((Button) inflate.findViewById(R.id.checksumButton1)).setOnClickListener(new View.OnClickListener(this, editText) { // from class: ru.maximoff.apktool.e.bc.1.1

                /* renamed from: a */
                private final AnonymousClass1 f15563a;

                /* renamed from: b */
                private final EditText f15564b;

                {
                    this.f15563a = this;
                    this.f15564b = editText;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String m18991a = C3112bn.m18991a(AnonymousClass1.m17446a(this.f15563a).f15556a);
                    if (m18991a != null) {
                        this.f15564b.setText(m18991a);
                        this.f15564b.setSelection(this.f15564b.getText().length());
                    } else {
                        C3112bn.m18999a(AnonymousClass1.m17446a(this.f15563a).f15556a, R.string.empty);
                    }
                }
            });
            editText.addTextChangedListener(new TextWatcher(this, textView) { // from class: ru.maximoff.apktool.e.bc.1.2

                /* renamed from: a */
                private final AnonymousClass1 f15565a;

                /* renamed from: b */
                private final TextView f15566b;

                {
                    this.f15565a = this;
                    this.f15566b = textView;
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    String trim = editable.toString().toLowerCase().trim();
                    String string = AnonymousClass1.m17446a(this.f15565a).f15556a.getString(R.string.check_hash);
                    if (C3112bn.m19040o(trim)) {
                        this.f15566b.setText(string);
                    } else {
                        this.f15566b.setText(AnonymousClass1.m17446a(this.f15565a).m17439a(trim));
                    }
                }
            });
            DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f15562a.f15556a).m418a(R.string.check_hash).m435b(inflate).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m438b();
            m438b.getWindow().setSoftInputMode(4);
            m438b.setOnShowListener(new DialogInterface.OnShowListener(this, editText) { // from class: ru.maximoff.apktool.e.bc.1.3

                /* renamed from: a */
                private final AnonymousClass1 f15567a;

                /* renamed from: b */
                private final EditText f15568b;

                {
                    this.f15567a = this;
                    this.f15568b = editText;
                }

                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    this.f15568b.requestFocus();
                }
            });
            m438b.show();
        }
    }

    /* compiled from: VerifyTask.java */
    /* renamed from: ru.maximoff.apktool.e.bc$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        private final AsyncTaskC2928bc f15569a;

        AnonymousClass2(AsyncTaskC2928bc asyncTaskC2928bc) {
            this.f15569a = asyncTaskC2928bc;
        }

        /* renamed from: a */
        static AsyncTaskC2928bc m17447a(AnonymousClass2 anonymousClass2) {
            return anonymousClass2.f15569a;
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] stringArray = this.f15569a.f15556a.getResources().getStringArray(R.array.checksum_names);
            String[] stringArray2 = this.f15569a.f15556a.getResources().getStringArray(R.array.checksum_keys);
            boolean[] zArr = new boolean[stringArray2.length];
            for (int i = 0; i < stringArray2.length; i++) {
                zArr[i] = C3102bd.m18925a(this.f15569a.f15556a, stringArray2[i], false);
            }
            new DialogInterfaceC0070b.a(this.f15569a.f15556a).m418a(R.string.checksum_format).m432a(stringArray, zArr, new DialogInterface.OnMultiChoiceClickListener(this, zArr) { // from class: ru.maximoff.apktool.e.bc.2.1

                /* renamed from: a */
                private final AnonymousClass2 f15570a;

                /* renamed from: b */
                private final boolean[] f15571b;

                {
                    this.f15570a = this;
                    this.f15571b = zArr;
                }

                @Override // android.content.DialogInterface.OnMultiChoiceClickListener
                public void onClick(DialogInterface dialogInterface, int i2, boolean z) {
                    this.f15571b[i2] = z;
                }
            }).m420a(R.string.save, new DialogInterface.OnClickListener(this, stringArray2, zArr) { // from class: ru.maximoff.apktool.e.bc.2.2

                /* renamed from: a */
                private final AnonymousClass2 f15572a;

                /* renamed from: b */
                private final String[] f15573b;

                /* renamed from: c */
                private final boolean[] f15574c;

                {
                    this.f15572a = this;
                    this.f15573b = stringArray2;
                    this.f15574c = zArr;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    for (int i3 = 0; i3 < this.f15573b.length; i3++) {
                        C3102bd.m18938b(AnonymousClass2.m17447a(this.f15572a).f15556a, this.f15573b[i3], this.f15574c[i3]);
                    }
                    dialogInterface.cancel();
                    AnonymousClass2.m17447a(this.f15572a).m17068d().cancel();
                    try {
                        AsyncTaskC2928bc asyncTaskC2928bc = new AsyncTaskC2928bc(AnonymousClass2.m17447a(this.f15572a).f15556a);
                        asyncTaskC2928bc.m17445g(AnonymousClass2.m17447a(this.f15572a).f15561f);
                        asyncTaskC2928bc.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, AnonymousClass2.m17447a(this.f15572a).f15557b);
                    } catch (Exception e2) {
                        C3112bn.m18999a(AnonymousClass2.m17447a(this.f15572a).f15556a, R.string.error_try_again);
                    }
                }
            }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x01c2, code lost:
    
        r0 = r12.f15556a.getString(com.srizwan.apktool.R.string.hash);
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SpannableString m17439a(String str) {
        boolean z;
        String str2;
        int i;
        String str3;
        String string = this.f15556a.getString(R.string.check_hash);
        String lowerCase = str.replace(":", "").toLowerCase();
        String str4 = (String) null;
        Iterator<String> it = this.f15560e.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                str2 = str4;
                break;
            }
            String lowerCase2 = it.next().replace(":", "").toLowerCase();
            if (lowerCase.equals(lowerCase2)) {
                str2 = m17441a(lowerCase2.length());
                z = false;
                break;
            }
            if (lowerCase2.length() == 8 && lowerCase.equals(new StringBuffer().append("0x").append(lowerCase2).toString())) {
                str2 = m17441a(lowerCase2.length());
                z = false;
                break;
            }
            if (lowerCase2.length() == 10 && lowerCase.equals(lowerCase2.substring(2))) {
                str2 = m17441a(lowerCase2.length());
                z = false;
                break;
            }
            if (lowerCase2.length() > 10 && lowerCase.length() > 8 && lowerCase2.length() > lowerCase.length() && lowerCase2.contains(lowerCase)) {
                str2 = m17441a(lowerCase2.length());
                z = true;
                break;
            }
        }
        if (str2 == null && lowerCase.matches("^\\d+$")) {
            try {
                String hexString = Long.toHexString(Long.parseLong(lowerCase));
                Iterator<String> it2 = this.f15560e.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        str3 = str2;
                        break;
                    }
                    String lowerCase3 = it2.next().replace(":", "").toLowerCase();
                    if (lowerCase3.equals(hexString)) {
                        str3 = "CRC32";
                        break;
                    }
                    if (lowerCase3.equals(new StringBuffer().append("0x").append(hexString).toString())) {
                        break;
                    }
                }
                str2 = str3;
            } catch (Exception e2) {
            }
        }
        int m19470a = C3246h.m19470a(this.f15556a, R.color.dark_red);
        String string2 = this.f15556a.getString(R.string.not_match);
        if (str2 != null) {
            int m19470a2 = C3246h.m19470a(this.f15556a, z ? R.color.light_orange : R.color.dark_green);
            string2 = new StringBuffer().append(new StringBuffer().append(str2).append(" ").toString()).append(this.f15556a.getString(z ? R.string.part_matches : R.string.matches)).toString();
            i = m19470a2;
        } else {
            i = m19470a;
        }
        SpannableString spannableString = new SpannableString(new StringBuffer().append(new StringBuffer().append(string).append(": ").toString()).append(string2).toString());
        spannableString.setSpan(new ForegroundColorSpan(i), string.length() + 2, string.length() + string2.length() + 2, 33);
        spannableString.setSpan(new StyleSpan(1), string.length() + 2, string2.length() + string.length() + 2, 33);
        return spannableString;
    }

    /* renamed from: a */
    private String m17441a(int i) {
        switch (i) {
            case 8:
                return "CRC32";
            case 10:
                return this.f15556a.getString(R.string.hash);
            case 32:
                return KeyProperties.DIGEST_MD5;
            case 40:
                return KeyProperties.DIGEST_SHA1;
            case 56:
                return KeyProperties.DIGEST_SHA224;
            case 64:
                return KeyProperties.DIGEST_SHA256;
            case 96:
                return KeyProperties.DIGEST_SHA384;
            case 128:
                return KeyProperties.DIGEST_SHA512;
            default:
                return (String) null;
        }
    }

    /* renamed from: g */
    public void m17445g(boolean z) {
        this.f15561f = z;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: c */
    protected int mo17065c() {
        return R.string.verify_run_title;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: a */
    protected boolean mo17058a(File file) {
        File file2;
        boolean z;
        this.f15557b = file;
        if (this.f15561f) {
            File m17444d = m17444d(file);
            m17060b(m17444d);
            file2 = m17444d;
        } else {
            file2 = file;
        }
        if (file2 == null) {
            m17060b((File) null);
            mo3979a(R.string.errorf, "apk file is null");
            return false;
        }
        C3060a c3060a = new C3060a(this.f15556a, file2);
        String name = file2.getName();
        if (c3060a.m18288z() != null) {
            name = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(c3060a.m18271i()).append(" v").toString()).append(c3060a.m18277o()).toString()).append(" (").toString()).append(c3060a.m18278p()).toString()).append(")").toString();
        }
        m17069e(R.string.text, new StringBuffer().append(new StringBuffer().append(this.f15556a.getString(R.string.verify_run_title)).append(": ").toString()).append(name).toString());
        m17069e(R.string.text, new StringBuffer().append(new StringBuffer().append(this.f15556a.getString(R.string.path_app)).append(": ").toString()).append(file.getAbsolutePath()).toString());
        C3104bf c3104bf = new C3104bf(this.f15556a);
        try {
            z = c3104bf.m18961a(file2, this);
        } catch (Error | Exception e2) {
            mo3979a(R.string.text, e2.getMessage());
            z = false;
        }
        this.f15560e = c3104bf.m18960a();
        if (!z || c3060a.m18288z() == null) {
            m17060b((File) null);
        }
        if (this.f15561f) {
            file2.delete();
        }
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d */
    private File m17444d(File file) {
        C2604w c2604w;
        C2604w c2604w2;
        File file2 = (File) null;
        C2604w c2604w3 = (C2604w) null;
        try {
            try {
                try {
                    c2604w = new C2604w(file);
                } catch (Exception e2) {
                    c2604w = c2604w3;
                }
            } catch (Exception e3) {
                c2604w = c2604w3;
            }
        } catch (Error e4) {
            c2604w = c2604w3;
        } catch (Throwable th) {
            th = th;
            c2604w = c2604w3;
        }
        try {
            try {
                Enumeration<C2602u> m16163b = c2604w.m16163b();
                try {
                    try {
                        byte[] bArr = new byte[C3249i.m19500a()];
                        while (true) {
                            try {
                                if (!m16163b.hasMoreElements()) {
                                    break;
                                }
                                try {
                                    try {
                                        C2602u nextElement = m16163b.nextElement();
                                        try {
                                            try {
                                                String lowerCase = nextElement.getName().toLowerCase();
                                                try {
                                                    if (!nextElement.isDirectory()) {
                                                        try {
                                                            if (lowerCase.endsWith(".apk")) {
                                                                try {
                                                                    try {
                                                                        if (lowerCase.contains(File.separator)) {
                                                                            continue;
                                                                        } else {
                                                                            try {
                                                                                try {
                                                                                    File createTempFile = File.createTempFile("AM_TempApkVS_", ".tmp", C3102bd.m18908a());
                                                                                    try {
                                                                                        try {
                                                                                            try {
                                                                                                try {
                                                                                                    BufferedInputStream bufferedInputStream = new BufferedInputStream(c2604w.m16160a(nextElement), C3249i.m19500a());
                                                                                                    try {
                                                                                                        try {
                                                                                                            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                                                                                                            while (true) {
                                                                                                                try {
                                                                                                                    int read = bufferedInputStream.read(bArr);
                                                                                                                    if (read == -1) {
                                                                                                                        try {
                                                                                                                            break;
                                                                                                                        } catch (Exception e5) {
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        fileOutputStream.write(bArr, 0, read);
                                                                                                                    }
                                                                                                                } catch (Throwable th2) {
                                                                                                                    try {
                                                                                                                        bufferedInputStream.close();
                                                                                                                        try {
                                                                                                                            fileOutputStream.close();
                                                                                                                            try {
                                                                                                                                throw th2;
                                                                                                                            } catch (Exception e6) {
                                                                                                                                c2604w2 = c2604w;
                                                                                                                                try {
                                                                                                                                    file2 = (File) null;
                                                                                                                                    C1887e.m13969a(c2604w2);
                                                                                                                                    return file2;
                                                                                                                                } catch (Throwable th3) {
                                                                                                                                    th = th3;
                                                                                                                                    c2604w = c2604w2;
                                                                                                                                    C1887e.m13969a(c2604w);
                                                                                                                                    throw th;
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } catch (Exception e7) {
                                                                                                                        }
                                                                                                                    } catch (Exception e8) {
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                            bufferedInputStream.close();
                                                                                                            try {
                                                                                                                fileOutputStream.close();
                                                                                                                try {
                                                                                                                    try {
                                                                                                                        try {
                                                                                                                            try {
                                                                                                                                C3060a c3060a = new C3060a(this.f15556a, createTempFile.getAbsolutePath());
                                                                                                                                try {
                                                                                                                                    if (c3060a.m18255D()) {
                                                                                                                                        try {
                                                                                                                                            if (c3060a.m18266d() != null) {
                                                                                                                                                file2 = createTempFile;
                                                                                                                                                break;
                                                                                                                                            }
                                                                                                                                        } catch (Exception e9) {
                                                                                                                                            c2604w2 = c2604w;
                                                                                                                                            file2 = (File) null;
                                                                                                                                            C1887e.m13969a(c2604w2);
                                                                                                                                            return file2;
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                    try {
                                                                                                                                        createTempFile.delete();
                                                                                                                                    } catch (Exception e10) {
                                                                                                                                        c2604w2 = c2604w;
                                                                                                                                        file2 = (File) null;
                                                                                                                                        C1887e.m13969a(c2604w2);
                                                                                                                                        return file2;
                                                                                                                                    }
                                                                                                                                } catch (Exception e11) {
                                                                                                                                }
                                                                                                                            } catch (Exception e12) {
                                                                                                                            }
                                                                                                                        } catch (Exception e13) {
                                                                                                                        }
                                                                                                                    } catch (Exception e14) {
                                                                                                                    }
                                                                                                                } catch (Exception e15) {
                                                                                                                }
                                                                                                            } catch (Exception e16) {
                                                                                                            }
                                                                                                        } catch (Exception e17) {
                                                                                                        }
                                                                                                    } catch (Exception e18) {
                                                                                                    }
                                                                                                } catch (Exception e19) {
                                                                                                }
                                                                                            } catch (Exception e20) {
                                                                                            }
                                                                                        } catch (Exception e21) {
                                                                                        }
                                                                                    } catch (Exception e22) {
                                                                                    }
                                                                                } catch (Exception e23) {
                                                                                }
                                                                            } catch (Exception e24) {
                                                                            }
                                                                        }
                                                                    } catch (Exception e25) {
                                                                    }
                                                                } catch (Exception e26) {
                                                                }
                                                            } else {
                                                                continue;
                                                            }
                                                        } catch (Exception e27) {
                                                        }
                                                    }
                                                } catch (Exception e28) {
                                                }
                                            } catch (Exception e29) {
                                            }
                                        } catch (Exception e30) {
                                        }
                                    } catch (Exception e31) {
                                    }
                                } catch (Exception e32) {
                                }
                            } catch (Exception e33) {
                            }
                        }
                        c2604w2 = c2604w;
                    } catch (Exception e34) {
                    }
                } catch (Exception e35) {
                }
            } catch (Exception e36) {
            }
        } catch (Error e37) {
        } catch (Throwable th4) {
            th = th4;
            C1887e.m13969a(c2604w);
            throw th;
        }
        C1887e.m13969a(c2604w2);
        return file2;
    }

    @Override // ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a
    /* renamed from: b */
    protected void mo17061b(Boolean bool) {
        super.mo17061b(bool);
    }
}
