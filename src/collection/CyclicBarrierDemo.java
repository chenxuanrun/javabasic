package collection;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @program: javabasic
 * @description: 栅栏:通过它可以完成多个线程之间相互等待，只有当每个线程都准备就绪后，才能各自继续往下执行后面的操作
 * @author: cxr
 * @create: 2019-10-01 15:20
 **/
public class CyclicBarrierDemo {
    public static void main(String[] args) throws InterruptedException {
        new CyclicBarrierDemo().go();
    }

    private void go() throws InterruptedException {
        //初始化栅栏的参与数为3
        CyclicBarrier cyclicBarrier=new CyclicBarrier(3);
        //依次创建3个线程,并启动
        new Thread(new Task(cyclicBarrier),"Thread1").start();
        Thread.sleep(1000);
        new Thread(new Task(cyclicBarrier),"Thread2").start();
        Thread.sleep(1000);
        new Thread(new Task(cyclicBarrier),"Thread3").start();
    }
    class Task implements Runnable{
        private CyclicBarrier cyclicBarrier;

        public Task(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程"+Thread.currentThread().getName()+"已经到达"+System.currentTimeMillis());
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("线程"+Thread.currentThread().getName()+"开始处理"+System.currentTimeMillis());
        }
    }
}
