package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: javabasic
 * @description: CAS实例(atomic包下子类)
 * @author: cxr
 * @create: 2019-09-27 20:54
 **/
public class CASCase {
    public AtomicInteger value;
    public void add(){
        value.getAndIncrement();
    }
}
