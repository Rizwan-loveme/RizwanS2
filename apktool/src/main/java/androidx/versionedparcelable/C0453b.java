package androidx.versionedparcelable;

import android.p008os.Parcel;
import android.p008os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.p011a.C0036a;
import java.lang.reflect.Method;

/* compiled from: VersionedParcelParcel.java */
/* renamed from: androidx.versionedparcelable.b */
/* loaded from: classes.dex */
class C0453b extends AbstractC0452a {

    /* renamed from: d */
    private final SparseIntArray f3256d;

    /* renamed from: e */
    private final Parcel f3257e;

    /* renamed from: f */
    private final int f3258f;

    /* renamed from: g */
    private final int f3259g;

    /* renamed from: h */
    private final String f3260h;

    /* renamed from: i */
    private int f3261i;

    /* renamed from: j */
    private int f3262j;

    /* renamed from: k */
    private int f3263k;

    C0453b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new C0036a(), new C0036a(), new C0036a());
    }

    private C0453b(Parcel parcel, int i, int i2, String str, C0036a<String, Method> c0036a, C0036a<String, Method> c0036a2, C0036a<String, Class> c0036a3) {
        super(c0036a, c0036a2, c0036a3);
        this.f3256d = new SparseIntArray();
        this.f3261i = -1;
        this.f3262j = 0;
        this.f3263k = -1;
        this.f3257e = parcel;
        this.f3258f = i;
        this.f3259g = i2;
        this.f3262j = this.f3258f;
        this.f3260h = str;
    }

    @Override // androidx.versionedparcelable.AbstractC0452a
    /* renamed from: b */
    public boolean mo3452b(int i) {
        while (this.f3262j < this.f3259g) {
            if (this.f3263k == i) {
                return true;
            }
            if (String.valueOf(this.f3263k).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            this.f3257e.setDataPosition(this.f3262j);
            int readInt = this.f3257e.readInt();
            this.f3263k = this.f3257e.readInt();
            this.f3262j = readInt + this.f3262j;
        }
        return this.f3263k == i;
    }

    @Override // androidx.versionedparcelable.AbstractC0452a
    /* renamed from: c */
    public void mo3456c(int i) {
        mo3451b();
        this.f3261i = i;
        this.f3256d.put(i, this.f3257e.dataPosition());
        mo3429a(0);
        mo3429a(i);
    }

    @Override // androidx.versionedparcelable.AbstractC0452a
    /* renamed from: b */
    public void mo3451b() {
        if (this.f3261i >= 0) {
            int i = this.f3256d.get(this.f3261i);
            int dataPosition = this.f3257e.dataPosition();
            this.f3257e.setDataPosition(i);
            this.f3257e.writeInt(dataPosition - i);
            this.f3257e.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.AbstractC0452a
    /* renamed from: c */
    protected AbstractC0452a mo3455c() {
        return new C0453b(this.f3257e, this.f3257e.dataPosition(), this.f3262j == this.f3258f ? this.f3259g : this.f3262j, this.f3260h + "  ", this.f3253a, this.f3254b, this.f3255c);
    }

    @Override // androidx.versionedparcelable.AbstractC0452a
    /* renamed from: a */
    public void mo3443a(byte[] bArr) {
        if (bArr != null) {
            this.f3257e.writeInt(bArr.length);
            this.f3257e.writeByteArray(bArr);
        } else {
            this.f3257e.writeInt(-1);
        }
    }

    @Override // androidx.versionedparcelable.AbstractC0452a
    /* renamed from: a */
    public void mo3429a(int i) {
        this.f3257e.writeInt(i);
    }

    @Override // androidx.versionedparcelable.AbstractC0452a
    /* renamed from: a */
    public void mo3438a(String str) {
        this.f3257e.writeString(str);
    }

    @Override // androidx.versionedparcelable.AbstractC0452a
    /* renamed from: a */
    public void mo3431a(Parcelable parcelable) {
        this.f3257e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.AbstractC0452a
    /* renamed from: a */
    public void mo3440a(boolean z) {
        this.f3257e.writeInt(z ? 1 : 0);
    }

    @Override // androidx.versionedparcelable.AbstractC0452a
    /* renamed from: a */
    protected void mo3436a(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f3257e, 0);
    }

    @Override // androidx.versionedparcelable.AbstractC0452a
    /* renamed from: g */
    protected CharSequence mo3460g() {
        return TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f3257e);
    }

    @Override // androidx.versionedparcelable.AbstractC0452a
    /* renamed from: d */
    public int mo3457d() {
        return this.f3257e.readInt();
    }

    @Override // androidx.versionedparcelable.AbstractC0452a
    /* renamed from: e */
    public String mo3458e() {
        return this.f3257e.readString();
    }

    @Override // androidx.versionedparcelable.AbstractC0452a
    /* renamed from: f */
    public byte[] mo3459f() {
        int readInt = this.f3257e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f3257e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.AbstractC0452a
    /* renamed from: h */
    public <T extends Parcelable> T mo3461h() {
        return (T) this.f3257e.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.AbstractC0452a
    /* renamed from: i */
    public boolean mo3462i() {
        return this.f3257e.readInt() != 0;
    }
}
