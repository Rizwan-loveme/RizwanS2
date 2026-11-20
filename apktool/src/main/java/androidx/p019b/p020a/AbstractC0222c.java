package androidx.p019b.p020a;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ResourceCursorAdapter.java */
/* renamed from: androidx.b.a.c */
/* loaded from: classes.dex */
public abstract class AbstractC0222c extends AbstractC0220a {

    /* renamed from: j */
    private int f1795j;

    /* renamed from: k */
    private int f1796k;

    /* renamed from: l */
    private LayoutInflater f1797l;

    @Deprecated
    public AbstractC0222c(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f1796k = i;
        this.f1795j = i;
        this.f1797l = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override // androidx.p019b.p020a.AbstractC0220a
    /* renamed from: a */
    public View mo1414a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1797l.inflate(this.f1795j, viewGroup, false);
    }

    @Override // androidx.p019b.p020a.AbstractC0220a
    /* renamed from: b */
    public View mo1614b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1797l.inflate(this.f1796k, viewGroup, false);
    }
}
