package ru.maximoff.apktool.util;

import android.app.Notification;
import android.app.slice.SliceItem;
import android.content.Context;
import android.hardware.Camera;
import android.media.MediaCodec;
import android.p008os.Build;
import android.provider.MediaStore;
import android.provider.Telephony;
import android.provider.UserDictionary;
import java.util.ArrayList;

/* compiled from: AttributeValues.java */
/* renamed from: ru.maximoff.apktool.util.b */
/* loaded from: classes.dex */
public class C3095b {
    /* renamed from: a */
    public static String m18792a(int i) {
        switch (i) {
            case -1:
                return "unspecified";
            case 0:
                return Camera.Parameters.SCENE_MODE_LANDSCAPE;
            case 1:
                return Camera.Parameters.SCENE_MODE_PORTRAIT;
            case 2:
                return "user";
            case 3:
                return "behind";
            case 4:
                return Context.SENSOR_SERVICE;
            case 5:
                return "nosensor";
            case 6:
                return "sensorLandscape";
            case 7:
                return "sensorPortrait";
            case 8:
                return "reverseLandscape";
            case 9:
                return "reversePortrait";
            case 10:
                return "fullSensor";
            case 11:
                return "userLandscape";
            case 12:
                return "userPortrait";
            case 13:
                return "fullUser";
            case 14:
                return "locked";
            default:
                return String.format("0x%08X", new Integer(i));
        }
    }

    /* renamed from: b */
    public static String m18793b(int i) {
        switch (i) {
            case 0:
                return "standard";
            case 1:
                return "singleTop";
            case 2:
                return "singleTask";
            case 3:
                return "singleInstance";
            default:
                return String.format("0x%08X", new Integer(i));
        }
    }

    /* renamed from: c */
    public static String m18794c(int i) {
        ArrayList arrayList = new ArrayList();
        if ((i & 4096) != 0) {
            arrayList.add("density");
        }
        if ((1073741824 & i) != 0) {
            arrayList.add("fontScale");
        }
        if ((i & 16) != 0) {
            arrayList.add("keyboard");
        }
        if ((i & 32) != 0) {
            arrayList.add("keyboardHidden");
        }
        if ((i & 8192) != 0) {
            arrayList.add("layoutDirection");
        }
        if ((i & 4) != 0) {
            arrayList.add(UserDictionary.Words.LOCALE);
        }
        if ((i & 1) != 0) {
            arrayList.add(Telephony.Carriers.MCC);
        }
        if ((i & 2) != 0) {
            arrayList.add(Telephony.Carriers.MNC);
        }
        if ((i & 64) != 0) {
            arrayList.add(Notification.CATEGORY_NAVIGATION);
        }
        if ((i & 128) != 0) {
            arrayList.add(MediaStore.MediaColumns.ORIENTATION);
        }
        if ((i & 256) != 0) {
            arrayList.add("screenLayout");
        }
        if ((i & 1024) != 0) {
            arrayList.add("screenSize");
        }
        if ((i & 2048) != 0) {
            arrayList.add("smallestScreenSize");
        }
        if ((i & 8) != 0) {
            arrayList.add("touchscreen");
        }
        if ((i & 512) != 0) {
            arrayList.add("uiMode");
        }
        return C3080al.m18538a(arrayList, "|");
    }

    /* renamed from: d */
    public static String m18795d(int i) {
        int i2 = i & 240;
        int i3 = i & 15;
        ArrayList arrayList = new ArrayList(2);
        switch (i2) {
            case 0:
                break;
            case 16:
                arrayList.add("adjustResize");
                break;
            case 32:
                arrayList.add("adjustPan");
                break;
            case 48:
                arrayList.add("adjustNothing");
                break;
            default:
                arrayList.add(String.format("0x%08X", new Integer(i2)));
                break;
        }
        switch (i3) {
            case 0:
                break;
            case 1:
                arrayList.add("stateUnchanged");
                break;
            case 2:
                arrayList.add("stateHidden");
                break;
            case 3:
                arrayList.add("stateAlwaysHidden");
                break;
            case 4:
                arrayList.add("stateVisible");
                break;
            case 5:
                arrayList.add("stateAlwaysVisible");
                break;
            default:
                arrayList.add(String.format("0x%08X", new Integer(i3)));
                break;
        }
        return C3080al.m18538a(arrayList, "|");
    }

