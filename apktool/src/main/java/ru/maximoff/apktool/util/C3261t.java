package ru.maximoff.apktool.util;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.p300e.AsyncTaskC2954y;
import ru.maximoff.apktool.p300e.C2919au;
import ru.maximoff.apktool.util.p306d.C3212b;
import ru.maximoff.apktool.view.CustomListView;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: FilePicker.java */
/* renamed from: ru.maximoff.apktool.util.t */
/* loaded from: classes.dex */
public class C3261t extends CustomListView {

    /* renamed from: a */
    private String f19685a;

    /* renamed from: b */
    private String[] f19686b;

    /* renamed from: c */
    private b f19687c;

    /* renamed from: d */
    private List<String> f19688d;

    /* renamed from: e */
    private Map<String, Integer> f19689e;

    /* renamed from: f */
    private Context f19690f;

    /* renamed from: g */
    private DialogInterfaceC0070b f19691g;

    /* renamed from: h */
    private Runnable f19692h;

    /* renamed from: i */
    private C3066aa f19693i;

    /* renamed from: j */
    private boolean f19694j;

    /* renamed from: k */
    private boolean f19695k;

    /* renamed from: l */
    private boolean f19696l;

    /* renamed from: m */
    private String f19697m;

    /* renamed from: n */
    private String f19698n;

    /* renamed from: o */
    private C3212b f19699o;

    /* renamed from: p */
    private long f19700p;

    public C3261t(Context context) {
        super(context);
        this.f19700p = 0L;
        setDivider((Drawable) null);
        setDividerHeight(0);
        setFastScrollEnabled(C3102bd.f18314av);
        this.f19690f = context;
        this.f19691g = (DialogInterfaceC0070b) null;
        this.f19694j = false;
        this.f19695k = true;
        this.f19696l = false;
        this.f19697m = "%s";
        this.f19698n = "";
        this.f19689e = new HashMap();
        this.f19699o = new C3212b(this.f19690f, "filepicker_", "history");
        this.f19685a = C3102bd.m18910a(this.f19690f, "picker_path", Environment.getExternalStorageDirectory().getAbsolutePath());
        this.f19693i = new C3066aa(this.f19690f);
        this.f19688d = new ArrayList();
        this.f19687c = new b(this, this.f19688d);
        setAdapter((ListAdapter) this.f19687c);
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
    }

    public void setDialog(DialogInterfaceC0070b dialogInterfaceC0070b) {
        this.f19691g = dialogInterfaceC0070b;
    }

    /* renamed from: a */
    public void m19546a(boolean z) {
        this.f19696l = z;
    }

    public void setFilter(String[] strArr) {
        if (strArr == null || strArr.length != 0) {
            this.f19686b = strArr;
        }
    }

    public void setCallback(Runnable runnable) {
        this.f19692h = runnable;
    }

    public void setPath(String str) {
        this.f19685a = str;
    }

    /* renamed from: a */
    public void m19545a(String str) {
        if (str != null) {
            this.f19698n = str;
            this.f19685a = C3102bd.m18910a(this.f19690f, new StringBuffer().append("picker_path").append(str).toString(), this.f19685a);
        }
    }

    public void setTitlePattern(String str) {
        this.f19697m = str;
    }

    /* renamed from: a */
    public void m19543a() {
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (this.f19685a.startsWith(absolutePath)) {
            return;
        }
        this.f19685a = absolutePath;
    }

    /* renamed from: b */
    public void m19547b() {
        this.f19694j = true;
    }

    public String getPath() {
        return this.f19685a;
    }

    /* renamed from: c */
    public String m19548c() {
        return new File(this.f19685a).getName();
    }

    /* renamed from: d */
    public C3212b m19549d() {
        return this.f19699o;
    }

    /* renamed from: e */
    public void m19550e() {
        File file = new File(this.f19685a);
        if (!file.exists() || !file.isDirectory() || !file.canRead()) {
            file = Environment.getExternalStorageDirectory();
        }
        m19544a(file);
    }

