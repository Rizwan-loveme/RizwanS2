package ru.maximoff.apktool.util;

import android.app.Notification;
import android.bluetooth.p005le.AdvertisingSetParameters;
import android.content.Context;
import android.icu.text.DateFormat;
import android.media.MediaPlayer;
import android.provider.Telephony;
import android.view.textclassifier.TextClassifier;
import javax.xml.XMLConstants;

/* compiled from: Constants.java */
/* renamed from: ru.maximoff.apktool.util.i */
/* loaded from: classes.dex */
public class C3249i {

    /* renamed from: g */
    public static final String f19547g = "classes_merged";

    /* renamed from: i */
    public static final String f19549i = "/data/app/";

    /* renamed from: j */
    public static final String f19550j = "/data/user/0";

    /* renamed from: k */
    public static final String f19551k = "/Android/data";

    /* renamed from: l */
    public static final String f19552l = "/Android/media";

    /* renamed from: m */
    public static final String f19553m = "/Android/obb";

    /* renamed from: n */
    public static final String f19554n = "/Android/cache";

    /* renamed from: o */
    public static final String f19555o = "абвгдеёжзийклмнопрстуфхцчшщьыъэюя";

    /* renamed from: p */
    public static final String f19556p = "abcdefghijklmnopqrstuvwxyz";

