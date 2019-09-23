package reflect;

/**
 * @program: javabasic
 * @description: 类加载demo
 * @author: cxr
 * @create: 2019-09-22 20:27
 **/
public class ClassLoaderCheck {
    public static void main(String[] args) throws Exception {
      MyClassLoader myClassLoader=new MyClassLoader("C:\\Users\\81513\\Desktop\\","myClassLoader");
      Class robot=myClassLoader.loadClass("Robot");
      System.out.println(robot.getClassLoader());
      robot.newInstance();
    }
}
