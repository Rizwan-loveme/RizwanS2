package ru.maximoff.apktool.util;

import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.p008os.Handler;
import android.p008os.Looper;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.widget.C0170al;
import androidx.appcompat.widget.C0173ao;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.p209io.FileFilter;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ru.maximoff.apktool.service.C3056b;

/* compiled from: Player.java */
/* renamed from: ru.maximoff.apktool.util.at */
/* loaded from: classes.dex */
public class C3088at {

    /* renamed from: c */
    private Context f18045c;

    /* renamed from: e */
    private File f18047e;

    /* renamed from: h */
    private MediaPlayer f18050h;

    /* renamed from: i */
    private Handler f18051i;

    /* renamed from: j */
    private TextView f18052j;

    /* renamed from: k */
    private TextView f18053k;

    /* renamed from: l */
    private TextView f18054l;

    /* renamed from: m */
    private SeekBar f18055m;

    /* renamed from: n */
    private Button f18056n;

    /* renamed from: o */
    private boolean f18057o;

    /* renamed from: p */
    private boolean f18058p;

    /* renamed from: s */
    private MediaPlayer.OnCompletionListener f18061s;

    /* renamed from: t */
    private C3056b f18062t;

    /* renamed from: a */
    private final long f18043a = 15;

    /* renamed from: b */
    private final long f18044b = 5000;

    /* renamed from: q */
    private boolean f18059q = false;

    /* renamed from: r */
    private boolean f18060r = false;

