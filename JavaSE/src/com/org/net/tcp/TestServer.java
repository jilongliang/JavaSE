package com.org.net.tcp;

import java.io.InputStream;
import java.io.PrintWriter;
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
public class TestServer {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(1119);
		Socket s = ss.accept();
		System.out.println(ss.getInetAddress().getHostName());

		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf, 0, len)); // 输出客户端发送了什么请求协议...

		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		out.println("<font color=red>客户端你好</font>");
		s.close();
		ss.close();
		out.close();
	}
}
