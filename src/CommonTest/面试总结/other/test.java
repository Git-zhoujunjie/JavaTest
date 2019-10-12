package CommonTest.面试总结;

public class test {
    public static void main(String[] args) {
        animal a = new dog();
        System.out.println(a.i);

    }

}

class animal{
    public int i=1;
    public animal(){
        System.out.println("animal");
    }
}
class dog extends animal{
    public int i=2;
    public dog(){
        System.out.println("dog");
    }
}