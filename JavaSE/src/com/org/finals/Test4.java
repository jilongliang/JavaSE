package com.org.finals;

/**
 *@Author:jilongliang
 *@Date  :2013-3-7
 *@Project:JavaSE
 *@Email:jilongliang@sina.com
 *@weibo:http://weibo.com/jilongliang
 *@Description: 
 */
public class Test4 {
	/**
	 * 当函数参数为final类型时,你可以读取使用该参数,但是无法改变该参数的值
	 * @param args
	 */
	public static void main(String[] args) {
		new Test4().f1(2);
	}

	public void f1(final int i) {
		// i++;    /**i是final类型的,值不允许改变的.*/
		System.out.print(i);
	}

}