    /* renamed from: a */
    public static final byte[] f19541a = {(byte) 48, (byte) Float.MIN_EXPONENT, (byte) 2, (byte) 126, (byte) 48, (byte) Float.MIN_EXPONENT, (byte) 1, (byte) (-25), (byte) (-96), (byte) 3, (byte) 2, (byte) 1, (byte) 2, (byte) 2, (byte) 1, (byte) 1, (byte) 48, (byte) 13, (byte) 6, (byte) 9, (byte) 42, (byte) (-122), (byte) 72, (byte) (-122), (byte) (-9), (byte) 13, (byte) 1, (byte) 1, (byte) 11, (byte) 5, (byte) 0, (byte) 48, (byte) AdvertisingSetParameters.TX_POWER_MIN, (byte) (-125), (byte) 49, (byte) 11, (byte) 48, (byte) 9, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 6, (byte) 19, (byte) 2, (byte) 82, (byte) 85, (byte) 49, (byte) 42, (byte) 48, (byte) 40, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 8, (byte) 12, (byte) 33, (byte) (-48), (byte) (-97), (byte) (-47), (byte) AdvertisingSetParameters.TX_POWER_MIN, (byte) (-48), (byte) (-70), (byte) (-48), (byte) (-66), (byte) (-48), (byte) (-78), (byte) (-47), (byte) AdvertisingSetParameters.TX_POWER_MIN, (byte) (-48), (byte) (-70), (byte) (-48), (byte) (-80), (byte) (-47), (byte) (-113), (byte) 32, (byte) (-48), (byte) (-66), (byte) (-48), (byte) (-79), (byte) (-48), (byte) (-69), (byte) (-48), (byte) (-80), (byte) (-47), (byte) AdvertisingSetParameters.TX_POWER_MIN, (byte) (-47), (byte) Float.MIN_EXPONENT, (byte) (-47), (byte) (-116), (byte) 49, (byte) 32, (byte) 48, (byte) 30, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 7, (byte) 12, (byte) 23, (byte) (-48), (byte) MediaPlayer.MEDIA_ERROR_TIMED_OUT, (byte) (-48), (byte) (-75), (byte) (-48), (byte) (-69), (byte) (-48), (byte) (-72), (byte) (-48), (byte) (-70), (byte) (-48), (byte) (-72), (byte) (-48), (byte) (-75), (byte) 32, (byte) (-48), (byte) (-101), (byte) (-47), (byte) (-125), (byte) (-48), (byte) (-70), (byte) (-48), (byte) (-72), (byte) 49, (byte) 38, (byte) 48, (byte) 36, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 3, (byte) 12, (byte) 29, (byte) (-48), (byte) (-112), (byte) (-48), (byte) (-67), (byte) (-48), (byte) (-76), (byte) (-47), (byte) (-128), (byte) (-48), (byte) (-75), (byte) (-48), (byte) (-71), (byte) 32, (byte) (-48), (byte) (-100), (byte) (-48), (byte) (-80), (byte) (-48), (byte) (-70), (byte) (-47), (byte) AdvertisingSetParameters.TX_POWER_MIN, (byte) (-48), (byte) (-72), (byte) (-48), (byte) (-68), (byte) (-48), (byte) (-66), (byte) (-48), (byte) (-78), (byte) 48, (byte) 32, (byte) 23, (byte) 13, (byte) 49, (byte) 56, (byte) 48, (byte) 55, (byte) 48, (byte) 49, (byte) 49, (byte) 48, (byte) 49, (byte) 51, (byte) 48, (byte) 51, (byte) 90, (byte) 24, (byte) 15, (byte) 50, (byte) 49, (byte) 49, (byte) 56, (byte) 48, (byte) 54, (byte) 48, (byte) 55, (byte) 49, (byte) 48, (byte) 49, (byte) 51, (byte) 48, (byte) 51, (byte) 90, (byte) 48, (byte) AdvertisingSetParameters.TX_POWER_MIN, (byte) (-125), (byte) 49, (byte) 11, (byte) 48, (byte) 9, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 6, (byte) 19, (byte) 2, (byte) 82, (byte) 85, (byte) 49, (byte) 42, (byte) 48, (byte) 40, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 8, (byte) 12, (byte) 33, (byte) (-48), (byte) (-97), (byte) (-47), (byte) AdvertisingSetParameters.TX_POWER_MIN, (byte) (-48), (byte) (-70), (byte) (-48), (byte) (-66), (byte) (-48), (byte) (-78), (byte) (-47), (byte) AdvertisingSetParameters.TX_POWER_MIN, (byte) (-48), (byte) (-70), (byte) (-48), (byte) (-80), (byte) (-47), (byte) (-113), (byte) 32, (byte) (-48), (byte) (-66), (byte) (-48), (byte) (-79), (byte) (-48), (byte) (-69), (byte) (-48), (byte) (-80), (byte) (-47), (byte) AdvertisingSetParameters.TX_POWER_MIN, (byte) (-47), (byte) Float.MIN_EXPONENT, (byte) (-47), (byte) (-116), (byte) 49, (byte) 32, (byte) 48, (byte) 30, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 7, (byte) 12, (byte) 23, (byte) (-48), (byte) MediaPlayer.MEDIA_ERROR_TIMED_OUT, (byte) (-48), (byte) (-75), (byte) (-48), (byte) (-69), (byte) (-48), (byte) (-72), (byte) (-48), (byte) (-70), (byte) (-48), (byte) (-72), (byte) (-48), (byte) (-75), (byte) 32, (byte) (-48), (byte) (-101), (byte) (-47), (byte) (-125), (byte) (-48), (byte) (-70), (byte) (-48), (byte) (-72), (byte) 49, (byte) 38, (byte) 48, (byte) 36, (byte) 6, (byte) 3, (byte) 85, (byte) 4, (byte) 3, (byte) 12, (byte) 29, (byte) (-48), (byte) (-112), (byte) (-48), (byte) (-67), (byte) (-48), (byte) (-76), (byte) (-47), (byte) (-128), (byte) (-48), (byte) (-75), (byte) (-48), (byte) (-71), (byte) 32, (byte) (-48), (byte) (-100), (byte) (-48), (byte) (-80), (byte) (-48), (byte) (-70), (byte) (-47), (byte) AdvertisingSetParameters.TX_POWER_MIN, (byte) (-48), (byte) (-72), (byte) (-48), (byte) (-68), (byte) (-48), (byte) (-66), (byte) (-48), (byte) (-78), (byte) 48, (byte) AdvertisingSetParameters.TX_POWER_MIN, (byte) (-97), (byte) 48, (byte) 13, (byte) 6, (byte) 9, (byte) 42, (byte) (-122), (byte) 72, (byte) (-122), (byte) (-9), (byte) 13, (byte) 1, (byte) 1, (byte) 1, (byte) 5, (byte) 0, (byte) 3, (byte) AdvertisingSetParameters.TX_POWER_MIN, (byte) (-115), (byte) 0, (byte) 48, (byte) AdvertisingSetParameters.TX_POWER_MIN, (byte) (-119), (byte) 2, (byte) AdvertisingSetParameters.TX_POWER_MIN, (byte) AdvertisingSetParameters.TX_POWER_MIN, (byte) 0, (byte) (-52), (byte) (-101), (byte) 65, (byte) (-39), (byte) (-115), (byte) (-44), (byte) 88, (byte) 55, (byte) 19, (byte) 5, (byte) 80, (byte) (-9), (byte) (-86), (byte) 102, (byte) (-58), (byte) 10, (byte) (-48), (byte) 126, (byte) (-91), (byte) 125, (byte) (-115), (byte) (-36), (byte) 72, (byte) (-95), (byte) (-27), (byte) (-20), (byte) 105, (byte) (-16), (byte) (-40), (byte) (-11), (byte) Float.MIN_EXPONENT, (byte) (-16), (byte) 95, (byte) (-52), (byte) (-84), (byte) 65, (byte) (-51), (byte) 89, (byte) (-2), (byte) 59, (byte) 65, (byte) (-35), (byte) 81, (byte) (-83), (byte) (-106), (byte) (-49), (byte) 66, (byte) (-57), (byte) (-115), (byte) (-72), (byte) 30, (byte) 100, (byte) 59, (byte) 47, (byte) 28, (byte) (-123), (byte) (-94), (byte) (-68), (byte) (-91), (byte) 39, (byte) 10, (byte) 119, (byte) (-81), (byte) (-86), (byte) 108, (byte) 105, (byte) 53, (byte) (-97), (byte) 34, (byte) (-112), (byte) (-83), (byte) 42, (byte) (-37), (byte) 54, (byte) (-84), (byte) (-72), (byte) (-106), (byte) 42, (byte) 38, (byte) 102, (byte) (-75), (byte) (-4), (byte) 76, (byte) 35, (byte) 2, (byte) 31, (byte) (-32), (byte) (-114), (byte) 78, (byte) 78, (byte) (-10), (byte) 100, (byte) 36, (byte) 87, (byte) (-54), (byte) 45, (byte) 44, (byte) (-111), (byte) (-73), (byte) (-87), (byte) 113, (byte) 124, (byte) (-19), (byte) 28, (byte) 116, (byte) (-43), (byte) (-78), (byte) 95, (byte) (-16), (byte) (-57), (byte) 96, (byte) (-36), (byte) 62, (byte) 63, (byte) 56, (byte) (-51), (byte) (-57), (byte) (-25), (byte) (-70), (byte) 125, (byte) 67, (byte) (-103), (byte) (-92), (byte) 82, (byte) (-49), (byte) 16, (byte) 50, (byte) (-107), (byte) 2, (byte) 3, (byte) 1, (byte) 0, (byte) 1, (byte) 48, (byte) 13, (byte) 6, (byte) 9, (byte) 42, (byte) (-122), (byte) 72, (byte) (-122), (byte) (-9), (byte) 13, (byte) 1, (byte) 1, (byte) 11, (byte) 5, (byte) 0, (byte) 3, (byte) AdvertisingSetParameters.TX_POWER_MIN, (byte) AdvertisingSetParameters.TX_POWER_MIN, (byte) 0, (byte) (-115), (byte) (-58), (byte) 60, (byte) 3, (byte) 66, (byte) (-76), (byte) 85, (byte) 55, (byte) 60, (byte) 64, (byte) (-2), (byte) 5, (byte) (-42), (byte) 57, (byte) 15, (byte) (-123), (byte) 20, (byte) 105, (byte) 90, (byte) 102, (byte) (-1), (byte) (-16), (byte) 65, (byte) (-69), (byte) (-80), (byte) (-128), (byte) 17, (byte) 125, (byte) (-88), (byte) (-65), (byte) (-17), (byte) (-18), (byte) (-4), (byte) (-113), (byte) 34, (byte) (-85), (byte) 104, (byte) (-43), (byte) 80, (byte) AdvertisingSetParameters.TX_POWER_MIN, (byte) 61, (byte) 51, (byte) (-38), (byte) 19, (byte) (-33), (byte) (-70), (byte) 123, (byte) (-49), (byte) (-106), (byte) (-78), (byte) 90, (byte) (-30), (byte) (-46), (byte) 54, (byte) 116, (byte) 0, (byte) 51, (byte) 93, (byte) (-12), (byte) (-22), (byte) 49, (byte) (-82), (byte) 64, (byte) 88, (byte) 111, (byte) 8, (byte) (-122), (byte) 53, (byte) (-41), (byte) (-66), (byte) (-52), (byte) (-62), (byte) 28, (byte) 4, (byte) 15, (byte) (-85), (byte) 23, (byte) (-18), (byte) 11, (byte) 60, (byte) 32, (byte) (-100), (byte) 32, (byte) (-125), (byte) 101, (byte) 2, (byte) (-128), (byte) 68, (byte) 117, (byte) 51, (byte) (-56), (byte) 11, (byte) (-37), (byte) 93, (byte) 126, (byte) (-36), (byte) 71, (byte) (-14), (byte) (-7), (byte) (-81), (byte) 33, (byte) 123, (byte) (-59), (byte) 6, (byte) (-72), (byte) 105, (byte) 76, (byte) 113, (byte) 110, (byte) 52, (byte) (-39), (byte) 78, (byte) (-49), (byte) 98, (byte) 36, (byte) 73, (byte) (-16), (byte) 12, (byte) (-6), (byte) (-29), (byte) (-3), (byte) 123, (byte) (-16), (byte) 46, (byte) 116, (byte) 82, (byte) (-87), (byte) 60};

