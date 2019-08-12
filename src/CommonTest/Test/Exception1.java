package CommonTest.Test;

public class Exception1 {
    static int i = 0;
    int b = 0;
    public static void main(String[] args) {
        testException();
        System.out.println(i);
    }

    public static int testException() {

        try {
            i++;
            throw new Exception("error");
        } catch (Exception e) {
            return i++;
        } finally {
            i++;
        }


    }
    abstract class  A{
        int a = i;
        int c = b;
    }
}
