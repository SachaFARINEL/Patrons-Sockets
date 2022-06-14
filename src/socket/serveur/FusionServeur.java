package socket.serveur;

public class FusionServeur {

    public static int[] fusionne(int[] liste1, int[] liste2) {

        int[] listeFusionnee = new int[liste1.length + liste2.length];
        int indiceListeFusionnee = 0;
        int indiceListe1 = 0;
        int indiceListe2 = 0;

        while (indiceListe1 < liste1.length && indiceListe2 < liste2.length) {
            if (liste1[indiceListe1] < liste2[indiceListe2]) {
                listeFusionnee[indiceListeFusionnee++] = liste1[indiceListe1++];
            } else {
                listeFusionnee[indiceListeFusionnee++] = liste2[indiceListe2++];
            }
        }

        while (indiceListe1 < liste1.length) {
            listeFusionnee[indiceListeFusionnee++] = liste1[indiceListe1++];
        }
        while (indiceListe2 < liste2.length) {
            listeFusionnee[indiceListeFusionnee++] = liste2[indiceListe2++];
        }
        return listeFusionnee;
    }
}
