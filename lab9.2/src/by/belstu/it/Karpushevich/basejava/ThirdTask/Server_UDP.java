package by.belstu.it.Karpushevich.basejava.ThirdTask;

import java.io.IOException;
import java.net.*;
import java.util.*;

public class Server_UDP {
    public static void main(String[] args){
        try {
            DatagramSocket data = new DatagramSocket(4004);                    //подключаемся к порту
            InetAddress address = InetAddress.getByName("localhost");          //задаем адрес
            while(true) {
                byte[] buf = new byte[10000];
                //задаём максимальную длину принимаемого пакета
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                //как и в той программе создаем объект класса. тут только задаем во что записать
                //пакет и длину (чисто логические предположения :) )
                data.receive(packet);                                          //ждем пакет
                String result = new String(packet.getData());
                // передаём полученный пакет в строку для его последующего вывода в консоль
                System.out.println(packet.getLength()+" "+result);
//выводим в консоль длину полученного сообщения в пакете (не всего пакета!) и собственно само сообщение
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
