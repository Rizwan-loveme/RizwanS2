package ru.p294a;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* compiled from: NioZipEncoding.java */
/* renamed from: ru.a.h */
/* loaded from: classes.dex */
class C2589h implements InterfaceC2600s {

    /* renamed from: a */
    private final Charset f13438a;

    public C2589h(Charset charset) {
        this.f13438a = charset;
    }

    @Override // ru.p294a.InterfaceC2600s
    /* renamed from: a */
    public boolean mo16078a(String str) {
        CharsetEncoder newEncoder = this.f13438a.newEncoder();
        newEncoder.onMalformedInput(CodingErrorAction.REPORT);
        newEncoder.onUnmappableCharacter(CodingErrorAction.REPORT);
        return newEncoder.canEncode(str);
    }

    @Override // ru.p294a.InterfaceC2600s
    /* renamed from: b */
    public ByteBuffer mo16079b(String str) {
        CharsetEncoder newEncoder = this.f13438a.newEncoder();
        newEncoder.onMalformedInput(CodingErrorAction.REPORT);
        newEncoder.onUnmappableCharacter(CodingErrorAction.REPORT);
        CharBuffer wrap = CharBuffer.wrap(str);
        ByteBuffer allocate = ByteBuffer.allocate(str.length() + ((str.length() + 1) / 2));
        while (true) {
            if (wrap.remaining() <= 0) {
                break;
            }
            CoderResult encode = newEncoder.encode(wrap, allocate, true);
            if (encode.isUnmappable() || encode.isMalformed()) {
                if (encode.length() * 6 > allocate.remaining()) {
                    allocate = AbstractC2601t.m16113a(allocate, allocate.position() + (encode.length() * 6));
                }
                for (int i = 0; i < encode.length(); i++) {
                    AbstractC2601t.m16116a(allocate, wrap.get());
                }
            } else if (encode.isOverflow()) {
                allocate = AbstractC2601t.m16113a(allocate, 0);
            } else if (encode.isUnderflow()) {
                newEncoder.flush(allocate);
                break;
            }
        }
        AbstractC2601t.m16115a(allocate);
        return allocate;
    }

    @Override // ru.p294a.InterfaceC2600s
    /* renamed from: a */
    public String mo16077a(byte[] bArr) {
        return this.f13438a.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(bArr)).toString();
    }
}
