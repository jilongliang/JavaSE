package com.org.thread.th2;
/**
 *@Author:jilongliang
 *@Date  :2013-4-24
 *@Project:JavaSE
 *@Class:TestThread1.java
 *@Description:
 */
public class TestThread1 {
	public static void main(String[] args) {

		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
			}
		}).start();
	}

	
	private  void Outputer(String name){
		int len=name.length();
		for (int i = 0; i < len; i++) {
			System.out.println(name.charAt(i));
		}
		System.out.println();
	}
}
