package ru.maximoff.apktool.p297b;

import android.view.Menu;
import android.view.MenuItem;
import com.srizwan.apktool.R;
import ru.maximoff.apktool.fragment.p301a.C2978b;
import ru.maximoff.apktool.util.C3102bd;

/* compiled from: Menus.java */
/* renamed from: ru.maximoff.apktool.b.a */
/* loaded from: classes.dex */
public class C2895a {
    /* renamed from: a */
    public static void m16939a(Menu menu, int i) {
        for (a aVar : a.values()) {
            aVar.m16941a(menu, i);
        }
    }

    /* renamed from: a */
    public static void m16940a(MenuItem menuItem, int i) {
        int itemId = menuItem.getItemId();
        for (a aVar : a.values()) {
            if (aVar.f14892u == itemId) {
                aVar.mo16943b(menuItem, i);
            }
        }
    }

    /* compiled from: Menus.java */
    /* renamed from: ru.maximoff.apktool.b.a$a */
    private enum a {
        METHODS(R.id.methods) { // from class: ru.maximoff.apktool.b.a.a.1
            @Override // ru.maximoff.apktool.p297b.C2895a.a
            /* renamed from: a */
            void mo16942a(MenuItem menuItem, int i) {
                if (C3102bd.f18291a) {
                    menuItem.setIcon(R.drawable.nav_menu);
                } else {
                    menuItem.setIcon(R.drawable.nav_dark_menu);
                }
                menuItem.setVisible(C2978b.f16135a.m17729o(i));
            }
        },
        HELP(R.id.smali_help) { // from class: ru.maximoff.apktool.b.a.a.2
            @Override // ru.maximoff.apktool.p297b.C2895a.a
            /* renamed from: a */
            void mo16942a(MenuItem menuItem, int i) {
                menuItem.setVisible(C2978b.f16135a.m17729o(i));
            }
        },
        TRANSLATE(R.id.translate) { // from class: ru.maximoff.apktool.b.a.a.3
            @Override // ru.maximoff.apktool.p297b.C2895a.a
            /* renamed from: a */
            void mo16942a(MenuItem menuItem, int i) {
                if (C2978b.f16135a.m17734t(i)) {
                    menuItem.setTitle(R.string.return_smali);
                } else {
                    menuItem.setTitle(R.string.translate_java);
                }
                menuItem.setVisible(C2978b.f16135a.m17729o(i) && C2978b.f16135a.m17730p(i));
            }
        },
        SAVE(R.id.save) { // from class: ru.maximoff.apktool.b.a.a.4
            @Override // ru.maximoff.apktool.p297b.C2895a.a
            /* renamed from: a */
            void mo16942a(MenuItem menuItem, int i) {
                if (C3102bd.f18291a) {
                    menuItem.setIcon(R.drawable.save_menu);
                } else {
                    menuItem.setIcon(R.drawable.save_dark_menu);
                }
                menuItem.setEnabled(C2978b.f16135a.m17710e(i));
            }
        },
        UNDO(R.id.undo) { // from class: ru.maximoff.apktool.b.a.a.5
            @Override // ru.maximoff.apktool.p297b.C2895a.a
            /* renamed from: a */
            void mo16942a(MenuItem menuItem, int i) {
                if (C3102bd.f18291a) {
                    menuItem.setIcon(R.drawable.undo_menu);
                } else {
                    menuItem.setIcon(R.drawable.undo_dark_menu);
                }
                menuItem.setEnabled(C2978b.f16135a.m17714g(i));
            }

            @Override // ru.maximoff.apktool.p297b.C2895a.a
            /* renamed from: b */
            void mo16943b(MenuItem menuItem, int i) {
                C2978b.f16135a.m17720j(i);
            }
        },
        REDO(R.id.redo) { // from class: ru.maximoff.apktool.b.a.a.6
            @Override // ru.maximoff.apktool.p297b.C2895a.a
            /* renamed from: a */
            void mo16942a(MenuItem menuItem, int i) {
                if (C3102bd.f18291a) {
                    menuItem.setIcon(R.drawable.redo_menu);
                } else {
                    menuItem.setIcon(R.drawable.redo_dark_menu);
                }
                menuItem.setEnabled(C2978b.f16135a.m17716h(i));
            }

            @Override // ru.maximoff.apktool.p297b.C2895a.a
            /* renamed from: b */
            void mo16943b(MenuItem menuItem, int i) {
                C2978b.f16135a.m17722k(i);
            }
        },
        FIND(R.id.find),
        SAVEAS(R.id.save_as) { // from class: ru.maximoff.apktool.b.a.a.7
            @Override // ru.maximoff.apktool.p297b.C2895a.a
            /* renamed from: b */
            void mo16943b(MenuItem menuItem, int i) {
                C2978b.f16135a.m17691a(i, false);
            }
        },
        SAVEALL(R.id.save_all) { // from class: ru.maximoff.apktool.b.a.a.8
            @Override // ru.maximoff.apktool.p297b.C2895a.a
            /* renamed from: a */
            void mo16942a(MenuItem menuItem, int i) {
                menuItem.setEnabled(C2978b.f16135a.m17717i());
            }

            @Override // ru.maximoff.apktool.p297b.C2895a.a
            /* renamed from: b */
            void mo16943b(MenuItem menuItem, int i) {
                C2978b.f16135a.m17719j();
            }
        },
        CLOSEALL(R.id.close_all) { // from class: ru.maximoff.apktool.b.a.a.9
            @Override // ru.maximoff.apktool.p297b.C2895a.a
            /* renamed from: b */
            void mo16943b(MenuItem menuItem, int i) {
                C2978b.f16135a.m17684a(i, 2);
            }
        },
        RELOAD(R.id.reload),
        SYNTAX(R.id.syntax) { // from class: ru.maximoff.apktool.b.a.a.10
            @Override // ru.maximoff.apktool.p297b.C2895a.a
            /* renamed from: a */
            void mo16942a(MenuItem menuItem, int i) {
                menuItem.setEnabled(!C2978b.f16135a.m17734t(i));
            }
        },
        ENCODING(R.id.encoding),
        WORDWRAP(R.id.wordwrap),
        ROWS(R.id.select_rows),
        GO_TO_LINE(R.id.go_to_line),
        EDIT_MODE(R.id.edit_mode) { // from class: ru.maximoff.apktool.b.a.a.11
            @Override // ru.maximoff.apktool.p297b.C2895a.a
            /* renamed from: a */
            void mo16942a(MenuItem menuItem, int i) {
                if (C2978b.f16135a.m17712f(i)) {
                    menuItem.setTitle(R.string.scan_mode);
                } else {
                    menuItem.setTitle(R.string.edit_mode);
                }
                menuItem.setEnabled(!C2978b.f16135a.m17733s(i));
            }
        },
        FORMAT(R.id.format) { // from class: ru.maximoff.apktool.b.a.a.12
            @Override // ru.maximoff.apktool.p297b.C2895a.a
            /* renamed from: a */
            void mo16942a(MenuItem menuItem, int i) {
                menuItem.setEnabled(C2978b.f16135a.m17718i(i));
            }

            @Override // ru.maximoff.apktool.p297b.C2895a.a
            /* renamed from: b */
            void mo16943b(MenuItem menuItem, int i) {
                C2978b.f16135a.m17724l(i);
            }
        },
        COLOR(R.id.color) { // from class: ru.maximoff.apktool.b.a.a.13
            @Override // ru.maximoff.apktool.p297b.C2895a.a
            /* renamed from: a */
            void mo16942a(MenuItem menuItem, int i) {
                menuItem.setEnabled(!C2978b.f16135a.m17733s(i));
            }
        },
        PROPERTIES(R.id.properties);


        /* renamed from: u */
        final int f14892u;

        /* renamed from: a */
        void mo16942a(MenuItem menuItem, int i) {
        }

        /* renamed from: b */
        void mo16943b(MenuItem menuItem, int i) {
        }

        public static a valueOf(String str) {
            for (a aVar : values()) {
                if (aVar.name().equals(str)) {
                    return aVar;
                }
            }
            throw new IllegalArgumentException();
        }

        a(int i) {
            this.f14892u = i;
        }

        /* renamed from: a */
        void m16941a(Menu menu, int i) {
            MenuItem findItem = menu.findItem(this.f14892u);
            if (i == -1) {
                findItem.setVisible(false);
            } else {
                findItem.setVisible(true);
                mo16942a(findItem, i);
            }
        }
    }
}
