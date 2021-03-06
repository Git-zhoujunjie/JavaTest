package ThinkingInJava.The16chapter;

import java.util.Arrays;
import java.util.Random;

public class IceCream {
    private static Random random = new Random(47);
    static final String[] FLAVORS = {
            "Chocalate","Strawberry","Vanilla","Mini Chip",
            "Mocha Almod", "Rum Raisin","Praline Cream",
            "Mub Pie "
    };
    public static String[] flavorSet(int n){
        if(n >FLAVORS.length)
            throw new IllegalArgumentException("Set too big");
        String[] results = new String[n];
        boolean[] picked = new boolean[FLAVORS.length];
        for(int i = 0;i<n;i++){
            int t;
            do {
                t = random.nextInt(FLAVORS.length);
            }while (picked[t]);

            results[i] = FLAVORS[t];
            picked[t] = true;
        }
        return results;
    }
    public static void main(String[] args){
        for(int i= 0;i<7;i++)
            System.out.println(Arrays.toString(flavorSet(5)));
    }
}
