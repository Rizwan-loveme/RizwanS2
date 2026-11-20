package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.p006pm.PackageManager;
import android.p008os.Bundle;
import android.util.Log;
import androidx.core.content.C0255a;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TaskStackBuilder.java */
/* renamed from: androidx.core.app.n */
/* loaded from: classes.dex */
public final class C0243n implements Iterable<Intent> {

    /* renamed from: a */
    private final ArrayList<Intent> f1955a = new ArrayList<>();

    /* renamed from: b */
    private final Context f1956b;

    /* compiled from: TaskStackBuilder.java */
    /* renamed from: androidx.core.app.n$a */
    public interface a {
        /* renamed from: i */
        Intent mo457i();
    }

    private C0243n(Context context) {
        this.f1956b = context;
    }

    /* renamed from: a */
    public static C0243n m1783a(Context context) {
        return new C0243n(context);
    }

    /* renamed from: a */
    public C0243n m1786a(Intent intent) {
        this.f1955a.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public C0243n m1784a(Activity activity) {
        Intent intent = null;
        if (activity instanceof a) {
            intent = ((a) activity).mo457i();
        }
        Intent m1699a = intent == null ? C0235f.m1699a(activity) : intent;
        if (m1699a != null) {
            ComponentName component = m1699a.getComponent();
            if (component == null) {
                component = m1699a.resolveActivity(this.f1956b.getPackageManager());
            }
            m1785a(component);
            m1786a(m1699a);
        }
        return this;
    }

    /* renamed from: a */
    public C0243n m1785a(ComponentName componentName) {
        int size = this.f1955a.size();
        try {
            Intent m1700a = C0235f.m1700a(this.f1956b, componentName);
            while (m1700a != null) {
                this.f1955a.add(size, m1700a);
                m1700a = C0235f.m1700a(this.f1956b, m1700a.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.m184e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e2);
        }
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f1955a.iterator();
    }

    /* renamed from: a */
    public void m1787a() {
        m1788a((Bundle) null);
    }

    /* renamed from: a */
    public void m1788a(Bundle bundle) {
        if (this.f1955a.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f1955a.toArray(new Intent[this.f1955a.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (!C0255a.m1849a(this.f1956b, intentArr, bundle)) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.f1956b.startActivity(intent);
        }
    }
}
