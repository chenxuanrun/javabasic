package jvm.gc;

/**
 * @program: javabasic
 * @description: 引用队列示例用到的对象
 * @author: cxr
 * @create: 2019-09-24 20:52
 **/
public class NormalObject {
    public String name;
    public  NormalObject(String name){
        this.name = name;
    }
    @Override
    protected void finalize(){
        System.out.println("Finalizing obj " + name);
    }
}
