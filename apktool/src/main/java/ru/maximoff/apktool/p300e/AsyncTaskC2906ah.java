package ru.maximoff.apktool.p300e;

import android.C0012R;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3060a;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3246h;
import ru.maximoff.apktool.util.C3262u;

/* compiled from: PreRenameTask.java */
/* renamed from: ru.maximoff.apktool.e.ah */
/* loaded from: classes.dex */
public class AsyncTaskC2906ah extends AsyncTask<File, Integer, Boolean> {

    /* renamed from: a */
    private Context f15094a;

    /* renamed from: b */
    private InterfaceC2995n f15095b;

    /* renamed from: c */
    private String f15096c;

    /* renamed from: d */
    private String f15097d;

    /* renamed from: e */
    private String f15098e;

    /* renamed from: f */
    private boolean f15099f;

    /* renamed from: g */
    private boolean f15100g;

    /* renamed from: h */
    private DialogInterfaceC0070b f15101h;

    /* renamed from: i */
    private ProgressDialog f15102i;

    /* renamed from: j */
    private File f15103j;

    /* renamed from: k */
    private HashMap<String, String> f15104k = new HashMap<>();

    @Override // android.os.AsyncTask
    protected Boolean doInBackground(File[] fileArr) {
        return m17140a(fileArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m17141a(bool);
    }

    public AsyncTaskC2906ah(Context context, InterfaceC2995n interfaceC2995n, String str, String str2, String str3, boolean z, boolean z2, DialogInterfaceC0070b dialogInterfaceC0070b) {
        this.f15094a = context;
        this.f15095b = interfaceC2995n;
        this.f15096c = str;
        this.f15097d = str2;
        this.f15098e = str3;
        this.f15099f = z;
        this.f15100g = z2;
        this.f15101h = dialogInterfaceC0070b;
        this.f15102i = new ProgressDialog(context);
        this.f15102i.setCancelable(false);
        this.f15102i.setMessage(context.getString(R.string.mplease_wait));
        this.f15102i.show();
    }

    /* renamed from: a */
    protected Boolean m17140a(File[] fileArr) {
        String m19032g;
        String m19032g2;
        String replace;
        for (int i = 0; i < fileArr.length; i++) {
            try {
                File file = fileArr[i];
                if (file.exists()) {
                    String name = file.getName();
                    String[] m19641b = C3262u.m19641b(name);
                    String str = m19641b[0];
                    String str2 = m19641b[1];
                    String stringBuffer = (!str2.isEmpty() || name.endsWith(".")) ? new StringBuffer().append(new StringBuffer().append(str).append(".").toString()).append(str2).toString() : str;
                    this.f15103j = file.getParentFile();
                    if (this.f15100g && str2.equalsIgnoreCase("apk")) {
                        C3060a c3060a = new C3060a(this.f15094a, file);
                        if (c3060a.m18255D()) {
                            str = C3112bn.m18992a(this.f15094a, c3060a, C3102bd.m18910a(this.f15094a, "apk_name_tpl", "{LABEL}_v{VERSION}({CODE})"));
                            name = new StringBuffer().append(new StringBuffer().append(str).append(".").toString()).append(str2).toString();
                        }
                    }
                    if (this.f15096c != null) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        Matcher matcher = Pattern.compile("\\{(NAME|DATE|TIME)([^\\}]+)\\}").matcher(this.f15096c);
                        while (matcher.find()) {
                            if (matcher.group(1).equals("NAME")) {
                                try {
                                    replace = str.replaceAll("\\s", matcher.group(2));
                                } catch (Exception e2) {
                                    replace = str.replace(" ", matcher.group(2));
                                }
                                matcher.appendReplacement(stringBuffer2, replace);
                            } else if (matcher.group(1).equals("DATE")) {
                                try {
                                    m19032g2 = C3112bn.m19032g("yyyy-MM-dd").replace("-", matcher.group(2));
                                } catch (Exception e3) {
                                    m19032g2 = C3112bn.m19032g("yyyy-MM-dd");
                                }
                                matcher.appendReplacement(stringBuffer2, m19032g2);
                            } else if (matcher.group(1).equals("TIME")) {
                                try {
                                    m19032g = C3112bn.m19032g("HH-mm-ss").replace("-", matcher.group(2));
                                } catch (Exception e4) {
                                    m19032g = C3112bn.m19032g("HH-mm-ss");
                                }
                                matcher.appendReplacement(stringBuffer2, m19032g);
                            }
                        }
                        matcher.appendTail(stringBuffer2);
                        name = C3112bn.m18995a(stringBuffer2.toString(), i).replace("{NAME}", str).replace("{EXT}", str2).replace("{DATE}", C3112bn.m19032g("yyyyMMdd")).replace("{TIME}", C3112bn.m19032g("HHmmss")).replace("\\{", "{").replace("\\}", "}");
                    }
                    if (this.f15097d != null) {
                        if (this.f15099f) {
                            try {
                                StringBuffer stringBuffer3 = new StringBuffer();
                                Matcher matcher2 = Pattern.compile(this.f15097d).matcher(name);
                                while (matcher2.find()) {
                                    matcher2.appendReplacement(stringBuffer3, this.f15098e);
                                }
                                matcher2.appendTail(stringBuffer3);
                                name = stringBuffer3.toString();
                            } catch (Exception e5) {
                                name = name.replace(this.f15097d, this.f15098e);
                            }
                        } else {
                            name = name.replace(this.f15097d, this.f15098e);
                        }
                    }
                    if (name.equals(stringBuffer)) {
                        this.f15104k.put(file.getAbsolutePath(), file.getAbsolutePath());
                    } else if (name.equalsIgnoreCase(stringBuffer)) {
                        this.f15104k.put(file.getAbsolutePath(), new StringBuffer().append(new StringBuffer().append(this.f15103j.getAbsolutePath()).append(File.separator).toString()).append(name).toString());
                    } else {
                        String[] m19641b2 = C3262u.m19641b(name);
                        String str3 = m19641b2[1];
                        if (!str3.isEmpty() || name.endsWith(".")) {
                            str3 = new StringBuffer().append(".").append(str3).toString();
                        }
                        this.f15104k.put(file.getAbsolutePath(), new StringBuffer().append(new StringBuffer().append(this.f15103j.getAbsolutePath()).append(File.separator).toString()).append(C3262u.m19567a(this.f15094a, this.f15103j.getAbsolutePath(), C3112bn.m19033h(m19641b2[0]), str3, 0, this.f15104k)).toString());
                    }
                }
            } catch (Exception e6) {
                return new Boolean(false);
            }
        }
        return new Boolean(true);
    }

