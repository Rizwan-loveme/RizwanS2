package com.p163i.p164a;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/* compiled from: Cloner.java */
/* renamed from: com.i.a.a */
/* loaded from: classes.dex */
public class C1403a {

    /* renamed from: b */
    private final Set<Class<?>> f9166b = new HashSet();

    /* renamed from: c */
    private final Set<Class<?>> f9167c = new HashSet();

    /* renamed from: d */
    private final Set<Class<?>> f9168d = new HashSet();

    /* renamed from: e */
    private final Map<Class<?>, InterfaceC1414l> f9169e = new HashMap();

    /* renamed from: f */
    private final Map<Object, Boolean> f9170f = new IdentityHashMap();

    /* renamed from: g */
    private final ConcurrentHashMap<Class<?>, List<Field>> f9171g = new ConcurrentHashMap<>();

    /* renamed from: h */
    private InterfaceC1413k f9172h = null;

    /* renamed from: i */
    private boolean f9173i = true;

    /* renamed from: j */
    private boolean f9174j = false;

    /* renamed from: k */
    private boolean f9175k = true;

    /* renamed from: l */
    private InterfaceC1412j f9176l = new InterfaceC1412j() { // from class: com.i.a.a.1
        @Override // com.p163i.p164a.InterfaceC1412j
        /* renamed from: a */
        public <T> T mo11216a(T t, Map<Object, Object> map) {
            try {
                return (T) C1403a.this.m11207b(t, map);
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException(e2);
            }
        }
    };

    /* renamed from: m */
    private final ConcurrentHashMap<Class<?>, Boolean> f9177m = new ConcurrentHashMap<>();

    /* renamed from: n */
    private boolean f9178n = true;

    /* renamed from: a */
    private final InterfaceC1416n f9165a = C1418p.m11223a();

    public C1403a() {
        m11200e();
    }

    /* renamed from: e */
    private void m11200e() {
        m11208b();
        m11212c();
        m11204a();
    }

    /* renamed from: a */
    protected void m11204a() {
        this.f9169e.put(GregorianCalendar.class, new C1406d());
        this.f9169e.put(ArrayList.class, new C1405c());
        this.f9169e.put(LinkedList.class, new C1410h());
        this.f9169e.put(HashSet.class, new C1409g());
        this.f9169e.put(HashMap.class, new C1408f());
        this.f9169e.put(TreeMap.class, new C1411i());
        this.f9169e.put(ConcurrentHashMap.class, new C1407e());
    }

    /* renamed from: a */
    protected Object m11203a(Object obj, Map<Object, Object> map) {
        InterfaceC1414l interfaceC1414l = this.f9169e.get(obj.getClass());
        if (interfaceC1414l != null) {
            return interfaceC1414l.mo11217a(obj, this.f9176l, map);
        }
        return null;
    }

    /* renamed from: a */
    public void m11205a(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            this.f9170f.put(declaredField.get(null), true);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (IllegalArgumentException e3) {
            throw new RuntimeException(e3);
        } catch (NoSuchFieldException e4) {
            throw new RuntimeException(e4);
        } catch (SecurityException e5) {
            throw new RuntimeException(e5);
        }
    }

    /* renamed from: b */
    protected void m11208b() {
        m11215d(String.class);
        m11215d(Integer.class);
        m11215d(Long.class);
        m11215d(Boolean.class);
        m11215d(Class.class);
        m11215d(Float.class);
        m11215d(Double.class);
        m11215d(Character.class);
        m11215d(Byte.class);
        m11215d(Short.class);
        m11215d(Void.class);
        m11215d(BigDecimal.class);
        m11215d(BigInteger.class);
        m11215d(URI.class);
        m11215d(URL.class);
        m11215d(UUID.class);
        m11215d(Pattern.class);
    }

    /* renamed from: c */
    protected void m11212c() {
        m11206a(TreeSet.class, HashSet.class, HashMap.class, TreeMap.class);
    }

    /* renamed from: a */
    public void m11206a(Class<?>... clsArr) {
        for (Class<?> cls : clsArr) {
            for (Field field : m11211c(cls)) {
                if (Modifier.isStatic(field.getModifiers()) && !field.getType().isPrimitive()) {
                    m11205a(cls, field.getName());
                }
            }
        }
    }

    /* renamed from: b */
    public void m11209b(Class<?>... clsArr) {
        for (Class<?> cls : clsArr) {
            this.f9166b.add(cls);
        }
    }

    /* renamed from: c */
    public void m11213c(Class<?>... clsArr) {
        for (Class<?> cls : clsArr) {
            this.f9167c.add(cls);
        }
    }

    /* renamed from: d */
    public void m11215d(Class<?>... clsArr) {
        for (Class<?> cls : clsArr) {
            this.f9166b.add(cls);
        }
    }

    /* renamed from: a */
    protected <T> T m11201a(Class<T> cls) {
        return (T) this.f9165a.mo11221a(cls);
    }

