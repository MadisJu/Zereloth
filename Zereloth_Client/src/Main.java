import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scam = new Scanner(System.in);
        System.out.println("Input the connection:");
        String a = scam.nextLine();
        DataOutputStream out = null;

        //Create a connection manager to handle all incoming connections.
        ConnectionManager cm = new ConnectionManager(4200);
        cm.start();

        Socket socket = null;

        try{
            socket = new Socket(a, 4200);

            DataInputStream input = new DataInputStream(System.in);
            out = new DataOutputStream(
                    socket.getOutputStream());
            String line = "";
            while(true)
            {
                Thread.sleep(1000);
                try {
                    line = input.readLine();
                    out.writeUTF(line);
                }
                catch (IOException i) {
                    System.out.println(i);
                }

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