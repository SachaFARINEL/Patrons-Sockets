package patrons;

public class Multiplication extends Operateur {

    public Multiplication() {
        super("x");
    }

    @Override
    public long interpret() {
        int produit = 1;
        for (Algebre arg : arguments) {
            produit *= arg.interpret();
        }
        return produit;
    }


}
