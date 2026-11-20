package androidx.activity.result.p013a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

/* compiled from: ActivityResultContract.java */
/* renamed from: androidx.activity.result.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC0052a<I, O> {
    /* renamed from: a */
    public abstract Intent mo314a(Context context, @SuppressLint({"UnknownNullness"}) I i);

    @SuppressLint({"UnknownNullness"})
    /* renamed from: a */
    public abstract O mo315a(int i, Intent intent);

    /* renamed from: b */
    public a<O> mo316b(Context context, @SuppressLint({"UnknownNullness"}) I i) {
        return null;
    }

    /* compiled from: ActivityResultContract.java */
    /* renamed from: androidx.activity.result.a.a$a */
    public static final class a<T> {

        /* renamed from: a */
        @SuppressLint({"UnknownNullness"})
        private final T f393a;

        public a(@SuppressLint({"UnknownNullness"}) T t) {
            this.f393a = t;
        }

        @SuppressLint({"UnknownNullness"})
        /* renamed from: a */
        public T m317a() {
            return this.f393a;
        }
    }
}