    /* renamed from: f */
    public boolean m19551f() {
        if (!this.f19695k) {
            m19544a(new File(this.f19685a).getParentFile());
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f19700p > 2000) {
            C3112bn.m18999a(this.f19690f, R.string.click_once_more2);
            this.f19700p = currentTimeMillis;
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void m19544a(File file) {
        int i;
        setScrollPosition(this.f19685a);
        this.f19685a = file.getAbsolutePath();
        if (file.isFile()) {
            this.f19699o.m19204a(file.getParent());
            if (this.f19696l && !file.getName().toLowerCase().endsWith(".apk")) {
                m19536c(file);
                return;
            }
            C3102bd.m18937b(this.f19690f, new StringBuffer().append("picker_path").append(this.f19698n).toString(), file.getParent());
            this.f19692h.run();
            this.f19691g.cancel();
            return;
        }
        if (this.f19691g != null) {
            this.f19691g.setTitle(String.format(this.f19697m, file.getName()));
        }
        C3102bd.m18937b(this.f19690f, new StringBuffer().append("picker_path").append(this.f19698n).toString(), this.f19685a);
        this.f19687c.m19556a(m19533b(file));
        if (this.f19689e.isEmpty() || !this.f19689e.containsKey(this.f19685a)) {
            i = 0;
        } else {
            i = this.f19689e.get(this.f19685a).intValue();
            if (i >= this.f19687c.getCount()) {
                i = 0;
            }
        }
        setHandleDataChangedListener(new CustomListView.InterfaceC3268a(this, i) { // from class: ru.maximoff.apktool.util.t.1

            /* renamed from: a */
            private final C3261t f19701a;

            /* renamed from: b */
            private final int f19702b;

            {
                this.f19701a = this;
                this.f19702b = i;
            }

            @Override // ru.maximoff.apktool.view.CustomListView.InterfaceC3268a
            /* renamed from: a */
            public void mo16527a() {
                this.f19701a.setHandleDataChangedListener((CustomListView.InterfaceC3268a) null);
                if (Build.VERSION.SDK_INT >= 21) {
                    View childAt = this.f19701a.getChildAt(0);
                    this.f19701a.setSelectionFromTop(this.f19702b, childAt == null ? 0 : childAt.getTop() - this.f19701a.getPaddingTop());
                } else {
                    this.f19701a.setSelection(this.f19702b);
                }
            }
        });
        this.f19687c.notifyDataSetChanged();
    }

    private void setScrollPosition(String str) {
        Iterator<Map.Entry<String, Integer>> it = this.f19689e.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (key.length() > str.length() && key.startsWith(str)) {
                it.remove();
            }
        }
        this.f19689e.put(str, new Integer(getFirstVisiblePosition()));
    }

    /* renamed from: b */
    private List<String> m19533b(File file) {
        String[] m19640b = C3262u.m19640b(this.f19690f);
        ArrayList arrayList = new ArrayList();
        if (m19640b != null) {
            boolean z = true;
            for (String str : m19640b) {
                if (file.getAbsolutePath().equals(str)) {
                    z = false;
                }
            }
            this.f19695k = !z;
            if (z) {
                arrayList.add(0, "..");
            }
        }
        File[] listFiles = file.listFiles(new FileFilter(this) { // from class: ru.maximoff.apktool.util.t.2

            /* renamed from: a */
            private final C3261t f19703a;

            {
                this.f19703a = this;
            }

            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (this.f19703a.f19694j) {
                    return true;
                }
                if (this.f19703a.f19686b != null && file2.isFile()) {
                    String name = file2.getName();
                    for (String str2 : this.f19703a.f19686b) {
                        if (name.toLowerCase().endsWith(new StringBuffer().append(".").append(str2.toLowerCase()).toString())) {
                            return true;
                        }
                    }
                }
                return file2.isDirectory();
            }
        });
        if (listFiles == null || listFiles.length == 0) {
            int i = 0;
            while (true) {
                if (i >= m19640b.length) {
                    break;
                }
                if (!file.getAbsolutePath().equalsIgnoreCase(new StringBuffer().append(m19640b[i]).append(C3249i.f19551k).toString())) {
                    i++;
                } else {
                    listFiles = new File[]{new File(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m19640b[i]).append(C3249i.f19551k).toString()).append("/").toString()).append(this.f19690f.getPackageName()).toString())};
                    break;
                }
            }
        }
        if (listFiles != null) {
            Arrays.sort(listFiles, new C3108bj(this.f19690f, file));
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    arrayList.add(file2.getName());
                }
            }
            for (File file3 : listFiles) {
                if (!file3.isDirectory()) {
                    arrayList.add(file3.getName());
                }
            }
        }
        return arrayList;
    }

    /* compiled from: FilePicker.java */
    /* renamed from: ru.maximoff.apktool.util.t$b */
    private class b extends BaseAdapter {

        /* renamed from: a */
        private List<String> f19709a;

        /* renamed from: b */
        private int f19710b;

        /* renamed from: c */
        private final C3261t f19711c;

        /* renamed from: a */
        static C3261t m19554a(b bVar) {
            return bVar.f19711c;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return m19555a(i);
        }

        public b(C3261t c3261t, List<String> list) {
            this.f19711c = c3261t;
            this.f19709a = (List) null;
            this.f19710b = C3246h.m19470a(this.f19711c.f19690f, C3102bd.f18291a ? R.color.colorFolderLight : R.color.colorFolderDark);
            this.f19709a = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f19709a != null) {
                return this.f19709a.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        /* renamed from: a */
        public String m19555a(int i) {
            return this.f19709a != null ? this.f19709a.get(i) : (String) null;
        }

        /* renamed from: a */
        public void m19556a(List<String> list) {
            this.f19709a.clear();
            this.f19709a.addAll(list);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            d dVar;
            String m18989a;
            if (view == null) {
                view = ((LayoutInflater) this.f19711c.f19690f.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.files_entry, (ViewGroup) null);
                dVar = new d(this.f19711c);
                dVar.f19726b = (ImageView) view.findViewById(R.id.icon);
                dVar.f19727c = (TextView) view.findViewById(R.id.name);
                dVar.f19728d = (TextView) view.findViewById(R.id.details);
                view.setTag(dVar);
            } else {
                dVar = (d) view.getTag();
            }
            dVar.f19725a = i;
            String str = this.f19709a.get(i);
            if (str != null && !C3112bn.m19040o(str)) {
                File file = new File(this.f19711c.f19685a);
                boolean z = i == 0 && !this.f19711c.f19695k;
                File parentFile = z ? file.getParentFile() : new File(this.f19711c.f19685a, str);
                boolean m19674l = C3262u.m19674l(parentFile);
                if (z) {
                    m18989a = parentFile.getAbsolutePath();
                } else {
                    m18989a = C3112bn.m18989a(parentFile.lastModified());
                    if (!parentFile.isDirectory() && !z) {
                        m18989a = new StringBuffer().append(m18989a).append(new StringBuffer().append(", ").append(C3106bh.m18975a(parentFile.length(), C3102bd.f18305am)).toString()).toString();
                    }
                }
                dVar.f19728d.setText(m18989a);
                dVar.f19728d.setTextSize(2, C3102bd.m18927b());
                dVar.f19727c.setText(str);
                dVar.f19727c.setTextSize(2, C3102bd.f18332o);
                dVar.f19726b.setTag(parentFile.getAbsolutePath());
                if ((parentFile.isDirectory() && !m19674l) || z) {
                    dVar.f19726b.setImageBitmap(C3267z.m19713a().m19714a(this.f19711c.f19693i, this.f19710b, R.drawable.ic_folder));
                } else {
                    String lowerCase = str.toLowerCase();
                    int[] m18400a = C3068ac.m18400a(this.f19711c.f19690f, lowerCase);
                    if (m19674l) {
                        dVar.f19726b.setImageBitmap(C3267z.m19713a().m19714a(this.f19711c.f19693i, this.f19710b, R.drawable.ic_folder));
                    } else {
                        dVar.f19726b.setImageBitmap(C3267z.m19713a().m19714a(this.f19711c.f19693i, m18400a[1], m18400a[0]));
                    }
                    if (C3072ad.m18430a(lowerCase) || m18400a[0] == R.drawable.ic_image || m19674l) {
                        C2919au.m17340a(parentFile, new C2919au.a(this, new AsyncTaskC2954y(this.f19711c.f19690f, dVar.f19726b, (InterfaceC2995n) null)) { // from class: ru.maximoff.apktool.util.t.b.1

                            /* renamed from: a */
                            private final b f19712a;

                            /* renamed from: b */
                            private final AsyncTaskC2954y f19713b;

                            {
                                this.f19712a = this;
                                this.f19713b = r2;
                            }

                            @Override // ru.maximoff.apktool.p300e.C2919au.a
                            /* renamed from: a */
                            public AsyncTaskC2954y mo17349a() {
                                return this.f19713b;
                            }
                        });
                    }
                }
                view.setOnClickListener(new View.OnClickListener(this, parentFile) { // from class: ru.maximoff.apktool.util.t.b.2

                    /* renamed from: a */
                    private final b f19714a;

                    /* renamed from: b */
                    private final File f19715b;

                    {
                        this.f19714a = this;
                        this.f19715b = parentFile;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        b.m19554a(this.f19714a).m19544a(this.f19715b);
                    }
                });
                view.setOnLongClickListener(new View.OnLongClickListener(this, parentFile, z) { // from class: ru.maximoff.apktool.util.t.b.3

                    /* renamed from: a */
                    private final b f19716a;

                    /* renamed from: b */
                    private final File f19717b;

                    /* renamed from: c */
                    private final boolean f19718c;

                    {
                        this.f19716a = this;
                        this.f19717b = parentFile;
                        this.f19718c = z;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view2) {
                        if (this.f19717b.isDirectory() && b.m19554a(this.f19716a).f19686b == null && !this.f19718c && !b.m19554a(this.f19716a).f19694j) {
                            b.m19554a(this.f19716a).f19685a = this.f19717b.getAbsolutePath();
                            C3102bd.m18937b(b.m19554a(this.f19716a).f19690f, new StringBuffer().append("picker_path").append(b.m19554a(this.f19716a).f19698n).toString(), this.f19717b.getParent());
                            b.m19554a(this.f19716a).f19692h.run();
                            b.m19554a(this.f19716a).f19691g.cancel();
                            return true;
                        }
                        return true;
                    }
                });
            }
            return view;
        }
    }

    /* compiled from: FilePicker.java */
    /* renamed from: ru.maximoff.apktool.util.t$d */
    private class d {

        /* renamed from: a */
        public int f19725a;

        /* renamed from: b */
        public ImageView f19726b;

        /* renamed from: c */
        public TextView f19727c;

        /* renamed from: d */
        public TextView f19728d;

        /* renamed from: e */
        private final C3261t f19729e;

        public d(C3261t c3261t) {
            this.f19729e = c3261t;
        }
    }

    /* renamed from: c */
    private void m19536c(File file) {
        if (!C3262u.m19654d(file)) {
            return;
        }
        new c(this, this.f19690f).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, file);
    }

    /* compiled from: FilePicker.java */
    /* renamed from: ru.maximoff.apktool.util.t$c */
    private class c extends AsyncTask<File, Void, Boolean> {

        /* renamed from: a */
        private Context f19719a;

        /* renamed from: b */
        private File f19720b;

        /* renamed from: c */
        private DialogInterfaceC0070b f19721c;

        /* renamed from: d */
        private List<String> f19722d = new ArrayList();

        /* renamed from: e */
        private final C3261t f19723e;

        /* renamed from: d */
        static C3261t m19560d(c cVar) {
            return cVar.f19723e;
        }

        @Override // android.os.AsyncTask
        protected Boolean doInBackground(File[] fileArr) {
            return m19561a(fileArr);
        }

        @Override // android.os.AsyncTask
        protected void onPostExecute(Boolean bool) {
            m19562a(bool);
        }

        public c(C3261t c3261t, Context context) {
            this.f19723e = c3261t;
            this.f19719a = context;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            View inflate = LayoutInflater.from(this.f19719a).inflate(R.layout.search_progress, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
            this.f19721c = new DialogInterfaceC0070b.a(this.f19719a).m435b(inflate).m429a(false).m438b();
            this.f19721c.show();
        }

        /* renamed from: a */
        protected Boolean m19561a(File[] fileArr) {
            try {
                this.f19720b = fileArr[0];
                C2604w c2604w = new C2604w(this.f19720b);
                Enumeration<C2602u> m16163b = c2604w.m16163b();
                while (m16163b.hasMoreElements()) {
                    C2602u nextElement = m16163b.nextElement();
                    String name = nextElement.getName();
                    if (!nextElement.isDirectory() && name.toLowerCase().endsWith(".apk") && name.indexOf(47) == -1) {
                        String stringBuffer = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(name).append(" (").toString()).append(C3106bh.m18975a(nextElement.getSize(), C3102bd.f18305am)).toString()).append(")").toString();
                        if (!this.f19722d.contains(stringBuffer)) {
                            this.f19722d.add(stringBuffer);
                        }
                    }
                }
                c2604w.close();
                return new Boolean(true);
            } catch (Error | Exception e2) {
                return new Boolean(false);
            }
        }

        /* renamed from: a */
        protected void m19562a(Boolean bool) {
            if (this.f19721c != null && this.f19721c.isShowing()) {
                try {
                    this.f19721c.cancel();
                } catch (Exception e2) {
                }
            }
            if (bool.booleanValue() && !this.f19722d.isEmpty()) {
                new DialogInterfaceC0070b.a(this.f19719a).m427a(this.f19720b.getName()).m431a((String[]) this.f19722d.toArray(new String[this.f19722d.size()]), new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.util.t.c.1

                    /* renamed from: a */
                    private final c f19724a;

                    {
                        this.f19724a = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        String str = (String) this.f19724a.f19722d.get(i);
                        int lastIndexOf = str.lastIndexOf(40);
                        if (lastIndexOf > 0) {
                            str = str.substring(0, lastIndexOf - 1);
                        }
                        new a(c.m19560d(this.f19724a), this.f19724a.f19719a, this.f19724a.f19720b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, str);
                    }
                }).m420a(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
            } else {
                C3112bn.m18999a(this.f19719a, R.string.not_found);
            }
        }
    }

    /* compiled from: FilePicker.java */
    /* renamed from: ru.maximoff.apktool.util.t$a */
    private class a extends AsyncTask<String, Void, Boolean> {

        /* renamed from: a */
        private Context f19704a;

        /* renamed from: b */
        private File f19705b;

        /* renamed from: c */
        private File f19706c;

        /* renamed from: d */
        private DialogInterfaceC0070b f19707d;

        /* renamed from: e */
        private final C3261t f19708e;

        @Override // android.os.AsyncTask
        protected Boolean doInBackground(String[] strArr) {
            return m19552a(strArr);
        }

        @Override // android.os.AsyncTask
        protected void onPostExecute(Boolean bool) {
            m19553a(bool);
        }

        public a(C3261t c3261t, Context context, File file) {
            this.f19708e = c3261t;
            this.f19704a = context;
            this.f19705b = file;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            View inflate = LayoutInflater.from(this.f19704a).inflate(R.layout.search_progress, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
            this.f19707d = new DialogInterfaceC0070b.a(this.f19704a).m435b(inflate).m429a(false).m438b();
            this.f19707d.show();
        }

        /* renamed from: a */
        protected Boolean m19552a(String[] strArr) {
            try {
                this.f19706c = new File(C3262u.m19564a(), C3112bn.m19033h(strArr[0]));
                C2604w c2604w = new C2604w(this.f19705b);
                C2602u m16162a = c2604w.m16162a(strArr[0]);
                byte[] bArr = new byte[C3249i.m19500a()];
                BufferedInputStream bufferedInputStream = new BufferedInputStream(c2604w.m16160a(m16162a), bArr.length);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.f19706c), bArr.length);
                while (true) {
                    try {
                        int read = bufferedInputStream.read(bArr);
                        if (read != -1) {
                            bufferedOutputStream.write(bArr, 0, read);
                        } else {
                            bufferedInputStream.close();
                            bufferedOutputStream.close();
                            c2604w.close();
                            return new Boolean(true);
                        }
                    } catch (Throwable th) {
                        bufferedInputStream.close();
                        bufferedOutputStream.close();
                        throw th;
                    }
                }
            } catch (Error | Exception e2) {
                return new Boolean(false);
            }
        }

        /* renamed from: a */
        protected void m19553a(Boolean bool) {
            if (this.f19707d != null && this.f19707d.isShowing()) {
                try {
                    this.f19707d.cancel();
                } catch (Exception e2) {
                }
            }
            if (bool.booleanValue()) {
                this.f19708e.f19685a = this.f19706c.getAbsolutePath();
                C3102bd.m18937b(this.f19708e.f19690f, new StringBuffer().append("picker_path").append(this.f19708e.f19698n).toString(), this.f19705b.getParent());
                this.f19708e.f19692h.run();
                this.f19708e.f19691g.cancel();
                return;
            }
            C3112bn.m18999a(this.f19704a, R.string.error);
        }
    }
}
