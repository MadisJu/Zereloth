import java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Server!");
        Socket socket = null;
        ServerSocket server = null;

        try{
            server = new ServerSocket(4200);
            socket = server.accept();
            DataInputStream in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));
            String s = "";

            while(!s.equals("HELLO SERVER!"))
            {
                try{
                    s = in.readUTF();
                    System.out.println(s);
                }
                catch (IOException i )
                {
                    System.out.println(i);
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}