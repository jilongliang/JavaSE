package com.org.thread.th1;

public class Thread1 {
	public static void main(String[] args) {
		Test t = new Test("test");
		t.start();// 使该线程开始执行；Java 虚拟机调用该线程的 run 方法。
	}

}

/**
 * 1)在Android中 默认是公有类(public class)应该和文件名(文件名.java)一致,
 * 公有类可以供外部类调用 如果不一致就是提示：the
 * public type **** must be defined in its own file”
 * 2)当声明某个类只在某个文件(文件名.java)使用，就不需要声明为公有类。
 */
class Test extends Thread {
	//private String name;
	Test(String name){
		//this.name=name;
		super(name);
	}
	
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Test!"+i+"name="+Thread.currentThread().getName()+"this="+this.getName());
		}
	}
}