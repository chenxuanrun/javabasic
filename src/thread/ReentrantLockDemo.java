package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: javabasic
 * @description: ReentrantLock实例
 * @author: cxr
 * @create: 2019-09-27 20:41
 **/
public class ReentrantLockDemo implements Runnable{
    private static ReentrantLock lock=new ReentrantLock(true);

    @Override
    public void run() {
        while (true){
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+" get lock");
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo rtld = new ReentrantLockDemo();
        Thread thread1 = new Thread(rtld);
        Thread thread2 = new Thread(rtld);
    }
}
