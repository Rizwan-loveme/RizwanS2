package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.p006pm.PackageManager;
import android.content.p006pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.p008os.Bundle;
import android.p008os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.C0255a;
import androidx.core.p024a.p025a.InterfaceMenuC0226a;
import androidx.core.p031f.AbstractC0283b;
import androidx.core.p031f.C0309y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MenuBuilder.java */
/* renamed from: androidx.appcompat.view.menu.g */
/* loaded from: classes.dex */
public class C0106g implements InterfaceMenuC0226a {

    /* renamed from: d */
    private static final int[] f996d = {1, 4, 5, 3, 2, 0};

    /* renamed from: A */
    private boolean f997A;

    /* renamed from: a */
    CharSequence f998a;

    /* renamed from: b */
    Drawable f999b;

    /* renamed from: c */
    View f1000c;

    /* renamed from: e */
    private final Context f1001e;

    /* renamed from: f */
    private final Resources f1002f;

    /* renamed from: g */
    private boolean f1003g;

    /* renamed from: h */
    private boolean f1004h;

    /* renamed from: i */
    private a f1005i;

    /* renamed from: q */
    private ContextMenu.ContextMenuInfo f1013q;

    /* renamed from: y */
    private C0108i f1021y;

    /* renamed from: p */
    private int f1012p = 0;

    /* renamed from: r */
    private boolean f1014r = false;

    /* renamed from: s */
    private boolean f1015s = false;

    /* renamed from: t */
    private boolean f1016t = false;

    /* renamed from: u */
    private boolean f1017u = false;

    /* renamed from: v */
    private boolean f1018v = false;

    /* renamed from: w */
    private ArrayList<C0108i> f1019w = new ArrayList<>();

    /* renamed from: x */
    private CopyOnWriteArrayList<WeakReference<InterfaceC0112m>> f1020x = new CopyOnWriteArrayList<>();

    /* renamed from: z */
    private boolean f1022z = false;

    /* renamed from: j */
    private ArrayList<C0108i> f1006j = new ArrayList<>();

    /* renamed from: k */
    private ArrayList<C0108i> f1007k = new ArrayList<>();

    /* renamed from: l */
    private boolean f1008l = true;

    /* renamed from: m */
    private ArrayList<C0108i> f1009m = new ArrayList<>();

    /* renamed from: n */
    private ArrayList<C0108i> f1010n = new ArrayList<>();

    /* renamed from: o */
    private boolean f1011o = true;

    /* compiled from: MenuBuilder.java */
    /* renamed from: androidx.appcompat.view.menu.g$a */
    public interface a {
        /* renamed from: a */
        void mo529a(C0106g c0106g);

        /* renamed from: a */
        boolean mo532a(C0106g c0106g, MenuItem menuItem);
    }

    /* compiled from: MenuBuilder.java */
    /* renamed from: androidx.appcompat.view.menu.g$b */
    public interface b {
        /* renamed from: a */
        boolean mo791a(C0108i c0108i);
    }

    public C0106g(Context context) {
        this.f1001e = context;
        this.f1002f = context.getResources();
        m866f(true);
    }

    /* renamed from: a */
    public C0106g m869a(int i) {
        this.f1012p = i;
        return this;
    }

    /* renamed from: a */
    public void m879a(InterfaceC0112m interfaceC0112m) {
        m880a(interfaceC0112m, this.f1001e);
    }

    /* renamed from: a */
    public void m880a(InterfaceC0112m interfaceC0112m, Context context) {
        this.f1020x.add(new WeakReference<>(interfaceC0112m));
        interfaceC0112m.mo810a(context, this);
        this.f1011o = true;
    }

    /* renamed from: b */
    public void m889b(InterfaceC0112m interfaceC0112m) {
        Iterator<WeakReference<InterfaceC0112m>> it = this.f1020x.iterator();
        while (it.hasNext()) {
            WeakReference<InterfaceC0112m> next = it.next();
            InterfaceC0112m interfaceC0112m2 = next.get();
            if (interfaceC0112m2 == null || interfaceC0112m2 == interfaceC0112m) {
                this.f1020x.remove(next);
            }
        }
    }

