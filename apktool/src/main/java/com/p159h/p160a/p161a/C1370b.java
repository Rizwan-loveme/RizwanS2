package com.p159h.p160a.p161a;

import android.C0012R;
import android.app.SearchManager;
import android.content.res.TypedArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.view.AbstractC0090b;
import androidx.appcompat.view.menu.C0106g;
import com.srizwan.apktool.R;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.fragment.p301a.C2978b;
import ru.maximoff.apktool.util.C3112bn;

/* compiled from: ClipboardPanel.java */
/* renamed from: com.h.a.a.b */
/* loaded from: classes.dex */
public class C1370b {

    /* renamed from: a */
    protected C1371c f8841a;

    /* renamed from: b */
    private AbstractC0090b f8842b;

    /* renamed from: c */
    private ActionMode f8843c;

    public C1370b(C1371c c1371c) {
        this.f8841a = c1371c;
    }

    /* renamed from: a */
    public void m10799a(int i, boolean z) {
        m10801b(i, z);
    }

    /* renamed from: a */
    public void m10798a() {
        m10800b();
    }

    /* renamed from: b */
    public void m10801b(int i, boolean z) {
        MainActivity m16615o;
        if (this.f8842b == null && this.f8843c == null && (m16615o = MainActivity.m16615o()) != null && !m16615o.isFinishing() && !m16615o.isDestroyed() && !m16615o.m16634p()) {
            if (i == 2) {
                this.f8841a.startActionMode(new ActionMode.Callback(this, m16615o) { // from class: com.h.a.a.b.1

                    /* renamed from: a */
                    private final C1370b f8844a;

                    /* renamed from: b */
                    private final MainActivity f8845b;

                    {
                        this.f8844a = this;
                        this.f8845b = m16615o;
                    }

                    @Override // android.view.ActionMode.Callback
                    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                        this.f8844a.f8843c = actionMode;
                        actionMode.setTitle(C0012R.string.selectTextMode);
                        TypedArray obtainStyledAttributes = this.f8845b.getTheme().obtainStyledAttributes(new int[]{R.attr.actionModeSelectAllDrawable, R.attr.actionModeCopyDrawable, R.attr.actionModeShareDrawable});
                        menu.add(0, 0, 0, this.f8845b.getString(C0012R.string.selectAll)).setShowAsActionFlags(2).setAlphabeticShortcut('a').setIcon(obtainStyledAttributes.getDrawable(0));
                        menu.add(0, 1, 0, this.f8845b.getString(C0012R.string.copy)).setShowAsActionFlags(2).setAlphabeticShortcut('c').setIcon(obtainStyledAttributes.getDrawable(1));
                        menu.add(0, 2, 0, this.f8845b.getString(R.string.send)).setShowAsActionFlags(2).setAlphabeticShortcut('z').setIcon(obtainStyledAttributes.getDrawable(2));
                        obtainStyledAttributes.recycle();
                        return true;
                    }

                    @Override // android.view.ActionMode.Callback
                    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                        return false;
                    }

                    @Override // android.view.ActionMode.Callback
                    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case 0:
                                this.f8844a.f8841a.m10854A();
                                break;
                            case 1:
                                this.f8844a.f8841a.m10858E();
                                actionMode.finish();
                                break;
                            case 2:
                                C3112bn.m19028c(this.f8845b, this.f8844a.f8841a.getSelection().toString());
                                actionMode.finish();
                                break;
                        }
                        return true;
                    }

                    @Override // android.view.ActionMode.Callback
                    public void onDestroyActionMode(ActionMode actionMode) {
                        this.f8844a.f8841a.m10895f(false);
                        this.f8844a.f8842b = (AbstractC0090b) null;
                        this.f8844a.f8843c = (ActionMode) null;
                    }
                });
            } else {
                m16615o.m449b(new AbstractC0090b.a(this, m16615o, i, z) { // from class: com.h.a.a.b.2

                    /* renamed from: a */
                    private final C1370b f8846a;

                    /* renamed from: b */
                    private final MainActivity f8847b;

                    /* renamed from: c */
                    private final int f8848c;

                    /* renamed from: d */
                    private final boolean f8849d;

                    {
                        this.f8846a = this;
                        this.f8847b = m16615o;
                        this.f8848c = i;
                        this.f8849d = z;
                    }

                    @Override // androidx.appcompat.view.AbstractC0090b.a
                    /* renamed from: a */
                    public boolean mo561a(AbstractC0090b abstractC0090b, Menu menu) {
                        this.f8846a.f8842b = abstractC0090b;
                        if (menu instanceof C0106g) {
                            ((C0106g) menu).m893c(true);
                        }
                        abstractC0090b.mo653a(C0012R.string.selectTextMode);
                        TypedArray obtainStyledAttributes = this.f8847b.getTheme().obtainStyledAttributes(new int[]{R.attr.actionModeSelectAllDrawable, R.attr.actionModeCutDrawable, R.attr.actionModeCopyDrawable, R.attr.actionModePasteDrawable, R.attr.actionModeSearchDrawable, R.attr.actionModePaletteDrawable, R.attr.actionModeShareDrawable, R.attr.actionModeGotoDrawable, R.attr.actionModeLowerDrawable, R.attr.actionModeUpperDrawable, R.attr.actionModeCommentDrawable, R.attr.actionModeTranslateDrawable, R.attr.actionModeLeftDrawable, R.attr.actionModeRightDrawable, R.attr.actionModeSaveDrawable, R.attr.actionModeHelpDrawable});
                        menu.add(0, 0, 0, this.f8847b.getString(C0012R.string.selectAll)).setShowAsActionFlags(2).setAlphabeticShortcut('a').setIcon(obtainStyledAttributes.getDrawable(0));
                        if (this.f8848c == 0) {
                            menu.add(0, 1, 0, this.f8847b.getString(C0012R.string.cut)).setShowAsActionFlags(2).setAlphabeticShortcut('x').setIcon(obtainStyledAttributes.getDrawable(1));
                        }
                        menu.add(0, 2, 0, this.f8847b.getString(C0012R.string.copy)).setShowAsActionFlags(2).setAlphabeticShortcut('c').setIcon(obtainStyledAttributes.getDrawable(2));
                        if (this.f8848c == 0) {
                            menu.add(0, 3, 0, this.f8847b.getString(C0012R.string.paste)).setShowAsActionFlags(2).setAlphabeticShortcut('v').setIcon(obtainStyledAttributes.getDrawable(3));
                            menu.add(0, 4, 0, this.f8847b.getString(C0012R.string.search_go)).setShowAsActionFlags(1).setAlphabeticShortcut('p').setIcon(obtainStyledAttributes.getDrawable(4));
                            menu.add(0, 5, 0, this.f8847b.getString(R.string.select_color)).setShowAsActionFlags(1).setAlphabeticShortcut(SearchManager.MENU_KEY).setIcon(obtainStyledAttributes.getDrawable(5));
                        }
                        menu.add(0, 6, 0, this.f8847b.getString(R.string.send)).setShowAsActionFlags(this.f8848c > 0 ? 2 : 1).setAlphabeticShortcut('z').setIcon(obtainStyledAttributes.getDrawable(6));
                        if (this.f8848c == 0) {
                            if (this.f8849d) {
                                menu.add(0, 7, 0, this.f8847b.getString(R.string.go_to)).setShowAsActionFlags(1).setAlphabeticShortcut('g').setIcon(obtainStyledAttributes.getDrawable(7));
                            }
                            menu.add(0, 8, 0, this.f8847b.getString(R.string.lower_case)).setShowAsActionFlags(1).setAlphabeticShortcut('l').setIcon(obtainStyledAttributes.getDrawable(8));
                            menu.add(0, 9, 0, this.f8847b.getString(R.string.upper_case)).setShowAsActionFlags(1).setAlphabeticShortcut('u').setIcon(obtainStyledAttributes.getDrawable(9));
                            menu.add(0, 12, 0, this.f8847b.getString(R.string.dec_indent)).setShowAsActionFlags(1).setAlphabeticShortcut('d').setIcon(obtainStyledAttributes.getDrawable(12));
                            menu.add(0, 13, 0, this.f8847b.getString(R.string.inc_indent)).setShowAsActionFlags(1).setAlphabeticShortcut('i').setIcon(obtainStyledAttributes.getDrawable(13));
                            menu.add(0, 10, 0, this.f8847b.getString(R.string.comment)).setShowAsActionFlags(1).setAlphabeticShortcut('k').setIcon(obtainStyledAttributes.getDrawable(10));
                            menu.add(0, 11, 0, this.f8847b.getString(R.string.mtranslator)).setShowAsActionFlags(1).setAlphabeticShortcut('t').setIcon(obtainStyledAttributes.getDrawable(11));
                            menu.add(0, 14, 0, this.f8847b.getString(R.string.save_as)).setShowAsActionFlags(1).setAlphabeticShortcut('b').setIcon(obtainStyledAttributes.getDrawable(14));
                            if (this.f8849d) {
                                menu.add(0, 15, 0, this.f8847b.getString(R.string.smali_help)).setShowAsActionFlags(1).setAlphabeticShortcut('h').setIcon(obtainStyledAttributes.getDrawable(15));
                            }
                        }
                        obtainStyledAttributes.recycle();
                        return true;
                    }

                    @Override // androidx.appcompat.view.AbstractC0090b.a
                    /* renamed from: b */
                    public boolean mo563b(AbstractC0090b abstractC0090b, Menu menu) {
                        return false;
                    }

                    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                    /* JADX WARN: Code restructure failed: missing block: B:3:0x0021, code lost:
                    
                        return true;
                     */
                    @Override // androidx.appcompat.view.AbstractC0090b.a
                    /* renamed from: a */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public boolean mo562a(AbstractC0090b abstractC0090b, MenuItem menuItem) {
                        int selectionStart = this.f8846a.f8841a.getSelectionStart();
                        int selectionEnd = this.f8846a.f8841a.getSelectionEnd();
                        CharSequence selection = this.f8846a.f8841a.getSelection();
                        switch (menuItem.getItemId()) {
                            case 0:
                                this.f8846a.f8841a.m10854A();
                                break;
                            case 1:
                                this.f8846a.f8841a.m10857D();
                                abstractC0090b.mo660c();
                                break;
                            case 2:
                                this.f8846a.f8841a.m10858E();
                                abstractC0090b.mo660c();
                                break;
                            case 3:
                                this.f8846a.f8841a.m10859F();
                                abstractC0090b.mo660c();
                                break;
                            case 4:
                                C2978b.f16135a.m17707d().m17641a(selection, true, false);
                                abstractC0090b.mo660c();
                                this.f8846a.f8841a.m10888d(Math.min(selectionStart, selectionEnd), Math.abs(selectionEnd - selectionStart));
                                break;
                            case 5:
                                C2978b.f16135a.m17707d().m17661g(selection.toString());
                                abstractC0090b.mo660c();
                                this.f8846a.f8841a.m10888d(Math.min(selectionStart, selectionEnd), Math.abs(selectionEnd - selectionStart));
                                break;
                            case 6:
                                C3112bn.m19028c(this.f8847b, selection.toString());
                                abstractC0090b.mo660c();
                                break;
                            case 7:
                                C2978b.f16135a.m17707d().m17640a((CharSequence) selection.toString(), false);
                                abstractC0090b.mo660c();
                                this.f8846a.f8841a.m10888d(Math.min(selectionStart, selectionEnd), Math.abs(selectionEnd - selectionStart));
                                break;
                            case 8:
                                C2978b.f16135a.m17707d().m17654c(selection.toString().toLowerCase());
                                abstractC0090b.mo660c();
                                this.f8846a.f8841a.m10888d(Math.min(selectionStart, selectionEnd), Math.abs(selectionEnd - selectionStart));
                                break;
                            case 9:
                                C2978b.f16135a.m17707d().m17654c(selection.toString().toUpperCase());
                                abstractC0090b.mo660c();
                                this.f8846a.f8841a.m10888d(Math.min(selectionStart, selectionEnd), Math.abs(selectionEnd - selectionStart));
                                break;
                            case 10:
                                C2978b.f16135a.m17707d().m17655d(selection.toString());
                                abstractC0090b.mo660c();
                                break;
                            case 11:
                                C2978b.f16135a.m17707d().m17660f(selection.toString());
                                abstractC0090b.mo660c();
                                this.f8846a.f8841a.m10888d(Math.min(selectionStart, selectionEnd), Math.abs(selectionEnd - selectionStart));
                                break;
                            case 12:
                                int m17628a = C2978b.f16135a.m17707d().m17628a(selection.toString(), false);
                                abstractC0090b.mo660c();
                                if (m17628a >= 0) {
                                    this.f8846a.f8841a.m10888d(Math.min(selectionStart, selectionEnd), m17628a);
                                    this.f8846a.m10801b(this.f8848c, this.f8849d);
                                    break;
                                }
                                break;
                            case 13:
                                int m17628a2 = C2978b.f16135a.m17707d().m17628a(selection.toString(), true);
                                abstractC0090b.mo660c();
                                if (m17628a2 >= 0) {
                                    this.f8846a.f8841a.m10888d(Math.min(selectionStart, selectionEnd), m17628a2);
                                    this.f8846a.m10801b(this.f8848c, this.f8849d);
                                    break;
                                }
                                break;
                            case 14:
                                C2978b.f16135a.m17707d().m17665n(true);
                                abstractC0090b.mo660c();
                                this.f8846a.f8841a.m10888d(Math.min(selectionStart, selectionEnd), Math.abs(selectionEnd - selectionStart));
                                break;
                            case 15:
                                C2978b.f16135a.m17707d().m17658e(selection.toString());
                                abstractC0090b.mo660c();
                                this.f8846a.f8841a.m10888d(Math.min(selectionStart, selectionEnd), Math.abs(selectionEnd - selectionStart));
                                break;
                        }
                    }

                    @Override // androidx.appcompat.view.AbstractC0090b.a
                    /* renamed from: a */
                    public void mo560a(AbstractC0090b abstractC0090b) {
                        this.f8846a.f8841a.m10895f(false);
                        this.f8846a.f8842b = (AbstractC0090b) null;
                        this.f8846a.f8843c = (ActionMode) null;
                    }
                });
            }
        }
    }

    /* renamed from: b */
    public void m10800b() {
        if (this.f8842b != null) {
            this.f8842b.mo660c();
            this.f8842b = (AbstractC0090b) null;
        }
        if (this.f8843c != null) {
            this.f8843c.finish();
            this.f8843c = (ActionMode) null;
        }
    }
}
