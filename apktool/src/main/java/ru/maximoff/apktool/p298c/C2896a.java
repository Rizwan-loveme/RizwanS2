package ru.maximoff.apktool.p298c;

import android.app.slice.Slice;
import android.content.ClipDescription;
import android.content.ContentResolver;
import android.hardware.Camera;
import android.media.MediaFormat;
import android.view.Window;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: LocalFileServer.java */
/* renamed from: ru.maximoff.apktool.c.a */
/* loaded from: classes.dex */
public class C2896a {

    /* renamed from: b */
    private final File f14894b;

    /* renamed from: c */
    private final int f14895c;

    /* renamed from: d */
    private volatile c f14896d;

    /* renamed from: e */
    private volatile boolean f14897e;

    /* renamed from: f */
    private ServerSocket f14898f;

    /* renamed from: g */
    private Thread f14899g;

    /* renamed from: a */
    private String f14893a = "Local WebDAV Server";

    /* renamed from: h */
    private int f14900h = -1;

    /* renamed from: i */
    private final Map<String, a> f14901i = new ConcurrentHashMap();

    /* compiled from: LocalFileServer.java */
    /* renamed from: ru.maximoff.apktool.c.a$b */
    private static class b {

        /* renamed from: a */
        String f14910a;

        /* renamed from: b */
        String f14911b;

        /* renamed from: c */
        long f14912c;

        /* renamed from: d */
        Map<String, String> f14913d = new HashMap();
    }

    /* compiled from: LocalFileServer.java */
    /* renamed from: ru.maximoff.apktool.c.a$c */
    public interface c {
        /* renamed from: a */
        void mo17006a();

        /* renamed from: a */
        void mo17007a(Exception exc);

        /* renamed from: a */
        void mo17008a(String str, int i);
    }

    public C2896a(File file, int i) {
        if (file == null) {
            throw new IllegalArgumentException("Root is null");
        }
        File m16970b = m16970b(file);
        if (!m16970b.exists() || !m16970b.isDirectory()) {
            throw new IllegalArgumentException(new StringBuffer().append("Root directory does not exist: ").append(m16970b.getAbsolutePath()).toString());
        }
        this.f14894b = m16970b;
        this.f14895c = i;
    }

    /* renamed from: a */
    public void m17001a(c cVar) {
        this.f14896d = cVar;
    }

    /* renamed from: a */
    public void m17000a(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        this.f14893a = str;
    }

    /* renamed from: a */
    public synchronized void m16999a() {
        if (!this.f14897e) {
            this.f14899g = new Thread(new Runnable(this) { // from class: ru.maximoff.apktool.c.a.1

                /* renamed from: a */
                private final C2896a f14902a;

                {
                    this.f14902a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f14902a.m16984d();
                }
            }, "LocalFileServer");
            this.f14899g.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m16984d() {
        try {
            try {
                this.f14898f = m16987e();
                this.f14900h = this.f14898f.getLocalPort();
                this.f14897e = true;
                String stringBuffer = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("http://").append(m16992g()).toString()).append(":").toString()).append(this.f14900h).toString();
                c cVar = this.f14896d;
                if (cVar != null) {
                    cVar.mo17008a(stringBuffer, this.f14900h);
                }
                while (this.f14897e) {
                    try {
                        new Thread(new Runnable(this, this.f14898f.accept()) { // from class: ru.maximoff.apktool.c.a.2

                            /* renamed from: a */
                            private final C2896a f14903a;

                            /* renamed from: b */
                            private final Socket f14904b;

                            {
                                this.f14903a = this;
                                this.f14904b = r2;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                this.f14903a.m16961a(this.f14904b);
                            }
                        }, "LocalFileServer-Client").start();
                    } catch (IOException e2) {
                        if (this.f14897e) {
                            m16958a(e2);
                        }
                    }
                }
            } catch (Exception e3) {
                m16958a(e3);
            }
            this.f14897e = false;
            try {
                if (this.f14898f != null) {
                    this.f14898f.close();
                }
            } catch (IOException e4) {
            }
            this.f14898f = (ServerSocket) null;
            this.f14900h = -1;
            this.f14901i.clear();
            c cVar2 = this.f14896d;
            if (cVar2 != null) {
                cVar2.mo17006a();
            }
        } finally {
        }
    }

