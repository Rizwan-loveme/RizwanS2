package androidx.lifecycle;

import android.view.View;
import android.view.ViewParent;
import androidx.lifecycle.viewmodel.C0429R;

/* loaded from: classes.dex */
public class ViewTreeViewModelStoreOwner {
    private ViewTreeViewModelStoreOwner() {
    }

    public static void set(View view, ViewModelStoreOwner viewModelStoreOwner) {
        view.setTag(C0429R.id.view_tree_view_model_store_owner, viewModelStoreOwner);
    }

    public static ViewModelStoreOwner get(View view) {
        ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) view.getTag(C0429R.id.view_tree_view_model_store_owner);
        if (viewModelStoreOwner == null) {
            ViewParent parent = view.getParent();
            while (viewModelStoreOwner == null && (parent instanceof View)) {
                View view2 = (View) parent;
                ViewModelStoreOwner viewModelStoreOwner2 = (ViewModelStoreOwner) view2.getTag(C0429R.id.view_tree_view_model_store_owner);
                parent = view2.getParent();
                viewModelStoreOwner = viewModelStoreOwner2;
            }
        }
        return viewModelStoreOwner;
    }
}
