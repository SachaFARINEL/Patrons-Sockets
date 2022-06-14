package patrons;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Expression {

    public static final int NB_NOMBRES = 30;
    public static final int NB_OPERATEURS = 10;

    private static Expression instance = null;
    private final Algebre expressionUnique;

    public static Expression getInstance() {
        if (instance == null) {
            instance = new Expression();
        }
        return instance;
    }

    public Expression() {
        super();
        List<Operateur> operateurs = new ArrayList<Operateur>();
        operateurs.add(new Addition());
        for (int i = 0; i < NB_OPERATEURS - 1; i++) {
            int n = (int) (Math.random() * 2);
            if (n == 1) {
                operateurs.add(new Addition());
            } else {
                operateurs.add(new Multiplication());
            }
        }

        for (int i = 0; i < NB_NOMBRES; i++) {
            // générer un nombre entre 1 et 5
            int n = ((int) (Math.random() * 5)) + 1;
            // tirer un opérateur entre 0 et 9 et lui ajouter le nombre
            int nOp = ((int) (Math.random() * 10));
            operateurs.get(nOp).add(new Nombre(n));
        }
        // imbriquer les opérateurs entre eux...
        for (int i = NB_OPERATEURS - 1; i > 0; i--) {
            int n = ((int) (Math.random() * i));
            operateurs.get(n).add(operateurs.get(i));
        }
        this.expressionUnique = operateurs.get(0);
    }

    private Algebre getExpressionUnique() {
        return expressionUnique;
    }

    private static void premierTest() {
        Nombre n3 = new Nombre(3);
        Nombre n6 = new Nombre(6);
        Nombre n1 = new Nombre(1);
        Nombre n2 = new Nombre(2);
        Operateur p1 = new Addition();
        Operateur p2 = new Addition();
        Operateur f3 = new Multiplication();
        f3.add(n6);
        f3.add(n1);
        p2.add(f3);
        p2.add(n2);
        p1.add(n3);
        p1.add(p2);
        System.out.println(p1.interpret());
    }

    public static void main(String[] args) {
//        premierTest();
        System.out.println(Expression.getInstance().getExpressionUnique() + " = " + Expression.getInstance().getExpressionUnique().interpret());
//        Visiteur visit = new Visiteur();
//        visit.visit((Operateur) Expression.getInstance().getExpressionUnique());
    }

}
