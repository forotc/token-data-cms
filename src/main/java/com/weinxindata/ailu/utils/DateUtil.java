package com.weinxindata.ailu.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理
 * 
 * @author Michael
 */
public class DateUtil {
	/** 时间格式(yyyy-MM-dd) */
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	/** 时间格式(yyyy-MM-dd HH:mm) */
	public final static String DATE_TIME_M_PATTERN = "yyyy-MM-dd HH:mm";
	/** 时间格式(yyyyMMddHHmmssSSS) */
	public final static String DATE_TIME_ALL_PATTERN = "yyyyMMddHHmmssSSS";
	/** 时间格式(yyyyMMddHHmmssSSS) */
	public final static String DATE_TIME_S_PATTERN = "yyyyMMddHHmmss";

	public static String format(Date date) {
		return format(date, DATE_TIME_PATTERN);
	}

	public static String format(Date date, String pattern) {
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			return df.format(date);
		}
		return null;
	}

	/**
	 * @Description: String 2 date
	 */
	public static Date parse(String date) {
		return parse(date, DATE_PATTERN);
	}

	public static Date parse(String date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(date.toString());
		} catch (ParseException e) {
			e.printStackTrace();
			return new Date();
		}
	}

	public static Date PlusDay(String date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(parse(date));
		cal.add(Calendar.DAY_OF_MONTH, +day);
		return cal.getTime();
	}

	public static Date PlusDay(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, +day);
		return cal.getTime();
	}

	/**
	 * 相差天数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int differentDaysByMillisecond(Date date1, Date date2) {
		int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
		return days;
	}

}
