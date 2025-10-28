package modele.reseau;

import modele.communication.Message;
import modele.physique.ObjetMobile;
import modele.physique.Position;

import java.util.Random;

public class Cellulaire extends ObjetMobile implements UniteCellulaire {

    public static final int NON_CONNECTE = -1;
    public static final double PROB_APPELER = 0.05;
    public static final double PROB_ENVOI_MSG = 0.2;
    public static final double PROB_DECONNEXION = 0.1;

    private String numeroLocal;
    private int numeroConnexion = NON_CONNECTE;
    private String numeroConnecte = null;
    private Antenne antenneConnectee;
    private Random random;
    private GestionnaireReseau gestionnaireReseau;


    public Cellulaire(String numeroLocal, Position position, double vitesse, double deviation) {
        super(position, vitesse, deviation);
        gestionnaireReseau = GestionnaireReseau.getInstance();
        random = new Random();
    }

    public String getnumeroLocal() {
        return numeroLocal;
    }

    public int getnumeroConnexion() {
        return numeroConnexion;
    }

    public boolean estConnecte(){
        return numeroConnexion != NON_CONNECTE;
    }

    public boolean comparerNumero(String autreNumero) {
        return autreNumero.equals(this.numeroLocal);
    }

    @Override
    public String toString() {
        return "Cellulaire { numeroLocal=" + numeroLocal + ", position=" + getPosition() + " }";
    }

    @Override
    public int appeler(String numeroAppele, String numeroAppelant, Antenne antenneConnectee) {
        return 0;
    }

    @Override
    public Cellulaire repondre(String numeroAppele, String numeroAppelant, int numeroConnexion) {
        return null;
    }

    @Override
    public void finAppelLocal(String numeroAppele, int numeroConnexion) {

    }

    @Override
    public void finAppelDistant(String numeroAppele, int numeroConnexion) {

    }

    @Override
    public void envoyer(Message message, int numeroConnexion) {

    }

    @Override
    public void recevoir(Message message) {

    }
}
