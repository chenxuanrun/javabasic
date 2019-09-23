package jvm.model;

/**
 * @program: javabasic
 * @description: 用于编译和反编译试验 查看编译之后语句运行顺序 理解虚拟机栈结构
 * @author: cxr
 * @create: 2019-09-23 21:53
 **/
public class ByteCodeSample {
    public static int add(int a,int b){
        int c = 0;
        c = a + b;
        return c;
    }
}
