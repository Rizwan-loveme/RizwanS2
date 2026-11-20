package ru.maximoff.apktool.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.provider.Contacts;
import com.srizwan.apktool.R;
import java.io.File;
import java.util.ArrayList;
import ru.maximoff.apktool.util.p303a.C3061a;

/* compiled from: TraceReader.java */
/* renamed from: ru.maximoff.apktool.util.bp */
/* loaded from: classes.dex */
public class C3114bp {

    /* renamed from: a */
    private Activity f18390a;

    /* renamed from: b */
    private File f18391b;

    public C3114bp(Activity activity) {
        this.f18390a = activity;
        this.f18391b = new File(activity.getExternalFilesDir((String) null), "Apktool_M.crashlog.txt");
    }

    /* renamed from: a */
    public String m19044a() {
        return C3061a.m18332i(this.f18391b);
    }

    /* renamed from: a */
    public void m19045a(String str) {
        File file;
        File[] fileArr;
        if (this.f18391b.exists() && !this.f18391b.isDirectory()) {
            if (str.isEmpty()) {
                str = "##### NO DESCRIPTION #####\n";
            }
            try {
                file = new File(String.format("%s/Apktool_M_LogCat_%d_%s.txt", this.f18390a.getExternalFilesDir((String) null).getAbsolutePath(), new Integer(this.f18390a.getPackageManager().getPackageInfo(this.f18390a.getPackageName(), 0).versionCode), C3112bn.m19032g("yyyyMMdd_HHmmss")));
                if (!C3080al.m18568a(file)) {
                    file = (File) null;
                }
            } catch (Exception e2) {
                file = (File) null;
            }
            if (C3080al.m18589c(this.f18390a)) {
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                arrayList.add(C3262u.m19657e(this.f18390a, this.f18391b));
                if (file != null) {
                    arrayList.add(C3262u.m19657e(this.f18390a, file));
                }
                C3112bn.m18999a(this.f18390a, R.string.send_log);
                Intent intent = new Intent(Intent.ACTION_SEND_MULTIPLE);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"apktool@maximoff.su"});
                intent.setType(Contacts.ContactMethods.CONTENT_EMAIL_TYPE);
                intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, arrayList);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Apktool M Crash");
                intent.putExtra(Intent.EXTRA_TEXT, str);
                intent.addFlags(1);
                this.f18390a.startActivity(Intent.createChooser(intent, this.f18390a.getString(R.string.send_log)));
                return;
            }
            if (file == null) {
                fileArr = new File[]{this.f18391b};
            } else {
                fileArr = new File[]{this.f18391b, file};
            }
            C3262u.m19604a(this.f18390a, fileArr);
        }
    }
}
