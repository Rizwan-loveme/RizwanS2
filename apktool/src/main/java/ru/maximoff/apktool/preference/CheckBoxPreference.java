package ru.maximoff.apktool.preference;

import android.C0012R;
import android.content.Context;
import android.preference.SwitchPreference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.srizwan.apktool.R;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;

/* loaded from: classes.dex */
public class CheckBoxPreference extends SwitchPreference implements View.OnLongClickListener {

    /* renamed from: a */
    private final String[] f16866a;

    /* renamed from: b */
    private Context f16867b;

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16866a = new String[]{"snowfall"};
        this.f16867b = context;
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16866a = new String[]{"snowfall"};
        this.f16867b = context;
    }

    public CheckBoxPreference(Context context) {
        super(context);
        this.f16866a = new String[]{"snowfall"};
        this.f16867b = context;
    }

    @Override // android.preference.SwitchPreference, android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(C0012R.id.title);
        if (textView != null) {
            C3112bn.m19001a(this.f16867b, textView, C0012R.style.TextAppearance_Medium);
            textView.setSingleLine(false);
            textView.setTextSize(2, C3102bd.f18332o);
        }
        TextView textView2 = (TextView) view.findViewById(C0012R.id.summary);
        if (textView2 != null) {
            C3112bn.m19001a(this.f16867b, textView2, C0012R.style.TextAppearance_Small);
            textView2.setSingleLine(false);
            textView2.setTextSize(2, C3102bd.m18927b());
        }
    }

    @Override // android.preference.Preference
    protected View onCreateView(ViewGroup viewGroup) {
        ((ListView) viewGroup).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(this) { // from class: ru.maximoff.apktool.preference.CheckBoxPreference.1

            /* renamed from: a */
            private final CheckBoxPreference f16868a;

            {
                this.f16868a = this;
            }

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                Object item = ((ListView) adapterView).getAdapter().getItem(i);
                if (item == null || !(item instanceof View.OnLongClickListener)) {
                    return false;
                }
                return ((View.OnLongClickListener) item).onLongClick(view);
            }
        });
        return super.onCreateView(viewGroup);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        for (String str : this.f16866a) {
            if (str.equals(getKey())) {
                return m18082a(str);
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m18082a(String str) {
        if (!str.equals("snowfall")) {
            return false;
        }
        boolean m18925a = C3102bd.m18925a(this.f16867b, "snowfall_force", false);
        boolean m18925a2 = C3102bd.m18925a(this.f16867b, "snowfall_sfr", true);
        C3102bd.m18938b(this.f16867b, "snowfall_force", !m18925a);
        if (m18925a) {
            C3102bd.m18938b(this.f16867b, "snowfall_sfr", !m18925a2);
        }
        C3102bd.f18320c = true;
        Object[] objArr = new Object[2];
        objArr[0] = this.f16867b.getString(m18925a ? R.string.hide : R.string.show);
        objArr[1] = new Integer(m18925a2 ? 1 : 2);
        C3112bn.m19023b(this.f16867b, String.format("%s [%d]", objArr));
        return true;
    }
}
