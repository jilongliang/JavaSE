package com.org.net.tcp;

import java.io.BufferedReader;
import java.io.FileReader;
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
class LoginClient {

	public static void main(String[] args) throws Exception {

		Socket s = new Socket("192.168.1.112", 11110);

		BufferedReader buf = new BufferedReader(
				new InputStreamReader(System.in));

		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s
				.getInputStream()));

		for (int i = 0; i < 3; i++) {
			String line = buf.readLine();
			if (line == null)
				break;
			out.println(line);
			String info = bufIn.readLine();

			System.out.println(info);

		}
		buf.close();
		bufIn.close();

	}
}

class UserThread implements Runnable {
	private Socket s;

	UserThread(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {

		String ip = s.getInetAddress().getHostName();

		System.out.println(ip);
		try {
			for (int i = 0; i < 3; i++) {
				BufferedReader bufIn = new BufferedReader(
						new InputStreamReader(s.getInputStream()));
				String name = bufIn.readLine();// name
				if (name == null)
					break;
				BufferedReader bufr = new BufferedReader(new FileReader(
						"user.txt"));
				PrintWriter out = new PrintWriter(s.getOutputStream(), true);
				String line = null;
				boolean flag = false;
				while ((line = bufr.readLine()) != null) {
					if (line.equals(name)) {
						flag = true;
						break;
					}
				}
				if (flag) {

					System.out.println(name + "已登录");
					out.println(name + "欢迎光临");
				} else {

					System.out.println(name + "不存在!");
					out.println(name + "欢迎光临");
				}
			}
			s.close();
		} catch (Exception e) {
			throw new RuntimeException("校正失败!");
		}
	}
}

class LoginServer {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket();
		while (true) {
			Socket s = ss.accept();
			new Thread(new UserThread(s)).start();
		}
	}
}
