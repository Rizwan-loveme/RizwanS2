package androidx.p019b.p020a;

import android.database.Cursor;
import android.widget.Filter;

/* compiled from: CursorFilter.java */
/* renamed from: androidx.b.a.b */
/* loaded from: classes.dex */
class C0221b extends Filter {

    /* renamed from: a */
    a f1794a;

    /* compiled from: CursorFilter.java */
    /* renamed from: androidx.b.a.b$a */
    interface a {
        /* renamed from: a */
        Cursor mo1612a();

        /* renamed from: a */
        Cursor mo1412a(CharSequence charSequence);

        /* renamed from: a */
        void mo1416a(Cursor cursor);

        /* renamed from: b */
        CharSequence mo1418b(Cursor cursor);
    }

    C0221b(a aVar) {
        this.f1794a = aVar;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.f1794a.mo1418b((Cursor) obj);
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor mo1412a = this.f1794a.mo1412a(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (mo1412a != null) {
            filterResults.count = mo1412a.getCount();
            filterResults.values = mo1412a;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor mo1612a = this.f1794a.mo1612a();
        if (filterResults.values != null && filterResults.values != mo1612a) {
            this.f1794a.mo1416a((Cursor) filterResults.values);
        }
    }
}
