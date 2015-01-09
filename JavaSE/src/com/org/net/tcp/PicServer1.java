package com.org.net.tcp;

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
public class PicServer1 {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(1131);

		while (true) {
			Socket s = ss.accept();
			new Thread(new PicClient1(s)).start();// 启动线程
		}
	}
}
