package com.org.finals;

/**
 *@DEMO:JavaSE
 *@Author:jilongliang
 *@Date:2013-3-19
 */
public class Test2 extends Test1 {
	public void f1() {
		System.out.println("Test1父类方法f1被覆盖!");
	}
	public static void main(String[] args) {
		Test2 t = new Test2();
		t.f1();
		t.f2(); // 调用从父类继承过来的final方法
		t.f3(); // 调用从父类继承过来的方法
		// t.f4(); //调用失败，无法从父类继承获得
	}
}