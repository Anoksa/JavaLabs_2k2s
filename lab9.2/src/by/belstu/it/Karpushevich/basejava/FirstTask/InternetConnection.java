package by.belstu.it.Karpushevich.basejava.FirstTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class InternetConnection {

    InetAddress currentIP = null;

    public  void getLocalHost() {
        try{
            currentIP = InetAddress.getLocalHost();
            System.out.println("IP -> " + currentIP.getHostAddress());
        } catch (UnknownHostException ex){
            System.out.println(ex.getMessage());
        }
    }

    public  void getByName(String web) {
        try {
            currentIP = InetAddress.getByName(web);
            System.out.println(currentIP.getHostAddress());
        } catch (UnknownHostException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void getByAdress(String name, byte[] ip) {
        try {
            currentIP = InetAddress.getByAddress(name, ip);
            System.out.println(currentIP.isReachable(100));
        }
        catch (UnknownHostException ex){
            System.out.println(ex.getMessage());
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public  void ReadHTML(String URL) {
        java.net.URL url = null;
        try {
            url = new URL(URL);
            if(url == null){
                throw new RuntimeException();
            }
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        }

        try (BufferedReader d= new BufferedReader(new InputStreamReader((url.openStream())))) {
            String line ="";
            while((line = d.readLine())!=null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void getInfo(String UrlName) {
        int timeout= 10_000;
        URL url;
        try{
            url = new URL(UrlName);
            final URLConnection connection = url.openConnection();
            connection.setConnectTimeout(timeout);

            System.out.println(UrlName + " content type: \n"
                    +connection.getContentType()+"\n"+
                    connection.getClass()+"\n"+
                    connection.getContentLength());
        }
        catch (MalformedURLException ex){
            ex.printStackTrace();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