    /* renamed from: e */
    private ServerSocket m16987e() {
        IOException e2 = (IOException) null;
        for (int i = this.f14895c; i < this.f14895c + 1000; i++) {
            try {
                return new ServerSocket(i);
            } catch (IOException e3) {
                e2 = e3;
            }
        }
        throw new IOException("No free port found", e2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16961a(Socket socket) {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        b m16948a;
        try {
            socket.setSoTimeout(Window.PROGRESS_SECONDARY_END);
            bufferedInputStream = new BufferedInputStream(socket.getInputStream());
            bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
            m16948a = m16948a(bufferedInputStream);
        } catch (Exception e2) {
        } catch (Throwable th) {
            try {
                socket.close();
            } catch (IOException e3) {
            }
            throw th;
        }
        if (m16948a == null) {
            try {
                socket.close();
            } catch (IOException e4) {
            }
        } else {
            m16962a(m16948a, bufferedInputStream, bufferedOutputStream);
            bufferedOutputStream.flush();
            try {
                socket.close();
            } catch (IOException e5) {
            }
        }
    }

    /* renamed from: a */
    private void m16962a(b bVar, InputStream inputStream, OutputStream outputStream) {
        String str = bVar.f14910a;
        if ("GET".equals(str)) {
            m16963a(bVar, outputStream);
            return;
        }
        if ("HEAD".equals(str)) {
            m16976b(bVar, outputStream);
            return;
        }
        if ("OPTIONS".equals(str)) {
            m16951a(outputStream);
            return;
        }
        if ("PROPFIND".equals(str)) {
            m16980c(bVar, outputStream);
            return;
        }
        if ("PUT".equals(str)) {
            m16975b(bVar, inputStream, outputStream);
            return;
        }
        if ("DELETE".equals(str)) {
            m16985d(bVar, outputStream);
            return;
        }
        if ("MKCOL".equals(str)) {
            m16988e(bVar, outputStream);
            return;
        }
        if ("COPY".equals(str)) {
            m16965a(bVar, false, outputStream);
            return;
        }
        if ("MOVE".equals(str)) {
            m16965a(bVar, true, outputStream);
            return;
        }
        if ("LOCK".equals(str)) {
            m16979c(bVar, inputStream, outputStream);
        } else if ("UNLOCK".equals(str)) {
            m16991f(bVar, outputStream);
        } else {
            m16974b(outputStream, 405, "Method Not Allowed");
        }
    }

    /* renamed from: a */
    private void m16963a(b bVar, OutputStream outputStream) {
        File m16986e = m16986e(bVar.f14911b);
        if (m16986e == null) {
            m16974b(outputStream, 403, "Forbidden");
            return;
        }
        if (!m16986e.exists()) {
            m16974b(outputStream, 404, "Not Found");
        } else if (m16986e.isDirectory()) {
            m16956a(outputStream, m16986e, bVar.f14911b);
        } else {
            m16964a(bVar, outputStream, m16986e);
        }
    }

    /* renamed from: b */
    private void m16976b(b bVar, OutputStream outputStream) {
        File m16986e = m16986e(bVar.f14911b);
        if (m16986e == null) {
            m16974b(outputStream, 403, "Forbidden");
            return;
        }
        if (!m16986e.exists()) {
            m16974b(outputStream, 404, "Not Found");
        } else if (m16986e.isDirectory()) {
            m16953a(outputStream, 200, "OK", "text/html; charset=UTF-8", -1);
        } else {
            m16953a(outputStream, 200, "OK", m16998l(m16986e.getName()), m16986e.length());
        }
    }

    /* renamed from: a */
    private void m16964a(b bVar, OutputStream outputStream, File file) {
        String substring;
        int indexOf;
        long j;
        long length = file.length();
        String str = bVar.f14913d.get(Slice.SUBTYPE_RANGE);
        long j2 = 0;
        long j3 = length - 1;
        if (str != null && str.startsWith("bytes=") && (indexOf = (substring = str.substring(6)).indexOf(45)) >= 0) {
            String trim = substring.substring(0, indexOf).trim();
            String trim2 = substring.substring(indexOf + 1).trim();
            try {
                if (trim.length() > 0) {
                    j2 = Long.parseLong(trim);
                    j = trim2.length() > 0 ? Long.parseLong(trim2) : j3;
                } else {
                    if (trim2.length() > 0) {
                        long parseLong = Long.parseLong(trim2);
                        if (parseLong < length) {
                            j2 = length - parseLong;
                            j = j3;
                        }
                    }
                    j = j3;
                }
                if (j2 < 0 || j2 >= length) {
                    m16955a(outputStream, length);
                    return;
                }
                if (j >= length) {
                    j = length - 1;
                }
                if (j < j2) {
                    m16955a(outputStream, length);
                    return;
                }
                long j4 = (j - j2) + 1;
                m16954a(outputStream, 206, "Partial Content", m16998l(file.getName()), j4, j2, j, length);
                m16950a(file, outputStream, j2, j4);
                return;
            } catch (NumberFormatException e2) {
                m16955a(outputStream, length);
                return;
            }
        }
        m16953a(outputStream, 200, "OK", m16998l(file.getName()), length);
        m16950a(file, outputStream, 0, length);
    }

    /* renamed from: a */
    private void m16950a(File file, OutputStream outputStream, long j, long j2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = (FileInputStream) null;
        try {
            fileInputStream = new FileInputStream(file);
            long j3 = 0;
            while (j3 < j) {
                try {
                    long skip = fileInputStream.skip(j - j3);
                    if (skip <= 0) {
                        break;
                    } else {
                        j3 += skip;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    throw th;
                }
            }
            byte[] bArr = new byte[8192];
            while (j2 > 0) {
                int read = fileInputStream.read(bArr, 0, (int) Math.min(bArr.length, j2));
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
                j2 -= read;
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = fileInputStream2;
        }
    }

    /* renamed from: a */
    private void m16951a(OutputStream outputStream) {
        outputStream.write(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("HTTP/1.1 200 OK\r\n").append("Allow: OPTIONS, GET, HEAD, PROPFIND, PUT, DELETE, ").toString()).append("MKCOL, COPY, MOVE, LOCK, UNLOCK\r\n").toString()).append("Server: ").toString()).append(this.f14893a).toString()).append("\r\n").toString()).append("DAV: 1, 2\r\n").toString()).append("MS-Author-Via: DAV\r\n").toString()).append("Accept-Ranges: bytes\r\n").toString()).append("Content-Length: 0\r\n").toString()).append("Connection: close\r\n").toString()).append("\r\n").toString().getBytes("ISO-8859-1"));
    }

    /* renamed from: c */
    private void m16980c(b bVar, OutputStream outputStream) {
        int i;
        File m16986e = m16986e(bVar.f14911b);
        if (m16986e == null) {
            m16974b(outputStream, 403, "Forbidden");
            return;
        }
        if (!m16986e.exists()) {
            m16974b(outputStream, 404, "Not Found");
            return;
        }
        String str = bVar.f14913d.get("depth");
        if ("0".equals(str)) {
            i = 0;
        } else if (!Camera.Parameters.FOCUS_MODE_INFINITY.equalsIgnoreCase(str)) {
            i = 1;
        } else {
            i = Integer.MAX_VALUE;
        }
        byte[] bytes = m16946a(m16986e, bVar.f14911b, i).getBytes("UTF-8");
        m16953a(outputStream, 207, "Multi-Status", "application/xml; charset=UTF-8", bytes.length);
        outputStream.write(bytes);
    }

    /* renamed from: a */
    private String m16946a(File file, String str, int i) {
        File[] listFiles;
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sb.append("<D:multistatus xmlns:D=\"DAV:\">");
        m16959a(sb, file, m16989f(str));
        if (file.isDirectory() && i > 0 && (listFiles = file.listFiles()) != null) {
            ArrayList<File> arrayList = new ArrayList();
            Collections.addAll(arrayList, listFiles);
            Collections.sort(arrayList, new Comparator<File>(this) { // from class: ru.maximoff.apktool.c.a.3

                /* renamed from: a */
                private final C2896a f14905a;

                {
                    this.f14905a = this;
                }

                @Override // java.util.Comparator
                public int compare(File file2, File file3) {
                    return m17004a(file2, file3);
                }

                /* renamed from: a */
                public int m17004a(File file2, File file3) {
                    if (file2.isDirectory() && !file3.isDirectory()) {
                        return -1;
                    }
                    if (!file2.isDirectory() && file3.isDirectory()) {
                        return 1;
                    }
                    return file2.getName().compareToIgnoreCase(file3.getName());
                }
            });
            for (File file2 : arrayList) {
                String m16947a = m16947a(m16989f(str), file2.getName(), file2.isDirectory());
                m16959a(sb, file2, m16947a);
                if (i > 1 && file2.isDirectory()) {
                    m16960a(sb, file2, m16947a, i - 1);
                }
            }
        }
        sb.append("</D:multistatus>");
        return sb.toString();
    }

    /* renamed from: a */
    private void m16960a(StringBuilder sb, File file, String str, int i) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                String m16947a = m16947a(str, file2.getName(), file2.isDirectory());
                m16959a(sb, file2, m16947a);
                if (i > 1 && file2.isDirectory()) {
                    m16960a(sb, file2, m16947a, i - 1);
                }
            }
        }
    }

    /* renamed from: a */
    private void m16959a(StringBuilder sb, File file, String str) {
        sb.append("<D:response>");
        sb.append("<D:href>");
        sb.append(m16997k(str));
        sb.append("</D:href>");
        sb.append("<D:propstat>");
        sb.append("<D:prop>");
        sb.append("<D:displayname>");
        sb.append(m16997k(file.getName()));
        sb.append("</D:displayname>");
        sb.append("<D:getlastmodified>");
        sb.append(m16997k(m16977c(file.lastModified())));
        sb.append("</D:getlastmodified>");
        sb.append("<D:getetag>");
        sb.append("\"");
        sb.append(m16982d(file));
        sb.append("\"");
        sb.append("</D:getetag>");
        if (file.isDirectory()) {
            sb.append("<D:resourcetype>");
            sb.append("<D:collection/>");
            sb.append("</D:resourcetype>");
        } else {
            sb.append("<D:resourcetype/>");
            sb.append("<D:getcontentlength>");
            sb.append(file.length());
            sb.append("</D:getcontentlength>");
            sb.append("<D:getcontenttype>");
            sb.append(m16997k(m16998l(file.getName())));
            sb.append("</D:getcontenttype>");
        }
        sb.append("</D:prop>");
        sb.append("<D:status>");
        sb.append("HTTP/1.1 200 OK");
        sb.append("</D:status>");
        sb.append("</D:propstat>");
        sb.append("</D:response>");
    }

    /* renamed from: b */
    private void m16975b(b bVar, InputStream inputStream, OutputStream outputStream) {
        FileOutputStream fileOutputStream;
        int read;
        File m16986e = m16986e(bVar.f14911b);
        if (m16986e == null) {
            m16974b(outputStream, 403, "Forbidden");
            return;
        }
        if (m16986e.isDirectory()) {
            m16974b(outputStream, 405, "Method Not Allowed");
            return;
        }
        boolean exists = m16986e.exists();
        if (!m16969a(bVar, m16986e)) {
            m16974b(outputStream, 423, "Locked");
            return;
        }
        File parentFile = m16986e.getParentFile();
        if (parentFile == null || !parentFile.exists()) {
            m16974b(outputStream, HttpURLConnection.HTTP_CONFLICT, "Conflict");
            return;
        }
        FileOutputStream fileOutputStream2 = (FileOutputStream) null;
        try {
            fileOutputStream = new FileOutputStream(m16986e, false);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = fileOutputStream2;
        }
        try {
            long j = bVar.f14912c;
            byte[] bArr = new byte[8192];
            while (j > 0 && (read = inputStream.read(bArr, 0, (int) Math.min(bArr.length, j))) != -1) {
                fileOutputStream.write(bArr, 0, read);
                j -= read;
            }
            if (j > 0) {
                throw new IOException("Unexpected end of PUT request");
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                }
            }
            m16952a(outputStream, exists ? 204 : 201, exists ? "No Content" : "Created");
        } catch (Throwable th2) {
            th = th2;
            if (fileOutputStream == null) {
                throw th;
            }
            try {
                fileOutputStream.close();
                throw th;
            } catch (IOException e3) {
                throw th;
            }
        }
    }

    /* renamed from: d */
    private void m16985d(b bVar, OutputStream outputStream) {
        File m16986e = m16986e(bVar.f14911b);
        if (m16986e == null) {
            m16974b(outputStream, 403, "Forbidden");
            return;
        }
        if (m16986e.equals(this.f14894b)) {
            m16974b(outputStream, 403, "Forbidden");
            return;
        }
        if (!m16986e.exists()) {
            m16974b(outputStream, 404, "Not Found");
            return;
        }
        if (!m16969a(bVar, m16986e)) {
            m16974b(outputStream, 423, "Locked");
        } else if (!m16968a(m16986e)) {
            m16974b(outputStream, HttpURLConnection.HTTP_CONFLICT, "Conflict");
        } else {
            m16952a(outputStream, 204, "No Content");
        }
    }

    /* renamed from: a */
    private boolean m16968a(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return false;
            }
            for (File file2 : listFiles) {
                if (!m16968a(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* renamed from: e */
    private void m16988e(b bVar, OutputStream outputStream) {
        File m16986e = m16986e(bVar.f14911b);
        if (m16986e == null) {
            m16974b(outputStream, 403, "Forbidden");
            return;
        }
        if (m16986e.exists()) {
            m16974b(outputStream, 405, "Method Not Allowed");
            return;
        }
        File parentFile = m16986e.getParentFile();
        if (parentFile == null || !parentFile.exists()) {
            m16974b(outputStream, HttpURLConnection.HTTP_CONFLICT, "Conflict");
        } else if (!m16986e.mkdir()) {
            m16974b(outputStream, HttpURLConnection.HTTP_CONFLICT, "Conflict");
        } else {
            m16952a(outputStream, 201, "Created");
        }
    }

    /* renamed from: a */
    private void m16965a(b bVar, boolean z, OutputStream outputStream) {
        boolean z2;
        File m16986e = m16986e(bVar.f14911b);
        if (m16986e == null) {
            m16974b(outputStream, 403, "Forbidden");
            return;
        }
        if (!m16986e.exists()) {
            m16974b(outputStream, 404, "Not Found");
            return;
        }
        if (m16986e.equals(this.f14894b)) {
            m16974b(outputStream, 403, "Forbidden");
            return;
        }
        if (!m16969a(bVar, m16986e)) {
            m16974b(outputStream, 423, "Locked");
            return;
        }
        String str = bVar.f14913d.get("destination");
        if (str == null) {
            m16974b(outputStream, 400, "Destination Required");
            return;
        }
        File m16971b = m16971b(str);
        if (m16971b == null) {
            m16974b(outputStream, 403, "Forbidden");
            return;
        }
        if (m16971b.equals(this.f14894b)) {
            m16974b(outputStream, 403, "Forbidden");
            return;
        }
        if (!"F".equalsIgnoreCase(bVar.f14913d.get("overwrite"))) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (m16971b.exists()) {
            if (!z2) {
                m16974b(outputStream, HttpURLConnection.HTTP_PRECON_FAILED, "Precondition Failed");
                return;
            } else if (!m16968a(m16971b)) {
                m16974b(outputStream, HttpURLConnection.HTTP_CONFLICT, "Conflict");
                return;
            }
        }
        File parentFile = m16971b.getParentFile();
        if (parentFile == null || !parentFile.exists()) {
            m16974b(outputStream, HttpURLConnection.HTTP_CONFLICT, "Conflict");
            return;
        }
        if (z) {
            if (!m16986e.renameTo(m16971b)) {
                m16949a(m16986e, m16971b);
                if (!m16968a(m16986e)) {
                    m16974b(outputStream, 500, "Move Failed");
                    return;
                }
            }
        } else {
            m16949a(m16986e, m16971b);
        }
        m16952a(outputStream, 201, "Created");
    }

    /* renamed from: a */
    private void m16949a(File file, File file2) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        if (file.isDirectory()) {
            if (!file2.mkdir() && !file2.isDirectory()) {
                throw new IOException("Cannot create directory");
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file3 : listFiles) {
                    m16949a(file3, new File(file2, file3.getName()));
                }
                return;
            }
            return;
        }
        FileInputStream fileInputStream2 = (FileInputStream) null;
        FileOutputStream fileOutputStream2 = (FileOutputStream) null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        fileOutputStream.write(bArr, 0, read);
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                file2.setLastModified(file.lastModified());
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                    }
                }
                if (fileOutputStream2 == null) {
                    throw th;
                }
                try {
                    fileOutputStream2.close();
                    throw th;
                } catch (IOException e5) {
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = fileInputStream2;
        }
    }

    /* renamed from: b */
    private File m16971b(String str) {
        try {
            int indexOf = str.indexOf("://");
            if (indexOf >= 0) {
                int indexOf2 = str.indexOf(47, indexOf + 3);
                if (indexOf2 >= 0) {
                    str = str.substring(indexOf2);
                } else {
                    str = "/";
                }
            }
            return m16986e(str);
        } catch (Exception e2) {
            return (File) null;
        }
    }

    /* renamed from: c */
    private void m16979c(b bVar, InputStream inputStream, OutputStream outputStream) {
        int read;
        File m16986e = m16986e(bVar.f14911b);
        if (m16986e == null) {
            m16974b(outputStream, 403, "Forbidden");
            return;
        }
        String str = bVar.f14913d.get("lock-token");
        if (str != null) {
            a aVar = this.f14901i.get(m16983d(str));
            if (aVar == null) {
                m16974b(outputStream, HttpURLConnection.HTTP_PRECON_FAILED, "Precondition Failed");
                return;
            } else {
                aVar.f14909c = System.currentTimeMillis() + 3600000;
                m16957a(outputStream, aVar);
                return;
            }
        }
        if (bVar.f14912c > 0) {
            long j = bVar.f14912c;
            byte[] bArr = new byte[8192];
            while (j > 0 && (read = inputStream.read(bArr, 0, (int) Math.min(bArr.length, j))) != -1) {
                j -= read;
            }
        }
        String stringBuffer = new StringBuffer().append("opaquelocktoken:").append(UUID.randomUUID().toString()).toString();
        a aVar2 = new a(stringBuffer, m16986e, System.currentTimeMillis() + 3600000);
        this.f14901i.put(stringBuffer, aVar2);
        m16957a(outputStream, aVar2);
    }

    /* renamed from: a */
    private void m16957a(OutputStream outputStream, a aVar) {
        byte[] bytes = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append("<D:prop xmlns:D=\"DAV:\">").toString()).append("<D:lockdiscovery>").toString()).append("<D:activelock>").toString()).append("<D:locktype><D:write/></D:locktype>").toString()).append("<D:lockscope><D:exclusive/></D:lockscope>").toString()).append("<D:depth>infinity</D:depth>").toString()).append("<D:timeout>Second-3600</D:timeout>").toString()).append("<D:locktoken>").toString()).append("<D:href>").toString()).append(m16997k(aVar.f14907a)).toString()).append("</D:href>").toString()).append("</D:locktoken>").toString()).append("</D:activelock>").toString()).append("</D:lockdiscovery>").toString()).append("</D:prop>").toString().getBytes("UTF-8");
        outputStream.write(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("HTTP/1.1 200 OK\r\n").append("Server: ").toString()).append(this.f14893a).toString()).append("\r\n").toString()).append("Lock-Token: <").toString()).append(aVar.f14907a).toString()).append(">\r\n").toString()).append("Content-Type: application/xml; charset=UTF-8\r\n").toString()).append("Content-Length: ").toString()).append(bytes.length).toString()).append("\r\n").toString()).append("Connection: close\r\n").toString()).append("\r\n").toString().getBytes("ISO-8859-1"));
        outputStream.write(bytes);
    }

    /* renamed from: f */
    private void m16991f(b bVar, OutputStream outputStream) {
        String str = bVar.f14913d.get("lock-token");
        if (str == null) {
            m16974b(outputStream, 400, "Lock-Token Required");
            return;
        }
        if (this.f14901i.remove(m16983d(str)) == null) {
            m16974b(outputStream, HttpURLConnection.HTTP_CONFLICT, "Conflict");
        } else {
            m16952a(outputStream, 204, "No Content");
        }
    }

    /* renamed from: a */
    private boolean m16969a(b bVar, File file) {
        m16990f();
        String str = bVar.f14913d.get("if");
        String m16978c = str != null ? m16978c(str) : str;
        for (a aVar : this.f14901i.values()) {
            if (aVar.f14908b.equals(file)) {
                return m16978c != null && m16978c.equals(aVar.f14907a);
            }
        }
        return true;
    }

    /* renamed from: f */
    private void m16990f() {
        long currentTimeMillis = System.currentTimeMillis();
        for (Map.Entry<String, a> entry : this.f14901i.entrySet()) {
            if (entry.getValue().f14909c <= currentTimeMillis) {
                this.f14901i.remove(entry.getKey());
            }
        }
    }

    /* renamed from: c */
    private String m16978c(String str) {
        int indexOf = str.indexOf(60);
        int indexOf2 = str.indexOf(62);
        if (indexOf >= 0 && indexOf2 > indexOf) {
            return str.substring(indexOf + 1, indexOf2);
        }
        return str;
    }

    /* renamed from: d */
    private String m16983d(String str) {
        String trim = str.trim();
        if (trim.startsWith("<") && trim.endsWith(">")) {
            return trim.substring(1, trim.length() - 1);
        }
        return trim;
    }

    /* renamed from: a */
    private b m16948a(BufferedInputStream bufferedInputStream) {
        String m16973b = m16973b(bufferedInputStream);
        if (m16973b == null || m16973b.length() == 0) {
            return (b) null;
        }
        String[] split = m16973b.split(" ");
        if (split.length < 2) {
            return (b) null;
        }
        b bVar = new b();
        bVar.f14910a = split[0].toUpperCase(Locale.f10688US);
        bVar.f14911b = split[1];
        int indexOf = bVar.f14911b.indexOf(63);
        if (indexOf >= 0) {
            bVar.f14911b = bVar.f14911b.substring(0, indexOf);
        }
        while (true) {
            String m16973b2 = m16973b(bufferedInputStream);
            if (m16973b2 == null || m16973b2.length() == 0) {
                break;
            }
            int indexOf2 = m16973b2.indexOf(58);
            if (indexOf2 > 0) {
                bVar.f14913d.put(m16973b2.substring(0, indexOf2).trim().toLowerCase(Locale.f10688US), m16973b2.substring(indexOf2 + 1).trim());
            }
        }
        String str = bVar.f14913d.get("content-length");
        if (str != null) {
            try {
                bVar.f14912c = Long.parseLong(str);
            } catch (NumberFormatException e2) {
            }
        }
        return bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return r0.toString("UTF-8");
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String m16973b(BufferedInputStream bufferedInputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = bufferedInputStream.read();
            if (read == -1) {
                if (byteArrayOutputStream.size() == 0) {
                    return (String) null;
                }
            } else {
                if (read == 10) {
                    break;
                }
                if (read != 13) {
                    byteArrayOutputStream.write(read);
                }
            }
        }
    }

    /* renamed from: a */
    private void m16956a(OutputStream outputStream, File file, String str) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            m16974b(outputStream, 403, "Cannot read directory");
            return;
        }
        ArrayList<File> arrayList = new ArrayList();
        Collections.addAll(arrayList, listFiles);
        Collections.sort(arrayList, new Comparator<File>(this) { // from class: ru.maximoff.apktool.c.a.4

            /* renamed from: a */
            private final C2896a f14906a;

            {
                this.f14906a = this;
            }

            @Override // java.util.Comparator
            public int compare(File file2, File file3) {
                return m17005a(file2, file3);
            }

            /* renamed from: a */
            public int m17005a(File file2, File file3) {
                if (file2.isDirectory() && !file3.isDirectory()) {
                    return -1;
                }
                if (!file2.isDirectory() && file3.isDirectory()) {
                    return 1;
                }
                return file2.getName().compareToIgnoreCase(file3.getName());
            }
        });
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>");
        sb.append("<html><head>");
        sb.append("<meta charset=\"UTF-8\">");
        sb.append("<meta name=\"viewport\" content=\"width=device-width\">");
        sb.append("<meta name=\"generator\" content=\"Apktool M\">");
        sb.append("<title>");
        sb.append(m16996j(m16994h(str)));
        sb.append("</title>");
        sb.append("<style>");
        sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("body{").append("font-family:sans-serif;").toString()).append("margin:0;").toString()).append("padding:16px;").toString()).append("background:#fafafa;").toString()).append("color:#222;").toString()).append("}").toString());
        sb.append(new StringBuffer().append(new StringBuffer().append("h2{").append("font-size:20px;").toString()).append("}").toString());
        sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("a{").append("display:block;").toString()).append("padding:10px 8px;").toString()).append("border-bottom:1px solid #ddd;").toString()).append("text-decoration:none;").toString()).append("color:#1565c0;").toString()).append("}").toString());
        sb.append(new StringBuffer().append(new StringBuffer().append(".dir{").append("font-weight:bold;").toString()).append("}").toString());
        sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(".name{").append("display:block;").toString()).append("overflow-wrap:anywhere;").toString()).append("word-break:break-word;").toString()).append("}").toString());
        sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(".meta{").append("display:block;").toString()).append("margin-top:3px;").toString()).append("font-size:12px;").toString()).append("font-weight:normal;").toString()).append("color:#888;").toString()).append("}").toString());
        sb.append("</style>");
        sb.append("</head><body>");
        sb.append("<h2>");
        sb.append(m16996j(m16994h(str)));
        sb.append("</h2>");
        if (!m16981c(file)) {
            sb.append("<a class=\"dir\" href=\"");
            sb.append(m16996j(m16993g(str)));
            sb.append("\">");
            sb.append("..");
            sb.append("</a>");
        }
        for (File file2 : arrayList) {
            String m16947a = m16947a(m16989f(str), file2.getName(), file2.isDirectory());
            sb.append("<a class=\"");
            sb.append(file2.isDirectory() ? "dir" : ContentResolver.SCHEME_FILE);
            sb.append("\" href=\"");
            sb.append(m16996j(m16947a));
            sb.append("\">");
            sb.append("<span class=\"name\">");
            sb.append(file2.isDirectory() ? "📁 " : "📄 ");
            sb.append(m16996j(file2.getName()));
            sb.append("</span>");
            sb.append("<span class=\"meta\">");
            if (!file2.isDirectory()) {
                sb.append(m16945a(file2.length()));
                sb.append(" · ");
            }
            sb.append(m16972b(file2.lastModified()));
            sb.append("</span>");
            sb.append("</a>");
        }
        sb.append("</body></html>");
        byte[] bytes = sb.toString().getBytes("UTF-8");
        m16953a(outputStream, 200, "OK", "text/html; charset=UTF-8", bytes.length);
        outputStream.write(bytes);
    }

    /* renamed from: e */
    private File m16986e(String str) {
        String str2;
        if (str == null) {
            return (File) null;
        }
        int indexOf = str.indexOf("://");
        if (indexOf >= 0) {
            int indexOf2 = str.indexOf(47, indexOf + 3);
            str2 = indexOf2 >= 0 ? str.substring(indexOf2) : "/";
        } else {
            str2 = str;
        }
        String decode = URLDecoder.decode(str2, "UTF-8");
        while (decode.startsWith("/")) {
            decode = decode.substring(1);
        }
        File m16970b = m16970b(new File(this.f14894b, decode));
        String path = this.f14894b.getPath();
        String path2 = m16970b.getPath();
        if (path2.equals(path) || path2.startsWith(new StringBuffer().append(path).append(File.separator).toString())) {
            return m16970b;
        }
        return (File) null;
    }

    /* renamed from: b */
    private File m16970b(File file) {
        try {
            return file.getCanonicalFile();
        } catch (IOException e2) {
            return file.getAbsoluteFile();
        }
    }

    /* renamed from: c */
    private boolean m16981c(File file) {
        return m16970b(file).equals(this.f14894b);
    }

    /* renamed from: a */
    private void m16953a(OutputStream outputStream, int i, String str, String str2, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 ");
        sb.append(i);
        sb.append(" ");
        sb.append(str);
        sb.append("\r\n");
        sb.append("Server: ");
        sb.append(this.f14893a);
        sb.append("\r\n");
        sb.append("Content-Type: ");
        sb.append(str2);
        sb.append("\r\n");
        if (j >= 0) {
            sb.append("Content-Length: ");
            sb.append(j);
            sb.append("\r\n");
        }
        sb.append("Accept-Ranges: bytes\r\n");
        sb.append("Connection: close\r\n");
        sb.append("\r\n");
        outputStream.write(sb.toString().getBytes("ISO-8859-1"));
    }

    /* renamed from: a */
    private void m16954a(OutputStream outputStream, int i, String str, String str2, long j, long j2, long j3, long j4) {
        outputStream.write(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("HTTP/1.1 ").append(i).toString()).append(" ").toString()).append(str).toString()).append("\r\n").toString()).append("Server: ").toString()).append(this.f14893a).toString()).append("\r\n").toString()).append("Content-Type: ").toString()).append(str2).toString()).append("\r\n").toString()).append("Content-Length: ").toString()).append(j).toString()).append("\r\n").toString()).append("Content-Range: bytes ").toString()).append(j2).toString()).append("-").toString()).append(j3).toString()).append("/").toString()).append(j4).toString()).append("\r\n").toString()).append("Accept-Ranges: bytes\r\n").toString()).append("Connection: close\r\n").toString()).append("\r\n").toString().getBytes("ISO-8859-1"));
    }

    /* renamed from: a */
    private void m16955a(OutputStream outputStream, long j) {
        outputStream.write(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("HTTP/1.1 416 Range Not Satisfiable\r\n").append("Server: ").toString()).append(this.f14893a).toString()).append("\r\n").toString()).append("Content-Range: bytes */").toString()).append(j).toString()).append("\r\n").toString()).append("Content-Length: 0\r\n").toString()).append("Connection: close\r\n").toString()).append("\r\n").toString().getBytes("ISO-8859-1"));
    }

    /* renamed from: a */
    private void m16952a(OutputStream outputStream, int i, String str) {
        m16953a(outputStream, i, str, "text/plain; charset=UTF-8", 0);
    }

    /* renamed from: b */
    private void m16974b(OutputStream outputStream, int i, String str) {
        byte[] bytes = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("<!DOCTYPE html><html><head>").append("<meta charset=\"UTF-8\">").toString()).append("<title>").toString()).append(i).toString()).append("</title>").toString()).append("</head><body><h2>").toString()).append(i).toString()).append(" - ").toString()).append(m16996j(str)).toString()).append("</h2></body></html>").toString().getBytes("UTF-8");
        m16953a(outputStream, i, str, "text/html; charset=UTF-8", bytes.length);
        outputStream.write(bytes);
    }

    /* renamed from: f */
    private String m16989f(String str) {
        if (str == null || str.length() == 0) {
            return "/";
        }
        if (!str.startsWith("/")) {
            str = new StringBuffer().append("/").append(str).toString();
        }
        if (!str.endsWith("/")) {
            return new StringBuffer().append(str).append("/").toString();
        }
        return str;
    }

    /* renamed from: a */
    private String m16947a(String str, String str2, boolean z) {
        if (!str.endsWith("/")) {
            str = new StringBuffer().append(str).append("/").toString();
        }
        return new StringBuffer().append(new StringBuffer().append(str).append(m16995i(str2)).toString()).append(z ? "/" : "").toString();
    }

    /* renamed from: g */
    private String m16993g(String str) {
        String substring;
        int lastIndexOf;
        String m16989f = m16989f(str);
        if ("/".equals(m16989f) || (lastIndexOf = (substring = m16989f.substring(0, m16989f.length() - 1)).lastIndexOf(47)) <= 0) {
            return "/";
        }
        return substring.substring(0, lastIndexOf + 1);
    }

    /* renamed from: h */
    private String m16994h(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Exception e2) {
            return str;
        }
    }

    /* renamed from: i */
    private String m16995i(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replace("+", "%20").replace("%2F", "/");
        } catch (Exception e2) {
            return str;
        }
    }

    /* renamed from: j */
    private String m16996j(String str) {
        return str == null ? "" : str.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#39;");
    }

    /* renamed from: k */
    private String m16997k(String str) {
        return m16996j(str);
    }

    /* renamed from: a */
    private String m16945a(long j) {
        if (j < 1024) {
            return new StringBuffer().append(j).append(" B").toString();
        }
        if (j < 1048576) {
            return new StringBuffer().append(m16944a(j / 1024.0d)).append(" KB").toString();
        }
        if (j < 1073741824) {
            return new StringBuffer().append(m16944a(j / 1048576.0d)).append(" MB").toString();
        }
        return new StringBuffer().append(m16944a(j / 1.073741824E9d)).append(" GB").toString();
    }

    /* renamed from: a */
    private String m16944a(double d2) {
        return d2 == ((double) ((long) d2)) ? String.valueOf((long) d2) : String.format(Locale.f10688US, "%.2f", new Double(d2)).replaceAll("0+$", "").replaceAll("\\.$", "");
    }

    /* renamed from: b */
    private String m16972b(long j) {
        return new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault()).format(new Date(j));
    }

    /* renamed from: d */
    private String m16982d(File file) {
        return new StringBuffer().append(new StringBuffer().append(Long.toHexString(file.length())).append("-").toString()).append(Long.toHexString(file.lastModified())).toString();
    }

    /* renamed from: c */
    private String m16977c(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.f10688US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(new Date(j));
    }

    /* renamed from: l */
    private String m16998l(String str) {
        String lowerCase = str.toLowerCase(Locale.f10688US);
        if (lowerCase.endsWith(".html") || lowerCase.endsWith(".htm")) {
            return ClipDescription.MIMETYPE_TEXT_HTML;
        }
        if (lowerCase.endsWith(".txt")) {
            return ClipDescription.MIMETYPE_TEXT_PLAIN;
        }
        if (lowerCase.endsWith(".xml")) {
            return "application/xml";
        }
        if (lowerCase.endsWith(".json")) {
            return "application/json";
        }
        if (lowerCase.endsWith(".jpg") || lowerCase.endsWith(".jpeg")) {
            return "image/jpeg";
        }
        if (lowerCase.endsWith(".png")) {
            return "image/png";
        }
        if (lowerCase.endsWith(".gif")) {
            return "image/gif";
        }
        if (lowerCase.endsWith(".webp")) {
            return "image/webp";
        }
        if (lowerCase.endsWith(".svg")) {
            return "image/svg+xml";
        }
        if (lowerCase.endsWith(".pdf")) {
            return "application/pdf";
        }
        if (lowerCase.endsWith(".zip")) {
            return "application/zip";
        }
        if (lowerCase.endsWith(".apk")) {
            return "application/vnd.android.package-archive";
        }
        if (lowerCase.endsWith(".mp3")) {
            return MediaFormat.MIMETYPE_AUDIO_MPEG;
        }
        if (lowerCase.endsWith(".mp4")) {
            return "video/mp4";
        }
        return "application/octet-stream";
    }

    /* renamed from: g */
    private String m16992g() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement.isUp() && !nextElement.isLoopback()) {
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        if ((nextElement2 instanceof Inet4Address) && !nextElement2.isLoopbackAddress()) {
                            return nextElement2.getHostAddress();
                        }
                    }
                }
            }
        } catch (Exception e2) {
        }
        return "127.0.0.1";
    }

    /* renamed from: a */
    private void m16958a(Exception exc) {
        c cVar = this.f14896d;
        if (cVar != null) {
            cVar.mo17007a(exc);
        }
    }

    /* renamed from: b */
    public synchronized void m17002b() {
        if (this.f14897e || this.f14898f != null) {
            this.f14897e = false;
            try {
                if (this.f14898f != null) {
                    this.f14898f.close();
                }
            } catch (IOException e2) {
            }
            this.f14898f = (ServerSocket) null;
        }
    }

    /* renamed from: c */
    public boolean m17003c() {
        return this.f14897e;
    }

    /* compiled from: LocalFileServer.java */
    /* renamed from: ru.maximoff.apktool.c.a$a */
    private static class a {

        /* renamed from: a */
        final String f14907a;

        /* renamed from: b */
        final File f14908b;

        /* renamed from: c */
        volatile long f14909c;

        a(String str, File file, long j) {
            this.f14907a = str;
            this.f14908b = file;
            this.f14909c = j;
        }
    }
}
