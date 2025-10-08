import modele.physique.*;
import modele.physique.Carte;

public class Main {
    public static void main(String[] args) {
        //tester affichage point
        Position position = new Position(2,3);
        System.out.println(position);


        //tester modification de point
        Carte carte = new Carte();
//        Position posAlea = carte.genererPositionAlea();
//        System.out.println(posAlea);
//        posAlea.setX(2000);
//        carte.ajusterPosition(posAlea);
//        System.out.println(posAlea);

        //tester ajustement position
        ObjetMobile objetMobile = new ObjetMobile(new Position(0,0),10, 2);
        System.out.println(objetMobile);

        objetMobile.seDeplacer(40,2);
        System.out.println(objetMobile.getPosition());



    }
}