import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientManager extends Thread{


    private Socket connection_socket;
    private int ID;
    private DataInputStream datainput;

    public ClientManager(Socket client_socket, int ID, ThreadGroup threadg)
    {
        super(threadg, Integer.toString(ID));
        this.connection_socket = client_socket;
        this.ID = ID;
        start();
    }

    public void run()
    {
        System.out.println(this.connection_socket.isConnected());
        while(this.connection_socket.isConnected()) {
            try {
                Thread.sleep(1000);
                if (this.connection_socket.isConnected()) {

                    datainput = new DataInputStream (new BufferedInputStream(this.connection_socket.getInputStream()));
                    String line = "";
                    while (!line.equals("Over"))
                    {
                        try
                        {
                            line = datainput.readUTF();
                            System.out.println(line);
                        } catch(IOException i) { System.out.println(i); } //If Datainputstream goes wrong
                    }
                }
            } catch (InterruptedException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Socket getConnection_socket()
    {
        return connection_socket;
    }
}