    /* renamed from: a */
    public <T> T m11202a(T t) {
        if (t == null) {
            return null;
        }
        if (this.f9173i) {
            if (this.f9172h != null) {
                this.f9172h.m11218a(t.getClass());
            }
            try {
                return (T) m11207b(t, new IdentityHashMap(16));
            } catch (IllegalAccessException e2) {
                throw new C1404b("error during cloning of " + t, e2);
            }
        }
        return t;
    }

    /* renamed from: b */
    protected boolean m11210b(Class<?> cls) {
        return false;
    }

    /* renamed from: d */
    protected Class<?> m11214d() {
        return InterfaceC1417o.class;
    }

    /* renamed from: d */
    private boolean m11199d(Class<?> cls) {
        Boolean bool = this.f9177m.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        if (m11210b(cls)) {
            return true;
        }
        Class<?> m11214d = m11214d();
        for (Annotation annotation : cls.getDeclaredAnnotations()) {
            if (annotation.annotationType() == m11214d) {
                this.f9177m.put(cls, Boolean.TRUE);
                return true;
            }
        }
        for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
            for (Annotation annotation2 : superclass.getDeclaredAnnotations()) {
                if (annotation2.annotationType() == InterfaceC1417o.class && ((InterfaceC1417o) annotation2).m11222a()) {
                    this.f9177m.put(cls, Boolean.TRUE);
                    return true;
                }
            }
        }
        this.f9177m.put(cls, Boolean.FALSE);
        return false;
    }

    /* renamed from: b */
    protected <T> T m11207b(T t, Map<Object, Object> map) {
        if (t != null && t != this) {
            if (!this.f9170f.containsKey(t) && !(t instanceof Enum)) {
                Class<?> cls = t.getClass();
                if (this.f9168d.contains(cls)) {
                    return null;
                }
                if (!this.f9166b.contains(cls)) {
                    Iterator<Class<?>> it = this.f9167c.iterator();
                    while (it.hasNext()) {
                        if (it.next().isAssignableFrom(cls)) {
                            return t;
                        }
                    }
                    if (!m11199d(cls)) {
                        if (!(t instanceof InterfaceC1415m) || !((InterfaceC1415m) t).m11220a()) {
                            Object obj = map != null ? map.get(t) : null;
                            if (obj != null) {
                                return (T) obj;
                            }
                            T t2 = (T) m11203a(t, map);
                            if (t2 != null) {
                                if (map != null) {
                                    map.put(t, t2);
                                }
                                return t2;
                            }
                            if (this.f9172h != null) {
                                this.f9172h.m11218a(t.getClass());
                            }
                            if (cls.isArray()) {
                                return (T) m11198c(t, map);
                            }
                            return (T) m11195a(t, map, cls);
                        }
                        return t;
                    }
                    return t;
                }
                return t;
            }
            return t;
        }
        return null;
    }

    /* renamed from: a */
    private <T> T m11195a(T t, Map<Object, Object> map, Class<T> cls) {
        T t2 = (T) m11201a((Class) cls);
        if (map != null) {
            map.put(t, t2);
        }
        for (Field field : m11211c((Class<?>) cls)) {
            int modifiers = field.getModifiers();
            if (!Modifier.isStatic(modifiers)) {
                if (this.f9174j && Modifier.isTransient(modifiers)) {
                    if (!field.getType().isPrimitive()) {
                        field.set(t2, null);
                    }
                } else {
                    Object obj = field.get(t);
                    Object m11207b = map != null ? (this.f9175k || (!this.f9175k && !field.isSynthetic())) && (this.f9178n || (!this.f9178n && !m11197a(field))) ? m11207b(obj, map) : obj : obj;
                    field.set(t2, m11207b);
                    if (this.f9172h != null && m11207b != obj) {
                        this.f9172h.m11219a(field, t.getClass());
                    }
                }
            }
        }
        return t2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    private <T> T m11198c(T t, Map<Object, Object> map) {
        Class<?> cls = t.getClass();
        int length = Array.getLength(t);
        T t2 = (T) Array.newInstance(cls.getComponentType(), length);
        if (map != null) {
            map.put(t, t2);
        }
        for (int i = 0; i < length; i++) {
            Object obj = Array.get(t, i);
            if (map != null) {
                obj = m11207b(obj, map);
            }
            Array.set(t2, i, obj);
        }
        return t2;
    }

    /* renamed from: a */
    private boolean m11197a(Field field) {
        return "this$0".equals(field.getName());
    }

    /* renamed from: a */
    private void m11196a(List<Field> list, Field[] fieldArr) {
        for (Field field : fieldArr) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            list.add(field);
        }
    }

    /* renamed from: c */
    protected List<Field> m11211c(Class<?> cls) {
        List<Field> list = this.f9171g.get(cls);
        if (list == null) {
            LinkedList linkedList = new LinkedList();
            m11196a(linkedList, cls.getDeclaredFields());
            Class<?> cls2 = cls;
            while (true) {
                cls2 = cls2.getSuperclass();
                if (cls2 == Object.class || cls2 == null) {
                    break;
                }
                m11196a(linkedList, cls2.getDeclaredFields());
            }
            this.f9171g.putIfAbsent(cls, linkedList);
            return linkedList;
        }
        return list;
    }
}
