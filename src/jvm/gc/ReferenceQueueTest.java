package jvm.gc;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * @program: javabasic
 * @description: 引用队列示例
 * @author: cxr
 * @create: 2019-09-24 20:57
 **/
public class ReferenceQueueTest {
    private static ReferenceQueue<NormalObject> rq = new ReferenceQueue<NormalObject>();
    
    private static void checkQueue(){
       Reference<NormalObject> ref = null;
       while ((ref=( Reference<NormalObject>)rq.poll())!=null){
           if (ref!=null){
               System.out.println("In queue: "+ ref);
               System.out.println("reference object: "+ref.get());
           }
       }
    }

    public static void main(String[] args) {
        ArrayList<WeakReference> weakList= new ArrayList<WeakReference>();
        for (int i =0;i<3;i++){
            weakList.add(new NormalObjectWeakReference(new NormalObject("Weak "+i),rq)) ;
            System.out.println("Creat weak: "+weakList.get(i));
        }
        System.out.println("first time");
        checkQueue();
        System.gc();
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("second time");
        checkQueue();
    }
}
