package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @program: javabasic
 * @description: TCP返回客户端字符串长度线程
 * @author: cxr
 * @create: 2019-09-16 17:33
 **/
public class TCPLengthCalculator implements Runnable{
     //客户端socket作为成员变量
     private Socket socket;

    public TCPLengthCalculator(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        OutputStream os=null;
        InputStream  is=null;
        try {
            os = socket.getOutputStream();//获取socket输出流
            is = socket.getInputStream(); //获取socket输入流
            byte[] bytes=new byte[1024];
            StringBuilder stringBuilder=new StringBuilder();
            while (is.read(bytes)>0){
                stringBuilder.append(new String(bytes,"UTF-8")); 
            }
            String receiveString= stringBuilder.toString().trim();
            System.out.println(receiveString);
            os.write(String.valueOf(receiveString.length()).getBytes());
            socket.shutdownOutput();
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
