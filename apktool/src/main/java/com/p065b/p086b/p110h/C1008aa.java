package com.p065b.p086b.p110h;

import java.p209io.IOException;
import java.p209io.StringWriter;
import java.p209io.Writer;

/* compiled from: TwoColumnOutput.java */
/* renamed from: com.b.b.h.aa */
/* loaded from: classes.dex */
public final class C1008aa {

    /* renamed from: a */
    private final Writer f6466a;

    /* renamed from: b */
    private final int f6467b;

    /* renamed from: c */
    private final StringBuffer f6468c;

    /* renamed from: d */
    private final StringBuffer f6469d;

    /* renamed from: e */
    private final C1023n f6470e;

    /* renamed from: f */
    private final C1023n f6471f;

    /* renamed from: a */
    public static String m8464a(String str, int i, String str2, String str3, int i2) {
        StringWriter stringWriter = new StringWriter((str.length() + str3.length()) * 3);
        C1008aa c1008aa = new C1008aa(stringWriter, i, i2, str2);
        try {
            c1008aa.m8470a().write(str);
            c1008aa.m8471b().write(str3);
            c1008aa.m8472c();
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new RuntimeException("shouldn't happen", e2);
        }
    }

    public C1008aa(Writer writer, int i, int i2, String str) {
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        if (i < 1) {
            throw new IllegalArgumentException("leftWidth < 1");
        }
        if (i2 < 1) {
            throw new IllegalArgumentException("rightWidth < 1");
        }
        if (str == null) {
            throw new NullPointerException("spacer == null");
        }
        StringWriter stringWriter = new StringWriter(1000);
        StringWriter stringWriter2 = new StringWriter(1000);
        this.f6466a = writer;
        this.f6467b = i;
        this.f6468c = stringWriter.getBuffer();
        this.f6469d = stringWriter2.getBuffer();
        this.f6470e = new C1023n(stringWriter, i);
        this.f6471f = new C1023n(stringWriter2, i2, str);
    }

    /* renamed from: a */
    public Writer m8470a() {
        return this.f6470e;
    }

    /* renamed from: b */
    public Writer m8471b() {
        return this.f6471f;
    }

    /* renamed from: c */
    public void m8472c() {
        try {
            m8466a(this.f6468c, this.f6470e);
            m8466a(this.f6469d, this.f6471f);
            m8467d();
            m8468e();
            m8469f();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* renamed from: d */
    private void m8467d() {
        int indexOf;
        while (true) {
            int indexOf2 = this.f6468c.indexOf("\n");
            if (indexOf2 < 0 || (indexOf = this.f6469d.indexOf("\n")) < 0) {
                return;
            }
            if (indexOf2 != 0) {
                this.f6466a.write(this.f6468c.substring(0, indexOf2));
            }
            if (indexOf != 0) {
                m8465a(this.f6466a, this.f6467b - indexOf2);
                this.f6466a.write(this.f6469d.substring(0, indexOf));
            }
            this.f6466a.write(10);
            this.f6468c.delete(0, indexOf2 + 1);
            this.f6469d.delete(0, indexOf + 1);
        }
    }

    /* renamed from: e */
    private void m8468e() {
        m8466a(this.f6468c, this.f6470e);
        while (this.f6468c.length() != 0) {
            this.f6471f.write(10);
            m8467d();
        }
    }

    /* renamed from: f */
    private void m8469f() {
        m8466a(this.f6469d, this.f6471f);
        while (this.f6469d.length() != 0) {
            this.f6470e.write(10);
            m8467d();
        }
    }

    /* renamed from: a */
    private static void m8466a(StringBuffer stringBuffer, Writer writer) {
        int length = stringBuffer.length();
        if (length != 0 && stringBuffer.charAt(length - 1) != '\n') {
            writer.write(10);
        }
    }

    /* renamed from: a */
    private static void m8465a(Writer writer, int i) {
        while (i > 0) {
            writer.write(32);
            i--;
        }
    }
}
