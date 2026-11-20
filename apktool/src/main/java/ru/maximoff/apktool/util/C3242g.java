package ru.maximoff.apktool.util;

import android.icu.text.DateFormat;
import java.p209io.BufferedReader;
import java.p209io.File;
import java.p209io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Chmod.java */
/* renamed from: ru.maximoff.apktool.util.g */
/* loaded from: classes.dex */
public class C3242g {

    /* renamed from: a */
    private File f19479a;

    /* renamed from: b */
    private String f19480b;

    /* renamed from: c */
    private String f19481c;

    /* renamed from: d */
    private String f19482d;

    /* renamed from: e */
    private String f19483e;

    /* renamed from: f */
    private String[] f19484f;

    /* renamed from: g */
    private String f19485g;

    public C3242g(File file) {
        this.f19479a = file;
        this.f19480b = file.getAbsolutePath();
        String[] strArr = new String[3];
        strArr[0] = "ls";
        strArr[1] = "-la";
        strArr[2] = this.f19479a.isDirectory() ? this.f19479a.getParent() : this.f19480b;
        this.f19484f = strArr;
        try {
            m19450f();
        } catch (Exception e2) {
        }
    }

    /* renamed from: a */
    public boolean m19453a() {
        return this.f19485g != null;
    }

    /* renamed from: b */
    public String m19454b() {
        return this.f19482d;
    }

    /* renamed from: c */
    public String m19455c() {
        return this.f19483e;
    }

    /* renamed from: d */
    public String m19456d() {
        return this.f19481c;
    }

    /* renamed from: e */
    public String m19457e() {
        return m19452a(this.f19481c);
    }

    public String toString() {
        return this.f19485g;
    }

    /* renamed from: f */
    private void m19450f() {
        String readLine;
        Process start = new ProcessBuilder(this.f19484f).start();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream()));
        while (true) {
            readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            if (this.f19479a.isDirectory()) {
                if (readLine.startsWith(DateFormat.DAY) || readLine.startsWith("l")) {
                    if (readLine.endsWith(new StringBuffer().append(" /").append(this.f19479a.getName()).toString()) || readLine.endsWith(new StringBuffer().append(" ").append(this.f19479a.getName()).toString())) {
                        break;
                    }
                }
            } else if (!readLine.trim().isEmpty()) {
                this.f19485g = readLine;
            }
        }
        this.f19485g = readLine;
        if (start.waitFor() != 0 || this.f19485g == null) {
            return;
        }
        m19451g();
    }

    /* renamed from: g */
    private void m19451g() {
        Matcher matcher = Pattern.compile("^([dlrwx-]{10})\\s+(\\d+)\\s+([^\\s]+)\\s+([^\\s]+)").matcher(this.f19485g);
        if (matcher.find()) {
            this.f19481c = matcher.group(1);
            this.f19482d = matcher.group(3);
            this.f19483e = matcher.group(4);
            return;
        }
        Matcher matcher2 = Pattern.compile("^([dlrwx-]{10})\\s+([^\\s]+)\\s+([^\\s]+)").matcher(this.f19485g);
        if (matcher2.find()) {
            this.f19481c = matcher2.group(1);
            this.f19482d = matcher2.group(2);
            this.f19483e = matcher2.group(3);
            return;
        }
        this.f19485g = (String) null;
    }

    /* renamed from: a */
    public String m19452a(String str) {
        if (str == null) {
            return "0";
        }
        ArrayList<String> arrayList = new ArrayList();
        for (int i = 1; i < str.length(); i += 3) {
            arrayList.add(str.substring(i, Math.min(i + 3, str.length())));
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : arrayList) {
            int i2 = 0;
            for (int i3 = 0; i3 < str2.length(); i3++) {
                switch (str2.charAt(i3)) {
                    case 'r':
                        i2 += 4;
                        break;
                    case 'w':
                        i2 += 2;
                        break;
                    case 'x':
                        i2++;
                        break;
                }
            }
            sb.append(i2);
        }
        return sb.toString();
    }
}
