package com.org.thread.th1;
/**
 *@DEMO:JavaSE
 *@Author:jilongliang
 *@Date:2013-3-17
 */
   class Bank{
	private int sum;
	Object obj=new Object();
	//同步函数
	public synchronized void add(int n) throws  Exception
	{
		//synchronized (obj) { //同步代码块
			sum=sum+n;
			Thread.sleep(10);//睡眠10毫秒
			System.out.println(sum);
		//}
	}
}

class Cus implements Runnable{
	private Bank bank=new Bank();
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			try {
				bank.add(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

public class BankThread{
	public static void main(String[] args) {
		Cus c=new Cus();
		Thread t=new Thread(c);
		t.start();
		
	}
}
