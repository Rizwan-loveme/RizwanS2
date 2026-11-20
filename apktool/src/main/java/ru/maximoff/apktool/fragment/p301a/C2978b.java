package ru.maximoff.apktool.fragment.p301a;

import android.C0012R;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.media.MediaCodec;
import android.net.Uri;
import android.p008os.Environment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.widget.C0173ao;
import androidx.appcompat.widget.SearchView;
import androidx.p044h.p045a.AbstractC0405a;
import com.p159h.p160a.p162b.C1397s;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.fragment.MenuItemOnActionExpandListenerC2976a;
import ru.maximoff.apktool.fragment.p302b.C2986e;
import ru.maximoff.apktool.util.C3066aa;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3261t;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p303a.C3061a;
import ru.maximoff.apktool.util.p306d.C3212b;
import ru.maximoff.apktool.view.Editor;
import ru.maximoff.apktool.view.EditorPager;

/* compiled from: EditorPagerAdapter.java */
/* renamed from: ru.maximoff.apktool.fragment.a.b */
/* loaded from: classes.dex */
public class C2978b extends AbstractC0405a {

    /* renamed from: a */
    public static final C2978b f16135a = new C2978b();

    /* renamed from: b */
    private Context f16136b;

    /* renamed from: f */
    private C2986e f16140f;

    /* renamed from: g */
    private MenuItemOnActionExpandListenerC2976a f16141g;

    /* renamed from: d */
    private boolean f16138d = true;

    /* renamed from: e */
    private Editor.InterfaceC3272a f16139e = (Editor.InterfaceC3272a) null;

    /* renamed from: c */
    private List<RunnableC2979c> f16137c = new ArrayList();

    C2978b() {
    }

    /* renamed from: a */
    public void m17694a(MenuItemOnActionExpandListenerC2976a menuItemOnActionExpandListenerC2976a) {
        this.f16141g = menuItemOnActionExpandListenerC2976a;
    }

    /* renamed from: d */
    public MenuItemOnActionExpandListenerC2976a m17707d() {
        return this.f16141g;
    }

    /* renamed from: e */
    public EditorPager m17709e() {
        return this.f16141g.m17656e();
    }

    /* renamed from: f */
    public void m17711f() {
        if (this.f16141g != null) {
            Iterator<RunnableC2979c> it = this.f16137c.iterator();
            while (it.hasNext()) {
                RunnableC2979c next = it.next();
                if (!next.m17788d()) {
                    next.m17773a();
                    it.remove();
                }
            }
            this.f16141g.m17630a();
            mo3289c();
        }
    }

    /* renamed from: a */
    public void m17685a(int i, int i2, int i3) {
        if (this.f16137c.size() == 0 || i >= this.f16137c.size()) {
            return;
        }
        this.f16137c.get(i).m17775a(i2, i3);
    }

    /* renamed from: c */
    public void m17705c(int i) {
        if (this.f16137c.size() != 0) {
            if (i >= this.f16137c.size()) {
                i = 0;
            }
            this.f16137c.get(i).m17786c();
        }
    }

    /* renamed from: d */
    public void m17708d(int i) {
        if (this.f16137c.size() != 0) {
            if (i >= this.f16137c.size()) {
                i = 0;
            }
            this.f16137c.get(i).m17801q();
        }
    }

    /* renamed from: a */
    public void m17695a(C2986e c2986e) {
        this.f16140f = c2986e;
    }

    /* renamed from: g */
    public synchronized void m17713g() {
        if (this.f16140f != null) {
            this.f16140f.mo17859b();
        }
    }

    /* renamed from: a */
    public int m17683a(ContentResolver contentResolver, Uri uri, boolean z, int i) {
        for (RunnableC2979c runnableC2979c : this.f16137c) {
            if (runnableC2979c.m17781a(uri)) {
                return this.f16137c.indexOf(runnableC2979c);
            }
        }
        RunnableC2979c runnableC2979c2 = new RunnableC2979c(contentResolver, uri, this.f16136b, this.f16138d, z, i, this.f16139e);
        this.f16137c.add(runnableC2979c2);
        m17725m();
        mo3289c();
        runnableC2979c2.m17801q();
        return this.f16137c.size() - 1;
    }

    /* renamed from: h */
    public void m17715h() {
        if (this.f16137c.size() != 0) {
            for (RunnableC2979c runnableC2979c : this.f16137c) {
                runnableC2979c.m17782b();
                runnableC2979c.m17806v().m19756h(true);
            }
            m17725m();
        }
    }

