package ru.maximoff.apktool.util;

import android.C0012R;
import android.app.slice.Slice;
import android.content.res.Resources;
import android.provider.MediaStore;
import android.util.C0035a;
import java.util.List;
import java.util.Map;
import p046b.p047a.p050c.p051a.C0497h;
import p060c.p061a.p062a.AbstractC0549e;
import p060c.p061a.p062a.C0547c;
import p060c.p061a.p062a.C0550f;
import ru.maximoff.apktool.util.p308f.C3239s;

/* compiled from: DumpAdapter.java */
/* renamed from: ru.maximoff.apktool.util.n */
/* loaded from: classes.dex */
public class C3254n extends C0547c {

    /* renamed from: a */
    private final String f19663a;

    /* renamed from: b */
    private Resources f19664b;

    /* renamed from: c */
    private int f19665c;

    /* renamed from: e */
    private boolean f19666e;

    /* renamed from: f */
    private String f19667f;

    /* renamed from: g */
    private StringBuilder f19668g;

    /* renamed from: h */
    private Map<String, String> f19669h;

    /* renamed from: i */
    private List<String> f19670i;

    public C3254n(AbstractC0549e abstractC0549e, Resources resources, int i, Map<String, String> map, List<String> list, StringBuilder sb, String str) {
        super(abstractC0549e);
        this.f19663a = "http://schemas.android.com/apk/res/android";
        this.f19666e = true;
        this.f19664b = resources;
        this.f19665c = i;
        this.f19669h = map;
        this.f19670i = list;
        this.f19668g = sb;
        this.f19667f = str;
    }

    @Override // p060c.p061a.p062a.AbstractC0549e
    /* renamed from: a */
    public void mo4032a(String str, String str2, int i, int i2, Object obj) {
        String m19512a;
        this.f19668g.append("\n");
        for (int i3 = 0; i3 < this.f19665c; i3++) {
            this.f19668g.append("    ");
        }
        if (this.f19669h != null && str != null) {
            this.f19668g.append(new StringBuffer().append(m19513a(str)).append(":").toString());
        }
        this.f19668g.append(str2);
        if (obj instanceof String) {
            m19512a = C3239s.m19436h((String) obj);
        } else if (obj instanceof Boolean) {
            m19512a = ((Boolean) obj).toString();
        } else if (i2 == 1) {
            if (obj instanceof C0550f) {
                m19512a = String.format("@0x%08x", new Integer(((C0550f) obj).f3695c));
            } else {
                m19512a = String.format("@0x%08x", obj);
            }
        } else if (i2 == 2) {
            if (obj instanceof C0550f) {
                m19512a = String.format("?0x%08x", new Integer(((C0550f) obj).f3695c));
            } else {
                m19512a = String.format("?0x%08x", obj);
            }
        } else if (obj instanceof C0550f) {
            m19512a = String.valueOf(C0035a.m199b(i2, ((C0550f) obj).f3695c));
        } else {
            m19512a = m19512a(i2, i, obj);
        }
        this.f19668g.append(new StringBuffer().append(new StringBuffer().append("=\"").append(m19512a).toString()).append("\"").toString());
        super.mo4032a(str, str2, i, i2, obj);
    }

