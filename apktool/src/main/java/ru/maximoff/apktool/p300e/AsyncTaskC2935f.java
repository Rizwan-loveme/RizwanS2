package ru.maximoff.apktool.p300e;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.p008os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.p065b.p066a.p067a.AbstractC0581c;
import com.srizwan.apktool.R;
import java.p209io.ByteArrayInputStream;
import java.p209io.File;
import java.p209io.FileFilter;
import java.p209io.FileInputStream;
import java.p209io.FileOutputStream;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.p217b.p218a.p219a.C1887e;
import ru.maximoff.apktool.fragment.p301a.C2978b;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.util.C3067ab;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3094az;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.p303a.C3061a;
import ru.maximoff.apktool.util.p308f.C3239s;

/* compiled from: Cloner.java */
/* renamed from: ru.maximoff.apktool.e.f */
/* loaded from: classes.dex */
public class AsyncTaskC2935f extends AsyncTask<File, String, Boolean> {

    /* renamed from: a */
    private Context f15615a;

    /* renamed from: b */
    private DialogInterfaceC0070b f15616b;

    /* renamed from: c */
    private InterfaceC2995n f15617c;

    /* renamed from: e */
    private String f15619e;

    /* renamed from: f */
    private String f15620f;

    /* renamed from: g */
    private String f15621g;

    /* renamed from: h */
    private String f15622h;

    /* renamed from: i */
    private String f15623i;

    /* renamed from: d */
    private ExecutorService f15618d = Executors.newFixedThreadPool(C3102bd.f18297ae);

    /* renamed from: j */
    private long f15624j = 0;

    /* renamed from: k */
    private String f15625k = "???";

    /* renamed from: l */
    private String f15626l = "...";

    @Override // android.p008os.AsyncTask
    protected Boolean doInBackground(File[] fileArr) {
        return m17482a(fileArr);
    }

    @Override // android.p008os.AsyncTask
    protected void onPostExecute(Boolean bool) {
        m17483a(bool);
    }

    public AsyncTaskC2935f(Context context, InterfaceC2995n interfaceC2995n, String str, String str2, String str3, String str4, String str5) {
        this.f15615a = context;
        this.f15617c = interfaceC2995n;
        this.f15619e = str;
        this.f15620f = str2;
        this.f15621g = str3;
        this.f15622h = str4;
        this.f15623i = str5;
    }

    @Override // android.p008os.AsyncTask
    protected void onPreExecute() {
        View inflate = LayoutInflater.from(this.f15615a).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        this.f15616b = new DialogInterfaceC0070b.a(this.f15615a).m435b(inflate).m429a(false).m438b();
        this.f15616b.show();
        this.f15624j = System.currentTimeMillis();
    }

