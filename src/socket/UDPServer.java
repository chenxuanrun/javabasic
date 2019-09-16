package socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @program: javabasic
 * @description: UDP服务端
 * @author: cxr
 * @create: 2019-09-16 20:30
 **/
public class UDPServer {
    public static void main(String[] args) throws Exception{
        DatagramSocket datagramSocket=new DatagramSocket(65001);
        byte[] buff=new byte[100];
        DatagramPacket datagramPacket=new DatagramPacket(buff,buff.length);
        datagramSocket.receive(datagramPacket);
        byte[] data=datagramPacket.getData();
        String reseiceString=new String(data,"UTF-8").trim();
        System.out.println(reseiceString);
        byte[] dataToClient=String.valueOf(reseiceString.length()).getBytes();
        DatagramPacket packetToClient=new DatagramPacket(dataToClient,dataToClient.length,datagramPacket.getAddress(),datagramPacket.getPort());
        datagramSocket.send(packetToClient);
    }
}
