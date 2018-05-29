package com.echomu.androidlib.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期时间帮助类
 * Created by echoMu on 2017/3/7.
 */

public class DateUtil {

    private static final long ONE_MINUTE = 60000L;
    private static final long ONE_HOUR = 3600000L;
    private static final long ONE_DAY = 86400000L;
    private static final long ONE_WEEK = 604800000L;

    private static final String ONE_SECOND_AGO = "秒前";
    private static final String ONE_MINUTE_AGO = "分钟前";
    private static final String ONE_HOUR_AGO = "小时前";
    private static final String ONE_DAY_AGO = "天前";
    private static final String ONE_MONTH_AGO = "月前";
    private static final String ONE_YEAR_AGO = "年前";

    private static final String ONE_SECOND_LATER = "秒";
    private static final String ONE_MINUTE_LATER = "分钟";
    private static final String ONE_HOUR_LATER = "小时";
    private static final String ONE_DAY_LATER = "天";
    private static final String ONE_MONTH_LATER = "个月";
    private static final String ONE_YEAR_LATER = "年";

    /**
     * 一星期的字符数组
     */
    public static final String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四",
            "星期五", "星期六"};

    /**
     * 一天中每个时段的字符数组
     */
    public static final String[] dayParts = {"凌晨", "早上", "上午", "中午", "下午", "晚上"};

    /**
     * 当前时间的日历
     */
    public static Calendar calendar = Calendar.getInstance();

    /**
     * 日期格式yyyy-MM字符串常量
     */
    public static final String MONTH_FORMAT = "yyyy-MM";

    /**
     * 日期格式yyyy-MM-dd字符串常量
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 日期格式yyyy-MM-dd HH:mm字符串常量
     */
    public static final String DATE_HOUR_FORMAT = "yyyy-MM-dd HH:mm";

    /**
     * 日期格式HH:mm:ss字符串常量
     */
    public static final String HOUR_FORMAT = "HH:mm:ss";

    /**
     * 日期格式yyyy-MM-dd HH:mm:ss字符串常量
     */
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";


    /****************************** 指定格式的时间转换操作 ***********************************/

    /**
     * 按照指定的文本格式返回当前时间
     *
     * @param format 默认格式：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getDateStr(String format) {
        if (format == null || "".equals(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        return new SimpleDateFormat(format).format(new Date());
    }

    /**
     * 转换时间戳为月日<br>
     * 将服务器获取的10位时间戳String时间转换成long类型*1000+"" 在转换成日期格式的string
     *
     * @param str
     * @return
     */
    public static String toTime1(String str) {
        long time = Long.parseLong(str) * 1000;
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日");
        Date d = new Date(time);
        String t = format.format(d);
        return t;
    }

    /**
     * 转换时间戳为时分
     */
    public static String toTime2(String str) {
        long time = Long.parseLong(str) * 1000;
        SimpleDateFormat format1 = new SimpleDateFormat("kk:mm");
        Date d = new Date(time);
        String t1 = format1.format(d);
        return t1;
    }

    /**
     * 转换时间戳为年月日 时分
     */
    public static String toTime3(String str) {
        long time = Long.parseLong(str) * 1000;
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日		kk:mm");
        Date d = new Date(time);
        String t = format.format(d);
        return t;
    }

    /**
     * 转换时间戳为年月日
     * yyyy年MM月dd日
     */
    public static String toTime4(String str) {
        long time = Long.parseLong(str);
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        Date d = new Date(time);
        String t = format.format(d);
        return t;
    }

    /**
     * 转换时间戳为2016.3.25<br>
     * 将服务器获取的10位时间戳String时间转换成long类型*1000+"" 在转换成日期格式的string
     *
     * @param str
     * @return
     */
    public static String toTime5(String str) {
        long time = Long.parseLong(str) * 1000;
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        Date d = new Date(time);
        String t = format.format(d);
        return t;
    }

    /**
     * 转换时间戳为2016-3-25<br>
     *
     * @return
     */
    public static String toTime6(Long time) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        Date d = new Date(time);
        String t = format.format(d);
        return t;
    }

    /****************************** 按照不同时期的时间转换操作 ***********************************/

    private static long toSeconds(long date) {
        return date / 1000L;
    }

    private static long toMinutes(long date) {
        return toSeconds(date) / 60L;
    }

    private static long toHours(long date) {
        return toMinutes(date) / 60L;
    }

    private static long toDays(long date) {
        return toHours(date) / 24L;
    }

    private static long toMonths(long date) {
        return toDays(date) / 30L;
    }

    private static long toYears(long date) {
        return toMonths(date) / 365L;
    }

    /**
     * 几秒前，几分钟前，几小时前，几天前，几月前，几年前的转换
     *
     * @param time
     * @return
     */
    public static String format(String time) {
        if (StringUtils.isEmpty(time)) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:m:s");
        Date date = null;
        long delta = 0;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        delta = new Date().getTime() - date.getTime();

        if (delta < 1L * ONE_MINUTE) {
            long seconds = toSeconds(delta);
            return "刚刚";
        }
        if (delta < 60L * ONE_MINUTE) {
            long minutes = toMinutes(delta);
            return (minutes <= 0 ? 1 : minutes) + ONE_MINUTE_AGO;
        }
        if (delta < 24L * ONE_HOUR) {
            long hours = toHours(delta);
            return (hours <= 0 ? 1 : hours) + ONE_HOUR_AGO;
        }
        if (delta < 48L * ONE_HOUR) {
            return "昨天";
        }
        if (delta < 72L * ONE_HOUR) {
            return "前天";
        }
        if (delta < 356L * ONE_DAY) {
            return time.substring(5, 10);
        } else {
            return time.substring(0, 10);
        }
    }

    /**
     * 当天：hh:mm
     * 当年：mm-dd
     * 非当年：yyyy-mm-dd
     *
     * @param time
     * @return
     */
    public static String format2(String time) {
        if (StringUtils.isEmpty(time)) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:m:s");
        Date date = null;
        long delta = 0;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        delta = new Date().getTime() - date.getTime();

        if (delta < 24L * ONE_HOUR) {
            return time.substring(11, 16);
        }
        if (delta < 356L * ONE_DAY) {
            return time.substring(5, 10);
        } else {
            return time.substring(0, 10);
        }
    }

    /**
     * 当天：“刚刚”、“x分钟前”、“x小时前”
     * 当年：mm-dd
     * 非当年：yyyy-mm-dd
     *
     * @param time
     * @return
     */
    public static String format3(String time) {
        if (StringUtils.isEmpty(time)) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:m:s");
        Date date = null;
        long delta = 0;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        delta = new Date().getTime() - date.getTime();

        if (delta < 1L * ONE_MINUTE) {
            long seconds = toSeconds(delta);
            return "刚刚";
        }
        if (delta < 60L * ONE_MINUTE) {
            long minutes = toMinutes(delta);
            return (minutes <= 0 ? 1 : minutes) + ONE_MINUTE_AGO;
        }
        if (delta < 24L * ONE_HOUR) {
            long hours = toHours(delta);
            return (hours <= 0 ? 1 : hours) + ONE_HOUR_AGO;
        }
        if (delta < 356L * ONE_DAY) {
            return time.substring(5, 10);
        } else {
            return time.substring(0, 10);
        }
    }

    /**
     * 当天：“刚刚”、“x分钟前”、“x小时前”
     * 当年：mm-dd hh:mm
     * 非当年：yyyy-mm-dd hh:mm
     *
     * @param time
     * @return
     */
    public static String format4(String time) {
        if (StringUtils.isEmpty(time)) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:m:s");
        Date date = null;
        long delta = 0;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        delta = new Date().getTime() - date.getTime();

        if (delta < 1L * ONE_MINUTE) {
            long seconds = toSeconds(delta);
            return "刚刚";
        }
        if (delta < 60L * ONE_MINUTE) {
            long minutes = toMinutes(delta);
            return (minutes <= 0 ? 1 : minutes) + ONE_MINUTE_AGO;
        }
        if (delta < 24L * ONE_HOUR) {
            long hours = toHours(delta);
            return (hours <= 0 ? 1 : hours) + ONE_HOUR_AGO;
        }
        if (delta < 356L * ONE_DAY) {
            return time.substring(5, 16);
        } else {
            return time.substring(0, 16);
        }
    }

    /**
     * 今天，昨天，前天，mm－dd的转换
     *
     * @param time
     * @return
     */
    public static String formatForEventContent(String time) {
        if (StringUtils.isEmpty(time)) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:m:s");
        Date date = null;
        long delta = 0;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        delta = new Date().getTime() - date.getTime();

        if (delta < 24L * ONE_HOUR) {
            return "今天";
        }
        if (delta < 48L * ONE_HOUR) {
            return "昨天";
        }
        if (delta < 72L * ONE_HOUR) {
            return "前天";
        }
        if (delta < 356L * ONE_DAY) {
            return time.substring(5, 10);
        } else {
            return time.substring(0, 10);
        }
    }

    /**
     * 几天后的转换
     *
     * @param time
     * @return
     */
    public static String formatLater(String time) {
        if (StringUtils.isEmpty(time)) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:m:s");
        Date date = null;
        long delta = 0;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        delta = date.getTime() - new Date().getTime();

        if (delta > 0) {
            if (delta < 48L * ONE_HOUR) {
                return "1天";
            }
            if (delta < 30L * ONE_DAY) {
                long days = toDays(delta);
                return (days <= 0 ? 1 : days) + ONE_DAY_LATER;
            }
            if (delta < 12L * 4L * ONE_WEEK) {
                long months = toMonths(delta);
                return (months <= 0 ? 1 : months) + ONE_MONTH_LATER;
            } else {
                long years = toYears(delta);
                // return (years <= 0 ? time : (years+ ONE_YEAR_LATER)) ;
                return (years <= 0 ? 1 : years) + ONE_YEAR_LATER;
            }
        } else {
            return "0";
        }
    }

    /**
     * 判断DATE1是否在DATE12前
     * @param DATE1
     * @param DATE2
     */
    public static boolean compareDate(String DATE1, String DATE2){
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d1=dateFormat.parse(DATE1);
            Date d2=dateFormat.parse(DATE2);
            if (d1.getTime() > d2.getTime()) {
                return true;
            }else {

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return false;
    }

}