    /* renamed from: a */
    public void m17692a(Context context, Editor.InterfaceC3272a interfaceC3272a) {
        this.f16139e = interfaceC3272a;
        this.f16136b = context;
        Iterator<RunnableC2979c> it = this.f16137c.iterator();
        while (it.hasNext()) {
            it.next().m17772a(context, interfaceC3272a);
        }
    }

    @Override // androidx.p044h.p045a.AbstractC0405a
    /* renamed from: a */
    public int mo3270a() {
        return this.f16137c.size();
    }

    /* renamed from: e */
    public boolean m17710e(int i) {
        if (this.f16137c.size() != 0 && i < this.f16137c.size()) {
            return this.f16137c.get(i).m17796l();
        }
        return false;
    }

    /* renamed from: f */
    public boolean m17712f(int i) {
        if (this.f16137c.size() != 0 && i < this.f16137c.size()) {
            return this.f16137c.get(i).m17797m();
        }
        return false;
    }

    /* renamed from: g */
    public boolean m17714g(int i) {
        if (this.f16137c.size() != 0 && i < this.f16137c.size()) {
            return this.f16137c.get(i).m17798n();
        }
        return false;
    }

    /* renamed from: h */
    public boolean m17716h(int i) {
        if (this.f16137c.size() != 0 && i < this.f16137c.size()) {
            return this.f16137c.get(i).m17799o();
        }
        return false;
    }

    /* renamed from: i */
    public boolean m17718i(int i) {
        if (this.f16137c.size() != 0 && i < this.f16137c.size()) {
            return this.f16137c.get(i).m17800p();
        }
        return false;
    }

    /* renamed from: a */
    public void m17696a(boolean z) {
        this.f16138d = z;
        Iterator<RunnableC2979c> it = this.f16137c.iterator();
        while (it.hasNext()) {
            it.next().m17780a(z);
        }
    }

    /* renamed from: j */
    public void m17720j(int i) {
        if (this.f16137c.size() != 0 && i < this.f16137c.size()) {
            this.f16137c.get(i).m17803s();
        }
    }

    /* renamed from: k */
    public void m17722k(int i) {
        if (this.f16137c.size() != 0 && i < this.f16137c.size()) {
            this.f16137c.get(i).m17804t();
        }
    }

    /* renamed from: l */
    public void m17724l(int i) {
        if (this.f16137c.size() != 0 && i < this.f16137c.size()) {
            this.f16137c.get(i).m17805u();
        }
    }

    /* renamed from: a */
    public int m17682a(int i, String str, boolean z, boolean z2, boolean z3) {
        if (this.f16137c.size() != 0 && i < this.f16137c.size()) {
            if (z3) {
                return this.f16137c.get(i).m17806v().m19751a(str, z, z2);
            }
            int m19747a = this.f16137c.get(i).m17806v().m19747a(str, 0, z, z2);
            int i2 = 0;
            while (m19747a > 0) {
                m19747a = this.f16137c.get(i).m17806v().m19747a(str, m19747a, z, z2);
                i2++;
            }
            return i2;
        }
        return 0;
    }

