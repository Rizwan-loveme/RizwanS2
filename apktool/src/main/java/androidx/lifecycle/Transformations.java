package androidx.lifecycle;

import androidx.arch.core.util.Function;

/* loaded from: classes.dex */
public class Transformations {
    private Transformations() {
    }

    public static <X, Y> LiveData<Y> map(LiveData<X> liveData, final Function<X, Y> function) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations.1
            @Override // androidx.lifecycle.Observer
            public void onChanged(X x) {
                MediatorLiveData.this.setValue(function.apply(x));
            }
        });
        return mediatorLiveData;
    }

    public static <X, Y> LiveData<Y> switchMap(LiveData<X> liveData, final Function<X, LiveData<Y>> function) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations.2
            LiveData<Y> mSource;

            @Override // androidx.lifecycle.Observer
            public void onChanged(X x) {
                LiveData<Y> liveData2 = (LiveData) Function.this.apply(x);
                if (this.mSource != liveData2) {
                    if (this.mSource != null) {
                        mediatorLiveData.removeSource(this.mSource);
                    }
                    this.mSource = liveData2;
                    if (this.mSource != null) {
                        mediatorLiveData.addSource(this.mSource, new Observer<Y>() { // from class: androidx.lifecycle.Transformations.2.1
                            @Override // androidx.lifecycle.Observer
                            public void onChanged(Y y) {
                                mediatorLiveData.setValue(y);
                            }
                        });
                    }
                }
            }
        });
        return mediatorLiveData;
    }

    public static <X> LiveData<X> distinctUntilChanged(LiveData<X> liveData) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations.3
            boolean mFirstTime = true;

            @Override // androidx.lifecycle.Observer
            public void onChanged(X x) {
                T value = MediatorLiveData.this.getValue();
                if (this.mFirstTime || ((value == 0 && x != null) || (value != 0 && !value.equals(x)))) {
                    this.mFirstTime = false;
                    MediatorLiveData.this.setValue(x);
                }
            }
        });
        return mediatorLiveData;
    }
}
