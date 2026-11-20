package com.p065b.p086b.p087a.p091d;

import android.icu.text.SymbolTable;
import android.view.Window;
import com.p065b.p086b.p110h.C1020k;
import java.p209io.ByteArrayOutputStream;
import java.p209io.File;
import java.p209io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: ClassPathOpener.java */
/* renamed from: com.b.b.a.d.d */
/* loaded from: classes.dex */
public class C0733d {

    /* renamed from: a */
    private final String f4632a;

    /* renamed from: b */
    private final a f4633b;

    /* renamed from: c */
    private final boolean f4634c;

    /* compiled from: ClassPathOpener.java */
    /* renamed from: com.b.b.a.d.d$a */
    public interface a {
        /* renamed from: a */
        void mo6823a(File file);

        /* renamed from: a */
        void mo6824a(Exception exc);

        /* renamed from: a */
        boolean mo6825a(String str, long j, byte[] bArr);
    }

    public C0733d(String str, boolean z, a aVar) {
        this.f4632a = str;
        this.f4634c = z;
        this.f4633b = aVar;
    }

    /* renamed from: a */
    public boolean m6820a() {
        return m6817a(new File(this.f4632a), true);
    }

    /* renamed from: a */
    private boolean m6817a(File file, boolean z) {
        boolean m6816a;
        try {
            if (file.isDirectory()) {
                m6816a = m6819b(file, z);
            } else {
                String path = file.getPath();
                if (path.endsWith(".zip") || path.endsWith(".jar") || path.endsWith(".apk")) {
                    m6816a = m6816a(file);
                } else {
                    m6816a = this.f4633b.mo6825a(path, file.lastModified(), C1020k.m8542a(file));
                }
            }
            return m6816a;
        } catch (Exception e2) {
            this.f4633b.mo6824a(e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static int m6818b(String str, String str2) {
        return str.replace(SymbolTable.SYMBOL_REF, '0').replace("package-info", "").compareTo(str2.replace(SymbolTable.SYMBOL_REF, '0').replace("package-info", ""));
    }

    /* renamed from: b */
    private boolean m6819b(File file, boolean z) {
        if (z) {
            file = new File(file, ".");
        }
        File[] listFiles = file.listFiles();
        if (this.f4634c) {
            Arrays.sort(listFiles, new Comparator<File>() { // from class: com.b.b.a.d.d.1
                @Override // java.util.Comparator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(File file2, File file3) {
                    return C0733d.m6818b(file2.getName(), file3.getName());
                }
            });
        }
        boolean z2 = false;
        for (File file2 : listFiles) {
            z2 |= m6817a(file2, false);
        }
        return z2;
    }

    /* renamed from: a */
    private boolean m6816a(File file) {
        ZipFile zipFile = new ZipFile(file);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(40000);
        byte[] bArr = new byte[Window.PROGRESS_SECONDARY_START];
        ArrayList list = Collections.list(zipFile.entries());
        if (this.f4634c) {
            Collections.sort(list, new Comparator<ZipEntry>() { // from class: com.b.b.a.d.d.2
                @Override // java.util.Comparator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(ZipEntry zipEntry, ZipEntry zipEntry2) {
                    return C0733d.m6818b(zipEntry.getName(), zipEntry2.getName());
                }
            });
        }
        this.f4633b.mo6823a(file);
        Iterator it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            ZipEntry zipEntry = (ZipEntry) it.next();
            if (!zipEntry.isDirectory()) {
                String name = zipEntry.getName();
                InputStream inputStream = zipFile.getInputStream(zipEntry);
                byteArrayOutputStream.reset();
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                inputStream.close();
                z = this.f4633b.mo6825a(name, zipEntry.getTime(), byteArrayOutputStream.toByteArray()) | z;
            }
        }
        zipFile.close();
        return z;
    }
}
