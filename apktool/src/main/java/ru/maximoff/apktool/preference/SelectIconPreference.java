package ru.maximoff.apktool.preference;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.p006pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;

/* loaded from: classes.dex */
public class SelectIconPreference extends CustomPreference {
    public SelectIconPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.preference.Preference
    protected void onClick() {
        Context context = getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.select_icon, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.selectIconImageView1);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.selectIconImageView2);
        RadioButton radioButton = (RadioButton) inflate.findViewById(R.id.selectIconRadioButton1);
        RadioButton radioButton2 = (RadioButton) inflate.findViewById(R.id.selectIconRadioButton2);
        boolean m18925a = C3102bd.m18925a(context, "use_dark_icon", false);
        radioButton.setChecked(m18925a ? false : true);
        radioButton2.setChecked(m18925a);
        View.OnClickListener onClickListener = new View.OnClickListener(this, radioButton, radioButton2) { // from class: ru.maximoff.apktool.preference.SelectIconPreference.1

            /* renamed from: a */
            private final SelectIconPreference f17057a;

            /* renamed from: b */
            private final RadioButton f17058b;

            /* renamed from: c */
            private final RadioButton f17059c;

            {
                this.f17057a = this;
                this.f17058b = radioButton;
                this.f17059c = radioButton2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.selectIconImageView1 /* 2131690010 */:
                    case R.id.selectIconRadioButton1 /* 2131690011 */:
                        this.f17058b.setChecked(true);
                        this.f17059c.setChecked(false);
                        break;
                    case R.id.selectIconImageView2 /* 2131690012 */:
                    case R.id.selectIconRadioButton2 /* 2131690013 */:
                        this.f17058b.setChecked(false);
                        this.f17059c.setChecked(true);
                        break;
                }
            }
        };
        imageView.setOnClickListener(onClickListener);
        imageView2.setOnClickListener(onClickListener);
        radioButton.setOnClickListener(onClickListener);
        radioButton2.setOnClickListener(onClickListener);
        new DialogInterfaceC0070b.a(context).m418a(R.string.select_icon).m435b(inflate).m420a(R.string.save, new DialogInterface.OnClickListener(this, radioButton2, m18925a, context) { // from class: ru.maximoff.apktool.preference.SelectIconPreference.2

            /* renamed from: a */
            private final SelectIconPreference f17060a;

            /* renamed from: b */
            private final RadioButton f17061b;

            /* renamed from: c */
            private final boolean f17062c;

            /* renamed from: d */
            private final Context f17063d;

            {
                this.f17060a = this;
                this.f17061b = radioButton2;
                this.f17062c = m18925a;
                this.f17063d = context;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                boolean isChecked = this.f17061b.isChecked();
                if (this.f17062c ? !isChecked : isChecked) {
                    this.f17060a.m18136a(this.f17063d, isChecked);
                }
                dialogInterface.cancel();
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m18136a(Context context, boolean z) {
        new DialogInterfaceC0070b.a(context).m418a(R.string.select_icon).m433b(R.string.select_icon_info).m420a(R.string.yes, new DialogInterface.OnClickListener(this, context, z) { // from class: ru.maximoff.apktool.preference.SelectIconPreference.3

            /* renamed from: a */
            private final SelectIconPreference f17064a;

            /* renamed from: b */
            private final Context f17065b;

            /* renamed from: c */
            private final boolean f17066c;

            {
                this.f17064a = this;
                this.f17065b = context;
                this.f17066c = z;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                C3102bd.m18938b(this.f17065b, "use_dark_icon", this.f17066c);
                this.f17064a.m18138b(this.f17065b, this.f17066c);
                dialogInterface.cancel();
            }
        }).m434b(R.string.f21469no, (DialogInterface.OnClickListener) null).m438b().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m18138b(Context context, boolean z) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        ComponentName componentName = new ComponentName(context, new StringBuffer().append(packageName).append(".SplashLightIcon").toString());
        ComponentName componentName2 = new ComponentName(context, new StringBuffer().append(packageName).append(".SplashDarkIcon").toString());
        packageManager.setComponentEnabledSetting(z ? componentName2 : componentName, 1, 1);
        if (!z) {
            componentName = componentName2;
        }
        packageManager.setComponentEnabledSetting(componentName, 2, 1);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this, context) { // from class: ru.maximoff.apktool.preference.SelectIconPreference.4

            /* renamed from: a */
            private final SelectIconPreference f17067a;

            /* renamed from: b */
            private final Context f17068b;

            {
                this.f17067a = this;
                this.f17068b = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                C3080al.m18613o(this.f17068b);
            }
        }, 300L);
    }
}
