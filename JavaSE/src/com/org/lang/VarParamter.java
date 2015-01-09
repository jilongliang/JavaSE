package com.org.lang;
/**
 *@Author:jilongliang
 *@Date  :2013-4-26
 *@Project:JavaSE
 *@Class:VarParamter.java
 *@Description:可变参数
 */
public class VarParamter {
	public static void main(String[] args) {
		System.out.println(add(2,3));
	}
	/**
	 * ...必须是最后一个参数.
	 * @param x
	 * @param args
	 * @return
	 */
	public static int add(int x,int ... args){
		 int sum=x;
		 
		 for (int i = 0; i < args.length; i++) {
			sum+=args[i];
		}
		 return sum;
	}
}
