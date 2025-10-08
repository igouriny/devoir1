package modele.physique;

public abstract class ObjetPhysique {

    private Position position;

    public ObjetPhysique(Position position) {
        this.position = position;
    }

    public Position getPosition(){
        return position;
    }

}
