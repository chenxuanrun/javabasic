package collection;

import java.util.concurrent.CountDownLatch;

/**
 * @program: javabasic
 * @description: 同步计数器:让主线程等待一组事件发生后继续执行
 * @author: cxr
 * @create: 2019-10-01 14:45
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        new CountDownLatchDemo().go();
    }

    private void go() throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(3);
        //依次创建3个线程,并启动
        new Thread(new Task(countDownLatch),"Thread1").start();
        Thread.sleep(1000);
        new Thread(new Task(countDownLatch),"Thread2").start();
        Thread.sleep(1000);
        new Thread(new Task(countDownLatch),"Thread3").start();
        countDownLatch.await();
        System.out.println("所有线程已到达,主线程开始执行"+System.currentTimeMillis());
    }
    class Task implements Runnable{
        private CountDownLatch countDownLatch;

        public Task(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
                System.out.println("线程"+Thread.currentThread().getName()+"已经到达"+System.currentTimeMillis());
                countDownLatch.countDown();
        }
    }
}
