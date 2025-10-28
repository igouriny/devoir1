package modele.physique;

import java.util.Random;

public class Carte {

    public static final Position TAILLE = new Position(1920, 1080);
    public static final Random RANDOM = new Random();

    // Retourne une position aléatoire dans les limites de la carte
    public static Position randomPosition(){
        double x = RANDOM.nextDouble() * TAILLE.getPositionX();
        double y = RANDOM.nextDouble() * TAILLE.getPositionY();
        return new Position(x, y);
    }

    public static void ajustementPosition(Position position){
        double x = position.getPositionX();
        double y = position.getPositionY();

        if(x < 0) x += TAILLE.getPositionX();
        if(x > TAILLE.getPositionX()) x -= TAILLE.getPositionX();

        if (y < 0) y += TAILLE.getPositionY();
        if (y >= TAILLE.getPositionY()) y -= TAILLE.getPositionY();

        position.setPositionX(x);
        position.setPositionY(y);
    }

    // Test
    public static void main(String[] args) {
        Position position = randomPosition();
        System.out.println("Un point random: " + position);

        position.setPositionX(position.getPositionX() + TAILLE.getPositionX());
        position.setPositionY(position.getPositionY() + TAILLE.getPositionY());
        System.out.println("Point en dehors de la carte: " + position);

        ajustementPosition(position);
        System.out.println("Point après ajustement: " + position);
    }



}
