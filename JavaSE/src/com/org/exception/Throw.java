package com.org.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PipedInputStream;

/**
 *@DEMO:JavaSE
 *@Author:jilongliang
 *@Date:2013-3-17
 */
public class Throw {
	/**
	 * 1)throws关键字通常被应用在声明方法时,用来指定可能抛出的异常, 多个异常可以使用逗号隔开.当在主函数中调用该方法时,如果发生异常 就会将异常抛给指定异常对象
	 * 2)throw关键字通常用在方法体中,并且抛出一个异常对象.程序在执行到throw语句时立即停止,它后面的语句都不执行.通过throw抛出异常后,如果想在上一级代码中来
	 *   捕获并处理异常,则需要在抛出异常的方法中使用throws关键字在方法声明中指明要跑出的异常；如果要捕捉throw抛出的异常,则必须使用try—catch语句
	 */
	public static void main(String[] args) throws FileNotFoundException,InterruptedException {
		FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\work"));
		Thread.sleep(111);
	}
}
class Reader implements Runnable {
	PipedInputStream pis;
	Reader(PipedInputStream pis) {
		this.pis = pis;
	}
	@Override
	public void run() {
		try {
			byte buf[] = new byte[1024];
			int len = pis.read(buf);
			String s = new String(buf, 0, len);
			System.out.println(s);
			pis.close();
		} catch (Exception e) {
			throw new RuntimeException("Exception"+e.toString());
		}
	}
}