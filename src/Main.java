import modele.physique.*;
import modele.physique.Carte;

public class Main {
    public static void main(String[] args) {
        //tester affichage point
        Position position = new Position(2,3);
        System.out.println(position);


        Carte carte = new Carte();
        Position posAlea = carte.genererPositionAlea();
        System.out.println(posAlea);
        posAlea.setX(2000);
        carte.ajusterPosition(posAlea);
        System.out.print(posAlea);


    }
}