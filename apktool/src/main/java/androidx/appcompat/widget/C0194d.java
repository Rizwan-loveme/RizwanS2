package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.p006pm.ResolveInfo;
import android.database.DataSetObservable;
import android.media.p007tv.TvContract;
import android.os.AsyncTask;
import android.os.DropBoxManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.math.BigDecimal;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.p291v1.XmlPullParser;
import org.xmlpull.p291v1.XmlPullParserException;
import org.xmlpull.p291v1.XmlSerializer;

/* compiled from: ActivityChooserModel.java */
/* renamed from: androidx.appcompat.widget.d */
/* loaded from: classes.dex */
class C0194d extends DataSetObservable {

    /* renamed from: a */
    static final String f1667a = C0194d.class.getSimpleName();

    /* renamed from: e */
    private static final Object f1668e = new Object();

    /* renamed from: f */
    private static final Map<String, C0194d> f1669f = new HashMap();

    /* renamed from: b */
    final Context f1670b;

    /* renamed from: c */
    final String f1671c;

    /* renamed from: d */
    boolean f1672d;

    /* renamed from: g */
    private final Object f1673g;

    /* renamed from: h */
    private final List<a> f1674h;

    /* renamed from: i */
    private final List<c> f1675i;

    /* renamed from: j */
    private Intent f1676j;

    /* renamed from: k */
    private b f1677k;

    /* renamed from: l */
    private int f1678l;

    /* renamed from: m */
    private boolean f1679m;

    /* renamed from: n */
    private boolean f1680n;

    /* renamed from: o */
    private boolean f1681o;

    /* renamed from: p */
    private d f1682p;

    /* compiled from: ActivityChooserModel.java */
    /* renamed from: androidx.appcompat.widget.d$b */
    public interface b {
        /* renamed from: a */
        void m1520a(Intent intent, List<a> list, List<c> list2);
    }

    /* compiled from: ActivityChooserModel.java */
    /* renamed from: androidx.appcompat.widget.d$d */
    public interface d {
        /* renamed from: a */
        boolean m1521a(C0194d c0194d, Intent intent);
    }

    /* renamed from: a */
    public int m1513a() {
        int size;
        synchronized (this.f1673g) {
            m1507d();
            size = this.f1674h.size();
        }
        return size;
    }

