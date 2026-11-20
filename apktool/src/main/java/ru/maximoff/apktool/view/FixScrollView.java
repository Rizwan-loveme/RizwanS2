package ru.maximoff.apktool.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* loaded from: classes.dex */
public class FixScrollView extends ScrollView {
    public FixScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public FixScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FixScrollView(Context context) {
        super(context);
    }

    @Override // android.widget.ScrollView
    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        return 0;
    }
}
