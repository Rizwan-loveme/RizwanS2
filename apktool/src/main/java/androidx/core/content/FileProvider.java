package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.p006pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.p008os.Build;
import android.p008os.Environment;
import android.p008os.ParcelFileDescriptor;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.p209io.File;
import java.p209io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.p291v1.XmlPullParserException;

/* loaded from: classes.dex */
public class FileProvider extends ContentProvider {

    /* renamed from: a */
    private static final String[] f2008a = {"_display_name", "_size"};

    /* renamed from: b */
    private static final File f2009b = new File("/");

    /* renamed from: c */
    private static HashMap<String, InterfaceC0253a> f2010c = new HashMap<>();

    /* renamed from: d */
    private InterfaceC0253a f2011d;

    /* renamed from: androidx.core.content.FileProvider$a */
    interface InterfaceC0253a {
        /* renamed from: a */
        Uri mo1844a(File file);

        /* renamed from: a */
        File mo1845a(Uri uri);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        this.f2011d = m1839a(context, providerInfo.authority.split(";")[0]);
    }

    /* renamed from: a */
    public static Uri m1838a(Context context, String str, File file) {
        return m1839a(context, str).mo1844a(file);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i;
        File mo1845a = this.f2011d.mo1845a(uri);
        String queryParameter = uri.getQueryParameter(ContactsContract.Directory.DISPLAY_NAME);
        if (strArr == null) {
            strArr = f2008a;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i2 = 0;
        int length = strArr.length;
        int i3 = 0;
        while (i3 < length) {
            String str3 = strArr[i3];
            if ("_display_name".equals(str3)) {
                strArr3[i2] = "_display_name";
                int i4 = i2 + 1;
                objArr[i2] = queryParameter == null ? mo1845a.getName() : queryParameter;
                i = i4;
            } else if ("_size".equals(str3)) {
                strArr3[i2] = "_size";
                i = i2 + 1;
                objArr[i2] = Long.valueOf(mo1845a.length());
            } else {
                i = i2;
            }
            i3++;
            i2 = i;
        }
        String[] m1842a = m1842a(strArr3, i2);
        Object[] m1841a = m1841a(objArr, i2);
        MatrixCursor matrixCursor = new MatrixCursor(m1842a, 1);
        matrixCursor.addRow(m1841a);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File mo1845a = this.f2011d.mo1845a(uri);
        int lastIndexOf = mo1845a.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(mo1845a.getName().substring(lastIndexOf + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return this.f2011d.mo1845a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    @SuppressLint({"UnknownNullness"})
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        return ParcelFileDescriptor.open(this.f2011d.mo1845a(uri), m1837a(str));
    }

    /* renamed from: a */
    private static InterfaceC0253a m1839a(Context context, String str) {
        InterfaceC0253a interfaceC0253a;
        synchronized (f2010c) {
            interfaceC0253a = f2010c.get(str);
            if (interfaceC0253a == null) {
                try {
                    try {
                        interfaceC0253a = m1843b(context, str);
                        f2010c.put(str, interfaceC0253a);
                    } catch (IOException e2) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                    }
                } catch (XmlPullParserException e3) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e3);
                }
            }
        }
        return interfaceC0253a;
    }

