package ru.maximoff.apktool.fragment.p301a;

import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.p008os.AsyncTask;
import android.p008os.Build;
import android.p008os.Bundle;
import android.p008os.Handler;
import android.p008os.Looper;
import android.p008os.Message;
import android.security.keystore.KeyProperties;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.p159h.p160a.p162b.AbstractRunnableC1391m;
import com.p159h.p160a.p162b.C1386h;
import com.srizwan.apktool.R;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.p180a.C1537e;
import jadx.p180a.C1538f;
import jadx.p180a.C1539g;
import java.p209io.BufferedInputStream;
import java.p209io.BufferedOutputStream;
import java.p209io.BufferedReader;
import java.p209io.File;
import java.p209io.FileFilter;
import java.p209io.FileInputStream;
import java.p209io.FileOutputStream;
import java.p209io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.p217b.p218a.p219a.C1887e;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.fragment.C2981b;
import ru.maximoff.apktool.p296a.C2884d;
import ru.maximoff.apktool.p296a.C2887g;
import ru.maximoff.apktool.p296a.C2892l;
import ru.maximoff.apktool.service.C3055a;
import ru.maximoff.apktool.util.C3084ap;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3107bi;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p303a.C3061a;
import ru.maximoff.apktool.util.p306d.C3215e;
import ru.maximoff.apktool.view.C3307i;
import ru.maximoff.apktool.view.CustomListView;
import ru.maximoff.apktool.view.Editor;

/* compiled from: EditorPagerItem.java */
/* renamed from: ru.maximoff.apktool.fragment.a.c */
/* loaded from: classes.dex */
public class RunnableC2979c implements Runnable, Editor.InterfaceC3272a {

    /* renamed from: w */
    private static final C2884d f16193w = new C2884d();

    /* renamed from: a */
    private Uri f16194a;

    /* renamed from: b */
    private String f16195b;

    /* renamed from: c */
    private ContentResolver f16196c;

    /* renamed from: d */
    private Editor f16197d;

    /* renamed from: f */
    private AbstractRunnableC1391m f16199f;

    /* renamed from: g */
    private boolean f16200g;

    /* renamed from: i */
    private boolean f16202i;

    /* renamed from: j */
    private boolean f16203j;

    /* renamed from: m */
    private boolean f16206m;

    /* renamed from: n */
    private int f16207n;

    /* renamed from: q */
    private Editor.InterfaceC3272a f16210q;

    /* renamed from: r */
    private Context f16211r;

    /* renamed from: h */
    private boolean f16201h = false;

    /* renamed from: l */
    private boolean f16205l = false;

    /* renamed from: o */
    private int f16208o = 0;

    /* renamed from: p */
    private int f16209p = 0;

    /* renamed from: t */
    private C1537e f16213t = (C1537e) null;

    /* renamed from: u */
    private long f16214u = 0;

