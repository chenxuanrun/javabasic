package jvm.model;

import java.util.Random;

/**
 * @program: javabasic
 * @description: 永久代内存溢出例子 JDK1.7字符串常量池放到了堆中 JDK1.8用元空间(本机内存)替代了永久代(JVM内存)
 * @author: cxr
 * @create: 2019-09-23 22:03
 **/
public class PermGenErrTest {
    public static void main(String[] args) {
        for (int i = 0; i <=1000 ; i++){
            //将返回的随机字符串添加到字符串常量池中
            getRandomString(1000000).intern();
        }
        System.out.println("Mission Complet!");
    }

    private static String getRandomString(int length) {
        //字符串源
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0 ; i < length ; i++){
            int num = random.nextInt(62);
            sb.append(str.charAt(num));
        }
        return sb.toString();
    }

}
