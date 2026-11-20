package ru.maximoff.apktool.util.p309g;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import com.srizwan.apktool.R;
import java.io.File;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3262u;

/* compiled from: Downloader.java */
/* renamed from: ru.maximoff.apktool.util.g.b */
/* loaded from: classes.dex */
public class C3244b {

    /* renamed from: a */
    static BroadcastReceiver f19492a = new BroadcastReceiver() { // from class: ru.maximoff.apktool.util.g.b.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(intent.getAction())) {
                C3244b.m19463b(context, intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, 0));
            }
        }
    };

    /* renamed from: a */
    public static void m19462a(Context context, String str, String str2, String str3, int i) {
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    Uri parse = Uri.parse(str);
                    context.registerReceiver(f19492a, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
                    DownloadManager.Request request = new DownloadManager.Request(parse);
                    request.setMimeType("application/vnd.android.package-archive");
                    request.setTitle(str2);
                    request.addRequestHeader("User-Agent", new StringBuffer().append(new StringBuffer().append(str3).append(" #AppDownloader_").toString()).append(i).toString());
                    request.setDescription(context.getString(R.string.app_name));
                    request.allowScanningByMediaScanner();
                    request.setNotificationVisibility(1);
                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, str2);
                    ((DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE)).enqueue(request);
                }
            } catch (IllegalStateException e2) {
                C3112bn.m19023b(context, context.getString(R.string.error));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m19463b(Context context, long j) {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(j);
        Cursor query2 = downloadManager.query(query);
        if (query2.moveToFirst()) {
            int i = query2.getInt(query2.getColumnIndex("status"));
            String string = query2.getString(query2.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI));
            if (i == 8 && string != null) {
                C3262u.m19650d(context, new File(Uri.parse(string).getPath()));
            }
        }
        query2.close();
    }
}