    /* renamed from: u */
    private Runnable f18063u = new Runnable(this) { // from class: ru.maximoff.apktool.util.at.9

        /* renamed from: a */
        private final C3088at f18083a;

        {
            this.f18083a = this;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f18083a.f18059q) {
                try {
                    long duration = this.f18083a.f18050h.getDuration();
                    long currentPosition = this.f18083a.f18050h.getCurrentPosition();
                    this.f18083a.f18052j.setText(new StringBuffer().append(new StringBuffer().append(C3080al.m18534a(currentPosition, false)).append(" / ").toString()).append(C3080al.m18534a(duration, false)).toString());
                    this.f18083a.f18055m.setProgress((int) currentPosition);
                    this.f18083a.f18051i.postDelayed(this, 15L);
                } catch (Exception e2) {
                }
            }
        }
    };

    /* renamed from: f */
    private List<File> f18048f = new ArrayList();

    /* renamed from: d */
    private Handler f18046d = new Handler(Looper.getMainLooper());

    /* renamed from: g */
    private int f18049g = 0;

    /* compiled from: Player.java */
    /* renamed from: ru.maximoff.apktool.util.at$b */
    private static class b {

        /* renamed from: a */
        public int f18092a;

        /* renamed from: b */
        public TextView f18093b;

        /* renamed from: c */
        public TextView f18094c;

        /* renamed from: d */
        public TextView f18095d;
    }

    public C3088at(Context context, File file) {
        this.f18045c = context;
        this.f18047e = file;
        this.f18057o = C3102bd.m18925a(this.f18045c, "player_repeat", false);
        this.f18058p = C3102bd.m18925a(this.f18045c, "player_play_row", false);
        this.f18062t = new C3056b(this.f18045c);
        m18683a(this.f18047e.getParentFile());
        this.f18051i = new Handler(Looper.getMainLooper());
        this.f18050h = MediaPlayer.create(this.f18045c, Uri.fromFile(this.f18047e));
        this.f18061s = new MediaPlayer.OnCompletionListener(this) { // from class: ru.maximoff.apktool.util.at.1

            /* renamed from: a */
            private final C3088at f18064a;

            {
                this.f18064a = this;
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (!this.f18064a.f18059q) {
                    try {
                        if (this.f18064a.f18058p) {
                            this.f18064a.f18050h.seekTo(0);
                            this.f18064a.f18055m.setProgress(0);
                            if (this.f18064a.f18048f.size() - this.f18064a.f18049g <= 1 && !this.f18064a.f18057o) {
                                this.f18064a.f18056n.setText(R.string.play);
                            } else {
                                this.f18064a.m18687a(true);
                                this.f18064a.f18050h.start();
                                this.f18064a.f18056n.setText(R.string.pause);
                            }
                        } else {
                            this.f18064a.f18050h.seekTo(0);
                            this.f18064a.f18055m.setProgress(0);
                            if (this.f18064a.f18057o) {
                                this.f18064a.f18050h.start();
                                this.f18064a.f18056n.setText(R.string.pause);
                            } else {
                                this.f18064a.f18056n.setText(R.string.play);
                            }
                        }
                    } catch (Exception e2) {
                    }
                }
            }
        };
        if (this.f18050h != null) {
            this.f18050h.setOnCompletionListener(this.f18061s);
            return;
        }
        String string = this.f18045c.getString(R.string.error);
        C3112bn.m19023b(this.f18045c, string);
        new SpannableString(string).setSpan(new ForegroundColorSpan(C3246h.m19470a(this.f18045c, R.color.dark_red)), 0, string.length(), 33);
    }

    /* renamed from: a */
    private void m18683a(File file) {
        File[] listFiles = file.listFiles(new FileFilter(this) { // from class: ru.maximoff.apktool.util.at.2

            /* renamed from: a */
            private final C3088at f18065a;

            {
                this.f18065a = this;
            }

            @Override // java.p209io.FileFilter
            public boolean accept(File file2) {
                String lowerCase = file2.getName().toLowerCase();
                return file2.isFile() && (lowerCase.endsWith(".mp3") || lowerCase.endsWith(".wav") || lowerCase.endsWith(".ogg") || lowerCase.endsWith(".amr") || lowerCase.endsWith(".awb"));
            }
        });
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        Arrays.sort(listFiles, new C3108bj(this.f18045c, file));
        for (int i = 0; i < listFiles.length; i++) {
            if (this.f18047e.equals(listFiles[i])) {
                this.f18049g = i;
            }
            this.f18048f.add(i, listFiles[i]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m18687a(boolean z) {
        boolean z2;
        if (z) {
            this.f18049g++;
            if (this.f18049g >= this.f18048f.size()) {
                this.f18049g = 0;
            }
        } else {
            this.f18049g--;
            if (this.f18049g < 0) {
                this.f18049g = this.f18048f.size() - 1;
            }
        }
        if (this.f18050h == null || !this.f18050h.isPlaying()) {
            z2 = false;
        } else {
            this.f18050h.stop();
            z2 = true;
        }
        this.f18047e = this.f18048f.get(this.f18049g);
        this.f18053k.setText(this.f18047e.getName());
        this.f18054l.setText(String.format("[%d/%d]", new Integer(this.f18049g + 1), new Integer(this.f18048f.size())));
        try {
            this.f18050h = MediaPlayer.create(this.f18045c, Uri.fromFile(this.f18047e));
        } catch (Exception e2) {
            this.f18050h = (MediaPlayer) null;
        }
        if (this.f18050h != null) {
            this.f18050h.setOnCompletionListener(this.f18061s);
            try {
                if (z2) {
                    this.f18050h.start();
                    this.f18056n.setText(R.string.pause);
                } else {
                    this.f18056n.setText(R.string.play);
                }
                this.f18055m.setProgress(0);
                this.f18055m.setMax(this.f18050h.getDuration());
                this.f18051i.postDelayed(this.f18063u, 15L);
            } catch (Exception e3) {
                String string = this.f18045c.getString(R.string.error);
                C3112bn.m19023b(this.f18045c, string);
                SpannableString spannableString = new SpannableString(string);
                spannableString.setSpan(new ForegroundColorSpan(C3246h.m19470a(this.f18045c, R.color.dark_red)), 0, string.length(), 33);
                this.f18052j.setText(spannableString);
                this.f18056n.setText(R.string.play);
            }
        } else {
            String string2 = this.f18045c.getString(R.string.error);
            C3112bn.m19023b(this.f18045c, string2);
            SpannableString spannableString2 = new SpannableString(string2);
            spannableString2.setSpan(new ForegroundColorSpan(C3246h.m19470a(this.f18045c, R.color.dark_red)), 0, string2.length(), 33);
            this.f18052j.setText(spannableString2);
            this.f18056n.setText(R.string.play);
        }
        if (this.f18060r) {
            this.f18062t.m18199b(this.f18045c.getString(R.string.player), this.f18047e.getName());
        }
    }

    /* renamed from: a */
    public void m18706a() {
        int m19470a;
        View inflate = LayoutInflater.from(this.f18045c).inflate(R.layout.player, (ViewGroup) null);
        this.f18053k = (TextView) inflate.findViewById(R.id.playerTextView1);
        this.f18052j = (TextView) inflate.findViewById(R.id.playerTextView2);
        this.f18055m = (SeekBar) inflate.findViewById(R.id.playerSeekBar1);
        this.f18055m.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(this) { // from class: ru.maximoff.apktool.util.at.3

            /* renamed from: a */
            private boolean f18066a = false;

            /* renamed from: b */
            private final C3088at f18067b;

            {
                this.f18067b = this;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                try {
                    if (this.f18066a) {
                        this.f18067b.f18050h.seekTo(i);
                    }
                } catch (Exception e2) {
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                this.f18066a = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                this.f18066a = false;
            }
        });
        this.f18053k.setText(this.f18047e.getName());
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.playerLinearLayout1);
        Button button = (Button) inflate.findViewById(R.id.playerButton1);
        Button button2 = (Button) inflate.findViewById(R.id.playerButton2);
        this.f18054l = (TextView) inflate.findViewById(R.id.playerTextView3);
        if (this.f18048f.size() > 1) {
            linearLayout.setVisibility(0);
            switch (C3102bd.f18319b) {
                case 1:
                    m19470a = C3246h.m19470a(this.f18045c, R.color.accent_material);
                    break;
                case 2:
                    m19470a = C3246h.m19470a(this.f18045c, R.color.white);
                    break;
                default:
                    m19470a = C3246h.m19470a(this.f18045c, R.color.accent_material_light);
                    break;
            }
            this.f18054l.setTextColor(m19470a);
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this, linearLayout);
            button.setOnClickListener(anonymousClass4);
            button2.setOnClickListener(anonymousClass4);
            this.f18054l.setOnClickListener(anonymousClass4);
            this.f18054l.setText(String.format("[%d/%d]", new Integer(this.f18049g + 1), new Integer(this.f18048f.size())));
        } else {
            linearLayout.setVisibility(8);
        }
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f18045c).m418a(R.string.player).m435b(inflate).m429a(false).m420a(R.string.play, (DialogInterface.OnClickListener) null).m434b(R.string.mshow_more_options, (DialogInterface.OnClickListener) null).m440c(R.string.close_cur, (DialogInterface.OnClickListener) null).m438b();
        m438b.setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: ru.maximoff.apktool.util.at.5

            /* renamed from: a */
            private final C3088at f18072a;

            {
                this.f18072a = this;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                    return false;
                }
                dialogInterface.cancel();
                return true;
            }
        });
        m438b.setOnShowListener(new AnonymousClass6(this, m438b));
        m438b.setOnCancelListener(new DialogInterface.OnCancelListener(this) { // from class: ru.maximoff.apktool.util.at.7

            /* renamed from: a */
            private final C3088at f18081a;

            {
                this.f18081a = this;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                this.f18081a.f18059q = true;
                try {
                    if (this.f18081a.f18050h.isPlaying()) {
                        this.f18081a.f18050h.stop();
                    }
                    if (this.f18081a.f18046d != null) {
                        this.f18081a.f18046d.removeCallbacksAndMessages((Object) null);
                    }
                    if (this.f18081a.f18060r) {
                        this.f18081a.f18060r = false;
                        this.f18081a.f18062t.m18200b(5017);
                    }
                } catch (Exception e2) {
                }
            }
        });
        m438b.show();
        this.f18046d.postDelayed(new Runnable(this) { // from class: ru.maximoff.apktool.util.at.8

            /* renamed from: a */
            private final C3088at f18082a;

            {
                this.f18082a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f18082a.m18707b();
            }
        }, 5000L);
    }

    /* compiled from: Player.java */
    /* renamed from: ru.maximoff.apktool.util.at$4, reason: invalid class name */
    class AnonymousClass4 implements View.OnClickListener {

        /* renamed from: a */
        private final C3088at f18068a;

        /* renamed from: b */
        private final LinearLayout f18069b;

        AnonymousClass4(C3088at c3088at, LinearLayout linearLayout) {
            this.f18068a = c3088at;
            this.f18069b = linearLayout;
        }

        /* renamed from: a */
        static C3088at m18708a(AnonymousClass4 anonymousClass4) {
            return anonymousClass4.f18068a;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 0;
            switch (view.getId()) {
                case R.id.playerButton1 /* 2131689951 */:
                    this.f18068a.m18687a(false);
                    break;
                case R.id.playerTextView3 /* 2131689952 */:
                    ArrayList arrayList = new ArrayList();
                    while (true) {
                        int i2 = i;
                        if (i2 < this.f18068a.f18048f.size()) {
                            arrayList.add(((File) this.f18068a.f18048f.get(i2)).getName());
                            i = i2 + 1;
                        } else {
                            C0170al c0170al = new C0170al(this.f18068a.f18045c);
                            a aVar = new a(this.f18068a, this.f18068a.f18045c, c0170al, arrayList);
                            c0170al.m1320b(this.f18069b);
                            c0170al.m1325f(3);
                            c0170al.mo1314a(aVar);
                            c0170al.m1327h(-1);
                            c0170al.m1326g(-1);
                            c0170al.m1316a(true);
                            c0170al.mo841b_();
                            c0170al.mo846e().post(new Runnable(this, c0170al) { // from class: ru.maximoff.apktool.util.at.4.1

                                /* renamed from: a */
                                private final AnonymousClass4 f18070a;

                                /* renamed from: b */
                                private final C0170al f18071b;

                                {
                                    this.f18070a = this;
                                    this.f18071b = c0170al;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    this.f18071b.mo846e().setSelection(AnonymousClass4.m18708a(this.f18070a).f18049g);
                                }
                            });
                            break;
                        }
                    }
                case R.id.playerButton2 /* 2131689953 */:
                    this.f18068a.m18687a(true);
                    break;
            }
        }
    }

    /* compiled from: Player.java */
    /* renamed from: ru.maximoff.apktool.util.at$6, reason: invalid class name */
    class AnonymousClass6 implements DialogInterface.OnShowListener {

        /* renamed from: a */
        private final C3088at f18073a;

        /* renamed from: b */
        private final DialogInterfaceC0070b f18074b;

        AnonymousClass6(C3088at c3088at, DialogInterfaceC0070b dialogInterfaceC0070b) {
            this.f18073a = c3088at;
            this.f18074b = dialogInterfaceC0070b;
        }

        /* renamed from: a */
        static C3088at m18709a(AnonymousClass6 anonymousClass6) {
            return anonymousClass6.f18073a;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            this.f18073a.f18056n = this.f18074b.m414a(-1);
            this.f18073a.f18056n.setOnClickListener(new View.OnClickListener(this) { // from class: ru.maximoff.apktool.util.at.6.1

                /* renamed from: a */
                private final AnonymousClass6 f18075a;

                {
                    this.f18075a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        if (AnonymousClass6.m18709a(this.f18075a).f18050h.isPlaying()) {
                            AnonymousClass6.m18709a(this.f18075a).f18050h.pause();
                            AnonymousClass6.m18709a(this.f18075a).f18056n.setText(R.string.play);
                        } else {
                            AnonymousClass6.m18709a(this.f18075a).f18050h.start();
                            AnonymousClass6.m18709a(this.f18075a).f18056n.setText(R.string.pause);
                        }
                    } catch (Exception e2) {
                        String string = AnonymousClass6.m18709a(this.f18075a).f18045c.getString(R.string.error);
                        C3112bn.m19023b(AnonymousClass6.m18709a(this.f18075a).f18045c, string);
                        SpannableString spannableString = new SpannableString(string);
                        spannableString.setSpan(new ForegroundColorSpan(C3246h.m19470a(AnonymousClass6.m18709a(this.f18075a).f18045c, R.color.dark_red)), 0, string.length(), 33);
                        AnonymousClass6.m18709a(this.f18075a).f18052j.setText(spannableString);
                        AnonymousClass6.m18709a(this.f18075a).f18056n.setText(R.string.play);
                    }
                }
            });
            this.f18074b.m414a(-2).setOnClickListener(new AnonymousClass2(this));
            this.f18074b.m414a(-3).setOnClickListener(new View.OnClickListener(this, this.f18074b) { // from class: ru.maximoff.apktool.util.at.6.3

                /* renamed from: a */
                private final AnonymousClass6 f18079a;

                /* renamed from: b */
                private final DialogInterfaceC0070b f18080b;

                {
                    this.f18079a = this;
                    this.f18080b = r2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f18080b.cancel();
                }
            });
            try {
                this.f18073a.f18050h.start();
                this.f18073a.f18055m.setProgress(0);
                this.f18073a.f18055m.setMax(this.f18073a.f18050h.getDuration());
                this.f18073a.f18051i.postDelayed(this.f18073a.f18063u, 15L);
                this.f18073a.f18056n.setText(R.string.pause);
            } catch (Exception e2) {
                String string = this.f18073a.f18045c.getString(R.string.error);
                C3112bn.m19023b(this.f18073a.f18045c, string);
                SpannableString spannableString = new SpannableString(string);
                spannableString.setSpan(new ForegroundColorSpan(C3246h.m19470a(this.f18073a.f18045c, R.color.dark_red)), 0, string.length(), 33);
                this.f18073a.f18052j.setText(spannableString);
                this.f18073a.f18056n.setText(R.string.play);
            }
        }

        /* compiled from: Player.java */
        /* renamed from: ru.maximoff.apktool.util.at$6$2, reason: invalid class name */
        class AnonymousClass2 implements View.OnClickListener {

            /* renamed from: a */
            private final AnonymousClass6 f18076a;

            AnonymousClass2(AnonymousClass6 anonymousClass6) {
                this.f18076a = anonymousClass6;
            }

            /* renamed from: a */
            static AnonymousClass6 m18710a(AnonymousClass2 anonymousClass2) {
                return anonymousClass2.f18076a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                C0173ao c0173ao = new C0173ao(AnonymousClass6.m18709a(this.f18076a).f18045c, view);
                if (C3102bd.m18910a(AnonymousClass6.m18709a(this.f18076a).f18045c, "menu_position", "1").equals("0")) {
                    i = 3;
                } else {
                    i = 5;
                }
                c0173ao.m1340a(i);
                MenuItem add = c0173ao.m1339a().add(0, Types.OTHER, 0, R.string.repeat);
                add.setCheckable(true);
                add.setChecked(AnonymousClass6.m18709a(this.f18076a).f18057o);
                add.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: ru.maximoff.apktool.util.at.6.2.1

                    /* renamed from: a */
                    private final AnonymousClass2 f18077a;

                    {
                        this.f18077a = this;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        AnonymousClass6.m18709a(AnonymousClass2.m18710a(this.f18077a)).f18057o = !AnonymousClass6.m18709a(AnonymousClass2.m18710a(this.f18077a)).f18057o;
                        C3102bd.m18938b(AnonymousClass6.m18709a(AnonymousClass2.m18710a(this.f18077a)).f18045c, "player_repeat", AnonymousClass6.m18709a(AnonymousClass2.m18710a(this.f18077a)).f18057o);
                        return true;
                    }
                });
                MenuItem add2 = c0173ao.m1339a().add(0, 1121, 0, R.string.play_row);
                add2.setCheckable(true);
                add2.setChecked(AnonymousClass6.m18709a(this.f18076a).f18058p);
                add2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: ru.maximoff.apktool.util.at.6.2.2

                    /* renamed from: a */
                    private final AnonymousClass2 f18078a;

                    {
                        this.f18078a = this;
                    }

                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        AnonymousClass6.m18709a(AnonymousClass2.m18710a(this.f18078a)).f18058p = !AnonymousClass6.m18709a(AnonymousClass2.m18710a(this.f18078a)).f18058p;
                        C3102bd.m18938b(AnonymousClass6.m18709a(AnonymousClass2.m18710a(this.f18078a)).f18045c, "player_play_row", AnonymousClass6.m18709a(AnonymousClass2.m18710a(this.f18078a)).f18058p);
                        return true;
                    }
                });
                c0173ao.m1344c();
            }
        }
    }

    /* renamed from: b */
    public void m18707b() {
        String name = this.f18047e.getName();
        CharSequence text = this.f18045c.getText(R.string.player);
        this.f18062t.m18202c(true);
        this.f18062t.m18201b(true);
        this.f18062t.m18194a(5017);
        this.f18062t.m18197a("player_notification");
        this.f18062t.m18195a(text, text);
        this.f18062t.m18192a(text.toString(), name);
        this.f18060r = true;
    }

    /* compiled from: Player.java */
    /* renamed from: ru.maximoff.apktool.util.at$a */
    private class a extends BaseAdapter {

        /* renamed from: a */
        private Context f18084a;

        /* renamed from: b */
        private C0170al f18085b;

        /* renamed from: c */
        private List<String> f18086c;

        /* renamed from: d */
        private final C3088at f18087d;

        /* renamed from: c */
        static C3088at m18713c(a aVar) {
            return aVar.f18087d;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return m18714a(i);
        }

        public a(C3088at c3088at, Context context, C0170al c0170al, List<String> list) {
            this.f18087d = c3088at;
            this.f18084a = context;
            this.f18085b = c0170al;
            this.f18086c = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f18086c != null) {
                return this.f18086c.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        /* renamed from: a */
        public String m18714a(int i) {
            return this.f18086c != null ? this.f18086c.get(i) : (String) null;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = ((LayoutInflater) this.f18084a.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.history_item, (ViewGroup) null);
                bVar = new b();
                bVar.f18093b = (TextView) view.findViewById(R.id.historyitemTextView1);
                bVar.f18094c = (TextView) view.findViewById(R.id.historyitemTextView3);
                bVar.f18095d = (TextView) view.findViewById(R.id.historyitemTextView2);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.f18095d.setVisibility(8);
            bVar.f18094c.setVisibility(8);
            bVar.f18092a = i;
            String str = this.f18086c.get(i);
            if (str != null) {
                if (i == this.f18087d.f18049g) {
                    view.setBackgroundColor(C3246h.m19470a(this.f18084a, C3102bd.f18291a ? R.color.tvery_light_grey2 : R.color.tvery_light_grey));
                } else {
                    view.setBackgroundColor(0);
                }
                bVar.f18093b.setTextSize(2, C3102bd.f18332o);
                bVar.f18093b.setText(str);
                bVar.f18093b.setOnClickListener(new View.OnClickListener(this, i) { // from class: ru.maximoff.apktool.util.at.a.1

                    /* renamed from: a */
                    private final a f18088a;

                    /* renamed from: b */
                    private final int f18089b;

                    {
                        this.f18088a = this;
                        this.f18089b = i;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        this.f18088a.f18085b.mo842c();
                        a.m18713c(this.f18088a).f18049g = this.f18089b + 1;
                        a.m18713c(this.f18088a).m18687a(false);
                    }
                });
                bVar.f18093b.setOnLongClickListener(new View.OnLongClickListener(this, str) { // from class: ru.maximoff.apktool.util.at.a.2

                    /* renamed from: a */
                    private final a f18090a;

                    /* renamed from: b */
                    private final String f18091b;

                    {
                        this.f18090a = this;
                        this.f18091b = str;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view2) {
                        if (C3102bd.m18925a(this.f18090a.f18084a, "copy_with_ext", false)) {
                            String[] m19641b = C3262u.m19641b(this.f18091b);
                            if (this.f18091b.toLowerCase().endsWith(".9.png")) {
                                C3112bn.m19002a(this.f18090a.f18084a, m19641b[0].substring(0, m19641b[0].length() - 2));
                                return true;
                            }
                            C3112bn.m19002a(this.f18090a.f18084a, m19641b[0]);
                            return true;
                        }
                        C3112bn.m19002a(this.f18090a.f18084a, this.f18091b);
                        return true;
                    }
                });
            }
            return view;
        }
    }
}
