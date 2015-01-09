package com.org.thread.th1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@DEMO:JavaSE
 *@Author:jilongliang
 *@Date:2013-3-21
 */
public class Locker {
	public static void main(String[] args) {
		Resources1 res = new Resources1();
		Pro p = new Pro(res);
		Customer1 c = new Customer1(res);
		new Thread(p).start();
		new Thread(c).start();
	}

}

class Pro implements Runnable {

	Resources1 resource;
	Pro(Resources1 res) {
		this.resource = res;
	}

	@Override
	public void run() {

		while (true) {
			try {
				resource.set("商品");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Customer1 implements Runnable {
	Resources1 res;

	Customer1(Resources1 res) {
		this.res = res;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (res) {
				try {
					res.out();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class Resources1 {

	private String name;
	private int count = 1;
	private boolean flag = false;
	private Lock lock = new ReentrantLock();
	private Condition condition_pro = lock.newCondition();
	private Condition condition_con = lock.newCondition();

	public void set(String name) throws InterruptedException {
		lock.lock();
		try {
			while (flag)
				// this.wait();
				condition_pro.await();// 等待
			this.name = name + "=生产数：" + count++;
			System.out.println(Thread.currentThread().getName() + "生产者:"
					+ this.name);
			flag = true;
			condition_con.signalAll();
			// this.notifyAll();
		} finally {
			lock.unlock();
		}
	}

	public void out() throws InterruptedException {
		lock.lock();
		try {
			while (!flag)
				// this.wait();
				condition_con.await();
			System.out.println(Thread.currentThread().getName()
					+ "消费者===========" + this.name);
			flag = false;
			condition_pro.signalAll();
			// this.notifyAll();
		} finally {
			lock.unlock();
		}
	}
}
