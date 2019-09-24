package jvm.gc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @program: javabasic
 * @description: 引用队列示例所使用的引用对象
 * @author: cxr
 * @create: 2019-09-24 20:54
 **/
public class NormalObjectWeakReference extends WeakReference {
    public String name;                    

    public NormalObjectWeakReference(NormalObject normalObject, ReferenceQueue rq) {
        super(normalObject, rq);
        this.name = normalObject.name;
    }

    @Override
    protected void finalize(){
        System.out.println("Finalizing NormalObjectWeakReference: " +name);
    }
}
