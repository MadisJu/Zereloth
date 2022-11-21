import java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Socket socket = null;

        try{
            socket = new Socket("localhost", 4200);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("HELLO SERVER!");
        } catch (UnknownHostException u)
        {
            System.out.println(u);
        } catch (IOException i)
        {
            System.out.println(i);
        }
    }
}