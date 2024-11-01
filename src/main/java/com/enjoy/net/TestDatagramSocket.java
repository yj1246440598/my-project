package com.enjoy.net;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class TestDatagramSocket {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(1001);
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            datagramSocket.receive(datagramPacket);
            String s = new String(datagramPacket.getData());
            System.out.println("收到客户端消息："+s);
            byte[] bytes = "欢迎".getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length,datagramPacket.getAddress(),datagramPacket.getPort());
            datagramSocket.send(packet);
            datagramSocket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   static class Client{
        public static void main(String[] args) throws IOException {
            DatagramSocket clientSocket = new DatagramSocket();

            // 向服务器发送数据
            byte[] sendBuffer = "Hello, Server!".getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, InetAddress.getLocalHost(), 1001);
            clientSocket.send(sendPacket);

            // 接收服务器发送的数据
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);
            String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("收到服务器消息：" + message);

            clientSocket.close();
        }
    }
}
