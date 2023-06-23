import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ConnectionManager extends Thread {
    private ServerSocket ss;
    public ArrayList<ClientManager> clients;
    private boolean isRunning;
    private ThreadGroup ConnectionThreads;

    private int con = 0;

    public ConnectionManager(int port) throws IOException {
        this.clients = new ArrayList<>();
        this.ss = new ServerSocket(port);
        this.isRunning = true;
        this.ConnectionThreads = new ThreadGroup("Connection Thread Manager");
        System.out.println("Server is running");
    }

    public void run()
    {
        while(isRunning)
        {
            try {
                Socket temp = this.ss.accept();
                ClientManager t = new ClientManager(temp, this.con, this.ConnectionThreads);
                this.clients.add(t);
                this.con++;
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
