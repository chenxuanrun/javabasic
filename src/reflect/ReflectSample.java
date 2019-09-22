package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @program: javabasic
 * @description: 反射例子
 * @author: cxr
 * @create: 2019-09-22 15:58
 **/
public class ReflectSample {
    public static void main(String[] args) throws Exception {
        Class robotClass=Class.forName("reflect.Robot");
        Object robot=robotClass.newInstance();
        System.out.println("Class name is" + robotClass.getName());
        //getDeclaredMethod可以获取私有方法,但不能获取继承和实现的方法
        Method throwHello=robotClass.getDeclaredMethod("throwHello",String.class);
        throwHello.setAccessible(true);
        Object str=throwHello.invoke(robot,"throwHello");
        System.out.println(str);   
        //getMethod不可以获取私有方法,但可以获取继承和实现的方法
        Method sayHi=robotClass.getMethod("sayHi",String.class);
        sayHi.invoke(robot,"sayHi");
        Field name=robotClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(robot,"name");
        System.out.println(name.get(robot));
    }
}
