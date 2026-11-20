package ru.maximoff.apktool.fragment.p302b;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.srizwan.apktool.R;
import java.io.File;
import java.util.Arrays;
import ru.maximoff.apktool.fragment.C2981b;
import ru.maximoff.apktool.util.C3066aa;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3246h;

/* compiled from: BackItem.java */
/* renamed from: ru.maximoff.apktool.fragment.b.c */
/* loaded from: classes.dex */
public class C2984c implements InterfaceC2994m {

    /* renamed from: a */
    private final File f16383a;

    /* renamed from: b */
    private Context f16384b;

    /* renamed from: c */
    private boolean f16385c = false;

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: a */
    public void mo17863a() {
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: a */
    public void mo17865a(C2991j c2991j) {
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: b */
    public void mo17868b() {
    }

    @Override // java.lang.Comparable
    public int compareTo(InterfaceC2994m interfaceC2994m) {
        return m17862a(interfaceC2994m);
    }

    public C2984c(Context context, File file) {
        this.f16384b = context;
        this.f16383a = file;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: c */
    public boolean mo17870c() {
        return false;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: a */
    public void mo17864a(View view, ImageView imageView, TextView textView, TextView textView2, InterfaceC2995n interfaceC2995n) {
        view.setBackgroundColor(0);
        C3066aa c3066aa = new C3066aa(this.f16384b);
        String string = this.f16384b.getString(R.string.go_back);
        imageView.setImageBitmap(c3066aa.m18363a(C3246h.m19470a(this.f16384b, C3102bd.f18291a ? R.color.colorFolderLight : R.color.colorFolderDark), R.drawable.ic_folder));
        textView.setText("..");
        textView.setContentDescription(string);
        textView2.setVisibility(8);
        imageView.setContentDescription(string);
        imageView.setOnClickListener(new View.OnClickListener(this, view, interfaceC2995n) { // from class: ru.maximoff.apktool.fragment.b.c.1

            /* renamed from: a */
            private final C2984c f16386a;

            /* renamed from: b */
            private final View f16387b;

            /* renamed from: c */
            private final InterfaceC2995n f16388c;

            {
                this.f16386a = this;
                this.f16387b = view;
                this.f16388c = interfaceC2995n;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                this.f16386a.mo17866a(this.f16387b, this.f16388c);
            }
        });
        imageView.setOnLongClickListener(new View.OnLongClickListener(this, interfaceC2995n) { // from class: ru.maximoff.apktool.fragment.b.c.2

            /* renamed from: a */
            private final C2984c f16389a;

            /* renamed from: b */
            private final InterfaceC2995n f16390b;

            {
                this.f16389a = this;
                this.f16390b = interfaceC2995n;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                this.f16390b.mo17936a(false);
                this.f16389a.f16385c = this.f16390b.mo17970v();
                return true;
            }
        });
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: a */
    public boolean mo17866a(View view, InterfaceC2995n interfaceC2995n) {
        if (this.f16385c) {
            this.f16385c = false;
        } else if (!interfaceC2995n.mo17970v()) {
            interfaceC2995n.mo17934a(this.f16383a.getParentFile());
        }
        return true;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: a */
    public boolean mo17867a(C2981b c2981b) {
        return false;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: b */
    public boolean mo17869b(View view, InterfaceC2995n interfaceC2995n) {
        return false;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: d */
    public String mo17871d() {
        return (String) null;
    }

    @Override // ru.maximoff.apktool.fragment.p302b.InterfaceC2994m
    /* renamed from: e */
    public int mo17872e() {
        return -1;
    }

    /* renamed from: a */
    public int m17862a(InterfaceC2994m interfaceC2994m) {
        return (-1) - interfaceC2994m.mo17872e();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f16383a, new Integer(mo17872e())});
    }
}
