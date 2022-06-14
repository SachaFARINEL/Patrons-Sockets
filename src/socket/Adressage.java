package socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Adressage {

    private static void testIP() {
        InetAddress localeAdresse;
        InetAddress serveurAdresse;
        try {
            localeAdresse = InetAddress.getLocalHost();
            System.out.println("locale = " + localeAdresse);
            serveurAdresse = InetAddress.getByName("www.openclassrooms.com");
            System.out.println("oc = " + serveurAdresse);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        testIP();

    }

}
