package modele.physique;

public class Position {

    private double x;
    private double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distance (Position autre){
        double dx = this.x + autre.x;
        double dy = this.y + autre.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString(){
        return String.format("(%.2f,%.2f)", getX(), getY());
    }
}
