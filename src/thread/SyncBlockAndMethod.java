package thread;

/**
 * @program: javabasic
 * @description: 配合演示monitor字节码层面实现
 * @author: cxr
 * @create: 2019-09-26 21:08
 **/
public class SyncBlockAndMethod {
    public void syncsTask(){
        //同步代码块
        synchronized (this){
            System.out.println("Hello");
            //锁重入
            synchronized (this){
                System.out.println("World");
            }
        }
        
    }
    public synchronized void syncTask(){
        System.out.println("Hello again");
    }
}
