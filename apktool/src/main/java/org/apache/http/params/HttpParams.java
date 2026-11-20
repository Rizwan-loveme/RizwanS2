package org.apache.http.params;

@Deprecated
/* loaded from: assets/android.dex */
public interface HttpParams {
    @Deprecated
    HttpParams copy();

    @Deprecated
    boolean getBooleanParameter(String str, boolean z);

    @Deprecated
    double getDoubleParameter(String str, double d2);

    @Deprecated
    int getIntParameter(String str, int i);

    @Deprecated
    long getLongParameter(String str, long j);

    @Deprecated
    Object getParameter(String str);

    @Deprecated
    boolean isParameterFalse(String str);

    @Deprecated
    boolean isParameterTrue(String str);

    @Deprecated
    boolean removeParameter(String str);

    @Deprecated
    HttpParams setBooleanParameter(String str, boolean z);

    @Deprecated
    HttpParams setDoubleParameter(String str, double d2);

    @Deprecated
    HttpParams setIntParameter(String str, int i);

    @Deprecated
    HttpParams setLongParameter(String str, long j);

    @Deprecated
    HttpParams setParameter(String str, Object obj);
}
