package jvm.gc;

/**
 * @program: javabasic
 * @description: finalize方法具体调用实例
 * @author: cxr
 * @create: 2019-09-24 20:37
 **/
public class Finalization {
    public static Finalization f;
    @Override
    protected  void finalize(){
        System.out.println("Finalized");
        f=this;
    }

    public static void main(String[] args) {
        Finalization finalization=new Finalization();
        System.out.println("First print: "+finalization);
        finalization = null;
        System.gc();
        try {
             Thread.currentThread().sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Second print: "+finalization);
        System.out.println(finalization.f);
    }
}
