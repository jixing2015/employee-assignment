package com.sw.basis.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author jixing2000
 * <p>
 * 描述:日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 */
public class DateUtils {

	private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
			"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd", "yyyyMMdd",
			"yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM" , "yyyyMM" };

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDateStryyyyMMdd() {
		return getDate("yyyyMMdd");
	}

	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}

	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date != null ? date : new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	public static String formatDateToYyyyMmm(Date date) {
		return formatDate(date != null ? date : new Date(), "yyyyMM");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 获取去年年份
	 */
	public static String getPrevYear(String year) {

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, Integer.valueOf(year));
		calendar.add(Calendar.YEAR, -1);

		return formatDate(calendar.getTime(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}

	/**
	 * 获取过去的天数
	 * 
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = System.currentTimeMillis() - date.getTime();
		return t / (24 * 60 * 60 * 1000);
	}

	/**
	 * 获取过去的小时
	 * 
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = System.currentTimeMillis() - date.getTime();
		return t / (60 * 60 * 1000);
	}

	/**
	 * 获取过去的分钟
	 * 
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = System.currentTimeMillis() - date.getTime();
		return t / (60 * 1000);
	}

	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * 
	 * @param timeMillis
	 * @return
	 */
	public static String formatDateTime(long timeMillis) {
		long day = timeMillis / (24 * 60 * 60 * 1000);
		long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
		long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
		return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
	}

	/**
	 * 获取两个日期之间的天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}

	/**
	 * 返回某一年某一月的天数</br>
	 * 例如：获取2018年3月份的天数</br>
	 * getDaysInMonth(2018,3) =>> 31
	 * 
	 * @param year  统计天数的年份
	 * @param month 统计天数的月份
	 * @return daysInMonth
	 */
	public static int getDaysInMonth(String year, String month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.valueOf(year));
		// Java月份才0开始算
		cal.set(Calendar.MONTH, Integer.valueOf(month) - 1);
		int daysInMonth = cal.getActualMaximum(Calendar.DATE);
		return daysInMonth;
	}

	/**
	 * 将指定字符串格式的字符串转为另一种日期格式
	 *
	 * @param date         日期字符串
	 * @param sourceFormat 源格式
	 * @param returnFormat 目标格式
	 * @return 返回格式化的日期
	 * @throws ParseException 分析时意外地出现了错误异常
	 */
	public static String strToDateFormat(String date, String sourceFormat, String returnFormat) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(sourceFormat);
		formatter.setLenient(false);
		Date newDate = formatter.parse(date);
		formatter = new SimpleDateFormat(returnFormat);
		return formatter.format(newDate);
	}

	/**
	 * 描述:返回两个日期相差天数
	 * 参数:@param fDate 参数:@param oDate 参数:@return
	 */
	public static int daysOfTwo(Date fDate, Date oDate) {
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(fDate);
		int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
		aCalendar.setTime(oDate);
		int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
		return day2 - day1;
	}

	/**
	 * 格式化CST时间为 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param cstDateStr
	 * @return
	 * @throws Exception
	 */
	public static String formatCstDate(String cstDateStr, String format) throws Exception {
		if (format == null || "".equals(format)) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		Date date = null;
		SimpleDateFormat sdf1 = null;
		SimpleDateFormat sdf2 = new SimpleDateFormat(format);
		try {
			sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
			date = sdf1.parse(cstDateStr);
		} catch (ParseException e) {
			sdf1 = new SimpleDateFormat("yyyy'年' MM'月' dd'日' EEE HH:mm:ss Z", Locale.CHINA);
			try {
				date = sdf1.parse(cstDateStr);
			} catch (ParseException e1) {
				throw new Exception("CST日期格式转换出错，原因：" + e.getMessage());
			}
		}
		return sdf2.format(date);
	}

	/**
	 * 把Calendar的时分秒毫秒都设置为0
	 * 
	 * @param c
	 * @return
	 */
	public static Calendar calendarTimeSetZero(Calendar c) {
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c;
	}

	public static boolean checkDateBigOrSmall(Date startDate, Date endDate) {

		if (startDate == null || endDate == null) {
			return false;
		}

		if (startDate.getTime() <= endDate.getTime()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 比较时间大小
	 * @param date1 时间1
	 * @param date2 时间2
	 * @return 结果 1表示date1在date2之后  0表示相等  -1 表示date1在date2之前
	 */
	public static int compareDate(String date1, String date2) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date dt1 = sdf.parse(date1);
			Date dt2 = sdf.parse(date2);
			if (dt1.getTime() > dt2.getTime()) {
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	/**
	 * 两个日期相减得到的天数
	 *
	 * @param beginDate 开始时间（被减）
	 * @param endDate 结束时间
	 * @return 返回正数，表示beginDate在endDate之前；0表示相等；负数表示beginDate在endDate之后
	 */
	public static int getDiffDays(Date beginDate, Date endDate) {
		if (beginDate == null || endDate == null) {
			throw new IllegalArgumentException("getDiffDays param is null!");
		}
		long diff = (endDate.getTime() - beginDate.getTime()) / (1000 * 60 * 60 * 24);
		int days = new Long(diff).intValue();
		return days;
	}

}
