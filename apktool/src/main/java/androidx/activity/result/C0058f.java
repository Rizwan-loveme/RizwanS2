package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: IntentSenderRequest.java */
@SuppressLint({"BanParcelableUsage"})
/* renamed from: androidx.activity.result.f */
/* loaded from: classes.dex */
public final class C0058f implements Parcelable {
    public static final Parcelable.Creator<C0058f> CREATOR = new Parcelable.Creator<C0058f>() { // from class: androidx.activity.result.f.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0058f createFromParcel(Parcel parcel) {
            return new C0058f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0058f[] newArray(int i) {
            return new C0058f[i];
        }
    };

    /* renamed from: a */
    private final IntentSender f410a;

    /* renamed from: b */
    private final Intent f411b;

    /* renamed from: c */
    private final int f412c;

    /* renamed from: d */
    private final int f413d;

    C0058f(IntentSender intentSender, Intent intent, int i, int i2) {
        this.f410a = intentSender;
        this.f411b = intent;
        this.f412c = i;
        this.f413d = i2;
    }

    /* renamed from: a */
    public IntentSender m336a() {
        return this.f410a;
    }

    /* renamed from: b */
    public Intent m337b() {
        return this.f411b;
    }

    /* renamed from: c */
    public int m338c() {
        return this.f412c;
    }

    /* renamed from: d */
    public int m339d() {
        return this.f413d;
    }

    C0058f(Parcel parcel) {
        this.f410a = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.f411b = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f412c = parcel.readInt();
        this.f413d = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f410a, i);
        parcel.writeParcelable(this.f411b, i);
        parcel.writeInt(this.f412c);
        parcel.writeInt(this.f413d);
    }

    /* compiled from: IntentSenderRequest.java */
    /* renamed from: androidx.activity.result.f$a */
    public static final class a {

        /* renamed from: a */
        private IntentSender f414a;

        /* renamed from: b */
        private Intent f415b;

        /* renamed from: c */
        private int f416c;

        /* renamed from: d */
        private int f417d;

        public a(IntentSender intentSender) {
            this.f414a = intentSender;
        }

        /* renamed from: a */
        public a m343a(Intent intent) {
            this.f415b = intent;
            return this;
        }

        /* renamed from: a */
        public a m342a(int i, int i2) {
            this.f417d = i;
            this.f416c = i2;
            return this;
        }

        /* renamed from: a */
        public C0058f m344a() {
            return new C0058f(this.f414a, this.f415b, this.f416c, this.f417d);
        }
    }
}
