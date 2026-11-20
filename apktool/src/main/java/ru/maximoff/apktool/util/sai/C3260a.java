package ru.maximoff.apktool.util.sai;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.p006pm.PackageInstaller;
import android.p008os.Build;
import java.lang.reflect.Method;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.p209io.InputStream;
import java.p209io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import ru.maximoff.apktool.util.C3249i;

/* compiled from: Installer.java */
/* renamed from: ru.maximoff.apktool.util.sai.a */
/* loaded from: classes.dex */
public class C3260a {

    /* renamed from: a */
    private PackageInstaller f19681a;

    /* renamed from: b */
    private Context f19682b;

    /* renamed from: c */
    private String f19683c = (String) null;

    /* renamed from: d */
    private int f19684d = -1;

    public C3260a(Context context) {
        this.f19682b = context.getApplicationContext();
        this.f19681a = this.f19682b.getPackageManager().getPackageInstaller();
    }

    /* renamed from: a */
    public void m19530a(String str) {
        this.f19683c = str;
    }

    /* renamed from: a */
    public void m19529a(int i) {
        this.f19684d = i;
    }

    /* renamed from: a */
    public int m19527a(File file) {
        return m19528a(new File[]{file});
    }

    /* renamed from: a */
    public int m19528a(File[] fileArr) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        long j = 0;
        for (File file : fileArr) {
            try {
                hashMap.put(file.getName(), new Long(file.length()));
                hashMap2.put(file.getName(), file.getAbsolutePath());
                j += file.length();
                if (this.f19683c == null) {
                    try {
                        String str = this.f19682b.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0).packageName;
                        if (str != null) {
                            this.f19683c = str;
                        }
                    } catch (Exception e2) {
                    }
                }
            } catch (Exception e3) {
                return -1;
            }
        }
        try {
            PackageInstaller.SessionParams sessionParams = new PackageInstaller.SessionParams(1);
            sessionParams.setSize(j);
            if (this.f19683c != null) {
                sessionParams.setAppPackageName(this.f19683c);
            }
            if (this.f19684d >= 0) {
                sessionParams.setInstallLocation(this.f19684d);
            }
            m19525a(sessionParams, 2);
            int createSession = this.f19681a.createSession(sessionParams);
            for (Map.Entry entry : hashMap.entrySet()) {
                m19524a(createSession, ((Long) entry.getValue()).longValue(), (String) entry.getKey(), (String) hashMap2.get((String) entry.getKey()));
            }
            if (m19526b(createSession) == 0) {
                return createSession;
            }
        } catch (Exception e4) {
        }
        return -1;
    }

    /* renamed from: a */
    private void m19525a(PackageInstaller.SessionParams sessionParams, int i) {
        try {
            try {
                Method declaredMethod = Class.forName("android.content.pm.PackageInstaller$SessionParams").getDeclaredMethod("setPackageSource", Integer.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(sessionParams, new Integer(i));
            } catch (ClassNotFoundException e2) {
                throw new NoClassDefFoundError(e2.getMessage());
            }
        } catch (Error e3) {
        } catch (Exception e4) {
        }
    }

    /* renamed from: a */
    private int m19524a(int i, long j, String str, String str2) {
        InputStream inputStream;
        PackageInstaller.Session session = (PackageInstaller.Session) null;
        InputStream inputStream2 = (InputStream) null;
        OutputStream outputStream = (OutputStream) null;
        try {
            session = this.f19681a.openSession(i);
            inputStream = new FileInputStream(str2);
            try {
                try {
                    outputStream = session.openWrite(str, 0, j);
                    byte[] bArr = new byte[C3249i.m19500a()];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        outputStream.write(bArr, 0, read);
                    }
                    session.fsync(outputStream);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e2) {
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (session != null) {
                        session.close();
                    }
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e3) {
                            throw th;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (session != null) {
                        session.close();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                inputStream2 = inputStream;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e5) {
                        return 1;
                    }
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (session != null) {
                    session.close();
                }
                return 1;
            }
        } catch (Exception e6) {
        } catch (Throwable th2) {
            th = th2;
            inputStream = inputStream2;
        }
    }

    /* renamed from: b */
    private int m19526b(int i) {
        PackageInstaller.Session session;
        PackageInstaller.Session session2 = (PackageInstaller.Session) null;
        try {
            session = this.f19681a.openSession(i);
            try {
                try {
                    Intent intent = new Intent(this.f19682b, Class.forName("ru.maximoff.apktool.util.sai.InstallService"));
                    intent.addFlags(335544320);
                    intent.putExtra(PackageInstaller.EXTRA_PACKAGE_NAME, this.f19683c);
                    session.commit(PendingIntent.getService(this.f19682b, 0, intent, Build.VERSION.SDK_INT >= 31 ? 301989888 : 268435456).getIntentSender());
                    if (session != null) {
                        session.close();
                    }
                    return 0;
                } catch (ClassNotFoundException e2) {
                    throw new NoClassDefFoundError(e2.getMessage());
                }
            } catch (Exception e3) {
                session2 = session;
                if (session2 != null) {
                    session2.close();
                }
                return 1;
            } catch (Throwable th) {
                th = th;
                if (session != null) {
                    session.close();
                }
                throw th;
            }
        } catch (Exception e4) {
        } catch (Throwable th2) {
            th = th2;
            session = session2;
        }
    }
}
