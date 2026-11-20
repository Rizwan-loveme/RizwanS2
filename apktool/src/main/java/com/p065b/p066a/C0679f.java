package com.p065b.p066a;

import java.p209io.ByteArrayOutputStream;
import java.p209io.DataOutputStream;
import java.p209io.IOException;
import java.p209io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Hints.java */
/* renamed from: com.b.a.f */
/* loaded from: classes.dex */
public final class C0679f {
    public static final String PIN_BYTE_RANGE_ZIP_ENTRY_NAME = "pinlist.meta";
    public static final String PIN_HINT_ASSET_ZIP_ENTRY_NAME = "assets/com.android.hints.pins.txt";

    /* renamed from: a */
    private static int m6482a(long j) {
        return (int) Math.max(0L, Math.min(j, 2147483647L));
    }

    /* compiled from: Hints.java */
    /* renamed from: com.b.a.f$a */
    public static final class a {

        /* renamed from: a */
        final long f4456a;

        /* renamed from: b */
        final long f4457b;

        public a(long j, long j2) {
            this.f4457b = j;
            this.f4456a = j2;
        }
    }

    /* compiled from: Hints.java */
    /* renamed from: com.b.a.f$b */
    public static final class b {

        /* renamed from: a */
        final long f4458a;

        /* renamed from: b */
        final Pattern f4459b;

        /* renamed from: c */
        final long f4460c;

        public b(String str) {
            this.f4459b = Pattern.compile(str);
            this.f4458a = 0L;
            this.f4460c = Long.MAX_VALUE;
        }

        public b(String str, long j, long j2) {
            this.f4459b = Pattern.compile(str);
            this.f4458a = j;
            this.f4460c = j2;
        }

        /* renamed from: a */
        public Matcher m6486a(CharSequence charSequence) {
            return this.f4459b.matcher(charSequence);
        }

        /* renamed from: a */
        public a m6485a(a aVar) {
            if (aVar.f4456a - aVar.f4457b < this.f4458a) {
                return null;
            }
            long j = this.f4458a + aVar.f4457b;
            return new a(j, Math.min(aVar.f4456a - j, this.f4460c) + j);
        }
    }

    /* renamed from: a */
    public static byte[] m6484a(List<a> list) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(list.size() * 8);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            for (a aVar : list) {
                dataOutputStream.writeInt(m6482a(aVar.f4457b));
                dataOutputStream.writeInt(m6482a(aVar.f4456a - aVar.f4457b));
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new AssertionError("impossible", e2);
        }
    }

    /* renamed from: a */
    public static ArrayList<b> m6483a(byte[] bArr) {
        ArrayList<b> arrayList = new ArrayList<>();
        try {
            for (String str : new String(bArr, "UTF-8").split("\n")) {
                String replaceFirst = str.replaceFirst("#.*", "");
                String[] split = replaceFirst.split(" ");
                if (split.length == 1) {
                    arrayList.add(new b(split[0]));
                } else if (split.length == 3) {
                    long parseLong = Long.parseLong(split[1]);
                    arrayList.add(new b(split[0], parseLong, Long.parseLong(split[2]) - parseLong));
                } else {
                    throw new AssertionError("bad pin pattern line " + replaceFirst);
                }
            }
            return arrayList;
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UTF-8 must be supported", e2);
        }
    }
}
