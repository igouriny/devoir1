package modele.physique;

public class Position {

    private double positionX;
    private double positionY;

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public Position(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public double distanceEntre(Position other) {
        double dx = this.positionX - other.positionX;
        double dy = this.positionY - other.positionY;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "Position { x=" + positionX + ", y=" + positionY + " }";
    }

    // Test
    public static void main(String[] args) {
        Position p = new Position(3.0, 4.0);
        System.out.println(p);
    }

}
