package patrons;

public class Visiteur {

    public void visit(Nombre visitor) {
        System.out.println("Visiting un nombre");
    }

    public void visit(Operateur visitor) {
        System.out.println("Visiting un opérateur");
    }

}
