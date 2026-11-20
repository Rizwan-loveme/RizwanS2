package com.p065b.p086b.p095c.p099c;

import java.util.Iterator;

/* compiled from: MemberIdsSection.java */
/* renamed from: com.b.b.c.c.ac */
/* loaded from: classes.dex */
public abstract class AbstractC0829ac extends AbstractC0846at {
    public AbstractC0829ac(String str, C0860m c0860m) {
        super(str, c0860m, 4);
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0846at
    /* renamed from: b */
    protected void mo7212b() {
        int i = 0;
        Iterator<? extends AbstractC0872y> it = mo7221a().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                ((AbstractC0828ab) it.next()).m7434a(i2);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
