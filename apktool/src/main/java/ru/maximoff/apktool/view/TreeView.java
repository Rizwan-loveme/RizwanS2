package ru.maximoff.apktool.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import ru.maximoff.apktool.util.C3102bd;

/* loaded from: classes.dex */
public class TreeView<T> extends CustomListView {

    /* renamed from: a */
    private final C3315q<T> f20817a;

    public TreeView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20817a = new C3315q<>(context);
        setAdapter((ListAdapter) this.f20817a);
        setOnItemClickListener(this.f20817a);
        setFocusable(true);
        setFastScrollEnabled(C3102bd.f18314av);
    }

    public void setAdapter(InterfaceC3314p<T> interfaceC3314p) {
        this.f20817a.m20043a(interfaceC3314p);
    }
}
