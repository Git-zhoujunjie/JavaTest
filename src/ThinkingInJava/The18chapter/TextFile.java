package ThinkingInJava.The18chapter;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile extends ArrayList<String> {
    private static final String FILEPATH = "/home/zhoujunjie/JavaTest/src/ThinkingInJava/The18chapter/";

    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try{
            BufferedReader in = new BufferedReader(new FileReader(
                    new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while((s= in.readLine())!=null){
                   sb.append(s + "\n");
                }
            }finally {
                in.close();
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static void write(String fileName,String text){
        try{
            PrintWriter out = new PrintWriter(
                    new File(fileName).getAbsoluteFile());
            try{
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        if(get(0).equals("")) remove(0);
    }

    public TextFile(String fileName){ this(fileName,"\n"); }

    public void write(String fileName){
        try{
            PrintWriter out = new PrintWriter(
                    new File(fileName).getAbsoluteFile());
            try{
                for(String s : this)
                    out.println(s);
            } finally {
                out.close();
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    //Simple Test
    public static void main(String[] args){
        String file = read(FILEPATH + "TextFile.java");
        write("/home/zhoujunjie/test.txt",file);
        TextFile text = new TextFile("/home/zhoujunjie/test.txt");
        text.write("/home/zhoujunjie/test2.txt");
        TreeSet<String> words = new TreeSet<>(
                new TextFile(FILEPATH + "TextFile.java","\\W+")
        );

        System.out.println(words.headSet("a"));
    }

}
