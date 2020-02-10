package com.alita.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MapMethodConfig {

    boolean isDetail() default false;

    String detailkey() default "";

    int[] view() default {};

    Class clazz();

}
