package socket.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.SortedSet;
import java.util.TreeSet;

public class AdditionClient {

    public static void main(String[] args) {
        try (Socket socket = new Socket(InetAddress.getLocalHost(), 5000)) {
// ouverture d'une connexion TCP
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
// envoi vers le serveur de cette «requête»

            int randomNumber1 = (int) (Math.random() * 25);
            int randomNumber2 = (int) (Math.random() * 25);

            oos.writeObject(randomNumber1);
            oos.writeObject(randomNumber2);

// lecture de la réponse retournée
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            System.out.println("le serveur retourne : " + ois.readObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
