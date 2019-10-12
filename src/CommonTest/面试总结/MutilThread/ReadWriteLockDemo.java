package CommonTest.面试总结.MutilThread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁测试
 *
 * 各大缓存中的读写操作采用的读写锁
 *
 * 读写分离
 */

class MyCache{
    //禁止指令重排和保持可见性
    private volatile Map<String, Object> map = new HashMap<>();

    private ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key,Object val){
        //写锁 保证写操作的原子性和一致性
        rwLock.writeLock().lock();
        try{
            Thread t  = Thread.currentThread();
            System.out.println(t.getName()+"正在写入。。。");
            try { TimeUnit.MILLISECONDS.sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
            map.put(key,val);
            System.out.println(t.getName()+"写入完成！");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }
    }

    public void get(String key){
        //读锁
        rwLock.readLock().lock();
        try{
            Thread t  = Thread.currentThread();
            System.out.println(t.getName()+"正在读取。。。");
            try { TimeUnit.MILLISECONDS.sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
            Object obj = map.get(key);
            System.out.println(t.getName()+"读取完成！    "+obj);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.readLock().unlock();
        }
    }
}

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache cache = new MyCache();
        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                cache.put(String.valueOf(tempInt),tempInt);
            }, String.valueOf(i)).start();
        }

        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                cache.get(String.valueOf(tempInt));
            }, String.valueOf(i)).start();
        }
    }
}
