package thread;

/**
 * @program: javabasic
 * @description: yield()方法应用实例,yield会暗示调度器让出当前cpu使用权,可能成功可能不成功,yield不会释放锁资源
 * @author: cxr
 * @create: 2019-09-25 21:26
 **/
public class YieldDemo {
    public static void main(String[] args) {
        Runnable yieldTask=new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+i);
                    if (i==5){
                        Thread.yield();
                    }
                }
            }
        };
        Thread t1 = new Thread(yieldTask,"A");
        Thread t2 = new Thread(yieldTask,"B");
        t1.start();
        t2.start();
    }
    
}
