package com.org.finals;
/**
 *@Author:jilongliang
 *@Date  :2013-3-7
 *@Project:JavaSE
 *@Email:jilongliang@sina.com
 *@weibo:http://weibo.com/jilongliang
 *@Description: 
 */
public class Finalize {
	protected void finalize() throws Throwable {
		super.finalize();
	}

	public static void main(String[] args) throws Throwable {
//		Finalize f=new Finalize();
//		f.finalize();	
		System.out.println();
	}
}
