package com.org.annotation.db;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *@DEMO:JavaSE
 *@Java：Constrains.java
 *@Date:2015-1-9下午3:52:58
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description：
 */
@Target(ElementType.FIELD)  
@Retention(RetentionPolicy.RUNTIME)  
public @interface Constrains {  
    boolean primaryKey() default false;  
    boolean unique() default false;  
    boolean allowNull() default true;  
}  
