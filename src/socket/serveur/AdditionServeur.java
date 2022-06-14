package socket.serveur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class AdditionServeur {

    public static void main(String[] args) {
        try (ServerSocket serveur = new ServerSocket(5000)) {
            Socket socket = serveur.accept();
// attente active d’un client
// requête
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Object obj = null;
            Object obj2 = null;

            try {
                obj = ois.readObject();
                obj2 = ois.readObject();

            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            System.out.println("le serveur a reçu : " + obj + " ainsi que " + obj2);
            int additionObj = ((int) obj) + ((int) obj2);
            System.out.println("L'addition des deux est égal à : " + additionObj);
//                System.out.println("Le serveur a fait l'addition : " + );
// réponse
            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(socket.getOutputStream());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                oos.writeObject(additionObj);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            System.out.println("fermeture du serveur");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
