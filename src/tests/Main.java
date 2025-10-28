package tests;

import modele.communication.Connexion;
import modele.physique.Carte;
import modele.physique.Position;
import modele.reseau.Antenne;
import modele.reseau.GestionnaireReseau;
import tests.modele.physique.ObjetMobileTest;

public class Main {
    public static void main(String[] args) {
        boolean valide = true;

        valide = testerPosition();
        valide = testerCarte();
        valide = testerObjetMobile();
        valide = testerReseauListeConnexions();

        if (valide) {
            System.out.println("Les tests passent");
        } else {
            System.out.println("Les tests échouent");
        }
    }

    public static boolean testerPosition() {
        System.out.println("--- Test Position ---");
        boolean valide = true;

        Position position = new Position(2.9, 4.5);
        System.out.println(position);

        return valide;
    }

    // Ce test assume que la largeur de la carte est de 1920
    public static boolean testerCarte() {
        System.out.println("--- Test Carte ---");
        boolean valide = true;

        Position position = Carte.genererPositionAlea();
        System.out.println(position);

        position.setX(2000);
        Carte.ajusterPosition(position);
        System.out.println(position);

        if (position.getX() > 1920 || position.getX() < 0) valide = false;

        return valide;
    }

    public static boolean testerObjetMobile() {
        System.out.println("--- Test ObjetMobile ---");
        boolean valide = true;

        ObjetMobileTest objetMobileTest = new ObjetMobileTest(
                new Position(2, 5),
                2,
                2.0
        );

        Position positionInitial;
        Position positionFinal;

        positionInitial = objetMobileTest.getPosition();
        System.out.println(objetMobileTest.getPosition());

        objetMobileTest.seDeplacer();

        positionFinal = objetMobileTest.getPosition();
        System.out.println(objetMobileTest.getPosition());

        if (!positionInitial.equals(positionFinal)) valide = false;

        return valide;
    }

    public static boolean testerReseauListeConnexions() {
        System.out.println("--- Test ReseauListeConnexions ---");
        boolean valide = true;

        return valide;
    }
}
