package by.belstu.it.Karpushevich.basejava.ThirdTask;

import java.net.*;
import java.util.*;
import java.io.IOException;

public class Client_UDP {
    public static void main (String[] args) throws InterruptedException {
        host = "localhost";
        port = 4004;
        try {
            InetAddress address = InetAddress.getByName(host); //получаем адрес для передачи информации
            DatagramSocket socket = new DatagramSocket();      //создаём сокет
            while(true)
            {
                int i = (int) (1000*Math.random());            //создаем случайное число для длины пакета
                byte [] buf = new byte[i];                     //передаем i, и определяем массив с данными
                System.out.println(buf.length);                //посмотрим между делом длину полученного массива
                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
                //создадим объект класса DatagramPacket и передадим ему массив, длину массива, адрес куда слать и порт
                socket.send(packet);                           //отправляем созданный UDP пакет
            }
        }
        catch (IOException e) {
            e.printStackTrace();                          //отлавливаем необходимые исключения
        }
    }
    private static String host;
    private static int port;
}
