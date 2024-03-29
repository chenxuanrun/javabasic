package thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: javabasic
 * @description: synchronize(对象锁)
 * @author: cxr
 * @create: 2019-09-26 16:41
 **/
public class SyncThread implements Runnable{
    @Override
    public void run() {
        String threadName=Thread.currentThread().getName();
        if (threadName.startsWith("A")){
           async(); 
        }else if (threadName.startsWith("B")){
           syncObjectBlock1(); 
        }else if (threadName.startsWith("C")){
           syncObjectMethod1(); 
        }else if (threadName.startsWith("D")){
           syncClassBlock1(); 
        }else if (threadName.startsWith("E")){
           syncClassMethod1(); 
        }
    }
    
    /**
     * synchronized 修饰非静态方法
     */
    private synchronized void syncObjectMethod1() {
        System.out.println(Thread.currentThread().getName()+"_SyncObjectMethod1: "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
        try {
            System.out.println(Thread.currentThread().getName()+"_SyncObjectMethod1_Start: "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"_SyncObjectBlock1_Ebd: "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 方法中有synchronized(this|object) {}同步代码块
     */
    private void syncObjectBlock1() {
        System.out.println(Thread.currentThread().getName()+"_SynObjectBlock1: "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
        synchronized (this){
            try {
                System.out.println(Thread.currentThread().getName()+"_SyncObjectBlock1_Start: "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"_SyncObjectBlock1_End: "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 异步方法
     */
    private void async() {
        try {
            System.out.println(Thread.currentThread().getName()+"_SyncObjectBlock1_Start: "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"_SyncObjectBlock1_End: "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * synchronized 修饰静态方法
     */
    private synchronized static void syncClassMethod1() {
        System.out.println(Thread.currentThread().getName()+"_SyncClassMethod1: "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
        try {
            System.out.println(Thread.currentThread().getName()+"_SyncClassMethod1_Start: "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            Thread.sleep(10000);
            System.out.println(Thread.currentThread().getName()+"_SyncClassMethod1_End: "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * synchronized 修饰代码块(类锁)
     */
    private void syncClassBlock1() {
        System.out.println(Thread.currentThread().getName()+"_SyncClassBlock1: "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
        try {
            System.out.println(Thread.currentThread().getName()+"_SyncClassBlock1_Start: "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"_SyncClassBlock1_End: "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    } 
}
