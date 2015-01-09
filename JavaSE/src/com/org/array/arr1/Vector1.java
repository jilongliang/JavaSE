package com.org.array.arr1;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 * Vector 有特有的的取出方法 有枚举和迭代很像
 * 1.Vector<String> v=new Vector();是对的,
 * 2.Vector v=new Vector<String>();也是对的 默认就是Object,
 * 	所有对象的都是Object,所以String其实的父类就是Object.所以1,2
 * 	是正确的
 * 3.Vector<String> v=new Vector<Object>();是错误的
 */
@SuppressWarnings("all")
public class Vector1 {
	/**
	 *因为list是链表，它的元素是不连续的,vector则是连续的。
	 *例如：
	 *  1 2 3 
	 *vector则是
	 *  a[0] = 1 
	 *  a[1] = 2
	 *  a[3] = 3 
	 *list则是 
	 *  a = 1 
	 *  a.right = 2 
	 *  a.right.right = 3
	 * @param args
	 */
	public static void main(String[] args) {
		Vector v = new Vector();
		v.add("v1");
		v.add("v2");
		v.add("v3");
		v.add("v4");
		System.out.println(v);
		Enumeration enumeration = v.elements();
		while (enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
		}
		
		
		List list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		System.out.println(list);
	}
}
