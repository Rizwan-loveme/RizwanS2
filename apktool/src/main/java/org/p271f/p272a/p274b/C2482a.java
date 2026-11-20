package org.p271f.p272a.p274b;

/* compiled from: SignatureReader.java */
/* renamed from: org.f.a.b.a */
/* loaded from: classes.dex */
public class C2482a {

    /* renamed from: a */
    private final String f12988a;

    public C2482a(String str) {
        this.f12988a = str;
    }

    /* renamed from: a */
    public void m15710a(AbstractC2483b abstractC2483b) {
        char charAt;
        int i = 0;
        String str = this.f12988a;
        int length = str.length();
        if (str.charAt(0) == '<') {
            i = 2;
            do {
                int indexOf = str.indexOf(58, i);
                abstractC2483b.mo15696c(str.substring(i - 1, indexOf));
                int i2 = indexOf + 1;
                char charAt2 = str.charAt(i2);
                if (charAt2 == 'L' || charAt2 == '[' || charAt2 == 'T') {
                    i2 = m15709a(str, i2, abstractC2483b.mo15692b());
                }
                while (true) {
                    int i3 = i2;
                    i = i3 + 1;
                    charAt = str.charAt(i3);
                    if (charAt != ':') {
                        break;
                    } else {
                        i2 = m15709a(str, i, abstractC2483b.mo15699e());
                    }
                }
            } while (charAt != '>');
        }
        if (str.charAt(i) == '(') {
            int i4 = i + 1;
            while (str.charAt(i4) != ')') {
                i4 = m15709a(str, i4, abstractC2483b.mo15700f());
            }
            int m15709a = m15709a(str, i4 + 1, abstractC2483b.mo15701g());
            while (m15709a < length) {
                m15709a = m15709a(str, m15709a + 1, abstractC2483b.mo15695c());
            }
            return;
        }
        int m15709a2 = m15709a(str, i, abstractC2483b.mo15702h());
        while (m15709a2 < length) {
            m15709a2 = m15709a(str, m15709a2, abstractC2483b.mo15697d());
        }
    }

    /* renamed from: b */
    public void m15711b(AbstractC2483b abstractC2483b) {
        m15709a(this.f12988a, 0, abstractC2483b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003a, code lost:
    
        r2 = r9.substring(r3, r6 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        if (r0 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0042, code lost:
    
        r11.mo15694b(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004c, code lost:
    
        r11.mo15691a(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
    
        if (r4 != ';') goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0050, code lost:
    
        r0 = true;
        r2 = false;
        r3 = r6;
        r4 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
    
        r11.mo15704j();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0078, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x001b, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
    
        if (r2 != false) goto L17;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int m15709a(String str, int i, AbstractC2483b abstractC2483b) {
        int i2 = i + 1;
        char charAt = str.charAt(i);
        switch (charAt) {
            case 'B':
            case 'C':
            case 'D':
            case 'F':
            case 'I':
            case 'J':
            case 'S':
            case 'V':
            case 'Z':
                abstractC2483b.mo15690a(charAt);
                return i2;
            case 'E':
            case 'G':
            case 'H':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'U':
            case 'W':
            case 'X':
            case 'Y':
            default:
                boolean z = false;
                boolean z2 = false;
                int i3 = i2;
                while (true) {
                    int i4 = i2;
                    int i5 = i4 + 1;
                    char charAt2 = str.charAt(i4);
                    switch (charAt2) {
                        case '.':
                        case ';':
                            break;
                        case '<':
                            String substring = str.substring(i3, i5 - 1);
                            if (z) {
                                abstractC2483b.mo15694b(substring);
                            } else {
                                abstractC2483b.mo15691a(substring);
                            }
                            i2 = i5;
                            while (true) {
                                char charAt3 = str.charAt(i2);
                                switch (charAt3) {
                                    case '*':
                                        abstractC2483b.mo15703i();
                                        i2++;
                                        break;
                                    case '+':
                                    case '-':
                                        i2 = m15709a(str, i2 + 1, abstractC2483b.mo15693b(charAt3));
                                        break;
                                    case '>':
                                        break;
                                    default:
                                        i2 = m15709a(str, i2, abstractC2483b.mo15693b('='));
                                        break;
                                }
                            }
                            break;
                        default:
                            i2 = i5;
                            break;
                    }
                }
                break;
            case 'T':
                int indexOf = str.indexOf(59, i2);
                abstractC2483b.mo15698d(str.substring(i2, indexOf));
                return indexOf + 1;
            case '[':
                return m15709a(str, i2, abstractC2483b.mo15689a());
        }
    }
}
