package com.org.thread.th1;

/**
 *@DEMO:JavaSE
 *@Author:jilongliang
 *@Date:2013-3-16
 */
/**
 * 创建线程有两种方式: 1.实现Runnable接口 2.继承Thread类
 * 
 * 实现方式和继承方式有啥区别？ 实现方式的好处：避免了单继承的局限性 在定义线程时，建议使用实现方式 区别：
 * 继承Thread：线程代码存放Thread子类run方法中 实现Runnable:线程代码存放接口的子类的run方法
 */
public class BuyThread {

	public static void main(String[] args) {

		Ticket t = new Ticket();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);

		t1.start();
		try {
			Thread.sleep(10);
		} catch (Exception e) {
		}
		t.flag = false;
		//t2.start();
	}
}

class Ticket implements Runnable {// extends Thread{
	int tick = 100;
	Object obj = new Object();
	boolean flag = true;

	/**
	 * 当多条语句操同一个线程共享数据时,一个线程执行一部分代码 代码还没执行完，
	 * 
	 * 另一个线程参与进来执行，会导致共享错误
	 * 
	 */
	@Override
	public void run() {
		while (true) {
			if (flag) {
				synchronized (this) { // 同步代码块~~
					if (tick > 0)
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					System.out.println(Thread.currentThread().getName()
							+ "同步代码块=" + tick--);
				}
			} else {
				while (flag) {
					synchShow();
				}
			}
		}
	}
	public synchronized void synchShow() {
		if (tick > 0)
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.out.println(Thread.currentThread().getName()
				+ "方法加上synchronized=" + tick--);
	}
}