package CommonTest.TestFileTree;

import java.io.File;

public class Test {
    public static void main(String[] args){
        String path = "D:\\学习资料\\三个月入门深度学习课件-胡晓曼.pdf";
        File f = new File(path);

        System.out.println(f.getAbsolutePath());
        printTree(new File("D:\\BaiduNetdiskDownload"),0);
    }

    static void printTree(File f, int level){
        for(int i=0;i<level;i++){
            System.out.print("-");
        }
        System.out.println(f.getName());

        if(f.isDirectory()){
            File[] fs = f.listFiles();
            for(File file : fs)
                printTree(file,level+1);
        }
    }
}
