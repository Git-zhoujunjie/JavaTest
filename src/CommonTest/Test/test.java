package CommonTest.Test;

public class test {
    public static void main(String[] args) {
        String s="ABBAABBA";

        System.out.println(fun(s));

    }

    static String fun(String s){
        String result = s;

        int len = s.length();
        int mid = len/2;
        boolean flag = true;

        while(flag){
            String s1 = result.substring(0,mid);
            String s2 = result.substring(mid);
            String s3 = nizhuan(s2);
            if(s1.equals(s2) || s1.equals(s3)){
                result = result.substring(0,mid);
                mid = result.length()/2;
            }else{
                flag=false;
            }
        }

        return result.length()+"";
    }

    static String nizhuan(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
