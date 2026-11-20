package com.p129f.p130a.p131a;

import android.icu.text.DateFormat;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.TimeUnit;

/* compiled from: Stopwatch.java */
/* renamed from: com.f.a.a.t */
/* loaded from: classes.dex */
public final class C1125t {

    /* renamed from: a */
    private final AbstractC1130y f7559a = AbstractC1130y.m9600b();

    /* renamed from: b */
    private boolean f7560b;

    /* renamed from: c */
    private long f7561c;

    /* renamed from: d */
    private long f7562d;

    /* renamed from: a */
    public static C1125t m9582a() {
        return new C1125t();
    }

    C1125t() {
    }

    @CanIgnoreReturnValue
    /* renamed from: b */
    public C1125t m9587b() {
        C1120o.m9559b(!this.f7560b, "This stopwatch is already running.");
        this.f7560b = true;
        this.f7562d = this.f7559a.mo9601a();
        return this;
    }

    /* renamed from: c */
    private long m9585c() {
        return this.f7560b ? (this.f7559a.mo9601a() - this.f7562d) + this.f7561c : this.f7561c;
    }

    /* renamed from: a */
    public long m9586a(TimeUnit timeUnit) {
        return timeUnit.convert(m9585c(), TimeUnit.NANOSECONDS);
    }

    public String toString() {
        long m9585c = m9585c();
        return C1119n.m9542a(m9585c / TimeUnit.NANOSECONDS.convert(1L, r2)) + " " + m9584b(m9583a(m9585c));
    }

    /* renamed from: a */
    private static TimeUnit m9583a(long j) {
        if (TimeUnit.DAYS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.DAYS;
        }
        if (TimeUnit.HOURS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.HOURS;
        }
        if (TimeUnit.MINUTES.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MINUTES;
        }
        if (TimeUnit.SECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.SECONDS;
        }
        if (TimeUnit.MILLISECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MILLISECONDS;
        }
        if (TimeUnit.MICROSECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MICROSECONDS;
        }
        return TimeUnit.NANOSECONDS;
    }

    /* renamed from: b */
    private static String m9584b(TimeUnit timeUnit) {
        switch (timeUnit) {
            case NANOSECONDS:
                return "ns";
            case MICROSECONDS:
                return "μs";
            case MILLISECONDS:
                return DateFormat.MINUTE_SECOND;
            case SECONDS:
                return DateFormat.SECOND;
            case MINUTES:
                return "min";
            case HOURS:
                return "h";
            case DAYS:
                return DateFormat.DAY;
            default:
                throw new AssertionError();
        }
    }
}
