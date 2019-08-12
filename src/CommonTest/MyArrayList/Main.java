package CommonTest.MyArrayList;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        String filepath = "D:/DataPoints.csv";
        File csv = new File(filepath);
        csv.setReadable(true);//设置可读

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csv));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String everyLine;
        ArrayList<String> allString = new ArrayList<>();
        try {
            while ((everyLine = br.readLine()) != null) // 读取到的内容给line变量
            {
                String items[] = everyLine.split(",");

                for (int i=0;i<items.length;i++)
                {
                    String s = items[i];
                    int a = s.length();
                    double item = Double.parseDouble(s);
                    System.out.println(item);
                }
                System.out.println();
            }
            System.out.println("csv表格中所有行数：" + allString.size());
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(allString);






    }




}
