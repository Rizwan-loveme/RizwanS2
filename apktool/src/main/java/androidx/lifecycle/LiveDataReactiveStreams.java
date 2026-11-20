package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.atomic.AtomicReference;
import org.p284h.InterfaceC2550a;
import org.p284h.InterfaceC2551b;
import org.p284h.InterfaceC2552c;

/* loaded from: classes.dex */
public final class LiveDataReactiveStreams {
    private LiveDataReactiveStreams() {
    }

    public static <T> InterfaceC2550a<T> toPublisher(LifecycleOwner lifecycleOwner, LiveData<T> liveData) {
        return new LiveDataPublisher(lifecycleOwner, liveData);
    }

    private static final class LiveDataPublisher<T> implements InterfaceC2550a<T> {
        final LifecycleOwner mLifecycle;
        final LiveData<T> mLiveData;

        LiveDataPublisher(LifecycleOwner lifecycleOwner, LiveData<T> liveData) {
            this.mLifecycle = lifecycleOwner;
            this.mLiveData = liveData;
        }

        @Override // org.p284h.InterfaceC2550a
        public void subscribe(InterfaceC2551b<? super T> interfaceC2551b) {
            interfaceC2551b.onSubscribe(new LiveDataSubscription(interfaceC2551b, this.mLifecycle, this.mLiveData));
        }

        static final class LiveDataSubscription<T> implements Observer<T>, InterfaceC2552c {
            volatile boolean mCanceled;
            T mLatest;
            final LifecycleOwner mLifecycle;
            final LiveData<T> mLiveData;
            boolean mObserving;
            long mRequested;
            final InterfaceC2551b<? super T> mSubscriber;

            LiveDataSubscription(InterfaceC2551b<? super T> interfaceC2551b, LifecycleOwner lifecycleOwner, LiveData<T> liveData) {
                this.mSubscriber = interfaceC2551b;
                this.mLifecycle = lifecycleOwner;
                this.mLiveData = liveData;
            }

            @Override // androidx.lifecycle.Observer
            public void onChanged(T t) {
                if (this.mCanceled) {
                    return;
                }
                if (this.mRequested > 0) {
                    this.mLatest = null;
                    this.mSubscriber.onNext(t);
                    if (this.mRequested != Long.MAX_VALUE) {
                        this.mRequested--;
                        return;
                    }
                    return;
                }
                this.mLatest = t;
            }

            @Override // org.p284h.InterfaceC2552c
            public void request(final long j) {
                if (!this.mCanceled) {
                    ArchTaskExecutor.getInstance().executeOnMainThread(new Runnable() { // from class: androidx.lifecycle.LiveDataReactiveStreams.LiveDataPublisher.LiveDataSubscription.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (LiveDataSubscription.this.mCanceled) {
                                return;
                            }
                            if (j <= 0) {
                                LiveDataSubscription.this.mCanceled = true;
                                if (LiveDataSubscription.this.mObserving) {
                                    LiveDataSubscription.this.mLiveData.removeObserver(LiveDataSubscription.this);
                                    LiveDataSubscription.this.mObserving = false;
                                }
                                LiveDataSubscription.this.mLatest = null;
                                LiveDataSubscription.this.mSubscriber.onError(new IllegalArgumentException("Non-positive request"));
                                return;
                            }
                            LiveDataSubscription.this.mRequested = LiveDataSubscription.this.mRequested + j >= LiveDataSubscription.this.mRequested ? LiveDataSubscription.this.mRequested + j : Long.MAX_VALUE;
                            if (!LiveDataSubscription.this.mObserving) {
                                LiveDataSubscription.this.mObserving = true;
                                LiveDataSubscription.this.mLiveData.observe(LiveDataSubscription.this.mLifecycle, LiveDataSubscription.this);
                            } else if (LiveDataSubscription.this.mLatest != null) {
                                LiveDataSubscription.this.onChanged(LiveDataSubscription.this.mLatest);
                                LiveDataSubscription.this.mLatest = null;
                            }
                        }
                    });
                }
            }

            @Override // org.p284h.InterfaceC2552c
            public void cancel() {
                if (!this.mCanceled) {
                    this.mCanceled = true;
                    ArchTaskExecutor.getInstance().executeOnMainThread(new Runnable() { // from class: androidx.lifecycle.LiveDataReactiveStreams.LiveDataPublisher.LiveDataSubscription.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (LiveDataSubscription.this.mObserving) {
                                LiveDataSubscription.this.mLiveData.removeObserver(LiveDataSubscription.this);
                                LiveDataSubscription.this.mObserving = false;
                            }
                            LiveDataSubscription.this.mLatest = null;
                        }
                    });
                }
            }
        }
    }

    public static <T> LiveData<T> fromPublisher(InterfaceC2550a<T> interfaceC2550a) {
        return new PublisherLiveData(interfaceC2550a);
    }

    private static class PublisherLiveData<T> extends LiveData<T> {
        private final InterfaceC2550a<T> mPublisher;
        final AtomicReference<PublisherLiveData<T>.LiveDataSubscriber> mSubscriber = new AtomicReference<>();

        PublisherLiveData(InterfaceC2550a<T> interfaceC2550a) {
            this.mPublisher = interfaceC2550a;
        }

        @Override // androidx.lifecycle.LiveData
        protected void onActive() {
            super.onActive();
            PublisherLiveData<T>.LiveDataSubscriber liveDataSubscriber = new LiveDataSubscriber();
            this.mSubscriber.set(liveDataSubscriber);
            this.mPublisher.subscribe(liveDataSubscriber);
        }

        @Override // androidx.lifecycle.LiveData
        protected void onInactive() {
            super.onInactive();
            PublisherLiveData<T>.LiveDataSubscriber andSet = this.mSubscriber.getAndSet(null);
            if (andSet != null) {
                andSet.cancelSubscription();
            }
        }

        final class LiveDataSubscriber extends AtomicReference<InterfaceC2552c> implements InterfaceC2551b<T> {
            LiveDataSubscriber() {
            }

            @Override // org.p284h.InterfaceC2551b
            public void onSubscribe(InterfaceC2552c interfaceC2552c) {
                if (compareAndSet(null, interfaceC2552c)) {
                    interfaceC2552c.request(Long.MAX_VALUE);
                } else {
                    interfaceC2552c.cancel();
                }
            }

            @Override // org.p284h.InterfaceC2551b
            public void onNext(T t) {
                PublisherLiveData.this.postValue(t);
            }

            @Override // org.p284h.InterfaceC2551b
            public void onError(final Throwable th) {
                PublisherLiveData.this.mSubscriber.compareAndSet(this, null);
                ArchTaskExecutor.getInstance().executeOnMainThread(new Runnable() { // from class: androidx.lifecycle.LiveDataReactiveStreams.PublisherLiveData.LiveDataSubscriber.1
                    @Override // java.lang.Runnable
                    public void run() {
                        throw new RuntimeException("LiveData does not handle errors. Errors from publishers should be handled upstream and propagated as state", th);
                    }
                });
            }

            public void onComplete() {
                PublisherLiveData.this.mSubscriber.compareAndSet(this, null);
            }

            public void cancelSubscription() {
                InterfaceC2552c interfaceC2552c = get();
                if (interfaceC2552c != null) {
                    interfaceC2552c.cancel();
                }
            }
        }
    }
}
