package com.msg.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/10 11:19
 */
public class DateUtils {
    public static String dateToString(Date date,String pattern){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String format = simpleDateFormat.format(date);
        return format;
    }

    public static Date StringToDate(String str,String pattern) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(str);
        return date;
    }
}
