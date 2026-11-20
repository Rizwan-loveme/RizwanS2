package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.C0433b;
import androidx.savedstate.InterfaceC0435d;
import java.util.Iterator;

/* loaded from: classes.dex */
final class SavedStateHandleController implements LifecycleEventObserver {
    static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";
    private final SavedStateHandle mHandle;
    private boolean mIsAttached = false;
    private final String mKey;

    SavedStateHandleController(String str, SavedStateHandle savedStateHandle) {
        this.mKey = str;
        this.mHandle = savedStateHandle;
    }

    boolean isAttached() {
        return this.mIsAttached;
    }

    void attachToLifecycle(C0433b c0433b, Lifecycle lifecycle) {
        if (this.mIsAttached) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.mIsAttached = true;
        lifecycle.addObserver(this);
        c0433b.m3348a(this.mKey, this.mHandle.savedStateProvider());
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.mIsAttached = false;
            lifecycleOwner.getLifecycle().removeObserver(this);
        }
    }

    SavedStateHandle getHandle() {
        return this.mHandle;
    }

    static SavedStateHandleController create(C0433b c0433b, Lifecycle lifecycle, String str, Bundle bundle) {
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, SavedStateHandle.createHandle(c0433b.m3344a(str), bundle));
        savedStateHandleController.attachToLifecycle(c0433b, lifecycle);
        tryToAddRecreator(c0433b, lifecycle);
        return savedStateHandleController;
    }

    static final class OnRecreation implements C0433b.a {
        OnRecreation() {
        }

        @Override // androidx.savedstate.C0433b.a
        public void onRecreated(InterfaceC0435d interfaceC0435d) {
            if (!(interfaceC0435d instanceof ViewModelStoreOwner)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
            }
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) interfaceC0435d).getViewModelStore();
            C0433b mo300d = interfaceC0435d.mo300d();
            Iterator<String> it = viewModelStore.keys().iterator();
            while (it.hasNext()) {
                SavedStateHandleController.attachHandleIfNeeded(viewModelStore.get(it.next()), mo300d, interfaceC0435d.getLifecycle());
            }
            if (!viewModelStore.keys().isEmpty()) {
                mo300d.m3347a(OnRecreation.class);
            }
        }
    }

    static void attachHandleIfNeeded(ViewModel viewModel, C0433b c0433b, Lifecycle lifecycle) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) viewModel.getTag(TAG_SAVED_STATE_HANDLE_CONTROLLER);
        if (savedStateHandleController != null && !savedStateHandleController.isAttached()) {
            savedStateHandleController.attachToLifecycle(c0433b, lifecycle);
            tryToAddRecreator(c0433b, lifecycle);
        }
    }

    private static void tryToAddRecreator(final C0433b c0433b, final Lifecycle lifecycle) {
        Lifecycle.State currentState = lifecycle.getCurrentState();
        if (currentState == Lifecycle.State.INITIALIZED || currentState.isAtLeast(Lifecycle.State.STARTED)) {
            c0433b.m3347a(OnRecreation.class);
        } else {
            lifecycle.addObserver(new LifecycleEventObserver() { // from class: androidx.lifecycle.SavedStateHandleController.1
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_START) {
                        Lifecycle.this.removeObserver(this);
                        c0433b.m3347a(OnRecreation.class);
                    }
                }
            });
        }
    }
}
