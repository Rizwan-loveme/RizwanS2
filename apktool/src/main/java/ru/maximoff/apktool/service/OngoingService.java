package ru.maximoff.apktool.service;

import android.app.Service;
import android.app.slice.Slice;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.DropBoxManager;
import android.os.IBinder;
import com.srizwan.apktool.R;

/* loaded from: classes.dex */
public class OngoingService extends Service {

    /* renamed from: a */
    private IBinder f17125a = new BinderC3053a(this);

    /* renamed from: b */
    private C3056b f17126b = (C3056b) null;

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String action = intent.getAction();
        if (action == null || action.equals("ru.maximoff.apktool.OngoingService.STOP_SERVICE")) {
            if (this.f17126b != null) {
                this.f17126b.m18193a();
            }
            stopForeground(true);
            stopSelf();
            return super.onStartCommand(intent, i, i2);
        }
        if (action.equals("ru.maximoff.apktool.OngoingService.ACTION_START")) {
            if (intent.hasExtra(Slice.SUBTYPE_MESSAGE)) {
                m18175a(intent.getStringExtra("title"), intent.getStringExtra(Slice.SUBTYPE_MESSAGE), intent.getStringExtra(DropBoxManager.EXTRA_TAG), intent.getIntExtra("ongoing_id", 0));
            } else {
                m18174a(intent.getStringExtra("title"), intent.getStringExtra(DropBoxManager.EXTRA_TAG), intent.getIntExtra("ongoing_id", 0));
            }
        } else if (action.equals("ru.maximoff.apktool.OngoingService.ACTION_UPDATE")) {
            m18173a(intent.getStringExtra("title"), intent.getStringExtra(Slice.SUBTYPE_MESSAGE));
        }
        return 3;
    }

    /* renamed from: a */
    public void m18174a(String str, String str2, int i) {
        m18175a(str, getString(R.string.mplease_wait), str2, i);
    }

    /* renamed from: a */
    public void m18175a(String str, String str2, String str3, int i) {
        this.f17126b = new C3056b(this);
        this.f17126b.m18201b(true);
        this.f17126b.m18202c(true);
        this.f17126b.m18194a(i);
        this.f17126b.m18197a(str3);
        this.f17126b.m18195a((CharSequence) str, (CharSequence) str);
        startForeground(i, this.f17126b.m18192a(str, str2));
    }

    /* renamed from: a */
    public void m18173a(String str, String str2) {
        if (this.f17126b != null) {
            this.f17126b.m18199b(str, str2);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f17125a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
        super.unbindService(serviceConnection);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.f17126b != null) {
            this.f17126b.m18193a();
        }
        stopForeground(true);
        stopSelf();
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        if (this.f17126b != null) {
            this.f17126b.m18193a();
        }
        stopForeground(true);
        stopSelf();
    }

    /* renamed from: ru.maximoff.apktool.service.OngoingService$a */
    public class BinderC3053a extends Binder {

        /* renamed from: a */
        private final OngoingService f17127a;

        public BinderC3053a(OngoingService ongoingService) {
            this.f17127a = ongoingService;
        }
    }
}
