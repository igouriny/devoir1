package modele.physique;

public class TestMobile extends ObjetMobile{

    public TestMobile(Position position, double vitesse, double deviation) {
        super(position, vitesse, deviation);
    }

    public static void main(String[] args) {
        TestMobile testMobile = new TestMobile(new Position(100, 100), 10, 0.2);
        System.out.println("Position initiale: " + testMobile.getPosition());
        for (int i = 0; i < 5; i++){
            testMobile.seDeplacer();
            System.out.println("Après déplacement " + (i+1) + ": " + testMobile.getPosition());
        }
    }
}
