package ru.maximoff.apktool.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import ru.maximoff.apktool.util.C3092ax;
import ru.maximoff.apktool.util.C3093ay;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;

/* loaded from: classes.dex */
public class EditorPanelPreference extends CustomPreference {

    /* renamed from: a */
    private int f16903a;

    public EditorPanelPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16903a = 0;
    }

    /* renamed from: a */
    private boolean m18094a() {
        if (!getKey().equals("quick_panel_symbols")) {
            return false;
        }
        this.f16903a = R.string.quick_panel_sym;
        return true;
    }

    @Override // android.preference.Preference
    protected void onClick() {
        if (m18094a()) {
            Context context = getContext();
            C3092ax c3092ax = new C3092ax(context);
            C3093ay c3093ay = new C3093ay(context);
            DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(context);
            aVar.m435b(c3092ax);
            aVar.m418a(this.f16903a);
            aVar.m434b(R.string.madd, (DialogInterface.OnClickListener) null);
            aVar.m420a(R.string.f21470ok, (DialogInterface.OnClickListener) null);
            aVar.m440c(R.string.search_reset, new DialogInterface.OnClickListener(this, c3093ay, context) { // from class: ru.maximoff.apktool.preference.EditorPanelPreference.1

                /* renamed from: a */
                private final EditorPanelPreference f16904a;

                /* renamed from: b */
                private final C3093ay f16905b;

                /* renamed from: c */
                private final Context f16906c;

                {
                    this.f16904a = this;
                    this.f16905b = c3093ay;
                    this.f16906c = context;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                    this.f16905b.m18789h();
                    C3102bd.f18336s = true;
                    C3112bn.m18999a(this.f16906c, R.string.success);
                }
            });
            DialogInterfaceC0070b m438b = aVar.m438b();
            m438b.setOnShowListener(new DialogInterface.OnShowListener(this, c3092ax, m438b) { // from class: ru.maximoff.apktool.preference.EditorPanelPreference.2

                /* renamed from: a */
                private final EditorPanelPreference f16907a;

                /* renamed from: b */
                private final C3092ax f16908b;

                /* renamed from: c */
                private final DialogInterfaceC0070b f16909c;

                {
                    this.f16907a = this;
                    this.f16908b = c3092ax;
                    this.f16909c = m438b;
                }

                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    this.f16908b.setDialog(this.f16909c);
                    this.f16909c.m414a(-2).setOnClickListener(new View.OnClickListener(this, this.f16908b) { // from class: ru.maximoff.apktool.preference.EditorPanelPreference.2.1

                        /* renamed from: a */
                        private final DialogInterfaceOnShowListenerC30202 f16910a;

                        /* renamed from: b */
                        private final C3092ax f16911b;

                        {
                            this.f16910a = this;
                            this.f16911b = r2;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            this.f16911b.m18761a();
                        }
                    });
                }
            });
            m438b.show();
        }
    }
}