    /* renamed from: e */
    private void m864e(boolean z) {
        if (!this.f1020x.isEmpty()) {
            m904h();
            Iterator<WeakReference<InterfaceC0112m>> it = this.f1020x.iterator();
            while (it.hasNext()) {
                WeakReference<InterfaceC0112m> next = it.next();
                InterfaceC0112m interfaceC0112m = next.get();
                if (interfaceC0112m == null) {
                    this.f1020x.remove(next);
                } else {
                    interfaceC0112m.mo815a(z);
                }
            }
            m905i();
        }
    }

    /* renamed from: a */
    private boolean m863a(SubMenuC0117r subMenuC0117r, InterfaceC0112m interfaceC0112m) {
        if (this.f1020x.isEmpty()) {
            return false;
        }
        boolean mo819a = interfaceC0112m != null ? interfaceC0112m.mo819a(subMenuC0117r) : false;
        Iterator<WeakReference<InterfaceC0112m>> it = this.f1020x.iterator();
        while (true) {
            boolean z = mo819a;
            if (!it.hasNext()) {
                return z;
            }
            WeakReference<InterfaceC0112m> next = it.next();
            InterfaceC0112m interfaceC0112m2 = next.get();
            if (interfaceC0112m2 == null) {
                this.f1020x.remove(next);
            } else if (!z) {
                z = interfaceC0112m2.mo819a(subMenuC0117r);
            }
            mo819a = z;
        }
    }

    /* renamed from: a */
    public void m875a(Bundle bundle) {
        SparseArray<? extends Parcelable> sparseArray = null;
        int size = size();
        int i = 0;
        while (i < size) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray<? extends Parcelable> sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((SubMenuC0117r) item.getSubMenu()).m875a(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(mo874a(), sparseArray);
        }
    }

    /* renamed from: b */
    public void m887b(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(mo874a());
            int size = size();
            for (int i = 0; i < size; i++) {
                MenuItem item = getItem(i);
                View actionView = item.getActionView();
                if (actionView != null && actionView.getId() != -1) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((SubMenuC0117r) item.getSubMenu()).m887b(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0 && (findItem = findItem(i2)) != null) {
                findItem.expandActionView();
            }
        }
    }

    /* renamed from: a */
    protected String mo874a() {
        return "android:menu:actionviewstates";
    }

    /* renamed from: a */
    public void mo877a(a aVar) {
        this.f1005i = aVar;
    }

    /* renamed from: a */
    protected MenuItem m868a(int i, int i2, int i3, CharSequence charSequence) {
        int m865f = m865f(i3);
        C0108i m860a = m860a(i, i2, i3, m865f, charSequence, this.f1012p);
        if (this.f1013q != null) {
            m860a.m923a(this.f1013q);
        }
        this.f1006j.add(m859a(this.f1006j, m865f), m860a);
        m890b(true);
        return m860a;
    }

    /* renamed from: a */
    private C0108i m860a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new C0108i(this, i, i2, i3, i4, charSequence, i5);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return m868a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return m868a(0, 0, 0, this.f1002f.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m868a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return m868a(i, i2, i3, this.f1002f.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f1002f.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        C0108i c0108i = (C0108i) m868a(i, i2, i3, charSequence);
        SubMenuC0117r subMenuC0117r = new SubMenuC0117r(this.f1001e, this, c0108i);
        c0108i.m924a(subMenuC0117r);
        return subMenuC0117r;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f1002f.getString(i4));
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.f1022z = z;
    }

