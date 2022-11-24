import javax.xml.transform.Result;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ConnectionManager implements Runnable {
    private ServerSocket ss;
    public ArrayList<ClientManager> clients;
    private boolean isRunning;

    private int con = 0;

    public ConnectionManager(int port) throws IOException {
        this.clients = new ArrayList<>();
        this.ss = new ServerSocket(port);
        this.isRunning = true;
        System.out.println("Server is running");
    }

    @Override
    public void run()
    {
        while(isRunning)
        {
            try {
                Socket temp = this.ss.accept();
                ClientManager t = new ClientManager(temp, this.con);
                this.clients.add(t);
                this.con++;
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
