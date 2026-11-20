package jadx.core.p183c.p188c;

import jadx.core.p203d.C1739h;

/* compiled from: GotoNode.java */
/* renamed from: jadx.core.c.c.g */
/* loaded from: classes.dex */
public class C1616g extends AbstractC1627r {

    /* renamed from: a */
    protected final int f10221a;

    public C1616g(int i) {
        this(EnumC1621l.GOTO, i, 0);
    }

    protected C1616g(EnumC1621l enumC1621l, int i, int i2) {
        super(enumC1621l, i2);
        this.f10221a = i;
    }

    /* renamed from: f */
    public int mo12383f() {
        return this.f10221a;
    }

    @Override // jadx.core.p183c.p191d.C1646l
    public String toString() {
        return String.valueOf(super.toString()) + "-> " + C1739h.m13270a(this.f10221a);
    }
}
