package ThinkingInJava.The18chapter;

import java.io.*;

public class BasicFIleOutput {
    static String file = "/home/zhoujunjie/BasicFIleOutput.out";
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("/home/zhoujunjie/wifi")));
        PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(file)));
        int linecount = 1;
        String s;
        while((s = in.readLine())!=null)
            out.println(linecount++ + ": " + s);
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
