import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientManager extends Thread{


    private Socket connection_socket;
    private int ID;

    public ClientManager(Socket client_socket, int ID)
    {
        this.connection_socket = client_socket;
        this.ID = ID;
        this.start();
    }
    @Override
    public void run()
    {
        System.out.println(this.connection_socket.isConnected());
        while(this.connection_socket.isConnected()) {
            System.out.println(this.threadId());
            try {
                Thread.sleep(1000);
                if (this.connection_socket.isConnected()) {
                    System.out.println("CLient connected with id of : " + this.ID);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Socket getConnection_socket()
    {
        return connection_socket;
    }
}
