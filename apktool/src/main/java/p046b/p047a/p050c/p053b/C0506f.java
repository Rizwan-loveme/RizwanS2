package p046b.p047a.p050c.p053b;

import com.srizwan.apktool.R;
import java.p209io.ByteArrayInputStream;
import java.p209io.IOException;
import java.p209io.InputStream;
import java.p209io.OutputStream;
import java.util.Arrays;
import java.util.logging.Level;
import javax.xml.XMLConstants;
import org.p217b.p218a.p219a.C1887e;
import p046b.p047a.C0461b;
import p046b.p047a.p048a.C0456a;
import p046b.p047a.p050c.C0467a;
import p046b.p047a.p050c.p051a.C0494e;
import p046b.p047a.p050c.p051a.p052a.C0472d;
import p046b.p047a.p050c.p051a.p052a.C0477i;
import p046b.p047a.p050c.p051a.p052a.C0487s;
import p046b.p058c.C0527b;
import p046b.p058c.C0529d;
import p046b.p058c.C0533h;
import p046b.p058c.InterfaceC0528c;
import p046b.p059d.C0540e;
import p046b.p059d.InterfaceC0541f;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.C3262u;

/* compiled from: ResFileDecoder.java */
/* renamed from: b.a.c.b.f */
/* loaded from: classes.dex */
public class C0506f {

    /* renamed from: c */
    private static final String[] f3546c = {"m4a", "qmg"};

    /* renamed from: d */
    private static final String[] f3547d = {"qmg", "spi"};

    /* renamed from: a */
    private final C0509i f3548a;

    /* renamed from: b */
    private final InterfaceC0541f f3549b;

    public C0506f(C0509i c0509i, InterfaceC0541f interfaceC0541f) {
        this.f3548a = c0509i;
        this.f3549b = interfaceC0541f;
    }

