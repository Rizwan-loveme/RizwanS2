package ru.maximoff.color;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.widget.C0173ao;
import com.srizwan.apktool.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.p306d.C3212b;
import ru.maximoff.apktool.view.C3313o;

/* compiled from: FavAdapter.java */
/* renamed from: ru.maximoff.color.b */
/* loaded from: classes.dex */
public class C3320b extends BaseAdapter {

    /* renamed from: a */
    private Context f21338a;

    /* renamed from: b */
    private EditText f21339b;

    /* renamed from: c */
    private DialogInterfaceC0070b f21340c;

    /* renamed from: d */
    private C3212b f21341d;

    /* renamed from: g */
    private int f21344g = 0;

    /* renamed from: e */
    private Map<Integer, String> f21342e = new LinkedHashMap();

    /* renamed from: f */
    private List<Integer> f21343f = new ArrayList();

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return m20090a(i);
    }

    public C3320b(Context context, EditText editText, C3212b c3212b) {
        this.f21338a = context;
        this.f21339b = editText;
        this.f21341d = c3212b;
        m20084a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m20084a() {
        this.f21343f.clear();
        this.f21342e.clear();
        this.f21342e.putAll(this.f21341d.m19207c());
        Iterator<Integer> it = this.f21342e.keySet().iterator();
        while (it.hasNext()) {
            this.f21343f.add(it.next());
        }
        Collections.sort(this.f21343f);
        Collections.reverse(this.f21343f);
    }

    /* renamed from: a */
    public void m20091a(DialogInterfaceC0070b dialogInterfaceC0070b) {
        this.f21340c = dialogInterfaceC0070b;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f21343f != null) {
            return this.f21343f.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i * 17;
    }

    /* renamed from: a */
    public String m20090a(int i) {
        return this.f21342e != null ? this.f21342e.get(new Integer(i)) : (String) null;
    }

    /* renamed from: b */
    public void m20092b(int i) {
        this.f21341d.m19206b(this.f21342e.get(new Integer(i)));
        m20084a();
        notifyDataSetChanged();
        if (this.f21343f.isEmpty() && this.f21340c != null && this.f21340c.isShowing()) {
            try {
                this.f21340c.cancel();
            } catch (Exception e2) {
            }
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        this.f21344g = 0;
        super.notifyDataSetChanged();
    }

    /* renamed from: a */
    private C3313o m20083a(String str) {
        int i;
        String str2;
        try {
            i = Color.parseColor(str);
            str2 = "";
        } catch (Exception e2) {
            i = -16777216;
            str2 = "?";
        }
        Typeface typeface = Typeface.DEFAULT;
        int m18522a = C3080al.m18522a(this.f21338a, 24);
        return C3313o.m20017a().mo20029a().mo20031a(typeface).mo20040d(2).mo20030a(m18522a).mo20033b(m18522a).mo20041e(m18522a / 2).mo20037c(Color.LTGRAY).mo20034b().mo20032a(str2, i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int intValue = this.f21343f.get(i).intValue();
        String str = this.f21342e.get(new Integer(intValue));
        if (view == null) {
            view = LayoutInflater.from(this.f21338a).inflate(R.layout.files_entry, (ViewGroup) null);
            a aVar2 = new a(this);
            aVar2.f21358a = (ImageView) view.findViewById(R.id.icon);
            aVar2.f21359b = (TextView) view.findViewById(R.id.name);
            aVar2.f21360c = (TextView) view.findViewById(R.id.details);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.f21358a.setImageDrawable(m20083a(str));
        aVar.f21358a.setBackgroundResource(R.drawable.alpha);
        aVar.f21359b.setText(str);
        aVar.f21359b.setTextSize(2, C3102bd.f18332o);
        aVar.f21360c.setVisibility(8);
        view.setOnClickListener(new View.OnClickListener(this, str) { // from class: ru.maximoff.color.b.1

            /* renamed from: a */
            private final C3320b f21345a;

            /* renamed from: b */
            private final String f21346b;

            {
                this.f21345a = this;
                this.f21346b = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                this.f21345a.f21339b.requestFocus();
                this.f21345a.f21339b.setText(this.f21346b);
                this.f21345a.f21339b.setSelection(this.f21346b.length());
                if (this.f21345a.f21340c == null || !this.f21345a.f21340c.isShowing()) {
                    return;
                }
                try {
                    this.f21345a.f21340c.cancel();
                } catch (Exception e2) {
                }
            }
        });
        view.setOnLongClickListener(new AnonymousClass2(this, str, intValue));
        return view;
    }

    /* compiled from: FavAdapter.java */
    /* renamed from: ru.maximoff.color.b$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnLongClickListener {

        /* renamed from: a */
        private final C3320b f21347a;

        /* renamed from: b */
        private final String f21348b;

        /* renamed from: c */
        private final int f21349c;

        AnonymousClass2(C3320b c3320b, String str, int i) {
            this.f21347a = c3320b;
            this.f21348b = str;
            this.f21349c = i;
        }

        /* renamed from: a */
        static C3320b m20093a(AnonymousClass2 anonymousClass2) {
            return anonymousClass2.f21347a;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            int i;
            int i2;
            C0173ao c0173ao = new C0173ao(this.f21347a.f21338a, view);
            if (C3102bd.m18910a(this.f21347a.f21338a, "menu_position", "1").equals("0")) {
                i = 3;
            } else {
                i = 5;
            }
            c0173ao.m1340a(i);
            c0173ao.m1339a().add(0, 1900, 0, this.f21347a.f21338a.getString(R.string.copy)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f21348b) { // from class: ru.maximoff.color.b.2.1

                /* renamed from: a */
                private final AnonymousClass2 f21350a;

                /* renamed from: b */
                private final String f21351b;

                {
                    this.f21350a = this;
                    this.f21351b = r2;
                }

                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    C3112bn.m19002a(AnonymousClass2.m20093a(this.f21350a).f21338a, this.f21351b);
                    return true;
                }
            });
            c0173ao.m1339a().add(0, 1901, 0, this.f21347a.f21338a.getString(R.string.delete)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f21349c) { // from class: ru.maximoff.color.b.2.2

                /* renamed from: a */
                private final AnonymousClass2 f21352a;

                /* renamed from: b */
                private final int f21353b;

                {
                    this.f21352a = this;
                    this.f21353b = r2;
                }

                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    AnonymousClass2.m20093a(this.f21352a).m20092b(this.f21353b);
                    return true;
                }
            });
            if (this.f21349c < this.f21347a.f21343f.size() - 1) {
                i2 = 1903;
                c0173ao.m1339a().add(0, 1902, 0, this.f21347a.f21338a.getString(R.string.f21471up)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f21349c) { // from class: ru.maximoff.color.b.2.3

                    /* renamed from: a */
                    private final AnonymousClass2 f21354a;

                    /* renamed from: b */
                    private final int f21355b;

                    {
                        this.f21354a = this;
                        this.f21355b = r2;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        AnonymousClass2.m20093a(this.f21354a).f21341d.m19203a(this.f21355b, this.f21355b + 1);
                        AnonymousClass2.m20093a(this.f21354a).m20084a();
                        AnonymousClass2.m20093a(this.f21354a).notifyDataSetChanged();
                        return true;
                    }
                });
            } else {
                i2 = 1902;
            }
            if (this.f21349c > 0) {
                int i3 = i2 + 1;
                c0173ao.m1339a().add(0, i2, 0, this.f21347a.f21338a.getString(R.string.down)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f21349c) { // from class: ru.maximoff.color.b.2.4

                    /* renamed from: a */
                    private final AnonymousClass2 f21356a;

                    /* renamed from: b */
                    private final int f21357b;

                    {
                        this.f21356a = this;
                        this.f21357b = r2;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        AnonymousClass2.m20093a(this.f21356a).f21341d.m19203a(this.f21357b, this.f21357b - 1);
                        AnonymousClass2.m20093a(this.f21356a).m20084a();
                        AnonymousClass2.m20093a(this.f21356a).notifyDataSetChanged();
                        return true;
                    }
                });
            }
            c0173ao.m1344c();
            return true;
        }
    }

    /* compiled from: FavAdapter.java */
    /* renamed from: ru.maximoff.color.b$a */
    private class a {

        /* renamed from: a */
        public ImageView f21358a;

        /* renamed from: b */
        public TextView f21359b;

        /* renamed from: c */
        public TextView f21360c;

        /* renamed from: d */
        private final C3320b f21361d;

        public a(C3320b c3320b) {
            this.f21361d = c3320b;
        }
    }
}
