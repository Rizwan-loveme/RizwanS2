package com.p129f.p130a.p138h.p139a;

import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.j2objc.annotations.ReflectionSupport;
import com.p129f.p130a.p131a.C1120o;
import com.p129f.p130a.p131a.C1129x;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;

/* compiled from: AbstractFuture.java */
@ReflectionSupport(ReflectionSupport.Level.FULL)
/* renamed from: com.f.a.h.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC1222a<V> extends InternalFutureFailureAccess implements InterfaceFutureC1231j<V> {

    /* renamed from: a */
    private static final boolean f7985a = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: b */
    private static final Logger f7986b = Logger.getLogger(AbstractC1222a.class.getName());

    /* renamed from: c */
    private static final a f7987c;

    /* renamed from: d */
    private static final Object f7988d;

    /* renamed from: e */
    @NullableDecl
    private volatile Object f7989e;

    /* renamed from: f */
    @NullableDecl
    private volatile d f7990f;

    /* renamed from: g */
    @NullableDecl
    private volatile k f7991g;

    /* compiled from: AbstractFuture.java */
    /* renamed from: com.f.a.h.a.a$h */
    interface h<V> extends InterfaceFutureC1231j<V> {
    }

    static {
        a gVar;
        Throwable th;
        Throwable th2;
        try {
            th = null;
            th2 = null;
            gVar = new j();
        } catch (Throwable th3) {
            try {
                th = null;
                th2 = th3;
                gVar = new e(AtomicReferenceFieldUpdater.newUpdater(k.class, Thread.class, "b"), AtomicReferenceFieldUpdater.newUpdater(k.class, k.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractC1222a.class, k.class, "g"), AtomicReferenceFieldUpdater.newUpdater(AbstractC1222a.class, d.class, "f"), AtomicReferenceFieldUpdater.newUpdater(AbstractC1222a.class, Object.class, "e"));
            } catch (Throwable th4) {
                gVar = new g();
                th = th4;
                th2 = th3;
            }
        }
        f7987c = gVar;
        if (th != null) {
            f7986b.log(Level.SEVERE, "UnsafeAtomicHelper is broken!", th2);
            f7986b.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f7988d = new Object();
    }

    /* compiled from: AbstractFuture.java */
    /* renamed from: com.f.a.h.a.a$i */
    static abstract class i<V> extends AbstractC1222a<V> implements h<V> {
        i() {
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final V get() {
            return (V) super.get();
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final V get(long j, TimeUnit timeUnit) {
            return (V) super.get(j, timeUnit);
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a, com.p129f.p130a.p138h.p139a.InterfaceFutureC1231j
        /* renamed from: a */
        public final void mo10200a(Runnable runnable, Executor executor) {
            super.mo10200a(runnable, executor);
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final boolean cancel(boolean z) {
            return super.cancel(z);
        }
    }

    /* compiled from: AbstractFuture.java */
    /* renamed from: com.f.a.h.a.a$k */
    private static final class k {

        /* renamed from: a */
        static final k f8015a = new k(false);

        /* renamed from: b */
        @NullableDecl
        volatile Thread f8016b;

        /* renamed from: c */
        @NullableDecl
        volatile k f8017c;

        k(boolean z) {
        }

        k() {
            AbstractC1222a.f7987c.mo10210a(this, Thread.currentThread());
        }

        /* renamed from: a */
        void m10216a(k kVar) {
            AbstractC1222a.f7987c.mo10209a(this, kVar);
        }

        /* renamed from: a */
        void m10215a() {
            Thread thread = this.f8016b;
            if (thread != null) {
                this.f8016b = null;
                LockSupport.unpark(thread);
            }
        }
    }

    /* renamed from: a */
    private void m10184a(k kVar) {
        kVar.f8016b = null;
        while (true) {
            k kVar2 = this.f7991g;
            if (kVar2 != k.f8015a) {
                k kVar3 = null;
                while (kVar2 != null) {
                    k kVar4 = kVar2.f8017c;
                    if (kVar2.f8016b != null) {
                        kVar3 = kVar2;
                    } else if (kVar3 != null) {
                        kVar3.f8017c = kVar4;
                        if (kVar3.f8016b == null) {
                            break;
                        }
                    } else if (!f7987c.mo10212a((AbstractC1222a<?>) this, kVar2, kVar4)) {
                        break;
                    }
                    kVar2 = kVar4;
                }
                return;
            }
            return;
        }
    }

    /* compiled from: AbstractFuture.java */
    /* renamed from: com.f.a.h.a.a$d */
    private static final class d {

        /* renamed from: a */
        static final d f7998a = new d(null, null);

        /* renamed from: b */
        final Runnable f7999b;

        /* renamed from: c */
        final Executor f8000c;

        /* renamed from: d */
        @NullableDecl
        d f8001d;

        d(Runnable runnable, Executor executor) {
            this.f7999b = runnable;
            this.f8000c = executor;
        }
    }

    /* compiled from: AbstractFuture.java */
    /* renamed from: com.f.a.h.a.a$c */
    private static final class c {

        /* renamed from: a */
        static final c f7996a = new c(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.f.a.h.a.a.c.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: b */
        final Throwable f7997b;

        c(Throwable th) {
            this.f7997b = (Throwable) C1120o.m9547a(th);
        }
    }

    /* compiled from: AbstractFuture.java */
    /* renamed from: com.f.a.h.a.a$b */
    private static final class b {

        /* renamed from: a */
        static final b f7992a;

        /* renamed from: b */
        static final b f7993b;

        /* renamed from: c */
        final boolean f7994c;

        /* renamed from: d */
        @NullableDecl
        final Throwable f7995d;

        static {
            if (AbstractC1222a.f7985a) {
                f7993b = null;
                f7992a = null;
            } else {
                f7993b = new b(false, null);
                f7992a = new b(true, null);
            }
        }

        b(boolean z, @NullableDecl Throwable th) {
            this.f7994c = z;
            this.f7995d = th;
        }
    }

    /* compiled from: AbstractFuture.java */
    /* renamed from: com.f.a.h.a.a$f */
    private static final class f<V> implements Runnable {

        /* renamed from: a */
        final AbstractC1222a<V> f8007a;

        /* renamed from: b */
        final InterfaceFutureC1231j<? extends V> f8008b;

        f(AbstractC1222a<V> abstractC1222a, InterfaceFutureC1231j<? extends V> interfaceFutureC1231j) {
            this.f8007a = abstractC1222a;
            this.f8008b = interfaceFutureC1231j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((AbstractC1222a) this.f8007a).f7989e == this) {
                if (AbstractC1222a.f7987c.mo10213a((AbstractC1222a<?>) this.f8007a, (Object) this, AbstractC1222a.m10192c((InterfaceFutureC1231j<?>) this.f8008b))) {
                    AbstractC1222a.m10195e(this.f8007a);
                }
            }
        }
    }

    protected AbstractC1222a() {
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    public V get(long j2, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j2);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f7989e;
        if ((obj != null) & (!(obj instanceof f))) {
            return m10187b(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            k kVar = this.f7991g;
            if (kVar != k.f8015a) {
                k kVar2 = new k();
                do {
                    kVar2.m10216a(kVar);
                    if (f7987c.mo10212a((AbstractC1222a<?>) this, kVar, kVar2)) {
                        long j3 = nanos;
                        do {
                            LockSupport.parkNanos(this, j3);
                            if (Thread.interrupted()) {
                                m10184a(kVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f7989e;
                            if ((obj2 != null) & (!(obj2 instanceof f))) {
                                return m10187b(obj2);
                            }
                            j3 = nanoTime - System.nanoTime();
                        } while (j3 >= 1000);
                        m10184a(kVar2);
                        nanos = j3;
                    } else {
                        kVar = this.f7991g;
                    }
                } while (kVar != k.f8015a);
            }
            return m10187b(this.f7989e);
        }
        while (nanos > 0) {
            Object obj3 = this.f7989e;
            if ((obj3 != null) & (!(obj3 instanceof f))) {
                return m10187b(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String m10207d = m10207d();
        String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
        String str = "Waited " + j2 + " " + timeUnit.toString().toLowerCase(Locale.ROOT);
        if (1000 + nanos < 0) {
            String str2 = str + " (plus ";
            long j4 = -nanos;
            long convert = timeUnit.convert(j4, TimeUnit.NANOSECONDS);
            long nanos2 = j4 - timeUnit.toNanos(convert);
            boolean z = convert == 0 || nanos2 > 1000;
            if (convert > 0) {
                String str3 = str2 + convert + " " + lowerCase;
                if (z) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + m10207d);
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    public V get() {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f7989e;
        if ((obj2 != null) & (!(obj2 instanceof f))) {
            return m10187b(obj2);
        }
        k kVar = this.f7991g;
        if (kVar != k.f8015a) {
            k kVar2 = new k();
            do {
                kVar2.m10216a(kVar);
                if (f7987c.mo10212a((AbstractC1222a<?>) this, kVar, kVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            m10184a(kVar2);
                            throw new InterruptedException();
                        }
                        obj = this.f7989e;
                    } while (!((obj != null) & (!(obj instanceof f))));
                    return m10187b(obj);
                }
                kVar = this.f7991g;
            } while (kVar != k.f8015a);
        }
        return m10187b(this.f7989e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    private V m10187b(Object obj) {
        if (obj instanceof b) {
            throw m10183a("Task was cancelled.", ((b) obj).f7995d);
        }
        if (obj instanceof c) {
            throw new ExecutionException(((c) obj).f7997b);
        }
        if (obj == f7988d) {
            return null;
        }
        return obj;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object obj = this.f7989e;
        return (obj != null) & (obj instanceof f ? false : true);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f7989e instanceof b;
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    public boolean cancel(boolean z) {
        b bVar;
        Object obj = this.f7989e;
        if (!(obj == null) && !(obj instanceof f)) {
            return false;
        }
        if (f7985a) {
            bVar = new b(z, new CancellationException("Future.cancel() was called."));
        } else {
            bVar = z ? b.f7992a : b.f7993b;
        }
        boolean z2 = false;
        Object obj2 = obj;
        while (true) {
            if (f7987c.mo10213a((AbstractC1222a<?>) this, obj2, (Object) bVar)) {
                if (z) {
                    this.m10199a();
                }
                m10195e(this);
                if (!(obj2 instanceof f)) {
                    return true;
                }
                InterfaceFutureC1231j<? extends V> interfaceFutureC1231j = ((f) obj2).f8008b;
                if (interfaceFutureC1231j instanceof h) {
                    AbstractC1222a<V> abstractC1222a = (AbstractC1222a) interfaceFutureC1231j;
                    obj2 = abstractC1222a.f7989e;
                    if (!(obj2 == null) && !(obj2 instanceof f)) {
                        return true;
                    }
                    this = abstractC1222a;
                    z2 = true;
                } else {
                    interfaceFutureC1231j.cancel(z);
                    return true;
                }
            } else {
                obj2 = this.f7989e;
                if (!(obj2 instanceof f)) {
                    return z2;
                }
            }
        }
    }

    /* renamed from: a */
    protected void m10199a() {
    }

    /* renamed from: b */
    protected final boolean m10205b() {
        Object obj = this.f7989e;
        return (obj instanceof b) && ((b) obj).f7994c;
    }

    @Override // com.p129f.p130a.p138h.p139a.InterfaceFutureC1231j
    /* renamed from: a */
    public void mo10200a(Runnable runnable, Executor executor) {
        d dVar;
        C1120o.m9548a(runnable, "Runnable was null.");
        C1120o.m9548a(executor, "Executor was null.");
        if (!isDone() && (dVar = this.f7990f) != d.f7998a) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.f8001d = dVar;
                if (!f7987c.mo10211a((AbstractC1222a<?>) this, dVar, dVar2)) {
                    dVar = this.f7990f;
                } else {
                    return;
                }
            } while (dVar != d.f7998a);
        }
        m10190b(runnable, executor);
    }

    @CanIgnoreReturnValue
    /* renamed from: a */
    protected boolean mo10203a(@NullableDecl V v) {
        if (v == null) {
            v = (V) f7988d;
        }
        if (!f7987c.mo10213a((AbstractC1222a<?>) this, (Object) null, (Object) v)) {
            return false;
        }
        m10195e(this);
        return true;
    }

    @CanIgnoreReturnValue
    /* renamed from: a */
    protected boolean mo10204a(Throwable th) {
        if (!f7987c.mo10213a((AbstractC1222a<?>) this, (Object) null, (Object) new c((Throwable) C1120o.m9547a(th)))) {
            return false;
        }
        m10195e(this);
        return true;
    }

    @CanIgnoreReturnValue
    /* renamed from: a */
    protected boolean mo10202a(InterfaceFutureC1231j<? extends V> interfaceFutureC1231j) {
        c cVar;
        C1120o.m9547a(interfaceFutureC1231j);
        Object obj = this.f7989e;
        if (obj == null) {
            if (interfaceFutureC1231j.isDone()) {
                if (!f7987c.mo10213a((AbstractC1222a<?>) this, (Object) null, m10192c((InterfaceFutureC1231j<?>) interfaceFutureC1231j))) {
                    return false;
                }
                m10195e(this);
                return true;
            }
            f fVar = new f(this, interfaceFutureC1231j);
            if (f7987c.mo10213a((AbstractC1222a<?>) this, (Object) null, (Object) fVar)) {
                try {
                    interfaceFutureC1231j.mo10200a(fVar, EnumC1224c.INSTANCE);
                } catch (Throwable th) {
                    try {
                        cVar = new c(th);
                    } catch (Throwable th2) {
                        cVar = c.f7996a;
                    }
                    f7987c.mo10213a((AbstractC1222a<?>) this, (Object) fVar, (Object) cVar);
                }
                return true;
            }
            obj = this.f7989e;
        }
        if (obj instanceof b) {
            interfaceFutureC1231j.cancel(((b) obj).f7994c);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static Object m10192c(InterfaceFutureC1231j<?> interfaceFutureC1231j) {
        Throwable tryInternalFastPathGetFailure;
        if (interfaceFutureC1231j instanceof h) {
            Object obj = ((AbstractC1222a) interfaceFutureC1231j).f7989e;
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (bVar.f7994c) {
                    return bVar.f7995d != null ? new b(false, bVar.f7995d) : b.f7993b;
                }
                return obj;
            }
            return obj;
        }
        if ((interfaceFutureC1231j instanceof InternalFutureFailureAccess) && (tryInternalFastPathGetFailure = InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess) interfaceFutureC1231j)) != null) {
            return new c(tryInternalFastPathGetFailure);
        }
        boolean isCancelled = interfaceFutureC1231j.isCancelled();
        if ((!f7985a) & isCancelled) {
            return b.f7993b;
        }
        try {
            Object m10188b = m10188b((Future<Object>) interfaceFutureC1231j);
            if (isCancelled) {
                return new b(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + interfaceFutureC1231j));
            }
            if (m10188b == null) {
                m10188b = f7988d;
            }
            return m10188b;
        } catch (CancellationException e2) {
            if (!isCancelled) {
                return new c(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + interfaceFutureC1231j, e2));
            }
            return new b(false, e2);
        } catch (ExecutionException e3) {
            if (isCancelled) {
                return new b(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + interfaceFutureC1231j, e3));
            }
            return new c(e3.getCause());
        } catch (Throwable th) {
            return new c(th);
        }
    }

    /* renamed from: b */
    private static <V> V m10188b(Future<V> future) {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException e2) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static void m10195e(AbstractC1222a<?> abstractC1222a) {
        d dVar;
        d dVar2 = null;
        while (true) {
            abstractC1222a.m10198h();
            abstractC1222a.mo10206c();
            d m10178a = abstractC1222a.m10178a(dVar2);
            while (m10178a != null) {
                dVar = m10178a.f8001d;
                Runnable runnable = m10178a.f7999b;
                if (runnable instanceof f) {
                    f fVar = (f) runnable;
                    abstractC1222a = fVar.f8007a;
                    if (((AbstractC1222a) abstractC1222a).f7989e == fVar) {
                        if (f7987c.mo10213a((AbstractC1222a<?>) abstractC1222a, (Object) fVar, m10192c((InterfaceFutureC1231j<?>) fVar.f8008b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    m10190b(runnable, m10178a.f8000c);
                }
                m10178a = dVar;
            }
            return;
            dVar2 = dVar;
        }
    }

    @ForOverride
    /* renamed from: c */
    protected void mo10206c() {
    }

    /* renamed from: a */
    final void m10201a(@NullableDecl Future<?> future) {
        if ((future != null) & isCancelled()) {
            future.cancel(m10205b());
        }
    }

    /* renamed from: h */
    private void m10198h() {
        k kVar;
        do {
            kVar = this.f7991g;
        } while (!f7987c.mo10212a((AbstractC1222a<?>) this, kVar, k.f8015a));
        while (kVar != null) {
            kVar.m10215a();
            kVar = kVar.f8017c;
        }
    }

    /* renamed from: a */
    private d m10178a(d dVar) {
        d dVar2;
        do {
            dVar2 = this.f7990f;
        } while (!f7987c.mo10211a((AbstractC1222a<?>) this, dVar2, d.f7998a));
        while (dVar2 != null) {
            d dVar3 = dVar2.f8001d;
            dVar2.f8001d = dVar;
            dVar = dVar2;
            dVar2 = dVar3;
        }
        return dVar;
    }

    /* renamed from: d */
    public String m10207d() {
        String str;
        StringBuilder append = new StringBuilder().append(super.toString()).append("[status=");
        if (isCancelled()) {
            append.append("CANCELLED");
        } else if (isDone()) {
            m10185a(append);
        } else {
            try {
                str = mo10208e();
            } catch (RuntimeException e2) {
                str = "Exception thrown from implementation: " + e2.getClass();
            }
            if (str != null && !str.isEmpty()) {
                append.append("PENDING, info=[").append(str).append("]");
            } else if (isDone()) {
                m10185a(append);
            } else {
                append.append("PENDING");
            }
        }
        return append.append("]").toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NullableDecl
    /* renamed from: e */
    protected String mo10208e() {
        Object obj = this.f7989e;
        if (obj instanceof f) {
            return "setFuture=[" + m10193c((Object) ((f) obj).f8008b) + "]";
        }
        if (this instanceof ScheduledFuture) {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
        return null;
    }

    /* renamed from: a */
    private void m10185a(StringBuilder sb) {
        try {
            sb.append("SUCCESS, result=[").append(m10193c(m10188b((Future) this))).append("]");
        } catch (CancellationException e2) {
            sb.append("CANCELLED");
        } catch (RuntimeException e3) {
            sb.append("UNKNOWN, cause=[").append(e3.getClass()).append(" thrown from get()]");
        } catch (ExecutionException e4) {
            sb.append("FAILURE, cause=[").append(e4.getCause()).append("]");
        }
    }

    /* renamed from: c */
    private String m10193c(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    /* renamed from: b */
    private static void m10190b(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            f7986b.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    /* compiled from: AbstractFuture.java */
    /* renamed from: com.f.a.h.a.a$a */
    private static abstract class a {
        /* renamed from: a */
        abstract void mo10209a(k kVar, k kVar2);

        /* renamed from: a */
        abstract void mo10210a(k kVar, Thread thread);

        /* renamed from: a */
        abstract boolean mo10211a(AbstractC1222a<?> abstractC1222a, d dVar, d dVar2);

        /* renamed from: a */
        abstract boolean mo10212a(AbstractC1222a<?> abstractC1222a, k kVar, k kVar2);

        /* renamed from: a */
        abstract boolean mo10213a(AbstractC1222a<?> abstractC1222a, Object obj, Object obj2);

        private a() {
        }
    }

    /* compiled from: AbstractFuture.java */
    /* renamed from: com.f.a.h.a.a$j */
    private static final class j extends a {

        /* renamed from: a */
        static final Unsafe f8009a;

        /* renamed from: b */
        static final long f8010b;

        /* renamed from: c */
        static final long f8011c;

        /* renamed from: d */
        static final long f8012d;

        /* renamed from: e */
        static final long f8013e;

        /* renamed from: f */
        static final long f8014f;

        private j() {
            super();
        }

        static {
            Unsafe unsafe;
            try {
                unsafe = Unsafe.getUnsafe();
            } catch (SecurityException e2) {
                try {
                    unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.f.a.h.a.a.j.1
                        @Override // java.security.PrivilegedExceptionAction
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public Unsafe run() {
                            for (Field field : Unsafe.class.getDeclaredFields()) {
                                field.setAccessible(true);
                                Object obj = field.get(null);
                                if (Unsafe.class.isInstance(obj)) {
                                    return (Unsafe) Unsafe.class.cast(obj);
                                }
                            }
                            throw new NoSuchFieldError("the Unsafe");
                        }
                    });
                } catch (PrivilegedActionException e3) {
                    throw new RuntimeException("Could not initialize intrinsics", e3.getCause());
                }
            }
            try {
                f8011c = unsafe.objectFieldOffset(AbstractC1222a.class.getDeclaredField("waiters"));
                f8010b = unsafe.objectFieldOffset(AbstractC1222a.class.getDeclaredField("listeners"));
                f8012d = unsafe.objectFieldOffset(AbstractC1222a.class.getDeclaredField("value"));
                f8013e = unsafe.objectFieldOffset(k.class.getDeclaredField("b"));
                f8014f = unsafe.objectFieldOffset(k.class.getDeclaredField("c"));
                f8009a = unsafe;
            } catch (Exception e4) {
                C1129x.m9597a(e4);
                throw new RuntimeException(e4);
            }
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a.a
        /* renamed from: a */
        void mo10210a(k kVar, Thread thread) {
            f8009a.putObject(kVar, f8013e, thread);
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a.a
        /* renamed from: a */
        void mo10209a(k kVar, k kVar2) {
            f8009a.putObject(kVar, f8014f, kVar2);
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a.a
        /* renamed from: a */
        boolean mo10212a(AbstractC1222a<?> abstractC1222a, k kVar, k kVar2) {
            return f8009a.compareAndSwapObject(abstractC1222a, f8011c, kVar, kVar2);
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a.a
        /* renamed from: a */
        boolean mo10211a(AbstractC1222a<?> abstractC1222a, d dVar, d dVar2) {
            return f8009a.compareAndSwapObject(abstractC1222a, f8010b, dVar, dVar2);
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a.a
        /* renamed from: a */
        boolean mo10213a(AbstractC1222a<?> abstractC1222a, Object obj, Object obj2) {
            return f8009a.compareAndSwapObject(abstractC1222a, f8012d, obj, obj2);
        }
    }

    /* compiled from: AbstractFuture.java */
    /* renamed from: com.f.a.h.a.a$e */
    private static final class e extends a {

        /* renamed from: a */
        final AtomicReferenceFieldUpdater<k, Thread> f8002a;

        /* renamed from: b */
        final AtomicReferenceFieldUpdater<k, k> f8003b;

        /* renamed from: c */
        final AtomicReferenceFieldUpdater<AbstractC1222a, k> f8004c;

        /* renamed from: d */
        final AtomicReferenceFieldUpdater<AbstractC1222a, d> f8005d;

        /* renamed from: e */
        final AtomicReferenceFieldUpdater<AbstractC1222a, Object> f8006e;

        e(AtomicReferenceFieldUpdater<k, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<k, k> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractC1222a, k> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractC1222a, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractC1222a, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f8002a = atomicReferenceFieldUpdater;
            this.f8003b = atomicReferenceFieldUpdater2;
            this.f8004c = atomicReferenceFieldUpdater3;
            this.f8005d = atomicReferenceFieldUpdater4;
            this.f8006e = atomicReferenceFieldUpdater5;
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a.a
        /* renamed from: a */
        void mo10210a(k kVar, Thread thread) {
            this.f8002a.lazySet(kVar, thread);
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a.a
        /* renamed from: a */
        void mo10209a(k kVar, k kVar2) {
            this.f8003b.lazySet(kVar, kVar2);
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a.a
        /* renamed from: a */
        boolean mo10212a(AbstractC1222a<?> abstractC1222a, k kVar, k kVar2) {
            return this.f8004c.compareAndSet(abstractC1222a, kVar, kVar2);
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a.a
        /* renamed from: a */
        boolean mo10211a(AbstractC1222a<?> abstractC1222a, d dVar, d dVar2) {
            return this.f8005d.compareAndSet(abstractC1222a, dVar, dVar2);
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a.a
        /* renamed from: a */
        boolean mo10213a(AbstractC1222a<?> abstractC1222a, Object obj, Object obj2) {
            return this.f8006e.compareAndSet(abstractC1222a, obj, obj2);
        }
    }

    /* compiled from: AbstractFuture.java */
    /* renamed from: com.f.a.h.a.a$g */
    private static final class g extends a {
        private g() {
            super();
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a.a
        /* renamed from: a */
        void mo10210a(k kVar, Thread thread) {
            kVar.f8016b = thread;
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a.a
        /* renamed from: a */
        void mo10209a(k kVar, k kVar2) {
            kVar.f8017c = kVar2;
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a.a
        /* renamed from: a */
        boolean mo10212a(AbstractC1222a<?> abstractC1222a, k kVar, k kVar2) {
            boolean z;
            synchronized (abstractC1222a) {
                if (((AbstractC1222a) abstractC1222a).f7991g == kVar) {
                    ((AbstractC1222a) abstractC1222a).f7991g = kVar2;
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a.a
        /* renamed from: a */
        boolean mo10211a(AbstractC1222a<?> abstractC1222a, d dVar, d dVar2) {
            boolean z;
            synchronized (abstractC1222a) {
                if (((AbstractC1222a) abstractC1222a).f7990f == dVar) {
                    ((AbstractC1222a) abstractC1222a).f7990f = dVar2;
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }

        @Override // com.p129f.p130a.p138h.p139a.AbstractC1222a.a
        /* renamed from: a */
        boolean mo10213a(AbstractC1222a<?> abstractC1222a, Object obj, Object obj2) {
            boolean z;
            synchronized (abstractC1222a) {
                if (((AbstractC1222a) abstractC1222a).f7989e == obj) {
                    ((AbstractC1222a) abstractC1222a).f7989e = obj2;
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
    }

    /* renamed from: a */
    private static CancellationException m10183a(@NullableDecl String str, @NullableDecl Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }
}
