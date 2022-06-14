package socket.serveur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AdditionTableauServeur {
    public static void main(String[] args) {
// l'instruction try (ressource) gère la fermeture de socket
        try (ServerSocket socketserver = new ServerSocket(2019)) {
            System.out.println("en attente");
            Socket socketduserveur = socketserver.accept();
            System.out.println("Un client connecté !");
            ObjectInputStream ois = new ObjectInputStream(socketduserveur.getInputStream());
            int[] tableauDeNombres = new int[2];
            try {
                tableauDeNombres = (int[]) ois.readObject();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            int resultatAddition = tableauDeNombres[0] + tableauDeNombres[1];
            System.out.println("le serveur a fait l'addition, le résultat est : " + resultatAddition);

            socketduserveur.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
