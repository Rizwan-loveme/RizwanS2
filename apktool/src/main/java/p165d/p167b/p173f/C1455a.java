package p165d.p167b.p173f;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.security.AccessController;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import p165d.p167b.p168a.C1421a;
import p165d.p167b.p169b.C1428f;
import p165d.p167b.p172e.C1444g;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p172e.C1454q;
import p165d.p167b.p172e.InterfaceC1445h;
import ru.maximoff.apktool.util.C3112bn;

/* compiled from: AVA.java */
/* renamed from: d.b.f.a */
/* loaded from: classes.dex */
public class C1455a implements InterfaceC1445h {

    /* renamed from: a */
    final C1454q f9382a;

    /* renamed from: b */
    final C1450m f9383b;

    /* renamed from: d */
    private static final C1444g f9381d = C1444g.m11328a("x509", "\t[AVA]");

    /* renamed from: c */
    private static final boolean f9380c = ((Boolean) AccessController.doPrivileged(new C1421a("com.sun.security.preserveOldDCEncoding"))).booleanValue();

    public C1455a(C1454q c1454q, C1450m c1450m) {
        if (c1454q == null || c1450m == null) {
            throw new NullPointerException();
        }
        this.f9382a = c1454q;
        this.f9383b = c1450m;
    }

    C1455a(Reader reader, Map<String, String> map) {
        this(reader, 1, map);
    }

