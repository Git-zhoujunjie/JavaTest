package ThinkingInJava.The16chapter.test18;

import java.util.Arrays;

class BerylliumSphere {
    private static long count ;
    private final long id = count++;
    public String toString() { return "Sphere: " + id ;}
}

public class copyArr {
    public static void main(String[] args){
        BerylliumSphere[] spheres = new BerylliumSphere[5];
        BerylliumSphere[] spheres1 = new BerylliumSphere[6];
        for(int i = 0;i<spheres.length;i++)
            spheres[i] = new BerylliumSphere();
        System.arraycopy(spheres,0,spheres1,0,spheres.length);
        System.out.println(Arrays.toString(spheres));
        System.out.println(Arrays.toString(spheres1));
        System.out.println(spheres[0] == spheres1[0]);
        System.out.println(spheres[0].equals(spheres1[0]));

        spheres[0] = new BerylliumSphere();
        System.out.println(Arrays.toString(spheres));
        System.out.println(Arrays.toString(spheres1));
        System.out.println(spheres[0] == spheres1[0]);
        System.out.println(spheres[0].equals(spheres1[0]));

    }
}
