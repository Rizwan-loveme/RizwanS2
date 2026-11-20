package ru.maximoff.apktool.fragment.p302b;

import java.p209io.File;
import java.util.Comparator;

/* compiled from: FileComparator.java */
/* renamed from: ru.maximoff.apktool.fragment.b.h */
/* loaded from: classes.dex */
public enum EnumC2989h implements Comparator<File> {
    NAME { // from class: ru.maximoff.apktool.fragment.b.h.1
        @Override // ru.maximoff.apktool.fragment.p302b.EnumC2989h
        /* renamed from: a */
        public int mo17914a(File file, File file2) {
            return EnumC2989h.m17906a(file.getName().toLowerCase(), file2.getName().toLowerCase());
        }
    },
    NAME_REVERSE { // from class: ru.maximoff.apktool.fragment.b.h.2
        @Override // ru.maximoff.apktool.fragment.p302b.EnumC2989h
        /* renamed from: a */
        public int mo17914a(File file, File file2) {
            return EnumC2989h.NAME.mo17914a(file2, file);
        }
    },
    TYPE { // from class: ru.maximoff.apktool.fragment.b.h.3
        @Override // ru.maximoff.apktool.fragment.p302b.EnumC2989h
        /* renamed from: a */
        public int mo17914a(File file, File file2) {
            int compareTo = EnumC2989h.m17913b(file).compareTo(EnumC2989h.m17913b(file2));
            if (compareTo == 0) {
                return EnumC2989h.NAME.mo17914a(file, file2);
            }
            return compareTo;
        }
    },
    TYPE_REVERSE { // from class: ru.maximoff.apktool.fragment.b.h.4
        @Override // ru.maximoff.apktool.fragment.p302b.EnumC2989h
        /* renamed from: a */
        public int mo17914a(File file, File file2) {
            return EnumC2989h.TYPE.mo17914a(file2, file);
        }
    },
    SIZE { // from class: ru.maximoff.apktool.fragment.b.h.5
        @Override // ru.maximoff.apktool.fragment.p302b.EnumC2989h
        /* renamed from: a */
        public int mo17914a(File file, File file2) {
            long length = file.length() - file2.length();
            if (length > 0) {
                return 1;
            }
            if (length < 0) {
                return -1;
            }
            return EnumC2989h.NAME.mo17914a(file, file2);
        }
    },
    SIZE_REVERSE { // from class: ru.maximoff.apktool.fragment.b.h.6
        @Override // ru.maximoff.apktool.fragment.p302b.EnumC2989h
        /* renamed from: a */
        public int mo17914a(File file, File file2) {
            return EnumC2989h.SIZE.mo17914a(file2, file);
        }
    },
    TIME { // from class: ru.maximoff.apktool.fragment.b.h.7
        @Override // ru.maximoff.apktool.fragment.p302b.EnumC2989h
        /* renamed from: a */
        public int mo17914a(File file, File file2) {
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified > 0) {
                return 1;
            }
            if (lastModified < 0) {
                return -1;
            }
            return EnumC2989h.NAME.mo17914a(file, file2);
        }
    },
    TIME_REVERSE { // from class: ru.maximoff.apktool.fragment.b.h.8
        @Override // ru.maximoff.apktool.fragment.p302b.EnumC2989h
        /* renamed from: a */
        public int mo17914a(File file, File file2) {
            return EnumC2989h.TIME.mo17914a(file2, file);
        }
    };


    /* renamed from: j */
    private static EnumC2989h f16455j = NAME;

    @Override // java.util.Comparator
    public int compare(File file, File file2) {
        return mo17914a(file, file2);
    }

    public static EnumC2989h valueOf(String str) {
        for (EnumC2989h enumC2989h : values()) {
            if (enumC2989h.name().equals(str)) {
                return enumC2989h;
            }
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    public static void m17911a(EnumC2989h enumC2989h) {
        f16455j = enumC2989h;
    }

    /* renamed from: a */
    public static void m17910a(int i) {
        m17911a(values()[i]);
    }

    /* renamed from: a */
    public static EnumC2989h m17909a() {
        return f16455j;
    }

    /* renamed from: a */
    public int mo17914a(File file, File file2) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static String m17913b(File file) {
        String name;
        int lastIndexOf;
        if (file.isDirectory() || (lastIndexOf = (name = file.getName()).lastIndexOf(46)) == -1) {
            return "";
        }
        return name.substring(lastIndexOf + 1);
    }

    /* renamed from: a */
    public static int m17906a(String str, String str2) {
        a m17908a = m17908a(str);
        a m17908a2 = m17908a(str2);
        int compareTo = m17908a.f16456a.compareTo(m17908a2.f16456a);
        if (compareTo == 0) {
            if (m17908a.f16457b ? !m17908a2.f16457b : m17908a2.f16457b) {
                return m17908a.f16457b ? 1 : -1;
            }
            if (!m17908a.f16457b) {
                return 0;
            }
            return m17912b(m17908a.f16458c, m17908a2.f16458c);
        }
        return compareTo;
    }

    /* renamed from: a */
    private static a m17908a(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            lastIndexOf = str.length();
        }
        int indexOf = str.indexOf(36);
        if (indexOf == -1 || indexOf >= lastIndexOf) {
            return new a(str, false, "");
        }
        return new a(new StringBuffer().append(str.substring(0, indexOf)).append(str.substring(lastIndexOf)).toString(), true, str.substring(indexOf + 1, lastIndexOf));
    }

    /* renamed from: b */
    private static int m17912b(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        int i = 0;
        for (int i2 = 0; i < length && i2 < length2; i2++) {
            char charAt = str.charAt(i);
            char charAt2 = str2.charAt(i2);
            if (Character.isDigit(charAt) && Character.isDigit(charAt2)) {
                int i3 = i;
                while (i3 < length && Character.isDigit(str.charAt(i3))) {
                    i3++;
                }
                int i4 = i2;
                while (i4 < length2 && Character.isDigit(str2.charAt(i4))) {
                    i4++;
                }
                String substring = str.substring(i, i3);
                String substring2 = str2.substring(i2, i4);
                String replaceFirst = substring.replaceFirst("^0+", "");
                String replaceFirst2 = substring2.replaceFirst("^0+", "");
                if (replaceFirst.length() != replaceFirst2.length()) {
                    return replaceFirst.length() - replaceFirst2.length();
                }
                int compareTo = replaceFirst.compareTo(replaceFirst2);
                return compareTo == 0 ? substring.length() - substring2.length() : compareTo;
            }
            if (charAt != charAt2) {
                return charAt - charAt2;
            }
            i++;
        }
        return length - length2;
    }

    /* compiled from: FileComparator.java */
    /* renamed from: ru.maximoff.apktool.fragment.b.h$a */
    private static class a {

        /* renamed from: a */
        String f16456a;

        /* renamed from: b */
        boolean f16457b;

        /* renamed from: c */
        String f16458c;

        a(String str, boolean z, String str2) {
            this.f16456a = str;
            this.f16457b = z;
            this.f16458c = str2;
        }
    }
}
