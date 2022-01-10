package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t1652;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadSimpleDateFormateTest extends Thread {


    private String dateString;

    public ThreadSimpleDateFormateTest(SimpleDateFormat sdf, String dateString) {
        this.dateString = dateString;
    }

    public static Date parse(String formatePattern, String dateString) throws Exception {
        return new SimpleDateFormat(formatePattern).parse(dateString);
    }

    public static String formate(String formatePattern, Date date) {
        return new SimpleDateFormat(formatePattern).format(date).toString();
    }

    public static ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<>();

    public static SimpleDateFormat getSimpleDateFormate(String datePattern) {
        SimpleDateFormat sdf = null;
        sdf = t1.get();
        if (sdf == null) {
            sdf = new SimpleDateFormat(datePattern);
            t1.set(sdf);
        }
        return sdf;
    }


    @Override
    public void run() {
        try {
            Date dateRef = parse("yyy-MM-dd", dateString);
            String newDateString = formate("yyy-MM-dd", dateRef).toString();
            if (!newDateString.equals(dateString)) {
                System.out.println("ThreadName = " + this.getName() + " 报错了日期字符串：" + dateString + " 转化的日期为 " + newDateString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        String[] dateStringArray = new String[]{"2000-01-01", "2000-01-02", "2000-01-03", "2000-01-04"
                , "2000-01-05", "2000-01-06", "2000-01-07", "2000-01-08", "2000-01-09", "2000-01-10"};

        ThreadSimpleDateFormateTest[] threadArray = new ThreadSimpleDateFormateTest[dateStringArray.length];
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i] = new ThreadSimpleDateFormateTest(sdf, dateStringArray[i]);
        }
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i].start();
        }

    }
}
