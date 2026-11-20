package p046b.p047a.p050c.p051a.p052a;

import android.icu.text.PluralRules;
import org.xmlpull.p291v1.XmlSerializer;
import p046b.p047a.p050c.p051a.C0494e;
import p046b.p047a.p050c.p055d.C0516b;
import p046b.p047a.p050c.p055d.InterfaceC0515a;
import p046b.p059d.C0538c;
import p046b.p059d.InterfaceC0541f;

/* compiled from: ResPluralsValue.java */
/* renamed from: b.a.c.a.a.p */
/* loaded from: classes.dex */
public class C0484p extends C0471c implements InterfaceC0515a {

    /* renamed from: c */
    private static final String[] f3400c = {"other", PluralRules.KEYWORD_ZERO, PluralRules.KEYWORD_ONE, PluralRules.KEYWORD_TWO, PluralRules.KEYWORD_FEW, PluralRules.KEYWORD_MANY};

    /* renamed from: b */
    private final AbstractC0486r[] f3401b;

    C0484p(C0485q c0485q, C0538c<Integer, AbstractC0486r>[] c0538cArr, boolean z, InterfaceC0541f interfaceC0541f) {
        super(c0485q, z, interfaceC0541f);
        this.f3401b = new AbstractC0486r[6];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= c0538cArr.length) {
                return;
            }
            this.f3401b[c0538cArr[i2].f3632a.intValue() - 16777220] = c0538cArr[i2].f3633b;
            i = i2 + 1;
        }
    }

    @Override // p046b.p047a.p050c.p051a.p052a.C0471c, p046b.p047a.p050c.p055d.InterfaceC0515a
    /* renamed from: a */
    public void mo3626a(XmlSerializer xmlSerializer, C0494e c0494e) {
        xmlSerializer.startTag((String) null, "plurals");
        xmlSerializer.attribute((String) null, "name", c0494e.m3700c().m3693e());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f3401b.length) {
                AbstractC0486r abstractC0486r = this.f3401b[i2];
                if (abstractC0486r != null) {
                    xmlSerializer.startTag((String) null, "item");
                    xmlSerializer.attribute((String) null, "quantity", f3400c[i2]);
                    xmlSerializer.text(C0516b.m3875e(abstractC0486r.m3652j()));
                    xmlSerializer.endTag((String) null, "item");
                }
                i = i2 + 1;
            } else {
                xmlSerializer.endTag((String) null, "plurals");
                return;
            }
        }
    }
}
