package com.alita.annotation;

/**
 * @author Lydia
 * @version V1.0
 * @since 2019-11-18 18:02:30
 */
public @interface FieldExposure {

    String name() default "";

    String cnName() default "";

}
