package ThinkingInJava.The18chapter.test10;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StreamTest {
    public static List<String> read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filename = br.readLine();
        BufferedReader io = new BufferedReader(
                new FileReader(filename));
        List<String> list = new ArrayList<>();
        String st;
        ArrayList a = new ArrayList();
        while((st = io.readLine())!=null)
            list.add(st.toUpperCase());
        return list;
    }

    public static void main(String[] args) throws IOException{
        System.out.println("Please Input the full filePath:");
        List<String> l = read();
        for(int i = l.size()-1;i>=0;i--){
            System.out.println(l.get(i));
        }
        System.out.print("Please Input the Word you want:");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for(int i = l.size()-1;i>=0;i--){
            if(l.get(i).contains(str))
                System.out.println(l.get(i));
        }
    }
}
