package org.p270e;

import java.p209io.BufferedReader;
import java.p209io.IOException;
import java.p209io.Reader;
import java.p209io.StringReader;

/* compiled from: JSONTokener.java */
/* renamed from: org.e.g */
/* loaded from: classes.dex */
public class C2472g {

    /* renamed from: a */
    private long f12956a;

    /* renamed from: b */
    private boolean f12957b;

    /* renamed from: c */
    private long f12958c;

    /* renamed from: d */
    private long f12959d;

    /* renamed from: e */
    private char f12960e;

    /* renamed from: f */
    private final Reader f12961f;

    /* renamed from: g */
    private boolean f12962g;

    /* renamed from: h */
    private long f12963h;

    public C2472g(Reader reader) {
        this.f12961f = reader.markSupported() ? reader : new BufferedReader(reader);
        this.f12957b = false;
        this.f12962g = false;
        this.f12960e = (char) 0;
        this.f12958c = 0L;
        this.f12956a = 1L;
        this.f12963h = 0L;
        this.f12959d = 1L;
    }

    public C2472g(String str) {
        this(new StringReader(str));
    }

    /* renamed from: a */
    public void m15630a() {
        if (this.f12962g || this.f12958c <= 0) {
            throw new C2467b("Stepping back two steps is not supported");
        }
        m15625f();
        this.f12962g = true;
        this.f12957b = false;
    }

    /* renamed from: f */
    private void m15625f() {
        this.f12958c--;
        if (this.f12960e == '\r' || this.f12960e == '\n') {
            this.f12959d--;
            this.f12956a = this.f12963h;
        } else if (this.f12956a > 0) {
            this.f12956a--;
        }
    }

    /* renamed from: b */
    public boolean m15631b() {
        return this.f12957b && !this.f12962g;
    }

    /* renamed from: c */
    public char m15632c() {
        int read;
        if (this.f12962g) {
            this.f12962g = false;
            read = this.f12960e;
        } else {
            try {
                read = this.f12961f.read();
            } catch (IOException e2) {
                throw new C2467b(e2);
            }
        }
        if (read <= 0) {
            this.f12957b = true;
            return (char) 0;
        }
        m15624b(read);
        this.f12960e = (char) read;
        return this.f12960e;
    }

    /* renamed from: b */
    private void m15624b(int i) {
        if (i > 0) {
            this.f12958c++;
            if (i == 13) {
                this.f12959d++;
                this.f12963h = this.f12956a;
                this.f12956a = 0L;
            } else {
                if (i == 10) {
                    if (this.f12960e != '\r') {
                        this.f12959d++;
                        this.f12963h = this.f12956a;
                    }
                    this.f12956a = 0L;
                    return;
                }
                this.f12956a++;
            }
        }
    }

    /* renamed from: a */
    public String m15627a(int i) {
        if (i == 0) {
            return "";
        }
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = m15632c();
            if (m15631b()) {
                throw m15628a("Substring bounds error");
            }
        }
        return new String(cArr);
    }

    /* renamed from: d */
    public char m15633d() {
        char m15632c;
        do {
            m15632c = m15632c();
            if (m15632c == 0) {
                break;
            }
        } while (m15632c <= ' ');
        return m15632c;
    }

    /* renamed from: a */
    public String m15626a(char c2) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            char m15632c = m15632c();
            switch (m15632c) {
                case 0:
                case '\n':
                case '\r':
                    throw m15628a("Unterminated string");
                case '\\':
                    char m15632c2 = m15632c();
                    switch (m15632c2) {
                        case '\"':
                        case '\'':
                        case '/':
                        case '\\':
                            sb.append(m15632c2);
                            break;
                        case 'b':
                            sb.append('\b');
                            break;
                        case 'f':
                            sb.append('\f');
                            break;
                        case 'n':
                            sb.append('\n');
                            break;
                        case 'r':
                            sb.append('\r');
                            break;
                        case 't':
                            sb.append('\t');
                            break;
                        case 'u':
                            try {
                                sb.append((char) Integer.parseInt(m15627a(4), 16));
                                break;
                            } catch (NumberFormatException e2) {
                                throw m15629a("Illegal escape.", e2);
                            }
                        default:
                            throw m15628a("Illegal escape.");
                    }
                default:
                    if (m15632c == c2) {
                        return sb.toString();
                    }
                    sb.append(m15632c);
                    break;
            }
        }
    }

    /* renamed from: e */
    public Object m15634e() {
        char m15633d = m15633d();
        switch (m15633d) {
            case '\"':
            case '\'':
                return m15626a(m15633d);
            case '[':
                m15630a();
                return new C2466a(this);
            case '{':
                m15630a();
                return new C2468c(this);
            default:
                StringBuilder sb = new StringBuilder();
                while (m15633d >= ' ' && ",:]}/\\\"[{;=#".indexOf(m15633d) < 0) {
                    sb.append(m15633d);
                    m15633d = m15632c();
                }
                if (!this.f12957b) {
                    m15630a();
                }
                String trim = sb.toString().trim();
                if ("".equals(trim)) {
                    throw m15628a("Missing value");
                }
                return C2468c.m15599n(trim);
        }
    }

    /* renamed from: a */
    public C2467b m15628a(String str) {
        return new C2467b(str + toString());
    }

    /* renamed from: a */
    public C2467b m15629a(String str, Throwable th) {
        return new C2467b(str + toString(), th);
    }

    public String toString() {
        return " at " + this.f12958c + " [character " + this.f12956a + " line " + this.f12959d + "]";
    }
}
