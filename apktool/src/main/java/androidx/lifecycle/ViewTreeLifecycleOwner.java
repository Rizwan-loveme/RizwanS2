package androidx.lifecycle;

import android.view.View;
import android.view.ViewParent;
import androidx.lifecycle.runtime.C0427R;

/* loaded from: classes.dex */
public class ViewTreeLifecycleOwner {
    private ViewTreeLifecycleOwner() {
    }

    public static void set(View view, LifecycleOwner lifecycleOwner) {
        view.setTag(C0427R.id.view_tree_lifecycle_owner, lifecycleOwner);
    }

    public static LifecycleOwner get(View view) {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) view.getTag(C0427R.id.view_tree_lifecycle_owner);
        if (lifecycleOwner == null) {
            ViewParent parent = view.getParent();
            while (lifecycleOwner == null && (parent instanceof View)) {
                View view2 = (View) parent;
                LifecycleOwner lifecycleOwner2 = (LifecycleOwner) view2.getTag(C0427R.id.view_tree_lifecycle_owner);
                parent = view2.getParent();
                lifecycleOwner = lifecycleOwner2;
            }
        }
        return lifecycleOwner;
    }
}
