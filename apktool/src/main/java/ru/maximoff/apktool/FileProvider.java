package ru.maximoff.apktool;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.p008os.ParcelFileDescriptor;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import java.p209io.File;
import java.util.Arrays;

/* loaded from: classes.dex */
public class FileProvider extends ContentProvider {

    /* renamed from: a */
    private static final String[] f14077a = {"_display_name", "_size"};

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i = 0;
        File m16589b = m16589b(uri);
        if (strArr == null) {
            strArr = f14077a;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < strArr.length) {
                String str3 = strArr[i2];
                if ("_display_name".equals(str3)) {
                    strArr3[i3] = "_display_name";
                    i = i3 + 1;
                    objArr[i3] = m16589b.getName();
                } else if ("_size".equals(str3)) {
                    strArr3[i3] = "_size";
                    i = i3 + 1;
                    objArr[i3] = Long.valueOf(m16589b.length());
                } else {
                    i = i3;
                }
                i2++;
            } else {
                String[] strArr4 = (String[]) Arrays.copyOf(strArr3, i3);
                Object[] copyOf = Arrays.copyOf(objArr, i3);
                MatrixCursor matrixCursor = new MatrixCursor(strArr4, 1);
                matrixCursor.addRow(copyOf);
                return matrixCursor;
            }
        }
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        String name = m16589b(uri).getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf == -1 ? "application/octet-stream" : MimeTypeMap.getSingleton().getMimeTypeFromExtension(name.substring(lastIndexOf + 1));
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        m16589b(uri).delete();
        return 0;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        return ParcelFileDescriptor.open(m16589b(uri), m16587a(str));
    }

    /* renamed from: a */
    private static int m16587a(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException(new StringBuffer().append("Invalid mode: ").append(str).toString());
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    /* renamed from: a */
    private static String m16588a(Uri uri) {
        return new String(Base64.decode(uri.getPath().substring(1), 2));
    }

    /* renamed from: b */
    private static File m16589b(Uri uri) {
        return new File(m16588a(uri));
    }
}
