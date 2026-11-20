package ru.maximoff.apktool;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.ActivityC0071c;
import com.srizwan.apktool.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.p217b.p218a.p219a.C1887e;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3262u;

/* loaded from: classes.dex */
public class OpenApk extends ActivityC0071c {
    @Override // androidx.fragment.app.ActivityC0375f, androidx.activity.ActivityC0048b, androidx.core.app.ActivityC0234e, android.app.Activity
    protected void onCreate(Bundle bundle) {
        Uri uri;
        File file;
        InputStream fileInputStream;
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        if (intent.getClipData() != null) {
            uri = intent.getClipData().getItemAt(0).getUri();
        } else if (intent.getData() != null) {
            uri = intent.getData();
        } else {
            uri = (Uri) null;
        }
        if (action == null || uri == null || (!action.equals("android.intent.action.VIEW") && !action.equals(Intent.ACTION_SEND))) {
            C3112bn.m19023b(this, getString(R.string.errorf, getString(R.string.no_data)));
            finish();
            return;
        }
        try {
            String m19565a = C3262u.m19565a(this, uri);
            File file2 = new File(C3102bd.m18908a(), "open_apk");
            file2.mkdirs();
            if (C3112bn.m19040o(m19565a)) {
                file = File.createTempFile("AM_OpenApk", ".apk", file2);
            } else {
                if (!m19565a.toLowerCase().endsWith(".apk")) {
                    m19565a = new StringBuffer().append(m19565a).append(".apk").toString();
                }
                file = new File(file2, C3112bn.m19033h(m19565a));
            }
            file.delete();
            if (uri.getScheme().equals(ContentResolver.SCHEME_CONTENT)) {
                fileInputStream = getContentResolver().openInputStream(uri);
            } else {
                fileInputStream = new FileInputStream(new File(uri.getPath()));
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            C1887e.m13962a(fileInputStream, fileOutputStream);
            fileInputStream.close();
            fileOutputStream.close();
            Intent intent2 = new Intent("ru.maximoff.apktool.OPEN_APK");
            intent2.putExtra("apk_name", m19565a);
            intent2.putExtra("apk_path", file.getAbsolutePath());
            intent2.addFlags(268435456);
            startActivity(intent2);
        } catch (Exception e2) {
            C3112bn.m19023b(this, getString(R.string.errorf, e2.getMessage()));
        }
        finish();
    }
}
