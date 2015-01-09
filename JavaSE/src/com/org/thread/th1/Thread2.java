package com.org.thread.th1;

/**
 *@DEMO:JavaSE
 *@Author:jilongliang
 *@Date:2013-3-21
 */

class Resource {
	private String name;
	private String address;
	private boolean flag = false;
	/**
	 * wait notify notifyAll 都在使用在同步中,因为要对持有监视器(锁)的线程操作 所以要使用在同步中,因为只有同步才具有锁
	 * 
	 * 为什么这些操作线程的方法要定义Object类中?
	 * 
	 * 因为这些方法在操作同步中线程时,都必须要标识他们所操作线程只有的锁
	 * 
	 * 只有同一个锁上的被等待线程,可以被同一个锁上的notify唤醒 不可以对不同锁中的线程进行唤醒
	 * 
	 * 也就是说,等待和唤醒必须是同一个锁 而锁可以是任意对象,所以可以被任意对象调用的方法定义了
	 * Object类中
	 */
	public synchronized void set(String name,String  address) throws InterruptedException{
		if(flag)
			this.wait();
		this.name=name;
		this.address=address;
		this.flag=false;
		this.notify();
	}
	public synchronized	void out(){
		System.out.println(this.name+""+this.address);
	}
}

class Input implements Runnable {
	private Resource res;
	Object obj = new Object();

	public Input(Resource res) {
		this.res = res;
	}

	
	@Override
	public void run() {
		int x = 0;
		while (true) {
			synchronized (res) {
				if (x == 0) {
					 try {
						res.set("jilongliang", "gangdong");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					 try {
						res.set("梁继龙", "gangdong");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				x = (x + 1) % 2;
			}
		}
	}
}

class Output implements Runnable {
	private Resource res;
	Object obj = new Object();

	public Output(Resource res) {
		this.res = res;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (res) {
				 res.out();
			}
		}
	}

}

public class Thread2 {
	public static void main(String[] args) {
		Resource r = new Resource();
		Input in = new Input(r);
		Output out = new Output(r);
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		t1.start();
		t2.start();

	}
}
