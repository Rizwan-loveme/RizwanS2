package dalvik.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Deprecated
/* loaded from: assets/android.dex */
public @interface TestTarget {
    @Deprecated
    String conceptName() default "";

    @Deprecated
    Class<?>[] methodArgs() default {};

    @Deprecated
    String methodName() default "";
}
