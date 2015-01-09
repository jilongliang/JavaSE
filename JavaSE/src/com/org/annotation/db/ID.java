package com.org.annotation.db;

import java.lang.annotation.*;

/**
 * 描述：声明主键
 *
 * @author: dashu
 * @since: 13-9-19
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ID {

    String value();

}
