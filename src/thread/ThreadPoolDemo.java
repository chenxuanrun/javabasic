package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @program: javabasic
 * @description: ThreadPool结合Callable实例应用
 * @author: cxr
 * @create: 2019-09-25 21:06
 **/
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService newCachedThreadPool= Executors.newCachedThreadPool();
        Future future=newCachedThreadPool.submit(new MyCallable());
        if (!future.isDone()){
            System.out.println("task has not finished, please wait!");
        }
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            newCachedThreadPool.shutdown();  
        }
    }
}
