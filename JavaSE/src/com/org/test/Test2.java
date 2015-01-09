package com.org.test;


/**
 * @Author:jilongliang
 * @Date :2013-4-24
 * @Project:JavaSE
 * @Class:Test1.java
 * @Description:
 */
public class Test2 {
	/**
	 * 在C#里面是不会报StringIndexOutOfBoundsException
	 * 问题直接输出ef
	 * 
	 *  String a = "abcdef";
     *	label1.Text = a.Substring(4, 2);
	 * @param args
	 */
	public static void main(String[] args) {
		 String a="abcdef";
		 try {
			System.out.println(a.substring(4, 2));
		} catch (Exception e) {
			System.out.println(e.toString());
			//e.printStackTrace();
		} 
	}
}
