package com.p163i.p164a;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: FastClonerCalendar.java */
/* renamed from: com.i.a.d */
/* loaded from: classes.dex */
public class C1406d implements InterfaceC1414l {
    @Override // com.p163i.p164a.InterfaceC1414l
    /* renamed from: a */
    public Object mo11217a(Object obj, InterfaceC1412j interfaceC1412j, Map<Object, Object> map) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        Calendar calendar = (Calendar) obj;
        gregorianCalendar.setTimeInMillis(calendar.getTimeInMillis());
        gregorianCalendar.setTimeZone((TimeZone) calendar.getTimeZone().clone());
        return gregorianCalendar;
    }
}
