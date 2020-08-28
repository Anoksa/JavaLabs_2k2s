package by.belstu.it.Karpushevich.basejava.SecondTask.Client;

public class Client {

    private static String ipAddr = "localhost";
    private static int port = 4004;

    public static void main(String[] args)
    {
        new ClientThread(ipAddr, port);
    }
}
