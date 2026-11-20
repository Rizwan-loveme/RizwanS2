package ru.maximoff.apktool;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.p006pm.ActivityInfo;
import android.content.p006pm.PackageInfo;
import android.content.p006pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.app.ActivityC0071c;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.activities.C3071a;
import ru.maximoff.apktool.util.activities.MActList;

/* loaded from: classes.dex */
public class ActivityList extends ActivityC0071c {

    /* renamed from: h */
    private long f13580h = 0;

    @Override // androidx.fragment.app.ActivityC0375f, androidx.activity.ActivityC0048b, androidx.core.app.ActivityC0234e, android.app.Activity
    protected void onCreate(Bundle bundle) {
        m16368o();
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("activity_list")) {
            try {
                m16369a(intent.getStringArrayListExtra("activity_list"));
            } catch (Exception e2) {
                C3112bn.m18999a(this, R.string.error);
                finish();
            }
            intent.removeExtra("activity_list");
            return;
        }
        C3112bn.m18999a(this, R.string.error);
        finish();
    }

    @Override // android.app.Activity
    public void finish() {
        if (Build.VERSION.SDK_INT >= 21) {
            finishAndRemoveTask();
        }
        super.finish();
    }

    /* renamed from: a */
    public void m16369a(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            C3112bn.m18999a(this, R.string.empty);
            finish();
            return;
        }
        Collections.reverse(arrayList);
        PackageManager packageManager = getPackageManager();
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String[] split = it.next().split("/", 2);
            ActivityInfo m16365a = m16365a(new ComponentName(split[0], split[1]));
            if (m16365a == null) {
                PackageInfo m16366a = m16366a(split[0]);
                if (m16366a != null) {
                    arrayList2.add(new C3071a(m16366a.packageName, split[1], m16366a.applicationInfo.loadLabel(packageManager), m16366a.applicationInfo.loadIcon(packageManager), true, true));
                }
            } else {
                arrayList2.add(new C3071a(m16365a.packageName, m16365a.name, m16365a.loadLabel(packageManager), m16365a.loadIcon(packageManager), (m16365a.enabled && m16365a.exported) ? false : true));
            }
        }
        View inflate = getLayoutInflater().inflate(R.layout.act_list, (ViewGroup) null);
        MActList mActList = (MActList) inflate.findViewById(R.id.actlistListView1);
        mActList.m18409a(true);
        mActList.m18408a(arrayList2);
        EditText editText = (EditText) inflate.findViewById(R.id.actlistEditText1);
        C3112bn.m19006a(editText, 10000);
        editText.addTextChangedListener(new TextWatcher(this, mActList) { // from class: ru.maximoff.apktool.ActivityList.1

            /* renamed from: a */
            private final ActivityList f13581a;

            /* renamed from: b */
            private final MActList f13582b;

            {
                this.f13581a = this;
                this.f13582b = mActList;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                this.f13582b.setFilter(editable.toString());
            }
        });
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this).m427a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(getString(R.string.act_list)).append(" (").toString()).append(arrayList2.size()).toString()).append(")").toString()).m435b(inflate).m429a(false).m420a(R.string.hide, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.ActivityList.2

            /* renamed from: a */
            private final ActivityList f13583a;

            {
                this.f13583a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                this.f13583a.finish();
            }
        }).m440c(R.string.search_reset, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.ActivityList.3

            /* renamed from: a */
            private final ActivityList f13584a;

            {
                this.f13584a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Intent intent = new Intent(this.f13584a, Class.forName("ru.maximoff.apktool.service.ActivityDetectingService"));
                    intent.setAction("ru.maximoff.apktool.AccessibilityService.RESET");
                    this.f13584a.startService(intent);
                    dialogInterface.dismiss();
                    this.f13584a.finish();
                } catch (ClassNotFoundException e2) {
                    throw new NoClassDefFoundError(e2.getMessage());
                }
            }
        }).m438b();
        m438b.setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: ru.maximoff.apktool.ActivityList.4

            /* renamed from: a */
            private final ActivityList f13585a;

            {
                this.f13585a = this;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                    return false;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f13585a.f13580h > 2000) {
                    C3112bn.m18999a(this.f13585a, R.string.click_once_more2);
                    this.f13585a.f13580h = currentTimeMillis;
                    return false;
                }
                dialogInterface.cancel();
                return true;
            }
        });
        m438b.setOnCancelListener(new DialogInterface.OnCancelListener(this) { // from class: ru.maximoff.apktool.ActivityList.5

            /* renamed from: a */
            private final ActivityList f13586a;

            {
                this.f13586a = this;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                this.f13586a.finish();
            }
        });
        mActList.setDialog(m438b);
        m438b.show();
    }

    /* renamed from: a */
    private ActivityInfo m16365a(ComponentName componentName) {
        try {
            return getPackageManager().getActivityInfo(componentName, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            return (ActivityInfo) null;
        }
    }

    /* renamed from: a */
    private PackageInfo m16366a(String str) {
        try {
            return getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            return (PackageInfo) null;
        }
    }

    /* renamed from: o */
    private void m16368o() {
        int i;
        switch (C3102bd.f18319b) {
            case 0:
                setTheme(R.style.TransparentThemeLight);
                break;
            case 1:
                setTheme(R.style.TransparentTheme);
                break;
            case 2:
                setTheme(R.style.TransparentThemeBlack);
                break;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            View decorView = getWindow().getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (C3102bd.f18291a) {
                i = systemUiVisibility | 16;
            } else {
                i = systemUiVisibility & (-17);
            }
            decorView.setSystemUiVisibility(i);
        }
    }
}
