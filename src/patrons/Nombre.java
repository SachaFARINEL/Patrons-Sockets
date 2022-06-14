package patrons;

public class Nombre extends Algebre {

    private final int n;

    public void accept(Visiteur visitor) {
        visitor.visit(this);
    }

    public Nombre(int n) {
        this.n = n;
    }

    @Override
    public long interpret() {
        return n;
    }

    @Override
    public String toString() {
        return "" + n;
    }

}
