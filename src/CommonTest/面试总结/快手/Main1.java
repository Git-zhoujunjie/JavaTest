package CommonTest.面试总结.快手;

import java.util.Scanner;

/**
 * @author Zhoujunjie
 * @create 2019/9/16 21:08
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String ip = in.nextLine();
            String res = isValidIP(ip);
            System.out.println(res);
        }
    }

    static String isValidIP(String ip){
        String[] iparr;
        if(ip.contains(".")){
            iparr = ip.split("\\.");
            if(iparr.length!=4 || ip.charAt(ip.length()-1)=='.')
                return "Neither";
            for(String s:iparr){
                if(s.length()<1||s.length()>3) return "Neither";
                else if(s.charAt(0)=='0'&&s.length()>1) return "Neither";
                for(int i=0;i<s.length();i++){
                    if(s.charAt(i)<'0'&&s.charAt(i)>'9') return "Neither";
                }
                if(Integer.parseInt(s)>255) return "Neither";
            }
            return "IPv4";
        }else{
            iparr = ip.split(":");
            if(iparr.length!=8||ip.charAt(ip.length()-1)==':') return "Neither";
            for(String s:iparr){
                if(s.length()<1||s.length()>4) return "Neither";
                for(int i=0;i<s.length();i++){
                    if(s.charAt(i)<'0'||s.charAt(i)>'f') return "Neither";
                    else if(s.charAt(i)>'9'&&s.charAt(i)<'A') return "Neither";
                    else if(s.charAt(i)>'F'&&s.charAt(i)<'a') return "Neither";
                }
            }
            return "IPv6";
        }
    }
}
