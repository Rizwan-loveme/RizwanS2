package ru.maximoff.apktool.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.p044h.p045a.C0406b;

/* loaded from: classes.dex */
public class CustomViewPager extends C0406b {
    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.p044h.p045a.C0406b, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (IllegalArgumentException e2) {
            return false;
        }
    }
}
