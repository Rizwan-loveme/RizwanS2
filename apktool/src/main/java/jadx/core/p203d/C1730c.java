package jadx.core.p203d;

import java.util.BitSet;

/* compiled from: EmptyBitSet.java */
/* renamed from: jadx.core.d.c */
/* loaded from: classes.dex */
public final class C1730c extends BitSet {

    /* renamed from: a */
    public static final BitSet f10580a = new C1730c();

    public C1730c() {
        super(0);
    }

    @Override // java.util.BitSet
    public int cardinality() {
        return 0;
    }

    @Override // java.util.BitSet
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.BitSet
    public int nextSetBit(int i) {
        return -1;
    }

    @Override // java.util.BitSet
    public int length() {
        return 0;
    }

    @Override // java.util.BitSet
    public int size() {
        return 0;
    }

    @Override // java.util.BitSet
    public void set(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.BitSet
    public void set(int i, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.BitSet
    public void set(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.BitSet
    public void set(int i, int i2, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.BitSet
    public boolean get(int i) {
        return false;
    }

    @Override // java.util.BitSet
    public BitSet get(int i, int i2) {
        return f10580a;
    }

    @Override // java.util.BitSet
    public void and(BitSet bitSet) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.BitSet
    /* renamed from: or */
    public void mo13226or(BitSet bitSet) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.BitSet
    public void xor(BitSet bitSet) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.BitSet
    public void andNot(BitSet bitSet) {
        throw new UnsupportedOperationException();
    }
}
