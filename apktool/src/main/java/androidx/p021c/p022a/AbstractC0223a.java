package androidx.p021c.p022a;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: AbsSavedState.java */
@SuppressLint({"BanParcelableUsage"})
/* renamed from: androidx.c.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC0223a implements Parcelable {

    /* renamed from: a */
    private final Parcelable f1799a;

    /* renamed from: c */
    public static final AbstractC0223a f1798c = new AbstractC0223a() { // from class: androidx.c.a.a.1
    };
    public static final Parcelable.Creator<AbstractC0223a> CREATOR = new Parcelable.ClassLoaderCreator<AbstractC0223a>() { // from class: androidx.c.a.a.2
        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC0223a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) != null) {
                throw new IllegalStateException("superState must be null");
            }
            return AbstractC0223a.f1798c;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC0223a createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC0223a[] newArray(int i) {
            return new AbstractC0223a[i];
        }
    };

    private AbstractC0223a() {
        this.f1799a = null;
    }

    protected AbstractC0223a(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.f1799a = parcelable == f1798c ? null : parcelable;
    }

    protected AbstractC0223a(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f1799a = readParcelable == null ? f1798c : readParcelable;
    }

    /* renamed from: a */
    public final Parcelable m1617a() {
        return this.f1799a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f1799a, i);
    }
}
