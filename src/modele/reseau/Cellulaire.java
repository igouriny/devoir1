package modele.reseau;

import modele.physique.ObjetMobile;
import modele.physique.Position;

import java.util.Random;

public class Cellulaire extends ObjetMobile {
    private final int NON_CONNECTE = -1;
    private final double PROB_APPELER = 0.05;
    private final double PROB_ENVOI_MSG = 0.2;
    private final double PROB_DECONNEXION = 0.1;

    private String numeroLocal;
    private int numeroConnexion = NON_CONNECTE;
    private String numeroConnecte = null;
    private Antenne antenneConnecte;

    private Random random = new Random();
    private GestionnaireReseau gestionnaireReseau = GestionnaireReseau.getInstance();

    public Cellulaire(Position position, int vitesse, double deviationStandard, String numeroLocal) {
        super(position, vitesse, deviationStandard);
        this.numeroLocal = numeroLocal;
    }

    public String getNumeroLocal() {
        return numeroLocal;
    }

    public int getNumeroConnexion() {
        return numeroConnexion;
    }

    public boolean estConnecte() {
        return numeroConnexion != NON_CONNECTE;
    }

    public void effectuerTour() {
        System.out.println("tour effectuer");
    }

    public boolean comparerNumero(String numero) {
        return numeroLocal.equals(numero);
    }

    public String toString() {
        return String.format("%s, %s", numeroLocal, getPosition());
    }
}
