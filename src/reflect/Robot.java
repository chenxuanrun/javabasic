package reflect;

/**
 * @program: javabasic
 * @description: 用于表现反射的类
 * @author: cxr
 * @create: 2019-09-22 15:55
 **/
public class Robot {
    private String name;
    public void sayHi(String helloSentence){
        System.out.println(helloSentence);
    }
    private String throwHello(String tag){
        return "Hello " + tag;
    }
}
