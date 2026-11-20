package ru.maximoff.apktool.util.p303a;

import com.srizwan.apktool.R;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.p226d.p233b.C2016c;
import org.p226d.p233b.C2359g;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.InterfaceC2244d;
import org.p226d.p233b.p250e.p252b.InterfaceC2218f;
import org.p226d.p233b.p250e.p252b.InterfaceC2227o;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2177a;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2186ai;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2187aj;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2197j;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2210w;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p250e.p255d.InterfaceC2255k;
import org.p226d.p233b.p256f.p258b.C2283a;
import org.p226d.p233b.p256f.p258b.C2291ah;
import org.p226d.p233b.p256f.p258b.C2292ai;
import org.p226d.p233b.p256f.p258b.C2293aj;
import org.p226d.p233b.p256f.p258b.C2317x;
import org.p226d.p233b.p256f.p261e.C2345l;
import org.p226d.p233b.p262g.C2362c;
import org.p226d.p233b.p262g.C2364e;
import org.p226d.p233b.p262g.C2365f;
import org.p226d.p233b.p262g.C2369j;
import org.p226d.p233b.p262g.C2375p;
import org.p226d.p233b.p262g.InterfaceC2374o;
import org.p226d.p233b.p262g.InterfaceC2377r;
import ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3262u;

