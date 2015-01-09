package com.org.annotation.db;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *@DEMO:JavaSE
 *@Java：SQLInteger.java
 *@Date:2015-1-9下午3:51:21
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description：
 */
@Target(ElementType.FIELD)  
@Retention(RetentionPolicy.RUNTIME)  
public @interface SQLInteger {  
    String name() default "";  
    Constrains constrain() default @Constrains;  
}  