    /* renamed from: a */
    public void m3832a(C0494e c0494e, InterfaceC0528c interfaceC0528c, InterfaceC0528c interfaceC0528c2, C0467a c0467a) {
        String str;
        String str2;
        if (!this.f3549b.mo3981a()) {
            C0477i c0477i = (C0477i) c0494e.m3701d();
            String m3635b = c0477i.m3635b();
            String m3697a = c0494e.m3697a();
            String m3740a = c0494e.m3700c().m3695g().m3740a();
            try {
                InterfaceC0528c mo3925e = c0477i.m3636c().equals("") ? interfaceC0528c : interfaceC0528c.mo3925e(c0477i.m3636c());
                String str3 = (String) null;
                boolean z = false;
                int lastIndexOf = m3635b.lastIndexOf(46);
                if (lastIndexOf >= 0) {
                    str3 = m3635b.substring(lastIndexOf).toLowerCase();
                    if (str3.indexOf(47) != -1) {
                        str3 = (String) null;
                    }
                }
                if (m3740a.equals("drawable") || m3740a.equals("mipmap") || m3740a.equals("raw")) {
                    try {
                        byte[] m19619a = C3262u.m19619a(mo3925e.mo3950o(m3635b), 4);
                        if (Arrays.equals(m19619a, C3249i.f19557q)) {
                            z = m3831a(C1887e.m13984b(mo3925e.mo3950o(m3635b)));
                            if (str3 == null || !str3.equals(".png")) {
                                str3 = ".png";
                            }
                        } else if (Arrays.equals(m19619a, C3249i.f19558r)) {
                            if (str3 == null || !str3.equals(".wav")) {
                                str3 = ".webp";
                            }
                        } else if (Arrays.equals(m19619a, C3249i.f19562v)) {
                            if (str3 == null || !str3.equals(".gif")) {
                                str3 = ".gif";
                            }
                        } else if (Arrays.equals(m19619a, C3249i.f19559s) || Arrays.equals(m19619a, C3249i.f19560t) || Arrays.equals(m19619a, C3249i.f19561u)) {
                            if (str3 == null || (!str3.equals(".jpg") && !str3.equals(".jpeg"))) {
                                str3 = ".jpg";
                            }
                        } else if (Arrays.equals(m19619a, C3249i.f19535A) && !m3740a.equals("raw") && (str3 == null || !str3.equals(".xml"))) {
                            str3 = ".xml";
                        }
                        str = str3;
                    } catch (Exception e2) {
                        str = str3;
                    }
                } else {
                    str = str3;
                }
                String stringBuffer = str == null ? m3697a : new StringBuffer().append(m3697a).append(str).toString();
                try {
                    if (m3740a.equals("raw")) {
                        m3835a(mo3925e, m3635b, interfaceC0528c2, stringBuffer, "raw", c0467a, c0477i.m3634a());
                        return;
                    }
                    if (m3740a.equals("font") && !".xml".equals(str)) {
                        m3835a(mo3925e, m3635b, interfaceC0528c2, stringBuffer, "raw", c0467a, c0477i.m3634a());
                        return;
                    }
                    if (m3740a.equals("drawable") || m3740a.equals("mipmap")) {
                        if (m3635b.toLowerCase().endsWith(new StringBuffer().append(".9").append(str).toString()) || z) {
                            String stringBuffer2 = new StringBuffer().append(new StringBuffer().append(m3697a).append(".9").toString()).append(str).toString();
                            if (m3635b.toLowerCase().endsWith(new StringBuffer().append(".r.9").append(str).toString())) {
                                stringBuffer2 = new StringBuffer().append(new StringBuffer().append(m3697a).append(".r.9").toString()).append(str).toString();
                            }
                            for (String str4 : f3547d) {
                                if (m3635b.toLowerCase().endsWith(new StringBuffer().append(".").append(str4).toString())) {
                                    m3833a(mo3925e, interfaceC0528c2, stringBuffer2);
                                    return;
                                }
                            }
                            if (m3635b.toLowerCase().endsWith(".xml")) {
                                m3835a(mo3925e, m3635b, interfaceC0528c2, stringBuffer2, XMLConstants.XML_NS_PREFIX, c0467a, c0477i.m3634a());
                                return;
                            }
                            try {
                                m3835a(mo3925e, m3635b, interfaceC0528c2, stringBuffer2, "9patch", c0467a, c0477i.m3634a());
                                return;
                            } catch (C0456a e3) {
                                this.f3549b.mo3980a(Level.INFO, String.format("Cant find 9patch chunk in file: \"%s\". Renaming it to *.png.", m3635b), (Throwable) null);
                                c0467a.m3608c(c0477i.m3634a());
                                interfaceC0528c2.mo3929g(stringBuffer2);
                                if (c0467a.m3601a()) {
                                    interfaceC0528c2.mo3929g(m3830a(c0477i.m3634a(), stringBuffer2));
                                }
                                stringBuffer = new StringBuffer().append(m3697a).append(str).toString();
                                c0467a.m3597a(c0477i.m3634a(), stringBuffer);
                            }
                        }
                        for (String str5 : f3546c) {
                            if (m3635b.toLowerCase().endsWith(new StringBuffer().append(".").append(str5).toString())) {
                                m3833a(mo3925e, interfaceC0528c2, stringBuffer);
                                return;
                            }
                        }
                        if (!".xml".equals(str)) {
                            m3835a(mo3925e, m3635b, interfaceC0528c2, stringBuffer, "raw", c0467a, c0477i.m3634a());
                            return;
                        }
                    }
                    String str6 = stringBuffer;
                    if (str == null || !".xml".equals(str)) {
                        try {
                            if (Arrays.equals(C3262u.m19619a(mo3925e.mo3950o(m3635b), 4), C3249i.f19535A)) {
                                if (str == null) {
                                    str6 = new StringBuffer().append(str6).append(".xml").toString();
                                } else {
                                    str6 = new StringBuffer().append(m3697a).append(".xml").toString();
                                }
                            }
                            str2 = str6;
                        } catch (Exception e4) {
                            str2 = str6;
                        }
                    } else {
                        str2 = str6;
                    }
                    if (!str2.endsWith(".xml")) {
                        m3835a(mo3925e, m3635b, interfaceC0528c2, str2, "raw", c0467a, c0477i.m3634a());
                    } else {
                        m3835a(mo3925e, m3635b, interfaceC0528c2, str2, XMLConstants.XML_NS_PREFIX, c0467a, c0477i.m3634a());
                    }
                } catch (C0461b e5) {
                    this.f3549b.mo3980a(Level.SEVERE, String.format("Could not decode file, replacing by FALSE value: %s", m3635b), (Throwable) null);
                    c0467a.m3608c(c0477i.m3634a());
                    c0494e.m3698a(new C0472d(false, 0, (String) null));
                }
            } catch (C0533h e6) {
                this.f3549b.mo3980a(Level.WARNING, String.format("Could not decode file, replaced by string resource: type=%s, name=%s, id=%s", c0494e.m3700c().m3695g().m3740a(), c0494e.m3700c().m3693e(), c0494e.m3700c().m3692d().toString()), (Throwable) null);
                c0467a.m3608c(c0477i.m3634a());
                c0494e.m3698a(new C0487s(c0477i.m3634a(), c0477i.m3642d()));
            }
        }
    }

