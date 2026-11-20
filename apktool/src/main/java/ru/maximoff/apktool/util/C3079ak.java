package ru.maximoff.apktool.util;

import android.content.Context;
import android.security.keystore.KeyProperties;
import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.p209io.DataInputStream;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.p209io.FileOutputStream;
import java.security.MessageDigest;
import java.util.zip.CRC32;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: MTKey.java */
/* renamed from: ru.maximoff.apktool.util.ak */
/* loaded from: classes.dex */
public class C3079ak {

    /* renamed from: a */
    private static byte[] f17662a;

    /* renamed from: b */
    private static byte[] f17663b;

    /* renamed from: a */
    public static boolean m18510a(String str) {
        boolean z = false;
        CRC32 crc32 = new CRC32();
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(str));
        try {
            if (dataInputStream.readInt() == -1395514453) {
                f17662a = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(f17662a);
                crc32.update(f17662a);
                f17663b = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(f17663b);
                crc32.update(f17663b);
                if (crc32.getValue() == dataInputStream.readLong()) {
                    z = true;
                }
            }
            return z;
        } finally {
            dataInputStream.close();
        }
    }

    /* renamed from: a */
    public static boolean m18511a(String str, String str2) {
        boolean z = false;
        CRC32 crc32 = new CRC32();
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(str));
        try {
            if (dataInputStream.readInt() == -1395514454) {
                byte[] bArr = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(bArr);
                f17662a = m18513a(str2, bArr);
                crc32.update(f17662a);
                byte[] bArr2 = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(bArr2);
                f17663b = m18513a(str2, bArr2);
                crc32.update(f17663b);
                if (crc32.getValue() == dataInputStream.readLong()) {
                    z = true;
                }
            }
            return z;
        } finally {
            dataInputStream.close();
        }
    }

    /* renamed from: a */
    public static File m18509a(Context context, File file, String str, String str2) {
        boolean m18511a;
        String absolutePath = file.getAbsolutePath();
        if (str2 == null) {
            m18511a = m18510a(absolutePath);
        } else {
            m18511a = m18511a(absolutePath, str2);
        }
        if (!m18511a) {
            throw new Exception(new StringBuffer().append("Failed to load ").append(absolutePath).toString());
        }
        File m18514b = m18514b(context, file, str, ".pk8");
        File m18514b2 = m18514b(context, file, str, ".x509.pem");
        if (m18514b == null || m18514b2 == null) {
            throw new Exception("Failed to create files!");
        }
        FileOutputStream fileOutputStream = new FileOutputStream(m18514b);
        fileOutputStream.write(f17663b);
        fileOutputStream.flush();
        fileOutputStream.close();
        FileOutputStream fileOutputStream2 = new FileOutputStream(m18514b2);
        fileOutputStream2.write("-----BEGIN CERTIFICATE-----\n".getBytes(StandardCharsets.UTF_8));
        if (m18512a(f17662a)) {
            fileOutputStream2.write(m18518c(f17662a));
        } else {
            fileOutputStream2.write(m18516b(f17662a));
        }
        fileOutputStream2.write("-----END CERTIFICATE-----\n".getBytes(StandardCharsets.UTF_8));
        fileOutputStream2.flush();
        fileOutputStream2.close();
        return m18514b.getParentFile();
    }

    /* renamed from: a */
    public static byte[] m18513a(String str, byte[] bArr) {
        MessageDigest messageDigest = MessageDigest.getInstance(KeyProperties.DIGEST_MD5);
        messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
        byte[] digest = messageDigest.digest();
        messageDigest.update(digest, 0, 16);
        byte[] digest2 = messageDigest.digest();
        SecretKeySpec secretKeySpec = new SecretKeySpec(digest, KeyProperties.KEY_ALGORITHM_AES);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(digest2));
        return cipher.doFinal(bArr);
    }

    /* renamed from: a */
    private static boolean m18512a(byte[] bArr) {
        for (int i = 0; i < 5; i++) {
            if (bArr[i] != 45) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private static byte[] m18516b(byte[] bArr) {
        String replaceAll = Base64.encodeToString(bArr, 2).replaceAll("(.{64})", "$1\n");
        if (!replaceAll.endsWith("\n")) {
            replaceAll = new StringBuffer().append(replaceAll).append("\n").toString();
        }
        return replaceAll.getBytes(StandardCharsets.UTF_8);
    }

    /* renamed from: c */
    private static byte[] m18518c(byte[] bArr) {
        String replaceAll = new String(bArr, StandardCharsets.UTF_8).split("\n")[1].replaceAll("(.{64})", "$1\n");
        if (!replaceAll.endsWith("\n")) {
            replaceAll = new StringBuffer().append(replaceAll).append("\n").toString();
        }
        return replaceAll.getBytes(StandardCharsets.UTF_8);
    }

    /* renamed from: b */
    private static File m18514b(Context context, File file, String str, String str2) {
        String parent = file.getParent();
        if ((!C3262u.m19664g(context, file)) || C3102bd.m18925a(context, "all_to_out_dir", false)) {
            parent = C3102bd.f18339v;
            if (parent == null) {
                return (File) null;
            }
            File file2 = new File(parent);
            if (!file2.exists() && !file2.mkdirs()) {
                return (File) null;
            }
            if (!file2.isDirectory()) {
                return (File) null;
            }
        }
        if (str == null) {
            str = file.getName();
        }
        return new File(parent, C3262u.m19566a(context, parent, str, str2, 0));
    }

    /* renamed from: b */
    public static boolean m18515b(String str) {
        try {
            if (!m18517c(str)) {
                if (!m18519d(str)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m18517c(String str) {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(str));
        try {
            return dataInputStream.readInt() == -1395514453;
        } finally {
            dataInputStream.close();
        }
    }

    /* renamed from: d */
    public static boolean m18519d(String str) {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(str));
        try {
            return dataInputStream.readInt() == -1395514454;
        } finally {
            dataInputStream.close();
        }
    }
}