    /* renamed from: a */
    public ResolveInfo m1515a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.f1673g) {
            m1507d();
            resolveInfo = this.f1674h.get(i).f1683a;
        }
        return resolveInfo;
    }

    /* renamed from: a */
    public int m1514a(ResolveInfo resolveInfo) {
        synchronized (this.f1673g) {
            m1507d();
            List<a> list = this.f1674h;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).f1683a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    /* renamed from: b */
    public Intent m1516b(int i) {
        synchronized (this.f1673g) {
            if (this.f1676j == null) {
                return null;
            }
            m1507d();
            a aVar = this.f1674h.get(i);
            ComponentName componentName = new ComponentName(aVar.f1683a.activityInfo.packageName, aVar.f1683a.activityInfo.name);
            Intent intent = new Intent(this.f1676j);
            intent.setComponent(componentName);
            if (this.f1682p != null) {
                if (this.f1682p.m1521a(this, new Intent(intent))) {
                    return null;
                }
            }
            m1505a(new c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    /* renamed from: b */
    public ResolveInfo m1517b() {
        synchronized (this.f1673g) {
            m1507d();
            if (!this.f1674h.isEmpty()) {
                return this.f1674h.get(0).f1683a;
            }
            return null;
        }
    }

    /* renamed from: c */
    public void m1518c(int i) {
        float f2;
        synchronized (this.f1673g) {
            m1507d();
            a aVar = this.f1674h.get(i);
            a aVar2 = this.f1674h.get(0);
            if (aVar2 != null) {
                f2 = (aVar2.f1684b - aVar.f1684b) + 5.0f;
            } else {
                f2 = 1.0f;
            }
            m1505a(new c(new ComponentName(aVar.f1683a.activityInfo.packageName, aVar.f1683a.activityInfo.name), System.currentTimeMillis(), f2));
        }
    }

    /* renamed from: c */
    private void m1506c() {
        if (!this.f1679m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (this.f1680n) {
            this.f1680n = false;
            if (!TextUtils.isEmpty(this.f1671c)) {
                new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.f1675i), this.f1671c);
            }
        }
    }

    /* renamed from: d */
    private void m1507d() {
        boolean m1509f = m1509f() | m1510g();
        m1511h();
        if (m1509f) {
            m1508e();
            notifyChanged();
        }
    }

    /* renamed from: e */
    private boolean m1508e() {
        if (this.f1677k == null || this.f1676j == null || this.f1674h.isEmpty() || this.f1675i.isEmpty()) {
            return false;
        }
        this.f1677k.m1520a(this.f1676j, this.f1674h, Collections.unmodifiableList(this.f1675i));
        return true;
    }

    /* renamed from: f */
    private boolean m1509f() {
        if (!this.f1681o || this.f1676j == null) {
            return false;
        }
        this.f1681o = false;
        this.f1674h.clear();
        List<ResolveInfo> queryIntentActivities = this.f1670b.getPackageManager().queryIntentActivities(this.f1676j, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.f1674h.add(new a(queryIntentActivities.get(i)));
        }
        return true;
    }

    /* renamed from: g */
    private boolean m1510g() {
        if (!this.f1672d || !this.f1680n || TextUtils.isEmpty(this.f1671c)) {
            return false;
        }
        this.f1672d = false;
        this.f1679m = true;
        m1512i();
        return true;
    }

    /* renamed from: a */
    private boolean m1505a(c cVar) {
        boolean add = this.f1675i.add(cVar);
        if (add) {
            this.f1680n = true;
            m1511h();
            m1506c();
            m1508e();
            notifyChanged();
        }
        return add;
    }

    /* renamed from: h */
    private void m1511h() {
        int size = this.f1675i.size() - this.f1678l;
        if (size > 0) {
            this.f1680n = true;
            for (int i = 0; i < size; i++) {
                this.f1675i.remove(0);
            }
        }
    }

    /* compiled from: ActivityChooserModel.java */
    /* renamed from: androidx.appcompat.widget.d$c */
    public static final class c {

        /* renamed from: a */
        public final ComponentName f1685a;

        /* renamed from: b */
        public final long f1686b;

        /* renamed from: c */
        public final float f1687c;

        public c(String str, long j, float f2) {
            this(ComponentName.unflattenFromString(str), j, f2);
        }

        public c(ComponentName componentName, long j, float f2) {
            this.f1685a = componentName;
            this.f1686b = j;
            this.f1687c = f2;
        }

        public int hashCode() {
            return (((((this.f1685a == null ? 0 : this.f1685a.hashCode()) + 31) * 31) + ((int) (this.f1686b ^ (this.f1686b >>> 32)))) * 31) + Float.floatToIntBits(this.f1687c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                c cVar = (c) obj;
                if (this.f1685a == null) {
                    if (cVar.f1685a != null) {
                        return false;
                    }
                } else if (!this.f1685a.equals(cVar.f1685a)) {
                    return false;
                }
                return this.f1686b == cVar.f1686b && Float.floatToIntBits(this.f1687c) == Float.floatToIntBits(cVar.f1687c);
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append("; activity:").append(this.f1685a);
            sb.append("; time:").append(this.f1686b);
            sb.append("; weight:").append(new BigDecimal(this.f1687c));
            sb.append("]");
            return sb.toString();
        }
    }

    /* compiled from: ActivityChooserModel.java */
    /* renamed from: androidx.appcompat.widget.d$a */
    public static final class a implements Comparable<a> {

        /* renamed from: a */
        public final ResolveInfo f1683a;

        /* renamed from: b */
        public float f1684b;

        public a(ResolveInfo resolveInfo) {
            this.f1683a = resolveInfo;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f1684b) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && Float.floatToIntBits(this.f1684b) == Float.floatToIntBits(((a) obj).f1684b);
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return Float.floatToIntBits(aVar.f1684b) - Float.floatToIntBits(this.f1684b);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append("resolveInfo:").append(this.f1683a.toString());
            sb.append("; weight:").append(new BigDecimal(this.f1684b));
            sb.append("]");
            return sb.toString();
        }
    }

    /* renamed from: i */
    private void m1512i() {
        FileInputStream openFileInput;
        try {
            try {
                openFileInput = this.f1670b.openFileInput(this.f1671c);
                try {
                    try {
                        XmlPullParser newPullParser = Xml.newPullParser();
                        newPullParser.setInput(openFileInput, "UTF-8");
                        for (int i = 0; i != 1 && i != 2; i = newPullParser.next()) {
                        }
                        if (!"historical-records".equals(newPullParser.getName())) {
                            throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                        }
                        List<c> list = this.f1675i;
                        list.clear();
                        while (true) {
                            int next = newPullParser.next();
                            if (next == 1) {
                                if (openFileInput != null) {
                                    try {
                                        openFileInput.close();
                                        return;
                                    } catch (IOException e2) {
                                        return;
                                    }
                                }
                                return;
                            }
                            if (next != 3 && next != 4) {
                                if (!"historical-record".equals(newPullParser.getName())) {
                                    throw new XmlPullParserException("Share records file not well-formed.");
                                }
                                list.add(new c(newPullParser.getAttributeValue(null, Context.ACTIVITY_SERVICE), Long.parseLong(newPullParser.getAttributeValue(null, DropBoxManager.EXTRA_TIME)), Float.parseFloat(newPullParser.getAttributeValue(null, TvContract.PreviewPrograms.COLUMN_WEIGHT))));
                            }
                        }
                    } catch (XmlPullParserException e3) {
                        Log.m185e(f1667a, "Error reading historical recrod file: " + this.f1671c, e3);
                        if (openFileInput != null) {
                            try {
                                openFileInput.close();
                            } catch (IOException e4) {
                            }
                        }
                    }
                } catch (IOException e5) {
                    Log.m185e(f1667a, "Error reading historical recrod file: " + this.f1671c, e5);
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e6) {
                        }
                    }
                }
            } catch (FileNotFoundException e7) {
            }
        } catch (Throwable th) {
            if (openFileInput != null) {
                try {
                    openFileInput.close();
                } catch (IOException e8) {
                }
            }
            throw th;
        }
    }

    /* compiled from: ActivityChooserModel.java */
    /* renamed from: androidx.appcompat.widget.d$e */
    private final class e extends AsyncTask<Object, Void, Void> {
        e() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Object... objArr) {
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                FileOutputStream openFileOutput = C0194d.this.f1670b.openFileOutput(str, 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    try {
                        try {
                            newSerializer.setOutput(openFileOutput, null);
                            newSerializer.startDocument("UTF-8", true);
                            newSerializer.startTag(null, "historical-records");
                            int size = list.size();
                            for (int i = 0; i < size; i++) {
                                c cVar = (c) list.remove(0);
                                newSerializer.startTag(null, "historical-record");
                                newSerializer.attribute(null, Context.ACTIVITY_SERVICE, cVar.f1685a.flattenToString());
                                newSerializer.attribute(null, DropBoxManager.EXTRA_TIME, String.valueOf(cVar.f1686b));
                                newSerializer.attribute(null, TvContract.PreviewPrograms.COLUMN_WEIGHT, String.valueOf(cVar.f1687c));
                                newSerializer.endTag(null, "historical-record");
                            }
                            newSerializer.endTag(null, "historical-records");
                            newSerializer.endDocument();
                            C0194d.this.f1672d = true;
                            if (openFileOutput != null) {
                                try {
                                    openFileOutput.close();
                                } catch (IOException e2) {
                                }
                            }
                        } catch (IOException e3) {
                            Log.m185e(C0194d.f1667a, "Error writing historical record file: " + C0194d.this.f1671c, e3);
                            C0194d.this.f1672d = true;
                            if (openFileOutput != null) {
                                try {
                                    openFileOutput.close();
                                } catch (IOException e4) {
                                }
                            }
                        }
                    } catch (IllegalArgumentException e5) {
                        Log.m185e(C0194d.f1667a, "Error writing historical record file: " + C0194d.this.f1671c, e5);
                        C0194d.this.f1672d = true;
                        if (openFileOutput != null) {
                            try {
                                openFileOutput.close();
                            } catch (IOException e6) {
                            }
                        }
                    } catch (IllegalStateException e7) {
                        Log.m185e(C0194d.f1667a, "Error writing historical record file: " + C0194d.this.f1671c, e7);
                        C0194d.this.f1672d = true;
                        if (openFileOutput != null) {
                            try {
                                openFileOutput.close();
                            } catch (IOException e8) {
                            }
                        }
                    }
                } catch (Throwable th) {
                    C0194d.this.f1672d = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e9) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e10) {
                Log.m185e(C0194d.f1667a, "Error writing historical record file: " + str, e10);
            }
            return null;
        }
    }
}
