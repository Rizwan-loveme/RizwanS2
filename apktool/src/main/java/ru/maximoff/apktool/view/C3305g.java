package ru.maximoff.apktool.view;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.srizwan.apktool.R;
import ru.maximoff.apktool.util.C3078aj;
import ru.maximoff.apktool.util.C3112bn;

/* compiled from: JsInterface.java */
/* renamed from: ru.maximoff.apktool.view.g */
/* loaded from: classes.dex */
public class C3305g {

    /* renamed from: a */
    private Context f21032a;

    public C3305g(Context context) {
        this.f21032a = context;
    }

    @JavascriptInterface
    public void copyETH() {
        C3112bn.m19002a(this.f21032a, "0xeb4eCb14dbF9d7603dA8D6195180006Eb42524f0");
    }

    @JavascriptInterface
    public void copyTON() {
        C3112bn.m19002a(this.f21032a, "UQChsA1V0gdGWt6bx5zRqrVPDYnlmG4OFITnuW0U0dvZaOhv");
    }

    @JavascriptInterface
    public void copyTRC20() {
        C3112bn.m19002a(this.f21032a, "TA2pEiKn56kq3icA2LzvpcWftjRYNpfkPz");
    }

    @JavascriptInterface
    public void copyERC20() {
        C3112bn.m19002a(this.f21032a, "0x689758B9Da7A20452f1aCF30Ba361E84B94202e9");
    }

    @JavascriptInterface
    public void copySOL() {
        C3112bn.m19002a(this.f21032a, "Eip52G1N9p5ZYZfD4zAurqFvNwdViwPzNgJdP5XWofP4");
    }

    @JavascriptInterface
    public void printBuild() {
        StringBuilder sb = new StringBuilder();
        C3112bn.m19010a(sb);
        String sb2 = sb.toString();
        new C3078aj(this.f21032a).m18494a(R.string.minfo).m18496a(sb2).m18497a(true).m18506d(R.string.f21470ok).m18505c(R.string.copy, new Runnable(this, sb2) { // from class: ru.maximoff.apktool.view.g.1

            /* renamed from: a */
            private final C3305g f21033a;

            /* renamed from: b */
            private final String f21034b;

            {
                this.f21033a = this;
                this.f21034b = sb2;
            }

            @Override // java.lang.Runnable
            public void run() {
                C3112bn.m19002a(this.f21033a.f21032a, this.f21034b);
            }
        }).m18507d();
    }
}
