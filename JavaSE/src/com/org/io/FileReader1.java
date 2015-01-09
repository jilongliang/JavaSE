package com.org.io;

import java.io.FileReader;

/**
 *@DEMO:JavaSE
 *@Author:jilongliang
 *@Date:2013-3-16
 */
public class FileReader1 {
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("src/txt/readme.txt");
		int line = 0;
		// while ((line = fr.read()) != -1) {
		// System.out.print((char) line);
		// }

		char buf[] = new char[1024];

		while ((line = fr.read(buf)) != -1) {
			System.out.println(new String(buf, 0, line));
		}
		fr.close();
	
	}
}
