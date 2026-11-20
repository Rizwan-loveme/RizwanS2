package ru.maximoff.apktool.util;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.srizwan.apktool.R;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.fragment.p301a.C2978b;
import ru.maximoff.apktool.view.EditorPager;

/* compiled from: MenuLongPress.java */
/* renamed from: ru.maximoff.apktool.util.ao */
/* loaded from: classes.dex */
public class ViewOnLongClickListenerC3083ao implements View.OnLongClickListener {

    /* renamed from: a */
    private EditorPager f18013a;

    /* renamed from: b */
    private Handler f18014b;

    /* renamed from: c */
    private long f18015c = 300;

    public ViewOnLongClickListenerC3083ao(EditorPager editorPager) {
        this.f18013a = editorPager;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        int id = view.getId();
        int currentItem = this.f18013a.getCurrentItem();
        if (id == R.id.save) {
            C2978b.f16135a.m17691a(currentItem, false);
            return true;
        }
        Runnable runnable = new Runnable(this, id, currentItem) { // from class: ru.maximoff.apktool.util.ao.1

            /* renamed from: a */
            private final ViewOnLongClickListenerC3083ao f18016a;

            /* renamed from: b */
            private final int f18017b;

            /* renamed from: c */
            private final int f18018c;

            {
                this.f18016a = this;
                this.f18017b = id;
                this.f18018c = currentItem;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean m17716h;
                switch (this.f18017b) {
                    case R.id.undo /* 2131690239 */:
                        m17716h = C2978b.f16135a.m17714g(this.f18018c);
                        break;
                    case R.id.redo /* 2131690240 */:
                        m17716h = C2978b.f16135a.m17716h(this.f18018c);
                        break;
                    default:
                        m17716h = false;
                        break;
                }
                if (m17716h) {
                    switch (this.f18017b) {
                        case R.id.undo /* 2131690239 */:
                            C2978b.f16135a.m17720j(this.f18018c);
                            break;
                        case R.id.redo /* 2131690240 */:
                            C2978b.f16135a.m17722k(this.f18018c);
                            break;
                        default:
                            return;
                    }
                    if (this.f18016a.f18015c > 100) {
                        this.f18016a.f18015c -= 20;
                    }
                    this.f18016a.f18014b.postDelayed(this, this.f18016a.f18015c);
                }
            }
        };
        view.setOnTouchListener(new View.OnTouchListener(this, view) { // from class: ru.maximoff.apktool.util.ao.2

            /* renamed from: a */
            private final ViewOnLongClickListenerC3083ao f18019a;

            /* renamed from: b */
            private final View f18020b;

            {
                this.f18019a = this;
                this.f18020b = view;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 1:
                    case 3:
                        if (this.f18019a.f18014b != null) {
                            this.f18019a.f18014b.removeCallbacksAndMessages((Object) null);
                            this.f18019a.f18014b = (Handler) null;
                            this.f18019a.f18015c = 300L;
                            this.f18020b.setOnTouchListener((View.OnTouchListener) null);
                            MainActivity.m16615o().invalidateOptionsMenu();
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        this.f18014b = new Handler(Looper.getMainLooper());
        this.f18014b.postDelayed(runnable, 0);
        return true;
    }
}
