package com.org.annotation.domain;

import com.org.annotation.test.Annotation;
import com.org.annotation.test.MyAnnotation;

/**
 *@Author:jilongliang
 *@Date  :2013-4-29
 *@Project:JavaSE
 *@Class:AnnotationTest.java
 *@Description:
 */
@MyAnnotation
(
	 annotationAttr=@Annotation("http://weibo.com/resourceljl"),
	 color = "red",
	 value="blue",
	 arrayValue={232,232}
 )
public class DoAnnotation {
	@MyAnnotation("liangjilong")
	public static void main(String[] args) {
		/**
		 * 返回一個false AnnotationTest.class是一个内存的二进制
		 */
		if(DoAnnotation.class.isAnnotationPresent(MyAnnotation.class)){
			 MyAnnotation annotation=(MyAnnotation)DoAnnotation.class.getAnnotation(MyAnnotation.class);
			 System.out.println(annotation.color());
			 System.out.println(annotation.value());
			 System.out.println(annotation.arrayValue().length);
			 System.out.println(annotation.annotationAttr().value());
		}
	}
	
	/**标记已经过时*/
	@Deprecated  
	public static void sayHello(){
		System.out.println("Hi====");
	}
}
