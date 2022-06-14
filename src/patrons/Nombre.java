package patrons;

public class Nombre extends Algebre {

    private final int n;

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
