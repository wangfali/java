package com.briup.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

@Documented
@Retention(RUNTIME)
@Target(ElementType.METHOD)
@Component
public @interface MineAopMethod {
	public abstract String value() default "";
}
