package com.org.io;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *@DEMO:JavaSE
 *@Author:jilongliang
 *@Date:2013-3-16
 */
public class BufferedWriter1 {
	/**
	 * 缓冲区是为了提高流的效率才出现的,在创建缓冲区时,必须有流对象
	 */
	public static void main(String[] args) throws Exception{
		FileWriter fw=new FileWriter("src/txt/readme.txt");
		
		BufferedWriter bw=new BufferedWriter(fw);
		for (int i = 1; i <= 10; i++) {
			bw.write("write:="+i);
			bw.newLine();
			bw.flush();//只要用到缓冲区就flush//其实关闭了缓冲区,就是关闭缓冲区中流的对象. //写一次flush是为了防止停电就挂了~
		}
		bw.close();
	}
}
