package com.org.lang;
/**
 *@Author:jilongliang
 *@Date  :2013-4-26
 *@Project:JavaSE
 *@Class:AutoBox.java
 *@Description:
 *记住设计模式就是把简单的问题复杂化
 */
public class AutoBox {
	public static void main(String[] args) {
		
		Integer i1=3;//自动装箱 jdk1.4是不可以的会报错的
		
		Integer a1=137;//-128到128是为true的
		Integer a2=137;//因为小的数据用得比较多他会放入缓存里面
		//当缓存有的话就直接到缓存拿,缓存的作用就是提高性能的效率
		System.out.println(a1==a2);
	
		Integer a11=12;//-128到128是为true的
		Integer a22=12;//因为小的数据用得比较多他会放入缓存里面
		//当缓存有的话就直接到缓存拿,缓存的作用就是提高性能的效率
		System.out.println(a11==a22);
	
	
	}

}
