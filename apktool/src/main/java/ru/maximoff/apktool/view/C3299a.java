package ru.maximoff.apktool.view;

import android.content.Context;
import android.widget.ExpandableListView;
import ru.maximoff.apktool.util.C3102bd;

/* compiled from: CustomExpListView.java */
/* renamed from: ru.maximoff.apktool.view.a */
/* loaded from: classes.dex */
public class C3299a extends ExpandableListView {
    public C3299a(Context context) {
        super(context);
        m19818a(context);
    }

    /* renamed from: a */
    protected void m19818a(Context context) {
        if (C3102bd.f18273I) {
            setVerticalScrollbarPosition(1);
        } else {
            setVerticalScrollbarPosition(2);
        }
    }
}
