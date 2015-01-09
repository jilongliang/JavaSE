package com.org.array.arr2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;


/**
 * @Author:jilongliang
 * @Date :2013-4-30
 * @Project:JavaSE
 */
@SuppressWarnings("all")
public class Array_List {
	public static void main(String[] args) {
		// Constructor<String
		//Vector<String> v=new Vector();是对的,Vector<String> v=new Vector<Object>();是错误的
		Vector<String> v=new Vector<String>();
		v.add("v1");
		v.add("v2");
		v.add("v3");
		v.add("v4");
		printCollection(v);
		/**
		 * Number直接已知子类： 
		 *   AtomicInteger, AtomicLong, BigDecimal, BigInteger,
		 *   Byte, Double, Float, Integer, Long, Short 
		 */
		//上边界,通配符 ,Integer是继承了Number
		Vector<? extends Number> v1=new Vector<AtomicInteger>();
		Vector<? extends Number> v2=new Vector<AtomicLong>();
		Vector<? extends Number> v3=new Vector<BigDecimal>();
		Vector<? extends Number> v4=new Vector<BigInteger>();
		Vector<? extends Number> v5=new Vector<Byte>();
		Vector<? extends Number> v6=new Vector<Double>();
		Vector<? extends Number> v7=new Vector<Float>();
		Vector<? extends Number> v8=new Vector<Integer>();
		Vector<? extends Number> v9=new Vector<Long>();
		Vector<? extends Number> v10=new Vector<Short>();
		//下边界,通配符
		Vector<? super Integer> v_2=new Vector<Number>();
		
		add(3, 5);
		Number n1=add(3.5,3);
		Object obj1=add(3,"abc");
		
		
		swap(new String []{"A","B","C"},1,2);//把第一个和第二个换一下

		
		Object obj2="ni hao";
		String a=convert(obj2);
		
		
		
	}
	/**
	 * Collection的使用
	 * @param collections
	 */
	private static void printCollection(Collection<?> collections){
		 System.out.println(collections.size());
		 for(Object obj:collections){
			 System.out.println(obj);
		 }
	}
	
	/**
	 * @param x
	 * @param y
	 * @return
	 */
	private static <T> T add(T x,T y){
		return null;
	}
	/**
	 * 交换方法
	 * @param a
	 * @param i
	 * @param y
	 */
	private static<T> void swap(T[] a,int i,int y){
		T temp=a[i];
		a[i]=a[y];
		a[y]=temp;
	}
	/**
	 * 转换
	 * @param obj
	 * @return
	 */
	private static<T> T convert(Object obj){
		return (T)obj;
	}
	
	private static<T> void fillArray(T[] t,T obj){
		for (int i = 0; i < t.length; i++) {
			t[i]=obj;
		}
	}
}
