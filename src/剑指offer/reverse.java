package 剑指offer;

public class reverse {
    public static String ReverseSentence(String str) {
        //三次反转
        if(str.length()<=0) return "";
        StringBuilder sb = new StringBuilder("");
        int begin=0;
        int end=begin+1;
        while(end<str.length()){
            while(end<str.length() && str.charAt(end)!=' ') end++;
            sb.append(rev(str.substring(begin,end)));
            begin = end;
            while(end<str.length() && str.charAt(end)==' ') end++;
            sb.append(str.substring(begin,end));
            begin = end;
        }
        return rev(sb.toString());
    }

    public static String rev(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "student. a am I";
        System.out.println(ReverseSentence(s));
    }
}
