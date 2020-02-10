package com.alita.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MapConfig {

    String key() default "";

    String value() default "";

    int status() default 0;

    int[] view() default {};

    int order() default 0;

    Class inner() default void.class;

}
