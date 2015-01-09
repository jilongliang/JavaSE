package com.org.static_import;
/**
 *@Author:jilongliang
 *@Date  :2013-4-26
 *@Project:JavaSE
 *@Class:Test1.java
 *@Description:静态导入
 */
import static java.lang.Math.abs;//静态导入

public class Test1 {

	public static void main(String[] args) {
		System.out.println(abs(3-6));//3-6的绝对值
	}
}
