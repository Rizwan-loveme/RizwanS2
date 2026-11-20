package ru.maximoff.apktool.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.p008os.AsyncTask;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Spinner;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.p209io.File;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.p300e.AsyncTaskC2946q;
import ru.maximoff.apktool.p300e.AsyncTaskC2955z;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;

/* loaded from: classes.dex */
public class Frameworks extends CustomPreference {

    /* renamed from: a */
    private Context f16912a;

    public Frameworks(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.preference.Preference
    protected void onClick() {
        this.f16912a = getContext();
        new DialogInterfaceC0070b.a(this.f16912a).m418a(R.string.man_frame).m431a(new String[]{this.f16912a.getString(R.string.man_frame_summary), this.f16912a.getString(R.string.import_system), this.f16912a.getString(R.string.down_for, "SDK")}, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.preference.Frameworks.1

            /* renamed from: a */
            private final Frameworks f16913a;

            {
                this.f16913a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                switch (i) {
                    case 0:
                        C3080al.m18550a(this.f16913a.f16912a, (Spinner) null, 0);
                        break;
                    case 1:
                        this.f16913a.m18096a();
                        break;
                    case 2:
                        this.f16913a.m18097b();
                        break;
                }
            }
        }).m420a(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m18096a() {
        new DialogInterfaceC0070b.a(this.f16912a).m418a(R.string.import_system).m431a(new String[]{this.f16912a.getString(R.string.for_miui), this.f16912a.getString(R.string.for_others)}, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.preference.Frameworks.2

            /* renamed from: a */
            private final Frameworks f16914a;

            {
                this.f16914a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                AsyncTaskC2955z asyncTaskC2955z = new AsyncTaskC2955z(this.f16914a.f16912a, (InterfaceC2995n) null);
                switch (i) {
                    case 0:
                        asyncTaskC2955z.m17601g(true);
                        break;
                    case 1:
                        asyncTaskC2955z.m17601g(false);
                        break;
                }
                asyncTaskC2955z.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new File[0]);
            }
        }).m420a(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m18097b() {
        String[] strArr = new String[15];
        for (int i = 22; i <= 36; i++) {
            strArr[i - 22] = String.format("%s (SDK %d)", C3080al.m18532a(i, false), new Integer(i));
        }
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f16912a).m427a(this.f16912a.getString(R.string.down_for, "SDK")).m431a(strArr, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.preference.Frameworks.3

            /* renamed from: a */
            private final Frameworks f16915a;

            {
                this.f16915a = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                int i3 = i2 + 22;
                AsyncTaskC2946q asyncTaskC2946q = new AsyncTaskC2946q(this.f16915a.f16912a, new File(this.f16915a.f16912a.getFilesDir(), "framework/user"), "/bin/frameworks/");
                asyncTaskC2946q.m17551c(true);
                try {
                    asyncTaskC2946q.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new StringBuffer().append(new StringBuffer().append("sdk-").append(i3).toString()).append(".apk").toString());
                } catch (Exception e2) {
                    C3112bn.m18999a(this.f16915a.f16912a, R.string.error_try_again);
                }
            }
        }).m420a(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.server, (DialogInterface.OnClickListener) null).m438b();
        m438b.setOnShowListener(new DialogInterfaceOnShowListenerC30244(this, m438b));
        m438b.show();
    }

    /* renamed from: ru.maximoff.apktool.preference.Frameworks$4 */
    class DialogInterfaceOnShowListenerC30244 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final Frameworks f16916a;

        /* renamed from: b */
        private final DialogInterfaceC0070b f16917b;

        DialogInterfaceOnShowListenerC30244(Frameworks frameworks, DialogInterfaceC0070b dialogInterfaceC0070b) {
            this.f16916a = frameworks;
            this.f16917b = dialogInterfaceC0070b;
        }

        /* renamed from: a */
        static Frameworks m18100a(DialogInterfaceOnShowListenerC30244 dialogInterfaceOnShowListenerC30244) {
            return dialogInterfaceOnShowListenerC30244.f16916a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            this.f16917b.m414a(-3).setOnClickListener(new AnonymousClass1(this));
        }

        /* renamed from: ru.maximoff.apktool.preference.Frameworks$4$1, reason: invalid class name */
        class AnonymousClass1 implements View.OnClickListener {

            /* renamed from: a */
            private final DialogInterfaceOnShowListenerC30244 f16918a;

            AnonymousClass1(DialogInterfaceOnShowListenerC30244 dialogInterfaceOnShowListenerC30244) {
                this.f16918a = dialogInterfaceOnShowListenerC30244;
            }

            /* renamed from: a */
            static DialogInterfaceOnShowListenerC30244 m18101a(AnonymousClass1 anonymousClass1) {
                return anonymousClass1.f16918a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i = 0;
                String[] strArr = {"githubusercontent.com", "maximoff.su", "beget.tech"};
                int m18905a = C3102bd.m18905a(DialogInterfaceOnShowListenerC30244.m18100a(this.f16918a).f16912a, "aapts_server", 0);
                if (m18905a > strArr.length - 1) {
                    C3102bd.m18935b(DialogInterfaceOnShowListenerC30244.m18100a(this.f16918a).f16912a, "aapts_server", 0);
                } else {
                    i = m18905a;
                }
                new DialogInterfaceC0070b.a(DialogInterfaceOnShowListenerC30244.m18100a(this.f16918a).f16912a).m418a(R.string.server).m430a(strArr, i, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.preference.Frameworks.4.1.1

                    /* renamed from: a */
                    private final AnonymousClass1 f16919a;

                    {
                        this.f16919a = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        C3102bd.m18935b(DialogInterfaceOnShowListenerC30244.m18100a(AnonymousClass1.m18101a(this.f16919a)).f16912a, "aapts_server", i2);
                        dialogInterface.cancel();
                    }
                }).m420a(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
            }
        }
    }
}
