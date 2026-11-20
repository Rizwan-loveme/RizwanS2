package ru.maximoff.apktool.service;

import android.app.Service;
import android.app.slice.Slice;
import android.content.Intent;
import android.content.ServiceConnection;
import android.p008os.Binder;
import android.p008os.DropBoxManager;
import android.p008os.IBinder;
import com.srizwan.apktool.R;

/* loaded from: classes.dex */
public class OngoingServiceBg extends Service {

    /* renamed from: a */
    private IBinder f17128a = new BinderC3054a(this);

    /* renamed from: b */
    private C3056b f17129b = (C3056b) null;

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String action = intent.getAction();
        if (action == null || action.equals("ru.maximoff.apktool.OngoingServiceBg.STOP_SERVICE")) {
            if (this.f17129b != null) {
                this.f17129b.m18193a();
            }
            stopForeground(true);
            stopSelf();
            return super.onStartCommand(intent, i, i2);
        }
        if (action.equals("ru.maximoff.apktool.OngoingServiceBg.ACTION_START")) {
            if (intent.hasExtra(Slice.SUBTYPE_MESSAGE)) {
                m18178a(intent.getStringExtra("title"), intent.getStringExtra(Slice.SUBTYPE_MESSAGE), intent.getStringExtra(DropBoxManager.EXTRA_TAG), intent.getIntExtra("ongoing_id", 0));
            } else {
                m18177a(intent.getStringExtra("title"), intent.getStringExtra(DropBoxManager.EXTRA_TAG), intent.getIntExtra("ongoing_id", 0));
            }
        } else if (action.equals("ru.maximoff.apktool.OngoingServiceBg.ACTION_UPDATE")) {
            m18176a(intent.getStringExtra("title"), intent.getStringExtra(Slice.SUBTYPE_MESSAGE));
        }
        return 3;
    }

    /* renamed from: a */
    public void m18177a(String str, String str2, int i) {
        m18178a(str, getString(R.string.mplease_wait), str2, i);
    }

    /* renamed from: a */
    public void m18178a(String str, String str2, String str3, int i) {
        this.f17129b = new C3056b(this);
        this.f17129b.m18201b(true);
        this.f17129b.m18202c(true);
        this.f17129b.m18194a(i);
        this.f17129b.m18197a(str3);
        this.f17129b.m18195a((CharSequence) str, (CharSequence) str);
        startForeground(i, this.f17129b.m18192a(str, str2));
    }

    /* renamed from: a */
    public void m18176a(String str, String str2) {
        if (this.f17129b != null) {
            this.f17129b.m18199b(str, str2);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f17128a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
        super.unbindService(serviceConnection);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.f17129b != null) {
            this.f17129b.m18193a();
        }
        stopForeground(true);
        stopSelf();
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        if (this.f17129b != null) {
            this.f17129b.m18193a();
        }
        stopForeground(true);
        stopSelf();
    }

    /* renamed from: ru.maximoff.apktool.service.OngoingServiceBg$a */
    public class BinderC3054a extends Binder {

        /* renamed from: a */
        private final OngoingServiceBg f17130a;

        public BinderC3054a(OngoingServiceBg ongoingServiceBg) {
            this.f17130a = ongoingServiceBg;
        }
    }
}
