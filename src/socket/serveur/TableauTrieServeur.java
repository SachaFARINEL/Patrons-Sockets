package socket.serveur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class TableauTrieServeur {

    public static void main(String[] args) {

        try (ServerSocket socketserver = new ServerSocket(2019)) {
            System.out.println("en attente");
            Socket socketduserveur = socketserver.accept();
            System.out.println("Un client connecté !");
            ObjectInputStream ois = new ObjectInputStream(socketduserveur.getInputStream());
            int[] tableauDeNombres = new int[5];
            int[] tableauDeNombres2 = new int[5];
            try {
                tableauDeNombres = (int[]) ois.readObject();
                tableauDeNombres2 = (int[]) ois.readObject();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }

            int[] concate = FusionServeur.fusionne(tableauDeNombres, tableauDeNombres2);
            Arrays.sort(concate);
            System.out.println("le serveur a fait la concaténation, le résultat est : " + Arrays.toString(concate));
            socketduserveur.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