    C1455a(Reader reader, int i, Map<String, String> map) {
        int read;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int m11459a = m11459a(reader, "Incorrect AVA format");
            if (m11459a == 61) {
                break;
            } else {
                sb.append((char) m11459a);
            }
        }
        this.f9382a = C1503c.m11622a(sb.toString(), i, map);
        sb.setLength(0);
        if (i != 3) {
            while (true) {
                read = reader.read();
                if (read != 32 && read != 10) {
                    break;
                }
            }
        } else {
            read = reader.read();
            if (read == 32) {
                throw new IOException("Incorrect AVA RFC2253 format - leading space must be escaped");
            }
        }
        if (read == -1) {
            this.f9383b = new C1450m("");
            return;
        }
        if (read == 35) {
            this.f9383b = m11460a(reader, i);
        } else if (read == 34 && i != 3) {
            this.f9383b = m11462a(reader, sb);
        } else {
            this.f9383b = m11461a(reader, read, i, sb);
        }
    }

    /* renamed from: a */
    private static C1450m m11460a(Reader reader, int i) {
        byte b2 = 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (true) {
            byte b3 = b2;
            int read = reader.read();
            if (!m11467a(read, i)) {
                int indexOf = C3112bn.f18384b.indexOf(Character.toUpperCase((char) read));
                if (indexOf == -1) {
                    throw new IOException("AVA parse, invalid hex digit: " + ((char) read));
                }
                if (i2 % 2 == 1) {
                    b2 = (byte) ((b3 * 16) + ((byte) indexOf));
                    byteArrayOutputStream.write(b2);
                } else {
                    b2 = (byte) indexOf;
                }
                i2++;
            } else {
                if (i2 == 0) {
                    throw new IOException("AVA parse, zero hex digits");
                }
                if (i2 % 2 == 1) {
                    throw new IOException("AVA parse, odd number of hex digits");
                }
                return new C1450m(byteArrayOutputStream.toByteArray());
            }
        }
    }

    /* renamed from: a */
    private C1450m m11462a(Reader reader, StringBuilder sb) {
        int read;
        int m11459a = m11459a(reader, "Quoted string did not end in quote");
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        while (m11459a != 34) {
            if (m11459a == 92) {
                m11459a = m11459a(reader, "Quoted string did not end in quote");
                Byte m11463a = m11463a(m11459a, reader);
                if (m11463a != null) {
                    z = false;
                    arrayList.add(m11463a);
                    m11459a = reader.read();
                } else if (m11459a != 92 && m11459a != 34 && ",+=\n<>#;".indexOf((char) m11459a) < 0) {
                    throw new IOException("Invalid escaped character in AVA: " + ((char) m11459a));
                }
            }
            if (arrayList.size() > 0) {
                sb.append(m11466a(arrayList));
                arrayList.clear();
            }
            z &= C1450m.m11411a((char) m11459a);
            sb.append((char) m11459a);
            m11459a = m11459a(reader, "Quoted string did not end in quote");
        }
        if (arrayList.size() > 0) {
            sb.append(m11466a(arrayList));
            arrayList.clear();
        }
        while (true) {
            read = reader.read();
            if (read != 10 && read != 32) {
                break;
            }
        }
        if (read != -1) {
            throw new IOException("AVA had characters other than whitespace after terminating quote");
        }
        if (this.f9382a.equals(C1428f.f9237d) || (this.f9382a.equals(C1496bn.f9541b) && !f9380c)) {
            return new C1450m((byte) 22, sb.toString().trim());
        }
        if (z) {
            return new C1450m(sb.toString().trim());
        }
        return new C1450m((byte) 12, sb.toString().trim());
    }

    /* renamed from: a */
    private C1450m m11461a(Reader reader, int i, int i2, StringBuilder sb) {
        int i3;
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        boolean z2 = true;
        int i4 = 0;
        int i5 = i;
        do {
            boolean z3 = z2;
            boolean z4 = z;
            boolean z5 = false;
            if (i5 == 92) {
                z5 = true;
                i5 = m11459a(reader, "Invalid trailing backslash");
                Byte m11463a = m11463a(i5, reader);
                if (m11463a != null) {
                    z = false;
                    arrayList.add(m11463a);
                    i5 = reader.read();
                    z2 = false;
                } else {
                    if ((i2 == 1 && ",=\n+<>#;\\\" ".indexOf((char) i5) == -1) || (i2 == 2 && ",+=\n<>#;".indexOf((char) i5) == -1 && i5 != 92 && i5 != 34)) {
                        throw new IOException("Invalid escaped character in AVA: '" + ((char) i5) + "'");
                    }
                    if (i2 == 3) {
                        if (i5 == 32) {
                            if (!z3 && !m11469a(reader)) {
                                throw new IOException("Invalid escaped space character in AVA.  Only a leading or trailing space character can be escaped.");
                            }
                        } else if (i5 == 35) {
                            if (!z3) {
                                throw new IOException("Invalid escaped '#' character in AVA.  Only a leading '#' can be escaped.");
                            }
                        } else if (",+\"\\<>;".indexOf((char) i5) == -1) {
                            throw new IOException("Invalid escaped character in AVA: '" + ((char) i5) + "'");
                        }
                    }
                }
            } else if (i2 == 3 && ",+\"\\<>;".indexOf((char) i5) != -1) {
                throw new IOException("Character '" + ((char) i5) + "' in AVA appears without escape");
            }
            if (arrayList.size() > 0) {
                for (int i6 = 0; i6 < i4; i6++) {
                    sb.append(" ");
                }
                i4 = 0;
                sb.append(m11466a(arrayList));
                arrayList.clear();
            }
            z = C1450m.m11411a((char) i5) & z4;
            if (i5 == 32 && !z5) {
                i3 = i4 + 1;
            } else {
                for (int i7 = 0; i7 < i4; i7++) {
                    sb.append(" ");
                }
                i3 = 0;
                sb.append((char) i5);
            }
            i5 = reader.read();
            i4 = i3;
            z2 = false;
        } while (!m11467a(i5, i2));
        if (i2 == 3 && i4 > 0) {
            throw new IOException("Incorrect AVA RFC2253 format - trailing space must be escaped");
        }
        if (arrayList.size() > 0) {
            sb.append(m11466a(arrayList));
            arrayList.clear();
        }
        if (this.f9382a.equals(C1428f.f9237d) || (this.f9382a.equals(C1496bn.f9541b) && !f9380c)) {
            return new C1450m((byte) 22, sb.toString());
        }
        if (z) {
            return new C1450m(sb.toString());
        }
        return new C1450m((byte) 12, sb.toString());
    }

    /* renamed from: a */
    private static Byte m11463a(int i, Reader reader) {
        if (C3112bn.f18384b.indexOf(Character.toUpperCase((char) i)) >= 0) {
            int m11459a = m11459a(reader, "unexpected EOF - escaped hex value must include two valid digits");
            if (C3112bn.f18384b.indexOf(Character.toUpperCase((char) m11459a)) >= 0) {
                return new Byte((byte) ((Character.digit((char) i, 16) << 4) + Character.digit((char) m11459a, 16)));
            }
            throw new IOException("escaped hex value must include two valid digits");
        }
        return null;
    }

    /* renamed from: a */
    private static String m11466a(List<Byte> list) {
        int size = list.size();
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            bArr[i] = list.get(i).byteValue();
        }
        return new String(bArr, "UTF8");
    }

    /* renamed from: a */
    private static boolean m11467a(int i, int i2) {
        switch (i) {
            case -1:
            case 43:
            case 44:
                break;
            case 59:
            case 62:
                if (i2 == 3) {
                    return false;
                }
                break;
            default:
                return false;
        }
        return true;
    }

    /* renamed from: a */
    private static int m11459a(Reader reader, String str) {
        int read = reader.read();
        if (read == -1) {
            throw new IOException(str);
        }
        return read;
    }

    /* renamed from: a */
    private static boolean m11469a(Reader reader) {
        boolean z = true;
        if (reader.markSupported()) {
            reader.mark(9999);
            while (true) {
                int read = reader.read();
                if (read == -1) {
                    break;
                }
                if (read != 32) {
                    if (read != 92) {
                        z = false;
                        break;
                    }
                    if (reader.read() != 32) {
                        z = false;
                        break;
                    }
                }
            }
            reader.reset();
        }
        return z;
    }

    C1455a(C1450m c1450m) {
        if (c1450m.f9357c != 48) {
            throw new IOException("AVA not a sequence");
        }
        this.f9382a = C1496bn.m11556a(c1450m.f9356b.m11376h());
        this.f9383b = c1450m.f9356b.m11371d();
        if (c1450m.f9356b.m11362a() != 0) {
            throw new IOException("AVA, extra bytes = " + c1450m.f9356b.m11362a());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1455a)) {
            return false;
        }
        return m11472b().equals(((C1455a) obj).m11472b());
    }

    public int hashCode() {
        return m11472b().hashCode();
    }

    @Override // p165d.p167b.p172e.InterfaceC1445h
    /* renamed from: a */
    public void mo11272a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        C1449l c1449l2 = new C1449l();
        c1449l.m11394a(this.f9382a);
        this.f9383b.m11416a(c1449l);
        c1449l2.m11388a((byte) 48, c1449l);
        outputStream.write(c1449l2.toByteArray());
    }

    /* renamed from: a */
    private String m11464a(int i, Map<String, String> map) {
        return C1503c.m11623a(this.f9382a, i, map);
    }

    public String toString() {
        return m11465a(m11464a(1, Collections.emptyMap()));
    }

    /* renamed from: a */
    public String m11470a(Map<String, String> map) {
        int i = 0;
        StringBuilder sb = new StringBuilder(100);
        sb.append(m11464a(3, map));
        sb.append('=');
        if ((sb.charAt(0) >= '0' && sb.charAt(0) <= '9') || !m11468a(this.f9383b, false)) {
            try {
                byte[] m11440u = this.f9383b.m11440u();
                sb.append('#');
                while (i < m11440u.length) {
                    byte b2 = m11440u[i];
                    sb.append(Character.forDigit((b2 >>> 4) & 15, 16));
                    sb.append(Character.forDigit(b2 & 15, 16));
                    i++;
                }
            } catch (IOException e2) {
                throw new IllegalArgumentException("DER Value conversion");
            }
        } else {
            try {
                String str = new String(this.f9383b.m11426g(), "UTF8");
                StringBuilder sb2 = new StringBuilder();
                for (int i2 = 0; i2 < str.length(); i2++) {
                    char charAt = str.charAt(i2);
                    if (C1450m.m11411a(charAt) || ",=+<>#;\"\\".indexOf(charAt) >= 0) {
                        if (",=+<>#;\"\\".indexOf(charAt) >= 0) {
                            sb2.append('\\');
                        }
                        sb2.append(charAt);
                    } else if (f9381d != null && C1444g.m11331b("ava")) {
                        try {
                            byte[] bytes = Character.toString(charAt).getBytes("UTF8");
                            for (int i3 = 0; i3 < bytes.length; i3++) {
                                sb2.append('\\');
                                sb2.append(Character.toUpperCase(Character.forDigit((bytes[i3] >>> 4) & 15, 16)));
                                sb2.append(Character.toUpperCase(Character.forDigit(bytes[i3] & 15, 16)));
                            }
                        } catch (IOException e3) {
                            throw new IllegalArgumentException("DER Value conversion");
                        }
                    } else {
                        sb2.append(charAt);
                    }
                }
                char[] charArray = sb2.toString().toCharArray();
                StringBuilder sb3 = new StringBuilder();
                int i4 = 0;
                while (i4 < charArray.length && (charArray[i4] == ' ' || charArray[i4] == '\r')) {
                    i4++;
                }
                int length = charArray.length - 1;
                while (length >= 0 && (charArray[length] == ' ' || charArray[length] == '\r')) {
                    length--;
                }
                while (i < charArray.length) {
                    char c2 = charArray[i];
                    if (i < i4 || i > length) {
                        sb3.append('\\');
                    }
                    sb3.append(c2);
                    i++;
                }
                sb.append(sb3.toString());
            } catch (IOException e4) {
                throw new IllegalArgumentException("DER Value conversion");
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    public String m11472b() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(m11464a(3, Collections.emptyMap()));
        sb.append('=');
        if ((sb.charAt(0) >= '0' && sb.charAt(0) <= '9') || !m11468a(this.f9383b, true)) {
            try {
                byte[] m11440u = this.f9383b.m11440u();
                sb.append('#');
                for (byte b2 : m11440u) {
                    sb.append(Character.forDigit((b2 >>> 4) & 15, 16));
                    sb.append(Character.forDigit(b2 & 15, 16));
                }
            } catch (IOException e2) {
                throw new IllegalArgumentException("DER Value conversion");
            }
        } else {
            try {
                String str = new String(this.f9383b.m11426g(), "UTF8");
                StringBuilder sb2 = new StringBuilder();
                boolean z = false;
                for (int i = 0; i < str.length(); i++) {
                    char charAt = str.charAt(i);
                    if (C1450m.m11411a(charAt) || ",+<>;\"\\".indexOf(charAt) >= 0 || (i == 0 && charAt == '#')) {
                        if ((i == 0 && charAt == '#') || ",+<>;\"\\".indexOf(charAt) >= 0) {
                            sb2.append('\\');
                        }
                        if (!Character.isWhitespace(charAt)) {
                            sb2.append(charAt);
                            z = false;
                        } else {
                            if (!z) {
                                sb2.append(charAt);
                                z = true;
                            }
                        }
                    } else if (f9381d != null && C1444g.m11331b("ava")) {
                        try {
                            byte[] bytes = Character.toString(charAt).getBytes("UTF8");
                            for (int i2 = 0; i2 < bytes.length; i2++) {
                                sb2.append('\\');
                                sb2.append(Character.forDigit((bytes[i2] >>> 4) & 15, 16));
                                sb2.append(Character.forDigit(bytes[i2] & 15, 16));
                            }
                            z = false;
                        } catch (IOException e3) {
                            throw new IllegalArgumentException("DER Value conversion");
                        }
                    } else {
                        sb2.append(charAt);
                        z = false;
                    }
                }
                sb.append(sb2.toString().trim());
            } catch (IOException e4) {
                throw new IllegalArgumentException("DER Value conversion");
            }
        }
        return Normalizer.normalize(sb.toString().toUpperCase(Locale.f10688US).toLowerCase(Locale.f10688US), Normalizer.Form.NFKD);
    }

    /* renamed from: a */
    private static boolean m11468a(C1450m c1450m, boolean z) {
        if (z) {
            switch (c1450m.f9357c) {
                case 12:
                case 19:
                    break;
                default:
                    return false;
            }
        } else {
            switch (c1450m.f9357c) {
                case 12:
                case 19:
                case 20:
                case 22:
                case 27:
                case 30:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    boolean m11471a() {
        return C1503c.m11625a(this.f9382a, 3);
    }

    /* renamed from: a */
    private String m11465a(String str) {
        char charAt;
        StringBuilder sb = new StringBuilder(40);
        sb.append(str);
        sb.append("=");
        try {
            String m11415a = this.f9383b.m11415a();
            if (m11415a == null) {
                byte[] m11440u = this.f9383b.m11440u();
                sb.append('#');
                for (int i = 0; i < m11440u.length; i++) {
                    sb.append(C3112bn.f18384b.charAt((m11440u[i] >> 4) & 15));
                    sb.append(C3112bn.f18384b.charAt(m11440u[i] & 15));
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                boolean z = false;
                boolean z2 = false;
                for (int i2 = 0; i2 < m11415a.length(); i2++) {
                    char charAt2 = m11415a.charAt(i2);
                    if (C1450m.m11411a(charAt2) || ",+=\n<>#;\\\"".indexOf(charAt2) >= 0) {
                        if (!z2 && ((i2 == 0 && (charAt2 == ' ' || charAt2 == '\n')) || ",+=\n<>#;\\\"".indexOf(charAt2) >= 0)) {
                            z2 = true;
                        }
                        if (charAt2 != ' ' && charAt2 != '\n') {
                            if (charAt2 == '\"' || charAt2 == '\\') {
                                sb2.append('\\');
                            }
                            z = false;
                        } else {
                            if (!z2 && z) {
                                z2 = true;
                            }
                            z = true;
                        }
                        sb2.append(charAt2);
                    } else if (f9381d != null && C1444g.m11331b("ava")) {
                        byte[] bytes = Character.toString(charAt2).getBytes("UTF8");
                        for (int i3 = 0; i3 < bytes.length; i3++) {
                            sb2.append('\\');
                            sb2.append(Character.toUpperCase(Character.forDigit((bytes[i3] >>> 4) & 15, 16)));
                            sb2.append(Character.toUpperCase(Character.forDigit(bytes[i3] & 15, 16)));
                        }
                        z = false;
                    } else {
                        sb2.append(charAt2);
                        z = false;
                    }
                }
                if (sb2.length() > 0 && ((charAt = sb2.charAt(sb2.length() - 1)) == ' ' || charAt == '\n')) {
                    z2 = true;
                }
                if (z2) {
                    sb.append("\"" + sb2.toString() + "\"");
                } else {
                    sb.append(sb2.toString());
                }
            }
            return sb.toString();
        } catch (IOException e2) {
            throw new IllegalArgumentException("DER Value conversion");
        }
    }
}
