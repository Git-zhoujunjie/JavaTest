package ThinkingInJava.The15chapter;

class GenericBase<T> {
    private T ele;
    public void set(T arg) { ele = arg; }
    public T get() { return ele; }
}

class Derived1<T> extends GenericBase{ }
class Derived2 extends GenericBase{}

public class ReasureAndInheritance {
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        Derived2 d2 = new Derived2();
        Object obj = d2.get();
        d2.set(obj);
    }
}
