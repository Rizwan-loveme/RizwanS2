package com.p124d.p125a;

import android.widget.ExpandableListView;

/* compiled from: IntegerParser.java */
/* renamed from: com.d.a.d */
/* loaded from: classes.dex */
class C1084d {

    /* renamed from: a */
    private int f6981a;

    /* renamed from: b */
    private long f6982b;

    C1084d(long j, int i) {
        this.f6982b = j;
        this.f6981a = i;
    }

    /* renamed from: a */
    int m9059a() {
        return this.f6981a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x004b  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static C1084d m9058a(String str, int i, int i2, boolean z) {
        boolean z2 = false;
        long j = 0;
        if (i >= i2) {
            return null;
        }
        if (z) {
            switch (str.charAt(i)) {
                case '+':
                    i++;
                    break;
                case '-':
                    z2 = true;
                    i++;
                    break;
            }
        }
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt >= '0' && charAt <= '9') {
                if (z2) {
                    j = (j * 10) - (charAt - '0');
                    if (j < -2147483648L) {
                        return null;
                    }
                } else {
                    j = (j * 10) + (charAt - '0');
                    if (j > 2147483647L) {
                        return null;
                    }
                }
            }
            if (i3 != i) {
                return null;
            }
            return new C1084d(j, i3);
        }
        if (i3 != i) {
        }
    }

    /* renamed from: b */
    public int m9060b() {
        return (int) this.f6982b;
    }

    /* renamed from: a */
    static C1084d m9057a(String str, int i, int i2) {
        long j = 0;
        if (i >= i2) {
            return null;
        }
        int i3 = i;
        while (i3 < i2) {
            char charAt = str.charAt(i3);
            if (charAt >= '0' && charAt <= '9') {
                j = (j * 16) + (charAt - '0');
            } else if (charAt >= 'A' && charAt <= 'F') {
                j = (j * 16) + (charAt - 'A') + 10;
            } else {
                if (charAt < 'a' || charAt > 'f') {
                    break;
                }
                j = (j * 16) + (charAt - 'a') + 10;
            }
            if (j > ExpandableListView.PACKED_POSITION_VALUE_NULL) {
                return null;
            }
            i3++;
        }
        if (i3 != i) {
            return new C1084d(j, i3);
        }
        return null;
    }
}
