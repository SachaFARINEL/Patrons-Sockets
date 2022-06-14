package socket.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class SimpleSocketClient {

    public static void main(String[] args) {
        System.out.println("début");
        try (Socket socket = new Socket(InetAddress.getLocalHost(), 2019)) {
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("fin");
    }

}
