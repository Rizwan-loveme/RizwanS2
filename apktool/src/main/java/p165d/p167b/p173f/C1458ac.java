package p165d.p167b.p173f;

import java.math.BigInteger;
import java.io.OutputStream;
import p165d.p167b.p172e.C1449l;

/* compiled from: DeltaCRLIndicatorExtension.java */
/* renamed from: d.b.f.ac */
/* loaded from: classes.dex */
public class C1458ac extends C1511k {
    public C1458ac(int i) {
        super(C1481az.f9489h, true, BigInteger.valueOf(i), "DeltaCRLIndicator", "Base CRL Number");
    }

    public C1458ac(BigInteger bigInteger) {
        super(C1481az.f9489h, true, bigInteger, "DeltaCRLIndicator", "Base CRL Number");
    }

    public C1458ac(Boolean bool, Object obj) {
        super(C1481az.f9489h, Boolean.valueOf(bool.booleanValue()), obj, "DeltaCRLIndicator", "Base CRL Number");
    }

    @Override // p165d.p167b.p173f.C1511k, p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        new C1449l();
        super.m11660a(outputStream, C1481az.f9489h, true);
    }
}
