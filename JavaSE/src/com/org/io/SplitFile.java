package com.org.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

public class SplitFile {
	public static void main(String[] args) throws Exception {
		// splitFile();
		marge();
	}

	/**
	 * 切割文件
	 * 
	 * @throws Exception
	 */
	public static void splitFile() throws Exception {
		FileInputStream fis = new FileInputStream("src/txt/me.jpg");
		FileOutputStream fos = null;
		byte[] buf = new byte[1024 * 1024];
		int len = 0;
		int count = 1;
		while ((len = fis.read(buf)) != -1) {
			fos = new FileOutputStream("src/txt/" + (count++) + ".part");
			fos.write(buf, 0, len);
			fos.close();
		}
		fis.close();
	}

	/**
	 * 合并文件
	 * @throws Exception
	 */
	public static void marge() throws Exception {

		ArrayList<FileInputStream> list = new ArrayList<FileInputStream>();
		//这里切多少块就遍历多少
		for (int i = 1; i <= 1; i++) {
			list.add(new FileInputStream("src/txt/" + i + ".part"));
		}

		final Iterator<FileInputStream> it = list.iterator(); // 因为下面是匿名类,所以要加上代码块final
		Enumeration<FileInputStream> en = new Enumeration<FileInputStream>() {

			@Override
			public FileInputStream nextElement() {
				return it.next();
			}
			@Override
			public boolean hasMoreElements() {
				return it.hasNext();
			}
		};
		SequenceInputStream sis = new SequenceInputStream(en); //圆形流
		FileOutputStream fos = new FileOutputStream("src/txt/marge.jpg");
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = sis.read(buf)) != -1) {
			fos.write(buf, 0, len);
		}
		fos.close();
		sis.close();
	}
}
