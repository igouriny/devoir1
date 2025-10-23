package modele.physique;

import java.util.Random;

public class ObjetMobile extends ObjetPhysique {

    private double direction = 0; //en radians
    private double vitesse;
    private double deviationStandard;
//    Carte carte = new Carte();

    private static Random random = new Random();

    public ObjetMobile(Position position, double vitesse, double deviationStandard) {
        super(position);
        this.vitesse = vitesse;
        this.deviationStandard = deviationStandard;
    }

    public void seDeplacer() {

        // variation de direction aléatoire
        double gaussienne = random.nextGaussian();
        direction += gaussienne * deviationStandard;

        // calcul du déplacement
        double dx = vitesse * Math.cos(direction);
        double dy = vitesse * Math.sin(direction);

        // mise à jour de la position
        double nouvelleX = getPosition().getX() + dx;
        double nouvelleY = getPosition().getY() + dy;

        getPosition().setX(nouvelleX);
        getPosition().setY(nouvelleY);

        // carte toroïdale : on ajuste si on sort des bornes
        Carte.ajusterPosition(getPosition());
    }

    @Override
    public String toString(){
        return String.format("(%.2f,%.2f)", getPosition().getX(), getPosition().getY());
    }


}
