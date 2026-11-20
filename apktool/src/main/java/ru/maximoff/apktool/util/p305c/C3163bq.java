package ru.maximoff.apktool.util.p305c;

import android.content.Context;
import java.io.InputStream;
import org.p217b.p218a.p219a.C1887e;
import p060c.p061a.p062a.AbstractC0549e;
import p060c.p061a.p062a.C0546b;
import p060c.p061a.p062a.C0547c;

/* compiled from: PairipLicense.java */
/* renamed from: ru.maximoff.apktool.util.c.bq */
/* loaded from: classes.dex */
public class C3163bq extends AbstractC3187d {

    /* renamed from: a */
    private boolean f18672a = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Pairip License Check";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18672a;
    }

    /* renamed from: a */
    public void m19103a(InputStream inputStream) {
        try {
            this.f18672a = m19102b(inputStream);
        } catch (Exception e2) {
        }
    }

    /* renamed from: b */
    private boolean m19102b(InputStream inputStream) {
        boolean[] zArr = {false, false};
        new C0546b(C1887e.m13984b(inputStream)).m4018a(new C0547c(this, zArr) { // from class: ru.maximoff.apktool.util.c.bq.1

            /* renamed from: a */
            private final C3163bq f18673a;

            /* renamed from: b */
            private final boolean[] f18674b;

            {
                this.f18673a = this;
                this.f18674b = zArr;
            }

            @Override // p060c.p061a.p062a.AbstractC0549e
            /* renamed from: a */
            public AbstractC0549e mo4019a(String str, String str2) {
                return new AbstractC0549e(this, super.mo4019a(str, str2), this.f18674b) { // from class: ru.maximoff.apktool.util.c.bq.1.1

                    /* renamed from: a */
                    private final AnonymousClass1 f18675a;

                    /* renamed from: b */
                    private final boolean[] f18676b;

                    {
                        this.f18675a = this;
                        this.f18676b = r3;
                    }

                    @Override // p060c.p061a.p062a.AbstractC0549e
                    /* renamed from: a */
                    public AbstractC0549e mo4019a(String str3, String str4) {
                        return str4.equalsIgnoreCase("application") ? new AbstractC0549e(this, super.mo4019a(str3, str4), this.f18676b) { // from class: ru.maximoff.apktool.util.c.bq.1.1.1

                            /* renamed from: a */
                            private final C34381 f18677a;

                            /* renamed from: b */
                            private final boolean[] f18678b;

                            {
                                this.f18677a = this;
                                this.f18678b = r3;
                            }

                            @Override // p060c.p061a.p062a.AbstractC0549e
                            /* renamed from: a */
                            public AbstractC0549e mo4019a(String str5, String str6) {
                                if (str6.equalsIgnoreCase(Context.ACTIVITY_SERVICE)) {
                                    return new AbstractC0549e(this, super.mo4019a(str5, str6), this.f18678b) { // from class: ru.maximoff.apktool.util.c.bq.1.1.1.1

                                        /* renamed from: a */
                                        private final C34391 f18679a;

                                        /* renamed from: b */
                                        private final boolean[] f18680b;

                                        {
                                            this.f18679a = this;
                                            this.f18680b = r3;
                                        }

                                        @Override // p060c.p061a.p062a.AbstractC0549e
                                        /* renamed from: a */
                                        public void mo4032a(String str7, String str8, int i, int i2, Object obj) {
                                            if (str8.equalsIgnoreCase("name") && ((String) obj).equals("com.pairip.licensecheck.LicenseActivity")) {
                                                this.f18680b[0] = true;
                                            }
                                            super.mo4032a(str7, str8, i, i2, obj);
                                        }
                                    };
                                }
                                if (str6.equalsIgnoreCase("provider")) {
                                    return new AbstractC0549e(this, super.mo4019a(str5, str6), this.f18678b) { // from class: ru.maximoff.apktool.util.c.bq.1.1.1.2

                                        /* renamed from: a */
                                        private final C34391 f18681a;

                                        /* renamed from: b */
                                        private final boolean[] f18682b;

                                        {
                                            this.f18681a = this;
                                            this.f18682b = r3;
                                        }

                                        @Override // p060c.p061a.p062a.AbstractC0549e
                                        /* renamed from: a */
                                        public void mo4032a(String str7, String str8, int i, int i2, Object obj) {
                                            if (str8.equalsIgnoreCase("name") && ((String) obj).matches("^com\\.pairip\\.licensecheck\\.LicenseContentProvider(\\d+)?$")) {
                                                this.f18682b[1] = true;
                                            }
                                            super.mo4032a(str7, str8, i, i2, obj);
                                        }
                                    };
                                }
                                return super.mo4019a(str5, str6);
                            }
                        } : super.mo4019a(str3, str4);
                    }
                };
            }
        });
        return zArr[0] || zArr[1];
    }
}
