import java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Socket socket = null;

        try{
            socket = new Socket("localhost", 4200);
            while(true)
            {
                Thread.sleep(1000);
            }
        } catch (UnknownHostException u)
        {
            System.out.println(u);
        } catch (IOException | InterruptedException i)
        {
            System.out.println(i);
        }
    }
}