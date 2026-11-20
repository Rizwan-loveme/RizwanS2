package ru.maximoff.apktool.util;

import android.os.AsyncTask;
import java.lang.reflect.Array;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ru.maximoff.apktool.util.p303a.C3061a;

/* compiled from: LCSOptimizer.java */
/* renamed from: ru.maximoff.apktool.util.ag */
/* loaded from: classes.dex */
public class C3075ag {

    /* renamed from: a */
    private final boolean f17617a;

    /* renamed from: b */
    private volatile boolean f17618b = false;

    /* compiled from: LCSOptimizer.java */
    /* renamed from: ru.maximoff.apktool.util.ag$c */
    public interface c {
        /* renamed from: a */
        void mo16577a(List<b> list, int i, int i2, boolean z);
    }

    public C3075ag(boolean z) {
        this.f17617a = z;
    }

    /* renamed from: a */
    public void m18476a(File file, File file2, c cVar) {
        this.f17618b = false;
        new a(this, file, file2, cVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* renamed from: a */
    public void m18475a() {
        this.f17618b = true;
    }

    /* compiled from: LCSOptimizer.java */
    /* renamed from: ru.maximoff.apktool.util.ag$a */
    private class a extends AsyncTask<Void, Void, List<b>> {

        /* renamed from: a */
        private final File f17619a;

        /* renamed from: b */
        private final File f17620b;

        /* renamed from: c */
        private final c f17621c;

        /* renamed from: d */
        private int f17622d;

        /* renamed from: e */
        private int f17623e;

        /* renamed from: f */
        private final C3075ag f17624f;

        @Override // android.os.AsyncTask
        protected List<b> doInBackground(Void[] voidArr) {
            return m18477a(voidArr);
        }

        @Override // android.os.AsyncTask
        protected void onPostExecute(List<b> list) {
            m18478a(list);
        }

        a(C3075ag c3075ag, File file, File file2, c cVar) {
            this.f17624f = c3075ag;
            this.f17619a = file;
            this.f17620b = file2;
            this.f17621c = cVar;
        }

        /* renamed from: a */
        protected List<b> m18477a(Void... voidArr) {
            List<String> m18331h = C3061a.m18331h(this.f17619a);
            List<String> m18331h2 = C3061a.m18331h(this.f17620b);
            this.f17622d = m18331h.size();
            this.f17623e = m18331h2.size();
            return this.f17624f.m18467a(m18331h, m18331h2, 0, this.f17622d, 0, this.f17623e);
        }

        /* renamed from: a */
        protected void m18478a(List<b> list) {
            if (this.f17621c != null) {
                this.f17621c.mo16577a(list, this.f17622d, this.f17623e, this.f17624f.f17618b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public List<b> m18467a(List<String> list, List<String> list2, int i, int i2, int i3, int i4) {
        if (this.f17618b) {
            return Collections.emptyList();
        }
        if (i == i2) {
            ArrayList arrayList = new ArrayList();
            while (i3 < i4) {
                arrayList.add(new b(this, (Integer) null, new Integer(i3 + 1), (String) null, list2.get(i3)));
                i3++;
            }
            return arrayList;
        }
        if (i3 == i4) {
            ArrayList arrayList2 = new ArrayList();
            while (i < i2) {
                arrayList2.add(new b(this, new Integer(i + 1), (Integer) null, list.get(i), (String) null));
                i++;
            }
            return arrayList2;
        }
        if (i2 - i == 1 || i4 - i3 == 1) {
            return m18472b(list, list2, i, i2, i3, i4);
        }
        int i5 = (i + i2) / 2;
        int m18466a = i3 + m18466a(m18471a(list, i, i5, list2, i3, i4), m18474b(list, i5, i2, list2, i3, i4));
        List<b> m18467a = m18467a(list, list2, i, i5, i3, m18466a);
        m18467a.addAll(m18467a(list, list2, i5, i2, m18466a, i4));
        return m18467a;
    }

    /* renamed from: a */
    private int m18466a(int[] iArr, int[] iArr2) {
        if (this.f17618b) {
            return 0;
        }
        int i = Integer.MIN_VALUE;
        int i2 = 0;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (this.f17618b) {
                return 0;
            }
            int i4 = iArr[i3] + iArr2[(iArr2.length - 1) - i3];
            if (i4 > i) {
                i = i4;
                i2 = i3;
            }
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e1, code lost:
    
        if (r9 == 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ef, code lost:
    
        if (r6[r9][r8 - 1] < r6[r9 - 1][r8]) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f1, code lost:
    
        r7.add(new ru.maximoff.apktool.util.C3075ag.b(r10, (java.lang.Integer) null, new java.lang.Integer(r15 + r8), (java.lang.String) null, r12.get((r15 + r8) - 1)));
        r8 = r8 - 1;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<b> m18472b(List<String> list, List<String> list2, int i, int i2, int i3, int i4) {
        if (this.f17618b) {
            return Collections.emptyList();
        }
        int i5 = i2 - i;
        int i6 = i4 - i3;
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, i5 + 1, i6 + 1);
        ArrayList arrayList = new ArrayList();
        for (int i7 = 1; i7 <= i5; i7++) {
            if (this.f17618b) {
                return Collections.emptyList();
            }
            for (int i8 = 1; i8 <= i6; i8++) {
                if (m18469a(list.get((i + i7) - 1), list2.get((i3 + i8) - 1))) {
                    iArr[i7][i8] = iArr[i7 - 1][i8 - 1] + 1;
                } else {
                    iArr[i7][i8] = Math.max(iArr[i7 - 1][i8], iArr[i7][i8 - 1]);
                }
            }
        }
        int i9 = i6;
        int i10 = i5;
        while (true) {
            if (i10 > 0 || i9 > 0) {
                if (this.f17618b) {
                    return Collections.emptyList();
                }
                if (i10 > 0 && i9 > 0 && m18469a(list.get((i + i10) - 1), list2.get((i3 + i9) - 1))) {
                    arrayList.add(new b(this, new Integer(i + i10), new Integer(i3 + i9), list.get((i + i10) - 1), list2.get((i3 + i9) - 1)));
                    i9--;
                    i10--;
                } else {
                    arrayList.add(new b(this, new Integer(i + i10), (Integer) null, list.get((i + i10) - 1), (String) null));
                    i10--;
                }
            } else {
                Collections.reverse(arrayList);
                return arrayList;
            }
        }
    }

    /* renamed from: a */
    private int[] m18471a(List<String> list, int i, int i2, List<String> list2, int i3, int i4) {
        if (this.f17618b) {
            return new int[0];
        }
        int i5 = i4 - i3;
        int[] iArr = new int[i5 + 1];
        int[] iArr2 = new int[i5 + 1];
        while (i < i2) {
            if (this.f17618b) {
                return new int[0];
            }
            String str = list.get(i);
            for (int i6 = 1; i6 <= i5; i6++) {
                if (m18469a(str, list2.get((i3 + i6) - 1))) {
                    iArr2[i6] = iArr[i6 - 1] + 1;
                } else {
                    iArr2[i6] = Math.max(iArr[i6], iArr2[i6 - 1]);
                }
            }
            i++;
            int[] iArr3 = iArr;
            iArr = iArr2;
            iArr2 = iArr3;
        }
        return iArr;
    }

    /* renamed from: b */
    private int[] m18474b(List<String> list, int i, int i2, List<String> list2, int i3, int i4) {
        if (this.f17618b) {
            return new int[0];
        }
        int i5 = i4 - i3;
        int[] iArr = new int[i5 + 1];
        int i6 = i2 - 1;
        int[] iArr2 = new int[i5 + 1];
        while (i6 >= i) {
            if (this.f17618b) {
                return new int[0];
            }
            String str = list.get(i6);
            for (int i7 = 1; i7 <= i5; i7++) {
                if (m18469a(str, list2.get((i3 + i5) - i7))) {
                    iArr2[i7] = iArr[i7 - 1] + 1;
                } else {
                    iArr2[i7] = Math.max(iArr[i7], iArr2[i7 - 1]);
                }
            }
            i6--;
            int[] iArr3 = iArr;
            iArr = iArr2;
            iArr2 = iArr3;
        }
        return iArr;
    }

    /* renamed from: a */
    private boolean m18469a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (this.f17618b || str == null || str2 == null) {
            return false;
        }
        if (!this.f17617a) {
            return str.equals(str2);
        }
        return m18473b(str, str2);
    }

    /* renamed from: b */
    private boolean m18473b(String str, String str2) {
        if (str == str2) {
            return true;
        }
        int length = str.length() - 1;
        int length2 = str2.length() - 1;
        int i = 0;
        while (i <= length && Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        int i2 = 0;
        while (i2 <= length2 && Character.isWhitespace(str2.charAt(i2))) {
            i2++;
        }
        while (length >= i && Character.isWhitespace(str.charAt(length))) {
            length--;
        }
        while (length2 >= i2 && Character.isWhitespace(str2.charAt(length2))) {
            length2--;
        }
        int i3 = length - i;
        if (i3 != length2 - i2) {
            return false;
        }
        for (int i4 = 0; i4 <= i3; i4++) {
            if (str.charAt(i + i4) != str2.charAt(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    /* compiled from: LCSOptimizer.java */
    /* renamed from: ru.maximoff.apktool.util.ag$b */
    public class b {

        /* renamed from: a */
        public final Integer f17625a;

        /* renamed from: b */
        public final Integer f17626b;

        /* renamed from: c */
        public final String f17627c;

        /* renamed from: d */
        public final String f17628d;

        /* renamed from: e */
        private final C3075ag f17629e;

        public b(C3075ag c3075ag, Integer num, Integer num2, String str, String str2) {
            this.f17629e = c3075ag;
            this.f17625a = num;
            this.f17626b = num2;
            this.f17627c = str;
            this.f17628d = str2;
        }
    }
}
