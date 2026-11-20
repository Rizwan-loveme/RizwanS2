package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.p008os.Bundle;
import android.p008os.Parcel;
import android.p008os.Parcelable;
import androidx.fragment.app.AbstractC0384o;
import java.util.ArrayList;

/* compiled from: FragmentManagerState.java */
@SuppressLint({"BanParcelableUsage"})
/* renamed from: androidx.fragment.app.q */
/* loaded from: classes.dex */
final class C0386q implements Parcelable {
    public static final Parcelable.Creator<C0386q> CREATOR = new Parcelable.Creator<C0386q>() { // from class: androidx.fragment.app.q.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0386q createFromParcel(Parcel parcel) {
            return new C0386q(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0386q[] newArray(int i) {
            return new C0386q[i];
        }
    };

    /* renamed from: a */
    ArrayList<C0390u> f2802a;

    /* renamed from: b */
    ArrayList<String> f2803b;

    /* renamed from: c */
    C0371b[] f2804c;

    /* renamed from: d */
    int f2805d;

    /* renamed from: e */
    String f2806e;

    /* renamed from: f */
    ArrayList<String> f2807f;

    /* renamed from: g */
    ArrayList<Bundle> f2808g;

    /* renamed from: h */
    ArrayList<AbstractC0384o.c> f2809h;

    public C0386q() {
        this.f2806e = null;
        this.f2807f = new ArrayList<>();
        this.f2808g = new ArrayList<>();
    }

    public C0386q(Parcel parcel) {
        this.f2806e = null;
        this.f2807f = new ArrayList<>();
        this.f2808g = new ArrayList<>();
        this.f2802a = parcel.createTypedArrayList(C0390u.CREATOR);
        this.f2803b = parcel.createStringArrayList();
        this.f2804c = (C0371b[]) parcel.createTypedArray(C0371b.CREATOR);
        this.f2805d = parcel.readInt();
        this.f2806e = parcel.readString();
        this.f2807f = parcel.createStringArrayList();
        this.f2808g = parcel.createTypedArrayList(Bundle.CREATOR);
        this.f2809h = parcel.createTypedArrayList(AbstractC0384o.c.CREATOR);
    }

    @Override // android.p008os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.p008os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f2802a);
        parcel.writeStringList(this.f2803b);
        parcel.writeTypedArray(this.f2804c, i);
        parcel.writeInt(this.f2805d);
        parcel.writeString(this.f2806e);
        parcel.writeStringList(this.f2807f);
        parcel.writeTypedList(this.f2808g);
        parcel.writeTypedList(this.f2809h);
    }
}
