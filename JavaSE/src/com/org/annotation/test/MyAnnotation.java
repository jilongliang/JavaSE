package com.org.annotation.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *@Author:jilongliang
 *@Date  :2013-4-29
 *@Project:JavaSE
 *@Class:Annotation.java
 *@Description:注解类
 *注解+注解=元注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface MyAnnotation {
	String color() default "blue";
	String value();
	int [] arrayValue() default{2,232,232};
	Annotation annotationAttr()default @Annotation("MyName");
}
