package throwable;

/**
 * @program: javabasic
 * @description: 异常处理机构
 * @author: cxr
 * @create: 2019-09-28 17:09
 **/
public class ExceptionHandleMechanism {
    public static  void doWork(){
        try {
            int i = 10 / 0;//会抛出异常
            System.out.println("i= "+i);
        } catch (ArithmeticException e) {
            //捕获 Exception
            System.out.println("ArithmeticException: "+e);
        }finally {
            System.out.println("Finally");
        }
    }

    public static void main(String[] args) {
        doWork();
        System.out.println("Mission Complete");
    }
}
