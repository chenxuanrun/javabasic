package jvm.model;

/**
 * @program: javabasic
 * @description: 内存溢出异常展示(可能会死机)
 * @author: cxr
 * @create: 2019-09-23 23:07
 **/
public class StackLeakByThread {
    public static void main(String[] args) {
        while (true){
            new Thread(){
                @Override
                public void run(){
                    while (true){
                        
                    }
                }
            }.start();;
        }
    }
}
