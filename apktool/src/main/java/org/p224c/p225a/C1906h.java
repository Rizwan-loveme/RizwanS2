package org.p224c.p225a;

import android.bluetooth.BluetoothClass;

/* compiled from: HuffmanTreeGroup.java */
/* renamed from: org.c.a.h */
/* loaded from: classes.dex */
final class C1906h {

    /* renamed from: a */
    int[] f11195a;

    /* renamed from: b */
    int[] f11196b;

    /* renamed from: c */
    private int f11197c;

    C1906h() {
    }

    /* renamed from: a */
    static void m14069a(C1906h c1906h, int i, int i2) {
        c1906h.f11197c = i;
        c1906h.f11195a = new int[i2 * BluetoothClass.Device.AUDIO_VIDEO_VIDEO_MONITOR];
        c1906h.f11196b = new int[i2];
    }

    /* renamed from: a */
    static void m14070a(C1906h c1906h, C1899a c1899a) {
        int length = c1906h.f11196b.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            c1906h.f11196b[i] = i2;
            C1903e.m14044a(c1906h.f11197c, c1906h.f11195a, i2, c1899a);
            i++;
            i2 += BluetoothClass.Device.AUDIO_VIDEO_VIDEO_MONITOR;
        }
    }
}
