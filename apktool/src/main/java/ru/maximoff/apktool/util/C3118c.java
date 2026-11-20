package ru.maximoff.apktool.util;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.icu.text.DateFormat;
import java.math.BigDecimal;
import java.math.MathContext;
import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ru.maximoff.apktool.util.p303a.C3061a;

/* compiled from: BmpToVector.java */
/* renamed from: ru.maximoff.apktool.util.c */
/* loaded from: classes.dex */
public class C3118c {

    /* renamed from: a */
    private Bitmap f18399a;

    /* renamed from: b */
    private byte[] f18400b;

    /* renamed from: c */
    private int[] f18401c;

    /* renamed from: d */
    private int[] f18402d;

    /* renamed from: e */
    private int f18403e = 1;

    /* renamed from: f */
    private int f18404f;

    /* renamed from: g */
    private int f18405g;

    /* renamed from: h */
    private int f18406h;

    public C3118c(Bitmap bitmap) {
        this.f18399a = bitmap;
        this.f18404f = this.f18399a.getWidth();
        this.f18405g = this.f18399a.getHeight();
        this.f18401c = new int[this.f18404f * this.f18405g];
        this.f18399a.getPixels(this.f18401c, 0, this.f18404f, 0, 0, this.f18404f, this.f18405g);
        this.f18402d = new int[this.f18401c.length];
        for (int i = 0; i < this.f18401c.length; i++) {
            this.f18402d[i] = m19075b(this.f18401c[i]);
        }
        this.f18406h = -1;
    }

    /* renamed from: a */
    public void m19078a(int i) {
        this.f18406h = i;
    }

    /* renamed from: a */
    private int m19072a(int i, int i2) {
        return (this.f18404f * i2) + i;
    }

    /* renamed from: b */
    private int m19075b(int i) {
        int alpha = Color.alpha(i);
        return (alpha == 0 || this.f18403e <= 1) ? i : Color.argb(alpha, (Color.red(i) / this.f18403e) * this.f18403e, (Color.green(i) / this.f18403e) * this.f18403e, (Color.blue(i) / this.f18403e) * this.f18403e);
    }

