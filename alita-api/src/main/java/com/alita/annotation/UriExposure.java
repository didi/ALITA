package com.alita.annotation;

/**
 * @author Lydia
 * @version V1.0
 * @since 2019-11-18 17:53:57
 */
public @interface UriExposure {

    String url() default "";

    Class paramType() default void.class;

    Class returnType() default void.class;

}
