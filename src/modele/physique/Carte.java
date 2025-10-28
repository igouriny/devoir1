package modele.physique;

import java.util.Random;

public final class Carte {
    public static final double LARGEUR = 1920.0;
    public static final double HAUTEUR = 1080.0;

    private static final Random R = new Random();

    private Carte() {}

    public static Position genererPositionAlea() {
        return new Position(R.nextDouble() * LARGEUR, R.nextDouble() * HAUTEUR);
    }

    public static void ajusterPosition(Position p) {
        double x = p.getX();
        double y = p.getY();

        x = (x % LARGEUR + LARGEUR) % LARGEUR;
        y = (y % HAUTEUR + HAUTEUR) % HAUTEUR;

        p.setX(x);
        p.setY(y);
    }
}