    /* renamed from: b */
    private static InterfaceC0253a m1843b(Context context, String str) {
        File file;
        C0254b c0254b = new C0254b(str);
        ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(str, 128);
        if (resolveContentProvider == null) {
            throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + str);
        }
        XmlResourceParser loadXmlMetaData = resolveContentProvider.loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (loadXmlMetaData == null) {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        while (true) {
            int next = loadXmlMetaData.next();
            if (next != 1) {
                if (next == 2) {
                    String name = loadXmlMetaData.getName();
                    String attributeValue = loadXmlMetaData.getAttributeValue(null, "name");
                    String attributeValue2 = loadXmlMetaData.getAttributeValue(null, "path");
                    if ("root-path".equals(name)) {
                        file = f2009b;
                    } else if ("files-path".equals(name)) {
                        file = context.getFilesDir();
                    } else if ("cache-path".equals(name)) {
                        file = context.getCacheDir();
                    } else if ("external-path".equals(name)) {
                        file = Environment.getExternalStorageDirectory();
                    } else if ("external-files-path".equals(name)) {
                        File[] m1851a = C0255a.m1851a(context, (String) null);
                        if (m1851a.length > 0) {
                            file = m1851a[0];
                        }
                        file = null;
                    } else if ("external-cache-path".equals(name)) {
                        File[] m1850a = C0255a.m1850a(context);
                        if (m1850a.length > 0) {
                            file = m1850a[0];
                        }
                        file = null;
                    } else {
                        if (Build.VERSION.SDK_INT >= 21 && "external-media-path".equals(name)) {
                            File[] externalMediaDirs = context.getExternalMediaDirs();
                            if (externalMediaDirs.length > 0) {
                                file = externalMediaDirs[0];
                            }
                        }
                        file = null;
                    }
                    if (file != null) {
                        c0254b.m1846a(attributeValue, m1840a(file, attributeValue2));
                    }
                }
            } else {
                return c0254b;
            }
        }
    }

    /* renamed from: androidx.core.content.FileProvider$b */
    static class C0254b implements InterfaceC0253a {

        /* renamed from: a */
        private final String f2012a;

        /* renamed from: b */
        private final HashMap<String, File> f2013b = new HashMap<>();

        C0254b(String str) {
            this.f2012a = str;
        }

        /* renamed from: a */
        void m1846a(String str, File file) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            try {
                this.f2013b.put(str, file.getCanonicalFile());
            } catch (IOException e2) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e2);
            }
        }

        @Override // androidx.core.content.FileProvider.InterfaceC0253a
        /* renamed from: a */
        public Uri mo1844a(File file) {
            String substring;
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.f2013b.entrySet()) {
                    String path = entry2.getValue().getPath();
                    if (!canonicalPath.startsWith(path) || (entry != null && path.length() <= entry.getValue().getPath().length())) {
                        entry2 = entry;
                    }
                    entry = entry2;
                }
                if (entry == null) {
                    throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
                }
                String path2 = entry.getValue().getPath();
                if (path2.endsWith("/")) {
                    substring = canonicalPath.substring(path2.length());
                } else {
                    substring = canonicalPath.substring(path2.length() + 1);
                }
                return new Uri.Builder().scheme(ContentResolver.SCHEME_CONTENT).authority(this.f2012a).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(substring, "/")).build();
            } catch (IOException e2) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        @Override // androidx.core.content.FileProvider.InterfaceC0253a
        /* renamed from: a */
        public File mo1845a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = this.f2013b.get(decode);
            if (file == null) {
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }
            File file2 = new File(file, decode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (!canonicalFile.getPath().startsWith(file.getPath())) {
                    throw new SecurityException("Resolved path jumped beyond configured root");
                }
                return canonicalFile;
            } catch (IOException e2) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
            }
        }
    }

    /* renamed from: a */
    private static int m1837a(String str) {
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
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    /* renamed from: a */
    private static File m1840a(File file, String... strArr) {
        int length = strArr.length;
        int i = 0;
        File file2 = file;
        while (i < length) {
            String str = strArr[i];
            i++;
            file2 = str != null ? new File(file2, str) : file2;
        }
        return file2;
    }

    /* renamed from: a */
    private static String[] m1842a(String[] strArr, int i) {
        String[] strArr2 = new String[i];
        System.arraycopy(strArr, 0, strArr2, 0, i);
        return strArr2;
    }

    /* renamed from: a */
    private static Object[] m1841a(Object[] objArr, int i) {
        Object[] objArr2 = new Object[i];
        System.arraycopy(objArr, 0, objArr2, 0, i);
        return objArr2;
    }
}
