package ru.maximoff.apktool.util;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
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
import ru.maximoff.apktool.util.C3093ay;
import ru.maximoff.apktool.view.CustomListView;

/* compiled from: QuickPanel.java */
/* renamed from: ru.maximoff.apktool.util.ax */
/* loaded from: classes.dex */
public class C3092ax extends CustomListView {

    /* renamed from: a */
    private a f18134a;

    /* renamed from: b */
    private C3093ay f18135b;

    /* renamed from: c */
    private DialogInterfaceC0070b f18136c;

    /* renamed from: d */
    private Context f18137d;

    public C3092ax(Context context) {
        super(context);
        setFastScrollEnabled(C3102bd.f18314av);
        this.f18137d = context;
        this.f18135b = new C3093ay(this.f18137d);
        this.f18134a = new a(this);
        setAdapter((ListAdapter) this.f18134a);
    }

    public void setDialog(DialogInterfaceC0070b dialogInterfaceC0070b) {
        this.f18136c = dialogInterfaceC0070b;
        this.f18134a.notifyDataSetChanged();
    }

    /* renamed from: a */
    public void m18761a() {
        this.f18134a.m18765a(-1, (C3093ay.a) null);
    }

    /* compiled from: QuickPanel.java */
    /* renamed from: ru.maximoff.apktool.util.ax$a */
    private class a extends BaseAdapter {

        /* renamed from: a */
        private List<Integer> f18138a = new ArrayList();

        /* renamed from: b */
        private Map<Integer, String> f18139b = new LinkedHashMap();

        /* renamed from: c */
        private final C3092ax f18140c;

        /* renamed from: c */
        static C3092ax m18769c(a aVar) {
            return aVar.f18140c;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return m18770a(i);
        }

