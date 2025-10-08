package modele.physique;

import java.util.Random;

public class ObjetMobile extends ObjetPhysique {

    private double direction = 0; //en radians
    private int vitesse;
    private double deviationStandard;
//    Carte carte = new Carte();

    private static Random random = new Random();

    public ObjetMobile(Position position, int vitesse, double deviationStandard) {
        super(position);
        this.vitesse = vitesse;
        this.deviationStandard = deviationStandard;
    }

    public void seDeplacer(double direction, double deviationStandard){

        double gaussienne = random.nextGaussian();
        direction = direction + gaussienne * deviationStandard;
        double positionX = getPosition().getX() + vitesse * Math.cos(direction);
        double positionY = getPosition().getY() + vitesse * Math.sin(direction);

        Position position = new Position(positionX,positionY);
        getPosition().setX(positionX);
        getPosition().setY(positionY);

        Carte.ajusterPosition(position);
    }

    @Override
    public String toString(){
        return String.format("(%.2f,%.2f)", getPosition().getX(), getPosition().getY());
    }


}
