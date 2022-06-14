package socket.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;

public class TableauTrieClient {

    public static void main(String[] args) {
        System.out.println("début");
        try (Socket socket = new Socket(InetAddress.getLocalHost(), 2019)) {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
// envoi vers le serveur de cette «requête»
//            SortedSet<String> l = new TreeSet<String>();

            int[] tableauDeNombres = new int[5];
            int[] tableauDeNombres2 = new int[5];
            for (int i = 0; i < tableauDeNombres.length; i++) {
                tableauDeNombres[i] = (int) (Math.random() * 50);
                tableauDeNombres2[i] = (int) (Math.random() * 50);
            }

            Arrays.sort(tableauDeNombres);
            Arrays.sort(tableauDeNombres2);
            oos.writeObject(tableauDeNombres);
            oos.writeObject(tableauDeNombres2);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("fin");
    }
}

