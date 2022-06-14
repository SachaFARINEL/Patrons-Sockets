package patrons;

public class Addition extends Operateur {

    public Addition() {
        super("+");
    }

    @Override
    public long interpret() {
        int somme = 0;
        for (Algebre arg : arguments) {
            somme += arg.interpret();
        }
        return somme;
    }

}
