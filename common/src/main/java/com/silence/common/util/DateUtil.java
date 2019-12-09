package com.silence.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/***
 * Created with IntelliJ IDEA.
 * Description: 日期工具类
 * User: silence
 * Date: 2019-12-06
 * Time: 上午10:15
 */
public class DateUtil {

    public final static String YYYY = "yyyy";
    public final static String MM = "MM";
    public final static String DD = "dd";
    public final static String YYYY_MM_DD = "yyyy-MM-dd";
    public final static String YYYY_MM = "yyyy-MM";
    public final static String HH_MM_SS = "HH:mm:ss";
    public final static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static String formatStr_yyyyMMddHHmm = "yyyy-MM-dd HH:mm";
    public static String formatStr_yyyyMMddHH = "yyyy-MM-dd HH";

    public static String begin = "";
    public static String end = "";

    private static final int DAY_MILLISECOND = 86400000;

    /**
     * 日期格式化－将<code>Date</code>类型的日期格式化为<code>String</code>型
     * @param date 日期
     * @param pattern   格式化字串
     * @return 返回类型 String 日期字符串
     */
    public static String format(Date date, String pattern) {
        if (date == null){
            return "";
        } else {
            return getFormatter(pattern).format(date);
        }
    }

    /**
     * 将日期类型转换为simpleDateFormat类型
     * @param pattern   要转换的日期类型
     * @return 返回类型 SimpleDateFormat 返回一个SimpleDateFormat类型的日期字符串
     */
    private static SimpleDateFormat getFormatter(String pattern) {
        return new SimpleDateFormat(pattern);
    }

    /**
     * 默认把日期格式化成yyyy-MM-dd格式
     * @param date   被格式化的时间
     * @return 返回类型 String 日期字符串
     */
    public static String formatYD(Date date) {
        if (date == null)
            return "";
        else
            return getFormatter(YYYY_MM_DD).format(date);
    }

    /**
     * 默认把日期格式化成yyyy-MM-dd格式
     * @param date   被格式化的时间
     * @return 返回类型 String 日期字符串
     */
    public static String formatYS(Date date) {
        if (date == null)
            return "";
        else
            return getFormatter(YYYY_MM_DD_HH_MM_SS).format(date);
    }

    /**
     * 将指定日期格式化成"yyyy年M月d日"的形式，如将2000-01-01转换为2000年1月1日
     * @param date  指定日期
     * @return 返回类型 String 格式化后日期字串
     */
    public static String getChineseDate(Date date) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.CHINESE);
        String strDate = df.format(date);
        return strDate;
    }

    /**
     * 获取当前月
     * @return 返回类型 String 获取当前月
     */
    public static String getMonth() {
        Calendar cal = Calendar.getInstance();
        return format(cal.getTime(), MM);
    }

    /**
     * 求当前日期和指定日期的相差天数
     * @param date 指定字符串日期,如: new Date()
     * @return 返回类型 long 当前日期和指定字符串日期的相差天数
     */
    public static long getTodayIntevalDays(Date date) {
        try {
            Date currentDate = new Date();
            long days = (currentDate.getTime() - date.getTime()) / (24 * 60 * 60 * 1000);
            return days;
        } catch (Exception ee) {
            return 0l;
        }
    }

    /**
     * 把指定时间字符串转换成指定日期型
     * @param dateTimeStr   指定时间字符
     * @param formatString 指定时间日期类型,如：yyyy_MM_dd
     * @return 返回类型 Date 转换后的日期
     */
    private static Date parseToDate2(String dateTimeStr, String formatString) {
        Date d = null;
        SimpleDateFormat sdf = new SimpleDateFormat(formatString);
        try {
            d = sdf.parse(dateTimeStr);
        } catch (ParseException pe) {
        }
        return d;
    }

    /**
     * 根据指定年,月,日得到一周的第几天
     * @param year 指定年
     * @param month  指定月
     * @param day   指定日
     * @return 返回类型 int 得到一周的第几天
     */
    public static int getDayOfWeek(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month - 1, day);
        int dayofWeek = cal.get(Calendar.DAY_OF_WEEK);
        switch (dayofWeek) {
            case 1:
                dayofWeek = 7;
                break;
            case 2:
                dayofWeek = 1;
                break;
            case 3:
                dayofWeek = 2;
                break;
            case 4:
                dayofWeek = 3;
                break;
            case 5:
                dayofWeek = 4;
                break;
            case 6:
                dayofWeek = 5;
                break;
            case 7:
                dayofWeek = 6;
                break;
        }
        return dayofWeek;
    }

    /**
     * 根据指定年,月,日得到一年的第几周
     * @param year    指定年
     * @param month    指定月
     * @param day     指定日
     * @return 返回类型 int 得到一年的第几周
     */
    public static int getWeekOfYear(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month - 1, day);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 根据指定年,月,日得到一月的第几天
     * @param year  指定年
     * @param month  指定月
     * @param day  指定日
     * @return 返回类型 int 得到一月的第几天
     */
    public static int getDayOfMonth(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month - 1, day);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 当返回值为true时表示指定时间与当前时间之差在24小时内，若为false则表示不在24小时之内
     * @param time 指定时间串 如:"12000293293"
     * @return 返回类型 boolean 指定时间与当前时间之差在24小时内，若为false则表示不在24小时之内
     */
    public static boolean dateCompare(String time) {
        Date date = new Date();
        Long dateLongValue = date.getTime();
        Long timeLongVlaue = 0L;
        if (time != null && !time.equals("")) {
            timeLongVlaue = Long.parseLong(time);
        }
        if ((dateLongValue - timeLongVlaue) <= DAY_MILLISECOND) {
            return true;
        }
        return false;
    }

    /**
     * 当返回值为true时表示指定时间与当前时间之差在同一月，若为false则表示不在同一月
     * @param time  指定时间串 如:"12000293293"
     * @return 返回类型 boolean 指定时间与当前时间之差在同一月，若为false则表示不在同一月
     */
    public static boolean compare(String time) {
        Date currentDate = new Date();
        int currentDay;
        int compareDay;
        Long timeLongVlaue = 0L;
        if (time != null && !time.equals("")) {
            timeLongVlaue = Long.parseLong(time);
        }
        Date compareDate = new Date(timeLongVlaue);
        Calendar compareCalendar = Calendar.getInstance();
        Calendar currentCalendar = Calendar.getInstance();
        currentCalendar.setTime(currentDate);
        compareCalendar.setTime(compareDate);
        currentDay = currentCalendar.get(Calendar.DAY_OF_MONTH);
        compareDay = compareCalendar.get(Calendar.DAY_OF_MONTH);
        int temp = currentDay - compareDay;
        if (temp == 1 || temp == 0) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(DateUtil.format(new Date(),DateUtil.YYYY_MM_DD_HH_MM_SS));
        System.out.println(DateUtil.getMonth());
        System.out.println(DateUtil.parseToDate2("2019-12-06 10:47:05","yyyy-MM-dd hh:mm:ss"));
    }

}
