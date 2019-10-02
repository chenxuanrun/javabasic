package io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: javabasic
 * @description: BIO实例
 * @author: cxr
 * @create: 2019-10-02 17:51
 **/
public class BIOPlainEchoServer {   
    public void serve(int port) throws IOException {
        //将ServerSocket绑定到指定的端口里
        final ServerSocket socket=new ServerSocket(port);  
        while (true){
            //阻塞直到收到新的客户端连接
            final Socket clientSocket = socket.accept();
            System.out.println("Accept connection from "+clientSocket);
            //创建一个子线程去处理客户端的请求
            new Thread(()->{
                //try(),可以自动关闭()实现了closeable的接口的资源,用于申请资源
                try(BufferedReader reader=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(),true);
                    //从客户端读取数据并原封不动写回去
                    while (true){
                        writer.println(reader.readLine());
                        writer.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
    public void improvedServe(int port) throws IOException {
        //将ServerSocket绑定到指定的端口里
        final ServerSocket socket=new ServerSocket(port);
        //创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        while (true){
            //阻塞直到收到新的客户端的链接
            final Socket clientSocket=socket.accept();
            System.out.println("Accept connection from "+clientSocket);
            //将请求交给线程池去执行
            executorService.submit(()->{
                 try(BufferedReader reader=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(),true);
                    //将从客户端读取的数据原封不动写回去
                     while (true){
                          writer.println(reader.readLine());
                          writer.flush();
                     }
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
            });
        }
        
    }
}
