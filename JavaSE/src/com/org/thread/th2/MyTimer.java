package com.org.thread.th2;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author:jilongliang
 * @Date :2013-4-24
 * @Project:JavaSE
 * @Class:MyTimer.java
 * @Description:http://hi.baidu.com/ma_yibo/item/7f6727c4a3b4957489ad9ec3
 */
public class MyTimer {

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(
					new MyTimer().new Task(),3600,3000
				);//每三秒执行一次
		
		while (true) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
	}

	class Task extends TimerTask {
		@Override
		public void run() {
			System.out.println("Run.........");
		}
	}
}
