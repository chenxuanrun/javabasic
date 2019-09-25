package thread;

/**
 * @program: javabasic
 * @description: 1. start()和run()方法区别演示,调用start()方法会创建一个新的线程并执行线程的run()方法,直接调用run()方法则只是Thread的一个普通方法的调用
 *               2.线程处于结束状态无法再次启动   
 * @author: cxr
 * @create: 2019-09-25 20:32
 **/
public class ThreadTest {
    private static void attack(){
        System.out.println("Fight");
        System.out.println("Current Thread: "+Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
           @Override
           public void run(){
               attack();
           } 
        };
        System.out.println("------------------------------------------------");
        System.out.println("1. start()和run()方法区别演示,调用start()方法会创建一个新的线程并执行线程的run()方法,直接调用run()方法则只是Thread的一个普通方法的调用");
        System.out.println("Current main thread is: "+Thread.currentThread().getName());
        t.start();
        t.run();
        System.out.println("------------------------------------------------");
        System.out.println("------------------------------------------------");
        System.out.println("2. 线程处于结束状态无法再次启动");
        t.join();
        t.start();
        System.out.println("------------------------------------------------");
    }
    
}
