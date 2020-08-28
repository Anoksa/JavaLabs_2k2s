package Chat.Client;

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

