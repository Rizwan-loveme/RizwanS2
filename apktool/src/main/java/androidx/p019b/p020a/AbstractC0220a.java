package androidx.p019b.p020a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.p019b.p020a.C0221b;

/* compiled from: CursorAdapter.java */
/* renamed from: androidx.b.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC0220a extends BaseAdapter implements Filterable, C0221b.a {

    /* renamed from: a */
    protected boolean f1783a;

    /* renamed from: b */
    protected boolean f1784b;

    /* renamed from: c */
    protected Cursor f1785c;

    /* renamed from: d */
    protected Context f1786d;

    /* renamed from: e */
    protected int f1787e;

    /* renamed from: f */
    protected a f1788f;

    /* renamed from: g */
    protected DataSetObserver f1789g;

    /* renamed from: h */
    protected C0221b f1790h;

    /* renamed from: i */
    protected FilterQueryProvider f1791i;

    /* renamed from: a */
    public abstract View mo1414a(Context context, Cursor cursor, ViewGroup viewGroup);

    /* renamed from: a */
    public abstract void mo1417a(View view, Context context, Cursor cursor);

    public AbstractC0220a(Context context, Cursor cursor, boolean z) {
        m1613a(context, cursor, z ? 1 : 2);
    }

    /* renamed from: a */
    void m1613a(Context context, Cursor cursor, int i) {
        if ((i & 1) == 1) {
            i |= 2;
            this.f1784b = true;
        } else {
            this.f1784b = false;
        }
        boolean z = cursor != null;
        this.f1785c = cursor;
        this.f1783a = z;
        this.f1786d = context;
        this.f1787e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f1788f = new a();
            this.f1789g = new b();
        } else {
            this.f1788f = null;
            this.f1789g = null;
        }
        if (z) {
            if (this.f1788f != null) {
                cursor.registerContentObserver(this.f1788f);
            }
            if (this.f1789g != null) {
                cursor.registerDataSetObserver(this.f1789g);
            }
        }
    }

    @Override // androidx.p019b.p020a.C0221b.a
    /* renamed from: a */
    public Cursor mo1612a() {
        return this.f1785c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (!this.f1783a || this.f1785c == null) {
            return 0;
        }
        return this.f1785c.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (!this.f1783a || this.f1785c == null) {
            return null;
        }
        this.f1785c.moveToPosition(i);
        return this.f1785c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.f1783a && this.f1785c != null && this.f1785c.moveToPosition(i)) {
            return this.f1785c.getLong(this.f1787e);
        }
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f1783a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.f1785c.moveToPosition(i)) {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
        if (view == null) {
            view = mo1414a(this.f1786d, this.f1785c, viewGroup);
        }
        mo1417a(view, this.f1786d, this.f1785c);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f1783a) {
            return null;
        }
        this.f1785c.moveToPosition(i);
        if (view == null) {
            view = mo1614b(this.f1786d, this.f1785c, viewGroup);
        }
        mo1417a(view, this.f1786d, this.f1785c);
        return view;
    }

    /* renamed from: b */
    public View mo1614b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return mo1414a(context, cursor, viewGroup);
    }

    /* renamed from: a */
    public void mo1416a(Cursor cursor) {
        Cursor m1616c = m1616c(cursor);
        if (m1616c != null) {
            m1616c.close();
        }
    }

    /* renamed from: c */
    public Cursor m1616c(Cursor cursor) {
        if (cursor == this.f1785c) {
            return null;
        }
        Cursor cursor2 = this.f1785c;
        if (cursor2 != null) {
            if (this.f1788f != null) {
                cursor2.unregisterContentObserver(this.f1788f);
            }
            if (this.f1789g != null) {
                cursor2.unregisterDataSetObserver(this.f1789g);
            }
        }
        this.f1785c = cursor;
        if (cursor != null) {
            if (this.f1788f != null) {
                cursor.registerContentObserver(this.f1788f);
            }
            if (this.f1789g != null) {
                cursor.registerDataSetObserver(this.f1789g);
            }
            this.f1787e = cursor.getColumnIndexOrThrow("_id");
            this.f1783a = true;
            notifyDataSetChanged();
            return cursor2;
        }
        this.f1787e = -1;
        this.f1783a = false;
        notifyDataSetInvalidated();
        return cursor2;
    }

    /* renamed from: b */
    public CharSequence mo1418b(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    /* renamed from: a */
    public Cursor mo1412a(CharSequence charSequence) {
        return this.f1791i != null ? this.f1791i.runQuery(charSequence) : this.f1785c;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f1790h == null) {
            this.f1790h = new C0221b(this);
        }
        return this.f1790h;
    }

    /* renamed from: b */
    protected void m1615b() {
        if (this.f1784b && this.f1785c != null && !this.f1785c.isClosed()) {
            this.f1783a = this.f1785c.requery();
        }
    }

    /* compiled from: CursorAdapter.java */
    /* renamed from: androidx.b.a.a$a */
    private class a extends ContentObserver {
        a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            AbstractC0220a.this.m1615b();
        }
    }

    /* compiled from: CursorAdapter.java */
    /* renamed from: androidx.b.a.a$b */
    private class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            AbstractC0220a.this.f1783a = true;
            AbstractC0220a.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            AbstractC0220a.this.f1783a = false;
            AbstractC0220a.this.notifyDataSetInvalidated();
        }
    }
}
