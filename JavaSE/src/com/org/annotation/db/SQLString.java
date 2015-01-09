package com.org.annotation.db;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *@DEMO:JavaSE
 *@Java：SQLString.java
 *@Date:2015-1-9下午3:50:59
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description：
 */
@Target(ElementType.FIELD)  
@Retention(RetentionPolicy.RUNTIME)  
public @interface SQLString {  
    //字段长度  
    int value() default 0;  
    //字段名称  
    String name() default "";  
    //字段附加属性  
    Constrains constrains() default @Constrains;  
      
}  