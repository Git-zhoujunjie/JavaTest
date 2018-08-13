package ThinkingInJava.The18chapter;

import java.io.*;

public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("/home/zhoujunjie/Data.txt")
                )
        );
        out.writeDouble(12.34);
        out.writeUTF("This is pi");
        out.writeBoolean(true);
        out.writeBytes("qwefa");
        out.writeChar('d');
        out.writeUTF("Square root of 2");
        out.close();
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("/home/zhoujunjie/Data.txt")
                )
        );
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
    }
}
