package by.belstu.it.Karpushevich.basejava.SecondTask.Client;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ClientThread {

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private BufferedReader inputUser;
    private String addr;
    private int port;
    private String name;
    public String images[] = new String[]{"https://avatars.mds.yandex.net/get-pdb/2864099/4dc41869-84ea-418e-b454-a93ca30fe8b4/s1200?webp=false","https://avatars.mds.yandex.net/get-pdb/2343194/7c509b34-afec-4b95-9f52-cba8e31a4e71/s1200?webp=false"};

    public ClientThread(String addr, int port) {
        this.addr = addr;
        this.port = port;

        try {
            this.socket = new Socket(addr, port);
        } catch (IOException e) {
            System.err.println("Socket failed");
        }

        try {
            inputUser = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.pressName();
            new ReadMessage().start();
            new WriteMessage().start();
        } catch (IOException e) {
            ClientThread.this.downService();
        }
    }

    private void pressName() {
        System.out.print("Введите имя: ");
        try {
            name = inputUser.readLine();
            out.write("Приветствуем " + name + "!\n");
            out.flush();
        } catch (IOException ignored) { }
    }


    public void getImage() throws IOException {
        System.out.print("Введите число 1-2: ");
        int i = Integer.parseInt(inputUser.readLine());
        switch (i)
        {
            case 1:
                System.out.println(images[0]);
                break;
            case 2:
                System.out.println(images[1]);
                break;
        }
    }

    private void downService() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
            }
        } catch (IOException ignored) {}
    }

    private class ReadMessage extends Thread {
        @Override
        public void run() {
            String str;
            try {
                while (true) {
                    str = in.readLine();
                    if (str.equals("end")) {
                        ClientThread.this.downService();
                        break;
                    }
                    if(str.equals("i")){
                        ClientThread.this.getImage();
                        break;
                    }
                    System.out.println(str);
                }
            } catch (IOException e) {
                ClientThread.this.downService();
            }
        }
    }

    public class WriteMessage extends Thread {
        @Override
        public void run() {
            while (true) {
                String userWord;
                try {
                    userWord = inputUser.readLine();
                    if (userWord.equals("end")) {
                        out.write("end" + "\n");
                        ClientThread.this.downService();
                        break;
                    } else if (userWord.equals("i")) {
                        ClientThread.this.getImage();
                    } else {
                        out.write(name + ": " + userWord + "\n");
                    }
                    out.flush();
                } catch (IOException e) {
                    ClientThread.this.downService();
                }

            }
        }
    }
}