    /* renamed from: a */
    private void m19074a(int i, int i2, int i3, List<b> list) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(new Integer(m19072a(i, i2)));
        while (!arrayDeque.isEmpty()) {
            int intValue = ((Integer) arrayDeque.pop()).intValue();
            int i4 = intValue % this.f18404f;
            int i5 = intValue / this.f18404f;
            if (this.f18400b[intValue] == 0 && this.f18402d[intValue] == i3) {
                int i6 = i4;
                while (i6 > 0) {
                    int m19072a = m19072a(i6 - 1, i5);
                    if (this.f18400b[m19072a] != 0 || this.f18402d[m19072a] != i3) {
                        break;
                    } else {
                        i6--;
                    }
                }
                while (i4 < this.f18404f - 1) {
                    int m19072a2 = m19072a(i4 + 1, i5);
                    if (this.f18400b[m19072a2] != 0 || this.f18402d[m19072a2] != i3) {
                        break;
                    } else {
                        i4++;
                    }
                }
                for (int i7 = i6; i7 <= i4; i7++) {
                    this.f18400b[m19072a(i7, i5)] = (byte) 1;
                }
                list.add(new b(i6, i4, i5));
                if (i5 > 0) {
                    for (int i8 = i6; i8 <= i4; i8++) {
                        int m19072a3 = m19072a(i8, i5 - 1);
                        if (this.f18400b[m19072a3] == 0 && this.f18402d[m19072a3] == i3) {
                            arrayDeque.push(new Integer(m19072a3));
                        }
                    }
                }
                if (i5 < this.f18405g - 1) {
                    while (i6 <= i4) {
                        int m19072a4 = m19072a(i6, i5 + 1);
                        if (this.f18400b[m19072a4] == 0 && this.f18402d[m19072a4] == i3) {
                            arrayDeque.push(new Integer(m19072a4));
                        }
                        i6++;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private List<a> m19073a(List<b> list) {
        boolean z;
        int i;
        ArrayList arrayList = new ArrayList();
        while (!list.isEmpty()) {
            b remove = list.remove(0);
            int i2 = remove.f18602a;
            int i3 = remove.f18603b;
            int i4 = remove.f18604c;
            int i5 = 1;
            while (true) {
                int i6 = 0;
                while (true) {
                    if (i6 < list.size()) {
                        b bVar = list.get(i6);
                        if (bVar.f18602a != i2 || bVar.f18603b != i3 || bVar.f18604c != i4 + i5) {
                            i6++;
                        } else {
                            i = i5 + 1;
                            list.remove(i6);
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        i = i5;
                        break;
                    }
                }
                if (!z) {
                    break;
                }
                i5 = i;
            }
            arrayList.add(new a(i2, i4, (i3 - i2) + 1, i));
        }
        return arrayList;
    }

    /* renamed from: b */
    private String m19076b(List<a> list) {
        StringBuilder sb = new StringBuilder();
        for (a aVar : list) {
            sb.append(DateFormat.NUM_MONTH).append(aVar.f18411a).append(",").append(aVar.f18412b).append("h").append(aVar.f18413c).append("v").append(aVar.f18414d).append("h-").append(aVar.f18413c).append(DateFormat.ABBR_SPECIFIC_TZ);
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public Map<Integer, String> m19077a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f18400b = new byte[this.f18404f * this.f18405g];
        for (int i = 0; i < this.f18405g; i++) {
            for (int i2 = 0; i2 < this.f18404f; i2++) {
                int m19072a = m19072a(i2, i);
                if (this.f18400b[m19072a] == 0) {
                    int i3 = this.f18402d[m19072a];
                    ArrayList arrayList = new ArrayList();
                    m19074a(i2, i, i3, arrayList);
                    String m19076b = m19076b(m19073a(arrayList));
                    String str = (String) linkedHashMap.get(new Integer(i3));
                    if (str == null) {
                        linkedHashMap.put(new Integer(i3), m19076b);
                    } else {
                        linkedHashMap.put(new Integer(i3), new StringBuffer().append(str).append(m19076b).toString());
                    }
                }
            }
        }
        return linkedHashMap;
    }

    /* renamed from: b */
    public List<C3115bq> m19080b() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Integer, String> entry : m19077a().entrySet()) {
            arrayList.add(new C3115bq(String.format("%08x", new Integer(entry.getKey().intValue() & (-1))), entry.getValue()));
        }
        return arrayList;
    }

    /* renamed from: a */
    public void m19079a(File file) {
        C3061a.m18319b(file, toString());
    }

    /* renamed from: b */
    public void m19081b(File file) {
        C3061a.m18319b(file, m19082c());
    }

    /* renamed from: c */
    public void m19083c(File file) {
        C3061a.m18319b(file, m19084d());
    }

    /* renamed from: a */
    private float m19070a(float f2) {
        return m19071a(f2, 12);
    }

    /* renamed from: a */
    private float m19071a(float f2, int i) {
        return new BigDecimal(f2, new MathContext(i)).floatValue();
    }

    /* renamed from: c */
    public String m19082c() {
        Map<Integer, String> m19077a = m19077a();
        StringBuilder sb = new StringBuilder();
        sb.append("<!-- ");
        sb.append("Created by Apktool M – https://github.com/Maximoff/Apktool-M-updates");
        sb.append(" -->\n");
        sb.append("<svg\n");
        sb.append("\txmlns=\"http://www.w3.org/2000/svg\"\n");
        sb.append("\txmlns:xlink=\"http://www.w3.org/1999/xlink\"\n");
        sb.append("\tversion=\"1.1\"\n");
        sb.append("\twidth=\"");
        sb.append(this.f18404f);
        sb.append("\"\n");
        sb.append("\theight=\"");
        sb.append(this.f18405g);
        sb.append("\"\n");
        sb.append("\tviewBox=\"0 0 ");
        sb.append(this.f18404f);
        sb.append(" ");
        sb.append(this.f18405g);
        sb.append("\">\n");
        for (Map.Entry<Integer, String> entry : m19077a.entrySet()) {
            int intValue = entry.getKey().intValue();
            sb.append("\t<path\n");
            sb.append("\t\td=\"");
            sb.append(entry.getValue());
            sb.append("\"\n");
            if (intValue == 0) {
                sb.append("\t\tfill=\"none\" />\n");
            } else {
                sb.append("\t\tfill=\"rgb(");
                sb.append(Color.red(intValue));
                sb.append(",");
                sb.append(Color.green(intValue));
                sb.append(",");
                sb.append(Color.blue(intValue));
                sb.append(")\"\n");
                sb.append("\t\tfill-opacity=\"");
                sb.append(m19070a(Color.alpha(intValue) / 255.0f));
                sb.append("\" />\n");
            }
        }
        sb.append("</svg>");
        return sb.toString();
    }

    /* renamed from: d */
    public String m19084d() {
        Map<Integer, String> m19077a = m19077a();
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        sb.append("<!-- ");
        sb.append("Created by Apktool M – https://github.com/Maximoff/Apktool-M-updates");
        sb.append(" -->\n");
        sb.append("<adaptive-icon\n");
        sb.append("\txmlns:android=\"http://schemas.android.com/apk/res/android\">\n");
        sb.append("\t<background>\n");
        sb.append("\t\t<shape\n");
        sb.append("\t\t\tandroid:width=\"");
        sb.append(this.f18404f);
        sb.append(".0dp\"\n");
        sb.append("\t\t\tandroid:height=\"");
        sb.append(this.f18405g);
        sb.append(".0dp\"\n");
        sb.append("\t\t\tandroid:shape=\"rectangle\">\n");
        sb.append("\t\t\t<solid\n");
        sb.append("\t\t\t\tandroid:color=\"");
        sb.append(String.format("#%08x", new Integer(this.f18406h & (-1))));
        sb.append("\" />\n");
        sb.append("\t\t</shape>\n");
        sb.append("\t</background>\n");
        sb.append("\t<foreground>\n");
        sb.append("\t\t<vector\n");
        sb.append("\t\t\tandroid:width=\"");
        sb.append(this.f18404f);
        sb.append(".0dp\"\n");
        sb.append("\t\t\tandroid:height=\"");
        sb.append(this.f18405g);
        sb.append(".0dp\"\n");
        sb.append("\t\t\tandroid:viewportWidth=\"");
        sb.append(this.f18404f);
        sb.append(".0\"\n");
        sb.append("\t\t\tandroid:viewportHeight=\"");
        sb.append(this.f18405g);
        sb.append(".0\">\n");
        for (Map.Entry<Integer, String> entry : m19077a.entrySet()) {
            sb.append("\t\t\t<path\n");
            sb.append("\t\t\t\tandroid:pathData=\"");
            sb.append(entry.getValue());
            sb.append("\"\n");
            sb.append("\t\t\t\tandroid:fillColor=\"");
            sb.append(String.format("#%08x", new Integer(entry.getKey().intValue() & (-1))));
            sb.append("\" />\n");
        }
        sb.append("\t\t</vector>\n");
        sb.append("\t</foreground>\n");
        sb.append("</adaptive-icon>");
        return sb.toString();
    }

    public String toString() {
        Map<Integer, String> m19077a = m19077a();
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        sb.append("<!-- ");
        sb.append("Created by Apktool M – https://github.com/Maximoff/Apktool-M-updates");
        sb.append(" -->\n");
        sb.append("<vector\n");
        sb.append("\txmlns:android=\"http://schemas.android.com/apk/res/android\"\n");
        sb.append("\tandroid:width=\"");
        sb.append(this.f18404f);
        sb.append(".0dp\"\n");
        sb.append("\tandroid:height=\"");
        sb.append(this.f18405g);
        sb.append(".0dp\"\n");
        sb.append("\tandroid:viewportWidth=\"");
        sb.append(this.f18404f);
        sb.append(".0\"\n");
        sb.append("\tandroid:viewportHeight=\"");
        sb.append(this.f18405g);
        sb.append(".0\">\n");
        for (Map.Entry<Integer, String> entry : m19077a.entrySet()) {
            sb.append("\t<path\n");
            sb.append("\t\tandroid:pathData=\"");
            sb.append(entry.getValue());
            sb.append("\"\n");
            sb.append("\t\tandroid:fillColor=\"");
            sb.append(String.format("#%08x", new Integer(entry.getKey().intValue() & (-1))));
            sb.append("\" />\n");
        }
        sb.append("</vector>");
        return sb.toString();
    }

    /* compiled from: BmpToVector.java */
    /* renamed from: ru.maximoff.apktool.util.c$b */
    private static class b {

        /* renamed from: a */
        int f18602a;

        /* renamed from: b */
        int f18603b;

        /* renamed from: c */
        int f18604c;

        b(int i, int i2, int i3) {
            this.f18602a = i;
            this.f18603b = i2;
            this.f18604c = i3;
        }
    }

    /* compiled from: BmpToVector.java */
    /* renamed from: ru.maximoff.apktool.util.c$a */
    private static class a {

        /* renamed from: a */
        int f18411a;

        /* renamed from: b */
        int f18412b;

        /* renamed from: c */
        int f18413c;

        /* renamed from: d */
        int f18414d;

        a(int i, int i2, int i3, int i4) {
            this.f18411a = i;
            this.f18412b = i2;
            this.f18413c = i3;
            this.f18414d = i4;
        }
    }
}
