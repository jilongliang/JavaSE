package com.org.net.tcp;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/**
 *@Author:jilongliang
 *@Date  :2013-3-7
 *@Project:JavaSE
 *@Email:jilongliang@sina.com
 *@weibo:http://weibo.com/jilongliang
 *@Description: 
 */
public class PicClient {

	public static void main(String[] args) throws Exception {
		Socket s = new Socket("192.168.1.111", 1131);
		FileInputStream fis = new FileInputStream("c:\\test.jpg");
		OutputStream out = s.getOutputStream();
		byte[] buf = new byte[1024];
		int len = 0;
		// 字节流是用read字符流是用readLine
		while ((len = fis.read(buf)) != -1) {
			out.write(buf, 0, len);
		}
		s.shutdownInput();//
		InputStream in = s.getInputStream();
		byte[] bff = new byte[1024];
		int num = in.read(bff);
		System.out.println(new String(bff, 0, num));
		fis.close();
		s.close();
	}
}
