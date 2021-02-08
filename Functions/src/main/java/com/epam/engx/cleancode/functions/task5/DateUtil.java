package com.epam.engx.cleancode.functions.task5;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public Date changeToMidnight(Date date, boolean up) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		setTime(calender,up);
		return calendar.getTime();
	}
	
	private void setTime(Calender calender, boolean hasOffset) {
		calendar.add(Calendar.DATE, up ? 1 : -1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
	}
	

}