        public a(C3092ax c3092ax) {
            this.f18140c = c3092ax;
            m18763a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m18763a() {
            this.f18138a.clear();
            this.f18139b.clear();
            this.f18140c.f18135b.m18782b();
            this.f18139b.putAll(this.f18140c.f18135b.m18787f());
            Iterator<Integer> it = this.f18139b.keySet().iterator();
            while (it.hasNext()) {
                this.f18138a.add(it.next());
            }
            Collections.sort(this.f18138a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m18764a(int i, int i2) {
            this.f18140c.f18135b.m18779a(i, i2);
            m18763a();
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f18138a != null) {
                return this.f18138a.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        /* renamed from: a */
        public String m18770a(int i) {
            return this.f18139b != null ? this.f18139b.get(new Integer(i)) : (String) null;
        }

        /* renamed from: b */
        public void m18771b(int i) {
            this.f18140c.f18135b.m18783b(this.f18139b.get(new Integer(i)));
            m18763a();
            notifyDataSetChanged();
            if (this.f18138a.isEmpty() && this.f18140c.f18136c != null && this.f18140c.f18136c.isShowing()) {
                try {
                    this.f18140c.f18136c.cancel();
                } catch (Exception e2) {
                }
            }
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C3436a c3436a;
            int intValue = this.f18138a.get(i).intValue();
            if (view == null) {
                view = ((LayoutInflater) this.f18140c.f18137d.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.panel_entry, (ViewGroup) null);
                c3436a = new C3436a(this);
                c3436a.f18177d = (ImageView) view.findViewById(R.id.panelentryImageView1);
                c3436a.f18178e = (ImageView) view.findViewById(R.id.panelentryImageView2);
                c3436a.f18175b = (TextView) view.findViewById(R.id.panelentryTextView1);
                c3436a.f18176c = (TextView) view.findViewById(R.id.panelentryTextView2);
                view.setTag(c3436a);
            } else {
                c3436a = (C3436a) view.getTag();
            }
            c3436a.f18174a = intValue;
            C3093ay.a m18774c = C3093ay.m18774c(this.f18139b.get(new Integer(intValue)));
            if (m18774c != null) {
                String m18790a = m18774c.m18790a();
                c3436a.f18175b.setTextSize(2, C3102bd.f18332o);
                c3436a.f18176c.setTextSize(2, C3102bd.f18332o - 2);
                TextView textView = c3436a.f18175b;
                if (m18790a.equals("\t") || m18790a.equals("    ")) {
                    m18790a = "⇥";
                }
                textView.setText(m18790a);
                c3436a.f18176c.setText(m18774c.m18791b());
                c3436a.f18177d.setOnClickListener(new View.OnClickListener(this, intValue) { // from class: ru.maximoff.apktool.util.ax.a.1

                    /* renamed from: a */
                    private final a f18141a;

                    /* renamed from: b */
                    private final int f18142b;

                    {
                        this.f18141a = this;
                        this.f18142b = intValue;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        this.f18141a.m18764a(this.f18142b, this.f18142b - 1);
                    }
                });
                c3436a.f18178e.setOnClickListener(new View.OnClickListener(this, intValue) { // from class: ru.maximoff.apktool.util.ax.a.2

                    /* renamed from: a */
                    private final a f18143a;

                    /* renamed from: b */
                    private final int f18144b;

                    {
                        this.f18143a = this;
                        this.f18144b = intValue;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        this.f18143a.m18764a(this.f18144b, this.f18144b + 1);
                    }
                });
                if (C3102bd.f18291a) {
                    c3436a.f18177d.setImageResource(R.drawable.ic_up);
                    c3436a.f18178e.setImageResource(R.drawable.ic_down);
                } else {
                    c3436a.f18177d.setImageResource(R.drawable.ic_up_dark);
                    c3436a.f18178e.setImageResource(R.drawable.ic_down_dark);
                }
                if (intValue > 0) {
                    c3436a.f18177d.setVisibility(0);
                } else {
                    c3436a.f18177d.setVisibility(8);
                }
                if (intValue < this.f18138a.size() - 1) {
                    c3436a.f18178e.setVisibility(0);
                } else {
                    c3436a.f18178e.setVisibility(8);
                }
                view.setOnClickListener(new View.OnClickListener(this, intValue, m18774c) { // from class: ru.maximoff.apktool.util.ax.a.3

                    /* renamed from: a */
                    private final a f18145a;

                    /* renamed from: b */
                    private final int f18146b;

                    /* renamed from: c */
                    private final C3093ay.a f18147c;

                    {
                        this.f18145a = this;
                        this.f18146b = intValue;
                        this.f18147c = m18774c;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        this.f18145a.m18765a(this.f18146b, this.f18147c);
                    }
                });
                view.setOnLongClickListener(new AnonymousClass4(this, intValue, m18774c));
            }
            return view;
        }

        /* compiled from: QuickPanel.java */
        /* renamed from: ru.maximoff.apktool.util.ax$a$4, reason: invalid class name */
        class AnonymousClass4 implements View.OnLongClickListener {

            /* renamed from: a */
            private final a f18148a;

            /* renamed from: b */
            private final int f18149b;

            /* renamed from: c */
            private final C3093ay.a f18150c;

            AnonymousClass4(a aVar, int i, C3093ay.a aVar2) {
                this.f18148a = aVar;
                this.f18149b = i;
                this.f18150c = aVar2;
            }

            /* renamed from: a */
            static a m18772a(AnonymousClass4 anonymousClass4) {
                return anonymousClass4.f18148a;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                int i;
                int i2;
                C0173ao c0173ao = new C0173ao(a.m18769c(this.f18148a).f18137d, view);
                if (C3102bd.m18910a(a.m18769c(this.f18148a).f18137d, "menu_position", "1").equals("0")) {
                    i = 3;
                } else {
                    i = 5;
                }
                c0173ao.m1340a(i);
                c0173ao.m1339a().add(0, 1500, 0, R.string.edit).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f18149b, this.f18150c) { // from class: ru.maximoff.apktool.util.ax.a.4.1

                    /* renamed from: a */
                    private final AnonymousClass4 f18151a;

                    /* renamed from: b */
                    private final int f18152b;

                    /* renamed from: c */
                    private final C3093ay.a f18153c;

                    {
                        this.f18151a = this;
                        this.f18152b = r2;
                        this.f18153c = r3;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        AnonymousClass4.m18772a(this.f18151a).m18765a(this.f18152b, this.f18153c);
                        return true;
                    }
                });
                c0173ao.m1339a().add(0, 1500, 0, R.string.delete).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f18149b) { // from class: ru.maximoff.apktool.util.ax.a.4.2

                    /* renamed from: a */
                    private final AnonymousClass4 f18154a;

                    /* renamed from: b */
                    private final int f18155b;

                    {
                        this.f18154a = this;
                        this.f18155b = r2;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        AnonymousClass4.m18772a(this.f18154a).m18771b(this.f18155b);
                        return true;
                    }
                });
                if (this.f18149b > 0) {
                    i2 = 1502;
                    c0173ao.m1339a().add(0, 1501, 0, a.m18769c(this.f18148a).f18137d.getString(R.string.f21471up)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f18149b) { // from class: ru.maximoff.apktool.util.ax.a.4.3

                        /* renamed from: a */
                        private final AnonymousClass4 f18156a;

                        /* renamed from: b */
                        private final int f18157b;

                        {
                            this.f18156a = this;
                            this.f18157b = r2;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            AnonymousClass4.m18772a(this.f18156a).m18764a(this.f18157b, this.f18157b - 1);
                            return true;
                        }
                    });
                } else {
                    i2 = 1501;
                }
                if (this.f18149b < this.f18148a.f18138a.size() - 1) {
                    int i3 = i2 + 1;
                    c0173ao.m1339a().add(0, i2, 0, a.m18769c(this.f18148a).f18137d.getString(R.string.down)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f18149b) { // from class: ru.maximoff.apktool.util.ax.a.4.4

                        /* renamed from: a */
                        private final AnonymousClass4 f18158a;

                        /* renamed from: b */
                        private final int f18159b;

                        {
                            this.f18158a = this;
                            this.f18159b = r2;
                        }

                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            AnonymousClass4.m18772a(this.f18158a).m18764a(this.f18159b, this.f18159b + 1);
                            return true;
                        }
                    });
                }
                c0173ao.m1344c();
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m18765a(int i, C3093ay.a aVar) {
            View inflate = LayoutInflater.from(this.f18140c.f18137d).inflate(R.layout.bm_edit, (ViewGroup) null);
            EditText editText = (EditText) inflate.findViewById(R.id.bmeditEditText1);
            EditText editText2 = (EditText) inflate.findViewById(R.id.bmeditEditText2);
            ((TextView) inflate.findViewById(R.id.bmeditTextView2)).setText(R.string.value);
            editText.setHint(R.string.name);
            editText2.setHint(R.string.value);
            if (aVar != null) {
                editText.setText(aVar.m18790a());
                editText2.setText(aVar.m18791b());
            }
            editText2.setSingleLine(false);
            editText2.setHorizontallyScrolling(false);
            editText2.setInputType(131073);
            DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f18140c.f18137d).m418a(aVar == null ? R.string.madd : R.string.edit).m435b(inflate).m420a(R.string.save, new DialogInterface.OnClickListener(this, editText, editText2, i) { // from class: ru.maximoff.apktool.util.ax.a.5

                /* renamed from: a */
                private final a f18160a;

                /* renamed from: b */
                private final EditText f18161b;

                /* renamed from: c */
                private final EditText f18162c;

                /* renamed from: d */
                private final int f18163d;

                {
                    this.f18160a = this;
                    this.f18161b = editText;
                    this.f18162c = editText2;
                    this.f18163d = i;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    String m18773a = C3093ay.m18773a(new C3093ay.a(this.f18161b.getText().toString(), this.f18162c.getText().toString()));
                    if (this.f18163d == -1) {
                        a.m18769c(this.f18160a).f18135b.m18781a(m18773a);
                    } else {
                        a.m18769c(this.f18160a).f18135b.m18780a(this.f18163d, m18773a);
                    }
                    this.f18160a.m18763a();
                    this.f18160a.notifyDataSetChanged();
                    C3102bd.f18336s = true;
                }
            }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
            m438b.getWindow().setSoftInputMode(4);
            m438b.setOnShowListener(new DialogInterface.OnShowListener(this, m438b, editText, editText2) { // from class: ru.maximoff.apktool.util.ax.a.6

                /* renamed from: a */
                private final a f18164a;

                /* renamed from: b */
                private final DialogInterfaceC0070b f18165b;

                /* renamed from: c */
                private final EditText f18166c;

                /* renamed from: d */
                private final EditText f18167d;

                {
                    this.f18164a = this;
                    this.f18165b = m438b;
                    this.f18166c = editText;
                    this.f18167d = editText2;
                }

                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    Button m414a = this.f18165b.m414a(-1);
                    this.f18166c.addTextChangedListener(new TextWatcher(this, m414a, this.f18167d) { // from class: ru.maximoff.apktool.util.ax.a.6.1

                        /* renamed from: a */
                        private final AnonymousClass6 f18168a;

                        /* renamed from: b */
                        private final Button f18169b;

                        /* renamed from: c */
                        private final EditText f18170c;

                        {
                            this.f18168a = this;
                            this.f18169b = m414a;
                            this.f18170c = r3;
                        }

                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                        }

                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable editable) {
                            this.f18169b.setEnabled(editable.length() > 0 && this.f18170c.getText().length() > 0);
                        }
                    });
                    this.f18167d.addTextChangedListener(new TextWatcher(this, m414a, this.f18166c) { // from class: ru.maximoff.apktool.util.ax.a.6.2

                        /* renamed from: a */
                        private final AnonymousClass6 f18171a;

                        /* renamed from: b */
                        private final Button f18172b;

                        /* renamed from: c */
                        private final EditText f18173c;

                        {
                            this.f18171a = this;
                            this.f18172b = m414a;
                            this.f18173c = r3;
                        }

                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                        }

                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable editable) {
                            this.f18172b.setEnabled(editable.length() > 0 && this.f18173c.getText().length() > 0);
                        }
                    });
                    this.f18166c.requestFocus();
                    this.f18166c.selectAll();
                }
            });
            m438b.show();
        }

        /* compiled from: QuickPanel.java */
        /* renamed from: ru.maximoff.apktool.util.ax$a$a, reason: collision with other inner class name */
        private class C3436a {

            /* renamed from: a */
            public int f18174a;

            /* renamed from: b */
            public TextView f18175b;

            /* renamed from: c */
            public TextView f18176c;

            /* renamed from: d */
            public ImageView f18177d;

            /* renamed from: e */
            public ImageView f18178e;

            /* renamed from: f */
            private final a f18179f;

            public C3436a(a aVar) {
                this.f18179f = aVar;
            }
        }
    }
}
