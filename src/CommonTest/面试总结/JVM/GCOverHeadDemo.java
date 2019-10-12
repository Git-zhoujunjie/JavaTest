package CommonTest.面试总结.JVM;

import java.util.ArrayList;
import java.util.List;

public class GCOverHeadDemo {

    public static void main(String[] args) {
        int i=0;
        List<String> list = new ArrayList<>();

        try {
            while (true){
                list.add(String.valueOf(++i).intern());
            }
        }catch (Throwable e){
            e.printStackTrace();
        }
    }
}
