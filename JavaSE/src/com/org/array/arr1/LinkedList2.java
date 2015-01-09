package com.org.array.arr1;

import java.util.LinkedList;
/**
 *@Author:jilongliang
 *@Date  :2013-3-7
 *@Project:JavaSE
 *@Email:jilongliang@sina.com
 *@weibo:http://weibo.com/jilongliang
 *@Description: 
 */
public class LinkedList2 {
	public static void main(String[] args) {
		/**
		 *LinkedList具有双向插入 LinkedList类
		 * LinkedList实现了List接口，允许null元素.此外LinkedList提供额外的get
		 * remove，insert方法在LinkedList的首部或尾部
		 * 这些操作使LinkedList可被用作堆栈（stack），队列（queue）或双向队列（deque）
		 * 
		 *先进后出
		 */
		Queue list = new Queue();
		list.Add("add1");
		list.Add("add2");
		list.Add("add3");
		while (!list.IsNull()) {
			System.out.println(list.get());// 先进后出
		}
	}
}
/**
 *队列
 */
@SuppressWarnings("all")
class Queue {
	LinkedList link = null;
	public Queue() {
		link = new LinkedList();
	}
	public boolean IsNull() {
		return link.isEmpty();
	}
	public void Add(Object obj) {
		link.addLast(obj);
	}
	public Object get() {
		return link.removeLast();
	}
}
