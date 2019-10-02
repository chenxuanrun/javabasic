package collection;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @program: javabasic
 * @description: 信号量:如果限定某些资源最多有N个线程可以访问，那么超过N个主不允许再有线程来访问，同时当现有线程结束后，就会释放，然后允许新的线程进来
 * @author: cxr
 * @create: 2019-10-01 15:45
 **/
public class SemaphoreDemo {
    public static void main(String[] args) {
        //线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        //只能5个线程同时访问
        final Semaphore semp=new Semaphore(5);
        //模拟20个客户端访问
        for (int index = 0;index<20;index++){
            final int NO =index;
            Runnable run=new Runnable() {
                @Override
                public void run() {
                    //获取许可
                    try {
                        semp.acquire();
                        System.out.println("Accessing: "+NO);
                        Thread.sleep((long) (Math.random()*10000));
                        //访问完后,释放
                        semp.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(run);
        }
        //退出线程池
        exec.shutdown();
    }
}
