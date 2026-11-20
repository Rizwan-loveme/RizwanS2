package com.p065b.p086b.p110h;

import android.widget.ExpandableListView;

/* compiled from: Unsigned.java */
/* renamed from: com.b.b.h.ab */
/* loaded from: classes.dex */
public final class C1009ab {
    /* renamed from: a */
    public static int m8474a(short s, short s2) {
        if (s == s2) {
            return 0;
        }
        return (s & 65535) < (65535 & s2) ? -1 : 1;
    }

    /* renamed from: a */
    public static int m8473a(int i, int i2) {
        if (i == i2) {
            return 0;
        }
        return (((long) i) & ExpandableListView.PACKED_POSITION_VALUE_NULL) < (((long) i2) & ExpandableListView.PACKED_POSITION_VALUE_NULL) ? -1 : 1;
    }
}
