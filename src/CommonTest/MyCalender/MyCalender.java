package CommonTest.MyCalender;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 一个自动生成日历的小程序
 *
 */
public class MyCalender {
    public static void main(String[] args) throws ParseException {

        //String str = "2020-10-1";

        Scanner in = new Scanner(System.in);
        System.out.println("请输入日期，格式如（2019-1-15）：");
        String str = in.nextLine();

        System.out.println("日\t一\t二\t三\t四\t五\t六");

        //将字符串转变为日期
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = df.parse(str);
        //System.out.println(d);
        Calendar c = new GregorianCalendar();
        c.setTime(d);
        //System.out.println(c);
        for(int i =0;i<c.get(Calendar.DAY_OF_WEEK)-1;i++){
            System.out.print("\t");
        }
        int maxD = c.getActualMaximum(Calendar.DATE);

        int day = c.get(Calendar.DAY_OF_MONTH);
        //int c1 = 1;
        c.set(Calendar.DAY_OF_MONTH,1);
        for(int i=1;i<=maxD;i++){
            if(c.get(Calendar.DAY_OF_MONTH) == day){
                System.out.print(c.get(Calendar.DAY_OF_MONTH) + "*\t");
            }else {
                System.out.print(c.get(Calendar.DAY_OF_MONTH) + "\t");
            }
            if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
                System.out.println();

            c.add(Calendar.DATE,1);
        }
    }
}