    /* renamed from: b */
    public static final String[] f19542b = {"\t", "/", "\\", ";", ":", "{", "}", "(", ")", "[", "]", "<", ">", "=", "\"", "'", "^", "+", "-", "_", "*", ",", ".", "|", "@", "#", "%", "&", "!", "?"};

    /* renamed from: c */
    public static final String[] f19543c = {"a", "b", DateFormat.SECOND, "i", "u", "big", "small", "cite", "dfn", "em", "strike", "del", "sup", Telephony.BaseMmsColumns.SUBJECT, "tt", "ul", "li", "br", "div", "font", "span", "p", "gradient"};

    /* renamed from: d */
    public static final String[] f19544d = {Context.ACTIVITY_SERVICE, "activity-alias", "provider", "receiver", Notification.CATEGORY_SERVICE};

    /* renamed from: e */
    public static final String[] f19545e = {"android.", "androidx.", "com.android.", "oppo.permission.", "com.sec.android.", "com.htc.", "com.sonyericsson.", "com.sonymobile.", "com.huawei."};

    /* renamed from: f */
    public static final String[] f19546f = {"txt", XMLConstants.XML_NS_PREFIX, "svg", "conf", "prop", "cpp", "h", "java", "log", "json", "js", "php", "css", "py", "c", "smali", "cfg", "ini", "bat", "md", "mf", "sf", "amd", "mtd", "lua", "htm", "html", "xhtml", "kt", "sh", "properties", "gradle", "patch", "dart", "yml", TextClassifier.TYPE_URL};

