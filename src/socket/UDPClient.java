package socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @program: javabasic
 * @description: UDP客户端
 * @author: cxr
 * @create: 2019-09-16 20:30
 **/
public class UDPClient {
    public static void main(String[] args) throws Exception {
        String ip = "127.0.0.1";
        int port=65001;
        DatagramSocket datagramSocket=new DatagramSocket();
        String stringToServer="Hello World";
        byte[] dataToServer=stringToServer.getBytes();
        InetAddress inetAddress=InetAddress.getByName(ip);
        DatagramPacket datagramPacket=new DatagramPacket(dataToServer,dataToServer.length,inetAddress,port) ;
        datagramSocket.send(datagramPacket);
        byte[] buff=new byte[100];
        DatagramPacket reseivePacket=new DatagramPacket(buff,buff.length);
        datagramSocket.receive(reseivePacket);
        byte[] reseiveData=reseivePacket.getData();
        System.out.println(new String(reseiveData,"UTF-8").trim());
    }
}
