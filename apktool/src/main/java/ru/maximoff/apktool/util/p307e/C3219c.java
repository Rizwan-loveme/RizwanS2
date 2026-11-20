package ru.maximoff.apktool.util.p307e;

import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.util.List;
import ru.maximoff.apktool.SettingActivity;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;

/* compiled from: SettingsSearchAdapter.java */
/* renamed from: ru.maximoff.apktool.util.e.c */
/* loaded from: classes.dex */
public class C3219c extends BaseAdapter {

    /* renamed from: a */
    private final SettingActivity f19277a;

    /* renamed from: b */
    private final List<C3217a> f19278b;

    /* renamed from: c */
    private DialogInterfaceC0070b f19279c;

    /* renamed from: d */
    private boolean f19280d;

    public C3219c(SettingActivity settingActivity) {
        this.f19277a = settingActivity;
        this.f19280d = C3080al.m18589c(settingActivity);
        this.f19278b = C3218b.m19276a(this.f19280d);
        m19283a((String) null);
    }

    /* renamed from: a */
    public void m19282a(DialogInterfaceC0070b dialogInterfaceC0070b) {
        this.f19279c = dialogInterfaceC0070b;
    }

    /* renamed from: a */
    public void m19283a(String str) {
        String string;
        if (!C3112bn.m19040o(str)) {
            str = str.trim();
        }
        List<C3217a> m19276a = C3218b.m19276a(this.f19280d);
        this.f19278b.clear();
        if (C3112bn.m19040o(str)) {
            this.f19278b.addAll(m19276a);
        } else {
            for (C3217a c3217a : m19276a) {
                String string2 = this.f19277a.getString(c3217a.f19235b);
                if (c3217a.f19234a.equals("imgs_backup")) {
                    string = this.f19277a.getString(R.string.imgs_backup_summary, this.f19277a.getString(R.string.invert_color), this.f19277a.getString(R.string.monochrome), this.f19277a.getString(R.string.pngquant), this.f19277a.getString(R.string.dummy_file));
                } else {
                    string = this.f19277a.getString(c3217a.f19236c);
                }
                if (m19280a(string2, str) || m19280a(string, str)) {
                    this.f19278b.add(c3217a);
                }
            }
        }
        notifyDataSetChanged();
    }

    /* renamed from: a */
    private boolean m19280a(String str, String str2) {
        return str.toLowerCase().contains(str2.toLowerCase());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f19278b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return i >= getCount() ? (Object) null : this.f19278b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return (getCount() * i) + 17;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        String string;
        if (view == null) {
            view = ((LayoutInflater) this.f19277a.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.perm_entry, (ViewGroup) null);
            aVar = new a(this);
            aVar.f19285a = (CheckBox) view.findViewById(R.id.permentryCheckBox1);
            aVar.f19286b = (TextView) view.findViewById(R.id.permentryTextView1);
            aVar.f19287c = (TextView) view.findViewById(R.id.permentryTextView2);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        view.setMinimumHeight(0);
        C3217a c3217a = this.f19278b.get(i);
        if (c3217a.f19234a.equals("imgs_backup")) {
            string = this.f19277a.getString(R.string.imgs_backup_summary, this.f19277a.getString(R.string.invert_color), this.f19277a.getString(R.string.monochrome), this.f19277a.getString(R.string.pngquant), this.f19277a.getString(R.string.dummy_file));
        } else {
            string = this.f19277a.getString(c3217a.f19236c);
        }
        aVar.f19285a.setVisibility(8);
        aVar.f19286b.setTextSize(2, C3102bd.f18332o);
        aVar.f19287c.setTextSize(2, C3102bd.m18927b());
        aVar.f19286b.setText(c3217a.f19235b);
        aVar.f19287c.setText(string);
        view.setOnClickListener(new View.OnClickListener(this, c3217a) { // from class: ru.maximoff.apktool.util.e.c.1

            /* renamed from: a */
            private final C3219c f19281a;

            /* renamed from: b */
            private final C3217a f19282b;

            {
                this.f19281a = this;
                this.f19282b = c3217a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (this.f19281a.f19279c != null) {
                    this.f19281a.f19279c.cancel();
                }
                try {
                    Intent intent = new Intent(this.f19281a.f19277a, Class.forName("ru.maximoff.apktool.SettingActivity"));
                    intent.putExtra(PreferenceActivity.EXTRA_SHOW_FRAGMENT, this.f19282b.f19237d.getName());
                    intent.putExtra(PreferenceActivity.EXTRA_NO_HEADERS, true);
                    intent.putExtra("target_key", this.f19282b.f19234a);
                    this.f19281a.f19277a.startActivity(intent);
                    this.f19281a.f19277a.finish();
                } catch (ClassNotFoundException e2) {
                    throw new NoClassDefFoundError(e2.getMessage());
                }
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener(this, c3217a) { // from class: ru.maximoff.apktool.util.e.c.2

            /* renamed from: a */
            private final C3219c f19283a;

            /* renamed from: b */
            private final C3217a f19284b;

            {
                this.f19283a = this;
                this.f19284b = c3217a;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                if (!C3102bd.m18925a((Context) this.f19283a.f19277a, "amdm", false)) {
                    return false;
                }
                C3112bn.m19002a(this.f19283a.f19277a, new StringBuffer().append("apktool://settings?key=").append(this.f19284b.f19234a).toString());
                return true;
            }
        });
        return view;
    }

    /* compiled from: SettingsSearchAdapter.java */
    /* renamed from: ru.maximoff.apktool.util.e.c$a */
    private class a {

        /* renamed from: a */
        public CheckBox f19285a;

        /* renamed from: b */
        public TextView f19286b;

        /* renamed from: c */
        public TextView f19287c;

        /* renamed from: d */
        private final C3219c f19288d;

        public a(C3219c c3219c) {
            this.f19288d = c3219c;
        }
    }
}
