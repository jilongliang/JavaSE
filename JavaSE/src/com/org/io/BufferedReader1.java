package com.org.io;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *@DEMO:JavaSE
 *@Author:jilongliang
 *@Date:2013-3-16
 */
public class BufferedReader1 {
	/**
	 * 缓冲区是为了提高流的效率才出现的,在创建缓冲区时,必须有流对象
	 */
	public static void main(String[] args) throws Exception{
		String path=BufferedReader1.class.getClassLoader().getResource("txt/readme.txt").getPath();
		FileReader fr=new FileReader(path);
		BufferedReader reader=new  BufferedReader(fr);
		
		String  line=null;
		while((line=reader.readLine())!=null){
			System.out.println(line);
		} 
	}
}
