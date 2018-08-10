package ThinkingInJava.The18chapter.test7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class StreamTest {
    public static List<String> read(String filename) throws IOException {
        BufferedReader io = new BufferedReader(
                new FileReader(filename));
//        StringBuilder sb = new StringBuilder();
        List<String> list = new LinkedList<>();
        String s;
        while((s = io.readLine())!=null)
//            sb.append(s + "\n");
            list.add(s);
//        return sb.toString();
        return list;
    }

    public static void main(String[] args) throws IOException{
        List<String> l = read("/home/zhoujunjie/wifi");
        for(int i = l.size()-1;i>=0;i--){
            System.out.println(l.get(i));
        }
    }
}
