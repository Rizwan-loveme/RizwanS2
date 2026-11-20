package org.p226d.p233b.p264i;

import com.p129f.p130a.p133c.AbstractC1163ap;
import java.util.Collection;
import java.util.Iterator;
import org.p226d.p233b.p238b.AbstractC1994b;
import org.p226d.p233b.p250e.InterfaceC2175b;
import org.p226d.p233b.p250e.p254c.InterfaceC2237b;
import org.p226d.p233b.p250e.p254c.InterfaceC2238c;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;

/* compiled from: EncodedValueWriter.java */
/* renamed from: org.d.b.i.i */
/* loaded from: classes.dex */
public abstract class AbstractC2432i<StringKey, TypeKey, FieldRefKey extends InterfaceC2237b, MethodRefKey extends InterfaceC2240e, AnnotationElement extends InterfaceC2175b, ProtoRefKey, MethodHandleKey extends InterfaceC2238c, EncodedValue> {

    /* renamed from: a */
    private final C2429f f12872a;

    /* renamed from: b */
    private final InterfaceC2442s<StringKey, ?> f12873b;

    /* renamed from: c */
    private final InterfaceC2444u<?, TypeKey, ?> f12874c;

    /* renamed from: d */
    private final InterfaceC2433j<?, ?, FieldRefKey, ?> f12875d;

    /* renamed from: e */
    private final InterfaceC2437n<?, ?, ?, MethodRefKey, ?> f12876e;

    /* renamed from: f */
    private final InterfaceC2441r<?, ?, ProtoRefKey, ?> f12877f;

    /* renamed from: g */
    private final InterfaceC2436m<MethodHandleKey, ?, ?> f12878g;

    /* renamed from: h */
    private final InterfaceC2394a<StringKey, TypeKey, ?, AnnotationElement, EncodedValue> f12879h;

    /* renamed from: a */
    protected abstract void mo15412a(EncodedValue encodedvalue);

    public AbstractC2432i(C2429f c2429f, InterfaceC2442s<StringKey, ?> interfaceC2442s, InterfaceC2444u<?, TypeKey, ?> interfaceC2444u, InterfaceC2433j<?, ?, FieldRefKey, ?> interfaceC2433j, InterfaceC2437n<?, ?, ?, MethodRefKey, ?> interfaceC2437n, InterfaceC2441r<?, ?, ProtoRefKey, ?> interfaceC2441r, InterfaceC2436m<MethodHandleKey, ?, ?> interfaceC2436m, InterfaceC2394a<StringKey, TypeKey, ?, AnnotationElement, EncodedValue> interfaceC2394a) {
        this.f12872a = c2429f;
        this.f12873b = interfaceC2442s;
        this.f12874c = interfaceC2444u;
        this.f12875d = interfaceC2433j;
        this.f12876e = interfaceC2437n;
        this.f12877f = interfaceC2441r;
        this.f12878g = interfaceC2436m;
        this.f12879h = interfaceC2394a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public void m15420a(TypeKey typekey, Collection<? extends AnnotationElement> collection) {
        this.f12872a.m15359a(29, 0);
        this.f12872a.m15371e(this.f12874c.mo15172B(typekey));
        this.f12872a.m15371e(collection.size());
        for (InterfaceC2175b interfaceC2175b : AbstractC1163ap.m9956a(AbstractC1994b.f11568a).m9961b(collection)) {
            this.f12872a.m15371e(this.f12873b.mo15172B(this.f12879h.mo15157d(interfaceC2175b)));
            mo15412a((AbstractC2432i<StringKey, TypeKey, FieldRefKey, MethodRefKey, AnnotationElement, ProtoRefKey, MethodHandleKey, EncodedValue>) this.f12879h.mo15158e(interfaceC2175b));
        }
    }

    /* renamed from: a */
    public void m15421a(Collection<? extends EncodedValue> collection) {
        this.f12872a.m15359a(28, 0);
        this.f12872a.m15371e(collection.size());
        Iterator<? extends EncodedValue> it = collection.iterator();
        while (it.hasNext()) {
            mo15412a((AbstractC2432i<StringKey, TypeKey, FieldRefKey, MethodRefKey, AnnotationElement, ProtoRefKey, MethodHandleKey, EncodedValue>) it.next());
        }
    }

    /* renamed from: a */
    public void m15425a(boolean z) {
        this.f12872a.m15359a(31, z ? 1 : 0);
    }

    /* renamed from: a */
    public void m15414a(byte b2) {
        this.f12872a.m15365b(0, (int) b2);
    }

    /* renamed from: a */
    public void m15415a(char c2) {
        this.f12872a.m15368c(3, c2);
    }

    /* renamed from: a */
    public void m15416a(double d2) {
        this.f12872a.m15357a(17, d2);
    }

    /* renamed from: a */
    public void m15422a(FieldRefKey fieldrefkey) {
        this.f12872a.m15368c(27, this.f12875d.mo15172B(fieldrefkey));
    }

    /* renamed from: b */
    public void m15428b(FieldRefKey fieldrefkey) {
        this.f12872a.m15368c(25, this.f12875d.mo15172B(fieldrefkey));
    }

    /* renamed from: a */
    public void m15417a(float f2) {
        this.f12872a.m15358a(16, f2);
    }

    /* renamed from: a */
    public void m15418a(int i) {
        this.f12872a.m15365b(4, i);
    }

    /* renamed from: a */
    public void m15419a(long j) {
        this.f12872a.m15360a(6, j);
    }

    /* renamed from: a */
    public void m15424a(MethodRefKey methodrefkey) {
        this.f12872a.m15368c(26, this.f12876e.mo15172B(methodrefkey));
    }

    /* renamed from: a */
    public void m15413a() {
        this.f12872a.write(30);
    }

    /* renamed from: b */
    public void m15426b(int i) {
        this.f12872a.m15365b(2, i);
    }

    /* renamed from: b */
    public void m15427b(StringKey stringkey) {
        this.f12872a.m15368c(23, this.f12873b.mo15172B(stringkey));
    }

    /* renamed from: c */
    public void m15429c(TypeKey typekey) {
        this.f12872a.m15368c(24, this.f12874c.mo15172B(typekey));
    }

    /* renamed from: d */
    public void m15430d(ProtoRefKey protorefkey) {
        this.f12872a.m15368c(21, this.f12877f.mo15172B(protorefkey));
    }

    /* renamed from: a */
    public void m15423a(MethodHandleKey methodhandlekey) {
        this.f12872a.m15368c(22, this.f12878g.mo15172B(methodhandlekey));
    }
}
