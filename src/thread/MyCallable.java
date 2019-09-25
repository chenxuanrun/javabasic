package thread;

import java.util.concurrent.Callable;

/**
 * @program: javabasic
 * @description: Callable应用实例
 * @author: cxr
 * @create: 2019-09-25 20:59
 **/
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        String value = "test";
        System.out.println("Ready to work");
        Thread.currentThread().sleep(5000);
        System.out.println("task done");
        return value;
    }
}