    /* renamed from: a */
    public void m3835a(InterfaceC0528c interfaceC0528c, String str, InterfaceC0528c interfaceC0528c2, String str2, String str3, C0467a c0467a, String str4) {
        InputStream inputStream = (InputStream) null;
        OutputStream outputStream = (OutputStream) null;
        try {
            try {
                if (c0467a.m3601a()) {
                    str2 = m3830a(str4, str2);
                }
                if (!str.equals(str2)) {
                    c0467a.m3597a(str4, new StringBuffer().append("res/").append(str2).toString());
                }
                InputStream mo3920c = interfaceC0528c.mo3920c(str);
                try {
                    OutputStream mo3923d = interfaceC0528c2.mo3923d(str2);
                    this.f3548a.m3837a(mo3920c, mo3923d, str3);
                    mo3920c.close();
                    mo3923d.close();
                    C3262u.m19610a(interfaceC0528c2.mo3936n(str2), interfaceC0528c.mo3952q(str));
                    C1887e.m13970a(mo3920c);
                    C1887e.m13972a(mo3923d);
                } catch (C0529d e2) {
                    e = e2;
                    throw new C0461b(e);
                } catch (IOException e3) {
                    e = e3;
                    throw new C0461b(e);
                } catch (IllegalArgumentException e4) {
                    e = e4;
                    this.f3549b.mo3979a(R.string.text, e.getMessage());
                    throw new C0461b(e);
                }
            } catch (Throwable th) {
                th = th;
                C1887e.m13970a(inputStream);
                C1887e.m13972a(outputStream);
                throw th;
            }
        } catch (C0529d e5) {
            e = e5;
        } catch (IOException e6) {
            e = e6;
        } catch (IllegalArgumentException e7) {
            e = e7;
        } catch (Throwable th2) {
            th = th2;
            C1887e.m13970a(inputStream);
            C1887e.m13972a(outputStream);
            throw th;
        }
    }

    /* renamed from: a */
    public void m3833a(InterfaceC0528c interfaceC0528c, InterfaceC0528c interfaceC0528c2, String str) {
        try {
            C0527b.m3939a(interfaceC0528c, interfaceC0528c2, str);
        } catch (C0529d e2) {
            throw new C0461b(e2);
        }
    }

    /* renamed from: a */
    public void m3834a(InterfaceC0528c interfaceC0528c, String str, InterfaceC0528c interfaceC0528c2, String str2) {
        InputStream inputStream = (InputStream) null;
        OutputStream outputStream = (OutputStream) null;
        try {
            try {
                InputStream mo3920c = interfaceC0528c.mo3920c(str);
                try {
                    OutputStream mo3923d = interfaceC0528c2.mo3923d(str2);
                    ((C0512l) this.f3548a.m3836a(XMLConstants.XML_NS_PREFIX)).m3861b(mo3920c, mo3923d);
                    mo3920c.close();
                    mo3923d.close();
                    C3262u.m19610a(interfaceC0528c2.mo3936n(str2), interfaceC0528c.mo3952q(str));
                    C1887e.m13970a(mo3920c);
                    C1887e.m13972a(mo3923d);
                } catch (C0529d e2) {
                    e = e2;
                    throw new C0461b(e);
                } catch (IOException e3) {
                    e = e3;
                    throw new C0461b(e);
                }
            } catch (Throwable th) {
                th = th;
                C1887e.m13970a(inputStream);
                C1887e.m13972a(outputStream);
                throw th;
            }
        } catch (C0529d e4) {
            e = e4;
        } catch (IOException e5) {
            e = e5;
        } catch (Throwable th2) {
            th = th2;
            C1887e.m13970a(inputStream);
            C1887e.m13972a(outputStream);
            throw th;
        }
    }

    /* renamed from: a */
    private boolean m3831a(byte[] bArr) {
        C0540e c0540e = new C0540e(new ByteArrayInputStream(bArr));
        c0540e.skipBytes(8);
        while (true) {
            try {
                int readInt = c0540e.readInt();
                if (c0540e.readInt() == 1852855395) {
                    return true;
                }
                c0540e.skipBytes(readInt + 4);
            } catch (IOException e2) {
                return false;
            }
        }
    }

    /* renamed from: a */
    private String m3830a(String str, String str2) {
        if (str.startsWith("res/")) {
            String[] split = str.split("/");
            if (split.length == 3 && split[1].length() >= 3 && str2.startsWith(split[1].substring(0, 3))) {
                return new StringBuffer().append(new StringBuffer().append(split[1]).append("/").toString()).append(str2.split("/")[1]).toString();
            }
            return str2;
        }
        return str2;
    }
}