    @Override // p060c.p061a.p062a.AbstractC0549e
    /* renamed from: a */
    public AbstractC0549e mo4019a(String str, String str2) {
        if (this.f19668g.length() > 0) {
            if (this.f19669h != null && !this.f19669h.isEmpty()) {
                for (Map.Entry<String, String> entry : this.f19669h.entrySet()) {
                    String key = entry.getKey();
                    if (!this.f19670i.contains(key)) {
                        this.f19670i.add(key);
                        this.f19668g.append("\n");
                        for (int i = 0; i < this.f19665c; i++) {
                            this.f19668g.append("    ");
                        }
                        this.f19668g.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("xmlns:").append((Object) entry.getValue()).toString()).append("=\"").toString()).append(key).toString()).append("\"").toString());
                    }
                }
            }
            if (this.f19668g.charAt(this.f19668g.length() - 1) != '>') {
                this.f19668g.append(">");
            }
            this.f19668g.append("\n");
        } else {
            this.f19668g.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>").append("\n");
        }
        this.f19666e = false;
        for (int i2 = 0; i2 < this.f19665c; i2++) {
            this.f19668g.append("    ");
        }
        this.f19668g.append("<");
        if (this.f19669h != null && str != null) {
            this.f19668g.append(new StringBuffer().append(m19513a(str)).append(":").toString());
        }
        this.f19668g.append(str2);
        return new C3254n(super.mo4019a(str, str2), this.f19664b, this.f19665c + 1, this.f19669h, this.f19670i, this.f19668g, str2);
    }

    @Override // p060c.p061a.p062a.AbstractC0549e
    /* renamed from: a */
    public void mo4024a() {
        if (this.f19666e) {
            if (this.f19669h != null && !this.f19669h.isEmpty()) {
                for (Map.Entry<String, String> entry : this.f19669h.entrySet()) {
                    String key = entry.getKey();
                    if (!this.f19670i.contains(key)) {
                        this.f19670i.add(key);
                        this.f19668g.append("\n");
                        for (int i = 0; i < this.f19665c; i++) {
                            this.f19668g.append("    ");
                        }
                        this.f19668g.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("xmlns:").append((Object) entry.getValue()).toString()).append("=\"").toString()).append(key).toString()).append("\"").toString());
                    }
                }
            }
            this.f19668g.append(" />");
        } else {
            this.f19668g.append("\n");
            for (int i2 = 0; i2 < this.f19665c - 1; i2++) {
                this.f19668g.append("    ");
            }
            this.f19668g.append(new StringBuffer().append(new StringBuffer().append("</").append(this.f19667f).toString()).append(">").toString());
        }
        super.mo4024a();
    }

    /* renamed from: a */
    private String m19513a(String str) {
        String str2;
        if (this.f19669h == null || (str2 = this.f19669h.get(str)) == null) {
            if (str.equals("http://schemas.android.com/apk/res/android")) {
                if (this.f19669h != null) {
                    this.f19669h.put(str, "android");
                    return "android";
                }
                return "android";
            }
            int lastIndexOf = str.lastIndexOf(47);
            if (lastIndexOf == -1 || lastIndexOf >= str.length() - 1) {
                return str;
            }
            String substring = str.substring(lastIndexOf + 1);
            if (this.f19669h != null) {
                this.f19669h.put(str, substring);
                return substring;
            }
            return substring;
        }
        return str2;
    }

    @Override // p060c.p061a.p062a.C0547c
    /* renamed from: a */
    public void mo4020a(String str, String str2, int i) {
        super.mo4020a(str, str2, i);
        if (this.f19669h != null) {
            this.f19669h.put(str2, str);
        }
    }

    /* renamed from: a */
    private String m19512a(int i, int i2, Object obj) {
        if (i == 16) {
            int identifier = this.f19664b.getIdentifier("layout_width", C0497h.f3457a, "android");
            if (identifier == 0) {
                identifier = C0012R.attr.layout_width;
            }
            int identifier2 = this.f19664b.getIdentifier("layout_height", C0497h.f3457a, "android");
            if (identifier2 == 0) {
                identifier2 = C0012R.attr.layout_height;
            }
            int identifier3 = this.f19664b.getIdentifier(MediaStore.MediaColumns.ORIENTATION, C0497h.f3457a, "android");
            if (identifier3 == 0) {
                identifier3 = C0012R.attr.orientation;
            }
            int identifier4 = this.f19664b.getIdentifier("fillType", C0497h.f3457a, "android");
            if (identifier4 == 0) {
                identifier4 = C0012R.attr.fillType;
            }
            int identifier5 = this.f19664b.getIdentifier("strokeLineJoin", C0497h.f3457a, "android");
            if (identifier5 == 0) {
                identifier5 = C0012R.attr.strokeLineJoin;
            }
            int identifier6 = this.f19664b.getIdentifier("strokeLineCap", C0497h.f3457a, "android");
            if (identifier6 == 0) {
                identifier6 = C0012R.attr.strokeLineCap;
            }
            if (i2 == identifier || i2 == identifier2) {
                switch (((Integer) obj).intValue()) {
                    case -2:
                        return "wrap_content";
                    case -1:
                        return "match_parent";
                }
            }
            if (i2 == identifier3) {
                switch (((Integer) obj).intValue()) {
                    case 0:
                        return Slice.HINT_HORIZONTAL;
                    case 1:
                        return "vertical";
                }
            }
            if (i2 == identifier4) {
                switch (((Integer) obj).intValue()) {
                    case 0:
                        return "nonZero";
                    case 1:
                        return "evenOdd";
                }
            }
            if (i2 == identifier5) {
                switch (((Integer) obj).intValue()) {
                    case 0:
                        return "miter";
                    case 1:
                        return "round";
                    case 2:
                        return "bevel";
                }
            }
            if (i2 == identifier6) {
                switch (((Integer) obj).intValue()) {
                    case 0:
                        return "butt";
                    case 1:
                        return "round";
                    case 2:
                        return "square";
                }
            }
        }
        return String.valueOf(C0035a.m199b(i, ((Integer) obj).intValue()));
    }
}
