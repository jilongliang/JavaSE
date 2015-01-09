package com.org.annotation.db;

import java.lang.annotation.*;

/**
 *@Date:2015-1-9
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Version:1.0
 *@Description：声明class对应的TableName
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface TableName {
    String value()default "";
    String name()default "";
}
