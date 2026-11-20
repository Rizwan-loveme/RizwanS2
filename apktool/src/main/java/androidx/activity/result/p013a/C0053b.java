package androidx.activity.result.p013a;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.C0051a;
import androidx.activity.result.p013a.AbstractC0052a;
import androidx.core.content.C0255a;
import androidx.p011a.C0036a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ActivityResultContracts.java */
/* renamed from: androidx.activity.result.a.b */
/* loaded from: classes.dex */
public final class C0053b {

    /* compiled from: ActivityResultContracts.java */
    /* renamed from: androidx.activity.result.a.b$b */
    public static final class b extends AbstractC0052a<Intent, C0051a> {
        @Override // androidx.activity.result.p013a.AbstractC0052a
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public Intent mo314a(Context context, Intent intent) {
            return intent;
        }

        @Override // androidx.activity.result.p013a.AbstractC0052a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0051a mo315a(int i, Intent intent) {
            return new C0051a(i, intent);
        }
    }

    /* compiled from: ActivityResultContracts.java */
    /* renamed from: androidx.activity.result.a.b$a */
    public static final class a extends AbstractC0052a<String[], Map<String, Boolean>> {
        @Override // androidx.activity.result.p013a.AbstractC0052a
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public Intent mo314a(Context context, String[] strArr) {
            return m318a(strArr);
        }

        @Override // androidx.activity.result.p013a.AbstractC0052a
        /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public AbstractC0052a.a<Map<String, Boolean>> mo316b(Context context, String[] strArr) {
            if (strArr == null || strArr.length == 0) {
                return new AbstractC0052a.a<>(Collections.emptyMap());
            }
            C0036a c0036a = new C0036a();
            int length = strArr.length;
            int i = 0;
            boolean z = true;
            while (i < length) {
                String str = strArr[i];
                boolean z2 = C0255a.m1852b(context, str) == 0;
                c0036a.put(str, Boolean.valueOf(z2));
                i++;
                z = !z2 ? false : z;
            }
            if (z) {
                return new AbstractC0052a.a<>(c0036a);
            }
            return null;
        }

        @Override // androidx.activity.result.p013a.AbstractC0052a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map<String, Boolean> mo315a(int i, Intent intent) {
            if (i == -1 && intent != null) {
                String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                if (intArrayExtra == null || stringArrayExtra == null) {
                    return Collections.emptyMap();
                }
                HashMap hashMap = new HashMap();
                int length = stringArrayExtra.length;
                for (int i2 = 0; i2 < length; i2++) {
                    hashMap.put(stringArrayExtra[i2], Boolean.valueOf(intArrayExtra[i2] == 0));
                }
                return hashMap;
            }
            return Collections.emptyMap();
        }

        /* renamed from: a */
        static Intent m318a(String[] strArr) {
            return new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
        }
    }
}
