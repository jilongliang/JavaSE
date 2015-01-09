package com.org.io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFile1 {
	
	public static void main(String[] args)throws IOException {
//		writeFile();
		readFile();
	}
	
	public static  void readFile() throws IOException
	{
		RandomAccessFile accessFile=new RandomAccessFile("src/txt/ran.txt", "r");//rw读和写
		accessFile.seek(8);//调整指针
		byte [] buf=new byte[4];
		accessFile.read(buf);
		
		String name=new String(buf);
		int age=accessFile.readInt();
		
		System.out.println("name="+name);
		System.out.println("age="+age);
		accessFile.close();
	}
	public static  void writeFile() throws IOException
	{
		RandomAccessFile accessFile=new RandomAccessFile("src/txt/ran.txt", "rw");//rw读和写
		
		//System.out.println("258的二进制是:"+Integer.toBinaryString(258));//转换为二进制
		accessFile.write("飞牛".getBytes());
		accessFile.writeInt(98);
		accessFile.write("黄八".getBytes());
		accessFile.writeInt(94);
		accessFile.close();
	}
}
