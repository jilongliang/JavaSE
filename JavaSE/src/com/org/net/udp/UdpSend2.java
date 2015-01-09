package com.org.net.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/**
 *@Author:jilongliang
 *@Date  :2013-3-7
 *@Project:JavaSE
 *@Email:jilongliang@sina.com
 *@weibo:http://weibo.com/jilongliang
 *@Description: 
 */
public class UdpSend2 {
	public static void main(String[] args) throws Exception {

		// 创建udp对象服务
		DatagramSocket datagramSocket = new DatagramSocket();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while ((line = br.readLine()) != null) {
			if ("886".equals(line))
				break;
			byte[] buf = line.getBytes();
			DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length,
					InetAddress.getByName("192.168.1.100"), 1922);
			datagramSocket.send(datagramPacket);
		}
		datagramSocket.close();
	}
}
