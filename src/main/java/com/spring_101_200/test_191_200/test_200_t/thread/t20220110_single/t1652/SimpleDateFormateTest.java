package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t1652;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormateTest extends Thread {


    private SimpleDateFormat sdf;

    private String dateString;

    public SimpleDateFormateTest(SimpleDateFormat sdf, String dateString) {
        this.sdf = sdf;
        this.dateString = dateString;
    }

    @Override
    public void run() {
        try {
            Date dateRef = sdf.parse(dateString);
            String newDateString = sdf.format(dateRef).toString();
            if (!newDateString.equals(dateString)) {
                System.out.println("ThreadName = "  +dateRef + "   "  + this.getName() + " 报错了日期字符串：" + dateString + " 转化的日期为 " + newDateString);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        String[] dateStringArray = new String[]{"2000-01-01", "2000-01-02", "2000-01-03", "2000-01-04"
                , "2000-01-05", "2000-01-06", "2000-01-07", "2000-01-08", "2000-01-09", "2000-01-10"};

        SimpleDateFormateTest[] threadArray = new SimpleDateFormateTest[dateStringArray.length];
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i] = new SimpleDateFormateTest(sdf, dateStringArray[i]);
        }
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i].start();
        }

    }
}
