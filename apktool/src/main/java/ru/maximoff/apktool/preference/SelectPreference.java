package ru.maximoff.apktool.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import ru.maximoff.apktool.util.C3066aa;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3261t;

/* loaded from: classes.dex */
public class SelectPreference extends CustomPreference {

    /* renamed from: a */
    private EditText f17069a;

    /* renamed from: b */
    private ImageButton f17070b;

    /* renamed from: c */
    private DialogInterface.OnClickListener f17071c;

    public SelectPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17071c = new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.preference.SelectPreference.3

            /* renamed from: a */
            private final SelectPreference f17082a;

            {
                this.f17082a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == -1) {
                    SharedPreferences.Editor edit = this.f17082a.getSharedPreferences().edit();
                    edit.putString("output_directory", this.f17082a.f17069a.getText().toString());
                    edit.commit();
                } else if (i == -3) {
                    SharedPreferences.Editor edit2 = this.f17082a.getSharedPreferences().edit();
                    edit2.putString("output_directory", "");
                    edit2.commit();
                }
            }
        };
    }

    @Override // android.preference.Preference
    protected void onClick() {
        Context context = getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.select_dir, (ViewGroup) null);
        C3066aa c3066aa = new C3066aa(context);
        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(context);
        aVar.m435b(inflate);
        aVar.m418a(R.string.output_directory);
        aVar.m434b(R.string.cancel, this.f17071c);
        aVar.m420a(R.string.save, this.f17071c);
        Bitmap m18363a = c3066aa.m18363a(!C3102bd.f18291a ? -16777216 : Color.DKGRAY, R.drawable.ic_folder);
        this.f17069a = (EditText) inflate.findViewById(R.id.selectdirEditText1);
        String string = getSharedPreferences().getString("output_directory", "");
        this.f17069a.setText(string);
        this.f17070b = (ImageButton) inflate.findViewById(R.id.selectdirImageButton1);
        this.f17070b.setImageBitmap(m18363a);
        this.f17070b.setOnClickListener(new ViewOnClickListenerC30451(this, context));
        DialogInterfaceC0070b m438b = aVar.m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, string) { // from class: ru.maximoff.apktool.preference.SelectPreference.2

            /* renamed from: a */
            private final SelectPreference f17080a;

            /* renamed from: b */
            private final String f17081b;

            {
                this.f17080a = this;
                this.f17081b = string;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f17080a.f17069a.requestFocus();
                this.f17080a.f17069a.setSelection(this.f17081b.length());
            }
        });
        m438b.show();
    }

    /* renamed from: ru.maximoff.apktool.preference.SelectPreference$1 */
    class ViewOnClickListenerC30451 implements View.OnClickListener {

        /* renamed from: a */
        private final SelectPreference f17072a;

        /* renamed from: b */
        private final Context f17073b;

        ViewOnClickListenerC30451(SelectPreference selectPreference, Context context) {
            this.f17072a = selectPreference;
            this.f17073b = context;
        }

        /* renamed from: a */
        static SelectPreference m18141a(ViewOnClickListenerC30451 viewOnClickListenerC30451) {
            return viewOnClickListenerC30451.f17072a;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C3261t c3261t = new C3261t(this.f17073b);
            Runnable runnable = new Runnable(this, c3261t) { // from class: ru.maximoff.apktool.preference.SelectPreference.1.1

                /* renamed from: a */
                private final ViewOnClickListenerC30451 f17074a;

                /* renamed from: b */
                private final C3261t f17075b;

                {
                    this.f17074a = this;
                    this.f17075b = c3261t;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String path = this.f17075b.getPath();
                    ViewOnClickListenerC30451.m18141a(this.f17074a).f17069a.requestFocus();
                    ViewOnClickListenerC30451.m18141a(this.f17074a).f17069a.setText(path);
                    ViewOnClickListenerC30451.m18141a(this.f17074a).f17069a.setSelection(path.length());
                }
            };
            c3261t.m19545a("_od");
            c3261t.setCallback(runnable);
            c3261t.m19550e();
            DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(this.f17073b);
            aVar.m427a(c3261t.m19548c());
            aVar.m435b(c3261t);
            aVar.m420a(R.string.mselect, new DialogInterface.OnClickListener(this, runnable) { // from class: ru.maximoff.apktool.preference.SelectPreference.1.2

                /* renamed from: a */
                private final ViewOnClickListenerC30451 f17076a;

                /* renamed from: b */
                private final Runnable f17077b;

                {
                    this.f17076a = this;
                    this.f17077b = runnable;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f17077b.run();
                    dialogInterface.dismiss();
                }
            });
            aVar.m434b(R.string.cancel, (DialogInterface.OnClickListener) null);
            aVar.m429a(false);
            aVar.m422a(new DialogInterface.OnKeyListener(this, c3261t) { // from class: ru.maximoff.apktool.preference.SelectPreference.1.3

                /* renamed from: a */
                private final ViewOnClickListenerC30451 f17078a;

                /* renamed from: b */
                private final C3261t f17079b;

                {
                    this.f17078a = this;
                    this.f17079b = c3261t;
                }

                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                        return false;
                    }
                    boolean m19551f = this.f17079b.m19551f();
                    if (!m19551f) {
                        dialogInterface.dismiss();
                        return m19551f;
                    }
                    return m19551f;
                }
            });
            DialogInterfaceC0070b m438b = aVar.m438b();
            c3261t.setDialog(m438b);
            m438b.show();
        }
    }
}