    /* renamed from: v */
    private Runnable f16215v = new Runnable(this) { // from class: ru.maximoff.apktool.fragment.a.c.4

        /* renamed from: a */
        private final RunnableC2979c f16236a;

        {
            this.f16236a = this;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C3102bd.f18274J != 0 && System.currentTimeMillis() - this.f16236a.f16214u >= C3102bd.f18274J * 1000 && this.f16236a.m17796l()) {
                this.f16236a.m17808x();
            }
        }
    };

    /* renamed from: k */
    private boolean f16204k = false;

    /* renamed from: s */
    private String f16212s = "UTF-8";

    /* renamed from: e */
    private C1386h f16198e = new C1386h();

    public RunnableC2979c(ContentResolver contentResolver, Uri uri, Context context, boolean z, boolean z2, int i, Editor.InterfaceC3272a interfaceC3272a) {
        this.f16202i = false;
        this.f16206m = false;
        this.f16207n = 0;
        this.f16196c = contentResolver;
        this.f16194a = uri;
        this.f16203j = z;
        this.f16202i = z2;
        this.f16211r = context;
        this.f16207n = i;
        String m17753c = m17753c(this.f16194a);
        if (C3102bd.f18287W) {
            this.f16206m = true;
            this.f16199f = C2887g.m16901a();
        } else {
            this.f16199f = C2887g.m16903a(m17753c, m17748b(this.f16194a));
            this.f16206m = false;
        }
        this.f16200g = m17753c != null && m17753c.toLowerCase().endsWith(".smali");
        m17772a(context, interfaceC3272a);
        new Thread(this).start();
    }

    /* renamed from: a */
    public void m17773a() {
        this.f16214u = System.currentTimeMillis();
    }

    /* renamed from: b */
    public void m17782b() {
        String m17753c = m17753c(this.f16194a);
        if (C3102bd.f18287W) {
            this.f16206m = true;
            this.f16199f = C2887g.m16901a();
        } else {
            this.f16199f = C2887g.m16903a(m17753c, m17748b(this.f16194a));
            this.f16206m = false;
        }
        this.f16200g = m17753c != null && m17753c.toLowerCase().endsWith(".smali");
        this.f16197d.setLexTask(this.f16199f);
    }

    /* renamed from: c */
    public void m17786c() {
        int m16900a = C2887g.m16900a(this.f16199f);
        int[] iArr = {m16900a};
        new DialogInterfaceC0070b.a(this.f16211r).m418a(R.string.syntax).m419a(R.array.syntax_values, m16900a, new DialogInterface.OnClickListener(this, iArr) { // from class: ru.maximoff.apktool.fragment.a.c.1

            /* renamed from: a */
            private final RunnableC2979c f16216a;

            /* renamed from: b */
            private final int[] f16217b;

            {
                this.f16216a = this;
                this.f16217b = iArr;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                this.f16217b[0] = i;
            }
        }).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this, iArr) { // from class: ru.maximoff.apktool.fragment.a.c.2

            /* renamed from: a */
            private final RunnableC2979c f16233a;

            /* renamed from: b */
            private final int[] f16234b;

            {
                this.f16233a = this;
                this.f16234b = iArr;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                this.f16233a.m17774a(this.f16234b[0]);
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
    }

    /* renamed from: a */
    public void m17774a(int i) {
        boolean z = false;
        String m17753c = m17753c(this.f16194a);
        this.f16199f = C2887g.m16902a(i, m17748b(this.f16194a));
        this.f16207n = this.f16197d.getCaretPosition();
        this.f16206m = i == 0;
        if (m17753c != null && m17753c.toLowerCase().endsWith(".smali")) {
            z = true;
        }
        this.f16200g = z;
        this.f16197d.setLexTask(this.f16199f);
        this.f16197d.setDocumentProvider(this.f16198e);
        this.f16197d.setEditable(this.f16203j);
        this.f16197d.m10874a(true);
        this.f16197d.m10901h(this.f16207n);
        this.f16197d.postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.fragment.a.c.3

            /* renamed from: a */
            private final RunnableC2979c f16235a;

            {
                this.f16235a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f16235a.f16197d.m19756h(false);
            }
        }, 10L);
    }

    /* renamed from: d */
    public boolean m17788d() {
        File m17758d = m17758d(this.f16194a);
        if (m17758d == null) {
            return true;
        }
        return m17758d.exists();
    }

    @Override // ru.maximoff.apktool.view.Editor.InterfaceC3272a
    /* renamed from: aw */
    public void mo17649aw() {
        this.f16210q.mo17649aw();
        if (!m17796l() || C3102bd.f18274J <= 0) {
            return;
        }
        this.f16214u = System.currentTimeMillis();
        this.f16197d.postDelayed(this.f16215v, C3102bd.f18274J * 1000);
    }

    /* renamed from: b */
    private C3055a m17748b(Uri uri) {
        if (!uri.getScheme().equals(ContentResolver.SCHEME_FILE)) {
            return (C3055a) null;
        }
        File file = new File(uri.getPath());
        C3055a m18213a = C3102bd.f18338u.m18213a(file);
        if (m18213a == null && uri.getPath().endsWith(".xml")) {
            return new C3055a(file);
        }
        return m18213a;
    }

    /* renamed from: c */
    private String m17753c(Uri uri) {
        return C3262u.m19565a(this.f16211r, uri);
    }

    /* renamed from: a */
    public void m17776a(MenuItem menuItem) {
        new a(this, this.f16211r).execute(new Void[0]);
    }

    /* renamed from: a */
    public void m17779a(List<C3084ap> list) {
        if (list == null || list.isEmpty()) {
            C3112bn.m18999a(this.f16211r, R.string.not_found);
            return;
        }
        Collections.sort(list, new Comparator<C3084ap>(this) { // from class: ru.maximoff.apktool.fragment.a.c.5

            /* renamed from: a */
            private final RunnableC2979c f16237a;

            {
                this.f16237a = this;
            }

            @Override // java.util.Comparator
            public int compare(C3084ap c3084ap, C3084ap c3084ap2) {
                return m17811a(c3084ap, c3084ap2);
            }

            /* renamed from: a */
            public int m17811a(C3084ap c3084ap, C3084ap c3084ap2) {
                return c3084ap.m18657c() - c3084ap2.m18657c();
            }
        });
        View inflate = LayoutInflater.from(this.f16211r).inflate(R.layout.smali_help, (ViewGroup) null);
        C3307i c3307i = new C3307i(this.f16211r, this.f16197d, list);
        c3307i.m19926b(this.f16197d.getLineNumber() + 1);
        CustomListView customListView = (CustomListView) inflate.findViewById(R.id.smalihelpListView1);
        customListView.setDivider((Drawable) null);
        customListView.setDividerHeight(0);
        customListView.setFastScrollEnabled(C3102bd.f18314av);
        customListView.setAdapter((ListAdapter) c3307i);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.clearText1);
        EditText editText = (EditText) inflate.findViewById(R.id.smalihelpEditText1);
        if (C3102bd.f18291a) {
            imageView.setImageResource(R.drawable.ic_close);
        } else {
            imageView.setImageResource(R.drawable.ic_close_dark);
        }
        imageView.setOnClickListener(new View.OnClickListener(this, editText) { // from class: ru.maximoff.apktool.fragment.a.c.6

            /* renamed from: a */
            private final RunnableC2979c f16238a;

            /* renamed from: b */
            private final EditText f16239b;

            {
                this.f16238a = this;
                this.f16239b = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f16239b.requestFocus();
                this.f16239b.setText("");
            }
        });
        if (editText.getText().length() == 0) {
            imageView.setVisibility(8);
        }
        editText.addTextChangedListener(new TextWatcher(this, imageView, c3307i) { // from class: ru.maximoff.apktool.fragment.a.c.7

            /* renamed from: a */
            private final RunnableC2979c f16240a;

            /* renamed from: b */
            private final ImageView f16241b;

            /* renamed from: c */
            private final C3307i f16242c;

            {
                this.f16240a = this;
                this.f16241b = imageView;
                this.f16242c = c3307i;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0) {
                    this.f16241b.setVisibility(8);
                } else {
                    this.f16241b.setVisibility(0);
                }
                this.f16242c.m19923a(editable.toString());
            }
        });
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f16211r).m418a(R.string.list_methods).m435b(inflate).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m440c(R.string.list_strings, (DialogInterface.OnClickListener) null).m438b();
        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, m438b, c3307i, editText, customListView) { // from class: ru.maximoff.apktool.fragment.a.c.8

            /* renamed from: a */
            private final RunnableC2979c f16243a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f16244b;

            /* renamed from: c */
            private final C3307i f16245c;

            /* renamed from: d */
            private final EditText f16246d;

            /* renamed from: e */
            private final CustomListView f16247e;

            {
                this.f16243a = this;
                this.f16244b = m438b;
                this.f16245c = c3307i;
                this.f16246d = editText;
                this.f16247e = customListView;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                Button m414a = this.f16244b.m414a(-3);
                m414a.setOnClickListener(new View.OnClickListener(this, this.f16245c, m414a, this.f16246d, this.f16247e) { // from class: ru.maximoff.apktool.fragment.a.c.8.1

                    /* renamed from: a */
                    private final AnonymousClass8 f16248a;

                    /* renamed from: b */
                    private final C3307i f16249b;

                    /* renamed from: c */
                    private final Button f16250c;

                    /* renamed from: d */
                    private final EditText f16251d;

                    /* renamed from: e */
                    private final CustomListView f16252e;

                    {
                        this.f16248a = this;
                        this.f16249b = r2;
                        this.f16250c = m414a;
                        this.f16251d = r4;
                        this.f16252e = r5;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (this.f16249b.m19924a()) {
                            this.f16250c.setText(R.string.list_methods);
                        } else {
                            this.f16250c.setText(R.string.list_strings);
                        }
                        if (this.f16251d.getText().length() > 0) {
                            this.f16249b.m19923a(this.f16251d.getText().toString());
                        }
                        int m19925b = this.f16249b.m19925b();
                        if (m19925b >= 0) {
                            this.f16252e.setHandleDataChangedListener(new CustomListView.InterfaceC3268a(this, this.f16252e, m19925b) { // from class: ru.maximoff.apktool.fragment.a.c.8.1.1

                                /* renamed from: a */
                                private final AnonymousClass1 f16253a;

                                /* renamed from: b */
                                private final CustomListView f16254b;

                                /* renamed from: c */
                                private final int f16255c;

                                {
                                    this.f16253a = this;
                                    this.f16254b = r2;
                                    this.f16255c = m19925b;
                                }

                                @Override // ru.maximoff.apktool.view.CustomListView.InterfaceC3268a
                                /* renamed from: a */
                                public void mo16527a() {
                                    this.f16254b.setHandleDataChangedListener((CustomListView.InterfaceC3268a) null);
                                    if (Build.VERSION.SDK_INT >= 21) {
                                        View childAt = this.f16254b.getChildAt(0);
                                        this.f16254b.setSelectionFromTop(this.f16255c, childAt == null ? 0 : childAt.getTop() - this.f16254b.getPaddingTop());
                                    } else {
                                        this.f16254b.setSelection(this.f16255c);
                                    }
                                }
                            });
                            this.f16249b.notifyDataSetChanged();
                        }
                    }
                });
                int m19925b = this.f16245c.m19925b();
                if (m19925b >= 0) {
                    this.f16247e.setHandleDataChangedListener(new CustomListView.InterfaceC3268a(this, this.f16247e, m19925b) { // from class: ru.maximoff.apktool.fragment.a.c.8.2

                        /* renamed from: a */
                        private final AnonymousClass8 f16256a;

                        /* renamed from: b */
                        private final CustomListView f16257b;

                        /* renamed from: c */
                        private final int f16258c;

                        {
                            this.f16256a = this;
                            this.f16257b = r2;
                            this.f16258c = m19925b;
                        }

                        @Override // ru.maximoff.apktool.view.CustomListView.InterfaceC3268a
                        /* renamed from: a */
                        public void mo16527a() {
                            this.f16257b.setHandleDataChangedListener((CustomListView.InterfaceC3268a) null);
                            if (Build.VERSION.SDK_INT >= 21) {
                                View childAt = this.f16257b.getChildAt(0);
                                this.f16257b.setSelectionFromTop(this.f16258c, childAt == null ? 0 : childAt.getTop() - this.f16257b.getPaddingTop());
                            } else {
                                this.f16257b.setSelection(this.f16258c);
                            }
                        }
                    });
                    this.f16245c.notifyDataSetChanged();
                }
            }
        });
        m438b.show();
        c3307i.m19922a(m438b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public List<C3084ap> m17771z() {
        ArrayList arrayList = new ArrayList();
        String[] split = this.f16197d.getText().toString().split("\\r?\\n");
        Pattern compile = Pattern.compile("^\\.class.+?([^\\s#]+);.*$");
        Pattern compile2 = Pattern.compile("^\\.super.+?([^\\s#]+);.*$");
        Pattern compile3 = Pattern.compile("^\\.implements.+?([^\\s#]+);.*$");
        Pattern compile4 = Pattern.compile("^\\.method.+?([^\\s]+)\\(([^\\s#]+).*$");
        Pattern compile5 = Pattern.compile("^\\.field.+?([^\\s]+)\\:([^#]+).*$");
        Pattern compile6 = Pattern.compile("^\\s+?const-string(?:\\/jumbo)? [pv]{1}\\d+, \"(.+?)\".*$");
        ArrayList arrayList2 = new ArrayList();
        String str = (String) null;
        String str2 = (String) null;
        String str3 = (String) null;
        for (int i = 0; i < split.length; i++) {
            if (str3 == null) {
                Matcher matcher = compile.matcher(split[i]);
                if (matcher.find()) {
                    str2 = matcher.group(0);
                    arrayList.add(new C3084ap(0, i + 1, new StringBuffer().append(matcher.group(1)).append(";").toString(), (String) null, (String) null, str, arrayList2, str2));
                    str3 = new StringBuffer().append(matcher.group(1)).append(";->").toString();
                }
            }
            if (str == null) {
                Matcher matcher2 = compile2.matcher(split[i]);
                if (matcher2.find()) {
                    str = new StringBuffer().append(matcher2.group(1)).append(";->").toString();
                    arrayList2.addAll(m17754c(matcher2.group(1).substring(1)));
                }
            }
            Matcher matcher3 = compile3.matcher(split[i]);
            if (matcher3.find()) {
                arrayList2.add(new StringBuffer().append(matcher3.group(1)).append(";->").toString());
            } else {
                Matcher matcher4 = compile4.matcher(split[i]);
                if (matcher4.find()) {
                    arrayList.add(new C3084ap(2, i + 1, matcher4.group(1), new StringBuffer().append("(").append(matcher4.group(2)).toString(), str3, str, arrayList2, str2));
                } else {
                    Matcher matcher5 = compile5.matcher(split[i]);
                    if (matcher5.find()) {
                        arrayList.add(new C3084ap(1, i + 1, matcher5.group(1), matcher5.group(2), str3, str, arrayList2, str2));
                    } else {
                        Matcher matcher6 = compile6.matcher(split[i]);
                        if (matcher6.find()) {
                            arrayList.add(new C3084ap(3, i + 1, new StringBuffer().append(new StringBuffer().append("\"").append(matcher6.group(1)).toString()).append("\"").toString(), (String) null, matcher6.group(0).trim(), str, arrayList2, str2));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0065 A[Catch: Exception -> 0x00bb, TRY_LEAVE, TryCatch #16 {Exception -> 0x00bb, blocks: (B:53:0x0060, B:49:0x0065), top: B:52:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<String> m17754c(String str) {
        File file;
        Throwable th;
        BufferedReader bufferedReader;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        BufferedReader bufferedReader2;
        int i = 0;
        ArrayList arrayList = new ArrayList();
        MainActivity m16615o = MainActivity.m16615o();
        if (m16615o == null) {
            return arrayList;
        }
        C2981b m16616A = m16615o.m16616A();
        String m16618C = m16615o.m16618C();
        if (m16616A == null || m16618C == null) {
            return arrayList;
        }
        File[] listFiles = new File(m16618C).listFiles(new FileFilter(this) { // from class: ru.maximoff.apktool.fragment.a.c.9

            /* renamed from: a */
            private final RunnableC2979c f16259a;

            {
                this.f16259a = this;
            }

            @Override // java.p209io.FileFilter
            public boolean accept(File file2) {
                return file2.isDirectory() && file2.getName().startsWith("smali");
            }
        });
        if (listFiles == null || listFiles.length == 0) {
            return arrayList;
        }
        File file2 = (File) null;
        int i2 = 0;
        while (true) {
            if (i2 < listFiles.length) {
                file = C3215e.m19251a(listFiles[i2], str, str);
                if (file != null && file.isFile()) {
                    break;
                }
                i2++;
            } else {
                file = file2;
                break;
            }
        }
        if (file != null) {
            Pattern compile = Pattern.compile("^\\.implements.+?([^\\s#]+);.*$");
            FileInputStream fileInputStream3 = (FileInputStream) null;
            BufferedReader bufferedReader3 = (BufferedReader) null;
            try {
                try {
                    try {
                        fileInputStream2 = new FileInputStream(file);
                        try {
                            try {
                                try {
                                    try {
                                        try {
                                            bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream2, "UTF-8"));
                                            while (true) {
                                                try {
                                                    try {
                                                        String readLine = bufferedReader2.readLine();
                                                        if (readLine == null) {
                                                            break;
                                                        }
                                                        try {
                                                            Matcher matcher = compile.matcher(readLine);
                                                            try {
                                                                if (matcher.find()) {
                                                                    try {
                                                                        try {
                                                                            try {
                                                                                try {
                                                                                    try {
                                                                                        try {
                                                                                            try {
                                                                                                arrayList.add(new StringBuffer().append(matcher.group(1)).append(";->").toString());
                                                                                            } catch (Exception e2) {
                                                                                                bufferedReader3 = bufferedReader2;
                                                                                                bufferedReader2 = bufferedReader3;
                                                                                                if (fileInputStream2 != null) {
                                                                                                }
                                                                                                if (bufferedReader2 != null) {
                                                                                                }
                                                                                                return arrayList;
                                                                                            }
                                                                                        } catch (Exception e3) {
                                                                                            bufferedReader3 = bufferedReader2;
                                                                                        }
                                                                                    } catch (Exception e4) {
                                                                                        bufferedReader3 = bufferedReader2;
                                                                                    }
                                                                                } catch (Exception e5) {
                                                                                    bufferedReader3 = bufferedReader2;
                                                                                }
                                                                            } catch (Exception e6) {
                                                                                bufferedReader3 = bufferedReader2;
                                                                            }
                                                                        } catch (Exception e7) {
                                                                            bufferedReader3 = bufferedReader2;
                                                                        }
                                                                    } catch (Exception e8) {
                                                                        bufferedReader3 = bufferedReader2;
                                                                    }
                                                                } else if (i >= 10) {
                                                                    break;
                                                                }
                                                                i++;
                                                            } catch (Exception e9) {
                                                                bufferedReader3 = bufferedReader2;
                                                            }
                                                        } catch (Exception e10) {
                                                            bufferedReader3 = bufferedReader2;
                                                        }
                                                    } catch (Exception e11) {
                                                        bufferedReader3 = bufferedReader2;
                                                    }
                                                } catch (Error e12) {
                                                    bufferedReader3 = bufferedReader2;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    bufferedReader = bufferedReader2;
                                                    fileInputStream = fileInputStream2;
                                                    if (fileInputStream != null) {
                                                        try {
                                                            fileInputStream.close();
                                                        } catch (Exception e13) {
                                                            throw th;
                                                        }
                                                    }
                                                    if (bufferedReader == null) {
                                                        throw th;
                                                    }
                                                    bufferedReader.close();
                                                    throw th;
                                                }
                                            }
                                        } catch (Exception e14) {
                                        }
                                    } catch (Exception e15) {
                                    }
                                } catch (Exception e16) {
                                }
                            } catch (Exception e17) {
                            }
                        } catch (Error e18) {
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = bufferedReader3;
                            fileInputStream = fileInputStream2;
                        }
                    } catch (Exception e19) {
                        fileInputStream2 = fileInputStream3;
                    }
                } catch (Exception e20) {
                    fileInputStream2 = fileInputStream3;
                }
            } catch (Error e21) {
                fileInputStream2 = fileInputStream3;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = bufferedReader3;
                fileInputStream = fileInputStream3;
            }
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception e22) {
                }
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public List<C3084ap> m17741A() {
        String abstractC1596a;
        String abstractC1596a2;
        String abstractC1596a3;
        ArrayList arrayList = new ArrayList();
        if (this.f16213t == null) {
            return arrayList;
        }
        for (C1538f c1538f : this.f16213t.m11808e()) {
            AbstractC1596a m11810a = c1538f.m11810a();
            if (m11810a.mo12278d()) {
                abstractC1596a3 = m11810a.mo12277c().m12322a();
            } else {
                abstractC1596a3 = m11810a.toString();
            }
            C3084ap c3084ap = new C3084ap(1, c1538f.m11811b(), c1538f.mo11806c(), abstractC1596a3, (String) null, (String) null, (List) null, (String) null);
            c3084ap.m18654a(true);
            arrayList.add(c3084ap);
        }
        for (C1539g c1539g : this.f16213t.m11809f()) {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= c1539g.m11812a().size()) {
                    break;
                }
                if (i2 > 0) {
                    sb.append(", ");
                }
                AbstractC1596a abstractC1596a4 = c1539g.m11812a().get(i2);
                if (abstractC1596a4.mo12278d()) {
                    abstractC1596a2 = abstractC1596a4.mo12277c().m12322a();
                } else {
                    abstractC1596a2 = abstractC1596a4.toString();
                }
                sb.append(abstractC1596a2);
                i = i2 + 1;
            }
            AbstractC1596a m11813b = c1539g.m11813b();
            if (m11813b.mo12278d()) {
                abstractC1596a = m11813b.mo12277c().m12322a();
            } else {
                abstractC1596a = m11813b.toString();
            }
            sb.append(")").append(abstractC1596a);
            C3084ap c3084ap2 = new C3084ap(2, c1539g.m11814d(), c1539g.mo11806c(), sb.toString(), (String) null, (String) null, (List) null, (String) null);
            c3084ap2.m18654a(true);
            arrayList.add(c3084ap2);
        }
        return arrayList;
    }

    /* renamed from: b */
    public void m17783b(MenuItem menuItem) {
        if (!this.f16200g) {
            menuItem.setVisible(false);
            return;
        }
        if (m17791g()) {
            menuItem.setTitle(R.string.translate_java);
            this.f16197d.setLexTask(this.f16199f);
            this.f16197d.setDocumentProvider(this.f16198e);
            this.f16197d.setEditable(this.f16203j);
            this.f16197d.m10874a(true);
            this.f16197d.m10901h(this.f16207n);
            this.f16197d.m10868a(0);
            this.f16201h = false;
        } else {
            try {
                menuItem.setTitle(R.string.return_smali);
                this.f16207n = this.f16197d.getCaretPosition();
                m17755c(menuItem);
            } catch (Error | Exception e2) {
                this.f16197d.m10868a(0);
                this.f16207n = 0;
                StringBuilder sb = new StringBuilder(e2.getMessage());
                StackTraceElement[] stackTrace = e2.getStackTrace();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb.append('\n');
                    sb.append(stackTraceElement);
                }
                new DialogInterfaceC0070b.a(this.f16197d.getContext()).m418a(R.string.error).m436b(sb).m441c();
            }
        }
        this.f16197d.postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.fragment.a.c.10

            /* renamed from: a */
            private final RunnableC2979c f16218a;

            {
                this.f16218a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f16218a.f16197d.m19756h(false);
            }
        }, 10L);
    }

    /* renamed from: e */
    public boolean m17789e() {
        return this.f16200g;
    }

    /* renamed from: f */
    public boolean m17790f() {
        return this.f16199f instanceof C2892l;
    }

    /* renamed from: g */
    public boolean m17791g() {
        return this.f16201h || m17792h();
    }

    /* renamed from: h */
    public boolean m17792h() {
        return this.f16202i;
    }

    /* renamed from: i */
    public Uri m17793i() {
        return this.f16194a;
    }

    /* renamed from: j */
    public String m17794j() {
        return this.f16212s;
    }

    /* renamed from: a */
    public void m17778a(String str) {
        this.f16212s = str;
        this.f16197d.setCharset(str);
    }

    /* renamed from: c */
    private void m17755c(MenuItem menuItem) {
        View inflate = LayoutInflater.from(this.f16211r).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f16211r).m435b(inflate).m429a(false).m438b();
        m438b.show();
        new Thread(new Runnable(this, new AnonymousClass11(this, Looper.getMainLooper(), m438b, menuItem)) { // from class: ru.maximoff.apktool.fragment.a.c.12

            /* renamed from: a */
            private final RunnableC2979c f16223a;

            /* renamed from: b */
            private final Handler f16224b;

            {
                this.f16223a = this;
                this.f16224b = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String stringBuffer;
                try {
                    C2892l c2892l = (C2892l) this.f16223a.f16199f;
                    this.f16223a.f16213t = C3107bi.m18978a(this.f16223a.f16211r, c2892l.m16928j(), this.f16223a.m17758d(this.f16223a.f16194a), c2892l.m16929k());
                    stringBuffer = this.f16223a.f16213t.m11804a();
                } catch (Error e2) {
                    this.f16223a.f16213t = (C1537e) null;
                    stringBuffer = new StringBuffer().append("// Error: ").append(e2.toString().replaceAll("\n", "\n//")).toString();
                } catch (Exception e3) {
                    this.f16223a.f16213t = (C1537e) null;
                    stringBuffer = new StringBuffer().append("// Translate to java failed: ").append(e3.toString().replaceAll("\n", "\n//")).toString();
                }
                Bundle bundle = new Bundle();
                bundle.putString("javaCode", stringBuffer);
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.setData(bundle);
                this.f16224b.sendMessage(obtain);
            }
        }).start();
    }

    /* compiled from: EditorPagerItem.java */
    /* renamed from: ru.maximoff.apktool.fragment.a.c$11, reason: invalid class name */
    class AnonymousClass11 extends Handler {

        /* renamed from: a */
        private final RunnableC2979c f16219a;

        /* renamed from: b */
        private final DialogInterfaceC0070b f16220b;

        /* renamed from: c */
        private final MenuItem f16221c;

        AnonymousClass11(RunnableC2979c runnableC2979c, Looper looper, DialogInterfaceC0070b dialogInterfaceC0070b, MenuItem menuItem) {
            super(looper);
            this.f16219a = runnableC2979c;
            this.f16220b = dialogInterfaceC0070b;
            this.f16221c = menuItem;
        }

        /* renamed from: a */
        static RunnableC2979c m17809a(AnonymousClass11 anonymousClass11) {
            return anonymousClass11.f16219a;
        }

        @Override // android.p008os.Handler
        public void handleMessage(Message message) {
            this.f16220b.cancel();
            if (message.what == 1) {
                String string = message.getData().getString("javaCode");
                if (string != null) {
                    C1386h c1386h = new C1386h();
                    c1386h.m11038a(string);
                    this.f16219a.f16197d.setLexTask(RunnableC2979c.f16193w);
                    this.f16219a.f16197d.setDocumentProvider(c1386h);
                    this.f16219a.f16197d.setEditable(false);
                    this.f16219a.f16197d.m10874a(true);
                    this.f16219a.f16197d.m10901h(0);
                    this.f16219a.f16197d.m10868a(1);
                    this.f16219a.f16201h = true;
                } else {
                    this.f16221c.setTitle(R.string.translate_java);
                    this.f16219a.f16197d.setLexTask(this.f16219a.f16199f);
                    this.f16219a.f16197d.setDocumentProvider(this.f16219a.f16198e);
                    this.f16219a.f16197d.setEditable(this.f16219a.f16203j);
                    this.f16219a.f16197d.m10874a(true);
                    this.f16219a.f16197d.m10901h(this.f16219a.f16207n);
                    this.f16219a.f16197d.m10868a(0);
                    this.f16219a.f16201h = false;
                    C3112bn.m19023b(this.f16219a.f16197d.getContext(), "Translate to java failed!");
                }
                this.f16219a.f16197d.postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.fragment.a.c.11.1

                    /* renamed from: a */
                    private final AnonymousClass11 f16222a;

                    {
                        this.f16222a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass11.m17809a(this.f16222a).f16197d.m19756h(false);
                    }
                }, 10L);
            }
        }
    }

    /* renamed from: k */
    public File m17795k() {
        return this.f16194a.getScheme().equals(ContentResolver.SCHEME_FILE) ? new File(this.f16194a.getPath()) : (File) null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public File m17758d(Uri uri) {
        return uri.getScheme().equals(ContentResolver.SCHEME_FILE) ? new File(uri.getPath()) : (File) null;
    }

    /* renamed from: a */
    public Editor m17772a(Context context, Editor.InterfaceC3272a interfaceC3272a) {
        this.f16197d = new Editor(context);
        this.f16201h = false;
        this.f16204k = false;
        this.f16210q = interfaceC3272a;
        this.f16197d.setContentDescription(String.format("%s (%s)", context.getString(R.string.editor), m17753c(this.f16194a)));
        this.f16197d.setOnEditStateChangedListener(this);
        this.f16197d.setLexTask(this.f16199f);
        this.f16197d.setDocumentProvider(this.f16198e);
        this.f16197d.m19756h(false);
        this.f16197d.setCharset(this.f16212s);
        return this.f16197d;
    }

    /* renamed from: l */
    public boolean m17796l() {
        if (m17791g()) {
            return false;
        }
        return this.f16197d.m10896f();
    }

    /* renamed from: m */
    public boolean m17797m() {
        if (m17791g()) {
            return false;
        }
        return this.f16203j;
    }

    /* renamed from: n */
    public boolean m17798n() {
        if (m17791g()) {
            return false;
        }
        return this.f16197d.m19743M();
    }

    /* renamed from: o */
    public boolean m17799o() {
        if (m17791g()) {
            return false;
        }
        return this.f16197d.m19742L();
    }

    /* renamed from: p */
    public boolean m17800p() {
        if (m17791g()) {
            return false;
        }
        return this.f16197d.m10876a();
    }

    /* renamed from: q */
    public void m17801q() {
        this.f16197d.requestFocus();
    }

    /* renamed from: r */
    public int m17802r() {
        if (!m17791g() && this.f16205l) {
            this.f16207n = this.f16197d.getCaretPosition();
        }
        return this.f16207n;
    }

    /* renamed from: a */
    public void m17775a(int i, int i2) {
        int i3 = (i2 - i) + 1;
        if (this.f16198e.length() > 0) {
            this.f16197d.m10874a(true);
            this.f16197d.m10888d(i, i3);
        } else {
            this.f16208o = i;
            this.f16209p = i3;
        }
    }

    /* renamed from: a */
    protected void m17777a(CharSequence charSequence) {
        this.f16198e.m11038a(charSequence);
        this.f16197d.m10883c();
        this.f16197d.m10860G();
        this.f16197d.m10897g();
        if (this.f16209p > 0) {
            this.f16197d.postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.fragment.a.c.13

                /* renamed from: a */
                private final RunnableC2979c f16225a;

                {
                    this.f16225a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f16225a.f16197d.m10888d(this.f16225a.f16208o, this.f16225a.f16209p);
                    this.f16225a.f16208o = 0;
                    this.f16225a.f16209p = 0;
                }
            }, 100L);
        }
    }

    /* renamed from: a */
    public void m17780a(boolean z) {
        if (!m17791g()) {
            this.f16197d.setEditable(z);
            if (z) {
                this.f16197d.m10868a(0);
            } else {
                this.f16197d.m10868a(1);
            }
            this.f16203j = z;
            return;
        }
        this.f16203j = false;
    }

    /* renamed from: s */
    public void m17803s() {
        if (m17791g()) {
            return;
        }
        this.f16197d.m19745O();
    }

    /* renamed from: t */
    public void m17804t() {
        if (m17791g()) {
            return;
        }
        this.f16197d.m19746P();
    }

    /* renamed from: u */
    public void m17805u() {
        if (m17791g()) {
            return;
        }
        this.f16197d.m10880b();
    }

    /* renamed from: v */
    public Editor m17806v() {
        return this.f16197d;
    }

    /* renamed from: w */
    public CharSequence m17807w() {
        return String.valueOf(m17753c(this.f16194a));
    }

    /* renamed from: b */
    public void m17785b(boolean z) {
        this.f16197d.setEdited(z);
    }

    /* renamed from: x */
    public void m17808x() {
        if (m17796l()) {
            try {
                String charSequence = this.f16197d.getText().toString();
                File m17758d = m17758d(this.f16194a);
                if (m17758d == null) {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.f16196c.openFileDescriptor(this.f16194a, "w").getFileDescriptor()));
                    C1887e.m13974a(charSequence, bufferedOutputStream, this.f16212s);
                    bufferedOutputStream.close();
                } else {
                    C3061a.m18320b(m17758d, charSequence, this.f16212s);
                }
                this.f16197d.setEdited(false);
                this.f16195b = C3112bn.m19020b(charSequence, KeyProperties.DIGEST_SHA1);
                MainActivity m16615o = MainActivity.m16615o();
                if (m16615o != null && !m16615o.isFinishing() && !m16615o.isDestroyed() && !m16615o.m16634p()) {
                    m16615o.runOnUiThread(new Runnable(this, m16615o) { // from class: ru.maximoff.apktool.fragment.a.c.14

                        /* renamed from: a */
                        private final RunnableC2979c f16226a;

                        /* renamed from: b */
                        private final MainActivity f16227b;

                        {
                            this.f16226a = this;
                            this.f16227b = m16615o;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            this.f16227b.m16644z();
                        }
                    });
                }
            } catch (Error | Exception e2) {
                C3112bn.m19000a(this.f16211r, R.string.err_save, m17807w());
            }
        }
    }

    /* renamed from: a */
    public boolean m17781a(Uri uri) {
        return this.f16194a.equals(uri);
    }

    @Override // java.lang.Runnable
    public void run() {
        String m13967a;
        try {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e2) {
            }
            File m17758d = m17758d(this.f16194a);
            if (m17758d == null) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.f16196c.openFileDescriptor(this.f16194a, "r").getFileDescriptor()));
                m13967a = C1887e.m13967a(bufferedInputStream, this.f16212s);
                bufferedInputStream.close();
            } else {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(m17758d));
                m13967a = C1887e.m13967a(bufferedInputStream2, this.f16212s);
                bufferedInputStream2.close();
            }
            String m19020b = C3112bn.m19020b(m13967a, KeyProperties.DIGEST_SHA1);
            if (this.f16195b != null && !this.f16195b.equalsIgnoreCase(m19020b)) {
                MainActivity m16615o = MainActivity.m16615o();
                if (m16615o != null && !m16615o.isFinishing() && !m16615o.isDestroyed() && !m16615o.m16634p()) {
                    this.f16211r = m16615o;
                    if (C3102bd.m18925a(this.f16211r, "editor_auto_reload", false)) {
                        this.f16204k = true;
                    } else {
                        m16615o.runOnUiThread(new AnonymousClass15(this));
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.f16204k || (!this.f16197d.m10896f() && !this.f16197d.m19743M() && !this.f16197d.m19742L())) {
                this.f16197d.postDelayed(new Runnable(this, m13967a, m19020b) { // from class: ru.maximoff.apktool.fragment.a.c.16

                    /* renamed from: a */
                    private final RunnableC2979c f16230a;

                    /* renamed from: b */
                    private final String f16231b;

                    /* renamed from: c */
                    private final String f16232c;

                    {
                        this.f16230a = this;
                        this.f16231b = m13967a;
                        this.f16232c = m19020b;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f16230a.m17777a((CharSequence) this.f16231b);
                        this.f16230a.f16197d.m19744N();
                        this.f16230a.f16197d.setEdited(false);
                        this.f16230a.f16197d.m10874a(true);
                        this.f16230a.f16197d.m10901h(this.f16230a.f16207n);
                        this.f16230a.f16195b = this.f16232c;
                        this.f16230a.f16204k = false;
                        if (this.f16230a.f16202i) {
                            this.f16230a.f16197d.setEditable(false);
                            this.f16230a.f16197d.m10868a(1);
                            this.f16230a.f16203j = false;
                        } else {
                            this.f16230a.f16197d.m10868a(0);
                        }
                        this.f16230a.f16197d.m10897g();
                        this.f16230a.f16205l = true;
                    }
                }, 100L);
            }
        } catch (Error e3) {
            e = e3;
            C3112bn.m19000a(this.f16211r, R.string.errorf, e.getMessage());
        } catch (Exception e4) {
            e = e4;
            C3112bn.m19000a(this.f16211r, R.string.errorf, e.getMessage());
        }
    }

    /* compiled from: EditorPagerItem.java */
    /* renamed from: ru.maximoff.apktool.fragment.a.c$15, reason: invalid class name */
    class AnonymousClass15 implements Runnable {

        /* renamed from: a */
        private final RunnableC2979c f16228a;

        AnonymousClass15(RunnableC2979c runnableC2979c) {
            this.f16228a = runnableC2979c;
        }

        /* renamed from: a */
        static RunnableC2979c m17810a(AnonymousClass15 anonymousClass15) {
            return anonymousClass15.f16228a;
        }

        @Override // java.lang.Runnable
        public void run() {
            new DialogInterfaceC0070b.a(this.f16228a.f16211r).m427a(this.f16228a.m17807w()).m436b(this.f16228a.f16211r.getString(R.string.file_is_changed, this.f16228a.m17807w())).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(this) { // from class: ru.maximoff.apktool.fragment.a.c.15.1

                /* renamed from: a */
                private final AnonymousClass15 f16229a;

                {
                    this.f16229a = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    AnonymousClass15.m17810a(this.f16229a).m17787c(true);
                    dialogInterface.dismiss();
                }
            }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
        }
    }

    /* renamed from: c */
    public void m17787c(boolean z) {
        if (z) {
            this.f16204k = true;
            this.f16195b = (String) null;
        }
        this.f16205l = false;
        this.f16207n = this.f16197d.getCaretPosition();
        new Thread(this).start();
    }

    /* renamed from: b */
    public void m17784b(String str) {
        if (m17791g()) {
            return;
        }
        this.f16197d.m10873a(str);
    }

    /* compiled from: EditorPagerItem.java */
    /* renamed from: ru.maximoff.apktool.fragment.a.c$a */
    private class a extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a */
        private Context f16260a;

        /* renamed from: b */
        private DialogInterfaceC0070b f16261b;

        /* renamed from: c */
        private String f16262c;

        /* renamed from: d */
        private List<C3084ap> f16263d;

        /* renamed from: e */
        private final RunnableC2979c f16264e;

        @Override // android.p008os.AsyncTask
        protected Boolean doInBackground(Void[] voidArr) {
            return m17812a(voidArr);
        }

        @Override // android.p008os.AsyncTask
        protected void onPostExecute(Boolean bool) {
            m17813a(bool);
        }

        public a(RunnableC2979c runnableC2979c, Context context) {
            this.f16264e = runnableC2979c;
            this.f16260a = context;
        }

        @Override // android.p008os.AsyncTask
        protected void onPreExecute() {
            View inflate = LayoutInflater.from(this.f16260a).inflate(R.layout.search_progress, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
            this.f16261b = new DialogInterfaceC0070b.a(this.f16260a).m435b(inflate).m429a(false).m438b();
            this.f16261b.show();
        }

        /* renamed from: a */
        protected Boolean m17812a(Void[] voidArr) {
            if (this.f16264e.m17791g()) {
                try {
                    this.f16263d = this.f16264e.m17741A();
                } catch (Error | Exception e2) {
                    this.f16262c = e2.toString();
                    return new Boolean(false);
                }
            } else {
                try {
                    this.f16263d = this.f16264e.m17771z();
                } catch (Error | Exception e3) {
                    this.f16262c = e3.toString();
                    return new Boolean(false);
                }
            }
            return new Boolean(true);
        }

        /* renamed from: a */
        protected void m17813a(Boolean bool) {
            if (this.f16261b != null && this.f16261b.isShowing()) {
                try {
                    this.f16261b.cancel();
                } catch (Exception e2) {
                }
            }
            if (bool.booleanValue()) {
                this.f16264e.m17779a(this.f16263d);
            } else if (this.f16262c == null) {
                C3112bn.m18999a(this.f16260a, R.string.error);
            } else {
                C3112bn.m19000a(this.f16260a, R.string.errorf, this.f16262c);
            }
        }
    }
}
