package javaTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date lastDayOfQuarter = getLastDayOfQuarter(2023, 3);
        String strDateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);

//        Calendar instance = Calendar.getInstance();
//        Date time = instance.getTime();
//        int i = lastDayOfQuarter.compareTo(time);
        System.out.printf(sdf.format(lastDayOfQuarter));
    }


    public static Date getLastDayOfQuarter(int year, int quarter) {

        int lastMonth = quarter * 3 - 1;

        // 根据月获取开始时间
        // 根据月获取开始时间
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, lastMonth);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));

        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        return cal.getTime();
    }
}
