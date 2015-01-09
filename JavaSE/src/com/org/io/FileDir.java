package com.org.io;

import java.io.File;

/**
 *@DEMO:JavaSE
 *@Author:jilongliang
 *@Date:2013-3-17
 */
public class FileDir {

	public static void main(String[] args) {
		File f1=new File("D:\\work");
		showDir(f1);
	}
	
	public static void showDir(File file){
		System.out.println(file);
		File []f=file.listFiles();
		for (int i = 0; i < f.length; i++) {
			if(f[i].isDirectory())
			{
				showDir(f[i]);
			}else {
				System.out.println(f[i]);
			}
		}
	
	}
}