    /* renamed from: a */
    public void m17690a(int i, String str, boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.f16137c.size() != 0 && i < this.f16137c.size()) {
            this.f16137c.get(i).m17806v().m19748a(str, this.f16137c.get(i).m17806v().getCaretPosition(), z, z2, z3, z4);
        }
    }

    /* renamed from: b */
    public void m17702b(int i, String str, boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.f16137c.size() != 0 && i < this.f16137c.size()) {
            Editor m17806v = this.f16137c.get(i).m17806v();
            int caretPosition = m17806v.getCaretPosition() - 1;
            if (m17806v.m10920y()) {
                caretPosition -= m17806v.getSelection().length();
            }
            m17806v.m19753b(str, caretPosition, z, z2, z3, z4);
        }
    }

    /* renamed from: a */
    public void m17689a(int i, String str, String str2, boolean z, boolean z2, boolean z3) {
        if (this.f16137c.size() != 0 && i < this.f16137c.size() && this.f16137c.get(i).m17797m()) {
            Editor m17806v = this.f16137c.get(i).m17806v();
            int caretPosition = m17806v.getCaretPosition() - 1;
            if (m17806v.m10920y()) {
                caretPosition -= m17806v.getSelection().length();
            }
            m17806v.m19749a(str, str2, caretPosition, z, z2, z3);
        }
    }

    /* renamed from: b */
    public C1397s m17698b(int i, String str, String str2, boolean z, boolean z2, boolean z3) {
        if (this.f16137c.size() == 0) {
            return new C1397s(0, new Integer(0));
        }
        if (i >= this.f16137c.size()) {
            return new C1397s(0, new Integer(0));
        }
        if (!this.f16137c.get(i).m17797m()) {
            return new C1397s(0, new Integer(0));
        }
        return this.f16137c.get(i).m17806v().m19754b(str, str2, this.f16137c.get(i).m17806v().getCaretPosition(), z, z2, z3);
    }

    /* renamed from: a */
    public void m17687a(int i, SearchView searchView) {
        if (this.f16137c.size() != 0 && i < this.f16137c.size()) {
            this.f16137c.get(i).m17806v().m19752a(searchView);
        }
    }

    /* renamed from: m */
    public void m17726m(int i) {
        if (this.f16137c.size() == 0) {
            return;
        }
        this.f16137c.get(m17709e().getCurrentItem()).m17806v().m19757k(i);
    }

    /* renamed from: n */
    public Editor m17727n(int i) {
        if (this.f16137c.size() == 0) {
            return (Editor) null;
        }
        if (i >= this.f16137c.size()) {
            return (Editor) null;
        }
        return this.f16137c.get(i).m17806v();
    }

    @Override // androidx.p044h.p045a.AbstractC0405a
    /* renamed from: a */
    public boolean mo3281a(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.p044h.p045a.AbstractC0405a
    /* renamed from: a */
    public Object mo3274a(ViewGroup viewGroup, int i) {
        Editor m17806v = this.f16137c.get(i).m17806v();
        viewGroup.addView(m17806v);
        return m17806v;
    }

    @Override // androidx.p044h.p045a.AbstractC0405a
    /* renamed from: a */
    public void mo3280a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.p044h.p045a.AbstractC0405a
    /* renamed from: a */
    public CharSequence mo3272a(int i) {
        if (i >= this.f16137c.size()) {
            return "";
        }
        RunnableC2979c runnableC2979c = this.f16137c.get(i);
        CharSequence m17807w = runnableC2979c.m17807w();
        return runnableC2979c.m17796l() ? new StringBuffer().append((Object) m17807w).append("*").toString() : m17807w;
    }

    /* renamed from: o */
    public boolean m17729o(int i) {
        if (this.f16137c.size() != 0 && i < this.f16137c.size()) {
            return this.f16137c.get(i).m17789e();
        }
        return false;
    }

    /* renamed from: p */
    public boolean m17730p(int i) {
        if (this.f16137c.size() != 0 && i < this.f16137c.size()) {
            return this.f16137c.get(i).m17790f();
        }
        return false;
    }

    /* renamed from: a */
    public void m17686a(int i, MenuItem menuItem) {
        if (this.f16137c.size() != 0 && i < this.f16137c.size()) {
            this.f16137c.get(i).m17783b(menuItem);
        }
    }

    /* renamed from: b */
    public void m17700b(int i, MenuItem menuItem) {
        if (this.f16137c.size() != 0 && i < this.f16137c.size()) {
            this.f16137c.get(i).m17776a(menuItem);
        }
    }

    /* renamed from: q */
    public Uri m17731q(int i) {
        if (this.f16137c.size() == 0) {
            return (Uri) null;
        }
        if (i >= this.f16137c.size()) {
            return (Uri) null;
        }
        return this.f16137c.get(i).m17793i();
    }

    /* renamed from: r */
    public String m17732r(int i) {
        if (this.f16137c.size() == 0) {
            return (String) null;
        }
        if (i >= this.f16137c.size()) {
            return (String) null;
        }
        return this.f16137c.get(i).m17794j();
    }

    /* renamed from: a */
    public void m17688a(int i, String str) {
        if (this.f16137c.size() != 0 && i < this.f16137c.size()) {
            this.f16137c.get(i).m17778a(str);
        }
    }

    /* renamed from: a */
    public void m17684a(int i, int i2) {
        boolean z;
        boolean z2 = true;
        if (i < this.f16137c.size()) {
            RunnableC2979c runnableC2979c = this.f16137c.get(i);
            if (i2 == 0 && !runnableC2979c.m17796l()) {
                m17699b(i, i2);
                if (this.f16141g != null) {
                    this.f16141g.m17648av();
                    return;
                }
                return;
            }
            if (i2 == 1) {
                Iterator<RunnableC2979c> it = this.f16137c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    }
                    RunnableC2979c next = it.next();
                    if (!runnableC2979c.equals(next) && next.m17796l()) {
                        break;
                    }
                }
                if (!z2) {
                    m17699b(i, i2);
                    return;
                }
            } else {
                Iterator<RunnableC2979c> it2 = this.f16137c.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = false;
                        break;
                    } else if (it2.next().m17796l()) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    m17699b(i, i2);
                    if (i2 == 0 && this.f16141g != null) {
                        this.f16141g.m17648av();
                        return;
                    }
                    return;
                }
            }
            new DialogInterfaceC0070b.a(this.f16136b).m418a(R.string.save_file).m433b(R.string.save_file_msg).m420a(R.string.yes, new DialogInterface.OnClickListener(this, i2, runnableC2979c, i) { // from class: ru.maximoff.apktool.fragment.a.b.1

                /* renamed from: a */
                private final C2978b f16151a;

                /* renamed from: b */
                private final int f16152b;

                /* renamed from: c */
                private final RunnableC2979c f16153c;

                /* renamed from: d */
                private final int f16154d;

                {
                    this.f16151a = this;
                    this.f16152b = i2;
                    this.f16153c = runnableC2979c;
                    this.f16154d = i;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.cancel();
                    switch (this.f16152b) {
                        case 0:
                            this.f16153c.m17808x();
                            break;
                        case 1:
                            this.f16151a.m17693a(this.f16153c);
                            break;
                        case 2:
                            this.f16151a.m17719j();
                            break;
                    }
                    this.f16151a.m17699b(this.f16154d, this.f16152b);
                    if (this.f16152b != 0 || this.f16151a.f16141g == null) {
                        return;
                    }
                    this.f16151a.f16141g.m17648av();
                }
            }).m434b(R.string.f21469no, new DialogInterface.OnClickListener(this, i2, runnableC2979c, i) { // from class: ru.maximoff.apktool.fragment.a.b.2

                /* renamed from: a */
                private final C2978b f16155a;

                /* renamed from: b */
                private final int f16156b;

                /* renamed from: c */
                private final RunnableC2979c f16157c;

                /* renamed from: d */
                private final int f16158d;

                {
                    this.f16155a = this;
                    this.f16156b = i2;
                    this.f16157c = runnableC2979c;
                    this.f16158d = i;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.cancel();
                    switch (this.f16156b) {
                        case 0:
                            this.f16157c.m17785b(false);
                            break;
                        case 1:
                            this.f16155a.m17678a(this.f16157c, false);
                            break;
                        case 2:
                            this.f16155a.m17680c(false);
                            break;
                    }
                    this.f16155a.m17699b(this.f16158d, this.f16156b);
                    if (this.f16156b != 0 || this.f16155a.f16141g == null) {
                        return;
                    }
                    this.f16155a.f16141g.m17648av();
                }
            }).m440c(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
        }
    }

    /* renamed from: b */
    public void m17699b(int i, int i2) {
        m17725m();
        if (i < this.f16137c.size()) {
            RunnableC2979c runnableC2979c = this.f16137c.get(i);
            if (i2 == 0) {
                this.f16137c.remove(runnableC2979c);
            } else {
                this.f16137c.clear();
                if (i2 == 1) {
                    this.f16137c.add(runnableC2979c);
                }
            }
            mo3289c();
            this.f16141g.m17659f(mo3270a());
            try {
                MainActivity.m16615o().m16633d(1);
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: i */
    public boolean m17717i() {
        Iterator<RunnableC2979c> it = this.f16137c.iterator();
        while (it.hasNext()) {
            if (it.next().m17796l()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: s */
    public boolean m17733s(int i) {
        if (this.f16137c.size() != 0 && i < this.f16137c.size()) {
            return this.f16137c.get(i).m17792h();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m17680c(boolean z) {
        Iterator<RunnableC2979c> it = this.f16137c.iterator();
        while (it.hasNext()) {
            it.next().m17785b(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17678a(RunnableC2979c runnableC2979c, boolean z) {
        for (RunnableC2979c runnableC2979c2 : this.f16137c) {
            if (!runnableC2979c2.equals(runnableC2979c)) {
                runnableC2979c2.m17785b(z);
            }
        }
    }

    /* renamed from: j */
    public void m17719j() {
        Iterator<RunnableC2979c> it = this.f16137c.iterator();
        while (it.hasNext()) {
            it.next().m17808x();
        }
        C3112bn.m18999a(this.f16136b, R.string.all_files_saved);
    }

    /* renamed from: k */
    public void m17721k() {
        if (this.f16137c.size() != 0) {
            m17711f();
            Iterator<RunnableC2979c> it = this.f16137c.iterator();
            while (it.hasNext()) {
                it.next().m17787c(false);
            }
        }
    }

    /* renamed from: a */
    public void m17693a(RunnableC2979c runnableC2979c) {
        for (RunnableC2979c runnableC2979c2 : this.f16137c) {
            if (!runnableC2979c2.equals(runnableC2979c)) {
                runnableC2979c2.m17808x();
            }
        }
    }

    /* renamed from: t */
    public boolean m17734t(int i) {
        if (this.f16137c.size() == 0 || i >= this.f16137c.size()) {
            return false;
        }
        RunnableC2979c runnableC2979c = this.f16137c.get(i);
        return runnableC2979c.m17791g() && !runnableC2979c.m17792h();
    }

    /* renamed from: u */
    public void m17735u(int i) {
        if (i >= this.f16137c.size()) {
            return;
        }
        this.f16137c.get(i).m17808x();
    }

    /* renamed from: a */
    public void m17691a(int i, boolean z) {
        if (i < this.f16137c.size()) {
            RunnableC2979c runnableC2979c = this.f16137c.get(i);
            View inflate = LayoutInflater.from(this.f16136b).inflate(R.layout.save_as, (ViewGroup) null);
            EditText editText = (EditText) inflate.findViewById(R.id.saveasEditText1);
            editText.setText(runnableC2979c.m17807w());
            editText.setHint(runnableC2979c.m17807w());
            EditText editText2 = (EditText) inflate.findViewById(R.id.saveasEditText2);
            File m17795k = runnableC2979c.m17795k();
            if (m17795k != null && !m17795k.getParentFile().equals(C3102bd.m18908a())) {
                editText2.setText(m17795k.getParentFile().getAbsolutePath());
                editText2.setHint(m17795k.getParentFile().getAbsolutePath());
            } else if (C3102bd.f18339v != null) {
                editText2.setText(C3102bd.f18339v);
                editText2.setHint(C3102bd.f18339v);
            } else {
                editText2.setText(Environment.getExternalStorageDirectory().getAbsolutePath());
                editText2.setHint(Environment.getExternalStorageDirectory().getAbsolutePath());
            }
            ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.saveasImageButton1);
            imageButton.setImageBitmap(new C3066aa(this.f16136b).m18363a(!C3102bd.f18291a ? -16777216 : Color.DKGRAY, R.drawable.ic_folder));
            imageButton.setOnClickListener(new AnonymousClass3(this, editText2, editText));
            Spinner spinner = (Spinner) inflate.findViewById(R.id.saveasSpinner1);
            String[] stringArray = this.f16136b.getResources().getStringArray(R.array.charsets);
            spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f16136b, C0012R.layout.simple_spinner_dropdown_item, stringArray));
            spinner.setSelection(0);
            CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.saveasCheckBox1);
            checkBox.setText(this.f16136b.getString(R.string.open_in_editor).toLowerCase());
            DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f16136b).m418a(R.string.save_as).m435b(inflate).m420a(R.string.save, new DialogInterface.OnClickListener(this, editText2, editText, z, runnableC2979c, stringArray, spinner, checkBox) { // from class: ru.maximoff.apktool.fragment.a.b.4

                /* renamed from: a */
                private final C2978b f16181a;

                /* renamed from: b */
                private final EditText f16182b;

                /* renamed from: c */
                private final EditText f16183c;

                /* renamed from: d */
                private final boolean f16184d;

                /* renamed from: e */
                private final RunnableC2979c f16185e;

                /* renamed from: f */
                private final String[] f16186f;

                /* renamed from: g */
                private final Spinner f16187g;

                /* renamed from: h */
                private final CheckBox f16188h;

                {
                    this.f16181a = this;
                    this.f16182b = editText2;
                    this.f16183c = editText;
                    this.f16184d = z;
                    this.f16185e = runnableC2979c;
                    this.f16186f = stringArray;
                    this.f16187g = spinner;
                    this.f16188h = checkBox;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    String charSequence;
                    dialogInterface.cancel();
                    try {
                        String editable = this.f16182b.getText().toString();
                        if (!editable.endsWith("/")) {
                            editable = new StringBuffer().append(editable).append("/").toString();
                        }
                        File file = new File(new StringBuffer().append(editable).append(C3112bn.m19033h(this.f16183c.getText().toString())).toString());
                        if (this.f16184d) {
                            charSequence = this.f16185e.m17806v().getSelection().toString();
                        } else {
                            charSequence = this.f16185e.m17806v().getText().toString();
                        }
                        C3061a.m18320b(file, charSequence, this.f16186f[this.f16187g.getSelectedItemPosition()]);
                        C3112bn.m18999a(this.f16181a.f16136b, R.string.success);
                        MainActivity.m16615o().m16637s();
                        this.f16181a.m17721k();
                        if (this.f16188h.isChecked()) {
                            this.f16181a.f16141g.m17636a(file);
                        }
                    } catch (Exception e2) {
                        C3112bn.m19023b(this.f16181a.f16136b, this.f16181a.f16136b.getString(R.string.errorf, e2.getMessage()));
                    }
                }
            }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b();
            m438b.getWindow().setSoftInputMode(4);
            m438b.setOnShowListener(new DialogInterface.OnShowListener(this, editText, runnableC2979c, z) { // from class: ru.maximoff.apktool.fragment.a.b.5

                /* renamed from: a */
                private final C2978b f16189a;

                /* renamed from: b */
                private final EditText f16190b;

                /* renamed from: c */
                private final RunnableC2979c f16191c;

                /* renamed from: d */
                private final boolean f16192d;

                {
                    this.f16189a = this;
                    this.f16190b = editText;
                    this.f16191c = runnableC2979c;
                    this.f16192d = z;
                }

                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    this.f16190b.requestFocus();
                    String charSequence = this.f16191c.m17807w().toString();
                    int lastIndexOf = charSequence.lastIndexOf(46);
                    if (lastIndexOf >= 0) {
                        if (this.f16192d) {
                            charSequence = new StringBuffer().append(new StringBuffer().append(charSequence.substring(0, lastIndexOf)).append("_sel").toString()).append(charSequence.substring(lastIndexOf)).toString();
                            lastIndexOf += 4;
                            this.f16190b.setText(charSequence);
                        }
                        if (this.f16191c.m17791g() && !this.f16191c.m17792h()) {
                            this.f16190b.setText(new StringBuffer().append(charSequence.substring(0, lastIndexOf)).append(".java").toString());
                        }
                        this.f16190b.setSelection(lastIndexOf);
                        return;
                    }
                    if (this.f16192d) {
                        charSequence = new StringBuffer().append(charSequence).append("_sel").toString();
                        this.f16190b.setText(charSequence);
                    }
                    this.f16190b.setSelection(charSequence.length());
                }
            });
            m438b.show();
        }
    }

    /* compiled from: EditorPagerAdapter.java */
    /* renamed from: ru.maximoff.apktool.fragment.a.b$3, reason: invalid class name */
    class AnonymousClass3 implements View.OnClickListener {

        /* renamed from: a */
        private final C2978b f16159a;

        /* renamed from: b */
        private final EditText f16160b;

        /* renamed from: c */
        private final EditText f16161c;

        AnonymousClass3(C2978b c2978b, EditText editText, EditText editText2) {
            this.f16159a = c2978b;
            this.f16160b = editText;
            this.f16161c = editText2;
        }

        /* renamed from: a */
        static C2978b m17739a(AnonymousClass3 anonymousClass3) {
            return anonymousClass3.f16159a;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C3261t c3261t = new C3261t(this.f16159a.f16136b);
            Runnable runnable = new Runnable(this, c3261t, this.f16160b, this.f16161c) { // from class: ru.maximoff.apktool.fragment.a.b.3.1

                /* renamed from: a */
                private final AnonymousClass3 f16162a;

                /* renamed from: b */
                private final C3261t f16163b;

                /* renamed from: c */
                private final EditText f16164c;

                /* renamed from: d */
                private final EditText f16165d;

                {
                    this.f16162a = this;
                    this.f16163b = c3261t;
                    this.f16164c = r3;
                    this.f16165d = r4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String path = this.f16163b.getPath();
                    File file = new File(path);
                    if (file.isDirectory()) {
                        this.f16164c.requestFocus();
                        this.f16164c.setText(path);
                        this.f16164c.setSelection(path.length());
                    } else if (file.isFile()) {
                        this.f16164c.setText(file.getParent());
                        this.f16164c.setSelection(file.getParent().length());
                        this.f16165d.requestFocus();
                        this.f16165d.setText(file.getName());
                        this.f16165d.setSelection(file.getName().length());
                    }
                }
            };
            c3261t.m19545a("_editor");
            c3261t.m19547b();
            c3261t.setCallback(runnable);
            c3261t.setPath(this.f16160b.getText().toString());
            c3261t.m19550e();
            DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(this.f16159a.f16136b);
            aVar.m427a(c3261t.m19548c());
            aVar.m435b(c3261t);
            aVar.m420a(R.string.mselect, new DialogInterface.OnClickListener(this, runnable) { // from class: ru.maximoff.apktool.fragment.a.b.3.2

                /* renamed from: a */
                private final AnonymousClass3 f16166a;

                /* renamed from: b */
                private final Runnable f16167b;

                {
                    this.f16166a = this;
                    this.f16167b = runnable;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f16167b.run();
                    dialogInterface.dismiss();
                }
            });
            aVar.m434b(R.string.cancel, (DialogInterface.OnClickListener) null);
            aVar.m437b("/...", (DialogInterface.OnClickListener) null);
            aVar.m429a(false);
            aVar.m422a(new DialogInterface.OnKeyListener(this, c3261t) { // from class: ru.maximoff.apktool.fragment.a.b.3.3

                /* renamed from: a */
                private final AnonymousClass3 f16168a;

                /* renamed from: b */
                private final C3261t f16169b;

                {
                    this.f16168a = this;
                    this.f16169b = c3261t;
                }

                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                        return false;
                    }
                    boolean m19551f = this.f16169b.m19551f();
                    if (!m19551f) {
                        dialogInterface.dismiss();
                        return m19551f;
                    }
                    return m19551f;
                }
            });
            DialogInterfaceC0070b m438b = aVar.m438b();
            m438b.setOnShowListener(new AnonymousClass4(this, m438b, c3261t));
            c3261t.setDialog(m438b);
            m438b.show();
        }

        /* compiled from: EditorPagerAdapter.java */
        /* renamed from: ru.maximoff.apktool.fragment.a.b$3$4, reason: invalid class name */
        class AnonymousClass4 implements DialogInterface.OnShowListener {

            /* renamed from: a */
            private final AnonymousClass3 f16170a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f16171b;

            /* renamed from: c */
            private final C3261t f16172c;

            AnonymousClass4(AnonymousClass3 anonymousClass3, DialogInterfaceC0070b dialogInterfaceC0070b, C3261t c3261t) {
                this.f16170a = anonymousClass3;
                this.f16171b = dialogInterfaceC0070b;
                this.f16172c = c3261t;
            }

            /* renamed from: a */
            static AnonymousClass3 m17740a(AnonymousClass4 anonymousClass4) {
                return anonymousClass4.f16170a;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                Button m414a = this.f16171b.m414a(-3);
                m414a.setOnClickListener(new View.OnClickListener(this, this.f16172c) { // from class: ru.maximoff.apktool.fragment.a.b.3.4.1

                    /* renamed from: a */
                    private final AnonymousClass4 f16173a;

                    /* renamed from: b */
                    private final C3261t f16174b;

                    {
                        this.f16173a = this;
                        this.f16174b = r2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        int i;
                        String[] m19640b = C3262u.m19640b(AnonymousClass3.m17739a(AnonymousClass4.m17740a(this.f16173a)).f16136b);
                        if (m19640b != null) {
                            C0173ao c0173ao = new C0173ao(AnonymousClass3.m17739a(AnonymousClass4.m17740a(this.f16173a)).f16136b, view);
                            if (C3102bd.m18910a(AnonymousClass3.m17739a(AnonymousClass4.m17740a(this.f16173a)).f16136b, "menu_position", "1").equals("0")) {
                                i = 3;
                            } else {
                                i = 5;
                            }
                            c0173ao.m1340a(i);
                            for (int i2 = 0; i2 < m19640b.length; i2++) {
                                c0173ao.m1339a().add(0, i2 + MediaCodec.CodecException.ERROR_INSUFFICIENT_RESOURCE, 0, m19640b[i2]).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f16174b) { // from class: ru.maximoff.apktool.fragment.a.b.3.4.1.1

                                    /* renamed from: a */
                                    private final AnonymousClass1 f16175a;

                                    /* renamed from: b */
                                    private final C3261t f16176b;

                                    {
                                        this.f16175a = this;
                                        this.f16176b = r2;
                                    }

                                    @Override // android.view.MenuItem.OnMenuItemClickListener
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        this.f16176b.m19544a(new File(menuItem.getTitle().toString()));
                                        return true;
                                    }
                                });
                            }
                            c0173ao.m1344c();
                        }
                    }
                });
                m414a.setOnLongClickListener(new View.OnLongClickListener(this, this.f16172c) { // from class: ru.maximoff.apktool.fragment.a.b.3.4.2

                    /* renamed from: a */
                    private final AnonymousClass4 f16177a;

                    /* renamed from: b */
                    private final C3261t f16178b;

                    {
                        this.f16177a = this;
                        this.f16178b = r2;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        int i;
                        List<String> m19205b = this.f16178b.m19549d().m19205b();
                        if (m19205b.isEmpty()) {
                            return false;
                        }
                        C0173ao c0173ao = new C0173ao(AnonymousClass3.m17739a(AnonymousClass4.m17740a(this.f16177a)).f16136b, view);
                        if (C3102bd.m18910a(AnonymousClass3.m17739a(AnonymousClass4.m17740a(this.f16177a)).f16136b, "menu_position", "1").equals("0")) {
                            i = 3;
                        } else {
                            i = 5;
                        }
                        c0173ao.m1340a(i);
                        Iterator<String> it = m19205b.iterator();
                        while (it.hasNext()) {
                            c0173ao.m1339a().add(0, 1300, 0, it.next()).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f16178b) { // from class: ru.maximoff.apktool.fragment.a.b.3.4.2.1

                                /* renamed from: a */
                                private final AnonymousClass2 f16179a;

                                /* renamed from: b */
                                private final C3261t f16180b;

                                {
                                    this.f16179a = this;
                                    this.f16180b = r2;
                                }

                                @Override // android.view.MenuItem.OnMenuItemClickListener
                                public boolean onMenuItemClick(MenuItem menuItem) {
                                    this.f16180b.m19544a(new File(menuItem.getTitle().toString()));
                                    return true;
                                }
                            });
                        }
                        c0173ao.m1344c();
                        return true;
                    }
                });
            }
        }
    }

    /* renamed from: v */
    public void m17736v(int i) {
        if (i >= this.f16137c.size()) {
            return;
        }
        this.f16137c.get(i).m17787c(true);
    }

    /* renamed from: b */
    public void m17701b(int i, String str) {
        if (i >= this.f16137c.size()) {
            return;
        }
        try {
            this.f16137c.get(i).m17784b(str);
        } catch (Exception e2) {
        }
    }

    /* renamed from: l */
    public synchronized void m17723l() {
        if (this.f16137c != null) {
            this.f16137c.clear();
        }
        this.f16140f = (C2986e) null;
        mo3289c();
    }

    /* renamed from: m */
    public void m17725m() {
        if (this.f16137c != null) {
            C3212b c3212b = new C3212b(this.f16136b, "editor_tabs", "");
            c3212b.m19208d();
            if (C3102bd.m18925a(this.f16136b, "editor_rem_tabs", false)) {
                for (RunnableC2979c runnableC2979c : this.f16137c) {
                    File m17795k = runnableC2979c.m17795k();
                    if (m17795k != null) {
                        c3212b.m19204a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(String.valueOf(runnableC2979c.m17802r())).append("|").toString()).append(String.valueOf(runnableC2979c.m17792h())).toString()).append("|").toString()).append(m17795k.getAbsolutePath()).toString());
                    }
                }
            }
        }
    }

    @Override // androidx.p044h.p045a.AbstractC0405a
    /* renamed from: a */
    public int mo3271a(Object obj) {
        for (RunnableC2979c runnableC2979c : this.f16137c) {
            if (runnableC2979c.m17806v() == obj) {
                return this.f16137c.indexOf(runnableC2979c);
            }
        }
        return -2;
    }

    /* renamed from: n */
    public boolean m17728n() {
        m17725m();
        if (this.f16137c == null) {
            return false;
        }
        Iterator<RunnableC2979c> it = this.f16137c.iterator();
        while (it.hasNext()) {
            if (it.next().m17796l()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public void m17703b(int i, boolean z) {
        if (i >= this.f16137c.size()) {
            return;
        }
        this.f16137c.get(i).m17806v().setEdited(z);
    }

    /* renamed from: b */
    public void m17704b(boolean z) {
        Iterator<RunnableC2979c> it = this.f16137c.iterator();
        while (it.hasNext()) {
            it.next().m17806v().setEdited(z);
        }
    }

    /* renamed from: c */
    public void m17706c(int i, String str) {
        if (i < this.f16137c.size()) {
            try {
                this.f16137c.get(i).m17806v().m19755b(str);
            } catch (Exception e2) {
                C3112bn.m18999a(this.f16136b, R.string.error);
            }
        }
    }

    /* renamed from: a */
    public int m17681a(int i, String str, boolean z, int i2) {
        if (i >= this.f16137c.size()) {
            return -1;
        }
        try {
            return this.f16137c.get(i).m17806v().m19750a(str, z, i2);
        } catch (Exception e2) {
            C3112bn.m18999a(this.f16136b, R.string.error);
            return -1;
        }
    }

    /* renamed from: a */
    public boolean m17697a(File file) {
        Uri fromFile = Uri.fromFile(file);
        Iterator<RunnableC2979c> it = this.f16137c.iterator();
        while (it.hasNext()) {
            if (it.next().m17793i().equals(fromFile)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.p044h.p045a.AbstractC0405a
    /* renamed from: c */
    public void mo3289c() {
        super.mo3289c();
    }
}
