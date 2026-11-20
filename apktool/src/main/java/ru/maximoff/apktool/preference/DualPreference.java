package ru.maximoff.apktool.preference;

import android.C0012R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.p008os.Build;
import android.preference.SwitchPreference;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.p065b.p066a.p067a.AbstractC0581c;
import com.srizwan.apktool.R;
import java.util.Arrays;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;

/* loaded from: classes.dex */
public class DualPreference extends SwitchPreference {

    /* renamed from: a */
    private final int f16876a;

    /* renamed from: b */
    private Context f16877b;

    public DualPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16876a = 777;
        this.f16877b = context;
    }

    public DualPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16876a = 777;
        this.f16877b = context;
    }

    public DualPreference(Context context) {
        super(context);
        this.f16876a = 777;
        this.f16877b = context;
    }

    /* renamed from: a */
    private Switch m18087a(View view) {
        Switch m18087a;
        if (view instanceof Switch) {
            return (Switch) view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= viewGroup.getChildCount()) {
                    break;
                }
                View childAt = viewGroup.getChildAt(i2);
                if ((childAt instanceof ViewGroup) && (m18087a = m18087a(childAt)) != null) {
                    return m18087a;
                }
                if (!(childAt instanceof Switch)) {
                    i = i2 + 1;
                } else {
                    return (Switch) childAt;
                }
            }
        }
        return (Switch) null;
    }

    /* renamed from: a */
    private void m18088a(View view, View view2) {
        if (view.findViewById(777) == null && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            viewGroup.addView(m18086a(), viewGroup.indexOfChild(view2));
        }
    }

    @Override // android.preference.SwitchPreference, android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(C0012R.id.title);
        if (textView != null) {
            C3112bn.m19001a(this.f16877b, textView, C0012R.style.TextAppearance_Medium);
            textView.setSingleLine(false);
            textView.setTextSize(2, C3102bd.f18332o);
        }
        TextView textView2 = (TextView) view.findViewById(C0012R.id.summary);
        if (textView2 != null) {
            C3112bn.m19001a(this.f16877b, textView2, C0012R.style.TextAppearance_Small);
            textView2.setSingleLine(false);
            textView2.setTextSize(2, C3102bd.m18927b());
        }
        int resourceId = this.f16877b.obtainStyledAttributes(new int[]{C0012R.attr.selectableItemBackground}).getResourceId(0, 0);
        Switch m18087a = m18087a(view);
        if (m18087a != null) {
            m18087a.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.preference.DualPreference.1

                /* renamed from: a */
                private final DualPreference f16878a;

                {
                    this.f16878a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    this.f16878a.getSharedPreferences().edit().putBoolean(this.f16878a.getKey(), ((Switch) view2).isChecked()).commit();
                }
            });
            m18087a.setChecked(getSharedPreferences().getBoolean(getKey(), false));
            m18087a.setFocusable(true);
            m18087a.setEnabled(isEnabled());
            View findViewById = view.findViewById(C0012R.id.widget_frame);
            if (findViewById != null) {
                m18088a(view, findViewById);
                findViewById.setBackgroundResource(resourceId);
                findViewById.setOnClickListener(new View.OnClickListener(this, m18087a) { // from class: ru.maximoff.apktool.preference.DualPreference.2

                    /* renamed from: a */
                    private final DualPreference f16879a;

                    /* renamed from: b */
                    private final Switch f16880b;

                    {
                        this.f16879a = this;
                        this.f16880b = m18087a;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (this.f16879a.isEnabled()) {
                            this.f16880b.performClick();
                        }
                    }
                });
            }
        }
        view.setBackgroundResource(resourceId);
        view.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.preference.DualPreference.3

            /* renamed from: a */
            private final DualPreference f16881a;

            {
                this.f16881a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                this.f16881a.m18089a(this.f16881a.getKey());
            }
        });
    }

    /* renamed from: a */
    private View m18086a() {
        int m18574b = C3080al.m18574b(this.f16877b, 5);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(C3080al.m18574b(this.f16877b, 1), -1);
        marginLayoutParams.setMargins(m18574b, m18574b * 2, m18574b, m18574b * 2);
        TypedValue typedValue = new TypedValue();
        this.f16877b.getTheme().resolveAttribute(C0012R.attr.dividerVertical, typedValue, true);
        View view = new View(this.f16877b);
        view.setId(777);
        view.setBackgroundResource(typedValue.resourceId);
        view.setLayoutParams(marginLayoutParams);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m18089a(String str) {
        Intent intent;
        if (isEnabled()) {
            if (str.equals("perm_description")) {
                boolean m18925a = C3102bd.m18925a(this.f16877b, "short_perm_description", false);
                new DialogInterfaceC0070b.a(this.f16877b).m418a(R.string.description_type).m430a(new String[]{this.f16877b.getString(R.string.mshort), this.f16877b.getString(R.string.mlong)}, m18925a ? 0 : 1, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.preference.DualPreference.4

                    /* renamed from: a */
                    private final DualPreference f16882a;

                    {
                        this.f16882a = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C3102bd.m18938b(this.f16882a.f16877b, "short_perm_description", i == 0);
                    }
                }).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m438b().show();
                return;
            }
            if (str.equals("copyOriginalFiles")) {
                new DialogInterfaceC0070b.a(this.f16877b).m418a(R.string.copyOriginalFiles).m432a(new String[]{this.f16877b.getString(R.string.signature), AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME}, new boolean[]{C3102bd.m18925a(this.f16877b, "copy_original_sign", true), C3102bd.m18925a(this.f16877b, "copy_original_mf", false)}, new DialogInterface.OnMultiChoiceClickListener(this) { // from class: ru.maximoff.apktool.preference.DualPreference.5

                    /* renamed from: a */
                    private final DualPreference f16883a;

                    {
                        this.f16883a = this;
                    }

                    @Override // android.content.DialogInterface.OnMultiChoiceClickListener
                    public void onClick(DialogInterface dialogInterface, int i, boolean z) {
                        switch (i) {
                            case 0:
                                C3102bd.m18938b(this.f16883a.f16877b, "copy_original_sign", z);
                                break;
                            case 1:
                                C3102bd.m18938b(this.f16883a.f16877b, "copy_original_mf", z);
                                break;
                        }
                    }
                }).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m438b().show();
                return;
            }
            if (str.equals("floating_button")) {
                new DialogInterfaceC0070b.a(this.f16877b).m418a(R.string.floating_button).m433b(R.string.reset_fab).m420a(R.string.yes, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.preference.DualPreference.6

                    /* renamed from: a */
                    private final DualPreference f16884a;

                    {
                        this.f16884a = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C3102bd.m18924a(this.f16884a.f16877b, "floating_button_position");
                        C3102bd.f18320c = true;
                        C3112bn.m18999a(this.f16884a.f16877b, R.string.success);
                        dialogInterface.cancel();
                    }
                }).m434b(R.string.f21469no, (DialogInterface.OnClickListener) null).m438b().show();
                return;
            }
            if (str.equals("installLocation")) {
                String[] stringArray = this.f16877b.getResources().getStringArray(R.array.installLocation);
                String[] strArr = (String[]) Arrays.copyOfRange(stringArray, 1, stringArray.length);
                int[] iArr = {C3102bd.m18905a(this.f16877b, "inlocation_idx", 1)};
                new DialogInterfaceC0070b.a(this.f16877b).m418a(R.string.mapp_inLocation).m430a(strArr, iArr[0], new DialogInterface.OnClickListener(this, iArr) { // from class: ru.maximoff.apktool.preference.DualPreference.7

                    /* renamed from: a */
                    private final DualPreference f16885a;

                    /* renamed from: b */
                    private final int[] f16886b;

                    {
                        this.f16885a = this;
                        this.f16886b = iArr;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        this.f16886b[0] = i;
                        if (i == 2) {
                            C3080al.m18614p(this.f16885a.f16877b);
                        }
                    }
                }).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, iArr) { // from class: ru.maximoff.apktool.preference.DualPreference.8

                    /* renamed from: a */
                    private final DualPreference f16887a;

                    /* renamed from: b */
                    private final int[] f16888b;

                    {
                        this.f16887a = this;
                        this.f16888b = iArr;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C3102bd.m18935b(this.f16887a.f16877b, "inlocation_idx", this.f16888b[0]);
                        dialogInterface.cancel();
                    }
                }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.search_reset, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.preference.DualPreference.9

                    /* renamed from: a */
                    private final DualPreference f16889a;

                    {
                        this.f16889a = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C3102bd.m18924a(this.f16889a.f16877b, "inlocation_idx");
                        dialogInterface.cancel();
                    }
                }).m438b().show();
                return;
            }
            if (str.equals("build_notification")) {
                String packageName = this.f16877b.getPackageName();
                try {
                    if (Build.VERSION.SDK_INT >= 26) {
                        intent = new Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
                        intent.putExtra(Settings.EXTRA_APP_PACKAGE, packageName);
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        intent = new Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
                        intent.putExtra("app_package", packageName);
                        intent.putExtra("app_uid", this.f16877b.getApplicationInfo().uid);
                    } else {
                        intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        intent.setData(Uri.parse(new StringBuffer().append("package:").append(packageName).toString()));
                    }
                    if (intent.resolveActivity(this.f16877b.getPackageManager()) != null) {
                        this.f16877b.startActivity(intent);
                    } else {
                        C3080al.m18588c(this.f16877b, packageName);
                    }
                } catch (Exception e2) {
                    C3080al.m18588c(this.f16877b, packageName);
                }
            }
        }
    }
}
