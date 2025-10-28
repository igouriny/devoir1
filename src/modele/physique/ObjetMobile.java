package modele.physique;

import java.util.Random;

public abstract class ObjetMobile extends ObjetPhysique {
    private double direction;
    private int vitesse;
    private double deviationStandard;

    private Random random = new Random();

    public ObjetMobile(Position position, int vitesse, double deviationStandard) {
        super(position);
        this.vitesse = vitesse;
        this.deviationStandard = deviationStandard;
    }

    public void seDeplacer() {
        direction = direction + random.nextGaussian() * deviationStandard;
        getPosition().setX(getPosition().getX() + vitesse * Math.cos(direction));
        getPosition().setY(getPosition().getY() + vitesse * Math.sin(direction));
        Carte.ajusterPosition(getPosition());
    }
}
