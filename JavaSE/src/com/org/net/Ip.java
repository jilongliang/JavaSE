package com.org.net;

import java.net.InetAddress;
/**
 *@Author:jilongliang
 *@Date  :2013-3-7
 *@Project:JavaSE
 *@Email:jilongliang@sina.com
 *@weibo:http://weibo.com/jilongliang
 *@Description: 
 */
public class Ip {

	public static void main(String[] args) throws Exception {

		/*
		 * InetAddress ia; try { ia = InetAddress.getLocalHost();
		 * System.out.println(ia); } catch (UnknownHostException e) {
		 * e.printStackTrace(); }
		 */

		InetAddress ia = InetAddress.getByName("www.google.com");// www.baidu.com/115.239.210.26
		ia.getHostAddress();
		System.out.println(ia);

	}
}
