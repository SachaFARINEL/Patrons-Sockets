package socket.serveur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketFlotsServeur {

    public static void main(String[] args) {

        try (ServerSocket serveur = new ServerSocket(5000)) {
            boolean fini = false;
            while (!fini) {
                Socket socket = serveur.accept();
// attente active d’un client
// requête
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Object obj = null;
                try {
                    obj = ois.readObject();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                System.out.println("le serveur a reçu : " + obj);
// réponse
                ObjectOutputStream oos = null;
                try {
                    oos = new ObjectOutputStream(socket.getOutputStream());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                fini = (((int) (Math.random() * 5)) == 0);
                try {
                    oos.writeObject(obj.toString() + fini);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("fermeture du serveur");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SocketFlotsServeur() throws IOException {
    }
}
