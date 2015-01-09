package com.org.array.arr1;

import java.util.LinkedList;

/**
 *@DEMO:JavaSE
 *@Author:jilongliang
 *@Date:2013-3-17
 */
public class LinkedList3 {
	private LinkedList<String> queue = new LinkedList<String>() ;
	public void fallIn(String s){
		System.out.println(s + "入队");
		queue.add(s) ;
	}
	public void fallOut(){
		int len = queue.size() ;
		for(int i=0;i<len;i++){
			System.out.println( queue.removeFirst() + "出队");
		}
	}
	public void print(){
		System.out.print("元素有:") ;
		for(String list : queue){
			System.out.print(list + " ");
		}
	}
	
	public static void main(String[] args) {
		LinkedList3 t = new LinkedList3() ;
		t.fallIn("A") ;
		t.fallIn("B") ;
		t.fallIn("C") ;
		t.fallOut() ;
		t.fallIn("E") ;
		t.fallOut() ;
		t.fallIn("F") ;
		t.fallIn("G") ;
		t.fallIn("H") ;
		t.print() ;
	}
}