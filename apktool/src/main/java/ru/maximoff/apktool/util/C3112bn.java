package ru.maximoff.apktool.util;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.icu.text.DateFormat;
import android.icu.text.SymbolTable;
import android.p008os.Build;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.srizwan.apktool.R;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.p209io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ru.maximoff.apktool.util.p304b.C3097b;

/* compiled from: TextUtil.java */
/* renamed from: ru.maximoff.apktool.util.bn */
/* loaded from: classes.dex */
public class C3112bn {

    /* renamed from: a */
    public static final String f18383a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    /* renamed from: b */
    public static final String f18384b = "0123456789ABCDEF";

    /* renamed from: d */
    private static final Pattern f18386d = Pattern.compile("[{}()\\[\\].+*?^$\\\\|]");

    /* renamed from: c */
    public static final String[] f18385c = {"{LABEL}", "{DEFAULT_LABEL}", "{PACKAGE}", "{VERSION}", "{CODE}", "{MINSDK}", "{TARGETSDK}", "{MINVER}", "{TARGETVER}", "{MINNAME}", "{TARGETNAME}", "{ARCH}", "{DATE}", "{TIME}"};

    /* renamed from: a */
    public static String m18994a(String str) {
        if (str == null) {
            return (String) null;
        }
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        StringBuilder sb = new StringBuilder(bytes.length);
        for (byte b2 : bytes) {
            if (b2 < 97 ? b2 < 65 ? b2 < 48 ? b2 == 45 || b2 == 46 : b2 <= 57 : b2 <= 90 || b2 == 95 : b2 <= 122 || b2 == 126) {
                sb.append((char) b2);
            } else {
                sb.append('%').append(f18384b.charAt((b2 >> 4) & 15)).append(f18384b.charAt(b2 & 15));
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0075, code lost:
    
        r8.append(new java.lang.String(r7, 0, r2, java.nio.charset.Charset.forName("UTF-8")));
        r2 = r3;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m19018b(String str) {
        char c2;
        char c3;
        if (str == null) {
            return (String) null;
        }
        int length = str.length();
        byte[] bArr = new byte[length / 3];
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt != '%') {
                sb.append(charAt);
                i++;
            } else {
                int i2 = 0;
                int i3 = i;
                while (true) {
                    char charAt2 = str.charAt(i3 + 1);
                    char charAt3 = str.charAt(i3 + 2);
                    i3 += 3;
                    char c4 = (char) (charAt2 - '0');
                    if (c4 >= '\n') {
                        char c5 = (char) (((char) (c4 | ' ')) - '1');
                        if (c5 >= 6) {
                            throw new IllegalArgumentException();
                        }
                        c2 = (char) (c5 + '\n');
                    } else {
                        c2 = c4;
                    }
                    char c6 = (char) (charAt3 - '0');
                    if (c6 >= '\n') {
                        char c7 = (char) (((char) (c6 | ' ')) - '1');
                        if (c7 >= 6) {
                            throw new IllegalArgumentException();
                        }
                        c3 = (char) (c7 + '\n');
                    } else {
                        c3 = c6;
                    }
                    int i4 = i2 + 1;
                    bArr[i2] = (byte) (c3 | (c2 << 4));
                    if (i3 < length && str.charAt(i3) == '%') {
                        i2 = i4;
                    }
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: c */
    public static String m19025c(String str) {
        String stringBuffer;
        String str2 = "^";
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '*':
                    stringBuffer = new StringBuffer().append(str2).append(".*").toString();
                    break;
                case '.':
                    stringBuffer = new StringBuffer().append(str2).append("\\.").toString();
                    break;
                case '?':
                    stringBuffer = new StringBuffer().append(str2).append('.').toString();
                    break;
                case '\\':
                    stringBuffer = new StringBuffer().append(str2).append("\\\\").toString();
                    break;
                default:
                    stringBuffer = new StringBuffer().append(str2).append(charAt).toString();
                    break;
            }
            i++;
            str2 = stringBuffer;
        }
        return new StringBuffer().append(str2).append(SymbolTable.SYMBOL_REF).toString();
    }

    /* renamed from: d */
    public static String m19029d(String str) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (z) {
                if (charAt == 't') {
                    sb.append('\t');
                } else if (charAt == 'b') {
                    sb.append('\b');
                } else if (charAt == 'r') {
                    sb.append('\r');
                } else if (charAt == 'n') {
                    sb.append('\n');
                } else if (charAt == 'f') {
                    sb.append('\f');
                } else if (charAt == '\\' || charAt == '\'' || charAt == '\"') {
                    sb.append(charAt);
                } else {
                    sb.append('\\').append(charAt);
                }
                z = false;
            } else if (charAt == '\\') {
                z = true;
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    /* renamed from: e */
    public static boolean m19030e(String str) {
        return str.matches("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$");
    }

    /* renamed from: f */
    public static String m19031f(String str) {
        return str.replaceAll("\\\\n", "\n").replaceAll("\\\\\"", "\"").replaceAll("\\\\'", "'").replace("&amp;", "&").replace("&lt;", "<");
    }

    /* renamed from: a */
    public static String m18988a(int i) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(i);
        for (int i2 = 0; i2 < i; i2++) {
            char charAt = f18383a.charAt(random.nextInt(f18383a.length()));
            while (i2 == 0 && Character.isDigit(charAt)) {
                charAt = f18383a.charAt(random.nextInt(f18383a.length()));
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static boolean m19012a(char c2) {
        return (c2 >= 'A' && c2 <= 'Z') || (c2 >= 'a' && c2 <= 'z');
    }

    /* renamed from: a */
    public static void m19009a(TextView textView, String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new URLSpan(""), 0, spannableString.length(), 33);
        textView.setText(spannableString, TextView.BufferType.SPANNABLE);
        textView.setClickable(true);
    }

    /* renamed from: a */
    public static void m19002a(Context context, String str) {
        if (!m19040o(str)) {
            try {
                ((ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText(context.getString(R.string.app_name), str));
                m18999a(context, R.string.copy_success);
            } catch (Exception e2) {
                m18999a(context, R.string.error);
            }
        }
    }

    /* renamed from: a */
    public static String m18991a(Context context) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        if (clipboardManager.hasPrimaryClip()) {
            ClipDescription primaryClipDescription = clipboardManager.getPrimaryClipDescription();
            ClipData primaryClip = clipboardManager.getPrimaryClip();
            if (primaryClipDescription != null && primaryClip != null && (primaryClipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN) || primaryClipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_HTML))) {
                return String.valueOf(primaryClip.getItemAt(0).getText());
            }
        }
        return (String) null;
    }

    /* renamed from: a */
    public static void m19003a(Context context, String str, int i) {
        int i2;
        int m19470a;
        try {
            switch (C3102bd.f18319b) {
                case 1:
                    i2 = R.drawable.bg_toast_dark;
                    m19470a = C3246h.m19470a(context, R.color.toast_text_dark);
                    break;
                case 2:
                    i2 = R.drawable.bg_toast_black;
                    m19470a = C3246h.m19470a(context, R.color.toast_text_dark);
                    break;
                default:
                    i2 = R.drawable.bg_toast;
                    m19470a = C3246h.m19470a(context, R.color.toast_text);
                    break;
            }
            Drawable drawable = context.getResources().getDrawable(i2);
            View inflate = LayoutInflater.from(context).inflate(R.layout.toast, (ViewGroup) null);
            inflate.setBackground(drawable);
            TextView textView = (TextView) inflate.findViewById(R.id.toastTextView1);
            textView.setTextColor(m19470a);
            textView.setText(str);
            Toast toast = new Toast(context);
            toast.setDuration(i);
            toast.setView(inflate);
            toast.show();
        } catch (Exception e2) {
        }
    }

    /* renamed from: b */
    public static void m19023b(Context context, String str) {
        try {
            m19003a(context, str, 0);
        } catch (Exception e2) {
        }
    }

    /* renamed from: a */
    public static void m18999a(Context context, int i) {
        try {
            m19003a(context, context.getString(i), 0);
        } catch (Exception e2) {
        }
    }

    /* renamed from: b */
    public static void m19022b(Context context, int i) {
        try {
            m19003a(context, context.getString(i), 1);
        } catch (Exception e2) {
        }
    }

    /* renamed from: a */
    public static void m19000a(Context context, int i, Object... objArr) {
        try {
            m19003a(context, context.getString(i, objArr), 0);
        } catch (Exception e2) {
        }
    }

    /* renamed from: a */
    public static String m18989a(long j) {
        return new SimpleDateFormat(C3102bd.f18266B).format(new Date(j));
    }

    /* renamed from: a */
    public static String m18990a(long j, String str) {
        return new SimpleDateFormat(str).format(new Date(j));
    }

    /* renamed from: g */
    public static String m19032g(String str) {
        return new SimpleDateFormat(str).format(new Date());
    }

    /* renamed from: a */
    public static long m18986a(String str, String str2) {
        return new SimpleDateFormat(str2).parse(str).getTime();
    }

    /* renamed from: a */
    public static String m18995a(String str, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = Pattern.compile("\\{(\\d+)\\}").matcher(str);
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, String.format(new StringBuffer().append(new StringBuffer().append("%0").append(matcher.group(1).length()).toString()).append(DateFormat.DAY).toString(), new Long(Long.parseLong(matcher.group(1)) + i)));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static void m19001a(Context context, TextView textView, int i) {
        if (Build.VERSION.SDK_INT < 23) {
            textView.setTextAppearance(context, i);
        } else {
            textView.setTextAppearance(i);
        }
    }

    /* renamed from: h */
    public static String m19033h(String str) {
        return str.replaceAll("[\\\\/:*?\"<>|]", "_").replaceAll("\\s", " ");
    }

    /* renamed from: i */
    public static boolean m19034i(String str) {
        return Pattern.compile("[\\\\/:*?\"<>|]+").matcher(str).find();
    }

    /* renamed from: j */
    public static boolean m19035j(String str) {
        return str.trim().matches(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("^").append("([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])").toString()).append("\\s?,\\s?").toString()).append("([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])").toString()).append("\\s?,\\s?").toString()).append("([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])").toString()).append("$").toString()) || str.trim().matches(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("^").append("([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])").toString()).append("\\s?,\\s?").toString()).append("([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])").toString()).append("\\s?,\\s?").toString()).append("([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])").toString()).append("\\s?,\\s?").toString()).append("([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])").toString()).append("$").toString());
    }

    /* renamed from: k */
    public static int m19036k(String str) {
        int parseInt;
        int parseInt2;
        int parseInt3;
        int parseInt4;
        try {
            String[] split = str.trim().split(",");
            if (split.length == 3) {
                parseInt = 255;
                parseInt2 = Integer.parseInt(split[0].trim());
                parseInt3 = Integer.parseInt(split[1].trim());
                parseInt4 = Integer.parseInt(split[2].trim());
            } else {
                parseInt = Integer.parseInt(split[0].trim());
                parseInt2 = Integer.parseInt(split[1].trim());
                parseInt3 = Integer.parseInt(split[2].trim());
                parseInt4 = Integer.parseInt(split[3].trim());
            }
            return Color.argb(parseInt, parseInt2, parseInt3, parseInt4);
        } catch (Exception e2) {
            return -16777216;
        }
    }

    /* renamed from: b */
    public static String m19020b(String str, String str2) {
        if (str.equals("")) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
            return m18997a(messageDigest.digest());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e2) {
            return (String) null;
        }
    }

    /* renamed from: a */
    public static String m18997a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            sb.append(String.format("%02x", new Byte(b2)));
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m18998a(byte[] bArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            if (i > 0) {
                sb.append(str);
            }
            sb.append(new StringBuffer().append("0x").append(String.format("%x", new Byte(bArr[i]))).toString());
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static String m19021b(byte[] bArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            if (i > 0) {
                sb.append(str);
            }
            byte b2 = bArr[i];
            if (b2 < 0) {
                sb.append(new StringBuffer().append(new StringBuffer().append("-0x").append(String.format("%02x", new Integer(256 - (b2 & 255)))).toString()).append("t").toString());
            } else {
                sb.append(new StringBuffer().append(new StringBuffer().append("0x").append(String.format("%02x", new Byte(b2))).toString()).append("t").toString());
            }
        }
        return sb.toString();
    }

    /* renamed from: l */
    public static byte[] m19037l(String str) {
        String[] split = str.replaceAll("..(?!$)", "$0 ").split(" ");
        byte[] bArr = new byte[split.length];
        for (int i = 0; i < split.length; i++) {
            bArr[i] = (byte) Integer.parseInt(split[i], 16);
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m19015a(String[] strArr) {
        byte[] bArr = new byte[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String replace = strArr[i].trim().toLowerCase().replace("0x", "");
            if (replace.charAt(0) == '-') {
                bArr[i] = (byte) (-((byte) Integer.parseInt(replace.substring(1).replaceAll("[^a-f0-9]", ""), 16)));
            } else {
                bArr[i] = (byte) Integer.parseInt(replace.replaceAll("[^a-f0-9]", ""), 16);
            }
        }
        return bArr;
    }

    /* renamed from: m */
    public static String m19038m(String str) {
        Matcher matcher = Pattern.compile("\\\\u([0-9a-f]{4})", 2).matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, String.valueOf((char) Integer.parseInt(matcher.group(1), 16)));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    /* renamed from: n */
    public static String m19039n(String str) {
        if (!str.equals("")) {
            StringBuilder sb = new StringBuilder();
            for (char c2 : str.toCharArray()) {
                if (c2 >= 128) {
                    sb.append("\\u").append(String.format("%04X", new Integer(c2)));
                } else {
                    sb.append(c2);
                }
            }
            return sb.toString();
        }
        return str;
    }

    /* renamed from: a */
    public static void m19007a(EditText editText, CharSequence charSequence) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        editText.getText().replace(Math.min(max, max2), Math.max(max, max2), charSequence);
        editText.requestFocus();
    }

    /* renamed from: a */
    public static void m19005a(ViewGroup viewGroup, int i) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof ViewGroup) {
                m19005a((ViewGroup) childAt, i);
            } else if (childAt instanceof TextView) {
                ((TextView) childAt).setTextSize(2, i);
            }
        }
    }

    /* renamed from: a */
    public static boolean m19013a(Editable editable) {
        return editable == null || m19040o(editable.toString());
    }

    /* renamed from: a */
    public static boolean m19014a(CharSequence charSequence) {
        return charSequence == null || m19040o(charSequence.toString());
    }

    /* renamed from: o */
    public static boolean m19040o(String str) {
        return str == null || str.equals("");
    }

    /* renamed from: b */
    public static String m19017b(CharSequence charSequence) {
        return charSequence == null ? "" : charSequence.toString();
    }

    /* renamed from: a */
    public static void m19011a(List<String> list, List<String> list2) {
        if (list != null && list2 != null) {
            for (String str : list2) {
                if (!list.contains(str)) {
                    list.add(str);
                }
            }
        }
    }

    /* renamed from: a */
    public static String m18992a(Context context, C3060a c3060a, String str) {
        return m18993a(context, c3060a, str, (List) null);
    }

    /* renamed from: a */
    public static String m18993a(Context context, C3060a c3060a, String str, List<String> list) {
        String replace;
        String replace2;
        String m19032g;
        String m19032g2;
        String replace3;
        String replace4;
        String replace5;
        StringBuffer stringBuffer = new StringBuffer();
        List<String> list2 = (List) null;
        Matcher matcher = Pattern.compile("\\{(LABEL|DEFAULT_LABEL|VERSION|ARCH|DATE|TIME|MINNAME|TARGETNAME)([^\\}]+)\\}").matcher(str);
        while (matcher.find()) {
            if (matcher.group(1).equals("LABEL")) {
                try {
                    replace5 = c3060a.m18271i().replaceAll("\\s", matcher.group(2));
                } catch (Exception e2) {
                    replace5 = c3060a.m18271i().replace(" ", matcher.group(2));
                }
                matcher.appendReplacement(stringBuffer, replace5);
            } else if (matcher.group(1).equals("DEFAULT_LABEL")) {
                try {
                    replace4 = c3060a.m18275m().replaceAll("\\s", matcher.group(2));
                } catch (Exception e3) {
                    replace4 = c3060a.m18275m().replace(" ", matcher.group(2));
                }
                matcher.appendReplacement(stringBuffer, replace4);
            } else if (matcher.group(1).equals("VERSION")) {
                try {
                    replace3 = c3060a.m18277o().replaceAll("\\s", matcher.group(2));
                } catch (Exception e4) {
                    replace3 = c3060a.m18277o().replace(" ", matcher.group(2));
                }
                matcher.appendReplacement(stringBuffer, replace3);
            } else if (matcher.group(1).equals("DATE")) {
                try {
                    m19032g2 = m19032g("yyyy-MM-dd").replace("-", matcher.group(2));
                } catch (Exception e5) {
                    m19032g2 = m19032g("yyyy-MM-dd");
                }
                matcher.appendReplacement(stringBuffer, m19032g2);
            } else if (matcher.group(1).equals("TIME")) {
                try {
                    m19032g = m19032g("HH-mm-ss").replace("-", matcher.group(2));
                } catch (Exception e6) {
                    m19032g = m19032g("HH-mm-ss");
                }
                matcher.appendReplacement(stringBuffer, m19032g);
            } else if (matcher.group(1).equals("ARCH")) {
                if (list2 == null) {
                    list2 = c3060a.m18259H();
                }
                if (!list2.isEmpty()) {
                    matcher.appendReplacement(stringBuffer, C3080al.m18538a(list2, matcher.group(2)));
                } else if (list != null) {
                    matcher.appendReplacement(stringBuffer, C3080al.m18538a(list, matcher.group(2)));
                } else {
                    matcher.appendReplacement(stringBuffer, "universal");
                }
            } else if (matcher.group(1).equals("MINNAME")) {
                try {
                    replace2 = c3060a.m18285w().replaceAll("\\s", matcher.group(2));
                } catch (Exception e7) {
                    replace2 = c3060a.m18285w().replace(" ", matcher.group(2));
                }
                matcher.appendReplacement(stringBuffer, replace2);
            } else if (matcher.group(1).equals("TARGETNAME")) {
                try {
                    replace = c3060a.m18286x().replaceAll("\\s", matcher.group(2));
                } catch (Exception e8) {
                    replace = c3060a.m18286x().replace(" ", matcher.group(2));
                }
                matcher.appendReplacement(stringBuffer, replace);
            }
        }
        matcher.appendTail(stringBuffer);
        if (str.indexOf("{ARCH}") >= 0 && list2 == null) {
            list2 = c3060a.m18259H();
            if (list2.isEmpty()) {
                if (list != null) {
                    list2.addAll(list);
                } else {
                    list2.add("universal");
                }
            }
        }
        return m19027c(C3102bd.m18910a(context, "apk_name_chars_remove", ""), stringBuffer.toString().replace("{DATE}", m19032g("yyyy-MM-dd")).replace("{TIME}", m19032g("HH-mm-ss")).replace("{ARCH}", C3080al.m18538a(list2, ",")).replace("{LABEL}", c3060a.m18271i()).replace("{DEFAULT_LABEL}", c3060a.m18275m()).replace("{PACKAGE}", c3060a.m18276n()).replace("{VERSION}", c3060a.m18277o()).replace("{CODE}", String.valueOf(c3060a.m18278p())).replace("{MINSDK}", String.valueOf(c3060a.m18281s())).replace("{TARGETSDK}", String.valueOf(c3060a.m18283u())).replace("{MINVER}", C3080al.m18530a(c3060a.m18281s())).replace("{TARGETVER}", C3080al.m18530a(c3060a.m18283u())).replace("{MINNAME}", c3060a.m18285w()).replace("{TARGETNAME}", c3060a.m18286x()));
    }

    /* renamed from: c */
    public static String m19024c(CharSequence charSequence) {
        return f18386d.matcher(charSequence).replaceAll("\\\\$0");
    }

    /* renamed from: a */
    public static void m19004a(Editable editable, Class<? extends CharacterStyle> cls) {
        for (CharacterStyle characterStyle : (CharacterStyle[]) editable.getSpans(0, editable.length(), cls)) {
            editable.removeSpan(characterStyle);
        }
    }

    /* renamed from: c */
    public static void m19028c(Context context, String str) {
        try {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType(ClipDescription.MIMETYPE_TEXT_PLAIN);
            intent.putExtra(Intent.EXTRA_TEXT, str);
            intent.addFlags(268435456);
            context.startActivity(Intent.createChooser(intent, context.getString(R.string.send)));
        } catch (Exception e2) {
            m18999a(context, R.string.error);
        }
    }

    /* renamed from: a */
    public static void m19008a(TextView textView) {
        textView.setText(m19041p(textView.getText().toString()));
    }

    /* renamed from: p */
    public static Spanned m19041p(String str) {
        return Build.VERSION.SDK_INT < 24 ? Html.fromHtml(str) : Html.fromHtml(str, 0);
    }

    /* renamed from: q */
    public static String m19042q(String str) {
        if (!m19040o(str)) {
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            String[] split = str.split("\\.");
            for (int i = 0; i < split.length; i++) {
                if (split[i].length() != 0) {
                    if (i > 0 && sb.length() > 0) {
                        sb.append(".");
                    }
                    for (char c2 : split[i].toCharArray()) {
                        if (Character.isDigit(c2)) {
                            sb.append(String.valueOf(C3080al.m18520a(0, 9)));
                        } else {
                            char charAt = C3249i.f19556p.charAt(random.nextInt(C3249i.f19556p.length()));
                            if (Character.isUpperCase(c2)) {
                                charAt = Character.toUpperCase(charAt);
                            }
                            sb.append(charAt);
                        }
                    }
                }
            }
            return sb.toString();
        }
        return str;
    }

    /* renamed from: r */
    public static String m19043r(String str) {
        String stringBuffer = new StringBuffer().append(C3249i.f19556p).append("1234567890").toString();
        char charAt = str.charAt(str.length() - 1);
        if (Character.isUpperCase(charAt)) {
            stringBuffer = stringBuffer.toUpperCase();
        }
        int indexOf = stringBuffer.indexOf(charAt);
        String substring = str.substring(0, str.length() - 1);
        if (indexOf < 0 || indexOf >= stringBuffer.length() - 1) {
            return new StringBuffer().append(substring).append(stringBuffer.substring(0, 1)).toString();
        }
        return new StringBuffer().append(substring).append(stringBuffer.substring(indexOf + 1, indexOf + 2)).toString();
    }

    /* renamed from: b */
    public static String m19019b(String str, int i) {
        StringBuilder sb = new StringBuilder();
        String[] split = str.split("\\s");
        int i2 = 0;
        while (true) {
            if (i2 >= split.length) {
                break;
            }
            if (i2 > 0) {
                sb.append(" ");
            }
            sb.append(split[i2]);
            if (sb.length() <= i || i2 >= split.length - 1) {
                i2++;
            } else {
                sb.append("...");
                break;
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m18996a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        StringBuilder sb2 = new StringBuilder(str.toLowerCase());
        String lowerCase = str2.toLowerCase();
        int i = 0;
        while (true) {
            int indexOf = sb2.indexOf(lowerCase, i);
            if (indexOf != -1) {
                sb.replace(indexOf, lowerCase.length() + indexOf, str3);
                sb2.replace(indexOf, lowerCase.length() + indexOf, str3);
                i = indexOf + str3.length();
            } else {
                sb2.setLength(0);
                sb2.trimToSize();
                return sb.toString();
            }
        }
    }

    /* renamed from: c */
    public static String m19026c(String str, int i) {
        int i2;
        int i3;
        int i4 = 0;
        for (int i5 = 0; i5 < str.length(); i5 = i5 + i3 + 1) {
            char charAt = str.charAt(i5);
            if (charAt <= 127) {
                i2 = 1;
                i3 = 0;
            } else if (charAt <= 2047) {
                i2 = 2;
                i3 = 0;
            } else if (charAt <= 55295) {
                i2 = 3;
                i3 = 0;
            } else if (charAt <= 57343) {
                i2 = 4;
                i3 = 1;
            } else {
                i2 = 3;
                i3 = 0;
            }
            if (i4 + i2 > i) {
                return str.substring(0, i5);
            }
            i4 += i2;
        }
        return str;
    }

    /* renamed from: a */
    public static void m19006a(EditText editText, int i) {
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
    }

    /* renamed from: a */
    public static SpannableString m18987a(SpannableString spannableString) {
        HashSet hashSet = new HashSet();
        Matcher matcher = Pattern.compile(String.format(Locale.f10688US, "#[0-9a-fA-F]{%d}", new Integer(8))).matcher(spannableString);
        while (matcher.find()) {
            try {
                int parseColor = Color.parseColor(matcher.group(0));
                int i = C3097b.m18818a(parseColor) ? -1 : -16777216;
                hashSet.add(new Integer(matcher.start()));
                spannableString.setSpan(new BackgroundColorSpan(parseColor), matcher.start(), matcher.end(), 33);
                spannableString.setSpan(new ForegroundColorSpan(i), matcher.start(), matcher.end(), 33);
            } catch (Exception e2) {
            }
        }
        Matcher matcher2 = Pattern.compile(String.format(Locale.f10688US, "#[0-9a-fA-F]{%d}", new Integer(6))).matcher(spannableString);
        while (matcher2.find()) {
            if (!hashSet.contains(new Integer(matcher2.start()))) {
                try {
                    int parseColor2 = Color.parseColor(matcher2.group(0));
                    int i2 = C3097b.m18818a(parseColor2) ? -1 : -16777216;
                    hashSet.add(new Integer(matcher2.start()));
                    spannableString.setSpan(new BackgroundColorSpan(parseColor2), matcher2.start(), matcher2.end(), 33);
                    spannableString.setSpan(new ForegroundColorSpan(i2), matcher2.start(), matcher2.end(), 33);
                } catch (Exception e3) {
                }
            }
        }
        Matcher matcher3 = Pattern.compile(String.format(Locale.f10688US, "#[0-9a-fA-F]{%d}", new Integer(4))).matcher(spannableString);
        while (matcher3.find()) {
            if (!hashSet.contains(new Integer(matcher3.start()))) {
                try {
                    String group = matcher3.group(0);
                    StringBuilder sb = new StringBuilder();
                    for (int i3 = 1; i3 < 5; i3++) {
                        sb.append(group.charAt(i3)).append(group.charAt(i3));
                    }
                    int parseColor3 = Color.parseColor(new StringBuffer().append("#").append(sb.toString()).toString());
                    int i4 = C3097b.m18818a(parseColor3) ? -1 : -16777216;
                    hashSet.add(new Integer(matcher3.start()));
                    spannableString.setSpan(new BackgroundColorSpan(parseColor3), matcher3.start(), matcher3.end(), 33);
                    spannableString.setSpan(new ForegroundColorSpan(i4), matcher3.start(), matcher3.end(), 33);
                } catch (Exception e4) {
                }
            }
        }
        Matcher matcher4 = Pattern.compile(String.format(Locale.f10688US, "#[0-9a-fA-F]{%d}", new Integer(3))).matcher(spannableString);
        while (matcher4.find()) {
            if (!hashSet.contains(new Integer(matcher4.start()))) {
                try {
                    String group2 = matcher4.group(0);
                    StringBuilder sb2 = new StringBuilder();
                    for (int i5 = 1; i5 < 4; i5++) {
                        sb2.append(group2.charAt(i5)).append(group2.charAt(i5));
                    }
                    int parseColor4 = Color.parseColor(new StringBuffer().append("#").append(sb2.toString()).toString());
                    int i6 = C3097b.m18818a(parseColor4) ? -1 : -16777216;
                    spannableString.setSpan(new BackgroundColorSpan(parseColor4), matcher4.start(), matcher4.end(), 33);
                    spannableString.setSpan(new ForegroundColorSpan(i6), matcher4.start(), matcher4.end(), 33);
                } catch (Exception e5) {
                }
            }
        }
        return spannableString;
    }

    /* renamed from: c */
    public static String m19027c(String str, String str2) {
        int i = 0;
        if (!m19040o(str) && !m19040o(str2)) {
            HashSet hashSet = new HashSet();
            int i2 = 0;
            while (i2 < str.length()) {
                int codePointAt = str.codePointAt(i2);
                hashSet.add(new Integer(codePointAt));
                i2 += Character.charCount(codePointAt);
            }
            StringBuilder sb = new StringBuilder(str2.length());
            while (i < str2.length()) {
                int codePointAt2 = str2.codePointAt(i);
                if (!hashSet.contains(new Integer(codePointAt2))) {
                    sb.appendCodePoint(codePointAt2);
                }
                i += Character.charCount(codePointAt2);
            }
            return sb.toString();
        }
        return str2;
    }

    /* renamed from: a */
    public static void m19010a(StringBuilder sb) {
        try {
            Field[] declaredFields = Class.forName("android.os.Build").getDeclaredFields();
            if (declaredFields == null || declaredFields.length == 0) {
                sb.append("*** Build declared fields is null ***");
                return;
            }
            for (Field field : declaredFields) {
                try {
                    field.setAccessible(true);
                    Object obj = field.get("");
                    if (obj instanceof String[]) {
                        sb.append(new StringBuffer().append(new StringBuffer().append(field.getName()).append(": ").toString()).append(C3080al.m18540a((String[]) obj, ", ")).toString()).append("\n");
                    } else {
                        sb.append(new StringBuffer().append(new StringBuffer().append(field.getName()).append(": ").toString()).append(obj.toString()).toString()).append("\n");
                    }
                } catch (Error e2) {
                } catch (Exception e3) {
                }
            }
        } catch (ClassNotFoundException e4) {
            throw new NoClassDefFoundError(e4.getMessage());
        }
    }

    /* renamed from: b */
    public static String m19016b(int i) {
        if (i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}
