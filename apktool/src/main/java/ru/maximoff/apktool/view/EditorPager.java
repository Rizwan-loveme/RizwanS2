package ru.maximoff.apktool.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.p044h.p045a.C0406b;

/* loaded from: classes.dex */
public class EditorPager extends C0406b {
    public EditorPager(Context context) {
        super(context);
        setFocusable(true);
    }

    public EditorPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFocusable(true);
    }

    @Override // androidx.p044h.p045a.C0406b, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (getCurrentItem() <= 0 && getChildCount() <= 0) {
            return false;
        }
        try {
            switch (motionEvent.getAction()) {
                case 0:
                    float width = getWidth();
                    float x = motionEvent.getX();
                    if (x > 10 || x < width - 10) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                    }
                    break;
                case 1:
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
            }
            z = super.onTouchEvent(motionEvent);
            return z;
        } catch (Error e2) {
            return z;
        } catch (Exception e3) {
            return z;
        }
    }

    @Override // androidx.p044h.p045a.C0406b, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (getCurrentItem() <= 0 && getChildCount() <= 0) {
            return false;
        }
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Error e2) {
            return false;
        } catch (Exception e3) {
            return false;
        }
    }
}
