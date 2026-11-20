package ru.maximoff.apktool.util.sai;

import android.app.Service;
import android.content.Intent;
import android.content.p006pm.PackageInstaller;
import android.os.IBinder;

/* loaded from: classes.dex */
public class InstallService extends Service {
    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int intExtra = intent.getIntExtra(PackageInstaller.EXTRA_STATUS, -12345);
        String stringExtra = intent.getStringExtra(PackageInstaller.EXTRA_STATUS_MESSAGE);
        String stringExtra2 = intent.getStringExtra(PackageInstaller.EXTRA_PACKAGE_NAME);
        switch (intExtra) {
            case -1:
                Intent intent2 = (Intent) intent.getParcelableExtra(Intent.EXTRA_INTENT);
                intent2.addFlags(335544320);
                try {
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    break;
                }
            default:
                Intent intent3 = new Intent("ru.maximoff.apktool.ACTION_FILTER");
                intent3.putExtra("saiPackageName", stringExtra2);
                intent3.putExtra("saiSuccess", intExtra == 0);
                intent3.putExtra("saiStatus", intExtra);
                intent3.putExtra("saiMessage", stringExtra);
                sendOrderedBroadcast(intent3, (String) null);
                break;
        }
        stopSelf();
        return 2;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return (IBinder) null;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        stopSelf();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        stopSelf();
    }
}
