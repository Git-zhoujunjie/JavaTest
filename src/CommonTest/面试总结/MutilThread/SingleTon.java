package CommonTest.面试总结;

/**
 * 懒汉式单例模式
 */
public class SingleTon {

    //加上volatile禁止指令重排
    private static volatile SingleTon instance = null;
    
    private SingleTon(){
        System.out.println(Thread.currentThread().getName()+"-------newInstance");
    }
    
    public static SingleTon getInstance(){
        //DCL doubleCheckingLocking模式
            //但存在指令重排的问题，不一定100%线程安全，可能一千万次会出现一次错，
        if(instance == null){
            synchronized (SingleTon.class) {
                if(instance == null)
                    instance = new SingleTon();
            }
        }
        
        return instance;
    }
    
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                SingleTon.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
