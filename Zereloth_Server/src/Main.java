import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Main {

    public static ArrayList<ClientManager> clients_sockets; //Global socket list
    public static void main(String[] args) throws IOException, InterruptedException {

        clients_sockets = new ArrayList<>();



        ConnectionManager CM = new ConnectionManager(4200);
        Thread CM_R = new Thread(CM);
        CM_R.start();

        while(true)
        {
            Thread.sleep(1000);
            clients_sockets = CM.clients;
            System.out.println(clients_sockets.size());
        }

    }
}