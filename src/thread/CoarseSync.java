package thread;

/**
 * @program: javabasic
 * @description: 锁粗化实例
 * @author: cxr
 * @create: 2019-09-26 21:33
 **/
public class CoarseSync {
    public static String copyString100Times(String target){
        int i=0;
        StringBuffer sb =new StringBuffer();
        while (i<100){
            sb.append(target);
        }
        return sb.toString();
    }
}
