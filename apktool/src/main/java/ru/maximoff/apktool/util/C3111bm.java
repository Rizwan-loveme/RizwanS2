package ru.maximoff.apktool.util;

import com.srizwan.apktool.R;
import java.p209io.BufferedReader;
import java.p209io.InputStream;
import java.p209io.InputStreamReader;
import p046b.p059d.InterfaceC0541f;

/* compiled from: StreamForwarder.java */
/* renamed from: ru.maximoff.apktool.util.bm */
/* loaded from: classes.dex */
public class C3111bm extends Thread {

    /* renamed from: a */
    private final InputStream f18380a;

    /* renamed from: b */
    private final int f18381b;

    /* renamed from: c */
    private final InterfaceC0541f f18382c;

    public C3111bm(InputStream inputStream, int i, InterfaceC0541f interfaceC0541f) {
        this.f18380a = inputStream;
        this.f18381b = i;
        this.f18382c = interfaceC0541f;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f18380a));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    switch (this.f18381b) {
                        case 1:
                            this.f18382c.mo3984d(R.string.text, readLine);
                            break;
                        case 2:
                            this.f18382c.mo3983c(R.string.text, readLine);
                            break;
                        case 3:
                            this.f18382c.mo3979a(R.string.text, readLine);
                            break;
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e2) {
        }
    }
}
