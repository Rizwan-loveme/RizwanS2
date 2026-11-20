package jadx.core.p183c.p184a.p186b;

import jadx.core.p183c.p184a.AbstractC1584d;

/* compiled from: LineAttrNode.java */
/* renamed from: jadx.core.c.a.b.k */
/* loaded from: classes.dex */
public abstract class AbstractC1577k extends AbstractC1584d implements Comparable<AbstractC1577k> {

    /* renamed from: a */
    private int f10073a;

    /* renamed from: b */
    private int f10074b;

    /* renamed from: d */
    public int m12122d() {
        return this.f10073a;
    }

    /* renamed from: a */
    public void m12118a(int i) {
        this.f10073a = i;
    }

    /* renamed from: e */
    public int m12123e() {
        return this.f10074b;
    }

    /* renamed from: b */
    public void m12121b(int i) {
        this.f10074b = i;
    }

    /* renamed from: a */
    public void m12119a(AbstractC1577k abstractC1577k) {
        m12118a(abstractC1577k.m12122d());
        m12121b(abstractC1577k.m12123e());
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(AbstractC1577k abstractC1577k) {
        return m12122d() - abstractC1577k.m12122d();
    }
}
