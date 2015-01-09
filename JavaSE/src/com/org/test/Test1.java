package com.org.test;


/**
 * @Author:jilongliang
 * @Date :2013-4-24
 * @Project:JavaSE
 * @Class:Test1.java
 * @Description:
 */
public class Test1 {
	public static void main(String[] args) {
		 
	}
	
	/**
	 * static生命的内部类就是一个外部类.
	 * 
	 */
	static class T{
		
		T t=new T();
		
	}
}
