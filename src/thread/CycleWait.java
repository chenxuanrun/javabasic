package thread;

/**
 * @program: javabasic
 * @description: 处理线程返回值(主线程等待法,join()方法阻塞当前线程以等待子线程处理完毕)
 * @author: cxr
 * @create: 2019-09-25 20:53
 **/
public class CycleWait implements Runnable{
    private String value;

    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = "we have data now";
    }

    public static void main(String[] args) throws InterruptedException {
        CycleWait cw=new CycleWait();
        Thread t = new Thread(cw);
        t.start();
        //主线程等待法
//        while (cw.value==null){
//            Thread.currentThread().sleep(100);
//        }
        //join()方法,缺点:控制不够精细
        t.join();
        System.out.println("value : "+cw.value);
    }
}
