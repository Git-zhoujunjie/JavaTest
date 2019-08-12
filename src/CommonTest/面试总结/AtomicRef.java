package CommonTest.面试总结;


import java.util.concurrent.atomic.AtomicReference;

class User{
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
public class AtomicRef {
    public static void main(String[] args) {
        User u1 = new User("11",23);
        User u2 = new User("22",32);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(u1);

        System.out.println(atomicReference.compareAndSet(u1,u2)+"==="+atomicReference.get());

        System.out.println(atomicReference.compareAndSet(u1,u2)+"==="+atomicReference.get());

    }
}
