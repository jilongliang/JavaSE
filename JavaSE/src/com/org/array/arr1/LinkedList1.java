package com.org.array.arr1;

import java.util.LinkedList;

public class LinkedList1 {
	public static void main(String[] args) {
		/**
		 *LinkedList具有双向插入 LinkedList类
		 * LinkedList实现了List接口，允许null元素.此外LinkedList提供额外的get
		 * remove，insert方法在LinkedList的首部或尾部
		 * 这些操作使LinkedList可被用作堆栈(stack），队列(queue)或双向队列(deque)
		 * 
		 *先进后出
		 */
		LinkedList<String> linked = new LinkedList<String>();
		linked.add("LinkedList1");
		linked.add("LinkedList2");
		linked.add("LinkedList3");
		linked.add("LinkedList4");
		System.out.println(linked);
		linked.addFirst("addFirst");// 从数组中的前面加一个数
		linked.addLast("addLast");// 从数组中的后面加一个数

		// System.out.println(linked.getLast());
		while (!linked.isEmpty()) {
			System.out.println(linked.removeFirst());
		}
		System.out.println(linked);
	}
}
