package com.org.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
/**
 *@Author:jilongliang
 *@Date  :2013-3-7
 *@Project:JavaSE
 *@Email:jilongliang@sina.com
 *@weibo:http://weibo.com/jilongliang
 *@Description: 
 */
public class UdpReceiver2 {

	public static void main(String[] args) throws Exception {
		DatagramSocket datagramSocket = new DatagramSocket(1922);
		while (true) {
			byte[] buf = new byte[1024];
			DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);//
			datagramSocket.receive(datagramPacket); // 接收
			String ip_address = datagramPacket.getAddress().getHostAddress();// 获取地址
			String data = new String(datagramPacket.getData(), 0,
					datagramPacket.getLength());
			int port = datagramPacket.getPort();
			System.out.println(ip_address + "----" + data + "----" + port);
		}
	}
}
