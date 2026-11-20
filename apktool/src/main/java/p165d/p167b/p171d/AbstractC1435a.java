package p165d.p167b.p171d;

import java.p209io.ByteArrayInputStream;
import java.p209io.DataInputStream;
import java.p209io.DataOutputStream;
import java.p209io.IOException;
import java.p209io.InputStream;
import java.p209io.OutputStream;
import java.security.DigestInputStream;
import java.security.DigestOutputStream;
import java.security.Key;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import p165d.p167b.p169b.C1425c;

/* compiled from: JavaKeyStore.java */
/* renamed from: d.b.d.a */
/* loaded from: classes.dex */
abstract class AbstractC1435a extends KeyStoreSpi {

    /* renamed from: a */
    private final Hashtable<String, Object> f9312a = new Hashtable<>();

    /* renamed from: a */
    abstract String mo11308a(String str);

    /* compiled from: JavaKeyStore.java */
    /* renamed from: d.b.d.a$b */
    public static final class b extends AbstractC1435a {
        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Enumeration engineAliases() {
            return super.engineAliases();
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineContainsAlias(String str) {
            return super.engineContainsAlias(str);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineDeleteEntry(String str) {
            super.engineDeleteEntry(str);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Certificate engineGetCertificate(String str) {
            return super.engineGetCertificate(str);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ String engineGetCertificateAlias(Certificate certificate) {
            return super.engineGetCertificateAlias(certificate);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Certificate[] engineGetCertificateChain(String str) {
            return super.engineGetCertificateChain(str);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Date engineGetCreationDate(String str) {
            return super.engineGetCreationDate(str);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Key engineGetKey(String str, char[] cArr) {
            return super.engineGetKey(str, cArr);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineIsCertificateEntry(String str) {
            return super.engineIsCertificateEntry(str);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineIsKeyEntry(String str) {
            return super.engineIsKeyEntry(str);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineLoad(InputStream inputStream, char[] cArr) {
            super.engineLoad(inputStream, cArr);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetCertificateEntry(String str, Certificate certificate) {
            super.engineSetCertificateEntry(str, certificate);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) {
            super.engineSetKeyEntry(str, key, cArr, certificateArr);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) {
            super.engineSetKeyEntry(str, bArr, certificateArr);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ int engineSize() {
            return super.engineSize();
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineStore(OutputStream outputStream, char[] cArr) {
            super.engineStore(outputStream, cArr);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a
        /* renamed from: a */
        String mo11308a(String str) {
            return str.toLowerCase();
        }
    }

    /* compiled from: JavaKeyStore.java */
    /* renamed from: d.b.d.a$a */
    public static final class a extends AbstractC1435a {
        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Enumeration engineAliases() {
            return super.engineAliases();
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineContainsAlias(String str) {
            return super.engineContainsAlias(str);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineDeleteEntry(String str) {
            super.engineDeleteEntry(str);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Certificate engineGetCertificate(String str) {
            return super.engineGetCertificate(str);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ String engineGetCertificateAlias(Certificate certificate) {
            return super.engineGetCertificateAlias(certificate);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Certificate[] engineGetCertificateChain(String str) {
            return super.engineGetCertificateChain(str);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Date engineGetCreationDate(String str) {
            return super.engineGetCreationDate(str);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Key engineGetKey(String str, char[] cArr) {
            return super.engineGetKey(str, cArr);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineIsCertificateEntry(String str) {
            return super.engineIsCertificateEntry(str);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineIsKeyEntry(String str) {
            return super.engineIsKeyEntry(str);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineLoad(InputStream inputStream, char[] cArr) {
            super.engineLoad(inputStream, cArr);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetCertificateEntry(String str, Certificate certificate) {
            super.engineSetCertificateEntry(str, certificate);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) {
            super.engineSetKeyEntry(str, key, cArr, certificateArr);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) {
            super.engineSetKeyEntry(str, bArr, certificateArr);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ int engineSize() {
            return super.engineSize();
        }

        @Override // p165d.p167b.p171d.AbstractC1435a, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineStore(OutputStream outputStream, char[] cArr) {
            super.engineStore(outputStream, cArr);
        }

        @Override // p165d.p167b.p171d.AbstractC1435a
        /* renamed from: a */
        String mo11308a(String str) {
            return str;
        }
    }

    /* compiled from: JavaKeyStore.java */
    /* renamed from: d.b.d.a$c */
    private static class c {

        /* renamed from: a */
        Certificate[] f9313a;

        /* renamed from: b */
        Date f9314b;

        /* renamed from: c */
        byte[] f9315c;

        private c() {
        }

        /* synthetic */ c(c cVar) {
            this();
        }
    }

    /* compiled from: JavaKeyStore.java */
    /* renamed from: d.b.d.a$d */
    private static class d {

        /* renamed from: a */
        Certificate f9316a;

        /* renamed from: b */
        Date f9317b;

        private d() {
        }

        /* synthetic */ d(d dVar) {
            this();
        }
    }

    AbstractC1435a() {
    }

    @Override // java.security.KeyStoreSpi
    public Key engineGetKey(String str, char[] cArr) {
        Object obj = this.f9312a.get(mo11308a(str));
        if (obj == null || !(obj instanceof c)) {
            return null;
        }
        if (cArr == null) {
            throw new UnrecoverableKeyException("Password must not be null");
        }
        try {
            return new C1437c(cArr).m11309a(new C1425c(((c) obj).f9315c));
        } catch (IOException e2) {
            throw new UnrecoverableKeyException("Private key not stored as PKCS #8 EncryptedPrivateKeyInfo");
        }
    }

    @Override // java.security.KeyStoreSpi
    public Certificate[] engineGetCertificateChain(String str) {
        Object obj = this.f9312a.get(mo11308a(str));
        if (obj == null || !(obj instanceof c)) {
            return null;
        }
        if (((c) obj).f9313a == null) {
            return null;
        }
        return (Certificate[]) ((c) obj).f9313a.clone();
    }

    @Override // java.security.KeyStoreSpi
    public Certificate engineGetCertificate(String str) {
        Object obj = this.f9312a.get(mo11308a(str));
        if (obj == null) {
            return null;
        }
        if (obj instanceof d) {
            return ((d) obj).f9316a;
        }
        if (((c) obj).f9313a == null) {
            return null;
        }
        return ((c) obj).f9313a[0];
    }

    @Override // java.security.KeyStoreSpi
    public Date engineGetCreationDate(String str) {
        Object obj = this.f9312a.get(mo11308a(str));
        if (obj != null) {
            if (obj instanceof d) {
                return new Date(((d) obj).f9317b.getTime());
            }
            return new Date(((c) obj).f9314b.getTime());
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) {
        c cVar;
        if (!(key instanceof PrivateKey)) {
            throw new KeyStoreException("Cannot store non-PrivateKeys");
        }
        try {
            synchronized (this.f9312a) {
                try {
                    cVar = new c(null);
                    cVar.f9314b = new Date();
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    cVar.f9315c = new C1437c(cArr).m11310a(key);
                    if (certificateArr == null || certificateArr.length == 0) {
                        cVar.f9313a = null;
                    } else {
                        cVar.f9313a = (Certificate[]) certificateArr.clone();
                    }
                    this.f9312a.put(mo11308a(str), cVar);
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
        } catch (NoSuchAlgorithmException e2) {
            throw new KeyStoreException("Key protection algorithm not found");
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) {
        synchronized (this.f9312a) {
            try {
                new C1425c(bArr);
                c cVar = new c(null);
                cVar.f9314b = new Date();
                cVar.f9315c = (byte[]) bArr.clone();
                if (certificateArr != null && certificateArr.length != 0) {
                    cVar.f9313a = (Certificate[]) certificateArr.clone();
                } else {
                    cVar.f9313a = null;
                }
                this.f9312a.put(mo11308a(str), cVar);
            } catch (IOException e2) {
                throw new KeyStoreException("key is not encoded as EncryptedPrivateKeyInfo");
            }
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetCertificateEntry(String str, Certificate certificate) {
        synchronized (this.f9312a) {
            Object obj = this.f9312a.get(mo11308a(str));
            if (obj != null && (obj instanceof c)) {
                throw new KeyStoreException("Cannot overwrite own certificate");
            }
            d dVar = new d(null);
            dVar.f9316a = certificate;
            dVar.f9317b = new Date();
            this.f9312a.put(mo11308a(str), dVar);
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineDeleteEntry(String str) {
        synchronized (this.f9312a) {
            this.f9312a.remove(mo11308a(str));
        }
    }

    @Override // java.security.KeyStoreSpi
    public Enumeration<String> engineAliases() {
        return this.f9312a.keys();
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineContainsAlias(String str) {
        return this.f9312a.containsKey(mo11308a(str));
    }

    @Override // java.security.KeyStoreSpi
    public int engineSize() {
        return this.f9312a.size();
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsKeyEntry(String str) {
        Object obj = this.f9312a.get(mo11308a(str));
        return obj != null && (obj instanceof c);
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsCertificateEntry(String str) {
        Object obj = this.f9312a.get(mo11308a(str));
        return obj != null && (obj instanceof d);
    }

    @Override // java.security.KeyStoreSpi
    public String engineGetCertificateAlias(Certificate certificate) {
        Certificate certificate2;
        Enumeration<String> keys = this.f9312a.keys();
        while (keys.hasMoreElements()) {
            String nextElement = keys.nextElement();
            Object obj = this.f9312a.get(nextElement);
            if (obj instanceof d) {
                certificate2 = ((d) obj).f9316a;
            } else if (((c) obj).f9313a != null) {
                certificate2 = ((c) obj).f9313a[0];
            } else {
                continue;
            }
            if (certificate2.equals(certificate)) {
                return nextElement;
            }
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(OutputStream outputStream, char[] cArr) {
        synchronized (this.f9312a) {
            if (cArr == null) {
                throw new IllegalArgumentException("password can't be null");
            }
            MessageDigest m11307a = m11307a(cArr);
            DataOutputStream dataOutputStream = new DataOutputStream(new DigestOutputStream(outputStream, m11307a));
            dataOutputStream.writeInt(-17957139);
            dataOutputStream.writeInt(2);
            dataOutputStream.writeInt(this.f9312a.size());
            Enumeration<String> keys = this.f9312a.keys();
            while (keys.hasMoreElements()) {
                String nextElement = keys.nextElement();
                Object obj = this.f9312a.get(nextElement);
                if (obj instanceof c) {
                    dataOutputStream.writeInt(1);
                    dataOutputStream.writeUTF(nextElement);
                    dataOutputStream.writeLong(((c) obj).f9314b.getTime());
                    dataOutputStream.writeInt(((c) obj).f9315c.length);
                    dataOutputStream.write(((c) obj).f9315c);
                    int length = ((c) obj).f9313a == null ? 0 : ((c) obj).f9313a.length;
                    dataOutputStream.writeInt(length);
                    for (int i = 0; i < length; i++) {
                        byte[] encoded = ((c) obj).f9313a[i].getEncoded();
                        dataOutputStream.writeUTF(((c) obj).f9313a[i].getType());
                        dataOutputStream.writeInt(encoded.length);
                        dataOutputStream.write(encoded);
                    }
                } else {
                    dataOutputStream.writeInt(2);
                    dataOutputStream.writeUTF(nextElement);
                    dataOutputStream.writeLong(((d) obj).f9317b.getTime());
                    byte[] encoded2 = ((d) obj).f9316a.getEncoded();
                    dataOutputStream.writeUTF(((d) obj).f9316a.getType());
                    dataOutputStream.writeInt(encoded2.length);
                    dataOutputStream.write(encoded2);
                }
            }
            dataOutputStream.write(m11307a.digest());
            dataOutputStream.flush();
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineLoad(InputStream inputStream, char[] cArr) {
        DataInputStream dataInputStream;
        MessageDigest messageDigest;
        Hashtable hashtable;
        synchronized (this.f9312a) {
            CertificateFactory certificateFactory = null;
            try {
                if (inputStream != null) {
                    if (cArr != null) {
                        MessageDigest m11307a = m11307a(cArr);
                        dataInputStream = new DataInputStream(new DigestInputStream(inputStream, m11307a));
                        messageDigest = m11307a;
                    } else {
                        dataInputStream = new DataInputStream(inputStream);
                        messageDigest = null;
                    }
                    int readInt = dataInputStream.readInt();
                    int readInt2 = dataInputStream.readInt();
                    if (readInt != -17957139 || (readInt2 != 1 && readInt2 != 2)) {
                        throw new IOException("Invalid keystore format");
                    }
                    if (readInt2 == 1) {
                        certificateFactory = CertificateFactory.getInstance("X509");
                        hashtable = null;
                    } else {
                        hashtable = new Hashtable(3);
                    }
                    this.f9312a.clear();
                    int readInt3 = dataInputStream.readInt();
                    for (int i = 0; i < readInt3; i++) {
                        try {
                            int readInt4 = dataInputStream.readInt();
                            if (readInt4 == 1) {
                                c cVar = new c(null);
                                String readUTF = dataInputStream.readUTF();
                                cVar.f9314b = new Date(dataInputStream.readLong());
                                try {
                                    cVar.f9315c = new byte[dataInputStream.readInt()];
                                    dataInputStream.readFully(cVar.f9315c);
                                    int readInt5 = dataInputStream.readInt();
                                    if (readInt5 > 0) {
                                        try {
                                            cVar.f9313a = new Certificate[readInt5];
                                        } catch (OutOfMemoryError e2) {
                                            throw new IOException("Too many certificates in chain");
                                        }
                                    }
                                    for (int i2 = 0; i2 < readInt5; i2++) {
                                        if (readInt2 == 2) {
                                            String readUTF2 = dataInputStream.readUTF();
                                            if (hashtable.containsKey(readUTF2)) {
                                                certificateFactory = (CertificateFactory) hashtable.get(readUTF2);
                                            } else {
                                                certificateFactory = CertificateFactory.getInstance(readUTF2);
                                                hashtable.put(readUTF2, certificateFactory);
                                            }
                                        }
                                        try {
                                            byte[] bArr = new byte[dataInputStream.readInt()];
                                            dataInputStream.readFully(bArr);
                                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                                            cVar.f9313a[i2] = certificateFactory.generateCertificate(byteArrayInputStream);
                                            byteArrayInputStream.close();
                                        } catch (OutOfMemoryError e3) {
                                            throw new IOException("Certificate too big");
                                        }
                                    }
                                    this.f9312a.put(readUTF, cVar);
                                } catch (OutOfMemoryError e4) {
                                    throw new IOException("Keysize too big");
                                }
                            } else if (readInt4 == 2) {
                                d dVar = new d(null);
                                String readUTF3 = dataInputStream.readUTF();
                                dVar.f9317b = new Date(dataInputStream.readLong());
                                if (readInt2 == 2) {
                                    String readUTF4 = dataInputStream.readUTF();
                                    if (hashtable.containsKey(readUTF4)) {
                                        certificateFactory = (CertificateFactory) hashtable.get(readUTF4);
                                    } else {
                                        certificateFactory = CertificateFactory.getInstance(readUTF4);
                                        hashtable.put(readUTF4, certificateFactory);
                                    }
                                }
                                try {
                                    byte[] bArr2 = new byte[dataInputStream.readInt()];
                                    dataInputStream.readFully(bArr2);
                                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr2);
                                    dVar.f9316a = certificateFactory.generateCertificate(byteArrayInputStream2);
                                    byteArrayInputStream2.close();
                                    this.f9312a.put(readUTF3, dVar);
                                } catch (OutOfMemoryError e5) {
                                    throw new IOException("Certificate too big");
                                }
                            } else {
                                throw new IOException("Unrecognized keystore entry");
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                    if (cArr != null) {
                        byte[] digest = messageDigest.digest();
                        byte[] bArr3 = new byte[digest.length];
                        dataInputStream.readFully(bArr3);
                        for (int i3 = 0; i3 < digest.length; i3++) {
                            if (digest[i3] != bArr3[i3]) {
                                throw ((IOException) new IOException("Keystore was tampered with, or password was incorrect").initCause(new UnrecoverableKeyException("Password verification failed")));
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* renamed from: a */
    private MessageDigest m11307a(char[] cArr) {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA");
        byte[] bArr = new byte[cArr.length * 2];
        int i = 0;
        for (int i2 = 0; i2 < cArr.length; i2++) {
            int i3 = i + 1;
            bArr[i] = (byte) (cArr[i2] >> '\b');
            i = i3 + 1;
            bArr[i3] = (byte) cArr[i2];
        }
        messageDigest.update(bArr);
        for (int i4 = 0; i4 < bArr.length; i4++) {
            bArr[i4] = 0;
        }
        messageDigest.update("Mighty Aphrodite".getBytes("UTF8"));
        return messageDigest;
    }
}
