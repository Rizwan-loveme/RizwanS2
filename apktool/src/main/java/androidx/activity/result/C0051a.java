package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ActivityResult.java */
@SuppressLint({"BanParcelableUsage"})
/* renamed from: androidx.activity.result.a */
/* loaded from: classes.dex */
public final class C0051a implements Parcelable {
    public static final Parcelable.Creator<C0051a> CREATOR = new Parcelable.Creator<C0051a>() { // from class: androidx.activity.result.a.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0051a createFromParcel(Parcel parcel) {
            return new C0051a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0051a[] newArray(int i) {
            return new C0051a[i];
        }
    };

    /* renamed from: a */
    private final int f391a;

    /* renamed from: b */
    private final Intent f392b;

    public C0051a(int i, Intent intent) {
        this.f391a = i;
        this.f392b = intent;
    }

    C0051a(Parcel parcel) {
        this.f391a = parcel.readInt();
        this.f392b = parcel.readInt() == 0 ? null : Intent.CREATOR.createFromParcel(parcel);
    }

    /* renamed from: a */
    public int m310a() {
        return this.f391a;
    }

    /* renamed from: b */
    public Intent m311b() {
        return this.f392b;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + m309a(this.f391a) + ", data=" + this.f392b + '}';
    }

    /* renamed from: a */
    public static String m309a(int i) {
        switch (i) {
            case -1:
                return "RESULT_OK";
            case 0:
                return "RESULT_CANCELED";
            default:
                return String.valueOf(i);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f391a);
        parcel.writeInt(this.f392b == null ? 0 : 1);
        if (this.f392b != null) {
            this.f392b.writeToParcel(parcel, i);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
