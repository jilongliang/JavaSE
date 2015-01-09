package com.org.net.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
public class ServerTCP1 {
	public static void main(String[] args) throws Exception {

		ServerSocket ss = new ServerSocket(1100);
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostName();
		System.out.println("ip" + ip);
		// 读取流中数据
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s
				.getInputStream()));
		// 目的Socket输出流,将大写数据写入socket输出流，并发给客户端
		// BufferedWriter bufOut=new BufferedWriter(new
		// OutputStreamWriter(s.getOutputStream()));
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);

		String line = null;
		while ((line = bufIn.readLine()) != null) {
			System.out.println(line);
			out.println(line.toUpperCase());
			// bufOut.write(line.toUpperCase());//转换为大写
			// bufOut.newLine();//移到下一个行,就是回车之后才知道
			// bufOut.flush();//清除一下缓冲区
		}
		s.close();
		ss.close();
	}
}
