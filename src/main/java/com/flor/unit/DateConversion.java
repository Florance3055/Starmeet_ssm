package com.flor.unit;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateConversion {

    /**
     * 时间戳转日期/时间
     *
     * @param seconds 时间戳
     * @param pattern 时间格式
     * @return 格式化的时间
     */
    public static String timeStamp2Date(long seconds, String pattern) {
        String time = "暂无数据";
        LocalDateTime dateTime = LocalDateTime.ofEpochSecond(seconds / 1000L, 0, ZoneOffset.ofHours(8));
        if (seconds != 0) time = dateTime.format(DateTimeFormatter.ofPattern(pattern));
        return time;
    }

    /**
     * 日期/时间转时间戳
     * @param date 时间
     * @param pattern 时间格式
     * @return  时间戳
     */
    public static long date2TimeStamp(String date,String pattern) throws DateTimeParseException {
        long timeStamp ;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime localDateTime = LocalDateTime.parse(date);
        timeStamp = localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        return timeStamp;
    }


}
