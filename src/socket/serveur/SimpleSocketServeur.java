package socket.serveur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleSocketServeur {

    public static void main(String[] args) {
// l'instruction try (ressource) gère la fermeture de socket
        try (ServerSocket socketserver = new ServerSocket(2019)) {
            System.out.println("en attente");
            Socket socketduserveur = socketserver.accept();
            System.out.println("Un client connecté !");
            socketduserveur.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
