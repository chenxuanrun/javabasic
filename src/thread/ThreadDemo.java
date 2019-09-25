package thread;

/**
 * @program: javabasic
 * @description: 创建线程方法演示
 * @author: cxr
 * @create: 2019-09-25 20:46
 **/
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread mt1 = new MyThread("Thread1");
        MyThread mt2 = new MyThread("Thread2");
        MyThread mt3= new MyThread("Thread3");
        mt1.start();
        mt2.start();
        mt3.start();
    }
}
