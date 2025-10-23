import modele.reseau.Reseau;
import vue.CadrePrincipal;

public class Main {
    public static void main(String[] args) {
        Thread t2 = new Thread(Reseau.getInstance());
        t2.start();

        Thread t = new Thread(new CadrePrincipal());
        t.start();



    }
}