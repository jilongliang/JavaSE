package com.org.each;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *@Author:jilongliang
 *@Date :2013-3-10
 *@Project:JavaSE
 *@Class:ForEach.java
 *@Description:
 */
public class ForEach {

	/**
	 * 迭代器（Iterator）
	 * 迭代器是一种设计模式，它是一个对象，它可以遍历并选择序列中的对象，
	 * 而开发人员不需要了解该序列的底层结构.迭代器通常被称为“轻量级”对象，
	 * 因为创建它的代价小.
	 * Java中的Iterator功能比较简单，并且只能单向移动：
	 * (1)
	 * 使用方法iterator()要求容器返回一个Iterator.第一次调用Iterator的next()方法时，它返回序列的第一个元素.注意
	 * iterator()方法是java.lang.Iterable接口,被Collection继承.
	 * (2) 使用next()获得序列中的下一个元素.
	 * (3) 使用hasNext()检查序列中是否还有元素.
	 * (4) 使用remove()将迭代器新返回的元素删除.
	 * Iterator是Java迭代器最简单的实现，为List设计的ListIterator具有更多的功能，它可以从两个方向遍历List，
	 * 也可以从List中插入和删除元素.
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("AA");
		list.add("BB");
		list.add("CC");
		list.add("EE");
		/**方法一 */
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		/**方法二*/
		Iterator<String> itera=list.iterator();
		do{
			System.out.println(itera.next());
		}while(itera.hasNext());
			
		/**方法三*/
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}

		/**方法四*/
		for (Iterator<String> iter = list.iterator(); iter.hasNext();) {
			String ss = iter.next();
			System.out.println(ss);
		}
		/**方法五**/
		for (String S : list) {
			System.out.println(S);
		}
	}
}
