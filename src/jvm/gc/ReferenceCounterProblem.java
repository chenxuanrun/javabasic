package jvm.gc;

/**
 * @program: javabasic
 * @description: 引用计数法缺陷演示
 * @author: cxr
 * @create: 2019-09-24 20:45
 **/
public class ReferenceCounterProblem {
    public static void main(String[] args) {
        MyObject myObject1 = new MyObject();
        MyObject myObject2 = new MyObject();
        
        myObject1.childNode=myObject2;
        myObject2.childNode=myObject1;
    }

}
