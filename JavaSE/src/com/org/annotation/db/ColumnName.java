package com.org.annotation.db;

import java.lang.annotation.*;

/**
 * 描述：声明Field对应的ColName
 *
 * @author: dashu
 * @since: 13-9-19
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ColumnName {

    String value();

}
