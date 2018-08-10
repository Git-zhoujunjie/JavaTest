package ThinkingInJava.The16chapter.test2;

import java.util.Arrays;

class BerylliumSphere {
    private static long count ;
    private final long id = count++;
    public String toString() { return "Sphere: " + id ;}
}

public class ReturnArray {
    static BerylliumSphere[] spheres(int n) {
        BerylliumSphere[] results = new BerylliumSphere[n];
        for(int i = 0;i<3;i++)
            results[i] = new BerylliumSphere();
        return results;
    }

    public static void main(String[] args){
        BerylliumSphere[] spheresArray = spheres(5);
        System.out.println(Arrays.toString(spheresArray));
    }
}
