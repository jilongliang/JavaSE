package com.org.enums;
/**
 *@Author:jilongliang
 *@Date  :2013-4-26
 *@Project:JavaSE
 *@Class:WeekDay.java
 *@Description:
 */
public abstract class WeekDay {

	private WeekDay(){}
	public final static WeekDay SUN=new WeekDay(){

		@Override
		public WeekDay nextDay() {
			return MON;
		}
		
	};
	public final static WeekDay MON=new WeekDay(){
		@Override
		public WeekDay nextDay() {
			return TUE;
		}
	};
	public final static WeekDay TUE=new WeekDay(){
		@Override
		public WeekDay nextDay() {
			return WED;
		}
	};
	public final static WeekDay WED=new WeekDay(){
		@Override
		public WeekDay nextDay() {
			return THU;
		}
	};
	public final static WeekDay THU=new WeekDay(){
		@Override
		public WeekDay nextDay() {
			return FRI;
		}
	};
	public final static WeekDay FRI=new WeekDay(){
		@Override
		public WeekDay nextDay() {
			return SAT;
		}
	};
	public final static WeekDay SAT=new WeekDay(){
		@Override
		public WeekDay nextDay() {
			return SUN;
		}
	};
	//抽象的类
	
	public abstract WeekDay nextDay(); //类一定是抽象的
	
	/**下一天
	public WeekDay nextDay(){
		if(this== SUN){
			return SON;
		}else{
			return SUN;
		}
	}*/
	
	@Override
	public String toString() {
		return this==SUN?"SUN":"SON";
	}
	
	public enum _WeekDay{
		SUN,MON,TUE,WED,THU,FRI,SAT
	}
	
}