    /* renamed from: a */
    protected void m17141a(Boolean bool) {
        if (this.f15102i != null && this.f15102i.isShowing()) {
            try {
                this.f15102i.cancel();
            } catch (Exception e2) {
            }
        }
        String string = this.f15094a.getString(R.string.rarrow);
        int m19470a = C3246h.m19470a(this.f15094a, R.color.dark_red);
        int m19470a2 = C3246h.m19470a(this.f15094a, R.color.dark_green);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int[] iArr = {0, 0};
        for (Map.Entry<String, String> entry : this.f15104k.entrySet()) {
            if (iArr[0] > 0) {
                spannableStringBuilder.append((CharSequence) "\n\n");
            }
            String name = new File(entry.getKey()).getName();
            String name2 = new File(entry.getValue()).getName();
            SpannableString spannableString = new SpannableString(name);
            SpannableString spannableString2 = new SpannableString(name2);
            if (!name.equals(name2)) {
                iArr[1] = iArr[1] + 1;
                spannableString.setSpan(new ForegroundColorSpan(m19470a), 0, name.length(), 33);
                spannableString2.setSpan(new ForegroundColorSpan(m19470a2), 0, name2.length(), 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString).append((CharSequence) new StringBuffer().append(new StringBuffer().append(" ").append(string).toString()).append(" ").toString()).append((CharSequence) spannableString2);
            iArr[0] = iArr[0] + 1;
        }
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f15094a).m418a(R.string.preview).m436b(spannableStringBuilder).m420a(R.string.rename, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.e.ah.1

            /* renamed from: a */
            private final AsyncTaskC2906ah f15105a;

            {
                this.f15105a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    new AsyncTaskC2910al(this.f15105a.f15094a, this.f15105a.f15095b, this.f15105a.f15104k).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new File[0]);
                } catch (Exception e3) {
                    C3112bn.m18999a(this.f15105a.f15094a, R.string.error_try_again);
                }
                this.f15105a.f15101h.cancel();
                dialogInterface.dismiss();
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, m438b, iArr) { // from class: ru.maximoff.apktool.e.ah.2

            /* renamed from: a */
            private final AsyncTaskC2906ah f15106a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f15107b;

            /* renamed from: c */
            private final int[] f15108c;

            {
                this.f15106a = this;
                this.f15107b = m438b;
                this.f15108c = iArr;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f15107b.m414a(-1).setEnabled(this.f15108c[1] > 0);
                TextView textView = (TextView) this.f15107b.findViewById(C0012R.id.message);
                if (textView != null) {
                    textView.setTextSize(2, C3102bd.f18332o - 2);
                }
            }
        });
        m438b.show();
    }
}
