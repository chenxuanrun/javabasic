package thread;

/**
 * @program: javabasic
 * @description: 普通Thread类(通过继承Thread创建线程)
 * @author: cxr
 * @create: 2019-09-25 20:43
 **/
public class MyThread extends Thread{
    private String name;
    public MyThread(String name) {
        this.name = name;
    }
    @Override
    public void run(){
        for (int i = 0;i<10;i++){
            System.out.println("Thread start: "+this.name+" ,i= "+i);
        }
    }
}
