package modele.physique;

import java.util.Random;

public class ObjetMobile extends ObjetPhysique{

    private double direction = 0.0;
    private double vitesse;
    private double deviation;
    private static final Random RANDOM = new Random();


    public ObjetMobile(Position position, double vitesse, double deviation) {
        super(position);
        this.vitesse = vitesse;
        this.deviation = deviation;
    }

    public void seDeplacer() {
        direction += RANDOM.nextGaussian() * deviation;

        double x = getPosition().getPositionX() + vitesse * Math.cos(direction);
        double y = getPosition().getPositionY() + vitesse * Math.sin(direction);

        getPosition().setPositionX(x);
        getPosition().setPositionY(y);

        Carte.ajustementPosition(getPosition());
    }


}
