package com.p159h.p160a.p162b;

import java.util.ArrayList;

/* compiled from: Document.java */
/* renamed from: com.h.a.b.g */
/* loaded from: classes.dex */
public class C1385g extends C1399u {

    /* renamed from: f */
    private boolean f9018f = false;

    /* renamed from: g */
    private a f9019g;

    /* renamed from: h */
    private ArrayList<Integer> f9020h;

    /* compiled from: Document.java */
    /* renamed from: com.h.a.b.g$a */
    public interface a {
        /* renamed from: a */
        int mo10864a(char c2);

        int getRowWidth();
    }

    public C1385g(a aVar) {
        this.f9019g = aVar;
        m11016q();
    }

    /* renamed from: a */
    public void m11022a(CharSequence charSequence) {
        int i = 1;
        int length = charSequence.length();
        char[] cArr = new char[C1399u.m11139g(length)];
        for (int i2 = 0; i2 < length; i2++) {
            cArr[i2] = charSequence.charAt(i2);
            if (charSequence.charAt(i2) == '\n') {
                i++;
            }
        }
        m11141a(cArr, length, i);
    }

    /* renamed from: q */
    private void m11016q() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(new Integer(0));
        this.f9020h = arrayList;
    }

    /* renamed from: a */
    public void m11021a(a aVar) {
        this.f9019g = aVar;
    }

    /* renamed from: a */
    public void m11023a(boolean z) {
        if (this.f9018f) {
            if (z) {
                return;
            }
        } else if (!z) {
            return;
        }
        this.f9018f = z;
        m11027b();
    }

    /* renamed from: a */
    public boolean m11025a() {
        return this.f9018f;
    }

    @Override // com.p159h.p160a.p162b.C1399u
    /* renamed from: a */
    public synchronized void mo11020a(int i, int i2, long j, boolean z) {
        super.mo11020a(i, i2, j, z);
        m11013a(m11031e(i), m11018s(i), -i2);
    }

    @Override // com.p159h.p160a.p162b.C1399u
    /* renamed from: a */
    public synchronized void mo11024a(char[] cArr, int i, long j, boolean z) {
        super.mo11024a(cArr, i, j, z);
        m11013a(m11031e(i), m11018s(cArr.length + i), cArr.length);
    }

    @Override // com.p159h.p160a.p162b.C1399u
    /* renamed from: a */
    synchronized void mo11019a(int i) {
        super.mo11019a(i);
        if (i != 0) {
            m11013a(m11031e(i > 0 ? this.f9143b - i : this.f9143b), m11018s(this.f9143b), i);
        }
    }

    /* renamed from: s */
    private int m11018s(int i) {
        int p = m11162p(i);
        while (p < this.f9142a.length) {
            if (p == this.f9143b) {
                p = this.f9144c;
            }
            if (this.f9142a[p] == '\n' || this.f9142a[p] == 65535) {
                break;
            }
            p++;
        }
        return m11164q(p) + 1;
    }

    /* renamed from: a */
    private void m11013a(int i, int i2, int i3) {
        if (i > 0) {
            i--;
        }
        if (i < this.f9020h.size() && i >= 0) {
            int intValue = this.f9020h.get(i).intValue();
            m11012a(i + 1, i2 - i3);
            m11014b(i + 1, i3);
            m11015b(i + 1, intValue, i2);
        }
    }

    /* renamed from: a */
    private void m11012a(int i, int i2) {
        while (i < this.f9020h.size() && this.f9020h.get(i).intValue() <= i2) {
            this.f9020h.remove(i);
        }
    }

    /* renamed from: b */
    private void m11014b(int i, int i2) {
        while (i < this.f9020h.size()) {
            this.f9020h.set(i, new Integer(this.f9020h.get(i).intValue() + i2));
            i++;
        }
    }

    /* renamed from: b */
    public void m11027b() {
        m11016q();
        if (this.f9018f && !m11017r()) {
            if (this.f9019g.getRowWidth() > 0) {
                C1401w.m11173a("Text field has non-zero width but still too small for word wrap");
                return;
            }
            return;
        }
        m11015b(1, 0, m11142d());
    }

    /* renamed from: r */
    private boolean m11017r() {
        return this.f9019g.getRowWidth() >= this.f9019g.mo10864a('M') * 2;
    }

    /* renamed from: b */
    private void m11015b(int i, int i2, int i3) {
        int i4;
        if (!this.f9018f) {
            int p = m11162p(i2);
            int p2 = m11162p(i3);
            ArrayList arrayList = new ArrayList();
            while (p < p2) {
                if (p == this.f9143b) {
                    p = this.f9144c;
                }
                if (this.f9142a[p] == '\n') {
                    arrayList.add(new Integer(m11164q(p) + 1));
                }
                p++;
            }
            this.f9020h.addAll(i, arrayList);
            return;
        }
        if (!m11017r()) {
            C1401w.m11173a("Not enough space to do word wrap");
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        int p3 = m11162p(i2);
        int p4 = m11162p(i3);
        int rowWidth = this.f9019g.getRowWidth();
        int i5 = rowWidth;
        int i6 = 0;
        int i7 = i2;
        while (p3 < p4) {
            int i8 = p3 == this.f9143b ? this.f9144c : p3;
            char c2 = this.f9142a[i8];
            i6 += this.f9019g.mo10864a(c2);
            if (c2 == ' ' || c2 == '\t' || c2 == '\n' || c2 == 65535) {
                if (i6 <= i5) {
                    i4 = i5 - i6;
                } else if (i6 > rowWidth) {
                    int p5 = m11162p(i7);
                    if (i7 != i2 && (arrayList2.isEmpty() || i7 != ((Integer) arrayList2.get(arrayList2.size() - 1)).intValue())) {
                        arrayList2.add(new Integer(i7));
                    }
                    int i9 = p5;
                    int i10 = rowWidth;
                    while (i9 <= i8) {
                        if (i9 == this.f9143b) {
                            i9 = this.f9144c;
                        }
                        int mo10864a = this.f9019g.mo10864a(this.f9142a[i9]);
                        if (mo10864a > i10) {
                            arrayList2.add(new Integer(m11164q(i9)));
                            i10 = rowWidth - mo10864a;
                        } else {
                            i10 -= mo10864a;
                        }
                        i9++;
                    }
                    i4 = i10;
                } else {
                    arrayList2.add(new Integer(i7));
                    i4 = rowWidth - i6;
                }
                i6 = 0;
                i7 = m11164q(i8) + 1;
            } else {
                i4 = i5;
            }
            if (c2 == '\n') {
                arrayList2.add(new Integer(i7));
                i5 = rowWidth;
            } else {
                i5 = i4;
            }
            p3 = i8 + 1;
        }
        this.f9020h.addAll(i, arrayList2);
    }

    /* renamed from: b */
    public String m11026b(int i) {
        int m11029c = m11029c(i);
        if (m11029c == 0) {
            return new String();
        }
        return subSequence(this.f9020h.get(i).intValue(), m11029c).toString();
    }

    /* renamed from: c */
    public int m11029c(int i) {
        if (m11032f(i)) {
            return 0;
        }
        if (i != this.f9020h.size() - 1) {
            return this.f9020h.get(i + 1).intValue() - this.f9020h.get(i).intValue();
        }
        return m11142d() - this.f9020h.get(i).intValue();
    }

    /* renamed from: c */
    public int m11028c() {
        return this.f9020h.size();
    }

    /* renamed from: d */
    public int m11030d(int i) {
        if (m11032f(i)) {
            return -1;
        }
        return this.f9020h.get(i).intValue();
    }

    /* renamed from: e */
    public int m11031e(int i) {
        if (!m11161o(i)) {
            return -1;
        }
        int i2 = 0;
        int size = this.f9020h.size() - 1;
        while (size >= i2) {
            int i3 = (i2 + size) / 2;
            int intValue = i3 + 1 < this.f9020h.size() ? this.f9020h.get(i3 + 1).intValue() : m11142d();
            if (i >= this.f9020h.get(i3).intValue() && i < intValue) {
                return i3;
            }
            if (i >= intValue) {
                i2 = i3 + 1;
            } else {
                size = i3 - 1;
            }
        }
        return -1;
    }

    /* renamed from: f */
    protected boolean m11032f(int i) {
        return i < 0 || i >= this.f9020h.size();
    }
}
