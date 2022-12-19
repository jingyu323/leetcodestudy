package rain.test.study20221219;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;


public class DateUtils {
    public static String YYYY = "yyyy";
    public static String YYYYMMDD = "yyyyMMdd";
    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static String MIN_TYPE = "MIN";


    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String MM_DD_HH_MM = "MM-dd HH:mm";
    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 将数据库中time类型的字段转化成DateTime类型的字段
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date dateTrans(Date date) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm:ss");

        String str1 = sdf2.format(new Date());
        String str2 = sdf3.format(date);

        return sdf1.parse(str1 + " " + str2);
    }

    public static String stampToStringDate(String value) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        long lt = new Long(value);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    public static Date stampToDate(String value) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        long lt = new Long(value) * 1000;
        Date date = new Date(lt);
        return date;
    }

    public static Date stampCurrentMilesToDate(String value) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        long lt = new Long(value);
        Date date = new Date(lt);
        return date;
    }


    public static Date dateAdd(Date date, String type, Integer interval) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        switch (type) {
            case "YEAR":
                calendar.add(Calendar.YEAR, interval);
                break;
            case "MONTH":
                calendar.add(Calendar.MONTH, interval);
                break;
            case "DATE":
                calendar.add(Calendar.DATE, interval);
                break;
            case "MIN":
                calendar.add(Calendar.MINUTE, interval);
        }
        return calendar.getTime();
    }

    /**
     * 计算结束时间经过秒数
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static int calSeconds(Date startTime, Date endTime) {
        long a = endTime.getTime();
        long b = startTime.getTime();
        int c = (int) ((a - b) / 1000);
        return c;
    }

    /**
     * 计算两个时间差多少分钟
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static int calMinus(Date startTime, Date endTime) {
        return calSeconds(startTime, endTime) / 60;
    }


    public static final String parseDateToStr(final String format, final Date date) {
        return new SimpleDateFormat(format).format(date);
    }


    public static final Date parseStrToDate(final String format, final String date) throws ParseException {
        return new SimpleDateFormat(format).parse(date);
    }

    // 获得某天最大时间 2017-10-15 23:59:59
    public static Date getEndOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    // 获得某天最小时间 2017-10-15 00:00:00
    public static Date getStartOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }


    /**
     * 比较日期大小
     *
     * @param start
     * @param end
     * @return
     * @throws ParseException
     */
    public static final boolean compareDate(final Date start, final Date end) throws ParseException {
        if (end.compareTo(start) > 0) {
            return true;
        }

        return false;
    }

    public static final int compareDateIntRes(final Date start, final Date end) throws ParseException {

        return end.compareTo(start);
    }


}
