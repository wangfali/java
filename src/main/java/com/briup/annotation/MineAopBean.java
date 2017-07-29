package com.briup.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;


@Documented
@Retention(RUNTIME)
@Target(TYPE)
@Component
public @interface MineAopBean {
	public abstract String value() default "";
}
