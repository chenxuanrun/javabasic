package thread;

/**
 * @program: javabasic
 * @description:  1.wait()和sleep()方法区别:wait()和sleep()都会让出CPU资源但wait()会释放锁资源而sleep()不会,wait()必须在synchronize中使用,sleep()则可以在任何地方使用
 *                2.notify()和notifyAll()区别:notify()会唤醒该对象的等待池中的随机一个线程,notifyAll()会唤醒该对象的等待池中的所有线程  
 * @author: cxr
 * @create: 2019-09-25 21:16
 **/
public class WaitSleepDemo {
    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread A is waiting to get lock");
                synchronized (lock){
                    try {
                        System.out.println("thread A get lock");
                        Thread.sleep(20);
                        System.out.println("thread A do wait method");
                        lock.wait();
                        System.out.println("thread A is done");
                    }catch (InterruptedException e){
                      e.printStackTrace();  
                    }
                }
            }
        }).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread B is waiting to get lock");
                synchronized (lock){
                    try {
                        System.out.println("thread B get lock");
                        System.out.println("thread B is sleeping 10 ms");
                        Thread.sleep(10);
                        System.out.println("thread B is done");
                        //唤醒该对象等待池中所有线程
                        lock.notifyAll();
                        //唤醒该对象等待池中随机一个线程
//                        lock.notify();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
