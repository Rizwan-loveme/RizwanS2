package ru.maximoff.apktool.util;

import android.graphics.Bitmap;
import android.icu.text.DateFormat;
import android.p008os.BatteryManager;
import java.lang.reflect.Array;
import java.nio.IntBuffer;
import java.p209io.BufferedWriter;
import java.p209io.File;
import java.p209io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: ImageTracerAndroid.java */
/* renamed from: ru.maximoff.apktool.util.ae */
/* loaded from: classes.dex */
public class C3073ae {

    /* renamed from: a */
    public static String f17336a = "1.1.2";

    /* renamed from: b */
    static byte[] f17337b = {(byte) 0, (byte) 0, (byte) 3, (byte) 0, (byte) 1, (byte) 0, (byte) 3, (byte) 0, (byte) 0, (byte) 3, (byte) 3, (byte) 1, (byte) 0, (byte) 3, (byte) 0, (byte) 0};

    /* renamed from: c */
    static boolean[] f17338c = {false, false, false, false, false, false, false, true, false, false, false, true, false, true, true, false};

    /* renamed from: d */
    static byte[][][] f17339d = {new byte[][]{new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}, new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}, new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}, new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}}, new byte[][]{new byte[]{(byte) 0, (byte) 1, (byte) 0, (byte) (-1)}, new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}, new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}, new byte[]{(byte) 0, (byte) 2, (byte) (-1), (byte) 0}}, new byte[][]{new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}, new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}, new byte[]{(byte) 0, (byte) 1, (byte) 0, (byte) (-1)}, new byte[]{(byte) 0, (byte) 0, (byte) 1, (byte) 0}}, new byte[][]{new byte[]{(byte) 0, (byte) 0, (byte) 1, (byte) 0}, new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}, new byte[]{(byte) 0, (byte) 2, (byte) (-1), (byte) 0}, new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}}, new byte[][]{new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}, new byte[]{(byte) 0, (byte) 0, (byte) 1, (byte) 0}, new byte[]{(byte) 0, (byte) 3, (byte) 0, (byte) 1}, new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}}, new byte[][]{new byte[]{(byte) 13, (byte) 3, (byte) 0, (byte) 1}, new byte[]{(byte) 13, (byte) 2, (byte) (-1), (byte) 0}, new byte[]{(byte) 7, (byte) 1, (byte) 0, (byte) (-1)}, new byte[]{(byte) 7, (byte) 0, (byte) 1, (byte) 0}}, new byte[][]{new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}, new byte[]{(byte) 0, (byte) 1, (byte) 0, (byte) (-1)}, new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}, new byte[]{(byte) 0, (byte) 3, (byte) 0, (byte) 1}}, new byte[][]{new byte[]{(byte) 0, (byte) 3, (byte) 0, (byte) 1}, new byte[]{(byte) 0, (byte) 2, (byte) (-1), (byte) 0}, new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}, new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}}, new byte[][]{new byte[]{(byte) 0, (byte) 3, (byte) 0, (byte) 1}, new byte[]{(byte) 0, (byte) 2, (byte) (-1), (byte) 0}, new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}, new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}}, new byte[][]{new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}, new byte[]{(byte) 0, (byte) 1, (byte) 0, (byte) (-1)}, new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}, new byte[]{(byte) 0, (byte) 3, (byte) 0, (byte) 1}}, new byte[][]{new byte[]{(byte) 11, (byte) 1, (byte) 0, (byte) (-1)}, new byte[]{(byte) 14, (byte) 0, (byte) 1, (byte) 0}, new byte[]{(byte) 14, (byte) 3, (byte) 0, (byte) 1}, new byte[]{(byte) 11, (byte) 2, (byte) (-1), (byte) 0}}, new byte[][]{new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}, new byte[]{(byte) 0, (byte) 0, (byte) 1, (byte) 0}, new byte[]{(byte) 0, (byte) 3, (byte) 0, (byte) 1}, new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}}, new byte[][]{new byte[]{(byte) 0, (byte) 0, (byte) 1, (byte) 0}, new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}, new byte[]{(byte) 0, (byte) 2, (byte) (-1), (byte) 0}, new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}}, new byte[][]{new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}, new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}, new byte[]{(byte) 0, (byte) 1, (byte) 0, (byte) (-1)}, new byte[]{(byte) 0, (byte) 0, (byte) 1, (byte) 0}}, new byte[][]{new byte[]{(byte) 0, (byte) 1, (byte) 0, (byte) (-1)}, new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}, new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}, new byte[]{(byte) 0, (byte) 2, (byte) (-1), (byte) 0}}, new byte[][]{new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}, new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}, new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}, new byte[]{(byte) (-1), (byte) (-1), (byte) (-1), (byte) (-1)}}};

    /* renamed from: e */
    static double[][] f17340e = {new double[]{0.27901d, 0.44198d, 0.27901d}, new double[]{0.135336d, 0.228569d, 0.272192d, 0.228569d, 0.135336d}, new double[]{0.086776d, 0.136394d, 0.178908d, 0.195843d, 0.178908d, 0.136394d, 0.086776d}, new double[]{0.063327d, 0.093095d, 0.122589d, 0.144599d, 0.152781d, 0.144599d, 0.122589d, 0.093095d, 0.063327d}, new double[]{0.049692d, 0.069304d, 0.089767d, 0.107988d, 0.120651d, 0.125194d, 0.120651d, 0.107988d, 0.089767d, 0.069304d, 0.049692d}};

    /* compiled from: ImageTracerAndroid.java */
    /* renamed from: ru.maximoff.apktool.util.ae$b */
    public static class b {

        /* renamed from: a */
        public int f17344a;

        /* renamed from: b */
        public int f17345b;

        /* renamed from: c */
        public int[][] f17346c;

        /* renamed from: d */
        public byte[][] f17347d;

        /* renamed from: e */
        public ArrayList<ArrayList<ArrayList<Double[]>>> f17348e;

        public b(int[][] iArr, byte[][] bArr) {
            this.f17346c = iArr;
            this.f17347d = bArr;
            this.f17344a = iArr[0].length - 2;
            this.f17345b = iArr.length - 2;
        }
    }

    /* compiled from: ImageTracerAndroid.java */
    /* renamed from: ru.maximoff.apktool.util.ae$a */
    public static class a {

        /* renamed from: a */
        public int f17341a;

        /* renamed from: b */
        public int f17342b;

        /* renamed from: c */
        public byte[] f17343c;

        public a(int i, int i2, byte[] bArr) {
            this.f17341a = i;
            this.f17342b = i2;
            this.f17343c = bArr;
        }
    }

    /* renamed from: a */
    public static void m18453a(String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
        bufferedWriter.write(str2);
        bufferedWriter.close();
    }

    /* renamed from: a */
    public static a m18448a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        IntBuffer allocate = IntBuffer.allocate(width * height);
        bitmap.copyPixelsToBuffer(allocate);
        int[] array = allocate.array();
        byte[] bArr = new byte[array.length * 4];
        for (int i = 0; i < array.length; i++) {
            bArr[(i * 4) + 3] = m18433a((byte) (array[i] >>> 24));
            bArr[(i * 4) + 2] = m18433a((byte) (array[i] >>> 16));
            bArr[(i * 4) + 1] = m18433a((byte) (array[i] >>> 8));
            bArr[i * 4] = m18433a((byte) array[i]);
        }
        return new a(width, height, bArr);
    }

    /* renamed from: a */
    public static byte m18433a(byte b2) {
        return b2 < 0 ? (byte) (b2 + 128) : (byte) (b2 - 128);
    }

    /* renamed from: a */
    public static List<C3115bq> m18445a(Bitmap bitmap, HashMap<String, Float> hashMap, byte[][] bArr) {
        return m18446a(m18448a(bitmap), m18444a(hashMap), bArr);
    }

    /* renamed from: a */
    public static List<C3115bq> m18446a(a aVar, HashMap<String, Float> hashMap, byte[][] bArr) {
        HashMap<String, Float> m18444a = m18444a(hashMap);
        return m18447a(m18461b(aVar, m18444a, bArr), m18444a);
    }

    /* renamed from: a */
    public static void m18451a(Bitmap bitmap, HashMap<String, Float> hashMap, byte[][] bArr, File file) {
        m18454a(m18448a(bitmap), m18444a(hashMap), bArr, file);
    }

    /* renamed from: a */
    public static void m18454a(a aVar, HashMap<String, Float> hashMap, byte[][] bArr, File file) {
        HashMap<String, Float> m18444a = m18444a(hashMap);
        m18452a(file, m18461b(aVar, m18444a, bArr), m18444a);
    }

    /* renamed from: b */
    public static b m18461b(a aVar, HashMap<String, Float> hashMap, byte[][] bArr) {
        b m18450a = m18450a(aVar, bArr, hashMap);
        m18450a.f17348e = m18462c(m18459b(m18443a(m18457a(m18450a), (int) Math.floor(hashMap.get("pathomit").floatValue()))), hashMap.get("ltres").floatValue(), hashMap.get("qtres").floatValue());
        return m18450a;
    }

    /* renamed from: a */
    public static HashMap<String, Float> m18444a(HashMap<String, Float> hashMap) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        if (!hashMap.containsKey("ltres")) {
            hashMap.put("ltres", new Float(1.0f));
        }
        if (!hashMap.containsKey("qtres")) {
            hashMap.put("qtres", new Float(1.0f));
        }
        if (!hashMap.containsKey("pathomit")) {
            hashMap.put("pathomit", new Float(8.0f));
        }
        if (!hashMap.containsKey("colorsampling")) {
            hashMap.put("colorsampling", new Float(1.0f));
        }
        if (!hashMap.containsKey("numberofcolors")) {
            hashMap.put("numberofcolors", new Float(16.0f));
        }
        if (!hashMap.containsKey("mincolorratio")) {
            hashMap.put("mincolorratio", new Float(0.02f));
        }
        if (!hashMap.containsKey("colorquantcycles")) {
            hashMap.put("colorquantcycles", new Float(3.0f));
        }
        if (!hashMap.containsKey(BatteryManager.EXTRA_SCALE)) {
            hashMap.put(BatteryManager.EXTRA_SCALE, new Float(1.0f));
        }
        if (!hashMap.containsKey("simplifytolerance")) {
            hashMap.put("simplifytolerance", new Float(0.0f));
        }
        if (!hashMap.containsKey("roundcoords")) {
            hashMap.put("roundcoords", new Float(1.0f));
        }
        if (!hashMap.containsKey("lcpr")) {
            hashMap.put("lcpr", new Float(0.0f));
        }
        if (!hashMap.containsKey("qcpr")) {
            hashMap.put("qcpr", new Float(0.0f));
        }
        if (!hashMap.containsKey("desc")) {
            hashMap.put("desc", new Float(1.0f));
        }
        if (!hashMap.containsKey("viewbox")) {
            hashMap.put("viewbox", new Float(0.0f));
        }
        if (!hashMap.containsKey("blurradius")) {
            hashMap.put("blurradius", new Float(0.0f));
        }
        if (!hashMap.containsKey("blurdelta")) {
            hashMap.put("blurdelta", new Float(20.0f));
        }
        return hashMap;
    }

    /* renamed from: a */
    public static b m18450a(a aVar, byte[][] bArr, HashMap<String, Float> hashMap) {
        int floor = (int) Math.floor(hashMap.get("numberofcolors").floatValue());
        float floatValue = hashMap.get("mincolorratio").floatValue();
        int floor2 = (int) Math.floor(hashMap.get("colorquantcycles").floatValue());
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, aVar.f17342b + 2, aVar.f17341a + 2);
        for (int i = 0; i < aVar.f17342b + 2; i++) {
            iArr[i][0] = -1;
            iArr[i][aVar.f17341a + 1] = -1;
        }
        for (int i2 = 0; i2 < aVar.f17341a + 2; i2++) {
            iArr[0][i2] = -1;
            iArr[aVar.f17342b + 1][i2] = -1;
        }
        if (bArr == null) {
            if (hashMap.get("colorsampling").floatValue() != 0) {
                bArr = m18456a(floor, aVar);
            } else {
                bArr = m18455a(floor);
            }
        }
        if (hashMap.get("blurradius").floatValue() > 0) {
            aVar = m18449a(aVar, hashMap.get("blurradius").floatValue(), hashMap.get("blurdelta").floatValue());
        }
        long[][] jArr = (long[][]) Array.newInstance(Long.TYPE, bArr.length, 5);
        for (int i3 = 0; i3 < floor2; i3++) {
            if (i3 > 0) {
                for (int i4 = 0; i4 < bArr.length; i4++) {
                    if (jArr[i4][3] > 0) {
                        bArr[i4][0] = (byte) ((-128) + (jArr[i4][0] / jArr[i4][4]));
                        bArr[i4][1] = (byte) ((-128) + (jArr[i4][1] / jArr[i4][4]));
                        bArr[i4][2] = (byte) ((-128) + (jArr[i4][2] / jArr[i4][4]));
                        bArr[i4][3] = (byte) ((-128) + (jArr[i4][3] / jArr[i4][4]));
                    }
                    if (((float) (jArr[i4][4] / (aVar.f17341a * aVar.f17342b))) < floatValue && i3 < floor2 - 1) {
                        bArr[i4][0] = (byte) ((-128) + Math.floor(Math.random() * 255));
                        bArr[i4][1] = (byte) ((-128) + Math.floor(Math.random() * 255));
                        bArr[i4][2] = (byte) ((-128) + Math.floor(Math.random() * 255));
                        bArr[i4][3] = (byte) ((-128) + Math.floor(Math.random() * 255));
                    }
                }
            }
            for (int i5 = 0; i5 < bArr.length; i5++) {
                jArr[i5][0] = 0;
                jArr[i5][1] = 0;
                jArr[i5][2] = 0;
                jArr[i5][3] = 0;
                jArr[i5][4] = 0;
            }
            for (int i6 = 0; i6 < aVar.f17342b; i6++) {
                for (int i7 = 0; i7 < aVar.f17341a; i7++) {
                    int i8 = ((aVar.f17341a * i6) + i7) * 4;
                    int i9 = 1024;
                    int i10 = 0;
                    for (int i11 = 0; i11 < bArr.length; i11++) {
                        int abs = Math.abs(bArr[i11][0] - aVar.f17343c[i8]) + Math.abs(bArr[i11][1] - aVar.f17343c[i8 + 1]) + Math.abs(bArr[i11][2] - aVar.f17343c[i8 + 2]) + (Math.abs(bArr[i11][3] - aVar.f17343c[i8 + 3]) * 4);
                        if (abs < i9) {
                            i10 = i11;
                            i9 = abs;
                        }
                    }
                    long[] jArr2 = jArr[i10];
                    jArr2[0] = jArr2[0] + aVar.f17343c[i8] + 128;
                    long[] jArr3 = jArr[i10];
                    jArr3[1] = jArr3[1] + aVar.f17343c[i8 + 1] + 128;
                    long[] jArr4 = jArr[i10];
                    jArr4[2] = jArr4[2] + aVar.f17343c[i8 + 2] + 128;
                    long[] jArr5 = jArr[i10];
                    jArr5[3] = jArr5[3] + aVar.f17343c[i8 + 3] + 128;
                    long[] jArr6 = jArr[i10];
                    jArr6[4] = jArr6[4] + 1;
                    iArr[i6 + 1][i7 + 1] = i10;
                }
            }
        }
        return new b(iArr, bArr);
    }

    /* renamed from: a */
    public static byte[][] m18455a(int i) {
        byte[][] bArr = (byte[][]) Array.newInstance(Byte.TYPE, i, 4);
        if (i < 8) {
            double d2 = 255.0d / (i - 1);
            for (byte b2 = (byte) 0; b2 < i; b2 = (byte) (b2 + 1)) {
                bArr[b2][0] = (byte) ((-128) + Math.round(b2 * d2));
                bArr[b2][1] = (byte) ((-128) + Math.round(b2 * d2));
                bArr[b2][2] = (byte) ((-128) + Math.round(b2 * d2));
                bArr[b2][3] = Byte.MAX_VALUE;
            }
        } else {
            int floor = (int) Math.floor(Math.pow(i, 0.3333333333333333d));
            int floor2 = (int) Math.floor(255 / (floor - 1));
            int i2 = 0;
            for (int i3 = 0; i3 < floor; i3++) {
                for (int i4 = 0; i4 < floor; i4++) {
                    for (int i5 = 0; i5 < floor; i5++) {
                        bArr[i2][0] = (byte) ((i3 * floor2) - 128);
                        bArr[i2][1] = (byte) ((i4 * floor2) - 128);
                        bArr[i2][2] = (byte) ((i5 * floor2) - 128);
                        bArr[i2][3] = Byte.MAX_VALUE;
                        i2++;
                    }
                }
            }
            for (int i6 = i2; i6 < i; i6++) {
                bArr[i2][0] = (byte) ((-128) + Math.floor(Math.random() * 255));
                bArr[i2][1] = (byte) ((-128) + Math.floor(Math.random() * 255));
                bArr[i2][2] = (byte) ((-128) + Math.floor(Math.random() * 255));
                bArr[i2][3] = (byte) ((-128) + Math.floor(Math.random() * 255));
            }
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[][] m18456a(int i, a aVar) {
        byte[][] bArr = (byte[][]) Array.newInstance(Byte.TYPE, i, 4);
        for (int i2 = 0; i2 < i; i2++) {
            int floor = (int) (Math.floor((Math.random() * aVar.f17343c.length) / 4) * 4);
            bArr[i2][0] = aVar.f17343c[floor];
            bArr[i2][1] = aVar.f17343c[floor + 1];
            bArr[i2][2] = aVar.f17343c[floor + 2];
            bArr[i2][3] = aVar.f17343c[floor + 3];
        }
        return bArr;
    }

    /* renamed from: a */
    public static int[][][] m18457a(b bVar) {
        int length = bVar.f17346c[0].length;
        int length2 = bVar.f17346c.length;
        int[][][] iArr = (int[][][]) Array.newInstance(Integer.TYPE, bVar.f17347d.length, length2, length);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 < length2 - 1) {
                int i3 = 1;
                while (true) {
                    int i4 = i3;
                    if (i4 >= length - 1) {
                        break;
                    }
                    int i5 = bVar.f17346c[i2][i4];
                    boolean z = bVar.f17346c[i2 + (-1)][i4 + (-1)] == i5;
                    int i6 = bVar.f17346c[i2 + (-1)][i4] == i5 ? 1 : 0;
                    int i7 = bVar.f17346c[i2 + (-1)][i4 + 1] == i5 ? 1 : 0;
                    int i8 = bVar.f17346c[i2][i4 + (-1)] == i5 ? 1 : 0;
                    int i9 = bVar.f17346c[i2][i4 + 1] == i5 ? 1 : 0;
                    int i10 = bVar.f17346c[i2 + 1][i4 + (-1)] == i5 ? 1 : 0;
                    int i11 = bVar.f17346c[i2 + 1][i4] == i5 ? 1 : 0;
                    iArr[i5][i2 + 1][i4 + 1] = ((bVar.f17346c[i2 + 1][i4 + 1] == i5 ? 1 : 0) * 4) + (i9 * 2) + 1 + (i11 * 8);
                    if (i8 == 0) {
                        iArr[i5][i2 + 1][i4] = (i10 * 8) + (i11 * 4) + 2;
                    }
                    if (i6 == 0) {
                        iArr[i5][i2][i4 + 1] = (i7 * 2) + 0 + (i9 * 4) + 8;
                    }
                    if (!z) {
                        iArr[i5][i2][i4] = (i6 * 2) + 0 + 4 + (i8 * 8);
                    }
                    i3 = i4 + 1;
                }
                i = i2 + 1;
            } else {
                return iArr;
            }
        }
    }

    /* renamed from: a */
    public static ArrayList<ArrayList<Integer[]>> m18442a(int[][] iArr, float f2) {
        ArrayList<ArrayList<Integer[]>> arrayList = new ArrayList<>();
        int length = iArr[0].length;
        int length2 = iArr.length;
        for (int i = 0; i < length2; i++) {
            for (int i2 = 0; i2 < length; i2++) {
                if (iArr[i][i2] != 0 && iArr[i][i2] != 15) {
                    arrayList.add(new ArrayList<>());
                    ArrayList<Integer[]> arrayList2 = arrayList.get(arrayList.size() - 1);
                    byte b2 = f17337b[iArr[i][i2]];
                    boolean z = f17338c[iArr[i][i2]];
                    boolean z2 = false;
                    int i3 = i;
                    int i4 = i2;
                    while (!z2) {
                        arrayList2.add(new Integer[3]);
                        arrayList2.get(arrayList2.size() - 1)[0] = new Integer(i4 - 1);
                        arrayList2.get(arrayList2.size() - 1)[1] = new Integer(i3 - 1);
                        arrayList2.get(arrayList2.size() - 1)[2] = new Integer(iArr[i3][i4]);
                        byte[] bArr = f17339d[iArr[i3][i4]][b2];
                        iArr[i3][i4] = bArr[0];
                        b2 = bArr[1];
                        i4 += bArr[2];
                        i3 += bArr[3];
                        if (i4 - 1 == arrayList2.get(0)[0].intValue() && i3 - 1 == arrayList2.get(0)[1].intValue()) {
                            if (z || arrayList2.size() < f2) {
                                arrayList.remove(arrayList2);
                            }
                            z2 = true;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static ArrayList<ArrayList<ArrayList<Integer[]>>> m18443a(int[][][] iArr, float f2) {
        ArrayList<ArrayList<ArrayList<Integer[]>>> arrayList = new ArrayList<>();
        for (int[][] iArr2 : iArr) {
            arrayList.add(m18442a(iArr2, f2));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static ArrayList<ArrayList<Double[]>> m18439a(ArrayList<ArrayList<Integer[]>> arrayList) {
        ArrayList<ArrayList<Double[]>> arrayList2 = new ArrayList<>();
        Double[] dArr = new Double[2];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                arrayList2.add(new ArrayList<>());
                ArrayList<Double[]> arrayList3 = arrayList2.get(arrayList2.size() - 1);
                int size = arrayList.get(i2).size();
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList3.add(new Double[3]);
                    Double[] dArr2 = arrayList3.get(arrayList3.size() - 1);
                    Integer[] numArr = arrayList.get(i2).get(i3);
                    Integer[] numArr2 = arrayList.get(i2).get((i3 + 1) % size);
                    Integer[] numArr3 = arrayList.get(i2).get((i3 + 2) % size);
                    dArr2[0] = new Double((numArr2[0].intValue() + numArr[0].intValue()) / 2.0d);
                    dArr2[1] = new Double((numArr2[1].intValue() + numArr[1].intValue()) / 2.0d);
                    dArr[0] = new Double((numArr3[0].intValue() + numArr2[0].intValue()) / 2.0d);
                    dArr[1] = new Double((numArr3[1].intValue() + numArr2[1].intValue()) / 2.0d);
                    if (dArr2[0].doubleValue() < dArr[0].doubleValue()) {
                        if (dArr2[1].doubleValue() < dArr[1].doubleValue()) {
                            dArr2[2] = new Double(1.0d);
                        } else if (dArr2[1].doubleValue() > dArr[1].doubleValue()) {
                            dArr2[2] = new Double(7.0d);
                        } else {
                            dArr2[2] = new Double(0.0d);
                        }
                    } else if (dArr2[0].doubleValue() > dArr[0].doubleValue()) {
                        if (dArr2[1].doubleValue() < dArr[1].doubleValue()) {
                            dArr2[2] = new Double(3.0d);
                        } else if (dArr2[1].doubleValue() > dArr[1].doubleValue()) {
                            dArr2[2] = new Double(5.0d);
                        } else {
                            dArr2[2] = new Double(4.0d);
                        }
                    } else if (dArr2[1].doubleValue() < dArr[1].doubleValue()) {
                        dArr2[2] = new Double(2.0d);
                    } else if (dArr2[1].doubleValue() > dArr[1].doubleValue()) {
                        dArr2[2] = new Double(6.0d);
                    } else {
                        dArr2[2] = new Double(8.0d);
                    }
                }
                i = i2 + 1;
            } else {
                return arrayList2;
            }
        }
    }

    /* renamed from: b */
    static ArrayList<ArrayList<ArrayList<Double[]>>> m18459b(ArrayList<ArrayList<ArrayList<Integer[]>>> arrayList) {
        ArrayList<ArrayList<ArrayList<Double[]>>> arrayList2 = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                arrayList2.add(m18439a(arrayList.get(i2)));
                i = i2 + 1;
            } else {
                return arrayList2;
            }
        }
    }

    /* renamed from: a */
    public static ArrayList<Double[]> m18440a(ArrayList<Double[]> arrayList, float f2, float f3) {
        ArrayList<Double[]> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            double doubleValue = arrayList.get(i)[2].doubleValue();
            double d2 = -1;
            int i2 = i + 1;
            while (true) {
                double d3 = d2;
                if ((arrayList.get(i2)[2].doubleValue() == doubleValue || arrayList.get(i2)[2].doubleValue() == d3 || d3 == -1) && i2 < size - 1) {
                    if (arrayList.get(i2)[2].doubleValue() != doubleValue && d3 == -1) {
                        d3 = arrayList.get(i2)[2].doubleValue();
                    }
                    d2 = d3;
                    i2++;
                }
            }
            if (i2 == size - 1) {
                i2 = 0;
            }
            arrayList2.addAll(m18441a(arrayList, f2, f3, i, i2));
            i = i2 > 0 ? i2 : size;
        }
        return arrayList2;
    }

    /* renamed from: a */
    public static ArrayList<Double[]> m18441a(ArrayList<Double[]> arrayList, float f2, float f3, int i, int i2) {
        int i3;
        ArrayList<Double[]> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        if (i2 > size || i2 < 0) {
            return arrayList2;
        }
        boolean z = true;
        double d2 = 0;
        double d3 = i2 - i;
        double d4 = d3 < ((double) 0) ? d3 + size : d3;
        double doubleValue = (arrayList.get(i2)[0].doubleValue() - arrayList.get(i)[0].doubleValue()) / d4;
        double doubleValue2 = (arrayList.get(i2)[1].doubleValue() - arrayList.get(i)[1].doubleValue()) / d4;
        int i4 = (i + 1) % size;
        int i5 = i;
        while (i4 != i2) {
            double d5 = i4 - i;
            double d6 = d5 < ((double) 0) ? d5 + size : d5;
            double doubleValue3 = (doubleValue * d6) + arrayList.get(i)[0].doubleValue();
            double doubleValue4 = (d6 * doubleValue2) + arrayList.get(i)[1].doubleValue();
            double doubleValue5 = ((arrayList.get(i4)[1].doubleValue() - doubleValue4) * (arrayList.get(i4)[1].doubleValue() - doubleValue4)) + ((arrayList.get(i4)[0].doubleValue() - doubleValue3) * (arrayList.get(i4)[0].doubleValue() - doubleValue3));
            boolean z2 = doubleValue5 > ((double) f2) ? false : z;
            if (doubleValue5 > d2) {
                i3 = i4;
            } else {
                doubleValue5 = d2;
                i3 = i5;
            }
            i4 = (i4 + 1) % size;
            d2 = doubleValue5;
            z = z2;
            i5 = i3;
        }
        if (z) {
            arrayList2.add(new Double[7]);
            Double[] dArr = arrayList2.get(arrayList2.size() - 1);
            dArr[0] = new Double(1.0d);
            dArr[1] = arrayList.get(i)[0];
            dArr[2] = arrayList.get(i)[1];
            dArr[3] = arrayList.get(i2)[0];
            dArr[4] = arrayList.get(i2)[1];
            dArr[5] = new Double(0.0d);
            dArr[6] = new Double(0.0d);
            return arrayList2;
        }
        boolean z3 = true;
        double d7 = 0;
        double d8 = (i5 - i) / d4;
        double d9 = (1.0d - d8) * (1.0d - d8);
        double d10 = 2.0d * (1.0d - d8) * d8;
        double d11 = d8 * d8;
        double doubleValue6 = (((d9 * arrayList.get(i)[0].doubleValue()) + (arrayList.get(i2)[0].doubleValue() * d11)) - arrayList.get(i5)[0].doubleValue()) / (-d10);
        double doubleValue7 = (((d9 * arrayList.get(i)[1].doubleValue()) + (arrayList.get(i2)[1].doubleValue() * d11)) - arrayList.get(i5)[1].doubleValue()) / (-d10);
        int i6 = i + 1;
        int i7 = i5;
        while (i6 != i2) {
            double d12 = (i6 - i) / d4;
            double d13 = (1.0d - d12) * (1.0d - d12);
            double d14 = 2.0d * (1.0d - d12) * d12;
            double d15 = d12 * d12;
            double doubleValue8 = (d14 * doubleValue6) + (arrayList.get(i)[0].doubleValue() * d13) + (arrayList.get(i2)[0].doubleValue() * d15);
            double doubleValue9 = (d14 * doubleValue7) + (arrayList.get(i)[1].doubleValue() * d13) + (arrayList.get(i2)[1].doubleValue() * d15);
            double doubleValue10 = ((arrayList.get(i6)[1].doubleValue() - doubleValue9) * (arrayList.get(i6)[1].doubleValue() - doubleValue9)) + ((arrayList.get(i6)[0].doubleValue() - doubleValue8) * (arrayList.get(i6)[0].doubleValue() - doubleValue8));
            if (doubleValue10 > f3) {
                z3 = false;
            }
            if (doubleValue10 > d7) {
                i7 = i6;
            } else {
                doubleValue10 = d7;
            }
            i6 = (i6 + 1) % size;
            d7 = doubleValue10;
        }
        if (z3) {
            arrayList2.add(new Double[7]);
            Double[] dArr2 = arrayList2.get(arrayList2.size() - 1);
            dArr2[0] = new Double(2.0d);
            dArr2[1] = arrayList.get(i)[0];
            dArr2[2] = arrayList.get(i)[1];
            dArr2[3] = new Double(doubleValue6);
            dArr2[4] = new Double(doubleValue7);
            dArr2[5] = arrayList.get(i2)[0];
            dArr2[6] = arrayList.get(i2)[1];
            return arrayList2;
        }
        int i8 = (i5 + i7) / 2;
        ArrayList<Double[]> m18441a = m18441a(arrayList, f2, f3, i, i8);
        m18441a.addAll(m18441a(arrayList, f2, f3, i8, i2));
        return m18441a;
    }

    /* renamed from: b */
    public static ArrayList<ArrayList<Double[]>> m18460b(ArrayList<ArrayList<Double[]>> arrayList, float f2, float f3) {
        ArrayList<ArrayList<Double[]>> arrayList2 = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                arrayList2.add(m18440a(arrayList.get(i2), f2, f3));
                i = i2 + 1;
            } else {
                return arrayList2;
            }
        }
    }

    /* renamed from: c */
    public static ArrayList<ArrayList<ArrayList<Double[]>>> m18462c(ArrayList<ArrayList<ArrayList<Double[]>>> arrayList, float f2, float f3) {
        ArrayList<ArrayList<ArrayList<Double[]>>> arrayList2 = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                arrayList2.add(m18460b(arrayList.get(i2), f2, f3));
                i = i2 + 1;
            } else {
                return arrayList2;
            }
        }
    }

    /* renamed from: a */
    public static float m18434a(float f2, float f3) {
        return (float) (Math.round(f2 * Math.pow(10, f3)) / Math.pow(10, f3));
    }

    /* renamed from: a */
    public static String m18436a(String str, ArrayList<Double[]> arrayList, String str2, HashMap<String, Float> hashMap) {
        float floatValue = hashMap.get(BatteryManager.EXTRA_SCALE).floatValue();
        float floor = (float) Math.floor(hashMap.get("roundcoords").floatValue());
        StringBuilder sb = new StringBuilder();
        sb.append("\t<path\n\t\t").append(str).append(str2).append("\n\t\tandroid:pathData=\"").append(DateFormat.NUM_MONTH).append(arrayList.get(0)[1].doubleValue() * floatValue).append(",").append(arrayList.get(0)[2].doubleValue() * floatValue).append(",");
        if (floor == -1) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                if (arrayList.get(i2)[0].doubleValue() == 1.0d) {
                    sb.append("L ").append(arrayList.get(i2)[3].doubleValue() * floatValue).append(" ").append(arrayList.get(i2)[4].doubleValue() * floatValue).append(" ");
                } else {
                    sb.append("Q ").append(arrayList.get(i2)[3].doubleValue() * floatValue).append(" ").append(arrayList.get(i2)[4].doubleValue() * floatValue).append(" ").append(arrayList.get(i2)[5].doubleValue() * floatValue).append(" ").append(arrayList.get(i2)[6].doubleValue() * floatValue).append(" ");
                }
                i = i2 + 1;
            }
        } else {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= arrayList.size()) {
                    break;
                }
                if (arrayList.get(i4)[0].doubleValue() == 1.0d) {
                    sb.append("L ").append(m18434a((float) (arrayList.get(i4)[3].doubleValue() * floatValue), floor)).append(" ").append(m18434a((float) (arrayList.get(i4)[4].doubleValue() * floatValue), floor)).append(" ");
                } else {
                    sb.append("Q ").append(m18434a((float) (arrayList.get(i4)[3].doubleValue() * floatValue), floor)).append(" ").append(m18434a((float) (arrayList.get(i4)[4].doubleValue() * floatValue), floor)).append(" ").append(m18434a((float) (arrayList.get(i4)[5].doubleValue() * floatValue), floor)).append(" ").append(m18434a((float) (arrayList.get(i4)[6].doubleValue() * floatValue), floor)).append(" ");
                }
                i3 = i4 + 1;
            }
        }
        sb.append("Z\" />\n");
        return sb.toString();
    }

    /* renamed from: a */
    public static String m18437a(String str, ArrayList<Double[]> arrayList, HashMap<String, Float> hashMap) {
        float floatValue = hashMap.get(BatteryManager.EXTRA_SCALE).floatValue();
        float floor = (float) Math.floor(hashMap.get("roundcoords").floatValue());
        StringBuilder sb = new StringBuilder();
        sb.append(DateFormat.NUM_MONTH).append(arrayList.get(0)[1].doubleValue() * floatValue).append(",").append(arrayList.get(0)[2].doubleValue() * floatValue).append(",");
        if (floor == -1) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                if (arrayList.get(i2)[0].doubleValue() == 1.0d) {
                    sb.append("L ").append(arrayList.get(i2)[3].doubleValue() * floatValue).append(" ").append(arrayList.get(i2)[4].doubleValue() * floatValue).append(" ");
                } else {
                    sb.append("Q ").append(arrayList.get(i2)[3].doubleValue() * floatValue).append(" ").append(arrayList.get(i2)[4].doubleValue() * floatValue).append(" ").append(arrayList.get(i2)[5].doubleValue() * floatValue).append(" ").append(arrayList.get(i2)[6].doubleValue() * floatValue).append(" ");
                }
                i = i2 + 1;
            }
        } else {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= arrayList.size()) {
                    break;
                }
                if (arrayList.get(i4)[0].doubleValue() == 1.0d) {
                    sb.append("L ").append(m18434a((float) (arrayList.get(i4)[3].doubleValue() * floatValue), floor)).append(" ").append(m18434a((float) (arrayList.get(i4)[4].doubleValue() * floatValue), floor)).append(" ");
                } else {
                    sb.append("Q ").append(m18434a((float) (arrayList.get(i4)[3].doubleValue() * floatValue), floor)).append(" ").append(m18434a((float) (arrayList.get(i4)[4].doubleValue() * floatValue), floor)).append(" ").append(m18434a((float) (arrayList.get(i4)[5].doubleValue() * floatValue), floor)).append(" ").append(m18434a((float) (arrayList.get(i4)[6].doubleValue() * floatValue), floor)).append(" ");
                }
                i3 = i4 + 1;
            }
        }
        sb.append("Z");
        return sb.toString();
    }

    /* renamed from: a */
    public static void m18452a(File file, b bVar, HashMap<String, Float> hashMap) {
        HashMap<String, Float> m18444a = m18444a(hashMap);
        int floatValue = (int) (m18444a.get(BatteryManager.EXTRA_SCALE).floatValue() * bVar.f17344a);
        int floatValue2 = (int) (m18444a.get(BatteryManager.EXTRA_SCALE).floatValue() * bVar.f17345b);
        StringBuilder sb = new StringBuilder();
        sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<!-- ").append("Created by Apktool M – https://github.com/Maximoff/Apktool-M-updates").toString()).append(" -->\n<vector\n\txmlns:android=\"http://schemas.android.com/apk/res/android\"\n\tandroid:height=\"").toString()).append(floatValue2).toString()).append(".0dp\"\n\tandroid:width=\"").toString()).append(floatValue).toString()).append(".0dp\"\n\tandroid:viewportHeight=\"").toString()).append(floatValue2).toString()).append(".0\"\n\tandroid:viewportWidth=\"").toString()).append(floatValue).toString()).append(".0\">\n").toString());
        TreeMap treeMap = new TreeMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bVar.f17348e.size()) {
                break;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= bVar.f17348e.get(i2).size()) {
                    break;
                }
                double doubleValue = (bVar.f17348e.get(i2).get(i4).get(0)[2].doubleValue() * floatValue) + bVar.f17348e.get(i2).get(i4).get(0)[1].doubleValue();
                if (!treeMap.containsKey(new Double(doubleValue))) {
                    treeMap.put(new Double(doubleValue), new Integer[2]);
                }
                ((Integer[]) treeMap.get(new Double(doubleValue)))[0] = new Integer(i2);
                ((Integer[]) treeMap.get(new Double(doubleValue)))[1] = new Integer(i4);
                i3 = i4 + 1;
            }
            i = i2 + 1;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            sb.append(m18436a("", bVar.f17348e.get(((Integer[]) entry.getValue())[0].intValue()).get(((Integer[]) entry.getValue())[1].intValue()), m18438a(bVar.f17347d[((Integer[]) entry.getValue())[0].intValue()]), m18444a));
        }
        sb.append("</vector>");
        m18453a(file.getAbsolutePath(), sb.toString());
    }

    /* renamed from: a */
    public static List<C3115bq> m18447a(b bVar, HashMap<String, Float> hashMap) {
        ArrayList arrayList = new ArrayList();
        HashMap<String, Float> m18444a = m18444a(hashMap);
        int floatValue = (int) (m18444a.get(BatteryManager.EXTRA_SCALE).floatValue() * bVar.f17344a);
        TreeMap treeMap = new TreeMap();
        for (int i = 0; i < bVar.f17348e.size(); i++) {
            for (int i2 = 0; i2 < bVar.f17348e.get(i).size(); i2++) {
                double doubleValue = (bVar.f17348e.get(i).get(i2).get(0)[2].doubleValue() * floatValue) + bVar.f17348e.get(i).get(i2).get(0)[1].doubleValue();
                if (!treeMap.containsKey(new Double(doubleValue))) {
                    treeMap.put(new Double(doubleValue), new Integer[2]);
                }
                ((Integer[]) treeMap.get(new Double(doubleValue)))[0] = new Integer(i);
                ((Integer[]) treeMap.get(new Double(doubleValue)))[1] = new Integer(i2);
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            arrayList.add(new C3115bq(m18458b(bVar.f17347d[((Integer[]) entry.getValue())[0].intValue()]), m18437a("", bVar.f17348e.get(((Integer[]) entry.getValue())[0].intValue()).get(((Integer[]) entry.getValue())[1].intValue()), m18444a)));
        }
        return arrayList;
    }

    /* renamed from: a */
    static String m18438a(byte[] bArr) {
        String upperCase = m18458b(bArr).toUpperCase();
        return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("android:fillColor=\"#").append(upperCase).toString()).append("\"\n\t\tandroid:strokeColor=\"#").toString()).append(upperCase).toString()).append("\"\n\t\tandroid:strokeWidth=\"1\"").toString();
    }

    /* renamed from: b */
    public static String m18458b(byte[] bArr) {
        String m18435a = m18435a(Integer.toHexString(bArr[3] + 128));
        String m18435a2 = m18435a(Integer.toHexString(bArr[0] + 128));
        String m18435a3 = m18435a(Integer.toHexString(bArr[1] + 128));
        return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18435a).append(m18435a2).toString()).append(m18435a3).toString()).append(m18435a(Integer.toHexString(bArr[2] + 128))).toString();
    }

    /* renamed from: a */
    private static final String m18435a(String str) {
        return str.length() == 1 ? new StringBuffer().append("0").append(str).toString() : str;
    }

    /* renamed from: a */
    static a m18449a(a aVar, float f2, float f3) {
        a aVar2 = new a(aVar.f17341a, aVar.f17342b, new byte[aVar.f17341a * aVar.f17342b * 4]);
        int floor = (int) Math.floor(f2);
        if (floor >= 1) {
            int i = floor > 5 ? 5 : floor;
            int abs = (int) Math.abs(f3);
            int i2 = abs > 1024 ? 1024 : abs;
            double[] dArr = f17340e[i - 1];
            for (int i3 = 0; i3 < aVar.f17342b; i3++) {
                for (int i4 = 0; i4 < aVar.f17341a; i4++) {
                    double d2 = 0;
                    double d3 = 0;
                    double d4 = 0;
                    double d5 = 0;
                    double d6 = 0;
                    for (int i5 = -i; i5 < i + 1; i5++) {
                        if (i4 + i5 > 0 && i4 + i5 < aVar.f17341a) {
                            int i6 = ((aVar.f17341a * i3) + i4 + i5) * 4;
                            d2 += aVar.f17343c[i6] * dArr[i5 + i];
                            d3 += aVar.f17343c[i6 + 1] * dArr[i5 + i];
                            d4 += aVar.f17343c[i6 + 2] * dArr[i5 + i];
                            d5 += aVar.f17343c[i6 + 3] * dArr[i5 + i];
                            d6 += dArr[i5 + i];
                        }
                    }
                    int i7 = ((aVar.f17341a * i3) + i4) * 4;
                    aVar2.f17343c[i7] = (byte) Math.floor(d2 / d6);
                    aVar2.f17343c[i7 + 1] = (byte) Math.floor(d3 / d6);
                    aVar2.f17343c[i7 + 2] = (byte) Math.floor(d4 / d6);
                    aVar2.f17343c[i7 + 3] = (byte) Math.floor(d5 / d6);
                }
            }
            byte[] bArr = (byte[]) aVar2.f17343c.clone();
            for (int i8 = 0; i8 < aVar.f17342b; i8++) {
                for (int i9 = 0; i9 < aVar.f17341a; i9++) {
                    double d7 = 0;
                    double d8 = 0;
                    double d9 = 0;
                    double d10 = 0;
                    double d11 = 0;
                    for (int i10 = -i; i10 < i + 1; i10++) {
                        if (i8 + i10 > 0 && i8 + i10 < aVar.f17342b) {
                            int i11 = (((i8 + i10) * aVar.f17341a) + i9) * 4;
                            d7 += bArr[i11] * dArr[i10 + i];
                            d8 += bArr[i11 + 1] * dArr[i10 + i];
                            d9 += bArr[i11 + 2] * dArr[i10 + i];
                            d10 += bArr[i11 + 3] * dArr[i10 + i];
                            d11 += dArr[i10 + i];
                        }
                    }
                    int i12 = ((aVar.f17341a * i8) + i9) * 4;
                    aVar2.f17343c[i12] = (byte) Math.floor(d7 / d11);
                    aVar2.f17343c[i12 + 1] = (byte) Math.floor(d8 / d11);
                    aVar2.f17343c[i12 + 2] = (byte) Math.floor(d9 / d11);
                    aVar2.f17343c[i12 + 3] = (byte) Math.floor(d10 / d11);
                }
            }
            for (int i13 = 0; i13 < aVar.f17342b; i13++) {
                for (int i14 = 0; i14 < aVar.f17341a; i14++) {
                    int i15 = ((aVar.f17341a * i13) + i14) * 4;
                    if (Math.abs(aVar2.f17343c[i15] - aVar.f17343c[i15]) + Math.abs(aVar2.f17343c[i15 + 1] - aVar.f17343c[i15 + 1]) + Math.abs(aVar2.f17343c[i15 + 2] - aVar.f17343c[i15 + 2]) + Math.abs(aVar2.f17343c[i15 + 3] - aVar.f17343c[i15 + 3]) > i2) {
                        aVar2.f17343c[i15] = aVar.f17343c[i15];
                        aVar2.f17343c[i15 + 1] = aVar.f17343c[i15 + 1];
                        aVar2.f17343c[i15 + 2] = aVar.f17343c[i15 + 2];
                        aVar2.f17343c[i15 + 3] = aVar.f17343c[i15 + 3];
                    }
                }
            }
            return aVar2;
        }
        return aVar;
    }
}
