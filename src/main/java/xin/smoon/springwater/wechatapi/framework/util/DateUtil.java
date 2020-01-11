package xin.smoon.springwater.wechatapi.framework.util;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
public class DateUtil {

    private static final String COLONS = ":";
    private static final ZoneId ZONE = ZoneId.systemDefault();
    private static final DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter YYYY_MM_DD_HH_MM_SS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 转化Date至时间字符串
     *
     * @param date
     * @return
     */
    public static String convertDate2YYYY_MM_DD(Date date) {
        final LocalDateTime localDateTime = dateToLocalDateTime(date);
        return localDateTime.format(YYYY_MM_DD);
    }

    /**
     * 转化时间字符串至 Date
     *
     * @param strDate
     * @return
     */
    public static Date convertStr2Date(String strDate) {
        return strDate.contains(COLONS) ? localDateTimeToDate(convertStr2LocalDateTime(strDate)) :
            localDateToDate(convertStr2LocalDate(strDate));
    }

    /**
     * 转化时间字符串至 LocalDate
     *
     * @param strDate
     * @return
     */
    public static LocalDate convertStr2LocalDate(String strDate) {
        return LocalDate.parse(strDate, YYYY_MM_DD);
    }

    /**
     * 转化时间字符串至 LocalDateTime
     *
     * @param strDate
     * @return
     */
    public static LocalDateTime convertStr2LocalDateTime(String strDate) {
        return LocalDateTime.parse(strDate, YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * java.util.Date --> java.time.LocalDateTime
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZONE);
    }

    /**
     * java.util.Date --> java.time.LocalDate
     */
    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZONE);
        return localDateTime.toLocalDate();
    }

    /**
     * java.util.Date --> java.time.LocalTime
     */
    public static LocalTime dateToLocalTime(Date date) {
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZONE);
        return localDateTime.toLocalTime();
    }

    /**
     * java.time.LocalDateTime --> java.util.Date
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        Instant instant = localDateTime.atZone(ZONE)
            .toInstant();
        return Date.from(instant);
    }

    /**
     * java.time.LocalDate --> java.util.Date
     */
    public static Date localDateToDate(LocalDate localDate) {
        Instant instant = localDate.atStartOfDay()
            .atZone(ZONE)
            .toInstant();
        return Date.from(instant);
    }

    public static String formatDate(Date date, String format) {

        if (date == null) {
            return StringUtils.EMPTY;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        }
    }
}
