package patrons;

import java.util.ArrayList;
import java.util.List;

public abstract class Operateur extends Algebre {

    private final String representation;
    protected List<Algebre> arguments;

    public void accept(Visiteur visitor)
    { visitor.visit(this); }

    public Operateur(String operateur) {
        this.representation = operateur;
        this.arguments = new ArrayList<Algebre>();
    }

    public String getRepresentation() {
        return representation;
    }

    public boolean add(Algebre argument) {
        return this.arguments.add(argument);
    }

    @Override
    public String toString() {
        return "" + representation + arguments ;
    }
}
