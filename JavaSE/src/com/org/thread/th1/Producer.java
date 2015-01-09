package com.org.thread.th1;
/**
 *@DEMO:JavaSE
 *@Author:jilongliang
 *@Date:2013-3-21
 */
public class Producer {
	public static void main(String[] args) {
		Resources res=new Resources();
		Produce p=new Produce(res);
		Customer c=new Customer(res);
		new Thread(p).start();
		new Thread(c).start();
	}

}



class Produce implements Runnable{

	Resources resource;
	Produce(Resources res){
		
		this.resource=res;
	}
	@Override
	public void run() {
	
		while(true)
		{
			try {
				resource.set("商品");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


class Customer implements Runnable{
	Resources res;
	Customer(Resources res){
		this.res=res;
		
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

class Resources{
	
	private String name;
	private int count=1;
	private boolean flag=false;
	
	public synchronized void set(String name) throws InterruptedException
	{
		while(flag)
			this.wait();
		this.name=name+"=生产数："+count++;
		System.out.println(Thread.currentThread().getName()+"生产者:"+this.name);
		flag=true;
		this.notifyAll();
	}
	
	public synchronized void out()throws InterruptedException{
		while(!flag)
			this.wait();
		System.out.println(Thread.currentThread().getName()+"消费者==========="+this.name);
		flag=false;
		this.notifyAll();
	}
}
