package test.Date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date day1 = new Date();    //创建一个日期对象
        System.out.println("当前的毫秒数是："+day1.getTime());

        //格式化日期，把日期转化成字符串
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//HH表示为24小时制
        System.out.println("当前的时间是："+sdf.format(day1));

        //把字符串转化为一个日期对象
        try {
            Date day2 = sdf.parse("2000-02-10 12:25:16");
            System.out.println("转换的时间是："+sdf.format(day2));

            //日期的比较
            System.out.println("day1 在 day2 之前?" +day1.before(day2));//before返回的是一个布尔值
            System.out.println("day1 在 day2 之后?" +day1.after(day2));

            //精确的比较的话 就比较两个数的毫秒数
            long day1Time = day1.getTime();
            long day2Time = day2.getTime();
            System.out.println("day1 是否和 day2 完全一致?"+(day1Time==day2Time));
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
