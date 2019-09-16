package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @program: javabasic
 * @description: TCP客户端
 * @author: cxr
 * @create: 2019-09-16 16:43
 **/
public class TCPClient {
    public static void main(String[] args) throws IOException {
        String ip = "127.0.0.1";
        int port=65000;
        Socket socket=new Socket(ip,port);
        OutputStream os = socket.getOutputStream();
        InputStream is =socket.getInputStream();
        String information="你好";
        os.write(information.getBytes());
        socket.shutdownOutput();
        byte[] bytes=new byte[1024];
        StringBuilder stringBuilder=new StringBuilder();
        while (is.read(bytes)>0){
            stringBuilder.append(new String(bytes,"UTF-8"));
        }
        System.out.println(stringBuilder.toString());
        if (is!=null){
           is.close(); 
        }
        if (os!=null){
            os.close();
        }
        if (socket!=null){
            socket.close();
        }
    }
}