    /* renamed from: h */
    public static final String[] f19548h = {"assets/dexopt/*", "lib/*.so", "res/raw*", "resources.arsc", "*.png", "*.jpg", "*.jpeg", "*.gif", "*.webp"};

    /* renamed from: q */
    public static final byte[] f19557q = {(byte) (-119), (byte) 80, (byte) 78, (byte) 71};

    /* renamed from: r */
    public static final byte[] f19558r = {(byte) 82, (byte) 73, (byte) 70, (byte) 70};

    /* renamed from: s */
    public static final byte[] f19559s = {(byte) (-1), (byte) (-40), (byte) (-1), (byte) (-31)};

    /* renamed from: t */
    public static final byte[] f19560t = {(byte) (-1), (byte) (-40), (byte) (-1), (byte) (-32)};

    /* renamed from: u */
    public static final byte[] f19561u = {(byte) (-1), (byte) (-40), (byte) (-1), (byte) (-37)};

    /* renamed from: v */
    public static final byte[] f19562v = {(byte) 71, (byte) 73, (byte) 70, (byte) 56};

    /* renamed from: w */
    public static final byte[] f19563w = {(byte) 80, (byte) 75, (byte) 3, (byte) 4};

    /* renamed from: x */
    public static final byte[] f19564x = {(byte) 80, (byte) 75, (byte) 5, (byte) 6};

    /* renamed from: y */
    public static final byte[] f19565y = {(byte) 80, (byte) 75, (byte) 7, (byte) 8};

    /* renamed from: z */
    public static final byte[] f19566z = {(byte) 127, (byte) 69, (byte) 76, (byte) 70};

    /* renamed from: A */
    public static final byte[] f19535A = {(byte) 3, (byte) 0, (byte) 8, (byte) 0};

    /* renamed from: B */
    public static final byte[] f19536B = {(byte) 100, (byte) 101, (byte) 120, (byte) 10};

    /* renamed from: C */
    public static final byte[] f19537C = {(byte) 100, (byte) 101, (byte) 120, (byte) 10, (byte) 48, (byte) 51, (byte) 53, (byte) 0};

    /* renamed from: D */
    public static final byte[] f19538D = {(byte) 100, (byte) 101, (byte) 120, (byte) 10, (byte) 48, (byte) 51, (byte) 55, (byte) 0};

    /* renamed from: E */
    public static final byte[] f19539E = {(byte) 100, (byte) 101, (byte) 120, (byte) 10, (byte) 48, (byte) 51, (byte) 56, (byte) 0};

    /* renamed from: F */
    public static final byte[] f19540F = {(byte) 100, (byte) 101, (byte) 120, (byte) 10, (byte) 48, (byte) 51, (byte) 57, (byte) 0};

    /* renamed from: a */
    public static int m19500a() {
        return C3102bd.f18295ac * 1024;
    }

    /* renamed from: b */
    public static String[] m19501b() {
        return C3080al.m18573a(f19546f, C3102bd.f18290Z);
    }
}
