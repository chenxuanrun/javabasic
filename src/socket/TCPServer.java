package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: javabasic
 * @description: TCP服务端
 * @author: cxr
 * @create: 2019-09-16 16:43
 **/
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(65000);
        while (true){
            Socket socket= serverSocket.accept();
            new Thread(new  TCPLengthCalculator(socket)).start();
        }
    }
}
