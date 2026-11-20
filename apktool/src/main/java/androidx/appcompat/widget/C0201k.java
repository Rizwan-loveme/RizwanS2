package androidx.appcompat.widget;

import android.C0012R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.C0059a;
import androidx.appcompat.p014a.p015a.C0060a;
import androidx.appcompat.widget.C0174ap;
import androidx.core.graphics.C0311a;

/* compiled from: AppCompatDrawableManager.java */
/* renamed from: androidx.appcompat.widget.k */
/* loaded from: classes.dex */
public final class C0201k {

    /* renamed from: a */
    private static final PorterDuff.Mode f1711a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    private static C0201k f1712b;

    /* renamed from: c */
    private C0174ap f1713c;

    /* renamed from: a */
    public static synchronized void m1543a() {
        synchronized (C0201k.class) {
            if (f1712b == null) {
                f1712b = new C0201k();
                f1712b.f1713c = C0174ap.m1352a();
                f1712b.f1713c.m1368a(new C0174ap.f() { // from class: androidx.appcompat.widget.k.1

                    /* renamed from: a */
                    private final int[] f1714a = {C0059a.e.abc_textfield_search_default_mtrl_alpha, C0059a.e.abc_textfield_default_mtrl_alpha, C0059a.e.abc_ab_share_pack_mtrl_alpha};

                    /* renamed from: b */
                    private final int[] f1715b = {C0059a.e.abc_ic_commit_search_api_mtrl_alpha, C0059a.e.abc_seekbar_tick_mark_material, C0059a.e.abc_ic_menu_share_mtrl_alpha, C0059a.e.abc_ic_menu_copy_mtrl_am_alpha, C0059a.e.abc_ic_menu_cut_mtrl_alpha, C0059a.e.abc_ic_menu_selectall_mtrl_alpha, C0059a.e.abc_ic_menu_paste_mtrl_am_alpha};

                    /* renamed from: c */
                    private final int[] f1716c = {C0059a.e.abc_textfield_activated_mtrl_alpha, C0059a.e.abc_textfield_search_activated_mtrl_alpha, C0059a.e.abc_cab_background_top_mtrl_alpha, C0059a.e.abc_text_cursor_material, C0059a.e.abc_text_select_handle_left_mtrl, C0059a.e.abc_text_select_handle_middle_mtrl, C0059a.e.abc_text_select_handle_right_mtrl};

                    /* renamed from: d */
                    private final int[] f1717d = {C0059a.e.abc_popup_background_mtrl_mult, C0059a.e.abc_cab_background_internal_bg, C0059a.e.abc_menu_hardkey_panel_mtrl_mult};

                    /* renamed from: e */
                    private final int[] f1718e = {C0059a.e.abc_tab_indicator_material, C0059a.e.abc_textfield_search_material};

                    /* renamed from: f */
                    private final int[] f1719f = {C0059a.e.abc_btn_check_material, C0059a.e.abc_btn_radio_material, C0059a.e.abc_btn_check_material_anim, C0059a.e.abc_btn_radio_material_anim};

                    /* renamed from: a */
                    private ColorStateList m1551a(Context context) {
                        return m1555b(context, C0179au.m1419a(context, C0059a.a.colorButtonNormal));
                    }

                    /* renamed from: b */
                    private ColorStateList m1554b(Context context) {
                        return m1555b(context, 0);
                    }

                    /* renamed from: c */
                    private ColorStateList m1557c(Context context) {
                        return m1555b(context, C0179au.m1419a(context, C0059a.a.colorAccent));
                    }

                    /* renamed from: b */
                    private ColorStateList m1555b(Context context, int i) {
                        int m1419a = C0179au.m1419a(context, C0059a.a.colorControlHighlight);
                        return new ColorStateList(new int[][]{C0179au.f1570a, C0179au.f1573d, C0179au.f1571b, C0179au.f1577h}, new int[]{C0179au.m1424c(context, C0059a.a.colorButtonNormal), C0311a.m2307a(m1419a, i), C0311a.m2307a(m1419a, i), i});
                    }

                    /* renamed from: d */
                    private ColorStateList m1558d(Context context) {
                        int[][] iArr = new int[3][];
                        int[] iArr2 = new int[3];
                        ColorStateList m1423b = C0179au.m1423b(context, C0059a.a.colorSwitchThumbNormal);
                        if (m1423b != null && m1423b.isStateful()) {
                            iArr[0] = C0179au.f1570a;
                            iArr2[0] = m1423b.getColorForState(iArr[0], 0);
                            iArr[1] = C0179au.f1574e;
                            iArr2[1] = C0179au.m1419a(context, C0059a.a.colorControlActivated);
                            iArr[2] = C0179au.f1577h;
                            iArr2[2] = m1423b.getDefaultColor();
                        } else {
                            iArr[0] = C0179au.f1570a;
                            iArr2[0] = C0179au.m1424c(context, C0059a.a.colorSwitchThumbNormal);
                            iArr[1] = C0179au.f1574e;
                            iArr2[1] = C0179au.m1419a(context, C0059a.a.colorControlActivated);
                            iArr[2] = C0179au.f1577h;
                            iArr2[2] = C0179au.m1419a(context, C0059a.a.colorSwitchThumbNormal);
                        }
                        return new ColorStateList(iArr, iArr2);
                    }

                    @Override // androidx.appcompat.widget.C0174ap.f
                    /* renamed from: a */
                    public Drawable mo1377a(C0174ap c0174ap, Context context, int i) {
                        if (i == C0059a.e.abc_cab_background_top_material) {
                            return new LayerDrawable(new Drawable[]{c0174ap.m1364a(context, C0059a.e.abc_cab_background_internal_bg), c0174ap.m1364a(context, C0059a.e.abc_cab_background_top_mtrl_alpha)});
                        }
                        if (i == C0059a.e.abc_ratingbar_material) {
                            return m1556b(c0174ap, context, C0059a.d.abc_star_big);
                        }
                        if (i == C0059a.e.abc_ratingbar_indicator_material) {
                            return m1556b(c0174ap, context, C0059a.d.abc_star_medium);
                        }
                        if (i == C0059a.e.abc_ratingbar_small_material) {
                            return m1556b(c0174ap, context, C0059a.d.abc_star_small);
                        }
                        return null;
                    }

                    /* renamed from: b */
                    private LayerDrawable m1556b(C0174ap c0174ap, Context context, int i) {
                        BitmapDrawable bitmapDrawable;
                        BitmapDrawable bitmapDrawable2;
                        BitmapDrawable bitmapDrawable3;
                        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
                        Drawable m1364a = c0174ap.m1364a(context, C0059a.e.abc_star_black_48dp);
                        Drawable m1364a2 = c0174ap.m1364a(context, C0059a.e.abc_star_half_black_48dp);
                        if ((m1364a instanceof BitmapDrawable) && m1364a.getIntrinsicWidth() == dimensionPixelSize && m1364a.getIntrinsicHeight() == dimensionPixelSize) {
                            BitmapDrawable bitmapDrawable4 = (BitmapDrawable) m1364a;
                            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable4.getBitmap());
                            bitmapDrawable = bitmapDrawable4;
                        } else {
                            Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(createBitmap);
                            m1364a.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                            m1364a.draw(canvas);
                            bitmapDrawable = new BitmapDrawable(createBitmap);
                            bitmapDrawable2 = new BitmapDrawable(createBitmap);
                        }
                        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
                        if ((m1364a2 instanceof BitmapDrawable) && m1364a2.getIntrinsicWidth() == dimensionPixelSize && m1364a2.getIntrinsicHeight() == dimensionPixelSize) {
                            bitmapDrawable3 = (BitmapDrawable) m1364a2;
                        } else {
                            Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                            Canvas canvas2 = new Canvas(createBitmap2);
                            m1364a2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                            m1364a2.draw(canvas2);
                            bitmapDrawable3 = new BitmapDrawable(createBitmap2);
                        }
                        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
                        layerDrawable.setId(0, C0012R.id.background);
                        layerDrawable.setId(1, C0012R.id.secondaryProgress);
                        layerDrawable.setId(2, C0012R.id.progress);
                        return layerDrawable;
                    }

                    /* renamed from: a */
                    private void m1552a(Drawable drawable, int i, PorterDuff.Mode mode) {
                        if (C0165ag.m1263b(drawable)) {
                            drawable = drawable.mutate();
                        }
                        if (mode == null) {
                            mode = C0201k.f1711a;
                        }
                        drawable.setColorFilter(C0201k.m1542a(i, mode));
                    }

                    @Override // androidx.appcompat.widget.C0174ap.f
                    /* renamed from: a */
                    public boolean mo1378a(Context context, int i, Drawable drawable) {
                        if (i == C0059a.e.abc_seekbar_track_material) {
                            LayerDrawable layerDrawable = (LayerDrawable) drawable;
                            m1552a(layerDrawable.findDrawableByLayerId(C0012R.id.background), C0179au.m1419a(context, C0059a.a.colorControlNormal), C0201k.f1711a);
                            m1552a(layerDrawable.findDrawableByLayerId(C0012R.id.secondaryProgress), C0179au.m1419a(context, C0059a.a.colorControlNormal), C0201k.f1711a);
                            m1552a(layerDrawable.findDrawableByLayerId(C0012R.id.progress), C0179au.m1419a(context, C0059a.a.colorControlActivated), C0201k.f1711a);
                            return true;
                        }
                        if (i == C0059a.e.abc_ratingbar_material || i == C0059a.e.abc_ratingbar_indicator_material || i == C0059a.e.abc_ratingbar_small_material) {
                            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                            m1552a(layerDrawable2.findDrawableByLayerId(C0012R.id.background), C0179au.m1424c(context, C0059a.a.colorControlNormal), C0201k.f1711a);
                            m1552a(layerDrawable2.findDrawableByLayerId(C0012R.id.secondaryProgress), C0179au.m1419a(context, C0059a.a.colorControlActivated), C0201k.f1711a);
                            m1552a(layerDrawable2.findDrawableByLayerId(C0012R.id.progress), C0179au.m1419a(context, C0059a.a.colorControlActivated), C0201k.f1711a);
                            return true;
                        }
                        return false;
                    }

                    /* renamed from: a */
                    private boolean m1553a(int[] iArr, int i) {
                        for (int i2 : iArr) {
                            if (i2 == i) {
                                return true;
                            }
                        }
                        return false;
                    }

                    @Override // androidx.appcompat.widget.C0174ap.f
                    /* renamed from: a */
                    public ColorStateList mo1375a(Context context, int i) {
                        if (i == C0059a.e.abc_edit_text_material) {
                            return C0060a.m345a(context, C0059a.c.abc_tint_edittext);
                        }
                        if (i == C0059a.e.abc_switch_track_mtrl_alpha) {
                            return C0060a.m345a(context, C0059a.c.abc_tint_switch_track);
                        }
                        if (i == C0059a.e.abc_switch_thumb_material) {
                            return m1558d(context);
                        }
                        if (i == C0059a.e.abc_btn_default_mtrl_shape) {
                            return m1551a(context);
                        }
                        if (i == C0059a.e.abc_btn_borderless_material) {
                            return m1554b(context);
                        }
                        if (i == C0059a.e.abc_btn_colored_material) {
                            return m1557c(context);
                        }
                        if (i == C0059a.e.abc_spinner_mtrl_am_alpha || i == C0059a.e.abc_spinner_textfield_background_material) {
                            return C0060a.m345a(context, C0059a.c.abc_tint_spinner);
                        }
                        if (m1553a(this.f1715b, i)) {
                            return C0179au.m1423b(context, C0059a.a.colorControlNormal);
                        }
                        if (m1553a(this.f1718e, i)) {
                            return C0060a.m345a(context, C0059a.c.abc_tint_default);
                        }
                        if (m1553a(this.f1719f, i)) {
                            return C0060a.m345a(context, C0059a.c.abc_tint_btn_checkable);
                        }
                        if (i == C0059a.e.abc_seekbar_thumb_material) {
                            return C0060a.m345a(context, C0059a.c.abc_tint_seek_thumb);
                        }
                        return null;
                    }

                    @Override // androidx.appcompat.widget.C0174ap.f
                    /* renamed from: b */
                    public boolean mo1379b(Context context, int i, Drawable drawable) {
                        int i2;
                        boolean z;
                        int i3 = C0012R.attr.colorBackground;
                        PorterDuff.Mode mode = C0201k.f1711a;
                        if (m1553a(this.f1714a, i)) {
                            i3 = C0059a.a.colorControlNormal;
                            i2 = -1;
                            z = true;
                        } else if (m1553a(this.f1716c, i)) {
                            i3 = C0059a.a.colorControlActivated;
                            i2 = -1;
                            z = true;
                        } else if (m1553a(this.f1717d, i)) {
                            mode = PorterDuff.Mode.MULTIPLY;
                            i2 = -1;
                            z = true;
                        } else if (i == C0059a.e.abc_list_divider_mtrl_alpha) {
                            i3 = C0012R.attr.colorForeground;
                            i2 = Math.round(40.8f);
                            z = true;
                        } else if (i == C0059a.e.abc_dialog_material_background) {
                            i2 = -1;
                            z = true;
                        } else {
                            i2 = -1;
                            i3 = 0;
                            z = false;
                        }
                        if (!z) {
                            return false;
                        }
                        if (C0165ag.m1263b(drawable)) {
                            drawable = drawable.mutate();
                        }
                        drawable.setColorFilter(C0201k.m1542a(C0179au.m1419a(context, i3), mode));
                        if (i2 == -1) {
                            return true;
                        }
                        drawable.setAlpha(i2);
                        return true;
                    }

                    @Override // androidx.appcompat.widget.C0174ap.f
                    /* renamed from: a */
                    public PorterDuff.Mode mo1376a(int i) {
                        if (i != C0059a.e.abc_switch_thumb_material) {
                            return null;
                        }
                        return PorterDuff.Mode.MULTIPLY;
                    }
                });
            }
        }
    }

    /* renamed from: b */
    public static synchronized C0201k m1545b() {
        C0201k c0201k;
        synchronized (C0201k.class) {
            if (f1712b == null) {
                m1543a();
            }
            c0201k = f1712b;
        }
        return c0201k;
    }

    /* renamed from: a */
    public synchronized Drawable m1547a(Context context, int i) {
        return this.f1713c.m1364a(context, i);
    }

    /* renamed from: a */
    synchronized Drawable m1548a(Context context, int i, boolean z) {
        return this.f1713c.m1365a(context, i, z);
    }

    /* renamed from: a */
    public synchronized void m1549a(Context context) {
        this.f1713c.m1367a(context);
    }

    /* renamed from: b */
    synchronized ColorStateList m1550b(Context context, int i) {
        return this.f1713c.m1370b(context, i);
    }

    /* renamed from: a */
    static void m1544a(Drawable drawable, C0182ax c0182ax, int[] iArr) {
        C0174ap.m1354a(drawable, c0182ax, iArr);
    }

    /* renamed from: a */
    public static synchronized PorterDuffColorFilter m1542a(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter m1348a;
        synchronized (C0201k.class) {
            m1348a = C0174ap.m1348a(i, mode);
        }
        return m1348a;
    }
}
