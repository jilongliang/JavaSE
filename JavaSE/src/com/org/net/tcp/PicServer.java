package com.org.net.tcp;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *@Author:jilongliang
 *@Date  :2013-3-7
 *@Project:JavaSE
 *@Email:jilongliang@sina.com
 *@weibo:http://weibo.com/jilongliang
 *@Description: 
 */
public class PicServer {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(1131);

		Socket s = ss.accept();
		InputStream is = s.getInputStream();
		FileOutputStream fos = new FileOutputStream("ss.jpg");
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = is.read(buf)) != -1) {
			fos.write(buf, 0, len);
		}

		OutputStream out = s.getOutputStream();
		out.write("上传成功".getBytes());
		fos.close();
		out.close();
		is.close();
	}
}
