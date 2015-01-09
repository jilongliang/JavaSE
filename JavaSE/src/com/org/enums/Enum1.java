package com.org.enums;

import java.util.Date;

import com.org.enums.WeekDay._WeekDay;

/**
 * @Author:jilongliang
 * @Date :2013-4-26
 * @Project:JavaSE
 * @Class:Enum1.java
 * @Description:
 */
public class Enum1 {
	public static void main(String[] args) {
		WeekDay weekDay = WeekDay.MON;// 周一的明天是SUN
		System.out.println(weekDay.nextDay());

		Week_Day wd = Week_Day.FRI;
		System.out.println("==========================");
		System.out.println(wd);
		System.out.println(wd.FRI);
		System.out.println(wd.name());
		System.out.println(wd.ordinal());
		// 遍历枚举
		for (_WeekDay w : _WeekDay.values()) {
			System.out.println(w);
		}

		new Date(300) {
		};
	}

	public enum TrafficLamp {
		RED(30) {
			@Override
			public TrafficLamp nextLamp() {
				return GREEN;// 绿灯
			}
		},
		GREEN(40) {
			@Override
			public TrafficLamp nextLamp() {
				return YELLOW;// 黄灯
			}
		},
		YELLOW(5) {
			@Override
			public TrafficLamp nextLamp() {
				return RED;// 绿灯
			}
		};

		public abstract TrafficLamp nextLamp();

		private int time;

		private TrafficLamp(int date) {
			this.time = date;
		}
	}
}
