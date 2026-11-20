package com.p065b.p086b.p100d;

import com.p065b.p086b.p100d.p101a.AbstractC0880f;

/* compiled from: CodeReader.java */
/* renamed from: com.b.b.d.e */
/* loaded from: classes.dex */
public final class C0897e {

    /* renamed from: a */
    private a f5439a = null;

    /* renamed from: b */
    private a f5440b = null;

    /* renamed from: c */
    private a f5441c = null;

    /* renamed from: d */
    private a f5442d = null;

    /* renamed from: e */
    private a f5443e = null;

    /* compiled from: CodeReader.java */
    /* renamed from: com.b.b.d.e$a */
    public interface a {
        /* renamed from: a */
        void mo7582a(AbstractC0880f[] abstractC0880fArr, AbstractC0880f abstractC0880f);
    }

    /* renamed from: a */
    public void m7576a(a aVar) {
        this.f5439a = aVar;
        this.f5440b = aVar;
        this.f5441c = aVar;
        this.f5442d = aVar;
        this.f5443e = aVar;
    }

    /* renamed from: b */
    public void m7578b(a aVar) {
        this.f5440b = aVar;
    }

    /* renamed from: c */
    public void m7579c(a aVar) {
        this.f5441c = aVar;
    }

    /* renamed from: d */
    public void m7580d(a aVar) {
        this.f5442d = aVar;
    }

    /* renamed from: e */
    public void m7581e(a aVar) {
        this.f5443e = aVar;
    }

    /* renamed from: a */
    public void m7577a(AbstractC0880f[] abstractC0880fArr) {
        for (AbstractC0880f abstractC0880f : abstractC0880fArr) {
            if (abstractC0880f != null) {
                m7575a(abstractC0880fArr, abstractC0880f);
            }
        }
    }

    /* renamed from: a */
    private void m7575a(AbstractC0880f[] abstractC0880fArr, AbstractC0880f abstractC0880f) {
        a aVar = null;
        switch (C0905m.m7688d(abstractC0880f.m7471b())) {
            case STRING_REF:
                aVar = this.f5440b;
                break;
            case TYPE_REF:
                aVar = this.f5441c;
                break;
            case FIELD_REF:
                aVar = this.f5442d;
                break;
            case METHOD_REF:
                aVar = this.f5443e;
                break;
        }
        if (aVar == null) {
            aVar = this.f5439a;
        }
        if (aVar != null) {
            aVar.mo7582a(abstractC0880fArr, abstractC0880f);
        }
    }
}
