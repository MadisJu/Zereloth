import java.net.Socket;

public class ClientManager implements Runnable{


    private Socket connection_socket;
    public Thread thread;
    private int ID;

    public ClientManager(Socket client_socket, int ID)
    {
        this.connection_socket = client_socket;
        this.ID = ID;
    }
    @Override
    public void run()
    {
        while(this.connection_socket.isConnected()) {
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
