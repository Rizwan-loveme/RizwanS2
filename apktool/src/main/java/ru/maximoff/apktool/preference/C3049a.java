package ru.maximoff.apktool.preference;

import android.content.Context;
import android.preference.PreferenceActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.srizwan.apktool.R;
import java.util.List;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;

/* compiled from: CustomHeaderAdapter.java */
/* renamed from: ru.maximoff.apktool.preference.a */
/* loaded from: classes.dex */
public class C3049a extends ArrayAdapter<PreferenceActivity.Header> {

    /* renamed from: a */
    private Context f17089a;

    /* renamed from: b */
    private int f17090b;

    /* renamed from: c */
    private LayoutInflater f17091c;

    /* renamed from: d */
    private int f17092d;

    /* renamed from: e */
    private boolean f17093e;

    public C3049a(Context context, List<PreferenceActivity.Header> list, int i, boolean z) {
        super(context, 0, list);
        this.f17090b = 0;
        this.f17089a = context;
        this.f17091c = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.f17092d = i;
        this.f17093e = z;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int i2;
        if (view == null) {
            view = this.f17091c.inflate(this.f17092d, viewGroup, false);
            aVar = new a(this);
            aVar.f17096a = (ImageView) view.findViewById(R.id.icon);
            aVar.f17097b = (TextView) view.findViewById(R.id.title);
            aVar.f17098c = (TextView) view.findViewById(R.id.summary);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.f17097b.setTextSize(2, C3102bd.f18332o);
        aVar.f17098c.setTextSize(2, C3102bd.m18927b());
        PreferenceActivity.Header item = getItem(i);
        if (this.f17093e) {
            if (item.iconRes == 0) {
                aVar.f17096a.setVisibility(8);
            } else {
                boolean z = C3080al.m18608k(this.f17089a) == 0;
                switch (item.iconRes) {
                    case R.drawable.ic_build_light /* 2130837651 */:
                        if (!z) {
                            i2 = R.drawable.ic_build_dark;
                            break;
                        } else {
                            i2 = item.iconRes;
                            break;
                        }
                    case R.drawable.ic_edit_light /* 2130837673 */:
                        if (!z) {
                            i2 = R.drawable.ic_edit_dark;
                            break;
                        } else {
                            i2 = item.iconRes;
                            break;
                        }
                    case R.drawable.ic_faq /* 2130837677 */:
                        if (!z) {
                            i2 = R.drawable.ic_faq_dark;
                            break;
                        } else {
                            i2 = item.iconRes;
                            break;
                        }
                    case R.drawable.ic_help_light /* 2130837685 */:
                        if (!z) {
                            i2 = R.drawable.ic_help_dark;
                            break;
                        } else {
                            i2 = item.iconRes;
                            break;
                        }
                    case R.drawable.ic_rebuild_light /* 2130837724 */:
                        if (!z) {
                            i2 = R.drawable.ic_rebuild_dark;
                            break;
                        } else {
                            i2 = item.iconRes;
                            break;
                        }
                    case R.drawable.ic_sign_light /* 2130837742 */:
                        if (!z) {
                            i2 = R.drawable.ic_sign_dark;
                            break;
                        } else {
                            i2 = item.iconRes;
                            break;
                        }
                    case R.drawable.ic_update_light /* 2130837764 */:
                        if (!z) {
                            i2 = R.drawable.ic_update_dark;
                            break;
                        } else {
                            i2 = item.iconRes;
                            break;
                        }
                    default:
                        i2 = item.iconRes;
                        break;
                }
                aVar.f17096a.setVisibility(0);
                aVar.f17096a.setImageResource(i2);
            }
        } else {
            aVar.f17096a.setImageResource(item.iconRes);
        }
        aVar.f17097b.setText(item.getTitle(this.f17089a.getResources()));
        CharSequence summary = item.getSummary(this.f17089a.getResources());
        if (!C3112bn.m19014a(summary)) {
            aVar.f17098c.setVisibility(0);
            aVar.f17098c.setText(summary);
        } else {
            aVar.f17098c.setVisibility(8);
        }
        aVar.f17096a.setOnLongClickListener(new View.OnLongClickListener(this, item) { // from class: ru.maximoff.apktool.preference.a.1

            /* renamed from: a */
            private final C3049a f17094a;

            /* renamed from: b */
            private final PreferenceActivity.Header f17095b;

            {
                this.f17094a = this;
                this.f17095b = item;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                if (this.f17095b.iconRes != R.drawable.ic_help_light) {
                    return false;
                }
                this.f17094a.f17090b++;
                if (this.f17094a.f17090b < 3) {
                    return true;
                }
                boolean m18925a = C3102bd.m18925a(this.f17094a.f17089a, "amdm", false);
                C3102bd.m18938b(this.f17094a.f17089a, "amdm", !m18925a);
                C3112bn.m19023b(this.f17094a.f17089a, new StringBuffer().append("DM ").append(m18925a ? "OFF" : "ON").toString());
                this.f17094a.f17090b = 0;
                return true;
            }
        });
        return view;
    }

    /* compiled from: CustomHeaderAdapter.java */
    /* renamed from: ru.maximoff.apktool.preference.a$a */
    private class a {

        /* renamed from: a */
        ImageView f17096a;

        /* renamed from: b */
        TextView f17097b;

        /* renamed from: c */
        TextView f17098c;

        /* renamed from: d */
        private final C3049a f17099d;

        public a(C3049a c3049a) {
            this.f17099d = c3049a;
        }
    }
}
