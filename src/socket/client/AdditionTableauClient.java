package socket.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;


public class AdditionTableauClient {

    public static void main(String[] args) {
        System.out.println("début");
        try (Socket socket = new Socket(InetAddress.getLocalHost(), 2019)) {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
// envoi vers le serveur de cette «requête»
//            SortedSet<String> l = new TreeSet<String>();
            int[] tableauDeNombres = new int[2];
            tableauDeNombres[0] = 5;
            tableauDeNombres[1] = 13;
            oos.writeObject(tableauDeNombres);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("fin");
    }
}
