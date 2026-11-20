package androidx.core.p027c;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.p006pm.PackageManager;
import android.content.p006pm.ProviderInfo;
import android.content.p006pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.provider.FontsContract;
import androidx.core.content.p028a.C0258c;
import androidx.core.p027c.C0251f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: FontProvider.java */
/* renamed from: androidx.core.c.c */
/* loaded from: classes.dex */
class C0248c {

    /* renamed from: a */
    private static final Comparator<byte[]> f1969a = new Comparator<byte[]>() { // from class: androidx.core.c.c.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            if (bArr.length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return bArr[i] - bArr2[i];
                }
            }
            return 0;
        }
    };

    /* renamed from: a */
    static C0251f.a m1800a(Context context, C0249d c0249d, CancellationSignal cancellationSignal) {
        ProviderInfo m1799a = m1799a(context.getPackageManager(), c0249d, context.getResources());
        if (m1799a == null) {
            return C0251f.a.m1823a(1, null);
        }
        return C0251f.a.m1823a(0, m1804a(context, c0249d, m1799a.authority, cancellationSignal));
    }

    /* renamed from: a */
    static ProviderInfo m1799a(PackageManager packageManager, C0249d c0249d, Resources resources) {
        int i = 0;
        String m1807a = c0249d.m1807a();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(m1807a, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + m1807a);
        }
        if (!resolveContentProvider.packageName.equals(c0249d.m1808b())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + m1807a + ", but package was not " + c0249d.m1808b());
        }
        List<byte[]> m1802a = m1802a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
        Collections.sort(m1802a, f1969a);
        List<List<byte[]>> m1801a = m1801a(c0249d, resources);
        while (true) {
            int i2 = i;
            if (i2 < m1801a.size()) {
                ArrayList arrayList = new ArrayList(m1801a.get(i2));
                Collections.sort(arrayList, f1969a);
                if (m1803a(m1802a, arrayList)) {
                    return resolveContentProvider;
                }
                i = i2 + 1;
            } else {
                return null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0126  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static C0251f.b[] m1804a(Context context, C0249d c0249d, String str, CancellationSignal cancellationSignal) {
        Cursor cursor;
        Cursor query;
        ArrayList arrayList;
        int i;
        Uri withAppendedId;
        ArrayList arrayList2 = new ArrayList();
        Uri build = new Uri.Builder().scheme(ContentResolver.SCHEME_CONTENT).authority(str).build();
        Uri build2 = new Uri.Builder().scheme(ContentResolver.SCHEME_CONTENT).authority(str).appendPath(ContentResolver.SCHEME_FILE).build();
        try {
            String[] strArr = {"_id", FontsContract.Columns.FILE_ID, FontsContract.Columns.TTC_INDEX, FontsContract.Columns.VARIATION_SETTINGS, FontsContract.Columns.WEIGHT, FontsContract.Columns.ITALIC, FontsContract.Columns.RESULT_CODE};
            if (Build.VERSION.SDK_INT > 16) {
                query = context.getContentResolver().query(build, strArr, "query = ?", new String[]{c0249d.m1809c()}, null, cancellationSignal);
            } else {
                query = context.getContentResolver().query(build, strArr, "query = ?", new String[]{c0249d.m1809c()}, null);
            }
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        int columnIndex = query.getColumnIndex(FontsContract.Columns.RESULT_CODE);
                        arrayList = new ArrayList();
                        int columnIndex2 = query.getColumnIndex("_id");
                        int columnIndex3 = query.getColumnIndex(FontsContract.Columns.FILE_ID);
                        int columnIndex4 = query.getColumnIndex(FontsContract.Columns.TTC_INDEX);
                        int columnIndex5 = query.getColumnIndex(FontsContract.Columns.WEIGHT);
                        int columnIndex6 = query.getColumnIndex(FontsContract.Columns.ITALIC);
                        while (query.moveToNext()) {
                            if (columnIndex != -1) {
                                i = query.getInt(columnIndex);
                            } else {
                                i = 0;
                            }
                            int i2 = columnIndex4 != -1 ? query.getInt(columnIndex4) : 0;
                            if (columnIndex3 == -1) {
                                withAppendedId = ContentUris.withAppendedId(build, query.getLong(columnIndex2));
                            } else {
                                withAppendedId = ContentUris.withAppendedId(build2, query.getLong(columnIndex3));
                            }
                            arrayList.add(C0251f.b.m1826a(withAppendedId, i2, columnIndex5 != -1 ? query.getInt(columnIndex5) : 400, columnIndex6 != -1 && query.getInt(columnIndex6) == 1, i));
                        }
                        if (query != null) {
                            query.close();
                        }
                        return (C0251f.b[]) arrayList.toArray(new C0251f.b[0]);
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            arrayList = arrayList2;
            if (query != null) {
            }
            return (C0251f.b[]) arrayList.toArray(new C0251f.b[0]);
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    /* renamed from: a */
    private static List<List<byte[]>> m1801a(C0249d c0249d, Resources resources) {
        if (c0249d.m1810d() != null) {
            return c0249d.m1810d();
        }
        return C0258c.m1883a(resources, c0249d.m1811e());
    }

    /* renamed from: a */
    private static boolean m1803a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static List<byte[]> m1802a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }
}
