package com.org.net.tcp;

import java.net.URL;
/**
 *@Author:jilongliang
 *@Date  :2013-3-7
 *@Project:JavaSE
 *@Email:jilongliang@sina.com
 *@weibo:http://weibo.com/jilongliang
 *@Description: 
 */
public class URL1 {

	public static void main(String[] args)throws Exception {
		URL url=new URL("http://198.121.121.12:8080/test/index.html");
		
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPath());
		System.out.println(url.getPort());
		System.out.println(url.getQuery());
	}
}
