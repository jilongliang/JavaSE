package com.org.net.tcp;

import java.io.FileOutputStream;
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
public class PicClient1 implements Runnable {

	private Socket s;

	public PicClient1(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		String ip = s.getInetAddress().getHostName();
		try {
			System.out.println(ip);
			InputStream in = s.getInputStream();
			FileOutputStream fos = new FileOutputStream("");
			byte[] buf = new byte[1024];

			int len = 0;
			while ((len = in.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}
			OutputStream os = s.getOutputStream();
			os.write("上传成功".getBytes());
			fos.close();
			s.close();
		} catch (Exception e) {
			throw new RuntimeException(ip + "上传失败!");
		}
	}
}