    /* renamed from: b */
    public boolean mo891b() {
        return this.f1022z;
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f1001e.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        m862a(m886b(i), true);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int m892c = m892c(i);
        if (m892c >= 0) {
            int size = this.f1006j.size() - m892c;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.f1006j.get(m892c).getGroupId() != i) {
                    break;
                }
                m862a(m892c, false);
                i2 = i3;
            }
            m890b(true);
        }
    }

    /* renamed from: a */
    private void m862a(int i, boolean z) {
        if (i >= 0 && i < this.f1006j.size()) {
            this.f1006j.remove(i);
            if (z) {
                m890b(true);
            }
        }
    }

    @Override // android.view.Menu
    public void clear() {
        if (this.f1021y != null) {
            mo899d(this.f1021y);
        }
        this.f1006j.clear();
        m890b(true);
    }

    /* renamed from: a */
    void m876a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f1006j.size();
        m904h();
        for (int i = 0; i < size; i++) {
            C0108i c0108i = this.f1006j.get(i);
            if (c0108i.getGroupId() == groupId && c0108i.m936g() && c0108i.isCheckable()) {
                c0108i.m927b(c0108i == menuItem);
            }
        }
        m905i();
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f1006j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0108i c0108i = this.f1006j.get(i2);
            if (c0108i.getGroupId() == i) {
                c0108i.m925a(z2);
                c0108i.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.f1006j.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            C0108i c0108i = this.f1006j.get(i2);
            i2++;
            z2 = (c0108i.getGroupId() == i && c0108i.m930c(z)) ? true : z2;
        }
        if (z2) {
            m890b(true);
        }
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.f1006j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0108i c0108i = this.f1006j.get(i2);
            if (c0108i.getGroupId() == i) {
                c0108i.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f997A) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f1006j.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        MenuItem findItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            C0108i c0108i = this.f1006j.get(i2);
            if (c0108i.getItemId() != i) {
                if (c0108i.hasSubMenu() && (findItem = c0108i.getSubMenu().findItem(i)) != null) {
                    return findItem;
                }
            } else {
                return c0108i;
            }
        }
        return null;
    }

    /* renamed from: b */
    public int m886b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f1006j.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: c */
    public int m892c(int i) {
        return m867a(i, 0);
    }

    /* renamed from: a */
    public int m867a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (this.f1006j.get(i3).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    @Override // android.view.Menu
    public int size() {
        return this.f1006j.size();
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.f1006j.get(i);
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m873a(i, keyEvent) != null;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f1003g = z;
        m890b(false);
    }

    /* renamed from: f */
    private static int m865f(int i) {
        int i2 = ((-65536) & i) >> 16;
        if (i2 < 0 || i2 >= f996d.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        return (f996d[i2] << 16) | (65535 & i);
    }

    /* renamed from: c */
    boolean mo894c() {
        return this.f1003g;
    }

    /* renamed from: f */
    private void m866f(boolean z) {
        this.f1004h = z && this.f1002f.getConfiguration().keyboard != 1 && C0309y.m2305a(ViewConfiguration.get(this.f1001e), this.f1001e);
    }

    /* renamed from: d */
    public boolean mo898d() {
        return this.f1004h;
    }

    /* renamed from: e */
    Resources m900e() {
        return this.f1002f;
    }

    /* renamed from: f */
    public Context m902f() {
        return this.f1001e;
    }

    /* renamed from: a */
    boolean mo885a(C0106g c0106g, MenuItem menuItem) {
        return this.f1005i != null && this.f1005i.mo532a(c0106g, menuItem);
    }

    /* renamed from: g */
    public void m903g() {
        if (this.f1005i != null) {
            this.f1005i.mo529a(this);
        }
    }

    /* renamed from: a */
    private static int m859a(ArrayList<C0108i> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).m929c() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        C0108i m873a = m873a(i, keyEvent);
        boolean z = false;
        if (m873a != null) {
            z = m883a(m873a, i2);
        }
        if ((i2 & 2) != 0) {
            m882a(true);
        }
        return z;
    }

    /* renamed from: a */
    void m881a(List<C0108i> list, int i, KeyEvent keyEvent) {
        boolean mo894c = mo894c();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f1006j.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0108i c0108i = this.f1006j.get(i2);
                if (c0108i.hasSubMenu()) {
                    ((C0106g) c0108i.getSubMenu()).m881a(list, i, keyEvent);
                }
                char alphabeticShortcut = mo894c ? c0108i.getAlphabeticShortcut() : c0108i.getNumericShortcut();
                if (((modifiers & Menu.SUPPORTED_MODIFIERS_MASK) == ((mo894c ? c0108i.getAlphabeticModifiers() : c0108i.getNumericModifiers()) & Menu.SUPPORTED_MODIFIERS_MASK)) && alphabeticShortcut != 0 && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (mo894c && alphabeticShortcut == '\b' && i == 67)) && c0108i.isEnabled())) {
                    list.add(c0108i);
                }
            }
        }
    }

    /* renamed from: a */
    C0108i m873a(int i, KeyEvent keyEvent) {
        ArrayList<C0108i> arrayList = this.f1019w;
        arrayList.clear();
        m881a(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean mo894c = mo894c();
        for (int i2 = 0; i2 < size; i2++) {
            C0108i c0108i = arrayList.get(i2);
            char alphabeticShortcut = mo894c ? c0108i.getAlphabeticShortcut() : c0108i.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return c0108i;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return c0108i;
            }
            if (mo894c && alphabeticShortcut == '\b' && i == 67) {
                return c0108i;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return m883a(findItem(i), i2);
    }

    /* renamed from: a */
    public boolean m883a(MenuItem menuItem, int i) {
        return m884a(menuItem, (InterfaceC0112m) null, i);
    }

    /* renamed from: a */
    public boolean m884a(MenuItem menuItem, InterfaceC0112m interfaceC0112m, int i) {
        C0108i c0108i = (C0108i) menuItem;
        if (c0108i == null || !c0108i.isEnabled()) {
            return false;
        }
        boolean m928b = c0108i.m928b();
        AbstractC0283b mo803a = c0108i.mo803a();
        boolean z = mo803a != null && mo803a.mo949c();
        if (c0108i.m943n()) {
            boolean expandActionView = c0108i.expandActionView() | m928b;
            if (expandActionView) {
                m882a(true);
                return expandActionView;
            }
            return expandActionView;
        }
        if (c0108i.hasSubMenu() || z) {
            if ((i & 4) == 0) {
                m882a(false);
            }
            if (!c0108i.hasSubMenu()) {
                c0108i.m924a(new SubMenuC0117r(m902f(), this, c0108i));
            }
            SubMenuC0117r subMenuC0117r = (SubMenuC0117r) c0108i.getSubMenu();
            if (z) {
                mo803a.mo947a(subMenuC0117r);
            }
            boolean m863a = m863a(subMenuC0117r, interfaceC0112m) | m928b;
            if (!m863a) {
                m882a(true);
                return m863a;
            }
            return m863a;
        }
        if ((i & 1) == 0) {
            m882a(true);
        }
        return m928b;
    }

    /* renamed from: a */
    public final void m882a(boolean z) {
        if (!this.f1018v) {
            this.f1018v = true;
            Iterator<WeakReference<InterfaceC0112m>> it = this.f1020x.iterator();
            while (it.hasNext()) {
                WeakReference<InterfaceC0112m> next = it.next();
                InterfaceC0112m interfaceC0112m = next.get();
                if (interfaceC0112m == null) {
                    this.f1020x.remove(next);
                } else {
                    interfaceC0112m.mo812a(this, z);
                }
            }
            this.f1018v = false;
        }
    }

    @Override // android.view.Menu
    public void close() {
        m882a(true);
    }

    /* renamed from: b */
    public void m890b(boolean z) {
        if (!this.f1014r) {
            if (z) {
                this.f1008l = true;
                this.f1011o = true;
            }
            m864e(z);
            return;
        }
        this.f1015s = true;
        if (z) {
            this.f1016t = true;
        }
    }

    /* renamed from: h */
    public void m904h() {
        if (!this.f1014r) {
            this.f1014r = true;
            this.f1015s = false;
            this.f1016t = false;
        }
    }

    /* renamed from: i */
    public void m905i() {
        this.f1014r = false;
        if (this.f1015s) {
            this.f1015s = false;
            m890b(this.f1016t);
        }
    }

    /* renamed from: a */
    void m878a(C0108i c0108i) {
        this.f1008l = true;
        m890b(true);
    }

    /* renamed from: b */
    void m888b(C0108i c0108i) {
        this.f1011o = true;
        m890b(true);
    }

    /* renamed from: j */
    public ArrayList<C0108i> m906j() {
        if (!this.f1008l) {
            return this.f1007k;
        }
        this.f1007k.clear();
        int size = this.f1006j.size();
        for (int i = 0; i < size; i++) {
            C0108i c0108i = this.f1006j.get(i);
            if (c0108i.isVisible()) {
                this.f1007k.add(c0108i);
            }
        }
        this.f1008l = false;
        this.f1011o = true;
        return this.f1007k;
    }

    /* renamed from: k */
    public void m907k() {
        boolean mo821b;
        ArrayList<C0108i> m906j = m906j();
        if (this.f1011o) {
            Iterator<WeakReference<InterfaceC0112m>> it = this.f1020x.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference<InterfaceC0112m> next = it.next();
                InterfaceC0112m interfaceC0112m = next.get();
                if (interfaceC0112m == null) {
                    this.f1020x.remove(next);
                    mo821b = z;
                } else {
                    mo821b = interfaceC0112m.mo821b() | z;
                }
                z = mo821b;
            }
            if (z) {
                this.f1009m.clear();
                this.f1010n.clear();
                int size = m906j.size();
                for (int i = 0; i < size; i++) {
                    C0108i c0108i = m906j.get(i);
                    if (c0108i.m939j()) {
                        this.f1009m.add(c0108i);
                    } else {
                        this.f1010n.add(c0108i);
                    }
                }
            } else {
                this.f1009m.clear();
                this.f1010n.clear();
                this.f1010n.addAll(m906j());
            }
            this.f1011o = false;
        }
    }

    /* renamed from: l */
    public ArrayList<C0108i> m908l() {
        m907k();
        return this.f1009m;
    }

    /* renamed from: m */
    public ArrayList<C0108i> m909m() {
        m907k();
        return this.f1010n;
    }

    public void clearHeader() {
        this.f999b = null;
        this.f998a = null;
        this.f1000c = null;
        m890b(false);
    }

    /* renamed from: a */
    private void m861a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources m900e = m900e();
        if (view != null) {
            this.f1000c = view;
            this.f998a = null;
            this.f999b = null;
        } else {
            if (i > 0) {
                this.f998a = m900e.getText(i);
            } else if (charSequence != null) {
                this.f998a = charSequence;
            }
            if (i2 > 0) {
                this.f999b = C0255a.m1847a(m902f(), i2);
            } else if (drawable != null) {
                this.f999b = drawable;
            }
            this.f1000c = null;
        }
        m890b(false);
    }

    /* renamed from: a */
    protected C0106g m872a(CharSequence charSequence) {
        m861a(0, charSequence, 0, null, null);
        return this;
    }

    /* renamed from: d */
    protected C0106g m896d(int i) {
        m861a(i, null, 0, null, null);
        return this;
    }

    /* renamed from: a */
    protected C0106g m870a(Drawable drawable) {
        m861a(0, null, 0, drawable, null);
        return this;
    }

    /* renamed from: e */
    protected C0106g m901e(int i) {
        m861a(0, null, i, null, null);
        return this;
    }

    /* renamed from: a */
    protected C0106g m871a(View view) {
        m861a(0, null, 0, null, view);
        return this;
    }

    /* renamed from: n */
    public CharSequence m910n() {
        return this.f998a;
    }

    /* renamed from: o */
    public Drawable m911o() {
        return this.f999b;
    }

    /* renamed from: p */
    public View m912p() {
        return this.f1000c;
    }

    /* renamed from: q */
    public C0106g mo913q() {
        return this;
    }

    /* renamed from: c */
    public void m893c(boolean z) {
        this.f1017u = z;
    }

    /* renamed from: r */
    boolean m914r() {
        return this.f1017u;
    }

    /* renamed from: c */
    public boolean mo895c(C0108i c0108i) {
        boolean z = false;
        if (!this.f1020x.isEmpty()) {
            m904h();
            Iterator<WeakReference<InterfaceC0112m>> it = this.f1020x.iterator();
            while (true) {
                boolean z2 = z;
                if (!it.hasNext()) {
                    z = z2;
                    break;
                }
                WeakReference<InterfaceC0112m> next = it.next();
                InterfaceC0112m interfaceC0112m = next.get();
                if (interfaceC0112m == null) {
                    this.f1020x.remove(next);
                    z = z2;
                } else {
                    z = interfaceC0112m.mo818a(this, c0108i);
                    if (z) {
                        break;
                    }
                }
            }
            m905i();
            if (z) {
                this.f1021y = c0108i;
            }
        }
        return z;
    }

    /* renamed from: d */
    public boolean mo899d(C0108i c0108i) {
        boolean z = false;
        if (!this.f1020x.isEmpty() && this.f1021y == c0108i) {
            m904h();
            Iterator<WeakReference<InterfaceC0112m>> it = this.f1020x.iterator();
            while (true) {
                boolean z2 = z;
                if (!it.hasNext()) {
                    z = z2;
                    break;
                }
                WeakReference<InterfaceC0112m> next = it.next();
                InterfaceC0112m interfaceC0112m = next.get();
                if (interfaceC0112m == null) {
                    this.f1020x.remove(next);
                    z = z2;
                } else {
                    z = interfaceC0112m.mo822b(this, c0108i);
                    if (z) {
                        break;
                    }
                }
            }
            m905i();
            if (z) {
                this.f1021y = null;
            }
        }
        return z;
    }

    /* renamed from: s */
    public C0108i m915s() {
        return this.f1021y;
    }

    /* renamed from: d */
    public void m897d(boolean z) {
        this.f997A = z;
    }
}
