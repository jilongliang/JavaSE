package com.org.net.udp;

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
public class UdpSend1 {
	public static void main(String[] args) throws Exception {

		// 创建udp对象服务
		DatagramSocket datagramSocket = new DatagramSocket();
		// 确定数据，并封装数据
		byte[] buf = "嘿嘿UDP".getBytes();
		DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length,
				InetAddress.getByName("192.168.1.100"), 10000);
		// 发送
		datagramSocket.send(datagramPacket);
	}
}