    /* renamed from: a */
    protected Boolean m17482a(File[] fileArr) {
        try {
            m17472a(fileArr[0]);
            m17479f(fileArr[0]);
            if (this.f15620f == null) {
                return new Boolean(true);
            }
            File[] listFiles = fileArr[0].listFiles();
            if (listFiles != null) {
                ArrayList<File> arrayList = new ArrayList();
                for (File file : listFiles) {
                    if (file.isFile() && file.getName().equals(AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME)) {
                        this.f15618d.submit(new a(this, file, true));
                    } else if (file.isDirectory()) {
                        if (file.getName().equals("res")) {
                            m17477d(file);
                        } else if (file.getName().startsWith("smali")) {
                            arrayList.add(file);
                            m17476c(file);
                        } else if (file.getName().equals("lib")) {
                            m17478e(file);
                        }
                    }
                }
                this.f15618d.shutdown();
                do {
                } while (!this.f15618d.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS));
                if (this.f15620f != null && !arrayList.isEmpty()) {
                    for (File file2 : arrayList) {
                        File file3 = new File(file2, this.f15619e.replace(".", "/"));
                        File file4 = new File(file2, this.f15620f.replace(".", "/"));
                        if (file3.isDirectory() && !file4.exists()) {
                            file4.mkdirs();
                            file3.renameTo(file4);
                        }
                    }
                }
            }
            return new Boolean(true);
        } catch (Error e2) {
            e = e2;
            this.f15625k = e.getMessage();
            return new Boolean(false);
        } catch (Exception e3) {
            e = e3;
            this.f15625k = e.getMessage();
            return new Boolean(false);
        }
    }

    /* renamed from: a */
    protected void m17483a(Boolean bool) {
        int i;
        String string;
        if (this.f15616b != null && this.f15616b.isShowing()) {
            try {
                this.f15616b.cancel();
            } catch (Exception e2) {
            }
        }
        if (this.f15617c != null) {
            this.f15617c.mo17929a();
        }
        if (bool.booleanValue() && (this.f15620f != null || this.f15622h != null || this.f15623i != null)) {
            if (this.f15620f == null && this.f15622h == null) {
                string = this.f15615a.getString(R.string.cloning_result, this.f15626l, this.f15623i, C3080al.m18533a(System.currentTimeMillis() - this.f15624j));
            } else if (this.f15620f == null) {
                string = this.f15615a.getString(R.string.cloning_result, this.f15621g, this.f15622h, C3080al.m18533a(System.currentTimeMillis() - this.f15624j));
            } else {
                String str = this.f15619e;
                String str2 = this.f15620f;
                if (this.f15622h != null) {
                    str = new StringBuffer().append(str).append(new StringBuffer().append(new StringBuffer().append(" (").append(this.f15621g).toString()).append(")").toString()).toString();
                    str2 = new StringBuffer().append(str2).append(new StringBuffer().append(new StringBuffer().append(" (").append(this.f15622h).toString()).append(")").toString()).toString();
                }
                string = this.f15615a.getString(R.string.cloning_result, str, str2, C3080al.m18533a(System.currentTimeMillis() - this.f15624j));
            }
            i = R.string.success;
        } else {
            i = R.string.error;
            if (this.f15620f == null && this.f15622h == null) {
                this.f15625k = this.f15615a.getString(R.string.data_unchanged);
            }
            string = this.f15615a.getString(R.string.errorf, this.f15625k);
        }
        new DialogInterfaceC0070b.a(this.f15615a).m418a(i).m436b(string).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m438b().show();
        C2978b.f16135a.m17721k();
    }

    /* renamed from: a */
    private void m17472a(File file) {
        String m17474b;
        File[] listFiles;
        if (this.f15622h != null && (m17474b = m17474b(file)) != null) {
            if (m17474b.matches("^@string/.+$")) {
                File file2 = new File(file, "res");
                String[] split = m17474b.substring(1).split("/");
                if (split.length == 2 && file2.isDirectory() && (listFiles = file2.listFiles(new FileFilter(this) { // from class: ru.maximoff.apktool.e.f.1

                    /* renamed from: a */
                    private final AsyncTaskC2935f f15627a;

                    {
                        this.f15627a = this;
                    }

                    @Override // java.p209io.FileFilter
                    public boolean accept(File file3) {
                        return file3.isDirectory() && file3.getName().startsWith("values");
                    }
                })) != null) {
                    for (File file3 : listFiles) {
                        File file4 = new File(file3, new StringBuffer().append(split[0]).append("s.xml").toString());
                        if (file4.isFile()) {
                            C3061a.m18319b(file4, C3061a.m18316b(C3061a.m18332i(file4), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("<").append(split[0]).toString()).append(" name=\"").toString()).append(split[1]).toString()).append("\">[^<]+</").toString()).append(split[0]).toString()).append(">").toString(), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("<").append(split[0]).toString()).append(" name=\"").toString()).append(split[1]).toString()).append("\">").toString()).append(Matcher.quoteReplacement(C3239s.m19434f(this.f15622h))).toString()).append("</").toString()).append(split[0]).toString()).append(">").toString()));
                        }
                    }
                    return;
                }
                return;
            }
            File file5 = new File(file, AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME);
            if (file5.isFile()) {
                C3061a.m18319b(file5, C3061a.m18316b(C3061a.m18332i(file5), "<application([^>]+)android:label=\"[^\"]+\"", new StringBuffer().append(new StringBuffer().append("<application$1android:label=\"").append(Matcher.quoteReplacement(C3239s.m19434f(this.f15622h))).toString()).append("\"").toString()));
            }
        }
    }

    /* renamed from: b */
    private String m17474b(File file) {
        File file2 = new File(file, AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME);
        if (!file2.exists() || !file2.isFile() || !file2.getParentFile().canWrite()) {
            return (String) null;
        }
        Matcher matcher = Pattern.compile("<application[^>]+\\sandroid:label=\"([^\"]+)\"").matcher(C3061a.m18332i(file2));
        if (matcher.find()) {
            return matcher.group(1);
        }
        return (String) null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m17467a(File file, String str) {
        File file2 = new File(file, "res");
        String[] split = str.substring(1).split("/");
        if (split.length != 2 || !file2.isDirectory()) {
            return (String) null;
        }
        File[] listFiles = file2.listFiles(new FileFilter(this) { // from class: ru.maximoff.apktool.e.f.2

            /* renamed from: a */
            private final AsyncTaskC2935f f15628a;

            {
                this.f15628a = this;
            }

            @Override // java.p209io.FileFilter
            public boolean accept(File file3) {
                return file3.isDirectory() && file3.getName().startsWith("values");
            }
        });
        if (listFiles != null) {
            Pattern compile = Pattern.compile(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("<").append(split[0]).toString()).append(" name=\"").toString()).append(split[1]).toString()).append("\">([^<]+)</").toString()).append(split[0]).toString()).append(">").toString());
            for (File file3 : listFiles) {
                File file4 = new File(file3, new StringBuffer().append(split[0]).append("s.xml").toString());
                if (file4.isFile()) {
                    Matcher matcher = compile.matcher(C3061a.m18332i(file4));
                    if (matcher.find()) {
                        return matcher.group(1);
                    }
                }
            }
        }
        return (String) null;
    }

    /* renamed from: c */
    private void m17476c(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    m17476c(file2);
                } else if (file2.isFile() && file2.getName().endsWith(".smali")) {
                    this.f15618d.submit(new a(this, file2));
                }
            }
        }
    }

    /* renamed from: d */
    private void m17477d(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    m17477d(file2);
                } else if (file2.isFile() && file2.getName().endsWith(".xml")) {
                    this.f15618d.submit(new a(this, file2));
                }
            }
        }
    }

    /* renamed from: e */
    private void m17478e(File file) {
        File[] listFiles;
        if (this.f15619e.length() == this.f15620f.length() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    m17478e(file2);
                } else if (file2.isFile() && file2.getName().endsWith(".so")) {
                    this.f15618d.submit(new a(this, file2));
                }
            }
        }
    }

    /* renamed from: f */
    private void m17479f(File file) {
        if (this.f15623i != null) {
            try {
                Bitmap m18367a = C3067ab.m18367a(C3067ab.m18377a(this.f15623i, 192));
                String m17480g = m17480g(file);
                String m17481h = m17481h(file);
                ArrayList arrayList = new ArrayList();
                if (m17480g != null) {
                    arrayList.add(String.format("\"%s\"", m17480g));
                    String[] split = m17480g.split("/");
                    m17473a(file, split[0], split[1], m18367a, false);
                }
                if (m17481h != null && !m17481h.equals(m17480g)) {
                    arrayList.add(String.format("\"%s\"", m17481h));
                    String[] split2 = m17481h.split("/");
                    m17473a(file, split2[0], split2[1], m18367a, true);
                }
                if (!arrayList.isEmpty()) {
                    this.f15626l = C3080al.m18538a(arrayList, ", ");
                }
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: g */
    private String m17480g(File file) {
        if (file == null) {
            return (String) null;
        }
        File file2 = new File(file, AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME);
        if (!file2.exists() || !file2.isFile() || !file2.getParentFile().canWrite()) {
            return (String) null;
        }
        Matcher matcher = Pattern.compile("<application[^>]+\\sandroid:icon=\"@((drawable|mipmap)/[^\"]+)\"").matcher(C3061a.m18332i(file2));
        if (matcher.find()) {
            return matcher.group(1);
        }
        return (String) null;
    }

    /* renamed from: h */
    private String m17481h(File file) {
        if (file == null) {
            return (String) null;
        }
        File file2 = new File(file, AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME);
        if (!file2.exists() || !file2.isFile() || !file2.getParentFile().canWrite()) {
            return (String) null;
        }
        Matcher matcher = Pattern.compile("<application[^>]+\\sandroid:roundIcon=\"@((drawable|mipmap)/[^\"]+)\"").matcher(C3061a.m18332i(file2));
        if (matcher.find()) {
            return matcher.group(1);
        }
        return (String) null;
    }

    /* renamed from: a */
    private void m17473a(File file, String str, String str2, Bitmap bitmap, boolean z) {
        File[] listFiles;
        File file2;
        if (file == null || str2 == null || str == null || bitmap == null) {
            return;
        }
        File file3 = new File(file, "res");
        if (!file3.isDirectory() || (listFiles = file3.listFiles(new FileFilter(this, str) { // from class: ru.maximoff.apktool.e.f.3

            /* renamed from: a */
            private final AsyncTaskC2935f f15629a;

            /* renamed from: b */
            private final String f15630b;

            {
                this.f15629a = this;
                this.f15630b = str;
            }

            @Override // java.p209io.FileFilter
            public boolean accept(File file4) {
                return file4.isDirectory() && file4.getName().startsWith(this.f15630b);
            }
        })) == null || listFiles.length <= 0) {
            return;
        }
        for (File file4 : listFiles) {
            File[] listFiles2 = file4.listFiles(new FileFilter(this, str2) { // from class: ru.maximoff.apktool.e.f.4

                /* renamed from: a */
                private final AsyncTaskC2935f f15631a;

                /* renamed from: b */
                private final String f15632b;

                {
                    this.f15631a = this;
                    this.f15632b = str2;
                }

                @Override // java.p209io.FileFilter
                public boolean accept(File file5) {
                    return file5.isFile() && (file5.getName().equals(new StringBuffer().append(this.f15632b).append(".png").toString()) || file5.getName().equals(new StringBuffer().append(this.f15632b).append(".webp").toString()) || file5.getName().equals(new StringBuffer().append(this.f15632b).append(".xml").toString()));
                }
            });
            if (listFiles2 != null) {
                for (File file5 : listFiles2) {
                    if (file5.getName().endsWith(".xml")) {
                        try {
                            Bitmap m18368a = C3067ab.m18368a(bitmap, 192);
                            if (z) {
                                m18368a = C3067ab.m18399f(m18368a);
                            }
                            if (file4.getName().startsWith(new StringBuffer().append(str).append("-anydpi").toString())) {
                                File file6 = new File(file3, new StringBuffer().append(str).append("-nodpi").toString());
                                if (!file6.exists()) {
                                    file6.mkdirs();
                                }
                                file2 = new File(file6, new StringBuffer().append(str2).append(".png").toString());
                                if (file2.exists()) {
                                    file5.delete();
                                }
                            } else {
                                file2 = new File(file5.getParentFile(), new StringBuffer().append(str2).append(".png").toString());
                            }
                            C3067ab.m18383a(m18368a, file2);
                            file5.delete();
                        } catch (Exception e2) {
                        }
                    } else {
                        String str3 = file5.getName().endsWith(".webp") ? "webp" : "png";
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeFile(file5.getAbsolutePath(), options);
                        Bitmap m18369a = C3067ab.m18369a(bitmap, options.outWidth, options.outHeight);
                        if (z) {
                            m18369a = C3067ab.m18399f(m18369a);
                        }
                        file5.delete();
                        C3067ab.m18384a(m18369a, file5, str3);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m17468a(String str) {
        if (str.startsWith(this.f15619e)) {
            return new StringBuffer().append(this.f15620f).append(str.substring(this.f15619e.length())).toString();
        }
        int indexOf = str.indexOf(".");
        if (indexOf < 0) {
            return new StringBuffer().append(new StringBuffer().append(this.f15620f).append(".").toString()).append(str).toString();
        }
        if (indexOf == 0) {
            return new StringBuffer().append(this.f15620f).append(str).toString();
        }
        return new StringBuffer().append(new StringBuffer().append(this.f15620f).append("_").toString()).append(str).toString();
    }

    /* compiled from: Cloner.java */
    /* renamed from: ru.maximoff.apktool.e.f$a */
    private class a implements Runnable {

        /* renamed from: a */
        private File f15633a;

        /* renamed from: b */
        private boolean f15634b;

        /* renamed from: c */
        private final AsyncTaskC2935f f15635c;

        public a(AsyncTaskC2935f asyncTaskC2935f, File file) {
            this(asyncTaskC2935f, file, false);
        }

        public a(AsyncTaskC2935f asyncTaskC2935f, File file, boolean z) {
            this.f15635c = asyncTaskC2935f;
            this.f15633a = file;
            this.f15634b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            String stringBuffer;
            String m17468a;
            String m18332i = C3061a.m18332i(this.f15633a);
            if (this.f15633a.getName().endsWith(".xml")) {
                if (this.f15634b) {
                    String m18298a = C3061a.m18298a(m18332i);
                    Matcher matcher = Pattern.compile(new StringBuffer().append(new StringBuffer().append("(\\s+)").append(m18298a).toString()).append(":authorities=\"([^\"]+)\"").toString()).matcher(m18332i);
                    StringBuffer stringBuffer2 = new StringBuffer();
                    while (matcher.find()) {
                        String group = matcher.group(2);
                        if (group.startsWith("@string/")) {
                            group = this.f15635c.m17467a(this.f15633a.getParentFile(), group);
                        }
                        if (group != null) {
                            if (group.indexOf(";") != -1) {
                                String[] split = group.split(";");
                                StringBuilder sb = new StringBuilder();
                                for (int i = 0; i < split.length; i++) {
                                    if (i > 0) {
                                        sb.append(";");
                                    }
                                    sb.append(this.f15635c.m17468a(split[i]));
                                }
                                m17468a = sb.toString();
                            } else {
                                m17468a = this.f15635c.m17468a(group);
                            }
                            matcher.appendReplacement(stringBuffer2, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("$1").append(m18298a).toString()).append(":authorities=\"").toString()).append(m17468a).toString()).append("\"").toString());
                        }
                    }
                    matcher.appendTail(stringBuffer2);
                    Matcher matcher2 = Pattern.compile(new StringBuffer().append(new StringBuffer().append("(\\s+)").append(m18298a).toString()).append(":process=\"([^\"]+)\"").toString()).matcher(stringBuffer2.toString());
                    StringBuffer stringBuffer3 = new StringBuffer();
                    while (matcher2.find()) {
                        String group2 = matcher2.group(2);
                        if (group2.startsWith("@string/")) {
                            group2 = this.f15635c.m17467a(this.f15633a.getParentFile(), group2);
                        }
                        if (group2 != null && group2.startsWith(this.f15635c.f15619e)) {
                            matcher2.appendReplacement(stringBuffer3, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("$1").append(m18298a).toString()).append(":process=\"").toString()).append(this.f15635c.f15620f).toString()).append(group2.substring(this.f15635c.f15619e.length())).toString()).append("\"").toString());
                        }
                    }
                    matcher2.appendTail(stringBuffer3);
                    Matcher matcher3 = Pattern.compile(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("<(uses-)?permission(\\s[^>]*)").append(m18298a).toString()).append(":name=\"(?!(").toString()).append(C3080al.m18540a(C3249i.f19545e, "|").replace(".", "\\.")).toString()).append("))([^\"]+)\"").toString()).matcher(stringBuffer3.toString());
                    StringBuffer stringBuffer4 = new StringBuffer();
                    while (matcher3.find()) {
                        String group3 = matcher3.group(4);
                        if (group3.startsWith(this.f15635c.f15619e)) {
                            stringBuffer = new StringBuffer().append(this.f15635c.f15620f).append(group3.substring(this.f15635c.f15619e.length())).toString();
                        } else {
                            stringBuffer = new StringBuffer().append(new StringBuffer().append(this.f15635c.f15620f).append("_").toString()).append(group3).toString();
                        }
                        matcher3.appendReplacement(stringBuffer4, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("<").append(C3112bn.m19017b((CharSequence) matcher3.group(1))).toString()).append("permission$2").toString()).append(m18298a).toString()).append(":name=\"").toString()).append(stringBuffer).toString()).append("\"").toString());
                    }
                    matcher3.appendTail(stringBuffer4);
                    m18332i = stringBuffer4.toString();
                }
                C3061a.m18319b(this.f15633a, C3061a.m18300a(m18332i, this.f15635c.f15619e, this.f15635c.f15620f));
                return;
            }
            if (this.f15633a.getName().endsWith(".smali")) {
                C3061a.m18319b(this.f15633a, C3061a.m18300a(C3061a.m18300a(m18332i, new StringBuffer().append(new StringBuffer().append("L").append(this.f15635c.f15619e.replace(".", "/")).toString()).append("/").toString(), new StringBuffer().append(new StringBuffer().append("L").append(this.f15635c.f15620f.replace(".", "/")).toString()).append("/").toString()), this.f15635c.f15619e, this.f15635c.f15620f));
                return;
            }
            if (this.f15633a.getName().endsWith(".so")) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(this.f15633a);
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(C1887e.m13984b(fileInputStream));
                    C3094az c3094az = new C3094az(new C3094az(new C3094az(byteArrayInputStream, new StringBuffer().append(new StringBuffer().append("Java_").append(this.f15635c.f15619e.replace(".", "_")).toString()).append("_").toString(), new StringBuffer().append(new StringBuffer().append("Java_").append(this.f15635c.f15620f.replace(".", "_")).toString()).append("_").toString()), this.f15635c.f15619e.replace(".", "/"), this.f15635c.f15620f.replace(".", "/")), this.f15635c.f15619e, this.f15635c.f15620f);
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f15633a);
                    byte[] bArr = new byte[C3249i.m19500a()];
                    while (true) {
                        int read = c3094az.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            byteArrayInputStream.close();
                            fileInputStream.close();
                            c3094az.close();
                            fileOutputStream.close();
                            return;
                        }
                    }
                } catch (Error e2) {
                } catch (Exception e3) {
                }
            }
        }
    }
}
