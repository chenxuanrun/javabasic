package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @program: javabasic
 * @description: 交换器:就是一个线程在完成一定的事务后想与另一个线程交换数据，则第一个先拿出数据的线程会一直等待第二个线程，直到第二个线程拿着数据到来时才能彼此交换对应数据
 * @author: cxr
 * @create: 2019-10-01 16:55
 **/
public class ExchangerDemo {
    private static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        //代表男生和女生
        ExecutorService service= Executors.newFixedThreadPool(2);
        
        service.execute(()->{
          //男生对女生说的话
            try {
                String girl = exchanger.exchange("我其实暗恋你很久了");
                System.out.println("女生说: "+girl);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.execute(()->{
            try {
                System.out.println("女生慢慢的从教室里走出来......");
                TimeUnit.SECONDS.sleep(3);
                //男生对女生说的话
                String boy = exchanger.exchange("我很喜欢你......");
                System.out.println("男生说: "+boy);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.shutdown();
    }
}
