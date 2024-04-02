import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public void run() throws UnknownHostException, IOException{
        int port = 8010;
        InetAddress address = InetAddress.getByName("localhost");
        Socket socket = new Socket(address,port);
        PrintWriter toscoket = new PrintWriter(socket.getOutputStream());
        BufferedReader fromscoket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        toscoket.println("Hello from the cilent");
        String line = fromscoket.readLine();
        System.out.println("Response from the socket is"+ " " +line);
        toscoket.close();
        fromscoket.close();
        socket.close();
    }

    public static void main(String[] args){
        try{
            Client client = new Client();
            client.run();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
