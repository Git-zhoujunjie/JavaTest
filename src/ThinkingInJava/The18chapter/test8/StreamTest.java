package ThinkingInJava.The18chapter.test8;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class StreamTest {
    public static List<String> read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filename = br.readLine();
        BufferedReader io = new BufferedReader(
                new FileReader(filename));
        List<String> list = new LinkedList<>();
        String s;
        while((s = io.readLine())!=null)
            list.add(s);
        return list;
    }

    public static void main(String[] args) throws IOException{
        System.out.println("Please Input the full filePath:");
        List<String> l = read();
        for(int i = l.size()-1;i>=0;i--){
            System.out.println(l.get(i));
        }
    }
}
