package modele.physique;
import modele.physique.*;

import java.util.Random;

import static java.lang.Math.abs;

public class Carte {

    private static final Position TAILLE = new Position(1920,1080);
    private static final Random rand = new Random();

    public Position genererPositionAlea(){
        double randX = rand.nextDouble();
        double randY = rand.nextDouble();

        return new Position(randX, randY);
    }

    public Position ajusterPosition(Position position){
        if (position.getX() > 1920){
            position.setX((position.getX() + 1920) % 1920);
        } else {
            position.getX();
        }
        if (position.getY() > 1080){
            position.setY((position.getY() + 1080) % 1080);

        } else {
            position.getY();
        }

        return position;
    }


}
