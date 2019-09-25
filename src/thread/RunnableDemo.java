package thread;

/**
 * @program: javabasic
 * @description: 创建线程方法演示
 * @author: cxr
 * @create: 2019-09-25 20:50
 **/
public class RunnableDemo {
    public static void main(String[] args) {
        MyRunnable mr1 = new MyRunnable("Runnable1");
        MyRunnable mr2 = new MyRunnable("Runnable2");
        MyRunnable mr3 = new MyRunnable("Runnable3");
        Thread t1 = new Thread(mr1);
        Thread t2 = new Thread(mr2);
        Thread t3 = new Thread(mr3);
        t1.start();
        t2.start();
        t3.start();
    }
}