    /* renamed from: e */
    public static String m18796e(int i) {
        int i2;
        ArrayList arrayList = new ArrayList(3);
        if ((i & 16) != 0) {
            i2 = i ^ 16;
            arrayList.add(Build.Partition.PARTITION_NAME_SYSTEM);
        } else {
            i2 = i;
        }
        if ((i2 & 32) != 0) {
            i2 ^= 32;
            arrayList.add("development");
        }
        switch (i2) {
            case 0:
                arrayList.add("normal");
                break;
            case 1:
                arrayList.add("dangerous");
                break;
            case 2:
                arrayList.add("signature");
                break;
            case 3:
                arrayList.add("signatureOrSystem");
                break;
            default:
                arrayList.add(String.format("0x%08X", new Integer(i2)));
                break;
        }
        return C3080al.m18538a(arrayList, "|");
    }

    /* renamed from: f */
    public static String m18797f(int i) {
        switch (i) {
            case 0:
                return "auto";
            case 1:
                return "internalOnly";
            case 2:
                return "preferExternal";
            default:
                return String.format("0x%08X", new Integer(i));
        }
    }

    /* renamed from: g */
    public static String m18798g(int i) {
        switch (i) {
            case 0:
                return "game";
            case 1:
                return "audio";
            case 2:
                return MediaCodec.MetricsConstants.MODE_VIDEO;
            case 3:
                return SliceItem.FORMAT_IMAGE;
            case 4:
                return Notification.CATEGORY_SOCIAL;
            case 5:
                return "news";
            case 6:
                return "maps";
            case 7:
                return "productivity";
            case 8:
                return Context.ACCESSIBILITY_SERVICE;
            default:
                return String.format("0x%08X", new Integer(i));
        }
    }

    /* renamed from: h */
    public static String m18799h(int i) {
        switch (i) {
            case 1:
                return "dataSync";
            case 2:
                return "mediaPlayback";
            case 4:
                return "phoneCall";
            case 8:
                return "location";
            case 16:
                return "connectedDevice";
            case 32:
                return "mediaProjection";
            case 64:
                return Context.CAMERA_SERVICE;
            case 128:
                return "microphone";
            default:
                return String.format("0x%08X", new Integer(i));
        }
    }

    /* renamed from: i */
    public static String m18800i(int i) {
        switch (i) {
            case -1:
                return "default";
            case 0:
                return "never";
            case 1:
                return "always";
            default:
                return String.format("0x%08X", new Integer(i));
        }
    }

    /* renamed from: j */
    public static String m18801j(int i) {
        switch (i) {
            case 0:
                return Camera.Parameters.EFFECT_NONE;
            case 1:
                return "splitActionBarWhenNarrow";
            default:
                return String.format("0x%08X", new Integer(i));
        }
    }

    /* renamed from: k */
    public static String m18802k(int i) {
        switch (i) {
            case 0:
                return "allowed";
            case 1:
                return "discouraged";
            case 2:
                return "disallowed";
            default:
                return String.format("0x%08X", new Integer(i));
        }
    }

    /* renamed from: l */
    public static String m18803l(int i) {
        switch (i) {
            case 32:
                return "enabled";
            case 64:
                return "disabled";
            default:
                return String.format("0x%08X", new Integer(i));
        }
    }

    /* renamed from: m */
    public static String m18804m(int i) {
        switch (i) {
            case 1:
                return Camera.Parameters.EFFECT_NONE;
            case 2:
                return "enforceIntentFilter";
            case 3:
            default:
                return String.format("0x%08X", new Integer(i));
            case 4:
                return "allowNullAction";
        }
    }

    /* renamed from: n */
    public static String m18805n(int i) {
        switch (i) {
            case -1:
                return "default";
            case 0:
                return "off";
            case 1:
                return "async";
            case 2:
                return "sync";
            default:
                return String.valueOf(i);
        }
    }
}
