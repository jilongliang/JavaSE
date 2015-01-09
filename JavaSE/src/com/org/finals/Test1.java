package com.org.finals;

/**
 *@DEMO:JavaSE
 *@Author:jilongliang
 *@Date:2013-3-19
 */
/**
 * Final确是个重要的关键字,而且很容易忘记,必须常回来看看.
 * 
 * Java中final使用方法总结 
 * 一、
 * final根据程序上下文环境,Java关键字final有“这是无法改变的”或者“终态的”含义,它可以修饰非抽象类
 *     、非抽象类成员方法和变量.
 * 你可能出于两种理解而需要阻止改变：
 * 设计或效率. 
 * final类不能被继承,没有子类,
 * final类中的方法默认是final的.
 * final方法不能被子类的方法覆盖,但可以被继承. 
 * final成员变量表示常量,只能被赋值一次,赋值后值不再改变.
 * final不能用于修饰构造方法.
 * 
 * 注意:父类的private成员方法是不能被子类方法覆盖的,因此private类型的方法默认是final类型的.
 * 
 * 1、final类
 * final类不能被继承,因此final类的成员方法没有机会被覆盖,默认都是final的.
 * 在设计类时候,如果这个类不需要有子类,类的实现细节不允许改变,并且确信这个类不会载被扩展,那么就设计为final类.
 * 
 * 2、final方法 如果一个类不允许其子类覆盖某个方法,则可以把这个方法声明为final方法. 
 * 使用final方法的原因有二：
 *   第一、把方法锁定,防止任何继承类修改它的意义和实现. 
 *   第二、高效.编译器在遇到调用final方法时候会转入内嵌机制,大大提高执行效率.
 */
public class Test1 {
 
	public Test1(){}// final  Test1(){}  final不能用于修饰构造方法.
	public void f1() {
		System.out.println("f1");
	}

	// 无法被子类覆盖的方法
	public final void f2() {
		System.out.println("f2");
	}

	public void f3() {
		System.out.println("f3");
	}

	private void f4() {
		System.out.println("f4");
	}
}
