package jvm.model;

/**
 * @program: javabasic
 * @description: 用于对比 jdk1.6以及jdk1.6之后intern方法调用处理的区别,
 * intern如果常量池中有字符串则直接返回引用,否则会执行如下操作:
 * jdk1.6调用intern只是将堆中的字符串拷贝到字符串常量池中原先的引用没有发生变化
 * jdk1.6之后调用intern在将堆中的字符串拷贝到常量池中的同时,也会改变原先的应用指向常量池中的字符串
 * StringBuffer.toString()没有将字符串放入常量池当中
 * @author: cxr
 * @create: 2019-09-23 21:58
 **/
public class InternDifference {
    public static void main(String[] args) {
        String s = new String("a");
        s.intern();
        String s2 = "a";
        System.out.println(s == s2);
        
        String s3 = new String("a") + new String("a");
        s3.intern();
        String s4 = "aa";
        System.out.println(s3 == s4);
        
        StringBuffer sb = new StringBuffer("word");
//        sb.append("he").append("llo");
        String str = sb.toString();
        System.out.println("word" == str);
    }
}
