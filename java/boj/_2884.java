package boj;

import java.util.Scanner;

public class _2884 {
	/* 알람 시계 */
	public static final int MINUTE_45 = 45;
	public static final int MINUTE_60 = 60;
	public static final int HOUR_23 = 23;

	class Alarm {
		private int hour;
		private int minute;

		public Alarm(int hour, int minute) {
			this.hour = hour;
			this.minute = minute;
			setAlarm();
		}

		private void setHour() {
			if (hour - 1 > 0)
				hour--;
			else
				hour = HOUR_23;
		}

		private void setAlarm() {
			int temp = minute - MINUTE_45;
			if (isVaild())
				minute -= MINUTE_45;
			else {
				setHour();
				minute = MINUTE_60 + temp;
			}
		}

		private boolean isVaild() {
			int temp = minute - MINUTE_45;
			if (temp < 0)
				return false;
			return true;
		}

		private String answer() {
			return hour + " " + minute;
		}
	}

	public void go() {
		Scanner sc = new Scanner(System.in);
		int h, m;
		h = sc.nextInt();
		m = sc.nextInt();
		Alarm alarm = new Alarm(h, m);
		System.out.println(alarm.answer());
	}
}
