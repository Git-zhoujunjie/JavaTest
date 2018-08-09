package ThinkingInJava.The15chapter;

class HasF {
    public void f() {
        System.out.println("Has.f()");
    }
}
class Manipulator<T extends HasF> {
    private T obj;
    public Manipulator(T x){
        obj = x;
    }
    public void manipulate(){ obj.f(); }
}
public class Manipulation {
    public static void main(String[] args){
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hf);
        manipulator.manipulate();
    }
}
