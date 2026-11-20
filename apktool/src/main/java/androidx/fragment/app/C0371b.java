package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.p008os.Parcel;
import android.p008os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.AbstractC0393x;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

/* compiled from: BackStackState.java */
@SuppressLint({"BanParcelableUsage"})
/* renamed from: androidx.fragment.app.b */
/* loaded from: classes.dex */
final class C0371b implements Parcelable {
    public static final Parcelable.Creator<C0371b> CREATOR = new Parcelable.Creator<C0371b>() { // from class: androidx.fragment.app.b.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0371b createFromParcel(Parcel parcel) {
            return new C0371b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0371b[] newArray(int i) {
            return new C0371b[i];
        }
    };

    /* renamed from: a */
    final int[] f2532a;

    /* renamed from: b */
    final ArrayList<String> f2533b;

    /* renamed from: c */
    final int[] f2534c;

    /* renamed from: d */
    final int[] f2535d;

    /* renamed from: e */
    final int f2536e;

    /* renamed from: f */
    final String f2537f;

    /* renamed from: g */
    final int f2538g;

    /* renamed from: h */
    final int f2539h;

    /* renamed from: i */
    final CharSequence f2540i;

    /* renamed from: j */
    final int f2541j;

    /* renamed from: k */
    final CharSequence f2542k;

    /* renamed from: l */
    final ArrayList<String> f2543l;

    /* renamed from: m */
    final ArrayList<String> f2544m;

    /* renamed from: n */
    final boolean f2545n;

    public C0371b(C0363a c0363a) {
        int size = c0363a.f2844d.size();
        this.f2532a = new int[size * 5];
        if (!c0363a.f2850j) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f2533b = new ArrayList<>(size);
        this.f2534c = new int[size];
        this.f2535d = new int[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            AbstractC0393x.a aVar = c0363a.f2844d.get(i2);
            int i3 = i + 1;
            this.f2532a[i] = aVar.f2861a;
            this.f2533b.add(aVar.f2862b != null ? aVar.f2862b.f2643g : null);
            int i4 = i3 + 1;
            this.f2532a[i3] = aVar.f2863c;
            int i5 = i4 + 1;
            this.f2532a[i4] = aVar.f2864d;
            int i6 = i5 + 1;
            this.f2532a[i5] = aVar.f2865e;
            i = i6 + 1;
            this.f2532a[i6] = aVar.f2866f;
            this.f2534c[i2] = aVar.f2867g.ordinal();
            this.f2535d[i2] = aVar.f2868h.ordinal();
        }
        this.f2536e = c0363a.f2849i;
        this.f2537f = c0363a.f2852l;
        this.f2538g = c0363a.f2470c;
        this.f2539h = c0363a.f2853m;
        this.f2540i = c0363a.f2854n;
        this.f2541j = c0363a.f2855o;
        this.f2542k = c0363a.f2856p;
        this.f2543l = c0363a.f2857q;
        this.f2544m = c0363a.f2858r;
        this.f2545n = c0363a.f2859s;
    }

    public C0371b(Parcel parcel) {
        this.f2532a = parcel.createIntArray();
        this.f2533b = parcel.createStringArrayList();
        this.f2534c = parcel.createIntArray();
        this.f2535d = parcel.createIntArray();
        this.f2536e = parcel.readInt();
        this.f2537f = parcel.readString();
        this.f2538g = parcel.readInt();
        this.f2539h = parcel.readInt();
        this.f2540i = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2541j = parcel.readInt();
        this.f2542k = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2543l = parcel.createStringArrayList();
        this.f2544m = parcel.createStringArrayList();
        this.f2545n = parcel.readInt() != 0;
    }

    /* renamed from: a */
    public C0363a m2728a(AbstractC0384o abstractC0384o) {
        C0363a c0363a = new C0363a(abstractC0384o);
        int i = 0;
        int i2 = 0;
        while (i2 < this.f2532a.length) {
            AbstractC0393x.a aVar = new AbstractC0393x.a();
            int i3 = i2 + 1;
            aVar.f2861a = this.f2532a[i2];
            if (AbstractC0384o.m2976a(2)) {
                Log.m188v("FragmentManager", "Instantiate " + c0363a + " op #" + i + " base fragment #" + this.f2532a[i3]);
            }
            String str = this.f2533b.get(i);
            if (str != null) {
                aVar.f2862b = abstractC0384o.m3042d(str);
            } else {
                aVar.f2862b = null;
            }
            aVar.f2867g = Lifecycle.State.values()[this.f2534c[i]];
            aVar.f2868h = Lifecycle.State.values()[this.f2535d[i]];
            int i4 = i3 + 1;
            aVar.f2863c = this.f2532a[i3];
            int i5 = i4 + 1;
            aVar.f2864d = this.f2532a[i4];
            int i6 = i5 + 1;
            aVar.f2865e = this.f2532a[i5];
            i2 = i6 + 1;
            aVar.f2866f = this.f2532a[i6];
            c0363a.f2845e = aVar.f2863c;
            c0363a.f2846f = aVar.f2864d;
            c0363a.f2847g = aVar.f2865e;
            c0363a.f2848h = aVar.f2866f;
            c0363a.m3165a(aVar);
            i++;
        }
        c0363a.f2849i = this.f2536e;
        c0363a.f2852l = this.f2537f;
        c0363a.f2470c = this.f2538g;
        c0363a.f2850j = true;
        c0363a.f2853m = this.f2539h;
        c0363a.f2854n = this.f2540i;
        c0363a.f2855o = this.f2541j;
        c0363a.f2856p = this.f2542k;
        c0363a.f2857q = this.f2543l;
        c0363a.f2858r = this.f2544m;
        c0363a.f2859s = this.f2545n;
        c0363a.m2636a(1);
        return c0363a;
    }

    @Override // android.p008os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.p008os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f2532a);
        parcel.writeStringList(this.f2533b);
        parcel.writeIntArray(this.f2534c);
        parcel.writeIntArray(this.f2535d);
        parcel.writeInt(this.f2536e);
        parcel.writeString(this.f2537f);
        parcel.writeInt(this.f2538g);
        parcel.writeInt(this.f2539h);
        TextUtils.writeToParcel(this.f2540i, parcel, 0);
        parcel.writeInt(this.f2541j);
        TextUtils.writeToParcel(this.f2542k, parcel, 0);
        parcel.writeStringList(this.f2543l);
        parcel.writeStringList(this.f2544m);
        parcel.writeInt(this.f2545n ? 1 : 0);
    }
}
