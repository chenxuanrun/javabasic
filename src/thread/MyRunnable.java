package thread;

/**
 * @program: javabasic
 * @description: 通过实现Runnable重写run()方法创建线程
 * @author: cxr
 * @create: 2019-09-25 20:48
 **/
public class MyRunnable implements Runnable{
    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
       for (int i=0;i<10;i++){
           System.out.println("Thread start : "+this.name+" ,i= "+i);
       }
    }
}
