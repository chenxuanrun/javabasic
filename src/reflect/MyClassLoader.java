package reflect;

import java.io.*;

/**
 * @program: javabasic
 * @description: 自定义类加载器, 类加载器主要有两个方法, findClass方法加载类,
 * defineClass方法:将获取到的.class文件字节码流转换为class对象
 * @author: cxr
 * @create: 2019-09-22 19:36
 **/
public class MyClassLoader extends ClassLoader {
    private String path;
    private String classLoaderName;

    public MyClassLoader(String path, String classLoaderName) {
        this.path = path;
        this.classLoaderName = classLoaderName;
    }

    //用于寻找类文件
    @Override
    public Class<?> findClass(String name) {
        byte[] bytes = loadClassData(name);
        return defineClass(bytes, 0, bytes.length);
    }

    //用于加载类文件
    private byte[] loadClassData(String name) {
        name = path + name + ".class";
        InputStream is = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
        is = new FileInputStream(new File(name));
        byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while ((i=is.read())!=-1){
            byteArrayOutputStream.write(i); 
        }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           if (byteArrayOutputStream!=null){
               try {
                   byteArrayOutputStream.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           if (is!=null){
               try {
                   is.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }
        return byteArrayOutputStream.toByteArray();
    }
}
