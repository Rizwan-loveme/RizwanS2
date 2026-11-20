package com.p140g.p152b.p153a.p154a;

import com.p140g.p141a.C1241c;
import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.C1368i;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import java.lang.reflect.Array;

/* compiled from: Constant.java */
/* renamed from: com.g.b.a.a.e */
/* loaded from: classes.dex */
public class C1307e extends AbstractC1322t.a {

    /* renamed from: a */
    public static final Object f8533a = new Object();

    /* renamed from: b */
    public Object f8534b;

    public C1307e(Object obj) {
        super(AbstractC1322t.e.CONSTANT);
        this.f8534b = obj;
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10480a() {
        return new C1307e(this.f8534b);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: a */
    public AbstractC1322t mo10481a(C1339c c1339c) {
        return new C1307e(this.f8534b);
    }

    @Override // com.p140g.p152b.p153a.p154a.AbstractC1322t
    /* renamed from: b */
    public String mo10482b() {
        if (f8533a == this.f8534b) {
            return "null";
        }
        if (this.f8534b == null) {
            return "NULL";
        }
        if (this.f8534b instanceof Number) {
            if (this.f8534b instanceof Float) {
                return new StringBuffer().append(this.f8534b.toString()).append("F").toString();
            }
            if (this.f8534b instanceof Long) {
                return new StringBuffer().append(this.f8534b.toString()).append("L").toString();
            }
            return this.f8534b.toString();
        }
        if (this.f8534b instanceof String) {
            StringBuffer stringBuffer = new StringBuffer();
            C1368i.m10771a(stringBuffer, (String) this.f8534b);
            return stringBuffer.toString();
        }
        if (this.f8534b instanceof C1241c) {
            return new StringBuffer().append(C1368i.m10770a(((C1241c) this.f8534b).f8048a)).append(".class").toString();
        }
        if (this.f8534b.getClass().isArray()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            int length = Array.getLength(this.f8534b);
            for (int i = 0; i < length; i++) {
                sb.append(Array.get(this.f8534b, i)).append(",");
            }
            if (length > 0) {
                sb.setLength(sb.length() - 1);
            }
            sb.append("]");
            return sb.toString();
        }
        return new StringBuffer().append("").append(this.f8534b).toString();
    }
}
