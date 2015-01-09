package com.org.net.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/**
 *@Author:jilongliang
 *@Date  :2013-3-7
 *@Project:JavaSE
 *@Email:jilongliang@sina.com
 *@weibo:http://weibo.com/jilongliang
 *@Description: 
 */
public class ClientTCP1 {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("192.168.1.100", 1100);
		BufferedReader bufr = new BufferedReader(new InputStreamReader(
				System.in));

		// BufferedWriter bufOut=new BufferedWriter(new
		// OutputStreamWriter(s.getOutputStream()));

		PrintWriter out = new PrintWriter(s.getOutputStream(), true);

		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s
				.getInputStream()));
		String line = null;
		while ((line = bufIn.readLine()) != null) {
			if ("over".equals(line)) {
				break;
			}
			out.println(line);
			// bufOut.write(line);
			// bufOut.newLine();
			// bufOut.flush();
			String Str = bufIn.readLine();
			System.out.println(Str);
		}

		s.close();
		bufr.close();
		bufIn.close();
		// bufOut.close();

	}

}
