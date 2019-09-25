package thread;

import thread.MyCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: javabasic
 * @description: FutureTask结合Callable实例应用
 * @author: cxr
 * @create: 2019-09-25 21:02
 **/
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<String>(new MyCallable());
        new Thread(task).start();
        if (!task.isDone()){
            System.out.println("task has not finished, please wait!");
        }
        System.out.println("task return : "+task.get());
    }
}
