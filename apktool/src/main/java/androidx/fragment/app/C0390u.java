package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: FragmentState.java */
@SuppressLint({"BanParcelableUsage"})
/* renamed from: androidx.fragment.app.u */
/* loaded from: classes.dex */
final class C0390u implements Parcelable {
    public static final Parcelable.Creator<C0390u> CREATOR = new Parcelable.Creator<C0390u>() { // from class: androidx.fragment.app.u.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0390u createFromParcel(Parcel parcel) {
            return new C0390u(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0390u[] newArray(int i) {
            return new C0390u[i];
        }
    };

    /* renamed from: a */
    final String f2818a;

    /* renamed from: b */
    final String f2819b;

    /* renamed from: c */
    final boolean f2820c;

    /* renamed from: d */
    final int f2821d;

    /* renamed from: e */
    final int f2822e;

    /* renamed from: f */
    final String f2823f;

    /* renamed from: g */
    final boolean f2824g;

    /* renamed from: h */
    final boolean f2825h;

    /* renamed from: i */
    final boolean f2826i;

    /* renamed from: j */
    final Bundle f2827j;

    /* renamed from: k */
    final boolean f2828k;

    /* renamed from: l */
    final int f2829l;

    /* renamed from: m */
    Bundle f2830m;

    C0390u(ComponentCallbacksC0374e componentCallbacksC0374e) {
        this.f2818a = componentCallbacksC0374e.getClass().getName();
        this.f2819b = componentCallbacksC0374e.f2643g;
        this.f2820c = componentCallbacksC0374e.f2650n;
        this.f2821d = componentCallbacksC0374e.f2659w;
        this.f2822e = componentCallbacksC0374e.f2660x;
        this.f2823f = componentCallbacksC0374e.f2661y;
        this.f2824g = componentCallbacksC0374e.f2612B;
        this.f2825h = componentCallbacksC0374e.f2649m;
        this.f2826i = componentCallbacksC0374e.f2611A;
        this.f2827j = componentCallbacksC0374e.f2644h;
        this.f2828k = componentCallbacksC0374e.f2662z;
        this.f2829l = componentCallbacksC0374e.f2627Q.ordinal();
    }

    C0390u(Parcel parcel) {
        this.f2818a = parcel.readString();
        this.f2819b = parcel.readString();
        this.f2820c = parcel.readInt() != 0;
        this.f2821d = parcel.readInt();
        this.f2822e = parcel.readInt();
        this.f2823f = parcel.readString();
        this.f2824g = parcel.readInt() != 0;
        this.f2825h = parcel.readInt() != 0;
        this.f2826i = parcel.readInt() != 0;
        this.f2827j = parcel.readBundle();
        this.f2828k = parcel.readInt() != 0;
        this.f2830m = parcel.readBundle();
        this.f2829l = parcel.readInt();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f2818a);
        sb.append(" (");
        sb.append(this.f2819b);
        sb.append(")}:");
        if (this.f2820c) {
            sb.append(" fromLayout");
        }
        if (this.f2822e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f2822e));
        }
        if (this.f2823f != null && !this.f2823f.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f2823f);
        }
        if (this.f2824g) {
            sb.append(" retainInstance");
        }
        if (this.f2825h) {
            sb.append(" removing");
        }
        if (this.f2826i) {
            sb.append(" detached");
        }
        if (this.f2828k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2818a);
        parcel.writeString(this.f2819b);
        parcel.writeInt(this.f2820c ? 1 : 0);
        parcel.writeInt(this.f2821d);
        parcel.writeInt(this.f2822e);
        parcel.writeString(this.f2823f);
        parcel.writeInt(this.f2824g ? 1 : 0);
        parcel.writeInt(this.f2825h ? 1 : 0);
        parcel.writeInt(this.f2826i ? 1 : 0);
        parcel.writeBundle(this.f2827j);
        parcel.writeInt(this.f2828k ? 1 : 0);
        parcel.writeBundle(this.f2830m);
        parcel.writeInt(this.f2829l);
    }
}
