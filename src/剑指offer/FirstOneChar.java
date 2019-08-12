package 剑指offer;

import java.util.HashMap;
import java.util.Map;

public class FirstOneChar {

    public static void main(String[] args) {
        FirstOneChar test = new FirstOneChar();
        System.out.println(test.FirstNotRepeatingChar("google"));
    }
    public int FirstNotRepeatingChar(String str) {
        if(str.length()<=0) return -1;
        char[] cs = str.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<cs.length;i++){
            if(map.get(cs[i])==null){
                map.put(cs[i],0);
            }else{
                map.put(cs[i],map.get(cs[i])+1);
            }
        }
        for(int i=0;i<cs.length;i++){
            if(map.get(cs[i])==0) return i;
        }

        return -1;
    }
}