/* compiled from: ResMerger.java */
/* renamed from: ru.maximoff.apktool.util.a.e */
/* loaded from: classes.dex */
public class C3065e {
    /* renamed from: a */
    public static void m18356a(File file, AbstractAsyncTaskC2898a abstractAsyncTaskC2898a) {
        File[] listFiles;
        Map<Long, Long> m18342c = new C3062b(new File(file, "changed_ids.json")).m18342c();
        if (m18342c.isEmpty() || (listFiles = file.listFiles(new FilenameFilter() { // from class: ru.maximoff.apktool.util.a.e.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                return str.equals("classes.dex") || str.matches("^classes\\d+\\.dex$");
            }
        })) == null) {
            return;
        }
        for (File file2 : listFiles) {
            abstractAsyncTaskC2898a.mo3984d(R.string.mprocessing_file, file2.getName());
            int m19672k = C3262u.m19672k(file2);
            if (m19672k != -1) {
                try {
                    m18357a(m18342c, file2.getAbsolutePath(), C3080al.f17665b[m19672k], abstractAsyncTaskC2898a);
                } catch (Error | Exception e2) {
                    abstractAsyncTaskC2898a.mo3979a(R.string.errorf, e2.getMessage());
                }
            } else {
                abstractAsyncTaskC2898a.mo3979a(R.string.errorf, "bad dex file");
            }
        }
    }

    /* renamed from: a */
    public static void m18357a(Map<Long, Long> map, String str, int i, AbstractAsyncTaskC2898a abstractAsyncTaskC2898a) {
        C2016c.m14455a(str, new C2364e(new C2375p(map) { // from class: ru.maximoff.apktool.util.a.e.2

            /* renamed from: a */
            private final Map f17225a;

            {
                this.f17225a = map;
            }

            @Override // org.p226d.p233b.p262g.C2375p
            /* renamed from: o */
            public InterfaceC2374o<InterfaceC2251g> mo15061o(InterfaceC2377r interfaceC2377r) {
                return new C2365f(this, interfaceC2377r, this.f17225a) { // from class: ru.maximoff.apktool.util.a.e.2.1

                    /* renamed from: b */
                    private final AnonymousClass2 f17226b;

                    /* renamed from: c */
                    private final Map f17227c;

                    {
                        this.f17226b = this;
                        this.f17227c = r3;
                    }

                    @Override // org.p226d.p233b.p262g.C2365f
                    /* renamed from: a */
                    public InterfaceC2251g mo15030a(InterfaceC2251g interfaceC2251g) {
                        if (interfaceC2251g.mo14430a() == 4) {
                            Long l = (Long) this.f17227c.get(new Long(((InterfaceC2255k) interfaceC2251g).mo14865b()));
                            if (l != null) {
                                return super.mo15030a((InterfaceC2251g) new C2345l(l.intValue()));
                            }
                        }
                        return super.mo15030a(interfaceC2251g);
                    }
                };
            }

            @Override // org.p226d.p233b.p262g.C2375p
            /* renamed from: f */
            public InterfaceC2374o<InterfaceC2218f> mo15052f(InterfaceC2377r interfaceC2377r) {
                return new C2369j(this, interfaceC2377r, this.f17225a) { // from class: ru.maximoff.apktool.util.a.e.2.2

                    /* renamed from: b */
                    private final AnonymousClass2 f17228b;

                    /* renamed from: c */
                    private final Map f17229c;

                    {
                        this.f17228b = this;
                        this.f17229c = r3;
                    }

                    @Override // org.p226d.p233b.p262g.C2369j
                    /* renamed from: a */
                    public InterfaceC2218f mo15030a(InterfaceC2218f interfaceC2218f) {
                        boolean z = false;
                        if (interfaceC2218f.mo14416a() == EnumC2272f.CONST) {
                            InterfaceC2210w interfaceC2210w = (InterfaceC2210w) interfaceC2218f;
                            Long l = (Long) this.f17229c.get(new Long(interfaceC2210w.mo14494g()));
                            if (l != null) {
                                return super.mo15030a((InterfaceC2218f) new C2317x(EnumC2272f.CONST, interfaceC2210w.mo14495q_(), l.intValue()));
                            }
                        } else if (interfaceC2218f.mo14416a() == EnumC2272f.CONST_HIGH16) {
                            InterfaceC2197j interfaceC2197j = (InterfaceC2197j) interfaceC2218f;
                            Long l2 = (Long) this.f17229c.get(new Long(interfaceC2197j.mo14494g()));
                            if (l2 != null) {
                                return super.mo15030a((InterfaceC2218f) new C2317x(EnumC2272f.CONST, interfaceC2197j.mo14495q_(), l2.intValue()));
                            }
                        } else if (interfaceC2218f.mo14416a() == EnumC2272f.ARRAY_PAYLOAD) {
                            InterfaceC2177a interfaceC2177a = (InterfaceC2177a) interfaceC2218f;
                            List<Number> mo14480f = interfaceC2177a.mo14480f();
                            ArrayList arrayList = new ArrayList();
                            boolean z2 = false;
                            for (Number number : mo14480f) {
                                Long l3 = (Long) this.f17229c.get(new Long(number.longValue()));
                                if (l3 != null) {
                                    arrayList.add(new Integer(l3.intValue()));
                                    z2 = !z2 ? true : z2;
                                } else {
                                    arrayList.add(number);
                                }
                            }
                            if (z2) {
                                return super.mo15030a((InterfaceC2218f) new C2283a(interfaceC2177a.mo14479e(), arrayList));
                            }
                        } else if (interfaceC2218f.mo14416a() == EnumC2272f.SPARSE_SWITCH_PAYLOAD) {
                            List<? extends InterfaceC2227o> f2 = ((InterfaceC2187aj) interfaceC2218f).mo14496f();
                            ArrayList arrayList2 = new ArrayList();
                            for (InterfaceC2227o interfaceC2227o : f2) {
                                Long l4 = (Long) this.f17229c.get(new Long(interfaceC2227o.mo14497a()));
                                if (l4 != null) {
                                    arrayList2.add(new C2293aj(l4.intValue(), interfaceC2227o.mo14498b()));
                                    if (!z) {
                                        z = true;
                                    }
                                } else {
                                    arrayList2.add(interfaceC2227o);
                                }
                            }
                            if (z) {
                                return super.mo15030a((InterfaceC2218f) new C2292ai(arrayList2));
                            }
                        } else if (interfaceC2218f.mo14416a() == EnumC2272f.PACKED_SWITCH_PAYLOAD) {
                            List<? extends InterfaceC2227o> f3 = ((InterfaceC2186ai) interfaceC2218f).mo14496f();
                            ArrayList arrayList3 = new ArrayList();
                            for (InterfaceC2227o interfaceC2227o2 : f3) {
                                Long l5 = (Long) this.f17229c.get(new Integer(interfaceC2227o2.mo14497a()));
                                if (l5 != null) {
                                    arrayList3.add(new C2293aj(l5.intValue(), interfaceC2227o2.mo14498b()));
                                    if (!z) {
                                        z = true;
                                    }
                                } else {
                                    arrayList3.add(interfaceC2227o2);
                                }
                            }
                            if (z) {
                                return super.mo15030a((InterfaceC2218f) new C2291ah(arrayList3));
                            }
                        }
                        return super.mo15030a(interfaceC2218f);
                    }
                };
            }

            @Override // org.p226d.p233b.p262g.C2375p
            /* renamed from: a */
            public InterfaceC2374o<InterfaceC2244d> mo15047a(InterfaceC2377r interfaceC2377r) {
                return new C2362c(this, interfaceC2377r) { // from class: ru.maximoff.apktool.util.a.e.2.3

                    /* renamed from: b */
                    private final AnonymousClass2 f17230b;

                    {
                        this.f17230b = this;
                    }

                    @Override // org.p226d.p233b.p262g.C2362c
                    /* renamed from: a */
                    public InterfaceC2244d mo15030a(InterfaceC2244d interfaceC2244d) {
                        return super.mo15030a(interfaceC2244d);
                    }
                };
            }
        }).m15031a(C2016c.m14454a(str, C2359g.m15023a(i))));
    }
}
